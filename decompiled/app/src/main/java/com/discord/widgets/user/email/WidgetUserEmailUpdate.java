package com.discord.widgets.user.email;

import android.content.Context;
import android.content.Intent;
import android.text.Editable;
import android.util.Patterns;
import android.view.View;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.core.app.NotificationCompat;
import androidx.fragment.app.Fragment;
import b.a.d.AppScreen2;
import b.a.d.o;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.api.user.User;
import com.discord.app.AppActivity;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetUserEmailUpdateBinding;
import com.discord.restapi.RestAPIParams;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.widgets.user.account.WidgetUserAccountVerifyBase;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputLayout;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import rx.functions.Action1;

/* compiled from: WidgetUserEmailUpdate.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0007¢\u0006\u0004\b\u0010\u0010\u0004J\u000f\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0004J\u0017\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\b\u0010\tR\u001d\u0010\u000f\u001a\u00020\n8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e¨\u0006\u0012"}, d2 = {"Lcom/discord/widgets/user/email/WidgetUserEmailUpdate;", "Lcom/discord/widgets/user/account/WidgetUserAccountVerifyBase;", "", "handleTextChanged", "()V", "onEmailUpdated", "Landroid/view/View;", "view", "onViewBound", "(Landroid/view/View;)V", "Lcom/discord/databinding/WidgetUserEmailUpdateBinding;", "binding$delegate", "Lcom/discord/utilities/viewbinding/FragmentViewBindingDelegate;", "getBinding", "()Lcom/discord/databinding/WidgetUserEmailUpdateBinding;", "binding", "<init>", "Companion", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final class WidgetUserEmailUpdate extends WidgetUserAccountVerifyBase {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetUserEmailUpdate.class, "binding", "getBinding()Lcom/discord/databinding/WidgetUserEmailUpdateBinding;", 0)};

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* compiled from: WidgetUserEmailUpdate.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0012\u0010\u0013J/\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006¢\u0006\u0004\b\n\u0010\u000bJ)\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\r\u001a\u00020\f2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\t0\u000e¢\u0006\u0004\b\u0010\u0010\u0011¨\u0006\u0014"}, d2 = {"Lcom/discord/widgets/user/email/WidgetUserEmailUpdate$Companion;", "", "Landroid/content/Context;", "context", "Lcom/discord/widgets/user/account/WidgetUserAccountVerifyBase$Mode;", "mode", "Landroidx/activity/result/ActivityResultLauncher;", "Landroid/content/Intent;", "launcher", "", "launch", "(Landroid/content/Context;Lcom/discord/widgets/user/account/WidgetUserAccountVerifyBase$Mode;Landroidx/activity/result/ActivityResultLauncher;)V", "Lcom/discord/app/AppFragment;", "fragment", "Lkotlin/Function0;", "callback", "registerForResult", "(Lcom/discord/app/AppFragment;Lkotlin/jvm/functions/Function0;)Landroidx/activity/result/ActivityResultLauncher;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void launch$default(Companion companion, Context context, WidgetUserAccountVerifyBase.Mode mode, ActivityResultLauncher activityResultLauncher, int i, Object obj) {
            if ((i & 4) != 0) {
                activityResultLauncher = null;
            }
            companion.launch(context, mode, activityResultLauncher);
        }

        public final void launch(Context context, WidgetUserAccountVerifyBase.Mode mode, ActivityResultLauncher<Intent> launcher) {
            Intrinsics3.checkNotNullParameter(context, "context");
            Intrinsics3.checkNotNullParameter(mode, "mode");
            Intent launchIntent = WidgetUserAccountVerifyBase.INSTANCE.getLaunchIntent(mode, false, true);
            if (launcher != null) {
                AppScreen2.g.f(context, launcher, WidgetUserEmailUpdate.class, launchIntent);
            } else {
                AppScreen2.d(context, WidgetUserEmailUpdate.class, launchIntent);
            }
        }

        public final ActivityResultLauncher<Intent> registerForResult(AppFragment fragment, Function0<Unit> callback) {
            Intrinsics3.checkNotNullParameter(fragment, "fragment");
            Intrinsics3.checkNotNullParameter(callback, "callback");
            ActivityResultLauncher<Intent> activityResultLauncherRegisterForActivityResult = fragment.registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new WidgetUserEmailUpdate2(callback));
            Intrinsics3.checkNotNullExpressionValue(activityResultLauncherRegisterForActivityResult, "fragment.registerForActi…k()\n          }\n        }");
            return activityResultLauncherRegisterForActivityResult;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetUserEmailUpdate.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/text/Editable;", "it", "", "invoke", "(Landroid/text/Editable;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.user.email.WidgetUserEmailUpdate$onViewBound$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<Editable, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Editable editable) {
            invoke2(editable);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Editable editable) {
            Intrinsics3.checkNotNullParameter(editable, "it");
            WidgetUserEmailUpdate.access$handleTextChanged(WidgetUserEmailUpdate.this);
        }
    }

    /* compiled from: WidgetUserEmailUpdate.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/text/Editable;", "it", "", "invoke", "(Landroid/text/Editable;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.user.email.WidgetUserEmailUpdate$onViewBound$2, reason: invalid class name */
    public static final class AnonymousClass2 extends Lambda implements Function1<Editable, Unit> {
        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Editable editable) {
            invoke2(editable);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Editable editable) {
            Intrinsics3.checkNotNullParameter(editable, "it");
            WidgetUserEmailUpdate.access$handleTextChanged(WidgetUserEmailUpdate.this);
        }
    }

    /* compiled from: WidgetUserEmailUpdate.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.user.email.WidgetUserEmailUpdate$onViewBound$3, reason: invalid class name */
    public static final class AnonymousClass3 implements View.OnClickListener {

        /* compiled from: WidgetUserEmailUpdate.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/discord/api/user/User;", "kotlin.jvm.PlatformType", "it", "", NotificationCompat.CATEGORY_CALL, "(Lcom/discord/api/user/User;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
        /* renamed from: com.discord.widgets.user.email.WidgetUserEmailUpdate$onViewBound$3$1, reason: invalid class name */
        public static final class AnonymousClass1<T> implements Action1<User> {
            public AnonymousClass1() {
            }

            @Override // rx.functions.Action1
            public /* bridge */ /* synthetic */ void call(User user) {
                call2(user);
            }

            /* renamed from: call, reason: avoid collision after fix types in other method */
            public final void call2(User user) {
                WidgetUserEmailUpdate.access$onEmailUpdated(WidgetUserEmailUpdate.this);
            }
        }

        public AnonymousClass3() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            RestAPI api = RestAPI.INSTANCE.getApi();
            RestAPIParams.UserInfo.Companion companion = RestAPIParams.UserInfo.INSTANCE;
            TextInputLayout textInputLayout = WidgetUserEmailUpdate.access$getBinding$p(WidgetUserEmailUpdate.this).c;
            Intrinsics3.checkNotNullExpressionValue(textInputLayout, "binding.alertVerifyEmailChangeEmail");
            String textOrEmpty = ViewExtensions.getTextOrEmpty(textInputLayout);
            TextInputLayout textInputLayout2 = WidgetUserEmailUpdate.access$getBinding$p(WidgetUserEmailUpdate.this).d;
            Intrinsics3.checkNotNullExpressionValue(textInputLayout2, "binding.alertVerifyEmailChangePassword");
            ObservableExtensionsKt.ui$default(ObservableExtensionsKt.withDimmer$default(ObservableExtensionsKt.restSubscribeOn$default(api.patchUser(companion.createForEmail(textOrEmpty, ViewExtensions.getTextOrEmpty(textInputLayout2))), false, 1, null), WidgetUserEmailUpdate.access$getBinding$p(WidgetUserEmailUpdate.this).e, 0L, 2, null), WidgetUserEmailUpdate.this, null, 2, null).k(o.i(new AnonymousClass1(), WidgetUserEmailUpdate.this));
        }
    }

    public WidgetUserEmailUpdate() {
        super(R.layout.widget_user_email_update);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetUserEmailUpdate3.INSTANCE, null, 2, null);
    }

    public static final /* synthetic */ WidgetUserEmailUpdateBinding access$getBinding$p(WidgetUserEmailUpdate widgetUserEmailUpdate) {
        return widgetUserEmailUpdate.getBinding();
    }

    public static final /* synthetic */ void access$handleTextChanged(WidgetUserEmailUpdate widgetUserEmailUpdate) {
        widgetUserEmailUpdate.handleTextChanged();
    }

    public static final /* synthetic */ void access$onEmailUpdated(WidgetUserEmailUpdate widgetUserEmailUpdate) {
        widgetUserEmailUpdate.onEmailUpdated();
    }

    private final WidgetUserEmailUpdateBinding getBinding() {
        return (WidgetUserEmailUpdateBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0033  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void handleTextChanged() {
        boolean z2;
        TextInputLayout textInputLayout = getBinding().d;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout, "binding.alertVerifyEmailChangePassword");
        if (ViewExtensions.getTextOrEmpty(textInputLayout).length() >= 3) {
            Pattern pattern = Patterns.EMAIL_ADDRESS;
            TextInputLayout textInputLayout2 = getBinding().c;
            Intrinsics3.checkNotNullExpressionValue(textInputLayout2, "binding.alertVerifyEmailChangeEmail");
            z2 = pattern.matcher(ViewExtensions.getTextOrEmpty(textInputLayout2)).matches();
        }
        MaterialButton materialButton = getBinding().f2680b;
        Intrinsics3.checkNotNullExpressionValue(materialButton, "binding.alertVerifyEmailChange");
        materialButton.setEnabled(z2);
    }

    private final void onEmailUpdated() {
        AppActivity appActivity = getAppActivity();
        if (appActivity != null) {
            appActivity.setResult(-1);
        }
        AppActivity appActivity2 = getAppActivity();
        if (appActivity2 != null) {
            appActivity2.finish();
        }
    }

    @Override // com.discord.widgets.user.account.WidgetUserAccountVerifyBase, com.discord.app.AppFragment
    public void onViewBound(View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        AppFragment.setActionBarDisplayHomeAsUpEnabled$default(this, false, 1, null);
        TextInputLayout textInputLayout = getBinding().c;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout, "binding.alertVerifyEmailChangeEmail");
        ViewExtensions.addBindedTextWatcher(textInputLayout, this, new AnonymousClass1());
        TextInputLayout textInputLayout2 = getBinding().d;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout2, "binding.alertVerifyEmailChangePassword");
        ViewExtensions.addBindedTextWatcher(textInputLayout2, this, new AnonymousClass2());
        getBinding().f2680b.setOnClickListener(new AnonymousClass3());
    }
}
