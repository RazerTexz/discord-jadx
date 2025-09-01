package com.discord.api.friendsuggestions;

import b.d.b.a.outline;
import kotlin.Metadata;

/* compiled from: FriendSuggestionDelete.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\n\u0010\u000bR\u0019\u0010\r\u001a\u00020\f8\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/discord/api/friendsuggestions/FriendSuggestionDelete;", "", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "suggestedUserId", "J", "a", "()J", "discord_api"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final /* data */ class FriendSuggestionDelete {
    private final long suggestedUserId;

    /* renamed from: a, reason: from getter */
    public final long getSuggestedUserId() {
        return this.suggestedUserId;
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof FriendSuggestionDelete) && this.suggestedUserId == ((FriendSuggestionDelete) other).suggestedUserId;
        }
        return true;
    }

    public int hashCode() {
        long j = this.suggestedUserId;
        return (int) (j ^ (j >>> 32));
    }

    public String toString() {
        return outline.C(outline.U("FriendSuggestionDelete(suggestedUserId="), this.suggestedUserId, ")");
    }
}
