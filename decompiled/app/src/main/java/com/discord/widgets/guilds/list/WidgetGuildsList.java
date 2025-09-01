package com.discord.widgets.guilds.list;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.PointF;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import b.a.d.AppScreen2;
import b.a.d.AppToast;
import b.a.d.AppViewModelDelegates3;
import b.a.d.AppViewModelDelegates5;
import b.a.k.FormatUtils;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetGuildsListBinding;
import com.discord.stores.StoreConnectionOpen;
import com.discord.stores.StoreNux;
import com.discord.stores.StoreStream;
import com.discord.utilities.accessibility.AccessibilityUtils;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.utilities.dimen.DimenUtils;
import com.discord.utilities.drawable.DrawableCompat;
import com.discord.utilities.resources.StringResourceUtils;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.widgets.channels.list.WidgetChannelListUnreads;
import com.discord.widgets.channels.list.WidgetChannelsListItemChannelActions;
import com.discord.widgets.guilds.contextmenu.WidgetFolderContextMenu;
import com.discord.widgets.guilds.contextmenu.WidgetGuildContextMenu;
import com.discord.widgets.guilds.create.CreateGuildTrigger;
import com.discord.widgets.guilds.list.GuildListItem;
import com.discord.widgets.guilds.list.WidgetGuildListAdapter;
import com.discord.widgets.guilds.list.WidgetGuildsListViewModel;
import com.discord.widgets.home.WidgetHome;
import com.discord.widgets.hubs.WidgetHubEmailFlow;
import com.discord.widgets.hubs.WidgetHubEmailViewModel2;
import com.discord.widgets.nux.WidgetGuildTemplates;
import com.discord.widgets.nux.WidgetNavigationHelp;
import com.discord.widgets.tabs.BottomNavViewObserver;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import d0.z.d.Reflection2;
import java.util.Objects;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import rx.Observable;

