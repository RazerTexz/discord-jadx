package d0.e0.p.d.m0.e.a.i0.l;

import d0.e0.p.d.m0.b.KotlinBuiltIns;
import d0.e0.p.d.m0.b.StandardNames;
import d0.e0.p.d.m0.b.q.mappingUtil;
import d0.e0.p.d.m0.c.ClassConstructorDescriptor;
import d0.e0.p.d.m0.c.ClassDescriptor;
import d0.e0.p.d.m0.c.ClassKind;
import d0.e0.p.d.m0.c.ClassifierDescriptor;
import d0.e0.p.d.m0.c.DeclarationDescriptor;
import d0.e0.p.d.m0.c.DescriptorVisibilities;
import d0.e0.p.d.m0.c.DescriptorVisibility2;
import d0.e0.p.d.m0.c.Modality;
import d0.e0.p.d.m0.c.NotFoundClasses;
import d0.e0.p.d.m0.c.ScopesHolderForClass;
import d0.e0.p.d.m0.c.SupertypeLoopChecker;
import d0.e0.p.d.m0.c.TypeParameterDescriptor;
import d0.e0.p.d.m0.c.Visibility2;
import d0.e0.p.d.m0.c.g1.AnnotationDescriptor;
import d0.e0.p.d.m0.c.g1.Annotations4;
import d0.e0.p.d.m0.c.i1.ClassDescriptorBase;
import d0.e0.p.d.m0.c.typeParameterUtils;
import d0.e0.p.d.m0.d.b.LookupLocation3;
import d0.e0.p.d.m0.e.a.FakePureImplementationsProvider;
import d0.e0.p.d.m0.e.a.JavaDescriptorVisibilities;
import d0.e0.p.d.m0.e.a.JvmAnnotationNames;
import d0.e0.p.d.m0.e.a.g0.JavaResolverCache;
import d0.e0.p.d.m0.e.a.g0.TypeUsage;
import d0.e0.p.d.m0.e.a.h0.JavaClassDescriptor;
import d0.e0.p.d.m0.e.a.i0.LazyJavaAnnotations2;
import d0.e0.p.d.m0.e.a.i0.context;
import d0.e0.p.d.m0.e.a.i0.context4;
import d0.e0.p.d.m0.e.a.i0.m.JavaTypeResolver;
import d0.e0.p.d.m0.e.a.i0.m.JavaTypeResolver5;
import d0.e0.p.d.m0.e.a.k0.javaTypes3;
import d0.e0.p.d.m0.e.a.k0.javaTypes5;
import d0.e0.p.d.m0.e.a.k0.y;
import d0.e0.p.d.m0.e.a.utils2;
import d0.e0.p.d.m0.g.FqName;
import d0.e0.p.d.m0.g.FqNamesUtil;
import d0.e0.p.d.m0.k.a0.InnerClassesScopeWrapper;
import d0.e0.p.d.m0.k.a0.MemberScope3;
import d0.e0.p.d.m0.k.v.w;
import d0.e0.p.d.m0.k.x.DescriptorUtils2;
import d0.e0.p.d.m0.l.b.ErrorReporter;
import d0.e0.p.d.m0.m.storage5;
import d0.e0.p.d.m0.n.AbstractClassTypeConstructor;
import d0.e0.p.d.m0.n.KotlinType;
import d0.e0.p.d.m0.n.KotlinType4;
import d0.e0.p.d.m0.n.KotlinTypeFactory;
import d0.e0.p.d.m0.n.TypeConstructor;
import d0.e0.p.d.m0.n.TypeProjectionImpl;
import d0.e0.p.d.m0.n.Variance;
import d0.e0.p.d.m0.n.l1.KotlinTypeRefiner;
import d0.e0.p.d.m0.p.collections;
import d0.t.Collections2;
import d0.t.CollectionsJVM;
import d0.t.Iterables2;
import d0.t.Iterators4;
import d0.t.Sets5;
import d0.t._Collections;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.ranges.Ranges2;

/* compiled from: LazyJavaClassDescriptor.kt */
/* renamed from: d0.e0.p.d.m0.e.a.i0.l.f, reason: use source file name */
/* loaded from: classes3.dex */
public final class LazyJavaClassDescriptor extends ClassDescriptorBase implements JavaClassDescriptor {
    public final LazyJavaClassMemberScope2 A;
    public final ScopesHolderForClass<LazyJavaClassMemberScope2> B;
    public final InnerClassesScopeWrapper C;
    public final LazyJavaStaticClassScope2 D;
    public final Annotations4 E;
    public final storage5<List<TypeParameterDescriptor>> F;
    public final context4 r;

