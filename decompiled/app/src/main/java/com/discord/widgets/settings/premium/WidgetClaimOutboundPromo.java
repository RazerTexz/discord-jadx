package com.discord.widgets.settings.premium;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.res.ColorStateList;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.Fragment2;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.transition.AutoTransition;
import androidx.transition.TransitionManager;
import b.a.d.AppViewModelDelegates3;
import b.a.d.AppViewModelDelegates5;
import b.a.k.FormatUtils;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.app.AppDialog;
import com.discord.app.AppViewFlipper;
import com.discord.databinding.WidgetClaimOutboundPromoBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.KotlinExtensions;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.dimen.DimenUtils;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.uri.UriHandler;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.widgets.settings.premium.ClaimOutboundPromoViewModel;
import com.discord.widgets.settings.premium.ClaimStatus;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapeAppearanceModel;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import d0.z.d.Reflection2;
import java.util.Objects;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;

/* compiled from: WidgetClaimOutboundPromo.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 -2\u00020\u0001:\u0001-B\u0007¢\u0006\u0004\b,\u0010\u0018J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\t\u0010\nJ\u0019\u0010\r\u001a\u00020\u00042\b\b\u0001\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u0019\u0010\u0011\u001a\u00020\u00042\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001c\u001a\u00020\u00198B@\u0002X\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001bR\u001d\u0010\"\u001a\u00020\u001d8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!R\u0016\u0010$\u001a\u00020#8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b$\u0010%R\u001d\u0010+\u001a\u00020&8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*¨\u0006."}, d2 = {"Lcom/discord/widgets/settings/premium/WidgetClaimOutboundPromo;", "Lcom/discord/app/AppDialog;", "Lcom/discord/widgets/settings/premium/ClaimOutboundPromoViewModel$ViewState;", "viewState", "", "configureUi", "(Lcom/discord/widgets/settings/premium/ClaimOutboundPromoViewModel$ViewState;)V", "Lcom/discord/widgets/settings/premium/ClaimOutboundPromoViewModel$Event;", "event", "handleEvent", "(Lcom/discord/widgets/settings/premium/ClaimOutboundPromoViewModel$Event;)V", "", ModelAuditLogEntry.CHANGE_KEY_COLOR, "setCodeBoxColor", "(I)V", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "Landroid/view/View;", "view", "onViewBound", "(Landroid/view/View;)V", "onViewBoundOrOnResume", "()V", "Lcom/discord/widgets/settings/premium/ClaimStatus;", "getClaimStatus", "()Lcom/discord/widgets/settings/premium/ClaimStatus;", "claimStatus", "Lcom/discord/databinding/WidgetClaimOutboundPromoBinding;", "binding$delegate", "Lcom/discord/utilities/viewbinding/FragmentViewBindingDelegate;", "getBinding", "()Lcom/discord/databinding/WidgetClaimOutboundPromoBinding;", "binding", "Lcom/google/android/material/shape/MaterialShapeDrawable;", "codeBoxBackground", "Lcom/google/android/material/shape/MaterialShapeDrawable;", "Lcom/discord/widgets/settings/premium/ClaimOutboundPromoViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "getViewModel", "()Lcom/discord/widgets/settings/premium/ClaimOutboundPromoViewModel;", "viewModel", "<init>", "Companion", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class WidgetClaimOutboundPromo extends AppDialog {
    private static final String ARG_CLAIM_STATUS = "ARG_CLAIM_STATUS";
    private static final int INDEX_FAILURE = 2;
    private static final int INDEX_LOADING = 0;
    private static final int INDEX_SUCCESS = 1;
    private static final String KEY_PROMO_CLAIMED = "KEY_PROMO_CLAIMED";

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private final MaterialShapeDrawable codeBoxBackground;

    /* renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetClaimOutboundPromo.class, "binding", "getBinding()Lcom/discord/databinding/WidgetClaimOutboundPromoBinding;", 0)};

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* compiled from: WidgetClaimOutboundPromo.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0015\u0010\u0016J1\u0010\n\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006¢\u0006\u0004\b\n\u0010\u000bR\u0016\u0010\r\u001a\u00020\f8\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u0010\u001a\u00020\u000f8\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0012\u001a\u00020\u000f8\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0012\u0010\u0011R\u0016\u0010\u0013\u001a\u00020\u000f8\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0013\u0010\u0011R\u0016\u0010\u0014\u001a\u00020\f8\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0014\u0010\u000e¨\u0006\u0017"}, d2 = {"Lcom/discord/widgets/settings/premium/WidgetClaimOutboundPromo$Companion;", "", "Lcom/discord/widgets/settings/premium/ClaimStatus;", "claimStatus", "Landroidx/fragment/app/Fragment;", "fragment", "Lkotlin/Function1;", "Lcom/discord/widgets/settings/premium/ClaimStatus$Claimed;", "", "onPromoClaimed", "showAndRegisterForClaimResult", "(Lcom/discord/widgets/settings/premium/ClaimStatus;Landroidx/fragment/app/Fragment;Lkotlin/jvm/functions/Function1;)V", "", WidgetClaimOutboundPromo.ARG_CLAIM_STATUS, "Ljava/lang/String;", "", "INDEX_FAILURE", "I", "INDEX_LOADING", "INDEX_SUCCESS", WidgetClaimOutboundPromo.KEY_PROMO_CLAIMED, "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public final void showAndRegisterForClaimResult(ClaimStatus claimStatus, Fragment fragment, Function1<? super ClaimStatus.Claimed, Unit> onPromoClaimed) {
            Intrinsics3.checkNotNullParameter(claimStatus, "claimStatus");
            Intrinsics3.checkNotNullParameter(fragment, "fragment");
            Intrinsics3.checkNotNullParameter(onPromoClaimed, "onPromoClaimed");
            if (fragment.getParentFragmentManager().findFragmentByTag("javaClass") != null) {
                return;
            }
            if (claimStatus instanceof ClaimStatus.Unclaimed) {
                Fragment2.setFragmentResultListener(fragment, WidgetClaimOutboundPromo.KEY_PROMO_CLAIMED, new WidgetClaimOutboundPromo2(onPromoClaimed));
            }
            WidgetClaimOutboundPromo widgetClaimOutboundPromo = new WidgetClaimOutboundPromo();
            Bundle bundle = new Bundle();
            bundle.putParcelable(WidgetClaimOutboundPromo.ARG_CLAIM_STATUS, claimStatus);
            widgetClaimOutboundPromo.setArguments(bundle);
            FragmentManager parentFragmentManager = fragment.getParentFragmentManager();
            Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "fragment.parentFragmentManager");
            widgetClaimOutboundPromo.show(parentFragmentManager, "javaClass");
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetClaimOutboundPromo.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.settings.premium.WidgetClaimOutboundPromo$onViewBound$1, reason: invalid class name */
    public static final class AnonymousClass1 implements View.OnClickListener {
        public AnonymousClass1() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetClaimOutboundPromo.access$getViewModel$p(WidgetClaimOutboundPromo.this).copyClicked();
        }
    }

    /* compiled from: WidgetClaimOutboundPromo.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.settings.premium.WidgetClaimOutboundPromo$onViewBound$2, reason: invalid class name */
    public static final class AnonymousClass2 implements View.OnClickListener {
        public AnonymousClass2() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetClaimOutboundPromo.access$getViewModel$p(WidgetClaimOutboundPromo.this).redeemClicked();
        }
    }

    /* compiled from: WidgetClaimOutboundPromo.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.settings.premium.WidgetClaimOutboundPromo$onViewBound$3, reason: invalid class name */
    public static final class AnonymousClass3 implements View.OnClickListener {
        public AnonymousClass3() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetClaimOutboundPromo.access$getViewModel$p(WidgetClaimOutboundPromo.this).maybeLaterClicked();
        }
    }

    /* compiled from: WidgetClaimOutboundPromo.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.settings.premium.WidgetClaimOutboundPromo$onViewBound$4, reason: invalid class name */
    public static final class AnonymousClass4 implements View.OnClickListener {
        public AnonymousClass4() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetClaimOutboundPromo.access$getViewModel$p(WidgetClaimOutboundPromo.this).failureCloseClicked();
        }
    }

    /* compiled from: WidgetClaimOutboundPromo.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/widgets/settings/premium/ClaimOutboundPromoViewModel$ViewState;", "p1", "", "invoke", "(Lcom/discord/widgets/settings/premium/ClaimOutboundPromoViewModel$ViewState;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.settings.premium.WidgetClaimOutboundPromo$onViewBoundOrOnResume$1, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<ClaimOutboundPromoViewModel.ViewState, Unit> {
        public AnonymousClass1(WidgetClaimOutboundPromo widgetClaimOutboundPromo) {
            super(1, widgetClaimOutboundPromo, WidgetClaimOutboundPromo.class, "configureUi", "configureUi(Lcom/discord/widgets/settings/premium/ClaimOutboundPromoViewModel$ViewState;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ClaimOutboundPromoViewModel.ViewState viewState) {
            invoke2(viewState);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ClaimOutboundPromoViewModel.ViewState viewState) {
            Intrinsics3.checkNotNullParameter(viewState, "p1");
            WidgetClaimOutboundPromo.access$configureUi((WidgetClaimOutboundPromo) this.receiver, viewState);
        }
    }

    /* compiled from: WidgetClaimOutboundPromo.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/widgets/settings/premium/ClaimOutboundPromoViewModel$Event;", "p1", "", "invoke", "(Lcom/discord/widgets/settings/premium/ClaimOutboundPromoViewModel$Event;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.settings.premium.WidgetClaimOutboundPromo$onViewBoundOrOnResume$2, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass2 extends FunctionReferenceImpl implements Function1<ClaimOutboundPromoViewModel.Event, Unit> {
        public AnonymousClass2(WidgetClaimOutboundPromo widgetClaimOutboundPromo) {
            super(1, widgetClaimOutboundPromo, WidgetClaimOutboundPromo.class, "handleEvent", "handleEvent(Lcom/discord/widgets/settings/premium/ClaimOutboundPromoViewModel$Event;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ClaimOutboundPromoViewModel.Event event) {
            invoke2(event);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ClaimOutboundPromoViewModel.Event event) {
            Intrinsics3.checkNotNullParameter(event, "p1");
            WidgetClaimOutboundPromo.access$handleEvent((WidgetClaimOutboundPromo) this.receiver, event);
        }
    }

    public WidgetClaimOutboundPromo() {
        super(R.layout.widget_claim_outbound_promo);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetClaimOutboundPromo3.INSTANCE, null, 2, null);
        WidgetClaimOutboundPromo4 widgetClaimOutboundPromo4 = new WidgetClaimOutboundPromo4(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection2.getOrCreateKotlinClass(ClaimOutboundPromoViewModel.class), new WidgetClaimOutboundPromo$appViewModels$$inlined$viewModels$1(new AppViewModelDelegates3(this)), new AppViewModelDelegates5(widgetClaimOutboundPromo4));
        MaterialShapeDrawable materialShapeDrawable = new MaterialShapeDrawable(new ShapeAppearanceModel.Builder().setAllCornerSizes(DimenUtils.dpToPixels(4)).build());
        materialShapeDrawable.setFillColor(ColorStateList.valueOf(0));
        this.codeBoxBackground = materialShapeDrawable;
    }

    public static final /* synthetic */ void access$configureUi(WidgetClaimOutboundPromo widgetClaimOutboundPromo, ClaimOutboundPromoViewModel.ViewState viewState) {
        widgetClaimOutboundPromo.configureUi(viewState);
    }

    public static final /* synthetic */ ClaimStatus access$getClaimStatus$p(WidgetClaimOutboundPromo widgetClaimOutboundPromo) {
        return widgetClaimOutboundPromo.getClaimStatus();
    }

    public static final /* synthetic */ ClaimOutboundPromoViewModel access$getViewModel$p(WidgetClaimOutboundPromo widgetClaimOutboundPromo) {
        return widgetClaimOutboundPromo.getViewModel();
    }

    public static final /* synthetic */ void access$handleEvent(WidgetClaimOutboundPromo widgetClaimOutboundPromo, ClaimOutboundPromoViewModel.Event event) {
        widgetClaimOutboundPromo.handleEvent(event);
    }

    private final void configureUi(ClaimOutboundPromoViewModel.ViewState viewState) {
        View view = getView();
        if (!(view instanceof ViewGroup)) {
            view = null;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        if (viewGroup != null) {
            AutoTransition autoTransition = new AutoTransition();
            autoTransition.setOrdering(0);
            autoTransition.setDuration(200L);
            TransitionManager.beginDelayedTransition(viewGroup, autoTransition);
        }
        if (viewState instanceof ClaimOutboundPromoViewModel.ViewState.ClaimInProgress) {
            AppViewFlipper appViewFlipper = getBinding().g;
            Intrinsics3.checkNotNullExpressionValue(appViewFlipper, "binding.claimPromoFlipper");
            appViewFlipper.setDisplayedChild(0);
            return;
        }
        if (!(viewState instanceof ClaimOutboundPromoViewModel.ViewState.Claimed)) {
            if (viewState instanceof ClaimOutboundPromoViewModel.ViewState.ClaimFailed) {
                AppViewFlipper appViewFlipper2 = getBinding().g;
                Intrinsics3.checkNotNullExpressionValue(appViewFlipper2, "binding.claimPromoFlipper");
                appViewFlipper2.setMeasureAllChildren(false);
                AppViewFlipper appViewFlipper3 = getBinding().g;
                Intrinsics3.checkNotNullExpressionValue(appViewFlipper3, "binding.claimPromoFlipper");
                appViewFlipper3.setDisplayedChild(2);
                setCancelable(true);
                return;
            }
            return;
        }
        TextView textView = getBinding().f2350b;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.claimPromoBody");
        ClaimOutboundPromoViewModel.ViewState.Claimed claimed = (ClaimOutboundPromoViewModel.ViewState.Claimed) viewState;
        textView.setText(claimed.getClaimedStatus().getBody());
        TextView textView2 = getBinding().c;
        Intrinsics3.checkNotNullExpressionValue(textView2, "binding.claimPromoCode");
        textView2.setText(claimed.getClaimedStatus().getCode());
        AppViewFlipper appViewFlipper4 = getBinding().g;
        Intrinsics3.checkNotNullExpressionValue(appViewFlipper4, "binding.claimPromoFlipper");
        appViewFlipper4.setDisplayedChild(1);
        setCancelable(true);
    }

    private final WidgetClaimOutboundPromoBinding getBinding() {
        return (WidgetClaimOutboundPromoBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final ClaimStatus getClaimStatus() {
        Parcelable parcelable = getArgumentsOrDefault().getParcelable(ARG_CLAIM_STATUS);
        Intrinsics3.checkNotNull(parcelable);
        return (ClaimStatus) parcelable;
    }

    private final ClaimOutboundPromoViewModel getViewModel() {
        return (ClaimOutboundPromoViewModel) this.viewModel.getValue();
    }

    private final void handleEvent(ClaimOutboundPromoViewModel.Event event) {
        Unit unit;
        if (event instanceof ClaimOutboundPromoViewModel.Event.Claimed) {
            Bundle bundle = new Bundle();
            bundle.putParcelable(KEY_PROMO_CLAIMED, ((ClaimOutboundPromoViewModel.Event.Claimed) event).getClaimedStatus());
            unit = Unit.a;
            Fragment2.setFragmentResult(this, KEY_PROMO_CLAIMED, bundle);
        } else if (event instanceof ClaimOutboundPromoViewModel.Event.CopyCode) {
            Object systemService = requireContext().getSystemService("clipboard");
            Objects.requireNonNull(systemService, "null cannot be cast to non-null type android.content.ClipboardManager");
            ((ClipboardManager) systemService).setPrimaryClip(ClipData.newPlainText("Promo Code", ((ClaimOutboundPromoViewModel.Event.CopyCode) event).getCode()));
            MaterialButton materialButton = getBinding().e;
            Intrinsics3.checkNotNullExpressionValue(materialButton, "binding.claimPromoCopyButton");
            FormatUtils.n(materialButton, R.string.copied, new Object[0], null, 4);
            setCodeBoxColor(ContextCompat.getColor(requireContext(), R.color.status_green_600));
            unit = Unit.a;
        } else if (event instanceof ClaimOutboundPromoViewModel.Event.OpenRedemptionUrl) {
            UriHandler uriHandler = UriHandler.INSTANCE;
            Context contextRequireContext = requireContext();
            Intrinsics3.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
            UriHandler.handle$default(uriHandler, contextRequireContext, ((ClaimOutboundPromoViewModel.Event.OpenRedemptionUrl) event).getUrl(), false, false, null, 28, null);
            dismiss();
            unit = Unit.a;
        } else {
            if (!(event instanceof ClaimOutboundPromoViewModel.Event.Dismiss)) {
                throw new NoWhenBranchMatchedException();
            }
            dismiss();
            unit = Unit.a;
        }
        KotlinExtensions.getExhaustive(unit);
    }

    private final void setCodeBoxColor(@ColorInt int color) {
        this.codeBoxBackground.setStroke(DimenUtils.dpToPixels(1), color);
        getBinding().d.invalidate();
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setCancelable(false);
    }

    @Override // com.discord.app.AppDialog
    public void onViewBound(View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        ViewCompat.setBackground(getBinding().d, this.codeBoxBackground);
        setCodeBoxColor(ColorCompat.getThemedColor(view, R.attr.colorInteractiveNormal));
        getBinding().e.setOnClickListener(new AnonymousClass1());
        getBinding().i.setOnClickListener(new AnonymousClass2());
        getBinding().h.setOnClickListener(new AnonymousClass3());
        getBinding().f.setOnClickListener(new AnonymousClass4());
    }

    @Override // com.discord.app.AppDialog
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeViewState(), this, null, 2, null), WidgetClaimOutboundPromo.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(this), 62, (Object) null);
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeEvents(), this, null, 2, null), WidgetClaimOutboundPromo.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass2(this), 62, (Object) null);
    }
}
