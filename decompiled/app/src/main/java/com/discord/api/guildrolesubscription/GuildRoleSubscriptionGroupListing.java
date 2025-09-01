package com.discord.api.guildrolesubscription;

import b.d.b.a.outline;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.Intrinsics3;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;

/* compiled from: GuildRoleSubscriptionGroupListing.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001Bc\u0012\u0006\u0010\r\u001a\u00020\f\u0012\n\u0010\u001d\u001a\u00060\fj\u0002`\u001c\u0012\n\u0010\u0012\u001a\u00060\fj\u0002`\u0011\u0012\b\u0010'\u001a\u0004\u0018\u00010&\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u0002\u0012\u000e\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u0014\u0012\u000e\u0010 \u001a\n\u0012\u0004\u0012\u00020\u001f\u0018\u00010\u0014\u0012\u0006\u0010\"\u001a\u00020\t¢\u0006\u0004\b+\u0010,J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\n\u0010\u000bR\u0019\u0010\r\u001a\u00020\f8\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001d\u0010\u0012\u001a\u00060\fj\u0002`\u00118\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u000e\u001a\u0004\b\u0013\u0010\u0010R!\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u00148\u0006@\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u001b\u0010\u0019\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u0004R\u001d\u0010\u001d\u001a\u00060\fj\u0002`\u001c8\u0006@\u0006¢\u0006\f\n\u0004\b\u001d\u0010\u000e\u001a\u0004\b\u001e\u0010\u0010R!\u0010 \u001a\n\u0012\u0004\u0012\u00020\u001f\u0018\u00010\u00148\u0006@\u0006¢\u0006\f\n\u0004\b \u0010\u0016\u001a\u0004\b!\u0010\u0018R\u0019\u0010\"\u001a\u00020\t8\u0006@\u0006¢\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%R\u001b\u0010'\u001a\u0004\u0018\u00010&8\u0006@\u0006¢\u0006\f\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*¨\u0006-"}, d2 = {"Lcom/discord/api/guildrolesubscription/GuildRoleSubscriptionGroupListing;", "", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "", ModelAuditLogEntry.CHANGE_KEY_ID, "J", "f", "()J", "Lcom/discord/primitives/ApplicationId;", "applicationId", "b", "", "subscriptionListingsIds", "Ljava/util/List;", "i", "()Ljava/util/List;", ModelAuditLogEntry.CHANGE_KEY_DESCRIPTION, "Ljava/lang/String;", "c", "Lcom/discord/primitives/GuildId;", "guildId", "e", "Lcom/discord/api/guildrolesubscription/GuildRoleSubscriptionTierListing;", "subscriptionListings", "h", "fullServerGate", "Z", "d", "()Z", "Lcom/discord/api/guildrolesubscription/ImageAsset;", "imageAsset", "Lcom/discord/api/guildrolesubscription/ImageAsset;", "g", "()Lcom/discord/api/guildrolesubscription/ImageAsset;", "<init>", "(JJJLcom/discord/api/guildrolesubscription/ImageAsset;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Z)V", "discord_api"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final /* data */ class GuildRoleSubscriptionGroupListing {
    private final long applicationId;
    private final String description;
    private final boolean fullServerGate;
    private final long guildId;
    private final long id;
    private final ImageAsset imageAsset;
    private final List<GuildRoleSubscriptionTierListing> subscriptionListings;
    private final List<Long> subscriptionListingsIds;

    public GuildRoleSubscriptionGroupListing(long j, long j2, long j3, ImageAsset imageAsset, String str, List<Long> list, List<GuildRoleSubscriptionTierListing> list2, boolean z2) {
        this.id = j;
        this.guildId = j2;
        this.applicationId = j3;
        this.imageAsset = imageAsset;
        this.description = str;
        this.subscriptionListingsIds = list;
        this.subscriptionListings = list2;
        this.fullServerGate = z2;
    }

    public static GuildRoleSubscriptionGroupListing a(GuildRoleSubscriptionGroupListing guildRoleSubscriptionGroupListing, long j, long j2, long j3, ImageAsset imageAsset, String str, List list, List list2, boolean z2, int i) {
        long j4 = (i & 1) != 0 ? guildRoleSubscriptionGroupListing.id : j;
        long j5 = (i & 2) != 0 ? guildRoleSubscriptionGroupListing.guildId : j2;
        long j6 = (i & 4) != 0 ? guildRoleSubscriptionGroupListing.applicationId : j3;
        ImageAsset imageAsset2 = (i & 8) != 0 ? guildRoleSubscriptionGroupListing.imageAsset : null;
        String str2 = (i & 16) != 0 ? guildRoleSubscriptionGroupListing.description : null;
        List<Long> list3 = (i & 32) != 0 ? guildRoleSubscriptionGroupListing.subscriptionListingsIds : null;
        List list4 = (i & 64) != 0 ? guildRoleSubscriptionGroupListing.subscriptionListings : list2;
        boolean z3 = (i & 128) != 0 ? guildRoleSubscriptionGroupListing.fullServerGate : z2;
        Objects.requireNonNull(guildRoleSubscriptionGroupListing);
        return new GuildRoleSubscriptionGroupListing(j4, j5, j6, imageAsset2, str2, list3, list4, z3);
    }

    /* renamed from: b, reason: from getter */
    public final long getApplicationId() {
        return this.applicationId;
    }

    /* renamed from: c, reason: from getter */
    public final String getDescription() {
        return this.description;
    }

    /* renamed from: d, reason: from getter */
    public final boolean getFullServerGate() {
        return this.fullServerGate;
    }

    /* renamed from: e, reason: from getter */
    public final long getGuildId() {
        return this.guildId;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GuildRoleSubscriptionGroupListing)) {
            return false;
        }
        GuildRoleSubscriptionGroupListing guildRoleSubscriptionGroupListing = (GuildRoleSubscriptionGroupListing) other;
        return this.id == guildRoleSubscriptionGroupListing.id && this.guildId == guildRoleSubscriptionGroupListing.guildId && this.applicationId == guildRoleSubscriptionGroupListing.applicationId && Intrinsics3.areEqual(this.imageAsset, guildRoleSubscriptionGroupListing.imageAsset) && Intrinsics3.areEqual(this.description, guildRoleSubscriptionGroupListing.description) && Intrinsics3.areEqual(this.subscriptionListingsIds, guildRoleSubscriptionGroupListing.subscriptionListingsIds) && Intrinsics3.areEqual(this.subscriptionListings, guildRoleSubscriptionGroupListing.subscriptionListings) && this.fullServerGate == guildRoleSubscriptionGroupListing.fullServerGate;
    }

    /* renamed from: f, reason: from getter */
    public final long getId() {
        return this.id;
    }

    /* renamed from: g, reason: from getter */
    public final ImageAsset getImageAsset() {
        return this.imageAsset;
    }

    public final List<GuildRoleSubscriptionTierListing> h() {
        return this.subscriptionListings;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        long j = this.id;
        long j2 = this.guildId;
        int i = ((((int) (j ^ (j >>> 32))) * 31) + ((int) (j2 ^ (j2 >>> 32)))) * 31;
        long j3 = this.applicationId;
        int i2 = (i + ((int) (j3 ^ (j3 >>> 32)))) * 31;
        ImageAsset imageAsset = this.imageAsset;
        int iHashCode = (i2 + (imageAsset != null ? imageAsset.hashCode() : 0)) * 31;
        String str = this.description;
        int iHashCode2 = (iHashCode + (str != null ? str.hashCode() : 0)) * 31;
        List<Long> list = this.subscriptionListingsIds;
        int iHashCode3 = (iHashCode2 + (list != null ? list.hashCode() : 0)) * 31;
        List<GuildRoleSubscriptionTierListing> list2 = this.subscriptionListings;
        int iHashCode4 = (iHashCode3 + (list2 != null ? list2.hashCode() : 0)) * 31;
        boolean z2 = this.fullServerGate;
        int i3 = z2;
        if (z2 != 0) {
            i3 = 1;
        }
        return iHashCode4 + i3;
    }

    public final List<Long> i() {
        return this.subscriptionListingsIds;
    }

    public String toString() {
        StringBuilder sbU = outline.U("GuildRoleSubscriptionGroupListing(id=");
        sbU.append(this.id);
        sbU.append(", guildId=");
        sbU.append(this.guildId);
        sbU.append(", applicationId=");
        sbU.append(this.applicationId);
        sbU.append(", imageAsset=");
        sbU.append(this.imageAsset);
        sbU.append(", description=");
        sbU.append(this.description);
        sbU.append(", subscriptionListingsIds=");
        sbU.append(this.subscriptionListingsIds);
        sbU.append(", subscriptionListings=");
        sbU.append(this.subscriptionListings);
        sbU.append(", fullServerGate=");
        return outline.O(sbU, this.fullServerGate, ")");
    }
}
