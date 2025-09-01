package com.discord.widgets.user;

import androidx.core.app.NotificationCompat;
import b.d.b.a.outline;
import com.discord.api.channel.Channel;
import com.discord.api.message.MessageReference;
import com.discord.api.role.GuildRole;
import com.discord.models.guild.Guild;
import com.discord.models.member.GuildMember;
import com.discord.models.message.Message;
import com.discord.stores.StoreMessageReplies;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUserSettings;
import com.discord.utilities.embed.InviteEmbedModel;
import com.discord.utilities.rx.ObservableCombineLatestOverloads2;
import com.discord.widgets.chat.list.entries.LoadingEntry;
import com.discord.widgets.chat.list.entries.MentionFooterEntry;
import com.discord.widgets.chat.list.entries.MessageHeaderEntry;
import com.discord.widgets.chat.list.model.WidgetChatListModelMessages;
import com.discord.widgets.guild_role_subscriptions.GuildRoleSubscriptionsFeatureFlag;
import com.discord.widgets.tabs.NavigationTab;
import com.discord.widgets.user.WidgetUserMentions;
import d0.t.Maps6;
import d0.t.Sets5;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import j0.k.Func1;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.functions.Function11;
import rx.Observable;

/* compiled from: WidgetUserMentions.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0007\u001a*\u0012\u000e\b\u0001\u0012\n \u0001*\u0004\u0018\u00010\u00040\u0004 \u0001*\u0014\u0012\u000e\b\u0001\u0012\n \u0001*\u0004\u0018\u00010\u00040\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lcom/discord/widgets/user/WidgetUserMentions$Model$MessageLoader$LoadingState;", "kotlin.jvm.PlatformType", "loadedState", "Lrx/Observable;", "Lcom/discord/widgets/user/WidgetUserMentions$Model;", NotificationCompat.CATEGORY_CALL, "(Lcom/discord/widgets/user/WidgetUserMentions$Model$MessageLoader$LoadingState;)Lrx/Observable;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final class WidgetUserMentions$Model$Companion$get$1<T, R> implements Func1<WidgetUserMentions.Model.MessageLoader.LoadingState, Observable<? extends WidgetUserMentions.Model>> {
    public final /* synthetic */ NavigationTab $selectedTab;

    /* compiled from: WidgetUserMentions.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u001d\u001a\u00020\u001a2\u0006\u0010\u0001\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0016\u0010\b\u001a\u0012\u0012\b\u0012\u00060\u0005j\u0002`\u0006\u0012\u0004\u0012\u00020\u00070\u00042\u0016\u0010\n\u001a\u0012\u0012\b\u0012\u00060\u0005j\u0002`\u0006\u0012\u0004\u0012\u00020\t0\u00042\u0016\u0010\f\u001a\u0012\u0012\b\u0012\u00060\u0005j\u0002`\u000b\u0012\u0004\u0012\u00020\u00020\u00042&\u0010\u000f\u001a\"\u0012\b\u0012\u00060\u0005j\u0002`\u000b\u0012\u0014\u0012\u0012\u0012\b\u0012\u00060\u0005j\u0002`\r\u0012\u0004\u0012\u00020\u000e0\u00040\u00042*\u0010\u0013\u001a&\u0012\b\u0012\u00060\u0005j\u0002`\u000b\u0012\u0018\u0012\u0016\u0012\b\u0012\u00060\u0005j\u0002`\u0010\u0012\b\u0012\u00060\u0011j\u0002`\u00120\u00040\u00042\n\u0010\u0014\u001a\u00060\u0005j\u0002`\u00102\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u00152\u0006\u0010\u0019\u001a\u00020\u0018H\n¢\u0006\u0004\b\u001b\u0010\u001c"}, d2 = {"Lcom/discord/widgets/chat/list/model/WidgetChatListModelMessages$MessagesWithMetadata;", "messagesWithMetadata", "Lcom/discord/models/guild/Guild;", "selectedGuild", "", "", "Lcom/discord/primitives/ChannelId;", "Lcom/discord/api/channel/Channel;", "channels", "", "names", "Lcom/discord/primitives/GuildId;", "guilds", "Lcom/discord/primitives/RoleId;", "Lcom/discord/api/role/GuildRole;", "roles", "Lcom/discord/primitives/UserId;", "Lcom/discord/models/member/GuildMember;", "Lcom/discord/stores/ClientGuildMember;", "members", "meUserId", "", "allowAnimatedEmojis", "autoPlayGifs", "Lcom/discord/utilities/embed/InviteEmbedModel;", "inviteEmbedModel", "Lcom/discord/widgets/user/WidgetUserMentions$Model;", "invoke", "(Lcom/discord/widgets/chat/list/model/WidgetChatListModelMessages$MessagesWithMetadata;Lcom/discord/models/guild/Guild;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;JZZLcom/discord/utilities/embed/InviteEmbedModel;)Lcom/discord/widgets/user/WidgetUserMentions$Model;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.user.WidgetUserMentions$Model$Companion$get$1$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function11<WidgetChatListModelMessages.MessagesWithMetadata, Guild, Map<Long, ? extends Channel>, Map<Long, ? extends String>, Map<Long, ? extends Guild>, Map<Long, ? extends Map<Long, ? extends GuildRole>>, Map<Long, ? extends Map<Long, ? extends GuildMember>>, Long, Boolean, Boolean, InviteEmbedModel, WidgetUserMentions.Model> {
        public final /* synthetic */ WidgetUserMentions.Model.MessageLoader.LoadingState $loadedState;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(WidgetUserMentions.Model.MessageLoader.LoadingState loadingState) {
            super(11);
            this.$loadedState = loadingState;
        }

        @Override // kotlin.jvm.functions.Function11
        public /* bridge */ /* synthetic */ WidgetUserMentions.Model invoke(WidgetChatListModelMessages.MessagesWithMetadata messagesWithMetadata, Guild guild, Map<Long, ? extends Channel> map, Map<Long, ? extends String> map2, Map<Long, ? extends Guild> map3, Map<Long, ? extends Map<Long, ? extends GuildRole>> map4, Map<Long, ? extends Map<Long, ? extends GuildMember>> map5, Long l, Boolean bool, Boolean bool2, InviteEmbedModel inviteEmbedModel) {
            return invoke(messagesWithMetadata, guild, (Map<Long, Channel>) map, (Map<Long, String>) map2, (Map<Long, Guild>) map3, (Map<Long, ? extends Map<Long, GuildRole>>) map4, (Map<Long, ? extends Map<Long, GuildMember>>) map5, l.longValue(), bool.booleanValue(), bool2.booleanValue(), inviteEmbedModel);
        }

        public final WidgetUserMentions.Model invoke(WidgetChatListModelMessages.MessagesWithMetadata messagesWithMetadata, Guild guild, Map<Long, Channel> map, Map<Long, String> map2, Map<Long, Guild> map3, Map<Long, ? extends Map<Long, GuildRole>> map4, Map<Long, ? extends Map<Long, GuildMember>> map5, long j, boolean z2, boolean z3, InviteEmbedModel inviteEmbedModel) {
            Map<Long, Channel> map6 = map;
            Map<Long, ? extends Map<Long, GuildRole>> map7 = map4;
            Map<Long, ? extends Map<Long, GuildMember>> map8 = map5;
            Intrinsics3.checkNotNullParameter(messagesWithMetadata, "messagesWithMetadata");
            Intrinsics3.checkNotNullParameter(map6, "channels");
            Intrinsics3.checkNotNullParameter(map2, "names");
            Intrinsics3.checkNotNullParameter(map3, "guilds");
            Intrinsics3.checkNotNullParameter(map7, "roles");
            Intrinsics3.checkNotNullParameter(map8, "members");
            Intrinsics3.checkNotNullParameter(inviteEmbedModel, "inviteEmbedModel");
            long id2 = guild != null ? guild.getId() : 0L;
            String name = guild != null ? guild.getName() : null;
            ArrayList arrayList = new ArrayList(this.$loadedState.getMentions().size() * 2);
            Set setEmptySet = Sets5.emptySet();
            Map<Long, StoreMessageReplies.MessageState> allMessageReferences = StoreStream.INSTANCE.getRepliedMessages().getAllMessageReferences();
            for (Message message : this.$loadedState.getMentions()) {
                Channel channel = map6.get(Long.valueOf(message.getChannelId()));
                if (channel != null) {
                    Map<Long, GuildMember> mapEmptyMap = map8.get(Long.valueOf(message.getChannelId()));
                    if (mapEmptyMap == null) {
                        mapEmptyMap = Maps6.emptyMap();
                    }
                    Map<Long, GuildMember> map9 = mapEmptyMap;
                    Object objC = outline.c(channel, map7);
                    if (objC == null) {
                        objC = Maps6.emptyMap();
                    }
                    Map map10 = (Map) objC;
                    LinkedHashMap linkedHashMap = new LinkedHashMap();
                    MessageReference messageReference = message.getMessageReference();
                    Long messageId = messageReference != null ? messageReference.getMessageId() : null;
                    if (messageId != null) {
                        Object obj = (StoreMessageReplies.MessageState) allMessageReferences.get(messageId);
                        if (obj == null) {
                            obj = StoreMessageReplies.MessageState.Unloaded.INSTANCE;
                        }
                        linkedHashMap.put(messageId, obj);
                    }
                    arrayList.add(new MessageHeaderEntry(message, channel, (Guild) outline.c(channel, map3)));
                    arrayList.addAll(WidgetChatListModelMessages.Companion.getMessageItems$default(WidgetChatListModelMessages.INSTANCE, channel, map9, map10, Maps6.emptyMap(), messagesWithMetadata.getMessageThreads().get(Long.valueOf(message.getId())), messagesWithMetadata.getThreadCountsAndLatestMessages().get(Long.valueOf(message.getId())), message, messagesWithMetadata.getMessageState().get(Long.valueOf(message.getId())), linkedHashMap, false, false, null, z2, z3, StoreStream.INSTANCE.getUserSettings().getIsRenderEmbedsEnabled(), j, false, new HashMap(), inviteEmbedModel, false, GuildRoleSubscriptionsFeatureFlag.INSTANCE.getINSTANCE().canGuildSeePurchaseFeedbackLoopMessages(channel.getGuildId()), 524288, null));
                }
                map6 = map;
                map7 = map4;
                map8 = map5;
            }
            if (this.$loadedState.isLoading()) {
                arrayList.add(new LoadingEntry());
            } else if (this.$loadedState.isAllLoaded()) {
                arrayList.add(new MentionFooterEntry());
            }
            return new WidgetUserMentions.Model(j, -1L, map3.get(Long.valueOf(id2)), id2, map2, -1L, arrayList, setEmptySet, -1L, false, z2, name, WidgetUserMentions$Model$Companion$get$1.this.$selectedTab, 512, null);
        }
    }

    public WidgetUserMentions$Model$Companion$get$1(NavigationTab navigationTab) {
        this.$selectedTab = navigationTab;
    }

    @Override // j0.k.Func1
    public /* bridge */ /* synthetic */ Observable<? extends WidgetUserMentions.Model> call(WidgetUserMentions.Model.MessageLoader.LoadingState loadingState) {
        return call2(loadingState);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends WidgetUserMentions.Model> call2(WidgetUserMentions.Model.MessageLoader.LoadingState loadingState) {
        Observable<WidgetChatListModelMessages.MessagesWithMetadata> observable = WidgetChatListModelMessages.MessagesWithMetadata.INSTANCE.get(loadingState.getMentions());
        StoreStream.Companion companion = StoreStream.INSTANCE;
        return ObservableCombineLatestOverloads2.combineLatest(observable, companion.getGuildSelected().observeSelectedGuild(), companion.getChannels().observeAllChannels(), companion.getChannels().observeNames(), companion.getGuilds().observeGuilds(), companion.getGuilds().observeRoles(), companion.getGuilds().observeComputed(), companion.getUsers().observeMeId(), StoreUserSettings.observeIsAnimatedEmojisEnabled$default(companion.getUserSettings(), false, 1, null), StoreUserSettings.observeIsAutoPlayGifsEnabled$default(companion.getUserSettings(), false, 1, null), InviteEmbedModel.Companion.observe$default(InviteEmbedModel.INSTANCE, null, null, null, null, 15, null), new AnonymousClass1(loadingState));
    }
}
