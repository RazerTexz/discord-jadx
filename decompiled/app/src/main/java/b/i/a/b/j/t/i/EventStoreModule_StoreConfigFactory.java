package b.i.a.b.j.t.i;

import c0.a.Provider3;
import java.util.Objects;

/* compiled from: EventStoreModule_StoreConfigFactory.java */
/* renamed from: b.i.a.b.j.t.i.g, reason: use source file name */
/* loaded from: classes3.dex */
public final class EventStoreModule_StoreConfigFactory implements Provider3 {

    /* compiled from: EventStoreModule_StoreConfigFactory.java */
    /* renamed from: b.i.a.b.j.t.i.g$a */
    public static final class a {
        public static final EventStoreModule_StoreConfigFactory a = new EventStoreModule_StoreConfigFactory();
    }

    @Override // c0.a.Provider3
    public Object get() {
        EventStoreConfig eventStoreConfig = EventStoreConfig.a;
        Objects.requireNonNull(eventStoreConfig, "Cannot return null from a non-@Nullable @Provides method");
        return eventStoreConfig;
    }
}
