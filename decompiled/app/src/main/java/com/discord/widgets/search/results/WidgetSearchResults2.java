package com.discord.widgets.search.results;

import androidx.core.app.NotificationCompat;
import b.d.b.a.outline;
import com.discord.api.channel.Channel;
import com.discord.api.role.GuildRole;
import com.discord.models.guild.Guild;
import com.discord.models.member.GuildMember;
import com.discord.models.message.Message;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUserSettings;
import com.discord.utilities.embed.InviteEmbedModel;
import com.discord.utilities.rx.ObservableCombineLatestOverloads2;
import com.discord.utilities.search.network.state.QueryFetchState;
import com.discord.utilities.search.network.state.SearchState;
import com.discord.widgets.chat.list.entries.LoadingEntry;
import com.discord.widgets.chat.list.entries.MessageHeaderEntry;
import com.discord.widgets.chat.list.entries.SearchEmptyEntry;
import com.discord.widgets.chat.list.entries.SearchErrorEntry;
import com.discord.widgets.chat.list.entries.SearchIndexingEntry;
import com.discord.widgets.chat.list.entries.SearchResultCountEntry;
import com.discord.widgets.chat.list.model.WidgetChatListModelMessages;
import com.discord.widgets.guild_role_subscriptions.GuildRoleSubscriptionsFeatureFlag;
import com.discord.widgets.search.results.WidgetSearchResults;
import d0.t.Collections2;
import d0.t.Maps6;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import j0.k.Func1;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function10;
import rx.Observable;

