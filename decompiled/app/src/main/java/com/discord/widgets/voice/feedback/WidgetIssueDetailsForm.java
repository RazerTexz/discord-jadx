package com.discord.widgets.voice.feedback;

import android.content.Context;
import android.content.Intent;
import android.text.Editable;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import b.a.d.AppHelpDesk;
import b.a.d.AppScreen2;
import b.a.d.AppToast;
import b.a.d.AppViewModelDelegates3;
import b.a.d.AppViewModelDelegates5;
import b.a.k.FormatUtils;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.app.AppActivity;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetIssueDetailsFormBinding;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.widgets.voice.feedback.IssueDetailsFormViewModel;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputLayout;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import d0.z.d.Reflection2;
import java.io.Serializable;
import java.util.Objects;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;

/* compiled from: WidgetIssueDetailsForm.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000  2\u00020\u0001:\u0001 B\u0007¢\u0006\u0004\b\u001f\u0010\u0012J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0011\u0010\u0012R\u001d\u0010\u0018\u001a\u00020\u00138B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u001d\u0010\u001e\u001a\u00020\u00198B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d¨\u0006!"}, d2 = {"Lcom/discord/widgets/voice/feedback/WidgetIssueDetailsForm;", "Lcom/discord/app/AppFragment;", "Lcom/discord/widgets/voice/feedback/IssueDetailsFormViewModel$Event;", "event", "", "handleEvent", "(Lcom/discord/widgets/voice/feedback/IssueDetailsFormViewModel$Event;)V", "Lcom/discord/widgets/voice/feedback/PendingFeedback;", "getPendingFeedback", "()Lcom/discord/widgets/voice/feedback/PendingFeedback;", "", "shouldShowCxPrompt", "()Z", "Landroid/view/View;", "view", "onViewBound", "(Landroid/view/View;)V", "onViewBoundOrOnResume", "()V", "Lcom/discord/widgets/voice/feedback/IssueDetailsFormViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "getViewModel", "()Lcom/discord/widgets/voice/feedback/IssueDetailsFormViewModel;", "viewModel", "Lcom/discord/databinding/WidgetIssueDetailsFormBinding;", "binding$delegate", "Lcom/discord/utilities/viewbinding/FragmentViewBindingDelegate;", "getBinding", "()Lcom/discord/databinding/WidgetIssueDetailsFormBinding;", "binding", "<init>", "Companion", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final class WidgetIssueDetailsForm extends AppFragment {
    public static final String ARG_PENDING_VOICE_FEEDBACK = "ARG_PENDING_VOICE_FEEDBACK";
    public static final String ARG_SHOW_CX_PROMPT = "ARG_SHOW_CX_PROMPT";

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetIssueDetailsForm.class, "binding", "getBinding()Lcom/discord/databinding/WidgetIssueDetailsFormBinding;", 0)};

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* compiled from: WidgetIssueDetailsForm.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000f\u0010\u0010J%\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nR\u0016\u0010\f\u001a\u00020\u000b8\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0016\u0010\u000e\u001a\u00020\u000b8\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000e\u0010\r¨\u0006\u0011"}, d2 = {"Lcom/discord/widgets/voice/feedback/WidgetIssueDetailsForm$Companion;", "", "Landroid/content/Context;", "context", "Lcom/discord/widgets/voice/feedback/PendingFeedback;", "pendingFeedback", "", "showCxPrompt", "", "launch", "(Landroid/content/Context;Lcom/discord/widgets/voice/feedback/PendingFeedback;Z)V", "", WidgetIssueDetailsForm.ARG_PENDING_VOICE_FEEDBACK, "Ljava/lang/String;", WidgetIssueDetailsForm.ARG_SHOW_CX_PROMPT, "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public final void launch(Context context, PendingFeedback pendingFeedback, boolean showCxPrompt) {
            Intrinsics3.checkNotNullParameter(context, "context");
            Intrinsics3.checkNotNullParameter(pendingFeedback, "pendingFeedback");
            Intent intent = new Intent();
            intent.putExtra(WidgetIssueDetailsForm.ARG_PENDING_VOICE_FEEDBACK, pendingFeedback);
            intent.putExtra(WidgetIssueDetailsForm.ARG_SHOW_CX_PROMPT, showCxPrompt);
            AppScreen2.d(context, WidgetIssueDetailsForm.class, intent);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetIssueDetailsForm.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.voice.feedback.WidgetIssueDetailsForm$onViewBound$1, reason: invalid class name */
    public static final class AnonymousClass1 implements View.OnClickListener {
        public AnonymousClass1() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            TextInputLayout textInputLayout = WidgetIssueDetailsForm.access$getBinding$p(WidgetIssueDetailsForm.this).c;
            Intrinsics3.checkNotNullExpressionValue(textInputLayout, "binding.issueDetailsInput");
            WidgetIssueDetailsForm.access$getViewModel$p(WidgetIssueDetailsForm.this).submitForm(ViewExtensions.getTextOrEmpty(textInputLayout));
        }
    }

    /* compiled from: WidgetIssueDetailsForm.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/text/Editable;", "editable", "", "invoke", "(Landroid/text/Editable;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.voice.feedback.WidgetIssueDetailsForm$onViewBound$2, reason: invalid class name */
    public static final class AnonymousClass2 extends Lambda implements Function1<Editable, Unit> {
        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Editable editable) {
            invoke2(editable);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Editable editable) {
            Intrinsics3.checkNotNullParameter(editable, "editable");
            MaterialButton materialButton = WidgetIssueDetailsForm.access$getBinding$p(WidgetIssueDetailsForm.this).d;
            Intrinsics3.checkNotNullExpressionValue(materialButton, "binding.issueDetailsSubmitButton");
            materialButton.setEnabled(editable.length() > 0);
        }
    }

    /* compiled from: WidgetIssueDetailsForm.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/widgets/voice/feedback/IssueDetailsFormViewModel$Event;", "event", "", "invoke", "(Lcom/discord/widgets/voice/feedback/IssueDetailsFormViewModel$Event;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.voice.feedback.WidgetIssueDetailsForm$onViewBoundOrOnResume$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<IssueDetailsFormViewModel.Event, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(IssueDetailsFormViewModel.Event event) {
            invoke2(event);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(IssueDetailsFormViewModel.Event event) {
            Intrinsics3.checkNotNullParameter(event, "event");
            WidgetIssueDetailsForm.access$handleEvent(WidgetIssueDetailsForm.this, event);
        }
    }

    public WidgetIssueDetailsForm() {
        super(R.layout.widget_issue_details_form);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetIssueDetailsForm2.INSTANCE, null, 2, null);
        WidgetIssueDetailsForm3 widgetIssueDetailsForm3 = new WidgetIssueDetailsForm3(this);
        AppViewModelDelegates3 appViewModelDelegates3 = new AppViewModelDelegates3(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection2.getOrCreateKotlinClass(IssueDetailsFormViewModel.class), new WidgetIssueDetailsForm$appViewModels$$inlined$viewModels$1(appViewModelDelegates3), new AppViewModelDelegates5(widgetIssueDetailsForm3));
    }

    public static final /* synthetic */ WidgetIssueDetailsFormBinding access$getBinding$p(WidgetIssueDetailsForm widgetIssueDetailsForm) {
        return widgetIssueDetailsForm.getBinding();
    }

    public static final /* synthetic */ PendingFeedback access$getPendingFeedback(WidgetIssueDetailsForm widgetIssueDetailsForm) {
        return widgetIssueDetailsForm.getPendingFeedback();
    }

    public static final /* synthetic */ IssueDetailsFormViewModel access$getViewModel$p(WidgetIssueDetailsForm widgetIssueDetailsForm) {
        return widgetIssueDetailsForm.getViewModel();
    }

    public static final /* synthetic */ void access$handleEvent(WidgetIssueDetailsForm widgetIssueDetailsForm, IssueDetailsFormViewModel.Event event) {
        widgetIssueDetailsForm.handleEvent(event);
    }

    private final WidgetIssueDetailsFormBinding getBinding() {
        return (WidgetIssueDetailsFormBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final PendingFeedback getPendingFeedback() {
        Serializable serializableExtra = getMostRecentIntent().getSerializableExtra(ARG_PENDING_VOICE_FEEDBACK);
        Objects.requireNonNull(serializableExtra, "null cannot be cast to non-null type com.discord.widgets.voice.feedback.PendingFeedback");
        return (PendingFeedback) serializableExtra;
    }

    private final IssueDetailsFormViewModel getViewModel() {
        return (IssueDetailsFormViewModel) this.viewModel.getValue();
    }

    private final void handleEvent(IssueDetailsFormViewModel.Event event) {
        if (Intrinsics3.areEqual(event, IssueDetailsFormViewModel.Event.Close.INSTANCE)) {
            AppToast.i(this, R.string.call_feedback_confirmation, 0, 4);
            AppActivity appActivity = getAppActivity();
            if (appActivity != null) {
                appActivity.hideKeyboard(getBinding().c);
            }
            requireActivity().onBackPressed();
        }
    }

    private final boolean shouldShowCxPrompt() {
        return getMostRecentIntent().getBooleanExtra(ARG_SHOW_CX_PROMPT, false);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        setActionBarTitle(R.string.feedback_modal_title);
        MaterialButton materialButton = getBinding().d;
        Intrinsics3.checkNotNullExpressionValue(materialButton, "binding.issueDetailsSubmitButton");
        materialButton.setEnabled(false);
        getBinding().d.setOnClickListener(new AnonymousClass1());
        TextInputLayout textInputLayout = getBinding().c;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout, "binding.issueDetailsInput");
        ViewExtensions.addBindedTextWatcher(textInputLayout, this, new AnonymousClass2());
        TextInputLayout textInputLayout2 = getBinding().c;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout2, "binding.issueDetailsInput");
        showKeyboard(textInputLayout2);
        LinkifiedTextView linkifiedTextView = getBinding().f2480b;
        Intrinsics3.checkNotNullExpressionValue(linkifiedTextView, "binding.issueDetailsCxPrompt");
        linkifiedTextView.setVisibility(shouldShowCxPrompt() ? 0 : 8);
        LinkifiedTextView linkifiedTextView2 = getBinding().f2480b;
        Intrinsics3.checkNotNullExpressionValue(linkifiedTextView2, "binding.issueDetailsCxPrompt");
        FormatUtils.n(linkifiedTextView2, R.string.feedback_need_more_help, new Object[]{AppHelpDesk.c()}, null, 4);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeEvents(), this, null, 2, null), WidgetIssueDetailsForm.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(), 62, (Object) null);
    }
}
