package com.discord.widgets.servers.guild_role_subscription;

import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentContainerView;
import com.discord.R;
import com.discord.app.AppViewFlipper;
import com.discord.databinding.WidgetServerSettingsGuildRoleSubscriptionsBinding;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* compiled from: WidgetServerSettingsGuildRoleSubscriptions.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/view/View;", "p1", "Lcom/discord/databinding/WidgetServerSettingsGuildRoleSubscriptionsBinding;", "invoke", "(Landroid/view/View;)Lcom/discord/databinding/WidgetServerSettingsGuildRoleSubscriptionsBinding;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.servers.guild_role_subscription.WidgetServerSettingsGuildRoleSubscriptions$binding$2, reason: use source file name */
/* loaded from: classes2.dex */
public final /* synthetic */ class WidgetServerSettingsGuildRoleSubscriptions2 extends FunctionReferenceImpl implements Function1<View, WidgetServerSettingsGuildRoleSubscriptionsBinding> {
    public static final WidgetServerSettingsGuildRoleSubscriptions2 INSTANCE = new WidgetServerSettingsGuildRoleSubscriptions2();

    public WidgetServerSettingsGuildRoleSubscriptions2() {
        super(1, WidgetServerSettingsGuildRoleSubscriptionsBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetServerSettingsGuildRoleSubscriptionsBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetServerSettingsGuildRoleSubscriptionsBinding invoke(View view) {
        return invoke2(view);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetServerSettingsGuildRoleSubscriptionsBinding invoke2(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        int i = R.id.guild_role_subscription_plan_details;
        FragmentContainerView fragmentContainerView = (FragmentContainerView) view.findViewById(R.id.guild_role_subscription_plan_details);
        if (fragmentContainerView != null) {
            i = R.id.guild_role_subscription_plan_format;
            FragmentContainerView fragmentContainerView2 = (FragmentContainerView) view.findViewById(R.id.guild_role_subscription_plan_format);
            if (fragmentContainerView2 != null) {
                i = R.id.guild_role_subscriptions_app_bar_layout;
                AppBarLayout appBarLayout = (AppBarLayout) view.findViewById(R.id.guild_role_subscriptions_app_bar_layout);
                if (appBarLayout != null) {
                    i = R.id.server_settings_guild_role_subscription_save;
                    FloatingActionButton floatingActionButton = (FloatingActionButton) view.findViewById(R.id.server_settings_guild_role_subscription_save);
                    if (floatingActionButton != null) {
                        i = R.id.server_settings_guild_role_subscription_view_flipper;
                        AppViewFlipper appViewFlipper = (AppViewFlipper) view.findViewById(R.id.server_settings_guild_role_subscription_view_flipper);
                        if (appViewFlipper != null) {
                            return new WidgetServerSettingsGuildRoleSubscriptionsBinding((ConstraintLayout) view, fragmentContainerView, fragmentContainerView2, appBarLayout, floatingActionButton, appViewFlipper);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
