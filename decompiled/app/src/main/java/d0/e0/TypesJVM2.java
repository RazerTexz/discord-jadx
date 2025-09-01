package d0.e0;

import d0.t._Arrays;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import kotlin.jvm.functions.Function1;

/* compiled from: TypesJVM.kt */
/* renamed from: d0.e0.k, reason: use source file name */
/* loaded from: classes3.dex */
public final class TypesJVM2 implements ParameterizedType, Type {
    public final Type[] j;
    public final Class<?> k;
    public final Type l;

    /* compiled from: TypesJVM.kt */
    /* renamed from: d0.e0.k$a */
    public static final /* synthetic */ class a extends FunctionReferenceImpl implements Function1<Type, String> {
        public static final a j = new a();

        public a() {
            super(1, TypesJVM5.class, "typeToString", "typeToString(Ljava/lang/reflect/Type;)Ljava/lang/String;", 1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ String invoke(Type type) {
            return invoke2(type);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final String invoke2(Type type) {
            Intrinsics3.checkNotNullParameter(type, "p1");
            return TypesJVM5.access$typeToString(type);
        }
    }

    public TypesJVM2(Class<?> cls, Type type, List<? extends Type> list) {
        Intrinsics3.checkNotNullParameter(cls, "rawType");
        Intrinsics3.checkNotNullParameter(list, "typeArguments");
        this.k = cls;
        this.l = type;
        Object[] array = list.toArray(new Type[0]);
        Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
        this.j = (Type[]) array;
    }

    public boolean equals(Object obj) {
        if (obj instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) obj;
            if (Intrinsics3.areEqual(this.k, parameterizedType.getRawType()) && Intrinsics3.areEqual(this.l, parameterizedType.getOwnerType()) && Arrays.equals(getActualTypeArguments(), parameterizedType.getActualTypeArguments())) {
                return true;
            }
        }
        return false;
    }

    @Override // java.lang.reflect.ParameterizedType
    public Type[] getActualTypeArguments() {
        return this.j;
    }

    @Override // java.lang.reflect.ParameterizedType
    public Type getOwnerType() {
        return this.l;
    }

    @Override // java.lang.reflect.ParameterizedType
    public Type getRawType() {
        return this.k;
    }

    @Override // java.lang.reflect.Type
    public String getTypeName() {
        StringBuilder sb = new StringBuilder();
        Type type = this.l;
        if (type != null) {
            sb.append(TypesJVM5.access$typeToString(type));
            sb.append("$");
            sb.append(this.k.getSimpleName());
        } else {
            sb.append(TypesJVM5.access$typeToString(this.k));
        }
        Type[] typeArr = this.j;
        if (!(typeArr.length == 0)) {
            _Arrays.joinTo$default(typeArr, sb, null, "<", ">", 0, null, a.j, 50, null);
        }
        String string = sb.toString();
        Intrinsics3.checkNotNullExpressionValue(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }

    public int hashCode() {
        int iHashCode = this.k.hashCode();
        Type type = this.l;
        return (iHashCode ^ (type != null ? type.hashCode() : 0)) ^ Arrays.hashCode(getActualTypeArguments());
    }

    public String toString() {
        return getTypeName();
    }
}
