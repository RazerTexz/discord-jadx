package com.discord.widgets.servers.role_members;

import b.d.b.a.outline;
import com.discord.models.member.GuildMember;
import com.discord.utilities.recycler.DiffKeyProvider;
import com.discord.widgets.channels.permissions.PermissionOwner;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: ServerSettingsRoleMemberAdapterItem.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b\u001e\u0010\u001fJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J$\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0015\u001a\u00020\u00142\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012HÖ\u0003¢\u0006\u0004\b\u0015\u0010\u0016R\u0019\u0010\t\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\u0017\u001a\u0004\b\u0018\u0010\u0007R\u001c\u0010\u0019\u001a\u00020\f8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u000eR\u0019\u0010\b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\u001c\u001a\u0004\b\u001d\u0010\u0004¨\u0006 "}, d2 = {"Lcom/discord/widgets/servers/role_members/ServerSettingsRoleMemberAdapterItem;", "Lcom/discord/utilities/recycler/DiffKeyProvider;", "Lcom/discord/models/member/GuildMember;", "component1", "()Lcom/discord/models/member/GuildMember;", "Lcom/discord/widgets/channels/permissions/PermissionOwner$Member;", "component2", "()Lcom/discord/widgets/channels/permissions/PermissionOwner$Member;", "guildMember", "permissionOwner", "copy", "(Lcom/discord/models/member/GuildMember;Lcom/discord/widgets/channels/permissions/PermissionOwner$Member;)Lcom/discord/widgets/servers/role_members/ServerSettingsRoleMemberAdapterItem;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/discord/widgets/channels/permissions/PermissionOwner$Member;", "getPermissionOwner", "key", "Ljava/lang/String;", "getKey", "Lcom/discord/models/member/GuildMember;", "getGuildMember", "<init>", "(Lcom/discord/models/member/GuildMember;Lcom/discord/widgets/channels/permissions/PermissionOwner$Member;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final /* data */ class ServerSettingsRoleMemberAdapterItem implements DiffKeyProvider {
    private final GuildMember guildMember;
    private final String key;
    private final PermissionOwner.Member permissionOwner;

    public ServerSettingsRoleMemberAdapterItem(GuildMember guildMember, PermissionOwner.Member member) {
        Intrinsics3.checkNotNullParameter(guildMember, "guildMember");
        Intrinsics3.checkNotNullParameter(member, "permissionOwner");
        this.guildMember = guildMember;
        this.permissionOwner = member;
        this.key = String.valueOf(member.getUser().getId());
    }

    public static /* synthetic */ ServerSettingsRoleMemberAdapterItem copy$default(ServerSettingsRoleMemberAdapterItem serverSettingsRoleMemberAdapterItem, GuildMember guildMember, PermissionOwner.Member member, int i, Object obj) {
        if ((i & 1) != 0) {
            guildMember = serverSettingsRoleMemberAdapterItem.guildMember;
        }
        if ((i & 2) != 0) {
            member = serverSettingsRoleMemberAdapterItem.permissionOwner;
        }
        return serverSettingsRoleMemberAdapterItem.copy(guildMember, member);
    }

    /* renamed from: component1, reason: from getter */
    public final GuildMember getGuildMember() {
        return this.guildMember;
    }

    /* renamed from: component2, reason: from getter */
    public final PermissionOwner.Member getPermissionOwner() {
        return this.permissionOwner;
    }

    public final ServerSettingsRoleMemberAdapterItem copy(GuildMember guildMember, PermissionOwner.Member permissionOwner) {
        Intrinsics3.checkNotNullParameter(guildMember, "guildMember");
        Intrinsics3.checkNotNullParameter(permissionOwner, "permissionOwner");
        return new ServerSettingsRoleMemberAdapterItem(guildMember, permissionOwner);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ServerSettingsRoleMemberAdapterItem)) {
            return false;
        }
        ServerSettingsRoleMemberAdapterItem serverSettingsRoleMemberAdapterItem = (ServerSettingsRoleMemberAdapterItem) other;
        return Intrinsics3.areEqual(this.guildMember, serverSettingsRoleMemberAdapterItem.guildMember) && Intrinsics3.areEqual(this.permissionOwner, serverSettingsRoleMemberAdapterItem.permissionOwner);
    }

    public final GuildMember getGuildMember() {
        return this.guildMember;
    }

    @Override // com.discord.utilities.recycler.DiffKeyProvider
    public String getKey() {
        return this.key;
    }

    public final PermissionOwner.Member getPermissionOwner() {
        return this.permissionOwner;
    }

    public int hashCode() {
        GuildMember guildMember = this.guildMember;
        int iHashCode = (guildMember != null ? guildMember.hashCode() : 0) * 31;
        PermissionOwner.Member member = this.permissionOwner;
        return iHashCode + (member != null ? member.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("ServerSettingsRoleMemberAdapterItem(guildMember=");
        sbU.append(this.guildMember);
        sbU.append(", permissionOwner=");
        sbU.append(this.permissionOwner);
        sbU.append(")");
        return sbU.toString();
    }
}
