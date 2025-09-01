package com.discord.models.friendsuggestions;

import b.d.b.a.outline;
import com.discord.models.user.User;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: FriendSuggestion.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J&\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00022\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\f\u0010\u0007J\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013R\u001b\u0010\t\u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\u0014\u001a\u0004\b\u0015\u0010\u0007R\u0019\u0010\b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\u0016\u001a\u0004\b\u0017\u0010\u0004¨\u0006\u001a"}, d2 = {"Lcom/discord/models/friendsuggestions/FriendSuggestion;", "", "Lcom/discord/models/user/User;", "component1", "()Lcom/discord/models/user/User;", "", "component2", "()Ljava/lang/String;", "user", "publicName", "copy", "(Lcom/discord/models/user/User;Ljava/lang/String;)Lcom/discord/models/friendsuggestions/FriendSuggestion;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getPublicName", "Lcom/discord/models/user/User;", "getUser", "<init>", "(Lcom/discord/models/user/User;Ljava/lang/String;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final /* data */ class FriendSuggestion {
    private final String publicName;
    private final User user;

    public FriendSuggestion(User user, String str) {
        Intrinsics3.checkNotNullParameter(user, "user");
        this.user = user;
        this.publicName = str;
    }

    public static /* synthetic */ FriendSuggestion copy$default(FriendSuggestion friendSuggestion, User user, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            user = friendSuggestion.user;
        }
        if ((i & 2) != 0) {
            str = friendSuggestion.publicName;
        }
        return friendSuggestion.copy(user, str);
    }

    /* renamed from: component1, reason: from getter */
    public final User getUser() {
        return this.user;
    }

    /* renamed from: component2, reason: from getter */
    public final String getPublicName() {
        return this.publicName;
    }

    public final FriendSuggestion copy(User user, String publicName) {
        Intrinsics3.checkNotNullParameter(user, "user");
        return new FriendSuggestion(user, publicName);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FriendSuggestion)) {
            return false;
        }
        FriendSuggestion friendSuggestion = (FriendSuggestion) other;
        return Intrinsics3.areEqual(this.user, friendSuggestion.user) && Intrinsics3.areEqual(this.publicName, friendSuggestion.publicName);
    }

    public final String getPublicName() {
        return this.publicName;
    }

    public final User getUser() {
        return this.user;
    }

    public int hashCode() {
        User user = this.user;
        int iHashCode = (user != null ? user.hashCode() : 0) * 31;
        String str = this.publicName;
        return iHashCode + (str != null ? str.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("FriendSuggestion(user=");
        sbU.append(this.user);
        sbU.append(", publicName=");
        return outline.J(sbU, this.publicName, ")");
    }
}
