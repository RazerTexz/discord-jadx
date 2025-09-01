package com.discord.widgets.auth;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.core.view.PointerIconCompat;
import b.a.d.AppToast;
import b.a.r.SamsungConnect;
import b.a.r.SamsungConnect2;
import b.a.r.SamsungConnectActivity2;
import b.d.b.a.outline;
import b.i.a.f.e.o.f;
import com.discord.R;
import com.discord.app.AppActivity;
import com.discord.app.AppLog;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.domain.ModelUserSettings;
import com.discord.restapi.RestAPIParams;
import com.discord.samsung.SamsungConnect3;
import com.discord.samsung.SamsungConnectActivity;
import com.discord.utilities.captcha.CaptchaErrorBody;
import com.discord.utilities.captcha.CaptchaHelper;
import com.discord.utilities.error.Error;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.widgets.auth.WidgetOauth2Authorize;
import d0.Result3;
import d0.g0.Strings4;
import d0.g0._Strings;
import d0.w.h.Intrinsics2;
import d0.w.i.a.ContinuationImpl3;
import d0.w.i.a.ContinuationImpl6;
import d0.w.i.a.DebugMetadata;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import f0.OkHttpClient;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import org.objectweb.asm.Opcodes;
import rx.Observable;
import s.a.CoroutineScope2;
import s.a.Dispatchers;
import s.a.MainCoroutineDispatcher;
import s.a.a.MainDispatchers;

