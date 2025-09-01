package com.discord.widgets.friends;

import android.content.Context;
import android.os.Bundle;
import android.view.ContextThemeWrapper;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.PopupMenu;
import androidx.core.app.NotificationCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.recyclerview.widget.RecyclerView;
import b.a.d.AppToast;
import b.a.d.AppViewModelDelegates3;
import b.a.d.AppViewModelDelegates5;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.app.AppFragment;
import com.discord.app.AppViewFlipper;
import com.discord.databinding.WidgetFriendsListBinding;
import com.discord.models.user.User;
import com.discord.stores.StoreNavigation;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreTabsNavigation;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.utilities.analytics.Traits;
import com.discord.utilities.captcha.CaptchaErrorBody;
import com.discord.utilities.captcha.CaptchaHelper;
import com.discord.utilities.channel.ChannelSelector;
import com.discord.utilities.mg_recycler.MGRecyclerAdapter;
import com.discord.utilities.rest.RestAPIAbortMessages;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.widgets.captcha.WidgetCaptchaBottomSheet;
import com.discord.widgets.channels.WidgetGroupInviteFriends;
import com.discord.widgets.channels.invite.GroupInviteFriendsSheet;
import com.discord.widgets.channels.invite.GroupInviteFriendsSheetFeatureFlag;
import com.discord.widgets.contact_sync.ContactSyncFlowAnalytics;
import com.discord.widgets.contact_sync.WidgetContactSync;
import com.discord.widgets.friends.FriendsListViewModel;
import com.discord.widgets.friends.WidgetFriendsAdd;
import com.discord.widgets.tabs.NavigationTab;
import com.discord.widgets.tabs.OnTabSelectedListener;
import com.discord.widgets.tabs.WidgetTabsHost;
import com.discord.widgets.user.calls.PrivateCallLauncher;
import com.discord.widgets.user.usersheet.WidgetUserSheet;
import d0.Tuples;
import d0.t.MapsJVM;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import d0.z.d.Reflection2;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.reflect.KProperty;
import rx.functions.Action1;
import rx.functions.Action2;

