package com.discord.stores;

import com.discord.stores.updates.ObservationDeck;
import com.discord.utilities.persister.Persister;
import com.discord.widgets.chat.input.expression.ExpressionTrayTab;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import rx.Observable;

/* compiled from: StoreExpressionPickerNavigation.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0012\u001a\u00020\u0011\u0012\u0006\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b\u0017\u0010\u0018J\u0013\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0007H\u0017¢\u0006\u0004\b\n\u0010\u000bR\u0016\u0010\f\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\f\u0010\rR\u001c\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00030\u000e8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0012\u001a\u00020\u00118\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0015\u001a\u00020\u00148\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016¨\u0006\u0019"}, d2 = {"Lcom/discord/stores/StoreExpressionPickerNavigation;", "Lcom/discord/stores/StoreV2;", "Lrx/Observable;", "Lcom/discord/widgets/chat/input/expression/ExpressionTrayTab;", "observeSelectedTab", "()Lrx/Observable;", "expressionTrayTab", "", "onSelectTab", "(Lcom/discord/widgets/chat/input/expression/ExpressionTrayTab;)V", "snapshotData", "()V", "selectedTab", "Lcom/discord/widgets/chat/input/expression/ExpressionTrayTab;", "Lcom/discord/utilities/persister/Persister;", "selectedTabPersister", "Lcom/discord/utilities/persister/Persister;", "Lcom/discord/stores/updates/ObservationDeck;", "observationDeck", "Lcom/discord/stores/updates/ObservationDeck;", "Lcom/discord/stores/Dispatcher;", "dispatcher", "Lcom/discord/stores/Dispatcher;", "<init>", "(Lcom/discord/stores/updates/ObservationDeck;Lcom/discord/stores/Dispatcher;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class StoreExpressionPickerNavigation extends StoreV2 {
    private final Dispatcher dispatcher;
    private final ObservationDeck observationDeck;
    private ExpressionTrayTab selectedTab;
    private final Persister<ExpressionTrayTab> selectedTabPersister;

    /* compiled from: StoreExpressionPickerNavigation.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lcom/discord/widgets/chat/input/expression/ExpressionTrayTab;", "invoke", "()Lcom/discord/widgets/chat/input/expression/ExpressionTrayTab;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreExpressionPickerNavigation$observeSelectedTab$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<ExpressionTrayTab> {
        public AnonymousClass1() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ ExpressionTrayTab invoke() {
            return invoke();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final ExpressionTrayTab invoke() {
            return StoreExpressionPickerNavigation.access$getSelectedTab$p(StoreExpressionPickerNavigation.this);
        }
    }

    /* compiled from: StoreExpressionPickerNavigation.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreExpressionPickerNavigation$onSelectTab$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ ExpressionTrayTab $expressionTrayTab;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(ExpressionTrayTab expressionTrayTab) {
            super(0);
            this.$expressionTrayTab = expressionTrayTab;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            StoreExpressionPickerNavigation.access$setSelectedTab$p(StoreExpressionPickerNavigation.this, this.$expressionTrayTab);
            StoreExpressionPickerNavigation.this.markChanged();
        }
    }

    public StoreExpressionPickerNavigation(ObservationDeck observationDeck, Dispatcher dispatcher) {
        Intrinsics3.checkNotNullParameter(observationDeck, "observationDeck");
        Intrinsics3.checkNotNullParameter(dispatcher, "dispatcher");
        this.observationDeck = observationDeck;
        this.dispatcher = dispatcher;
        this.selectedTab = ExpressionTrayTab.EMOJI;
        Persister<ExpressionTrayTab> persister = new Persister<>("CACHE_KEY_SELECTED_EXPRESSION_TRAY_TAB", this.selectedTab);
        this.selectedTabPersister = persister;
        this.selectedTab = persister.get();
    }

    public static final /* synthetic */ ExpressionTrayTab access$getSelectedTab$p(StoreExpressionPickerNavigation storeExpressionPickerNavigation) {
        return storeExpressionPickerNavigation.selectedTab;
    }

    public static final /* synthetic */ void access$setSelectedTab$p(StoreExpressionPickerNavigation storeExpressionPickerNavigation, ExpressionTrayTab expressionTrayTab) {
        storeExpressionPickerNavigation.selectedTab = expressionTrayTab;
    }

    public final Observable<ExpressionTrayTab> observeSelectedTab() {
        Observable<ExpressionTrayTab> observableR = ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, false, null, null, new AnonymousClass1(), 14, null).r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "observationDeck.connectR… }.distinctUntilChanged()");
        return observableR;
    }

    public final void onSelectTab(ExpressionTrayTab expressionTrayTab) {
        Intrinsics3.checkNotNullParameter(expressionTrayTab, "expressionTrayTab");
        this.dispatcher.schedule(new AnonymousClass1(expressionTrayTab));
    }

    @Override // com.discord.stores.StoreV2
    @Store3
    public void snapshotData() {
        this.selectedTabPersister.set(this.selectedTab, true);
    }
}
