package com.discord.widgets.servers.creator_monetization_eligibility.onboarding;

import android.view.View;
import android.view.ViewStub;
import android.widget.TextView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.discord.R;
import com.discord.app.AppViewFlipper;
import com.discord.databinding.WidgetServerSettingsCreatorMonetizationOnboardingBinding;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* compiled from: WidgetServerSettingsCreatorMonetizationOnboarding.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/view/View;", "p1", "Lcom/discord/databinding/WidgetServerSettingsCreatorMonetizationOnboardingBinding;", "invoke", "(Landroid/view/View;)Lcom/discord/databinding/WidgetServerSettingsCreatorMonetizationOnboardingBinding;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final /* synthetic */ class WidgetServerSettingsCreatorMonetizationOnboarding$binding$2 extends FunctionReferenceImpl implements Function1<View, WidgetServerSettingsCreatorMonetizationOnboardingBinding> {
    public static final WidgetServerSettingsCreatorMonetizationOnboarding$binding$2 INSTANCE = new WidgetServerSettingsCreatorMonetizationOnboarding$binding$2();

    public WidgetServerSettingsCreatorMonetizationOnboarding$binding$2() {
        super(1, WidgetServerSettingsCreatorMonetizationOnboardingBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetServerSettingsCreatorMonetizationOnboardingBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetServerSettingsCreatorMonetizationOnboardingBinding invoke(View view) {
        return invoke2(view);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetServerSettingsCreatorMonetizationOnboardingBinding invoke2(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        int i = R.id.error_notice_text;
        TextView textView = (TextView) view.findViewById(R.id.error_notice_text);
        if (textView != null) {
            i = R.id.onboarding_accept_terms;
            ViewStub viewStub = (ViewStub) view.findViewById(R.id.onboarding_accept_terms);
            if (viewStub != null) {
                i = R.id.onboarding_create_request;
                ViewStub viewStub2 = (ViewStub) view.findViewById(R.id.onboarding_create_request);
                if (viewStub2 != null) {
                    i = R.id.view_flipper;
                    AppViewFlipper appViewFlipper = (AppViewFlipper) view.findViewById(R.id.view_flipper);
                    if (appViewFlipper != null) {
                        return new WidgetServerSettingsCreatorMonetizationOnboardingBinding((CoordinatorLayout) view, textView, viewStub, viewStub2, appViewFlipper);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
