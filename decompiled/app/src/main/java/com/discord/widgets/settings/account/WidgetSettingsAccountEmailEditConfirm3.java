package com.discord.widgets.settings.account;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.discord.R;
import com.discord.databinding.WidgetSettingsAccountEmailEditConfirmBinding;
import com.discord.utilities.dimmer.DimmerView;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.google.android.material.textfield.TextInputLayout;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* compiled from: WidgetSettingsAccountEmailEditConfirm.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/view/View;", "p1", "Lcom/discord/databinding/WidgetSettingsAccountEmailEditConfirmBinding;", "invoke", "(Landroid/view/View;)Lcom/discord/databinding/WidgetSettingsAccountEmailEditConfirmBinding;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.settings.account.WidgetSettingsAccountEmailEditConfirm$binding$2, reason: use source file name */
/* loaded from: classes2.dex */
public final /* synthetic */ class WidgetSettingsAccountEmailEditConfirm3 extends FunctionReferenceImpl implements Function1<View, WidgetSettingsAccountEmailEditConfirmBinding> {
    public static final WidgetSettingsAccountEmailEditConfirm3 INSTANCE = new WidgetSettingsAccountEmailEditConfirm3();

    public WidgetSettingsAccountEmailEditConfirm3() {
        super(1, WidgetSettingsAccountEmailEditConfirmBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetSettingsAccountEmailEditConfirmBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetSettingsAccountEmailEditConfirmBinding invoke(View view) {
        return invoke2(view);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetSettingsAccountEmailEditConfirmBinding invoke2(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        int i = R.id.dimmer_view;
        DimmerView dimmerView = (DimmerView) view.findViewById(R.id.dimmer_view);
        if (dimmerView != null) {
            i = R.id.edit_account_code_wrap;
            TextInputLayout textInputLayout = (TextInputLayout) view.findViewById(R.id.edit_account_code_wrap);
            if (textInputLayout != null) {
                i = R.id.edit_account_email_confirm_description;
                TextView textView = (TextView) view.findViewById(R.id.edit_account_email_confirm_description);
                if (textView != null) {
                    i = R.id.settings_account_confirm_resend;
                    LinkifiedTextView linkifiedTextView = (LinkifiedTextView) view.findViewById(R.id.settings_account_confirm_resend);
                    if (linkifiedTextView != null) {
                        i = R.id.settings_account_next;
                        Button button = (Button) view.findViewById(R.id.settings_account_next);
                        if (button != null) {
                            return new WidgetSettingsAccountEmailEditConfirmBinding((CoordinatorLayout) view, dimmerView, textInputLayout, textView, linkifiedTextView, button);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
