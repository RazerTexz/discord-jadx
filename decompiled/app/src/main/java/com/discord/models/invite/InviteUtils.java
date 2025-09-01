package com.discord.models.invite;

import b.d.b.a.outline;
import com.discord.BuildConfig;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.domain.ModelInvite;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: InviteUtils.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\b\u0010\tJ\u001f\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Lcom/discord/models/invite/InviteUtils;", "", "", ModelAuditLogEntry.CHANGE_KEY_CODE, "", "guildScheduledEventId", "createLinkFromCode", "(Ljava/lang/String;Ljava/lang/Long;)Ljava/lang/String;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final class InviteUtils {
    public static final InviteUtils INSTANCE = new InviteUtils();

    private InviteUtils() {
    }

    public final String createLinkFromCode(String code, Long guildScheduledEventId) {
        Intrinsics3.checkNotNullParameter(code, ModelAuditLogEntry.CHANGE_KEY_CODE);
        return guildScheduledEventId != null ? outline.P(new Object[]{BuildConfig.HOST_INVITE, code, guildScheduledEventId}, 3, ModelInvite.URL_FORMAT_WITH_EVENT, "java.lang.String.format(format, *args)") : outline.P(new Object[]{BuildConfig.HOST_INVITE, code}, 2, ModelInvite.URL_FORMAT, "java.lang.String.format(format, *args)");
    }
}
