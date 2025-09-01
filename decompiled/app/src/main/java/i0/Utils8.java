package i0;

import b.d.b.a.outline;
import d0.z.d.Intrinsics3;
import f0.ResponseBody2;
import g0.Buffer3;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.GenericDeclaration;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Objects;
import okhttp3.MediaType;
import okhttp3.ResponseBody;

/* compiled from: Utils.java */
/* renamed from: i0.c0, reason: use source file name */
/* loaded from: classes3.dex */
public final class Utils8 {
    public static final Type[] a = new Type[0];

    /* compiled from: Utils.java */
    /* renamed from: i0.c0$a */
    public static final class a implements GenericArrayType {
        public final Type j;

        public a(Type type) {
            this.j = type;
        }

        public boolean equals(Object obj) {
            return (obj instanceof GenericArrayType) && Utils8.c(this, (GenericArrayType) obj);
        }

        @Override // java.lang.reflect.GenericArrayType
        public Type getGenericComponentType() {
            return this.j;
        }

        public int hashCode() {
            return this.j.hashCode();
        }

        public String toString() {
            return Utils8.p(this.j) + "[]";
        }
    }

    /* compiled from: Utils.java */
    /* renamed from: i0.c0$b */
    public static final class b implements ParameterizedType {
        public final Type j;
        public final Type k;
        public final Type[] l;

        public b(Type type, Type type2, Type... typeArr) {
            if (type2 instanceof Class) {
                if ((type == null) != (((Class) type2).getEnclosingClass() == null)) {
                    throw new IllegalArgumentException();
                }
            }
            for (Type type3 : typeArr) {
                Objects.requireNonNull(type3, "typeArgument == null");
                Utils8.b(type3);
            }
            this.j = type;
            this.k = type2;
            this.l = (Type[]) typeArr.clone();
        }

        public boolean equals(Object obj) {
            return (obj instanceof ParameterizedType) && Utils8.c(this, (ParameterizedType) obj);
        }

        @Override // java.lang.reflect.ParameterizedType
        public Type[] getActualTypeArguments() {
            return (Type[]) this.l.clone();
        }

        @Override // java.lang.reflect.ParameterizedType
        public Type getOwnerType() {
            return this.j;
        }

        @Override // java.lang.reflect.ParameterizedType
        public Type getRawType() {
            return this.k;
        }

        public int hashCode() {
            int iHashCode = Arrays.hashCode(this.l) ^ this.k.hashCode();
            Type type = this.j;
            return iHashCode ^ (type != null ? type.hashCode() : 0);
        }

        public String toString() {
            Type[] typeArr = this.l;
            if (typeArr.length == 0) {
                return Utils8.p(this.k);
            }
            StringBuilder sb = new StringBuilder((typeArr.length + 1) * 30);
            sb.append(Utils8.p(this.k));
            sb.append("<");
            sb.append(Utils8.p(this.l[0]));
            for (int i = 1; i < this.l.length; i++) {
                sb.append(", ");
                sb.append(Utils8.p(this.l[i]));
            }
            sb.append(">");
            return sb.toString();
        }
    }

    /* compiled from: Utils.java */
    /* renamed from: i0.c0$c */
    public static final class c implements WildcardType {
        public final Type j;
        public final Type k;

        public c(Type[] typeArr, Type[] typeArr2) {
            if (typeArr2.length > 1) {
                throw new IllegalArgumentException();
            }
            if (typeArr.length != 1) {
                throw new IllegalArgumentException();
            }
            if (typeArr2.length != 1) {
                Objects.requireNonNull(typeArr[0]);
                Utils8.b(typeArr[0]);
                this.k = null;
                this.j = typeArr[0];
                return;
            }
            Objects.requireNonNull(typeArr2[0]);
            Utils8.b(typeArr2[0]);
            if (typeArr[0] != Object.class) {
                throw new IllegalArgumentException();
            }
            this.k = typeArr2[0];
            this.j = Object.class;
        }

        public boolean equals(Object obj) {
            return (obj instanceof WildcardType) && Utils8.c(this, (WildcardType) obj);
        }

