package com.discord.api.guildrolesubscription;

import b.d.b.a.outline;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: GuildRoleSubscriptionTierFreeTrial.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\n\u0010\u000bR\u001b\u0010\f\u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001b\u0010\u0010\u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0010\u0010\r\u001a\u0004\b\u0011\u0010\u000fR\u0019\u0010\u0013\u001a\u00020\u00128\u0006@\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u001b\u0010\u0018\u001a\u0004\u0018\u00010\u00178\u0006@\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b¨\u0006\u001c"}, d2 = {"Lcom/discord/api/guildrolesubscription/GuildRoleSubscriptionTierFreeTrial;", "", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "numActiveTrialUsers", "Ljava/lang/Integer;", "getNumActiveTrialUsers", "()Ljava/lang/Integer;", "maxNumActiveTrialUsers", "c", "", ModelAuditLogEntry.CHANGE_KEY_ID, "J", "b", "()J", "Lcom/discord/api/guildrolesubscription/SubscriptionTrial;", "activeTrial", "Lcom/discord/api/guildrolesubscription/SubscriptionTrial;", "a", "()Lcom/discord/api/guildrolesubscription/SubscriptionTrial;", "discord_api"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final /* data */ class GuildRoleSubscriptionTierFreeTrial {
    private final SubscriptionTrial activeTrial;
    private final long id;
    private final Integer maxNumActiveTrialUsers;
    private final Integer numActiveTrialUsers;

    /* renamed from: a, reason: from getter */
    public final SubscriptionTrial getActiveTrial() {
        return this.activeTrial;
    }

    /* renamed from: b, reason: from getter */
    public final long getId() {
        return this.id;
    }

    /* renamed from: c, reason: from getter */
    public final Integer getMaxNumActiveTrialUsers() {
        return this.maxNumActiveTrialUsers;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GuildRoleSubscriptionTierFreeTrial)) {
            return false;
        }
        GuildRoleSubscriptionTierFreeTrial guildRoleSubscriptionTierFreeTrial = (GuildRoleSubscriptionTierFreeTrial) other;
        return this.id == guildRoleSubscriptionTierFreeTrial.id && Intrinsics3.areEqual(this.numActiveTrialUsers, guildRoleSubscriptionTierFreeTrial.numActiveTrialUsers) && Intrinsics3.areEqual(this.activeTrial, guildRoleSubscriptionTierFreeTrial.activeTrial) && Intrinsics3.areEqual(this.maxNumActiveTrialUsers, guildRoleSubscriptionTierFreeTrial.maxNumActiveTrialUsers);
    }

    public int hashCode() {
        long j = this.id;
        int i = ((int) (j ^ (j >>> 32))) * 31;
        Integer num = this.numActiveTrialUsers;
        int iHashCode = (i + (num != null ? num.hashCode() : 0)) * 31;
        SubscriptionTrial subscriptionTrial = this.activeTrial;
        int iHashCode2 = (iHashCode + (subscriptionTrial != null ? subscriptionTrial.hashCode() : 0)) * 31;
        Integer num2 = this.maxNumActiveTrialUsers;
        return iHashCode2 + (num2 != null ? num2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("GuildRoleSubscriptionTierFreeTrial(id=");
        sbU.append(this.id);
        sbU.append(", numActiveTrialUsers=");
        sbU.append(this.numActiveTrialUsers);
        sbU.append(", activeTrial=");
        sbU.append(this.activeTrial);
        sbU.append(", maxNumActiveTrialUsers=");
        return outline.F(sbU, this.maxNumActiveTrialUsers, ")");
    }
}
