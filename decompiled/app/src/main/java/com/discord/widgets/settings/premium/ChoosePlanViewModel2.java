package com.discord.widgets.settings.premium;

import com.discord.stores.StoreGooglePlayPurchases;
import com.discord.stores.StoreGooglePlaySkuDetails;
import com.discord.stores.StoreSubscriptions;
import com.discord.widgets.settings.premium.ChoosePlanViewModel;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.jvm.functions.Function4;

/* compiled from: ChoosePlanViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\n"}, d2 = {"Lcom/discord/stores/StoreGooglePlaySkuDetails$State;", "p1", "Lcom/discord/stores/StoreGooglePlayPurchases$State;", "p2", "Lcom/discord/stores/StoreGooglePlayPurchases$QueryState;", "p3", "Lcom/discord/stores/StoreSubscriptions$SubscriptionsState;", "p4", "Lcom/discord/widgets/settings/premium/ChoosePlanViewModel$StoreState;", "invoke", "(Lcom/discord/stores/StoreGooglePlaySkuDetails$State;Lcom/discord/stores/StoreGooglePlayPurchases$State;Lcom/discord/stores/StoreGooglePlayPurchases$QueryState;Lcom/discord/stores/StoreSubscriptions$SubscriptionsState;)Lcom/discord/widgets/settings/premium/ChoosePlanViewModel$StoreState;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.settings.premium.ChoosePlanViewModel$Companion$observeStores$1, reason: use source file name */
/* loaded from: classes2.dex */
public final /* synthetic */ class ChoosePlanViewModel2 extends FunctionReferenceImpl implements Function4<StoreGooglePlaySkuDetails.State, StoreGooglePlayPurchases.State, StoreGooglePlayPurchases.QueryState, StoreSubscriptions.SubscriptionsState, ChoosePlanViewModel.StoreState> {
    public static final ChoosePlanViewModel2 INSTANCE = new ChoosePlanViewModel2();

    public ChoosePlanViewModel2() {
        super(4, ChoosePlanViewModel.StoreState.class, "<init>", "<init>(Lcom/discord/stores/StoreGooglePlaySkuDetails$State;Lcom/discord/stores/StoreGooglePlayPurchases$State;Lcom/discord/stores/StoreGooglePlayPurchases$QueryState;Lcom/discord/stores/StoreSubscriptions$SubscriptionsState;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function4
    public /* bridge */ /* synthetic */ ChoosePlanViewModel.StoreState invoke(StoreGooglePlaySkuDetails.State state, StoreGooglePlayPurchases.State state2, StoreGooglePlayPurchases.QueryState queryState, StoreSubscriptions.SubscriptionsState subscriptionsState) {
        return invoke2(state, state2, queryState, subscriptionsState);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final ChoosePlanViewModel.StoreState invoke2(StoreGooglePlaySkuDetails.State state, StoreGooglePlayPurchases.State state2, StoreGooglePlayPurchases.QueryState queryState, StoreSubscriptions.SubscriptionsState subscriptionsState) {
        Intrinsics3.checkNotNullParameter(state, "p1");
        Intrinsics3.checkNotNullParameter(state2, "p2");
        Intrinsics3.checkNotNullParameter(queryState, "p3");
        Intrinsics3.checkNotNullParameter(subscriptionsState, "p4");
        return new ChoosePlanViewModel.StoreState(state, state2, queryState, subscriptionsState);
    }
}
