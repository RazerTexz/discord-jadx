package b.g.a.c.g0;

import b.c.a.a0.AnimatableValueParser;
import b.d.b.a.outline;
import b.g.a.a.JsonFormat;
import b.g.a.a.JsonIgnoreProperties;
import b.g.a.a.JsonInclude;
import b.g.a.a.JsonIncludeProperties;
import b.g.a.a.JsonTypeInfo;
import b.g.a.a.ObjectIdGenerator;
import b.g.a.a.ObjectIdGenerators3;
import b.g.a.c.AnnotationIntrospector;
import b.g.a.c.BeanDescription;
import b.g.a.c.BeanProperty;
import b.g.a.c.JavaType;
import b.g.a.c.JsonSerializer;
import b.g.a.c.MapperFeature;
import b.g.a.c.PropertyMetadata;
import b.g.a.c.PropertyName;
import b.g.a.c.SerializationConfig;
import b.g.a.c.SerializationFeature;
import b.g.a.c.SerializerProvider;
import b.g.a.c.b0.OptionalHandlerFactory;
import b.g.a.c.c0.AnnotatedClass;
import b.g.a.c.c0.AnnotatedConstructor;
import b.g.a.c.c0.AnnotatedField;
import b.g.a.c.c0.AnnotatedMember;
import b.g.a.c.c0.AnnotatedMethod;
import b.g.a.c.c0.BasicBeanDescription;
import b.g.a.c.c0.BeanPropertyDefinition;
import b.g.a.c.c0.ObjectIdInfo;
import b.g.a.c.c0.POJOPropertiesCollector;
import b.g.a.c.e0.TypeResolverBuilder;
import b.g.a.c.e0.TypeSerializer;
import b.g.a.c.g0.t.FilteredBeanPropertyWriter;
import b.g.a.c.g0.t.FilteredBeanPropertyWriter2;
import b.g.a.c.g0.t.IndexedListSerializer;
import b.g.a.c.g0.t.IndexedStringListSerializer;
import b.g.a.c.g0.t.IteratorSerializer;
import b.g.a.c.g0.t.MapEntrySerializer;
import b.g.a.c.g0.t.ObjectIdWriter;
import b.g.a.c.g0.t.PropertyBasedObjectIdGenerator;
import b.g.a.c.g0.t.StringArraySerializer2;
import b.g.a.c.g0.t.StringCollectionSerializer;
import b.g.a.c.g0.t.UnsupportedTypeSerializer;
import b.g.a.c.g0.t.UnwrappingBeanPropertyWriter;
import b.g.a.c.g0.u.AtomicReferenceSerializer;
import b.g.a.c.g0.u.BeanSerializerBase;
import b.g.a.c.g0.u.ByteBufferSerializer;
import b.g.a.c.g0.u.CalendarSerializer2;
import b.g.a.c.g0.u.CollectionSerializer2;
import b.g.a.c.g0.u.DateSerializer2;
import b.g.a.c.g0.u.EnumSerializer2;
import b.g.a.c.g0.u.EnumSetSerializer2;
import b.g.a.c.g0.u.InetAddressSerializer;
import b.g.a.c.g0.u.InetSocketAddressSerializer;
import b.g.a.c.g0.u.IterableSerializer;
import b.g.a.c.g0.u.MapSerializer2;
import b.g.a.c.g0.u.NumberSerializer;
import b.g.a.c.g0.u.ObjectArraySerializer2;
import b.g.a.c.g0.u.ReferenceTypeSerializer;
import b.g.a.c.g0.u.StdArraySerializers;
import b.g.a.c.g0.u.StdDelegatingSerializer;
import b.g.a.c.g0.u.TimeZoneSerializer2;
import b.g.a.c.g0.u.ToStringSerializer;
import b.g.a.c.h0.ArrayType;
import b.g.a.c.h0.CollectionLikeType;
import b.g.a.c.h0.CollectionType;
import b.g.a.c.h0.MapLikeType;
import b.g.a.c.h0.MapType;
import b.g.a.c.h0.ReferenceType;
import b.g.a.c.h0.TypeFactory;
import b.g.a.c.i0.ArrayIterator2;
import b.g.a.c.i0.ClassUtil;
import b.g.a.c.i0.Converter;
import b.g.a.c.i0.EnumValues;
import b.g.a.c.i0.NameTransformer4;
import b.g.a.c.z.SerializerFactoryConfig;
import com.fasterxml.jackson.databind.JsonMappingException;
import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.RandomAccess;
import java.util.Set;
import java.util.TimeZone;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: BeanSerializerFactory.java */
/* renamed from: b.g.a.c.g0.f, reason: use source file name */
/* loaded from: classes3.dex */
public class BeanSerializerFactory extends BasicSerializerFactory implements Serializable {
    public static final BeanSerializerFactory l = new BeanSerializerFactory(null);
    private static final long serialVersionUID = 1;

    public BeanSerializerFactory(SerializerFactoryConfig serializerFactoryConfig) {
        super(null);
    }

