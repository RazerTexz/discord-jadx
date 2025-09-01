package com.discord.widgets.guildscheduledevent;

import a0.a.a.b;
import b.d.b.a.outline;
import com.discord.api.guildscheduledevent.ApiGuildScheduledEventUser;
import com.discord.models.member.GuildMember;
import com.discord.models.user.CoreUser;
import com.discord.models.user.User;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: GuildScheduledEventUser.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\f\b\u0086\b\u0018\u0000 #2\u00020\u0001:\u0001#B#\u0012\u0006\u0010\f\u001a\u00020\u0002\u0012\u0006\u0010\r\u001a\u00020\u0005\u0012\n\u0010\u000e\u001a\u00060\bj\u0002`\t¢\u0006\u0004\b!\u0010\"J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0014\u0010\n\u001a\u00060\bj\u0002`\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ2\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\f\u001a\u00020\u00022\b\b\u0002\u0010\r\u001a\u00020\u00052\f\b\u0002\u0010\u000e\u001a\u00060\bj\u0002`\tHÆ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0012\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0015\u001a\u00020\u0014HÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u001a\u0010\u0019\u001a\u00020\u00182\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0019\u0010\u001aR\u0019\u0010\r\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\u001b\u001a\u0004\b\u001c\u0010\u0007R\u001d\u0010\u000e\u001a\u00060\bj\u0002`\t8\u0006@\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u001d\u001a\u0004\b\u001e\u0010\u000bR\u0019\u0010\f\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\u001f\u001a\u0004\b \u0010\u0004¨\u0006$"}, d2 = {"Lcom/discord/widgets/guildscheduledevent/GuildScheduledEventUser;", "", "Lcom/discord/models/user/User;", "component1", "()Lcom/discord/models/user/User;", "Lcom/discord/models/member/GuildMember;", "component2", "()Lcom/discord/models/member/GuildMember;", "", "Lcom/discord/primitives/GuildScheduledEventId;", "component3", "()J", "user", "guildMember", "guildScheduledEventId", "copy", "(Lcom/discord/models/user/User;Lcom/discord/models/member/GuildMember;J)Lcom/discord/widgets/guildscheduledevent/GuildScheduledEventUser;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/discord/models/member/GuildMember;", "getGuildMember", "J", "getGuildScheduledEventId", "Lcom/discord/models/user/User;", "getUser", "<init>", "(Lcom/discord/models/user/User;Lcom/discord/models/member/GuildMember;J)V", "Companion", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final /* data */ class GuildScheduledEventUser {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final GuildMember guildMember;
    private final long guildScheduledEventId;
    private final User user;

    /* compiled from: GuildScheduledEventUser.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\n\u0010\u000bJ#\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0003\u001a\u00020\u00022\n\u0010\u0006\u001a\u00060\u0004j\u0002`\u0005¢\u0006\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lcom/discord/widgets/guildscheduledevent/GuildScheduledEventUser$Companion;", "", "Lcom/discord/api/guildscheduledevent/ApiGuildScheduledEventUser;", "apiGuildScheduledEventUser", "", "Lcom/discord/primitives/GuildId;", "guildId", "Lcom/discord/widgets/guildscheduledevent/GuildScheduledEventUser;", "from", "(Lcom/discord/api/guildscheduledevent/ApiGuildScheduledEventUser;J)Lcom/discord/widgets/guildscheduledevent/GuildScheduledEventUser;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public final GuildScheduledEventUser from(ApiGuildScheduledEventUser apiGuildScheduledEventUser, long guildId) {
            Intrinsics3.checkNotNullParameter(apiGuildScheduledEventUser, "apiGuildScheduledEventUser");
            com.discord.api.user.User userC = apiGuildScheduledEventUser.getUser();
            com.discord.api.guildmember.GuildMember guildMemberA = apiGuildScheduledEventUser.a(guildId);
            if (userC == null || guildMemberA == null) {
                return null;
            }
            return new GuildScheduledEventUser(new CoreUser(userC), GuildMember.Companion.from$default(GuildMember.INSTANCE, guildMemberA, guildId, null, null, 12, null), apiGuildScheduledEventUser.getGuildScheduledEventId());
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public GuildScheduledEventUser(User user, GuildMember guildMember, long j) {
        Intrinsics3.checkNotNullParameter(user, "user");
        Intrinsics3.checkNotNullParameter(guildMember, "guildMember");
        this.user = user;
        this.guildMember = guildMember;
        this.guildScheduledEventId = j;
    }

    public static /* synthetic */ GuildScheduledEventUser copy$default(GuildScheduledEventUser guildScheduledEventUser, User user, GuildMember guildMember, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            user = guildScheduledEventUser.user;
        }
        if ((i & 2) != 0) {
            guildMember = guildScheduledEventUser.guildMember;
        }
        if ((i & 4) != 0) {
            j = guildScheduledEventUser.guildScheduledEventId;
        }
        return guildScheduledEventUser.copy(user, guildMember, j);
    }

    /* renamed from: component1, reason: from getter */
    public final User getUser() {
        return this.user;
    }

    /* renamed from: component2, reason: from getter */
    public final GuildMember getGuildMember() {
        return this.guildMember;
    }

    /* renamed from: component3, reason: from getter */
    public final long getGuildScheduledEventId() {
        return this.guildScheduledEventId;
    }

    public final GuildScheduledEventUser copy(User user, GuildMember guildMember, long guildScheduledEventId) {
        Intrinsics3.checkNotNullParameter(user, "user");
        Intrinsics3.checkNotNullParameter(guildMember, "guildMember");
        return new GuildScheduledEventUser(user, guildMember, guildScheduledEventId);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GuildScheduledEventUser)) {
            return false;
        }
        GuildScheduledEventUser guildScheduledEventUser = (GuildScheduledEventUser) other;
        return Intrinsics3.areEqual(this.user, guildScheduledEventUser.user) && Intrinsics3.areEqual(this.guildMember, guildScheduledEventUser.guildMember) && this.guildScheduledEventId == guildScheduledEventUser.guildScheduledEventId;
    }

    public final GuildMember getGuildMember() {
        return this.guildMember;
    }

    public final long getGuildScheduledEventId() {
        return this.guildScheduledEventId;
    }

    public final User getUser() {
        return this.user;
    }

    public int hashCode() {
        User user = this.user;
        int iHashCode = (user != null ? user.hashCode() : 0) * 31;
        GuildMember guildMember = this.guildMember;
        return b.a(this.guildScheduledEventId) + ((iHashCode + (guildMember != null ? guildMember.hashCode() : 0)) * 31);
    }

    public String toString() {
        StringBuilder sbU = outline.U("GuildScheduledEventUser(user=");
        sbU.append(this.user);
        sbU.append(", guildMember=");
        sbU.append(this.guildMember);
        sbU.append(", guildScheduledEventId=");
        return outline.C(sbU, this.guildScheduledEventId, ")");
    }
}
