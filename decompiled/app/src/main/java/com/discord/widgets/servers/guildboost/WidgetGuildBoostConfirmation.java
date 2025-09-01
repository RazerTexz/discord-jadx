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
import com.discord.app.AppActivity;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetServerBoostConfirmationBinding;
import com.discord.utilities.dimmer.DimmerView;
import com.discord.utilities.resources.StringResourceUtils;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.widgets.servers.WidgetServerSettingsChannels;
import com.discord.widgets.servers.guildboost.GuildBoostInProgressViewModel;
import com.google.android.material.button.MaterialButton;
import d0.LazyJVM;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import d0.z.d.Reflection2;
import java.util.Objects;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import rx.Observable;

/* compiled from: WidgetGuildBoostConfirmation.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 (2\u00020\u0001:\u0001(B\u0007¢\u0006\u0004\b'\u0010\u0010J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000f\u0010\u0010R!\u0010\u0017\u001a\u00060\u0011j\u0002`\u00128B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u001d\u0010\u001c\u001a\u00020\u00188B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u0014\u001a\u0004\b\u001a\u0010\u001bR\u001d\u0010\"\u001a\u00020\u001d8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!R!\u0010&\u001a\u00060\u0011j\u0002`#8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b$\u0010\u0014\u001a\u0004\b%\u0010\u0016¨\u0006)"}, d2 = {"Lcom/discord/widgets/servers/guildboost/WidgetGuildBoostConfirmation;", "Lcom/discord/app/AppFragment;", "Lcom/discord/widgets/servers/guildboost/GuildBoostInProgressViewModel$ViewState;", "viewModelViewState", "", "configureUI", "(Lcom/discord/widgets/servers/guildboost/GuildBoostInProgressViewModel$ViewState;)V", "", "guildName", "configureToolbar", "(Ljava/lang/String;)V", "Landroid/view/View;", "view", "onViewBound", "(Landroid/view/View;)V", "onResume", "()V", "", "Lcom/discord/primitives/GuildBoostSlotId;", "slotId$delegate", "Lkotlin/Lazy;", "getSlotId", "()J", "slotId", "Lcom/discord/widgets/servers/guildboost/GuildBoostInProgressViewModel;", "viewModel$delegate", "getViewModel", "()Lcom/discord/widgets/servers/guildboost/GuildBoostInProgressViewModel;", "viewModel", "Lcom/discord/databinding/WidgetServerBoostConfirmationBinding;", "binding$delegate", "Lcom/discord/utilities/viewbinding/FragmentViewBindingDelegate;", "getBinding", "()Lcom/discord/databinding/WidgetServerBoostConfirmationBinding;", "binding", "Lcom/discord/primitives/GuildId;", "guildId$delegate", "getGuildId", "guildId", "<init>", "Companion", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class WidgetGuildBoostConfirmation extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetGuildBoostConfirmation.class, "binding", "getBinding()Lcom/discord/databinding/WidgetServerBoostConfirmationBinding;", 0)};

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String INTENT_EXTRA_GUILD_ID = "GUILD_ID";
    private static final String INTENT_EXTRA_SLOT_ID = "SLOT_ID";

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* renamed from: guildId$delegate, reason: from kotlin metadata */
    private final Lazy guildId;

    /* renamed from: slotId$delegate, reason: from kotlin metadata */
    private final Lazy slotId;

    /* renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* compiled from: WidgetGuildBoostConfirmation.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0010\u0010\u0011J/\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\n\u0010\u0006\u001a\u00060\u0004j\u0002`\u00052\n\u0010\b\u001a\u00060\u0004j\u0002`\u0007H\u0007¢\u0006\u0004\b\n\u0010\u000bR\u0016\u0010\r\u001a\u00020\f8\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u000f\u001a\u00020\f8\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000f\u0010\u000e¨\u0006\u0012"}, d2 = {"Lcom/discord/widgets/servers/guildboost/WidgetGuildBoostConfirmation$Companion;", "", "Landroid/content/Context;", "context", "", "Lcom/discord/primitives/GuildId;", "guildId", "Lcom/discord/primitives/GuildBoostSlotId;", "slotId", "", "create", "(Landroid/content/Context;JJ)V", "", WidgetServerSettingsChannels.INTENT_EXTRA_GUILD_ID, "Ljava/lang/String;", "INTENT_EXTRA_SLOT_ID", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public final void create(Context context, long guildId, long slotId) {
            Intrinsics3.checkNotNullParameter(context, "context");
            Intent intentPutExtra = new Intent().putExtra(WidgetGuildBoostConfirmation.INTENT_EXTRA_GUILD_ID, guildId).putExtra(WidgetGuildBoostConfirmation.INTENT_EXTRA_SLOT_ID, slotId);
            Intrinsics3.checkNotNullExpressionValue(intentPutExtra, "Intent()\n          .putE…NT_EXTRA_SLOT_ID, slotId)");
            AppScreen2.d(context, WidgetGuildBoostConfirmation.class, intentPutExtra);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            GuildBoostInProgressViewModel.GuildBoostState.values();
            int[] iArr = new int[4];
            $EnumSwitchMapping$0 = iArr;
            iArr[GuildBoostInProgressViewModel.GuildBoostState.NOT_IN_PROGRESS.ordinal()] = 1;
            iArr[GuildBoostInProgressViewModel.GuildBoostState.CALL_IN_PROGRESS.ordinal()] = 2;
            iArr[GuildBoostInProgressViewModel.GuildBoostState.ERROR.ordinal()] = 3;
            iArr[GuildBoostInProgressViewModel.GuildBoostState.COMPLETED.ordinal()] = 4;
        }
    }

    /* compiled from: WidgetGuildBoostConfirmation.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.servers.guildboost.WidgetGuildBoostConfirmation$configureUI$1, reason: invalid class name */
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
            FragmentActivity activity = WidgetGuildBoostConfirmation.this.getActivity();
            if (activity != null) {
                activity.finish();
            }
        }
    }

    /* compiled from: WidgetGuildBoostConfirmation.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/widgets/servers/guildboost/GuildBoostInProgressViewModel$ViewState;", "p1", "", "invoke", "(Lcom/discord/widgets/servers/guildboost/GuildBoostInProgressViewModel$ViewState;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.servers.guildboost.WidgetGuildBoostConfirmation$onResume$1, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<GuildBoostInProgressViewModel.ViewState, Unit> {
        public AnonymousClass1(WidgetGuildBoostConfirmation widgetGuildBoostConfirmation) {
            super(1, widgetGuildBoostConfirmation, WidgetGuildBoostConfirmation.class, "configureUI", "configureUI(Lcom/discord/widgets/servers/guildboost/GuildBoostInProgressViewModel$ViewState;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(GuildBoostInProgressViewModel.ViewState viewState) {
            invoke2(viewState);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(GuildBoostInProgressViewModel.ViewState viewState) {
            Intrinsics3.checkNotNullParameter(viewState, "p1");
            WidgetGuildBoostConfirmation.access$configureUI((WidgetGuildBoostConfirmation) this.receiver, viewState);
        }
    }

    /* compiled from: WidgetGuildBoostConfirmation.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.servers.guildboost.WidgetGuildBoostConfirmation$onViewBound$1, reason: invalid class name */
    public static final class AnonymousClass1 implements View.OnClickListener {
        public AnonymousClass1() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetGuildBoostConfirmation.access$getViewModel$p(WidgetGuildBoostConfirmation.this).subscribeToGuildBoost(WidgetGuildBoostConfirmation.access$getGuildId$p(WidgetGuildBoostConfirmation.this), WidgetGuildBoostConfirmation.access$getSlotId$p(WidgetGuildBoostConfirmation.this));
        }
    }

    public WidgetGuildBoostConfirmation() {
        super(R.layout.widget_server_boost_confirmation);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetGuildBoostConfirmation2.INSTANCE, null, 2, null);
        WidgetGuildBoostConfirmation5 widgetGuildBoostConfirmation5 = new WidgetGuildBoostConfirmation5(this);
        AppViewModelDelegates3 appViewModelDelegates3 = new AppViewModelDelegates3(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection2.getOrCreateKotlinClass(GuildBoostInProgressViewModel.class), new WidgetGuildBoostConfirmation$appViewModels$$inlined$viewModels$1(appViewModelDelegates3), new AppViewModelDelegates5(widgetGuildBoostConfirmation5));
        this.guildId = LazyJVM.lazy(new WidgetGuildBoostConfirmation3(this));
        this.slotId = LazyJVM.lazy(new WidgetGuildBoostConfirmation4(this));
    }

    public static final /* synthetic */ void access$configureUI(WidgetGuildBoostConfirmation widgetGuildBoostConfirmation, GuildBoostInProgressViewModel.ViewState viewState) {
        widgetGuildBoostConfirmation.configureUI(viewState);
    }

    public static final /* synthetic */ long access$getGuildId$p(WidgetGuildBoostConfirmation widgetGuildBoostConfirmation) {
        return widgetGuildBoostConfirmation.getGuildId();
    }

    public static final /* synthetic */ long access$getSlotId$p(WidgetGuildBoostConfirmation widgetGuildBoostConfirmation) {
        return widgetGuildBoostConfirmation.getSlotId();
    }

    public static final /* synthetic */ GuildBoostInProgressViewModel access$getViewModel$p(WidgetGuildBoostConfirmation widgetGuildBoostConfirmation) {
        return widgetGuildBoostConfirmation.getViewModel();
    }

    private final void configureToolbar(String guildName) {
        setActionBarTitle(R.string.premium_guild_perks_modal_header);
        setActionBarSubtitle(guildName);
    }

    private final void configureUI(GuildBoostInProgressViewModel.ViewState viewModelViewState) {
        if (viewModelViewState instanceof GuildBoostInProgressViewModel.ViewState.Uninitialized) {
            return;
        }
        Objects.requireNonNull(viewModelViewState, "null cannot be cast to non-null type com.discord.widgets.servers.guildboost.GuildBoostInProgressViewModel.ViewState.Loaded");
        GuildBoostInProgressViewModel.ViewState.Loaded loaded = (GuildBoostInProgressViewModel.ViewState.Loaded) viewModelViewState;
        if (loaded.getGuild() == null) {
            requireActivity().finish();
            return;
        }
        configureToolbar(loaded.getGuild().getName());
        getBinding().f2534b.b(loaded.getGuild(), 1);
        int iOrdinal = loaded.getGuildBoostState().ordinal();
        if (iOrdinal == 0) {
            DimmerView.setDimmed$default(getBinding().f, false, false, 2, null);
            TextView textView = getBinding().d;
            Intrinsics3.checkNotNullExpressionValue(textView, "binding.boostConfirmationError");
            textView.setVisibility(4);
            return;
        }
        if (iOrdinal == 1) {
            DimmerView.setDimmed$default(getBinding().f, true, false, 2, null);
            TextView textView2 = getBinding().d;
            Intrinsics3.checkNotNullExpressionValue(textView2, "binding.boostConfirmationError");
            textView2.setVisibility(4);
            return;
        }
        if (iOrdinal != 2) {
            if (iOrdinal != 3) {
                return;
            }
            DimmerView.setDimmed$default(getBinding().f, false, false, 2, null);
            TextView textView3 = getBinding().d;
            Intrinsics3.checkNotNullExpressionValue(textView3, "binding.boostConfirmationError");
            textView3.setVisibility(0);
            return;
        }
        if (loaded.getCanShowConfirmationDialog()) {
            GuildBoostActivatedDialog.Companion aVar = GuildBoostActivatedDialog.INSTANCE;
            FragmentManager parentFragmentManager = getParentFragmentManager();
            Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
            aVar.a(parentFragmentManager, requireContext(), loaded.getGuild().getName(), loaded.getSubscriptionCount() + 1, false, new AnonymousClass1());
        }
    }

    public static final void create(Context context, long j, long j2) {
        INSTANCE.create(context, j, j2);
    }

    private final WidgetServerBoostConfirmationBinding getBinding() {
        return (WidgetServerBoostConfirmationBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final long getGuildId() {
        return ((Number) this.guildId.getValue()).longValue();
    }

    private final long getSlotId() {
        return ((Number) this.slotId.getValue()).longValue();
    }

    private final GuildBoostInProgressViewModel getViewModel() {
        return (GuildBoostInProgressViewModel) this.viewModel.getValue();
    }

    @Override // com.discord.app.AppFragment, androidx.fragment.app.Fragment
    public void onResume() {
        AppActivity appActivity;
        super.onResume();
        if ((getGuildId() == 0 || getGuildId() == -1) && (appActivity = getAppActivity()) != null) {
            appActivity.finish();
        }
        Observable observableR = ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeViewState(), this, null, 2, null).r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "viewModel\n        .obser…  .distinctUntilChanged()");
        ObservableExtensionsKt.appSubscribe$default(observableR, WidgetGuildBoostConfirmation.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(this), 62, (Object) null);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        AppFragment.setActionBarDisplayHomeAsUpEnabled$default(this, false, 1, null);
        getBinding().e.setOnClickListener(new AnonymousClass1());
        MaterialButton materialButton = getBinding().e;
        Intrinsics3.checkNotNullExpressionValue(materialButton, "binding.boostConfirmationSelect");
        materialButton.setText(FormatUtils.k(this, R.string.premium_guild_subscribe_confirm_confirmation, new Object[]{StringResourceUtils.getI18nPluralString(requireContext(), R.plurals.premium_guild_subscribe_confirm_confirmation_slotCount, 1, 1)}, null, 4));
        CharSequence i18nPluralString = StringResourceUtils.getI18nPluralString(requireContext(), R.plurals.premium_guild_subscribe_confirm_cooldown_warning_days, 7, 7);
        CharSequence i18nPluralString2 = StringResourceUtils.getI18nPluralString(requireContext(), R.plurals.premium_guild_subscribe_confirm_cooldown_warning_slotCount, 1, 1);
        TextView textView = getBinding().c;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.boostConfirmationCooldownWarning");
        textView.setText(FormatUtils.k(this, R.string.premium_guild_subscribe_confirm_cooldown_warning, new Object[]{i18nPluralString2, i18nPluralString}, null, 4));
    }
}
