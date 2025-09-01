package com.discord.widgets.auth;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.activity.result.ActivityResultLauncher;
import androidx.core.app.NotificationCompat;
import androidx.fragment.app.Fragment;
import b.a.d.AppScreen2;
import b.a.k.FormatUtils;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.analytics.generated.events.network_action.TrackNetworkActionUserRegisterPhone;
import com.discord.analytics.generated.traits.TrackNetworkMetadata2;
import com.discord.app.AppFragment;
import com.discord.app.AppLogger2;
import com.discord.databinding.WidgetAuthRegisterIdentityBinding;
import com.discord.models.domain.ModelInvite;
import com.discord.models.experiments.domain.Experiment;
import com.discord.models.phone.PhoneCountryCode;
import com.discord.restapi.RestAPIParams;
import com.discord.stores.StorePhone;
import com.discord.stores.StoreStream;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeck4;
import com.discord.stores.utilities.RestCallState5;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.utilities.auth.RegistrationFlowRepo;
import com.discord.utilities.captcha.CaptchaHelper;
import com.discord.utilities.error.Error;
import com.discord.utilities.features.GrowthTeamFeatures;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.discord.utilities.view.validators.ValidationManager;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.views.phone.PhoneOrEmailInputView;
import com.discord.views.segmentedcontrol.CardSegment;
import com.discord.views.segmentedcontrol.SegmentedControlContainer;
import com.discord.widgets.auth.WidgetAuthCaptcha;
import com.discord.widgets.captcha.WidgetCaptcha4;
import d0.LazyJVM;
import d0.t.CollectionsJVM;
import d0.t._Collections;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KProperty;

