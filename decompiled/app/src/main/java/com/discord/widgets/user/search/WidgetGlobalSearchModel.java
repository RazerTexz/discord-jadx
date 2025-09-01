package com.discord.widgets.user.search;

import a0.a.a.b;
import androidx.annotation.StringRes;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.guild.Guild;
import com.discord.models.member.GuildMember;
import com.discord.models.presence.Presence;
import com.discord.models.user.User;
import com.discord.stores.StoreStream;
import com.discord.utilities.frecency.FrecencyTracker;
import com.discord.utilities.mg_recycler.MGRecyclerDataPayload;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.rx.ObservableWithLeadingEdgeThrottle;
import com.discord.utilities.search.SearchUtils;
import com.discord.utilities.string.StringUtils2;
import com.discord.widgets.chat.input.MentionUtils;
import com.discord.widgets.user.search.WidgetGlobalSearchGuildsModel;
import d0.f0._Sequences2;
import d0.f0.n;
import d0.g0.Strings4;
import d0.g0.StringsJVM;
import d0.g0._Strings;
import d0.t.Sets5;
import d0.t._Collections;
import d0.z.d.Intrinsics3;
import j0.l.e.ScalarSynchronousObservable;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.sequences.Sequence;
import rx.Observable;
import rx.functions.Func4;
import rx.functions.Func7;
import rx.functions.Func8;

