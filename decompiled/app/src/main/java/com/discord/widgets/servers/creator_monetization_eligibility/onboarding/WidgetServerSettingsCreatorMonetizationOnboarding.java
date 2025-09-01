package com.discord.widgets.servers.creator_monetization_eligibility.onboarding;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import b.a.d.AppScreen2;
import b.a.d.AppViewModelDelegates3;
import b.a.d.AppViewModelDelegates5;
import b.a.k.FormatUtils;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.api.creatormonetization.CreatorMonetizationEligibilityRequirements;
import com.discord.api.creatormonetization.CreatorMonetizationEnableRequest;
import com.discord.api.guild.GuildFeature;
import com.discord.app.AppFragment;
import com.discord.app.AppLogger2;
import com.discord.app.AppViewFlipper;
import com.discord.databinding.WidgetServerSettingsCreatorMonetizationOnboardingAcceptTermsBinding;
import com.discord.databinding.WidgetServerSettingsCreatorMonetizationOnboardingBinding;
import com.discord.databinding.WidgetServerSettingsCreatorMonetizationOnboardingCreateRequestBinding;
import com.discord.i18n.Hook;
import com.discord.i18n.RenderContext;
import com.discord.utilities.KotlinExtensions;
import com.discord.utilities.color.ColorCompat2;
import com.discord.utilities.error.Error;
import com.discord.utilities.resources.DurationUtils2;
import com.discord.utilities.resources.DurationUtils3;
import com.discord.utilities.resources.DurationUtils4;
import com.discord.utilities.resources.StringResourceUtils;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.textprocessing.FontColorSpan;
import com.discord.utilities.time.Clock;
import com.discord.utilities.time.ClockFactory;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.utilities.views.viewstub.LazyViewStubDelegate;
import com.discord.views.LoadingButton;
import com.discord.widgets.servers.creator_monetization_eligibility.EligibilityChecklistView;
import com.discord.widgets.servers.creator_monetization_eligibility.onboarding.ServerSettingsCreatorMonetizationOnboardingViewModel;
import com.discord.widgets.servers.guild_role_subscription.WidgetServerSettingsEmptyGuildRoleSubscriptions;
import com.google.android.material.button.MaterialButton;
import d0.LazyJVM;
import d0.t.Collections2;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import d0.z.d.Reflection2;
import java.util.List;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import rx.Observable;

