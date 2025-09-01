package com.discord.api.guildrolesubscription;

import b.d.b.a.outline;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: SubscriptionTrial.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\n\u0010\u000bR\u0019\u0010\f\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u0007R\u001d\u0010\u0011\u001a\u00060\u000fj\u0002`\u00108\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0019\u0010\u0016\u001a\u00020\u00158\u0006@\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u0019\u0010\u001a\u001a\u00020\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u0012\u001a\u0004\b\u001b\u0010\u0014¨\u0006\u001c"}, d2 = {"Lcom/discord/api/guildrolesubscription/SubscriptionTrial;", "", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "intervalCount", "I", "b", "", "Lcom/discord/primitives/SkuId;", "skuId", "J", "getSkuId", "()J", "Lcom/discord/api/guildrolesubscription/GuildRoleSubscriptionFreeTrialIntervalTypes;", "interval", "Lcom/discord/api/guildrolesubscription/GuildRoleSubscriptionFreeTrialIntervalTypes;", "a", "()Lcom/discord/api/guildrolesubscription/GuildRoleSubscriptionFreeTrialIntervalTypes;", ModelAuditLogEntry.CHANGE_KEY_ID, "getId", "discord_api"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final /* data */ class SubscriptionTrial {
    private final long id;
    private final GuildRoleSubscriptionFreeTrialIntervalTypes interval;
    private final int intervalCount;
    private final long skuId;

    /* renamed from: a, reason: from getter */
    public final GuildRoleSubscriptionFreeTrialIntervalTypes getInterval() {
        return this.interval;
    }

    /* renamed from: b, reason: from getter */
    public final int getIntervalCount() {
        return this.intervalCount;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SubscriptionTrial)) {
            return false;
        }
        SubscriptionTrial subscriptionTrial = (SubscriptionTrial) other;
        return this.id == subscriptionTrial.id && Intrinsics3.areEqual(this.interval, subscriptionTrial.interval) && this.intervalCount == subscriptionTrial.intervalCount && this.skuId == subscriptionTrial.skuId;
    }

    public int hashCode() {
        long j = this.id;
        int i = ((int) (j ^ (j >>> 32))) * 31;
        GuildRoleSubscriptionFreeTrialIntervalTypes guildRoleSubscriptionFreeTrialIntervalTypes = this.interval;
        int iHashCode = (((i + (guildRoleSubscriptionFreeTrialIntervalTypes != null ? guildRoleSubscriptionFreeTrialIntervalTypes.hashCode() : 0)) * 31) + this.intervalCount) * 31;
        long j2 = this.skuId;
        return iHashCode + ((int) (j2 ^ (j2 >>> 32)));
    }

    public String toString() {
        StringBuilder sbU = outline.U("SubscriptionTrial(id=");
        sbU.append(this.id);
        sbU.append(", interval=");
        sbU.append(this.interval);
        sbU.append(", intervalCount=");
        sbU.append(this.intervalCount);
        sbU.append(", skuId=");
        return outline.C(sbU, this.skuId, ")");
    }
}
