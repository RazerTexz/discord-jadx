package com.discord.widgets.settings.premium;

import androidx.core.app.NotificationCompat;
import com.discord.stores.StoreEntitlements;
import com.discord.stores.StoreGooglePlayPurchases;
import com.discord.stores.StoreGooglePlaySkuDetails;
import com.discord.stores.StoreGuildBoost;
import com.discord.stores.StorePaymentSources;
import com.discord.stores.StoreSubscriptions;
import com.discord.widgets.settings.premium.SettingsPremiumViewModel;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import rx.functions.Func7;

/* compiled from: SettingsPremiumViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0011\u001a\n \u0001*\u0004\u0018\u00010\u000e0\u000e2\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u00002\u000e\u0010\u0004\u001a\n \u0001*\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0005\u001a\n \u0001*\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0007\u001a\n \u0001*\u0004\u0018\u00010\u00060\u00062\u000e\u0010\t\u001a\n \u0001*\u0004\u0018\u00010\b0\b2\u000e\u0010\u000b\u001a\n \u0001*\u0004\u0018\u00010\n0\n2\u000e\u0010\r\u001a\n \u0001*\u0004\u0018\u00010\f0\fH\n¢\u0006\u0004\b\u000f\u0010\u0010"}, d2 = {"Lcom/discord/stores/StorePaymentSources$PaymentSourcesState;", "kotlin.jvm.PlatformType", "paymentSourcesState", "Lcom/discord/widgets/settings/premium/SettingsPremiumViewModel$SubscriptionAndInvoice;", "renewalSubscriptionStateAndInvoice", "currentSubscriptionStateAndInvoice", "Lcom/discord/stores/StoreEntitlements$State;", "entitlementsState", "Lcom/discord/stores/StoreGuildBoost$State;", "guildSubscriptionState", "Lcom/discord/stores/StoreGooglePlaySkuDetails$State;", "skuDetailsState", "Lcom/discord/stores/StoreGooglePlayPurchases$State;", "purchaseState", "Lcom/discord/widgets/settings/premium/SettingsPremiumViewModel$StoreState;", NotificationCompat.CATEGORY_CALL, "(Lcom/discord/stores/StorePaymentSources$PaymentSourcesState;Lcom/discord/widgets/settings/premium/SettingsPremiumViewModel$SubscriptionAndInvoice;Lcom/discord/widgets/settings/premium/SettingsPremiumViewModel$SubscriptionAndInvoice;Lcom/discord/stores/StoreEntitlements$State;Lcom/discord/stores/StoreGuildBoost$State;Lcom/discord/stores/StoreGooglePlaySkuDetails$State;Lcom/discord/stores/StoreGooglePlayPurchases$State;)Lcom/discord/widgets/settings/premium/SettingsPremiumViewModel$StoreState;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.settings.premium.SettingsPremiumViewModel$Companion$observeStores$3, reason: use source file name */
/* loaded from: classes2.dex */
public final class SettingsPremiumViewModel6<T1, T2, T3, T4, T5, T6, T7, R> implements Func7<StorePaymentSources.PaymentSourcesState, SettingsPremiumViewModel.SubscriptionAndInvoice, SettingsPremiumViewModel.SubscriptionAndInvoice, StoreEntitlements.State, StoreGuildBoost.State, StoreGooglePlaySkuDetails.State, StoreGooglePlayPurchases.State, SettingsPremiumViewModel.StoreState> {
    public static final SettingsPremiumViewModel6 INSTANCE = new SettingsPremiumViewModel6();

    @Override // rx.functions.Func7
    public /* bridge */ /* synthetic */ SettingsPremiumViewModel.StoreState call(StorePaymentSources.PaymentSourcesState paymentSourcesState, SettingsPremiumViewModel.SubscriptionAndInvoice subscriptionAndInvoice, SettingsPremiumViewModel.SubscriptionAndInvoice subscriptionAndInvoice2, StoreEntitlements.State state, StoreGuildBoost.State state2, StoreGooglePlaySkuDetails.State state3, StoreGooglePlayPurchases.State state4) {
        return call2(paymentSourcesState, subscriptionAndInvoice, subscriptionAndInvoice2, state, state2, state3, state4);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final SettingsPremiumViewModel.StoreState call2(StorePaymentSources.PaymentSourcesState paymentSourcesState, SettingsPremiumViewModel.SubscriptionAndInvoice subscriptionAndInvoice, SettingsPremiumViewModel.SubscriptionAndInvoice subscriptionAndInvoice2, StoreEntitlements.State state, StoreGuildBoost.State state2, StoreGooglePlaySkuDetails.State state3, StoreGooglePlayPurchases.State state4) {
        Intrinsics3.checkNotNullExpressionValue(paymentSourcesState, "paymentSourcesState");
        StoreSubscriptions.SubscriptionsState subscriptionsState = subscriptionAndInvoice.getSubscriptionsState();
        Intrinsics3.checkNotNullExpressionValue(state, "entitlementsState");
        Intrinsics3.checkNotNullExpressionValue(state2, "guildSubscriptionState");
        SettingsPremiumViewModel.InvoicePreviewFetch invoicePreviewFetch = subscriptionAndInvoice.getInvoicePreviewFetch();
        SettingsPremiumViewModel.InvoicePreviewFetch invoicePreviewFetch2 = subscriptionAndInvoice2.getInvoicePreviewFetch();
        Intrinsics3.checkNotNullExpressionValue(state3, "skuDetailsState");
        Intrinsics3.checkNotNullExpressionValue(state4, "purchaseState");
        return new SettingsPremiumViewModel.StoreState(paymentSourcesState, subscriptionsState, state, state2, invoicePreviewFetch, invoicePreviewFetch2, state3, state4);
    }
}
