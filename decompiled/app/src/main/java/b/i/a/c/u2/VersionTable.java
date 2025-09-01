package b.i.a.c.u2;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import b.i.a.c.ExoPlayerLibraryInfo;
import b.i.a.c.f3.Util2;
import com.google.android.exoplayer2.database.DatabaseIOException;

/* compiled from: VersionTable.java */
/* renamed from: b.i.a.c.u2.d, reason: use source file name */
/* loaded from: classes3.dex */
public final class VersionTable {
    public static final /* synthetic */ int a = 0;

    static {
        ExoPlayerLibraryInfo.a("goog.exo.database");
    }

    public static int a(SQLiteDatabase sQLiteDatabase, int i, String str) throws DatabaseIOException {
        try {
            if (!Util2.J(sQLiteDatabase, "ExoPlayerVersions")) {
                return -1;
            }
            Cursor cursorQuery = sQLiteDatabase.query("ExoPlayerVersions", new String[]{"version"}, "feature = ? AND instance_uid = ?", new String[]{Integer.toString(i), str}, null, null, null);
            try {
                if (cursorQuery.getCount() == 0) {
                    cursorQuery.close();
                    return -1;
                }
                cursorQuery.moveToNext();
                int i2 = cursorQuery.getInt(0);
                cursorQuery.close();
                return i2;
            } finally {
            }
        } catch (SQLException e) {
            throw new DatabaseIOException(e);
        }
    }

    public static void b(SQLiteDatabase sQLiteDatabase, int i, String str, int i2) throws SQLException, DatabaseIOException {
        try {
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS ExoPlayerVersions (feature INTEGER NOT NULL,instance_uid TEXT NOT NULL,version INTEGER NOT NULL,PRIMARY KEY (feature, instance_uid))");
            ContentValues contentValues = new ContentValues();
            contentValues.put("feature", Integer.valueOf(i));
            contentValues.put("instance_uid", str);
            contentValues.put("version", Integer.valueOf(i2));
            sQLiteDatabase.replaceOrThrow("ExoPlayerVersions", null, contentValues);
        } catch (SQLException e) {
            throw new DatabaseIOException(e);
        }
    }
}
