package com.discord.widgets.stage;

import b.d.b.a.outline;
import com.discord.models.member.GuildMember;
import com.discord.models.user.User;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: StageCardSpeaker.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J&\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00022\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015R\u001b\u0010\t\u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\u0016\u001a\u0004\b\u0017\u0010\u0007R\u0019\u0010\b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\u0018\u001a\u0004\b\u0019\u0010\u0004R\u0019\u0010\u001a\u001a\u00020\f8\u0006@\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u000e¨\u0006\u001f"}, d2 = {"Lcom/discord/widgets/stage/StageCardSpeaker;", "", "Lcom/discord/models/user/User;", "component1", "()Lcom/discord/models/user/User;", "Lcom/discord/models/member/GuildMember;", "component2", "()Lcom/discord/models/member/GuildMember;", "user", "guildMember", "copy", "(Lcom/discord/models/user/User;Lcom/discord/models/member/GuildMember;)Lcom/discord/widgets/stage/StageCardSpeaker;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/discord/models/member/GuildMember;", "getGuildMember", "Lcom/discord/models/user/User;", "getUser", "displayName", "Ljava/lang/String;", "getDisplayName", "<init>", "(Lcom/discord/models/user/User;Lcom/discord/models/member/GuildMember;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final /* data */ class StageCardSpeaker {
    private final String displayName;
    private final GuildMember guildMember;
    private final User user;

    public StageCardSpeaker(User user, GuildMember guildMember) {
        String nick;
        Intrinsics3.checkNotNullParameter(user, "user");
        this.user = user;
        this.guildMember = guildMember;
        this.displayName = (guildMember == null || (nick = guildMember.getNick()) == null) ? user.getUsername() : nick;
    }

    public static /* synthetic */ StageCardSpeaker copy$default(StageCardSpeaker stageCardSpeaker, User user, GuildMember guildMember, int i, Object obj) {
        if ((i & 1) != 0) {
            user = stageCardSpeaker.user;
        }
        if ((i & 2) != 0) {
            guildMember = stageCardSpeaker.guildMember;
        }
        return stageCardSpeaker.copy(user, guildMember);
    }

    /* renamed from: component1, reason: from getter */
    public final User getUser() {
        return this.user;
    }

    /* renamed from: component2, reason: from getter */
    public final GuildMember getGuildMember() {
        return this.guildMember;
    }

    public final StageCardSpeaker copy(User user, GuildMember guildMember) {
        Intrinsics3.checkNotNullParameter(user, "user");
        return new StageCardSpeaker(user, guildMember);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof StageCardSpeaker)) {
            return false;
        }
        StageCardSpeaker stageCardSpeaker = (StageCardSpeaker) other;
        return Intrinsics3.areEqual(this.user, stageCardSpeaker.user) && Intrinsics3.areEqual(this.guildMember, stageCardSpeaker.guildMember);
    }

    public final String getDisplayName() {
        return this.displayName;
    }

    public final GuildMember getGuildMember() {
        return this.guildMember;
    }

    public final User getUser() {
        return this.user;
    }

    public int hashCode() {
        User user = this.user;
        int iHashCode = (user != null ? user.hashCode() : 0) * 31;
        GuildMember guildMember = this.guildMember;
        return iHashCode + (guildMember != null ? guildMember.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("StageCardSpeaker(user=");
        sbU.append(this.user);
        sbU.append(", guildMember=");
        sbU.append(this.guildMember);
        sbU.append(")");
        return sbU.toString();
    }
}
