package com.discord.widgets.guild_role_subscriptions.tier.create;

import android.view.View;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.discord.R;
import com.discord.databinding.WidgetGuildRoleSubscriptionDetailsBinding;
import com.discord.widgets.guild_role_subscriptions.GuildSubscriptionRoleImageUploadView;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* compiled from: WidgetGuildRoleSubscriptionTierDetails.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/view/View;", "p1", "Lcom/discord/databinding/WidgetGuildRoleSubscriptionDetailsBinding;", "invoke", "(Landroid/view/View;)Lcom/discord/databinding/WidgetGuildRoleSubscriptionDetailsBinding;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.guild_role_subscriptions.tier.create.WidgetGuildRoleSubscriptionTierDetails$binding$2, reason: use source file name */
/* loaded from: classes2.dex */
public final /* synthetic */ class WidgetGuildRoleSubscriptionTierDetails2 extends FunctionReferenceImpl implements Function1<View, WidgetGuildRoleSubscriptionDetailsBinding> {
    public static final WidgetGuildRoleSubscriptionTierDetails2 INSTANCE = new WidgetGuildRoleSubscriptionTierDetails2();

    public WidgetGuildRoleSubscriptionTierDetails2() {
        super(1, WidgetGuildRoleSubscriptionDetailsBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetGuildRoleSubscriptionDetailsBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetGuildRoleSubscriptionDetailsBinding invoke(View view) {
        return invoke2(view);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetGuildRoleSubscriptionDetailsBinding invoke2(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        int i = R.id.create_subscription_tier_description;
        TextInputEditText textInputEditText = (TextInputEditText) view.findViewById(R.id.create_subscription_tier_description);
        if (textInputEditText != null) {
            i = R.id.create_subscription_tier_description_layout;
            TextInputLayout textInputLayout = (TextInputLayout) view.findViewById(R.id.create_subscription_tier_description_layout);
            if (textInputLayout != null) {
                i = R.id.create_subscription_tier_details_layout;
                ScrollView scrollView = (ScrollView) view.findViewById(R.id.create_subscription_tier_details_layout);
                if (scrollView != null) {
                    i = R.id.create_subscription_tier_image_upload_view;
                    GuildSubscriptionRoleImageUploadView guildSubscriptionRoleImageUploadView = (GuildSubscriptionRoleImageUploadView) view.findViewById(R.id.create_subscription_tier_image_upload_view);
                    if (guildSubscriptionRoleImageUploadView != null) {
                        i = R.id.create_subscription_tier_name;
                        TextInputEditText textInputEditText2 = (TextInputEditText) view.findViewById(R.id.create_subscription_tier_name);
                        if (textInputEditText2 != null) {
                            i = R.id.create_subscription_tier_name_layout;
                            TextInputLayout textInputLayout2 = (TextInputLayout) view.findViewById(R.id.create_subscription_tier_name_layout);
                            if (textInputLayout2 != null) {
                                i = R.id.create_subscription_tier_price;
                                TextView textView = (TextView) view.findViewById(R.id.create_subscription_tier_price);
                                if (textView != null) {
                                    i = R.id.create_subscription_tier_subtitle;
                                    TextView textView2 = (TextView) view.findViewById(R.id.create_subscription_tier_subtitle);
                                    if (textView2 != null) {
                                        i = R.id.create_subscription_tier_title;
                                        TextView textView3 = (TextView) view.findViewById(R.id.create_subscription_tier_title);
                                        if (textView3 != null) {
                                            i = R.id.guild_role_subscription_tier_detail_divider;
                                            View viewFindViewById = view.findViewById(R.id.guild_role_subscription_tier_detail_divider);
                                            if (viewFindViewById != null) {
                                                return new WidgetGuildRoleSubscriptionDetailsBinding((ConstraintLayout) view, textInputEditText, textInputLayout, scrollView, guildSubscriptionRoleImageUploadView, textInputEditText2, textInputLayout2, textView, textView2, textView3, viewFindViewById);
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
