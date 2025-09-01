package com.discord.widgets.user;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.core.app.NotificationCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import b.a.d.AppScreen2;
import b.a.d.AppToast;
import b.a.d.o;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.api.user.User;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetUserPasswordVerifyBinding;
import com.discord.restapi.RestAPIParams;
import com.discord.stores.StoreStream;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.utilities.auth.GoogleSmartLockManager;
import com.discord.utilities.auth.GoogleSmartLockManager3;
import com.discord.utilities.error.Error;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.stateful.StatefulViews;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.view.validators.ValidationManager;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.widgets.settings.account.WidgetSettingsAccountChangePassword;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputLayout;
import d0.LazyJVM;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import rx.functions.Action1;

/* compiled from: WidgetUserPasswordVerify.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 %2\u00020\u0001:\u0001%B\u0007¢\u0006\u0004\b$\u0010\u0004J\u000f\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\t\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\t\u0010\bJ\u0017\u0010\n\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\n\u0010\bJ\u000f\u0010\u000b\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u000b\u0010\u0004J\u0017\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0013\u0010\u0014R\u001d\u0010\u001a\u001a\u00020\u00158B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u001d\u0010 \u001a\u00020\u001b8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u0016\u0010\"\u001a\u00020!8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\"\u0010#¨\u0006&"}, d2 = {"Lcom/discord/widgets/user/WidgetUserPasswordVerify;", "Lcom/discord/app/AppFragment;", "", "saveInfo", "()V", "", WidgetSettingsAccountChangePassword.CURRENT_PASSWORD_FIELD, "updateAccountInfo", "(Ljava/lang/String;)V", "removePhoneNumber", "updatePhoneNumber", "finishWithSuccess", "Lcom/discord/utilities/error/Error;", "error", "", "maybeHandleApiError", "(Lcom/discord/utilities/error/Error;)Z", "Landroid/view/View;", "view", "onViewBound", "(Landroid/view/View;)V", "Lcom/discord/databinding/WidgetUserPasswordVerifyBinding;", "binding$delegate", "Lcom/discord/utilities/viewbinding/FragmentViewBindingDelegate;", "getBinding", "()Lcom/discord/databinding/WidgetUserPasswordVerifyBinding;", "binding", "Lcom/discord/utilities/view/validators/ValidationManager;", "validationManager$delegate", "Lkotlin/Lazy;", "getValidationManager", "()Lcom/discord/utilities/view/validators/ValidationManager;", "validationManager", "Lcom/discord/utilities/stateful/StatefulViews;", "state", "Lcom/discord/utilities/stateful/StatefulViews;", "<init>", "Companion", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final class WidgetUserPasswordVerify extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetUserPasswordVerify.class, "binding", "getBinding()Lcom/discord/databinding/WidgetUserPasswordVerifyBinding;", 0)};

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String INTENT_EXTRA_ACTION = "INTENT_EXTRA_ACTION";
    private static final String INTENT_EXTRA_DISCRIMINATOR = "INTENT_EXTRA_DISCRIMINATOR";
    private static final String INTENT_EXTRA_EMAIL = "INTENT_EXTRA_EMAIL";
    private static final String INTENT_EXTRA_EMAIL_TOKEN = "INTENT_EXTRA_EMAIL_TOKEN";
    private static final String INTENT_EXTRA_PHONE_TOKEN = "INTENT_EXTRA_PHONE_TOKEN";
    private static final String INTENT_EXTRA_SOURCE_TYPE = "INTENT_EXTRA_SOURCE_TYPE";
    private static final String INTENT_EXTRA_USERNAME = "INTENT_EXTRA_USERNAME";

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private final StatefulViews state;

    /* renamed from: validationManager$delegate, reason: from kotlin metadata */
    private final Lazy validationManager;

    /* compiled from: WidgetUserPasswordVerify.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0086\u0003\u0018\u00002\u00020\u0001:\u0001)B\t\b\u0002¢\u0006\u0004\b'\u0010(J-\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\n\u0010\u000bJ#\u0010\f\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\f\u0010\rJ3\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000e¢\u0006\u0004\b\u0011\u0010\u0012JS\u0010\u0017\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\u0017\u0010\u0018J)\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u001a\u001a\u00020\u00192\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\t0\u001b¢\u0006\u0004\b\u001d\u0010\u001eR\u0016\u0010\u001f\u001a\u00020\u000e8\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010!\u001a\u00020\u000e8\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b!\u0010 R\u0016\u0010\"\u001a\u00020\u000e8\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\"\u0010 R\u0016\u0010#\u001a\u00020\u000e8\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b#\u0010 R\u0016\u0010$\u001a\u00020\u000e8\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b$\u0010 R\u0016\u0010%\u001a\u00020\u000e8\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b%\u0010 R\u0016\u0010&\u001a\u00020\u000e8\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b&\u0010 ¨\u0006*"}, d2 = {"Lcom/discord/widgets/user/WidgetUserPasswordVerify$Companion;", "", "Landroid/content/Context;", "context", "Landroidx/activity/result/ActivityResultLauncher;", "Landroid/content/Intent;", "launcher", "Landroid/os/Bundle;", NotificationCompat.MessagingStyle.Message.KEY_EXTRAS_BUNDLE, "", "launch", "(Landroid/content/Context;Landroidx/activity/result/ActivityResultLauncher;Landroid/os/Bundle;)V", "launchRemovePhoneNumber", "(Landroid/content/Context;Landroidx/activity/result/ActivityResultLauncher;)V", "", "phoneToken", "source", "launchUpdatePhoneNumber", "(Landroid/content/Context;Landroidx/activity/result/ActivityResultLauncher;Ljava/lang/String;Ljava/lang/String;)V", NotificationCompat.CATEGORY_EMAIL, "username", "discriminator", "email_token", "launchUpdateAccountSettings", "(Landroid/content/Context;Landroidx/activity/result/ActivityResultLauncher;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "Lcom/discord/app/AppFragment;", "fragment", "Lkotlin/Function0;", "callback", "registerForResult", "(Lcom/discord/app/AppFragment;Lkotlin/jvm/functions/Function0;)Landroidx/activity/result/ActivityResultLauncher;", WidgetUserPasswordVerify.INTENT_EXTRA_ACTION, "Ljava/lang/String;", WidgetUserPasswordVerify.INTENT_EXTRA_DISCRIMINATOR, WidgetUserPasswordVerify.INTENT_EXTRA_EMAIL, WidgetUserPasswordVerify.INTENT_EXTRA_EMAIL_TOKEN, WidgetUserPasswordVerify.INTENT_EXTRA_PHONE_TOKEN, WidgetUserPasswordVerify.INTENT_EXTRA_SOURCE_TYPE, WidgetUserPasswordVerify.INTENT_EXTRA_USERNAME, "<init>", "()V", "Action", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {

        /* compiled from: WidgetUserPasswordVerify.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/discord/widgets/user/WidgetUserPasswordVerify$Companion$Action;", "", "<init>", "(Ljava/lang/String;I)V", "UpdateAccountInfo", "RemovePhoneNumber", "UpdatePhoneNumber", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public enum Action {
            UpdateAccountInfo,
            RemovePhoneNumber,
            UpdatePhoneNumber
        }

        private Companion() {
        }

        private final void launch(Context context, ActivityResultLauncher<Intent> launcher, Bundle extras) {
            AnalyticsTracker.openModal$default("Account Settings Password Verification", "", null, 4, null);
            AppScreen2.g.f(context, launcher, WidgetUserPasswordVerify.class, new Intent().putExtras(extras));
        }

        public static /* synthetic */ void launchUpdateAccountSettings$default(Companion companion, Context context, ActivityResultLauncher activityResultLauncher, String str, String str2, String str3, String str4, int i, Object obj) {
            companion.launchUpdateAccountSettings(context, activityResultLauncher, (i & 4) != 0 ? null : str, (i & 8) != 0 ? null : str2, (i & 16) != 0 ? null : str3, (i & 32) != 0 ? null : str4);
        }

        public final void launchRemovePhoneNumber(Context context, ActivityResultLauncher<Intent> launcher) {
            Intrinsics3.checkNotNullParameter(context, "context");
            Intrinsics3.checkNotNullParameter(launcher, "launcher");
            Bundle bundle = new Bundle();
            bundle.putSerializable(WidgetUserPasswordVerify.INTENT_EXTRA_ACTION, Action.RemovePhoneNumber);
            launch(context, launcher, bundle);
        }

        public final void launchUpdateAccountSettings(Context context, ActivityResultLauncher<Intent> launcher, String email, String username, String discriminator, String email_token) {
            Intrinsics3.checkNotNullParameter(context, "context");
            Intrinsics3.checkNotNullParameter(launcher, "launcher");
            Bundle bundle = new Bundle();
            bundle.putSerializable(WidgetUserPasswordVerify.INTENT_EXTRA_ACTION, Action.UpdateAccountInfo);
            bundle.putString(WidgetUserPasswordVerify.INTENT_EXTRA_EMAIL, email);
            bundle.putString(WidgetUserPasswordVerify.INTENT_EXTRA_USERNAME, username);
            bundle.putString(WidgetUserPasswordVerify.INTENT_EXTRA_DISCRIMINATOR, discriminator);
            bundle.putString(WidgetUserPasswordVerify.INTENT_EXTRA_EMAIL_TOKEN, email_token);
            launch(context, launcher, bundle);
        }

        public final void launchUpdatePhoneNumber(Context context, ActivityResultLauncher<Intent> launcher, String phoneToken, String source) {
            Intrinsics3.checkNotNullParameter(context, "context");
            Intrinsics3.checkNotNullParameter(launcher, "launcher");
            Intrinsics3.checkNotNullParameter(phoneToken, "phoneToken");
            Intrinsics3.checkNotNullParameter(source, "source");
            Bundle bundle = new Bundle();
            bundle.putSerializable(WidgetUserPasswordVerify.INTENT_EXTRA_ACTION, Action.UpdatePhoneNumber);
            bundle.putString(WidgetUserPasswordVerify.INTENT_EXTRA_PHONE_TOKEN, phoneToken);
            bundle.putString(WidgetUserPasswordVerify.INTENT_EXTRA_SOURCE_TYPE, source);
            launch(context, launcher, bundle);
        }

        public final ActivityResultLauncher<Intent> registerForResult(AppFragment fragment, Function0<Unit> callback) {
            Intrinsics3.checkNotNullParameter(fragment, "fragment");
            Intrinsics3.checkNotNullParameter(callback, "callback");
            ActivityResultLauncher<Intent> activityResultLauncherRegisterForActivityResult = fragment.registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new WidgetUserPasswordVerify2(callback));
            Intrinsics3.checkNotNullExpressionValue(activityResultLauncherRegisterForActivityResult, "fragment.registerForActi…k()\n          }\n        }");
            return activityResultLauncherRegisterForActivityResult;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            Companion.Action.values();
            int[] iArr = new int[3];
            $EnumSwitchMapping$0 = iArr;
            iArr[Companion.Action.UpdateAccountInfo.ordinal()] = 1;
            iArr[Companion.Action.RemovePhoneNumber.ordinal()] = 2;
            iArr[Companion.Action.UpdatePhoneNumber.ordinal()] = 3;
        }
    }

    /* compiled from: WidgetUserPasswordVerify.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/widget/TextView;", "it", "", "invoke", "(Landroid/widget/TextView;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.user.WidgetUserPasswordVerify$onViewBound$1, reason: invalid class name */
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
            WidgetUserPasswordVerify.access$saveInfo(WidgetUserPasswordVerify.this);
        }
    }

    /* compiled from: WidgetUserPasswordVerify.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.user.WidgetUserPasswordVerify$onViewBound$2, reason: invalid class name */
    public static final class AnonymousClass2 implements View.OnClickListener {
        public AnonymousClass2() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetUserPasswordVerify.access$saveInfo(WidgetUserPasswordVerify.this);
        }
    }

    /* compiled from: WidgetUserPasswordVerify.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Ljava/lang/Void;", "it", "", NotificationCompat.CATEGORY_CALL, "(Ljava/lang/Void;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.user.WidgetUserPasswordVerify$removePhoneNumber$1, reason: invalid class name */
    public static final class AnonymousClass1<T> implements Action1<Void> {
        public AnonymousClass1() {
        }

        @Override // rx.functions.Action1
        public /* bridge */ /* synthetic */ void call(Void r1) {
            call2(r1);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final void call2(Void r1) {
            WidgetUserPasswordVerify.access$finishWithSuccess(WidgetUserPasswordVerify.this);
        }
    }

    /* compiled from: WidgetUserPasswordVerify.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/discord/utilities/error/Error;", "kotlin.jvm.PlatformType", "it", "", NotificationCompat.CATEGORY_CALL, "(Lcom/discord/utilities/error/Error;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.user.WidgetUserPasswordVerify$removePhoneNumber$2, reason: invalid class name */
    public static final class AnonymousClass2<T> implements Action1<Error> {
        public AnonymousClass2() {
        }

        @Override // rx.functions.Action1
        public /* bridge */ /* synthetic */ void call(Error error) {
            call2(error);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final void call2(Error error) {
            WidgetUserPasswordVerify widgetUserPasswordVerify = WidgetUserPasswordVerify.this;
            Intrinsics3.checkNotNullExpressionValue(error, "it");
            error.setShowErrorToasts(!WidgetUserPasswordVerify.access$maybeHandleApiError(widgetUserPasswordVerify, error));
        }
    }

    /* compiled from: WidgetUserPasswordVerify.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/discord/api/user/User;", "kotlin.jvm.PlatformType", "updatedUser", "", NotificationCompat.CATEGORY_CALL, "(Lcom/discord/api/user/User;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.user.WidgetUserPasswordVerify$updateAccountInfo$1, reason: invalid class name */
    public static final class AnonymousClass1<T> implements Action1<User> {
        public final /* synthetic */ String $newEmail;
        public final /* synthetic */ String $password;

        public AnonymousClass1(String str, String str2) {
            this.$newEmail = str;
            this.$password = str2;
        }

        @Override // rx.functions.Action1
        public /* bridge */ /* synthetic */ void call(User user) {
            call2(user);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final void call2(User user) {
            GoogleSmartLockManager googleSmartLockManager;
            StoreStream.INSTANCE.getAuthentication().setAuthed(user.getToken());
            Context context = WidgetUserPasswordVerify.this.getContext();
            if (context != null && (googleSmartLockManager = GoogleSmartLockManager3.googleSmartLockManager(context)) != null) {
                googleSmartLockManager.updateAccountInfo(this.$newEmail, this.$password);
            }
            WidgetUserPasswordVerify.access$finishWithSuccess(WidgetUserPasswordVerify.this);
        }
    }

    /* compiled from: WidgetUserPasswordVerify.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/discord/utilities/error/Error;", "kotlin.jvm.PlatformType", "it", "", NotificationCompat.CATEGORY_CALL, "(Lcom/discord/utilities/error/Error;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.user.WidgetUserPasswordVerify$updateAccountInfo$2, reason: invalid class name */
    public static final class AnonymousClass2<T> implements Action1<Error> {
        public AnonymousClass2() {
        }

        @Override // rx.functions.Action1
        public /* bridge */ /* synthetic */ void call(Error error) {
            call2(error);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final void call2(Error error) {
            WidgetUserPasswordVerify widgetUserPasswordVerify = WidgetUserPasswordVerify.this;
            Intrinsics3.checkNotNullExpressionValue(error, "it");
            error.setShowErrorToasts(!WidgetUserPasswordVerify.access$maybeHandleApiError(widgetUserPasswordVerify, error));
        }
    }

    /* compiled from: WidgetUserPasswordVerify.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Ljava/lang/Void;", "it", "", NotificationCompat.CATEGORY_CALL, "(Ljava/lang/Void;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.user.WidgetUserPasswordVerify$updatePhoneNumber$1, reason: invalid class name */
    public static final class AnonymousClass1<T> implements Action1<Void> {
        public AnonymousClass1() {
        }

        @Override // rx.functions.Action1
        public /* bridge */ /* synthetic */ void call(Void r1) {
            call2(r1);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final void call2(Void r1) {
            WidgetUserPasswordVerify.access$finishWithSuccess(WidgetUserPasswordVerify.this);
        }
    }

    /* compiled from: WidgetUserPasswordVerify.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/discord/utilities/error/Error;", "kotlin.jvm.PlatformType", "it", "", NotificationCompat.CATEGORY_CALL, "(Lcom/discord/utilities/error/Error;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.user.WidgetUserPasswordVerify$updatePhoneNumber$2, reason: invalid class name */
    public static final class AnonymousClass2<T> implements Action1<Error> {
        public AnonymousClass2() {
        }

        @Override // rx.functions.Action1
        public /* bridge */ /* synthetic */ void call(Error error) {
            call2(error);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final void call2(Error error) {
            WidgetUserPasswordVerify widgetUserPasswordVerify = WidgetUserPasswordVerify.this;
            Intrinsics3.checkNotNullExpressionValue(error, "it");
            error.setShowErrorToasts(!WidgetUserPasswordVerify.access$maybeHandleApiError(widgetUserPasswordVerify, error));
        }
    }

    public WidgetUserPasswordVerify() {
        super(R.layout.widget_user_password_verify);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetUserPasswordVerify3.INSTANCE, null, 2, null);
        this.state = new StatefulViews(R.id.edit_account_password_wrap);
        this.validationManager = LazyJVM.lazy(new WidgetUserPasswordVerify4(this));
    }

    public static final /* synthetic */ void access$finishWithSuccess(WidgetUserPasswordVerify widgetUserPasswordVerify) {
        widgetUserPasswordVerify.finishWithSuccess();
    }

    public static final /* synthetic */ WidgetUserPasswordVerifyBinding access$getBinding$p(WidgetUserPasswordVerify widgetUserPasswordVerify) {
        return widgetUserPasswordVerify.getBinding();
    }

    public static final /* synthetic */ boolean access$maybeHandleApiError(WidgetUserPasswordVerify widgetUserPasswordVerify, Error error) {
        return widgetUserPasswordVerify.maybeHandleApiError(error);
    }

    public static final /* synthetic */ void access$saveInfo(WidgetUserPasswordVerify widgetUserPasswordVerify) {
        widgetUserPasswordVerify.saveInfo();
    }

    private final void finishWithSuccess() {
        StatefulViews.clear$default(this.state, false, 1, null);
        AppToast.i(this, R.string.saved_settings, 0, 4);
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.setResult(-1);
        }
        FragmentActivity activity2 = getActivity();
        if (activity2 != null) {
            activity2.onBackPressed();
        }
    }

    private final WidgetUserPasswordVerifyBinding getBinding() {
        return (WidgetUserPasswordVerifyBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final ValidationManager getValidationManager() {
        return (ValidationManager) this.validationManager.getValue();
    }

    private final boolean maybeHandleApiError(Error error) {
        if (error.getType() != Error.Type.DISCORD_BAD_REQUEST) {
            return false;
        }
        ValidationManager validationManager = getValidationManager();
        Error.Response response = error.getResponse();
        Intrinsics3.checkNotNullExpressionValue(response, "error.response");
        Map<String, List<String>> messages = response.getMessages();
        Intrinsics3.checkNotNullExpressionValue(messages, "error.response.messages");
        return validationManager.setErrors(messages).isEmpty();
    }

    private final void removePhoneNumber(String password) {
        ObservableExtensionsKt.withDimmer$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.INSTANCE.getApi().userPhoneDelete(new RestAPIParams.DeletePhone(password)), false, 1, null), this, null, 2, null), getBinding().f2686b, 0L, 2, null).k(o.h(new AnonymousClass1(), getContext(), new AnonymousClass2()));
    }

    private final void saveInfo() {
        if (ValidationManager.validate$default(getValidationManager(), false, 1, null)) {
            AppFragment.hideKeyboard$default(this, null, 1, null);
            TextInputLayout textInputLayout = getBinding().c;
            Intrinsics3.checkNotNullExpressionValue(textInputLayout, "binding.editAccountPasswordWrap");
            String textOrEmpty = ViewExtensions.getTextOrEmpty(textInputLayout);
            Serializable serializableExtra = getMostRecentIntent().getSerializableExtra(INTENT_EXTRA_ACTION);
            Objects.requireNonNull(serializableExtra, "null cannot be cast to non-null type com.discord.widgets.user.WidgetUserPasswordVerify.Companion.Action");
            int iOrdinal = ((Companion.Action) serializableExtra).ordinal();
            if (iOrdinal == 0) {
                updateAccountInfo(textOrEmpty);
            } else if (iOrdinal == 1) {
                removePhoneNumber(textOrEmpty);
            } else {
                if (iOrdinal != 2) {
                    return;
                }
                updatePhoneNumber(textOrEmpty);
            }
        }
    }

    private final void updateAccountInfo(String password) {
        String stringExtra = getMostRecentIntent().getStringExtra(INTENT_EXTRA_USERNAME);
        String stringExtra2 = getMostRecentIntent().getStringExtra(INTENT_EXTRA_DISCRIMINATOR);
        String stringExtra3 = getMostRecentIntent().getStringExtra(INTENT_EXTRA_EMAIL);
        ObservableExtensionsKt.withDimmer$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.INSTANCE.getApi().patchUser(new RestAPIParams.UserInfo(null, stringExtra3, getMostRecentIntent().getStringExtra(INTENT_EXTRA_EMAIL_TOKEN), password, null, stringExtra, StoreStream.INSTANCE.getNotifications().getPushToken(), null, stringExtra2, null, null, 1681, null)), false, 1, null), this, null, 2, null), getBinding().f2686b, 0L, 2, null).k(o.h(new AnonymousClass1(stringExtra3, password), getContext(), new AnonymousClass2()));
    }

    private final void updatePhoneNumber(String password) {
        String stringExtra = getMostRecentIntent().getStringExtra(INTENT_EXTRA_PHONE_TOKEN);
        Intrinsics3.checkNotNull(stringExtra);
        Intrinsics3.checkNotNullExpressionValue(stringExtra, "mostRecentIntent.getStri…TENT_EXTRA_PHONE_TOKEN)!!");
        String stringExtra2 = getMostRecentIntent().getStringExtra(INTENT_EXTRA_SOURCE_TYPE);
        Intrinsics3.checkNotNull(stringExtra2);
        Intrinsics3.checkNotNullExpressionValue(stringExtra2, "mostRecentIntent.getStri…TENT_EXTRA_SOURCE_TYPE)!!");
        ObservableExtensionsKt.withDimmer$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.INSTANCE.getApi().userPhoneWithToken(new RestAPIParams.VerificationPhoneCode(stringExtra, password, stringExtra2)), false, 1, null), this, null, 2, null), getBinding().f2686b, 0L, 2, null).k(o.h(new AnonymousClass1(), getContext(), new AnonymousClass2()));
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        setActionBarSubtitle(R.string.user_settings);
        setActionBarTitle(R.string.user_settings_account_verify_password_title_in_title_case);
        AppFragment.setActionBarDisplayHomeAsUpEnabled$default(this, false, 1, null);
        StatefulViews statefulViews = this.state;
        FloatingActionButton floatingActionButton = getBinding().d;
        TextInputLayout textInputLayout = getBinding().c;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout, "binding.editAccountPasswordWrap");
        statefulViews.setupTextWatcherWithSaveAction(this, floatingActionButton, textInputLayout);
        TextInputLayout textInputLayout2 = getBinding().c;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout2, "binding.editAccountPasswordWrap");
        ViewExtensions.setOnImeActionDone$default(textInputLayout2, false, new AnonymousClass1(), 1, null);
        getBinding().d.setOnClickListener(new AnonymousClass2());
    }
}
