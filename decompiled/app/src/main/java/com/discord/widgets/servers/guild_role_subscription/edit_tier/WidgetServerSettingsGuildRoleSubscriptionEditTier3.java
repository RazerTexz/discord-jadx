package com.discord.widgets.servers.guild_role_subscription.edit_tier;

import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.Barrier;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.viewpager2.widget.ViewPager2;
import com.discord.R;
import com.discord.app.AppViewFlipper;
import com.discord.databinding.WidgetServerSettingsGuildRoleSubscriptionEditTierBinding;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* compiled from: WidgetServerSettingsGuildRoleSubscriptionEditTier.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/view/View;", "p1", "Lcom/discord/databinding/WidgetServerSettingsGuildRoleSubscriptionEditTierBinding;", "invoke", "(Landroid/view/View;)Lcom/discord/databinding/WidgetServerSettingsGuildRoleSubscriptionEditTierBinding;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.servers.guild_role_subscription.edit_tier.WidgetServerSettingsGuildRoleSubscriptionEditTier$binding$2, reason: use source file name */
/* loaded from: classes2.dex */
public final /* synthetic */ class WidgetServerSettingsGuildRoleSubscriptionEditTier3 extends FunctionReferenceImpl implements Function1<View, WidgetServerSettingsGuildRoleSubscriptionEditTierBinding> {
    public static final WidgetServerSettingsGuildRoleSubscriptionEditTier3 INSTANCE = new WidgetServerSettingsGuildRoleSubscriptionEditTier3();

    public WidgetServerSettingsGuildRoleSubscriptionEditTier3() {
        super(1, WidgetServerSettingsGuildRoleSubscriptionEditTierBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetServerSettingsGuildRoleSubscriptionEditTierBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetServerSettingsGuildRoleSubscriptionEditTierBinding invoke(View view) {
        return invoke2(view);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetServerSettingsGuildRoleSubscriptionEditTierBinding invoke2(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        int i = R.id.guild_role_subscription_edit_tier_publish;
        MaterialButton materialButton = (MaterialButton) view.findViewById(R.id.guild_role_subscription_edit_tier_publish);
        if (materialButton != null) {
            i = R.id.guild_role_subscription_edit_tier_publish_description;
            TextView textView = (TextView) view.findViewById(R.id.guild_role_subscription_edit_tier_publish_description);
            if (textView != null) {
                i = R.id.guild_role_subscription_edit_tier_publish_group;
                Group group = (Group) view.findViewById(R.id.guild_role_subscription_edit_tier_publish_group);
                if (group != null) {
                    i = R.id.guild_role_subscription_edit_tier_tabs;
                    TabLayout tabLayout = (TabLayout) view.findViewById(R.id.guild_role_subscription_edit_tier_tabs);
                    if (tabLayout != null) {
                        i = R.id.guild_role_subscription_edit_tier_view_pager;
                        ViewPager2 viewPager2 = (ViewPager2) view.findViewById(R.id.guild_role_subscription_edit_tier_view_pager);
                        if (viewPager2 != null) {
                            i = R.id.guild_role_subscription_edit_tier_view_pager_top_barrier;
                            Barrier barrier = (Barrier) view.findViewById(R.id.guild_role_subscription_edit_tier_view_pager_top_barrier);
                            if (barrier != null) {
                                i = R.id.server_settings_guild_role_subscription_edit_tier_app_bar;
                                AppBarLayout appBarLayout = (AppBarLayout) view.findViewById(R.id.server_settings_guild_role_subscription_edit_tier_app_bar);
                                if (appBarLayout != null) {
                                    i = R.id.server_settings_guild_role_subscription_edit_tier_delete;
                                    MaterialButton materialButton2 = (MaterialButton) view.findViewById(R.id.server_settings_guild_role_subscription_edit_tier_delete);
                                    if (materialButton2 != null) {
                                        i = R.id.server_settings_guild_role_subscription_edit_tier_save;
                                        FloatingActionButton floatingActionButton = (FloatingActionButton) view.findViewById(R.id.server_settings_guild_role_subscription_edit_tier_save);
                                        if (floatingActionButton != null) {
                                            i = R.id.server_settings_guild_role_subscription_edit_tier_view_flipper;
                                            AppViewFlipper appViewFlipper = (AppViewFlipper) view.findViewById(R.id.server_settings_guild_role_subscription_edit_tier_view_flipper);
                                            if (appViewFlipper != null) {
                                                return new WidgetServerSettingsGuildRoleSubscriptionEditTierBinding((ConstraintLayout) view, materialButton, textView, group, tabLayout, viewPager2, barrier, appBarLayout, materialButton2, floatingActionButton, appViewFlipper);
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
