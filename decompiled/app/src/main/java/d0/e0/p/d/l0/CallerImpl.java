package d0.e0.p.d.l0;

import d0.e0.p.d.l0.Caller2;
import d0.t.Collections2;
import d0.t._Arrays;
import d0.t._ArraysJvm;
import d0.z.d.Intrinsics3;
import d0.z.d.SpreadBuilder;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: CallerImpl.kt */
/* renamed from: d0.e0.p.d.l0.e, reason: use source file name */
/* loaded from: classes3.dex */
public abstract class CallerImpl<M extends Member> implements Caller2<M> {
    public static final d a = new d(null);

    /* renamed from: b, reason: collision with root package name */
    public final List<Type> f3204b;
    public final M c;
    public final Type d;
    public final Class<?> e;

    /* compiled from: CallerImpl.kt */
    /* renamed from: d0.e0.p.d.l0.e$a */
    public static final class a extends CallerImpl<Constructor<?>> implements Caller {
        public final Object f;

        /* JADX WARN: Illegal instructions before constructor call */
        public a(Constructor<?> constructor, Object obj) {
            Object[] objArr;
            Intrinsics3.checkNotNullParameter(constructor, "constructor");
            Class<?> declaringClass = constructor.getDeclaringClass();
            Intrinsics3.checkNotNullExpressionValue(declaringClass, "constructor.declaringClass");
            Type[] genericParameterTypes = constructor.getGenericParameterTypes();
            Intrinsics3.checkNotNullExpressionValue(genericParameterTypes, "constructor.genericParameterTypes");
            if (genericParameterTypes.length <= 2) {
                objArr = new Type[0];
            } else {
                Object[] objArrCopyOfRange = _ArraysJvm.copyOfRange(genericParameterTypes, 1, genericParameterTypes.length - 1);
                Objects.requireNonNull(objArrCopyOfRange, "null cannot be cast to non-null type kotlin.Array<T>");
                objArr = objArrCopyOfRange;
            }
            super(constructor, declaringClass, null, (Type[]) objArr, null);
            this.f = obj;
        }

        @Override // d0.e0.p.d.l0.Caller2
        public Object call(Object[] objArr) {
            Intrinsics3.checkNotNullParameter(objArr, "args");
            checkArguments(objArr);
            Constructor<?> constructorMo80getMember = mo80getMember();
            SpreadBuilder spreadBuilder = new SpreadBuilder(3);
            spreadBuilder.add(this.f);
            spreadBuilder.addSpread(objArr);
            spreadBuilder.add(null);
            return constructorMo80getMember.newInstance(spreadBuilder.toArray(new Object[spreadBuilder.size()]));
        }
    }

    /* compiled from: CallerImpl.kt */
    /* renamed from: d0.e0.p.d.l0.e$b */
    public static final class b extends CallerImpl<Constructor<?>> {
        /* JADX WARN: Illegal instructions before constructor call */
        public b(Constructor<?> constructor) {
            Object[] objArr;
            Intrinsics3.checkNotNullParameter(constructor, "constructor");
            Class<?> declaringClass = constructor.getDeclaringClass();
            Intrinsics3.checkNotNullExpressionValue(declaringClass, "constructor.declaringClass");
            Type[] genericParameterTypes = constructor.getGenericParameterTypes();
            Intrinsics3.checkNotNullExpressionValue(genericParameterTypes, "constructor.genericParameterTypes");
            if (genericParameterTypes.length <= 1) {
                objArr = new Type[0];
            } else {
                Object[] objArrCopyOfRange = _ArraysJvm.copyOfRange(genericParameterTypes, 0, genericParameterTypes.length - 1);
                Objects.requireNonNull(objArrCopyOfRange, "null cannot be cast to non-null type kotlin.Array<T>");
                objArr = objArrCopyOfRange;
            }
            super(constructor, declaringClass, null, (Type[]) objArr, null);
        }

        @Override // d0.e0.p.d.l0.Caller2
        public Object call(Object[] objArr) {
            Intrinsics3.checkNotNullParameter(objArr, "args");
            checkArguments(objArr);
            Constructor<?> constructorMo80getMember = mo80getMember();
            SpreadBuilder spreadBuilder = new SpreadBuilder(2);
            spreadBuilder.addSpread(objArr);
            spreadBuilder.add(null);
            return constructorMo80getMember.newInstance(spreadBuilder.toArray(new Object[spreadBuilder.size()]));
        }
    }

    /* compiled from: CallerImpl.kt */
    /* renamed from: d0.e0.p.d.l0.e$c */
    public static final class c extends CallerImpl<Constructor<?>> implements Caller {
        public final Object f;

