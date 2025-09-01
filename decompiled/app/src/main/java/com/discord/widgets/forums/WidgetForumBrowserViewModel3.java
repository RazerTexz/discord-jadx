package com.discord.widgets.forums;

import androidx.core.app.NotificationCompat;
import com.discord.api.channel.Channel;
import com.discord.api.permission.Permission;
import com.discord.api.role.GuildRole;
import com.discord.models.domain.emoji.Emoji;
import com.discord.models.domain.emoji.EmojiSet;
import com.discord.models.member.GuildMember;
import com.discord.models.message.Message;
import com.discord.models.user.MeUser;
import com.discord.models.user.User;
import com.discord.stores.ArchivedThreadsStore;
import com.discord.stores.StoreChannels;
import com.discord.stores.StoreEmoji;
import com.discord.stores.StoreForumPostMessages;
import com.discord.stores.StoreForumPostReadStates;
import com.discord.stores.StoreGuilds;
import com.discord.stores.StoreMessagesMostRecent;
import com.discord.stores.StorePermissions;
import com.discord.stores.StoreThreadMessages;
import com.discord.stores.StoreThreadsActive;
import com.discord.stores.StoreUser;
import com.discord.stores.StoreUserRelationships;
import com.discord.stores.StoreUserTyping;
import com.discord.utilities.permissions.PermissionUtils;
import com.discord.utilities.rx.ObservableCombineLatestOverloads2;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.widgets.forums.WidgetForumBrowserViewModel;
import d0.t.Maps6;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import j0.k.Func1;
import j0.l.e.ScalarSynchronousObservable;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.functions.Function17;
import rx.Observable;

