package com.discord.api.bugreport;

import b.d.b.a.outline;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: BugReportConfig.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0011\u001a\u00020\u0002\u0012\u0006\u0010\u0014\u001a\u00020\u0002\u0012\b\u0010\r\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\n\u0010\u000bR\u001b\u0010\r\u001a\u0004\u0018\u00010\f8\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u0019\u0010\u0011\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0004R\u0019\u0010\u0014\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0012\u001a\u0004\b\u0015\u0010\u0004¨\u0006\u0018"}, d2 = {"Lcom/discord/api/bugreport/Feature;", "", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "asanaInboxId", "Ljava/lang/Long;", "a", "()Ljava/lang/Long;", ModelAuditLogEntry.CHANGE_KEY_NAME, "Ljava/lang/String;", "b", "squad", "c", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;)V", "discord_api"}, k = 1, mv = {1, 4, 2})
/* renamed from: com.discord.api.bugreport.Feature, reason: use source file name */
/* loaded from: classes.dex */
public final /* data */ class BugReportConfig2 {
    private final Long asanaInboxId;
    private final String name;
    private final String squad;

    public BugReportConfig2(String str, String str2, Long l) {
        Intrinsics3.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_NAME);
        Intrinsics3.checkNotNullParameter(str2, "squad");
        this.name = str;
        this.squad = str2;
        this.asanaInboxId = l;
    }

    /* renamed from: a, reason: from getter */
    public final Long getAsanaInboxId() {
        return this.asanaInboxId;
    }

    /* renamed from: b, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* renamed from: c, reason: from getter */
    public final String getSquad() {
        return this.squad;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof BugReportConfig2)) {
            return false;
        }
        BugReportConfig2 bugReportConfig2 = (BugReportConfig2) other;
        return Intrinsics3.areEqual(this.name, bugReportConfig2.name) && Intrinsics3.areEqual(this.squad, bugReportConfig2.squad) && Intrinsics3.areEqual(this.asanaInboxId, bugReportConfig2.asanaInboxId);
    }

    public int hashCode() {
        String str = this.name;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.squad;
        int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        Long l = this.asanaInboxId;
        return iHashCode2 + (l != null ? l.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("Feature(name=");
        sbU.append(this.name);
        sbU.append(", squad=");
        sbU.append(this.squad);
        sbU.append(", asanaInboxId=");
        return outline.G(sbU, this.asanaInboxId, ")");
    }
}