    /* renamed from: s, reason: collision with root package name */
    public final d0.e0.p.d.m0.e.a.k0.g f3328s;
    public final ClassDescriptor t;
    public final context4 u;
    public final ClassKind v;
    public final Modality w;

    /* renamed from: x, reason: collision with root package name */
    public final Visibility2 f3329x;

    /* renamed from: y, reason: collision with root package name */
    public final boolean f3330y;

    /* renamed from: z, reason: collision with root package name */
    public final b f3331z;

    /* compiled from: LazyJavaClassDescriptor.kt */
    /* renamed from: d0.e0.p.d.m0.e.a.i0.l.f$a */
    public static final class a {
        public a(DefaultConstructorMarker defaultConstructorMarker) {
        }
    }

    /* compiled from: LazyJavaClassDescriptor.kt */
    /* renamed from: d0.e0.p.d.m0.e.a.i0.l.f$b */
    public final class b extends AbstractClassTypeConstructor {
        public final storage5<List<TypeParameterDescriptor>> c;
        public final /* synthetic */ LazyJavaClassDescriptor d;

        /* compiled from: LazyJavaClassDescriptor.kt */
        /* renamed from: d0.e0.p.d.m0.e.a.i0.l.f$b$a */
        public static final class a extends Lambda implements Function0<List<? extends TypeParameterDescriptor>> {
            public final /* synthetic */ LazyJavaClassDescriptor this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(LazyJavaClassDescriptor lazyJavaClassDescriptor) {
                super(0);
                this.this$0 = lazyJavaClassDescriptor;
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ List<? extends TypeParameterDescriptor> invoke() {
                return invoke2();
            }

            @Override // kotlin.jvm.functions.Function0
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final List<? extends TypeParameterDescriptor> invoke2() {
                return typeParameterUtils.computeConstructorTypeParameters(this.this$0);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(LazyJavaClassDescriptor lazyJavaClassDescriptor) {
            super(LazyJavaClassDescriptor.access$getC$p(lazyJavaClassDescriptor).getStorageManager());
            Intrinsics3.checkNotNullParameter(lazyJavaClassDescriptor, "this$0");
            this.d = lazyJavaClassDescriptor;
            this.c = LazyJavaClassDescriptor.access$getC$p(lazyJavaClassDescriptor).getStorageManager().createLazyValue(new a(lazyJavaClassDescriptor));
        }

        /* JADX WARN: Removed duplicated region for block: B:16:0x0057  */
        /* JADX WARN: Removed duplicated region for block: B:29:0x0076  */
        /* JADX WARN: Removed duplicated region for block: B:34:0x0089  */
        /* JADX WARN: Removed duplicated region for block: B:57:0x0135  */
        /* JADX WARN: Removed duplicated region for block: B:76:0x01b1  */
        /* JADX WARN: Removed duplicated region for block: B:79:0x01d0  */
        /* JADX WARN: Removed duplicated region for block: B:86:0x020f  */
        /* JADX WARN: Removed duplicated region for block: B:87:0x0214  */
        @Override // d0.e0.p.d.m0.n.AbstractTypeConstructor
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public Collection<KotlinType> a() {
            FqName fqName;
            FqName purelyImplementedInterface;
            ArrayList arrayList;
            KotlinType4 kotlinType4SimpleNotNullType;
            Variance variance = Variance.INVARIANT;
            Collection<javaTypes3> supertypes = this.d.getJClass().getSupertypes();
            ArrayList arrayList2 = new ArrayList(supertypes.size());
            ArrayList arrayList3 = new ArrayList(0);
            Annotations4 annotations = this.d.getAnnotations();
            FqName fqName2 = JvmAnnotationNames.n;
            Intrinsics3.checkNotNullExpressionValue(fqName2, "PURELY_IMPLEMENTS_ANNOTATION");
            AnnotationDescriptor annotationDescriptorFindAnnotation = annotations.findAnnotation(fqName2);
            if (annotationDescriptorFindAnnotation == null) {
                fqName = null;
            } else {
                Object objSingleOrNull = _Collections.singleOrNull(annotationDescriptorFindAnnotation.getAllValueArguments().values());
                w wVar = objSingleOrNull instanceof w ? (w) objSingleOrNull : null;
                String value = wVar == null ? null : wVar.getValue();
                if (value != null && FqNamesUtil.isValidJavaFqName(value)) {
                    fqName = new FqName(value);
                }
            }
            if (fqName != null) {
                if (!(!fqName.isRoot() && fqName.startsWith(StandardNames.k))) {
                    fqName = null;
                }
            }
            if (fqName == null) {
                purelyImplementedInterface = FakePureImplementationsProvider.a.getPurelyImplementedInterface(DescriptorUtils2.getFqNameSafe(this.d));
                if (purelyImplementedInterface == null) {
                    kotlinType4SimpleNotNullType = null;
                }
                for (javaTypes3 javatypes3 : supertypes) {
                    KotlinType kotlinTypeTransformJavaType = LazyJavaClassDescriptor.access$getC$p(this.d).getTypeResolver().transformJavaType(javatypes3, JavaTypeResolver5.toAttributes$default(TypeUsage.SUPERTYPE, false, null, 3, null));
                    if (LazyJavaClassDescriptor.access$getC$p(this.d).getComponents().getSettings().getTypeEnhancementImprovements()) {
                        kotlinTypeTransformJavaType = LazyJavaClassDescriptor.access$getC$p(this.d).getComponents().getSignatureEnhancement().enhanceSuperType(kotlinTypeTransformJavaType, LazyJavaClassDescriptor.access$getC$p(this.d));
                    }
                    if (kotlinTypeTransformJavaType.getConstructor().getDeclarationDescriptor() instanceof NotFoundClasses.b) {
                        arrayList3.add(javatypes3);
                    }
                    if (!Intrinsics3.areEqual(kotlinTypeTransformJavaType.getConstructor(), kotlinType4SimpleNotNullType == null ? null : kotlinType4SimpleNotNullType.getConstructor()) && !KotlinBuiltIns.isAnyOrNullableAny(kotlinTypeTransformJavaType)) {
                        arrayList2.add(kotlinTypeTransformJavaType);
                    }
                }
                ClassDescriptor classDescriptorAccess$getAdditionalSupertypeClassDescriptor$p = LazyJavaClassDescriptor.access$getAdditionalSupertypeClassDescriptor$p(this.d);
                collections.addIfNotNull(arrayList2, classDescriptorAccess$getAdditionalSupertypeClassDescriptor$p != null ? mappingUtil.createMappedTypeParametersSubstitution(classDescriptorAccess$getAdditionalSupertypeClassDescriptor$p, this.d).buildSubstitutor().substitute(classDescriptorAccess$getAdditionalSupertypeClassDescriptor$p.getDefaultType(), variance) : null);
                collections.addIfNotNull(arrayList2, kotlinType4SimpleNotNullType);
                if (!arrayList3.isEmpty()) {
                    ErrorReporter errorReporter = LazyJavaClassDescriptor.access$getC$p(this.d).getComponents().getErrorReporter();
                    ClassDescriptor declarationDescriptor = getDeclarationDescriptor();
                    ArrayList arrayList4 = new ArrayList(Iterables2.collectionSizeOrDefault(arrayList3, 10));
                    Iterator it = arrayList3.iterator();
                    while (it.hasNext()) {
                        arrayList4.add(((javaTypes3) ((javaTypes5) it.next())).getPresentableText());
                    }
                    errorReporter.reportIncompleteHierarchy(declarationDescriptor, arrayList4);
                }
                return !(arrayList2.isEmpty() ^ true) ? _Collections.toList(arrayList2) : CollectionsJVM.listOf(LazyJavaClassDescriptor.access$getC$p(this.d).getModule().getBuiltIns().getAnyType());
            }
            purelyImplementedInterface = fqName;
            ClassDescriptor classDescriptorResolveTopLevelClass = DescriptorUtils2.resolveTopLevelClass(LazyJavaClassDescriptor.access$getC$p(this.d).getModule(), purelyImplementedInterface, LookupLocation3.FROM_JAVA_LOADER);
            if (classDescriptorResolveTopLevelClass != null) {
                int size = classDescriptorResolveTopLevelClass.getTypeConstructor().getParameters().size();
                List<TypeParameterDescriptor> parameters = this.d.getTypeConstructor().getParameters();
                Intrinsics3.checkNotNullExpressionValue(parameters, "getTypeConstructor().parameters");
                int size2 = parameters.size();
                if (size2 == size) {
                    arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(parameters, 10));
                    Iterator<T> it2 = parameters.iterator();
                    while (it2.hasNext()) {
                        arrayList.add(new TypeProjectionImpl(variance, ((TypeParameterDescriptor) it2.next()).getDefaultType()));
                    }
                } else {
                    if (size2 == 1 && size > 1 && fqName == null) {
                        TypeProjectionImpl typeProjectionImpl = new TypeProjectionImpl(variance, ((TypeParameterDescriptor) _Collections.single((List) parameters)).getDefaultType());
                        Ranges2 ranges2 = new Ranges2(1, size);
                        ArrayList arrayList5 = new ArrayList(Iterables2.collectionSizeOrDefault(ranges2, 10));
                        Iterator<Integer> it3 = ranges2.iterator();
                        while (it3.hasNext()) {
                            ((Iterators4) it3).nextInt();
                            arrayList5.add(typeProjectionImpl);
                        }
                        arrayList = arrayList5;
                    }
                    kotlinType4SimpleNotNullType = null;
                }
                KotlinTypeFactory kotlinTypeFactory = KotlinTypeFactory.a;
                kotlinType4SimpleNotNullType = KotlinTypeFactory.simpleNotNullType(Annotations4.f.getEMPTY(), classDescriptorResolveTopLevelClass, arrayList);
            }
            while (r1.hasNext()) {
            }
            ClassDescriptor classDescriptorAccess$getAdditionalSupertypeClassDescriptor$p2 = LazyJavaClassDescriptor.access$getAdditionalSupertypeClassDescriptor$p(this.d);
            collections.addIfNotNull(arrayList2, classDescriptorAccess$getAdditionalSupertypeClassDescriptor$p2 != null ? mappingUtil.createMappedTypeParametersSubstitution(classDescriptorAccess$getAdditionalSupertypeClassDescriptor$p2, this.d).buildSubstitutor().substitute(classDescriptorAccess$getAdditionalSupertypeClassDescriptor$p2.getDefaultType(), variance) : null);
            collections.addIfNotNull(arrayList2, kotlinType4SimpleNotNullType);
            if (!arrayList3.isEmpty()) {
            }
            if (!(arrayList2.isEmpty() ^ true)) {
            }
        }

        @Override // d0.e0.p.d.m0.n.AbstractTypeConstructor
        public SupertypeLoopChecker d() {
            return LazyJavaClassDescriptor.access$getC$p(this.d).getComponents().getSupertypeLoopChecker();
        }

        @Override // d0.e0.p.d.m0.n.AbstractTypeConstructor, d0.e0.p.d.m0.n.TypeConstructor
        public /* bridge */ /* synthetic */ ClassifierDescriptor getDeclarationDescriptor() {
            return getDeclarationDescriptor();
        }

        @Override // d0.e0.p.d.m0.n.TypeConstructor
        public List<TypeParameterDescriptor> getParameters() {
            return this.c.invoke();
        }

        @Override // d0.e0.p.d.m0.n.TypeConstructor
        public boolean isDenotable() {
            return true;
        }

        public String toString() {
            String strAsString = this.d.getName().asString();
            Intrinsics3.checkNotNullExpressionValue(strAsString, "name.asString()");
            return strAsString;
        }

        @Override // d0.e0.p.d.m0.n.AbstractClassTypeConstructor, d0.e0.p.d.m0.n.AbstractTypeConstructor, d0.e0.p.d.m0.n.TypeConstructor
        public ClassDescriptor getDeclarationDescriptor() {
            return this.d;
        }
    }

