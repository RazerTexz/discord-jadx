package com.discord.widgets.channels.settings;

import androidx.core.app.NotificationCompat;
import com.discord.api.channel.Channel;
import com.discord.models.domain.ModelNotificationSettings;
import com.discord.stores.StoreUserGuildSettings;
import com.discord.widgets.channels.settings.ChannelGroupDMSettingsViewModel;
import d0.z.d.Intrinsics3;
import j0.k.Func1;
import j0.l.e.ScalarSynchronousObservable;
import kotlin.Metadata;
import rx.Observable;
import rx.functions.Func2;

/* compiled from: ChannelGroupDMSettingsViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0007\u001a*\u0012\u000e\b\u0001\u0012\n \u0004*\u0004\u0018\u00010\u00030\u0003 \u0004*\u0014\u0012\u000e\b\u0001\u0012\n \u0004*\u0004\u0018\u00010\u00030\u0003\u0018\u00010\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lcom/discord/api/channel/Channel;", "nullableChannel", "Lrx/Observable;", "Lcom/discord/widgets/channels/settings/ChannelGroupDMSettingsViewModel$StoreState;", "kotlin.jvm.PlatformType", NotificationCompat.CATEGORY_CALL, "(Lcom/discord/api/channel/Channel;)Lrx/Observable;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.channels.settings.ChannelGroupDMSettingsViewModel$Companion$observeStoreState$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class ChannelGroupDMSettingsViewModel2<T, R> implements Func1<Channel, Observable<? extends ChannelGroupDMSettingsViewModel.StoreState>> {
    public final /* synthetic */ StoreUserGuildSettings $storeUserGuildSettings;

    /* compiled from: ChannelGroupDMSettingsViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\b\u001a\n \u0001*\u0004\u0018\u00010\u00050\u00052\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u00002\u000e\u0010\u0004\u001a\n \u0001*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"Lcom/discord/api/channel/Channel;", "kotlin.jvm.PlatformType", "channel", "Lcom/discord/models/domain/ModelNotificationSettings;", "notificationSettings", "Lcom/discord/widgets/channels/settings/ChannelGroupDMSettingsViewModel$StoreState$Valid;", NotificationCompat.CATEGORY_CALL, "(Lcom/discord/api/channel/Channel;Lcom/discord/models/domain/ModelNotificationSettings;)Lcom/discord/widgets/channels/settings/ChannelGroupDMSettingsViewModel$StoreState$Valid;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.channels.settings.ChannelGroupDMSettingsViewModel$Companion$observeStoreState$1$1, reason: invalid class name */
    public static final class AnonymousClass1<T1, T2, R> implements Func2<Channel, ModelNotificationSettings, ChannelGroupDMSettingsViewModel.StoreState.Valid> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        @Override // rx.functions.Func2
        public /* bridge */ /* synthetic */ ChannelGroupDMSettingsViewModel.StoreState.Valid call(Channel channel, ModelNotificationSettings modelNotificationSettings) {
            return call2(channel, modelNotificationSettings);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final ChannelGroupDMSettingsViewModel.StoreState.Valid call2(Channel channel, ModelNotificationSettings modelNotificationSettings) {
            Intrinsics3.checkNotNullExpressionValue(channel, "channel");
            Intrinsics3.checkNotNullExpressionValue(modelNotificationSettings, "notificationSettings");
            return new ChannelGroupDMSettingsViewModel.StoreState.Valid(channel, modelNotificationSettings);
        }
    }

    public ChannelGroupDMSettingsViewModel2(StoreUserGuildSettings storeUserGuildSettings) {
        this.$storeUserGuildSettings = storeUserGuildSettings;
    }

    @Override // j0.k.Func1
    public /* bridge */ /* synthetic */ Observable<? extends ChannelGroupDMSettingsViewModel.StoreState> call(Channel channel) {
        return call2(channel);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends ChannelGroupDMSettingsViewModel.StoreState> call2(Channel channel) {
        return channel == null ? new ScalarSynchronousObservable(ChannelGroupDMSettingsViewModel.StoreState.Invalid.INSTANCE) : Observable.j(new ScalarSynchronousObservable(channel), this.$storeUserGuildSettings.observeGuildSettings(channel.getGuildId()), AnonymousClass1.INSTANCE);
    }
}
