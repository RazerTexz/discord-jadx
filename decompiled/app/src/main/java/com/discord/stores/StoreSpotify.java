package com.discord.stores;

import a0.a.a.b;
import android.content.Context;
import androidx.core.app.NotificationCompat;
import b.d.b.a.outline;
import com.discord.api.activity.ActivityType;
import com.discord.api.connectedaccounts.ConnectedAccount;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.domain.ModelPayload;
import com.discord.models.domain.spotify.ModelSpotifyAlbum;
import com.discord.models.domain.spotify.ModelSpotifyTrack;
import com.discord.stores.StoreUserConnections;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.utilities.integrations.SpotifyHelper;
import com.discord.utilities.platform.Platform;
import com.discord.utilities.presence.ActivityUtils;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.spotify.SpotifyApiClient;
import com.discord.utilities.time.Clock;
import com.discord.widgets.chat.input.MentionUtils;
import com.discord.widgets.chat.input.autocomplete.AutocompleteViewModel;
import d0.g0.Strings4;
import d0.g0.StringsJVM;
import d0.t._Collections;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import j0.k.Func1;
import j0.l.e.ScalarSynchronousObservable;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;
import rx.Subscription;
import rx.functions.Func2;
import rx.subjects.BehaviorSubject;

/* compiled from: StoreSpotify.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001<B\u001f\u0012\u0006\u00101\u001a\u000200\u0012\u0006\u00108\u001a\u000207\u0012\u0006\u0010%\u001a\u00020$¢\u0006\u0004\b:\u0010;J\u000f\u0010\u0003\u001a\u00020\u0002H\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\u000b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\rH\u0007¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0011\u0010\u0004J\u0017\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0012H\u0007¢\u0006\u0004\b\u0014\u0010\u0015J\u001d\u0010\u0019\u001a\u00020\u00022\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016H\u0007¢\u0006\u0004\b\u0019\u0010\u001aJ\u001d\u0010\u001e\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\r2\u0006\u0010\u001d\u001a\u00020\u001c¢\u0006\u0004\b\u001e\u0010\u001fJ\u0015\u0010\"\u001a\u00020\u00022\u0006\u0010!\u001a\u00020 ¢\u0006\u0004\b\"\u0010#R\u0016\u0010%\u001a\u00020$8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b%\u0010&R\u0018\u0010(\u001a\u0004\u0018\u00010'8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b(\u0010)R\u0016\u0010+\u001a\u00020*8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b+\u0010,R\u0018\u0010.\u001a\u0004\u0018\u00010-8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b.\u0010/R\u0016\u00101\u001a\u0002008\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b1\u00102R:\u00105\u001a&\u0012\f\u0012\n 4*\u0004\u0018\u00010\u00020\u0002 4*\u0012\u0012\f\u0012\n 4*\u0004\u0018\u00010\u00020\u0002\u0018\u000103038\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b5\u00106R\u0016\u00108\u001a\u0002078\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b8\u00109¨\u0006="}, d2 = {"Lcom/discord/stores/StoreSpotify;", "", "", "publishState", "()V", "", "timeLeftMs", "startStateExpiration", "(J)V", "Landroid/content/Context;", "context", "init", "(Landroid/content/Context;)V", "", "ready", "handleConnectionReady", "(Z)V", "handlePreLogout", "Lcom/discord/models/domain/ModelPayload;", "payload", "handleConnectionOpen", "(Lcom/discord/models/domain/ModelPayload;)V", "", "Lcom/discord/api/connectedaccounts/ConnectedAccount;", "accounts", "handleUserConnections", "(Ljava/util/List;)V", "playing", "", ModelAuditLogEntry.CHANGE_KEY_POSITION, "setPlayingStatus", "(ZI)V", "", "trackId", "setCurrentTrackId", "(Ljava/lang/String;)V", "Lcom/discord/utilities/time/Clock;", "clock", "Lcom/discord/utilities/time/Clock;", "Lcom/discord/stores/StoreSpotify$SpotifyState;", "spotifyState", "Lcom/discord/stores/StoreSpotify$SpotifyState;", "Lcom/discord/utilities/spotify/SpotifyApiClient;", "spotifyApiClient", "Lcom/discord/utilities/spotify/SpotifyApiClient;", "Lrx/Subscription;", "expireStateSub", "Lrx/Subscription;", "Lcom/discord/stores/StoreStream;", "stream", "Lcom/discord/stores/StoreStream;", "Lrx/subjects/BehaviorSubject;", "kotlin.jvm.PlatformType", "publishStateTrigger", "Lrx/subjects/BehaviorSubject;", "Lcom/discord/stores/Dispatcher;", "dispatcher", "Lcom/discord/stores/Dispatcher;", "<init>", "(Lcom/discord/stores/StoreStream;Lcom/discord/stores/Dispatcher;Lcom/discord/utilities/time/Clock;)V", "SpotifyState", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class StoreSpotify {
    private final Clock clock;
    private final Dispatcher dispatcher;
    private Subscription expireStateSub;
    private final BehaviorSubject<Unit> publishStateTrigger;
    private final SpotifyApiClient spotifyApiClient;
    private SpotifyState spotifyState;
    private final StoreStream stream;

    /* compiled from: StoreSpotify.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0011\b\u0086\b\u0018\u00002\u00020\u0001B1\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0010\u001a\u00020\b\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u000b¢\u0006\u0004\b#\u0010$J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÆ\u0003¢\u0006\u0004\b\f\u0010\rJ:\u0010\u0012\u001a\u00020\u00002\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u000f\u001a\u00020\u00052\b\b\u0002\u0010\u0010\u001a\u00020\b2\b\b\u0002\u0010\u0011\u001a\u00020\u000bHÆ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0015\u001a\u00020\u0014HÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0017\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\u0017\u0010\nJ\u001a\u0010\u0019\u001a\u00020\u00052\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0019\u0010\u001aR\u0019\u0010\u000f\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u001b\u001a\u0004\b\u001c\u0010\u0007R\u0019\u0010\u0011\u001a\u00020\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u001d\u001a\u0004\b\u001e\u0010\rR\u001b\u0010\u000e\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u001f\u001a\u0004\b \u0010\u0004R\u0019\u0010\u0010\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\u0010\u0010!\u001a\u0004\b\"\u0010\n¨\u0006%"}, d2 = {"Lcom/discord/stores/StoreSpotify$SpotifyState;", "", "Lcom/discord/models/domain/spotify/ModelSpotifyTrack;", "component1", "()Lcom/discord/models/domain/spotify/ModelSpotifyTrack;", "", "component2", "()Z", "", "component3", "()I", "", "component4", "()J", "track", "playing", ModelAuditLogEntry.CHANGE_KEY_POSITION, "start", "copy", "(Lcom/discord/models/domain/spotify/ModelSpotifyTrack;ZIJ)Lcom/discord/stores/StoreSpotify$SpotifyState;", "", "toString", "()Ljava/lang/String;", "hashCode", "other", "equals", "(Ljava/lang/Object;)Z", "Z", "getPlaying", "J", "getStart", "Lcom/discord/models/domain/spotify/ModelSpotifyTrack;", "getTrack", "I", "getPosition", "<init>", "(Lcom/discord/models/domain/spotify/ModelSpotifyTrack;ZIJ)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class SpotifyState {
        private final boolean playing;
        private final int position;
        private final long start;
        private final ModelSpotifyTrack track;

        public SpotifyState() {
            this(null, false, 0, 0L, 15, null);
        }

        public SpotifyState(ModelSpotifyTrack modelSpotifyTrack, boolean z2, int i, long j) {
            this.track = modelSpotifyTrack;
            this.playing = z2;
            this.position = i;
            this.start = j;
        }

        public static /* synthetic */ SpotifyState copy$default(SpotifyState spotifyState, ModelSpotifyTrack modelSpotifyTrack, boolean z2, int i, long j, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                modelSpotifyTrack = spotifyState.track;
            }
            if ((i2 & 2) != 0) {
                z2 = spotifyState.playing;
            }
            boolean z3 = z2;
            if ((i2 & 4) != 0) {
                i = spotifyState.position;
            }
            int i3 = i;
            if ((i2 & 8) != 0) {
                j = spotifyState.start;
            }
            return spotifyState.copy(modelSpotifyTrack, z3, i3, j);
        }

        /* renamed from: component1, reason: from getter */
        public final ModelSpotifyTrack getTrack() {
            return this.track;
        }

        /* renamed from: component2, reason: from getter */
        public final boolean getPlaying() {
            return this.playing;
        }

        /* renamed from: component3, reason: from getter */
        public final int getPosition() {
            return this.position;
        }

        /* renamed from: component4, reason: from getter */
        public final long getStart() {
            return this.start;
        }

        public final SpotifyState copy(ModelSpotifyTrack track, boolean playing, int position, long start) {
            return new SpotifyState(track, playing, position, start);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof SpotifyState)) {
                return false;
            }
            SpotifyState spotifyState = (SpotifyState) other;
            return Intrinsics3.areEqual(this.track, spotifyState.track) && this.playing == spotifyState.playing && this.position == spotifyState.position && this.start == spotifyState.start;
        }

        public final boolean getPlaying() {
            return this.playing;
        }

        public final int getPosition() {
            return this.position;
        }

        public final long getStart() {
            return this.start;
        }

        public final ModelSpotifyTrack getTrack() {
            return this.track;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            ModelSpotifyTrack modelSpotifyTrack = this.track;
            int iHashCode = (modelSpotifyTrack != null ? modelSpotifyTrack.hashCode() : 0) * 31;
            boolean z2 = this.playing;
            int i = z2;
            if (z2 != 0) {
                i = 1;
            }
            return b.a(this.start) + ((((iHashCode + i) * 31) + this.position) * 31);
        }

        public String toString() {
            StringBuilder sbU = outline.U("SpotifyState(track=");
            sbU.append(this.track);
            sbU.append(", playing=");
            sbU.append(this.playing);
            sbU.append(", position=");
            sbU.append(this.position);
            sbU.append(", start=");
            return outline.C(sbU, this.start, ")");
        }

        public /* synthetic */ SpotifyState(ModelSpotifyTrack modelSpotifyTrack, boolean z2, int i, long j, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this((i2 & 1) != 0 ? null : modelSpotifyTrack, (i2 & 2) != 0 ? false : z2, (i2 & 4) == 0 ? i : 0, (i2 & 8) != 0 ? 0L : j);
        }
    }

    /* compiled from: StoreSpotify.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0006\u001a\u001e\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u0000 \u0003*\u000e\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u0000\u0018\u00010\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/discord/models/domain/spotify/ModelSpotifyTrack;", "track", "Lrx/Observable;", "kotlin.jvm.PlatformType", NotificationCompat.CATEGORY_CALL, "(Lcom/discord/models/domain/spotify/ModelSpotifyTrack;)Lrx/Observable;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreSpotify$init$1, reason: invalid class name */
    public static final class AnonymousClass1<T, R> implements Func1<ModelSpotifyTrack, Observable<? extends ModelSpotifyTrack>> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        /* compiled from: StoreSpotify.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0001\n\u0002\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "kotlin.jvm.PlatformType", "it", "", NotificationCompat.CATEGORY_CALL, "(Ljava/lang/Long;)Ljava/lang/Void;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
        /* renamed from: com.discord.stores.StoreSpotify$init$1$1, reason: invalid class name and collision with other inner class name */
        public static final class C01721<T, R> implements Func1 {
            public static final C01721 INSTANCE = new C01721();

            @Override // j0.k.Func1
            public /* bridge */ /* synthetic */ Object call(Object obj) {
                return call((Long) obj);
            }

            public final Void call(Long l) {
                return null;
            }
        }

        @Override // j0.k.Func1
        public /* bridge */ /* synthetic */ Observable<? extends ModelSpotifyTrack> call(ModelSpotifyTrack modelSpotifyTrack) {
            return call2(modelSpotifyTrack);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final Observable<? extends ModelSpotifyTrack> call2(ModelSpotifyTrack modelSpotifyTrack) {
            return modelSpotifyTrack != null ? new ScalarSynchronousObservable(modelSpotifyTrack) : Observable.d0(1L, TimeUnit.SECONDS).G(C01721.INSTANCE);
        }
    }

    /* compiled from: StoreSpotify.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0007\u001a\u0004\u0018\u00010\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u00002\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"", "kotlin.jvm.PlatformType", "<anonymous parameter 0>", "Lcom/discord/models/domain/spotify/ModelSpotifyTrack;", "track", NotificationCompat.CATEGORY_CALL, "(Lkotlin/Unit;Lcom/discord/models/domain/spotify/ModelSpotifyTrack;)Lcom/discord/models/domain/spotify/ModelSpotifyTrack;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreSpotify$init$2, reason: invalid class name */
    public static final class AnonymousClass2<T1, T2, R> implements Func2<Unit, ModelSpotifyTrack, ModelSpotifyTrack> {
        public static final AnonymousClass2 INSTANCE = new AnonymousClass2();

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final ModelSpotifyTrack call2(Unit unit, ModelSpotifyTrack modelSpotifyTrack) {
            return modelSpotifyTrack;
        }

        @Override // rx.functions.Func2
        public /* bridge */ /* synthetic */ ModelSpotifyTrack call(Unit unit, ModelSpotifyTrack modelSpotifyTrack) {
            return call2(unit, modelSpotifyTrack);
        }
    }

    /* compiled from: StoreSpotify.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/models/domain/spotify/ModelSpotifyTrack;", "track", "", "invoke", "(Lcom/discord/models/domain/spotify/ModelSpotifyTrack;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreSpotify$init$3, reason: invalid class name */
    public static final class AnonymousClass3 extends Lambda implements Function1<ModelSpotifyTrack, Unit> {

        /* compiled from: StoreSpotify.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
        /* renamed from: com.discord.stores.StoreSpotify$init$3$1, reason: invalid class name */
        public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
            public final /* synthetic */ ModelSpotifyTrack $track;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(ModelSpotifyTrack modelSpotifyTrack) {
                super(0);
                this.$track = modelSpotifyTrack;
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                SpotifyState spotifyStateAccess$getSpotifyState$p = StoreSpotify.access$getSpotifyState$p(StoreSpotify.this);
                if (spotifyStateAccess$getSpotifyState$p != null) {
                    StoreSpotify.access$setSpotifyState$p(StoreSpotify.this, SpotifyState.copy$default(spotifyStateAccess$getSpotifyState$p, this.$track, false, 0, 0L, 14, null));
                    Subscription subscriptionAccess$getExpireStateSub$p = StoreSpotify.access$getExpireStateSub$p(StoreSpotify.this);
                    if (subscriptionAccess$getExpireStateSub$p != null) {
                        subscriptionAccess$getExpireStateSub$p.unsubscribe();
                    }
                    if (this.$track != null) {
                        StoreSpotify.access$startStateExpiration(StoreSpotify.this, (this.$track.getDurationMs() + spotifyStateAccess$getSpotifyState$p.getStart()) - StoreSpotify.access$getClock$p(StoreSpotify.this).currentTimeMillis());
                    }
                }
                StoreSpotify.access$publishState(StoreSpotify.this);
            }
        }

        public AnonymousClass3() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ModelSpotifyTrack modelSpotifyTrack) {
            invoke2(modelSpotifyTrack);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ModelSpotifyTrack modelSpotifyTrack) {
            StoreSpotify.access$getDispatcher$p(StoreSpotify.this).schedule(new AnonymousClass1(modelSpotifyTrack));
        }
    }

    /* compiled from: StoreSpotify.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreSpotify$setPlayingStatus$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ boolean $playing;
        public final /* synthetic */ int $position;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(boolean z2, int i) {
            super(0);
            this.$playing = z2;
            this.$position = i;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            if (StoreSpotify.access$getSpotifyState$p(StoreSpotify.this) == null) {
                StoreSpotify.access$setSpotifyState$p(StoreSpotify.this, new SpotifyState(null, false, 0, 0L, 15, null));
            }
            StoreSpotify storeSpotify = StoreSpotify.this;
            SpotifyState spotifyStateAccess$getSpotifyState$p = StoreSpotify.access$getSpotifyState$p(storeSpotify);
            StoreSpotify.access$setSpotifyState$p(storeSpotify, spotifyStateAccess$getSpotifyState$p != null ? SpotifyState.copy$default(spotifyStateAccess$getSpotifyState$p, null, this.$playing, this.$position, StoreSpotify.access$getClock$p(StoreSpotify.this).currentTimeMillis() - this.$position, 1, null) : null);
            StoreSpotify.access$getPublishStateTrigger$p(StoreSpotify.this).onNext(Unit.a);
        }
    }

    /* compiled from: StoreSpotify.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lrx/Subscription;", "it", "", "invoke", "(Lrx/Subscription;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreSpotify$startStateExpiration$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<Subscription, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Subscription subscription) {
            invoke2(subscription);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Subscription subscription) {
            Intrinsics3.checkNotNullParameter(subscription, "it");
            StoreSpotify.access$setExpireStateSub$p(StoreSpotify.this, subscription);
        }
    }

    /* compiled from: StoreSpotify.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "kotlin.jvm.PlatformType", "it", "", "invoke", "(Ljava/lang/Long;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreSpotify$startStateExpiration$2, reason: invalid class name */
    public static final class AnonymousClass2 extends Lambda implements Function1<Long, Unit> {

        /* compiled from: StoreSpotify.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
        /* renamed from: com.discord.stores.StoreSpotify$startStateExpiration$2$1, reason: invalid class name */
        public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
            public AnonymousClass1() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                StoreSpotify.access$setSpotifyState$p(StoreSpotify.this, null);
                StoreSpotify.access$publishState(StoreSpotify.this);
            }
        }

        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Long l) {
            invoke2(l);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Long l) {
            StoreSpotify.access$getDispatcher$p(StoreSpotify.this).schedule(new AnonymousClass1());
        }
    }

    public StoreSpotify(StoreStream storeStream, Dispatcher dispatcher, Clock clock) {
        Intrinsics3.checkNotNullParameter(storeStream, "stream");
        Intrinsics3.checkNotNullParameter(dispatcher, "dispatcher");
        Intrinsics3.checkNotNullParameter(clock, "clock");
        this.stream = storeStream;
        this.dispatcher = dispatcher;
        this.clock = clock;
        this.publishStateTrigger = BehaviorSubject.k0();
        this.spotifyApiClient = new SpotifyApiClient(clock);
    }

    public static final /* synthetic */ Clock access$getClock$p(StoreSpotify storeSpotify) {
        return storeSpotify.clock;
    }

    public static final /* synthetic */ Dispatcher access$getDispatcher$p(StoreSpotify storeSpotify) {
        return storeSpotify.dispatcher;
    }

    public static final /* synthetic */ Subscription access$getExpireStateSub$p(StoreSpotify storeSpotify) {
        return storeSpotify.expireStateSub;
    }

    public static final /* synthetic */ BehaviorSubject access$getPublishStateTrigger$p(StoreSpotify storeSpotify) {
        return storeSpotify.publishStateTrigger;
    }

    public static final /* synthetic */ SpotifyState access$getSpotifyState$p(StoreSpotify storeSpotify) {
        return storeSpotify.spotifyState;
    }

    public static final /* synthetic */ void access$publishState(StoreSpotify storeSpotify) {
        storeSpotify.publishState();
    }

    public static final /* synthetic */ void access$setExpireStateSub$p(StoreSpotify storeSpotify, Subscription subscription) {
        storeSpotify.expireStateSub = subscription;
    }

    public static final /* synthetic */ void access$setSpotifyState$p(StoreSpotify storeSpotify, SpotifyState spotifyState) {
        storeSpotify.spotifyState = spotifyState;
    }

    public static final /* synthetic */ void access$startStateExpiration(StoreSpotify storeSpotify, long j) {
        storeSpotify.startStateExpiration(j);
    }

    @Store3
    private final void publishState() {
        boolean z2;
        List<ModelSpotifyAlbum.AlbumImage> images;
        List<ModelSpotifyAlbum.AlbumImage> images2;
        ModelSpotifyAlbum.AlbumImage albumImage;
        String url;
        List listSplit$default;
        if (this.spotifyState == null) {
            this.stream.getPresences().updateActivity(ActivityType.LISTENING, null, true);
            return;
        }
        StoreUserConnections.State stateSnapshot = this.stream.getUserConnections().getStateSnapshot();
        if ((stateSnapshot instanceof Collection) && stateSnapshot.isEmpty()) {
            z2 = false;
        } else {
            for (ConnectedAccount connectedAccount : stateSnapshot) {
                if (Intrinsics3.areEqual(connectedAccount.getType(), Platform.SPOTIFY.getPlatformId()) && connectedAccount.getShowActivity()) {
                    z2 = true;
                    break;
                }
            }
            z2 = false;
        }
        if (z2) {
            SpotifyState spotifyState = this.spotifyState;
            Intrinsics3.checkNotNull(spotifyState);
            ModelSpotifyTrack track = spotifyState.getTrack();
            boolean playing = spotifyState.getPlaying();
            long start = spotifyState.getStart();
            if (!playing || track == null) {
                this.stream.getPresences().updateActivity(ActivityType.LISTENING, null, true);
                return;
            }
            ModelSpotifyAlbum album = track.getAlbum();
            String str = (album == null || (images2 = album.getImages()) == null || (albumImage = (ModelSpotifyAlbum.AlbumImage) _Collections.firstOrNull((List) images2)) == null || (url = albumImage.getUrl()) == null || (listSplit$default = Strings4.split$default((CharSequence) url, new String[]{AutocompleteViewModel.COMMAND_DISCOVER_TOKEN}, false, 0, 6, (Object) null)) == null) ? null : (String) _Collections.last(listSplit$default);
            String str2 = str != null ? Platform.SPOTIFY.getPlatformId() + MentionUtils.EMOJIS_AND_STICKERS_CHAR + str : null;
            long jCurrentTimeMillis = this.clock.currentTimeMillis();
            Platform platform = Platform.SPOTIFY;
            String properName = platform.getProperName();
            String name = track.getName();
            String id2 = track.getId();
            ModelSpotifyAlbum album2 = track.getAlbum();
            this.stream.getPresences().updateActivity(ActivityType.LISTENING, ActivityUtils.createSpotifyListeningActivity(jCurrentTimeMillis, properName, name, id2, album2 != null ? album2.getName() : null, str2, _Collections.joinToString$default(track.getArtists(), null, null, null, 0, null, StoreSpotify2.INSTANCE, 31, null), start, track.getDurationMs() + start, platform.getPlatformId() + MentionUtils.EMOJIS_AND_STICKERS_CHAR + this.stream.getUsers().getMe().getId()), true);
            AnalyticsTracker analyticsTracker = AnalyticsTracker.INSTANCE;
            String id3 = track.getId();
            ModelSpotifyAlbum album3 = track.getAlbum();
            analyticsTracker.activityUpdatedSpotify(id3, (album3 == null || (images = album3.getImages()) == null || images.isEmpty()) ? false : true);
        }
    }

    @Store3
    private final void startStateExpiration(long timeLeftMs) {
        Observable<Long> observableD0 = Observable.d0(timeLeftMs + 5000, TimeUnit.MILLISECONDS);
        Intrinsics3.checkNotNullExpressionValue(observableD0, "Observable\n        .time…), TimeUnit.MILLISECONDS)");
        ObservableExtensionsKt.appSubscribe$default(observableD0, StoreSpotify.class, (Context) null, new AnonymousClass1(), (Function1) null, (Function0) null, (Function0) null, new AnonymousClass2(), 58, (Object) null);
    }

    @Store3
    public final void handleConnectionOpen(ModelPayload payload) {
        Intrinsics3.checkNotNullParameter(payload, "payload");
        List<ConnectedAccount> connectedAccounts = payload.getConnectedAccounts();
        Intrinsics3.checkNotNullExpressionValue(connectedAccounts, "payload.connectedAccounts");
        handleUserConnections(connectedAccounts);
        this.publishStateTrigger.onNext(Unit.a);
    }

    @Store3
    public final void handleConnectionReady(boolean ready) {
        if (ready) {
            this.publishStateTrigger.onNext(Unit.a);
        }
    }

    @Store3
    public final void handlePreLogout() {
        this.spotifyState = null;
    }

    @Store3
    public final void handleUserConnections(List<ConnectedAccount> accounts) {
        Object next;
        Intrinsics3.checkNotNullParameter(accounts, "accounts");
        Iterator<T> it = accounts.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            } else {
                next = it.next();
                if (StringsJVM.equals(Platform.SPOTIFY.name(), ((ConnectedAccount) next).getType(), true)) {
                    break;
                }
            }
        }
        ConnectedAccount connectedAccount = (ConnectedAccount) next;
        this.spotifyApiClient.setSpotifyAccountId(connectedAccount != null ? connectedAccount.getId() : null);
    }

    public final void init(Context context) {
        Intrinsics3.checkNotNullParameter(context, "context");
        SpotifyHelper.registerSpotifyBroadcastReceivers(context);
        Observable observableP = Observable.j(this.publishStateTrigger, this.spotifyApiClient.getSpotifyTrack().Y(AnonymousClass1.INSTANCE).r(), AnonymousClass2.INSTANCE).p(2L, TimeUnit.SECONDS);
        Intrinsics3.checkNotNullExpressionValue(observableP, "Observable.combineLatest…unce(2, TimeUnit.SECONDS)");
        ObservableExtensionsKt.appSubscribe$default(observableP, StoreSpotify.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass3(), 62, (Object) null);
    }

    public final void setCurrentTrackId(String trackId) {
        Intrinsics3.checkNotNullParameter(trackId, "trackId");
        this.spotifyApiClient.fetchSpotifyTrack(trackId);
    }

    public final void setPlayingStatus(boolean playing, int position) {
        this.dispatcher.schedule(new AnonymousClass1(playing, position));
    }
}