    /* compiled from: LazyJavaClassDescriptor.kt */
    /* renamed from: d0.e0.p.d.m0.e.a.i0.l.f$c */
    public static final class c extends Lambda implements Function0<List<? extends TypeParameterDescriptor>> {
        public c() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ List<? extends TypeParameterDescriptor> invoke() {
            return invoke2();
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final List<? extends TypeParameterDescriptor> invoke2() {
            List<y> typeParameters = LazyJavaClassDescriptor.this.getJClass().getTypeParameters();
            LazyJavaClassDescriptor lazyJavaClassDescriptor = LazyJavaClassDescriptor.this;
            ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(typeParameters, 10));
            for (y yVar : typeParameters) {
                TypeParameterDescriptor typeParameterDescriptorResolveTypeParameter = LazyJavaClassDescriptor.access$getC$p(lazyJavaClassDescriptor).getTypeParameterResolver().resolveTypeParameter(yVar);
                if (typeParameterDescriptorResolveTypeParameter == null) {
                    throw new AssertionError("Parameter " + yVar + " surely belongs to class " + lazyJavaClassDescriptor.getJClass() + ", so it must be resolved");
                }
                arrayList.add(typeParameterDescriptorResolveTypeParameter);
            }
            return arrayList;
        }
    }

    /* compiled from: LazyJavaClassDescriptor.kt */
    /* renamed from: d0.e0.p.d.m0.e.a.i0.l.f$d */
    public static final class d extends Lambda implements Function1<KotlinTypeRefiner, LazyJavaClassMemberScope2> {
        public d() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ LazyJavaClassMemberScope2 invoke(KotlinTypeRefiner kotlinTypeRefiner) {
            return invoke2(kotlinTypeRefiner);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final LazyJavaClassMemberScope2 invoke2(KotlinTypeRefiner kotlinTypeRefiner) {
            Intrinsics3.checkNotNullParameter(kotlinTypeRefiner, "it");
            context4 context4VarAccess$getC$p = LazyJavaClassDescriptor.access$getC$p(LazyJavaClassDescriptor.this);
            LazyJavaClassDescriptor lazyJavaClassDescriptor = LazyJavaClassDescriptor.this;
            return new LazyJavaClassMemberScope2(context4VarAccess$getC$p, lazyJavaClassDescriptor, lazyJavaClassDescriptor.getJClass(), LazyJavaClassDescriptor.access$getAdditionalSupertypeClassDescriptor$p(LazyJavaClassDescriptor.this) != null, LazyJavaClassDescriptor.access$getUnsubstitutedMemberScope$p(LazyJavaClassDescriptor.this));
        }
    }

