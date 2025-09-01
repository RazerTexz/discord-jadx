package b.f.j.c;

import b.f.j.j.CloseableImage;

/* compiled from: CountingLruBitmapMemoryCacheFactory.java */
/* renamed from: b.f.j.c.j, reason: use source file name */
/* loaded from: classes.dex */
public class CountingLruBitmapMemoryCacheFactory implements ValueDescriptor<CloseableImage> {
    public CountingLruBitmapMemoryCacheFactory(CountingLruBitmapMemoryCacheFactory2 countingLruBitmapMemoryCacheFactory2) {
    }

    @Override // b.f.j.c.ValueDescriptor
    public int a(CloseableImage closeableImage) {
        return closeableImage.c();
    }
}
