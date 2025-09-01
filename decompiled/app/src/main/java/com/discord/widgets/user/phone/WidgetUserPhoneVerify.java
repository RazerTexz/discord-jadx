package com.discord.widgets.user.phone;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure;
import androidx.core.app.NotificationCompat;
import androidx.fragment.app.Fragment;
import b.a.d.AppScreen2;
import b.a.d.o;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.analytics.generated.events.network_action.TrackNetworkActionUserVerifyPhone;
import com.discord.analytics.generated.traits.TrackNetworkMetadata2;
import com.discord.app.AppFragment;
import com.discord.app.AppLogger2;
import com.discord.databinding.WidgetUserPhoneVerifyBinding;
import com.discord.models.domain.ModelPhoneVerificationToken;
import com.discord.restapi.RestAPIParams;
import com.discord.stores.utilities.RestCallState5;
import com.discord.utilities.error.Error;
import com.discord.utilities.features.GrowthTeamFeatures;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.sms.SmsListener;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.widgets.user.WidgetUserPasswordVerify;
import com.discord.widgets.user.account.WidgetUserAccountVerifyBase;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import rx.Observable;
import rx.functions.Action1;

/* compiled from: WidgetUserPhoneVerify.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB\u0007¢\u0006\u0004\b\u001d\u0010\u001eJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\b\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\t\u0010\u0006J\u0017\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\f\u0010\rR\u001c\u0010\u000f\u001a\u00020\u000e8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u00138\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u001d\u0010\u001c\u001a\u00020\u00178B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b¨\u0006 "}, d2 = {"Lcom/discord/widgets/user/phone/WidgetUserPhoneVerify;", "Lcom/discord/widgets/user/account/WidgetUserAccountVerifyBase;", "", "verificationCode", "", "autofillCode", "(Ljava/lang/String;)V", "phoneToken", "handleCodeReceived", "handleCodeEntered", "Landroid/view/View;", "view", "onViewBound", "(Landroid/view/View;)V", "Lcom/discord/app/LoggingConfig;", "loggingConfig", "Lcom/discord/app/LoggingConfig;", "getLoggingConfig", "()Lcom/discord/app/LoggingConfig;", "Landroidx/activity/result/ActivityResultLauncher;", "Landroid/content/Intent;", "passwordVerifyLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "Lcom/discord/databinding/WidgetUserPhoneVerifyBinding;", "binding$delegate", "Lcom/discord/utilities/viewbinding/FragmentViewBindingDelegate;", "getBinding", "()Lcom/discord/databinding/WidgetUserPhoneVerifyBinding;", "binding", "<init>", "()V", "Companion", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final class WidgetUserPhoneVerify extends WidgetUserAccountVerifyBase {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetUserPhoneVerify.class, "binding", "getBinding()Lcom/discord/databinding/WidgetUserPhoneVerifyBinding;", 0)};

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String INTENT_EXTRA_PHONE_NUMBER = "INTENT_EXTRA_PHONE_NUMBER";
    private static final String INTENT_EXTRA_SOURCE_TYPE = "INTENT_EXTRA_SOURCE_TYPE";

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private final AppLogger2 loggingConfig;
    private final ActivityResultLauncher<Intent> passwordVerifyLauncher;

    /* compiled from: WidgetUserPhoneVerify.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0018\u0010\u0019J=\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\u000b\u001a\u00020\t¢\u0006\u0004\b\r\u0010\u000eJ)\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0010\u001a\u00020\u000f2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\f0\u0011¢\u0006\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0015\u001a\u00020\t8\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0017\u001a\u00020\t8\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0017\u0010\u0016¨\u0006\u001a"}, d2 = {"Lcom/discord/widgets/user/phone/WidgetUserPhoneVerify$Companion;", "", "Landroid/content/Context;", "context", "Landroidx/activity/result/ActivityResultLauncher;", "Landroid/content/Intent;", "launcher", "Lcom/discord/widgets/user/account/WidgetUserAccountVerifyBase$Mode;", "mode", "", "phoneNumber", "source", "", "launch", "(Landroid/content/Context;Landroidx/activity/result/ActivityResultLauncher;Lcom/discord/widgets/user/account/WidgetUserAccountVerifyBase$Mode;Ljava/lang/String;Ljava/lang/String;)V", "Lcom/discord/app/AppFragment;", "fragment", "Lkotlin/Function0;", "callback", "registerForResult", "(Lcom/discord/app/AppFragment;Lkotlin/jvm/functions/Function0;)Landroidx/activity/result/ActivityResultLauncher;", WidgetUserPhoneVerify.INTENT_EXTRA_PHONE_NUMBER, "Ljava/lang/String;", WidgetUserPhoneVerify.INTENT_EXTRA_SOURCE_TYPE, "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public final void launch(Context context, ActivityResultLauncher<Intent> launcher, WidgetUserAccountVerifyBase.Mode mode, String phoneNumber, String source) {
            Intrinsics3.checkNotNullParameter(context, "context");
            Intrinsics3.checkNotNullParameter(launcher, "launcher");
            Intrinsics3.checkNotNullParameter(mode, "mode");
            Intrinsics3.checkNotNullParameter(source, "source");
            Intent launchIntent = WidgetUserAccountVerifyBase.INSTANCE.getLaunchIntent(mode, true, false);
            if (mode == WidgetUserAccountVerifyBase.Mode.NO_HISTORY_FROM_USER_SETTINGS) {
                launchIntent.addFlags(BasicMeasure.EXACTLY);
            }
            launchIntent.putExtra(WidgetUserPhoneVerify.INTENT_EXTRA_PHONE_NUMBER, phoneNumber);
            launchIntent.putExtra(WidgetUserPhoneVerify.INTENT_EXTRA_SOURCE_TYPE, source);
            AppScreen2.g.f(context, launcher, WidgetUserPhoneVerify.class, launchIntent);
        }

        public final ActivityResultLauncher<Intent> registerForResult(AppFragment fragment, Function0<Unit> callback) {
            Intrinsics3.checkNotNullParameter(fragment, "fragment");
            Intrinsics3.checkNotNullParameter(callback, "callback");
            ActivityResultLauncher<Intent> activityResultLauncherRegisterForActivityResult = fragment.registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new WidgetUserPhoneVerify3(callback));
            Intrinsics3.checkNotNullExpressionValue(activityResultLauncherRegisterForActivityResult, "fragment.registerForActi…k()\n          }\n        }");
            return activityResultLauncherRegisterForActivityResult;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetUserPhoneVerify.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "kotlin.jvm.PlatformType", "it", "", "invoke", "(Ljava/lang/Long;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.user.phone.WidgetUserPhoneVerify$autofillCode$2, reason: invalid class name */
    public static final class AnonymousClass2 extends Lambda implements Function1<Long, Unit> {
        public final /* synthetic */ String $verificationCode;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(String str) {
            super(1);
            this.$verificationCode = str;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Long l) {
            invoke2(l);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Long l) {
            WidgetUserPhoneVerify.access$handleCodeEntered(WidgetUserPhoneVerify.this, this.$verificationCode);
        }
    }

    /* compiled from: WidgetUserPhoneVerify.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u0004\u0018\u00010\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/models/domain/ModelPhoneVerificationToken;", "it", "Lcom/discord/analytics/generated/traits/TrackNetworkMetadataReceiver;", "invoke", "(Lcom/discord/models/domain/ModelPhoneVerificationToken;)Lcom/discord/analytics/generated/traits/TrackNetworkMetadataReceiver;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.user.phone.WidgetUserPhoneVerify$handleCodeEntered$1, reason: invalid class name */
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

    /* compiled from: WidgetUserPhoneVerify.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/discord/models/domain/ModelPhoneVerificationToken;", "kotlin.jvm.PlatformType", "<name for destructuring parameter 0>", "", NotificationCompat.CATEGORY_CALL, "(Lcom/discord/models/domain/ModelPhoneVerificationToken;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.user.phone.WidgetUserPhoneVerify$handleCodeEntered$2, reason: invalid class name */
    public static final class AnonymousClass2<T> implements Action1<ModelPhoneVerificationToken> {
        public AnonymousClass2() {
        }

        @Override // rx.functions.Action1
        public /* bridge */ /* synthetic */ void call(ModelPhoneVerificationToken modelPhoneVerificationToken) {
            call2(modelPhoneVerificationToken);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final void call2(ModelPhoneVerificationToken modelPhoneVerificationToken) {
            WidgetUserPhoneVerify.access$handleCodeReceived(WidgetUserPhoneVerify.this, modelPhoneVerificationToken.getToken());
        }
    }

    /* compiled from: WidgetUserPhoneVerify.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/discord/utilities/error/Error;", "kotlin.jvm.PlatformType", "it", "", NotificationCompat.CATEGORY_CALL, "(Lcom/discord/utilities/error/Error;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.user.phone.WidgetUserPhoneVerify$handleCodeEntered$3, reason: invalid class name */
    public static final class AnonymousClass3<T> implements Action1<Error> {
        public AnonymousClass3() {
        }

        @Override // rx.functions.Action1
        public /* bridge */ /* synthetic */ void call(Error error) {
            call2(error);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final void call2(Error error) {
            WidgetUserPhoneVerify.access$getBinding$p(WidgetUserPhoneVerify.this).d.b();
        }
    }

    /* compiled from: WidgetUserPhoneVerify.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "p1", "", "invoke", "(Ljava/lang/String;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.user.phone.WidgetUserPhoneVerify$onViewBound$2, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass2 extends FunctionReferenceImpl implements Function1<String, Unit> {
        public AnonymousClass2(WidgetUserPhoneVerify widgetUserPhoneVerify) {
            super(1, widgetUserPhoneVerify, WidgetUserPhoneVerify.class, "autofillCode", "autofillCode(Ljava/lang/String;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(String str) {
            invoke2(str);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(String str) {
            Intrinsics3.checkNotNullParameter(str, "p1");
            WidgetUserPhoneVerify.access$autofillCode((WidgetUserPhoneVerify) this.receiver, str);
        }
    }

    public WidgetUserPhoneVerify() {
        super(R.layout.widget_user_phone_verify);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetUserPhoneVerify6.INSTANCE, null, 2, null);
        this.passwordVerifyLauncher = WidgetUserPasswordVerify.INSTANCE.registerForResult(this, new WidgetUserPhoneVerify9(this));
        this.loggingConfig = new AppLogger2(false, null, WidgetUserPhoneVerify7.INSTANCE, 3);
    }

    public static final /* synthetic */ void access$autofillCode(WidgetUserPhoneVerify widgetUserPhoneVerify, String str) {
        widgetUserPhoneVerify.autofillCode(str);
    }

    public static final /* synthetic */ WidgetUserPhoneVerifyBinding access$getBinding$p(WidgetUserPhoneVerify widgetUserPhoneVerify) {
        return widgetUserPhoneVerify.getBinding();
    }

    public static final /* synthetic */ WidgetUserAccountVerifyBase.Mode access$getMode$p(WidgetUserPhoneVerify widgetUserPhoneVerify) {
        return widgetUserPhoneVerify.getMode();
    }

    public static final /* synthetic */ void access$handleCodeEntered(WidgetUserPhoneVerify widgetUserPhoneVerify, String str) {
        widgetUserPhoneVerify.handleCodeEntered(str);
    }

    public static final /* synthetic */ void access$handleCodeReceived(WidgetUserPhoneVerify widgetUserPhoneVerify, String str) {
        widgetUserPhoneVerify.handleCodeReceived(str);
    }

    public static final /* synthetic */ void access$setMode$p(WidgetUserPhoneVerify widgetUserPhoneVerify, WidgetUserAccountVerifyBase.Mode mode) {
        widgetUserPhoneVerify.setMode(mode);
    }

    private final void autofillCode(String verificationCode) {
        if (getView() != null) {
            WidgetUserPhoneVerifyBinding binding = getBinding();
            binding.d.setOnCodeEntered(WidgetUserPhoneVerify4.INSTANCE);
            binding.d.setCode(verificationCode);
            binding.d.setOnCodeEntered(new WidgetUserPhoneVerify5(this));
            Observable<Long> observableD0 = Observable.d0(500L, TimeUnit.MILLISECONDS);
            Intrinsics3.checkNotNullExpressionValue(observableD0, "Observable\n        .time…L, TimeUnit.MILLISECONDS)");
            ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(observableD0, this, null, 2, null), WidgetUserPhoneVerify.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass2(verificationCode), 62, (Object) null);
        }
    }

    private final WidgetUserPhoneVerifyBinding getBinding() {
        return (WidgetUserPhoneVerifyBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final void handleCodeEntered(String verificationCode) {
        String stringExtra = getMostRecentIntent().getStringExtra(INTENT_EXTRA_PHONE_NUMBER);
        if (stringExtra != null) {
            Intrinsics3.checkNotNullExpressionValue(stringExtra, "mostRecentIntent.getStri…A_PHONE_NUMBER) ?: return");
            ObservableExtensionsKt.ui$default(ObservableExtensionsKt.withDimmer$default(ObservableExtensionsKt.restSubscribeOn$default(RestCallState5.logNetworkAction(RestAPI.INSTANCE.getApi().phoneVerificationsVerify(new RestAPIParams.VerificationCode(stringExtra, verificationCode)), AnonymousClass1.INSTANCE), false, 1, null), getBinding().c, 0L, 2, null), this, null, 2, null).k(o.h(new AnonymousClass2(), getContext(), new AnonymousClass3()));
        }
    }

    private final void handleCodeReceived(String phoneToken) {
        String stringExtra = getMostRecentIntent().getStringExtra(INTENT_EXTRA_SOURCE_TYPE);
        if (stringExtra != null) {
            Intrinsics3.checkNotNullExpressionValue(stringExtra, "mostRecentIntent.getStri…RA_SOURCE_TYPE) ?: return");
            WidgetUserPasswordVerify.INSTANCE.launchUpdatePhoneNumber(requireContext(), this.passwordVerifyLauncher, phoneToken, stringExtra);
        }
    }

    @Override // com.discord.app.AppFragment, com.discord.app.AppLogger.a
    public AppLogger2 getLoggingConfig() {
        return this.loggingConfig;
    }

    @Override // com.discord.widgets.user.account.WidgetUserAccountVerifyBase, com.discord.app.AppFragment
    public void onViewBound(View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        WidgetUserPhoneVerifyBinding binding = getBinding();
        binding.d.setOnCodeEntered(new WidgetUserPhoneVerify8(this));
        ImageView imageView = binding.f2688b;
        Intrinsics3.checkNotNullExpressionValue(imageView, "closeButton");
        imageView.setVisibility(isForced() ? 8 : 0);
        binding.f2688b.setOnClickListener(new WidgetUserPhoneVerify2(this));
        if (GrowthTeamFeatures.INSTANCE.isAndroidSmsAutofillEnabled()) {
            SmsListener.INSTANCE.startSmsListener(new AnonymousClass2(this));
        }
    }
}
