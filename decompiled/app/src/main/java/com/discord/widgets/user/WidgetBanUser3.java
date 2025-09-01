package com.discord.widgets.user;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.discord.R;
import com.discord.databinding.WidgetBanUserBinding;
import com.discord.views.CheckedSetting;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputLayout;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* compiled from: WidgetBanUser.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/view/View;", "p1", "Lcom/discord/databinding/WidgetBanUserBinding;", "invoke", "(Landroid/view/View;)Lcom/discord/databinding/WidgetBanUserBinding;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.user.WidgetBanUser$binding$2, reason: use source file name */
/* loaded from: classes.dex */
public final /* synthetic */ class WidgetBanUser3 extends FunctionReferenceImpl implements Function1<View, WidgetBanUserBinding> {
    public static final WidgetBanUser3 INSTANCE = new WidgetBanUser3();

    public WidgetBanUser3() {
        super(1, WidgetBanUserBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetBanUserBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetBanUserBinding invoke(View view) {
        return invoke2(view);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetBanUserBinding invoke2(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        int i = R.id.ban_user_body;
        TextView textView = (TextView) view.findViewById(R.id.ban_user_body);
        if (textView != null) {
            i = R.id.ban_user_button_container;
            LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.ban_user_button_container);
            if (linearLayout != null) {
                i = R.id.ban_user_cancel;
                MaterialButton materialButton = (MaterialButton) view.findViewById(R.id.ban_user_cancel);
                if (materialButton != null) {
                    i = R.id.ban_user_confirm;
                    MaterialButton materialButton2 = (MaterialButton) view.findViewById(R.id.ban_user_confirm);
                    if (materialButton2 != null) {
                        i = R.id.ban_user_delete_messages_1_day;
                        CheckedSetting checkedSetting = (CheckedSetting) view.findViewById(R.id.ban_user_delete_messages_1_day);
                        if (checkedSetting != null) {
                            i = R.id.ban_user_delete_messages_7_days;
                            CheckedSetting checkedSetting2 = (CheckedSetting) view.findViewById(R.id.ban_user_delete_messages_7_days);
                            if (checkedSetting2 != null) {
                                i = R.id.ban_user_delete_messages_none;
                                CheckedSetting checkedSetting3 = (CheckedSetting) view.findViewById(R.id.ban_user_delete_messages_none);
                                if (checkedSetting3 != null) {
                                    i = R.id.ban_user_reason;
                                    TextInputLayout textInputLayout = (TextInputLayout) view.findViewById(R.id.ban_user_reason);
                                    if (textInputLayout != null) {
                                        i = R.id.ban_user_title;
                                        TextView textView2 = (TextView) view.findViewById(R.id.ban_user_title);
                                        if (textView2 != null) {
                                            LinearLayout linearLayout2 = (LinearLayout) view;
                                            return new WidgetBanUserBinding(linearLayout2, textView, linearLayout, materialButton, materialButton2, checkedSetting, checkedSetting2, checkedSetting3, textInputLayout, textView2, linearLayout2);
                                        }
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
