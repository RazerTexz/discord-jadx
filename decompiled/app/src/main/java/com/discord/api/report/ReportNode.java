package com.discord.api.report;

import b.d.b.a.outline;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.Intrinsics3;
import java.util.List;
import kotlin.Metadata;

/* compiled from: InAppReportsMenu.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\n\u0010\u000bR\u001f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\f8\u0006@\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001b\u0010\u0013\u001a\u0004\u0018\u00010\u00128\u0006@\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u001d\u0010\u0018\u001a\u00060\u0005j\u0002`\u00178\u0006@\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u0007R\u001b\u0010\u001b\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u0004R\u001b\u0010\u001e\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u001e\u0010\u001c\u001a\u0004\b\u001f\u0010\u0004R\u001f\u0010!\u001a\b\u0012\u0004\u0012\u00020 0\f8\u0006@\u0006¢\u0006\f\n\u0004\b!\u0010\u000f\u001a\u0004\b\"\u0010\u0011R\u001b\u0010#\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b#\u0010\u001c\u001a\u0004\b$\u0010\u0004R\u001b\u0010%\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b%\u0010\u001c\u001a\u0004\b&\u0010\u0004R\u0019\u0010'\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b'\u0010\u001c\u001a\u0004\b(\u0010\u0004¨\u0006)"}, d2 = {"Lcom/discord/api/report/ReportNode;", "", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "Lcom/discord/api/report/ReportNodeElement;", "elements", "Ljava/util/List;", "c", "()Ljava/util/List;", "Lcom/discord/api/report/ReportNodeBottomButton;", "button", "Lcom/discord/api/report/ReportNodeBottomButton;", "a", "()Lcom/discord/api/report/ReportNodeBottomButton;", "Lcom/discord/api/report/ReportNodeRef;", ModelAuditLogEntry.CHANGE_KEY_ID, "I", "e", "subheader", "Ljava/lang/String;", "g", "info", "f", "Lcom/discord/api/report/ReportNodeChild;", "children", "b", ModelAuditLogEntry.CHANGE_KEY_DESCRIPTION, "getDescription", "menu_name", "getMenu_name", "header", "d", "discord_api"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final /* data */ class ReportNode {
    private final ReportNodeBottomButton button;
    private final List<ReportNodeChild> children;
    private final String description;
    private final List<ReportNodeElement> elements;
    private final String header;
    private final int id;
    private final String info;
    private final String menu_name;
    private final String subheader;

    /* renamed from: a, reason: from getter */
    public final ReportNodeBottomButton getButton() {
        return this.button;
    }

    public final List<ReportNodeChild> b() {
        return this.children;
    }

    public final List<ReportNodeElement> c() {
        return this.elements;
    }

    /* renamed from: d, reason: from getter */
    public final String getHeader() {
        return this.header;
    }

    /* renamed from: e, reason: from getter */
    public final int getId() {
        return this.id;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ReportNode)) {
            return false;
        }
        ReportNode reportNode = (ReportNode) other;
        return this.id == reportNode.id && Intrinsics3.areEqual(this.menu_name, reportNode.menu_name) && Intrinsics3.areEqual(this.header, reportNode.header) && Intrinsics3.areEqual(this.subheader, reportNode.subheader) && Intrinsics3.areEqual(this.info, reportNode.info) && Intrinsics3.areEqual(this.description, reportNode.description) && Intrinsics3.areEqual(this.children, reportNode.children) && Intrinsics3.areEqual(this.elements, reportNode.elements) && Intrinsics3.areEqual(this.button, reportNode.button);
    }

    /* renamed from: f, reason: from getter */
    public final String getInfo() {
        return this.info;
    }

    /* renamed from: g, reason: from getter */
    public final String getSubheader() {
        return this.subheader;
    }

    public int hashCode() {
        int i = this.id * 31;
        String str = this.menu_name;
        int iHashCode = (i + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.header;
        int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.subheader;
        int iHashCode3 = (iHashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.info;
        int iHashCode4 = (iHashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.description;
        int iHashCode5 = (iHashCode4 + (str5 != null ? str5.hashCode() : 0)) * 31;
        List<ReportNodeChild> list = this.children;
        int iHashCode6 = (iHashCode5 + (list != null ? list.hashCode() : 0)) * 31;
        List<ReportNodeElement> list2 = this.elements;
        int iHashCode7 = (iHashCode6 + (list2 != null ? list2.hashCode() : 0)) * 31;
        ReportNodeBottomButton reportNodeBottomButton = this.button;
        return iHashCode7 + (reportNodeBottomButton != null ? reportNodeBottomButton.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("ReportNode(id=");
        sbU.append(this.id);
        sbU.append(", menu_name=");
        sbU.append(this.menu_name);
        sbU.append(", header=");
        sbU.append(this.header);
        sbU.append(", subheader=");
        sbU.append(this.subheader);
        sbU.append(", info=");
        sbU.append(this.info);
        sbU.append(", description=");
        sbU.append(this.description);
        sbU.append(", children=");
        sbU.append(this.children);
        sbU.append(", elements=");
        sbU.append(this.elements);
        sbU.append(", button=");
        sbU.append(this.button);
        sbU.append(")");
        return sbU.toString();
    }
}
