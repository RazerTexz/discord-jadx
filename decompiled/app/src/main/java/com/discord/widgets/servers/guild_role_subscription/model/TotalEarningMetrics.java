package com.discord.widgets.servers.guild_role_subscription.model;

import b.d.b.a.outline;
import d0.t.Collections2;
import d0.z.d.Intrinsics3;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: TotalEarningMetrics.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0005\u0012\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00050\b¢\u0006\u0004\b \u0010!J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0016\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ6\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u000b\u001a\u00020\u00022\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00052\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00050\bHÆ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0014\u001a\u00020\u0013HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u001a\u0010\u0018\u001a\u00020\u00172\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0018\u0010\u0019R\u001f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00050\b8\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\u001a\u001a\u0004\b\u001b\u0010\nR\u0019\u0010\u000b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u001c\u001a\u0004\b\u001d\u0010\u0004R\u001b\u0010\f\u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\u001e\u001a\u0004\b\u001f\u0010\u0007¨\u0006\""}, d2 = {"Lcom/discord/widgets/servers/guild_role_subscription/model/TotalEarningMetrics;", "", "Lcom/discord/widgets/servers/guild_role_subscription/model/CurrentMonthEarningMetrics;", "component1", "()Lcom/discord/widgets/servers/guild_role_subscription/model/CurrentMonthEarningMetrics;", "Lcom/discord/widgets/servers/guild_role_subscription/model/TotalPayoutsForPeriod;", "component2", "()Lcom/discord/widgets/servers/guild_role_subscription/model/TotalPayoutsForPeriod;", "", "component3", "()Ljava/util/List;", "currentMonthEarningMetrics", "currentPeriod", "previousPeriods", "copy", "(Lcom/discord/widgets/servers/guild_role_subscription/model/CurrentMonthEarningMetrics;Lcom/discord/widgets/servers/guild_role_subscription/model/TotalPayoutsForPeriod;Ljava/util/List;)Lcom/discord/widgets/servers/guild_role_subscription/model/TotalEarningMetrics;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/util/List;", "getPreviousPeriods", "Lcom/discord/widgets/servers/guild_role_subscription/model/CurrentMonthEarningMetrics;", "getCurrentMonthEarningMetrics", "Lcom/discord/widgets/servers/guild_role_subscription/model/TotalPayoutsForPeriod;", "getCurrentPeriod", "<init>", "(Lcom/discord/widgets/servers/guild_role_subscription/model/CurrentMonthEarningMetrics;Lcom/discord/widgets/servers/guild_role_subscription/model/TotalPayoutsForPeriod;Ljava/util/List;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final /* data */ class TotalEarningMetrics {
    private final CurrentMonthEarningMetrics currentMonthEarningMetrics;
    private final TotalPayoutsForPeriod currentPeriod;
    private final List<TotalPayoutsForPeriod> previousPeriods;

    public TotalEarningMetrics(CurrentMonthEarningMetrics currentMonthEarningMetrics, TotalPayoutsForPeriod totalPayoutsForPeriod, List<TotalPayoutsForPeriod> list) {
        Intrinsics3.checkNotNullParameter(currentMonthEarningMetrics, "currentMonthEarningMetrics");
        Intrinsics3.checkNotNullParameter(list, "previousPeriods");
        this.currentMonthEarningMetrics = currentMonthEarningMetrics;
        this.currentPeriod = totalPayoutsForPeriod;
        this.previousPeriods = list;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ TotalEarningMetrics copy$default(TotalEarningMetrics totalEarningMetrics, CurrentMonthEarningMetrics currentMonthEarningMetrics, TotalPayoutsForPeriod totalPayoutsForPeriod, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            currentMonthEarningMetrics = totalEarningMetrics.currentMonthEarningMetrics;
        }
        if ((i & 2) != 0) {
            totalPayoutsForPeriod = totalEarningMetrics.currentPeriod;
        }
        if ((i & 4) != 0) {
            list = totalEarningMetrics.previousPeriods;
        }
        return totalEarningMetrics.copy(currentMonthEarningMetrics, totalPayoutsForPeriod, list);
    }

    /* renamed from: component1, reason: from getter */
    public final CurrentMonthEarningMetrics getCurrentMonthEarningMetrics() {
        return this.currentMonthEarningMetrics;
    }

    /* renamed from: component2, reason: from getter */
    public final TotalPayoutsForPeriod getCurrentPeriod() {
        return this.currentPeriod;
    }

    public final List<TotalPayoutsForPeriod> component3() {
        return this.previousPeriods;
    }

    public final TotalEarningMetrics copy(CurrentMonthEarningMetrics currentMonthEarningMetrics, TotalPayoutsForPeriod currentPeriod, List<TotalPayoutsForPeriod> previousPeriods) {
        Intrinsics3.checkNotNullParameter(currentMonthEarningMetrics, "currentMonthEarningMetrics");
        Intrinsics3.checkNotNullParameter(previousPeriods, "previousPeriods");
        return new TotalEarningMetrics(currentMonthEarningMetrics, currentPeriod, previousPeriods);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TotalEarningMetrics)) {
            return false;
        }
        TotalEarningMetrics totalEarningMetrics = (TotalEarningMetrics) other;
        return Intrinsics3.areEqual(this.currentMonthEarningMetrics, totalEarningMetrics.currentMonthEarningMetrics) && Intrinsics3.areEqual(this.currentPeriod, totalEarningMetrics.currentPeriod) && Intrinsics3.areEqual(this.previousPeriods, totalEarningMetrics.previousPeriods);
    }

    public final CurrentMonthEarningMetrics getCurrentMonthEarningMetrics() {
        return this.currentMonthEarningMetrics;
    }

    public final TotalPayoutsForPeriod getCurrentPeriod() {
        return this.currentPeriod;
    }

    public final List<TotalPayoutsForPeriod> getPreviousPeriods() {
        return this.previousPeriods;
    }

    public int hashCode() {
        CurrentMonthEarningMetrics currentMonthEarningMetrics = this.currentMonthEarningMetrics;
        int iHashCode = (currentMonthEarningMetrics != null ? currentMonthEarningMetrics.hashCode() : 0) * 31;
        TotalPayoutsForPeriod totalPayoutsForPeriod = this.currentPeriod;
        int iHashCode2 = (iHashCode + (totalPayoutsForPeriod != null ? totalPayoutsForPeriod.hashCode() : 0)) * 31;
        List<TotalPayoutsForPeriod> list = this.previousPeriods;
        return iHashCode2 + (list != null ? list.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TotalEarningMetrics(currentMonthEarningMetrics=");
        sbU.append(this.currentMonthEarningMetrics);
        sbU.append(", currentPeriod=");
        sbU.append(this.currentPeriod);
        sbU.append(", previousPeriods=");
        return outline.L(sbU, this.previousPeriods, ")");
    }

    public /* synthetic */ TotalEarningMetrics(CurrentMonthEarningMetrics currentMonthEarningMetrics, TotalPayoutsForPeriod totalPayoutsForPeriod, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(currentMonthEarningMetrics, totalPayoutsForPeriod, (i & 4) != 0 ? Collections2.emptyList() : list);
    }
}
