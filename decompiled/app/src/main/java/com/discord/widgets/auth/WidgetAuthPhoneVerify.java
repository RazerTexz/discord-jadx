package com.discord.widgets.auth;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.fragment.app.Fragment;
import b.a.d.AppScreen2;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.analytics.generated.events.network_action.TrackNetworkActionUserVerifyPhone;
import com.discord.analytics.generated.traits.TrackNetworkMetadata2;
import com.discord.app.AppActivity;
import com.discord.app.AppFragment;
import com.discord.app.AppLogger2;
import com.discord.app.AppTransitionActivity;
import com.discord.databinding.WidgetAuthPhoneVerifyBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.domain.ModelPhoneVerificationToken;
import com.discord.models.experiments.domain.Experiment;
import com.discord.restapi.RestAPIParams;
import com.discord.stores.StoreStream;
import com.discord.stores.utilities.RestCallState5;
import com.discord.utilities.auth.RegistrationFlowRepo;
import com.discord.utilities.error.Error;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.sms.SmsListener;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import d0.t.CollectionsJVM;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import j0.l.e.ScalarSynchronousObservable;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import kotlin.text.Regex;
import rx.Observable;

/* compiled from: WidgetAuthPhoneVerify.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 .2\u00020\u0001:\u0002./B\u0007¢\u0006\u0004\b-\u0010\bJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\t\u0010\bJ\u000f\u0010\n\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\n\u0010\bJ\u0017\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u000b\u0010\u0006J\u0017\u0010\u000e\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0010\u0010\bJ)\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\f2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0019\u001a\u00020\u0018H\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u001d\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u001d\u0010\bR\u0016\u0010\u001e\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u001c\u0010!\u001a\u00020 8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$R\u001d\u0010*\u001a\u00020%8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)R\u0016\u0010+\u001a\u00020\u00028\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b+\u0010,¨\u00060"}, d2 = {"Lcom/discord/widgets/auth/WidgetAuthPhoneVerify;", "Lcom/discord/app/AppFragment;", "", ModelAuditLogEntry.CHANGE_KEY_CODE, "", "inputCode", "(Ljava/lang/String;)V", "tryPasteCodeFromClipboard", "()V", "resendCode", "bailoutToEmail", "evaluateCode", "Landroid/view/View;", "view", "onViewBound", "(Landroid/view/View;)V", "onDestroyView", "Landroid/view/ContextMenu;", "menu", "v", "Landroid/view/ContextMenu$ContextMenuInfo;", "menuInfo", "onCreateContextMenu", "(Landroid/view/ContextMenu;Landroid/view/View;Landroid/view/ContextMenu$ContextMenuInfo;)V", "Landroid/view/MenuItem;", "item", "", "onContextItemSelected", "(Landroid/view/MenuItem;)Z", "onResume", "ignoreAutopaste", "Z", "Lcom/discord/app/LoggingConfig;", "loggingConfig", "Lcom/discord/app/LoggingConfig;", "getLoggingConfig", "()Lcom/discord/app/LoggingConfig;", "Lcom/discord/databinding/WidgetAuthPhoneVerifyBinding;", "binding$delegate", "Lcom/discord/utilities/viewbinding/FragmentViewBindingDelegate;", "getBinding", "()Lcom/discord/databinding/WidgetAuthPhoneVerifyBinding;", "binding", "phone", "Ljava/lang/String;", "<init>", "Companion", "Result", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class WidgetAuthPhoneVerify extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetAuthPhoneVerify.class, "binding", "getBinding()Lcom/discord/databinding/WidgetAuthPhoneVerifyBinding;", 0)};

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String INTENT_EXTRA_PHONE = "INTENT_EXTRA_PHONE";
    private static final String INTENT_EXTRA_SUBTITLE = "INTENT_EXTRA_SUBTITLE";
    private static final String INTENT_EXTRA_TITLE = "INTENT_EXTRA_TITLE";
    private static final int RESULT_BACK_TO_EMAIL = 2;
    private static final String RESULT_EXTRA_TOKEN = "RESULT_EXTRA_TOKEN";

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private boolean ignoreAutopaste;
    private final AppLogger2 loggingConfig;
    private String phone;

    /* compiled from: WidgetAuthPhoneVerify.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u001e\u0010\u001fJ;\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t¢\u0006\u0004\b\r\u0010\u000eJ/\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0010\u001a\u00020\u000f2\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\f0\u0011¢\u0006\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0016\u001a\u00020\u00078\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u0018\u001a\u00020\u00078\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0018\u0010\u0017R\u0016\u0010\u0019\u001a\u00020\u00078\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0019\u0010\u0017R\u0016\u0010\u001b\u001a\u00020\u001a8\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010\u001d\u001a\u00020\u00078\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001d\u0010\u0017¨\u0006 "}, d2 = {"Lcom/discord/widgets/auth/WidgetAuthPhoneVerify$Companion;", "", "Landroid/content/Context;", "context", "Landroidx/activity/result/ActivityResultLauncher;", "Landroid/content/Intent;", "launcher", "", "phone", "", "title", "subtitle", "", "launch", "(Landroid/content/Context;Landroidx/activity/result/ActivityResultLauncher;Ljava/lang/String;Ljava/lang/CharSequence;Ljava/lang/CharSequence;)V", "Lcom/discord/app/AppFragment;", "fragment", "Lkotlin/Function1;", "Lcom/discord/widgets/auth/WidgetAuthPhoneVerify$Result;", "callback", "registerForResult", "(Lcom/discord/app/AppFragment;Lkotlin/jvm/functions/Function1;)Landroidx/activity/result/ActivityResultLauncher;", WidgetAuthPhoneVerify.INTENT_EXTRA_PHONE, "Ljava/lang/String;", WidgetAuthPhoneVerify.INTENT_EXTRA_SUBTITLE, WidgetAuthPhoneVerify.INTENT_EXTRA_TITLE, "", "RESULT_BACK_TO_EMAIL", "I", WidgetAuthPhoneVerify.RESULT_EXTRA_TOKEN, "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public final void launch(Context context, ActivityResultLauncher<Intent> launcher, String phone, CharSequence title, CharSequence subtitle) {
            Intrinsics3.checkNotNullParameter(context, "context");
            Intrinsics3.checkNotNullParameter(launcher, "launcher");
            Intrinsics3.checkNotNullParameter(phone, "phone");
            Intrinsics3.checkNotNullParameter(title, "title");
            Intrinsics3.checkNotNullParameter(subtitle, "subtitle");
            Intent intent = new Intent();
            intent.putExtra(WidgetAuthPhoneVerify.INTENT_EXTRA_PHONE, phone);
            intent.putExtra(WidgetAuthPhoneVerify.INTENT_EXTRA_TITLE, title);
            intent.putExtra(WidgetAuthPhoneVerify.INTENT_EXTRA_SUBTITLE, subtitle);
            AppScreen2.g.f(context, launcher, WidgetAuthPhoneVerify.class, intent);
        }

        public final ActivityResultLauncher<Intent> registerForResult(AppFragment fragment, Function1<? super Result, Unit> callback) {
            Intrinsics3.checkNotNullParameter(fragment, "fragment");
            Intrinsics3.checkNotNullParameter(callback, "callback");
            ActivityResultLauncher<Intent> activityResultLauncherRegisterForActivityResult = fragment.registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new WidgetAuthPhoneVerify2(callback));
            Intrinsics3.checkNotNullExpressionValue(activityResultLauncherRegisterForActivityResult, "fragment.registerForActi…ed)\n          }\n        }");
            return activityResultLauncherRegisterForActivityResult;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetAuthPhoneVerify.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0002\u0006\u0007¨\u0006\b"}, d2 = {"Lcom/discord/widgets/auth/WidgetAuthPhoneVerify$Result;", "", "<init>", "()V", "Cancelled", "Token", "Lcom/discord/widgets/auth/WidgetAuthPhoneVerify$Result$Token;", "Lcom/discord/widgets/auth/WidgetAuthPhoneVerify$Result$Cancelled;", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static abstract class Result {

        /* compiled from: WidgetAuthPhoneVerify.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/discord/widgets/auth/WidgetAuthPhoneVerify$Result$Cancelled;", "Lcom/discord/widgets/auth/WidgetAuthPhoneVerify$Result;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final class Cancelled extends Result {
            public static final Cancelled INSTANCE = new Cancelled();

            private Cancelled() {
                super(null);
            }
        }

        /* compiled from: WidgetAuthPhoneVerify.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\b\u0010\u0004J\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fHÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010R\u0019\u0010\u0005\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0011\u001a\u0004\b\u0012\u0010\u0004¨\u0006\u0015"}, d2 = {"Lcom/discord/widgets/auth/WidgetAuthPhoneVerify$Result$Token;", "Lcom/discord/widgets/auth/WidgetAuthPhoneVerify$Result;", "", "component1", "()Ljava/lang/String;", "token", "copy", "(Ljava/lang/String;)Lcom/discord/widgets/auth/WidgetAuthPhoneVerify$Result$Token;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getToken", "<init>", "(Ljava/lang/String;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final /* data */ class Token extends Result {
            private final String token;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Token(String str) {
                super(null);
                Intrinsics3.checkNotNullParameter(str, "token");
                this.token = str;
            }

            public static /* synthetic */ Token copy$default(Token token, String str, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = token.token;
                }
                return token.copy(str);
            }

            /* renamed from: component1, reason: from getter */
            public final String getToken() {
                return this.token;
            }

            public final Token copy(String token) {
                Intrinsics3.checkNotNullParameter(token, "token");
                return new Token(token);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof Token) && Intrinsics3.areEqual(this.token, ((Token) other).token);
                }
                return true;
            }

            public final String getToken() {
                return this.token;
            }

            public int hashCode() {
                String str = this.token;
                if (str != null) {
                    return str.hashCode();
                }
                return 0;
            }

            public String toString() {
                return outline.J(outline.U("Token(token="), this.token, ")");
            }
        }

        private Result() {
        }

        public /* synthetic */ Result(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetAuthPhoneVerify.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u0004\u0018\u00010\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/models/domain/ModelPhoneVerificationToken;", "it", "Lcom/discord/analytics/generated/traits/TrackNetworkMetadataReceiver;", "invoke", "(Lcom/discord/models/domain/ModelPhoneVerificationToken;)Lcom/discord/analytics/generated/traits/TrackNetworkMetadataReceiver;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.auth.WidgetAuthPhoneVerify$evaluateCode$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<ModelPhoneVerificationToken, TrackNetworkMetadata2> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ TrackNetworkMetadata2 invoke(ModelPhoneVerificationToken modelPhoneVerificationToken) {
            return invoke2(modelPhoneVerificationToken);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final TrackNetworkMetadata2 invoke2(ModelPhoneVerificationToken modelPhoneVerificationToken) {
            return new TrackNetworkActionUserVerifyPhone();
        }
    }

    /* compiled from: WidgetAuthPhoneVerify.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/models/domain/ModelPhoneVerificationToken;", "it", "", "invoke", "(Lcom/discord/models/domain/ModelPhoneVerificationToken;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.auth.WidgetAuthPhoneVerify$evaluateCode$2, reason: invalid class name */
    public static final class AnonymousClass2 extends Lambda implements Function1<ModelPhoneVerificationToken, Unit> {
        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ModelPhoneVerificationToken modelPhoneVerificationToken) {
            invoke2(modelPhoneVerificationToken);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ModelPhoneVerificationToken modelPhoneVerificationToken) {
            Intrinsics3.checkNotNullParameter(modelPhoneVerificationToken, "it");
            Intent intent = new Intent();
            intent.putExtra(WidgetAuthPhoneVerify.RESULT_EXTRA_TOKEN, modelPhoneVerificationToken.getToken());
            AppActivity appActivity = WidgetAuthPhoneVerify.this.getAppActivity();
            if (appActivity != null) {
                appActivity.setResult(-1, intent);
            }
            AppActivity appActivity2 = WidgetAuthPhoneVerify.this.getAppActivity();
            if (appActivity2 != null) {
                appActivity2.finish();
            }
        }
    }

    /* compiled from: WidgetAuthPhoneVerify.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/utilities/error/Error;", "it", "", "invoke", "(Lcom/discord/utilities/error/Error;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.auth.WidgetAuthPhoneVerify$evaluateCode$3, reason: invalid class name */
    public static final class AnonymousClass3 extends Lambda implements Function1<Error, Unit> {
        public AnonymousClass3() {
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
            RegistrationFlowRepo.INSTANCE.getINSTANCE().trackTransition("Phone Verification", "response_error", CollectionsJVM.listOf(ModelAuditLogEntry.CHANGE_KEY_CODE));
            WidgetAuthPhoneVerify.access$getBinding$p(WidgetAuthPhoneVerify.this).c.b();
        }
    }

    /* compiled from: WidgetAuthPhoneVerify.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "it", "", "invoke", "(Ljava/lang/String;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.auth.WidgetAuthPhoneVerify$inputCode$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<String, Unit> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

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
            Intrinsics3.checkNotNullParameter(str, "it");
        }
    }

    /* compiled from: WidgetAuthPhoneVerify.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "p1", "", "invoke", "(Ljava/lang/String;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.auth.WidgetAuthPhoneVerify$inputCode$2, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass2 extends FunctionReferenceImpl implements Function1<String, Unit> {
        public AnonymousClass2(WidgetAuthPhoneVerify widgetAuthPhoneVerify) {
            super(1, widgetAuthPhoneVerify, WidgetAuthPhoneVerify.class, "evaluateCode", "evaluateCode(Ljava/lang/String;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(String str) {
            invoke2(str);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(String str) {
            Intrinsics3.checkNotNullParameter(str, "p1");
            WidgetAuthPhoneVerify.access$evaluateCode((WidgetAuthPhoneVerify) this.receiver, str);
        }
    }

    /* compiled from: WidgetAuthPhoneVerify.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "kotlin.jvm.PlatformType", "it", "", "invoke", "(Ljava/lang/Long;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.auth.WidgetAuthPhoneVerify$inputCode$3, reason: invalid class name */
    public static final class AnonymousClass3 extends Lambda implements Function1<Long, Unit> {
        public AnonymousClass3() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Long l) {
            invoke2(l);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Long l) {
            WidgetAuthPhoneVerify widgetAuthPhoneVerify = WidgetAuthPhoneVerify.this;
            WidgetAuthPhoneVerify.access$evaluateCode(widgetAuthPhoneVerify, WidgetAuthPhoneVerify.access$getBinding$p(widgetAuthPhoneVerify).c.getCom.discord.models.domain.ModelAuditLogEntry.CHANGE_KEY_CODE java.lang.String());
        }
    }

    /* compiled from: WidgetAuthPhoneVerify.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0005\u0010\u0005\u001a\u00020\u00002\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "kotlin.jvm.PlatformType", "it", "invoke", "(Lkotlin/Unit;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.auth.WidgetAuthPhoneVerify$onResume$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<Unit, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Unit unit) {
            invoke2(unit);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Unit unit) {
            WidgetAuthPhoneVerify.access$tryPasteCodeFromClipboard(WidgetAuthPhoneVerify.this);
        }
    }

    /* compiled from: WidgetAuthPhoneVerify.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.auth.WidgetAuthPhoneVerify$onViewBound$1, reason: invalid class name */
    public static final class AnonymousClass1 implements View.OnClickListener {
        public AnonymousClass1() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetAuthPhoneVerify.access$resendCode(WidgetAuthPhoneVerify.this);
        }
    }

    /* compiled from: WidgetAuthPhoneVerify.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.auth.WidgetAuthPhoneVerify$onViewBound$2, reason: invalid class name */
    public static final class AnonymousClass2 implements View.OnClickListener {
        public AnonymousClass2() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetAuthPhoneVerify.access$bailoutToEmail(WidgetAuthPhoneVerify.this);
        }
    }

    /* compiled from: WidgetAuthPhoneVerify.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", ModelAuditLogEntry.CHANGE_KEY_CODE, "", "invoke", "(Ljava/lang/String;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.auth.WidgetAuthPhoneVerify$onViewBound$3, reason: invalid class name */
    public static final class AnonymousClass3 extends Lambda implements Function1<String, Unit> {
        public AnonymousClass3() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(String str) {
            invoke2(str);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(String str) {
            Intrinsics3.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_CODE);
            WidgetAuthPhoneVerify.access$evaluateCode(WidgetAuthPhoneVerify.this, str);
        }
    }

    /* compiled from: WidgetAuthPhoneVerify.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "p1", "", "invoke", "(Ljava/lang/String;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.auth.WidgetAuthPhoneVerify$onViewBound$4, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass4 extends FunctionReferenceImpl implements Function1<String, Unit> {
        public AnonymousClass4(WidgetAuthPhoneVerify widgetAuthPhoneVerify) {
            super(1, widgetAuthPhoneVerify, WidgetAuthPhoneVerify.class, "inputCode", "inputCode(Ljava/lang/String;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(String str) {
            invoke2(str);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(String str) {
            Intrinsics3.checkNotNullParameter(str, "p1");
            WidgetAuthPhoneVerify.access$inputCode((WidgetAuthPhoneVerify) this.receiver, str);
        }
    }

    /* compiled from: WidgetAuthPhoneVerify.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Ljava/lang/Void;", "it", "", "invoke", "(Ljava/lang/Void;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.auth.WidgetAuthPhoneVerify$resendCode$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<Void, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Void r1) {
            invoke2(r1);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Void r1) {
            WidgetAuthPhoneVerify.access$getBinding$p(WidgetAuthPhoneVerify.this).c.b();
        }
    }

    /* compiled from: WidgetAuthPhoneVerify.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/utilities/error/Error;", "it", "", "invoke", "(Lcom/discord/utilities/error/Error;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.auth.WidgetAuthPhoneVerify$resendCode$2, reason: invalid class name */
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
            WidgetAuthPhoneVerify.access$getBinding$p(WidgetAuthPhoneVerify.this).c.b();
        }
    }

    public WidgetAuthPhoneVerify() {
        super(R.layout.widget_auth_phone_verify);
        this.loggingConfig = new AppLogger2(false, null, WidgetAuthPhoneVerify4.INSTANCE, 3);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetAuthPhoneVerify3.INSTANCE, null, 2, null);
        this.ignoreAutopaste = true;
    }

    public static final /* synthetic */ void access$bailoutToEmail(WidgetAuthPhoneVerify widgetAuthPhoneVerify) {
        widgetAuthPhoneVerify.bailoutToEmail();
    }

    public static final /* synthetic */ void access$evaluateCode(WidgetAuthPhoneVerify widgetAuthPhoneVerify, String str) {
        widgetAuthPhoneVerify.evaluateCode(str);
    }

    public static final /* synthetic */ WidgetAuthPhoneVerifyBinding access$getBinding$p(WidgetAuthPhoneVerify widgetAuthPhoneVerify) {
        return widgetAuthPhoneVerify.getBinding();
    }

    public static final /* synthetic */ void access$inputCode(WidgetAuthPhoneVerify widgetAuthPhoneVerify, String str) {
        widgetAuthPhoneVerify.inputCode(str);
    }

    public static final /* synthetic */ void access$resendCode(WidgetAuthPhoneVerify widgetAuthPhoneVerify) {
        widgetAuthPhoneVerify.resendCode();
    }

    public static final /* synthetic */ void access$tryPasteCodeFromClipboard(WidgetAuthPhoneVerify widgetAuthPhoneVerify) {
        widgetAuthPhoneVerify.tryPasteCodeFromClipboard();
    }

    private final void bailoutToEmail() {
        AppActivity appActivity = getAppActivity();
        if (appActivity != null) {
            appActivity.setResult(2);
        }
        AppTransitionActivity.j = true;
        AppActivity appActivity2 = getAppActivity();
        if (appActivity2 != null) {
            appActivity2.overridePendingTransition(R.anim.activity_slide_horizontal_open_in, R.anim.activity_slide_horizontal_close_out);
        }
        AppActivity appActivity3 = getAppActivity();
        if (appActivity3 != null) {
            appActivity3.finish();
        }
    }

    private final void evaluateCode(String code) {
        RegistrationFlowRepo.trackTransition$default(RegistrationFlowRepo.INSTANCE.getINSTANCE(), "Phone Verification", "submitted", null, 4, null);
        RestAPI api = RestAPI.INSTANCE.getApi();
        String str = this.phone;
        if (str == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("phone");
        }
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.withDimmer$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(RestCallState5.logNetworkAction(api.phoneVerificationsVerify(new RestAPIParams.VerificationCode(str, code)), AnonymousClass1.INSTANCE), false, 1, null), this, null, 2, null), getBinding().g, 0L, 2, null), WidgetAuthPhoneVerify.class, getContext(), (Function1) null, new AnonymousClass3(), (Function0) null, (Function0) null, new AnonymousClass2(), 52, (Object) null);
    }

    private final WidgetAuthPhoneVerifyBinding getBinding() {
        return (WidgetAuthPhoneVerifyBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final void inputCode(String code) {
        if (getView() != null) {
            getBinding().c.setOnCodeEntered(AnonymousClass1.INSTANCE);
            getBinding().c.setCode(code);
            getBinding().c.setOnCodeEntered(new AnonymousClass2(this));
            Observable<Long> observableD0 = Observable.d0(500L, TimeUnit.MILLISECONDS);
            Intrinsics3.checkNotNullExpressionValue(observableD0, "Observable\n        .time…L, TimeUnit.MILLISECONDS)");
            ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(observableD0, this, null, 2, null), WidgetAuthPhoneVerify.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass3(), 62, (Object) null);
        }
    }

    private final void resendCode() {
        RestAPI api = RestAPI.INSTANCE.getApi();
        String str = this.phone;
        if (str == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("phone");
        }
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.withDimmer$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(api.phoneVerificationsResend(new RestAPIParams.VerificationCodeResend(str)), false, 1, null), this, null, 2, null), getBinding().g, 0L, 2, null), WidgetAuthPhoneVerify.class, getContext(), (Function1) null, new AnonymousClass2(), (Function0) null, (Function0) null, new AnonymousClass1(), 52, (Object) null);
    }

    private final void tryPasteCodeFromClipboard() {
        ClipData primaryClip;
        Context context = getContext();
        if (context != null) {
            Intrinsics3.checkNotNullExpressionValue(context, "context ?: return");
            Object systemService = context.getSystemService("clipboard");
            if (!(systemService instanceof ClipboardManager)) {
                systemService = null;
            }
            ClipboardManager clipboardManager = (ClipboardManager) systemService;
            if (clipboardManager == null || (primaryClip = clipboardManager.getPrimaryClip()) == null) {
                return;
            }
            Intrinsics3.checkNotNullExpressionValue(primaryClip, "clipboard.primaryClip ?: return");
            if (primaryClip.getItemCount() >= 1) {
                CharSequence charSequenceCoerceToText = primaryClip.getItemAt(0).coerceToText(context);
                Intrinsics3.checkNotNullExpressionValue(charSequenceCoerceToText, "clipData.getItemAt(0).coerceToText(context)");
                String strReplace = new Regex(" ").replace(charSequenceCoerceToText, "");
                if (strReplace.length() == 6 && TextUtils.isDigitsOnly(strReplace)) {
                    inputCode(strReplace);
                }
            }
        }
    }

    @Override // com.discord.app.AppFragment, com.discord.app.AppLogger.a
    public AppLogger2 getLoggingConfig() {
        return this.loggingConfig;
    }

    @Override // androidx.fragment.app.Fragment
    public boolean onContextItemSelected(MenuItem item) {
        Intrinsics3.checkNotNullParameter(item, "item");
        if (item.getItemId() != R.id.menu_code_verification_paste) {
            return super.onContextItemSelected(item);
        }
        tryPasteCodeFromClipboard();
        return true;
    }

    @Override // androidx.fragment.app.Fragment, android.view.View.OnCreateContextMenuListener
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        Intrinsics3.checkNotNullParameter(menu, "menu");
        Intrinsics3.checkNotNullParameter(v, "v");
        super.onCreateContextMenu(menu, v, menuInfo);
        new MenuInflater(requireContext()).inflate(R.menu.menu_code_verification, menu);
    }

    @Override // com.discord.app.AppFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        SmsListener.INSTANCE.stopSmsListener();
    }

    @Override // com.discord.app.AppFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.ignoreAutopaste) {
            this.ignoreAutopaste = false;
            return;
        }
        ScalarSynchronousObservable scalarSynchronousObservable = new ScalarSynchronousObservable(Unit.a);
        Intrinsics3.checkNotNullExpressionValue(scalarSynchronousObservable, "Observable\n          .just(Unit)");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(scalarSynchronousObservable, this, null, 2, null), WidgetAuthPhoneVerify.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(), 62, (Object) null);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        String stringExtra = getMostRecentIntent().getStringExtra(INTENT_EXTRA_PHONE);
        if (stringExtra == null) {
            stringExtra = "";
        }
        this.phone = stringExtra;
        RegistrationFlowRepo.trackTransition$default(RegistrationFlowRepo.INSTANCE.getINSTANCE(), "Phone Verification", "viewed", null, 4, null);
        CharSequence charSequenceExtra = getMostRecentIntent().getCharSequenceExtra(INTENT_EXTRA_TITLE);
        if (charSequenceExtra == null) {
            charSequenceExtra = "";
        }
        Intrinsics3.checkNotNullExpressionValue(charSequenceExtra, "mostRecentIntent.getChar…INTENT_EXTRA_TITLE) ?: \"\"");
        CharSequence charSequenceExtra2 = getMostRecentIntent().getCharSequenceExtra(INTENT_EXTRA_SUBTITLE);
        if (charSequenceExtra2 == null) {
            charSequenceExtra2 = "";
        }
        Intrinsics3.checkNotNullExpressionValue(charSequenceExtra2, "mostRecentIntent.getChar…ENT_EXTRA_SUBTITLE) ?: \"\"");
        if (!Intrinsics3.areEqual(charSequenceExtra, "")) {
            TextView textView = getBinding().f;
            Intrinsics3.checkNotNullExpressionValue(textView, "binding.authPhoneVerifyTitle");
            textView.setText(charSequenceExtra);
        }
        if (!Intrinsics3.areEqual(charSequenceExtra2, "")) {
            TextView textView2 = getBinding().e;
            Intrinsics3.checkNotNullExpressionValue(textView2, "binding.authPhoneVerifySubtitle");
            textView2.setText(charSequenceExtra2);
        }
        getBinding().d.setOnClickListener(new AnonymousClass1());
        Experiment userExperiment = StoreStream.INSTANCE.getExperiments().getUserExperiment("2021-06_reg_bailout_to_email_android", true);
        if (userExperiment != null && userExperiment.getBucket() == 1) {
            TextView textView3 = getBinding().f2235b;
            Intrinsics3.checkNotNullExpressionValue(textView3, "binding.authPhoneBailout");
            textView3.setVisibility(0);
            getBinding().f2235b.setOnClickListener(new AnonymousClass2());
        }
        getBinding().c.setOnCodeEntered(new AnonymousClass3());
        registerForContextMenu(getBinding().c);
        SmsListener.INSTANCE.startSmsListener(new AnonymousClass4(this));
    }
}