    static {
        new a(null);
        Sets5.setOf((Object[]) new String[]{"equals", "hashCode", "getClass", "wait", "notify", "notifyAll", "toString"});
    }

    public /* synthetic */ LazyJavaClassDescriptor(context4 context4Var, DeclarationDescriptor declarationDescriptor, d0.e0.p.d.m0.e.a.k0.g gVar, ClassDescriptor classDescriptor, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context4Var, declarationDescriptor, gVar, (i & 8) != 0 ? null : classDescriptor);
    }

    public static final /* synthetic */ ClassDescriptor access$getAdditionalSupertypeClassDescriptor$p(LazyJavaClassDescriptor lazyJavaClassDescriptor) {
        return lazyJavaClassDescriptor.t;
    }

    public static final /* synthetic */ context4 access$getC$p(LazyJavaClassDescriptor lazyJavaClassDescriptor) {
        return lazyJavaClassDescriptor.u;
    }

    public static final /* synthetic */ LazyJavaClassMemberScope2 access$getUnsubstitutedMemberScope$p(LazyJavaClassDescriptor lazyJavaClassDescriptor) {
        return lazyJavaClassDescriptor.A;
    }

    public final LazyJavaClassDescriptor copy$descriptors_jvm(JavaResolverCache javaResolverCache, ClassDescriptor classDescriptor) {
        Intrinsics3.checkNotNullParameter(javaResolverCache, "javaResolverCache");
        context4 context4Var = this.u;
        context4 context4VarReplaceComponents = context.replaceComponents(context4Var, context4Var.getComponents().replace(javaResolverCache));
        DeclarationDescriptor containingDeclaration = getContainingDeclaration();
        Intrinsics3.checkNotNullExpressionValue(containingDeclaration, "containingDeclaration");
        return new LazyJavaClassDescriptor(context4VarReplaceComponents, containingDeclaration, this.f3328s, classDescriptor);
    }

