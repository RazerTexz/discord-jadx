package com.discord.widgets.settings.account.mfa;

import android.view.View;
import android.widget.LinearLayout;
import com.discord.R;
import com.discord.databinding.WidgetSettingsEnableMfaSuccessBinding;
import com.google.android.material.button.MaterialButton;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* compiled from: WidgetEnableMFASuccess.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/view/View;", "p1", "Lcom/discord/databinding/WidgetSettingsEnableMfaSuccessBinding;", "invoke", "(Landroid/view/View;)Lcom/discord/databinding/WidgetSettingsEnableMfaSuccessBinding;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.settings.account.mfa.WidgetEnableMFASuccess$binding$2, reason: use source file name */
/* loaded from: classes2.dex */
public final /* synthetic */ class WidgetEnableMFASuccess2 extends FunctionReferenceImpl implements Function1<View, WidgetSettingsEnableMfaSuccessBinding> {
    public static final WidgetEnableMFASuccess2 INSTANCE = new WidgetEnableMFASuccess2();

    public WidgetEnableMFASuccess2() {
        super(1, WidgetSettingsEnableMfaSuccessBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetSettingsEnableMfaSuccessBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetSettingsEnableMfaSuccessBinding invoke(View view) {
        return invoke2(view);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetSettingsEnableMfaSuccessBinding invoke2(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        MaterialButton materialButton = (MaterialButton) view.findViewById(R.id.mfa_success_enable_sms);
        if (materialButton != null) {
            return new WidgetSettingsEnableMfaSuccessBinding((LinearLayout) view, materialButton);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(R.id.mfa_success_enable_sms)));
    }
}
