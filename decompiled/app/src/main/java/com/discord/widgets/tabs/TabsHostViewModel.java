package com.discord.widgets.tabs;

import a0.a.a.b;
import android.content.Context;
import androidx.annotation.MainThread;
import b.a.d.AppViewModel;
import b.d.b.a.outline;
import com.discord.models.guild.Guild;
import com.discord.panels.PanelState;
import com.discord.stores.StoreGuilds;
import com.discord.stores.StoreMentions;
import com.discord.stores.StoreNavigation;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreTabsNavigation;
import com.discord.stores.StoreUser;
import com.discord.stores.StoreUserRelationships;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.t.Sets5;
import d0.t._Arrays;
import d0.t._Collections;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;
import rx.subjects.PublishSubject;

/* compiled from: TabsHostViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 *2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0004*+,-B5\u0012\b\b\u0002\u0010&\u001a\u00020%\u0012\b\b\u0002\u0010\u001f\u001a\u00020\u001e\u0012\b\b\u0002\u0010\"\u001a\u00020!\u0012\u000e\b\u0002\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00030\u000f¢\u0006\u0004\b(\u0010)J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\n\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\bH\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u000e\u0010\rJ\u0013\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u0013H\u0007¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0018\u001a\u00020\u0017H\u0007¢\u0006\u0004\b\u0018\u0010\u0019R:\u0010\u001c\u001a&\u0012\f\u0012\n \u001b*\u0004\u0018\u00010\u00100\u0010 \u001b*\u0012\u0012\f\u0012\n \u001b*\u0004\u0018\u00010\u00100\u0010\u0018\u00010\u001a0\u001a8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0016\u0010\u001f\u001a\u00020\u001e8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010\"\u001a\u00020!8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\"\u0010#R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0004\u0010$¨\u0006."}, d2 = {"Lcom/discord/widgets/tabs/TabsHostViewModel;", "Lb/a/d/d0;", "Lcom/discord/widgets/tabs/TabsHostViewModel$ViewState;", "Lcom/discord/widgets/tabs/TabsHostViewModel$StoreState;", "storeState", "", "handleStoreState", "(Lcom/discord/widgets/tabs/TabsHostViewModel$StoreState;)V", "", "height", "handleBottomNavHeight", "(I)V", "emitTrackFriendsListShown", "()V", "dismissSearchDialog", "Lrx/Observable;", "Lcom/discord/widgets/tabs/TabsHostViewModel$Event;", "observeEvents", "()Lrx/Observable;", "Lcom/discord/widgets/tabs/NavigationTab;", "tab", "selectTab", "(Lcom/discord/widgets/tabs/NavigationTab;)V", "", "handleBackPress", "()Z", "Lrx/subjects/PublishSubject;", "kotlin.jvm.PlatformType", "eventSubject", "Lrx/subjects/PublishSubject;", "Lcom/discord/stores/StoreTabsNavigation;", "storeTabsNavigation", "Lcom/discord/stores/StoreTabsNavigation;", "Lcom/discord/stores/StoreNavigation;", "storeNavigation", "Lcom/discord/stores/StoreNavigation;", "Lcom/discord/widgets/tabs/TabsHostViewModel$StoreState;", "Lcom/discord/widgets/tabs/BottomNavViewObserver;", "bottomNavViewObserver", "storeStateObservable", "<init>", "(Lcom/discord/widgets/tabs/BottomNavViewObserver;Lcom/discord/stores/StoreTabsNavigation;Lcom/discord/stores/StoreNavigation;Lrx/Observable;)V", "Companion", "Event", "StoreState", "ViewState", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final class TabsHostViewModel extends AppViewModel<ViewState> {
    private static final Set<NavigationTab> AT_LEAST_ONE_GUILD_TABS;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final List<NavigationTab> NON_HOME_TAB_DESTINATIONS;
    private static final Set<NavigationTab> NO_GUILD_TABS;
    private static final List<NavigationTab> TAB_DESTINATIONS;
    private final PublishSubject<Event> eventSubject;
    private final StoreNavigation storeNavigation;
    private StoreState storeState;
    private final StoreTabsNavigation storeTabsNavigation;

    /* compiled from: TabsHostViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/widgets/tabs/TabsHostViewModel$StoreState;", "storeState", "", "invoke", "(Lcom/discord/widgets/tabs/TabsHostViewModel$StoreState;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.tabs.TabsHostViewModel$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<StoreState, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(StoreState storeState) {
            invoke2(storeState);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(StoreState storeState) {
            Intrinsics3.checkNotNullParameter(storeState, "storeState");
            TabsHostViewModel.access$handleStoreState(TabsHostViewModel.this, storeState);
        }
    }

    /* compiled from: TabsHostViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "bottomNavHeight", "", "invoke", "(I)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.tabs.TabsHostViewModel$2, reason: invalid class name */
    public static final class AnonymousClass2 extends Lambda implements Function1<Integer, Unit> {
        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
            invoke(num.intValue());
            return Unit.a;
        }

        public final void invoke(int i) {
            TabsHostViewModel.access$handleBottomNavHeight(TabsHostViewModel.this, i);
        }
    }

    /* compiled from: TabsHostViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0004\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"", "it", "invoke", "(Lkotlin/Unit;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.tabs.TabsHostViewModel$3, reason: invalid class name */
    public static final class AnonymousClass3 extends Lambda implements Function1<Unit, Unit> {
        public AnonymousClass3() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Unit unit) {
            invoke2(unit);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Unit unit) {
            Intrinsics3.checkNotNullParameter(unit, "it");
            TabsHostViewModel.access$dismissSearchDialog(TabsHostViewModel.this);
        }
    }

    /* compiled from: TabsHostViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u000b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b!\u0010\"JE\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b\u0010\u0010\u0011R\u001f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u00128\u0006@\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u001f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00130\u00188\u0006@\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u001f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00130\u00128\u0006@\u0006¢\u0006\f\n\u0004\b\u001d\u0010\u0015\u001a\u0004\b\u001e\u0010\u0017R\u001f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00130\u00188\u0006@\u0006¢\u0006\f\n\u0004\b\u001f\u0010\u001a\u001a\u0004\b \u0010\u001c¨\u0006#"}, d2 = {"Lcom/discord/widgets/tabs/TabsHostViewModel$Companion;", "", "Lcom/discord/stores/StoreNavigation;", "storeNavigation", "Lcom/discord/stores/StoreTabsNavigation;", "storeTabsNavigation", "Lcom/discord/stores/StoreUser;", "storeUser", "Lcom/discord/stores/StoreGuilds;", "storeGuilds", "Lcom/discord/stores/StoreMentions;", "storeMentions", "Lcom/discord/stores/StoreUserRelationships;", "storeUserRelationships", "Lrx/Observable;", "Lcom/discord/widgets/tabs/TabsHostViewModel$StoreState;", "observeStoreState", "(Lcom/discord/stores/StoreNavigation;Lcom/discord/stores/StoreTabsNavigation;Lcom/discord/stores/StoreUser;Lcom/discord/stores/StoreGuilds;Lcom/discord/stores/StoreMentions;Lcom/discord/stores/StoreUserRelationships;)Lrx/Observable;", "", "Lcom/discord/widgets/tabs/NavigationTab;", "AT_LEAST_ONE_GUILD_TABS", "Ljava/util/Set;", "getAT_LEAST_ONE_GUILD_TABS", "()Ljava/util/Set;", "", "NON_HOME_TAB_DESTINATIONS", "Ljava/util/List;", "getNON_HOME_TAB_DESTINATIONS", "()Ljava/util/List;", "NO_GUILD_TABS", "getNO_GUILD_TABS", "TAB_DESTINATIONS", "getTAB_DESTINATIONS", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public static final /* synthetic */ Observable access$observeStoreState(Companion companion, StoreNavigation storeNavigation, StoreTabsNavigation storeTabsNavigation, StoreUser storeUser, StoreGuilds storeGuilds, StoreMentions storeMentions, StoreUserRelationships storeUserRelationships) {
            return companion.observeStoreState(storeNavigation, storeTabsNavigation, storeUser, storeGuilds, storeMentions, storeUserRelationships);
        }

        private final Observable<StoreState> observeStoreState(StoreNavigation storeNavigation, StoreTabsNavigation storeTabsNavigation, StoreUser storeUser, StoreGuilds storeGuilds, StoreMentions storeMentions, StoreUserRelationships storeUserRelationships) {
            Observable<StoreState> observableF = Observable.f(storeNavigation.observeLeftPanelState(), storeTabsNavigation.observeSelectedTab(), storeUser.observeMeId(), storeGuilds.observeGuilds(), storeMentions.observeTotalMentions(), storeUserRelationships.observe(), TabsHostViewModel2.INSTANCE);
            Intrinsics3.checkNotNullExpressionValue(observableF, "Observable.combineLatest…nships,\n        )\n      }");
            return observableF;
        }

        public final Set<NavigationTab> getAT_LEAST_ONE_GUILD_TABS() {
            return TabsHostViewModel.access$getAT_LEAST_ONE_GUILD_TABS$cp();
        }

        public final List<NavigationTab> getNON_HOME_TAB_DESTINATIONS() {
            return TabsHostViewModel.access$getNON_HOME_TAB_DESTINATIONS$cp();
        }

        public final Set<NavigationTab> getNO_GUILD_TABS() {
            return TabsHostViewModel.access$getNO_GUILD_TABS$cp();
        }

        public final List<NavigationTab> getTAB_DESTINATIONS() {
            return TabsHostViewModel.access$getTAB_DESTINATIONS$cp();
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: TabsHostViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0002\u0006\u0007¨\u0006\b"}, d2 = {"Lcom/discord/widgets/tabs/TabsHostViewModel$Event;", "", "<init>", "()V", "DismissSearchDialog", "TrackFriendsListShown", "Lcom/discord/widgets/tabs/TabsHostViewModel$Event$TrackFriendsListShown;", "Lcom/discord/widgets/tabs/TabsHostViewModel$Event$DismissSearchDialog;", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static abstract class Event {

        /* compiled from: TabsHostViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/discord/widgets/tabs/TabsHostViewModel$Event$DismissSearchDialog;", "Lcom/discord/widgets/tabs/TabsHostViewModel$Event;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final class DismissSearchDialog extends Event {
            public static final DismissSearchDialog INSTANCE = new DismissSearchDialog();

            private DismissSearchDialog() {
                super(null);
            }
        }

        /* compiled from: TabsHostViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/discord/widgets/tabs/TabsHostViewModel$Event$TrackFriendsListShown;", "Lcom/discord/widgets/tabs/TabsHostViewModel$Event;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final class TrackFriendsListShown extends Event {
            public static final TrackFriendsListShown INSTANCE = new TrackFriendsListShown();

            private TrackFriendsListShown() {
                super(null);
            }
        }

        private Event() {
        }

        public /* synthetic */ Event(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: TabsHostViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0010\b\u0086\b\u0018\u00002\u00020\u0001B_\u0012\u0006\u0010\u0016\u001a\u00020\u0002\u0012\u0006\u0010\u0017\u001a\u00020\u0005\u0012\n\u0010\u0018\u001a\u00060\bj\u0002`\t\u0012\u0016\u0010\u0019\u001a\u0012\u0012\b\u0012\u00060\bj\u0002`\r\u0012\u0004\u0012\u00020\u000e0\f\u0012\u0006\u0010\u001a\u001a\u00020\u0011\u0012\u001a\u0010\u001b\u001a\u0016\u0012\b\u0012\u00060\bj\u0002`\t\u0012\b\u0012\u00060\u0011j\u0002`\u00140\f¢\u0006\u0004\b1\u00102J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0014\u0010\n\u001a\u00060\bj\u0002`\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ \u0010\u000f\u001a\u0012\u0012\b\u0012\u00060\bj\u0002`\r\u0012\u0004\u0012\u00020\u000e0\fHÆ\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0012\u001a\u00020\u0011HÆ\u0003¢\u0006\u0004\b\u0012\u0010\u0013J$\u0010\u0015\u001a\u0016\u0012\b\u0012\u00060\bj\u0002`\t\u0012\b\u0012\u00060\u0011j\u0002`\u00140\fHÆ\u0003¢\u0006\u0004\b\u0015\u0010\u0010Jt\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0016\u001a\u00020\u00022\b\b\u0002\u0010\u0017\u001a\u00020\u00052\f\b\u0002\u0010\u0018\u001a\u00060\bj\u0002`\t2\u0018\b\u0002\u0010\u0019\u001a\u0012\u0012\b\u0012\u00060\bj\u0002`\r\u0012\u0004\u0012\u00020\u000e0\f2\b\b\u0002\u0010\u001a\u001a\u00020\u00112\u001c\b\u0002\u0010\u001b\u001a\u0016\u0012\b\u0012\u00060\bj\u0002`\t\u0012\b\u0012\u00060\u0011j\u0002`\u00140\fHÆ\u0001¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u001f\u001a\u00020\u001eHÖ\u0001¢\u0006\u0004\b\u001f\u0010 J\u0010\u0010!\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b!\u0010\u0013J\u001a\u0010$\u001a\u00020#2\b\u0010\"\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b$\u0010%R\u001d\u0010\u0018\u001a\u00060\bj\u0002`\t8\u0006@\u0006¢\u0006\f\n\u0004\b\u0018\u0010&\u001a\u0004\b'\u0010\u000bR\u0019\u0010\u0017\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0017\u0010(\u001a\u0004\b)\u0010\u0007R\u0019\u0010\u0016\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0016\u0010*\u001a\u0004\b+\u0010\u0004R)\u0010\u0019\u001a\u0012\u0012\b\u0012\u00060\bj\u0002`\r\u0012\u0004\u0012\u00020\u000e0\f8\u0006@\u0006¢\u0006\f\n\u0004\b\u0019\u0010,\u001a\u0004\b-\u0010\u0010R\u0019\u0010\u001a\u001a\u00020\u00118\u0006@\u0006¢\u0006\f\n\u0004\b\u001a\u0010.\u001a\u0004\b/\u0010\u0013R-\u0010\u001b\u001a\u0016\u0012\b\u0012\u00060\bj\u0002`\t\u0012\b\u0012\u00060\u0011j\u0002`\u00140\f8\u0006@\u0006¢\u0006\f\n\u0004\b\u001b\u0010,\u001a\u0004\b0\u0010\u0010¨\u00063"}, d2 = {"Lcom/discord/widgets/tabs/TabsHostViewModel$StoreState;", "", "Lcom/discord/panels/PanelState;", "component1", "()Lcom/discord/panels/PanelState;", "Lcom/discord/widgets/tabs/NavigationTab;", "component2", "()Lcom/discord/widgets/tabs/NavigationTab;", "", "Lcom/discord/primitives/UserId;", "component3", "()J", "", "Lcom/discord/primitives/GuildId;", "Lcom/discord/models/guild/Guild;", "component4", "()Ljava/util/Map;", "", "component5", "()I", "Lcom/discord/primitives/RelationshipType;", "component6", "leftPanelState", "selectedTab", "myUserId", "guildIdToGuildMap", "numTotalMentions", "userRelationships", "copy", "(Lcom/discord/panels/PanelState;Lcom/discord/widgets/tabs/NavigationTab;JLjava/util/Map;ILjava/util/Map;)Lcom/discord/widgets/tabs/TabsHostViewModel$StoreState;", "", "toString", "()Ljava/lang/String;", "hashCode", "other", "", "equals", "(Ljava/lang/Object;)Z", "J", "getMyUserId", "Lcom/discord/widgets/tabs/NavigationTab;", "getSelectedTab", "Lcom/discord/panels/PanelState;", "getLeftPanelState", "Ljava/util/Map;", "getGuildIdToGuildMap", "I", "getNumTotalMentions", "getUserRelationships", "<init>", "(Lcom/discord/panels/PanelState;Lcom/discord/widgets/tabs/NavigationTab;JLjava/util/Map;ILjava/util/Map;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class StoreState {
        private final Map<Long, Guild> guildIdToGuildMap;
        private final PanelState leftPanelState;
        private final long myUserId;
        private final int numTotalMentions;
        private final NavigationTab selectedTab;
        private final Map<Long, Integer> userRelationships;

        public StoreState(PanelState panelState, NavigationTab navigationTab, long j, Map<Long, Guild> map, int i, Map<Long, Integer> map2) {
            Intrinsics3.checkNotNullParameter(panelState, "leftPanelState");
            Intrinsics3.checkNotNullParameter(navigationTab, "selectedTab");
            Intrinsics3.checkNotNullParameter(map, "guildIdToGuildMap");
            Intrinsics3.checkNotNullParameter(map2, "userRelationships");
            this.leftPanelState = panelState;
            this.selectedTab = navigationTab;
            this.myUserId = j;
            this.guildIdToGuildMap = map;
            this.numTotalMentions = i;
            this.userRelationships = map2;
        }

        public static /* synthetic */ StoreState copy$default(StoreState storeState, PanelState panelState, NavigationTab navigationTab, long j, Map map, int i, Map map2, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                panelState = storeState.leftPanelState;
            }
            if ((i2 & 2) != 0) {
                navigationTab = storeState.selectedTab;
            }
            NavigationTab navigationTab2 = navigationTab;
            if ((i2 & 4) != 0) {
                j = storeState.myUserId;
            }
            long j2 = j;
            if ((i2 & 8) != 0) {
                map = storeState.guildIdToGuildMap;
            }
            Map map3 = map;
            if ((i2 & 16) != 0) {
                i = storeState.numTotalMentions;
            }
            int i3 = i;
            if ((i2 & 32) != 0) {
                map2 = storeState.userRelationships;
            }
            return storeState.copy(panelState, navigationTab2, j2, map3, i3, map2);
        }

        /* renamed from: component1, reason: from getter */
        public final PanelState getLeftPanelState() {
            return this.leftPanelState;
        }

        /* renamed from: component2, reason: from getter */
        public final NavigationTab getSelectedTab() {
            return this.selectedTab;
        }

        /* renamed from: component3, reason: from getter */
        public final long getMyUserId() {
            return this.myUserId;
        }

        public final Map<Long, Guild> component4() {
            return this.guildIdToGuildMap;
        }

        /* renamed from: component5, reason: from getter */
        public final int getNumTotalMentions() {
            return this.numTotalMentions;
        }

        public final Map<Long, Integer> component6() {
            return this.userRelationships;
        }

        public final StoreState copy(PanelState leftPanelState, NavigationTab selectedTab, long myUserId, Map<Long, Guild> guildIdToGuildMap, int numTotalMentions, Map<Long, Integer> userRelationships) {
            Intrinsics3.checkNotNullParameter(leftPanelState, "leftPanelState");
            Intrinsics3.checkNotNullParameter(selectedTab, "selectedTab");
            Intrinsics3.checkNotNullParameter(guildIdToGuildMap, "guildIdToGuildMap");
            Intrinsics3.checkNotNullParameter(userRelationships, "userRelationships");
            return new StoreState(leftPanelState, selectedTab, myUserId, guildIdToGuildMap, numTotalMentions, userRelationships);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof StoreState)) {
                return false;
            }
            StoreState storeState = (StoreState) other;
            return Intrinsics3.areEqual(this.leftPanelState, storeState.leftPanelState) && Intrinsics3.areEqual(this.selectedTab, storeState.selectedTab) && this.myUserId == storeState.myUserId && Intrinsics3.areEqual(this.guildIdToGuildMap, storeState.guildIdToGuildMap) && this.numTotalMentions == storeState.numTotalMentions && Intrinsics3.areEqual(this.userRelationships, storeState.userRelationships);
        }

        public final Map<Long, Guild> getGuildIdToGuildMap() {
            return this.guildIdToGuildMap;
        }

        public final PanelState getLeftPanelState() {
            return this.leftPanelState;
        }

        public final long getMyUserId() {
            return this.myUserId;
        }

        public final int getNumTotalMentions() {
            return this.numTotalMentions;
        }

        public final NavigationTab getSelectedTab() {
            return this.selectedTab;
        }

        public final Map<Long, Integer> getUserRelationships() {
            return this.userRelationships;
        }

        public int hashCode() {
            PanelState panelState = this.leftPanelState;
            int iHashCode = (panelState != null ? panelState.hashCode() : 0) * 31;
            NavigationTab navigationTab = this.selectedTab;
            int iA = (b.a(this.myUserId) + ((iHashCode + (navigationTab != null ? navigationTab.hashCode() : 0)) * 31)) * 31;
            Map<Long, Guild> map = this.guildIdToGuildMap;
            int iHashCode2 = (((iA + (map != null ? map.hashCode() : 0)) * 31) + this.numTotalMentions) * 31;
            Map<Long, Integer> map2 = this.userRelationships;
            return iHashCode2 + (map2 != null ? map2.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbU = outline.U("StoreState(leftPanelState=");
            sbU.append(this.leftPanelState);
            sbU.append(", selectedTab=");
            sbU.append(this.selectedTab);
            sbU.append(", myUserId=");
            sbU.append(this.myUserId);
            sbU.append(", guildIdToGuildMap=");
            sbU.append(this.guildIdToGuildMap);
            sbU.append(", numTotalMentions=");
            sbU.append(this.numTotalMentions);
            sbU.append(", userRelationships=");
            return outline.M(sbU, this.userRelationships, ")");
        }
    }

    /* compiled from: TabsHostViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b\r\n\u0002\u0010\u000e\n\u0002\b\u0015\b\u0086\b\u0018\u00002\u00020\u0001BI\u0012\u0006\u0010\u0014\u001a\u00020\u0002\u0012\u0006\u0010\u0015\u001a\u00020\u0005\u0012\u0006\u0010\u0016\u001a\u00020\b\u0012\n\u0010\u0017\u001a\u00060\u000bj\u0002`\f\u0012\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00020\u000f\u0012\u0006\u0010\u0019\u001a\u00020\b\u0012\u0006\u0010\u001a\u001a\u00020\b¢\u0006\u0004\b0\u00101J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0014\u0010\r\u001a\u00060\u000bj\u0002`\fHÆ\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u0016\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00020\u000fHÆ\u0003¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\u0012\u0010\nJ\u0010\u0010\u0013\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\u0013\u0010\nJ`\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0014\u001a\u00020\u00022\b\b\u0002\u0010\u0015\u001a\u00020\u00052\b\b\u0002\u0010\u0016\u001a\u00020\b2\f\b\u0002\u0010\u0017\u001a\u00060\u000bj\u0002`\f2\u000e\b\u0002\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00020\u000f2\b\b\u0002\u0010\u0019\u001a\u00020\b2\b\b\u0002\u0010\u001a\u001a\u00020\bHÆ\u0001¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u001e\u001a\u00020\u001dHÖ\u0001¢\u0006\u0004\b\u001e\u0010\u001fJ\u0010\u0010 \u001a\u00020\bHÖ\u0001¢\u0006\u0004\b \u0010\nJ\u001a\u0010\"\u001a\u00020\u00052\b\u0010!\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\"\u0010#R\u0019\u0010\u0015\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0015\u0010$\u001a\u0004\b%\u0010\u0007R\u0019\u0010\u0019\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\u0019\u0010&\u001a\u0004\b'\u0010\nR\u0019\u0010\u001a\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\u001a\u0010&\u001a\u0004\b(\u0010\nR\u0019\u0010\u0014\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0014\u0010)\u001a\u0004\b*\u0010\u0004R\u001f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00020\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b\u0018\u0010+\u001a\u0004\b,\u0010\u0011R\u0019\u0010\u0016\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\u0016\u0010&\u001a\u0004\b-\u0010\nR\u001d\u0010\u0017\u001a\u00060\u000bj\u0002`\f8\u0006@\u0006¢\u0006\f\n\u0004\b\u0017\u0010.\u001a\u0004\b/\u0010\u000e¨\u00062"}, d2 = {"Lcom/discord/widgets/tabs/TabsHostViewModel$ViewState;", "", "Lcom/discord/widgets/tabs/NavigationTab;", "component1", "()Lcom/discord/widgets/tabs/NavigationTab;", "", "component2", "()Z", "", "component3", "()I", "", "Lcom/discord/primitives/UserId;", "component4", "()J", "", "component5", "()Ljava/util/Set;", "component6", "component7", "selectedTab", "showBottomNav", "bottomNavHeight", "myUserId", "visibleTabs", "numHomeNotifications", "numFriendsNotifications", "copy", "(Lcom/discord/widgets/tabs/NavigationTab;ZIJLjava/util/Set;II)Lcom/discord/widgets/tabs/TabsHostViewModel$ViewState;", "", "toString", "()Ljava/lang/String;", "hashCode", "other", "equals", "(Ljava/lang/Object;)Z", "Z", "getShowBottomNav", "I", "getNumHomeNotifications", "getNumFriendsNotifications", "Lcom/discord/widgets/tabs/NavigationTab;", "getSelectedTab", "Ljava/util/Set;", "getVisibleTabs", "getBottomNavHeight", "J", "getMyUserId", "<init>", "(Lcom/discord/widgets/tabs/NavigationTab;ZIJLjava/util/Set;II)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class ViewState {
        private final int bottomNavHeight;
        private final long myUserId;
        private final int numFriendsNotifications;
        private final int numHomeNotifications;
        private final NavigationTab selectedTab;
        private final boolean showBottomNav;
        private final Set<NavigationTab> visibleTabs;

        /* JADX WARN: Multi-variable type inference failed */
        public ViewState(NavigationTab navigationTab, boolean z2, int i, long j, Set<? extends NavigationTab> set, int i2, int i3) {
            Intrinsics3.checkNotNullParameter(navigationTab, "selectedTab");
            Intrinsics3.checkNotNullParameter(set, "visibleTabs");
            this.selectedTab = navigationTab;
            this.showBottomNav = z2;
            this.bottomNavHeight = i;
            this.myUserId = j;
            this.visibleTabs = set;
            this.numHomeNotifications = i2;
            this.numFriendsNotifications = i3;
        }

        public static /* synthetic */ ViewState copy$default(ViewState viewState, NavigationTab navigationTab, boolean z2, int i, long j, Set set, int i2, int i3, int i4, Object obj) {
            return viewState.copy((i4 & 1) != 0 ? viewState.selectedTab : navigationTab, (i4 & 2) != 0 ? viewState.showBottomNav : z2, (i4 & 4) != 0 ? viewState.bottomNavHeight : i, (i4 & 8) != 0 ? viewState.myUserId : j, (i4 & 16) != 0 ? viewState.visibleTabs : set, (i4 & 32) != 0 ? viewState.numHomeNotifications : i2, (i4 & 64) != 0 ? viewState.numFriendsNotifications : i3);
        }

        /* renamed from: component1, reason: from getter */
        public final NavigationTab getSelectedTab() {
            return this.selectedTab;
        }

        /* renamed from: component2, reason: from getter */
        public final boolean getShowBottomNav() {
            return this.showBottomNav;
        }

        /* renamed from: component3, reason: from getter */
        public final int getBottomNavHeight() {
            return this.bottomNavHeight;
        }

        /* renamed from: component4, reason: from getter */
        public final long getMyUserId() {
            return this.myUserId;
        }

        public final Set<NavigationTab> component5() {
            return this.visibleTabs;
        }

        /* renamed from: component6, reason: from getter */
        public final int getNumHomeNotifications() {
            return this.numHomeNotifications;
        }

        /* renamed from: component7, reason: from getter */
        public final int getNumFriendsNotifications() {
            return this.numFriendsNotifications;
        }

        public final ViewState copy(NavigationTab selectedTab, boolean showBottomNav, int bottomNavHeight, long myUserId, Set<? extends NavigationTab> visibleTabs, int numHomeNotifications, int numFriendsNotifications) {
            Intrinsics3.checkNotNullParameter(selectedTab, "selectedTab");
            Intrinsics3.checkNotNullParameter(visibleTabs, "visibleTabs");
            return new ViewState(selectedTab, showBottomNav, bottomNavHeight, myUserId, visibleTabs, numHomeNotifications, numFriendsNotifications);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ViewState)) {
                return false;
            }
            ViewState viewState = (ViewState) other;
            return Intrinsics3.areEqual(this.selectedTab, viewState.selectedTab) && this.showBottomNav == viewState.showBottomNav && this.bottomNavHeight == viewState.bottomNavHeight && this.myUserId == viewState.myUserId && Intrinsics3.areEqual(this.visibleTabs, viewState.visibleTabs) && this.numHomeNotifications == viewState.numHomeNotifications && this.numFriendsNotifications == viewState.numFriendsNotifications;
        }

        public final int getBottomNavHeight() {
            return this.bottomNavHeight;
        }

        public final long getMyUserId() {
            return this.myUserId;
        }

        public final int getNumFriendsNotifications() {
            return this.numFriendsNotifications;
        }

        public final int getNumHomeNotifications() {
            return this.numHomeNotifications;
        }

        public final NavigationTab getSelectedTab() {
            return this.selectedTab;
        }

        public final boolean getShowBottomNav() {
            return this.showBottomNav;
        }

        public final Set<NavigationTab> getVisibleTabs() {
            return this.visibleTabs;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            NavigationTab navigationTab = this.selectedTab;
            int iHashCode = (navigationTab != null ? navigationTab.hashCode() : 0) * 31;
            boolean z2 = this.showBottomNav;
            int i = z2;
            if (z2 != 0) {
                i = 1;
            }
            int iA = (b.a(this.myUserId) + ((((iHashCode + i) * 31) + this.bottomNavHeight) * 31)) * 31;
            Set<NavigationTab> set = this.visibleTabs;
            return ((((iA + (set != null ? set.hashCode() : 0)) * 31) + this.numHomeNotifications) * 31) + this.numFriendsNotifications;
        }

        public String toString() {
            StringBuilder sbU = outline.U("ViewState(selectedTab=");
            sbU.append(this.selectedTab);
            sbU.append(", showBottomNav=");
            sbU.append(this.showBottomNav);
            sbU.append(", bottomNavHeight=");
            sbU.append(this.bottomNavHeight);
            sbU.append(", myUserId=");
            sbU.append(this.myUserId);
            sbU.append(", visibleTabs=");
            sbU.append(this.visibleTabs);
            sbU.append(", numHomeNotifications=");
            sbU.append(this.numHomeNotifications);
            sbU.append(", numFriendsNotifications=");
            return outline.B(sbU, this.numFriendsNotifications, ")");
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            NavigationTab.values();
            int[] iArr = new int[6];
            $EnumSwitchMapping$0 = iArr;
            iArr[NavigationTab.HOME.ordinal()] = 1;
            iArr[NavigationTab.FRIENDS.ordinal()] = 2;
        }
    }

    static {
        List<NavigationTab> list = _Arrays.toList(NavigationTab.values());
        TAB_DESTINATIONS = list;
        NavigationTab navigationTab = NavigationTab.HOME;
        NON_HOME_TAB_DESTINATIONS = _Collections.minus(list, navigationTab);
        NavigationTab navigationTab2 = NavigationTab.FRIENDS;
        NavigationTab navigationTab3 = NavigationTab.SETTINGS;
        NO_GUILD_TABS = Sets5.setOf((Object[]) new NavigationTab[]{navigationTab, navigationTab2, navigationTab3});
        AT_LEAST_ONE_GUILD_TABS = Sets5.setOf((Object[]) new NavigationTab[]{navigationTab, navigationTab2, NavigationTab.SEARCH, NavigationTab.MENTIONS, navigationTab3});
    }

    public TabsHostViewModel() {
        this(null, null, null, null, 15, null);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ TabsHostViewModel(BottomNavViewObserver bottomNavViewObserver, StoreTabsNavigation storeTabsNavigation, StoreNavigation storeNavigation, Observable observable, int i, DefaultConstructorMarker defaultConstructorMarker) {
        bottomNavViewObserver = (i & 1) != 0 ? BottomNavViewObserver.INSTANCE.getINSTANCE() : bottomNavViewObserver;
        storeTabsNavigation = (i & 2) != 0 ? StoreStream.INSTANCE.getTabsNavigation() : storeTabsNavigation;
        storeNavigation = (i & 4) != 0 ? StoreStream.INSTANCE.getNavigation() : storeNavigation;
        if ((i & 8) != 0) {
            Companion companion = INSTANCE;
            StoreStream.Companion companion2 = StoreStream.INSTANCE;
            observable = Companion.access$observeStoreState(companion, storeNavigation, storeTabsNavigation, companion2.getUsers(), companion2.getGuilds(), companion2.getMentions(), companion2.getUserRelationships());
        }
        this(bottomNavViewObserver, storeTabsNavigation, storeNavigation, observable);
    }

    public static final /* synthetic */ void access$dismissSearchDialog(TabsHostViewModel tabsHostViewModel) {
        tabsHostViewModel.dismissSearchDialog();
    }

    public static final /* synthetic */ Set access$getAT_LEAST_ONE_GUILD_TABS$cp() {
        return AT_LEAST_ONE_GUILD_TABS;
    }

    public static final /* synthetic */ List access$getNON_HOME_TAB_DESTINATIONS$cp() {
        return NON_HOME_TAB_DESTINATIONS;
    }

    public static final /* synthetic */ Set access$getNO_GUILD_TABS$cp() {
        return NO_GUILD_TABS;
    }

    public static final /* synthetic */ List access$getTAB_DESTINATIONS$cp() {
        return TAB_DESTINATIONS;
    }

    public static final /* synthetic */ void access$handleBottomNavHeight(TabsHostViewModel tabsHostViewModel, int i) {
        tabsHostViewModel.handleBottomNavHeight(i);
    }

    public static final /* synthetic */ void access$handleStoreState(TabsHostViewModel tabsHostViewModel, StoreState storeState) {
        tabsHostViewModel.handleStoreState(storeState);
    }

    private final void dismissSearchDialog() {
        PublishSubject<Event> publishSubject = this.eventSubject;
        publishSubject.k.onNext(Event.DismissSearchDialog.INSTANCE);
    }

    private final void emitTrackFriendsListShown() {
        PublishSubject<Event> publishSubject = this.eventSubject;
        publishSubject.k.onNext(Event.TrackFriendsListShown.INSTANCE);
    }

    @MainThread
    private final void handleBottomNavHeight(int height) {
        updateViewState(ViewState.copy$default(requireViewState(), null, false, height, 0L, null, 0, 0, 123, null));
    }

    @MainThread
    private final void handleStoreState(StoreState storeState) {
        this.storeState = storeState;
        NavigationTab selectedTab = storeState.getSelectedTab();
        boolean z2 = NON_HOME_TAB_DESTINATIONS.contains(selectedTab) || (selectedTab == NavigationTab.HOME && (Intrinsics3.areEqual(storeState.getLeftPanelState(), PanelState.c.a) || Intrinsics3.areEqual(storeState.getLeftPanelState(), PanelState.d.a)));
        Set<NavigationTab> set = storeState.getGuildIdToGuildMap().values().isEmpty() ^ true ? AT_LEAST_ONE_GUILD_TABS : NO_GUILD_TABS;
        Map<Long, Integer> userRelationships = storeState.getUserRelationships();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<Long, Integer> entry : userRelationships.entrySet()) {
            if (entry.getValue().intValue() == 3) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        updateViewState(ViewState.copy$default(requireViewState(), selectedTab, z2, 0, storeState.getMyUserId(), set, storeState.getNumTotalMentions(), linkedHashMap.size(), 4, null));
    }

    @MainThread
    public final boolean handleBackPress() {
        NavigationTab navigationTab;
        NavigationTab selectedTab = requireViewState().getSelectedTab();
        if (!TAB_DESTINATIONS.contains(selectedTab) || selectedTab == (navigationTab = NavigationTab.HOME)) {
            return false;
        }
        selectTab(navigationTab);
        return true;
    }

    public final Observable<Event> observeEvents() {
        PublishSubject<Event> publishSubject = this.eventSubject;
        Intrinsics3.checkNotNullExpressionValue(publishSubject, "eventSubject");
        return publishSubject;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x003f  */
    @MainThread
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void selectTab(NavigationTab tab) {
        StoreNavigation.PanelAction panelAction;
        Intrinsics3.checkNotNullParameter(tab, "tab");
        NavigationTab selectedTab = requireViewState().getSelectedTab();
        StoreTabsNavigation.selectTab$default(this.storeTabsNavigation, tab, false, 2, null);
        int iOrdinal = tab.ordinal();
        if (iOrdinal != 0) {
            if (iOrdinal != 1) {
                return;
            }
            emitTrackFriendsListShown();
        } else {
            if (selectedTab != NavigationTab.HOME) {
                panelAction = StoreNavigation.PanelAction.OPEN;
            } else {
                StoreState storeState = this.storeState;
                if (Intrinsics3.areEqual(storeState != null ? storeState.getLeftPanelState() : null, PanelState.c.a)) {
                    panelAction = StoreNavigation.PanelAction.CLOSE;
                }
            }
            StoreNavigation.setNavigationPanelAction$default(this.storeNavigation, panelAction, null, 2, null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TabsHostViewModel(BottomNavViewObserver bottomNavViewObserver, StoreTabsNavigation storeTabsNavigation, StoreNavigation storeNavigation, Observable<StoreState> observable) {
        super(new ViewState(NavigationTab.HOME, false, 0, 0L, NO_GUILD_TABS, 0, 0));
        Intrinsics3.checkNotNullParameter(bottomNavViewObserver, "bottomNavViewObserver");
        Intrinsics3.checkNotNullParameter(storeTabsNavigation, "storeTabsNavigation");
        Intrinsics3.checkNotNullParameter(storeNavigation, "storeNavigation");
        Intrinsics3.checkNotNullParameter(observable, "storeStateObservable");
        this.storeTabsNavigation = storeTabsNavigation;
        this.storeNavigation = storeNavigation;
        this.eventSubject = PublishSubject.k0();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.computationLatest(observable), this, null, 2, null), TabsHostViewModel.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(), 62, (Object) null);
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(bottomNavViewObserver.observeHeight(), this, null, 2, null), TabsHostViewModel.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass2(), 62, (Object) null);
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(storeTabsNavigation.observeDismissTabsDialogEvent(), this, null, 2, null), TabsHostViewModel.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass3(), 62, (Object) null);
    }
}
