package lombok.eclipse.agent;

import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.jar.JarFile;
import java.util.zip.ZipEntry;

/* JADX WARN: Classes with same name are omitted:
  discord:Class50/lombok/eclipse/agent/EclipseLoaderPatcherTransplants.SCL.lombok
 */
/* loaded from: discord:lombok/eclipse/agent/EclipseLoaderPatcherTransplants.SCL.lombok */
public class EclipseLoaderPatcherTransplants {
    static Class class$0;

    public static boolean overrideLoadDecide(ClassLoader original, String name, boolean resolve) {
        return name.startsWith("lombok.");
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x014c A[Catch: all -> 0x01df, Exception -> 0x025c, FINALLY_INSNS, TryCatch #0 {Exception -> 0x025c, blocks: (B:2:0x0000, B:4:0x0019, B:5:0x0021, B:6:0x0022, B:8:0x0031, B:10:0x0061, B:11:0x006f, B:12:0x008a, B:19:0x00bd, B:65:0x014c, B:66:0x0151, B:15:0x00a4, B:17:0x00b3, B:18:0x00bc, B:26:0x014c, B:27:0x0151, B:23:0x0144, B:30:0x015c, B:32:0x01db, B:35:0x01e1, B:36:0x01e2, B:39:0x01e7, B:41:0x0212, B:42:0x0218, B:45:0x022a, B:43:0x021e, B:44:0x0229, B:47:0x0255), top: B:67:0x0000, inners: #1 }] */
    /* JADX WARN: Type inference failed for: r0v29, types: [java.lang.Class, java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r0v37, types: [java.lang.String, java.lang.Throwable] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Class overrideLoadResult(ClassLoader original, String name, boolean resolve) throws NoSuchFieldException, NoSuchMethodException, SecurityException, ClassNotFoundException {
        byte[] bytes;
        int len;
        try {
            Field shadowLoaderField = original.getClass().getField("lombok$shadowLoader");
            ClassLoader shadowLoader = (ClassLoader) shadowLoaderField.get(original);
            if (shadowLoader == null) {
                synchronized ("lombok$shadowLoader$globalLock".intern()) {
                    shadowLoader = (ClassLoader) shadowLoaderField.get(original);
                    if (shadowLoader == null) {
                        Class shadowClassLoaderClass = (Class) original.getClass().getField("lombok$shadowLoaderClass").get(null);
                        Class classLoaderClass = Class.forName("java.lang.ClassLoader");
                        String jarLoc = (String) original.getClass().getField("lombok$location").get(null);
                        if (shadowClassLoaderClass == null) {
                            JarFile jf = new JarFile(jarLoc);
                            InputStream in = null;
                            try {
                                ZipEntry entry = jf.getEntry("lombok/launch/ShadowClassLoader.class");
                                in = jf.getInputStream(entry);
                                bytes = new byte[65536];
                                len = 0;
                            } finally {
                                if (in != null) {
                                }
                                jf.close();
                            }
                            do {
                                int r = in.read(bytes, len, bytes.length - len);
                                if (r != -1) {
                                    len += r;
                                } else {
                                    in.close();
                                    Class[] paramTypes = new Class[4];
                                    paramTypes[0] = "".getClass();
                                    paramTypes[1] = new byte[0].getClass();
                                    paramTypes[2] = Integer.TYPE;
                                    paramTypes[3] = paramTypes[2];
                                    Method defineClassMethod = classLoaderClass.getDeclaredMethod("defineClass", paramTypes);
                                    defineClassMethod.setAccessible(true);
                                    shadowClassLoaderClass = (Class) defineClassMethod.invoke(original, "lombok.launch.ShadowClassLoader", bytes, new Integer(0), new Integer(len));
                                    original.getClass().getField("lombok$shadowLoaderClass").set(null, shadowClassLoaderClass);
                                    if (in != null) {
                                        in.close();
                                    }
                                    jf.close();
                                }
                            } while (len != bytes.length);
                            throw new IllegalStateException("lombok.launch.ShadowClassLoader too large.");
                        }
                        Class[] paramTypes2 = new Class[5];
                        paramTypes2[0] = classLoaderClass;
                        paramTypes2[1] = "".getClass();
                        paramTypes2[2] = paramTypes2[1];
                        paramTypes2[3] = Class.forName("java.util.List");
                        paramTypes2[4] = paramTypes2[3];
                        Constructor constructor = shadowClassLoaderClass.getDeclaredConstructor(paramTypes2);
                        constructor.setAccessible(true);
                        shadowLoader = (ClassLoader) constructor.newInstance(original, "lombok", jarLoc, Arrays.asList("lombok."), Arrays.asList("lombok.patcher.Symbols"));
                        shadowLoaderField.set(original, shadowLoader);
                    }
                }
            }
            if (resolve) {
                Class[] paramTypes3 = {"".getClass(), Boolean.TYPE};
                ?? r0 = shadowLoader.getClass();
                Class[] clsArr = new Class[2];
                Class<?> cls = class$0;
                if (cls == null) {
                    try {
                        cls = Class.forName("java.lang.String");
                        class$0 = cls;
                    } catch (ClassNotFoundException unused) {
                        throw new NoClassDefFoundError(r0.getMessage());
                    }
                }
                clsArr[0] = cls;
                clsArr[1] = Boolean.TYPE;
                Method m = r0.getDeclaredMethod("loadClass", clsArr);
                m.setAccessible(true);
                return (Class) m.invoke(shadowLoader, name, Boolean.TRUE);
            }
            return shadowLoader.loadClass(name);
        } catch (Exception ex) {
            Throwable t = ex;
            if (t instanceof InvocationTargetException) {
                t = t.getCause();
            }
            if (t instanceof RuntimeException) {
                throw ((RuntimeException) t);
            }
            if (t instanceof Error) {
                throw ((Error) t);
            }
            throw new RuntimeException(t);
        }
    }
}
