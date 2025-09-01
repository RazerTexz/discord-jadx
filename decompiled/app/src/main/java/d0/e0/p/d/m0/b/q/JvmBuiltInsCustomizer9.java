package d0.e0.p.d.m0.b.q;

import d0.e0.p.d.m0.c.CallableMemberDescriptor;
import d0.e0.p.d.m0.c.ClassDescriptor;
import d0.z.d.Lambda;
import kotlin.jvm.functions.Function1;

/* compiled from: JvmBuiltInsCustomizer.kt */
/* renamed from: d0.e0.p.d.m0.b.q.n, reason: use source file name */
/* loaded from: classes3.dex */
public final class JvmBuiltInsCustomizer9 extends Lambda implements Function1<CallableMemberDescriptor, Boolean> {
    public final /* synthetic */ JvmBuiltInsCustomizer2 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public JvmBuiltInsCustomizer9(JvmBuiltInsCustomizer2 jvmBuiltInsCustomizer2) {
        super(1);
        this.this$0 = jvmBuiltInsCustomizer2;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Boolean invoke(CallableMemberDescriptor callableMemberDescriptor) {
        return invoke2(callableMemberDescriptor);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Boolean invoke2(CallableMemberDescriptor callableMemberDescriptor) {
        return Boolean.valueOf(callableMemberDescriptor.getKind() == CallableMemberDescriptor.a.DECLARATION && JvmBuiltInsCustomizer2.access$getJ2kClassMapper$p(this.this$0).isMutable((ClassDescriptor) callableMemberDescriptor.getContainingDeclaration()));
    }
}
