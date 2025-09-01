package com.discord.widgets.servers.creator_monetization_eligibility.onboarding;

import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import com.discord.R;
import com.discord.databinding.WidgetServerSettingsCreatorMonetizationOnboardingCreateRequestBinding;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.discord.views.LoadingButton;
import com.discord.widgets.servers.creator_monetization_eligibility.EligibilityChecklistView;
import com.google.android.material.button.MaterialButton;
import d0.z.d.Lambda;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

/* compiled from: WidgetServerSettingsCreatorMonetizationOnboarding.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lcom/discord/databinding/WidgetServerSettingsCreatorMonetizationOnboardingCreateRequestBinding;", "invoke", "()Lcom/discord/databinding/WidgetServerSettingsCreatorMonetizationOnboardingCreateRequestBinding;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class WidgetServerSettingsCreatorMonetizationOnboarding$createRequestBinding$2 extends Lambda implements Function0<WidgetServerSettingsCreatorMonetizationOnboardingCreateRequestBinding> {
    public final /* synthetic */ WidgetServerSettingsCreatorMonetizationOnboarding this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetServerSettingsCreatorMonetizationOnboarding$createRequestBinding$2(WidgetServerSettingsCreatorMonetizationOnboarding widgetServerSettingsCreatorMonetizationOnboarding) {
        super(0);
        this.this$0 = widgetServerSettingsCreatorMonetizationOnboarding;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ WidgetServerSettingsCreatorMonetizationOnboardingCreateRequestBinding invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final WidgetServerSettingsCreatorMonetizationOnboardingCreateRequestBinding invoke() {
        View viewInflate = WidgetServerSettingsCreatorMonetizationOnboarding.access$getBinding$p(this.this$0).d.inflate();
        int i = R.id.application_pending_button;
        MaterialButton materialButton = (MaterialButton) viewInflate.findViewById(R.id.application_pending_button);
        if (materialButton != null) {
            i = R.id.apply_button;
            LoadingButton loadingButton = (LoadingButton) viewInflate.findViewById(R.id.apply_button);
            if (loadingButton != null) {
                i = R.id.eligibility_checklist;
                EligibilityChecklistView eligibilityChecklistView = (EligibilityChecklistView) viewInflate.findViewById(R.id.eligibility_checklist);
                if (eligibilityChecklistView != null) {
                    i = R.id.eligibility_checklist_header_indicator;
                    ImageView imageView = (ImageView) viewInflate.findViewById(R.id.eligibility_checklist_header_indicator);
                    if (imageView != null) {
                        i = R.id.eligibility_checklist_title;
                        TextView textView = (TextView) viewInflate.findViewById(R.id.eligibility_checklist_title);
                        if (textView != null) {
                            i = R.id.only_guild_owner_notice;
                            ViewStub viewStub = (ViewStub) viewInflate.findViewById(R.id.only_guild_owner_notice);
                            if (viewStub != null) {
                                i = R.id.request_rejected_notice;
                                TextView textView2 = (TextView) viewInflate.findViewById(R.id.request_rejected_notice);
                                if (textView2 != null) {
                                    i = R.id.requirements_description;
                                    LinkifiedTextView linkifiedTextView = (LinkifiedTextView) viewInflate.findViewById(R.id.requirements_description);
                                    if (linkifiedTextView != null) {
                                        return new WidgetServerSettingsCreatorMonetizationOnboardingCreateRequestBinding((ScrollView) viewInflate, materialButton, loadingButton, eligibilityChecklistView, imageView, textView, viewStub, textView2, linkifiedTextView);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i)));
    }
}
