package com.discord.widgets.user;

import b.d.b.a.outline;
import com.discord.models.guild.Guild;
import com.discord.models.member.GuildMember;
import com.discord.stores.StoreGuilds;
import com.discord.stores.StoreGuildsSorted;
import com.discord.stores.StoreStream;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeck4;
import d0.d0._Ranges;
import d0.t.Iterables2;
import d0.t.MapsJVM;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* compiled from: UserMutualGuildsManager.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u001e\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B%\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u000f\u0012\b\b\u0002\u0010\r\u001a\u00020\f\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u0015\u0010\u0016J;\u0010\n\u001a\u001e\u0012\u001a\u0012\u0018\u0012\b\u0012\u00060\u0003j\u0002`\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u00070\u00062\u0010\u0010\u0005\u001a\f\u0012\b\u0012\u00060\u0003j\u0002`\u00040\u0002¢\u0006\u0004\b\n\u0010\u000bR\u0016\u0010\r\u001a\u00020\f8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u0010\u001a\u00020\u000f8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0013\u001a\u00020\u00128\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014¨\u0006\u0017"}, d2 = {"Lcom/discord/widgets/user/UserMutualGuildsManager;", "", "", "", "Lcom/discord/primitives/UserId;", "userIds", "Lrx/Observable;", "", "", "Lcom/discord/models/guild/Guild;", "observeMutualGuilds", "(Ljava/util/Collection;)Lrx/Observable;", "Lcom/discord/stores/StoreGuilds;", "storeGuilds", "Lcom/discord/stores/StoreGuilds;", "Lcom/discord/stores/StoreGuildsSorted;", "storeGuildsSorted", "Lcom/discord/stores/StoreGuildsSorted;", "Lcom/discord/stores/updates/ObservationDeck;", "observationDeck", "Lcom/discord/stores/updates/ObservationDeck;", "<init>", "(Lcom/discord/stores/StoreGuildsSorted;Lcom/discord/stores/StoreGuilds;Lcom/discord/stores/updates/ObservationDeck;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final class UserMutualGuildsManager {
    private final ObservationDeck observationDeck;
    private final StoreGuilds storeGuilds;
    private final StoreGuildsSorted storeGuildsSorted;

    /* compiled from: UserMutualGuildsManager.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0007\u001a\u0018\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0000H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"", "", "Lcom/discord/primitives/UserId;", "", "Lcom/discord/models/guild/Guild;", "invoke", "()Ljava/util/Map;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.user.UserMutualGuildsManager$observeMutualGuilds$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<Map<Long, ? extends List<? extends Guild>>> {
        public final /* synthetic */ Collection $userIds;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Collection collection) {
            super(0);
            this.$userIds = collection;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Map<Long, ? extends List<? extends Guild>> invoke() {
            return invoke2();
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Map<Long, ? extends List<? extends Guild>> invoke2() {
            LinkedHashMap<Long, Guild> orderedGuilds = UserMutualGuildsManager.access$getStoreGuildsSorted$p(UserMutualGuildsManager.this).getOrderedGuilds();
            Map<Long, Map<Long, GuildMember>> members = UserMutualGuildsManager.access$getStoreGuilds$p(UserMutualGuildsManager.this).getMembers();
            Collection<Guild> collectionValues = orderedGuilds.values();
            Collection<Number> collection = this.$userIds;
            LinkedHashMap linkedHashMap = new LinkedHashMap(_Ranges.coerceAtLeast(MapsJVM.mapCapacity(Iterables2.collectionSizeOrDefault(collection, 10)), 16));
            for (Number number : collection) {
                Long lValueOf = Long.valueOf(number.longValue());
                long jLongValue = number.longValue();
                Intrinsics3.checkNotNullExpressionValue(collectionValues, "guildsList");
                ArrayList arrayList = new ArrayList();
                for (Object obj : collectionValues) {
                    Map map = (Map) outline.e((Guild) obj, members);
                    if (map != null && map.containsKey(Long.valueOf(jLongValue))) {
                        arrayList.add(obj);
                    }
                }
                linkedHashMap.put(lValueOf, arrayList);
            }
            return linkedHashMap;
        }
    }

    public UserMutualGuildsManager() {
        this(null, null, null, 7, null);
    }

    public UserMutualGuildsManager(StoreGuildsSorted storeGuildsSorted, StoreGuilds storeGuilds, ObservationDeck observationDeck) {
        Intrinsics3.checkNotNullParameter(storeGuildsSorted, "storeGuildsSorted");
        Intrinsics3.checkNotNullParameter(storeGuilds, "storeGuilds");
        Intrinsics3.checkNotNullParameter(observationDeck, "observationDeck");
        this.storeGuildsSorted = storeGuildsSorted;
        this.storeGuilds = storeGuilds;
        this.observationDeck = observationDeck;
    }

    public static final /* synthetic */ StoreGuilds access$getStoreGuilds$p(UserMutualGuildsManager userMutualGuildsManager) {
        return userMutualGuildsManager.storeGuilds;
    }

    public static final /* synthetic */ StoreGuildsSorted access$getStoreGuildsSorted$p(UserMutualGuildsManager userMutualGuildsManager) {
        return userMutualGuildsManager.storeGuildsSorted;
    }

    public final Observable<Map<Long, List<Guild>>> observeMutualGuilds(Collection<Long> userIds) {
        Intrinsics3.checkNotNullParameter(userIds, "userIds");
        Observable<Map<Long, List<Guild>>> observableR = ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this.storeGuildsSorted, this.storeGuilds}, false, null, null, new AnonymousClass1(userIds), 14, null).r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "observationDeck.connectR…  .distinctUntilChanged()");
        return observableR;
    }

    public /* synthetic */ UserMutualGuildsManager(StoreGuildsSorted storeGuildsSorted, StoreGuilds storeGuilds, ObservationDeck observationDeck, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? StoreStream.INSTANCE.getGuildsSorted() : storeGuildsSorted, (i & 2) != 0 ? StoreStream.INSTANCE.getGuilds() : storeGuilds, (i & 4) != 0 ? ObservationDeck4.get() : observationDeck);
    }
}
