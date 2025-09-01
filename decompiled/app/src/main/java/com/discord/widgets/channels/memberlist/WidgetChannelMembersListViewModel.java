package com.discord.widgets.channels.memberlist;

import android.content.Context;
import androidx.annotation.MainThread;
import b.a.d.AppViewModel;
import b.d.b.a.outline;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.api.role.GuildRole;
import com.discord.models.domain.ModelApplicationStream;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.domain.ModelUserRelationship;
import com.discord.models.member.GuildMember;
import com.discord.models.presence.Presence;
import com.discord.models.user.User;
import com.discord.restapi.RestAPIParams;
import com.discord.stores.StoreApplicationStreaming;
import com.discord.stores.StoreChannelMembers;
import com.discord.stores.StoreChannels;
import com.discord.stores.StoreChannelsSelected;
import com.discord.stores.StoreEmojiCustom;
import com.discord.stores.StoreGuilds;
import com.discord.stores.StoreNavigation;
import com.discord.stores.StorePermissions;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreThreadMembers;
import com.discord.stores.StoreThreadsJoined;
import com.discord.stores.StoreUser;
import com.discord.stores.StoreUserPresence;
import com.discord.stores.StoreUserRelationships;
import com.discord.utilities.error.Error;
import com.discord.utilities.lazy.memberlist.ChannelMemberList;
import com.discord.utilities.permissions.PermissionUtils;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.widgets.channels.memberlist.adapter.ChannelMembersListAdapter;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.ranges.Ranges2;
import rx.Observable;
import rx.subjects.PublishSubject;

