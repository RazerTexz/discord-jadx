package com.discord.widgets.servers.guild_role_subscription.model;

import a0.a.a.b;
import b.d.b.a.outline;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: CurrentMonthEarningMetrics.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000e\b\u0086\b\u0018\u00002\u00020\u0001BK\u0012\b\b\u0002\u0010\r\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b&\u0010'J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0007\u0010\u0004J\u0012\u0010\b\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\b\u0010\u0006J\u0012\u0010\n\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0012\u0010\f\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0004\b\f\u0010\u000bJT\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\r\u001a\u00020\u00022\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u000f\u001a\u00020\u00022\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\tHÆ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0015\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\u0015\u0010\u000bJ\u0010\u0010\u0017\u001a\u00020\u0016HÖ\u0001¢\u0006\u0004\b\u0017\u0010\u0018J\u001a\u0010\u001b\u001a\u00020\u001a2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001b\u0010\u001cR\u0019\u0010\u000f\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u001d\u001a\u0004\b\u001e\u0010\u0004R\u001b\u0010\u0012\u001a\u0004\u0018\u00010\t8\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u001f\u001a\u0004\b \u0010\u000bR\u001b\u0010\u000e\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u000e\u0010!\u001a\u0004\b\"\u0010\u0006R\u001b\u0010\u0010\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0010\u0010!\u001a\u0004\b#\u0010\u0006R\u0019\u0010\r\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\u001d\u001a\u0004\b$\u0010\u0004R\u001b\u0010\u0011\u001a\u0004\u0018\u00010\t8\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u001f\u001a\u0004\b%\u0010\u000b¨\u0006("}, d2 = {"Lcom/discord/widgets/servers/guild_role_subscription/model/CurrentMonthEarningMetrics;", "", "", "component1", "()J", "component2", "()Ljava/lang/Long;", "component3", "component4", "", "component5", "()Ljava/lang/String;", "component6", "revenue", "monthOverMonthRevenueChangePercent", "subscriberCount", "monthOverMonthSubscriberCountChange", "nextPaymentDate", "revenueSinceDate", "copy", "(JLjava/lang/Long;JLjava/lang/Long;Ljava/lang/String;Ljava/lang/String;)Lcom/discord/widgets/servers/guild_role_subscription/model/CurrentMonthEarningMetrics;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "J", "getSubscriberCount", "Ljava/lang/String;", "getRevenueSinceDate", "Ljava/lang/Long;", "getMonthOverMonthRevenueChangePercent", "getMonthOverMonthSubscriberCountChange", "getRevenue", "getNextPaymentDate", "<init>", "(JLjava/lang/Long;JLjava/lang/Long;Ljava/lang/String;Ljava/lang/String;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final /* data */ class CurrentMonthEarningMetrics {
    private final Long monthOverMonthRevenueChangePercent;
    private final Long monthOverMonthSubscriberCountChange;
    private final String nextPaymentDate;
    private final long revenue;
    private final String revenueSinceDate;
    private final long subscriberCount;

    public CurrentMonthEarningMetrics() {
        this(0L, null, 0L, null, null, null, 63, null);
    }

    public CurrentMonthEarningMetrics(long j, Long l, long j2, Long l2, String str, String str2) {
        this.revenue = j;
        this.monthOverMonthRevenueChangePercent = l;
        this.subscriberCount = j2;
        this.monthOverMonthSubscriberCountChange = l2;
        this.nextPaymentDate = str;
        this.revenueSinceDate = str2;
    }

    public static /* synthetic */ CurrentMonthEarningMetrics copy$default(CurrentMonthEarningMetrics currentMonthEarningMetrics, long j, Long l, long j2, Long l2, String str, String str2, int i, Object obj) {
        return currentMonthEarningMetrics.copy((i & 1) != 0 ? currentMonthEarningMetrics.revenue : j, (i & 2) != 0 ? currentMonthEarningMetrics.monthOverMonthRevenueChangePercent : l, (i & 4) != 0 ? currentMonthEarningMetrics.subscriberCount : j2, (i & 8) != 0 ? currentMonthEarningMetrics.monthOverMonthSubscriberCountChange : l2, (i & 16) != 0 ? currentMonthEarningMetrics.nextPaymentDate : str, (i & 32) != 0 ? currentMonthEarningMetrics.revenueSinceDate : str2);
    }

    /* renamed from: component1, reason: from getter */
    public final long getRevenue() {
        return this.revenue;
    }

    /* renamed from: component2, reason: from getter */
    public final Long getMonthOverMonthRevenueChangePercent() {
        return this.monthOverMonthRevenueChangePercent;
    }

    /* renamed from: component3, reason: from getter */
    public final long getSubscriberCount() {
        return this.subscriberCount;
    }

    /* renamed from: component4, reason: from getter */
    public final Long getMonthOverMonthSubscriberCountChange() {
        return this.monthOverMonthSubscriberCountChange;
    }

    /* renamed from: component5, reason: from getter */
    public final String getNextPaymentDate() {
        return this.nextPaymentDate;
    }

    /* renamed from: component6, reason: from getter */
    public final String getRevenueSinceDate() {
        return this.revenueSinceDate;
    }

    public final CurrentMonthEarningMetrics copy(long revenue, Long monthOverMonthRevenueChangePercent, long subscriberCount, Long monthOverMonthSubscriberCountChange, String nextPaymentDate, String revenueSinceDate) {
        return new CurrentMonthEarningMetrics(revenue, monthOverMonthRevenueChangePercent, subscriberCount, monthOverMonthSubscriberCountChange, nextPaymentDate, revenueSinceDate);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CurrentMonthEarningMetrics)) {
            return false;
        }
        CurrentMonthEarningMetrics currentMonthEarningMetrics = (CurrentMonthEarningMetrics) other;
        return this.revenue == currentMonthEarningMetrics.revenue && Intrinsics3.areEqual(this.monthOverMonthRevenueChangePercent, currentMonthEarningMetrics.monthOverMonthRevenueChangePercent) && this.subscriberCount == currentMonthEarningMetrics.subscriberCount && Intrinsics3.areEqual(this.monthOverMonthSubscriberCountChange, currentMonthEarningMetrics.monthOverMonthSubscriberCountChange) && Intrinsics3.areEqual(this.nextPaymentDate, currentMonthEarningMetrics.nextPaymentDate) && Intrinsics3.areEqual(this.revenueSinceDate, currentMonthEarningMetrics.revenueSinceDate);
    }

    public final Long getMonthOverMonthRevenueChangePercent() {
        return this.monthOverMonthRevenueChangePercent;
    }

    public final Long getMonthOverMonthSubscriberCountChange() {
        return this.monthOverMonthSubscriberCountChange;
    }

    public final String getNextPaymentDate() {
        return this.nextPaymentDate;
    }

    public final long getRevenue() {
        return this.revenue;
    }

    public final String getRevenueSinceDate() {
        return this.revenueSinceDate;
    }

    public final long getSubscriberCount() {
        return this.subscriberCount;
    }

    public int hashCode() {
        int iA = b.a(this.revenue) * 31;
        Long l = this.monthOverMonthRevenueChangePercent;
        int iA2 = (b.a(this.subscriberCount) + ((iA + (l != null ? l.hashCode() : 0)) * 31)) * 31;
        Long l2 = this.monthOverMonthSubscriberCountChange;
        int iHashCode = (iA2 + (l2 != null ? l2.hashCode() : 0)) * 31;
        String str = this.nextPaymentDate;
        int iHashCode2 = (iHashCode + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.revenueSinceDate;
        return iHashCode2 + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("CurrentMonthEarningMetrics(revenue=");
        sbU.append(this.revenue);
        sbU.append(", monthOverMonthRevenueChangePercent=");
        sbU.append(this.monthOverMonthRevenueChangePercent);
        sbU.append(", subscriberCount=");
        sbU.append(this.subscriberCount);
        sbU.append(", monthOverMonthSubscriberCountChange=");
        sbU.append(this.monthOverMonthSubscriberCountChange);
        sbU.append(", nextPaymentDate=");
        sbU.append(this.nextPaymentDate);
        sbU.append(", revenueSinceDate=");
        return outline.J(sbU, this.revenueSinceDate, ")");
    }

    public /* synthetic */ CurrentMonthEarningMetrics(long j, Long l, long j2, Long l2, String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? 0L : j, (i & 2) != 0 ? null : l, (i & 4) == 0 ? j2 : 0L, (i & 8) == 0 ? l2 : null, (i & 16) != 0 ? "" : str, (i & 32) == 0 ? str2 : "");
    }
}