    @Override // d0.e0.p.d.m0.c.g1.Annotations3
    public Annotations4 getAnnotations() {
        return this.E;
    }

    @Override // d0.e0.p.d.m0.c.ClassDescriptor
    public ClassDescriptor getCompanionObjectDescriptor() {
        return null;
    }

    @Override // d0.e0.p.d.m0.c.ClassDescriptor
    public /* bridge */ /* synthetic */ Collection getConstructors() {
        return getConstructors();
    }

    @Override // d0.e0.p.d.m0.c.ClassDescriptor, d0.e0.p.d.m0.c.ClassifierDescriptorWithTypeParameters
    public List<TypeParameterDescriptor> getDeclaredTypeParameters() {
        return this.F.invoke();
    }

    public final d0.e0.p.d.m0.e.a.k0.g getJClass() {
        return this.f3328s;
    }

    @Override // d0.e0.p.d.m0.c.ClassDescriptor
    public ClassKind getKind() {
        return this.v;
    }

    @Override // d0.e0.p.d.m0.c.ClassDescriptor, d0.e0.p.d.m0.c.MemberDescriptor
    public Modality getModality() {
        return this.w;
    }

    @Override // d0.e0.p.d.m0.c.ClassDescriptor
    public Collection<ClassDescriptor> getSealedSubclasses() {
        if (this.w != Modality.SEALED) {
            return Collections2.emptyList();
        }
        JavaTypeResolver attributes$default = JavaTypeResolver5.toAttributes$default(TypeUsage.COMMON, false, null, 3, null);
        Collection<javaTypes3> permittedTypes = this.f3328s.getPermittedTypes();
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = permittedTypes.iterator();
        while (it.hasNext()) {
            ClassifierDescriptor declarationDescriptor = this.u.getTypeResolver().transformJavaType((javaTypes3) it.next(), attributes$default).getConstructor().getDeclarationDescriptor();
            ClassDescriptor classDescriptor = declarationDescriptor instanceof ClassDescriptor ? (ClassDescriptor) declarationDescriptor : null;
            if (classDescriptor != null) {
                arrayList.add(classDescriptor);
            }
        }
        return arrayList;
    }

