package b.i.a.b.j.t.i;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabaseLockedException;
import android.os.SystemClock;
import android.util.Base64;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.annotation.WorkerThread;
import b.c.a.a0.AnimatableValueParser;
import b.d.b.a.outline;
import b.i.a.b.Encoding2;
import b.i.a.b.j.EventInternal;
import b.i.a.b.j.TransportContext;
import b.i.a.b.j.u.SynchronizationGuard;
import b.i.a.b.j.v.Clock3;
import b.i.a.b.j.w.PriorityMapping;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* compiled from: SQLiteEventStore.java */
@WorkerThread
/* loaded from: classes3.dex */
public class t implements EventStore, SynchronizationGuard {
    public static final Encoding2 j = new Encoding2("proto");
    public final SchemaManager5 k;
    public final Clock3 l;
    public final Clock3 m;
    public final EventStoreConfig n;

    /* compiled from: SQLiteEventStore.java */
    public interface b<T, U> {
        U apply(T t);
    }

    /* compiled from: SQLiteEventStore.java */
    public static class c {
        public final String a;

        /* renamed from: b, reason: collision with root package name */
        public final String f802b;

        public c(String str, String str2, a aVar) {
            this.a = str;
            this.f802b = str2;
        }
    }

    /* compiled from: SQLiteEventStore.java */
    public interface d<T> {
        T a();
    }

    public t(Clock3 clock3, Clock3 clock32, EventStoreConfig eventStoreConfig, SchemaManager5 schemaManager5) {
        this.k = schemaManager5;
        this.l = clock3;
        this.m = clock32;
        this.n = eventStoreConfig;
    }

    public static String f(Iterable<PersistedEvent> iterable) {
        StringBuilder sb = new StringBuilder("(");
        Iterator<PersistedEvent> it = iterable.iterator();
        while (it.hasNext()) {
            sb.append(it.next().b());
            if (it.hasNext()) {
                sb.append(',');
            }
        }
        sb.append(')');
        return sb.toString();
    }

    public static <T> T n(Cursor cursor, b<Cursor, T> bVar) {
        try {
            return bVar.apply(cursor);
        } finally {
            cursor.close();
        }
    }

    @Override // b.i.a.b.j.u.SynchronizationGuard
    public <T> T a(SynchronizationGuard.a<T> aVar) {
        SQLiteDatabase sQLiteDatabaseB = b();
        e(new m(sQLiteDatabaseB), n.a);
        try {
            T tExecute = aVar.execute();
            sQLiteDatabaseB.setTransactionSuccessful();
            return tExecute;
        } finally {
            sQLiteDatabaseB.endTransaction();
        }
    }

    @Override // b.i.a.b.j.t.i.EventStore
    @Nullable
    public PersistedEvent a0(TransportContext transportContext, EventInternal eventInternal) {
        AnimatableValueParser.Y("SQLiteEventStore", "Storing event with priority=%s, name=%s for destination %s", transportContext.d(), eventInternal.g(), transportContext.b());
        long jLongValue = ((Long) d(new s(this, transportContext, eventInternal))).longValue();
        if (jLongValue < 1) {
            return null;
        }
        return new AutoValue_PersistedEvent(jLongValue, transportContext, eventInternal);
    }

    @VisibleForTesting
    public SQLiteDatabase b() {
        SchemaManager5 schemaManager5 = this.k;
        schemaManager5.getClass();
        return (SQLiteDatabase) e(new o(schemaManager5), r.a);
    }

