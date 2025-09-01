package b.i.a.b.j.t.i;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import b.d.b.a.outline;
import java.util.Arrays;
import java.util.List;

/* compiled from: SchemaManager.java */
/* renamed from: b.i.a.b.j.t.i.z, reason: use source file name */
/* loaded from: classes3.dex */
public final class SchemaManager5 extends SQLiteOpenHelper {
    public static final List<a> j = Arrays.asList(SchemaManager.a, SchemaManager2.a, SchemaManager3.a, SchemaManager4.a);
    public final int k;
    public boolean l;

    /* compiled from: SchemaManager.java */
    /* renamed from: b.i.a.b.j.t.i.z$a */
    public interface a {
        void a(SQLiteDatabase sQLiteDatabase);
    }

    public SchemaManager5(Context context, String str, int i) {
        super(context, str, (SQLiteDatabase.CursorFactory) null, i);
        this.l = false;
        this.k = i;
    }

    public final void a(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        List<a> list = j;
        if (i2 <= list.size()) {
            while (i < i2) {
                j.get(i).a(sQLiteDatabase);
                i++;
            }
        } else {
            StringBuilder sbW = outline.W("Migration from ", i, " to ", i2, " was requested, but cannot be performed. Only ");
            sbW.append(list.size());
            sbW.append(" migrations are provided");
            throw new IllegalArgumentException(sbW.toString());
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onConfigure(SQLiteDatabase sQLiteDatabase) {
        this.l = true;
        sQLiteDatabase.rawQuery("PRAGMA busy_timeout=0;", new String[0]).close();
        sQLiteDatabase.setForeignKeyConstraintsEnabled(true);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        int i = this.k;
        if (!this.l) {
            onConfigure(sQLiteDatabase);
        }
        a(sQLiteDatabase, 0, i);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) throws SQLException {
        sQLiteDatabase.execSQL("DROP TABLE events");
        sQLiteDatabase.execSQL("DROP TABLE event_metadata");
        sQLiteDatabase.execSQL("DROP TABLE transport_contexts");
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS event_payloads");
        if (!this.l) {
            onConfigure(sQLiteDatabase);
        }
        a(sQLiteDatabase, 0, i2);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onOpen(SQLiteDatabase sQLiteDatabase) {
        if (this.l) {
            return;
        }
        onConfigure(sQLiteDatabase);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        if (!this.l) {
            onConfigure(sQLiteDatabase);
        }
        a(sQLiteDatabase, i, i2);
    }
}
