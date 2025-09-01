package b.i.a.b.j.t.i;

import b.i.a.b.j.t.i.t;

/* compiled from: SQLiteEventStore.java */
/* loaded from: classes3.dex */
public final /* synthetic */ class o implements t.d {
    public final SchemaManager5 a;

    public o(SchemaManager5 schemaManager5) {
        this.a = schemaManager5;
    }

    @Override // b.i.a.b.j.t.i.t.d
    public Object a() {
        return this.a.getWritableDatabase();
    }
}
