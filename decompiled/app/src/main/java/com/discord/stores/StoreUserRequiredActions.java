package com.discord.stores;

import com.discord.api.requiredaction.UserRequiredActionUpdate;
import com.discord.models.domain.ModelPayload;
import com.discord.models.requiredaction.RequiredAction;
import com.discord.stores.updates.ObservationDeck;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import rx.Observable;

/* compiled from: StoreUserRequiredActions.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0013\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0019\u0010\f\u001a\u00020\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0007¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000eH\u0007¢\u0006\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0013\u001a\u00020\u00128\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0015¨\u0006\u0018"}, d2 = {"Lcom/discord/stores/StoreUserRequiredActions;", "Lcom/discord/stores/StoreV2;", "Lcom/discord/models/requiredaction/RequiredAction;", "userRequiredAction", "", "updateUserRequiredAction", "(Lcom/discord/models/requiredaction/RequiredAction;)V", "Lrx/Observable;", "observeUserRequiredAction", "()Lrx/Observable;", "Lcom/discord/models/domain/ModelPayload;", "payload", "handleConnectionOpen", "(Lcom/discord/models/domain/ModelPayload;)V", "Lcom/discord/api/requiredaction/UserRequiredActionUpdate;", "userRequiredActionUpdate", "handleUserRequiredActionUpdate", "(Lcom/discord/api/requiredaction/UserRequiredActionUpdate;)V", "Lcom/discord/stores/updates/ObservationDeck;", "observationDeck", "Lcom/discord/stores/updates/ObservationDeck;", "Lcom/discord/models/requiredaction/RequiredAction;", "<init>", "(Lcom/discord/stores/updates/ObservationDeck;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class StoreUserRequiredActions extends StoreV2 {
    private final ObservationDeck observationDeck;
    private RequiredAction userRequiredAction;

    /* compiled from: StoreUserRequiredActions.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lcom/discord/models/requiredaction/RequiredAction;", "invoke", "()Lcom/discord/models/requiredaction/RequiredAction;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreUserRequiredActions$observeUserRequiredAction$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<RequiredAction> {
        public AnonymousClass1() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ RequiredAction invoke() {
            return invoke();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final RequiredAction invoke() {
            return StoreUserRequiredActions.access$getUserRequiredAction$p(StoreUserRequiredActions.this);
        }
    }

    public StoreUserRequiredActions(ObservationDeck observationDeck) {
        Intrinsics3.checkNotNullParameter(observationDeck, "observationDeck");
        this.observationDeck = observationDeck;
        this.userRequiredAction = RequiredAction.NONE;
    }

    public static final /* synthetic */ RequiredAction access$getUserRequiredAction$p(StoreUserRequiredActions storeUserRequiredActions) {
        return storeUserRequiredActions.userRequiredAction;
    }

    public static final /* synthetic */ void access$setUserRequiredAction$p(StoreUserRequiredActions storeUserRequiredActions, RequiredAction requiredAction) {
        storeUserRequiredActions.userRequiredAction = requiredAction;
    }

    @Store3
    private final void updateUserRequiredAction(RequiredAction userRequiredAction) {
        if (userRequiredAction == RequiredAction.REQUIRE_CAPTCHA) {
            userRequiredAction = RequiredAction.REQUIRE_VERIFIED_PHONE;
        }
        this.userRequiredAction = userRequiredAction;
    }

    @Store3
    public final void handleConnectionOpen(ModelPayload payload) {
        updateUserRequiredAction(RequiredAction.INSTANCE.fromApiString(payload != null ? payload.getRequiredAction() : null));
        markChanged();
    }

    @Store3
    public final void handleUserRequiredActionUpdate(UserRequiredActionUpdate userRequiredActionUpdate) {
        Intrinsics3.checkNotNullParameter(userRequiredActionUpdate, "userRequiredActionUpdate");
        updateUserRequiredAction(RequiredAction.INSTANCE.fromApiString(userRequiredActionUpdate.getRequiredAction()));
        markChanged();
    }

    public final Observable<RequiredAction> observeUserRequiredAction() {
        return ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, false, null, null, new AnonymousClass1(), 14, null);
    }
}
