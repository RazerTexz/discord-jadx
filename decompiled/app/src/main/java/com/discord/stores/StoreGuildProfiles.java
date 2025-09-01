package com.discord.stores;

import android.content.Context;
import b.d.b.a.outline;
import com.discord.api.guild.preview.GuildPreview;
import com.discord.stores.updates.ObservationDeck;
import com.discord.utilities.error.Error;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import rx.Observable;

/* compiled from: StoreGuildProfiles.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010%\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0002\"#B\u0017\u0012\u0006\u0010\u001e\u001a\u00020\u001d\u0012\u0006\u0010\u0019\u001a\u00020\u0018¢\u0006\u0004\b \u0010!J\u001b\u0010\u0006\u001a\u00020\u00052\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003H\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u001b\u0010\b\u001a\u00020\u00052\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003H\u0003¢\u0006\u0004\b\b\u0010\u0007J\u0017\u0010\u000b\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\tH\u0003¢\u0006\u0004\b\u000b\u0010\fJ\u001b\u0010\r\u001a\u00020\u00052\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003H\u0003¢\u0006\u0004\b\r\u0010\u0007J\u001b\u0010\u000e\u001a\u00020\u00052\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003H\u0003¢\u0006\u0004\b\u000e\u0010\u0007J!\u0010\u0011\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u000f2\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u0005H\u0017¢\u0006\u0004\b\u0013\u0010\u0014R&\u0010\u0016\u001a\u0012\u0012\b\u0012\u00060\u0002j\u0002`\u0003\u0012\u0004\u0012\u00020\u00100\u00158\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u0019\u001a\u00020\u00188\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR&\u0010\u001c\u001a\u0012\u0012\b\u0012\u00060\u0002j\u0002`\u0003\u0012\u0004\u0012\u00020\u00100\u001b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010\u0017R\u0016\u0010\u001e\u001a\u00020\u001d8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001f¨\u0006$"}, d2 = {"Lcom/discord/stores/StoreGuildProfiles;", "Lcom/discord/stores/StoreV2;", "", "Lcom/discord/primitives/GuildId;", "guildId", "", "fetchGuildProfile", "(J)V", "fetchIfNonexisting", "Lcom/discord/api/guild/preview/GuildPreview;", "guildPreview", "handleGuildProfileFetchSuccess", "(Lcom/discord/api/guild/preview/GuildPreview;)V", "handleGuildProfileFetchStart", "handleGuildProfileFetchFailed", "Lrx/Observable;", "Lcom/discord/stores/StoreGuildProfiles$GuildProfileData;", "observeGuildProfile", "(J)Lrx/Observable;", "snapshotData", "()V", "", "guildProfilesState", "Ljava/util/Map;", "Lcom/discord/stores/updates/ObservationDeck;", "observationDeck", "Lcom/discord/stores/updates/ObservationDeck;", "", "guildProfilesStateSnapshot", "Lcom/discord/stores/Dispatcher;", "dispatcher", "Lcom/discord/stores/Dispatcher;", "<init>", "(Lcom/discord/stores/Dispatcher;Lcom/discord/stores/updates/ObservationDeck;)V", "FetchStates", "GuildProfileData", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class StoreGuildProfiles extends StoreV2 {
    private final Dispatcher dispatcher;
    private final Map<Long, GuildProfileData> guildProfilesState;
    private Map<Long, GuildProfileData> guildProfilesStateSnapshot;
    private final ObservationDeck observationDeck;

    /* compiled from: StoreGuildProfiles.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/discord/stores/StoreGuildProfiles$FetchStates;", "", "<init>", "(Ljava/lang/String;I)V", "FETCHING", "FAILED", "SUCCEEDED", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public enum FetchStates {
        FETCHING,
        FAILED,
        SUCCEEDED
    }

    /* compiled from: StoreGuildProfiles.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J&\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00022\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015R\u0019\u0010\b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\u0016\u001a\u0004\b\u0017\u0010\u0004R\u001b\u0010\t\u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\u0018\u001a\u0004\b\u0019\u0010\u0007¨\u0006\u001c"}, d2 = {"Lcom/discord/stores/StoreGuildProfiles$GuildProfileData;", "", "Lcom/discord/stores/StoreGuildProfiles$FetchStates;", "component1", "()Lcom/discord/stores/StoreGuildProfiles$FetchStates;", "Lcom/discord/api/guild/preview/GuildPreview;", "component2", "()Lcom/discord/api/guild/preview/GuildPreview;", "fetchState", "data", "copy", "(Lcom/discord/stores/StoreGuildProfiles$FetchStates;Lcom/discord/api/guild/preview/GuildPreview;)Lcom/discord/stores/StoreGuildProfiles$GuildProfileData;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/discord/stores/StoreGuildProfiles$FetchStates;", "getFetchState", "Lcom/discord/api/guild/preview/GuildPreview;", "getData", "<init>", "(Lcom/discord/stores/StoreGuildProfiles$FetchStates;Lcom/discord/api/guild/preview/GuildPreview;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class GuildProfileData {
        private final GuildPreview data;
        private final FetchStates fetchState;

        public GuildProfileData(FetchStates fetchStates, GuildPreview guildPreview) {
            Intrinsics3.checkNotNullParameter(fetchStates, "fetchState");
            this.fetchState = fetchStates;
            this.data = guildPreview;
        }

        public static /* synthetic */ GuildProfileData copy$default(GuildProfileData guildProfileData, FetchStates fetchStates, GuildPreview guildPreview, int i, Object obj) {
            if ((i & 1) != 0) {
                fetchStates = guildProfileData.fetchState;
            }
            if ((i & 2) != 0) {
                guildPreview = guildProfileData.data;
            }
            return guildProfileData.copy(fetchStates, guildPreview);
        }

        /* renamed from: component1, reason: from getter */
        public final FetchStates getFetchState() {
            return this.fetchState;
        }

        /* renamed from: component2, reason: from getter */
        public final GuildPreview getData() {
            return this.data;
        }

        public final GuildProfileData copy(FetchStates fetchState, GuildPreview data) {
            Intrinsics3.checkNotNullParameter(fetchState, "fetchState");
            return new GuildProfileData(fetchState, data);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof GuildProfileData)) {
                return false;
            }
            GuildProfileData guildProfileData = (GuildProfileData) other;
            return Intrinsics3.areEqual(this.fetchState, guildProfileData.fetchState) && Intrinsics3.areEqual(this.data, guildProfileData.data);
        }

        public final GuildPreview getData() {
            return this.data;
        }

        public final FetchStates getFetchState() {
            return this.fetchState;
        }

        public int hashCode() {
            FetchStates fetchStates = this.fetchState;
            int iHashCode = (fetchStates != null ? fetchStates.hashCode() : 0) * 31;
            GuildPreview guildPreview = this.data;
            return iHashCode + (guildPreview != null ? guildPreview.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbU = outline.U("GuildProfileData(fetchState=");
            sbU.append(this.fetchState);
            sbU.append(", data=");
            sbU.append(this.data);
            sbU.append(")");
            return sbU.toString();
        }
    }

    /* compiled from: StoreGuildProfiles.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreGuildProfiles$fetchGuildProfile$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ long $guildId;

        /* compiled from: StoreGuildProfiles.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/api/guild/preview/GuildPreview;", "guildPreview", "", "invoke", "(Lcom/discord/api/guild/preview/GuildPreview;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
        /* renamed from: com.discord.stores.StoreGuildProfiles$fetchGuildProfile$1$1, reason: invalid class name and collision with other inner class name */
        public static final class C01241 extends Lambda implements Function1<GuildPreview, Unit> {

            /* compiled from: StoreGuildProfiles.kt */
            @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
            /* renamed from: com.discord.stores.StoreGuildProfiles$fetchGuildProfile$1$1$1, reason: invalid class name and collision with other inner class name */
            public static final class C01251 extends Lambda implements Function0<Unit> {
                public final /* synthetic */ GuildPreview $guildPreview;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public C01251(GuildPreview guildPreview) {
                    super(0);
                    this.$guildPreview = guildPreview;
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.a;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    StoreGuildProfiles.access$handleGuildProfileFetchSuccess(StoreGuildProfiles.this, this.$guildPreview);
                }
            }

            public C01241() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(GuildPreview guildPreview) {
                invoke2(guildPreview);
                return Unit.a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(GuildPreview guildPreview) {
                Intrinsics3.checkNotNullParameter(guildPreview, "guildPreview");
                StoreGuildProfiles.access$getDispatcher$p(StoreGuildProfiles.this).schedule(new C01251(guildPreview));
            }
        }

        /* compiled from: StoreGuildProfiles.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/utilities/error/Error;", "it", "", "invoke", "(Lcom/discord/utilities/error/Error;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
        /* renamed from: com.discord.stores.StoreGuildProfiles$fetchGuildProfile$1$2, reason: invalid class name */
        public static final class AnonymousClass2 extends Lambda implements Function1<Error, Unit> {

            /* compiled from: StoreGuildProfiles.kt */
            @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
            /* renamed from: com.discord.stores.StoreGuildProfiles$fetchGuildProfile$1$2$1, reason: invalid class name and collision with other inner class name */
            public static final class C01261 extends Lambda implements Function0<Unit> {
                public C01261() {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.a;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                    StoreGuildProfiles.access$handleGuildProfileFetchFailed(StoreGuildProfiles.this, anonymousClass1.$guildId);
                }
            }

            public AnonymousClass2() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Error error) {
                invoke2(error);
                return Unit.a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Error error) {
                Intrinsics3.checkNotNullParameter(error, "it");
                StoreGuildProfiles.access$getDispatcher$p(StoreGuildProfiles.this).schedule(new C01261());
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(long j) {
            super(0);
            this.$guildId = j;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            GuildProfileData guildProfileData = (GuildProfileData) StoreGuildProfiles.access$getGuildProfilesState$p(StoreGuildProfiles.this).get(Long.valueOf(this.$guildId));
            if ((guildProfileData != null ? guildProfileData.getFetchState() : null) == FetchStates.FETCHING) {
                return;
            }
            StoreGuildProfiles.access$handleGuildProfileFetchStart(StoreGuildProfiles.this, this.$guildId);
            ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.INSTANCE.getApi().getGuildPreview(this.$guildId), false, 1, null), StoreGuildProfiles.this.getClass(), (Context) null, (Function1) null, new AnonymousClass2(), (Function0) null, (Function0) null, new C01241(), 54, (Object) null);
        }
    }

    /* compiled from: StoreGuildProfiles.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreGuildProfiles$observeGuildProfile$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ long $guildId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(long j) {
            super(0);
            this.$guildId = j;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            StoreGuildProfiles.access$fetchIfNonexisting(StoreGuildProfiles.this, this.$guildId);
        }
    }

    /* compiled from: StoreGuildProfiles.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lcom/discord/stores/StoreGuildProfiles$GuildProfileData;", "invoke", "()Lcom/discord/stores/StoreGuildProfiles$GuildProfileData;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreGuildProfiles$observeGuildProfile$2, reason: invalid class name */
    public static final class AnonymousClass2 extends Lambda implements Function0<GuildProfileData> {
        public final /* synthetic */ long $guildId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(long j) {
            super(0);
            this.$guildId = j;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ GuildProfileData invoke() {
            return invoke();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final GuildProfileData invoke() {
            return (GuildProfileData) StoreGuildProfiles.access$getGuildProfilesStateSnapshot$p(StoreGuildProfiles.this).get(Long.valueOf(this.$guildId));
        }
    }

    public StoreGuildProfiles(Dispatcher dispatcher, ObservationDeck observationDeck) {
        Intrinsics3.checkNotNullParameter(dispatcher, "dispatcher");
        Intrinsics3.checkNotNullParameter(observationDeck, "observationDeck");
        this.dispatcher = dispatcher;
        this.observationDeck = observationDeck;
        this.guildProfilesState = new HashMap();
        this.guildProfilesStateSnapshot = new HashMap();
    }

    public static final /* synthetic */ void access$fetchIfNonexisting(StoreGuildProfiles storeGuildProfiles, long j) {
        storeGuildProfiles.fetchIfNonexisting(j);
    }

    public static final /* synthetic */ Dispatcher access$getDispatcher$p(StoreGuildProfiles storeGuildProfiles) {
        return storeGuildProfiles.dispatcher;
    }

    public static final /* synthetic */ Map access$getGuildProfilesState$p(StoreGuildProfiles storeGuildProfiles) {
        return storeGuildProfiles.guildProfilesState;
    }

    public static final /* synthetic */ Map access$getGuildProfilesStateSnapshot$p(StoreGuildProfiles storeGuildProfiles) {
        return storeGuildProfiles.guildProfilesStateSnapshot;
    }

    public static final /* synthetic */ void access$handleGuildProfileFetchFailed(StoreGuildProfiles storeGuildProfiles, long j) {
        storeGuildProfiles.handleGuildProfileFetchFailed(j);
    }

    public static final /* synthetic */ void access$handleGuildProfileFetchStart(StoreGuildProfiles storeGuildProfiles, long j) {
        storeGuildProfiles.handleGuildProfileFetchStart(j);
    }

    public static final /* synthetic */ void access$handleGuildProfileFetchSuccess(StoreGuildProfiles storeGuildProfiles, GuildPreview guildPreview) {
        storeGuildProfiles.handleGuildProfileFetchSuccess(guildPreview);
    }

    public static final /* synthetic */ void access$setGuildProfilesStateSnapshot$p(StoreGuildProfiles storeGuildProfiles, Map map) {
        storeGuildProfiles.guildProfilesStateSnapshot = map;
    }

    @Store3
    private final void fetchGuildProfile(long guildId) {
        this.dispatcher.schedule(new AnonymousClass1(guildId));
    }

    @Store3
    private final void fetchIfNonexisting(long guildId) {
        GuildProfileData guildProfileData = this.guildProfilesState.get(Long.valueOf(guildId));
        if (guildProfileData == null || guildProfileData.getFetchState() == FetchStates.FAILED) {
            fetchGuildProfile(guildId);
        }
    }

    @Store3
    private final void handleGuildProfileFetchFailed(long guildId) {
        this.guildProfilesState.put(Long.valueOf(guildId), new GuildProfileData(FetchStates.FAILED, null));
        markChanged();
    }

    @Store3
    private final void handleGuildProfileFetchStart(long guildId) {
        this.guildProfilesState.put(Long.valueOf(guildId), new GuildProfileData(FetchStates.FETCHING, null));
        markChanged();
    }

    @Store3
    private final void handleGuildProfileFetchSuccess(GuildPreview guildPreview) {
        this.guildProfilesState.put(Long.valueOf(guildPreview.getId()), new GuildProfileData(FetchStates.SUCCEEDED, guildPreview));
        markChanged();
    }

    public final Observable<GuildProfileData> observeGuildProfile(long guildId) {
        this.dispatcher.schedule(new AnonymousClass1(guildId));
        Observable<GuildProfileData> observableR = ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, false, null, null, new AnonymousClass2(guildId), 14, null).r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "observationDeck\n        …  .distinctUntilChanged()");
        return observableR;
    }

    @Override // com.discord.stores.StoreV2
    @Store3
    public void snapshotData() {
        this.guildProfilesStateSnapshot = new HashMap(this.guildProfilesState);
    }
}