        @Override // java.lang.reflect.WildcardType
        public Type[] getLowerBounds() {
            Type type = this.k;
            return type != null ? new Type[]{type} : Utils8.a;
        }

        @Override // java.lang.reflect.WildcardType
        public Type[] getUpperBounds() {
            return new Type[]{this.j};
        }

        public int hashCode() {
            Type type = this.k;
            return (type != null ? type.hashCode() + 31 : 1) ^ (this.j.hashCode() + 31);
        }

        public String toString() {
            if (this.k != null) {
                StringBuilder sbU = outline.U("? super ");
                sbU.append(Utils8.p(this.k));
                return sbU.toString();
            }
            if (this.j == Object.class) {
                return "?";
            }
            StringBuilder sbU2 = outline.U("? extends ");
            sbU2.append(Utils8.p(this.j));
            return sbU2.toString();
        }
    }

    public static ResponseBody a(ResponseBody responseBody) throws IOException {
        Buffer3 buffer3 = new Buffer3();
        responseBody.c().k0(buffer3);
        MediaType mediaTypeB = responseBody.b();
        long jA = responseBody.a();
        Intrinsics3.checkParameterIsNotNull(buffer3, "content");
        Intrinsics3.checkParameterIsNotNull(buffer3, "$this$asResponseBody");
        return new ResponseBody2(buffer3, mediaTypeB, jA);
    }

    public static void b(Type type) {
        if ((type instanceof Class) && ((Class) type).isPrimitive()) {
            throw new IllegalArgumentException();
        }
    }

    public static boolean c(Type type, Type type2) {
        if (type == type2) {
            return true;
        }
        if (type instanceof Class) {
            return type.equals(type2);
        }
        if (type instanceof ParameterizedType) {
            if (!(type2 instanceof ParameterizedType)) {
                return false;
            }
            ParameterizedType parameterizedType = (ParameterizedType) type;
            ParameterizedType parameterizedType2 = (ParameterizedType) type2;
            Type ownerType = parameterizedType.getOwnerType();
            Type ownerType2 = parameterizedType2.getOwnerType();
            return (ownerType == ownerType2 || (ownerType != null && ownerType.equals(ownerType2))) && parameterizedType.getRawType().equals(parameterizedType2.getRawType()) && Arrays.equals(parameterizedType.getActualTypeArguments(), parameterizedType2.getActualTypeArguments());
        }
        if (type instanceof GenericArrayType) {
            if (type2 instanceof GenericArrayType) {
                return c(((GenericArrayType) type).getGenericComponentType(), ((GenericArrayType) type2).getGenericComponentType());
            }
            return false;
        }
        if (type instanceof WildcardType) {
            if (!(type2 instanceof WildcardType)) {
                return false;
            }
            WildcardType wildcardType = (WildcardType) type;
            WildcardType wildcardType2 = (WildcardType) type2;
            return Arrays.equals(wildcardType.getUpperBounds(), wildcardType2.getUpperBounds()) && Arrays.equals(wildcardType.getLowerBounds(), wildcardType2.getLowerBounds());
        }
        if (!(type instanceof TypeVariable) || !(type2 instanceof TypeVariable)) {
            return false;
        }
        TypeVariable typeVariable = (TypeVariable) type;
        TypeVariable typeVariable2 = (TypeVariable) type2;
        return typeVariable.getGenericDeclaration() == typeVariable2.getGenericDeclaration() && typeVariable.getName().equals(typeVariable2.getName());
    }

    public static Type d(Type type, Class<?> cls, Class<?> cls2) {
        if (cls2 == cls) {
            return type;
        }
        if (cls2.isInterface()) {
            Class<?>[] interfaces = cls.getInterfaces();
            int length = interfaces.length;
            for (int i = 0; i < length; i++) {
                if (interfaces[i] == cls2) {
                    return cls.getGenericInterfaces()[i];
                }
                if (cls2.isAssignableFrom(interfaces[i])) {
                    return d(cls.getGenericInterfaces()[i], interfaces[i], cls2);
                }
            }
        }
        if (!cls.isInterface()) {
            while (cls != Object.class) {
                Class<? super Object> superclass = cls.getSuperclass();
                if (superclass == cls2) {
                    return cls.getGenericSuperclass();
                }
                if (cls2.isAssignableFrom(superclass)) {
                    return d(cls.getGenericSuperclass(), superclass, cls2);
                }
                cls = superclass;
            }
        }
        return cls2;
    }

