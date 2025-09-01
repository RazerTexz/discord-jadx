package com.discord.widgets.user.phone;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.view.View;
import android.widget.TextView;
import androidx.activity.result.ActivityResultLauncher;
import androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import b.a.d.AppScreen2;
import b.a.k.FormatUtils;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.databinding.WidgetUserPhoneManageBinding;
import com.discord.models.phone.PhoneCountryCode;
import com.discord.models.user.MeUser;
import com.discord.restapi.RestAPIParams;
import com.discord.stores.StorePhone;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUser;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeck4;
import com.discord.utilities.captcha.CaptchaHelper;
import com.discord.utilities.drawable.DrawableCompat;
import com.discord.utilities.error.Error;
import com.discord.utilities.features.GrowthTeamFeatures;
import com.discord.utilities.intent.IntentUtilsKt;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.user.UserUtils;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.widgets.captcha.WidgetCaptcha;
import com.discord.widgets.notice.WidgetNoticeDialog;
import com.discord.widgets.user.WidgetUserPasswordVerify;
import com.discord.widgets.user.account.WidgetUserAccountVerifyBase;
import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.button.MaterialButton;
import d0.Tuples;
import d0.g0.StringsJVM;
import d0.t.MapsJVM;
import d0.t._Collections;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.Collection;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;

