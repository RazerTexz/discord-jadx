package com.discord.api.creatormonetization;

import b.d.b.a.outline;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: CreatorMonetizationEnableRequest.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001:\u0001\u0017J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\n\u0010\u000bR\u001d\u0010\u000e\u001a\u00060\fj\u0002`\r8\u0006@\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0019\u0010\u0013\u001a\u00020\u00128\u0006@\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u0018"}, d2 = {"Lcom/discord/api/creatormonetization/CreatorMonetizationEnableRequest;", "", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "Lcom/discord/primitives/Snowflake;", ModelAuditLogEntry.CHANGE_KEY_ID, "J", "a", "()J", "Lcom/discord/api/creatormonetization/CreatorMonetizationEnableRequest$State;", "state", "Lcom/discord/api/creatormonetization/CreatorMonetizationEnableRequest$State;", "b", "()Lcom/discord/api/creatormonetization/CreatorMonetizationEnableRequest$State;", "State", "discord_api"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final /* data */ class CreatorMonetizationEnableRequest {
    private final long id;
    private final State state;

    /* compiled from: CreatorMonetizationEnableRequest.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/discord/api/creatormonetization/CreatorMonetizationEnableRequest$State;", "", "<init>", "(Ljava/lang/String;I)V", "OPEN", "REJECTED", "APPROVED", "discord_api"}, k = 1, mv = {1, 4, 2})
    public enum State {
        OPEN,
        REJECTED,
        APPROVED
    }

    /* renamed from: a, reason: from getter */
    public final long getId() {
        return this.id;
    }

    /* renamed from: b, reason: from getter */
    public final State getState() {
        return this.state;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CreatorMonetizationEnableRequest)) {
            return false;
        }
        CreatorMonetizationEnableRequest creatorMonetizationEnableRequest = (CreatorMonetizationEnableRequest) other;
        return this.id == creatorMonetizationEnableRequest.id && Intrinsics3.areEqual(this.state, creatorMonetizationEnableRequest.state);
    }

    public int hashCode() {
        long j = this.id;
        int i = ((int) (j ^ (j >>> 32))) * 31;
        State state = this.state;
        return i + (state != null ? state.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("CreatorMonetizationEnableRequest(id=");
        sbU.append(this.id);
        sbU.append(", state=");
        sbU.append(this.state);
        sbU.append(")");
        return sbU.toString();
    }
}
