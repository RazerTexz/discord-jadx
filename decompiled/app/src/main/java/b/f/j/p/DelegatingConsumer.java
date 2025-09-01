package b.f.j.p;

/* compiled from: DelegatingConsumer.java */
/* renamed from: b.f.j.p.p, reason: use source file name */
/* loaded from: classes3.dex */
public abstract class DelegatingConsumer<I, O> extends BaseConsumer<I> {

    /* renamed from: b, reason: collision with root package name */
    public final Consumer2<O> f632b;

    public DelegatingConsumer(Consumer2<O> consumer2) {
        this.f632b = consumer2;
    }

    @Override // b.f.j.p.BaseConsumer
    public void g() {
        this.f632b.d();
    }

    @Override // b.f.j.p.BaseConsumer
    public void h(Throwable th) {
        this.f632b.c(th);
    }

    @Override // b.f.j.p.BaseConsumer
    public void j(float f) {
        this.f632b.a(f);
    }
}
