package com.discord.widgets.auth;

import com.discord.analytics.generated.events.impression.TrackImpressionUserAgeGate;
import com.discord.analytics.generated.events.impression.TrackImpressionUserAgeGateUnderage;
import com.discord.api.science.AnalyticsSchema;
import com.discord.app.AppViewFlipper;
import com.discord.stores.StoreStream;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

/* compiled from: WidgetAgeVerify.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lcom/discord/api/science/AnalyticsSchema;", "invoke", "()Lcom/discord/api/science/AnalyticsSchema;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.auth.WidgetAgeVerify$loggingConfig$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetAgeVerify4 extends Lambda implements Function0<AnalyticsSchema> {
    public final /* synthetic */ WidgetAgeVerify this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetAgeVerify4(WidgetAgeVerify widgetAgeVerify) {
        super(0);
        this.this$0 = widgetAgeVerify;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ AnalyticsSchema invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final AnalyticsSchema invoke() {
        AnalyticsSchema trackImpressionUserAgeGate;
        boolean z2 = StoreStream.INSTANCE.getUsers().getMeSnapshot().getId() > 0;
        AppViewFlipper appViewFlipper = WidgetAgeVerify.access$getBinding$p(this.this$0).f2224b;
        Intrinsics3.checkNotNullExpressionValue(appViewFlipper, "binding.ageVerifyViewFlipper");
        int displayedChild = appViewFlipper.getDisplayedChild();
        if (displayedChild == 0) {
            trackImpressionUserAgeGate = new TrackImpressionUserAgeGate(Boolean.valueOf(z2));
        } else {
            if (displayedChild != 2) {
                return null;
            }
            trackImpressionUserAgeGate = new TrackImpressionUserAgeGateUnderage(Boolean.valueOf(z2));
        }
        return trackImpressionUserAgeGate;
    }
}
