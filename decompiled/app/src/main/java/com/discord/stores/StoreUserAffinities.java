package com.discord.stores;

import android.content.Context;
import androidx.core.app.NotificationCompat;
import com.discord.models.domain.ModelUserAffinities;
import com.discord.models.domain.ModelUserAffinity;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeck4;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.t.Collections2;
import d0.t.Iterables2;
import d0.t._Collections;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import j0.k.Func1;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* compiled from: StoreUserAffinities.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0013\u001a\u00020\u0012\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0015¢\u0006\u0004\b\u001a\u0010\u001bJ\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0003H\u0003¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0007H\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u001d\u0010\u000f\u001a\u0012\u0012\u000e\u0012\f\u0012\b\u0012\u00060\rj\u0002`\u000e0\f0\u0002¢\u0006\u0004\b\u000f\u0010\u0005J\u000f\u0010\u0010\u001a\u00020\u0007H\u0007¢\u0006\u0004\b\u0010\u0010\u000bJ\u000f\u0010\u0011\u001a\u00020\u0007H\u0017¢\u0006\u0004\b\u0011\u0010\u000bR\u0016\u0010\u0013\u001a\u00020\u00128\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0016\u001a\u00020\u00158\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u0006\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u0018R\u0016\u0010\u0019\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010\u0018¨\u0006\u001c"}, d2 = {"Lcom/discord/stores/StoreUserAffinities;", "Lcom/discord/stores/StoreV2;", "Lrx/Observable;", "Lcom/discord/models/domain/ModelUserAffinities;", "observeUserAffinities", "()Lrx/Observable;", "affinities", "", "handleUserAffinitiesFetchSuccess", "(Lcom/discord/models/domain/ModelUserAffinities;)V", "fetchUserAffinities", "()V", "", "", "Lcom/discord/primitives/UserId;", "observeAffinityUserIds", "handleConnectionOpen", "snapshotData", "Lcom/discord/stores/Dispatcher;", "dispatcher", "Lcom/discord/stores/Dispatcher;", "Lcom/discord/stores/updates/ObservationDeck;", "observationDeck", "Lcom/discord/stores/updates/ObservationDeck;", "Lcom/discord/models/domain/ModelUserAffinities;", "affinitiesSnapshot", "<init>", "(Lcom/discord/stores/Dispatcher;Lcom/discord/stores/updates/ObservationDeck;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class StoreUserAffinities extends StoreV2 {
    private ModelUserAffinities affinities;
    private ModelUserAffinities affinitiesSnapshot;
    private final Dispatcher dispatcher;
    private final ObservationDeck observationDeck;

    /* compiled from: StoreUserAffinities.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/models/domain/ModelUserAffinities;", "affinities", "", "invoke", "(Lcom/discord/models/domain/ModelUserAffinities;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreUserAffinities$fetchUserAffinities$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<ModelUserAffinities, Unit> {

        /* compiled from: StoreUserAffinities.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
        /* renamed from: com.discord.stores.StoreUserAffinities$fetchUserAffinities$1$1, reason: invalid class name and collision with other inner class name */
        public static final class C01831 extends Lambda implements Function0<Unit> {
            public final /* synthetic */ ModelUserAffinities $affinities;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C01831(ModelUserAffinities modelUserAffinities) {
                super(0);
                this.$affinities = modelUserAffinities;
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                StoreUserAffinities.access$handleUserAffinitiesFetchSuccess(StoreUserAffinities.this, this.$affinities);
            }
        }

        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ModelUserAffinities modelUserAffinities) {
            invoke2(modelUserAffinities);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ModelUserAffinities modelUserAffinities) {
            Intrinsics3.checkNotNullParameter(modelUserAffinities, "affinities");
            StoreUserAffinities.access$getDispatcher$p(StoreUserAffinities.this).schedule(new C01831(modelUserAffinities));
        }
    }

    /* compiled from: StoreUserAffinities.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\t\n\u0002\b\u0003\u0010\u0007\u001a\u0016\u0012\u0004\u0012\u00020\u0004 \u0001*\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lcom/discord/models/domain/ModelUserAffinities;", "kotlin.jvm.PlatformType", "affinities", "", "", NotificationCompat.CATEGORY_CALL, "(Lcom/discord/models/domain/ModelUserAffinities;)Ljava/util/List;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreUserAffinities$observeAffinityUserIds$1, reason: invalid class name */
    public static final class AnonymousClass1<T, R> implements Func1<ModelUserAffinities, List<? extends Long>> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        @Override // j0.k.Func1
        public /* bridge */ /* synthetic */ List<? extends Long> call(ModelUserAffinities modelUserAffinities) {
            return call2(modelUserAffinities);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final List<Long> call2(ModelUserAffinities modelUserAffinities) {
            List<ModelUserAffinity> userAffinities = modelUserAffinities.getUserAffinities();
            ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(userAffinities, 10));
            Iterator<T> it = userAffinities.iterator();
            while (it.hasNext()) {
                arrayList.add(Long.valueOf(((ModelUserAffinity) it.next()).getUserId()));
            }
            return arrayList;
        }
    }

    /* compiled from: StoreUserAffinities.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lcom/discord/models/domain/ModelUserAffinities;", "invoke", "()Lcom/discord/models/domain/ModelUserAffinities;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreUserAffinities$observeUserAffinities$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<ModelUserAffinities> {
        public AnonymousClass1() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ ModelUserAffinities invoke() {
            return invoke();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final ModelUserAffinities invoke() {
            return StoreUserAffinities.access$getAffinitiesSnapshot$p(StoreUserAffinities.this);
        }
    }

    public /* synthetic */ StoreUserAffinities(Dispatcher dispatcher, ObservationDeck observationDeck, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(dispatcher, (i & 2) != 0 ? ObservationDeck4.get() : observationDeck);
    }

    public static final /* synthetic */ ModelUserAffinities access$getAffinitiesSnapshot$p(StoreUserAffinities storeUserAffinities) {
        return storeUserAffinities.affinitiesSnapshot;
    }

    public static final /* synthetic */ Dispatcher access$getDispatcher$p(StoreUserAffinities storeUserAffinities) {
        return storeUserAffinities.dispatcher;
    }

    public static final /* synthetic */ void access$handleUserAffinitiesFetchSuccess(StoreUserAffinities storeUserAffinities, ModelUserAffinities modelUserAffinities) {
        storeUserAffinities.handleUserAffinitiesFetchSuccess(modelUserAffinities);
    }

    public static final /* synthetic */ void access$setAffinitiesSnapshot$p(StoreUserAffinities storeUserAffinities, ModelUserAffinities modelUserAffinities) {
        storeUserAffinities.affinitiesSnapshot = modelUserAffinities;
    }

    @Store3
    private final void fetchUserAffinities() {
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.INSTANCE.getApi().getUserAffinities(), false, 1, null), StoreUserAffinities.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(), 62, (Object) null);
    }

    @Store3
    private final void handleUserAffinitiesFetchSuccess(ModelUserAffinities affinities) {
        this.affinities = affinities;
        markChanged();
    }

    private final Observable<ModelUserAffinities> observeUserAffinities() {
        return ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, false, null, null, new AnonymousClass1(), 14, null);
    }

    @Store3
    public final void handleConnectionOpen() {
        fetchUserAffinities();
    }

    public final Observable<List<Long>> observeAffinityUserIds() {
        Observable<List<Long>> observableR = observeUserAffinities().G(AnonymousClass1.INSTANCE).r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "observeUserAffinities()\n…  .distinctUntilChanged()");
        return observableR;
    }

    @Override // com.discord.stores.StoreV2
    @Store3
    public void snapshotData() {
        super.snapshotData();
        this.affinitiesSnapshot = new ModelUserAffinities(_Collections.toList(this.affinities.getUserAffinities()), _Collections.toList(this.affinities.getInverseUserAffinities()));
    }

    public StoreUserAffinities(Dispatcher dispatcher, ObservationDeck observationDeck) {
        Intrinsics3.checkNotNullParameter(dispatcher, "dispatcher");
        Intrinsics3.checkNotNullParameter(observationDeck, "observationDeck");
        this.dispatcher = dispatcher;
        this.observationDeck = observationDeck;
        this.affinities = new ModelUserAffinities(Collections2.emptyList(), Collections2.emptyList());
        this.affinitiesSnapshot = new ModelUserAffinities(Collections2.emptyList(), Collections2.emptyList());
    }
}
