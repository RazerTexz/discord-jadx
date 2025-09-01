package com.discord.utilities.permissions;

import b.d.b.a.outline;
import com.discord.api.permission.Permission;
import com.discord.api.sticker.Sticker;
import com.discord.api.sticker.StickerPartial;
import com.discord.api.user.User;
import com.discord.models.message.Message;
import com.discord.models.user.MeUser;
import d0.z.d.Intrinsics3;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: PermissionsContexts.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0010\b\u0086\b\u0018\u0000 $2\u00020\u0001:\u0001$B7\u0012\u0006\u0010\n\u001a\u00020\u0002\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\u0006\u0010\f\u001a\u00020\u0002\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u0012\u0006\u0010\u000f\u001a\u00020\u0002¢\u0006\u0004\b\"\u0010#J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0007\u0010\u0004J\u0010\u0010\b\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\b\u0010\u0004J\u0010\u0010\t\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\t\u0010\u0004JL\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\n\u001a\u00020\u00022\b\b\u0002\u0010\u000b\u001a\u00020\u00022\b\b\u0002\u0010\f\u001a\u00020\u00022\b\b\u0002\u0010\r\u001a\u00020\u00022\b\b\u0002\u0010\u000e\u001a\u00020\u00022\b\b\u0002\u0010\u000f\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0013\u001a\u00020\u0012HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0016\u001a\u00020\u0015HÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u001a\u0010\u0019\u001a\u00020\u00022\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0019\u0010\u001aR\u0019\u0010\f\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\u001b\u001a\u0004\b\u001c\u0010\u0004R\u0019\u0010\n\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\n\u0010\u001b\u001a\u0004\b\u001d\u0010\u0004R\u0019\u0010\u000f\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u001b\u001a\u0004\b\u001e\u0010\u0004R\u0019\u0010\r\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\u001b\u001a\u0004\b\u001f\u0010\u0004R\u0019\u0010\u000e\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u001b\u001a\u0004\b \u0010\u0004R\u0019\u0010\u000b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u001b\u001a\u0004\b!\u0010\u0004¨\u0006%"}, d2 = {"Lcom/discord/utilities/permissions/ManageMessageContext;", "", "", "component1", "()Z", "component2", "component3", "component4", "component5", "component6", "canManageMessages", "canEdit", "canDelete", "canAddReactions", "canTogglePinned", "canMarkUnread", "copy", "(ZZZZZZ)Lcom/discord/utilities/permissions/ManageMessageContext;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Z", "getCanDelete", "getCanManageMessages", "getCanMarkUnread", "getCanAddReactions", "getCanTogglePinned", "getCanEdit", "<init>", "(ZZZZZZ)V", "Companion", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* renamed from: com.discord.utilities.permissions.ManageMessageContext, reason: use source file name */
/* loaded from: classes2.dex */
public final /* data */ class PermissionsContexts2 {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final boolean canAddReactions;
    private final boolean canDelete;
    private final boolean canEdit;
    private final boolean canManageMessages;
    private final boolean canMarkUnread;
    private final boolean canTogglePinned;

    /* compiled from: PermissionsContexts.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0012\u0010\u0013JQ\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u00022\u000e\u0010\u0006\u001a\n\u0018\u00010\u0004j\u0004\u0018\u0001`\u00052\u0006\u0010\b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000bH\u0007¢\u0006\u0004\b\u0010\u0010\u0011¨\u0006\u0014"}, d2 = {"Lcom/discord/utilities/permissions/ManageMessageContext$Companion;", "", "Lcom/discord/models/message/Message;", "message", "", "Lcom/discord/api/permission/PermissionBit;", "myPermissions", "Lcom/discord/models/user/MeUser;", "meUser", "", "guildMfaLevel", "", "isPrivateChannel", "isSystemDM", "isArchivedThread", "Lcom/discord/utilities/permissions/ManageMessageContext;", "from", "(Lcom/discord/models/message/Message;Ljava/lang/Long;Lcom/discord/models/user/MeUser;Ljava/lang/Integer;ZZZ)Lcom/discord/utilities/permissions/ManageMessageContext;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    /* renamed from: com.discord.utilities.permissions.ManageMessageContext$Companion, reason: from kotlin metadata */
    public static final class Companion {
        private Companion() {
        }

        /* JADX WARN: Removed duplicated region for block: B:48:0x0082  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final PermissionsContexts2 from(Message message, Long myPermissions, MeUser meUser, Integer guildMfaLevel, boolean isPrivateChannel, boolean isSystemDM, boolean isArchivedThread) {
            boolean z2;
            Intrinsics3.checkNotNullParameter(message, "message");
            Intrinsics3.checkNotNullParameter(meUser, "meUser");
            boolean zIsUserMessage = message.isUserMessage();
            User author = message.getAuthor();
            boolean z3 = false;
            boolean z4 = author != null && author.getId() == meUser.getId();
            boolean z5 = isPrivateChannel && !isSystemDM;
            boolean z6 = (guildMfaLevel == null || !PermissionUtils.canAndIsElevated(Permission.MANAGE_MESSAGES, myPermissions, meUser.getMfaEnabled(), guildMfaLevel.intValue()) || isArchivedThread) ? false : true;
            boolean z7 = z6 || z5;
            boolean z8 = z6 || z4;
            if (z4 && zIsUserMessage) {
                List<Sticker> stickers = message.getStickers();
                if (stickers == null || stickers.isEmpty()) {
                    List<StickerPartial> stickerItems = message.getStickerItems();
                    if ((stickerItems == null || stickerItems.isEmpty()) && !isArchivedThread) {
                        z2 = true;
                    }
                }
            } else {
                z2 = false;
            }
            boolean z9 = z8 && !isArchivedThread && PermissionsContexts4.isDeleteable(message);
            boolean z10 = !message.isLocal() && (z5 || PermissionUtils.can(64L, myPermissions)) && !isArchivedThread;
            if (z7 && zIsUserMessage && !isSystemDM && !isArchivedThread) {
                z3 = true;
            }
            return new PermissionsContexts2(z6, z2, z9, z10, z3, !isArchivedThread);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public PermissionsContexts2(boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7) {
        this.canManageMessages = z2;
        this.canEdit = z3;
        this.canDelete = z4;
        this.canAddReactions = z5;
        this.canTogglePinned = z6;
        this.canMarkUnread = z7;
    }

    public static /* synthetic */ PermissionsContexts2 copy$default(PermissionsContexts2 permissionsContexts2, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, int i, Object obj) {
        if ((i & 1) != 0) {
            z2 = permissionsContexts2.canManageMessages;
        }
        if ((i & 2) != 0) {
            z3 = permissionsContexts2.canEdit;
        }
        boolean z8 = z3;
        if ((i & 4) != 0) {
            z4 = permissionsContexts2.canDelete;
        }
        boolean z9 = z4;
        if ((i & 8) != 0) {
            z5 = permissionsContexts2.canAddReactions;
        }
        boolean z10 = z5;
        if ((i & 16) != 0) {
            z6 = permissionsContexts2.canTogglePinned;
        }
        boolean z11 = z6;
        if ((i & 32) != 0) {
            z7 = permissionsContexts2.canMarkUnread;
        }
        return permissionsContexts2.copy(z2, z8, z9, z10, z11, z7);
    }

    public static final PermissionsContexts2 from(Message message, Long l, MeUser meUser, Integer num, boolean z2, boolean z3, boolean z4) {
        return INSTANCE.from(message, l, meUser, num, z2, z3, z4);
    }

    /* renamed from: component1, reason: from getter */
    public final boolean getCanManageMessages() {
        return this.canManageMessages;
    }

    /* renamed from: component2, reason: from getter */
    public final boolean getCanEdit() {
        return this.canEdit;
    }

    /* renamed from: component3, reason: from getter */
    public final boolean getCanDelete() {
        return this.canDelete;
    }

    /* renamed from: component4, reason: from getter */
    public final boolean getCanAddReactions() {
        return this.canAddReactions;
    }

    /* renamed from: component5, reason: from getter */
    public final boolean getCanTogglePinned() {
        return this.canTogglePinned;
    }

    /* renamed from: component6, reason: from getter */
    public final boolean getCanMarkUnread() {
        return this.canMarkUnread;
    }

    public final PermissionsContexts2 copy(boolean canManageMessages, boolean canEdit, boolean canDelete, boolean canAddReactions, boolean canTogglePinned, boolean canMarkUnread) {
        return new PermissionsContexts2(canManageMessages, canEdit, canDelete, canAddReactions, canTogglePinned, canMarkUnread);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PermissionsContexts2)) {
            return false;
        }
        PermissionsContexts2 permissionsContexts2 = (PermissionsContexts2) other;
        return this.canManageMessages == permissionsContexts2.canManageMessages && this.canEdit == permissionsContexts2.canEdit && this.canDelete == permissionsContexts2.canDelete && this.canAddReactions == permissionsContexts2.canAddReactions && this.canTogglePinned == permissionsContexts2.canTogglePinned && this.canMarkUnread == permissionsContexts2.canMarkUnread;
    }

    public final boolean getCanAddReactions() {
        return this.canAddReactions;
    }

    public final boolean getCanDelete() {
        return this.canDelete;
    }

    public final boolean getCanEdit() {
        return this.canEdit;
    }

    public final boolean getCanManageMessages() {
        return this.canManageMessages;
    }

    public final boolean getCanMarkUnread() {
        return this.canMarkUnread;
    }

    public final boolean getCanTogglePinned() {
        return this.canTogglePinned;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v12 */
    /* JADX WARN: Type inference failed for: r0v13 */
    /* JADX WARN: Type inference failed for: r2v0, types: [boolean] */
    /* JADX WARN: Type inference failed for: r2v2, types: [boolean] */
    /* JADX WARN: Type inference failed for: r2v4, types: [boolean] */
    /* JADX WARN: Type inference failed for: r2v6, types: [boolean] */
    public int hashCode() {
        boolean z2 = this.canManageMessages;
        ?? r0 = z2;
        if (z2) {
            r0 = 1;
        }
        int i = r0 * 31;
        ?? r2 = this.canEdit;
        int i2 = r2;
        if (r2 != 0) {
            i2 = 1;
        }
        int i3 = (i + i2) * 31;
        ?? r22 = this.canDelete;
        int i4 = r22;
        if (r22 != 0) {
            i4 = 1;
        }
        int i5 = (i3 + i4) * 31;
        ?? r23 = this.canAddReactions;
        int i6 = r23;
        if (r23 != 0) {
            i6 = 1;
        }
        int i7 = (i5 + i6) * 31;
        ?? r24 = this.canTogglePinned;
        int i8 = r24;
        if (r24 != 0) {
            i8 = 1;
        }
        int i9 = (i7 + i8) * 31;
        boolean z3 = this.canMarkUnread;
        return i9 + (z3 ? 1 : z3 ? 1 : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("ManageMessageContext(canManageMessages=");
        sbU.append(this.canManageMessages);
        sbU.append(", canEdit=");
        sbU.append(this.canEdit);
        sbU.append(", canDelete=");
        sbU.append(this.canDelete);
        sbU.append(", canAddReactions=");
        sbU.append(this.canAddReactions);
        sbU.append(", canTogglePinned=");
        sbU.append(this.canTogglePinned);
        sbU.append(", canMarkUnread=");
        return outline.O(sbU, this.canMarkUnread, ")");
    }
}
