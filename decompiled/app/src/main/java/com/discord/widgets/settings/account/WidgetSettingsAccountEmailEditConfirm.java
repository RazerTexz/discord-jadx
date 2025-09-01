package com.discord.widgets.settings.account;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.TextView;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.core.app.NotificationCompat;
import androidx.fragment.app.Fragment;
import b.a.d.AppScreen2;
import b.a.d.AppToast;
import b.a.d.o;
import b.a.k.FormatUtils;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetSettingsAccountEmailEditConfirmBinding;
import com.discord.i18n.RenderContext;
import com.discord.models.domain.ModelEmailChangeConfirm;
import com.discord.models.user.MeUser;
import com.discord.restapi.RestAPIParams;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUser;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.widgets.user.WidgetUserPasswordVerify;
import com.google.android.material.textfield.TextInputLayout;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import rx.functions.Action1;

/* compiled from: WidgetSettingsAccountEmailEditConfirm.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB\u0007¢\u0006\u0004\b\u0019\u0010\bJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\t\u0010\bJ\u0017\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000e\u0010\bR\u001c\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u001d\u0010\u0018\u001a\u00020\u00138B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u001b"}, d2 = {"Lcom/discord/widgets/settings/account/WidgetSettingsAccountEmailEditConfirm;", "Lcom/discord/app/AppFragment;", "Lcom/discord/models/user/MeUser;", "meUser", "", "configureUI", "(Lcom/discord/models/user/MeUser;)V", "resendVerificationCode", "()V", "submitVerificationCode", "Landroid/view/View;", "view", "onViewBound", "(Landroid/view/View;)V", "onViewBoundOrOnResume", "Landroidx/activity/result/ActivityResultLauncher;", "Landroid/content/Intent;", "passwordVerifyLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "Lcom/discord/databinding/WidgetSettingsAccountEmailEditConfirmBinding;", "binding$delegate", "Lcom/discord/utilities/viewbinding/FragmentViewBindingDelegate;", "getBinding", "()Lcom/discord/databinding/WidgetSettingsAccountEmailEditConfirmBinding;", "binding", "<init>", "Companion", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class WidgetSettingsAccountEmailEditConfirm extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetSettingsAccountEmailEditConfirm.class, "binding", "getBinding()Lcom/discord/databinding/WidgetSettingsAccountEmailEditConfirmBinding;", 0)};

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String EXTRA_EMAIL = "extra_email";

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private final ActivityResultLauncher<Intent> passwordVerifyLauncher;

    /* compiled from: WidgetSettingsAccountEmailEditConfirm.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0014\u0010\u0015J/\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\n\u0010\u000bJ)\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\r\u001a\u00020\f2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\t0\u000e¢\u0006\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0012\u001a\u00020\u00078\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013¨\u0006\u0016"}, d2 = {"Lcom/discord/widgets/settings/account/WidgetSettingsAccountEmailEditConfirm$Companion;", "", "Landroid/content/Context;", "context", "Landroidx/activity/result/ActivityResultLauncher;", "Landroid/content/Intent;", "launcher", "", NotificationCompat.CATEGORY_EMAIL, "", "launch", "(Landroid/content/Context;Landroidx/activity/result/ActivityResultLauncher;Ljava/lang/String;)V", "Lcom/discord/app/AppFragment;", "fragment", "Lkotlin/Function0;", "callback", "registerForResult", "(Lcom/discord/app/AppFragment;Lkotlin/jvm/functions/Function0;)Landroidx/activity/result/ActivityResultLauncher;", "EXTRA_EMAIL", "Ljava/lang/String;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public static /* synthetic */ void launch$default(Companion companion, Context context, ActivityResultLauncher activityResultLauncher, String str, int i, Object obj) {
            if ((i & 4) != 0) {
                str = null;
            }
            companion.launch(context, activityResultLauncher, str);
        }

        public final void launch(Context context, ActivityResultLauncher<Intent> launcher, String email) {
            Intrinsics3.checkNotNullParameter(context, "context");
            Intrinsics3.checkNotNullParameter(launcher, "launcher");
            Intent intent = new Intent();
            intent.putExtra(WidgetSettingsAccountEmailEditConfirm.EXTRA_EMAIL, email);
            AppScreen2.g.f(context, launcher, WidgetSettingsAccountEmailEditConfirm.class, intent);
        }

        public final ActivityResultLauncher<Intent> registerForResult(AppFragment fragment, Function0<Unit> callback) {
            Intrinsics3.checkNotNullParameter(fragment, "fragment");
            Intrinsics3.checkNotNullParameter(callback, "callback");
            ActivityResultLauncher<Intent> activityResultLauncherRegisterForActivityResult = fragment.registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new WidgetSettingsAccountEmailEditConfirm2(callback));
            Intrinsics3.checkNotNullExpressionValue(activityResultLauncherRegisterForActivityResult, "fragment.registerForActi…k()\n          }\n        }");
            return activityResultLauncherRegisterForActivityResult;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetSettingsAccountEmailEditConfirm.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/discord/i18n/RenderContext;", "", "invoke", "(Lcom/discord/i18n/RenderContext;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.settings.account.WidgetSettingsAccountEmailEditConfirm$configureUI$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<RenderContext, Unit> {

        /* compiled from: WidgetSettingsAccountEmailEditConfirm.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/view/View;", "it", "", "invoke", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
        /* renamed from: com.discord.widgets.settings.account.WidgetSettingsAccountEmailEditConfirm$configureUI$1$1, reason: invalid class name and collision with other inner class name */
        public static final class C03351 extends Lambda implements Function1<View, Unit> {
            public C03351() {
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
                WidgetSettingsAccountEmailEditConfirm.access$resendVerificationCode(WidgetSettingsAccountEmailEditConfirm.this);
            }
        }

        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(RenderContext renderContext) {
            invoke2(renderContext);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(RenderContext renderContext) {
            Intrinsics3.checkNotNullParameter(renderContext, "$receiver");
            renderContext.b("onResend", new C03351());
        }
    }

    /* compiled from: WidgetSettingsAccountEmailEditConfirm.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/widget/TextView;", "it", "", "invoke", "(Landroid/widget/TextView;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.settings.account.WidgetSettingsAccountEmailEditConfirm$onViewBound$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<TextView, Unit> {
        public AnonymousClass1() {
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
            WidgetSettingsAccountEmailEditConfirm.access$submitVerificationCode(WidgetSettingsAccountEmailEditConfirm.this);
        }
    }

    /* compiled from: WidgetSettingsAccountEmailEditConfirm.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.settings.account.WidgetSettingsAccountEmailEditConfirm$onViewBound$2, reason: invalid class name */
    public static final class AnonymousClass2 implements View.OnClickListener {
        public AnonymousClass2() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetSettingsAccountEmailEditConfirm.access$submitVerificationCode(WidgetSettingsAccountEmailEditConfirm.this);
        }
    }

    /* compiled from: WidgetSettingsAccountEmailEditConfirm.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/models/user/MeUser;", "it", "", "invoke", "(Lcom/discord/models/user/MeUser;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.settings.account.WidgetSettingsAccountEmailEditConfirm$onViewBoundOrOnResume$1, reason: invalid class name */
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
            WidgetSettingsAccountEmailEditConfirm.access$configureUI(WidgetSettingsAccountEmailEditConfirm.this, meUser);
        }
    }

    /* compiled from: WidgetSettingsAccountEmailEditConfirm.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Ljava/lang/Void;", "it", "", NotificationCompat.CATEGORY_CALL, "(Ljava/lang/Void;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.settings.account.WidgetSettingsAccountEmailEditConfirm$resendVerificationCode$1, reason: invalid class name */
    public static final class AnonymousClass1<T> implements Action1<Void> {
        public AnonymousClass1() {
        }

        @Override // rx.functions.Action1
        public /* bridge */ /* synthetic */ void call(Void r1) {
            call2(r1);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final void call2(Void r5) {
            AppToast.g(WidgetSettingsAccountEmailEditConfirm.this.requireContext(), R.string.user_settings_account_change_email_confirm_code_sent, 0, null, 12);
        }
    }

    /* compiled from: WidgetSettingsAccountEmailEditConfirm.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/models/domain/ModelEmailChangeConfirm;", "response", "", NotificationCompat.CATEGORY_CALL, "(Lcom/discord/models/domain/ModelEmailChangeConfirm;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.settings.account.WidgetSettingsAccountEmailEditConfirm$submitVerificationCode$1, reason: invalid class name */
    public static final class AnonymousClass1<T> implements Action1<ModelEmailChangeConfirm> {
        public AnonymousClass1() {
        }

        @Override // rx.functions.Action1
        public /* bridge */ /* synthetic */ void call(ModelEmailChangeConfirm modelEmailChangeConfirm) {
            call2(modelEmailChangeConfirm);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final void call2(ModelEmailChangeConfirm modelEmailChangeConfirm) {
            WidgetUserPasswordVerify.Companion.launchUpdateAccountSettings$default(WidgetUserPasswordVerify.INSTANCE, WidgetSettingsAccountEmailEditConfirm.this.requireContext(), WidgetSettingsAccountEmailEditConfirm.access$getPasswordVerifyLauncher$p(WidgetSettingsAccountEmailEditConfirm.this), WidgetSettingsAccountEmailEditConfirm.this.getMostRecentIntent().getStringExtra(WidgetSettingsAccountEmailEditConfirm.EXTRA_EMAIL), null, null, modelEmailChangeConfirm != null ? modelEmailChangeConfirm.getToken() : null, 24, null);
        }
    }

    public WidgetSettingsAccountEmailEditConfirm() {
        super(R.layout.widget_settings_account_email_edit_confirm);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetSettingsAccountEmailEditConfirm3.INSTANCE, null, 2, null);
        this.passwordVerifyLauncher = WidgetUserPasswordVerify.INSTANCE.registerForResult(this, new WidgetSettingsAccountEmailEditConfirm4(this));
    }

    public static final /* synthetic */ void access$configureUI(WidgetSettingsAccountEmailEditConfirm widgetSettingsAccountEmailEditConfirm, MeUser meUser) {
        widgetSettingsAccountEmailEditConfirm.configureUI(meUser);
    }

    public static final /* synthetic */ ActivityResultLauncher access$getPasswordVerifyLauncher$p(WidgetSettingsAccountEmailEditConfirm widgetSettingsAccountEmailEditConfirm) {
        return widgetSettingsAccountEmailEditConfirm.passwordVerifyLauncher;
    }

    public static final /* synthetic */ void access$resendVerificationCode(WidgetSettingsAccountEmailEditConfirm widgetSettingsAccountEmailEditConfirm) {
        widgetSettingsAccountEmailEditConfirm.resendVerificationCode();
    }

    public static final /* synthetic */ void access$submitVerificationCode(WidgetSettingsAccountEmailEditConfirm widgetSettingsAccountEmailEditConfirm) {
        widgetSettingsAccountEmailEditConfirm.submitVerificationCode();
    }

    private final void configureUI(MeUser meUser) {
        TextView textView = getBinding().d;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.editAccountEmailConfirmDescription");
        FormatUtils.n(textView, R.string.user_settings_account_change_email_confirm_description, new Object[]{meUser.getEmail()}, null, 4);
        LinkifiedTextView linkifiedTextView = getBinding().e;
        Intrinsics3.checkNotNullExpressionValue(linkifiedTextView, "binding.settingsAccountConfirmResend");
        FormatUtils.m(linkifiedTextView, R.string.user_settings_account_change_email_confirm_resend, new Object[0], new AnonymousClass1());
    }

    private final WidgetSettingsAccountEmailEditConfirmBinding getBinding() {
        return (WidgetSettingsAccountEmailEditConfirmBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final void resendVerificationCode() {
        ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.INSTANCE.getApi().userEmail(), false, 1, null), this, null, 2, null).k(o.j(new AnonymousClass1(), requireContext(), null, 4));
    }

    private final void submitVerificationCode() {
        TextInputLayout textInputLayout = getBinding().c;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout, "binding.editAccountCodeWrap");
        ObservableExtensionsKt.withDimmer$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.INSTANCE.getApi().userEmailVerifyCode(new RestAPIParams.UserEmailConfirmCode(ViewExtensions.getTextOrEmpty(textInputLayout))), false, 1, null), this, null, 2, null), getBinding().f2600b, 0L, 2, null).k(o.j(new AnonymousClass1(), requireContext(), null, 4));
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        setActionBarSubtitle(R.string.user_settings);
        setActionBarTitle(R.string.user_settings_account_change_email_confirm_title);
        AppFragment.setActionBarDisplayHomeAsUpEnabled$default(this, false, 1, null);
        TextInputLayout textInputLayout = getBinding().c;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout, "binding.editAccountCodeWrap");
        ViewExtensions.setOnImeActionDone$default(textInputLayout, false, new AnonymousClass1(), 1, null);
        getBinding().f.setOnClickListener(new AnonymousClass2());
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(StoreUser.observeMe$default(StoreStream.INSTANCE.getUsers(), false, 1, null), this, null, 2, null), WidgetSettingsAccountEmailEditConfirm.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(), 62, (Object) null);
    }
}
