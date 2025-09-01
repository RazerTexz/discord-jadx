package d0.e0.p.d.m0.e.a.i0.l;

import d0.Tuples;
import d0.e0.p.d.m0.c.ClassDescriptor;
import d0.e0.p.d.m0.c.SourceElement;
import d0.e0.p.d.m0.c.g1.Annotations4;
import d0.e0.p.d.m0.c.i1.PackageFragmentDescriptorImpl;
import d0.e0.p.d.m0.e.a.i0.LazyJavaAnnotations2;
import d0.e0.p.d.m0.e.a.i0.context;
import d0.e0.p.d.m0.e.a.i0.context4;
import d0.e0.p.d.m0.e.a.k0.u;
import d0.e0.p.d.m0.e.b.KotlinClassFinder2;
import d0.e0.p.d.m0.e.b.KotlinJvmBinaryClass;
import d0.e0.p.d.m0.e.b.KotlinJvmBinaryPackageSourceElement;
import d0.e0.p.d.m0.e.b.PackagePartProvider;
import d0.e0.p.d.m0.e.b.b0.KotlinClassHeader;
import d0.e0.p.d.m0.g.ClassId;
import d0.e0.p.d.m0.g.FqName;
import d0.e0.p.d.m0.k.a0.MemberScope3;
import d0.e0.p.d.m0.k.y.JvmClassName;
import d0.e0.p.d.m0.m.storage5;
import d0.e0.p.d.m0.m.storage7;
import d0.t.Collections2;
import d0.t.Iterables2;
import d0.t.Maps6;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import d0.z.d.PropertyReference1Impl;
import d0.z.d.Reflection2;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Tuples2;
import kotlin.jvm.functions.Function0;
import kotlin.reflect.KProperty;

/* compiled from: LazyJavaPackageFragment.kt */
/* renamed from: d0.e0.p.d.m0.e.a.i0.l.i, reason: use source file name */
/* loaded from: classes3.dex */
public final class LazyJavaPackageFragment extends PackageFragmentDescriptorImpl {
    public static final /* synthetic */ KProperty<Object>[] o = {Reflection2.property1(new PropertyReference1Impl(Reflection2.getOrCreateKotlinClass(LazyJavaPackageFragment.class), "binaryClasses", "getBinaryClasses$descriptors_jvm()Ljava/util/Map;")), Reflection2.property1(new PropertyReference1Impl(Reflection2.getOrCreateKotlinClass(LazyJavaPackageFragment.class), "partToFacade", "getPartToFacade()Ljava/util/HashMap;"))};
    public final u p;
    public final context4 q;
    public final storage5 r;

    /* renamed from: s, reason: collision with root package name */
    public final JvmPackageScope f3333s;
    public final storage5<List<FqName>> t;
    public final Annotations4 u;

    /* compiled from: LazyJavaPackageFragment.kt */
    /* renamed from: d0.e0.p.d.m0.e.a.i0.l.i$a */
    public static final class a extends Lambda implements Function0<Map<String, ? extends KotlinJvmBinaryClass>> {
        public a() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Map<String, ? extends KotlinJvmBinaryClass> invoke() {
            return invoke2();
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Map<String, ? extends KotlinJvmBinaryClass> invoke2() {
            PackagePartProvider packagePartProvider = LazyJavaPackageFragment.access$getC$p(LazyJavaPackageFragment.this).getComponents().getPackagePartProvider();
            String strAsString = LazyJavaPackageFragment.this.getFqName().asString();
            Intrinsics3.checkNotNullExpressionValue(strAsString, "fqName.asString()");
            List<String> listFindPackageParts = packagePartProvider.findPackageParts(strAsString);
            LazyJavaPackageFragment lazyJavaPackageFragment = LazyJavaPackageFragment.this;
            ArrayList arrayList = new ArrayList();
            for (String str : listFindPackageParts) {
                ClassId classId = ClassId.topLevel(JvmClassName.byInternalName(str).getFqNameForTopLevelClassMaybeWithDollars());
                Intrinsics3.checkNotNullExpressionValue(classId, "topLevel(JvmClassName.byInternalName(partName).fqNameForTopLevelClassMaybeWithDollars)");
                KotlinJvmBinaryClass kotlinJvmBinaryClassFindKotlinClass = KotlinClassFinder2.findKotlinClass(LazyJavaPackageFragment.access$getC$p(lazyJavaPackageFragment).getComponents().getKotlinClassFinder(), classId);
                Tuples2 tuples2 = kotlinJvmBinaryClassFindKotlinClass == null ? null : Tuples.to(str, kotlinJvmBinaryClassFindKotlinClass);
                if (tuples2 != null) {
                    arrayList.add(tuples2);
                }
            }
            return Maps6.toMap(arrayList);
        }
    }

