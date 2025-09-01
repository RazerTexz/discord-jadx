package com.discord.widgets.servers.member_verification;

import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* compiled from: MemberVerificationRulesAdapter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"", "<anonymous parameter 0>", "", "<anonymous parameter 1>", "", "invoke", "(ILjava/lang/Object;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.servers.member_verification.MemberVerificationRulesAdapter$onUserInputDataEntered$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class MemberVerificationRulesAdapter6 extends Lambda implements Function2<Integer, Object, Unit> {
    public static final MemberVerificationRulesAdapter6 INSTANCE = new MemberVerificationRulesAdapter6();

    public MemberVerificationRulesAdapter6() {
        super(2);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(Integer num, Object obj) {
        invoke(num.intValue(), obj);
        return Unit.a;
    }

    public final void invoke(int i, Object obj) {
        Intrinsics3.checkNotNullParameter(obj, "<anonymous parameter 1>");
    }
}
