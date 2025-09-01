package com.discord.stores;

import android.content.Context;
import b.d.b.a.outline;
import com.discord.api.guild.welcome.GuildWelcomeScreen;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeck4;
import com.discord.utilities.error.Error;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.t.Maps6;
import d0.t.Sets5;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* compiled from: StoreGuildWelcomeScreens.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u00011B\u0019\u0012\u0006\u0010-\u001a\u00020,\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u001b¢\u0006\u0004\b/\u00100J!\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u001b\u0010\n\u001a\u00020\u00062\n\u0010\u0003\u001a\u00060\u0002j\u0002`\tH\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u001b\u0010\f\u001a\u00020\u00062\n\u0010\u0003\u001a\u00060\u0002j\u0002`\tH\u0003¢\u0006\u0004\b\f\u0010\u000bJ\u001b\u0010\u000e\u001a\u0004\u0018\u00010\r2\n\u0010\u0003\u001a\u00060\u0002j\u0002`\t¢\u0006\u0004\b\u000e\u0010\u000fJ\u0019\u0010\u0011\u001a\u00020\u00102\n\u0010\u0003\u001a\u00060\u0002j\u0002`\t¢\u0006\u0004\b\u0011\u0010\u0012J!\u0010\u0014\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\r0\u00132\n\u0010\u0003\u001a\u00060\u0002j\u0002`\t¢\u0006\u0004\b\u0014\u0010\u0015J\u0019\u0010\u0016\u001a\u00020\u00062\n\u0010\u0003\u001a\u00060\u0002j\u0002`\t¢\u0006\u0004\b\u0016\u0010\u000bJ\u0019\u0010\u0017\u001a\u00020\u00062\n\u0010\u0003\u001a\u00060\u0002j\u0002`\t¢\u0006\u0004\b\u0017\u0010\u000bJ\u001f\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0018\u0010\bJ\u000f\u0010\u0019\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001c\u001a\u00020\u001b8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR.\u0010 \u001a\u001a\u0012\b\u0012\u00060\u0002j\u0002`\t0\u001ej\f\u0012\b\u0012\u00060\u0002j\u0002`\t`\u001f8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b \u0010!R \u0010#\u001a\f\u0012\b\u0012\u00060\u0002j\u0002`\t0\"8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b#\u0010$R:\u0010'\u001a&\u0012\b\u0012\u00060\u0002j\u0002`\t\u0012\u0004\u0012\u00020\r0%j\u0012\u0012\b\u0012\u00060\u0002j\u0002`\t\u0012\u0004\u0012\u00020\r`&8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b'\u0010(R&\u0010*\u001a\u0012\u0012\b\u0012\u00060\u0002j\u0002`\t\u0012\u0004\u0012\u00020\r0)8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b*\u0010+R\u0016\u0010-\u001a\u00020,8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b-\u0010.¨\u00062"}, d2 = {"Lcom/discord/stores/StoreGuildWelcomeScreens;", "Lcom/discord/stores/StoreV2;", "", "guildId", "Lcom/discord/api/guild/welcome/GuildWelcomeScreen;", "guildWelcomeScreen", "", "handleGuildWelcomeScreen", "(JLcom/discord/api/guild/welcome/GuildWelcomeScreen;)V", "Lcom/discord/primitives/GuildId;", "handleGuildWelcomeScreenFetchStart", "(J)V", "handleGuildWelcomeScreenFetchFailed", "Lcom/discord/stores/StoreGuildWelcomeScreens$State;", "getGuildWelcomeScreen", "(J)Lcom/discord/stores/StoreGuildWelcomeScreens$State;", "", "hasWelcomeScreenBeenSeen", "(J)Z", "Lrx/Observable;", "observeGuildWelcomeScreen", "(J)Lrx/Observable;", "markWelcomeScreenShown", "fetchIfNonexisting", "handleGuildJoined", "snapshotData", "()V", "Lcom/discord/stores/updates/ObservationDeck;", "observationDeck", "Lcom/discord/stores/updates/ObservationDeck;", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "guildWelcomeScreensSeen", "Ljava/util/HashSet;", "", "guildWelcomeScreensSeenSnapshot", "Ljava/util/Set;", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "guildWelcomeScreensState", "Ljava/util/HashMap;", "", "guildWelcomeScreensSnapshot", "Ljava/util/Map;", "Lcom/discord/stores/Dispatcher;", "dispatcher", "Lcom/discord/stores/Dispatcher;", "<init>", "(Lcom/discord/stores/Dispatcher;Lcom/discord/stores/updates/ObservationDeck;)V", "State", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class StoreGuildWelcomeScreens extends StoreV2 {
    private final Dispatcher dispatcher;
    private final HashSet<Long> guildWelcomeScreensSeen;
    private Set<Long> guildWelcomeScreensSeenSnapshot;
    private Map<Long, ? extends State> guildWelcomeScreensSnapshot;
    private final HashMap<Long, State> guildWelcomeScreensState;
    private final ObservationDeck observationDeck;

    /* compiled from: StoreGuildWelcomeScreens.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0004\u0005\u0006B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0003\u0007\b\t¨\u0006\n"}, d2 = {"Lcom/discord/stores/StoreGuildWelcomeScreens$State;", "", "<init>", "()V", "Failure", "Fetching", "Loaded", "Lcom/discord/stores/StoreGuildWelcomeScreens$State$Loaded;", "Lcom/discord/stores/StoreGuildWelcomeScreens$State$Failure;", "Lcom/discord/stores/StoreGuildWelcomeScreens$State$Fetching;", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static abstract class State {

        /* compiled from: StoreGuildWelcomeScreens.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/discord/stores/StoreGuildWelcomeScreens$State$Failure;", "Lcom/discord/stores/StoreGuildWelcomeScreens$State;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final class Failure extends State {
            public static final Failure INSTANCE = new Failure();

            private Failure() {
                super(null);
            }
        }

        /* compiled from: StoreGuildWelcomeScreens.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/discord/stores/StoreGuildWelcomeScreens$State$Fetching;", "Lcom/discord/stores/StoreGuildWelcomeScreens$State;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final class Fetching extends State {
            public static final Fetching INSTANCE = new Fetching();

            private Fetching() {
                super(null);
            }
        }

        /* compiled from: StoreGuildWelcomeScreens.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001c\u0010\u0006\u001a\u00020\u00002\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u001b\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0013\u001a\u0004\b\u0014\u0010\u0004¨\u0006\u0017"}, d2 = {"Lcom/discord/stores/StoreGuildWelcomeScreens$State$Loaded;", "Lcom/discord/stores/StoreGuildWelcomeScreens$State;", "Lcom/discord/api/guild/welcome/GuildWelcomeScreen;", "component1", "()Lcom/discord/api/guild/welcome/GuildWelcomeScreen;", "data", "copy", "(Lcom/discord/api/guild/welcome/GuildWelcomeScreen;)Lcom/discord/stores/StoreGuildWelcomeScreens$State$Loaded;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/discord/api/guild/welcome/GuildWelcomeScreen;", "getData", "<init>", "(Lcom/discord/api/guild/welcome/GuildWelcomeScreen;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final /* data */ class Loaded extends State {
            private final GuildWelcomeScreen data;

            public Loaded(GuildWelcomeScreen guildWelcomeScreen) {
                super(null);
                this.data = guildWelcomeScreen;
            }

            public static /* synthetic */ Loaded copy$default(Loaded loaded, GuildWelcomeScreen guildWelcomeScreen, int i, Object obj) {
                if ((i & 1) != 0) {
                    guildWelcomeScreen = loaded.data;
                }
                return loaded.copy(guildWelcomeScreen);
            }

            /* renamed from: component1, reason: from getter */
            public final GuildWelcomeScreen getData() {
                return this.data;
            }

            public final Loaded copy(GuildWelcomeScreen data) {
                return new Loaded(data);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof Loaded) && Intrinsics3.areEqual(this.data, ((Loaded) other).data);
                }
                return true;
            }

            public final GuildWelcomeScreen getData() {
                return this.data;
            }

            public int hashCode() {
                GuildWelcomeScreen guildWelcomeScreen = this.data;
                if (guildWelcomeScreen != null) {
                    return guildWelcomeScreen.hashCode();
                }
                return 0;
            }

            public String toString() {
                StringBuilder sbU = outline.U("Loaded(data=");
                sbU.append(this.data);
                sbU.append(")");
                return sbU.toString();
            }
        }

        private State() {
        }

        public /* synthetic */ State(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: StoreGuildWelcomeScreens.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreGuildWelcomeScreens$fetchIfNonexisting$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ long $guildId;

        /* compiled from: StoreGuildWelcomeScreens.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/api/guild/welcome/GuildWelcomeScreen;", "guildWelcomeScreen", "", "invoke", "(Lcom/discord/api/guild/welcome/GuildWelcomeScreen;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
        /* renamed from: com.discord.stores.StoreGuildWelcomeScreens$fetchIfNonexisting$1$1, reason: invalid class name and collision with other inner class name */
        public static final class C01371 extends Lambda implements Function1<GuildWelcomeScreen, Unit> {

            /* compiled from: StoreGuildWelcomeScreens.kt */
            @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
            /* renamed from: com.discord.stores.StoreGuildWelcomeScreens$fetchIfNonexisting$1$1$1, reason: invalid class name and collision with other inner class name */
            public static final class C01381 extends Lambda implements Function0<Unit> {
                public final /* synthetic */ GuildWelcomeScreen $guildWelcomeScreen;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public C01381(GuildWelcomeScreen guildWelcomeScreen) {
                    super(0);
                    this.$guildWelcomeScreen = guildWelcomeScreen;
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.a;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                    StoreGuildWelcomeScreens.access$handleGuildWelcomeScreen(StoreGuildWelcomeScreens.this, anonymousClass1.$guildId, this.$guildWelcomeScreen);
                }
            }

            public C01371() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(GuildWelcomeScreen guildWelcomeScreen) {
                invoke2(guildWelcomeScreen);
                return Unit.a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(GuildWelcomeScreen guildWelcomeScreen) {
                Intrinsics3.checkNotNullParameter(guildWelcomeScreen, "guildWelcomeScreen");
                StoreGuildWelcomeScreens.access$getDispatcher$p(StoreGuildWelcomeScreens.this).schedule(new C01381(guildWelcomeScreen));
            }
        }

        /* compiled from: StoreGuildWelcomeScreens.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/utilities/error/Error;", "it", "", "invoke", "(Lcom/discord/utilities/error/Error;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
        /* renamed from: com.discord.stores.StoreGuildWelcomeScreens$fetchIfNonexisting$1$2, reason: invalid class name */
        public static final class AnonymousClass2 extends Lambda implements Function1<Error, Unit> {

            /* compiled from: StoreGuildWelcomeScreens.kt */
            @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
            /* renamed from: com.discord.stores.StoreGuildWelcomeScreens$fetchIfNonexisting$1$2$1, reason: invalid class name and collision with other inner class name */
            public static final class C01391 extends Lambda implements Function0<Unit> {
                public C01391() {
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
                    StoreGuildWelcomeScreens.access$handleGuildWelcomeScreenFetchFailed(StoreGuildWelcomeScreens.this, anonymousClass1.$guildId);
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
                StoreGuildWelcomeScreens.access$getDispatcher$p(StoreGuildWelcomeScreens.this).schedule(new C01391());
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
            State state = (State) StoreGuildWelcomeScreens.access$getGuildWelcomeScreensState$p(StoreGuildWelcomeScreens.this).get(Long.valueOf(this.$guildId));
            if ((state instanceof State.Loaded) || (state instanceof State.Fetching)) {
                return;
            }
            StoreGuildWelcomeScreens.access$handleGuildWelcomeScreenFetchStart(StoreGuildWelcomeScreens.this, this.$guildId);
            ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.restSubscribeOn(RestAPI.INSTANCE.getApi().getGuildWelcomeScreen(this.$guildId), false), StoreGuildWelcomeScreens.this.getClass(), (Context) null, (Function1) null, new AnonymousClass2(), (Function0) null, (Function0) null, new C01371(), 54, (Object) null);
        }
    }

    /* compiled from: StoreGuildWelcomeScreens.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreGuildWelcomeScreens$markWelcomeScreenShown$1, reason: invalid class name */
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
            if (StoreGuildWelcomeScreens.access$getGuildWelcomeScreensSeen$p(StoreGuildWelcomeScreens.this).contains(Long.valueOf(this.$guildId))) {
                return;
            }
            StoreGuildWelcomeScreens.access$getGuildWelcomeScreensSeen$p(StoreGuildWelcomeScreens.this).add(Long.valueOf(this.$guildId));
            StoreGuildWelcomeScreens.this.markChanged();
        }
    }

    /* compiled from: StoreGuildWelcomeScreens.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lcom/discord/stores/StoreGuildWelcomeScreens$State;", "invoke", "()Lcom/discord/stores/StoreGuildWelcomeScreens$State;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreGuildWelcomeScreens$observeGuildWelcomeScreen$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<State> {
        public final /* synthetic */ long $guildId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(long j) {
            super(0);
            this.$guildId = j;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ State invoke() {
            return invoke();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final State invoke() {
            return StoreGuildWelcomeScreens.this.getGuildWelcomeScreen(this.$guildId);
        }
    }

    public /* synthetic */ StoreGuildWelcomeScreens(Dispatcher dispatcher, ObservationDeck observationDeck, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(dispatcher, (i & 2) != 0 ? ObservationDeck4.get() : observationDeck);
    }

    public static final /* synthetic */ Dispatcher access$getDispatcher$p(StoreGuildWelcomeScreens storeGuildWelcomeScreens) {
        return storeGuildWelcomeScreens.dispatcher;
    }

    public static final /* synthetic */ HashSet access$getGuildWelcomeScreensSeen$p(StoreGuildWelcomeScreens storeGuildWelcomeScreens) {
        return storeGuildWelcomeScreens.guildWelcomeScreensSeen;
    }

    public static final /* synthetic */ HashMap access$getGuildWelcomeScreensState$p(StoreGuildWelcomeScreens storeGuildWelcomeScreens) {
        return storeGuildWelcomeScreens.guildWelcomeScreensState;
    }

    public static final /* synthetic */ void access$handleGuildWelcomeScreen(StoreGuildWelcomeScreens storeGuildWelcomeScreens, long j, GuildWelcomeScreen guildWelcomeScreen) {
        storeGuildWelcomeScreens.handleGuildWelcomeScreen(j, guildWelcomeScreen);
    }

    public static final /* synthetic */ void access$handleGuildWelcomeScreenFetchFailed(StoreGuildWelcomeScreens storeGuildWelcomeScreens, long j) {
        storeGuildWelcomeScreens.handleGuildWelcomeScreenFetchFailed(j);
    }

    public static final /* synthetic */ void access$handleGuildWelcomeScreenFetchStart(StoreGuildWelcomeScreens storeGuildWelcomeScreens, long j) {
        storeGuildWelcomeScreens.handleGuildWelcomeScreenFetchStart(j);
    }

    @Store3
    private final void handleGuildWelcomeScreen(long guildId, GuildWelcomeScreen guildWelcomeScreen) {
        this.guildWelcomeScreensState.put(Long.valueOf(guildId), new State.Loaded(guildWelcomeScreen));
        markChanged();
    }

    @Store3
    private final void handleGuildWelcomeScreenFetchFailed(long guildId) {
        this.guildWelcomeScreensState.put(Long.valueOf(guildId), State.Failure.INSTANCE);
        markChanged();
    }

    @Store3
    private final void handleGuildWelcomeScreenFetchStart(long guildId) {
        this.guildWelcomeScreensState.put(Long.valueOf(guildId), State.Fetching.INSTANCE);
        markChanged();
    }

    public final void fetchIfNonexisting(long guildId) {
        this.dispatcher.schedule(new AnonymousClass1(guildId));
    }

    public final State getGuildWelcomeScreen(long guildId) {
        return this.guildWelcomeScreensSnapshot.get(Long.valueOf(guildId));
    }

    public final void handleGuildJoined(long guildId, GuildWelcomeScreen guildWelcomeScreen) {
        handleGuildWelcomeScreen(guildId, guildWelcomeScreen);
    }

    public final boolean hasWelcomeScreenBeenSeen(long guildId) {
        return this.guildWelcomeScreensSeenSnapshot.contains(Long.valueOf(guildId));
    }

    public final void markWelcomeScreenShown(long guildId) {
        this.dispatcher.schedule(new AnonymousClass1(guildId));
    }

    public final Observable<State> observeGuildWelcomeScreen(long guildId) {
        Observable<State> observableR = ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, false, null, null, new AnonymousClass1(guildId), 14, null).r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "observationDeck.connectR… }.distinctUntilChanged()");
        return observableR;
    }

    @Override // com.discord.stores.StoreV2
    public void snapshotData() {
        super.snapshotData();
        this.guildWelcomeScreensSnapshot = new HashMap(this.guildWelcomeScreensState);
        this.guildWelcomeScreensSeenSnapshot = new HashSet(this.guildWelcomeScreensSeen);
    }

    public StoreGuildWelcomeScreens(Dispatcher dispatcher, ObservationDeck observationDeck) {
        Intrinsics3.checkNotNullParameter(dispatcher, "dispatcher");
        Intrinsics3.checkNotNullParameter(observationDeck, "observationDeck");
        this.dispatcher = dispatcher;
        this.observationDeck = observationDeck;
        this.guildWelcomeScreensSnapshot = Maps6.emptyMap();
        this.guildWelcomeScreensSeenSnapshot = Sets5.emptySet();
        this.guildWelcomeScreensState = new HashMap<>();
        this.guildWelcomeScreensSeen = new HashSet<>();
    }
}
