package j0.l.e.o;

import java.lang.reflect.Field;
import sun.misc.Unsafe;

/* compiled from: UnsafeAccess.java */
/* renamed from: j0.l.e.o.y, reason: use source file name */
/* loaded from: classes3.dex */
public final class UnsafeAccess {
    public static final Unsafe a;

    /* renamed from: b, reason: collision with root package name */
    public static final boolean f3799b;

    static {
        f3799b = System.getProperty("rx.unsafe-disable") != null;
        Unsafe unsafe = null;
        try {
            Field declaredField = Unsafe.class.getDeclaredField("theUnsafe");
            declaredField.setAccessible(true);
            unsafe = (Unsafe) declaredField.get(null);
        } catch (Throwable unused) {
        }
        a = unsafe;
    }

    public static long a(Class<?> cls, String str) throws NoSuchFieldException {
        try {
            return a.objectFieldOffset(cls.getDeclaredField(str));
        } catch (NoSuchFieldException e) {
            InternalError internalError = new InternalError();
            internalError.initCause(e);
            throw internalError;
        }
    }

    public static boolean b() {
        return (a == null || f3799b) ? false : true;
    }
}
