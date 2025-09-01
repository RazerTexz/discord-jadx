package b.i.a.b.j.t.i;

import b.i.a.b.j.t.i.SchemaManager5;
import c0.a.Provider3;
import java.util.List;

/* compiled from: EventStoreModule_SchemaVersionFactory.java */
/* renamed from: b.i.a.b.j.t.i.f, reason: use source file name */
/* loaded from: classes3.dex */
public final class EventStoreModule_SchemaVersionFactory implements Provider3 {

    /* compiled from: EventStoreModule_SchemaVersionFactory.java */
    /* renamed from: b.i.a.b.j.t.i.f$a */
    public static final class a {
        public static final EventStoreModule_SchemaVersionFactory a = new EventStoreModule_SchemaVersionFactory();
    }

    @Override // c0.a.Provider3
    public Object get() {
        List<SchemaManager5.a> list = SchemaManager5.j;
        return 4;
    }
}
