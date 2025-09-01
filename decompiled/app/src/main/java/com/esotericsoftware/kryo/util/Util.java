package com.esotericsoftware.kryo.util;

import b.e.a.Log;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes.dex */
public class Util {
    public static final boolean IS_ANDROID;
    private static final ConcurrentHashMap<String, Boolean> classAvailabilities;

    @Deprecated
    public static boolean isAndroid;

    static {
        boolean zEquals = "Dalvik".equals(System.getProperty("java.vm.name"));
        IS_ANDROID = zEquals;
        isAndroid = zEquals;
        classAvailabilities = new ConcurrentHashMap<>();
    }

    public static String className(Class cls) {
        if (!cls.isArray()) {
            return (cls.isPrimitive() || cls == Object.class || cls == Boolean.class || cls == Byte.class || cls == Character.class || cls == Short.class || cls == Integer.class || cls == Long.class || cls == Float.class || cls == Double.class || cls == String.class) ? cls.getSimpleName() : cls.getName();
        }
        Class elementClass = getElementClass(cls);
        StringBuilder sb = new StringBuilder(16);
        int dimensionCount = getDimensionCount(cls);
        for (int i = 0; i < dimensionCount; i++) {
            sb.append("[]");
        }
        return className(elementClass) + ((Object) sb);
    }

    public static int getDimensionCount(Class cls) {
        int i = 0;
        for (Class<?> componentType = cls.getComponentType(); componentType != null; componentType = componentType.getComponentType()) {
            i++;
        }
        return i;
    }

    public static Class getElementClass(Class cls) {
        while (cls.getComponentType() != null) {
            cls = cls.getComponentType();
        }
        return cls;
    }

    public static Class getPrimitiveClass(Class cls) {
        return cls == Integer.class ? Integer.TYPE : cls == Float.class ? Float.TYPE : cls == Boolean.class ? Boolean.TYPE : cls == Long.class ? Long.TYPE : cls == Byte.class ? Byte.TYPE : cls == Character.class ? Character.TYPE : cls == Short.class ? Short.TYPE : cls == Double.class ? Double.TYPE : cls == Void.class ? Void.TYPE : cls;
    }

    public static Class getWrapperClass(Class cls) {
        return cls == Integer.TYPE ? Integer.class : cls == Float.TYPE ? Float.class : cls == Boolean.TYPE ? Boolean.class : cls == Long.TYPE ? Long.class : cls == Byte.TYPE ? Byte.class : cls == Character.TYPE ? Character.class : cls == Short.TYPE ? Short.class : cls == Double.TYPE ? Double.class : Void.class;
    }

    public static boolean isClassAvailable(String str) throws ClassNotFoundException {
        Boolean bool = classAvailabilities.get(str);
        if (bool == null) {
            try {
                Class.forName(str);
                bool = Boolean.TRUE;
            } catch (Exception unused) {
                Log.a aVar = Log.a;
                bool = Boolean.FALSE;
            }
            classAvailabilities.put(str, bool);
        }
        return bool.booleanValue();
    }

    public static boolean isWrapperClass(Class cls) {
        return cls == Integer.class || cls == Float.class || cls == Boolean.class || cls == Long.class || cls == Byte.class || cls == Character.class || cls == Short.class || cls == Double.class;
    }

    public static void log(String str, Object obj) {
        if (obj == null) {
            Log.a aVar = Log.a;
            return;
        }
        Class<?> cls = obj.getClass();
        if (cls.isPrimitive() || cls == Boolean.class || cls == Byte.class || cls == Character.class || cls == Short.class || cls == Integer.class || cls == Long.class || cls == Float.class || cls == Double.class || cls == String.class) {
            Log.a aVar2 = Log.a;
        } else {
            string(obj);
            Log.a aVar3 = Log.a;
        }
    }

    public static String string(Object obj) {
        if (obj == null) {
            return "null";
        }
        Class<?> cls = obj.getClass();
        if (cls.isArray()) {
            return className(cls);
        }
        try {
            if (cls.getMethod("toString", new Class[0]).getDeclaringClass() == Object.class) {
                Log.a aVar = Log.a;
                return cls.getSimpleName();
            }
        } catch (Exception unused) {
        }
        try {
            return String.valueOf(obj);
        } catch (Throwable th) {
            StringBuilder sb = new StringBuilder();
            Log.a aVar2 = Log.a;
            sb.append(cls.getSimpleName());
            sb.append("(Exception ");
            sb.append(th);
            sb.append(" in toString)");
            return sb.toString();
        }
    }

    public static int swapInt(int i) {
        return ((i >> 24) & 255) | ((i & 255) << 24) | ((65280 & i) << 8) | ((16711680 & i) >> 8);
    }

    public static long swapLong(long j) {
        return (((j >> 56) & 255) << 0) | (((j >> 0) & 255) << 56) | (((j >> 8) & 255) << 48) | (((j >> 16) & 255) << 40) | (((j >> 24) & 255) << 32) | (((j >> 32) & 255) << 24) | (((j >> 40) & 255) << 16) | (((j >> 48) & 255) << 8);
    }
}
