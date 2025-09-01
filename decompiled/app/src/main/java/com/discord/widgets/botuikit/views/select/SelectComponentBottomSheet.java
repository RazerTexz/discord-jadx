package com.discord.widgets.botuikit.views.select;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.core.os.Bundle2;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import b.a.d.AppViewModelDelegates3;
import b.a.d.AppViewModelDelegates5;
import b.a.k.FormatUtils;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.api.botuikit.SelectComponent2;
import com.discord.app.AppBottomSheet;
import com.discord.databinding.WidgetSelectComponentBottomSheetBinding;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.view.recycler.MaxHeightRecyclerView;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.widgets.botuikit.views.select.SelectComponentBottomSheetViewModel;
import d0.Tuples;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import d0.z.d.Reflection2;
import java.util.List;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;

/* compiled from: SelectComponentBottomSheet.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 ,2\u00020\u0001:\u0001,B\u0007¢\u0006\u0004\b+\u0010\u001bJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\t\u0010\nJ\u001d\u0010\u000f\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J!\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u00142\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001a\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u001a\u0010\u001bR\u0016\u0010\u001d\u001a\u00020\u001c8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u001d\u0010$\u001a\u00020\u001f8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#R\u001d\u0010*\u001a\u00020%8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)¨\u0006-"}, d2 = {"Lcom/discord/widgets/botuikit/views/select/SelectComponentBottomSheet;", "Lcom/discord/app/AppBottomSheet;", "Lcom/discord/widgets/botuikit/views/select/SelectComponentBottomSheetViewModel$Event;", "event", "", "handleEvent", "(Lcom/discord/widgets/botuikit/views/select/SelectComponentBottomSheetViewModel$Event;)V", "Lcom/discord/widgets/botuikit/views/select/SelectComponentBottomSheetViewModel$ViewState;", "viewState", "configureUI", "(Lcom/discord/widgets/botuikit/views/select/SelectComponentBottomSheetViewModel$ViewState;)V", "Lcom/discord/api/botuikit/SelectItem;", "item", "", "isSelected", "onItemSelected", "(Lcom/discord/api/botuikit/SelectItem;Z)V", "", "getContentViewResId", "()I", "Landroid/view/View;", "view", "Landroid/os/Bundle;", "savedInstanceState", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "onResume", "()V", "Lcom/discord/widgets/botuikit/views/select/SelectComponentBottomSheetAdapter;", "adapter", "Lcom/discord/widgets/botuikit/views/select/SelectComponentBottomSheetAdapter;", "Lcom/discord/widgets/botuikit/views/select/SelectComponentBottomSheetViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "getViewModel", "()Lcom/discord/widgets/botuikit/views/select/SelectComponentBottomSheetViewModel;", "viewModel", "Lcom/discord/databinding/WidgetSelectComponentBottomSheetBinding;", "binding$delegate", "Lcom/discord/utilities/viewbinding/FragmentViewBindingDelegate;", "getBinding", "()Lcom/discord/databinding/WidgetSelectComponentBottomSheetBinding;", "binding", "<init>", "Companion", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class SelectComponentBottomSheet extends AppBottomSheet {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(SelectComponentBottomSheet.class, "binding", "getBinding()Lcom/discord/databinding/WidgetSelectComponentBottomSheetBinding;", 0)};

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final String EXTRA_COMPONENT_CONTEXT = "extra_component_context";
    public static final String EXTRA_COMPONENT_INDEX = "extra_component_index";
    public static final String EXTRA_CUSTOM_ID = "extra_custom_id";
    public static final String EXTRA_EMOJI_ANIMATIONS_ENABLED = "extra_emoji_animations_enabled";
    public static final String EXTRA_MAX = "extra_max";
    public static final String EXTRA_MIN = "extra_min";
    public static final String EXTRA_OPTIONS = "extra_options";
    public static final String EXTRA_PLACEHOLDER = "extra_placeholder";
    public static final String EXTRA_SELECTED = "extra_selected";
    private final SelectComponentBottomSheetAdapter adapter;

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* compiled from: SelectComponentBottomSheet.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000f\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b!\u0010\"Jo\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\n\u0010\b\u001a\u00060\u0006j\u0002`\u00072\u0006\u0010\n\u001a\u00020\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\t2\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u00062\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\u0006\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0017\u001a\u00020\t8\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0016\u0010\u0019\u001a\u00020\t8\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0019\u0010\u0018R\u0016\u0010\u001a\u001a\u00020\t8\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u001a\u0010\u0018R\u0016\u0010\u001b\u001a\u00020\t8\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u001b\u0010\u0018R\u0016\u0010\u001c\u001a\u00020\t8\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u001c\u0010\u0018R\u0016\u0010\u001d\u001a\u00020\t8\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u001d\u0010\u0018R\u0016\u0010\u001e\u001a\u00020\t8\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u001e\u0010\u0018R\u0016\u0010\u001f\u001a\u00020\t8\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u001f\u0010\u0018R\u0016\u0010 \u001a\u00020\t8\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b \u0010\u0018¨\u0006#"}, d2 = {"Lcom/discord/widgets/botuikit/views/select/SelectComponentBottomSheet$Companion;", "", "Landroidx/fragment/app/FragmentManager;", "fragmentManager", "Lcom/discord/widgets/botuikit/views/select/ComponentContext;", "componentContext", "", "Lcom/discord/widgets/botuikit/ComponentIndex;", "componentIndex", "", "customId", "placeholder", "min", "max", "", "Lcom/discord/api/botuikit/SelectItem;", "options", "selectedItems", "", "emojiAnimationsEnabled", "", "show", "(Landroidx/fragment/app/FragmentManager;Lcom/discord/widgets/botuikit/views/select/ComponentContext;ILjava/lang/String;Ljava/lang/String;IILjava/util/List;Ljava/util/List;Z)V", "EXTRA_COMPONENT_CONTEXT", "Ljava/lang/String;", "EXTRA_COMPONENT_INDEX", "EXTRA_CUSTOM_ID", "EXTRA_EMOJI_ANIMATIONS_ENABLED", "EXTRA_MAX", "EXTRA_MIN", "EXTRA_OPTIONS", "EXTRA_PLACEHOLDER", "EXTRA_SELECTED", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public final void show(FragmentManager fragmentManager, SelectComponentBottomSheet2 componentContext, int componentIndex, String customId, String placeholder, int min, int max, List<SelectComponent2> options, List<SelectComponent2> selectedItems, boolean emojiAnimationsEnabled) {
            Intrinsics3.checkNotNullParameter(fragmentManager, "fragmentManager");
            Intrinsics3.checkNotNullParameter(componentContext, "componentContext");
            Intrinsics3.checkNotNullParameter(customId, "customId");
            Intrinsics3.checkNotNullParameter(options, "options");
            Intrinsics3.checkNotNullParameter(selectedItems, "selectedItems");
            SelectComponentBottomSheet selectComponentBottomSheet = new SelectComponentBottomSheet();
            selectComponentBottomSheet.setArguments(Bundle2.bundleOf(Tuples.to(SelectComponentBottomSheet.EXTRA_COMPONENT_CONTEXT, componentContext), Tuples.to(SelectComponentBottomSheet.EXTRA_COMPONENT_INDEX, Integer.valueOf(componentIndex)), Tuples.to(SelectComponentBottomSheet.EXTRA_CUSTOM_ID, customId), Tuples.to(SelectComponentBottomSheet.EXTRA_PLACEHOLDER, placeholder), Tuples.to(SelectComponentBottomSheet.EXTRA_MIN, Integer.valueOf(min)), Tuples.to(SelectComponentBottomSheet.EXTRA_MAX, Integer.valueOf(max)), Tuples.to(SelectComponentBottomSheet.EXTRA_OPTIONS, options), Tuples.to(SelectComponentBottomSheet.EXTRA_SELECTED, selectedItems), Tuples.to(SelectComponentBottomSheet.EXTRA_EMOJI_ANIMATIONS_ENABLED, Boolean.valueOf(emojiAnimationsEnabled))));
            selectComponentBottomSheet.show(fragmentManager, SelectComponentBottomSheet.class.getSimpleName());
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: SelectComponentBottomSheet.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.botuikit.views.select.SelectComponentBottomSheet$configureUI$1, reason: invalid class name */
    public static final class AnonymousClass1 implements View.OnClickListener {
        public AnonymousClass1() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            SelectComponentBottomSheet.access$getViewModel$p(SelectComponentBottomSheet.this).onClickSelect();
        }
    }

    /* compiled from: SelectComponentBottomSheet.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/widgets/botuikit/views/select/SelectComponentBottomSheetViewModel$ViewState;", "p1", "", "invoke", "(Lcom/discord/widgets/botuikit/views/select/SelectComponentBottomSheetViewModel$ViewState;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.botuikit.views.select.SelectComponentBottomSheet$onResume$1, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<SelectComponentBottomSheetViewModel.ViewState, Unit> {
        public AnonymousClass1(SelectComponentBottomSheet selectComponentBottomSheet) {
            super(1, selectComponentBottomSheet, SelectComponentBottomSheet.class, "configureUI", "configureUI(Lcom/discord/widgets/botuikit/views/select/SelectComponentBottomSheetViewModel$ViewState;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(SelectComponentBottomSheetViewModel.ViewState viewState) {
            invoke2(viewState);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(SelectComponentBottomSheetViewModel.ViewState viewState) {
            Intrinsics3.checkNotNullParameter(viewState, "p1");
            SelectComponentBottomSheet.access$configureUI((SelectComponentBottomSheet) this.receiver, viewState);
        }
    }

    /* compiled from: SelectComponentBottomSheet.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/widgets/botuikit/views/select/SelectComponentBottomSheetViewModel$Event;", "p1", "", "invoke", "(Lcom/discord/widgets/botuikit/views/select/SelectComponentBottomSheetViewModel$Event;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.botuikit.views.select.SelectComponentBottomSheet$onResume$2, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass2 extends FunctionReferenceImpl implements Function1<SelectComponentBottomSheetViewModel.Event, Unit> {
        public AnonymousClass2(SelectComponentBottomSheet selectComponentBottomSheet) {
            super(1, selectComponentBottomSheet, SelectComponentBottomSheet.class, "handleEvent", "handleEvent(Lcom/discord/widgets/botuikit/views/select/SelectComponentBottomSheetViewModel$Event;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(SelectComponentBottomSheetViewModel.Event event) {
            invoke2(event);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(SelectComponentBottomSheetViewModel.Event event) {
            Intrinsics3.checkNotNullParameter(event, "p1");
            SelectComponentBottomSheet.access$handleEvent((SelectComponentBottomSheet) this.receiver, event);
        }
    }

    public SelectComponentBottomSheet() {
        super(false, 1, null);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, SelectComponentBottomSheet4.INSTANCE, null, 2, null);
        this.adapter = new SelectComponentBottomSheetAdapter(new SelectComponentBottomSheet3(this));
        SelectComponentBottomSheet5 selectComponentBottomSheet5 = new SelectComponentBottomSheet5(this);
        AppViewModelDelegates3 appViewModelDelegates3 = new AppViewModelDelegates3(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection2.getOrCreateKotlinClass(SelectComponentBottomSheetViewModel.class), new SelectComponentBottomSheet$appViewModels$$inlined$viewModels$1(appViewModelDelegates3), new AppViewModelDelegates5(selectComponentBottomSheet5));
    }

    public static final /* synthetic */ void access$configureUI(SelectComponentBottomSheet selectComponentBottomSheet, SelectComponentBottomSheetViewModel.ViewState viewState) {
        selectComponentBottomSheet.configureUI(viewState);
    }

    public static final /* synthetic */ Bundle access$getArgumentsOrDefault$p(SelectComponentBottomSheet selectComponentBottomSheet) {
        return selectComponentBottomSheet.getArgumentsOrDefault();
    }

    public static final /* synthetic */ SelectComponentBottomSheetViewModel access$getViewModel$p(SelectComponentBottomSheet selectComponentBottomSheet) {
        return selectComponentBottomSheet.getViewModel();
    }

    public static final /* synthetic */ void access$handleEvent(SelectComponentBottomSheet selectComponentBottomSheet, SelectComponentBottomSheetViewModel.Event event) {
        selectComponentBottomSheet.handleEvent(event);
    }

    private final void configureUI(SelectComponentBottomSheetViewModel.ViewState viewState) {
        TextView textView = getBinding().f2532b;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.widgetSheetComponentBottomSheetPlaceholder");
        textView.setText(viewState.getTitle());
        TextView textView2 = getBinding().e;
        Intrinsics3.checkNotNullExpressionValue(textView2, "binding.widgetSheetComponentBottomSheetSubtitle");
        textView2.setVisibility(viewState.getIsMultiSelect() ? 0 : 8);
        if (viewState.getIsMultiSelect()) {
            TextView textView3 = getBinding().e;
            Intrinsics3.checkNotNullExpressionValue(textView3, "binding.widgetSheetComponentBottomSheetSubtitle");
            textView3.setText(FormatUtils.k(this, R.string.message_select_component_select_requirement, new Object[]{Integer.valueOf(viewState.getMinSelections())}, null, 4));
        }
        TextView textView4 = getBinding().d;
        Intrinsics3.checkNotNullExpressionValue(textView4, "binding.widgetSheetComponentBottomSheetSelect");
        textView4.setVisibility(true ^ viewState.getShowSelectButton() ? 4 : 0);
        getBinding().d.setOnClickListener(new AnonymousClass1());
        TextView textView5 = getBinding().d;
        Intrinsics3.checkNotNullExpressionValue(textView5, "binding.widgetSheetComponentBottomSheetSelect");
        ViewExtensions.setEnabledAlpha(textView5, viewState.getIsValidSelection(), 0.3f);
        TextView textView6 = getBinding().d;
        Intrinsics3.checkNotNullExpressionValue(textView6, "binding.widgetSheetComponentBottomSheetSelect");
        textView6.setClickable(viewState.getIsValidSelection());
        this.adapter.setItems(viewState.getItems(), viewState.getMaxSelections(), viewState.getEmojiAnimationsEnabled());
    }

    private final WidgetSelectComponentBottomSheetBinding getBinding() {
        return (WidgetSelectComponentBottomSheetBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final SelectComponentBottomSheetViewModel getViewModel() {
        return (SelectComponentBottomSheetViewModel) this.viewModel.getValue();
    }

    private final void handleEvent(SelectComponentBottomSheetViewModel.Event event) {
        if (Intrinsics3.areEqual(event, SelectComponentBottomSheetViewModel.Event.CloseSheet.INSTANCE)) {
            dismiss();
        }
    }

    @Override // com.discord.app.AppBottomSheet
    public int getContentViewResId() {
        return R.layout.widget_select_component_bottom_sheet;
    }

    public final void onItemSelected(SelectComponent2 item, boolean isSelected) {
        Intrinsics3.checkNotNullParameter(item, "item");
        getViewModel().selectItem(item, isSelected);
    }

    @Override // com.discord.app.AppBottomSheet, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeViewState(), this, null, 2, null), SelectComponentBottomSheet.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(this), 62, (Object) null);
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeEvents(), this, null, 2, null), SelectComponentBottomSheet.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass2(this), 62, (Object) null);
    }

    @Override // com.discord.app.AppBottomSheet, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        setBottomSheetCollapsedStateDisabled();
        MaxHeightRecyclerView maxHeightRecyclerView = getBinding().c;
        Intrinsics3.checkNotNullExpressionValue(maxHeightRecyclerView, "binding.widgetSheetComponentBottomSheetRecycler");
        maxHeightRecyclerView.setAdapter(this.adapter);
    }
}
