package com.discord.widgets.settings.account;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.discord.R;
import com.discord.databinding.WidgetSettingsAccountChangePasswordBinding;
import com.discord.utilities.dimmer.DimmerView;
import com.discord.views.LoadingButton;
import com.discord.views.ScreenTitleView;
import com.google.android.material.textfield.TextInputLayout;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* compiled from: WidgetSettingsAccountChangePassword.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/view/View;", "p1", "Lcom/discord/databinding/WidgetSettingsAccountChangePasswordBinding;", "invoke", "(Landroid/view/View;)Lcom/discord/databinding/WidgetSettingsAccountChangePasswordBinding;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.settings.account.WidgetSettingsAccountChangePassword$binding$2, reason: use source file name */
/* loaded from: classes2.dex */
public final /* synthetic */ class WidgetSettingsAccountChangePassword2 extends FunctionReferenceImpl implements Function1<View, WidgetSettingsAccountChangePasswordBinding> {
    public static final WidgetSettingsAccountChangePassword2 INSTANCE = new WidgetSettingsAccountChangePassword2();

    public WidgetSettingsAccountChangePassword2() {
        super(1, WidgetSettingsAccountChangePasswordBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetSettingsAccountChangePasswordBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetSettingsAccountChangePasswordBinding invoke(View view) {
        return invoke2(view);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetSettingsAccountChangePasswordBinding invoke2(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        int i = R.id.auth_change_password_icon;
        ImageView imageView = (ImageView) view.findViewById(R.id.auth_change_password_icon);
        if (imageView != null) {
            i = R.id.change_password_current_password_input;
            TextInputLayout textInputLayout = (TextInputLayout) view.findViewById(R.id.change_password_current_password_input);
            if (textInputLayout != null) {
                i = R.id.change_password_new_password_input;
                TextInputLayout textInputLayout2 = (TextInputLayout) view.findViewById(R.id.change_password_new_password_input);
                if (textInputLayout2 != null) {
                    i = R.id.change_password_save;
                    LoadingButton loadingButton = (LoadingButton) view.findViewById(R.id.change_password_save);
                    if (loadingButton != null) {
                        i = R.id.change_password_title;
                        ScreenTitleView screenTitleView = (ScreenTitleView) view.findViewById(R.id.change_password_title);
                        if (screenTitleView != null) {
                            i = R.id.change_password_two_factor;
                            TextInputLayout textInputLayout3 = (TextInputLayout) view.findViewById(R.id.change_password_two_factor);
                            if (textInputLayout3 != null) {
                                i = R.id.change_password_two_factor_title;
                                TextView textView = (TextView) view.findViewById(R.id.change_password_two_factor_title);
                                if (textView != null) {
                                    i = R.id.dimmer_view;
                                    DimmerView dimmerView = (DimmerView) view.findViewById(R.id.dimmer_view);
                                    if (dimmerView != null) {
                                        return new WidgetSettingsAccountChangePasswordBinding((CoordinatorLayout) view, imageView, textInputLayout, textInputLayout2, loadingButton, screenTitleView, textInputLayout3, textView, dimmerView);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
