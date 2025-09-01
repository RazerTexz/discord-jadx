package com.discord.widgets.chat.input;

import androidx.core.app.NotificationCompat;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.api.guild.GuildVerificationLevel;
import com.discord.api.guildjoinrequest.GuildJoinRequest;
import com.discord.models.guild.Guild;
import com.discord.models.member.GuildMember;
import com.discord.models.user.MeUser;
import com.discord.models.user.User;
import com.discord.stores.StoreChannelsSelected;
import com.discord.stores.StoreChat;
import com.discord.stores.StoreGuildJoinRequest;
import com.discord.stores.StoreGuilds;
import com.discord.stores.StoreLurking;
import com.discord.stores.StorePendingReplies;
import com.discord.stores.StorePermissions;
import com.discord.stores.StoreSlowMode;
import com.discord.stores.StoreThreadDraft;
import com.discord.stores.StoreUser;
import com.discord.stores.StoreUserRelationships;
import com.discord.utilities.rx.ObservableCombineLatestOverloads2;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.widgets.chat.input.ChatInputViewModel;
import com.discord.widgets.forums.ForumPostCreateManager;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import j0.k.Func1;
import j0.l.e.ScalarSynchronousObservable;
import kotlin.Metadata;
import kotlin.jvm.functions.Function13;
import rx.Observable;

