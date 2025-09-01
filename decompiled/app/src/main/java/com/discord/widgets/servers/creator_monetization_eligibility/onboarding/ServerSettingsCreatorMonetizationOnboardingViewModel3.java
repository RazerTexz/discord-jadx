package com.discord.widgets.servers.creator_monetization_eligibility.onboarding;

import com.discord.api.creatormonetization.CreatorMonetizationEligibilityRequirements;
import com.discord.api.creatormonetization.CreatorMonetizationEnableRequest;
import com.discord.widgets.servers.creator_monetization_eligibility.onboarding.ServerSettingsCreatorMonetizationOnboardingViewModel;
import d0.z.d.Lambda;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: ServerSettingsCreatorMonetizationOnboardingViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u0010\u0007\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/discord/api/creatormonetization/CreatorMonetizationEnableRequest;", "kotlin.jvm.PlatformType", "newRequest", "", "invoke", "(Lcom/discord/api/creatormonetization/CreatorMonetizationEnableRequest;)V", "com/discord/widgets/servers/creator_monetization_eligibility/onboarding/ServerSettingsCreatorMonetizationOnboardingViewModel$createRequestToEnableMonetization$1$2", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.servers.creator_monetization_eligibility.onboarding.ServerSettingsCreatorMonetizationOnboardingViewModel$createRequestToEnableMonetization$$inlined$updateWithViewState$lambda$2, reason: use source file name */
/* loaded from: classes2.dex */
public final class ServerSettingsCreatorMonetizationOnboardingViewModel3 extends Lambda implements Function1<CreatorMonetizationEnableRequest, Unit> {
    public final /* synthetic */ ServerSettingsCreatorMonetizationOnboardingViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ServerSettingsCreatorMonetizationOnboardingViewModel3(ServerSettingsCreatorMonetizationOnboardingViewModel serverSettingsCreatorMonetizationOnboardingViewModel) {
        super(1);
        this.this$0 = serverSettingsCreatorMonetizationOnboardingViewModel;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(CreatorMonetizationEnableRequest creatorMonetizationEnableRequest) {
        invoke2(creatorMonetizationEnableRequest);
        return Unit.a;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(CreatorMonetizationEnableRequest creatorMonetizationEnableRequest) {
        ServerSettingsCreatorMonetizationOnboardingViewModel serverSettingsCreatorMonetizationOnboardingViewModel = this.this$0;
        ServerSettingsCreatorMonetizationOnboardingViewModel.ViewState viewStateAccess$requireViewState = ServerSettingsCreatorMonetizationOnboardingViewModel.access$requireViewState(serverSettingsCreatorMonetizationOnboardingViewModel);
        if (viewStateAccess$requireViewState instanceof ServerSettingsCreatorMonetizationOnboardingViewModel.ViewState.CreateRequest) {
            ServerSettingsCreatorMonetizationOnboardingViewModel.ViewState.CreateRequest createRequest = (ServerSettingsCreatorMonetizationOnboardingViewModel.ViewState.CreateRequest) viewStateAccess$requireViewState;
            ServerSettingsCreatorMonetizationOnboardingViewModel.access$updateViewState(serverSettingsCreatorMonetizationOnboardingViewModel, ServerSettingsCreatorMonetizationOnboardingViewModel.ViewState.CreateRequest.copy$default(createRequest, CreatorMonetizationEligibilityRequirements.a(createRequest.getRequirements(), 0L, creatorMonetizationEnableRequest, false, false, false, false, null, false, false, false, null, false, null, 0, 0, 32765), false, false, 2, null));
        }
    }
}
