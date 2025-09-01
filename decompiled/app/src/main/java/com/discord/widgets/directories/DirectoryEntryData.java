package com.discord.widgets.directories;

import b.d.b.a.outline;
import com.discord.api.directory.DirectoryEntryGuild;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: WidgetDirectoryEntryViewHolder.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\r\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\u0006\u0010\n\u001a\u00020\u0005\u0012\u0006\u0010\u000b\u001a\u00020\u0005¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\b\u0010\u0007J.\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\t\u001a\u00020\u00022\b\b\u0002\u0010\n\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0012\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u001a\u0010\u0015\u001a\u00020\u00052\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0015\u0010\u0016R\u0019\u0010\n\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\n\u0010\u0017\u001a\u0004\b\u0018\u0010\u0007R\u0019\u0010\t\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\u0019\u001a\u0004\b\u001a\u0010\u0004R\u0019\u0010\u000b\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u0017\u001a\u0004\b\u001b\u0010\u0007¨\u0006\u001e"}, d2 = {"Lcom/discord/widgets/directories/DirectoryEntryData;", "", "Lcom/discord/api/directory/DirectoryEntryGuild;", "component1", "()Lcom/discord/api/directory/DirectoryEntryGuild;", "", "component2", "()Z", "component3", "entry", "hasJoinedGuild", "hasEditPermissions", "copy", "(Lcom/discord/api/directory/DirectoryEntryGuild;ZZ)Lcom/discord/widgets/directories/DirectoryEntryData;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Z", "getHasJoinedGuild", "Lcom/discord/api/directory/DirectoryEntryGuild;", "getEntry", "getHasEditPermissions", "<init>", "(Lcom/discord/api/directory/DirectoryEntryGuild;ZZ)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final /* data */ class DirectoryEntryData {
    private final DirectoryEntryGuild entry;
    private final boolean hasEditPermissions;
    private final boolean hasJoinedGuild;

    public DirectoryEntryData(DirectoryEntryGuild directoryEntryGuild, boolean z2, boolean z3) {
        Intrinsics3.checkNotNullParameter(directoryEntryGuild, "entry");
        this.entry = directoryEntryGuild;
        this.hasJoinedGuild = z2;
        this.hasEditPermissions = z3;
    }

    public static /* synthetic */ DirectoryEntryData copy$default(DirectoryEntryData directoryEntryData, DirectoryEntryGuild directoryEntryGuild, boolean z2, boolean z3, int i, Object obj) {
        if ((i & 1) != 0) {
            directoryEntryGuild = directoryEntryData.entry;
        }
        if ((i & 2) != 0) {
            z2 = directoryEntryData.hasJoinedGuild;
        }
        if ((i & 4) != 0) {
            z3 = directoryEntryData.hasEditPermissions;
        }
        return directoryEntryData.copy(directoryEntryGuild, z2, z3);
    }

    /* renamed from: component1, reason: from getter */
    public final DirectoryEntryGuild getEntry() {
        return this.entry;
    }

    /* renamed from: component2, reason: from getter */
    public final boolean getHasJoinedGuild() {
        return this.hasJoinedGuild;
    }

    /* renamed from: component3, reason: from getter */
    public final boolean getHasEditPermissions() {
        return this.hasEditPermissions;
    }

    public final DirectoryEntryData copy(DirectoryEntryGuild entry, boolean hasJoinedGuild, boolean hasEditPermissions) {
        Intrinsics3.checkNotNullParameter(entry, "entry");
        return new DirectoryEntryData(entry, hasJoinedGuild, hasEditPermissions);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DirectoryEntryData)) {
            return false;
        }
        DirectoryEntryData directoryEntryData = (DirectoryEntryData) other;
        return Intrinsics3.areEqual(this.entry, directoryEntryData.entry) && this.hasJoinedGuild == directoryEntryData.hasJoinedGuild && this.hasEditPermissions == directoryEntryData.hasEditPermissions;
    }

    public final DirectoryEntryGuild getEntry() {
        return this.entry;
    }

    public final boolean getHasEditPermissions() {
        return this.hasEditPermissions;
    }

    public final boolean getHasJoinedGuild() {
        return this.hasJoinedGuild;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        DirectoryEntryGuild directoryEntryGuild = this.entry;
        int iHashCode = (directoryEntryGuild != null ? directoryEntryGuild.hashCode() : 0) * 31;
        boolean z2 = this.hasJoinedGuild;
        int i = z2;
        if (z2 != 0) {
            i = 1;
        }
        int i2 = (iHashCode + i) * 31;
        boolean z3 = this.hasEditPermissions;
        return i2 + (z3 ? 1 : z3 ? 1 : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("DirectoryEntryData(entry=");
        sbU.append(this.entry);
        sbU.append(", hasJoinedGuild=");
        sbU.append(this.hasJoinedGuild);
        sbU.append(", hasEditPermissions=");
        return outline.O(sbU, this.hasEditPermissions, ")");
    }
}
