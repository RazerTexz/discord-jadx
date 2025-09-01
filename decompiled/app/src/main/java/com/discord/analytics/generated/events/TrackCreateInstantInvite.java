package com.discord.analytics.generated.events;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.api.science.AnalyticsSchema;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: TrackCreateInstantInvite.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\r\n\u0002\b\u0015\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u0002J\u0010\u0010\u0004\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u001a\u0010\f\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\tHÖ\u0003¢\u0006\u0004\b\f\u0010\rR$\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001b\u0010\u0016\u001a\u0004\u0018\u00010\u00158\u0006@\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u001c\u0010\u001a\u001a\u00020\u00038\u0016@\u0016X\u0096D¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u0005R\u001b\u0010\u001d\u001a\u0004\u0018\u00010\u00158\u0006@\u0006¢\u0006\f\n\u0004\b\u001d\u0010\u0017\u001a\u0004\b\u001e\u0010\u0019R\u001b\u0010 \u001a\u0004\u0018\u00010\u001f8\u0006@\u0006¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#R\u001b\u0010$\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'R\u001b\u0010(\u001a\u0004\u0018\u00010\u00158\u0006@\u0006¢\u0006\f\n\u0004\b(\u0010\u0017\u001a\u0004\b)\u0010\u0019R\u001b\u0010*\u001a\u0004\u0018\u00010\u00158\u0006@\u0006¢\u0006\f\n\u0004\b*\u0010\u0017\u001a\u0004\b+\u0010\u0019R\u001b\u0010,\u001a\u0004\u0018\u00010\u00158\u0006@\u0006¢\u0006\f\n\u0004\b,\u0010\u0017\u001a\u0004\b-\u0010\u0019R\u001b\u0010.\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b.\u0010%\u001a\u0004\b/\u0010'R\u001b\u00100\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b0\u0010%\u001a\u0004\b1\u0010'R\u001b\u00102\u001a\u0004\u0018\u00010\u00158\u0006@\u0006¢\u0006\f\n\u0004\b2\u0010\u0017\u001a\u0004\b3\u0010\u0019¨\u00064"}, d2 = {"Lcom/discord/analytics/generated/events/TrackCreateInstantInvite;", "Lcom/discord/api/science/AnalyticsSchema;", "Lcom/discord/analytics/generated/traits/TrackBaseReceiver;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/discord/analytics/generated/traits/TrackBase;", "trackBase", "Lcom/discord/analytics/generated/traits/TrackBase;", "getTrackBase", "()Lcom/discord/analytics/generated/traits/TrackBase;", "setTrackBase", "(Lcom/discord/analytics/generated/traits/TrackBase;)V", "", "channelType", "Ljava/lang/Long;", "getChannelType", "()Ljava/lang/Long;", "analyticsSchemaTypeName", "Ljava/lang/String;", "d", "maxUses", "getMaxUses", "", ModelAuditLogEntry.CHANGE_KEY_CODE, "Ljava/lang/CharSequence;", "getCode", "()Ljava/lang/CharSequence;", "unique", "Ljava/lang/Boolean;", "getUnique", "()Ljava/lang/Boolean;", "maxAge", "getMaxAge", "guildId", "getGuildId", "channelId", "getChannelId", ModelAuditLogEntry.CHANGE_KEY_TEMPORARY, "getTemporary", "regenerate", "getRegenerate", "inviteType", "getInviteType", "analytics_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final /* data */ class TrackCreateInstantInvite implements AnalyticsSchema, TrackBase2 {
    private TrackBase trackBase;
    private final Boolean temporary = null;
    private final Long maxUses = null;
    private final Long maxAge = null;
    private final Boolean regenerate = null;
    private final Boolean unique = null;
    private final CharSequence code = null;
    private final Long guildId = null;
    private final Long channelId = null;
    private final Long channelType = null;
    private final Long inviteType = null;
    private final transient String analyticsSchemaTypeName = "create_instant_invite";

    @Override // com.discord.api.science.AnalyticsSchema
    /* renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackCreateInstantInvite)) {
            return false;
        }
        TrackCreateInstantInvite trackCreateInstantInvite = (TrackCreateInstantInvite) other;
        return Intrinsics3.areEqual(this.temporary, trackCreateInstantInvite.temporary) && Intrinsics3.areEqual(this.maxUses, trackCreateInstantInvite.maxUses) && Intrinsics3.areEqual(this.maxAge, trackCreateInstantInvite.maxAge) && Intrinsics3.areEqual(this.regenerate, trackCreateInstantInvite.regenerate) && Intrinsics3.areEqual(this.unique, trackCreateInstantInvite.unique) && Intrinsics3.areEqual(this.code, trackCreateInstantInvite.code) && Intrinsics3.areEqual(this.guildId, trackCreateInstantInvite.guildId) && Intrinsics3.areEqual(this.channelId, trackCreateInstantInvite.channelId) && Intrinsics3.areEqual(this.channelType, trackCreateInstantInvite.channelType) && Intrinsics3.areEqual(this.inviteType, trackCreateInstantInvite.inviteType);
    }

    public int hashCode() {
        Boolean bool = this.temporary;
        int iHashCode = (bool != null ? bool.hashCode() : 0) * 31;
        Long l = this.maxUses;
        int iHashCode2 = (iHashCode + (l != null ? l.hashCode() : 0)) * 31;
        Long l2 = this.maxAge;
        int iHashCode3 = (iHashCode2 + (l2 != null ? l2.hashCode() : 0)) * 31;
        Boolean bool2 = this.regenerate;
        int iHashCode4 = (iHashCode3 + (bool2 != null ? bool2.hashCode() : 0)) * 31;
        Boolean bool3 = this.unique;
        int iHashCode5 = (iHashCode4 + (bool3 != null ? bool3.hashCode() : 0)) * 31;
        CharSequence charSequence = this.code;
        int iHashCode6 = (iHashCode5 + (charSequence != null ? charSequence.hashCode() : 0)) * 31;
        Long l3 = this.guildId;
        int iHashCode7 = (iHashCode6 + (l3 != null ? l3.hashCode() : 0)) * 31;
        Long l4 = this.channelId;
        int iHashCode8 = (iHashCode7 + (l4 != null ? l4.hashCode() : 0)) * 31;
        Long l5 = this.channelType;
        int iHashCode9 = (iHashCode8 + (l5 != null ? l5.hashCode() : 0)) * 31;
        Long l6 = this.inviteType;
        return iHashCode9 + (l6 != null ? l6.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackCreateInstantInvite(temporary=");
        sbU.append(this.temporary);
        sbU.append(", maxUses=");
        sbU.append(this.maxUses);
        sbU.append(", maxAge=");
        sbU.append(this.maxAge);
        sbU.append(", regenerate=");
        sbU.append(this.regenerate);
        sbU.append(", unique=");
        sbU.append(this.unique);
        sbU.append(", code=");
        sbU.append(this.code);
        sbU.append(", guildId=");
        sbU.append(this.guildId);
        sbU.append(", channelId=");
        sbU.append(this.channelId);
        sbU.append(", channelType=");
        sbU.append(this.channelType);
        sbU.append(", inviteType=");
        return outline.G(sbU, this.inviteType, ")");
    }
}
