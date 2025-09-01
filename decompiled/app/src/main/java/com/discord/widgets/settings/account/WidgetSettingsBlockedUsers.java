package com.discord.widgets.settings.account;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.recyclerview.widget.RecyclerView;
import b.a.d.AppScreen2;
import b.a.d.AppToast;
import b.a.d.AppViewModelDelegates3;
import b.a.d.AppViewModelDelegates5;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.app.AppFragment;
import com.discord.app.AppViewFlipper;
import com.discord.databinding.WidgetSettingsBlockedUsersBinding;
import com.discord.models.user.User;
import com.discord.utilities.mg_recycler.MGRecyclerAdapter;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.widgets.settings.account.WidgetSettingsBlockedUsersViewModel;
import com.discord.widgets.user.usersheet.WidgetUserSheet;
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
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;

/* compiled from: WidgetSettingsBlockedUsers.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 *2\u00020\u0001:\u0001*B\u0007¢\u0006\u0004\b)\u0010\u0012J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\f\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0013\u0010\u0012J!\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u00142\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0016¢\u0006\u0004\b\u0018\u0010\u0019R\u001d\u0010\u001f\u001a\u00020\u001a8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u001d\u0010%\u001a\u00020 8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$R\u0016\u0010'\u001a\u00020&8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b'\u0010(¨\u0006+"}, d2 = {"Lcom/discord/widgets/settings/account/WidgetSettingsBlockedUsers;", "Lcom/discord/app/AppFragment;", "Lcom/discord/widgets/settings/account/WidgetSettingsBlockedUsersViewModel$ViewState;", "viewState", "", "configureUI", "(Lcom/discord/widgets/settings/account/WidgetSettingsBlockedUsersViewModel$ViewState;)V", "Lcom/discord/widgets/settings/account/WidgetSettingsBlockedUsersViewModel$Event;", "event", "handleEvent", "(Lcom/discord/widgets/settings/account/WidgetSettingsBlockedUsersViewModel$Event;)V", "Lcom/discord/widgets/settings/account/WidgetSettingsBlockedUsersViewModel$Event$ShowToast;", "handleShowToast", "(Lcom/discord/widgets/settings/account/WidgetSettingsBlockedUsersViewModel$Event$ShowToast;)V", "Lcom/discord/widgets/settings/account/WidgetSettingsBlockedUsersViewModel$ViewState$Loaded;", "showBlockedUsers", "(Lcom/discord/widgets/settings/account/WidgetSettingsBlockedUsersViewModel$ViewState$Loaded;)V", "showEmptyView", "()V", "onViewBoundOrOnResume", "Landroid/view/View;", "view", "Landroid/os/Bundle;", "savedInstanceState", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "Lcom/discord/widgets/settings/account/WidgetSettingsBlockedUsersViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "getViewModel", "()Lcom/discord/widgets/settings/account/WidgetSettingsBlockedUsersViewModel;", "viewModel", "Lcom/discord/databinding/WidgetSettingsBlockedUsersBinding;", "binding$delegate", "Lcom/discord/utilities/viewbinding/FragmentViewBindingDelegate;", "getBinding", "()Lcom/discord/databinding/WidgetSettingsBlockedUsersBinding;", "binding", "Lcom/discord/widgets/settings/account/WidgetSettingsBlockedUsersAdapter;", "adapter", "Lcom/discord/widgets/settings/account/WidgetSettingsBlockedUsersAdapter;", "<init>", "Companion", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class WidgetSettingsBlockedUsers extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetSettingsBlockedUsers.class, "binding", "getBinding()Lcom/discord/databinding/WidgetSettingsBlockedUsersBinding;", 0)};

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final int VIEW_INDEX_EMPTY = 1;
    private static final int VIEW_INDEX_RECYCLER = 0;
    private WidgetSettingsBlockedUsersAdapter adapter;

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* compiled from: WidgetSettingsBlockedUsers.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\b\u001a\u00020\u00078\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0016\u0010\n\u001a\u00020\u00078\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\n\u0010\t¨\u0006\r"}, d2 = {"Lcom/discord/widgets/settings/account/WidgetSettingsBlockedUsers$Companion;", "", "Landroid/content/Context;", "context", "", "launch", "(Landroid/content/Context;)V", "", "VIEW_INDEX_EMPTY", "I", "VIEW_INDEX_RECYCLER", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public final void launch(Context context) {
            Intrinsics3.checkNotNullParameter(context, "context");
            AppScreen2.e(context, WidgetSettingsBlockedUsers.class, null, 4);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetSettingsBlockedUsers.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/widgets/settings/account/WidgetSettingsBlockedUsersViewModel$ViewState;", "p1", "", "invoke", "(Lcom/discord/widgets/settings/account/WidgetSettingsBlockedUsersViewModel$ViewState;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.settings.account.WidgetSettingsBlockedUsers$onViewBoundOrOnResume$1, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<WidgetSettingsBlockedUsersViewModel.ViewState, Unit> {
        public AnonymousClass1(WidgetSettingsBlockedUsers widgetSettingsBlockedUsers) {
            super(1, widgetSettingsBlockedUsers, WidgetSettingsBlockedUsers.class, "configureUI", "configureUI(Lcom/discord/widgets/settings/account/WidgetSettingsBlockedUsersViewModel$ViewState;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(WidgetSettingsBlockedUsersViewModel.ViewState viewState) {
            invoke2(viewState);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(WidgetSettingsBlockedUsersViewModel.ViewState viewState) {
            Intrinsics3.checkNotNullParameter(viewState, "p1");
            WidgetSettingsBlockedUsers.access$configureUI((WidgetSettingsBlockedUsers) this.receiver, viewState);
        }
    }

    /* compiled from: WidgetSettingsBlockedUsers.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/widgets/settings/account/WidgetSettingsBlockedUsersViewModel$Event;", "p1", "", "invoke", "(Lcom/discord/widgets/settings/account/WidgetSettingsBlockedUsersViewModel$Event;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.settings.account.WidgetSettingsBlockedUsers$onViewBoundOrOnResume$2, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass2 extends FunctionReferenceImpl implements Function1<WidgetSettingsBlockedUsersViewModel.Event, Unit> {
        public AnonymousClass2(WidgetSettingsBlockedUsers widgetSettingsBlockedUsers) {
            super(1, widgetSettingsBlockedUsers, WidgetSettingsBlockedUsers.class, "handleEvent", "handleEvent(Lcom/discord/widgets/settings/account/WidgetSettingsBlockedUsersViewModel$Event;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(WidgetSettingsBlockedUsersViewModel.Event event) {
            invoke2(event);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(WidgetSettingsBlockedUsersViewModel.Event event) {
            Intrinsics3.checkNotNullParameter(event, "p1");
            WidgetSettingsBlockedUsers.access$handleEvent((WidgetSettingsBlockedUsers) this.receiver, event);
        }
    }

    /* compiled from: WidgetSettingsBlockedUsers.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/models/user/User;", "user", "", "invoke", "(Lcom/discord/models/user/User;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.settings.account.WidgetSettingsBlockedUsers$onViewCreated$2, reason: invalid class name */
    public static final class AnonymousClass2 extends Lambda implements Function1<User, Unit> {
        public AnonymousClass2() {
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
            WidgetSettingsBlockedUsers.access$getViewModel$p(WidgetSettingsBlockedUsers.this).onClickUnblock(user.getId());
        }
    }

    /* compiled from: WidgetSettingsBlockedUsers.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/models/user/User;", "user", "", "invoke", "(Lcom/discord/models/user/User;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.settings.account.WidgetSettingsBlockedUsers$onViewCreated$3, reason: invalid class name */
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
            WidgetUserSheet.Companion companion = WidgetUserSheet.INSTANCE;
            long id2 = user.getId();
            FragmentManager parentFragmentManager = WidgetSettingsBlockedUsers.this.getParentFragmentManager();
            Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
            WidgetUserSheet.Companion.show$default(companion, id2, null, parentFragmentManager, null, null, null, null, 122, null);
        }
    }

    public WidgetSettingsBlockedUsers() {
        super(R.layout.widget_settings_blocked_users);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetSettingsBlockedUsers2.INSTANCE, null, 2, null);
        WidgetSettingsBlockedUsers3 widgetSettingsBlockedUsers3 = WidgetSettingsBlockedUsers3.INSTANCE;
        AppViewModelDelegates3 appViewModelDelegates3 = new AppViewModelDelegates3(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection2.getOrCreateKotlinClass(WidgetSettingsBlockedUsersViewModel.class), new WidgetSettingsBlockedUsers$appViewModels$$inlined$viewModels$1(appViewModelDelegates3), new AppViewModelDelegates5(widgetSettingsBlockedUsers3));
    }

    public static final /* synthetic */ void access$configureUI(WidgetSettingsBlockedUsers widgetSettingsBlockedUsers, WidgetSettingsBlockedUsersViewModel.ViewState viewState) {
        widgetSettingsBlockedUsers.configureUI(viewState);
    }

    public static final /* synthetic */ WidgetSettingsBlockedUsersViewModel access$getViewModel$p(WidgetSettingsBlockedUsers widgetSettingsBlockedUsers) {
        return widgetSettingsBlockedUsers.getViewModel();
    }

    public static final /* synthetic */ void access$handleEvent(WidgetSettingsBlockedUsers widgetSettingsBlockedUsers, WidgetSettingsBlockedUsersViewModel.Event event) {
        widgetSettingsBlockedUsers.handleEvent(event);
    }

    private final void configureUI(WidgetSettingsBlockedUsersViewModel.ViewState viewState) {
        if (Intrinsics3.areEqual(viewState, WidgetSettingsBlockedUsersViewModel.ViewState.Uninitialized.INSTANCE)) {
            return;
        }
        if (Intrinsics3.areEqual(viewState, WidgetSettingsBlockedUsersViewModel.ViewState.Empty.INSTANCE)) {
            showEmptyView();
        } else {
            if (!(viewState instanceof WidgetSettingsBlockedUsersViewModel.ViewState.Loaded)) {
                throw new NoWhenBranchMatchedException();
            }
            showBlockedUsers((WidgetSettingsBlockedUsersViewModel.ViewState.Loaded) viewState);
        }
    }

    private final WidgetSettingsBlockedUsersBinding getBinding() {
        return (WidgetSettingsBlockedUsersBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final WidgetSettingsBlockedUsersViewModel getViewModel() {
        return (WidgetSettingsBlockedUsersViewModel) this.viewModel.getValue();
    }

    private final void handleEvent(WidgetSettingsBlockedUsersViewModel.Event event) {
        if (!(event instanceof WidgetSettingsBlockedUsersViewModel.Event.ShowToast)) {
            throw new NoWhenBranchMatchedException();
        }
        handleShowToast((WidgetSettingsBlockedUsersViewModel.Event.ShowToast) event);
    }

    private final void handleShowToast(WidgetSettingsBlockedUsersViewModel.Event.ShowToast event) {
        AppToast.i(this, event.getStringRes(), 0, 4);
    }

    private final void showBlockedUsers(WidgetSettingsBlockedUsersViewModel.ViewState.Loaded viewState) {
        AppViewFlipper appViewFlipper = getBinding().f2611b;
        Intrinsics3.checkNotNullExpressionValue(appViewFlipper, "binding.blockedUsersFlipper");
        appViewFlipper.setDisplayedChild(0);
        WidgetSettingsBlockedUsersAdapter widgetSettingsBlockedUsersAdapter = this.adapter;
        if (widgetSettingsBlockedUsersAdapter == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("adapter");
        }
        widgetSettingsBlockedUsersAdapter.setData(viewState.getItems());
    }

    private final void showEmptyView() {
        AppViewFlipper appViewFlipper = getBinding().f2611b;
        Intrinsics3.checkNotNullExpressionValue(appViewFlipper, "binding.blockedUsersFlipper");
        appViewFlipper.setDisplayedChild(1);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeViewState(), this, null, 2, null), WidgetSettingsBlockedUsers.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(this), 62, (Object) null);
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeEvents(), this, null, 2, null), WidgetSettingsBlockedUsers.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass2(this), 62, (Object) null);
    }

    @Override // com.discord.app.AppFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        setActionBarTitle(R.string.user_settings_blocked_users);
        AppFragment.setActionBarDisplayHomeAsUpEnabled$default(this, false, 1, null);
        RecyclerView recyclerView = getBinding().c;
        MGRecyclerAdapter.Companion companion = MGRecyclerAdapter.INSTANCE;
        Intrinsics3.checkNotNullExpressionValue(recyclerView, "it");
        WidgetSettingsBlockedUsersAdapter widgetSettingsBlockedUsersAdapter = (WidgetSettingsBlockedUsersAdapter) companion.configure(new WidgetSettingsBlockedUsersAdapter(recyclerView));
        this.adapter = widgetSettingsBlockedUsersAdapter;
        if (widgetSettingsBlockedUsersAdapter == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("adapter");
        }
        widgetSettingsBlockedUsersAdapter.setOnClickUnblock(new AnonymousClass2());
        WidgetSettingsBlockedUsersAdapter widgetSettingsBlockedUsersAdapter2 = this.adapter;
        if (widgetSettingsBlockedUsersAdapter2 == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("adapter");
        }
        widgetSettingsBlockedUsersAdapter2.setOnClickUserProfile(new AnonymousClass3());
    }
}
