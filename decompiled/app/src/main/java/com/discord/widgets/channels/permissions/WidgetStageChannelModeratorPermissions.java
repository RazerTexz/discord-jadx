package com.discord.widgets.channels.permissions;

import android.content.Context;
import android.view.View;
import android.widget.Toast;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import b.a.d.AppViewModelDelegates3;
import b.a.d.AppViewModelDelegates5;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetStageChannelModeratorPermissionsBinding;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.widgets.channels.permissions.ConfirmRemovePermissionDialog;
import com.discord.widgets.channels.permissions.WidgetChannelSettingsAddMemberSheet;
import com.discord.widgets.channels.permissions.WidgetStageChannelModeratorPermissionsViewModel;
import d0.LazyJVM;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import d0.z.d.Reflection2;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KProperty;
import rx.Observable;

/* compiled from: WidgetStageChannelModeratorPermissions.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001f\u0010\fJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000b\u0010\fR!\u0010\u0013\u001a\u00060\rj\u0002`\u000e8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001d\u0010\u0018\u001a\u00020\u00148B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u0010\u001a\u0004\b\u0016\u0010\u0017R\u001d\u0010\u001e\u001a\u00020\u00198B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d¨\u0006 "}, d2 = {"Lcom/discord/widgets/channels/permissions/WidgetStageChannelModeratorPermissions;", "Lcom/discord/app/AppFragment;", "Lcom/discord/widgets/channels/permissions/WidgetStageChannelModeratorPermissionsViewModel$ViewState;", "viewState", "", "configureUI", "(Lcom/discord/widgets/channels/permissions/WidgetStageChannelModeratorPermissionsViewModel$ViewState;)V", "Lcom/discord/widgets/channels/permissions/PermissionOwner;", "permissionOwner", "confirmRemoveModerator", "(Lcom/discord/widgets/channels/permissions/PermissionOwner;)V", "onViewBoundOrOnResume", "()V", "", "Lcom/discord/primitives/ChannelId;", "channelId$delegate", "Lkotlin/Lazy;", "getChannelId", "()J", "channelId", "Lcom/discord/widgets/channels/permissions/WidgetStageChannelModeratorPermissionsViewModel;", "viewModel$delegate", "getViewModel", "()Lcom/discord/widgets/channels/permissions/WidgetStageChannelModeratorPermissionsViewModel;", "viewModel", "Lcom/discord/databinding/WidgetStageChannelModeratorPermissionsBinding;", "viewBinding$delegate", "Lcom/discord/utilities/viewbinding/FragmentViewBindingDelegate;", "getViewBinding", "()Lcom/discord/databinding/WidgetStageChannelModeratorPermissionsBinding;", "viewBinding", "<init>", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class WidgetStageChannelModeratorPermissions extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetStageChannelModeratorPermissions.class, "viewBinding", "getViewBinding()Lcom/discord/databinding/WidgetStageChannelModeratorPermissionsBinding;", 0)};

    /* renamed from: channelId$delegate, reason: from kotlin metadata */
    private final Lazy channelId;

    /* renamed from: viewBinding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate viewBinding;

    /* renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* compiled from: WidgetStageChannelModeratorPermissions.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.channels.permissions.WidgetStageChannelModeratorPermissions$configureUI$1, reason: invalid class name */
    public static final class AnonymousClass1 implements View.OnClickListener {
        public final /* synthetic */ WidgetStageChannelModeratorPermissionsViewModel.ViewState $viewState;

        public AnonymousClass1(WidgetStageChannelModeratorPermissionsViewModel.ViewState viewState) {
            this.$viewState = viewState;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            boolean canEditModerators = ((WidgetStageChannelModeratorPermissionsViewModel.ViewState.Valid) this.$viewState).getCanEditModerators();
            if (!canEditModerators) {
                if (canEditModerators) {
                    return;
                }
                Toast.makeText(WidgetStageChannelModeratorPermissions.this.getContext(), R.string.channel_permissions_cannot_edit_moderators, 0).show();
            } else {
                WidgetChannelSettingsAddMemberSheet.Companion companion = WidgetChannelSettingsAddMemberSheet.INSTANCE;
                FragmentManager parentFragmentManager = WidgetStageChannelModeratorPermissions.this.getParentFragmentManager();
                Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
                companion.show(parentFragmentManager, WidgetStageChannelModeratorPermissions.access$getChannelId$p(WidgetStageChannelModeratorPermissions.this));
            }
        }
    }

    /* compiled from: WidgetStageChannelModeratorPermissions.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/widgets/channels/permissions/PermissionOwner;", "p1", "", "invoke", "(Lcom/discord/widgets/channels/permissions/PermissionOwner;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.channels.permissions.WidgetStageChannelModeratorPermissions$configureUI$2, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass2 extends FunctionReferenceImpl implements Function1<PermissionOwner, Unit> {
        public AnonymousClass2(WidgetStageChannelModeratorPermissions widgetStageChannelModeratorPermissions) {
            super(1, widgetStageChannelModeratorPermissions, WidgetStageChannelModeratorPermissions.class, "confirmRemoveModerator", "confirmRemoveModerator(Lcom/discord/widgets/channels/permissions/PermissionOwner;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(PermissionOwner permissionOwner) {
            invoke2(permissionOwner);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(PermissionOwner permissionOwner) {
            Intrinsics3.checkNotNullParameter(permissionOwner, "p1");
            WidgetStageChannelModeratorPermissions.access$confirmRemoveModerator((WidgetStageChannelModeratorPermissions) this.receiver, permissionOwner);
        }
    }

    /* compiled from: WidgetStageChannelModeratorPermissions.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/widgets/channels/permissions/PermissionOwner;", "p1", "", "invoke", "(Lcom/discord/widgets/channels/permissions/PermissionOwner;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.channels.permissions.WidgetStageChannelModeratorPermissions$configureUI$3, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass3 extends FunctionReferenceImpl implements Function1<PermissionOwner, Unit> {
        public AnonymousClass3(WidgetStageChannelModeratorPermissions widgetStageChannelModeratorPermissions) {
            super(1, widgetStageChannelModeratorPermissions, WidgetStageChannelModeratorPermissions.class, "confirmRemoveModerator", "confirmRemoveModerator(Lcom/discord/widgets/channels/permissions/PermissionOwner;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(PermissionOwner permissionOwner) {
            invoke2(permissionOwner);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(PermissionOwner permissionOwner) {
            Intrinsics3.checkNotNullParameter(permissionOwner, "p1");
            WidgetStageChannelModeratorPermissions.access$confirmRemoveModerator((WidgetStageChannelModeratorPermissions) this.receiver, permissionOwner);
        }
    }

    /* compiled from: WidgetStageChannelModeratorPermissions.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/widgets/channels/permissions/WidgetStageChannelModeratorPermissionsViewModel$ViewState;", "p1", "", "invoke", "(Lcom/discord/widgets/channels/permissions/WidgetStageChannelModeratorPermissionsViewModel$ViewState;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.channels.permissions.WidgetStageChannelModeratorPermissions$onViewBoundOrOnResume$1, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<WidgetStageChannelModeratorPermissionsViewModel.ViewState, Unit> {
        public AnonymousClass1(WidgetStageChannelModeratorPermissions widgetStageChannelModeratorPermissions) {
            super(1, widgetStageChannelModeratorPermissions, WidgetStageChannelModeratorPermissions.class, "configureUI", "configureUI(Lcom/discord/widgets/channels/permissions/WidgetStageChannelModeratorPermissionsViewModel$ViewState;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(WidgetStageChannelModeratorPermissionsViewModel.ViewState viewState) {
            invoke2(viewState);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(WidgetStageChannelModeratorPermissionsViewModel.ViewState viewState) {
            Intrinsics3.checkNotNullParameter(viewState, "p1");
            WidgetStageChannelModeratorPermissions.access$configureUI((WidgetStageChannelModeratorPermissions) this.receiver, viewState);
        }
    }

    public WidgetStageChannelModeratorPermissions() {
        super(R.layout.widget_stage_channel_moderator_permissions);
        WidgetStageChannelModeratorPermissions4 widgetStageChannelModeratorPermissions4 = new WidgetStageChannelModeratorPermissions4(this);
        AppViewModelDelegates3 appViewModelDelegates3 = new AppViewModelDelegates3(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection2.getOrCreateKotlinClass(WidgetStageChannelModeratorPermissionsViewModel.class), new WidgetStageChannelModeratorPermissions$appViewModels$$inlined$viewModels$1(appViewModelDelegates3), new AppViewModelDelegates5(widgetStageChannelModeratorPermissions4));
        this.channelId = LazyJVM.lazy(new WidgetStageChannelModeratorPermissions2(this));
        this.viewBinding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetStageChannelModeratorPermissions3.INSTANCE, null, 2, null);
    }

    public static final /* synthetic */ void access$configureUI(WidgetStageChannelModeratorPermissions widgetStageChannelModeratorPermissions, WidgetStageChannelModeratorPermissionsViewModel.ViewState viewState) {
        widgetStageChannelModeratorPermissions.configureUI(viewState);
    }

    public static final /* synthetic */ void access$confirmRemoveModerator(WidgetStageChannelModeratorPermissions widgetStageChannelModeratorPermissions, PermissionOwner permissionOwner) {
        widgetStageChannelModeratorPermissions.confirmRemoveModerator(permissionOwner);
    }

    public static final /* synthetic */ long access$getChannelId$p(WidgetStageChannelModeratorPermissions widgetStageChannelModeratorPermissions) {
        return widgetStageChannelModeratorPermissions.getChannelId();
    }

    private final void configureUI(WidgetStageChannelModeratorPermissionsViewModel.ViewState viewState) {
        if (viewState instanceof WidgetStageChannelModeratorPermissionsViewModel.ViewState.Valid) {
            AddPermissionOwnerView addPermissionOwnerView = getViewBinding().f2652b;
            Intrinsics3.checkNotNullExpressionValue(addPermissionOwnerView, "viewBinding.addPermissionOwnerButton");
            WidgetStageChannelModeratorPermissionsViewModel.ViewState.Valid valid = (WidgetStageChannelModeratorPermissionsViewModel.ViewState.Valid) viewState;
            ViewExtensions.setEnabledAlpha$default(addPermissionOwnerView, valid.getCanEditModerators(), 0.0f, 2, null);
            getViewBinding().f2652b.setOnClickListener(new AnonymousClass1(viewState));
            getViewBinding().d.setData(valid.getRoleItems(), new AnonymousClass2(this));
            getViewBinding().c.setData(valid.getMemberItems(), new AnonymousClass3(this));
        }
    }

    private final void confirmRemoveModerator(PermissionOwner permissionOwner) {
        ConfirmRemovePermissionDialog.Companion companion = ConfirmRemovePermissionDialog.INSTANCE;
        FragmentManager parentFragmentManager = getParentFragmentManager();
        Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
        companion.show(permissionOwner, getChannelId(), parentFragmentManager);
    }

    private final long getChannelId() {
        return ((Number) this.channelId.getValue()).longValue();
    }

    private final WidgetStageChannelModeratorPermissionsBinding getViewBinding() {
        return (WidgetStageChannelModeratorPermissionsBinding) this.viewBinding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final WidgetStageChannelModeratorPermissionsViewModel getViewModel() {
        return (WidgetStageChannelModeratorPermissionsViewModel) this.viewModel.getValue();
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        Observable<WidgetStageChannelModeratorPermissionsViewModel.ViewState> observableR = getViewModel().observeViewState().r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "viewModel\n        .obser…  .distinctUntilChanged()");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(observableR, this, null, 2, null), WidgetStageChannelModeratorPermissions.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(this), 62, (Object) null);
    }
}
