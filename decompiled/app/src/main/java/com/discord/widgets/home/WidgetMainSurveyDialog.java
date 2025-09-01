package com.discord.widgets.home;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.app.AppDialog;
import com.discord.databinding.ViewDialogConfirmationBinding;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.utilities.uri.UriHandler;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.google.android.material.button.MaterialButton;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;

/* compiled from: WidgetMainSurveyDialog.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u0007¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u001d\u0010\f\u001a\u00020\u00078B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b¨\u0006\u0010"}, d2 = {"Lcom/discord/widgets/home/WidgetMainSurveyDialog;", "Lcom/discord/app/AppDialog;", "Landroid/view/View;", "view", "", "onViewBound", "(Landroid/view/View;)V", "Lcom/discord/databinding/ViewDialogConfirmationBinding;", "binding$delegate", "Lcom/discord/utilities/viewbinding/FragmentViewBindingDelegate;", "getBinding", "()Lcom/discord/databinding/ViewDialogConfirmationBinding;", "binding", "<init>", "()V", "Companion", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class WidgetMainSurveyDialog extends AppDialog {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetMainSurveyDialog.class, "binding", "getBinding()Lcom/discord/databinding/ViewDialogConfirmationBinding;", 0)};

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String EXTRA_SURVEY_BODY = "extra_survey_body";
    private static final String EXTRA_SURVEY_ID = "extra_survey_id";
    private static final String EXTRA_SURVEY_TITLE = "extra_survey_title";
    private static final String EXTRA_SURVEY_URL = "extra_survey_url";

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* compiled from: WidgetMainSurveyDialog.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\n\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0012\u0010\u0013J9\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\n\u0010\u0006\u001a\u00060\u0004j\u0002`\u00052\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0004¢\u0006\u0004\b\u000b\u0010\fR\u0016\u0010\r\u001a\u00020\u00048\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u000f\u001a\u00020\u00048\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000f\u0010\u000eR\u0016\u0010\u0010\u001a\u00020\u00048\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0010\u0010\u000eR\u0016\u0010\u0011\u001a\u00020\u00048\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0011\u0010\u000e¨\u0006\u0014"}, d2 = {"Lcom/discord/widgets/home/WidgetMainSurveyDialog$Companion;", "", "Landroidx/fragment/app/FragmentManager;", "fragmentManager", "", "Lcom/discord/primitives/SurveyId;", "surveyId", "surveyUrl", "surveyBody", "surveyTitle", "", "show", "(Landroidx/fragment/app/FragmentManager;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "EXTRA_SURVEY_BODY", "Ljava/lang/String;", "EXTRA_SURVEY_ID", "EXTRA_SURVEY_TITLE", "EXTRA_SURVEY_URL", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public final void show(FragmentManager fragmentManager, String surveyId, String surveyUrl, String surveyBody, String surveyTitle) {
            Intrinsics3.checkNotNullParameter(fragmentManager, "fragmentManager");
            Intrinsics3.checkNotNullParameter(surveyId, "surveyId");
            Intrinsics3.checkNotNullParameter(surveyUrl, "surveyUrl");
            Intrinsics3.checkNotNullParameter(surveyBody, "surveyBody");
            Intrinsics3.checkNotNullParameter(surveyTitle, "surveyTitle");
            WidgetMainSurveyDialog widgetMainSurveyDialog = new WidgetMainSurveyDialog();
            Bundle bundle = new Bundle();
            bundle.putString(WidgetMainSurveyDialog.EXTRA_SURVEY_ID, surveyId);
            bundle.putString(WidgetMainSurveyDialog.EXTRA_SURVEY_URL, surveyUrl);
            bundle.putString(WidgetMainSurveyDialog.EXTRA_SURVEY_BODY, surveyBody);
            bundle.putString(WidgetMainSurveyDialog.EXTRA_SURVEY_TITLE, surveyTitle);
            widgetMainSurveyDialog.setArguments(bundle);
            widgetMainSurveyDialog.show(fragmentManager, "WidgetMainSurveyDialog");
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetMainSurveyDialog.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.home.WidgetMainSurveyDialog$onViewBound$1, reason: invalid class name */
    public static final class AnonymousClass1 implements View.OnClickListener {
        public AnonymousClass1() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetMainSurveyDialog.this.dismiss();
        }
    }

    /* compiled from: WidgetMainSurveyDialog.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "button", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.home.WidgetMainSurveyDialog$onViewBound$2, reason: invalid class name */
    public static final class AnonymousClass2 implements View.OnClickListener {
        public final /* synthetic */ String $surveyUrl;

        public AnonymousClass2(String str) {
            this.$surveyUrl = str;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            UriHandler.handle$default(UriHandler.INSTANCE, outline.x(view, "button", "button.context"), this.$surveyUrl, false, false, null, 28, null);
            WidgetMainSurveyDialog.this.dismiss();
        }
    }

    public WidgetMainSurveyDialog() {
        super(R.layout.view_dialog_confirmation);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetMainSurveyDialog2.INSTANCE, null, 2, null);
    }

    private final ViewDialogConfirmationBinding getBinding() {
        return (ViewDialogConfirmationBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    @Override // com.discord.app.AppDialog
    public void onViewBound(View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        Bundle arguments = getArguments();
        String string = arguments != null ? arguments.getString(EXTRA_SURVEY_URL) : null;
        Bundle arguments2 = getArguments();
        String string2 = arguments2 != null ? arguments2.getString(EXTRA_SURVEY_BODY) : null;
        Bundle arguments3 = getArguments();
        String string3 = arguments3 != null ? arguments3.getString(EXTRA_SURVEY_ID) : null;
        Bundle arguments4 = getArguments();
        String string4 = arguments4 != null ? arguments4.getString(EXTRA_SURVEY_TITLE) : null;
        if (!(string == null || string.length() == 0)) {
            if (!(string3 == null || string3.length() == 0)) {
                TextView textView = getBinding().d;
                Intrinsics3.checkNotNullExpressionValue(textView, "binding.viewDialogConfirmationHeader");
                textView.setText(string4);
                TextView textView2 = getBinding().e;
                Intrinsics3.checkNotNullExpressionValue(textView2, "binding.viewDialogConfirmationText");
                textView2.setText(string2);
                MaterialButton materialButton = getBinding().f2185b;
                Intrinsics3.checkNotNullExpressionValue(materialButton, "binding.viewDialogConfirmationCancel");
                materialButton.setText(getString(R.string.no_thanks));
                getBinding().f2185b.setOnClickListener(new AnonymousClass1());
                MaterialButton materialButton2 = getBinding().c;
                Intrinsics3.checkNotNullExpressionValue(materialButton2, "binding.viewDialogConfirmationConfirm");
                materialButton2.setText(getString(R.string.okay));
                getBinding().c.setOnClickListener(new AnonymousClass2(string));
                AnalyticsTracker.INSTANCE.surveyViewed(string3);
                return;
            }
        }
        dismiss();
    }
}
