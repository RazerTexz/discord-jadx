package com.discord.widgets.user.usersheet;

import androidx.core.app.NotificationCompat;
import b.d.b.a.outline;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.api.role.GuildRole;
import com.discord.api.user.UserProfile;
import com.discord.api.voice.state.StageRequestToSpeakState;
import com.discord.api.voice.state.VoiceState;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.guild.Guild;
import com.discord.models.member.GuildMember;
import com.discord.models.user.MeUser;
import com.discord.models.user.User;
import com.discord.stores.StoreChannels;
import com.discord.stores.StoreGuilds;
import com.discord.stores.StoreMediaSettings;
import com.discord.stores.StorePermissions;
import com.discord.stores.StoreStageChannels;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUser;
import com.discord.stores.StoreUserNotes;
import com.discord.stores.StoreUserPresence;
import com.discord.stores.StoreUserProfile;
import com.discord.stores.StoreUserRelationships;
import com.discord.stores.StoreVoiceChannelSelected;
import com.discord.stores.StoreVoiceStates;
import com.discord.utilities.rx.LeadingEdgeThrottle;
import com.discord.utilities.rx.ObservableCombineLatestOverloads2;
import com.discord.utilities.streams.StreamContext;
import com.discord.utilities.streams.StreamContextService;
import com.discord.widgets.guildcommunicationdisabled.start.GuildCommunicationDisabledGuildsFeatureFlag;
import com.discord.widgets.stage.StageRoles;
import com.discord.widgets.user.presence.ModelRichPresence;
import com.discord.widgets.user.usersheet.WidgetUserSheetViewModel;
import d0.t.Collections2;
import d0.t.Maps6;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import j0.k.Func1;
import j0.l.a.OnSubscribeLift;
import j0.l.e.ScalarSynchronousObservable;
import j0.p.Schedulers2;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.functions.Function16;
import kotlin.jvm.functions.Function4;
import rx.Observable;
import rx.Scheduler;
import rx.functions.Func4;

