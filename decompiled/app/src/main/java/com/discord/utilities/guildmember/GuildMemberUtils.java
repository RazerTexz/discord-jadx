package com.discord.utilities.guildmember;

import com.discord.models.member.GuildMember;
import com.discord.utilities.time.ClockFactory;
import kotlin.Metadata;

/* compiled from: GuildMemberUtils.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0015\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u0017\u0010\u0005\u001a\u00020\u00002\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000¢\u0006\u0004\b\u0005\u0010\u0006\"\u0016\u0010\u0007\u001a\u00020\u00008\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0007\u0010\b\"\u0019\u0010\n\u001a\u00020\u0002*\u0004\u0018\u00010\t8F@\u0006¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"", "joinedAt", "", "isGuildMemberOldEnough", "(J)Z", "getJoinedAtOrNow", "(Ljava/lang/Long;)J", "AGE_THRESHOLD", "J", "Lcom/discord/models/member/GuildMember;", "isLurker", "(Lcom/discord/models/member/GuildMember;)Z", "app_productionGoogleRelease"}, k = 2, mv = {1, 4, 2})
/* renamed from: com.discord.utilities.guildmember.GuildMemberUtilsKt, reason: use source file name */
/* loaded from: classes2.dex */
public final class GuildMemberUtils {
    private static final long AGE_THRESHOLD = 600000;

    public static final long getJoinedAtOrNow(Long l) {
        return l != null ? l.longValue() : ClockFactory.get().currentTimeMillis();
    }

    public static final boolean isGuildMemberOldEnough(long j) {
        return ClockFactory.get().currentTimeMillis() - j > 600000;
    }

    public static final boolean isLurker(GuildMember guildMember) {
        return guildMember == null || guildMember.getPending() || guildMember.getJoinedAt() == null;
    }
}
