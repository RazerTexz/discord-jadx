package b.f.d.d;

/* compiled from: Throwables.java */
/* renamed from: b.f.d.d.m, reason: use source file name */
/* loaded from: classes.dex */
public final class Throwables {
    public static void a(Throwable th) throws Throwable {
        if (Error.class.isInstance(th)) {
            throw ((Throwable) Error.class.cast(th));
        }
        if (RuntimeException.class.isInstance(th)) {
            throw ((Throwable) RuntimeException.class.cast(th));
        }
    }
}
