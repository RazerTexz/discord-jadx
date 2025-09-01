package com.discord.widgets.voice.fullscreen;

import androidx.core.app.NotificationCompat;
import b.d.b.a.outline;
import com.discord.api.channel.Channel;
import com.discord.api.user.NsfwAllowance;
import com.discord.models.user.MeUser;
import com.discord.stores.StoreChannelsSelected;
import com.discord.stores.StoreMentions;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUser;
import com.discord.stores.StoreVoiceChannelSelected;
import com.discord.widgets.chat.list.TextInVoiceFeatureFlag;
import com.discord.widgets.voice.fullscreen.WidgetCallPreviewFullscreenViewModel;
import com.discord.widgets.voice.model.CallModel;
import d0.z.d.Intrinsics3;
import j0.k.Func1;
import java.util.Map;
import kotlin.Metadata;
import rx.Observable;
import rx.functions.Func7;

/* compiled from: WidgetCallPreviewFullscreenViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0007\u001a*\u0012\u000e\b\u0001\u0012\n \u0004*\u0004\u0018\u00010\u00030\u0003 \u0004*\u0014\u0012\u000e\b\u0001\u0012\n \u0004*\u0004\u0018\u00010\u00030\u0003\u0018\u00010\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lcom/discord/api/channel/Channel;", "voiceChannel", "Lrx/Observable;", "Lcom/discord/widgets/voice/fullscreen/WidgetCallPreviewFullscreenViewModel$StoreState;", "kotlin.jvm.PlatformType", NotificationCompat.CATEGORY_CALL, "(Lcom/discord/api/channel/Channel;)Lrx/Observable;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.voice.fullscreen.WidgetCallPreviewFullscreenViewModel$Companion$observeStoreState$1, reason: use source file name */
/* loaded from: classes.dex */
public final class WidgetCallPreviewFullscreenViewModel2<T, R> implements Func1<Channel, Observable<? extends WidgetCallPreviewFullscreenViewModel.StoreState>> {
    public final /* synthetic */ StoreChannelsSelected $storeChannelsSelected;
    public final /* synthetic */ StoreMentions $storeMentions;
    public final /* synthetic */ StoreUser $storeUser;
    public final /* synthetic */ StoreVoiceChannelSelected $storeVoiceChannelSelected;
    public final /* synthetic */ long $voiceChannelId;

    /* compiled from: WidgetCallPreviewFullscreenViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0013\u001a\n \u0001*\u0004\u0018\u00010\u00100\u00102\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u00002\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u000e\u0010\u0006\u001a\n \u0001*\u0004\u0018\u00010\u00050\u00052\u000e\u0010\b\u001a\n \u0001*\u0004\u0018\u00010\u00070\u00072.\u0010\f\u001a*\u0012\b\u0012\u00060\nj\u0002`\u000b\u0012\u0004\u0012\u00020\u0007 \u0001*\u0014\u0012\b\u0012\u00060\nj\u0002`\u000b\u0012\u0004\u0012\u00020\u0007\u0018\u00010\t0\t2\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0004\b\u0011\u0010\u0012"}, d2 = {"Lcom/discord/models/user/MeUser;", "kotlin.jvm.PlatformType", "meUser", "Lcom/discord/api/channel/Channel;", "selectedTextChannel", "", "isTextInVoiceEnabled", "", "totalMentionsCount", "", "", "Lcom/discord/primitives/ChannelId;", "mentionsMap", "Lcom/discord/widgets/voice/model/CallModel;", "callModel", "selectedVoiceChannel", "Lcom/discord/widgets/voice/fullscreen/WidgetCallPreviewFullscreenViewModel$StoreState;", NotificationCompat.CATEGORY_CALL, "(Lcom/discord/models/user/MeUser;Lcom/discord/api/channel/Channel;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/util/Map;Lcom/discord/widgets/voice/model/CallModel;Lcom/discord/api/channel/Channel;)Lcom/discord/widgets/voice/fullscreen/WidgetCallPreviewFullscreenViewModel$StoreState;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.voice.fullscreen.WidgetCallPreviewFullscreenViewModel$Companion$observeStoreState$1$1, reason: invalid class name */
    public static final class AnonymousClass1<T1, T2, T3, T4, T5, T6, T7, R> implements Func7<MeUser, Channel, Boolean, Integer, Map<Long, ? extends Integer>, CallModel, Channel, WidgetCallPreviewFullscreenViewModel.StoreState> {
        public final /* synthetic */ Channel $voiceChannel;

