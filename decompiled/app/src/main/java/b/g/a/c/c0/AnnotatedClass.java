package b.g.a.c.c0;

import b.c.a.a0.AnimatableValueParser;
import b.d.b.a.outline;
import b.g.a.c.AnnotationIntrospector;
import b.g.a.c.JavaType;
import b.g.a.c.c0.AnnotatedFieldCollector;
import b.g.a.c.c0.AnnotatedMethodCollector;
import b.g.a.c.c0.ClassIntrospector;
import b.g.a.c.c0.TypeResolutionContext;
import b.g.a.c.h0.TypeBindings;
import b.g.a.c.h0.TypeFactory;
import b.g.a.c.i0.Annotations;
import b.g.a.c.i0.ClassUtil;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/* compiled from: AnnotatedClass.java */
/* renamed from: b.g.a.c.c0.c, reason: use source file name */
/* loaded from: classes3.dex */
public final class AnnotatedClass extends Annotated implements TypeResolutionContext {
    public static final a j = new a(null, Collections.emptyList(), Collections.emptyList());
    public final JavaType k;
    public final Class<?> l;
    public final TypeBindings m;
    public final List<JavaType> n;
    public final AnnotationIntrospector o;
    public final TypeFactory p;
    public final ClassIntrospector.a q;
    public final Class<?> r;

    /* renamed from: s, reason: collision with root package name */
    public final boolean f684s;
    public final Annotations t;
    public a u;
    public AnnotatedMethodMap v;
    public List<AnnotatedField> w;

    /* renamed from: x, reason: collision with root package name */
    public transient Boolean f685x;

    /* compiled from: AnnotatedClass.java */
    /* renamed from: b.g.a.c.c0.c$a */
    public static final class a {
        public final AnnotatedConstructor a;

        /* renamed from: b, reason: collision with root package name */
        public final List<AnnotatedConstructor> f686b;
        public final List<AnnotatedMethod> c;

        public a(AnnotatedConstructor annotatedConstructor, List<AnnotatedConstructor> list, List<AnnotatedMethod> list2) {
            this.a = annotatedConstructor;
            this.f686b = list;
            this.c = list2;
        }
    }

    public AnnotatedClass(JavaType javaType, Class<?> cls, List<JavaType> list, Class<?> cls2, Annotations annotations, TypeBindings typeBindings, AnnotationIntrospector annotationIntrospector, ClassIntrospector.a aVar, TypeFactory typeFactory, boolean z2) {
        this.k = javaType;
        this.l = cls;
        this.n = list;
        this.r = cls2;
        this.t = annotations;
        this.m = typeBindings;
        this.o = annotationIntrospector;
        this.q = aVar;
        this.p = typeFactory;
        this.f684s = z2;
    }

    @Override // b.g.a.c.c0.TypeResolutionContext
    public JavaType a(Type type) {
        return this.p.b(null, type, this.m);
    }

    @Override // b.g.a.c.c0.Annotated
    public <A extends Annotation> A b(Class<A> cls) {
        return (A) this.t.a(cls);
    }

    @Override // b.g.a.c.c0.Annotated
    public String c() {
        return this.l.getName();
    }

    @Override // b.g.a.c.c0.Annotated
    public Class<?> d() {
        return this.l;
    }

    @Override // b.g.a.c.c0.Annotated
    public JavaType e() {
        return this.k;
    }

