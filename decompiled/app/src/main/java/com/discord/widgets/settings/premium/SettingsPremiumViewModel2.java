package com.discord.widgets.settings.premium;

import androidx.core.app.NotificationCompat;
import com.discord.models.domain.billing.ModelInvoicePreview;
import com.discord.stores.StoreSubscriptions;
import com.discord.widgets.settings.premium.SettingsPremiumViewModel;
import j0.k.Func1;
import kotlin.Metadata;

/* compiled from: SettingsPremiumViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0006\u001a\n \u0003*\u0004\u0018\u00010\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/discord/models/domain/billing/ModelInvoicePreview;", "invoicePreview", "Lcom/discord/widgets/settings/premium/SettingsPremiumViewModel$SubscriptionAndInvoice;", "kotlin.jvm.PlatformType", NotificationCompat.CATEGORY_CALL, "(Lcom/discord/models/domain/billing/ModelInvoicePreview;)Lcom/discord/widgets/settings/premium/SettingsPremiumViewModel$SubscriptionAndInvoice;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.settings.premium.SettingsPremiumViewModel$Companion$getSubscriptionsAndInvoicePreview$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class SettingsPremiumViewModel2<T, R> implements Func1<ModelInvoicePreview, SettingsPremiumViewModel.SubscriptionAndInvoice> {
    public final /* synthetic */ StoreSubscriptions.SubscriptionsState $state;

    public SettingsPremiumViewModel2(StoreSubscriptions.SubscriptionsState subscriptionsState) {
        this.$state = subscriptionsState;
    }

    @Override // j0.k.Func1
    public /* bridge */ /* synthetic */ SettingsPremiumViewModel.SubscriptionAndInvoice call(ModelInvoicePreview modelInvoicePreview) {
        return call2(modelInvoicePreview);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final SettingsPremiumViewModel.SubscriptionAndInvoice call2(ModelInvoicePreview modelInvoicePreview) {
        return new SettingsPremiumViewModel.SubscriptionAndInvoice(this.$state, new SettingsPremiumViewModel.InvoicePreviewFetch.Invoice(modelInvoicePreview));
    }
}
