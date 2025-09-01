package com.discord.api.report;

import b.d.b.a.outline;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.Intrinsics3;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: InAppReportsMenu.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0086\b\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bJ\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\n\u0010\u000bR!\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f8\u0006@\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0019\u0010\u0012\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0004R\u0019\u0010\u0015\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0013\u001a\u0004\b\u0016\u0010\u0004R\u0019\u0010\u0017\u001a\u00020\t8\u0006@\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a¨\u0006\u001c"}, d2 = {"Lcom/discord/api/report/ReportNodeElement;", "", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "Lcom/discord/api/report/ReportNodeElementData;", "data", "Ljava/util/List;", "a", "()Ljava/util/List;", "type", "Ljava/lang/String;", "c", ModelAuditLogEntry.CHANGE_KEY_NAME, "b", "should_submit_data", "Z", "getShould_submit_data", "()Z", "Companion", "discord_api"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final /* data */ class ReportNodeElement {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final List<ReportNodeElementData> data;
    private final String name;
    private final boolean should_submit_data;
    private final String type;

    /* compiled from: InAppReportsMenu.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/discord/api/report/ReportNodeElement$Companion;", "", "<init>", "()V", "discord_api"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
        }
    }

    public final List<ReportNodeElementData> a() {
        return this.data;
    }

    /* renamed from: b, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* renamed from: c, reason: from getter */
    public final String getType() {
        return this.type;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ReportNodeElement)) {
            return false;
        }
        ReportNodeElement reportNodeElement = (ReportNodeElement) other;
        return Intrinsics3.areEqual(this.type, reportNodeElement.type) && Intrinsics3.areEqual(this.name, reportNodeElement.name) && Intrinsics3.areEqual(this.data, reportNodeElement.data) && this.should_submit_data == reportNodeElement.should_submit_data;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        String str = this.type;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.name;
        int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        List<ReportNodeElementData> list = this.data;
        int iHashCode3 = (iHashCode2 + (list != null ? list.hashCode() : 0)) * 31;
        boolean z2 = this.should_submit_data;
        int i = z2;
        if (z2 != 0) {
            i = 1;
        }
        return iHashCode3 + i;
    }

    public String toString() {
        StringBuilder sbU = outline.U("ReportNodeElement(type=");
        sbU.append(this.type);
        sbU.append(", name=");
        sbU.append(this.name);
        sbU.append(", data=");
        sbU.append(this.data);
        sbU.append(", should_submit_data=");
        return outline.O(sbU, this.should_submit_data, ")");
    }
}
