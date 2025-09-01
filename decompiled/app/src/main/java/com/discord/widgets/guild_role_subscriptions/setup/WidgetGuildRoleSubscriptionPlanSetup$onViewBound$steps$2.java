package com.discord.widgets.guild_role_subscriptions.setup;

import android.view.View;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: WidgetGuildRoleSubscriptionPlanSetup.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/view/View;", "it", "", "invoke", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class WidgetGuildRoleSubscriptionPlanSetup$onViewBound$steps$2 extends Lambda implements Function1<View, Unit> {
    public final /* synthetic */ WidgetGuildRoleSubscriptionPlanSetup this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetGuildRoleSubscriptionPlanSetup$onViewBound$steps$2(WidgetGuildRoleSubscriptionPlanSetup widgetGuildRoleSubscriptionPlanSetup) {
        super(1);
        this.this$0 = widgetGuildRoleSubscriptionPlanSetup;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(View view) {
        invoke2(view);
        return Unit.a;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(View view) {
        Intrinsics3.checkNotNullParameter(view, "it");
        WidgetGuildRoleSubscriptionPlanSetup.access$getSetupViewModel$p(this.this$0).goToNextStep();
    }
}
