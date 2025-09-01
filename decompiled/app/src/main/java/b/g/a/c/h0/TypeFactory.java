package b.g.a.c.h0;

import b.d.b.a.outline;
import b.g.a.c.JavaType;
import b.g.a.c.JsonNode;
import b.g.a.c.i0.ClassUtil;
import b.g.a.c.i0.LRUMap;
import b.g.a.c.i0.LookupCache;
import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Properties;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: TypeFactory.java */
/* renamed from: b.g.a.c.h0.n, reason: use source file name */
/* loaded from: classes3.dex */
public class TypeFactory implements Serializable {
    public static final SimpleType A;
    public static final SimpleType B;
    public static final SimpleType C;
    public static final SimpleType D;
    public static final JavaType[] j = new JavaType[0];
    public static final TypeFactory k = new TypeFactory();
    public static final TypeBindings l = TypeBindings.l;
    public static final Class<?> m = String.class;
    public static final Class<?> n = Object.class;
    public static final Class<?> o = Comparable.class;
    public static final Class<?> p = Class.class;
    public static final Class<?> q = Enum.class;
    public static final Class<?> r = JsonNode.class;

    /* renamed from: s, reason: collision with root package name */
    public static final Class<?> f722s;
    private static final long serialVersionUID = 1;
    public static final Class<?> t;
    public static final Class<?> u;
    public static final SimpleType v;
    public static final SimpleType w;

    /* renamed from: x, reason: collision with root package name */
    public static final SimpleType f723x;

    /* renamed from: y, reason: collision with root package name */
    public static final SimpleType f724y;

    /* renamed from: z, reason: collision with root package name */
    public static final SimpleType f725z;
    public final LookupCache<Object, JavaType> _typeCache = new LRUMap(16, 200);
    public final TypeParser _parser = new TypeParser(this);
    public final TypeModifier[] _modifiers = null;
    public final ClassLoader _classLoader = null;

    static {
        Class<?> cls = Boolean.TYPE;
        f722s = cls;
        Class<?> cls2 = Integer.TYPE;
        t = cls2;
        Class<?> cls3 = Long.TYPE;
        u = cls3;
        v = new SimpleType(cls);
        w = new SimpleType(cls2);
        f723x = new SimpleType(cls3);
        f724y = new SimpleType(String.class);
        f725z = new SimpleType(Object.class);
        A = new SimpleType(Comparable.class);
        B = new SimpleType(Enum.class);
        C = new SimpleType(Class.class);
        D = new SimpleType(JsonNode.class);
    }

    public static JavaType k() {
        Objects.requireNonNull(k);
        return f725z;
    }

    public JavaType a(Class<?> cls) {
        if (cls.isPrimitive()) {
            if (cls == f722s) {
                return v;
            }
            if (cls == t) {
                return w;
            }
            if (cls == u) {
                return f723x;
            }
            return null;
        }
        if (cls == m) {
            return f724y;
        }
        if (cls == n) {
            return f725z;
        }
        if (cls == r) {
            return D;
        }
        return null;
    }