    @Override // b.g.a.c.g0.SerializerFactory2
    public JsonSerializer<Object> b(SerializerProvider serializerProvider, JavaType javaType) throws JsonMappingException {
        JavaType javaTypeE0;
        Object objH;
        SerializationConfig serializationConfig = serializerProvider._config;
        BeanDescription beanDescriptionU = serializationConfig.u(javaType);
        JsonSerializer<?> jsonSerializerF = f(serializerProvider, ((BasicBeanDescription) beanDescriptionU).f);
        if (jsonSerializerF != null) {
            return jsonSerializerF;
        }
        AnnotationIntrospector annotationIntrospectorE = serializationConfig.e();
        boolean z2 = false;
        Converter converter = null;
        if (annotationIntrospectorE == null) {
            javaTypeE0 = javaType;
        } else {
            try {
                javaTypeE0 = annotationIntrospectorE.e0(serializationConfig, ((BasicBeanDescription) beanDescriptionU).f, javaType);
            } catch (JsonMappingException e) {
                serializerProvider.F(beanDescriptionU, e.getMessage(), new Object[0]);
                throw null;
            }
        }
        if (javaTypeE0 != javaType) {
            if (!javaTypeE0.t(javaType._class)) {
                beanDescriptionU = serializationConfig.u(javaTypeE0);
            }
            z2 = true;
        }
        BasicBeanDescription basicBeanDescription = (BasicBeanDescription) beanDescriptionU;
        AnnotationIntrospector annotationIntrospector = basicBeanDescription.e;
        if (annotationIntrospector != null && (objH = annotationIntrospector.H(basicBeanDescription.f)) != null) {
            if (objH instanceof Converter) {
                converter = (Converter) objH;
            } else {
                if (!(objH instanceof Class)) {
                    StringBuilder sbU = outline.U("AnnotationIntrospector returned Converter definition of type ");
                    sbU.append(objH.getClass().getName());
                    sbU.append("; expected type Converter or Class<Converter> instead");
                    throw new IllegalStateException(sbU.toString());
                }
                Class cls = (Class) objH;
                if (cls != Converter.a.class && !ClassUtil.p(cls)) {
                    if (!Converter.class.isAssignableFrom(cls)) {
                        throw new IllegalStateException(outline.o(cls, outline.U("AnnotationIntrospector returned Class "), "; expected Class<Converter>"));
                    }
                    Objects.requireNonNull(basicBeanDescription.d._base);
                    converter = (Converter) ClassUtil.g(cls, basicBeanDescription.d.b());
                }
            }
        }
        if (converter == null) {
            return i(serializerProvider, javaTypeE0, beanDescriptionU, z2);
        }
        JavaType javaTypeA = converter.a(serializerProvider.d());
        if (!javaTypeA.t(javaTypeE0._class)) {
            beanDescriptionU = serializationConfig.u(javaTypeA);
            jsonSerializerF = f(serializerProvider, ((BasicBeanDescription) beanDescriptionU).f);
        }
        if (jsonSerializerF == null && !javaTypeA.y()) {
            jsonSerializerF = i(serializerProvider, javaTypeA, beanDescriptionU, true);
        }
        return new StdDelegatingSerializer(converter, javaTypeA, jsonSerializerF);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:100:0x0218  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x0259  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x02a1  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x02b0  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x02b6  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x020f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public BeanPropertyWriter h(SerializerProvider serializerProvider, BeanPropertyDefinition beanPropertyDefinition, PropertyBuilder propertyBuilder, boolean z2, AnnotatedMember annotatedMember) throws IllegalAccessException, InstantiationException, JsonMappingException, IllegalArgumentException, InvocationTargetException {
        TypeSerializer typeSerializerC;
        boolean z3;
        boolean z4;
        boolean zB;
        Object obj;
        Class<?>[] clsArrI;
        Object objQ;
        Object objT0;
        PropertyName propertyNameM = beanPropertyDefinition.m();
        JavaType javaTypeE = annotatedMember.e();
        BeanProperty.a aVar = new BeanProperty.a(propertyNameM, javaTypeE, beanPropertyDefinition.t(), annotatedMember, beanPropertyDefinition.o());
        JsonSerializer<Object> jsonSerializerF = f(serializerProvider, annotatedMember);
        if (jsonSerializerF instanceof ResolvableSerializer) {
            ((ResolvableSerializer) jsonSerializerF).b(serializerProvider);
        }
        JsonSerializer<?> jsonSerializerY = serializerProvider.y(jsonSerializerF, aVar);
        if (javaTypeE.v() || javaTypeE.b()) {
            SerializationConfig serializationConfig = serializerProvider._config;
            JavaType javaTypeK = javaTypeE.k();
            TypeResolverBuilder<?> typeResolverBuilderU = serializationConfig.e().u(serializationConfig, annotatedMember, javaTypeE);
            typeSerializerC = typeResolverBuilderU == null ? c(serializationConfig, javaTypeK) : typeResolverBuilderU.e(serializationConfig, javaTypeK, serializationConfig._subtypeResolver.a(serializationConfig, annotatedMember, javaTypeK));
        } else {
            typeSerializerC = null;
        }
        SerializationConfig serializationConfig2 = serializerProvider._config;
        TypeResolverBuilder<?> typeResolverBuilderC = serializationConfig2.e().C(serializationConfig2, annotatedMember, javaTypeE);
        TypeSerializer typeSerializerC2 = typeResolverBuilderC == null ? c(serializationConfig2, javaTypeE) : typeResolverBuilderC.e(serializationConfig2, javaTypeE, serializationConfig2._subtypeResolver.a(serializationConfig2, annotatedMember, javaTypeE));
        Object obj2 = JsonInclude.a.NON_EMPTY;
        try {
            JavaType javaTypeA = propertyBuilder.a(annotatedMember, z2, javaTypeE);
            if (typeSerializerC != null) {
                if (javaTypeA == null) {
                    javaTypeA = javaTypeE;
                }
                if (javaTypeA.k() == null) {
                    serializerProvider.E(propertyBuilder.f702b, beanPropertyDefinition, "serialization type " + javaTypeA + " has no content", new Object[0]);
                    throw null;
                }
                JavaType javaTypeE2 = javaTypeA.E(typeSerializerC);
                javaTypeE2.k();
                javaTypeA = javaTypeE2;
            }
            JavaType javaType = javaTypeA == null ? javaTypeE : javaTypeA;
            AnnotatedMember annotatedMemberJ = beanPropertyDefinition.j();
            if (annotatedMemberJ == null) {
                serializerProvider.E(propertyBuilder.f702b, beanPropertyDefinition, "could not determine property type", new Object[0]);
                throw null;
            }
            Class<?> clsD = annotatedMemberJ.d();
            SerializationConfig serializationConfig3 = propertyBuilder.a;
            Class<?> cls = javaType._class;
            JsonInclude.b bVar = propertyBuilder.e;
            serializationConfig3.f(cls);
            serializationConfig3.f(clsD);
            JsonInclude.b[] bVarArr = {bVar, null, null};
            JsonInclude.b bVar2 = JsonInclude.b.j;
            int i = 0;
            JsonInclude.b bVar3 = null;
            for (int i2 = 3; i < i2; i2 = 3) {
                JsonInclude.b bVarA = bVarArr[i];
                if (bVarA != null) {
                    if (bVar3 != null) {
                        bVarA = bVar3.a(bVarA);
                    }
                    bVar3 = bVarA;
                }
                i++;
            }
            JsonInclude.b bVarA2 = bVar3.a(beanPropertyDefinition.g());
            JsonInclude.a aVar2 = bVarA2._valueInclusion;
            if (aVar2 == JsonInclude.a.USE_DEFAULTS) {
                aVar2 = JsonInclude.a.ALWAYS;
            }
            int iOrdinal = aVar2.ordinal();
            if (iOrdinal != 1) {
                if (iOrdinal != 2) {
                    if (iOrdinal != 3) {
                        if (iOrdinal == 4) {
                            if (propertyBuilder.f) {
                                Object objNewInstance = propertyBuilder.d;
                                if (objNewInstance == null) {
                                    BeanDescription beanDescription = propertyBuilder.f702b;
                                    boolean zB2 = propertyBuilder.a.b();
                                    BasicBeanDescription basicBeanDescription = (BasicBeanDescription) beanDescription;
                                    AnnotatedConstructor annotatedConstructor = basicBeanDescription.f.f().a;
                                    if (annotatedConstructor == null) {
                                        objNewInstance = null;
                                    } else {
                                        if (zB2) {
                                            annotatedConstructor.f(basicBeanDescription.d.q(MapperFeature.OVERRIDE_PUBLIC_ACCESS_MODIFIERS));
                                        }
                                        try {
                                            objNewInstance = annotatedConstructor._constructor.newInstance(new Object[0]);
                                        } catch (Exception e) {
                                            e = e;
                                            while (e.getCause() != null) {
                                                e = e.getCause();
                                            }
                                            ClassUtil.w(e);
                                            ClassUtil.x(e);
                                            StringBuilder sbU = outline.U("Failed to instantiate bean of type ");
                                            sbU.append(basicBeanDescription.f.l.getName());
                                            sbU.append(": (");
                                            sbU.append(e.getClass().getName());
                                            sbU.append(") ");
                                            sbU.append(ClassUtil.h(e));
                                            throw new IllegalArgumentException(sbU.toString(), e);
                                        }
                                    }
                                    if (objNewInstance == null) {
                                        objNewInstance = Boolean.FALSE;
                                    }
                                    propertyBuilder.d = objNewInstance;
                                }
                                Object obj3 = objNewInstance == Boolean.FALSE ? null : propertyBuilder.d;
                                if (obj3 != null) {
                                    if (serializerProvider.C(MapperFeature.CAN_OVERRIDE_ACCESS_MODIFIERS)) {
                                        annotatedMember.f(propertyBuilder.a.q(MapperFeature.OVERRIDE_PUBLIC_ACCESS_MODIFIERS));
                                    }
                                    try {
                                        objT0 = annotatedMember.j(obj3);
                                        z3 = false;
                                    } catch (Exception e2) {
                                        e = e2;
                                        String strP = beanPropertyDefinition.p();
                                        while (e.getCause() != null) {
                                            e = e.getCause();
                                        }
                                        ClassUtil.w(e);
                                        ClassUtil.x(e);
                                        StringBuilder sbY = outline.Y("Failed to get property '", strP, "' of default ");
                                        sbY.append(obj3.getClass().getName());
                                        sbY.append(" instance");
                                        throw new IllegalArgumentException(sbY.toString());
                                    }
                                }
                                if (objT0 != null) {
                                }
                            } else {
                                objT0 = AnimatableValueParser.t0(javaType);
                                z3 = true;
                                if (objT0 != null) {
                                    if (objT0.getClass().isArray()) {
                                        objT0 = AnimatableValueParser.q0(objT0);
                                    }
                                    obj2 = objT0;
                                    zB = z3;
                                    obj = obj2;
                                }
                            }
                            clsArrI = beanPropertyDefinition.i();
                            if (clsArrI == null) {
                            }
                            BeanPropertyWriter beanPropertyWriter = new BeanPropertyWriter(beanPropertyDefinition, annotatedMember, ((BasicBeanDescription) propertyBuilder.f702b).f.t, javaTypeE, jsonSerializerY, typeSerializerC2, javaTypeA, zB, obj, clsArrI);
                            objQ = propertyBuilder.c.q(annotatedMember);
                            if (objQ != null) {
                            }
                            NameTransformer4 nameTransformer4Q = propertyBuilder.c.Q(annotatedMember);
                            if (nameTransformer4Q == null) {
                            }
                        } else if (iOrdinal != 5) {
                            z3 = false;
                        } else {
                            objT0 = serializerProvider.A(beanPropertyDefinition, bVarA2._valueFilter);
                            if (objT0 != null) {
                                obj = objT0;
                                zB = serializerProvider.B(objT0);
                                clsArrI = beanPropertyDefinition.i();
                                if (clsArrI == null) {
                                    BasicBeanDescription basicBeanDescription2 = (BasicBeanDescription) propertyBuilder.f702b;
                                    if (!basicBeanDescription2.h) {
                                        basicBeanDescription2.h = true;
                                        AnnotationIntrospector annotationIntrospector = basicBeanDescription2.e;
                                        Class<?>[] clsArrR = annotationIntrospector == null ? null : annotationIntrospector.R(basicBeanDescription2.f);
                                        if (clsArrR == null && !basicBeanDescription2.d.q(MapperFeature.DEFAULT_VIEW_INCLUSION)) {
                                            clsArrR = BasicBeanDescription.f693b;
                                        }
                                        basicBeanDescription2.g = clsArrR;
                                    }
                                    clsArrI = basicBeanDescription2.g;
                                }
                                BeanPropertyWriter beanPropertyWriter2 = new BeanPropertyWriter(beanPropertyDefinition, annotatedMember, ((BasicBeanDescription) propertyBuilder.f702b).f.t, javaTypeE, jsonSerializerY, typeSerializerC2, javaTypeA, zB, obj, clsArrI);
                                objQ = propertyBuilder.c.q(annotatedMember);
                                if (objQ != null) {
                                    beanPropertyWriter2.e(serializerProvider.H(annotatedMember, objQ));
                                }
                                NameTransformer4 nameTransformer4Q2 = propertyBuilder.c.Q(annotatedMember);
                                return nameTransformer4Q2 == null ? new UnwrappingBeanPropertyWriter(beanPropertyWriter2, nameTransformer4Q2) : beanPropertyWriter2;
                            }
                        }
                        obj2 = objT0;
                    } else {
                        int i3 = BeanPropertyWriter.j;
                    }
                } else if (javaType.b()) {
                    int i4 = BeanPropertyWriter.j;
                } else {
                    z4 = true;
                    zB = z4;
                    obj = null;
                    clsArrI = beanPropertyDefinition.i();
                    if (clsArrI == null) {
                    }
                    BeanPropertyWriter beanPropertyWriter22 = new BeanPropertyWriter(beanPropertyDefinition, annotatedMember, ((BasicBeanDescription) propertyBuilder.f702b).f.t, javaTypeE, jsonSerializerY, typeSerializerC2, javaTypeA, zB, obj, clsArrI);
                    objQ = propertyBuilder.c.q(annotatedMember);
                    if (objQ != null) {
                    }
                    NameTransformer4 nameTransformer4Q22 = propertyBuilder.c.Q(annotatedMember);
                    if (nameTransformer4Q22 == null) {
                    }
                }
                obj = obj2;
                zB = true;
                clsArrI = beanPropertyDefinition.i();
                if (clsArrI == null) {
                }
                BeanPropertyWriter beanPropertyWriter222 = new BeanPropertyWriter(beanPropertyDefinition, annotatedMember, ((BasicBeanDescription) propertyBuilder.f702b).f.t, javaTypeE, jsonSerializerY, typeSerializerC2, javaTypeA, zB, obj, clsArrI);
                objQ = propertyBuilder.c.q(annotatedMember);
                if (objQ != null) {
                }
                NameTransformer4 nameTransformer4Q222 = propertyBuilder.c.Q(annotatedMember);
                if (nameTransformer4Q222 == null) {
                }
            } else {
                z3 = true;
            }
            SerializationFeature serializationFeature = SerializationFeature.WRITE_EMPTY_JSON_ARRAYS;
            if (!javaType.v() || propertyBuilder.a.v(serializationFeature)) {
                z4 = z3;
                zB = z4;
                obj = null;
                clsArrI = beanPropertyDefinition.i();
                if (clsArrI == null) {
                }
                BeanPropertyWriter beanPropertyWriter2222 = new BeanPropertyWriter(beanPropertyDefinition, annotatedMember, ((BasicBeanDescription) propertyBuilder.f702b).f.t, javaTypeE, jsonSerializerY, typeSerializerC2, javaTypeA, zB, obj, clsArrI);
                objQ = propertyBuilder.c.q(annotatedMember);
                if (objQ != null) {
                }
                NameTransformer4 nameTransformer4Q2222 = propertyBuilder.c.Q(annotatedMember);
                if (nameTransformer4Q2222 == null) {
                }
            } else {
                int i5 = BeanPropertyWriter.j;
                zB = z3;
                obj = obj2;
                clsArrI = beanPropertyDefinition.i();
                if (clsArrI == null) {
                }
                BeanPropertyWriter beanPropertyWriter22222 = new BeanPropertyWriter(beanPropertyDefinition, annotatedMember, ((BasicBeanDescription) propertyBuilder.f702b).f.t, javaTypeE, jsonSerializerY, typeSerializerC2, javaTypeA, zB, obj, clsArrI);
                objQ = propertyBuilder.c.q(annotatedMember);
                if (objQ != null) {
                }
                NameTransformer4 nameTransformer4Q22222 = propertyBuilder.c.Q(annotatedMember);
                if (nameTransformer4Q22222 == null) {
                }
            }
        } catch (JsonMappingException e3) {
            serializerProvider.E(propertyBuilder.f702b, beanPropertyDefinition, ClassUtil.h(e3), new Object[0]);
            throw null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:167:0x02fc  */
    /* JADX WARN: Removed duplicated region for block: B:203:0x03c6  */
    /* JADX WARN: Removed duplicated region for block: B:262:0x04bf A[PHI: r4
      0x04bf: PHI (r4v14 int) = (r4v13 int), (r4v16 int) binds: [B:260:0x04ba, B:247:0x048b] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:349:0x0658  */
    /* JADX WARN: Removed duplicated region for block: B:353:0x065e  */
    /* JADX WARN: Removed duplicated region for block: B:356:0x0663  */
    /* JADX WARN: Removed duplicated region for block: B:408:0x0729  */
    /* JADX WARN: Removed duplicated region for block: B:429:0x078f  */
    /* JADX WARN: Removed duplicated region for block: B:431:0x0792  */
    /* JADX WARN: Removed duplicated region for block: B:432:0x0795  */
    /* JADX WARN: Removed duplicated region for block: B:479:0x0891  */
    /* JADX WARN: Removed duplicated region for block: B:604:0x0b18  */
    /* JADX WARN: Removed duplicated region for block: B:606:0x0b1b  */
    /* JADX WARN: Removed duplicated region for block: B:612:0x0b6e  */
    /* JADX WARN: Removed duplicated region for block: B:629:0x0ba5  */
    /* JADX WARN: Removed duplicated region for block: B:631:0x0bad  */
    /* JADX WARN: Removed duplicated region for block: B:676:0x0c71  */
    /* JADX WARN: Removed duplicated region for block: B:680:0x0c9d  */
    /* JADX WARN: Type inference failed for: r26v0, types: [b.g.a.c.g0.b, b.g.a.c.g0.f] */
    /* JADX WARN: Type inference failed for: r5v33, types: [b.g.a.c.g0.t.i] */
    /* JADX WARN: Type inference failed for: r5v34 */
    /* JADX WARN: Type inference failed for: r5v35 */
    /* JADX WARN: Type inference failed for: r5v8, types: [b.g.a.c.n] */
    /* JADX WARN: Type inference failed for: r5v9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public JsonSerializer<?> i(SerializerProvider serializerProvider, JavaType javaType, BeanDescription beanDescription, boolean z2) throws JsonMappingException {
        JsonInclude.a aVar;
        JsonInclude.a aVar2;
        JsonFormat.c cVar;
        Class<Enum> cls;
        BeanDescription beanDescription2;
        int i;
        JsonSerializer<?> jsonSerializerE;
        JsonSerializer<?> jsonSerializerA;
        int i2;
        Object objT0;
        boolean zB;
        int i3;
        char c;
        int iOrdinal;
        Object objT02;
        boolean zB2;
        String str;
        String str2;
        String str3;
        UnsupportedTypeSerializer unsupportedTypeSerializer;
        boolean z3;
        ArrayList arrayList;
        boolean z4;
        ArrayList arrayList2;
        boolean zEquals;
        ObjectIdWriter objectIdWriterA;
        AnnotatedMember first;
        boolean zQ;
        int size;
        int i4;
        List<BeanPropertyWriter> list;
        JsonSerializer<?> jsonSerializerX;
        EnumSerializer2 enumSerializer2;
        Class<? extends JsonSerializer<?>> cls2;
        boolean z5;
        boolean z6;
        TypeSerializer typeSerializer;
        JsonSerializer<Object> jsonSerializer;
        JsonSerializer<?> collectionSerializer2;
        JsonFormat.c cVar2;
        SerializationConfig serializationConfig;
        JsonSerializer<Object> jsonSerializer2;
        BasicBeanDescription basicBeanDescription;
        boolean z7;
        TypeSerializer typeSerializer2;
        Object objT03;
        boolean zB3;
        BeanDescription beanDescription3 = beanDescription;
        boolean z8 = z2;
        Class<Enum> cls3 = Enum.class;
        JsonFormat.c cVar3 = JsonFormat.c.OBJECT;
        JsonInclude.a aVar3 = JsonInclude.a.ALWAYS;
        JsonInclude.a aVar4 = JsonInclude.a.USE_DEFAULTS;
        SerializationConfig serializationConfig2 = serializerProvider._config;
        if (javaType.v()) {
            boolean zG = !z8 ? g(serializationConfig2, beanDescription3, null) : z8;
            SerializationConfig serializationConfig3 = serializerProvider._config;
            boolean z9 = (zG || !javaType._asStatic || (javaType.v() && javaType.k().y())) ? zG : true;
            TypeSerializer typeSerializerC = c(serializationConfig3, javaType.k());
            boolean z10 = typeSerializerC != null ? false : z9;
            BasicBeanDescription basicBeanDescription2 = (BasicBeanDescription) beanDescription3;
            AnnotatedClass annotatedClass = basicBeanDescription2.f;
            Object objC = serializerProvider.v().c(annotatedClass);
            JsonSerializer<Object> jsonSerializerH = objC != null ? serializerProvider.H(annotatedClass, objC) : null;
            if (javaType.z()) {
                MapLikeType mapLikeType = (MapLikeType) javaType;
                AnnotatedClass annotatedClass2 = basicBeanDescription2.f;
                Object objL = serializerProvider.v().l(annotatedClass2);
                JsonSerializer<Object> jsonSerializerH2 = objL != null ? serializerProvider.H(annotatedClass2, objL) : null;
                if (mapLikeType instanceof MapType) {
                    MapType mapType = (MapType) mapLikeType;
                    if (beanDescription3.a(null).e() == cVar3) {
                        jsonSerializerE = null;
                        cVar2 = cVar3;
                    } else {
                        SerializationConfig serializationConfig4 = serializerProvider._config;
                        ArrayIterator2 arrayIterator2 = (ArrayIterator2) j();
                        JsonSerializer<?> jsonSerializerE2 = null;
                        while (true) {
                            if (!arrayIterator2.hasNext()) {
                                cVar2 = cVar3;
                                serializationConfig = serializationConfig4;
                                jsonSerializer2 = jsonSerializerH;
                                basicBeanDescription = basicBeanDescription2;
                                z7 = z10;
                                typeSerializer2 = typeSerializerC;
                                break;
                            }
                            serializationConfig = serializationConfig4;
                            jsonSerializer2 = jsonSerializerH;
                            cVar2 = cVar3;
                            basicBeanDescription = basicBeanDescription2;
                            z7 = z10;
                            typeSerializer2 = typeSerializerC;
                            jsonSerializerE2 = ((Serializers) arrayIterator2.next()).c(serializationConfig4, mapType, beanDescription, jsonSerializerH2, typeSerializerC, jsonSerializer2);
                            if (jsonSerializerE2 != null) {
                                break;
                            }
                            serializationConfig4 = serializationConfig;
                            basicBeanDescription2 = basicBeanDescription;
                            z10 = z7;
                            typeSerializerC = typeSerializer2;
                            jsonSerializerH = jsonSerializer2;
                            cVar3 = cVar2;
                        }
                        if (jsonSerializerE2 == null && (jsonSerializerE2 = e(serializerProvider, mapType, beanDescription3)) == null) {
                            Object objG = serializationConfig.e().g(basicBeanDescription.f);
                            SerializationConfig serializationConfig5 = serializationConfig;
                            JsonIgnoreProperties.a aVarS = serializationConfig5.s(Map.class, basicBeanDescription.f);
                            Set<String> setD = aVarS == null ? null : aVarS.d();
                            AnnotatedClass annotatedClass3 = basicBeanDescription.f;
                            AnnotationIntrospector annotationIntrospectorE = serializationConfig5.e();
                            JsonIncludeProperties.a aVarA = annotationIntrospectorE == null ? null : annotationIntrospectorE.A(serializationConfig5, annotatedClass3);
                            MapSerializer2 mapSerializer2S = MapSerializer2.s(setD, aVarA == null ? null : aVarA._included, mapType, z7, typeSerializer2, jsonSerializerH2, jsonSerializer2, objG);
                            JavaType javaType2 = mapSerializer2S._valueType;
                            JsonInclude.b bVarD = d(serializerProvider, beanDescription3, javaType2, Map.class);
                            JsonInclude.a aVar5 = bVarD == null ? aVar4 : bVarD._contentInclusion;
                            if (aVar5 == aVar4 || aVar5 == aVar3) {
                                jsonSerializerE = mapSerializer2S;
                                if (!serializerProvider.D(SerializationFeature.WRITE_NULL_MAP_VALUES)) {
                                    jsonSerializerE = mapSerializer2S.v(null, true);
                                }
                            } else {
                                int iOrdinal2 = aVar5.ordinal();
                                if (iOrdinal2 != 2) {
                                    if (iOrdinal2 == 3) {
                                        objT03 = MapSerializer2.l;
                                    } else if (iOrdinal2 == 4) {
                                        objT03 = AnimatableValueParser.t0(javaType2);
                                        if (objT03 != null && objT03.getClass().isArray()) {
                                            objT03 = AnimatableValueParser.q0(objT03);
                                        }
                                    } else if (iOrdinal2 != 5) {
                                        zB3 = true;
                                        objT03 = null;
                                    } else {
                                        objT03 = serializerProvider.A(null, bVarD._contentFilter);
                                        if (objT03 != null) {
                                            zB3 = serializerProvider.B(objT03);
                                        }
                                    }
                                    zB3 = true;
                                } else {
                                    if (javaType2.b()) {
                                        objT03 = MapSerializer2.l;
                                        zB3 = true;
                                    }
                                    zB3 = true;
                                    objT03 = null;
                                }
                                jsonSerializerE = mapSerializer2S.v(objT03, zB3);
                            }
                        } else {
                            jsonSerializerE = jsonSerializerE2;
                        }
                        if (this._factoryConfig.a()) {
                            ArrayIterator2 arrayIterator22 = (ArrayIterator2) this._factoryConfig.b();
                            while (arrayIterator22.hasNext()) {
                                Objects.requireNonNull((BeanSerializerModifier) arrayIterator22.next());
                            }
                        }
                    }
                } else {
                    cVar2 = cVar3;
                    JsonSerializer<?> jsonSerializerF = null;
                    ArrayIterator2 arrayIterator23 = (ArrayIterator2) j();
                    while (arrayIterator23.hasNext()) {
                        MapLikeType mapLikeType2 = mapLikeType;
                        jsonSerializerF = ((Serializers) arrayIterator23.next()).f(serializationConfig3, mapLikeType, beanDescription, jsonSerializerH2, typeSerializerC, jsonSerializerH);
                        if (jsonSerializerF != null) {
                            break;
                        }
                        mapLikeType = mapLikeType2;
                    }
                    jsonSerializerE = jsonSerializerF == null ? e(serializerProvider, javaType, beanDescription) : jsonSerializerF;
                    if (jsonSerializerE != null && this._factoryConfig.a()) {
                        ArrayIterator2 arrayIterator24 = (ArrayIterator2) this._factoryConfig.b();
                        while (arrayIterator24.hasNext()) {
                            Objects.requireNonNull((BeanSerializerModifier) arrayIterator24.next());
                        }
                    }
                }
                aVar = aVar4;
                aVar2 = aVar3;
                cls = cls3;
                beanDescription2 = beanDescription3;
                cVar = cVar2;
            } else {
                JsonFormat.c cVar4 = cVar3;
                boolean z11 = z10;
                JsonSerializer<?> jsonSerializerE3 = null;
                if (javaType.u()) {
                    CollectionLikeType collectionLikeType = (CollectionLikeType) javaType;
                    if (collectionLikeType instanceof CollectionType) {
                        CollectionType collectionType = (CollectionType) collectionLikeType;
                        SerializationConfig serializationConfig6 = serializerProvider._config;
                        ArrayIterator2 arrayIterator25 = (ArrayIterator2) j();
                        while (true) {
                            if (!arrayIterator25.hasNext()) {
                                aVar = aVar4;
                                aVar2 = aVar3;
                                cls = cls3;
                                beanDescription2 = beanDescription3;
                                cVar = cVar4;
                                break;
                            }
                            Serializers serializers = (Serializers) arrayIterator25.next();
                            aVar = aVar4;
                            SerializationConfig serializationConfig7 = serializationConfig6;
                            aVar2 = aVar3;
                            cVar = cVar4;
                            SerializationConfig serializationConfig8 = serializationConfig6;
                            cls = cls3;
                            ArrayIterator2 arrayIterator26 = arrayIterator25;
                            beanDescription2 = beanDescription3;
                            jsonSerializerE3 = serializers.g(serializationConfig7, collectionType, beanDescription, typeSerializerC, jsonSerializerH);
                            if (jsonSerializerE3 != null) {
                                break;
                            }
                            cls3 = cls;
                            beanDescription3 = beanDescription2;
                            aVar4 = aVar;
                            aVar3 = aVar2;
                            cVar4 = cVar;
                            serializationConfig6 = serializationConfig8;
                            arrayIterator25 = arrayIterator26;
                        }
                        if (jsonSerializerE3 == null && (jsonSerializerE3 = e(serializerProvider, collectionType, beanDescription2)) == null) {
                            if (beanDescription2.a(null).e() != cVar) {
                                Class<?> cls4 = collectionType._class;
                                if (EnumSet.class.isAssignableFrom(cls4)) {
                                    JavaType javaType3 = collectionType._elementType;
                                    if (!(ClassUtil.q(javaType3._class) && javaType3._class != cls)) {
                                        javaType3 = null;
                                    }
                                    collectionSerializer2 = new EnumSetSerializer2(javaType3);
                                } else {
                                    Class<?> cls5 = collectionType._elementType._class;
                                    if (!RandomAccess.class.isAssignableFrom(cls4)) {
                                        z6 = z11;
                                        typeSerializer = typeSerializerC;
                                        jsonSerializer = jsonSerializerH;
                                        if (cls5 == String.class && ClassUtil.s(jsonSerializer)) {
                                            jsonSerializerE3 = StringCollectionSerializer.k;
                                        }
                                    } else if (cls5 == String.class) {
                                        if (ClassUtil.s(jsonSerializerH)) {
                                            jsonSerializerE3 = IndexedStringListSerializer.k;
                                        }
                                        z6 = z11;
                                        typeSerializer = typeSerializerC;
                                        jsonSerializer = jsonSerializerH;
                                    } else {
                                        z6 = z11;
                                        typeSerializer = typeSerializerC;
                                        jsonSerializer = jsonSerializerH;
                                        jsonSerializerE3 = new IndexedListSerializer(collectionType._elementType, z6, typeSerializer, jsonSerializer);
                                    }
                                    if (jsonSerializerE3 == null) {
                                        collectionSerializer2 = new CollectionSerializer2(collectionType._elementType, z6, typeSerializer, jsonSerializer);
                                    }
                                    jsonSerializerE = jsonSerializerE3;
                                    if (this._factoryConfig.a()) {
                                    }
                                }
                                jsonSerializerE = collectionSerializer2;
                                if (this._factoryConfig.a()) {
                                }
                            }
                            jsonSerializerE = null;
                        } else {
                            jsonSerializerE = jsonSerializerE3;
                            if (this._factoryConfig.a()) {
                                ArrayIterator2 arrayIterator27 = (ArrayIterator2) this._factoryConfig.b();
                                while (arrayIterator27.hasNext()) {
                                    Objects.requireNonNull((BeanSerializerModifier) arrayIterator27.next());
                                }
                            }
                        }
                    } else {
                        aVar = aVar4;
                        aVar2 = aVar3;
                        cls = cls3;
                        beanDescription2 = beanDescription3;
                        TypeSerializer typeSerializer3 = typeSerializerC;
                        JsonSerializer<Object> jsonSerializer3 = jsonSerializerH;
                        cVar = cVar4;
                        ArrayIterator2 arrayIterator28 = (ArrayIterator2) j();
                        JsonSerializer<?> jsonSerializerD = null;
                        while (arrayIterator28.hasNext()) {
                            SerializationConfig serializationConfig9 = serializationConfig3;
                            JsonSerializer<Object> jsonSerializer4 = jsonSerializer3;
                            TypeSerializer typeSerializer4 = typeSerializer3;
                            jsonSerializerD = ((Serializers) arrayIterator28.next()).d(serializationConfig9, collectionLikeType, beanDescription, typeSerializer3, jsonSerializer4);
                            if (jsonSerializerD != null) {
                                break;
                            }
                            serializationConfig3 = serializationConfig9;
                            typeSerializer3 = typeSerializer4;
                            jsonSerializer3 = jsonSerializer4;
                        }
                        jsonSerializerE = jsonSerializerD == null ? e(serializerProvider, javaType, beanDescription) : jsonSerializerD;
                        if (jsonSerializerE != null && this._factoryConfig.a()) {
                            ArrayIterator2 arrayIterator29 = (ArrayIterator2) this._factoryConfig.b();
                            while (arrayIterator29.hasNext()) {
                                Objects.requireNonNull((BeanSerializerModifier) arrayIterator29.next());
                            }
                        }
                    }
                } else {
                    aVar = aVar4;
                    aVar2 = aVar3;
                    cls = cls3;
                    beanDescription2 = beanDescription3;
                    boolean z12 = z11;
                    cVar = cVar4;
                    if (javaType instanceof ArrayType) {
                        ArrayType arrayType = (ArrayType) javaType;
                        SerializationConfig serializationConfig10 = serializerProvider._config;
                        ArrayIterator2 arrayIterator210 = (ArrayIterator2) j();
                        jsonSerializerE = null;
                        while (true) {
                            if (!arrayIterator210.hasNext()) {
                                z5 = z12;
                                break;
                            }
                            SerializationConfig serializationConfig11 = serializationConfig10;
                            SerializationConfig serializationConfig12 = serializationConfig10;
                            z5 = z12;
                            jsonSerializerE = ((Serializers) arrayIterator210.next()).e(serializationConfig11, arrayType, beanDescription, typeSerializerC, jsonSerializerH);
                            if (jsonSerializerE != null) {
                                break;
                            }
                            z12 = z5;
                            serializationConfig10 = serializationConfig12;
                            jsonSerializerE = jsonSerializerE;
                        }
                        if (jsonSerializerE == null) {
                            Class<?> cls6 = arrayType._class;
                            if (jsonSerializerH != null) {
                                jsonSerializerE = jsonSerializerE;
                                if (ClassUtil.s(jsonSerializerH)) {
                                    jsonSerializerE = String[].class == cls6 ? StringArraySerializer2.k : StdArraySerializers.a.get(cls6.getName());
                                }
                                if (jsonSerializerE == null) {
                                    jsonSerializerE = new ObjectArraySerializer2(arrayType._componentType, z5, typeSerializerC, jsonSerializerH);
                                }
                            }
                        }
                        if (this._factoryConfig.a()) {
                            ArrayIterator2 arrayIterator211 = (ArrayIterator2) this._factoryConfig.b();
                            while (arrayIterator211.hasNext()) {
                                Objects.requireNonNull((BeanSerializerModifier) arrayIterator211.next());
                            }
                        }
                    } else {
                        jsonSerializerE = null;
                    }
                }
            }
            if (jsonSerializerE != null) {
                return jsonSerializerE;
            }
            i = 3;
            z8 = zG;
        } else {
            aVar = aVar4;
            aVar2 = aVar3;
            cVar = cVar3;
            cls = cls3;
            beanDescription2 = beanDescription3;
            if (javaType.b()) {
                ReferenceType referenceType = (ReferenceType) javaType;
                JavaType javaType4 = referenceType._referencedType;
                TypeSerializer typeSerializerC2 = (TypeSerializer) javaType4._typeHandler;
                SerializationConfig serializationConfig13 = serializerProvider._config;
                if (typeSerializerC2 == null) {
                    typeSerializerC2 = c(serializationConfig13, javaType4);
                }
                TypeSerializer typeSerializer5 = typeSerializerC2;
                JsonSerializer<Object> jsonSerializer5 = (JsonSerializer) javaType4._valueHandler;
                ArrayIterator2 arrayIterator212 = (ArrayIterator2) j();
                while (true) {
                    if (arrayIterator212.hasNext()) {
                        JsonSerializer<Object> jsonSerializer6 = jsonSerializer5;
                        TypeSerializer typeSerializer6 = typeSerializer5;
                        SerializationConfig serializationConfig14 = serializationConfig13;
                        jsonSerializerA = ((Serializers) arrayIterator212.next()).a(serializationConfig13, referenceType, beanDescription, typeSerializer5, jsonSerializer6);
                        if (jsonSerializerA != null) {
                            break;
                        }
                        jsonSerializer5 = jsonSerializer6;
                        typeSerializer5 = typeSerializer6;
                        serializationConfig13 = serializationConfig14;
                    } else {
                        JsonSerializer<Object> jsonSerializer7 = jsonSerializer5;
                        TypeSerializer typeSerializer7 = typeSerializer5;
                        if (referenceType.B(AtomicReference.class)) {
                            JavaType javaType5 = referenceType._referencedType;
                            JsonInclude.b bVarD2 = d(serializerProvider, beanDescription2, javaType5, AtomicReference.class);
                            JsonInclude.a aVar6 = bVarD2 == null ? aVar : bVarD2._contentInclusion;
                            if (aVar6 == aVar || aVar6 == aVar2) {
                                i2 = 3;
                                objT0 = null;
                                zB = false;
                            } else {
                                int iOrdinal3 = aVar6.ordinal();
                                if (iOrdinal3 != 2) {
                                    i2 = 3;
                                    if (iOrdinal3 == 3) {
                                        objT0 = MapSerializer2.l;
                                    } else if (iOrdinal3 == 4) {
                                        objT0 = AnimatableValueParser.t0(javaType5);
                                        if (objT0 != null && objT0.getClass().isArray()) {
                                            objT0 = AnimatableValueParser.q0(objT0);
                                        }
                                    } else if (iOrdinal3 != 5) {
                                        objT0 = null;
                                    } else {
                                        objT0 = serializerProvider.A(null, bVarD2._contentFilter);
                                        if (objT0 != null) {
                                            zB = serializerProvider.B(objT0);
                                        }
                                    }
                                    zB = true;
                                } else {
                                    i2 = 3;
                                    if (javaType5.b()) {
                                        objT0 = MapSerializer2.l;
                                    }
                                    zB = true;
                                }
                            }
                            ReferenceTypeSerializer<AtomicReference<?>> referenceTypeSerializerT = new AtomicReferenceSerializer(referenceType, z8, typeSerializer7, jsonSerializer7).t(objT0, zB);
                            i = i2;
                            jsonSerializerE = referenceTypeSerializerT;
                        } else {
                            jsonSerializerA = null;
                        }
                    }
                }
                i = 3;
                jsonSerializerE = jsonSerializerA;
            } else {
                i = 3;
                ArrayIterator2 arrayIterator213 = (ArrayIterator2) j();
                JsonSerializer<?> jsonSerializerB = null;
                while (arrayIterator213.hasNext() && (jsonSerializerB = ((Serializers) arrayIterator213.next()).b(serializationConfig2, javaType, beanDescription2)) == null) {
                }
                jsonSerializerE = jsonSerializerB;
            }
            if (jsonSerializerE == null) {
                jsonSerializerE = e(serializerProvider, javaType, beanDescription);
            }
        }
        if (jsonSerializerE == null) {
            String name = javaType._class.getName();
            JsonSerializer<?> jsonSerializer8 = BasicSerializerFactory.j.get(name);
            if (jsonSerializer8 != null || (cls2 = BasicSerializerFactory.k.get(name)) == null) {
                jsonSerializerE = jsonSerializer8;
                i3 = 0;
            } else {
                i3 = 0;
                jsonSerializerE = (JsonSerializer) ClassUtil.g(cls2, false);
            }
            if (jsonSerializerE == null) {
                if (javaType.w()) {
                    SerializationConfig serializationConfig15 = serializerProvider._config;
                    JsonFormat.d dVarA = beanDescription2.a(null);
                    if (dVarA.e() == cVar) {
                        Iterator<BeanPropertyDefinition> it = ((BasicBeanDescription) beanDescription2).d().iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                break;
                            }
                            if (it.next().p().equals("declaringClass")) {
                                it.remove();
                                break;
                            }
                        }
                        enumSerializer2 = null;
                    } else {
                        Class<?> cls7 = javaType._class;
                        int i5 = EnumSerializer2.k;
                        EnumSerializer2 enumSerializer22 = new EnumSerializer2(EnumValues.a(serializationConfig15, cls7), EnumSerializer2.p(cls7, dVarA, true, null));
                        if (this._factoryConfig.a()) {
                            ArrayIterator2 arrayIterator214 = (ArrayIterator2) this._factoryConfig.b();
                            while (arrayIterator214.hasNext()) {
                                Objects.requireNonNull((BeanSerializerModifier) arrayIterator214.next());
                            }
                        }
                        enumSerializer2 = enumSerializer22;
                    }
                    c = 1;
                    jsonSerializerE = enumSerializer2;
                } else {
                    c = 1;
                    Class<?> cls8 = javaType._class;
                    ?? A = OptionalHandlerFactory.l.a(serializerProvider._config, javaType, beanDescription2);
                    if (A != 0) {
                        jsonSerializerE = A;
                    } else if (Calendar.class.isAssignableFrom(cls8)) {
                        jsonSerializerE = CalendarSerializer2.k;
                    } else if (Date.class.isAssignableFrom(cls8)) {
                        jsonSerializerE = DateSerializer2.k;
                    } else if (Map.Entry.class.isAssignableFrom(cls8)) {
                        JavaType javaTypeI = javaType.i(Map.Entry.class);
                        JavaType javaTypeH = javaTypeI.h(i3);
                        JavaType javaTypeH2 = javaTypeI.h(1);
                        JsonFormat.d dVarI = serializerProvider._config.i(Map.Entry.class);
                        JsonFormat.d dVarA2 = beanDescription2.a(null);
                        if (dVarA2 != null) {
                            dVarI = dVarA2.k(dVarI);
                        }
                        if (dVarI.e() == cVar) {
                            A = 0;
                        } else {
                            A = new MapEntrySerializer(javaTypeH2, javaTypeH, javaTypeH2, z8, c(serializerProvider._config, javaTypeH2), null);
                            JavaType javaType6 = A._valueType;
                            JsonInclude.b bVarD3 = d(serializerProvider, beanDescription2, javaType6, Map.Entry.class);
                            JsonInclude.a aVar7 = bVarD3 == null ? aVar : bVarD3._contentInclusion;
                            if (aVar7 != aVar && aVar7 != aVar2) {
                                int iOrdinal4 = aVar7.ordinal();
                                if (iOrdinal4 != 2) {
                                    if (iOrdinal4 == i) {
                                        objT02 = MapSerializer2.l;
                                    } else if (iOrdinal4 == 4) {
                                        objT02 = AnimatableValueParser.t0(javaType6);
                                        if (objT02 != null && objT02.getClass().isArray()) {
                                            objT02 = AnimatableValueParser.q0(objT02);
                                        }
                                    } else if (iOrdinal4 != 5) {
                                        objT02 = null;
                                    } else {
                                        objT02 = serializerProvider.A(null, bVarD3._contentFilter);
                                        if (objT02 != null) {
                                            zB2 = serializerProvider.B(objT02);
                                        }
                                        if (A._suppressableValue != objT02 || A._suppressNulls != zB2) {
                                            A = new MapEntrySerializer(A, A._keySerializer, A._valueSerializer, objT02, zB2);
                                        }
                                    }
                                    zB2 = true;
                                    if (A._suppressableValue != objT02) {
                                        A = new MapEntrySerializer(A, A._keySerializer, A._valueSerializer, objT02, zB2);
                                    }
                                } else {
                                    if (javaType6.b()) {
                                        objT02 = MapSerializer2.l;
                                    }
                                    zB2 = true;
                                    if (A._suppressableValue != objT02) {
                                    }
                                }
                            }
                        }
                        jsonSerializerE = A;
                    } else {
                        jsonSerializerE = ByteBuffer.class.isAssignableFrom(cls8) ? new ByteBufferSerializer() : InetAddress.class.isAssignableFrom(cls8) ? new InetAddressSerializer() : InetSocketAddress.class.isAssignableFrom(cls8) ? new InetSocketAddressSerializer() : TimeZone.class.isAssignableFrom(cls8) ? new TimeZoneSerializer2() : Charset.class.isAssignableFrom(cls8) ? ToStringSerializer.k : (!Number.class.isAssignableFrom(cls8) || (iOrdinal = beanDescription2.a(null).e().ordinal()) == i || iOrdinal == 4) ? null : iOrdinal != 8 ? NumberSerializer.k : ToStringSerializer.k;
                    }
                }
                if (jsonSerializerE == null) {
                    Class<?> cls9 = javaType._class;
                    Annotation[] annotationArr = ClassUtil.a;
                    if ((cls9.isAnnotation() ? "annotation" : cls9.isArray() ? "array" : cls.isAssignableFrom(cls9) ? "enum" : cls9.isPrimitive() ? "primitive" : null) == null) {
                        String name2 = cls9.getName();
                        boolean z13 = !(name2.startsWith("net.sf.cglib.proxy.") || name2.startsWith("org.hibernate.proxy."));
                        if (!z13 && !ClassUtil.q(javaType._class)) {
                            jsonSerializerX = null;
                        } else if (beanDescription2.a._class == Object.class) {
                            jsonSerializerX = serializerProvider.x(Object.class);
                        } else {
                            Class<?> cls10 = javaType._class;
                            if (cls10.getName().startsWith("java.time.")) {
                                str2 = "Java 8 date/time";
                                str3 = "com.fasterxml.jackson.datatype:jackson-datatype-jsr310";
                            } else if (cls10.getName().startsWith("org.joda.time.")) {
                                str2 = "Joda date/time";
                                str3 = "com.fasterxml.jackson.datatype:jackson-datatype-joda";
                            } else {
                                str = null;
                                unsupportedTypeSerializer = (str == null && serializerProvider._config.a(javaType._class) == null) ? new UnsupportedTypeSerializer(javaType, str) : null;
                                if (unsupportedTypeSerializer == null) {
                                    jsonSerializerE = unsupportedTypeSerializer;
                                } else {
                                    SerializationConfig serializationConfig16 = serializerProvider._config;
                                    BeanSerializerBuilder beanSerializerBuilder = new BeanSerializerBuilder(beanDescription2);
                                    beanSerializerBuilder.c = serializationConfig16;
                                    BasicBeanDescription basicBeanDescription3 = (BasicBeanDescription) beanDescription2;
                                    List<BeanPropertyDefinition> listD = basicBeanDescription3.d();
                                    SerializationConfig serializationConfig17 = serializerProvider._config;
                                    AnnotationIntrospector annotationIntrospectorE2 = serializationConfig17.e();
                                    HashMap map = new HashMap();
                                    Iterator<BeanPropertyDefinition> it2 = listD.iterator();
                                    while (it2.hasNext()) {
                                        BeanPropertyDefinition next = it2.next();
                                        if (next.j() == null) {
                                            it2.remove();
                                        } else {
                                            Class<?> clsR = next.r();
                                            Boolean boolC0 = (Boolean) map.get(clsR);
                                            if (boolC0 == null) {
                                                serializationConfig17.f(clsR);
                                                boolC0 = annotationIntrospectorE2.c0(((BasicBeanDescription) serializationConfig17.o(clsR)).f);
                                                if (boolC0 == null) {
                                                    boolC0 = Boolean.FALSE;
                                                }
                                                map.put(clsR, boolC0);
                                            }
                                            if (boolC0.booleanValue()) {
                                                it2.remove();
                                            }
                                        }
                                    }
                                    if (serializationConfig17.q(MapperFeature.REQUIRE_SETTERS_FOR_GETTERS)) {
                                        Iterator<BeanPropertyDefinition> it3 = listD.iterator();
                                        while (it3.hasNext()) {
                                            BeanPropertyDefinition next2 = it3.next();
                                            if (!next2.f() && !next2.u()) {
                                                it3.remove();
                                            }
                                        }
                                    }
                                    if (listD.isEmpty()) {
                                        arrayList = null;
                                        z3 = z8;
                                    } else {
                                        boolean zG2 = g(serializationConfig17, beanDescription2, null);
                                        PropertyBuilder propertyBuilder = new PropertyBuilder(serializationConfig17, beanDescription2);
                                        ArrayList arrayList3 = new ArrayList(listD.size());
                                        for (BeanPropertyDefinition beanPropertyDefinition : listD) {
                                            AnnotatedMember annotatedMemberJ = beanPropertyDefinition.j();
                                            if (!beanPropertyDefinition.v()) {
                                                AnnotationIntrospector.a aVarH = beanPropertyDefinition.h();
                                                if (aVarH == null) {
                                                    if (annotatedMemberJ instanceof AnnotatedMethod) {
                                                        z4 = z8;
                                                        arrayList2 = arrayList3;
                                                        arrayList2.add(h(serializerProvider, beanPropertyDefinition, propertyBuilder, zG2, (AnnotatedMethod) annotatedMemberJ));
                                                    } else {
                                                        z4 = z8;
                                                        arrayList2 = arrayList3;
                                                        arrayList2.add(h(serializerProvider, beanPropertyDefinition, propertyBuilder, zG2, (AnnotatedField) annotatedMemberJ));
                                                    }
                                                    arrayList3 = arrayList2;
                                                    z8 = z4;
                                                } else {
                                                    if (aVarH.a == 2) {
                                                        z4 = z8;
                                                        arrayList2 = arrayList3;
                                                    }
                                                    arrayList3 = arrayList2;
                                                    z8 = z4;
                                                }
                                            } else if (annotatedMemberJ == null) {
                                                continue;
                                            } else {
                                                if (beanSerializerBuilder.h != null) {
                                                    StringBuilder sbU = outline.U("Multiple type ids specified with ");
                                                    sbU.append(beanSerializerBuilder.h);
                                                    sbU.append(" and ");
                                                    sbU.append(annotatedMemberJ);
                                                    throw new IllegalArgumentException(sbU.toString());
                                                }
                                                beanSerializerBuilder.h = annotatedMemberJ;
                                            }
                                        }
                                        z3 = z8;
                                        arrayList = arrayList3;
                                    }
                                    if (arrayList == null) {
                                        arrayList = new ArrayList();
                                    } else {
                                        int size2 = arrayList.size();
                                        for (int i6 = 0; i6 < size2; i6++) {
                                            BeanPropertyWriter beanPropertyWriter = (BeanPropertyWriter) arrayList.get(i6);
                                            TypeSerializer typeSerializer8 = beanPropertyWriter._typeSerializer;
                                            if (typeSerializer8 != null && typeSerializer8.c() == JsonTypeInfo.a.EXTERNAL_PROPERTY) {
                                                PropertyName propertyNameA = PropertyName.a(typeSerializer8.b());
                                                Iterator it4 = arrayList.iterator();
                                                while (true) {
                                                    if (!it4.hasNext()) {
                                                        break;
                                                    }
                                                    BeanPropertyWriter beanPropertyWriter2 = (BeanPropertyWriter) it4.next();
                                                    if (beanPropertyWriter2 != beanPropertyWriter) {
                                                        PropertyName propertyName = beanPropertyWriter2._wrapperName;
                                                        if (propertyName != null) {
                                                            zEquals = propertyName.equals(propertyNameA);
                                                        } else {
                                                            if (propertyNameA._simpleName.equals(beanPropertyWriter2._name._value)) {
                                                                if (!(propertyNameA._namespace != null)) {
                                                                    zEquals = true;
                                                                }
                                                            }
                                                            zEquals = false;
                                                        }
                                                        if (zEquals) {
                                                            beanPropertyWriter._typeSerializer = null;
                                                            break;
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                    serializerProvider.v().a(serializationConfig16, basicBeanDescription3.f, arrayList);
                                    if (this._factoryConfig.a()) {
                                        ArrayIterator2 arrayIterator215 = (ArrayIterator2) this._factoryConfig.b();
                                        while (arrayIterator215.hasNext()) {
                                            Objects.requireNonNull((BeanSerializerModifier) arrayIterator215.next());
                                        }
                                    }
                                    JsonIgnoreProperties.a aVarS2 = serializationConfig16.s(beanDescription2.a._class, basicBeanDescription3.f);
                                    Set<String> setD2 = aVarS2 != null ? aVarS2.d() : null;
                                    Class<?> cls11 = beanDescription2.a._class;
                                    AnnotatedClass annotatedClass4 = basicBeanDescription3.f;
                                    AnnotationIntrospector annotationIntrospectorE3 = serializationConfig16.e();
                                    JsonIncludeProperties.a aVarA2 = annotationIntrospectorE3 == null ? null : annotationIntrospectorE3.A(serializationConfig16, annotatedClass4);
                                    Set<String> set = aVarA2 != null ? aVarA2._included : null;
                                    if (set != null || (setD2 != null && !setD2.isEmpty())) {
                                        Iterator it5 = arrayList.iterator();
                                        while (it5.hasNext()) {
                                            if (AnimatableValueParser.b2(((BeanPropertyWriter) it5.next())._name._value, setD2, set)) {
                                                it5.remove();
                                            }
                                        }
                                    }
                                    if (this._factoryConfig.a()) {
                                        ArrayIterator2 arrayIterator216 = (ArrayIterator2) this._factoryConfig.b();
                                        while (arrayIterator216.hasNext()) {
                                            Objects.requireNonNull((BeanSerializerModifier) arrayIterator216.next());
                                        }
                                    }
                                    ObjectIdInfo objectIdInfo = basicBeanDescription3.j;
                                    if (objectIdInfo == null) {
                                        objectIdWriterA = null;
                                    } else {
                                        Class<? extends ObjectIdGenerator<?>> cls12 = objectIdInfo.c;
                                        if (cls12 == ObjectIdGenerators3.class) {
                                            String str4 = objectIdInfo.f681b._simpleName;
                                            int size3 = arrayList.size();
                                            for (int i7 = 0; i7 != size3; i7++) {
                                                BeanPropertyWriter beanPropertyWriter3 = (BeanPropertyWriter) arrayList.get(i7);
                                                if (str4.equals(beanPropertyWriter3._name._value)) {
                                                    if (i7 > 0) {
                                                        arrayList.remove(i7);
                                                        arrayList.add(0, beanPropertyWriter3);
                                                    }
                                                    objectIdWriterA = ObjectIdWriter.a(beanPropertyWriter3._declaredType, null, new PropertyBasedObjectIdGenerator(objectIdInfo, beanPropertyWriter3), objectIdInfo.f);
                                                }
                                            }
                                            Object[] objArr = new Object[2];
                                            objArr[0] = ClassUtil.n(beanDescription2.a);
                                            objArr[1] = str4 == null ? "[null]" : ClassUtil.c(str4);
                                            throw new IllegalArgumentException(String.format("Invalid Object Id definition for %s: cannot find property with name %s", objArr));
                                        }
                                        objectIdWriterA = ObjectIdWriter.a(serializerProvider.d().i(serializerProvider.b(cls12), ObjectIdGenerator.class)[0], objectIdInfo.f681b, serializerProvider.e(basicBeanDescription3.f, objectIdInfo), objectIdInfo.f);
                                    }
                                    beanSerializerBuilder.i = objectIdWriterA;
                                    beanSerializerBuilder.d = arrayList;
                                    beanSerializerBuilder.g = serializationConfig16.e().g(basicBeanDescription3.f);
                                    POJOPropertiesCollector pOJOPropertiesCollector = basicBeanDescription3.c;
                                    if (pOJOPropertiesCollector == null) {
                                        first = null;
                                        if (first != null) {
                                            JavaType javaTypeE = first.e();
                                            JavaType javaTypeK = javaTypeE.k();
                                            TypeSerializer typeSerializerC3 = c(serializationConfig16, javaTypeK);
                                            JsonSerializer jsonSerializerF2 = f(serializerProvider, first);
                                            if (jsonSerializerF2 == null) {
                                                jsonSerializerF2 = MapSerializer2.s(null, null, javaTypeE, serializationConfig16.q(MapperFeature.USE_STATIC_TYPING), typeSerializerC3, null, null, null);
                                            }
                                            beanSerializerBuilder.f = new AnyGetterWriter(new BeanProperty.a(PropertyName.a(first.c()), javaTypeK, null, first, PropertyMetadata.k), first, jsonSerializerF2);
                                        }
                                        List<BeanPropertyWriter> list2 = beanSerializerBuilder.d;
                                        zQ = serializationConfig16.q(MapperFeature.DEFAULT_VIEW_INCLUSION);
                                        size = list2.size();
                                        BeanPropertyWriter[] beanPropertyWriterArr = new BeanPropertyWriter[size];
                                        i4 = 0;
                                        int i8 = 0;
                                        while (i4 < size) {
                                            BeanPropertyWriter beanPropertyWriter4 = list2.get(i4);
                                            Class<?>[] clsArr = beanPropertyWriter4._includeInViews;
                                            if (clsArr == null || clsArr.length == 0) {
                                                list = list2;
                                                if (zQ) {
                                                    beanPropertyWriterArr[i4] = beanPropertyWriter4;
                                                }
                                            } else {
                                                i8++;
                                                list = list2;
                                                beanPropertyWriterArr[i4] = clsArr.length == 1 ? new FilteredBeanPropertyWriter2(beanPropertyWriter4, clsArr[0]) : new FilteredBeanPropertyWriter(beanPropertyWriter4, clsArr);
                                            }
                                            i4++;
                                            list2 = list;
                                        }
                                        if (zQ || i8 != 0) {
                                            if (size == beanSerializerBuilder.d.size()) {
                                                throw new IllegalArgumentException(String.format("Trying to set %d filtered properties; must match length of non-filtered `properties` (%d)", Integer.valueOf(size), Integer.valueOf(beanSerializerBuilder.d.size())));
                                            }
                                            beanSerializerBuilder.e = beanPropertyWriterArr;
                                        }
                                        if (this._factoryConfig.a()) {
                                            ArrayIterator2 arrayIterator217 = (ArrayIterator2) this._factoryConfig.b();
                                            while (arrayIterator217.hasNext()) {
                                                Objects.requireNonNull((BeanSerializerModifier) arrayIterator217.next());
                                            }
                                        }
                                        try {
                                            jsonSerializerE = beanSerializerBuilder.a();
                                            if (jsonSerializerE == null) {
                                                if (javaType.A()) {
                                                    jsonSerializerE = new BeanSerializer2(beanSerializerBuilder.f701b.a, beanSerializerBuilder, BeanSerializerBase.k, null);
                                                } else {
                                                    Class<?> cls13 = javaType._class;
                                                    if (Iterator.class.isAssignableFrom(cls13)) {
                                                        JavaType[] javaTypeArrI = serializationConfig16._base._typeFactory.i(javaType, Iterator.class);
                                                        JavaType javaTypeK2 = (javaTypeArrI == null || javaTypeArrI.length != 1) ? TypeFactory.k() : javaTypeArrI[0];
                                                        jsonSerializerE = new IteratorSerializer(javaTypeK2, z3, c(serializationConfig16, javaTypeK2));
                                                    } else {
                                                        boolean z14 = z3;
                                                        if (Iterable.class.isAssignableFrom(cls13)) {
                                                            JavaType[] javaTypeArrI2 = serializationConfig16._base._typeFactory.i(javaType, Iterable.class);
                                                            JavaType javaTypeK3 = (javaTypeArrI2 == null || javaTypeArrI2.length != 1) ? TypeFactory.k() : javaTypeArrI2[0];
                                                            jsonSerializerE = new IterableSerializer(javaTypeK3, z14, c(serializationConfig16, javaTypeK3));
                                                        } else {
                                                            jsonSerializerE = CharSequence.class.isAssignableFrom(cls13) ? ToStringSerializer.k : null;
                                                        }
                                                    }
                                                    if (jsonSerializerE == null) {
                                                        if (basicBeanDescription3.f.t.size() > 0) {
                                                            jsonSerializerE = new BeanSerializer2(beanSerializerBuilder.f701b.a, beanSerializerBuilder, BeanSerializerBase.k, null);
                                                        }
                                                    }
                                                }
                                            }
                                        } catch (RuntimeException e) {
                                            serializerProvider.F(beanDescription2, "Failed to construct BeanSerializer for %s: (%s) %s", beanDescription2.a, e.getClass().getName(), e.getMessage());
                                            throw null;
                                        }
                                    } else {
                                        if (!pOJOPropertiesCollector.i) {
                                            pOJOPropertiesCollector.h();
                                        }
                                        LinkedList<AnnotatedMember> linkedList = pOJOPropertiesCollector.m;
                                        if (linkedList == null) {
                                            first = null;
                                        } else {
                                            if (linkedList.size() > 1) {
                                                pOJOPropertiesCollector.i("Multiple 'any-getter' methods defined (%s vs %s)", pOJOPropertiesCollector.m.get(0), pOJOPropertiesCollector.m.get(1));
                                                throw null;
                                            }
                                            first = pOJOPropertiesCollector.m.getFirst();
                                        }
                                        if (first == null) {
                                            POJOPropertiesCollector pOJOPropertiesCollector2 = basicBeanDescription3.c;
                                            if (!pOJOPropertiesCollector2.i) {
                                                pOJOPropertiesCollector2.h();
                                            }
                                            LinkedList<AnnotatedMember> linkedList2 = pOJOPropertiesCollector2.n;
                                            if (linkedList2 == null) {
                                                first = null;
                                            } else {
                                                if (linkedList2.size() > 1) {
                                                    pOJOPropertiesCollector2.i("Multiple 'any-getter' fields defined (%s vs %s)", pOJOPropertiesCollector2.n.get(0), pOJOPropertiesCollector2.n.get(1));
                                                    throw null;
                                                }
                                                first = pOJOPropertiesCollector2.n.getFirst();
                                            }
                                            if (first != null) {
                                                if (!Map.class.isAssignableFrom(first.d())) {
                                                    throw new IllegalArgumentException(String.format("Invalid 'any-getter' annotation on field '%s': type is not instance of java.util.Map", first.c()));
                                                }
                                            }
                                        } else if (!Map.class.isAssignableFrom(first.d())) {
                                            throw new IllegalArgumentException(String.format("Invalid 'any-getter' annotation on method %s(): return type is not instance of java.util.Map", first.c()));
                                        }
                                        if (first != null) {
                                        }
                                        List<BeanPropertyWriter> list22 = beanSerializerBuilder.d;
                                        zQ = serializationConfig16.q(MapperFeature.DEFAULT_VIEW_INCLUSION);
                                        size = list22.size();
                                        BeanPropertyWriter[] beanPropertyWriterArr2 = new BeanPropertyWriter[size];
                                        i4 = 0;
                                        int i82 = 0;
                                        while (i4 < size) {
                                        }
                                        if (zQ) {
                                            if (size == beanSerializerBuilder.d.size()) {
                                            }
                                        }
                                    }
                                }
                                if (jsonSerializerE == null) {
                                    jsonSerializerE = serializerProvider.x(beanDescription2.a._class);
                                }
                            }
                            Object[] objArr2 = new Object[i];
                            objArr2[i3] = str2;
                            objArr2[c] = ClassUtil.n(javaType);
                            objArr2[2] = str3;
                            str = String.format("%s type %s not supported by default: add Module \"%s\" to enable handling", objArr2);
                            if (str == null) {
                                if (unsupportedTypeSerializer == null) {
                                }
                                if (jsonSerializerE == null) {
                                }
                            }
                        }
                        jsonSerializerE = jsonSerializerX;
                        if (jsonSerializerE == null) {
                        }
                    }
                }
            }
        }
        if (jsonSerializerE != null && this._factoryConfig.a()) {
            ArrayIterator2 arrayIterator218 = (ArrayIterator2) this._factoryConfig.b();
            while (arrayIterator218.hasNext()) {
                Objects.requireNonNull((BeanSerializerModifier) arrayIterator218.next());
            }
        }
        return jsonSerializerE;
    }

    public Iterable<Serializers> j() {
        return new ArrayIterator2(this._factoryConfig._additionalSerializers);
    }
}