/* compiled from: WidgetGlobalSearchModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0016\b\u0086\b\u0018\u0000 #2\u00020\u0001:\n$#%&'()*+,B7\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u0012\u0006\u0010\u000f\u001a\u00020\u0005\u0012\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\t0\b\u0012\u0010\b\u0002\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\b¢\u0006\u0004\b!\u0010\"J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0016\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0018\u0010\r\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\bHÆ\u0003¢\u0006\u0004\b\r\u0010\u000bJF\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u000e\u001a\u00020\u00022\b\b\u0002\u0010\u000f\u001a\u00020\u00052\u000e\b\u0002\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0010\b\u0002\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\bHÆ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0004J\u0010\u0010\u0015\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0007J\u001a\u0010\u0018\u001a\u00020\u00172\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0018\u0010\u0019R\u0019\u0010\u000e\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u001a\u001a\u0004\b\u001b\u0010\u0004R\u0019\u0010\u000f\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u001c\u001a\u0004\b\u001d\u0010\u0007R\u001f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\t0\b8\u0006@\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u001e\u001a\u0004\b\u001f\u0010\u000bR!\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\b8\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u001e\u001a\u0004\b \u0010\u000b¨\u0006-"}, d2 = {"Lcom/discord/widgets/user/search/WidgetGlobalSearchModel;", "", "", "component1", "()Ljava/lang/String;", "", "component2", "()I", "", "Lcom/discord/widgets/user/search/WidgetGlobalSearchModel$ItemDataPayload;", "component3", "()Ljava/util/List;", "Lcom/discord/widgets/user/search/WidgetGlobalSearchGuildsModel$Item;", "component4", "filter", "searchType", "data", "guildsList", "copy", "(Ljava/lang/String;ILjava/util/List;Ljava/util/List;)Lcom/discord/widgets/user/search/WidgetGlobalSearchModel;", "toString", "hashCode", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getFilter", "I", "getSearchType", "Ljava/util/List;", "getData", "getGuildsList", "<init>", "(Ljava/lang/String;ILjava/util/List;Ljava/util/List;)V", "Companion", "ChannelContext", "ItemChannel", "ItemDataPayload", "ItemGuild", "ItemHeader", "ItemUser", "MatchedResult", "SearchContext", "UsersContext", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final /* data */ class WidgetGlobalSearchModel {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Function2<Channel, Map<Long, Long>, Boolean> DEFAULT_PERMISSIONS_PREDICATE;
    private static final Pattern DISCRIMINATOR_PATTERN;
    private static final int MAX_RESULTS = 50;
    public static final int SEARCH_TYPE_GENERAL = 0;
    public static final int SEARCH_TYPE_GUILD = 3;
    public static final int SEARCH_TYPE_TEXT_CHANNEL = 2;
    public static final int SEARCH_TYPE_USER = 1;
    public static final int SEARCH_TYPE_VOICE_CHANNEL = 4;
    public static final int TYPE_CHANNEL = 0;
    public static final int TYPE_GUILD = 2;
    public static final int TYPE_HEADER = -1;
    public static final int TYPE_USER = 1;
    private final List<ItemDataPayload> data;
    private final String filter;
    private final List<WidgetGlobalSearchGuildsModel.Item> guildsList;
    private final int searchType;

    /* compiled from: WidgetGlobalSearchModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\"\n\u0002\b\r\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0011\b\u0086\b\u0018\u00002\u00020\u0001BÉ\u0001\u0012\u0016\u0010\u0015\u001a\u0012\u0012\b\u0012\u00060\u0003j\u0002`\u0004\u0012\u0004\u0012\u00020\u00050\u0002\u0012\u0016\u0010\u0016\u001a\u0012\u0012\b\u0012\u00060\u0003j\u0002`\b\u0012\u0004\u0012\u00020\t0\u0002\u0012\u0016\u0010\u0017\u001a\u0012\u0012\b\u0012\u00060\u0003j\u0002`\b\u0012\u0004\u0012\u00020\t0\u0002\u0012\u001a\u0010\u0018\u001a\u0016\u0012\b\u0012\u00060\u0003j\u0002`\b\u0012\b\u0012\u00060\u0003j\u0002`\f0\u0002\u0012\u0016\u0010\u0019\u001a\u0012\u0012\b\u0012\u00060\u0003j\u0002`\b\u0012\u0004\u0012\u00020\t0\u0002\u0012 \u0010\u001a\u001a\u001c\u0012\b\u0012\u00060\u0003j\u0002`\u0004\u0012\u000e\u0012\f\u0012\b\u0012\u00060\u0003j\u0002`\b0\u000f0\u0002\u0012\u0010\u0010\u001b\u001a\f\u0012\b\u0012\u00060\u0003j\u0002`\b0\u0011\u0012\u0010\u0010\u001c\u001a\f\u0012\b\u0012\u00060\u0003j\u0002`\u00040\u0011¢\u0006\u0004\b5\u00106J \u0010\u0006\u001a\u0012\u0012\b\u0012\u00060\u0003j\u0002`\u0004\u0012\u0004\u0012\u00020\u00050\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J \u0010\n\u001a\u0012\u0012\b\u0012\u00060\u0003j\u0002`\b\u0012\u0004\u0012\u00020\t0\u0002HÆ\u0003¢\u0006\u0004\b\n\u0010\u0007J \u0010\u000b\u001a\u0012\u0012\b\u0012\u00060\u0003j\u0002`\b\u0012\u0004\u0012\u00020\t0\u0002HÆ\u0003¢\u0006\u0004\b\u000b\u0010\u0007J$\u0010\r\u001a\u0016\u0012\b\u0012\u00060\u0003j\u0002`\b\u0012\b\u0012\u00060\u0003j\u0002`\f0\u0002HÆ\u0003¢\u0006\u0004\b\r\u0010\u0007J \u0010\u000e\u001a\u0012\u0012\b\u0012\u00060\u0003j\u0002`\b\u0012\u0004\u0012\u00020\t0\u0002HÆ\u0003¢\u0006\u0004\b\u000e\u0010\u0007J*\u0010\u0010\u001a\u001c\u0012\b\u0012\u00060\u0003j\u0002`\u0004\u0012\u000e\u0012\f\u0012\b\u0012\u00060\u0003j\u0002`\b0\u000f0\u0002HÆ\u0003¢\u0006\u0004\b\u0010\u0010\u0007J\u001a\u0010\u0012\u001a\f\u0012\b\u0012\u00060\u0003j\u0002`\b0\u0011HÆ\u0003¢\u0006\u0004\b\u0012\u0010\u0013J\u001a\u0010\u0014\u001a\f\u0012\b\u0012\u00060\u0003j\u0002`\u00040\u0011HÆ\u0003¢\u0006\u0004\b\u0014\u0010\u0013Jâ\u0001\u0010\u001d\u001a\u00020\u00002\u0018\b\u0002\u0010\u0015\u001a\u0012\u0012\b\u0012\u00060\u0003j\u0002`\u0004\u0012\u0004\u0012\u00020\u00050\u00022\u0018\b\u0002\u0010\u0016\u001a\u0012\u0012\b\u0012\u00060\u0003j\u0002`\b\u0012\u0004\u0012\u00020\t0\u00022\u0018\b\u0002\u0010\u0017\u001a\u0012\u0012\b\u0012\u00060\u0003j\u0002`\b\u0012\u0004\u0012\u00020\t0\u00022\u001c\b\u0002\u0010\u0018\u001a\u0016\u0012\b\u0012\u00060\u0003j\u0002`\b\u0012\b\u0012\u00060\u0003j\u0002`\f0\u00022\u0018\b\u0002\u0010\u0019\u001a\u0012\u0012\b\u0012\u00060\u0003j\u0002`\b\u0012\u0004\u0012\u00020\t0\u00022\"\b\u0002\u0010\u001a\u001a\u001c\u0012\b\u0012\u00060\u0003j\u0002`\u0004\u0012\u000e\u0012\f\u0012\b\u0012\u00060\u0003j\u0002`\b0\u000f0\u00022\u0012\b\u0002\u0010\u001b\u001a\f\u0012\b\u0012\u00060\u0003j\u0002`\b0\u00112\u0012\b\u0002\u0010\u001c\u001a\f\u0012\b\u0012\u00060\u0003j\u0002`\u00040\u0011HÆ\u0001¢\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010 \u001a\u00020\u001fHÖ\u0001¢\u0006\u0004\b \u0010!J\u0010\u0010#\u001a\u00020\"HÖ\u0001¢\u0006\u0004\b#\u0010$J\u001a\u0010'\u001a\u00020&2\b\u0010%\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b'\u0010(R)\u0010\u0015\u001a\u0012\u0012\b\u0012\u00060\u0003j\u0002`\u0004\u0012\u0004\u0012\u00020\u00050\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0015\u0010)\u001a\u0004\b*\u0010\u0007R3\u0010\u001a\u001a\u001c\u0012\b\u0012\u00060\u0003j\u0002`\u0004\u0012\u000e\u0012\f\u0012\b\u0012\u00060\u0003j\u0002`\b0\u000f0\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u001a\u0010)\u001a\u0004\b+\u0010\u0007R#\u0010\u001b\u001a\f\u0012\b\u0012\u00060\u0003j\u0002`\b0\u00118\u0006@\u0006¢\u0006\f\n\u0004\b\u001b\u0010,\u001a\u0004\b-\u0010\u0013R#\u0010.\u001a\f\u0012\b\u0012\u00060\u0003j\u0002`\u00040\u00118\u0006@\u0006¢\u0006\f\n\u0004\b.\u0010,\u001a\u0004\b/\u0010\u0013R)\u0010\u0016\u001a\u0012\u0012\b\u0012\u00060\u0003j\u0002`\b\u0012\u0004\u0012\u00020\t0\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0016\u0010)\u001a\u0004\b0\u0010\u0007R)\u0010\u0019\u001a\u0012\u0012\b\u0012\u00060\u0003j\u0002`\b\u0012\u0004\u0012\u00020\t0\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0019\u0010)\u001a\u0004\b1\u0010\u0007R#\u0010\u001c\u001a\f\u0012\b\u0012\u00060\u0003j\u0002`\u00040\u00118\u0006@\u0006¢\u0006\f\n\u0004\b\u001c\u0010,\u001a\u0004\b2\u0010\u0013R)\u0010\u0017\u001a\u0012\u0012\b\u0012\u00060\u0003j\u0002`\b\u0012\u0004\u0012\u00020\t0\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0017\u0010)\u001a\u0004\b3\u0010\u0007R-\u0010\u0018\u001a\u0016\u0012\b\u0012\u00060\u0003j\u0002`\b\u0012\b\u0012\u00060\u0003j\u0002`\f0\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0018\u0010)\u001a\u0004\b4\u0010\u0007¨\u00067"}, d2 = {"Lcom/discord/widgets/user/search/WidgetGlobalSearchModel$ChannelContext;", "", "", "", "Lcom/discord/primitives/GuildId;", "Lcom/discord/models/guild/Guild;", "component1", "()Ljava/util/Map;", "Lcom/discord/primitives/ChannelId;", "Lcom/discord/api/channel/Channel;", "component2", "component3", "Lcom/discord/api/permission/PermissionBit;", "component4", "component5", "", "component6", "", "component7", "()Ljava/util/Set;", "component8", "guilds", "channels", "activeJoinedThreads", "channelPerms", "channelsPrivate", "guildToChannels", "unreadChannelIds", "unreadGuildIds", "copy", "(Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/util/Set;Ljava/util/Set;)Lcom/discord/widgets/user/search/WidgetGlobalSearchModel$ChannelContext;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/util/Map;", "getGuilds", "getGuildToChannels", "Ljava/util/Set;", "getUnreadChannelIds", "smallGuildIds", "getSmallGuildIds", "getChannels", "getChannelsPrivate", "getUnreadGuildIds", "getActiveJoinedThreads", "getChannelPerms", "<init>", "(Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/util/Set;Ljava/util/Set;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class ChannelContext {
        private final Map<Long, Channel> activeJoinedThreads;
        private final Map<Long, Long> channelPerms;
        private final Map<Long, Channel> channels;
        private final Map<Long, Channel> channelsPrivate;
        private final Map<Long, List<Long>> guildToChannels;
        private final Map<Long, Guild> guilds;
        private final Set<Long> smallGuildIds;
        private final Set<Long> unreadChannelIds;
        private final Set<Long> unreadGuildIds;

        /* JADX WARN: Multi-variable type inference failed */
        public ChannelContext(Map<Long, Guild> map, Map<Long, Channel> map2, Map<Long, Channel> map3, Map<Long, Long> map4, Map<Long, Channel> map5, Map<Long, ? extends List<Long>> map6, Set<Long> set, Set<Long> set2) {
            Intrinsics3.checkNotNullParameter(map, "guilds");
            Intrinsics3.checkNotNullParameter(map2, "channels");
            Intrinsics3.checkNotNullParameter(map3, "activeJoinedThreads");
            Intrinsics3.checkNotNullParameter(map4, "channelPerms");
            Intrinsics3.checkNotNullParameter(map5, "channelsPrivate");
            Intrinsics3.checkNotNullParameter(map6, "guildToChannels");
            Intrinsics3.checkNotNullParameter(set, "unreadChannelIds");
            Intrinsics3.checkNotNullParameter(set2, "unreadGuildIds");
            this.guilds = map;
            this.channels = map2;
            this.activeJoinedThreads = map3;
            this.channelPerms = map4;
            this.channelsPrivate = map5;
            this.guildToChannels = map6;
            this.unreadChannelIds = set;
            this.unreadGuildIds = set2;
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (Map.Entry<Long, Guild> entry : map.entrySet()) {
                if (entry.getValue().getMemberCount() <= 200) {
                    linkedHashMap.put(entry.getKey(), entry.getValue());
                }
            }
            this.smallGuildIds = linkedHashMap.keySet();
        }

        public static /* synthetic */ ChannelContext copy$default(ChannelContext channelContext, Map map, Map map2, Map map3, Map map4, Map map5, Map map6, Set set, Set set2, int i, Object obj) {
            return channelContext.copy((i & 1) != 0 ? channelContext.guilds : map, (i & 2) != 0 ? channelContext.channels : map2, (i & 4) != 0 ? channelContext.activeJoinedThreads : map3, (i & 8) != 0 ? channelContext.channelPerms : map4, (i & 16) != 0 ? channelContext.channelsPrivate : map5, (i & 32) != 0 ? channelContext.guildToChannels : map6, (i & 64) != 0 ? channelContext.unreadChannelIds : set, (i & 128) != 0 ? channelContext.unreadGuildIds : set2);
        }

        public final Map<Long, Guild> component1() {
            return this.guilds;
        }

        public final Map<Long, Channel> component2() {
            return this.channels;
        }

        public final Map<Long, Channel> component3() {
            return this.activeJoinedThreads;
        }

        public final Map<Long, Long> component4() {
            return this.channelPerms;
        }

        public final Map<Long, Channel> component5() {
            return this.channelsPrivate;
        }

        public final Map<Long, List<Long>> component6() {
            return this.guildToChannels;
        }

        public final Set<Long> component7() {
            return this.unreadChannelIds;
        }

        public final Set<Long> component8() {
            return this.unreadGuildIds;
        }

        public final ChannelContext copy(Map<Long, Guild> guilds, Map<Long, Channel> channels, Map<Long, Channel> activeJoinedThreads, Map<Long, Long> channelPerms, Map<Long, Channel> channelsPrivate, Map<Long, ? extends List<Long>> guildToChannels, Set<Long> unreadChannelIds, Set<Long> unreadGuildIds) {
            Intrinsics3.checkNotNullParameter(guilds, "guilds");
            Intrinsics3.checkNotNullParameter(channels, "channels");
            Intrinsics3.checkNotNullParameter(activeJoinedThreads, "activeJoinedThreads");
            Intrinsics3.checkNotNullParameter(channelPerms, "channelPerms");
            Intrinsics3.checkNotNullParameter(channelsPrivate, "channelsPrivate");
            Intrinsics3.checkNotNullParameter(guildToChannels, "guildToChannels");
            Intrinsics3.checkNotNullParameter(unreadChannelIds, "unreadChannelIds");
            Intrinsics3.checkNotNullParameter(unreadGuildIds, "unreadGuildIds");
            return new ChannelContext(guilds, channels, activeJoinedThreads, channelPerms, channelsPrivate, guildToChannels, unreadChannelIds, unreadGuildIds);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ChannelContext)) {
                return false;
            }
            ChannelContext channelContext = (ChannelContext) other;
            return Intrinsics3.areEqual(this.guilds, channelContext.guilds) && Intrinsics3.areEqual(this.channels, channelContext.channels) && Intrinsics3.areEqual(this.activeJoinedThreads, channelContext.activeJoinedThreads) && Intrinsics3.areEqual(this.channelPerms, channelContext.channelPerms) && Intrinsics3.areEqual(this.channelsPrivate, channelContext.channelsPrivate) && Intrinsics3.areEqual(this.guildToChannels, channelContext.guildToChannels) && Intrinsics3.areEqual(this.unreadChannelIds, channelContext.unreadChannelIds) && Intrinsics3.areEqual(this.unreadGuildIds, channelContext.unreadGuildIds);
        }

        public final Map<Long, Channel> getActiveJoinedThreads() {
            return this.activeJoinedThreads;
        }

        public final Map<Long, Long> getChannelPerms() {
            return this.channelPerms;
        }

        public final Map<Long, Channel> getChannels() {
            return this.channels;
        }

        public final Map<Long, Channel> getChannelsPrivate() {
            return this.channelsPrivate;
        }

        public final Map<Long, List<Long>> getGuildToChannels() {
            return this.guildToChannels;
        }

        public final Map<Long, Guild> getGuilds() {
            return this.guilds;
        }

        public final Set<Long> getSmallGuildIds() {
            return this.smallGuildIds;
        }

        public final Set<Long> getUnreadChannelIds() {
            return this.unreadChannelIds;
        }

        public final Set<Long> getUnreadGuildIds() {
            return this.unreadGuildIds;
        }

        public int hashCode() {
            Map<Long, Guild> map = this.guilds;
            int iHashCode = (map != null ? map.hashCode() : 0) * 31;
            Map<Long, Channel> map2 = this.channels;
            int iHashCode2 = (iHashCode + (map2 != null ? map2.hashCode() : 0)) * 31;
            Map<Long, Channel> map3 = this.activeJoinedThreads;
            int iHashCode3 = (iHashCode2 + (map3 != null ? map3.hashCode() : 0)) * 31;
            Map<Long, Long> map4 = this.channelPerms;
            int iHashCode4 = (iHashCode3 + (map4 != null ? map4.hashCode() : 0)) * 31;
            Map<Long, Channel> map5 = this.channelsPrivate;
            int iHashCode5 = (iHashCode4 + (map5 != null ? map5.hashCode() : 0)) * 31;
            Map<Long, List<Long>> map6 = this.guildToChannels;
            int iHashCode6 = (iHashCode5 + (map6 != null ? map6.hashCode() : 0)) * 31;
            Set<Long> set = this.unreadChannelIds;
            int iHashCode7 = (iHashCode6 + (set != null ? set.hashCode() : 0)) * 31;
            Set<Long> set2 = this.unreadGuildIds;
            return iHashCode7 + (set2 != null ? set2.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbU = outline.U("ChannelContext(guilds=");
            sbU.append(this.guilds);
            sbU.append(", channels=");
            sbU.append(this.channels);
            sbU.append(", activeJoinedThreads=");
            sbU.append(this.activeJoinedThreads);
            sbU.append(", channelPerms=");
            sbU.append(this.channelPerms);
            sbU.append(", channelsPrivate=");
            sbU.append(this.channelsPrivate);
            sbU.append(", guildToChannels=");
            sbU.append(this.guildToChannels);
            sbU.append(", unreadChannelIds=");
            sbU.append(this.unreadChannelIds);
            sbU.append(", unreadGuildIds=");
            return outline.N(sbU, this.unreadGuildIds, ")");
        }
    }

    /* compiled from: WidgetGlobalSearchModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u008a\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000e\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\bD\u0010EJ\u0081\u0001\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022,\u0010\f\u001a(\u0012\u0004\u0012\u00020\u0006\u0012\u0018\u0012\u0016\u0012\b\u0012\u00060\bj\u0002`\t\u0012\b\u0012\u00060\bj\u0002`\n0\u0007\u0012\u0004\u0012\u00020\u000b0\u00052\u0016\b\u0002\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000b\u0018\u00010\r2\u0016\u0010\u0011\u001a\u0012\u0012\u0004\u0012\u00020\u0010\u0012\b\u0012\u00060\bj\u0002`\t0\rH\u0002¢\u0006\u0004\b\u0013\u0010\u0014J?\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001d2\u0006\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u00182\u0010\u0010\u001c\u001a\f\u0012\b\u0012\u00060\bj\u0002`\u001b0\u001aH\u0002¢\u0006\u0004\b\u001f\u0010 J\u001d\u0010!\u001a\f\u0012\b\u0012\u00060\bj\u0002`\t0\u001d*\u00020\u0010H\u0002¢\u0006\u0004\b!\u0010\"J\u001b\u0010%\u001a\u0004\u0018\u00010$*\u00020\u00032\u0006\u0010#\u001a\u00020\u0003¢\u0006\u0004\b%\u0010&J\u001b\u0010'\u001a\u0004\u0018\u00010$*\u00020\u00032\u0006\u0010#\u001a\u00020\u0003¢\u0006\u0004\b'\u0010&J9\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00120\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0016\b\u0002\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000b\u0018\u00010\r¢\u0006\u0004\b(\u0010)J!\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00120\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b*\u0010+J_\u0010.\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010-\u001a\u00020,2\u0016\b\u0002\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000b\u0018\u00010\r2\u0018\b\u0002\u0010\u0011\u001a\u0012\u0012\u0004\u0012\u00020\u0010\u0012\b\u0012\u00060\bj\u0002`\t0\r¢\u0006\u0004\b.\u0010/R\u0013\u00102\u001a\u00020$8F@\u0006¢\u0006\u0006\u001a\u0004\b0\u00101R<\u00103\u001a(\u0012\u0004\u0012\u00020\u0006\u0012\u0018\u0012\u0016\u0012\b\u0012\u00060\bj\u0002`\t\u0012\b\u0012\u00060\bj\u0002`\n0\u0007\u0012\u0004\u0012\u00020\u000b0\u00058\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b3\u00104R\u0016\u00106\u001a\u0002058\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b6\u00107R\u0016\u00109\u001a\u0002088\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b9\u0010:R\u0016\u0010;\u001a\u0002088\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b;\u0010:R\u0016\u0010<\u001a\u0002088\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b<\u0010:R\u0016\u0010=\u001a\u0002088\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b=\u0010:R\u0016\u0010>\u001a\u0002088\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b>\u0010:R\u0016\u0010?\u001a\u0002088\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b?\u0010:R\u0016\u0010@\u001a\u0002088\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b@\u0010:R\u0016\u0010A\u001a\u0002088\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\bA\u0010:R\u0016\u0010B\u001a\u0002088\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\bB\u0010:R\u0016\u0010C\u001a\u0002088\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\bC\u0010:¨\u0006F"}, d2 = {"Lcom/discord/widgets/user/search/WidgetGlobalSearchModel$Companion;", "", "Lrx/Observable;", "", "filterPublisher", "Lkotlin/Function2;", "Lcom/discord/api/channel/Channel;", "", "", "Lcom/discord/primitives/ChannelId;", "Lcom/discord/api/permission/PermissionBit;", "", "permissionsPredicate", "Lkotlin/Function1;", "Lcom/discord/widgets/user/search/WidgetGlobalSearchModel$ItemDataPayload;", "resultsFilter", "Lcom/discord/widgets/user/search/WidgetGlobalSearchModel$SearchContext;", "lastChannelIdProvider", "Lcom/discord/widgets/user/search/WidgetGlobalSearchModel;", "get", "(Lrx/Observable;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)Lrx/Observable;", "searchContext", "Lcom/discord/widgets/user/search/WidgetGlobalSearchModel$ChannelContext;", "channelContext", "Lcom/discord/widgets/user/search/WidgetGlobalSearchModel$UsersContext;", "usersContext", "", "Lcom/discord/primitives/UserId;", "selectedGuildUserIds", "Lkotlin/sequences/Sequence;", "Lcom/discord/models/user/User;", "getDefaultUserSearch", "(Lcom/discord/widgets/user/search/WidgetGlobalSearchModel$SearchContext;Lcom/discord/widgets/user/search/WidgetGlobalSearchModel$ChannelContext;Lcom/discord/widgets/user/search/WidgetGlobalSearchModel$UsersContext;Ljava/util/Set;)Lkotlin/sequences/Sequence;", "getRecentChannelIds", "(Lcom/discord/widgets/user/search/WidgetGlobalSearchModel$SearchContext;)Lkotlin/sequences/Sequence;", "filter", "Lcom/discord/widgets/user/search/WidgetGlobalSearchModel$MatchedResult;", "toMatchedResult", "(Ljava/lang/String;Ljava/lang/String;)Lcom/discord/widgets/user/search/WidgetGlobalSearchModel$MatchedResult;", "toFuzzyMatchedResult", "getForSend", "(Lrx/Observable;Lkotlin/jvm/functions/Function1;)Lrx/Observable;", "getForNav", "(Lrx/Observable;)Lrx/Observable;", "Lcom/discord/widgets/user/search/WidgetGlobalSearchGuildsModel;", "widgetGuildsListModel", "create", "(Lcom/discord/widgets/user/search/WidgetGlobalSearchModel$SearchContext;Lcom/discord/widgets/user/search/WidgetGlobalSearchModel$UsersContext;Lcom/discord/widgets/user/search/WidgetGlobalSearchModel$ChannelContext;Lcom/discord/widgets/user/search/WidgetGlobalSearchGuildsModel;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)Lcom/discord/widgets/user/search/WidgetGlobalSearchModel;", "getEMPTY_MATCH_RESULT", "()Lcom/discord/widgets/user/search/WidgetGlobalSearchModel$MatchedResult;", "EMPTY_MATCH_RESULT", "DEFAULT_PERMISSIONS_PREDICATE", "Lkotlin/jvm/functions/Function2;", "Ljava/util/regex/Pattern;", "DISCRIMINATOR_PATTERN", "Ljava/util/regex/Pattern;", "", "MAX_RESULTS", "I", "SEARCH_TYPE_GENERAL", "SEARCH_TYPE_GUILD", "SEARCH_TYPE_TEXT_CHANNEL", "SEARCH_TYPE_USER", "SEARCH_TYPE_VOICE_CHANNEL", "TYPE_CHANNEL", "TYPE_GUILD", "TYPE_HEADER", "TYPE_USER", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public static /* synthetic */ WidgetGlobalSearchModel create$default(Companion companion, SearchContext searchContext, UsersContext usersContext, ChannelContext channelContext, WidgetGlobalSearchGuildsModel widgetGlobalSearchGuildsModel, Function1 function1, Function1 function12, int i, Object obj) {
            if ((i & 16) != 0) {
                function1 = null;
            }
            Function1 function13 = function1;
            if ((i & 32) != 0) {
                function12 = WidgetGlobalSearchModel$Companion$create$1.INSTANCE;
            }
            return companion.create(searchContext, usersContext, channelContext, widgetGlobalSearchGuildsModel, function13, function12);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r3v17, types: [com.discord.widgets.user.search.WidgetGlobalSearchModel$sam$rx_functions_Func4$0] */
        /* JADX WARN: Type inference failed for: r4v9, types: [com.discord.widgets.user.search.WidgetGlobalSearchModel$sam$rx_functions_Func8$0] */
        private final Observable<WidgetGlobalSearchModel> get(Observable<String> filterPublisher, Function2<? super Channel, ? super Map<Long, Long>, Boolean> permissionsPredicate, Function1<? super ItemDataPayload, Boolean> resultsFilter, Function1<? super SearchContext, Long> lastChannelIdProvider) {
            ScalarSynchronousObservable scalarSynchronousObservable = new ScalarSynchronousObservable("");
            StoreStream.Companion companion = StoreStream.INSTANCE;
            Observable<List<Long>> observableObserveRecentSelectedGuildIds = companion.getGuildSelected().observeRecentSelectedGuildIds();
            Observable<Long> observableObserveId = companion.getChannelsSelected().observeId();
            Observable<Long> observableObservePreviousId = companion.getChannelsSelected().observePreviousId();
            Observable<Long> observableObserveSelectedVoiceChannelId = companion.getVoiceChannelSelected().observeSelectedVoiceChannelId();
            Observable<Map<Long, Long>> observableObserveRecentMessageIds = companion.getMessagesMostRecent().observeRecentMessageIds();
            TimeUnit timeUnit = TimeUnit.SECONDS;
            Observable observableLeadingEdgeThrottle = ObservableExtensionsKt.leadingEdgeThrottle(observableObserveRecentMessageIds, 10L, timeUnit);
            Observable<Map<Long, Integer>> observableObserveMentionCounts = companion.getMentions().observeMentionCounts();
            WidgetGlobalSearchModel$Companion$get$partialSearchContextObservable$1 widgetGlobalSearchModel$Companion$get$partialSearchContextObservable$1 = WidgetGlobalSearchModel$Companion$get$partialSearchContextObservable$1.INSTANCE;
            Object widgetGlobalSearchModel$sam$rx_functions_Func7$0 = widgetGlobalSearchModel$Companion$get$partialSearchContextObservable$1;
            if (widgetGlobalSearchModel$Companion$get$partialSearchContextObservable$1 != null) {
                widgetGlobalSearchModel$sam$rx_functions_Func7$0 = new WidgetGlobalSearchModel$sam$rx_functions_Func7$0(widgetGlobalSearchModel$Companion$get$partialSearchContextObservable$1);
            }
            Observable observableR = ObservableWithLeadingEdgeThrottle.combineLatest(scalarSynchronousObservable, observableObserveRecentSelectedGuildIds, observableObserveId, observableObservePreviousId, observableObserveSelectedVoiceChannelId, observableLeadingEdgeThrottle, observableObserveMentionCounts, (Func7) widgetGlobalSearchModel$sam$rx_functions_Func7$0, 2L, timeUnit).r();
            WidgetGlobalSearchModel$Companion$get$searchContextObservable$1 widgetGlobalSearchModel$Companion$get$searchContextObservable$1 = WidgetGlobalSearchModel$Companion$get$searchContextObservable$1.INSTANCE;
            TimeUnit timeUnit2 = TimeUnit.MILLISECONDS;
            Observable observableR2 = ObservableWithLeadingEdgeThrottle.combineLatest(filterPublisher, observableR, widgetGlobalSearchModel$Companion$get$searchContextObservable$1, 250L, timeUnit2).r();
            Observable<Map<Long, User>> observableObserveAllUsers = companion.getUsers().observeAllUsers();
            Observable<Map<Long, Presence>> observableObserveAllPresences = companion.getPresences().observeAllPresences();
            Observable<Map<Long, Integer>> observableObserve = companion.getUserRelationships().observe();
            Observable<Map<Long, Map<Long, GuildMember>>> observableObserveComputed = companion.getGuilds().observeComputed();
            WidgetGlobalSearchModel$Companion$get$usersContextObservable$1 widgetGlobalSearchModel$sam$rx_functions_Func4$0 = WidgetGlobalSearchModel$Companion$get$usersContextObservable$1.INSTANCE;
            if (widgetGlobalSearchModel$sam$rx_functions_Func4$0 != null) {
                widgetGlobalSearchModel$sam$rx_functions_Func4$0 = new WidgetGlobalSearchModel$sam$rx_functions_Func4$0(widgetGlobalSearchModel$sam$rx_functions_Func4$0);
            }
            Observable observableR3 = ObservableWithLeadingEdgeThrottle.combineLatest(observableObserveAllUsers, observableObserveAllPresences, observableObserve, observableObserveComputed, (Func4) widgetGlobalSearchModel$sam$rx_functions_Func4$0, 10L, timeUnit).r();
            Observable<Map<Long, Guild>> observableObserveGuilds = companion.getGuilds().observeGuilds();
            Observable<Map<Long, Channel>> observableObserveGuildAndPrivateChannels = companion.getChannels().observeGuildAndPrivateChannels();
            Observable<Map<Long, Channel>> observableObserveAllActiveJoinedThreadsChannelsById = companion.getThreadsActiveJoined().observeAllActiveJoinedThreadsChannelsById();
            Observable<Map<Long, Long>> observableObservePermissionsForAllChannels = companion.getPermissions().observePermissionsForAllChannels();
            Observable<Map<Long, Channel>> observableObservePrivateChannels = companion.getChannels().observePrivateChannels();
            Observable<Map<Long, List<Long>>> observableObserveIds = companion.getChannels().observeIds(true);
            Observable<Set<Long>> unreadChannelIds = companion.getReadStates().getUnreadChannelIds();
            Observable<Set<Long>> unreadGuildIds = companion.getReadStates().getUnreadGuildIds();
            WidgetGlobalSearchModel$Companion$get$channelContextObservable$1 widgetGlobalSearchModel$sam$rx_functions_Func8$0 = WidgetGlobalSearchModel$Companion$get$channelContextObservable$1.INSTANCE;
            if (widgetGlobalSearchModel$sam$rx_functions_Func8$0 != null) {
                widgetGlobalSearchModel$sam$rx_functions_Func8$0 = new WidgetGlobalSearchModel$sam$rx_functions_Func8$0(widgetGlobalSearchModel$sam$rx_functions_Func8$0);
            }
            Observable observableR4 = ObservableWithLeadingEdgeThrottle.combineLatest(observableObserveGuilds, observableObserveGuildAndPrivateChannels, observableObserveAllActiveJoinedThreadsChannelsById, observableObservePermissionsForAllChannels, observableObservePrivateChannels, observableObserveIds, unreadChannelIds, unreadGuildIds, (Func8) widgetGlobalSearchModel$sam$rx_functions_Func8$0, 3L, timeUnit).G(new WidgetGlobalSearchModel$Companion$get$channelContextObservable$2(permissionsPredicate)).r();
            Observable<WidgetGlobalSearchModel> observableR5 = ObservableWithLeadingEdgeThrottle.combineLatest(observableR2, observableR3, observableR4, ObservableWithLeadingEdgeThrottle.combineLatest(observableR2, observableR4, companion.getUserGuildSettings().observeGuildSettings(), companion.getGuildsSorted().observeOrderedGuilds(), WidgetGlobalSearchModel$Companion$get$guildsListObservable$1.INSTANCE, 5L, timeUnit).r(), new ScalarSynchronousObservable(resultsFilter), new ScalarSynchronousObservable(lastChannelIdProvider), new WidgetGlobalSearchModel$sam$rx_functions_Func6$0(new WidgetGlobalSearchModel$Companion$get$1(this)), 200L, timeUnit2).r();
            Intrinsics3.checkNotNullExpressionValue(observableR5, "ObservableWithLeadingEdg…  .distinctUntilChanged()");
            return observableR5;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Observable get$default(Companion companion, Observable observable, Function2 function2, Function1 function1, Function1 function12, int i, Object obj) {
            if ((i & 4) != 0) {
                function1 = null;
            }
            return companion.get(observable, function2, function1, function12);
        }

        private final Sequence<User> getDefaultUserSearch(SearchContext searchContext, ChannelContext channelContext, UsersContext usersContext, Set<Long> selectedGuildUserIds) {
            Sequence sequenceMapNotNull = _Sequences2.mapNotNull(getRecentChannelIds(searchContext), new WidgetGlobalSearchModel$Companion$getDefaultUserSearch$recentDmUserIds$1(channelContext));
            return _Sequences2.filterNot(_Sequences2.take(_Sequences2.mapNotNull(_Sequences2.distinct(_Sequences2.plus(_Sequences2.plus(sequenceMapNotNull, (Iterable) selectedGuildUserIds), n.flattenSequenceOfIterable(_Sequences2.mapNotNull(_Collections.asSequence(channelContext.getSmallGuildIds()), new WidgetGlobalSearchModel$Companion$getDefaultUserSearch$smallGuildUserIds$1(usersContext))))), new WidgetGlobalSearchModel$Companion$getDefaultUserSearch$1(usersContext)), 100), WidgetGlobalSearchModel$Companion$getDefaultUserSearch$2.INSTANCE);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Observable getForSend$default(Companion companion, Observable observable, Function1 function1, int i, Object obj) {
            if ((i & 2) != 0) {
                function1 = null;
            }
            return companion.getForSend(observable, function1);
        }

        private final Sequence<Long> getRecentChannelIds(SearchContext searchContext) {
            return searchContext.getFrecencyChannels().isEmpty() ^ true ? _Collections.asSequence(searchContext.getFrecencyChannels()) : _Sequences2.map(_Sequences2.take(_Collections.asSequence(_Collections.sortedWith(searchContext.getMostRecent().entrySet(), new WidgetGlobalSearchModel$Companion$getRecentChannelIds$$inlined$sortedBy$1())), 50), WidgetGlobalSearchModel$Companion$getRecentChannelIds$2.INSTANCE);
        }

        public final WidgetGlobalSearchModel create(SearchContext searchContext, UsersContext usersContext, ChannelContext channelContext, WidgetGlobalSearchGuildsModel widgetGuildsListModel, Function1<? super ItemDataPayload, Boolean> resultsFilter, Function1<? super SearchContext, Long> lastChannelIdProvider) {
            Set<Long> setEmptySet;
            Sequence sequenceMapNotNull;
            Sequence sequenceMapNotNull2;
            Intrinsics3.checkNotNullParameter(searchContext, "searchContext");
            Intrinsics3.checkNotNullParameter(usersContext, "usersContext");
            Intrinsics3.checkNotNullParameter(channelContext, "channelContext");
            Intrinsics3.checkNotNullParameter(widgetGuildsListModel, "widgetGuildsListModel");
            Intrinsics3.checkNotNullParameter(lastChannelIdProvider, "lastChannelIdProvider");
            WidgetGlobalSearchModel$Companion$create$2 widgetGlobalSearchModel$Companion$create$2 = new WidgetGlobalSearchModel$Companion$create$2(usersContext, searchContext, channelContext);
            WidgetGlobalSearchModel$Companion$create$3 widgetGlobalSearchModel$Companion$create$3 = new WidgetGlobalSearchModel$Companion$create$3(channelContext, searchContext);
            WidgetGlobalSearchModel$Companion$create$4 widgetGlobalSearchModel$Companion$create$4 = new WidgetGlobalSearchModel$Companion$create$4(channelContext, widgetGlobalSearchModel$Companion$create$2, searchContext);
            int searchType = searchContext.getSearchType();
            String sanitizedFilter = searchContext.getSanitizedFilter();
            Map<Long, GuildMember> map = usersContext.getMembers().get(_Collections.first((List) searchContext.getRecentGuildIds()));
            if (map == null || (setEmptySet = map.keySet()) == null) {
                setEmptySet = Sets5.emptySet();
            }
            Set<Long> set = setEmptySet;
            if (searchType != 1) {
                if (searchType == 2) {
                    sequenceMapNotNull2 = _Sequences2.mapNotNull(_Sequences2.filter(_Collections.asSequence(channelContext.getChannels().values()), WidgetGlobalSearchModel$Companion$create$filteredResults$3.INSTANCE), new WidgetGlobalSearchModel$Companion$create$filteredResults$4(widgetGlobalSearchModel$Companion$create$4, sanitizedFilter));
                } else if (searchType == 3) {
                    sequenceMapNotNull2 = _Sequences2.mapNotNull(_Collections.asSequence(channelContext.getGuilds().values()), new WidgetGlobalSearchModel$Companion$create$filteredResults$2(widgetGlobalSearchModel$Companion$create$3, sanitizedFilter));
                } else if (searchType == 4) {
                    sequenceMapNotNull2 = _Sequences2.sortedWith(_Sequences2.mapNotNull(_Sequences2.filter(_Sequences2.filter(_Collections.asSequence(channelContext.getChannels().values()), WidgetGlobalSearchModel$Companion$create$filteredResults$5.INSTANCE), new WidgetGlobalSearchModel$Companion$create$filteredResults$6(channelContext)), new WidgetGlobalSearchModel$Companion$create$filteredResults$7(widgetGlobalSearchModel$Companion$create$4, sanitizedFilter)), new WidgetGlobalSearchModel$Companion$create$$inlined$sortedBy$1(searchContext));
                } else if (StringsJVM.isBlank(sanitizedFilter)) {
                    sequenceMapNotNull2 = _Sequences2.mapNotNull(_Sequences2.filter(_Sequences2.mapNotNull(_Collections.asSequence(_Collections.union(searchContext.getMentionCounts().keySet(), _Sequences2.asIterable(getRecentChannelIds(searchContext)))), new WidgetGlobalSearchModel$Companion$create$filteredResults$9(channelContext)), WidgetGlobalSearchModel$Companion$create$filteredResults$10.INSTANCE), new WidgetGlobalSearchModel$Companion$create$filteredResults$11(widgetGlobalSearchModel$Companion$create$4, sanitizedFilter));
                } else {
                    HashSet hashSet = new HashSet();
                    sequenceMapNotNull2 = _Sequences2.plus(_Sequences2.mapNotNull(_Sequences2.filter(_Collections.asSequence(channelContext.getChannels().values()), WidgetGlobalSearchModel$Companion$create$filteredResults$channelResults$1.INSTANCE), new WidgetGlobalSearchModel$Companion$create$filteredResults$channelResults$2(hashSet, widgetGlobalSearchModel$Companion$create$2, usersContext, sanitizedFilter, widgetGlobalSearchModel$Companion$create$4)), _Sequences2.mapNotNull(_Sequences2.filterNot(_Collections.asSequence(set), new WidgetGlobalSearchModel$Companion$create$filteredResults$selectedGuildUserResults$1(hashSet)), new WidgetGlobalSearchModel$Companion$create$filteredResults$selectedGuildUserResults$2(widgetGlobalSearchModel$Companion$create$2, usersContext, sanitizedFilter)));
                }
                sequenceMapNotNull = sequenceMapNotNull2;
            } else {
                sequenceMapNotNull = _Sequences2.mapNotNull(StringsJVM.isBlank(sanitizedFilter) ? getDefaultUserSearch(searchContext, channelContext, usersContext, set) : _Collections.asSequence(usersContext.getUsers().values()), new WidgetGlobalSearchModel$Companion$create$filteredResults$1(widgetGlobalSearchModel$Companion$create$2, sanitizedFilter));
            }
            if (resultsFilter != null) {
                sequenceMapNotNull = _Sequences2.filter(sequenceMapNotNull, resultsFilter);
            }
            Sequence sequenceTake = _Sequences2.take(_Sequences2.sortedWith(sequenceMapNotNull, new WidgetGlobalSearchModel$Companion$create$$inlined$sortedByDescending$1(searchContext)), 50);
            if (searchType == 0 && StringsJVM.isBlank(searchContext.getFilter())) {
                Channel channel = channelContext.getChannels().get(lastChannelIdProvider.invoke(searchContext));
                ItemDataPayload itemDataPayloadInvoke2 = channel != null ? widgetGlobalSearchModel$Companion$create$4.invoke2(channel, "") : null;
                return new WidgetGlobalSearchModel(sanitizedFilter, searchType, _Sequences2.toList(itemDataPayloadInvoke2 == null ? _Sequences2.plus(n.sequenceOf(new ItemHeader(R.string.suggestions, 0, false, 6, null)), sequenceTake) : _Sequences2.plus(_Sequences2.plus(n.sequenceOf(new ItemHeader(R.string.quickswitcher_last_channel, 0, false, 6, null), itemDataPayloadInvoke2), n.sequenceOf(new ItemHeader(R.string.suggestions, 0, false, 6, null))), _Sequences2.filterNot(sequenceTake, new WidgetGlobalSearchModel$Companion$create$results$1(channel)))), widgetGuildsListModel.getItems());
            }
            if (_Sequences2.firstOrNull(sequenceTake) != null) {
                sequenceTake = _Sequences2.plus(n.sequenceOf(new ItemHeader(R.string.suggestions, 0, false, 6, null)), sequenceTake);
            }
            return new WidgetGlobalSearchModel(sanitizedFilter, searchType, _Sequences2.toList(sequenceTake), null, 8, null);
        }

        public final MatchedResult getEMPTY_MATCH_RESULT() {
            return new MatchedResult("", -1, 0);
        }

        public final Observable<WidgetGlobalSearchModel> getForNav(Observable<String> filterPublisher) {
            Intrinsics3.checkNotNullParameter(filterPublisher, "filterPublisher");
            return get$default(this, filterPublisher, WidgetGlobalSearchModel.access$getDEFAULT_PERMISSIONS_PREDICATE$cp(), null, WidgetGlobalSearchModel$Companion$getForNav$1.INSTANCE, 4, null);
        }

        public final Observable<WidgetGlobalSearchModel> getForSend(Observable<String> filterPublisher, Function1<? super ItemDataPayload, Boolean> resultsFilter) {
            Intrinsics3.checkNotNullParameter(filterPublisher, "filterPublisher");
            return get(filterPublisher, WidgetGlobalSearchModel$Companion$getForSend$1.INSTANCE, resultsFilter, WidgetGlobalSearchModel$Companion$getForSend$2.INSTANCE);
        }

        public final MatchedResult toFuzzyMatchedResult(String str, String str2) {
            Intrinsics3.checkNotNullParameter(str, "$this$toFuzzyMatchedResult");
            Intrinsics3.checkNotNullParameter(str2, "filter");
            SearchUtils searchUtils = SearchUtils.INSTANCE;
            Locale locale = Locale.ROOT;
            Intrinsics3.checkNotNullExpressionValue(locale, "Locale.ROOT");
            String lowerCase = str2.toLowerCase(locale);
            Intrinsics3.checkNotNullExpressionValue(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
            Intrinsics3.checkNotNullExpressionValue(locale, "Locale.ROOT");
            String lowerCase2 = str.toLowerCase(locale);
            Intrinsics3.checkNotNullExpressionValue(lowerCase2, "(this as java.lang.String).toLowerCase(locale)");
            if (searchUtils.fuzzyMatch(lowerCase, StringUtils2.stripAccents(lowerCase2))) {
                return new MatchedResult(str, -1, str2.length());
            }
            return null;
        }

        public final MatchedResult toMatchedResult(String str, String str2) {
            Intrinsics3.checkNotNullParameter(str, "$this$toMatchedResult");
            Intrinsics3.checkNotNullParameter(str2, "filter");
            int iIndexOf$default = Strings4.indexOf$default((CharSequence) str, str2, 0, true, 2, (Object) null);
            if (iIndexOf$default != -1) {
                return new MatchedResult(str, iIndexOf$default, str2.length());
            }
            return null;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetGlobalSearchModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004R\u0016\u0010\t\u001a\u00020\u00068&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\r\u001a\u00020\n8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u0011\u001a\u00020\u000e8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0012"}, d2 = {"Lcom/discord/widgets/user/search/WidgetGlobalSearchModel$ItemDataPayload;", "Lcom/discord/utilities/mg_recycler/MGRecyclerDataPayload;", "Lcom/discord/api/channel/Channel;", "getChannel", "()Lcom/discord/api/channel/Channel;", "channel", "Lcom/discord/widgets/user/search/WidgetGlobalSearchModel$MatchedResult;", "getMatchedResult", "()Lcom/discord/widgets/user/search/WidgetGlobalSearchModel$MatchedResult;", "matchedResult", "", "getMentions", "()I", "mentions", "", "getUnread", "()Z", "unread", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public interface ItemDataPayload extends MGRecyclerDataPayload {
        Channel getChannel();

        MatchedResult getMatchedResult();

        int getMentions();

        boolean getUnread();
    }

    /* compiled from: WidgetGlobalSearchModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\u0006\u0010\n\u001a\u00020\u0005\u0012\u0006\u0010\u000b\u001a\u00020\u0005¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\b\u0010\u0007J.\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\t\u001a\u00020\u00022\b\b\u0002\u0010\n\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0007J\u001a\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015R\u0019\u0010\t\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\u0016\u001a\u0004\b\u0017\u0010\u0004R\u0019\u0010\n\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\n\u0010\u0018\u001a\u0004\b\u0019\u0010\u0007R\u0019\u0010\u000b\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u0018\u001a\u0004\b\u001a\u0010\u0007¨\u0006\u001d"}, d2 = {"Lcom/discord/widgets/user/search/WidgetGlobalSearchModel$MatchedResult;", "", "", "component1", "()Ljava/lang/CharSequence;", "", "component2", "()I", "component3", "value", "firstMatchIndex", "filterLength", "copy", "(Ljava/lang/CharSequence;II)Lcom/discord/widgets/user/search/WidgetGlobalSearchModel$MatchedResult;", "", "toString", "()Ljava/lang/String;", "hashCode", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/CharSequence;", "getValue", "I", "getFirstMatchIndex", "getFilterLength", "<init>", "(Ljava/lang/CharSequence;II)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class MatchedResult {
        private final int filterLength;
        private final int firstMatchIndex;
        private final CharSequence value;

        public MatchedResult(CharSequence charSequence, int i, int i2) {
            Intrinsics3.checkNotNullParameter(charSequence, "value");
            this.value = charSequence;
            this.firstMatchIndex = i;
            this.filterLength = i2;
        }

        public static /* synthetic */ MatchedResult copy$default(MatchedResult matchedResult, CharSequence charSequence, int i, int i2, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                charSequence = matchedResult.value;
            }
            if ((i3 & 2) != 0) {
                i = matchedResult.firstMatchIndex;
            }
            if ((i3 & 4) != 0) {
                i2 = matchedResult.filterLength;
            }
            return matchedResult.copy(charSequence, i, i2);
        }

        /* renamed from: component1, reason: from getter */
        public final CharSequence getValue() {
            return this.value;
        }

        /* renamed from: component2, reason: from getter */
        public final int getFirstMatchIndex() {
            return this.firstMatchIndex;
        }

        /* renamed from: component3, reason: from getter */
        public final int getFilterLength() {
            return this.filterLength;
        }

        public final MatchedResult copy(CharSequence value, int firstMatchIndex, int filterLength) {
            Intrinsics3.checkNotNullParameter(value, "value");
            return new MatchedResult(value, firstMatchIndex, filterLength);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof MatchedResult)) {
                return false;
            }
            MatchedResult matchedResult = (MatchedResult) other;
            return Intrinsics3.areEqual(this.value, matchedResult.value) && this.firstMatchIndex == matchedResult.firstMatchIndex && this.filterLength == matchedResult.filterLength;
        }

        public final int getFilterLength() {
            return this.filterLength;
        }

        public final int getFirstMatchIndex() {
            return this.firstMatchIndex;
        }

        public final CharSequence getValue() {
            return this.value;
        }

        public int hashCode() {
            CharSequence charSequence = this.value;
            return ((((charSequence != null ? charSequence.hashCode() : 0) * 31) + this.firstMatchIndex) * 31) + this.filterLength;
        }

        public String toString() {
            StringBuilder sbU = outline.U("MatchedResult(value=");
            sbU.append(this.value);
            sbU.append(", firstMatchIndex=");
            sbU.append(this.firstMatchIndex);
            sbU.append(", filterLength=");
            return outline.B(sbU, this.filterLength, ")");
        }
    }

    /* compiled from: WidgetGlobalSearchModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\u001e\n\u0002\b\u000f\b\u0086\b\u0018\u00002\u00020\u0001By\u0012\u0006\u0010\u0015\u001a\u00020\u0002\u0012\u0010\u0010\u0016\u001a\f\u0012\b\u0012\u00060\u0006j\u0002`\u00070\u0005\u0012\n\u0010\u0017\u001a\u00060\u0006j\u0002`\n\u0012\n\u0010\u0018\u001a\u00060\u0006j\u0002`\n\u0012\n\u0010\u0019\u001a\u00060\u0006j\u0002`\n\u0012\u001a\u0010\u001a\u001a\u0016\u0012\b\u0012\u00060\u0006j\u0002`\n\u0012\b\u0012\u00060\u0006j\u0002`\u00100\u000f\u0012\u0016\u0010\u001b\u001a\u0012\u0012\b\u0012\u00060\u0006j\u0002`\n\u0012\u0004\u0012\u00020\u00130\u000f¢\u0006\u0004\b>\u0010?J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\b\u001a\f\u0012\b\u0012\u00060\u0006j\u0002`\u00070\u0005HÆ\u0003¢\u0006\u0004\b\b\u0010\tJ\u0014\u0010\u000b\u001a\u00060\u0006j\u0002`\nHÆ\u0003¢\u0006\u0004\b\u000b\u0010\fJ\u0014\u0010\r\u001a\u00060\u0006j\u0002`\nHÆ\u0003¢\u0006\u0004\b\r\u0010\fJ\u0014\u0010\u000e\u001a\u00060\u0006j\u0002`\nHÆ\u0003¢\u0006\u0004\b\u000e\u0010\fJ$\u0010\u0011\u001a\u0016\u0012\b\u0012\u00060\u0006j\u0002`\n\u0012\b\u0012\u00060\u0006j\u0002`\u00100\u000fHÆ\u0003¢\u0006\u0004\b\u0011\u0010\u0012J \u0010\u0014\u001a\u0012\u0012\b\u0012\u00060\u0006j\u0002`\n\u0012\u0004\u0012\u00020\u00130\u000fHÆ\u0003¢\u0006\u0004\b\u0014\u0010\u0012J\u0090\u0001\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0015\u001a\u00020\u00022\u0012\b\u0002\u0010\u0016\u001a\f\u0012\b\u0012\u00060\u0006j\u0002`\u00070\u00052\f\b\u0002\u0010\u0017\u001a\u00060\u0006j\u0002`\n2\f\b\u0002\u0010\u0018\u001a\u00060\u0006j\u0002`\n2\f\b\u0002\u0010\u0019\u001a\u00060\u0006j\u0002`\n2\u001c\b\u0002\u0010\u001a\u001a\u0016\u0012\b\u0012\u00060\u0006j\u0002`\n\u0012\b\u0012\u00060\u0006j\u0002`\u00100\u000f2\u0018\b\u0002\u0010\u001b\u001a\u0012\u0012\b\u0012\u00060\u0006j\u0002`\n\u0012\u0004\u0012\u00020\u00130\u000fHÆ\u0001¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u001e\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u001e\u0010\u0004J\u0010\u0010\u001f\u001a\u00020\u0013HÖ\u0001¢\u0006\u0004\b\u001f\u0010 J\u001a\u0010#\u001a\u00020\"2\b\u0010!\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b#\u0010$R\u001d\u0010\u0017\u001a\u00060\u0006j\u0002`\n8\u0006@\u0006¢\u0006\f\n\u0004\b\u0017\u0010%\u001a\u0004\b&\u0010\fR)\u0010\u001b\u001a\u0012\u0012\b\u0012\u00060\u0006j\u0002`\n\u0012\u0004\u0012\u00020\u00130\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b\u001b\u0010'\u001a\u0004\b(\u0010\u0012R#\u0010\u0016\u001a\f\u0012\b\u0012\u00060\u0006j\u0002`\u00070\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0016\u0010)\u001a\u0004\b*\u0010\tR\u0019\u0010+\u001a\u00020\"8\u0006@\u0006¢\u0006\f\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.R\u001d\u0010\u0019\u001a\u00060\u0006j\u0002`\n8\u0006@\u0006¢\u0006\f\n\u0004\b\u0019\u0010%\u001a\u0004\b/\u0010\fR-\u0010\u001a\u001a\u0016\u0012\b\u0012\u00060\u0006j\u0002`\n\u0012\b\u0012\u00060\u0006j\u0002`\u00100\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b\u001a\u0010'\u001a\u0004\b0\u0010\u0012R#\u00102\u001a\f\u0012\b\u0012\u00060\u0006j\u0002`\n018\u0006@\u0006¢\u0006\f\n\u0004\b2\u00103\u001a\u0004\b4\u00105R\u001d\u0010\u0018\u001a\u00060\u0006j\u0002`\n8\u0006@\u0006¢\u0006\f\n\u0004\b\u0018\u0010%\u001a\u0004\b6\u0010\fR\u0019\u00107\u001a\u00020\u00138\u0006@\u0006¢\u0006\f\n\u0004\b7\u00108\u001a\u0004\b9\u0010 R\u0019\u0010\u0015\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0015\u0010:\u001a\u0004\b;\u0010\u0004R\u0019\u0010<\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b<\u0010:\u001a\u0004\b=\u0010\u0004¨\u0006@"}, d2 = {"Lcom/discord/widgets/user/search/WidgetGlobalSearchModel$SearchContext;", "", "", "component1", "()Ljava/lang/String;", "", "", "Lcom/discord/primitives/GuildId;", "component2", "()Ljava/util/List;", "Lcom/discord/primitives/ChannelId;", "component3", "()J", "component4", "component5", "", "Lcom/discord/primitives/MessageId;", "component6", "()Ljava/util/Map;", "", "component7", "filter", "recentGuildIds", "selectedChannelId", "prevSelectedChannelId", "selectedVoiceChannelId", "mostRecent", "mentionCounts", "copy", "(Ljava/lang/String;Ljava/util/List;JJJLjava/util/Map;Ljava/util/Map;)Lcom/discord/widgets/user/search/WidgetGlobalSearchModel$SearchContext;", "toString", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "J", "getSelectedChannelId", "Ljava/util/Map;", "getMentionCounts", "Ljava/util/List;", "getRecentGuildIds", "hasDiscriminator", "Z", "getHasDiscriminator", "()Z", "getSelectedVoiceChannelId", "getMostRecent", "", "frecencyChannels", "Ljava/util/Collection;", "getFrecencyChannels", "()Ljava/util/Collection;", "getPrevSelectedChannelId", "searchType", "I", "getSearchType", "Ljava/lang/String;", "getFilter", "sanitizedFilter", "getSanitizedFilter", "<init>", "(Ljava/lang/String;Ljava/util/List;JJJLjava/util/Map;Ljava/util/Map;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class SearchContext {
        private final String filter;
        private final Collection<Long> frecencyChannels;
        private final boolean hasDiscriminator;
        private final Map<Long, Integer> mentionCounts;
        private final Map<Long, Long> mostRecent;
        private final long prevSelectedChannelId;
        private final List<Long> recentGuildIds;
        private final String sanitizedFilter;
        private final int searchType;
        private final long selectedChannelId;
        private final long selectedVoiceChannelId;

        public SearchContext(String str, List<Long> list, long j, long j2, long j3, Map<Long, Long> map, Map<Long, Integer> map2) {
            String strSubstring;
            Intrinsics3.checkNotNullParameter(str, "filter");
            Intrinsics3.checkNotNullParameter(list, "recentGuildIds");
            Intrinsics3.checkNotNullParameter(map, "mostRecent");
            Intrinsics3.checkNotNullParameter(map2, "mentionCounts");
            this.filter = str;
            this.recentGuildIds = list;
            this.selectedChannelId = j;
            this.prevSelectedChannelId = j2;
            this.selectedVoiceChannelId = j3;
            this.mostRecent = map;
            this.mentionCounts = map2;
            this.frecencyChannels = FrecencyTracker.getSortedKeys$default(StoreStream.INSTANCE.getChannelsSelected().getFrecency(), 0L, 1, null);
            Character chFirstOrNull = _Strings.firstOrNull(str);
            int i = (chFirstOrNull != null && chFirstOrNull.charValue() == '@') ? 1 : (chFirstOrNull != null && chFirstOrNull.charValue() == '#') ? 2 : (chFirstOrNull != null && chFirstOrNull.charValue() == '!') ? 4 : (chFirstOrNull != null && chFirstOrNull.charValue() == '*') ? 3 : 0;
            this.searchType = i;
            if (i != 0) {
                Objects.requireNonNull(str, "null cannot be cast to non-null type java.lang.String");
                strSubstring = str.substring(1);
                Intrinsics3.checkNotNullExpressionValue(strSubstring, "(this as java.lang.String).substring(startIndex)");
            } else {
                strSubstring = str;
            }
            this.sanitizedFilter = strSubstring;
            this.hasDiscriminator = (i == 0 || i == 1) ? WidgetGlobalSearchModel.access$getDISCRIMINATOR_PATTERN$cp().matcher(str).find() : false;
        }

        public static /* synthetic */ SearchContext copy$default(SearchContext searchContext, String str, List list, long j, long j2, long j3, Map map, Map map2, int i, Object obj) {
            return searchContext.copy((i & 1) != 0 ? searchContext.filter : str, (i & 2) != 0 ? searchContext.recentGuildIds : list, (i & 4) != 0 ? searchContext.selectedChannelId : j, (i & 8) != 0 ? searchContext.prevSelectedChannelId : j2, (i & 16) != 0 ? searchContext.selectedVoiceChannelId : j3, (i & 32) != 0 ? searchContext.mostRecent : map, (i & 64) != 0 ? searchContext.mentionCounts : map2);
        }

        /* renamed from: component1, reason: from getter */
        public final String getFilter() {
            return this.filter;
        }

        public final List<Long> component2() {
            return this.recentGuildIds;
        }

        /* renamed from: component3, reason: from getter */
        public final long getSelectedChannelId() {
            return this.selectedChannelId;
        }

        /* renamed from: component4, reason: from getter */
        public final long getPrevSelectedChannelId() {
            return this.prevSelectedChannelId;
        }

        /* renamed from: component5, reason: from getter */
        public final long getSelectedVoiceChannelId() {
            return this.selectedVoiceChannelId;
        }

        public final Map<Long, Long> component6() {
            return this.mostRecent;
        }

        public final Map<Long, Integer> component7() {
            return this.mentionCounts;
        }

        public final SearchContext copy(String filter, List<Long> recentGuildIds, long selectedChannelId, long prevSelectedChannelId, long selectedVoiceChannelId, Map<Long, Long> mostRecent, Map<Long, Integer> mentionCounts) {
            Intrinsics3.checkNotNullParameter(filter, "filter");
            Intrinsics3.checkNotNullParameter(recentGuildIds, "recentGuildIds");
            Intrinsics3.checkNotNullParameter(mostRecent, "mostRecent");
            Intrinsics3.checkNotNullParameter(mentionCounts, "mentionCounts");
            return new SearchContext(filter, recentGuildIds, selectedChannelId, prevSelectedChannelId, selectedVoiceChannelId, mostRecent, mentionCounts);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof SearchContext)) {
                return false;
            }
            SearchContext searchContext = (SearchContext) other;
            return Intrinsics3.areEqual(this.filter, searchContext.filter) && Intrinsics3.areEqual(this.recentGuildIds, searchContext.recentGuildIds) && this.selectedChannelId == searchContext.selectedChannelId && this.prevSelectedChannelId == searchContext.prevSelectedChannelId && this.selectedVoiceChannelId == searchContext.selectedVoiceChannelId && Intrinsics3.areEqual(this.mostRecent, searchContext.mostRecent) && Intrinsics3.areEqual(this.mentionCounts, searchContext.mentionCounts);
        }

        public final String getFilter() {
            return this.filter;
        }

        public final Collection<Long> getFrecencyChannels() {
            return this.frecencyChannels;
        }

        public final boolean getHasDiscriminator() {
            return this.hasDiscriminator;
        }

        public final Map<Long, Integer> getMentionCounts() {
            return this.mentionCounts;
        }

        public final Map<Long, Long> getMostRecent() {
            return this.mostRecent;
        }

        public final long getPrevSelectedChannelId() {
            return this.prevSelectedChannelId;
        }

        public final List<Long> getRecentGuildIds() {
            return this.recentGuildIds;
        }

        public final String getSanitizedFilter() {
            return this.sanitizedFilter;
        }

        public final int getSearchType() {
            return this.searchType;
        }

        public final long getSelectedChannelId() {
            return this.selectedChannelId;
        }

        public final long getSelectedVoiceChannelId() {
            return this.selectedVoiceChannelId;
        }

        public int hashCode() {
            String str = this.filter;
            int iHashCode = (str != null ? str.hashCode() : 0) * 31;
            List<Long> list = this.recentGuildIds;
            int iA = (b.a(this.selectedVoiceChannelId) + ((b.a(this.prevSelectedChannelId) + ((b.a(this.selectedChannelId) + ((iHashCode + (list != null ? list.hashCode() : 0)) * 31)) * 31)) * 31)) * 31;
            Map<Long, Long> map = this.mostRecent;
            int iHashCode2 = (iA + (map != null ? map.hashCode() : 0)) * 31;
            Map<Long, Integer> map2 = this.mentionCounts;
            return iHashCode2 + (map2 != null ? map2.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbU = outline.U("SearchContext(filter=");
            sbU.append(this.filter);
            sbU.append(", recentGuildIds=");
            sbU.append(this.recentGuildIds);
            sbU.append(", selectedChannelId=");
            sbU.append(this.selectedChannelId);
            sbU.append(", prevSelectedChannelId=");
            sbU.append(this.prevSelectedChannelId);
            sbU.append(", selectedVoiceChannelId=");
            sbU.append(this.selectedVoiceChannelId);
            sbU.append(", mostRecent=");
            sbU.append(this.mostRecent);
            sbU.append(", mentionCounts=");
            return outline.M(sbU, this.mentionCounts, ")");
        }
    }

    /* compiled from: WidgetGlobalSearchModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001Bw\u0012\u0016\u0010\u000f\u001a\u0012\u0012\b\u0012\u00060\u0003j\u0002`\u0004\u0012\u0004\u0012\u00020\u00050\u0002\u0012\u0016\u0010\u0010\u001a\u0012\u0012\b\u0012\u00060\u0003j\u0002`\u0004\u0012\u0004\u0012\u00020\b0\u0002\u0012\u0016\u0010\u0011\u001a\u0012\u0012\b\u0012\u00060\u0003j\u0002`\u0004\u0012\u0004\u0012\u00020\n0\u0002\u0012&\u0010\u0012\u001a\"\u0012\b\u0012\u00060\u0003j\u0002`\f\u0012\u0014\u0012\u0012\u0012\b\u0012\u00060\u0003j\u0002`\u0004\u0012\u0004\u0012\u00020\r0\u00020\u0002¢\u0006\u0004\b#\u0010$J \u0010\u0006\u001a\u0012\u0012\b\u0012\u00060\u0003j\u0002`\u0004\u0012\u0004\u0012\u00020\u00050\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J \u0010\t\u001a\u0012\u0012\b\u0012\u00060\u0003j\u0002`\u0004\u0012\u0004\u0012\u00020\b0\u0002HÆ\u0003¢\u0006\u0004\b\t\u0010\u0007J \u0010\u000b\u001a\u0012\u0012\b\u0012\u00060\u0003j\u0002`\u0004\u0012\u0004\u0012\u00020\n0\u0002HÆ\u0003¢\u0006\u0004\b\u000b\u0010\u0007J0\u0010\u000e\u001a\"\u0012\b\u0012\u00060\u0003j\u0002`\f\u0012\u0014\u0012\u0012\u0012\b\u0012\u00060\u0003j\u0002`\u0004\u0012\u0004\u0012\u00020\r0\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u000e\u0010\u0007J\u0088\u0001\u0010\u0013\u001a\u00020\u00002\u0018\b\u0002\u0010\u000f\u001a\u0012\u0012\b\u0012\u00060\u0003j\u0002`\u0004\u0012\u0004\u0012\u00020\u00050\u00022\u0018\b\u0002\u0010\u0010\u001a\u0012\u0012\b\u0012\u00060\u0003j\u0002`\u0004\u0012\u0004\u0012\u00020\b0\u00022\u0018\b\u0002\u0010\u0011\u001a\u0012\u0012\b\u0012\u00060\u0003j\u0002`\u0004\u0012\u0004\u0012\u00020\n0\u00022(\b\u0002\u0010\u0012\u001a\"\u0012\b\u0012\u00060\u0003j\u0002`\f\u0012\u0014\u0012\u0012\u0012\b\u0012\u00060\u0003j\u0002`\u0004\u0012\u0004\u0012\u00020\r0\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0016\u001a\u00020\u0015HÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0018\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u0018\u0010\u0019J\u001a\u0010\u001c\u001a\u00020\u001b2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001c\u0010\u001dR)\u0010\u000f\u001a\u0012\u0012\b\u0012\u00060\u0003j\u0002`\u0004\u0012\u0004\u0012\u00020\u00050\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u001e\u001a\u0004\b\u001f\u0010\u0007R)\u0010\u0010\u001a\u0012\u0012\b\u0012\u00060\u0003j\u0002`\u0004\u0012\u0004\u0012\u00020\b0\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u001e\u001a\u0004\b \u0010\u0007R9\u0010\u0012\u001a\"\u0012\b\u0012\u00060\u0003j\u0002`\f\u0012\u0014\u0012\u0012\u0012\b\u0012\u00060\u0003j\u0002`\u0004\u0012\u0004\u0012\u00020\r0\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u001e\u001a\u0004\b!\u0010\u0007R)\u0010\u0011\u001a\u0012\u0012\b\u0012\u00060\u0003j\u0002`\u0004\u0012\u0004\u0012\u00020\n0\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u001e\u001a\u0004\b\"\u0010\u0007¨\u0006%"}, d2 = {"Lcom/discord/widgets/user/search/WidgetGlobalSearchModel$UsersContext;", "", "", "", "Lcom/discord/primitives/UserId;", "Lcom/discord/models/user/User;", "component1", "()Ljava/util/Map;", "Lcom/discord/models/presence/Presence;", "component2", "", "component3", "Lcom/discord/primitives/GuildId;", "Lcom/discord/models/member/GuildMember;", "component4", "users", "presences", "relationships", "members", "copy", "(Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;)Lcom/discord/widgets/user/search/WidgetGlobalSearchModel$UsersContext;", "", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/util/Map;", "getUsers", "getPresences", "getMembers", "getRelationships", "<init>", "(Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class UsersContext {
        private final Map<Long, Map<Long, GuildMember>> members;
        private final Map<Long, Presence> presences;
        private final Map<Long, Integer> relationships;
        private final Map<Long, User> users;

        /* JADX WARN: Multi-variable type inference failed */
        public UsersContext(Map<Long, ? extends User> map, Map<Long, Presence> map2, Map<Long, Integer> map3, Map<Long, ? extends Map<Long, GuildMember>> map4) {
            Intrinsics3.checkNotNullParameter(map, "users");
            Intrinsics3.checkNotNullParameter(map2, "presences");
            Intrinsics3.checkNotNullParameter(map3, "relationships");
            Intrinsics3.checkNotNullParameter(map4, "members");
            this.users = map;
            this.presences = map2;
            this.relationships = map3;
            this.members = map4;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ UsersContext copy$default(UsersContext usersContext, Map map, Map map2, Map map3, Map map4, int i, Object obj) {
            if ((i & 1) != 0) {
                map = usersContext.users;
            }
            if ((i & 2) != 0) {
                map2 = usersContext.presences;
            }
            if ((i & 4) != 0) {
                map3 = usersContext.relationships;
            }
            if ((i & 8) != 0) {
                map4 = usersContext.members;
            }
            return usersContext.copy(map, map2, map3, map4);
        }

        public final Map<Long, User> component1() {
            return this.users;
        }

        public final Map<Long, Presence> component2() {
            return this.presences;
        }

        public final Map<Long, Integer> component3() {
            return this.relationships;
        }

        public final Map<Long, Map<Long, GuildMember>> component4() {
            return this.members;
        }

        public final UsersContext copy(Map<Long, ? extends User> users, Map<Long, Presence> presences, Map<Long, Integer> relationships, Map<Long, ? extends Map<Long, GuildMember>> members) {
            Intrinsics3.checkNotNullParameter(users, "users");
            Intrinsics3.checkNotNullParameter(presences, "presences");
            Intrinsics3.checkNotNullParameter(relationships, "relationships");
            Intrinsics3.checkNotNullParameter(members, "members");
            return new UsersContext(users, presences, relationships, members);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof UsersContext)) {
                return false;
            }
            UsersContext usersContext = (UsersContext) other;
            return Intrinsics3.areEqual(this.users, usersContext.users) && Intrinsics3.areEqual(this.presences, usersContext.presences) && Intrinsics3.areEqual(this.relationships, usersContext.relationships) && Intrinsics3.areEqual(this.members, usersContext.members);
        }

        public final Map<Long, Map<Long, GuildMember>> getMembers() {
            return this.members;
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
            Map<Long, User> map = this.users;
            int iHashCode = (map != null ? map.hashCode() : 0) * 31;
            Map<Long, Presence> map2 = this.presences;
            int iHashCode2 = (iHashCode + (map2 != null ? map2.hashCode() : 0)) * 31;
            Map<Long, Integer> map3 = this.relationships;
            int iHashCode3 = (iHashCode2 + (map3 != null ? map3.hashCode() : 0)) * 31;
            Map<Long, Map<Long, GuildMember>> map4 = this.members;
            return iHashCode3 + (map4 != null ? map4.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbU = outline.U("UsersContext(users=");
            sbU.append(this.users);
            sbU.append(", presences=");
            sbU.append(this.presences);
            sbU.append(", relationships=");
            sbU.append(this.relationships);
            sbU.append(", members=");
            return outline.M(sbU, this.members, ")");
        }
    }

    static {
        Pattern patternCompile = Pattern.compile("[^\\s]#\\d{0,4}$", 0);
        Intrinsics3.checkNotNullExpressionValue(patternCompile, "java.util.regex.Pattern.compile(this, flags)");
        DISCRIMINATOR_PATTERN = patternCompile;
        DEFAULT_PERMISSIONS_PREDICATE = WidgetGlobalSearchModel$Companion$DEFAULT_PERMISSIONS_PREDICATE$1.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public WidgetGlobalSearchModel(String str, int i, List<? extends ItemDataPayload> list, List<WidgetGlobalSearchGuildsModel.Item> list2) {
        Intrinsics3.checkNotNullParameter(str, "filter");
        Intrinsics3.checkNotNullParameter(list, "data");
        this.filter = str;
        this.searchType = i;
        this.data = list;
        this.guildsList = list2;
    }

    public static final /* synthetic */ Function2 access$getDEFAULT_PERMISSIONS_PREDICATE$cp() {
        return DEFAULT_PERMISSIONS_PREDICATE;
    }

    public static final /* synthetic */ Pattern access$getDISCRIMINATOR_PATTERN$cp() {
        return DISCRIMINATOR_PATTERN;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ WidgetGlobalSearchModel copy$default(WidgetGlobalSearchModel widgetGlobalSearchModel, String str, int i, List list, List list2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = widgetGlobalSearchModel.filter;
        }
        if ((i2 & 2) != 0) {
            i = widgetGlobalSearchModel.searchType;
        }
        if ((i2 & 4) != 0) {
            list = widgetGlobalSearchModel.data;
        }
        if ((i2 & 8) != 0) {
            list2 = widgetGlobalSearchModel.guildsList;
        }
        return widgetGlobalSearchModel.copy(str, i, list, list2);
    }

    /* renamed from: component1, reason: from getter */
    public final String getFilter() {
        return this.filter;
    }

    /* renamed from: component2, reason: from getter */
    public final int getSearchType() {
        return this.searchType;
    }

    public final List<ItemDataPayload> component3() {
        return this.data;
    }

    public final List<WidgetGlobalSearchGuildsModel.Item> component4() {
        return this.guildsList;
    }

    public final WidgetGlobalSearchModel copy(String filter, int searchType, List<? extends ItemDataPayload> data, List<WidgetGlobalSearchGuildsModel.Item> guildsList) {
        Intrinsics3.checkNotNullParameter(filter, "filter");
        Intrinsics3.checkNotNullParameter(data, "data");
        return new WidgetGlobalSearchModel(filter, searchType, data, guildsList);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WidgetGlobalSearchModel)) {
            return false;
        }
        WidgetGlobalSearchModel widgetGlobalSearchModel = (WidgetGlobalSearchModel) other;
        return Intrinsics3.areEqual(this.filter, widgetGlobalSearchModel.filter) && this.searchType == widgetGlobalSearchModel.searchType && Intrinsics3.areEqual(this.data, widgetGlobalSearchModel.data) && Intrinsics3.areEqual(this.guildsList, widgetGlobalSearchModel.guildsList);
    }

    public final List<ItemDataPayload> getData() {
        return this.data;
    }

    public final String getFilter() {
        return this.filter;
    }

    public final List<WidgetGlobalSearchGuildsModel.Item> getGuildsList() {
        return this.guildsList;
    }

    public final int getSearchType() {
        return this.searchType;
    }

    public int hashCode() {
        String str = this.filter;
        int iHashCode = (((str != null ? str.hashCode() : 0) * 31) + this.searchType) * 31;
        List<ItemDataPayload> list = this.data;
        int iHashCode2 = (iHashCode + (list != null ? list.hashCode() : 0)) * 31;
        List<WidgetGlobalSearchGuildsModel.Item> list2 = this.guildsList;
        return iHashCode2 + (list2 != null ? list2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("WidgetGlobalSearchModel(filter=");
        sbU.append(this.filter);
        sbU.append(", searchType=");
        sbU.append(this.searchType);
        sbU.append(", data=");
        sbU.append(this.data);
        sbU.append(", guildsList=");
        return outline.L(sbU, this.guildsList, ")");
    }

    /* compiled from: WidgetGlobalSearchModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\u0000\n\u0002\b\u0016\b\u0086\b\u0018\u00002\u00020\u0001B?\u0012\u0006\u0010\u0015\u001a\u00020\u0005\u0012\u0006\u0010\u0016\u001a\u00020\b\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\b\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\f\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0012¢\u0006\u0004\b2\u00103J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0012\u0010\u000b\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0004\b\u000b\u0010\nJ\u0012\u0010\r\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÆ\u0003¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0013\u001a\u00020\u0012HÆ\u0003¢\u0006\u0004\b\u0013\u0010\u0014JP\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0015\u001a\u00020\u00052\b\b\u0002\u0010\u0016\u001a\u00020\b2\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\f2\b\b\u0002\u0010\u0019\u001a\u00020\u000f2\b\b\u0002\u0010\u001a\u001a\u00020\u0012HÆ\u0001¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u001d\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u001d\u0010\u0011J\u001a\u0010 \u001a\u00020\u00122\b\u0010\u001f\u001a\u0004\u0018\u00010\u001eHÖ\u0003¢\u0006\u0004\b \u0010!R\u001c\u0010\u0019\u001a\u00020\u000f8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0019\u0010\"\u001a\u0004\b#\u0010\u0011R\u001b\u0010\u0017\u001a\u0004\u0018\u00010\b8\u0006@\u0006¢\u0006\f\n\u0004\b\u0017\u0010$\u001a\u0004\b%\u0010\nR\u001b\u0010\u0018\u001a\u0004\u0018\u00010\f8\u0006@\u0006¢\u0006\f\n\u0004\b\u0018\u0010&\u001a\u0004\b'\u0010\u000eR\u001c\u0010(\u001a\u00020\u00028\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b(\u0010)\u001a\u0004\b*\u0010\u0004R\u001c\u0010\u0016\u001a\u00020\b8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0016\u0010$\u001a\u0004\b+\u0010\nR\u001c\u0010\u001a\u001a\u00020\u00128\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u001a\u0010,\u001a\u0004\b-\u0010\u0014R\u001c\u0010\u0015\u001a\u00020\u00058\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0015\u0010.\u001a\u0004\b/\u0010\u0007R\u001c\u00100\u001a\u00020\u000f8\u0016@\u0016X\u0096D¢\u0006\f\n\u0004\b0\u0010\"\u001a\u0004\b1\u0010\u0011¨\u00064"}, d2 = {"Lcom/discord/widgets/user/search/WidgetGlobalSearchModel$ItemChannel;", "Lcom/discord/widgets/user/search/WidgetGlobalSearchModel$ItemDataPayload;", "", "toString", "()Ljava/lang/String;", "Lcom/discord/widgets/user/search/WidgetGlobalSearchModel$MatchedResult;", "component1", "()Lcom/discord/widgets/user/search/WidgetGlobalSearchModel$MatchedResult;", "Lcom/discord/api/channel/Channel;", "component2", "()Lcom/discord/api/channel/Channel;", "component3", "Lcom/discord/models/guild/Guild;", "component4", "()Lcom/discord/models/guild/Guild;", "", "component5", "()I", "", "component6", "()Z", "matchedResult", "channel", "parentChannel", "guild", "mentions", "unread", "copy", "(Lcom/discord/widgets/user/search/WidgetGlobalSearchModel$MatchedResult;Lcom/discord/api/channel/Channel;Lcom/discord/api/channel/Channel;Lcom/discord/models/guild/Guild;IZ)Lcom/discord/widgets/user/search/WidgetGlobalSearchModel$ItemChannel;", "hashCode", "", "other", "equals", "(Ljava/lang/Object;)Z", "I", "getMentions", "Lcom/discord/api/channel/Channel;", "getParentChannel", "Lcom/discord/models/guild/Guild;", "getGuild", "key", "Ljava/lang/String;", "getKey", "getChannel", "Z", "getUnread", "Lcom/discord/widgets/user/search/WidgetGlobalSearchModel$MatchedResult;", "getMatchedResult", "type", "getType", "<init>", "(Lcom/discord/widgets/user/search/WidgetGlobalSearchModel$MatchedResult;Lcom/discord/api/channel/Channel;Lcom/discord/api/channel/Channel;Lcom/discord/models/guild/Guild;IZ)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class ItemChannel implements ItemDataPayload {
        private final Channel channel;
        private final Guild guild;
        private final String key;
        private final MatchedResult matchedResult;
        private final int mentions;
        private final Channel parentChannel;
        private final int type;
        private final boolean unread;

        public ItemChannel(MatchedResult matchedResult, Channel channel, Channel channel2, Guild guild, int i, boolean z2) {
            Intrinsics3.checkNotNullParameter(matchedResult, "matchedResult");
            Intrinsics3.checkNotNullParameter(channel, "channel");
            this.matchedResult = matchedResult;
            this.channel = channel;
            this.parentChannel = channel2;
            this.guild = guild;
            this.mentions = i;
            this.unread = z2;
            this.key = String.valueOf(getChannel().getId());
        }

        public static /* synthetic */ ItemChannel copy$default(ItemChannel itemChannel, MatchedResult matchedResult, Channel channel, Channel channel2, Guild guild, int i, boolean z2, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                matchedResult = itemChannel.getMatchedResult();
            }
            if ((i2 & 2) != 0) {
                channel = itemChannel.getChannel();
            }
            Channel channel3 = channel;
            if ((i2 & 4) != 0) {
                channel2 = itemChannel.parentChannel;
            }
            Channel channel4 = channel2;
            if ((i2 & 8) != 0) {
                guild = itemChannel.guild;
            }
            Guild guild2 = guild;
            if ((i2 & 16) != 0) {
                i = itemChannel.getMentions();
            }
            int i3 = i;
            if ((i2 & 32) != 0) {
                z2 = itemChannel.getUnread();
            }
            return itemChannel.copy(matchedResult, channel3, channel4, guild2, i3, z2);
        }

        public final MatchedResult component1() {
            return getMatchedResult();
        }

        public final Channel component2() {
            return getChannel();
        }

        /* renamed from: component3, reason: from getter */
        public final Channel getParentChannel() {
            return this.parentChannel;
        }

        /* renamed from: component4, reason: from getter */
        public final Guild getGuild() {
            return this.guild;
        }

        public final int component5() {
            return getMentions();
        }

        public final boolean component6() {
            return getUnread();
        }

        public final ItemChannel copy(MatchedResult matchedResult, Channel channel, Channel parentChannel, Guild guild, int mentions, boolean unread) {
            Intrinsics3.checkNotNullParameter(matchedResult, "matchedResult");
            Intrinsics3.checkNotNullParameter(channel, "channel");
            return new ItemChannel(matchedResult, channel, parentChannel, guild, mentions, unread);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ItemChannel)) {
                return false;
            }
            ItemChannel itemChannel = (ItemChannel) other;
            return Intrinsics3.areEqual(getMatchedResult(), itemChannel.getMatchedResult()) && Intrinsics3.areEqual(getChannel(), itemChannel.getChannel()) && Intrinsics3.areEqual(this.parentChannel, itemChannel.parentChannel) && Intrinsics3.areEqual(this.guild, itemChannel.guild) && getMentions() == itemChannel.getMentions() && getUnread() == itemChannel.getUnread();
        }

        @Override // com.discord.widgets.user.search.WidgetGlobalSearchModel.ItemDataPayload
        public Channel getChannel() {
            return this.channel;
        }

        public final Guild getGuild() {
            return this.guild;
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
        public String getKey() {
            return this.key;
        }

        @Override // com.discord.widgets.user.search.WidgetGlobalSearchModel.ItemDataPayload
        public MatchedResult getMatchedResult() {
            return this.matchedResult;
        }

        @Override // com.discord.widgets.user.search.WidgetGlobalSearchModel.ItemDataPayload
        public int getMentions() {
            return this.mentions;
        }

        public final Channel getParentChannel() {
            return this.parentChannel;
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload
        public int getType() {
            return this.type;
        }

        @Override // com.discord.widgets.user.search.WidgetGlobalSearchModel.ItemDataPayload
        public boolean getUnread() {
            return this.unread;
        }

        public int hashCode() {
            MatchedResult matchedResult = getMatchedResult();
            int iHashCode = (matchedResult != null ? matchedResult.hashCode() : 0) * 31;
            Channel channel = getChannel();
            int iHashCode2 = (iHashCode + (channel != null ? channel.hashCode() : 0)) * 31;
            Channel channel2 = this.parentChannel;
            int iHashCode3 = (iHashCode2 + (channel2 != null ? channel2.hashCode() : 0)) * 31;
            Guild guild = this.guild;
            int mentions = (getMentions() + ((iHashCode3 + (guild != null ? guild.hashCode() : 0)) * 31)) * 31;
            boolean unread = getUnread();
            int i = unread;
            if (unread) {
                i = 1;
            }
            return mentions + i;
        }

        public String toString() {
            return String.valueOf(MentionUtils.CHANNELS_CHAR) + ChannelUtils.c(getChannel());
        }

        public /* synthetic */ ItemChannel(MatchedResult matchedResult, Channel channel, Channel channel2, Guild guild, int i, boolean z2, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this(matchedResult, channel, channel2, guild, (i2 & 16) != 0 ? 0 : i, (i2 & 32) != 0 ? false : z2);
        }
    }

    public /* synthetic */ WidgetGlobalSearchModel(String str, int i, List list, List list2, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, i, list, (i2 & 8) != 0 ? null : list2);
    }

    /* compiled from: WidgetGlobalSearchModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\u0000\n\u0002\b\u0015\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0014\u001a\u00020\u0005\u0012\u0006\u0010\u0015\u001a\u00020\b\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u000b\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0011¢\u0006\u0004\b/\u00100J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0012\u0010\f\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u000eHÆ\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0012\u001a\u00020\u0011HÆ\u0003¢\u0006\u0004\b\u0012\u0010\u0013JD\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0014\u001a\u00020\u00052\b\b\u0002\u0010\u0015\u001a\u00020\b2\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010\u0017\u001a\u00020\u000e2\b\b\u0002\u0010\u0018\u001a\u00020\u0011HÆ\u0001¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u001b\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u001b\u0010\u0010J\u001a\u0010\u001e\u001a\u00020\u00112\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cHÖ\u0003¢\u0006\u0004\b\u001e\u0010\u001fR\u001c\u0010\u0014\u001a\u00020\u00058\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0014\u0010 \u001a\u0004\b!\u0010\u0007R\u001c\u0010\u0018\u001a\u00020\u00118\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0018\u0010\"\u001a\u0004\b#\u0010\u0013R\u001c\u0010$\u001a\u00020\u00028\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010\u0004R\u001c\u0010'\u001a\u00020\u000e8\u0016@\u0016X\u0096D¢\u0006\f\n\u0004\b'\u0010(\u001a\u0004\b)\u0010\u0010R\u0019\u0010\u0015\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\u0015\u0010*\u001a\u0004\b+\u0010\nR\u001c\u0010\u0017\u001a\u00020\u000e8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0017\u0010(\u001a\u0004\b,\u0010\u0010R\u001e\u0010\u0016\u001a\u0004\u0018\u00010\u000b8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0016\u0010-\u001a\u0004\b.\u0010\r¨\u00061"}, d2 = {"Lcom/discord/widgets/user/search/WidgetGlobalSearchModel$ItemGuild;", "Lcom/discord/widgets/user/search/WidgetGlobalSearchModel$ItemDataPayload;", "", "toString", "()Ljava/lang/String;", "Lcom/discord/widgets/user/search/WidgetGlobalSearchModel$MatchedResult;", "component1", "()Lcom/discord/widgets/user/search/WidgetGlobalSearchModel$MatchedResult;", "Lcom/discord/models/guild/Guild;", "component2", "()Lcom/discord/models/guild/Guild;", "Lcom/discord/api/channel/Channel;", "component3", "()Lcom/discord/api/channel/Channel;", "", "component4", "()I", "", "component5", "()Z", "matchedResult", "guild", "channel", "mentions", "unread", "copy", "(Lcom/discord/widgets/user/search/WidgetGlobalSearchModel$MatchedResult;Lcom/discord/models/guild/Guild;Lcom/discord/api/channel/Channel;IZ)Lcom/discord/widgets/user/search/WidgetGlobalSearchModel$ItemGuild;", "hashCode", "", "other", "equals", "(Ljava/lang/Object;)Z", "Lcom/discord/widgets/user/search/WidgetGlobalSearchModel$MatchedResult;", "getMatchedResult", "Z", "getUnread", "key", "Ljava/lang/String;", "getKey", "type", "I", "getType", "Lcom/discord/models/guild/Guild;", "getGuild", "getMentions", "Lcom/discord/api/channel/Channel;", "getChannel", "<init>", "(Lcom/discord/widgets/user/search/WidgetGlobalSearchModel$MatchedResult;Lcom/discord/models/guild/Guild;Lcom/discord/api/channel/Channel;IZ)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class ItemGuild implements ItemDataPayload {
        private final Channel channel;
        private final Guild guild;
        private final String key;
        private final MatchedResult matchedResult;
        private final int mentions;
        private final int type;
        private final boolean unread;

        public ItemGuild(MatchedResult matchedResult, Guild guild, Channel channel, int i, boolean z2) {
            Intrinsics3.checkNotNullParameter(matchedResult, "matchedResult");
            Intrinsics3.checkNotNullParameter(guild, "guild");
            this.matchedResult = matchedResult;
            this.guild = guild;
            this.channel = channel;
            this.mentions = i;
            this.unread = z2;
            this.type = 2;
            this.key = String.valueOf(guild.getId());
        }

        public static /* synthetic */ ItemGuild copy$default(ItemGuild itemGuild, MatchedResult matchedResult, Guild guild, Channel channel, int i, boolean z2, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                matchedResult = itemGuild.getMatchedResult();
            }
            if ((i2 & 2) != 0) {
                guild = itemGuild.guild;
            }
            Guild guild2 = guild;
            if ((i2 & 4) != 0) {
                channel = itemGuild.getChannel();
            }
            Channel channel2 = channel;
            if ((i2 & 8) != 0) {
                i = itemGuild.getMentions();
            }
            int i3 = i;
            if ((i2 & 16) != 0) {
                z2 = itemGuild.getUnread();
            }
            return itemGuild.copy(matchedResult, guild2, channel2, i3, z2);
        }

        public final MatchedResult component1() {
            return getMatchedResult();
        }

        /* renamed from: component2, reason: from getter */
        public final Guild getGuild() {
            return this.guild;
        }

        public final Channel component3() {
            return getChannel();
        }

        public final int component4() {
            return getMentions();
        }

        public final boolean component5() {
            return getUnread();
        }

        public final ItemGuild copy(MatchedResult matchedResult, Guild guild, Channel channel, int mentions, boolean unread) {
            Intrinsics3.checkNotNullParameter(matchedResult, "matchedResult");
            Intrinsics3.checkNotNullParameter(guild, "guild");
            return new ItemGuild(matchedResult, guild, channel, mentions, unread);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ItemGuild)) {
                return false;
            }
            ItemGuild itemGuild = (ItemGuild) other;
            return Intrinsics3.areEqual(getMatchedResult(), itemGuild.getMatchedResult()) && Intrinsics3.areEqual(this.guild, itemGuild.guild) && Intrinsics3.areEqual(getChannel(), itemGuild.getChannel()) && getMentions() == itemGuild.getMentions() && getUnread() == itemGuild.getUnread();
        }

        @Override // com.discord.widgets.user.search.WidgetGlobalSearchModel.ItemDataPayload
        public Channel getChannel() {
            return this.channel;
        }

        public final Guild getGuild() {
            return this.guild;
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
        public String getKey() {
            return this.key;
        }

        @Override // com.discord.widgets.user.search.WidgetGlobalSearchModel.ItemDataPayload
        public MatchedResult getMatchedResult() {
            return this.matchedResult;
        }

        @Override // com.discord.widgets.user.search.WidgetGlobalSearchModel.ItemDataPayload
        public int getMentions() {
            return this.mentions;
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload
        public int getType() {
            return this.type;
        }

        @Override // com.discord.widgets.user.search.WidgetGlobalSearchModel.ItemDataPayload
        public boolean getUnread() {
            return this.unread;
        }

        public int hashCode() {
            MatchedResult matchedResult = getMatchedResult();
            int iHashCode = (matchedResult != null ? matchedResult.hashCode() : 0) * 31;
            Guild guild = this.guild;
            int iHashCode2 = (iHashCode + (guild != null ? guild.hashCode() : 0)) * 31;
            Channel channel = getChannel();
            int mentions = (getMentions() + ((iHashCode2 + (channel != null ? channel.hashCode() : 0)) * 31)) * 31;
            boolean unread = getUnread();
            int i = unread;
            if (unread) {
                i = 1;
            }
            return mentions + i;
        }

        public String toString() {
            return String.valueOf('*') + this.guild.getName();
        }

        public /* synthetic */ ItemGuild(MatchedResult matchedResult, Guild guild, Channel channel, int i, boolean z2, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this(matchedResult, guild, (i2 & 4) != 0 ? null : channel, (i2 & 8) != 0 ? 0 : i, (i2 & 16) != 0 ? false : z2);
        }
    }

    /* compiled from: WidgetGlobalSearchModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\u0000\n\u0002\b\u0019\b\u0086\b\u0018\u00002\u00020\u0001BY\u0012\u0006\u0010\u001c\u001a\u00020\u0005\u0012\u0006\u0010\u001d\u001a\u00020\b\u0012\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\f0\u000b\u0012\b\b\u0002\u0010\u001f\u001a\u00020\u000f\u0012\b\u0010 \u001a\u0004\u0018\u00010\u0012\u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u0015\u0012\b\b\u0002\u0010\"\u001a\u00020\u0018\u0012\b\b\u0002\u0010#\u001a\u00020\u000f¢\u0006\u0004\b>\u0010?J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0016\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000bHÆ\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÆ\u0003¢\u0006\u0004\b\u0010\u0010\u0011J\u0012\u0010\u0013\u001a\u0004\u0018\u00010\u0012HÆ\u0003¢\u0006\u0004\b\u0013\u0010\u0014J\u0012\u0010\u0016\u001a\u0004\u0018\u00010\u0015HÆ\u0003¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0019\u001a\u00020\u0018HÆ\u0003¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u001b\u001a\u00020\u000fHÆ\u0003¢\u0006\u0004\b\u001b\u0010\u0011Jj\u0010$\u001a\u00020\u00002\b\b\u0002\u0010\u001c\u001a\u00020\u00052\b\b\u0002\u0010\u001d\u001a\u00020\b2\u000e\b\u0002\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\b\b\u0002\u0010\u001f\u001a\u00020\u000f2\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u00152\b\b\u0002\u0010\"\u001a\u00020\u00182\b\b\u0002\u0010#\u001a\u00020\u000fHÆ\u0001¢\u0006\u0004\b$\u0010%J\u0010\u0010&\u001a\u00020\u0018HÖ\u0001¢\u0006\u0004\b&\u0010\u001aJ\u001a\u0010)\u001a\u00020\u000f2\b\u0010(\u001a\u0004\u0018\u00010'HÖ\u0003¢\u0006\u0004\b)\u0010*R\u001c\u0010\u001c\u001a\u00020\u00058\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u001c\u0010+\u001a\u0004\b,\u0010\u0007R\u001c\u0010-\u001a\u00020\u00188\u0016@\u0016X\u0096D¢\u0006\f\n\u0004\b-\u0010.\u001a\u0004\b/\u0010\u001aR\u0019\u0010\u001f\u001a\u00020\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b\u001f\u00100\u001a\u0004\b\u001f\u0010\u0011R\u001c\u0010\"\u001a\u00020\u00188\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\"\u0010.\u001a\u0004\b1\u0010\u001aR\u001c\u0010#\u001a\u00020\u000f8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b#\u00100\u001a\u0004\b2\u0010\u0011R\u001c\u00103\u001a\u00020\u00028\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b3\u00104\u001a\u0004\b5\u0010\u0004R\u001e\u0010!\u001a\u0004\u0018\u00010\u00158\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b!\u00106\u001a\u0004\b7\u0010\u0017R\u001b\u0010 \u001a\u0004\u0018\u00010\u00128\u0006@\u0006¢\u0006\f\n\u0004\b \u00108\u001a\u0004\b9\u0010\u0014R\u001f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\f0\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\u001e\u0010:\u001a\u0004\b;\u0010\u000eR\u0019\u0010\u001d\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\u001d\u0010<\u001a\u0004\b=\u0010\n¨\u0006@"}, d2 = {"Lcom/discord/widgets/user/search/WidgetGlobalSearchModel$ItemUser;", "Lcom/discord/widgets/user/search/WidgetGlobalSearchModel$ItemDataPayload;", "", "toString", "()Ljava/lang/String;", "Lcom/discord/widgets/user/search/WidgetGlobalSearchModel$MatchedResult;", "component1", "()Lcom/discord/widgets/user/search/WidgetGlobalSearchModel$MatchedResult;", "Lcom/discord/models/user/User;", "component2", "()Lcom/discord/models/user/User;", "", "", "component3", "()Ljava/util/List;", "", "component4", "()Z", "Lcom/discord/models/presence/Presence;", "component5", "()Lcom/discord/models/presence/Presence;", "Lcom/discord/api/channel/Channel;", "component6", "()Lcom/discord/api/channel/Channel;", "", "component7", "()I", "component8", "matchedResult", "user", "aliases", "isFriend", "presence", "channel", "mentions", "unread", "copy", "(Lcom/discord/widgets/user/search/WidgetGlobalSearchModel$MatchedResult;Lcom/discord/models/user/User;Ljava/util/List;ZLcom/discord/models/presence/Presence;Lcom/discord/api/channel/Channel;IZ)Lcom/discord/widgets/user/search/WidgetGlobalSearchModel$ItemUser;", "hashCode", "", "other", "equals", "(Ljava/lang/Object;)Z", "Lcom/discord/widgets/user/search/WidgetGlobalSearchModel$MatchedResult;", "getMatchedResult", "type", "I", "getType", "Z", "getMentions", "getUnread", "key", "Ljava/lang/String;", "getKey", "Lcom/discord/api/channel/Channel;", "getChannel", "Lcom/discord/models/presence/Presence;", "getPresence", "Ljava/util/List;", "getAliases", "Lcom/discord/models/user/User;", "getUser", "<init>", "(Lcom/discord/widgets/user/search/WidgetGlobalSearchModel$MatchedResult;Lcom/discord/models/user/User;Ljava/util/List;ZLcom/discord/models/presence/Presence;Lcom/discord/api/channel/Channel;IZ)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class ItemUser implements ItemDataPayload {
        private final List<CharSequence> aliases;
        private final Channel channel;
        private final boolean isFriend;
        private final String key;
        private final MatchedResult matchedResult;
        private final int mentions;
        private final Presence presence;
        private final int type;
        private final boolean unread;
        private final User user;

        /* JADX WARN: Multi-variable type inference failed */
        public ItemUser(MatchedResult matchedResult, User user, List<? extends CharSequence> list, boolean z2, Presence presence, Channel channel, int i, boolean z3) {
            Intrinsics3.checkNotNullParameter(matchedResult, "matchedResult");
            Intrinsics3.checkNotNullParameter(user, "user");
            Intrinsics3.checkNotNullParameter(list, "aliases");
            this.matchedResult = matchedResult;
            this.user = user;
            this.aliases = list;
            this.isFriend = z2;
            this.presence = presence;
            this.channel = channel;
            this.mentions = i;
            this.unread = z3;
            this.type = 1;
            this.key = String.valueOf(user.getId());
        }

        public static /* synthetic */ ItemUser copy$default(ItemUser itemUser, MatchedResult matchedResult, User user, List list, boolean z2, Presence presence, Channel channel, int i, boolean z3, int i2, Object obj) {
            return itemUser.copy((i2 & 1) != 0 ? itemUser.getMatchedResult() : matchedResult, (i2 & 2) != 0 ? itemUser.user : user, (i2 & 4) != 0 ? itemUser.aliases : list, (i2 & 8) != 0 ? itemUser.isFriend : z2, (i2 & 16) != 0 ? itemUser.presence : presence, (i2 & 32) != 0 ? itemUser.getChannel() : channel, (i2 & 64) != 0 ? itemUser.getMentions() : i, (i2 & 128) != 0 ? itemUser.getUnread() : z3);
        }

        public final MatchedResult component1() {
            return getMatchedResult();
        }

        /* renamed from: component2, reason: from getter */
        public final User getUser() {
            return this.user;
        }

        public final List<CharSequence> component3() {
            return this.aliases;
        }

        /* renamed from: component4, reason: from getter */
        public final boolean getIsFriend() {
            return this.isFriend;
        }

        /* renamed from: component5, reason: from getter */
        public final Presence getPresence() {
            return this.presence;
        }

        public final Channel component6() {
            return getChannel();
        }

        public final int component7() {
            return getMentions();
        }

        public final boolean component8() {
            return getUnread();
        }

        public final ItemUser copy(MatchedResult matchedResult, User user, List<? extends CharSequence> aliases, boolean isFriend, Presence presence, Channel channel, int mentions, boolean unread) {
            Intrinsics3.checkNotNullParameter(matchedResult, "matchedResult");
            Intrinsics3.checkNotNullParameter(user, "user");
            Intrinsics3.checkNotNullParameter(aliases, "aliases");
            return new ItemUser(matchedResult, user, aliases, isFriend, presence, channel, mentions, unread);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ItemUser)) {
                return false;
            }
            ItemUser itemUser = (ItemUser) other;
            return Intrinsics3.areEqual(getMatchedResult(), itemUser.getMatchedResult()) && Intrinsics3.areEqual(this.user, itemUser.user) && Intrinsics3.areEqual(this.aliases, itemUser.aliases) && this.isFriend == itemUser.isFriend && Intrinsics3.areEqual(this.presence, itemUser.presence) && Intrinsics3.areEqual(getChannel(), itemUser.getChannel()) && getMentions() == itemUser.getMentions() && getUnread() == itemUser.getUnread();
        }

        public final List<CharSequence> getAliases() {
            return this.aliases;
        }

        @Override // com.discord.widgets.user.search.WidgetGlobalSearchModel.ItemDataPayload
        public Channel getChannel() {
            return this.channel;
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
        public String getKey() {
            return this.key;
        }

        @Override // com.discord.widgets.user.search.WidgetGlobalSearchModel.ItemDataPayload
        public MatchedResult getMatchedResult() {
            return this.matchedResult;
        }

        @Override // com.discord.widgets.user.search.WidgetGlobalSearchModel.ItemDataPayload
        public int getMentions() {
            return this.mentions;
        }

        public final Presence getPresence() {
            return this.presence;
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload
        public int getType() {
            return this.type;
        }

        @Override // com.discord.widgets.user.search.WidgetGlobalSearchModel.ItemDataPayload
        public boolean getUnread() {
            return this.unread;
        }

        public final User getUser() {
            return this.user;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            MatchedResult matchedResult = getMatchedResult();
            int iHashCode = (matchedResult != null ? matchedResult.hashCode() : 0) * 31;
            User user = this.user;
            int iHashCode2 = (iHashCode + (user != null ? user.hashCode() : 0)) * 31;
            List<CharSequence> list = this.aliases;
            int iHashCode3 = (iHashCode2 + (list != null ? list.hashCode() : 0)) * 31;
            boolean z2 = this.isFriend;
            int i = z2;
            if (z2 != 0) {
                i = 1;
            }
            int i2 = (iHashCode3 + i) * 31;
            Presence presence = this.presence;
            int iHashCode4 = (i2 + (presence != null ? presence.hashCode() : 0)) * 31;
            Channel channel = getChannel();
            int mentions = (getMentions() + ((iHashCode4 + (channel != null ? channel.hashCode() : 0)) * 31)) * 31;
            boolean unread = getUnread();
            return mentions + (unread ? 1 : unread);
        }

        public final boolean isFriend() {
            return this.isFriend;
        }

        public String toString() {
            StringBuilder sbQ = outline.Q(MentionUtils.MENTIONS_CHAR);
            sbQ.append(getMatchedResult().getValue());
            return sbQ.toString();
        }

        public /* synthetic */ ItemUser(MatchedResult matchedResult, User user, List list, boolean z2, Presence presence, Channel channel, int i, boolean z3, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this(matchedResult, user, list, (i2 & 8) != 0 ? false : z2, presence, (i2 & 32) != 0 ? null : channel, (i2 & 64) != 0 ? 0 : i, (i2 & 128) != 0 ? false : z3);
        }
    }

    /* compiled from: WidgetGlobalSearchModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0011\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\b\b\u0001\u0010\t\u001a\u00020\u0002\u0012\b\b\u0002\u0010\n\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0006¢\u0006\u0004\b*\u0010+J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ.\u0010\f\u001a\u00020\u00002\b\b\u0003\u0010\t\u001a\u00020\u00022\b\b\u0002\u0010\n\u001a\u00020\u00022\b\b\u0002\u0010\u000b\u001a\u00020\u0006HÆ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0004J\u001a\u0010\u0014\u001a\u00020\u00062\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015R\u001e\u0010\u0017\u001a\u0004\u0018\u00010\u00168\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u001c\u0010\u001c\u001a\u00020\u001b8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u0019\u0010\t\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010 \u001a\u0004\b!\u0010\u0004R\u001c\u0010\n\u001a\u00020\u00028\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\n\u0010 \u001a\u0004\b\"\u0010\u0004R\u001c\u0010#\u001a\u00020\u000e8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b%\u0010\u0010R\u001c\u0010&\u001a\u00020\u00028\u0016@\u0016X\u0096D¢\u0006\f\n\u0004\b&\u0010 \u001a\u0004\b'\u0010\u0004R\u001c\u0010\u000b\u001a\u00020\u00068\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u000b\u0010(\u001a\u0004\b)\u0010\b¨\u0006,"}, d2 = {"Lcom/discord/widgets/user/search/WidgetGlobalSearchModel$ItemHeader;", "Lcom/discord/widgets/user/search/WidgetGlobalSearchModel$ItemDataPayload;", "", "component1", "()I", "component2", "", "component3", "()Z", ModelAuditLogEntry.CHANGE_KEY_NAME, "mentions", "unread", "copy", "(IIZ)Lcom/discord/widgets/user/search/WidgetGlobalSearchModel$ItemHeader;", "", "toString", "()Ljava/lang/String;", "hashCode", "", "other", "equals", "(Ljava/lang/Object;)Z", "Lcom/discord/api/channel/Channel;", "channel", "Lcom/discord/api/channel/Channel;", "getChannel", "()Lcom/discord/api/channel/Channel;", "Lcom/discord/widgets/user/search/WidgetGlobalSearchModel$MatchedResult;", "matchedResult", "Lcom/discord/widgets/user/search/WidgetGlobalSearchModel$MatchedResult;", "getMatchedResult", "()Lcom/discord/widgets/user/search/WidgetGlobalSearchModel$MatchedResult;", "I", "getName", "getMentions", "key", "Ljava/lang/String;", "getKey", "type", "getType", "Z", "getUnread", "<init>", "(IIZ)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class ItemHeader implements ItemDataPayload {
        private final Channel channel;
        private final String key;
        private final MatchedResult matchedResult;
        private final int mentions;
        private final int name;
        private final int type;
        private final boolean unread;

        public ItemHeader(@StringRes int i, int i2, boolean z2) {
            this.name = i;
            this.mentions = i2;
            this.unread = z2;
            this.matchedResult = WidgetGlobalSearchModel.INSTANCE.getEMPTY_MATCH_RESULT();
            this.type = -1;
            this.key = outline.q("header", i);
        }

        public static /* synthetic */ ItemHeader copy$default(ItemHeader itemHeader, int i, int i2, boolean z2, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                i = itemHeader.name;
            }
            if ((i3 & 2) != 0) {
                i2 = itemHeader.getMentions();
            }
            if ((i3 & 4) != 0) {
                z2 = itemHeader.getUnread();
            }
            return itemHeader.copy(i, i2, z2);
        }

        /* renamed from: component1, reason: from getter */
        public final int getName() {
            return this.name;
        }

        public final int component2() {
            return getMentions();
        }

        public final boolean component3() {
            return getUnread();
        }

        public final ItemHeader copy(@StringRes int name, int mentions, boolean unread) {
            return new ItemHeader(name, mentions, unread);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ItemHeader)) {
                return false;
            }
            ItemHeader itemHeader = (ItemHeader) other;
            return this.name == itemHeader.name && getMentions() == itemHeader.getMentions() && getUnread() == itemHeader.getUnread();
        }

        @Override // com.discord.widgets.user.search.WidgetGlobalSearchModel.ItemDataPayload
        public Channel getChannel() {
            return this.channel;
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
        public String getKey() {
            return this.key;
        }

        @Override // com.discord.widgets.user.search.WidgetGlobalSearchModel.ItemDataPayload
        public MatchedResult getMatchedResult() {
            return this.matchedResult;
        }

        @Override // com.discord.widgets.user.search.WidgetGlobalSearchModel.ItemDataPayload
        public int getMentions() {
            return this.mentions;
        }

        public final int getName() {
            return this.name;
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload
        public int getType() {
            return this.type;
        }

        @Override // com.discord.widgets.user.search.WidgetGlobalSearchModel.ItemDataPayload
        public boolean getUnread() {
            return this.unread;
        }

        public int hashCode() {
            int mentions = (getMentions() + (this.name * 31)) * 31;
            boolean unread = getUnread();
            int i = unread;
            if (unread) {
                i = 1;
            }
            return mentions + i;
        }

        public String toString() {
            StringBuilder sbU = outline.U("ItemHeader(name=");
            sbU.append(this.name);
            sbU.append(", mentions=");
            sbU.append(getMentions());
            sbU.append(", unread=");
            sbU.append(getUnread());
            sbU.append(")");
            return sbU.toString();
        }

        public /* synthetic */ ItemHeader(int i, int i2, boolean z2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this(i, (i3 & 2) != 0 ? 0 : i2, (i3 & 4) != 0 ? false : z2);
        }
    }
}
