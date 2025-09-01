package com.discord.widgets.guild_role_subscriptions.setup;

import android.view.View;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.constraintlayout.widget.Group;
import com.discord.R;
import com.discord.databinding.WidgetGuildRoleSubscriptionPlanDetailsBinding;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* compiled from: WidgetGuildRoleSubscriptionPlanDetails.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/view/View;", "p1", "Lcom/discord/databinding/WidgetGuildRoleSubscriptionPlanDetailsBinding;", "invoke", "(Landroid/view/View;)Lcom/discord/databinding/WidgetGuildRoleSubscriptionPlanDetailsBinding;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.guild_role_subscriptions.setup.WidgetGuildRoleSubscriptionPlanDetails$binding$2, reason: use source file name */
/* loaded from: classes2.dex */
public final /* synthetic */ class WidgetGuildRoleSubscriptionPlanDetails2 extends FunctionReferenceImpl implements Function1<View, WidgetGuildRoleSubscriptionPlanDetailsBinding> {
    public static final WidgetGuildRoleSubscriptionPlanDetails2 INSTANCE = new WidgetGuildRoleSubscriptionPlanDetails2();

    public WidgetGuildRoleSubscriptionPlanDetails2() {
        super(1, WidgetGuildRoleSubscriptionPlanDetailsBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetGuildRoleSubscriptionPlanDetailsBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetGuildRoleSubscriptionPlanDetailsBinding invoke(View view) {
        return invoke2(view);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetGuildRoleSubscriptionPlanDetailsBinding invoke2(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        int i = R.id.guild_role_subscription_plan_cover_image;
        SimpleDraweeView simpleDraweeView = (SimpleDraweeView) view.findViewById(R.id.guild_role_subscription_plan_cover_image);
        if (simpleDraweeView != null) {
            i = R.id.guild_role_subscription_plan_cover_image_info;
            TextView textView = (TextView) view.findViewById(R.id.guild_role_subscription_plan_cover_image_info);
            if (textView != null) {
                i = R.id.guild_role_subscription_plan_cover_image_label;
                TextView textView2 = (TextView) view.findViewById(R.id.guild_role_subscription_plan_cover_image_label);
                if (textView2 != null) {
                    i = R.id.guild_role_subscription_plan_description;
                    TextInputEditText textInputEditText = (TextInputEditText) view.findViewById(R.id.guild_role_subscription_plan_description);
                    if (textInputEditText != null) {
                        i = R.id.guild_role_subscription_plan_description_label;
                        TextView textView3 = (TextView) view.findViewById(R.id.guild_role_subscription_plan_description_label);
                        if (textView3 != null) {
                            i = R.id.guild_role_subscription_plan_description_layout;
                            TextInputLayout textInputLayout = (TextInputLayout) view.findViewById(R.id.guild_role_subscription_plan_description_layout);
                            if (textInputLayout != null) {
                                i = R.id.guild_role_subscription_plan_details_divider;
                                View viewFindViewById = view.findViewById(R.id.guild_role_subscription_plan_details_divider);
                                if (viewFindViewById != null) {
                                    i = R.id.guild_role_subscription_plan_details_header_group;
                                    Group group = (Group) view.findViewById(R.id.guild_role_subscription_plan_details_header_group);
                                    if (group != null) {
                                        i = R.id.guild_role_subscription_plan_details_subtitle;
                                        TextView textView4 = (TextView) view.findViewById(R.id.guild_role_subscription_plan_details_subtitle);
                                        if (textView4 != null) {
                                            i = R.id.guild_role_subscription_plan_details_title;
                                            TextView textView5 = (TextView) view.findViewById(R.id.guild_role_subscription_plan_details_title);
                                            if (textView5 != null) {
                                                i = R.id.guild_subscription_plan_details_edit_cover_image;
                                                ImageView imageView = (ImageView) view.findViewById(R.id.guild_subscription_plan_details_edit_cover_image);
                                                if (imageView != null) {
                                                    ScrollView scrollView = (ScrollView) view;
                                                    return new WidgetGuildRoleSubscriptionPlanDetailsBinding(scrollView, simpleDraweeView, textView, textView2, textInputEditText, textView3, textInputLayout, viewFindViewById, group, textView4, textView5, imageView, scrollView);
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
