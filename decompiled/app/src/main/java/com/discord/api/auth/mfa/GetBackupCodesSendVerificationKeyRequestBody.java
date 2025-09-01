package com.discord.api.auth.mfa;

import com.discord.widgets.settings.account.WidgetSettingsAccountChangePassword;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: GetBackupCodesSendVerificationKeyRequestBody.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"Lcom/discord/api/auth/mfa/GetBackupCodesSendVerificationKeyRequestBody;", "", "", WidgetSettingsAccountChangePassword.CURRENT_PASSWORD_FIELD, "Ljava/lang/String;", "<init>", "(Ljava/lang/String;)V", "discord_api"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final class GetBackupCodesSendVerificationKeyRequestBody {
    private final String password;

    public GetBackupCodesSendVerificationKeyRequestBody(String str) {
        Intrinsics3.checkNotNullParameter(str, WidgetSettingsAccountChangePassword.CURRENT_PASSWORD_FIELD);
        this.password = str;
    }
}
