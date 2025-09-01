package b.i.a.f.i.b;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabaseLockedException;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteFullException;
import android.os.SystemClock;
import androidx.annotation.WorkerThread;
import androidx.exifinterface.media.ExifInterface;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* loaded from: classes3.dex */
public final class m3 extends a5 {
    public final p3 c;
    public boolean d;

    public m3(u4 u4Var) {
        super(u4Var);
        this.c = new p3(this, this.a.f1570b, "google_app_measurement_local.db");
    }

    public static long w(SQLiteDatabase sQLiteDatabase) {
        Cursor cursorQuery = null;
        try {
            cursorQuery = sQLiteDatabase.query("messages", new String[]{"rowid"}, "type=?", new String[]{ExifInterface.GPS_MEASUREMENT_3D}, null, null, "rowid desc", "1");
            if (!cursorQuery.moveToFirst()) {
                cursorQuery.close();
                return -1L;
            }
            long j = cursorQuery.getLong(0);
            cursorQuery.close();
            return j;
        } catch (Throwable th) {
            if (cursorQuery != null) {
                cursorQuery.close();
            }
            throw th;
        }
    }

    @WorkerThread
    public final SQLiteDatabase A() throws SQLiteException {
        if (this.d) {
            return null;
        }
        SQLiteDatabase writableDatabase = this.c.getWritableDatabase();
        if (writableDatabase != null) {
            return writableDatabase;
        }
        this.d = true;
        return null;
    }

