package com.discord.widgets.servers.member_verification.form_fields;

import b.d.b.a.outline;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: MemberVerificationItemParagraph.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\r\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J&\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00022\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\f\u0010\u0007J\u0010\u0010\r\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\r\u0010\u0004J\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u0019\u0010\b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\u0013\u001a\u0004\b\u0014\u0010\u0004R\u001c\u0010\u0015\u001a\u00020\u00058\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0007R\u001c\u0010\u0018\u001a\u00020\u00028\u0016@\u0016X\u0096D¢\u0006\f\n\u0004\b\u0018\u0010\u0013\u001a\u0004\b\u0019\u0010\u0004R\u001b\u0010\t\u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\u0016\u001a\u0004\b\u001a\u0010\u0007¨\u0006\u001d"}, d2 = {"Lcom/discord/widgets/servers/member_verification/form_fields/MemberVerificationItemParagraph;", "Lcom/discord/widgets/servers/member_verification/form_fields/MemberVerificationItem;", "", "component1", "()I", "", "component2", "()Ljava/lang/String;", "fieldIndex", "response", "copy", "(ILjava/lang/String;)Lcom/discord/widgets/servers/member_verification/form_fields/MemberVerificationItemParagraph;", "toString", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "I", "getFieldIndex", "key", "Ljava/lang/String;", "getKey", "type", "getType", "getResponse", "<init>", "(ILjava/lang/String;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final /* data */ class MemberVerificationItemParagraph implements MemberVerificationItem {
    private final int fieldIndex;
    private final String key;
    private final String response;
    private final int type = 5;

    public MemberVerificationItemParagraph(int i, String str) {
        this.fieldIndex = i;
        this.response = str;
        StringBuilder sb = new StringBuilder();
        sb.append(i);
        sb.append(getType());
        this.key = sb.toString();
    }

    public static /* synthetic */ MemberVerificationItemParagraph copy$default(MemberVerificationItemParagraph memberVerificationItemParagraph, int i, String str, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = memberVerificationItemParagraph.fieldIndex;
        }
        if ((i2 & 2) != 0) {
            str = memberVerificationItemParagraph.response;
        }
        return memberVerificationItemParagraph.copy(i, str);
    }

    /* renamed from: component1, reason: from getter */
    public final int getFieldIndex() {
        return this.fieldIndex;
    }

    /* renamed from: component2, reason: from getter */
    public final String getResponse() {
        return this.response;
    }

    public final MemberVerificationItemParagraph copy(int fieldIndex, String response) {
        return new MemberVerificationItemParagraph(fieldIndex, response);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MemberVerificationItemParagraph)) {
            return false;
        }
        MemberVerificationItemParagraph memberVerificationItemParagraph = (MemberVerificationItemParagraph) other;
        return this.fieldIndex == memberVerificationItemParagraph.fieldIndex && Intrinsics3.areEqual(this.response, memberVerificationItemParagraph.response);
    }

    public final int getFieldIndex() {
        return this.fieldIndex;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
    public String getKey() {
        return this.key;
    }

    public final String getResponse() {
        return this.response;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload
    public int getType() {
        return this.type;
    }

    public int hashCode() {
        int i = this.fieldIndex * 31;
        String str = this.response;
        return i + (str != null ? str.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("MemberVerificationItemParagraph(fieldIndex=");
        sbU.append(this.fieldIndex);
        sbU.append(", response=");
        return outline.J(sbU, this.response, ")");
    }
}