    public static Type e(int i, ParameterizedType parameterizedType) {
        Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
        if (i >= 0 && i < actualTypeArguments.length) {
            Type type = actualTypeArguments[i];
            return type instanceof WildcardType ? ((WildcardType) type).getUpperBounds()[0] : type;
        }
        StringBuilder sbV = outline.V("Index ", i, " not in range [0,");
        sbV.append(actualTypeArguments.length);
        sbV.append(") for ");
        sbV.append(parameterizedType);
        throw new IllegalArgumentException(sbV.toString());
    }

    public static Class<?> f(Type type) {
        Objects.requireNonNull(type, "type == null");
        if (type instanceof Class) {
            return (Class) type;
        }
        if (type instanceof ParameterizedType) {
            Type rawType = ((ParameterizedType) type).getRawType();
            if (rawType instanceof Class) {
                return (Class) rawType;
            }
            throw new IllegalArgumentException();
        }
        if (type instanceof GenericArrayType) {
            return Array.newInstance(f(((GenericArrayType) type).getGenericComponentType()), 0).getClass();
        }
        if (type instanceof TypeVariable) {
            return Object.class;
        }
        if (type instanceof WildcardType) {
            return f(((WildcardType) type).getUpperBounds()[0]);
        }
        throw new IllegalArgumentException("Expected a Class, ParameterizedType, or GenericArrayType, but <" + type + "> is of type " + type.getClass().getName());
    }

    public static Type g(Type type, Class<?> cls, Class<?> cls2) {
        if (cls2.isAssignableFrom(cls)) {
            return n(type, cls, d(type, cls, cls2));
        }
        throw new IllegalArgumentException();
    }

    public static boolean h(Type type) {
        if (type instanceof Class) {
            return false;
        }
        if (type instanceof ParameterizedType) {
            for (Type type2 : ((ParameterizedType) type).getActualTypeArguments()) {
                if (h(type2)) {
                    return true;
                }
            }
            return false;
        }
        if (type instanceof GenericArrayType) {
            return h(((GenericArrayType) type).getGenericComponentType());
        }
        if ((type instanceof TypeVariable) || (type instanceof WildcardType)) {
            return true;
        }
        throw new IllegalArgumentException("Expected a Class, ParameterizedType, or GenericArrayType, but <" + type + "> is of type " + (type == null ? "null" : type.getClass().getName()));
    }

    public static boolean i(Annotation[] annotationArr, Class<? extends Annotation> cls) {
        for (Annotation annotation : annotationArr) {
            if (cls.isInstance(annotation)) {
                return true;
            }
        }
        return false;
    }

    public static RuntimeException j(Method method, String str, Object... objArr) {
        return k(method, null, str, objArr);
    }

    public static RuntimeException k(Method method, Throwable th, String str, Object... objArr) {
        StringBuilder sbX = outline.X(String.format(str, objArr), "\n    for method ");
        sbX.append(method.getDeclaringClass().getSimpleName());
        sbX.append(".");
        sbX.append(method.getName());
        return new IllegalArgumentException(sbX.toString(), th);
    }

    public static RuntimeException l(Method method, int i, String str, Object... objArr) {
        StringBuilder sbX = outline.X(str, " (parameter #");
        sbX.append(i + 1);
        sbX.append(")");
        return j(method, sbX.toString(), objArr);
    }

