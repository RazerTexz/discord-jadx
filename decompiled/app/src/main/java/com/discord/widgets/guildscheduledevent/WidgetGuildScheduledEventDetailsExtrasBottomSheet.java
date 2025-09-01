package com.discord.widgets.guildscheduledevent;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.View;
import android.widget.TextView;
import androidx.activity.result.ActivityResultLauncher;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import b.a.d.AppToast;
import b.a.d.AppViewModelDelegates3;
import b.a.d.AppViewModelDelegates5;
import b.a.k.FormatUtils;
import b.c.a.a0.AnimatableValueParser;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.app.AppBottomSheet;
import com.discord.databinding.WidgetGuildScheduledEventDetailsExtrasBottomSheetBinding;
import com.discord.utilities.guildscheduledevent.GuildScheduledEventUtilities2;
import com.discord.utilities.guildscheduledevent.GuildScheduledEventUtilities5;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.widgets.guildscheduledevent.GuildScheduledEventDetailsViewModel;
import com.discord.widgets.guildscheduledevent.WidgetGuildScheduledEventDetailsBottomSheet;
import com.discord.widgets.guildscheduledevent.WidgetGuildScheduledEventLocationSelect;
import com.discord.widgets.guildscheduledevent.WidgetPreviewGuildScheduledEvent;
import com.discord.widgets.mobile_reports.WidgetMobileReports;
import com.discord.widgets.notice.WidgetNoticeDialog;
import d0.LazyJVM;
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
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;

