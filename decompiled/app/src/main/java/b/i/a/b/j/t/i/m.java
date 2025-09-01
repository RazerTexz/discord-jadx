package b.i.a.b.j.t.i;

import android.database.sqlite.SQLiteDatabase;
import b.i.a.b.Encoding2;
import b.i.a.b.j.t.i.t;

/* compiled from: SQLiteEventStore.java */
/* loaded from: classes3.dex */
public final /* synthetic */ class m implements t.d {
    public final SQLiteDatabase a;

    public m(SQLiteDatabase sQLiteDatabase) {
        this.a = sQLiteDatabase;
    }

    @Override // b.i.a.b.j.t.i.t.d
    public Object a() {
        SQLiteDatabase sQLiteDatabase = this.a;
        Encoding2 encoding2 = t.j;
        sQLiteDatabase.beginTransaction();
        return null;
    }
}
