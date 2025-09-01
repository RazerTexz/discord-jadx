package com.discord.api.message.role_subscription;

import b.d.b.a.outline;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: RoleSubscriptionData.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\n\u0010\u000bR\u0019\u0010\f\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u0004R\u0019\u0010\u000f\u001a\u00020\t8\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0019\u0010\u0014\u001a\u00020\u00138\u0006@\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0019\u0010\u0018\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u0007¨\u0006\u001b"}, d2 = {"Lcom/discord/api/message/role_subscription/RoleSubscriptionData;", "", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "tierName", "Ljava/lang/String;", "b", "isRenewal", "Z", "d", "()Z", "", "roleSubscriptionListingId", "J", "a", "()J", "totalMonthsSubscribed", "I", "c", "discord_api"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final /* data */ class RoleSubscriptionData {
    private final boolean isRenewal;
    private final long roleSubscriptionListingId;
    private final String tierName;
    private final int totalMonthsSubscribed;

    /* renamed from: a, reason: from getter */
    public final long getRoleSubscriptionListingId() {
        return this.roleSubscriptionListingId;
    }

    /* renamed from: b, reason: from getter */
    public final String getTierName() {
        return this.tierName;
    }

    /* renamed from: c, reason: from getter */
    public final int getTotalMonthsSubscribed() {
        return this.totalMonthsSubscribed;
    }

    /* renamed from: d, reason: from getter */
    public final boolean getIsRenewal() {
        return this.isRenewal;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RoleSubscriptionData)) {
            return false;
        }
        RoleSubscriptionData roleSubscriptionData = (RoleSubscriptionData) other;
        return this.roleSubscriptionListingId == roleSubscriptionData.roleSubscriptionListingId && Intrinsics3.areEqual(this.tierName, roleSubscriptionData.tierName) && this.totalMonthsSubscribed == roleSubscriptionData.totalMonthsSubscribed && this.isRenewal == roleSubscriptionData.isRenewal;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        long j = this.roleSubscriptionListingId;
        int i = ((int) (j ^ (j >>> 32))) * 31;
        String str = this.tierName;
        int iHashCode = (((i + (str != null ? str.hashCode() : 0)) * 31) + this.totalMonthsSubscribed) * 31;
        boolean z2 = this.isRenewal;
        int i2 = z2;
        if (z2 != 0) {
            i2 = 1;
        }
        return iHashCode + i2;
    }

    public String toString() {
        StringBuilder sbU = outline.U("RoleSubscriptionData(roleSubscriptionListingId=");
        sbU.append(this.roleSubscriptionListingId);
        sbU.append(", tierName=");
        sbU.append(this.tierName);
        sbU.append(", totalMonthsSubscribed=");
        sbU.append(this.totalMonthsSubscribed);
        sbU.append(", isRenewal=");
        return outline.O(sbU, this.isRenewal, ")");
    }
}
