package com.discord.api.guildrolesubscription;

import b.d.b.a.outline;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: PayoutGroup.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\n\u0010\u000bR\u0019\u0010\f\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u0004R\u0019\u0010\u0010\u001a\u00020\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u001b\u0010\u0015\u001a\u0004\u0018\u00010\u00148\u0006@\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u001d\u0010\u001a\u001a\u00060\u0014j\u0002`\u00198\u0006@\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u0019\u0010\u001e\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u001e\u0010\r\u001a\u0004\b\u001f\u0010\u0004R\u0019\u0010 \u001a\u00020\u00148\u0006@\u0006¢\u0006\f\n\u0004\b \u0010\u001b\u001a\u0004\b!\u0010\u001dR\u0019\u0010\"\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\"\u0010\r\u001a\u0004\b#\u0010\u0004¨\u0006$"}, d2 = {"Lcom/discord/api/guildrolesubscription/Payout;", "", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "periodEnd", "Ljava/lang/String;", "getPeriodEnd", "Lcom/discord/api/guildrolesubscription/PayoutStatus;", "status", "Lcom/discord/api/guildrolesubscription/PayoutStatus;", "getStatus", "()Lcom/discord/api/guildrolesubscription/PayoutStatus;", "", "amount", "Ljava/lang/Long;", "getAmount", "()Ljava/lang/Long;", "Lcom/discord/primitives/UserId;", "userId", "J", "getUserId", "()J", "periodStart", "getPeriodStart", ModelAuditLogEntry.CHANGE_KEY_ID, "getId", "payoutDate", "getPayoutDate", "discord_api"}, k = 1, mv = {1, 4, 2})
/* renamed from: com.discord.api.guildrolesubscription.Payout, reason: use source file name */
/* loaded from: classes.dex */
public final /* data */ class PayoutGroup2 {
    private final Long amount;
    private final long id;
    private final String payoutDate;
    private final String periodEnd;
    private final String periodStart;
    private final PayoutStatus status;
    private final long userId;

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PayoutGroup2)) {
            return false;
        }
        PayoutGroup2 payoutGroup2 = (PayoutGroup2) other;
        return this.id == payoutGroup2.id && this.userId == payoutGroup2.userId && Intrinsics3.areEqual(this.periodStart, payoutGroup2.periodStart) && Intrinsics3.areEqual(this.periodEnd, payoutGroup2.periodEnd) && Intrinsics3.areEqual(this.payoutDate, payoutGroup2.payoutDate) && Intrinsics3.areEqual(this.status, payoutGroup2.status) && Intrinsics3.areEqual(this.amount, payoutGroup2.amount);
    }

    public int hashCode() {
        long j = this.id;
        long j2 = this.userId;
        int i = ((((int) (j ^ (j >>> 32))) * 31) + ((int) (j2 ^ (j2 >>> 32)))) * 31;
        String str = this.periodStart;
        int iHashCode = (i + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.periodEnd;
        int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.payoutDate;
        int iHashCode3 = (iHashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        PayoutStatus payoutStatus = this.status;
        int iHashCode4 = (iHashCode3 + (payoutStatus != null ? payoutStatus.hashCode() : 0)) * 31;
        Long l = this.amount;
        return iHashCode4 + (l != null ? l.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("Payout(id=");
        sbU.append(this.id);
        sbU.append(", userId=");
        sbU.append(this.userId);
        sbU.append(", periodStart=");
        sbU.append(this.periodStart);
        sbU.append(", periodEnd=");
        sbU.append(this.periodEnd);
        sbU.append(", payoutDate=");
        sbU.append(this.payoutDate);
        sbU.append(", status=");
        sbU.append(this.status);
        sbU.append(", amount=");
        return outline.G(sbU, this.amount, ")");
    }
}
