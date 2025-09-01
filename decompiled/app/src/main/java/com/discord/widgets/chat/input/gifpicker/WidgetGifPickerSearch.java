package com.discord.widgets.chat.input.gifpicker;

import android.content.Context;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import b.a.d.AppViewModelDelegates3;
import b.a.d.AppViewModelDelegates5;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.app.AppFragment;
import com.discord.app.AppViewFlipper;
import com.discord.databinding.WidgetGifPickerSearchBinding;
import com.discord.utilities.dimen.DimenUtils;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.views.SearchInputView;
import com.discord.widgets.chat.input.gifpicker.GifAdapter;
import com.discord.widgets.chat.input.gifpicker.GifAdapterItem;
import com.discord.widgets.chat.input.gifpicker.GifSearchViewModel;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import d0.z.d.Reflection2;
import defpackage.GifStaggeredGridItemDecoration;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KProperty;
import rx.Observable;

/* compiled from: WidgetGifPickerSearch.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b(\u0010\bJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0011\u0010\bJ\u001b\u0010\u0014\u001a\u00020\u00042\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00040\u0012¢\u0006\u0004\b\u0014\u0010\u0015J\r\u0010\u0016\u001a\u00020\u0004¢\u0006\u0004\b\u0016\u0010\bR\u0016\u0010\u0018\u001a\u00020\u00178\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u001e\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u001d\u0010!\u001a\u00020\u001c8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u001d\u0010'\u001a\u00020\"8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&¨\u0006)"}, d2 = {"Lcom/discord/widgets/chat/input/gifpicker/WidgetGifPickerSearch;", "Lcom/discord/app/AppFragment;", "Lcom/discord/widgets/chat/input/gifpicker/GifSearchViewModel$ViewState;", "viewState", "", "handleViewState", "(Lcom/discord/widgets/chat/input/gifpicker/GifSearchViewModel$ViewState;)V", "setupSearchBar", "()V", "", "categoryColumnsCount", "setUpGifRecycler", "(I)V", "Landroid/view/View;", "view", "onViewBound", "(Landroid/view/View;)V", "onViewBoundOrOnResume", "Lkotlin/Function0;", "onSelected", "setOnGifSelected", "(Lkotlin/jvm/functions/Function0;)V", "clearSearchBar", "Lcom/discord/widgets/chat/input/gifpicker/GifAdapter;", "gifAdapter", "Lcom/discord/widgets/chat/input/gifpicker/GifAdapter;", "onGifSelected", "Lkotlin/jvm/functions/Function0;", "Lcom/discord/widgets/chat/input/gifpicker/GifSearchViewModel;", "gifPickerViewModel$delegate", "Lkotlin/Lazy;", "getGifPickerViewModel", "()Lcom/discord/widgets/chat/input/gifpicker/GifSearchViewModel;", "gifPickerViewModel", "Lcom/discord/databinding/WidgetGifPickerSearchBinding;", "binding$delegate", "Lcom/discord/utilities/viewbinding/FragmentViewBindingDelegate;", "getBinding", "()Lcom/discord/databinding/WidgetGifPickerSearchBinding;", "binding", "<init>", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class WidgetGifPickerSearch extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetGifPickerSearch.class, "binding", "getBinding()Lcom/discord/databinding/WidgetGifPickerSearchBinding;", 0)};

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private GifAdapter gifAdapter;

    /* renamed from: gifPickerViewModel$delegate, reason: from kotlin metadata */
    private final Lazy gifPickerViewModel;
    private Function0<Unit> onGifSelected;

    /* compiled from: WidgetGifPickerSearch.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/discord/widgets/chat/input/gifpicker/GifSearchViewModel$ViewState;", "kotlin.jvm.PlatformType", "viewState", "", "invoke", "(Lcom/discord/widgets/chat/input/gifpicker/GifSearchViewModel$ViewState;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.chat.input.gifpicker.WidgetGifPickerSearch$onViewBoundOrOnResume$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<GifSearchViewModel.ViewState, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(GifSearchViewModel.ViewState viewState) {
            invoke2(viewState);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(GifSearchViewModel.ViewState viewState) {
            WidgetGifPickerSearch widgetGifPickerSearch = WidgetGifPickerSearch.this;
            Intrinsics3.checkNotNullExpressionValue(viewState, "viewState");
            WidgetGifPickerSearch.access$handleViewState(widgetGifPickerSearch, viewState);
        }
    }

    /* compiled from: WidgetGifPickerSearch.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/widgets/chat/input/gifpicker/GifAdapterItem$GifItem;", "gifItem", "", "invoke", "(Lcom/discord/widgets/chat/input/gifpicker/GifAdapterItem$GifItem;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.chat.input.gifpicker.WidgetGifPickerSearch$setUpGifRecycler$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<GifAdapterItem.GifItem, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(GifAdapterItem.GifItem gifItem) {
            invoke2(gifItem);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(GifAdapterItem.GifItem gifItem) {
            Intrinsics3.checkNotNullParameter(gifItem, "gifItem");
            WidgetGifPickerSearch.access$getGifPickerViewModel$p(WidgetGifPickerSearch.this).selectGif(gifItem);
            Function0 function0Access$getOnGifSelected$p = WidgetGifPickerSearch.access$getOnGifSelected$p(WidgetGifPickerSearch.this);
            if (function0Access$getOnGifSelected$p != null) {
            }
        }
    }

    /* compiled from: WidgetGifPickerSearch.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "p1", "", "invoke", "(Ljava/lang/String;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.chat.input.gifpicker.WidgetGifPickerSearch$setUpGifRecycler$2, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass2 extends FunctionReferenceImpl implements Function1<String, Unit> {
        public AnonymousClass2(SearchInputView searchInputView) {
            super(1, searchInputView, SearchInputView.class, "setText", "setText(Ljava/lang/String;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(String str) {
            invoke2(str);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(String str) {
            Intrinsics3.checkNotNullParameter(str, "p1");
            ((SearchInputView) this.receiver).setText(str);
        }
    }

    /* compiled from: WidgetGifPickerSearch.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "searchQuery", "", "invoke", "(Ljava/lang/String;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.chat.input.gifpicker.WidgetGifPickerSearch$setupSearchBar$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<String, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(String str) {
            invoke2(str);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(String str) {
            Intrinsics3.checkNotNullParameter(str, "searchQuery");
            WidgetGifPickerSearch.access$getGifPickerViewModel$p(WidgetGifPickerSearch.this).setSearchText(str);
        }
    }

    public WidgetGifPickerSearch() {
        super(R.layout.widget_gif_picker_search);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetGifPickerSearch2.INSTANCE, null, 2, null);
        WidgetGifPickerSearch3 widgetGifPickerSearch3 = new WidgetGifPickerSearch3(this);
        AppViewModelDelegates3 appViewModelDelegates3 = new AppViewModelDelegates3(this);
        this.gifPickerViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection2.getOrCreateKotlinClass(GifSearchViewModel.class), new WidgetGifPickerSearch$appViewModels$$inlined$viewModels$1(appViewModelDelegates3), new AppViewModelDelegates5(widgetGifPickerSearch3));
    }

    public static final /* synthetic */ GifSearchViewModel access$getGifPickerViewModel$p(WidgetGifPickerSearch widgetGifPickerSearch) {
        return widgetGifPickerSearch.getGifPickerViewModel();
    }

    public static final /* synthetic */ Function0 access$getOnGifSelected$p(WidgetGifPickerSearch widgetGifPickerSearch) {
        return widgetGifPickerSearch.onGifSelected;
    }

    public static final /* synthetic */ void access$handleViewState(WidgetGifPickerSearch widgetGifPickerSearch, GifSearchViewModel.ViewState viewState) {
        widgetGifPickerSearch.handleViewState(viewState);
    }

    public static final /* synthetic */ void access$setOnGifSelected$p(WidgetGifPickerSearch widgetGifPickerSearch, Function0 function0) {
        widgetGifPickerSearch.onGifSelected = function0;
    }

    private final WidgetGifPickerSearchBinding getBinding() {
        return (WidgetGifPickerSearchBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final GifSearchViewModel getGifPickerViewModel() {
        return (GifSearchViewModel) this.gifPickerViewModel.getValue();
    }

    private final void handleViewState(GifSearchViewModel.ViewState viewState) {
        if (viewState instanceof GifSearchViewModel.ViewState.Loaded) {
            GifAdapter gifAdapter = this.gifAdapter;
            if (gifAdapter == null) {
                Intrinsics3.throwUninitializedPropertyAccessException("gifAdapter");
            }
            gifAdapter.setItems(((GifSearchViewModel.ViewState.Loaded) viewState).getAdapterItems());
            AppViewFlipper appViewFlipper = getBinding().d;
            Intrinsics3.checkNotNullExpressionValue(appViewFlipper, "binding.gifSearchViewFlipper");
            appViewFlipper.setDisplayedChild(0);
            return;
        }
        if (Intrinsics3.areEqual(viewState, GifSearchViewModel.ViewState.LoadingSearchResults.INSTANCE)) {
            GifAdapter gifAdapter2 = this.gifAdapter;
            if (gifAdapter2 == null) {
                Intrinsics3.throwUninitializedPropertyAccessException("gifAdapter");
            }
            gifAdapter2.clearItems();
            AppViewFlipper appViewFlipper2 = getBinding().d;
            Intrinsics3.checkNotNullExpressionValue(appViewFlipper2, "binding.gifSearchViewFlipper");
            appViewFlipper2.setDisplayedChild(1);
        }
    }

    private final void setUpGifRecycler(int categoryColumnsCount) {
        RecyclerView recyclerView = getBinding().f2402b;
        Intrinsics3.checkNotNullExpressionValue(recyclerView, "binding.gifSearchGifRecycler");
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(categoryColumnsCount, 1));
        RecyclerView recyclerView2 = getBinding().f2402b;
        Intrinsics3.checkNotNullExpressionValue(recyclerView2, "binding.gifSearchGifRecycler");
        recyclerView2.setItemAnimator(null);
        int iDpToPixels = DimenUtils.dpToPixels(8);
        AnonymousClass1 anonymousClass1 = new AnonymousClass1();
        GifAdapter.Companion companion = GifAdapter.INSTANCE;
        RecyclerView recyclerView3 = getBinding().f2402b;
        Intrinsics3.checkNotNullExpressionValue(recyclerView3, "binding.gifSearchGifRecycler");
        this.gifAdapter = new GifAdapter(this, anonymousClass1, companion.calculateColumnWidth(recyclerView3, categoryColumnsCount, iDpToPixels), new AnonymousClass2(getBinding().e), null, 16, null);
        RecyclerView recyclerView4 = getBinding().f2402b;
        Intrinsics3.checkNotNullExpressionValue(recyclerView4, "binding.gifSearchGifRecycler");
        GifAdapter gifAdapter = this.gifAdapter;
        if (gifAdapter == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("gifAdapter");
        }
        recyclerView4.setAdapter(gifAdapter);
        getBinding().f2402b.addItemDecoration(new GifStaggeredGridItemDecoration(iDpToPixels, categoryColumnsCount));
    }

    private final void setupSearchBar() {
        getBinding().e.a(this, new AnonymousClass1());
    }

    public final void clearSearchBar() {
        getGifPickerViewModel().setSearchText("");
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        GifAdapter.Companion companion = GifAdapter.INSTANCE;
        RecyclerView recyclerView = getBinding().f2402b;
        Intrinsics3.checkNotNullExpressionValue(recyclerView, "binding.gifSearchGifRecycler");
        int iCalculateColumnCount = companion.calculateColumnCount(recyclerView);
        setUpGifRecycler(iCalculateColumnCount);
        setupSearchBar();
        GifLoadingView.updateView$default(getBinding().c, iCalculateColumnCount, 0, 2, null);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        getBinding().e.binding.c.requestFocus();
        Observable<GifSearchViewModel.ViewState> observableR = getGifPickerViewModel().observeViewState().r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "gifPickerViewModel\n     …  .distinctUntilChanged()");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(observableR, this, null, 2, null), WidgetGifPickerSearch.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(), 62, (Object) null);
    }

    public final void setOnGifSelected(Function0<Unit> onSelected) {
        Intrinsics3.checkNotNullParameter(onSelected, "onSelected");
        this.onGifSelected = onSelected;
    }
}
