package com.discord.rtcconnection;

import android.content.ComponentCallbacks2;
import android.content.res.Configuration;
import com.discord.rtcconnection.enums.TrimMemoryLevel;
import com.discord.utilities.logging.Logger;
import com.discord.utilities.logging.LoggingProvider;
import d0.z.d.Intrinsics3;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;

/* compiled from: LowMemoryDetector.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00122\u00020\u0001:\u0001\u0013B\u0007¢\u0006\u0004\b\u0011\u0010\bJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\u000b\u0010\fR\u0016\u0010\u0010\u001a\u00020\r8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f¨\u0006\u0014"}, d2 = {"Lcom/discord/rtcconnection/LowMemoryDetector;", "Landroid/content/ComponentCallbacks2;", "", "level", "", "onTrimMemory", "(I)V", "onLowMemory", "()V", "Landroid/content/res/Configuration;", "newConfig", "onConfigurationChanged", "(Landroid/content/res/Configuration;)V", "Ljava/util/concurrent/atomic/AtomicBoolean;", "k", "Ljava/util/concurrent/atomic/AtomicBoolean;", "isOom", "<init>", "j", "a", "rtcconnection_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final class LowMemoryDetector implements ComponentCallbacks2 {

    /* renamed from: k, reason: from kotlin metadata */
    public final AtomicBoolean isOom = new AtomicBoolean(false);

    @Override // android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration newConfig) {
        Intrinsics3.checkNotNullParameter(newConfig, "newConfig");
    }

    @Override // android.content.ComponentCallbacks
    public void onLowMemory() {
        this.isOom.set(true);
        if (this.isOom.get()) {
            Logger.i$default(LoggingProvider.INSTANCE.get(), "LowMemoryDetector", "Normal memory", null, 4, null);
        } else {
            Logger.w$default(LoggingProvider.INSTANCE.get(), "LowMemoryDetector", "Low memory", null, 4, null);
        }
    }

    @Override // android.content.ComponentCallbacks2
    public void onTrimMemory(int level) {
        TrimMemoryLevel trimMemoryLevel;
        Objects.requireNonNull(TrimMemoryLevel.INSTANCE);
        TrimMemoryLevel[] trimMemoryLevelArrValues = TrimMemoryLevel.values();
        int i = 0;
        while (true) {
            if (i >= 7) {
                trimMemoryLevel = null;
                break;
            }
            trimMemoryLevel = trimMemoryLevelArrValues[i];
            if (trimMemoryLevel.getValue() == level) {
                break;
            } else {
                i++;
            }
        }
        if (trimMemoryLevel != null) {
            Logger.i$default(LoggingProvider.INSTANCE.get(), "LowMemoryDetector", "Memory trim level: " + trimMemoryLevel, null, 4, null);
            switch (trimMemoryLevel) {
                case Background:
                case RunningModerate:
                    Logger.i$default(LoggingProvider.INSTANCE.get(), "LowMemoryDetector", "ignoring low priority oom messages.", null, 4, null);
                    break;
                case Moderate:
                case RunningLow:
                    Logger.i$default(LoggingProvider.INSTANCE.get(), "LowMemoryDetector", "ignoring medium priority oom messages.", null, 4, null);
                    break;
                case Complete:
                case RunningCritical:
                    onLowMemory();
                    break;
                case UiHidden:
                    Logger.i$default(LoggingProvider.INSTANCE.get(), "LowMemoryDetector", "UI is hidden because the app is in the background.", null, 4, null);
                    break;
            }
        }
    }
}
