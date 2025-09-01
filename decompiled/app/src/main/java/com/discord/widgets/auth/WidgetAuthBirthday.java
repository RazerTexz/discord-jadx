package com.discord.widgets.auth;

import android.content.Context;
import android.content.Intent;
import android.text.SpannableStringBuilder;
import android.view.View;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import b.a.a.DatePickerDialog;
import b.a.d.AppScreen2;
import b.a.k.FormatUtils;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetAuthBirthdayBinding;
import com.discord.stores.StoreStream;
import com.discord.utilities.auth.RegistrationFlowRepo;
import com.discord.utilities.birthday.BirthdayHelper;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.discord.utilities.view.validators.ValidationManager;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.google.android.material.checkbox.MaterialCheckBox;
import com.google.android.material.textfield.TextInputLayout;
import d0.LazyJVM;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;

/* compiled from: WidgetAuthBirthday.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u0000 $2\u00020\u0001:\u0001$B\u0007¢\u0006\u0004\b#\u0010\u000eJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0011\u0010\u0007\u001a\u0004\u0018\u00010\u0002H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\r\u0010\u000eJ\r\u0010\u000f\u001a\u00020\u0004¢\u0006\u0004\b\u000f\u0010\u000eR\u001e\u0010\u0012\u001a\n \u0011*\u0004\u0018\u00010\u00100\u00108\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u001d\u0010\u0019\u001a\u00020\u00148B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u001d\u0010\u001f\u001a\u00020\u001a8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u0016\u0010!\u001a\u00020 8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b!\u0010\"¨\u0006%"}, d2 = {"Lcom/discord/widgets/auth/WidgetAuthBirthday;", "Lcom/discord/app/AppFragment;", "", "date", "", "setBirthday", "(J)V", "getBirthday", "()Ljava/lang/Long;", "Landroid/view/View;", "view", "onViewBound", "(Landroid/view/View;)V", "onViewBoundOrOnResume", "()V", "submit", "Ljava/text/DateFormat;", "kotlin.jvm.PlatformType", "formatter", "Ljava/text/DateFormat;", "Lcom/discord/databinding/WidgetAuthBirthdayBinding;", "binding$delegate", "Lcom/discord/utilities/viewbinding/FragmentViewBindingDelegate;", "getBinding", "()Lcom/discord/databinding/WidgetAuthBirthdayBinding;", "binding", "Lcom/discord/utilities/view/validators/ValidationManager;", "validationManager$delegate", "Lkotlin/Lazy;", "getValidationManager", "()Lcom/discord/utilities/view/validators/ValidationManager;", "validationManager", "", "isConsentRequired", "Z", "<init>", "Companion", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class WidgetAuthBirthday extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetAuthBirthday.class, "binding", "getBinding()Lcom/discord/databinding/WidgetAuthBirthdayBinding;", 0)};

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String RESULT_EXTRA_BIRTHDAY = "RESULT_EXTRA_BIRTHDAY";
    private static final String VALIDATOR_DATE_OF_BIRTH = "dateOfBirth";
    private static final String VALIDATOR_TOS = "tos";

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private final DateFormat formatter;
    private boolean isConsentRequired;

    /* renamed from: validationManager$delegate, reason: from kotlin metadata */
    private final Lazy validationManager;

    /* compiled from: WidgetAuthBirthday.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0016\u0010\u0017J#\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\b\u0010\tJ/\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u000b\u001a\u00020\n2\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00070\f¢\u0006\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0012\u001a\u00020\u00118\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0014\u001a\u00020\u00118\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0014\u0010\u0013R\u0016\u0010\u0015\u001a\u00020\u00118\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0015\u0010\u0013¨\u0006\u0018"}, d2 = {"Lcom/discord/widgets/auth/WidgetAuthBirthday$Companion;", "", "Landroid/content/Context;", "context", "Landroidx/activity/result/ActivityResultLauncher;", "Landroid/content/Intent;", "launcher", "", "launch", "(Landroid/content/Context;Landroidx/activity/result/ActivityResultLauncher;)V", "Lcom/discord/app/AppFragment;", "fragment", "Lkotlin/Function1;", "", "callback", "registerForResult", "(Lcom/discord/app/AppFragment;Lkotlin/jvm/functions/Function1;)Landroidx/activity/result/ActivityResultLauncher;", "", WidgetAuthBirthday.RESULT_EXTRA_BIRTHDAY, "Ljava/lang/String;", "VALIDATOR_DATE_OF_BIRTH", "VALIDATOR_TOS", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public final void launch(Context context, ActivityResultLauncher<Intent> launcher) {
            Intrinsics3.checkNotNullParameter(context, "context");
            Intrinsics3.checkNotNullParameter(launcher, "launcher");
            AppScreen2.g.f(context, launcher, WidgetAuthBirthday.class, null);
        }

        public final ActivityResultLauncher<Intent> registerForResult(AppFragment fragment, Function1<? super Long, Unit> callback) {
            Intrinsics3.checkNotNullParameter(fragment, "fragment");
            Intrinsics3.checkNotNullParameter(callback, "callback");
            ActivityResultLauncher<Intent> activityResultLauncherRegisterForActivityResult = fragment.registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new WidgetAuthBirthday3(callback));
            Intrinsics3.checkNotNullExpressionValue(activityResultLauncherRegisterForActivityResult, "fragment.registerForActi…ay)\n          }\n        }");
            return activityResultLauncherRegisterForActivityResult;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetAuthBirthday.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/view/View;", "it", "", "invoke", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.auth.WidgetAuthBirthday$onViewBoundOrOnResume$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<View, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(View view) {
            invoke2(view);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(View view) {
            Intrinsics3.checkNotNullParameter(view, "it");
            DatePickerDialog.Companion companion = DatePickerDialog.INSTANCE;
            FragmentManager parentFragmentManager = WidgetAuthBirthday.this.getParentFragmentManager();
            Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
            String string = WidgetAuthBirthday.this.getString(R.string.age_gate_date_of_birth);
            Intrinsics3.checkNotNullExpressionValue(string, "getString(R.string.age_gate_date_of_birth)");
            Long lAccess$getBirthday = WidgetAuthBirthday.access$getBirthday(WidgetAuthBirthday.this);
            companion.a(parentFragmentManager, string, lAccess$getBirthday != null ? lAccess$getBirthday.longValue() : BirthdayHelper.INSTANCE.defaultInputAge(), BirthdayHelper.INSTANCE.getMaxDateOfBirth()).onDatePicked = new WidgetAuthBirthday2(this);
        }
    }

    /* compiled from: WidgetAuthBirthday.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.auth.WidgetAuthBirthday$onViewBoundOrOnResume$2, reason: invalid class name */
    public static final class AnonymousClass2 implements View.OnClickListener {
        public AnonymousClass2() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetAuthBirthday.this.submit();
        }
    }

    public WidgetAuthBirthday() {
        super(R.layout.widget_auth_birthday);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetAuthBirthday4.INSTANCE, null, 2, null);
        this.isConsentRequired = true;
        this.formatter = DateFormat.getDateInstance(3);
        this.validationManager = LazyJVM.lazy(new WidgetAuthBirthday5(this));
    }

    public static final /* synthetic */ WidgetAuthBirthdayBinding access$getBinding$p(WidgetAuthBirthday widgetAuthBirthday) {
        return widgetAuthBirthday.getBinding();
    }

    public static final /* synthetic */ Long access$getBirthday(WidgetAuthBirthday widgetAuthBirthday) {
        return widgetAuthBirthday.getBirthday();
    }

    public static final /* synthetic */ boolean access$isConsentRequired$p(WidgetAuthBirthday widgetAuthBirthday) {
        return widgetAuthBirthday.isConsentRequired;
    }

    public static final /* synthetic */ void access$setBirthday(WidgetAuthBirthday widgetAuthBirthday, long j) {
        widgetAuthBirthday.setBirthday(j);
    }

    public static final /* synthetic */ void access$setConsentRequired$p(WidgetAuthBirthday widgetAuthBirthday, boolean z2) {
        widgetAuthBirthday.isConsentRequired = z2;
    }

    private final WidgetAuthBirthdayBinding getBinding() {
        return (WidgetAuthBirthdayBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final Long getBirthday() throws ParseException {
        try {
            DateFormat dateFormat = this.formatter;
            TextInputLayout textInputLayout = getBinding().c;
            Intrinsics3.checkNotNullExpressionValue(textInputLayout, "binding.authRegisterBirthday");
            Date date = dateFormat.parse(ViewExtensions.getTextOrEmpty(textInputLayout));
            if (date != null) {
                return Long.valueOf(date.getTime());
            }
            return null;
        } catch (ParseException unused) {
            return null;
        }
    }

    private final ValidationManager getValidationManager() {
        return (ValidationManager) this.validationManager.getValue();
    }

    private final void setBirthday(long date) {
        String str = this.formatter.format(Long.valueOf(date));
        TextInputLayout textInputLayout = getBinding().c;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout, "binding.authRegisterBirthday");
        ViewExtensions.setText(textInputLayout, new SpannableStringBuilder(str));
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        RegistrationFlowRepo.trackTransition$default(RegistrationFlowRepo.INSTANCE.getINSTANCE(), "Age Gate", "viewed", null, 4, null);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        Calendar calendar = Calendar.getInstance();
        Intrinsics3.checkNotNullExpressionValue(calendar, "Calendar.getInstance()");
        DateFormat dateFormat = this.formatter;
        Intrinsics3.checkNotNullExpressionValue(dateFormat, "formatter");
        dateFormat.setTimeZone(calendar.getTimeZone());
        this.isConsentRequired = StoreStream.INSTANCE.getAuthentication().isConsentRequired();
        MaterialCheckBox materialCheckBox = getBinding().e;
        Intrinsics3.checkNotNullExpressionValue(materialCheckBox, "binding.authTosOptIn");
        materialCheckBox.setVisibility(this.isConsentRequired ? 0 : 8);
        LinkifiedTextView linkifiedTextView = getBinding().f2230b;
        Intrinsics3.checkNotNullExpressionValue(linkifiedTextView, "binding.authPolicyLinks");
        FormatUtils.n(linkifiedTextView, this.isConsentRequired ? R.string.terms_privacy_opt_in : R.string.terms_privacy, new Object[]{getString(R.string.terms_of_service_url), getString(R.string.privacy_policy_url)}, null, 4);
        TextInputLayout textInputLayout = getBinding().c;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout, "binding.authRegisterBirthday");
        ViewExtensions.setOnEditTextClickListener(textInputLayout, new AnonymousClass1());
        getBinding().d.setOnClickListener(new AnonymousClass2());
    }

    public final void submit() {
        RegistrationFlowRepo.Companion companion = RegistrationFlowRepo.INSTANCE;
        RegistrationFlowRepo.trackTransition$default(companion.getINSTANCE(), "Age Gate", "submitted", null, 4, null);
        if (!ValidationManager.validate$default(getValidationManager(), false, 1, null)) {
            RegistrationFlowRepo.trackTransition$default(companion.getINSTANCE(), "Age Gate", "input_error", null, 4, null);
            return;
        }
        RegistrationFlowRepo.trackTransition$default(companion.getINSTANCE(), "Age Gate", "success", null, 4, null);
        Intent intent = new Intent();
        intent.putExtra(RESULT_EXTRA_BIRTHDAY, getBirthday());
        requireActivity().setResult(-1, intent);
        requireActivity().onBackPressed();
    }
}
