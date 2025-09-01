package com.discord.stores;

import android.content.Context;
import androidx.core.app.NotificationCompat;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.models.member.GuildMember;
import com.discord.models.user.MeUser;
import com.discord.models.user.User;
import com.discord.stores.StoreSearch;
import com.discord.stores.StoreStream;
import com.discord.stores.updates.ObservationDeck;
import com.discord.utilities.analytics.Traits;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.rx.ObservableWithLeadingEdgeThrottle;
import com.discord.utilities.search.validation.SearchData;
import d0.t.Maps6;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import j0.k.Func1;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function4;
import rx.Observable;
import rx.Subscription;
import rx.subjects.BehaviorSubject;
import rx.subjects.Subject;

/* compiled from: StoreSearchData.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010)\u001a\u00020(\u0012\u0006\u0010\u001d\u001a\u00020\u001c\u0012\u0006\u0010&\u001a\u00020%\u0012\u0006\u0010#\u001a\u00020\"¢\u0006\u0004\b,\u0010-J!\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003H\u0002¢\u0006\u0004\b\u0007\u0010\bJ!\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\n\u0010\n\u001a\u00060\u0002j\u0002`\tH\u0002¢\u0006\u0004\b\u000b\u0010\bJ\u0019\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u0015\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b\u0016\u0010\u0017J\u0013\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u0018\u0010\u0019J\r\u0010\u001a\u001a\u00020\u000e¢\u0006\u0004\b\u001a\u0010\u001bR\u0016\u0010\u001d\u001a\u00020\u001c8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\"\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u001f8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b \u0010!R\u0016\u0010#\u001a\u00020\"8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010&\u001a\u00020%8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b&\u0010'R\u0016\u0010)\u001a\u00020(8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b)\u0010*R\u0018\u0010\r\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\r\u0010+¨\u0006."}, d2 = {"Lcom/discord/stores/StoreSearchData;", "", "", "Lcom/discord/primitives/ChannelId;", "channelId", "Lrx/Observable;", "Lcom/discord/utilities/search/validation/SearchData;", "getChannelSearchData", "(J)Lrx/Observable;", "Lcom/discord/primitives/GuildId;", "guildId", "getGuildSearchData", "Lrx/Subscription;", Traits.Payment.Type.SUBSCRIPTION, "", "handleSubscription", "(Lrx/Subscription;)V", "searchData", "handleNewData", "(Lcom/discord/utilities/search/validation/SearchData;)V", "Lcom/discord/stores/StoreSearch$SearchTarget;", "searchTarget", "init", "(Lcom/discord/stores/StoreSearch$SearchTarget;)V", "get", "()Lrx/Observable;", "clear", "()V", "Lcom/discord/stores/StoreChannels;", "storeChannels", "Lcom/discord/stores/StoreChannels;", "Lrx/subjects/Subject;", "searchDataSubject", "Lrx/subjects/Subject;", "Lcom/discord/stores/StoreGuilds;", "storeGuilds", "Lcom/discord/stores/StoreGuilds;", "Lcom/discord/stores/StoreUser;", "storeUser", "Lcom/discord/stores/StoreUser;", "Lcom/discord/stores/updates/ObservationDeck;", "observationDeck", "Lcom/discord/stores/updates/ObservationDeck;", "Lrx/Subscription;", "<init>", "(Lcom/discord/stores/updates/ObservationDeck;Lcom/discord/stores/StoreChannels;Lcom/discord/stores/StoreUser;Lcom/discord/stores/StoreGuilds;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class StoreSearchData {
    private final ObservationDeck observationDeck;
    private final Subject<SearchData, SearchData> searchDataSubject;
    private final StoreChannels storeChannels;
    private final StoreGuilds storeGuilds;
    private final StoreUser storeUser;
    private Subscription subscription;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            StoreSearch.SearchTarget.Type.values();
            int[] iArr = new int[2];
            $EnumSwitchMapping$0 = iArr;
            iArr[StoreSearch.SearchTarget.Type.GUILD.ordinal()] = 1;
            iArr[StoreSearch.SearchTarget.Type.CHANNEL.ordinal()] = 2;
        }
    }

    /* compiled from: StoreSearchData.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lcom/discord/utilities/search/validation/SearchData;", "invoke", "()Lcom/discord/utilities/search/validation/SearchData;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreSearchData$getChannelSearchData$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<SearchData> {
        public final /* synthetic */ long $channelId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(long j) {
            super(0);
            this.$channelId = j;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ SearchData invoke() {
            return invoke();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final SearchData invoke() {
            Channel channel = StoreSearchData.access$getStoreChannels$p(StoreSearchData.this).getChannel(this.$channelId);
            MeUser meSnapshot = StoreSearchData.access$getStoreUser$p(StoreSearchData.this).getMeSnapshot();
            Map<Long, GuildMember> mapEmptyMap = StoreSearchData.access$getStoreGuilds$p(StoreSearchData.this).getMembers().get(channel != null ? Long.valueOf(channel.getGuildId()) : null);
            if (mapEmptyMap == null) {
                mapEmptyMap = Maps6.emptyMap();
            }
            return new SearchData.Builder().buildForChannel(channel, meSnapshot, mapEmptyMap);
        }
    }

    /* compiled from: StoreSearchData.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0010\b\u001a\"\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0003 \u0004*\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00000\u00002.\u0010\u0005\u001a*\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0012\u0004\u0012\u00020\u0003 \u0004*\u0014\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"", "", "Lcom/discord/primitives/ChannelId;", "Lcom/discord/api/channel/Channel;", "kotlin.jvm.PlatformType", "guildChannels", NotificationCompat.CATEGORY_CALL, "(Ljava/util/Map;)Ljava/util/Map;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreSearchData$getGuildSearchData$1, reason: invalid class name */
    public static final class AnonymousClass1<T, R> implements Func1<Map<Long, ? extends Channel>, Map<Long, ? extends Channel>> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        @Override // j0.k.Func1
        public /* bridge */ /* synthetic */ Map<Long, ? extends Channel> call(Map<Long, ? extends Channel> map) {
            return call2((Map<Long, Channel>) map);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final Map<Long, Channel> call2(Map<Long, Channel> map) {
            Intrinsics3.checkNotNullExpressionValue(map, "guildChannels");
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (Map.Entry<Long, Channel> entry : map.entrySet()) {
                if (ChannelUtils.v(entry.getValue())) {
                    linkedHashMap.put(entry.getKey(), entry.getValue());
                }
            }
            return linkedHashMap;
        }
    }

    /* compiled from: StoreSearchData.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\r\u001a\u00020\n2\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00020\u00002\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00040\u00002\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00060\u00002\u0016\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u0001\u0012\b\u0012\u00060\u0001j\u0002`\b0\u0000¢\u0006\u0004\b\u000b\u0010\f"}, d2 = {"", "", "Lcom/discord/models/member/GuildMember;", "p1", "Lcom/discord/models/user/User;", "p2", "Lcom/discord/api/channel/Channel;", "p3", "Lcom/discord/api/permission/PermissionBit;", "p4", "Lcom/discord/utilities/search/validation/SearchData;", "invoke", "(Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;)Lcom/discord/utilities/search/validation/SearchData;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreSearchData$getGuildSearchData$2, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass2 extends FunctionReferenceImpl implements Function4<Map<Long, ? extends GuildMember>, Map<Long, ? extends User>, Map<Long, ? extends Channel>, Map<Long, ? extends Long>, SearchData> {
        public AnonymousClass2(SearchData.Builder builder) {
            super(4, builder, SearchData.Builder.class, "buildForGuild", "buildForGuild(Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;)Lcom/discord/utilities/search/validation/SearchData;", 0);
        }

        @Override // kotlin.jvm.functions.Function4
        public /* bridge */ /* synthetic */ SearchData invoke(Map<Long, ? extends GuildMember> map, Map<Long, ? extends User> map2, Map<Long, ? extends Channel> map3, Map<Long, ? extends Long> map4) {
            return invoke2((Map<Long, GuildMember>) map, map2, (Map<Long, Channel>) map3, (Map<Long, Long>) map4);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final SearchData invoke2(Map<Long, GuildMember> map, Map<Long, ? extends User> map2, Map<Long, Channel> map3, Map<Long, Long> map4) {
            Intrinsics3.checkNotNullParameter(map, "p1");
            Intrinsics3.checkNotNullParameter(map2, "p2");
            Intrinsics3.checkNotNullParameter(map3, "p3");
            Intrinsics3.checkNotNullParameter(map4, "p4");
            return ((SearchData.Builder) this.receiver).buildForGuild(map, map2, map3, map4);
        }
    }

    /* compiled from: StoreSearchData.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lrx/Subscription;", "p1", "", "invoke", "(Lrx/Subscription;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreSearchData$init$1, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<Subscription, Unit> {
        public AnonymousClass1(StoreSearchData storeSearchData) {
            super(1, storeSearchData, StoreSearchData.class, "handleSubscription", "handleSubscription(Lrx/Subscription;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Subscription subscription) {
            invoke2(subscription);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Subscription subscription) {
            StoreSearchData.access$handleSubscription((StoreSearchData) this.receiver, subscription);
        }
    }

    /* compiled from: StoreSearchData.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/utilities/search/validation/SearchData;", "p1", "", "invoke", "(Lcom/discord/utilities/search/validation/SearchData;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreSearchData$init$2, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass2 extends FunctionReferenceImpl implements Function1<SearchData, Unit> {
        public AnonymousClass2(StoreSearchData storeSearchData) {
            super(1, storeSearchData, StoreSearchData.class, "handleNewData", "handleNewData(Lcom/discord/utilities/search/validation/SearchData;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(SearchData searchData) {
            invoke2(searchData);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(SearchData searchData) {
            Intrinsics3.checkNotNullParameter(searchData, "p1");
            StoreSearchData.access$handleNewData((StoreSearchData) this.receiver, searchData);
        }
    }

    public StoreSearchData(ObservationDeck observationDeck, StoreChannels storeChannels, StoreUser storeUser, StoreGuilds storeGuilds) {
        Intrinsics3.checkNotNullParameter(observationDeck, "observationDeck");
        Intrinsics3.checkNotNullParameter(storeChannels, "storeChannels");
        Intrinsics3.checkNotNullParameter(storeUser, "storeUser");
        Intrinsics3.checkNotNullParameter(storeGuilds, "storeGuilds");
        this.observationDeck = observationDeck;
        this.storeChannels = storeChannels;
        this.storeUser = storeUser;
        this.storeGuilds = storeGuilds;
        BehaviorSubject behaviorSubjectL0 = BehaviorSubject.l0(new SearchData(null, null, null, null, null, 31, null));
        Intrinsics3.checkNotNullExpressionValue(behaviorSubjectL0, "BehaviorSubject.create(SearchData())");
        this.searchDataSubject = behaviorSubjectL0;
    }

    public static final /* synthetic */ StoreChannels access$getStoreChannels$p(StoreSearchData storeSearchData) {
        return storeSearchData.storeChannels;
    }

    public static final /* synthetic */ StoreGuilds access$getStoreGuilds$p(StoreSearchData storeSearchData) {
        return storeSearchData.storeGuilds;
    }

    public static final /* synthetic */ StoreUser access$getStoreUser$p(StoreSearchData storeSearchData) {
        return storeSearchData.storeUser;
    }

    public static final /* synthetic */ void access$handleNewData(StoreSearchData storeSearchData, SearchData searchData) {
        storeSearchData.handleNewData(searchData);
    }

    public static final /* synthetic */ void access$handleSubscription(StoreSearchData storeSearchData, Subscription subscription) {
        storeSearchData.handleSubscription(subscription);
    }

    private final Observable<SearchData> getChannelSearchData(long channelId) {
        return ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this.storeChannels, this.storeUser, this.storeGuilds}, false, null, null, new AnonymousClass1(channelId), 14, null);
    }

    private final Observable<SearchData> getGuildSearchData(long guildId) {
        StoreStream.Companion companion = StoreStream.INSTANCE;
        Observable<SearchData> observableCombineLatest = ObservableWithLeadingEdgeThrottle.combineLatest(companion.getGuilds().observeComputed(guildId), companion.getUsers().observeAllUsers(), StoreChannels.observeChannelsForGuild$default(companion.getChannels(), guildId, null, 2, null).G(AnonymousClass1.INSTANCE), companion.getPermissions().observeChannelPermissionsForGuild(guildId), new StoreSearchData2(new AnonymousClass2(new SearchData.Builder())), 3L, TimeUnit.SECONDS);
        Intrinsics3.checkNotNullExpressionValue(observableCombineLatest, "ObservableWithLeadingEdg…3, TimeUnit.SECONDS\n    )");
        return observableCombineLatest;
    }

    private final void handleNewData(SearchData searchData) {
        this.searchDataSubject.onNext(searchData);
    }

    private final synchronized void handleSubscription(Subscription subscription) {
        Subscription subscription2 = this.subscription;
        if (subscription2 != null) {
            subscription2.unsubscribe();
        }
        this.subscription = subscription;
    }

    public final void clear() {
        handleSubscription(null);
        handleNewData(new SearchData(null, null, null, null, null, 31, null));
    }

    public final Observable<SearchData> get() {
        return this.searchDataSubject;
    }

    public final void init(StoreSearch.SearchTarget searchTarget) {
        Observable<SearchData> guildSearchData;
        Intrinsics3.checkNotNullParameter(searchTarget, "searchTarget");
        int iOrdinal = searchTarget.getType().ordinal();
        if (iOrdinal == 0) {
            guildSearchData = getGuildSearchData(searchTarget.getId());
        } else {
            if (iOrdinal != 1) {
                throw new NoWhenBranchMatchedException();
            }
            guildSearchData = getChannelSearchData(searchTarget.getId());
        }
        Observable observableR = ObservableExtensionsKt.computationBuffered(guildSearchData).r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "searchDataObservable\n   …  .distinctUntilChanged()");
        ObservableExtensionsKt.appSubscribe$default(observableR, StoreSearchData.class, (Context) null, new AnonymousClass1(this), (Function1) null, (Function0) null, (Function0) null, new AnonymousClass2(this), 58, (Object) null);
    }
}
