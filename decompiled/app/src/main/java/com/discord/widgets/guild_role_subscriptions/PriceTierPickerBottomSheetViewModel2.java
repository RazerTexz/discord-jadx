package com.discord.widgets.guild_role_subscriptions;

import com.discord.stores.StoreGuildRoleSubscriptions;
import com.discord.widgets.guild_role_subscriptions.PriceTierPickerBottomSheetViewModel;
import d0.z.d.Lambda;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

/* compiled from: PriceTierPickerBottomSheetViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lcom/discord/widgets/guild_role_subscriptions/PriceTierPickerBottomSheetViewModel$StoreState;", "invoke", "()Lcom/discord/widgets/guild_role_subscriptions/PriceTierPickerBottomSheetViewModel$StoreState;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.guild_role_subscriptions.PriceTierPickerBottomSheetViewModel$Companion$observeStoreState$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class PriceTierPickerBottomSheetViewModel2 extends Lambda implements Function0<PriceTierPickerBottomSheetViewModel.StoreState> {
    public final /* synthetic */ StoreGuildRoleSubscriptions $storeGuildRoleSubscriptions;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PriceTierPickerBottomSheetViewModel2(StoreGuildRoleSubscriptions storeGuildRoleSubscriptions) {
        super(0);
        this.$storeGuildRoleSubscriptions = storeGuildRoleSubscriptions;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ PriceTierPickerBottomSheetViewModel.StoreState invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final PriceTierPickerBottomSheetViewModel.StoreState invoke() {
        return new PriceTierPickerBottomSheetViewModel.StoreState(this.$storeGuildRoleSubscriptions.getPriceTierStateSnapshot());
    }
}
