package com.discord.utilities.auth;

import android.content.Context;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.stores.StoreAuthentication;
import com.discord.stores.StoreStream;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.utilities.auth.GoogleSmartLockManager;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.widgets.settings.account.WidgetSettingsAccountChangePassword;
import d0.LazyJVM;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;
import rx.subjects.PublishSubject;

/* compiled from: GoogleSmartLockRepo.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 ,2\u00020\u0001:\u0001,B\u0011\u0012\b\b\u0002\u0010)\u001a\u00020(¢\u0006\u0004\b*\u0010+J\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\r\u0010\u0007\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\r\u0010\t\u001a\u00020\u0004¢\u0006\u0004\b\t\u0010\bJ\u001d\u0010\r\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\n¢\u0006\u0004\b\r\u0010\u000eJ\u0013\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f¢\u0006\u0004\b\u0011\u0010\u0012R$\u0010\u0013\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\"\u0010\u001a\u001a\u00020\u00198\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\"\u0010 \u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010\u0006R\u001c\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00100%8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b&\u0010'¨\u0006-"}, d2 = {"Lcom/discord/utilities/auth/GoogleSmartLockRepo;", "", "", "usedAutomaticCredentials", "", "setAttemptToSignInWithSmartLock", "(Z)V", "onLoginWithSmartLockSuccess", "()V", "onSmartLockCredentialsFailed", "", ModelAuditLogEntry.CHANGE_KEY_ID, WidgetSettingsAccountChangePassword.CURRENT_PASSWORD_FIELD, "setSmartLockLogin", "(Ljava/lang/String;Ljava/lang/String;)V", "Lrx/Observable;", "Lcom/discord/utilities/auth/GoogleSmartLockManager$SmartLockCredentials;", "getSmartLockLoginObservable", "()Lrx/Observable;", "pendingIdChange", "Ljava/lang/String;", "getPendingIdChange", "()Ljava/lang/String;", "setPendingIdChange", "(Ljava/lang/String;)V", "Lcom/discord/utilities/auth/SmartLockSignInAttempt;", "smartLockLoginAttempt", "Lcom/discord/utilities/auth/SmartLockSignInAttempt;", "getSmartLockLoginAttempt", "()Lcom/discord/utilities/auth/SmartLockSignInAttempt;", "setSmartLockLoginAttempt", "(Lcom/discord/utilities/auth/SmartLockSignInAttempt;)V", "disableAutoLogin", "Z", "getDisableAutoLogin", "()Z", "setDisableAutoLogin", "Lrx/subjects/PublishSubject;", "smartLockLogin", "Lrx/subjects/PublishSubject;", "Lcom/discord/stores/StoreAuthentication;", "storeAuth", "<init>", "(Lcom/discord/stores/StoreAuthentication;)V", "Companion", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class GoogleSmartLockRepo {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Lazy INSTANCE$delegate = LazyJVM.lazy(GoogleSmartLockRepo2.INSTANCE);
    private boolean disableAutoLogin;
    private String pendingIdChange;
    private PublishSubject<GoogleSmartLockManager.SmartLockCredentials> smartLockLogin;
    private GoogleSmartLockRepo3 smartLockLoginAttempt;

    /* compiled from: GoogleSmartLockRepo.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "isLoggedIn", "", "invoke", "(Z)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.utilities.auth.GoogleSmartLockRepo$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<Boolean, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
            invoke(bool.booleanValue());
            return Unit.a;
        }

        public final void invoke(boolean z2) {
            if (z2) {
                return;
            }
            GoogleSmartLockRepo.this.setDisableAutoLogin(true);
        }
    }

    /* compiled from: GoogleSmartLockRepo.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\b\u0010\tR\u001d\u0010\u0007\u001a\u00020\u00028F@\u0006X\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/discord/utilities/auth/GoogleSmartLockRepo$Companion;", "", "Lcom/discord/utilities/auth/GoogleSmartLockRepo;", "INSTANCE$delegate", "Lkotlin/Lazy;", "getINSTANCE", "()Lcom/discord/utilities/auth/GoogleSmartLockRepo;", "INSTANCE", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public final GoogleSmartLockRepo getINSTANCE() {
            Lazy lazyAccess$getINSTANCE$cp = GoogleSmartLockRepo.access$getINSTANCE$cp();
            Companion companion = GoogleSmartLockRepo.INSTANCE;
            return (GoogleSmartLockRepo) lazyAccess$getINSTANCE$cp.getValue();
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public GoogleSmartLockRepo() {
        this(null, 1, null);
    }

    public GoogleSmartLockRepo(StoreAuthentication storeAuthentication) {
        Intrinsics3.checkNotNullParameter(storeAuthentication, "storeAuth");
        PublishSubject<GoogleSmartLockManager.SmartLockCredentials> publishSubjectK0 = PublishSubject.k0();
        Intrinsics3.checkNotNullExpressionValue(publishSubjectK0, "PublishSubject.create()");
        this.smartLockLogin = publishSubjectK0;
        this.smartLockLoginAttempt = new GoogleSmartLockRepo3(false, false, 3, null);
        ObservableExtensionsKt.appSubscribe$default(storeAuthentication.getPreLogoutSignal$app_productionGoogleRelease(), GoogleSmartLockRepo.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(), 62, (Object) null);
    }

    public static final /* synthetic */ Lazy access$getINSTANCE$cp() {
        return INSTANCE$delegate;
    }

    public final boolean getDisableAutoLogin() {
        return this.disableAutoLogin;
    }

    public final String getPendingIdChange() {
        return this.pendingIdChange;
    }

    public final GoogleSmartLockRepo3 getSmartLockLoginAttempt() {
        return this.smartLockLoginAttempt;
    }

    public final Observable<GoogleSmartLockManager.SmartLockCredentials> getSmartLockLoginObservable() {
        return this.smartLockLogin;
    }

    public final void onLoginWithSmartLockSuccess() {
        if (this.smartLockLoginAttempt.getSignedInWithoutError()) {
            if (this.smartLockLoginAttempt.getUsedAutomaticCredentials()) {
                AnalyticsTracker.INSTANCE.smartLockAutoLogin();
            } else {
                AnalyticsTracker.INSTANCE.smartLockLogin();
            }
        }
    }

    public final void onSmartLockCredentialsFailed() {
        this.smartLockLoginAttempt = GoogleSmartLockRepo3.copy$default(this.smartLockLoginAttempt, false, false, 1, null);
        AnalyticsTracker.INSTANCE.smartLockLoginCredentialsFailed();
    }

    public final void setAttemptToSignInWithSmartLock(boolean usedAutomaticCredentials) {
        this.smartLockLoginAttempt = new GoogleSmartLockRepo3(usedAutomaticCredentials, false, 2, null);
    }

    public final void setDisableAutoLogin(boolean z2) {
        this.disableAutoLogin = z2;
    }

    public final void setPendingIdChange(String str) {
        this.pendingIdChange = str;
    }

    public final void setSmartLockLogin(String id2, String password) {
        Intrinsics3.checkNotNullParameter(id2, ModelAuditLogEntry.CHANGE_KEY_ID);
        Intrinsics3.checkNotNullParameter(password, WidgetSettingsAccountChangePassword.CURRENT_PASSWORD_FIELD);
        PublishSubject<GoogleSmartLockManager.SmartLockCredentials> publishSubject = this.smartLockLogin;
        publishSubject.k.onNext(new GoogleSmartLockManager.SmartLockCredentials(id2, password));
    }

    public final void setSmartLockLoginAttempt(GoogleSmartLockRepo3 googleSmartLockRepo3) {
        Intrinsics3.checkNotNullParameter(googleSmartLockRepo3, "<set-?>");
        this.smartLockLoginAttempt = googleSmartLockRepo3;
    }

    public /* synthetic */ GoogleSmartLockRepo(StoreAuthentication storeAuthentication, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? StoreStream.INSTANCE.getAuthentication() : storeAuthentication);
    }
}
