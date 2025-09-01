package d0.e0.p.d.m0.k.a0;

import com.discord.models.domain.ModelAuditLogEntry;
import d0.e0.p.d.m0.c.CallableMemberDescriptor;
import d0.e0.p.d.m0.c.ClassDescriptor;
import d0.e0.p.d.m0.c.DeclarationDescriptor;
import d0.e0.p.d.m0.c.FunctionDescriptor;
import d0.e0.p.d.m0.c.PropertyDescriptor;
import d0.e0.p.d.m0.c.SimpleFunctionDescriptor;
import d0.e0.p.d.m0.d.b.LookupLocation2;
import d0.e0.p.d.m0.g.Name;
import d0.e0.p.d.m0.k.OverridingUtil;
import d0.e0.p.d.m0.k.a0.ResolutionScope;
import d0.e0.p.d.m0.m.StorageManager;
import d0.e0.p.d.m0.m.storage5;
import d0.e0.p.d.m0.m.storage7;
import d0.e0.p.d.m0.n.KotlinType;
import d0.e0.p.d.m0.p.SmartList;
import d0.e0.p.d.m0.p.collections;
import d0.t.Collections2;
import d0.t.MutableCollections;
import d0.t._Collections;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import d0.z.d.PropertyReference1Impl;
import d0.z.d.Reflection2;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KProperty;

/* compiled from: GivenFunctionsMemberScope.kt */
/* renamed from: d0.e0.p.d.m0.k.a0.e, reason: use source file name */
/* loaded from: classes3.dex */
public abstract class GivenFunctionsMemberScope extends MemberScopeImpl {

    /* renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ KProperty<Object>[] f3456b = {Reflection2.property1(new PropertyReference1Impl(Reflection2.getOrCreateKotlinClass(GivenFunctionsMemberScope.class), "allDescriptors", "getAllDescriptors()Ljava/util/List;"))};
    public final ClassDescriptor c;
    public final storage5 d;

    /* compiled from: GivenFunctionsMemberScope.kt */
    /* renamed from: d0.e0.p.d.m0.k.a0.e$a */
    public static final class a extends Lambda implements Function0<List<? extends DeclarationDescriptor>> {
        public a() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ List<? extends DeclarationDescriptor> invoke() {
            return invoke2();
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final List<? extends DeclarationDescriptor> invoke2() {
            List<FunctionDescriptor> listA = GivenFunctionsMemberScope.this.a();
            return _Collections.plus((Collection) listA, (Iterable) GivenFunctionsMemberScope.access$createFakeOverrides(GivenFunctionsMemberScope.this, listA));
        }
    }

