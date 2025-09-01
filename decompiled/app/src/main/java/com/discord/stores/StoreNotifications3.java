package com.discord.stores;

import androidx.core.app.NotificationCompat;
import com.discord.stores.StoreUserSettingsSystem;
import com.discord.utilities.fcm.NotificationClient;
import d0.z.d.Intrinsics3;
import java.util.HashSet;
import kotlin.Metadata;
import rx.functions.Func4;

/* compiled from: StoreNotifications.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u000e\u001a\n \u0001*\u0004\u0018\u00010\u00000\u00002\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u00002\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u000e\u0010\u0006\u001a\n \u0001*\u0004\u0018\u00010\u00050\u00052@\u0010\u000b\u001a<\u0012\b\u0012\u00060\bj\u0002`\t \u0001*\u001e\u0012\b\u0012\u00060\bj\u0002`\t\u0018\u00010\u0007j\u000e\u0012\b\u0012\u00060\bj\u0002`\t\u0018\u0001`\n0\u0007j\f\u0012\b\u0012\u00060\bj\u0002`\t`\nH\n¢\u0006\u0004\b\f\u0010\r"}, d2 = {"Lcom/discord/utilities/fcm/NotificationClient$SettingsV2;", "kotlin.jvm.PlatformType", "settings", "", "authToken", "Lcom/discord/stores/StoreUserSettingsSystem$Settings;", "systemSettings", "Ljava/util/HashSet;", "", "Lcom/discord/primitives/ChannelId;", "Lkotlin/collections/HashSet;", "nonSendableChannelIds", NotificationCompat.CATEGORY_CALL, "(Lcom/discord/utilities/fcm/NotificationClient$SettingsV2;Ljava/lang/String;Lcom/discord/stores/StoreUserSettingsSystem$Settings;Ljava/util/HashSet;)Lcom/discord/utilities/fcm/NotificationClient$SettingsV2;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.stores.StoreNotifications$configureNotificationClient$completedSettings$2, reason: use source file name */
/* loaded from: classes2.dex */
public final class StoreNotifications3<T1, T2, T3, T4, R> implements Func4<NotificationClient.SettingsV2, String, StoreUserSettingsSystem.Settings, HashSet<Long>, NotificationClient.SettingsV2> {
    public static final StoreNotifications3 INSTANCE = new StoreNotifications3();

    @Override // rx.functions.Func4
    public /* bridge */ /* synthetic */ NotificationClient.SettingsV2 call(NotificationClient.SettingsV2 settingsV2, String str, StoreUserSettingsSystem.Settings settings, HashSet<Long> hashSet) {
        return call2(settingsV2, str, settings, hashSet);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final NotificationClient.SettingsV2 call2(NotificationClient.SettingsV2 settingsV2, String str, StoreUserSettingsSystem.Settings settings, HashSet<Long> hashSet) {
        String locale = settings.getLocale();
        Intrinsics3.checkNotNullExpressionValue(hashSet, "nonSendableChannelIds");
        return NotificationClient.SettingsV2.copy$default(settingsV2, false, false, false, false, false, false, str, locale, hashSet, 63, null);
    }
}
