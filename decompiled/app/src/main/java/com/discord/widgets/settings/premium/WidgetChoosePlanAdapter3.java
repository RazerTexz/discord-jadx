package com.discord.widgets.settings.premium;

import com.android.billingclient.api.SkuDetails;
import com.discord.utilities.billing.GooglePlaySku;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;

/* compiled from: WidgetChoosePlanAdapter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\t\u001a\u00020\u00062\u0006\u0010\u0001\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\n¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"Lcom/discord/utilities/billing/GooglePlaySku;", "<anonymous parameter 0>", "", "<anonymous parameter 1>", "Lcom/android/billingclient/api/SkuDetails;", "<anonymous parameter 2>", "", "invoke", "(Lcom/discord/utilities/billing/GooglePlaySku;Ljava/lang/String;Lcom/android/billingclient/api/SkuDetails;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.settings.premium.WidgetChoosePlanAdapter$onClickPlan$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetChoosePlanAdapter3 extends Lambda implements Function3<GooglePlaySku, String, SkuDetails, Unit> {
    public static final WidgetChoosePlanAdapter3 INSTANCE = new WidgetChoosePlanAdapter3();

    public WidgetChoosePlanAdapter3() {
        super(3);
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Unit invoke(GooglePlaySku googlePlaySku, String str, SkuDetails skuDetails) {
        invoke2(googlePlaySku, str, skuDetails);
        return Unit.a;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(GooglePlaySku googlePlaySku, String str, SkuDetails skuDetails) {
        Intrinsics3.checkNotNullParameter(googlePlaySku, "<anonymous parameter 0>");
    }
}
