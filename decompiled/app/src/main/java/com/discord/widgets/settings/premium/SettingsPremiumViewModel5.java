package com.discord.widgets.settings.premium;

import androidx.core.app.NotificationCompat;
import com.discord.stores.StoreSubscriptions;
import com.discord.utilities.rest.RestAPI;
import com.discord.widgets.settings.premium.SettingsPremiumViewModel;
import d0.z.d.Intrinsics3;
import j0.k.Func1;
import kotlin.Metadata;
import rx.Observable;

/* compiled from: SettingsPremiumViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0007\u001a*\u0012\u000e\b\u0001\u0012\n \u0001*\u0004\u0018\u00010\u00040\u0004 \u0001*\u0014\u0012\u000e\b\u0001\u0012\n \u0001*\u0004\u0018\u00010\u00040\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lcom/discord/stores/StoreSubscriptions$SubscriptionsState;", "kotlin.jvm.PlatformType", "state", "Lrx/Observable;", "Lcom/discord/widgets/settings/premium/SettingsPremiumViewModel$SubscriptionAndInvoice;", NotificationCompat.CATEGORY_CALL, "(Lcom/discord/stores/StoreSubscriptions$SubscriptionsState;)Lrx/Observable;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.settings.premium.SettingsPremiumViewModel$Companion$observeStores$2, reason: use source file name */
/* loaded from: classes2.dex */
public final class SettingsPremiumViewModel5<T, R> implements Func1<StoreSubscriptions.SubscriptionsState, Observable<? extends SettingsPremiumViewModel.SubscriptionAndInvoice>> {
    public final /* synthetic */ RestAPI $restAPI;

    public SettingsPremiumViewModel5(RestAPI restAPI) {
        this.$restAPI = restAPI;
    }

    @Override // j0.k.Func1
    public /* bridge */ /* synthetic */ Observable<? extends SettingsPremiumViewModel.SubscriptionAndInvoice> call(StoreSubscriptions.SubscriptionsState subscriptionsState) {
        return call2(subscriptionsState);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends SettingsPremiumViewModel.SubscriptionAndInvoice> call2(StoreSubscriptions.SubscriptionsState subscriptionsState) {
        SettingsPremiumViewModel.Companion companion = SettingsPremiumViewModel.INSTANCE;
        RestAPI restAPI = this.$restAPI;
        Intrinsics3.checkNotNullExpressionValue(subscriptionsState, "state");
        return SettingsPremiumViewModel.Companion.access$getSubscriptionsAndInvoicePreview(companion, restAPI, subscriptionsState, false);
    }
}
