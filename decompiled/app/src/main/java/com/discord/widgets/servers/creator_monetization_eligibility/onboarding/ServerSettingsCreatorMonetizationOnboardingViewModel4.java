package com.discord.widgets.servers.creator_monetization_eligibility.onboarding;

import com.discord.utilities.error.Error;
import com.discord.widgets.servers.creator_monetization_eligibility.onboarding.ServerSettingsCreatorMonetizationOnboardingViewModel;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: ServerSettingsCreatorMonetizationOnboardingViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/discord/utilities/error/Error;", "it", "", "invoke", "(Lcom/discord/utilities/error/Error;)V", "com/discord/widgets/servers/creator_monetization_eligibility/onboarding/ServerSettingsCreatorMonetizationOnboardingViewModel$submitTermsAcceptance$1$1", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.servers.creator_monetization_eligibility.onboarding.ServerSettingsCreatorMonetizationOnboardingViewModel$submitTermsAcceptance$$inlined$updateWithViewState$lambda$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class ServerSettingsCreatorMonetizationOnboardingViewModel4 extends Lambda implements Function1<Error, Unit> {
    public final /* synthetic */ ServerSettingsCreatorMonetizationOnboardingViewModel.ViewState.AcceptTerms $existing;
    public final /* synthetic */ ServerSettingsCreatorMonetizationOnboardingViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ServerSettingsCreatorMonetizationOnboardingViewModel4(ServerSettingsCreatorMonetizationOnboardingViewModel.ViewState.AcceptTerms acceptTerms, ServerSettingsCreatorMonetizationOnboardingViewModel serverSettingsCreatorMonetizationOnboardingViewModel) {
        super(1);
        this.$existing = acceptTerms;
        this.this$0 = serverSettingsCreatorMonetizationOnboardingViewModel;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Error error) {
        invoke2(error);
        return Unit.a;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Error error) {
        Intrinsics3.checkNotNullParameter(error, "it");
        ServerSettingsCreatorMonetizationOnboardingViewModel serverSettingsCreatorMonetizationOnboardingViewModel = this.this$0;
        ServerSettingsCreatorMonetizationOnboardingViewModel.ViewState viewStateAccess$requireViewState = ServerSettingsCreatorMonetizationOnboardingViewModel.access$requireViewState(serverSettingsCreatorMonetizationOnboardingViewModel);
        if (viewStateAccess$requireViewState instanceof ServerSettingsCreatorMonetizationOnboardingViewModel.ViewState.AcceptTerms) {
            ServerSettingsCreatorMonetizationOnboardingViewModel.access$updateViewState(serverSettingsCreatorMonetizationOnboardingViewModel, ServerSettingsCreatorMonetizationOnboardingViewModel.ViewState.AcceptTerms.copy$default(this.$existing, null, false, null, false, false, 15, null));
        }
    }
}
