package com.discord.api.permission;

import b.d.b.a.outline;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: PermissionOverwrite.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001:\u0001\u001eB/\u0012\u0006\u0010\u0015\u001a\u00020\u0002\u0012\u0006\u0010\u0018\u001a\u00020\u0017\u0012\n\u0010\u0010\u001a\u00060\u0002j\u0002`\u000f\u0012\n\u0010\u0013\u001a\u00060\u0002j\u0002`\u000f¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u001a\u0010\r\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\r\u0010\u000eR\u001d\u0010\u0010\u001a\u00060\u0002j\u0002`\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0004R\u001d\u0010\u0013\u001a\u00060\u0002j\u0002`\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0011\u001a\u0004\b\u0014\u0010\u0004R\u0019\u0010\u0015\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0011\u001a\u0004\b\u0016\u0010\u0004R\u0019\u0010\u0018\u001a\u00020\u00178\u0006@\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b¨\u0006\u001f"}, d2 = {"Lcom/discord/api/permission/PermissionOverwrite;", "", "", "a", "()J", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/discord/api/permission/PermissionBit;", ModelAuditLogEntry.CHANGE_KEY_PERMISSIONS_GRANTED, "J", "c", ModelAuditLogEntry.CHANGE_KEY_PERMISSIONS_DENIED, "d", ModelAuditLogEntry.CHANGE_KEY_ID, "e", "Lcom/discord/api/permission/PermissionOverwrite$Type;", "type", "Lcom/discord/api/permission/PermissionOverwrite$Type;", "f", "()Lcom/discord/api/permission/PermissionOverwrite$Type;", "<init>", "(JLcom/discord/api/permission/PermissionOverwrite$Type;JJ)V", "Type", "discord_api"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final /* data */ class PermissionOverwrite {
    private final long allow;
    private final long deny;
    private final long id;
    private final Type type;

    /* compiled from: PermissionOverwrite.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/discord/api/permission/PermissionOverwrite$Type;", "", "<init>", "(Ljava/lang/String;I)V", "ROLE", "MEMBER", "discord_api"}, k = 1, mv = {1, 4, 2})
    public enum Type {
        ROLE,
        MEMBER
    }

    public PermissionOverwrite(long j, Type type, long j2, long j3) {
        Intrinsics3.checkNotNullParameter(type, "type");
        this.id = j;
        this.type = type;
        this.allow = j2;
        this.deny = j3;
    }

    public static PermissionOverwrite b(PermissionOverwrite permissionOverwrite, long j, Type type, long j2, long j3, int i) {
        long j4 = (i & 1) != 0 ? permissionOverwrite.id : j;
        Type type2 = (i & 2) != 0 ? permissionOverwrite.type : null;
        long j5 = (i & 4) != 0 ? permissionOverwrite.allow : j2;
        long j6 = (i & 8) != 0 ? permissionOverwrite.deny : j3;
        Intrinsics3.checkNotNullParameter(type2, "type");
        return new PermissionOverwrite(j4, type2, j5, j6);
    }

    /* renamed from: a, reason: from getter */
    public final long getId() {
        return this.id;
    }

    /* renamed from: c, reason: from getter */
    public final long getAllow() {
        return this.allow;
    }

    /* renamed from: d, reason: from getter */
    public final long getDeny() {
        return this.deny;
    }

    public final long e() {
        return this.id;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PermissionOverwrite)) {
            return false;
        }
        PermissionOverwrite permissionOverwrite = (PermissionOverwrite) other;
        return this.id == permissionOverwrite.id && Intrinsics3.areEqual(this.type, permissionOverwrite.type) && this.allow == permissionOverwrite.allow && this.deny == permissionOverwrite.deny;
    }

    /* renamed from: f, reason: from getter */
    public final Type getType() {
        return this.type;
    }

    public int hashCode() {
        long j = this.id;
        int i = ((int) (j ^ (j >>> 32))) * 31;
        Type type = this.type;
        int iHashCode = type != null ? type.hashCode() : 0;
        long j2 = this.allow;
        int i2 = (((i + iHashCode) * 31) + ((int) (j2 ^ (j2 >>> 32)))) * 31;
        long j3 = this.deny;
        return i2 + ((int) (j3 ^ (j3 >>> 32)));
    }

    public String toString() {
        StringBuilder sbU = outline.U("PermissionOverwrite(id=");
        sbU.append(this.id);
        sbU.append(", type=");
        sbU.append(this.type);
        sbU.append(", allow=");
        sbU.append(this.allow);
        sbU.append(", deny=");
        return outline.C(sbU, this.deny, ")");
    }
}