/* compiled from: WidgetChannelMembersListViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 02\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0006012345B5\u0012\b\b\u0002\u0010$\u001a\u00020#\u0012\b\b\u0002\u0010+\u001a\u00020*\u0012\b\b\u0002\u0010!\u001a\u00020 \u0012\u000e\b\u0002\u0010-\u001a\b\u0012\u0004\u0012\u00020\u00030\b¢\u0006\u0004\b.\u0010/J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0013\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0004\b\n\u0010\u000bJ'\u0010\u000f\u001a\u00020\u00052\b\u0010\f\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u0011H\u0007¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0017\u001a\u00020\u00052\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015¢\u0006\u0004\b\u0017\u0010\u0018J!\u0010\u001e\u001a\u00020\u00052\n\u0010\u001b\u001a\u00060\u0019j\u0002`\u001a2\u0006\u0010\u001d\u001a\u00020\u001c¢\u0006\u0004\b\u001e\u0010\u001fR\u0016\u0010!\u001a\u00020 8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010$\u001a\u00020#8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b$\u0010%R:\u0010(\u001a&\u0012\f\u0012\n '*\u0004\u0018\u00010\t0\t '*\u0012\u0012\f\u0012\n '*\u0004\u0018\u00010\t0\t\u0018\u00010&0&8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b(\u0010)R\u0016\u0010+\u001a\u00020*8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b+\u0010,¨\u00066"}, d2 = {"Lcom/discord/widgets/channels/memberlist/WidgetChannelMembersListViewModel;", "Lb/a/d/d0;", "Lcom/discord/widgets/channels/memberlist/WidgetChannelMembersListViewModel$ViewState;", "Lcom/discord/widgets/channels/memberlist/WidgetChannelMembersListViewModel$StoreState;", "storeState", "", "handleStoreState", "(Lcom/discord/widgets/channels/memberlist/WidgetChannelMembersListViewModel$StoreState;)V", "Lrx/Observable;", "Lcom/discord/widgets/channels/memberlist/WidgetChannelMembersListViewModel$Event;", "observeEvents", "()Lrx/Observable;", "prevViewState", "Lcom/discord/widgets/channels/memberlist/WidgetChannelMembersListViewModel$ViewState$Loaded;", "newViewState", "updateSubscriptions", "(Lcom/discord/widgets/channels/memberlist/WidgetChannelMembersListViewModel$ViewState;Lcom/discord/widgets/channels/memberlist/WidgetChannelMembersListViewModel$ViewState$Loaded;Lcom/discord/widgets/channels/memberlist/WidgetChannelMembersListViewModel$StoreState;)V", "Lkotlin/ranges/IntRange;", "range", "updateSubscriptionsForChannel", "(Lkotlin/ranges/IntRange;)V", "Lcom/discord/api/channel/Channel;", "channel", "updateSubscriptionsForThread", "(Lcom/discord/api/channel/Channel;)V", "", "Lcom/discord/primitives/ChannelId;", "channelId", "", "isThreadJoined", "onThreadJoinLeaveClicked", "(JZ)V", "Lcom/discord/stores/StoreEmojiCustom;", "storeCustomEmojis", "Lcom/discord/stores/StoreEmojiCustom;", "Lcom/discord/widgets/channels/memberlist/WidgetChannelMembersListViewModel$GuildChannelSubscriber;", "guildChannelSubscriber", "Lcom/discord/widgets/channels/memberlist/WidgetChannelMembersListViewModel$GuildChannelSubscriber;", "Lrx/subjects/PublishSubject;", "kotlin.jvm.PlatformType", "eventSubject", "Lrx/subjects/PublishSubject;", "Lcom/discord/stores/StoreGuilds;", "storeGuilds", "Lcom/discord/stores/StoreGuilds;", "storeStateObservable", "<init>", "(Lcom/discord/widgets/channels/memberlist/WidgetChannelMembersListViewModel$GuildChannelSubscriber;Lcom/discord/stores/StoreGuilds;Lcom/discord/stores/StoreEmojiCustom;Lrx/Observable;)V", "Companion", "Event", "GuildChannelSubscriber", "MemberList", "StoreState", "ViewState", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class WidgetChannelMembersListViewModel extends AppViewModel<ViewState> {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final PublishSubject<Event> eventSubject;
    private final GuildChannelSubscriber guildChannelSubscriber;
    private final StoreEmojiCustom storeCustomEmojis;
    private final StoreGuilds storeGuilds;

    /* compiled from: WidgetChannelMembersListViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\t\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"com/discord/widgets/channels/memberlist/WidgetChannelMembersListViewModel$1", "Lcom/discord/widgets/channels/memberlist/WidgetChannelMembersListViewModel$GuildChannelSubscriber;", "Lcom/discord/api/channel/Channel;", "channel", "Lkotlin/ranges/IntRange;", "range", "", "subscribeToChannelRange", "(Lcom/discord/api/channel/Channel;Lkotlin/ranges/IntRange;)V", "subscribeToThread", "(Lcom/discord/api/channel/Channel;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.channels.memberlist.WidgetChannelMembersListViewModel$1, reason: invalid class name */
    public static final class AnonymousClass1 implements GuildChannelSubscriber {
        @Override // com.discord.widgets.channels.memberlist.WidgetChannelMembersListViewModel.GuildChannelSubscriber
        public void subscribeToChannelRange(Channel channel, Ranges2 range) {
            Intrinsics3.checkNotNullParameter(channel, "channel");
            Intrinsics3.checkNotNullParameter(range, "range");
            StoreStream.INSTANCE.getGuildSubscriptions().subscribeChannelRange(channel.getGuildId(), channel.getId(), range);
        }

        @Override // com.discord.widgets.channels.memberlist.WidgetChannelMembersListViewModel.GuildChannelSubscriber
        public void subscribeToThread(Channel channel) {
            Intrinsics3.checkNotNullParameter(channel, "channel");
            StoreStream.INSTANCE.getGuildSubscriptions().subscribeThread(channel.getGuildId(), channel.getId());
        }
    }

    /* compiled from: WidgetChannelMembersListViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/widgets/channels/memberlist/WidgetChannelMembersListViewModel$StoreState;", "storeState", "", "invoke", "(Lcom/discord/widgets/channels/memberlist/WidgetChannelMembersListViewModel$StoreState;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.channels.memberlist.WidgetChannelMembersListViewModel$2, reason: invalid class name */
    public static final class AnonymousClass2 extends Lambda implements Function1<StoreState, Unit> {
        public AnonymousClass2() {
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
            WidgetChannelMembersListViewModel.access$handleStoreState(WidgetChannelMembersListViewModel.this, storeState);
        }
    }

    /* compiled from: WidgetChannelMembersListViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b \u0010!J\u0097\u0001\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001c2\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0011\u001a\u00020\u00102\b\b\u0002\u0010\u0013\u001a\u00020\u00122\b\b\u0002\u0010\u0015\u001a\u00020\u00142\b\b\u0002\u0010\u0017\u001a\u00020\u00162\b\b\u0002\u0010\u0019\u001a\u00020\u00182\b\b\u0002\u0010\u001b\u001a\u00020\u001aH\u0002¢\u0006\u0004\b\u001e\u0010\u001f¨\u0006\""}, d2 = {"Lcom/discord/widgets/channels/memberlist/WidgetChannelMembersListViewModel$Companion;", "", "Lcom/discord/stores/StoreGuilds;", "storeGuilds", "Lcom/discord/stores/StoreChannelMembers;", "storeChannelMembers", "Lcom/discord/stores/StoreThreadMembers;", "storeThreadMembers", "Lcom/discord/stores/StoreChannelsSelected;", "storeChannelsSelected", "Lcom/discord/stores/StoreNavigation;", "storeNavigation", "Lcom/discord/widgets/channels/memberlist/PrivateChannelMemberListService;", "privateChannelMemberListService", "Lcom/discord/stores/StorePermissions;", "storePermissions", "Lcom/discord/stores/StoreUserRelationships;", "storeUserRelationships", "Lcom/discord/stores/StoreChannels;", "storeChannels", "Lcom/discord/stores/StoreUser;", "storeUser", "Lcom/discord/stores/StoreUserPresence;", "storePresence", "Lcom/discord/stores/StoreApplicationStreaming;", "storeApplicationStreaming", "Lcom/discord/stores/StoreThreadsJoined;", "storeThreadsJoined", "Lrx/Observable;", "Lcom/discord/widgets/channels/memberlist/WidgetChannelMembersListViewModel$StoreState;", "observeStoreState", "(Lcom/discord/stores/StoreGuilds;Lcom/discord/stores/StoreChannelMembers;Lcom/discord/stores/StoreThreadMembers;Lcom/discord/stores/StoreChannelsSelected;Lcom/discord/stores/StoreNavigation;Lcom/discord/widgets/channels/memberlist/PrivateChannelMemberListService;Lcom/discord/stores/StorePermissions;Lcom/discord/stores/StoreUserRelationships;Lcom/discord/stores/StoreChannels;Lcom/discord/stores/StoreUser;Lcom/discord/stores/StoreUserPresence;Lcom/discord/stores/StoreApplicationStreaming;Lcom/discord/stores/StoreThreadsJoined;)Lrx/Observable;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        private final Observable<StoreState> observeStoreState(StoreGuilds storeGuilds, StoreChannelMembers storeChannelMembers, StoreThreadMembers storeThreadMembers, StoreChannelsSelected storeChannelsSelected, StoreNavigation storeNavigation, PrivateChannelMemberListService privateChannelMemberListService, StorePermissions storePermissions, StoreUserRelationships storeUserRelationships, StoreChannels storeChannels, StoreUser storeUser, StoreUserPresence storePresence, StoreApplicationStreaming storeApplicationStreaming, StoreThreadsJoined storeThreadsJoined) {
            Observable observableY = storeChannelsSelected.observeSelectedChannel().Y(new WidgetChannelMembersListViewModel2(storeNavigation.observeRightPanelState().G(WidgetChannelMembersListViewModel3.INSTANCE), privateChannelMemberListService, storeUserRelationships, storeChannels, storePermissions, storeChannelMembers, storeGuilds, storeThreadMembers, storeUser, storePresence, storeApplicationStreaming, storeThreadsJoined));
            Intrinsics3.checkNotNullExpressionValue(observableY, "storeChannelsSelected\n  …            }\n          }");
            return observableY;
        }

        public static /* synthetic */ Observable observeStoreState$default(Companion companion, StoreGuilds storeGuilds, StoreChannelMembers storeChannelMembers, StoreThreadMembers storeThreadMembers, StoreChannelsSelected storeChannelsSelected, StoreNavigation storeNavigation, PrivateChannelMemberListService privateChannelMemberListService, StorePermissions storePermissions, StoreUserRelationships storeUserRelationships, StoreChannels storeChannels, StoreUser storeUser, StoreUserPresence storeUserPresence, StoreApplicationStreaming storeApplicationStreaming, StoreThreadsJoined storeThreadsJoined, int i, Object obj) {
            return companion.observeStoreState((i & 1) != 0 ? StoreStream.INSTANCE.getGuilds() : storeGuilds, (i & 2) != 0 ? StoreStream.INSTANCE.getChannelMembers() : storeChannelMembers, (i & 4) != 0 ? StoreStream.INSTANCE.getThreadMembers() : storeThreadMembers, (i & 8) != 0 ? StoreStream.INSTANCE.getChannelsSelected() : storeChannelsSelected, (i & 16) != 0 ? StoreStream.INSTANCE.getNavigation() : storeNavigation, (i & 32) != 0 ? new PrivateChannelMemberListService(null, null, null, 7, null) : privateChannelMemberListService, (i & 64) != 0 ? StoreStream.INSTANCE.getPermissions() : storePermissions, (i & 128) != 0 ? StoreStream.INSTANCE.getUserRelationships() : storeUserRelationships, (i & 256) != 0 ? StoreStream.INSTANCE.getChannels() : storeChannels, (i & 512) != 0 ? StoreStream.INSTANCE.getUsers() : storeUser, (i & 1024) != 0 ? StoreStream.INSTANCE.getPresences() : storeUserPresence, (i & 2048) != 0 ? StoreStream.INSTANCE.getApplicationStreaming() : storeApplicationStreaming, (i & 4096) != 0 ? StoreStream.INSTANCE.getThreadsJoined() : storeThreadsJoined);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetChannelMembersListViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0004\u0005\u0006B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0003\u0007\b\t¨\u0006\n"}, d2 = {"Lcom/discord/widgets/channels/memberlist/WidgetChannelMembersListViewModel$Event;", "", "<init>", "()V", "Error", "ScrollToTop", "UpdateRanges", "Lcom/discord/widgets/channels/memberlist/WidgetChannelMembersListViewModel$Event$ScrollToTop;", "Lcom/discord/widgets/channels/memberlist/WidgetChannelMembersListViewModel$Event$UpdateRanges;", "Lcom/discord/widgets/channels/memberlist/WidgetChannelMembersListViewModel$Event$Error;", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static abstract class Event {

        /* compiled from: WidgetChannelMembersListViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000b\u0010\u0004J\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fHÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010R\u0019\u0010\u0005\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0011\u001a\u0004\b\u0012\u0010\u0004¨\u0006\u0015"}, d2 = {"Lcom/discord/widgets/channels/memberlist/WidgetChannelMembersListViewModel$Event$Error;", "Lcom/discord/widgets/channels/memberlist/WidgetChannelMembersListViewModel$Event;", "", "component1", "()I", ModelAuditLogEntry.CHANGE_KEY_CODE, "copy", "(I)Lcom/discord/widgets/channels/memberlist/WidgetChannelMembersListViewModel$Event$Error;", "", "toString", "()Ljava/lang/String;", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "I", "getCode", "<init>", "(I)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final /* data */ class Error extends Event {
            private final int code;

            public Error(int i) {
                super(null);
                this.code = i;
            }

            public static /* synthetic */ Error copy$default(Error error, int i, int i2, Object obj) {
                if ((i2 & 1) != 0) {
                    i = error.code;
                }
                return error.copy(i);
            }

            /* renamed from: component1, reason: from getter */
            public final int getCode() {
                return this.code;
            }

            public final Error copy(int code) {
                return new Error(code);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof Error) && this.code == ((Error) other).code;
                }
                return true;
            }

            public final int getCode() {
                return this.code;
            }

            public int hashCode() {
                return this.code;
            }

            public String toString() {
                return outline.B(outline.U("Error(code="), this.code, ")");
            }
        }

        /* compiled from: WidgetChannelMembersListViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/discord/widgets/channels/memberlist/WidgetChannelMembersListViewModel$Event$ScrollToTop;", "Lcom/discord/widgets/channels/memberlist/WidgetChannelMembersListViewModel$Event;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final class ScrollToTop extends Event {
            public static final ScrollToTop INSTANCE = new ScrollToTop();

            private ScrollToTop() {
                super(null);
            }
        }

        /* compiled from: WidgetChannelMembersListViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/discord/widgets/channels/memberlist/WidgetChannelMembersListViewModel$Event$UpdateRanges;", "Lcom/discord/widgets/channels/memberlist/WidgetChannelMembersListViewModel$Event;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final class UpdateRanges extends Event {
            public static final UpdateRanges INSTANCE = new UpdateRanges();

            private UpdateRanges() {
                super(null);
            }
        }

        private Event() {
        }

        public /* synthetic */ Event(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetChannelMembersListViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\t\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/discord/widgets/channels/memberlist/WidgetChannelMembersListViewModel$GuildChannelSubscriber;", "", "Lcom/discord/api/channel/Channel;", "channel", "Lkotlin/ranges/IntRange;", "range", "", "subscribeToChannelRange", "(Lcom/discord/api/channel/Channel;Lkotlin/ranges/IntRange;)V", "subscribeToThread", "(Lcom/discord/api/channel/Channel;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public interface GuildChannelSubscriber {
        void subscribeToChannelRange(Channel channel, Ranges2 range);

        void subscribeToThread(Channel channel);
    }

    /* compiled from: WidgetChannelMembersListViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012J\u0018\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H¦\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\b\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0007\u001a\u00020\u0002H&¢\u0006\u0004\b\b\u0010\tR\u0016\u0010\f\u001a\u00020\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\u0011\u001a\u00060\rj\u0002`\u000e8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0013"}, d2 = {"Lcom/discord/widgets/channels/memberlist/WidgetChannelMembersListViewModel$MemberList;", "", "", "index", "Lcom/discord/widgets/channels/memberlist/adapter/ChannelMembersListAdapter$Item;", "get", "(I)Lcom/discord/widgets/channels/memberlist/adapter/ChannelMembersListAdapter$Item;", "itemPosition", "getHeaderPositionForItem", "(I)Ljava/lang/Integer;", "getSize", "()I", "size", "", "Lcom/discord/primitives/MemberListId;", "getListId", "()Ljava/lang/String;", "listId", "Companion", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public interface MemberList {

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = Companion.$$INSTANCE;

        /* compiled from: WidgetChannelMembersListViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0019\u0010\u0003\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/discord/widgets/channels/memberlist/WidgetChannelMembersListViewModel$MemberList$Companion;", "", "Lcom/discord/widgets/channels/memberlist/WidgetChannelMembersListViewModel$MemberList;", "EMPTY", "Lcom/discord/widgets/channels/memberlist/WidgetChannelMembersListViewModel$MemberList;", "getEMPTY", "()Lcom/discord/widgets/channels/memberlist/WidgetChannelMembersListViewModel$MemberList;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final class Companion {
            public static final /* synthetic */ Companion $$INSTANCE = new Companion();
            private static final MemberList EMPTY = new WidgetChannelMembersListViewModel4();

            private Companion() {
            }

            public final MemberList getEMPTY() {
                return EMPTY;
            }
        }

        ChannelMembersListAdapter.Item get(int index);

        Integer getHeaderPositionForItem(int itemPosition);

        String getListId();

        int getSize();
    }

    /* compiled from: WidgetChannelMembersListViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0004\r\u000e\u000f\u0010B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u000b\u0010\fR\u001c\u0010\u0003\u001a\u00020\u00028\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005R\u001e\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n\u0082\u0001\u0004\u0011\u0012\u0013\u0014¨\u0006\u0015"}, d2 = {"Lcom/discord/widgets/channels/memberlist/WidgetChannelMembersListViewModel$StoreState;", "", "", "isPanelOpen", "Z", "()Z", "Lcom/discord/api/channel/Channel;", "channel", "Lcom/discord/api/channel/Channel;", "getChannel", "()Lcom/discord/api/channel/Channel;", "<init>", "(ZLcom/discord/api/channel/Channel;)V", "Guild", "None", "Private", "Thread", "Lcom/discord/widgets/channels/memberlist/WidgetChannelMembersListViewModel$StoreState$None;", "Lcom/discord/widgets/channels/memberlist/WidgetChannelMembersListViewModel$StoreState$Guild;", "Lcom/discord/widgets/channels/memberlist/WidgetChannelMembersListViewModel$StoreState$Private;", "Lcom/discord/widgets/channels/memberlist/WidgetChannelMembersListViewModel$StoreState$Thread;", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static abstract class StoreState {
        private final Channel channel;
        private final boolean isPanelOpen;

        /* compiled from: WidgetChannelMembersListViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0011\b\u0086\b\u0018\u00002\u00020\u0001BQ\u0012\u0006\u0010\u0017\u001a\u00020\u0002\u0012\u0006\u0010\u0018\u001a\u00020\u0005\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\u001a\u001a\u00020\u000b\u0012\u000e\u0010\u001b\u001a\n\u0018\u00010\u000ej\u0004\u0018\u0001`\u000f\u0012\u0016\u0010\u001c\u001a\u0012\u0012\b\u0012\u00060\u000ej\u0002`\u0013\u0012\u0004\u0012\u00020\u00140\u0012¢\u0006\u0004\b4\u00105J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\t\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÆ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0018\u0010\u0010\u001a\n\u0018\u00010\u000ej\u0004\u0018\u0001`\u000fHÆ\u0003¢\u0006\u0004\b\u0010\u0010\u0011J \u0010\u0015\u001a\u0012\u0012\b\u0012\u00060\u000ej\u0002`\u0013\u0012\u0004\u0012\u00020\u00140\u0012HÆ\u0003¢\u0006\u0004\b\u0015\u0010\u0016Jf\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0017\u001a\u00020\u00022\b\b\u0002\u0010\u0018\u001a\u00020\u00052\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\u001a\u001a\u00020\u000b2\u0010\b\u0002\u0010\u001b\u001a\n\u0018\u00010\u000ej\u0004\u0018\u0001`\u000f2\u0018\b\u0002\u0010\u001c\u001a\u0012\u0012\b\u0012\u00060\u000ej\u0002`\u0013\u0012\u0004\u0012\u00020\u00140\u0012HÆ\u0001¢\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010 \u001a\u00020\u001fHÖ\u0001¢\u0006\u0004\b \u0010!J\u0010\u0010#\u001a\u00020\"HÖ\u0001¢\u0006\u0004\b#\u0010$J\u001a\u0010'\u001a\u00020\u00022\b\u0010&\u001a\u0004\u0018\u00010%HÖ\u0003¢\u0006\u0004\b'\u0010(R)\u0010\u001c\u001a\u0012\u0012\b\u0012\u00060\u000ej\u0002`\u0013\u0012\u0004\u0012\u00020\u00140\u00128\u0006@\u0006¢\u0006\f\n\u0004\b\u001c\u0010)\u001a\u0004\b*\u0010\u0016R\u001c\u0010\u0017\u001a\u00020\u00028\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0017\u0010+\u001a\u0004\b\u0017\u0010\u0004R\u0019\u0010\u001a\u001a\u00020\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\u001a\u0010,\u001a\u0004\b-\u0010\rR\u001c\u0010\u0018\u001a\u00020\u00058\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0018\u0010.\u001a\u0004\b/\u0010\u0007R\u001b\u0010\u0019\u001a\u0004\u0018\u00010\b8\u0006@\u0006¢\u0006\f\n\u0004\b\u0019\u00100\u001a\u0004\b1\u0010\nR!\u0010\u001b\u001a\n\u0018\u00010\u000ej\u0004\u0018\u0001`\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b\u001b\u00102\u001a\u0004\b3\u0010\u0011¨\u00066"}, d2 = {"Lcom/discord/widgets/channels/memberlist/WidgetChannelMembersListViewModel$StoreState$Guild;", "Lcom/discord/widgets/channels/memberlist/WidgetChannelMembersListViewModel$StoreState;", "", "component1", "()Z", "Lcom/discord/api/channel/Channel;", "component2", "()Lcom/discord/api/channel/Channel;", "Lcom/discord/models/guild/Guild;", "component3", "()Lcom/discord/models/guild/Guild;", "Lcom/discord/utilities/lazy/memberlist/ChannelMemberList;", "component4", "()Lcom/discord/utilities/lazy/memberlist/ChannelMemberList;", "", "Lcom/discord/api/permission/PermissionBit;", "component5", "()Ljava/lang/Long;", "", "Lcom/discord/primitives/RoleId;", "Lcom/discord/api/role/GuildRole;", "component6", "()Ljava/util/Map;", "isPanelOpen", "channel", "guild", "channelMembers", "channelPermissions", "guildRoles", "copy", "(ZLcom/discord/api/channel/Channel;Lcom/discord/models/guild/Guild;Lcom/discord/utilities/lazy/memberlist/ChannelMemberList;Ljava/lang/Long;Ljava/util/Map;)Lcom/discord/widgets/channels/memberlist/WidgetChannelMembersListViewModel$StoreState$Guild;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "Ljava/util/Map;", "getGuildRoles", "Z", "Lcom/discord/utilities/lazy/memberlist/ChannelMemberList;", "getChannelMembers", "Lcom/discord/api/channel/Channel;", "getChannel", "Lcom/discord/models/guild/Guild;", "getGuild", "Ljava/lang/Long;", "getChannelPermissions", "<init>", "(ZLcom/discord/api/channel/Channel;Lcom/discord/models/guild/Guild;Lcom/discord/utilities/lazy/memberlist/ChannelMemberList;Ljava/lang/Long;Ljava/util/Map;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final /* data */ class Guild extends StoreState {
            private final Channel channel;
            private final ChannelMemberList channelMembers;
            private final Long channelPermissions;
            private final com.discord.models.guild.Guild guild;
            private final Map<Long, GuildRole> guildRoles;
            private final boolean isPanelOpen;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Guild(boolean z2, Channel channel, com.discord.models.guild.Guild guild, ChannelMemberList channelMemberList, Long l, Map<Long, GuildRole> map) {
                super(z2, channel, null);
                Intrinsics3.checkNotNullParameter(channel, "channel");
                Intrinsics3.checkNotNullParameter(channelMemberList, "channelMembers");
                Intrinsics3.checkNotNullParameter(map, "guildRoles");
                this.isPanelOpen = z2;
                this.channel = channel;
                this.guild = guild;
                this.channelMembers = channelMemberList;
                this.channelPermissions = l;
                this.guildRoles = map;
            }

            public static /* synthetic */ Guild copy$default(Guild guild, boolean z2, Channel channel, com.discord.models.guild.Guild guild2, ChannelMemberList channelMemberList, Long l, Map map, int i, Object obj) {
                if ((i & 1) != 0) {
                    z2 = guild.getIsPanelOpen();
                }
                if ((i & 2) != 0) {
                    channel = guild.getChannel();
                }
                Channel channel2 = channel;
                if ((i & 4) != 0) {
                    guild2 = guild.guild;
                }
                com.discord.models.guild.Guild guild3 = guild2;
                if ((i & 8) != 0) {
                    channelMemberList = guild.channelMembers;
                }
                ChannelMemberList channelMemberList2 = channelMemberList;
                if ((i & 16) != 0) {
                    l = guild.channelPermissions;
                }
                Long l2 = l;
                if ((i & 32) != 0) {
                    map = guild.guildRoles;
                }
                return guild.copy(z2, channel2, guild3, channelMemberList2, l2, map);
            }

            public final boolean component1() {
                return getIsPanelOpen();
            }

            public final Channel component2() {
                return getChannel();
            }

            /* renamed from: component3, reason: from getter */
            public final com.discord.models.guild.Guild getGuild() {
                return this.guild;
            }

            /* renamed from: component4, reason: from getter */
            public final ChannelMemberList getChannelMembers() {
                return this.channelMembers;
            }

            /* renamed from: component5, reason: from getter */
            public final Long getChannelPermissions() {
                return this.channelPermissions;
            }

            public final Map<Long, GuildRole> component6() {
                return this.guildRoles;
            }

            public final Guild copy(boolean isPanelOpen, Channel channel, com.discord.models.guild.Guild guild, ChannelMemberList channelMembers, Long channelPermissions, Map<Long, GuildRole> guildRoles) {
                Intrinsics3.checkNotNullParameter(channel, "channel");
                Intrinsics3.checkNotNullParameter(channelMembers, "channelMembers");
                Intrinsics3.checkNotNullParameter(guildRoles, "guildRoles");
                return new Guild(isPanelOpen, channel, guild, channelMembers, channelPermissions, guildRoles);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Guild)) {
                    return false;
                }
                Guild guild = (Guild) other;
                return getIsPanelOpen() == guild.getIsPanelOpen() && Intrinsics3.areEqual(getChannel(), guild.getChannel()) && Intrinsics3.areEqual(this.guild, guild.guild) && Intrinsics3.areEqual(this.channelMembers, guild.channelMembers) && Intrinsics3.areEqual(this.channelPermissions, guild.channelPermissions) && Intrinsics3.areEqual(this.guildRoles, guild.guildRoles);
            }

            @Override // com.discord.widgets.channels.memberlist.WidgetChannelMembersListViewModel.StoreState
            public Channel getChannel() {
                return this.channel;
            }

            public final ChannelMemberList getChannelMembers() {
                return this.channelMembers;
            }

            public final Long getChannelPermissions() {
                return this.channelPermissions;
            }

            public final com.discord.models.guild.Guild getGuild() {
                return this.guild;
            }

            public final Map<Long, GuildRole> getGuildRoles() {
                return this.guildRoles;
            }

            public int hashCode() {
                boolean isPanelOpen = getIsPanelOpen();
                int i = isPanelOpen;
                if (isPanelOpen) {
                    i = 1;
                }
                int i2 = i * 31;
                Channel channel = getChannel();
                int iHashCode = (i2 + (channel != null ? channel.hashCode() : 0)) * 31;
                com.discord.models.guild.Guild guild = this.guild;
                int iHashCode2 = (iHashCode + (guild != null ? guild.hashCode() : 0)) * 31;
                ChannelMemberList channelMemberList = this.channelMembers;
                int iHashCode3 = (iHashCode2 + (channelMemberList != null ? channelMemberList.hashCode() : 0)) * 31;
                Long l = this.channelPermissions;
                int iHashCode4 = (iHashCode3 + (l != null ? l.hashCode() : 0)) * 31;
                Map<Long, GuildRole> map = this.guildRoles;
                return iHashCode4 + (map != null ? map.hashCode() : 0);
            }

            @Override // com.discord.widgets.channels.memberlist.WidgetChannelMembersListViewModel.StoreState
            /* renamed from: isPanelOpen, reason: from getter */
            public boolean getIsPanelOpen() {
                return this.isPanelOpen;
            }

            public String toString() {
                StringBuilder sbU = outline.U("Guild(isPanelOpen=");
                sbU.append(getIsPanelOpen());
                sbU.append(", channel=");
                sbU.append(getChannel());
                sbU.append(", guild=");
                sbU.append(this.guild);
                sbU.append(", channelMembers=");
                sbU.append(this.channelMembers);
                sbU.append(", channelPermissions=");
                sbU.append(this.channelPermissions);
                sbU.append(", guildRoles=");
                return outline.M(sbU, this.guildRoles, ")");
            }
        }

        /* compiled from: WidgetChannelMembersListViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0010\u001a\u00020\u00022\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0005\u001a\u00020\u00028\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u0012\u001a\u0004\b\u0005\u0010\u0004¨\u0006\u0015"}, d2 = {"Lcom/discord/widgets/channels/memberlist/WidgetChannelMembersListViewModel$StoreState$None;", "Lcom/discord/widgets/channels/memberlist/WidgetChannelMembersListViewModel$StoreState;", "", "component1", "()Z", "isPanelOpen", "copy", "(Z)Lcom/discord/widgets/channels/memberlist/WidgetChannelMembersListViewModel$StoreState$None;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "Z", "<init>", "(Z)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final /* data */ class None extends StoreState {
            private final boolean isPanelOpen;

            public None(boolean z2) {
                super(z2, null, null);
                this.isPanelOpen = z2;
            }

            public static /* synthetic */ None copy$default(None none, boolean z2, int i, Object obj) {
                if ((i & 1) != 0) {
                    z2 = none.getIsPanelOpen();
                }
                return none.copy(z2);
            }

            public final boolean component1() {
                return getIsPanelOpen();
            }

            public final None copy(boolean isPanelOpen) {
                return new None(isPanelOpen);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof None) && getIsPanelOpen() == ((None) other).getIsPanelOpen();
                }
                return true;
            }

            public int hashCode() {
                boolean isPanelOpen = getIsPanelOpen();
                if (isPanelOpen) {
                    return 1;
                }
                return isPanelOpen ? 1 : 0;
            }

            @Override // com.discord.widgets.channels.memberlist.WidgetChannelMembersListViewModel.StoreState
            /* renamed from: isPanelOpen, reason: from getter */
            public boolean getIsPanelOpen() {
                return this.isPanelOpen;
            }

            public String toString() {
                StringBuilder sbU = outline.U("None(isPanelOpen=");
                sbU.append(getIsPanelOpen());
                sbU.append(")");
                return sbU.toString();
            }
        }

        /* compiled from: WidgetChannelMembersListViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u000e\b\u0086\b\u0018\u00002\u00020\u0001B{\u0012\u0006\u0010\u0015\u001a\u00020\u0002\u0012\u0006\u0010\u0016\u001a\u00020\u0005\u0012\u0016\u0010\u0017\u001a\u0012\u0012\b\u0012\u00060\tj\u0002`\n\u0012\u0004\u0012\u00020\u000b0\b\u0012\u0016\u0010\u0018\u001a\u0012\u0012\b\u0012\u00060\tj\u0002`\n\u0012\u0004\u0012\u00020\u000e0\b\u0012\u0016\u0010\u0019\u001a\u0012\u0012\b\u0012\u00060\tj\u0002`\n\u0012\u0004\u0012\u00020\u00100\b\u0012\u001a\u0010\u001a\u001a\u0016\u0012\b\u0012\u00060\tj\u0002`\n\u0012\b\u0012\u00060\u0012j\u0002`\u00130\b¢\u0006\u0004\b.\u0010/J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J \u0010\f\u001a\u0012\u0012\b\u0012\u00060\tj\u0002`\n\u0012\u0004\u0012\u00020\u000b0\bHÆ\u0003¢\u0006\u0004\b\f\u0010\rJ \u0010\u000f\u001a\u0012\u0012\b\u0012\u00060\tj\u0002`\n\u0012\u0004\u0012\u00020\u000e0\bHÆ\u0003¢\u0006\u0004\b\u000f\u0010\rJ \u0010\u0011\u001a\u0012\u0012\b\u0012\u00060\tj\u0002`\n\u0012\u0004\u0012\u00020\u00100\bHÆ\u0003¢\u0006\u0004\b\u0011\u0010\rJ$\u0010\u0014\u001a\u0016\u0012\b\u0012\u00060\tj\u0002`\n\u0012\b\u0012\u00060\u0012j\u0002`\u00130\bHÆ\u0003¢\u0006\u0004\b\u0014\u0010\rJ\u0090\u0001\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0015\u001a\u00020\u00022\b\b\u0002\u0010\u0016\u001a\u00020\u00052\u0018\b\u0002\u0010\u0017\u001a\u0012\u0012\b\u0012\u00060\tj\u0002`\n\u0012\u0004\u0012\u00020\u000b0\b2\u0018\b\u0002\u0010\u0018\u001a\u0012\u0012\b\u0012\u00060\tj\u0002`\n\u0012\u0004\u0012\u00020\u000e0\b2\u0018\b\u0002\u0010\u0019\u001a\u0012\u0012\b\u0012\u00060\tj\u0002`\n\u0012\u0004\u0012\u00020\u00100\b2\u001c\b\u0002\u0010\u001a\u001a\u0016\u0012\b\u0012\u00060\tj\u0002`\n\u0012\b\u0012\u00060\u0012j\u0002`\u00130\bHÆ\u0001¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u001e\u001a\u00020\u001dHÖ\u0001¢\u0006\u0004\b\u001e\u0010\u001fJ\u0010\u0010 \u001a\u00020\u0012HÖ\u0001¢\u0006\u0004\b \u0010!J\u001a\u0010$\u001a\u00020\u00022\b\u0010#\u001a\u0004\u0018\u00010\"HÖ\u0003¢\u0006\u0004\b$\u0010%R)\u0010\u0019\u001a\u0012\u0012\b\u0012\u00060\tj\u0002`\n\u0012\u0004\u0012\u00020\u00100\b8\u0006@\u0006¢\u0006\f\n\u0004\b\u0019\u0010&\u001a\u0004\b'\u0010\rR-\u0010\u001a\u001a\u0016\u0012\b\u0012\u00060\tj\u0002`\n\u0012\b\u0012\u00060\u0012j\u0002`\u00130\b8\u0006@\u0006¢\u0006\f\n\u0004\b\u001a\u0010&\u001a\u0004\b(\u0010\rR\u001c\u0010\u0015\u001a\u00020\u00028\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0015\u0010)\u001a\u0004\b\u0015\u0010\u0004R)\u0010\u0017\u001a\u0012\u0012\b\u0012\u00060\tj\u0002`\n\u0012\u0004\u0012\u00020\u000b0\b8\u0006@\u0006¢\u0006\f\n\u0004\b\u0017\u0010&\u001a\u0004\b*\u0010\rR\u001c\u0010\u0016\u001a\u00020\u00058\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0016\u0010+\u001a\u0004\b,\u0010\u0007R)\u0010\u0018\u001a\u0012\u0012\b\u0012\u00060\tj\u0002`\n\u0012\u0004\u0012\u00020\u000e0\b8\u0006@\u0006¢\u0006\f\n\u0004\b\u0018\u0010&\u001a\u0004\b-\u0010\r¨\u00060"}, d2 = {"Lcom/discord/widgets/channels/memberlist/WidgetChannelMembersListViewModel$StoreState$Private;", "Lcom/discord/widgets/channels/memberlist/WidgetChannelMembersListViewModel$StoreState;", "", "component1", "()Z", "Lcom/discord/api/channel/Channel;", "component2", "()Lcom/discord/api/channel/Channel;", "", "", "Lcom/discord/primitives/UserId;", "Lcom/discord/models/user/User;", "component3", "()Ljava/util/Map;", "Lcom/discord/models/presence/Presence;", "component4", "Lcom/discord/models/domain/ModelApplicationStream;", "component5", "", "Lcom/discord/primitives/RelationshipType;", "component6", "isPanelOpen", "channel", "users", "presences", "applicationStreams", "relationships", "copy", "(ZLcom/discord/api/channel/Channel;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;)Lcom/discord/widgets/channels/memberlist/WidgetChannelMembersListViewModel$StoreState$Private;", "", "toString", "()Ljava/lang/String;", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "Ljava/util/Map;", "getApplicationStreams", "getRelationships", "Z", "getUsers", "Lcom/discord/api/channel/Channel;", "getChannel", "getPresences", "<init>", "(ZLcom/discord/api/channel/Channel;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final /* data */ class Private extends StoreState {
            private final Map<Long, ModelApplicationStream> applicationStreams;
            private final Channel channel;
            private final boolean isPanelOpen;
            private final Map<Long, Presence> presences;
            private final Map<Long, Integer> relationships;
            private final Map<Long, User> users;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            public Private(boolean z2, Channel channel, Map<Long, ? extends User> map, Map<Long, Presence> map2, Map<Long, ? extends ModelApplicationStream> map3, Map<Long, Integer> map4) {
                super(z2, channel, null);
                Intrinsics3.checkNotNullParameter(channel, "channel");
                Intrinsics3.checkNotNullParameter(map, "users");
                Intrinsics3.checkNotNullParameter(map2, "presences");
                Intrinsics3.checkNotNullParameter(map3, "applicationStreams");
                Intrinsics3.checkNotNullParameter(map4, "relationships");
                this.isPanelOpen = z2;
                this.channel = channel;
                this.users = map;
                this.presences = map2;
                this.applicationStreams = map3;
                this.relationships = map4;
            }

            public static /* synthetic */ Private copy$default(Private r4, boolean z2, Channel channel, Map map, Map map2, Map map3, Map map4, int i, Object obj) {
                if ((i & 1) != 0) {
                    z2 = r4.getIsPanelOpen();
                }
                if ((i & 2) != 0) {
                    channel = r4.getChannel();
                }
                Channel channel2 = channel;
                if ((i & 4) != 0) {
                    map = r4.users;
                }
                Map map5 = map;
                if ((i & 8) != 0) {
                    map2 = r4.presences;
                }
                Map map6 = map2;
                if ((i & 16) != 0) {
                    map3 = r4.applicationStreams;
                }
                Map map7 = map3;
                if ((i & 32) != 0) {
                    map4 = r4.relationships;
                }
                return r4.copy(z2, channel2, map5, map6, map7, map4);
            }

            public final boolean component1() {
                return getIsPanelOpen();
            }

            public final Channel component2() {
                return getChannel();
            }

            public final Map<Long, User> component3() {
                return this.users;
            }

            public final Map<Long, Presence> component4() {
                return this.presences;
            }

            public final Map<Long, ModelApplicationStream> component5() {
                return this.applicationStreams;
            }

            public final Map<Long, Integer> component6() {
                return this.relationships;
            }

            public final Private copy(boolean isPanelOpen, Channel channel, Map<Long, ? extends User> users, Map<Long, Presence> presences, Map<Long, ? extends ModelApplicationStream> applicationStreams, Map<Long, Integer> relationships) {
                Intrinsics3.checkNotNullParameter(channel, "channel");
                Intrinsics3.checkNotNullParameter(users, "users");
                Intrinsics3.checkNotNullParameter(presences, "presences");
                Intrinsics3.checkNotNullParameter(applicationStreams, "applicationStreams");
                Intrinsics3.checkNotNullParameter(relationships, "relationships");
                return new Private(isPanelOpen, channel, users, presences, applicationStreams, relationships);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Private)) {
                    return false;
                }
                Private r3 = (Private) other;
                return getIsPanelOpen() == r3.getIsPanelOpen() && Intrinsics3.areEqual(getChannel(), r3.getChannel()) && Intrinsics3.areEqual(this.users, r3.users) && Intrinsics3.areEqual(this.presences, r3.presences) && Intrinsics3.areEqual(this.applicationStreams, r3.applicationStreams) && Intrinsics3.areEqual(this.relationships, r3.relationships);
            }

            public final Map<Long, ModelApplicationStream> getApplicationStreams() {
                return this.applicationStreams;
            }

            @Override // com.discord.widgets.channels.memberlist.WidgetChannelMembersListViewModel.StoreState
            public Channel getChannel() {
                return this.channel;
            }

            public final Map<Long, Presence> getPresences() {
                return this.presences;
            }

            public final Map<Long, Integer> getRelationships() {
                return this.relationships;
            }

            public final Map<Long, User> getUsers() {
                return this.users;
            }

            public int hashCode() {
                boolean isPanelOpen = getIsPanelOpen();
                int i = isPanelOpen;
                if (isPanelOpen) {
                    i = 1;
                }
                int i2 = i * 31;
                Channel channel = getChannel();
                int iHashCode = (i2 + (channel != null ? channel.hashCode() : 0)) * 31;
                Map<Long, User> map = this.users;
                int iHashCode2 = (iHashCode + (map != null ? map.hashCode() : 0)) * 31;
                Map<Long, Presence> map2 = this.presences;
                int iHashCode3 = (iHashCode2 + (map2 != null ? map2.hashCode() : 0)) * 31;
                Map<Long, ModelApplicationStream> map3 = this.applicationStreams;
                int iHashCode4 = (iHashCode3 + (map3 != null ? map3.hashCode() : 0)) * 31;
                Map<Long, Integer> map4 = this.relationships;
                return iHashCode4 + (map4 != null ? map4.hashCode() : 0);
            }

            @Override // com.discord.widgets.channels.memberlist.WidgetChannelMembersListViewModel.StoreState
            /* renamed from: isPanelOpen, reason: from getter */
            public boolean getIsPanelOpen() {
                return this.isPanelOpen;
            }

            public String toString() {
                StringBuilder sbU = outline.U("Private(isPanelOpen=");
                sbU.append(getIsPanelOpen());
                sbU.append(", channel=");
                sbU.append(getChannel());
                sbU.append(", users=");
                sbU.append(this.users);
                sbU.append(", presences=");
                sbU.append(this.presences);
                sbU.append(", applicationStreams=");
                sbU.append(this.applicationStreams);
                sbU.append(", relationships=");
                return outline.M(sbU, this.relationships, ")");
            }
        }

        /* compiled from: WidgetChannelMembersListViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0016\b\u0086\b\u0018\u00002\u00020\u0001B¿\u0001\u0012\u0006\u0010!\u001a\u00020\u0002\u0012\u0006\u0010\"\u001a\u00020\u0005\u0012\b\u0010#\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010$\u001a\u0004\u0018\u00010\t\u0012\u0016\u0010%\u001a\u0012\u0012\b\u0012\u00060\rj\u0002`\u000e\u0012\u0004\u0012\u00020\u000f0\f\u0012\u0016\u0010&\u001a\u0012\u0012\b\u0012\u00060\rj\u0002`\u0012\u0012\u0004\u0012\u00020\u00130\f\u0012\u0016\u0010'\u001a\u0012\u0012\b\u0012\u00060\rj\u0002`\u0012\u0012\u0004\u0012\u00020\u00150\f\u0012\u0016\u0010(\u001a\u0012\u0012\b\u0012\u00060\rj\u0002`\u0012\u0012\u0004\u0012\u00020\u00170\f\u0012\u0016\u0010)\u001a\u0012\u0012\b\u0012\u00060\rj\u0002`\u0012\u0012\u0004\u0012\u00020\u00190\f\u0012\u0010\u0010*\u001a\f\u0012\b\u0012\u00060\rj\u0002`\u00120\u001b\u0012\b\u0010+\u001a\u0004\u0018\u00010\u001e¢\u0006\u0004\bH\u0010IJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\b\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\b\u0010\u0007J\u0012\u0010\n\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ \u0010\u0010\u001a\u0012\u0012\b\u0012\u00060\rj\u0002`\u000e\u0012\u0004\u0012\u00020\u000f0\fHÆ\u0003¢\u0006\u0004\b\u0010\u0010\u0011J \u0010\u0014\u001a\u0012\u0012\b\u0012\u00060\rj\u0002`\u0012\u0012\u0004\u0012\u00020\u00130\fHÆ\u0003¢\u0006\u0004\b\u0014\u0010\u0011J \u0010\u0016\u001a\u0012\u0012\b\u0012\u00060\rj\u0002`\u0012\u0012\u0004\u0012\u00020\u00150\fHÆ\u0003¢\u0006\u0004\b\u0016\u0010\u0011J \u0010\u0018\u001a\u0012\u0012\b\u0012\u00060\rj\u0002`\u0012\u0012\u0004\u0012\u00020\u00170\fHÆ\u0003¢\u0006\u0004\b\u0018\u0010\u0011J \u0010\u001a\u001a\u0012\u0012\b\u0012\u00060\rj\u0002`\u0012\u0012\u0004\u0012\u00020\u00190\fHÆ\u0003¢\u0006\u0004\b\u001a\u0010\u0011J\u001a\u0010\u001c\u001a\f\u0012\b\u0012\u00060\rj\u0002`\u00120\u001bHÆ\u0003¢\u0006\u0004\b\u001c\u0010\u001dJ\u0012\u0010\u001f\u001a\u0004\u0018\u00010\u001eHÆ\u0003¢\u0006\u0004\b\u001f\u0010 JÞ\u0001\u0010,\u001a\u00020\u00002\b\b\u0002\u0010!\u001a\u00020\u00022\b\b\u0002\u0010\"\u001a\u00020\u00052\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\t2\u0018\b\u0002\u0010%\u001a\u0012\u0012\b\u0012\u00060\rj\u0002`\u000e\u0012\u0004\u0012\u00020\u000f0\f2\u0018\b\u0002\u0010&\u001a\u0012\u0012\b\u0012\u00060\rj\u0002`\u0012\u0012\u0004\u0012\u00020\u00130\f2\u0018\b\u0002\u0010'\u001a\u0012\u0012\b\u0012\u00060\rj\u0002`\u0012\u0012\u0004\u0012\u00020\u00150\f2\u0018\b\u0002\u0010(\u001a\u0012\u0012\b\u0012\u00060\rj\u0002`\u0012\u0012\u0004\u0012\u00020\u00170\f2\u0018\b\u0002\u0010)\u001a\u0012\u0012\b\u0012\u00060\rj\u0002`\u0012\u0012\u0004\u0012\u00020\u00190\f2\u0012\b\u0002\u0010*\u001a\f\u0012\b\u0012\u00060\rj\u0002`\u00120\u001b2\n\b\u0002\u0010+\u001a\u0004\u0018\u00010\u001eHÆ\u0001¢\u0006\u0004\b,\u0010-J\u0010\u0010/\u001a\u00020.HÖ\u0001¢\u0006\u0004\b/\u00100J\u0010\u00102\u001a\u000201HÖ\u0001¢\u0006\u0004\b2\u00103J\u001a\u00106\u001a\u00020\u00022\b\u00105\u001a\u0004\u0018\u000104HÖ\u0003¢\u0006\u0004\b6\u00107R\u001b\u0010#\u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b#\u00108\u001a\u0004\b9\u0010\u0007R)\u0010'\u001a\u0012\u0012\b\u0012\u00060\rj\u0002`\u0012\u0012\u0004\u0012\u00020\u00150\f8\u0006@\u0006¢\u0006\f\n\u0004\b'\u0010:\u001a\u0004\b;\u0010\u0011R)\u0010)\u001a\u0012\u0012\b\u0012\u00060\rj\u0002`\u0012\u0012\u0004\u0012\u00020\u00190\f8\u0006@\u0006¢\u0006\f\n\u0004\b)\u0010:\u001a\u0004\b<\u0010\u0011R)\u0010&\u001a\u0012\u0012\b\u0012\u00060\rj\u0002`\u0012\u0012\u0004\u0012\u00020\u00130\f8\u0006@\u0006¢\u0006\f\n\u0004\b&\u0010:\u001a\u0004\b=\u0010\u0011R\u001b\u0010+\u001a\u0004\u0018\u00010\u001e8\u0006@\u0006¢\u0006\f\n\u0004\b+\u0010>\u001a\u0004\b?\u0010 R\u001b\u0010$\u001a\u0004\u0018\u00010\t8\u0006@\u0006¢\u0006\f\n\u0004\b$\u0010@\u001a\u0004\bA\u0010\u000bR\u001c\u0010!\u001a\u00020\u00028\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b!\u0010B\u001a\u0004\b!\u0010\u0004R\u001c\u0010\"\u001a\u00020\u00058\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\"\u00108\u001a\u0004\bC\u0010\u0007R)\u0010%\u001a\u0012\u0012\b\u0012\u00060\rj\u0002`\u000e\u0012\u0004\u0012\u00020\u000f0\f8\u0006@\u0006¢\u0006\f\n\u0004\b%\u0010:\u001a\u0004\bD\u0010\u0011R#\u0010*\u001a\f\u0012\b\u0012\u00060\rj\u0002`\u00120\u001b8\u0006@\u0006¢\u0006\f\n\u0004\b*\u0010E\u001a\u0004\bF\u0010\u001dR)\u0010(\u001a\u0012\u0012\b\u0012\u00060\rj\u0002`\u0012\u0012\u0004\u0012\u00020\u00170\f8\u0006@\u0006¢\u0006\f\n\u0004\b(\u0010:\u001a\u0004\bG\u0010\u0011¨\u0006J"}, d2 = {"Lcom/discord/widgets/channels/memberlist/WidgetChannelMembersListViewModel$StoreState$Thread;", "Lcom/discord/widgets/channels/memberlist/WidgetChannelMembersListViewModel$StoreState;", "", "component1", "()Z", "Lcom/discord/api/channel/Channel;", "component2", "()Lcom/discord/api/channel/Channel;", "component3", "Lcom/discord/models/guild/Guild;", "component4", "()Lcom/discord/models/guild/Guild;", "", "", "Lcom/discord/primitives/RoleId;", "Lcom/discord/api/role/GuildRole;", "component5", "()Ljava/util/Map;", "Lcom/discord/primitives/UserId;", "Lcom/discord/models/member/GuildMember;", "component6", "Lcom/discord/models/user/User;", "component7", "Lcom/discord/models/presence/Presence;", "component8", "Lcom/discord/models/domain/ModelApplicationStream;", "component9", "", "component10", "()Ljava/util/Set;", "Lcom/discord/stores/StoreThreadsJoined$JoinedThread;", "component11", "()Lcom/discord/stores/StoreThreadsJoined$JoinedThread;", "isPanelOpen", "channel", "parentChannel", "guild", "roles", "guildMembers", "users", "presences", "streams", "threadMembers", "joinedThread", "copy", "(ZLcom/discord/api/channel/Channel;Lcom/discord/api/channel/Channel;Lcom/discord/models/guild/Guild;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/util/Set;Lcom/discord/stores/StoreThreadsJoined$JoinedThread;)Lcom/discord/widgets/channels/memberlist/WidgetChannelMembersListViewModel$StoreState$Thread;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "Lcom/discord/api/channel/Channel;", "getParentChannel", "Ljava/util/Map;", "getUsers", "getStreams", "getGuildMembers", "Lcom/discord/stores/StoreThreadsJoined$JoinedThread;", "getJoinedThread", "Lcom/discord/models/guild/Guild;", "getGuild", "Z", "getChannel", "getRoles", "Ljava/util/Set;", "getThreadMembers", "getPresences", "<init>", "(ZLcom/discord/api/channel/Channel;Lcom/discord/api/channel/Channel;Lcom/discord/models/guild/Guild;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/util/Set;Lcom/discord/stores/StoreThreadsJoined$JoinedThread;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final /* data */ class Thread extends StoreState {
            private final Channel channel;
            private final com.discord.models.guild.Guild guild;
            private final Map<Long, GuildMember> guildMembers;
            private final boolean isPanelOpen;
            private final StoreThreadsJoined.JoinedThread joinedThread;
            private final Channel parentChannel;
            private final Map<Long, Presence> presences;
            private final Map<Long, GuildRole> roles;
            private final Map<Long, ModelApplicationStream> streams;
            private final Set<Long> threadMembers;
            private final Map<Long, User> users;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            public Thread(boolean z2, Channel channel, Channel channel2, com.discord.models.guild.Guild guild, Map<Long, GuildRole> map, Map<Long, GuildMember> map2, Map<Long, ? extends User> map3, Map<Long, Presence> map4, Map<Long, ? extends ModelApplicationStream> map5, Set<Long> set, StoreThreadsJoined.JoinedThread joinedThread) {
                super(z2, channel, null);
                Intrinsics3.checkNotNullParameter(channel, "channel");
                Intrinsics3.checkNotNullParameter(map, "roles");
                Intrinsics3.checkNotNullParameter(map2, "guildMembers");
                Intrinsics3.checkNotNullParameter(map3, "users");
                Intrinsics3.checkNotNullParameter(map4, "presences");
                Intrinsics3.checkNotNullParameter(map5, "streams");
                Intrinsics3.checkNotNullParameter(set, "threadMembers");
                this.isPanelOpen = z2;
                this.channel = channel;
                this.parentChannel = channel2;
                this.guild = guild;
                this.roles = map;
                this.guildMembers = map2;
                this.users = map3;
                this.presences = map4;
                this.streams = map5;
                this.threadMembers = set;
                this.joinedThread = joinedThread;
            }

            public static /* synthetic */ Thread copy$default(Thread thread, boolean z2, Channel channel, Channel channel2, com.discord.models.guild.Guild guild, Map map, Map map2, Map map3, Map map4, Map map5, Set set, StoreThreadsJoined.JoinedThread joinedThread, int i, Object obj) {
                return thread.copy((i & 1) != 0 ? thread.getIsPanelOpen() : z2, (i & 2) != 0 ? thread.getChannel() : channel, (i & 4) != 0 ? thread.parentChannel : channel2, (i & 8) != 0 ? thread.guild : guild, (i & 16) != 0 ? thread.roles : map, (i & 32) != 0 ? thread.guildMembers : map2, (i & 64) != 0 ? thread.users : map3, (i & 128) != 0 ? thread.presences : map4, (i & 256) != 0 ? thread.streams : map5, (i & 512) != 0 ? thread.threadMembers : set, (i & 1024) != 0 ? thread.joinedThread : joinedThread);
            }

            public final boolean component1() {
                return getIsPanelOpen();
            }

            public final Set<Long> component10() {
                return this.threadMembers;
            }

            /* renamed from: component11, reason: from getter */
            public final StoreThreadsJoined.JoinedThread getJoinedThread() {
                return this.joinedThread;
            }

            public final Channel component2() {
                return getChannel();
            }

            /* renamed from: component3, reason: from getter */
            public final Channel getParentChannel() {
                return this.parentChannel;
            }

            /* renamed from: component4, reason: from getter */
            public final com.discord.models.guild.Guild getGuild() {
                return this.guild;
            }

            public final Map<Long, GuildRole> component5() {
                return this.roles;
            }

            public final Map<Long, GuildMember> component6() {
                return this.guildMembers;
            }

            public final Map<Long, User> component7() {
                return this.users;
            }

            public final Map<Long, Presence> component8() {
                return this.presences;
            }

            public final Map<Long, ModelApplicationStream> component9() {
                return this.streams;
            }

            public final Thread copy(boolean isPanelOpen, Channel channel, Channel parentChannel, com.discord.models.guild.Guild guild, Map<Long, GuildRole> roles, Map<Long, GuildMember> guildMembers, Map<Long, ? extends User> users, Map<Long, Presence> presences, Map<Long, ? extends ModelApplicationStream> streams, Set<Long> threadMembers, StoreThreadsJoined.JoinedThread joinedThread) {
                Intrinsics3.checkNotNullParameter(channel, "channel");
                Intrinsics3.checkNotNullParameter(roles, "roles");
                Intrinsics3.checkNotNullParameter(guildMembers, "guildMembers");
                Intrinsics3.checkNotNullParameter(users, "users");
                Intrinsics3.checkNotNullParameter(presences, "presences");
                Intrinsics3.checkNotNullParameter(streams, "streams");
                Intrinsics3.checkNotNullParameter(threadMembers, "threadMembers");
                return new Thread(isPanelOpen, channel, parentChannel, guild, roles, guildMembers, users, presences, streams, threadMembers, joinedThread);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Thread)) {
                    return false;
                }
                Thread thread = (Thread) other;
                return getIsPanelOpen() == thread.getIsPanelOpen() && Intrinsics3.areEqual(getChannel(), thread.getChannel()) && Intrinsics3.areEqual(this.parentChannel, thread.parentChannel) && Intrinsics3.areEqual(this.guild, thread.guild) && Intrinsics3.areEqual(this.roles, thread.roles) && Intrinsics3.areEqual(this.guildMembers, thread.guildMembers) && Intrinsics3.areEqual(this.users, thread.users) && Intrinsics3.areEqual(this.presences, thread.presences) && Intrinsics3.areEqual(this.streams, thread.streams) && Intrinsics3.areEqual(this.threadMembers, thread.threadMembers) && Intrinsics3.areEqual(this.joinedThread, thread.joinedThread);
            }

            @Override // com.discord.widgets.channels.memberlist.WidgetChannelMembersListViewModel.StoreState
            public Channel getChannel() {
                return this.channel;
            }

            public final com.discord.models.guild.Guild getGuild() {
                return this.guild;
            }

            public final Map<Long, GuildMember> getGuildMembers() {
                return this.guildMembers;
            }

            public final StoreThreadsJoined.JoinedThread getJoinedThread() {
                return this.joinedThread;
            }

            public final Channel getParentChannel() {
                return this.parentChannel;
            }

            public final Map<Long, Presence> getPresences() {
                return this.presences;
            }

            public final Map<Long, GuildRole> getRoles() {
                return this.roles;
            }

            public final Map<Long, ModelApplicationStream> getStreams() {
                return this.streams;
            }

            public final Set<Long> getThreadMembers() {
                return this.threadMembers;
            }

            public final Map<Long, User> getUsers() {
                return this.users;
            }

            public int hashCode() {
                boolean isPanelOpen = getIsPanelOpen();
                int i = isPanelOpen;
                if (isPanelOpen) {
                    i = 1;
                }
                int i2 = i * 31;
                Channel channel = getChannel();
                int iHashCode = (i2 + (channel != null ? channel.hashCode() : 0)) * 31;
                Channel channel2 = this.parentChannel;
                int iHashCode2 = (iHashCode + (channel2 != null ? channel2.hashCode() : 0)) * 31;
                com.discord.models.guild.Guild guild = this.guild;
                int iHashCode3 = (iHashCode2 + (guild != null ? guild.hashCode() : 0)) * 31;
                Map<Long, GuildRole> map = this.roles;
                int iHashCode4 = (iHashCode3 + (map != null ? map.hashCode() : 0)) * 31;
                Map<Long, GuildMember> map2 = this.guildMembers;
                int iHashCode5 = (iHashCode4 + (map2 != null ? map2.hashCode() : 0)) * 31;
                Map<Long, User> map3 = this.users;
                int iHashCode6 = (iHashCode5 + (map3 != null ? map3.hashCode() : 0)) * 31;
                Map<Long, Presence> map4 = this.presences;
                int iHashCode7 = (iHashCode6 + (map4 != null ? map4.hashCode() : 0)) * 31;
                Map<Long, ModelApplicationStream> map5 = this.streams;
                int iHashCode8 = (iHashCode7 + (map5 != null ? map5.hashCode() : 0)) * 31;
                Set<Long> set = this.threadMembers;
                int iHashCode9 = (iHashCode8 + (set != null ? set.hashCode() : 0)) * 31;
                StoreThreadsJoined.JoinedThread joinedThread = this.joinedThread;
                return iHashCode9 + (joinedThread != null ? joinedThread.hashCode() : 0);
            }

            @Override // com.discord.widgets.channels.memberlist.WidgetChannelMembersListViewModel.StoreState
            /* renamed from: isPanelOpen, reason: from getter */
            public boolean getIsPanelOpen() {
                return this.isPanelOpen;
            }

            public String toString() {
                StringBuilder sbU = outline.U("Thread(isPanelOpen=");
                sbU.append(getIsPanelOpen());
                sbU.append(", channel=");
                sbU.append(getChannel());
                sbU.append(", parentChannel=");
                sbU.append(this.parentChannel);
                sbU.append(", guild=");
                sbU.append(this.guild);
                sbU.append(", roles=");
                sbU.append(this.roles);
                sbU.append(", guildMembers=");
                sbU.append(this.guildMembers);
                sbU.append(", users=");
                sbU.append(this.users);
                sbU.append(", presences=");
                sbU.append(this.presences);
                sbU.append(", streams=");
                sbU.append(this.streams);
                sbU.append(", threadMembers=");
                sbU.append(this.threadMembers);
                sbU.append(", joinedThread=");
                sbU.append(this.joinedThread);
                sbU.append(")");
                return sbU.toString();
            }
        }

        private StoreState(boolean z2, Channel channel) {
            this.isPanelOpen = z2;
            this.channel = channel;
        }

        public Channel getChannel() {
            return this.channel;
        }

        /* renamed from: isPanelOpen, reason: from getter */
        public boolean getIsPanelOpen() {
            return this.isPanelOpen;
        }

        public /* synthetic */ StoreState(boolean z2, Channel channel, DefaultConstructorMarker defaultConstructorMarker) {
            this(z2, channel);
        }
    }

    /* compiled from: WidgetChannelMembersListViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\n\u000bB\u0015\b\u0002\u0012\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003¢\u0006\u0004\b\b\u0010\tR\u001d\u0010\u0004\u001a\u00060\u0002j\u0002`\u00038\u0006@\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\u0082\u0001\u0002\f\r¨\u0006\u000e"}, d2 = {"Lcom/discord/widgets/channels/memberlist/WidgetChannelMembersListViewModel$ViewState;", "", "", "Lcom/discord/primitives/MemberListId;", "listId", "Ljava/lang/String;", "getListId", "()Ljava/lang/String;", "<init>", "(Ljava/lang/String;)V", "Empty", "Loaded", "Lcom/discord/widgets/channels/memberlist/WidgetChannelMembersListViewModel$ViewState$Empty;", "Lcom/discord/widgets/channels/memberlist/WidgetChannelMembersListViewModel$ViewState$Loaded;", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static abstract class ViewState {
        private final String listId;

        /* compiled from: WidgetChannelMembersListViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/discord/widgets/channels/memberlist/WidgetChannelMembersListViewModel$ViewState$Empty;", "Lcom/discord/widgets/channels/memberlist/WidgetChannelMembersListViewModel$ViewState;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final class Empty extends ViewState {
            public static final Empty INSTANCE = new Empty();

            private Empty() {
                super("empty", null);
            }
        }

        /* compiled from: WidgetChannelMembersListViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\f\u001a\u00020\u0002\u0012\u0006\u0010\r\u001a\u00020\u0005\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\u000f\u001a\u00020\u0005¢\u0006\u0004\b!\u0010\"J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\t\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u000b\u0010\u0007J:\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\f\u001a\u00020\u00022\b\b\u0002\u0010\r\u001a\u00020\u00052\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\u000f\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0013\u001a\u00020\u0012HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0016\u001a\u00020\u0015HÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u001a\u0010\u001a\u001a\u00020\u00052\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018HÖ\u0003¢\u0006\u0004\b\u001a\u0010\u001bR\u0019\u0010\f\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\u001c\u001a\u0004\b\u001d\u0010\u0004R\u0019\u0010\r\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\u001e\u001a\u0004\b\r\u0010\u0007R\u0019\u0010\u000f\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u001e\u001a\u0004\b\u000f\u0010\u0007R\u001b\u0010\u000e\u001a\u0004\u0018\u00010\b8\u0006@\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u001f\u001a\u0004\b \u0010\n¨\u0006#"}, d2 = {"Lcom/discord/widgets/channels/memberlist/WidgetChannelMembersListViewModel$ViewState$Loaded;", "Lcom/discord/widgets/channels/memberlist/WidgetChannelMembersListViewModel$ViewState;", "Lcom/discord/widgets/channels/memberlist/WidgetChannelMembersListViewModel$MemberList;", "component1", "()Lcom/discord/widgets/channels/memberlist/WidgetChannelMembersListViewModel$MemberList;", "", "component2", "()Z", "Lcom/discord/api/channel/Channel;", "component3", "()Lcom/discord/api/channel/Channel;", "component4", "listItems", "isOpen", "channel", "isThreadJoined", "copy", "(Lcom/discord/widgets/channels/memberlist/WidgetChannelMembersListViewModel$MemberList;ZLcom/discord/api/channel/Channel;Z)Lcom/discord/widgets/channels/memberlist/WidgetChannelMembersListViewModel$ViewState$Loaded;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "Lcom/discord/widgets/channels/memberlist/WidgetChannelMembersListViewModel$MemberList;", "getListItems", "Z", "Lcom/discord/api/channel/Channel;", "getChannel", "<init>", "(Lcom/discord/widgets/channels/memberlist/WidgetChannelMembersListViewModel$MemberList;ZLcom/discord/api/channel/Channel;Z)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final /* data */ class Loaded extends ViewState {
            private final Channel channel;
            private final boolean isOpen;
            private final boolean isThreadJoined;
            private final MemberList listItems;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Loaded(MemberList memberList, boolean z2, Channel channel, boolean z3) {
                super(memberList.getListId(), null);
                Intrinsics3.checkNotNullParameter(memberList, "listItems");
                this.listItems = memberList;
                this.isOpen = z2;
                this.channel = channel;
                this.isThreadJoined = z3;
            }

            public static /* synthetic */ Loaded copy$default(Loaded loaded, MemberList memberList, boolean z2, Channel channel, boolean z3, int i, Object obj) {
                if ((i & 1) != 0) {
                    memberList = loaded.listItems;
                }
                if ((i & 2) != 0) {
                    z2 = loaded.isOpen;
                }
                if ((i & 4) != 0) {
                    channel = loaded.channel;
                }
                if ((i & 8) != 0) {
                    z3 = loaded.isThreadJoined;
                }
                return loaded.copy(memberList, z2, channel, z3);
            }

            /* renamed from: component1, reason: from getter */
            public final MemberList getListItems() {
                return this.listItems;
            }

            /* renamed from: component2, reason: from getter */
            public final boolean getIsOpen() {
                return this.isOpen;
            }

            /* renamed from: component3, reason: from getter */
            public final Channel getChannel() {
                return this.channel;
            }

            /* renamed from: component4, reason: from getter */
            public final boolean getIsThreadJoined() {
                return this.isThreadJoined;
            }

            public final Loaded copy(MemberList listItems, boolean isOpen, Channel channel, boolean isThreadJoined) {
                Intrinsics3.checkNotNullParameter(listItems, "listItems");
                return new Loaded(listItems, isOpen, channel, isThreadJoined);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Loaded)) {
                    return false;
                }
                Loaded loaded = (Loaded) other;
                return Intrinsics3.areEqual(this.listItems, loaded.listItems) && this.isOpen == loaded.isOpen && Intrinsics3.areEqual(this.channel, loaded.channel) && this.isThreadJoined == loaded.isThreadJoined;
            }

            public final Channel getChannel() {
                return this.channel;
            }

            public final MemberList getListItems() {
                return this.listItems;
            }

            /* JADX WARN: Multi-variable type inference failed */
            public int hashCode() {
                MemberList memberList = this.listItems;
                int iHashCode = (memberList != null ? memberList.hashCode() : 0) * 31;
                boolean z2 = this.isOpen;
                int i = z2;
                if (z2 != 0) {
                    i = 1;
                }
                int i2 = (iHashCode + i) * 31;
                Channel channel = this.channel;
                int iHashCode2 = (i2 + (channel != null ? channel.hashCode() : 0)) * 31;
                boolean z3 = this.isThreadJoined;
                return iHashCode2 + (z3 ? 1 : z3 ? 1 : 0);
            }

            public final boolean isOpen() {
                return this.isOpen;
            }

            public final boolean isThreadJoined() {
                return this.isThreadJoined;
            }

            public String toString() {
                StringBuilder sbU = outline.U("Loaded(listItems=");
                sbU.append(this.listItems);
                sbU.append(", isOpen=");
                sbU.append(this.isOpen);
                sbU.append(", channel=");
                sbU.append(this.channel);
                sbU.append(", isThreadJoined=");
                return outline.O(sbU, this.isThreadJoined, ")");
            }
        }

        private ViewState(String str) {
            this.listId = str;
        }

        public final String getListId() {
            return this.listId;
        }

        public /* synthetic */ ViewState(String str, DefaultConstructorMarker defaultConstructorMarker) {
            this(str);
        }
    }

    /* compiled from: WidgetChannelMembersListViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/utilities/error/Error;", "error", "", "invoke", "(Lcom/discord/utilities/error/Error;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.channels.memberlist.WidgetChannelMembersListViewModel$onThreadJoinLeaveClicked$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<Error, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Error error) {
            invoke2(error);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Error error) {
            Intrinsics3.checkNotNullParameter(error, "error");
            PublishSubject publishSubjectAccess$getEventSubject$p = WidgetChannelMembersListViewModel.access$getEventSubject$p(WidgetChannelMembersListViewModel.this);
            Error.Response response = error.getResponse();
            Intrinsics3.checkNotNullExpressionValue(response, "error.response");
            publishSubjectAccess$getEventSubject$p.k.onNext(new Event.Error(response.getCode()));
        }
    }

    /* compiled from: WidgetChannelMembersListViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Ljava/lang/Void;", "it", "", "invoke", "(Ljava/lang/Void;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.channels.memberlist.WidgetChannelMembersListViewModel$onThreadJoinLeaveClicked$2, reason: invalid class name */
    public static final class AnonymousClass2 extends Lambda implements Function1<Void, Unit> {
        public static final AnonymousClass2 INSTANCE = new AnonymousClass2();

        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Void r1) {
            invoke2(r1);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Void r1) {
        }
    }

    /* compiled from: WidgetChannelMembersListViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/utilities/error/Error;", "error", "", "invoke", "(Lcom/discord/utilities/error/Error;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.channels.memberlist.WidgetChannelMembersListViewModel$onThreadJoinLeaveClicked$3, reason: invalid class name */
    public static final class AnonymousClass3 extends Lambda implements Function1<Error, Unit> {
        public AnonymousClass3() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Error error) {
            invoke2(error);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Error error) {
            Intrinsics3.checkNotNullParameter(error, "error");
            PublishSubject publishSubjectAccess$getEventSubject$p = WidgetChannelMembersListViewModel.access$getEventSubject$p(WidgetChannelMembersListViewModel.this);
            Error.Response response = error.getResponse();
            Intrinsics3.checkNotNullExpressionValue(response, "error.response");
            publishSubjectAccess$getEventSubject$p.k.onNext(new Event.Error(response.getCode()));
        }
    }

    /* compiled from: WidgetChannelMembersListViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Ljava/lang/Void;", "it", "", "invoke", "(Ljava/lang/Void;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.channels.memberlist.WidgetChannelMembersListViewModel$onThreadJoinLeaveClicked$4, reason: invalid class name */
    public static final class AnonymousClass4 extends Lambda implements Function1<Void, Unit> {
        public static final AnonymousClass4 INSTANCE = new AnonymousClass4();

        public AnonymousClass4() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Void r1) {
            invoke2(r1);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Void r1) {
        }
    }

    public WidgetChannelMembersListViewModel() {
        this(null, null, null, null, 15, null);
    }

    /*  JADX ERROR: NullPointerException in pass: InitCodeVariables
        java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.SSAVar.getPhiList()" because "resultVar" is null
        	at jadx.core.dex.visitors.InitCodeVariables.collectConnectedVars(InitCodeVariables.java:119)
        	at jadx.core.dex.visitors.InitCodeVariables.setCodeVar(InitCodeVariables.java:82)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVar(InitCodeVariables.java:74)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVars(InitCodeVariables.java:48)
        	at jadx.core.dex.visitors.InitCodeVariables.visit(InitCodeVariables.java:29)
        */
    public /* synthetic */ WidgetChannelMembersListViewModel(com.discord.widgets.channels.memberlist.WidgetChannelMembersListViewModel.GuildChannelSubscriber r21, com.discord.stores.StoreGuilds r22, com.discord.stores.StoreEmojiCustom r23, rx.Observable r24, int r25, kotlin.jvm.internal.DefaultConstructorMarker r26) {
        /*
            r20 = this;
            r0 = r25 & 1
            if (r0 == 0) goto La
            com.discord.widgets.channels.memberlist.WidgetChannelMembersListViewModel$1 r0 = new com.discord.widgets.channels.memberlist.WidgetChannelMembersListViewModel$1
            r0.<init>()
            goto Lc
        La:
            r0 = r21
        Lc:
            r1 = r25 & 2
            if (r1 == 0) goto L17
            com.discord.stores.StoreStream$Companion r1 = com.discord.stores.StoreStream.INSTANCE
            com.discord.stores.StoreGuilds r1 = r1.getGuilds()
            goto L19
        L17:
            r1 = r22
        L19:
            r2 = r25 & 4
            if (r2 == 0) goto L25
            com.discord.stores.StoreStream$Companion r2 = com.discord.stores.StoreStream.INSTANCE
            com.discord.stores.StoreEmojiCustom r2 = r2.getCustomEmojis()
            r15 = r2
            goto L27
        L25:
            r15 = r23
        L27:
            r2 = r25 & 8
            if (r2 == 0) goto L50
            com.discord.widgets.channels.memberlist.WidgetChannelMembersListViewModel$Companion r2 = com.discord.widgets.channels.memberlist.WidgetChannelMembersListViewModel.INSTANCE
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 0
            r12 = 0
            r13 = 0
            r14 = 0
            r16 = 0
            r17 = 8190(0x1ffe, float:1.1477E-41)
            r18 = 0
            r3 = r1
            r19 = r15
            r15 = r16
            r16 = r17
            r17 = r18
            rx.Observable r2 = com.discord.widgets.channels.memberlist.WidgetChannelMembersListViewModel.Companion.observeStoreState$default(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17)
            r3 = r20
            r4 = r19
            goto L55
        L50:
            r3 = r20
            r2 = r24
            r4 = r15
        L55:
            r3.<init>(r0, r1, r4, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.discord.widgets.channels.memberlist.WidgetChannelMembersListViewModel.<init>(com.discord.widgets.channels.memberlist.WidgetChannelMembersListViewModel$GuildChannelSubscriber, com.discord.stores.StoreGuilds, com.discord.stores.StoreEmojiCustom, rx.Observable, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public static final /* synthetic */ PublishSubject access$getEventSubject$p(WidgetChannelMembersListViewModel widgetChannelMembersListViewModel) {
        return widgetChannelMembersListViewModel.eventSubject;
    }

    public static final /* synthetic */ void access$handleStoreState(WidgetChannelMembersListViewModel widgetChannelMembersListViewModel, StoreState storeState) {
        widgetChannelMembersListViewModel.handleStoreState(storeState);
    }

    @MainThread
    private final void handleStoreState(StoreState storeState) {
        MemberList memberListGenerateThreadMemberListItems;
        if (storeState instanceof StoreState.None) {
            updateViewState(ViewState.Empty.INSTANCE);
            return;
        }
        boolean z2 = false;
        if (storeState instanceof StoreState.Guild) {
            StoreState.Guild guild = (StoreState.Guild) storeState;
            memberListGenerateThreadMemberListItems = GuildMemberListItemGenerator.generateGuildMemberListItems(guild.getChannelMembers(), guild.getGuild(), guild.getChannel(), guild.getGuildRoles(), PermissionUtils.can(1L, guild.getChannelPermissions()), false, this.storeGuilds, this.storeCustomEmojis);
        } else if (storeState instanceof StoreState.Private) {
            StoreState.Private r0 = (StoreState.Private) storeState;
            Map<Long, Integer> relationships = r0.getRelationships();
            User userA = ChannelUtils.a(r0.getChannel());
            memberListGenerateThreadMemberListItems = PrivateChannelMemberListItemGenerator.generateGroupDmMemberListItems(r0.getChannel(), r0.getUsers(), r0.getPresences(), r0.getApplicationStreams(), ChannelUtils.p(r0.getChannel()) || ModelUserRelationship.isType(relationships.get(userA != null ? Long.valueOf(userA.getId()) : null), 1));
        } else {
            if (!(storeState instanceof StoreState.Thread)) {
                throw new NoWhenBranchMatchedException();
            }
            StoreState.Thread thread = (StoreState.Thread) storeState;
            memberListGenerateThreadMemberListItems = ThreadMemberListItemGenerator.generateThreadMemberListItems(thread.getChannel(), thread.getRoles(), thread.getGuild(), thread.getGuildMembers(), thread.getUsers(), thread.getPresences(), thread.getStreams(), thread.getThreadMembers(), thread.getJoinedThread(), this.storeGuilds, this.storeCustomEmojis);
        }
        ViewState viewState = getViewState();
        boolean isPanelOpen = storeState.getIsPanelOpen();
        Channel channel = storeState.getChannel();
        if ((storeState instanceof StoreState.Thread) && ((StoreState.Thread) storeState).getJoinedThread() != null) {
            z2 = true;
        }
        ViewState.Loaded loaded = new ViewState.Loaded(memberListGenerateThreadMemberListItems, isPanelOpen, channel, z2);
        updateViewState(loaded);
        updateSubscriptions(viewState, loaded, storeState);
    }

    public final Observable<Event> observeEvents() {
        PublishSubject<Event> publishSubject = this.eventSubject;
        Intrinsics3.checkNotNullExpressionValue(publishSubject, "eventSubject");
        return publishSubject;
    }

    public final void onThreadJoinLeaveClicked(long channelId, boolean isThreadJoined) {
        if (isThreadJoined) {
            ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.INSTANCE.getApi().leaveThread(channelId, "Thread Member List"), false, 1, null), this, null, 2, null), WidgetChannelMembersListViewModel.class, (Context) null, (Function1) null, new AnonymousClass1(), (Function0) null, (Function0) null, AnonymousClass2.INSTANCE, 54, (Object) null);
            StoreNavigation.setNavigationPanelAction$default(StoreStream.INSTANCE.getNavigation(), StoreNavigation.PanelAction.CLOSE, null, 2, null);
        } else {
            ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.INSTANCE.getApi().joinThread(channelId, "Thread Member List", new RestAPIParams.EmptyBody()), false, 1, null), WidgetChannelMembersListViewModel.class, (Context) null, (Function1) null, new AnonymousClass3(), (Function0) null, (Function0) null, AnonymousClass4.INSTANCE, 54, (Object) null);
            StoreNavigation.setNavigationPanelAction$default(StoreStream.INSTANCE.getNavigation(), StoreNavigation.PanelAction.CLOSE, null, 2, null);
        }
    }

    public final void updateSubscriptions(ViewState prevViewState, ViewState.Loaded newViewState, StoreState storeState) {
        Intrinsics3.checkNotNullParameter(newViewState, "newViewState");
        Intrinsics3.checkNotNullParameter(storeState, "storeState");
        boolean z2 = (Intrinsics3.areEqual(prevViewState != null ? prevViewState.getListId() : null, newViewState.getListId()) ^ true) && storeState.getIsPanelOpen();
        Channel channel = newViewState.getChannel();
        if (channel != null && ChannelUtils.H(channel)) {
            if (z2) {
                this.eventSubject.k.onNext(Event.ScrollToTop.INSTANCE);
                updateSubscriptionsForThread(newViewState.getChannel());
                return;
            } else {
                if ((prevViewState instanceof ViewState.Loaded) && !((ViewState.Loaded) prevViewState).isOpen() && newViewState.isOpen()) {
                    updateSubscriptionsForThread(newViewState.getChannel());
                    return;
                }
                return;
            }
        }
        if (z2) {
            this.eventSubject.k.onNext(Event.ScrollToTop.INSTANCE);
            updateSubscriptionsForChannel(new Ranges2(0, 99));
        } else if ((prevViewState instanceof ViewState.Loaded) && !((ViewState.Loaded) prevViewState).isOpen() && newViewState.isOpen()) {
            this.eventSubject.k.onNext(Event.UpdateRanges.INSTANCE);
        }
    }

    @MainThread
    public final void updateSubscriptionsForChannel(Ranges2 range) {
        Intrinsics3.checkNotNullParameter(range, "range");
        ViewState viewState = getViewState();
        if (!(viewState instanceof ViewState.Loaded)) {
            viewState = null;
        }
        ViewState.Loaded loaded = (ViewState.Loaded) viewState;
        if (loaded == null || loaded.getChannel() == null || !loaded.isOpen()) {
            return;
        }
        this.guildChannelSubscriber.subscribeToChannelRange(loaded.getChannel(), range);
    }

    public final void updateSubscriptionsForThread(Channel channel) {
        if (channel == null || ChannelUtils.j(channel)) {
            return;
        }
        Intrinsics3.checkNotNullParameter(channel, "$this$isAnnouncementThread");
        if (channel.getType() == 10) {
            return;
        }
        this.guildChannelSubscriber.subscribeToThread(channel);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChannelMembersListViewModel(GuildChannelSubscriber guildChannelSubscriber, StoreGuilds storeGuilds, StoreEmojiCustom storeEmojiCustom, Observable<StoreState> observable) {
        super(ViewState.Empty.INSTANCE);
        Intrinsics3.checkNotNullParameter(guildChannelSubscriber, "guildChannelSubscriber");
        Intrinsics3.checkNotNullParameter(storeGuilds, "storeGuilds");
        Intrinsics3.checkNotNullParameter(storeEmojiCustom, "storeCustomEmojis");
        Intrinsics3.checkNotNullParameter(observable, "storeStateObservable");
        this.guildChannelSubscriber = guildChannelSubscriber;
        this.storeGuilds = storeGuilds;
        this.storeCustomEmojis = storeEmojiCustom;
        this.eventSubject = PublishSubject.k0();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.computationLatest(observable), this, null, 2, null), WidgetChannelMembersListViewModel.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass2(), 62, (Object) null);
    }
}
