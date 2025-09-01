package com.discord.api.message.call;

import b.d.b.a.outline;
import com.discord.api.utcdatetime.UtcDateTime;
import d0.z.d.Intrinsics3;
import java.util.List;
import kotlin.Metadata;

/* compiled from: MessageCall.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0010\t\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\n\u0010\u000bR\u001b\u0010\r\u001a\u0004\u0018\u00010\f8\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u00118\u0006@\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"Lcom/discord/api/message/call/MessageCall;", "", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/discord/api/utcdatetime/UtcDateTime;", "endedTimestamp", "Lcom/discord/api/utcdatetime/UtcDateTime;", "a", "()Lcom/discord/api/utcdatetime/UtcDateTime;", "", "", "participants", "Ljava/util/List;", "b", "()Ljava/util/List;", "discord_api"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final /* data */ class MessageCall {
    private final UtcDateTime endedTimestamp;
    private final List<Long> participants;

    /* renamed from: a, reason: from getter */
    public final UtcDateTime getEndedTimestamp() {
        return this.endedTimestamp;
    }

    public final List<Long> b() {
        return this.participants;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MessageCall)) {
            return false;
        }
        MessageCall messageCall = (MessageCall) other;
        return Intrinsics3.areEqual(this.participants, messageCall.participants) && Intrinsics3.areEqual(this.endedTimestamp, messageCall.endedTimestamp);
    }

    public int hashCode() {
        List<Long> list = this.participants;
        int iHashCode = (list != null ? list.hashCode() : 0) * 31;
        UtcDateTime utcDateTime = this.endedTimestamp;
        return iHashCode + (utcDateTime != null ? utcDateTime.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("MessageCall(participants=");
        sbU.append(this.participants);
        sbU.append(", endedTimestamp=");
        sbU.append(this.endedTimestamp);
        sbU.append(")");
        return sbU.toString();
    }
}
