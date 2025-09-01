package com.discord.stores;

import android.content.Context;
import com.discord.api.user.User;
import com.discord.api.user.UserProfile;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeck4;
import com.discord.utilities.error.Error;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.t.Maps6;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.objectweb.asm.Opcodes;
import rx.Observable;

/* compiled from: StoreUserProfile.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 72\u00020\u0001:\u00017B+\u0012\u0006\u0010-\u001a\u00020,\u0012\b\b\u0002\u0010$\u001a\u00020#\u0012\u0006\u0010*\u001a\u00020)\u0012\b\b\u0002\u0010'\u001a\u00020&¢\u0006\u0004\b5\u00106J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u001b\u0010\n\u001a\u00020\u00042\n\u0010\t\u001a\u00060\u0007j\u0002`\bH\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0019\u0010\r\u001a\u00020\f2\n\u0010\t\u001a\u00060\u0007j\u0002`\b¢\u0006\u0004\b\r\u0010\u000eJ\u001f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\f0\u000f2\n\u0010\t\u001a\u00060\u0007j\u0002`\b¢\u0006\u0004\b\u0010\u0010\u0011JM\u0010\u0018\u001a\u00020\u00042\n\u0010\t\u001a\u00060\u0007j\u0002`\b2\u0010\b\u0002\u0010\u0013\u001a\n\u0018\u00010\u0007j\u0004\u0018\u0001`\u00122\b\b\u0002\u0010\u0015\u001a\u00020\u00142\u0016\b\u0002\u0010\u0017\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u0015\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u001a\u0010\u0006J\u0017\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\fH\u0007¢\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010\u001e\u001a\u00020\u0004H\u0017¢\u0006\u0004\b\u001e\u0010\u001fR&\u0010!\u001a\u0012\u0012\b\u0012\u00060\u0007j\u0002`\b\u0012\u0004\u0012\u00020\f0 8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010$\u001a\u00020#8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b$\u0010%R\u0016\u0010'\u001a\u00020&8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010*\u001a\u00020)8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b*\u0010+R\u0016\u0010-\u001a\u00020,8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b-\u0010.R&\u00100\u001a\u0012\u0012\b\u0012\u00060\u0007j\u0002`\b\u0012\u0004\u0012\u00020\f0/8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b0\u00101R \u00103\u001a\f\u0012\b\u0012\u00060\u0007j\u0002`\b028\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b3\u00104¨\u00068"}, d2 = {"Lcom/discord/stores/StoreUserProfile;", "Lcom/discord/stores/StoreV2;", "Lcom/discord/api/user/User;", "user", "", "handleUser", "(Lcom/discord/api/user/User;)V", "", "Lcom/discord/primitives/UserId;", "userId", "handleFailure", "(J)V", "Lcom/discord/api/user/UserProfile;", "getUserProfile", "(J)Lcom/discord/api/user/UserProfile;", "Lrx/Observable;", "observeUserProfile", "(J)Lrx/Observable;", "Lcom/discord/primitives/GuildId;", "guildId", "", "withMutualGuilds", "Lkotlin/Function1;", "onFetchSuccess", "fetchProfile", "(JLjava/lang/Long;ZLkotlin/jvm/functions/Function1;)V", "updateUser", "userProfile", "handleUserProfile", "(Lcom/discord/api/user/UserProfile;)V", "snapshotData", "()V", "Ljava/util/HashMap;", "profiles", "Ljava/util/HashMap;", "Lcom/discord/stores/updates/ObservationDeck;", "observationDeck", "Lcom/discord/stores/updates/ObservationDeck;", "Lcom/discord/utilities/rest/RestAPI;", "restAPI", "Lcom/discord/utilities/rest/RestAPI;", "Lcom/discord/stores/StoreStream;", "storeStream", "Lcom/discord/stores/StoreStream;", "Lcom/discord/stores/Dispatcher;", "dispatcher", "Lcom/discord/stores/Dispatcher;", "", "profilesSnapshot", "Ljava/util/Map;", "Ljava/util/HashSet;", "profilesLoading", "Ljava/util/HashSet;", "<init>", "(Lcom/discord/stores/Dispatcher;Lcom/discord/stores/updates/ObservationDeck;Lcom/discord/stores/StoreStream;Lcom/discord/utilities/rest/RestAPI;)V", "Companion", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class StoreUserProfile extends StoreV2 {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final UserProfile EMPTY_PROFILE = new UserProfile(null, null, null, null, null, null, null, Opcodes.LAND);
    private final Dispatcher dispatcher;
    private final ObservationDeck observationDeck;
    private final HashMap<Long, UserProfile> profiles;
    private final HashSet<Long> profilesLoading;
    private Map<Long, UserProfile> profilesSnapshot;
    private final RestAPI restAPI;
    private final StoreStream storeStream;

    /* compiled from: StoreUserProfile.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0019\u0010\u0003\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/discord/stores/StoreUserProfile$Companion;", "", "Lcom/discord/api/user/UserProfile;", "EMPTY_PROFILE", "Lcom/discord/api/user/UserProfile;", "getEMPTY_PROFILE", "()Lcom/discord/api/user/UserProfile;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public final UserProfile getEMPTY_PROFILE() {
            return StoreUserProfile.access$getEMPTY_PROFILE$cp();
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: StoreUserProfile.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreUserProfile$fetchProfile$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ Long $guildId;
        public final /* synthetic */ Function1 $onFetchSuccess;
        public final /* synthetic */ long $userId;
        public final /* synthetic */ boolean $withMutualGuilds;

        /* compiled from: StoreUserProfile.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/api/user/UserProfile;", "userProfile", "", "invoke", "(Lcom/discord/api/user/UserProfile;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
        /* renamed from: com.discord.stores.StoreUserProfile$fetchProfile$1$1, reason: invalid class name and collision with other inner class name */
        public static final class C01891 extends Lambda implements Function1<UserProfile, Unit> {

            /* compiled from: StoreUserProfile.kt */
            @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
            /* renamed from: com.discord.stores.StoreUserProfile$fetchProfile$1$1$1, reason: invalid class name and collision with other inner class name */
            public static final class C01901 extends Lambda implements Function0<Unit> {
                public final /* synthetic */ UserProfile $userProfile;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public C01901(UserProfile userProfile) {
                    super(0);
                    this.$userProfile = userProfile;
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.a;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    if (this.$userProfile != null) {
                        StoreUserProfile.access$getStoreStream$p(StoreUserProfile.this).handleUserProfile(this.$userProfile, AnonymousClass1.this.$guildId);
                        Function1 function1 = AnonymousClass1.this.$onFetchSuccess;
                        if (function1 != null) {
                        }
                    }
                }
            }

            public C01891() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(UserProfile userProfile) {
                invoke2(userProfile);
                return Unit.a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(UserProfile userProfile) {
                StoreUserProfile.access$getDispatcher$p(StoreUserProfile.this).schedule(new C01901(userProfile));
            }
        }

        /* compiled from: StoreUserProfile.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/utilities/error/Error;", "it", "", "invoke", "(Lcom/discord/utilities/error/Error;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
        /* renamed from: com.discord.stores.StoreUserProfile$fetchProfile$1$2, reason: invalid class name */
        public static final class AnonymousClass2 extends Lambda implements Function1<Error, Unit> {

            /* compiled from: StoreUserProfile.kt */
            @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
            /* renamed from: com.discord.stores.StoreUserProfile$fetchProfile$1$2$1, reason: invalid class name and collision with other inner class name */
            public static final class C01911 extends Lambda implements Function0<Unit> {
                public C01911() {
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
                    StoreUserProfile.access$handleFailure(StoreUserProfile.this, anonymousClass1.$userId);
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
                StoreUserProfile.access$getDispatcher$p(StoreUserProfile.this).schedule(new C01911());
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(long j, Long l, boolean z2, Function1 function1) {
            super(0);
            this.$userId = j;
            this.$guildId = l;
            this.$withMutualGuilds = z2;
            this.$onFetchSuccess = function1;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            if (StoreUserProfile.access$getProfilesLoading$p(StoreUserProfile.this).contains(Long.valueOf(this.$userId))) {
                return;
            }
            StoreUserProfile.access$getProfilesLoading$p(StoreUserProfile.this).add(Long.valueOf(this.$userId));
            Observable observableR = ObservableExtensionsKt.restSubscribeOn$default(StoreUserProfile.access$getRestAPI$p(StoreUserProfile.this).userProfileGet(this.$userId, this.$withMutualGuilds, this.$guildId), false, 1, null).r();
            Intrinsics3.checkNotNullExpressionValue(observableR, "restAPI\n          .userP…  .distinctUntilChanged()");
            ObservableExtensionsKt.appSubscribe$default(observableR, StoreUserProfile.this.getClass(), (Context) null, (Function1) null, new AnonymousClass2(), (Function0) null, (Function0) null, new C01891(), 54, (Object) null);
        }
    }

    /* compiled from: StoreUserProfile.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lcom/discord/api/user/UserProfile;", "invoke", "()Lcom/discord/api/user/UserProfile;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreUserProfile$observeUserProfile$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<UserProfile> {
        public final /* synthetic */ long $userId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(long j) {
            super(0);
            this.$userId = j;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ UserProfile invoke() {
            return invoke();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final UserProfile invoke() {
            return StoreUserProfile.this.getUserProfile(this.$userId);
        }
    }

    /* compiled from: StoreUserProfile.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreUserProfile$updateUser$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ User $user;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(User user) {
            super(0);
            this.$user = user;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            StoreUserProfile.access$handleUser(StoreUserProfile.this, this.$user);
        }
    }

    public /* synthetic */ StoreUserProfile(Dispatcher dispatcher, ObservationDeck observationDeck, StoreStream storeStream, RestAPI restAPI, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(dispatcher, (i & 2) != 0 ? ObservationDeck4.get() : observationDeck, storeStream, (i & 8) != 0 ? RestAPI.INSTANCE.getApi() : restAPI);
    }

    public static final /* synthetic */ Dispatcher access$getDispatcher$p(StoreUserProfile storeUserProfile) {
        return storeUserProfile.dispatcher;
    }

    public static final /* synthetic */ UserProfile access$getEMPTY_PROFILE$cp() {
        return EMPTY_PROFILE;
    }

    public static final /* synthetic */ HashSet access$getProfilesLoading$p(StoreUserProfile storeUserProfile) {
        return storeUserProfile.profilesLoading;
    }

    public static final /* synthetic */ RestAPI access$getRestAPI$p(StoreUserProfile storeUserProfile) {
        return storeUserProfile.restAPI;
    }

    public static final /* synthetic */ StoreStream access$getStoreStream$p(StoreUserProfile storeUserProfile) {
        return storeUserProfile.storeStream;
    }

    public static final /* synthetic */ void access$handleFailure(StoreUserProfile storeUserProfile, long j) {
        storeUserProfile.handleFailure(j);
    }

    public static final /* synthetic */ void access$handleUser(StoreUserProfile storeUserProfile, User user) {
        storeUserProfile.handleUser(user);
    }

    public static /* synthetic */ void fetchProfile$default(StoreUserProfile storeUserProfile, long j, Long l, boolean z2, Function1 function1, int i, Object obj) {
        storeUserProfile.fetchProfile(j, (i & 2) != 0 ? null : l, (i & 4) != 0 ? false : z2, (i & 8) != 0 ? null : function1);
    }

    @Store3
    private final void handleFailure(long userId) {
        this.profilesLoading.remove(Long.valueOf(userId));
    }

    @Store3
    private final void handleUser(User user) {
        UserProfile userProfile = this.profiles.get(Long.valueOf(user.getId()));
        if (userProfile != null) {
            Intrinsics3.checkNotNullExpressionValue(userProfile, "profiles[user.id] ?: return");
            this.profiles.put(Long.valueOf(user.getId()), new UserProfile(userProfile.b(), userProfile.d(), user, userProfile.getPremiumSince(), userProfile.getPremiumGuildSince(), null, userProfile.getApplication()));
            markChanged();
        }
    }

    public final void fetchProfile(long userId, Long guildId, boolean withMutualGuilds, Function1<? super UserProfile, Unit> onFetchSuccess) {
        this.dispatcher.schedule(new AnonymousClass1(userId, guildId, withMutualGuilds, onFetchSuccess));
    }

    public final UserProfile getUserProfile(long userId) {
        UserProfile userProfile = this.profilesSnapshot.get(Long.valueOf(userId));
        return userProfile != null ? userProfile : EMPTY_PROFILE;
    }

    @Store3
    public final void handleUserProfile(UserProfile userProfile) {
        Intrinsics3.checkNotNullParameter(userProfile, "userProfile");
        long id2 = userProfile.getUser().getId();
        this.profilesLoading.remove(Long.valueOf(id2));
        this.profiles.put(Long.valueOf(id2), userProfile);
        markChanged();
    }

    public final Observable<UserProfile> observeUserProfile(long userId) {
        Observable<UserProfile> observableR = ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, false, null, null, new AnonymousClass1(userId), 14, null).r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "observationDeck.connectR… }.distinctUntilChanged()");
        return observableR;
    }

    @Override // com.discord.stores.StoreV2
    @Store3
    public void snapshotData() {
        super.snapshotData();
        this.profilesSnapshot = new HashMap(this.profiles);
    }

    public final void updateUser(User user) {
        Intrinsics3.checkNotNullParameter(user, "user");
        this.dispatcher.schedule(new AnonymousClass1(user));
    }

    public StoreUserProfile(Dispatcher dispatcher, ObservationDeck observationDeck, StoreStream storeStream, RestAPI restAPI) {
        Intrinsics3.checkNotNullParameter(dispatcher, "dispatcher");
        Intrinsics3.checkNotNullParameter(observationDeck, "observationDeck");
        Intrinsics3.checkNotNullParameter(storeStream, "storeStream");
        Intrinsics3.checkNotNullParameter(restAPI, "restAPI");
        this.dispatcher = dispatcher;
        this.observationDeck = observationDeck;
        this.storeStream = storeStream;
        this.restAPI = restAPI;
        this.profilesLoading = new HashSet<>();
        this.profiles = new HashMap<>();
        this.profilesSnapshot = Maps6.emptyMap();
    }
}
