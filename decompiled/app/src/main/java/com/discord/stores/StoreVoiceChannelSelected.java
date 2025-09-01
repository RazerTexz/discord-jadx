package com.discord.stores;

import b.d.b.a.outline;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.api.guild.GuildMaxVideoChannelUsers;
import com.discord.api.guild.GuildVerificationLevel;
import com.discord.api.stageinstance.StageInstance;
import com.discord.api.voice.state.VoiceState;
import com.discord.models.domain.ModelApplicationStream;
import com.discord.models.domain.ModelPayload;
import com.discord.models.guild.Guild;
import com.discord.models.member.GuildMember;
import com.discord.models.user.MeUser;
import com.discord.rtcconnection.RtcConnection;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeck4;
import com.discord.utilities.guildmember.GuildMemberUtils;
import com.discord.utilities.media.AppSound;
import com.discord.utilities.media.AppSoundManager;
import com.discord.utilities.time.Clock;
import com.discord.utilities.user.UserUtils;
import com.discord.utilities.voice.VoiceChannelJoinabilityUtils;
import com.discord.utilities.voice.VoiceChannelJoinabilityUtils2;
import d0.t.Maps6;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.Collection;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;
import rx.subjects.PublishSubject;

/* compiled from: StoreVoiceChannelSelected.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000²\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 [2\u00020\u00012\u00020\u0002:\u0002[\\B)\u0012\u0006\u0010P\u001a\u00020O\u0012\u0006\u0010F\u001a\u00020E\u0012\u0006\u0010V\u001a\u00020U\u0012\b\b\u0002\u0010I\u001a\u00020H¢\u0006\u0004\bY\u0010ZJ#\u0010\t\u001a\u00020\b2\n\u0010\u0005\u001a\u00060\u0003j\u0002`\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0003¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH\u0003¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u000bH\u0003¢\u0006\u0004\b\u000e\u0010\rJ\u0017\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u000fH\u0003¢\u0006\u0004\b\u0012\u0010\u0013J\u001b\u0010\u0016\u001a\u00020\u00152\n\u0010\u0014\u001a\u00060\u0003j\u0002`\u0004H\u0003¢\u0006\u0004\b\u0016\u0010\u0017J\u0011\u0010\u0018\u001a\u00060\u0003j\u0002`\u0004¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001b\u001a\u0004\u0018\u00010\u001a¢\u0006\u0004\b\u001b\u0010\u001cJ\u0011\u0010\u001d\u001a\u00060\u0003j\u0002`\u0004¢\u0006\u0004\b\u001d\u0010\u0019J\u0017\u0010\u001f\u001a\f\u0012\b\u0012\u00060\u0003j\u0002`\u00040\u001e¢\u0006\u0004\b\u001f\u0010 J\u0017\u0010\"\u001a\f\u0012\b\u0012\u00060\u0003j\u0002`!0\u001e¢\u0006\u0004\b\"\u0010 J\u0011\u0010#\u001a\u00060\u0003j\u0002`!¢\u0006\u0004\b#\u0010\u0019J\u0015\u0010$\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001a0\u001e¢\u0006\u0004\b$\u0010 J\u001f\u0010%\u001a\b\u0012\u0004\u0012\u00020\b0\u001e2\n\u0010\u0014\u001a\u00060\u0003j\u0002`\u0004¢\u0006\u0004\b%\u0010&J\r\u0010'\u001a\u00020\u000b¢\u0006\u0004\b'\u0010\rJ\u0017\u0010*\u001a\u00020\u000b2\u0006\u0010)\u001a\u00020(H\u0007¢\u0006\u0004\b*\u0010+J\u000f\u0010,\u001a\u00020\u000bH\u0007¢\u0006\u0004\b,\u0010\rJ\u000f\u0010-\u001a\u00020\u000bH\u0007¢\u0006\u0004\b-\u0010\rJ\u000f\u0010.\u001a\u00020\u000bH\u0007¢\u0006\u0004\b.\u0010\rJ\u000f\u0010/\u001a\u00020\u000bH\u0007¢\u0006\u0004\b/\u0010\rJ\u000f\u00100\u001a\u00020\u000bH\u0007¢\u0006\u0004\b0\u0010\rJ\u0017\u00103\u001a\u00020\u000b2\u0006\u00102\u001a\u000201H\u0007¢\u0006\u0004\b3\u00104J\u0017\u00107\u001a\u00020\u000b2\u0006\u00106\u001a\u000205H\u0007¢\u0006\u0004\b7\u00108J\u0019\u0010;\u001a\u00020\u000b2\b\u0010:\u001a\u0004\u0018\u000109H\u0007¢\u0006\u0004\b;\u0010<J\u001b\u0010?\u001a\u00020\u000b2\n\u0010>\u001a\u000609j\u0002`=H\u0007¢\u0006\u0004\b?\u0010<J\u0017\u0010B\u001a\u00020\u000b2\u0006\u0010A\u001a\u00020@H\u0007¢\u0006\u0004\bB\u0010CJ\u000f\u0010D\u001a\u00020\u000bH\u0017¢\u0006\u0004\bD\u0010\rR\u0016\u0010F\u001a\u00020E8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bF\u0010GR\u0016\u0010I\u001a\u00020H8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bI\u0010JR\u001a\u0010K\u001a\u00060\u0003j\u0002`!8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bK\u0010LR\u001e\u0010M\u001a\n\u0018\u00010\u0003j\u0004\u0018\u0001`\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bM\u0010NR\u0016\u0010P\u001a\u00020O8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bP\u0010QR\u001e\u0010S\u001a\n\u0018\u000109j\u0004\u0018\u0001`R8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bS\u0010TR\u0016\u0010V\u001a\u00020U8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bV\u0010WR\u001a\u0010X\u001a\u00060\u0003j\u0002`\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bX\u0010LR\u001a\u0010\u0005\u001a\u00060\u0003j\u0002`\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0005\u0010L¨\u0006]"}, d2 = {"Lcom/discord/stores/StoreVoiceChannelSelected;", "Lcom/discord/stores/StoreV2;", "Lcom/discord/stores/DispatchHandler;", "", "Lcom/discord/primitives/ChannelId;", "selectedVoiceChannelId", "", "forceMoved", "Lcom/discord/stores/StoreVoiceChannelSelected$JoinVoiceChannelResult;", "selectVoiceChannelInternal", "(JZ)Lcom/discord/stores/StoreVoiceChannelSelected$JoinVoiceChannelResult;", "", "clearInternal", "()V", "validateSelectedVoiceChannel", "Lcom/discord/models/guild/Guild;", "guild", "Lcom/discord/api/guild/GuildVerificationLevel;", "getVerificationLevelTriggered", "(Lcom/discord/models/guild/Guild;)Lcom/discord/api/guild/GuildVerificationLevel;", "channelId", "Lcom/discord/utilities/voice/VoiceChannelJoinability;", "getJoinability", "(J)Lcom/discord/utilities/voice/VoiceChannelJoinability;", "getSelectedVoiceChannelId", "()J", "Lcom/discord/api/channel/Channel;", "getSelectedVoiceChannel", "()Lcom/discord/api/channel/Channel;", "getLastSelectedVoiceChannelId", "Lrx/Observable;", "observeSelectedVoiceChannelId", "()Lrx/Observable;", "Lcom/discord/primitives/Timestamp;", "observeTimeSelectedMs", "getTimeSelectedMs", "observeSelectedChannel", "selectVoiceChannel", "(J)Lrx/Observable;", "clear", "Lcom/discord/models/domain/ModelPayload;", "payload", "handleConnectionOpen", "(Lcom/discord/models/domain/ModelPayload;)V", "handleGuildRemove", "handleChannelOrThreadCreateOrUpdate", "handleChannelOrThreadDelete", "handleGuildRoleRemove", "handleGuildRoleCreateOrUpdate", "Lcom/discord/api/guildmember/GuildMember;", "member", "handleGuildMemberAdd", "(Lcom/discord/api/guildmember/GuildMember;)V", "Lcom/discord/api/voice/state/VoiceState;", "voiceState", "handleVoiceStateUpdates", "(Lcom/discord/api/voice/state/VoiceState;)V", "", "authToken", "handleAuthToken", "(Ljava/lang/String;)V", "Lcom/discord/primitives/StreamKey;", "streamKey", "handleStreamTargeted", "Lcom/discord/rtcconnection/RtcConnection$State;", "state", "handleRtcConnectionStateChanged", "(Lcom/discord/rtcconnection/RtcConnection$State;)V", "snapshotData", "Lcom/discord/stores/Dispatcher;", "dispatcher", "Lcom/discord/stores/Dispatcher;", "Lcom/discord/stores/updates/ObservationDeck;", "observationDeck", "Lcom/discord/stores/updates/ObservationDeck;", "timeSelectedMs", "J", "preselectedVoiceChannelId", "Ljava/lang/Long;", "Lcom/discord/stores/StoreStream;", "stream", "Lcom/discord/stores/StoreStream;", "Lcom/discord/primitives/SessionId;", "sessionId", "Ljava/lang/String;", "Lcom/discord/utilities/time/Clock;", "clock", "Lcom/discord/utilities/time/Clock;", "lastSelectedVoiceChannelId", "<init>", "(Lcom/discord/stores/StoreStream;Lcom/discord/stores/Dispatcher;Lcom/discord/utilities/time/Clock;Lcom/discord/stores/updates/ObservationDeck;)V", "Companion", "JoinVoiceChannelResult", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class StoreVoiceChannelSelected extends StoreV2 implements Store2 {
    public static final long VOICE_CHANNEL_ID_NONE = 0;
    private final Clock clock;
    private final Dispatcher dispatcher;
    private long lastSelectedVoiceChannelId;
    private final ObservationDeck observationDeck;
    private Long preselectedVoiceChannelId;
    private long selectedVoiceChannelId;
    private String sessionId;
    private final StoreStream stream;
    private long timeSelectedMs;

    /* compiled from: StoreVoiceChannelSelected.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\n\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/discord/stores/StoreVoiceChannelSelected$JoinVoiceChannelResult;", "", "<init>", "(Ljava/lang/String;I)V", "SUCCESS", "DEFERRED_UNTIL_SESSION_START", "ALREADY_CONNECTED", "FAILED_PERMISSIONS_MISSING", "FAILED_GUILD_VIDEO_AT_CAPACITY", "FAILED_CHANNEL_FULL", "FAILED_CHANNEL_DOES_NOT_EXIST", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public enum JoinVoiceChannelResult {
        SUCCESS,
        DEFERRED_UNTIL_SESSION_START,
        ALREADY_CONNECTED,
        FAILED_PERMISSIONS_MISSING,
        FAILED_GUILD_VIDEO_AT_CAPACITY,
        FAILED_CHANNEL_FULL,
        FAILED_CHANNEL_DOES_NOT_EXIST
    }

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;
        public static final /* synthetic */ int[] $EnumSwitchMapping$2;

        static {
            VoiceChannelJoinabilityUtils2.values();
            int[] iArr = new int[5];
            $EnumSwitchMapping$0 = iArr;
            VoiceChannelJoinabilityUtils2 voiceChannelJoinabilityUtils2 = VoiceChannelJoinabilityUtils2.CAN_JOIN;
            iArr[voiceChannelJoinabilityUtils2.ordinal()] = 1;
            VoiceChannelJoinabilityUtils2 voiceChannelJoinabilityUtils22 = VoiceChannelJoinabilityUtils2.PERMISSIONS_MISSING;
            iArr[voiceChannelJoinabilityUtils22.ordinal()] = 2;
            VoiceChannelJoinabilityUtils2 voiceChannelJoinabilityUtils23 = VoiceChannelJoinabilityUtils2.CHANNEL_FULL;
            iArr[voiceChannelJoinabilityUtils23.ordinal()] = 3;
            VoiceChannelJoinabilityUtils2 voiceChannelJoinabilityUtils24 = VoiceChannelJoinabilityUtils2.GUILD_VIDEO_AT_CAPACITY;
            iArr[voiceChannelJoinabilityUtils24.ordinal()] = 4;
            VoiceChannelJoinabilityUtils2 voiceChannelJoinabilityUtils25 = VoiceChannelJoinabilityUtils2.CHANNEL_DOES_NOT_EXIST;
            iArr[voiceChannelJoinabilityUtils25.ordinal()] = 5;
            VoiceChannelJoinabilityUtils2.values();
            int[] iArr2 = new int[5];
            $EnumSwitchMapping$1 = iArr2;
            iArr2[voiceChannelJoinabilityUtils22.ordinal()] = 1;
            iArr2[voiceChannelJoinabilityUtils24.ordinal()] = 2;
            iArr2[voiceChannelJoinabilityUtils23.ordinal()] = 3;
            iArr2[voiceChannelJoinabilityUtils25.ordinal()] = 4;
            iArr2[voiceChannelJoinabilityUtils2.ordinal()] = 5;
            GuildVerificationLevel.values();
            int[] iArr3 = new int[5];
            $EnumSwitchMapping$2 = iArr3;
            iArr3[GuildVerificationLevel.HIGHEST.ordinal()] = 1;
            iArr3[GuildVerificationLevel.HIGH.ordinal()] = 2;
            iArr3[GuildVerificationLevel.MEDIUM.ordinal()] = 3;
            iArr3[GuildVerificationLevel.LOW.ordinal()] = 4;
            iArr3[GuildVerificationLevel.NONE.ordinal()] = 5;
        }
    }

    /* compiled from: StoreVoiceChannelSelected.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreVoiceChannelSelected$clear$1, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function0<Unit> {
        public AnonymousClass1(StoreVoiceChannelSelected storeVoiceChannelSelected) {
            super(0, storeVoiceChannelSelected, StoreVoiceChannelSelected.class, "clearInternal", "clearInternal()V", 0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            StoreVoiceChannelSelected.access$clearInternal((StoreVoiceChannelSelected) this.receiver);
        }
    }

    /* compiled from: StoreVoiceChannelSelected.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lcom/discord/api/channel/Channel;", "invoke", "()Lcom/discord/api/channel/Channel;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreVoiceChannelSelected$observeSelectedChannel$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<Channel> {
        public AnonymousClass1() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Channel invoke() {
            return invoke();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final Channel invoke() {
            return StoreVoiceChannelSelected.access$getStream$p(StoreVoiceChannelSelected.this).getChannels().findChannelByIdInternal$app_productionGoogleRelease(StoreVoiceChannelSelected.access$getSelectedVoiceChannelId$p(StoreVoiceChannelSelected.this));
        }
    }

    /* compiled from: StoreVoiceChannelSelected.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00060\u0000j\u0002`\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"", "Lcom/discord/primitives/ChannelId;", "invoke", "()J", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreVoiceChannelSelected$observeSelectedVoiceChannelId$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<Long> {
        public AnonymousClass1() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Long invoke() {
            return Long.valueOf(invoke2());
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final long invoke2() {
            return StoreVoiceChannelSelected.access$getSelectedVoiceChannelId$p(StoreVoiceChannelSelected.this);
        }
    }

    /* compiled from: StoreVoiceChannelSelected.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00060\u0000j\u0002`\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"", "Lcom/discord/primitives/Timestamp;", "invoke", "()J", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreVoiceChannelSelected$observeTimeSelectedMs$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<Long> {
        public AnonymousClass1() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Long invoke() {
            return Long.valueOf(invoke2());
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final long invoke2() {
            return StoreVoiceChannelSelected.access$getTimeSelectedMs$p(StoreVoiceChannelSelected.this);
        }
    }

    /* compiled from: StoreVoiceChannelSelected.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreVoiceChannelSelected$selectVoiceChannel$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ long $channelId;
        public final /* synthetic */ PublishSubject $resultSubject;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(long j, PublishSubject publishSubject) {
            super(0);
            this.$channelId = j;
            this.$resultSubject = publishSubject;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            this.$resultSubject.k.onNext(StoreVoiceChannelSelected.access$selectVoiceChannelInternal(StoreVoiceChannelSelected.this, this.$channelId, false));
            this.$resultSubject.k.onCompleted();
        }
    }

    public /* synthetic */ StoreVoiceChannelSelected(StoreStream storeStream, Dispatcher dispatcher, Clock clock, ObservationDeck observationDeck, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(storeStream, dispatcher, clock, (i & 8) != 0 ? ObservationDeck4.get() : observationDeck);
    }

    public static final /* synthetic */ void access$clearInternal(StoreVoiceChannelSelected storeVoiceChannelSelected) {
        storeVoiceChannelSelected.clearInternal();
    }

    public static final /* synthetic */ long access$getSelectedVoiceChannelId$p(StoreVoiceChannelSelected storeVoiceChannelSelected) {
        return storeVoiceChannelSelected.selectedVoiceChannelId;
    }

    public static final /* synthetic */ StoreStream access$getStream$p(StoreVoiceChannelSelected storeVoiceChannelSelected) {
        return storeVoiceChannelSelected.stream;
    }

    public static final /* synthetic */ long access$getTimeSelectedMs$p(StoreVoiceChannelSelected storeVoiceChannelSelected) {
        return storeVoiceChannelSelected.timeSelectedMs;
    }

    public static final /* synthetic */ JoinVoiceChannelResult access$selectVoiceChannelInternal(StoreVoiceChannelSelected storeVoiceChannelSelected, long j, boolean z2) {
        return storeVoiceChannelSelected.selectVoiceChannelInternal(j, z2);
    }

    public static final /* synthetic */ void access$setSelectedVoiceChannelId$p(StoreVoiceChannelSelected storeVoiceChannelSelected, long j) {
        storeVoiceChannelSelected.selectedVoiceChannelId = j;
    }

    public static final /* synthetic */ void access$setTimeSelectedMs$p(StoreVoiceChannelSelected storeVoiceChannelSelected, long j) {
        storeVoiceChannelSelected.timeSelectedMs = j;
    }

    @Store3
    private final void clearInternal() {
        Channel channel = StoreStream.INSTANCE.getChannels().getChannel(this.selectedVoiceChannelId);
        if (channel != null && ChannelUtils.K(channel)) {
            AppSoundManager.Provider.INSTANCE.get().play(AppSound.INSTANCE.getSOUND_USER_LEFT());
        }
        selectVoiceChannelInternal(0L, false);
    }

    @Store3
    private final VoiceChannelJoinabilityUtils2 getJoinability(long channelId) {
        GuildMaxVideoChannelUsers maxVideoChannelUsers;
        StoreChannels channels = this.stream.getChannels();
        StoreGuilds guilds = this.stream.getGuilds();
        StorePermissions permissions = this.stream.getPermissions();
        StoreVoiceStates voiceStates = this.stream.getVoiceStates();
        StoreStageInstances stageInstances = this.stream.getStageInstances();
        Channel channelFindChannelByIdInternal$app_productionGoogleRelease = channels.findChannelByIdInternal$app_productionGoogleRelease(channelId);
        if (channelFindChannelByIdInternal$app_productionGoogleRelease == null) {
            return VoiceChannelJoinabilityUtils2.CHANNEL_DOES_NOT_EXIST;
        }
        StageInstance stageInstanceForChannelInternal = stageInstances.getStageInstanceForChannelInternal(channelId);
        Map mapEmptyMap = (Map) outline.c(channelFindChannelByIdInternal$app_productionGoogleRelease, voiceStates.get());
        if (mapEmptyMap == null) {
            mapEmptyMap = Maps6.emptyMap();
        }
        Long l = permissions.getPermissionsByChannel().get(Long.valueOf(channelId));
        Guild guild = (Guild) outline.c(channelFindChannelByIdInternal$app_productionGoogleRelease, guilds.getGuilds());
        GuildVerificationLevel verificationLevelTriggered = guild != null ? getVerificationLevelTriggered(guild) : GuildVerificationLevel.NONE;
        VoiceChannelJoinabilityUtils voiceChannelJoinabilityUtils = VoiceChannelJoinabilityUtils.INSTANCE;
        Collection<VoiceState> collectionValues = mapEmptyMap.values();
        if (guild == null || (maxVideoChannelUsers = guild.getMaxVideoChannelUsers()) == null) {
            maxVideoChannelUsers = GuildMaxVideoChannelUsers.Unlimited.INSTANCE;
        }
        return voiceChannelJoinabilityUtils.computeJoinability(channelFindChannelByIdInternal$app_productionGoogleRelease, collectionValues, l, maxVideoChannelUsers, verificationLevelTriggered, Long.valueOf(this.selectedVoiceChannelId), stageInstanceForChannelInternal);
    }

    @Store3
    private final GuildVerificationLevel getVerificationLevelTriggered(Guild guild) {
        StoreGuilds guilds = this.stream.getGuilds();
        StoreUser users = this.stream.getUsers();
        GuildVerificationLevel verificationLevel = guild.getVerificationLevel();
        Map map = (Map) outline.e(guild, guilds.getMembers());
        MeUser meSnapshot = users.getMeSnapshot();
        GuildMember guildMember = map != null ? (GuildMember) map.get(Long.valueOf(meSnapshot.getId())) : null;
        boolean zIsOwner = guild.isOwner(meSnapshot.getId());
        boolean z2 = guildMember != null && (guildMember.getRoles().isEmpty() ^ true);
        UserUtils userUtils = UserUtils.INSTANCE;
        boolean hasPhone = userUtils.getHasPhone(meSnapshot);
        Long l = (Long) outline.e(guild, guilds.getGuildsJoinedAt());
        if (zIsOwner || z2 || hasPhone) {
            return GuildVerificationLevel.NONE;
        }
        int iOrdinal = verificationLevel.ordinal();
        if (iOrdinal == 0) {
            return GuildVerificationLevel.NONE;
        }
        if (iOrdinal != 1) {
            if (iOrdinal != 2) {
                if (iOrdinal != 3) {
                    if (iOrdinal == 4) {
                        return GuildVerificationLevel.HIGH;
                    }
                } else if (l != null && !GuildMemberUtils.isGuildMemberOldEnough(l.longValue())) {
                    return GuildVerificationLevel.HIGH;
                }
            } else if (!userUtils.isAccountOldEnough(meSnapshot, this.clock)) {
                return GuildVerificationLevel.MEDIUM;
            }
        } else if (!meSnapshot.isVerified()) {
            return GuildVerificationLevel.LOW;
        }
        return GuildVerificationLevel.NONE;
    }

    @Store3
    private final JoinVoiceChannelResult selectVoiceChannelInternal(long selectedVoiceChannelId, boolean forceMoved) {
        boolean z2;
        Channel channel;
        if (this.sessionId == null) {
            this.preselectedVoiceChannelId = Long.valueOf(selectedVoiceChannelId);
            return JoinVoiceChannelResult.DEFERRED_UNTIL_SESSION_START;
        }
        this.preselectedVoiceChannelId = null;
        if (selectedVoiceChannelId == this.selectedVoiceChannelId) {
            return JoinVoiceChannelResult.ALREADY_CONNECTED;
        }
        VoiceChannelJoinabilityUtils2 joinability = getJoinability(selectedVoiceChannelId);
        int iOrdinal = joinability.ordinal();
        if (iOrdinal == 0) {
            z2 = true;
        } else if (iOrdinal == 1) {
            z2 = forceMoved;
        } else {
            if (iOrdinal != 2) {
                if (iOrdinal != 3) {
                    if (iOrdinal != 4) {
                        throw new NoWhenBranchMatchedException();
                    }
                }
                z2 = forceMoved;
            }
            z2 = false;
        }
        long j = this.selectedVoiceChannelId;
        if (z2) {
            if (!forceMoved && (channel = StoreStream.INSTANCE.getChannels().getChannel(selectedVoiceChannelId)) != null && ChannelUtils.K(channel)) {
                AppSoundManager.Provider.INSTANCE.get().play(AppSound.INSTANCE.getSOUND_USER_JOINED());
            }
            this.selectedVoiceChannelId = selectedVoiceChannelId;
            if (selectedVoiceChannelId > 0) {
                this.lastSelectedVoiceChannelId = selectedVoiceChannelId;
            }
        } else {
            this.selectedVoiceChannelId = 0L;
        }
        if (j != this.selectedVoiceChannelId) {
            markChanged();
        }
        if (z2) {
            return JoinVoiceChannelResult.SUCCESS;
        }
        int iOrdinal2 = joinability.ordinal();
        if (iOrdinal2 == 0) {
            return JoinVoiceChannelResult.SUCCESS;
        }
        if (iOrdinal2 == 1) {
            return JoinVoiceChannelResult.FAILED_PERMISSIONS_MISSING;
        }
        if (iOrdinal2 == 2) {
            return JoinVoiceChannelResult.FAILED_GUILD_VIDEO_AT_CAPACITY;
        }
        if (iOrdinal2 == 3) {
            return JoinVoiceChannelResult.FAILED_CHANNEL_FULL;
        }
        if (iOrdinal2 == 4) {
            return JoinVoiceChannelResult.FAILED_CHANNEL_DOES_NOT_EXIST;
        }
        throw new NoWhenBranchMatchedException();
    }

    @Store3
    private final void validateSelectedVoiceChannel() {
        long j = this.selectedVoiceChannelId;
        if (j == 0) {
            return;
        }
        if (this.stream.getChannels().findChannelByIdInternal$app_productionGoogleRelease(this.selectedVoiceChannelId) == null) {
            clearInternal();
        }
        if (this.selectedVoiceChannelId != j) {
            markChanged();
        }
    }

    public final void clear() {
        this.dispatcher.schedule(new AnonymousClass1(this));
    }

    public final long getLastSelectedVoiceChannelId() {
        return this.lastSelectedVoiceChannelId;
    }

    public final Channel getSelectedVoiceChannel() {
        return this.stream.getChannels().findChannelByIdInternal$app_productionGoogleRelease(this.selectedVoiceChannelId);
    }

    public final long getSelectedVoiceChannelId() {
        return this.selectedVoiceChannelId;
    }

    public final long getTimeSelectedMs() {
        return this.timeSelectedMs;
    }

    @Store3
    public final void handleAuthToken(String authToken) {
        if (authToken == null) {
            clearInternal();
        }
    }

    @Store3
    public final void handleChannelOrThreadCreateOrUpdate() {
        validateSelectedVoiceChannel();
    }

    @Store3
    public final void handleChannelOrThreadDelete() {
        validateSelectedVoiceChannel();
    }

    @Store3
    public final void handleConnectionOpen(ModelPayload payload) {
        Intrinsics3.checkNotNullParameter(payload, "payload");
        this.sessionId = payload.getSessionId();
        Long l = this.preselectedVoiceChannelId;
        if (l != null) {
            selectVoiceChannelInternal(l.longValue(), false);
        }
    }

    @Store3
    public final void handleGuildMemberAdd(com.discord.api.guildmember.GuildMember member) {
        Intrinsics3.checkNotNullParameter(member, "member");
        if (member.getUser().getId() == this.stream.getUsers().getMe().getId()) {
            validateSelectedVoiceChannel();
        }
    }

    @Store3
    public final void handleGuildRemove() {
        validateSelectedVoiceChannel();
    }

    @Store3
    public final void handleGuildRoleCreateOrUpdate() {
        validateSelectedVoiceChannel();
    }

    @Store3
    public final void handleGuildRoleRemove() {
        validateSelectedVoiceChannel();
    }

    @Store3
    public final void handleRtcConnectionStateChanged(RtcConnection.State state) {
        Intrinsics3.checkNotNullParameter(state, "state");
        if (state instanceof RtcConnection.State.f) {
            Channel channelFindChannelByIdInternal$app_productionGoogleRelease = this.stream.getChannels().findChannelByIdInternal$app_productionGoogleRelease(this.selectedVoiceChannelId);
            Guild guild = this.stream.getGuilds().getGuildsInternal$app_productionGoogleRelease().get(channelFindChannelByIdInternal$app_productionGoogleRelease != null ? Long.valueOf(channelFindChannelByIdInternal$app_productionGoogleRelease.getGuildId()) : null);
            if (guild != null) {
                Long afkChannelId = guild.getAfkChannelId();
                long j = this.selectedVoiceChannelId;
                if (afkChannelId == null || afkChannelId.longValue() != j || this.stream.getMediaEngine().getSelectedVideoInputDevice() == null) {
                    return;
                }
                this.stream.getMediaEngine().selectVideoInputDevice(null);
            }
        }
    }

    @Store3
    public final void handleStreamTargeted(String streamKey) {
        Intrinsics3.checkNotNullParameter(streamKey, "streamKey");
        selectVoiceChannelInternal(ModelApplicationStream.INSTANCE.decodeStreamKey(streamKey).getChannelId(), false);
    }

    @Store3
    public final void handleVoiceStateUpdates(VoiceState voiceState) {
        Channel channelFindChannelByIdInternal$app_productionGoogleRelease;
        Intrinsics3.checkNotNullParameter(voiceState, "voiceState");
        if (this.stream.getUsers().getMe().getId() == voiceState.getUserId() && (channelFindChannelByIdInternal$app_productionGoogleRelease = this.stream.getChannels().findChannelByIdInternal$app_productionGoogleRelease(this.selectedVoiceChannelId)) != null && channelFindChannelByIdInternal$app_productionGoogleRelease.getGuildId() == voiceState.getGuildId()) {
            Long channelId = voiceState.getChannelId();
            long j = this.selectedVoiceChannelId;
            if ((channelId != null && channelId.longValue() == j) || !Intrinsics3.areEqual(voiceState.getSessionId(), this.sessionId)) {
                if (!Intrinsics3.areEqual(voiceState.getSessionId(), this.sessionId)) {
                    clearInternal();
                }
            } else if (channelId == null) {
                clearInternal();
            } else {
                selectVoiceChannelInternal(channelId.longValue(), true);
                AppSoundManager.Provider.INSTANCE.get().play(AppSound.INSTANCE.getSOUND_USER_MOVED());
            }
        }
    }

    public final Observable<Channel> observeSelectedChannel() {
        return ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this, this.stream.getChannels()}, false, null, null, new AnonymousClass1(), 14, null);
    }

    public final Observable<Long> observeSelectedVoiceChannelId() {
        return ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, false, null, null, new AnonymousClass1(), 14, null);
    }

    public final Observable<Long> observeTimeSelectedMs() {
        return ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, false, null, null, new AnonymousClass1(), 14, null);
    }

    public final Observable<JoinVoiceChannelResult> selectVoiceChannel(long channelId) {
        Channel channel = this.stream.getChannels().getChannel(channelId);
        if (channel != null && ChannelUtils.D(channel)) {
            StoreStream.INSTANCE.getMediaEngine().setAudioInputEnabled(false);
        }
        PublishSubject publishSubjectK0 = PublishSubject.k0();
        this.dispatcher.schedule(new AnonymousClass1(channelId, publishSubjectK0));
        Intrinsics3.checkNotNullExpressionValue(publishSubjectK0, "resultSubject");
        return publishSubjectK0;
    }

    @Override // com.discord.stores.StoreV2
    @Store3
    public void snapshotData() {
        super.snapshotData();
        this.timeSelectedMs = this.selectedVoiceChannelId > 0 ? this.clock.currentTimeMillis() : 0L;
    }

    public StoreVoiceChannelSelected(StoreStream storeStream, Dispatcher dispatcher, Clock clock, ObservationDeck observationDeck) {
        Intrinsics3.checkNotNullParameter(storeStream, "stream");
        Intrinsics3.checkNotNullParameter(dispatcher, "dispatcher");
        Intrinsics3.checkNotNullParameter(clock, "clock");
        Intrinsics3.checkNotNullParameter(observationDeck, "observationDeck");
        this.stream = storeStream;
        this.dispatcher = dispatcher;
        this.clock = clock;
        this.observationDeck = observationDeck;
    }
}
