package b.f.d.h;

import b.c.a.a0.AnimatableValueParser;
import com.facebook.common.references.CloseableReference;
import com.facebook.common.references.SharedReference;

/* compiled from: RefCountCloseableReference.java */
/* renamed from: b.f.d.h.e, reason: use source file name */
/* loaded from: classes.dex */
public class RefCountCloseableReference<T> extends CloseableReference<T> {
    public RefCountCloseableReference(SharedReference<T> sharedReference, CloseableReference.c cVar, Throwable th) {
        super(sharedReference, cVar, th);
    }

    @Override // com.facebook.common.references.CloseableReference
    public CloseableReference<T> b() {
        AnimatableValueParser.B(x());
        return new RefCountCloseableReference(this.o, this.p, this.q);
    }

    @Override // com.facebook.common.references.CloseableReference
    public /* bridge */ /* synthetic */ Object clone() throws CloneNotSupportedException {
        return b();
    }

    public RefCountCloseableReference(T t, ResourceReleaser<T> resourceReleaser, CloseableReference.c cVar, Throwable th) {
        super(t, resourceReleaser, cVar, th);
    }
}