    @Nullable
    public final Long c(SQLiteDatabase sQLiteDatabase, TransportContext transportContext) {
        StringBuilder sb = new StringBuilder("backend_name = ? and priority = ?");
        ArrayList arrayList = new ArrayList(Arrays.asList(transportContext.b(), String.valueOf(PriorityMapping.a(transportContext.d()))));
        if (transportContext.c() != null) {
            sb.append(" and extras = ?");
            arrayList.add(Base64.encodeToString(transportContext.c(), 0));
        }
        Cursor cursorQuery = sQLiteDatabase.query("transport_contexts", new String[]{"_id"}, sb.toString(), (String[]) arrayList.toArray(new String[0]), null, null, null);
        try {
            return !cursorQuery.moveToNext() ? null : Long.valueOf(cursorQuery.getLong(0));
        } finally {
            cursorQuery.close();
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.k.close();
    }

    public final <T> T d(b<SQLiteDatabase, T> bVar) {
        SQLiteDatabase sQLiteDatabaseB = b();
        sQLiteDatabaseB.beginTransaction();
        try {
            T tApply = bVar.apply(sQLiteDatabaseB);
            sQLiteDatabaseB.setTransactionSuccessful();
            return tApply;
        } finally {
            sQLiteDatabaseB.endTransaction();
        }
    }

    public final <T> T e(d<T> dVar, b<Throwable, T> bVar) {
        long jA = this.m.a();
        while (true) {
            try {
                return dVar.a();
            } catch (SQLiteDatabaseLockedException e) {
                if (this.m.a() >= this.n.a() + jA) {
                    return bVar.apply(e);
                }
                SystemClock.sleep(50L);
            }
        }
    }

    @Override // b.i.a.b.j.t.i.EventStore
    public long h0(TransportContext transportContext) {
        Cursor cursorRawQuery = b().rawQuery("SELECT next_request_ms FROM transport_contexts WHERE backend_name = ? and priority = ?", new String[]{transportContext.b(), String.valueOf(PriorityMapping.a(transportContext.d()))});
        try {
            Long lValueOf = cursorRawQuery.moveToNext() ? Long.valueOf(cursorRawQuery.getLong(0)) : 0L;
            cursorRawQuery.close();
            return lValueOf.longValue();
        } catch (Throwable th) {
            cursorRawQuery.close();
            throw th;
        }
    }

    @Override // b.i.a.b.j.t.i.EventStore
    public int l() {
        long jA = this.l.a() - this.n.b();
        SQLiteDatabase sQLiteDatabaseB = b();
        sQLiteDatabaseB.beginTransaction();
        try {
            Integer numValueOf = Integer.valueOf(sQLiteDatabaseB.delete("events", "timestamp_ms < ?", new String[]{String.valueOf(jA)}));
            sQLiteDatabaseB.setTransactionSuccessful();
            sQLiteDatabaseB.endTransaction();
            return numValueOf.intValue();
        } catch (Throwable th) {
            sQLiteDatabaseB.endTransaction();
            throw th;
        }
    }

    @Override // b.i.a.b.j.t.i.EventStore
    public boolean l0(TransportContext transportContext) {
        SQLiteDatabase sQLiteDatabaseB = b();
        sQLiteDatabaseB.beginTransaction();
        try {
            Long lC = c(sQLiteDatabaseB, transportContext);
            Boolean bool = lC == null ? Boolean.FALSE : (Boolean) n(b().rawQuery("SELECT 1 FROM events WHERE context_id = ? LIMIT 1", new String[]{lC.toString()}), q.a);
            sQLiteDatabaseB.setTransactionSuccessful();
            sQLiteDatabaseB.endTransaction();
            return bool.booleanValue();
        } catch (Throwable th) {
            sQLiteDatabaseB.endTransaction();
            throw th;
        }
    }

    @Override // b.i.a.b.j.t.i.EventStore
    public void m(Iterable<PersistedEvent> iterable) {
        if (iterable.iterator().hasNext()) {
            StringBuilder sbU = outline.U("DELETE FROM events WHERE _id in ");
            sbU.append(f(iterable));
            b().compileStatement(sbU.toString()).execute();
        }
    }

    @Override // b.i.a.b.j.t.i.EventStore
    public void n0(Iterable<PersistedEvent> iterable) {
        if (iterable.iterator().hasNext()) {
            StringBuilder sbU = outline.U("UPDATE events SET num_attempts = num_attempts + 1 WHERE _id in ");
            sbU.append(f(iterable));
            String string = sbU.toString();
            SQLiteDatabase sQLiteDatabaseB = b();
            sQLiteDatabaseB.beginTransaction();
            try {
                sQLiteDatabaseB.compileStatement(string).execute();
                sQLiteDatabaseB.compileStatement("DELETE FROM events WHERE num_attempts >= 16").execute();
                sQLiteDatabaseB.setTransactionSuccessful();
            } finally {
                sQLiteDatabaseB.endTransaction();
            }
        }
    }

    @Override // b.i.a.b.j.t.i.EventStore
    public Iterable<PersistedEvent> r(TransportContext transportContext) {
        return (Iterable) d(new j(this, transportContext));
    }

    @Override // b.i.a.b.j.t.i.EventStore
    public void v(TransportContext transportContext, long j2) {
        d(new i(j2, transportContext));
    }

    @Override // b.i.a.b.j.t.i.EventStore
    public Iterable<TransportContext> z() {
        SQLiteDatabase sQLiteDatabaseB = b();
        sQLiteDatabaseB.beginTransaction();
        try {
            List list = (List) n(sQLiteDatabaseB.rawQuery("SELECT distinct t._id, t.backend_name, t.priority, t.extras FROM transport_contexts AS t, events AS e WHERE e.context_id = t._id", new String[0]), p.a);
            sQLiteDatabaseB.setTransactionSuccessful();
            return list;
        } finally {
            sQLiteDatabaseB.endTransaction();
        }
    }
}
