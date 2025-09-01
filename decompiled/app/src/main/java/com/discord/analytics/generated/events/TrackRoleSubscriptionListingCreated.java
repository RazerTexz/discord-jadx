package com.discord.analytics.generated.events;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.analytics.generated.traits.TrackGuild;
import com.discord.analytics.generated.traits.TrackGuild2;
import com.discord.api.science.AnalyticsSchema;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.Intrinsics3;
import java.util.List;
import kotlin.Metadata;

/* compiled from: TrackRoleSubscriptionListingCreated.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\r\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003J\u0010\u0010\u0005\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\b\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b\b\u0010\tJ\u001a\u0010\r\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\nHÖ\u0003¢\u0006\u0004\b\r\u0010\u000eR\u001b\u0010\u000f\u001a\u0004\u0018\u00010\f8\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R!\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u00138\u0006@\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R#\u0010\u001a\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0019\u0018\u00010\u00138\u0006@\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u0016\u001a\u0004\b\u001b\u0010\u0018R\u001b\u0010\u001c\u001a\u0004\u0018\u00010\u00148\u0006@\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR$\u0010!\u001a\u0004\u0018\u00010 8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u001b\u0010'\u001a\u0004\u0018\u00010\u00148\u0006@\u0006¢\u0006\f\n\u0004\b'\u0010\u001d\u001a\u0004\b(\u0010\u001fR\u001c\u0010)\u001a\u00020\u00048\u0016@\u0016X\u0096D¢\u0006\f\n\u0004\b)\u0010*\u001a\u0004\b+\u0010\u0006R\u001b\u0010,\u001a\u0004\u0018\u00010\u00148\u0006@\u0006¢\u0006\f\n\u0004\b,\u0010\u001d\u001a\u0004\b-\u0010\u001fR\u001b\u0010.\u001a\u0004\u0018\u00010\u00148\u0006@\u0006¢\u0006\f\n\u0004\b.\u0010\u001d\u001a\u0004\b/\u0010\u001fR$\u00101\u001a\u0004\u0018\u0001008\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b1\u00102\u001a\u0004\b3\u00104\"\u0004\b5\u00106R\u001b\u00107\u001a\u0004\u0018\u00010\u00198\u0006@\u0006¢\u0006\f\n\u0004\b7\u00108\u001a\u0004\b9\u0010:¨\u0006;"}, d2 = {"Lcom/discord/analytics/generated/events/TrackRoleSubscriptionListingCreated;", "Lcom/discord/api/science/AnalyticsSchema;", "Lcom/discord/analytics/generated/traits/TrackBaseReceiver;", "Lcom/discord/analytics/generated/traits/TrackGuildReceiver;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "published", "Ljava/lang/Boolean;", "getPublished", "()Ljava/lang/Boolean;", "", "", "channelBenefitIds", "Ljava/util/List;", "getChannelBenefitIds", "()Ljava/util/List;", "", "intangibleBenefitNames", "getIntangibleBenefitNames", "roleId", "Ljava/lang/Long;", "getRoleId", "()Ljava/lang/Long;", "Lcom/discord/analytics/generated/traits/TrackGuild;", "trackGuild", "Lcom/discord/analytics/generated/traits/TrackGuild;", "a", "()Lcom/discord/analytics/generated/traits/TrackGuild;", "c", "(Lcom/discord/analytics/generated/traits/TrackGuild;)V", "roleSubscriptionListingId", "getRoleSubscriptionListingId", "analyticsSchemaTypeName", "Ljava/lang/String;", "d", "roleSubscriptionGroupListingId", "getRoleSubscriptionGroupListingId", "priceTier", "getPriceTier", "Lcom/discord/analytics/generated/traits/TrackBase;", "trackBase", "Lcom/discord/analytics/generated/traits/TrackBase;", "getTrackBase", "()Lcom/discord/analytics/generated/traits/TrackBase;", "setTrackBase", "(Lcom/discord/analytics/generated/traits/TrackBase;)V", ModelAuditLogEntry.CHANGE_KEY_NAME, "Ljava/lang/CharSequence;", "getName", "()Ljava/lang/CharSequence;", "analytics_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final /* data */ class TrackRoleSubscriptionListingCreated implements AnalyticsSchema, TrackBase2, TrackGuild2 {
    private TrackBase trackBase;
    private TrackGuild trackGuild;
    private final Long roleSubscriptionListingId = null;
    private final CharSequence name = null;
    private final Long roleSubscriptionGroupListingId = null;
    private final Boolean published = null;
    private final List<Long> channelBenefitIds = null;
    private final Long roleId = null;
    private final List<CharSequence> intangibleBenefitNames = null;
    private final Long priceTier = null;
    private final transient String analyticsSchemaTypeName = "role_subscription_listing_created";

    @Override // com.discord.analytics.generated.traits.TrackGuild2
    /* renamed from: a, reason: from getter */
    public TrackGuild getTrackGuild() {
        return this.trackGuild;
    }

    @Override // com.discord.analytics.generated.traits.TrackGuild2
    public void c(TrackGuild trackGuild) {
        this.trackGuild = trackGuild;
    }

    @Override // com.discord.api.science.AnalyticsSchema
    /* renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackRoleSubscriptionListingCreated)) {
            return false;
        }
        TrackRoleSubscriptionListingCreated trackRoleSubscriptionListingCreated = (TrackRoleSubscriptionListingCreated) other;
        return Intrinsics3.areEqual(this.roleSubscriptionListingId, trackRoleSubscriptionListingCreated.roleSubscriptionListingId) && Intrinsics3.areEqual(this.name, trackRoleSubscriptionListingCreated.name) && Intrinsics3.areEqual(this.roleSubscriptionGroupListingId, trackRoleSubscriptionListingCreated.roleSubscriptionGroupListingId) && Intrinsics3.areEqual(this.published, trackRoleSubscriptionListingCreated.published) && Intrinsics3.areEqual(this.channelBenefitIds, trackRoleSubscriptionListingCreated.channelBenefitIds) && Intrinsics3.areEqual(this.roleId, trackRoleSubscriptionListingCreated.roleId) && Intrinsics3.areEqual(this.intangibleBenefitNames, trackRoleSubscriptionListingCreated.intangibleBenefitNames) && Intrinsics3.areEqual(this.priceTier, trackRoleSubscriptionListingCreated.priceTier);
    }

    public int hashCode() {
        Long l = this.roleSubscriptionListingId;
        int iHashCode = (l != null ? l.hashCode() : 0) * 31;
        CharSequence charSequence = this.name;
        int iHashCode2 = (iHashCode + (charSequence != null ? charSequence.hashCode() : 0)) * 31;
        Long l2 = this.roleSubscriptionGroupListingId;
        int iHashCode3 = (iHashCode2 + (l2 != null ? l2.hashCode() : 0)) * 31;
        Boolean bool = this.published;
        int iHashCode4 = (iHashCode3 + (bool != null ? bool.hashCode() : 0)) * 31;
        List<Long> list = this.channelBenefitIds;
        int iHashCode5 = (iHashCode4 + (list != null ? list.hashCode() : 0)) * 31;
        Long l3 = this.roleId;
        int iHashCode6 = (iHashCode5 + (l3 != null ? l3.hashCode() : 0)) * 31;
        List<CharSequence> list2 = this.intangibleBenefitNames;
        int iHashCode7 = (iHashCode6 + (list2 != null ? list2.hashCode() : 0)) * 31;
        Long l4 = this.priceTier;
        return iHashCode7 + (l4 != null ? l4.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackRoleSubscriptionListingCreated(roleSubscriptionListingId=");
        sbU.append(this.roleSubscriptionListingId);
        sbU.append(", name=");
        sbU.append(this.name);
        sbU.append(", roleSubscriptionGroupListingId=");
        sbU.append(this.roleSubscriptionGroupListingId);
        sbU.append(", published=");
        sbU.append(this.published);
        sbU.append(", channelBenefitIds=");
        sbU.append(this.channelBenefitIds);
        sbU.append(", roleId=");
        sbU.append(this.roleId);
        sbU.append(", intangibleBenefitNames=");
        sbU.append(this.intangibleBenefitNames);
        sbU.append(", priceTier=");
        return outline.G(sbU, this.priceTier, ")");
    }
}
