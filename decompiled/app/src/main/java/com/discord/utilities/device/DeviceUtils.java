package com.discord.utilities.device;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.provider.Settings;
import d0.g0.Strings4;
import d0.t.SetsJVM;
import d0.z.d.Intrinsics3;
import java.util.Iterator;
import java.util.Set;
import kotlin.Metadata;

/* compiled from: DeviceUtils.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\"\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\u0006J1\u0010\r\u001a\u00020\u00042\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\r\u0010\u000eJC\u0010\r\u001a\u00020\u00042\u0010\b\u0002\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u000f2\u0010\b\u0002\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u000f2\u0010\b\u0002\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u000f¢\u0006\u0004\b\r\u0010\u0013J\u0015\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b\u0016\u0010\u0017R\u0016\u0010\u0018\u001a\u00020\n8\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019¨\u0006\u001c"}, d2 = {"Lcom/discord/utilities/device/DeviceUtils;", "", "Landroid/content/res/Resources;", "resources", "", "isTablet", "(Landroid/content/res/Resources;)Z", "isSmallScreen", "", "manufacturer", "", "versionCode", "model", "isDevice", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;)Z", "", "manufacturers", "versionCodes", "models", "(Ljava/util/Set;Ljava/util/Set;Ljava/util/Set;)Z", "Landroid/content/Context;", "context", "canDrawOverlays", "(Landroid/content/Context;)Z", "SMALL_SCREEN_WIDTH_DP", "I", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class DeviceUtils {
    public static final DeviceUtils INSTANCE = new DeviceUtils();
    private static final int SMALL_SCREEN_WIDTH_DP = 360;

    private DeviceUtils() {
    }

    public static /* synthetic */ boolean isDevice$default(DeviceUtils deviceUtils, String str, Integer num, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        if ((i & 2) != 0) {
            num = null;
        }
        if ((i & 4) != 0) {
            str2 = null;
        }
        return deviceUtils.isDevice(str, num, str2);
    }

    public final boolean canDrawOverlays(Context context) {
        Intrinsics3.checkNotNullParameter(context, "context");
        return Build.VERSION.SDK_INT <= 22 || Settings.canDrawOverlays(context);
    }

    public final boolean isDevice(String manufacturer, Integer versionCode, String model) {
        return isDevice(manufacturer != null ? SetsJVM.setOf(manufacturer) : null, versionCode != null ? SetsJVM.setOf(Integer.valueOf(versionCode.intValue())) : null, model != null ? SetsJVM.setOf(model) : null);
    }

    public final boolean isSmallScreen(Resources resources) {
        Intrinsics3.checkNotNullParameter(resources, "resources");
        return ((float) resources.getDisplayMetrics().widthPixels) <= ((float) SMALL_SCREEN_WIDTH_DP) * resources.getDisplayMetrics().density;
    }

    public final boolean isTablet(Resources resources) {
        Intrinsics3.checkNotNullParameter(resources, "resources");
        return (resources.getConfiguration().screenLayout & 15) >= 3;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ boolean isDevice$default(DeviceUtils deviceUtils, Set set, Set set2, Set set3, int i, Object obj) {
        if ((i & 1) != 0) {
            set = null;
        }
        if ((i & 2) != 0) {
            set2 = null;
        }
        if ((i & 4) != 0) {
            set3 = null;
        }
        return deviceUtils.isDevice((Set<String>) set, (Set<Integer>) set2, (Set<String>) set3);
    }

    public final boolean isDevice(Set<String> manufacturers, Set<Integer> versionCodes, Set<String> models) {
        boolean z2;
        boolean z3;
        boolean z4;
        if (manufacturers == null) {
            z2 = true;
            break;
        }
        if (!manufacturers.isEmpty()) {
            for (String str : manufacturers) {
                String str2 = Build.MANUFACTURER;
                Intrinsics3.checkNotNullExpressionValue(str2, "Build.MANUFACTURER");
                if (Strings4.contains((CharSequence) str2, (CharSequence) str, true)) {
                    z2 = true;
                    break;
                }
            }
        }
        z2 = false;
        if (versionCodes == null) {
            z3 = true;
            break;
        }
        if (!versionCodes.isEmpty()) {
            Iterator<T> it = versionCodes.iterator();
            while (it.hasNext()) {
                if (Build.VERSION.SDK_INT == ((Number) it.next()).intValue()) {
                    z3 = true;
                    break;
                }
            }
        }
        z3 = false;
        if (models == null) {
            z4 = true;
            break;
        }
        if (!models.isEmpty()) {
            for (String str3 : models) {
                String str4 = Build.MODEL;
                Intrinsics3.checkNotNullExpressionValue(str4, "Build.MODEL");
                if (Strings4.contains((CharSequence) str4, (CharSequence) str3, true)) {
                    z4 = true;
                    break;
                }
            }
        }
        z4 = false;
        return z2 && z3 && z4;
    }
}