        /* JADX WARN: Illegal instructions before constructor call */
        public c(Constructor<?> constructor, Object obj) {
            Intrinsics3.checkNotNullParameter(constructor, "constructor");
            Class<?> declaringClass = constructor.getDeclaringClass();
            Intrinsics3.checkNotNullExpressionValue(declaringClass, "constructor.declaringClass");
            Type[] genericParameterTypes = constructor.getGenericParameterTypes();
            Intrinsics3.checkNotNullExpressionValue(genericParameterTypes, "constructor.genericParameterTypes");
            super(constructor, declaringClass, null, genericParameterTypes, null);
            this.f = obj;
        }

        @Override // d0.e0.p.d.l0.Caller2
        public Object call(Object[] objArr) {
            Intrinsics3.checkNotNullParameter(objArr, "args");
            checkArguments(objArr);
            Constructor<?> constructorMo80getMember = mo80getMember();
            SpreadBuilder spreadBuilder = new SpreadBuilder(2);
            spreadBuilder.add(this.f);
            spreadBuilder.addSpread(objArr);
            return constructorMo80getMember.newInstance(spreadBuilder.toArray(new Object[spreadBuilder.size()]));
        }
    }

    /* compiled from: CallerImpl.kt */
    /* renamed from: d0.e0.p.d.l0.e$d */
    public static final class d {
        public d(DefaultConstructorMarker defaultConstructorMarker) {
        }
    }

    /* compiled from: CallerImpl.kt */
    /* renamed from: d0.e0.p.d.l0.e$e */
    public static final class e extends CallerImpl<Constructor<?>> {
        /* JADX WARN: Illegal instructions before constructor call */
        public e(Constructor<?> constructor) {
            Intrinsics3.checkNotNullParameter(constructor, "constructor");
            Class<?> declaringClass = constructor.getDeclaringClass();
            Intrinsics3.checkNotNullExpressionValue(declaringClass, "constructor.declaringClass");
            Class<?> declaringClass2 = constructor.getDeclaringClass();
            Intrinsics3.checkNotNullExpressionValue(declaringClass2, "klass");
            Class<?> declaringClass3 = declaringClass2.getDeclaringClass();
            Class<?> cls = (declaringClass3 == null || Modifier.isStatic(declaringClass2.getModifiers())) ? null : declaringClass3;
            Type[] genericParameterTypes = constructor.getGenericParameterTypes();
            Intrinsics3.checkNotNullExpressionValue(genericParameterTypes, "constructor.genericParameterTypes");
            super(constructor, declaringClass, cls, genericParameterTypes, null);
        }

        @Override // d0.e0.p.d.l0.Caller2
        public Object call(Object[] objArr) {
            Intrinsics3.checkNotNullParameter(objArr, "args");
            checkArguments(objArr);
            return mo80getMember().newInstance(Arrays.copyOf(objArr, objArr.length));
        }
    }

    /* compiled from: CallerImpl.kt */
    /* renamed from: d0.e0.p.d.l0.e$f */
    public static abstract class f extends CallerImpl<Field> {

        /* compiled from: CallerImpl.kt */
        /* renamed from: d0.e0.p.d.l0.e$f$a */
        public static final class a extends f implements Caller {
            public final Object f;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(Field field, Object obj) {
                super(field, false, null);
                Intrinsics3.checkNotNullParameter(field, "field");
                this.f = obj;
            }

            @Override // d0.e0.p.d.l0.CallerImpl.f, d0.e0.p.d.l0.Caller2
            public Object call(Object[] objArr) {
                Intrinsics3.checkNotNullParameter(objArr, "args");
                checkArguments(objArr);
                return mo80getMember().get(this.f);
            }
        }

        /* compiled from: CallerImpl.kt */
        /* renamed from: d0.e0.p.d.l0.e$f$b */
        public static final class b extends f implements Caller {
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public b(Field field) {
                super(field, false, null);
                Intrinsics3.checkNotNullParameter(field, "field");
            }
        }

        /* compiled from: CallerImpl.kt */
        /* renamed from: d0.e0.p.d.l0.e$f$c */
        public static final class c extends f {
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public c(Field field) {
                super(field, true, null);
                Intrinsics3.checkNotNullParameter(field, "field");
            }
        }

        /* compiled from: CallerImpl.kt */
        /* renamed from: d0.e0.p.d.l0.e$f$d */
        public static final class d extends f {
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public d(Field field) {
                super(field, true, null);
                Intrinsics3.checkNotNullParameter(field, "field");
            }

