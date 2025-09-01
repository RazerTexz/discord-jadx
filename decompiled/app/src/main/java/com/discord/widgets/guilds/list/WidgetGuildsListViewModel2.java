package com.discord.widgets.guilds.list;

import androidx.core.app.NotificationCompat;
import com.discord.api.channel.Channel;
import com.discord.models.domain.ModelNotificationSettings;
import com.discord.stores.StoreGuildsSorted;
import com.discord.stores.StoreStream;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.widgets.guilds.list.WidgetGuildsListViewModel;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import rx.Observable;
import rx.functions.Func9;

/* compiled from: WidgetGuildsListViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lrx/Observable;", "Lcom/discord/widgets/guilds/list/WidgetGuildsListViewModel$Companion$Chunk;", "invoke", "()Lrx/Observable;", "observeChunk"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.guilds.list.WidgetGuildsListViewModel$Companion$observeStores$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetGuildsListViewModel2 extends Lambda implements Function0<Observable<WidgetGuildsListViewModel.Companion.Chunk>> {
    public static final WidgetGuildsListViewModel2 INSTANCE = new WidgetGuildsListViewModel2();

    /* compiled from: WidgetGuildsListViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0017\u001a\n \u0002*\u0004\u0018\u00010\u00140\u00142\u0018\u0010\u0003\u001a\u0014 \u0002*\n\u0018\u00010\u0000j\u0004\u0018\u0001`\u00010\u0000j\u0002`\u00012\u0018\u0010\u0005\u001a\u0014 \u0002*\n\u0018\u00010\u0000j\u0004\u0018\u0001`\u00040\u0000j\u0002`\u00042.\u0010\b\u001a*\u0012\b\u0012\u00060\u0000j\u0002`\u0001\u0012\u0004\u0012\u00020\u0007 \u0002*\u0014\u0012\b\u0012\u00060\u0000j\u0002`\u0001\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00060\u00062\"\u0010\n\u001a\u001e\u0012\b\u0012\u00060\u0000j\u0002`\u0001 \u0002*\u000e\u0012\b\u0012\u00060\u0000j\u0002`\u0001\u0018\u00010\t0\t2.\u0010\f\u001a*\u0012\b\u0012\u00060\u0000j\u0002`\u0004\u0012\u0004\u0012\u00020\u000b \u0002*\u0014\u0012\b\u0012\u00060\u0000j\u0002`\u0004\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u00060\u00062B\u0010\u000e\u001a>\u0012\b\u0012\u00060\u0000j\u0002`\u0001\u0012\u000e\u0012\f\u0012\b\u0012\u00060\u0000j\u0002`\u00040\r \u0002*\u001e\u0012\b\u0012\u00060\u0000j\u0002`\u0001\u0012\u000e\u0012\f\u0012\b\u0012\u00060\u0000j\u0002`\u00040\r\u0018\u00010\u00060\u00062\"\u0010\u000f\u001a\u001e\u0012\b\u0012\u00060\u0000j\u0002`\u0001 \u0002*\u000e\u0012\b\u0012\u00060\u0000j\u0002`\u0001\u0018\u00010\t0\t2.\u0010\u0011\u001a*\u0012\b\u0012\u00060\u0000j\u0002`\u0004\u0012\u0004\u0012\u00020\u0010 \u0002*\u0014\u0012\b\u0012\u00060\u0000j\u0002`\u0004\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u00060\u00062\u001a\u0010\u0013\u001a\u0016\u0012\u0004\u0012\u00020\u0012 \u0002*\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\r0\rH\n¢\u0006\u0004\b\u0015\u0010\u0016"}, d2 = {"", "Lcom/discord/primitives/GuildId;", "kotlin.jvm.PlatformType", "selectedGuildId", "Lcom/discord/primitives/ChannelId;", "selectedVoiceChannelId", "", "Lcom/discord/models/domain/ModelNotificationSettings;", "guildSettings", "", "unreadGuildIds", "", "mentionCounts", "", "channelIds", "unavailableGuilds", "Lcom/discord/api/channel/Channel;", "privateChannels", "Lcom/discord/stores/StoreGuildsSorted$Entry;", "sortedGuilds", "Lcom/discord/widgets/guilds/list/WidgetGuildsListViewModel$Companion$Chunk;", NotificationCompat.CATEGORY_CALL, "(Ljava/lang/Long;Ljava/lang/Long;Ljava/util/Map;Ljava/util/Set;Ljava/util/Map;Ljava/util/Map;Ljava/util/Set;Ljava/util/Map;Ljava/util/List;)Lcom/discord/widgets/guilds/list/WidgetGuildsListViewModel$Companion$Chunk;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.guilds.list.WidgetGuildsListViewModel$Companion$observeStores$1$1, reason: invalid class name */
    public static final class AnonymousClass1<T1, T2, T3, T4, T5, T6, T7, T8, T9, R> implements Func9<Long, Long, Map<Long, ? extends ModelNotificationSettings>, Set<? extends Long>, Map<Long, ? extends Integer>, Map<Long, ? extends List<? extends Long>>, Set<? extends Long>, Map<Long, ? extends Channel>, List<? extends StoreGuildsSorted.Entry>, WidgetGuildsListViewModel.Companion.Chunk> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        @Override // rx.functions.Func9
        public /* bridge */ /* synthetic */ WidgetGuildsListViewModel.Companion.Chunk call(Long l, Long l2, Map<Long, ? extends ModelNotificationSettings> map, Set<? extends Long> set, Map<Long, ? extends Integer> map2, Map<Long, ? extends List<? extends Long>> map3, Set<? extends Long> set2, Map<Long, ? extends Channel> map4, List<? extends StoreGuildsSorted.Entry> list) {
            return call2(l, l2, map, (Set<Long>) set, (Map<Long, Integer>) map2, (Map<Long, ? extends List<Long>>) map3, (Set<Long>) set2, (Map<Long, Channel>) map4, list);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final WidgetGuildsListViewModel.Companion.Chunk call2(Long l, Long l2, Map<Long, ? extends ModelNotificationSettings> map, Set<Long> set, Map<Long, Integer> map2, Map<Long, ? extends List<Long>> map3, Set<Long> set2, Map<Long, Channel> map4, List<? extends StoreGuildsSorted.Entry> list) {
            Intrinsics3.checkNotNullExpressionValue(l, "selectedGuildId");
            long jLongValue = l.longValue();
            Intrinsics3.checkNotNullExpressionValue(l2, "selectedVoiceChannelId");
            long jLongValue2 = l2.longValue();
            Intrinsics3.checkNotNullExpressionValue(map, "guildSettings");
            Intrinsics3.checkNotNullExpressionValue(set, "unreadGuildIds");
            Intrinsics3.checkNotNullExpressionValue(map2, "mentionCounts");
            Intrinsics3.checkNotNullExpressionValue(map3, "channelIds");
            Intrinsics3.checkNotNullExpressionValue(set2, "unavailableGuilds");
            Intrinsics3.checkNotNullExpressionValue(map4, "privateChannels");
            Intrinsics3.checkNotNullExpressionValue(list, "sortedGuilds");
            return new WidgetGuildsListViewModel.Companion.Chunk(jLongValue, jLongValue2, map, set, map2, map3, set2, map4, list);
        }
    }

    public WidgetGuildsListViewModel2() {
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Observable<WidgetGuildsListViewModel.Companion.Chunk> invoke() {
        return invoke2();
    }

    @Override // kotlin.jvm.functions.Function0
    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Observable<WidgetGuildsListViewModel.Companion.Chunk> invoke2() {
        StoreStream.Companion companion = StoreStream.INSTANCE;
        Observable<WidgetGuildsListViewModel.Companion.Chunk> observableC = Observable.c(companion.getGuildSelected().observeSelectedGuildId(), companion.getVoiceChannelSelected().observeSelectedVoiceChannelId(), companion.getUserGuildSettings().observeGuildSettings(), companion.getReadStates().getUnreadGuildIds(), ObservableExtensionsKt.leadingEdgeThrottle(companion.getMentions().observeMentionCounts(), 500L, TimeUnit.MILLISECONDS).r(), companion.getChannels().observeIds(true), companion.getGuilds().observeUnavailableGuilds(), companion.getChannels().observePrivateChannels(), companion.getGuildsSorted().observeEntries(), AnonymousClass1.INSTANCE);
        Intrinsics3.checkNotNullExpressionValue(observableC, "Observable.combineLatest…lds\n          )\n        }");
        return observableC;
    }
}
