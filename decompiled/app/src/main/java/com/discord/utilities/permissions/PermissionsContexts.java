package com.discord.utilities.permissions;

import b.d.b.a.outline;
import com.discord.api.channel.Channel;
import com.discord.api.permission.Permission;
import d0.z.d.Intrinsics3;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: PermissionsContexts.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0016\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0012\b\u0086\b\u0018\u0000 -2\u00020\u0001:\u0001-BO\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u0012\u0006\u0010\u000f\u001a\u00020\u0002\u0012\u0006\u0010\u0010\u001a\u00020\u0002\u0012\u0006\u0010\u0011\u001a\u00020\u0002\u0012\u0006\u0010\u0012\u001a\u00020\u0002\u0012\u0006\u0010\u0013\u001a\u00020\u0002\u0012\u0006\u0010\u0014\u001a\u00020\u0002\u0012\u0006\u0010\u0015\u001a\u00020\u0002\u0012\u0006\u0010\u0016\u001a\u00020\u0002¢\u0006\u0004\b+\u0010,J\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0007\u0010\u0004J\u0010\u0010\b\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\b\u0010\u0004J\u0010\u0010\t\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\t\u0010\u0004J\u0010\u0010\n\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\n\u0010\u0004J\u0010\u0010\u000b\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u000b\u0010\u0004J\u0010\u0010\f\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\f\u0010\u0004J\u0010\u0010\r\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\r\u0010\u0004Jj\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u000e\u001a\u00020\u00022\b\b\u0002\u0010\u000f\u001a\u00020\u00022\b\b\u0002\u0010\u0010\u001a\u00020\u00022\b\b\u0002\u0010\u0011\u001a\u00020\u00022\b\b\u0002\u0010\u0012\u001a\u00020\u00022\b\b\u0002\u0010\u0013\u001a\u00020\u00022\b\b\u0002\u0010\u0014\u001a\u00020\u00022\b\b\u0002\u0010\u0015\u001a\u00020\u00022\b\b\u0002\u0010\u0016\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u001a\u001a\u00020\u0019HÖ\u0001¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u001d\u001a\u00020\u001cHÖ\u0001¢\u0006\u0004\b\u001d\u0010\u001eJ\u001a\u0010 \u001a\u00020\u00022\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b \u0010!R\u0019\u0010\u000f\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010\"\u001a\u0004\b#\u0010\u0004R\u0019\u0010\u0012\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010\"\u001a\u0004\b$\u0010\u0004R\u0019\u0010\u0014\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0014\u0010\"\u001a\u0004\b%\u0010\u0004R\u0019\u0010\u0010\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0010\u0010\"\u001a\u0004\b&\u0010\u0004R\u0019\u0010\u0016\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0016\u0010\"\u001a\u0004\b\u0016\u0010\u0004R\u0019\u0010\u000e\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u000e\u0010\"\u001a\u0004\b'\u0010\u0004R\u0019\u0010\u0011\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010\"\u001a\u0004\b(\u0010\u0004R\u0019\u0010\u0013\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0013\u0010\"\u001a\u0004\b)\u0010\u0004R\u0019\u0010\u0015\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0015\u0010\"\u001a\u0004\b*\u0010\u0004¨\u0006."}, d2 = {"Lcom/discord/utilities/permissions/ManageGuildContext;", "", "", "canManage", "()Z", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "canManageServer", "canManageChannels", "canManageRoles", "canManageBans", "canManageNicknames", "canManageEmojisAndStickers", "canViewAuditLogs", "canManageEvents", "isOwnerWithRequiredMFALevel", "copy", "(ZZZZZZZZZ)Lcom/discord/utilities/permissions/ManageGuildContext;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Z", "getCanManageChannels", "getCanManageNicknames", "getCanViewAuditLogs", "getCanManageRoles", "getCanManageServer", "getCanManageBans", "getCanManageEmojisAndStickers", "getCanManageEvents", "<init>", "(ZZZZZZZZZ)V", "Companion", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* renamed from: com.discord.utilities.permissions.ManageGuildContext, reason: use source file name */
/* loaded from: classes2.dex */
public final /* data */ class PermissionsContexts {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final boolean canManageBans;
    private final boolean canManageChannels;
    private final boolean canManageEmojisAndStickers;
    private final boolean canManageEvents;
    private final boolean canManageNicknames;
    private final boolean canManageRoles;
    private final boolean canManageServer;
    private final boolean canViewAuditLogs;
    private final boolean isOwnerWithRequiredMFALevel;

    /* compiled from: PermissionsContexts.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0013\u0010\u0014Ja\u0010\u0011\u001a\u00020\u00102\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u000e\u0010\t\u001a\n\u0018\u00010\u0007j\u0004\u0018\u0001`\b2\u001a\u0010\f\u001a\u0016\u0012\b\u0012\u00060\u0007j\u0002`\u000b\u0012\b\u0012\u00060\u0007j\u0002`\b0\n2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0005H\u0007¢\u0006\u0004\b\u0011\u0010\u0012¨\u0006\u0015"}, d2 = {"Lcom/discord/utilities/permissions/ManageGuildContext$Companion;", "", "", "Lcom/discord/api/channel/Channel;", "categories", "", "isOwner", "", "Lcom/discord/api/permission/PermissionBit;", "guildPermissions", "", "Lcom/discord/primitives/ChannelId;", "channelPermissions", "", "guildMfaLevel", "isMeMfaEnabled", "Lcom/discord/utilities/permissions/ManageGuildContext;", "from", "(Ljava/util/List;ZLjava/lang/Long;Ljava/util/Map;IZ)Lcom/discord/utilities/permissions/ManageGuildContext;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    /* renamed from: com.discord.utilities.permissions.ManageGuildContext$Companion, reason: from kotlin metadata */
    public static final class Companion {
        private Companion() {
        }

        public final PermissionsContexts from(List<Channel> categories, boolean isOwner, Long guildPermissions, Map<Long, Long> channelPermissions, int guildMfaLevel, boolean isMeMfaEnabled) {
            boolean z2;
            Intrinsics3.checkNotNullParameter(categories, "categories");
            Intrinsics3.checkNotNullParameter(channelPermissions, "channelPermissions");
            if ((categories instanceof Collection) && categories.isEmpty()) {
                z2 = false;
            } else {
                Iterator<T> it = categories.iterator();
                while (it.hasNext()) {
                    if (PermissionUtils.can(16L, (Long) outline.d((Channel) it.next(), channelPermissions))) {
                        z2 = true;
                        break;
                    }
                }
                z2 = false;
            }
            return new PermissionsContexts(isOwner || PermissionUtils.can(32L, guildPermissions), isOwner || PermissionUtils.can(16L, guildPermissions) || z2, isOwner || PermissionUtils.can(Permission.MANAGE_ROLES, guildPermissions), isOwner || PermissionUtils.can(4L, guildPermissions), isOwner || PermissionUtils.can(Permission.MANAGE_NICKNAMES, guildPermissions), isOwner || PermissionUtils.can(Permission.MANAGE_EMOJIS_AND_STICKERS, guildPermissions), isOwner || PermissionUtils.can(128L, guildPermissions), isOwner || PermissionUtils.can(Permission.MANAGE_EVENTS, guildPermissions), isOwner && PermissionUtils.isElevated(isMeMfaEnabled, guildMfaLevel));
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public PermissionsContexts(boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, boolean z8, boolean z9, boolean z10) {
        this.canManageServer = z2;
        this.canManageChannels = z3;
        this.canManageRoles = z4;
        this.canManageBans = z5;
        this.canManageNicknames = z6;
        this.canManageEmojisAndStickers = z7;
        this.canViewAuditLogs = z8;
        this.canManageEvents = z9;
        this.isOwnerWithRequiredMFALevel = z10;
    }

    public static /* synthetic */ PermissionsContexts copy$default(PermissionsContexts permissionsContexts, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, boolean z8, boolean z9, boolean z10, int i, Object obj) {
        return permissionsContexts.copy((i & 1) != 0 ? permissionsContexts.canManageServer : z2, (i & 2) != 0 ? permissionsContexts.canManageChannels : z3, (i & 4) != 0 ? permissionsContexts.canManageRoles : z4, (i & 8) != 0 ? permissionsContexts.canManageBans : z5, (i & 16) != 0 ? permissionsContexts.canManageNicknames : z6, (i & 32) != 0 ? permissionsContexts.canManageEmojisAndStickers : z7, (i & 64) != 0 ? permissionsContexts.canViewAuditLogs : z8, (i & 128) != 0 ? permissionsContexts.canManageEvents : z9, (i & 256) != 0 ? permissionsContexts.isOwnerWithRequiredMFALevel : z10);
    }

    public static final PermissionsContexts from(List<Channel> list, boolean z2, Long l, Map<Long, Long> map, int i, boolean z3) {
        return INSTANCE.from(list, z2, l, map, i, z3);
    }

    public final boolean canManage() {
        return this.canManageServer || this.canManageChannels || this.canManageRoles || this.canManageBans || this.canViewAuditLogs || this.canManageEmojisAndStickers || this.isOwnerWithRequiredMFALevel;
    }

    /* renamed from: component1, reason: from getter */
    public final boolean getCanManageServer() {
        return this.canManageServer;
    }

    /* renamed from: component2, reason: from getter */
    public final boolean getCanManageChannels() {
        return this.canManageChannels;
    }

    /* renamed from: component3, reason: from getter */
    public final boolean getCanManageRoles() {
        return this.canManageRoles;
    }

    /* renamed from: component4, reason: from getter */
    public final boolean getCanManageBans() {
        return this.canManageBans;
    }

    /* renamed from: component5, reason: from getter */
    public final boolean getCanManageNicknames() {
        return this.canManageNicknames;
    }

    /* renamed from: component6, reason: from getter */
    public final boolean getCanManageEmojisAndStickers() {
        return this.canManageEmojisAndStickers;
    }

    /* renamed from: component7, reason: from getter */
    public final boolean getCanViewAuditLogs() {
        return this.canViewAuditLogs;
    }

    /* renamed from: component8, reason: from getter */
    public final boolean getCanManageEvents() {
        return this.canManageEvents;
    }

    /* renamed from: component9, reason: from getter */
    public final boolean getIsOwnerWithRequiredMFALevel() {
        return this.isOwnerWithRequiredMFALevel;
    }

    public final PermissionsContexts copy(boolean canManageServer, boolean canManageChannels, boolean canManageRoles, boolean canManageBans, boolean canManageNicknames, boolean canManageEmojisAndStickers, boolean canViewAuditLogs, boolean canManageEvents, boolean isOwnerWithRequiredMFALevel) {
        return new PermissionsContexts(canManageServer, canManageChannels, canManageRoles, canManageBans, canManageNicknames, canManageEmojisAndStickers, canViewAuditLogs, canManageEvents, isOwnerWithRequiredMFALevel);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PermissionsContexts)) {
            return false;
        }
        PermissionsContexts permissionsContexts = (PermissionsContexts) other;
        return this.canManageServer == permissionsContexts.canManageServer && this.canManageChannels == permissionsContexts.canManageChannels && this.canManageRoles == permissionsContexts.canManageRoles && this.canManageBans == permissionsContexts.canManageBans && this.canManageNicknames == permissionsContexts.canManageNicknames && this.canManageEmojisAndStickers == permissionsContexts.canManageEmojisAndStickers && this.canViewAuditLogs == permissionsContexts.canViewAuditLogs && this.canManageEvents == permissionsContexts.canManageEvents && this.isOwnerWithRequiredMFALevel == permissionsContexts.isOwnerWithRequiredMFALevel;
    }

    public final boolean getCanManageBans() {
        return this.canManageBans;
    }

    public final boolean getCanManageChannels() {
        return this.canManageChannels;
    }

    public final boolean getCanManageEmojisAndStickers() {
        return this.canManageEmojisAndStickers;
    }

    public final boolean getCanManageEvents() {
        return this.canManageEvents;
    }

    public final boolean getCanManageNicknames() {
        return this.canManageNicknames;
    }

    public final boolean getCanManageRoles() {
        return this.canManageRoles;
    }

    public final boolean getCanManageServer() {
        return this.canManageServer;
    }

    public final boolean getCanViewAuditLogs() {
        return this.canViewAuditLogs;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v18 */
    /* JADX WARN: Type inference failed for: r0v19 */
    /* JADX WARN: Type inference failed for: r2v0, types: [boolean] */
    /* JADX WARN: Type inference failed for: r2v10, types: [boolean] */
    /* JADX WARN: Type inference failed for: r2v12, types: [boolean] */
    /* JADX WARN: Type inference failed for: r2v2, types: [boolean] */
    /* JADX WARN: Type inference failed for: r2v4, types: [boolean] */
    /* JADX WARN: Type inference failed for: r2v6, types: [boolean] */
    /* JADX WARN: Type inference failed for: r2v8, types: [boolean] */
    public int hashCode() {
        boolean z2 = this.canManageServer;
        ?? r0 = z2;
        if (z2) {
            r0 = 1;
        }
        int i = r0 * 31;
        ?? r2 = this.canManageChannels;
        int i2 = r2;
        if (r2 != 0) {
            i2 = 1;
        }
        int i3 = (i + i2) * 31;
        ?? r22 = this.canManageRoles;
        int i4 = r22;
        if (r22 != 0) {
            i4 = 1;
        }
        int i5 = (i3 + i4) * 31;
        ?? r23 = this.canManageBans;
        int i6 = r23;
        if (r23 != 0) {
            i6 = 1;
        }
        int i7 = (i5 + i6) * 31;
        ?? r24 = this.canManageNicknames;
        int i8 = r24;
        if (r24 != 0) {
            i8 = 1;
        }
        int i9 = (i7 + i8) * 31;
        ?? r25 = this.canManageEmojisAndStickers;
        int i10 = r25;
        if (r25 != 0) {
            i10 = 1;
        }
        int i11 = (i9 + i10) * 31;
        ?? r26 = this.canViewAuditLogs;
        int i12 = r26;
        if (r26 != 0) {
            i12 = 1;
        }
        int i13 = (i11 + i12) * 31;
        ?? r27 = this.canManageEvents;
        int i14 = r27;
        if (r27 != 0) {
            i14 = 1;
        }
        int i15 = (i13 + i14) * 31;
        boolean z3 = this.isOwnerWithRequiredMFALevel;
        return i15 + (z3 ? 1 : z3 ? 1 : 0);
    }

    public final boolean isOwnerWithRequiredMFALevel() {
        return this.isOwnerWithRequiredMFALevel;
    }

    public String toString() {
        StringBuilder sbU = outline.U("ManageGuildContext(canManageServer=");
        sbU.append(this.canManageServer);
        sbU.append(", canManageChannels=");
        sbU.append(this.canManageChannels);
        sbU.append(", canManageRoles=");
        sbU.append(this.canManageRoles);
        sbU.append(", canManageBans=");
        sbU.append(this.canManageBans);
        sbU.append(", canManageNicknames=");
        sbU.append(this.canManageNicknames);
        sbU.append(", canManageEmojisAndStickers=");
        sbU.append(this.canManageEmojisAndStickers);
        sbU.append(", canViewAuditLogs=");
        sbU.append(this.canViewAuditLogs);
        sbU.append(", canManageEvents=");
        sbU.append(this.canManageEvents);
        sbU.append(", isOwnerWithRequiredMFALevel=");
        return outline.O(sbU, this.isOwnerWithRequiredMFALevel, ")");
    }
}