    /* compiled from: LazyJavaPackageFragment.kt */
    /* renamed from: d0.e0.p.d.m0.e.a.i0.l.i$b */
    public static final class b extends Lambda implements Function0<HashMap<JvmClassName, JvmClassName>> {
        public b() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ HashMap<JvmClassName, JvmClassName> invoke() {
            return invoke2();
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final HashMap<JvmClassName, JvmClassName> invoke2() {
            String multifileClassName;
            HashMap<JvmClassName, JvmClassName> map = new HashMap<>();
            for (Map.Entry<String, KotlinJvmBinaryClass> entry : LazyJavaPackageFragment.this.getBinaryClasses$descriptors_jvm().entrySet()) {
                String key = entry.getKey();
                KotlinJvmBinaryClass value = entry.getValue();
                JvmClassName jvmClassNameByInternalName = JvmClassName.byInternalName(key);
                Intrinsics3.checkNotNullExpressionValue(jvmClassNameByInternalName, "byInternalName(partInternalName)");
                KotlinClassHeader classHeader = value.getClassHeader();
                int iOrdinal = classHeader.getKind().ordinal();
                if (iOrdinal == 2) {
                    map.put(jvmClassNameByInternalName, jvmClassNameByInternalName);
                } else if (iOrdinal == 5 && (multifileClassName = classHeader.getMultifileClassName()) != null) {
                    JvmClassName jvmClassNameByInternalName2 = JvmClassName.byInternalName(multifileClassName);
                    Intrinsics3.checkNotNullExpressionValue(jvmClassNameByInternalName2, "byInternalName(header.multifileClassName ?: continue@kotlinClasses)");
                    map.put(jvmClassNameByInternalName, jvmClassNameByInternalName2);
                }
            }
            return map;
        }
    }

    /* compiled from: LazyJavaPackageFragment.kt */
    /* renamed from: d0.e0.p.d.m0.e.a.i0.l.i$c */
    public static final class c extends Lambda implements Function0<List<? extends FqName>> {
        public c() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ List<? extends FqName> invoke() {
            return invoke2();
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final List<? extends FqName> invoke2() {
            Collection<u> subPackages = LazyJavaPackageFragment.access$getJPackage$p(LazyJavaPackageFragment.this).getSubPackages();
            ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(subPackages, 10));
            Iterator<T> it = subPackages.iterator();
            while (it.hasNext()) {
                arrayList.add(((u) it.next()).getFqName());
            }
            return arrayList;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LazyJavaPackageFragment(context4 context4Var, u uVar) {
        super(context4Var.getModule(), uVar.getFqName());
        Intrinsics3.checkNotNullParameter(context4Var, "outerContext");
        Intrinsics3.checkNotNullParameter(uVar, "jPackage");
        this.p = uVar;
        context4 context4VarChildForClassOrPackage$default = context.childForClassOrPackage$default(context4Var, this, null, 0, 6, null);
        this.q = context4VarChildForClassOrPackage$default;
        this.r = context4VarChildForClassOrPackage$default.getStorageManager().createLazyValue(new a());
        this.f3333s = new JvmPackageScope(context4VarChildForClassOrPackage$default, uVar, this);
        this.t = context4VarChildForClassOrPackage$default.getStorageManager().createRecursionTolerantLazyValue(new c(), Collections2.emptyList());
        this.u = context4VarChildForClassOrPackage$default.getComponents().getJavaTypeEnhancementState().getDisabledDefaultAnnotations() ? Annotations4.f.getEMPTY() : LazyJavaAnnotations2.resolveAnnotations(context4VarChildForClassOrPackage$default, uVar);
        context4VarChildForClassOrPackage$default.getStorageManager().createLazyValue(new b());
    }

    public static final /* synthetic */ context4 access$getC$p(LazyJavaPackageFragment lazyJavaPackageFragment) {
        return lazyJavaPackageFragment.q;
    }

    public static final /* synthetic */ u access$getJPackage$p(LazyJavaPackageFragment lazyJavaPackageFragment) {
        return lazyJavaPackageFragment.p;
    }

    public final ClassDescriptor findClassifierByJavaClass$descriptors_jvm(d0.e0.p.d.m0.e.a.k0.g gVar) {
        Intrinsics3.checkNotNullParameter(gVar, "jClass");
        return this.f3333s.getJavaScope$descriptors_jvm().findClassifierByJavaClass$descriptors_jvm(gVar);
    }

    @Override // d0.e0.p.d.m0.c.g1.AnnotatedImpl, d0.e0.p.d.m0.c.g1.Annotations3
    public Annotations4 getAnnotations() {
        return this.u;
    }

    public final Map<String, KotlinJvmBinaryClass> getBinaryClasses$descriptors_jvm() {
        return (Map) storage7.getValue(this.r, this, (KProperty<?>) o[0]);
    }

    @Override // d0.e0.p.d.m0.c.PackageFragmentDescriptor
    public /* bridge */ /* synthetic */ MemberScope3 getMemberScope() {
        return getMemberScope();
    }

    @Override // d0.e0.p.d.m0.c.i1.PackageFragmentDescriptorImpl, d0.e0.p.d.m0.c.i1.DeclarationDescriptorNonRootImpl, d0.e0.p.d.m0.c.DeclarationDescriptorWithSource
    public SourceElement getSource() {
        return new KotlinJvmBinaryPackageSourceElement(this);
    }

    public final List<FqName> getSubPackageFqNames$descriptors_jvm() {
        return this.t.invoke();
    }

    @Override // d0.e0.p.d.m0.c.i1.PackageFragmentDescriptorImpl, d0.e0.p.d.m0.c.i1.DeclarationDescriptorImpl
    public String toString() {
        return Intrinsics3.stringPlus("Lazy Java package fragment: ", getFqName());
    }

    @Override // d0.e0.p.d.m0.c.PackageFragmentDescriptor
    public JvmPackageScope getMemberScope() {
        return this.f3333s;
    }
}
