package com.discord.widgets.guild_role_subscriptions.tier.create;

import d0.z.d.Lambda;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* compiled from: WidgetCreateGuildRoleSubscriptionTier.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0004\u0010\u0004\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002¨\u0006\u0003"}, d2 = {"", "invoke", "()V", "com/discord/widgets/guild_role_subscriptions/tier/create/WidgetCreateGuildRoleSubscriptionTier$onViewBound$1$1", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class WidgetCreateGuildRoleSubscriptionTier$onViewBound$$inlined$apply$lambda$1 extends Lambda implements Function0<Unit> {
    public final /* synthetic */ List $steps$inlined;
    public final /* synthetic */ WidgetCreateGuildRoleSubscriptionTier this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetCreateGuildRoleSubscriptionTier$onViewBound$$inlined$apply$lambda$1(WidgetCreateGuildRoleSubscriptionTier widgetCreateGuildRoleSubscriptionTier, List list) {
        super(0);
        this.this$0 = widgetCreateGuildRoleSubscriptionTier;
        this.$steps$inlined = list;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        this.this$0.requireActivity().finish();
    }
}