/* compiled from: WidgetGuildsList.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u008e\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u00012\u00020\u0002:\u0001PB\u0007¢\u0006\u0004\bO\u0010\tJ\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\f\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u000e\u0010\tJ\u000f\u0010\u000f\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u000f\u0010\tJ\u000f\u0010\u0010\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0010\u0010\tJ\u000f\u0010\u0011\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0011\u0010\tJ\u000f\u0010\u0012\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0012\u0010\tJ\u0017\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u0013H\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u001b\u0010\u001a\u001a\u00020\u00052\n\u0010\u0019\u001a\u00060\u0017j\u0002`\u0018H\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u001e\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\u001cH\u0002¢\u0006\u0004\b\u001e\u0010\u001fJ\u0017\u0010\"\u001a\u00020\u00052\u0006\u0010!\u001a\u00020 H\u0002¢\u0006\u0004\b\"\u0010#J\u0017\u0010&\u001a\u00020\u00052\u0006\u0010%\u001a\u00020$H\u0002¢\u0006\u0004\b&\u0010'J\u0017\u0010*\u001a\u00020\u00052\u0006\u0010)\u001a\u00020(H\u0016¢\u0006\u0004\b*\u0010+J\u000f\u0010,\u001a\u00020\u0005H\u0016¢\u0006\u0004\b,\u0010\tJ\u001f\u0010.\u001a\u00020\u00052\u0006\u0010)\u001a\u00020(2\u0006\u0010\u0014\u001a\u00020-H\u0016¢\u0006\u0004\b.\u0010/J\u001f\u00100\u001a\u00020\u00052\u0006\u0010)\u001a\u00020(2\u0006\u0010\u0014\u001a\u00020-H\u0016¢\u0006\u0004\b0\u0010/J\u000f\u00101\u001a\u00020\u0005H\u0016¢\u0006\u0004\b1\u0010\tJ\u0017\u00104\u001a\u00020\u00052\u0006\u00103\u001a\u000202H\u0016¢\u0006\u0004\b4\u00105J\u000f\u00106\u001a\u00020$H\u0016¢\u0006\u0004\b6\u00107R\u0016\u00109\u001a\u0002088\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b9\u0010:R\u0018\u0010<\u001a\u0004\u0018\u00010;8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b<\u0010=R\u0016\u0010?\u001a\u00020>8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b?\u0010@R\u001d\u0010F\u001a\u00020A8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\bB\u0010C\u001a\u0004\bD\u0010ER\u001d\u0010L\u001a\u00020G8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\bH\u0010I\u001a\u0004\bJ\u0010KR\u0018\u0010M\u001a\u0004\u0018\u00010(8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bM\u0010N¨\u0006Q"}, d2 = {"Lcom/discord/widgets/guilds/list/WidgetGuildsList;", "Lcom/discord/app/AppFragment;", "Lcom/discord/widgets/guilds/list/WidgetGuildListAdapter$InteractionListener;", "Lcom/discord/widgets/guilds/list/WidgetGuildsListViewModel$ViewState;", "viewState", "", "configureUI", "(Lcom/discord/widgets/guilds/list/WidgetGuildsListViewModel$ViewState;)V", "configureBottomNavSpace", "()V", "Lcom/discord/widgets/guilds/list/WidgetGuildsListViewModel$Event;", "event", "handleEvent", "(Lcom/discord/widgets/guilds/list/WidgetGuildsListViewModel$Event;)V", "setupRecycler", "showCreateGuild", "showHubVerification", "showHelp", "focusFirstElement", "Lcom/discord/widgets/guilds/list/GuildListItem$FolderItem;", "item", "announceFolderToggle", "(Lcom/discord/widgets/guilds/list/GuildListItem$FolderItem;)V", "", "Lcom/discord/primitives/ChannelId;", "channelId", "showChannelActions", "(J)V", "", "unavailableGuildCount", "showUnavailableGuildsToast", "(I)V", "Lcom/discord/widgets/guilds/list/WidgetGuildsList$AddGuildHint;", "addGuildHint", "configureAddGuildHint", "(Lcom/discord/widgets/guilds/list/WidgetGuildsList$AddGuildHint;)V", "", "wasAcknowledged", "dismissAddGuildHint", "(Z)V", "Landroid/view/View;", "view", "onViewBound", "(Landroid/view/View;)V", "onResume", "Lcom/discord/widgets/guilds/list/GuildListItem;", "onItemClicked", "(Landroid/view/View;Lcom/discord/widgets/guilds/list/GuildListItem;)V", "onItemLongPressed", "onItemMoved", "Lcom/discord/widgets/guilds/list/WidgetGuildListAdapter$Operation;", "operation", "onOperation", "(Lcom/discord/widgets/guilds/list/WidgetGuildListAdapter$Operation;)V", "onDrop", "()Z", "Lcom/discord/widgets/guilds/list/WidgetGuildListAdapter;", "adapter", "Lcom/discord/widgets/guilds/list/WidgetGuildListAdapter;", "Lcom/discord/widgets/channels/list/WidgetChannelListUnreads;", "guildListUnreads", "Lcom/discord/widgets/channels/list/WidgetChannelListUnreads;", "Lcom/discord/widgets/tabs/BottomNavViewObserver;", "bottomNavViewObserver", "Lcom/discord/widgets/tabs/BottomNavViewObserver;", "Lcom/discord/databinding/WidgetGuildsListBinding;", "binding$delegate", "Lcom/discord/utilities/viewbinding/FragmentViewBindingDelegate;", "getBinding", "()Lcom/discord/databinding/WidgetGuildsListBinding;", "binding", "Lcom/discord/widgets/guilds/list/WidgetGuildsListViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "getViewModel", "()Lcom/discord/widgets/guilds/list/WidgetGuildsListViewModel;", "viewModel", "guildListAddHint", "Landroid/view/View;", "<init>", "AddGuildHint", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class WidgetGuildsList extends AppFragment implements WidgetGuildListAdapter.InteractionListener {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetGuildsList.class, "binding", "getBinding()Lcom/discord/databinding/WidgetGuildsListBinding;", 0)};
    private WidgetGuildListAdapter adapter;

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private final BottomNavViewObserver bottomNavViewObserver;
    private View guildListAddHint;
    private WidgetChannelListUnreads guildListUnreads;

    /* renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* compiled from: WidgetGuildsList.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\b\u0082\b\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u0019\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J$\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0006\u001a\u00020\u00022\b\b\u0002\u0010\u0007\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0011\u001a\u00020\u00022\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0013\u001a\u0004\b\u0007\u0010\u0004R\u0019\u0010\u0006\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0013\u001a\u0004\b\u0006\u0010\u0004¨\u0006\u0017"}, d2 = {"Lcom/discord/widgets/guilds/list/WidgetGuildsList$AddGuildHint;", "", "", "component1", "()Z", "component2", "isEligible", "isAddGuildHint", "copy", "(ZZ)Lcom/discord/widgets/guilds/list/WidgetGuildsList$AddGuildHint;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Z", "<init>", "(ZZ)V", "Companion", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class AddGuildHint {

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final boolean isAddGuildHint;
        private final boolean isEligible;

        /* compiled from: WidgetGuildsList.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\b\u0010\tJ\u0013\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0013\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0002¢\u0006\u0004\b\u0007\u0010\u0005¨\u0006\n"}, d2 = {"Lcom/discord/widgets/guilds/list/WidgetGuildsList$AddGuildHint$Companion;", "", "Lrx/Observable;", "Lcom/discord/widgets/guilds/list/WidgetGuildsList$AddGuildHint;", "get", "()Lrx/Observable;", "", "getDismissAction", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final class Companion {
            private Companion() {
            }

            public final Observable<AddGuildHint> get() {
                StoreStream.Companion companion = StoreStream.INSTANCE;
                Observable observableY = Observable.i(companion.getNux().getNuxState(), StoreConnectionOpen.observeConnectionOpen$default(companion.getConnectionOpen(), false, 1, null), companion.getChannels().observeGuildAndPrivateChannels(), WidgetGuildsList2.INSTANCE).y(WidgetGuildsList3.INSTANCE);
                Intrinsics3.checkNotNullExpressionValue(observableY, "Observable\n             ….filter { it.isEligible }");
                Observable<AddGuildHint> observableM = ObservableExtensionsKt.takeSingleUntilTimeout$default(observableY, 0L, false, 3, null).M(WidgetGuildsList4.INSTANCE);
                Intrinsics3.checkNotNullExpressionValue(observableM, "Observable\n             … = false)\n              }");
                return observableM;
            }

            public final Observable<Boolean> getDismissAction() {
                Observable observableG = StoreStream.INSTANCE.getNavigation().observeLeftPanelState().G(WidgetGuildsList5.INSTANCE);
                Intrinsics3.checkNotNullExpressionValue(observableG, "StoreStream\n            …te == PanelState.Closed }");
                return observableG;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public AddGuildHint(boolean z2, boolean z3) {
            this.isEligible = z2;
            this.isAddGuildHint = z3;
        }

        public static /* synthetic */ AddGuildHint copy$default(AddGuildHint addGuildHint, boolean z2, boolean z3, int i, Object obj) {
            if ((i & 1) != 0) {
                z2 = addGuildHint.isEligible;
            }
            if ((i & 2) != 0) {
                z3 = addGuildHint.isAddGuildHint;
            }
            return addGuildHint.copy(z2, z3);
        }

        /* renamed from: component1, reason: from getter */
        public final boolean getIsEligible() {
            return this.isEligible;
        }

        /* renamed from: component2, reason: from getter */
        public final boolean getIsAddGuildHint() {
            return this.isAddGuildHint;
        }

        public final AddGuildHint copy(boolean isEligible, boolean isAddGuildHint) {
            return new AddGuildHint(isEligible, isAddGuildHint);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof AddGuildHint)) {
                return false;
            }
            AddGuildHint addGuildHint = (AddGuildHint) other;
            return this.isEligible == addGuildHint.isEligible && this.isAddGuildHint == addGuildHint.isAddGuildHint;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v1, types: [int] */
        /* JADX WARN: Type inference failed for: r0v4 */
        /* JADX WARN: Type inference failed for: r0v5 */
        public int hashCode() {
            boolean z2 = this.isEligible;
            ?? r0 = z2;
            if (z2) {
                r0 = 1;
            }
            int i = r0 * 31;
            boolean z3 = this.isAddGuildHint;
            return i + (z3 ? 1 : z3 ? 1 : 0);
        }

        public final boolean isAddGuildHint() {
            return this.isAddGuildHint;
        }

        public final boolean isEligible() {
            return this.isEligible;
        }

        public String toString() {
            StringBuilder sbU = outline.U("AddGuildHint(isEligible=");
            sbU.append(this.isEligible);
            sbU.append(", isAddGuildHint=");
            return outline.O(sbU, this.isAddGuildHint, ")");
        }

        public /* synthetic */ AddGuildHint(boolean z2, boolean z3, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(z2, (i & 2) != 0 ? false : z3);
        }
    }

    /* compiled from: WidgetGuildsList.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/discord/stores/StoreNux$NuxState;", "nux", "invoke", "(Lcom/discord/stores/StoreNux$NuxState;)Lcom/discord/stores/StoreNux$NuxState;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.guilds.list.WidgetGuildsList$configureAddGuildHint$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<StoreNux.NuxState, StoreNux.NuxState> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ StoreNux.NuxState invoke(StoreNux.NuxState nuxState) {
            return invoke2(nuxState);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final StoreNux.NuxState invoke2(StoreNux.NuxState nuxState) {
            Intrinsics3.checkNotNullParameter(nuxState, "nux");
            return StoreNux.NuxState.copy$default(nuxState, false, false, false, false, false, null, 47, null);
        }
    }

    /* compiled from: WidgetGuildsList.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "bottomNavHeight", "", "invoke", "(I)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.guilds.list.WidgetGuildsList$configureBottomNavSpace$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<Integer, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
            invoke(num.intValue());
            return Unit.a;
        }

        public final void invoke(int i) {
            WidgetGuildsList.access$getAdapter$p(WidgetGuildsList.this).handleBottomNavHeight(i);
            ViewStub viewStub = WidgetGuildsList.access$getBinding$p(WidgetGuildsList.this).c;
            Intrinsics3.checkNotNullExpressionValue(viewStub, "binding.guildListUnreadsStub");
            ViewGroup.LayoutParams layoutParams = viewStub.getLayoutParams();
            Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            marginLayoutParams.setMargins(marginLayoutParams.leftMargin, marginLayoutParams.topMargin, marginLayoutParams.rightMargin, i);
            ViewStub viewStub2 = WidgetGuildsList.access$getBinding$p(WidgetGuildsList.this).c;
            Intrinsics3.checkNotNullExpressionValue(viewStub2, "binding.guildListUnreadsStub");
            viewStub2.setLayoutParams(marginLayoutParams);
        }
    }

    /* compiled from: WidgetGuildsList.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/widgets/guilds/list/WidgetGuildsListViewModel$ViewState;", "it", "", "invoke", "(Lcom/discord/widgets/guilds/list/WidgetGuildsListViewModel$ViewState;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.guilds.list.WidgetGuildsList$onResume$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<WidgetGuildsListViewModel.ViewState, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(WidgetGuildsListViewModel.ViewState viewState) {
            invoke2(viewState);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(WidgetGuildsListViewModel.ViewState viewState) {
            Intrinsics3.checkNotNullParameter(viewState, "it");
            WidgetGuildsList.access$configureUI(WidgetGuildsList.this, viewState);
        }
    }

    /* compiled from: WidgetGuildsList.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/widgets/guilds/list/WidgetGuildsListViewModel$Event;", "it", "", "invoke", "(Lcom/discord/widgets/guilds/list/WidgetGuildsListViewModel$Event;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.guilds.list.WidgetGuildsList$onResume$2, reason: invalid class name */
    public static final class AnonymousClass2 extends Lambda implements Function1<WidgetGuildsListViewModel.Event, Unit> {
        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(WidgetGuildsListViewModel.Event event) {
            invoke2(event);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(WidgetGuildsListViewModel.Event event) {
            Intrinsics3.checkNotNullParameter(event, "it");
            WidgetGuildsList.access$handleEvent(WidgetGuildsList.this, event);
        }
    }

    /* compiled from: WidgetGuildsList.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/widgets/guilds/list/WidgetGuildsList$AddGuildHint;", "it", "", "invoke", "(Lcom/discord/widgets/guilds/list/WidgetGuildsList$AddGuildHint;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.guilds.list.WidgetGuildsList$onResume$3, reason: invalid class name */
    public static final class AnonymousClass3 extends Lambda implements Function1<AddGuildHint, Unit> {
        public AnonymousClass3() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(AddGuildHint addGuildHint) {
            invoke2(addGuildHint);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(AddGuildHint addGuildHint) {
            Intrinsics3.checkNotNullParameter(addGuildHint, "it");
            WidgetGuildsList.access$configureAddGuildHint(WidgetGuildsList.this, addGuildHint);
        }
    }

    /* compiled from: WidgetGuildsList.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "shouldDismiss", "", "invoke", "(Z)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.guilds.list.WidgetGuildsList$onResume$4, reason: invalid class name */
    public static final class AnonymousClass4 extends Lambda implements Function1<Boolean, Unit> {
        public AnonymousClass4() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
            invoke(bool.booleanValue());
            return Unit.a;
        }

        public final void invoke(boolean z2) {
            if (z2) {
                WidgetGuildsList.access$dismissAddGuildHint(WidgetGuildsList.this, false);
            }
        }
    }

    /* compiled from: WidgetGuildsList.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\b\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()I", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.guilds.list.WidgetGuildsList$onViewBound$1, reason: invalid class name */
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
            return WidgetGuildsList.access$getAdapter$p(WidgetGuildsList.this).getItemCount();
        }
    }

    /* compiled from: WidgetGuildsList.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/view/View;", "it", "", "invoke", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.guilds.list.WidgetGuildsList$onViewBound$2, reason: invalid class name */
    public static final class AnonymousClass2 extends Lambda implements Function1<View, Unit> {

        /* compiled from: WidgetGuildsList.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
        /* renamed from: com.discord.widgets.guilds.list.WidgetGuildsList$onViewBound$2$1, reason: invalid class name */
        public static final class AnonymousClass1 implements View.OnClickListener {
            public AnonymousClass1() {
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WidgetGuildsList.access$dismissAddGuildHint(WidgetGuildsList.this, true);
            }
        }

        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(View view) {
            invoke2(view);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(View view) {
            Intrinsics3.checkNotNullParameter(view, "it");
            WidgetGuildsList.access$setGuildListAddHint$p(WidgetGuildsList.this, view);
            View viewAccess$getGuildListAddHint$p = WidgetGuildsList.access$getGuildListAddHint$p(WidgetGuildsList.this);
            if (viewAccess$getGuildListAddHint$p != null) {
                viewAccess$getGuildListAddHint$p.setOnClickListener(new AnonymousClass1());
            }
        }
    }

    public WidgetGuildsList() {
        super(R.layout.widget_guilds_list);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetGuildsList6.INSTANCE, null, 2, null);
        this.bottomNavViewObserver = BottomNavViewObserver.INSTANCE.getINSTANCE();
        WidgetGuildsList7 widgetGuildsList7 = WidgetGuildsList7.INSTANCE;
        AppViewModelDelegates3 appViewModelDelegates3 = new AppViewModelDelegates3(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection2.getOrCreateKotlinClass(WidgetGuildsListViewModel.class), new WidgetGuildsList$appViewModels$$inlined$viewModels$1(appViewModelDelegates3), new AppViewModelDelegates5(widgetGuildsList7));
    }

    public static final /* synthetic */ void access$configureAddGuildHint(WidgetGuildsList widgetGuildsList, AddGuildHint addGuildHint) {
        widgetGuildsList.configureAddGuildHint(addGuildHint);
    }

    public static final /* synthetic */ void access$configureUI(WidgetGuildsList widgetGuildsList, WidgetGuildsListViewModel.ViewState viewState) {
        widgetGuildsList.configureUI(viewState);
    }

    public static final /* synthetic */ void access$dismissAddGuildHint(WidgetGuildsList widgetGuildsList, boolean z2) {
        widgetGuildsList.dismissAddGuildHint(z2);
    }

    public static final /* synthetic */ WidgetGuildListAdapter access$getAdapter$p(WidgetGuildsList widgetGuildsList) {
        WidgetGuildListAdapter widgetGuildListAdapter = widgetGuildsList.adapter;
        if (widgetGuildListAdapter == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("adapter");
        }
        return widgetGuildListAdapter;
    }

    public static final /* synthetic */ WidgetGuildsListBinding access$getBinding$p(WidgetGuildsList widgetGuildsList) {
        return widgetGuildsList.getBinding();
    }

    public static final /* synthetic */ View access$getGuildListAddHint$p(WidgetGuildsList widgetGuildsList) {
        return widgetGuildsList.guildListAddHint;
    }

    public static final /* synthetic */ void access$handleEvent(WidgetGuildsList widgetGuildsList, WidgetGuildsListViewModel.Event event) {
        widgetGuildsList.handleEvent(event);
    }

    public static final /* synthetic */ void access$setAdapter$p(WidgetGuildsList widgetGuildsList, WidgetGuildListAdapter widgetGuildListAdapter) {
        widgetGuildsList.adapter = widgetGuildListAdapter;
    }

    public static final /* synthetic */ void access$setGuildListAddHint$p(WidgetGuildsList widgetGuildsList, View view) {
        widgetGuildsList.guildListAddHint = view;
    }

    private final void announceFolderToggle(GuildListItem.FolderItem item) {
        Object[] objArr = new Object[2];
        objArr[0] = FormatUtils.k(this, item.isOpen() ? R.string.collapsed : R.string.expanded, new Object[0], null, 4);
        String name = item.getName();
        if (name == null) {
            name = "";
        }
        objArr[1] = name;
        AccessibilityUtils.INSTANCE.sendAnnouncement(requireContext(), outline.P(objArr, 2, "%s, %s", "java.lang.String.format(this, *args)"));
    }

    private final void configureAddGuildHint(AddGuildHint addGuildHint) {
        if (addGuildHint.isAddGuildHint()) {
            StoreStream.INSTANCE.getNux().updateNux(AnonymousClass1.INSTANCE);
        }
        if (addGuildHint.isEligible()) {
            AnalyticsTracker.INSTANCE.showFirstServerTipTutorial();
            View view = this.guildListAddHint;
            if (view != null) {
                ViewExtensions.fadeIn$default(view, 0L, null, null, null, 15, null);
            }
        }
    }

    private final void configureBottomNavSpace() {
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(this.bottomNavViewObserver.observeHeight(), this, null, 2, null), WidgetGuildsList.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(), 62, (Object) null);
    }

    private final void configureUI(WidgetGuildsListViewModel.ViewState viewState) {
        View view;
        if (viewState instanceof WidgetGuildsListViewModel.ViewState.Loaded) {
            WidgetGuildListAdapter widgetGuildListAdapter = this.adapter;
            if (widgetGuildListAdapter == null) {
                Intrinsics3.throwUninitializedPropertyAccessException("adapter");
            }
            WidgetGuildsListViewModel.ViewState.Loaded loaded = (WidgetGuildsListViewModel.ViewState.Loaded) viewState;
            widgetGuildListAdapter.setItems(loaded.getItems(), !loaded.getWasDragResult());
            WidgetChannelListUnreads widgetChannelListUnreads = this.guildListUnreads;
            if (widgetChannelListUnreads != null) {
                widgetChannelListUnreads.onDatasetChanged(loaded.getItems());
            }
            if (loaded.getHasChannels() && (view = this.guildListAddHint) != null && view.getVisibility() == 0) {
                dismissAddGuildHint(false);
            }
        }
    }

    private final void dismissAddGuildHint(boolean wasAcknowledged) {
        if (wasAcknowledged) {
            View view = this.guildListAddHint;
            if (view != null) {
                ViewExtensions.fadeOut$default(view, 0L, null, null, 7, null);
            }
            AnalyticsTracker.INSTANCE.closeFirstServerTipTutorial(true);
            return;
        }
        View view2 = this.guildListAddHint;
        if (view2 == null || view2.getVisibility() != 0) {
            return;
        }
        View view3 = this.guildListAddHint;
        if (view3 != null) {
            view3.setVisibility(8);
        }
        AnalyticsTracker.INSTANCE.closeFirstServerTipTutorial(false);
    }

    private final void focusFirstElement() {
        View childAt = getBinding().f2458b.getChildAt(0);
        if (childAt != null) {
            childAt.sendAccessibilityEvent(8);
        }
    }

    private final WidgetGuildsListBinding getBinding() {
        return (WidgetGuildsListBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final WidgetGuildsListViewModel getViewModel() {
        return (WidgetGuildsListViewModel) this.viewModel.getValue();
    }

    private final void handleEvent(WidgetGuildsListViewModel.Event event) {
        if (event instanceof WidgetGuildsListViewModel.Event.ShowChannelActions) {
            showChannelActions(((WidgetGuildsListViewModel.Event.ShowChannelActions) event).getChannelId());
            return;
        }
        if (event instanceof WidgetGuildsListViewModel.Event.ShowUnavailableGuilds) {
            showUnavailableGuildsToast(((WidgetGuildsListViewModel.Event.ShowUnavailableGuilds) event).getUnavailableGuildCount());
            return;
        }
        if (event instanceof WidgetGuildsListViewModel.Event.AnnounceFolderToggleForAccessibility) {
            announceFolderToggle(((WidgetGuildsListViewModel.Event.AnnounceFolderToggleForAccessibility) event).getItem());
            return;
        }
        if (Intrinsics3.areEqual(event, WidgetGuildsListViewModel.Event.ShowCreateGuild.INSTANCE)) {
            showCreateGuild();
            return;
        }
        if (Intrinsics3.areEqual(event, WidgetGuildsListViewModel.Event.ShowHubVerification.INSTANCE)) {
            showHubVerification();
        } else if (Intrinsics3.areEqual(event, WidgetGuildsListViewModel.Event.ShowHelp.INSTANCE)) {
            showHelp();
        } else {
            if (!Intrinsics3.areEqual(event, WidgetGuildsListViewModel.Event.FocusFirstElement.INSTANCE)) {
                throw new NoWhenBranchMatchedException();
            }
            focusFirstElement();
        }
    }

    private final void setupRecycler() {
        RecyclerView recyclerView = getBinding().f2458b;
        Intrinsics3.checkNotNullExpressionValue(recyclerView, "binding.guildList");
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(recyclerView.getContext(), 1, false);
        WidgetGuildListAdapter widgetGuildListAdapter = new WidgetGuildListAdapter(linearLayoutManager, this);
        this.adapter = widgetGuildListAdapter;
        if (widgetGuildListAdapter == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("adapter");
        }
        widgetGuildListAdapter.setHasStableIds(true);
        RecyclerView recyclerView2 = getBinding().f2458b;
        Intrinsics3.checkNotNullExpressionValue(recyclerView2, "binding.guildList");
        recyclerView2.setItemAnimator(null);
        RecyclerView recyclerView3 = getBinding().f2458b;
        Intrinsics3.checkNotNullExpressionValue(recyclerView3, "binding.guildList");
        recyclerView3.setLayoutManager(linearLayoutManager);
        RecyclerView recyclerView4 = getBinding().f2458b;
        Intrinsics3.checkNotNullExpressionValue(recyclerView4, "binding.guildList");
        WidgetGuildListAdapter widgetGuildListAdapter2 = this.adapter;
        if (widgetGuildListAdapter2 == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("adapter");
        }
        recyclerView4.setAdapter(widgetGuildListAdapter2);
        WidgetGuildListAdapter widgetGuildListAdapter3 = this.adapter;
        if (widgetGuildListAdapter3 == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("adapter");
        }
        new ItemTouchHelper(new GuildsDragAndDropCallback(widgetGuildListAdapter3)).attachToRecyclerView(getBinding().f2458b);
        RecyclerView recyclerView5 = getBinding().f2458b;
        Drawable drawable = ContextCompat.getDrawable(requireContext(), DrawableCompat.getThemedDrawableRes$default(requireContext(), R.attr.bg_folder_no_children, 0, 2, (Object) null));
        Intrinsics3.checkNotNull(drawable);
        Intrinsics3.checkNotNullExpressionValue(drawable, "ContextCompat.getDrawabl…children)\n            )!!");
        Drawable drawable2 = ContextCompat.getDrawable(requireContext(), DrawableCompat.getThemedDrawableRes$default(requireContext(), R.attr.bg_folder_tintable_no_children, 0, 2, (Object) null));
        Intrinsics3.checkNotNull(drawable2);
        Intrinsics3.checkNotNullExpressionValue(drawable2, "ContextCompat.getDrawabl…children)\n            )!!");
        Drawable drawable3 = ContextCompat.getDrawable(requireContext(), DrawableCompat.getThemedDrawableRes$default(requireContext(), R.attr.bg_folder_with_children, 0, 2, (Object) null));
        Intrinsics3.checkNotNull(drawable3);
        Intrinsics3.checkNotNullExpressionValue(drawable3, "ContextCompat.getDrawabl…children)\n            )!!");
        recyclerView5.addItemDecoration(new FolderItemDecoration(drawable, drawable2, drawable3, requireContext().getResources().getDimensionPixelSize(R.dimen.avatar_size_large)));
    }

    private final void showChannelActions(long channelId) {
        WidgetChannelsListItemChannelActions.Companion companion = WidgetChannelsListItemChannelActions.INSTANCE;
        FragmentManager parentFragmentManager = getParentFragmentManager();
        Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
        companion.show(parentFragmentManager, channelId);
    }

    private final void showCreateGuild() {
        dismissAddGuildHint(true);
        WidgetGuildTemplates.INSTANCE.launch(requireContext(), CreateGuildTrigger.IN_APP, false);
    }

    private final void showHelp() {
        dismissAddGuildHint(true);
        WidgetNavigationHelp.Companion companion = WidgetNavigationHelp.INSTANCE;
        FragmentManager parentFragmentManager = getParentFragmentManager();
        Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
        companion.show(parentFragmentManager);
    }

    private final void showHubVerification() {
        AppScreen2.d(requireContext(), WidgetHubEmailFlow.class, new WidgetHubEmailViewModel2(null, 0, null, 7, null));
    }

    private final void showUnavailableGuildsToast(int unavailableGuildCount) {
        Resources resources = getResources();
        Intrinsics3.checkNotNullExpressionValue(resources, "resources");
        AppToast.h(getContext(), FormatUtils.l(StringResourceUtils.getQuantityString(resources, requireContext(), R.plurals.partial_outage_count, unavailableGuildCount, Integer.valueOf(unavailableGuildCount)), new Object[0], null, 2), 0, null, 12);
    }

    @Override // com.discord.widgets.guilds.list.WidgetGuildListAdapter.InteractionListener
    public boolean onDrop() {
        return getViewModel().onDrop();
    }

    @Override // com.discord.widgets.guilds.list.WidgetGuildListAdapter.InteractionListener
    public void onItemClicked(View view, GuildListItem item) {
        Intrinsics3.checkNotNullParameter(view, "view");
        Intrinsics3.checkNotNullParameter(item, "item");
        WidgetGuildsListViewModel viewModel = getViewModel();
        Context contextRequireContext = requireContext();
        FragmentManager parentFragmentManager = getParentFragmentManager();
        Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
        viewModel.onItemClicked(item, contextRequireContext, parentFragmentManager);
    }

    @Override // com.discord.widgets.guilds.list.WidgetGuildListAdapter.InteractionListener
    public void onItemLongPressed(View view, GuildListItem item) {
        Intrinsics3.checkNotNullParameter(view, "view");
        Intrinsics3.checkNotNullParameter(item, "item");
        boolean z2 = item instanceof GuildListItem.GuildItem;
        if (!z2 && !(item instanceof GuildListItem.FolderItem)) {
            getViewModel().onItemLongPressed(item);
            return;
        }
        view.getLocationInWindow(new int[2]);
        PointF pointF = new PointF(r1[0] + DimenUtils.dpToPixels(64), r1[1]);
        if (z2) {
            WidgetGuildContextMenu.Companion companion = WidgetGuildContextMenu.INSTANCE;
            FragmentActivity fragmentActivityRequireActivity = requireActivity();
            Intrinsics3.checkNotNullExpressionValue(fragmentActivityRequireActivity, "requireActivity()");
            companion.show(fragmentActivityRequireActivity, pointF, ((GuildListItem.GuildItem) item).getGuild().getId());
            return;
        }
        if (item instanceof GuildListItem.FolderItem) {
            WidgetFolderContextMenu.Companion companion2 = WidgetFolderContextMenu.INSTANCE;
            FragmentActivity fragmentActivityRequireActivity2 = requireActivity();
            Intrinsics3.checkNotNullExpressionValue(fragmentActivityRequireActivity2, "requireActivity()");
            companion2.show(fragmentActivityRequireActivity2, pointF, ((GuildListItem.FolderItem) item).getFolderId());
        }
    }

    @Override // com.discord.widgets.guilds.list.WidgetGuildListAdapter.InteractionListener
    public void onItemMoved() {
        WidgetGuildContextMenu.Companion companion = WidgetGuildContextMenu.INSTANCE;
        FragmentActivity fragmentActivityRequireActivity = requireActivity();
        Intrinsics3.checkNotNullExpressionValue(fragmentActivityRequireActivity, "requireActivity()");
        companion.hide(fragmentActivityRequireActivity, true);
        WidgetFolderContextMenu.Companion companion2 = WidgetFolderContextMenu.INSTANCE;
        FragmentActivity fragmentActivityRequireActivity2 = requireActivity();
        Intrinsics3.checkNotNullExpressionValue(fragmentActivityRequireActivity2, "requireActivity()");
        companion2.hide(fragmentActivityRequireActivity2, true);
    }

    @Override // com.discord.widgets.guilds.list.WidgetGuildListAdapter.InteractionListener
    public void onOperation(WidgetGuildListAdapter.Operation operation) {
        Intrinsics3.checkNotNullParameter(operation, "operation");
        if (operation instanceof WidgetGuildListAdapter.Operation.MoveAbove) {
            WidgetGuildListAdapter.Operation.MoveAbove moveAbove = (WidgetGuildListAdapter.Operation.MoveAbove) operation;
            getViewModel().moveAbove(moveAbove.getFromPosition(), moveAbove.getTargetPosition());
        } else if (operation instanceof WidgetGuildListAdapter.Operation.MoveBelow) {
            WidgetGuildListAdapter.Operation.MoveBelow moveBelow = (WidgetGuildListAdapter.Operation.MoveBelow) operation;
            getViewModel().moveBelow(moveBelow.getFromPosition(), moveBelow.getTargetPosition());
        } else if (operation instanceof WidgetGuildListAdapter.Operation.TargetOperation) {
            WidgetGuildListAdapter.Operation.TargetOperation targetOperation = (WidgetGuildListAdapter.Operation.TargetOperation) operation;
            getViewModel().target(targetOperation.getFromPosition(), targetOperation.getTargetPosition());
        }
    }

    @Override // com.discord.app.AppFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeViewState(), this, null, 2, null), WidgetGuildsList.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(), 62, (Object) null);
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().listenForEvents(), this, null, 2, null), WidgetGuildsList.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass2(), 62, (Object) null);
        AddGuildHint.Companion companion = AddGuildHint.INSTANCE;
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(companion.get(), this, null, 2, null), WidgetGuildsList.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass3(), 62, (Object) null);
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(companion.getDismissAction(), this, null, 2, null), WidgetGuildsList.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass4(), 62, (Object) null);
        configureBottomNavSpace();
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        setupRecycler();
        ViewStub viewStub = getBinding().c;
        Intrinsics3.checkNotNullExpressionValue(viewStub, "binding.guildListUnreadsStub");
        RecyclerView recyclerView = getBinding().f2458b;
        Intrinsics3.checkNotNullExpressionValue(recyclerView, "binding.guildList");
        WidgetChannelListUnreads widgetChannelListUnreads = new WidgetChannelListUnreads(viewStub, recyclerView, null, new AnonymousClass1(), 0, 0, false, 116, null);
        this.guildListUnreads = widgetChannelListUnreads;
        if (widgetChannelListUnreads != null) {
            widgetChannelListUnreads.setMentionResId(R.string._new);
        }
        WidgetChannelListUnreads widgetChannelListUnreads2 = this.guildListUnreads;
        if (widgetChannelListUnreads2 != null) {
            widgetChannelListUnreads2.setUnreadsEnabled(false);
        }
        Fragment parentFragment = getParentFragment();
        if (!(parentFragment instanceof WidgetHome)) {
            parentFragment = null;
        }
        WidgetHome widgetHome = (WidgetHome) parentFragment;
        if (widgetHome != null) {
            widgetHome.setOnGuildListAddHintCreate(new AnonymousClass2());
        }
    }
}
