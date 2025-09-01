package com.discord.utilities.analytics;

import com.discord.utilities.system.DeviceResourceUsageMonitor;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: AnalyticsDeviceResourceUsageMonitor.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/utilities/system/DeviceResourceUsageMonitor$ResourceUsage;", "it", "", "invoke", "(Lcom/discord/utilities/system/DeviceResourceUsageMonitor$ResourceUsage;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.utilities.analytics.AnalyticsDeviceResourceUsageMonitor$resourceMonitor$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class AnalyticsDeviceResourceUsageMonitor2 extends Lambda implements Function1<DeviceResourceUsageMonitor.ResourceUsage, Unit> {
    public static final AnalyticsDeviceResourceUsageMonitor2 INSTANCE = new AnalyticsDeviceResourceUsageMonitor2();

    public AnalyticsDeviceResourceUsageMonitor2() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(DeviceResourceUsageMonitor.ResourceUsage resourceUsage) {
        invoke2(resourceUsage);
        return Unit.a;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(DeviceResourceUsageMonitor.ResourceUsage resourceUsage) {
        Intrinsics3.checkNotNullParameter(resourceUsage, "it");
        AnalyticSuperProperties.INSTANCE.setClientPerformanceProperties(resourceUsage.getCpuUsagePercent(), resourceUsage.getMemoryRssBytes() / 1024, resourceUsage.getCpuCoreCount());
    }
}
