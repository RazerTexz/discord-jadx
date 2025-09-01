package com.discord.api.message.activity;

import b.d.b.a.outline;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: MessageActivity.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\r\u001a\u00020\f\u0012\u0006\u0010\u0011\u001a\u00020\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\n\u0010\u000bR\u0019\u0010\r\u001a\u00020\f8\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u0019\u0010\u0011\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0004¨\u0006\u0016"}, d2 = {"Lcom/discord/api/message/activity/MessageActivity;", "", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/discord/api/message/activity/MessageActivityType;", "type", "Lcom/discord/api/message/activity/MessageActivityType;", "b", "()Lcom/discord/api/message/activity/MessageActivityType;", "partyId", "Ljava/lang/String;", "a", "<init>", "(Lcom/discord/api/message/activity/MessageActivityType;Ljava/lang/String;)V", "discord_api"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final /* data */ class MessageActivity {
    private final String partyId;
    private final MessageActivityType type;

    public MessageActivity(MessageActivityType messageActivityType, String str) {
        Intrinsics3.checkNotNullParameter(messageActivityType, "type");
        Intrinsics3.checkNotNullParameter(str, "partyId");
        this.type = messageActivityType;
        this.partyId = str;
    }

    /* renamed from: a, reason: from getter */
    public final String getPartyId() {
        return this.partyId;
    }

    /* renamed from: b, reason: from getter */
    public final MessageActivityType getType() {
        return this.type;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MessageActivity)) {
            return false;
        }
        MessageActivity messageActivity = (MessageActivity) other;
        return Intrinsics3.areEqual(this.type, messageActivity.type) && Intrinsics3.areEqual(this.partyId, messageActivity.partyId);
    }

    public int hashCode() {
        MessageActivityType messageActivityType = this.type;
        int iHashCode = (messageActivityType != null ? messageActivityType.hashCode() : 0) * 31;
        String str = this.partyId;
        return iHashCode + (str != null ? str.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("MessageActivity(type=");
        sbU.append(this.type);
        sbU.append(", partyId=");
        return outline.J(sbU, this.partyId, ")");
    }
}
