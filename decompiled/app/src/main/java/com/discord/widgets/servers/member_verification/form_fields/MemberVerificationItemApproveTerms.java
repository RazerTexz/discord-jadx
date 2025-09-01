package com.discord.widgets.servers.member_verification.form_fields;

import b.d.b.a.outline;
import kotlin.Metadata;

/* compiled from: MemberVerificationItemApproveTerms.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u000e\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J$\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0004J\u001a\u0010\u0012\u001a\u00020\u00052\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010HÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013R\u0019\u0010\b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\u0014\u001a\u0004\b\u0015\u0010\u0004R\u0019\u0010\t\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\u0016\u001a\u0004\b\t\u0010\u0007R\u001c\u0010\u0017\u001a\u00020\u00028\u0016@\u0016X\u0096D¢\u0006\f\n\u0004\b\u0017\u0010\u0014\u001a\u0004\b\u0018\u0010\u0004R\u001c\u0010\u0019\u001a\u00020\f8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u000e¨\u0006\u001e"}, d2 = {"Lcom/discord/widgets/servers/member_verification/form_fields/MemberVerificationItemApproveTerms;", "Lcom/discord/widgets/servers/member_verification/form_fields/MemberVerificationItem;", "", "component1", "()I", "", "component2", "()Z", "fieldIndex", "isApproved", "copy", "(IZ)Lcom/discord/widgets/servers/member_verification/form_fields/MemberVerificationItemApproveTerms;", "", "toString", "()Ljava/lang/String;", "hashCode", "", "other", "equals", "(Ljava/lang/Object;)Z", "I", "getFieldIndex", "Z", "type", "getType", "key", "Ljava/lang/String;", "getKey", "<init>", "(IZ)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final /* data */ class MemberVerificationItemApproveTerms implements MemberVerificationItem {
    private final int fieldIndex;
    private final boolean isApproved;
    private final int type = 2;
    private final String key = String.valueOf(getType());

    public MemberVerificationItemApproveTerms(int i, boolean z2) {
        this.fieldIndex = i;
        this.isApproved = z2;
    }

    public static /* synthetic */ MemberVerificationItemApproveTerms copy$default(MemberVerificationItemApproveTerms memberVerificationItemApproveTerms, int i, boolean z2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = memberVerificationItemApproveTerms.fieldIndex;
        }
        if ((i2 & 2) != 0) {
            z2 = memberVerificationItemApproveTerms.isApproved;
        }
        return memberVerificationItemApproveTerms.copy(i, z2);
    }

    /* renamed from: component1, reason: from getter */
    public final int getFieldIndex() {
        return this.fieldIndex;
    }

    /* renamed from: component2, reason: from getter */
    public final boolean getIsApproved() {
        return this.isApproved;
    }

    public final MemberVerificationItemApproveTerms copy(int fieldIndex, boolean isApproved) {
        return new MemberVerificationItemApproveTerms(fieldIndex, isApproved);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MemberVerificationItemApproveTerms)) {
            return false;
        }
        MemberVerificationItemApproveTerms memberVerificationItemApproveTerms = (MemberVerificationItemApproveTerms) other;
        return this.fieldIndex == memberVerificationItemApproveTerms.fieldIndex && this.isApproved == memberVerificationItemApproveTerms.isApproved;
    }

    public final int getFieldIndex() {
        return this.fieldIndex;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
    public String getKey() {
        return this.key;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload
    public int getType() {
        return this.type;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int i = this.fieldIndex * 31;
        boolean z2 = this.isApproved;
        int i2 = z2;
        if (z2 != 0) {
            i2 = 1;
        }
        return i + i2;
    }

    public final boolean isApproved() {
        return this.isApproved;
    }

    public String toString() {
        StringBuilder sbU = outline.U("MemberVerificationItemApproveTerms(fieldIndex=");
        sbU.append(this.fieldIndex);
        sbU.append(", isApproved=");
        return outline.O(sbU, this.isApproved, ")");
    }
}
