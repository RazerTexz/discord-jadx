package b.i.a.b.j.q;

import android.content.Context;
import c0.a.Provider3;

/* compiled from: MetadataBackendRegistry_Factory.java */
/* renamed from: b.i.a.b.j.q.l, reason: use source file name */
/* loaded from: classes3.dex */
public final class MetadataBackendRegistry_Factory implements Provider3 {
    public final Provider3<Context> a;

    /* renamed from: b, reason: collision with root package name */
    public final Provider3<CreationContextFactory> f778b;

    public MetadataBackendRegistry_Factory(Provider3<Context> provider3, Provider3<CreationContextFactory> provider32) {
        this.a = provider3;
        this.f778b = provider32;
    }

    @Override // c0.a.Provider3
    public Object get() {
        return new MetadataBackendRegistry(this.a.get(), this.f778b.get());
    }
}
