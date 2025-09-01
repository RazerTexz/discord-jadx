package com.discord.utilities.application;

import android.net.Uri;
import com.adjust.sdk.Constants;
import com.discord.api.application.ProfileApplication;
import com.discord.api.application.ProfileApplication2;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.t._Arrays;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* compiled from: ApplicationUtils.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lcom/discord/utilities/application/ApplicationUtils;", "", "Lcom/discord/api/application/ProfileApplication;", "application", "", "canInstallApplication", "(Lcom/discord/api/application/ProfileApplication;)Z", "Landroid/net/Uri;", "getApplicationUri", "(Lcom/discord/api/application/ProfileApplication;)Landroid/net/Uri;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class ApplicationUtils {
    public static final ApplicationUtils INSTANCE = new ApplicationUtils();

    private ApplicationUtils() {
    }

    public final boolean canInstallApplication(ProfileApplication application) {
        return (application == null || (application.getCustomInstallUrl() == null && application.getInstallParams() == null)) ? false : true;
    }

    public final Uri getApplicationUri(ProfileApplication application) {
        String[] scopes;
        String strJoinToString$default = null;
        if ((application != null ? application.getCustomInstallUrl() : null) != null) {
            return Uri.parse(application.getCustomInstallUrl());
        }
        if ((application != null ? application.getInstallParams() : null) == null) {
            return null;
        }
        Uri.Builder builder = new Uri.Builder();
        Uri.Builder builderAppendQueryParameter = builder.scheme(Constants.SCHEME).authority("discord.com").appendPath("api").appendPath("oauth2").appendPath("authorize").appendQueryParameter("client_id", application.getId());
        ProfileApplication2 installParams = application.getInstallParams();
        Uri.Builder builderAppendQueryParameter2 = builderAppendQueryParameter.appendQueryParameter(ModelAuditLogEntry.CHANGE_KEY_PERMISSIONS, installParams != null ? installParams.getPermissions() : null);
        ProfileApplication2 installParams2 = application.getInstallParams();
        if (installParams2 != null && (scopes = installParams2.getScopes()) != null) {
            strJoinToString$default = _Arrays.joinToString$default(scopes, " ", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null);
        }
        builderAppendQueryParameter2.appendQueryParameter("scope", strJoinToString$default);
        return Uri.parse(builder.toString());
    }
}
