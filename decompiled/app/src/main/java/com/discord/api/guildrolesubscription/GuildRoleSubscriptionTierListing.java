package com.discord.api.guildrolesubscription;

import b.d.b.a.outline;
import com.discord.api.guildscheduledevent.GuildRoleSubscriptionRoleBenefits;
import com.discord.api.premium.SubscriptionPlan;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.Intrinsics3;
import java.util.List;
import kotlin.Metadata;

/* compiled from: GuildRoleSubscriptionTierListing.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\n\u0010\u000bR\u0019\u0010\r\u001a\u00020\f8\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u0019\u0010\u0011\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0004R\u001d\u0010\u0016\u001a\u00060\u0014j\u0002`\u00158\u0006@\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u001f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001a8\u0006@\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u001d\u0010!\u001a\u00060\u0014j\u0002` 8\u0006@\u0006¢\u0006\f\n\u0004\b!\u0010\u0017\u001a\u0004\b\"\u0010\u0019R\u001b\u0010#\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b#\u0010\u0012\u001a\u0004\b$\u0010\u0004R\u0019\u0010%\u001a\u00020\u00148\u0006@\u0006¢\u0006\f\n\u0004\b%\u0010\u0017\u001a\u0004\b&\u0010\u0019R\u0019\u0010'\u001a\u00020\t8\u0006@\u0006¢\u0006\f\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*R\u001b\u0010,\u001a\u0004\u0018\u00010+8\u0006@\u0006¢\u0006\f\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/¨\u00060"}, d2 = {"Lcom/discord/api/guildrolesubscription/GuildRoleSubscriptionTierListing;", "", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/discord/api/guildscheduledevent/GuildRoleSubscriptionRoleBenefits;", "roleBenefits", "Lcom/discord/api/guildscheduledevent/GuildRoleSubscriptionRoleBenefits;", "g", "()Lcom/discord/api/guildscheduledevent/GuildRoleSubscriptionRoleBenefits;", ModelAuditLogEntry.CHANGE_KEY_NAME, "Ljava/lang/String;", "e", "", "Lcom/discord/primitives/ApplicationId;", "applicationId", "J", "a", "()J", "", "Lcom/discord/api/premium/SubscriptionPlan;", "subscriptionPlans", "Ljava/util/List;", "i", "()Ljava/util/List;", "Lcom/discord/primitives/RoleId;", "roleId", "h", ModelAuditLogEntry.CHANGE_KEY_DESCRIPTION, "b", ModelAuditLogEntry.CHANGE_KEY_ID, "c", "published", "Z", "f", "()Z", "Lcom/discord/api/guildrolesubscription/ImageAsset;", "imageAsset", "Lcom/discord/api/guildrolesubscription/ImageAsset;", "d", "()Lcom/discord/api/guildrolesubscription/ImageAsset;", "discord_api"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final /* data */ class GuildRoleSubscriptionTierListing {
    private final long applicationId;
    private final String description;
    private final long id;
    private final ImageAsset imageAsset;
    private final String name;
    private final boolean published;
    private final GuildRoleSubscriptionRoleBenefits roleBenefits;
    private final long roleId;
    private final List<SubscriptionPlan> subscriptionPlans;

    /* renamed from: a, reason: from getter */
    public final long getApplicationId() {
        return this.applicationId;
    }

    /* renamed from: b, reason: from getter */
    public final String getDescription() {
        return this.description;
    }

    /* renamed from: c, reason: from getter */
    public final long getId() {
        return this.id;
    }

    /* renamed from: d, reason: from getter */
    public final ImageAsset getImageAsset() {
        return this.imageAsset;
    }

    /* renamed from: e, reason: from getter */
    public final String getName() {
        return this.name;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GuildRoleSubscriptionTierListing)) {
            return false;
        }
        GuildRoleSubscriptionTierListing guildRoleSubscriptionTierListing = (GuildRoleSubscriptionTierListing) other;
        return this.id == guildRoleSubscriptionTierListing.id && this.applicationId == guildRoleSubscriptionTierListing.applicationId && Intrinsics3.areEqual(this.name, guildRoleSubscriptionTierListing.name) && this.published == guildRoleSubscriptionTierListing.published && Intrinsics3.areEqual(this.description, guildRoleSubscriptionTierListing.description) && Intrinsics3.areEqual(this.imageAsset, guildRoleSubscriptionTierListing.imageAsset) && Intrinsics3.areEqual(this.subscriptionPlans, guildRoleSubscriptionTierListing.subscriptionPlans) && Intrinsics3.areEqual(this.roleBenefits, guildRoleSubscriptionTierListing.roleBenefits) && this.roleId == guildRoleSubscriptionTierListing.roleId;
    }

    /* renamed from: f, reason: from getter */
    public final boolean getPublished() {
        return this.published;
    }

    /* renamed from: g, reason: from getter */
    public final GuildRoleSubscriptionRoleBenefits getRoleBenefits() {
        return this.roleBenefits;
    }

    /* renamed from: h, reason: from getter */
    public final long getRoleId() {
        return this.roleId;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        long j = this.id;
        long j2 = this.applicationId;
        int i = ((((int) (j ^ (j >>> 32))) * 31) + ((int) (j2 ^ (j2 >>> 32)))) * 31;
        String str = this.name;
        int iHashCode = (i + (str != null ? str.hashCode() : 0)) * 31;
        boolean z2 = this.published;
        int i2 = z2;
        if (z2 != 0) {
            i2 = 1;
        }
        int i3 = (iHashCode + i2) * 31;
        String str2 = this.description;
        int iHashCode2 = (i3 + (str2 != null ? str2.hashCode() : 0)) * 31;
        ImageAsset imageAsset = this.imageAsset;
        int iHashCode3 = (iHashCode2 + (imageAsset != null ? imageAsset.hashCode() : 0)) * 31;
        List<SubscriptionPlan> list = this.subscriptionPlans;
        int iHashCode4 = (iHashCode3 + (list != null ? list.hashCode() : 0)) * 31;
        GuildRoleSubscriptionRoleBenefits guildRoleSubscriptionRoleBenefits = this.roleBenefits;
        int iHashCode5 = (iHashCode4 + (guildRoleSubscriptionRoleBenefits != null ? guildRoleSubscriptionRoleBenefits.hashCode() : 0)) * 31;
        long j3 = this.roleId;
        return iHashCode5 + ((int) (j3 ^ (j3 >>> 32)));
    }

    public final List<SubscriptionPlan> i() {
        return this.subscriptionPlans;
    }

    public String toString() {
        StringBuilder sbU = outline.U("GuildRoleSubscriptionTierListing(id=");
        sbU.append(this.id);
        sbU.append(", applicationId=");
        sbU.append(this.applicationId);
        sbU.append(", name=");
        sbU.append(this.name);
        sbU.append(", published=");
        sbU.append(this.published);
        sbU.append(", description=");
        sbU.append(this.description);
        sbU.append(", imageAsset=");
        sbU.append(this.imageAsset);
        sbU.append(", subscriptionPlans=");
        sbU.append(this.subscriptionPlans);
        sbU.append(", roleBenefits=");
        sbU.append(this.roleBenefits);
        sbU.append(", roleId=");
        return outline.C(sbU, this.roleId, ")");
    }
}
