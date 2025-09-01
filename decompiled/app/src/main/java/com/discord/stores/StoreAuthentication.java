package com.discord.stores;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.util.Patterns;
import androidx.core.app.NotificationCompat;
import androidx.core.content.ContextCompat;
import b.d.b.a.outline;
import com.discord.analytics.generated.events.network_action.TrackNetworkActionAuthorizeIp;
import com.discord.analytics.generated.events.network_action.TrackNetworkActionForgotPassword;
import com.discord.analytics.generated.events.network_action.TrackNetworkActionUserLogin;
import com.discord.analytics.generated.events.network_action.TrackNetworkActionUserLoginMfa;
import com.discord.analytics.generated.events.network_action.TrackNetworkActionUserLogout;
import com.discord.analytics.generated.events.network_action.TrackNetworkActionUserRegister;
import com.discord.analytics.generated.traits.TrackNetworkMetadata2;
import com.discord.api.auth.RegisterResponse;
import com.discord.api.auth.RequiredAction;
import com.discord.api.channel.Channel;
import com.discord.api.fingerprint.FingerprintResponse;
import com.discord.app.AppLog;
import com.discord.models.authentication.AuthState;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.domain.ModelInvite;
import com.discord.models.domain.ModelLocationMetadata;
import com.discord.models.domain.auth.ModelLoginResult;
import com.discord.models.user.MeUser;
import com.discord.restapi.RestAPIParams;
import com.discord.stores.StoreInviteSettings;
import com.discord.stores.StoreNavigation;
import com.discord.stores.StoreStream;
import com.discord.stores.authentication.AuthStateCache;
import com.discord.stores.utilities.RestCallState5;
import com.discord.utilities.SnowflakeUtils;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.utilities.captcha.CaptchaHelper;
import com.discord.utilities.error.Error;
import com.discord.utilities.persister.Persister;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.time.TimeUtils;
import com.discord.widgets.settings.account.WidgetSettingsAccountChangePassword;
import com.google.firebase.crashlytics.FirebaseCrashlytics;
import d0.g0.StringsJVM;
import d0.t.Sets5;
import d0.t._Collections;
import d0.t._Sets;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import j0.k.Func1;
import j0.l.e.ScalarSynchronousObservable;
import j0.m.BlockingObservable;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;
import rx.Subscription;
import rx.functions.Action1;
import rx.functions.Func2;
import rx.functions.Func3;
import rx.subjects.BehaviorSubject;
import rx.subjects.PublishSubject;
import rx.subjects.SerializedSubject;

