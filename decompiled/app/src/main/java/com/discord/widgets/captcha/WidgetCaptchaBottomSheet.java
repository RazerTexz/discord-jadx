package com.discord.widgets.captcha;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.widget.ActivityChooserModel;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.Fragment2;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import b.a.d.AppToast;
import b.a.k.FormatUtils;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.app.AppActivity;
import com.discord.app.AppBottomSheet;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetCaptchaBottomSheetBinding;
import com.discord.stores.StoreNotices;
import com.discord.stores.StoreStream;
import com.discord.utilities.captcha.CaptchaErrorBody;
import com.discord.utilities.captcha.CaptchaHelper;
import com.discord.utilities.captcha.CaptchaService;
import com.discord.utilities.error.Error;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.widgets.share.WidgetIncomingShare;
import com.discord.widgets.tabs.WidgetTabsHost;
import com.google.android.material.button.MaterialButton;
import d0.LazyJVM;
import d0.e0.KClass;
import d0.t.Collections2;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import d0.z.d.Reflection2;
import java.util.List;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;

/* compiled from: WidgetCaptchaBottomSheet.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 /2\u00020\u0001:\u0001/B\u0007¢\u0006\u0004\b.\u0010\u0004J\u000f\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0004J\u0017\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\fJ!\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0015\u0010\u0016R\u001d\u0010\u001c\u001a\u00020\u00178B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u0016\u0010\u001e\u001a\u00020\u001d8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u001d\u0010$\u001a\u00020 8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b!\u0010\u0019\u001a\u0004\b\"\u0010#R\u001e\u0010&\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010%8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b&\u0010'R\u001d\u0010-\u001a\u00020(8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,¨\u00060"}, d2 = {"Lcom/discord/widgets/captcha/WidgetCaptchaBottomSheet;", "Lcom/discord/app/AppBottomSheet;", "", "configureUI", "()V", "openCaptcha", "Landroid/app/Activity;", ActivityChooserModel.ATTRIBUTE_ACTIVITY, "finishIfCaptchaTokenReceived", "(Landroid/app/Activity;)V", "", "getContentViewResId", "()I", "Landroid/view/View;", "view", "Landroid/os/Bundle;", "savedInstanceState", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "Landroid/content/DialogInterface;", "dialog", "onDismiss", "(Landroid/content/DialogInterface;)V", "Lcom/discord/utilities/captcha/CaptchaErrorBody;", "captchaErrorBody$delegate", "Lkotlin/Lazy;", "getCaptchaErrorBody", "()Lcom/discord/utilities/captcha/CaptchaErrorBody;", "captchaErrorBody", "", "captchaPassed", "Z", "", "requestCode$delegate", "getRequestCode", "()Ljava/lang/String;", "requestCode", "Lkotlin/Function0;", "onCaptchaAttemptFailed", "Lkotlin/jvm/functions/Function0;", "Lcom/discord/databinding/WidgetCaptchaBottomSheetBinding;", "binding$delegate", "Lcom/discord/utilities/viewbinding/FragmentViewBindingDelegate;", "getBinding", "()Lcom/discord/databinding/WidgetCaptchaBottomSheetBinding;", "binding", "<init>", "Companion", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class WidgetCaptchaBottomSheet extends AppBottomSheet {
    private static final String ARG_REQUEST_KEY = "INTENT_EXTRA_REQUEST_CODE";
    private static final String NOTICE_NAME = "captcha notice";
    private static final String RESULT_EXTRA_CAPTCHA_RQTOKEN = "INTENT_EXTRA_CAPTCHA_RQTOKEN";
    private static final String RESULT_EXTRA_CAPTCHA_TOKEN = "INTENT_EXTRA_CAPTCHA_TOKEN";

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* renamed from: captchaErrorBody$delegate, reason: from kotlin metadata */
    private final Lazy captchaErrorBody;
    private boolean captchaPassed;
    private Function0<Unit> onCaptchaAttemptFailed;

    /* renamed from: requestCode$delegate, reason: from kotlin metadata */
    private final Lazy requestCode;
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetCaptchaBottomSheet.class, "binding", "getBinding()Lcom/discord/databinding/WidgetCaptchaBottomSheetBinding;", 0)};

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final List<KClass<? extends AppFragment>> resolvableFragments = Collections2.listOf((Object[]) new KClass[]{Reflection2.getOrCreateKotlinClass(WidgetTabsHost.class), Reflection2.getOrCreateKotlinClass(WidgetIncomingShare.class)});

    /* compiled from: WidgetCaptchaBottomSheet.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u001f\u0010 J9\u0010\u000b\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b¢\u0006\u0004\b\u000b\u0010\fJK\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\u0018\u0010\u0010\u001a\u0014\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\t0\r2\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0011\u0010\u0012J7\u0010\u0014\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u00042\u0018\u0010\u0010\u001a\u0014\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\t0\r¢\u0006\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0016\u001a\u00020\u00048\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u0018\u001a\u00020\u00048\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0018\u0010\u0017R\u0016\u0010\u0019\u001a\u00020\u00048\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0019\u0010\u0017R\u0016\u0010\u001a\u001a\u00020\u00048\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001a\u0010\u0017R$\u0010\u001d\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u000e0\u001c0\u001b8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001e¨\u0006!"}, d2 = {"Lcom/discord/widgets/captcha/WidgetCaptchaBottomSheet$Companion;", "", "Landroidx/fragment/app/FragmentManager;", "fragmentManager", "", "requestKey", "Lcom/discord/utilities/captcha/CaptchaErrorBody;", "error", "Lkotlin/Function0;", "", "onCaptchaAttemptFailed", "show", "(Landroidx/fragment/app/FragmentManager;Ljava/lang/String;Lcom/discord/utilities/captcha/CaptchaErrorBody;Lkotlin/jvm/functions/Function0;)V", "Lkotlin/Function2;", "Lcom/discord/app/AppFragment;", "Lcom/discord/utilities/captcha/CaptchaHelper$CaptchaPayload;", "onCaptchaPayloadReceived", "enqueue", "(Ljava/lang/String;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function0;Lcom/discord/utilities/captcha/CaptchaErrorBody;)V", "fragment", "registerForResult", "(Lcom/discord/app/AppFragment;Ljava/lang/String;Lkotlin/jvm/functions/Function2;)V", "ARG_REQUEST_KEY", "Ljava/lang/String;", "NOTICE_NAME", "RESULT_EXTRA_CAPTCHA_RQTOKEN", "RESULT_EXTRA_CAPTCHA_TOKEN", "", "Ld0/e0/c;", "resolvableFragments", "Ljava/util/List;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void enqueue$default(Companion companion, String str, Function2 function2, Function0 function0, CaptchaErrorBody captchaErrorBody, int i, Object obj) {
            if ((i & 4) != 0) {
                function0 = null;
            }
            companion.enqueue(str, function2, function0, captchaErrorBody);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void show$default(Companion companion, FragmentManager fragmentManager, String str, CaptchaErrorBody captchaErrorBody, Function0 function0, int i, Object obj) {
            if ((i & 8) != 0) {
                function0 = null;
            }
            companion.show(fragmentManager, str, captchaErrorBody, function0);
        }

        public final void enqueue(String requestKey, Function2<? super AppFragment, ? super CaptchaHelper.CaptchaPayload, Unit> onCaptchaPayloadReceived, Function0<Unit> onCaptchaAttemptFailed, CaptchaErrorBody error) {
            Intrinsics3.checkNotNullParameter(requestKey, "requestKey");
            Intrinsics3.checkNotNullParameter(onCaptchaPayloadReceived, "onCaptchaPayloadReceived");
            StoreStream.INSTANCE.getNotices().requestToShow(new StoreNotices.Notice(WidgetCaptchaBottomSheet.NOTICE_NAME, null, 0L, 0, false, WidgetCaptchaBottomSheet.access$getResolvableFragments$cp(), 0L, false, 0L, new WidgetCaptchaBottomSheet2(requestKey, error, onCaptchaAttemptFailed, onCaptchaPayloadReceived), 150, null));
        }

        public final void registerForResult(AppFragment fragment, String requestKey, Function2<? super AppFragment, ? super CaptchaHelper.CaptchaPayload, Unit> onCaptchaPayloadReceived) {
            Intrinsics3.checkNotNullParameter(fragment, "fragment");
            Intrinsics3.checkNotNullParameter(requestKey, "requestKey");
            Intrinsics3.checkNotNullParameter(onCaptchaPayloadReceived, "onCaptchaPayloadReceived");
            Fragment2.setFragmentResultListener(fragment, requestKey, new WidgetCaptchaBottomSheet3(requestKey, onCaptchaPayloadReceived, fragment));
        }

        public final void show(FragmentManager fragmentManager, String requestKey, CaptchaErrorBody error, Function0<Unit> onCaptchaAttemptFailed) {
            Intrinsics3.checkNotNullParameter(fragmentManager, "fragmentManager");
            Intrinsics3.checkNotNullParameter(requestKey, "requestKey");
            WidgetCaptchaBottomSheet widgetCaptchaBottomSheet = new WidgetCaptchaBottomSheet();
            Bundle bundle = new Bundle();
            bundle.putSerializable("INTENT_EXTRA_CAPTCHA_ERROR_BODY", error);
            bundle.putString(WidgetCaptchaBottomSheet.ARG_REQUEST_KEY, requestKey);
            widgetCaptchaBottomSheet.setArguments(bundle);
            WidgetCaptchaBottomSheet.access$setOnCaptchaAttemptFailed$p(widgetCaptchaBottomSheet, onCaptchaAttemptFailed);
            widgetCaptchaBottomSheet.show(fragmentManager, WidgetCaptchaBottomSheet.class.getName());
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetCaptchaBottomSheet.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.captcha.WidgetCaptchaBottomSheet$configureUI$1, reason: invalid class name */
    public static final class AnonymousClass1 implements View.OnClickListener {
        public AnonymousClass1() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetCaptchaBottomSheet.access$openCaptcha(WidgetCaptchaBottomSheet.this);
        }
    }

    /* compiled from: WidgetCaptchaBottomSheet.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "token", "", "invoke", "(Ljava/lang/String;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.captcha.WidgetCaptchaBottomSheet$openCaptcha$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<String, Unit> {
        public AnonymousClass1() {
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
            WidgetCaptchaBottomSheet.access$setCaptchaPassed$p(WidgetCaptchaBottomSheet.this, true);
            AppActivity appActivity = WidgetCaptchaBottomSheet.this.getAppActivity();
            if (appActivity != null) {
                WidgetCaptchaBottomSheet.access$finishIfCaptchaTokenReceived(WidgetCaptchaBottomSheet.this, appActivity);
            }
        }
    }

    /* compiled from: WidgetCaptchaBottomSheet.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/utilities/error/Error;", "it", "", "invoke", "(Lcom/discord/utilities/error/Error;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.captcha.WidgetCaptchaBottomSheet$openCaptcha$2, reason: invalid class name */
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
            Throwable throwable = error.getThrowable();
            if (!(throwable instanceof CaptchaHelper.Failure)) {
                throwable = null;
            }
            CaptchaHelper.Failure failure = (CaptchaHelper.Failure) throwable;
            if (failure != null) {
                AppToast.g(WidgetCaptchaBottomSheet.this.getAppActivity(), failure.getErrorStringId(), 0, null, 12);
            }
        }
    }

    public WidgetCaptchaBottomSheet() {
        super(false, 1, null);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetCaptchaBottomSheet4.INSTANCE, null, 2, null);
        this.requestCode = LazyJVM.lazy(new WidgetCaptchaBottomSheet6(this));
        this.captchaErrorBody = LazyJVM.lazy(new WidgetCaptchaBottomSheet5(this));
    }

    public static final /* synthetic */ void access$finishIfCaptchaTokenReceived(WidgetCaptchaBottomSheet widgetCaptchaBottomSheet, Activity activity) {
        widgetCaptchaBottomSheet.finishIfCaptchaTokenReceived(activity);
    }

    public static final /* synthetic */ Bundle access$getArgumentsOrDefault$p(WidgetCaptchaBottomSheet widgetCaptchaBottomSheet) {
        return widgetCaptchaBottomSheet.getArgumentsOrDefault();
    }

    public static final /* synthetic */ boolean access$getCaptchaPassed$p(WidgetCaptchaBottomSheet widgetCaptchaBottomSheet) {
        return widgetCaptchaBottomSheet.captchaPassed;
    }

    public static final /* synthetic */ Function0 access$getOnCaptchaAttemptFailed$p(WidgetCaptchaBottomSheet widgetCaptchaBottomSheet) {
        return widgetCaptchaBottomSheet.onCaptchaAttemptFailed;
    }

    public static final /* synthetic */ List access$getResolvableFragments$cp() {
        return resolvableFragments;
    }

    public static final /* synthetic */ void access$openCaptcha(WidgetCaptchaBottomSheet widgetCaptchaBottomSheet) {
        widgetCaptchaBottomSheet.openCaptcha();
    }

    public static final /* synthetic */ void access$setCaptchaPassed$p(WidgetCaptchaBottomSheet widgetCaptchaBottomSheet, boolean z2) {
        widgetCaptchaBottomSheet.captchaPassed = z2;
    }

    public static final /* synthetic */ void access$setOnCaptchaAttemptFailed$p(WidgetCaptchaBottomSheet widgetCaptchaBottomSheet, Function0 function0) {
        widgetCaptchaBottomSheet.onCaptchaAttemptFailed = function0;
    }

    private final void configureUI() {
        TextView textView = getBinding().d;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.captchaTitle");
        FormatUtils.n(textView, R.string.generic_captcha_header, new Object[0], null, 4);
        TextView textView2 = getBinding().f2251b;
        Intrinsics3.checkNotNullExpressionValue(textView2, "binding.captchaBody");
        FormatUtils.n(textView2, R.string.generic_captcha_description, new Object[0], null, 4);
        MaterialButton materialButton = getBinding().c;
        Intrinsics3.checkNotNullExpressionValue(materialButton, "binding.captchaButton");
        FormatUtils.n(materialButton, R.string.confirm, new Object[0], null, 4);
        getBinding().c.setOnClickListener(new AnonymousClass1());
    }

    private final void finishIfCaptchaTokenReceived(Activity activity) {
        CaptchaHelper captchaHelper = CaptchaHelper.INSTANCE;
        String captchaToken = captchaHelper.getCaptchaToken();
        if (captchaToken != null) {
            String captchaRqtoken = captchaHelper.getCaptchaRqtoken();
            captchaHelper.setCaptchaToken(null);
            captchaHelper.setCaptchaRqtoken(null);
            String requestCode = getRequestCode();
            Bundle bundle = new Bundle();
            bundle.putString(RESULT_EXTRA_CAPTCHA_TOKEN, captchaToken);
            bundle.putString(RESULT_EXTRA_CAPTCHA_RQTOKEN, captchaRqtoken);
            Fragment2.setFragmentResult(this, requestCode, bundle);
            dismiss();
        }
    }

    private final WidgetCaptchaBottomSheetBinding getBinding() {
        return (WidgetCaptchaBottomSheetBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final CaptchaErrorBody getCaptchaErrorBody() {
        return (CaptchaErrorBody) this.captchaErrorBody.getValue();
    }

    private final String getRequestCode() {
        return (String) this.requestCode.getValue();
    }

    private final void openCaptcha() {
        CaptchaHelper.CaptchaRequest reCaptcha;
        String captchaSitekey = getCaptchaErrorBody().getCaptchaSitekey();
        CaptchaService captchaService = getCaptchaErrorBody().getCaptchaService();
        String captchaRqdata = getCaptchaErrorBody().getCaptchaRqdata();
        String captchaRqtoken = getCaptchaErrorBody().getCaptchaRqtoken();
        CaptchaHelper captchaHelper = CaptchaHelper.INSTANCE;
        captchaHelper.setCaptchaRqtoken(captchaRqtoken);
        if (captchaSitekey == null || captchaService != CaptchaService.HCAPTCHA) {
            FragmentActivity fragmentActivityRequireActivity = requireActivity();
            Intrinsics3.checkNotNullExpressionValue(fragmentActivityRequireActivity, "requireActivity()");
            reCaptcha = new CaptchaHelper.CaptchaRequest.ReCaptcha(fragmentActivityRequireActivity);
        } else {
            FragmentActivity fragmentActivityRequireActivity2 = requireActivity();
            Intrinsics3.checkNotNullExpressionValue(fragmentActivityRequireActivity2, "requireActivity()");
            reCaptcha = new CaptchaHelper.CaptchaRequest.HCaptcha(captchaSitekey, fragmentActivityRequireActivity2, captchaRqdata);
        }
        ObservableExtensionsKt.appSubscribe$default(captchaHelper.tryShowCaptcha(reCaptcha), WidgetCaptchaBottomSheet.class, (Context) null, (Function1) null, new AnonymousClass2(), (Function0) null, (Function0) null, new AnonymousClass1(), 54, (Object) null);
    }

    @Override // com.discord.app.AppBottomSheet
    public int getContentViewResId() {
        return R.layout.widget_captcha_bottom_sheet;
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialog) {
        Function0<Unit> function0;
        Intrinsics3.checkNotNullParameter(dialog, "dialog");
        super.onDismiss(dialog);
        if (this.captchaPassed || (function0 = this.onCaptchaAttemptFailed) == null) {
            return;
        }
        function0.invoke();
    }

    @Override // com.discord.app.AppBottomSheet, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        configureUI();
    }
}
