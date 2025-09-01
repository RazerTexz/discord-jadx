package lombok.core;

import com.adjust.sdk.Constants;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/* loaded from: discord:lombok/core/SpiLoadUtil.SCL.lombok */
public class SpiLoadUtil {
    private SpiLoadUtil() {
    }

    public static <T> List<T> readAllFromIterator(Iterable<T> findServices) {
        List<T> list = new ArrayList<>();
        for (T t : findServices) {
            list.add(t);
        }
        return list;
    }

    public static <C> Iterable<C> findServices(Class<C> target) throws IOException {
        return findServices(target, Thread.currentThread().getContextClassLoader());
    }

    public static <C> Iterable<C> findServices(Class<C> target, ClassLoader loader) throws IOException {
        if (loader == null) {
            loader = ClassLoader.getSystemClassLoader();
        }
        Enumeration<URL> resources = loader.getResources("META-INF/services/" + target.getName());
        Set<String> entries = new LinkedHashSet<>();
        while (resources.hasMoreElements()) {
            URL url = resources.nextElement();
            readServicesFromUrl(entries, url);
        }
        Iterator<String> names = entries.iterator();
        ClassLoader fLoader = loader;
        return new AnonymousClass1(names, target, fLoader);
    }

    /* JADX INFO: Add missing generic type declarations: [C] */
    /* renamed from: lombok.core.SpiLoadUtil$1, reason: invalid class name */
    /* loaded from: discord:lombok/core/SpiLoadUtil$1.SCL.lombok */
    class AnonymousClass1<C> implements Iterable<C> {
        private final /* synthetic */ Iterator val$names;
        private final /* synthetic */ Class val$target;
        private final /* synthetic */ ClassLoader val$fLoader;

        AnonymousClass1(Iterator it, Class cls, ClassLoader classLoader) {
            this.val$names = it;
            this.val$target = cls;
            this.val$fLoader = classLoader;
        }

        /* renamed from: lombok.core.SpiLoadUtil$1$1, reason: invalid class name and collision with other inner class name */
        /* loaded from: discord:lombok/core/SpiLoadUtil$1$1.SCL.lombok */
        class C04341 implements Iterator<C> {
            private final /* synthetic */ Iterator val$names;
            private final /* synthetic */ Class val$target;
            private final /* synthetic */ ClassLoader val$fLoader;

            C04341(Iterator it, Class cls, ClassLoader classLoader) {
                this.val$names = it;
                this.val$target = cls;
                this.val$fLoader = classLoader;
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.val$names.hasNext();
            }

            @Override // java.util.Iterator
            public C next() {
                try {
                    return (C) this.val$target.cast(Class.forName((String) this.val$names.next(), true, this.val$fLoader).getConstructor(new Class[0]).newInstance(new Object[0]));
                } catch (Exception e) {
                    Exception cause = e;
                    if (cause instanceof InvocationTargetException) {
                        cause = cause.getCause();
                    }
                    if (cause instanceof RuntimeException) {
                        throw ((RuntimeException) cause);
                    }
                    if (cause instanceof Error) {
                        throw ((Error) cause);
                    }
                    throw new RuntimeException(cause);
                }
            }

            @Override // java.util.Iterator
            public void remove() {
                throw new UnsupportedOperationException();
            }
        }

        @Override // java.lang.Iterable
        public Iterator<C> iterator() {
            return new C04341(this.val$names, this.val$target, this.val$fLoader);
        }
    }

    private static void readServicesFromUrl(Collection<String> list, URL url) throws IOException {
        InputStream in = url.openStream();
        BufferedReader r = null;
        if (in != null) {
            try {
                r = new BufferedReader(new InputStreamReader(in, Constants.ENCODING));
                while (true) {
                    String line = r.readLine();
                    if (line == null) {
                        break;
                    }
                    int idx = line.indexOf(35);
                    if (idx != -1) {
                        line = line.substring(0, idx);
                    }
                    String line2 = line.trim();
                    if (line2.length() != 0) {
                        list.add(line2);
                    }
                }
                if (r != null) {
                    try {
                        r.close();
                    } catch (Throwable unused) {
                        return;
                    }
                }
                if (in != null) {
                    in.close();
                    return;
                }
                return;
            } catch (Throwable th) {
                if (r != null) {
                    try {
                        r.close();
                    } catch (Throwable unused2) {
                        throw th;
                    }
                }
                if (in != null) {
                    in.close();
                }
                throw th;
            }
        }
        if (0 != 0) {
            try {
                r.close();
            } catch (Throwable unused3) {
                return;
            }
        }
        if (in != null) {
            in.close();
        }
    }

    public static Class<? extends Annotation> findAnnotationClass(Class<?> c, Class<?> base) {
        if (c == Object.class || c == null) {
            return null;
        }
        Class<? extends Annotation> answer = findAnnotationHelper(base, c.getGenericSuperclass());
        if (answer != null) {
            return answer;
        }
        for (Type iface : c.getGenericInterfaces()) {
            Class<? extends Annotation> answer2 = findAnnotationHelper(base, iface);
            if (answer2 != null) {
                return answer2;
            }
        }
        Class<? extends Annotation> potential = findAnnotationClass(c.getSuperclass(), base);
        if (potential != null) {
            return potential;
        }
        for (Class<?> iface2 : c.getInterfaces()) {
            Class<? extends Annotation> potential2 = findAnnotationClass(iface2, base);
            if (potential2 != null) {
                return potential2;
            }
        }
        return null;
    }

    private static Class<? extends Annotation> findAnnotationHelper(Class<?> base, Type iface) {
        if (iface instanceof ParameterizedType) {
            ParameterizedType p = (ParameterizedType) iface;
            if (!base.equals(p.getRawType())) {
                return null;
            }
            Type target = p.getActualTypeArguments()[0];
            if ((target instanceof Class) && Annotation.class.isAssignableFrom((Class) target)) {
                return (Class) target;
            }
            throw new ClassCastException("Not an annotation type: " + target);
        }
        return null;
    }
}
