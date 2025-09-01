package com.discord.widgets.settings;

import a0.a.a.b;
import android.content.Context;
import androidx.annotation.MainThread;
import b.a.d.AppViewModel;
import b.d.b.a.outline;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.models.domain.ModelMuteConfig;
import com.discord.models.domain.ModelNotificationSettings;
import com.discord.models.guild.Guild;
import com.discord.stores.StoreChannels;
import com.discord.stores.StoreGuilds;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreThreadsJoined;
import com.discord.stores.StoreUserGuildSettings;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.time.Clock;
import com.discord.utilities.time.ClockFactory;
import com.discord.utilities.time.TimeUtils;
import com.discord.widgets.chat.input.MentionUtils;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;
import rx.subjects.PublishSubject;

/* compiled from: MuteSettingsSheetViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 :2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0006:;<=>?BC\u0012\n\u00106\u001a\u00060\u0014j\u0002`5\u0012\n\u0010\u0019\u001a\u00060\u0014j\u0002`\u0018\u0012\u000e\b\u0002\u0010-\u001a\b\u0012\u0004\u0012\u00020\u00030\n\u0012\b\b\u0002\u0010!\u001a\u00020 \u0012\b\b\u0002\u0010)\u001a\u00020(¢\u0006\u0004\b8\u00109J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0005H\u0003¢\u0006\u0004\b\b\u0010\tJ\u0013\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\u0004\b\f\u0010\rJ\u001b\u0010\u0011\u001a\u00020\u00052\n\u0010\u0010\u001a\u00060\u000ej\u0002`\u000fH\u0007¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u0005H\u0007¢\u0006\u0004\b\u0013\u0010\tJ#\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u00142\n\u0010\u0010\u001a\u00060\u000ej\u0002`\u000fH\u0007¢\u0006\u0004\b\u0016\u0010\u0017J\u001b\u0010\u001a\u001a\u00020\u00052\n\u0010\u0019\u001a\u00060\u0014j\u0002`\u0018H\u0007¢\u0006\u0004\b\u001a\u0010\u001bR:\u0010\u001e\u001a&\u0012\f\u0012\n \u001d*\u0004\u0018\u00010\u000b0\u000b \u001d*\u0012\u0012\f\u0012\n \u001d*\u0004\u0018\u00010\u000b0\u000b\u0018\u00010\u001c0\u001c8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0019\u0010!\u001a\u00020 8\u0006@\u0006¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$R\u001d\u0010\u0019\u001a\u00060\u0014j\u0002`\u00188\u0006@\u0006¢\u0006\f\n\u0004\b\u0019\u0010%\u001a\u0004\b&\u0010'R\u0019\u0010)\u001a\u00020(8\u0006@\u0006¢\u0006\f\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,R\u001f\u0010-\u001a\b\u0012\u0004\u0012\u00020\u00030\n8\u0006@\u0006¢\u0006\f\n\u0004\b-\u0010.\u001a\u0004\b/\u0010\rR\u0019\u00101\u001a\u0002008\u0006@\u0006¢\u0006\f\n\u0004\b1\u00102\u001a\u0004\b3\u00104R\u001d\u00106\u001a\u00060\u0014j\u0002`58\u0006@\u0006¢\u0006\f\n\u0004\b6\u0010%\u001a\u0004\b7\u0010'¨\u0006@"}, d2 = {"Lcom/discord/widgets/settings/MuteSettingsSheetViewModel;", "Lb/a/d/d0;", "Lcom/discord/widgets/settings/MuteSettingsSheetViewModel$ViewState;", "Lcom/discord/widgets/settings/MuteSettingsSheetViewModel$StoreState;", "storeState", "", "handleStoreState", "(Lcom/discord/widgets/settings/MuteSettingsSheetViewModel$StoreState;)V", "emitDismissEvent", "()V", "Lrx/Observable;", "Lcom/discord/widgets/settings/MuteSettingsSheetViewModel$Event;", "observeEvents", "()Lrx/Observable;", "Landroid/content/Context;", "Lcom/discord/app/ApplicationContext;", "appContext", "unmute", "(Landroid/content/Context;)V", "onChannelSettingsSelected", "", "muteDurationMs", "selectMuteDurationMs", "(JLandroid/content/Context;)V", "Lcom/discord/primitives/ChannelId;", "channelId", "emitNotificationSettingsEvent", "(J)V", "Lrx/subjects/PublishSubject;", "kotlin.jvm.PlatformType", "eventSubject", "Lrx/subjects/PublishSubject;", "Lcom/discord/stores/StoreUserGuildSettings;", "storeUserGuildSettings", "Lcom/discord/stores/StoreUserGuildSettings;", "getStoreUserGuildSettings", "()Lcom/discord/stores/StoreUserGuildSettings;", "J", "getChannelId", "()J", "Lcom/discord/utilities/time/Clock;", "clock", "Lcom/discord/utilities/time/Clock;", "getClock", "()Lcom/discord/utilities/time/Clock;", "storeStateObservable", "Lrx/Observable;", "getStoreStateObservable", "Lcom/discord/widgets/settings/MuteSettingsSheetViewModel$Config;", "config", "Lcom/discord/widgets/settings/MuteSettingsSheetViewModel$Config;", "getConfig", "()Lcom/discord/widgets/settings/MuteSettingsSheetViewModel$Config;", "Lcom/discord/primitives/GuildId;", "guildId", "getGuildId", "<init>", "(JJLrx/Observable;Lcom/discord/stores/StoreUserGuildSettings;Lcom/discord/utilities/time/Clock;)V", "Companion", "Config", "Event", "SettingsType", "StoreState", "ViewState", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class MuteSettingsSheetViewModel extends AppViewModel<ViewState> {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final long MUTE_DURATION_ALWAYS = 0;
    private final long channelId;
    private final Clock clock;
    private final Config config;
    private final PublishSubject<Event> eventSubject;
    private final long guildId;
    private final Observable<StoreState> storeStateObservable;
    private final StoreUserGuildSettings storeUserGuildSettings;

    /* compiled from: MuteSettingsSheetViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/widgets/settings/MuteSettingsSheetViewModel$StoreState;", "storeState", "", "invoke", "(Lcom/discord/widgets/settings/MuteSettingsSheetViewModel$StoreState;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.settings.MuteSettingsSheetViewModel$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<StoreState, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(StoreState storeState) {
            invoke2(storeState);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(StoreState storeState) {
            Intrinsics3.checkNotNullParameter(storeState, "storeState");
            MuteSettingsSheetViewModel.access$handleStoreState(MuteSettingsSheetViewModel.this, storeState);
        }
    }

    /* compiled from: MuteSettingsSheetViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0015\u0010\u0016JM\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u00032\n\u0010\u0006\u001a\u00060\u0002j\u0002`\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0013\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014¨\u0006\u0017"}, d2 = {"Lcom/discord/widgets/settings/MuteSettingsSheetViewModel$Companion;", "", "", "Lcom/discord/primitives/GuildId;", "guildId", "Lcom/discord/primitives/ChannelId;", "channelId", "Lcom/discord/stores/StoreGuilds;", "storeGuilds", "Lcom/discord/stores/StoreChannels;", "storeChannels", "Lcom/discord/stores/StoreUserGuildSettings;", "storeUserGuildSettings", "Lcom/discord/stores/StoreThreadsJoined;", "storeThreadsJoined", "Lrx/Observable;", "Lcom/discord/widgets/settings/MuteSettingsSheetViewModel$StoreState;", "observeStoreState", "(JJLcom/discord/stores/StoreGuilds;Lcom/discord/stores/StoreChannels;Lcom/discord/stores/StoreUserGuildSettings;Lcom/discord/stores/StoreThreadsJoined;)Lrx/Observable;", "MUTE_DURATION_ALWAYS", "J", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public static final /* synthetic */ Observable access$observeStoreState(Companion companion, long j, long j2, StoreGuilds storeGuilds, StoreChannels storeChannels, StoreUserGuildSettings storeUserGuildSettings, StoreThreadsJoined storeThreadsJoined) {
            return companion.observeStoreState(j, j2, storeGuilds, storeChannels, storeUserGuildSettings, storeThreadsJoined);
        }

        private final Observable<StoreState> observeStoreState(long guildId, long channelId, StoreGuilds storeGuilds, StoreChannels storeChannels, StoreUserGuildSettings storeUserGuildSettings, StoreThreadsJoined storeThreadsJoined) {
            Observable<StoreState> observableH = Observable.h(storeGuilds.observeGuild(guildId), storeChannels.observeChannel(channelId), storeUserGuildSettings.observeGuildSettings(), storeThreadsJoined.observeJoinedThread(channelId), MuteSettingsSheetViewModel2.INSTANCE);
            Intrinsics3.checkNotNullExpressionValue(observableH, "Observable.combineLatest…dThread\n        )\n      }");
            return observableH;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: MuteSettingsSheetViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0002\u0006\u0007¨\u0006\b"}, d2 = {"Lcom/discord/widgets/settings/MuteSettingsSheetViewModel$Config;", "", "<init>", "()V", "Channel", "Guild", "Lcom/discord/widgets/settings/MuteSettingsSheetViewModel$Config$Guild;", "Lcom/discord/widgets/settings/MuteSettingsSheetViewModel$Config$Channel;", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static abstract class Config {

        /* compiled from: MuteSettingsSheetViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u0013\u0012\n\u0010\u0006\u001a\u00060\u0002j\u0002`\u0003¢\u0006\u0004\b\u0016\u0010\u0017J\u0014\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001e\u0010\u0007\u001a\u00020\u00002\f\b\u0002\u0010\u0006\u001a\u00060\u0002j\u0002`\u0003HÆ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fHÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013R\u001d\u0010\u0006\u001a\u00060\u0002j\u0002`\u00038\u0006@\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0014\u001a\u0004\b\u0015\u0010\u0005¨\u0006\u0018"}, d2 = {"Lcom/discord/widgets/settings/MuteSettingsSheetViewModel$Config$Channel;", "Lcom/discord/widgets/settings/MuteSettingsSheetViewModel$Config;", "", "Lcom/discord/primitives/ChannelId;", "component1", "()J", "channelId", "copy", "(J)Lcom/discord/widgets/settings/MuteSettingsSheetViewModel$Config$Channel;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "J", "getChannelId", "<init>", "(J)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final /* data */ class Channel extends Config {
            private final long channelId;

            public Channel(long j) {
                super(null);
                this.channelId = j;
            }

            public static /* synthetic */ Channel copy$default(Channel channel, long j, int i, Object obj) {
                if ((i & 1) != 0) {
                    j = channel.channelId;
                }
                return channel.copy(j);
            }

            /* renamed from: component1, reason: from getter */
            public final long getChannelId() {
                return this.channelId;
            }

            public final Channel copy(long channelId) {
                return new Channel(channelId);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof Channel) && this.channelId == ((Channel) other).channelId;
                }
                return true;
            }

            public final long getChannelId() {
                return this.channelId;
            }

            public int hashCode() {
                return b.a(this.channelId);
            }

            public String toString() {
                return outline.C(outline.U("Channel(channelId="), this.channelId, ")");
            }
        }

        /* compiled from: MuteSettingsSheetViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u0013\u0012\n\u0010\u0006\u001a\u00060\u0002j\u0002`\u0003¢\u0006\u0004\b\u0016\u0010\u0017J\u0014\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001e\u0010\u0007\u001a\u00020\u00002\f\b\u0002\u0010\u0006\u001a\u00060\u0002j\u0002`\u0003HÆ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fHÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013R\u001d\u0010\u0006\u001a\u00060\u0002j\u0002`\u00038\u0006@\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0014\u001a\u0004\b\u0015\u0010\u0005¨\u0006\u0018"}, d2 = {"Lcom/discord/widgets/settings/MuteSettingsSheetViewModel$Config$Guild;", "Lcom/discord/widgets/settings/MuteSettingsSheetViewModel$Config;", "", "Lcom/discord/primitives/GuildId;", "component1", "()J", "guildId", "copy", "(J)Lcom/discord/widgets/settings/MuteSettingsSheetViewModel$Config$Guild;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "J", "getGuildId", "<init>", "(J)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final /* data */ class Guild extends Config {
            private final long guildId;

            public Guild(long j) {
                super(null);
                this.guildId = j;
            }

            public static /* synthetic */ Guild copy$default(Guild guild, long j, int i, Object obj) {
                if ((i & 1) != 0) {
                    j = guild.guildId;
                }
                return guild.copy(j);
            }

            /* renamed from: component1, reason: from getter */
            public final long getGuildId() {
                return this.guildId;
            }

            public final Guild copy(long guildId) {
                return new Guild(guildId);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof Guild) && this.guildId == ((Guild) other).guildId;
                }
                return true;
            }

            public final long getGuildId() {
                return this.guildId;
            }

            public int hashCode() {
                return b.a(this.guildId);
            }

            public String toString() {
                return outline.C(outline.U("Guild(guildId="), this.guildId, ")");
            }
        }

        private Config() {
        }

        public /* synthetic */ Config(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: MuteSettingsSheetViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0002\u0006\u0007¨\u0006\b"}, d2 = {"Lcom/discord/widgets/settings/MuteSettingsSheetViewModel$Event;", "", "<init>", "()V", "Dismiss", "NavigateToChannelSettings", "Lcom/discord/widgets/settings/MuteSettingsSheetViewModel$Event$Dismiss;", "Lcom/discord/widgets/settings/MuteSettingsSheetViewModel$Event$NavigateToChannelSettings;", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static abstract class Event {

        /* compiled from: MuteSettingsSheetViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/discord/widgets/settings/MuteSettingsSheetViewModel$Event$Dismiss;", "Lcom/discord/widgets/settings/MuteSettingsSheetViewModel$Event;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final class Dismiss extends Event {
            public static final Dismiss INSTANCE = new Dismiss();

            private Dismiss() {
                super(null);
            }
        }

        /* compiled from: MuteSettingsSheetViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u0013\u0012\n\u0010\u0006\u001a\u00060\u0002j\u0002`\u0003¢\u0006\u0004\b\u0016\u0010\u0017J\u0014\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001e\u0010\u0007\u001a\u00020\u00002\f\b\u0002\u0010\u0006\u001a\u00060\u0002j\u0002`\u0003HÆ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fHÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013R\u001d\u0010\u0006\u001a\u00060\u0002j\u0002`\u00038\u0006@\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0014\u001a\u0004\b\u0015\u0010\u0005¨\u0006\u0018"}, d2 = {"Lcom/discord/widgets/settings/MuteSettingsSheetViewModel$Event$NavigateToChannelSettings;", "Lcom/discord/widgets/settings/MuteSettingsSheetViewModel$Event;", "", "Lcom/discord/primitives/ChannelId;", "component1", "()J", "channelId", "copy", "(J)Lcom/discord/widgets/settings/MuteSettingsSheetViewModel$Event$NavigateToChannelSettings;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "J", "getChannelId", "<init>", "(J)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final /* data */ class NavigateToChannelSettings extends Event {
            private final long channelId;

            public NavigateToChannelSettings(long j) {
                super(null);
                this.channelId = j;
            }

            public static /* synthetic */ NavigateToChannelSettings copy$default(NavigateToChannelSettings navigateToChannelSettings, long j, int i, Object obj) {
                if ((i & 1) != 0) {
                    j = navigateToChannelSettings.channelId;
                }
                return navigateToChannelSettings.copy(j);
            }

            /* renamed from: component1, reason: from getter */
            public final long getChannelId() {
                return this.channelId;
            }

            public final NavigateToChannelSettings copy(long channelId) {
                return new NavigateToChannelSettings(channelId);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof NavigateToChannelSettings) && this.channelId == ((NavigateToChannelSettings) other).channelId;
                }
                return true;
            }

            public final long getChannelId() {
                return this.channelId;
            }

            public int hashCode() {
                return b.a(this.channelId);
            }

            public String toString() {
                return outline.C(outline.U("NavigateToChannelSettings(channelId="), this.channelId, ")");
            }
        }

        private Event() {
        }

        public /* synthetic */ Event(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: MuteSettingsSheetViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\n\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/discord/widgets/settings/MuteSettingsSheetViewModel$SettingsType;", "", "<init>", "(Ljava/lang/String;I)V", "GUILD", "DM", "GROUP_DM", "THREAD", "GUILD_CHANNEL", "CATEGORY", "UNKNOWN", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public enum SettingsType {
        GUILD,
        DM,
        GROUP_DM,
        THREAD,
        GUILD_CHANNEL,
        CATEGORY,
        UNKNOWN
    }

    /* compiled from: MuteSettingsSheetViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\r\b\u0086\b\u0018\u00002\u00020\u0001B1\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\b\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b&\u0010'J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\t\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0012\u0010\f\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0004\b\f\u0010\rJ@\u0010\u0012\u001a\u00020\u00002\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u000bHÆ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0015\u001a\u00020\u0014HÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0018\u001a\u00020\u0017HÖ\u0001¢\u0006\u0004\b\u0018\u0010\u0019J\u001a\u0010\u001c\u001a\u00020\u001b2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001c\u0010\u001dR\u001b\u0010\u000f\u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u001e\u001a\u0004\b\u001f\u0010\u0007R\u001b\u0010\u0011\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010 \u001a\u0004\b!\u0010\rR\u001b\u0010\u000e\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u000e\u0010\"\u001a\u0004\b#\u0010\u0004R\u001b\u0010\u0010\u001a\u0004\u0018\u00010\b8\u0006@\u0006¢\u0006\f\n\u0004\b\u0010\u0010$\u001a\u0004\b%\u0010\n¨\u0006("}, d2 = {"Lcom/discord/widgets/settings/MuteSettingsSheetViewModel$StoreState;", "", "Lcom/discord/models/guild/Guild;", "component1", "()Lcom/discord/models/guild/Guild;", "Lcom/discord/api/channel/Channel;", "component2", "()Lcom/discord/api/channel/Channel;", "Lcom/discord/models/domain/ModelNotificationSettings;", "component3", "()Lcom/discord/models/domain/ModelNotificationSettings;", "Lcom/discord/stores/StoreThreadsJoined$JoinedThread;", "component4", "()Lcom/discord/stores/StoreThreadsJoined$JoinedThread;", "guild", "channel", "guildNotificationSettings", "joinedThread", "copy", "(Lcom/discord/models/guild/Guild;Lcom/discord/api/channel/Channel;Lcom/discord/models/domain/ModelNotificationSettings;Lcom/discord/stores/StoreThreadsJoined$JoinedThread;)Lcom/discord/widgets/settings/MuteSettingsSheetViewModel$StoreState;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/discord/api/channel/Channel;", "getChannel", "Lcom/discord/stores/StoreThreadsJoined$JoinedThread;", "getJoinedThread", "Lcom/discord/models/guild/Guild;", "getGuild", "Lcom/discord/models/domain/ModelNotificationSettings;", "getGuildNotificationSettings", "<init>", "(Lcom/discord/models/guild/Guild;Lcom/discord/api/channel/Channel;Lcom/discord/models/domain/ModelNotificationSettings;Lcom/discord/stores/StoreThreadsJoined$JoinedThread;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class StoreState {
        private final Channel channel;
        private final Guild guild;
        private final ModelNotificationSettings guildNotificationSettings;
        private final StoreThreadsJoined.JoinedThread joinedThread;

        public StoreState(Guild guild, Channel channel, ModelNotificationSettings modelNotificationSettings, StoreThreadsJoined.JoinedThread joinedThread) {
            this.guild = guild;
            this.channel = channel;
            this.guildNotificationSettings = modelNotificationSettings;
            this.joinedThread = joinedThread;
        }

        public static /* synthetic */ StoreState copy$default(StoreState storeState, Guild guild, Channel channel, ModelNotificationSettings modelNotificationSettings, StoreThreadsJoined.JoinedThread joinedThread, int i, Object obj) {
            if ((i & 1) != 0) {
                guild = storeState.guild;
            }
            if ((i & 2) != 0) {
                channel = storeState.channel;
            }
            if ((i & 4) != 0) {
                modelNotificationSettings = storeState.guildNotificationSettings;
            }
            if ((i & 8) != 0) {
                joinedThread = storeState.joinedThread;
            }
            return storeState.copy(guild, channel, modelNotificationSettings, joinedThread);
        }

        /* renamed from: component1, reason: from getter */
        public final Guild getGuild() {
            return this.guild;
        }

        /* renamed from: component2, reason: from getter */
        public final Channel getChannel() {
            return this.channel;
        }

        /* renamed from: component3, reason: from getter */
        public final ModelNotificationSettings getGuildNotificationSettings() {
            return this.guildNotificationSettings;
        }

        /* renamed from: component4, reason: from getter */
        public final StoreThreadsJoined.JoinedThread getJoinedThread() {
            return this.joinedThread;
        }

        public final StoreState copy(Guild guild, Channel channel, ModelNotificationSettings guildNotificationSettings, StoreThreadsJoined.JoinedThread joinedThread) {
            return new StoreState(guild, channel, guildNotificationSettings, joinedThread);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof StoreState)) {
                return false;
            }
            StoreState storeState = (StoreState) other;
            return Intrinsics3.areEqual(this.guild, storeState.guild) && Intrinsics3.areEqual(this.channel, storeState.channel) && Intrinsics3.areEqual(this.guildNotificationSettings, storeState.guildNotificationSettings) && Intrinsics3.areEqual(this.joinedThread, storeState.joinedThread);
        }

        public final Channel getChannel() {
            return this.channel;
        }

        public final Guild getGuild() {
            return this.guild;
        }

        public final ModelNotificationSettings getGuildNotificationSettings() {
            return this.guildNotificationSettings;
        }

        public final StoreThreadsJoined.JoinedThread getJoinedThread() {
            return this.joinedThread;
        }

        public int hashCode() {
            Guild guild = this.guild;
            int iHashCode = (guild != null ? guild.hashCode() : 0) * 31;
            Channel channel = this.channel;
            int iHashCode2 = (iHashCode + (channel != null ? channel.hashCode() : 0)) * 31;
            ModelNotificationSettings modelNotificationSettings = this.guildNotificationSettings;
            int iHashCode3 = (iHashCode2 + (modelNotificationSettings != null ? modelNotificationSettings.hashCode() : 0)) * 31;
            StoreThreadsJoined.JoinedThread joinedThread = this.joinedThread;
            return iHashCode3 + (joinedThread != null ? joinedThread.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbU = outline.U("StoreState(guild=");
            sbU.append(this.guild);
            sbU.append(", channel=");
            sbU.append(this.channel);
            sbU.append(", guildNotificationSettings=");
            sbU.append(this.guildNotificationSettings);
            sbU.append(", joinedThread=");
            sbU.append(this.joinedThread);
            sbU.append(")");
            return sbU.toString();
        }

        public /* synthetic */ StoreState(Guild guild, Channel channel, ModelNotificationSettings modelNotificationSettings, StoreThreadsJoined.JoinedThread joinedThread, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(guild, channel, (i & 4) != 0 ? null : modelNotificationSettings, joinedThread);
        }
    }

    /* compiled from: MuteSettingsSheetViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0004\u0005\u0006B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0003\u0007\b\t¨\u0006\n"}, d2 = {"Lcom/discord/widgets/settings/MuteSettingsSheetViewModel$ViewState;", "", "<init>", "()V", "Failure", "Loaded", "Uninitialized", "Lcom/discord/widgets/settings/MuteSettingsSheetViewModel$ViewState$Loaded;", "Lcom/discord/widgets/settings/MuteSettingsSheetViewModel$ViewState$Uninitialized;", "Lcom/discord/widgets/settings/MuteSettingsSheetViewModel$ViewState$Failure;", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static abstract class ViewState {

        /* compiled from: MuteSettingsSheetViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/discord/widgets/settings/MuteSettingsSheetViewModel$ViewState$Failure;", "Lcom/discord/widgets/settings/MuteSettingsSheetViewModel$ViewState;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final class Failure extends ViewState {
            public static final Failure INSTANCE = new Failure();

            private Failure() {
                super(null);
            }
        }

        /* compiled from: MuteSettingsSheetViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u0000\n\u0002\b\u000e\b\u0086\b\u0018\u00002\u00020\u0001BG\u0012\u0006\u0010\u0011\u001a\u00020\u0002\u0012\u0006\u0010\u0012\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0013\u001a\u00020\b\u0012\b\b\u0002\u0010\u0014\u001a\u00020\b\u0012\u0010\b\u0002\u0010\u0015\u001a\n\u0018\u00010\u0005j\u0004\u0018\u0001`\f\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u000e¢\u0006\u0004\b'\u0010(J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\u000b\u0010\nJ\u0018\u0010\r\u001a\n\u0018\u00010\u0005j\u0004\u0018\u0001`\fHÆ\u0003¢\u0006\u0004\b\r\u0010\u0007J\u0010\u0010\u000f\u001a\u00020\u000eHÆ\u0003¢\u0006\u0004\b\u000f\u0010\u0010JT\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0011\u001a\u00020\u00022\b\b\u0002\u0010\u0012\u001a\u00020\u00052\b\b\u0002\u0010\u0013\u001a\u00020\b2\b\b\u0002\u0010\u0014\u001a\u00020\b2\u0010\b\u0002\u0010\u0015\u001a\n\u0018\u00010\u0005j\u0004\u0018\u0001`\f2\b\b\u0002\u0010\u0016\u001a\u00020\u000eHÆ\u0001¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0019\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0019\u0010\u0007J\u0010\u0010\u001a\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u001a\u0010\u0010J\u001a\u0010\u001d\u001a\u00020\b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bHÖ\u0003¢\u0006\u0004\b\u001d\u0010\u001eR\u0019\u0010\u0014\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u001f\u001a\u0004\b\u0014\u0010\nR\u0019\u0010\u0016\u001a\u00020\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b\u0016\u0010 \u001a\u0004\b!\u0010\u0010R\u0019\u0010\u0011\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010\"\u001a\u0004\b#\u0010\u0004R\u0019\u0010\u0013\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u001f\u001a\u0004\b\u0013\u0010\nR\u0019\u0010\u0012\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010$\u001a\u0004\b%\u0010\u0007R!\u0010\u0015\u001a\n\u0018\u00010\u0005j\u0004\u0018\u0001`\f8\u0006@\u0006¢\u0006\f\n\u0004\b\u0015\u0010$\u001a\u0004\b&\u0010\u0007¨\u0006)"}, d2 = {"Lcom/discord/widgets/settings/MuteSettingsSheetViewModel$ViewState$Loaded;", "Lcom/discord/widgets/settings/MuteSettingsSheetViewModel$ViewState;", "Lcom/discord/widgets/settings/MuteSettingsSheetViewModel$SettingsType;", "component1", "()Lcom/discord/widgets/settings/MuteSettingsSheetViewModel$SettingsType;", "", "component2", "()Ljava/lang/String;", "", "component3", "()Z", "component4", "Lcom/discord/primitives/UtcTimestamp;", "component5", "", "component6", "()I", "settingsType", "subtitle", "isChannelMuted", "isGuildMuted", "muteEndTime", "notificationSetting", "copy", "(Lcom/discord/widgets/settings/MuteSettingsSheetViewModel$SettingsType;Ljava/lang/String;ZZLjava/lang/String;I)Lcom/discord/widgets/settings/MuteSettingsSheetViewModel$ViewState$Loaded;", "toString", "hashCode", "", "other", "equals", "(Ljava/lang/Object;)Z", "Z", "I", "getNotificationSetting", "Lcom/discord/widgets/settings/MuteSettingsSheetViewModel$SettingsType;", "getSettingsType", "Ljava/lang/String;", "getSubtitle", "getMuteEndTime", "<init>", "(Lcom/discord/widgets/settings/MuteSettingsSheetViewModel$SettingsType;Ljava/lang/String;ZZLjava/lang/String;I)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final /* data */ class Loaded extends ViewState {
            private final boolean isChannelMuted;
            private final boolean isGuildMuted;
            private final String muteEndTime;
            private final int notificationSetting;
            private final SettingsType settingsType;
            private final String subtitle;

            public /* synthetic */ Loaded(SettingsType settingsType, String str, boolean z2, boolean z3, String str2, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
                this(settingsType, str, (i2 & 4) != 0 ? false : z2, (i2 & 8) != 0 ? false : z3, (i2 & 16) != 0 ? null : str2, (i2 & 32) != 0 ? ModelNotificationSettings.FREQUENCY_UNSET : i);
            }

            public static /* synthetic */ Loaded copy$default(Loaded loaded, SettingsType settingsType, String str, boolean z2, boolean z3, String str2, int i, int i2, Object obj) {
                if ((i2 & 1) != 0) {
                    settingsType = loaded.settingsType;
                }
                if ((i2 & 2) != 0) {
                    str = loaded.subtitle;
                }
                String str3 = str;
                if ((i2 & 4) != 0) {
                    z2 = loaded.isChannelMuted;
                }
                boolean z4 = z2;
                if ((i2 & 8) != 0) {
                    z3 = loaded.isGuildMuted;
                }
                boolean z5 = z3;
                if ((i2 & 16) != 0) {
                    str2 = loaded.muteEndTime;
                }
                String str4 = str2;
                if ((i2 & 32) != 0) {
                    i = loaded.notificationSetting;
                }
                return loaded.copy(settingsType, str3, z4, z5, str4, i);
            }

            /* renamed from: component1, reason: from getter */
            public final SettingsType getSettingsType() {
                return this.settingsType;
            }

            /* renamed from: component2, reason: from getter */
            public final String getSubtitle() {
                return this.subtitle;
            }

            /* renamed from: component3, reason: from getter */
            public final boolean getIsChannelMuted() {
                return this.isChannelMuted;
            }

            /* renamed from: component4, reason: from getter */
            public final boolean getIsGuildMuted() {
                return this.isGuildMuted;
            }

            /* renamed from: component5, reason: from getter */
            public final String getMuteEndTime() {
                return this.muteEndTime;
            }

            /* renamed from: component6, reason: from getter */
            public final int getNotificationSetting() {
                return this.notificationSetting;
            }

            public final Loaded copy(SettingsType settingsType, String subtitle, boolean isChannelMuted, boolean isGuildMuted, String muteEndTime, int notificationSetting) {
                Intrinsics3.checkNotNullParameter(settingsType, "settingsType");
                Intrinsics3.checkNotNullParameter(subtitle, "subtitle");
                return new Loaded(settingsType, subtitle, isChannelMuted, isGuildMuted, muteEndTime, notificationSetting);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Loaded)) {
                    return false;
                }
                Loaded loaded = (Loaded) other;
                return Intrinsics3.areEqual(this.settingsType, loaded.settingsType) && Intrinsics3.areEqual(this.subtitle, loaded.subtitle) && this.isChannelMuted == loaded.isChannelMuted && this.isGuildMuted == loaded.isGuildMuted && Intrinsics3.areEqual(this.muteEndTime, loaded.muteEndTime) && this.notificationSetting == loaded.notificationSetting;
            }

            public final String getMuteEndTime() {
                return this.muteEndTime;
            }

            public final int getNotificationSetting() {
                return this.notificationSetting;
            }

            public final SettingsType getSettingsType() {
                return this.settingsType;
            }

            public final String getSubtitle() {
                return this.subtitle;
            }

            /* JADX WARN: Multi-variable type inference failed */
            public int hashCode() {
                SettingsType settingsType = this.settingsType;
                int iHashCode = (settingsType != null ? settingsType.hashCode() : 0) * 31;
                String str = this.subtitle;
                int iHashCode2 = (iHashCode + (str != null ? str.hashCode() : 0)) * 31;
                boolean z2 = this.isChannelMuted;
                int i = z2;
                if (z2 != 0) {
                    i = 1;
                }
                int i2 = (iHashCode2 + i) * 31;
                boolean z3 = this.isGuildMuted;
                int i3 = (i2 + (z3 ? 1 : z3 ? 1 : 0)) * 31;
                String str2 = this.muteEndTime;
                return ((i3 + (str2 != null ? str2.hashCode() : 0)) * 31) + this.notificationSetting;
            }

            public final boolean isChannelMuted() {
                return this.isChannelMuted;
            }

            public final boolean isGuildMuted() {
                return this.isGuildMuted;
            }

            public String toString() {
                StringBuilder sbU = outline.U("Loaded(settingsType=");
                sbU.append(this.settingsType);
                sbU.append(", subtitle=");
                sbU.append(this.subtitle);
                sbU.append(", isChannelMuted=");
                sbU.append(this.isChannelMuted);
                sbU.append(", isGuildMuted=");
                sbU.append(this.isGuildMuted);
                sbU.append(", muteEndTime=");
                sbU.append(this.muteEndTime);
                sbU.append(", notificationSetting=");
                return outline.B(sbU, this.notificationSetting, ")");
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Loaded(SettingsType settingsType, String str, boolean z2, boolean z3, String str2, int i) {
                super(null);
                Intrinsics3.checkNotNullParameter(settingsType, "settingsType");
                Intrinsics3.checkNotNullParameter(str, "subtitle");
                this.settingsType = settingsType;
                this.subtitle = str;
                this.isChannelMuted = z2;
                this.isGuildMuted = z3;
                this.muteEndTime = str2;
                this.notificationSetting = i;
            }
        }

        /* compiled from: MuteSettingsSheetViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/discord/widgets/settings/MuteSettingsSheetViewModel$ViewState$Uninitialized;", "Lcom/discord/widgets/settings/MuteSettingsSheetViewModel$ViewState;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final class Uninitialized extends ViewState {
            public static final Uninitialized INSTANCE = new Uninitialized();

            private Uninitialized() {
                super(null);
            }
        }

        private ViewState() {
        }

        public /* synthetic */ ViewState(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            SettingsType.values();
            int[] iArr = new int[7];
            $EnumSwitchMapping$0 = iArr;
            iArr[SettingsType.GUILD.ordinal()] = 1;
            iArr[SettingsType.THREAD.ordinal()] = 2;
            iArr[SettingsType.GUILD_CHANNEL.ordinal()] = 3;
            iArr[SettingsType.DM.ordinal()] = 4;
            iArr[SettingsType.GROUP_DM.ordinal()] = 5;
            iArr[SettingsType.CATEGORY.ordinal()] = 6;
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ MuteSettingsSheetViewModel(long j, long j2, Observable observable, StoreUserGuildSettings storeUserGuildSettings, Clock clock, int i, DefaultConstructorMarker defaultConstructorMarker) {
        Observable observableAccess$observeStoreState;
        if ((i & 4) != 0) {
            Companion companion = INSTANCE;
            StoreStream.Companion companion2 = StoreStream.INSTANCE;
            observableAccess$observeStoreState = Companion.access$observeStoreState(companion, j, j2, companion2.getGuilds(), companion2.getChannels(), companion2.getUserGuildSettings(), companion2.getThreadsJoined());
        } else {
            observableAccess$observeStoreState = observable;
        }
        this(j, j2, observableAccess$observeStoreState, (i & 8) != 0 ? StoreStream.INSTANCE.getUserGuildSettings() : storeUserGuildSettings, (i & 16) != 0 ? ClockFactory.get() : clock);
    }

    public static final /* synthetic */ void access$handleStoreState(MuteSettingsSheetViewModel muteSettingsSheetViewModel, StoreState storeState) {
        muteSettingsSheetViewModel.handleStoreState(storeState);
    }

    @MainThread
    private final void emitDismissEvent() {
        PublishSubject<Event> publishSubject = this.eventSubject;
        publishSubject.k.onNext(Event.Dismiss.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x0091  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00d8  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0121  */
    @MainThread
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void handleStoreState(StoreState storeState) {
        String name;
        ModelNotificationSettings.ChannelOverride channelOverride;
        String muteEndTime;
        ModelNotificationSettings guildNotificationSettings;
        ModelMuteConfig muteConfig;
        StoreThreadsJoined.JoinedThread joinedThread;
        List<ModelNotificationSettings.ChannelOverride> channelOverrides;
        Object next;
        Guild guild = storeState.getGuild();
        Channel channel = storeState.getChannel();
        SettingsType settingsType = guild != null ? SettingsType.GUILD : channel != null ? ChannelUtils.m(channel) ? SettingsType.DM : ChannelUtils.p(channel) ? SettingsType.GROUP_DM : ChannelUtils.k(channel) ? SettingsType.CATEGORY : ChannelUtils.H(channel) ? SettingsType.THREAD : SettingsType.GUILD_CHANNEL : SettingsType.UNKNOWN;
        if (settingsType == SettingsType.UNKNOWN) {
            updateViewState(ViewState.Failure.INSTANCE);
            return;
        }
        int iOrdinal = settingsType.ordinal();
        if (iOrdinal == 0) {
            Intrinsics3.checkNotNull(guild);
            name = guild.getName();
        } else if (iOrdinal == 1 || iOrdinal == 2) {
            Intrinsics3.checkNotNull(channel);
            name = ChannelUtils.c(channel);
        } else if (iOrdinal == 3) {
            StringBuilder sb = new StringBuilder();
            sb.append('\"');
            Intrinsics3.checkNotNull(channel);
            sb.append(ChannelUtils.c(channel));
            sb.append('\"');
            name = sb.toString();
        } else if (iOrdinal == 4) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(MentionUtils.CHANNELS_CHAR);
            Intrinsics3.checkNotNull(channel);
            sb2.append(ChannelUtils.c(channel));
            name = sb2.toString();
        } else if (iOrdinal != 5) {
            name = "";
        }
        ModelNotificationSettings guildNotificationSettings2 = storeState.getGuildNotificationSettings();
        if (guildNotificationSettings2 == null || (channelOverrides = guildNotificationSettings2.getChannelOverrides()) == null) {
            channelOverride = null;
        } else {
            Iterator<T> it = channelOverrides.iterator();
            while (true) {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
                ModelNotificationSettings.ChannelOverride channelOverride2 = (ModelNotificationSettings.ChannelOverride) next;
                Channel channel2 = storeState.getChannel();
                if (channel2 != null) {
                    long id2 = channel2.getId();
                    Intrinsics3.checkNotNullExpressionValue(channelOverride2, "channelOverride");
                    boolean z2 = id2 == channelOverride2.getChannelId();
                    if (z2) {
                        break;
                    }
                }
            }
            channelOverride = (ModelNotificationSettings.ChannelOverride) next;
        }
        boolean z3 = channel == null || !ChannelUtils.H(channel) ? !(channelOverride == null || !channelOverride.isMuted()) : !((joinedThread = storeState.getJoinedThread()) == null || !joinedThread.getMuted());
        if (channel == null || !ChannelUtils.H(channel)) {
            muteEndTime = channelOverride != null ? channelOverride.getMuteEndTime() : null;
        } else {
            StoreThreadsJoined.JoinedThread joinedThread2 = storeState.getJoinedThread();
            if (joinedThread2 != null && (muteConfig = joinedThread2.getMuteConfig()) != null) {
                muteEndTime = muteConfig.getEndTime();
            }
        }
        if (channel != null && ChannelUtils.H(channel)) {
            StoreThreadsJoined.JoinedThread joinedThread3 = storeState.getJoinedThread();
            numValueOf = joinedThread3 != null ? Integer.valueOf(joinedThread3.getFlags()) : null;
            numValueOf = Integer.valueOf((numValueOf != null && numValueOf.intValue() == 8) ? ModelNotificationSettings.FREQUENCY_NOTHING : (numValueOf != null && numValueOf.intValue() == 4) ? ModelNotificationSettings.FREQUENCY_MENTIONS : ModelNotificationSettings.FREQUENCY_ALL);
        } else if (channelOverride != null) {
            numValueOf = Integer.valueOf(channelOverride.getMessageNotifications());
        }
        updateViewState(new ViewState.Loaded(settingsType, name, z3, (channel == null || ChannelUtils.B(channel) || (guildNotificationSettings = storeState.getGuildNotificationSettings()) == null || !guildNotificationSettings.isMuted()) ? false : true, muteEndTime, numValueOf != null ? numValueOf.intValue() : ModelNotificationSettings.FREQUENCY_UNSET));
    }

    @MainThread
    public final void emitNotificationSettingsEvent(long channelId) {
        PublishSubject<Event> publishSubject = this.eventSubject;
        publishSubject.k.onNext(new Event.NavigateToChannelSettings(channelId));
    }

    public final long getChannelId() {
        return this.channelId;
    }

    public final Clock getClock() {
        return this.clock;
    }

    public final Config getConfig() {
        return this.config;
    }

    public final long getGuildId() {
        return this.guildId;
    }

    public final Observable<StoreState> getStoreStateObservable() {
        return this.storeStateObservable;
    }

    public final StoreUserGuildSettings getStoreUserGuildSettings() {
        return this.storeUserGuildSettings;
    }

    public final Observable<Event> observeEvents() {
        PublishSubject<Event> publishSubject = this.eventSubject;
        Intrinsics3.checkNotNullExpressionValue(publishSubject, "eventSubject");
        return publishSubject;
    }

    @MainThread
    public final void onChannelSettingsSelected() {
        Config config = this.config;
        if (config instanceof Config.Channel) {
            emitNotificationSettingsEvent(((Config.Channel) config).getChannelId());
        }
    }

    @MainThread
    public final void selectMuteDurationMs(long muteDurationMs, Context appContext) {
        Intrinsics3.checkNotNullParameter(appContext, "appContext");
        ModelMuteConfig modelMuteConfig = muteDurationMs != 0 ? new ModelMuteConfig(TimeUtils.toUTCDateTime$default(Long.valueOf(this.clock.currentTimeMillis() + muteDurationMs), null, 2, null)) : null;
        Config config = this.config;
        if (config instanceof Config.Guild) {
            this.storeUserGuildSettings.setGuildMuted(appContext, ((Config.Guild) config).getGuildId(), true, modelMuteConfig);
        } else if (config instanceof Config.Channel) {
            this.storeUserGuildSettings.setChannelMuted(appContext, ((Config.Channel) config).getChannelId(), true, modelMuteConfig);
        }
        emitDismissEvent();
    }

    @MainThread
    public final void unmute(Context appContext) {
        Intrinsics3.checkNotNullParameter(appContext, "appContext");
        Config config = this.config;
        if (config instanceof Config.Channel) {
            this.storeUserGuildSettings.setChannelMuted(appContext, ((Config.Channel) config).getChannelId(), false, null);
            emitDismissEvent();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MuteSettingsSheetViewModel(long j, long j2, Observable<StoreState> observable, StoreUserGuildSettings storeUserGuildSettings, Clock clock) {
        Config channel;
        super(ViewState.Uninitialized.INSTANCE);
        Intrinsics3.checkNotNullParameter(observable, "storeStateObservable");
        Intrinsics3.checkNotNullParameter(storeUserGuildSettings, "storeUserGuildSettings");
        Intrinsics3.checkNotNullParameter(clock, "clock");
        this.guildId = j;
        this.channelId = j2;
        this.storeStateObservable = observable;
        this.storeUserGuildSettings = storeUserGuildSettings;
        this.clock = clock;
        if (j != 0) {
            channel = new Config.Guild(j);
        } else {
            channel = new Config.Channel(j2);
        }
        this.config = channel;
        this.eventSubject = PublishSubject.k0();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.computationLatest(observable), this, null, 2, null), MuteSettingsSheetViewModel.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(), 62, (Object) null);
    }
}
