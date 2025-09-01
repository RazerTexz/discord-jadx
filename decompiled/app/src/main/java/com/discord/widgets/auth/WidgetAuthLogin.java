package com.discord.widgets.auth;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.activity.result.ActivityResultLauncher;
import androidx.core.app.NotificationCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import b.a.d.AppToast;
import b.a.k.FormatUtils;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.app.AppFragment;
import com.discord.app.AppLogger2;
import com.discord.databinding.WidgetAuthLoginBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.domain.ModelInvite;
import com.discord.models.domain.auth.ModelLoginResult;
import com.discord.models.phone.PhoneCountryCode;
import com.discord.restapi.RestAPIParams;
import com.discord.stores.StorePhone;
import com.discord.stores.StoreStream;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeck4;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.utilities.auth.GoogleSmartLockManager;
import com.discord.utilities.auth.GoogleSmartLockManager3;
import com.discord.utilities.auth.RegistrationFlowRepo;
import com.discord.utilities.captcha.CaptchaHelper;
import com.discord.utilities.error.Error;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.view.validators.ValidationManager;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.widgets.auth.WidgetAuthCaptcha;
import com.discord.widgets.auth.WidgetAuthMfa;
import com.discord.widgets.auth.WidgetAuthPhoneVerify;
import com.discord.widgets.notice.WidgetNoticeDialog;
import com.discord.widgets.settings.account.WidgetSettingsAccountChangePassword;
import com.google.android.material.textfield.TextInputLayout;
import d0.LazyJVM;
import d0.g0.StringsJVM;
import d0.t._Collections;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KProperty;

