package i0;

import b.d.b.a.outline;
import java.lang.annotation.Annotation;

/* compiled from: SkipCallbackExecutorImpl.java */
/* renamed from: i0.b0, reason: use source file name */
/* loaded from: classes3.dex */
public final class SkipCallbackExecutorImpl implements SkipCallbackExecutor {
    public static final SkipCallbackExecutor a = new SkipCallbackExecutorImpl();

    @Override // java.lang.annotation.Annotation
    public Class<? extends Annotation> annotationType() {
        return SkipCallbackExecutor.class;
    }

    @Override // java.lang.annotation.Annotation
    public boolean equals(Object obj) {
        return obj instanceof SkipCallbackExecutor;
    }

    @Override // java.lang.annotation.Annotation
    public int hashCode() {
        return 0;
    }

    @Override // java.lang.annotation.Annotation
    public String toString() {
        return outline.o(SkipCallbackExecutor.class, outline.U("@"), "()");
    }
}
