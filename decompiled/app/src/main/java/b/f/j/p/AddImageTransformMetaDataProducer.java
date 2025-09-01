package b.f.j.p;

import b.f.j.j.EncodedImage2;
import java.io.IOException;

/* compiled from: AddImageTransformMetaDataProducer.java */
/* renamed from: b.f.j.p.a, reason: use source file name */
/* loaded from: classes3.dex */
public class AddImageTransformMetaDataProducer implements Producer2<EncodedImage2> {
    public final Producer2<EncodedImage2> a;

    /* compiled from: AddImageTransformMetaDataProducer.java */
    /* renamed from: b.f.j.p.a$b */
    public static class b extends DelegatingConsumer<EncodedImage2, EncodedImage2> {
        public b(Consumer2 consumer2, a aVar) {
            super(consumer2);
        }

        @Override // b.f.j.p.BaseConsumer
        public void i(Object obj, int i) throws IOException {
            EncodedImage2 encodedImage2 = (EncodedImage2) obj;
            if (encodedImage2 == null) {
                this.f632b.b(null, i);
                return;
            }
            if (!EncodedImage2.s(encodedImage2)) {
                encodedImage2.q();
            }
            this.f632b.b(encodedImage2, i);
        }
    }

    public AddImageTransformMetaDataProducer(Producer2<EncodedImage2> producer2) {
        this.a = producer2;
    }

    @Override // b.f.j.p.Producer2
    public void b(Consumer2<EncodedImage2> consumer2, ProducerContext producerContext) {
        this.a.b(new b(consumer2, null), producerContext);
    }
}
