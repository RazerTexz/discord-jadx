package com.discord.utilities.analytics;

import com.adjust.sdk.AdjustAttribution;
import com.adjust.sdk.OnAttributionChangedListener;
import kotlin.Metadata;

/* compiled from: AdjustConfig.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/adjust/sdk/AdjustAttribution;", "kotlin.jvm.PlatformType", "adjustAttribution", "", "onAttributionChanged", "(Lcom/adjust/sdk/AdjustAttribution;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.utilities.analytics.AdjustConfig$init$1$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class AdjustConfig2 implements OnAttributionChangedListener {
    public static final AdjustConfig2 INSTANCE = new AdjustConfig2();

    @Override // com.adjust.sdk.OnAttributionChangedListener
    public final void onAttributionChanged(AdjustAttribution adjustAttribution) {
        if (adjustAttribution != null) {
            AnalyticsTracker.INSTANCE.attributionChange(adjustAttribution);
        }
    }
}
