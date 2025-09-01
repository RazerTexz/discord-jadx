package com.discord.widgets.settings.premium;

import android.content.Context;
import android.view.View;
import com.discord.models.domain.ModelSubscription;
import com.discord.utilities.analytics.Traits;
import com.discord.utilities.billing.GooglePlaySku;
import com.discord.widgets.settings.premium.WidgetChoosePlan;
import com.google.android.material.button.MaterialButton;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: WidgetSettingsPremium.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u0010\u0007\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "com/discord/widgets/settings/premium/WidgetSettingsPremium$configureButtons$2$1", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.settings.premium.WidgetSettingsPremium$configureButtons$$inlined$forEach$lambda$2, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetSettingsPremium3 implements View.OnClickListener {
    public final /* synthetic */ MaterialButton $button;
    public final /* synthetic */ ModelSubscription $premiumSubscription$inlined;
    public final /* synthetic */ WidgetSettingsPremium this$0;

    public WidgetSettingsPremium3(MaterialButton materialButton, WidgetSettingsPremium widgetSettingsPremium, ModelSubscription modelSubscription) {
        this.$button = materialButton;
        this.this$0 = widgetSettingsPremium;
        this.$premiumSubscription$inlined = modelSubscription;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        WidgetChoosePlan.Companion companion = WidgetChoosePlan.INSTANCE;
        Context contextRequireContext = this.this$0.requireContext();
        WidgetChoosePlan.ViewType viewType = Intrinsics3.areEqual(this.$button, WidgetSettingsPremium.access$getBinding$p(this.this$0).t.f76b) ? WidgetChoosePlan.ViewType.BUY_PREMIUM_TIER_1 : WidgetChoosePlan.ViewType.BUY_PREMIUM_TIER_2;
        ModelSubscription modelSubscription = this.$premiumSubscription$inlined;
        WidgetChoosePlan.Companion.launch$default(companion, contextRequireContext, null, viewType, modelSubscription != null ? modelSubscription.getPaymentGatewayPlanId() : null, new Traits.Location(Traits.Location.Page.USER_SETTINGS, WidgetSettingsPremium.access$getAnalyticsLocationSection$p(this.this$0), Traits.Location.Obj.BUTTON_CTA, Traits.Location.ObjType.BUY, null, 16, null), Traits.Subscription.INSTANCE.withGatewayPlanId(Intrinsics3.areEqual(this.$button, WidgetSettingsPremium.access$getBinding$p(this.this$0).t.f76b) ? GooglePlaySku.PREMIUM_TIER_1_MONTHLY.getSkuName() : GooglePlaySku.PREMIUM_TIER_2_MONTHLY.getSkuName()), 2, null);
    }
}