    public static RuntimeException m(Method method, Throwable th, int i, String str, Object... objArr) {
        StringBuilder sbX = outline.X(str, " (parameter #");
        sbX.append(i + 1);
        sbX.append(")");
        return k(method, th, sbX.toString(), objArr);
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x003f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Type n(Type type, Class<?> cls, Type type2) {
        Type type3;
        Type type4 = type2;
        while (true) {
            int i = 0;
            if (!(type4 instanceof TypeVariable)) {
                if (type4 instanceof Class) {
                    Class cls2 = (Class) type4;
                    if (cls2.isArray()) {
                        Class<?> componentType = cls2.getComponentType();
                        Type typeN = n(type, cls, componentType);
                        return componentType == typeN ? cls2 : new a(typeN);
                    }
                }
                if (type4 instanceof GenericArrayType) {
                    GenericArrayType genericArrayType = (GenericArrayType) type4;
                    Type genericComponentType = genericArrayType.getGenericComponentType();
                    Type typeN2 = n(type, cls, genericComponentType);
                    return genericComponentType == typeN2 ? genericArrayType : new a(typeN2);
                }
                if (type4 instanceof ParameterizedType) {
                    ParameterizedType parameterizedType = (ParameterizedType) type4;
                    Type ownerType = parameterizedType.getOwnerType();
                    Type typeN3 = n(type, cls, ownerType);
                    boolean z2 = typeN3 != ownerType;
                    Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
                    int length = actualTypeArguments.length;
                    while (i < length) {
                        Type typeN4 = n(type, cls, actualTypeArguments[i]);
                        if (typeN4 != actualTypeArguments[i]) {
                            if (!z2) {
                                actualTypeArguments = (Type[]) actualTypeArguments.clone();
                                z2 = true;
                            }
                            actualTypeArguments[i] = typeN4;
                        }
                        i++;
                    }
                    return z2 ? new b(typeN3, parameterizedType.getRawType(), actualTypeArguments) : parameterizedType;
                }
                boolean z3 = type4 instanceof WildcardType;
                Type type5 = type4;
                if (z3) {
                    WildcardType wildcardType = (WildcardType) type4;
                    Type[] lowerBounds = wildcardType.getLowerBounds();
                    Type[] upperBounds = wildcardType.getUpperBounds();
                    if (lowerBounds.length == 1) {
                        Type typeN5 = n(type, cls, lowerBounds[0]);
                        type5 = wildcardType;
                        if (typeN5 != lowerBounds[0]) {
                            return new c(new Type[]{Object.class}, new Type[]{typeN5});
                        }
                    } else {
                        type5 = wildcardType;
                        if (upperBounds.length == 1) {
                            Type typeN6 = n(type, cls, upperBounds[0]);
                            type5 = wildcardType;
                            if (typeN6 != upperBounds[0]) {
                                return new c(new Type[]{typeN6}, a);
                            }
                        }
                    }
                }
                return type5;
            }
            TypeVariable typeVariable = (TypeVariable) type4;
            GenericDeclaration genericDeclaration = typeVariable.getGenericDeclaration();
            Class cls3 = genericDeclaration instanceof Class ? (Class) genericDeclaration : null;
            if (cls3 == null) {
                type3 = typeVariable;
            } else {
                Type typeD = d(type, cls, cls3);
                if (typeD instanceof ParameterizedType) {
                    TypeVariable[] typeParameters = cls3.getTypeParameters();
                    while (i < typeParameters.length) {
                        if (typeVariable.equals(typeParameters[i])) {
                            type3 = ((ParameterizedType) typeD).getActualTypeArguments()[i];
                        } else {
                            i++;
                        }
                    }
                    throw new NoSuchElementException();
                }
            }
            if (type3 == typeVariable) {
                return type3;
            }
            type4 = type3;
        }
    }

    public static void o(Throwable th) {
        if (th instanceof VirtualMachineError) {
            throw ((VirtualMachineError) th);
        }
        if (th instanceof ThreadDeath) {
            throw ((ThreadDeath) th);
        }
        if (th instanceof LinkageError) {
            throw ((LinkageError) th);
        }
    }

    public static String p(Type type) {
        return type instanceof Class ? ((Class) type).getName() : type.toString();
    }
}
