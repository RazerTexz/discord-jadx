package com.discord.widgets.servers.guild_role_subscription;

import android.view.View;
import android.widget.Button;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.discord.R;
import com.discord.app.AppViewFlipper;
import com.discord.databinding.WidgetServerSettingsEmptyGuildRoleSubscriptionBinding;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* compiled from: WidgetServerSettingsEmptyGuildRoleSubscriptions.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/view/View;", "p1", "Lcom/discord/databinding/WidgetServerSettingsEmptyGuildRoleSubscriptionBinding;", "invoke", "(Landroid/view/View;)Lcom/discord/databinding/WidgetServerSettingsEmptyGuildRoleSubscriptionBinding;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.servers.guild_role_subscription.WidgetServerSettingsEmptyGuildRoleSubscriptions$binding$2, reason: use source file name */
/* loaded from: classes2.dex */
public final /* synthetic */ class WidgetServerSettingsEmptyGuildRoleSubscriptions4 extends FunctionReferenceImpl implements Function1<View, WidgetServerSettingsEmptyGuildRoleSubscriptionBinding> {
    public static final WidgetServerSettingsEmptyGuildRoleSubscriptions4 INSTANCE = new WidgetServerSettingsEmptyGuildRoleSubscriptions4();

    public WidgetServerSettingsEmptyGuildRoleSubscriptions4() {
        super(1, WidgetServerSettingsEmptyGuildRoleSubscriptionBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetServerSettingsEmptyGuildRoleSubscriptionBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetServerSettingsEmptyGuildRoleSubscriptionBinding invoke(View view) {
        return invoke2(view);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetServerSettingsEmptyGuildRoleSubscriptionBinding invoke2(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        int i = R.id.empty_guild_role_subscription_cta;
        Button button = (Button) view.findViewById(R.id.empty_guild_role_subscription_cta);
        if (button != null) {
            i = R.id.server_settings_empty_guild_role_subscriptions_view_flipper;
            AppViewFlipper appViewFlipper = (AppViewFlipper) view.findViewById(R.id.server_settings_empty_guild_role_subscriptions_view_flipper);
            if (appViewFlipper != null) {
                return new WidgetServerSettingsEmptyGuildRoleSubscriptionBinding((CoordinatorLayout) view, button, appViewFlipper);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
