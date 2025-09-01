package com.discord.widgets.servers.guild_role_subscription.model;

import a0.a.a.b;
import b.d.b.a.outline;
import com.discord.api.guildrolesubscription.PayoutGroup;
import d0.z.d.Intrinsics3;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: TotalPayoutsForPeriod.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u0001B;\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0005\u0012\u0016\b\u0002\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\n\u0018\u00010\t¢\u0006\u0004\b\"\u0010#J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\b\u0010\u0007J\u001e\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\n\u0018\u00010\tHÆ\u0003¢\u0006\u0004\b\u000b\u0010\fJF\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\r\u001a\u00020\u00022\b\b\u0002\u0010\u000e\u001a\u00020\u00052\b\b\u0002\u0010\u000f\u001a\u00020\u00052\u0016\b\u0002\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\n\u0018\u00010\tHÆ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0004J\u0010\u0010\u0015\u001a\u00020\u0014HÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u001a\u0010\u0019\u001a\u00020\u00182\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0019\u0010\u001aR'\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\n\u0018\u00010\t8\u0006@\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u001b\u001a\u0004\b\u001c\u0010\fR\u0019\u0010\r\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\u001d\u001a\u0004\b\u001e\u0010\u0004R\u0019\u0010\u000e\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u001f\u001a\u0004\b \u0010\u0007R\u0019\u0010\u000f\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u001f\u001a\u0004\b!\u0010\u0007¨\u0006$"}, d2 = {"Lcom/discord/widgets/servers/guild_role_subscription/model/TotalPayoutsForPeriod;", "", "", "component1", "()Ljava/lang/String;", "", "component2", "()J", "component3", "", "Lcom/discord/api/guildrolesubscription/PayoutGroup;", "component4", "()Ljava/util/Map;", "periodStartingAt", "subscriberCount", "revenue", "payoutGroups", "copy", "(Ljava/lang/String;JJLjava/util/Map;)Lcom/discord/widgets/servers/guild_role_subscription/model/TotalPayoutsForPeriod;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/util/Map;", "getPayoutGroups", "Ljava/lang/String;", "getPeriodStartingAt", "J", "getSubscriberCount", "getRevenue", "<init>", "(Ljava/lang/String;JJLjava/util/Map;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final /* data */ class TotalPayoutsForPeriod {
    private final Map<Long, PayoutGroup> payoutGroups;
    private final String periodStartingAt;
    private final long revenue;
    private final long subscriberCount;

    public TotalPayoutsForPeriod(String str, long j, long j2, Map<Long, PayoutGroup> map) {
        Intrinsics3.checkNotNullParameter(str, "periodStartingAt");
        this.periodStartingAt = str;
        this.subscriberCount = j;
        this.revenue = j2;
        this.payoutGroups = map;
    }

    public static /* synthetic */ TotalPayoutsForPeriod copy$default(TotalPayoutsForPeriod totalPayoutsForPeriod, String str, long j, long j2, Map map, int i, Object obj) {
        if ((i & 1) != 0) {
            str = totalPayoutsForPeriod.periodStartingAt;
        }
        if ((i & 2) != 0) {
            j = totalPayoutsForPeriod.subscriberCount;
        }
        long j3 = j;
        if ((i & 4) != 0) {
            j2 = totalPayoutsForPeriod.revenue;
        }
        long j4 = j2;
        if ((i & 8) != 0) {
            map = totalPayoutsForPeriod.payoutGroups;
        }
        return totalPayoutsForPeriod.copy(str, j3, j4, map);
    }

    /* renamed from: component1, reason: from getter */
    public final String getPeriodStartingAt() {
        return this.periodStartingAt;
    }

    /* renamed from: component2, reason: from getter */
    public final long getSubscriberCount() {
        return this.subscriberCount;
    }

    /* renamed from: component3, reason: from getter */
    public final long getRevenue() {
        return this.revenue;
    }

    public final Map<Long, PayoutGroup> component4() {
        return this.payoutGroups;
    }

    public final TotalPayoutsForPeriod copy(String periodStartingAt, long subscriberCount, long revenue, Map<Long, PayoutGroup> payoutGroups) {
        Intrinsics3.checkNotNullParameter(periodStartingAt, "periodStartingAt");
        return new TotalPayoutsForPeriod(periodStartingAt, subscriberCount, revenue, payoutGroups);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TotalPayoutsForPeriod)) {
            return false;
        }
        TotalPayoutsForPeriod totalPayoutsForPeriod = (TotalPayoutsForPeriod) other;
        return Intrinsics3.areEqual(this.periodStartingAt, totalPayoutsForPeriod.periodStartingAt) && this.subscriberCount == totalPayoutsForPeriod.subscriberCount && this.revenue == totalPayoutsForPeriod.revenue && Intrinsics3.areEqual(this.payoutGroups, totalPayoutsForPeriod.payoutGroups);
    }

    public final Map<Long, PayoutGroup> getPayoutGroups() {
        return this.payoutGroups;
    }

    public final String getPeriodStartingAt() {
        return this.periodStartingAt;
    }

    public final long getRevenue() {
        return this.revenue;
    }

    public final long getSubscriberCount() {
        return this.subscriberCount;
    }

    public int hashCode() {
        String str = this.periodStartingAt;
        int iA = (b.a(this.revenue) + ((b.a(this.subscriberCount) + ((str != null ? str.hashCode() : 0) * 31)) * 31)) * 31;
        Map<Long, PayoutGroup> map = this.payoutGroups;
        return iA + (map != null ? map.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TotalPayoutsForPeriod(periodStartingAt=");
        sbU.append(this.periodStartingAt);
        sbU.append(", subscriberCount=");
        sbU.append(this.subscriberCount);
        sbU.append(", revenue=");
        sbU.append(this.revenue);
        sbU.append(", payoutGroups=");
        return outline.M(sbU, this.payoutGroups, ")");
    }

    public /* synthetic */ TotalPayoutsForPeriod(String str, long j, long j2, Map map, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? 0L : j, (i & 4) == 0 ? j2 : 0L, (i & 8) != 0 ? null : map);
    }
}
