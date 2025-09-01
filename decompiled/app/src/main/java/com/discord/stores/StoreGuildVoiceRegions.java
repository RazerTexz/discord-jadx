package com.discord.stores;

import android.content.Context;
import b.d.b.a.outline;
import com.discord.models.domain.ModelVoiceRegion;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeck4;
import com.discord.utilities.error.Error;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.t.Collections2;
import d0.t.Maps6;
import d0.t.MapsJVM;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* compiled from: StoreGuildVoiceRegions.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001&B\u0019\u0012\u0006\u0010\"\u001a\u00020!\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0019¢\u0006\u0004\b$\u0010%J)\u0010\t\u001a\u00020\b2\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u00032\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0003¢\u0006\u0004\b\t\u0010\nJ\u001b\u0010\u000b\u001a\u00020\b2\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003H\u0003¢\u0006\u0004\b\u000b\u0010\fJ\u001b\u0010\r\u001a\u00020\b2\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003H\u0003¢\u0006\u0004\b\r\u0010\fJ\u001f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ'\u0010\u0011\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00050\u00102\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003¢\u0006\u0004\b\u0011\u0010\u0012J\u0019\u0010\u0013\u001a\u00020\b2\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003¢\u0006\u0004\b\u0013\u0010\fJ\u000f\u0010\u0014\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0014\u0010\u0015R,\u0010\u0017\u001a\u0018\u0012\b\u0012\u00060\u0002j\u0002`\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001a\u001a\u00020\u00198\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR:\u0010\u001f\u001a&\u0012\b\u0012\u00060\u0002j\u0002`\u0003\u0012\u0004\u0012\u00020\u001d0\u001cj\u0012\u0012\b\u0012\u00060\u0002j\u0002`\u0003\u0012\u0004\u0012\u00020\u001d`\u001e8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010\"\u001a\u00020!8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\"\u0010#¨\u0006'"}, d2 = {"Lcom/discord/stores/StoreGuildVoiceRegions;", "Lcom/discord/stores/StoreV2;", "", "Lcom/discord/primitives/GuildId;", "guildId", "", "Lcom/discord/models/domain/ModelVoiceRegion;", "voiceRegions", "", "handleGuildVoiceRegions", "(JLjava/util/List;)V", "handleGuildVoiceRegionsFetchStart", "(J)V", "handleGuildVoiceRegionsFetchFailed", "getGuildVoiceRegions", "(J)Ljava/util/List;", "Lrx/Observable;", "observeGuildVoiceRegions", "(J)Lrx/Observable;", "fetchIfNonexisting", "snapshotData", "()V", "", "guildVoiceRegionsSnapshot", "Ljava/util/Map;", "Lcom/discord/stores/updates/ObservationDeck;", "observationDeck", "Lcom/discord/stores/updates/ObservationDeck;", "Ljava/util/HashMap;", "Lcom/discord/stores/StoreGuildVoiceRegions$State;", "Lkotlin/collections/HashMap;", "guildVoiceRegionsState", "Ljava/util/HashMap;", "Lcom/discord/stores/Dispatcher;", "dispatcher", "Lcom/discord/stores/Dispatcher;", "<init>", "(Lcom/discord/stores/Dispatcher;Lcom/discord/stores/updates/ObservationDeck;)V", "State", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class StoreGuildVoiceRegions extends StoreV2 {
    private final Dispatcher dispatcher;
    private Map<Long, ? extends List<? extends ModelVoiceRegion>> guildVoiceRegionsSnapshot;
    private final HashMap<Long, State> guildVoiceRegionsState;
    private final ObservationDeck observationDeck;

    /* compiled from: StoreGuildVoiceRegions.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0004\u0005\u0006B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0003\u0007\b\t¨\u0006\n"}, d2 = {"Lcom/discord/stores/StoreGuildVoiceRegions$State;", "", "<init>", "()V", "Failure", "Fetching", "Loaded", "Lcom/discord/stores/StoreGuildVoiceRegions$State$Loaded;", "Lcom/discord/stores/StoreGuildVoiceRegions$State$Failure;", "Lcom/discord/stores/StoreGuildVoiceRegions$State$Fetching;", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static abstract class State {

        /* compiled from: StoreGuildVoiceRegions.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/discord/stores/StoreGuildVoiceRegions$State$Failure;", "Lcom/discord/stores/StoreGuildVoiceRegions$State;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final class Failure extends State {
            public static final Failure INSTANCE = new Failure();

            private Failure() {
                super(null);
            }
        }

        /* compiled from: StoreGuildVoiceRegions.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/discord/stores/StoreGuildVoiceRegions$State$Fetching;", "Lcom/discord/stores/StoreGuildVoiceRegions$State;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final class Fetching extends State {
            public static final Fetching INSTANCE = new Fetching();

            private Fetching() {
                super(null);
            }
        }

        /* compiled from: StoreGuildVoiceRegions.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J \u0010\u0007\u001a\u00020\u00002\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002HÆ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fHÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013R\u001f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0014\u001a\u0004\b\u0015\u0010\u0005¨\u0006\u0018"}, d2 = {"Lcom/discord/stores/StoreGuildVoiceRegions$State$Loaded;", "Lcom/discord/stores/StoreGuildVoiceRegions$State;", "", "Lcom/discord/models/domain/ModelVoiceRegion;", "component1", "()Ljava/util/List;", "data", "copy", "(Ljava/util/List;)Lcom/discord/stores/StoreGuildVoiceRegions$State$Loaded;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/util/List;", "getData", "<init>", "(Ljava/util/List;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final /* data */ class Loaded extends State {
            private final List<ModelVoiceRegion> data;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            public Loaded(List<? extends ModelVoiceRegion> list) {
                super(null);
                Intrinsics3.checkNotNullParameter(list, "data");
                this.data = list;
            }

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ Loaded copy$default(Loaded loaded, List list, int i, Object obj) {
                if ((i & 1) != 0) {
                    list = loaded.data;
                }
                return loaded.copy(list);
            }

            public final List<ModelVoiceRegion> component1() {
                return this.data;
            }

            public final Loaded copy(List<? extends ModelVoiceRegion> data) {
                Intrinsics3.checkNotNullParameter(data, "data");
                return new Loaded(data);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof Loaded) && Intrinsics3.areEqual(this.data, ((Loaded) other).data);
                }
                return true;
            }

            public final List<ModelVoiceRegion> getData() {
                return this.data;
            }

            public int hashCode() {
                List<ModelVoiceRegion> list = this.data;
                if (list != null) {
                    return list.hashCode();
                }
                return 0;
            }

            public String toString() {
                return outline.L(outline.U("Loaded(data="), this.data, ")");
            }
        }

        private State() {
        }

        public /* synthetic */ State(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: StoreGuildVoiceRegions.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreGuildVoiceRegions$fetchIfNonexisting$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ long $guildId;

        /* compiled from: StoreGuildVoiceRegions.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "Lcom/discord/models/domain/ModelVoiceRegion;", "voiceRegions", "", "invoke", "(Ljava/util/List;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
        /* renamed from: com.discord.stores.StoreGuildVoiceRegions$fetchIfNonexisting$1$1, reason: invalid class name and collision with other inner class name */
        public static final class C01341 extends Lambda implements Function1<List<? extends ModelVoiceRegion>, Unit> {

            /* compiled from: StoreGuildVoiceRegions.kt */
            @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
            /* renamed from: com.discord.stores.StoreGuildVoiceRegions$fetchIfNonexisting$1$1$1, reason: invalid class name and collision with other inner class name */
            public static final class C01351 extends Lambda implements Function0<Unit> {
                public final /* synthetic */ List $voiceRegions;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public C01351(List list) {
                    super(0);
                    this.$voiceRegions = list;
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.a;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                    StoreGuildVoiceRegions.access$handleGuildVoiceRegions(StoreGuildVoiceRegions.this, anonymousClass1.$guildId, this.$voiceRegions);
                }
            }

            public C01341() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(List<? extends ModelVoiceRegion> list) {
                invoke2(list);
                return Unit.a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(List<? extends ModelVoiceRegion> list) {
                Intrinsics3.checkNotNullParameter(list, "voiceRegions");
                StoreGuildVoiceRegions.access$getDispatcher$p(StoreGuildVoiceRegions.this).schedule(new C01351(list));
            }
        }

        /* compiled from: StoreGuildVoiceRegions.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/utilities/error/Error;", "it", "", "invoke", "(Lcom/discord/utilities/error/Error;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
        /* renamed from: com.discord.stores.StoreGuildVoiceRegions$fetchIfNonexisting$1$2, reason: invalid class name */
        public static final class AnonymousClass2 extends Lambda implements Function1<Error, Unit> {

            /* compiled from: StoreGuildVoiceRegions.kt */
            @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
            /* renamed from: com.discord.stores.StoreGuildVoiceRegions$fetchIfNonexisting$1$2$1, reason: invalid class name and collision with other inner class name */
            public static final class C01361 extends Lambda implements Function0<Unit> {
                public C01361() {
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
                    StoreGuildVoiceRegions.access$handleGuildVoiceRegionsFetchFailed(StoreGuildVoiceRegions.this, anonymousClass1.$guildId);
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
                StoreGuildVoiceRegions.access$getDispatcher$p(StoreGuildVoiceRegions.this).schedule(new C01361());
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
            State state = (State) StoreGuildVoiceRegions.access$getGuildVoiceRegionsState$p(StoreGuildVoiceRegions.this).get(Long.valueOf(this.$guildId));
            if ((state instanceof State.Loaded) || (state instanceof State.Fetching)) {
                return;
            }
            StoreGuildVoiceRegions.access$handleGuildVoiceRegionsFetchStart(StoreGuildVoiceRegions.this, this.$guildId);
            ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.restSubscribeOn(RestAPI.INSTANCE.getApi().getGuildVoiceRegions(this.$guildId), false), StoreGuildVoiceRegions.this.getClass(), (Context) null, (Function1) null, new AnonymousClass2(), (Function0) null, (Function0) null, new C01341(), 54, (Object) null);
        }
    }

    /* compiled from: StoreGuildVoiceRegions.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"", "Lcom/discord/models/domain/ModelVoiceRegion;", "invoke", "()Ljava/util/List;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreGuildVoiceRegions$observeGuildVoiceRegions$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<List<? extends ModelVoiceRegion>> {
        public final /* synthetic */ long $guildId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(long j) {
            super(0);
            this.$guildId = j;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ List<? extends ModelVoiceRegion> invoke() {
            return invoke2();
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final List<? extends ModelVoiceRegion> invoke2() {
            return StoreGuildVoiceRegions.this.getGuildVoiceRegions(this.$guildId);
        }
    }

    public /* synthetic */ StoreGuildVoiceRegions(Dispatcher dispatcher, ObservationDeck observationDeck, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(dispatcher, (i & 2) != 0 ? ObservationDeck4.get() : observationDeck);
    }

    public static final /* synthetic */ Dispatcher access$getDispatcher$p(StoreGuildVoiceRegions storeGuildVoiceRegions) {
        return storeGuildVoiceRegions.dispatcher;
    }

    public static final /* synthetic */ HashMap access$getGuildVoiceRegionsState$p(StoreGuildVoiceRegions storeGuildVoiceRegions) {
        return storeGuildVoiceRegions.guildVoiceRegionsState;
    }

    public static final /* synthetic */ void access$handleGuildVoiceRegions(StoreGuildVoiceRegions storeGuildVoiceRegions, long j, List list) {
        storeGuildVoiceRegions.handleGuildVoiceRegions(j, list);
    }

    public static final /* synthetic */ void access$handleGuildVoiceRegionsFetchFailed(StoreGuildVoiceRegions storeGuildVoiceRegions, long j) {
        storeGuildVoiceRegions.handleGuildVoiceRegionsFetchFailed(j);
    }

    public static final /* synthetic */ void access$handleGuildVoiceRegionsFetchStart(StoreGuildVoiceRegions storeGuildVoiceRegions, long j) {
        storeGuildVoiceRegions.handleGuildVoiceRegionsFetchStart(j);
    }

    @Store3
    private final void handleGuildVoiceRegions(long guildId, List<? extends ModelVoiceRegion> voiceRegions) {
        this.guildVoiceRegionsState.put(Long.valueOf(guildId), new State.Loaded(voiceRegions));
        markChanged();
    }

    @Store3
    private final void handleGuildVoiceRegionsFetchFailed(long guildId) {
        this.guildVoiceRegionsState.put(Long.valueOf(guildId), State.Failure.INSTANCE);
        markChanged();
    }

    @Store3
    private final void handleGuildVoiceRegionsFetchStart(long guildId) {
        this.guildVoiceRegionsState.put(Long.valueOf(guildId), State.Fetching.INSTANCE);
        markChanged();
    }

    public final void fetchIfNonexisting(long guildId) {
        this.dispatcher.schedule(new AnonymousClass1(guildId));
    }

    public final List<ModelVoiceRegion> getGuildVoiceRegions(long guildId) {
        List<ModelVoiceRegion> list = (List) this.guildVoiceRegionsSnapshot.get(Long.valueOf(guildId));
        return list != null ? list : Collections2.emptyList();
    }

    public final Observable<List<ModelVoiceRegion>> observeGuildVoiceRegions(long guildId) {
        Observable<List<ModelVoiceRegion>> observableR = ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, false, null, null, new AnonymousClass1(guildId), 14, null).r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "observationDeck.connectR… }.distinctUntilChanged()");
        return observableR;
    }

    @Override // com.discord.stores.StoreV2
    public void snapshotData() {
        List<ModelVoiceRegion> listEmptyList;
        super.snapshotData();
        HashMap<Long, State> map = this.guildVoiceRegionsState;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<Long, State> entry : map.entrySet()) {
            if (entry.getValue() instanceof State.Loaded) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        LinkedHashMap linkedHashMap2 = new LinkedHashMap(MapsJVM.mapCapacity(linkedHashMap.size()));
        for (Map.Entry entry2 : linkedHashMap.entrySet()) {
            Object key = entry2.getKey();
            Object value = entry2.getValue();
            if (!(value instanceof State.Loaded)) {
                value = null;
            }
            State.Loaded loaded = (State.Loaded) value;
            if (loaded == null || (listEmptyList = loaded.getData()) == null) {
                listEmptyList = Collections2.emptyList();
            }
            linkedHashMap2.put(key, listEmptyList);
        }
        this.guildVoiceRegionsSnapshot = linkedHashMap2;
    }

    public StoreGuildVoiceRegions(Dispatcher dispatcher, ObservationDeck observationDeck) {
        Intrinsics3.checkNotNullParameter(dispatcher, "dispatcher");
        Intrinsics3.checkNotNullParameter(observationDeck, "observationDeck");
        this.dispatcher = dispatcher;
        this.observationDeck = observationDeck;
        this.guildVoiceRegionsSnapshot = Maps6.emptyMap();
        this.guildVoiceRegionsState = new HashMap<>();
    }
}
