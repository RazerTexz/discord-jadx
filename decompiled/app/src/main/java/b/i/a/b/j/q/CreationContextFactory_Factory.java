package b.i.a.b.j.q;

import android.content.Context;
import b.i.a.b.j.v.Clock3;
import c0.a.Provider3;

/* compiled from: CreationContextFactory_Factory.java */
/* renamed from: b.i.a.b.j.q.j, reason: use source file name */
/* loaded from: classes3.dex */
public final class CreationContextFactory_Factory implements Provider3 {
    public final Provider3<Context> a;

    /* renamed from: b, reason: collision with root package name */
    public final Provider3<Clock3> f775b;
    public final Provider3<Clock3> c;

    public CreationContextFactory_Factory(Provider3<Context> provider3, Provider3<Clock3> provider32, Provider3<Clock3> provider33) {
        this.a = provider3;
        this.f775b = provider32;
        this.c = provider33;
    }

    @Override // c0.a.Provider3
    public Object get() {
        return new CreationContextFactory(this.a.get(), this.f775b.get(), this.c.get());
    }
}