    @Override // b.i.a.f.i.b.a5
    public final boolean v() {
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:78:0x011c  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0121  */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r2v9 */
    @WorkerThread
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean x(int i, byte[] bArr) {
        SQLiteDatabase sQLiteDatabaseA;
        Cursor cursor;
        b();
        ?? r2 = 0;
        if (this.d) {
            return false;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("type", Integer.valueOf(i));
        contentValues.put("entry", bArr);
        int i2 = 0;
        int i3 = 5;
        for (int i4 = 5; i2 < i4; i4 = 5) {
            Cursor cursor2 = null;
            cursor = null;
            cursor2 = null;
            Cursor cursor3 = null;
            Cursor cursor4 = null;
            cursor2 = null;
            SQLiteDatabase sQLiteDatabase = null;
            try {
                sQLiteDatabaseA = A();
                try {
                    if (sQLiteDatabaseA == null) {
                        this.d = true;
                        if (sQLiteDatabaseA != null) {
                            sQLiteDatabaseA.close();
                        }
                        return r2;
                    }
                    sQLiteDatabaseA.beginTransaction();
                    long j = 0;
                    Cursor cursorRawQuery = sQLiteDatabaseA.rawQuery("select count(1) from messages", null);
                    if (cursorRawQuery != 0) {
                        try {
                            if (cursorRawQuery.moveToFirst()) {
                                j = cursorRawQuery.getLong(r2);
                            }
                        } catch (SQLiteDatabaseLockedException unused) {
                            cursor4 = cursorRawQuery;
                            SystemClock.sleep(i3);
                            i3 += 20;
                            if (cursor4 != null) {
                                cursor4.close();
                            }
                            if (sQLiteDatabaseA != null) {
                                sQLiteDatabaseA.close();
                            }
                            i2++;
                            r2 = 0;
                        } catch (SQLiteFullException e) {
                            e = e;
                            cursor2 = cursorRawQuery;
                            try {
                                g().f.b("Error writing entry; local database full", e);
                                this.d = true;
                                if (cursor2 != null) {
                                    cursor2.close();
                                }
                                if (sQLiteDatabaseA != null) {
                                    sQLiteDatabaseA.close();
                                }
                                i2++;
                                r2 = 0;
                            } catch (Throwable th) {
                                th = th;
                                if (cursor2 != null) {
                                }
                                if (sQLiteDatabaseA != null) {
                                }
                                throw th;
                            }
                        } catch (SQLiteException e2) {
                            e = e2;
                            cursor3 = cursorRawQuery;
                            cursor = cursor3;
                            sQLiteDatabase = sQLiteDatabaseA;
                            if (sQLiteDatabase != null) {
                                try {
                                    if (sQLiteDatabase.inTransaction()) {
                                        sQLiteDatabase.endTransaction();
                                    }
                                } catch (Throwable th2) {
                                    th = th2;
                                    sQLiteDatabaseA = sQLiteDatabase;
                                    cursor2 = cursor;
                                    if (cursor2 != null) {
                                        cursor2.close();
                                    }
                                    if (sQLiteDatabaseA != null) {
                                        sQLiteDatabaseA.close();
                                    }
                                    throw th;
                                }
                            }
                            g().f.b("Error writing entry to local database", e);
                            this.d = true;
                            if (cursor != null) {
                                cursor.close();
                            }
                            if (sQLiteDatabase != null) {
                                sQLiteDatabase.close();
                            }
                            i2++;
                            r2 = 0;
                        } catch (Throwable th3) {
                            th = th3;
                            cursor2 = cursorRawQuery;
                            if (cursor2 != null) {
                            }
                            if (sQLiteDatabaseA != null) {
                            }
                            throw th;
                        }
                    }
                    if (j >= 100000) {
                        g().f.a("Data loss, local db full");
                        long j2 = (100000 - j) + 1;
                        String[] strArr = new String[1];
                        strArr[r2] = Long.toString(j2);
                        long jDelete = sQLiteDatabaseA.delete("messages", "rowid in (select rowid from messages order by rowid asc limit ?)", strArr);
                        if (jDelete != j2) {
                            g().f.d("Different delete count than expected in local db. expected, received, difference", Long.valueOf(j2), Long.valueOf(jDelete), Long.valueOf(j2 - jDelete));
                        }
                    }
                    sQLiteDatabaseA.insertOrThrow("messages", null, contentValues);
                    sQLiteDatabaseA.setTransactionSuccessful();
                    sQLiteDatabaseA.endTransaction();
                    if (cursorRawQuery != 0) {
                        cursorRawQuery.close();
                    }
                    sQLiteDatabaseA.close();
                    return true;
                } catch (SQLiteDatabaseLockedException unused2) {
                } catch (SQLiteFullException e3) {
                    e = e3;
                } catch (SQLiteException e4) {
                    e = e4;
                }
            } catch (SQLiteDatabaseLockedException unused3) {
                sQLiteDatabaseA = null;
            } catch (SQLiteFullException e5) {
                e = e5;
                sQLiteDatabaseA = null;
            } catch (SQLiteException e6) {
                e = e6;
                cursor = null;
            } catch (Throwable th4) {
                th = th4;
                sQLiteDatabaseA = null;
            }
        }
        g().n.a("Failed to write entry to local database");
        return false;
    }

    @WorkerThread
    public final void y() {
        b();
        try {
            int iDelete = A().delete("messages", null, null) + 0;
            if (iDelete > 0) {
                g().n.b("Reset local analytics data. records", Integer.valueOf(iDelete));
            }
        } catch (SQLiteException e) {
            g().f.b("Error resetting local analytics data. error", e);
        }
    }

    @WorkerThread
    public final boolean z() {
        b();
        if (this.d || !this.a.f1570b.getDatabasePath("google_app_measurement_local.db").exists()) {
            return false;
        }
        int i = 5;
        for (int i2 = 0; i2 < 5; i2++) {
            SQLiteDatabase sQLiteDatabase = null;
            try {
                SQLiteDatabase sQLiteDatabaseA = A();
                if (sQLiteDatabaseA == null) {
                    this.d = true;
                    if (sQLiteDatabaseA != null) {
                        sQLiteDatabaseA.close();
                    }
                    return false;
                }
                sQLiteDatabaseA.beginTransaction();
                sQLiteDatabaseA.delete("messages", "type == ?", new String[]{Integer.toString(3)});
                sQLiteDatabaseA.setTransactionSuccessful();
                sQLiteDatabaseA.endTransaction();
                sQLiteDatabaseA.close();
                return true;
            } catch (SQLiteDatabaseLockedException unused) {
                SystemClock.sleep(i);
                i += 20;
                if (0 != 0) {
                    sQLiteDatabase.close();
                }
            } catch (SQLiteFullException e) {
                g().f.b("Error deleting app launch break from local database", e);
                this.d = true;
                if (0 != 0) {
                    sQLiteDatabase.close();
                }
            } catch (SQLiteException e2) {
                if (0 != 0) {
                    try {
                        if (sQLiteDatabase.inTransaction()) {
                            sQLiteDatabase.endTransaction();
                        }
                    } catch (Throwable th) {
                        if (0 != 0) {
                            sQLiteDatabase.close();
                        }
                        throw th;
                    }
                }
                g().f.b("Error deleting app launch break from local database", e2);
                this.d = true;
                if (0 != 0) {
                    sQLiteDatabase.close();
                }
            }
        }
        g().i.a("Error deleting app launch break from local database in reasonable time");
        return false;
    }
}
