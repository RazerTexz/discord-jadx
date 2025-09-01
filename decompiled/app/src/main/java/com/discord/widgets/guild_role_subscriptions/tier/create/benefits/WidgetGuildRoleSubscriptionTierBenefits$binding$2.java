package com.discord.widgets.guild_role_subscriptions.tier.create.benefits;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.R;
import com.discord.databinding.WidgetGuildRoleSubscriptionTierBenefitsBinding;
import com.google.android.material.radiobutton.MaterialRadioButton;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* compiled from: WidgetGuildRoleSubscriptionTierBenefits.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/view/View;", "p1", "Lcom/discord/databinding/WidgetGuildRoleSubscriptionTierBenefitsBinding;", "invoke", "(Landroid/view/View;)Lcom/discord/databinding/WidgetGuildRoleSubscriptionTierBenefitsBinding;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final /* synthetic */ class WidgetGuildRoleSubscriptionTierBenefits$binding$2 extends FunctionReferenceImpl implements Function1<View, WidgetGuildRoleSubscriptionTierBenefitsBinding> {
    public static final WidgetGuildRoleSubscriptionTierBenefits$binding$2 INSTANCE = new WidgetGuildRoleSubscriptionTierBenefits$binding$2();

    public WidgetGuildRoleSubscriptionTierBenefits$binding$2() {
        super(1, WidgetGuildRoleSubscriptionTierBenefitsBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetGuildRoleSubscriptionTierBenefitsBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetGuildRoleSubscriptionTierBenefitsBinding invoke(View view) {
        return invoke2(view);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetGuildRoleSubscriptionTierBenefitsBinding invoke2(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        int i = R.id.guild_role_subscription_tier_all_channels;
        MaterialRadioButton materialRadioButton = (MaterialRadioButton) view.findViewById(R.id.guild_role_subscription_tier_all_channels);
        if (materialRadioButton != null) {
            i = R.id.guild_role_subscription_tier_benefits_divider;
            View viewFindViewById = view.findViewById(R.id.guild_role_subscription_tier_benefits_divider);
            if (viewFindViewById != null) {
                i = R.id.guild_role_subscription_tier_benefits_sub_title;
                TextView textView = (TextView) view.findViewById(R.id.guild_role_subscription_tier_benefits_sub_title);
                if (textView != null) {
                    i = R.id.guild_role_subscription_tier_benefits_title;
                    TextView textView2 = (TextView) view.findViewById(R.id.guild_role_subscription_tier_benefits_title);
                    if (textView2 != null) {
                        i = R.id.guild_role_subscription_tier_channel_benefit_setting;
                        RadioGroup radioGroup = (RadioGroup) view.findViewById(R.id.guild_role_subscription_tier_channel_benefit_setting);
                        if (radioGroup != null) {
                            i = R.id.guild_role_subscription_tier_manual_channels;
                            MaterialRadioButton materialRadioButton2 = (MaterialRadioButton) view.findViewById(R.id.guild_role_subscription_tier_manual_channels);
                            if (materialRadioButton2 != null) {
                                i = R.id.subscription_tier_benefits_recycler;
                                RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.subscription_tier_benefits_recycler);
                                if (recyclerView != null) {
                                    return new WidgetGuildRoleSubscriptionTierBenefitsBinding((LinearLayout) view, materialRadioButton, viewFindViewById, textView, textView2, radioGroup, materialRadioButton2, recyclerView);
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