    @Override // b.g.a.c.c0.Annotated
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        return ClassUtil.o(obj, AnnotatedClass.class) && ((AnnotatedClass) obj).l == this.l;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:165:0x02ea  */
    /* JADX WARN: Removed duplicated region for block: B:169:0x02f3  */
    /* JADX WARN: Removed duplicated region for block: B:170:0x02f5  */
    /* JADX WARN: Removed duplicated region for block: B:177:0x0318  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0128  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0140  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0146  */
    /* JADX WARN: Type inference failed for: r2v6, types: [java.util.List] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final a f() throws SecurityException, IllegalArgumentException {
        ClassUtil.a aVar;
        ArrayList arrayList;
        int size;
        ArrayList arrayList2;
        ArrayList arrayList3;
        ArrayList arrayList4;
        List listEmptyList;
        JavaType javaType;
        int i;
        ArrayList arrayList5;
        TypeBindings typeBindings;
        TypeVariable<Method>[] typeVariableArr;
        Type[] typeArr;
        TypeVariable<Method> typeVariable;
        boolean z2;
        Method[] methodArr;
        ClassUtil.a[] aVarArr;
        a aVar2 = this.u;
        if (aVar2 == null) {
            JavaType javaType2 = this.k;
            if (javaType2 == null) {
                aVar2 = j;
            } else {
                AnnotationIntrospector annotationIntrospector = this.o;
                TypeFactory typeFactory = this.p;
                Class<?> cls = this.r;
                AnnotatedCreatorCollector annotatedCreatorCollector = new AnnotatedCreatorCollector(annotationIntrospector, this, this.f684s | (cls != null));
                if (javaType2.w()) {
                    aVar = null;
                    arrayList = null;
                } else {
                    aVar = null;
                    arrayList = null;
                    for (ClassUtil.a aVar3 : ClassUtil.l(javaType2._class)) {
                        if (!aVar3.a.isSynthetic()) {
                            if (aVar3.a() == 0) {
                                aVar = aVar3;
                            } else {
                                if (arrayList == null) {
                                    arrayList = new ArrayList();
                                }
                                arrayList.add(aVar3);
                            }
                        }
                    }
                }
                if (arrayList == null) {
                    ?? EmptyList = Collections.emptyList();
                    arrayList3 = EmptyList;
                    if (aVar != null) {
                        arrayList2 = EmptyList;
                        size = 0;
                    }
                    arrayList4 = null;
                    for (Method method : ClassUtil.k(javaType2._class)) {
                        if (AnnotatedCreatorCollector.f(method)) {
                            if (arrayList4 == null) {
                                arrayList4 = new ArrayList();
                            }
                            arrayList4.add(method);
                        }
                    }
                    if (arrayList4 != null) {
                        listEmptyList = Collections.emptyList();
                    } else {
                        TypeResolutionContext.b bVar = new TypeResolutionContext.b(typeFactory);
                        int size2 = arrayList4.size();
                        ArrayList arrayList6 = new ArrayList(size2);
                        for (int i2 = 0; i2 < size2; i2++) {
                            arrayList6.add(null);
                        }
                        if (cls != null) {
                            Method[] declaredMethods = cls.getDeclaredMethods();
                            int length = declaredMethods.length;
                            MemberKey[] memberKeyArr = null;
                            int i3 = 0;
                            while (i3 < length) {
                                Method method2 = declaredMethods[i3];
                                if (AnnotatedCreatorCollector.f(method2)) {
                                    if (memberKeyArr == null) {
                                        memberKeyArr = new MemberKey[size2];
                                        int i4 = 0;
                                        while (i4 < size2) {
                                            memberKeyArr[i4] = new MemberKey((Method) arrayList4.get(i4));
                                            i4++;
                                            declaredMethods = declaredMethods;
                                        }
                                    }
                                    methodArr = declaredMethods;
                                    MemberKey memberKey = new MemberKey(method2);
                                    int i5 = 0;
                                    while (true) {
                                        if (i5 >= size2) {
                                            break;
                                        }
                                        if (memberKey.equals(memberKeyArr[i5])) {
                                            arrayList6.set(i5, annotatedCreatorCollector.j((Method) arrayList4.get(i5), bVar, method2));
                                            break;
                                        }
                                        i5++;
                                    }
                                } else {
                                    methodArr = declaredMethods;
                                }
                                i3++;
                                declaredMethods = methodArr;
                            }
                        }
                        int i6 = 0;
                        while (i6 < size2) {
                            if (((AnnotatedMethod) arrayList6.get(i6)) == null) {
                                Method method3 = (Method) arrayList4.get(i6);
                                TypeVariable<Method>[] typeParameters = method3.getTypeParameters();
                                if (typeParameters.length == 0 || javaType2.j().i()) {
                                    javaType = javaType2;
                                    i = size2;
                                    arrayList5 = arrayList4;
                                    typeBindings = null;
                                    arrayList6.set(i6, annotatedCreatorCollector.j(method3, typeBindings == null ? bVar : new TypeResolutionContext.a(typeFactory, typeBindings), null));
                                } else {
                                    Type genericReturnType = method3.getGenericReturnType();
                                    if (genericReturnType instanceof ParameterizedType) {
                                        ParameterizedType parameterizedType = (ParameterizedType) genericReturnType;
                                        if (Objects.equals(javaType2._class, parameterizedType.getRawType())) {
                                            Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
                                            ArrayList arrayList7 = new ArrayList(typeParameters.length);
                                            ArrayList arrayList8 = new ArrayList(typeParameters.length);
                                            i = size2;
                                            int i7 = 0;
                                            while (true) {
                                                if (i7 < actualTypeArguments.length) {
                                                    TypeVariable<?> typeVariableI1 = AnimatableValueParser.i1(actualTypeArguments[i7]);
                                                    if (typeVariableI1 != null) {
                                                        String name = typeVariableI1.getName();
                                                        if (name == null) {
                                                            javaType = javaType2;
                                                            break;
                                                        }
                                                        arrayList5 = arrayList4;
                                                        JavaType javaTypeF = javaType2.j().f(i7);
                                                        if (javaTypeF == null) {
                                                            javaType = javaType2;
                                                            break;
                                                        }
                                                        javaType = javaType2;
                                                        int length2 = typeParameters.length;
                                                        typeArr = actualTypeArguments;
                                                        int i8 = 0;
                                                        while (true) {
                                                            if (i8 >= length2) {
                                                                typeVariable = null;
                                                                break;
                                                            }
                                                            typeVariable = typeParameters[i8];
                                                            int i9 = length2;
                                                            if (name.equals(typeVariable.getName())) {
                                                                break;
                                                            }
                                                            i8++;
                                                            length2 = i9;
                                                        }
                                                        if (typeVariable == null) {
                                                            break;
                                                        }
                                                        Type[] bounds = typeVariable.getBounds();
                                                        int length3 = bounds.length;
                                                        typeVariableArr = typeParameters;
                                                        int i10 = 0;
                                                        while (true) {
                                                            if (i10 >= length3) {
                                                                z2 = true;
                                                                break;
                                                            }
                                                            int i11 = length3;
                                                            if (!AnimatableValueParser.A1(bVar, javaTypeF, bounds[i10])) {
                                                                z2 = false;
                                                                break;
                                                            }
                                                            i10++;
                                                            length3 = i11;
                                                        }
                                                        if (z2) {
                                                            int iIndexOf = arrayList7.indexOf(name);
                                                            if (iIndexOf != -1) {
                                                                JavaType javaType3 = (JavaType) arrayList8.get(iIndexOf);
                                                                if (!javaTypeF.equals(javaType3)) {
                                                                    boolean zB = javaType3.B(javaTypeF._class);
                                                                    boolean zB2 = javaTypeF.B(javaType3._class);
                                                                    if (!zB && !zB2) {
                                                                        break;
                                                                    }
                                                                    if ((zB ^ zB2) && zB2) {
                                                                        arrayList8.set(iIndexOf, javaTypeF);
                                                                    }
                                                                } else {
                                                                    continue;
                                                                }
                                                            } else {
                                                                arrayList7.add(name);
                                                                arrayList8.add(javaTypeF);
                                                            }
                                                        } else {
                                                            continue;
                                                        }
                                                    } else {
                                                        javaType = javaType2;
                                                        arrayList5 = arrayList4;
                                                        typeVariableArr = typeParameters;
                                                        typeArr = actualTypeArguments;
                                                    }
                                                    i7++;
                                                    arrayList4 = arrayList5;
                                                    javaType2 = javaType;
                                                    actualTypeArguments = typeArr;
                                                    typeParameters = typeVariableArr;
                                                } else {
                                                    javaType = javaType2;
                                                    arrayList5 = arrayList4;
                                                    if (arrayList7.isEmpty()) {
                                                        break;
                                                    }
                                                    typeBindings = (arrayList7.isEmpty() || arrayList8.isEmpty()) ? TypeBindings.l : new TypeBindings((String[]) arrayList7.toArray(TypeBindings.j), (JavaType[]) arrayList8.toArray(TypeBindings.k), null);
                                                }
                                            }
                                            typeBindings = null;
                                            arrayList6.set(i6, annotatedCreatorCollector.j(method3, typeBindings == null ? bVar : new TypeResolutionContext.a(typeFactory, typeBindings), null));
                                        }
                                        arrayList5 = arrayList4;
                                        typeBindings = null;
                                        arrayList6.set(i6, annotatedCreatorCollector.j(method3, typeBindings == null ? bVar : new TypeResolutionContext.a(typeFactory, typeBindings), null));
                                    }
                                }
                            } else {
                                javaType = javaType2;
                                i = size2;
                                arrayList5 = arrayList4;
                            }
                            i6++;
                            size2 = i;
                            arrayList4 = arrayList5;
                            javaType2 = javaType;
                        }
                        listEmptyList = arrayList6;
                    }
                    if (annotatedCreatorCollector.e) {
                        AnnotatedConstructor annotatedConstructor = annotatedCreatorCollector.f;
                        if (annotatedConstructor != null && annotatedCreatorCollector.c.Z(annotatedConstructor)) {
                            annotatedCreatorCollector.f = null;
                        }
                        int size3 = arrayList3.size();
                        while (true) {
                            size3--;
                            if (size3 < 0) {
                                break;
                            }
                            if (annotatedCreatorCollector.c.Z((AnnotatedMember) arrayList3.get(size3))) {
                                arrayList3.remove(size3);
                            }
                        }
                        int size4 = listEmptyList.size();
                        while (true) {
                            size4--;
                            if (size4 < 0) {
                                break;
                            }
                            if (annotatedCreatorCollector.c.Z((AnnotatedMember) listEmptyList.get(size4))) {
                                listEmptyList.remove(size4);
                            }
                        }
                    }
                    aVar2 = new a(annotatedCreatorCollector.f, arrayList3, listEmptyList);
                } else {
                    size = arrayList.size();
                    arrayList2 = new ArrayList(size);
                    for (int i12 = 0; i12 < size; i12++) {
                        arrayList2.add(null);
                    }
                }
                if (cls != null) {
                    ClassUtil.a[] aVarArrL = ClassUtil.l(cls);
                    int length4 = aVarArrL.length;
                    MemberKey[] memberKeyArr2 = null;
                    int i13 = 0;
                    while (i13 < length4) {
                        ClassUtil.a aVar4 = aVarArrL[i13];
                        if (aVar4.a() != 0) {
                            aVarArr = aVarArrL;
                            if (arrayList != null) {
                                if (memberKeyArr2 == null) {
                                    MemberKey[] memberKeyArr3 = new MemberKey[size];
                                    for (int i14 = 0; i14 < size; i14++) {
                                        memberKeyArr3[i14] = new MemberKey(((ClassUtil.a) arrayList.get(i14)).a);
                                    }
                                    memberKeyArr2 = memberKeyArr3;
                                }
                                MemberKey memberKey2 = new MemberKey(aVar4.a);
                                int i15 = 0;
                                while (true) {
                                    if (i15 >= size) {
                                        break;
                                    }
                                    if (memberKey2.equals(memberKeyArr2[i15])) {
                                        arrayList2.set(i15, annotatedCreatorCollector.k((ClassUtil.a) arrayList.get(i15), aVar4));
                                        break;
                                    }
                                    i15++;
                                }
                            }
                        } else if (aVar != null) {
                            aVarArr = aVarArrL;
                            annotatedCreatorCollector.f = new AnnotatedConstructor(annotatedCreatorCollector.d, aVar.a, annotatedCreatorCollector.g(aVar, aVar4), CollectorBase.a);
                            aVar = null;
                        } else {
                            aVarArr = aVarArrL;
                        }
                        i13++;
                        aVarArrL = aVarArr;
                    }
                }
                if (aVar != null) {
                    annotatedCreatorCollector.f = new AnnotatedConstructor(annotatedCreatorCollector.d, aVar.a, annotatedCreatorCollector.g(aVar, null), CollectorBase.a);
                }
                for (int i16 = 0; i16 < size; i16++) {
                    if (((AnnotatedConstructor) arrayList2.get(i16)) == null) {
                        arrayList2.set(i16, annotatedCreatorCollector.k((ClassUtil.a) arrayList.get(i16), null));
                    }
                }
                arrayList3 = arrayList2;
                arrayList4 = null;
                while (i < r6) {
                }
                if (arrayList4 != null) {
                }
                if (annotatedCreatorCollector.e) {
                }
                aVar2 = new a(annotatedCreatorCollector.f, arrayList3, listEmptyList);
            }
            this.u = aVar2;
        }
        return aVar2;
    }

    public Iterable<AnnotatedField> g() {
        List<AnnotatedField> listEmptyList = this.w;
        if (listEmptyList == null) {
            JavaType javaType = this.k;
            if (javaType == null) {
                listEmptyList = Collections.emptyList();
            } else {
                Map<String, AnnotatedFieldCollector.a> mapF = new AnnotatedFieldCollector(this.o, this.p, this.q, this.f684s).f(this, javaType, null);
                if (mapF == null) {
                    listEmptyList = Collections.emptyList();
                } else {
                    ArrayList arrayList = new ArrayList(mapF.size());
                    for (AnnotatedFieldCollector.a aVar : mapF.values()) {
                        arrayList.add(new AnnotatedField(aVar.a, aVar.f690b, aVar.c.b()));
                    }
                    listEmptyList = arrayList;
                }
            }
            this.w = listEmptyList;
        }
        return listEmptyList;
    }

    public Iterable<AnnotatedMethod> h() throws NoSuchMethodException, SecurityException {
        boolean z2;
        Class<?> clsA;
        AnnotatedMethodMap annotatedMethodMap = this.v;
        if (annotatedMethodMap == null) {
            JavaType javaType = this.k;
            if (javaType == null) {
                annotatedMethodMap = new AnnotatedMethodMap();
            } else {
                AnnotationIntrospector annotationIntrospector = this.o;
                ClassIntrospector.a aVar = this.q;
                TypeFactory typeFactory = this.p;
                List<JavaType> list = this.n;
                Class<?> cls = this.r;
                AnnotatedMethodCollector annotatedMethodCollector = new AnnotatedMethodCollector(annotationIntrospector, aVar, this.f684s);
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                annotatedMethodCollector.f(this, javaType._class, linkedHashMap, cls);
                Iterator<JavaType> it = list.iterator();
                while (true) {
                    Class<?> clsA2 = null;
                    if (!it.hasNext()) {
                        break;
                    }
                    JavaType next = it.next();
                    ClassIntrospector.a aVar2 = annotatedMethodCollector.d;
                    if (aVar2 != null) {
                        clsA2 = aVar2.a(next._class);
                    }
                    annotatedMethodCollector.f(new TypeResolutionContext.a(typeFactory, next.j()), next._class, linkedHashMap, clsA2);
                }
                ClassIntrospector.a aVar3 = annotatedMethodCollector.d;
                if (aVar3 == null || (clsA = aVar3.a(Object.class)) == null) {
                    z2 = false;
                } else {
                    annotatedMethodCollector.g(this, javaType._class, linkedHashMap, clsA);
                    z2 = true;
                }
                if (z2 && annotatedMethodCollector.c != null && !linkedHashMap.isEmpty()) {
                    for (Map.Entry entry : linkedHashMap.entrySet()) {
                        MemberKey memberKey = (MemberKey) entry.getKey();
                        if ("hashCode".equals(memberKey.f696b) && memberKey.c.length == 0) {
                            try {
                                Method declaredMethod = Object.class.getDeclaredMethod(memberKey.f696b, new Class[0]);
                                if (declaredMethod != null) {
                                    AnnotatedMethodCollector.a aVar4 = (AnnotatedMethodCollector.a) entry.getValue();
                                    aVar4.c = annotatedMethodCollector.d(aVar4.c, declaredMethod.getDeclaredAnnotations());
                                    aVar4.f691b = declaredMethod;
                                }
                            } catch (Exception unused) {
                            }
                        }
                    }
                }
                if (linkedHashMap.isEmpty()) {
                    annotatedMethodMap = new AnnotatedMethodMap();
                } else {
                    LinkedHashMap linkedHashMap2 = new LinkedHashMap(linkedHashMap.size());
                    for (Map.Entry entry2 : linkedHashMap.entrySet()) {
                        AnnotatedMethodCollector.a aVar5 = (AnnotatedMethodCollector.a) entry2.getValue();
                        Method method = aVar5.f691b;
                        AnnotatedMethod annotatedMethod = method == null ? null : new AnnotatedMethod(aVar5.a, method, aVar5.c.b(), null);
                        if (annotatedMethod != null) {
                            linkedHashMap2.put(entry2.getKey(), annotatedMethod);
                        }
                    }
                    annotatedMethodMap = new AnnotatedMethodMap(linkedHashMap2);
                }
            }
            this.v = annotatedMethodMap;
        }
        return annotatedMethodMap;
    }

    @Override // b.g.a.c.c0.Annotated
    public int hashCode() {
        return this.l.getName().hashCode();
    }

    public String toString() {
        return outline.o(this.l, outline.U("[AnnotedClass "), "]");
    }

    public AnnotatedClass(Class<?> cls) {
        this.k = null;
        this.l = cls;
        this.n = Collections.emptyList();
        this.r = null;
        this.t = AnnotationCollector.a;
        this.m = TypeBindings.l;
        this.o = null;
        this.q = null;
        this.p = null;
        this.f684s = false;
    }
}
