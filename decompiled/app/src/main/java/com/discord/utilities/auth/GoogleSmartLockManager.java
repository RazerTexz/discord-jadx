package com.discord.utilities.auth;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.net.Uri;
import androidx.fragment.app.Fragment;
import b.c.a.a0.AnimatableValueParser;
import b.d.b.a.outline;
import b.i.a.f.c.a.d.a;
import b.i.a.f.c.a.d.b;
import b.i.a.f.c.a.d.d;
import b.i.a.f.e.k.k;
import b.i.a.f.e.k.s;
import b.i.a.f.e.k.v;
import b.i.a.f.h.c.g;
import b.i.a.f.h.c.h;
import b.i.a.f.h.c.i;
import b.i.a.f.h.c.l;
import b.i.a.f.n.c;
import com.discord.app.AppFragment;
import com.discord.app.AppLog;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.user.MeUser;
import com.discord.stores.StoreNotices;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUser;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.logging.Logger;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.user.UserUtils;
import com.discord.widgets.settings.account.WidgetSettingsAccount;
import com.discord.widgets.settings.account.WidgetSettingsAccountChangePassword;
import com.discord.widgets.tabs.WidgetTabsHost;
import com.google.android.gms.auth.api.credentials.Credential;
import com.google.android.gms.auth.api.credentials.CredentialRequest;
import com.google.android.gms.auth.api.credentials.CredentialsClient;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.ResolvableApiException;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import d0.e0.KClass;
import d0.t.Collections2;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import d0.z.d.Reflection2;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.objectweb.asm.Opcodes;
import rx.Observable;