/* compiled from: WidgetOauth2AuthorizeSamsung.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 +2\u00020\u0001:\u0001+B\u0007¢\u0006\u0004\b)\u0010*J\u001f\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J!\u0010\n\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00022\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000e\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0011\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0014\u001a\u00020\u0013H\u0014¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u0018H\u0014¢\u0006\u0004\b\u001a\u0010\u001bJ#\u0010\u001d\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0082@ø\u0001\u0000¢\u0006\u0004\b\u001d\u0010\u001eR\"\u0010!\u001a\b\u0012\u0004\u0012\u00020 0\u001f8\u0014@\u0014X\u0094\u0004¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$R$\u0010&\u001a\u0010\u0012\f\u0012\n %*\u0004\u0018\u00010 0 0\u001f8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b&\u0010\"R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0004\u0010'R\u001c\u0010(\u001a\b\u0012\u0004\u0012\u00020 0\u001f8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b(\u0010\"\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006,"}, d2 = {"Lcom/discord/widgets/auth/WidgetOauth2AuthorizeSamsung;", "Lcom/discord/widgets/auth/WidgetOauth2Authorize;", "", "saUrl", "samsungAuthCode", "", "startSamsungAccountLink", "(Ljava/lang/String;Ljava/lang/String;)V", "Lcom/discord/utilities/captcha/CaptchaHelper$CaptchaPayload;", "captchaPayload", "authorizeForSamsung", "(Ljava/lang/String;Lcom/discord/utilities/captcha/CaptchaHelper$CaptchaPayload;)V", "Lcom/discord/samsung/SamsungConnectActivity$Result$Failure;", "result", "handleConnectActivityFailure", "(Lcom/discord/samsung/SamsungConnectActivity$Result$Failure;)V", "Lcom/discord/samsung/SamsungConnectActivity$Result$Success;", "handleConnectActivitySuccess", "(Lcom/discord/samsung/SamsungConnectActivity$Result$Success;)V", "Landroid/net/Uri;", "requestUrl", "Lcom/discord/widgets/auth/WidgetOauth2Authorize$OAuth2Authorize;", "createOauthAuthorize", "(Landroid/net/Uri;)Lcom/discord/widgets/auth/WidgetOauth2Authorize$OAuth2Authorize;", "Lcom/discord/restapi/RestAPIParams$OAuth2Authorize$ResponseGet;", "data", "configureUI", "(Lcom/discord/restapi/RestAPIParams$OAuth2Authorize$ResponseGet;)V", ModelAuditLogEntry.CHANGE_KEY_LOCATION, "samsungCallbackHandshake", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Landroidx/activity/result/ActivityResultLauncher;", "Landroid/content/Intent;", "captchaLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "getCaptchaLauncher", "()Landroidx/activity/result/ActivityResultLauncher;", "kotlin.jvm.PlatformType", "samsungDisclaimerLauncher", "Ljava/lang/String;", "samsungConnectLauncher", "<init>", "()V", "Companion", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class WidgetOauth2AuthorizeSamsung extends WidgetOauth2Authorize {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final int REQ_CODE_SAMSUNG = 5459;
    private final ActivityResultLauncher<Intent> captchaLauncher;
    private String samsungAuthCode;
    private final ActivityResultLauncher<Intent> samsungConnectLauncher;
    private final ActivityResultLauncher<Intent> samsungDisclaimerLauncher;

    /* compiled from: WidgetOauth2AuthorizeSamsung.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J#\u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0002¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u000b\u0010\fJ!\u0010\u0011\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u000f*\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0002¢\u0006\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0014\u001a\u00020\u00138\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015¨\u0006\u0018"}, d2 = {"Lcom/discord/widgets/auth/WidgetOauth2AuthorizeSamsung$Companion;", "", "", "message", "", "logI", "(Ljava/lang/String;)V", "", "throwable", "logW", "(Ljava/lang/String;Ljava/lang/Throwable;)V", "createSAStateId", "()Ljava/lang/String;", "Lcom/discord/widgets/auth/WidgetOauth2Authorize$OAuth2Authorize;", "accountUri", "Lrx/Observable;", "Ljava/lang/Void;", "getForSamsung", "(Lcom/discord/widgets/auth/WidgetOauth2Authorize$OAuth2Authorize;Ljava/lang/String;)Lrx/Observable;", "", "REQ_CODE_SAMSUNG", "I", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public static final /* synthetic */ String access$createSAStateId(Companion companion) {
            return companion.createSAStateId();
        }

        public static final /* synthetic */ void access$logI(Companion companion, String str) {
            companion.logI(str);
        }

        private final String createSAStateId() {
            StringBuilder sbU = outline.U("SA");
            sbU.append(UUID.randomUUID());
            return _Strings.take(sbU.toString(), 115);
        }

        private final void logI(String message) {
            AppLog appLog = AppLog.g;
            appLog.c(message, "Samsung", null, new WidgetOauth2AuthorizeSamsung2(appLog));
        }

        private final void logW(String message, Throwable throwable) {
            AppLog appLog = AppLog.g;
            appLog.c(message, "Samsung", throwable, new WidgetOauth2AuthorizeSamsung3(appLog));
        }

        public static /* synthetic */ void logW$default(Companion companion, String str, Throwable th, int i, Object obj) {
            if ((i & 2) != 0) {
                th = null;
            }
            companion.logW(str, th);
        }

        public final Observable<Void> getForSamsung(WidgetOauth2Authorize.OAuth2Authorize oAuth2Authorize, String str) {
            Intrinsics3.checkNotNullParameter(oAuth2Authorize, "$this$getForSamsung");
            Intrinsics3.checkNotNullParameter(str, "accountUri");
            return RestAPI.INSTANCE.getApi().getOauth2SamsungAuthorize(String.valueOf(oAuth2Authorize.getClientId()), oAuth2Authorize.getState(), oAuth2Authorize.getResponseType(), str, oAuth2Authorize.getPrompt(), oAuth2Authorize.getScope());
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetOauth2AuthorizeSamsung.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/utilities/error/Error;", "error", "", "invoke", "(Lcom/discord/utilities/error/Error;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.auth.WidgetOauth2AuthorizeSamsung$authorizeForSamsung$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<Error, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Error error) {
            invoke2(error);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Error error) {
            Intrinsics3.checkNotNullParameter(error, "error");
            Companion.access$logI(WidgetOauth2AuthorizeSamsung.INSTANCE, "POST /authorize: error " + error);
            String bodyText = error.getBodyText();
            if (bodyText == null || !Strings4.contains$default((CharSequence) bodyText, (CharSequence) CaptchaHelper.CAPTCHA_KEY, false, 2, (Object) null)) {
                return;
            }
            WidgetAuthCaptcha.INSTANCE.launch(WidgetOauth2AuthorizeSamsung.this.requireContext(), WidgetOauth2AuthorizeSamsung.this.getCaptchaLauncher(), CaptchaErrorBody.INSTANCE.createFromError(error));
        }
    }

    /* compiled from: WidgetOauth2AuthorizeSamsung.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/restapi/RestAPIParams$OAuth2Authorize$ResponsePost;", "it", "", "invoke", "(Lcom/discord/restapi/RestAPIParams$OAuth2Authorize$ResponsePost;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.auth.WidgetOauth2AuthorizeSamsung$authorizeForSamsung$2, reason: invalid class name */
    public static final class AnonymousClass2 extends Lambda implements Function1<RestAPIParams.OAuth2Authorize.ResponsePost, Unit> {
        public final /* synthetic */ String $samsungAuthCode;

        /* compiled from: WidgetOauth2AuthorizeSamsung.kt */
        @DebugMetadata(c = "com.discord.widgets.auth.WidgetOauth2AuthorizeSamsung$authorizeForSamsung$2$1", f = "WidgetOauth2AuthorizeSamsung.kt", l = {157}, m = "invokeSuspend")
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\u008a@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
        /* renamed from: com.discord.widgets.auth.WidgetOauth2AuthorizeSamsung$authorizeForSamsung$2$1, reason: invalid class name */
        public static final class AnonymousClass1 extends ContinuationImpl6 implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            public final /* synthetic */ RestAPIParams.OAuth2Authorize.ResponsePost $it;
            public int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(RestAPIParams.OAuth2Authorize.ResponsePost responsePost, Continuation continuation) {
                super(2, continuation);
                this.$it = responsePost;
            }

            @Override // d0.w.i.a.ContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                Intrinsics3.checkNotNullParameter(continuation, "completion");
                return AnonymousClass2.this.new AnonymousClass1(this.$it, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.a);
            }

            @Override // d0.w.i.a.ContinuationImpl
            public final Object invokeSuspend(Object obj) {
                Object coroutine_suspended = Intrinsics2.getCOROUTINE_SUSPENDED();
                int i = this.label;
                if (i == 0) {
                    Result3.throwOnFailure(obj);
                    WidgetOauth2AuthorizeSamsung widgetOauth2AuthorizeSamsung = WidgetOauth2AuthorizeSamsung.this;
                    String location = this.$it.getLocation();
                    String str = AnonymousClass2.this.$samsungAuthCode;
                    this.label = 1;
                    if (widgetOauth2AuthorizeSamsung.samsungCallbackHandshake(location, str, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    Result3.throwOnFailure(obj);
                }
                return Unit.a;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(String str) {
            super(1);
            this.$samsungAuthCode = str;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(RestAPIParams.OAuth2Authorize.ResponsePost responsePost) {
            invoke2(responsePost);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(RestAPIParams.OAuth2Authorize.ResponsePost responsePost) {
            Intrinsics3.checkNotNullParameter(responsePost, "it");
            Companion.access$logI(WidgetOauth2AuthorizeSamsung.INSTANCE, "POST /authorize success");
            f.H0(CoroutineScope2.j, Dispatchers.f3842b, null, new AnonymousClass1(responsePost, null), 2, null);
        }
    }

    /* compiled from: WidgetOauth2AuthorizeSamsung.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.auth.WidgetOauth2AuthorizeSamsung$configureUI$1, reason: invalid class name */
    public static final class AnonymousClass1 implements View.OnClickListener {
        public AnonymousClass1() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            Intrinsics3.checkNotNullExpressionValue(view, "it");
            Context context = view.getContext();
            Intrinsics3.checkNotNullExpressionValue(context, "it.context");
            Intrinsics3.checkNotNullParameter(context, "context");
            Account[] accountsByType = AccountManager.get(context).getAccountsByType("com.osp.app.signin");
            Intrinsics3.checkNotNullExpressionValue(accountsByType, "accountManager.getAccoun…yType(SA_ACCOUNT_SERVICE)");
            if (!(!(accountsByType.length == 0))) {
                Companion.access$logI(WidgetOauth2AuthorizeSamsung.INSTANCE, "Not Logged into Samsung Account");
            }
            try {
                ActivityResultLauncher activityResultLauncherAccess$getSamsungDisclaimerLauncher$p = WidgetOauth2AuthorizeSamsung.access$getSamsungDisclaimerLauncher$p(WidgetOauth2AuthorizeSamsung.this);
                Intent intent = new Intent("com.msc.action.samsungaccount.REQUEST_NEW_THIRD_PARTY_INTEGRATION_WITH_SAMSUNG_ACCOUNT");
                intent.putExtra("client_id", "97t47j218f");
                intent.putExtra("progress_theme", ModelUserSettings.THEME_DARK);
                activityResultLauncherAccess$getSamsungDisclaimerLauncher$p.launch(intent);
            } catch (ActivityNotFoundException unused) {
                AppActivity appActivity = WidgetOauth2AuthorizeSamsung.this.getAppActivity();
                if (appActivity != null) {
                    appActivity.finish();
                }
            }
        }
    }

    /* compiled from: WidgetOauth2AuthorizeSamsung.kt */
    @DebugMetadata(c = "com.discord.widgets.auth.WidgetOauth2AuthorizeSamsung", f = "WidgetOauth2AuthorizeSamsung.kt", l = {Opcodes.RETURN, Opcodes.NEWARRAY, Opcodes.CHECKCAST}, m = "samsungCallbackHandshake")
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00002\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0082@¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"", ModelAuditLogEntry.CHANGE_KEY_LOCATION, "samsungAuthCode", "Lkotlin/coroutines/Continuation;", "", "continuation", "", "samsungCallbackHandshake", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.auth.WidgetOauth2AuthorizeSamsung$samsungCallbackHandshake$1, reason: invalid class name */
    public static final class AnonymousClass1 extends ContinuationImpl3 {
        public Object L$0;
        public Object L$1;
        public Object L$2;
        public int label;
        public /* synthetic */ Object result;

        public AnonymousClass1(Continuation continuation) {
            super(continuation);
        }

        @Override // d0.w.i.a.ContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return WidgetOauth2AuthorizeSamsung.this.samsungCallbackHandshake(null, null, this);
        }
    }

    /* compiled from: WidgetOauth2AuthorizeSamsung.kt */
    @DebugMetadata(c = "com.discord.widgets.auth.WidgetOauth2AuthorizeSamsung$samsungCallbackHandshake$2", f = "WidgetOauth2AuthorizeSamsung.kt", l = {}, m = "invokeSuspend")
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u0001*\u00020\u0000H\u008a@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.auth.WidgetOauth2AuthorizeSamsung$samsungCallbackHandshake$2, reason: invalid class name */
    public static final class AnonymousClass2 extends ContinuationImpl6 implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        public int label;

        public AnonymousClass2(Continuation continuation) {
            super(2, continuation);
        }

        @Override // d0.w.i.a.ContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Intrinsics3.checkNotNullParameter(continuation, "completion");
            return WidgetOauth2AuthorizeSamsung.this.new AnonymousClass2(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.a);
        }

        @Override // d0.w.i.a.ContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Intrinsics2.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            Result3.throwOnFailure(obj);
            AppToast.i(WidgetOauth2AuthorizeSamsung.this, R.string.authorized, 0, 4);
            AppActivity appActivity = WidgetOauth2AuthorizeSamsung.this.getAppActivity();
            if (appActivity == null) {
                return null;
            }
            appActivity.finish();
            return Unit.a;
        }
    }

    /* compiled from: WidgetOauth2AuthorizeSamsung.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/utilities/error/Error;", "error", "", "invoke", "(Lcom/discord/utilities/error/Error;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.auth.WidgetOauth2AuthorizeSamsung$startSamsungAccountLink$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<Error, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Error error) throws Exception {
            invoke2(error);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Error error) throws Exception {
            Intrinsics3.checkNotNullParameter(error, "error");
            Companion.access$logI(WidgetOauth2AuthorizeSamsung.INSTANCE, "GET /authorize: error " + error);
            AppActivity appActivity = WidgetOauth2AuthorizeSamsung.this.getAppActivity();
            if (appActivity != null) {
                appActivity.onBackPressed();
            }
        }
    }

    /* compiled from: WidgetOauth2AuthorizeSamsung.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Ljava/lang/Void;", "unusableRedirect", "", "invoke", "(Ljava/lang/Void;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.auth.WidgetOauth2AuthorizeSamsung$startSamsungAccountLink$2, reason: invalid class name */
    public static final class AnonymousClass2 extends Lambda implements Function1<Void, Unit> {
        public final /* synthetic */ String $samsungAuthCode;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(String str) {
            super(1);
            this.$samsungAuthCode = str;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Void r1) {
            invoke2(r1);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Void r3) {
            WidgetOauth2AuthorizeSamsung.access$authorizeForSamsung(WidgetOauth2AuthorizeSamsung.this, this.$samsungAuthCode, null);
        }
    }

    public WidgetOauth2AuthorizeSamsung() {
        WidgetOauth2AuthorizeSamsung5 widgetOauth2AuthorizeSamsung5 = new WidgetOauth2AuthorizeSamsung5(this);
        Intrinsics3.checkNotNullParameter(this, "fragment");
        Intrinsics3.checkNotNullParameter(widgetOauth2AuthorizeSamsung5, "callback");
        ActivityResultLauncher<Intent> activityResultLauncherRegisterForActivityResult = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new SamsungConnectActivity2(widgetOauth2AuthorizeSamsung5));
        Intrinsics3.checkNotNullExpressionValue(activityResultLauncherRegisterForActivityResult, "fragment.registerForActi…  }\n          }\n        }");
        this.samsungConnectLauncher = activityResultLauncherRegisterForActivityResult;
        ActivityResultLauncher<Intent> activityResultLauncherRegisterForActivityResult2 = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new WidgetOauth2AuthorizeSamsung6(this));
        Intrinsics3.checkNotNullExpressionValue(activityResultLauncherRegisterForActivityResult2, "registerForActivityResul…inish()\n        }\n      }");
        this.samsungDisclaimerLauncher = activityResultLauncherRegisterForActivityResult2;
        this.captchaLauncher = WidgetAuthCaptcha.INSTANCE.registerForResult(this, new WidgetOauth2AuthorizeSamsung4(this));
    }

    public static final /* synthetic */ void access$authorizeForSamsung(WidgetOauth2AuthorizeSamsung widgetOauth2AuthorizeSamsung, String str, CaptchaHelper.CaptchaPayload captchaPayload) {
        widgetOauth2AuthorizeSamsung.authorizeForSamsung(str, captchaPayload);
    }

    public static final /* synthetic */ String access$getSamsungAuthCode$p(WidgetOauth2AuthorizeSamsung widgetOauth2AuthorizeSamsung) {
        return widgetOauth2AuthorizeSamsung.samsungAuthCode;
    }

    public static final /* synthetic */ ActivityResultLauncher access$getSamsungConnectLauncher$p(WidgetOauth2AuthorizeSamsung widgetOauth2AuthorizeSamsung) {
        return widgetOauth2AuthorizeSamsung.samsungConnectLauncher;
    }

    public static final /* synthetic */ ActivityResultLauncher access$getSamsungDisclaimerLauncher$p(WidgetOauth2AuthorizeSamsung widgetOauth2AuthorizeSamsung) {
        return widgetOauth2AuthorizeSamsung.samsungDisclaimerLauncher;
    }

    public static final /* synthetic */ void access$handleConnectActivityFailure(WidgetOauth2AuthorizeSamsung widgetOauth2AuthorizeSamsung, SamsungConnectActivity.Result.Failure failure) {
        widgetOauth2AuthorizeSamsung.handleConnectActivityFailure(failure);
    }

    public static final /* synthetic */ void access$handleConnectActivitySuccess(WidgetOauth2AuthorizeSamsung widgetOauth2AuthorizeSamsung, SamsungConnectActivity.Result.Success success) {
        widgetOauth2AuthorizeSamsung.handleConnectActivitySuccess(success);
    }

    public static final /* synthetic */ void access$setSamsungAuthCode$p(WidgetOauth2AuthorizeSamsung widgetOauth2AuthorizeSamsung, String str) {
        widgetOauth2AuthorizeSamsung.samsungAuthCode = str;
    }

    private final void authorizeForSamsung(String samsungAuthCode, CaptchaHelper.CaptchaPayload captchaPayload) {
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(getOauth2ViewModel().getOauthAuthorize().post(captchaPayload != null ? captchaPayload.getCaptchaKey() : null, captchaPayload != null ? captchaPayload.getCaptchaRqtoken() : null), false, 1, null), this, null, 2, null), WidgetOauth2AuthorizeSamsung.class, (Context) null, (Function1) null, new AnonymousClass1(), (Function0) null, (Function0) null, new AnonymousClass2(samsungAuthCode), 54, (Object) null);
    }

    private final void handleConnectActivityFailure(SamsungConnectActivity.Result.Failure result) {
        if (!result.isRetryAllowed || result.attemptCount >= 2) {
            return;
        }
        Companion.logW$default(INSTANCE, "Retrying SA connection.\nBecause sometimes it just doesn't bind the first time.", null, 2, null);
        SamsungConnectActivity.b(requireContext(), this.samsungConnectLauncher, result.attemptCount);
    }

    private final void handleConnectActivitySuccess(SamsungConnectActivity.Result.Success result) {
        String str = result.authCode;
        this.samsungAuthCode = str;
        startSamsungAccountLink(result.serverUrl, str);
    }

    private final void startSamsungAccountLink(String saUrl, String samsungAuthCode) {
        String str;
        Intrinsics3.checkNotNullParameter(saUrl, "authServerUrl");
        String strTake = _Strings.take(saUrl, 2);
        int iHashCode = strTake.hashCode();
        if (iHashCode != 3179) {
            if (iHashCode == 3248) {
                strTake.equals("eu");
            } else if (iHashCode == 3742 && strTake.equals("us")) {
                str = "https://us.account.samsung.com";
            }
        } else {
            str = strTake.equals("cn") ? "https://account.samsung.cn" : "https://account.samsung.com";
        }
        Companion companion = INSTANCE;
        Companion.access$logI(companion, "GET /authorize " + str);
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(companion.getForSamsung(getOauth2ViewModel().getOauthAuthorize(), str), false, 1, null), this, null, 2, null), WidgetOauth2AuthorizeSamsung.class, requireContext(), (Function1) null, new AnonymousClass1(), (Function0) null, (Function0) null, new AnonymousClass2(samsungAuthCode), 52, (Object) null);
    }

    @Override // com.discord.widgets.auth.WidgetOauth2Authorize
    public void configureUI(RestAPIParams.OAuth2Authorize.ResponseGet data) {
        Intrinsics3.checkNotNullParameter(data, "data");
        super.configureUI(data);
        getBinding().g.setOnClickListener(new AnonymousClass1());
    }

    @Override // com.discord.widgets.auth.WidgetOauth2Authorize
    public WidgetOauth2Authorize.OAuth2Authorize createOauthAuthorize(Uri requestUrl) {
        Intrinsics3.checkNotNullParameter(requestUrl, "requestUrl");
        WidgetOauth2Authorize.OAuth2Authorize oAuth2AuthorizeCreateOauthAuthorize = super.createOauthAuthorize(requestUrl);
        String state = oAuth2AuthorizeCreateOauthAuthorize.getState();
        if (state == null) {
            state = Companion.access$createSAStateId(INSTANCE);
        }
        return WidgetOauth2Authorize.OAuth2Authorize.copy$default(oAuth2AuthorizeCreateOauthAuthorize, 0L, state, null, "https://discord.com/api/v6/oauth2/samsung/authorize/callback", null, null, null, null, null, null, PointerIconCompat.TYPE_ALL_SCROLL, null);
    }

    @Override // com.discord.widgets.auth.WidgetOauth2Authorize
    public ActivityResultLauncher<Intent> getCaptchaLauncher() {
        return this.captchaLauncher;
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x0106 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0016  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object samsungCallbackHandshake(String str, String str2, Continuation<? super Unit> continuation) throws Throwable {
        AnonymousClass1 anonymousClass1;
        String str3;
        OkHttpClient okHttpClient;
        WidgetOauth2AuthorizeSamsung widgetOauth2AuthorizeSamsung;
        String queryParameter;
        MainCoroutineDispatcher mainCoroutineDispatcher;
        AnonymousClass2 anonymousClass2;
        if (continuation instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuation;
            int i = anonymousClass1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label = i - Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1(continuation);
            }
        }
        Object objC1 = anonymousClass1.result;
        Object coroutine_suspended = Intrinsics2.getCOROUTINE_SUSPENDED();
        int i2 = anonymousClass1.label;
        if (i2 == 0) {
            Result3.throwOnFailure(objC1);
            OkHttpClient.a aVar = new OkHttpClient.a();
            aVar.h = false;
            OkHttpClient okHttpClient2 = new OkHttpClient(aVar);
            Companion.access$logI(INSTANCE, "GET /callback");
            anonymousClass1.L$0 = this;
            anonymousClass1.L$1 = str2;
            anonymousClass1.L$2 = okHttpClient2;
            anonymousClass1.label = 1;
            Object objC12 = f.C1(Dispatchers.f3842b, new SamsungConnect(str, okHttpClient2, null), anonymousClass1);
            if (objC12 == coroutine_suspended) {
                return coroutine_suspended;
            }
            str3 = str2;
            okHttpClient = okHttpClient2;
            objC1 = objC12;
            widgetOauth2AuthorizeSamsung = this;
        } else {
            if (i2 != 1) {
                if (i2 != 2) {
                    if (i2 != 3) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    Result3.throwOnFailure(objC1);
                    return Unit.a;
                }
                widgetOauth2AuthorizeSamsung = (WidgetOauth2AuthorizeSamsung) anonymousClass1.L$0;
                Result3.throwOnFailure(objC1);
                Companion.access$logI(INSTANCE, "POST /callback success " + ((Uri) objC1));
                CoroutineDispatcher coroutineDispatcher = Dispatchers.a;
                mainCoroutineDispatcher = MainDispatchers.f3830b;
                anonymousClass2 = widgetOauth2AuthorizeSamsung.new AnonymousClass2(null);
                anonymousClass1.L$0 = null;
                anonymousClass1.label = 3;
                if (f.C1(mainCoroutineDispatcher, anonymousClass2, anonymousClass1) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return Unit.a;
            }
            OkHttpClient okHttpClient3 = (OkHttpClient) anonymousClass1.L$2;
            String str4 = (String) anonymousClass1.L$1;
            WidgetOauth2AuthorizeSamsung widgetOauth2AuthorizeSamsung2 = (WidgetOauth2AuthorizeSamsung) anonymousClass1.L$0;
            Result3.throwOnFailure(objC1);
            okHttpClient = okHttpClient3;
            str3 = str4;
            widgetOauth2AuthorizeSamsung = widgetOauth2AuthorizeSamsung2;
        }
        Uri uri = (Uri) objC1;
        if (uri == null || (queryParameter = uri.getQueryParameter("redirect_uri")) == null) {
            throw new SamsungConnect3("no_redirect_uri", "no redirect uri returned from GET/callback");
        }
        Intrinsics3.checkNotNullExpressionValue(queryParameter, "getCallbackUri?.getQuery…m GET/callback\"\n        )");
        Companion.access$logI(INSTANCE, "POST /callback " + queryParameter);
        String state = widgetOauth2AuthorizeSamsung.getOauth2ViewModel().getOauthAuthorize().getState();
        Intrinsics3.checkNotNull(state);
        anonymousClass1.L$0 = widgetOauth2AuthorizeSamsung;
        anonymousClass1.L$1 = null;
        anonymousClass1.L$2 = null;
        anonymousClass1.label = 2;
        objC1 = f.C1(Dispatchers.f3842b, new SamsungConnect2(state, str3, queryParameter, okHttpClient, null), anonymousClass1);
        if (objC1 == coroutine_suspended) {
            return coroutine_suspended;
        }
        Companion.access$logI(INSTANCE, "POST /callback success " + ((Uri) objC1));
        CoroutineDispatcher coroutineDispatcher2 = Dispatchers.a;
        mainCoroutineDispatcher = MainDispatchers.f3830b;
        anonymousClass2 = widgetOauth2AuthorizeSamsung.new AnonymousClass2(null);
        anonymousClass1.L$0 = null;
        anonymousClass1.label = 3;
        if (f.C1(mainCoroutineDispatcher, anonymousClass2, anonymousClass1) == coroutine_suspended) {
        }
        return Unit.a;
    }
}
