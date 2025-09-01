package d0.e0.p.d.m0.c;

import d0.e0.p.d.m0.k.a0.MemberScope3;
import d0.z.d.Lambda;
import kotlin.jvm.functions.Function0;

/* JADX INFO: Add missing generic type declarations: [T] */
/* compiled from: ScopesHolderForClass.kt */
/* renamed from: d0.e0.p.d.m0.c.s0, reason: use source file name */
/* loaded from: classes3.dex */
public final class ScopesHolderForClass2<T> extends Lambda implements Function0<T> {
    public final /* synthetic */ ScopesHolderForClass<T> this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ScopesHolderForClass2(ScopesHolderForClass<T> scopesHolderForClass) {
        super(0);
        this.this$0 = scopesHolderForClass;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Object invoke() {
        return invoke();
    }

    /* JADX WARN: Incorrect return type in method signature: ()TT; */
    @Override // kotlin.jvm.functions.Function0
    public final MemberScope3 invoke() {
        return (MemberScope3) ScopesHolderForClass.access$getScopeFactory$p(this.this$0).invoke(ScopesHolderForClass.access$getKotlinTypeRefinerForOwnerModule$p(this.this$0));
    }
}
