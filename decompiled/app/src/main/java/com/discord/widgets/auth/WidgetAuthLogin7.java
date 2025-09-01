package com.discord.widgets.auth;

import com.discord.widgets.auth.WidgetAuthPhoneVerify;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: WidgetAuthLogin.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/widgets/auth/WidgetAuthPhoneVerify$Result;", "result", "", "invoke", "(Lcom/discord/widgets/auth/WidgetAuthPhoneVerify$Result;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.auth.WidgetAuthLogin$phoneVerifyPasswordLauncher$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetAuthLogin7 extends Lambda implements Function1<WidgetAuthPhoneVerify.Result, Unit> {
    public final /* synthetic */ WidgetAuthLogin this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetAuthLogin7(WidgetAuthLogin widgetAuthLogin) {
        super(1);
        this.this$0 = widgetAuthLogin;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(WidgetAuthPhoneVerify.Result result) {
        invoke2(result);
        return Unit.a;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(WidgetAuthPhoneVerify.Result result) {
        Intrinsics3.checkNotNullParameter(result, "result");
        if (result instanceof WidgetAuthPhoneVerify.Result.Token) {
            WidgetAuthResetPassword.INSTANCE.start(this.this$0.requireContext(), ((WidgetAuthPhoneVerify.Result.Token) result).getToken());
        }
    }
}
