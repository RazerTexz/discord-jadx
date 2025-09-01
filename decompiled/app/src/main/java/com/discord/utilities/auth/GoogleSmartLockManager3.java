package com.discord.utilities.auth;

import android.content.Context;
import android.content.Intent;
import com.discord.utilities.auth.GoogleSmartLockManager;
import com.discord.widgets.auth.WidgetAuthLogin;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: GoogleSmartLockManager.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005*\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007\u001a\u0011\u0010\t\u001a\u00020\b*\u00020\u0004¢\u0006\u0004\b\t\u0010\n\u001a\u0011\u0010\f\u001a\u00020\u000b*\u00020\u0004¢\u0006\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Landroid/content/Context;", "Lcom/discord/utilities/auth/GoogleSmartLockManager;", "googleSmartLockManager", "(Landroid/content/Context;)Lcom/discord/utilities/auth/GoogleSmartLockManager;", "Landroid/content/Intent;", "Lcom/discord/utilities/auth/GoogleSmartLockManager$SmartLockCredentials;", "toSmartLockCredentials", "(Landroid/content/Intent;)Lcom/discord/utilities/auth/GoogleSmartLockManager$SmartLockCredentials;", "", "clearSmartLockCredentials", "(Landroid/content/Intent;)V", "", "hasSmartLockCredentials", "(Landroid/content/Intent;)Z", "app_productionGoogleRelease"}, k = 2, mv = {1, 4, 2})
/* renamed from: com.discord.utilities.auth.GoogleSmartLockManagerKt, reason: use source file name */
/* loaded from: classes2.dex */
public final class GoogleSmartLockManager3 {
    public static final void clearSmartLockCredentials(Intent intent) {
        Intrinsics3.checkNotNullParameter(intent, "$this$clearSmartLockCredentials");
        intent.removeExtra(WidgetAuthLogin.GOOGLE_SMARTLOCK_LOGIN_EXTRA_ID);
        intent.removeExtra(WidgetAuthLogin.GOOGLE_SMARTLOCK_LOGIN_EXTRA_PASSWORD);
    }

    public static final GoogleSmartLockManager googleSmartLockManager(Context context) {
        Intrinsics3.checkNotNullParameter(context, "$this$googleSmartLockManager");
        return new GoogleSmartLockManager(context, null, 2, null);
    }

    public static final boolean hasSmartLockCredentials(Intent intent) {
        Intrinsics3.checkNotNullParameter(intent, "$this$hasSmartLockCredentials");
        return intent.hasExtra(WidgetAuthLogin.GOOGLE_SMARTLOCK_LOGIN_EXTRA_ID);
    }

    public static final GoogleSmartLockManager.SmartLockCredentials toSmartLockCredentials(Intent intent) {
        Intrinsics3.checkNotNullParameter(intent, "$this$toSmartLockCredentials");
        if (!intent.hasExtra(WidgetAuthLogin.GOOGLE_SMARTLOCK_LOGIN_EXTRA_ID)) {
            return null;
        }
        String stringExtra = intent.getStringExtra(WidgetAuthLogin.GOOGLE_SMARTLOCK_LOGIN_EXTRA_ID);
        String stringExtra2 = intent.getStringExtra(WidgetAuthLogin.GOOGLE_SMARTLOCK_LOGIN_EXTRA_PASSWORD);
        if (stringExtra == null || stringExtra2 == null) {
            return null;
        }
        return new GoogleSmartLockManager.SmartLockCredentials(stringExtra, stringExtra2);
    }
}
