package com.discord.widgets.captcha;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.widget.ActivityChooserModel;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import b.a.d.AppScreen2;
import b.a.d.AppToast;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.app.AppActivity;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetCaptchaBinding;
import com.discord.utilities.captcha.CaptchaErrorBody;
import com.discord.utilities.captcha.CaptchaHelper;
import com.discord.utilities.captcha.CaptchaService;
import com.discord.utilities.error.Error;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import d0.t.CollectionsJVM;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;

/* compiled from: WidgetCaptcha.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\b\u0016\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB\u0007¢\u0006\u0004\b\u0019\u0010\fJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000b\u0010\fJ)\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\r2\u0010\b\u0002\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u000fH\u0014¢\u0006\u0004\b\u0011\u0010\u0012R\u001d\u0010\u0018\u001a\u00020\u00138B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u001b"}, d2 = {"Lcom/discord/widgets/captcha/WidgetCaptcha;", "Lcom/discord/app/AppFragment;", "Landroid/app/Activity;", ActivityChooserModel.ATTRIBUTE_ACTIVITY, "", "finishIfCaptchaTokenReceived", "(Landroid/app/Activity;)V", "Landroid/view/View;", "view", "onViewBound", "(Landroid/view/View;)V", "onResume", "()V", "", "action", "", "details", "trackTransition", "(Ljava/lang/String;Ljava/util/List;)V", "Lcom/discord/databinding/WidgetCaptchaBinding;", "binding$delegate", "Lcom/discord/utilities/viewbinding/FragmentViewBindingDelegate;", "getBinding", "()Lcom/discord/databinding/WidgetCaptchaBinding;", "binding", "<init>", "Companion", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public class WidgetCaptcha extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetCaptcha.class, "binding", "getBinding()Lcom/discord/databinding/WidgetCaptchaBinding;", 0)};

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String EXTRA_CAPTCHA_ERROR_BODY = "EXTRA_CAPTCHA_ERROR_BODY";
    private static final String RESULT_EXTRA_RQTOKEN = "RESULT_EXTRA_RQTOKEN";
    private static final String RESULT_EXTRA_TOKEN = "RESULT_EXTRA_TOKEN";

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* compiled from: WidgetCaptcha.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u001f\u0010 J=\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0010\u0010\n\u001a\f\u0012\b\u0012\u00060\bj\u0002`\t0\u00072\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\u000e\u0010\u000fJ-\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010¢\u0006\u0004\b\u0012\u0010\u0013J/\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0015\u001a\u00020\u00142\u0012\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\r0\u0016¢\u0006\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001b\u001a\u00020\b8\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010\u001d\u001a\u00020\b8\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001d\u0010\u001cR\u0016\u0010\u001e\u001a\u00020\b8\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001e\u0010\u001c¨\u0006!"}, d2 = {"Lcom/discord/widgets/captcha/WidgetCaptcha$Companion;", "", "Landroid/content/Context;", "context", "Landroidx/activity/result/ActivityResultLauncher;", "Landroid/content/Intent;", "launcher", "", "", "Lcom/discord/utilities/view/validators/FieldName;", "unhandledErrors", "Lcom/discord/utilities/error/Error;", "error", "", "processErrorsForCaptcha", "(Landroid/content/Context;Landroidx/activity/result/ActivityResultLauncher;Ljava/util/List;Lcom/discord/utilities/error/Error;)V", "Lcom/discord/utilities/captcha/CaptchaErrorBody;", "captchaErrorBody", "launch", "(Landroid/content/Context;Landroidx/activity/result/ActivityResultLauncher;Lcom/discord/utilities/captcha/CaptchaErrorBody;)V", "Lcom/discord/app/AppFragment;", "fragment", "Lkotlin/Function1;", "Lcom/discord/utilities/captcha/CaptchaHelper$CaptchaPayload;", "callback", "registerForResult", "(Lcom/discord/app/AppFragment;Lkotlin/jvm/functions/Function1;)Landroidx/activity/result/ActivityResultLauncher;", WidgetCaptcha.EXTRA_CAPTCHA_ERROR_BODY, "Ljava/lang/String;", WidgetCaptcha.RESULT_EXTRA_RQTOKEN, WidgetCaptcha.RESULT_EXTRA_TOKEN, "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public final void launch(Context context, ActivityResultLauncher<Intent> launcher, CaptchaErrorBody captchaErrorBody) {
            Intrinsics3.checkNotNullParameter(context, "context");
            Intrinsics3.checkNotNullParameter(launcher, "launcher");
            Intent intent = new Intent();
            intent.putExtra(WidgetCaptcha.EXTRA_CAPTCHA_ERROR_BODY, captchaErrorBody);
            AppScreen2.g.f(context, launcher, WidgetCaptcha.class, intent);
        }

        public final void processErrorsForCaptcha(Context context, ActivityResultLauncher<Intent> launcher, List<String> unhandledErrors, Error error) {
            Intrinsics3.checkNotNullParameter(context, "context");
            Intrinsics3.checkNotNullParameter(launcher, "launcher");
            Intrinsics3.checkNotNullParameter(unhandledErrors, "unhandledErrors");
            Intrinsics3.checkNotNullParameter(error, "error");
            if (unhandledErrors.remove(CaptchaHelper.CAPTCHA_KEY)) {
                launch(context, launcher, CaptchaErrorBody.INSTANCE.createFromError(error));
                error.setShowErrorToasts(false);
            }
        }

        public final ActivityResultLauncher<Intent> registerForResult(AppFragment fragment, Function1<? super CaptchaHelper.CaptchaPayload, Unit> callback) {
            Intrinsics3.checkNotNullParameter(fragment, "fragment");
            Intrinsics3.checkNotNullParameter(callback, "callback");
            ActivityResultLauncher<Intent> activityResultLauncherRegisterForActivityResult = fragment.registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new WidgetCaptcha2(callback));
            Intrinsics3.checkNotNullExpressionValue(activityResultLauncherRegisterForActivityResult, "fragment.registerForActi…  }\n          }\n        }");
            return activityResultLauncherRegisterForActivityResult;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetCaptcha.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.captcha.WidgetCaptcha$onViewBound$1, reason: invalid class name */
    public static final class AnonymousClass1 implements View.OnClickListener {
        public final /* synthetic */ CaptchaHelper.CaptchaRequest $captchaRequest;

        /* compiled from: WidgetCaptcha.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "token", "", "invoke", "(Ljava/lang/String;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
        /* renamed from: com.discord.widgets.captcha.WidgetCaptcha$onViewBound$1$1, reason: invalid class name and collision with other inner class name */
        public static final class C02391 extends Lambda implements Function1<String, Unit> {
            public C02391() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(String str) {
                invoke2(str);
                return Unit.a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(String str) {
                CaptchaHelper.INSTANCE.setCaptchaToken(str);
                AppActivity appActivity = WidgetCaptcha.this.getAppActivity();
                if (appActivity != null) {
                    WidgetCaptcha.access$finishIfCaptchaTokenReceived(WidgetCaptcha.this, appActivity);
                }
            }
        }

        /* compiled from: WidgetCaptcha.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/utilities/error/Error;", "it", "", "invoke", "(Lcom/discord/utilities/error/Error;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
        /* renamed from: com.discord.widgets.captcha.WidgetCaptcha$onViewBound$1$2, reason: invalid class name */
        public static final class AnonymousClass2 extends Lambda implements Function1<Error, Unit> {
            public AnonymousClass2() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Error error) {
                invoke2(error);
                return Unit.a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Error error) {
                Intrinsics3.checkNotNullParameter(error, "it");
                WidgetCaptcha.trackTransition$default(WidgetCaptcha.this, "submitted", null, 2, null);
                WidgetCaptcha.this.trackTransition("response_error", CollectionsJVM.listOf("captcha"));
                Throwable throwable = error.getThrowable();
                if (!(throwable instanceof CaptchaHelper.Failure)) {
                    throwable = null;
                }
                CaptchaHelper.Failure failure = (CaptchaHelper.Failure) throwable;
                if (failure != null) {
                    AppToast.g(WidgetCaptcha.this.getAppActivity(), failure.getErrorStringId(), 0, null, 12);
                }
            }
        }

        public AnonymousClass1(CaptchaHelper.CaptchaRequest captchaRequest) {
            this.$captchaRequest = captchaRequest;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            ObservableExtensionsKt.appSubscribe$default(CaptchaHelper.INSTANCE.tryShowCaptcha(this.$captchaRequest), WidgetCaptcha.this.getClass(), (Context) null, (Function1) null, new AnonymousClass2(), (Function0) null, (Function0) null, new C02391(), 54, (Object) null);
        }
    }

    /* compiled from: WidgetCaptcha.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.captcha.WidgetCaptcha$onViewBound$2, reason: invalid class name */
    public static final class AnonymousClass2 implements View.OnClickListener {

        /* compiled from: WidgetCaptcha.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
        /* renamed from: com.discord.widgets.captcha.WidgetCaptcha$onViewBound$2$1, reason: invalid class name */
        public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
            public AnonymousClass1() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                FragmentActivity activity = WidgetCaptcha.this.getActivity();
                if (activity != null) {
                    activity.finish();
                }
            }
        }

        public AnonymousClass2() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            CaptchaHelper.INSTANCE.showCaptchaHelpDialog(WidgetCaptcha.this.getAppActivity(), new AnonymousClass1());
        }
    }

    public WidgetCaptcha() {
        super(R.layout.widget_captcha);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetCaptcha3.INSTANCE, null, 2, null);
    }

    public static final /* synthetic */ void access$finishIfCaptchaTokenReceived(WidgetCaptcha widgetCaptcha, Activity activity) {
        widgetCaptcha.finishIfCaptchaTokenReceived(activity);
    }

    private final void finishIfCaptchaTokenReceived(Activity activity) {
        CaptchaHelper captchaHelper = CaptchaHelper.INSTANCE;
        String captchaToken = captchaHelper.getCaptchaToken();
        if (captchaToken != null) {
            String captchaRqtoken = captchaHelper.getCaptchaRqtoken();
            captchaHelper.setCaptchaToken(null);
            captchaHelper.setCaptchaRqtoken(null);
            trackTransition$default(this, "submitted", null, 2, null);
            Intent intent = new Intent();
            intent.putExtra(RESULT_EXTRA_TOKEN, captchaToken);
            intent.putExtra(RESULT_EXTRA_RQTOKEN, captchaRqtoken);
            activity.setResult(-1, intent);
            activity.finish();
        }
    }

    private final WidgetCaptchaBinding getBinding() {
        return (WidgetCaptchaBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void trackTransition$default(WidgetCaptcha widgetCaptcha, String str, List list, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: trackTransition");
        }
        if ((i & 2) != 0) {
            list = null;
        }
        widgetCaptcha.trackTransition(str, list);
    }

    @Override // com.discord.app.AppFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        finishIfCaptchaTokenReceived(requireAppActivity());
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        CaptchaHelper.CaptchaRequest reCaptcha;
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        Serializable serializableExtra = getMostRecentIntent().getSerializableExtra(EXTRA_CAPTCHA_ERROR_BODY);
        if (!(serializableExtra instanceof CaptchaErrorBody)) {
            serializableExtra = null;
        }
        CaptchaErrorBody captchaErrorBody = (CaptchaErrorBody) serializableExtra;
        String captchaSitekey = captchaErrorBody != null ? captchaErrorBody.getCaptchaSitekey() : null;
        CaptchaService captchaService = captchaErrorBody != null ? captchaErrorBody.getCaptchaService() : null;
        String captchaRqdata = captchaErrorBody != null ? captchaErrorBody.getCaptchaRqdata() : null;
        CaptchaHelper.INSTANCE.setCaptchaRqtoken(captchaErrorBody != null ? captchaErrorBody.getCaptchaRqtoken() : null);
        if (captchaSitekey == null || captchaService != CaptchaService.HCAPTCHA) {
            FragmentActivity fragmentActivityRequireActivity = requireActivity();
            Intrinsics3.checkNotNullExpressionValue(fragmentActivityRequireActivity, "requireActivity()");
            reCaptcha = new CaptchaHelper.CaptchaRequest.ReCaptcha(fragmentActivityRequireActivity);
        } else {
            FragmentActivity fragmentActivityRequireActivity2 = requireActivity();
            Intrinsics3.checkNotNullExpressionValue(fragmentActivityRequireActivity2, "requireActivity()");
            reCaptcha = new CaptchaHelper.CaptchaRequest.HCaptcha(captchaSitekey, fragmentActivityRequireActivity2, captchaRqdata);
        }
        String string = reCaptcha instanceof CaptchaHelper.CaptchaRequest.HCaptcha ? getString(R.string.verify_by_hcaptcha) : getString(R.string.verify_by_recaptcha);
        Intrinsics3.checkNotNullExpressionValue(string, "when (captchaRequest) {\n…erify_by_recaptcha)\n    }");
        getBinding().d.setTitle(string);
        trackTransition$default(this, "viewed", null, 2, null);
        getBinding().c.setOnClickListener(new AnonymousClass1(reCaptcha));
        getBinding().f2250b.setOnClickListener(new AnonymousClass2());
    }

    public void trackTransition(String action, List<String> details) {
        Intrinsics3.checkNotNullParameter(action, "action");
    }
}