    public GivenFunctionsMemberScope(StorageManager storageManager, ClassDescriptor classDescriptor) {
        Intrinsics3.checkNotNullParameter(storageManager, "storageManager");
        Intrinsics3.checkNotNullParameter(classDescriptor, "containingClass");
        this.c = classDescriptor;
        this.d = storageManager.createLazyValue(new a());
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v4, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r5v5 */
    /* JADX WARN: Type inference failed for: r5v7, types: [java.util.ArrayList] */
    public static final List access$createFakeOverrides(GivenFunctionsMemberScope givenFunctionsMemberScope, List list) {
        Collection<? extends CallableMemberDescriptor> collectionEmptyList;
        Objects.requireNonNull(givenFunctionsMemberScope);
        ArrayList arrayList = new ArrayList(3);
        Collection<KotlinType> supertypes = givenFunctionsMemberScope.c.getTypeConstructor().getSupertypes();
        Intrinsics3.checkNotNullExpressionValue(supertypes, "containingClass.typeConstructor.supertypes");
        ArrayList arrayList2 = new ArrayList();
        Iterator it = supertypes.iterator();
        while (it.hasNext()) {
            MutableCollections.addAll(arrayList2, ResolutionScope.a.getContributedDescriptors$default(((KotlinType) it.next()).getMemberScope(), null, null, 3, null));
        }
        ArrayList arrayList3 = new ArrayList();
        Iterator it2 = arrayList2.iterator();
        while (it2.hasNext()) {
            Object next = it2.next();
            if (next instanceof CallableMemberDescriptor) {
                arrayList3.add(next);
            }
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator it3 = arrayList3.iterator();
        while (it3.hasNext()) {
            Object next2 = it3.next();
            Name name = ((CallableMemberDescriptor) next2).getName();
            Object arrayList4 = linkedHashMap.get(name);
            if (arrayList4 == null) {
                arrayList4 = new ArrayList();
                linkedHashMap.put(name, arrayList4);
            }
            ((List) arrayList4).add(next2);
        }
        for (Map.Entry entry : linkedHashMap.entrySet()) {
            Name name2 = (Name) entry.getKey();
            List list2 = (List) entry.getValue();
            LinkedHashMap linkedHashMap2 = new LinkedHashMap();
            for (Object obj : list2) {
                Boolean boolValueOf = Boolean.valueOf(((CallableMemberDescriptor) obj) instanceof FunctionDescriptor);
                Object arrayList5 = linkedHashMap2.get(boolValueOf);
                if (arrayList5 == null) {
                    arrayList5 = new ArrayList();
                    linkedHashMap2.put(boolValueOf, arrayList5);
                }
                ((List) arrayList5).add(obj);
            }
            for (Map.Entry entry2 : linkedHashMap2.entrySet()) {
                boolean zBooleanValue = ((Boolean) entry2.getKey()).booleanValue();
                List list3 = (List) entry2.getValue();
                OverridingUtil overridingUtil = OverridingUtil.f3468b;
                if (zBooleanValue) {
                    collectionEmptyList = new ArrayList();
                    for (Object obj2 : list) {
                        if (Intrinsics3.areEqual(((FunctionDescriptor) obj2).getName(), name2)) {
                            collectionEmptyList.add(obj2);
                        }
                    }
                } else {
                    collectionEmptyList = Collections2.emptyList();
                }
                overridingUtil.generateOverridesInFunctionGroup(name2, list3, collectionEmptyList, givenFunctionsMemberScope.c, new GivenFunctionsMemberScope2(arrayList, givenFunctionsMemberScope));
            }
        }
        return collections.compact(arrayList);
    }

    public abstract List<FunctionDescriptor> a();

    public final List<DeclarationDescriptor> b() {
        return (List) storage7.getValue(this.d, this, (KProperty<?>) f3456b[0]);
    }

    @Override // d0.e0.p.d.m0.k.a0.MemberScopeImpl, d0.e0.p.d.m0.k.a0.ResolutionScope
    public Collection<DeclarationDescriptor> getContributedDescriptors(MemberScope2 memberScope2, Function1<? super Name, Boolean> function1) {
        Intrinsics3.checkNotNullParameter(memberScope2, "kindFilter");
        Intrinsics3.checkNotNullParameter(function1, "nameFilter");
        return !memberScope2.acceptsKinds(MemberScope2.n.getKindMask()) ? Collections2.emptyList() : b();
    }

    @Override // d0.e0.p.d.m0.k.a0.MemberScopeImpl, d0.e0.p.d.m0.k.a0.MemberScope3
    public Collection<SimpleFunctionDescriptor> getContributedFunctions(Name name, LookupLocation2 lookupLocation2) {
        Intrinsics3.checkNotNullParameter(name, ModelAuditLogEntry.CHANGE_KEY_NAME);
        Intrinsics3.checkNotNullParameter(lookupLocation2, ModelAuditLogEntry.CHANGE_KEY_LOCATION);
        List<DeclarationDescriptor> listB = b();
        SmartList smartList = new SmartList();
        for (Object obj : listB) {
            if ((obj instanceof SimpleFunctionDescriptor) && Intrinsics3.areEqual(((SimpleFunctionDescriptor) obj).getName(), name)) {
                smartList.add(obj);
            }
        }
        return smartList;
    }

    @Override // d0.e0.p.d.m0.k.a0.MemberScopeImpl, d0.e0.p.d.m0.k.a0.MemberScope3
    public Collection<PropertyDescriptor> getContributedVariables(Name name, LookupLocation2 lookupLocation2) {
        Intrinsics3.checkNotNullParameter(name, ModelAuditLogEntry.CHANGE_KEY_NAME);
        Intrinsics3.checkNotNullParameter(lookupLocation2, ModelAuditLogEntry.CHANGE_KEY_LOCATION);
        List<DeclarationDescriptor> listB = b();
        SmartList smartList = new SmartList();
        for (Object obj : listB) {
            if ((obj instanceof PropertyDescriptor) && Intrinsics3.areEqual(((PropertyDescriptor) obj).getName(), name)) {
                smartList.add(obj);
            }
        }
        return smartList;
    }
}
