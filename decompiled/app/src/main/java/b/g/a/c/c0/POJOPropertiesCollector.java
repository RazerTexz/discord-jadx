package b.g.a.c.c0;

import b.d.b.a.outline;
import b.g.a.a.JacksonInject;
import b.g.a.a.JsonCreator;
import b.g.a.a.JsonProperty;
import b.g.a.c.AnnotationIntrospector;
import b.g.a.c.JavaType;
import b.g.a.c.MapperFeature;
import b.g.a.c.PropertyName;
import b.g.a.c.PropertyNamingStrategy;
import b.g.a.c.c0.POJOPropertyBuilder;
import b.g.a.c.c0.VisibilityChecker;
import b.g.a.c.i0.ClassUtil;
import b.g.a.c.z.MapperConfig;
import java.lang.annotation.Annotation;
import java.lang.reflect.Modifier;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TreeMap;

/* compiled from: POJOPropertiesCollector.java */
/* renamed from: b.g.a.c.c0.b0, reason: use source file name */
/* loaded from: classes3.dex */
public class POJOPropertiesCollector {
    public final MapperConfig<?> a;

    /* renamed from: b, reason: collision with root package name */
    public final AccessorNamingStrategy f682b;
    public final boolean c;
    public final JavaType d;
    public final AnnotatedClass e;
    public final VisibilityChecker<?> f;
    public final AnnotationIntrospector g;
    public final boolean h;
    public boolean i;
    public LinkedHashMap<String, POJOPropertyBuilder> j;
    public LinkedList<POJOPropertyBuilder> k;
    public Map<PropertyName, PropertyName> l;
    public LinkedList<AnnotatedMember> m;
    public LinkedList<AnnotatedMember> n;
    public LinkedList<AnnotatedMethod> o;
    public LinkedList<AnnotatedMember> p;
    public LinkedList<AnnotatedMember> q;
    public LinkedList<AnnotatedMember> r;

    /* renamed from: s, reason: collision with root package name */
    public HashSet<String> f683s;
    public LinkedHashMap<Object, AnnotatedMember> t;

    public POJOPropertiesCollector(MapperConfig<?> mapperConfig, boolean z2, JavaType javaType, AnnotatedClass annotatedClass, AccessorNamingStrategy accessorNamingStrategy) {
        this.a = mapperConfig;
        this.c = z2;
        this.d = javaType;
        this.e = annotatedClass;
        if (mapperConfig.p()) {
            this.h = true;
            this.g = mapperConfig.e();
        } else {
            this.h = false;
            this.g = NopAnnotationIntrospector.j;
        }
        this.f = mapperConfig.m(javaType._class, annotatedClass);
        this.f682b = accessorNamingStrategy;
        mapperConfig.q(MapperFeature.USE_STD_BEAN_NAMING);
    }

    public void a(Map<String, POJOPropertyBuilder> map, AnnotatedParameter annotatedParameter) {
        POJOPropertyBuilder pOJOPropertyBuilderF;
        JsonCreator.a aVarD;
        String strI = this.g.i(annotatedParameter);
        if (strI == null) {
            strI = "";
        }
        PropertyName propertyNameN = this.g.n(annotatedParameter);
        boolean z2 = (propertyNameN == null || propertyNameN.d()) ? false : true;
        if (!z2) {
            if (strI.isEmpty() || (aVarD = this.g.d(this.a, annotatedParameter._owner)) == null || aVarD == JsonCreator.a.DISABLED) {
                return;
            } else {
                propertyNameN = PropertyName.a(strI);
            }
        }
        PropertyName propertyName = propertyNameN;
        String strB = b(strI);
        if (z2 && strB.isEmpty()) {
            String str = propertyName._simpleName;
            pOJOPropertyBuilderF = map.get(str);
            if (pOJOPropertyBuilderF == null) {
                pOJOPropertyBuilderF = new POJOPropertyBuilder(this.a, this.g, this.c, propertyName);
                map.put(str, pOJOPropertyBuilderF);
            }
        } else {
            pOJOPropertyBuilderF = f(map, strB);
        }
        pOJOPropertyBuilderF.r = new POJOPropertyBuilder.d<>(annotatedParameter, pOJOPropertyBuilderF.r, propertyName, z2, true, false);
        this.k.add(pOJOPropertyBuilderF);
    }

    public final String b(String str) {
        PropertyName propertyName;
        Map<PropertyName, PropertyName> map = this.l;
        return (map == null || (propertyName = map.get(e(str))) == null) ? str : propertyName._simpleName;
    }