            @Override // d0.e0.p.d.l0.CallerImpl
            public void checkArguments(Object[] objArr) {
                Intrinsics3.checkNotNullParameter(objArr, "args");
                super.checkArguments(objArr);
                a(_Arrays.firstOrNull(objArr));
            }
        }

        /* compiled from: CallerImpl.kt */
        /* renamed from: d0.e0.p.d.l0.e$f$e */
        public static final class e extends f {
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public e(Field field) {
                super(field, false, null);
                Intrinsics3.checkNotNullParameter(field, "field");
            }
        }

        /* JADX WARN: Illegal instructions before constructor call */
        public f(Field field, boolean z2, DefaultConstructorMarker defaultConstructorMarker) {
            Type genericType = field.getGenericType();
            Intrinsics3.checkNotNullExpressionValue(genericType, "field.genericType");
            super(field, genericType, z2 ? field.getDeclaringClass() : null, new Type[0], null);
        }

        @Override // d0.e0.p.d.l0.Caller2
        public Object call(Object[] objArr) {
            Intrinsics3.checkNotNullParameter(objArr, "args");
            checkArguments(objArr);
            return mo80getMember().get(getInstanceClass() != null ? _Arrays.first(objArr) : null);
        }
    }

    /* compiled from: CallerImpl.kt */
    /* renamed from: d0.e0.p.d.l0.e$g */
    public static abstract class g extends CallerImpl<Field> {
        public final boolean f;

        /* compiled from: CallerImpl.kt */
        /* renamed from: d0.e0.p.d.l0.e$g$a */
        public static final class a extends g implements Caller {
            public final Object g;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(Field field, boolean z2, Object obj) {
                super(field, z2, false, null);
                Intrinsics3.checkNotNullParameter(field, "field");
                this.g = obj;
            }

            @Override // d0.e0.p.d.l0.CallerImpl.g, d0.e0.p.d.l0.Caller2
            public Object call(Object[] objArr) throws IllegalAccessException, IllegalArgumentException {
                Intrinsics3.checkNotNullParameter(objArr, "args");
                checkArguments(objArr);
                mo80getMember().set(this.g, _Arrays.first(objArr));
                return Unit.a;
            }
        }

        /* compiled from: CallerImpl.kt */
        /* renamed from: d0.e0.p.d.l0.e$g$b */
        public static final class b extends g implements Caller {
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public b(Field field, boolean z2) {
                super(field, z2, false, null);
                Intrinsics3.checkNotNullParameter(field, "field");
            }

            @Override // d0.e0.p.d.l0.CallerImpl.g, d0.e0.p.d.l0.Caller2
            public Object call(Object[] objArr) throws IllegalAccessException, IllegalArgumentException {
                Intrinsics3.checkNotNullParameter(objArr, "args");
                checkArguments(objArr);
                mo80getMember().set(null, _Arrays.last(objArr));
                return Unit.a;
            }
        }

        /* compiled from: CallerImpl.kt */
        /* renamed from: d0.e0.p.d.l0.e$g$c */
        public static final class c extends g {
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public c(Field field, boolean z2) {
                super(field, z2, true, null);
                Intrinsics3.checkNotNullParameter(field, "field");
            }
        }

        /* compiled from: CallerImpl.kt */
        /* renamed from: d0.e0.p.d.l0.e$g$d */
        public static final class d extends g {
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public d(Field field, boolean z2) {
                super(field, z2, true, null);
                Intrinsics3.checkNotNullParameter(field, "field");
            }

            @Override // d0.e0.p.d.l0.CallerImpl.g, d0.e0.p.d.l0.CallerImpl
            public void checkArguments(Object[] objArr) {
                Intrinsics3.checkNotNullParameter(objArr, "args");
                super.checkArguments(objArr);
                a(_Arrays.firstOrNull(objArr));
            }
        }

        /* compiled from: CallerImpl.kt */
        /* renamed from: d0.e0.p.d.l0.e$g$e */
        public static final class e extends g {
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public e(Field field, boolean z2) {
                super(field, z2, false, null);
                Intrinsics3.checkNotNullParameter(field, "field");
            }
        }

        /* JADX WARN: Illegal instructions before constructor call */
        public g(Field field, boolean z2, boolean z3, DefaultConstructorMarker defaultConstructorMarker) {
            Class cls = Void.TYPE;
            Intrinsics3.checkNotNullExpressionValue(cls, "Void.TYPE");
            Class<?> declaringClass = z3 ? field.getDeclaringClass() : null;
            Type genericType = field.getGenericType();
            Intrinsics3.checkNotNullExpressionValue(genericType, "field.genericType");
            super(field, cls, declaringClass, new Type[]{genericType}, null);
            this.f = z2;
        }

