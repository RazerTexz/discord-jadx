package com.discord.utilities.spotify;

import android.annotation.SuppressLint;
import android.content.Context;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.domain.ModelConnectionAccessToken;
import com.discord.models.domain.spotify.ModelSpotifyTrack;
import com.discord.utilities.error.Error;
import com.discord.utilities.platform.Platform;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.time.Clock;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.HashMap;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import rx.Observable;
import rx.Subscription;
import rx.subjects.BehaviorSubject;

/* compiled from: SpotifyApiClient.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010-\u001a\u00020,¢\u0006\u0004\b3\u00104J\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\t\u0010\nJ\u0011\u0010\u000b\u001a\u0004\u0018\u00010\u0002H\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0019\u0010\r\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u0010\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0016\u001a\u00020\u0015H\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0018\u001a\u00020\bH\u0003¢\u0006\u0004\b\u0018\u0010\u0019J\u0015\u0010\u001b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u001a¢\u0006\u0004\b\u001b\u0010\u001cJ\u0015\u0010\u001d\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u001d\u0010\u000eJ\u0017\u0010\u001f\u001a\u00020\b2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u001f\u0010\u000eR\u0018\u0010!\u001a\u0004\u0018\u00010 8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b!\u0010\"R\u0018\u0010#\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b#\u0010$R\u0018\u0010%\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b%\u0010$R\u0016\u0010&\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b&\u0010'R2\u0010*\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040(j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0004`)8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b*\u0010+R\u0016\u0010-\u001a\u00020,8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b-\u0010.R:\u00101\u001a&\u0012\f\u0012\n 0*\u0004\u0018\u00010\u00040\u0004 0*\u0012\u0012\f\u0012\n 0*\u0004\u0018\u00010\u00040\u0004\u0018\u00010/0/8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b1\u00102¨\u00065"}, d2 = {"Lcom/discord/utilities/spotify/SpotifyApiClient;", "", "", "trackId", "Lcom/discord/models/domain/spotify/ModelSpotifyTrack;", "getCachedTrack", "(Ljava/lang/String;)Lcom/discord/models/domain/spotify/ModelSpotifyTrack;", "track", "", "setCachedTrack", "(Lcom/discord/models/domain/spotify/ModelSpotifyTrack;)V", "getTrackIdToFetch", "()Ljava/lang/String;", "setTrackIdToFetch", "(Ljava/lang/String;)V", "", "getTokenExpiresAt", "()J", "expiresAt", "setTokenExpiresAt", "(J)V", "", "isTokenExpiring", "()Z", "refreshSpotifyToken", "()V", "Lrx/Observable;", "getSpotifyTrack", "()Lrx/Observable;", "fetchSpotifyTrack", ModelAuditLogEntry.CHANGE_KEY_ID, "setSpotifyAccountId", "Lrx/Subscription;", "tokenSubscription", "Lrx/Subscription;", "spotifyAccountId", "Ljava/lang/String;", "trackIdToFetch", "tokenExpiresAt", "J", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "spotifyTracks", "Ljava/util/HashMap;", "Lcom/discord/utilities/time/Clock;", "clock", "Lcom/discord/utilities/time/Clock;", "Lrx/subjects/BehaviorSubject;", "kotlin.jvm.PlatformType", "spotifyTrackSubject", "Lrx/subjects/BehaviorSubject;", "<init>", "(Lcom/discord/utilities/time/Clock;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class SpotifyApiClient {
    private final Clock clock;
    private String spotifyAccountId;
    private final BehaviorSubject<ModelSpotifyTrack> spotifyTrackSubject;
    private final HashMap<String, ModelSpotifyTrack> spotifyTracks;
    private long tokenExpiresAt;
    private Subscription tokenSubscription;
    private String trackIdToFetch;

    /* compiled from: SpotifyApiClient.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/utilities/error/Error;", "it", "", "invoke", "(Lcom/discord/utilities/error/Error;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.utilities.spotify.SpotifyApiClient$fetchSpotifyTrack$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<Error, Unit> {
        public final /* synthetic */ String $trackId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(String str) {
            super(1);
            this.$trackId = str;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Error error) {
            invoke2(error);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Error error) {
            Intrinsics3.checkNotNullParameter(error, "it");
            Error.Response response = error.getResponse();
            Intrinsics3.checkNotNullExpressionValue(response, "it.response");
            if (response.getCode() == 401) {
                SpotifyApiClient.access$setTrackIdToFetch(SpotifyApiClient.this, this.$trackId);
                SpotifyApiClient.access$refreshSpotifyToken(SpotifyApiClient.this);
            }
        }
    }

    /* compiled from: SpotifyApiClient.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/models/domain/spotify/ModelSpotifyTrack;", "track", "", "invoke", "(Lcom/discord/models/domain/spotify/ModelSpotifyTrack;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.utilities.spotify.SpotifyApiClient$fetchSpotifyTrack$2, reason: invalid class name */
    public static final class AnonymousClass2 extends Lambda implements Function1<ModelSpotifyTrack, Unit> {
        public final /* synthetic */ String $trackId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(String str) {
            super(1);
            this.$trackId = str;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ModelSpotifyTrack modelSpotifyTrack) {
            invoke2(modelSpotifyTrack);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ModelSpotifyTrack modelSpotifyTrack) {
            Intrinsics3.checkNotNullParameter(modelSpotifyTrack, "track");
            SpotifyApiClient.access$setCachedTrack(SpotifyApiClient.this, modelSpotifyTrack);
            SpotifyApiClient.access$getSpotifyTrackSubject$p(SpotifyApiClient.this).onNext(SpotifyApiClient.access$getCachedTrack(SpotifyApiClient.this, this.$trackId));
        }
    }

    /* compiled from: SpotifyApiClient.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/models/domain/ModelConnectionAccessToken;", "spotifyToken", "", "invoke", "(Lcom/discord/models/domain/ModelConnectionAccessToken;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.utilities.spotify.SpotifyApiClient$refreshSpotifyToken$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<ModelConnectionAccessToken, Unit> {

        /* compiled from: SpotifyApiClient.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()Ljava/lang/String;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
        /* renamed from: com.discord.utilities.spotify.SpotifyApiClient$refreshSpotifyToken$1$1, reason: invalid class name and collision with other inner class name */
        public static final class C02241 extends Lambda implements Function0<String> {
            public final /* synthetic */ ModelConnectionAccessToken $spotifyToken;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C02241(ModelConnectionAccessToken modelConnectionAccessToken) {
                super(0);
                this.$spotifyToken = modelConnectionAccessToken;
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ String invoke() {
                return invoke2();
            }

            @Override // kotlin.jvm.functions.Function0
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final String invoke2() {
                return this.$spotifyToken.getAccessToken();
            }
        }

        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ModelConnectionAccessToken modelConnectionAccessToken) {
            invoke2(modelConnectionAccessToken);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ModelConnectionAccessToken modelConnectionAccessToken) {
            Intrinsics3.checkNotNullParameter(modelConnectionAccessToken, "spotifyToken");
            RestAPI.AppHeadersProvider.spotifyTokenProvider = new C02241(modelConnectionAccessToken);
            SpotifyApiClient spotifyApiClient = SpotifyApiClient.this;
            SpotifyApiClient.access$setTokenExpiresAt(spotifyApiClient, SpotifyApiClient.access$getClock$p(spotifyApiClient).currentTimeMillis() + 3600000);
            String strAccess$getTrackIdToFetch = SpotifyApiClient.access$getTrackIdToFetch(SpotifyApiClient.this);
            if (strAccess$getTrackIdToFetch != null) {
                SpotifyApiClient.this.fetchSpotifyTrack(strAccess$getTrackIdToFetch);
                SpotifyApiClient.access$setTrackIdToFetch(SpotifyApiClient.this, null);
            }
        }
    }

    /* compiled from: SpotifyApiClient.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lrx/Subscription;", "it", "", "invoke", "(Lrx/Subscription;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.utilities.spotify.SpotifyApiClient$refreshSpotifyToken$2, reason: invalid class name */
    public static final class AnonymousClass2 extends Lambda implements Function1<Subscription, Unit> {
        public AnonymousClass2() {
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
            SpotifyApiClient.access$setTokenSubscription$p(SpotifyApiClient.this, subscription);
        }
    }

    public SpotifyApiClient(Clock clock) {
        Intrinsics3.checkNotNullParameter(clock, "clock");
        this.clock = clock;
        this.spotifyTracks = new HashMap<>();
        this.spotifyTrackSubject = BehaviorSubject.k0();
    }

    public static final /* synthetic */ ModelSpotifyTrack access$getCachedTrack(SpotifyApiClient spotifyApiClient, String str) {
        return spotifyApiClient.getCachedTrack(str);
    }

    public static final /* synthetic */ Clock access$getClock$p(SpotifyApiClient spotifyApiClient) {
        return spotifyApiClient.clock;
    }

    public static final /* synthetic */ BehaviorSubject access$getSpotifyTrackSubject$p(SpotifyApiClient spotifyApiClient) {
        return spotifyApiClient.spotifyTrackSubject;
    }

    public static final /* synthetic */ Subscription access$getTokenSubscription$p(SpotifyApiClient spotifyApiClient) {
        return spotifyApiClient.tokenSubscription;
    }

    public static final /* synthetic */ String access$getTrackIdToFetch(SpotifyApiClient spotifyApiClient) {
        return spotifyApiClient.getTrackIdToFetch();
    }

    public static final /* synthetic */ void access$refreshSpotifyToken(SpotifyApiClient spotifyApiClient) {
        spotifyApiClient.refreshSpotifyToken();
    }

    public static final /* synthetic */ void access$setCachedTrack(SpotifyApiClient spotifyApiClient, ModelSpotifyTrack modelSpotifyTrack) {
        spotifyApiClient.setCachedTrack(modelSpotifyTrack);
    }

    public static final /* synthetic */ void access$setTokenExpiresAt(SpotifyApiClient spotifyApiClient, long j) {
        spotifyApiClient.setTokenExpiresAt(j);
    }

    public static final /* synthetic */ void access$setTokenSubscription$p(SpotifyApiClient spotifyApiClient, Subscription subscription) {
        spotifyApiClient.tokenSubscription = subscription;
    }

    public static final /* synthetic */ void access$setTrackIdToFetch(SpotifyApiClient spotifyApiClient, String str) {
        spotifyApiClient.setTrackIdToFetch(str);
    }

    private final synchronized ModelSpotifyTrack getCachedTrack(String trackId) {
        return this.spotifyTracks.get(trackId);
    }

    private final synchronized long getTokenExpiresAt() {
        return this.tokenExpiresAt;
    }

    private final synchronized String getTrackIdToFetch() {
        return this.trackIdToFetch;
    }

    private final boolean isTokenExpiring() {
        return this.clock.currentTimeMillis() >= getTokenExpiresAt() - 10000;
    }

    @SuppressLint({"DefaultLocale"})
    private final void refreshSpotifyToken() {
        String str;
        Subscription subscription = this.tokenSubscription;
        if ((subscription == null || (subscription != null && subscription.isUnsubscribed())) && (str = this.spotifyAccountId) != null) {
            RestAPI api = RestAPI.INSTANCE.getApi();
            String strName = Platform.SPOTIFY.name();
            Objects.requireNonNull(strName, "null cannot be cast to non-null type java.lang.String");
            String lowerCase = strName.toLowerCase();
            Intrinsics3.checkNotNullExpressionValue(lowerCase, "(this as java.lang.String).toLowerCase()");
            ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.restSubscribeOn$default(api.getConnectionAccessToken(lowerCase, str), false, 1, null), SpotifyApiClient.class, (Context) null, new AnonymousClass2(), (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(), 58, (Object) null);
        }
    }

    private final synchronized void setCachedTrack(ModelSpotifyTrack track) {
        this.spotifyTracks.put(track.getId(), track);
    }

    private final synchronized void setTokenExpiresAt(long expiresAt) {
        this.tokenExpiresAt = expiresAt;
    }

    private final synchronized void setTrackIdToFetch(String trackId) {
        this.trackIdToFetch = trackId;
    }

    public final void fetchSpotifyTrack(String trackId) {
        Intrinsics3.checkNotNullParameter(trackId, "trackId");
        if (getCachedTrack(trackId) != null) {
            this.spotifyTrackSubject.onNext(getCachedTrack(trackId));
            return;
        }
        this.spotifyTrackSubject.onNext(null);
        if (!isTokenExpiring()) {
            ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.INSTANCE.getApiSpotify().getSpotifyTrack(trackId), false, 1, null), SpotifyApiClient.class, (Context) null, (Function1) null, new AnonymousClass1(trackId), (Function0) null, (Function0) null, new AnonymousClass2(trackId), 54, (Object) null);
        } else {
            setTrackIdToFetch(trackId);
            refreshSpotifyToken();
        }
    }

    public final Observable<ModelSpotifyTrack> getSpotifyTrack() {
        BehaviorSubject<ModelSpotifyTrack> behaviorSubject = this.spotifyTrackSubject;
        Intrinsics3.checkNotNullExpressionValue(behaviorSubject, "spotifyTrackSubject");
        return behaviorSubject;
    }

    public final void setSpotifyAccountId(String id2) {
        this.spotifyAccountId = id2;
    }
}
