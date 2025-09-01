package com.discord.api.interaction;

import b.d.b.a.outline;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.Intrinsics3;
import java.util.List;
import kotlin.Metadata;

/* compiled from: Interaction.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010 \n\u0002\u0010\t\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\n\u0010\u000bR\u0019\u0010\f\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u0004R\u0019\u0010\u000f\u001a\u00020\t8\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0019\u0010\u0013\u001a\u00020\t8\u0006@\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0010\u001a\u0004\b\u0014\u0010\u0012R\u001f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\u00158\u0006@\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a¨\u0006\u001b"}, d2 = {"Lcom/discord/api/interaction/Member;", "", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "joinedAt", "Ljava/lang/String;", "getJoinedAt", ModelAuditLogEntry.CHANGE_KEY_MUTE, "Z", "getMute", "()Z", ModelAuditLogEntry.CHANGE_KEY_DEAF, "getDeaf", "", "", "roles", "Ljava/util/List;", "getRoles", "()Ljava/util/List;", "discord_api"}, k = 1, mv = {1, 4, 2})
/* renamed from: com.discord.api.interaction.Member, reason: use source file name */
/* loaded from: classes.dex */
public final /* data */ class Interaction2 {
    private final boolean deaf;
    private final String joinedAt;
    private final boolean mute;
    private final List<Long> roles;

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Interaction2)) {
            return false;
        }
        Interaction2 interaction2 = (Interaction2) other;
        return Intrinsics3.areEqual(this.roles, interaction2.roles) && Intrinsics3.areEqual(this.joinedAt, interaction2.joinedAt) && this.mute == interaction2.mute && this.deaf == interaction2.deaf;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        List<Long> list = this.roles;
        int iHashCode = (list != null ? list.hashCode() : 0) * 31;
        String str = this.joinedAt;
        int iHashCode2 = (iHashCode + (str != null ? str.hashCode() : 0)) * 31;
        boolean z2 = this.mute;
        int i = z2;
        if (z2 != 0) {
            i = 1;
        }
        int i2 = (iHashCode2 + i) * 31;
        boolean z3 = this.deaf;
        return i2 + (z3 ? 1 : z3 ? 1 : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("Member(roles=");
        sbU.append(this.roles);
        sbU.append(", joinedAt=");
        sbU.append(this.joinedAt);
        sbU.append(", mute=");
        sbU.append(this.mute);
        sbU.append(", deaf=");
        return outline.O(sbU, this.deaf, ")");
    }
}
