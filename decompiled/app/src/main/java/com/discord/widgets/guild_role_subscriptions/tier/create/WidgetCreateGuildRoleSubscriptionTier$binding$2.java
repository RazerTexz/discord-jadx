package com.discord.widgets.guild_role_subscriptions.tier.create;

import android.view.View;
import com.discord.databinding.WidgetCreateGuildRoleSubscriptionTierBinding;
import com.discord.views.steps.StepsView;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* compiled from: WidgetCreateGuildRoleSubscriptionTier.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/view/View;", "p1", "Lcom/discord/databinding/WidgetCreateGuildRoleSubscriptionTierBinding;", "invoke", "(Landroid/view/View;)Lcom/discord/databinding/WidgetCreateGuildRoleSubscriptionTierBinding;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final /* synthetic */ class WidgetCreateGuildRoleSubscriptionTier$binding$2 extends FunctionReferenceImpl implements Function1<View, WidgetCreateGuildRoleSubscriptionTierBinding> {
    public static final WidgetCreateGuildRoleSubscriptionTier$binding$2 INSTANCE = new WidgetCreateGuildRoleSubscriptionTier$binding$2();

    public WidgetCreateGuildRoleSubscriptionTier$binding$2() {
        super(1, WidgetCreateGuildRoleSubscriptionTierBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetCreateGuildRoleSubscriptionTierBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetCreateGuildRoleSubscriptionTierBinding invoke(View view) {
        return invoke2(view);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetCreateGuildRoleSubscriptionTierBinding invoke2(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        Objects.requireNonNull(view, "rootView");
        StepsView stepsView = (StepsView) view;
        return new WidgetCreateGuildRoleSubscriptionTierBinding(stepsView, stepsView);
    }
}
