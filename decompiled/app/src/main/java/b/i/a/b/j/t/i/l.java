package b.i.a.b.j.t.i;

import android.database.Cursor;
import b.i.a.b.Encoding2;
import b.i.a.b.j.t.i.t;
import java.util.ArrayList;

/* compiled from: SQLiteEventStore.java */
/* loaded from: classes3.dex */
public final /* synthetic */ class l implements t.b {
    public static final l a = new l();

    @Override // b.i.a.b.j.t.i.t.b
    public Object apply(Object obj) {
        Cursor cursor = (Cursor) obj;
        Encoding2 encoding2 = t.j;
        ArrayList arrayList = new ArrayList();
        int length = 0;
        while (cursor.moveToNext()) {
            byte[] blob = cursor.getBlob(0);
            arrayList.add(blob);
            length += blob.length;
        }
        byte[] bArr = new byte[length];
        int length2 = 0;
        for (int i = 0; i < arrayList.size(); i++) {
            byte[] bArr2 = (byte[]) arrayList.get(i);
            System.arraycopy(bArr2, 0, bArr, length2, bArr2.length);
            length2 += bArr2.length;
        }
        return bArr;
    }
}
