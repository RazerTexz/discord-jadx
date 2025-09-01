package com.discord.utilities.experiments;

import b.d.b.a.outline;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.Intrinsics3;
import java.util.List;
import kotlin.Metadata;

/* compiled from: ExperimentRegistry.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0012\b\u0086\b\u0018\u00002\u00020\u0001:\u0001(B5\u0012\u0006\u0010\u000f\u001a\u00020\u0002\u0012\u0006\u0010\u0010\u001a\u00020\u0002\u0012\u0006\u0010\u0011\u001a\u00020\u0006\u0012\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00020\t\u0012\u0006\u0010\u0013\u001a\u00020\f¢\u0006\u0004\b&\u0010'J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0016\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÆ\u0003¢\u0006\u0004\b\r\u0010\u000eJH\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u000f\u001a\u00020\u00022\b\b\u0002\u0010\u0010\u001a\u00020\u00022\b\b\u0002\u0010\u0011\u001a\u00020\u00062\u000e\b\u0002\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00020\t2\b\b\u0002\u0010\u0013\u001a\u00020\fHÆ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0016\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0004J\u0010\u0010\u0018\u001a\u00020\u0017HÖ\u0001¢\u0006\u0004\b\u0018\u0010\u0019J\u001a\u0010\u001b\u001a\u00020\f2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001b\u0010\u001cR\u0019\u0010\u0013\u001a\u00020\f8\u0006@\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u001d\u001a\u0004\b\u001e\u0010\u000eR\u0019\u0010\u0010\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u001f\u001a\u0004\b \u0010\u0004R\u0019\u0010\u000f\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u001f\u001a\u0004\b!\u0010\u0004R\u001f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00020\t8\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010\"\u001a\u0004\b#\u0010\u000bR\u0019\u0010\u0011\u001a\u00020\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010$\u001a\u0004\b%\u0010\b¨\u0006)"}, d2 = {"Lcom/discord/utilities/experiments/RegisteredExperiment;", "", "", "component1", "()Ljava/lang/String;", "component2", "Lcom/discord/utilities/experiments/RegisteredExperiment$Type;", "component3", "()Lcom/discord/utilities/experiments/RegisteredExperiment$Type;", "", "component4", "()Ljava/util/List;", "", "component5", "()Z", "readableName", ModelAuditLogEntry.CHANGE_KEY_NAME, "type", "buckets", "cacheExperiment", "copy", "(Ljava/lang/String;Ljava/lang/String;Lcom/discord/utilities/experiments/RegisteredExperiment$Type;Ljava/util/List;Z)Lcom/discord/utilities/experiments/RegisteredExperiment;", "toString", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Z", "getCacheExperiment", "Ljava/lang/String;", "getName", "getReadableName", "Ljava/util/List;", "getBuckets", "Lcom/discord/utilities/experiments/RegisteredExperiment$Type;", "getType", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/discord/utilities/experiments/RegisteredExperiment$Type;Ljava/util/List;Z)V", "Type", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* renamed from: com.discord.utilities.experiments.RegisteredExperiment, reason: use source file name */
/* loaded from: classes2.dex */
public final /* data */ class ExperimentRegistry2 {
    private final List<String> buckets;
    private final boolean cacheExperiment;
    private final String name;
    private final String readableName;
    private final Type type;

    /* compiled from: ExperimentRegistry.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/discord/utilities/experiments/RegisteredExperiment$Type;", "", "<init>", "(Ljava/lang/String;I)V", "GUILD", "USER", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    /* renamed from: com.discord.utilities.experiments.RegisteredExperiment$Type */
    public enum Type {
        GUILD,
        USER
    }

    public ExperimentRegistry2(String str, String str2, Type type, List<String> list, boolean z2) {
        Intrinsics3.checkNotNullParameter(str, "readableName");
        Intrinsics3.checkNotNullParameter(str2, ModelAuditLogEntry.CHANGE_KEY_NAME);
        Intrinsics3.checkNotNullParameter(type, "type");
        Intrinsics3.checkNotNullParameter(list, "buckets");
        this.readableName = str;
        this.name = str2;
        this.type = type;
        this.buckets = list;
        this.cacheExperiment = z2;
    }

    public static /* synthetic */ ExperimentRegistry2 copy$default(ExperimentRegistry2 experimentRegistry2, String str, String str2, Type type, List list, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = experimentRegistry2.readableName;
        }
        if ((i & 2) != 0) {
            str2 = experimentRegistry2.name;
        }
        String str3 = str2;
        if ((i & 4) != 0) {
            type = experimentRegistry2.type;
        }
        Type type2 = type;
        if ((i & 8) != 0) {
            list = experimentRegistry2.buckets;
        }
        List list2 = list;
        if ((i & 16) != 0) {
            z2 = experimentRegistry2.cacheExperiment;
        }
        return experimentRegistry2.copy(str, str3, type2, list2, z2);
    }

    /* renamed from: component1, reason: from getter */
    public final String getReadableName() {
        return this.readableName;
    }

    /* renamed from: component2, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* renamed from: component3, reason: from getter */
    public final Type getType() {
        return this.type;
    }

    public final List<String> component4() {
        return this.buckets;
    }

    /* renamed from: component5, reason: from getter */
    public final boolean getCacheExperiment() {
        return this.cacheExperiment;
    }

    public final ExperimentRegistry2 copy(String readableName, String name, Type type, List<String> buckets, boolean cacheExperiment) {
        Intrinsics3.checkNotNullParameter(readableName, "readableName");
        Intrinsics3.checkNotNullParameter(name, ModelAuditLogEntry.CHANGE_KEY_NAME);
        Intrinsics3.checkNotNullParameter(type, "type");
        Intrinsics3.checkNotNullParameter(buckets, "buckets");
        return new ExperimentRegistry2(readableName, name, type, buckets, cacheExperiment);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ExperimentRegistry2)) {
            return false;
        }
        ExperimentRegistry2 experimentRegistry2 = (ExperimentRegistry2) other;
        return Intrinsics3.areEqual(this.readableName, experimentRegistry2.readableName) && Intrinsics3.areEqual(this.name, experimentRegistry2.name) && Intrinsics3.areEqual(this.type, experimentRegistry2.type) && Intrinsics3.areEqual(this.buckets, experimentRegistry2.buckets) && this.cacheExperiment == experimentRegistry2.cacheExperiment;
    }

    public final List<String> getBuckets() {
        return this.buckets;
    }

    public final boolean getCacheExperiment() {
        return this.cacheExperiment;
    }

    public final String getName() {
        return this.name;
    }

    public final String getReadableName() {
        return this.readableName;
    }

    public final Type getType() {
        return this.type;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        String str = this.readableName;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.name;
        int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        Type type = this.type;
        int iHashCode3 = (iHashCode2 + (type != null ? type.hashCode() : 0)) * 31;
        List<String> list = this.buckets;
        int iHashCode4 = (iHashCode3 + (list != null ? list.hashCode() : 0)) * 31;
        boolean z2 = this.cacheExperiment;
        int i = z2;
        if (z2 != 0) {
            i = 1;
        }
        return iHashCode4 + i;
    }

    public String toString() {
        StringBuilder sbU = outline.U("RegisteredExperiment(readableName=");
        sbU.append(this.readableName);
        sbU.append(", name=");
        sbU.append(this.name);
        sbU.append(", type=");
        sbU.append(this.type);
        sbU.append(", buckets=");
        sbU.append(this.buckets);
        sbU.append(", cacheExperiment=");
        return outline.O(sbU, this.cacheExperiment, ")");
    }
}
