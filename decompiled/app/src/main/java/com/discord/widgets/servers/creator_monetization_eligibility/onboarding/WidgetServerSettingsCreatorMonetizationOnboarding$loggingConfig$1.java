package com.discord.widgets.servers.creator_monetization_eligibility.onboarding;

import com.discord.analytics.generated.events.impression.TrackImpressionEnableCreatorMonetizationAcceptTermsLanding;
import com.discord.analytics.generated.events.impression.TrackImpressionEnableCreatorMonetizationCreateRequestLanding;
import com.discord.analytics.generated.traits.TrackGuild;
import com.discord.api.science.AnalyticsSchema;
import com.discord.app.AppLogger2;
import com.discord.widgets.servers.creator_monetization_eligibility.onboarding.ServerSettingsCreatorMonetizationOnboardingViewModel;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* compiled from: WidgetServerSettingsCreatorMonetizationOnboarding.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/widgets/servers/creator_monetization_eligibility/onboarding/ServerSettingsCreatorMonetizationOnboardingViewModel$ViewState;", "state", "Lcom/discord/app/LoggingConfig;", "invoke", "(Lcom/discord/widgets/servers/creator_monetization_eligibility/onboarding/ServerSettingsCreatorMonetizationOnboardingViewModel$ViewState;)Lcom/discord/app/LoggingConfig;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class WidgetServerSettingsCreatorMonetizationOnboarding$loggingConfig$1 extends Lambda implements Function1<ServerSettingsCreatorMonetizationOnboardingViewModel.ViewState, AppLogger2> {
    public final /* synthetic */ WidgetServerSettingsCreatorMonetizationOnboarding this$0;

    /* compiled from: WidgetServerSettingsCreatorMonetizationOnboarding.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lcom/discord/api/science/AnalyticsSchema;", "invoke", "()Lcom/discord/api/science/AnalyticsSchema;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.servers.creator_monetization_eligibility.onboarding.WidgetServerSettingsCreatorMonetizationOnboarding$loggingConfig$1$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<AnalyticsSchema> {
        public final /* synthetic */ ServerSettingsCreatorMonetizationOnboardingViewModel.ViewState $state;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(ServerSettingsCreatorMonetizationOnboardingViewModel.ViewState viewState) {
            super(0);
            this.$state = viewState;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ AnalyticsSchema invoke() {
            return invoke();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final AnalyticsSchema invoke() {
            TrackImpressionEnableCreatorMonetizationCreateRequestLanding trackImpressionEnableCreatorMonetizationCreateRequestLanding = new TrackImpressionEnableCreatorMonetizationCreateRequestLanding(Boolean.valueOf(((ServerSettingsCreatorMonetizationOnboardingViewModel.ViewState.CreateRequest) this.$state).getRequirements().getCanApply()), Boolean.valueOf(((ServerSettingsCreatorMonetizationOnboardingViewModel.ViewState.CreateRequest) this.$state).isApplicationPending()), AnalyticsFormattedMonetizationRequirements.INSTANCE.toAnalyticsFormat(((ServerSettingsCreatorMonetizationOnboardingViewModel.ViewState.CreateRequest) this.$state).getRequirements()).toJson());
            trackImpressionEnableCreatorMonetizationCreateRequestLanding.c(new TrackGuild(Long.valueOf(WidgetServerSettingsCreatorMonetizationOnboarding.access$getGuildId$p(WidgetServerSettingsCreatorMonetizationOnboarding$loggingConfig$1.this.this$0)), null, null, null, null, null, null, null, null, null, null, null, 4094));
            return trackImpressionEnableCreatorMonetizationCreateRequestLanding;
        }
    }

    /* compiled from: WidgetServerSettingsCreatorMonetizationOnboarding.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lcom/discord/api/science/AnalyticsSchema;", "invoke", "()Lcom/discord/api/science/AnalyticsSchema;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.servers.creator_monetization_eligibility.onboarding.WidgetServerSettingsCreatorMonetizationOnboarding$loggingConfig$1$2, reason: invalid class name */
    public static final class AnonymousClass2 extends Lambda implements Function0<AnalyticsSchema> {
        public final /* synthetic */ ServerSettingsCreatorMonetizationOnboardingViewModel.ViewState $state;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(ServerSettingsCreatorMonetizationOnboardingViewModel.ViewState viewState) {
            super(0);
            this.$state = viewState;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ AnalyticsSchema invoke() {
            return invoke();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final AnalyticsSchema invoke() {
            TrackImpressionEnableCreatorMonetizationAcceptTermsLanding trackImpressionEnableCreatorMonetizationAcceptTermsLanding = new TrackImpressionEnableCreatorMonetizationAcceptTermsLanding(String.valueOf(((ServerSettingsCreatorMonetizationOnboardingViewModel.ViewState.AcceptTerms) this.$state).getLatestRequest().getId()));
            trackImpressionEnableCreatorMonetizationAcceptTermsLanding.c(new TrackGuild(Long.valueOf(WidgetServerSettingsCreatorMonetizationOnboarding.access$getGuildId$p(WidgetServerSettingsCreatorMonetizationOnboarding$loggingConfig$1.this.this$0)), null, null, null, null, null, null, null, null, null, null, null, 4094));
            return trackImpressionEnableCreatorMonetizationAcceptTermsLanding;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetServerSettingsCreatorMonetizationOnboarding$loggingConfig$1(WidgetServerSettingsCreatorMonetizationOnboarding widgetServerSettingsCreatorMonetizationOnboarding) {
        super(1);
        this.this$0 = widgetServerSettingsCreatorMonetizationOnboarding;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ AppLogger2 invoke(ServerSettingsCreatorMonetizationOnboardingViewModel.ViewState viewState) {
        return invoke2(viewState);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final AppLogger2 invoke2(ServerSettingsCreatorMonetizationOnboardingViewModel.ViewState viewState) {
        AppLogger2 appLogger2;
        Intrinsics3.checkNotNullParameter(viewState, "state");
        if (viewState instanceof ServerSettingsCreatorMonetizationOnboardingViewModel.ViewState.CreateRequest) {
            appLogger2 = new AppLogger2(false, null, new AnonymousClass1(viewState), 3);
        } else {
            if (!(viewState instanceof ServerSettingsCreatorMonetizationOnboardingViewModel.ViewState.AcceptTerms)) {
                return null;
            }
            appLogger2 = new AppLogger2(false, null, new AnonymousClass2(viewState), 3);
        }
        return appLogger2;
    }
}
