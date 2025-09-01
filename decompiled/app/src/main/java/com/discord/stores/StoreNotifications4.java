package com.discord.stores;

import com.discord.utilities.fcm.NotificationClient;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* compiled from: StoreNotifications.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/discord/utilities/fcm/NotificationClient$SettingsV2;", "it", "invoke", "(Lcom/discord/utilities/fcm/NotificationClient$SettingsV2;)Lcom/discord/utilities/fcm/NotificationClient$SettingsV2;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.stores.StoreNotifications$setEnabledInApp$oldValue$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class StoreNotifications4 extends Lambda implements Function1<NotificationClient.SettingsV2, NotificationClient.SettingsV2> {
    public final /* synthetic */ boolean $isEnabledInApp;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreNotifications4(boolean z2) {
        super(1);
        this.$isEnabledInApp = z2;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ NotificationClient.SettingsV2 invoke(NotificationClient.SettingsV2 settingsV2) {
        return invoke2(settingsV2);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final NotificationClient.SettingsV2 invoke2(NotificationClient.SettingsV2 settingsV2) {
        Intrinsics3.checkNotNullParameter(settingsV2, "it");
        return NotificationClient.SettingsV2.copy$default(settingsV2, false, this.$isEnabledInApp, false, false, false, false, null, null, null, 509, null);
    }
}
