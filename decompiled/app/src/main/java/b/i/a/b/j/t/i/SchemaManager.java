package b.i.a.b.j.t.i;

import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import b.i.a.b.j.t.i.SchemaManager5;
import java.util.List;

/* compiled from: SchemaManager.java */
/* renamed from: b.i.a.b.j.t.i.v, reason: use source file name */
/* loaded from: classes3.dex */
public final /* synthetic */ class SchemaManager implements SchemaManager5.a {
    public static final SchemaManager a = new SchemaManager();

    @Override // b.i.a.b.j.t.i.SchemaManager5.a
    public void a(SQLiteDatabase sQLiteDatabase) throws SQLException {
        List<SchemaManager5.a> list = SchemaManager5.j;
        sQLiteDatabase.execSQL("CREATE TABLE events (_id INTEGER PRIMARY KEY, context_id INTEGER NOT NULL, transport_name TEXT NOT NULL, timestamp_ms INTEGER NOT NULL, uptime_ms INTEGER NOT NULL, payload BLOB NOT NULL, code INTEGER, num_attempts INTEGER NOT NULL,FOREIGN KEY (context_id) REFERENCES transport_contexts(_id) ON DELETE CASCADE)");
        sQLiteDatabase.execSQL("CREATE TABLE event_metadata (_id INTEGER PRIMARY KEY, event_id INTEGER NOT NULL, name TEXT NOT NULL, value TEXT NOT NULL,FOREIGN KEY (event_id) REFERENCES events(_id) ON DELETE CASCADE)");
        sQLiteDatabase.execSQL("CREATE TABLE transport_contexts (_id INTEGER PRIMARY KEY, backend_name TEXT NOT NULL, priority INTEGER NOT NULL, next_request_ms INTEGER NOT NULL)");
        sQLiteDatabase.execSQL("CREATE INDEX events_backend_id on events(context_id)");
        sQLiteDatabase.execSQL("CREATE UNIQUE INDEX contexts_backend_priority on transport_contexts(backend_name, priority)");
    }
}
