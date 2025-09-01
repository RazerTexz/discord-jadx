package com.discord.widgets.settings;

import androidx.core.app.NotificationCompat;
import com.discord.api.connectedaccounts.ConnectedAccount;
import com.discord.models.domain.ModelUserConsents2;
import com.discord.models.domain.ModelUserSettings;
import com.discord.models.experiments.domain.Experiment;
import com.discord.models.user.MeUser;
import com.discord.restapi.utils.RetryWithDelay;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUser;
import com.discord.utilities.rest.RestAPI;
import com.discord.widgets.settings.WidgetSettingsPrivacy;
import d0.z.d.Intrinsics3;
import j0.k.Func1;
import j0.l.e.ScalarSynchronousObservable;
import j0.p.Schedulers2;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import rx.Observable;
import rx.functions.Func3;

/* compiled from: WidgetSettingsPrivacy.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0007\u001a*\u0012\u000e\b\u0001\u0012\n \u0001*\u0004\u0018\u00010\u00040\u0004 \u0001*\u0014\u0012\u000e\b\u0001\u0012\n \u0001*\u0004\u0018\u00010\u00040\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lcom/discord/widgets/settings/WidgetSettingsPrivacy$LocalState;", "kotlin.jvm.PlatformType", "intermediateModel", "Lrx/Observable;", "Lcom/discord/widgets/settings/WidgetSettingsPrivacy$Model;", NotificationCompat.CATEGORY_CALL, "(Lcom/discord/widgets/settings/WidgetSettingsPrivacy$LocalState;)Lrx/Observable;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class WidgetSettingsPrivacy$Model$Companion$get$3<T, R> implements Func1<WidgetSettingsPrivacy.LocalState, Observable<? extends WidgetSettingsPrivacy.Model>> {
    public static final WidgetSettingsPrivacy$Model$Companion$get$3 INSTANCE = new WidgetSettingsPrivacy$Model$Companion$get$3();

    /* compiled from: WidgetSettingsPrivacy.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\u0006\u001a\n \u0001*\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/discord/models/user/MeUser;", "kotlin.jvm.PlatformType", "it", "", NotificationCompat.CATEGORY_CALL, "(Lcom/discord/models/user/MeUser;)Ljava/lang/Boolean;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.settings.WidgetSettingsPrivacy$Model$Companion$get$3$1, reason: invalid class name */
    public static final class AnonymousClass1<T, R> implements Func1<MeUser, Boolean> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        @Override // j0.k.Func1
        public /* bridge */ /* synthetic */ Boolean call(MeUser meUser) {
            return call2(meUser);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final Boolean call2(MeUser meUser) {
            return Boolean.valueOf(meUser.isVerified());
        }
    }

    /* compiled from: WidgetSettingsPrivacy.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0007\u001a*\u0012\u000e\b\u0001\u0012\n \u0001*\u0004\u0018\u00010\u00040\u0004 \u0001*\u0014\u0012\u000e\b\u0001\u0012\n \u0001*\u0004\u0018\u00010\u00040\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lcom/discord/models/user/MeUser;", "kotlin.jvm.PlatformType", "it", "Lrx/Observable;", "Lcom/discord/utilities/rest/RestAPI$HarvestState;", NotificationCompat.CATEGORY_CALL, "(Lcom/discord/models/user/MeUser;)Lrx/Observable;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.settings.WidgetSettingsPrivacy$Model$Companion$get$3$2, reason: invalid class name */
    public static final class AnonymousClass2<T, R> implements Func1<MeUser, Observable<? extends RestAPI.HarvestState>> {
        public static final AnonymousClass2 INSTANCE = new AnonymousClass2();

        /* compiled from: WidgetSettingsPrivacy.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0006\u001a\n \u0001*\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "kotlin.jvm.PlatformType", "it", "Lcom/discord/utilities/rest/RestAPI$HarvestState;", NotificationCompat.CATEGORY_CALL, "(Ljava/lang/Throwable;)Lcom/discord/utilities/rest/RestAPI$HarvestState;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
        /* renamed from: com.discord.widgets.settings.WidgetSettingsPrivacy$Model$Companion$get$3$2$1, reason: invalid class name */
        public static final class AnonymousClass1<T, R> implements Func1<Throwable, RestAPI.HarvestState> {
            public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

            @Override // j0.k.Func1
            public /* bridge */ /* synthetic */ RestAPI.HarvestState call(Throwable th) {
                return call2(th);
            }

            /* renamed from: call, reason: avoid collision after fix types in other method */
            public final RestAPI.HarvestState call2(Throwable th) {
                return new RestAPI.HarvestState.NeverRequested();
            }
        }

        @Override // j0.k.Func1
        public /* bridge */ /* synthetic */ Observable<? extends RestAPI.HarvestState> call(MeUser meUser) {
            return call2(meUser);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final Observable<? extends RestAPI.HarvestState> call2(MeUser meUser) {
            RetryWithDelay retryWithDelay = RetryWithDelay.INSTANCE;
            Observable<RestAPI.HarvestState> observableJ = RestAPI.INSTANCE.getApi().getHarvestStatusGuarded().J(Schedulers2.c());
            Intrinsics3.checkNotNullExpressionValue(observableJ, "RestAPI\n                …bserveOn(Schedulers.io())");
            return RetryWithDelay.restRetry$default(retryWithDelay, observableJ, 0L, null, null, 7, null).q(500L, TimeUnit.MILLISECONDS).M(AnonymousClass1.INSTANCE);
        }
    }

    /* compiled from: WidgetSettingsPrivacy.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\n\u001a\n \u0001*\u0004\u0018\u00010\u00070\u00072\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u00002\u000e\u0010\u0004\u001a\n \u0001*\u0004\u0018\u00010\u00030\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\n¢\u0006\u0004\b\b\u0010\t"}, d2 = {"Lcom/discord/widgets/settings/WidgetSettingsPrivacy$LocalState;", "kotlin.jvm.PlatformType", "localState", "Lcom/discord/models/domain/Consents;", "consent", "Lcom/discord/utilities/rest/RestAPI$HarvestState;", "harvestState", "Lcom/discord/widgets/settings/WidgetSettingsPrivacy$Model;", NotificationCompat.CATEGORY_CALL, "(Lcom/discord/widgets/settings/WidgetSettingsPrivacy$LocalState;Lcom/discord/models/domain/Consents;Lcom/discord/utilities/rest/RestAPI$HarvestState;)Lcom/discord/widgets/settings/WidgetSettingsPrivacy$Model;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.settings.WidgetSettingsPrivacy$Model$Companion$get$3$3, reason: invalid class name */
    public static final class AnonymousClass3<T1, T2, T3, R> implements Func3<WidgetSettingsPrivacy.LocalState, ModelUserConsents2, RestAPI.HarvestState, WidgetSettingsPrivacy.Model> {
        public static final AnonymousClass3 INSTANCE = new AnonymousClass3();

        @Override // rx.functions.Func3
        public /* bridge */ /* synthetic */ WidgetSettingsPrivacy.Model call(WidgetSettingsPrivacy.LocalState localState, ModelUserConsents2 modelUserConsents2, RestAPI.HarvestState harvestState) {
            return call2(localState, modelUserConsents2, harvestState);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final WidgetSettingsPrivacy.Model call2(WidgetSettingsPrivacy.LocalState localState, ModelUserConsents2 modelUserConsents2, RestAPI.HarvestState harvestState) {
            ConnectedAccount contactSyncConnection = localState.getContactSyncConnection();
            Experiment contactSyncExperiment = localState.getContactSyncExperiment();
            boolean z2 = contactSyncExperiment != null && contactSyncExperiment.getBucket() == 1;
            MeUser me2 = localState.getMe();
            int explicitContentFilter = localState.getExplicitContentFilter();
            boolean defaultRestrictedGuilds = localState.getDefaultRestrictedGuilds();
            ModelUserSettings.FriendSourceFlags friendSourceFlags = localState.getFriendSourceFlags();
            int userDiscoveryFlags = localState.getUserDiscoveryFlags();
            Intrinsics3.checkNotNullExpressionValue(modelUserConsents2, "consent");
            return new WidgetSettingsPrivacy.Model(me2, explicitContentFilter, defaultRestrictedGuilds, friendSourceFlags, userDiscoveryFlags, contactSyncConnection, z2, modelUserConsents2, harvestState);
        }
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends WidgetSettingsPrivacy.Model> call2(WidgetSettingsPrivacy.LocalState localState) {
        ScalarSynchronousObservable scalarSynchronousObservable = new ScalarSynchronousObservable(localState);
        StoreStream.Companion companion = StoreStream.INSTANCE;
        return Observable.i(scalarSynchronousObservable, companion.getUserSettings().observeConsents(), Observable.I(new ScalarSynchronousObservable(null), StoreUser.observeMe$default(companion.getUsers(), false, 1, null).y(AnonymousClass1.INSTANCE).A(AnonymousClass2.INSTANCE)), AnonymousClass3.INSTANCE);
    }

    @Override // j0.k.Func1
    public /* bridge */ /* synthetic */ Observable<? extends WidgetSettingsPrivacy.Model> call(WidgetSettingsPrivacy.LocalState localState) {
        return call2(localState);
    }
}
