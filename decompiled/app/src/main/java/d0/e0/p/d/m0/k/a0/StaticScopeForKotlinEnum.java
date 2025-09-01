package d0.e0.p.d.m0.k.a0;

import com.discord.models.domain.ModelAuditLogEntry;
import d0.e0.p.d.m0.c.ClassDescriptor;
import d0.e0.p.d.m0.c.ClassKind;
import d0.e0.p.d.m0.c.ClassifierDescriptor;
import d0.e0.p.d.m0.c.SimpleFunctionDescriptor;
import d0.e0.p.d.m0.d.b.LookupLocation2;
import d0.e0.p.d.m0.g.Name;
import d0.e0.p.d.m0.k.DescriptorFactory;
import d0.e0.p.d.m0.m.StorageManager;
import d0.e0.p.d.m0.m.storage5;
import d0.e0.p.d.m0.m.storage7;
import d0.e0.p.d.m0.p.SmartList;
import d0.t.Collections2;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import d0.z.d.PropertyReference1Impl;
import d0.z.d.Reflection2;
import java.util.Collection;
import java.util.List;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KProperty;

/* compiled from: StaticScopeForKotlinEnum.kt */
/* renamed from: d0.e0.p.d.m0.k.a0.m, reason: use source file name */
/* loaded from: classes3.dex */
public final class StaticScopeForKotlinEnum extends MemberScopeImpl {

    /* renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ KProperty<Object>[] f3462b = {Reflection2.property1(new PropertyReference1Impl(Reflection2.getOrCreateKotlinClass(StaticScopeForKotlinEnum.class), "functions", "getFunctions()Ljava/util/List;"))};
    public final ClassDescriptor c;
    public final storage5 d;

    /* compiled from: StaticScopeForKotlinEnum.kt */
    /* renamed from: d0.e0.p.d.m0.k.a0.m$a */
    public static final class a extends Lambda implements Function0<List<? extends SimpleFunctionDescriptor>> {
        public a() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ List<? extends SimpleFunctionDescriptor> invoke() {
            return invoke2();
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final List<? extends SimpleFunctionDescriptor> invoke2() {
            return Collections2.listOf((Object[]) new SimpleFunctionDescriptor[]{DescriptorFactory.createEnumValueOfMethod(StaticScopeForKotlinEnum.access$getContainingClass$p(StaticScopeForKotlinEnum.this)), DescriptorFactory.createEnumValuesMethod(StaticScopeForKotlinEnum.access$getContainingClass$p(StaticScopeForKotlinEnum.this))});
        }
    }

    public StaticScopeForKotlinEnum(StorageManager storageManager, ClassDescriptor classDescriptor) {
        Intrinsics3.checkNotNullParameter(storageManager, "storageManager");
        Intrinsics3.checkNotNullParameter(classDescriptor, "containingClass");
        this.c = classDescriptor;
        classDescriptor.getKind();
        ClassKind classKind = ClassKind.ENUM_CLASS;
        this.d = storageManager.createLazyValue(new a());
    }

    public static final /* synthetic */ ClassDescriptor access$getContainingClass$p(StaticScopeForKotlinEnum staticScopeForKotlinEnum) {
        return staticScopeForKotlinEnum.c;
    }

    @Override // d0.e0.p.d.m0.k.a0.MemberScopeImpl, d0.e0.p.d.m0.k.a0.ResolutionScope
    public /* bridge */ /* synthetic */ ClassifierDescriptor getContributedClassifier(Name name, LookupLocation2 lookupLocation2) {
        return (ClassifierDescriptor) m92getContributedClassifier(name, lookupLocation2);
    }

    /* renamed from: getContributedClassifier, reason: collision with other method in class */
    public Void m92getContributedClassifier(Name name, LookupLocation2 lookupLocation2) {
        Intrinsics3.checkNotNullParameter(name, ModelAuditLogEntry.CHANGE_KEY_NAME);
        Intrinsics3.checkNotNullParameter(lookupLocation2, ModelAuditLogEntry.CHANGE_KEY_LOCATION);
        return null;
    }

    @Override // d0.e0.p.d.m0.k.a0.MemberScopeImpl, d0.e0.p.d.m0.k.a0.ResolutionScope
    public /* bridge */ /* synthetic */ Collection getContributedDescriptors(MemberScope2 memberScope2, Function1 function1) {
        return getContributedDescriptors(memberScope2, (Function1<? super Name, Boolean>) function1);
    }

    @Override // d0.e0.p.d.m0.k.a0.MemberScopeImpl, d0.e0.p.d.m0.k.a0.MemberScope3
    public /* bridge */ /* synthetic */ Collection getContributedFunctions(Name name, LookupLocation2 lookupLocation2) {
        return getContributedFunctions(name, lookupLocation2);
    }

    @Override // d0.e0.p.d.m0.k.a0.MemberScopeImpl, d0.e0.p.d.m0.k.a0.ResolutionScope
    public List<SimpleFunctionDescriptor> getContributedDescriptors(MemberScope2 memberScope2, Function1<? super Name, Boolean> function1) {
        Intrinsics3.checkNotNullParameter(memberScope2, "kindFilter");
        Intrinsics3.checkNotNullParameter(function1, "nameFilter");
        return (List) storage7.getValue(this.d, this, (KProperty<?>) f3462b[0]);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // d0.e0.p.d.m0.k.a0.MemberScopeImpl, d0.e0.p.d.m0.k.a0.MemberScope3
    public SmartList<SimpleFunctionDescriptor> getContributedFunctions(Name name, LookupLocation2 lookupLocation2) {
        Intrinsics3.checkNotNullParameter(name, ModelAuditLogEntry.CHANGE_KEY_NAME);
        Intrinsics3.checkNotNullParameter(lookupLocation2, ModelAuditLogEntry.CHANGE_KEY_LOCATION);
        List list = (List) storage7.getValue(this.d, this, (KProperty<?>) f3462b[0]);
        SmartList<SimpleFunctionDescriptor> smartList = new SmartList<>();
        for (Object obj : list) {
            if (Intrinsics3.areEqual(((SimpleFunctionDescriptor) obj).getName(), name)) {
                smartList.add(obj);
            }
        }
        return smartList;
    }
}