/* compiled from: WidgetSearchResults.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0007\u001a*\u0012\u000e\b\u0001\u0012\n \u0001*\u0004\u0018\u00010\u00040\u0004 \u0001*\u0014\u0012\u000e\b\u0001\u0012\n \u0001*\u0004\u0018\u00010\u00040\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lcom/discord/utilities/search/network/state/SearchState;", "kotlin.jvm.PlatformType", "searchState", "Lrx/Observable;", "Lcom/discord/widgets/search/results/WidgetSearchResults$Model;", NotificationCompat.CATEGORY_CALL, "(Lcom/discord/utilities/search/network/state/SearchState;)Lrx/Observable;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.search.results.WidgetSearchResults$Model$Companion$get$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetSearchResults2<T, R> implements Func1<SearchState, Observable<? extends WidgetSearchResults.Model>> {
    public static final WidgetSearchResults2 INSTANCE = new WidgetSearchResults2();

    /* compiled from: WidgetSearchResults.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u001c\u001a\u00020\u00192\u0006\u0010\u0001\u001a\u00020\u00002\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u00032\u0016\u0010\b\u001a\u0012\u0012\b\u0012\u00060\u0002j\u0002`\u0006\u0012\u0004\u0012\u00020\u00070\u00052\u0016\u0010\u000b\u001a\u0012\u0012\b\u0012\u00060\u0002j\u0002`\t\u0012\u0004\u0012\u00020\n0\u00052*\u0010\u000e\u001a&\u0012\b\u0012\u00060\u0002j\u0002`\t\u0012\u0018\u0012\u0016\u0012\b\u0012\u00060\u0002j\u0002`\u0003\u0012\b\u0012\u00060\fj\u0002`\r0\u00050\u00052&\u0010\u0011\u001a\"\u0012\b\u0012\u00060\u0002j\u0002`\t\u0012\u0014\u0012\u0012\u0012\b\u0012\u00060\u0002j\u0002`\u000f\u0012\u0004\u0012\u00020\u00100\u00050\u00052\u0016\u0010\u0013\u001a\u0012\u0012\b\u0012\u00060\u0002j\u0002`\u0006\u0012\u0004\u0012\u00020\u00120\u00052\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u0017H\n¢\u0006\u0004\b\u001a\u0010\u001b"}, d2 = {"Lcom/discord/widgets/chat/list/model/WidgetChatListModelMessages$MessagesWithMetadata;", "messagesWithMetadata", "", "Lcom/discord/primitives/UserId;", "meId", "", "Lcom/discord/primitives/ChannelId;", "", "channelNames", "Lcom/discord/primitives/GuildId;", "Lcom/discord/models/guild/Guild;", "guilds", "Lcom/discord/models/member/GuildMember;", "Lcom/discord/stores/ClientGuildMember;", "members", "Lcom/discord/primitives/RoleId;", "Lcom/discord/api/role/GuildRole;", "roles", "Lcom/discord/api/channel/Channel;", "channels", "", "allowAnimatedEmojis", "autoPlayGifs", "Lcom/discord/utilities/embed/InviteEmbedModel;", "inviteEmbedModel", "Lcom/discord/widgets/search/results/WidgetSearchResults$Model;", "invoke", "(Lcom/discord/widgets/chat/list/model/WidgetChatListModelMessages$MessagesWithMetadata;JLjava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;ZZLcom/discord/utilities/embed/InviteEmbedModel;)Lcom/discord/widgets/search/results/WidgetSearchResults$Model;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.search.results.WidgetSearchResults$Model$Companion$get$1$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function10<WidgetChatListModelMessages.MessagesWithMetadata, Long, Map<Long, ? extends String>, Map<Long, ? extends Guild>, Map<Long, ? extends Map<Long, ? extends GuildMember>>, Map<Long, ? extends Map<Long, ? extends GuildRole>>, Map<Long, ? extends Channel>, Boolean, Boolean, InviteEmbedModel, WidgetSearchResults.Model> {
        public final /* synthetic */ SearchState $searchState;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(SearchState searchState) {
            super(10);
            this.$searchState = searchState;
        }

        @Override // kotlin.jvm.functions.Function10
        public /* bridge */ /* synthetic */ WidgetSearchResults.Model invoke(WidgetChatListModelMessages.MessagesWithMetadata messagesWithMetadata, Long l, Map<Long, ? extends String> map, Map<Long, ? extends Guild> map2, Map<Long, ? extends Map<Long, ? extends GuildMember>> map3, Map<Long, ? extends Map<Long, ? extends GuildRole>> map4, Map<Long, ? extends Channel> map5, Boolean bool, Boolean bool2, InviteEmbedModel inviteEmbedModel) {
            return invoke(messagesWithMetadata, l.longValue(), (Map<Long, String>) map, (Map<Long, Guild>) map2, (Map<Long, ? extends Map<Long, GuildMember>>) map3, (Map<Long, ? extends Map<Long, GuildRole>>) map4, (Map<Long, Channel>) map5, bool.booleanValue(), bool2.booleanValue(), inviteEmbedModel);
        }

        public final WidgetSearchResults.Model invoke(WidgetChatListModelMessages.MessagesWithMetadata messagesWithMetadata, long j, Map<Long, String> map, Map<Long, Guild> map2, Map<Long, ? extends Map<Long, GuildMember>> map3, Map<Long, ? extends Map<Long, GuildRole>> map4, Map<Long, Channel> map5, boolean z2, boolean z3, InviteEmbedModel inviteEmbedModel) {
            Long l;
            Map<Long, Guild> map6 = map2;
            Map<Long, ? extends Map<Long, GuildMember>> map7 = map3;
            Map<Long, ? extends Map<Long, GuildRole>> map8 = map4;
            Intrinsics3.checkNotNullParameter(messagesWithMetadata, "messagesWithMetadata");
            Intrinsics3.checkNotNullParameter(map, "channelNames");
            Intrinsics3.checkNotNullParameter(map6, "guilds");
            Intrinsics3.checkNotNullParameter(map7, "members");
            Intrinsics3.checkNotNullParameter(map8, "roles");
            Intrinsics3.checkNotNullParameter(map5, "channels");
            Intrinsics3.checkNotNullParameter(inviteEmbedModel, "inviteEmbedModel");
            ArrayList arrayList = new ArrayList();
            HashSet hashSet = new HashSet();
            Long l2 = null;
            if (this.$searchState.getQueryFetchState() == QueryFetchState.COMPLETED || this.$searchState.getQueryFetchState() == QueryFetchState.LOADING_MORE) {
                List<Message> messages = messagesWithMetadata.getMessages();
                if (!messages.isEmpty()) {
                    Long lValueOf = Long.valueOf(messages.get(messages.size() - 1).getId());
                    arrayList.add(new SearchResultCountEntry(this.$searchState.getTotalResults()));
                    l = lValueOf;
                } else {
                    l = null;
                }
                for (Message message : messages) {
                    Channel channel = map5.get(Long.valueOf(message.getChannelId()));
                    if (channel != null) {
                        Map mapEmptyMap = (Map) outline.c(channel, map7);
                        if (mapEmptyMap == null) {
                            mapEmptyMap = Maps6.emptyMap();
                        }
                        Map map9 = mapEmptyMap;
                        GuildMember guildMember = (GuildMember) map9.get(Long.valueOf(j));
                        List<Long> roles = guildMember != null ? guildMember.getRoles() : null;
                        if (roles == null) {
                            roles = Collections2.emptyList();
                        }
                        hashSet.addAll(roles);
                        arrayList.add(new MessageHeaderEntry(message, channel, (Guild) outline.c(channel, map6)));
                        Map<Long, GuildRole> mapEmptyMap2 = map8.get(Long.valueOf(channel.getGuildId()));
                        if (mapEmptyMap2 == null) {
                            mapEmptyMap2 = Maps6.emptyMap();
                        }
                        arrayList.addAll(WidgetChatListModelMessages.Companion.getMessageItems$default(WidgetChatListModelMessages.INSTANCE, channel, map9, mapEmptyMap2, new HashMap(), messagesWithMetadata.getMessageThreads().get(Long.valueOf(message.getId())), messagesWithMetadata.getThreadCountsAndLatestMessages().get(Long.valueOf(message.getId())), message, messagesWithMetadata.getMessageState().get(Long.valueOf(message.getId())), new HashMap(), false, false, null, z2, z3, StoreStream.INSTANCE.getUserSettings().getIsRenderEmbedsEnabled(), j, false, new HashMap(), inviteEmbedModel, false, GuildRoleSubscriptionsFeatureFlag.INSTANCE.getINSTANCE().canGuildSeePurchaseFeedbackLoopMessages(channel.getGuildId()), 524288, null));
                    }
                    map6 = map2;
                    map7 = map3;
                    map8 = map4;
                }
                if (this.$searchState.getQueryFetchState() == QueryFetchState.LOADING_MORE) {
                    arrayList.add(new LoadingEntry());
                } else if (arrayList.isEmpty()) {
                    arrayList.add(new SearchEmptyEntry());
                }
                l2 = l;
            } else if (this.$searchState.getQueryFetchState() == QueryFetchState.IN_PROGRESS) {
                arrayList.add(new LoadingEntry());
            } else if (this.$searchState.getQueryFetchState() == QueryFetchState.INDEXING) {
                arrayList.add(new SearchIndexingEntry());
            } else if (this.$searchState.getQueryFetchState() == QueryFetchState.FAILED) {
                arrayList.add(new SearchErrorEntry());
            }
            return new WidgetSearchResults.Model(arrayList, j, map, l2 != null ? l2.longValue() : 0L, hashSet);
        }
    }

    @Override // j0.k.Func1
    public /* bridge */ /* synthetic */ Observable<? extends WidgetSearchResults.Model> call(SearchState searchState) {
        return call2(searchState);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends WidgetSearchResults.Model> call2(SearchState searchState) {
        WidgetChatListModelMessages.MessagesWithMetadata.Companion companion = WidgetChatListModelMessages.MessagesWithMetadata.INSTANCE;
        List<Message> hits = searchState.getHits();
        if (hits == null) {
            hits = new ArrayList<>();
        }
        Observable<WidgetChatListModelMessages.MessagesWithMetadata> observable = companion.get(hits);
        StoreStream.Companion companion2 = StoreStream.INSTANCE;
        return ObservableCombineLatestOverloads2.combineLatest(observable, companion2.getUsers().observeMeId(), companion2.getChannels().observeNames(), companion2.getGuilds().observeGuilds(), companion2.getGuilds().observeComputed(), companion2.getGuilds().observeRoles(), companion2.getChannels().observeAllChannels(), StoreUserSettings.observeIsAnimatedEmojisEnabled$default(companion2.getUserSettings(), false, 1, null), StoreUserSettings.observeIsAutoPlayGifsEnabled$default(companion2.getUserSettings(), false, 1, null), InviteEmbedModel.Companion.observe$default(InviteEmbedModel.INSTANCE, null, null, null, null, 15, null), new AnonymousClass1(searchState));
    }
}