/* compiled from: WidgetUserSheetViewModelStoreState.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001+B\t\b\u0002¢\u0006\u0004\b)\u0010*JÍ\u0001\u0010'\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010&0%2\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u00032\u000e\u0010\u0006\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u00052\u000e\u0010\b\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u00072\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\u000e\u001a\u00020\r2\b\b\u0002\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u0012\u001a\u00020\u00112\b\b\u0002\u0010\u0014\u001a\u00020\u00132\b\b\u0002\u0010\u0016\u001a\u00020\u00152\b\b\u0002\u0010\u0018\u001a\u00020\u00172\b\b\u0002\u0010\u001a\u001a\u00020\u00192\b\b\u0002\u0010\u001c\u001a\u00020\u001b2\b\b\u0002\u0010\u001e\u001a\u00020\u001d2\b\b\u0002\u0010 \u001a\u00020\u001f2\b\b\u0002\u0010\"\u001a\u00020!2\b\b\u0002\u0010$\u001a\u00020#¢\u0006\u0004\b'\u0010(¨\u0006,"}, d2 = {"Lcom/discord/widgets/user/usersheet/WidgetUserSheetViewModelStoreState;", "", "", "Lcom/discord/primitives/UserId;", "userId", "Lcom/discord/primitives/ChannelId;", "channelId", "Lcom/discord/primitives/GuildId;", "guildId", "Lcom/discord/stores/StoreUser;", "storeUser", "Lcom/discord/stores/StoreChannels;", "storeChannels", "Lcom/discord/stores/StoreVoiceChannelSelected;", "storeVoiceChannelSelected", "Lcom/discord/stores/StoreUserProfile;", "storeUserProfile", "Lcom/discord/stores/StoreUserRelationships;", "storeUserRelationships", "Lcom/discord/stores/StoreVoiceStates;", "storeVoiceStates", "Lcom/discord/stores/StoreGuilds;", "storeGuilds", "Lcom/discord/stores/StoreMediaSettings;", "storeMediaSettings", "Lcom/discord/stores/StoreUserPresence;", "storeUserPresence", "Lcom/discord/stores/StorePermissions;", "storePermissions", "Lcom/discord/stores/StoreUserNotes;", "storeUserNotes", "Lcom/discord/stores/StoreStageChannels;", "storeStageChannels", "Lcom/discord/utilities/streams/StreamContextService;", "streamContextService", "Lrx/Scheduler;", "storeStateRxScheduler", "Lrx/Observable;", "Lcom/discord/widgets/user/usersheet/WidgetUserSheetViewModel$StoreState;", "observeStoreState", "(JLjava/lang/Long;Ljava/lang/Long;Lcom/discord/stores/StoreUser;Lcom/discord/stores/StoreChannels;Lcom/discord/stores/StoreVoiceChannelSelected;Lcom/discord/stores/StoreUserProfile;Lcom/discord/stores/StoreUserRelationships;Lcom/discord/stores/StoreVoiceStates;Lcom/discord/stores/StoreGuilds;Lcom/discord/stores/StoreMediaSettings;Lcom/discord/stores/StoreUserPresence;Lcom/discord/stores/StorePermissions;Lcom/discord/stores/StoreUserNotes;Lcom/discord/stores/StoreStageChannels;Lcom/discord/utilities/streams/StreamContextService;Lrx/Scheduler;)Lrx/Observable;", "<init>", "()V", "BootstrapData", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final class WidgetUserSheetViewModelStoreState {
    public static final WidgetUserSheetViewModelStoreState INSTANCE = new WidgetUserSheetViewModelStoreState();

    /* compiled from: WidgetUserSheetViewModelStoreState.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\f\b\u0082\b\u0018\u00002\u00020\u0001B-\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\r\u001a\u00020\u0005\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\b\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b#\u0010$J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\t\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0012\u0010\u000b\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0004\b\u000b\u0010\nJ>\u0010\u0010\u001a\u00020\u00002\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\r\u001a\u00020\u00052\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\bHÆ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0013\u001a\u00020\u0012HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0016\u001a\u00020\u0015HÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u001a\u0010\u001a\u001a\u00020\u00192\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001a\u0010\u001bR\u001b\u0010\u000e\u001a\u0004\u0018\u00010\b8\u0006@\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u001c\u001a\u0004\b\u001d\u0010\nR\u001b\u0010\u000f\u001a\u0004\u0018\u00010\b8\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u001c\u001a\u0004\b\u001e\u0010\nR\u001b\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\u001f\u001a\u0004\b \u0010\u0004R\u0019\u0010\r\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010!\u001a\u0004\b\"\u0010\u0007¨\u0006%"}, d2 = {"Lcom/discord/widgets/user/usersheet/WidgetUserSheetViewModelStoreState$BootstrapData;", "", "Lcom/discord/models/user/User;", "component1", "()Lcom/discord/models/user/User;", "Lcom/discord/models/user/MeUser;", "component2", "()Lcom/discord/models/user/MeUser;", "Lcom/discord/api/channel/Channel;", "component3", "()Lcom/discord/api/channel/Channel;", "component4", "user", "me", "channel", "selectedVoiceChannel", "copy", "(Lcom/discord/models/user/User;Lcom/discord/models/user/MeUser;Lcom/discord/api/channel/Channel;Lcom/discord/api/channel/Channel;)Lcom/discord/widgets/user/usersheet/WidgetUserSheetViewModelStoreState$BootstrapData;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/discord/api/channel/Channel;", "getChannel", "getSelectedVoiceChannel", "Lcom/discord/models/user/User;", "getUser", "Lcom/discord/models/user/MeUser;", "getMe", "<init>", "(Lcom/discord/models/user/User;Lcom/discord/models/user/MeUser;Lcom/discord/api/channel/Channel;Lcom/discord/api/channel/Channel;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class BootstrapData {
        private final Channel channel;
        private final MeUser me;
        private final Channel selectedVoiceChannel;
        private final User user;

        public BootstrapData(User user, MeUser meUser, Channel channel, Channel channel2) {
            Intrinsics3.checkNotNullParameter(meUser, "me");
            this.user = user;
            this.me = meUser;
            this.channel = channel;
            this.selectedVoiceChannel = channel2;
        }

        public static /* synthetic */ BootstrapData copy$default(BootstrapData bootstrapData, User user, MeUser meUser, Channel channel, Channel channel2, int i, Object obj) {
            if ((i & 1) != 0) {
                user = bootstrapData.user;
            }
            if ((i & 2) != 0) {
                meUser = bootstrapData.me;
            }
            if ((i & 4) != 0) {
                channel = bootstrapData.channel;
            }
            if ((i & 8) != 0) {
                channel2 = bootstrapData.selectedVoiceChannel;
            }
            return bootstrapData.copy(user, meUser, channel, channel2);
        }

        /* renamed from: component1, reason: from getter */
        public final User getUser() {
            return this.user;
        }

        /* renamed from: component2, reason: from getter */
        public final MeUser getMe() {
            return this.me;
        }

        /* renamed from: component3, reason: from getter */
        public final Channel getChannel() {
            return this.channel;
        }

        /* renamed from: component4, reason: from getter */
        public final Channel getSelectedVoiceChannel() {
            return this.selectedVoiceChannel;
        }

        public final BootstrapData copy(User user, MeUser me2, Channel channel, Channel selectedVoiceChannel) {
            Intrinsics3.checkNotNullParameter(me2, "me");
            return new BootstrapData(user, me2, channel, selectedVoiceChannel);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof BootstrapData)) {
                return false;
            }
            BootstrapData bootstrapData = (BootstrapData) other;
            return Intrinsics3.areEqual(this.user, bootstrapData.user) && Intrinsics3.areEqual(this.me, bootstrapData.me) && Intrinsics3.areEqual(this.channel, bootstrapData.channel) && Intrinsics3.areEqual(this.selectedVoiceChannel, bootstrapData.selectedVoiceChannel);
        }

        public final Channel getChannel() {
            return this.channel;
        }

        public final MeUser getMe() {
            return this.me;
        }

        public final Channel getSelectedVoiceChannel() {
            return this.selectedVoiceChannel;
        }

        public final User getUser() {
            return this.user;
        }

        public int hashCode() {
            User user = this.user;
            int iHashCode = (user != null ? user.hashCode() : 0) * 31;
            MeUser meUser = this.me;
            int iHashCode2 = (iHashCode + (meUser != null ? meUser.hashCode() : 0)) * 31;
            Channel channel = this.channel;
            int iHashCode3 = (iHashCode2 + (channel != null ? channel.hashCode() : 0)) * 31;
            Channel channel2 = this.selectedVoiceChannel;
            return iHashCode3 + (channel2 != null ? channel2.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbU = outline.U("BootstrapData(user=");
            sbU.append(this.user);
            sbU.append(", me=");
            sbU.append(this.me);
            sbU.append(", channel=");
            sbU.append(this.channel);
            sbU.append(", selectedVoiceChannel=");
            sbU.append(this.selectedVoiceChannel);
            sbU.append(")");
            return sbU.toString();
        }
    }

    /* compiled from: WidgetUserSheetViewModelStoreState.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\n\u001a\u00020\u00072\b\u0010\u0001\u001a\u0004\u0018\u00010\u00002\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\b\u0010\t"}, d2 = {"Lcom/discord/models/user/User;", "p1", "Lcom/discord/models/user/MeUser;", "p2", "Lcom/discord/api/channel/Channel;", "p3", "p4", "Lcom/discord/widgets/user/usersheet/WidgetUserSheetViewModelStoreState$BootstrapData;", "invoke", "(Lcom/discord/models/user/User;Lcom/discord/models/user/MeUser;Lcom/discord/api/channel/Channel;Lcom/discord/api/channel/Channel;)Lcom/discord/widgets/user/usersheet/WidgetUserSheetViewModelStoreState$BootstrapData;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.user.usersheet.WidgetUserSheetViewModelStoreState$observeStoreState$2, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass2 extends FunctionReferenceImpl implements Function4<User, MeUser, Channel, Channel, BootstrapData> {
        public static final AnonymousClass2 INSTANCE = new AnonymousClass2();

        public AnonymousClass2() {
            super(4, BootstrapData.class, "<init>", "<init>(Lcom/discord/models/user/User;Lcom/discord/models/user/MeUser;Lcom/discord/api/channel/Channel;Lcom/discord/api/channel/Channel;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function4
        public /* bridge */ /* synthetic */ BootstrapData invoke(User user, MeUser meUser, Channel channel, Channel channel2) {
            return invoke2(user, meUser, channel, channel2);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final BootstrapData invoke2(User user, MeUser meUser, Channel channel, Channel channel2) {
            Intrinsics3.checkNotNullParameter(meUser, "p2");
            return new BootstrapData(user, meUser, channel, channel2);
        }
    }

    /* compiled from: WidgetUserSheetViewModelStoreState.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0007\u001a\u001e\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u0004 \u0001*\u000e\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lcom/discord/widgets/user/usersheet/WidgetUserSheetViewModelStoreState$BootstrapData;", "kotlin.jvm.PlatformType", "data", "Lrx/Observable;", "Lcom/discord/widgets/user/usersheet/WidgetUserSheetViewModel$StoreState;", NotificationCompat.CATEGORY_CALL, "(Lcom/discord/widgets/user/usersheet/WidgetUserSheetViewModelStoreState$BootstrapData;)Lrx/Observable;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.user.usersheet.WidgetUserSheetViewModelStoreState$observeStoreState$3, reason: invalid class name */
    public static final class AnonymousClass3<T, R> implements Func1<BootstrapData, Observable<? extends WidgetUserSheetViewModel.StoreState>> {
        public final /* synthetic */ Long $guildId;
        public final /* synthetic */ StoreGuilds $storeGuilds;
        public final /* synthetic */ StoreMediaSettings $storeMediaSettings;
        public final /* synthetic */ StorePermissions $storePermissions;
        public final /* synthetic */ StoreStageChannels $storeStageChannels;
        public final /* synthetic */ StoreUserNotes $storeUserNotes;
        public final /* synthetic */ StoreUserPresence $storeUserPresence;
        public final /* synthetic */ StoreUserProfile $storeUserProfile;
        public final /* synthetic */ StoreUserRelationships $storeUserRelationships;
        public final /* synthetic */ StoreVoiceStates $storeVoiceStates;
        public final /* synthetic */ StreamContextService $streamContextService;

        /* compiled from: WidgetUserSheetViewModelStoreState.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0001\n\u0002\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "kotlin.jvm.PlatformType", "it", "", NotificationCompat.CATEGORY_CALL, "(Ljava/lang/Long;)Ljava/lang/Void;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
        /* renamed from: com.discord.widgets.user.usersheet.WidgetUserSheetViewModelStoreState$observeStoreState$3$1, reason: invalid class name */
        public static final class AnonymousClass1<T, R> implements Func1 {
            public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

            @Override // j0.k.Func1
            public /* bridge */ /* synthetic */ Object call(Object obj) {
                return call((Long) obj);
            }

            public final Void call(Long l) {
                return null;
            }
        }

        /* compiled from: WidgetUserSheetViewModelStoreState.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000x\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010'\u001a\u00020$2\u001a\u0010\u0005\u001a\u0016\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0012\b\u0012\u00060\u0003j\u0002`\u00040\u00002\u0016\u0010\b\u001a\u0012\u0012\b\u0012\u00060\u0001j\u0002`\u0006\u0012\u0004\u0012\u00020\u00070\u00002\u0016\u0010\n\u001a\u0012\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0012\u0004\u0012\u00020\t0\u00002\u0016\u0010\u000b\u001a\u0012\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0012\u0004\u0012\u00020\t0\u00002\u0006\u0010\r\u001a\u00020\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\u000e\u0010\u0013\u001a\n\u0018\u00010\u0001j\u0004\u0018\u0001`\u00122\b\u0010\u0015\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0017\u001a\u00020\u00162\u000e\u0010\u001a\u001a\n\u0018\u00010\u0018j\u0004\u0018\u0001`\u00192\u0006\u0010\u001c\u001a\u00020\u001b2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001d2\u0006\u0010 \u001a\u00020\u001f2\b\u0010!\u001a\u0004\u0018\u00010\u001d2\u0006\u0010#\u001a\u00020\"H\n¢\u0006\u0004\b%\u0010&"}, d2 = {"", "", "Lcom/discord/primitives/UserId;", "Lcom/discord/models/member/GuildMember;", "Lcom/discord/stores/ClientGuildMember;", "computedMembers", "Lcom/discord/primitives/RoleId;", "Lcom/discord/api/role/GuildRole;", "guildRoles", "Lcom/discord/api/voice/state/VoiceState;", "mySelectedVoiceChannelVoiceStates", "currentChannelVoiceStates", "Lcom/discord/stores/StoreMediaSettings$VoiceConfiguration;", "voiceConfig", "Lcom/discord/widgets/user/presence/ModelRichPresence;", "richPresence", "Lcom/discord/models/guild/Guild;", "guild", "Lcom/discord/api/permission/PermissionBit;", ModelAuditLogEntry.CHANGE_KEY_PERMISSIONS, "Lcom/discord/utilities/streams/StreamContext;", "streamContext", "Lcom/discord/api/user/UserProfile;", "userProfile", "", "Lcom/discord/primitives/RelationshipType;", "userRelationshipType", "Lcom/discord/stores/StoreUserNotes$UserNoteState;", "userNote", "Lcom/discord/widgets/stage/StageRoles;", "userStageRoles", "Lcom/discord/api/voice/state/StageRequestToSpeakState;", "userRequestToSpeakState", "myStageRoles", "", "canDisableCommunication", "Lcom/discord/widgets/user/usersheet/WidgetUserSheetViewModel$StoreState;", "invoke", "(Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Lcom/discord/stores/StoreMediaSettings$VoiceConfiguration;Lcom/discord/widgets/user/presence/ModelRichPresence;Lcom/discord/models/guild/Guild;Ljava/lang/Long;Lcom/discord/utilities/streams/StreamContext;Lcom/discord/api/user/UserProfile;Ljava/lang/Integer;Lcom/discord/stores/StoreUserNotes$UserNoteState;Lcom/discord/widgets/stage/StageRoles;Lcom/discord/api/voice/state/StageRequestToSpeakState;Lcom/discord/widgets/stage/StageRoles;Z)Lcom/discord/widgets/user/usersheet/WidgetUserSheetViewModel$StoreState;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
        /* renamed from: com.discord.widgets.user.usersheet.WidgetUserSheetViewModelStoreState$observeStoreState$3$2, reason: invalid class name */
        public static final class AnonymousClass2 extends Lambda implements Function16<Map<Long, ? extends GuildMember>, Map<Long, ? extends GuildRole>, Map<Long, ? extends VoiceState>, Map<Long, ? extends VoiceState>, StoreMediaSettings.VoiceConfiguration, ModelRichPresence, Guild, Long, StreamContext, UserProfile, Integer, StoreUserNotes.UserNoteState, StageRoles, StageRequestToSpeakState, StageRoles, Boolean, WidgetUserSheetViewModel.StoreState> {
            public final /* synthetic */ Channel $channel;
            public final /* synthetic */ MeUser $me;
            public final /* synthetic */ Channel $selectedVoiceChannel;
            public final /* synthetic */ User $user;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass2(User user, MeUser meUser, Channel channel, Channel channel2) {
                super(16);
                this.$user = user;
                this.$me = meUser;
                this.$channel = channel;
                this.$selectedVoiceChannel = channel2;
            }

            @Override // kotlin.jvm.functions.Function16
            public /* bridge */ /* synthetic */ WidgetUserSheetViewModel.StoreState invoke(Map<Long, ? extends GuildMember> map, Map<Long, ? extends GuildRole> map2, Map<Long, ? extends VoiceState> map3, Map<Long, ? extends VoiceState> map4, StoreMediaSettings.VoiceConfiguration voiceConfiguration, ModelRichPresence modelRichPresence, Guild guild, Long l, StreamContext streamContext, UserProfile userProfile, Integer num, StoreUserNotes.UserNoteState userNoteState, StageRoles stageRoles, StageRequestToSpeakState stageRequestToSpeakState, StageRoles stageRoles2, Boolean bool) {
                return invoke((Map<Long, GuildMember>) map, (Map<Long, GuildRole>) map2, (Map<Long, VoiceState>) map3, (Map<Long, VoiceState>) map4, voiceConfiguration, modelRichPresence, guild, l, streamContext, userProfile, num, userNoteState, stageRoles, stageRequestToSpeakState, stageRoles2, bool.booleanValue());
            }

            public final WidgetUserSheetViewModel.StoreState invoke(Map<Long, GuildMember> map, Map<Long, GuildRole> map2, Map<Long, VoiceState> map3, Map<Long, VoiceState> map4, StoreMediaSettings.VoiceConfiguration voiceConfiguration, ModelRichPresence modelRichPresence, Guild guild, Long l, StreamContext streamContext, UserProfile userProfile, Integer num, StoreUserNotes.UserNoteState userNoteState, StageRoles stageRoles, StageRequestToSpeakState stageRequestToSpeakState, StageRoles stageRoles2, boolean z2) {
                Intrinsics3.checkNotNullParameter(map, "computedMembers");
                Intrinsics3.checkNotNullParameter(map2, "guildRoles");
                Intrinsics3.checkNotNullParameter(map3, "mySelectedVoiceChannelVoiceStates");
                Intrinsics3.checkNotNullParameter(map4, "currentChannelVoiceStates");
                Intrinsics3.checkNotNullParameter(voiceConfiguration, "voiceConfig");
                Intrinsics3.checkNotNullParameter(userProfile, "userProfile");
                Intrinsics3.checkNotNullParameter(userNoteState, "userNote");
                Intrinsics3.checkNotNullParameter(stageRequestToSpeakState, "userRequestToSpeakState");
                Boolean bool = (Boolean) outline.f(this.$user, voiceConfiguration.getMutedUsers());
                boolean zBooleanValue = bool != null ? bool.booleanValue() : false;
                boolean zIsSelfMuted = voiceConfiguration.isSelfMuted();
                boolean zIsSelfDeafened = voiceConfiguration.isSelfDeafened();
                Float f = (Float) outline.f(this.$user, voiceConfiguration.getUserOutputVolumes());
                float fFloatValue = f != null ? f.floatValue() : 100.0f;
                User user = this.$user;
                MeUser meUser = this.$me;
                Channel channel = this.$channel;
                Channel channel2 = this.$selectedVoiceChannel;
                return new WidgetUserSheetViewModel.StoreState(user, meUser, channel, map, map2, map3, map4, zBooleanValue, zIsSelfMuted, zIsSelfDeafened, fFloatValue, modelRichPresence, guild, l, streamContext, userProfile, num, userNoteState, (channel2 == null || !ChannelUtils.D(channel2)) ? null : channel2, stageRoles, stageRequestToSpeakState, stageRoles2, z2, null);
            }
        }

        public AnonymousClass3(Long l, StoreGuilds storeGuilds, StoreVoiceStates storeVoiceStates, StoreUserPresence storeUserPresence, StorePermissions storePermissions, StreamContextService streamContextService, StoreStageChannels storeStageChannels, StoreMediaSettings storeMediaSettings, StoreUserProfile storeUserProfile, StoreUserRelationships storeUserRelationships, StoreUserNotes storeUserNotes) {
            this.$guildId = l;
            this.$storeGuilds = storeGuilds;
            this.$storeVoiceStates = storeVoiceStates;
            this.$storeUserPresence = storeUserPresence;
            this.$storePermissions = storePermissions;
            this.$streamContextService = streamContextService;
            this.$storeStageChannels = storeStageChannels;
            this.$storeMediaSettings = storeMediaSettings;
            this.$storeUserProfile = storeUserProfile;
            this.$storeUserRelationships = storeUserRelationships;
            this.$storeUserNotes = storeUserNotes;
        }

        @Override // j0.k.Func1
        public /* bridge */ /* synthetic */ Observable<? extends WidgetUserSheetViewModel.StoreState> call(BootstrapData bootstrapData) {
            return call2(bootstrapData);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:16:0x0065  */
        /* JADX WARN: Removed duplicated region for block: B:21:0x0082  */
        /* JADX WARN: Removed duplicated region for block: B:37:0x00e6  */
        /* JADX WARN: Removed duplicated region for block: B:46:0x0112  */
        /* JADX WARN: Removed duplicated region for block: B:49:0x0126  */
        /* JADX WARN: Removed duplicated region for block: B:52:0x0131  */
        /* JADX WARN: Removed duplicated region for block: B:55:0x0144  */
        /* JADX WARN: Removed duplicated region for block: B:58:0x0150  */
        /* JADX WARN: Removed duplicated region for block: B:61:0x015d  */
        /* JADX WARN: Removed duplicated region for block: B:63:0x0165  */
        /* JADX WARN: Removed duplicated region for block: B:66:0x0179  */
        /* renamed from: call, reason: avoid collision after fix types in other method */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Observable<? extends WidgetUserSheetViewModel.StoreState> call2(BootstrapData bootstrapData) {
            Observable scalarSynchronousObservable;
            Observable scalarSynchronousObservable2;
            Observable<Guild> scalarSynchronousObservable3;
            Observable observable;
            Observable<Long> scalarSynchronousObservable4;
            MeUser meUser;
            Channel channel;
            Observable<StageRoles> scalarSynchronousObservable5;
            MeUser meUser2;
            Observable<StageRequestToSpeakState> scalarSynchronousObservable6;
            Observable<StageRoles> scalarSynchronousObservable7;
            Observable<Boolean> scalarSynchronousObservable8;
            Observable observableObserve;
            Observable observableObserve2;
            User user = bootstrapData.getUser();
            MeUser me2 = bootstrapData.getMe();
            Channel channel2 = bootstrapData.getChannel();
            Channel selectedVoiceChannel = bootstrapData.getSelectedVoiceChannel();
            if (user == null) {
                return Observable.d0(5L, TimeUnit.SECONDS).G(AnonymousClass1.INSTANCE);
            }
            Long lValueOf = this.$guildId;
            if (lValueOf == null) {
                lValueOf = channel2 != null ? Long.valueOf(channel2.getGuildId()) : null;
            }
            if (lValueOf != null) {
                lValueOf.longValue();
                Observable observableObserveComputed = this.$storeGuilds.observeComputed(lValueOf.longValue(), Collections2.listOf((Object[]) new Long[]{Long.valueOf(user.getId()), Long.valueOf(me2.getId())}));
                scalarSynchronousObservable = observableObserveComputed != null ? observableObserveComputed : new ScalarSynchronousObservable(Maps6.emptyMap());
            }
            if (lValueOf != null) {
                lValueOf.longValue();
                Observable observableObserveRoles = this.$storeGuilds.observeRoles(lValueOf.longValue());
                scalarSynchronousObservable2 = observableObserveRoles != null ? observableObserveRoles : new ScalarSynchronousObservable(Maps6.emptyMap());
            }
            Observable scalarSynchronousObservable9 = (selectedVoiceChannel == null || (observableObserve2 = this.$storeVoiceStates.observe(selectedVoiceChannel.getGuildId(), selectedVoiceChannel.getId())) == null) ? new ScalarSynchronousObservable(Maps6.emptyMap()) : observableObserve2;
            Observable scalarSynchronousObservable10 = (channel2 == null || (observableObserve = this.$storeVoiceStates.observe(channel2.getGuildId(), channel2.getId())) == null) ? new ScalarSynchronousObservable(Maps6.emptyMap()) : observableObserve;
            Observable<ModelRichPresence> observable2 = ModelRichPresence.INSTANCE.get(user.getId(), this.$storeUserPresence);
            if (lValueOf != null) {
                lValueOf.longValue();
                scalarSynchronousObservable3 = this.$storeGuilds.observeGuild(lValueOf.longValue());
                if (scalarSynchronousObservable3 == null) {
                    scalarSynchronousObservable3 = new ScalarSynchronousObservable<>(null);
                }
            }
            if (channel2 != null) {
                observable = scalarSynchronousObservable;
                scalarSynchronousObservable4 = this.$storePermissions.observePermissionsForChannel(channel2.getId());
                if (scalarSynchronousObservable4 == null) {
                }
                Observable<StreamContext> forUser = this.$streamContextService.getForUser(user.getId(), true);
                if (selectedVoiceChannel == null) {
                    meUser = me2;
                    channel = channel2;
                    scalarSynchronousObservable5 = this.$storeStageChannels.observeUserRoles(user.getId(), selectedVoiceChannel.getId());
                    if (scalarSynchronousObservable5 == null) {
                    }
                    if (selectedVoiceChannel != null) {
                        meUser2 = meUser;
                        scalarSynchronousObservable6 = this.$storeStageChannels.observeUserRequestToSpeakState(user.getId(), selectedVoiceChannel.getId());
                        if (scalarSynchronousObservable6 == null) {
                        }
                        if (selectedVoiceChannel != null || (scalarSynchronousObservable7 = this.$storeStageChannels.observeMyRoles(selectedVoiceChannel.getId())) == null) {
                            scalarSynchronousObservable7 = new ScalarSynchronousObservable<>(null);
                        }
                        if (lValueOf == null) {
                            lValueOf.longValue();
                            scalarSynchronousObservable8 = GuildCommunicationDisabledGuildsFeatureFlag.INSTANCE.getINSTANCE().observeCanGuildAccessCommunicationDisabled(lValueOf.longValue());
                            if (scalarSynchronousObservable8 == null) {
                                scalarSynchronousObservable8 = new ScalarSynchronousObservable(Boolean.FALSE);
                            }
                        }
                        Intrinsics3.checkNotNullExpressionValue(observable, "computedMembersObservable");
                        Intrinsics3.checkNotNullExpressionValue(scalarSynchronousObservable2, "guildRolesObservable");
                        Intrinsics3.checkNotNullExpressionValue(scalarSynchronousObservable9, "mySelectedVoiceChannelVoiceStatesObservable");
                        Intrinsics3.checkNotNullExpressionValue(scalarSynchronousObservable10, "currentChannelVoiceStatesObservable");
                        Observable<StoreMediaSettings.VoiceConfiguration> voiceConfig = this.$storeMediaSettings.getVoiceConfig();
                        Intrinsics3.checkNotNullExpressionValue(scalarSynchronousObservable3, "guildsObservable");
                        Intrinsics3.checkNotNullExpressionValue(scalarSynchronousObservable4, "permissionsObservable");
                        Observable<UserProfile> observableObserveUserProfile = this.$storeUserProfile.observeUserProfile(user.getId());
                        Observable<Integer> observableObserve3 = this.$storeUserRelationships.observe(user.getId());
                        Observable<StoreUserNotes.UserNoteState> observableObserveUserNote = this.$storeUserNotes.observeUserNote(user.getId());
                        Intrinsics3.checkNotNullExpressionValue(scalarSynchronousObservable5, "userStageRolesObservable");
                        Intrinsics3.checkNotNullExpressionValue(scalarSynchronousObservable6, "userStageRequestToSpeakStateObservable");
                        Intrinsics3.checkNotNullExpressionValue(scalarSynchronousObservable7, "myStageRolesObservable");
                        Intrinsics3.checkNotNullExpressionValue(scalarSynchronousObservable8, "canDisableCommunicationObservable");
                        return ObservableCombineLatestOverloads2.combineLatest(observable, scalarSynchronousObservable2, scalarSynchronousObservable9, scalarSynchronousObservable10, voiceConfig, observable2, scalarSynchronousObservable3, scalarSynchronousObservable4, forUser, observableObserveUserProfile, observableObserve3, observableObserveUserNote, scalarSynchronousObservable5, scalarSynchronousObservable6, scalarSynchronousObservable7, scalarSynchronousObservable8, new AnonymousClass2(user, meUser2, channel, selectedVoiceChannel));
                    }
                    meUser2 = meUser;
                    scalarSynchronousObservable6 = new ScalarSynchronousObservable(StageRequestToSpeakState.NONE);
                    if (selectedVoiceChannel != null) {
                        scalarSynchronousObservable7 = new ScalarSynchronousObservable<>(null);
                    }
                    if (lValueOf == null) {
                    }
                    Intrinsics3.checkNotNullExpressionValue(observable, "computedMembersObservable");
                    Intrinsics3.checkNotNullExpressionValue(scalarSynchronousObservable2, "guildRolesObservable");
                    Intrinsics3.checkNotNullExpressionValue(scalarSynchronousObservable9, "mySelectedVoiceChannelVoiceStatesObservable");
                    Intrinsics3.checkNotNullExpressionValue(scalarSynchronousObservable10, "currentChannelVoiceStatesObservable");
                    Observable<StoreMediaSettings.VoiceConfiguration> voiceConfig2 = this.$storeMediaSettings.getVoiceConfig();
                    Intrinsics3.checkNotNullExpressionValue(scalarSynchronousObservable3, "guildsObservable");
                    Intrinsics3.checkNotNullExpressionValue(scalarSynchronousObservable4, "permissionsObservable");
                    Observable<UserProfile> observableObserveUserProfile2 = this.$storeUserProfile.observeUserProfile(user.getId());
                    Observable<Integer> observableObserve32 = this.$storeUserRelationships.observe(user.getId());
                    Observable<StoreUserNotes.UserNoteState> observableObserveUserNote2 = this.$storeUserNotes.observeUserNote(user.getId());
                    Intrinsics3.checkNotNullExpressionValue(scalarSynchronousObservable5, "userStageRolesObservable");
                    Intrinsics3.checkNotNullExpressionValue(scalarSynchronousObservable6, "userStageRequestToSpeakStateObservable");
                    Intrinsics3.checkNotNullExpressionValue(scalarSynchronousObservable7, "myStageRolesObservable");
                    Intrinsics3.checkNotNullExpressionValue(scalarSynchronousObservable8, "canDisableCommunicationObservable");
                    return ObservableCombineLatestOverloads2.combineLatest(observable, scalarSynchronousObservable2, scalarSynchronousObservable9, scalarSynchronousObservable10, voiceConfig2, observable2, scalarSynchronousObservable3, scalarSynchronousObservable4, forUser, observableObserveUserProfile2, observableObserve32, observableObserveUserNote2, scalarSynchronousObservable5, scalarSynchronousObservable6, scalarSynchronousObservable7, scalarSynchronousObservable8, new AnonymousClass2(user, meUser2, channel, selectedVoiceChannel));
                }
                meUser = me2;
                channel = channel2;
                scalarSynchronousObservable5 = new ScalarSynchronousObservable<>(null);
                if (selectedVoiceChannel != null) {
                }
                scalarSynchronousObservable6 = new ScalarSynchronousObservable(StageRequestToSpeakState.NONE);
                if (selectedVoiceChannel != null) {
                }
                if (lValueOf == null) {
                }
                Intrinsics3.checkNotNullExpressionValue(observable, "computedMembersObservable");
                Intrinsics3.checkNotNullExpressionValue(scalarSynchronousObservable2, "guildRolesObservable");
                Intrinsics3.checkNotNullExpressionValue(scalarSynchronousObservable9, "mySelectedVoiceChannelVoiceStatesObservable");
                Intrinsics3.checkNotNullExpressionValue(scalarSynchronousObservable10, "currentChannelVoiceStatesObservable");
                Observable<StoreMediaSettings.VoiceConfiguration> voiceConfig22 = this.$storeMediaSettings.getVoiceConfig();
                Intrinsics3.checkNotNullExpressionValue(scalarSynchronousObservable3, "guildsObservable");
                Intrinsics3.checkNotNullExpressionValue(scalarSynchronousObservable4, "permissionsObservable");
                Observable<UserProfile> observableObserveUserProfile22 = this.$storeUserProfile.observeUserProfile(user.getId());
                Observable<Integer> observableObserve322 = this.$storeUserRelationships.observe(user.getId());
                Observable<StoreUserNotes.UserNoteState> observableObserveUserNote22 = this.$storeUserNotes.observeUserNote(user.getId());
                Intrinsics3.checkNotNullExpressionValue(scalarSynchronousObservable5, "userStageRolesObservable");
                Intrinsics3.checkNotNullExpressionValue(scalarSynchronousObservable6, "userStageRequestToSpeakStateObservable");
                Intrinsics3.checkNotNullExpressionValue(scalarSynchronousObservable7, "myStageRolesObservable");
                Intrinsics3.checkNotNullExpressionValue(scalarSynchronousObservable8, "canDisableCommunicationObservable");
                return ObservableCombineLatestOverloads2.combineLatest(observable, scalarSynchronousObservable2, scalarSynchronousObservable9, scalarSynchronousObservable10, voiceConfig22, observable2, scalarSynchronousObservable3, scalarSynchronousObservable4, forUser, observableObserveUserProfile22, observableObserve322, observableObserveUserNote22, scalarSynchronousObservable5, scalarSynchronousObservable6, scalarSynchronousObservable7, scalarSynchronousObservable8, new AnonymousClass2(user, meUser2, channel, selectedVoiceChannel));
            }
            observable = scalarSynchronousObservable;
            scalarSynchronousObservable4 = new ScalarSynchronousObservable<>(null);
            Observable<StreamContext> forUser2 = this.$streamContextService.getForUser(user.getId(), true);
            if (selectedVoiceChannel == null) {
            }
            scalarSynchronousObservable5 = new ScalarSynchronousObservable<>(null);
            if (selectedVoiceChannel != null) {
            }
            scalarSynchronousObservable6 = new ScalarSynchronousObservable(StageRequestToSpeakState.NONE);
            if (selectedVoiceChannel != null) {
            }
            if (lValueOf == null) {
            }
            Intrinsics3.checkNotNullExpressionValue(observable, "computedMembersObservable");
            Intrinsics3.checkNotNullExpressionValue(scalarSynchronousObservable2, "guildRolesObservable");
            Intrinsics3.checkNotNullExpressionValue(scalarSynchronousObservable9, "mySelectedVoiceChannelVoiceStatesObservable");
            Intrinsics3.checkNotNullExpressionValue(scalarSynchronousObservable10, "currentChannelVoiceStatesObservable");
            Observable<StoreMediaSettings.VoiceConfiguration> voiceConfig222 = this.$storeMediaSettings.getVoiceConfig();
            Intrinsics3.checkNotNullExpressionValue(scalarSynchronousObservable3, "guildsObservable");
            Intrinsics3.checkNotNullExpressionValue(scalarSynchronousObservable4, "permissionsObservable");
            Observable<UserProfile> observableObserveUserProfile222 = this.$storeUserProfile.observeUserProfile(user.getId());
            Observable<Integer> observableObserve3222 = this.$storeUserRelationships.observe(user.getId());
            Observable<StoreUserNotes.UserNoteState> observableObserveUserNote222 = this.$storeUserNotes.observeUserNote(user.getId());
            Intrinsics3.checkNotNullExpressionValue(scalarSynchronousObservable5, "userStageRolesObservable");
            Intrinsics3.checkNotNullExpressionValue(scalarSynchronousObservable6, "userStageRequestToSpeakStateObservable");
            Intrinsics3.checkNotNullExpressionValue(scalarSynchronousObservable7, "myStageRolesObservable");
            Intrinsics3.checkNotNullExpressionValue(scalarSynchronousObservable8, "canDisableCommunicationObservable");
            return ObservableCombineLatestOverloads2.combineLatest(observable, scalarSynchronousObservable2, scalarSynchronousObservable9, scalarSynchronousObservable10, voiceConfig222, observable2, scalarSynchronousObservable3, scalarSynchronousObservable4, forUser2, observableObserveUserProfile222, observableObserve3222, observableObserveUserNote222, scalarSynchronousObservable5, scalarSynchronousObservable6, scalarSynchronousObservable7, scalarSynchronousObservable8, new AnonymousClass2(user, meUser2, channel, selectedVoiceChannel));
        }
    }

    private WidgetUserSheetViewModelStoreState() {
    }

    public static /* synthetic */ Observable observeStoreState$default(WidgetUserSheetViewModelStoreState widgetUserSheetViewModelStoreState, long j, Long l, Long l2, StoreUser storeUser, StoreChannels storeChannels, StoreVoiceChannelSelected storeVoiceChannelSelected, StoreUserProfile storeUserProfile, StoreUserRelationships storeUserRelationships, StoreVoiceStates storeVoiceStates, StoreGuilds storeGuilds, StoreMediaSettings storeMediaSettings, StoreUserPresence storeUserPresence, StorePermissions storePermissions, StoreUserNotes storeUserNotes, StoreStageChannels storeStageChannels, StreamContextService streamContextService, Scheduler scheduler, int i, Object obj) {
        Scheduler scheduler2;
        StoreUser users = (i & 8) != 0 ? StoreStream.INSTANCE.getUsers() : storeUser;
        StoreChannels channels = (i & 16) != 0 ? StoreStream.INSTANCE.getChannels() : storeChannels;
        StoreVoiceChannelSelected voiceChannelSelected = (i & 32) != 0 ? StoreStream.INSTANCE.getVoiceChannelSelected() : storeVoiceChannelSelected;
        StoreUserProfile userProfile = (i & 64) != 0 ? StoreStream.INSTANCE.getUserProfile() : storeUserProfile;
        StoreUserRelationships userRelationships = (i & 128) != 0 ? StoreStream.INSTANCE.getUserRelationships() : storeUserRelationships;
        StoreVoiceStates voiceStates = (i & 256) != 0 ? StoreStream.INSTANCE.getVoiceStates() : storeVoiceStates;
        StoreGuilds guilds = (i & 512) != 0 ? StoreStream.INSTANCE.getGuilds() : storeGuilds;
        StoreMediaSettings mediaSettings = (i & 1024) != 0 ? StoreStream.INSTANCE.getMediaSettings() : storeMediaSettings;
        StoreUserPresence presences = (i & 2048) != 0 ? StoreStream.INSTANCE.getPresences() : storeUserPresence;
        StorePermissions permissions = (i & 4096) != 0 ? StoreStream.INSTANCE.getPermissions() : storePermissions;
        StoreUserNotes usersNotes = (i & 8192) != 0 ? StoreStream.INSTANCE.getUsersNotes() : storeUserNotes;
        StoreStageChannels stageChannels = (i & 16384) != 0 ? StoreStream.INSTANCE.getStageChannels() : storeStageChannels;
        StreamContextService streamContextService2 = (32768 & i) != 0 ? new StreamContextService(null, null, null, null, null, null, null, null, 255, null) : streamContextService;
        if ((i & 65536) != 0) {
            Scheduler schedulerA = Schedulers2.a();
            Intrinsics3.checkNotNullExpressionValue(schedulerA, "Schedulers.computation()");
            scheduler2 = schedulerA;
        } else {
            scheduler2 = scheduler;
        }
        return widgetUserSheetViewModelStoreState.observeStoreState(j, l, l2, users, channels, voiceChannelSelected, userProfile, userRelationships, voiceStates, guilds, mediaSettings, presences, permissions, usersNotes, stageChannels, streamContextService2, scheduler2);
    }

    public final Observable<WidgetUserSheetViewModel.StoreState> observeStoreState(long userId, Long channelId, Long guildId, StoreUser storeUser, StoreChannels storeChannels, StoreVoiceChannelSelected storeVoiceChannelSelected, StoreUserProfile storeUserProfile, StoreUserRelationships storeUserRelationships, StoreVoiceStates storeVoiceStates, StoreGuilds storeGuilds, StoreMediaSettings storeMediaSettings, StoreUserPresence storeUserPresence, StorePermissions storePermissions, StoreUserNotes storeUserNotes, StoreStageChannels storeStageChannels, StreamContextService streamContextService, Scheduler storeStateRxScheduler) {
        Observable<Channel> scalarSynchronousObservable;
        Intrinsics3.checkNotNullParameter(storeUser, "storeUser");
        Intrinsics3.checkNotNullParameter(storeChannels, "storeChannels");
        Intrinsics3.checkNotNullParameter(storeVoiceChannelSelected, "storeVoiceChannelSelected");
        Intrinsics3.checkNotNullParameter(storeUserProfile, "storeUserProfile");
        Intrinsics3.checkNotNullParameter(storeUserRelationships, "storeUserRelationships");
        Intrinsics3.checkNotNullParameter(storeVoiceStates, "storeVoiceStates");
        Intrinsics3.checkNotNullParameter(storeGuilds, "storeGuilds");
        Intrinsics3.checkNotNullParameter(storeMediaSettings, "storeMediaSettings");
        Intrinsics3.checkNotNullParameter(storeUserPresence, "storeUserPresence");
        Intrinsics3.checkNotNullParameter(storePermissions, "storePermissions");
        Intrinsics3.checkNotNullParameter(storeUserNotes, "storeUserNotes");
        Intrinsics3.checkNotNullParameter(storeStageChannels, "storeStageChannels");
        Intrinsics3.checkNotNullParameter(streamContextService, "streamContextService");
        Intrinsics3.checkNotNullParameter(storeStateRxScheduler, "storeStateRxScheduler");
        Observable<User> observableObserveUser = storeUser.observeUser(userId);
        Observable observableObserveMe$default = StoreUser.observeMe$default(storeUser, false, 1, null);
        if (channelId == null || (scalarSynchronousObservable = storeChannels.observeChannel(channelId.longValue())) == null) {
            scalarSynchronousObservable = new ScalarSynchronousObservable<>(null);
        }
        Observable<Channel> observableObserveSelectedChannel = storeVoiceChannelSelected.observeSelectedChannel();
        AnonymousClass2 anonymousClass2 = AnonymousClass2.INSTANCE;
        Object widgetUserSheetViewModelStoreState2 = anonymousClass2;
        if (anonymousClass2 != null) {
            widgetUserSheetViewModelStoreState2 = new WidgetUserSheetViewModelStoreState2(anonymousClass2);
        }
        Observable<WidgetUserSheetViewModel.StoreState> observableR = Observable.h0(new OnSubscribeLift(Observable.h(observableObserveUser, observableObserveMe$default, scalarSynchronousObservable, observableObserveSelectedChannel, (Func4) widgetUserSheetViewModelStoreState2).Y(new AnonymousClass3(guildId, storeGuilds, storeVoiceStates, storeUserPresence, storePermissions, streamContextService, storeStageChannels, storeMediaSettings, storeUserProfile, storeUserRelationships, storeUserNotes)).j, new LeadingEdgeThrottle(250L, TimeUnit.MILLISECONDS, storeStateRxScheduler))).r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "Observable\n          .co…  .distinctUntilChanged()");
        return observableR;
    }
}
