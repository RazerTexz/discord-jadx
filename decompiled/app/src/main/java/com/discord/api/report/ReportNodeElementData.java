package com.discord.api.report;

import b.d.b.a.outline;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: InAppReportsMenu.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u000f\u001a\u00020\u0002\u0012\u0006\u0010\f\u001a\u00020\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\n\u0010\u000bR\u0019\u0010\f\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u0004R\u0019\u0010\u000f\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010\r\u001a\u0004\b\u0010\u0010\u0004¨\u0006\u0013"}, d2 = {"Lcom/discord/api/report/ReportNodeElementData;", "", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "elementValue", "Ljava/lang/String;", "b", "elementKey", "a", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "discord_api"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final /* data */ class ReportNodeElementData {
    private final String elementKey;
    private final String elementValue;

    public ReportNodeElementData(String str, String str2) {
        Intrinsics3.checkNotNullParameter(str, "elementKey");
        Intrinsics3.checkNotNullParameter(str2, "elementValue");
        this.elementKey = str;
        this.elementValue = str2;
    }

    /* renamed from: a, reason: from getter */
    public final String getElementKey() {
        return this.elementKey;
    }

    /* renamed from: b, reason: from getter */
    public final String getElementValue() {
        return this.elementValue;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ReportNodeElementData)) {
            return false;
        }
        ReportNodeElementData reportNodeElementData = (ReportNodeElementData) other;
        return Intrinsics3.areEqual(this.elementKey, reportNodeElementData.elementKey) && Intrinsics3.areEqual(this.elementValue, reportNodeElementData.elementValue);
    }

    public int hashCode() {
        String str = this.elementKey;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.elementValue;
        return iHashCode + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("ReportNodeElementData(elementKey=");
        sbU.append(this.elementKey);
        sbU.append(", elementValue=");
        return outline.J(sbU, this.elementValue, ")");
    }
}
