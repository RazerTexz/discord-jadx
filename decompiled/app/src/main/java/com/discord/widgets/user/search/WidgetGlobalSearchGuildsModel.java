package com.discord.widgets.user.search;

import a0.a.a.b;
import androidx.core.app.FrameMetricsAggregator;
import b.d.b.a.outline;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.domain.ModelNotificationSettings;
import com.discord.models.guild.Guild;
import com.discord.utilities.mg_recycler.MGRecyclerDataPayload;
import d0.f0._Sequences2;
import d0.f0.n;
import d0.t._Collections;
import d0.z.d.Intrinsics3;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.sequences.Sequence;

/* compiled from: WidgetGlobalSearchGuildsModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000e\b\u0086\b\u0018\u0000 \u001c2\u00020\u0001:\u0002\u001c\u001dB\u001f\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\b\b\u0002\u0010\n\u001a\u00020\u0006¢\u0006\u0004\b\u001a\u0010\u001bJ\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ*\u0010\u000b\u001a\u00020\u00002\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\b\b\u0002\u0010\n\u001a\u00020\u0006HÆ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u001a\u0010\u0014\u001a\u00020\u00062\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015R\u001f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\u0016\u001a\u0004\b\u0017\u0010\u0005R\u0019\u0010\n\u001a\u00020\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\n\u0010\u0018\u001a\u0004\b\u0019\u0010\b¨\u0006\u001e"}, d2 = {"Lcom/discord/widgets/user/search/WidgetGlobalSearchGuildsModel;", "", "", "Lcom/discord/widgets/user/search/WidgetGlobalSearchGuildsModel$Item;", "component1", "()Ljava/util/List;", "", "component2", "()Z", "items", "hasChannels", "copy", "(Ljava/util/List;Z)Lcom/discord/widgets/user/search/WidgetGlobalSearchGuildsModel;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Ljava/util/List;", "getItems", "Z", "getHasChannels", "<init>", "(Ljava/util/List;Z)V", "Companion", "Item", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final /* data */ class WidgetGlobalSearchGuildsModel {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final boolean hasChannels;
    private final List<Item> items;

    /* compiled from: WidgetGlobalSearchGuildsModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u001f\u0010 J\u009f\u0001\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u0002*\b\u0012\u0004\u0012\u00020\u00030\u00022\u000e\u0010\u0006\u001a\n\u0018\u00010\u0004j\u0004\u0018\u0001`\u00052\n\u0010\b\u001a\u00060\u0004j\u0002`\u00072\u0010\u0010\n\u001a\f\u0012\b\u0012\u00060\u0004j\u0002`\u00050\t2\u0016\u0010\r\u001a\u0012\u0012\b\u0012\u00060\u0004j\u0002`\u0005\u0012\u0004\u0012\u00020\f0\u000b2\u0016\u0010\u000f\u001a\u0012\u0012\b\u0012\u00060\u0004j\u0002`\u0007\u0012\u0004\u0012\u00020\u000e0\u000b2 \u0010\u0011\u001a\u001c\u0012\b\u0012\u00060\u0004j\u0002`\u0005\u0012\u000e\u0012\f\u0012\b\u0012\u00060\u0004j\u0002`\u00070\u00100\u000bH\u0002¢\u0006\u0004\b\u0013\u0010\u0014JM\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00120\u0002*\u0014\u0012\b\u0012\u00060\u0004j\u0002`\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u00150\u000b2\u0016\u0010\u000f\u001a\u0012\u0012\b\u0012\u00060\u0004j\u0002`\u0007\u0012\u0004\u0012\u00020\u000e0\u000b2\b\u0010\u0016\u001a\u0004\u0018\u00010\fH\u0002¢\u0006\u0004\b\u0017\u0010\u0018J¿\u0001\u0010\u001d\u001a\u00020\u001c2\u0010\u0010\u0019\u001a\f\u0012\b\u0012\u00060\u0004j\u0002`\u00050\u00102\n\u0010\b\u001a\u00060\u0004j\u0002`\u00072\u0010\u0010\n\u001a\f\u0012\b\u0012\u00060\u0004j\u0002`\u00050\t2\u0016\u0010\u000f\u001a\u0012\u0012\b\u0012\u00060\u0004j\u0002`\u0007\u0012\u0004\u0012\u00020\u000e0\u000b2\u0016\u0010\u001a\u001a\u0012\u0012\b\u0012\u00060\u0004j\u0002`\u0007\u0012\u0004\u0012\u00020\u00150\u000b2\u0016\u0010\u001b\u001a\u0012\u0012\b\u0012\u00060\u0004j\u0002`\u0005\u0012\u0004\u0012\u00020\u00030\u000b2 \u0010\u0011\u001a\u001c\u0012\b\u0012\u00060\u0004j\u0002`\u0005\u0012\u000e\u0012\f\u0012\b\u0012\u00060\u0004j\u0002`\u00070\u00100\u000b2\u0016\u0010\r\u001a\u0012\u0012\b\u0012\u00060\u0004j\u0002`\u0005\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\u0004\b\u001d\u0010\u001e¨\u0006!"}, d2 = {"Lcom/discord/widgets/user/search/WidgetGlobalSearchGuildsModel$Companion;", "", "Lkotlin/sequences/Sequence;", "Lcom/discord/models/guild/Guild;", "", "Lcom/discord/primitives/GuildId;", "selectedGuildId", "Lcom/discord/primitives/ChannelId;", "selectedVoiceChannelId", "", "unreadGuildIds", "", "Lcom/discord/models/domain/ModelNotificationSettings;", "guildSettings", "", "mentionCounts", "", "channelIds", "Lcom/discord/widgets/user/search/WidgetGlobalSearchGuildsModel$Item;", "asGuildItems", "(Lkotlin/sequences/Sequence;Ljava/lang/Long;JLjava/util/Set;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;)Lkotlin/sequences/Sequence;", "Lcom/discord/api/channel/Channel;", "dmSettings", "asDirectMessageItems", "(Ljava/util/Map;Ljava/util/Map;Lcom/discord/models/domain/ModelNotificationSettings;)Lkotlin/sequences/Sequence;", "recentGuildIds", "privateChannels", "guilds", "Lcom/discord/widgets/user/search/WidgetGlobalSearchGuildsModel;", "create", "(Ljava/util/List;JLjava/util/Set;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;)Lcom/discord/widgets/user/search/WidgetGlobalSearchGuildsModel;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        private final Sequence<Item> asDirectMessageItems(Map<Long, Channel> map, Map<Long, Integer> map2, ModelNotificationSettings modelNotificationSettings) {
            return _Sequences2.map(_Sequences2.sortedWith(_Sequences2.filter(_Sequences2.filterNotNull(_Collections.asSequence(map.values())), new WidgetGlobalSearchGuildsModel2(modelNotificationSettings, map2)), ChannelUtils.h(Channel.INSTANCE)), new WidgetGlobalSearchGuildsModel3(map2));
        }

        private final Sequence<Item> asGuildItems(Sequence<Guild> sequence, Long l, long j, Set<Long> set, Map<Long, ? extends ModelNotificationSettings> map, Map<Long, Integer> map2, Map<Long, ? extends List<Long>> map3) {
            return _Sequences2.map(sequence, new WidgetGlobalSearchGuildsModel4(map3, map2, map, set, l, j));
        }

        public final WidgetGlobalSearchGuildsModel create(List<Long> recentGuildIds, long selectedVoiceChannelId, Set<Long> unreadGuildIds, Map<Long, Integer> mentionCounts, Map<Long, Channel> privateChannels, Map<Long, Guild> guilds, Map<Long, ? extends List<Long>> channelIds, Map<Long, ? extends ModelNotificationSettings> guildSettings) {
            Intrinsics3.checkNotNullParameter(recentGuildIds, "recentGuildIds");
            Intrinsics3.checkNotNullParameter(unreadGuildIds, "unreadGuildIds");
            Intrinsics3.checkNotNullParameter(mentionCounts, "mentionCounts");
            Intrinsics3.checkNotNullParameter(privateChannels, "privateChannels");
            Intrinsics3.checkNotNullParameter(guilds, "guilds");
            Intrinsics3.checkNotNullParameter(channelIds, "channelIds");
            Intrinsics3.checkNotNullParameter(guildSettings, "guildSettings");
            Sequence<Item> sequenceAsDirectMessageItems = asDirectMessageItems(privateChannels, mentionCounts, guildSettings.get(0L));
            return new WidgetGlobalSearchGuildsModel(_Sequences2.toList(_Sequences2.plus(_Sequences2.plus((Sequence) sequenceAsDirectMessageItems, _Sequences2.any(sequenceAsDirectMessageItems) ? n.sequenceOf(Item.INSTANCE.createDivider$app_productionGoogleRelease()) : n.emptySequence()), _Sequences2.sortedWith(asGuildItems(_Sequences2.mapNotNull(_Sequences2.drop(_Sequences2.distinct(_Collections.asSequence(_Collections.plus((Collection) recentGuildIds, (Iterable) guilds.keySet()))), 1), new WidgetGlobalSearchGuildsModel5(guilds)), (Long) _Collections.firstOrNull((List) recentGuildIds), selectedVoiceChannelId, unreadGuildIds, guildSettings, mentionCounts, channelIds), new WidgetGlobalSearchGuildsModel$Companion$create$$inlined$sortedByDescending$1()))), !channelIds.isEmpty());
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public WidgetGlobalSearchGuildsModel(List<Item> list, boolean z2) {
        Intrinsics3.checkNotNullParameter(list, "items");
        this.items = list;
        this.hasChannels = z2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ WidgetGlobalSearchGuildsModel copy$default(WidgetGlobalSearchGuildsModel widgetGlobalSearchGuildsModel, List list, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            list = widgetGlobalSearchGuildsModel.items;
        }
        if ((i & 2) != 0) {
            z2 = widgetGlobalSearchGuildsModel.hasChannels;
        }
        return widgetGlobalSearchGuildsModel.copy(list, z2);
    }

    public final List<Item> component1() {
        return this.items;
    }

    /* renamed from: component2, reason: from getter */
    public final boolean getHasChannels() {
        return this.hasChannels;
    }

    public final WidgetGlobalSearchGuildsModel copy(List<Item> items, boolean hasChannels) {
        Intrinsics3.checkNotNullParameter(items, "items");
        return new WidgetGlobalSearchGuildsModel(items, hasChannels);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WidgetGlobalSearchGuildsModel)) {
            return false;
        }
        WidgetGlobalSearchGuildsModel widgetGlobalSearchGuildsModel = (WidgetGlobalSearchGuildsModel) other;
        return Intrinsics3.areEqual(this.items, widgetGlobalSearchGuildsModel.items) && this.hasChannels == widgetGlobalSearchGuildsModel.hasChannels;
    }

    public final boolean getHasChannels() {
        return this.hasChannels;
    }

    public final List<Item> getItems() {
        return this.items;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        List<Item> list = this.items;
        int iHashCode = (list != null ? list.hashCode() : 0) * 31;
        boolean z2 = this.hasChannels;
        int i = z2;
        if (z2 != 0) {
            i = 1;
        }
        return iHashCode + i;
    }

    public String toString() {
        StringBuilder sbU = outline.U("WidgetGlobalSearchGuildsModel(items=");
        sbU.append(this.items);
        sbU.append(", hasChannels=");
        return outline.O(sbU, this.hasChannels, ")");
    }

    public /* synthetic */ WidgetGlobalSearchGuildsModel(List list, boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(list, (i & 2) != 0 ? true : z2);
    }

    /* compiled from: WidgetGlobalSearchGuildsModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0017\b\u0086\b\u0018\u0000 :2\u00020\u0001:\u0001:Be\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u000b\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u0002¢\u0006\u0004\b8\u00109J\u0010\u0010\u0003\u001a\u00020\u0002HÂ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\t\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0012\u0010\f\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u000e\u0010\u0004J\u0010\u0010\u0010\u001a\u00020\u000fHÆ\u0003¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\u000fHÆ\u0003¢\u0006\u0004\b\u0012\u0010\u0011J\u0010\u0010\u0013\u001a\u00020\u000fHÆ\u0003¢\u0006\u0004\b\u0013\u0010\u0011J\u0010\u0010\u0014\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0014\u0010\u0004Jn\u0010\u001e\u001a\u00020\u00002\b\b\u0002\u0010\u0015\u001a\u00020\u00022\b\b\u0002\u0010\u0016\u001a\u00020\u00052\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010\u0019\u001a\u00020\u00022\b\b\u0002\u0010\u001a\u001a\u00020\u000f2\b\b\u0002\u0010\u001b\u001a\u00020\u000f2\b\b\u0002\u0010\u001c\u001a\u00020\u000f2\b\b\u0002\u0010\u001d\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u001e\u0010\u001fJ\u0010\u0010!\u001a\u00020 HÖ\u0001¢\u0006\u0004\b!\u0010\"J\u0010\u0010#\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b#\u0010\u0004J\u001a\u0010&\u001a\u00020\u000f2\b\u0010%\u001a\u0004\u0018\u00010$HÖ\u0003¢\u0006\u0004\b&\u0010'R\u0019\u0010\u001b\u001a\u00020\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b\u001b\u0010(\u001a\u0004\b\u001b\u0010\u0011R\u0019\u0010\u0019\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0019\u0010)\u001a\u0004\b*\u0010\u0004R\u001c\u0010+\u001a\u00020 8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b+\u0010,\u001a\u0004\b-\u0010\"R\u001b\u0010\u0017\u001a\u0004\u0018\u00010\b8\u0006@\u0006¢\u0006\f\n\u0004\b\u0017\u0010.\u001a\u0004\b/\u0010\nR\u001b\u0010\u0018\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\u0018\u00100\u001a\u0004\b1\u0010\rR\u0016\u0010\u0015\u001a\u00020\u00028\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010)R\u0019\u0010\u001d\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u001d\u0010)\u001a\u0004\b2\u0010\u0004R\u0019\u0010\u0016\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0016\u00103\u001a\u0004\b4\u0010\u0007R\u001c\u00105\u001a\u00020\u00028\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b5\u0010)\u001a\u0004\b6\u0010\u0004R\u0019\u0010\u001a\u001a\u00020\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b\u001a\u0010(\u001a\u0004\b\u001a\u0010\u0011R\u0019\u0010\u001c\u001a\u00020\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b\u001c\u0010(\u001a\u0004\b7\u0010\u0011¨\u0006;"}, d2 = {"Lcom/discord/widgets/user/search/WidgetGlobalSearchGuildsModel$Item;", "Lcom/discord/utilities/mg_recycler/MGRecyclerDataPayload;", "", "component1", "()I", "", "component2", "()J", "Lcom/discord/api/channel/Channel;", "component3", "()Lcom/discord/api/channel/Channel;", "Lcom/discord/models/guild/Guild;", "component4", "()Lcom/discord/models/guild/Guild;", "component5", "", "component6", "()Z", "component7", "component8", "component9", "_type", ModelAuditLogEntry.CHANGE_KEY_ID, "channel", "guild", "mentionCount", "isUnread", "isSelected", "connectedToVoice", "unavailableGuildCount", "copy", "(IJLcom/discord/api/channel/Channel;Lcom/discord/models/guild/Guild;IZZZI)Lcom/discord/widgets/user/search/WidgetGlobalSearchGuildsModel$Item;", "", "toString", "()Ljava/lang/String;", "hashCode", "", "other", "equals", "(Ljava/lang/Object;)Z", "Z", "I", "getMentionCount", "key", "Ljava/lang/String;", "getKey", "Lcom/discord/api/channel/Channel;", "getChannel", "Lcom/discord/models/guild/Guild;", "getGuild", "getUnavailableGuildCount", "J", "getId", "type", "getType", "getConnectedToVoice", "<init>", "(IJLcom/discord/api/channel/Channel;Lcom/discord/models/guild/Guild;IZZZI)V", "Companion", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class Item implements MGRecyclerDataPayload {

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        public static final int TYPE_DIVIDER = 1;
        public static final int TYPE_DM = 2;
        public static final int TYPE_GUILD = 3;
        private final int _type;
        private final Channel channel;
        private final boolean connectedToVoice;
        private final Guild guild;
        private final long id;
        private final boolean isSelected;
        private final boolean isUnread;
        private final String key;
        private final int mentionCount;
        private final int type;
        private final int unavailableGuildCount;

        /* compiled from: WidgetGlobalSearchGuildsModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\r\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\u001f\u0010\t\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0000¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\f\u001a\u00020\u0006H\u0000¢\u0006\u0004\b\n\u0010\u000bJ7\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u000fH\u0000¢\u0006\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0016\u001a\u00020\u00048\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u0018\u001a\u00020\u00048\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0018\u0010\u0017R\u0016\u0010\u0019\u001a\u00020\u00048\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0019\u0010\u0017¨\u0006\u001c"}, d2 = {"Lcom/discord/widgets/user/search/WidgetGlobalSearchGuildsModel$Item$Companion;", "", "Lcom/discord/api/channel/Channel;", "channel", "", "mentionCount", "Lcom/discord/widgets/user/search/WidgetGlobalSearchGuildsModel$Item;", "createDirectMessage$app_productionGoogleRelease", "(Lcom/discord/api/channel/Channel;I)Lcom/discord/widgets/user/search/WidgetGlobalSearchGuildsModel$Item;", "createDirectMessage", "createDivider$app_productionGoogleRelease", "()Lcom/discord/widgets/user/search/WidgetGlobalSearchGuildsModel$Item;", "createDivider", "Lcom/discord/models/guild/Guild;", "guild", "", "hasUnread", "isSelected", "connectedToVoice", "createGuild$app_productionGoogleRelease", "(Lcom/discord/models/guild/Guild;IZZZ)Lcom/discord/widgets/user/search/WidgetGlobalSearchGuildsModel$Item;", "createGuild", "TYPE_DIVIDER", "I", "TYPE_DM", "TYPE_GUILD", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final class Companion {
            private Companion() {
            }

            public final Item createDirectMessage$app_productionGoogleRelease(Channel channel, int mentionCount) {
                Intrinsics3.checkNotNullParameter(channel, "channel");
                return new Item(2, channel.getId(), channel, null, mentionCount, false, false, false, 0, 488, null);
            }

            public final Item createDivider$app_productionGoogleRelease() {
                return new Item(1, 1L, null, null, 0, false, false, false, 0, 508, null);
            }

            public final Item createGuild$app_productionGoogleRelease(Guild guild, int mentionCount, boolean hasUnread, boolean isSelected, boolean connectedToVoice) {
                Intrinsics3.checkNotNullParameter(guild, "guild");
                return new Item(3, guild.getId(), null, guild, mentionCount, hasUnread, isSelected, connectedToVoice, 0, 260, null);
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public Item() {
            this(0, 0L, null, null, 0, false, false, false, 0, FrameMetricsAggregator.EVERY_DURATION, null);
        }

        public Item(int i, long j, Channel channel, Guild guild, int i2, boolean z2, boolean z3, boolean z4, int i3) {
            this._type = i;
            this.id = j;
            this.channel = channel;
            this.guild = guild;
            this.mentionCount = i2;
            this.isUnread = z2;
            this.isSelected = z3;
            this.connectedToVoice = z4;
            this.unavailableGuildCount = i3;
            this.type = i;
            StringBuilder sb = new StringBuilder();
            sb.append(getType());
            sb.append('-');
            sb.append(j);
            this.key = sb.toString();
        }

        /* renamed from: component1, reason: from getter */
        private final int get_type() {
            return this._type;
        }

        public static /* synthetic */ Item copy$default(Item item, int i, long j, Channel channel, Guild guild, int i2, boolean z2, boolean z3, boolean z4, int i3, int i4, Object obj) {
            return item.copy((i4 & 1) != 0 ? item._type : i, (i4 & 2) != 0 ? item.id : j, (i4 & 4) != 0 ? item.channel : channel, (i4 & 8) != 0 ? item.guild : guild, (i4 & 16) != 0 ? item.mentionCount : i2, (i4 & 32) != 0 ? item.isUnread : z2, (i4 & 64) != 0 ? item.isSelected : z3, (i4 & 128) != 0 ? item.connectedToVoice : z4, (i4 & 256) != 0 ? item.unavailableGuildCount : i3);
        }

        /* renamed from: component2, reason: from getter */
        public final long getId() {
            return this.id;
        }

        /* renamed from: component3, reason: from getter */
        public final Channel getChannel() {
            return this.channel;
        }

        /* renamed from: component4, reason: from getter */
        public final Guild getGuild() {
            return this.guild;
        }

        /* renamed from: component5, reason: from getter */
        public final int getMentionCount() {
            return this.mentionCount;
        }

        /* renamed from: component6, reason: from getter */
        public final boolean getIsUnread() {
            return this.isUnread;
        }

        /* renamed from: component7, reason: from getter */
        public final boolean getIsSelected() {
            return this.isSelected;
        }

        /* renamed from: component8, reason: from getter */
        public final boolean getConnectedToVoice() {
            return this.connectedToVoice;
        }

        /* renamed from: component9, reason: from getter */
        public final int getUnavailableGuildCount() {
            return this.unavailableGuildCount;
        }

        public final Item copy(int _type, long id2, Channel channel, Guild guild, int mentionCount, boolean isUnread, boolean isSelected, boolean connectedToVoice, int unavailableGuildCount) {
            return new Item(_type, id2, channel, guild, mentionCount, isUnread, isSelected, connectedToVoice, unavailableGuildCount);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Item)) {
                return false;
            }
            Item item = (Item) other;
            return this._type == item._type && this.id == item.id && Intrinsics3.areEqual(this.channel, item.channel) && Intrinsics3.areEqual(this.guild, item.guild) && this.mentionCount == item.mentionCount && this.isUnread == item.isUnread && this.isSelected == item.isSelected && this.connectedToVoice == item.connectedToVoice && this.unavailableGuildCount == item.unavailableGuildCount;
        }

        public final Channel getChannel() {
            return this.channel;
        }

        public final boolean getConnectedToVoice() {
            return this.connectedToVoice;
        }

        public final Guild getGuild() {
            return this.guild;
        }

        public final long getId() {
            return this.id;
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
        public String getKey() {
            return this.key;
        }

        public final int getMentionCount() {
            return this.mentionCount;
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload
        public int getType() {
            return this.type;
        }

        public final int getUnavailableGuildCount() {
            return this.unavailableGuildCount;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            int iA = (b.a(this.id) + (this._type * 31)) * 31;
            Channel channel = this.channel;
            int iHashCode = (iA + (channel != null ? channel.hashCode() : 0)) * 31;
            Guild guild = this.guild;
            int iHashCode2 = (((iHashCode + (guild != null ? guild.hashCode() : 0)) * 31) + this.mentionCount) * 31;
            boolean z2 = this.isUnread;
            int i = z2;
            if (z2 != 0) {
                i = 1;
            }
            int i2 = (iHashCode2 + i) * 31;
            boolean z3 = this.isSelected;
            int i3 = z3;
            if (z3 != 0) {
                i3 = 1;
            }
            int i4 = (i2 + i3) * 31;
            boolean z4 = this.connectedToVoice;
            return ((i4 + (z4 ? 1 : z4 ? 1 : 0)) * 31) + this.unavailableGuildCount;
        }

        public final boolean isSelected() {
            return this.isSelected;
        }

        public final boolean isUnread() {
            return this.isUnread;
        }

        public String toString() {
            StringBuilder sbU = outline.U("Item(_type=");
            sbU.append(this._type);
            sbU.append(", id=");
            sbU.append(this.id);
            sbU.append(", channel=");
            sbU.append(this.channel);
            sbU.append(", guild=");
            sbU.append(this.guild);
            sbU.append(", mentionCount=");
            sbU.append(this.mentionCount);
            sbU.append(", isUnread=");
            sbU.append(this.isUnread);
            sbU.append(", isSelected=");
            sbU.append(this.isSelected);
            sbU.append(", connectedToVoice=");
            sbU.append(this.connectedToVoice);
            sbU.append(", unavailableGuildCount=");
            return outline.B(sbU, this.unavailableGuildCount, ")");
        }

        public /* synthetic */ Item(int i, long j, Channel channel, Guild guild, int i2, boolean z2, boolean z3, boolean z4, int i3, int i4, DefaultConstructorMarker defaultConstructorMarker) {
            this((i4 & 1) != 0 ? 0 : i, (i4 & 2) != 0 ? 0L : j, (i4 & 4) != 0 ? null : channel, (i4 & 8) == 0 ? guild : null, (i4 & 16) != 0 ? 0 : i2, (i4 & 32) != 0 ? false : z2, (i4 & 64) != 0 ? false : z3, (i4 & 128) != 0 ? false : z4, (i4 & 256) == 0 ? i3 : 0);
        }
    }
}
