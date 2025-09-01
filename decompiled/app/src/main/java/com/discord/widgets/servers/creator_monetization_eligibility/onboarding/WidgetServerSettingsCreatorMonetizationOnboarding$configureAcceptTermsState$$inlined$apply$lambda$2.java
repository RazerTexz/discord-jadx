package com.discord.widgets.servers.creator_monetization_eligibility.onboarding;

import android.view.View;
import com.discord.widgets.servers.creator_monetization_eligibility.onboarding.ServerSettingsCreatorMonetizationOnboardingViewModel;
import kotlin.Metadata;

/* compiled from: WidgetServerSettingsCreatorMonetizationOnboarding.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u0010\u0007\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "com/discord/widgets/servers/creator_monetization_eligibility/onboarding/WidgetServerSettingsCreatorMonetizationOnboarding$configureAcceptTermsState$2$1", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class WidgetServerSettingsCreatorMonetizationOnboarding$configureAcceptTermsState$$inlined$apply$lambda$2 implements View.OnClickListener {
    public final /* synthetic */ ServerSettingsCreatorMonetizationOnboardingViewModel.ViewState.AcceptTerms $viewState$inlined;
    public final /* synthetic */ WidgetServerSettingsCreatorMonetizationOnboarding this$0;

    public WidgetServerSettingsCreatorMonetizationOnboarding$configureAcceptTermsState$$inlined$apply$lambda$2(WidgetServerSettingsCreatorMonetizationOnboarding widgetServerSettingsCreatorMonetizationOnboarding, ServerSettingsCreatorMonetizationOnboardingViewModel.ViewState.AcceptTerms acceptTerms) {
        this.this$0 = widgetServerSettingsCreatorMonetizationOnboarding;
        this.$viewState$inlined = acceptTerms;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        WidgetServerSettingsCreatorMonetizationOnboarding.access$getViewModel$p(this.this$0).submitTermsAcceptance();
    }
}