    @Override // d0.e0.p.d.m0.c.ClassDescriptor
    public MemberScope3 getStaticScope() {
        return this.D;
    }

    @Override // d0.e0.p.d.m0.c.ClassifierDescriptor
    public TypeConstructor getTypeConstructor() {
        return this.f3331z;
    }

    @Override // d0.e0.p.d.m0.c.i1.AbstractClassDescriptor, d0.e0.p.d.m0.c.ClassDescriptor
    public MemberScope3 getUnsubstitutedInnerClassesScope() {
        return this.C;
    }

    @Override // d0.e0.p.d.m0.c.i1.ModuleAwareClassDescriptor
    public MemberScope3 getUnsubstitutedMemberScope(KotlinTypeRefiner kotlinTypeRefiner) {
        Intrinsics3.checkNotNullParameter(kotlinTypeRefiner, "kotlinTypeRefiner");
        return (LazyJavaClassMemberScope2) this.B.getScope(kotlinTypeRefiner);
    }

    @Override // d0.e0.p.d.m0.c.ClassDescriptor
    public ClassConstructorDescriptor getUnsubstitutedPrimaryConstructor() {
        return null;
    }

    @Override // d0.e0.p.d.m0.c.ClassDescriptor, d0.e0.p.d.m0.c.DeclarationDescriptorWithVisibility, d0.e0.p.d.m0.c.MemberDescriptor
    public DescriptorVisibility2 getVisibility() {
        if (!Intrinsics3.areEqual(this.f3329x, DescriptorVisibilities.a) || this.f3328s.getOuterClass() != null) {
            return utils2.toDescriptorVisibility(this.f3329x);
        }
        DescriptorVisibility2 descriptorVisibility2 = JavaDescriptorVisibilities.a;
        Intrinsics3.checkNotNullExpressionValue(descriptorVisibility2, "{\n            JavaDescriptorVisibilities.PACKAGE_VISIBILITY\n        }");
        return descriptorVisibility2;
    }

    @Override // d0.e0.p.d.m0.c.MemberDescriptor
    public boolean isActual() {
        return false;
    }

    @Override // d0.e0.p.d.m0.c.ClassDescriptor
    public boolean isCompanionObject() {
        return false;
    }

    @Override // d0.e0.p.d.m0.c.ClassDescriptor
    public boolean isData() {
        return false;
    }

    @Override // d0.e0.p.d.m0.c.MemberDescriptor
    public boolean isExpect() {
        return false;
    }

    @Override // d0.e0.p.d.m0.c.ClassDescriptor
    public boolean isFun() {
        return false;
    }

