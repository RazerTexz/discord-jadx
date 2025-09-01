package com.discord.widgets.servers.guild_role_subscription;

import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.R;
import com.discord.app.AppViewFlipper;
import com.discord.databinding.WidgetServerSettingsGuildRoleSubscriptionTierListBinding;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* compiled from: WidgetServerSettingsGuildRoleSubscriptionTierList.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/view/View;", "p1", "Lcom/discord/databinding/WidgetServerSettingsGuildRoleSubscriptionTierListBinding;", "invoke", "(Landroid/view/View;)Lcom/discord/databinding/WidgetServerSettingsGuildRoleSubscriptionTierListBinding;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.servers.guild_role_subscription.WidgetServerSettingsGuildRoleSubscriptionTierList$binding$2, reason: use source file name */
/* loaded from: classes2.dex */
public final /* synthetic */ class WidgetServerSettingsGuildRoleSubscriptionTierList2 extends FunctionReferenceImpl implements Function1<View, WidgetServerSettingsGuildRoleSubscriptionTierListBinding> {
    public static final WidgetServerSettingsGuildRoleSubscriptionTierList2 INSTANCE = new WidgetServerSettingsGuildRoleSubscriptionTierList2();

    public WidgetServerSettingsGuildRoleSubscriptionTierList2() {
        super(1, WidgetServerSettingsGuildRoleSubscriptionTierListBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetServerSettingsGuildRoleSubscriptionTierListBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetServerSettingsGuildRoleSubscriptionTierListBinding invoke(View view) {
        return invoke2(view);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetServerSettingsGuildRoleSubscriptionTierListBinding invoke2(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        int i = R.id.server_settings_guild_role_subscription_tier_list;
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.server_settings_guild_role_subscription_tier_list);
        if (recyclerView != null) {
            i = R.id.server_settings_guild_role_subscription_tier_list_view_flipper;
            AppViewFlipper appViewFlipper = (AppViewFlipper) view.findViewById(R.id.server_settings_guild_role_subscription_tier_list_view_flipper);
            if (appViewFlipper != null) {
                return new WidgetServerSettingsGuildRoleSubscriptionTierListBinding((CoordinatorLayout) view, recyclerView, appViewFlipper);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
