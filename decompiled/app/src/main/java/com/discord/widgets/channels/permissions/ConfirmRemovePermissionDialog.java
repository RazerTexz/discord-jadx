package com.discord.widgets.channels.permissions;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import b.a.d.AppViewModelDelegates3;
import b.a.d.AppViewModelDelegates5;
import b.a.k.FormatUtils;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.app.AppDialog;
import com.discord.databinding.ConfirmRemovePermissionDialogBinding;
import com.discord.utilities.KotlinExtensions;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.widgets.channels.permissions.ConfirmRemovePermissionDialogViewModel;
import com.discord.widgets.channels.permissions.PermissionOwner;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import d0.z.d.Reflection2;
import java.io.Serializable;
import java.util.Objects;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;

/* compiled from: ConfirmRemovePermissionDialog.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB\u0007¢\u0006\u0004\b\u001c\u0010\u000fJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\b\u0010\tJ\u0013\u0010\f\u001a\u00060\nj\u0002`\u000bH\u0002¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000e\u0010\u000fR\u001d\u0010\u0015\u001a\u00020\u00108B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001d\u0010\u001b\u001a\u00020\u00168B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a¨\u0006\u001e"}, d2 = {"Lcom/discord/widgets/channels/permissions/ConfirmRemovePermissionDialog;", "Lcom/discord/app/AppDialog;", "Lcom/discord/widgets/channels/permissions/ConfirmRemovePermissionDialogViewModel$ViewState;", "viewState", "", "configureUI", "(Lcom/discord/widgets/channels/permissions/ConfirmRemovePermissionDialogViewModel$ViewState;)V", "Lcom/discord/widgets/channels/permissions/PermissionOwner;", "getPermissionOwnerFromArgs", "()Lcom/discord/widgets/channels/permissions/PermissionOwner;", "", "Lcom/discord/primitives/ChannelId;", "getChannelIdFromArgs", "()J", "onResume", "()V", "Lcom/discord/databinding/ConfirmRemovePermissionDialogBinding;", "binding$delegate", "Lcom/discord/utilities/viewbinding/FragmentViewBindingDelegate;", "getBinding", "()Lcom/discord/databinding/ConfirmRemovePermissionDialogBinding;", "binding", "Lcom/discord/widgets/channels/permissions/ConfirmRemovePermissionDialogViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "getViewModel", "()Lcom/discord/widgets/channels/permissions/ConfirmRemovePermissionDialogViewModel;", "viewModel", "<init>", "Companion", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class ConfirmRemovePermissionDialog extends AppDialog {
    private static final String ARG_PERMISSION_OWNER = "ARG_PERMISSION_OWNER";

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(ConfirmRemovePermissionDialog.class, "binding", "getBinding()Lcom/discord/databinding/ConfirmRemovePermissionDialogBinding;", 0)};

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* compiled from: ConfirmRemovePermissionDialog.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000f\u0010\u0010J)\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\n\u0010\u0006\u001a\u00060\u0004j\u0002`\u00052\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\n\u0010\u000bR\u0016\u0010\r\u001a\u00020\f8\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\r\u0010\u000e¨\u0006\u0011"}, d2 = {"Lcom/discord/widgets/channels/permissions/ConfirmRemovePermissionDialog$Companion;", "", "Lcom/discord/widgets/channels/permissions/PermissionOwner;", "permissionOwner", "", "Lcom/discord/primitives/ChannelId;", "channelId", "Landroidx/fragment/app/FragmentManager;", "fragmentManager", "", "show", "(Lcom/discord/widgets/channels/permissions/PermissionOwner;JLandroidx/fragment/app/FragmentManager;)V", "", ConfirmRemovePermissionDialog.ARG_PERMISSION_OWNER, "Ljava/lang/String;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public final void show(PermissionOwner permissionOwner, long channelId, FragmentManager fragmentManager) {
            Intrinsics3.checkNotNullParameter(permissionOwner, "permissionOwner");
            Intrinsics3.checkNotNullParameter(fragmentManager, "fragmentManager");
            ConfirmRemovePermissionDialog confirmRemovePermissionDialog = new ConfirmRemovePermissionDialog();
            Bundle bundle = new Bundle();
            bundle.putSerializable(ConfirmRemovePermissionDialog.ARG_PERMISSION_OWNER, permissionOwner);
            bundle.putLong("com.discord.intent.extra.EXTRA_CHANNEL_ID", channelId);
            confirmRemovePermissionDialog.setArguments(bundle);
            confirmRemovePermissionDialog.show(fragmentManager, ConfirmRemovePermissionDialog.class.getSimpleName());
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: ConfirmRemovePermissionDialog.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/widgets/channels/permissions/ConfirmRemovePermissionDialogViewModel$ViewState;", "viewState", "", "invoke", "(Lcom/discord/widgets/channels/permissions/ConfirmRemovePermissionDialogViewModel$ViewState;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.channels.permissions.ConfirmRemovePermissionDialog$onResume$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<ConfirmRemovePermissionDialogViewModel.ViewState, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ConfirmRemovePermissionDialogViewModel.ViewState viewState) {
            invoke2(viewState);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ConfirmRemovePermissionDialogViewModel.ViewState viewState) {
            Intrinsics3.checkNotNullParameter(viewState, "viewState");
            ConfirmRemovePermissionDialog.access$configureUI(ConfirmRemovePermissionDialog.this, viewState);
        }
    }

    /* compiled from: ConfirmRemovePermissionDialog.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.channels.permissions.ConfirmRemovePermissionDialog$onResume$2, reason: invalid class name */
    public static final class AnonymousClass2 implements View.OnClickListener {
        public AnonymousClass2() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            ConfirmRemovePermissionDialog.access$getViewModel$p(ConfirmRemovePermissionDialog.this).submit();
        }
    }

    /* compiled from: ConfirmRemovePermissionDialog.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.channels.permissions.ConfirmRemovePermissionDialog$onResume$3, reason: invalid class name */
    public static final class AnonymousClass3 implements View.OnClickListener {
        public AnonymousClass3() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            ConfirmRemovePermissionDialog.this.dismiss();
        }
    }

    public ConfirmRemovePermissionDialog() {
        super(R.layout.confirm_remove_permission_dialog);
        ConfirmRemovePermissionDialog3 confirmRemovePermissionDialog3 = new ConfirmRemovePermissionDialog3(this);
        AppViewModelDelegates3 appViewModelDelegates3 = new AppViewModelDelegates3(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection2.getOrCreateKotlinClass(ConfirmRemovePermissionDialogViewModel.class), new ConfirmRemovePermissionDialog$appViewModels$$inlined$viewModels$1(appViewModelDelegates3), new AppViewModelDelegates5(confirmRemovePermissionDialog3));
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, ConfirmRemovePermissionDialog2.INSTANCE, null, 2, null);
    }

    public static final /* synthetic */ void access$configureUI(ConfirmRemovePermissionDialog confirmRemovePermissionDialog, ConfirmRemovePermissionDialogViewModel.ViewState viewState) {
        confirmRemovePermissionDialog.configureUI(viewState);
    }

    public static final /* synthetic */ long access$getChannelIdFromArgs(ConfirmRemovePermissionDialog confirmRemovePermissionDialog) {
        return confirmRemovePermissionDialog.getChannelIdFromArgs();
    }

    public static final /* synthetic */ PermissionOwner access$getPermissionOwnerFromArgs(ConfirmRemovePermissionDialog confirmRemovePermissionDialog) {
        return confirmRemovePermissionDialog.getPermissionOwnerFromArgs();
    }

    public static final /* synthetic */ ConfirmRemovePermissionDialogViewModel access$getViewModel$p(ConfirmRemovePermissionDialog confirmRemovePermissionDialog) {
        return confirmRemovePermissionDialog.getViewModel();
    }

    private final void configureUI(ConfirmRemovePermissionDialogViewModel.ViewState viewState) {
        Unit unit;
        if (viewState instanceof ConfirmRemovePermissionDialogViewModel.ViewState.Default) {
            getBinding().d.setIsLoading(((ConfirmRemovePermissionDialogViewModel.ViewState.Default) viewState).isSubmitting());
            unit = Unit.a;
        } else {
            if (!Intrinsics3.areEqual(viewState, ConfirmRemovePermissionDialogViewModel.ViewState.Complete.INSTANCE)) {
                throw new NoWhenBranchMatchedException();
            }
            dismiss();
            unit = Unit.a;
        }
        KotlinExtensions.getExhaustive(unit);
    }

    private final ConfirmRemovePermissionDialogBinding getBinding() {
        return (ConfirmRemovePermissionDialogBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final long getChannelIdFromArgs() {
        return requireArguments().getLong("com.discord.intent.extra.EXTRA_CHANNEL_ID");
    }

    private final PermissionOwner getPermissionOwnerFromArgs() {
        Serializable serializable = requireArguments().getSerializable(ARG_PERMISSION_OWNER);
        Objects.requireNonNull(serializable, "null cannot be cast to non-null type com.discord.widgets.channels.permissions.PermissionOwner");
        return (PermissionOwner) serializable;
    }

    private final ConfirmRemovePermissionDialogViewModel getViewModel() {
        return (ConfirmRemovePermissionDialogViewModel) this.viewModel.getValue();
    }

    @Override // com.discord.app.AppDialog, androidx.fragment.app.Fragment
    public void onResume() {
        String username;
        super.onResume();
        requireDialog().setCanceledOnTouchOutside(true);
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeViewState(), this, null, 2, null), ConfirmRemovePermissionDialog.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(), 62, (Object) null);
        PermissionOwner permissionOwnerFromArgs = getPermissionOwnerFromArgs();
        if (permissionOwnerFromArgs instanceof PermissionOwner.Role) {
            username = ((PermissionOwner.Role) permissionOwnerFromArgs).getRole().getName();
        } else {
            if (!(permissionOwnerFromArgs instanceof PermissionOwner.Member)) {
                throw new NoWhenBranchMatchedException();
            }
            PermissionOwner.Member member = (PermissionOwner.Member) permissionOwnerFromArgs;
            String nickname = member.getNickname();
            username = nickname != null ? nickname : member.getUser().getUsername();
        }
        TextView textView = getBinding().f2091b;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.body");
        FormatUtils.n(textView, R.string.settings_permissions_delete_body, new Object[]{username}, null, 4);
        getBinding().d.setOnClickListener(new AnonymousClass2());
        getBinding().c.setOnClickListener(new AnonymousClass3());
    }
}
