package com.discord.widgets.stage.sheet;

import androidx.core.app.NotificationCompat;
import com.discord.api.channel.Channel;
import com.discord.api.role.GuildRole;
import com.discord.api.utcdatetime.UtcDateTime;
import com.discord.api.voice.state.VoiceState;
import com.discord.models.member.GuildMember;
import com.discord.stores.StoreGuilds;
import com.discord.stores.StoreStageChannels;
import com.discord.stores.StoreVoiceParticipants;
import com.discord.utilities.guilds.RoleUtils;
import com.discord.utilities.time.Clock;
import com.discord.widgets.stage.StageRoles;
import com.discord.widgets.stage.sheet.WidgetStageRaisedHandsBottomSheetAdapter;
import com.discord.widgets.stage.sheet.WidgetStageRaisedHandsBottomSheetViewModel;
import d0.f0._Sequences2;
import d0.t._Collections;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import j0.k.Func1;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import rx.Observable;
import rx.functions.Func4;

/* compiled from: WidgetStageRaisedHandsBottomSheetViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0007\u001a*\u0012\u000e\b\u0001\u0012\n \u0001*\u0004\u0018\u00010\u00040\u0004 \u0001*\u0014\u0012\u000e\b\u0001\u0012\n \u0001*\u0004\u0018\u00010\u00040\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lcom/discord/api/channel/Channel;", "kotlin.jvm.PlatformType", "channel", "Lrx/Observable;", "Lcom/discord/widgets/stage/sheet/WidgetStageRaisedHandsBottomSheetViewModel$StoreState;", NotificationCompat.CATEGORY_CALL, "(Lcom/discord/api/channel/Channel;)Lrx/Observable;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.stage.sheet.WidgetStageRaisedHandsBottomSheetViewModel$Companion$observeStoreState$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetStageRaisedHandsBottomSheetViewModel2<T, R> implements Func1<Channel, Observable<? extends WidgetStageRaisedHandsBottomSheetViewModel.StoreState>> {
    public final /* synthetic */ long $channelId;
    public final /* synthetic */ Clock $clock;
    public final /* synthetic */ StoreGuilds $guildsStore;
    public final /* synthetic */ StoreStageChannels $stageChannels;
    public final /* synthetic */ StoreVoiceParticipants $voiceParticipants;

    /* compiled from: WidgetStageRaisedHandsBottomSheetViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0011\u001a\n \u0004*\u0004\u0018\u00010\u000e0\u000e2.\u0010\u0005\u001a*\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0012\u0004\u0012\u00020\u0003 \u0004*\u0014\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00000\u000026\u0010\t\u001a2\u0012\b\u0012\u00060\u0001j\u0002`\u0006\u0012\b\u0012\u00060\u0007j\u0002`\b \u0004*\u0018\u0012\b\u0012\u00060\u0001j\u0002`\u0006\u0012\b\u0012\u00060\u0007j\u0002`\b\u0018\u00010\u00000\u00002.\u0010\u000b\u001a*\u0012\b\u0012\u00060\u0001j\u0002`\u0006\u0012\u0004\u0012\u00020\n \u0004*\u0014\u0012\b\u0012\u00060\u0001j\u0002`\u0006\u0012\u0004\u0012\u00020\n\u0018\u00010\u00000\u00002\b\u0010\r\u001a\u0004\u0018\u00010\fH\n¢\u0006\u0004\b\u000f\u0010\u0010"}, d2 = {"", "", "Lcom/discord/primitives/RoleId;", "Lcom/discord/api/role/GuildRole;", "kotlin.jvm.PlatformType", "roles", "Lcom/discord/primitives/UserId;", "Lcom/discord/models/member/GuildMember;", "Lcom/discord/stores/ClientGuildMember;", "members", "Lcom/discord/stores/StoreVoiceParticipants$VoiceUser;", "participants", "Lcom/discord/widgets/stage/StageRoles;", "myStageRoles", "Lcom/discord/widgets/stage/sheet/WidgetStageRaisedHandsBottomSheetViewModel$StoreState;", NotificationCompat.CATEGORY_CALL, "(Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Lcom/discord/widgets/stage/StageRoles;)Lcom/discord/widgets/stage/sheet/WidgetStageRaisedHandsBottomSheetViewModel$StoreState;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.stage.sheet.WidgetStageRaisedHandsBottomSheetViewModel$Companion$observeStoreState$1$1, reason: invalid class name */
    public static final class AnonymousClass1<T1, T2, T3, T4, R> implements Func4<Map<Long, ? extends GuildRole>, Map<Long, ? extends GuildMember>, Map<Long, ? extends StoreVoiceParticipants.VoiceUser>, StageRoles, WidgetStageRaisedHandsBottomSheetViewModel.StoreState> {
        public final /* synthetic */ Channel $channel;

        /* compiled from: WidgetStageRaisedHandsBottomSheetViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/stores/StoreVoiceParticipants$VoiceUser;", "voiceUser", "", "invoke", "(Lcom/discord/stores/StoreVoiceParticipants$VoiceUser;)Z", "<anonymous>"}, k = 3, mv = {1, 4, 2})
        /* renamed from: com.discord.widgets.stage.sheet.WidgetStageRaisedHandsBottomSheetViewModel$Companion$observeStoreState$1$1$1, reason: invalid class name and collision with other inner class name */
        public static final class C03461 extends Lambda implements Function1<StoreVoiceParticipants.VoiceUser, Boolean> {
            public static final C03461 INSTANCE = new C03461();

            public C03461() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Boolean invoke(StoreVoiceParticipants.VoiceUser voiceUser) {
                return Boolean.valueOf(invoke2(voiceUser));
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final boolean invoke2(StoreVoiceParticipants.VoiceUser voiceUser) {
                Intrinsics3.checkNotNullParameter(voiceUser, "voiceUser");
                return voiceUser.getIsRequestingToSpeak();
            }
        }

        /* compiled from: WidgetStageRaisedHandsBottomSheetViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/stores/StoreVoiceParticipants$VoiceUser;", "voiceUser", "Lcom/discord/widgets/stage/sheet/WidgetStageRaisedHandsBottomSheetAdapter$ListItem$Participant;", "invoke", "(Lcom/discord/stores/StoreVoiceParticipants$VoiceUser;)Lcom/discord/widgets/stage/sheet/WidgetStageRaisedHandsBottomSheetAdapter$ListItem$Participant;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
        /* renamed from: com.discord.widgets.stage.sheet.WidgetStageRaisedHandsBottomSheetViewModel$Companion$observeStoreState$1$1$2, reason: invalid class name */
        public static final class AnonymousClass2 extends Lambda implements Function1<StoreVoiceParticipants.VoiceUser, WidgetStageRaisedHandsBottomSheetAdapter.ListItem.Participant> {
            public final /* synthetic */ Map $members;
            public final /* synthetic */ Map $roles;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass2(Map map, Map map2) {
                super(1);
                this.$members = map;
                this.$roles = map2;
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ WidgetStageRaisedHandsBottomSheetAdapter.ListItem.Participant invoke(StoreVoiceParticipants.VoiceUser voiceUser) {
                return invoke2(voiceUser);
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final WidgetStageRaisedHandsBottomSheetAdapter.ListItem.Participant invoke2(StoreVoiceParticipants.VoiceUser voiceUser) {
                UtcDateTime utcDateTime;
                Intrinsics3.checkNotNullParameter(voiceUser, "voiceUser");
                VoiceState voiceState = voiceUser.getVoiceState();
                if (voiceState == null || (utcDateTime = voiceState.getRequestToSpeakTimestamp()) == null) {
                    utcDateTime = new UtcDateTime(WidgetStageRaisedHandsBottomSheetViewModel2.this.$clock.currentTimeMillis());
                }
                GuildMember guildMember = (GuildMember) this.$members.get(Long.valueOf(voiceUser.getUser().getId()));
                Map map = this.$roles;
                Intrinsics3.checkNotNullExpressionValue(map, "roles");
                return new WidgetStageRaisedHandsBottomSheetAdapter.ListItem.Participant(voiceUser, utcDateTime, guildMember, RoleUtils.getHighestHoistedRole(map, (GuildMember) this.$members.get(Long.valueOf(voiceUser.getUser().getId()))));
            }
        }

        public AnonymousClass1(Channel channel) {
            this.$channel = channel;
        }

        @Override // rx.functions.Func4
        public /* bridge */ /* synthetic */ WidgetStageRaisedHandsBottomSheetViewModel.StoreState call(Map<Long, ? extends GuildRole> map, Map<Long, ? extends GuildMember> map2, Map<Long, ? extends StoreVoiceParticipants.VoiceUser> map3, StageRoles stageRoles) {
            return call2((Map<Long, GuildRole>) map, (Map<Long, GuildMember>) map2, (Map<Long, StoreVoiceParticipants.VoiceUser>) map3, stageRoles);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final WidgetStageRaisedHandsBottomSheetViewModel.StoreState call2(Map<Long, GuildRole> map, Map<Long, GuildMember> map2, Map<Long, StoreVoiceParticipants.VoiceUser> map3, StageRoles stageRoles) {
            Channel channel = this.$channel;
            Intrinsics3.checkNotNullExpressionValue(channel, "channel");
            Intrinsics3.checkNotNullExpressionValue(map, "roles");
            return new WidgetStageRaisedHandsBottomSheetViewModel.StoreState(channel, map, _Sequences2.toList(_Sequences2.sortedWith(_Sequences2.map(_Sequences2.filter(_Collections.asSequence(map3.values()), C03461.INSTANCE), new AnonymousClass2(map2, map)), new WidgetStageRaisedHandsBottomSheetViewModel$Companion$observeStoreState$1$1$$special$$inlined$sortedBy$1())), stageRoles != null ? stageRoles.m35unboximpl() : StageRoles.INSTANCE.m37getAUDIENCE1LxfuJo(), null);
        }
    }

    public WidgetStageRaisedHandsBottomSheetViewModel2(StoreGuilds storeGuilds, StoreVoiceParticipants storeVoiceParticipants, long j, StoreStageChannels storeStageChannels, Clock clock) {
        this.$guildsStore = storeGuilds;
        this.$voiceParticipants = storeVoiceParticipants;
        this.$channelId = j;
        this.$stageChannels = storeStageChannels;
        this.$clock = clock;
    }

    @Override // j0.k.Func1
    public /* bridge */ /* synthetic */ Observable<? extends WidgetStageRaisedHandsBottomSheetViewModel.StoreState> call(Channel channel) {
        return call2(channel);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends WidgetStageRaisedHandsBottomSheetViewModel.StoreState> call2(Channel channel) {
        return Observable.h(this.$guildsStore.observeRoles(channel.getGuildId()), this.$guildsStore.observeComputed(channel.getGuildId()), this.$voiceParticipants.get(this.$channelId), this.$stageChannels.observeMyRoles(this.$channelId), new AnonymousClass1(channel));
    }
}
