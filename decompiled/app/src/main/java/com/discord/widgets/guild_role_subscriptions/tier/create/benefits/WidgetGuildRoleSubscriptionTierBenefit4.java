package com.discord.widgets.guild_role_subscriptions.tier.create.benefits;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.discord.R;
import com.discord.databinding.WidgetGuildRoleSubscriptionTierBenefitBinding;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* compiled from: WidgetGuildRoleSubscriptionTierBenefit.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/view/View;", "p1", "Lcom/discord/databinding/WidgetGuildRoleSubscriptionTierBenefitBinding;", "invoke", "(Landroid/view/View;)Lcom/discord/databinding/WidgetGuildRoleSubscriptionTierBenefitBinding;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.guild_role_subscriptions.tier.create.benefits.WidgetGuildRoleSubscriptionTierBenefit$binding$2, reason: use source file name */
/* loaded from: classes2.dex */
public final /* synthetic */ class WidgetGuildRoleSubscriptionTierBenefit4 extends FunctionReferenceImpl implements Function1<View, WidgetGuildRoleSubscriptionTierBenefitBinding> {
    public static final WidgetGuildRoleSubscriptionTierBenefit4 INSTANCE = new WidgetGuildRoleSubscriptionTierBenefit4();

    public WidgetGuildRoleSubscriptionTierBenefit4() {
        super(1, WidgetGuildRoleSubscriptionTierBenefitBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetGuildRoleSubscriptionTierBenefitBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetGuildRoleSubscriptionTierBenefitBinding invoke(View view) {
        return invoke2(view);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetGuildRoleSubscriptionTierBenefitBinding invoke2(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        int i = R.id.guild_role_subscription_benefit_channel_label;
        TextView textView = (TextView) view.findViewById(R.id.guild_role_subscription_benefit_channel_label);
        if (textView != null) {
            i = R.id.guild_role_subscription_intangible_benefit_name;
            TextInputEditText textInputEditText = (TextInputEditText) view.findViewById(R.id.guild_role_subscription_intangible_benefit_name);
            if (textInputEditText != null) {
                i = R.id.guild_role_subscription_intangible_benefit_name_label;
                TextView textView2 = (TextView) view.findViewById(R.id.guild_role_subscription_intangible_benefit_name_label);
                if (textView2 != null) {
                    i = R.id.guild_role_subscription_intangible_benefit_name_layout;
                    TextInputLayout textInputLayout = (TextInputLayout) view.findViewById(R.id.guild_role_subscription_intangible_benefit_name_layout);
                    if (textInputLayout != null) {
                        i = R.id.guild_role_subscription_tier_benefit_app_bar_layout;
                        AppBarLayout appBarLayout = (AppBarLayout) view.findViewById(R.id.guild_role_subscription_tier_benefit_app_bar_layout);
                        if (appBarLayout != null) {
                            i = R.id.guild_role_subscription_tier_benefit_cancel;
                            MaterialButton materialButton = (MaterialButton) view.findViewById(R.id.guild_role_subscription_tier_benefit_cancel);
                            if (materialButton != null) {
                                i = R.id.guild_role_subscription_tier_benefit_description;
                                TextInputLayout textInputLayout2 = (TextInputLayout) view.findViewById(R.id.guild_role_subscription_tier_benefit_description);
                                if (textInputLayout2 != null) {
                                    i = R.id.guild_role_subscription_tier_benefit_description_edit_text;
                                    TextInputEditText textInputEditText2 = (TextInputEditText) view.findViewById(R.id.guild_role_subscription_tier_benefit_description_edit_text);
                                    if (textInputEditText2 != null) {
                                        i = R.id.guild_role_subscription_tier_benefit_emoji;
                                        SimpleDraweeView simpleDraweeView = (SimpleDraweeView) view.findViewById(R.id.guild_role_subscription_tier_benefit_emoji);
                                        if (simpleDraweeView != null) {
                                            i = R.id.guild_role_subscription_tier_benefit_emoji_name;
                                            TextView textView3 = (TextView) view.findViewById(R.id.guild_role_subscription_tier_benefit_emoji_name);
                                            if (textView3 != null) {
                                                i = R.id.guild_role_subscription_tier_benefit_name;
                                                TextView textView4 = (TextView) view.findViewById(R.id.guild_role_subscription_tier_benefit_name);
                                                if (textView4 != null) {
                                                    i = R.id.guild_role_subscription_tier_benefit_remove;
                                                    MaterialButton materialButton2 = (MaterialButton) view.findViewById(R.id.guild_role_subscription_tier_benefit_remove);
                                                    if (materialButton2 != null) {
                                                        i = R.id.guild_role_subscription_tier_benefit_save;
                                                        MaterialButton materialButton3 = (MaterialButton) view.findViewById(R.id.guild_role_subscription_tier_benefit_save);
                                                        if (materialButton3 != null) {
                                                            i = R.id.guild_role_subscription_tier_benefit_scroll_view;
                                                            ScrollView scrollView = (ScrollView) view.findViewById(R.id.guild_role_subscription_tier_benefit_scroll_view);
                                                            if (scrollView != null) {
                                                                i = R.id.guild_role_subscription_tier_benefit_select_emoji;
                                                                LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.guild_role_subscription_tier_benefit_select_emoji);
                                                                if (linearLayout != null) {
                                                                    i = R.id.guild_role_subscription_tier_benefit_subtitle;
                                                                    TextView textView5 = (TextView) view.findViewById(R.id.guild_role_subscription_tier_benefit_subtitle);
                                                                    if (textView5 != null) {
                                                                        i = R.id.guild_role_subscription_tier_benefit_title;
                                                                        TextView textView6 = (TextView) view.findViewById(R.id.guild_role_subscription_tier_benefit_title);
                                                                        if (textView6 != null) {
                                                                            i = R.id.guild_role_subscription_tier_channel_benefit_warning;
                                                                            TextView textView7 = (TextView) view.findViewById(R.id.guild_role_subscription_tier_channel_benefit_warning);
                                                                            if (textView7 != null) {
                                                                                return new WidgetGuildRoleSubscriptionTierBenefitBinding((ConstraintLayout) view, textView, textInputEditText, textView2, textInputLayout, appBarLayout, materialButton, textInputLayout2, textInputEditText2, simpleDraweeView, textView3, textView4, materialButton2, materialButton3, scrollView, linearLayout, textView5, textView6, textView7);
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
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
