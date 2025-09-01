package com.discord.widgets.servers.guildboost;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import b.a.a.a.GuildBoostActivatedDialog;
import b.a.d.AppScreen2;
import b.a.d.AppViewModelDelegates3;
import b.a.d.AppViewModelDelegates5;
import b.a.k.FormatUtils;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetGuildBoostTransferBinding;
import com.discord.models.domain.ModelAppliedGuildBoost;
import com.discord.models.domain.ModelGuildBoostSlot;
import com.discord.utilities.dimmer.DimmerView;
import com.discord.utilities.resources.StringResourceUtils;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.widgets.servers.guildboost.GuildBoostTransferInProgressViewModel;
import com.google.android.material.button.MaterialButton;
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

/* compiled from: WidgetGuildBoostTransfer.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB\u0007¢\u0006\u0004\b\u0019\u0010\fJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000b\u0010\fR\u001d\u0010\u0012\u001a\u00020\r8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001d\u0010\u0018\u001a\u00020\u00138B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u001b"}, d2 = {"Lcom/discord/widgets/servers/guildboost/WidgetGuildBoostTransfer;", "Lcom/discord/app/AppFragment;", "Lcom/discord/widgets/servers/guildboost/GuildBoostTransferInProgressViewModel$ViewState;", "state", "", "configureUI", "(Lcom/discord/widgets/servers/guildboost/GuildBoostTransferInProgressViewModel$ViewState;)V", "Landroid/view/View;", "view", "onViewBound", "(Landroid/view/View;)V", "onViewBoundOrOnResume", "()V", "Lcom/discord/widgets/servers/guildboost/GuildBoostTransferInProgressViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "getViewModel", "()Lcom/discord/widgets/servers/guildboost/GuildBoostTransferInProgressViewModel;", "viewModel", "Lcom/discord/databinding/WidgetGuildBoostTransferBinding;", "binding$delegate", "Lcom/discord/utilities/viewbinding/FragmentViewBindingDelegate;", "getBinding", "()Lcom/discord/databinding/WidgetGuildBoostTransferBinding;", "binding", "<init>", "Companion", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class WidgetGuildBoostTransfer extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetGuildBoostTransfer.class, "binding", "getBinding()Lcom/discord/databinding/WidgetGuildBoostTransferBinding;", 0)};

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String INTENT_EXTRA_PREVIOUS_GUILD_ID = "PREVIOUS_GUILD_ID";
    private static final String INTENT_EXTRA_SLOT_ID = "SLOT_ID";
    private static final String INTENT_EXTRA_SUBSCRIPTION_ID = "SUBSCRIPTION_ID";
    private static final String INTENT_EXTRA_TARGET_GUILD_ID = "TARGET_GUILD_ID";

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* compiled from: WidgetGuildBoostTransfer.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0013\u0010\u0014J;\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\n\u0010\u0006\u001a\u00060\u0004j\u0002`\u00052\n\u0010\u0007\u001a\u00060\u0004j\u0002`\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\bH\u0007¢\u0006\u0004\b\u000b\u0010\fR\u0016\u0010\u000e\u001a\u00020\r8\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0010\u001a\u00020\r8\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0010\u0010\u000fR\u0016\u0010\u0011\u001a\u00020\r8\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0011\u0010\u000fR\u0016\u0010\u0012\u001a\u00020\r8\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0012\u0010\u000f¨\u0006\u0015"}, d2 = {"Lcom/discord/widgets/servers/guildboost/WidgetGuildBoostTransfer$Companion;", "", "Landroid/content/Context;", "context", "", "Lcom/discord/primitives/GuildId;", "previousGuildId", "targetGuildId", "Lcom/discord/models/domain/ModelGuildBoostSlot;", "slot", "", "create", "(Landroid/content/Context;JJLcom/discord/models/domain/ModelGuildBoostSlot;)V", "", "INTENT_EXTRA_PREVIOUS_GUILD_ID", "Ljava/lang/String;", "INTENT_EXTRA_SLOT_ID", "INTENT_EXTRA_SUBSCRIPTION_ID", "INTENT_EXTRA_TARGET_GUILD_ID", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public static /* synthetic */ void create$default(Companion companion, Context context, long j, long j2, ModelGuildBoostSlot modelGuildBoostSlot, int i, Object obj) {
            if ((i & 8) != 0) {
                modelGuildBoostSlot = null;
            }
            companion.create(context, j, j2, modelGuildBoostSlot);
        }

        public final void create(Context context, long previousGuildId, long targetGuildId, ModelGuildBoostSlot slot) {
            ModelAppliedGuildBoost premiumGuildSubscription;
            Intrinsics3.checkNotNullParameter(context, "context");
            Long lValueOf = null;
            Intent intentPutExtra = new Intent().putExtra(WidgetGuildBoostTransfer.INTENT_EXTRA_PREVIOUS_GUILD_ID, previousGuildId).putExtra(WidgetGuildBoostTransfer.INTENT_EXTRA_TARGET_GUILD_ID, targetGuildId).putExtra(WidgetGuildBoostTransfer.INTENT_EXTRA_SLOT_ID, slot != null ? Long.valueOf(slot.getId()) : null);
            if (slot != null && (premiumGuildSubscription = slot.getPremiumGuildSubscription()) != null) {
                lValueOf = Long.valueOf(premiumGuildSubscription.getId());
            }
            Intent intentPutExtra2 = intentPutExtra.putExtra(WidgetGuildBoostTransfer.INTENT_EXTRA_SUBSCRIPTION_ID, lValueOf);
            Intrinsics3.checkNotNullExpressionValue(intentPutExtra2, "Intent()\n          .putE…iumGuildSubscription?.id)");
            AppScreen2.d(context, WidgetGuildBoostTransfer.class, intentPutExtra2);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetGuildBoostTransfer.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.servers.guildboost.WidgetGuildBoostTransfer$configureUI$1, reason: invalid class name */
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
            FragmentActivity activity = WidgetGuildBoostTransfer.this.getActivity();
            if (activity != null) {
                activity.finish();
            }
        }
    }

    /* compiled from: WidgetGuildBoostTransfer.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.servers.guildboost.WidgetGuildBoostTransfer$onViewBound$1, reason: invalid class name */
    public static final class AnonymousClass1 implements View.OnClickListener {
        public AnonymousClass1() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetGuildBoostTransfer.access$getViewModel$p(WidgetGuildBoostTransfer.this).transferGuildBoost();
        }
    }

    /* compiled from: WidgetGuildBoostTransfer.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/widgets/servers/guildboost/GuildBoostTransferInProgressViewModel$ViewState;", "p1", "", "invoke", "(Lcom/discord/widgets/servers/guildboost/GuildBoostTransferInProgressViewModel$ViewState;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.servers.guildboost.WidgetGuildBoostTransfer$onViewBoundOrOnResume$1, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<GuildBoostTransferInProgressViewModel.ViewState, Unit> {
        public AnonymousClass1(WidgetGuildBoostTransfer widgetGuildBoostTransfer) {
            super(1, widgetGuildBoostTransfer, WidgetGuildBoostTransfer.class, "configureUI", "configureUI(Lcom/discord/widgets/servers/guildboost/GuildBoostTransferInProgressViewModel$ViewState;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(GuildBoostTransferInProgressViewModel.ViewState viewState) {
            invoke2(viewState);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(GuildBoostTransferInProgressViewModel.ViewState viewState) {
            Intrinsics3.checkNotNullParameter(viewState, "p1");
            WidgetGuildBoostTransfer.access$configureUI((WidgetGuildBoostTransfer) this.receiver, viewState);
        }
    }

    public WidgetGuildBoostTransfer() {
        super(R.layout.widget_guild_boost_transfer);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetGuildBoostTransfer2.INSTANCE, null, 2, null);
        WidgetGuildBoostTransfer3 widgetGuildBoostTransfer3 = new WidgetGuildBoostTransfer3(this);
        AppViewModelDelegates3 appViewModelDelegates3 = new AppViewModelDelegates3(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection2.getOrCreateKotlinClass(GuildBoostTransferInProgressViewModel.class), new WidgetGuildBoostTransfer$appViewModels$$inlined$viewModels$1(appViewModelDelegates3), new AppViewModelDelegates5(widgetGuildBoostTransfer3));
    }

    public static final /* synthetic */ void access$configureUI(WidgetGuildBoostTransfer widgetGuildBoostTransfer, GuildBoostTransferInProgressViewModel.ViewState viewState) {
        widgetGuildBoostTransfer.configureUI(viewState);
    }

    public static final /* synthetic */ GuildBoostTransferInProgressViewModel access$getViewModel$p(WidgetGuildBoostTransfer widgetGuildBoostTransfer) {
        return widgetGuildBoostTransfer.getViewModel();
    }

    private final void configureUI(GuildBoostTransferInProgressViewModel.ViewState state) {
        if (state instanceof GuildBoostTransferInProgressViewModel.ViewState.ErrorLoading) {
            FragmentActivity activity = getActivity();
            if (activity != null) {
                activity.finish();
                return;
            }
            return;
        }
        if (state instanceof GuildBoostTransferInProgressViewModel.ViewState.Loading) {
            DimmerView.setDimmed$default(getBinding().f2408b, true, false, 2, null);
            TextView textView = getBinding().d;
            Intrinsics3.checkNotNullExpressionValue(textView, "binding.guildBoostTransferError");
            textView.setVisibility(4);
            return;
        }
        if (state instanceof GuildBoostTransferInProgressViewModel.ViewState.ErrorTransfer) {
            DimmerView.setDimmed$default(getBinding().f2408b, false, false, 2, null);
            TextView textView2 = getBinding().d;
            Intrinsics3.checkNotNullExpressionValue(textView2, "binding.guildBoostTransferError");
            textView2.setVisibility(0);
            return;
        }
        if (state instanceof GuildBoostTransferInProgressViewModel.ViewState.PreTransfer) {
            GuildBoostTransferInProgressViewModel.ViewState.PreTransfer preTransfer = (GuildBoostTransferInProgressViewModel.ViewState.PreTransfer) state;
            DimmerView.setDimmed$default(getBinding().f2408b, preTransfer.isTransferInProgress(), false, 2, null);
            TextView textView3 = getBinding().d;
            Intrinsics3.checkNotNullExpressionValue(textView3, "binding.guildBoostTransferError");
            textView3.setVisibility(4);
            getBinding().e.b(preTransfer.getPreviousGuild(), -1);
            getBinding().h.b(preTransfer.getTargetGuild(), 1);
            return;
        }
        if (state instanceof GuildBoostTransferInProgressViewModel.ViewState.PostTransfer) {
            GuildBoostActivatedDialog.Companion aVar = GuildBoostActivatedDialog.INSTANCE;
            FragmentManager parentFragmentManager = getParentFragmentManager();
            Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
            GuildBoostTransferInProgressViewModel.ViewState.PostTransfer postTransfer = (GuildBoostTransferInProgressViewModel.ViewState.PostTransfer) state;
            aVar.a(parentFragmentManager, requireContext(), postTransfer.getTargetGuild().getName(), postTransfer.getTargetGuildSubscriptionCount() + 1, true, new AnonymousClass1());
        }
    }

    public static final void create(Context context, long j, long j2, ModelGuildBoostSlot modelGuildBoostSlot) {
        INSTANCE.create(context, j, j2, modelGuildBoostSlot);
    }

    private final WidgetGuildBoostTransferBinding getBinding() {
        return (WidgetGuildBoostTransferBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final GuildBoostTransferInProgressViewModel getViewModel() {
        return (GuildBoostTransferInProgressViewModel) this.viewModel.getValue();
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        AppFragment.setActionBarDisplayHomeAsUpEnabled$default(this, false, 1, null);
        TextView textView = getBinding().c;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.guildBoostTransferConfirmationBlurb");
        textView.setText(FormatUtils.k(this, R.string.premium_guild_subscribe_confirm_transfer_blurb, new Object[]{StringResourceUtils.getI18nPluralString(requireContext(), R.plurals.premium_guild_subscribe_confirm_transfer_blurb_slotCount, 1, 1), StringResourceUtils.getI18nPluralString(requireContext(), R.plurals.premium_guild_subscribe_confirm_transfer_blurb_guildCount, 1, 1)}, null, 4));
        TextView textView2 = getBinding().f;
        Intrinsics3.checkNotNullExpressionValue(textView2, "binding.guildBoostTransferPreviousGuildHeader");
        textView2.setText(FormatUtils.k(this, R.string.premium_guild_subscribe_confirm_transfer_from_guild, new Object[]{StringResourceUtils.getI18nPluralString(requireContext(), R.plurals.premium_guild_subscribe_confirm_transfer_from_guild_guildCount, 1, 1)}, null, 4));
        TextView textView3 = getBinding().i;
        Intrinsics3.checkNotNullExpressionValue(textView3, "binding.guildBoostTransferTargetGuildHeader");
        textView3.setText(FormatUtils.k(this, R.string.premium_guild_subscribe_confirm_transfer_to_guild, new Object[]{StringResourceUtils.getI18nPluralString(requireContext(), R.plurals.premium_guild_subscribe_confirm_transfer_to_guild_slotCount, 1, 1)}, null, 4));
        getBinding().g.setOnClickListener(new AnonymousClass1());
        MaterialButton materialButton = getBinding().g;
        Intrinsics3.checkNotNullExpressionValue(materialButton, "binding.guildBoostTransferSelect");
        materialButton.setText(FormatUtils.k(this, R.string.premium_guild_subscribe_transfer_confirm_confirmation, new Object[]{StringResourceUtils.getI18nPluralString(requireContext(), R.plurals.premium_guild_subscribe_transfer_confirm_confirmation_slotCount, 1, 1)}, null, 4));
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        Observable observableR = ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeViewState(), this, null, 2, null).r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "viewModel\n        .obser…  .distinctUntilChanged()");
        ObservableExtensionsKt.appSubscribe$default(observableR, WidgetGuildBoostTransfer.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(this), 62, (Object) null);
    }
}
