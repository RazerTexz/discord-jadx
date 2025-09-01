package com.discord.utilities.system;

import android.content.Context;
import android.net.wifi.WifiManager;
import android.os.PowerManager;
import d0.z.d.Intrinsics3;
import java.util.Objects;
import kotlin.Metadata;

/* compiled from: SystemServiceExtensions.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\u001a3\u0010\t\u001a\u00060\u0007R\u00020\b*\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00012\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\t\u0010\n\u001a+\u0010\r\u001a\b\u0018\u00010\u000bR\u00020\f*\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00012\b\b\u0002\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\r\u0010\u000e\u001a+\u0010\u000f\u001a\b\u0018\u00010\u000bR\u00020\f*\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00012\b\b\u0002\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u000f\u0010\u000e\u001a?\u0010\u0012\u001a\b\u0018\u00010\u000bR\u00020\f*\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u00032\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0002\u001a\u00020\u00012\b\b\u0002\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0012\u0010\u0013\"\u0016\u0010\u0014\u001a\u00020\u00058\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Landroid/content/Context;", "", "referenceCounted", "", "lockType", "", "tag", "Landroid/net/wifi/WifiManager$WifiLock;", "Landroid/net/wifi/WifiManager;", "createWifiLock", "(Landroid/content/Context;ZILjava/lang/String;)Landroid/net/wifi/WifiManager$WifiLock;", "Landroid/os/PowerManager$WakeLock;", "Landroid/os/PowerManager;", "createPartialWakeLock", "(Landroid/content/Context;ZLjava/lang/String;)Landroid/os/PowerManager$WakeLock;", "createProximityScreenWakeLock", "level", "flags", "createWakeLock", "(Landroid/content/Context;ILjava/lang/Integer;ZLjava/lang/String;)Landroid/os/PowerManager$WakeLock;", "TAG", "Ljava/lang/String;", "utils_release"}, k = 2, mv = {1, 4, 2})
/* renamed from: com.discord.utilities.system.SystemServiceExtensionsKt, reason: use source file name */
/* loaded from: classes2.dex */
public final class SystemServiceExtensions {
    private static final String TAG = "discord:com.discord.utils";

    public static final PowerManager.WakeLock createPartialWakeLock(Context context, boolean z2, String str) {
        Intrinsics3.checkNotNullParameter(context, "$this$createPartialWakeLock");
        Intrinsics3.checkNotNullParameter(str, "tag");
        return createWakeLock$default(context, 1, null, z2, str, 2, null);
    }

    public static /* synthetic */ PowerManager.WakeLock createPartialWakeLock$default(Context context, boolean z2, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            z2 = false;
        }
        if ((i & 2) != 0) {
            str = TAG;
        }
        return createPartialWakeLock(context, z2, str);
    }

    public static final PowerManager.WakeLock createProximityScreenWakeLock(Context context, boolean z2, String str) {
        Intrinsics3.checkNotNullParameter(context, "$this$createProximityScreenWakeLock");
        Intrinsics3.checkNotNullParameter(str, "tag");
        return createWakeLock$default(context, 32, null, z2, str, 2, null);
    }

    public static /* synthetic */ PowerManager.WakeLock createProximityScreenWakeLock$default(Context context, boolean z2, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            z2 = false;
        }
        if ((i & 2) != 0) {
            str = TAG;
        }
        return createProximityScreenWakeLock(context, z2, str);
    }

    private static final PowerManager.WakeLock createWakeLock(Context context, int i, Integer num, boolean z2, String str) {
        Object systemService = context.getSystemService("power");
        Objects.requireNonNull(systemService, "null cannot be cast to non-null type android.os.PowerManager");
        PowerManager powerManager = (PowerManager) systemService;
        if (!powerManager.isWakeLockLevelSupported(i)) {
            return null;
        }
        if (num != null) {
            i |= num.intValue();
        }
        PowerManager.WakeLock wakeLockNewWakeLock = powerManager.newWakeLock(i, str);
        wakeLockNewWakeLock.setReferenceCounted(z2);
        return wakeLockNewWakeLock;
    }

    public static /* synthetic */ PowerManager.WakeLock createWakeLock$default(Context context, int i, Integer num, boolean z2, String str, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            num = null;
        }
        if ((i2 & 8) != 0) {
            str = TAG;
        }
        return createWakeLock(context, i, num, z2, str);
    }

    public static final WifiManager.WifiLock createWifiLock(Context context, boolean z2, int i, String str) {
        Intrinsics3.checkNotNullParameter(context, "$this$createWifiLock");
        Intrinsics3.checkNotNullParameter(str, "tag");
        Object systemService = context.getApplicationContext().getSystemService("wifi");
        Objects.requireNonNull(systemService, "null cannot be cast to non-null type android.net.wifi.WifiManager");
        WifiManager.WifiLock wifiLockCreateWifiLock = ((WifiManager) systemService).createWifiLock(i, str);
        wifiLockCreateWifiLock.setReferenceCounted(z2);
        Intrinsics3.checkNotNullExpressionValue(wifiLockCreateWifiLock, "(applicationContext.getS…unted(referenceCounted)\n}");
        return wifiLockCreateWifiLock;
    }

    public static /* synthetic */ WifiManager.WifiLock createWifiLock$default(Context context, boolean z2, int i, String str, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            z2 = false;
        }
        if ((i2 & 2) != 0) {
            i = 3;
        }
        if ((i2 & 4) != 0) {
            str = TAG;
        }
        return createWifiLock(context, z2, i, str);
    }
}
