package com.discord.widgets.voice.sheet;

import android.content.Context;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import b.a.d.AppHelpDesk;
import b.a.d.AppToast;
import b.a.d.AppViewModelDelegates3;
import b.a.d.AppViewModelDelegates5;
import b.a.k.FormatUtils;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.app.AppBottomSheet;
import com.discord.databinding.WidgetVoiceNoiseCancellationBottomSheetBinding;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.widgets.voice.sheet.WidgetNoiseCancellationBottomSheetViewModel;
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

/* compiled from: WidgetNoiseCancellationBottomSheet.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB\u0007¢\u0006\u0004\b\u0019\u0010\bJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\f\u0010\bR\u001d\u0010\u0012\u001a\u00020\r8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001d\u0010\u0018\u001a\u00020\u00138B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u001b"}, d2 = {"Lcom/discord/widgets/voice/sheet/WidgetNoiseCancellationBottomSheet;", "Lcom/discord/app/AppBottomSheet;", "Lcom/discord/widgets/voice/sheet/WidgetNoiseCancellationBottomSheetViewModel$Event;", "event", "", "handleEvent", "(Lcom/discord/widgets/voice/sheet/WidgetNoiseCancellationBottomSheetViewModel$Event;)V", "configureUI", "()V", "", "getContentViewResId", "()I", "onResume", "Lcom/discord/databinding/WidgetVoiceNoiseCancellationBottomSheetBinding;", "binding$delegate", "Lcom/discord/utilities/viewbinding/FragmentViewBindingDelegate;", "getBinding", "()Lcom/discord/databinding/WidgetVoiceNoiseCancellationBottomSheetBinding;", "binding", "Lcom/discord/widgets/voice/sheet/WidgetNoiseCancellationBottomSheetViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "getViewModel", "()Lcom/discord/widgets/voice/sheet/WidgetNoiseCancellationBottomSheetViewModel;", "viewModel", "<init>", "Companion", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final class WidgetNoiseCancellationBottomSheet extends AppBottomSheet {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetNoiseCancellationBottomSheet.class, "binding", "getBinding()Lcom/discord/databinding/WidgetVoiceNoiseCancellationBottomSheetBinding;", 0)};

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* compiled from: WidgetNoiseCancellationBottomSheet.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/discord/widgets/voice/sheet/WidgetNoiseCancellationBottomSheet$Companion;", "", "Landroidx/fragment/app/Fragment;", "fragment", "", "show", "(Landroidx/fragment/app/Fragment;)V", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public final void show(Fragment fragment) {
            Intrinsics3.checkNotNullParameter(fragment, "fragment");
            WidgetNoiseCancellationBottomSheet widgetNoiseCancellationBottomSheet = new WidgetNoiseCancellationBottomSheet();
            FragmentManager parentFragmentManager = fragment.getParentFragmentManager();
            Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "fragment.parentFragmentManager");
            widgetNoiseCancellationBottomSheet.show(parentFragmentManager, WidgetNoiseCancellationBottomSheet.class.getName());
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetNoiseCancellationBottomSheet.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.voice.sheet.WidgetNoiseCancellationBottomSheet$configureUI$1, reason: invalid class name */
    public static final class AnonymousClass1 implements View.OnClickListener {
        public AnonymousClass1() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetNoiseCancellationBottomSheet.access$getViewModel$p(WidgetNoiseCancellationBottomSheet.this).onNoiseCancellationButtonPressed();
            WidgetNoiseCancellationBottomSheet.this.dismiss();
        }
    }

    /* compiled from: WidgetNoiseCancellationBottomSheet.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/widgets/voice/sheet/WidgetNoiseCancellationBottomSheetViewModel$Event;", "event", "", "invoke", "(Lcom/discord/widgets/voice/sheet/WidgetNoiseCancellationBottomSheetViewModel$Event;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.voice.sheet.WidgetNoiseCancellationBottomSheet$onResume$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<WidgetNoiseCancellationBottomSheetViewModel.Event, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(WidgetNoiseCancellationBottomSheetViewModel.Event event) {
            invoke2(event);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(WidgetNoiseCancellationBottomSheetViewModel.Event event) {
            Intrinsics3.checkNotNullParameter(event, "event");
            WidgetNoiseCancellationBottomSheet.access$handleEvent(WidgetNoiseCancellationBottomSheet.this, event);
        }
    }

    public WidgetNoiseCancellationBottomSheet() {
        super(false, 1, null);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetNoiseCancellationBottomSheet2.INSTANCE, null, 2, null);
        WidgetNoiseCancellationBottomSheet3 widgetNoiseCancellationBottomSheet3 = WidgetNoiseCancellationBottomSheet3.INSTANCE;
        AppViewModelDelegates3 appViewModelDelegates3 = new AppViewModelDelegates3(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection2.getOrCreateKotlinClass(WidgetNoiseCancellationBottomSheetViewModel.class), new WidgetNoiseCancellationBottomSheet$appViewModels$$inlined$viewModels$1(appViewModelDelegates3), new AppViewModelDelegates5(widgetNoiseCancellationBottomSheet3));
    }

    public static final /* synthetic */ WidgetNoiseCancellationBottomSheetViewModel access$getViewModel$p(WidgetNoiseCancellationBottomSheet widgetNoiseCancellationBottomSheet) {
        return widgetNoiseCancellationBottomSheet.getViewModel();
    }

    public static final /* synthetic */ void access$handleEvent(WidgetNoiseCancellationBottomSheet widgetNoiseCancellationBottomSheet, WidgetNoiseCancellationBottomSheetViewModel.Event event) {
        widgetNoiseCancellationBottomSheet.handleEvent(event);
    }

    private final void configureUI() {
        TextView textView = getBinding().c;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.noiseCancellationLearnMore");
        FormatUtils.n(textView, R.string.learn_more_link, new Object[]{AppHelpDesk.a.a(360040843952L, null)}, null, 4);
        TextView textView2 = getBinding().c;
        Intrinsics3.checkNotNullExpressionValue(textView2, "binding.noiseCancellationLearnMore");
        textView2.setMovementMethod(LinkMovementMethod.getInstance());
        getBinding().f2704b.setOnClickListener(new AnonymousClass1());
    }

    private final WidgetVoiceNoiseCancellationBottomSheetBinding getBinding() {
        return (WidgetVoiceNoiseCancellationBottomSheetBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final WidgetNoiseCancellationBottomSheetViewModel getViewModel() {
        return (WidgetNoiseCancellationBottomSheetViewModel) this.viewModel.getValue();
    }

    private final void handleEvent(WidgetNoiseCancellationBottomSheetViewModel.Event event) {
        if (event instanceof WidgetNoiseCancellationBottomSheetViewModel.Event.ShowToast) {
            AppToast.g(requireContext(), ((WidgetNoiseCancellationBottomSheetViewModel.Event.ShowToast) event).getToastResId(), 0, null, 12);
        }
    }

    @Override // com.discord.app.AppBottomSheet
    public int getContentViewResId() {
        return R.layout.widget_voice_noise_cancellation_bottom_sheet;
    }

    @Override // com.discord.app.AppBottomSheet, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeEvents(), this, null, 2, null), WidgetNoiseCancellationBottomSheet.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(), 62, (Object) null);
        configureUI();
    }
}
