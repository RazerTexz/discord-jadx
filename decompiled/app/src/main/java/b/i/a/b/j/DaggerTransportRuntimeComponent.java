package b.i.a.b.j;

import android.content.Context;
import b.i.a.b.j.ExecutionModule_ExecutorFactory;
import b.i.a.b.j.q.CreationContextFactory_Factory;
import b.i.a.b.j.q.MetadataBackendRegistry_Factory;
import b.i.a.b.j.r.a.DoubleCheck;
import b.i.a.b.j.r.a.InstanceFactory;
import b.i.a.b.j.t.DefaultScheduler3;
import b.i.a.b.j.t.DefaultScheduler_Factory;
import b.i.a.b.j.t.SchedulingConfigModule_ConfigFactory;
import b.i.a.b.j.t.SchedulingModule_WorkSchedulerFactory;
import b.i.a.b.j.t.h.SchedulerConfig;
import b.i.a.b.j.t.h.Uploader6;
import b.i.a.b.j.t.h.Uploader_Factory;
import b.i.a.b.j.t.h.WorkInitializer3;
import b.i.a.b.j.t.h.WorkInitializer_Factory;
import b.i.a.b.j.t.h.WorkScheduler;
import b.i.a.b.j.t.i.EventStoreModule_DbNameFactory;
import b.i.a.b.j.t.i.EventStoreModule_SchemaVersionFactory;
import b.i.a.b.j.t.i.EventStoreModule_StoreConfigFactory;
import b.i.a.b.j.t.i.SQLiteEventStore_Factory;
import b.i.a.b.j.t.i.SchemaManager_Factory;
import b.i.a.b.j.t.i.t;
import b.i.a.b.j.v.TimeModule_EventClockFactory;
import b.i.a.b.j.v.TimeModule_UptimeClockFactory;
import c0.a.Provider3;
import java.util.Objects;
import java.util.concurrent.Executor;

/* compiled from: DaggerTransportRuntimeComponent.java */
/* renamed from: b.i.a.b.j.c, reason: use source file name */
/* loaded from: classes3.dex */
public final class DaggerTransportRuntimeComponent extends TransportRuntimeComponent {
    public Provider3<Executor> j;
    public Provider3<Context> k;
    public Provider3 l;
    public Provider3 m;
    public Provider3 n;
    public Provider3<t> o;
    public Provider3<SchedulerConfig> p;
    public Provider3<WorkScheduler> q;
    public Provider3<DefaultScheduler3> r;

    /* renamed from: s, reason: collision with root package name */
    public Provider3<Uploader6> f765s;
    public Provider3<WorkInitializer3> t;
    public Provider3<TransportRuntime> u;

    public DaggerTransportRuntimeComponent(Context context, a aVar) {
        Provider3 provider3 = ExecutionModule_ExecutorFactory.a.a;
        Object obj = DoubleCheck.a;
        this.j = provider3 instanceof DoubleCheck ? provider3 : new DoubleCheck(provider3);
        Objects.requireNonNull(context, "instance cannot be null");
        InstanceFactory instanceFactory = new InstanceFactory(context);
        this.k = instanceFactory;
        TimeModule_EventClockFactory timeModule_EventClockFactory = TimeModule_EventClockFactory.a.a;
        TimeModule_UptimeClockFactory timeModule_UptimeClockFactory = TimeModule_UptimeClockFactory.a.a;
        CreationContextFactory_Factory creationContextFactory_Factory = new CreationContextFactory_Factory(instanceFactory, timeModule_EventClockFactory, timeModule_UptimeClockFactory);
        this.l = creationContextFactory_Factory;
        Provider3 metadataBackendRegistry_Factory = new MetadataBackendRegistry_Factory(instanceFactory, creationContextFactory_Factory);
        this.m = metadataBackendRegistry_Factory instanceof DoubleCheck ? metadataBackendRegistry_Factory : new DoubleCheck(metadataBackendRegistry_Factory);
        SchemaManager_Factory schemaManager_Factory = new SchemaManager_Factory(this.k, EventStoreModule_DbNameFactory.a.a, EventStoreModule_SchemaVersionFactory.a.a);
        this.n = schemaManager_Factory;
        SQLiteEventStore_Factory sQLiteEventStore_Factory = new SQLiteEventStore_Factory(timeModule_EventClockFactory, timeModule_UptimeClockFactory, EventStoreModule_StoreConfigFactory.a.a, schemaManager_Factory);
        Provider3<t> doubleCheck = sQLiteEventStore_Factory instanceof DoubleCheck ? sQLiteEventStore_Factory : new DoubleCheck<>(sQLiteEventStore_Factory);
        this.o = doubleCheck;
        SchedulingConfigModule_ConfigFactory schedulingConfigModule_ConfigFactory = new SchedulingConfigModule_ConfigFactory(timeModule_EventClockFactory);
        this.p = schedulingConfigModule_ConfigFactory;
        Provider3<Context> provider32 = this.k;
        SchedulingModule_WorkSchedulerFactory schedulingModule_WorkSchedulerFactory = new SchedulingModule_WorkSchedulerFactory(provider32, doubleCheck, schedulingConfigModule_ConfigFactory, timeModule_UptimeClockFactory);
        this.q = schedulingModule_WorkSchedulerFactory;
        Provider3<Executor> provider33 = this.j;
        Provider3 provider34 = this.m;
        DefaultScheduler_Factory defaultScheduler_Factory = new DefaultScheduler_Factory(provider33, provider34, schedulingModule_WorkSchedulerFactory, doubleCheck, doubleCheck);
        this.r = defaultScheduler_Factory;
        Uploader_Factory uploader_Factory = new Uploader_Factory(provider32, provider34, doubleCheck, schedulingModule_WorkSchedulerFactory, provider33, doubleCheck, timeModule_EventClockFactory);
        this.f765s = uploader_Factory;
        WorkInitializer_Factory workInitializer_Factory = new WorkInitializer_Factory(provider33, doubleCheck, schedulingModule_WorkSchedulerFactory, doubleCheck);
        this.t = workInitializer_Factory;
        Provider3 transportRuntime_Factory = new TransportRuntime_Factory(timeModule_EventClockFactory, timeModule_UptimeClockFactory, defaultScheduler_Factory, uploader_Factory, workInitializer_Factory);
        this.u = transportRuntime_Factory instanceof DoubleCheck ? transportRuntime_Factory : new DoubleCheck(transportRuntime_Factory);
    }
}