/* compiled from: WidgetAuthRegisterIdentity.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 >2\u00020\u0001:\u0001>B\u0007¢\u0006\u0004\b=\u0010\u0004J\u000f\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0004J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u000b\u0010\u0004J\u0017\u0010\r\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u000f\u0010\u0004J\u001b\u0010\u0012\u001a\u00020\u00022\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0014\u0010\u0004J\u0017\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J!\u0010\u001c\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u00192\b\u0010\u001b\u001a\u0004\u0018\u00010\u0015H\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010\u001e\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u001e\u0010\u0004R\u001c\u0010!\u001a\b\u0012\u0004\u0012\u00020 0\u001f8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b!\u0010\"R\u001c\u0010$\u001a\u00020#8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'R\u0016\u0010)\u001a\u00020(8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b)\u0010*R\u001d\u00100\u001a\u00020+8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/R\u001c\u00101\u001a\b\u0012\u0004\u0012\u00020 0\u001f8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b1\u0010\"R\u0016\u00102\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b2\u00103R\u001d\u00109\u001a\u0002048B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b5\u00106\u001a\u0004\b7\u00108R\u001d\u0010<\u001a\u0002048B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b:\u00106\u001a\u0004\b;\u00108¨\u0006?"}, d2 = {"Lcom/discord/widgets/auth/WidgetAuthRegisterIdentity;", "Lcom/discord/app/AppFragment;", "", "configureUI", "()V", "configurePhoneInput", "Lcom/discord/views/phone/PhoneOrEmailInputView$Mode;", "mode", "Lcom/discord/views/segmentedcontrol/CardSegment;", "getCardSegmentForMode", "(Lcom/discord/views/phone/PhoneOrEmailInputView$Mode;)Lcom/discord/views/segmentedcontrol/CardSegment;", "configureSegmentControl", "newInputMode", "setInputMode", "(Lcom/discord/views/phone/PhoneOrEmailInputView$Mode;)V", "handleNext", "Lcom/discord/utilities/captcha/CaptchaHelper$CaptchaPayload;", "captchaPayload", "registerViaPhone", "(Lcom/discord/utilities/captcha/CaptchaHelper$CaptchaPayload;)V", "registerViaEmail", "Landroid/os/Bundle;", "outState", "onSaveInstanceState", "(Landroid/os/Bundle;)V", "Landroid/view/View;", "view", "savedInstanceState", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "onResume", "Landroidx/activity/result/ActivityResultLauncher;", "Landroid/content/Intent;", "phoneVerifyLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "Lcom/discord/app/LoggingConfig;", "loggingConfig", "Lcom/discord/app/LoggingConfig;", "getLoggingConfig", "()Lcom/discord/app/LoggingConfig;", "", "shouldValidateInputs", "Z", "Lcom/discord/databinding/WidgetAuthRegisterIdentityBinding;", "binding$delegate", "Lcom/discord/utilities/viewbinding/FragmentViewBindingDelegate;", "getBinding", "()Lcom/discord/databinding/WidgetAuthRegisterIdentityBinding;", "binding", "captchaLauncher", "inputMode", "Lcom/discord/views/phone/PhoneOrEmailInputView$Mode;", "Lcom/discord/utilities/view/validators/ValidationManager;", "emailValidationManager$delegate", "Lkotlin/Lazy;", "getEmailValidationManager", "()Lcom/discord/utilities/view/validators/ValidationManager;", "emailValidationManager", "phoneValidationManager$delegate", "getPhoneValidationManager", "phoneValidationManager", "<init>", "Companion", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class WidgetAuthRegisterIdentity extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetAuthRegisterIdentity.class, "binding", "getBinding()Lcom/discord/databinding/WidgetAuthRegisterIdentityBinding;", 0)};
    private static final String IS_PHONE_MODE = "IS_PHONE_MODE";

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private final ActivityResultLauncher<Intent> captchaLauncher;

    /* renamed from: emailValidationManager$delegate, reason: from kotlin metadata */
    private final Lazy emailValidationManager;
    private PhoneOrEmailInputView.Mode inputMode;
    private final AppLogger2 loggingConfig;

    /* renamed from: phoneValidationManager$delegate, reason: from kotlin metadata */
    private final Lazy phoneValidationManager;
    private final ActivityResultLauncher<Intent> phoneVerifyLauncher;
    private boolean shouldValidateInputs;

    /* compiled from: WidgetAuthRegisterIdentity.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/widget/TextView;", "it", "", "invoke", "(Landroid/widget/TextView;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.auth.WidgetAuthRegisterIdentity$configurePhoneInput$1, reason: invalid class name */
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
            WidgetAuthRegisterIdentity.access$handleNext(WidgetAuthRegisterIdentity.this);
        }
    }

    /* compiled from: WidgetAuthRegisterIdentity.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "index", "", "invoke", "(I)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.auth.WidgetAuthRegisterIdentity$configureSegmentControl$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<Integer, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
            invoke(num.intValue());
            return Unit.a;
        }

        public final void invoke(int i) {
            WidgetAuthRegisterIdentity.access$setInputMode(WidgetAuthRegisterIdentity.this, i == 0 ? PhoneOrEmailInputView.Mode.PHONE : PhoneOrEmailInputView.Mode.EMAIL);
            WidgetAuthRegisterIdentity.access$getBinding$p(WidgetAuthRegisterIdentity.this).g.setSelectedIndex(i);
        }
    }

    /* compiled from: WidgetAuthRegisterIdentity.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lcom/discord/models/phone/PhoneCountryCode;", "invoke", "()Lcom/discord/models/phone/PhoneCountryCode;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.auth.WidgetAuthRegisterIdentity$configureUI$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<PhoneCountryCode> {
        public final /* synthetic */ StorePhone $phoneStore;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(StorePhone storePhone) {
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

    /* compiled from: WidgetAuthRegisterIdentity.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/models/phone/PhoneCountryCode;", "it", "", "invoke", "(Lcom/discord/models/phone/PhoneCountryCode;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.auth.WidgetAuthRegisterIdentity$configureUI$2, reason: invalid class name */
    public static final class AnonymousClass2 extends Lambda implements Function1<PhoneCountryCode, Unit> {
        public AnonymousClass2() {
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
            WidgetAuthRegisterIdentity.access$getBinding$p(WidgetAuthRegisterIdentity.this).d.setCountryCode(phoneCountryCode);
        }
    }

    /* compiled from: WidgetAuthRegisterIdentity.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.auth.WidgetAuthRegisterIdentity$configureUI$3, reason: invalid class name */
    public static final class AnonymousClass3 implements View.OnClickListener {
        public AnonymousClass3() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetAuthRegisterIdentity.access$handleNext(WidgetAuthRegisterIdentity.this);
        }
    }

    /* compiled from: WidgetAuthRegisterIdentity.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/models/domain/ModelInvite;", "invite", "", "invoke", "(Lcom/discord/models/domain/ModelInvite;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.auth.WidgetAuthRegisterIdentity$onViewCreated$1, reason: invalid class name */
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
            AnalyticsTracker.INSTANCE.registerViewed(modelInvite);
            RegistrationFlowRepo.Companion companion = RegistrationFlowRepo.INSTANCE;
            companion.getINSTANCE().setInvite(modelInvite);
            RegistrationFlowRepo.trackTransition$default(companion.getINSTANCE(), "Account Identity", "viewed", null, 4, null);
        }
    }

    /* compiled from: WidgetAuthRegisterIdentity.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u0004\u0018\u00010\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Ljava/lang/Void;", "it", "Lcom/discord/analytics/generated/traits/TrackNetworkMetadataReceiver;", "invoke", "(Ljava/lang/Void;)Lcom/discord/analytics/generated/traits/TrackNetworkMetadataReceiver;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.auth.WidgetAuthRegisterIdentity$registerViaPhone$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<Void, TrackNetworkMetadata2> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ TrackNetworkMetadata2 invoke(Void r1) {
            return invoke2(r1);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final TrackNetworkMetadata2 invoke2(Void r1) {
            return new TrackNetworkActionUserRegisterPhone();
        }
    }

    /* compiled from: WidgetAuthRegisterIdentity.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Ljava/lang/Void;", "it", "", "invoke", "(Ljava/lang/Void;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.auth.WidgetAuthRegisterIdentity$registerViaPhone$2, reason: invalid class name */
    public static final class AnonymousClass2 extends Lambda implements Function1<Void, Unit> {
        public final /* synthetic */ String $phone;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(String str) {
            super(1);
            this.$phone = str;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Void r1) {
            invoke2(r1);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Void r13) {
            RegistrationFlowRepo.trackTransition$default(RegistrationFlowRepo.INSTANCE.getINSTANCE(), "Account Identity", "success", null, 4, null);
            WidgetAuthPhoneVerify.INSTANCE.launch(WidgetAuthRegisterIdentity.this.requireContext(), WidgetAuthRegisterIdentity.access$getPhoneVerifyLauncher$p(WidgetAuthRegisterIdentity.this), WidgetAuthRegisterIdentity.access$getBinding$p(WidgetAuthRegisterIdentity.this).d.getTextOrEmpty(), FormatUtils.h(WidgetAuthRegisterIdentity.this.requireContext(), R.string.sms_confirmation_title, new Object[0], null, 4), FormatUtils.h(WidgetAuthRegisterIdentity.this.requireContext(), R.string.sms_confirmation_description, new Object[]{this.$phone}, null, 4));
        }
    }

    /* compiled from: WidgetAuthRegisterIdentity.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/utilities/error/Error;", "error", "", "invoke", "(Lcom/discord/utilities/error/Error;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.auth.WidgetAuthRegisterIdentity$registerViaPhone$3, reason: invalid class name */
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
            Intrinsics3.checkNotNullParameter(error, "error");
            if (!GrowthTeamFeatures.INSTANCE.isPhoneVerifyCaptchaEnabled() || !WidgetCaptcha4.isCaptchaError(error)) {
                RegistrationFlowRepo.INSTANCE.getINSTANCE().trackTransition("Account Identity", "response_error", CollectionsJVM.listOf("phone"));
                return;
            }
            WidgetAuthCaptcha.Companion companion = WidgetAuthCaptcha.INSTANCE;
            Context contextRequireContext = WidgetAuthRegisterIdentity.this.requireContext();
            ActivityResultLauncher<Intent> activityResultLauncherAccess$getCaptchaLauncher$p = WidgetAuthRegisterIdentity.access$getCaptchaLauncher$p(WidgetAuthRegisterIdentity.this);
            Error.Response response = error.getResponse();
            Intrinsics3.checkNotNullExpressionValue(response, "error.response");
            companion.processErrorsForCaptcha(contextRequireContext, activityResultLauncherAccess$getCaptchaLauncher$p, _Collections.toMutableList((Collection) response.getMessages().keySet()), error);
        }
    }

    public WidgetAuthRegisterIdentity() {
        super(R.layout.widget_auth_register_identity);
        this.loggingConfig = new AppLogger2(false, null, WidgetAuthRegisterIdentity5.INSTANCE, 3);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetAuthRegisterIdentity2.INSTANCE, null, 2, null);
        this.inputMode = PhoneOrEmailInputView.Mode.PHONE;
        this.shouldValidateInputs = true;
        this.phoneVerifyLauncher = WidgetAuthPhoneVerify.INSTANCE.registerForResult(this, new WidgetAuthRegisterIdentity7(this));
        this.captchaLauncher = WidgetAuthCaptcha.INSTANCE.registerForResult(this, new WidgetAuthRegisterIdentity3(this));
        this.phoneValidationManager = LazyJVM.lazy(new WidgetAuthRegisterIdentity6(this));
        this.emailValidationManager = LazyJVM.lazy(new WidgetAuthRegisterIdentity4(this));
    }

    public static final /* synthetic */ WidgetAuthRegisterIdentityBinding access$getBinding$p(WidgetAuthRegisterIdentity widgetAuthRegisterIdentity) {
        return widgetAuthRegisterIdentity.getBinding();
    }

    public static final /* synthetic */ ActivityResultLauncher access$getCaptchaLauncher$p(WidgetAuthRegisterIdentity widgetAuthRegisterIdentity) {
        return widgetAuthRegisterIdentity.captchaLauncher;
    }

    public static final /* synthetic */ ActivityResultLauncher access$getPhoneVerifyLauncher$p(WidgetAuthRegisterIdentity widgetAuthRegisterIdentity) {
        return widgetAuthRegisterIdentity.phoneVerifyLauncher;
    }

    public static final /* synthetic */ void access$handleNext(WidgetAuthRegisterIdentity widgetAuthRegisterIdentity) {
        widgetAuthRegisterIdentity.handleNext();
    }

    public static final /* synthetic */ void access$registerViaPhone(WidgetAuthRegisterIdentity widgetAuthRegisterIdentity, CaptchaHelper.CaptchaPayload captchaPayload) {
        widgetAuthRegisterIdentity.registerViaPhone(captchaPayload);
    }

    public static final /* synthetic */ void access$setInputMode(WidgetAuthRegisterIdentity widgetAuthRegisterIdentity, PhoneOrEmailInputView.Mode mode) {
        widgetAuthRegisterIdentity.setInputMode(mode);
    }

    private final void configurePhoneInput() {
        getBinding().d.setMode(this.inputMode);
        if (this.inputMode == PhoneOrEmailInputView.Mode.PHONE) {
            getBinding().d.setHint(getString(R.string.form_label_phone_number));
        } else {
            getBinding().d.setHint(getString(R.string.form_label_email));
        }
        getBinding().d.getMainEditText().setImeOptions(6);
        ViewExtensions.setOnImeActionDone$default(getBinding().d.getMainTextInputLayout(), false, new AnonymousClass1(), 1, null);
    }

    private final void configureSegmentControl() {
        SegmentedControlContainer.b(getBinding().g, 0, 1);
        getBinding().g.setOnSegmentSelectedChangeListener(new AnonymousClass1());
        PhoneOrEmailInputView.Mode mode = this.inputMode;
        PhoneOrEmailInputView.Mode mode2 = PhoneOrEmailInputView.Mode.PHONE;
        getBinding().g.setSelectedIndex(mode != mode2 ? 1 : 0);
        CardSegment cardSegmentForMode = getCardSegmentForMode(mode2);
        cardSegmentForMode.setText(getString(R.string.phone));
        cardSegmentForMode.setContentDescription(getString(R.string.use_phone));
        CardSegment cardSegmentForMode2 = getCardSegmentForMode(PhoneOrEmailInputView.Mode.EMAIL);
        cardSegmentForMode2.setText(getString(R.string.email));
        cardSegmentForMode2.setContentDescription(getString(R.string.use_email));
    }

    private final void configureUI() {
        getBinding().d.b(this);
        StorePhone phone = StoreStream.INSTANCE.getPhone();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservationDeck.connectRx$default(ObservationDeck4.get(), new ObservationDeck.UpdateSource[]{phone}, false, null, null, new AnonymousClass1(phone), 14, null), this, null, 2, null), WidgetAuthRegisterIdentity.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass2(), 62, (Object) null);
        configurePhoneInput();
        configureSegmentControl();
        getBinding().d.requestFocus();
        LinkifiedTextView linkifiedTextView = getBinding().e;
        Intrinsics3.checkNotNullExpressionValue(linkifiedTextView, "binding.authRegisterIdentityPolicyLink");
        FormatUtils.n(linkifiedTextView, R.string.register_login_privacy_notice, new Object[]{getString(R.string.privacy_policy_url)}, null, 4);
        getBinding().f2237b.setOnClickListener(new AnonymousClass3());
    }

    private final WidgetAuthRegisterIdentityBinding getBinding() {
        return (WidgetAuthRegisterIdentityBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final CardSegment getCardSegmentForMode(PhoneOrEmailInputView.Mode mode) {
        if (mode == PhoneOrEmailInputView.Mode.PHONE) {
            CardSegment cardSegment = getBinding().c;
            Intrinsics3.checkNotNullExpressionValue(cardSegment, "binding.authRegisterIdentityFirstSegmentCard");
            return cardSegment;
        }
        CardSegment cardSegment2 = getBinding().f;
        Intrinsics3.checkNotNullExpressionValue(cardSegment2, "binding.authRegisterIdentitySecondSegmentCard");
        return cardSegment2;
    }

    private final ValidationManager getEmailValidationManager() {
        return (ValidationManager) this.emailValidationManager.getValue();
    }

    private final ValidationManager getPhoneValidationManager() {
        return (ValidationManager) this.phoneValidationManager.getValue();
    }

    private final void handleNext() {
        if (this.inputMode == PhoneOrEmailInputView.Mode.EMAIL) {
            if (!this.shouldValidateInputs || ValidationManager.validate$default(getEmailValidationManager(), false, 1, null)) {
                registerViaEmail();
                return;
            } else {
                RegistrationFlowRepo.trackTransition$default(RegistrationFlowRepo.INSTANCE.getINSTANCE(), "Account Identity", "input_error", null, 4, null);
                return;
            }
        }
        if (!this.shouldValidateInputs || ValidationManager.validate$default(getPhoneValidationManager(), false, 1, null)) {
            registerViaPhone$default(this, null, 1, null);
        } else {
            RegistrationFlowRepo.trackTransition$default(RegistrationFlowRepo.INSTANCE.getINSTANCE(), "Account Identity", "input_error", null, 4, null);
        }
    }

    private final void registerViaEmail() {
        RegistrationFlowRepo.Companion companion = RegistrationFlowRepo.INSTANCE;
        companion.getINSTANCE().setEmail(getBinding().d.getTextOrEmpty());
        RegistrationFlowRepo.trackTransition$default(companion.getINSTANCE(), "Account Identity", "success", null, 4, null);
        AppScreen2.e(requireContext(), WidgetAuthRegisterAccountInformation.class, null, 4);
    }

    private final void registerViaPhone(CaptchaHelper.CaptchaPayload captchaPayload) {
        String textOrEmpty = getBinding().d.getTextOrEmpty();
        RegistrationFlowRepo.INSTANCE.getINSTANCE().setPhone(textOrEmpty);
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.withDimmer$default(ObservableExtensionsKt.ui$default(RestCallState5.logNetworkAction(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.INSTANCE.getApi().postAuthRegisterPhone(new RestAPIParams.AuthRegisterPhone(textOrEmpty, captchaPayload != null ? captchaPayload.getCaptchaKey() : null, captchaPayload != null ? captchaPayload.getCaptchaRqtoken() : null)), false, 1, null), AnonymousClass1.INSTANCE), this, null, 2, null), getBinding().h, 0L, 2, null), WidgetAuthRegisterIdentity.class, getContext(), (Function1) null, new AnonymousClass3(), (Function0) null, (Function0) null, new AnonymousClass2(textOrEmpty), 52, (Object) null);
    }

    public static /* synthetic */ void registerViaPhone$default(WidgetAuthRegisterIdentity widgetAuthRegisterIdentity, CaptchaHelper.CaptchaPayload captchaPayload, int i, Object obj) {
        if ((i & 1) != 0) {
            captchaPayload = null;
        }
        widgetAuthRegisterIdentity.registerViaPhone(captchaPayload);
    }

    private final void setInputMode(PhoneOrEmailInputView.Mode newInputMode) {
        if (this.inputMode == newInputMode) {
            return;
        }
        this.inputMode = newInputMode;
        getBinding().d.getMainTextInputLayout().setError(null);
        configurePhoneInput();
    }

    @Override // com.discord.app.AppFragment, com.discord.app.AppLogger.a
    public AppLogger2 getLoggingConfig() {
        return this.loggingConfig;
    }

    @Override // com.discord.app.AppFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        configureUI();
        Map<String, List<String>> errors = RegistrationFlowRepo.INSTANCE.getINSTANCE().getErrors();
        if (errors != null) {
            getEmailValidationManager().setErrors(errors);
            Set<String> setKeySet = errors.keySet();
            ArrayList arrayList = new ArrayList();
            Iterator<T> it = setKeySet.iterator();
            while (true) {
                boolean z2 = true;
                if (!it.hasNext()) {
                    break;
                }
                Object next = it.next();
                String str = (String) next;
                if (!Intrinsics3.areEqual(str, NotificationCompat.CATEGORY_EMAIL) && !Intrinsics3.areEqual(str, "phone")) {
                    z2 = false;
                }
                if (z2) {
                    arrayList.add(next);
                }
            }
            List<String> list = _Collections.toList(arrayList);
            if (!list.isEmpty()) {
                RegistrationFlowRepo.INSTANCE.getINSTANCE().trackTransition("Account Identity", "response_error", list);
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle outState) {
        Intrinsics3.checkNotNullParameter(outState, "outState");
        super.onSaveInstanceState(outState);
        outState.putBoolean(IS_PHONE_MODE, this.inputMode == PhoneOrEmailInputView.Mode.PHONE);
    }

    @Override // com.discord.app.AppFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        this.inputMode = (savedInstanceState == null || savedInstanceState.getBoolean(IS_PHONE_MODE)) ? PhoneOrEmailInputView.Mode.PHONE : PhoneOrEmailInputView.Mode.EMAIL;
        RegistrationFlowRepo.trackTransition$default(RegistrationFlowRepo.INSTANCE.getINSTANCE(), "Account Identity", "submitted", null, 4, null);
        StoreStream.Companion companion = StoreStream.INSTANCE;
        boolean z2 = true;
        Experiment userExperiment = companion.getExperiments().getUserExperiment("2021-01_android_registration_flow", true);
        if ((userExperiment != null && userExperiment.getBucket() == 1) || (userExperiment != null && userExperiment.getBucket() == 3)) {
            z2 = false;
        }
        this.shouldValidateInputs = z2;
        configureUI();
        companion.getInviteSettings().trackWithInvite$app_productionGoogleRelease(WidgetAuthRegisterIdentity.class, AnonymousClass1.INSTANCE);
    }
}