        @Override // d0.e0.p.d.l0.Caller2
        public Object call(Object[] objArr) throws IllegalAccessException, IllegalArgumentException {
            Intrinsics3.checkNotNullParameter(objArr, "args");
            checkArguments(objArr);
            mo80getMember().set(getInstanceClass() != null ? _Arrays.first(objArr) : null, _Arrays.last(objArr));
            return Unit.a;
        }

        @Override // d0.e0.p.d.l0.CallerImpl
        public void checkArguments(Object[] objArr) {
            Intrinsics3.checkNotNullParameter(objArr, "args");
            super.checkArguments(objArr);
            if (this.f && _Arrays.last(objArr) == null) {
                throw new IllegalArgumentException("null is not allowed as a value for this property.");
            }
        }
    }

    /* compiled from: CallerImpl.kt */
    /* renamed from: d0.e0.p.d.l0.e$h */
    public static abstract class h extends CallerImpl<Method> {
        public final boolean f;

        /* compiled from: CallerImpl.kt */
        /* renamed from: d0.e0.p.d.l0.e$h$a */
        public static final class a extends h implements Caller {
            public final Object g;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(Method method, Object obj) {
                super(method, false, (Type[]) null, 4);
                Intrinsics3.checkNotNullParameter(method, "method");
                this.g = obj;
            }

            @Override // d0.e0.p.d.l0.Caller2
            public Object call(Object[] objArr) {
                Intrinsics3.checkNotNullParameter(objArr, "args");
                checkArguments(objArr);
                return b(this.g, objArr);
            }
        }

        /* compiled from: CallerImpl.kt */
        /* renamed from: d0.e0.p.d.l0.e$h$b */
        public static final class b extends h implements Caller {
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public b(Method method) {
                super(method, false, (Type[]) null, 4);
                Intrinsics3.checkNotNullParameter(method, "method");
            }

            @Override // d0.e0.p.d.l0.Caller2
            public Object call(Object[] objArr) {
                Intrinsics3.checkNotNullParameter(objArr, "args");
                checkArguments(objArr);
                return b(null, objArr);
            }
        }

        /* compiled from: CallerImpl.kt */
        /* renamed from: d0.e0.p.d.l0.e$h$c */
        public static final class c extends h implements Caller {
            public final Object g;

            /* JADX WARN: Illegal instructions before constructor call */
            public c(Method method, Object obj) {
                Object objCopyOfRange;
                Intrinsics3.checkNotNullParameter(method, "method");
                Type[] genericParameterTypes = method.getGenericParameterTypes();
                Intrinsics3.checkNotNullExpressionValue(genericParameterTypes, "method.genericParameterTypes");
                if (genericParameterTypes.length <= 1) {
                    objCopyOfRange = new Type[0];
                } else {
                    objCopyOfRange = _ArraysJvm.copyOfRange(genericParameterTypes, 1, genericParameterTypes.length);
                    Objects.requireNonNull(objCopyOfRange, "null cannot be cast to non-null type kotlin.Array<T>");
                }
                super(method, false, (Type[]) objCopyOfRange, (DefaultConstructorMarker) null);
                this.g = obj;
            }

            @Override // d0.e0.p.d.l0.Caller2
            public Object call(Object[] objArr) {
                Intrinsics3.checkNotNullParameter(objArr, "args");
                checkArguments(objArr);
                SpreadBuilder spreadBuilder = new SpreadBuilder(2);
                spreadBuilder.add(this.g);
                spreadBuilder.addSpread(objArr);
                return b(null, spreadBuilder.toArray(new Object[spreadBuilder.size()]));
            }
        }

        /* compiled from: CallerImpl.kt */
        /* renamed from: d0.e0.p.d.l0.e$h$d */
        public static final class d extends h {
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public d(Method method) {
                super(method, false, (Type[]) null, 6);
                Intrinsics3.checkNotNullParameter(method, "method");
            }

            @Override // d0.e0.p.d.l0.Caller2
            public Object call(Object[] objArr) {
                Object[] objArrCopyOfRange;
                Intrinsics3.checkNotNullParameter(objArr, "args");
                checkArguments(objArr);
                Object obj = objArr[0];
                if (objArr.length <= 1) {
                    objArrCopyOfRange = new Object[0];
                } else {
                    objArrCopyOfRange = _ArraysJvm.copyOfRange(objArr, 1, objArr.length);
                    Objects.requireNonNull(objArrCopyOfRange, "null cannot be cast to non-null type kotlin.Array<T>");
                }
                return b(obj, objArrCopyOfRange);
            }
        }

