package b.i.a.c;

import b.i.a.c.Renderer2;

/* compiled from: ExoPlayerImplInternal.java */
/* renamed from: b.i.a.c.g1, reason: use source file name */
/* loaded from: classes3.dex */
public class ExoPlayerImplInternal implements Renderer2.a {
    public final /* synthetic */ ExoPlayerImplInternal2 a;

    public ExoPlayerImplInternal(ExoPlayerImplInternal2 exoPlayerImplInternal2) {
        this.a = exoPlayerImplInternal2;
    }

    @Override // b.i.a.c.Renderer2.a
    public void a() {
        this.a.q.f(2);
    }

    @Override // b.i.a.c.Renderer2.a
    public void b(long j) {
        if (j >= 2000) {
            this.a.Q = true;
        }
    }
}