/* compiled from: ChatInputViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0007\u001a*\u0012\u000e\b\u0001\u0012\n \u0001*\u0004\u0018\u00010\u00040\u0004 \u0001*\u0014\u0012\u000e\b\u0001\u0012\n \u0001*\u0004\u0018\u00010\u00040\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lcom/discord/stores/StoreChannelsSelected$ResolvedSelectedChannel;", "kotlin.jvm.PlatformType", "selectedChannel", "Lrx/Observable;", "Lcom/discord/widgets/chat/input/ChatInputViewModel$StoreState;", NotificationCompat.CATEGORY_CALL, "(Lcom/discord/stores/StoreChannelsSelected$ResolvedSelectedChannel;)Lrx/Observable;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class ChatInputViewModel$Companion$observeStoreState$1<T, R> implements Func1<StoreChannelsSelected.ResolvedSelectedChannel, Observable<? extends ChatInputViewModel.StoreState>> {
    public final /* synthetic */ StoreChat $storeChat;
    public final /* synthetic */ StoreGuildJoinRequest $storeGuildJoinRequest;
    public final /* synthetic */ StoreGuilds $storeGuilds;
    public final /* synthetic */ StoreLurking $storeLurking;
    public final /* synthetic */ StorePendingReplies $storePendingReplies;
    public final /* synthetic */ StorePermissions $storePermissions;
    public final /* synthetic */ StoreSlowMode $storeSlowMode;
    public final /* synthetic */ StoreThreadDraft $storeThreadDraft;
    public final /* synthetic */ StoreUserRelationships $storeUserRelationships;
    public final /* synthetic */ StoreUser $storeUsers;

    /* compiled from: ChatInputViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u001f\u001a\u00020\u001c2\u0006\u0010\u0001\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u000e\u0010\u0006\u001a\n\u0018\u00010\u0004j\u0004\u0018\u0001`\u00052\u000e\u0010\t\u001a\n\u0018\u00010\u0007j\u0004\u0018\u0001`\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u000e\u0010\u000f\u001a\n \u000e*\u0004\u0018\u00010\f0\f2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\u0010\u0013\u001a\u0004\u0018\u00010\u00122\u000e\u0010\u0016\u001a\n\u0018\u00010\u0014j\u0004\u0018\u0001`\u00152\b\u0010\u0018\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\fH\n¢\u0006\u0004\b\u001d\u0010\u001e"}, d2 = {"Lcom/discord/models/user/MeUser;", "me", "Lcom/discord/stores/StoreChat$EditingMessage;", "editing", "", "Lcom/discord/primitives/RelationshipType;", "relationshipType", "", "Lcom/discord/api/permission/PermissionBit;", "channelPermissions", "Lcom/discord/api/guild/GuildVerificationLevel;", "verificationLevelTriggered", "", "isLurking", "kotlin.jvm.PlatformType", "isOnCooldown", "Lcom/discord/models/guild/Guild;", "guild", "Lcom/discord/widgets/chat/input/ChatInputViewModel$StoreState$Loaded$PendingReply;", "pendingReply", "Lcom/discord/models/member/GuildMember;", "Lcom/discord/stores/ClientGuildMember;", "meGuildMember", "Lcom/discord/api/guildjoinrequest/GuildJoinRequest;", "guildJoinRequest", "Lcom/discord/stores/StoreThreadDraft$ThreadDraftState;", "threadDraftState", "isForumPostCreateInProgress", "Lcom/discord/widgets/chat/input/ChatInputViewModel$StoreState$Loaded;", "invoke", "(Lcom/discord/models/user/MeUser;Lcom/discord/stores/StoreChat$EditingMessage;Ljava/lang/Integer;Ljava/lang/Long;Lcom/discord/api/guild/GuildVerificationLevel;ZLjava/lang/Boolean;Lcom/discord/models/guild/Guild;Lcom/discord/widgets/chat/input/ChatInputViewModel$StoreState$Loaded$PendingReply;Lcom/discord/models/member/GuildMember;Lcom/discord/api/guildjoinrequest/GuildJoinRequest;Lcom/discord/stores/StoreThreadDraft$ThreadDraftState;Z)Lcom/discord/widgets/chat/input/ChatInputViewModel$StoreState$Loaded;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.chat.input.ChatInputViewModel$Companion$observeStoreState$1$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function13<MeUser, StoreChat.EditingMessage, Integer, Long, GuildVerificationLevel, Boolean, Boolean, Guild, ChatInputViewModel.StoreState.Loaded.PendingReply, GuildMember, GuildJoinRequest, StoreThreadDraft.ThreadDraftState, Boolean, ChatInputViewModel.StoreState.Loaded> {
        public final /* synthetic */ Channel $channel;
        public final /* synthetic */ StoreChannelsSelected.ResolvedSelectedChannel $selectedChannel;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Channel channel, StoreChannelsSelected.ResolvedSelectedChannel resolvedSelectedChannel) {
            super(13);
            this.$channel = channel;
            this.$selectedChannel = resolvedSelectedChannel;
        }

        @Override // kotlin.jvm.functions.Function13
        public /* bridge */ /* synthetic */ ChatInputViewModel.StoreState.Loaded invoke(MeUser meUser, StoreChat.EditingMessage editingMessage, Integer num, Long l, GuildVerificationLevel guildVerificationLevel, Boolean bool, Boolean bool2, Guild guild, ChatInputViewModel.StoreState.Loaded.PendingReply pendingReply, GuildMember guildMember, GuildJoinRequest guildJoinRequest, StoreThreadDraft.ThreadDraftState threadDraftState, Boolean bool3) {
            return invoke(meUser, editingMessage, num, l, guildVerificationLevel, bool.booleanValue(), bool2, guild, pendingReply, guildMember, guildJoinRequest, threadDraftState, bool3.booleanValue());
        }

        public final ChatInputViewModel.StoreState.Loaded invoke(MeUser meUser, StoreChat.EditingMessage editingMessage, Integer num, Long l, GuildVerificationLevel guildVerificationLevel, boolean z2, Boolean bool, Guild guild, ChatInputViewModel.StoreState.Loaded.PendingReply pendingReply, GuildMember guildMember, GuildJoinRequest guildJoinRequest, StoreThreadDraft.ThreadDraftState threadDraftState, boolean z3) {
            Intrinsics3.checkNotNullParameter(meUser, "me");
            Intrinsics3.checkNotNullParameter(guildVerificationLevel, "verificationLevelTriggered");
            Intrinsics3.checkNotNullParameter(threadDraftState, "threadDraftState");
            Channel channel = this.$channel;
            Intrinsics3.checkNotNullExpressionValue(bool, "isOnCooldown");
            boolean zBooleanValue = bool.booleanValue();
            StoreChannelsSelected.ResolvedSelectedChannel resolvedSelectedChannel = this.$selectedChannel;
            if (!(resolvedSelectedChannel instanceof StoreChannelsSelected.ResolvedSelectedChannel.ThreadDraft)) {
                resolvedSelectedChannel = null;
            }
            return new ChatInputViewModel.StoreState.Loaded(channel, meUser, editingMessage, num, l, guildVerificationLevel, z2, zBooleanValue, guild, pendingReply, (StoreChannelsSelected.ResolvedSelectedChannel.ThreadDraft) resolvedSelectedChannel, guildMember, guildJoinRequest, threadDraftState, z3);
        }
    }

    public ChatInputViewModel$Companion$observeStoreState$1(StoreUser storeUser, StoreChat storeChat, StoreUserRelationships storeUserRelationships, StorePermissions storePermissions, StoreGuilds storeGuilds, StoreLurking storeLurking, StoreSlowMode storeSlowMode, StorePendingReplies storePendingReplies, StoreGuildJoinRequest storeGuildJoinRequest, StoreThreadDraft storeThreadDraft) {
        this.$storeUsers = storeUser;
        this.$storeChat = storeChat;
        this.$storeUserRelationships = storeUserRelationships;
        this.$storePermissions = storePermissions;
        this.$storeGuilds = storeGuilds;
        this.$storeLurking = storeLurking;
        this.$storeSlowMode = storeSlowMode;
        this.$storePendingReplies = storePendingReplies;
        this.$storeGuildJoinRequest = storeGuildJoinRequest;
        this.$storeThreadDraft = storeThreadDraft;
    }

    @Override // j0.k.Func1
    public /* bridge */ /* synthetic */ Observable<? extends ChatInputViewModel.StoreState> call(StoreChannelsSelected.ResolvedSelectedChannel resolvedSelectedChannel) {
        return call2(resolvedSelectedChannel);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends ChatInputViewModel.StoreState> call2(StoreChannelsSelected.ResolvedSelectedChannel resolvedSelectedChannel) {
        Channel channelOrParent = resolvedSelectedChannel.getChannelOrParent();
        if (channelOrParent == null) {
            return new ScalarSynchronousObservable(ChatInputViewModel.StoreState.Loading.INSTANCE);
        }
        Observable<MeUser> observableObserveMe = this.$storeUsers.observeMe(true);
        Observable observableComputationBuffered = ObservableExtensionsKt.computationBuffered(this.$storeChat.observeEditingMessage());
        StoreUserRelationships storeUserRelationships = this.$storeUserRelationships;
        User userA = ChannelUtils.a(channelOrParent);
        Observable<Integer> observableObserve = storeUserRelationships.observe(userA != null ? userA.getId() : 0L);
        Observable<Long> observableObservePermissionsForChannel = this.$storePermissions.observePermissionsForChannel(channelOrParent.getId());
        ChatInputViewModel.Companion companion = ChatInputViewModel.INSTANCE;
        Observable observableAccess$getVerificationLevelTriggeredObservable = ChatInputViewModel.Companion.access$getVerificationLevelTriggeredObservable(companion, channelOrParent.getGuildId(), this.$storeGuilds, this.$storeUsers);
        Observable<Boolean> observableIsLurkingObs = this.$storeLurking.isLurkingObs(channelOrParent.getGuildId());
        Observable observableAccess$getIsOnCooldownObservable = ChatInputViewModel.Companion.access$getIsOnCooldownObservable(companion, channelOrParent.getId(), this.$storeSlowMode);
        Intrinsics3.checkNotNullExpressionValue(observableAccess$getIsOnCooldownObservable, "getIsOnCooldownObservabl…hannel.id, storeSlowMode)");
        return ObservableCombineLatestOverloads2.combineLatest(observableObserveMe, observableComputationBuffered, observableObserve, observableObservePermissionsForChannel, observableAccess$getVerificationLevelTriggeredObservable, observableIsLurkingObs, observableAccess$getIsOnCooldownObservable, this.$storeGuilds.observeFromChannelId(channelOrParent.getId()), ChatInputViewModel.Companion.access$getPendingReplyStateObservable(companion, channelOrParent.getId(), this.$storePendingReplies), this.$storeGuilds.observeComputedMember(channelOrParent.getGuildId(), this.$storeUsers.getMeSnapshot().getId()), this.$storeGuildJoinRequest.observeGuildJoinRequest(channelOrParent.getGuildId()), this.$storeThreadDraft.observeDraftState(), ForumPostCreateManager.INSTANCE.observeIsForumPostCreateInProgress(channelOrParent.getGuildId()), new AnonymousClass1(channelOrParent, resolvedSelectedChannel));
    }
}
