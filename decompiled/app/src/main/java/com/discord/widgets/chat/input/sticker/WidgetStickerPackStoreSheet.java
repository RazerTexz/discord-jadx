package com.discord.widgets.chat.input.sticker;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.recyclerview.widget.RecyclerView;
import b.a.d.AppViewModelDelegates3;
import b.a.d.AppViewModelDelegates5;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.api.premium.PremiumTier;
import com.discord.api.sticker.Sticker;
import com.discord.api.sticker.StickerType;
import com.discord.app.AppBottomSheet;
import com.discord.databinding.WidgetStickerPackStoreSheetBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.dimen.DimenUtils;
import com.discord.utilities.images.MGImages;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.stickers.StickerUtils;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.views.LoadingButton;
import com.discord.widgets.chat.input.sticker.StickerFullSizeDialog;
import com.discord.widgets.chat.input.sticker.StickerPackStoreSheetViewModel;
import com.discord.widgets.settings.premium.WidgetSettingsPremium;
import com.discord.widgets.stickers.StickerPurchaseLocation;
import com.discord.widgets.stickers.WidgetStickerPackDetailsDialog;
import com.facebook.drawee.view.SimpleDraweeView;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import d0.z.d.Reflection2;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;

/* compiled from: WidgetStickerPackStoreSheet.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 +2\u00020\u0001:\u0001+B\u0007¢\u0006\u0004\b*\u0010\u001aJ\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u0010\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0012\u0010\u0011J!\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u00132\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u0019\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0019\u0010\u001aR\u001d\u0010 \u001a\u00020\u001b8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u0016\u0010\"\u001a\u00020!8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\"\u0010#R\u001d\u0010)\u001a\u00020$8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(¨\u0006,"}, d2 = {"Lcom/discord/widgets/chat/input/sticker/WidgetStickerPackStoreSheet;", "Lcom/discord/app/AppBottomSheet;", "Lcom/discord/widgets/chat/input/sticker/StickerPackStoreSheetViewModel$ViewState;", "viewState", "", "configureUI", "(Lcom/discord/widgets/chat/input/sticker/StickerPackStoreSheetViewModel$ViewState;)V", "Lcom/discord/widgets/chat/input/sticker/StoreHeaderItem;", "storeHeaderItem", "onStickerHeaderItemsClicked", "(Lcom/discord/widgets/chat/input/sticker/StoreHeaderItem;)V", "Lcom/discord/widgets/chat/input/sticker/StickerItem;", "stickerItem", "onStickerItemSelected", "(Lcom/discord/widgets/chat/input/sticker/StickerItem;)V", "", "getAdditionalBottomPaddingPx", "()I", "getContentViewResId", "Landroid/view/View;", "view", "Landroid/os/Bundle;", "savedInstanceState", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "onResume", "()V", "Lcom/discord/widgets/chat/input/sticker/StickerPackStoreSheetViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "getViewModel", "()Lcom/discord/widgets/chat/input/sticker/StickerPackStoreSheetViewModel;", "viewModel", "Lcom/discord/widgets/chat/input/sticker/WidgetStickerAdapter;", "adapter", "Lcom/discord/widgets/chat/input/sticker/WidgetStickerAdapter;", "Lcom/discord/databinding/WidgetStickerPackStoreSheetBinding;", "binding$delegate", "Lcom/discord/utilities/viewbinding/FragmentViewBindingDelegate;", "getBinding", "()Lcom/discord/databinding/WidgetStickerPackStoreSheetBinding;", "binding", "<init>", "Companion", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class WidgetStickerPackStoreSheet extends AppBottomSheet {
    private static final String ANALYTICS_LOCATION = "widget_sticker_pack_Store_sheet_analytics_location";
    private static final String ANALYTICS_LOCATION_SECTION = "widget_sticker_pack_Store_sheet_analytics_location_section";
    private static final String VIEW_TYPE = "widget_sticker_pack_store_sheet_view_type";
    private WidgetStickerAdapter adapter;

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetStickerPackStoreSheet.class, "binding", "getBinding()Lcom/discord/databinding/WidgetStickerPackStoreSheetBinding;", 0)};

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* compiled from: WidgetStickerPackStoreSheet.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0013\u0010\u0014J?\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0007¢\u0006\u0004\b\r\u0010\u000eR\u0016\u0010\u000f\u001a\u00020\b8\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0011\u001a\u00020\b8\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0011\u0010\u0010R\u0016\u0010\u0012\u001a\u00020\b8\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0012\u0010\u0010¨\u0006\u0015"}, d2 = {"Lcom/discord/widgets/chat/input/sticker/WidgetStickerPackStoreSheet$Companion;", "", "Landroidx/fragment/app/FragmentManager;", "fragmentManager", "Lcom/discord/api/sticker/Sticker;", "sticker", "Lcom/discord/widgets/chat/input/sticker/StickerPackStoreSheetViewType;", "viewType", "", ModelAuditLogEntry.CHANGE_KEY_LOCATION, "Lcom/discord/widgets/stickers/StickerPurchaseLocation;", "purchaseLocation", "", "show", "(Landroidx/fragment/app/FragmentManager;Lcom/discord/api/sticker/Sticker;Lcom/discord/widgets/chat/input/sticker/StickerPackStoreSheetViewType;Ljava/lang/String;Lcom/discord/widgets/stickers/StickerPurchaseLocation;)V", "ANALYTICS_LOCATION", "Ljava/lang/String;", "ANALYTICS_LOCATION_SECTION", WidgetStickerPicker.VIEW_TYPE, "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public static /* synthetic */ void show$default(Companion companion, FragmentManager fragmentManager, Sticker sticker, WidgetStickerPackStoreSheet2 widgetStickerPackStoreSheet2, String str, StickerPurchaseLocation stickerPurchaseLocation, int i, Object obj) {
            companion.show(fragmentManager, sticker, widgetStickerPackStoreSheet2, (i & 8) != 0 ? null : str, (i & 16) != 0 ? null : stickerPurchaseLocation);
        }

        public final void show(FragmentManager fragmentManager, Sticker sticker, WidgetStickerPackStoreSheet2 viewType, String location, StickerPurchaseLocation purchaseLocation) {
            Intrinsics3.checkNotNullParameter(fragmentManager, "fragmentManager");
            Intrinsics3.checkNotNullParameter(sticker, "sticker");
            Intrinsics3.checkNotNullParameter(viewType, "viewType");
            if (sticker.getType() != StickerType.STANDARD) {
                return;
            }
            WidgetStickerPackStoreSheet widgetStickerPackStoreSheet = new WidgetStickerPackStoreSheet();
            Bundle bundle = new Bundle();
            bundle.putSerializable("com.discord.intent.extra.EXTRA_STICKER", sticker);
            bundle.putSerializable(WidgetStickerPackStoreSheet.VIEW_TYPE, viewType);
            bundle.putString(WidgetStickerPackStoreSheet.ANALYTICS_LOCATION, location);
            bundle.putSerializable(WidgetStickerPackStoreSheet.ANALYTICS_LOCATION_SECTION, purchaseLocation);
            widgetStickerPackStoreSheet.setArguments(bundle);
            widgetStickerPackStoreSheet.show(fragmentManager, WidgetStickerPackStoreSheet.class.getName());
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetStickerPackStoreSheet.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.chat.input.sticker.WidgetStickerPackStoreSheet$configureUI$1, reason: invalid class name */
    public static final class AnonymousClass1 implements View.OnClickListener {
        public final /* synthetic */ StickerPackStoreSheetViewModel.ViewState $viewState;

        public AnonymousClass1(StickerPackStoreSheetViewModel.ViewState viewState) {
            this.$viewState = viewState;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            if (!this.$viewState.isPackEnabled() || this.$viewState.canUserAccessToPremiumStickers()) {
                return;
            }
            WidgetSettingsPremium.Companion companion = WidgetSettingsPremium.INSTANCE;
            Context contextRequireContext = WidgetStickerPackStoreSheet.this.requireContext();
            Intrinsics3.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
            WidgetSettingsPremium.Companion.launch$default(companion, contextRequireContext, 1, null, 4, null);
        }
    }

    /* compiled from: WidgetStickerPackStoreSheet.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/widgets/chat/input/sticker/StickerPackStoreSheetViewModel$ViewState;", "p1", "", "invoke", "(Lcom/discord/widgets/chat/input/sticker/StickerPackStoreSheetViewModel$ViewState;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.chat.input.sticker.WidgetStickerPackStoreSheet$onResume$1, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<StickerPackStoreSheetViewModel.ViewState, Unit> {
        public AnonymousClass1(WidgetStickerPackStoreSheet widgetStickerPackStoreSheet) {
            super(1, widgetStickerPackStoreSheet, WidgetStickerPackStoreSheet.class, "configureUI", "configureUI(Lcom/discord/widgets/chat/input/sticker/StickerPackStoreSheetViewModel$ViewState;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(StickerPackStoreSheetViewModel.ViewState viewState) {
            invoke2(viewState);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(StickerPackStoreSheetViewModel.ViewState viewState) {
            WidgetStickerPackStoreSheet.access$configureUI((WidgetStickerPackStoreSheet) this.receiver, viewState);
        }
    }

    /* compiled from: WidgetStickerPackStoreSheet.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/widgets/chat/input/sticker/StickerItem;", "p1", "", "invoke", "(Lcom/discord/widgets/chat/input/sticker/StickerItem;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.chat.input.sticker.WidgetStickerPackStoreSheet$onViewCreated$1, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<StickerAdapterItems3, Unit> {
        public AnonymousClass1(WidgetStickerPackStoreSheet widgetStickerPackStoreSheet) {
            super(1, widgetStickerPackStoreSheet, WidgetStickerPackStoreSheet.class, "onStickerItemSelected", "onStickerItemSelected(Lcom/discord/widgets/chat/input/sticker/StickerItem;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(StickerAdapterItems3 stickerAdapterItems3) {
            invoke2(stickerAdapterItems3);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(StickerAdapterItems3 stickerAdapterItems3) {
            Intrinsics3.checkNotNullParameter(stickerAdapterItems3, "p1");
            WidgetStickerPackStoreSheet.access$onStickerItemSelected((WidgetStickerPackStoreSheet) this.receiver, stickerAdapterItems3);
        }
    }

    /* compiled from: WidgetStickerPackStoreSheet.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/widgets/chat/input/sticker/StoreHeaderItem;", "p1", "", "invoke", "(Lcom/discord/widgets/chat/input/sticker/StoreHeaderItem;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.chat.input.sticker.WidgetStickerPackStoreSheet$onViewCreated$2, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass2 extends FunctionReferenceImpl implements Function1<StickerAdapterItems4, Unit> {
        public AnonymousClass2(WidgetStickerPackStoreSheet widgetStickerPackStoreSheet) {
            super(1, widgetStickerPackStoreSheet, WidgetStickerPackStoreSheet.class, "onStickerHeaderItemsClicked", "onStickerHeaderItemsClicked(Lcom/discord/widgets/chat/input/sticker/StoreHeaderItem;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(StickerAdapterItems4 stickerAdapterItems4) {
            invoke2(stickerAdapterItems4);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(StickerAdapterItems4 stickerAdapterItems4) {
            Intrinsics3.checkNotNullParameter(stickerAdapterItems4, "p1");
            WidgetStickerPackStoreSheet.access$onStickerHeaderItemsClicked((WidgetStickerPackStoreSheet) this.receiver, stickerAdapterItems4);
        }
    }

    public WidgetStickerPackStoreSheet() {
        super(false, 1, null);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetStickerPackStoreSheet3.INSTANCE, null, 2, null);
        WidgetStickerPackStoreSheet4 widgetStickerPackStoreSheet4 = new WidgetStickerPackStoreSheet4(this);
        AppViewModelDelegates3 appViewModelDelegates3 = new AppViewModelDelegates3(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection2.getOrCreateKotlinClass(StickerPackStoreSheetViewModel.class), new WidgetStickerPackStoreSheet$appViewModels$$inlined$viewModels$1(appViewModelDelegates3), new AppViewModelDelegates5(widgetStickerPackStoreSheet4));
    }

    public static final /* synthetic */ void access$configureUI(WidgetStickerPackStoreSheet widgetStickerPackStoreSheet, StickerPackStoreSheetViewModel.ViewState viewState) {
        widgetStickerPackStoreSheet.configureUI(viewState);
    }

    public static final /* synthetic */ void access$onStickerHeaderItemsClicked(WidgetStickerPackStoreSheet widgetStickerPackStoreSheet, StickerAdapterItems4 stickerAdapterItems4) {
        widgetStickerPackStoreSheet.onStickerHeaderItemsClicked(stickerAdapterItems4);
    }

    public static final /* synthetic */ void access$onStickerItemSelected(WidgetStickerPackStoreSheet widgetStickerPackStoreSheet, StickerAdapterItems3 stickerAdapterItems3) {
        widgetStickerPackStoreSheet.onStickerItemSelected(stickerAdapterItems3);
    }

    private final void configureUI(StickerPackStoreSheetViewModel.ViewState viewState) {
        if (viewState != null) {
            setBottomSheetState(3);
            WidgetStickerAdapter widgetStickerAdapter = this.adapter;
            if (widgetStickerAdapter == null) {
                Intrinsics3.throwUninitializedPropertyAccessException("adapter");
            }
            widgetStickerAdapter.setData(viewState.getStickerItems());
            StickerUtils stickerUtils = StickerUtils.INSTANCE;
            Context contextRequireContext = requireContext();
            Intrinsics3.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
            CharSequence stickerPackPremiumPriceLabel = stickerUtils.getStickerPackPremiumPriceLabel(contextRequireContext, viewState.getStickerPack(), viewState.getMeUserPremiumTier(), viewState.isPackEnabled());
            boolean zIsStickerPackFreeForPremiumTier = stickerUtils.isStickerPackFreeForPremiumTier(viewState.getStickerPack(), PremiumTier.PREMIUM_GUILD_SUBSCRIPTION_ONLY);
            getBinding().e.setText(stickerPackPremiumPriceLabel);
            LoadingButton loadingButton = getBinding().e;
            Intrinsics3.checkNotNullExpressionValue(loadingButton, "binding.stickerStoreBuyButtonPremium");
            loadingButton.setVisibility(viewState.isPackEnabled() && !viewState.canUserAccessToPremiumStickers() ? 0 : 8);
            getBinding().e.setOnClickListener(new AnonymousClass1(viewState));
            LoadingButton loadingButton2 = getBinding().e;
            Intrinsics3.checkNotNullExpressionValue(loadingButton2, "binding.stickerStoreBuyButtonPremium");
            loadingButton2.setEnabled(true);
            getBinding().e.setIsLoading(false);
            getBinding().e.setIconVisibility(!zIsStickerPackFreeForPremiumTier);
            String bannerCDNAssetUrl = stickerUtils.getBannerCDNAssetUrl(viewState.getStickerPack(), 1024);
            if (!(bannerCDNAssetUrl.length() > 0)) {
                SimpleDraweeView simpleDraweeView = getBinding().d;
                Intrinsics3.checkNotNullExpressionValue(simpleDraweeView, "binding.stickerPackViewAllBanner");
                simpleDraweeView.setVisibility(8);
            } else {
                SimpleDraweeView simpleDraweeView2 = getBinding().d;
                Intrinsics3.checkNotNullExpressionValue(simpleDraweeView2, "binding.stickerPackViewAllBanner");
                MGImages.setImage$default(simpleDraweeView2, bannerCDNAssetUrl, 0, 0, false, null, null, 124, null);
                SimpleDraweeView simpleDraweeView3 = getBinding().d;
                Intrinsics3.checkNotNullExpressionValue(simpleDraweeView3, "binding.stickerPackViewAllBanner");
                simpleDraweeView3.setVisibility(0);
            }
        }
    }

    private final int getAdditionalBottomPaddingPx() {
        if (Build.VERSION.SDK_INT >= 29) {
            return DimenUtils.dpToPixels(8);
        }
        return 0;
    }

    private final WidgetStickerPackStoreSheetBinding getBinding() {
        return (WidgetStickerPackStoreSheetBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final StickerPackStoreSheetViewModel getViewModel() {
        return (StickerPackStoreSheetViewModel) this.viewModel.getValue();
    }

    private final void onStickerHeaderItemsClicked(StickerAdapterItems4 storeHeaderItem) {
        WidgetStickerPackDetailsDialog.Companion companion = WidgetStickerPackDetailsDialog.INSTANCE;
        FragmentManager childFragmentManager = getChildFragmentManager();
        Intrinsics3.checkNotNullExpressionValue(childFragmentManager, "childFragmentManager");
        companion.show(childFragmentManager, storeHeaderItem.getPack().getId(), Integer.valueOf(DimenUtils.dpToPixels(80)));
    }

    private final void onStickerItemSelected(StickerAdapterItems3 stickerItem) {
        StickerFullSizeDialog.Companion companion = StickerFullSizeDialog.INSTANCE;
        FragmentManager childFragmentManager = getChildFragmentManager();
        Intrinsics3.checkNotNullExpressionValue(childFragmentManager, "childFragmentManager");
        companion.show(childFragmentManager, stickerItem.getSticker());
    }

    public static final void show(FragmentManager fragmentManager, Sticker sticker, WidgetStickerPackStoreSheet2 widgetStickerPackStoreSheet2, String str, StickerPurchaseLocation stickerPurchaseLocation) {
        INSTANCE.show(fragmentManager, sticker, widgetStickerPackStoreSheet2, str, stickerPurchaseLocation);
    }

    @Override // com.discord.app.AppBottomSheet
    public int getContentViewResId() {
        return R.layout.widget_sticker_pack_store_sheet;
    }

    @Override // com.discord.app.AppBottomSheet, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeViewState(), this, null, 2, null), WidgetStickerPackStoreSheet.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(this), 62, (Object) null);
    }

    @Override // com.discord.app.AppBottomSheet, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        RelativeLayout relativeLayout = getBinding().f2660b;
        Intrinsics3.checkNotNullExpressionValue(relativeLayout, "binding.stickerPackStoreSheetContainer");
        relativeLayout.setPadding(relativeLayout.getPaddingLeft(), relativeLayout.getPaddingTop(), relativeLayout.getPaddingRight(), getAdditionalBottomPaddingPx());
        RecyclerView recyclerView = getBinding().c;
        Intrinsics3.checkNotNullExpressionValue(recyclerView, "binding.stickerPackStoreSheetRecycler");
        this.adapter = new WidgetStickerAdapter(recyclerView, new AnonymousClass1(this), new AnonymousClass2(this), null, this, true, 8, null);
        getViewModel().fetchStickersData();
    }
}
