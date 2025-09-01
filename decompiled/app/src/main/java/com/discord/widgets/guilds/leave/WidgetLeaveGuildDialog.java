package com.discord.widgets.guilds.leave;

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
import com.discord.databinding.LeaveGuildDialogBinding;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.widgets.guilds.leave.LeaveGuildDialogViewModel;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import d0.z.d.Reflection2;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;

/* compiled from: WidgetLeaveGuildDialog.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB\u0007¢\u0006\u0004\b\u0019\u0010\fJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000b\u0010\fR\u001d\u0010\u0012\u001a\u00020\r8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001d\u0010\u0018\u001a\u00020\u00138B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u001b"}, d2 = {"Lcom/discord/widgets/guilds/leave/WidgetLeaveGuildDialog;", "Lcom/discord/app/AppDialog;", "Lcom/discord/widgets/guilds/leave/LeaveGuildDialogViewModel$ViewState;", "viewState", "", "configureUI", "(Lcom/discord/widgets/guilds/leave/LeaveGuildDialogViewModel$ViewState;)V", "Lcom/discord/widgets/guilds/leave/LeaveGuildDialogViewModel$Event;", "event", "handleEvent", "(Lcom/discord/widgets/guilds/leave/LeaveGuildDialogViewModel$Event;)V", "onResume", "()V", "Lcom/discord/widgets/guilds/leave/LeaveGuildDialogViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "getViewModel", "()Lcom/discord/widgets/guilds/leave/LeaveGuildDialogViewModel;", "viewModel", "Lcom/discord/databinding/LeaveGuildDialogBinding;", "binding$delegate", "Lcom/discord/utilities/viewbinding/FragmentViewBindingDelegate;", "getBinding", "()Lcom/discord/databinding/LeaveGuildDialogBinding;", "binding", "<init>", "Companion", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class WidgetLeaveGuildDialog extends AppDialog {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetLeaveGuildDialog.class, "binding", "getBinding()Lcom/discord/databinding/LeaveGuildDialogBinding;", 0)};

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* compiled from: WidgetLeaveGuildDialog.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\n\u0010\u000bJ!\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\n\u0010\u0006\u001a\u00060\u0004j\u0002`\u0005¢\u0006\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lcom/discord/widgets/guilds/leave/WidgetLeaveGuildDialog$Companion;", "", "Landroidx/fragment/app/FragmentManager;", "fragmentManager", "", "Lcom/discord/primitives/GuildId;", "guildId", "", "show", "(Landroidx/fragment/app/FragmentManager;J)V", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public final void show(FragmentManager fragmentManager, long guildId) {
            Intrinsics3.checkNotNullParameter(fragmentManager, "fragmentManager");
            Bundle bundle = new Bundle();
            bundle.putLong("com.discord.intent.extra.EXTRA_GUILD_ID", guildId);
            WidgetLeaveGuildDialog widgetLeaveGuildDialog = new WidgetLeaveGuildDialog();
            widgetLeaveGuildDialog.setArguments(bundle);
            widgetLeaveGuildDialog.show(fragmentManager, WidgetLeaveGuildDialog.class.getSimpleName());
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetLeaveGuildDialog.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.guilds.leave.WidgetLeaveGuildDialog$onResume$1, reason: invalid class name */
    public static final class AnonymousClass1 implements View.OnClickListener {
        public AnonymousClass1() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetLeaveGuildDialog.access$getViewModel$p(WidgetLeaveGuildDialog.this).leaveGuild();
        }
    }

    /* compiled from: WidgetLeaveGuildDialog.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.guilds.leave.WidgetLeaveGuildDialog$onResume$2, reason: invalid class name */
    public static final class AnonymousClass2 implements View.OnClickListener {
        public AnonymousClass2() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetLeaveGuildDialog.this.dismiss();
        }
    }

    /* compiled from: WidgetLeaveGuildDialog.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/widgets/guilds/leave/LeaveGuildDialogViewModel$ViewState;", "viewState", "", "invoke", "(Lcom/discord/widgets/guilds/leave/LeaveGuildDialogViewModel$ViewState;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.guilds.leave.WidgetLeaveGuildDialog$onResume$3, reason: invalid class name */
    public static final class AnonymousClass3 extends Lambda implements Function1<LeaveGuildDialogViewModel.ViewState, Unit> {
        public AnonymousClass3() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(LeaveGuildDialogViewModel.ViewState viewState) {
            invoke2(viewState);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(LeaveGuildDialogViewModel.ViewState viewState) {
            Intrinsics3.checkNotNullParameter(viewState, "viewState");
            WidgetLeaveGuildDialog.access$configureUI(WidgetLeaveGuildDialog.this, viewState);
        }
    }

    /* compiled from: WidgetLeaveGuildDialog.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/widgets/guilds/leave/LeaveGuildDialogViewModel$Event;", "event", "", "invoke", "(Lcom/discord/widgets/guilds/leave/LeaveGuildDialogViewModel$Event;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.guilds.leave.WidgetLeaveGuildDialog$onResume$4, reason: invalid class name */
    public static final class AnonymousClass4 extends Lambda implements Function1<LeaveGuildDialogViewModel.Event, Unit> {
        public AnonymousClass4() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(LeaveGuildDialogViewModel.Event event) {
            invoke2(event);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(LeaveGuildDialogViewModel.Event event) {
            Intrinsics3.checkNotNullParameter(event, "event");
            WidgetLeaveGuildDialog.access$handleEvent(WidgetLeaveGuildDialog.this, event);
        }
    }

    public WidgetLeaveGuildDialog() {
        super(R.layout.leave_guild_dialog);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetLeaveGuildDialog2.INSTANCE, null, 2, null);
        WidgetLeaveGuildDialog3 widgetLeaveGuildDialog3 = new WidgetLeaveGuildDialog3(this);
        AppViewModelDelegates3 appViewModelDelegates3 = new AppViewModelDelegates3(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection2.getOrCreateKotlinClass(LeaveGuildDialogViewModel.class), new WidgetLeaveGuildDialog$appViewModels$$inlined$viewModels$1(appViewModelDelegates3), new AppViewModelDelegates5(widgetLeaveGuildDialog3));
    }

    public static final /* synthetic */ void access$configureUI(WidgetLeaveGuildDialog widgetLeaveGuildDialog, LeaveGuildDialogViewModel.ViewState viewState) {
        widgetLeaveGuildDialog.configureUI(viewState);
    }

    public static final /* synthetic */ Bundle access$getArgumentsOrDefault$p(WidgetLeaveGuildDialog widgetLeaveGuildDialog) {
        return widgetLeaveGuildDialog.getArgumentsOrDefault();
    }

    public static final /* synthetic */ LeaveGuildDialogViewModel access$getViewModel$p(WidgetLeaveGuildDialog widgetLeaveGuildDialog) {
        return widgetLeaveGuildDialog.getViewModel();
    }

    public static final /* synthetic */ void access$handleEvent(WidgetLeaveGuildDialog widgetLeaveGuildDialog, LeaveGuildDialogViewModel.Event event) {
        widgetLeaveGuildDialog.handleEvent(event);
    }

    private final void configureUI(LeaveGuildDialogViewModel.ViewState viewState) {
        if (!(viewState instanceof LeaveGuildDialogViewModel.ViewState.Valid)) {
            if (Intrinsics3.areEqual(viewState, LeaveGuildDialogViewModel.ViewState.Invalid.INSTANCE)) {
                dismiss();
                return;
            }
            return;
        }
        TextView textView = getBinding().e;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.leaveGuildDialogHeader");
        LeaveGuildDialogViewModel.ViewState.Valid valid = (LeaveGuildDialogViewModel.ViewState.Valid) viewState;
        FormatUtils.n(textView, R.string.leave_server_title, new Object[]{valid.getGuild().getName()}, null, 4);
        TextView textView2 = getBinding().d;
        Intrinsics3.checkNotNullExpressionValue(textView2, "binding.leaveGuildDialogBody");
        FormatUtils.n(textView2, valid.getGuild().isHub() ? R.string.leave_hub_body : R.string.leave_server_body_mobile, new Object[]{valid.getGuild().getName()}, null, 4);
        getBinding().c.setText(getString(valid.getGuild().isHub() ? R.string.leave_hub : R.string.leave_server));
        getBinding().c.setIsLoading(valid.isLoading());
    }

    private final LeaveGuildDialogBinding getBinding() {
        return (LeaveGuildDialogBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final LeaveGuildDialogViewModel getViewModel() {
        return (LeaveGuildDialogViewModel) this.viewModel.getValue();
    }

    private final void handleEvent(LeaveGuildDialogViewModel.Event event) {
        if (Intrinsics3.areEqual(event, LeaveGuildDialogViewModel.Event.Dismiss.INSTANCE)) {
            dismiss();
        }
    }

    @Override // com.discord.app.AppDialog, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        requireDialog().setCanceledOnTouchOutside(true);
        getBinding().c.setOnClickListener(new AnonymousClass1());
        getBinding().f2128b.setOnClickListener(new AnonymousClass2());
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeViewState(), this, null, 2, null), WidgetLeaveGuildDialog.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass3(), 62, (Object) null);
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeEvents(), this, null, 2, null), WidgetLeaveGuildDialog.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass4(), 62, (Object) null);
    }
}
