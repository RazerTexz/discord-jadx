package com.discord.models.domain;

import b.d.b.a.outline;
import d0.z.d.Intrinsics3;
import java.util.List;
import kotlin.Metadata;

/* compiled from: ModelRtcLatencyRegion.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00020\u0005¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J*\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00022\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00020\u0005HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\f\u0010\u0004J\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013R\u0019\u0010\b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\u0014\u001a\u0004\b\u0015\u0010\u0004R\u001f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\u0016\u001a\u0004\b\u0017\u0010\u0007¨\u0006\u001a"}, d2 = {"Lcom/discord/models/domain/ModelRtcLatencyRegion;", "", "", "component1", "()Ljava/lang/String;", "", "component2", "()Ljava/util/List;", ModelAuditLogEntry.CHANGE_KEY_REGION, "ips", "copy", "(Ljava/lang/String;Ljava/util/List;)Lcom/discord/models/domain/ModelRtcLatencyRegion;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getRegion", "Ljava/util/List;", "getIps", "<init>", "(Ljava/lang/String;Ljava/util/List;)V", "app_models_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final /* data */ class ModelRtcLatencyRegion {
    private final List<String> ips;
    private final String region;

    public ModelRtcLatencyRegion(String str, List<String> list) {
        Intrinsics3.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_REGION);
        Intrinsics3.checkNotNullParameter(list, "ips");
        this.region = str;
        this.ips = list;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ModelRtcLatencyRegion copy$default(ModelRtcLatencyRegion modelRtcLatencyRegion, String str, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            str = modelRtcLatencyRegion.region;
        }
        if ((i & 2) != 0) {
            list = modelRtcLatencyRegion.ips;
        }
        return modelRtcLatencyRegion.copy(str, list);
    }

    /* renamed from: component1, reason: from getter */
    public final String getRegion() {
        return this.region;
    }

    public final List<String> component2() {
        return this.ips;
    }

    public final ModelRtcLatencyRegion copy(String region, List<String> ips) {
        Intrinsics3.checkNotNullParameter(region, ModelAuditLogEntry.CHANGE_KEY_REGION);
        Intrinsics3.checkNotNullParameter(ips, "ips");
        return new ModelRtcLatencyRegion(region, ips);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ModelRtcLatencyRegion)) {
            return false;
        }
        ModelRtcLatencyRegion modelRtcLatencyRegion = (ModelRtcLatencyRegion) other;
        return Intrinsics3.areEqual(this.region, modelRtcLatencyRegion.region) && Intrinsics3.areEqual(this.ips, modelRtcLatencyRegion.ips);
    }

    public final List<String> getIps() {
        return this.ips;
    }

    public final String getRegion() {
        return this.region;
    }

    public int hashCode() {
        String str = this.region;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        List<String> list = this.ips;
        return iHashCode + (list != null ? list.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("ModelRtcLatencyRegion(region=");
        sbU.append(this.region);
        sbU.append(", ips=");
        return outline.L(sbU, this.ips, ")");
    }
}