/* compiled from: WidgetAuthLogin.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 J2\u00020\u0001:\u0001JB\u0007¢\u0006\u0004\bI\u0010\u0019J\u001b\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\t\u0010\nJ%\u0010\r\u001a\u00020\u00042\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\r\u0010\u000eJ5\u0010\r\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u00072\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\r\u0010\u0011J\u001f\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u0012\u0010\u0013J#\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u00142\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0007H\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0018\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u0019\u0010\u001c\u001a\u00020\u00042\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aH\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ\u0017\u0010 \u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020\u001eH\u0016¢\u0006\u0004\b \u0010!R\u001c\u0010$\u001a\b\u0012\u0004\u0012\u00020#0\"8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b$\u0010%R\u001d\u0010+\u001a\u00020&8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*R\"\u0010-\u001a\u00020,8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b-\u0010.\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\u001c\u00103\u001a\b\u0012\u0004\u0012\u00020#0\"8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b3\u0010%R\u001c\u00105\u001a\u0002048\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b5\u00106\u001a\u0004\b7\u00108R\u001c\u00109\u001a\b\u0012\u0004\u0012\u00020#0\"8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b9\u0010%R$\u0010;\u001a\u0004\u0018\u00010:8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b;\u0010<\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@R\u001c\u0010A\u001a\b\u0012\u0004\u0012\u00020#0\"8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bA\u0010%R\u001d\u0010G\u001a\u00020B8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\bC\u0010D\u001a\u0004\bE\u0010FR\u001c\u0010H\u001a\b\u0012\u0004\u0012\u00020#0\"8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bH\u0010%¨\u0006K"}, d2 = {"Lcom/discord/widgets/auth/WidgetAuthLogin;", "Lcom/discord/app/AppFragment;", "Lcom/discord/utilities/captcha/CaptchaHelper$CaptchaPayload;", "captchaPayload", "", "forgotPassword", "(Lcom/discord/utilities/captcha/CaptchaHelper$CaptchaPayload;)V", "", NotificationCompat.CATEGORY_EMAIL, "showEmailSentToast", "(Ljava/lang/String;)V", "", "undelete", "login", "(Lcom/discord/utilities/captcha/CaptchaHelper$CaptchaPayload;Z)V", ModelAuditLogEntry.CHANGE_KEY_ID, WidgetSettingsAccountChangePassword.CURRENT_PASSWORD_FIELD, "(Ljava/lang/String;Ljava/lang/String;Lcom/discord/utilities/captcha/CaptchaHelper$CaptchaPayload;Z)V", "onLoginSuccess", "(Ljava/lang/String;Ljava/lang/String;)V", "Lcom/discord/utilities/error/Error;", "error", "handleError", "(Lcom/discord/utilities/error/Error;Ljava/lang/String;)V", "loadCachedLogin", "()V", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "Landroid/view/View;", "view", "onViewBound", "(Landroid/view/View;)V", "Landroidx/activity/result/ActivityResultLauncher;", "Landroid/content/Intent;", "phoneVerifyPasswordLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "Lcom/discord/utilities/view/validators/ValidationManager;", "validationManager$delegate", "Lkotlin/Lazy;", "getValidationManager", "()Lcom/discord/utilities/view/validators/ValidationManager;", "validationManager", "Lcom/discord/utilities/auth/GoogleSmartLockManager;", "googleSmartLockManager", "Lcom/discord/utilities/auth/GoogleSmartLockManager;", "getGoogleSmartLockManager", "()Lcom/discord/utilities/auth/GoogleSmartLockManager;", "setGoogleSmartLockManager", "(Lcom/discord/utilities/auth/GoogleSmartLockManager;)V", "captchaLoginLauncher", "Lcom/discord/app/LoggingConfig;", "loggingConfig", "Lcom/discord/app/LoggingConfig;", "getLoggingConfig", "()Lcom/discord/app/LoggingConfig;", "phoneVerifyLoginLauncher", "Lcom/discord/utilities/auth/GoogleSmartLockManager$SmartLockCredentials;", "smartLockCredentials", "Lcom/discord/utilities/auth/GoogleSmartLockManager$SmartLockCredentials;", "getSmartLockCredentials", "()Lcom/discord/utilities/auth/GoogleSmartLockManager$SmartLockCredentials;", "setSmartLockCredentials", "(Lcom/discord/utilities/auth/GoogleSmartLockManager$SmartLockCredentials;)V", "undeleteAccountLauncher", "Lcom/discord/databinding/WidgetAuthLoginBinding;", "binding$delegate", "Lcom/discord/utilities/viewbinding/FragmentViewBindingDelegate;", "getBinding", "()Lcom/discord/databinding/WidgetAuthLoginBinding;", "binding", "captchaForgotPasswordLauncher", "<init>", "Companion", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class WidgetAuthLogin extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetAuthLogin.class, "binding", "getBinding()Lcom/discord/databinding/WidgetAuthLoginBinding;", 0)};
    public static final String GOOGLE_SMARTLOCK_LOGIN_EXTRA_ID = "smartlock_extra_id";
    public static final String GOOGLE_SMARTLOCK_LOGIN_EXTRA_PASSWORD = "smartlock_extra_password";

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private final ActivityResultLauncher<Intent> captchaForgotPasswordLauncher;
    private final ActivityResultLauncher<Intent> captchaLoginLauncher;
    public GoogleSmartLockManager googleSmartLockManager;
    private final AppLogger2 loggingConfig;
    private final ActivityResultLauncher<Intent> phoneVerifyLoginLauncher;
    private final ActivityResultLauncher<Intent> phoneVerifyPasswordLauncher;
    private GoogleSmartLockManager.SmartLockCredentials smartLockCredentials;
    private final ActivityResultLauncher<Intent> undeleteAccountLauncher;

    /* renamed from: validationManager$delegate, reason: from kotlin metadata */
    private final Lazy validationManager;

    /* compiled from: WidgetAuthLogin.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Ljava/lang/Void;", "it", "", "invoke", "(Ljava/lang/Void;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.auth.WidgetAuthLogin$forgotPassword$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<Void, Unit> {
        public final /* synthetic */ String $login;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(String str) {
            super(1);
            this.$login = str;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Void r1) {
            invoke2(r1);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Void r2) {
            WidgetAuthLogin.access$showEmailSentToast(WidgetAuthLogin.this, this.$login);
        }
    }

    /* compiled from: WidgetAuthLogin.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/utilities/error/Error;", "error", "", "invoke", "(Lcom/discord/utilities/error/Error;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.auth.WidgetAuthLogin$forgotPassword$2, reason: invalid class name */
    public static final class AnonymousClass2 extends Lambda implements Function1<Error, Unit> {
        public final /* synthetic */ String $login;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(String str) {
            super(1);
            this.$login = str;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Error error) {
            invoke2(error);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Error error) {
            Intrinsics3.checkNotNullParameter(error, "error");
            Error.Response response = error.getResponse();
            Intrinsics3.checkNotNullExpressionValue(response, "error.response");
            if (response.getCode() != 70007) {
                ValidationManager validationManagerAccess$getValidationManager$p = WidgetAuthLogin.access$getValidationManager$p(WidgetAuthLogin.this);
                Error.Response response2 = error.getResponse();
                Intrinsics3.checkNotNullExpressionValue(response2, "error.response");
                Map<String, List<String>> messages = response2.getMessages();
                Intrinsics3.checkNotNullExpressionValue(messages, "error.response.messages");
                WidgetAuthCaptcha.INSTANCE.processErrorsForCaptcha(WidgetAuthLogin.this.requireContext(), WidgetAuthLogin.access$getCaptchaForgotPasswordLauncher$p(WidgetAuthLogin.this), _Collections.toMutableList((Collection) validationManagerAccess$getValidationManager$p.setErrors(messages)), error);
                error.setShowErrorToasts(!r0.isEmpty());
                return;
            }
            WidgetAuthPhoneVerify.Companion companion = WidgetAuthPhoneVerify.INSTANCE;
            Context contextRequireContext = WidgetAuthLogin.this.requireContext();
            ActivityResultLauncher<Intent> activityResultLauncherAccess$getPhoneVerifyPasswordLauncher$p = WidgetAuthLogin.access$getPhoneVerifyPasswordLauncher$p(WidgetAuthLogin.this);
            String str = this.$login;
            String string = WidgetAuthLogin.this.getString(R.string.password_recovery_verify_phone_title);
            Intrinsics3.checkNotNullExpressionValue(string, "getString(R.string.passw…overy_verify_phone_title)");
            String string2 = WidgetAuthLogin.this.getString(R.string.password_recovery_verify_phone_subtitle);
            Intrinsics3.checkNotNullExpressionValue(string2, "getString(R.string.passw…ry_verify_phone_subtitle)");
            companion.launch(contextRequireContext, activityResultLauncherAccess$getPhoneVerifyPasswordLauncher$p, str, string, string2);
            error.setShowErrorToasts(false);
        }
    }

    /* compiled from: WidgetAuthLogin.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/models/domain/auth/ModelLoginResult;", "it", "", "invoke", "(Lcom/discord/models/domain/auth/ModelLoginResult;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.auth.WidgetAuthLogin$login$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<ModelLoginResult, Unit> {
        public final /* synthetic */ Context $context;
        public final /* synthetic */ String $id;
        public final /* synthetic */ String $password;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(String str, String str2, Context context) {
            super(1);
            this.$id = str;
            this.$password = str2;
            this.$context = context;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ModelLoginResult modelLoginResult) {
            invoke2(modelLoginResult);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ModelLoginResult modelLoginResult) {
            Intrinsics3.checkNotNullParameter(modelLoginResult, "it");
            WidgetAuthLogin.access$onLoginSuccess(WidgetAuthLogin.this, this.$id, this.$password);
            if (!modelLoginResult.getMfa()) {
                AnalyticsTracker.INSTANCE.loginAttempt(true);
                return;
            }
            WidgetAuthMfa.Companion companion = WidgetAuthMfa.INSTANCE;
            Context context = this.$context;
            String ticket = modelLoginResult.getTicket();
            Intrinsics3.checkNotNull(ticket);
            companion.start(context, ticket);
        }
    }

    /* compiled from: WidgetAuthLogin.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/utilities/error/Error;", "it", "", "invoke", "(Lcom/discord/utilities/error/Error;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.auth.WidgetAuthLogin$login$2, reason: invalid class name */
    public static final class AnonymousClass2 extends Lambda implements Function1<Error, Unit> {
        public final /* synthetic */ String $id;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(String str) {
            super(1);
            this.$id = str;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Error error) {
            invoke2(error);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Error error) {
            Intrinsics3.checkNotNullParameter(error, "it");
            WidgetAuthLogin.access$handleError(WidgetAuthLogin.this, error, this.$id);
            AnalyticsTracker.INSTANCE.loginAttempt(false);
        }
    }

    /* compiled from: WidgetAuthLogin.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/models/domain/ModelInvite;", "invite", "", "invoke", "(Lcom/discord/models/domain/ModelInvite;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.auth.WidgetAuthLogin$onViewBound$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<ModelInvite, Unit> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ModelInvite modelInvite) {
            invoke2(modelInvite);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ModelInvite modelInvite) {
            AnalyticsTracker.INSTANCE.loginViewed(modelInvite);
        }
    }

    /* compiled from: WidgetAuthLogin.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.auth.WidgetAuthLogin$onViewBound$2, reason: invalid class name */
    public static final class AnonymousClass2 implements View.OnClickListener {
        public AnonymousClass2() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetAuthLogin.login$default(WidgetAuthLogin.this, null, false, 3, null);
        }
    }

    /* compiled from: WidgetAuthLogin.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/widget/TextView;", "it", "", "invoke", "(Landroid/widget/TextView;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.auth.WidgetAuthLogin$onViewBound$3, reason: invalid class name */
    public static final class AnonymousClass3 extends Lambda implements Function1<TextView, Unit> {
        public AnonymousClass3() {
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
            WidgetAuthLogin.login$default(WidgetAuthLogin.this, null, false, 3, null);
        }
    }

    /* compiled from: WidgetAuthLogin.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.auth.WidgetAuthLogin$onViewBound$4, reason: invalid class name */
    public static final class AnonymousClass4 implements View.OnClickListener {
        public AnonymousClass4() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetAuthLogin.forgotPassword$default(WidgetAuthLogin.this, null, 1, null);
        }
    }

    /* compiled from: WidgetAuthLogin.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.auth.WidgetAuthLogin$onViewBound$5, reason: invalid class name */
    public static final class AnonymousClass5 implements View.OnClickListener {

        /* compiled from: WidgetAuthLogin.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/view/View;", "it", "", "invoke", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
        /* renamed from: com.discord.widgets.auth.WidgetAuthLogin$onViewBound$5$1, reason: invalid class name */
        public static final class AnonymousClass1 extends Lambda implements Function1<View, Unit> {
            public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

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
                try {
                    view.getContext().startActivity(new Intent("android.settings.ACCESSIBILITY_SETTINGS"));
                } catch (ActivityNotFoundException unused) {
                    AppToast.g(view.getContext(), R.string.password_manager_open_settings_error, 0, null, 12);
                }
            }
        }

        public AnonymousClass5() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetNoticeDialog.Builder negativeButton$default = WidgetNoticeDialog.Builder.setNegativeButton$default(new WidgetNoticeDialog.Builder(WidgetAuthLogin.this.requireContext()).setTitle(R.string.password_manager).setMessage(R.string.password_manager_info_android).setPositiveButton(R.string.password_manager_open_settings, AnonymousClass1.INSTANCE), R.string.cancel, (Function1) null, 2, (Object) null);
            FragmentManager parentFragmentManager = WidgetAuthLogin.this.getParentFragmentManager();
            Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
            negativeButton$default.show(parentFragmentManager);
        }
    }

    /* compiled from: WidgetAuthLogin.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.auth.WidgetAuthLogin$onViewBound$6, reason: invalid class name */
    public static final class AnonymousClass6 implements View.OnClickListener {
        public AnonymousClass6() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            AppFragment.hideKeyboard$default(WidgetAuthLogin.this, null, 1, null);
        }
    }

    /* compiled from: WidgetAuthLogin.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lcom/discord/models/phone/PhoneCountryCode;", "invoke", "()Lcom/discord/models/phone/PhoneCountryCode;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.auth.WidgetAuthLogin$onViewBound$8, reason: invalid class name */
    public static final class AnonymousClass8 extends Lambda implements Function0<PhoneCountryCode> {
        public final /* synthetic */ StorePhone $phoneStore;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass8(StorePhone storePhone) {
            super(0);
            this.$phoneStore = storePhone;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ PhoneCountryCode invoke() {
            return invoke();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final PhoneCountryCode invoke() {
            return this.$phoneStore.getCountryCode();
        }
    }

    /* compiled from: WidgetAuthLogin.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/models/phone/PhoneCountryCode;", "it", "", "invoke", "(Lcom/discord/models/phone/PhoneCountryCode;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.auth.WidgetAuthLogin$onViewBound$9, reason: invalid class name */
    public static final class AnonymousClass9 extends Lambda implements Function1<PhoneCountryCode, Unit> {
        public AnonymousClass9() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(PhoneCountryCode phoneCountryCode) {
            invoke2(phoneCountryCode);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(PhoneCountryCode phoneCountryCode) {
            Intrinsics3.checkNotNullParameter(phoneCountryCode, "it");
            WidgetAuthLogin.access$getBinding$p(WidgetAuthLogin.this).e.setCountryCode(phoneCountryCode);
        }
    }

    public WidgetAuthLogin() {
        super(R.layout.widget_auth_login);
        this.loggingConfig = new AppLogger2(false, null, WidgetAuthLogin5.INSTANCE, 3);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetAuthLogin2.INSTANCE, null, 2, null);
        WidgetAuthCaptcha.Companion companion = WidgetAuthCaptcha.INSTANCE;
        this.captchaForgotPasswordLauncher = companion.registerForResult(this, new WidgetAuthLogin3(this));
        this.captchaLoginLauncher = companion.registerForResult(this, new WidgetAuthLogin4(this));
        WidgetAuthPhoneVerify.Companion companion2 = WidgetAuthPhoneVerify.INSTANCE;
        this.phoneVerifyLoginLauncher = companion2.registerForResult(this, new WidgetAuthLogin6(this));
        this.phoneVerifyPasswordLauncher = companion2.registerForResult(this, new WidgetAuthLogin7(this));
        this.undeleteAccountLauncher = WidgetAuthUndeleteAccount.INSTANCE.registerForResult(this, new WidgetAuthLogin8(this));
        this.validationManager = LazyJVM.lazy(new WidgetAuthLogin9(this));
    }

    public static final /* synthetic */ void access$forgotPassword(WidgetAuthLogin widgetAuthLogin, CaptchaHelper.CaptchaPayload captchaPayload) {
        widgetAuthLogin.forgotPassword(captchaPayload);
    }

    public static final /* synthetic */ WidgetAuthLoginBinding access$getBinding$p(WidgetAuthLogin widgetAuthLogin) {
        return widgetAuthLogin.getBinding();
    }

    public static final /* synthetic */ ActivityResultLauncher access$getCaptchaForgotPasswordLauncher$p(WidgetAuthLogin widgetAuthLogin) {
        return widgetAuthLogin.captchaForgotPasswordLauncher;
    }

    public static final /* synthetic */ ActivityResultLauncher access$getPhoneVerifyPasswordLauncher$p(WidgetAuthLogin widgetAuthLogin) {
        return widgetAuthLogin.phoneVerifyPasswordLauncher;
    }

    public static final /* synthetic */ ValidationManager access$getValidationManager$p(WidgetAuthLogin widgetAuthLogin) {
        return widgetAuthLogin.getValidationManager();
    }

    public static final /* synthetic */ void access$handleError(WidgetAuthLogin widgetAuthLogin, Error error, String str) {
        widgetAuthLogin.handleError(error, str);
    }

    public static final /* synthetic */ void access$onLoginSuccess(WidgetAuthLogin widgetAuthLogin, String str, String str2) {
        widgetAuthLogin.onLoginSuccess(str, str2);
    }

    public static final /* synthetic */ void access$showEmailSentToast(WidgetAuthLogin widgetAuthLogin, String str) {
        widgetAuthLogin.showEmailSentToast(str);
    }

    private final void forgotPassword(CaptchaHelper.CaptchaPayload captchaPayload) {
        String textOrEmpty = getBinding().e.getTextOrEmpty();
        if (textOrEmpty.length() == 0) {
            AppToast.g(getContext(), R.string.login_required, 0, null, 12);
        } else {
            ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.withDimmer$default(ObservableExtensionsKt.ui(StoreStream.INSTANCE.getAuthentication().forgotPassword(textOrEmpty, captchaPayload)), getBinding().h, 0L, 2, null), getContext(), "REST: forgotPassword", (Function1) null, new AnonymousClass1(textOrEmpty), new AnonymousClass2(textOrEmpty), (Function0) null, (Function0) null, 100, (Object) null);
        }
    }

    public static /* synthetic */ void forgotPassword$default(WidgetAuthLogin widgetAuthLogin, CaptchaHelper.CaptchaPayload captchaPayload, int i, Object obj) {
        if ((i & 1) != 0) {
            captchaPayload = null;
        }
        widgetAuthLogin.forgotPassword(captchaPayload);
    }

    private final WidgetAuthLoginBinding getBinding() {
        return (WidgetAuthLoginBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final ValidationManager getValidationManager() {
        return (ValidationManager) this.validationManager.getValue();
    }

    private final void handleError(Error error, String login) {
        Error.Response response = error.getResponse();
        Intrinsics3.checkNotNullExpressionValue(response, "error.response");
        boolean z2 = response.getCode() == 20011;
        boolean z3 = response.getCode() == 20013;
        boolean z4 = response.getCode() == 70007;
        if (response.getCode() == 50035) {
            if (login == null || this.smartLockCredentials == null) {
                return;
            }
            GoogleSmartLockManager googleSmartLockManager = this.googleSmartLockManager;
            if (googleSmartLockManager == null) {
                Intrinsics3.throwUninitializedPropertyAccessException("googleSmartLockManager");
            }
            googleSmartLockManager.getSmartLockRepo().onSmartLockCredentialsFailed();
            GoogleSmartLockManager googleSmartLockManager2 = this.googleSmartLockManager;
            if (googleSmartLockManager2 == null) {
                Intrinsics3.throwUninitializedPropertyAccessException("googleSmartLockManager");
            }
            googleSmartLockManager2.deleteCredentials(login);
            this.smartLockCredentials = null;
            GoogleSmartLockManager3.clearSmartLockCredentials(getMostRecentIntent());
            return;
        }
        if (z2) {
            WidgetAuthUndeleteAccount.INSTANCE.launch(requireContext(), this.undeleteAccountLauncher, false);
            return;
        }
        if (z3) {
            WidgetAuthUndeleteAccount.INSTANCE.launch(requireContext(), this.undeleteAccountLauncher, true);
            return;
        }
        if (z4) {
            WidgetAuthPhoneVerify.Companion companion = WidgetAuthPhoneVerify.INSTANCE;
            Context contextRequireContext = requireContext();
            ActivityResultLauncher<Intent> activityResultLauncher = this.phoneVerifyLoginLauncher;
            String textOrEmpty = getBinding().e.getTextOrEmpty();
            String string = getString(R.string.phone_ip_authorization_title);
            Intrinsics3.checkNotNullExpressionValue(string, "getString(R.string.phone_ip_authorization_title)");
            String string2 = getString(R.string.phone_ip_authorization_subtitle);
            Intrinsics3.checkNotNullExpressionValue(string2, "getString(R.string.phone…p_authorization_subtitle)");
            companion.launch(contextRequireContext, activityResultLauncher, textOrEmpty, string, string2);
            return;
        }
        Error.Response response2 = error.getResponse();
        Intrinsics3.checkNotNullExpressionValue(response2, "error.response");
        if (response2.getMessages().isEmpty()) {
            return;
        }
        ValidationManager validationManager = getValidationManager();
        Map<String, List<String>> messages = response.getMessages();
        Intrinsics3.checkNotNullExpressionValue(messages, "errorResponse.messages");
        WidgetAuthCaptcha.INSTANCE.processErrorsForCaptcha(requireContext(), this.captchaLoginLauncher, _Collections.toMutableList((Collection) validationManager.setErrors(messages)), error);
        error.setShowErrorToasts(!r13.isEmpty());
    }

    public static /* synthetic */ void handleError$default(WidgetAuthLogin widgetAuthLogin, Error error, String str, int i, Object obj) {
        if ((i & 2) != 0) {
            str = null;
        }
        widgetAuthLogin.handleError(error, str);
    }

    private final void loadCachedLogin() {
        String savedLogin = StoreStream.INSTANCE.getAuthentication().getSavedLogin();
        if (savedLogin == null || !(!StringsJVM.isBlank(savedLogin))) {
            getBinding().e.requestFocus();
        } else {
            getBinding().e.setText(savedLogin);
            getBinding().g.requestFocus();
        }
    }

    private final void login(CaptchaHelper.CaptchaPayload captchaPayload, boolean undelete) {
        if (ValidationManager.validate$default(getValidationManager(), false, 1, null)) {
            String textOrEmpty = getBinding().e.getTextOrEmpty();
            TextInputLayout textInputLayout = getBinding().g;
            Intrinsics3.checkNotNullExpressionValue(textInputLayout, "binding.authLoginPasswordWrap");
            login(textOrEmpty, ViewExtensions.getTextOrEmpty(textInputLayout), captchaPayload, undelete);
        }
    }

    public static /* synthetic */ void login$default(WidgetAuthLogin widgetAuthLogin, CaptchaHelper.CaptchaPayload captchaPayload, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            captchaPayload = null;
        }
        if ((i & 2) != 0) {
            z2 = false;
        }
        widgetAuthLogin.login(captchaPayload, z2);
    }

    private final void onLoginSuccess(String id2, String password) {
        if (GoogleSmartLockManager3.hasSmartLockCredentials(getMostRecentIntent())) {
            GoogleSmartLockManager googleSmartLockManager = this.googleSmartLockManager;
            if (googleSmartLockManager == null) {
                Intrinsics3.throwUninitializedPropertyAccessException("googleSmartLockManager");
            }
            googleSmartLockManager.getSmartLockRepo().onLoginWithSmartLockSuccess();
        }
        GoogleSmartLockManager googleSmartLockManager2 = this.googleSmartLockManager;
        if (googleSmartLockManager2 == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("googleSmartLockManager");
        }
        googleSmartLockManager2.saveCredentials(id2, password);
    }

    private final void showEmailSentToast(String email) {
        AppToast.h(getContext(), FormatUtils.h(requireContext(), R.string.email_verification_instructions_body, new Object[]{email}, null, 4), 0, null, 12);
    }

    public final GoogleSmartLockManager getGoogleSmartLockManager() {
        GoogleSmartLockManager googleSmartLockManager = this.googleSmartLockManager;
        if (googleSmartLockManager == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("googleSmartLockManager");
        }
        return googleSmartLockManager;
    }

    @Override // com.discord.app.AppFragment, com.discord.app.AppLogger.a
    public AppLogger2 getLoggingConfig() {
        return this.loggingConfig;
    }

    public final GoogleSmartLockManager.SmartLockCredentials getSmartLockCredentials() {
        return this.smartLockCredentials;
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        RegistrationFlowRepo.INSTANCE.getINSTANCE().setRegistering(false);
        FragmentActivity fragmentActivityRequireActivity = requireActivity();
        Intrinsics3.checkNotNullExpressionValue(fragmentActivityRequireActivity, "requireActivity()");
        this.googleSmartLockManager = new GoogleSmartLockManager(fragmentActivityRequireActivity, null, 2, null);
        this.smartLockCredentials = GoogleSmartLockManager3.toSmartLockCredentials(getMostRecentIntent());
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        StoreStream.Companion companion = StoreStream.INSTANCE;
        companion.getInviteSettings().trackWithInvite$app_productionGoogleRelease(WidgetAuthLogin.class, AnonymousClass1.INSTANCE);
        loadCachedLogin();
        getBinding().f2232b.setOnClickListener(new AnonymousClass2());
        TextInputLayout textInputLayout = getBinding().g;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout, "binding.authLoginPasswordWrap");
        ViewExtensions.setOnImeActionDone$default(textInputLayout, false, new AnonymousClass3(), 1, null);
        getBinding().d.setOnClickListener(new AnonymousClass4());
        getBinding().f.setOnClickListener(new AnonymousClass5());
        getBinding().c.setOnClickListener(new AnonymousClass6());
        getBinding().e.b(this);
        GoogleSmartLockManager.SmartLockCredentials smartLockCredentials = this.smartLockCredentials;
        if (smartLockCredentials != null) {
            getBinding().e.setText(smartLockCredentials.getId());
            TextInputLayout textInputLayout2 = getBinding().g;
            Intrinsics3.checkNotNullExpressionValue(textInputLayout2, "binding.authLoginPasswordWrap");
            ViewExtensions.setText(textInputLayout2, smartLockCredentials.getPassword());
            login$default(this, null, false, 3, null);
        }
        StorePhone phone = companion.getPhone();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservationDeck.connectRx$default(ObservationDeck4.get(), new ObservationDeck.UpdateSource[]{phone}, false, null, null, new AnonymousClass8(phone), 14, null), this, null, 2, null), WidgetAuthLogin.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass9(), 62, (Object) null);
    }

    public final void setGoogleSmartLockManager(GoogleSmartLockManager googleSmartLockManager) {
        Intrinsics3.checkNotNullParameter(googleSmartLockManager, "<set-?>");
        this.googleSmartLockManager = googleSmartLockManager;
    }

    public final void setSmartLockCredentials(GoogleSmartLockManager.SmartLockCredentials smartLockCredentials) {
        this.smartLockCredentials = smartLockCredentials;
    }

    public static /* synthetic */ void login$default(WidgetAuthLogin widgetAuthLogin, String str, String str2, CaptchaHelper.CaptchaPayload captchaPayload, boolean z2, int i, Object obj) {
        if ((i & 4) != 0) {
            captchaPayload = null;
        }
        if ((i & 8) != 0) {
            z2 = false;
        }
        widgetAuthLogin.login(str, str2, captchaPayload, z2);
    }

    private final void login(String id2, String password, CaptchaHelper.CaptchaPayload captchaPayload, boolean undelete) {
        Context context = getContext();
        if (context != null) {
            Intrinsics3.checkNotNullExpressionValue(context, "context ?: return");
            ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.withDimmer$default(ObservableExtensionsKt.ui$default(StoreStream.INSTANCE.getAuthentication().login(id2, password, captchaPayload, undelete, GoogleSmartLockManager3.hasSmartLockCredentials(getMostRecentIntent()) ? RestAPIParams.AuthLogin.LoginSource.LOGIN_SOURCE_KEYCHAIN_AUTO : null), this, null, 2, null), getBinding().h, 0L, 2, null), context, "REST: login", (Function1) null, new AnonymousClass1(id2, password, context), new AnonymousClass2(id2), (Function0) null, (Function0) null, 100, (Object) null);
        }
    }
}