/* compiled from: StoreAuthentication.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000²\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u0084\u00012\u00020\u0001:\u0004\u0085\u0001\u0084\u0001B\u001a\u0012\u0006\u0010a\u001a\u00020`\u0012\u0007\u0010\u0080\u0001\u001a\u00020\u007f¢\u0006\u0006\b\u0082\u0001\u0010\u0083\u0001J\u0019\u0010\u0005\u001a\f\u0012\b\u0012\u00060\u0003j\u0002`\u00040\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\f\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\f\u0010\rJ\u001d\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\u0006\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u0019\u0010\u0014\u001a\u00020\u00072\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u0015\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00160\u0002H\u0000¢\u0006\u0004\b\u0017\u0010\u0006J\r\u0010\u0019\u001a\u00020\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u0015\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00160\u0002H\u0000¢\u0006\u0004\b\u001b\u0010\u0006J\u0017\u0010\u001e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u0002H\u0000¢\u0006\u0004\b\u001d\u0010\u0006J\u0017\u0010 \u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0002H\u0000¢\u0006\u0004\b\u001f\u0010\u0006J\u0017\u0010\"\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0002H\u0000¢\u0006\u0004\b!\u0010\u0006J\r\u0010#\u001a\u00020\u0007¢\u0006\u0004\b#\u0010\tJ\u0015\u0010$\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0002¢\u0006\u0004\b$\u0010\u0006J\u0015\u0010&\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010%0\u0002¢\u0006\u0004\b&\u0010\u0006J\u0019\u0010(\u001a\u00020\u00072\b\u0010'\u001a\u0004\u0018\u00010\u0003H\u0007¢\u0006\u0004\b(\u0010)J\u0017\u0010*\u001a\u00020\u00072\b\u0010'\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b*\u0010)J\u0017\u0010,\u001a\u00020\u00072\b\u0010+\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b,\u0010)J\u0013\u0010.\u001a\b\u0012\u0004\u0012\u00020-0\u0002¢\u0006\u0004\b.\u0010\u0006J\u0015\u00100\u001a\u00020\u00072\u0006\u0010/\u001a\u00020-¢\u0006\u0004\b0\u00101JA\u00102\u001a\b\u0012\u0004\u0012\u00020\n0\u00022\u0006\u00102\u001a\u00020\u00032\u0006\u00103\u001a\u00020\u00032\b\u00105\u001a\u0004\u0018\u0001042\u0006\u00106\u001a\u00020\u00162\n\b\u0002\u00107\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b2\u00108J#\u0010;\u001a\b\u0012\u0004\u0012\u00020\n0\u00022\u0006\u00109\u001a\u00020\u00032\u0006\u0010:\u001a\u00020\u0003¢\u0006\u0004\b;\u0010<J\u001d\u0010>\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010=0\u00022\u0006\u0010+\u001a\u00020\u0003¢\u0006\u0004\b>\u0010?J\u0017\u0010@\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\nH\u0007¢\u0006\u0004\b@\u0010\rJ\r\u0010A\u001a\u00020\u0007¢\u0006\u0004\bA\u0010\tJ[\u0010I\u001a\b\u0012\u0004\u0012\u00020H0\u00022\u0006\u0010B\u001a\u00020\u00032\b\u0010C\u001a\u0004\u0018\u00010\u00032\b\u0010D\u001a\u0004\u0018\u00010\u00032\u0006\u00103\u001a\u00020\u00032\b\u00105\u001a\u0004\u0018\u0001042\u0006\u0010E\u001a\u00020\u00162\u0010\b\u0002\u0010G\u001a\n\u0018\u00010\u0003j\u0004\u0018\u0001`F¢\u0006\u0004\bI\u0010JJ'\u0010K\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010=0\u00022\u0006\u00102\u001a\u00020\u00032\b\u00105\u001a\u0004\u0018\u000104¢\u0006\u0004\bK\u0010LJ\u0017\u0010N\u001a\u00020\u00072\b\u0010M\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\bN\u0010)J\u001f\u0010Q\u001a\u00020\u00072\b\u0010O\u001a\u0004\u0018\u00010\u00032\u0006\u0010P\u001a\u00020\u0016¢\u0006\u0004\bQ\u0010RJ\u0017\u0010U\u001a\u00020\u00072\u0006\u0010T\u001a\u00020SH\u0017¢\u0006\u0004\bU\u0010VJ\u0019\u0010X\u001a\u00020\u00072\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0001¢\u0006\u0004\bW\u0010\u0015J\u000f\u0010Z\u001a\u00020\u0007H\u0001¢\u0006\u0004\bY\u0010\tRF\u0010]\u001a2\u0012\u0016\u0012\u0014 \\*\n\u0018\u00010\u0003j\u0004\u0018\u0001`\u00040\u0003j\u0002`\u0004\u0012\u0016\u0012\u0014 \\*\n\u0018\u00010\u0003j\u0004\u0018\u0001`\u00040\u0003j\u0002`\u00040[8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b]\u0010^R&\u0010_\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u00120[8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b_\u0010^R\u0016\u0010a\u001a\u00020`8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\ba\u0010bR:\u0010d\u001a&\u0012\f\u0012\n \\*\u0004\u0018\u00010\u00160\u0016 \\*\u0012\u0012\f\u0012\n \\*\u0004\u0018\u00010\u00160\u0016\u0018\u00010c0c8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bd\u0010eR$\u0010g\u001a\u00020\u00162\u0006\u0010f\u001a\u00020\u00168F@BX\u0086\u000e¢\u0006\f\u001a\u0004\bg\u0010\u001a\"\u0004\bh\u0010iR\u0018\u0010j\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bj\u0010kR(\u0010\u0013\u001a\u0004\u0018\u00010\u00122\b\u0010l\u001a\u0004\u0018\u00010\u00128\u0000@BX\u0080\u000e¢\u0006\f\n\u0004\b\u0013\u0010m\u001a\u0004\b\u001d\u0010nR\u0016\u0010p\u001a\u00020o8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bp\u0010qR.\u0010r\u001a\u0004\u0018\u00010\u00032\b\u00102\u001a\u0004\u0018\u00010\u00038\u0006@BX\u0086\u000e¢\u0006\u0012\n\u0004\br\u0010s\u001a\u0004\bt\u0010u\"\u0004\bv\u0010)R\u001e\u0010x\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030w8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bx\u0010yR4\u0010O\u001a\n\u0018\u00010\u0003j\u0004\u0018\u0001`\u00042\u000e\u0010l\u001a\n\u0018\u00010\u0003j\u0004\u0018\u0001`\u00048\u0000@BX\u0080\u000e¢\u0006\f\n\u0004\bO\u0010s\u001a\u0004\bz\u0010uR\"\u0010|\u001a\u0004\u0018\u00010{2\b\u0010l\u001a\u0004\u0018\u00010{8B@BX\u0082\u000e¢\u0006\u0006\n\u0004\b|\u0010}R2\u0010~\u001a\u001e\u0012\f\u0012\n \\*\u0004\u0018\u00010-0-\u0012\f\u0012\n \\*\u0004\u0018\u00010-0-0[8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b~\u0010^R\u0019\u0010\u0080\u0001\u001a\u00020\u007f8\u0002@\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0080\u0001\u0010\u0081\u0001¨\u0006\u0086\u0001"}, d2 = {"Lcom/discord/stores/StoreAuthentication;", "Lcom/discord/stores/Store;", "Lrx/Observable;", "", "Lcom/discord/primitives/FingerPrint;", "getFingerprintSnapshotOrGenerate", "()Lrx/Observable;", "", "resetIsConsentRequired", "()V", "Lcom/discord/models/domain/auth/ModelLoginResult;", "loginResult", "dispatchLogin", "(Lcom/discord/models/domain/auth/ModelLoginResult;)V", "", "Lcom/discord/api/auth/RequiredAction;", "getRequiredActionsFromLoginResponse", "(Lcom/discord/models/domain/auth/ModelLoginResult;)Ljava/util/Set;", "Lcom/discord/models/authentication/AuthState;", "authState", "publishAuthState", "(Lcom/discord/models/authentication/AuthState;)V", "", "getPreLogoutSignal$app_productionGoogleRelease", "getPreLogoutSignal", "isAuthed", "()Z", "observeIsAuthed$app_productionGoogleRelease", "observeIsAuthed", "getAuthState$app_productionGoogleRelease", "getAuthState", "getAuthedToken$app_productionGoogleRelease", "getAuthedToken", "getFingerPrint$app_productionGoogleRelease", "getFingerPrint", "requestConsentRequired", "getAgeGateError", "Lcom/discord/stores/StoreNavigation$AgeGate;", "getShouldShowAgeGate", "error", "handleAgeGateError", "(Ljava/lang/String;)V", "setAgeGateError", StoreAuthentication.CACHE_KEY_TOKEN_RNA, "onPasswordChanged", "Landroid/net/Uri;", "getOAuthUriObservable", NotificationCompat.MessagingStyle.Message.KEY_DATA_URI, "setOAuthUriSubject", "(Landroid/net/Uri;)V", "login", WidgetSettingsAccountChangePassword.CURRENT_PASSWORD_FIELD, "Lcom/discord/utilities/captcha/CaptchaHelper$CaptchaPayload;", "captchaPayload", "undelete", "loginSource", "(Ljava/lang/String;Ljava/lang/String;Lcom/discord/utilities/captcha/CaptchaHelper$CaptchaPayload;ZLjava/lang/String;)Lrx/Observable;", ModelAuditLogEntry.CHANGE_KEY_CODE, "ticket", "authMFA", "(Ljava/lang/String;Ljava/lang/String;)Lrx/Observable;", "Ljava/lang/Void;", "authorizeIP", "(Ljava/lang/String;)Lrx/Observable;", "handleLoginResult", "logout", "username", NotificationCompat.CATEGORY_EMAIL, "phoneToken", "consent", "Lcom/discord/primitives/UtcTimestamp;", "dateOfBirth", "Lcom/discord/api/auth/RegisterResponse;", "register", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/discord/utilities/captcha/CaptchaHelper$CaptchaPayload;ZLjava/lang/String;)Lrx/Observable;", "forgotPassword", "(Ljava/lang/String;Lcom/discord/utilities/captcha/CaptchaHelper$CaptchaPayload;)Lrx/Observable;", "authToken", "setAuthed", "fingerprint", "force", "setFingerprint", "(Ljava/lang/String;Z)V", "Landroid/content/Context;", "context", "init", "(Landroid/content/Context;)V", "handleAuthState$app_productionGoogleRelease", "handleAuthState", "handlePreLogout$app_productionGoogleRelease", "handlePreLogout", "Lrx/subjects/SerializedSubject;", "kotlin.jvm.PlatformType", "fingerprintSubject", "Lrx/subjects/SerializedSubject;", "authStateSubject", "Lcom/discord/stores/StoreStream;", "storeStream", "Lcom/discord/stores/StoreStream;", "Lrx/subjects/PublishSubject;", "userInitiatedAuthEventSubject", "Lrx/subjects/PublishSubject;", "value", "isConsentRequired", "setConsentRequired", "(Z)V", "_isConsentRequired", "Ljava/lang/Boolean;", "<set-?>", "Lcom/discord/models/authentication/AuthState;", "()Lcom/discord/models/authentication/AuthState;", "Lcom/discord/stores/authentication/AuthStateCache;", "authStateCache", "Lcom/discord/stores/authentication/AuthStateCache;", "savedLogin", "Ljava/lang/String;", "getSavedLogin", "()Ljava/lang/String;", "setSavedLogin", "Lrx/subjects/BehaviorSubject;", "ageGateError", "Lrx/subjects/BehaviorSubject;", "getFingerprint$app_productionGoogleRelease", "Lrx/Subscription;", "isConsentRequiredSubscription", "Lrx/Subscription;", "oauthUriSubject", "Lcom/discord/stores/Dispatcher;", "dispatcher", "Lcom/discord/stores/Dispatcher;", "<init>", "(Lcom/discord/stores/StoreStream;Lcom/discord/stores/Dispatcher;)V", "Companion", "AuthRequestParams", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class StoreAuthentication extends Store {
    private static final String CACHE_KEY_FINGERPRINT = "STORE_AUTHED_FINGERPRINT";
    private static final String CACHE_KEY_LOGIN = "STORE_AUTHED_LOGIN";
    private static final String CACHE_KEY_TOKEN_RNA = "token";

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String SHARED_PREFS_NAME_RNA = "CacheStore";
    private Boolean _isConsentRequired;
    private BehaviorSubject<String> ageGateError;
    private AuthState authState;
    private final AuthStateCache authStateCache;
    private final SerializedSubject<AuthState, AuthState> authStateSubject;
    private final Dispatcher dispatcher;
    private String fingerprint;
    private final SerializedSubject<String, String> fingerprintSubject;
    private Subscription isConsentRequiredSubscription;
    private final SerializedSubject<Uri, Uri> oauthUriSubject;
    private String savedLogin;
    private final StoreStream storeStream;
    private final PublishSubject<Boolean> userInitiatedAuthEventSubject;

    /* compiled from: StoreAuthentication.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\b\u0082\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0018\u0010\u0019J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J(\u0010\n\u001a\u00020\u00002\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\f\u0010\u0007J\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013R\u001b\u0010\t\u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\u0014\u001a\u0004\b\u0015\u0010\u0007R\u001b\u0010\b\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\u0016\u001a\u0004\b\u0017\u0010\u0004¨\u0006\u001a"}, d2 = {"Lcom/discord/stores/StoreAuthentication$AuthRequestParams;", "", "Lcom/discord/stores/StoreInviteSettings$InviteCode;", "component1", "()Lcom/discord/stores/StoreInviteSettings$InviteCode;", "", "component2", "()Ljava/lang/String;", "inviteCode", "guildTemplateCode", "copy", "(Lcom/discord/stores/StoreInviteSettings$InviteCode;Ljava/lang/String;)Lcom/discord/stores/StoreAuthentication$AuthRequestParams;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getGuildTemplateCode", "Lcom/discord/stores/StoreInviteSettings$InviteCode;", "getInviteCode", "<init>", "(Lcom/discord/stores/StoreInviteSettings$InviteCode;Ljava/lang/String;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class AuthRequestParams {
        private final String guildTemplateCode;
        private final StoreInviteSettings.InviteCode inviteCode;

        public AuthRequestParams(StoreInviteSettings.InviteCode inviteCode, String str) {
            this.inviteCode = inviteCode;
            this.guildTemplateCode = str;
        }

        public static /* synthetic */ AuthRequestParams copy$default(AuthRequestParams authRequestParams, StoreInviteSettings.InviteCode inviteCode, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                inviteCode = authRequestParams.inviteCode;
            }
            if ((i & 2) != 0) {
                str = authRequestParams.guildTemplateCode;
            }
            return authRequestParams.copy(inviteCode, str);
        }

        /* renamed from: component1, reason: from getter */
        public final StoreInviteSettings.InviteCode getInviteCode() {
            return this.inviteCode;
        }

        /* renamed from: component2, reason: from getter */
        public final String getGuildTemplateCode() {
            return this.guildTemplateCode;
        }

        public final AuthRequestParams copy(StoreInviteSettings.InviteCode inviteCode, String guildTemplateCode) {
            return new AuthRequestParams(inviteCode, guildTemplateCode);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof AuthRequestParams)) {
                return false;
            }
            AuthRequestParams authRequestParams = (AuthRequestParams) other;
            return Intrinsics3.areEqual(this.inviteCode, authRequestParams.inviteCode) && Intrinsics3.areEqual(this.guildTemplateCode, authRequestParams.guildTemplateCode);
        }

        public final String getGuildTemplateCode() {
            return this.guildTemplateCode;
        }

        public final StoreInviteSettings.InviteCode getInviteCode() {
            return this.inviteCode;
        }

        public int hashCode() {
            StoreInviteSettings.InviteCode inviteCode = this.inviteCode;
            int iHashCode = (inviteCode != null ? inviteCode.hashCode() : 0) * 31;
            String str = this.guildTemplateCode;
            return iHashCode + (str != null ? str.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbU = outline.U("AuthRequestParams(inviteCode=");
            sbU.append(this.inviteCode);
            sbU.append(", guildTemplateCode=");
            return outline.J(sbU, this.guildTemplateCode, ")");
        }
    }

    /* compiled from: StoreAuthentication.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\u0007\u001a\u0004\u0018\u00010\u0004*\u00020\u0002H\u0002¢\u0006\u0004\b\u0007\u0010\u0006R\u0016\u0010\b\u001a\u00020\u00048\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0016\u0010\n\u001a\u00020\u00048\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\n\u0010\tR\u0016\u0010\u000b\u001a\u00020\u00048\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000b\u0010\tR\u0016\u0010\f\u001a\u00020\u00048\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\f\u0010\t¨\u0006\u000f"}, d2 = {"Lcom/discord/stores/StoreAuthentication$Companion;", "", "Landroid/content/Context;", "context", "", "getDeviceEmail", "(Landroid/content/Context;)Ljava/lang/String;", "getRnaAuthToken", "CACHE_KEY_FINGERPRINT", "Ljava/lang/String;", "CACHE_KEY_LOGIN", "CACHE_KEY_TOKEN_RNA", "SHARED_PREFS_NAME_RNA", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public static final /* synthetic */ String access$getDeviceEmail(Companion companion, Context context) {
            return companion.getDeviceEmail(context);
        }

        public static final /* synthetic */ String access$getRnaAuthToken(Companion companion, Context context) {
            return companion.getRnaAuthToken(context);
        }

        @SuppressLint({"MissingPermission"})
        private final String getDeviceEmail(Context context) {
            Account account;
            if (ContextCompat.checkSelfPermission(context, "android.permission.GET_ACCOUNTS") != 0) {
                return null;
            }
            AccountManager accountManager = AccountManager.get(context);
            Intrinsics3.checkNotNullExpressionValue(accountManager, "AccountManager.get(context)");
            Account[] accounts = accountManager.getAccounts();
            Intrinsics3.checkNotNullExpressionValue(accounts, "AccountManager.get(context).accounts");
            int length = accounts.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    account = null;
                    break;
                }
                account = accounts[i];
                if (Patterns.EMAIL_ADDRESS.matcher(account.type).matches()) {
                    break;
                }
                i++;
            }
            if (account != null) {
                return account.name;
            }
            return null;
        }

        private final String getRnaAuthToken(Context context) {
            String string = context.getSharedPreferences(StoreAuthentication.SHARED_PREFS_NAME_RNA, 0).getString(StoreAuthentication.CACHE_KEY_TOKEN_RNA, null);
            if (string != null) {
                return StringsJVM.replace$default(string, "\"", "", false, 4, (Object) null);
            }
            return null;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: StoreAuthentication.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u0004\u0018\u00010\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/models/domain/auth/ModelLoginResult;", "it", "Lcom/discord/analytics/generated/traits/TrackNetworkMetadataReceiver;", "invoke", "(Lcom/discord/models/domain/auth/ModelLoginResult;)Lcom/discord/analytics/generated/traits/TrackNetworkMetadataReceiver;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreAuthentication$authMFA$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<ModelLoginResult, TrackNetworkMetadata2> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ TrackNetworkMetadata2 invoke(ModelLoginResult modelLoginResult) {
            return invoke2(modelLoginResult);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final TrackNetworkMetadata2 invoke2(ModelLoginResult modelLoginResult) {
            return new TrackNetworkActionUserLoginMfa();
        }
    }

    /* compiled from: StoreAuthentication.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/discord/models/domain/auth/ModelLoginResult;", "kotlin.jvm.PlatformType", "loginResult", "", NotificationCompat.CATEGORY_CALL, "(Lcom/discord/models/domain/auth/ModelLoginResult;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreAuthentication$authMFA$2, reason: invalid class name */
    public static final class AnonymousClass2<T> implements Action1<ModelLoginResult> {
        public AnonymousClass2() {
        }

        @Override // rx.functions.Action1
        public /* bridge */ /* synthetic */ void call(ModelLoginResult modelLoginResult) {
            call2(modelLoginResult);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final void call2(ModelLoginResult modelLoginResult) {
            StoreAuthentication storeAuthentication = StoreAuthentication.this;
            Intrinsics3.checkNotNullExpressionValue(modelLoginResult, "loginResult");
            StoreAuthentication.access$dispatchLogin(storeAuthentication, modelLoginResult);
        }
    }

    /* compiled from: StoreAuthentication.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u0004\u0018\u00010\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Ljava/lang/Void;", "it", "Lcom/discord/analytics/generated/traits/TrackNetworkMetadataReceiver;", "invoke", "(Ljava/lang/Void;)Lcom/discord/analytics/generated/traits/TrackNetworkMetadataReceiver;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreAuthentication$authorizeIP$1, reason: invalid class name */
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
            return new TrackNetworkActionAuthorizeIp();
        }
    }

    /* compiled from: StoreAuthentication.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreAuthentication$dispatchLogin$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ ModelLoginResult $loginResult;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(ModelLoginResult modelLoginResult) {
            super(0);
            this.$loginResult = modelLoginResult;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            StoreAuthentication.access$getStoreStream$p(StoreAuthentication.this).handleLoginResult(this.$loginResult);
        }
    }

    /* compiled from: StoreAuthentication.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u0004\u0018\u00010\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Ljava/lang/Void;", "it", "Lcom/discord/analytics/generated/traits/TrackNetworkMetadataReceiver;", "invoke", "(Ljava/lang/Void;)Lcom/discord/analytics/generated/traits/TrackNetworkMetadataReceiver;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreAuthentication$forgotPassword$1, reason: invalid class name */
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
            return new TrackNetworkActionForgotPassword();
        }
    }

    /* compiled from: StoreAuthentication.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0007\u001a>\u0012\u0018\b\u0001\u0012\u0014 \u0002*\n\u0018\u00010\u0000j\u0004\u0018\u0001`\u00010\u0000j\u0002`\u0001 \u0002*\u001e\u0012\u0018\b\u0001\u0012\u0014 \u0002*\n\u0018\u00010\u0000j\u0004\u0018\u0001`\u00010\u0000j\u0002`\u0001\u0018\u00010\u00040\u00042\u0018\u0010\u0003\u001a\u0014 \u0002*\n\u0018\u00010\u0000j\u0004\u0018\u0001`\u00010\u0000j\u0002`\u0001H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"", "Lcom/discord/primitives/FingerPrint;", "kotlin.jvm.PlatformType", "fingerprint", "Lrx/Observable;", NotificationCompat.CATEGORY_CALL, "(Ljava/lang/String;)Lrx/Observable;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreAuthentication$getFingerprintSnapshotOrGenerate$1, reason: invalid class name */
    public static final class AnonymousClass1<T, R> implements Func1<String, Observable<? extends String>> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        /* compiled from: StoreAuthentication.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0007\u001a\u0014 \u0001*\n\u0018\u00010\u0003j\u0004\u0018\u0001`\u00040\u0003j\u0002`\u00042\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lcom/discord/api/fingerprint/FingerprintResponse;", "kotlin.jvm.PlatformType", "it", "", "Lcom/discord/primitives/FingerPrint;", NotificationCompat.CATEGORY_CALL, "(Lcom/discord/api/fingerprint/FingerprintResponse;)Ljava/lang/String;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
        /* renamed from: com.discord.stores.StoreAuthentication$getFingerprintSnapshotOrGenerate$1$2, reason: invalid class name */
        public static final class AnonymousClass2<T, R> implements Func1<FingerprintResponse, String> {
            public static final AnonymousClass2 INSTANCE = new AnonymousClass2();

            @Override // j0.k.Func1
            public /* bridge */ /* synthetic */ String call(FingerprintResponse fingerprintResponse) {
                return call2(fingerprintResponse);
            }

            /* renamed from: call, reason: avoid collision after fix types in other method */
            public final String call2(FingerprintResponse fingerprintResponse) {
                return fingerprintResponse.getFingerprint();
            }
        }

        @Override // j0.k.Func1
        public /* bridge */ /* synthetic */ Observable<? extends String> call(String str) {
            return call2(str);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final Observable<? extends String> call2(String str) {
            return str != null ? new ScalarSynchronousObservable(str) : ObservableExtensionsKt.restSubscribeOn$default(RestAPI.INSTANCE.getApi().postAuthFingerprint(new RestAPIParams.EmptyBody()), false, 1, null).G(AnonymousClass2.INSTANCE);
        }
    }

    /* compiled from: StoreAuthentication.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0007\u001a\u00020\u00042\u0018\u0010\u0003\u001a\u0014 \u0002*\n\u0018\u00010\u0000j\u0004\u0018\u0001`\u00010\u0000j\u0002`\u0001H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"", "Lcom/discord/primitives/FingerPrint;", "kotlin.jvm.PlatformType", "fingerprint", "", NotificationCompat.CATEGORY_CALL, "(Ljava/lang/String;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreAuthentication$getFingerprintSnapshotOrGenerate$2, reason: invalid class name */
    public static final class AnonymousClass2<T> implements Action1<String> {
        public AnonymousClass2() {
        }

        @Override // rx.functions.Action1
        public /* bridge */ /* synthetic */ void call(String str) {
            call2(str);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final void call2(String str) {
            StoreAuthentication.this.setFingerprint(str, false);
        }
    }

    /* compiled from: StoreAuthentication.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\n\u001a\u0004\u0018\u00010\u00072\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u00002\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\n¢\u0006\u0004\b\b\u0010\t"}, d2 = {"Lcom/discord/models/user/MeUser;", "kotlin.jvm.PlatformType", "me", "", "ageGateError", "Lcom/discord/api/channel/Channel;", "channel", "Lcom/discord/stores/StoreNavigation$AgeGate;", NotificationCompat.CATEGORY_CALL, "(Lcom/discord/models/user/MeUser;Ljava/lang/String;Lcom/discord/api/channel/Channel;)Lcom/discord/stores/StoreNavigation$AgeGate;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreAuthentication$getShouldShowAgeGate$1, reason: invalid class name */
    public static final class AnonymousClass1<T1, T2, T3, R> implements Func3<MeUser, String, Channel, StoreNavigation.AgeGate> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        @Override // rx.functions.Func3
        public /* bridge */ /* synthetic */ StoreNavigation.AgeGate call(MeUser meUser, String str, Channel channel) {
            return call2(meUser, str, channel);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final StoreNavigation.AgeGate call2(MeUser meUser, String str, Channel channel) {
            long uTCDate = TimeUtils.parseUTCDate("2021-02-05T12:00:00+0000");
            if (!meUser.getHasBirthday() && (meUser.getId() >>> 22) + SnowflakeUtils.DISCORD_EPOCH > uTCDate) {
                return StoreNavigation.AgeGate.REGISTER_AGE_GATE;
            }
            if (str != null || meUser.getHasBirthday() || channel == null || !channel.getNsfw()) {
                return null;
            }
            return StoreNavigation.AgeGate.NSFW_CHANNEL_AGE_GATE;
        }
    }

    /* compiled from: StoreAuthentication.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "kotlin.jvm.PlatformType", "isLoggedIn", "", "invoke", "(Ljava/lang/Boolean;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreAuthentication$init$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<Boolean, Unit> {
        public final /* synthetic */ Context $context;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Context context) {
            super(1);
            this.$context = context;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
            invoke2(bool);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Boolean bool) {
            Context context = this.$context;
            Intrinsics3.checkNotNullExpressionValue(bool, "isLoggedIn");
            context.sendBroadcast(new Intent(bool.booleanValue() ? "com.discord.broadcast.LOGGED_IN" : "com.discord.broadcast.LOGGED_OUT"));
        }
    }

    /* compiled from: StoreAuthentication.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\b\u001a*\u0012\u000e\b\u0001\u0012\n \u0002*\u0004\u0018\u00010\u00050\u0005 \u0002*\u0014\u0012\u000e\b\u0001\u0012\n \u0002*\u0004\u0018\u00010\u00050\u0005\u0018\u00010\u00040\u00042\u0018\u0010\u0003\u001a\u0014 \u0002*\n\u0018\u00010\u0000j\u0004\u0018\u0001`\u00010\u0000j\u0002`\u0001H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"", "Lcom/discord/primitives/FingerPrint;", "kotlin.jvm.PlatformType", "it", "Lrx/Observable;", "Lcom/discord/models/domain/auth/ModelLoginResult;", NotificationCompat.CATEGORY_CALL, "(Ljava/lang/String;)Lrx/Observable;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreAuthentication$login$1, reason: invalid class name */
    public static final class AnonymousClass1<T, R> implements Func1<String, Observable<? extends ModelLoginResult>> {
        public final /* synthetic */ CaptchaHelper.CaptchaPayload $captchaPayload;
        public final /* synthetic */ String $login;
        public final /* synthetic */ String $loginSource;
        public final /* synthetic */ String $password;
        public final /* synthetic */ boolean $undelete;

        /* compiled from: StoreAuthentication.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u0004\u0018\u00010\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/models/domain/auth/ModelLoginResult;", "it", "Lcom/discord/analytics/generated/traits/TrackNetworkMetadataReceiver;", "invoke", "(Lcom/discord/models/domain/auth/ModelLoginResult;)Lcom/discord/analytics/generated/traits/TrackNetworkMetadataReceiver;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
        /* renamed from: com.discord.stores.StoreAuthentication$login$1$1, reason: invalid class name and collision with other inner class name */
        public static final class C00911 extends Lambda implements Function1<ModelLoginResult, TrackNetworkMetadata2> {
            public static final C00911 INSTANCE = new C00911();

            public C00911() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ TrackNetworkMetadata2 invoke(ModelLoginResult modelLoginResult) {
                return invoke2(modelLoginResult);
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final TrackNetworkMetadata2 invoke2(ModelLoginResult modelLoginResult) {
                Observable<T> observableM = ObservableExtensionsKt.takeSingleUntilTimeout$default(StoreStream.INSTANCE.getInviteSettings().getInvite(), 250L, false, 2, null).M(StoreAuthentication4.INSTANCE);
                ModelInvite modelInvite = (ModelInvite) new BlockingObservable(observableM).a(observableM.z());
                return new TrackNetworkActionUserLogin(modelInvite != null ? modelInvite.code : null, null, 2);
            }
        }

        public AnonymousClass1(String str, String str2, CaptchaHelper.CaptchaPayload captchaPayload, boolean z2, String str3) {
            this.$login = str;
            this.$password = str2;
            this.$captchaPayload = captchaPayload;
            this.$undelete = z2;
            this.$loginSource = str3;
        }

        @Override // j0.k.Func1
        public /* bridge */ /* synthetic */ Observable<? extends ModelLoginResult> call(String str) {
            return call2(str);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final Observable<? extends ModelLoginResult> call2(String str) {
            RestAPI api = RestAPI.INSTANCE.getApi();
            String str2 = this.$login;
            String str3 = this.$password;
            CaptchaHelper.CaptchaPayload captchaPayload = this.$captchaPayload;
            String captchaKey = captchaPayload != null ? captchaPayload.getCaptchaKey() : null;
            CaptchaHelper.CaptchaPayload captchaPayload2 = this.$captchaPayload;
            return RestCallState5.logNetworkAction(ObservableExtensionsKt.restSubscribeOn$default(api.postAuthLogin(new RestAPIParams.AuthLogin(str2, str3, captchaKey, captchaPayload2 != null ? captchaPayload2.getCaptchaRqtoken() : null, Boolean.valueOf(this.$undelete), this.$loginSource)), false, 1, null), C00911.INSTANCE);
        }
    }

    /* compiled from: StoreAuthentication.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/discord/models/domain/auth/ModelLoginResult;", "kotlin.jvm.PlatformType", "loginResult", "", NotificationCompat.CATEGORY_CALL, "(Lcom/discord/models/domain/auth/ModelLoginResult;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreAuthentication$login$2, reason: invalid class name */
    public static final class AnonymousClass2<T> implements Action1<ModelLoginResult> {
        public AnonymousClass2() {
        }

        @Override // rx.functions.Action1
        public /* bridge */ /* synthetic */ void call(ModelLoginResult modelLoginResult) {
            call2(modelLoginResult);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final void call2(ModelLoginResult modelLoginResult) {
            if (modelLoginResult.getMfa()) {
                return;
            }
            StoreAuthentication storeAuthentication = StoreAuthentication.this;
            Intrinsics3.checkNotNullExpressionValue(modelLoginResult, "loginResult");
            StoreAuthentication.access$dispatchLogin(storeAuthentication, modelLoginResult);
        }
    }

    /* compiled from: StoreAuthentication.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u0004\u0018\u00010\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Ljava/lang/Void;", "it", "Lcom/discord/analytics/generated/traits/TrackNetworkMetadataReceiver;", "invoke", "(Ljava/lang/Void;)Lcom/discord/analytics/generated/traits/TrackNetworkMetadataReceiver;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreAuthentication$logout$1, reason: invalid class name */
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
            return new TrackNetworkActionUserLogout();
        }
    }

    /* compiled from: StoreAuthentication.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\b\u001a>\u0012\u0018\b\u0001\u0012\u0014 \u0005*\n\u0018\u00010\u0003j\u0004\u0018\u0001`\u00040\u0003j\u0002`\u0004 \u0005*\u001e\u0012\u0018\b\u0001\u0012\u0014 \u0005*\n\u0018\u00010\u0003j\u0004\u0018\u0001`\u00040\u0003j\u0002`\u0004\u0018\u00010\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"Ljava/lang/Void;", "it", "Lrx/Observable;", "", "Lcom/discord/primitives/FingerPrint;", "kotlin.jvm.PlatformType", NotificationCompat.CATEGORY_CALL, "(Ljava/lang/Void;)Lrx/Observable;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreAuthentication$logout$2, reason: invalid class name */
    public static final class AnonymousClass2<T, R> implements Func1<Void, Observable<? extends String>> {
        public AnonymousClass2() {
        }

        @Override // j0.k.Func1
        public /* bridge */ /* synthetic */ Observable<? extends String> call(Void r1) {
            return call2(r1);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final Observable<? extends String> call2(Void r1) {
            return StoreAuthentication.access$getFingerprintSnapshotOrGenerate(StoreAuthentication.this);
        }
    }

    /* compiled from: StoreAuthentication.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0007\u001a\u00020\u00042\u0018\u0010\u0003\u001a\u0014 \u0002*\n\u0018\u00010\u0000j\u0004\u0018\u0001`\u00010\u0000j\u0002`\u0001H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"", "Lcom/discord/primitives/FingerPrint;", "kotlin.jvm.PlatformType", "it", "", "invoke", "(Ljava/lang/String;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreAuthentication$logout$3, reason: invalid class name */
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
            StoreStream.INSTANCE.getNux().clearNux();
            StoreAuthentication.access$publishAuthState(StoreAuthentication.this, null);
        }
    }

    /* compiled from: StoreAuthentication.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/utilities/error/Error;", "it", "", "invoke", "(Lcom/discord/utilities/error/Error;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreAuthentication$logout$4, reason: invalid class name */
    public static final class AnonymousClass4 extends Lambda implements Function1<Error, Unit> {
        public AnonymousClass4() {
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
            StoreAuthentication.access$publishAuthState(StoreAuthentication.this, null);
        }
    }

    /* compiled from: StoreAuthentication.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreAuthentication$onPasswordChanged$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ String $token;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(String str) {
            super(0);
            this.$token = str;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            Set<RequiredAction> setEmptySet;
            AuthState authState = StoreAuthentication.this.getAuthState();
            if (authState == null || (setEmptySet = authState.getRequiredActions()) == null) {
                setEmptySet = Sets5.emptySet();
            }
            StoreAuthentication.access$publishAuthState(StoreAuthentication.this, AuthState.INSTANCE.from(this.$token, _Sets.minus(setEmptySet, RequiredAction.UPDATE_PASSWORD)));
        }
    }

    /* compiled from: StoreAuthentication.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\b\u001a*\u0012\u000e\b\u0001\u0012\n \u0002*\u0004\u0018\u00010\u00050\u0005 \u0002*\u0014\u0012\u000e\b\u0001\u0012\n \u0002*\u0004\u0018\u00010\u00050\u0005\u0018\u00010\u00040\u00042\u0018\u0010\u0003\u001a\u0014 \u0002*\n\u0018\u00010\u0000j\u0004\u0018\u0001`\u00010\u0000j\u0002`\u0001H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"", "Lcom/discord/primitives/FingerPrint;", "kotlin.jvm.PlatformType", "fingerprint", "Lrx/Observable;", "Lcom/discord/api/auth/RegisterResponse;", NotificationCompat.CATEGORY_CALL, "(Ljava/lang/String;)Lrx/Observable;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreAuthentication$register$1, reason: invalid class name */
    public static final class AnonymousClass1<T, R> implements Func1<String, Observable<? extends RegisterResponse>> {
        public final /* synthetic */ CaptchaHelper.CaptchaPayload $captchaPayload;
        public final /* synthetic */ boolean $consent;
        public final /* synthetic */ String $dateOfBirth;
        public final /* synthetic */ String $email;
        public final /* synthetic */ String $password;
        public final /* synthetic */ String $phoneToken;
        public final /* synthetic */ String $username;

        /* compiled from: StoreAuthentication.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0007\u001a\u00020\u00042\b\u0010\u0001\u001a\u0004\u0018\u00010\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lcom/discord/stores/StoreInviteSettings$InviteCode;", "p1", "", "p2", "Lcom/discord/stores/StoreAuthentication$AuthRequestParams;", "invoke", "(Lcom/discord/stores/StoreInviteSettings$InviteCode;Ljava/lang/String;)Lcom/discord/stores/StoreAuthentication$AuthRequestParams;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
        /* renamed from: com.discord.stores.StoreAuthentication$register$1$1, reason: invalid class name and collision with other inner class name */
        public static final /* synthetic */ class C00921 extends FunctionReferenceImpl implements Function2<StoreInviteSettings.InviteCode, String, AuthRequestParams> {
            public static final C00921 INSTANCE = new C00921();

            public C00921() {
                super(2, AuthRequestParams.class, "<init>", "<init>(Lcom/discord/stores/StoreInviteSettings$InviteCode;Ljava/lang/String;)V", 0);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ AuthRequestParams invoke(StoreInviteSettings.InviteCode inviteCode, String str) {
                return invoke2(inviteCode, str);
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final AuthRequestParams invoke2(StoreInviteSettings.InviteCode inviteCode, String str) {
                return new AuthRequestParams(inviteCode, str);
            }
        }

        /* compiled from: StoreAuthentication.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0007\u001a*\u0012\u000e\b\u0001\u0012\n \u0001*\u0004\u0018\u00010\u00040\u0004 \u0001*\u0014\u0012\u000e\b\u0001\u0012\n \u0001*\u0004\u0018\u00010\u00040\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lcom/discord/stores/StoreAuthentication$AuthRequestParams;", "kotlin.jvm.PlatformType", "params", "Lrx/Observable;", "Lcom/discord/api/auth/RegisterResponse;", NotificationCompat.CATEGORY_CALL, "(Lcom/discord/stores/StoreAuthentication$AuthRequestParams;)Lrx/Observable;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
        /* renamed from: com.discord.stores.StoreAuthentication$register$1$2, reason: invalid class name */
        public static final class AnonymousClass2<T, R> implements Func1<AuthRequestParams, Observable<? extends RegisterResponse>> {
            public final /* synthetic */ String $fingerprint;

            /* compiled from: StoreAuthentication.kt */
            @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u0004\u0018\u00010\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/api/auth/RegisterResponse;", "it", "Lcom/discord/analytics/generated/traits/TrackNetworkMetadataReceiver;", "invoke", "(Lcom/discord/api/auth/RegisterResponse;)Lcom/discord/analytics/generated/traits/TrackNetworkMetadataReceiver;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
            /* renamed from: com.discord.stores.StoreAuthentication$register$1$2$1, reason: invalid class name and collision with other inner class name */
            public static final class C00931 extends Lambda implements Function1<RegisterResponse, TrackNetworkMetadata2> {
                public final /* synthetic */ String $inviteCode;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public C00931(String str) {
                    super(1);
                    this.$inviteCode = str;
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ TrackNetworkMetadata2 invoke(RegisterResponse registerResponse) {
                    return invoke2(registerResponse);
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final TrackNetworkMetadata2 invoke2(RegisterResponse registerResponse) {
                    return new TrackNetworkActionUserRegister(this.$inviteCode, Boolean.valueOf(AnonymousClass1.this.$consent), Boolean.FALSE);
                }
            }

            public AnonymousClass2(String str) {
                this.$fingerprint = str;
            }

            @Override // j0.k.Func1
            public /* bridge */ /* synthetic */ Observable<? extends RegisterResponse> call(AuthRequestParams authRequestParams) {
                return call2(authRequestParams);
            }

            /* renamed from: call, reason: avoid collision after fix types in other method */
            public final Observable<? extends RegisterResponse> call2(AuthRequestParams authRequestParams) {
                StoreInviteSettings.InviteCode inviteCode = authRequestParams.getInviteCode();
                String inviteCode2 = inviteCode != null ? inviteCode.getInviteCode() : null;
                if (inviteCode2 == null || inviteCode2.length() == 0) {
                    StoreStream.INSTANCE.getNux().setPostRegister(true);
                } else {
                    StoreStream.INSTANCE.getNux().setPostRegisterWithInvite(true);
                }
                RestAPI api = RestAPI.INSTANCE.getApi();
                String str = this.$fingerprint;
                AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                String str2 = anonymousClass1.$username;
                String str3 = anonymousClass1.$email;
                String str4 = anonymousClass1.$phoneToken;
                String str5 = anonymousClass1.$password;
                CaptchaHelper.CaptchaPayload captchaPayload = anonymousClass1.$captchaPayload;
                String captchaKey = captchaPayload != null ? captchaPayload.getCaptchaKey() : null;
                CaptchaHelper.CaptchaPayload captchaPayload2 = AnonymousClass1.this.$captchaPayload;
                String captchaRqtoken = captchaPayload2 != null ? captchaPayload2.getCaptchaRqtoken() : null;
                String guildTemplateCode = authRequestParams.getGuildTemplateCode();
                AnonymousClass1 anonymousClass12 = AnonymousClass1.this;
                return RestCallState5.logNetworkAction(api.postAuthRegister(new RestAPIParams.AuthRegister(str, str2, str3, str4, str5, captchaKey, captchaRqtoken, inviteCode2, guildTemplateCode, anonymousClass12.$consent, anonymousClass12.$dateOfBirth)), new C00931(inviteCode2));
            }
        }

        /* compiled from: StoreAuthentication.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/discord/api/auth/RegisterResponse;", "kotlin.jvm.PlatformType", "response", "", NotificationCompat.CATEGORY_CALL, "(Lcom/discord/api/auth/RegisterResponse;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
        /* renamed from: com.discord.stores.StoreAuthentication$register$1$3, reason: invalid class name */
        public static final class AnonymousClass3<T> implements Action1<RegisterResponse> {
            public AnonymousClass3() {
            }

            @Override // rx.functions.Action1
            public /* bridge */ /* synthetic */ void call(RegisterResponse registerResponse) {
                call2(registerResponse);
            }

            /* renamed from: call, reason: avoid collision after fix types in other method */
            public final void call2(RegisterResponse registerResponse) {
                StoreStream.Companion companion = StoreStream.INSTANCE;
                companion.getUserSettingsSystem().setIsSyncThemeEnabled(false);
                StoreAuthentication.this.setFingerprint(null, true);
                StoreAuthentication.access$publishAuthState(StoreAuthentication.this, new AuthState(registerResponse.getToken(), Sets5.emptySet()));
                AnalyticsTracker.INSTANCE.appFirstLogin();
                companion.getNotifications().setEnabledInApp(true, false);
                companion.getNux().setFirstOpen(true);
            }
        }

        public AnonymousClass1(String str, String str2, String str3, String str4, CaptchaHelper.CaptchaPayload captchaPayload, boolean z2, String str5) {
            this.$username = str;
            this.$email = str2;
            this.$phoneToken = str3;
            this.$password = str4;
            this.$captchaPayload = captchaPayload;
            this.$consent = z2;
            this.$dateOfBirth = str5;
        }

        @Override // j0.k.Func1
        public /* bridge */ /* synthetic */ Observable<? extends RegisterResponse> call(String str) {
            return call2(str);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final Observable<? extends RegisterResponse> call2(String str) {
            StoreStream.Companion companion = StoreStream.INSTANCE;
            Observable<StoreInviteSettings.InviteCode> inviteCode = companion.getInviteSettings().getInviteCode();
            Observable<String> observableObserveDynamicLinkGuildTemplateCode = companion.getGuildTemplates().observeDynamicLinkGuildTemplateCode();
            C00921 c00921 = C00921.INSTANCE;
            Object storeAuthentication6 = c00921;
            if (c00921 != null) {
                storeAuthentication6 = new StoreAuthentication6(c00921);
            }
            Observable observableJ = Observable.j(inviteCode, observableObserveDynamicLinkGuildTemplateCode, (Func2) storeAuthentication6);
            Intrinsics3.checkNotNullExpressionValue(observableJ, "Observable.combineLatest…RequestParams\n          )");
            Observable<R> observableA = ObservableExtensionsKt.takeSingleUntilTimeout$default(observableJ, 500L, false, 2, null).A(new AnonymousClass2(str));
            Intrinsics3.checkNotNullExpressionValue(observableA, "Observable.combineLatest…        }\n              }");
            return ObservableExtensionsKt.takeSingleUntilTimeout$default(ObservableExtensionsKt.restSubscribeOn$default(observableA, false, 1, null), 0L, false, 3, null).u(new AnonymousClass3());
        }
    }

    /* compiled from: StoreAuthentication.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/models/domain/ModelLocationMetadata;", "it", "", "invoke", "(Lcom/discord/models/domain/ModelLocationMetadata;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreAuthentication$requestConsentRequired$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<ModelLocationMetadata, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ModelLocationMetadata modelLocationMetadata) {
            invoke2(modelLocationMetadata);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ModelLocationMetadata modelLocationMetadata) {
            Intrinsics3.checkNotNullParameter(modelLocationMetadata, "it");
            StoreAuthentication.access$setConsentRequired$p(StoreAuthentication.this, modelLocationMetadata.getConsentRequired());
            String countryCode = modelLocationMetadata.getCountryCode();
            if (countryCode != null) {
                StoreStream.INSTANCE.getPhone().updateDefaultCountryCode(countryCode);
            }
        }
    }

    /* compiled from: StoreAuthentication.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/utilities/error/Error;", "it", "", "invoke", "(Lcom/discord/utilities/error/Error;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreAuthentication$requestConsentRequired$2, reason: invalid class name */
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
            StoreAuthentication.access$setConsentRequired$p(StoreAuthentication.this, true);
        }
    }

    /* compiled from: StoreAuthentication.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lrx/Subscription;", "consentSubscription", "", "invoke", "(Lrx/Subscription;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreAuthentication$requestConsentRequired$3, reason: invalid class name */
    public static final class AnonymousClass3 extends Lambda implements Function1<Subscription, Unit> {
        public AnonymousClass3() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Subscription subscription) {
            invoke2(subscription);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Subscription subscription) {
            Intrinsics3.checkNotNullParameter(subscription, "consentSubscription");
            StoreAuthentication.access$setConsentRequiredSubscription$p(StoreAuthentication.this, subscription);
        }
    }

    /* compiled from: StoreAuthentication.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreAuthentication$setAgeGateError$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ String $error;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(String str) {
            super(0);
            this.$error = str;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            StoreAuthentication.this.handleAgeGateError(this.$error);
        }
    }

    public StoreAuthentication(StoreStream storeStream, Dispatcher dispatcher) {
        Intrinsics3.checkNotNullParameter(storeStream, "storeStream");
        Intrinsics3.checkNotNullParameter(dispatcher, "dispatcher");
        this.storeStream = storeStream;
        this.dispatcher = dispatcher;
        this.userInitiatedAuthEventSubject = PublishSubject.k0();
        this.fingerprintSubject = new SerializedSubject<>(BehaviorSubject.k0());
        this.authStateSubject = new SerializedSubject<>(BehaviorSubject.l0(null));
        BehaviorSubject<String> behaviorSubjectK0 = BehaviorSubject.k0();
        Intrinsics3.checkNotNullExpressionValue(behaviorSubjectK0, "BehaviorSubject.create()");
        this.ageGateError = behaviorSubjectK0;
        this.oauthUriSubject = new SerializedSubject<>(BehaviorSubject.l0(Uri.EMPTY));
        this.authStateCache = new AuthStateCache(getPrefs());
    }

    public static final /* synthetic */ void access$dispatchLogin(StoreAuthentication storeAuthentication, ModelLoginResult modelLoginResult) {
        storeAuthentication.dispatchLogin(modelLoginResult);
    }

    public static final /* synthetic */ AuthState access$getAuthState$p(StoreAuthentication storeAuthentication) {
        return storeAuthentication.authState;
    }

    public static final /* synthetic */ Observable access$getFingerprintSnapshotOrGenerate(StoreAuthentication storeAuthentication) {
        return storeAuthentication.getFingerprintSnapshotOrGenerate();
    }

    public static final /* synthetic */ StoreStream access$getStoreStream$p(StoreAuthentication storeAuthentication) {
        return storeAuthentication.storeStream;
    }

    public static final /* synthetic */ boolean access$isConsentRequired$p(StoreAuthentication storeAuthentication) {
        return storeAuthentication.isConsentRequired();
    }

    public static final /* synthetic */ Subscription access$isConsentRequiredSubscription$p(StoreAuthentication storeAuthentication) {
        return storeAuthentication.isConsentRequiredSubscription;
    }

    public static final /* synthetic */ void access$publishAuthState(StoreAuthentication storeAuthentication, AuthState authState) {
        storeAuthentication.publishAuthState(authState);
    }

    public static final /* synthetic */ void access$setAuthState$p(StoreAuthentication storeAuthentication, AuthState authState) {
        storeAuthentication.authState = authState;
    }

    public static final /* synthetic */ void access$setConsentRequired$p(StoreAuthentication storeAuthentication, boolean z2) {
        storeAuthentication.setConsentRequired(z2);
    }

    public static final /* synthetic */ void access$setConsentRequiredSubscription$p(StoreAuthentication storeAuthentication, Subscription subscription) {
        storeAuthentication.isConsentRequiredSubscription = subscription;
    }

    private final void dispatchLogin(ModelLoginResult loginResult) {
        this.dispatcher.schedule(new AnonymousClass1(loginResult));
    }

    private final Observable<String> getFingerprintSnapshotOrGenerate() {
        Observable<String> observableU = this.fingerprintSubject.Z(1).Y(AnonymousClass1.INSTANCE).u(new AnonymousClass2());
        Intrinsics3.checkNotNullExpressionValue(observableU, "fingerprintSubject\n     …int(fingerprint, false) }");
        return observableU;
    }

    private final Set<RequiredAction> getRequiredActionsFromLoginResponse(ModelLoginResult loginResult) {
        Set<RequiredAction> set;
        List<RequiredAction> requiredActions = loginResult.getRequiredActions();
        return (requiredActions == null || (set = _Collections.toSet(requiredActions)) == null) ? Sets5.emptySet() : set;
    }

    public static /* synthetic */ Observable login$default(StoreAuthentication storeAuthentication, String str, String str2, CaptchaHelper.CaptchaPayload captchaPayload, boolean z2, String str3, int i, Object obj) {
        if ((i & 16) != 0) {
            str3 = null;
        }
        return storeAuthentication.login(str, str2, captchaPayload, z2, str3);
    }

    private final void publishAuthState(AuthState authState) {
        this.authStateSubject.k.onNext(authState);
    }

    public static /* synthetic */ Observable register$default(StoreAuthentication storeAuthentication, String str, String str2, String str3, String str4, CaptchaHelper.CaptchaPayload captchaPayload, boolean z2, String str5, int i, Object obj) {
        return storeAuthentication.register(str, str2, str3, str4, captchaPayload, z2, (i & 64) != 0 ? null : str5);
    }

    private final synchronized void resetIsConsentRequired() {
        this._isConsentRequired = null;
        Subscription subscription = this.isConsentRequiredSubscription;
        if (subscription != null) {
            subscription.unsubscribe();
        }
        this.isConsentRequiredSubscription = null;
    }

    private final synchronized void setConsentRequired(boolean z2) {
        this._isConsentRequired = Boolean.valueOf(z2);
    }

    private final void setSavedLogin(String str) {
        this.savedLogin = str;
        AppLog.g(null, str, null);
        getPrefsSessionDurable().edit().putString(CACHE_KEY_LOGIN, str).apply();
    }

    public final Observable<ModelLoginResult> authMFA(String code, String ticket) {
        Intrinsics3.checkNotNullParameter(code, ModelAuditLogEntry.CHANGE_KEY_CODE);
        Intrinsics3.checkNotNullParameter(ticket, "ticket");
        Observable<ModelLoginResult> observableU = ObservableExtensionsKt.restSubscribeOn$default(RestCallState5.logNetworkAction(RestAPI.INSTANCE.getApi().postMFACode(new RestAPIParams.MFALogin(ticket, code)), AnonymousClass1.INSTANCE), false, 1, null).u(new AnonymousClass2());
        Intrinsics3.checkNotNullExpressionValue(observableU, "RestAPI\n        .api\n   …in(loginResult)\n        }");
        return observableU;
    }

    public final Observable<Void> authorizeIP(String token) {
        Intrinsics3.checkNotNullParameter(token, CACHE_KEY_TOKEN_RNA);
        return RestCallState5.logNetworkAction(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.INSTANCE.getApi().authorizeIP(new RestAPIParams.AuthorizeIP(token)), false, 1, null), AnonymousClass1.INSTANCE);
    }

    public final Observable<Void> forgotPassword(String login, CaptchaHelper.CaptchaPayload captchaPayload) {
        Intrinsics3.checkNotNullParameter(login, "login");
        return ObservableExtensionsKt.restSubscribeOn$default(RestCallState5.logNetworkAction(RestAPI.INSTANCE.getApi().forgotPassword(new RestAPIParams.ForgotPassword(login, captchaPayload != null ? captchaPayload.getCaptchaKey() : null, captchaPayload != null ? captchaPayload.getCaptchaRqtoken() : null)), AnonymousClass1.INSTANCE), false, 1, null);
    }

    public final Observable<String> getAgeGateError() {
        Observable<String> observableR = this.ageGateError.r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "ageGateError.distinctUntilChanged()");
        return observableR;
    }

    /* renamed from: getAuthState$app_productionGoogleRelease, reason: from getter */
    public final AuthState getAuthState() {
        return this.authState;
    }

    public final Observable<String> getAuthedToken$app_productionGoogleRelease() {
        Observable observableG = this.authStateSubject.r().G(StoreAuthentication2.INSTANCE);
        Intrinsics3.checkNotNullExpressionValue(observableG, "authStateSubject.distinc…anged().map { it?.token }");
        return observableG;
    }

    public final Observable<String> getFingerPrint$app_productionGoogleRelease() {
        Observable<String> observableR = this.fingerprintSubject.r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "fingerprintSubject.distinctUntilChanged()");
        return observableR;
    }

    /* renamed from: getFingerprint$app_productionGoogleRelease, reason: from getter */
    public final String getFingerprint() {
        return this.fingerprint;
    }

    public final Observable<Uri> getOAuthUriObservable() {
        Observable<Uri> observableR = this.oauthUriSubject.r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "oauthUriSubject.distinctUntilChanged()");
        return observableR;
    }

    public final Observable<Boolean> getPreLogoutSignal$app_productionGoogleRelease() {
        Observable<Boolean> observableY = this.userInitiatedAuthEventSubject.y(StoreAuthentication3.INSTANCE);
        Intrinsics3.checkNotNullExpressionValue(observableY, "userInitiatedAuthEventSu…LoggedIn -> !isLoggedIn }");
        return observableY;
    }

    public final String getSavedLogin() {
        return this.savedLogin;
    }

    public final Observable<StoreNavigation.AgeGate> getShouldShowAgeGate() {
        Observable<StoreNavigation.AgeGate> observableR = Observable.i(this.storeStream.getUsers().observeMe(true), this.storeStream.getAuthentication().getAgeGateError(), this.storeStream.getChannelsSelected().observeSelectedChannel(), AnonymousClass1.INSTANCE).r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "Observable.combineLatest…  .distinctUntilChanged()");
        return observableR;
    }

    @Store3
    public final void handleAgeGateError(String error) {
        this.ageGateError.onNext(error);
    }

    @Store3
    public final void handleAuthState$app_productionGoogleRelease(AuthState authState) {
        this.authState = authState;
        this.authStateCache.cacheAuthState(authState);
        if (authState == null) {
            Persister.INSTANCE.reset();
            SharedPreferences.Editor editorEdit = getPrefs().edit();
            Intrinsics3.checkNotNullExpressionValue(editorEdit, "editor");
            editorEdit.clear();
            editorEdit.apply();
        }
    }

    @Store3
    public final void handleLoginResult(ModelLoginResult loginResult) {
        Intrinsics3.checkNotNullParameter(loginResult, "loginResult");
        setFingerprint(null, true);
        publishAuthState(AuthState.INSTANCE.from(loginResult.getToken(), getRequiredActionsFromLoginResponse(loginResult)));
        if (loginResult.getToken() != null) {
            setAgeGateError(null);
            AnalyticsTracker.INSTANCE.appFirstLogin();
        }
        PublishSubject<Boolean> publishSubject = this.userInitiatedAuthEventSubject;
        publishSubject.k.onNext(Boolean.TRUE);
        StoreStream.INSTANCE.getNux().setFirstOpen(true);
    }

    @Store3
    public final void handlePreLogout$app_productionGoogleRelease() {
        resetIsConsentRequired();
    }

    @Override // com.discord.stores.Store
    @Store3
    public synchronized void init(Context context) {
        Intrinsics3.checkNotNullParameter(context, "context");
        super.init(context);
        String string = getPrefsSessionDurable().getString(CACHE_KEY_FINGERPRINT, null);
        if (string != null) {
            setFingerprint(string, false);
        }
        AuthState cachedAuthState = this.authStateCache.getCachedAuthState();
        if (cachedAuthState == null) {
            cachedAuthState = AuthState.INSTANCE.from(Companion.access$getRnaAuthToken(INSTANCE, context), Sets5.emptySet());
        }
        if (AuthState.INSTANCE.isUpdatePasswordRequired(cachedAuthState)) {
            logout();
        } else {
            this.authState = cachedAuthState;
            publishAuthState(cachedAuthState);
        }
        handleAgeGateError(null);
        setSavedLogin(getPrefsSessionDurable().getString(CACHE_KEY_LOGIN, Companion.access$getDeviceEmail(INSTANCE, context)));
        Observable<Boolean> observableR = this.userInitiatedAuthEventSubject.r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "userInitiatedAuthEventSu…  .distinctUntilChanged()");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui(ObservableExtensionsKt.computationLatest(observableR)), getClass(), (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(context), 62, (Object) null);
    }

    public final boolean isAuthed() {
        return this.authState != null;
    }

    public final synchronized boolean isConsentRequired() {
        Boolean bool;
        bool = this._isConsentRequired;
        return bool != null ? bool.booleanValue() : true;
    }

    public final Observable<ModelLoginResult> login(String login, String password, CaptchaHelper.CaptchaPayload captchaPayload, boolean undelete, String loginSource) {
        Intrinsics3.checkNotNullParameter(login, "login");
        Intrinsics3.checkNotNullParameter(password, WidgetSettingsAccountChangePassword.CURRENT_PASSWORD_FIELD);
        setSavedLogin(login);
        Observable<ModelLoginResult> observableU = getFingerprintSnapshotOrGenerate().A(new AnonymousClass1(login, password, captchaPayload, undelete, loginSource)).u(new AnonymousClass2());
        Intrinsics3.checkNotNullExpressionValue(observableU, "getFingerprintSnapshotOr…lt)\n          }\n        }");
        return observableU;
    }

    public final void logout() {
        PublishSubject<Boolean> publishSubject = this.userInitiatedAuthEventSubject;
        publishSubject.k.onNext(Boolean.FALSE);
        Observable observableA = ObservableExtensionsKt.restSubscribeOn$default(RestCallState5.logNetworkAction(RestAPI.INSTANCE.getApi().logout(new RestAPIParams.UserDevices(StoreStream.INSTANCE.getNotifications().getPushToken())), AnonymousClass1.INSTANCE), false, 1, null).A(new AnonymousClass2());
        Intrinsics3.checkNotNullExpressionValue(observableA, "RestAPI\n        .api\n   …intSnapshotOrGenerate() }");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.takeSingleUntilTimeout$default(observableA, 0L, false, 3, null), (Context) null, "logout", (Function1) null, new AnonymousClass3(), new AnonymousClass4(), (Function0) null, (Function0) null, 101, (Object) null);
    }

    public final Observable<Boolean> observeIsAuthed$app_productionGoogleRelease() {
        Observable observableG = m8getAuthState$app_productionGoogleRelease().G(StoreAuthentication5.INSTANCE);
        Intrinsics3.checkNotNullExpressionValue(observableG, "getAuthState()\n      .ma…te -> authState != null }");
        return observableG;
    }

    public final void onPasswordChanged(String token) {
        this.dispatcher.schedule(new AnonymousClass1(token));
    }

    public final Observable<RegisterResponse> register(String username, String email, String phoneToken, String password, CaptchaHelper.CaptchaPayload captchaPayload, boolean consent, String dateOfBirth) {
        Intrinsics3.checkNotNullParameter(username, "username");
        Intrinsics3.checkNotNullParameter(password, WidgetSettingsAccountChangePassword.CURRENT_PASSWORD_FIELD);
        setSavedLogin(email);
        Observable observableA = getFingerprintSnapshotOrGenerate().A(new AnonymousClass1(username, email, phoneToken, password, captchaPayload, consent, dateOfBirth));
        Intrinsics3.checkNotNullExpressionValue(observableA, "getFingerprintSnapshotOr…              }\n        }");
        return observableA;
    }

    public final synchronized void requestConsentRequired() {
        if (this._isConsentRequired != null) {
            return;
        }
        resetIsConsentRequired();
        Observable observableRestSubscribeOn$default = ObservableExtensionsKt.restSubscribeOn$default(RestAPI.INSTANCE.getApi().getLocationMetadata(), false, 1, null);
        Class<?> cls = getClass();
        AnonymousClass1 anonymousClass1 = new AnonymousClass1();
        ObservableExtensionsKt.appSubscribe$default(observableRestSubscribeOn$default, cls, (Context) null, new AnonymousClass3(), new AnonymousClass2(), (Function0) null, (Function0) null, anonymousClass1, 50, (Object) null);
    }

    public final void setAgeGateError(String error) {
        this.dispatcher.schedule(new AnonymousClass1(error));
    }

    public final void setAuthed(String authToken) {
        publishAuthState(AuthState.INSTANCE.from(authToken, Sets5.emptySet()));
    }

    /* JADX WARN: Removed duplicated region for block: B:6:0x0007 A[Catch: all -> 0x0044, TryCatch #0 {, blocks: (B:4:0x0003, B:9:0x002c, B:11:0x0030, B:14:0x003a, B:6:0x0007, B:8:0x0023), top: B:20:0x0003 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final synchronized void setFingerprint(String fingerprint, boolean force) {
        if (!force) {
            if (this.fingerprint == null) {
                getPrefsSessionDurable().edit().putString(CACHE_KEY_FINGERPRINT, fingerprint).apply();
                this.fingerprint = fingerprint;
                this.fingerprintSubject.k.onNext(fingerprint);
                if (fingerprint != null) {
                    FirebaseCrashlytics.getInstance().setCustomKey("fingerprint", fingerprint);
                }
            }
            if (this.fingerprint != null && (!Intrinsics3.areEqual(r3, fingerprint)) && fingerprint != null) {
                String str = this.fingerprint;
                Intrinsics3.checkNotNull(str);
                AnalyticsTracker.externalFingerprintDropped(str, fingerprint);
            }
        }
    }

    public final void setOAuthUriSubject(Uri uri) {
        Intrinsics3.checkNotNullParameter(uri, NotificationCompat.MessagingStyle.Message.KEY_DATA_URI);
        this.oauthUriSubject.k.onNext(uri);
    }

    /* renamed from: getAuthState$app_productionGoogleRelease, reason: collision with other method in class */
    public final Observable<AuthState> m8getAuthState$app_productionGoogleRelease() {
        Observable<AuthState> observableR = this.authStateSubject.r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "authStateSubject.distinctUntilChanged()");
        return observableR;
    }
}
