package b.e.b;

import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import java.security.ProtectionDomain;
import java.util.WeakHashMap;

/* compiled from: AccessClassLoader.java */
/* renamed from: b.e.b.a, reason: use source file name */
/* loaded from: classes.dex */
public class AccessClassLoader extends ClassLoader {
    public static final WeakHashMap<ClassLoader, WeakReference<AccessClassLoader>> a = new WeakHashMap<>();

    /* renamed from: b, reason: collision with root package name */
    public static final ClassLoader f454b;
    public static volatile AccessClassLoader c;
    public static volatile Method d;

    static {
        ClassLoader classLoader = AccessClassLoader.class.getClassLoader();
        if (classLoader == null) {
            classLoader = ClassLoader.getSystemClassLoader();
        }
        f454b = classLoader;
        c = new AccessClassLoader(classLoader);
    }

    public AccessClassLoader(ClassLoader classLoader) {
        super(classLoader);
    }

    public static AccessClassLoader b(Class cls) {
        ClassLoader classLoader = cls.getClassLoader();
        if (classLoader == null) {
            classLoader = ClassLoader.getSystemClassLoader();
        }
        ClassLoader classLoader2 = f454b;
        if (classLoader2.equals(classLoader)) {
            if (c == null) {
                synchronized (a) {
                    if (c == null) {
                        c = new AccessClassLoader(classLoader2);
                    }
                }
            }
            return c;
        }
        WeakHashMap<ClassLoader, WeakReference<AccessClassLoader>> weakHashMap = a;
        synchronized (weakHashMap) {
            WeakReference<AccessClassLoader> weakReference = weakHashMap.get(classLoader);
            if (weakReference != null) {
                AccessClassLoader accessClassLoader = weakReference.get();
                if (accessClassLoader != null) {
                    return accessClassLoader;
                }
                weakHashMap.remove(classLoader);
            }
            AccessClassLoader accessClassLoader2 = new AccessClassLoader(classLoader);
            weakHashMap.put(classLoader, new WeakReference<>(accessClassLoader2));
            return accessClassLoader2;
        }
    }

    public static Method c() throws Exception {
        if (d == null) {
            synchronized (a) {
                Class cls = Integer.TYPE;
                d = ClassLoader.class.getDeclaredMethod("defineClass", String.class, byte[].class, cls, cls, ProtectionDomain.class);
                try {
                    d.setAccessible(true);
                } catch (Exception unused) {
                }
            }
        }
        return d;
    }

    public Class<?> a(String str, byte[] bArr) throws ClassFormatError {
        try {
            return (Class) c().invoke(getParent(), str, bArr, 0, Integer.valueOf(bArr.length), getClass().getProtectionDomain());
        } catch (Exception unused) {
            return defineClass(str, bArr, 0, bArr.length, AccessClassLoader.class.getProtectionDomain());
        }
    }

    @Override // java.lang.ClassLoader
    public Class<?> loadClass(String str, boolean z2) throws ClassNotFoundException {
        return str.equals(FieldAccess2.class.getName()) ? FieldAccess2.class : str.equals(MethodAccess.class.getName()) ? MethodAccess.class : str.equals(ConstructorAccess.class.getName()) ? ConstructorAccess.class : str.equals(PublicConstructorAccess.class.getName()) ? PublicConstructorAccess.class : super.loadClass(str, z2);
    }
}
