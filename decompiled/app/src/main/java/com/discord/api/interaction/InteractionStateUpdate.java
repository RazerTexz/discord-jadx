package com.discord.api.interaction;

import b.d.b.a.outline;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: InteractionStateUpdate.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f\u0012\u0006\u0010\f\u001a\u00020\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\n\u0010\u000bR\u0019\u0010\f\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u0004R\u001b\u0010\u0010\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0016"}, d2 = {"Lcom/discord/api/interaction/InteractionStateUpdate;", "", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "nonce", "Ljava/lang/String;", "b", "", ModelAuditLogEntry.CHANGE_KEY_ID, "Ljava/lang/Long;", "a", "()Ljava/lang/Long;", "<init>", "(Ljava/lang/Long;Ljava/lang/String;)V", "discord_api"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final /* data */ class InteractionStateUpdate {
    private final Long id;
    private final String nonce;

    public InteractionStateUpdate(Long l, String str) {
        Intrinsics3.checkNotNullParameter(str, "nonce");
        this.id = l;
        this.nonce = str;
    }

    /* renamed from: a, reason: from getter */
    public final Long getId() {
        return this.id;
    }

    /* renamed from: b, reason: from getter */
    public final String getNonce() {
        return this.nonce;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof InteractionStateUpdate)) {
            return false;
        }
        InteractionStateUpdate interactionStateUpdate = (InteractionStateUpdate) other;
        return Intrinsics3.areEqual(this.id, interactionStateUpdate.id) && Intrinsics3.areEqual(this.nonce, interactionStateUpdate.nonce);
    }

    public int hashCode() {
        Long l = this.id;
        int iHashCode = (l != null ? l.hashCode() : 0) * 31;
        String str = this.nonce;
        return iHashCode + (str != null ? str.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("InteractionStateUpdate(id=");
        sbU.append(this.id);
        sbU.append(", nonce=");
        return outline.J(sbU, this.nonce, ")");
    }
}
