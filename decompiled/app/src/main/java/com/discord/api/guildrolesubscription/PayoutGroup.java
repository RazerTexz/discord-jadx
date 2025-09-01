package com.discord.api.guildrolesubscription;

import b.d.b.a.outline;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: PayoutGroup.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\n\u0010\u000bR\u0019\u0010\r\u001a\u00020\f8\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001b\u0010\u0012\u001a\u0004\u0018\u00010\u00118\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0019\u0010\u0016\u001a\u00020\f8\u0006@\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u000e\u001a\u0004\b\u0017\u0010\u0010R\u0019\u0010\u0018\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u0004R\u0019\u0010\u001b\u001a\u00020\f8\u0006@\u0006¢\u0006\f\n\u0004\b\u001b\u0010\u000e\u001a\u0004\b\u001c\u0010\u0010R\u0019\u0010\u001e\u001a\u00020\u001d8\u0006@\u0006¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!R\u0019\u0010\"\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\"\u0010\u0019\u001a\u0004\b#\u0010\u0004R\u0019\u0010%\u001a\u00020$8\u0006@\u0006¢\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(R\u0019\u0010)\u001a\u00020\f8\u0006@\u0006¢\u0006\f\n\u0004\b)\u0010\u000e\u001a\u0004\b*\u0010\u0010R\u0019\u0010+\u001a\u00020\f8\u0006@\u0006¢\u0006\f\n\u0004\b+\u0010\u000e\u001a\u0004\b,\u0010\u0010R\u0019\u0010-\u001a\u00020\f8\u0006@\u0006¢\u0006\f\n\u0004\b-\u0010\u000e\u001a\u0004\b.\u0010\u0010R\u0019\u0010/\u001a\u00020\f8\u0006@\u0006¢\u0006\f\n\u0004\b/\u0010\u000e\u001a\u0004\b0\u0010\u0010R\u001d\u00102\u001a\u00060\fj\u0002`18\u0006@\u0006¢\u0006\f\n\u0004\b2\u0010\u000e\u001a\u0004\b3\u0010\u0010R\u0019\u00104\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b4\u0010\u0019\u001a\u0004\b5\u0010\u0004R\u0019\u00106\u001a\u00020\f8\u0006@\u0006¢\u0006\f\n\u0004\b6\u0010\u000e\u001a\u0004\b7\u0010\u0010R\u001d\u00109\u001a\u00060\fj\u0002`88\u0006@\u0006¢\u0006\f\n\u0004\b9\u0010\u000e\u001a\u0004\b:\u0010\u0010¨\u0006;"}, d2 = {"Lcom/discord/api/guildrolesubscription/PayoutGroup;", "", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "paymentsCount", "J", "getPaymentsCount", "()J", "Lcom/discord/api/guildrolesubscription/Payout;", "payout", "Lcom/discord/api/guildrolesubscription/Payout;", "getPayout", "()Lcom/discord/api/guildrolesubscription/Payout;", "groupingId", "getGroupingId", "periodEndingAt", "Ljava/lang/String;", "getPeriodEndingAt", "deductionsCount", "getDeductionsCount", "Lcom/discord/api/guildrolesubscription/PayoutGroupStatus;", "status", "Lcom/discord/api/guildrolesubscription/PayoutGroupStatus;", "getStatus", "()Lcom/discord/api/guildrolesubscription/PayoutGroupStatus;", "currency", "getCurrency", "Lcom/discord/api/guildrolesubscription/PayoutGroupType;", "groupingType", "Lcom/discord/api/guildrolesubscription/PayoutGroupType;", "getGroupingType", "()Lcom/discord/api/guildrolesubscription/PayoutGroupType;", "amountPayable", "getAmountPayable", "amountDeducted", "getAmountDeducted", ModelAuditLogEntry.CHANGE_KEY_ID, "getId", "amount", "getAmount", "Lcom/discord/primitives/ApplicationId;", "applicationId", "getApplicationId", "periodStartingAt", "getPeriodStartingAt", "payoutId", "getPayoutId", "Lcom/discord/primitives/UserId;", "userId", "getUserId", "discord_api"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final /* data */ class PayoutGroup {
    private final long amount;
    private final long amountDeducted;
    private final long amountPayable;
    private final long applicationId;
    private final String currency;
    private final long deductionsCount;
    private final long groupingId;
    private final PayoutGroupType groupingType;
    private final long id;
    private final long paymentsCount;
    private final PayoutGroup2 payout;
    private final long payoutId;
    private final String periodEndingAt;
    private final String periodStartingAt;
    private final PayoutGroupStatus status;
    private final long userId;

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PayoutGroup)) {
            return false;
        }
        PayoutGroup payoutGroup = (PayoutGroup) other;
        return this.id == payoutGroup.id && this.payoutId == payoutGroup.payoutId && this.userId == payoutGroup.userId && this.applicationId == payoutGroup.applicationId && this.groupingId == payoutGroup.groupingId && Intrinsics3.areEqual(this.status, payoutGroup.status) && this.amount == payoutGroup.amount && this.amountPayable == payoutGroup.amountPayable && this.amountDeducted == payoutGroup.amountDeducted && this.paymentsCount == payoutGroup.paymentsCount && this.deductionsCount == payoutGroup.deductionsCount && Intrinsics3.areEqual(this.currency, payoutGroup.currency) && Intrinsics3.areEqual(this.groupingType, payoutGroup.groupingType) && Intrinsics3.areEqual(this.periodStartingAt, payoutGroup.periodStartingAt) && Intrinsics3.areEqual(this.periodEndingAt, payoutGroup.periodEndingAt) && Intrinsics3.areEqual(this.payout, payoutGroup.payout);
    }

    public int hashCode() {
        long j = this.id;
        long j2 = this.payoutId;
        int i = ((((int) (j ^ (j >>> 32))) * 31) + ((int) (j2 ^ (j2 >>> 32)))) * 31;
        long j3 = this.userId;
        int i2 = (i + ((int) (j3 ^ (j3 >>> 32)))) * 31;
        long j4 = this.applicationId;
        int i3 = (i2 + ((int) (j4 ^ (j4 >>> 32)))) * 31;
        long j5 = this.groupingId;
        int i4 = (i3 + ((int) (j5 ^ (j5 >>> 32)))) * 31;
        PayoutGroupStatus payoutGroupStatus = this.status;
        int iHashCode = payoutGroupStatus != null ? payoutGroupStatus.hashCode() : 0;
        long j6 = this.amount;
        int i5 = (((i4 + iHashCode) * 31) + ((int) (j6 ^ (j6 >>> 32)))) * 31;
        long j7 = this.amountPayable;
        int i6 = (i5 + ((int) (j7 ^ (j7 >>> 32)))) * 31;
        long j8 = this.amountDeducted;
        int i7 = (i6 + ((int) (j8 ^ (j8 >>> 32)))) * 31;
        long j9 = this.paymentsCount;
        int i8 = (i7 + ((int) (j9 ^ (j9 >>> 32)))) * 31;
        long j10 = this.deductionsCount;
        int i9 = (i8 + ((int) (j10 ^ (j10 >>> 32)))) * 31;
        String str = this.currency;
        int iHashCode2 = (i9 + (str != null ? str.hashCode() : 0)) * 31;
        PayoutGroupType payoutGroupType = this.groupingType;
        int iHashCode3 = (iHashCode2 + (payoutGroupType != null ? payoutGroupType.hashCode() : 0)) * 31;
        String str2 = this.periodStartingAt;
        int iHashCode4 = (iHashCode3 + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.periodEndingAt;
        int iHashCode5 = (iHashCode4 + (str3 != null ? str3.hashCode() : 0)) * 31;
        PayoutGroup2 payoutGroup2 = this.payout;
        return iHashCode5 + (payoutGroup2 != null ? payoutGroup2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("PayoutGroup(id=");
        sbU.append(this.id);
        sbU.append(", payoutId=");
        sbU.append(this.payoutId);
        sbU.append(", userId=");
        sbU.append(this.userId);
        sbU.append(", applicationId=");
        sbU.append(this.applicationId);
        sbU.append(", groupingId=");
        sbU.append(this.groupingId);
        sbU.append(", status=");
        sbU.append(this.status);
        sbU.append(", amount=");
        sbU.append(this.amount);
        sbU.append(", amountPayable=");
        sbU.append(this.amountPayable);
        sbU.append(", amountDeducted=");
        sbU.append(this.amountDeducted);
        sbU.append(", paymentsCount=");
        sbU.append(this.paymentsCount);
        sbU.append(", deductionsCount=");
        sbU.append(this.deductionsCount);
        sbU.append(", currency=");
        sbU.append(this.currency);
        sbU.append(", groupingType=");
        sbU.append(this.groupingType);
        sbU.append(", periodStartingAt=");
        sbU.append(this.periodStartingAt);
        sbU.append(", periodEndingAt=");
        sbU.append(this.periodEndingAt);
        sbU.append(", payout=");
        sbU.append(this.payout);
        sbU.append(")");
        return sbU.toString();
    }
}