    @Override // d0.e0.p.d.m0.c.ClassDescriptor
    public boolean isInline() {
        return false;
    }

    @Override // d0.e0.p.d.m0.c.ClassifierDescriptorWithTypeParameters
    public boolean isInner() {
        return this.f3330y;
    }

    @Override // d0.e0.p.d.m0.c.ClassDescriptor
    public boolean isValue() {
        return false;
    }

    public String toString() {
        return Intrinsics3.stringPlus("Lazy Java class ", DescriptorUtils2.getFqNameUnsafe(this));
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LazyJavaClassDescriptor(context4 context4Var, DeclarationDescriptor declarationDescriptor, d0.e0.p.d.m0.e.a.k0.g gVar, ClassDescriptor classDescriptor) {
        Modality modalityConvertFromFlags;
        super(context4Var.getStorageManager(), declarationDescriptor, gVar.getName(), context4Var.getComponents().getSourceElementFactory().source(gVar), false);
        Intrinsics3.checkNotNullParameter(context4Var, "outerContext");
        Intrinsics3.checkNotNullParameter(declarationDescriptor, "containingDeclaration");
        Intrinsics3.checkNotNullParameter(gVar, "jClass");
        this.r = context4Var;
        this.f3328s = gVar;
        this.t = classDescriptor;
        context4 context4VarChildForClassOrPackage$default = context.childForClassOrPackage$default(context4Var, this, gVar, 0, 4, null);
        this.u = context4VarChildForClassOrPackage$default;
        ((JavaResolverCache.a) context4VarChildForClassOrPackage$default.getComponents().getJavaResolverCache()).recordClass(gVar, this);
        gVar.getLightClassOriginKind();
        this.v = gVar.isAnnotationType() ? ClassKind.ANNOTATION_CLASS : gVar.isInterface() ? ClassKind.INTERFACE : gVar.isEnum() ? ClassKind.ENUM_CLASS : ClassKind.CLASS;
        if (gVar.isAnnotationType() || gVar.isEnum()) {
            modalityConvertFromFlags = Modality.FINAL;
        } else {
            modalityConvertFromFlags = Modality.j.convertFromFlags(false, gVar.isSealed() || gVar.isAbstract() || gVar.isInterface(), !gVar.isFinal());
        }
        this.w = modalityConvertFromFlags;
        this.f3329x = gVar.getVisibility();
        this.f3330y = (gVar.getOuterClass() == null || gVar.isStatic()) ? false : true;
        this.f3331z = new b(this);
        LazyJavaClassMemberScope2 lazyJavaClassMemberScope2 = new LazyJavaClassMemberScope2(context4VarChildForClassOrPackage$default, this, gVar, classDescriptor != null, null, 16, null);
        this.A = lazyJavaClassMemberScope2;
        this.B = ScopesHolderForClass.a.create(this, context4VarChildForClassOrPackage$default.getStorageManager(), context4VarChildForClassOrPackage$default.getComponents().getKotlinTypeChecker().getKotlinTypeRefiner(), new d());
        this.C = new InnerClassesScopeWrapper(lazyJavaClassMemberScope2);
        this.D = new LazyJavaStaticClassScope2(context4VarChildForClassOrPackage$default, gVar, this);
        this.E = LazyJavaAnnotations2.resolveAnnotations(context4VarChildForClassOrPackage$default, gVar);
        this.F = context4VarChildForClassOrPackage$default.getStorageManager().createLazyValue(new c());
    }

    @Override // d0.e0.p.d.m0.c.ClassDescriptor
    public List<ClassConstructorDescriptor> getConstructors() {
        return this.A.getConstructors$descriptors_jvm().invoke();
    }

    @Override // d0.e0.p.d.m0.c.i1.AbstractClassDescriptor, d0.e0.p.d.m0.c.ClassDescriptor
    public /* bridge */ /* synthetic */ MemberScope3 getUnsubstitutedMemberScope() {
        return getUnsubstitutedMemberScope();
    }

    @Override // d0.e0.p.d.m0.c.i1.AbstractClassDescriptor, d0.e0.p.d.m0.c.ClassDescriptor
    public LazyJavaClassMemberScope2 getUnsubstitutedMemberScope() {
        return (LazyJavaClassMemberScope2) super.getUnsubstitutedMemberScope();
    }
}
