package com.discord.utilities.analytics;

import com.discord.utilities.analytics.AnalyticsUtils;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.time.ClockFactory;
import d0.z.d.Lambda;
import java.util.concurrent.ConcurrentLinkedQueue;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

/* compiled from: AnalyticsUtils.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lcom/discord/utilities/analytics/AnalyticsUtils$Tracker;", "invoke", "()Lcom/discord/utilities/analytics/AnalyticsUtils$Tracker;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.utilities.analytics.AnalyticsUtils$Tracker$Companion$instance$2, reason: use source file name */
/* loaded from: classes2.dex */
public final class AnalyticsUtils2 extends Lambda implements Function0<AnalyticsUtils.Tracker> {
    public static final AnalyticsUtils2 INSTANCE = new AnalyticsUtils2();

    public AnalyticsUtils2() {
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ AnalyticsUtils.Tracker invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final AnalyticsUtils.Tracker invoke() {
        return new AnalyticsUtils.Tracker(ClockFactory.get(), RestAPI.INSTANCE.getApi(), new ConcurrentLinkedQueue());
    }
}