    public JavaType b(ClassStack classStack, Type type, TypeBindings typeBindings) {
        JavaType javaTypeB;
        Type[] bounds;
        TypeBindings typeBindingsD;
        if (type instanceof Class) {
            javaTypeB = c(classStack, (Class) type, l);
        } else if (type instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) type;
            Class<?> cls = (Class) parameterizedType.getRawType();
            if (cls == q) {
                javaTypeB = B;
            } else if (cls == o) {
                javaTypeB = A;
            } else if (cls == p) {
                javaTypeB = C;
            } else {
                Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
                int length = actualTypeArguments == null ? 0 : actualTypeArguments.length;
                if (length == 0) {
                    typeBindingsD = l;
                } else {
                    JavaType[] javaTypeArr = new JavaType[length];
                    for (int i = 0; i < length; i++) {
                        javaTypeArr[i] = b(classStack, actualTypeArguments[i], typeBindings);
                    }
                    typeBindingsD = TypeBindings.d(cls, javaTypeArr);
                }
                javaTypeB = c(classStack, cls, typeBindingsD);
            }
        } else {
            if (type instanceof JavaType) {
                return (JavaType) type;
            }
            if (type instanceof GenericArrayType) {
                javaTypeB = ArrayType.L(b(classStack, ((GenericArrayType) type).getGenericComponentType(), typeBindings), typeBindings);
            } else if (type instanceof TypeVariable) {
                TypeVariable typeVariable = (TypeVariable) type;
                String name = typeVariable.getName();
                if (typeBindings == null) {
                    throw new IllegalArgumentException(outline.y("Null `bindings` passed (type variable \"", name, "\")"));
                }
                JavaType javaTypeE = typeBindings.e(name);
                if (javaTypeE != null) {
                    javaTypeB = javaTypeE;
                } else if (typeBindings.h(name)) {
                    javaTypeB = f725z;
                } else {
                    TypeBindings typeBindingsL = typeBindings.l(name);
                    synchronized (typeVariable) {
                        bounds = typeVariable.getBounds();
                    }
                    javaTypeB = b(classStack, bounds[0], typeBindingsL);
                }
            } else {
                if (!(type instanceof WildcardType)) {
                    StringBuilder sbU = outline.U("Unrecognized Type: ");
                    sbU.append(type == null ? "[null]" : type.toString());
                    throw new IllegalArgumentException(sbU.toString());
                }
                javaTypeB = b(classStack, ((WildcardType) type).getUpperBounds()[0], typeBindings);
            }
        }
        if (this._modifiers != null) {
            javaTypeB.j();
            TypeModifier[] typeModifierArr = this._modifiers;
            if (typeModifierArr.length > 0) {
                TypeModifier typeModifier = typeModifierArr[0];
                throw null;
            }
        }
        return javaTypeB;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:100:0x01ac  */
    /* JADX WARN: Type inference failed for: r1v41, types: [b.g.a.c.j] */
    /* JADX WARN: Type inference failed for: r2v25, types: [b.g.a.c.j] */
    /* JADX WARN: Type inference failed for: r2v42, types: [java.lang.Object] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public JavaType c(ClassStack classStack, Class<?> cls, TypeBindings typeBindings) {
        ClassStack classStack2;
        ClassStack classStack3;
        JavaType javaTypeB;
        JavaType[] javaTypeArrE;
        Class<?> cls2;
        JavaType referenceType;
        JavaType javaType;
        JavaType javaType2;
        JavaType javaType3;
        SimpleType simpleType;
        SimpleType simpleType2;
        SimpleType simpleType3;
        JavaType javaTypeA = a(cls);
        if (javaTypeA != null) {
            return javaTypeA;
        }
        Class<?> clsA = (typeBindings == null || typeBindings.i()) ? cls : typeBindings.a(cls);
        JavaType javaTypeC = this._typeCache.get(clsA);
        if (javaTypeC != null) {
            return javaTypeC;
        }
        if (classStack == null) {
            classStack3 = new ClassStack(cls);
        } else {
            if (classStack.f719b != cls) {
                classStack2 = classStack.a;
                while (true) {
                    if (classStack2 == null) {
                        classStack2 = null;
                        break;
                    }
                    if (classStack2.f719b == cls) {
                        break;
                    }
                    classStack2 = classStack2.a;
                }
            } else {
                classStack2 = classStack;
            }
            if (classStack2 != null) {
                ResolvedRecursiveType resolvedRecursiveType = new ResolvedRecursiveType(cls, l);
                if (classStack2.c == null) {
                    classStack2.c = new ArrayList<>();
                }
                classStack2.c.add(resolvedRecursiveType);
                return resolvedRecursiveType;
            }
            classStack3 = new ClassStack(classStack, cls);
        }
        if (cls.isArray()) {
            referenceType = ArrayType.L(b(classStack3, cls.getComponentType(), typeBindings), typeBindings);
            cls2 = clsA;
        } else {
            if (cls.isInterface()) {
                javaTypeArrE = e(classStack3, cls, typeBindings);
                javaTypeB = null;
            } else {
                Annotation[] annotationArr = ClassUtil.a;
                Type genericSuperclass = cls.getGenericSuperclass();
                javaTypeB = genericSuperclass == null ? null : b(classStack3, genericSuperclass, typeBindings);
                javaTypeArrE = e(classStack3, cls, typeBindings);
            }
            JavaType[] javaTypeArr = javaTypeArrE;
            JavaType javaType4 = javaTypeB;
            if (cls == Properties.class) {
                SimpleType simpleType4 = f724y;
                javaTypeC = MapType.Q(cls, typeBindings, javaType4, javaTypeArr, simpleType4, simpleType4);
            } else if (javaType4 != null) {
                javaTypeC = javaType4.C(cls, typeBindings, javaType4, javaTypeArr);
            }
            if (javaTypeC == null) {
                TypeBindings typeBindings2 = typeBindings == null ? l : typeBindings;
                if (cls == Map.class) {
                    if (cls == Properties.class) {
                        simpleType = f724y;
                    } else {
                        List<JavaType> listG = typeBindings2.g();
                        int size = listG.size();
                        if (size == 0) {
                            simpleType = f725z;
                        } else {
                            if (size != 2) {
                                Object[] objArr = new Object[4];
                                objArr[0] = ClassUtil.u(cls);
                                objArr[1] = Integer.valueOf(size);
                                objArr[2] = size == 1 ? "" : "s";
                                objArr[3] = typeBindings2;
                                throw new IllegalArgumentException(String.format("Strange Map type %s with %d type parameter%s (%s), can not resolve", objArr));
                            }
                            JavaType javaType5 = listG.get(0);
                            simpleType2 = listG.get(1);
                            simpleType3 = javaType5;
                            referenceType = MapType.Q(cls, typeBindings2, javaType4, javaTypeArr, simpleType3, simpleType2);
                        }
                    }
                    simpleType3 = simpleType;
                    simpleType2 = simpleType3;
                    referenceType = MapType.Q(cls, typeBindings2, javaType4, javaTypeArr, simpleType3, simpleType2);
                } else if (cls == Collection.class) {
                    List<JavaType> listG2 = typeBindings2.g();
                    if (listG2.isEmpty()) {
                        javaType3 = f725z;
                    } else {
                        if (listG2.size() != 1) {
                            throw new IllegalArgumentException(outline.o(cls, outline.U("Strange Collection type "), ": cannot determine type parameters"));
                        }
                        javaType3 = listG2.get(0);
                    }
                    referenceType = new CollectionType(cls, typeBindings2, javaType4, javaTypeArr, javaType3, null, null, false);
                } else {
                    if (cls == AtomicReference.class) {
                        List<JavaType> listG3 = typeBindings2.g();
                        if (listG3.isEmpty()) {
                            javaType2 = f725z;
                        } else {
                            if (listG3.size() != 1) {
                                throw new IllegalArgumentException(outline.o(cls, outline.U("Strange Reference type "), ": cannot determine type parameters"));
                            }
                            javaType2 = listG3.get(0);
                        }
                        cls2 = clsA;
                        javaType = javaType4;
                        referenceType = new ReferenceType(cls, typeBindings2, javaType4, javaTypeArr, javaType2, null, null, null, false);
                    } else {
                        cls2 = clsA;
                        javaType = javaType4;
                        referenceType = null;
                    }
                    if (referenceType == null) {
                        int length = javaTypeArr.length;
                        int i = 0;
                        while (true) {
                            if (i >= length) {
                                referenceType = null;
                                break;
                            }
                            JavaType javaTypeC2 = javaTypeArr[i].C(cls, typeBindings, javaType, javaTypeArr);
                            if (javaTypeC2 != null) {
                                referenceType = javaTypeC2;
                                break;
                            }
                            i++;
                        }
                        if (referenceType == null) {
                            referenceType = d(cls, typeBindings, javaType, javaTypeArr);
                        }
                    }
                }
                cls2 = clsA;
                javaType = javaType4;
                if (referenceType == null) {
                }
            } else {
                cls2 = clsA;
                referenceType = javaTypeC;
            }
        }
        ArrayList<ResolvedRecursiveType> arrayList = classStack3.c;
        if (arrayList != null) {
            Iterator<ResolvedRecursiveType> it = arrayList.iterator();
            while (it.hasNext()) {
                ResolvedRecursiveType next = it.next();
                if (next._referencedType != null) {
                    StringBuilder sbU = outline.U("Trying to re-set self reference; old value = ");
                    sbU.append(next._referencedType);
                    sbU.append(", new = ");
                    sbU.append(referenceType);
                    throw new IllegalStateException(sbU.toString());
                }
                next._referencedType = referenceType;
            }
        }
        if (!referenceType.s()) {
            this._typeCache.putIfAbsent(cls2, referenceType);
        }
        return referenceType;
    }

    public JavaType d(Class<?> cls, TypeBindings typeBindings, JavaType javaType, JavaType[] javaTypeArr) {
        return new SimpleType(cls, typeBindings, javaType, javaTypeArr, null, null, false);
    }

    public JavaType[] e(ClassStack classStack, Class<?> cls, TypeBindings typeBindings) {
        Annotation[] annotationArr = ClassUtil.a;
        Type[] genericInterfaces = cls.getGenericInterfaces();
        if (genericInterfaces == null || genericInterfaces.length == 0) {
            return j;
        }
        int length = genericInterfaces.length;
        JavaType[] javaTypeArr = new JavaType[length];
        for (int i = 0; i < length; i++) {
            javaTypeArr[i] = b(classStack, genericInterfaces[i], typeBindings);
        }
        return javaTypeArr;
    }

    public final boolean f(JavaType javaType, JavaType javaType2) {
        if (javaType2 instanceof PlaceholderForType) {
            ((PlaceholderForType) javaType2)._actualType = javaType;
            return true;
        }
        if (javaType._class != javaType2._class) {
            return false;
        }
        List<JavaType> listG = javaType.j().g();
        List<JavaType> listG2 = javaType2.j().g();
        int size = listG.size();
        for (int i = 0; i < size; i++) {
            if (!f(listG.get(i), listG2.get(i))) {
                return false;
            }
        }
        return true;
    }

    public JavaType g(JavaType javaType, Class<?> cls) {
        Class<?> cls2 = javaType._class;
        if (cls2 == cls) {
            return javaType;
        }
        JavaType javaTypeI = javaType.i(cls);
        if (javaTypeI != null) {
            return javaTypeI;
        }
        if (cls.isAssignableFrom(cls2)) {
            throw new IllegalArgumentException(String.format("Internal error: class %s not included as super-type for %s", cls.getName(), javaType));
        }
        throw new IllegalArgumentException(String.format("Class %s not a super-type of %s", cls.getName(), javaType));
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x019e  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x009d A[LOOP:0: B:45:0x009b->B:46:0x009d, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0107  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public JavaType h(JavaType javaType, Class<?> cls, boolean z2) throws IllegalArgumentException {
        int length;
        int i;
        JavaType javaTypeI;
        String str;
        JavaType javaTypeC;
        Class<?> cls2 = javaType._class;
        if (cls2 == cls) {
            return javaType;
        }
        if (cls2 == Object.class) {
            javaTypeC = c(null, cls, l);
        } else {
            if (!cls2.isAssignableFrom(cls)) {
                throw new IllegalArgumentException(String.format("Class %s not subtype of %s", ClassUtil.u(cls), ClassUtil.n(javaType)));
            }
            if (javaType.v()) {
                if (javaType.z()) {
                    if (cls == HashMap.class || cls == LinkedHashMap.class || cls == EnumMap.class || cls == TreeMap.class) {
                        javaTypeC = c(null, cls, TypeBindings.c(cls, javaType.o(), javaType.k()));
                    }
                } else if (javaType.u()) {
                    if (cls == ArrayList.class || cls == LinkedList.class || cls == HashSet.class || cls == TreeSet.class) {
                        javaTypeC = c(null, cls, TypeBindings.b(cls, javaType.k()));
                    } else {
                        if (cls2 == EnumSet.class) {
                            return javaType;
                        }
                        if (javaType.j().i()) {
                            javaTypeC = c(null, cls, l);
                        } else {
                            PlaceholderForType[] placeholderForTypeArr = new PlaceholderForType[length];
                            while (i < length) {
                            }
                            javaTypeI = c(null, cls, TypeBindings.d(cls, placeholderForTypeArr)).i(javaType._class);
                            if (javaTypeI != null) {
                            }
                        }
                    }
                }
            } else if (javaType.j().i() && (length = cls.getTypeParameters().length) != 0) {
                PlaceholderForType[] placeholderForTypeArr2 = new PlaceholderForType[length];
                for (i = 0; i < length; i++) {
                    placeholderForTypeArr2[i] = new PlaceholderForType(i);
                }
                javaTypeI = c(null, cls, TypeBindings.d(cls, placeholderForTypeArr2)).i(javaType._class);
                if (javaTypeI != null) {
                    throw new IllegalArgumentException(String.format("Internal error: unable to locate supertype (%s) from resolved subtype %s", javaType._class.getName(), cls.getName()));
                }
                List<JavaType> listG = javaType.j().g();
                List<JavaType> listG2 = javaTypeI.j().g();
                int size = listG2.size();
                int size2 = listG.size();
                int i2 = 0;
                while (i2 < size2) {
                    JavaType javaType2 = listG.get(i2);
                    JavaType javaTypeK = i2 < size ? listG2.get(i2) : k();
                    if (!f(javaType2, javaTypeK)) {
                        if (javaType2._class == Object.class) {
                            continue;
                        } else {
                            if (i2 != 0 || !javaType.z()) {
                                if (javaType2._class.isInterface()) {
                                    Class<?> cls3 = javaTypeK._class;
                                    Class<?> cls4 = javaType2._class;
                                    if (cls4 == cls3 || cls4.isAssignableFrom(cls3)) {
                                    }
                                }
                                str = String.format("Type parameter #%d/%d differs; can not specialize %s with %s", Integer.valueOf(i2 + 1), Integer.valueOf(size2), javaType2.e(), javaTypeK.e());
                                break;
                            }
                            if (javaTypeK._class == Object.class) {
                                continue;
                            }
                        }
                    }
                    i2++;
                }
                str = null;
                if (str != null && !z2) {
                    StringBuilder sbU = outline.U("Failed to specialize base type ");
                    sbU.append(javaType.e());
                    sbU.append(" as ");
                    sbU.append(cls.getName());
                    sbU.append(", problem: ");
                    sbU.append(str);
                    throw new IllegalArgumentException(sbU.toString());
                }
                JavaType[] javaTypeArr = new JavaType[length];
                for (int i3 = 0; i3 < length; i3++) {
                    JavaType javaTypeK2 = placeholderForTypeArr2[i3]._actualType;
                    if (javaTypeK2 == null) {
                        javaTypeK2 = k();
                    }
                    javaTypeArr[i3] = javaTypeK2;
                }
                javaTypeC = c(null, cls, TypeBindings.d(cls, javaTypeArr));
            } else {
                javaTypeC = c(null, cls, l);
            }
        }
        return javaTypeC.F(javaType);
    }

    public JavaType[] i(JavaType javaType, Class<?> cls) {
        JavaType javaTypeI = javaType.i(cls);
        return javaTypeI == null ? j : javaTypeI.j().k();
    }

    @Deprecated
    public JavaType j(Class<?> cls) {
        JavaType javaTypeA;
        TypeBindings typeBindings = l;
        return (!typeBindings.i() || (javaTypeA = a(cls)) == null) ? d(cls, typeBindings, null, null) : javaTypeA;
    }
}
