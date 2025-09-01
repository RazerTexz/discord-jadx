package com.discord.widgets.channels.threads.browser;

import android.content.Context;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import androidx.core.app.NotificationCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.viewpager.widget.ViewPager;
import b.a.d.AppScreen2;
import b.a.d.AppViewModelDelegates2;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetThreadBrowserBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.stores.StoreChannelsSelected3;
import com.discord.stores.StoreStream;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.utilities.channel.ChannelSelector;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.simple_pager.SimplePager;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.widgets.channels.threads.browser.WidgetThreadBrowserFilterSheet;
import com.discord.widgets.channels.threads.browser.WidgetThreadBrowserViewModel;
import com.google.android.material.tabs.TabLayout;
import d0.LazyJVM;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import d0.z.d.Reflection2;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import rx.functions.Action1;
import rx.functions.Action2;

/* compiled from: WidgetThreadBrowser.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 :2\u00020\u0001:\u0001:B\u0007¢\u0006\u0004\b9\u0010\u0011J!\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000e\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\rH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0014\u0010\u0015R\u001d\u0010\u001b\u001a\u00020\u00168B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001d\u001a\u00020\u001c8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010\u001f\u001a\u00020\u00028\u0002@\u0002X\u0082D¢\u0006\u0006\n\u0004\b\u001f\u0010 R!\u0010&\u001a\u00060!j\u0002`\"8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b#\u0010\u0018\u001a\u0004\b$\u0010%R!\u0010*\u001a\u00060!j\u0002`'8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b(\u0010\u0018\u001a\u0004\b)\u0010%R\u001d\u0010/\u001a\u00020+8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b,\u0010\u0018\u001a\u0004\b-\u0010.R\u0016\u00100\u001a\u00020\u00028\u0002@\u0002X\u0082D¢\u0006\u0006\n\u0004\b0\u0010 R\u001d\u00106\u001a\u0002018B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b2\u00103\u001a\u0004\b4\u00105R\u0018\u00107\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b7\u00108¨\u0006;"}, d2 = {"Lcom/discord/widgets/channels/threads/browser/WidgetThreadBrowser;", "Lcom/discord/app/AppFragment;", "", "selectedPage", "", "canCreateThread", "", "updateMenu", "(ILjava/lang/Boolean;)V", "Lcom/discord/widgets/channels/threads/browser/WidgetThreadBrowserViewModel$ViewState;", "viewState", "updateView", "(Lcom/discord/widgets/channels/threads/browser/WidgetThreadBrowserViewModel$ViewState;)V", "Lcom/discord/widgets/channels/threads/browser/WidgetThreadBrowserViewModel$ViewState$Browser;", "initializeAdapter", "(Lcom/discord/widgets/channels/threads/browser/WidgetThreadBrowserViewModel$ViewState$Browser;)V", "onResume", "()V", "Landroid/view/View;", "view", "onViewBound", "(Landroid/view/View;)V", "Lcom/discord/widgets/channels/threads/browser/WidgetThreadBrowserViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "getViewModel", "()Lcom/discord/widgets/channels/threads/browser/WidgetThreadBrowserViewModel;", "viewModel", "Lcom/discord/utilities/channel/ChannelSelector;", "channelSelector", "Lcom/discord/utilities/channel/ChannelSelector;", "ARCHIVED_PAGE", "I", "", "Lcom/discord/primitives/ChannelId;", "channelId$delegate", "getChannelId", "()J", "channelId", "Lcom/discord/primitives/GuildId;", "guildId$delegate", "getGuildId", "guildId", "Lcom/discord/widgets/channels/threads/browser/WidgetThreadBrowserArchivedViewModel;", "archivedViewModel$delegate", "getArchivedViewModel", "()Lcom/discord/widgets/channels/threads/browser/WidgetThreadBrowserArchivedViewModel;", "archivedViewModel", "ACTIVE_PAGE", "Lcom/discord/databinding/WidgetThreadBrowserBinding;", "binding$delegate", "Lcom/discord/utilities/viewbinding/FragmentViewBindingDelegate;", "getBinding", "()Lcom/discord/databinding/WidgetThreadBrowserBinding;", "binding", "previousViewState", "Lcom/discord/widgets/channels/threads/browser/WidgetThreadBrowserViewModel$ViewState;", "<init>", "Companion", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class WidgetThreadBrowser extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetThreadBrowser.class, "binding", "getBinding()Lcom/discord/databinding/WidgetThreadBrowserBinding;", 0)};

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final int ACTIVE_PAGE;
    private final int ARCHIVED_PAGE;

    /* renamed from: archivedViewModel$delegate, reason: from kotlin metadata */
    private final Lazy archivedViewModel;

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* renamed from: channelId$delegate, reason: from kotlin metadata */
    private final Lazy channelId;
    private final ChannelSelector channelSelector;

    /* renamed from: guildId$delegate, reason: from kotlin metadata */
    private final Lazy guildId;
    private WidgetThreadBrowserViewModel.ViewState previousViewState;

    /* renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* compiled from: WidgetThreadBrowser.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ9\u0010\f\u001a\u00020\u000b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\n\u0010\u0006\u001a\u00060\u0004j\u0002`\u00052\n\u0010\b\u001a\u00060\u0004j\u0002`\u00072\u0006\u0010\n\u001a\u00020\tH\u0007¢\u0006\u0004\b\f\u0010\r¨\u0006\u0010"}, d2 = {"Lcom/discord/widgets/channels/threads/browser/WidgetThreadBrowser$Companion;", "", "Landroid/content/Context;", "context", "", "Lcom/discord/primitives/GuildId;", "guildId", "Lcom/discord/primitives/ChannelId;", "channelId", "", ModelAuditLogEntry.CHANGE_KEY_LOCATION, "", "show", "(Landroid/content/Context;JJLjava/lang/String;)V", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public final void show(Context context, long guildId, long channelId, String location) {
            Intrinsics3.checkNotNullParameter(location, ModelAuditLogEntry.CHANGE_KEY_LOCATION);
            if (context != null) {
                Intent intent = new Intent();
                intent.putExtra("com.discord.intent.extra.EXTRA_GUILD_ID", guildId);
                intent.putExtra("com.discord.intent.extra.EXTRA_CHANNEL_ID", channelId);
                AppScreen2.d(context, WidgetThreadBrowser.class, intent);
                AnalyticsTracker.openModal("Thread Browser", location, Long.valueOf(guildId));
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetThreadBrowser.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Landroidx/fragment/app/Fragment;", "invoke", "()Landroidx/fragment/app/Fragment;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.channels.threads.browser.WidgetThreadBrowser$initializeAdapter$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<Fragment> {
        public AnonymousClass1() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Fragment invoke() {
            return invoke();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final Fragment invoke() {
            return WidgetThreadBrowserActive.INSTANCE.create(WidgetThreadBrowser.access$getViewModel$p(WidgetThreadBrowser.this).getGuildId(), WidgetThreadBrowser.access$getViewModel$p(WidgetThreadBrowser.this).getChannelId());
        }
    }

    /* compiled from: WidgetThreadBrowser.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Landroidx/fragment/app/Fragment;", "invoke", "()Landroidx/fragment/app/Fragment;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.channels.threads.browser.WidgetThreadBrowser$initializeAdapter$2, reason: invalid class name */
    public static final class AnonymousClass2 extends Lambda implements Function0<Fragment> {
        public AnonymousClass2() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Fragment invoke() {
            return invoke();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final Fragment invoke() {
            return WidgetThreadBrowserArchived.INSTANCE.create(WidgetThreadBrowser.access$getViewModel$p(WidgetThreadBrowser.this).getGuildId(), WidgetThreadBrowser.access$getViewModel$p(WidgetThreadBrowser.this).getChannelId());
        }
    }

    /* compiled from: WidgetThreadBrowser.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J'\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\r\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\r\u0010\u0006¨\u0006\u000e"}, d2 = {"com/discord/widgets/channels/threads/browser/WidgetThreadBrowser$initializeAdapter$3", "Landroidx/viewpager/widget/ViewPager$OnPageChangeListener;", "", "state", "", "onPageScrollStateChanged", "(I)V", ModelAuditLogEntry.CHANGE_KEY_POSITION, "", "positionOffset", "positionOffsetPixels", "onPageScrolled", "(IFI)V", "onPageSelected", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.channels.threads.browser.WidgetThreadBrowser$initializeAdapter$3, reason: invalid class name */
    public static final class AnonymousClass3 implements ViewPager.OnPageChangeListener {
        public AnonymousClass3() {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int state) {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int position) {
            WidgetThreadBrowser widgetThreadBrowser = WidgetThreadBrowser.this;
            WidgetThreadBrowserViewModel.ViewState viewStateAccess$getPreviousViewState$p = WidgetThreadBrowser.access$getPreviousViewState$p(widgetThreadBrowser);
            if (!(viewStateAccess$getPreviousViewState$p instanceof WidgetThreadBrowserViewModel.ViewState.Browser)) {
                viewStateAccess$getPreviousViewState$p = null;
            }
            WidgetThreadBrowserViewModel.ViewState.Browser browser = (WidgetThreadBrowserViewModel.ViewState.Browser) viewStateAccess$getPreviousViewState$p;
            WidgetThreadBrowser.access$updateMenu(widgetThreadBrowser, position, browser != null ? Boolean.valueOf(browser.getCanCreateThread()) : null);
            if (position == WidgetThreadBrowser.access$getACTIVE_PAGE$p(WidgetThreadBrowser.this)) {
                StoreStream.INSTANCE.getAnalytics().trackThreadBrowserTabChanged(WidgetThreadBrowser.access$getChannelId$p(WidgetThreadBrowser.this), "Active Threads");
            } else if (position == WidgetThreadBrowser.access$getARCHIVED_PAGE$p(WidgetThreadBrowser.this)) {
                WidgetThreadBrowser.access$getArchivedViewModel$p(WidgetThreadBrowser.this).trackTabChanged();
            }
        }
    }

    /* compiled from: WidgetThreadBrowser.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/widgets/channels/threads/browser/WidgetThreadBrowserViewModel$ViewState;", "viewState", "", "invoke", "(Lcom/discord/widgets/channels/threads/browser/WidgetThreadBrowserViewModel$ViewState;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.channels.threads.browser.WidgetThreadBrowser$onResume$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<WidgetThreadBrowserViewModel.ViewState, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(WidgetThreadBrowserViewModel.ViewState viewState) {
            invoke2(viewState);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(WidgetThreadBrowserViewModel.ViewState viewState) {
            Intrinsics3.checkNotNullParameter(viewState, "viewState");
            WidgetThreadBrowser.access$updateView(WidgetThreadBrowser.this, viewState);
        }
    }

    /* compiled from: WidgetThreadBrowser.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\b\u001a\u00020\u00052\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u00002\u000e\u0010\u0004\u001a\n \u0001*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "menuItem", "Landroid/content/Context;", "<anonymous parameter 1>", "", NotificationCompat.CATEGORY_CALL, "(Landroid/view/MenuItem;Landroid/content/Context;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.channels.threads.browser.WidgetThreadBrowser$updateMenu$1, reason: invalid class name */
    public static final class AnonymousClass1<T1, T2> implements Action2<MenuItem, Context> {
        public AnonymousClass1() {
        }

        @Override // rx.functions.Action2
        public /* bridge */ /* synthetic */ void call(MenuItem menuItem, Context context) {
            call2(menuItem, context);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final void call2(MenuItem menuItem, Context context) {
            Intrinsics3.checkNotNullExpressionValue(menuItem, "menuItem");
            switch (menuItem.getItemId()) {
                case R.id.menu_thread_browser_create_thread /* 2131364416 */:
                    ChannelSelector.openCreateThread$default(ChannelSelector.INSTANCE.getInstance(), WidgetThreadBrowser.access$getGuildId$p(WidgetThreadBrowser.this), WidgetThreadBrowser.access$getChannelId$p(WidgetThreadBrowser.this), null, "Thread Browser Toolbar", 4, null);
                    WidgetThreadBrowser.this.requireAppActivity().finish();
                    break;
                case R.id.menu_thread_browser_filters /* 2131364417 */:
                    WidgetThreadBrowserFilterSheet.Companion companion = WidgetThreadBrowserFilterSheet.INSTANCE;
                    FragmentManager parentFragmentManager = WidgetThreadBrowser.this.getParentFragmentManager();
                    Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
                    companion.show(parentFragmentManager, WidgetThreadBrowser.access$getGuildId$p(WidgetThreadBrowser.this), WidgetThreadBrowser.access$getChannelId$p(WidgetThreadBrowser.this));
                    break;
            }
        }
    }

    /* compiled from: WidgetThreadBrowser.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/Menu;", "kotlin.jvm.PlatformType", "menu", "", NotificationCompat.CATEGORY_CALL, "(Landroid/view/Menu;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.channels.threads.browser.WidgetThreadBrowser$updateMenu$2, reason: invalid class name */
    public static final class AnonymousClass2<T> implements Action1<Menu> {
        public final /* synthetic */ Boolean $canCreateThread;
        public final /* synthetic */ int $selectedPage;

        public AnonymousClass2(int i, Boolean bool) {
            this.$selectedPage = i;
            this.$canCreateThread = bool;
        }

        @Override // rx.functions.Action1
        public /* bridge */ /* synthetic */ void call(Menu menu) {
            call2(menu);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final void call2(Menu menu) {
            MenuItem menuItemFindItem = menu.findItem(R.id.menu_thread_browser_filters);
            if (menuItemFindItem != null) {
                menuItemFindItem.setVisible(this.$selectedPage == WidgetThreadBrowser.access$getARCHIVED_PAGE$p(WidgetThreadBrowser.this));
            }
            MenuItem menuItemFindItem2 = menu.findItem(R.id.menu_thread_browser_create_thread);
            if (menuItemFindItem2 != null) {
                menuItemFindItem2.setVisible(this.$selectedPage == WidgetThreadBrowser.access$getACTIVE_PAGE$p(WidgetThreadBrowser.this) && Intrinsics3.areEqual(this.$canCreateThread, Boolean.TRUE));
            }
        }
    }

    public WidgetThreadBrowser() {
        super(R.layout.widget_thread_browser);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetThreadBrowser3.INSTANCE, null, 2, null);
        this.guildId = LazyJVM.lazy(new WidgetThreadBrowser5(this));
        this.channelId = LazyJVM.lazy(new WidgetThreadBrowser4(this));
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection2.getOrCreateKotlinClass(WidgetThreadBrowserViewModel.class), new WidgetThreadBrowser$appActivityViewModels$$inlined$activityViewModels$1(this), new AppViewModelDelegates2(new WidgetThreadBrowser6(this)));
        this.archivedViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection2.getOrCreateKotlinClass(WidgetThreadBrowserArchivedViewModel.class), new WidgetThreadBrowser$appActivityViewModels$$inlined$activityViewModels$3(this), new AppViewModelDelegates2(new WidgetThreadBrowser2(this)));
        this.channelSelector = ChannelSelector.INSTANCE.getInstance();
        this.ARCHIVED_PAGE = 1;
    }

    public static final /* synthetic */ int access$getACTIVE_PAGE$p(WidgetThreadBrowser widgetThreadBrowser) {
        return widgetThreadBrowser.ACTIVE_PAGE;
    }

    public static final /* synthetic */ int access$getARCHIVED_PAGE$p(WidgetThreadBrowser widgetThreadBrowser) {
        return widgetThreadBrowser.ARCHIVED_PAGE;
    }

    public static final /* synthetic */ WidgetThreadBrowserArchivedViewModel access$getArchivedViewModel$p(WidgetThreadBrowser widgetThreadBrowser) {
        return widgetThreadBrowser.getArchivedViewModel();
    }

    public static final /* synthetic */ long access$getChannelId$p(WidgetThreadBrowser widgetThreadBrowser) {
        return widgetThreadBrowser.getChannelId();
    }

    public static final /* synthetic */ long access$getGuildId$p(WidgetThreadBrowser widgetThreadBrowser) {
        return widgetThreadBrowser.getGuildId();
    }

    public static final /* synthetic */ WidgetThreadBrowserViewModel.ViewState access$getPreviousViewState$p(WidgetThreadBrowser widgetThreadBrowser) {
        return widgetThreadBrowser.previousViewState;
    }

    public static final /* synthetic */ WidgetThreadBrowserViewModel access$getViewModel$p(WidgetThreadBrowser widgetThreadBrowser) {
        return widgetThreadBrowser.getViewModel();
    }

    public static final /* synthetic */ void access$setPreviousViewState$p(WidgetThreadBrowser widgetThreadBrowser, WidgetThreadBrowserViewModel.ViewState viewState) {
        widgetThreadBrowser.previousViewState = viewState;
    }

    public static final /* synthetic */ void access$updateMenu(WidgetThreadBrowser widgetThreadBrowser, int i, Boolean bool) {
        widgetThreadBrowser.updateMenu(i, bool);
    }

    public static final /* synthetic */ void access$updateView(WidgetThreadBrowser widgetThreadBrowser, WidgetThreadBrowserViewModel.ViewState viewState) {
        widgetThreadBrowser.updateView(viewState);
    }

    private final WidgetThreadBrowserArchivedViewModel getArchivedViewModel() {
        return (WidgetThreadBrowserArchivedViewModel) this.archivedViewModel.getValue();
    }

    private final WidgetThreadBrowserBinding getBinding() {
        return (WidgetThreadBrowserBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final long getChannelId() {
        return ((Number) this.channelId.getValue()).longValue();
    }

    private final long getGuildId() {
        return ((Number) this.guildId.getValue()).longValue();
    }

    private final WidgetThreadBrowserViewModel getViewModel() {
        return (WidgetThreadBrowserViewModel) this.viewModel.getValue();
    }

    private final void initializeAdapter(WidgetThreadBrowserViewModel.ViewState.Browser viewState) {
        SimplePager simplePager = getBinding().c;
        Intrinsics3.checkNotNullExpressionValue(simplePager, "binding.threadBrowserViewPager");
        if (simplePager.getAdapter() == null) {
            ArrayList arrayList = new ArrayList();
            String string = getString(R.string.thread_browser_active);
            Intrinsics3.checkNotNullExpressionValue(string, "getString(R.string.thread_browser_active)");
            arrayList.add(new SimplePager.Adapter.Item(string, new AnonymousClass1()));
            if (viewState.getCanViewArchivedThreads()) {
                String string2 = getString(R.string.thread_browser_archived);
                Intrinsics3.checkNotNullExpressionValue(string2, "getString(R.string.thread_browser_archived)");
                arrayList.add(new SimplePager.Adapter.Item(string2, new AnonymousClass2()));
            }
            SimplePager simplePager2 = getBinding().c;
            Intrinsics3.checkNotNullExpressionValue(simplePager2, "binding.threadBrowserViewPager");
            FragmentManager parentFragmentManager = getParentFragmentManager();
            Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
            Object[] array = arrayList.toArray(new SimplePager.Adapter.Item[0]);
            Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
            SimplePager.Adapter.Item[] itemArr = (SimplePager.Adapter.Item[]) array;
            simplePager2.setAdapter(new SimplePager.Adapter(parentFragmentManager, (SimplePager.Adapter.Item[]) Arrays.copyOf(itemArr, itemArr.length)));
            getBinding().c.addOnPageChangeListener(new AnonymousClass3());
            TabLayout tabLayout = getBinding().f2670b;
            Intrinsics3.checkNotNullExpressionValue(tabLayout, "binding.actionBarTabs");
            tabLayout.setVisibility(viewState.getCanViewArchivedThreads() ? 0 : 8);
        }
    }

    public static final void show(Context context, long j, long j2, String str) {
        INSTANCE.show(context, j, j2, str);
    }

    private final void updateMenu(int selectedPage, Boolean canCreateThread) {
        setActionBarOptionsMenu(R.menu.menu_thread_browser, new AnonymousClass1(), new AnonymousClass2(selectedPage, canCreateThread));
    }

    private final void updateView(WidgetThreadBrowserViewModel.ViewState viewState) {
        this.previousViewState = viewState;
        if (viewState instanceof WidgetThreadBrowserViewModel.ViewState.GoToChannel) {
            ChannelSelector.selectChannel$default(this.channelSelector, ((WidgetThreadBrowserViewModel.ViewState.GoToChannel) viewState).getChannel(), null, StoreChannelsSelected3.THREAD_BROWSER, 2, null);
            requireActivity().onBackPressed();
            return;
        }
        if (viewState instanceof WidgetThreadBrowserViewModel.ViewState.Browser) {
            WidgetThreadBrowserViewModel.ViewState.Browser browser = (WidgetThreadBrowserViewModel.ViewState.Browser) viewState;
            initializeAdapter(browser);
            if (browser.getChannelName() != null && !browser.isForumChannel()) {
                StringBuilder sbU = outline.U("#");
                sbU.append(browser.getChannelName());
                setActionBarSubtitle(sbU.toString());
            }
            if (browser.getChannelName() != null && browser.isForumChannel()) {
                StringBuilder sbU2 = outline.U("#");
                sbU2.append(browser.getChannelName());
                setActionBarTitle(sbU2.toString());
            }
            SimplePager simplePager = getBinding().c;
            Intrinsics3.checkNotNullExpressionValue(simplePager, "binding.threadBrowserViewPager");
            updateMenu(simplePager.getCurrentItem(), Boolean.valueOf(browser.getCanCreateThread()));
        }
    }

    @Override // com.discord.app.AppFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeViewState(), this, null, 2, null), WidgetThreadBrowser.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(), 62, (Object) null);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        AppFragment.setActionBarDisplayHomeAsUpEnabled$default(this, false, 1, null);
        setActionBarTitle(R.string.thread_browser_title);
    }
}
