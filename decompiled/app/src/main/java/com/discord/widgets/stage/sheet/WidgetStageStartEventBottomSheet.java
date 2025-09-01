package com.discord.widgets.stage.sheet;

import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.TextView;
import androidx.core.os.Bundle2;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import b.a.d.AppToast;
import b.a.d.AppViewModelDelegates3;
import b.a.d.AppViewModelDelegates5;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.app.AppBottomSheet;
import com.discord.databinding.WidgetStageStartEventBottomSheetBinding;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.view.text.TextWatcher4;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.widgets.stage.sheet.WidgetStageStartEventBottomSheetViewModel;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import d0.LazyJVM;
import d0.Tuples;
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

/* compiled from: WidgetStageStartEventBottomSheet.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 02\u00020\u0001:\u00010B\u0007¢\u0006\u0004\b/\u0010\u0015J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\f\u0010\rJ!\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0014\u0010\u0015R!\u0010\u001c\u001a\u00060\u0016j\u0002`\u00178B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR*\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u001d8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001d\u0010)\u001a\u00020$8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(R\u001d\u0010.\u001a\u00020*8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b+\u0010\u0019\u001a\u0004\b,\u0010-¨\u00061"}, d2 = {"Lcom/discord/widgets/stage/sheet/WidgetStageStartEventBottomSheet;", "Lcom/discord/app/AppBottomSheet;", "Lcom/discord/widgets/stage/sheet/WidgetStageStartEventBottomSheetViewModel$ViewState;", "viewState", "", "configureUI", "(Lcom/discord/widgets/stage/sheet/WidgetStageStartEventBottomSheetViewModel$ViewState;)V", "Lcom/discord/widgets/stage/sheet/WidgetStageStartEventBottomSheetViewModel$Event;", "event", "handleEvent", "(Lcom/discord/widgets/stage/sheet/WidgetStageStartEventBottomSheetViewModel$Event;)V", "", "getContentViewResId", "()I", "Landroid/view/View;", "view", "Landroid/os/Bundle;", "savedInstanceState", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "onResume", "()V", "", "Lcom/discord/primitives/ChannelId;", "channelId$delegate", "Lkotlin/Lazy;", "getChannelId", "()J", "channelId", "Lkotlin/Function0;", "onDismiss", "Lkotlin/jvm/functions/Function0;", "getOnDismiss", "()Lkotlin/jvm/functions/Function0;", "setOnDismiss", "(Lkotlin/jvm/functions/Function0;)V", "Lcom/discord/databinding/WidgetStageStartEventBottomSheetBinding;", "binding$delegate", "Lcom/discord/utilities/viewbinding/FragmentViewBindingDelegate;", "getBinding", "()Lcom/discord/databinding/WidgetStageStartEventBottomSheetBinding;", "binding", "Lcom/discord/widgets/stage/sheet/WidgetStageStartEventBottomSheetViewModel;", "viewModel$delegate", "getViewModel", "()Lcom/discord/widgets/stage/sheet/WidgetStageStartEventBottomSheetViewModel;", "viewModel", "<init>", "Companion", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class WidgetStageStartEventBottomSheet extends AppBottomSheet {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetStageStartEventBottomSheet.class, "binding", "getBinding()Lcom/discord/databinding/WidgetStageStartEventBottomSheetBinding;", 0)};

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* renamed from: channelId$delegate, reason: from kotlin metadata */
    private final Lazy channelId;
    private Function0<Unit> onDismiss;

    /* renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* compiled from: WidgetStageStartEventBottomSheet.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\r\u0010\u000eJ3\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\n\u0010\u0006\u001a\u00060\u0004j\u0002`\u00052\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007¢\u0006\u0004\b\u000b\u0010\f¨\u0006\u000f"}, d2 = {"Lcom/discord/widgets/stage/sheet/WidgetStageStartEventBottomSheet$Companion;", "", "Landroidx/fragment/app/FragmentManager;", "fragmentManager", "", "Lcom/discord/primitives/ChannelId;", "channelId", "Lkotlin/Function0;", "", "onDismiss", "Lcom/discord/widgets/stage/sheet/WidgetStageStartEventBottomSheet;", "show", "(Landroidx/fragment/app/FragmentManager;JLkotlin/jvm/functions/Function0;)Lcom/discord/widgets/stage/sheet/WidgetStageStartEventBottomSheet;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ WidgetStageStartEventBottomSheet show$default(Companion companion, FragmentManager fragmentManager, long j, Function0 function0, int i, Object obj) {
            if ((i & 4) != 0) {
                function0 = null;
            }
            return companion.show(fragmentManager, j, function0);
        }

        public final WidgetStageStartEventBottomSheet show(FragmentManager fragmentManager, long channelId, Function0<Unit> onDismiss) {
            Intrinsics3.checkNotNullParameter(fragmentManager, "fragmentManager");
            WidgetStageStartEventBottomSheet widgetStageStartEventBottomSheet = new WidgetStageStartEventBottomSheet();
            widgetStageStartEventBottomSheet.setOnDismiss(onDismiss);
            widgetStageStartEventBottomSheet.setArguments(Bundle2.bundleOf(Tuples.to("com.discord.intent.extra.EXTRA_CHANNEL_ID", Long.valueOf(channelId))));
            widgetStageStartEventBottomSheet.show(fragmentManager, WidgetStageStartEventBottomSheet.class.getSimpleName());
            return widgetStageStartEventBottomSheet;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetStageStartEventBottomSheet.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/widgets/stage/sheet/WidgetStageStartEventBottomSheetViewModel$Event;", "event", "", "invoke", "(Lcom/discord/widgets/stage/sheet/WidgetStageStartEventBottomSheetViewModel$Event;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.stage.sheet.WidgetStageStartEventBottomSheet$onResume$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<WidgetStageStartEventBottomSheetViewModel.Event, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(WidgetStageStartEventBottomSheetViewModel.Event event) {
            invoke2(event);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(WidgetStageStartEventBottomSheetViewModel.Event event) {
            Intrinsics3.checkNotNullParameter(event, "event");
            WidgetStageStartEventBottomSheet.access$handleEvent(WidgetStageStartEventBottomSheet.this, event);
        }
    }

    /* compiled from: WidgetStageStartEventBottomSheet.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/widgets/stage/sheet/WidgetStageStartEventBottomSheetViewModel$ViewState;", "viewState", "", "invoke", "(Lcom/discord/widgets/stage/sheet/WidgetStageStartEventBottomSheetViewModel$ViewState;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.stage.sheet.WidgetStageStartEventBottomSheet$onResume$2, reason: invalid class name */
    public static final class AnonymousClass2 extends Lambda implements Function1<WidgetStageStartEventBottomSheetViewModel.ViewState, Unit> {
        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(WidgetStageStartEventBottomSheetViewModel.ViewState viewState) {
            invoke2(viewState);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(WidgetStageStartEventBottomSheetViewModel.ViewState viewState) {
            Intrinsics3.checkNotNullParameter(viewState, "viewState");
            WidgetStageStartEventBottomSheet.access$configureUI(WidgetStageStartEventBottomSheet.this, viewState);
        }
    }

    /* compiled from: WidgetStageStartEventBottomSheet.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/text/Editable;", "editable", "", "invoke", "(Landroid/text/Editable;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.stage.sheet.WidgetStageStartEventBottomSheet$onViewCreated$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<Editable, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Editable editable) {
            invoke2(editable);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Editable editable) {
            Intrinsics3.checkNotNullParameter(editable, "editable");
            TextInputLayout textInputLayout = WidgetStageStartEventBottomSheet.access$getBinding$p(WidgetStageStartEventBottomSheet.this).g;
            Intrinsics3.checkNotNullExpressionValue(textInputLayout, "binding.topicLayout");
            textInputLayout.setError(null);
            WidgetStageStartEventBottomSheet.access$getViewModel$p(WidgetStageStartEventBottomSheet.this).setTopic(editable.toString());
        }
    }

    /* compiled from: WidgetStageStartEventBottomSheet.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.stage.sheet.WidgetStageStartEventBottomSheet$onViewCreated$2, reason: invalid class name */
    public static final class AnonymousClass2 implements View.OnClickListener {

        /* compiled from: WidgetStageStartEventBottomSheet.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
        /* renamed from: com.discord.widgets.stage.sheet.WidgetStageStartEventBottomSheet$onViewCreated$2$1, reason: invalid class name */
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
                WidgetStageStartEventBottomSheet.access$getViewModel$p(WidgetStageStartEventBottomSheet.this).openStage(false);
                Function0<Unit> onDismiss = WidgetStageStartEventBottomSheet.this.getOnDismiss();
                if (onDismiss != null) {
                    onDismiss.invoke();
                }
            }
        }

        /* compiled from: WidgetStageStartEventBottomSheet.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
        /* renamed from: com.discord.widgets.stage.sheet.WidgetStageStartEventBottomSheet$onViewCreated$2$2, reason: invalid class name and collision with other inner class name */
        public static final class C03472 extends Lambda implements Function0<Unit> {
            public C03472() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                WidgetStageStartEventBottomSheet.access$getViewModel$p(WidgetStageStartEventBottomSheet.this).openStage(true);
                Function0<Unit> onDismiss = WidgetStageStartEventBottomSheet.this.getOnDismiss();
                if (onDismiss != null) {
                    onDismiss.invoke();
                }
            }
        }

        public AnonymousClass2() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetStageStartEventBottomSheet.this.requestMicrophone(new AnonymousClass1(), new C03472());
        }
    }

    public WidgetStageStartEventBottomSheet() {
        super(true);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetStageStartEventBottomSheet2.INSTANCE, null, 2, null);
        this.channelId = LazyJVM.lazy(new WidgetStageStartEventBottomSheet3(this));
        WidgetStageStartEventBottomSheet4 widgetStageStartEventBottomSheet4 = new WidgetStageStartEventBottomSheet4(this);
        AppViewModelDelegates3 appViewModelDelegates3 = new AppViewModelDelegates3(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection2.getOrCreateKotlinClass(WidgetStageStartEventBottomSheetViewModel.class), new WidgetStageStartEventBottomSheet$appViewModels$$inlined$viewModels$1(appViewModelDelegates3), new AppViewModelDelegates5(widgetStageStartEventBottomSheet4));
    }

    public static final /* synthetic */ void access$configureUI(WidgetStageStartEventBottomSheet widgetStageStartEventBottomSheet, WidgetStageStartEventBottomSheetViewModel.ViewState viewState) {
        widgetStageStartEventBottomSheet.configureUI(viewState);
    }

    public static final /* synthetic */ Bundle access$getArgumentsOrDefault$p(WidgetStageStartEventBottomSheet widgetStageStartEventBottomSheet) {
        return widgetStageStartEventBottomSheet.getArgumentsOrDefault();
    }

    public static final /* synthetic */ WidgetStageStartEventBottomSheetBinding access$getBinding$p(WidgetStageStartEventBottomSheet widgetStageStartEventBottomSheet) {
        return widgetStageStartEventBottomSheet.getBinding();
    }

    public static final /* synthetic */ long access$getChannelId$p(WidgetStageStartEventBottomSheet widgetStageStartEventBottomSheet) {
        return widgetStageStartEventBottomSheet.getChannelId();
    }

    public static final /* synthetic */ WidgetStageStartEventBottomSheetViewModel access$getViewModel$p(WidgetStageStartEventBottomSheet widgetStageStartEventBottomSheet) {
        return widgetStageStartEventBottomSheet.getViewModel();
    }

    public static final /* synthetic */ void access$handleEvent(WidgetStageStartEventBottomSheet widgetStageStartEventBottomSheet, WidgetStageStartEventBottomSheetViewModel.Event event) {
        widgetStageStartEventBottomSheet.handleEvent(event);
    }

    private final void configureUI(WidgetStageStartEventBottomSheetViewModel.ViewState viewState) {
        if (viewState instanceof WidgetStageStartEventBottomSheetViewModel.ViewState.Loaded) {
            MaterialButton materialButton = getBinding().c;
            Intrinsics3.checkNotNullExpressionValue(materialButton, "binding.startStageButton");
            WidgetStageStartEventBottomSheetViewModel.ViewState.Loaded loaded = (WidgetStageStartEventBottomSheetViewModel.ViewState.Loaded) viewState;
            ViewExtensions.setEnabledAndAlpha$default(materialButton, loaded.getTopic().length() > 0, 0.0f, 2, null);
            String topic = loaded.getTopic();
            Intrinsics3.checkNotNullExpressionValue(getBinding().g, "binding.topicLayout");
            if (!Intrinsics3.areEqual(topic, ViewExtensions.getTextOrEmpty(r2))) {
                getBinding().f.setText(loaded.getTopic());
            }
            TextView textView = getBinding().e;
            Intrinsics3.checkNotNullExpressionValue(textView, "binding.title");
            textView.setText(getString(loaded.getStageInstance() == null ? R.string.start_stage_channel_event_modal_title : R.string.edit_stage_title));
            TextView textView2 = getBinding().d;
            Intrinsics3.checkNotNullExpressionValue(textView2, "binding.subtitle");
            textView2.setText(getString(loaded.getStageInstance() == null ? R.string.start_stage_channel_event_modal_subtitle : R.string.edit_stage_subtitle));
            MaterialButton materialButton2 = getBinding().c;
            Intrinsics3.checkNotNullExpressionValue(materialButton2, "binding.startStageButton");
            materialButton2.setText(getString(loaded.getStageInstance() == null ? R.string.start_stage_channel_event_modal_button : R.string.save_changes));
            TextView textView3 = getBinding().f2658b;
            Intrinsics3.checkNotNullExpressionValue(textView3, "binding.speakerHint");
            textView3.setVisibility(loaded.getStageInstance() == null ? 0 : 8);
        }
    }

    private final WidgetStageStartEventBottomSheetBinding getBinding() {
        return (WidgetStageStartEventBottomSheetBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final long getChannelId() {
        return ((Number) this.channelId.getValue()).longValue();
    }

    private final WidgetStageStartEventBottomSheetViewModel getViewModel() {
        return (WidgetStageStartEventBottomSheetViewModel) this.viewModel.getValue();
    }

    private final void handleEvent(WidgetStageStartEventBottomSheetViewModel.Event event) {
        if (event instanceof WidgetStageStartEventBottomSheetViewModel.Event.SetTopicSuccess) {
            AppBottomSheet.hideKeyboard$default(this, null, 1, null);
            dismiss();
        } else if (event instanceof WidgetStageStartEventBottomSheetViewModel.Event.SetTopicFailure) {
            AppToast.i(this, ((WidgetStageStartEventBottomSheetViewModel.Event.SetTopicFailure) event).getFailureMessageStringRes(), 0, 4);
        } else if (event instanceof WidgetStageStartEventBottomSheetViewModel.Event.InvalidTopic) {
            TextInputLayout textInputLayout = getBinding().g;
            Intrinsics3.checkNotNullExpressionValue(textInputLayout, "binding.topicLayout");
            textInputLayout.setError(getString(((WidgetStageStartEventBottomSheetViewModel.Event.InvalidTopic) event).getFailureMessageStringRes()));
        }
    }

    @Override // com.discord.app.AppBottomSheet
    public int getContentViewResId() {
        return R.layout.widget_stage_start_event_bottom_sheet;
    }

    public final Function0<Unit> getOnDismiss() {
        return this.onDismiss;
    }

    @Override // com.discord.app.AppBottomSheet, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeEvents(), this, null, 2, null), WidgetStageStartEventBottomSheet.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(), 62, (Object) null);
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeViewState(), this, null, 2, null), WidgetStageStartEventBottomSheet.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass2(), 62, (Object) null);
    }

    @Override // com.discord.app.AppBottomSheet, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        TextInputEditText textInputEditText = getBinding().f;
        Intrinsics3.checkNotNullExpressionValue(textInputEditText, "binding.topicInput");
        TextWatcher4.addBindedTextWatcher(textInputEditText, this, new AnonymousClass1());
        getBinding().c.setOnClickListener(new AnonymousClass2());
    }

    public final void setOnDismiss(Function0<Unit> function0) {
        this.onDismiss = function0;
    }
}