    public void c(String str) {
        if (this.c || str == null) {
            return;
        }
        if (this.f683s == null) {
            this.f683s = new HashSet<>();
        }
        this.f683s.add(str);
    }

    public void d(JacksonInject.a aVar, AnnotatedMember annotatedMember) {
        if (aVar == null) {
            return;
        }
        Object obj = aVar._id;
        if (this.t == null) {
            this.t = new LinkedHashMap<>();
        }
        AnnotatedMember annotatedMemberPut = this.t.put(obj, annotatedMember);
        if (annotatedMemberPut == null || annotatedMemberPut.getClass() != annotatedMember.getClass()) {
            return;
        }
        throw new IllegalArgumentException("Duplicate injectable value with id '" + obj + "' (of type " + obj.getClass().getName() + ")");
    }

    public final PropertyName e(String str) {
        return PropertyName.b(str, null);
    }

    public POJOPropertyBuilder f(Map<String, POJOPropertyBuilder> map, String str) {
        POJOPropertyBuilder pOJOPropertyBuilder = map.get(str);
        if (pOJOPropertyBuilder != null) {
            return pOJOPropertyBuilder;
        }
        POJOPropertyBuilder pOJOPropertyBuilder2 = new POJOPropertyBuilder(this.a, this.g, this.c, PropertyName.a(str));
        map.put(str, pOJOPropertyBuilder2);
        return pOJOPropertyBuilder2;
    }

