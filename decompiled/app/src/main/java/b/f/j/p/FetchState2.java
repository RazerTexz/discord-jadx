package b.f.j.p;

import b.f.j.j.EncodedImage2;

/* compiled from: FetchState.java */
/* renamed from: b.f.j.p.x, reason: use source file name */
/* loaded from: classes3.dex */
public class FetchState2 {
    public final Consumer2<EncodedImage2> a;

    /* renamed from: b, reason: collision with root package name */
    public final ProducerContext f642b;
    public long c = 0;

    public FetchState2(Consumer2<EncodedImage2> consumer2, ProducerContext producerContext) {
        this.a = consumer2;
        this.f642b = producerContext;
    }

    public ProducerListener2 a() {
        return this.f642b.o();
    }
}