/* compiled from: WidgetServerSettingsCreatorMonetizationOnboarding.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u008c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 I2\u00020\u0001:\u0001IB\u0007¢\u0006\u0004\bH\u0010 J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\f\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u000f\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u0019\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012*\u00020\u0011H\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0017\u001a\u00020\u0016H\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\u0017\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u001bH\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ\u000f\u0010\u001f\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u001f\u0010 R\u001d\u0010&\u001a\u00020!8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%R\u001d\u0010)\u001a\u00020!8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b'\u0010#\u001a\u0004\b(\u0010%R\u001d\u0010.\u001a\u00020*8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b+\u0010#\u001a\u0004\b,\u0010-R\u001d\u00103\u001a\u00020/8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b0\u0010#\u001a\u0004\b1\u00102R\u001d\u00108\u001a\u0002048B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b5\u0010#\u001a\u0004\b6\u00107R\u001d\u0010>\u001a\u0002098B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b:\u0010;\u001a\u0004\b<\u0010=R\u001d\u0010C\u001a\u00020?8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b@\u0010#\u001a\u0004\bA\u0010BR\u0018\u0010G\u001a\u0004\u0018\u00010D8V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\bE\u0010F¨\u0006J"}, d2 = {"Lcom/discord/widgets/servers/creator_monetization_eligibility/onboarding/WidgetServerSettingsCreatorMonetizationOnboarding;", "Lcom/discord/app/AppFragment;", "Lcom/discord/widgets/servers/creator_monetization_eligibility/onboarding/ServerSettingsCreatorMonetizationOnboardingViewModel$Event;", "event", "", "handleEvent", "(Lcom/discord/widgets/servers/creator_monetization_eligibility/onboarding/ServerSettingsCreatorMonetizationOnboardingViewModel$Event;)V", "Lcom/discord/widgets/servers/creator_monetization_eligibility/onboarding/ServerSettingsCreatorMonetizationOnboardingViewModel$ViewState;", "viewState", "configureUI", "(Lcom/discord/widgets/servers/creator_monetization_eligibility/onboarding/ServerSettingsCreatorMonetizationOnboardingViewModel$ViewState;)V", "Lcom/discord/widgets/servers/creator_monetization_eligibility/onboarding/ServerSettingsCreatorMonetizationOnboardingViewModel$ViewState$CreateRequest;", "configureCreateRequestState", "(Lcom/discord/widgets/servers/creator_monetization_eligibility/onboarding/ServerSettingsCreatorMonetizationOnboardingViewModel$ViewState$CreateRequest;)V", "Lcom/discord/widgets/servers/creator_monetization_eligibility/onboarding/ServerSettingsCreatorMonetizationOnboardingViewModel$ViewState$AcceptTerms;", "configureAcceptTermsState", "(Lcom/discord/widgets/servers/creator_monetization_eligibility/onboarding/ServerSettingsCreatorMonetizationOnboardingViewModel$ViewState$AcceptTerms;)V", "Lcom/discord/api/creatormonetization/CreatorMonetizationEligibilityRequirements;", "", "Lcom/discord/widgets/servers/creator_monetization_eligibility/EligibilityChecklistView$Requirement;", "toChecklistRequirements", "(Lcom/discord/api/creatormonetization/CreatorMonetizationEligibilityRequirements;)Ljava/util/List;", "", "minimumAgeInDays", "", "formatDurationFromDays", "(I)Ljava/lang/CharSequence;", "Landroid/view/View;", "view", "onViewBound", "(Landroid/view/View;)V", "onViewBoundOrOnResume", "()V", "Lcom/discord/utilities/views/viewstub/LazyViewStubDelegate;", "acceptTermsOnlyGuildOwnerNotice$delegate", "Lkotlin/Lazy;", "getAcceptTermsOnlyGuildOwnerNotice", "()Lcom/discord/utilities/views/viewstub/LazyViewStubDelegate;", "acceptTermsOnlyGuildOwnerNotice", "createRequestOnlyGuildOwnerNotice$delegate", "getCreateRequestOnlyGuildOwnerNotice", "createRequestOnlyGuildOwnerNotice", "Lcom/discord/databinding/WidgetServerSettingsCreatorMonetizationOnboardingCreateRequestBinding;", "createRequestBinding$delegate", "getCreateRequestBinding", "()Lcom/discord/databinding/WidgetServerSettingsCreatorMonetizationOnboardingCreateRequestBinding;", "createRequestBinding", "Lcom/discord/databinding/WidgetServerSettingsCreatorMonetizationOnboardingAcceptTermsBinding;", "acceptTermsBinding$delegate", "getAcceptTermsBinding", "()Lcom/discord/databinding/WidgetServerSettingsCreatorMonetizationOnboardingAcceptTermsBinding;", "acceptTermsBinding", "", "guildId$delegate", "getGuildId", "()J", "guildId", "Lcom/discord/databinding/WidgetServerSettingsCreatorMonetizationOnboardingBinding;", "binding$delegate", "Lcom/discord/utilities/viewbinding/FragmentViewBindingDelegate;", "getBinding", "()Lcom/discord/databinding/WidgetServerSettingsCreatorMonetizationOnboardingBinding;", "binding", "Lcom/discord/widgets/servers/creator_monetization_eligibility/onboarding/ServerSettingsCreatorMonetizationOnboardingViewModel;", "viewModel$delegate", "getViewModel", "()Lcom/discord/widgets/servers/creator_monetization_eligibility/onboarding/ServerSettingsCreatorMonetizationOnboardingViewModel;", "viewModel", "Lcom/discord/app/LoggingConfig;", "getLoggingConfig", "()Lcom/discord/app/LoggingConfig;", "loggingConfig", "<init>", "Companion", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class WidgetServerSettingsCreatorMonetizationOnboarding extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetServerSettingsCreatorMonetizationOnboarding.class, "binding", "getBinding()Lcom/discord/databinding/WidgetServerSettingsCreatorMonetizationOnboardingBinding;", 0)};

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final int VIEW_FLIPPER_ACCEPT_TERMS_STATE = 3;
    private static final int VIEW_FLIPPER_CREATE_REQUEST_STATE = 2;
    private static final int VIEW_FLIPPER_ERROR_STATE = 1;
    private static final int VIEW_FLIPPER_LOADING_STATE = 0;

    /* renamed from: acceptTermsBinding$delegate, reason: from kotlin metadata */
    private final Lazy acceptTermsBinding;

    /* renamed from: acceptTermsOnlyGuildOwnerNotice$delegate, reason: from kotlin metadata */
    private final Lazy acceptTermsOnlyGuildOwnerNotice;

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* renamed from: createRequestBinding$delegate, reason: from kotlin metadata */
    private final Lazy createRequestBinding;

    /* renamed from: createRequestOnlyGuildOwnerNotice$delegate, reason: from kotlin metadata */
    private final Lazy createRequestOnlyGuildOwnerNotice;

    /* renamed from: guildId$delegate, reason: from kotlin metadata */
    private final Lazy guildId;

    /* renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* compiled from: WidgetServerSettingsCreatorMonetizationOnboarding.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0017\u0010\u0018J'\u0010\b\u001a\u0004\u0018\u00010\u0007*\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\b\u0010\tJ#\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\n\u001a\u00020\u00022\n\u0010\r\u001a\u00060\u000bj\u0002`\fH\u0007¢\u0006\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0012\u001a\u00020\u00118\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0014\u001a\u00020\u00118\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0014\u0010\u0013R\u0016\u0010\u0015\u001a\u00020\u00118\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0015\u0010\u0013R\u0016\u0010\u0016\u001a\u00020\u00118\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0016\u0010\u0013¨\u0006\u0019"}, d2 = {"Lcom/discord/widgets/servers/creator_monetization_eligibility/onboarding/WidgetServerSettingsCreatorMonetizationOnboarding$Companion;", "", "Landroid/content/Context;", "Lcom/discord/api/creatormonetization/CreatorMonetizationEligibilityRequirements$Rejection;", "rejection", "Lcom/discord/utilities/time/Clock;", "clock", "", "formatRejectionCooldown", "(Landroid/content/Context;Lcom/discord/api/creatormonetization/CreatorMonetizationEligibilityRequirements$Rejection;Lcom/discord/utilities/time/Clock;)Ljava/lang/CharSequence;", "context", "", "Lcom/discord/primitives/GuildId;", "guildId", "", "launch", "(Landroid/content/Context;J)V", "", "VIEW_FLIPPER_ACCEPT_TERMS_STATE", "I", "VIEW_FLIPPER_CREATE_REQUEST_STATE", "VIEW_FLIPPER_ERROR_STATE", "VIEW_FLIPPER_LOADING_STATE", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        private final CharSequence formatRejectionCooldown(Context context, CreatorMonetizationEligibilityRequirements.Rejection rejection, Clock clock) {
            long time = rejection.getCanReapplyAt().getTime() - clock.currentTimeMillis();
            if (time <= 0) {
                return null;
            }
            return DurationUtils4.INSTANCE.formatDurationInMillis(context, time);
        }

        public static /* synthetic */ CharSequence formatRejectionCooldown$default(Companion companion, Context context, CreatorMonetizationEligibilityRequirements.Rejection rejection, Clock clock, int i, Object obj) {
            if ((i & 2) != 0) {
                clock = ClockFactory.get();
            }
            return companion.formatRejectionCooldown(context, rejection, clock);
        }

        public final void launch(Context context, long guildId) {
            Intrinsics3.checkNotNullParameter(context, "context");
            Intent intent = new Intent();
            intent.putExtra("com.discord.intent.extra.EXTRA_GUILD_ID", guildId);
            AppScreen2.d(context, WidgetServerSettingsCreatorMonetizationOnboarding.class, intent);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetServerSettingsCreatorMonetizationOnboarding.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/discord/i18n/RenderContext;", "", "invoke", "(Lcom/discord/i18n/RenderContext;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.servers.creator_monetization_eligibility.onboarding.WidgetServerSettingsCreatorMonetizationOnboarding$configureCreateRequestState$4, reason: invalid class name */
    public static final class AnonymousClass4 extends Lambda implements Function1<RenderContext, Unit> {
        public AnonymousClass4() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(RenderContext renderContext) {
            invoke2(renderContext);
            return Unit.a;
        }

        /* compiled from: WidgetServerSettingsCreatorMonetizationOnboarding.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/discord/i18n/Hook;", "", "invoke", "(Lcom/discord/i18n/Hook;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
        /* renamed from: com.discord.widgets.servers.creator_monetization_eligibility.onboarding.WidgetServerSettingsCreatorMonetizationOnboarding$configureCreateRequestState$4$1, reason: invalid class name */
        public static final class AnonymousClass1 extends Lambda implements Function1<Hook, Unit> {
            public AnonymousClass1() {
                super(1);
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Hook hook) {
                Intrinsics3.checkNotNullParameter(hook, "$receiver");
                hook.styles.add(new FontColorSpan(ColorCompat2.getColor(WidgetServerSettingsCreatorMonetizationOnboarding.this, R.color.status_red_500)));
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Hook hook) {
                invoke2(hook);
                return Unit.a;
            }
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(RenderContext renderContext) {
            Intrinsics3.checkNotNullParameter(renderContext, "$receiver");
            renderContext.a("doesNotHook", new AnonymousClass1());
        }
    }

    /* compiled from: WidgetServerSettingsCreatorMonetizationOnboarding.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/discord/widgets/servers/creator_monetization_eligibility/onboarding/ServerSettingsCreatorMonetizationOnboardingViewModel$ViewState;", "kotlin.jvm.PlatformType", "it", "", "invoke", "(Lcom/discord/widgets/servers/creator_monetization_eligibility/onboarding/ServerSettingsCreatorMonetizationOnboardingViewModel$ViewState;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.servers.creator_monetization_eligibility.onboarding.WidgetServerSettingsCreatorMonetizationOnboarding$onViewBoundOrOnResume$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<ServerSettingsCreatorMonetizationOnboardingViewModel.ViewState, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ServerSettingsCreatorMonetizationOnboardingViewModel.ViewState viewState) {
            invoke2(viewState);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ServerSettingsCreatorMonetizationOnboardingViewModel.ViewState viewState) {
            WidgetServerSettingsCreatorMonetizationOnboarding widgetServerSettingsCreatorMonetizationOnboarding = WidgetServerSettingsCreatorMonetizationOnboarding.this;
            Intrinsics3.checkNotNullExpressionValue(viewState, "it");
            WidgetServerSettingsCreatorMonetizationOnboarding.access$configureUI(widgetServerSettingsCreatorMonetizationOnboarding, viewState);
            WidgetServerSettingsCreatorMonetizationOnboarding.this.getAppLogger().b();
        }
    }

    /* compiled from: WidgetServerSettingsCreatorMonetizationOnboarding.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/widgets/servers/creator_monetization_eligibility/onboarding/ServerSettingsCreatorMonetizationOnboardingViewModel$Event;", "it", "", "invoke", "(Lcom/discord/widgets/servers/creator_monetization_eligibility/onboarding/ServerSettingsCreatorMonetizationOnboardingViewModel$Event;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.servers.creator_monetization_eligibility.onboarding.WidgetServerSettingsCreatorMonetizationOnboarding$onViewBoundOrOnResume$2, reason: invalid class name */
    public static final class AnonymousClass2 extends Lambda implements Function1<ServerSettingsCreatorMonetizationOnboardingViewModel.Event, Unit> {
        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ServerSettingsCreatorMonetizationOnboardingViewModel.Event event) throws Throwable {
            invoke2(event);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ServerSettingsCreatorMonetizationOnboardingViewModel.Event event) throws Throwable {
            Intrinsics3.checkNotNullParameter(event, "it");
            WidgetServerSettingsCreatorMonetizationOnboarding.access$handleEvent(WidgetServerSettingsCreatorMonetizationOnboarding.this, event);
        }
    }

    public WidgetServerSettingsCreatorMonetizationOnboarding() {
        super(R.layout.widget_server_settings_creator_monetization_onboarding);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetServerSettingsCreatorMonetizationOnboarding$binding$2.INSTANCE, null, 2, null);
        this.guildId = LazyJVM.lazy(new WidgetServerSettingsCreatorMonetizationOnboarding$guildId$2(this));
        WidgetServerSettingsCreatorMonetizationOnboarding$viewModel$2 widgetServerSettingsCreatorMonetizationOnboarding$viewModel$2 = new WidgetServerSettingsCreatorMonetizationOnboarding$viewModel$2(this);
        AppViewModelDelegates3 appViewModelDelegates3 = new AppViewModelDelegates3(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection2.getOrCreateKotlinClass(ServerSettingsCreatorMonetizationOnboardingViewModel.class), new WidgetServerSettingsCreatorMonetizationOnboarding$appViewModels$$inlined$viewModels$1(appViewModelDelegates3), new AppViewModelDelegates5(widgetServerSettingsCreatorMonetizationOnboarding$viewModel$2));
        this.createRequestBinding = LazyJVM.lazy(new WidgetServerSettingsCreatorMonetizationOnboarding$createRequestBinding$2(this));
        this.acceptTermsBinding = LazyJVM.lazy(new WidgetServerSettingsCreatorMonetizationOnboarding$acceptTermsBinding$2(this));
        LazyViewStubDelegate.Companion companion = LazyViewStubDelegate.INSTANCE;
        this.createRequestOnlyGuildOwnerNotice = companion.lazyViewStub(new WidgetServerSettingsCreatorMonetizationOnboarding$createRequestOnlyGuildOwnerNotice$2(this));
        this.acceptTermsOnlyGuildOwnerNotice = companion.lazyViewStub(new WidgetServerSettingsCreatorMonetizationOnboarding$acceptTermsOnlyGuildOwnerNotice$2(this));
    }

    public static final /* synthetic */ void access$configureUI(WidgetServerSettingsCreatorMonetizationOnboarding widgetServerSettingsCreatorMonetizationOnboarding, ServerSettingsCreatorMonetizationOnboardingViewModel.ViewState viewState) {
        widgetServerSettingsCreatorMonetizationOnboarding.configureUI(viewState);
    }

    public static final /* synthetic */ CharSequence access$formatDurationFromDays(WidgetServerSettingsCreatorMonetizationOnboarding widgetServerSettingsCreatorMonetizationOnboarding, int i) {
        return widgetServerSettingsCreatorMonetizationOnboarding.formatDurationFromDays(i);
    }

    public static final /* synthetic */ WidgetServerSettingsCreatorMonetizationOnboardingAcceptTermsBinding access$getAcceptTermsBinding$p(WidgetServerSettingsCreatorMonetizationOnboarding widgetServerSettingsCreatorMonetizationOnboarding) {
        return widgetServerSettingsCreatorMonetizationOnboarding.getAcceptTermsBinding();
    }

    public static final /* synthetic */ WidgetServerSettingsCreatorMonetizationOnboardingBinding access$getBinding$p(WidgetServerSettingsCreatorMonetizationOnboarding widgetServerSettingsCreatorMonetizationOnboarding) {
        return widgetServerSettingsCreatorMonetizationOnboarding.getBinding();
    }

    public static final /* synthetic */ WidgetServerSettingsCreatorMonetizationOnboardingCreateRequestBinding access$getCreateRequestBinding$p(WidgetServerSettingsCreatorMonetizationOnboarding widgetServerSettingsCreatorMonetizationOnboarding) {
        return widgetServerSettingsCreatorMonetizationOnboarding.getCreateRequestBinding();
    }

    public static final /* synthetic */ long access$getGuildId$p(WidgetServerSettingsCreatorMonetizationOnboarding widgetServerSettingsCreatorMonetizationOnboarding) {
        return widgetServerSettingsCreatorMonetizationOnboarding.getGuildId();
    }

    public static final /* synthetic */ ServerSettingsCreatorMonetizationOnboardingViewModel access$getViewModel$p(WidgetServerSettingsCreatorMonetizationOnboarding widgetServerSettingsCreatorMonetizationOnboarding) {
        return widgetServerSettingsCreatorMonetizationOnboarding.getViewModel();
    }

    public static final /* synthetic */ void access$handleEvent(WidgetServerSettingsCreatorMonetizationOnboarding widgetServerSettingsCreatorMonetizationOnboarding, ServerSettingsCreatorMonetizationOnboardingViewModel.Event event) throws Throwable {
        widgetServerSettingsCreatorMonetizationOnboarding.handleEvent(event);
    }

    private final void configureAcceptTermsState(ServerSettingsCreatorMonetizationOnboardingViewModel.ViewState.AcceptTerms viewState) {
        getAcceptTermsOnlyGuildOwnerNotice().setVisible(!viewState.isGuildOwner());
        CheckBox checkBox = getAcceptTermsBinding().c;
        checkBox.setChecked(viewState.getHasAcceptedTerms());
        checkBox.setEnabled(!viewState.isSubmitting() && viewState.isGuildOwner());
        checkBox.setOnCheckedChangeListener(new WidgetServerSettingsCreatorMonetizationOnboarding$configureAcceptTermsState$$inlined$apply$lambda$1(this, viewState));
        LoadingButton loadingButton = getAcceptTermsBinding().f2557b;
        loadingButton.setEnabled(viewState.getHasAcceptedTerms() && viewState.isGuildOwner());
        loadingButton.setIsLoading(viewState.isSubmitting());
        loadingButton.setOnClickListener(new WidgetServerSettingsCreatorMonetizationOnboarding$configureAcceptTermsState$$inlined$apply$lambda$2(this, viewState));
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x009d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void configureCreateRequestState(ServerSettingsCreatorMonetizationOnboardingViewModel.ViewState.CreateRequest viewState) {
        CharSequence rejectionCooldown$default;
        LoadingButton loadingButton = getCreateRequestBinding().c;
        boolean z2 = true;
        loadingButton.setEnabled(viewState.getRequirements().getCanApply() && viewState.isGuildOwner());
        loadingButton.setVisibility(viewState.isApplicationPending() ^ true ? 0 : 8);
        loadingButton.setIsLoading(viewState.isSubmitting());
        loadingButton.setOnClickListener(new WidgetServerSettingsCreatorMonetizationOnboarding$configureCreateRequestState$$inlined$apply$lambda$1(this, viewState));
        getCreateRequestOnlyGuildOwnerNotice().setVisible(!viewState.isGuildOwner());
        MaterialButton materialButton = getCreateRequestBinding().f2559b;
        Intrinsics3.checkNotNullExpressionValue(materialButton, "createRequestBinding.applicationPendingButton");
        materialButton.setVisibility(viewState.isApplicationPending() ? 0 : 8);
        TextView textView = getCreateRequestBinding().h;
        CreatorMonetizationEligibilityRequirements.Rejection rejectionJ = viewState.getRequirements().getRejection();
        if (rejectionJ != null) {
            Companion companion = INSTANCE;
            Context context = textView.getContext();
            Intrinsics3.checkNotNullExpressionValue(context, "context");
            rejectionCooldown$default = Companion.formatRejectionCooldown$default(companion, context, rejectionJ, null, 2, null);
        } else {
            rejectionCooldown$default = null;
        }
        if (rejectionCooldown$default == null) {
            z2 = false;
        } else {
            CreatorMonetizationEnableRequest creatorMonetizationEnableRequestF = viewState.getRequirements().getLatestRequest();
            if ((creatorMonetizationEnableRequestF != null ? creatorMonetizationEnableRequestF.getState() : null) != CreatorMonetizationEnableRequest.State.REJECTED) {
            }
        }
        textView.setVisibility(z2 ? 0 : 8);
        if (rejectionCooldown$default != null) {
            FormatUtils.m(textView, R.string.guild_role_subscription_settings_enable_request_rejected, new Object[0], new WidgetServerSettingsCreatorMonetizationOnboarding$configureCreateRequestState$2$1(rejectionCooldown$default));
        }
        LinkifiedTextView linkifiedTextView = getCreateRequestBinding().i;
        Intrinsics3.checkNotNullExpressionValue(linkifiedTextView, "createRequestBinding.requirementsDescription");
        FormatUtils.m(linkifiedTextView, R.string.guild_role_subscription_settings_enable_requirements_description, new Object[0], AnonymousClass3.INSTANCE);
        ImageView imageView = getCreateRequestBinding().e;
        Intrinsics3.checkNotNullExpressionValue(imageView, "createRequestBinding.eli…yChecklistHeaderIndicator");
        imageView.setActivated(viewState.getRequirements().getSufficient());
        if (viewState.getRequirements().getSufficient()) {
            TextView textView2 = getCreateRequestBinding().f;
            Intrinsics3.checkNotNullExpressionValue(textView2, "createRequestBinding.eligibilityChecklistTitle");
            FormatUtils.n(textView2, R.string.guild_role_subscription_settings_eligible_message, new Object[0], null, 4);
        } else {
            TextView textView3 = getCreateRequestBinding().f;
            Intrinsics3.checkNotNullExpressionValue(textView3, "createRequestBinding.eligibilityChecklistTitle");
            FormatUtils.m(textView3, R.string.guild_role_subscription_settings_not_eligible_message, new Object[0], new AnonymousClass4());
        }
        getCreateRequestBinding().d.bind(toChecklistRequirements(viewState.getRequirements()));
    }

    private final void configureUI(ServerSettingsCreatorMonetizationOnboardingViewModel.ViewState viewState) {
        Unit unit;
        if (viewState instanceof ServerSettingsCreatorMonetizationOnboardingViewModel.ViewState.Loading) {
            AppViewFlipper appViewFlipper = getBinding().e;
            Intrinsics3.checkNotNullExpressionValue(appViewFlipper, "binding.viewFlipper");
            appViewFlipper.setDisplayedChild(0);
            unit = Unit.a;
        } else if (viewState instanceof ServerSettingsCreatorMonetizationOnboardingViewModel.ViewState.Error) {
            AppViewFlipper appViewFlipper2 = getBinding().e;
            Intrinsics3.checkNotNullExpressionValue(appViewFlipper2, "binding.viewFlipper");
            appViewFlipper2.setDisplayedChild(1);
            TextView textView = getBinding().f2558b;
            Intrinsics3.checkNotNullExpressionValue(textView, "binding.errorNoticeText");
            textView.setText(((ServerSettingsCreatorMonetizationOnboardingViewModel.ViewState.Error) viewState).getError().getDisplayString(requireContext()));
            unit = Unit.a;
        } else if (viewState instanceof ServerSettingsCreatorMonetizationOnboardingViewModel.ViewState.CreateRequest) {
            AppViewFlipper appViewFlipper3 = getBinding().e;
            Intrinsics3.checkNotNullExpressionValue(appViewFlipper3, "binding.viewFlipper");
            appViewFlipper3.setDisplayedChild(2);
            configureCreateRequestState((ServerSettingsCreatorMonetizationOnboardingViewModel.ViewState.CreateRequest) viewState);
            unit = Unit.a;
        } else {
            if (!(viewState instanceof ServerSettingsCreatorMonetizationOnboardingViewModel.ViewState.AcceptTerms)) {
                throw new NoWhenBranchMatchedException();
            }
            ServerSettingsCreatorMonetizationOnboardingViewModel.ViewState.AcceptTerms acceptTerms = (ServerSettingsCreatorMonetizationOnboardingViewModel.ViewState.AcceptTerms) viewState;
            if (acceptTerms.getGuild().hasFeature(GuildFeature.CREATOR_MONETIZABLE)) {
                WidgetServerSettingsEmptyGuildRoleSubscriptions.INSTANCE.launch(requireContext(), getGuildId());
                requireActivity().finish();
                unit = Unit.a;
            } else {
                AppViewFlipper appViewFlipper4 = getBinding().e;
                Intrinsics3.checkNotNullExpressionValue(appViewFlipper4, "binding.viewFlipper");
                appViewFlipper4.setDisplayedChild(3);
                configureAcceptTermsState(acceptTerms);
                unit = Unit.a;
            }
        }
        KotlinExtensions.getExhaustive(unit);
    }

    private final CharSequence formatDurationFromDays(int minimumAgeInDays) {
        return (minimumAgeInDays <= 0 || minimumAgeInDays % 7 != 0) ? DurationUtils3.formatDuration(requireContext(), DurationUtils2.DAYS, minimumAgeInDays) : DurationUtils3.formatDuration(requireContext(), DurationUtils2.WEEKS, minimumAgeInDays / 7);
    }

    private final WidgetServerSettingsCreatorMonetizationOnboardingAcceptTermsBinding getAcceptTermsBinding() {
        return (WidgetServerSettingsCreatorMonetizationOnboardingAcceptTermsBinding) this.acceptTermsBinding.getValue();
    }

    private final LazyViewStubDelegate getAcceptTermsOnlyGuildOwnerNotice() {
        return (LazyViewStubDelegate) this.acceptTermsOnlyGuildOwnerNotice.getValue();
    }

    private final WidgetServerSettingsCreatorMonetizationOnboardingBinding getBinding() {
        return (WidgetServerSettingsCreatorMonetizationOnboardingBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final WidgetServerSettingsCreatorMonetizationOnboardingCreateRequestBinding getCreateRequestBinding() {
        return (WidgetServerSettingsCreatorMonetizationOnboardingCreateRequestBinding) this.createRequestBinding.getValue();
    }

    private final LazyViewStubDelegate getCreateRequestOnlyGuildOwnerNotice() {
        return (LazyViewStubDelegate) this.createRequestOnlyGuildOwnerNotice.getValue();
    }

    private final long getGuildId() {
        return ((Number) this.guildId.getValue()).longValue();
    }

    private final ServerSettingsCreatorMonetizationOnboardingViewModel getViewModel() {
        return (ServerSettingsCreatorMonetizationOnboardingViewModel) this.viewModel.getValue();
    }

    private final void handleEvent(ServerSettingsCreatorMonetizationOnboardingViewModel.Event event) throws Throwable {
        if (event instanceof ServerSettingsCreatorMonetizationOnboardingViewModel.Event.ShowErrorToast) {
            Error.handle(((ServerSettingsCreatorMonetizationOnboardingViewModel.Event.ShowErrorToast) event).getError(), WidgetServerSettingsCreatorMonetizationOnboarding.class.getSimpleName(), null, getActivity());
        }
    }

    public static final void launch(Context context, long j) {
        INSTANCE.launch(context, j);
    }

    private final List<EligibilityChecklistView.Requirement> toChecklistRequirements(CreatorMonetizationEligibilityRequirements creatorMonetizationEligibilityRequirements) {
        EligibilityChecklistView.Requirement[] requirementArr = new EligibilityChecklistView.Requirement[6];
        String string = creatorMonetizationEligibilityRequirements.getSize() ? getString(R.string.guild_role_subscription_settings_eligibility_requirement_members_eligible) : getString(R.string.guild_role_subscription_settings_eligibility_requirement_members_not_eligible);
        Intrinsics3.checkNotNullExpressionValue(string, "when {\n                s…eligible)\n              }");
        requirementArr[0] = new EligibilityChecklistView.Requirement(string, FormatUtils.e(this, R.string.guild_role_subscription_settings_eligibility_requirement_members_description, new Object[0], new AnonymousClass1(creatorMonetizationEligibilityRequirements)), creatorMonetizationEligibilityRequirements.getSize());
        String string2 = creatorMonetizationEligibilityRequirements.getAge() ? getString(R.string.guild_role_subscription_settings_eligibility_requirement_age_eligible) : getString(R.string.guild_role_subscription_settings_eligibility_requirement_age_not_eligible);
        Intrinsics3.checkNotNullExpressionValue(string2, "when {\n                a…eligible)\n              }");
        requirementArr[1] = new EligibilityChecklistView.Requirement(string2, FormatUtils.e(this, R.string.guild_role_subscription_settings_eligibility_requirement_age_description, new Object[0], new AnonymousClass2(creatorMonetizationEligibilityRequirements)), creatorMonetizationEligibilityRequirements.getAge());
        String string3 = creatorMonetizationEligibilityRequirements.getSafeEnvironment() ? getString(R.string.guild_role_subscription_settings_eligibility_requirement_violations_eligible) : getString(R.string.guild_role_subscription_settings_eligibility_requirement_violations_not_eligible);
        Intrinsics3.checkNotNullExpressionValue(string3, "when {\n                s…        )\n              }");
        requirementArr[2] = new EligibilityChecklistView.Requirement(string3, FormatUtils.e(this, R.string.guild_role_subscription_settings_eligibility_requirement_violations_description, new Object[0], AnonymousClass3.INSTANCE), creatorMonetizationEligibilityRequirements.getSafeEnvironment());
        String string4 = creatorMonetizationEligibilityRequirements.getEngagementHealthy() ? getString(R.string.guild_role_subscription_settings_eligibility_requirement_communicators_eligible) : getString(R.string.guild_role_subscription_settings_eligibility_requirement_communicators_not_eligible);
        Intrinsics3.checkNotNullExpressionValue(string4, "when {\n                e…        )\n              }");
        String string5 = getString(R.string.guild_role_subscription_settings_eligibility_requirement_communicators_description);
        Intrinsics3.checkNotNullExpressionValue(string5, "getString(R.string.guild…ommunicators_description)");
        requirementArr[3] = new EligibilityChecklistView.Requirement(string4, string5, creatorMonetizationEligibilityRequirements.getEngagementHealthy());
        String string6 = creatorMonetizationEligibilityRequirements.getRetentionHealthy() ? getString(R.string.guild_role_subscription_settings_eligibility_requirement_retention_eligible) : getString(R.string.guild_role_subscription_settings_eligibility_requirement_retention_not_eligible);
        Intrinsics3.checkNotNullExpressionValue(string6, "when {\n                r…eligible)\n              }");
        String string7 = getString(R.string.guild_role_subscription_settings_eligibility_requirement_retention_description);
        Intrinsics3.checkNotNullExpressionValue(string7, "getString(R.string.guild…nt_retention_description)");
        requirementArr[4] = new EligibilityChecklistView.Requirement(string6, string7, creatorMonetizationEligibilityRequirements.getRetentionHealthy());
        String string8 = creatorMonetizationEligibilityRequirements.i().isEmpty() ? getString(R.string.guild_role_subscription_settings_eligibility_requirement_nsfw_content_eligible) : getString(R.string.guild_role_subscription_settings_eligibility_requirement_nsfw_content_not_eligible);
        Intrinsics3.checkNotNullExpressionValue(string8, "when {\n                n…        )\n              }");
        String string9 = getString(R.string.guild_role_subscription_settings_eligibility_requirement_nsfw_content_description);
        Intrinsics3.checkNotNullExpressionValue(string9, "getString(R.string.guild…nsfw_content_description)");
        requirementArr[5] = new EligibilityChecklistView.Requirement(string8, string9, creatorMonetizationEligibilityRequirements.i().isEmpty());
        return Collections2.listOf((Object[]) requirementArr);
    }

    @Override // com.discord.app.AppFragment, com.discord.app.AppLogger.a
    public AppLogger2 getLoggingConfig() {
        return (AppLogger2) getViewModel().withViewState(new WidgetServerSettingsCreatorMonetizationOnboarding$loggingConfig$1(this));
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        setActionBarDisplayHomeAsUpEnabled(true);
        setActionBarTitle(R.string.guild_settings_role_subscriptions_title);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        Observable<ServerSettingsCreatorMonetizationOnboardingViewModel.ViewState> observableR = getViewModel().observeViewState().r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "viewModel\n        .obser…  .distinctUntilChanged()");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(observableR, this, null, 2, null), WidgetServerSettingsCreatorMonetizationOnboarding.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(), 62, (Object) null);
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().listenForEvents(), this, null, 2, null), WidgetServerSettingsCreatorMonetizationOnboarding.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass2(), 62, (Object) null);
    }

    /* compiled from: WidgetServerSettingsCreatorMonetizationOnboarding.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/discord/i18n/RenderContext;", "", "invoke", "(Lcom/discord/i18n/RenderContext;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.servers.creator_monetization_eligibility.onboarding.WidgetServerSettingsCreatorMonetizationOnboarding$configureCreateRequestState$3, reason: invalid class name */
    public static final class AnonymousClass3 extends Lambda implements Function1<RenderContext, Unit> {
        public static final AnonymousClass3 INSTANCE = new AnonymousClass3();

        public AnonymousClass3() {
            super(1);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(RenderContext renderContext) {
            Intrinsics3.checkNotNullParameter(renderContext, "$receiver");
            renderContext.args.put("faqUrl", "https://support.discord.com/hc/en-us/articles/5371495812631");
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(RenderContext renderContext) {
            invoke2(renderContext);
            return Unit.a;
        }
    }

    /* compiled from: WidgetServerSettingsCreatorMonetizationOnboarding.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/discord/i18n/RenderContext;", "", "invoke", "(Lcom/discord/i18n/RenderContext;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.servers.creator_monetization_eligibility.onboarding.WidgetServerSettingsCreatorMonetizationOnboarding$toChecklistRequirements$2, reason: invalid class name */
    public static final class AnonymousClass2 extends Lambda implements Function1<RenderContext, Unit> {
        public final /* synthetic */ CreatorMonetizationEligibilityRequirements $this_toChecklistRequirements;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(CreatorMonetizationEligibilityRequirements creatorMonetizationEligibilityRequirements) {
            super(1);
            this.$this_toChecklistRequirements = creatorMonetizationEligibilityRequirements;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(RenderContext renderContext) {
            Intrinsics3.checkNotNullParameter(renderContext, "$receiver");
            renderContext.args.put("minimumAge", WidgetServerSettingsCreatorMonetizationOnboarding.access$formatDurationFromDays(WidgetServerSettingsCreatorMonetizationOnboarding.this, this.$this_toChecklistRequirements.getMinimumAgeInDays()).toString());
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(RenderContext renderContext) {
            invoke2(renderContext);
            return Unit.a;
        }
    }

    /* compiled from: WidgetServerSettingsCreatorMonetizationOnboarding.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/discord/i18n/RenderContext;", "", "invoke", "(Lcom/discord/i18n/RenderContext;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.servers.creator_monetization_eligibility.onboarding.WidgetServerSettingsCreatorMonetizationOnboarding$toChecklistRequirements$3, reason: invalid class name */
    public static final class AnonymousClass3 extends Lambda implements Function1<RenderContext, Unit> {
        public static final AnonymousClass3 INSTANCE = new AnonymousClass3();

        public AnonymousClass3() {
            super(1);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(RenderContext renderContext) {
            Intrinsics3.checkNotNullParameter(renderContext, "$receiver");
            renderContext.args.put("communityGuidelinesUrl", "https://support.discord.com/hc/en-us/articles/360035969312");
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(RenderContext renderContext) {
            invoke2(renderContext);
            return Unit.a;
        }
    }

    /* compiled from: WidgetServerSettingsCreatorMonetizationOnboarding.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/discord/i18n/RenderContext;", "", "invoke", "(Lcom/discord/i18n/RenderContext;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.servers.creator_monetization_eligibility.onboarding.WidgetServerSettingsCreatorMonetizationOnboarding$toChecklistRequirements$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<RenderContext, Unit> {
        public final /* synthetic */ CreatorMonetizationEligibilityRequirements $this_toChecklistRequirements;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(CreatorMonetizationEligibilityRequirements creatorMonetizationEligibilityRequirements) {
            super(1);
            this.$this_toChecklistRequirements = creatorMonetizationEligibilityRequirements;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(RenderContext renderContext) {
            Intrinsics3.checkNotNullParameter(renderContext, "$receiver");
            renderContext.args.put("minimumSize", StringResourceUtils.getI18nPluralString(WidgetServerSettingsCreatorMonetizationOnboarding.this.requireContext(), R.plurals.guild_role_subscription_settings_eligibility_requirement_members_description_minimumSize, this.$this_toChecklistRequirements.getMinimumSize(), Integer.valueOf(this.$this_toChecklistRequirements.getMinimumSize())).toString());
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(RenderContext renderContext) {
            invoke2(renderContext);
            return Unit.a;
        }
    }
}
