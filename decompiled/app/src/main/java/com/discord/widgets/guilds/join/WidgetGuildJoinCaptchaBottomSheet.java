package com.discord.widgets.guilds.join;

import android.app.Activity;
import android.content.Context;
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
import com.discord.databinding.WidgetGuildJoinCaptchaBottomSheetBinding;
import com.discord.stores.StoreNotices;
import com.discord.stores.StoreStream;
import com.discord.utilities.captcha.CaptchaErrorBody;
import com.discord.utilities.captcha.CaptchaHelper;
import com.discord.utilities.captcha.CaptchaService;
import com.discord.utilities.error.Error;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.widgets.tabs.WidgetTabsHost;
import com.google.android.material.button.MaterialButton;
import d0.LazyJVM;
import d0.t.CollectionsJVM;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import d0.z.d.Reflection2;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;

/* compiled from: WidgetGuildJoinCaptchaBottomSheet.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 %2\u00020\u0001:\u0001%B\u0007¢\u0006\u0004\b$\u0010\u0004J\u000f\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0004J\u0017\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\fJ!\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016¢\u0006\u0004\b\u0011\u0010\u0012R\u001d\u0010\u0018\u001a\u00020\u00138B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u001d\u0010\u001e\u001a\u00020\u00198B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u001d\u0010#\u001a\u00020\u001f8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b \u0010\u001b\u001a\u0004\b!\u0010\"¨\u0006&"}, d2 = {"Lcom/discord/widgets/guilds/join/WidgetGuildJoinCaptchaBottomSheet;", "Lcom/discord/app/AppBottomSheet;", "", "configureUI", "()V", "openCaptcha", "Landroid/app/Activity;", ActivityChooserModel.ATTRIBUTE_ACTIVITY, "finishIfCaptchaTokenReceived", "(Landroid/app/Activity;)V", "", "getContentViewResId", "()I", "Landroid/view/View;", "view", "Landroid/os/Bundle;", "savedInstanceState", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "Lcom/discord/databinding/WidgetGuildJoinCaptchaBottomSheetBinding;", "binding$delegate", "Lcom/discord/utilities/viewbinding/FragmentViewBindingDelegate;", "getBinding", "()Lcom/discord/databinding/WidgetGuildJoinCaptchaBottomSheetBinding;", "binding", "", "requestCode$delegate", "Lkotlin/Lazy;", "getRequestCode", "()Ljava/lang/String;", "requestCode", "Lcom/discord/utilities/captcha/CaptchaErrorBody;", "captchaErrorBody$delegate", "getCaptchaErrorBody", "()Lcom/discord/utilities/captcha/CaptchaErrorBody;", "captchaErrorBody", "<init>", "Companion", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class WidgetGuildJoinCaptchaBottomSheet extends AppBottomSheet {
    private static final String ARG_REQUEST_KEY = "INTENT_EXTRA_REQUEST_CODE";
    private static final String NOTICE_NAME = "guild captcha notice";
    private static final String RESULT_EXTRA_CAPTCHA_RQTOKEN = "INTENT_EXTRA_CAPTCHA_RQTOKEN";
    private static final String RESULT_EXTRA_CAPTCHA_TOKEN = "INTENT_EXTRA_CAPTCHA_TOKEN";

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* renamed from: captchaErrorBody$delegate, reason: from kotlin metadata */
    private final Lazy captchaErrorBody;

    /* renamed from: requestCode$delegate, reason: from kotlin metadata */
    private final Lazy requestCode;
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetGuildJoinCaptchaBottomSheet.class, "binding", "getBinding()Lcom/discord/databinding/WidgetGuildJoinCaptchaBottomSheetBinding;", 0)};

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* compiled from: WidgetGuildJoinCaptchaBottomSheet.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ)\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0007¢\u0006\u0004\b\t\u0010\nJ9\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0018\u0010\u000e\u001a\u0014\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\b0\u000b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u000f\u0010\u0010J7\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u00042\u0018\u0010\u000e\u001a\u0014\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\b0\u000b¢\u0006\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0014\u001a\u00020\u00048\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0016\u001a\u00020\u00048\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0016\u0010\u0015R\u0016\u0010\u0017\u001a\u00020\u00048\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0017\u0010\u0015R\u0016\u0010\u0018\u001a\u00020\u00048\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0018\u0010\u0015¨\u0006\u001b"}, d2 = {"Lcom/discord/widgets/guilds/join/WidgetGuildJoinCaptchaBottomSheet$Companion;", "", "Landroidx/fragment/app/FragmentManager;", "fragmentManager", "", "requestKey", "Lcom/discord/utilities/captcha/CaptchaErrorBody;", "error", "", "show", "(Landroidx/fragment/app/FragmentManager;Ljava/lang/String;Lcom/discord/utilities/captcha/CaptchaErrorBody;)V", "Lkotlin/Function2;", "Lcom/discord/app/AppFragment;", "Lcom/discord/utilities/captcha/CaptchaHelper$CaptchaPayload;", "onCaptchaPayloadReceived", "enqueue", "(Ljava/lang/String;Lkotlin/jvm/functions/Function2;Lcom/discord/utilities/captcha/CaptchaErrorBody;)V", "fragment", "registerForResult", "(Lcom/discord/app/AppFragment;Ljava/lang/String;Lkotlin/jvm/functions/Function2;)V", "ARG_REQUEST_KEY", "Ljava/lang/String;", "NOTICE_NAME", "RESULT_EXTRA_CAPTCHA_RQTOKEN", "RESULT_EXTRA_CAPTCHA_TOKEN", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public final void enqueue(String requestKey, Function2<? super AppFragment, ? super CaptchaHelper.CaptchaPayload, Unit> onCaptchaPayloadReceived, CaptchaErrorBody error) {
            Intrinsics3.checkNotNullParameter(requestKey, "requestKey");
            Intrinsics3.checkNotNullParameter(onCaptchaPayloadReceived, "onCaptchaPayloadReceived");
            StoreStream.INSTANCE.getNotices().requestToShow(new StoreNotices.Notice(WidgetGuildJoinCaptchaBottomSheet.NOTICE_NAME, null, 0L, 0, false, CollectionsJVM.listOf(Reflection2.getOrCreateKotlinClass(WidgetTabsHost.class)), 0L, false, 0L, new WidgetGuildJoinCaptchaBottomSheet$Companion$enqueue$guildCaptchaNotice$1(requestKey, error, onCaptchaPayloadReceived), 150, null));
        }

        public final void registerForResult(AppFragment fragment, String requestKey, Function2<? super AppFragment, ? super CaptchaHelper.CaptchaPayload, Unit> onCaptchaPayloadReceived) {
            Intrinsics3.checkNotNullParameter(fragment, "fragment");
            Intrinsics3.checkNotNullParameter(requestKey, "requestKey");
            Intrinsics3.checkNotNullParameter(onCaptchaPayloadReceived, "onCaptchaPayloadReceived");
            Fragment2.setFragmentResultListener(fragment, requestKey, new WidgetGuildJoinCaptchaBottomSheet$Companion$registerForResult$1(requestKey, onCaptchaPayloadReceived, fragment));
        }

        public final void show(FragmentManager fragmentManager, String requestKey, CaptchaErrorBody error) {
            Intrinsics3.checkNotNullParameter(fragmentManager, "fragmentManager");
            Intrinsics3.checkNotNullParameter(requestKey, "requestKey");
            WidgetGuildJoinCaptchaBottomSheet widgetGuildJoinCaptchaBottomSheet = new WidgetGuildJoinCaptchaBottomSheet();
            Bundle bundle = new Bundle();
            bundle.putSerializable("INTENT_EXTRA_CAPTCHA_ERROR_BODY", error);
            bundle.putString(WidgetGuildJoinCaptchaBottomSheet.ARG_REQUEST_KEY, requestKey);
            widgetGuildJoinCaptchaBottomSheet.setArguments(bundle);
            widgetGuildJoinCaptchaBottomSheet.show(fragmentManager, WidgetGuildJoinCaptchaBottomSheet.class.getName());
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetGuildJoinCaptchaBottomSheet.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.guilds.join.WidgetGuildJoinCaptchaBottomSheet$configureUI$1, reason: invalid class name */
    public static final class AnonymousClass1 implements View.OnClickListener {
        public AnonymousClass1() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetGuildJoinCaptchaBottomSheet.access$openCaptcha(WidgetGuildJoinCaptchaBottomSheet.this);
        }
    }

    /* compiled from: WidgetGuildJoinCaptchaBottomSheet.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "token", "", "invoke", "(Ljava/lang/String;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.guilds.join.WidgetGuildJoinCaptchaBottomSheet$openCaptcha$1, reason: invalid class name */
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
            AppActivity appActivity = WidgetGuildJoinCaptchaBottomSheet.this.getAppActivity();
            if (appActivity != null) {
                WidgetGuildJoinCaptchaBottomSheet.access$finishIfCaptchaTokenReceived(WidgetGuildJoinCaptchaBottomSheet.this, appActivity);
            }
        }
    }

    /* compiled from: WidgetGuildJoinCaptchaBottomSheet.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/utilities/error/Error;", "it", "", "invoke", "(Lcom/discord/utilities/error/Error;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.guilds.join.WidgetGuildJoinCaptchaBottomSheet$openCaptcha$2, reason: invalid class name */
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
                AppToast.g(WidgetGuildJoinCaptchaBottomSheet.this.getAppActivity(), failure.getErrorStringId(), 0, null, 12);
            }
        }
    }

    public WidgetGuildJoinCaptchaBottomSheet() {
        super(false, 1, null);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetGuildJoinCaptchaBottomSheet$binding$2.INSTANCE, null, 2, null);
        this.requestCode = LazyJVM.lazy(new WidgetGuildJoinCaptchaBottomSheet$requestCode$2(this));
        this.captchaErrorBody = LazyJVM.lazy(new WidgetGuildJoinCaptchaBottomSheet$captchaErrorBody$2(this));
    }

    public static final /* synthetic */ void access$finishIfCaptchaTokenReceived(WidgetGuildJoinCaptchaBottomSheet widgetGuildJoinCaptchaBottomSheet, Activity activity) {
        widgetGuildJoinCaptchaBottomSheet.finishIfCaptchaTokenReceived(activity);
    }

    public static final /* synthetic */ Bundle access$getArgumentsOrDefault$p(WidgetGuildJoinCaptchaBottomSheet widgetGuildJoinCaptchaBottomSheet) {
        return widgetGuildJoinCaptchaBottomSheet.getArgumentsOrDefault();
    }

    public static final /* synthetic */ void access$openCaptcha(WidgetGuildJoinCaptchaBottomSheet widgetGuildJoinCaptchaBottomSheet) {
        widgetGuildJoinCaptchaBottomSheet.openCaptcha();
    }

    private final void configureUI() {
        TextView textView = getBinding().d;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.guildJoinCaptchaTitle");
        FormatUtils.n(textView, R.string.guild_join_captcha_header, new Object[0], null, 4);
        TextView textView2 = getBinding().f2424b;
        Intrinsics3.checkNotNullExpressionValue(textView2, "binding.guildJoinCaptchaBody");
        FormatUtils.n(textView2, R.string.guild_join_captcha_description, new Object[0], null, 4);
        MaterialButton materialButton = getBinding().c;
        Intrinsics3.checkNotNullExpressionValue(materialButton, "binding.guildJoinCaptchaButton");
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

    private final WidgetGuildJoinCaptchaBottomSheetBinding getBinding() {
        return (WidgetGuildJoinCaptchaBottomSheetBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
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
        ObservableExtensionsKt.appSubscribe$default(captchaHelper.tryShowCaptcha(reCaptcha), WidgetGuildJoinCaptchaBottomSheet.class, (Context) null, (Function1) null, new AnonymousClass2(), (Function0) null, (Function0) null, new AnonymousClass1(), 54, (Object) null);
    }

    public static final void show(FragmentManager fragmentManager, String str, CaptchaErrorBody captchaErrorBody) {
        INSTANCE.show(fragmentManager, str, captchaErrorBody);
    }

    @Override // com.discord.app.AppBottomSheet
    public int getContentViewResId() {
        return R.layout.widget_guild_join_captcha_bottom_sheet;
    }

    @Override // com.discord.app.AppBottomSheet, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        configureUI();
    }
}
