package d0.e0.p.d.m0.e.a.i0.l;

import d0.e0.p.d.m0.c.ClassDescriptor;
import d0.e0.p.d.m0.k.a0.MemberScope3;
import d0.e0.p.d.m0.p.DFS;
import d0.z.d.Intrinsics3;
import java.util.Collection;
import java.util.Set;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: LazyJavaStaticClassScope.kt */
/* renamed from: d0.e0.p.d.m0.e.a.i0.l.q, reason: use source file name */
/* loaded from: classes3.dex */
public final class LazyJavaStaticClassScope4 extends DFS.b<ClassDescriptor, Unit> {
    public final /* synthetic */ ClassDescriptor a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Set<R> f3338b;
    public final /* synthetic */ Function1<MemberScope3, Collection<R>> c;

    /* JADX WARN: Multi-variable type inference failed */
    public LazyJavaStaticClassScope4(ClassDescriptor classDescriptor, Set<R> set, Function1<? super MemberScope3, ? extends Collection<? extends R>> function1) {
        this.a = classDescriptor;
        this.f3338b = set;
        this.c = function1;
    }

    @Override // d0.e0.p.d.m0.p.DFS.d
    public /* bridge */ /* synthetic */ boolean beforeChildren(Object obj) {
        return beforeChildren((ClassDescriptor) obj);
    }

    @Override // d0.e0.p.d.m0.p.DFS.d
    public /* bridge */ /* synthetic */ Object result() {
        m87result();
        return Unit.a;
    }

    /* renamed from: result, reason: collision with other method in class */
    public void m87result() {
    }

    public boolean beforeChildren(ClassDescriptor classDescriptor) {
        Intrinsics3.checkNotNullParameter(classDescriptor, "current");
        if (classDescriptor == this.a) {
            return true;
        }
        MemberScope3 staticScope = classDescriptor.getStaticScope();
        Intrinsics3.checkNotNullExpressionValue(staticScope, "current.staticScope");
        if (!(staticScope instanceof LazyJavaStaticScope)) {
            return true;
        }
        this.f3338b.addAll((Collection) this.c.invoke(staticScope));
        return false;
    }
}
