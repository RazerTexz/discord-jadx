package j0.o;

import b.d.b.a.outline;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: RxJavaPlugins.java */
/* renamed from: j0.o.o, reason: use source file name */
/* loaded from: classes3.dex */
public class RxJavaPlugins {
    public static final RxJavaPlugins a = new RxJavaPlugins();

    /* renamed from: b, reason: collision with root package name */
    public static final RxJavaErrorHandler f3802b = new a();
    public final AtomicReference<RxJavaErrorHandler> c = new AtomicReference<>();
    public final AtomicReference<RxJavaObservableExecutionHook> d = new AtomicReference<>();
    public final AtomicReference<RxJavaSingleExecutionHook> e = new AtomicReference<>();
    public final AtomicReference<RxJavaCompletableExecutionHook> f = new AtomicReference<>();
    public final AtomicReference<RxJavaSchedulersHook> g = new AtomicReference<>();

    /* compiled from: RxJavaPlugins.java */
    /* renamed from: j0.o.o$a */
    public static class a extends RxJavaErrorHandler {
    }

    /* compiled from: RxJavaPlugins.java */
    /* renamed from: j0.o.o$b */
    public class b extends RxJavaCompletableExecutionHook {
        public b(RxJavaPlugins rxJavaPlugins) {
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0060, code lost:
    
        r2 = "rxjava.plugin." + r7.substring(0, r7.length() - 6).substring(14) + ".impl";
        r1 = r10.getProperty(r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0087, code lost:
    
        if (r1 == null) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x00a8, code lost:
    
        throw new java.lang.IllegalStateException("Implementing class declaration for " + r0 + " missing: " + r2);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Object d(Class<?> cls, Properties properties) {
        Properties properties2 = (Properties) properties.clone();
        String simpleName = cls.getSimpleName();
        String property = properties2.getProperty("rxjava.plugin." + simpleName + ".implementation");
        if (property == null) {
            try {
                Iterator it = properties2.entrySet().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    Map.Entry entry = (Map.Entry) it.next();
                    String string = entry.getKey().toString();
                    if (string.startsWith("rxjava.plugin.") && string.endsWith(".class") && simpleName.equals(entry.getValue().toString())) {
                        break;
                    }
                }
            } catch (SecurityException e) {
                e.printStackTrace();
            }
        }
        if (property == null) {
            return null;
        }
        try {
            return Class.forName(property).asSubclass(cls).newInstance();
        } catch (ClassCastException e2) {
            throw new IllegalStateException(simpleName + " implementation is not an instance of " + simpleName + ": " + property, e2);
        } catch (ClassNotFoundException e3) {
            throw new IllegalStateException(outline.y(simpleName, " implementation class not found: ", property), e3);
        } catch (IllegalAccessException e4) {
            throw new IllegalStateException(outline.y(simpleName, " implementation not able to be accessed: ", property), e4);
        } catch (InstantiationException e5) {
            throw new IllegalStateException(outline.y(simpleName, " implementation not able to be instantiated: ", property), e5);
        }
    }

    public static Properties g() {
        try {
            return System.getProperties();
        } catch (SecurityException unused) {
            return new Properties();
        }
    }

    public RxJavaCompletableExecutionHook a() {
        if (this.f.get() == null) {
            Object objD = d(RxJavaCompletableExecutionHook.class, g());
            if (objD == null) {
                this.f.compareAndSet(null, new b(this));
            } else {
                this.f.compareAndSet(null, (RxJavaCompletableExecutionHook) objD);
            }
        }
        return this.f.get();
    }

    public RxJavaErrorHandler b() {
        if (this.c.get() == null) {
            Object objD = d(RxJavaErrorHandler.class, g());
            if (objD == null) {
                this.c.compareAndSet(null, f3802b);
            } else {
                this.c.compareAndSet(null, (RxJavaErrorHandler) objD);
            }
        }
        return this.c.get();
    }

    public RxJavaObservableExecutionHook c() {
        if (this.d.get() == null) {
            Object objD = d(RxJavaObservableExecutionHook.class, g());
            if (objD == null) {
                this.d.compareAndSet(null, RxJavaObservableExecutionHookDefault.a);
            } else {
                this.d.compareAndSet(null, (RxJavaObservableExecutionHook) objD);
            }
        }
        return this.d.get();
    }

    public RxJavaSchedulersHook e() {
        if (this.g.get() == null) {
            Object objD = d(RxJavaSchedulersHook.class, g());
            if (objD == null) {
                this.g.compareAndSet(null, RxJavaSchedulersHook.a);
            } else {
                this.g.compareAndSet(null, (RxJavaSchedulersHook) objD);
            }
        }
        return this.g.get();
    }

    public RxJavaSingleExecutionHook f() {
        if (this.e.get() == null) {
            Object objD = d(RxJavaSingleExecutionHook.class, g());
            if (objD == null) {
                this.e.compareAndSet(null, RxJavaSingleExecutionHookDefault.a);
            } else {
                this.e.compareAndSet(null, (RxJavaSingleExecutionHook) objD);
            }
        }
        return this.e.get();
    }
}