/* compiled from: WidgetFriendsList.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u009c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 H2\u00020\u00012\u00020\u0002:\u0001HB\u0007¢\u0006\u0004\bG\u0010\u0005J\u000f\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\b\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\nH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\r\u0010\u0005J\u0017\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u0015H\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u0019H\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u001d\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u001cH\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ\u0017\u0010 \u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u001fH\u0002¢\u0006\u0004\b \u0010!J\u0017\u0010#\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\"H\u0002¢\u0006\u0004\b#\u0010$J\u0019\u0010'\u001a\u00020\u00032\b\u0010&\u001a\u0004\u0018\u00010%H\u0016¢\u0006\u0004\b'\u0010(J\u0017\u0010+\u001a\u00020\u00032\u0006\u0010*\u001a\u00020)H\u0016¢\u0006\u0004\b+\u0010,J\u000f\u0010-\u001a\u00020\u0003H\u0016¢\u0006\u0004\b-\u0010\u0005J\u000f\u0010.\u001a\u00020\u0003H\u0016¢\u0006\u0004\b.\u0010\u0005R\u0016\u00100\u001a\u00020/8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b0\u00101R\u001d\u00107\u001a\u0002028B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b3\u00104\u001a\u0004\b5\u00106R\u0016\u00109\u001a\u0002088\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b9\u0010:R\u001d\u0010@\u001a\u00020;8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b<\u0010=\u001a\u0004\b>\u0010?R\u0016\u0010B\u001a\u00020A8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\bB\u0010CR\u0016\u0010E\u001a\u00020D8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\bE\u0010F¨\u0006I"}, d2 = {"Lcom/discord/widgets/friends/WidgetFriendsList;", "Lcom/discord/app/AppFragment;", "Lcom/discord/widgets/tabs/OnTabSelectedListener;", "", "configureToolbar", "()V", "Lcom/discord/widgets/friends/FriendsListViewModel$ViewState;", "viewState", "configureUI", "(Lcom/discord/widgets/friends/FriendsListViewModel$ViewState;)V", "Lcom/discord/widgets/friends/FriendsListViewModel$ViewState$Loaded;", "updateView", "(Lcom/discord/widgets/friends/FriendsListViewModel$ViewState$Loaded;)V", "showLoadingView", "Lcom/discord/widgets/friends/FriendsListViewModel$ViewState$Empty;", "showEmptyView", "(Lcom/discord/widgets/friends/FriendsListViewModel$ViewState$Empty;)V", "", "index", "displayFlipperChild", "(I)V", "Lcom/discord/widgets/friends/FriendsListViewModel$Event;", "event", "handleEvent", "(Lcom/discord/widgets/friends/FriendsListViewModel$Event;)V", "Lcom/discord/widgets/friends/FriendsListViewModel$Event$ShowToast;", "handleShowToast", "(Lcom/discord/widgets/friends/FriendsListViewModel$Event$ShowToast;)V", "Lcom/discord/widgets/friends/FriendsListViewModel$Event$ShowFriendRequestErrorToast;", "handleShowFriendRequestErrorToast", "(Lcom/discord/widgets/friends/FriendsListViewModel$Event$ShowFriendRequestErrorToast;)V", "Lcom/discord/widgets/friends/FriendsListViewModel$Event$LaunchVoiceCall;", "handleLaunchVoiceCall", "(Lcom/discord/widgets/friends/FriendsListViewModel$Event$LaunchVoiceCall;)V", "Lcom/discord/widgets/friends/FriendsListViewModel$Event$CaptchaError;", "handleCaptchaError", "(Lcom/discord/widgets/friends/FriendsListViewModel$Event$CaptchaError;)V", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "Landroid/view/View;", "view", "onViewBound", "(Landroid/view/View;)V", "onViewBoundOrOnResume", "onTabSelected", "Lcom/discord/widgets/friends/WidgetFriendsListAdapter;", "adapter", "Lcom/discord/widgets/friends/WidgetFriendsListAdapter;", "Lcom/discord/widgets/friends/FriendsListViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "getViewModel", "()Lcom/discord/widgets/friends/FriendsListViewModel;", "viewModel", "", "showContactSyncIcon", "Z", "Lcom/discord/databinding/WidgetFriendsListBinding;", "binding$delegate", "Lcom/discord/utilities/viewbinding/FragmentViewBindingDelegate;", "getBinding", "()Lcom/discord/databinding/WidgetFriendsListBinding;", "binding", "Lcom/discord/widgets/user/calls/PrivateCallLauncher;", "privateCallLauncher", "Lcom/discord/widgets/user/calls/PrivateCallLauncher;", "Lcom/discord/widgets/friends/WidgetFriendsListLoadingAdapter;", "loadingAdapter", "Lcom/discord/widgets/friends/WidgetFriendsListLoadingAdapter;", "<init>", "Companion", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class WidgetFriendsList extends AppFragment implements OnTabSelectedListener {
    private static final String ANALYTICS_SOURCE = "Friends";
    private static final int VIEW_INDEX_EMPTY = 1;
    private static final int VIEW_INDEX_LOADING = 2;
    private static final int VIEW_INDEX_RECYCLER = 0;
    private WidgetFriendsListAdapter adapter;

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private WidgetFriendsList5 loadingAdapter;
    private PrivateCallLauncher privateCallLauncher;
    private boolean showContactSyncIcon;

    /* renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetFriendsList.class, "binding", "getBinding()Lcom/discord/databinding/WidgetFriendsListBinding;", 0)};

    /* compiled from: WidgetFriendsList.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\b\u001a\u00020\u00052\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u00002\u000e\u0010\u0004\u001a\n \u0001*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "menuItem", "Landroid/content/Context;", "context", "", NotificationCompat.CATEGORY_CALL, "(Landroid/view/MenuItem;Landroid/content/Context;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.friends.WidgetFriendsList$configureToolbar$1, reason: invalid class name */
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
                case R.id.menu_friends_add_friend /* 2131364389 */:
                    WidgetFriendsAdd.Companion companion = WidgetFriendsAdd.INSTANCE;
                    Intrinsics3.checkNotNullExpressionValue(context, "context");
                    WidgetFriendsAdd.Companion.show$default(companion, context, null, WidgetFriendsList.ANALYTICS_SOURCE, 2, null);
                    break;
                case R.id.menu_friends_contact_sync /* 2131364390 */:
                    ContactSyncFlowAnalytics.Companion.trackStart$default(ContactSyncFlowAnalytics.INSTANCE, false, MapsJVM.mapOf(Tuples.to("location_page", "Friends List Icon")), 1, null);
                    AnalyticsTracker.INSTANCE.openModal("Contact Sync", new Traits.Location("Friends List Icon", null, null, null, null, 30, null));
                    WidgetContactSync.Companion companion2 = WidgetContactSync.INSTANCE;
                    Intrinsics3.checkNotNullExpressionValue(context, "context");
                    WidgetContactSync.Companion.launch$default(companion2, context, null, false, false, false, 30, null);
                    break;
                case R.id.menu_friends_start_group /* 2131364391 */:
                    if (!GroupInviteFriendsSheetFeatureFlag.INSTANCE.getINSTANCE().isEnabled()) {
                        WidgetGroupInviteFriends.INSTANCE.launch(WidgetFriendsList.this.requireContext(), WidgetFriendsList.ANALYTICS_SOURCE);
                        break;
                    } else {
                        GroupInviteFriendsSheet.Companion companion3 = GroupInviteFriendsSheet.INSTANCE;
                        FragmentManager parentFragmentManager = WidgetFriendsList.this.getParentFragmentManager();
                        Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
                        GroupInviteFriendsSheet.Companion.show$default(companion3, parentFragmentManager, 0L, WidgetFriendsList.ANALYTICS_SOURCE, 2, null);
                        break;
                    }
            }
        }
    }

    /* compiled from: WidgetFriendsList.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/Menu;", "kotlin.jvm.PlatformType", "menu", "", NotificationCompat.CATEGORY_CALL, "(Landroid/view/Menu;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.friends.WidgetFriendsList$configureToolbar$2, reason: invalid class name */
    public static final class AnonymousClass2<T> implements Action1<Menu> {
        public AnonymousClass2() {
        }

        @Override // rx.functions.Action1
        public /* bridge */ /* synthetic */ void call(Menu menu) {
            call2(menu);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final void call2(Menu menu) {
            MenuItem menuItemFindItem = menu.findItem(R.id.menu_friends_contact_sync);
            if (menuItemFindItem != null) {
                menuItemFindItem.setVisible(WidgetFriendsList.access$getShowContactSyncIcon$p(WidgetFriendsList.this));
            }
        }
    }

    /* compiled from: WidgetFriendsList.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lcom/discord/app/AppFragment;", "<anonymous parameter 0>", "Lcom/discord/utilities/captcha/CaptchaHelper$CaptchaPayload;", "captchaPayload", "", "invoke", "(Lcom/discord/app/AppFragment;Lcom/discord/utilities/captcha/CaptchaHelper$CaptchaPayload;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.friends.WidgetFriendsList$handleCaptchaError$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function2<AppFragment, CaptchaHelper.CaptchaPayload, Unit> {
        public final /* synthetic */ FriendsListViewModel.Event.CaptchaError $event;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(FriendsListViewModel.Event.CaptchaError captchaError) {
            super(2);
            this.$event = captchaError;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(AppFragment appFragment, CaptchaHelper.CaptchaPayload captchaPayload) {
            invoke2(appFragment, captchaPayload);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(AppFragment appFragment, CaptchaHelper.CaptchaPayload captchaPayload) {
            Intrinsics3.checkNotNullParameter(appFragment, "<anonymous parameter 0>");
            Intrinsics3.checkNotNullParameter(captchaPayload, "captchaPayload");
            WidgetFriendsList.access$getViewModel$p(WidgetFriendsList.this).acceptFriendSuggestion(this.$event.getUsername(), this.$event.getDiscriminator(), captchaPayload);
        }
    }

    /* compiled from: WidgetFriendsList.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Landroid/view/View;", "<anonymous parameter 0>", "Lcom/discord/models/user/User;", "user", "", "invoke", "(Landroid/view/View;Lcom/discord/models/user/User;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.friends.WidgetFriendsList$onViewBound$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function2<View, User, Unit> {
        public AnonymousClass1() {
            super(2);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(View view, User user) {
            invoke2(view, user);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(View view, User user) {
            Intrinsics3.checkNotNullParameter(view, "<anonymous parameter 0>");
            Intrinsics3.checkNotNullParameter(user, "user");
            WidgetUserSheet.Companion companion = WidgetUserSheet.INSTANCE;
            long id2 = user.getId();
            FragmentManager parentFragmentManager = WidgetFriendsList.this.getParentFragmentManager();
            Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
            WidgetUserSheet.Companion.show$default(companion, id2, null, parentFragmentManager, null, null, null, null, 122, null);
        }
    }

    /* compiled from: WidgetFriendsList.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/models/user/User;", "user", "", "invoke", "(Lcom/discord/models/user/User;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.friends.WidgetFriendsList$onViewBound$10, reason: invalid class name */
    public static final class AnonymousClass10 extends Lambda implements Function1<User, Unit> {
        public AnonymousClass10() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(User user) {
            invoke2(user);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(User user) {
            Intrinsics3.checkNotNullParameter(user, "user");
            FriendsListViewModel.acceptFriendSuggestion$default(WidgetFriendsList.access$getViewModel$p(WidgetFriendsList.this), user.getUsername(), user.getDiscriminator(), null, 4, null);
        }
    }

    /* compiled from: WidgetFriendsList.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\n\u0010\u0002\u001a\u00060\u0000j\u0002`\u0001¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "Lcom/discord/primitives/UserId;", "p1", "", "invoke", "(J)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.friends.WidgetFriendsList$onViewBound$11, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass11 extends FunctionReferenceImpl implements Function1<Long, Unit> {
        public AnonymousClass11(FriendsListViewModel friendsListViewModel) {
            super(1, friendsListViewModel, FriendsListViewModel.class, "ignoreSuggestion", "ignoreSuggestion(J)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Long l) {
            invoke(l.longValue());
            return Unit.a;
        }

        public final void invoke(long j) {
            ((FriendsListViewModel) this.receiver).ignoreSuggestion(j);
        }
    }

    /* compiled from: WidgetFriendsList.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.friends.WidgetFriendsList$onViewBound$2, reason: invalid class name */
    public static final class AnonymousClass2 extends Lambda implements Function0<Unit> {
        public AnonymousClass2() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            WidgetFriendsList.access$getViewModel$p(WidgetFriendsList.this).handleClickPendingHeader();
        }
    }

    /* compiled from: WidgetFriendsList.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/models/user/User;", "user", "", "invoke", "(Lcom/discord/models/user/User;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.friends.WidgetFriendsList$onViewBound$3, reason: invalid class name */
    public static final class AnonymousClass3 extends Lambda implements Function1<User, Unit> {
        public AnonymousClass3() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(User user) {
            invoke2(user);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(User user) {
            Intrinsics3.checkNotNullParameter(user, "user");
            WidgetFriendsList.access$getViewModel$p(WidgetFriendsList.this).launchVoiceCall(user.getId());
        }
    }

    /* compiled from: WidgetFriendsList.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/models/user/User;", "user", "", "invoke", "(Lcom/discord/models/user/User;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.friends.WidgetFriendsList$onViewBound$4, reason: invalid class name */
    public static final class AnonymousClass4 extends Lambda implements Function1<User, Unit> {
        public AnonymousClass4() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(User user) {
            invoke2(user);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(User user) {
            Intrinsics3.checkNotNullParameter(user, "user");
            ChannelSelector.INSTANCE.getInstance().findAndSetDirectMessage(WidgetFriendsList.this.requireContext(), user.getId());
            StoreTabsNavigation.selectHomeTab$default(StoreStream.INSTANCE.getTabsNavigation(), StoreNavigation.PanelAction.CLOSE, false, 2, null);
        }
    }

    /* compiled from: WidgetFriendsList.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/models/user/User;", "it", "", "invoke", "(Lcom/discord/models/user/User;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.friends.WidgetFriendsList$onViewBound$5, reason: invalid class name */
    public static final class AnonymousClass5 extends Lambda implements Function1<User, Unit> {
        public AnonymousClass5() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(User user) {
            invoke2(user);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(User user) {
            Intrinsics3.checkNotNullParameter(user, "it");
            WidgetFriendsList.access$getViewModel$p(WidgetFriendsList.this).acceptFriendRequest(user.getId(), user.getUsername());
        }
    }

    /* compiled from: WidgetFriendsList.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\b\u001a\u00020\u00052\u0006\u0010\u0001\u001a\u00020\u00002\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"Lcom/discord/models/user/User;", "user", "", "Lcom/discord/primitives/RelationshipType;", "relationshipType", "", "invoke", "(Lcom/discord/models/user/User;I)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.friends.WidgetFriendsList$onViewBound$6, reason: invalid class name */
    public static final class AnonymousClass6 extends Lambda implements Function2<User, Integer, Unit> {
        public AnonymousClass6() {
            super(2);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(User user, Integer num) {
            invoke(user, num.intValue());
            return Unit.a;
        }

        public final void invoke(User user, int i) {
            Intrinsics3.checkNotNullParameter(user, "user");
            WidgetFriendsList.access$getViewModel$p(WidgetFriendsList.this).removeFriendRequest(user.getId(), i);
        }
    }

    /* compiled from: WidgetFriendsList.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.friends.WidgetFriendsList$onViewBound$7, reason: invalid class name */
    public static final class AnonymousClass7 extends Lambda implements Function0<Unit> {
        public AnonymousClass7() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            ContactSyncFlowAnalytics.Companion.trackStart$default(ContactSyncFlowAnalytics.INSTANCE, false, MapsJVM.mapOf(Tuples.to("location_page", "Friends List Upsell")), 1, null);
            AnalyticsTracker.INSTANCE.openModal("Contact Sync", new Traits.Location("Friends List Upsell", null, null, null, null, 30, null));
            WidgetContactSync.Companion.launch$default(WidgetContactSync.INSTANCE, WidgetFriendsList.this.requireContext(), null, false, false, false, 30, null);
        }
    }

    /* compiled from: WidgetFriendsList.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/view/View;", "upsellView", "", "invoke", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.friends.WidgetFriendsList$onViewBound$8, reason: invalid class name */
    public static final class AnonymousClass8 extends Lambda implements Function1<View, Unit> {

        /* compiled from: WidgetFriendsList.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "it", "", "onMenuItemClick", "(Landroid/view/MenuItem;)Z", "<anonymous>"}, k = 3, mv = {1, 4, 2})
        /* renamed from: com.discord.widgets.friends.WidgetFriendsList$onViewBound$8$1, reason: invalid class name */
        public static final class AnonymousClass1 implements MenuItem.OnMenuItemClickListener {
            public AnonymousClass1() {
            }

            @Override // android.view.MenuItem.OnMenuItemClickListener
            public final boolean onMenuItemClick(MenuItem menuItem) {
                WidgetFriendsList.access$getViewModel$p(WidgetFriendsList.this).dismissContactSyncUpsell();
                return true;
            }
        }

        public AnonymousClass8() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(View view) {
            invoke2(view);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(View view) {
            Intrinsics3.checkNotNullParameter(view, "upsellView");
            PopupMenu popupMenu = new PopupMenu(new ContextThemeWrapper(view.getContext(), 2131951663), view);
            popupMenu.getMenuInflater().inflate(R.menu.menu_contact_sync_upsell, popupMenu.getMenu());
            popupMenu.getMenu().findItem(R.id.menu_contact_sync_upsell_dismiss).setOnMenuItemClickListener(new AnonymousClass1());
            popupMenu.show();
        }
    }

    /* compiled from: WidgetFriendsList.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.friends.WidgetFriendsList$onViewBound$9, reason: invalid class name */
    public static final class AnonymousClass9 extends Lambda implements Function0<Unit> {
        public AnonymousClass9() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            WidgetFriendsList.access$getViewModel$p(WidgetFriendsList.this).handleClickSuggestedHeader();
        }
    }

    /* compiled from: WidgetFriendsList.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/widgets/friends/FriendsListViewModel$ViewState;", "p1", "", "invoke", "(Lcom/discord/widgets/friends/FriendsListViewModel$ViewState;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.friends.WidgetFriendsList$onViewBoundOrOnResume$1, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<FriendsListViewModel.ViewState, Unit> {
        public AnonymousClass1(WidgetFriendsList widgetFriendsList) {
            super(1, widgetFriendsList, WidgetFriendsList.class, "configureUI", "configureUI(Lcom/discord/widgets/friends/FriendsListViewModel$ViewState;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(FriendsListViewModel.ViewState viewState) {
            invoke2(viewState);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(FriendsListViewModel.ViewState viewState) {
            Intrinsics3.checkNotNullParameter(viewState, "p1");
            WidgetFriendsList.access$configureUI((WidgetFriendsList) this.receiver, viewState);
        }
    }

    /* compiled from: WidgetFriendsList.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/widgets/friends/FriendsListViewModel$Event;", "p1", "", "invoke", "(Lcom/discord/widgets/friends/FriendsListViewModel$Event;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.friends.WidgetFriendsList$onViewBoundOrOnResume$2, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass2 extends FunctionReferenceImpl implements Function1<FriendsListViewModel.Event, Unit> {
        public AnonymousClass2(WidgetFriendsList widgetFriendsList) {
            super(1, widgetFriendsList, WidgetFriendsList.class, "handleEvent", "handleEvent(Lcom/discord/widgets/friends/FriendsListViewModel$Event;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(FriendsListViewModel.Event event) {
            invoke2(event);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(FriendsListViewModel.Event event) {
            Intrinsics3.checkNotNullParameter(event, "p1");
            WidgetFriendsList.access$handleEvent((WidgetFriendsList) this.receiver, event);
        }
    }

    public WidgetFriendsList() {
        super(R.layout.widget_friends_list);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetFriendsList3.INSTANCE, null, 2, null);
        WidgetFriendsList4 widgetFriendsList4 = WidgetFriendsList4.INSTANCE;
        AppViewModelDelegates3 appViewModelDelegates3 = new AppViewModelDelegates3(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection2.getOrCreateKotlinClass(FriendsListViewModel.class), new WidgetFriendsList$appViewModels$$inlined$viewModels$1(appViewModelDelegates3), new AppViewModelDelegates5(widgetFriendsList4));
    }

    public static final /* synthetic */ void access$configureUI(WidgetFriendsList widgetFriendsList, FriendsListViewModel.ViewState viewState) {
        widgetFriendsList.configureUI(viewState);
    }

    public static final /* synthetic */ boolean access$getShowContactSyncIcon$p(WidgetFriendsList widgetFriendsList) {
        return widgetFriendsList.showContactSyncIcon;
    }

    public static final /* synthetic */ FriendsListViewModel access$getViewModel$p(WidgetFriendsList widgetFriendsList) {
        return widgetFriendsList.getViewModel();
    }

    public static final /* synthetic */ void access$handleEvent(WidgetFriendsList widgetFriendsList, FriendsListViewModel.Event event) {
        widgetFriendsList.handleEvent(event);
    }

    public static final /* synthetic */ void access$setShowContactSyncIcon$p(WidgetFriendsList widgetFriendsList, boolean z2) {
        widgetFriendsList.showContactSyncIcon = z2;
    }

    private final void configureToolbar() {
        AppFragment.bindToolbar$default(this, null, 1, null);
        setActionBarTitle(R.string.friends);
        setActionBarTitleLayoutMinimumTappableArea();
        setActionBarOptionsMenu(R.menu.menu_friends, new AnonymousClass1(), new AnonymousClass2());
    }

    private final void configureUI(FriendsListViewModel.ViewState viewState) {
        if (Intrinsics3.areEqual(viewState, FriendsListViewModel.ViewState.Uninitialized.INSTANCE)) {
            showLoadingView();
        } else if (viewState instanceof FriendsListViewModel.ViewState.Empty) {
            showEmptyView((FriendsListViewModel.ViewState.Empty) viewState);
        } else {
            if (!(viewState instanceof FriendsListViewModel.ViewState.Loaded)) {
                throw new NoWhenBranchMatchedException();
            }
            updateView((FriendsListViewModel.ViewState.Loaded) viewState);
        }
    }

    private final void displayFlipperChild(int index) {
        AppViewFlipper appViewFlipper = getBinding().c;
        Intrinsics3.checkNotNullExpressionValue(appViewFlipper, "binding.friendsListFlipper");
        appViewFlipper.setVisibility(0);
        AppViewFlipper appViewFlipper2 = getBinding().c;
        Intrinsics3.checkNotNullExpressionValue(appViewFlipper2, "binding.friendsListFlipper");
        appViewFlipper2.setDisplayedChild(index);
    }

    private final WidgetFriendsListBinding getBinding() {
        return (WidgetFriendsListBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final FriendsListViewModel getViewModel() {
        return (FriendsListViewModel) this.viewModel.getValue();
    }

    private final void handleCaptchaError(FriendsListViewModel.Event.CaptchaError event) {
        WidgetCaptchaBottomSheet.Companion.enqueue$default(WidgetCaptchaBottomSheet.INSTANCE, "Add Friend Captcha", new AnonymousClass1(event), null, CaptchaErrorBody.INSTANCE.createFromError(event.getError()), 4, null);
    }

    private final void handleEvent(FriendsListViewModel.Event event) {
        if (event instanceof FriendsListViewModel.Event.ShowToast) {
            handleShowToast((FriendsListViewModel.Event.ShowToast) event);
            return;
        }
        if (event instanceof FriendsListViewModel.Event.ShowFriendRequestErrorToast) {
            handleShowFriendRequestErrorToast((FriendsListViewModel.Event.ShowFriendRequestErrorToast) event);
        } else if (event instanceof FriendsListViewModel.Event.LaunchVoiceCall) {
            handleLaunchVoiceCall((FriendsListViewModel.Event.LaunchVoiceCall) event);
        } else {
            if (!(event instanceof FriendsListViewModel.Event.CaptchaError)) {
                throw new NoWhenBranchMatchedException();
            }
            handleCaptchaError((FriendsListViewModel.Event.CaptchaError) event);
        }
    }

    private final void handleLaunchVoiceCall(FriendsListViewModel.Event.LaunchVoiceCall event) {
        PrivateCallLauncher privateCallLauncher = this.privateCallLauncher;
        if (privateCallLauncher == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("privateCallLauncher");
        }
        privateCallLauncher.launchVoiceCall(event.getChannelId());
    }

    private final void handleShowFriendRequestErrorToast(FriendsListViewModel.Event.ShowFriendRequestErrorToast event) {
        AppToast.j(this, RestAPIAbortMessages.ResponseResolver.INSTANCE.getRelationshipResponse(getContext(), event.getAbortCode(), event.getUsername()), 0, 4);
    }

    private final void handleShowToast(FriendsListViewModel.Event.ShowToast event) {
        AppToast.i(this, event.getStringRes(), 0, 4);
    }

    private final void showEmptyView(FriendsListViewModel.ViewState.Empty viewState) {
        displayFlipperChild(1);
        this.showContactSyncIcon = viewState.getShowContactSyncIcon();
        configureToolbar();
    }

    private final void showLoadingView() {
        displayFlipperChild(2);
    }

    private final void updateView(FriendsListViewModel.ViewState.Loaded viewState) {
        displayFlipperChild(0);
        WidgetFriendsListAdapter widgetFriendsListAdapter = this.adapter;
        if (widgetFriendsListAdapter == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("adapter");
        }
        widgetFriendsListAdapter.setData(viewState.getItems());
        this.showContactSyncIcon = viewState.getShowContactSyncIcon();
        configureToolbar();
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Context contextRequireContext = requireContext();
        FragmentManager parentFragmentManager = getParentFragmentManager();
        Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
        this.privateCallLauncher = new PrivateCallLauncher(this, this, contextRequireContext, parentFragmentManager);
    }

    @Override // com.discord.widgets.tabs.OnTabSelectedListener
    public void onTabSelected() {
        configureToolbar();
        AnalyticsTracker.INSTANCE.friendsListViewed();
        setActionBarTitleAccessibilityViewFocused();
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        Fragment parentFragment = getParentFragment();
        if (!(parentFragment instanceof WidgetTabsHost)) {
            parentFragment = null;
        }
        WidgetTabsHost widgetTabsHost = (WidgetTabsHost) parentFragment;
        if (widgetTabsHost != null) {
            widgetTabsHost.registerTabSelectionListener(NavigationTab.FRIENDS, this);
        }
        getBinding().f2396b.updateView(ANALYTICS_SOURCE);
        MGRecyclerAdapter.Companion companion = MGRecyclerAdapter.INSTANCE;
        RecyclerView recyclerView = getBinding().e;
        Intrinsics3.checkNotNullExpressionValue(recyclerView, "binding.friendsListRecycler");
        WidgetFriendsListAdapter widgetFriendsListAdapter = (WidgetFriendsListAdapter) companion.configure(new WidgetFriendsListAdapter(recyclerView));
        this.adapter = widgetFriendsListAdapter;
        if (widgetFriendsListAdapter == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("adapter");
        }
        widgetFriendsListAdapter.setOnClickUserProfile(new AnonymousClass1());
        WidgetFriendsListAdapter widgetFriendsListAdapter2 = this.adapter;
        if (widgetFriendsListAdapter2 == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("adapter");
        }
        widgetFriendsListAdapter2.setOnClickPendingHeaderExpand(new AnonymousClass2());
        WidgetFriendsListAdapter widgetFriendsListAdapter3 = this.adapter;
        if (widgetFriendsListAdapter3 == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("adapter");
        }
        widgetFriendsListAdapter3.setOnClickCall(new AnonymousClass3());
        WidgetFriendsListAdapter widgetFriendsListAdapter4 = this.adapter;
        if (widgetFriendsListAdapter4 == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("adapter");
        }
        widgetFriendsListAdapter4.setOnClickChat(new AnonymousClass4());
        WidgetFriendsListAdapter widgetFriendsListAdapter5 = this.adapter;
        if (widgetFriendsListAdapter5 == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("adapter");
        }
        widgetFriendsListAdapter5.setOnClickAcceptFriend(new AnonymousClass5());
        WidgetFriendsListAdapter widgetFriendsListAdapter6 = this.adapter;
        if (widgetFriendsListAdapter6 == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("adapter");
        }
        widgetFriendsListAdapter6.setOnClickDeclineFriend(new AnonymousClass6());
        WidgetFriendsListAdapter widgetFriendsListAdapter7 = this.adapter;
        if (widgetFriendsListAdapter7 == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("adapter");
        }
        widgetFriendsListAdapter7.setOnClickContactSyncUpsell(new AnonymousClass7());
        WidgetFriendsListAdapter widgetFriendsListAdapter8 = this.adapter;
        if (widgetFriendsListAdapter8 == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("adapter");
        }
        widgetFriendsListAdapter8.setOnClickContactSyncUpsellLongClick(new AnonymousClass8());
        WidgetFriendsListAdapter widgetFriendsListAdapter9 = this.adapter;
        if (widgetFriendsListAdapter9 == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("adapter");
        }
        widgetFriendsListAdapter9.setOnClickSuggestedHeaderExpandCollapse(new AnonymousClass9());
        WidgetFriendsListAdapter widgetFriendsListAdapter10 = this.adapter;
        if (widgetFriendsListAdapter10 == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("adapter");
        }
        widgetFriendsListAdapter10.setOnClickApproveSuggestion(new AnonymousClass10());
        WidgetFriendsListAdapter widgetFriendsListAdapter11 = this.adapter;
        if (widgetFriendsListAdapter11 == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("adapter");
        }
        widgetFriendsListAdapter11.setOnClickRemoveSuggestion(new AnonymousClass11(getViewModel()));
        this.loadingAdapter = new WidgetFriendsList5();
        RecyclerView recyclerView2 = getBinding().d;
        Intrinsics3.checkNotNullExpressionValue(recyclerView2, "binding.friendsListLoading");
        WidgetFriendsList5 widgetFriendsList5 = this.loadingAdapter;
        if (widgetFriendsList5 == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("loadingAdapter");
        }
        recyclerView2.setAdapter(widgetFriendsList5);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeViewState(), this, null, 2, null), WidgetFriendsList.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(this), 62, (Object) null);
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeEvents(), this, null, 2, null), WidgetFriendsList.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass2(this), 62, (Object) null);
    }
}
