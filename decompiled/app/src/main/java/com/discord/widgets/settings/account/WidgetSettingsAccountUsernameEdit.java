package com.discord.widgets.settings.account;

import android.content.Context;
import android.content.Intent;
import android.text.Editable;
import android.text.Selection;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import androidx.activity.result.ActivityResultLauncher;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import b.a.a.b.MultiValuePropPremiumUpsellDialog;
import b.a.d.AppScreen2;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetSettingsAccountEditBinding;
import com.discord.models.user.MeUser;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUser;
import com.discord.utilities.analytics.Traits;
import com.discord.utilities.premium.PremiumUtils3;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.stateful.StatefulViews;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.view.validators.ValidationManager;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.widgets.user.WidgetUserPasswordVerify;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputLayout;
import d0.LazyJVM;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.Arrays;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;

/* compiled from: WidgetSettingsAccountUsernameEdit.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \"2\u00020\u0001:\u0001\"B\u0007¢\u0006\u0004\b!\u0010\bJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\r\u0010\bR\u001d\u0010\u0013\u001a\u00020\u000e8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\u00148\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u001d\u0010\u001d\u001a\u00020\u00188B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u0016\u0010\u001f\u001a\u00020\u001e8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 ¨\u0006#"}, d2 = {"Lcom/discord/widgets/settings/account/WidgetSettingsAccountUsernameEdit;", "Lcom/discord/app/AppFragment;", "Lcom/discord/models/user/MeUser;", "meUser", "", "configureUI", "(Lcom/discord/models/user/MeUser;)V", "showPasswordVerification", "()V", "Landroid/view/View;", "view", "onViewBound", "(Landroid/view/View;)V", "onViewBoundOrOnResume", "Lcom/discord/utilities/view/validators/ValidationManager;", "validationManager$delegate", "Lkotlin/Lazy;", "getValidationManager", "()Lcom/discord/utilities/view/validators/ValidationManager;", "validationManager", "Landroidx/activity/result/ActivityResultLauncher;", "Landroid/content/Intent;", "passwordVerifyLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "Lcom/discord/databinding/WidgetSettingsAccountEditBinding;", "binding$delegate", "Lcom/discord/utilities/viewbinding/FragmentViewBindingDelegate;", "getBinding", "()Lcom/discord/databinding/WidgetSettingsAccountEditBinding;", "binding", "Lcom/discord/utilities/stateful/StatefulViews;", "state", "Lcom/discord/utilities/stateful/StatefulViews;", "<init>", "Companion", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class WidgetSettingsAccountUsernameEdit extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetSettingsAccountUsernameEdit.class, "binding", "getBinding()Lcom/discord/databinding/WidgetSettingsAccountEditBinding;", 0)};

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private final ActivityResultLauncher<Intent> passwordVerifyLauncher;
    private final StatefulViews state;

    /* renamed from: validationManager$delegate, reason: from kotlin metadata */
    private final Lazy validationManager;

    /* compiled from: WidgetSettingsAccountUsernameEdit.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/discord/widgets/settings/account/WidgetSettingsAccountUsernameEdit$Companion;", "", "Landroid/content/Context;", "context", "", "launch", "(Landroid/content/Context;)V", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public final void launch(Context context) {
            Intrinsics3.checkNotNullParameter(context, "context");
            AppScreen2.e(context, WidgetSettingsAccountUsernameEdit.class, null, 4);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetSettingsAccountUsernameEdit.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\b\u001a\u00020\u00052\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u00002\u0006\u0010\u0004\u001a\u00020\u0003H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "<anonymous parameter 0>", "", "hasFocus", "", "onFocusChange", "(Landroid/view/View;Z)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.settings.account.WidgetSettingsAccountUsernameEdit$configureUI$1, reason: invalid class name */
    public static final class AnonymousClass1 implements View.OnFocusChangeListener {

        /* compiled from: WidgetSettingsAccountUsernameEdit.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "run", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
        /* renamed from: com.discord.widgets.settings.account.WidgetSettingsAccountUsernameEdit$configureUI$1$1, reason: invalid class name and collision with other inner class name */
        public static final class RunnableC03361 implements Runnable {
            public RunnableC03361() {
            }

            @Override // java.lang.Runnable
            public final void run() {
                WidgetSettingsAccountUsernameEdit.access$getBinding$p(WidgetSettingsAccountUsernameEdit.this).f2598b.clearFocus();
            }
        }

        public AnonymousClass1() {
        }

        @Override // android.view.View.OnFocusChangeListener
        public final void onFocusChange(View view, boolean z2) {
            if (z2) {
                WidgetSettingsAccountUsernameEdit.access$getBinding$p(WidgetSettingsAccountUsernameEdit.this).f2598b.post(new RunnableC03361());
                MultiValuePropPremiumUpsellDialog.Companion companion = MultiValuePropPremiumUpsellDialog.INSTANCE;
                FragmentManager parentFragmentManager = WidgetSettingsAccountUsernameEdit.this.getParentFragmentManager();
                Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
                MultiValuePropPremiumUpsellDialog.Companion.a(companion, parentFragmentManager, 0, WidgetSettingsAccountUsernameEdit.this.getString(R.string.premium_upsell_tag_active_mobile), null, Traits.Location.Page.USER_SETTINGS, "Edit Account", null, null, false, false, 968);
            }
        }
    }

    /* compiled from: WidgetSettingsAccountUsernameEdit.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/text/Editable;", "it", "", "invoke", "(Landroid/text/Editable;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.settings.account.WidgetSettingsAccountUsernameEdit$onViewBound$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<Editable, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Editable editable) {
            invoke2(editable);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Editable editable) {
            Intrinsics3.checkNotNullParameter(editable, "it");
            TextInputLayout textInputLayout = WidgetSettingsAccountUsernameEdit.access$getBinding$p(WidgetSettingsAccountUsernameEdit.this).f2598b;
            Intrinsics3.checkNotNullExpressionValue(textInputLayout, "binding.editAccountDiscriminatorWrap");
            textInputLayout.setError(null);
        }
    }

    /* compiled from: WidgetSettingsAccountUsernameEdit.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/widget/TextView;", "it", "", "invoke", "(Landroid/widget/TextView;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.settings.account.WidgetSettingsAccountUsernameEdit$onViewBound$2, reason: invalid class name */
    public static final class AnonymousClass2 extends Lambda implements Function1<TextView, Unit> {
        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(TextView textView) {
            invoke2(textView);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(TextView textView) {
            Intrinsics3.checkNotNullParameter(textView, "it");
            WidgetSettingsAccountUsernameEdit.access$showPasswordVerification(WidgetSettingsAccountUsernameEdit.this);
        }
    }

    /* compiled from: WidgetSettingsAccountUsernameEdit.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.settings.account.WidgetSettingsAccountUsernameEdit$onViewBound$3, reason: invalid class name */
    public static final class AnonymousClass3 implements View.OnClickListener {
        public AnonymousClass3() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetSettingsAccountUsernameEdit.access$showPasswordVerification(WidgetSettingsAccountUsernameEdit.this);
        }
    }

    /* compiled from: WidgetSettingsAccountUsernameEdit.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/models/user/MeUser;", "it", "", "invoke", "(Lcom/discord/models/user/MeUser;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.settings.account.WidgetSettingsAccountUsernameEdit$onViewBoundOrOnResume$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<MeUser, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(MeUser meUser) {
            invoke2(meUser);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(MeUser meUser) {
            Intrinsics3.checkNotNullParameter(meUser, "it");
            WidgetSettingsAccountUsernameEdit.access$configureUI(WidgetSettingsAccountUsernameEdit.this, meUser);
        }
    }

    public WidgetSettingsAccountUsernameEdit() {
        super(R.layout.widget_settings_account_edit);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetSettingsAccountUsernameEdit2.INSTANCE, null, 2, null);
        this.passwordVerifyLauncher = WidgetUserPasswordVerify.INSTANCE.registerForResult(this, new WidgetSettingsAccountUsernameEdit3(this));
        this.state = new StatefulViews(R.id.edit_account_username_wrap, R.id.edit_account_discriminator_wrap);
        this.validationManager = LazyJVM.lazy(new WidgetSettingsAccountUsernameEdit4(this));
    }

    public static final /* synthetic */ void access$configureUI(WidgetSettingsAccountUsernameEdit widgetSettingsAccountUsernameEdit, MeUser meUser) {
        widgetSettingsAccountUsernameEdit.configureUI(meUser);
    }

    public static final /* synthetic */ WidgetSettingsAccountEditBinding access$getBinding$p(WidgetSettingsAccountUsernameEdit widgetSettingsAccountUsernameEdit) {
        return widgetSettingsAccountUsernameEdit.getBinding();
    }

    public static final /* synthetic */ StatefulViews access$getState$p(WidgetSettingsAccountUsernameEdit widgetSettingsAccountUsernameEdit) {
        return widgetSettingsAccountUsernameEdit.state;
    }

    public static final /* synthetic */ void access$showPasswordVerification(WidgetSettingsAccountUsernameEdit widgetSettingsAccountUsernameEdit) {
        widgetSettingsAccountUsernameEdit.showPasswordVerification();
    }

    private final void configureUI(MeUser meUser) {
        TextInputLayout textInputLayout = getBinding().c;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout, "binding.editAccountUsernameWrap");
        StatefulViews statefulViews = this.state;
        TextInputLayout textInputLayout2 = getBinding().c;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout2, "binding.editAccountUsernameWrap");
        ViewExtensions.setText(textInputLayout, (CharSequence) statefulViews.get(textInputLayout2.getId(), meUser.getUsername()));
        TextInputLayout textInputLayout3 = getBinding().f2598b;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout3, "binding.editAccountDiscriminatorWrap");
        StatefulViews statefulViews2 = this.state;
        TextInputLayout textInputLayout4 = getBinding().f2598b;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout4, "binding.editAccountDiscriminatorWrap");
        int id2 = textInputLayout4.getId();
        String str = String.format("%04d", Arrays.copyOf(new Object[]{Integer.valueOf(meUser.getDiscriminator())}, 1));
        Intrinsics3.checkNotNullExpressionValue(str, "java.lang.String.format(format, *args)");
        ViewExtensions.setText(textInputLayout3, (CharSequence) statefulViews2.get(id2, str));
        TextInputLayout textInputLayout5 = getBinding().c;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout5, "binding.editAccountUsernameWrap");
        EditText editText = textInputLayout5.getEditText();
        Editable text = editText != null ? editText.getText() : null;
        TextInputLayout textInputLayout6 = getBinding().c;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout6, "binding.editAccountUsernameWrap");
        Selection.setSelection(text, ViewExtensions.getTextOrEmpty(textInputLayout6).length());
        boolean zGrantsAccessToCustomTagAndAnimatedAvatarFeatures = PremiumUtils3.grantsAccessToCustomTagAndAnimatedAvatarFeatures(meUser.getPremiumTier());
        TextInputLayout textInputLayout7 = getBinding().f2598b;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout7, "binding.editAccountDiscriminatorWrap");
        textInputLayout7.setLongClickable(zGrantsAccessToCustomTagAndAnimatedAvatarFeatures);
        if (zGrantsAccessToCustomTagAndAnimatedAvatarFeatures) {
            return;
        }
        TextInputLayout textInputLayout8 = getBinding().f2598b;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout8, "binding.editAccountDiscriminatorWrap");
        ViewExtensions.setOnEditTextFocusChangeListener(textInputLayout8, new AnonymousClass1());
    }

    private final WidgetSettingsAccountEditBinding getBinding() {
        return (WidgetSettingsAccountEditBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final ValidationManager getValidationManager() {
        return (ValidationManager) this.validationManager.getValue();
    }

    private final void showPasswordVerification() {
        if (ValidationManager.validate$default(getValidationManager(), false, 1, null)) {
            WidgetUserPasswordVerify.Companion companion = WidgetUserPasswordVerify.INSTANCE;
            Context contextRequireContext = requireContext();
            ActivityResultLauncher<Intent> activityResultLauncher = this.passwordVerifyLauncher;
            TextInputLayout textInputLayout = getBinding().c;
            Intrinsics3.checkNotNullExpressionValue(textInputLayout, "binding.editAccountUsernameWrap");
            String textOrEmpty = ViewExtensions.getTextOrEmpty(textInputLayout);
            TextInputLayout textInputLayout2 = getBinding().f2598b;
            Intrinsics3.checkNotNullExpressionValue(textInputLayout2, "binding.editAccountDiscriminatorWrap");
            WidgetUserPasswordVerify.Companion.launchUpdateAccountSettings$default(companion, contextRequireContext, activityResultLauncher, null, textOrEmpty, ViewExtensions.getTextOrEmpty(textInputLayout2), null, 36, null);
        }
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        setActionBarSubtitle(R.string.user_settings);
        setActionBarTitle(R.string.user_settings_account_change_username_title);
        AppFragment.setActionBarDisplayHomeAsUpEnabled$default(this, false, 1, null);
        TextInputLayout textInputLayout = getBinding().f2598b;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout, "binding.editAccountDiscriminatorWrap");
        ViewExtensions.addBindedTextWatcher(textInputLayout, this, new AnonymousClass1());
        TextInputLayout textInputLayout2 = getBinding().f2598b;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout2, "binding.editAccountDiscriminatorWrap");
        ViewExtensions.setOnImeActionDone$default(textInputLayout2, false, new AnonymousClass2(), 1, null);
        getBinding().d.setOnClickListener(new AnonymousClass3());
        StatefulViews statefulViews = this.state;
        FloatingActionButton floatingActionButton = getBinding().d;
        TextInputLayout textInputLayout3 = getBinding().c;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout3, "binding.editAccountUsernameWrap");
        TextInputLayout textInputLayout4 = getBinding().f2598b;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout4, "binding.editAccountDiscriminatorWrap");
        statefulViews.setupTextWatcherWithSaveAction(this, floatingActionButton, textInputLayout3, textInputLayout4);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(StoreUser.observeMe$default(StoreStream.INSTANCE.getUsers(), false, 1, null), this, null, 2, null), WidgetSettingsAccountUsernameEdit.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(), 62, (Object) null);
    }
}
