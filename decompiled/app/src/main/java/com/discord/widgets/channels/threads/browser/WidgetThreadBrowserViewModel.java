package com.discord.widgets.channels.threads.browser;

import android.content.Context;
import androidx.annotation.MainThread;
import b.a.d.AppViewModel;
import b.d.b.a.outline;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.guild.Guild;
import com.discord.stores.StoreChannels;
import com.discord.stores.StoreGuilds;
import com.discord.stores.StorePermissions;
import com.discord.stores.StoreStream;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.threads.ThreadUtils;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* compiled from: WidgetThreadBrowserViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \"2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0003\"#$BM\u0012\n\u0010\u000e\u001a\u00060\fj\u0002`\r\u0012\n\u0010\u0016\u001a\u00060\fj\u0002`\u0015\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0012\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0018\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u001b\u0012\u000e\b\u0002\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00030\u001e¢\u0006\u0004\b \u0010!J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0015\u0010\n\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bR\u001d\u0010\u000e\u001a\u00060\fj\u0002`\r8\u0006@\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0013\u001a\u00020\u00128\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u001d\u0010\u0016\u001a\u00060\fj\u0002`\u00158\u0006@\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u000f\u001a\u0004\b\u0017\u0010\u0011R\u0016\u0010\u0019\u001a\u00020\u00188\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001c\u001a\u00020\u001b8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001d¨\u0006%"}, d2 = {"Lcom/discord/widgets/channels/threads/browser/WidgetThreadBrowserViewModel;", "Lb/a/d/d0;", "Lcom/discord/widgets/channels/threads/browser/WidgetThreadBrowserViewModel$ViewState;", "Lcom/discord/widgets/channels/threads/browser/WidgetThreadBrowserViewModel$StoreState;", "storeState", "", "handleStoreState", "(Lcom/discord/widgets/channels/threads/browser/WidgetThreadBrowserViewModel$StoreState;)V", "Lcom/discord/api/channel/Channel;", "channel", "openThread", "(Lcom/discord/api/channel/Channel;)V", "", "Lcom/discord/primitives/GuildId;", "guildId", "J", "getGuildId", "()J", "Lcom/discord/stores/StoreChannels;", "storeChannels", "Lcom/discord/stores/StoreChannels;", "Lcom/discord/primitives/ChannelId;", "channelId", "getChannelId", "Lcom/discord/stores/StoreGuilds;", "storeGuilds", "Lcom/discord/stores/StoreGuilds;", "Lcom/discord/stores/StorePermissions;", "storePermissions", "Lcom/discord/stores/StorePermissions;", "Lrx/Observable;", "storeStateObservable", "<init>", "(JJLcom/discord/stores/StoreChannels;Lcom/discord/stores/StoreGuilds;Lcom/discord/stores/StorePermissions;Lrx/Observable;)V", "Companion", "StoreState", "ViewState", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class WidgetThreadBrowserViewModel extends AppViewModel<ViewState> {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final long channelId;
    private final long guildId;
    private final StoreChannels storeChannels;
    private final StoreGuilds storeGuilds;
    private final StorePermissions storePermissions;

    /* compiled from: WidgetThreadBrowserViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/widgets/channels/threads/browser/WidgetThreadBrowserViewModel$StoreState;", "storeState", "", "invoke", "(Lcom/discord/widgets/channels/threads/browser/WidgetThreadBrowserViewModel$StoreState;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.channels.threads.browser.WidgetThreadBrowserViewModel$1, reason: invalid class name */
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
            WidgetThreadBrowserViewModel.access$handleStoreState(WidgetThreadBrowserViewModel.this, storeState);
        }
    }

    /* compiled from: WidgetThreadBrowserViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0011\u0010\u0012JE\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u00032\n\u0010\u0006\u001a\u00060\u0002j\u0002`\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u000f\u0010\u0010¨\u0006\u0013"}, d2 = {"Lcom/discord/widgets/channels/threads/browser/WidgetThreadBrowserViewModel$Companion;", "", "", "Lcom/discord/primitives/ChannelId;", "channelId", "Lcom/discord/primitives/GuildId;", "guildId", "Lcom/discord/stores/StoreChannels;", "storeChannels", "Lcom/discord/stores/StoreGuilds;", "storeGuilds", "Lcom/discord/stores/StorePermissions;", "storePermissions", "Lrx/Observable;", "Lcom/discord/widgets/channels/threads/browser/WidgetThreadBrowserViewModel$StoreState;", "observeStoreState", "(JJLcom/discord/stores/StoreChannels;Lcom/discord/stores/StoreGuilds;Lcom/discord/stores/StorePermissions;)Lrx/Observable;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public static final /* synthetic */ Observable access$observeStoreState(Companion companion, long j, long j2, StoreChannels storeChannels, StoreGuilds storeGuilds, StorePermissions storePermissions) {
            return companion.observeStoreState(j, j2, storeChannels, storeGuilds, storePermissions);
        }

        private final Observable<StoreState> observeStoreState(long channelId, long guildId, StoreChannels storeChannels, StoreGuilds storeGuilds, StorePermissions storePermissions) {
            Observable<StoreState> observableI = Observable.i(storeChannels.observeChannel(channelId), storeGuilds.observeGuild(guildId), storePermissions.observePermissionsForChannel(channelId), WidgetThreadBrowserViewModel2.INSTANCE);
            Intrinsics3.checkNotNullExpressionValue(observableI, "Observable.combineLatest…issions\n        )\n      }");
            return observableI;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetThreadBrowserViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0005\u0012\u000e\u0010\u000e\u001a\n\u0018\u00010\bj\u0004\u0018\u0001`\t¢\u0006\u0004\b!\u0010\"J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0018\u0010\n\u001a\n\u0018\u00010\bj\u0004\u0018\u0001`\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ:\u0010\u000f\u001a\u00020\u00002\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00052\u0010\b\u0002\u0010\u000e\u001a\n\u0018\u00010\bj\u0004\u0018\u0001`\tHÆ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0012\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0015\u001a\u00020\u0014HÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u001a\u0010\u0019\u001a\u00020\u00182\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0019\u0010\u001aR\u001b\u0010\r\u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\u001b\u001a\u0004\b\u001c\u0010\u0007R!\u0010\u000e\u001a\n\u0018\u00010\bj\u0004\u0018\u0001`\t8\u0006@\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u001d\u001a\u0004\b\u001e\u0010\u000bR\u001b\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\u001f\u001a\u0004\b \u0010\u0004¨\u0006#"}, d2 = {"Lcom/discord/widgets/channels/threads/browser/WidgetThreadBrowserViewModel$StoreState;", "", "Lcom/discord/api/channel/Channel;", "component1", "()Lcom/discord/api/channel/Channel;", "Lcom/discord/models/guild/Guild;", "component2", "()Lcom/discord/models/guild/Guild;", "", "Lcom/discord/api/permission/PermissionBit;", "component3", "()Ljava/lang/Long;", "channel", "guild", ModelAuditLogEntry.CHANGE_KEY_PERMISSIONS, "copy", "(Lcom/discord/api/channel/Channel;Lcom/discord/models/guild/Guild;Ljava/lang/Long;)Lcom/discord/widgets/channels/threads/browser/WidgetThreadBrowserViewModel$StoreState;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/discord/models/guild/Guild;", "getGuild", "Ljava/lang/Long;", "getPermissions", "Lcom/discord/api/channel/Channel;", "getChannel", "<init>", "(Lcom/discord/api/channel/Channel;Lcom/discord/models/guild/Guild;Ljava/lang/Long;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class StoreState {
        private final Channel channel;
        private final Guild guild;
        private final Long permissions;

        public StoreState(Channel channel, Guild guild, Long l) {
            this.channel = channel;
            this.guild = guild;
            this.permissions = l;
        }

        public static /* synthetic */ StoreState copy$default(StoreState storeState, Channel channel, Guild guild, Long l, int i, Object obj) {
            if ((i & 1) != 0) {
                channel = storeState.channel;
            }
            if ((i & 2) != 0) {
                guild = storeState.guild;
            }
            if ((i & 4) != 0) {
                l = storeState.permissions;
            }
            return storeState.copy(channel, guild, l);
        }

        /* renamed from: component1, reason: from getter */
        public final Channel getChannel() {
            return this.channel;
        }

        /* renamed from: component2, reason: from getter */
        public final Guild getGuild() {
            return this.guild;
        }

        /* renamed from: component3, reason: from getter */
        public final Long getPermissions() {
            return this.permissions;
        }

        public final StoreState copy(Channel channel, Guild guild, Long permissions) {
            return new StoreState(channel, guild, permissions);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof StoreState)) {
                return false;
            }
            StoreState storeState = (StoreState) other;
            return Intrinsics3.areEqual(this.channel, storeState.channel) && Intrinsics3.areEqual(this.guild, storeState.guild) && Intrinsics3.areEqual(this.permissions, storeState.permissions);
        }

        public final Channel getChannel() {
            return this.channel;
        }

        public final Guild getGuild() {
            return this.guild;
        }

        public final Long getPermissions() {
            return this.permissions;
        }

        public int hashCode() {
            Channel channel = this.channel;
            int iHashCode = (channel != null ? channel.hashCode() : 0) * 31;
            Guild guild = this.guild;
            int iHashCode2 = (iHashCode + (guild != null ? guild.hashCode() : 0)) * 31;
            Long l = this.permissions;
            return iHashCode2 + (l != null ? l.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbU = outline.U("StoreState(channel=");
            sbU.append(this.channel);
            sbU.append(", guild=");
            sbU.append(this.guild);
            sbU.append(", permissions=");
            return outline.G(sbU, this.permissions, ")");
        }
    }

    /* compiled from: WidgetThreadBrowserViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0002\u0006\u0007¨\u0006\b"}, d2 = {"Lcom/discord/widgets/channels/threads/browser/WidgetThreadBrowserViewModel$ViewState;", "", "<init>", "()V", "Browser", "GoToChannel", "Lcom/discord/widgets/channels/threads/browser/WidgetThreadBrowserViewModel$ViewState$GoToChannel;", "Lcom/discord/widgets/channels/threads/browser/WidgetThreadBrowserViewModel$ViewState$Browser;", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static abstract class ViewState {

        /* compiled from: WidgetThreadBrowserViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001B)\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u000b\u001a\u00020\u0005\u0012\u0006\u0010\f\u001a\u00020\u0005\u0012\u0006\u0010\r\u001a\u00020\u0005¢\u0006\u0004\b\u001d\u0010\u001eJ\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\b\u0010\u0007J\u0010\u0010\t\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\t\u0010\u0007J:\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u000b\u001a\u00020\u00052\b\b\u0002\u0010\f\u001a\u00020\u00052\b\b\u0002\u0010\r\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0004J\u0010\u0010\u0012\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u001a\u0010\u0016\u001a\u00020\u00052\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014HÖ\u0003¢\u0006\u0004\b\u0016\u0010\u0017R\u001b\u0010\n\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\n\u0010\u0018\u001a\u0004\b\u0019\u0010\u0004R\u0019\u0010\u000b\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u001a\u001a\u0004\b\u001b\u0010\u0007R\u0019\u0010\r\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\u001a\u001a\u0004\b\r\u0010\u0007R\u0019\u0010\f\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\u001a\u001a\u0004\b\u001c\u0010\u0007¨\u0006\u001f"}, d2 = {"Lcom/discord/widgets/channels/threads/browser/WidgetThreadBrowserViewModel$ViewState$Browser;", "Lcom/discord/widgets/channels/threads/browser/WidgetThreadBrowserViewModel$ViewState;", "", "component1", "()Ljava/lang/String;", "", "component2", "()Z", "component3", "component4", "channelName", "canCreateThread", "canViewArchivedThreads", "isForumChannel", "copy", "(Ljava/lang/String;ZZZ)Lcom/discord/widgets/channels/threads/browser/WidgetThreadBrowserViewModel$ViewState$Browser;", "toString", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getChannelName", "Z", "getCanCreateThread", "getCanViewArchivedThreads", "<init>", "(Ljava/lang/String;ZZZ)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final /* data */ class Browser extends ViewState {
            private final boolean canCreateThread;
            private final boolean canViewArchivedThreads;
            private final String channelName;
            private final boolean isForumChannel;

            public Browser(String str, boolean z2, boolean z3, boolean z4) {
                super(null);
                this.channelName = str;
                this.canCreateThread = z2;
                this.canViewArchivedThreads = z3;
                this.isForumChannel = z4;
            }

            public static /* synthetic */ Browser copy$default(Browser browser, String str, boolean z2, boolean z3, boolean z4, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = browser.channelName;
                }
                if ((i & 2) != 0) {
                    z2 = browser.canCreateThread;
                }
                if ((i & 4) != 0) {
                    z3 = browser.canViewArchivedThreads;
                }
                if ((i & 8) != 0) {
                    z4 = browser.isForumChannel;
                }
                return browser.copy(str, z2, z3, z4);
            }

            /* renamed from: component1, reason: from getter */
            public final String getChannelName() {
                return this.channelName;
            }

            /* renamed from: component2, reason: from getter */
            public final boolean getCanCreateThread() {
                return this.canCreateThread;
            }

            /* renamed from: component3, reason: from getter */
            public final boolean getCanViewArchivedThreads() {
                return this.canViewArchivedThreads;
            }

            /* renamed from: component4, reason: from getter */
            public final boolean getIsForumChannel() {
                return this.isForumChannel;
            }

            public final Browser copy(String channelName, boolean canCreateThread, boolean canViewArchivedThreads, boolean isForumChannel) {
                return new Browser(channelName, canCreateThread, canViewArchivedThreads, isForumChannel);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Browser)) {
                    return false;
                }
                Browser browser = (Browser) other;
                return Intrinsics3.areEqual(this.channelName, browser.channelName) && this.canCreateThread == browser.canCreateThread && this.canViewArchivedThreads == browser.canViewArchivedThreads && this.isForumChannel == browser.isForumChannel;
            }

            public final boolean getCanCreateThread() {
                return this.canCreateThread;
            }

            public final boolean getCanViewArchivedThreads() {
                return this.canViewArchivedThreads;
            }

            public final String getChannelName() {
                return this.channelName;
            }

            /* JADX WARN: Multi-variable type inference failed */
            public int hashCode() {
                String str = this.channelName;
                int iHashCode = (str != null ? str.hashCode() : 0) * 31;
                boolean z2 = this.canCreateThread;
                int i = z2;
                if (z2 != 0) {
                    i = 1;
                }
                int i2 = (iHashCode + i) * 31;
                boolean z3 = this.canViewArchivedThreads;
                int i3 = z3;
                if (z3 != 0) {
                    i3 = 1;
                }
                int i4 = (i2 + i3) * 31;
                boolean z4 = this.isForumChannel;
                return i4 + (z4 ? 1 : z4 ? 1 : 0);
            }

            public final boolean isForumChannel() {
                return this.isForumChannel;
            }

            public String toString() {
                StringBuilder sbU = outline.U("Browser(channelName=");
                sbU.append(this.channelName);
                sbU.append(", canCreateThread=");
                sbU.append(this.canCreateThread);
                sbU.append(", canViewArchivedThreads=");
                sbU.append(this.canViewArchivedThreads);
                sbU.append(", isForumChannel=");
                return outline.O(sbU, this.isForumChannel, ")");
            }
        }

        /* compiled from: WidgetThreadBrowserViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u0019\u0010\u0005\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0013\u001a\u0004\b\u0014\u0010\u0004¨\u0006\u0017"}, d2 = {"Lcom/discord/widgets/channels/threads/browser/WidgetThreadBrowserViewModel$ViewState$GoToChannel;", "Lcom/discord/widgets/channels/threads/browser/WidgetThreadBrowserViewModel$ViewState;", "Lcom/discord/api/channel/Channel;", "component1", "()Lcom/discord/api/channel/Channel;", "channel", "copy", "(Lcom/discord/api/channel/Channel;)Lcom/discord/widgets/channels/threads/browser/WidgetThreadBrowserViewModel$ViewState$GoToChannel;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/discord/api/channel/Channel;", "getChannel", "<init>", "(Lcom/discord/api/channel/Channel;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final /* data */ class GoToChannel extends ViewState {
            private final Channel channel;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public GoToChannel(Channel channel) {
                super(null);
                Intrinsics3.checkNotNullParameter(channel, "channel");
                this.channel = channel;
            }

            public static /* synthetic */ GoToChannel copy$default(GoToChannel goToChannel, Channel channel, int i, Object obj) {
                if ((i & 1) != 0) {
                    channel = goToChannel.channel;
                }
                return goToChannel.copy(channel);
            }

            /* renamed from: component1, reason: from getter */
            public final Channel getChannel() {
                return this.channel;
            }

            public final GoToChannel copy(Channel channel) {
                Intrinsics3.checkNotNullParameter(channel, "channel");
                return new GoToChannel(channel);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof GoToChannel) && Intrinsics3.areEqual(this.channel, ((GoToChannel) other).channel);
                }
                return true;
            }

            public final Channel getChannel() {
                return this.channel;
            }

            public int hashCode() {
                Channel channel = this.channel;
                if (channel != null) {
                    return channel.hashCode();
                }
                return 0;
            }

            public String toString() {
                StringBuilder sbU = outline.U("GoToChannel(channel=");
                sbU.append(this.channel);
                sbU.append(")");
                return sbU.toString();
            }
        }

        private ViewState() {
        }

        public /* synthetic */ ViewState(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ WidgetThreadBrowserViewModel(long j, long j2, StoreChannels storeChannels, StoreGuilds storeGuilds, StorePermissions storePermissions, Observable observable, int i, DefaultConstructorMarker defaultConstructorMarker) {
        StoreChannels channels = (i & 4) != 0 ? StoreStream.INSTANCE.getChannels() : storeChannels;
        StoreGuilds guilds = (i & 8) != 0 ? StoreStream.INSTANCE.getGuilds() : storeGuilds;
        StorePermissions permissions = (i & 16) != 0 ? StoreStream.INSTANCE.getPermissions() : storePermissions;
        this(j, j2, channels, guilds, permissions, (i & 32) != 0 ? Companion.access$observeStoreState(INSTANCE, j2, j, channels, guilds, permissions) : observable);
    }

    public static final /* synthetic */ void access$handleStoreState(WidgetThreadBrowserViewModel widgetThreadBrowserViewModel, StoreState storeState) {
        widgetThreadBrowserViewModel.handleStoreState(storeState);
    }

    @MainThread
    private final void handleStoreState(StoreState storeState) {
        if (getViewState() instanceof ViewState.GoToChannel) {
            return;
        }
        Channel channel = storeState.getChannel();
        String strC = channel != null ? ChannelUtils.c(channel) : null;
        ThreadUtils threadUtils = ThreadUtils.INSTANCE;
        boolean zCanCreateThread = threadUtils.canCreateThread(storeState.getPermissions(), storeState.getChannel(), null, storeState.getGuild());
        boolean zCanViewAllPublicArchivedThreads = threadUtils.canViewAllPublicArchivedThreads(storeState.getChannel(), storeState.getPermissions());
        Channel channel2 = storeState.getChannel();
        updateViewState(new ViewState.Browser(strC, zCanCreateThread, zCanViewAllPublicArchivedThreads, channel2 != null && channel2.getType() == 15));
    }

    public final long getChannelId() {
        return this.channelId;
    }

    public final long getGuildId() {
        return this.guildId;
    }

    public final void openThread(Channel channel) {
        Intrinsics3.checkNotNullParameter(channel, "channel");
        updateViewState(new ViewState.GoToChannel(channel));
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetThreadBrowserViewModel(long j, long j2, StoreChannels storeChannels, StoreGuilds storeGuilds, StorePermissions storePermissions, Observable<StoreState> observable) {
        super(null, 1, null);
        Intrinsics3.checkNotNullParameter(storeChannels, "storeChannels");
        Intrinsics3.checkNotNullParameter(storeGuilds, "storeGuilds");
        Intrinsics3.checkNotNullParameter(storePermissions, "storePermissions");
        Intrinsics3.checkNotNullParameter(observable, "storeStateObservable");
        this.guildId = j;
        this.channelId = j2;
        this.storeChannels = storeChannels;
        this.storeGuilds = storeGuilds;
        this.storePermissions = storePermissions;
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(observable, this, null, 2, null), WidgetThreadBrowserViewModel.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(), 62, (Object) null);
    }
}
