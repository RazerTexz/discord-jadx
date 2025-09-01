package com.discord.widgets.user.account;

import android.content.Context;
import android.content.Intent;
import android.view.MenuItem;
import android.view.View;
import androidx.annotation.LayoutRes;
import androidx.core.app.NotificationCompat;
import androidx.fragment.app.FragmentActivity;
import b.a.d.AppScreen2;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.app.AppFragment;
import com.discord.app.AppLog;
import com.discord.models.requiredaction.RequiredAction;
import com.discord.models.user.MeUser;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUser;
import com.discord.utilities.logging.Logger;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.user.UserUtils;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;
import rx.functions.Action2;
import rx.functions.Func2;

/* compiled from: WidgetUserAccountVerifyBase.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0006\b&\u0018\u0000 )2\u00020\u0001:\u0002)*B\u0011\u0012\b\b\u0001\u0010&\u001a\u00020%¢\u0006\u0004\b'\u0010(J\u000f\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\tH\u0002¢\u0006\u0004\b\n\u0010\u000bJ'\u0010\u0010\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0016\u0010\u0004R\u0013\u0010\u0017\u001a\u00020\u00058F@\u0006¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\"\u0010\u0019\u001a\u00020\u00058\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u0019\u0010\u0018\"\u0004\b\u001b\u0010\bR\"\u0010\u001d\u001a\u00020\u001c8\u0004@\u0004X\u0084.¢\u0006\u0012\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\"\u0010#\u001a\u00020\u00058\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b#\u0010\u001a\u001a\u0004\b#\u0010\u0018\"\u0004\b$\u0010\b¨\u0006+"}, d2 = {"Lcom/discord/widgets/user/account/WidgetUserAccountVerifyBase;", "Lcom/discord/app/AppFragment;", "", "setOptionsMenu", "()V", "", "isAuthorized", "handleIsAuthorized", "(Z)V", "Lrx/Observable;", "getShouldDismissObservable", "()Lrx/Observable;", "isMissingPhone", "isMissingEmailOrUnverified", "Lcom/discord/models/requiredaction/RequiredAction;", "requiredAction", "computeShouldDismiss", "(ZZLcom/discord/models/requiredaction/RequiredAction;)Z", "Landroid/view/View;", "view", "onViewBound", "(Landroid/view/View;)V", "onViewBoundOrOnResume", "isForced", "()Z", "isEmailAllowed", "Z", "setEmailAllowed", "Lcom/discord/widgets/user/account/WidgetUserAccountVerifyBase$Mode;", "mode", "Lcom/discord/widgets/user/account/WidgetUserAccountVerifyBase$Mode;", "getMode", "()Lcom/discord/widgets/user/account/WidgetUserAccountVerifyBase$Mode;", "setMode", "(Lcom/discord/widgets/user/account/WidgetUserAccountVerifyBase$Mode;)V", "isPhoneAllowed", "setPhoneAllowed", "", "contentResId", "<init>", "(I)V", "Companion", "Mode", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public abstract class WidgetUserAccountVerifyBase extends AppFragment {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String INTENT_EMAIL_ALLOWED = "INTENT_EMAIL_ALLOWED";
    private static final String INTENT_MODE = "INTENT_MODE";
    private static final String INTENT_PHONE_ALLOWED = "INTENT_PHONE_ALLOWED";
    private boolean isEmailAllowed;
    private boolean isPhoneAllowed;
    public Mode mode;

    /* compiled from: WidgetUserAccountVerifyBase.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000f\u0010\u0010J'\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\b\u0010\tR\u0016\u0010\u000b\u001a\u00020\n8\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0016\u0010\r\u001a\u00020\n8\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\r\u0010\fR\u0016\u0010\u000e\u001a\u00020\n8\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000e\u0010\f¨\u0006\u0011"}, d2 = {"Lcom/discord/widgets/user/account/WidgetUserAccountVerifyBase$Companion;", "", "Lcom/discord/widgets/user/account/WidgetUserAccountVerifyBase$Mode;", "mode", "", "phoneAllowed", "emailAllowed", "Landroid/content/Intent;", "getLaunchIntent", "(Lcom/discord/widgets/user/account/WidgetUserAccountVerifyBase$Mode;ZZ)Landroid/content/Intent;", "", WidgetUserAccountVerifyBase.INTENT_EMAIL_ALLOWED, "Ljava/lang/String;", WidgetUserAccountVerifyBase.INTENT_MODE, WidgetUserAccountVerifyBase.INTENT_PHONE_ALLOWED, "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public final Intent getLaunchIntent(Mode mode, boolean phoneAllowed, boolean emailAllowed) {
            Intrinsics3.checkNotNullParameter(mode, "mode");
            Intent intent = new Intent();
            intent.putExtra(WidgetUserAccountVerifyBase.INTENT_PHONE_ALLOWED, phoneAllowed);
            intent.putExtra(WidgetUserAccountVerifyBase.INTENT_EMAIL_ALLOWED, emailAllowed);
            intent.putExtra(WidgetUserAccountVerifyBase.INTENT_MODE, mode.ordinal());
            return intent;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetUserAccountVerifyBase.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/discord/widgets/user/account/WidgetUserAccountVerifyBase$Mode;", "", "<init>", "(Ljava/lang/String;I)V", "UNFORCED", "FORCED", "NO_HISTORY_FROM_USER_SETTINGS", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public enum Mode {
        UNFORCED,
        FORCED,
        NO_HISTORY_FROM_USER_SETTINGS
    }

    /* compiled from: WidgetUserAccountVerifyBase.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\b\u001a\n \u0001*\u0004\u0018\u00010\u00050\u00052\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u00002\u000e\u0010\u0004\u001a\n \u0001*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"Lcom/discord/models/requiredaction/RequiredAction;", "kotlin.jvm.PlatformType", "requiredAction", "Lcom/discord/models/user/MeUser;", "me", "", NotificationCompat.CATEGORY_CALL, "(Lcom/discord/models/requiredaction/RequiredAction;Lcom/discord/models/user/MeUser;)Ljava/lang/Boolean;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.user.account.WidgetUserAccountVerifyBase$getShouldDismissObservable$1, reason: invalid class name */
    public static final class AnonymousClass1<T1, T2, R> implements Func2<RequiredAction, MeUser, Boolean> {
        public AnonymousClass1() {
        }

        @Override // rx.functions.Func2
        public /* bridge */ /* synthetic */ Boolean call(RequiredAction requiredAction, MeUser meUser) {
            return call2(requiredAction, meUser);
        }

        /* JADX WARN: Removed duplicated region for block: B:7:0x001a  */
        /* renamed from: call, reason: avoid collision after fix types in other method */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Boolean call2(RequiredAction requiredAction, MeUser meUser) {
            boolean z2;
            if (WidgetUserAccountVerifyBase.this.getIsPhoneAllowed()) {
                UserUtils userUtils = UserUtils.INSTANCE;
                Intrinsics3.checkNotNullExpressionValue(meUser, "me");
                z2 = !userUtils.getHasPhone(meUser);
            }
            boolean z3 = WidgetUserAccountVerifyBase.this.getIsEmailAllowed() && !meUser.isVerified();
            WidgetUserAccountVerifyBase widgetUserAccountVerifyBase = WidgetUserAccountVerifyBase.this;
            Intrinsics3.checkNotNullExpressionValue(requiredAction, "requiredAction");
            return Boolean.valueOf(WidgetUserAccountVerifyBase.access$computeShouldDismiss(widgetUserAccountVerifyBase, z2, z3, requiredAction));
        }
    }

    /* compiled from: WidgetUserAccountVerifyBase.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "p1", "", "invoke", "(Z)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.user.account.WidgetUserAccountVerifyBase$onViewBoundOrOnResume$1, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<Boolean, Unit> {
        public AnonymousClass1(WidgetUserAccountVerifyBase widgetUserAccountVerifyBase) {
            super(1, widgetUserAccountVerifyBase, WidgetUserAccountVerifyBase.class, "handleIsAuthorized", "handleIsAuthorized(Z)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
            invoke(bool.booleanValue());
            return Unit.a;
        }

        public final void invoke(boolean z2) {
            WidgetUserAccountVerifyBase.access$handleIsAuthorized((WidgetUserAccountVerifyBase) this.receiver, z2);
        }
    }

    /* compiled from: WidgetUserAccountVerifyBase.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\b\u001a\u00020\u00052\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u00002\u000e\u0010\u0004\u001a\n \u0001*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "menuItem", "Landroid/content/Context;", "<anonymous parameter 1>", "", NotificationCompat.CATEGORY_CALL, "(Landroid/view/MenuItem;Landroid/content/Context;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.user.account.WidgetUserAccountVerifyBase$setOptionsMenu$1, reason: invalid class name */
    public static final class AnonymousClass1<T1, T2> implements Action2<MenuItem, Context> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        @Override // rx.functions.Action2
        public /* bridge */ /* synthetic */ void call(MenuItem menuItem, Context context) {
            call2(menuItem, context);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final void call2(MenuItem menuItem, Context context) {
            Intrinsics3.checkNotNullExpressionValue(menuItem, "menuItem");
            if (menuItem.getItemId() != R.id.menu_settings_log_out) {
                return;
            }
            StoreStream.INSTANCE.getAuthentication().logout();
        }
    }

    public WidgetUserAccountVerifyBase(@LayoutRes int i) {
        super(i);
        this.isPhoneAllowed = true;
        this.isEmailAllowed = true;
    }

    public static final /* synthetic */ boolean access$computeShouldDismiss(WidgetUserAccountVerifyBase widgetUserAccountVerifyBase, boolean z2, boolean z3, RequiredAction requiredAction) {
        return widgetUserAccountVerifyBase.computeShouldDismiss(z2, z3, requiredAction);
    }

    public static final /* synthetic */ void access$handleIsAuthorized(WidgetUserAccountVerifyBase widgetUserAccountVerifyBase, boolean z2) {
        widgetUserAccountVerifyBase.handleIsAuthorized(z2);
    }

    private final boolean computeShouldDismiss(boolean isMissingPhone, boolean isMissingEmailOrUnverified, RequiredAction requiredAction) {
        Mode mode = this.mode;
        if (mode == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("mode");
        }
        if (mode == Mode.UNFORCED) {
            return true;
        }
        Mode mode2 = this.mode;
        if (mode2 == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("mode");
        }
        if (mode2 == Mode.NO_HISTORY_FROM_USER_SETTINGS) {
            return true;
        }
        if (isMissingPhone && requiredAction == RequiredAction.REQUIRE_VERIFIED_PHONE) {
            return true;
        }
        return (isMissingPhone || isMissingEmailOrUnverified) && requiredAction == RequiredAction.REQUIRE_VERIFIED_EMAIL;
    }

    public static final Intent getLaunchIntent(Mode mode, boolean z2, boolean z3) {
        return INSTANCE.getLaunchIntent(mode, z2, z3);
    }

    private final Observable<Boolean> getShouldDismissObservable() {
        StoreStream.Companion companion = StoreStream.INSTANCE;
        Observable observableJ = Observable.j(companion.getUserRequiredActions().observeUserRequiredAction(), StoreUser.observeMe$default(companion.getUsers(), false, 1, null), new AnonymousClass1());
        Intrinsics3.checkNotNullExpressionValue(observableJ, "Observable\n        .comb…requiredAction)\n        }");
        Observable<Boolean> observableR = ObservableExtensionsKt.computationBuffered(observableJ).r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "Observable\n        .comb…  .distinctUntilChanged()");
        return observableR;
    }

    private final void handleIsAuthorized(boolean isAuthorized) {
        Context context = getContext();
        if (context != null) {
            Intrinsics3.checkNotNullExpressionValue(context, "context ?: return");
            if (isAuthorized) {
                return;
            }
            AppScreen2.c(context, false, null, 6);
        }
    }

    private final void setOptionsMenu() {
        Mode mode = this.mode;
        if (mode == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("mode");
        }
        AppFragment.setActionBarOptionsMenu$default(this, mode == Mode.FORCED ? R.menu.menu_settings_logout : R.menu.menu_empty, AnonymousClass1.INSTANCE, null, 4, null);
    }

    public final Mode getMode() {
        Mode mode = this.mode;
        if (mode == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("mode");
        }
        return mode;
    }

    /* renamed from: isEmailAllowed, reason: from getter */
    public final boolean getIsEmailAllowed() {
        return this.isEmailAllowed;
    }

    public final boolean isForced() {
        Mode mode = this.mode;
        if (mode == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("mode");
        }
        return mode == Mode.FORCED;
    }

    /* renamed from: isPhoneAllowed, reason: from getter */
    public final boolean getIsPhoneAllowed() {
        return this.isPhoneAllowed;
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        int intExtra = getMostRecentIntent().getIntExtra(INTENT_MODE, -1);
        Mode.values();
        if (intExtra >= 0 && 3 > intExtra) {
            this.mode = Mode.values()[intExtra];
            setOptionsMenu();
            this.isPhoneAllowed = getMostRecentIntent().getBooleanExtra(INTENT_PHONE_ALLOWED, this.isPhoneAllowed);
            this.isEmailAllowed = getMostRecentIntent().getBooleanExtra(INTENT_EMAIL_ALLOWED, this.isEmailAllowed);
            return;
        }
        AppLog appLog = AppLog.g;
        StringBuilder sbU = outline.U("Invalid mode passed into ");
        sbU.append(WidgetUserAccountVerifyBase.class.getName());
        Logger.e$default(appLog, sbU.toString(), null, null, 6, null);
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.finish();
        }
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(getShouldDismissObservable(), this, null, 2, null), getClass(), (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(this), 62, (Object) null);
    }

    public final void setEmailAllowed(boolean z2) {
        this.isEmailAllowed = z2;
    }

    public final void setMode(Mode mode) {
        Intrinsics3.checkNotNullParameter(mode, "<set-?>");
        this.mode = mode;
    }

    public final void setPhoneAllowed(boolean z2) {
        this.isPhoneAllowed = z2;
    }
}
