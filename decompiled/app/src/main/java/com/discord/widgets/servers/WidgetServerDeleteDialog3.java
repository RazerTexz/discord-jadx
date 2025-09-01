package com.discord.widgets.servers;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.discord.R;
import com.discord.databinding.WidgetServerDeleteDialogBinding;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputLayout;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* compiled from: WidgetServerDeleteDialog.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/view/View;", "p1", "Lcom/discord/databinding/WidgetServerDeleteDialogBinding;", "invoke", "(Landroid/view/View;)Lcom/discord/databinding/WidgetServerDeleteDialogBinding;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.servers.WidgetServerDeleteDialog$binding$2, reason: use source file name */
/* loaded from: classes2.dex */
public final /* synthetic */ class WidgetServerDeleteDialog3 extends FunctionReferenceImpl implements Function1<View, WidgetServerDeleteDialogBinding> {
    public static final WidgetServerDeleteDialog3 INSTANCE = new WidgetServerDeleteDialog3();

    public WidgetServerDeleteDialog3() {
        super(1, WidgetServerDeleteDialogBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetServerDeleteDialogBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetServerDeleteDialogBinding invoke(View view) {
        return invoke2(view);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetServerDeleteDialogBinding invoke2(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        int i = R.id.server_settings_delete_server_cancel;
        MaterialButton materialButton = (MaterialButton) view.findViewById(R.id.server_settings_delete_server_cancel);
        if (materialButton != null) {
            i = R.id.server_settings_delete_server_confirm;
            MaterialButton materialButton2 = (MaterialButton) view.findViewById(R.id.server_settings_delete_server_confirm);
            if (materialButton2 != null) {
                i = R.id.server_settings_delete_server_header;
                TextView textView = (TextView) view.findViewById(R.id.server_settings_delete_server_header);
                if (textView != null) {
                    i = R.id.server_settings_delete_server_mfa_code;
                    TextInputLayout textInputLayout = (TextInputLayout) view.findViewById(R.id.server_settings_delete_server_mfa_code);
                    if (textInputLayout != null) {
                        i = R.id.server_settings_delete_server_mfa_wrap;
                        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.server_settings_delete_server_mfa_wrap);
                        if (linearLayout != null) {
                            i = R.id.server_settings_delete_server_text;
                            TextView textView2 = (TextView) view.findViewById(R.id.server_settings_delete_server_text);
                            if (textView2 != null) {
                                return new WidgetServerDeleteDialogBinding((LinearLayout) view, materialButton, materialButton2, textView, textInputLayout, linearLayout, textView2);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
