package com.discord.analytics.generated.traits;

import b.d.b.a.outline;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: TrackDirectoryEntry.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\n\u0010\u000bR\u001b\u0010\r\u001a\u0004\u0018\u00010\f8\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001b\u0010\u0011\u001a\u0004\u0018\u00010\f8\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u000e\u001a\u0004\b\u0012\u0010\u0010R\u001b\u0010\u0013\u001a\u0004\u0018\u00010\f8\u0006@\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u000e\u001a\u0004\b\u0014\u0010\u0010R!\u0010\u0016\u001a\n\u0018\u00010\fj\u0004\u0018\u0001`\u00158\u0006@\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u000e\u001a\u0004\b\u0017\u0010\u0010R\u001b\u0010\u0019\u001a\u0004\u0018\u00010\u00188\u0006@\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u001b\u0010\u001d\u001a\u0004\u0018\u00010\f8\u0006@\u0006¢\u0006\f\n\u0004\b\u001d\u0010\u000e\u001a\u0004\b\u001e\u0010\u0010R\u001b\u0010\u001f\u001a\u0004\u0018\u00010\f8\u0006@\u0006¢\u0006\f\n\u0004\b\u001f\u0010\u000e\u001a\u0004\b \u0010\u0010R\u001b\u0010!\u001a\u0004\u0018\u00010\f8\u0006@\u0006¢\u0006\f\n\u0004\b!\u0010\u000e\u001a\u0004\b\"\u0010\u0010¨\u0006#"}, d2 = {"Lcom/discord/analytics/generated/traits/TrackDirectoryEntry;", "", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "primaryCategoryId", "Ljava/lang/Long;", "getPrimaryCategoryId", "()Ljava/lang/Long;", "directoryGuildId", "getDirectoryGuildId", "authorId", "getAuthorId", "Lcom/discord/primitives/Timestamp;", "createdAt", "getCreatedAt", "", "entryDescription", "Ljava/lang/CharSequence;", "getEntryDescription", "()Ljava/lang/CharSequence;", "entityType", "getEntityType", "entityId", "getEntityId", "directoryChannelId", "getDirectoryChannelId", "analytics_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final /* data */ class TrackDirectoryEntry {
    private final Long directoryChannelId = null;
    private final Long directoryGuildId = null;
    private final Long entityId = null;
    private final Long authorId = null;
    private final Long entityType = null;
    private final Long createdAt = null;
    private final Long primaryCategoryId = null;
    private final CharSequence entryDescription = null;

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackDirectoryEntry)) {
            return false;
        }
        TrackDirectoryEntry trackDirectoryEntry = (TrackDirectoryEntry) other;
        return Intrinsics3.areEqual(this.directoryChannelId, trackDirectoryEntry.directoryChannelId) && Intrinsics3.areEqual(this.directoryGuildId, trackDirectoryEntry.directoryGuildId) && Intrinsics3.areEqual(this.entityId, trackDirectoryEntry.entityId) && Intrinsics3.areEqual(this.authorId, trackDirectoryEntry.authorId) && Intrinsics3.areEqual(this.entityType, trackDirectoryEntry.entityType) && Intrinsics3.areEqual(this.createdAt, trackDirectoryEntry.createdAt) && Intrinsics3.areEqual(this.primaryCategoryId, trackDirectoryEntry.primaryCategoryId) && Intrinsics3.areEqual(this.entryDescription, trackDirectoryEntry.entryDescription);
    }

    public int hashCode() {
        Long l = this.directoryChannelId;
        int iHashCode = (l != null ? l.hashCode() : 0) * 31;
        Long l2 = this.directoryGuildId;
        int iHashCode2 = (iHashCode + (l2 != null ? l2.hashCode() : 0)) * 31;
        Long l3 = this.entityId;
        int iHashCode3 = (iHashCode2 + (l3 != null ? l3.hashCode() : 0)) * 31;
        Long l4 = this.authorId;
        int iHashCode4 = (iHashCode3 + (l4 != null ? l4.hashCode() : 0)) * 31;
        Long l5 = this.entityType;
        int iHashCode5 = (iHashCode4 + (l5 != null ? l5.hashCode() : 0)) * 31;
        Long l6 = this.createdAt;
        int iHashCode6 = (iHashCode5 + (l6 != null ? l6.hashCode() : 0)) * 31;
        Long l7 = this.primaryCategoryId;
        int iHashCode7 = (iHashCode6 + (l7 != null ? l7.hashCode() : 0)) * 31;
        CharSequence charSequence = this.entryDescription;
        return iHashCode7 + (charSequence != null ? charSequence.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackDirectoryEntry(directoryChannelId=");
        sbU.append(this.directoryChannelId);
        sbU.append(", directoryGuildId=");
        sbU.append(this.directoryGuildId);
        sbU.append(", entityId=");
        sbU.append(this.entityId);
        sbU.append(", authorId=");
        sbU.append(this.authorId);
        sbU.append(", entityType=");
        sbU.append(this.entityType);
        sbU.append(", createdAt=");
        sbU.append(this.createdAt);
        sbU.append(", primaryCategoryId=");
        sbU.append(this.primaryCategoryId);
        sbU.append(", entryDescription=");
        return outline.E(sbU, this.entryDescription, ")");
    }
}
