package com.discord.api.report;

import b.d.b.a.outline;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.Intrinsics3;
import java.util.Map;
import kotlin.Metadata;

/* compiled from: InAppReportsMenu.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\n\u0010\u000bR\u0019\u0010\f\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u0004R\u0019\u0010\u000f\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010\r\u001a\u0004\b\u0010\u0010\u0004R\u001b\u0010\u0011\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010\r\u001a\u0004\b\u0012\u0010\u0004R\u001d\u0010\u0014\u001a\u00060\u0005j\u0002`\u00138\u0006@\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0007R\u0019\u0010\u0017\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0017\u0010\r\u001a\u0004\b\u0018\u0010\u0004R)\u0010\u001b\u001a\u0012\u0012\b\u0012\u00060\u0005j\u0002`\u0013\u0012\u0004\u0012\u00020\u001a0\u00198\u0006@\u0006¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u001d\u0010\u001f\u001a\u00060\u0005j\u0002`\u00138\u0006@\u0006¢\u0006\f\n\u0004\b\u001f\u0010\u0015\u001a\u0004\b \u0010\u0007R\u0019\u0010!\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b!\u0010\r\u001a\u0004\b\"\u0010\u0004¨\u0006#"}, d2 = {"Lcom/discord/api/report/MenuAPIResponse;", "", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", ModelAuditLogEntry.CHANGE_KEY_NAME, "Ljava/lang/String;", "b", "version", "g", "language", "a", "Lcom/discord/api/report/ReportNodeRef;", "success_node_id", "I", "e", "variant", "f", "", "Lcom/discord/api/report/ReportNode;", "nodes", "Ljava/util/Map;", "c", "()Ljava/util/Map;", "root_node_id", "d", "postback_url", "getPostback_url", "discord_api"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final /* data */ class MenuAPIResponse {
    private final String language;
    private final String name;
    private final Map<Integer, ReportNode> nodes;
    private final String postback_url;
    private final int root_node_id;
    private final int success_node_id;
    private final String variant;
    private final String version;

    /* renamed from: a, reason: from getter */
    public final String getLanguage() {
        return this.language;
    }

    /* renamed from: b, reason: from getter */
    public final String getName() {
        return this.name;
    }

    public final Map<Integer, ReportNode> c() {
        return this.nodes;
    }

    /* renamed from: d, reason: from getter */
    public final int getRoot_node_id() {
        return this.root_node_id;
    }

    /* renamed from: e, reason: from getter */
    public final int getSuccess_node_id() {
        return this.success_node_id;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MenuAPIResponse)) {
            return false;
        }
        MenuAPIResponse menuAPIResponse = (MenuAPIResponse) other;
        return Intrinsics3.areEqual(this.name, menuAPIResponse.name) && Intrinsics3.areEqual(this.variant, menuAPIResponse.variant) && Intrinsics3.areEqual(this.version, menuAPIResponse.version) && Intrinsics3.areEqual(this.language, menuAPIResponse.language) && this.success_node_id == menuAPIResponse.success_node_id && this.root_node_id == menuAPIResponse.root_node_id && Intrinsics3.areEqual(this.postback_url, menuAPIResponse.postback_url) && Intrinsics3.areEqual(this.nodes, menuAPIResponse.nodes);
    }

    /* renamed from: f, reason: from getter */
    public final String getVariant() {
        return this.variant;
    }

    /* renamed from: g, reason: from getter */
    public final String getVersion() {
        return this.version;
    }

    public int hashCode() {
        String str = this.name;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.variant;
        int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.version;
        int iHashCode3 = (iHashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.language;
        int iHashCode4 = (((((iHashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31) + this.success_node_id) * 31) + this.root_node_id) * 31;
        String str5 = this.postback_url;
        int iHashCode5 = (iHashCode4 + (str5 != null ? str5.hashCode() : 0)) * 31;
        Map<Integer, ReportNode> map = this.nodes;
        return iHashCode5 + (map != null ? map.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("MenuAPIResponse(name=");
        sbU.append(this.name);
        sbU.append(", variant=");
        sbU.append(this.variant);
        sbU.append(", version=");
        sbU.append(this.version);
        sbU.append(", language=");
        sbU.append(this.language);
        sbU.append(", success_node_id=");
        sbU.append(this.success_node_id);
        sbU.append(", root_node_id=");
        sbU.append(this.root_node_id);
        sbU.append(", postback_url=");
        sbU.append(this.postback_url);
        sbU.append(", nodes=");
        return outline.M(sbU, this.nodes, ")");
    }
}