/* compiled from: WidgetForumBrowserViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0007\u001a*\u0012\u000e\b\u0001\u0012\n \u0001*\u0004\u0018\u00010\u00040\u0004 \u0001*\u0014\u0012\u000e\b\u0001\u0012\n \u0001*\u0004\u0018\u00010\u00040\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lcom/discord/widgets/forums/WidgetForumBrowserViewModel$MinimalStoreState;", "kotlin.jvm.PlatformType", "minimalStoreState", "Lrx/Observable;", "Lcom/discord/widgets/forums/WidgetForumBrowserViewModel$StoreState;", NotificationCompat.CATEGORY_CALL, "(Lcom/discord/widgets/forums/WidgetForumBrowserViewModel$MinimalStoreState;)Lrx/Observable;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.forums.WidgetForumBrowserViewModel$Companion$observeStoreState$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetForumBrowserViewModel3<T, R> implements Func1<WidgetForumBrowserViewModel.MinimalStoreState, Observable<? extends WidgetForumBrowserViewModel.StoreState>> {
    public final /* synthetic */ ArchivedThreadsStore $storeArchivedThreads;
    public final /* synthetic */ StoreChannels $storeChannels;
    public final /* synthetic */ StoreEmoji $storeEmoji;
    public final /* synthetic */ StoreForumPostMessages $storeForumPostMessages;
    public final /* synthetic */ StoreForumPostReadStates $storeForumPostReadStates;
    public final /* synthetic */ StoreGuilds $storeGuilds;
    public final /* synthetic */ StoreMessagesMostRecent $storeMessagesMostRecent;
    public final /* synthetic */ StorePermissions $storePermissions;
    public final /* synthetic */ StoreThreadsActive $storeThreadsActive;
    public final /* synthetic */ StoreThreadMessages $storeThreadsMessages;
    public final /* synthetic */ StoreUser $storeUser;
    public final /* synthetic */ StoreUserRelationships $storeUserRelationships;
    public final /* synthetic */ StoreUserTyping $storeUserTyping;

    /* compiled from: WidgetForumBrowserViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010+\u001a\u00020(2\u0006\u0010\u0001\u001a\u00020\u00002\u0016\u0010\u0006\u001a\u0012\u0012\b\u0012\u00060\u0003j\u0002`\u0004\u0012\u0004\u0012\u00020\u00050\u00022\u0006\u0010\b\u001a\u00020\u00072\u0016\u0010\u000b\u001a\u0012\u0012\b\u0012\u00060\u0003j\u0002`\t\u0012\u0004\u0012\u00020\n0\u000226\u0010\u000f\u001a2\u0012\b\u0012\u00060\u0003j\u0002`\u0004\u0012\b\u0012\u00060\fj\u0002`\r \u000e*\u0018\u0012\b\u0012\u00060\u0003j\u0002`\u0004\u0012\b\u0012\u00060\fj\u0002`\r\u0018\u00010\u00020\u00022\u0016\u0010\u0012\u001a\u0012\u0012\b\u0012\u00060\u0003j\u0002`\u0010\u0012\u0004\u0012\u00020\u00110\u00022\u0016\u0010\u0014\u001a\u0012\u0012\b\u0012\u00060\u0003j\u0002`\t\u0012\u0004\u0012\u00020\u00130\u00022\u0016\u0010\u0016\u001a\u0012\u0012\b\u0012\u00060\u0003j\u0002`\t\u0012\u0004\u0012\u00020\u00150\u00022\u001a\u0010\u0019\u001a\u0016\u0012\b\u0012\u00060\u0003j\u0002`\u0004\u0012\b\u0012\u00060\u0017j\u0002`\u00180\u00022\u000e\u0010\u001b\u001a\n\u0018\u00010\u0003j\u0004\u0018\u0001`\u001a2\u001a\u0010\u001d\u001a\u0016\u0012\b\u0012\u00060\u0003j\u0002`\t\u0012\b\u0012\u00060\u0003j\u0002`\u001c0\u00022\u0006\u0010\u001f\u001a\u00020\u001e2\u0016\u0010!\u001a\u0012\u0012\b\u0012\u00060\u0003j\u0002`\t\u0012\u0004\u0012\u00020 0\u00022\u0016\u0010\"\u001a\u0012\u0012\b\u0012\u00060\u0003j\u0002`\t\u0012\u0004\u0012\u00020\u00170\u00022\u0010\u0010$\u001a\f\u0012\b\u0012\u00060\u0003j\u0002`\t0#2\u0006\u0010&\u001a\u00020%2 \u0010'\u001a\u001c\u0012\b\u0012\u00060\u0003j\u0002`\t\u0012\u000e\u0012\f\u0012\b\u0012\u00060\u0003j\u0002`\u00040#0\u0002H\n¢\u0006\u0004\b)\u0010*"}, d2 = {"Lcom/discord/models/user/MeUser;", "meUser", "", "", "Lcom/discord/primitives/UserId;", "Lcom/discord/models/user/User;", "users", "Lcom/discord/stores/ArchivedThreadsStore$ThreadListingState;", "archivedThreadsState", "Lcom/discord/primitives/ChannelId;", "", "channelNames", "Lcom/discord/models/member/GuildMember;", "Lcom/discord/stores/ClientGuildMember;", "kotlin.jvm.PlatformType", "guildMembers", "Lcom/discord/primitives/RoleId;", "Lcom/discord/api/role/GuildRole;", "guildRoles", "Lcom/discord/models/message/Message;", "forumPostFirstMessages", "Lcom/discord/stores/StoreThreadMessages$ThreadState;", "forumPostMessageCounts", "", "Lcom/discord/primitives/RelationshipType;", "myBlockedUsers", "Lcom/discord/api/permission/PermissionBit;", "parentChannelPermissions", "Lcom/discord/primitives/MessageId;", "mostRecentMessageIds", "Lcom/discord/models/domain/emoji/EmojiSet;", "emojis", "Lcom/discord/widgets/forums/ForumPostReadState;", "forumPostReadStates", "forumPostUnreadCounts", "", "forumPostWithPersistedReadStates", "", "isThreadSyncedGuild", "typingUsers", "Lcom/discord/widgets/forums/WidgetForumBrowserViewModel$StoreState$Loaded;", "invoke", "(Lcom/discord/models/user/MeUser;Ljava/util/Map;Lcom/discord/stores/ArchivedThreadsStore$ThreadListingState;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/lang/Long;Ljava/util/Map;Lcom/discord/models/domain/emoji/EmojiSet;Ljava/util/Map;Ljava/util/Map;Ljava/util/Set;ZLjava/util/Map;)Lcom/discord/widgets/forums/WidgetForumBrowserViewModel$StoreState$Loaded;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.forums.WidgetForumBrowserViewModel$Companion$observeStoreState$1$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function17<MeUser, Map<Long, ? extends User>, ArchivedThreadsStore.ThreadListingState, Map<Long, ? extends String>, Map<Long, ? extends GuildMember>, Map<Long, ? extends GuildRole>, Map<Long, ? extends Message>, Map<Long, ? extends StoreThreadMessages.ThreadState>, Map<Long, ? extends Integer>, Long, Map<Long, ? extends Long>, EmojiSet, Map<Long, ? extends ForumPostReadState>, Map<Long, ? extends Integer>, Set<? extends Long>, Boolean, Map<Long, ? extends Set<? extends Long>>, WidgetForumBrowserViewModel.StoreState.Loaded> {
        public final /* synthetic */ Map $activeThreads;
        public final /* synthetic */ Channel $parentChannel;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Map map, Channel channel) {
            super(17);
            this.$activeThreads = map;
            this.$parentChannel = channel;
        }

        @Override // kotlin.jvm.functions.Function17
        public /* bridge */ /* synthetic */ WidgetForumBrowserViewModel.StoreState.Loaded invoke(MeUser meUser, Map<Long, ? extends User> map, ArchivedThreadsStore.ThreadListingState threadListingState, Map<Long, ? extends String> map2, Map<Long, ? extends GuildMember> map3, Map<Long, ? extends GuildRole> map4, Map<Long, ? extends Message> map5, Map<Long, ? extends StoreThreadMessages.ThreadState> map6, Map<Long, ? extends Integer> map7, Long l, Map<Long, ? extends Long> map8, EmojiSet emojiSet, Map<Long, ? extends ForumPostReadState> map9, Map<Long, ? extends Integer> map10, Set<? extends Long> set, Boolean bool, Map<Long, ? extends Set<? extends Long>> map11) {
            return invoke(meUser, map, threadListingState, (Map<Long, String>) map2, (Map<Long, GuildMember>) map3, (Map<Long, GuildRole>) map4, (Map<Long, Message>) map5, (Map<Long, StoreThreadMessages.ThreadState>) map6, (Map<Long, Integer>) map7, l, (Map<Long, Long>) map8, emojiSet, (Map<Long, ForumPostReadState>) map9, (Map<Long, Integer>) map10, (Set<Long>) set, bool.booleanValue(), (Map<Long, ? extends Set<Long>>) map11);
        }

        public final WidgetForumBrowserViewModel.StoreState.Loaded invoke(MeUser meUser, Map<Long, ? extends User> map, ArchivedThreadsStore.ThreadListingState threadListingState, Map<Long, String> map2, Map<Long, GuildMember> map3, Map<Long, GuildRole> map4, Map<Long, Message> map5, Map<Long, StoreThreadMessages.ThreadState> map6, Map<Long, Integer> map7, Long l, Map<Long, Long> map8, EmojiSet emojiSet, Map<Long, ForumPostReadState> map9, Map<Long, Integer> map10, Set<Long> set, boolean z2, Map<Long, ? extends Set<Long>> map11) {
            AnonymousClass1 anonymousClass1 = this;
            Intrinsics3.checkNotNullParameter(meUser, "meUser");
            Intrinsics3.checkNotNullParameter(map, "users");
            Intrinsics3.checkNotNullParameter(threadListingState, "archivedThreadsState");
            Intrinsics3.checkNotNullParameter(map2, "channelNames");
            Intrinsics3.checkNotNullParameter(map4, "guildRoles");
            Intrinsics3.checkNotNullParameter(map5, "forumPostFirstMessages");
            Intrinsics3.checkNotNullParameter(map6, "forumPostMessageCounts");
            Intrinsics3.checkNotNullParameter(map7, "myBlockedUsers");
            Intrinsics3.checkNotNullParameter(map8, "mostRecentMessageIds");
            Intrinsics3.checkNotNullParameter(emojiSet, "emojis");
            Intrinsics3.checkNotNullParameter(map9, "forumPostReadStates");
            Intrinsics3.checkNotNullParameter(map10, "forumPostUnreadCounts");
            Intrinsics3.checkNotNullParameter(set, "forumPostWithPersistedReadStates");
            Intrinsics3.checkNotNullParameter(map11, "typingUsers");
            Map map12 = anonymousClass1.$activeThreads;
            Intrinsics3.checkNotNullExpressionValue(map3, "guildMembers");
            Channel channel = anonymousClass1.$parentChannel;
            Set<Long> setKeySet = map7.keySet();
            boolean zCan = PermissionUtils.can(Permission.SEND_MESSAGES, l);
            Map<String, Emoji> map13 = emojiSet.emojiIndex;
            Intrinsics3.checkNotNullExpressionValue(map13, "emojis.emojiIndex");
            Map map14 = Maps6.toMap(map13);
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (Map.Entry<Long, Integer> entry : map10.entrySet()) {
                if (set.contains(Long.valueOf(entry.getKey().longValue()))) {
                    linkedHashMap.put(entry.getKey(), entry.getValue());
                }
            }
            LinkedHashMap linkedHashMap2 = new LinkedHashMap();
            for (Map.Entry<Long, ? extends Set<Long>> entry2 : map11.entrySet()) {
                if (anonymousClass1.$activeThreads.containsKey(Long.valueOf(entry2.getKey().longValue()))) {
                    linkedHashMap2.put(entry2.getKey(), entry2.getValue());
                }
                anonymousClass1 = this;
            }
            return new WidgetForumBrowserViewModel.StoreState.Loaded(meUser, map, threadListingState, map12, map3, map4, map2, channel, map5, map6, setKeySet, zCan, map8, map14, map9, linkedHashMap, z2, linkedHashMap2);
        }
    }

    public WidgetForumBrowserViewModel3(StoreUser storeUser, ArchivedThreadsStore archivedThreadsStore, StoreChannels storeChannels, StoreGuilds storeGuilds, StoreForumPostMessages storeForumPostMessages, StoreThreadMessages storeThreadMessages, StoreUserRelationships storeUserRelationships, StorePermissions storePermissions, StoreMessagesMostRecent storeMessagesMostRecent, StoreEmoji storeEmoji, StoreForumPostReadStates storeForumPostReadStates, StoreThreadsActive storeThreadsActive, StoreUserTyping storeUserTyping) {
        this.$storeUser = storeUser;
        this.$storeArchivedThreads = archivedThreadsStore;
        this.$storeChannels = storeChannels;
        this.$storeGuilds = storeGuilds;
        this.$storeForumPostMessages = storeForumPostMessages;
        this.$storeThreadsMessages = storeThreadMessages;
        this.$storeUserRelationships = storeUserRelationships;
        this.$storePermissions = storePermissions;
        this.$storeMessagesMostRecent = storeMessagesMostRecent;
        this.$storeEmoji = storeEmoji;
        this.$storeForumPostReadStates = storeForumPostReadStates;
        this.$storeThreadsActive = storeThreadsActive;
        this.$storeUserTyping = storeUserTyping;
    }

    @Override // j0.k.Func1
    public /* bridge */ /* synthetic */ Observable<? extends WidgetForumBrowserViewModel.StoreState> call(WidgetForumBrowserViewModel.MinimalStoreState minimalStoreState) {
        return call2(minimalStoreState);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends WidgetForumBrowserViewModel.StoreState> call2(WidgetForumBrowserViewModel.MinimalStoreState minimalStoreState) {
        if (!(minimalStoreState instanceof WidgetForumBrowserViewModel.MinimalStoreState.Valid)) {
            return new ScalarSynchronousObservable(WidgetForumBrowserViewModel.StoreState.Invalid.INSTANCE);
        }
        WidgetForumBrowserViewModel.MinimalStoreState.Valid valid = (WidgetForumBrowserViewModel.MinimalStoreState.Valid) minimalStoreState;
        Channel channel = valid.getChannel();
        Map<Long, Channel> activeThreads = valid.getActiveThreads();
        Observable observableObserveMe$default = StoreUser.observeMe$default(this.$storeUser, false, 1, null);
        Observable<Map<Long, User>> observableObserveAllUsers = this.$storeUser.observeAllUsers();
        Observable<ArchivedThreadsStore.ThreadListingState> observableMaybeLoadAndObserveThreadListing = ForumUtils.INSTANCE.maybeLoadAndObserveThreadListing(channel.getId(), true ^ activeThreads.isEmpty(), this.$storeArchivedThreads);
        Observable<Map<Long, String>> observableObserveNames = this.$storeChannels.observeNames();
        Observable<Map<Long, GuildMember>> observableObserveGuildMembers = this.$storeGuilds.observeGuildMembers(channel.getGuildId());
        Intrinsics3.checkNotNullExpressionValue(observableObserveGuildMembers, "storeGuilds\n            …rs(parentChannel.guildId)");
        Observable<T> observableR = ObservableExtensionsKt.leadingEdgeThrottle(observableObserveGuildMembers, 1L, TimeUnit.SECONDS).r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "storeGuilds\n            …  .distinctUntilChanged()");
        return ObservableCombineLatestOverloads2.combineLatest(observableObserveMe$default, observableObserveAllUsers, observableMaybeLoadAndObserveThreadListing, observableObserveNames, observableR, this.$storeGuilds.observeRoles(channel.getGuildId()), this.$storeForumPostMessages.observeForumPostFirstMessages(), this.$storeThreadsMessages.observeThreadCountAndLatestMessage(), this.$storeUserRelationships.observeForType(2), this.$storePermissions.observePermissionsForChannel(channel.getId()), this.$storeMessagesMostRecent.observeRecentMessageIds(), StoreEmoji.getEmojiSet$default(this.$storeEmoji, channel.getGuildId(), channel.getId(), false, false, 12, null), ForumPostReadStateManager.observeForumPostReadStates$default(ForumPostReadStateManager.INSTANCE, channel.getGuildId(), channel.getId(), null, null, null, 28, null), this.$storeForumPostReadStates.observeThreadUnreadCounts(), this.$storeForumPostReadStates.observeThreadIdsWithPersistedReadStates(), this.$storeThreadsActive.observeIsThreadSyncedGuild(channel.getGuildId()), this.$storeUserTyping.observeTypingUsersForChannels(activeThreads.keySet()), new AnonymousClass1(activeThreads, channel));
    }
}
