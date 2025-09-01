package b.g.a.c.b0;

import b.g.a.c.PropertyName;
import b.g.a.c.c0.Annotated;
import b.g.a.c.c0.AnnotatedParameter;
import b.g.a.c.i0.ClassUtil;

/* compiled from: Java7Support.java */
/* renamed from: b.g.a.c.b0.c, reason: use source file name */
/* loaded from: classes3.dex */
public abstract class Java7Support {
    public static final Java7Support a;

    static {
        Java7Support java7Support;
        try {
            java7Support = (Java7Support) ClassUtil.g(Class.forName("b.g.a.c.b0.d"), false);
        } catch (Throwable unused) {
            java7Support = null;
        }
        a = java7Support;
    }

    public abstract PropertyName a(AnnotatedParameter annotatedParameter);

    public abstract Boolean b(Annotated annotated);

    public abstract Boolean c(Annotated annotated);
}
