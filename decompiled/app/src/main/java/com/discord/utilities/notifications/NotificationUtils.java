package com.discord.utilities.notifications;

import android.content.Context;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.discord.utilities.fcm.NotificationClient;
import com.discord.widgets.settings.WidgetSettingsNotifications;
import com.discord.widgets.settings.WidgetSettingsNotificationsOs;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: NotificationUtils.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/discord/utilities/notifications/NotificationUtils;", "", "Landroidx/fragment/app/Fragment;", "fragment", "", "showNotificationPage", "(Landroidx/fragment/app/Fragment;)V", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class NotificationUtils {
    public static final NotificationUtils INSTANCE = new NotificationUtils();

    private NotificationUtils() {
    }

    public final void showNotificationPage(Fragment fragment) {
        Intrinsics3.checkNotNullParameter(fragment, "fragment");
        if (NotificationClient.INSTANCE.isOsLevelNotificationEnabled()) {
            WidgetSettingsNotificationsOs.Companion companion = WidgetSettingsNotificationsOs.INSTANCE;
            FragmentManager parentFragmentManager = fragment.getParentFragmentManager();
            Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "fragment.parentFragmentManager");
            companion.show(parentFragmentManager);
            return;
        }
        WidgetSettingsNotifications.Companion companion2 = WidgetSettingsNotifications.INSTANCE;
        Context contextRequireContext = fragment.requireContext();
        Intrinsics3.checkNotNullExpressionValue(contextRequireContext, "fragment.requireContext()");
        companion2.launch(contextRequireContext);
    }
}
