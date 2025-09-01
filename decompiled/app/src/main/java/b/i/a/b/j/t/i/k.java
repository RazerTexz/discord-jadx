package b.i.a.b.j.t.i;

import android.database.Cursor;
import b.i.a.b.Encoding2;
import b.i.a.b.j.AutoValue_EventInternal;
import b.i.a.b.j.EncodedPayload;
import b.i.a.b.j.TransportContext;
import b.i.a.b.j.t.i.t;
import java.util.HashMap;
import java.util.List;

/* compiled from: SQLiteEventStore.java */
/* loaded from: classes3.dex */
public final /* synthetic */ class k implements t.b {
    public final t a;

    /* renamed from: b, reason: collision with root package name */
    public final List f800b;
    public final TransportContext c;

    public k(t tVar, List list, TransportContext transportContext) {
        this.a = tVar;
        this.f800b = list;
        this.c = transportContext;
    }

    @Override // b.i.a.b.j.t.i.t.b
    public Object apply(Object obj) {
        t tVar = this.a;
        List list = this.f800b;
        TransportContext transportContext = this.c;
        Cursor cursor = (Cursor) obj;
        Encoding2 encoding2 = t.j;
        while (cursor.moveToNext()) {
            long j = cursor.getLong(0);
            boolean z2 = cursor.getInt(7) != 0;
            AutoValue_EventInternal.b bVar = new AutoValue_EventInternal.b();
            bVar.f = new HashMap();
            bVar.f(cursor.getString(1));
            bVar.e(cursor.getLong(2));
            bVar.g(cursor.getLong(3));
            if (z2) {
                String string = cursor.getString(4);
                bVar.d(new EncodedPayload(string == null ? t.j : new Encoding2(string), cursor.getBlob(5)));
            } else {
                String string2 = cursor.getString(4);
                bVar.d(new EncodedPayload(string2 == null ? t.j : new Encoding2(string2), (byte[]) t.n(tVar.b().query("event_payloads", new String[]{"bytes"}, "event_id = ?", new String[]{String.valueOf(j)}, null, null, "sequence_num"), l.a)));
            }
            if (!cursor.isNull(6)) {
                bVar.f762b = Integer.valueOf(cursor.getInt(6));
            }
            list.add(new AutoValue_PersistedEvent(j, transportContext, bVar.b()));
        }
        return null;
    }
}
