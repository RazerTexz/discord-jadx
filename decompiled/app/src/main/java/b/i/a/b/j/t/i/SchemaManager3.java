package b.i.a.b.j.t.i;

import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import b.i.a.b.j.t.i.SchemaManager5;
import java.util.List;

/* compiled from: SchemaManager.java */
/* renamed from: b.i.a.b.j.t.i.x, reason: use source file name */
/* loaded from: classes3.dex */
public final /* synthetic */ class SchemaManager3 implements SchemaManager5.a {
    public static final SchemaManager3 a = new SchemaManager3();

    @Override // b.i.a.b.j.t.i.SchemaManager5.a
    public void a(SQLiteDatabase sQLiteDatabase) throws SQLException {
        List<SchemaManager5.a> list = SchemaManager5.j;
        sQLiteDatabase.execSQL("ALTER TABLE events ADD COLUMN payload_encoding TEXT");
    }
}