/* compiled from: GoogleSmartLockManager.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 )2\u00020\u0001:\u0002)*B\u0019\u0012\u0006\u0010&\u001a\u00020%\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0019¢\u0006\u0004\b'\u0010(J'\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\t\u0010\rJ\u001d\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u000f\u0010\u0010J\u001f\u0010\u0013\u001a\u00020\b2\b\u0010\u0011\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0012\u001a\u00020\u000b¢\u0006\u0004\b\u0013\u0010\u0014J\u001d\u0010\u0016\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u000b¢\u0006\u0004\b\u0016\u0010\u0014J\u0015\u0010\u0017\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\u0017\u0010\u0018R\u0019\u0010\u001a\u001a\u00020\u00198\u0006@\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u0016\u0010\u001f\u001a\u00020\u001e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010 R$\u0010#\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u000e0\"0!8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b#\u0010$¨\u0006+"}, d2 = {"Lcom/discord/utilities/auth/GoogleSmartLockManager;", "", "Landroidx/fragment/app/Fragment;", "fragment", "", "requestCode", "Lcom/google/android/gms/common/api/ResolvableApiException;", "rae", "", "resolveResult", "(Landroidx/fragment/app/Fragment;ILcom/google/android/gms/common/api/ResolvableApiException;)V", "", ModelAuditLogEntry.CHANGE_KEY_ID, "(Lcom/google/android/gms/common/api/ResolvableApiException;Ljava/lang/String;)V", "Lcom/discord/app/AppFragment;", "requestCredentials", "(Lcom/discord/app/AppFragment;I)V", "login", "newPassword", "updateAccountInfo", "(Ljava/lang/String;Ljava/lang/String;)V", WidgetSettingsAccountChangePassword.CURRENT_PASSWORD_FIELD, "saveCredentials", "deleteCredentials", "(Ljava/lang/String;)V", "Lcom/discord/utilities/auth/GoogleSmartLockRepo;", "smartLockRepo", "Lcom/discord/utilities/auth/GoogleSmartLockRepo;", "getSmartLockRepo", "()Lcom/discord/utilities/auth/GoogleSmartLockRepo;", "Lcom/google/android/gms/auth/api/credentials/CredentialsClient;", "credentialsClient", "Lcom/google/android/gms/auth/api/credentials/CredentialsClient;", "", "Ld0/e0/c;", "resolvableFragments", "Ljava/util/List;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;Lcom/discord/utilities/auth/GoogleSmartLockRepo;)V", "Companion", "SmartLockCredentials", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class GoogleSmartLockManager {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final String DISCORD_ACCOUNT_IDENTITY = "https://discord.com/";
    public static final boolean ENABLE_SMART_LOCK = false;
    public static final int GOOGLE_SMART_LOCK_REQUEST_CODE_RESOLVE = 4008;
    public static final int GOOGLE_SMART_LOCK_REQUEST_CODE_RESOLVE_FOR_REQUEST = 4009;
    public static final boolean SET_DISCORD_ACCOUNT_DETAILS = true;
    public static final String SMART_LOCK_NOTICE_NAME = "smartlock_resolution_";
    private CredentialsClient credentialsClient;
    private final List<KClass<? extends AppFragment>> resolvableFragments;
    private final GoogleSmartLockRepo smartLockRepo;

    /* compiled from: GoogleSmartLockManager.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0007\u0010\bR\u0016\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0016\u0010\r\u001a\u00020\f8\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u000f\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0011\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0011\u0010\u0010R\u0016\u0010\u0012\u001a\u00020\f8\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0012\u0010\u000eR\u0016\u0010\u0013\u001a\u00020\t8\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0013\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/discord/utilities/auth/GoogleSmartLockManager$Companion;", "", "", "resultCode", "Landroid/content/Intent;", "data", "", "handleResult", "(ILandroid/content/Intent;)V", "", "DISCORD_ACCOUNT_IDENTITY", "Ljava/lang/String;", "", "ENABLE_SMART_LOCK", "Z", "GOOGLE_SMART_LOCK_REQUEST_CODE_RESOLVE", "I", "GOOGLE_SMART_LOCK_REQUEST_CODE_RESOLVE_FOR_REQUEST", "SET_DISCORD_ACCOUNT_DETAILS", "SMART_LOCK_NOTICE_NAME", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public final void handleResult(int resultCode, Intent data) {
            if (resultCode != -1 || data == null) {
                return;
            }
            Credential credential = (Credential) data.getParcelableExtra("com.google.android.gms.credentials.Credential");
            String str = credential != null ? credential.j : null;
            String str2 = credential != null ? credential.n : null;
            if (str == null || str2 == null) {
                return;
            }
            GoogleSmartLockRepo.INSTANCE.getINSTANCE().setSmartLockLogin(str, str2);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: GoogleSmartLockManager.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J$\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0006\u001a\u00020\u00022\b\b\u0002\u0010\u0007\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\n\u0010\u0004J\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011R\u0019\u0010\u0006\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0012\u001a\u0004\b\u0013\u0010\u0004R\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0012\u001a\u0004\b\u0014\u0010\u0004¨\u0006\u0017"}, d2 = {"Lcom/discord/utilities/auth/GoogleSmartLockManager$SmartLockCredentials;", "", "", "component1", "()Ljava/lang/String;", "component2", ModelAuditLogEntry.CHANGE_KEY_ID, WidgetSettingsAccountChangePassword.CURRENT_PASSWORD_FIELD, "copy", "(Ljava/lang/String;Ljava/lang/String;)Lcom/discord/utilities/auth/GoogleSmartLockManager$SmartLockCredentials;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getId", "getPassword", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class SmartLockCredentials {
        private final String id;
        private final String password;

        public SmartLockCredentials(String str, String str2) {
            Intrinsics3.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_ID);
            Intrinsics3.checkNotNullParameter(str2, WidgetSettingsAccountChangePassword.CURRENT_PASSWORD_FIELD);
            this.id = str;
            this.password = str2;
        }

        public static /* synthetic */ SmartLockCredentials copy$default(SmartLockCredentials smartLockCredentials, String str, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = smartLockCredentials.id;
            }
            if ((i & 2) != 0) {
                str2 = smartLockCredentials.password;
            }
            return smartLockCredentials.copy(str, str2);
        }

        /* renamed from: component1, reason: from getter */
        public final String getId() {
            return this.id;
        }

        /* renamed from: component2, reason: from getter */
        public final String getPassword() {
            return this.password;
        }

        public final SmartLockCredentials copy(String id2, String password) {
            Intrinsics3.checkNotNullParameter(id2, ModelAuditLogEntry.CHANGE_KEY_ID);
            Intrinsics3.checkNotNullParameter(password, WidgetSettingsAccountChangePassword.CURRENT_PASSWORD_FIELD);
            return new SmartLockCredentials(id2, password);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof SmartLockCredentials)) {
                return false;
            }
            SmartLockCredentials smartLockCredentials = (SmartLockCredentials) other;
            return Intrinsics3.areEqual(this.id, smartLockCredentials.id) && Intrinsics3.areEqual(this.password, smartLockCredentials.password);
        }

        public final String getId() {
            return this.id;
        }

        public final String getPassword() {
            return this.password;
        }

        public int hashCode() {
            String str = this.id;
            int iHashCode = (str != null ? str.hashCode() : 0) * 31;
            String str2 = this.password;
            return iHashCode + (str2 != null ? str2.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbU = outline.U("SmartLockCredentials(id=");
            sbU.append(this.id);
            sbU.append(", password=");
            return outline.J(sbU, this.password, ")");
        }
    }

    /* compiled from: GoogleSmartLockManager.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0007\u001a\u00020\u00042*\u0010\u0003\u001a&\u0012\f\u0012\n \u0002*\u0004\u0018\u00010\u00010\u0001 \u0002*\u0012\u0012\f\u0012\n \u0002*\u0004\u0018\u00010\u00010\u0001\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lcom/google/android/gms/tasks/Task;", "Lb/i/a/f/c/a/d/a;", "kotlin.jvm.PlatformType", "task", "", "onComplete", "(Lcom/google/android/gms/tasks/Task;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.utilities.auth.GoogleSmartLockManager$requestCredentials$1, reason: invalid class name */
    public static final class AnonymousClass1<TResult> implements c<a> {
        public final /* synthetic */ AppFragment $fragment;
        public final /* synthetic */ int $requestCode;

        public AnonymousClass1(AppFragment appFragment, int i) {
            this.$fragment = appFragment;
            this.$requestCode = i;
        }

        @Override // b.i.a.f.n.c
        public final void onComplete(Task<a> task) {
            Intrinsics3.checkNotNullExpressionValue(task, "task");
            if (task.p()) {
                a aVarL = task.l();
                Intrinsics3.checkNotNullExpressionValue(aVarL, "task.result");
                Credential credentialR = ((b) aVarL.a).R();
                String str = credentialR != null ? credentialR.j : null;
                a aVarL2 = task.l();
                Intrinsics3.checkNotNullExpressionValue(aVarL2, "task.result");
                Credential credentialR2 = ((b) aVarL2.a).R();
                String str2 = credentialR2 != null ? credentialR2.n : null;
                if (str == null || str2 == null) {
                    return;
                }
                GoogleSmartLockManager.this.getSmartLockRepo().setAttemptToSignInWithSmartLock(true);
                GoogleSmartLockManager.this.getSmartLockRepo().setSmartLockLogin(str, str2);
                return;
            }
            Exception excK = task.k();
            if (!(excK instanceof ResolvableApiException)) {
                if (excK instanceof ApiException) {
                    AppLog.g.w("Google Smart Lock", "API Exception requesting credentials", excK);
                    return;
                } else {
                    AppLog.g.w("Google Smart Lock", "Exception requesting credentials", excK);
                    return;
                }
            }
            ResolvableApiException resolvableApiException = (ResolvableApiException) excK;
            boolean z2 = resolvableApiException.mStatus.p != 4;
            AppLog.g.w("Google Smart Lock", "Resolvable Exception requesting credentials", excK);
            if (z2) {
                GoogleSmartLockManager.access$resolveResult(GoogleSmartLockManager.this, this.$fragment, this.$requestCode, resolvableApiException);
            }
        }
    }

    /* compiled from: GoogleSmartLockManager.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/discord/models/user/MeUser;", "kotlin.jvm.PlatformType", "it", "", "invoke", "(Lcom/discord/models/user/MeUser;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.utilities.auth.GoogleSmartLockManager$saveCredentials$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<MeUser, Unit> {
        public final /* synthetic */ String $id;
        public final /* synthetic */ String $password;

        /* compiled from: GoogleSmartLockManager.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0007\u001a\u00020\u00042*\u0010\u0003\u001a&\u0012\f\u0012\n \u0002*\u0004\u0018\u00010\u00010\u0001 \u0002*\u0012\u0012\f\u0012\n \u0002*\u0004\u0018\u00010\u00010\u0001\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lcom/google/android/gms/tasks/Task;", "Ljava/lang/Void;", "kotlin.jvm.PlatformType", "task", "", "onComplete", "(Lcom/google/android/gms/tasks/Task;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
        /* renamed from: com.discord.utilities.auth.GoogleSmartLockManager$saveCredentials$1$1, reason: invalid class name and collision with other inner class name */
        public static final class C02081<TResult> implements c<Void> {
            public C02081() {
            }

            @Override // b.i.a.f.n.c
            public final void onComplete(Task<Void> task) {
                Intrinsics3.checkNotNullExpressionValue(task, "task");
                if (task.p()) {
                    Logger.i$default(AppLog.g, "Google Smart Lock", "Credentials Saved", null, 4, null);
                    return;
                }
                Exception excK = task.k();
                if (!(excK instanceof ResolvableApiException)) {
                    AppLog.g.w("Google Smart Lock", "Exception saving credentials", excK);
                    return;
                }
                AppLog.g.w("Google Smart Lock", "Resolving Exception saving credentials", excK);
                AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                GoogleSmartLockManager.access$resolveResult(GoogleSmartLockManager.this, (ResolvableApiException) excK, anonymousClass1.$id);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(String str, String str2) {
            super(1);
            this.$id = str;
            this.$password = str2;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(MeUser meUser) {
            invoke2(meUser);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(MeUser meUser) {
            String forUser$default = IconUtils.getForUser$default(meUser, false, null, 4, null);
            Credential.a aVar = new Credential.a(this.$id);
            aVar.d = this.$password;
            Intrinsics3.checkNotNullExpressionValue(aVar, "Credential.Builder(id)\n …   .setPassword(password)");
            UserUtils userUtils = UserUtils.INSTANCE;
            Intrinsics3.checkNotNullExpressionValue(meUser, "it");
            aVar.f2995b = UserUtils.getUserNameWithDiscriminator$default(userUtils, meUser, null, null, 3, null).toString();
            aVar.c = Uri.parse(forUser$default);
            Credential credentialA = aVar.a();
            CredentialsClient credentialsClientAccess$getCredentialsClient$p = GoogleSmartLockManager.access$getCredentialsClient$p(GoogleSmartLockManager.this);
            Objects.requireNonNull(credentialsClientAccess$getCredentialsClient$p);
            b.i.a.f.c.a.d.c cVar = b.i.a.f.c.a.a.g;
            b.i.a.f.e.h.c cVar2 = credentialsClientAccess$getCredentialsClient$p.g;
            Objects.requireNonNull((h) cVar);
            AnimatableValueParser.z(cVar2, "client must not be null");
            AnimatableValueParser.z(credentialA, "credential must not be null");
            k.a(cVar2.b(new i(cVar2, credentialA))).b(new C02081());
        }
    }

    public GoogleSmartLockManager(Context context, GoogleSmartLockRepo googleSmartLockRepo) {
        Intrinsics3.checkNotNullParameter(context, "context");
        Intrinsics3.checkNotNullParameter(googleSmartLockRepo, "smartLockRepo");
        this.smartLockRepo = googleSmartLockRepo;
        this.resolvableFragments = Collections2.listOf((Object[]) new KClass[]{Reflection2.getOrCreateKotlinClass(WidgetTabsHost.class), Reflection2.getOrCreateKotlinClass(WidgetSettingsAccount.class)});
        d.a aVar = new d.a();
        aVar.f1333b = Boolean.TRUE;
        CredentialsClient credentialsClient = new CredentialsClient(context, new d(aVar, null));
        Intrinsics3.checkNotNullExpressionValue(credentialsClient, "Credentials.getClient(context, options)");
        this.credentialsClient = credentialsClient;
        if (googleSmartLockRepo.getDisableAutoLogin()) {
            CredentialsClient credentialsClient2 = this.credentialsClient;
            Objects.requireNonNull(credentialsClient2);
            b.i.a.f.c.a.d.c cVar = b.i.a.f.c.a.a.g;
            b.i.a.f.e.h.c cVar2 = credentialsClient2.g;
            Objects.requireNonNull((h) cVar);
            AnimatableValueParser.z(cVar2, "client must not be null");
            k.a(cVar2.b(new b.i.a.f.h.c.k(cVar2)));
        }
    }

    public static final /* synthetic */ CredentialsClient access$getCredentialsClient$p(GoogleSmartLockManager googleSmartLockManager) {
        return googleSmartLockManager.credentialsClient;
    }

    public static final /* synthetic */ List access$getResolvableFragments$p(GoogleSmartLockManager googleSmartLockManager) {
        return googleSmartLockManager.resolvableFragments;
    }

    public static final /* synthetic */ void access$resolveResult(GoogleSmartLockManager googleSmartLockManager, Fragment fragment, int i, ResolvableApiException resolvableApiException) {
        googleSmartLockManager.resolveResult(fragment, i, resolvableApiException);
    }

    public static final /* synthetic */ void access$setCredentialsClient$p(GoogleSmartLockManager googleSmartLockManager, CredentialsClient credentialsClient) {
        googleSmartLockManager.credentialsClient = credentialsClient;
    }

    private final void resolveResult(Fragment fragment, int requestCode, ResolvableApiException rae) {
        try {
            if (!(rae.mStatus.p != 4) || fragment.isDetached() || fragment.isRemoving()) {
                return;
            }
            PendingIntent pendingIntent = rae.mStatus.r;
            Intrinsics3.checkNotNullExpressionValue(pendingIntent, "rae.resolution");
            fragment.startIntentSenderForResult(pendingIntent.getIntentSender(), requestCode, null, 0, 0, 0, null);
        } catch (IntentSender.SendIntentException e) {
            AppLog.g.w("Google Smart Lock", "Failed to send resolution.", e);
        } catch (Exception e2) {
            AppLog.g.w("Google Smart Lock", "Failed to resolve", e2);
        }
    }

    public final void deleteCredentials(String id2) {
        Intrinsics3.checkNotNullParameter(id2, ModelAuditLogEntry.CHANGE_KEY_ID);
        CredentialsClient credentialsClient = this.credentialsClient;
        Credential credential = new Credential(id2, null, null, null, null, null, null, null);
        Objects.requireNonNull(credentialsClient);
        b.i.a.f.c.a.d.c cVar = b.i.a.f.c.a.a.g;
        b.i.a.f.e.h.c cVar2 = credentialsClient.g;
        Objects.requireNonNull((h) cVar);
        AnimatableValueParser.z(cVar2, "client must not be null");
        AnimatableValueParser.z(credential, "credential must not be null");
        k.a(cVar2.b(new l(cVar2, credential)));
    }

    public final GoogleSmartLockRepo getSmartLockRepo() {
        return this.smartLockRepo;
    }

    public final void requestCredentials(AppFragment fragment, int requestCode) {
        Intrinsics3.checkNotNullParameter(fragment, "fragment");
        CredentialRequest credentialRequest = new CredentialRequest(4, true, new String[]{DISCORD_ACCOUNT_IDENTITY}, null, null, false, null, null, false);
        CredentialsClient credentialsClient = this.credentialsClient;
        Objects.requireNonNull(credentialsClient);
        b.i.a.f.c.a.d.c cVar = b.i.a.f.c.a.a.g;
        b.i.a.f.e.h.c cVar2 = credentialsClient.g;
        Objects.requireNonNull((h) cVar);
        AnimatableValueParser.z(cVar2, "client must not be null");
        AnimatableValueParser.z(credentialRequest, "request must not be null");
        b.i.a.f.e.h.j.d dVarA = cVar2.a(new g(cVar2, credentialRequest));
        v vVar = new v(new a());
        k.b bVar = k.a;
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        dVarA.c(new s(dVarA, taskCompletionSource, vVar, bVar));
        taskCompletionSource.a.b(new AnonymousClass1(fragment, requestCode));
    }

    public final void saveCredentials(String id2, String password) {
        Intrinsics3.checkNotNullParameter(id2, ModelAuditLogEntry.CHANGE_KEY_ID);
        Intrinsics3.checkNotNullParameter(password, WidgetSettingsAccountChangePassword.CURRENT_PASSWORD_FIELD);
        Observable observableZ = StoreUser.observeMe$default(StoreStream.INSTANCE.getUsers(), false, 1, null).Z(1);
        Intrinsics3.checkNotNullExpressionValue(observableZ, "StoreStream.getUsers().observeMe().take(1)");
        ObservableExtensionsKt.appSubscribe$default(observableZ, GoogleSmartLockManager.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(id2, password), 62, (Object) null);
    }

    public final void updateAccountInfo(String login, String newPassword) {
        Intrinsics3.checkNotNullParameter(newPassword, "newPassword");
        String pendingIdChange = this.smartLockRepo.getPendingIdChange();
        if (pendingIdChange != null) {
            deleteCredentials(pendingIdChange);
            this.smartLockRepo.setPendingIdChange(null);
        }
        if (login == null) {
            login = StoreStream.INSTANCE.getAuthentication().getSavedLogin();
        }
        if (login != null) {
            saveCredentials(login, newPassword);
        }
    }

    public static final /* synthetic */ void access$resolveResult(GoogleSmartLockManager googleSmartLockManager, ResolvableApiException resolvableApiException, String str) {
        googleSmartLockManager.resolveResult(resolvableApiException, str);
    }

    private final void resolveResult(ResolvableApiException rae, String id2) {
        try {
            if (rae.mStatus.p != 4) {
                StoreStream.INSTANCE.getNotices().requestToShow(new StoreNotices.Notice(SMART_LOCK_NOTICE_NAME + id2, null, 0L, 0, false, this.resolvableFragments, 0L, false, 0L, new GoogleSmartLockManager2(this, rae), Opcodes.I2F, null));
            }
        } catch (IntentSender.SendIntentException e) {
            AppLog.g.w("Google Smart Lock", "Failed to send resolution.", e);
        } catch (Exception e2) {
            AppLog.g.w("Google Smart Lock", "Failed to resolve", e2);
        }
    }

    public /* synthetic */ GoogleSmartLockManager(Context context, GoogleSmartLockRepo googleSmartLockRepo, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? GoogleSmartLockRepo.INSTANCE.getINSTANCE() : googleSmartLockRepo);
    }
}
