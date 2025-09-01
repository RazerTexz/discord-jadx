package com.discord.stores;

import android.content.Context;
import android.content.SharedPreferences;
import com.discord.analytics.generated.events.network_action.TrackNetworkActionUserSurveyFetch;
import com.discord.analytics.generated.traits.TrackNetworkMetadata2;
import com.discord.api.guild.GuildFeature;
import com.discord.api.user.UserSurvey;
import com.discord.api.user.UserSurvey2;
import com.discord.api.user.UserSurvey3;
import com.discord.models.guild.Guild;
import com.discord.models.user.MeUser;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.utilities.RestCallState5;
import com.discord.utilities.permissions.PermissionUtils;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.time.Clock;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* compiled from: StoreUserSurvey.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001BI\u0012\u0006\u00100\u001a\u00020/\u0012\u0006\u0010\"\u001a\u00020!\u0012\u0006\u0010\u0019\u001a\u00020\u0018\u0012\u0006\u0010\u001f\u001a\u00020\u001e\u0012\u0006\u0010\u0016\u001a\u00020\u0015\u0012\b\b\u0002\u0010(\u001a\u00020'\u0012\u0006\u0010%\u001a\u00020$\u0012\u0006\u0010-\u001a\u00020,¢\u0006\u0004\b2\u00103J\u0011\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0019\u0010\u000e\u001a\u00020\u00052\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u0005H\u0003¢\u0006\u0004\b\u0010\u0010\u0007J\u0015\u0010\u0012\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0011¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\u0005H\u0007¢\u0006\u0004\b\u0014\u0010\u0007R\u0016\u0010\u0016\u001a\u00020\u00158\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u0019\u001a\u00020\u00188\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001c\u001a\u00020\u001b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0016\u0010\u001f\u001a\u00020\u001e8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010\"\u001a\u00020!8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\"\u0010#R\u0016\u0010%\u001a\u00020$8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010(\u001a\u00020'8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b(\u0010)R\u0018\u0010*\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b*\u0010+R\u0016\u0010-\u001a\u00020,8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b-\u0010.R\u0016\u00100\u001a\u00020/8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b0\u00101¨\u00064"}, d2 = {"Lcom/discord/stores/StoreUserSurvey;", "Lcom/discord/stores/StoreV2;", "Lcom/discord/api/user/UserSurvey;", "getUserSurvey", "()Lcom/discord/api/user/UserSurvey;", "", "setLastFetched", "()V", "survey", "", "meetsGuildRequirements", "(Lcom/discord/api/user/UserSurvey;)Z", "Lcom/discord/api/user/UserSurveyFetchResponse;", "res", "handleUserSurveyFetchSuccess", "(Lcom/discord/api/user/UserSurveyFetchResponse;)V", "fetchUserSurvey", "Lrx/Observable;", "observeUserSurvey", "()Lrx/Observable;", "handleConnectionOpen", "Lcom/discord/stores/updates/ObservationDeck;", "observationDeck", "Lcom/discord/stores/updates/ObservationDeck;", "Lcom/discord/stores/StoreGuilds;", "storeGuilds", "Lcom/discord/stores/StoreGuilds;", "", "refetchIntervalMs", "I", "Lcom/discord/stores/StorePermissions;", "storePermissions", "Lcom/discord/stores/StorePermissions;", "Lcom/discord/stores/StoreUser;", "storeUser", "Lcom/discord/stores/StoreUser;", "Lcom/discord/utilities/time/Clock;", "clock", "Lcom/discord/utilities/time/Clock;", "Lcom/discord/utilities/rest/RestAPI;", "restApi", "Lcom/discord/utilities/rest/RestAPI;", "userSurvey", "Lcom/discord/api/user/UserSurvey;", "Landroid/content/SharedPreferences;", "sharedPreferences", "Landroid/content/SharedPreferences;", "Lcom/discord/stores/Dispatcher;", "dispatcher", "Lcom/discord/stores/Dispatcher;", "<init>", "(Lcom/discord/stores/Dispatcher;Lcom/discord/stores/StoreUser;Lcom/discord/stores/StoreGuilds;Lcom/discord/stores/StorePermissions;Lcom/discord/stores/updates/ObservationDeck;Lcom/discord/utilities/rest/RestAPI;Lcom/discord/utilities/time/Clock;Landroid/content/SharedPreferences;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class StoreUserSurvey extends StoreV2 {
    private final Clock clock;
    private final Dispatcher dispatcher;
    private final ObservationDeck observationDeck;
    private int refetchIntervalMs;
    private final RestAPI restApi;
    private final SharedPreferences sharedPreferences;
    private final StoreGuilds storeGuilds;
    private final StorePermissions storePermissions;
    private final StoreUser storeUser;
    private UserSurvey userSurvey;

    /* compiled from: StoreUserSurvey.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u0004\u0018\u00010\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/api/user/UserSurveyFetchResponse;", "response", "Lcom/discord/analytics/generated/traits/TrackNetworkMetadataReceiver;", "invoke", "(Lcom/discord/api/user/UserSurveyFetchResponse;)Lcom/discord/analytics/generated/traits/TrackNetworkMetadataReceiver;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreUserSurvey$fetchUserSurvey$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<UserSurvey3, TrackNetworkMetadata2> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ TrackNetworkMetadata2 invoke(UserSurvey3 userSurvey3) {
            return invoke2(userSurvey3);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final TrackNetworkMetadata2 invoke2(UserSurvey3 userSurvey3) {
            UserSurvey survey;
            return new TrackNetworkActionUserSurveyFetch((userSurvey3 == null || (survey = userSurvey3.getSurvey()) == null) ? null : survey.getKey());
        }
    }

    /* compiled from: StoreUserSurvey.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/api/user/UserSurveyFetchResponse;", "res", "", "invoke", "(Lcom/discord/api/user/UserSurveyFetchResponse;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreUserSurvey$fetchUserSurvey$2, reason: invalid class name */
    public static final class AnonymousClass2 extends Lambda implements Function1<UserSurvey3, Unit> {

        /* compiled from: StoreUserSurvey.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
        /* renamed from: com.discord.stores.StoreUserSurvey$fetchUserSurvey$2$1, reason: invalid class name */
        public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
            public final /* synthetic */ UserSurvey3 $res;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(UserSurvey3 userSurvey3) {
                super(0);
                this.$res = userSurvey3;
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                StoreUserSurvey.access$handleUserSurveyFetchSuccess(StoreUserSurvey.this, this.$res);
            }
        }

        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(UserSurvey3 userSurvey3) {
            invoke2(userSurvey3);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(UserSurvey3 userSurvey3) {
            Intrinsics3.checkNotNullParameter(userSurvey3, "res");
            StoreUserSurvey.access$getDispatcher$p(StoreUserSurvey.this).schedule(new AnonymousClass1(userSurvey3));
        }
    }

    /* compiled from: StoreUserSurvey.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lcom/discord/api/user/UserSurvey;", "invoke", "()Lcom/discord/api/user/UserSurvey;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreUserSurvey$observeUserSurvey$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<UserSurvey> {
        public AnonymousClass1() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ UserSurvey invoke() {
            return invoke();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final UserSurvey invoke() {
            return StoreUserSurvey.access$getUserSurvey(StoreUserSurvey.this);
        }
    }

    public /* synthetic */ StoreUserSurvey(Dispatcher dispatcher, StoreUser storeUser, StoreGuilds storeGuilds, StorePermissions storePermissions, ObservationDeck observationDeck, RestAPI restAPI, Clock clock, SharedPreferences sharedPreferences, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(dispatcher, storeUser, storeGuilds, storePermissions, observationDeck, (i & 32) != 0 ? RestAPI.INSTANCE.getApi() : restAPI, clock, sharedPreferences);
    }

    public static final /* synthetic */ Dispatcher access$getDispatcher$p(StoreUserSurvey storeUserSurvey) {
        return storeUserSurvey.dispatcher;
    }

    public static final /* synthetic */ UserSurvey access$getUserSurvey(StoreUserSurvey storeUserSurvey) {
        return storeUserSurvey.getUserSurvey();
    }

    public static final /* synthetic */ void access$handleUserSurveyFetchSuccess(StoreUserSurvey storeUserSurvey, UserSurvey3 userSurvey3) {
        storeUserSurvey.handleUserSurveyFetchSuccess(userSurvey3);
    }

    @Store3
    private final void fetchUserSurvey() {
        setLastFetched();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.restSubscribeOn$default(RestCallState5.logNetworkAction(this.restApi.getUserSurvey(), AnonymousClass1.INSTANCE), false, 1, null), StoreUserSurvey.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass2(), 62, (Object) null);
    }

    private final UserSurvey getUserSurvey() {
        return this.userSurvey;
    }

    @Store3
    private final void handleUserSurveyFetchSuccess(UserSurvey3 res) {
        UserSurvey survey;
        if (res == null || (survey = res.getSurvey()) == null || !meetsGuildRequirements(survey)) {
            return;
        }
        this.userSurvey = survey;
        markChanged();
    }

    private final boolean meetsGuildRequirements(UserSurvey survey) {
        boolean z2;
        List<String> listC = survey.c();
        if (listC.isEmpty()) {
            return true;
        }
        Iterator<String> it = listC.iterator();
        while (it.hasNext()) {
            if (!StoreUserSurvey2.getIMPLEMENTED_GUILD_REQUIREMENTS().contains(it.next())) {
                return false;
            }
        }
        MeUser meSnapshot = this.storeUser.getMeSnapshot();
        for (Map.Entry<Long, Guild> entry : this.storeGuilds.getGuilds().entrySet()) {
            long jLongValue = entry.getKey().longValue();
            Guild value = entry.getValue();
            if (!listC.contains(UserSurvey2.IS_COMMUNITY.getValue()) || value.getFeatures().contains(GuildFeature.COMMUNITY)) {
                if (!listC.contains(UserSurvey2.IS_HUB.getValue()) || value.getFeatures().contains(GuildFeature.HUB)) {
                    if (listC.contains(UserSurvey2.GUILD_SIZE.getValue())) {
                        Integer num = survey.d().get(0);
                        Integer num2 = survey.d().get(1);
                        int memberCount = value.getMemberCount();
                        if (num == null || memberCount >= num.intValue()) {
                            if (num2 == null || memberCount <= num2.intValue()) {
                            }
                        }
                    }
                    Map<Long, Long> guildPermissions = this.storePermissions.getGuildPermissions();
                    if (listC.contains(UserSurvey2.GUILD_PERMISSIONS.getValue())) {
                        List<Long> listB = survey.b();
                        if (listB.isEmpty()) {
                            continue;
                        } else {
                            Iterator<Long> it2 = listB.iterator();
                            while (true) {
                                if (!it2.hasNext()) {
                                    z2 = false;
                                    break;
                                }
                                if (PermissionUtils.can(it2.next().longValue(), guildPermissions.get(Long.valueOf(jLongValue)))) {
                                    z2 = true;
                                    break;
                                }
                            }
                            if (!z2) {
                                continue;
                            }
                        }
                    }
                    boolean zIsOwner = value.isOwner(meSnapshot.getId());
                    boolean zCan = PermissionUtils.can(8L, guildPermissions.get(Long.valueOf(jLongValue)));
                    if (!listC.contains(UserSurvey2.IS_OWNER.getValue()) || zIsOwner) {
                        if (!listC.contains(UserSurvey2.IS_ADMIN.getValue()) || zCan) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    private final void setLastFetched() {
        this.sharedPreferences.edit().putLong("CACHE_KEY_USER_SURVEY_LAST_FETCHED", this.clock.currentTimeMillis()).apply();
    }

    @Store3
    public final void handleConnectionOpen() {
        if (this.clock.currentTimeMillis() - this.sharedPreferences.getLong("CACHE_KEY_USER_SURVEY_LAST_FETCHED", 0L) > this.refetchIntervalMs) {
            fetchUserSurvey();
        }
    }

    public final Observable<UserSurvey> observeUserSurvey() {
        return ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, false, null, null, new AnonymousClass1(), 14, null);
    }

    public StoreUserSurvey(Dispatcher dispatcher, StoreUser storeUser, StoreGuilds storeGuilds, StorePermissions storePermissions, ObservationDeck observationDeck, RestAPI restAPI, Clock clock, SharedPreferences sharedPreferences) {
        Intrinsics3.checkNotNullParameter(dispatcher, "dispatcher");
        Intrinsics3.checkNotNullParameter(storeUser, "storeUser");
        Intrinsics3.checkNotNullParameter(storeGuilds, "storeGuilds");
        Intrinsics3.checkNotNullParameter(storePermissions, "storePermissions");
        Intrinsics3.checkNotNullParameter(observationDeck, "observationDeck");
        Intrinsics3.checkNotNullParameter(restAPI, "restApi");
        Intrinsics3.checkNotNullParameter(clock, "clock");
        Intrinsics3.checkNotNullParameter(sharedPreferences, "sharedPreferences");
        this.dispatcher = dispatcher;
        this.storeUser = storeUser;
        this.storeGuilds = storeGuilds;
        this.storePermissions = storePermissions;
        this.observationDeck = observationDeck;
        this.restApi = restAPI;
        this.clock = clock;
        this.sharedPreferences = sharedPreferences;
        this.refetchIntervalMs = 86400000;
    }
}
