package com.discord.stores;

import com.discord.api.guild.Guild;
import com.discord.api.guildmember.GuildMember;
import com.discord.api.sticker.GuildStickersUpdate;
import com.discord.api.sticker.Sticker;
import com.discord.api.sticker.StickerType;
import com.discord.models.domain.ModelPayload;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeck4;
import d0.d0._Ranges;
import d0.t.Collections2;
import d0.t.Iterables2;
import d0.t.Maps6;
import d0.t.MapsJVM;
import d0.t._Collections;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* compiled from: StoreGuildStickers.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010%\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B7\u0012\u0006\u00104\u001a\u000203\u0012\b\b\u0002\u0010?\u001a\u00020>\u0012\u001c\u00107\u001a\u0018\u0012\u000e\u0012\f\u0012\b\u0012\u00060\u0002j\u0002`\f0\u0010\u0012\u0004\u0012\u00020\b06¢\u0006\u0004\bB\u0010CJ)\u0010\t\u001a\u00020\b2\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u00032\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0002¢\u0006\u0004\b\t\u0010\nJ1\u0010\u000e\u001a&\u0012\b\u0012\u00060\u0002j\u0002`\u0003\u0012\u0018\u0012\u0016\u0012\b\u0012\u00060\u0002j\u0002`\f\u0012\u0004\u0012\u00020\u00060\u000bj\u0002`\r0\u000b¢\u0006\u0004\b\u000e\u0010\u000fJ\u0013\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00060\u0010¢\u0006\u0004\b\u0011\u0010\u0012J-\u0010\u0013\u001a\u0016\u0012\b\u0012\u00060\u0002j\u0002`\f\u0012\u0004\u0012\u00020\u00060\u000bj\u0002`\r2\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003¢\u0006\u0004\b\u0013\u0010\u0014J\u001b\u0010\u0016\u001a\u0004\u0018\u00010\u00062\n\u0010\u0015\u001a\u00060\u0002j\u0002`\f¢\u0006\u0004\b\u0016\u0010\u0017J3\u0010\u0018\u001a&\u0012\b\u0012\u00060\u0002j\u0002`\u0003\u0012\u0018\u0012\u0016\u0012\b\u0012\u00060\u0002j\u0002`\f\u0012\u0004\u0012\u00020\u00060\u000bj\u0002`\r0\u000bH\u0007¢\u0006\u0004\b\u0018\u0010\u000fJ3\u0010\u0019\u001a\u001a\u0012\b\u0012\u00060\u0002j\u0002`\f\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u000bj\u0004\u0018\u0001`\r2\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003H\u0007¢\u0006\u0004\b\u0019\u0010\u0014J7\u0010\u001b\u001a,\u0012(\u0012&\u0012\b\u0012\u00060\u0002j\u0002`\u0003\u0012\u0018\u0012\u0016\u0012\b\u0012\u00060\u0002j\u0002`\f\u0012\u0004\u0012\u00020\u00060\u000bj\u0002`\r0\u000b0\u001a¢\u0006\u0004\b\u001b\u0010\u001cJ\u0017\u0010\u001f\u001a\u00020\b2\u0006\u0010\u001e\u001a\u00020\u001dH\u0007¢\u0006\u0004\b\u001f\u0010 J\u0019\u0010#\u001a\u0004\u0018\u00010\b2\u0006\u0010\"\u001a\u00020!H\u0007¢\u0006\u0004\b#\u0010$J\u001b\u0010%\u001a\u00020\b2\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003H\u0007¢\u0006\u0004\b%\u0010&J\u0017\u0010)\u001a\u00020\b2\u0006\u0010(\u001a\u00020'H\u0007¢\u0006\u0004\b)\u0010*J\u0017\u0010,\u001a\u00020\b2\b\u0010+\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b,\u0010-J\u000f\u0010.\u001a\u00020\bH\u0016¢\u0006\u0004\b.\u0010/R:\u00101\u001a&\u0012\b\u0012\u00060\u0002j\u0002`\u0003\u0012\u0018\u0012\u0016\u0012\b\u0012\u00060\u0002j\u0002`\f\u0012\u0004\u0012\u00020\u00060\u000bj\u0002`\r008\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b1\u00102R\u0016\u00104\u001a\u0002038\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b4\u00105R,\u00107\u001a\u0018\u0012\u000e\u0012\f\u0012\b\u0012\u00060\u0002j\u0002`\f0\u0010\u0012\u0004\u0012\u00020\b068\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b7\u00108R\u001a\u0010:\u001a\u00060\u0002j\u0002`98\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b:\u0010;R\u001c\u0010<\u001a\b\u0012\u0004\u0012\u00020\u00060\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b<\u0010=R\u0016\u0010?\u001a\u00020>8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b?\u0010@R:\u0010A\u001a&\u0012\b\u0012\u00060\u0002j\u0002`\u0003\u0012\u0018\u0012\u0016\u0012\b\u0012\u00060\u0002j\u0002`\f\u0012\u0004\u0012\u00020\u00060\u000bj\u0002`\r0\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bA\u00102¨\u0006D"}, d2 = {"Lcom/discord/stores/StoreGuildStickers;", "Lcom/discord/stores/StoreV2;", "", "Lcom/discord/primitives/GuildId;", "guildId", "", "Lcom/discord/api/sticker/Sticker;", "stickers", "", "updateStickers", "(JLjava/util/Collection;)V", "", "Lcom/discord/primitives/StickerId;", "Lcom/discord/stores/StickerMap;", "getAllGuildStickers", "()Ljava/util/Map;", "", "getAllGuildStickersFlattened", "()Ljava/util/List;", "getStickersForGuild", "(J)Ljava/util/Map;", "stickerId", "getGuildSticker", "(J)Lcom/discord/api/sticker/Sticker;", "getAllGuildStickersInternal", "getStickersForGuildInternal", "Lrx/Observable;", "observeGuildStickers", "()Lrx/Observable;", "Lcom/discord/models/domain/ModelPayload;", "payload", "handleConnectionOpen", "(Lcom/discord/models/domain/ModelPayload;)V", "Lcom/discord/api/guild/Guild;", "guild", "handleGuildCreateOrUpdate", "(Lcom/discord/api/guild/Guild;)Lkotlin/Unit;", "handleGuildRemove", "(J)V", "Lcom/discord/api/sticker/GuildStickersUpdate;", "stickersUpdate", "handleStickerUpdate", "(Lcom/discord/api/sticker/GuildStickersUpdate;)V", "sticker", "handleFetchedSticker", "(Lcom/discord/api/sticker/Sticker;)V", "snapshotData", "()V", "", "allGuildStickers", "Ljava/util/Map;", "Lcom/discord/stores/Dispatcher;", "dispatcher", "Lcom/discord/stores/Dispatcher;", "Lkotlin/Function1;", "onStickersDeleted", "Lkotlin/jvm/functions/Function1;", "Lcom/discord/primitives/UserId;", "me", "J", "allGuildStickersFlattenedSnapshot", "Ljava/util/List;", "Lcom/discord/stores/updates/ObservationDeck;", "observationDeck", "Lcom/discord/stores/updates/ObservationDeck;", "allGuildStickersSnapshot", "<init>", "(Lcom/discord/stores/Dispatcher;Lcom/discord/stores/updates/ObservationDeck;Lkotlin/jvm/functions/Function1;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class StoreGuildStickers extends StoreV2 {
    private final Map<Long, Map<Long, Sticker>> allGuildStickers;
    private List<Sticker> allGuildStickersFlattenedSnapshot;
    private Map<Long, ? extends Map<Long, Sticker>> allGuildStickersSnapshot;
    private final Dispatcher dispatcher;
    private long me;
    private final ObservationDeck observationDeck;
    private final Function1<List<Long>, Unit> onStickersDeleted;

    /* compiled from: StoreGuildStickers.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreGuildStickers$handleFetchedSticker$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ long $guildId;
        public final /* synthetic */ Sticker $sticker;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(long j, Sticker sticker) {
            super(0);
            this.$guildId = j;
            this.$sticker = sticker;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            Map mapEmptyMap = (Map) StoreGuildStickers.access$getAllGuildStickers$p(StoreGuildStickers.this).get(Long.valueOf(this.$guildId));
            if (mapEmptyMap == null) {
                mapEmptyMap = Maps6.emptyMap();
            }
            linkedHashMap.putAll(mapEmptyMap);
            linkedHashMap.put(Long.valueOf(this.$sticker.getId()), this.$sticker);
            StoreGuildStickers.access$getAllGuildStickers$p(StoreGuildStickers.this).put(Long.valueOf(this.$guildId), linkedHashMap);
            StoreGuildStickers.this.markChanged();
        }
    }

    /* compiled from: StoreGuildStickers.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\b\u001a&\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0012\u0018\u0012\u0016\u0012\b\u0012\u00060\u0001j\u0002`\u0003\u0012\u0004\u0012\u00020\u00040\u0000j\u0002`\u00050\u0000H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"", "", "Lcom/discord/primitives/GuildId;", "Lcom/discord/primitives/StickerId;", "Lcom/discord/api/sticker/Sticker;", "Lcom/discord/stores/StickerMap;", "invoke", "()Ljava/util/Map;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreGuildStickers$observeGuildStickers$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<Map<Long, ? extends Map<Long, ? extends Sticker>>> {
        public AnonymousClass1() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Map<Long, ? extends Map<Long, ? extends Sticker>> invoke() {
            return invoke2();
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Map<Long, ? extends Map<Long, ? extends Sticker>> invoke2() {
            return StoreGuildStickers.access$getAllGuildStickersSnapshot$p(StoreGuildStickers.this);
        }
    }

    public /* synthetic */ StoreGuildStickers(Dispatcher dispatcher, ObservationDeck observationDeck, Function1 function1, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(dispatcher, (i & 2) != 0 ? ObservationDeck4.get() : observationDeck, function1);
    }

    public static final /* synthetic */ Map access$getAllGuildStickers$p(StoreGuildStickers storeGuildStickers) {
        return storeGuildStickers.allGuildStickers;
    }

    public static final /* synthetic */ Map access$getAllGuildStickersSnapshot$p(StoreGuildStickers storeGuildStickers) {
        return storeGuildStickers.allGuildStickersSnapshot;
    }

    public static final /* synthetic */ void access$setAllGuildStickersSnapshot$p(StoreGuildStickers storeGuildStickers, Map map) {
        storeGuildStickers.allGuildStickersSnapshot = map;
    }

    private final void updateStickers(long guildId, Collection<Sticker> stickers) {
        if (stickers.isEmpty()) {
            this.allGuildStickers.remove(Long.valueOf(guildId));
        } else {
            Map<Long, Map<Long, Sticker>> map = this.allGuildStickers;
            Long lValueOf = Long.valueOf(guildId);
            LinkedHashMap linkedHashMap = new LinkedHashMap(_Ranges.coerceAtLeast(MapsJVM.mapCapacity(Iterables2.collectionSizeOrDefault(stickers, 10)), 16));
            for (Object obj : stickers) {
                linkedHashMap.put(Long.valueOf(((Sticker) obj).getId()), obj);
            }
            map.put(lValueOf, linkedHashMap);
        }
        markChanged();
    }

    public final Map<Long, Map<Long, Sticker>> getAllGuildStickers() {
        return this.allGuildStickersSnapshot;
    }

    public final List<Sticker> getAllGuildStickersFlattened() {
        return this.allGuildStickersFlattenedSnapshot;
    }

    @Store3
    public final Map<Long, Map<Long, Sticker>> getAllGuildStickersInternal() {
        return this.allGuildStickers;
    }

    public final Sticker getGuildSticker(long stickerId) {
        Object next;
        Iterator<T> it = getAllGuildStickers().values().iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (((Map) next).containsKey(Long.valueOf(stickerId))) {
                break;
            }
        }
        Map map = (Map) next;
        if (map != null) {
            return (Sticker) map.get(Long.valueOf(stickerId));
        }
        return null;
    }

    public final Map<Long, Sticker> getStickersForGuild(long guildId) {
        Map<Long, Sticker> map = getAllGuildStickers().get(Long.valueOf(guildId));
        return map != null ? map : Maps6.emptyMap();
    }

    @Store3
    public final Map<Long, Sticker> getStickersForGuildInternal(long guildId) {
        return this.allGuildStickers.get(Long.valueOf(guildId));
    }

    @Store3
    public final void handleConnectionOpen(ModelPayload payload) {
        Intrinsics3.checkNotNullParameter(payload, "payload");
        this.me = payload.getMe().getId();
        for (Guild guild : payload.getGuilds()) {
            Intrinsics3.checkNotNullExpressionValue(guild, "guild");
            handleGuildCreateOrUpdate(guild);
        }
    }

    public final void handleFetchedSticker(Sticker sticker) {
        Long guildId;
        if (sticker == null || sticker.getType() != StickerType.GUILD || (guildId = sticker.getGuildId()) == null) {
            return;
        }
        this.dispatcher.schedule(new AnonymousClass1(guildId.longValue(), sticker));
    }

    @Store3
    public final Unit handleGuildCreateOrUpdate(Guild guild) {
        Object next;
        Intrinsics3.checkNotNullParameter(guild, "guild");
        List<GuildMember> listV = guild.v();
        if (listV == null) {
            return null;
        }
        Iterator<T> it = listV.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (((GuildMember) next).getUser().getId() == this.me) {
                break;
            }
        }
        if (((GuildMember) next) == null) {
            return null;
        }
        long id2 = guild.getId();
        List<Sticker> listK = guild.K();
        if (listK == null) {
            listK = Collections2.emptyList();
        }
        updateStickers(id2, listK);
        return Unit.a;
    }

    @Store3
    public final void handleGuildRemove(long guildId) {
        if (this.allGuildStickers.containsKey(Long.valueOf(guildId))) {
            this.allGuildStickers.remove(Long.valueOf(guildId));
            markChanged();
        }
    }

    @Store3
    public final void handleStickerUpdate(GuildStickersUpdate stickersUpdate) {
        Collection collectionEmptyList;
        Intrinsics3.checkNotNullParameter(stickersUpdate, "stickersUpdate");
        long guildId = stickersUpdate.getGuildId();
        List<Sticker> listC = stickersUpdate.c();
        ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(listC, 10));
        Iterator<T> it = listC.iterator();
        while (it.hasNext()) {
            arrayList.add(Long.valueOf(((Sticker) it.next()).getId()));
        }
        Set set = _Collections.toSet(arrayList);
        Map<Long, Sticker> map = this.allGuildStickersSnapshot.get(Long.valueOf(guildId));
        if (map != null) {
            collectionEmptyList = new ArrayList(map.size());
            Iterator<Map.Entry<Long, Sticker>> it2 = map.entrySet().iterator();
            while (it2.hasNext()) {
                collectionEmptyList.add(Long.valueOf(it2.next().getKey().longValue()));
            }
        } else {
            collectionEmptyList = Collections2.emptyList();
        }
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : collectionEmptyList) {
            if (!set.contains(Long.valueOf(((Number) obj).longValue()))) {
                arrayList2.add(obj);
            }
        }
        updateStickers(guildId, listC);
        this.onStickersDeleted.invoke(arrayList2);
    }

    public final Observable<Map<Long, Map<Long, Sticker>>> observeGuildStickers() {
        Observable<Map<Long, Map<Long, Sticker>>> observableR = ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, false, null, null, new AnonymousClass1(), 14, null).r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "observationDeck.connectR… }.distinctUntilChanged()");
        return observableR;
    }

    @Override // com.discord.stores.StoreV2
    public void snapshotData() {
        super.snapshotData();
        ArrayList arrayList = new ArrayList();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<Long, Map<Long, Sticker>> entry : this.allGuildStickers.entrySet()) {
            long jLongValue = entry.getKey().longValue();
            Map<Long, Sticker> value = entry.getValue();
            linkedHashMap.put(Long.valueOf(jLongValue), Maps6.toMap(value));
            arrayList.addAll(value.values());
        }
        this.allGuildStickersSnapshot = linkedHashMap;
        this.allGuildStickersFlattenedSnapshot = _Collections.toList(arrayList);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public StoreGuildStickers(Dispatcher dispatcher, ObservationDeck observationDeck, Function1<? super List<Long>, Unit> function1) {
        Intrinsics3.checkNotNullParameter(dispatcher, "dispatcher");
        Intrinsics3.checkNotNullParameter(observationDeck, "observationDeck");
        Intrinsics3.checkNotNullParameter(function1, "onStickersDeleted");
        this.dispatcher = dispatcher;
        this.observationDeck = observationDeck;
        this.onStickersDeleted = function1;
        this.allGuildStickers = new LinkedHashMap();
        this.allGuildStickersSnapshot = Maps6.emptyMap();
        this.allGuildStickersFlattenedSnapshot = Collections2.emptyList();
    }
}
