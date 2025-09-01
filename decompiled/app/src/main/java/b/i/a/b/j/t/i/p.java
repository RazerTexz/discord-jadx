package b.i.a.b.j.t.i;

import android.database.Cursor;
import android.util.Base64;
import b.i.a.b.Encoding2;
import b.i.a.b.j.AutoValue_TransportContext;
import b.i.a.b.j.TransportContext;
import b.i.a.b.j.t.i.t;
import b.i.a.b.j.w.PriorityMapping;
import java.util.ArrayList;

/* compiled from: SQLiteEventStore.java */
/* loaded from: classes3.dex */
public final /* synthetic */ class p implements t.b {
    public static final p a = new p();

    @Override // b.i.a.b.j.t.i.t.b
    public Object apply(Object obj) {
        Cursor cursor = (Cursor) obj;
        Encoding2 encoding2 = t.j;
        ArrayList arrayList = new ArrayList();
        while (cursor.moveToNext()) {
            TransportContext.a aVarA = TransportContext.a();
            aVarA.b(cursor.getString(1));
            aVarA.c(PriorityMapping.b(cursor.getInt(2)));
            String string = cursor.getString(3);
            AutoValue_TransportContext.b bVar = (AutoValue_TransportContext.b) aVarA;
            bVar.f764b = string == null ? null : Base64.decode(string, 0);
            arrayList.add(bVar.a());
        }
        return arrayList;
    }
}
