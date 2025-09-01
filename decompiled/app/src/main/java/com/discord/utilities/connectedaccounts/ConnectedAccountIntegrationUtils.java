package com.discord.utilities.connectedaccounts;

import b.d.b.a.outline;
import com.discord.api.connectedaccounts.ConnectedAccountIntegration;
import com.discord.api.connectedaccounts.ConnectedIntegrationAccount;
import com.discord.api.connectedaccounts.ConnectedIntegrationGuild;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: ConnectedAccountIntegrationUtils.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\b\u001a\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003\"\u0016\u0010\u0004\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005\"\u0016\u0010\u0006\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0006\u0010\u0005\"\u0016\u0010\u0007\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0007\u0010\u0005\"\u0016\u0010\b\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\b\u0010\u0005¨\u0006\t"}, d2 = {"Lcom/discord/api/connectedaccounts/ConnectedAccountIntegration;", "", "getDisplayName", "(Lcom/discord/api/connectedaccounts/ConnectedAccountIntegration;)Ljava/lang/String;", "YOUTUBE_URL_PREFIX", "Ljava/lang/String;", "TYPE_TWITCH", "TWITCH_URL_PREFIX", "TYPE_YOUTUBE", "app_productionGoogleRelease"}, k = 2, mv = {1, 4, 2})
/* renamed from: com.discord.utilities.connectedaccounts.ConnectedAccountIntegrationUtilsKt, reason: use source file name */
/* loaded from: classes2.dex */
public final class ConnectedAccountIntegrationUtils {
    public static final String TWITCH_URL_PREFIX = "twitch.tv/";
    public static final String TYPE_TWITCH = "twitch";
    public static final String TYPE_YOUTUBE = "youtube";
    public static final String YOUTUBE_URL_PREFIX = "youtube.com/channel/";

    public static final String getDisplayName(ConnectedAccountIntegration connectedAccountIntegration) {
        Intrinsics3.checkNotNullParameter(connectedAccountIntegration, "$this$getDisplayName");
        if (Intrinsics3.areEqual("twitch", connectedAccountIntegration.getType())) {
            StringBuilder sbU = outline.U(TWITCH_URL_PREFIX);
            ConnectedIntegrationAccount account = connectedAccountIntegration.getAccount();
            sbU.append(account != null ? account.getName() : null);
            return sbU.toString();
        }
        if (Intrinsics3.areEqual("youtube", connectedAccountIntegration.getType())) {
            StringBuilder sbU2 = outline.U(YOUTUBE_URL_PREFIX);
            ConnectedIntegrationAccount account2 = connectedAccountIntegration.getAccount();
            sbU2.append(account2 != null ? account2.getName() : null);
            return sbU2.toString();
        }
        ConnectedIntegrationGuild guild = connectedAccountIntegration.getGuild();
        if (guild != null) {
            return guild.getName();
        }
        return null;
    }
}
