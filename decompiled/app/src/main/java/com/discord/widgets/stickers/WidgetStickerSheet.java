package com.discord.widgets.stickers;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import b.a.d.AppViewModelDelegates3;
import b.a.d.AppViewModelDelegates5;
import b.a.k.FormatUtils;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.api.channel.Channel;
import com.discord.api.premium.PremiumTier;
import com.discord.api.sticker.Sticker;
import com.discord.api.sticker.StickerType;
import com.discord.app.AppBottomSheet;
import com.discord.databinding.WidgetStickerSheetBinding;
import com.discord.i18n.RenderContext;
import com.discord.models.sticker.dto.ModelStickerPack;
import com.discord.stores.StoreStream;
import com.discord.utilities.analytics.Traits;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.stickers.StickerUtils;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.views.LoadingButton;
import com.discord.widgets.chat.input.expression.ExpressionPickerEvent;
import com.discord.widgets.chat.input.expression.ExpressionPickerEventBus;
import com.discord.widgets.chat.input.sticker.WidgetStickerPackStoreSheet;
import com.discord.widgets.chat.input.sticker.WidgetStickerPackStoreSheet2;
import com.discord.widgets.settings.premium.WidgetSettingsPremium;
import com.discord.widgets.stickers.StickerPremiumUpsellDialog;
import com.discord.widgets.stickers.StickerSheetViewModel;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.chip.Chip;
import d0.z.d.FunctionReferenceImpl;
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
import rx.Observable;
import rx.subscriptions.CompositeSubscription;

