package com.discord.widgets.servers.creator_monetization_eligibility.onboarding;

import android.widget.CompoundButton;
import android.widget.ScrollView;
import com.discord.utilities.view.extensions.ScrollViewExtensions;
import com.discord.widgets.servers.creator_monetization_eligibility.onboarding.ServerSettingsCreatorMonetizationOnboardingViewModel;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: WidgetServerSettingsCreatorMonetizationOnboarding.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0010\t\u001a\u00020\u00052\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u00002\u0006\u0010\u0004\u001a\u00020\u0003H\n¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Landroid/widget/CompoundButton;", "kotlin.jvm.PlatformType", "<anonymous parameter 0>", "", "isChecked", "", "onCheckedChanged", "(Landroid/widget/CompoundButton;Z)V", "com/discord/widgets/servers/creator_monetization_eligibility/onboarding/WidgetServerSettingsCreatorMonetizationOnboarding$configureAcceptTermsState$1$1", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class WidgetServerSettingsCreatorMonetizationOnboarding$configureAcceptTermsState$$inlined$apply$lambda$1 implements CompoundButton.OnCheckedChangeListener {
    public final /* synthetic */ ServerSettingsCreatorMonetizationOnboardingViewModel.ViewState.AcceptTerms $viewState$inlined;
    public final /* synthetic */ WidgetServerSettingsCreatorMonetizationOnboarding this$0;

    public WidgetServerSettingsCreatorMonetizationOnboarding$configureAcceptTermsState$$inlined$apply$lambda$1(WidgetServerSettingsCreatorMonetizationOnboarding widgetServerSettingsCreatorMonetizationOnboarding, ServerSettingsCreatorMonetizationOnboardingViewModel.ViewState.AcceptTerms acceptTerms) {
        this.this$0 = widgetServerSettingsCreatorMonetizationOnboarding;
        this.$viewState$inlined = acceptTerms;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public final void onCheckedChanged(CompoundButton compoundButton, boolean z2) {
        WidgetServerSettingsCreatorMonetizationOnboarding.access$getViewModel$p(this.this$0).setHasAcceptedTerms(z2);
        if (z2) {
            ScrollView scrollView = WidgetServerSettingsCreatorMonetizationOnboarding.access$getAcceptTermsBinding$p(this.this$0).d;
            Intrinsics3.checkNotNullExpressionValue(scrollView, "acceptTermsBinding.acceptTermsScrollView");
            ScrollViewExtensions.flashScrollBars(scrollView);
        }
    }
}
