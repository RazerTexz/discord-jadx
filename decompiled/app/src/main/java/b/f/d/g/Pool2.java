package b.f.d.g;

import b.f.d.h.ResourceReleaser;

/* compiled from: Pool.java */
/* renamed from: b.f.d.g.e, reason: use source file name */
/* loaded from: classes.dex */
public interface Pool2<V> extends ResourceReleaser<V>, MemoryTrimmable {
    V get(int i);

    @Override // b.f.d.h.ResourceReleaser
    void release(V v);
}
