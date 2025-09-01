package b.i.a.c.u2;

import android.database.sqlite.SQLiteDatabase;

/* compiled from: DatabaseProvider.java */
/* renamed from: b.i.a.c.u2.a, reason: use source file name */
/* loaded from: classes3.dex */
public interface DatabaseProvider {
    SQLiteDatabase getReadableDatabase();

    SQLiteDatabase getWritableDatabase();
}
