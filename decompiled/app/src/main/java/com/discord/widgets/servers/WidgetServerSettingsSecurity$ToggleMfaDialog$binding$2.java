package com.discord.widgets.servers;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.discord.R;
import com.discord.databinding.WidgetServerSettingsSecurityDialogBinding;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputLayout;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* compiled from: WidgetServerSettingsSecurity.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/view/View;", "p1", "Lcom/discord/databinding/WidgetServerSettingsSecurityDialogBinding;", "invoke", "(Landroid/view/View;)Lcom/discord/databinding/WidgetServerSettingsSecurityDialogBinding;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final /* synthetic */ class WidgetServerSettingsSecurity$ToggleMfaDialog$binding$2 extends FunctionReferenceImpl implements Function1<View, WidgetServerSettingsSecurityDialogBinding> {
    public static final WidgetServerSettingsSecurity$ToggleMfaDialog$binding$2 INSTANCE = new WidgetServerSettingsSecurity$ToggleMfaDialog$binding$2();

    public WidgetServerSettingsSecurity$ToggleMfaDialog$binding$2() {
        super(1, WidgetServerSettingsSecurityDialogBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetServerSettingsSecurityDialogBinding;", 0);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetServerSettingsSecurityDialogBinding invoke2(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        int i = R.id.notice_header;
        TextView textView = (TextView) view.findViewById(R.id.notice_header);
        if (textView != null) {
            i = R.id.server_settings_security_dialog_cancel;
            MaterialButton materialButton = (MaterialButton) view.findViewById(R.id.server_settings_security_dialog_cancel);
            if (materialButton != null) {
                i = R.id.server_settings_security_dialog_confirm;
                MaterialButton materialButton2 = (MaterialButton) view.findViewById(R.id.server_settings_security_dialog_confirm);
                if (materialButton2 != null) {
                    i = R.id.server_settings_security_server_mfa_code;
                    TextInputLayout textInputLayout = (TextInputLayout) view.findViewById(R.id.server_settings_security_server_mfa_code);
                    if (textInputLayout != null) {
                        return new WidgetServerSettingsSecurityDialogBinding((LinearLayout) view, textView, materialButton, materialButton2, textInputLayout);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetServerSettingsSecurityDialogBinding invoke(View view) {
        return invoke2(view);
    }
}
