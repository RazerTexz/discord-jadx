package com.discord.widgets.settings.premium;

import com.discord.models.domain.ModelGift;
import com.discord.stores.StoreEntitlements;
import com.discord.stores.StoreOutboundPromotions;
import com.discord.widgets.settings.premium.SettingsGiftingViewModel;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function4;

/* compiled from: SettingsGiftingViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\f\u001a\u00020\t2\u0006\u0010\u0001\u001a\u00020\u00002\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\n\u0010\u000b"}, d2 = {"Lcom/discord/stores/StoreEntitlements$State;", "p1", "", "Lcom/discord/models/domain/ModelGift;", "p2", "Lcom/discord/stores/StoreOutboundPromotions$State;", "p3", "", "p4", "Lcom/discord/widgets/settings/premium/SettingsGiftingViewModel$StoreState;", "invoke", "(Lcom/discord/stores/StoreEntitlements$State;Ljava/util/List;Lcom/discord/stores/StoreOutboundPromotions$State;Z)Lcom/discord/widgets/settings/premium/SettingsGiftingViewModel$StoreState;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.settings.premium.SettingsGiftingViewModel$Companion$observeStores$3, reason: use source file name */
/* loaded from: classes2.dex */
public final /* synthetic */ class SettingsGiftingViewModel4 extends FunctionReferenceImpl implements Function4<StoreEntitlements.State, List<? extends ModelGift>, StoreOutboundPromotions.State, Boolean, SettingsGiftingViewModel.StoreState> {
    public static final SettingsGiftingViewModel4 INSTANCE = new SettingsGiftingViewModel4();

    public SettingsGiftingViewModel4() {
        super(4, SettingsGiftingViewModel.StoreState.class, "<init>", "<init>(Lcom/discord/stores/StoreEntitlements$State;Ljava/util/List;Lcom/discord/stores/StoreOutboundPromotions$State;Z)V", 0);
    }

    @Override // kotlin.jvm.functions.Function4
    public /* bridge */ /* synthetic */ SettingsGiftingViewModel.StoreState invoke(StoreEntitlements.State state, List<? extends ModelGift> list, StoreOutboundPromotions.State state2, Boolean bool) {
        return invoke(state, (List<ModelGift>) list, state2, bool.booleanValue());
    }

    public final SettingsGiftingViewModel.StoreState invoke(StoreEntitlements.State state, List<ModelGift> list, StoreOutboundPromotions.State state2, boolean z2) {
        Intrinsics3.checkNotNullParameter(state, "p1");
        Intrinsics3.checkNotNullParameter(list, "p2");
        Intrinsics3.checkNotNullParameter(state2, "p3");
        return new SettingsGiftingViewModel.StoreState(state, list, state2, z2);
    }
}
