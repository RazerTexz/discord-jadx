package com.discord.widgets.settings.premium;

import androidx.core.app.NotificationCompat;
import com.discord.stores.StoreSubscriptions;
import com.discord.widgets.settings.premium.SettingsPremiumViewModel;
import j0.k.Func1;
import kotlin.Metadata;

/* compiled from: SettingsPremiumViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0006\u001a\n \u0001*\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "kotlin.jvm.PlatformType", "it", "Lcom/discord/widgets/settings/premium/SettingsPremiumViewModel$SubscriptionAndInvoice;", NotificationCompat.CATEGORY_CALL, "(Ljava/lang/Throwable;)Lcom/discord/widgets/settings/premium/SettingsPremiumViewModel$SubscriptionAndInvoice;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.settings.premium.SettingsPremiumViewModel$Companion$getSubscriptionsAndInvoicePreview$2, reason: use source file name */
/* loaded from: classes2.dex */
public final class SettingsPremiumViewModel3<T, R> implements Func1<Throwable, SettingsPremiumViewModel.SubscriptionAndInvoice> {
    public final /* synthetic */ StoreSubscriptions.SubscriptionsState $state;

    public SettingsPremiumViewModel3(StoreSubscriptions.SubscriptionsState subscriptionsState) {
        this.$state = subscriptionsState;
    }

    @Override // j0.k.Func1
    public /* bridge */ /* synthetic */ SettingsPremiumViewModel.SubscriptionAndInvoice call(Throwable th) {
        return call2(th);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final SettingsPremiumViewModel.SubscriptionAndInvoice call2(Throwable th) {
        return new SettingsPremiumViewModel.SubscriptionAndInvoice(this.$state, SettingsPremiumViewModel.InvoicePreviewFetch.Error.INSTANCE);
    }
}
