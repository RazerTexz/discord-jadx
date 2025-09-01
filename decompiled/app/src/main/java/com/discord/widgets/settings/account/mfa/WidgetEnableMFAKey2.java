package com.discord.widgets.settings.account.mfa;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.discord.R;
import com.discord.databinding.WidgetSettingsEnableMfaKeyBinding;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* compiled from: WidgetEnableMFAKey.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/view/View;", "p1", "Lcom/discord/databinding/WidgetSettingsEnableMfaKeyBinding;", "invoke", "(Landroid/view/View;)Lcom/discord/databinding/WidgetSettingsEnableMfaKeyBinding;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.settings.account.mfa.WidgetEnableMFAKey$binding$2, reason: use source file name */
/* loaded from: classes2.dex */
public final /* synthetic */ class WidgetEnableMFAKey2 extends FunctionReferenceImpl implements Function1<View, WidgetSettingsEnableMfaKeyBinding> {
    public static final WidgetEnableMFAKey2 INSTANCE = new WidgetEnableMFAKey2();

    public WidgetEnableMFAKey2() {
        super(1, WidgetSettingsEnableMfaKeyBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetSettingsEnableMfaKeyBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetSettingsEnableMfaKeyBinding invoke(View view) {
        return invoke2(view);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetSettingsEnableMfaKeyBinding invoke2(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        int i = R.id.enable_mfa_key_code;
        TextView textView = (TextView) view.findViewById(R.id.enable_mfa_key_code);
        if (textView != null) {
            i = R.id.enable_mfa_key_launch_authy;
            TextView textView2 = (TextView) view.findViewById(R.id.enable_mfa_key_launch_authy);
            if (textView2 != null) {
                i = R.id.enable_mfa_key_launch_google_auth;
                TextView textView3 = (TextView) view.findViewById(R.id.enable_mfa_key_launch_google_auth);
                if (textView3 != null) {
                    return new WidgetSettingsEnableMfaKeyBinding((LinearLayout) view, textView, textView2, textView3);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