/* compiled from: WidgetGuildScheduledEventDetailsExtrasBottomSheet.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 +2\u00020\u0001:\u0001+B\u0007¢\u0006\u0004\b*\u0010\bJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\f\u0010\bJ\u0017\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0012\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u001d\u0010\u0019\u001a\u00020\u00148B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u001d\u0010\u001e\u001a\u00020\u001a8F@\u0006X\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u001b\u0010\u0016\u001a\u0004\b\u001c\u0010\u001dR$\u0010\"\u001a\u0010\u0012\f\u0012\n !*\u0004\u0018\u00010 0 0\u001f8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\"\u0010#R\u001d\u0010)\u001a\u00020$8F@\u0006X\u0086\u0084\u0002¢\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(¨\u0006,"}, d2 = {"Lcom/discord/widgets/guildscheduledevent/WidgetGuildScheduledEventDetailsExtrasBottomSheet;", "Lcom/discord/app/AppBottomSheet;", "Lcom/discord/widgets/guildscheduledevent/GuildScheduledEventDetailsViewModel$ViewState;", "viewState", "", "configureUi", "(Lcom/discord/widgets/guildscheduledevent/GuildScheduledEventDetailsViewModel$ViewState;)V", "dismissWithActionTaken", "()V", "", "getContentViewResId", "()I", "onResume", "Landroid/content/DialogInterface;", "dialog", "onDismiss", "(Landroid/content/DialogInterface;)V", "", "actionTaken", "Z", "Lcom/discord/widgets/guildscheduledevent/GuildScheduledEventDetailsViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "getViewModel", "()Lcom/discord/widgets/guildscheduledevent/GuildScheduledEventDetailsViewModel;", "viewModel", "Lcom/discord/widgets/guildscheduledevent/GuildScheduledEventDetailsArgs;", "args$delegate", "getArgs", "()Lcom/discord/widgets/guildscheduledevent/GuildScheduledEventDetailsArgs;", "args", "Landroidx/activity/result/ActivityResultLauncher;", "Landroid/content/Intent;", "kotlin.jvm.PlatformType", "previewLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "Lcom/discord/databinding/WidgetGuildScheduledEventDetailsExtrasBottomSheetBinding;", "binding$delegate", "Lcom/discord/utilities/viewbinding/FragmentViewBindingDelegate;", "getBinding", "()Lcom/discord/databinding/WidgetGuildScheduledEventDetailsExtrasBottomSheetBinding;", "binding", "<init>", "Companion", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class WidgetGuildScheduledEventDetailsExtrasBottomSheet extends AppBottomSheet {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetGuildScheduledEventDetailsExtrasBottomSheet.class, "binding", "getBinding()Lcom/discord/databinding/WidgetGuildScheduledEventDetailsExtrasBottomSheetBinding;", 0)};

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private boolean actionTaken;

    /* renamed from: args$delegate, reason: from kotlin metadata */
    private final Lazy args;

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private final ActivityResultLauncher<Intent> previewLauncher;

    /* renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* compiled from: WidgetGuildScheduledEventDetailsExtrasBottomSheet.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nJ\u001d\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/discord/widgets/guildscheduledevent/WidgetGuildScheduledEventDetailsExtrasBottomSheet$Companion;", "", "Landroidx/fragment/app/FragmentManager;", "fragmentManager", "Lcom/discord/widgets/guildscheduledevent/GuildScheduledEventDetailsArgs;", "args", "", "show", "(Landroidx/fragment/app/FragmentManager;Lcom/discord/widgets/guildscheduledevent/GuildScheduledEventDetailsArgs;)V", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public final void show(FragmentManager fragmentManager, WidgetGuildScheduledEventDetailsBottomSheet2 args) {
            Intrinsics3.checkNotNullParameter(fragmentManager, "fragmentManager");
            Intrinsics3.checkNotNullParameter(args, "args");
            WidgetGuildScheduledEventDetailsExtrasBottomSheet widgetGuildScheduledEventDetailsExtrasBottomSheet = new WidgetGuildScheduledEventDetailsExtrasBottomSheet();
            widgetGuildScheduledEventDetailsExtrasBottomSheet.setArguments(AnimatableValueParser.e2(args));
            widgetGuildScheduledEventDetailsExtrasBottomSheet.show(fragmentManager, WidgetGuildScheduledEventDetailsExtrasBottomSheet.class.getName());
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetGuildScheduledEventDetailsExtrasBottomSheet.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.guildscheduledevent.WidgetGuildScheduledEventDetailsExtrasBottomSheet$configureUi$2, reason: invalid class name */
    public static final class AnonymousClass2 implements View.OnClickListener {
        public final /* synthetic */ GuildScheduledEventDetailsViewModel.ViewState $viewState;

        public AnonymousClass2(GuildScheduledEventDetailsViewModel.ViewState viewState) {
            this.$viewState = viewState;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetPreviewGuildScheduledEvent.Companion companion = WidgetPreviewGuildScheduledEvent.INSTANCE;
            Context contextRequireContext = WidgetGuildScheduledEventDetailsExtrasBottomSheet.this.requireContext();
            Intrinsics3.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
            WidgetPreviewGuildScheduledEvent.Companion.launch$default(companion, contextRequireContext, GuildScheduledEventModel2.toModel(((GuildScheduledEventDetailsViewModel.ViewState.Initialized) this.$viewState).getGuildScheduledEvent()), new WidgetPreviewGuildScheduledEvent.Companion.ExistingEventData(((GuildScheduledEventDetailsViewModel.ViewState.Initialized) this.$viewState).getGuildScheduledEvent().getId(), WidgetPreviewGuildScheduledEvent.Companion.Action.START_EVENT), WidgetGuildScheduledEventDetailsExtrasBottomSheet.access$getPreviewLauncher$p(WidgetGuildScheduledEventDetailsExtrasBottomSheet.this), false, 16, null);
        }
    }

    /* compiled from: WidgetGuildScheduledEventDetailsExtrasBottomSheet.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.guildscheduledevent.WidgetGuildScheduledEventDetailsExtrasBottomSheet$configureUi$3, reason: invalid class name */
    public static final class AnonymousClass3 implements View.OnClickListener {
        public final /* synthetic */ GuildScheduledEventDetailsViewModel.ViewState $viewState;

        public AnonymousClass3(GuildScheduledEventDetailsViewModel.ViewState viewState) {
            this.$viewState = viewState;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetGuildScheduledEventDetailsExtrasBottomSheet.access$dismissWithActionTaken(WidgetGuildScheduledEventDetailsExtrasBottomSheet.this);
            WidgetGuildScheduledEventLocationSelect.Companion companion = WidgetGuildScheduledEventLocationSelect.INSTANCE;
            Context contextRequireContext = WidgetGuildScheduledEventDetailsExtrasBottomSheet.this.requireContext();
            Intrinsics3.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
            companion.launchForEdit(contextRequireContext, ((GuildScheduledEventDetailsViewModel.ViewState.Initialized) this.$viewState).getGuildScheduledEvent().getGuildId(), ((GuildScheduledEventDetailsViewModel.ViewState.Initialized) this.$viewState).getGuildScheduledEvent().getId());
        }
    }

    /* compiled from: WidgetGuildScheduledEventDetailsExtrasBottomSheet.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.guildscheduledevent.WidgetGuildScheduledEventDetailsExtrasBottomSheet$configureUi$4, reason: invalid class name */
    public static final class AnonymousClass4 implements View.OnClickListener {

        /* compiled from: WidgetGuildScheduledEventDetailsExtrasBottomSheet.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
        /* renamed from: com.discord.widgets.guildscheduledevent.WidgetGuildScheduledEventDetailsExtrasBottomSheet$configureUi$4$1, reason: invalid class name */
        public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
            public AnonymousClass1() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                WidgetGuildScheduledEventDetailsExtrasBottomSheet.access$dismissWithActionTaken(WidgetGuildScheduledEventDetailsExtrasBottomSheet.this);
            }
        }

        public AnonymousClass4() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            GuildScheduledEventDetailsViewModel guildScheduledEventDetailsViewModelAccess$getViewModel$p = WidgetGuildScheduledEventDetailsExtrasBottomSheet.access$getViewModel$p(WidgetGuildScheduledEventDetailsExtrasBottomSheet.this);
            Context contextRequireContext = WidgetGuildScheduledEventDetailsExtrasBottomSheet.this.requireContext();
            Intrinsics3.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
            guildScheduledEventDetailsViewModelAccess$getViewModel$p.endEventClicked(contextRequireContext, new AnonymousClass1());
        }
    }

    /* compiled from: WidgetGuildScheduledEventDetailsExtrasBottomSheet.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.guildscheduledevent.WidgetGuildScheduledEventDetailsExtrasBottomSheet$configureUi$5, reason: invalid class name */
    public static final class AnonymousClass5 implements View.OnClickListener {
        public final /* synthetic */ GuildScheduledEventDetailsViewModel.ViewState $viewState;

        /* compiled from: WidgetGuildScheduledEventDetailsExtrasBottomSheet.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/view/View;", "it", "", "invoke", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
        /* renamed from: com.discord.widgets.guildscheduledevent.WidgetGuildScheduledEventDetailsExtrasBottomSheet$configureUi$5$1, reason: invalid class name */
        public static final class AnonymousClass1 extends Lambda implements Function1<View, Unit> {

            /* compiled from: WidgetGuildScheduledEventDetailsExtrasBottomSheet.kt */
            @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
            /* renamed from: com.discord.widgets.guildscheduledevent.WidgetGuildScheduledEventDetailsExtrasBottomSheet$configureUi$5$1$1, reason: invalid class name and collision with other inner class name */
            public static final class C02961 extends Lambda implements Function0<Unit> {
                public C02961() {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.a;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    WidgetGuildScheduledEventDetailsExtrasBottomSheet.this.dismiss();
                }
            }

            public AnonymousClass1() {
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
                GuildScheduledEventDetailsViewModel guildScheduledEventDetailsViewModelAccess$getViewModel$p = WidgetGuildScheduledEventDetailsExtrasBottomSheet.access$getViewModel$p(WidgetGuildScheduledEventDetailsExtrasBottomSheet.this);
                Context contextRequireContext = WidgetGuildScheduledEventDetailsExtrasBottomSheet.this.requireContext();
                Intrinsics3.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
                guildScheduledEventDetailsViewModelAccess$getViewModel$p.onDeleteButtonClicked(contextRequireContext, new C02961());
            }
        }

        public AnonymousClass5(GuildScheduledEventDetailsViewModel.ViewState viewState) {
            this.$viewState = viewState;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetNoticeDialog.Companion companion = WidgetNoticeDialog.INSTANCE;
            FragmentManager childFragmentManager = WidgetGuildScheduledEventDetailsExtrasBottomSheet.this.getChildFragmentManager();
            Intrinsics3.checkNotNullExpressionValue(childFragmentManager, "childFragmentManager");
            String string = WidgetGuildScheduledEventDetailsExtrasBottomSheet.this.requireContext().getString(R.string.delete_event);
            Context contextRequireContext = WidgetGuildScheduledEventDetailsExtrasBottomSheet.this.requireContext();
            Intrinsics3.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
            WidgetNoticeDialog.Companion.show$default(companion, childFragmentManager, string, FormatUtils.h(contextRequireContext, R.string.delete_stage_event_confirmation_description, new Object[]{((GuildScheduledEventDetailsViewModel.ViewState.Initialized) this.$viewState).getGuildScheduledEvent().getName()}, null, 4), WidgetGuildScheduledEventDetailsExtrasBottomSheet.this.requireContext().getString(R.string.delete_event), WidgetGuildScheduledEventDetailsExtrasBottomSheet.this.requireContext().getString(R.string.back), MapsJVM.mapOf(Tuples.to(Integer.valueOf(R.id.notice_ok), new AnonymousClass1())), null, null, null, null, null, null, 0, null, 16320, null);
        }
    }

    /* compiled from: WidgetGuildScheduledEventDetailsExtrasBottomSheet.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.guildscheduledevent.WidgetGuildScheduledEventDetailsExtrasBottomSheet$configureUi$6, reason: invalid class name */
    public static final class AnonymousClass6 implements View.OnClickListener {
        public final /* synthetic */ GuildScheduledEventDetailsViewModel.ViewState $viewState;

        public AnonymousClass6(GuildScheduledEventDetailsViewModel.ViewState viewState) {
            this.$viewState = viewState;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetGuildScheduledEventDetailsExtrasBottomSheet.access$dismissWithActionTaken(WidgetGuildScheduledEventDetailsExtrasBottomSheet.this);
            WidgetMobileReports.Companion companion = WidgetMobileReports.INSTANCE;
            Context contextRequireContext = WidgetGuildScheduledEventDetailsExtrasBottomSheet.this.requireContext();
            Intrinsics3.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
            companion.launchGuildScheduledEventReport(contextRequireContext, ((GuildScheduledEventDetailsViewModel.ViewState.Initialized) this.$viewState).getGuildScheduledEvent().getGuildId(), ((GuildScheduledEventDetailsViewModel.ViewState.Initialized) this.$viewState).getGuildScheduledEvent().getId());
        }
    }

    /* compiled from: WidgetGuildScheduledEventDetailsExtrasBottomSheet.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.guildscheduledevent.WidgetGuildScheduledEventDetailsExtrasBottomSheet$configureUi$7, reason: invalid class name */
    public static final class AnonymousClass7 implements View.OnClickListener {
        public final /* synthetic */ GuildScheduledEventDetailsViewModel.ViewState $viewState;

        public AnonymousClass7(GuildScheduledEventDetailsViewModel.ViewState viewState) {
            this.$viewState = viewState;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetGuildScheduledEventDetailsExtrasBottomSheet.access$dismissWithActionTaken(WidgetGuildScheduledEventDetailsExtrasBottomSheet.this);
            Context contextRequireContext = WidgetGuildScheduledEventDetailsExtrasBottomSheet.this.requireContext();
            Intrinsics3.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
            AppToast.c(contextRequireContext, String.valueOf(((GuildScheduledEventDetailsViewModel.ViewState.Initialized) this.$viewState).getGuildScheduledEvent().getId()), 0, 4);
        }
    }

    /* compiled from: WidgetGuildScheduledEventDetailsExtrasBottomSheet.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/widgets/guildscheduledevent/GuildScheduledEventDetailsViewModel$ViewState;", "p1", "", "invoke", "(Lcom/discord/widgets/guildscheduledevent/GuildScheduledEventDetailsViewModel$ViewState;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.guildscheduledevent.WidgetGuildScheduledEventDetailsExtrasBottomSheet$onResume$1, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<GuildScheduledEventDetailsViewModel.ViewState, Unit> {
        public AnonymousClass1(WidgetGuildScheduledEventDetailsExtrasBottomSheet widgetGuildScheduledEventDetailsExtrasBottomSheet) {
            super(1, widgetGuildScheduledEventDetailsExtrasBottomSheet, WidgetGuildScheduledEventDetailsExtrasBottomSheet.class, "configureUi", "configureUi(Lcom/discord/widgets/guildscheduledevent/GuildScheduledEventDetailsViewModel$ViewState;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(GuildScheduledEventDetailsViewModel.ViewState viewState) {
            invoke2(viewState);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(GuildScheduledEventDetailsViewModel.ViewState viewState) {
            Intrinsics3.checkNotNullParameter(viewState, "p1");
            WidgetGuildScheduledEventDetailsExtrasBottomSheet.access$configureUi((WidgetGuildScheduledEventDetailsExtrasBottomSheet) this.receiver, viewState);
        }
    }

    public WidgetGuildScheduledEventDetailsExtrasBottomSheet() {
        super(false, 1, null);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetGuildScheduledEventDetailsExtrasBottomSheet3.INSTANCE, null, 2, null);
        this.args = LazyJVM.lazy(new WidgetGuildScheduledEventDetailsExtrasBottomSheet$$special$$inlined$args$1(this, "intent_args_key"));
        WidgetGuildScheduledEventDetailsExtrasBottomSheet5 widgetGuildScheduledEventDetailsExtrasBottomSheet5 = new WidgetGuildScheduledEventDetailsExtrasBottomSheet5(this);
        AppViewModelDelegates3 appViewModelDelegates3 = new AppViewModelDelegates3(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection2.getOrCreateKotlinClass(GuildScheduledEventDetailsViewModel.class), new WidgetGuildScheduledEventDetailsExtrasBottomSheet$appViewModels$$inlined$viewModels$1(appViewModelDelegates3), new AppViewModelDelegates5(widgetGuildScheduledEventDetailsExtrasBottomSheet5));
        this.previewLauncher = WidgetPreviewGuildScheduledEvent.INSTANCE.createJoinOnStartActivityRegistration(this, new WidgetGuildScheduledEventDetailsExtrasBottomSheet4(this));
    }

    public static final /* synthetic */ void access$configureUi(WidgetGuildScheduledEventDetailsExtrasBottomSheet widgetGuildScheduledEventDetailsExtrasBottomSheet, GuildScheduledEventDetailsViewModel.ViewState viewState) {
        widgetGuildScheduledEventDetailsExtrasBottomSheet.configureUi(viewState);
    }

    public static final /* synthetic */ void access$dismissWithActionTaken(WidgetGuildScheduledEventDetailsExtrasBottomSheet widgetGuildScheduledEventDetailsExtrasBottomSheet) {
        widgetGuildScheduledEventDetailsExtrasBottomSheet.dismissWithActionTaken();
    }

    public static final /* synthetic */ ActivityResultLauncher access$getPreviewLauncher$p(WidgetGuildScheduledEventDetailsExtrasBottomSheet widgetGuildScheduledEventDetailsExtrasBottomSheet) {
        return widgetGuildScheduledEventDetailsExtrasBottomSheet.previewLauncher;
    }

    public static final /* synthetic */ GuildScheduledEventDetailsViewModel access$getViewModel$p(WidgetGuildScheduledEventDetailsExtrasBottomSheet widgetGuildScheduledEventDetailsExtrasBottomSheet) {
        return widgetGuildScheduledEventDetailsExtrasBottomSheet.getViewModel();
    }

    private final void configureUi(GuildScheduledEventDetailsViewModel.ViewState viewState) {
        String string;
        if (!(viewState instanceof GuildScheduledEventDetailsViewModel.ViewState.Initialized)) {
            dismiss();
            return;
        }
        GuildScheduledEventDetailsViewModel.ViewState.Initialized initialized = (GuildScheduledEventDetailsViewModel.ViewState.Initialized) viewState;
        boolean canStartEvent = initialized.getCanStartEvent();
        GuildScheduledEventUtilities2 eventTiming = GuildScheduledEventUtilities5.getEventTiming(initialized.getGuildScheduledEvent());
        TextView textView = getBinding().f;
        textView.setVisibility(canStartEvent && eventTiming.isStartable() ? 0 : 8);
        boolean zIsRsvped = initialized.isRsvped();
        if (zIsRsvped) {
            string = getString(R.string.event_mark_not_interested);
        } else {
            if (zIsRsvped) {
                throw new NoWhenBranchMatchedException();
            }
            string = getString(R.string.event_mark_interested);
        }
        textView.setText(string);
        textView.setOnClickListener(new WidgetGuildScheduledEventDetailsExtrasBottomSheet2(this, canStartEvent, eventTiming, viewState));
        TextView textView2 = getBinding().h;
        Intrinsics3.checkNotNullExpressionValue(textView2, "binding.startEvent");
        textView2.setVisibility(canStartEvent && eventTiming.isLongStartable() ? 0 : 8);
        getBinding().h.setOnClickListener(new AnonymousClass2(viewState));
        TextView textView3 = getBinding().d;
        Intrinsics3.checkNotNullExpressionValue(textView3, "binding.editEvent");
        textView3.setVisibility(canStartEvent ? 0 : 8);
        getBinding().d.setOnClickListener(new AnonymousClass3(viewState));
        boolean z2 = eventTiming == GuildScheduledEventUtilities2.LIVE;
        TextView textView4 = getBinding().e;
        Intrinsics3.checkNotNullExpressionValue(textView4, "binding.endEvent");
        textView4.setVisibility(canStartEvent && z2 ? 0 : 8);
        getBinding().e.setOnClickListener(new AnonymousClass4());
        TextView textView5 = getBinding().f2445b;
        Intrinsics3.checkNotNullExpressionValue(textView5, "binding.cancelEvent");
        textView5.setVisibility(initialized.getCanStartEvent() && !z2 ? 0 : 8);
        getBinding().f2445b.setOnClickListener(new AnonymousClass5(viewState));
        getBinding().g.setOnClickListener(new AnonymousClass6(viewState));
        TextView textView6 = getBinding().c;
        Intrinsics3.checkNotNullExpressionValue(textView6, "binding.copyId");
        textView6.setVisibility(initialized.isDeveloperMode() ? 0 : 8);
        getBinding().c.setOnClickListener(new AnonymousClass7(viewState));
    }

    private final void dismissWithActionTaken() {
        this.actionTaken = true;
        dismiss();
    }

    private final GuildScheduledEventDetailsViewModel getViewModel() {
        return (GuildScheduledEventDetailsViewModel) this.viewModel.getValue();
    }

    public final WidgetGuildScheduledEventDetailsBottomSheet2 getArgs() {
        return (WidgetGuildScheduledEventDetailsBottomSheet2) this.args.getValue();
    }

    public final WidgetGuildScheduledEventDetailsExtrasBottomSheetBinding getBinding() {
        return (WidgetGuildScheduledEventDetailsExtrasBottomSheetBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    @Override // com.discord.app.AppBottomSheet
    public int getContentViewResId() {
        return R.layout.widget_guild_scheduled_event_details_extras_bottom_sheet;
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialog) {
        Intrinsics3.checkNotNullParameter(dialog, "dialog");
        super.onDismiss(dialog);
        if (this.actionTaken) {
            return;
        }
        WidgetGuildScheduledEventDetailsBottomSheet.Companion companion = WidgetGuildScheduledEventDetailsBottomSheet.INSTANCE;
        FragmentManager parentFragmentManager = getParentFragmentManager();
        Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
        companion.show(parentFragmentManager, getArgs());
    }

    @Override // com.discord.app.AppBottomSheet, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeViewState(), this, null, 2, null), WidgetGuildScheduledEventDetailsExtrasBottomSheet.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(this), 62, (Object) null);
    }
}
