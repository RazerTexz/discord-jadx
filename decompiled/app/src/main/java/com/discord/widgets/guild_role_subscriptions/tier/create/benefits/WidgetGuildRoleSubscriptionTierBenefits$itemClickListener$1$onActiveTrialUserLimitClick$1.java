package com.discord.widgets.guild_role_subscriptions.tier.create.benefits;

import com.discord.widgets.guild_role_subscriptions.tier.create.benefits.GuildRoleSubscriptionTierBenefitsViewModel;
import com.discord.widgets.hubs.WidgetRadioSelectorBottomSheet2;
import d0.t.Collections2;
import d0.t.Iterables2;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* compiled from: WidgetGuildRoleSubscriptionTierBenefits.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/discord/widgets/guild_role_subscriptions/tier/create/benefits/GuildRoleSubscriptionTierBenefitsViewModel$ViewState;", "it", "", "Lcom/discord/widgets/hubs/RadioSelectorItem;", "invoke", "(Lcom/discord/widgets/guild_role_subscriptions/tier/create/benefits/GuildRoleSubscriptionTierBenefitsViewModel$ViewState;)Ljava/util/List;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class WidgetGuildRoleSubscriptionTierBenefits$itemClickListener$1$onActiveTrialUserLimitClick$1 extends Lambda implements Function1<GuildRoleSubscriptionTierBenefitsViewModel.ViewState, List<? extends WidgetRadioSelectorBottomSheet2>> {
    public final /* synthetic */ WidgetGuildRoleSubscriptionTierBenefits$itemClickListener$1 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetGuildRoleSubscriptionTierBenefits$itemClickListener$1$onActiveTrialUserLimitClick$1(WidgetGuildRoleSubscriptionTierBenefits$itemClickListener$1 widgetGuildRoleSubscriptionTierBenefits$itemClickListener$1) {
        super(1);
        this.this$0 = widgetGuildRoleSubscriptionTierBenefits$itemClickListener$1;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ List<? extends WidgetRadioSelectorBottomSheet2> invoke(GuildRoleSubscriptionTierBenefitsViewModel.ViewState viewState) {
        return invoke2(viewState);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final List<WidgetRadioSelectorBottomSheet2> invoke2(GuildRoleSubscriptionTierBenefitsViewModel.ViewState viewState) {
        Intrinsics3.checkNotNullParameter(viewState, "it");
        List<Integer> activeTrialUserLimitOptions = viewState.getActiveTrialUserLimitOptions();
        ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(activeTrialUserLimitOptions, 10));
        int i = 0;
        for (Object obj : activeTrialUserLimitOptions) {
            int i2 = i + 1;
            if (i < 0) {
                Collections2.throwIndexOverflow();
            }
            arrayList.add((WidgetRadioSelectorBottomSheet2) WidgetGuildRoleSubscriptionTierBenefits.access$getViewModel$p(this.this$0.this$0).withViewState(new WidgetGuildRoleSubscriptionTierBenefits$itemClickListener$1$onActiveTrialUserLimitClick$1$$special$$inlined$mapIndexed$lambda$1(i, (Integer) obj, this)));
            i = i2;
        }
        return arrayList;
    }
}
