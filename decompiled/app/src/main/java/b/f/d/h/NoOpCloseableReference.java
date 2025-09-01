package b.f.d.h;

import com.facebook.common.references.CloseableReference;

/* compiled from: NoOpCloseableReference.java */
/* renamed from: b.f.d.h.d, reason: use source file name */
/* loaded from: classes.dex */
public class NoOpCloseableReference<T> extends CloseableReference<T> {
    public NoOpCloseableReference(T t, ResourceReleaser<T> resourceReleaser, CloseableReference.c cVar, Throwable th) {
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
}