/* compiled from: WidgetStickerSheet.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB\u0007¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\f\u0010\rR\u001d\u0010\u0013\u001a\u00020\u000e8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001d\u0010\u0019\u001a\u00020\u00148B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018¨\u0006\u001d"}, d2 = {"Lcom/discord/widgets/stickers/WidgetStickerSheet;", "Lcom/discord/app/AppBottomSheet;", "Lcom/discord/widgets/stickers/StickerSheetViewModel$ViewState;", "viewState", "", "configureUI", "(Lcom/discord/widgets/stickers/StickerSheetViewModel$ViewState;)V", "", "getContentViewResId", "()I", "Lrx/subscriptions/CompositeSubscription;", "compositeSubscription", "bindSubscriptions", "(Lrx/subscriptions/CompositeSubscription;)V", "Lcom/discord/widgets/stickers/StickerSheetViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "getViewModel", "()Lcom/discord/widgets/stickers/StickerSheetViewModel;", "viewModel", "Lcom/discord/databinding/WidgetStickerSheetBinding;", "binding$delegate", "Lcom/discord/utilities/viewbinding/FragmentViewBindingDelegate;", "getBinding", "()Lcom/discord/databinding/WidgetStickerSheetBinding;", "binding", "<init>", "()V", "Companion", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final class WidgetStickerSheet extends AppBottomSheet {
    private static final String ANALYTICS_LOCATION = "widget_sticker_sheet_analytics_location";

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetStickerSheet.class, "binding", "getBinding()Lcom/discord/databinding/WidgetStickerSheetBinding;", 0)};

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* compiled from: WidgetStickerSheet.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000f\u0010\u0010J+\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\n\u0010\b\u001a\u00060\u0006j\u0002`\u0007H\u0007¢\u0006\u0004\b\n\u0010\u000bR\u0016\u0010\r\u001a\u00020\f8\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\r\u0010\u000e¨\u0006\u0011"}, d2 = {"Lcom/discord/widgets/stickers/WidgetStickerSheet$Companion;", "", "Landroidx/fragment/app/FragmentManager;", "fragmentManager", "Lcom/discord/api/sticker/Sticker;", "sticker", "", "Lcom/discord/primitives/ChannelId;", "channelId", "", "show", "(Landroidx/fragment/app/FragmentManager;Lcom/discord/api/sticker/Sticker;J)V", "", "ANALYTICS_LOCATION", "Ljava/lang/String;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public final void show(FragmentManager fragmentManager, Sticker sticker, long channelId) {
            Channel channelFindChannelById;
            Intrinsics3.checkNotNullParameter(fragmentManager, "fragmentManager");
            Intrinsics3.checkNotNullParameter(sticker, "sticker");
            if (sticker.getType() == StickerType.STANDARD && (channelFindChannelById = StoreStream.INSTANCE.getChannels().findChannelById(channelId)) != null) {
                String str = channelFindChannelById.getGuildId() == 0 ? "DM Channel" : Traits.Location.Page.GUILD_CHANNEL;
                WidgetStickerSheet widgetStickerSheet = new WidgetStickerSheet();
                Bundle bundle = new Bundle();
                bundle.putSerializable("com.discord.intent.extra.EXTRA_STICKER", sticker);
                bundle.putString(WidgetStickerSheet.ANALYTICS_LOCATION, str);
                widgetStickerSheet.setArguments(bundle);
                widgetStickerSheet.show(fragmentManager, WidgetStickerSheet.class.getName());
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetStickerSheet.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/widgets/stickers/StickerSheetViewModel$ViewState;", "p1", "", "invoke", "(Lcom/discord/widgets/stickers/StickerSheetViewModel$ViewState;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.stickers.WidgetStickerSheet$bindSubscriptions$1, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<StickerSheetViewModel.ViewState, Unit> {
        public AnonymousClass1(WidgetStickerSheet widgetStickerSheet) {
            super(1, widgetStickerSheet, WidgetStickerSheet.class, "configureUI", "configureUI(Lcom/discord/widgets/stickers/StickerSheetViewModel$ViewState;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(StickerSheetViewModel.ViewState viewState) {
            invoke2(viewState);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(StickerSheetViewModel.ViewState viewState) {
            Intrinsics3.checkNotNullParameter(viewState, "p1");
            WidgetStickerSheet.access$configureUI((WidgetStickerSheet) this.receiver, viewState);
        }
    }

    /* compiled from: WidgetStickerSheet.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.stickers.WidgetStickerSheet$configureUI$1, reason: invalid class name */
    public static final class AnonymousClass1 implements View.OnClickListener {
        public AnonymousClass1() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetSettingsPremium.Companion companion = WidgetSettingsPremium.INSTANCE;
            FragmentActivity fragmentActivityRequireActivity = WidgetStickerSheet.this.requireActivity();
            Intrinsics3.checkNotNullExpressionValue(fragmentActivityRequireActivity, "requireActivity()");
            WidgetSettingsPremium.Companion.launch$default(companion, fragmentActivityRequireActivity, null, "Sticker Nitro Upsell Popout", 2, null);
        }
    }

    /* compiled from: WidgetStickerSheet.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/discord/i18n/RenderContext;", "", "invoke", "(Lcom/discord/i18n/RenderContext;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.stickers.WidgetStickerSheet$configureUI$2, reason: invalid class name */
    public static final class AnonymousClass2 extends Lambda implements Function1<RenderContext, Unit> {
        public static final AnonymousClass2 INSTANCE = new AnonymousClass2();

        /* compiled from: WidgetStickerSheet.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/view/View;", "view", "", "invoke", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
        /* renamed from: com.discord.widgets.stickers.WidgetStickerSheet$configureUI$2$1, reason: invalid class name */
        public static final class AnonymousClass1 extends Lambda implements Function1<View, Unit> {
            public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

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
                Intrinsics3.checkNotNullParameter(view, "view");
                WidgetSettingsPremium.Companion companion = WidgetSettingsPremium.INSTANCE;
                Context context = view.getContext();
                Intrinsics3.checkNotNullExpressionValue(context, "view.context");
                WidgetSettingsPremium.Companion.launch$default(companion, context, null, "Sticker Nitro Upsell Popout", 2, null);
            }
        }

        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(RenderContext renderContext) {
            invoke2(renderContext);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(RenderContext renderContext) {
            Intrinsics3.checkNotNullParameter(renderContext, "$receiver");
            renderContext.b("onClick", AnonymousClass1.INSTANCE);
        }
    }

    /* compiled from: WidgetStickerSheet.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.stickers.WidgetStickerSheet$configureUI$3, reason: invalid class name */
    public static final class AnonymousClass3 implements View.OnClickListener {
        public final /* synthetic */ boolean $isPackEnabled;
        public final /* synthetic */ StickerSheetViewModel.ViewState $viewState;

        public AnonymousClass3(boolean z2, StickerSheetViewModel.ViewState viewState) {
            this.$isPackEnabled = z2;
            this.$viewState = viewState;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            if (!this.$isPackEnabled || this.$viewState.getCanUsePremiumStickers()) {
                return;
            }
            WidgetStickerSheet.this.dismiss();
            StickerPremiumUpsellDialog.Companion companion = StickerPremiumUpsellDialog.INSTANCE;
            FragmentManager parentFragmentManager = WidgetStickerSheet.this.getParentFragmentManager();
            Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
            companion.show(parentFragmentManager, new Traits.Location(null, Traits.Location.Section.STICKER_POPOUT, null, null, null, 29, null));
        }
    }

    /* compiled from: WidgetStickerSheet.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.stickers.WidgetStickerSheet$configureUI$4, reason: invalid class name */
    public static final class AnonymousClass4 implements View.OnClickListener {
        public final /* synthetic */ boolean $isPackEnabled;
        public final /* synthetic */ String $location;
        public final /* synthetic */ Sticker $sticker;
        public final /* synthetic */ ModelStickerPack $stickerPack;
        public final /* synthetic */ StickerSheetViewModel.ViewState $viewState;

        public AnonymousClass4(boolean z2, StickerSheetViewModel.ViewState viewState, Sticker sticker, String str, ModelStickerPack modelStickerPack) {
            this.$isPackEnabled = z2;
            this.$viewState = viewState;
            this.$sticker = sticker;
            this.$location = str;
            this.$stickerPack = modelStickerPack;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            if (this.$isPackEnabled && this.$viewState.getCanUsePremiumStickers()) {
                ExpressionPickerEventBus.INSTANCE.getINSTANCE().emitEvent(new ExpressionPickerEvent.OpenStickerPicker(this.$sticker.getPackId(), null, false, 2, null));
            } else {
                WidgetStickerPackStoreSheet.Companion companion = WidgetStickerPackStoreSheet.INSTANCE;
                FragmentManager parentFragmentManager = WidgetStickerSheet.this.getParentFragmentManager();
                Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
                companion.show(parentFragmentManager, this.$sticker, WidgetStickerPackStoreSheet2.STICKER_POPOUT_VIEW_ALL, this.$location, StickerPurchaseLocation.INSTANCE.getPopoutPurchaseLocation(this.$stickerPack.canBePurchased()));
            }
            WidgetStickerSheet.this.dismiss();
        }
    }

    public WidgetStickerSheet() {
        super(false, 1, null);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetStickerSheet2.INSTANCE, null, 2, null);
        WidgetStickerSheet3 widgetStickerSheet3 = new WidgetStickerSheet3(this);
        AppViewModelDelegates3 appViewModelDelegates3 = new AppViewModelDelegates3(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection2.getOrCreateKotlinClass(StickerSheetViewModel.class), new WidgetStickerSheet$appViewModels$$inlined$viewModels$1(appViewModelDelegates3), new AppViewModelDelegates5(widgetStickerSheet3));
    }

    public static final /* synthetic */ void access$configureUI(WidgetStickerSheet widgetStickerSheet, StickerSheetViewModel.ViewState viewState) {
        widgetStickerSheet.configureUI(viewState);
    }

    public static final /* synthetic */ Bundle access$getArgumentsOrDefault$p(WidgetStickerSheet widgetStickerSheet) {
        return widgetStickerSheet.getArgumentsOrDefault();
    }

    private final void configureUI(StickerSheetViewModel.ViewState viewState) {
        ModelStickerPack stickerPack = viewState.getStickerPack();
        Sticker sticker = viewState.getSticker();
        PremiumTier meUserPremiumTier = viewState.getMeUserPremiumTier();
        boolean isStickerPackEnabled = viewState.getIsStickerPackEnabled();
        TextView textView = getBinding().d;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.stickerSheetStickerName");
        textView.setText(sticker.getName());
        if (!viewState.getCanUsePremiumStickers()) {
            getBinding().c.setOnClickListener(new AnonymousClass1());
        }
        TextView textView2 = getBinding().c;
        Intrinsics3.checkNotNullExpressionValue(textView2, "binding.stickerSheetStickerInfo");
        textView2.setText((isStickerPackEnabled || viewState.getCanUsePremiumStickers() || stickerPack.isPremiumPack()) ? FormatUtils.k(this, R.string.sticker_popout_pack_info_premium, new Object[]{stickerPack.getName()}, null, 4) : !stickerPack.canBePurchased() ? FormatUtils.k(this, R.string.sticker_popout_pack_info_unavailable, new Object[]{stickerPack.getName()}, null, 4) : FormatUtils.e(this, R.string.sticker_popout_pack_info, new Object[]{stickerPack.getName(), String.valueOf(StickerUtils.INSTANCE.calculatePremiumStickerPackDiscount())}, AnonymousClass2.INSTANCE));
        try {
            getBinding().h.d(stickerPack.getStickers().get(0), 0);
            getBinding().i.d(stickerPack.getStickers().get(1), 0);
            getBinding().j.d(stickerPack.getStickers().get(2), 0);
            getBinding().k.d(stickerPack.getStickers().get(3), 0);
        } catch (IndexOutOfBoundsException unused) {
        }
        Bundle arguments = getArguments();
        String string = arguments != null ? arguments.getString(ANALYTICS_LOCATION) : null;
        StickerUtils stickerUtils = StickerUtils.INSTANCE;
        Context contextRequireContext = requireContext();
        Intrinsics3.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
        getBinding().f2663b.setText(stickerUtils.getStickerPackPremiumPriceLabel(contextRequireContext, stickerPack, meUserPremiumTier, isStickerPackEnabled));
        getBinding().f2663b.setIsLoading(false);
        getBinding().f2663b.setOnClickListener(new AnonymousClass3(isStickerPackEnabled, viewState));
        LoadingButton loadingButton = getBinding().f2663b;
        Intrinsics3.checkNotNullExpressionValue(loadingButton, "binding.stickerSheetBuyButton");
        loadingButton.setVisibility(isStickerPackEnabled && !viewState.getCanUsePremiumStickers() ? 0 : 8);
        MaterialButton materialButton = getBinding().e;
        Intrinsics3.checkNotNullExpressionValue(materialButton, "binding.stickerSheetViewButton");
        materialButton.setVisibility(isStickerPackEnabled ? 0 : 8);
        getBinding().e.setOnClickListener(new AnonymousClass4(isStickerPackEnabled, viewState, sticker, string, stickerPack));
        RelativeLayout relativeLayout = getBinding().g;
        Intrinsics3.checkNotNullExpressionValue(relativeLayout, "binding.stickerSheetViewLimitedContainer");
        relativeLayout.setVisibility(stickerPack.isLimitedPack() ? 0 : 8);
        Chip chip = getBinding().f;
        Intrinsics3.checkNotNullExpressionValue(chip, "binding.stickerSheetViewLimitedChip");
        Context contextRequireContext2 = requireContext();
        Intrinsics3.checkNotNullExpressionValue(contextRequireContext2, "requireContext()");
        chip.setText(stickerUtils.getLimitedTimeLeftString(contextRequireContext2, stickerPack.getStoreListing()));
    }

    private final WidgetStickerSheetBinding getBinding() {
        return (WidgetStickerSheetBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final StickerSheetViewModel getViewModel() {
        return (StickerSheetViewModel) this.viewModel.getValue();
    }

    public static final void show(FragmentManager fragmentManager, Sticker sticker, long j) {
        INSTANCE.show(fragmentManager, sticker, j);
    }

    @Override // com.discord.app.AppBottomSheet
    public void bindSubscriptions(CompositeSubscription compositeSubscription) {
        Intrinsics3.checkNotNullParameter(compositeSubscription, "compositeSubscription");
        Observable observableR = ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeViewState(), this, null, 2, null).r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "viewModel\n        .obser…  .distinctUntilChanged()");
        ObservableExtensionsKt.appSubscribe$default(observableR, WidgetStickerSheet.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(this), 62, (Object) null);
    }

    @Override // com.discord.app.AppBottomSheet
    public int getContentViewResId() {
        return R.layout.widget_sticker_sheet;
    }
}
