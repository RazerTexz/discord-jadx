package com.discord.api.auth.mfa;

import com.discord.widgets.settings.account.WidgetSettingsAccountChangePassword;
import kotlin.Metadata;

/* compiled from: GetBackupCodesRequestBody.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u00002\u00020\u0001R\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0006\u001a\u00020\u00058\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/discord/api/auth/mfa/GetBackupCodesRequestBody;", "", "", WidgetSettingsAccountChangePassword.CURRENT_PASSWORD_FIELD, "Ljava/lang/String;", "", "regenerate", "Z", "discord_api"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final class GetBackupCodesRequestBody {
    private final String password;
    private final boolean regenerate;
}
