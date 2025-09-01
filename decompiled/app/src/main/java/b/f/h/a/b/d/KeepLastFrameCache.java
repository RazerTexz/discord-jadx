package b.f.h.a.b.d;

import android.graphics.Bitmap;
import b.f.h.a.b.BitmapFrameCache;
import com.facebook.common.references.CloseableReference;

/* compiled from: KeepLastFrameCache.java */
/* renamed from: b.f.h.a.b.d.c, reason: use source file name */
/* loaded from: classes.dex */
public class KeepLastFrameCache implements BitmapFrameCache {
    public int a = -1;

    /* renamed from: b, reason: collision with root package name */
    public CloseableReference<Bitmap> f529b;

    @Override // b.f.h.a.b.BitmapFrameCache
    public synchronized CloseableReference<Bitmap> a(int i, int i2, int i3) {
        try {
        } finally {
            g();
        }
        return CloseableReference.n(this.f529b);
    }

    @Override // b.f.h.a.b.BitmapFrameCache
    public void b(int i, CloseableReference<Bitmap> closeableReference, int i2) {
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x000f  */
    @Override // b.f.h.a.b.BitmapFrameCache
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized boolean c(int i) {
        boolean z2;
        if (i == this.a) {
            z2 = CloseableReference.y(this.f529b);
        }
        return z2;
    }

    @Override // b.f.h.a.b.BitmapFrameCache
    public synchronized void clear() {
        g();
    }

    @Override // b.f.h.a.b.BitmapFrameCache
    public synchronized CloseableReference<Bitmap> d(int i) {
        if (this.a != i) {
            return null;
        }
        return CloseableReference.n(this.f529b);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0021 A[Catch: all -> 0x002e, TryCatch #0 {, blocks: (B:4:0x0003, B:6:0x0007, B:10:0x001b, B:12:0x0021, B:13:0x0024), top: B:19:0x0003 }] */
    @Override // b.f.h.a.b.BitmapFrameCache
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void e(int i, CloseableReference<Bitmap> closeableReference, int i2) {
        CloseableReference<Bitmap> closeableReference2;
        if (closeableReference == null) {
            closeableReference2 = this.f529b;
            Class<CloseableReference> cls = CloseableReference.j;
            if (closeableReference2 != null) {
            }
            this.f529b = CloseableReference.n(closeableReference);
            this.a = i;
            return;
        }
        if (this.f529b != null && closeableReference.u().equals(this.f529b.u())) {
            return;
        }
        closeableReference2 = this.f529b;
        Class<CloseableReference> cls2 = CloseableReference.j;
        if (closeableReference2 != null) {
            closeableReference2.close();
        }
        this.f529b = CloseableReference.n(closeableReference);
        this.a = i;
        return;
    }

    @Override // b.f.h.a.b.BitmapFrameCache
    public synchronized CloseableReference<Bitmap> f(int i) {
        return CloseableReference.n(this.f529b);
    }

    public final synchronized void g() {
        CloseableReference<Bitmap> closeableReference = this.f529b;
        Class<CloseableReference> cls = CloseableReference.j;
        if (closeableReference != null) {
            closeableReference.close();
        }
        this.f529b = null;
        this.a = -1;
    }
}
