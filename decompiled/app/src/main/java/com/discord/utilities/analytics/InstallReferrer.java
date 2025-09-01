package com.discord.utilities.analytics;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.RemoteException;
import b.d.b.a.outline;
import com.android.installreferrer.api.InstallReferrerClient;
import com.android.installreferrer.api.InstallReferrerStateListener;
import com.android.installreferrer.api.ReferrerDetails;
import com.discord.utilities.cache.SharedPreferencesProvider;
import com.discord.utilities.lifecycle.ApplicationProvider;
import com.discord.utilities.logging.Logger;
import com.discord.utilities.logging.LoggingProvider;
import d0.LazyJVM;
import d0.z.d.Intrinsics3;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: InstallReferrer.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Q\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0002\n\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0001\u0006\u0018\u0000 &2\u00020\u0001:\u0001&B\u001d\b\u0002\u0012\b\b\u0002\u0010\u001f\u001a\u00020\u001e\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0015¢\u0006\u0004\b$\u0010%J#\u0010\u0007\u001a\u00020\u00062\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\u000e\u001a\u00020\u00042\u000e\u0010\r\u001a\n\u0018\u00010\u000bj\u0004\u0018\u0001`\fH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0011\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0011\u0010\u0012J!\u0010\u0013\u001a\u00020\u00042\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002¢\u0006\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0016\u001a\u00020\u00158\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u001d\u0010\u001d\u001a\u00020\u00188B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u0016\u0010\u001f\u001a\u00020\u001e8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010\"\u001a\u00020!8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\"\u0010#¨\u0006'"}, d2 = {"Lcom/discord/utilities/analytics/InstallReferrer;", "", "Lkotlin/Function1;", "", "", "onReceivedInstallReferrer", "com/discord/utilities/analytics/InstallReferrer$createReferrerStateListener$1", "createReferrerStateListener", "(Lkotlin/jvm/functions/Function1;)Lcom/discord/utilities/analytics/InstallReferrer$createReferrerStateListener$1;", "setFetchInstallReferrerSuccessful", "()V", "Ljava/lang/Exception;", "Lkotlin/Exception;", "e", "setFetchInstallReferrerFailed", "(Ljava/lang/Exception;)V", "", "shouldFetchInstallReferrer", "()Z", "init", "(Lkotlin/jvm/functions/Function1;)V", "Landroid/content/Context;", "context", "Landroid/content/Context;", "Landroid/content/SharedPreferences;", "sharedPreferences$delegate", "Lkotlin/Lazy;", "getSharedPreferences", "()Landroid/content/SharedPreferences;", "sharedPreferences", "Lcom/discord/utilities/logging/Logger;", "logger", "Lcom/discord/utilities/logging/Logger;", "Lcom/android/installreferrer/api/InstallReferrerClient;", "referrerClient", "Lcom/android/installreferrer/api/InstallReferrerClient;", "<init>", "(Lcom/discord/utilities/logging/Logger;Landroid/content/Context;)V", "Companion", "utils_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class InstallReferrer {
    private static final String CACHE_KEY_HAS_EXECUTED = "CACHE_KEY_HAS_EXECUTED";
    private static final String CACHE_KEY_HAS_EXECUTED_ATTEMPTS = "CACHE_KEY_HAS_EXECUTED_ATTEMPTS";

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Lazy INSTANCE$delegate = LazyJVM.lazy(InstallReferrer2.INSTANCE);
    private static final int MAX_ATTEMPTS = 10;
    private final Context context;
    private final Logger logger;
    private InstallReferrerClient referrerClient;

    /* renamed from: sharedPreferences$delegate, reason: from kotlin metadata */
    private final Lazy sharedPreferences;

    /* compiled from: InstallReferrer.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0014\u0010\u0015J!\u0010\u0006\u001a\u00020\u00042\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u001d\u0010\r\u001a\u00020\b8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u000e\u001a\u00020\u00038\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0010\u001a\u00020\u00038\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0010\u0010\u000fR\u0016\u0010\u0012\u001a\u00020\u00118\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013¨\u0006\u0016"}, d2 = {"Lcom/discord/utilities/analytics/InstallReferrer$Companion;", "", "Lkotlin/Function1;", "", "", "onReceivedInstallReferrer", "init", "(Lkotlin/jvm/functions/Function1;)V", "Lcom/discord/utilities/analytics/InstallReferrer;", "INSTANCE$delegate", "Lkotlin/Lazy;", "getINSTANCE", "()Lcom/discord/utilities/analytics/InstallReferrer;", "INSTANCE", InstallReferrer.CACHE_KEY_HAS_EXECUTED, "Ljava/lang/String;", InstallReferrer.CACHE_KEY_HAS_EXECUTED_ATTEMPTS, "", "MAX_ATTEMPTS", "I", "<init>", "()V", "utils_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        private final InstallReferrer getINSTANCE() {
            Lazy lazyAccess$getINSTANCE$cp = InstallReferrer.access$getINSTANCE$cp();
            Companion companion = InstallReferrer.INSTANCE;
            return (InstallReferrer) lazyAccess$getINSTANCE$cp.getValue();
        }

        public final void init(Function1<? super String, Unit> onReceivedInstallReferrer) {
            Intrinsics3.checkNotNullParameter(onReceivedInstallReferrer, "onReceivedInstallReferrer");
            getINSTANCE().init(onReceivedInstallReferrer);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: InstallReferrer.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"com/discord/utilities/analytics/InstallReferrer$createReferrerStateListener$1", "Lcom/android/installreferrer/api/InstallReferrerStateListener;", "", "responseCode", "", "onInstallReferrerSetupFinished", "(I)V", "onInstallReferrerServiceDisconnected", "()V", "utils_release"}, k = 1, mv = {1, 4, 2})
    /* renamed from: com.discord.utilities.analytics.InstallReferrer$createReferrerStateListener$1, reason: invalid class name */
    public static final class AnonymousClass1 implements InstallReferrerStateListener {
        public final /* synthetic */ Function1 $onReceivedInstallReferrer;

        public AnonymousClass1(Function1 function1) {
            this.$onReceivedInstallReferrer = function1;
        }

        @Override // com.android.installreferrer.api.InstallReferrerStateListener
        public void onInstallReferrerServiceDisconnected() {
            Logger.d$default(InstallReferrer.access$getLogger$p(InstallReferrer.this), "Install referrer service disconnected.", null, 2, null);
        }

        @Override // com.android.installreferrer.api.InstallReferrerStateListener
        public void onInstallReferrerSetupFinished(int responseCode) {
            if (responseCode != 0) {
                InstallReferrer.access$setFetchInstallReferrerFailed(InstallReferrer.this, null);
            } else {
                try {
                    Function1 function1 = this.$onReceivedInstallReferrer;
                    ReferrerDetails installReferrer = InstallReferrer.access$getReferrerClient$p(InstallReferrer.this).getInstallReferrer();
                    Intrinsics3.checkNotNullExpressionValue(installReferrer, "referrerClient.installReferrer");
                    String installReferrer2 = installReferrer.getInstallReferrer();
                    Intrinsics3.checkNotNullExpressionValue(installReferrer2, "referrerClient.installReferrer.installReferrer");
                    function1.invoke(installReferrer2);
                    InstallReferrer.access$setFetchInstallReferrerSuccessful(InstallReferrer.this);
                } catch (Exception e) {
                    InstallReferrer.access$setFetchInstallReferrerFailed(InstallReferrer.this, e);
                }
            }
            try {
                InstallReferrer.access$getReferrerClient$p(InstallReferrer.this).endConnection();
            } catch (Exception e2) {
                InstallReferrer.access$getLogger$p(InstallReferrer.this).i("Unable to end connection, likely already dead.", e2);
            }
        }
    }

    private InstallReferrer(Logger logger, Context context) {
        this.logger = logger;
        this.context = context;
        this.sharedPreferences = LazyJVM.lazy(InstallReferrer3.INSTANCE);
    }

    public static final /* synthetic */ Lazy access$getINSTANCE$cp() {
        return INSTANCE$delegate;
    }

    public static final /* synthetic */ Logger access$getLogger$p(InstallReferrer installReferrer) {
        return installReferrer.logger;
    }

    public static final /* synthetic */ InstallReferrerClient access$getReferrerClient$p(InstallReferrer installReferrer) {
        InstallReferrerClient installReferrerClient = installReferrer.referrerClient;
        if (installReferrerClient == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("referrerClient");
        }
        return installReferrerClient;
    }

    public static final /* synthetic */ void access$setFetchInstallReferrerFailed(InstallReferrer installReferrer, Exception exc) {
        installReferrer.setFetchInstallReferrerFailed(exc);
    }

    public static final /* synthetic */ void access$setFetchInstallReferrerSuccessful(InstallReferrer installReferrer) throws RemoteException {
        installReferrer.setFetchInstallReferrerSuccessful();
    }

    public static final /* synthetic */ void access$setReferrerClient$p(InstallReferrer installReferrer, InstallReferrerClient installReferrerClient) {
        installReferrer.referrerClient = installReferrerClient;
    }

    private final AnonymousClass1 createReferrerStateListener(Function1<? super String, Unit> onReceivedInstallReferrer) {
        return new AnonymousClass1(onReceivedInstallReferrer);
    }

    private final SharedPreferences getSharedPreferences() {
        return (SharedPreferences) this.sharedPreferences.getValue();
    }

    private final void setFetchInstallReferrerFailed(Exception e) {
        int i = SharedPreferencesProvider.INSTANCE.get().getInt(CACHE_KEY_HAS_EXECUTED_ATTEMPTS, 0);
        this.logger.i("Unable to resolve referrer details, " + i + " attempt.", e);
        SharedPreferences.Editor editorEdit = getSharedPreferences().edit();
        Intrinsics3.checkNotNullExpressionValue(editorEdit, "editor");
        editorEdit.putInt(CACHE_KEY_HAS_EXECUTED_ATTEMPTS, i + 1);
        editorEdit.apply();
    }

    private final void setFetchInstallReferrerSuccessful() throws RemoteException {
        InstallReferrerClient installReferrerClient = this.referrerClient;
        if (installReferrerClient == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("referrerClient");
        }
        ReferrerDetails installReferrer = installReferrerClient.getInstallReferrer();
        Intrinsics3.checkNotNullExpressionValue(installReferrer, "referrerClient.installReferrer");
        Logger.i$default(this.logger, outline.w("Retrieved install referrer, ", installReferrer.getInstallReferrer()), null, 2, null);
        SharedPreferences.Editor editorEdit = getSharedPreferences().edit();
        Intrinsics3.checkNotNullExpressionValue(editorEdit, "editor");
        editorEdit.putBoolean(CACHE_KEY_HAS_EXECUTED, true);
        editorEdit.apply();
    }

    private final boolean shouldFetchInstallReferrer() {
        return !getSharedPreferences().getBoolean(CACHE_KEY_HAS_EXECUTED, false) && getSharedPreferences().getInt(CACHE_KEY_HAS_EXECUTED_ATTEMPTS, 0) < 10;
    }

    public final void init(Function1<? super String, Unit> onReceivedInstallReferrer) {
        Intrinsics3.checkNotNullParameter(onReceivedInstallReferrer, "onReceivedInstallReferrer");
        if (shouldFetchInstallReferrer()) {
            try {
                InstallReferrerClient installReferrerClientBuild = InstallReferrerClient.newBuilder(this.context).build();
                Intrinsics3.checkNotNullExpressionValue(installReferrerClientBuild, "InstallReferrerClient.newBuilder(context).build()");
                this.referrerClient = installReferrerClientBuild;
                if (installReferrerClientBuild == null) {
                    try {
                        Intrinsics3.throwUninitializedPropertyAccessException("referrerClient");
                    } catch (Exception e) {
                        this.logger.i("Unable to start connection to referrer client.", e);
                        return;
                    }
                }
                installReferrerClientBuild.startConnection(createReferrerStateListener(onReceivedInstallReferrer));
            } catch (Exception e2) {
                this.logger.i("Unable to initialize referrer client.", e2);
            }
        }
    }

    public /* synthetic */ InstallReferrer(Logger logger, Context context, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? LoggingProvider.INSTANCE.get() : logger, (i & 2) != 0 ? ApplicationProvider.INSTANCE.get() : context);
    }
}
