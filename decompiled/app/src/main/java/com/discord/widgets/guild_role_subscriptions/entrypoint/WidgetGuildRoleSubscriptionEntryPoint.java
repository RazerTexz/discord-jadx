package com.discord.widgets.guild_role_subscriptions.entrypoint;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import b.a.d.AppScreen2;
import b.a.d.AppViewModelDelegates3;
import b.a.d.AppViewModelDelegates5;
import b.a.k.FormatUtils;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetGuildRoleSubscriptionEntryPointBinding;
import com.discord.i18n.Hook;
import com.discord.i18n.RenderContext;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.widgets.guild_role_subscriptions.entrypoint.WidgetGuildRoleSubscriptionEntryPointViewModel;
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

/* compiled from: WidgetGuildRoleSubscriptionEntryPoint.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u0000 *2\u00020\u0001:\u0001*B\u0007¢\u0006\u0004\b)\u0010\u0014J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J-\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ!\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0013\u0010\u0014R\u001d\u0010\u001a\u001a\u00020\u00158B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001e\u001a\u00020\u001b8B@\u0002X\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001dR\u001d\u0010$\u001a\u00020\u001f8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#R\u0018\u0010(\u001a\u0004\u0018\u00010%8B@\u0002X\u0082\u0004¢\u0006\u0006\u001a\u0004\b&\u0010'¨\u0006+"}, d2 = {"Lcom/discord/widgets/guild_role_subscriptions/entrypoint/WidgetGuildRoleSubscriptionEntryPoint;", "Lcom/discord/app/AppFragment;", "Lcom/discord/widgets/guild_role_subscriptions/entrypoint/WidgetGuildRoleSubscriptionEntryPointViewModel$ViewState;", "viewState", "", "configureUI", "(Lcom/discord/widgets/guild_role_subscriptions/entrypoint/WidgetGuildRoleSubscriptionEntryPointViewModel$ViewState;)V", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "onViewBoundOrOnResume", "()V", "Lcom/discord/widgets/guild_role_subscriptions/entrypoint/WidgetGuildRoleSubscriptionEntryPointViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "getViewModel", "()Lcom/discord/widgets/guild_role_subscriptions/entrypoint/WidgetGuildRoleSubscriptionEntryPointViewModel;", "viewModel", "", "getGuildId", "()J", "guildId", "Lcom/discord/databinding/WidgetGuildRoleSubscriptionEntryPointBinding;", "viewBinding$delegate", "Lcom/discord/utilities/viewbinding/FragmentViewBindingDelegate;", "getViewBinding", "()Lcom/discord/databinding/WidgetGuildRoleSubscriptionEntryPointBinding;", "viewBinding", "", "getTrackingSourceLocation", "()Ljava/lang/String;", "trackingSourceLocation", "<init>", "Companion", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class WidgetGuildRoleSubscriptionEntryPoint extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetGuildRoleSubscriptionEntryPoint.class, "viewBinding", "getViewBinding()Lcom/discord/databinding/WidgetGuildRoleSubscriptionEntryPointBinding;", 0)};

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String INTENT_EXTRA_TRACKING_SOURCE_LOCATION = "INTENT_EXTRA_TRACKING_SOURCE_LOCATION";

    /* renamed from: viewBinding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate viewBinding;

    /* renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* compiled from: WidgetGuildRoleSubscriptionEntryPoint.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ+\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\n\u0010\u0006\u001a\u00060\u0004j\u0002`\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0007¢\u0006\u0004\b\n\u0010\u000bR\u0016\u0010\f\u001a\u00020\u00078\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\f\u0010\r¨\u0006\u0010"}, d2 = {"Lcom/discord/widgets/guild_role_subscriptions/entrypoint/WidgetGuildRoleSubscriptionEntryPoint$Companion;", "", "Landroid/content/Context;", "context", "", "Lcom/discord/primitives/GuildId;", "guildId", "", "trackingSourceLocation", "", "launch", "(Landroid/content/Context;JLjava/lang/String;)V", WidgetGuildRoleSubscriptionEntryPoint.INTENT_EXTRA_TRACKING_SOURCE_LOCATION, "Ljava/lang/String;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public final void launch(Context context, long guildId, String trackingSourceLocation) {
            Intrinsics3.checkNotNullParameter(context, "context");
            Intrinsics3.checkNotNullParameter(trackingSourceLocation, "trackingSourceLocation");
            Intent intent = new Intent();
            intent.putExtra("com.discord.intent.extra.EXTRA_GUILD_ID", guildId);
            intent.putExtra(WidgetGuildRoleSubscriptionEntryPoint.INTENT_EXTRA_TRACKING_SOURCE_LOCATION, trackingSourceLocation);
            AppScreen2.d(context, WidgetGuildRoleSubscriptionEntryPoint.class, intent);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetGuildRoleSubscriptionEntryPoint.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/discord/i18n/RenderContext;", "", "invoke", "(Lcom/discord/i18n/RenderContext;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.guild_role_subscriptions.entrypoint.WidgetGuildRoleSubscriptionEntryPoint$configureUI$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<RenderContext, Unit> {
        public final /* synthetic */ WidgetGuildRoleSubscriptionEntryPointViewModel.ViewState $viewState;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(WidgetGuildRoleSubscriptionEntryPointViewModel.ViewState viewState) {
            super(1);
            this.$viewState = viewState;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(RenderContext renderContext) {
            Intrinsics3.checkNotNullParameter(renderContext, "$receiver");
            renderContext.args.put("serverName", ((WidgetGuildRoleSubscriptionEntryPointViewModel.ViewState.Valid) this.$viewState).getGuild().getName());
            renderContext.a("serverNameHook", new C02901());
        }

        /* compiled from: WidgetGuildRoleSubscriptionEntryPoint.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/discord/i18n/Hook;", "", "invoke", "(Lcom/discord/i18n/Hook;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
        /* renamed from: com.discord.widgets.guild_role_subscriptions.entrypoint.WidgetGuildRoleSubscriptionEntryPoint$configureUI$1$1, reason: invalid class name and collision with other inner class name */
        public static final class C02901 extends Lambda implements Function1<Hook, Unit> {
            public C02901() {
                super(1);
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Hook hook) {
                Intrinsics3.checkNotNullParameter(hook, "$receiver");
                hook.styles.add(new ForegroundColorSpan(ColorCompat.getThemedColor(WidgetGuildRoleSubscriptionEntryPoint.this.getContext(), R.attr.primary_000)));
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Hook hook) {
                invoke2(hook);
                return Unit.a;
            }
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(RenderContext renderContext) {
            invoke2(renderContext);
            return Unit.a;
        }
    }

    /* compiled from: WidgetGuildRoleSubscriptionEntryPoint.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/widgets/guild_role_subscriptions/entrypoint/WidgetGuildRoleSubscriptionEntryPointViewModel$ViewState;", "p1", "", "invoke", "(Lcom/discord/widgets/guild_role_subscriptions/entrypoint/WidgetGuildRoleSubscriptionEntryPointViewModel$ViewState;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.guild_role_subscriptions.entrypoint.WidgetGuildRoleSubscriptionEntryPoint$onViewBoundOrOnResume$1, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<WidgetGuildRoleSubscriptionEntryPointViewModel.ViewState, Unit> {
        public AnonymousClass1(WidgetGuildRoleSubscriptionEntryPoint widgetGuildRoleSubscriptionEntryPoint) {
            super(1, widgetGuildRoleSubscriptionEntryPoint, WidgetGuildRoleSubscriptionEntryPoint.class, "configureUI", "configureUI(Lcom/discord/widgets/guild_role_subscriptions/entrypoint/WidgetGuildRoleSubscriptionEntryPointViewModel$ViewState;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(WidgetGuildRoleSubscriptionEntryPointViewModel.ViewState viewState) {
            invoke2(viewState);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(WidgetGuildRoleSubscriptionEntryPointViewModel.ViewState viewState) {
            Intrinsics3.checkNotNullParameter(viewState, "p1");
            WidgetGuildRoleSubscriptionEntryPoint.access$configureUI((WidgetGuildRoleSubscriptionEntryPoint) this.receiver, viewState);
        }
    }

    public WidgetGuildRoleSubscriptionEntryPoint() {
        super(R.layout.widget_guild_role_subscription_entry_point);
        this.viewBinding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetGuildRoleSubscriptionEntryPoint2.INSTANCE, null, 2, null);
        WidgetGuildRoleSubscriptionEntryPoint3 widgetGuildRoleSubscriptionEntryPoint3 = WidgetGuildRoleSubscriptionEntryPoint3.INSTANCE;
        AppViewModelDelegates3 appViewModelDelegates3 = new AppViewModelDelegates3(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection2.getOrCreateKotlinClass(WidgetGuildRoleSubscriptionEntryPointViewModel.class), new WidgetGuildRoleSubscriptionEntryPoint$appViewModels$$inlined$viewModels$1(appViewModelDelegates3), new AppViewModelDelegates5(widgetGuildRoleSubscriptionEntryPoint3));
    }

    public static final /* synthetic */ void access$configureUI(WidgetGuildRoleSubscriptionEntryPoint widgetGuildRoleSubscriptionEntryPoint, WidgetGuildRoleSubscriptionEntryPointViewModel.ViewState viewState) {
        widgetGuildRoleSubscriptionEntryPoint.configureUI(viewState);
    }

    private final void configureUI(WidgetGuildRoleSubscriptionEntryPointViewModel.ViewState viewState) {
        if (viewState instanceof WidgetGuildRoleSubscriptionEntryPointViewModel.ViewState.Uninitialized) {
            TextView textView = getViewBinding().f2434b;
            Intrinsics3.checkNotNullExpressionValue(textView, "viewBinding.description");
            textView.setVisibility(8);
        } else {
            if (viewState instanceof WidgetGuildRoleSubscriptionEntryPointViewModel.ViewState.Invalid) {
                requireActivity().onBackPressed();
                return;
            }
            if (viewState instanceof WidgetGuildRoleSubscriptionEntryPointViewModel.ViewState.Valid) {
                TextView textView2 = getViewBinding().c;
                Intrinsics3.checkNotNullExpressionValue(textView2, "viewBinding.title");
                FormatUtils.m(textView2, R.string.guild_role_subscription_purchase_page_unavailable_cta_hook, new Object[0], new AnonymousClass1(viewState));
                TextView textView3 = getViewBinding().f2434b;
                Intrinsics3.checkNotNullExpressionValue(textView3, "viewBinding.description");
                textView3.setVisibility(0);
            }
        }
    }

    private final long getGuildId() {
        return getMostRecentIntent().getLongExtra("com.discord.intent.extra.EXTRA_GUILD_ID", -1L);
    }

    private final String getTrackingSourceLocation() {
        return getMostRecentIntent().getStringExtra(INTENT_EXTRA_TRACKING_SOURCE_LOCATION);
    }

    private final WidgetGuildRoleSubscriptionEntryPointBinding getViewBinding() {
        return (WidgetGuildRoleSubscriptionEntryPointBinding) this.viewBinding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final WidgetGuildRoleSubscriptionEntryPointViewModel getViewModel() {
        return (WidgetGuildRoleSubscriptionEntryPointViewModel) this.viewModel.getValue();
    }

    public static final void launch(Context context, long j, String str) {
        INSTANCE.launch(context, j, str);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics3.checkNotNullParameter(inflater, "inflater");
        getViewModel().setGuildId(getGuildId());
        getViewModel().setTrackingSourceLocation(getTrackingSourceLocation());
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeViewState(), this, null, 2, null), WidgetGuildRoleSubscriptionEntryPoint.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(this), 62, (Object) null);
    }

    @Override // com.discord.app.AppFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        AppFragment.setActionBarDisplayHomeAsUpEnabled$default(this, false, 1, null);
    }
}
