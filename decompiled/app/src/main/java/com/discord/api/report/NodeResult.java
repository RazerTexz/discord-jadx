package com.discord.api.report;

import b.d.b.a.outline;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: InAppReportsMenu.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0017\u001a\u00020\u0016\u0012\b\u0010\r\u001a\u0004\u0018\u00010\f\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\n\u0010\u000bR\u001b\u0010\r\u001a\u0004\u0018\u00010\f8\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001b\u0010\u0012\u001a\u0004\u0018\u00010\u00118\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0019\u0010\u0017\u001a\u00020\u00168\u0006@\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a¨\u0006\u001d"}, d2 = {"Lcom/discord/api/report/NodeResult;", "", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/discord/api/report/ReportNodeChild;", "destination", "Lcom/discord/api/report/ReportNodeChild;", "a", "()Lcom/discord/api/report/ReportNodeChild;", "Lcom/discord/api/report/NodeElementResult;", "elementResult", "Lcom/discord/api/report/NodeElementResult;", "b", "()Lcom/discord/api/report/NodeElementResult;", "Lcom/discord/api/report/ReportNode;", "node", "Lcom/discord/api/report/ReportNode;", "c", "()Lcom/discord/api/report/ReportNode;", "<init>", "(Lcom/discord/api/report/ReportNode;Lcom/discord/api/report/ReportNodeChild;Lcom/discord/api/report/NodeElementResult;)V", "discord_api"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final /* data */ class NodeResult {
    private final ReportNodeChild destination;
    private final NodeElementResult elementResult;
    private final ReportNode node;

    public NodeResult(ReportNode reportNode, ReportNodeChild reportNodeChild, NodeElementResult nodeElementResult) {
        Intrinsics3.checkNotNullParameter(reportNode, "node");
        this.node = reportNode;
        this.destination = reportNodeChild;
        this.elementResult = nodeElementResult;
    }

    /* renamed from: a, reason: from getter */
    public final ReportNodeChild getDestination() {
        return this.destination;
    }

    /* renamed from: b, reason: from getter */
    public final NodeElementResult getElementResult() {
        return this.elementResult;
    }

    /* renamed from: c, reason: from getter */
    public final ReportNode getNode() {
        return this.node;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof NodeResult)) {
            return false;
        }
        NodeResult nodeResult = (NodeResult) other;
        return Intrinsics3.areEqual(this.node, nodeResult.node) && Intrinsics3.areEqual(this.destination, nodeResult.destination) && Intrinsics3.areEqual(this.elementResult, nodeResult.elementResult);
    }

    public int hashCode() {
        ReportNode reportNode = this.node;
        int iHashCode = (reportNode != null ? reportNode.hashCode() : 0) * 31;
        ReportNodeChild reportNodeChild = this.destination;
        int iHashCode2 = (iHashCode + (reportNodeChild != null ? reportNodeChild.hashCode() : 0)) * 31;
        NodeElementResult nodeElementResult = this.elementResult;
        return iHashCode2 + (nodeElementResult != null ? nodeElementResult.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("NodeResult(node=");
        sbU.append(this.node);
        sbU.append(", destination=");
        sbU.append(this.destination);
        sbU.append(", elementResult=");
        sbU.append(this.elementResult);
        sbU.append(")");
        return sbU.toString();
    }
}
