package com.discord.widgets.user.email;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.discord.R;
import com.discord.databinding.WidgetUserEmailUpdateBinding;
import com.discord.utilities.dimmer.DimmerView;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputLayout;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* compiled from: WidgetUserEmailUpdate.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/view/View;", "p1", "Lcom/discord/databinding/WidgetUserEmailUpdateBinding;", "invoke", "(Landroid/view/View;)Lcom/discord/databinding/WidgetUserEmailUpdateBinding;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.user.email.WidgetUserEmailUpdate$binding$2, reason: use source file name */
/* loaded from: classes.dex */
public final /* synthetic */ class WidgetUserEmailUpdate3 extends FunctionReferenceImpl implements Function1<View, WidgetUserEmailUpdateBinding> {
    public static final WidgetUserEmailUpdate3 INSTANCE = new WidgetUserEmailUpdate3();

    public WidgetUserEmailUpdate3() {
        super(1, WidgetUserEmailUpdateBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetUserEmailUpdateBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetUserEmailUpdateBinding invoke(View view) {
        return invoke2(view);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetUserEmailUpdateBinding invoke2(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        int i = R.id.alert_verify_email_anchor;
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.alert_verify_email_anchor);
        if (linearLayout != null) {
            i = R.id.alert_verify_email_change;
            MaterialButton materialButton = (MaterialButton) view.findViewById(R.id.alert_verify_email_change);
            if (materialButton != null) {
                i = R.id.alert_verify_email_change_email;
                TextInputLayout textInputLayout = (TextInputLayout) view.findViewById(R.id.alert_verify_email_change_email);
                if (textInputLayout != null) {
                    i = R.id.alert_verify_email_change_password;
                    TextInputLayout textInputLayout2 = (TextInputLayout) view.findViewById(R.id.alert_verify_email_change_password);
                    if (textInputLayout2 != null) {
                        i = R.id.dimmer_view;
                        DimmerView dimmerView = (DimmerView) view.findViewById(R.id.dimmer_view);
                        if (dimmerView != null) {
                            return new WidgetUserEmailUpdateBinding((RelativeLayout) view, linearLayout, materialButton, textInputLayout, textInputLayout2, dimmerView);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
