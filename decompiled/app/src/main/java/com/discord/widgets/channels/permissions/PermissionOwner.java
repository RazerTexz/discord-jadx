package com.discord.widgets.channels.permissions;

import b.d.b.a.outline;
import com.discord.api.role.GuildRole;
import com.discord.models.user.User;
import d0.z.d.Intrinsics3;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: PermissionOwner.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\t\nB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0019\u0010\u0003\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u0082\u0001\u0002\u000b\f¨\u0006\r"}, d2 = {"Lcom/discord/widgets/channels/permissions/PermissionOwner;", "Ljava/io/Serializable;", "", "entityId", "J", "getEntityId", "()J", "<init>", "(J)V", "Member", "Role", "Lcom/discord/widgets/channels/permissions/PermissionOwner$Role;", "Lcom/discord/widgets/channels/permissions/PermissionOwner$Member;", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public abstract class PermissionOwner implements Serializable {
    private final long entityId;

    /* compiled from: PermissionOwner.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\r\u001a\u00020\b¢\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ0\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u000b\u001a\u00020\u00022\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\r\u001a\u00020\bHÆ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0007J\u0010\u0010\u0012\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u001a\u0010\u0016\u001a\u00020\b2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014HÖ\u0003¢\u0006\u0004\b\u0016\u0010\u0017R\u0019\u0010\r\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\u0018\u001a\u0004\b\r\u0010\nR\u0019\u0010\u000b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u0019\u001a\u0004\b\u001a\u0010\u0004R\u001b\u0010\f\u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\u001b\u001a\u0004\b\u001c\u0010\u0007¨\u0006\u001f"}, d2 = {"Lcom/discord/widgets/channels/permissions/PermissionOwner$Member;", "Lcom/discord/widgets/channels/permissions/PermissionOwner;", "Lcom/discord/models/user/User;", "component1", "()Lcom/discord/models/user/User;", "", "component2", "()Ljava/lang/String;", "", "component3", "()Z", "user", "nickname", "isOwner", "copy", "(Lcom/discord/models/user/User;Ljava/lang/String;Z)Lcom/discord/widgets/channels/permissions/PermissionOwner$Member;", "toString", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "Z", "Lcom/discord/models/user/User;", "getUser", "Ljava/lang/String;", "getNickname", "<init>", "(Lcom/discord/models/user/User;Ljava/lang/String;Z)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class Member extends PermissionOwner {
        private final boolean isOwner;
        private final String nickname;
        private final User user;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Member(User user, String str, boolean z2) {
            super(user.getId(), null);
            Intrinsics3.checkNotNullParameter(user, "user");
            this.user = user;
            this.nickname = str;
            this.isOwner = z2;
        }

        public static /* synthetic */ Member copy$default(Member member, User user, String str, boolean z2, int i, Object obj) {
            if ((i & 1) != 0) {
                user = member.user;
            }
            if ((i & 2) != 0) {
                str = member.nickname;
            }
            if ((i & 4) != 0) {
                z2 = member.isOwner;
            }
            return member.copy(user, str, z2);
        }

        /* renamed from: component1, reason: from getter */
        public final User getUser() {
            return this.user;
        }

        /* renamed from: component2, reason: from getter */
        public final String getNickname() {
            return this.nickname;
        }

        /* renamed from: component3, reason: from getter */
        public final boolean getIsOwner() {
            return this.isOwner;
        }

        public final Member copy(User user, String nickname, boolean isOwner) {
            Intrinsics3.checkNotNullParameter(user, "user");
            return new Member(user, nickname, isOwner);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Member)) {
                return false;
            }
            Member member = (Member) other;
            return Intrinsics3.areEqual(this.user, member.user) && Intrinsics3.areEqual(this.nickname, member.nickname) && this.isOwner == member.isOwner;
        }

        public final String getNickname() {
            return this.nickname;
        }

        public final User getUser() {
            return this.user;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            User user = this.user;
            int iHashCode = (user != null ? user.hashCode() : 0) * 31;
            String str = this.nickname;
            int iHashCode2 = (iHashCode + (str != null ? str.hashCode() : 0)) * 31;
            boolean z2 = this.isOwner;
            int i = z2;
            if (z2 != 0) {
                i = 1;
            }
            return iHashCode2 + i;
        }

        public final boolean isOwner() {
            return this.isOwner;
        }

        public String toString() {
            StringBuilder sbU = outline.U("Member(user=");
            sbU.append(this.user);
            sbU.append(", nickname=");
            sbU.append(this.nickname);
            sbU.append(", isOwner=");
            return outline.O(sbU, this.isOwner, ")");
        }
    }

    /* compiled from: PermissionOwner.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u0019\u0010\u0005\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0013\u001a\u0004\b\u0014\u0010\u0004¨\u0006\u0017"}, d2 = {"Lcom/discord/widgets/channels/permissions/PermissionOwner$Role;", "Lcom/discord/widgets/channels/permissions/PermissionOwner;", "Lcom/discord/api/role/GuildRole;", "component1", "()Lcom/discord/api/role/GuildRole;", "role", "copy", "(Lcom/discord/api/role/GuildRole;)Lcom/discord/widgets/channels/permissions/PermissionOwner$Role;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/discord/api/role/GuildRole;", "getRole", "<init>", "(Lcom/discord/api/role/GuildRole;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class Role extends PermissionOwner {
        private final GuildRole role;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Role(GuildRole guildRole) {
            super(guildRole.getId(), null);
            Intrinsics3.checkNotNullParameter(guildRole, "role");
            this.role = guildRole;
        }

        public static /* synthetic */ Role copy$default(Role role, GuildRole guildRole, int i, Object obj) {
            if ((i & 1) != 0) {
                guildRole = role.role;
            }
            return role.copy(guildRole);
        }

        /* renamed from: component1, reason: from getter */
        public final GuildRole getRole() {
            return this.role;
        }

        public final Role copy(GuildRole role) {
            Intrinsics3.checkNotNullParameter(role, "role");
            return new Role(role);
        }

        public boolean equals(Object other) {
            if (this != other) {
                return (other instanceof Role) && Intrinsics3.areEqual(this.role, ((Role) other).role);
            }
            return true;
        }

        public final GuildRole getRole() {
            return this.role;
        }

        public int hashCode() {
            GuildRole guildRole = this.role;
            if (guildRole != null) {
                return guildRole.hashCode();
            }
            return 0;
        }

        public String toString() {
            StringBuilder sbU = outline.U("Role(role=");
            sbU.append(this.role);
            sbU.append(")");
            return sbU.toString();
        }
    }

    private PermissionOwner(long j) {
        this.entityId = j;
    }

    public final long getEntityId() {
        return this.entityId;
    }

    public /* synthetic */ PermissionOwner(long j, DefaultConstructorMarker defaultConstructorMarker) {
        this(j);
    }
}
