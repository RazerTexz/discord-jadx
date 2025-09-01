package com.discord.widgets.user.phone;

import androidx.fragment.app.FragmentActivity;
import b.a.d.AppScreen2;
import com.discord.widgets.settings.account.WidgetSettingsAccount;
import com.discord.widgets.user.account.WidgetUserAccountVerifyBase;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* compiled from: WidgetUserPhoneVerify.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.user.phone.WidgetUserPhoneVerify$passwordVerifyLauncher$1, reason: use source file name */
/* loaded from: classes.dex */
public final class WidgetUserPhoneVerify9 extends Lambda implements Function0<Unit> {
    public final /* synthetic */ WidgetUserPhoneVerify this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetUserPhoneVerify9(WidgetUserPhoneVerify widgetUserPhoneVerify) {
        super(0);
        this.this$0 = widgetUserPhoneVerify;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        FragmentActivity fragmentActivityRequireActivity = this.this$0.requireActivity();
        Intrinsics3.checkNotNullExpressionValue(fragmentActivityRequireActivity, "requireActivity()");
        if (fragmentActivityRequireActivity.getCallingActivity() != null) {
            this.this$0.requireActivity().setResult(-1);
            this.this$0.requireActivity().finish();
        } else if (WidgetUserPhoneVerify.access$getMode$p(this.this$0) == WidgetUserAccountVerifyBase.Mode.NO_HISTORY_FROM_USER_SETTINGS) {
            WidgetSettingsAccount.INSTANCE.launch(this.this$0.requireContext(), false, WidgetSettingsAccount.Redirect.SMS_BACKUP);
        } else {
            if (this.this$0.isForced()) {
                return;
            }
            AppScreen2.c(this.this$0.requireContext(), false, null, 6);
        }
    }
}
