package d0.e0.p.d.m0.c.k1.b;

import d0.e0.p.d.m0.e.a.k0.javaTypes5;
import d0.e0.p.d.m0.g.FqName;
import d0.z.d.Intrinsics3;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: ReflectJavaType.kt */
/* renamed from: d0.e0.p.d.m0.c.k1.b.w, reason: use source file name */
/* loaded from: classes3.dex */
public abstract class ReflectJavaType implements javaTypes5 {
    public static final a a = new a(null);

    /* compiled from: ReflectJavaType.kt */
    /* renamed from: d0.e0.p.d.m0.c.k1.b.w$a */
    public static final class a {
        public a(DefaultConstructorMarker defaultConstructorMarker) {
        }

        public final ReflectJavaType create(Type type) {
            Intrinsics3.checkNotNullParameter(type, "type");
            boolean z2 = type instanceof Class;
            if (z2) {
                Class cls = (Class) type;
                if (cls.isPrimitive()) {
                    return new ReflectJavaPrimitiveType(cls);
                }
            }
            return ((type instanceof GenericArrayType) || (z2 && ((Class) type).isArray())) ? new ReflectJavaArrayType(type) : type instanceof WildcardType ? new ReflectJavaWildcardType((WildcardType) type) : new ReflectJavaClassifierType(type);
        }
    }

    public boolean equals(Object obj) {
        return (obj instanceof ReflectJavaType) && Intrinsics3.areEqual(getReflectType(), ((ReflectJavaType) obj).getReflectType());
    }

    @Override // d0.e0.p.d.m0.e.a.k0.d
    public d0.e0.p.d.m0.e.a.k0.a findAnnotation(FqName fqName) {
        return javaTypes5.a.findAnnotation(this, fqName);
    }

    public abstract Type getReflectType();

    public int hashCode() {
        return getReflectType().hashCode();
    }

    public String toString() {
        return getClass().getName() + ": " + getReflectType();
    }
}
