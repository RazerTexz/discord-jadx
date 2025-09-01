package com.discord.stores;

import com.discord.stores.StoreNavigation;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeck4;
import com.discord.widgets.tabs.NavigationTab;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;
import rx.subjects.PublishSubject;

/* compiled from: StoreTabsNavigation.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u001c\u001a\u00020\u001b\u0012\u0006\u0010\u001f\u001a\u00020\u001e\u0012\b\b\u0002\u0010(\u001a\u00020'¢\u0006\u0004\b*\u0010+J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0003¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u000b\u0010\fJ\r\u0010\r\u001a\u00020\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u0013\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00020\u000f¢\u0006\u0004\b\u0010\u0010\u0011J\u0013\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00040\u000f¢\u0006\u0004\b\u0012\u0010\u0011J\u001f\u0010\u0014\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\u000b\u001a\u00020\u0013¢\u0006\u0004\b\u0014\u0010\u0015J\u001f\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u000b\u001a\u00020\u0013¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0018\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0018\u0010\fJ!\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u000b\u001a\u00020\u0013H\u0001¢\u0006\u0004\b\u0019\u0010\u0017R\u0016\u0010\u001c\u001a\u00020\u001b8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0016\u0010\u001f\u001a\u00020\u001e8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010!\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b!\u0010\"R:\u0010%\u001a&\u0012\f\u0012\n $*\u0004\u0018\u00010\u00040\u0004 $*\u0012\u0012\f\u0012\n $*\u0004\u0018\u00010\u00040\u0004\u0018\u00010#0#8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010(\u001a\u00020'8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b(\u0010)¨\u0006,"}, d2 = {"Lcom/discord/stores/StoreTabsNavigation;", "Lcom/discord/stores/StoreV2;", "Lcom/discord/widgets/tabs/NavigationTab;", "navigationTab", "", "handleTabSelection", "(Lcom/discord/widgets/tabs/NavigationTab;)V", "Lcom/discord/stores/StoreNavigation$PanelAction;", "panelAction", "notifyHomeTabSelected", "(Lcom/discord/stores/StoreNavigation$PanelAction;)V", "dismissTabsDialogs", "()V", "getSelectedTab", "()Lcom/discord/widgets/tabs/NavigationTab;", "Lrx/Observable;", "observeSelectedTab", "()Lrx/Observable;", "observeDismissTabsDialogEvent", "", "selectHomeTab", "(Lcom/discord/stores/StoreNavigation$PanelAction;Z)V", "selectTab", "(Lcom/discord/widgets/tabs/NavigationTab;Z)V", "handlePreLogout", "selectTabInternal$app_productionGoogleRelease", "selectTabInternal", "Lcom/discord/stores/Dispatcher;", "dispatcher", "Lcom/discord/stores/Dispatcher;", "Lcom/discord/stores/StoreStream;", "storeStream", "Lcom/discord/stores/StoreStream;", "selectedTab", "Lcom/discord/widgets/tabs/NavigationTab;", "Lrx/subjects/PublishSubject;", "kotlin.jvm.PlatformType", "dismissTabsDialogEventSubject", "Lrx/subjects/PublishSubject;", "Lcom/discord/stores/updates/ObservationDeck;", "observationDeck", "Lcom/discord/stores/updates/ObservationDeck;", "<init>", "(Lcom/discord/stores/Dispatcher;Lcom/discord/stores/StoreStream;Lcom/discord/stores/updates/ObservationDeck;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class StoreTabsNavigation extends StoreV2 {
    private final PublishSubject<Unit> dismissTabsDialogEventSubject;
    private final Dispatcher dispatcher;
    private final ObservationDeck observationDeck;
    private NavigationTab selectedTab;
    private final StoreStream storeStream;

    /* compiled from: StoreTabsNavigation.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lcom/discord/widgets/tabs/NavigationTab;", "invoke", "()Lcom/discord/widgets/tabs/NavigationTab;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreTabsNavigation$observeSelectedTab$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<NavigationTab> {
        public AnonymousClass1() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ NavigationTab invoke() {
            return invoke();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final NavigationTab invoke() {
            return StoreTabsNavigation.this.getSelectedTab();
        }
    }

    /* compiled from: StoreTabsNavigation.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreTabsNavigation$selectHomeTab$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ boolean $dismissTabsDialogs;
        public final /* synthetic */ StoreNavigation.PanelAction $panelAction;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(StoreNavigation.PanelAction panelAction, boolean z2) {
            super(0);
            this.$panelAction = panelAction;
            this.$dismissTabsDialogs = z2;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            StoreTabsNavigation.access$handleTabSelection(StoreTabsNavigation.this, NavigationTab.HOME);
            StoreTabsNavigation.access$notifyHomeTabSelected(StoreTabsNavigation.this, this.$panelAction);
            if (this.$dismissTabsDialogs) {
                StoreTabsNavigation.access$dismissTabsDialogs(StoreTabsNavigation.this);
            }
        }
    }

    /* compiled from: StoreTabsNavigation.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreTabsNavigation$selectTab$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ boolean $dismissTabsDialogs;
        public final /* synthetic */ NavigationTab $navigationTab;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(NavigationTab navigationTab, boolean z2) {
            super(0);
            this.$navigationTab = navigationTab;
            this.$dismissTabsDialogs = z2;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            StoreTabsNavigation.this.selectTabInternal$app_productionGoogleRelease(this.$navigationTab, this.$dismissTabsDialogs);
        }
    }

    public /* synthetic */ StoreTabsNavigation(Dispatcher dispatcher, StoreStream storeStream, ObservationDeck observationDeck, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(dispatcher, storeStream, (i & 4) != 0 ? ObservationDeck4.get() : observationDeck);
    }

    public static final /* synthetic */ void access$dismissTabsDialogs(StoreTabsNavigation storeTabsNavigation) {
        storeTabsNavigation.dismissTabsDialogs();
    }

    public static final /* synthetic */ void access$handleTabSelection(StoreTabsNavigation storeTabsNavigation, NavigationTab navigationTab) {
        storeTabsNavigation.handleTabSelection(navigationTab);
    }

    public static final /* synthetic */ void access$notifyHomeTabSelected(StoreTabsNavigation storeTabsNavigation, StoreNavigation.PanelAction panelAction) {
        storeTabsNavigation.notifyHomeTabSelected(panelAction);
    }

    private final void dismissTabsDialogs() {
        PublishSubject<Unit> publishSubject = this.dismissTabsDialogEventSubject;
        publishSubject.k.onNext(Unit.a);
    }

    @Store3
    private final void handleTabSelection(NavigationTab navigationTab) {
        this.selectedTab = navigationTab;
        markChanged();
    }

    @Store3
    private final void notifyHomeTabSelected(StoreNavigation.PanelAction panelAction) {
        this.storeStream.handleHomeTabSelected(panelAction);
    }

    public static /* synthetic */ void selectHomeTab$default(StoreTabsNavigation storeTabsNavigation, StoreNavigation.PanelAction panelAction, boolean z2, int i, Object obj) {
        if ((i & 2) != 0) {
            z2 = false;
        }
        storeTabsNavigation.selectHomeTab(panelAction, z2);
    }

    public static /* synthetic */ void selectTab$default(StoreTabsNavigation storeTabsNavigation, NavigationTab navigationTab, boolean z2, int i, Object obj) {
        if ((i & 2) != 0) {
            z2 = false;
        }
        storeTabsNavigation.selectTab(navigationTab, z2);
    }

    public static /* synthetic */ void selectTabInternal$app_productionGoogleRelease$default(StoreTabsNavigation storeTabsNavigation, NavigationTab navigationTab, boolean z2, int i, Object obj) {
        if ((i & 2) != 0) {
            z2 = false;
        }
        storeTabsNavigation.selectTabInternal$app_productionGoogleRelease(navigationTab, z2);
    }

    public final NavigationTab getSelectedTab() {
        return this.selectedTab;
    }

    @Store3
    public final void handlePreLogout() {
        selectTabInternal$app_productionGoogleRelease$default(this, NavigationTab.HOME, false, 2, null);
    }

    public final Observable<Unit> observeDismissTabsDialogEvent() {
        PublishSubject<Unit> publishSubject = this.dismissTabsDialogEventSubject;
        Intrinsics3.checkNotNullExpressionValue(publishSubject, "dismissTabsDialogEventSubject");
        return publishSubject;
    }

    public final Observable<NavigationTab> observeSelectedTab() {
        Observable<NavigationTab> observableR = ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, false, null, null, new AnonymousClass1(), 14, null).r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "observationDeck.connectR…  .distinctUntilChanged()");
        return observableR;
    }

    public final void selectHomeTab(StoreNavigation.PanelAction panelAction, boolean dismissTabsDialogs) {
        Intrinsics3.checkNotNullParameter(panelAction, "panelAction");
        this.dispatcher.schedule(new AnonymousClass1(panelAction, dismissTabsDialogs));
    }

    public final void selectTab(NavigationTab navigationTab, boolean dismissTabsDialogs) {
        Intrinsics3.checkNotNullParameter(navigationTab, "navigationTab");
        this.dispatcher.schedule(new AnonymousClass1(navigationTab, dismissTabsDialogs));
    }

    @Store3
    public final void selectTabInternal$app_productionGoogleRelease(NavigationTab navigationTab, boolean dismissTabsDialogs) {
        Intrinsics3.checkNotNullParameter(navigationTab, "navigationTab");
        handleTabSelection(navigationTab);
        if (dismissTabsDialogs) {
            dismissTabsDialogs();
        }
    }

    public StoreTabsNavigation(Dispatcher dispatcher, StoreStream storeStream, ObservationDeck observationDeck) {
        Intrinsics3.checkNotNullParameter(dispatcher, "dispatcher");
        Intrinsics3.checkNotNullParameter(storeStream, "storeStream");
        Intrinsics3.checkNotNullParameter(observationDeck, "observationDeck");
        this.dispatcher = dispatcher;
        this.storeStream = storeStream;
        this.observationDeck = observationDeck;
        this.selectedTab = NavigationTab.HOME;
        this.dismissTabsDialogEventSubject = PublishSubject.k0();
    }
}