        public AnonymousClass1(Channel channel) {
            this.$voiceChannel = channel;
        }

        @Override // rx.functions.Func7
        public /* bridge */ /* synthetic */ WidgetCallPreviewFullscreenViewModel.StoreState call(MeUser meUser, Channel channel, Boolean bool, Integer num, Map<Long, ? extends Integer> map, CallModel callModel, Channel channel2) {
            return call2(meUser, channel, bool, num, (Map<Long, Integer>) map, callModel, channel2);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final WidgetCallPreviewFullscreenViewModel.StoreState call2(MeUser meUser, Channel channel, Boolean bool, Integer num, Map<Long, Integer> map, CallModel callModel, Channel channel2) {
            if (callModel == null || this.$voiceChannel == null || channel == null) {
                return WidgetCallPreviewFullscreenViewModel.StoreState.Invalid.INSTANCE;
            }
            boolean z2 = !StoreStream.INSTANCE.getGuildsNsfw().isGuildNsfwGateAgreed(this.$voiceChannel.getGuildId());
            boolean nsfw = this.$voiceChannel.getNsfw();
            NsfwAllowance nsfwAllowance = meUser != null ? meUser.getNsfwAllowance() : null;
            Channel channel3 = this.$voiceChannel;
            Intrinsics3.checkNotNullExpressionValue(bool, "isTextInVoiceEnabled");
            boolean zBooleanValue = bool.booleanValue();
            Intrinsics3.checkNotNullExpressionValue(num, "totalMentionsCount");
            int iIntValue = num.intValue();
            Integer num2 = (Integer) outline.d(this.$voiceChannel, map);
            return new WidgetCallPreviewFullscreenViewModel.StoreState.Valid(channel3, channel, zBooleanValue, iIntValue, num2 != null ? num2.intValue() : 0, z2, nsfw, nsfwAllowance, callModel, channel2);
        }
    }

    public WidgetCallPreviewFullscreenViewModel2(StoreUser storeUser, StoreChannelsSelected storeChannelsSelected, StoreMentions storeMentions, long j, StoreVoiceChannelSelected storeVoiceChannelSelected) {
        this.$storeUser = storeUser;
        this.$storeChannelsSelected = storeChannelsSelected;
        this.$storeMentions = storeMentions;
        this.$voiceChannelId = j;
        this.$storeVoiceChannelSelected = storeVoiceChannelSelected;
    }

    @Override // j0.k.Func1
    public /* bridge */ /* synthetic */ Observable<? extends WidgetCallPreviewFullscreenViewModel.StoreState> call(Channel channel) {
        return call2(channel);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends WidgetCallPreviewFullscreenViewModel.StoreState> call2(Channel channel) {
        return Observable.e(StoreUser.observeMe$default(this.$storeUser, false, 1, null), this.$storeChannelsSelected.observeSelectedChannel(), TextInVoiceFeatureFlag.INSTANCE.getINSTANCE().observeEnabled(channel != null ? Long.valueOf(channel.getGuildId()) : null), this.$storeMentions.observeTotalMentions(), this.$storeMentions.observeMentionCounts(), CallModel.INSTANCE.get(this.$voiceChannelId), this.$storeVoiceChannelSelected.observeSelectedChannel(), new AnonymousClass1(channel));
    }
}
