package d0.e0.p.d.m0.k.a0;

import com.discord.models.domain.ModelAuditLogEntry;
import d0.e0.p.d.m0.c.CallableDescriptor;
import d0.e0.p.d.m0.c.DeclarationDescriptor;
import d0.e0.p.d.m0.c.PropertyDescriptor;
import d0.e0.p.d.m0.c.SimpleFunctionDescriptor;
import d0.e0.p.d.m0.d.b.LookupLocation2;
import d0.e0.p.d.m0.g.Name;
import d0.e0.p.d.m0.k.overridingUtils;
import d0.e0.p.d.m0.n.KotlinType;
import d0.e0.p.d.m0.o.n.scopeUtils;
import d0.e0.p.d.m0.p.SmartList;
import d0.t.Iterables2;
import d0.t._Collections;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Tuples2;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: TypeIntersectionScope.kt */
/* renamed from: d0.e0.p.d.m0.k.a0.o, reason: use source file name */
/* loaded from: classes3.dex */
public final class TypeIntersectionScope extends AbstractScopeAdapter {

    /* renamed from: b, reason: collision with root package name */
    public static final a f3464b = new a(null);
    public final MemberScope3 c;

    /* compiled from: TypeIntersectionScope.kt */
    /* renamed from: d0.e0.p.d.m0.k.a0.o$a */
    public static final class a {
        public a(DefaultConstructorMarker defaultConstructorMarker) {
        }

        public final MemberScope3 create(String str, Collection<? extends KotlinType> collection) {
            Intrinsics3.checkNotNullParameter(str, "message");
            Intrinsics3.checkNotNullParameter(collection, "types");
            ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(collection, 10));
            Iterator<T> it = collection.iterator();
            while (it.hasNext()) {
                arrayList.add(((KotlinType) it.next()).getMemberScope());
            }
            SmartList<MemberScope3> smartListListOfNonEmptyScopes = scopeUtils.listOfNonEmptyScopes(arrayList);
            MemberScope3 memberScope3CreateOrSingle$descriptors = ChainedMemberScope.f3451b.createOrSingle$descriptors(str, smartListListOfNonEmptyScopes);
            return smartListListOfNonEmptyScopes.size() <= 1 ? memberScope3CreateOrSingle$descriptors : new TypeIntersectionScope(str, memberScope3CreateOrSingle$descriptors, null);
        }
    }

    /* compiled from: TypeIntersectionScope.kt */
    /* renamed from: d0.e0.p.d.m0.k.a0.o$b */
    public static final class b extends Lambda implements Function1<CallableDescriptor, CallableDescriptor> {
        public static final b j = new b();

        public b() {
            super(1);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final CallableDescriptor invoke2(CallableDescriptor callableDescriptor) {
            Intrinsics3.checkNotNullParameter(callableDescriptor, "<this>");
            return callableDescriptor;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ CallableDescriptor invoke(CallableDescriptor callableDescriptor) {
            return invoke2(callableDescriptor);
        }
    }

    /* compiled from: TypeIntersectionScope.kt */
    /* renamed from: d0.e0.p.d.m0.k.a0.o$c */
    public static final class c extends Lambda implements Function1<SimpleFunctionDescriptor, CallableDescriptor> {
        public static final c j = new c();

        public c() {
            super(1);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final CallableDescriptor invoke2(SimpleFunctionDescriptor simpleFunctionDescriptor) {
            Intrinsics3.checkNotNullParameter(simpleFunctionDescriptor, "<this>");
            return simpleFunctionDescriptor;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ CallableDescriptor invoke(SimpleFunctionDescriptor simpleFunctionDescriptor) {
            return invoke2(simpleFunctionDescriptor);
        }
    }

    /* compiled from: TypeIntersectionScope.kt */
    /* renamed from: d0.e0.p.d.m0.k.a0.o$d */
    public static final class d extends Lambda implements Function1<PropertyDescriptor, CallableDescriptor> {
        public static final d j = new d();

        public d() {
            super(1);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final CallableDescriptor invoke2(PropertyDescriptor propertyDescriptor) {
            Intrinsics3.checkNotNullParameter(propertyDescriptor, "<this>");
            return propertyDescriptor;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ CallableDescriptor invoke(PropertyDescriptor propertyDescriptor) {
            return invoke2(propertyDescriptor);
        }
    }

    public TypeIntersectionScope(String str, MemberScope3 memberScope3, DefaultConstructorMarker defaultConstructorMarker) {
        this.c = memberScope3;
    }

    public static final MemberScope3 create(String str, Collection<? extends KotlinType> collection) {
        return f3464b.create(str, collection);
    }

    @Override // d0.e0.p.d.m0.k.a0.AbstractScopeAdapter
    public MemberScope3 a() {
        return this.c;
    }

    @Override // d0.e0.p.d.m0.k.a0.AbstractScopeAdapter, d0.e0.p.d.m0.k.a0.ResolutionScope
    public Collection<DeclarationDescriptor> getContributedDescriptors(MemberScope2 memberScope2, Function1<? super Name, Boolean> function1) {
        Intrinsics3.checkNotNullParameter(memberScope2, "kindFilter");
        Intrinsics3.checkNotNullParameter(function1, "nameFilter");
        Collection<DeclarationDescriptor> contributedDescriptors = super.getContributedDescriptors(memberScope2, function1);
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : contributedDescriptors) {
            if (((DeclarationDescriptor) obj) instanceof CallableDescriptor) {
                arrayList.add(obj);
            } else {
                arrayList2.add(obj);
            }
        }
        Tuples2 tuples2 = new Tuples2(arrayList, arrayList2);
        List list = (List) tuples2.component1();
        return _Collections.plus(overridingUtils.selectMostSpecificInEachOverridableGroup(list, b.j), (Iterable) tuples2.component2());
    }

    @Override // d0.e0.p.d.m0.k.a0.AbstractScopeAdapter, d0.e0.p.d.m0.k.a0.MemberScope3
    public Collection<SimpleFunctionDescriptor> getContributedFunctions(Name name, LookupLocation2 lookupLocation2) {
        Intrinsics3.checkNotNullParameter(name, ModelAuditLogEntry.CHANGE_KEY_NAME);
        Intrinsics3.checkNotNullParameter(lookupLocation2, ModelAuditLogEntry.CHANGE_KEY_LOCATION);
        return overridingUtils.selectMostSpecificInEachOverridableGroup(super.getContributedFunctions(name, lookupLocation2), c.j);
    }

    @Override // d0.e0.p.d.m0.k.a0.AbstractScopeAdapter, d0.e0.p.d.m0.k.a0.MemberScope3
    public Collection<PropertyDescriptor> getContributedVariables(Name name, LookupLocation2 lookupLocation2) {
        Intrinsics3.checkNotNullParameter(name, ModelAuditLogEntry.CHANGE_KEY_NAME);
        Intrinsics3.checkNotNullParameter(lookupLocation2, ModelAuditLogEntry.CHANGE_KEY_LOCATION);
        return overridingUtils.selectMostSpecificInEachOverridableGroup(super.getContributedVariables(name, lookupLocation2), d.j);
    }
}
