package com.discord.stores;

import android.content.Context;
import androidx.core.app.NotificationCompat;
import com.discord.api.activity.Activity;
import com.discord.api.activity.ActivityParty;
import com.discord.api.activity.ActivityType;
import com.discord.api.voice.state.VoiceState;
import com.discord.stores.updates.ObservationDeck;
import com.discord.utilities.presence.ActivityUtils;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.widgets.stage.StageRoles;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import j0.k.Func1;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import rx.Observable;
import rx.functions.Func2;
import rx.subjects.BehaviorSubject;

/* compiled from: StoreStageChannelSelfPresence.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B?\u0012\u0006\u0010\u0014\u001a\u00020\u0013\u0012\u0006\u0010-\u001a\u00020,\u0012\u0006\u00109\u001a\u000208\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\u0006\u0010#\u001a\u00020\"\u0012\u0006\u0010\u0019\u001a\u00020\u0018\u0012\u0006\u0010(\u001a\u00020'¢\u0006\u0004\b=\u0010>J\u000f\u0010\u0003\u001a\u00020\u0002H\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\r\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0004J\u0017\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\n\u0010\u0004J\u000f\u0010\u000b\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u000b\u0010\u0004J\u000f\u0010\f\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\f\u0010\u0004J\u000f\u0010\r\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\r\u0010\u0004R\u0019\u0010\u000f\u001a\u00020\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0019\u0010\u0014\u001a\u00020\u00138\u0006@\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0019\u0010\u0019\u001a\u00020\u00188\u0006@\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u001f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00020\u001d8\u0006@\u0006¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!R\u0019\u0010#\u001a\u00020\"8\u0006@\u0006¢\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&R\u0019\u0010(\u001a\u00020'8\u0006@\u0006¢\u0006\f\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+R\u0019\u0010-\u001a\u00020,8\u0006@\u0006¢\u0006\f\n\u0004\b-\u0010.\u001a\u0004\b/\u00100R$\u00102\u001a\u0004\u0018\u0001018\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b2\u00103\u001a\u0004\b4\u00105\"\u0004\b6\u00107R\u0019\u00109\u001a\u0002088\u0006@\u0006¢\u0006\f\n\u0004\b9\u0010:\u001a\u0004\b;\u0010<¨\u0006?"}, d2 = {"Lcom/discord/stores/StoreStageChannelSelfPresence;", "Lcom/discord/stores/StoreV2;", "", "updateActivity", "()V", "init", "Lcom/discord/api/voice/state/VoiceState;", "voiceState", "handleVoiceStateUpdate", "(Lcom/discord/api/voice/state/VoiceState;)V", "handleStageInstanceCreate", "handleStageInstanceUpdate", "handleStageInstanceDelete", "handleVoiceChannelSelected", "Lcom/discord/stores/StoreStageChannels;", "stageChannels", "Lcom/discord/stores/StoreStageChannels;", "getStageChannels", "()Lcom/discord/stores/StoreStageChannels;", "Lcom/discord/stores/updates/ObservationDeck;", "observationDeck", "Lcom/discord/stores/updates/ObservationDeck;", "getObservationDeck", "()Lcom/discord/stores/updates/ObservationDeck;", "Lcom/discord/stores/StoreUserSettings;", "userSettings", "Lcom/discord/stores/StoreUserSettings;", "getUserSettings", "()Lcom/discord/stores/StoreUserSettings;", "Lrx/subjects/BehaviorSubject;", "publishStateTrigger", "Lrx/subjects/BehaviorSubject;", "getPublishStateTrigger", "()Lrx/subjects/BehaviorSubject;", "Lcom/discord/stores/StoreVoiceChannelSelected;", "voiceChannelSelected", "Lcom/discord/stores/StoreVoiceChannelSelected;", "getVoiceChannelSelected", "()Lcom/discord/stores/StoreVoiceChannelSelected;", "Lcom/discord/stores/Dispatcher;", "dispatcher", "Lcom/discord/stores/Dispatcher;", "getDispatcher", "()Lcom/discord/stores/Dispatcher;", "Lcom/discord/stores/StoreUser;", "userStore", "Lcom/discord/stores/StoreUser;", "getUserStore", "()Lcom/discord/stores/StoreUser;", "Lcom/discord/api/activity/Activity;", "stageChannelActivity", "Lcom/discord/api/activity/Activity;", "getStageChannelActivity", "()Lcom/discord/api/activity/Activity;", "setStageChannelActivity", "(Lcom/discord/api/activity/Activity;)V", "Lcom/discord/stores/StoreUserPresence;", "userPresence", "Lcom/discord/stores/StoreUserPresence;", "getUserPresence", "()Lcom/discord/stores/StoreUserPresence;", "<init>", "(Lcom/discord/stores/updates/ObservationDeck;Lcom/discord/stores/StoreUser;Lcom/discord/stores/StoreUserPresence;Lcom/discord/stores/StoreStageChannels;Lcom/discord/stores/StoreVoiceChannelSelected;Lcom/discord/stores/StoreUserSettings;Lcom/discord/stores/Dispatcher;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class StoreStageChannelSelfPresence extends StoreV2 {
    private final Dispatcher dispatcher;
    private final ObservationDeck observationDeck;
    private final BehaviorSubject<Unit> publishStateTrigger;
    private Activity stageChannelActivity;
    private final StoreStageChannels stageChannels;
    private final StoreUserPresence userPresence;
    private final StoreUserSettings userSettings;
    private final StoreUser userStore;
    private final StoreVoiceChannelSelected voiceChannelSelected;

    /* compiled from: StoreStageChannelSelfPresence.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\b\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()I", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreStageChannelSelfPresence$init$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<Integer> {
        public AnonymousClass1() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Integer invoke() {
            return Integer.valueOf(invoke2());
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final int invoke2() {
            Map<Long, StageRoles> channelRolesInternal = StoreStageChannelSelfPresence.this.getStageChannels().getChannelRolesInternal(StoreStageChannelSelfPresence.this.getVoiceChannelSelected().getSelectedVoiceChannelId());
            return ((channelRolesInternal != null ? channelRolesInternal.size() : 0) / 100) + 1;
        }
    }

    /* compiled from: StoreStageChannelSelfPresence.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\u0007\u001a*\u0012\u000e\b\u0001\u0012\n \u0001*\u0004\u0018\u00010\u00040\u0004 \u0001*\u0014\u0012\u000e\b\u0001\u0012\n \u0001*\u0004\u0018\u00010\u00040\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"", "kotlin.jvm.PlatformType", "windowDuration", "Lrx/Observable;", "", NotificationCompat.CATEGORY_CALL, "(Ljava/lang/Integer;)Lrx/Observable;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreStageChannelSelfPresence$init$2, reason: invalid class name */
    public static final class AnonymousClass2<T, R> implements Func1<Integer, Observable<? extends Boolean>> {

        /* compiled from: StoreStageChannelSelfPresence.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\u0010\u0007\u001a\n \u0001*\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u00002\u000e\u0010\u0004\u001a\n \u0001*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"", "kotlin.jvm.PlatformType", "<anonymous parameter 0>", "", "isEnabled", NotificationCompat.CATEGORY_CALL, "(Lkotlin/Unit;Ljava/lang/Boolean;)Ljava/lang/Boolean;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
        /* renamed from: com.discord.stores.StoreStageChannelSelfPresence$init$2$1, reason: invalid class name */
        public static final class AnonymousClass1<T1, T2, R> implements Func2<Unit, Boolean, Boolean> {
            public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

            /* renamed from: call, reason: avoid collision after fix types in other method */
            public final Boolean call2(Unit unit, Boolean bool) {
                return bool;
            }

            @Override // rx.functions.Func2
            public /* bridge */ /* synthetic */ Boolean call(Unit unit, Boolean bool) {
                return call2(unit, bool);
            }
        }

        public AnonymousClass2() {
        }

        @Override // j0.k.Func1
        public /* bridge */ /* synthetic */ Observable<? extends Boolean> call(Integer num) {
            return call2(num);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final Observable<? extends Boolean> call2(Integer num) {
            return Observable.j(ObservableExtensionsKt.leadingEdgeThrottle(StoreStageChannelSelfPresence.this.getPublishStateTrigger(), num.intValue(), TimeUnit.SECONDS), StoreStageChannelSelfPresence.this.getUserSettings().observeIsShowCurrentGameEnabled(), AnonymousClass1.INSTANCE);
        }
    }

    /* compiled from: StoreStageChannelSelfPresence.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "kotlin.jvm.PlatformType", "showCurrentActivity", "", "invoke", "(Ljava/lang/Boolean;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreStageChannelSelfPresence$init$3, reason: invalid class name */
    public static final class AnonymousClass3 extends Lambda implements Function1<Boolean, Unit> {

        /* compiled from: StoreStageChannelSelfPresence.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
        /* renamed from: com.discord.stores.StoreStageChannelSelfPresence$init$3$1, reason: invalid class name */
        public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
            public final /* synthetic */ Boolean $showCurrentActivity;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(Boolean bool) {
                super(0);
                this.$showCurrentActivity = bool;
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                StoreUserPresence userPresence = StoreStageChannelSelfPresence.this.getUserPresence();
                ActivityType activityType = ActivityType.LISTENING;
                Activity stageChannelActivity = StoreStageChannelSelfPresence.this.getStageChannelActivity();
                Boolean bool = this.$showCurrentActivity;
                Intrinsics3.checkNotNullExpressionValue(bool, "showCurrentActivity");
                if (!bool.booleanValue()) {
                    stageChannelActivity = null;
                }
                userPresence.updateActivity(activityType, stageChannelActivity, true);
            }
        }

        public AnonymousClass3() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
            invoke2(bool);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Boolean bool) {
            StoreStageChannelSelfPresence.this.getDispatcher().schedule(new AnonymousClass1(bool));
        }
    }

    public StoreStageChannelSelfPresence(ObservationDeck observationDeck, StoreUser storeUser, StoreUserPresence storeUserPresence, StoreStageChannels storeStageChannels, StoreVoiceChannelSelected storeVoiceChannelSelected, StoreUserSettings storeUserSettings, Dispatcher dispatcher) {
        Intrinsics3.checkNotNullParameter(observationDeck, "observationDeck");
        Intrinsics3.checkNotNullParameter(storeUser, "userStore");
        Intrinsics3.checkNotNullParameter(storeUserPresence, "userPresence");
        Intrinsics3.checkNotNullParameter(storeStageChannels, "stageChannels");
        Intrinsics3.checkNotNullParameter(storeVoiceChannelSelected, "voiceChannelSelected");
        Intrinsics3.checkNotNullParameter(storeUserSettings, "userSettings");
        Intrinsics3.checkNotNullParameter(dispatcher, "dispatcher");
        this.observationDeck = observationDeck;
        this.userStore = storeUser;
        this.userPresence = storeUserPresence;
        this.stageChannels = storeStageChannels;
        this.voiceChannelSelected = storeVoiceChannelSelected;
        this.userSettings = storeUserSettings;
        this.dispatcher = dispatcher;
        BehaviorSubject<Unit> behaviorSubjectK0 = BehaviorSubject.k0();
        Intrinsics3.checkNotNullExpressionValue(behaviorSubjectK0, "BehaviorSubject.create()");
        this.publishStateTrigger = behaviorSubjectK0;
    }

    @Store3
    private final void updateActivity() throws NumberFormatException {
        ActivityParty party;
        ActivityParty party2;
        Activity activityCreateStageChannelListeningActivity = ActivityUtils.createStageChannelListeningActivity();
        String id2 = (activityCreateStageChannelListeningActivity == null || (party2 = activityCreateStageChannelListeningActivity.getParty()) == null) ? null : party2.getId();
        Activity activity = this.stageChannelActivity;
        if (!(!Intrinsics3.areEqual(id2, (activity == null || (party = activity.getParty()) == null) ? null : party.getId()))) {
            String name = activityCreateStageChannelListeningActivity != null ? activityCreateStageChannelListeningActivity.getName() : null;
            if (!(!Intrinsics3.areEqual(name, this.stageChannelActivity != null ? r3.getName() : null))) {
                return;
            }
        }
        this.stageChannelActivity = activityCreateStageChannelListeningActivity;
        this.publishStateTrigger.onNext(Unit.a);
    }

    public final Dispatcher getDispatcher() {
        return this.dispatcher;
    }

    public final ObservationDeck getObservationDeck() {
        return this.observationDeck;
    }

    public final BehaviorSubject<Unit> getPublishStateTrigger() {
        return this.publishStateTrigger;
    }

    public final Activity getStageChannelActivity() {
        return this.stageChannelActivity;
    }

    public final StoreStageChannels getStageChannels() {
        return this.stageChannels;
    }

    public final StoreUserPresence getUserPresence() {
        return this.userPresence;
    }

    public final StoreUserSettings getUserSettings() {
        return this.userSettings;
    }

    public final StoreUser getUserStore() {
        return this.userStore;
    }

    public final StoreVoiceChannelSelected getVoiceChannelSelected() {
        return this.voiceChannelSelected;
    }

    @Store3
    public final void handleStageInstanceCreate() {
        updateActivity();
    }

    @Store3
    public final void handleStageInstanceDelete() {
        updateActivity();
    }

    @Store3
    public final void handleStageInstanceUpdate() {
        updateActivity();
    }

    @Store3
    public final void handleVoiceChannelSelected() {
        updateActivity();
    }

    @Store3
    public final void handleVoiceStateUpdate(VoiceState voiceState) {
        Intrinsics3.checkNotNullParameter(voiceState, "voiceState");
        if (voiceState.getUserId() == this.userStore.getMeSnapshot().getId()) {
            updateActivity();
        }
    }

    public final void init() {
        Observable observableY = ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this.stageChannels, this.voiceChannelSelected}, false, null, null, new AnonymousClass1(), 14, null).r().Y(new AnonymousClass2());
        Intrinsics3.checkNotNullExpressionValue(observableY, "observationDeck.connectR…bled -> isEnabled }\n    }");
        ObservableExtensionsKt.appSubscribe$default(observableY, StoreStageChannelSelfPresence.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass3(), 62, (Object) null);
    }

    public final void setStageChannelActivity(Activity activity) {
        this.stageChannelActivity = activity;
    }
}
