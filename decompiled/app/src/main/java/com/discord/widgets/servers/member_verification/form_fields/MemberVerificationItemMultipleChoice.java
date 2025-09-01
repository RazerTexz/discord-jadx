package com.discord.widgets.servers.member_verification.form_fields;

import b.d.b.a.outline;
import d0.z.d.Intrinsics3;
import java.util.List;
import kotlin.Metadata;

/* compiled from: MemberVerificationItemMultipleChoice.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0010\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b#\u0010$J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0012\u0010\t\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\t\u0010\nJ6\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u000b\u001a\u00020\u00022\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0004J\u001a\u0010\u0016\u001a\u00020\u00152\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013HÖ\u0003¢\u0006\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0018\u001a\u00020\u00068\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u0011R\u001c\u0010\u001b\u001a\u00020\u00028\u0016@\u0016X\u0096D¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u0004R\u0019\u0010\u000b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u001c\u001a\u0004\b\u001e\u0010\u0004R\u001b\u0010\r\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\u001f\u001a\u0004\b \u0010\nR\u001f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010!\u001a\u0004\b\"\u0010\b¨\u0006%"}, d2 = {"Lcom/discord/widgets/servers/member_verification/form_fields/MemberVerificationItemMultipleChoice;", "Lcom/discord/widgets/servers/member_verification/form_fields/MemberVerificationItem;", "", "component1", "()I", "", "", "component2", "()Ljava/util/List;", "component3", "()Ljava/lang/Integer;", "fieldIndex", "choices", "response", "copy", "(ILjava/util/List;Ljava/lang/Integer;)Lcom/discord/widgets/servers/member_verification/form_fields/MemberVerificationItemMultipleChoice;", "toString", "()Ljava/lang/String;", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "key", "Ljava/lang/String;", "getKey", "type", "I", "getType", "getFieldIndex", "Ljava/lang/Integer;", "getResponse", "Ljava/util/List;", "getChoices", "<init>", "(ILjava/util/List;Ljava/lang/Integer;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final /* data */ class MemberVerificationItemMultipleChoice implements MemberVerificationItem {
    private final List<String> choices;
    private final int fieldIndex;
    private final String key;
    private final Integer response;
    private final int type;

    public MemberVerificationItemMultipleChoice(int i, List<String> list, Integer num) {
        Intrinsics3.checkNotNullParameter(list, "choices");
        this.fieldIndex = i;
        this.choices = list;
        this.response = num;
        this.type = 6;
        StringBuilder sb = new StringBuilder();
        sb.append(i);
        sb.append(getType());
        this.key = sb.toString();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ MemberVerificationItemMultipleChoice copy$default(MemberVerificationItemMultipleChoice memberVerificationItemMultipleChoice, int i, List list, Integer num, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = memberVerificationItemMultipleChoice.fieldIndex;
        }
        if ((i2 & 2) != 0) {
            list = memberVerificationItemMultipleChoice.choices;
        }
        if ((i2 & 4) != 0) {
            num = memberVerificationItemMultipleChoice.response;
        }
        return memberVerificationItemMultipleChoice.copy(i, list, num);
    }

    /* renamed from: component1, reason: from getter */
    public final int getFieldIndex() {
        return this.fieldIndex;
    }

    public final List<String> component2() {
        return this.choices;
    }

    /* renamed from: component3, reason: from getter */
    public final Integer getResponse() {
        return this.response;
    }

    public final MemberVerificationItemMultipleChoice copy(int fieldIndex, List<String> choices, Integer response) {
        Intrinsics3.checkNotNullParameter(choices, "choices");
        return new MemberVerificationItemMultipleChoice(fieldIndex, choices, response);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MemberVerificationItemMultipleChoice)) {
            return false;
        }
        MemberVerificationItemMultipleChoice memberVerificationItemMultipleChoice = (MemberVerificationItemMultipleChoice) other;
        return this.fieldIndex == memberVerificationItemMultipleChoice.fieldIndex && Intrinsics3.areEqual(this.choices, memberVerificationItemMultipleChoice.choices) && Intrinsics3.areEqual(this.response, memberVerificationItemMultipleChoice.response);
    }

    public final List<String> getChoices() {
        return this.choices;
    }

    public final int getFieldIndex() {
        return this.fieldIndex;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
    public String getKey() {
        return this.key;
    }

    public final Integer getResponse() {
        return this.response;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload
    public int getType() {
        return this.type;
    }

    public int hashCode() {
        int i = this.fieldIndex * 31;
        List<String> list = this.choices;
        int iHashCode = (i + (list != null ? list.hashCode() : 0)) * 31;
        Integer num = this.response;
        return iHashCode + (num != null ? num.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("MemberVerificationItemMultipleChoice(fieldIndex=");
        sbU.append(this.fieldIndex);
        sbU.append(", choices=");
        sbU.append(this.choices);
        sbU.append(", response=");
        return outline.F(sbU, this.response, ")");
    }
}