    public boolean g(POJOPropertyBuilder pOJOPropertyBuilder, List<POJOPropertyBuilder> list) {
        if (list != null) {
            String str = pOJOPropertyBuilder.p._simpleName;
            int size = list.size();
            for (int i = 0; i < size; i++) {
                if (list.get(i).p._simpleName.equals(str)) {
                    list.set(i, pOJOPropertyBuilder);
                    return true;
                }
            }
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:179:0x0341  */
    /* JADX WARN: Removed duplicated region for block: B:452:0x087e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void h() {
        PropertyNamingStrategy propertyNamingStrategy;
        boolean zBooleanValue;
        boolean z2;
        Collection<POJOPropertyBuilder> collectionValues;
        String strC;
        HashSet<String> hashSet;
        JsonProperty.a aVarT;
        POJOPropertyBuilder.d<AnnotatedParameter> dVar;
        POJOPropertyBuilder.d<AnnotatedMethod> dVar2;
        POJOPropertyBuilder.d<AnnotatedField> dVar3;
        POJOPropertyBuilder.d<AnnotatedMethod> dVar4;
        POJOPropertyBuilder.d<AnnotatedMethod> dVar5;
        POJOPropertyBuilder.d<AnnotatedField> dVar6;
        POJOPropertyBuilder.d<AnnotatedParameter> dVar7;
        POJOPropertyBuilder.d<AnnotatedMethod> dVar8;
        boolean z3;
        String strI;
        PropertyName propertyName;
        boolean z4;
        boolean z5;
        boolean zF;
        String strI2;
        PropertyName propertyName2;
        boolean z6;
        boolean zF2;
        PropertyName propertyNameE;
        boolean z7;
        boolean z8;
        boolean z9;
        LinkedHashMap<String, POJOPropertyBuilder> linkedHashMap = new LinkedHashMap<>();
        AnnotationIntrospector annotationIntrospector = this.g;
        boolean z10 = (this.c || this.a.q(MapperFeature.ALLOW_FINAL_FIELDS_AS_MUTATORS)) ? false : true;
        boolean zQ = this.a.q(MapperFeature.PROPAGATE_TRANSIENT_MARKER);
        for (AnnotatedField annotatedField : this.e.g()) {
            Boolean bool = Boolean.TRUE;
            if (bool.equals(annotationIntrospector.V(this.a, annotatedField))) {
                if (this.q == null) {
                    this.q = new LinkedList<>();
                }
                this.q.add(annotatedField);
            }
            if (bool.equals(annotationIntrospector.W(annotatedField))) {
                if (this.r == null) {
                    this.r = new LinkedList<>();
                }
                this.r.add(annotatedField);
            } else {
                boolean zEquals = bool.equals(annotationIntrospector.S(annotatedField));
                boolean zEquals2 = bool.equals(annotationIntrospector.U(annotatedField));
                if (zEquals || zEquals2) {
                    if (zEquals) {
                        if (this.n == null) {
                            this.n = new LinkedList<>();
                        }
                        this.n.add(annotatedField);
                    }
                    if (zEquals2) {
                        if (this.p == null) {
                            this.p = new LinkedList<>();
                        }
                        this.p.add(annotatedField);
                    }
                } else {
                    String strI3 = annotationIntrospector.i(annotatedField);
                    if (strI3 == null) {
                        strI3 = annotatedField.c();
                    }
                    Objects.requireNonNull((DefaultAccessorNamingStrategy) this.f682b);
                    if (strI3 != null) {
                        PropertyName propertyNameE2 = e(strI3);
                        PropertyName propertyNameE3 = annotationIntrospector.E(this.a, annotatedField, propertyNameE2);
                        if (propertyNameE3 != null && !propertyNameE3.equals(propertyNameE2)) {
                            if (this.l == null) {
                                this.l = new HashMap();
                            }
                            this.l.put(propertyNameE3, propertyNameE2);
                        }
                        PropertyName propertyNameO = this.c ? annotationIntrospector.o(annotatedField) : annotationIntrospector.n(annotatedField);
                        boolean z11 = propertyNameO != null;
                        if (z11 && propertyNameO.d()) {
                            propertyNameE = e(strI3);
                            z7 = false;
                        } else {
                            propertyNameE = propertyNameO;
                            z7 = z11;
                        }
                        boolean zF3 = propertyNameE != null;
                        if (!zF3) {
                            VisibilityChecker.a aVar = (VisibilityChecker.a) this.f;
                            Objects.requireNonNull(aVar);
                            zF3 = aVar._fieldMinLevel.f(annotatedField.l);
                        }
                        boolean Z = annotationIntrospector.Z(annotatedField);
                        if (!Modifier.isTransient(annotatedField.l.getModifiers()) || z11) {
                            z8 = Z;
                            z9 = zF3;
                        } else if (zQ) {
                            z9 = false;
                            z8 = true;
                        } else {
                            z8 = Z;
                            z9 = false;
                        }
                        if (!z10 || propertyNameE != null || z8 || !Modifier.isFinal(annotatedField.l.getModifiers())) {
                            POJOPropertyBuilder pOJOPropertyBuilderF = f(linkedHashMap, strI3);
                            pOJOPropertyBuilderF.q = new POJOPropertyBuilder.d<>(annotatedField, pOJOPropertyBuilderF.q, propertyNameE, z7, z9, z8);
                        }
                    }
                }
            }
        }
        Iterator<AnnotatedMethod> it = ((AnnotatedMethodMap) this.e.h()).iterator();
        while (it.hasNext()) {
            AnnotatedMethod next = it.next();
            int iO = next.o();
            if (iO == 0) {
                AnnotationIntrospector annotationIntrospector2 = this.g;
                Class<?> returnType = next.l.getReturnType();
                if (returnType != Void.TYPE && (returnType != Void.class || this.a.q(MapperFeature.ALLOW_VOID_VALUED_PROPERTIES))) {
                    Boolean bool2 = Boolean.TRUE;
                    if (bool2.equals(annotationIntrospector2.S(next))) {
                        if (this.m == null) {
                            this.m = new LinkedList<>();
                        }
                        this.m.add(next);
                    } else if (bool2.equals(annotationIntrospector2.V(this.a, next))) {
                        if (this.q == null) {
                            this.q = new LinkedList<>();
                        }
                        this.q.add(next);
                    } else if (bool2.equals(annotationIntrospector2.W(next))) {
                        if (this.r == null) {
                            this.r = new LinkedList<>();
                        }
                        this.r.add(next);
                    } else {
                        PropertyName propertyNameO2 = annotationIntrospector2.o(next);
                        boolean z12 = propertyNameO2 != null;
                        if (z12) {
                            strI = annotationIntrospector2.i(next);
                            if (strI == null && (strI = this.f682b.c(next, next.c())) == null) {
                                strI = this.f682b.a(next, next.c());
                            }
                            if (strI == null) {
                                strI = next.c();
                            }
                            if (propertyNameO2.d()) {
                                propertyNameO2 = e(strI);
                                z12 = false;
                            }
                            propertyName = propertyNameO2;
                            z4 = z12;
                            z5 = true;
                        } else {
                            strI = annotationIntrospector2.i(next);
                            if (strI == null) {
                                strI = this.f682b.c(next, next.c());
                            }
                            if (strI == null) {
                                strI = this.f682b.a(next, next.c());
                                if (strI != null) {
                                    VisibilityChecker.a aVar2 = (VisibilityChecker.a) this.f;
                                    Objects.requireNonNull(aVar2);
                                    zF = aVar2._isGetterMinLevel.f(next.l);
                                }
                            } else {
                                VisibilityChecker.a aVar3 = (VisibilityChecker.a) this.f;
                                Objects.requireNonNull(aVar3);
                                zF = aVar3._getterMinLevel.f(next.l);
                            }
                            z4 = z12;
                            z5 = zF;
                            propertyName = propertyNameO2;
                        }
                        String strB = b(strI);
                        boolean Z2 = annotationIntrospector2.Z(next);
                        POJOPropertyBuilder pOJOPropertyBuilderF2 = f(linkedHashMap, strB);
                        pOJOPropertyBuilderF2.f687s = new POJOPropertyBuilder.d<>(next, pOJOPropertyBuilderF2.f687s, propertyName, z4, z5, Z2);
                    }
                }
            } else if (iO == 1) {
                AnnotationIntrospector annotationIntrospector3 = this.g;
                PropertyName propertyNameN = annotationIntrospector3.n(next);
                boolean z13 = propertyNameN != null;
                if (z13) {
                    strI2 = annotationIntrospector3.i(next);
                    if (strI2 == null) {
                        strI2 = this.f682b.b(next, next.c());
                    }
                    if (strI2 == null) {
                        strI2 = next.c();
                    }
                    if (propertyNameN.d()) {
                        propertyNameN = e(strI2);
                        z13 = false;
                    }
                    propertyName2 = propertyNameN;
                    z6 = z13;
                    zF2 = true;
                } else {
                    strI2 = annotationIntrospector3.i(next);
                    if (strI2 == null) {
                        strI2 = this.f682b.b(next, next.c());
                    }
                    if (strI2 != null) {
                        VisibilityChecker.a aVar4 = (VisibilityChecker.a) this.f;
                        Objects.requireNonNull(aVar4);
                        z6 = z13;
                        zF2 = aVar4._setterMinLevel.f(next.l);
                        propertyName2 = propertyNameN;
                    }
                }
                String strB2 = b(strI2);
                boolean Z3 = annotationIntrospector3.Z(next);
                POJOPropertyBuilder pOJOPropertyBuilderF3 = f(linkedHashMap, strB2);
                pOJOPropertyBuilderF3.t = new POJOPropertyBuilder.d<>(next, pOJOPropertyBuilderF3.t, propertyName2, z6, zF2, Z3);
            } else if (iO == 2 && Boolean.TRUE.equals(this.g.U(next))) {
                if (this.o == null) {
                    this.o = new LinkedList<>();
                }
                this.o.add(next);
            }
        }
        AnnotatedClass annotatedClass = this.e;
        Boolean boolValueOf = annotatedClass.f685x;
        if (boolValueOf == null) {
            Class<?> cls = annotatedClass.l;
            Annotation[] annotationArr = ClassUtil.a;
            if (Modifier.isStatic(cls.getModifiers())) {
                z3 = false;
                boolValueOf = Boolean.valueOf(z3);
                annotatedClass.f685x = boolValueOf;
            } else {
                if ((ClassUtil.t(cls) ? null : cls.getEnclosingClass()) != null) {
                    z3 = true;
                }
                boolValueOf = Boolean.valueOf(z3);
                annotatedClass.f685x = boolValueOf;
            }
        }
        if (!boolValueOf.booleanValue() && this.h) {
            for (AnnotatedConstructor annotatedConstructor : this.e.f().f686b) {
                if (this.k == null) {
                    this.k = new LinkedList<>();
                }
                int length = annotatedConstructor._constructor.getParameterTypes().length;
                for (int i = 0; i < length; i++) {
                    a(linkedHashMap, annotatedConstructor.m(i));
                }
            }
            for (AnnotatedMethod annotatedMethod : this.e.f().c) {
                if (this.k == null) {
                    this.k = new LinkedList<>();
                }
                int iO2 = annotatedMethod.o();
                for (int i2 = 0; i2 < iO2; i2++) {
                    a(linkedHashMap, annotatedMethod.m(i2));
                }
            }
        }
        Iterator<POJOPropertyBuilder> it2 = linkedHashMap.values().iterator();
        while (it2.hasNext()) {
            POJOPropertyBuilder next2 = it2.next();
            if (!(next2.z(next2.q) || next2.z(next2.f687s) || next2.z(next2.t) || next2.z(next2.r))) {
                it2.remove();
            } else if (next2.y(next2.q) || next2.y(next2.f687s) || next2.y(next2.t) || next2.y(next2.r)) {
                if (next2.u()) {
                    next2.q = next2.G(next2.q);
                    next2.f687s = next2.G(next2.f687s);
                    next2.t = next2.G(next2.t);
                    next2.r = next2.G(next2.r);
                    if (!next2.f()) {
                        c(next2.p());
                    }
                } else {
                    it2.remove();
                    c(next2.p());
                }
            }
        }
        boolean zQ2 = this.a.q(MapperFeature.INFER_PROPERTY_MUTATORS);
        for (POJOPropertyBuilder pOJOPropertyBuilder : linkedHashMap.values()) {
            POJOPropertiesCollector pOJOPropertiesCollector = this.c ? null : this;
            JsonProperty.a aVar5 = JsonProperty.a.AUTO;
            AnnotationIntrospector annotationIntrospector4 = pOJOPropertyBuilder.n;
            if (annotationIntrospector4 == null || (!pOJOPropertyBuilder.l ? ((dVar = pOJOPropertyBuilder.r) == null || (aVarT = annotationIntrospector4.t(dVar.a)) == null || aVarT == aVar5) && (((dVar2 = pOJOPropertyBuilder.t) == null || (aVarT = pOJOPropertyBuilder.n.t(dVar2.a)) == null || aVarT == aVar5) && (((dVar3 = pOJOPropertyBuilder.q) == null || (aVarT = pOJOPropertyBuilder.n.t(dVar3.a)) == null || aVarT == aVar5) && ((dVar4 = pOJOPropertyBuilder.f687s) == null || (aVarT = pOJOPropertyBuilder.n.t(dVar4.a)) == null || aVarT == aVar5))) : ((dVar5 = pOJOPropertyBuilder.f687s) == null || (aVarT = annotationIntrospector4.t(dVar5.a)) == null || aVarT == aVar5) && (((dVar6 = pOJOPropertyBuilder.q) == null || (aVarT = pOJOPropertyBuilder.n.t(dVar6.a)) == null || aVarT == aVar5) && (((dVar7 = pOJOPropertyBuilder.r) == null || (aVarT = pOJOPropertyBuilder.n.t(dVar7.a)) == null || aVarT == aVar5) && ((dVar8 = pOJOPropertyBuilder.t) == null || (aVarT = pOJOPropertyBuilder.n.t(dVar8.a)) == null || aVarT == aVar5))))) {
                aVarT = null;
            }
            if (aVarT != null) {
                aVar5 = aVarT;
            }
            int iOrdinal = aVar5.ordinal();
            if (iOrdinal == 1) {
                if (pOJOPropertiesCollector != null) {
                    pOJOPropertiesCollector.c(pOJOPropertyBuilder.p());
                    Iterator<PropertyName> it3 = pOJOPropertyBuilder.L().iterator();
                    while (it3.hasNext()) {
                        pOJOPropertiesCollector.c(it3.next()._simpleName);
                    }
                }
                pOJOPropertyBuilder.t = null;
                pOJOPropertyBuilder.r = null;
                if (!pOJOPropertyBuilder.l) {
                    pOJOPropertyBuilder.q = null;
                }
            } else if (iOrdinal == 2) {
                pOJOPropertyBuilder.f687s = null;
                if (pOJOPropertyBuilder.l) {
                    pOJOPropertyBuilder.q = null;
                }
            } else if (iOrdinal != 3) {
                pOJOPropertyBuilder.f687s = pOJOPropertyBuilder.H(pOJOPropertyBuilder.f687s);
                pOJOPropertyBuilder.r = pOJOPropertyBuilder.H(pOJOPropertyBuilder.r);
                if (!zQ2 || pOJOPropertyBuilder.f687s == null) {
                    pOJOPropertyBuilder.q = pOJOPropertyBuilder.H(pOJOPropertyBuilder.q);
                    pOJOPropertyBuilder.t = pOJOPropertyBuilder.H(pOJOPropertyBuilder.t);
                }
            }
        }
        Iterator<Map.Entry<String, POJOPropertyBuilder>> it4 = linkedHashMap.entrySet().iterator();
        LinkedList linkedList = null;
        while (it4.hasNext()) {
            POJOPropertyBuilder value = it4.next().getValue();
            Set<PropertyName> setL = value.L();
            if (!setL.isEmpty()) {
                it4.remove();
                if (linkedList == null) {
                    linkedList = new LinkedList();
                }
                if (setL.size() == 1) {
                    linkedList.add(new POJOPropertyBuilder(value, setL.iterator().next()));
                } else {
                    HashMap map = new HashMap();
                    value.B(setL, map, value.q);
                    value.B(setL, map, value.f687s);
                    value.B(setL, map, value.t);
                    value.B(setL, map, value.r);
                    linkedList.addAll(map.values());
                }
            }
        }
        if (linkedList != null) {
            Iterator it5 = linkedList.iterator();
            while (it5.hasNext()) {
                POJOPropertyBuilder pOJOPropertyBuilder2 = (POJOPropertyBuilder) it5.next();
                String strP = pOJOPropertyBuilder2.p();
                POJOPropertyBuilder pOJOPropertyBuilder3 = linkedHashMap.get(strP);
                if (pOJOPropertyBuilder3 == null) {
                    linkedHashMap.put(strP, pOJOPropertyBuilder2);
                } else {
                    pOJOPropertyBuilder3.K(pOJOPropertyBuilder2);
                }
                if (g(pOJOPropertyBuilder2, this.k) && (hashSet = this.f683s) != null) {
                    hashSet.remove(strP);
                }
            }
        }
        for (AnnotatedField annotatedField2 : this.e.g()) {
            d(this.g.j(annotatedField2), annotatedField2);
        }
        Iterator<AnnotatedMethod> it6 = ((AnnotatedMethodMap) this.e.h()).iterator();
        while (it6.hasNext()) {
            AnnotatedMethod next3 = it6.next();
            if (next3.o() == 1) {
                d(this.g.j(next3), next3);
            }
        }
        for (POJOPropertyBuilder pOJOPropertyBuilder4 : linkedHashMap.values()) {
            if (this.c) {
                POJOPropertyBuilder.d<AnnotatedMethod> dVar9 = pOJOPropertyBuilder4.f687s;
                if (dVar9 != null) {
                    pOJOPropertyBuilder4.f687s = pOJOPropertyBuilder4.A(pOJOPropertyBuilder4.f687s, pOJOPropertyBuilder4.F(0, dVar9, pOJOPropertyBuilder4.q, pOJOPropertyBuilder4.r, pOJOPropertyBuilder4.t));
                } else {
                    POJOPropertyBuilder.d<AnnotatedField> dVar10 = pOJOPropertyBuilder4.q;
                    if (dVar10 != null) {
                        pOJOPropertyBuilder4.q = pOJOPropertyBuilder4.A(pOJOPropertyBuilder4.q, pOJOPropertyBuilder4.F(0, dVar10, pOJOPropertyBuilder4.r, pOJOPropertyBuilder4.t));
                    }
                }
            } else {
                POJOPropertyBuilder.d<AnnotatedParameter> dVar11 = pOJOPropertyBuilder4.r;
                if (dVar11 != null) {
                    pOJOPropertyBuilder4.r = pOJOPropertyBuilder4.A(pOJOPropertyBuilder4.r, pOJOPropertyBuilder4.F(0, dVar11, pOJOPropertyBuilder4.t, pOJOPropertyBuilder4.q, pOJOPropertyBuilder4.f687s));
                } else {
                    POJOPropertyBuilder.d<AnnotatedMethod> dVar12 = pOJOPropertyBuilder4.t;
                    if (dVar12 != null) {
                        pOJOPropertyBuilder4.t = pOJOPropertyBuilder4.A(pOJOPropertyBuilder4.t, pOJOPropertyBuilder4.F(0, dVar12, pOJOPropertyBuilder4.q, pOJOPropertyBuilder4.f687s));
                    } else {
                        POJOPropertyBuilder.d<AnnotatedField> dVar13 = pOJOPropertyBuilder4.q;
                        if (dVar13 != null) {
                            pOJOPropertyBuilder4.q = pOJOPropertyBuilder4.A(pOJOPropertyBuilder4.q, pOJOPropertyBuilder4.F(0, dVar13, pOJOPropertyBuilder4.f687s));
                        }
                    }
                }
            }
        }
        for (POJOPropertyBuilder pOJOPropertyBuilder5 : linkedHashMap.values()) {
            pOJOPropertyBuilder5.q = pOJOPropertyBuilder5.J(pOJOPropertyBuilder5.q);
            pOJOPropertyBuilder5.f687s = pOJOPropertyBuilder5.J(pOJOPropertyBuilder5.f687s);
            pOJOPropertyBuilder5.t = pOJOPropertyBuilder5.J(pOJOPropertyBuilder5.t);
            pOJOPropertyBuilder5.r = pOJOPropertyBuilder5.J(pOJOPropertyBuilder5.r);
        }
        Object objP = this.g.p(this.e);
        if (objP == null) {
            propertyNamingStrategy = this.a._base._propertyNamingStrategy;
        } else if (objP instanceof PropertyNamingStrategy) {
            propertyNamingStrategy = (PropertyNamingStrategy) objP;
        } else {
            if (!(objP instanceof Class)) {
                StringBuilder sbU = outline.U("AnnotationIntrospector returned PropertyNamingStrategy definition of type ");
                sbU.append(objP.getClass().getName());
                sbU.append("; expected type PropertyNamingStrategy or Class<PropertyNamingStrategy> instead");
                throw new IllegalStateException(sbU.toString());
            }
            Class cls2 = (Class) objP;
            if (cls2 == PropertyNamingStrategy.class) {
                propertyNamingStrategy = null;
            } else {
                if (!PropertyNamingStrategy.class.isAssignableFrom(cls2)) {
                    throw new IllegalStateException(outline.o(cls2, outline.U("AnnotationIntrospector returned Class "), "; expected Class<PropertyNamingStrategy>"));
                }
                Objects.requireNonNull(this.a._base);
                propertyNamingStrategy = (PropertyNamingStrategy) ClassUtil.g(cls2, this.a.b());
            }
        }
        if (propertyNamingStrategy != null) {
            POJOPropertyBuilder[] pOJOPropertyBuilderArr = (POJOPropertyBuilder[]) linkedHashMap.values().toArray(new POJOPropertyBuilder[linkedHashMap.size()]);
            linkedHashMap.clear();
            for (POJOPropertyBuilder pOJOPropertyBuilder6 : pOJOPropertyBuilderArr) {
                PropertyName propertyName3 = pOJOPropertyBuilder6.o;
                if (!(pOJOPropertyBuilder6.w(pOJOPropertyBuilder6.q) || pOJOPropertyBuilder6.w(pOJOPropertyBuilder6.f687s) || pOJOPropertyBuilder6.w(pOJOPropertyBuilder6.t) || pOJOPropertyBuilder6.w(pOJOPropertyBuilder6.r)) || this.a.q(MapperFeature.ALLOW_EXPLICIT_PROPERTY_RENAMING)) {
                    if (this.c) {
                        strC = pOJOPropertyBuilder6.f687s != null ? propertyNamingStrategy.c(this.a, pOJOPropertyBuilder6.n(), propertyName3._simpleName) : pOJOPropertyBuilder6.q != null ? propertyNamingStrategy.b(this.a, pOJOPropertyBuilder6.l(), propertyName3._simpleName) : null;
                    } else if (pOJOPropertyBuilder6.t != null) {
                        strC = propertyNamingStrategy.d(this.a, pOJOPropertyBuilder6.s(), propertyName3._simpleName);
                    } else if (pOJOPropertyBuilder6.r != null) {
                        strC = propertyNamingStrategy.a(this.a, pOJOPropertyBuilder6.k(), propertyName3._simpleName);
                    } else if (pOJOPropertyBuilder6.q != null) {
                        strC = propertyNamingStrategy.b(this.a, pOJOPropertyBuilder6.l(), propertyName3._simpleName);
                    } else if (pOJOPropertyBuilder6.f687s != null) {
                        strC = propertyNamingStrategy.c(this.a, pOJOPropertyBuilder6.n(), propertyName3._simpleName);
                    }
                }
                if (strC == null || propertyName3._simpleName.equals(strC)) {
                    strC = propertyName3._simpleName;
                } else {
                    PropertyName propertyName4 = pOJOPropertyBuilder6.o;
                    if (!strC.equals(propertyName4._simpleName)) {
                        propertyName4 = new PropertyName(strC, propertyName4._namespace);
                    }
                    if (propertyName4 != pOJOPropertyBuilder6.o) {
                        pOJOPropertyBuilder6 = new POJOPropertyBuilder(pOJOPropertyBuilder6, propertyName4);
                    }
                }
                POJOPropertyBuilder pOJOPropertyBuilder7 = linkedHashMap.get(strC);
                if (pOJOPropertyBuilder7 == null) {
                    linkedHashMap.put(strC, pOJOPropertyBuilder6);
                } else {
                    pOJOPropertyBuilder7.K(pOJOPropertyBuilder6);
                }
                g(pOJOPropertyBuilder6, this.k);
            }
        }
        if (this.a.q(MapperFeature.USE_WRAPPER_NAME_AS_PROPERTY_NAME)) {
            Iterator<Map.Entry<String, POJOPropertyBuilder>> it7 = linkedHashMap.entrySet().iterator();
            while (it7.hasNext()) {
                if (it7.next().getValue().q() != null) {
                    Objects.requireNonNull(this.g);
                }
            }
        }
        AnnotationIntrospector annotationIntrospector5 = this.g;
        Boolean boolJ = annotationIntrospector5.J(this.e);
        if (boolJ == null) {
            MapperConfig<?> mapperConfig = this.a;
            Objects.requireNonNull(mapperConfig);
            zBooleanValue = mapperConfig.q(MapperFeature.SORT_PROPERTIES_ALPHABETICALLY);
        } else {
            zBooleanValue = boolJ.booleanValue();
        }
        Iterator<POJOPropertyBuilder> it8 = linkedHashMap.values().iterator();
        while (true) {
            if (it8.hasNext()) {
                if (it8.next().o()._index != null) {
                    z2 = true;
                    break;
                }
            } else {
                z2 = false;
                break;
            }
        }
        String[] strArrI = annotationIntrospector5.I(this.e);
        if (zBooleanValue || z2 || this.k != null || strArrI != null) {
            int size = linkedHashMap.size();
            Map<? extends Object, ? extends Object> treeMap = zBooleanValue ? new TreeMap<>() : new LinkedHashMap<>(size + size);
            for (POJOPropertyBuilder pOJOPropertyBuilder8 : linkedHashMap.values()) {
                treeMap.put(pOJOPropertyBuilder8.p(), pOJOPropertyBuilder8);
            }
            LinkedHashMap linkedHashMap2 = new LinkedHashMap(size + size);
            if (strArrI != null) {
                for (String strP2 : strArrI) {
                    POJOPropertyBuilder pOJOPropertyBuilder9 = (POJOPropertyBuilder) treeMap.remove(strP2);
                    if (pOJOPropertyBuilder9 == null) {
                        Iterator<POJOPropertyBuilder> it9 = linkedHashMap.values().iterator();
                        while (true) {
                            if (!it9.hasNext()) {
                                break;
                            }
                            POJOPropertyBuilder next4 = it9.next();
                            if (strP2.equals(next4.p._simpleName)) {
                                strP2 = next4.p();
                                pOJOPropertyBuilder9 = next4;
                                break;
                            }
                        }
                    }
                    if (pOJOPropertyBuilder9 != null) {
                        linkedHashMap2.put(strP2, pOJOPropertyBuilder9);
                    }
                }
            }
            if (z2) {
                TreeMap treeMap2 = new TreeMap();
                Iterator<Map.Entry<? extends Object, ? extends Object>> it10 = treeMap.entrySet().iterator();
                while (it10.hasNext()) {
                    POJOPropertyBuilder pOJOPropertyBuilder10 = (POJOPropertyBuilder) it10.next().getValue();
                    Integer num = pOJOPropertyBuilder10.o()._index;
                    if (num != null) {
                        treeMap2.put(num, pOJOPropertyBuilder10);
                        it10.remove();
                    }
                }
                for (POJOPropertyBuilder pOJOPropertyBuilder11 : treeMap2.values()) {
                    linkedHashMap2.put(pOJOPropertyBuilder11.p(), pOJOPropertyBuilder11);
                }
            }
            if (this.k != null && (!zBooleanValue || this.a.q(MapperFeature.SORT_CREATOR_PROPERTIES_FIRST))) {
                if (zBooleanValue) {
                    TreeMap treeMap3 = new TreeMap();
                    Iterator<POJOPropertyBuilder> it11 = this.k.iterator();
                    while (it11.hasNext()) {
                        POJOPropertyBuilder next5 = it11.next();
                        treeMap3.put(next5.p(), next5);
                    }
                    collectionValues = treeMap3.values();
                } else {
                    collectionValues = this.k;
                }
                for (POJOPropertyBuilder pOJOPropertyBuilder12 : collectionValues) {
                    String strP3 = pOJOPropertyBuilder12.p();
                    if (treeMap.containsKey(strP3)) {
                        linkedHashMap2.put(strP3, pOJOPropertyBuilder12);
                    }
                }
            }
            linkedHashMap2.putAll(treeMap);
            linkedHashMap.clear();
            linkedHashMap.putAll(linkedHashMap2);
        }
        this.j = linkedHashMap;
        this.i = true;
    }

    public void i(String str, Object... objArr) {
        if (objArr.length > 0) {
            str = String.format(str, objArr);
        }
        StringBuilder sbU = outline.U("Problem with definition of ");
        sbU.append(this.e);
        sbU.append(": ");
        sbU.append(str);
        throw new IllegalArgumentException(sbU.toString());
    }
}
