package com.discord.stores;

import a0.a.a.b;
import b.d.b.a.outline;
import d0.t.Collections2;
import d0.z.d.Intrinsics3;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: StoreRtcRegion.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B1\u0012\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\b\b\u0002\u0010\f\u001a\u00020\u0007¢\u0006\u0004\b\u001d\u0010\u001eJ\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0005J\u0010\u0010\b\u001a\u00020\u0007HÆ\u0003¢\u0006\u0004\b\b\u0010\tJ:\u0010\r\u001a\u00020\u00002\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\b\b\u0002\u0010\f\u001a\u00020\u0007HÆ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0012\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u001a\u0010\u0016\u001a\u00020\u00152\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0016\u0010\u0017R\u001f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\n\u0010\u0018\u001a\u0004\b\u0019\u0010\u0005R\u001f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u0018\u001a\u0004\b\u001a\u0010\u0005R\u0019\u0010\f\u001a\u00020\u00078\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\u001b\u001a\u0004\b\u001c\u0010\t¨\u0006\u001f"}, d2 = {"Lcom/discord/stores/RtcLatencyTestResult;", "", "", "", "component1", "()Ljava/util/List;", "component2", "", "component3", "()J", "latencyRankedRegions", "geoRankedRegions", "lastTestTimestampMs", "copy", "(Ljava/util/List;Ljava/util/List;J)Lcom/discord/stores/RtcLatencyTestResult;", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/util/List;", "getLatencyRankedRegions", "getGeoRankedRegions", "J", "getLastTestTimestampMs", "<init>", "(Ljava/util/List;Ljava/util/List;J)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* renamed from: com.discord.stores.RtcLatencyTestResult, reason: use source file name */
/* loaded from: classes2.dex */
public final /* data */ class StoreRtcRegion2 {
    private final List<String> geoRankedRegions;
    private final long lastTestTimestampMs;
    private final List<String> latencyRankedRegions;

    public StoreRtcRegion2() {
        this(null, null, 0L, 7, null);
    }

    public StoreRtcRegion2(List<String> list, List<String> list2, long j) {
        Intrinsics3.checkNotNullParameter(list, "latencyRankedRegions");
        Intrinsics3.checkNotNullParameter(list2, "geoRankedRegions");
        this.latencyRankedRegions = list;
        this.geoRankedRegions = list2;
        this.lastTestTimestampMs = j;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ StoreRtcRegion2 copy$default(StoreRtcRegion2 storeRtcRegion2, List list, List list2, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            list = storeRtcRegion2.latencyRankedRegions;
        }
        if ((i & 2) != 0) {
            list2 = storeRtcRegion2.geoRankedRegions;
        }
        if ((i & 4) != 0) {
            j = storeRtcRegion2.lastTestTimestampMs;
        }
        return storeRtcRegion2.copy(list, list2, j);
    }

    public final List<String> component1() {
        return this.latencyRankedRegions;
    }

    public final List<String> component2() {
        return this.geoRankedRegions;
    }

    /* renamed from: component3, reason: from getter */
    public final long getLastTestTimestampMs() {
        return this.lastTestTimestampMs;
    }

    public final StoreRtcRegion2 copy(List<String> latencyRankedRegions, List<String> geoRankedRegions, long lastTestTimestampMs) {
        Intrinsics3.checkNotNullParameter(latencyRankedRegions, "latencyRankedRegions");
        Intrinsics3.checkNotNullParameter(geoRankedRegions, "geoRankedRegions");
        return new StoreRtcRegion2(latencyRankedRegions, geoRankedRegions, lastTestTimestampMs);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof StoreRtcRegion2)) {
            return false;
        }
        StoreRtcRegion2 storeRtcRegion2 = (StoreRtcRegion2) other;
        return Intrinsics3.areEqual(this.latencyRankedRegions, storeRtcRegion2.latencyRankedRegions) && Intrinsics3.areEqual(this.geoRankedRegions, storeRtcRegion2.geoRankedRegions) && this.lastTestTimestampMs == storeRtcRegion2.lastTestTimestampMs;
    }

    public final List<String> getGeoRankedRegions() {
        return this.geoRankedRegions;
    }

    public final long getLastTestTimestampMs() {
        return this.lastTestTimestampMs;
    }

    public final List<String> getLatencyRankedRegions() {
        return this.latencyRankedRegions;
    }

    public int hashCode() {
        List<String> list = this.latencyRankedRegions;
        int iHashCode = (list != null ? list.hashCode() : 0) * 31;
        List<String> list2 = this.geoRankedRegions;
        return b.a(this.lastTestTimestampMs) + ((iHashCode + (list2 != null ? list2.hashCode() : 0)) * 31);
    }

    public String toString() {
        StringBuilder sbU = outline.U("RtcLatencyTestResult(latencyRankedRegions=");
        sbU.append(this.latencyRankedRegions);
        sbU.append(", geoRankedRegions=");
        sbU.append(this.geoRankedRegions);
        sbU.append(", lastTestTimestampMs=");
        return outline.C(sbU, this.lastTestTimestampMs, ")");
    }

    public /* synthetic */ StoreRtcRegion2(List list, List list2, long j, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? Collections2.emptyList() : list, (i & 2) != 0 ? Collections2.emptyList() : list2, (i & 4) != 0 ? 0L : j);
    }
}
