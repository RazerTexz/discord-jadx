package com.discord.utilities.analytics;

import com.discord.utilities.system.DeviceResourceUsageMonitor;
import com.discord.utilities.time.ClockFactory;
import com.discord.utilities.time.TimeSpan;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;

/* compiled from: AnalyticsDeviceResourceUsageMonitor.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\b\u0010\u0004J\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0006\u001a\u00020\u00058\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007¨\u0006\t"}, d2 = {"Lcom/discord/utilities/analytics/AnalyticsDeviceResourceUsageMonitor;", "", "", "start", "()V", "Lcom/discord/utilities/system/DeviceResourceUsageMonitor;", "resourceMonitor", "Lcom/discord/utilities/system/DeviceResourceUsageMonitor;", "<init>", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class AnalyticsDeviceResourceUsageMonitor {
    public static final AnalyticsDeviceResourceUsageMonitor INSTANCE = new AnalyticsDeviceResourceUsageMonitor();
    private static final DeviceResourceUsageMonitor resourceMonitor = new DeviceResourceUsageMonitor(new TimeSpan(1, TimeUnit.SECONDS), ClockFactory.get(), AnalyticsDeviceResourceUsageMonitor2.INSTANCE);

    private AnalyticsDeviceResourceUsageMonitor() {
    }

    public final void start() {
        resourceMonitor.start();
    }
}
