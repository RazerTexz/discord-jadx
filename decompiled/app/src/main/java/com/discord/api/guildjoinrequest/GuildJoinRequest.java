package com.discord.api.guildjoinrequest;

import b.d.b.a.outline;
import com.discord.api.user.User;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: GuildJoinRequest.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\n\u0010\u000bR\u001b\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u0004R\u0019\u0010\u0010\u001a\u00020\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u001b\u0010\u0014\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0014\u0010\r\u001a\u0004\b\u0015\u0010\u0004R\u001b\u0010\u0016\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0016\u0010\r\u001a\u0004\b\u0017\u0010\u0004R\u0019\u0010\u0018\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0018\u0010\r\u001a\u0004\b\u0019\u0010\u0004R\u0019\u0010\u001b\u001a\u00020\u001a8\u0006@\u0006¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u001b\u0010\u001f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u001f\u0010\r\u001a\u0004\b \u0010\u0004R\u0019\u0010!\u001a\u00020\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b!\u0010\u0011\u001a\u0004\b\"\u0010\u0013R\u001b\u0010$\u001a\u0004\u0018\u00010#8\u0006@\u0006¢\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'¨\u0006("}, d2 = {"Lcom/discord/api/guildjoinrequest/GuildJoinRequest;", "", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "rejectionReason", "Ljava/lang/String;", "d", "", "guildId", "J", "b", "()J", "actionedAt", "getActionedAt", "lastSeen", "c", "createdAt", "getCreatedAt", "Lcom/discord/api/guildjoinrequest/ApplicationStatus;", "applicationStatus", "Lcom/discord/api/guildjoinrequest/ApplicationStatus;", "a", "()Lcom/discord/api/guildjoinrequest/ApplicationStatus;", "inviteCode", "getInviteCode", "userId", "e", "Lcom/discord/api/user/User;", "user", "Lcom/discord/api/user/User;", "getUser", "()Lcom/discord/api/user/User;", "discord_api"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final /* data */ class GuildJoinRequest {
    private final String actionedAt;
    private final ApplicationStatus applicationStatus;
    private final String createdAt;
    private final long guildId;
    private final String inviteCode;
    private final String lastSeen;
    private final String rejectionReason;
    private final User user;
    private final long userId;

    /* renamed from: a, reason: from getter */
    public final ApplicationStatus getApplicationStatus() {
        return this.applicationStatus;
    }

    /* renamed from: b, reason: from getter */
    public final long getGuildId() {
        return this.guildId;
    }

    /* renamed from: c, reason: from getter */
    public final String getLastSeen() {
        return this.lastSeen;
    }

    /* renamed from: d, reason: from getter */
    public final String getRejectionReason() {
        return this.rejectionReason;
    }

    /* renamed from: e, reason: from getter */
    public final long getUserId() {
        return this.userId;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GuildJoinRequest)) {
            return false;
        }
        GuildJoinRequest guildJoinRequest = (GuildJoinRequest) other;
        return this.userId == guildJoinRequest.userId && Intrinsics3.areEqual(this.user, guildJoinRequest.user) && this.guildId == guildJoinRequest.guildId && Intrinsics3.areEqual(this.createdAt, guildJoinRequest.createdAt) && Intrinsics3.areEqual(this.applicationStatus, guildJoinRequest.applicationStatus) && Intrinsics3.areEqual(this.rejectionReason, guildJoinRequest.rejectionReason) && Intrinsics3.areEqual(this.inviteCode, guildJoinRequest.inviteCode) && Intrinsics3.areEqual(this.lastSeen, guildJoinRequest.lastSeen) && Intrinsics3.areEqual(this.actionedAt, guildJoinRequest.actionedAt);
    }

    public int hashCode() {
        long j = this.userId;
        int i = ((int) (j ^ (j >>> 32))) * 31;
        User user = this.user;
        int iHashCode = user != null ? user.hashCode() : 0;
        long j2 = this.guildId;
        int i2 = (((i + iHashCode) * 31) + ((int) (j2 ^ (j2 >>> 32)))) * 31;
        String str = this.createdAt;
        int iHashCode2 = (i2 + (str != null ? str.hashCode() : 0)) * 31;
        ApplicationStatus applicationStatus = this.applicationStatus;
        int iHashCode3 = (iHashCode2 + (applicationStatus != null ? applicationStatus.hashCode() : 0)) * 31;
        String str2 = this.rejectionReason;
        int iHashCode4 = (iHashCode3 + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.inviteCode;
        int iHashCode5 = (iHashCode4 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.lastSeen;
        int iHashCode6 = (iHashCode5 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.actionedAt;
        return iHashCode6 + (str5 != null ? str5.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("GuildJoinRequest(userId=");
        sbU.append(this.userId);
        sbU.append(", user=");
        sbU.append(this.user);
        sbU.append(", guildId=");
        sbU.append(this.guildId);
        sbU.append(", createdAt=");
        sbU.append(this.createdAt);
        sbU.append(", applicationStatus=");
        sbU.append(this.applicationStatus);
        sbU.append(", rejectionReason=");
        sbU.append(this.rejectionReason);
        sbU.append(", inviteCode=");
        sbU.append(this.inviteCode);
        sbU.append(", lastSeen=");
        sbU.append(this.lastSeen);
        sbU.append(", actionedAt=");
        return outline.J(sbU, this.actionedAt, ")");
    }
}
