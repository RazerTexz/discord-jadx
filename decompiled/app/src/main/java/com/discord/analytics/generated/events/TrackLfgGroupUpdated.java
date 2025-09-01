package com.discord.analytics.generated.events;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.analytics.generated.traits.TrackChannel;
import com.discord.analytics.generated.traits.TrackChannel2;
import com.discord.analytics.generated.traits.TrackLfgGroup;
import com.discord.analytics.generated.traits.TrackLfgGroup2;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: TrackLfgGroupUpdated.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u001a\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u000bHÖ\u0003¢\u0006\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0010\u001a\u00020\u00058\u0016@\u0016X\u0096D¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0007R\u001b\u0010\u0013\u001a\u0004\u0018\u00010\r8\u0006@\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R$\u0010\u0018\u001a\u0004\u0018\u00010\u00178\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR$\u0010\u001f\u001a\u0004\u0018\u00010\u001e8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u001b\u0010&\u001a\u0004\u0018\u00010%8\u0006@\u0006¢\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)R\u001b\u0010*\u001a\u0004\u0018\u00010\r8\u0006@\u0006¢\u0006\f\n\u0004\b*\u0010\u0014\u001a\u0004\b+\u0010\u0016R$\u0010-\u001a\u0004\u0018\u00010,8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b-\u0010.\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\u001b\u00103\u001a\u0004\u0018\u00010\r8\u0006@\u0006¢\u0006\f\n\u0004\b3\u0010\u0014\u001a\u0004\b4\u0010\u0016¨\u00065"}, d2 = {"Lcom/discord/analytics/generated/events/TrackLfgGroupUpdated;", "Lcom/discord/api/science/AnalyticsSchema;", "Lcom/discord/analytics/generated/traits/TrackBaseReceiver;", "Lcom/discord/analytics/generated/traits/TrackChannelReceiver;", "Lcom/discord/analytics/generated/traits/TrackLfgGroupReceiver;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "analyticsSchemaTypeName", "Ljava/lang/String;", "d", "updatedSize", "Ljava/lang/Boolean;", "getUpdatedSize", "()Ljava/lang/Boolean;", "Lcom/discord/analytics/generated/traits/TrackChannel;", "trackChannel", "Lcom/discord/analytics/generated/traits/TrackChannel;", "getTrackChannel", "()Lcom/discord/analytics/generated/traits/TrackChannel;", "setTrackChannel", "(Lcom/discord/analytics/generated/traits/TrackChannel;)V", "Lcom/discord/analytics/generated/traits/TrackLfgGroup;", "trackLfgGroup", "Lcom/discord/analytics/generated/traits/TrackLfgGroup;", "getTrackLfgGroup", "()Lcom/discord/analytics/generated/traits/TrackLfgGroup;", "setTrackLfgGroup", "(Lcom/discord/analytics/generated/traits/TrackLfgGroup;)V", "", "previousSize", "Ljava/lang/Long;", "getPreviousSize", "()Ljava/lang/Long;", "updatedTitle", "getUpdatedTitle", "Lcom/discord/analytics/generated/traits/TrackBase;", "trackBase", "Lcom/discord/analytics/generated/traits/TrackBase;", "getTrackBase", "()Lcom/discord/analytics/generated/traits/TrackBase;", "setTrackBase", "(Lcom/discord/analytics/generated/traits/TrackBase;)V", "updatedDescription", "getUpdatedDescription", "analytics_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final /* data */ class TrackLfgGroupUpdated implements AnalyticsSchema, TrackBase2, TrackChannel2, TrackLfgGroup2 {
    private TrackBase trackBase;
    private TrackChannel trackChannel;
    private TrackLfgGroup trackLfgGroup;
    private final Boolean updatedSize = null;
    private final Long previousSize = null;
    private final Boolean updatedTitle = null;
    private final Boolean updatedDescription = null;
    private final transient String analyticsSchemaTypeName = "lfg_group_updated";

    @Override // com.discord.api.science.AnalyticsSchema
    /* renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackLfgGroupUpdated)) {
            return false;
        }
        TrackLfgGroupUpdated trackLfgGroupUpdated = (TrackLfgGroupUpdated) other;
        return Intrinsics3.areEqual(this.updatedSize, trackLfgGroupUpdated.updatedSize) && Intrinsics3.areEqual(this.previousSize, trackLfgGroupUpdated.previousSize) && Intrinsics3.areEqual(this.updatedTitle, trackLfgGroupUpdated.updatedTitle) && Intrinsics3.areEqual(this.updatedDescription, trackLfgGroupUpdated.updatedDescription);
    }

    public int hashCode() {
        Boolean bool = this.updatedSize;
        int iHashCode = (bool != null ? bool.hashCode() : 0) * 31;
        Long l = this.previousSize;
        int iHashCode2 = (iHashCode + (l != null ? l.hashCode() : 0)) * 31;
        Boolean bool2 = this.updatedTitle;
        int iHashCode3 = (iHashCode2 + (bool2 != null ? bool2.hashCode() : 0)) * 31;
        Boolean bool3 = this.updatedDescription;
        return iHashCode3 + (bool3 != null ? bool3.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackLfgGroupUpdated(updatedSize=");
        sbU.append(this.updatedSize);
        sbU.append(", previousSize=");
        sbU.append(this.previousSize);
        sbU.append(", updatedTitle=");
        sbU.append(this.updatedTitle);
        sbU.append(", updatedDescription=");
        return outline.D(sbU, this.updatedDescription, ")");
    }
}
