package com.discord.widgets.settings.account;

import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.discord.R;
import com.discord.databinding.WidgetSettingsAccountEditBinding;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputLayout;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* compiled from: WidgetSettingsAccountUsernameEdit.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/view/View;", "p1", "Lcom/discord/databinding/WidgetSettingsAccountEditBinding;", "invoke", "(Landroid/view/View;)Lcom/discord/databinding/WidgetSettingsAccountEditBinding;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.settings.account.WidgetSettingsAccountUsernameEdit$binding$2, reason: use source file name */
/* loaded from: classes2.dex */
public final /* synthetic */ class WidgetSettingsAccountUsernameEdit2 extends FunctionReferenceImpl implements Function1<View, WidgetSettingsAccountEditBinding> {
    public static final WidgetSettingsAccountUsernameEdit2 INSTANCE = new WidgetSettingsAccountUsernameEdit2();

    public WidgetSettingsAccountUsernameEdit2() {
        super(1, WidgetSettingsAccountEditBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetSettingsAccountEditBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetSettingsAccountEditBinding invoke(View view) {
        return invoke2(view);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetSettingsAccountEditBinding invoke2(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        int i = R.id.dtddd;
        TextView textView = (TextView) view.findViewById(R.id.dtddd);
        if (textView != null) {
            i = R.id.edit_account_discriminator_wrap;
            TextInputLayout textInputLayout = (TextInputLayout) view.findViewById(R.id.edit_account_discriminator_wrap);
            if (textInputLayout != null) {
                i = R.id.edit_account_tag_layout_container;
                RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.edit_account_tag_layout_container);
                if (relativeLayout != null) {
                    i = R.id.edit_account_username_wrap;
                    TextInputLayout textInputLayout2 = (TextInputLayout) view.findViewById(R.id.edit_account_username_wrap);
                    if (textInputLayout2 != null) {
                        i = R.id.settings_account_save;
                        FloatingActionButton floatingActionButton = (FloatingActionButton) view.findViewById(R.id.settings_account_save);
                        if (floatingActionButton != null) {
                            return new WidgetSettingsAccountEditBinding((CoordinatorLayout) view, textView, textInputLayout, relativeLayout, textInputLayout2, floatingActionButton);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