/* compiled from: WidgetUserPhoneManage.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 #2\u00020\u0001:\u0001#B\u0007¢\u0006\u0004\b\"\u0010\bJ\u001b\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\r\u0010\bJ\u0017\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0012\u0010\bR\u001c\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u00138\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00140\u00138\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0016R\u001c\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00140\u00138\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0016R\u0016\u0010\u001a\u001a\u00020\u00198\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u001d\u0010!\u001a\u00020\u001c8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 ¨\u0006$"}, d2 = {"Lcom/discord/widgets/user/phone/WidgetUserPhoneManage;", "Lcom/discord/widgets/user/account/WidgetUserAccountVerifyBase;", "Lcom/discord/utilities/captcha/CaptchaHelper$CaptchaPayload;", "captchaPayload", "", "updatePhoneNumber", "(Lcom/discord/utilities/captcha/CaptchaHelper$CaptchaPayload;)V", "removePhoneNumber", "()V", "Lcom/discord/models/user/MeUser;", "meUser", "configureUI", "(Lcom/discord/models/user/MeUser;)V", "handlePhoneNumberTextChanged", "Landroid/view/View;", "view", "onViewBound", "(Landroid/view/View;)V", "onViewBoundOrOnResume", "Landroidx/activity/result/ActivityResultLauncher;", "Landroid/content/Intent;", "phoneVerificationLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "captchaLauncher", "passwordVerifyLauncher", "", "source", "Ljava/lang/String;", "Lcom/discord/databinding/WidgetUserPhoneManageBinding;", "binding$delegate", "Lcom/discord/utilities/viewbinding/FragmentViewBindingDelegate;", "getBinding", "()Lcom/discord/databinding/WidgetUserPhoneManageBinding;", "binding", "<init>", "Companion", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final class WidgetUserPhoneManage extends WidgetUserAccountVerifyBase {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetUserPhoneManage.class, "binding", "getBinding()Lcom/discord/databinding/WidgetUserPhoneManageBinding;", 0)};

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private final ActivityResultLauncher<Intent> captchaLauncher;
    private final ActivityResultLauncher<Intent> passwordVerifyLauncher;
    private final ActivityResultLauncher<Intent> phoneVerificationLauncher;
    private String source;

    /* compiled from: WidgetUserPhoneManage.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001:\u0001\rB\t\b\u0002¢\u0006\u0004\b\u000b\u0010\fJ%\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\n¨\u0006\u000e"}, d2 = {"Lcom/discord/widgets/user/phone/WidgetUserPhoneManage$Companion;", "", "Landroid/content/Context;", "context", "Lcom/discord/widgets/user/account/WidgetUserAccountVerifyBase$Mode;", "mode", "Lcom/discord/widgets/user/phone/WidgetUserPhoneManage$Companion$Source;", "source", "", "launch", "(Landroid/content/Context;Lcom/discord/widgets/user/account/WidgetUserAccountVerifyBase$Mode;Lcom/discord/widgets/user/phone/WidgetUserPhoneManage$Companion$Source;)V", "<init>", "()V", "Source", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {

        /* compiled from: WidgetUserPhoneManage.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\r\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0019\u0010\u0003\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u000f"}, d2 = {"Lcom/discord/widgets/user/phone/WidgetUserPhoneManage$Companion$Source;", "", "", "source", "Ljava/lang/String;", "getSource", "()Ljava/lang/String;", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "USER_ACTION_REQUIRED", "USER_SETTINGS_UPDATE", "GUILD_PHONE_REQUIRED", "MFA_PHONE_UPDATE", "CONTACT_SYNC", "DEFAULT", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public enum Source {
            USER_ACTION_REQUIRED("user_action_required"),
            USER_SETTINGS_UPDATE("user_settings_update"),
            GUILD_PHONE_REQUIRED("guild_phone_required"),
            MFA_PHONE_UPDATE("mfa_phone_update"),
            CONTACT_SYNC("contact_sync"),
            DEFAULT("update_phone");

            private final String source;

            Source(String str) {
                this.source = str;
            }

            public final String getSource() {
                return this.source;
            }
        }

        private Companion() {
        }

        public final void launch(Context context, WidgetUserAccountVerifyBase.Mode mode, Source source) {
            Intrinsics3.checkNotNullParameter(context, "context");
            Intrinsics3.checkNotNullParameter(mode, "mode");
            Intrinsics3.checkNotNullParameter(source, "source");
            Intent launchIntent = WidgetUserAccountVerifyBase.INSTANCE.getLaunchIntent(mode, true, false);
            if (mode == WidgetUserAccountVerifyBase.Mode.NO_HISTORY_FROM_USER_SETTINGS) {
                launchIntent.addFlags(BasicMeasure.EXACTLY);
            }
            launchIntent.putExtra("intent_args_key", source.getSource());
            AppScreen2.d(context, WidgetUserPhoneManage.class, launchIntent);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetUserPhoneManage.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lcom/discord/models/phone/PhoneCountryCode;", "invoke", "()Lcom/discord/models/phone/PhoneCountryCode;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.user.phone.WidgetUserPhoneManage$onViewBound$1, reason: invalid class name */
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

    /* compiled from: WidgetUserPhoneManage.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/models/phone/PhoneCountryCode;", "it", "", "invoke", "(Lcom/discord/models/phone/PhoneCountryCode;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.user.phone.WidgetUserPhoneManage$onViewBound$2, reason: invalid class name */
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
            WidgetUserPhoneManage.access$getBinding$p(WidgetUserPhoneManage.this).f.setCountryCode(phoneCountryCode);
        }
    }

    /* compiled from: WidgetUserPhoneManage.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.user.phone.WidgetUserPhoneManage$onViewBound$3, reason: invalid class name */
    public static final class AnonymousClass3 extends Lambda implements Function0<Unit> {
        public AnonymousClass3() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            WidgetUserPhoneManage.access$handlePhoneNumberTextChanged(WidgetUserPhoneManage.this);
        }
    }

    /* compiled from: WidgetUserPhoneManage.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.user.phone.WidgetUserPhoneManage$onViewBound$4, reason: invalid class name */
    public static final class AnonymousClass4 implements View.OnClickListener {
        public AnonymousClass4() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetUserPhoneManage.updatePhoneNumber$default(WidgetUserPhoneManage.this, null, 1, null);
        }
    }

    /* compiled from: WidgetUserPhoneManage.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.user.phone.WidgetUserPhoneManage$onViewBound$5, reason: invalid class name */
    public static final class AnonymousClass5 implements View.OnClickListener {
        public AnonymousClass5() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetUserPhoneManage.access$removePhoneNumber(WidgetUserPhoneManage.this);
        }
    }

    /* compiled from: WidgetUserPhoneManage.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/models/user/MeUser;", "it", "", "invoke", "(Lcom/discord/models/user/MeUser;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.user.phone.WidgetUserPhoneManage$onViewBoundOrOnResume$1, reason: invalid class name */
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
            WidgetUserPhoneManage.access$configureUI(WidgetUserPhoneManage.this, meUser);
        }
    }

    /* compiled from: WidgetUserPhoneManage.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/view/View;", "it", "", "invoke", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.user.phone.WidgetUserPhoneManage$removePhoneNumber$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<View, Unit> {
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
            WidgetUserPasswordVerify.INSTANCE.launchRemovePhoneNumber(WidgetUserPhoneManage.this.requireContext(), WidgetUserPhoneManage.access$getPasswordVerifyLauncher$p(WidgetUserPhoneManage.this));
        }
    }

    /* compiled from: WidgetUserPhoneManage.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/utilities/error/Error;", "error", "", "invoke", "(Lcom/discord/utilities/error/Error;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.user.phone.WidgetUserPhoneManage$updatePhoneNumber$1, reason: invalid class name */
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
            if (GrowthTeamFeatures.INSTANCE.isPhoneVerifyCaptchaEnabled()) {
                WidgetCaptcha.Companion companion = WidgetCaptcha.INSTANCE;
                Context contextRequireContext = WidgetUserPhoneManage.this.requireContext();
                ActivityResultLauncher<Intent> activityResultLauncherAccess$getCaptchaLauncher$p = WidgetUserPhoneManage.access$getCaptchaLauncher$p(WidgetUserPhoneManage.this);
                Error.Response response = error.getResponse();
                Intrinsics3.checkNotNullExpressionValue(response, "error.response");
                companion.processErrorsForCaptcha(contextRequireContext, activityResultLauncherAccess$getCaptchaLauncher$p, _Collections.toMutableList((Collection) response.getMessages().keySet()), error);
            }
        }
    }

    /* compiled from: WidgetUserPhoneManage.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Ljava/lang/Void;", "it", "", "invoke", "(Ljava/lang/Void;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.user.phone.WidgetUserPhoneManage$updatePhoneNumber$2, reason: invalid class name */
    public static final class AnonymousClass2 extends Lambda implements Function1<Void, Unit> {
        public final /* synthetic */ String $phoneNumber;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(String str) {
            super(1);
            this.$phoneNumber = str;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Void r1) {
            invoke2(r1);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Void r7) {
            WidgetUserPhoneVerify.INSTANCE.launch(WidgetUserPhoneManage.this.requireContext(), WidgetUserPhoneManage.access$getPhoneVerificationLauncher$p(WidgetUserPhoneManage.this), WidgetUserPhoneManage.access$getMode$p(WidgetUserPhoneManage.this), this.$phoneNumber, WidgetUserPhoneManage.access$getSource$p(WidgetUserPhoneManage.this));
        }
    }

    public WidgetUserPhoneManage() {
        super(R.layout.widget_user_phone_manage);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetUserPhoneManage2.INSTANCE, null, 2, null);
        this.passwordVerifyLauncher = WidgetUserPasswordVerify.INSTANCE.registerForResult(this, new WidgetUserPhoneManage4(this));
        this.phoneVerificationLauncher = WidgetUserPhoneVerify.INSTANCE.registerForResult(this, new WidgetUserPhoneManage5(this));
        this.captchaLauncher = WidgetCaptcha.INSTANCE.registerForResult(this, new WidgetUserPhoneManage3(this));
    }

    public static final /* synthetic */ void access$configureUI(WidgetUserPhoneManage widgetUserPhoneManage, MeUser meUser) {
        widgetUserPhoneManage.configureUI(meUser);
    }

    public static final /* synthetic */ WidgetUserPhoneManageBinding access$getBinding$p(WidgetUserPhoneManage widgetUserPhoneManage) {
        return widgetUserPhoneManage.getBinding();
    }

    public static final /* synthetic */ ActivityResultLauncher access$getCaptchaLauncher$p(WidgetUserPhoneManage widgetUserPhoneManage) {
        return widgetUserPhoneManage.captchaLauncher;
    }

    public static final /* synthetic */ WidgetUserAccountVerifyBase.Mode access$getMode$p(WidgetUserPhoneManage widgetUserPhoneManage) {
        return widgetUserPhoneManage.getMode();
    }

    public static final /* synthetic */ ActivityResultLauncher access$getPasswordVerifyLauncher$p(WidgetUserPhoneManage widgetUserPhoneManage) {
        return widgetUserPhoneManage.passwordVerifyLauncher;
    }

    public static final /* synthetic */ ActivityResultLauncher access$getPhoneVerificationLauncher$p(WidgetUserPhoneManage widgetUserPhoneManage) {
        return widgetUserPhoneManage.phoneVerificationLauncher;
    }

    public static final /* synthetic */ String access$getSource$p(WidgetUserPhoneManage widgetUserPhoneManage) {
        String str = widgetUserPhoneManage.source;
        if (str == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("source");
        }
        return str;
    }

    public static final /* synthetic */ void access$handlePhoneNumberTextChanged(WidgetUserPhoneManage widgetUserPhoneManage) {
        widgetUserPhoneManage.handlePhoneNumberTextChanged();
    }

    public static final /* synthetic */ void access$removePhoneNumber(WidgetUserPhoneManage widgetUserPhoneManage) {
        widgetUserPhoneManage.removePhoneNumber();
    }

    public static final /* synthetic */ void access$setMode$p(WidgetUserPhoneManage widgetUserPhoneManage, WidgetUserAccountVerifyBase.Mode mode) {
        widgetUserPhoneManage.setMode(mode);
    }

    public static final /* synthetic */ void access$setSource$p(WidgetUserPhoneManage widgetUserPhoneManage, String str) {
        widgetUserPhoneManage.source = str;
    }

    public static final /* synthetic */ void access$updatePhoneNumber(WidgetUserPhoneManage widgetUserPhoneManage, CaptchaHelper.CaptchaPayload captchaPayload) {
        widgetUserPhoneManage.updatePhoneNumber(captchaPayload);
    }

    private final void configureUI(MeUser meUser) {
        if (meUser.getPhoneNumber() != null) {
            getBinding().g.setText(R.string.phone_verification_update_title);
            TextView textView = getBinding().d;
            Intrinsics3.checkNotNullExpressionValue(textView, "binding.userPhoneAddDescriptionNote");
            FormatUtils.n(textView, R.string.phone_verification_current_phone, new Object[]{meUser.getPhoneNumber()}, null, 4);
            TextView textView2 = getBinding().c;
            Intrinsics3.checkNotNullExpressionValue(textView2, "binding.removePhone");
            textView2.setVisibility(0);
        } else {
            getBinding().g.setText(R.string.enter_phone_title);
            getBinding().d.setText(R.string.enter_phone_description);
            TextView textView3 = getBinding().c;
            Intrinsics3.checkNotNullExpressionValue(textView3, "binding.removePhone");
            textView3.setVisibility(8);
        }
        if (meUser.getEmail() == null) {
            TextView textView4 = getBinding().c;
            Intrinsics3.checkNotNullExpressionValue(textView4, "binding.removePhone");
            textView4.setVisibility(8);
        }
    }

    private final WidgetUserPhoneManageBinding getBinding() {
        return (WidgetUserPhoneManageBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final void handlePhoneNumberTextChanged() {
        String textOrEmpty = getBinding().f.getTextOrEmpty();
        MaterialButton materialButton = getBinding().e;
        Intrinsics3.checkNotNullExpressionValue(materialButton, "binding.userPhoneAddNext");
        materialButton.setEnabled((textOrEmpty.length() > 0) && StringsJVM.startsWith$default(textOrEmpty, BadgeDrawable.DEFAULT_EXCEED_MAX_BADGE_NUMBER_SUFFIX, false, 2, null));
    }

    private final void removePhoneNumber() {
        if (!UserUtils.INSTANCE.isMfaSMSEnabled(StoreStream.INSTANCE.getUsers().getMeSnapshot())) {
            WidgetUserPasswordVerify.INSTANCE.launchRemovePhoneNumber(requireContext(), this.passwordVerifyLauncher);
            return;
        }
        WidgetNoticeDialog.Companion companion = WidgetNoticeDialog.INSTANCE;
        FragmentManager parentFragmentManager = getParentFragmentManager();
        Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
        Resources resources = getResources();
        Intrinsics3.checkNotNullExpressionValue(resources, "resources");
        CharSequence charSequenceI = FormatUtils.i(resources, R.string.user_settings_account_remove_phone_number_warning_title, new Object[0], null, 4);
        Resources resources2 = getResources();
        Intrinsics3.checkNotNullExpressionValue(resources2, "resources");
        CharSequence charSequenceI2 = FormatUtils.i(resources2, R.string.user_settings_account_remove_phone_number_warning_body, new Object[0], null, 4);
        Resources resources3 = getResources();
        Intrinsics3.checkNotNullExpressionValue(resources3, "resources");
        CharSequence charSequenceI3 = FormatUtils.i(resources3, R.string.remove, new Object[0], null, 4);
        Resources resources4 = getResources();
        Intrinsics3.checkNotNullExpressionValue(resources4, "resources");
        WidgetNoticeDialog.Companion.show$default(companion, parentFragmentManager, charSequenceI, charSequenceI2, charSequenceI3, FormatUtils.i(resources4, R.string.cancel, new Object[0], null, 4), MapsJVM.mapOf(Tuples.to(Integer.valueOf(R.id.notice_ok), new AnonymousClass1())), null, null, null, Integer.valueOf(R.attr.notice_theme_positive_red), null, null, 0, null, 15808, null);
    }

    private final void updatePhoneNumber(CaptchaHelper.CaptchaPayload captchaPayload) {
        String textOrEmpty = getBinding().f.getTextOrEmpty();
        RestAPI api = RestAPI.INSTANCE.getApi();
        String str = this.source;
        if (str == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("source");
        }
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.withDimmer$default(ObservableExtensionsKt.restSubscribeOn$default(api.userAddPhone(new RestAPIParams.Phone(textOrEmpty, str, captchaPayload != null ? captchaPayload.getCaptchaKey() : null, captchaPayload != null ? captchaPayload.getCaptchaRqtoken() : null)), false, 1, null), getBinding().f2687b, 0L, 2, null), this, null, 2, null), WidgetUserPhoneManage.class, (Context) null, (Function1) null, new AnonymousClass1(), (Function0) null, (Function0) null, new AnonymousClass2(textOrEmpty), 54, (Object) null);
    }

    public static /* synthetic */ void updatePhoneNumber$default(WidgetUserPhoneManage widgetUserPhoneManage, CaptchaHelper.CaptchaPayload captchaPayload, int i, Object obj) {
        if ((i & 1) != 0) {
            captchaPayload = null;
        }
        widgetUserPhoneManage.updatePhoneNumber(captchaPayload);
    }

    @Override // com.discord.widgets.user.account.WidgetUserAccountVerifyBase, com.discord.app.AppFragment
    public void onViewBound(View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        setActionBarDisplayHomeAsUpEnabled(!isForced(), Integer.valueOf(DrawableCompat.getThemedDrawableRes$default(view, R.attr.ic_action_bar_close, 0, 2, (Object) null)), !isForced() ? Integer.valueOf(R.string.close) : null);
        this.source = IntentUtilsKt.getStringExtraOrDefault(getMostRecentIntent(), "intent_args_key", Companion.Source.DEFAULT.getSource());
        getBinding().f.b(this);
        StorePhone phone = StoreStream.INSTANCE.getPhone();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservationDeck.connectRx$default(ObservationDeck4.get(), new ObservationDeck.UpdateSource[]{phone}, false, null, null, new AnonymousClass1(phone), 14, null), this, null, 2, null), WidgetUserPhoneManage.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass2(), 62, (Object) null);
        getBinding().f.a(this, new AnonymousClass3());
        getBinding().e.setOnClickListener(new AnonymousClass4());
        getBinding().c.setOnClickListener(new AnonymousClass5());
    }

    @Override // com.discord.widgets.user.account.WidgetUserAccountVerifyBase, com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(StoreUser.observeMe$default(StoreStream.INSTANCE.getUsers(), false, 1, null), this, null, 2, null), WidgetUserPhoneManage.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(), 62, (Object) null);
    }
}
