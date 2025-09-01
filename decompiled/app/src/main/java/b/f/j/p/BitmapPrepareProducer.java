package b.f.j.p;

import android.graphics.Bitmap;
import b.c.a.a0.AnimatableValueParser;
import b.f.j.j.CloseableImage;
import b.f.j.j.CloseableStaticBitmap;
import com.facebook.common.references.CloseableReference;
import java.util.Objects;

/* compiled from: BitmapPrepareProducer.java */
/* renamed from: b.f.j.p.i, reason: use source file name */
/* loaded from: classes3.dex */
public class BitmapPrepareProducer implements Producer2<CloseableReference<CloseableImage>> {
    public final Producer2<CloseableReference<CloseableImage>> a;

    /* renamed from: b, reason: collision with root package name */
    public final int f615b;
    public final int c;
    public final boolean d;

    /* compiled from: BitmapPrepareProducer.java */
    /* renamed from: b.f.j.p.i$a */
    public static class a extends DelegatingConsumer<CloseableReference<CloseableImage>, CloseableReference<CloseableImage>> {
        public final int c;
        public final int d;

        public a(Consumer2<CloseableReference<CloseableImage>> consumer2, int i, int i2) {
            super(consumer2);
            this.c = i;
            this.d = i2;
        }

        @Override // b.f.j.p.BaseConsumer
        public void i(Object obj, int i) {
            Bitmap bitmap;
            CloseableReference closeableReference = (CloseableReference) obj;
            if (closeableReference != null && closeableReference.x()) {
                CloseableImage closeableImage = (CloseableImage) closeableReference.u();
                if (!closeableImage.isClosed() && (closeableImage instanceof CloseableStaticBitmap) && (bitmap = ((CloseableStaticBitmap) closeableImage).m) != null) {
                    int height = bitmap.getHeight() * bitmap.getRowBytes();
                    if (height >= this.c && height <= this.d) {
                        bitmap.prepareToDraw();
                    }
                }
            }
            this.f632b.b(closeableReference, i);
        }
    }

    public BitmapPrepareProducer(Producer2<CloseableReference<CloseableImage>> producer2, int i, int i2, boolean z2) {
        AnimatableValueParser.i(Boolean.valueOf(i <= i2));
        Objects.requireNonNull(producer2);
        this.a = producer2;
        this.f615b = i;
        this.c = i2;
        this.d = z2;
    }

    @Override // b.f.j.p.Producer2
    public void b(Consumer2<CloseableReference<CloseableImage>> consumer2, ProducerContext producerContext) {
        if (!producerContext.k() || this.d) {
            this.a.b(new a(consumer2, this.f615b, this.c), producerContext);
        } else {
            this.a.b(consumer2, producerContext);
        }
    }
}
