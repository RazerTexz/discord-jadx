package b.i.a.b.j.t.i;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import b.i.a.b.Encoding2;
import b.i.a.b.j.TransportContext;
import b.i.a.b.j.t.i.t;
import b.i.a.b.j.w.PriorityMapping;

/* compiled from: SQLiteEventStore.java */
/* loaded from: classes3.dex */
public final /* synthetic */ class i implements t.b {
    public final long a;

    /* renamed from: b, reason: collision with root package name */
    public final TransportContext f798b;

    public i(long j, TransportContext transportContext) {
        this.a = j;
        this.f798b = transportContext;
    }

    @Override // b.i.a.b.j.t.i.t.b
    public Object apply(Object obj) {
        long j = this.a;
        TransportContext transportContext = this.f798b;
        SQLiteDatabase sQLiteDatabase = (SQLiteDatabase) obj;
        Encoding2 encoding2 = t.j;
        ContentValues contentValues = new ContentValues();
        contentValues.put("next_request_ms", Long.valueOf(j));
        if (sQLiteDatabase.update("transport_contexts", contentValues, "backend_name = ? and priority = ?", new String[]{transportContext.b(), String.valueOf(PriorityMapping.a(transportContext.d()))}) < 1) {
            contentValues.put("backend_name", transportContext.b());
            contentValues.put("priority", Integer.valueOf(PriorityMapping.a(transportContext.d())));
            sQLiteDatabase.insert("transport_contexts", null, contentValues);
        }
        return null;
    }
}
