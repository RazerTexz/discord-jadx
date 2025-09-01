package b.f.d.h;

import b.f.d.e.FLog;
import com.facebook.common.references.CloseableReference;

/* compiled from: FinalizerCloseableReference.java */
/* renamed from: b.f.d.h.b, reason: use source file name */
/* loaded from: classes.dex */
public class FinalizerCloseableReference<T> extends CloseableReference<T> {
    public FinalizerCloseableReference(T t, ResourceReleaser<T> resourceReleaser, CloseableReference.c cVar, Throwable th) {
        super(t, resourceReleaser, cVar, th);
    }

    @Override // com.facebook.common.references.CloseableReference
    public CloseableReference<T> b() {
        return this;
    }

    @Override // com.facebook.common.references.CloseableReference
    public Object clone() throws CloneNotSupportedException {
        return this;
    }

    @Override // com.facebook.common.references.CloseableReference, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    public void finalize() throws Throwable {
        try {
            synchronized (this) {
                if (this.n) {
                    return;
                }
                T tC = this.o.c();
                Object[] objArr = new Object[3];
                objArr[0] = Integer.valueOf(System.identityHashCode(this));
                objArr[1] = Integer.valueOf(System.identityHashCode(this.o));
                objArr[2] = tC == null ? null : tC.getClass().getName();
                FLog.o("FinalizerCloseableReference", "Finalized without closing: %x %x (type = %s)", objArr);
                this.o.a();
            }
        } finally {
            super.finalize();
        }
    }
}
