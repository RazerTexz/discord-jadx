package b.i.a.b.j.t.i;

import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import b.i.a.b.j.t.i.SchemaManager5;
import java.util.List;

/* compiled from: SchemaManager.java */
/* renamed from: b.i.a.b.j.t.i.y, reason: use source file name */
/* loaded from: classes3.dex */
public final /* synthetic */ class SchemaManager4 implements SchemaManager5.a {
    public static final SchemaManager4 a = new SchemaManager4();

    @Override // b.i.a.b.j.t.i.SchemaManager5.a
    public void a(SQLiteDatabase sQLiteDatabase) throws SQLException {
        List<SchemaManager5.a> list = SchemaManager5.j;
        sQLiteDatabase.execSQL("ALTER TABLE events ADD COLUMN inline BOOLEAN NOT NULL DEFAULT 1");
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS event_payloads");
        sQLiteDatabase.execSQL("CREATE TABLE event_payloads (sequence_num INTEGER NOT NULL, event_id INTEGER NOT NULL, bytes BLOB NOT NULL,FOREIGN KEY (event_id) REFERENCES events(_id) ON DELETE CASCADE,PRIMARY KEY (sequence_num, event_id))");
    }
}
