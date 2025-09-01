package com.discord.api.friendsuggestions;

import b.d.b.a.outline;
import com.discord.api.user.User;
import d0.z.d.Intrinsics3;
import java.util.List;
import kotlin.Metadata;

/* compiled from: FriendSuggestion.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\n\u0010\u000bR\u001f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\f8\u0006@\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0019\u0010\u0013\u001a\u00020\u00128\u0006@\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"Lcom/discord/api/friendsuggestions/FriendSuggestion;", "", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "Lcom/discord/api/friendsuggestions/FriendSuggestionReason;", "reasons", "Ljava/util/List;", "a", "()Ljava/util/List;", "Lcom/discord/api/user/User;", "suggestedUser", "Lcom/discord/api/user/User;", "b", "()Lcom/discord/api/user/User;", "discord_api"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final /* data */ class FriendSuggestion {
    private final List<FriendSuggestionReason> reasons;
    private final User suggestedUser;

    public final List<FriendSuggestionReason> a() {
        return this.reasons;
    }

    /* renamed from: b, reason: from getter */
    public final User getSuggestedUser() {
        return this.suggestedUser;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FriendSuggestion)) {
            return false;
        }
        FriendSuggestion friendSuggestion = (FriendSuggestion) other;
        return Intrinsics3.areEqual(this.suggestedUser, friendSuggestion.suggestedUser) && Intrinsics3.areEqual(this.reasons, friendSuggestion.reasons);
    }

    public int hashCode() {
        User user = this.suggestedUser;
        int iHashCode = (user != null ? user.hashCode() : 0) * 31;
        List<FriendSuggestionReason> list = this.reasons;
        return iHashCode + (list != null ? list.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("FriendSuggestion(suggestedUser=");
        sbU.append(this.suggestedUser);
        sbU.append(", reasons=");
        return outline.L(sbU, this.reasons, ")");
    }
}
