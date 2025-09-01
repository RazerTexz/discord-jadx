package com.discord.utilities.navigation;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.discord.utilities.fcm.NotificationClient;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: SystemSettingNavigators.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/discord/utilities/navigation/SystemSettingNavigators;", "", "Landroid/content/Context;", "context", "", "openSystemNotification", "(Landroid/content/Context;)V", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class SystemSettingNavigators {
    public static final SystemSettingNavigators INSTANCE = new SystemSettingNavigators();

    private SystemSettingNavigators() {
    }

    public final void openSystemNotification(Context context) {
        Intrinsics3.checkNotNullParameter(context, "context");
        if (!NotificationClient.INSTANCE.isOsLevelNotificationEnabled()) {
            context.startActivity(new Intent("android.settings.APPLICATION_DETAILS_SETTINGS", new Uri.Builder().scheme("package").opaquePart(context.getPackageName()).build()));
            return;
        }
        Intent intent = new Intent("android.settings.APP_NOTIFICATION_SETTINGS");
        intent.putExtra("android.provider.extra.APP_PACKAGE", context.getPackageName());
        context.startActivity(intent);
    }
}