        /* compiled from: CallerImpl.kt */
        /* renamed from: d0.e0.p.d.l0.e$h$e */
        public static final class e extends h {
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public e(Method method) {
                super(method, true, (Type[]) null, 4);
                Intrinsics3.checkNotNullParameter(method, "method");
            }

            @Override // d0.e0.p.d.l0.Caller2
            public Object call(Object[] objArr) {
                Object[] objArrCopyOfRange;
                Intrinsics3.checkNotNullParameter(objArr, "args");
                checkArguments(objArr);
                a(_Arrays.firstOrNull(objArr));
                if (objArr.length <= 1) {
                    objArrCopyOfRange = new Object[0];
                } else {
                    objArrCopyOfRange = _ArraysJvm.copyOfRange(objArr, 1, objArr.length);
                    Objects.requireNonNull(objArrCopyOfRange, "null cannot be cast to non-null type kotlin.Array<T>");
                }
                return b(null, objArrCopyOfRange);
            }
        }

        /* compiled from: CallerImpl.kt */
        /* renamed from: d0.e0.p.d.l0.e$h$f */
        public static final class f extends h {
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public f(Method method) {
                super(method, false, (Type[]) null, 6);
                Intrinsics3.checkNotNullParameter(method, "method");
            }

            @Override // d0.e0.p.d.l0.Caller2
            public Object call(Object[] objArr) {
                Intrinsics3.checkNotNullParameter(objArr, "args");
                checkArguments(objArr);
                return b(null, objArr);
            }
        }

        public /* synthetic */ h(Method method, boolean z2, Type[] typeArr, DefaultConstructorMarker defaultConstructorMarker) {
            this(method, z2, typeArr);
        }

        public final Object b(Object obj, Object[] objArr) {
            Intrinsics3.checkNotNullParameter(objArr, "args");
            return this.f ? Unit.a : mo80getMember().invoke(obj, Arrays.copyOf(objArr, objArr.length));
        }

        /* JADX WARN: Illegal instructions before constructor call */
        public /* synthetic */ h(Method method, boolean z2, Type[] typeArr, int i) {
            Type[] genericParameterTypes;
            z2 = (i & 2) != 0 ? !Modifier.isStatic(method.getModifiers()) : z2;
            if ((i & 4) != 0) {
                genericParameterTypes = method.getGenericParameterTypes();
                Intrinsics3.checkNotNullExpressionValue(genericParameterTypes, "method.genericParameterTypes");
            } else {
                genericParameterTypes = null;
            }
            this(method, z2, genericParameterTypes);
        }

        /* JADX WARN: Illegal instructions before constructor call */
        public h(Method method, boolean z2, Type[] typeArr) {
            Type genericReturnType = method.getGenericReturnType();
            Intrinsics3.checkNotNullExpressionValue(genericReturnType, "method.genericReturnType");
            super(method, genericReturnType, z2 ? method.getDeclaringClass() : null, typeArr, null);
            this.f = Intrinsics3.areEqual(getReturnType(), Void.TYPE);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:7:0x002a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public CallerImpl(Member member, Type type, Class cls, Type[] typeArr, DefaultConstructorMarker defaultConstructorMarker) {
        List<Type> list;
        this.c = member;
        this.d = type;
        this.e = cls;
        if (cls != null) {
            SpreadBuilder spreadBuilder = new SpreadBuilder(2);
            spreadBuilder.add(cls);
            spreadBuilder.addSpread(typeArr);
            list = Collections2.listOf(spreadBuilder.toArray(new Type[spreadBuilder.size()]));
            list = list == null ? _Arrays.toList(typeArr) : list;
        }
        this.f3204b = list;
    }

    public final void a(Object obj) {
        if (obj == null || !this.c.getDeclaringClass().isInstance(obj)) {
            throw new IllegalArgumentException("An object member requires the object instance passed as the first argument.");
        }
    }

    public void checkArguments(Object[] objArr) {
        Intrinsics3.checkNotNullParameter(objArr, "args");
        Caller2.a.checkArguments(this, objArr);
    }

    public final Class<?> getInstanceClass() {
        return this.e;
    }

    @Override // d0.e0.p.d.l0.Caller2
    /* renamed from: getMember */
    public final M mo80getMember() {
        return this.c;
    }

    @Override // d0.e0.p.d.l0.Caller2
    public List<Type> getParameterTypes() {
        return this.f3204b;
    }

    @Override // d0.e0.p.d.l0.Caller2
    public final Type getReturnType() {
        return this.d;
    }
}
