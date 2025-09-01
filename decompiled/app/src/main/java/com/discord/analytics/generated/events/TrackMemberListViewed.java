package com.discord.analytics.generated.events;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.analytics.generated.traits.TrackChannel;
import com.discord.analytics.generated.traits.TrackChannel2;
import com.discord.analytics.generated.traits.TrackGuild;
import com.discord.analytics.generated.traits.TrackGuild2;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: TrackMemberListViewed.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0012\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u001a\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u000bHÖ\u0003¢\u0006\u0004\b\u000e\u0010\u000fR$\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R$\u0010\u0018\u001a\u0004\u0018\u00010\u00178\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR$\u0010\u001f\u001a\u0004\u0018\u00010\u001e8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u001b\u0010&\u001a\u0004\u0018\u00010%8\u0006@\u0006¢\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)R\u001b\u0010*\u001a\u0004\u0018\u00010\r8\u0006@\u0006¢\u0006\f\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-R\u001b\u0010.\u001a\u0004\u0018\u00010%8\u0006@\u0006¢\u0006\f\n\u0004\b.\u0010'\u001a\u0004\b/\u0010)R\u001b\u00100\u001a\u0004\u0018\u00010%8\u0006@\u0006¢\u0006\f\n\u0004\b0\u0010'\u001a\u0004\b1\u0010)R\u001b\u00102\u001a\u0004\u0018\u00010%8\u0006@\u0006¢\u0006\f\n\u0004\b2\u0010'\u001a\u0004\b3\u0010)R\u001c\u00104\u001a\u00020\u00058\u0016@\u0016X\u0096D¢\u0006\f\n\u0004\b4\u00105\u001a\u0004\b6\u0010\u0007¨\u00067"}, d2 = {"Lcom/discord/analytics/generated/events/TrackMemberListViewed;", "Lcom/discord/api/science/AnalyticsSchema;", "Lcom/discord/analytics/generated/traits/TrackBaseReceiver;", "Lcom/discord/analytics/generated/traits/TrackGuildReceiver;", "Lcom/discord/analytics/generated/traits/TrackChannelReceiver;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/discord/analytics/generated/traits/TrackGuild;", "trackGuild", "Lcom/discord/analytics/generated/traits/TrackGuild;", "a", "()Lcom/discord/analytics/generated/traits/TrackGuild;", "c", "(Lcom/discord/analytics/generated/traits/TrackGuild;)V", "Lcom/discord/analytics/generated/traits/TrackBase;", "trackBase", "Lcom/discord/analytics/generated/traits/TrackBase;", "getTrackBase", "()Lcom/discord/analytics/generated/traits/TrackBase;", "setTrackBase", "(Lcom/discord/analytics/generated/traits/TrackBase;)V", "Lcom/discord/analytics/generated/traits/TrackChannel;", "trackChannel", "Lcom/discord/analytics/generated/traits/TrackChannel;", "getTrackChannel", "()Lcom/discord/analytics/generated/traits/TrackChannel;", "setTrackChannel", "(Lcom/discord/analytics/generated/traits/TrackChannel;)V", "", "numUsersVisibleWithActivity", "Ljava/lang/Long;", "getNumUsersVisibleWithActivity", "()Ljava/lang/Long;", "hasAddMembersCta", "Ljava/lang/Boolean;", "getHasAddMembersCta", "()Ljava/lang/Boolean;", "numUsersVisible", "getNumUsersVisible", "numUsersVisibleWithMobileIndicator", "getNumUsersVisibleWithMobileIndicator", "numUsersVisibleWithGameActivity", "getNumUsersVisibleWithGameActivity", "analyticsSchemaTypeName", "Ljava/lang/String;", "d", "analytics_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final /* data */ class TrackMemberListViewed implements AnalyticsSchema, TrackBase2, TrackGuild2, TrackChannel2 {
    private TrackBase trackBase;
    private TrackChannel trackChannel;
    private TrackGuild trackGuild;
    private final Long numUsersVisible = null;
    private final Long numUsersVisibleWithMobileIndicator = null;
    private final Long numUsersVisibleWithGameActivity = null;
    private final Long numUsersVisibleWithActivity = null;
    private final Boolean hasAddMembersCta = null;
    private final transient String analyticsSchemaTypeName = "member_list_viewed";

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
        if (!(other instanceof TrackMemberListViewed)) {
            return false;
        }
        TrackMemberListViewed trackMemberListViewed = (TrackMemberListViewed) other;
        return Intrinsics3.areEqual(this.numUsersVisible, trackMemberListViewed.numUsersVisible) && Intrinsics3.areEqual(this.numUsersVisibleWithMobileIndicator, trackMemberListViewed.numUsersVisibleWithMobileIndicator) && Intrinsics3.areEqual(this.numUsersVisibleWithGameActivity, trackMemberListViewed.numUsersVisibleWithGameActivity) && Intrinsics3.areEqual(this.numUsersVisibleWithActivity, trackMemberListViewed.numUsersVisibleWithActivity) && Intrinsics3.areEqual(this.hasAddMembersCta, trackMemberListViewed.hasAddMembersCta);
    }

    public int hashCode() {
        Long l = this.numUsersVisible;
        int iHashCode = (l != null ? l.hashCode() : 0) * 31;
        Long l2 = this.numUsersVisibleWithMobileIndicator;
        int iHashCode2 = (iHashCode + (l2 != null ? l2.hashCode() : 0)) * 31;
        Long l3 = this.numUsersVisibleWithGameActivity;
        int iHashCode3 = (iHashCode2 + (l3 != null ? l3.hashCode() : 0)) * 31;
        Long l4 = this.numUsersVisibleWithActivity;
        int iHashCode4 = (iHashCode3 + (l4 != null ? l4.hashCode() : 0)) * 31;
        Boolean bool = this.hasAddMembersCta;
        return iHashCode4 + (bool != null ? bool.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackMemberListViewed(numUsersVisible=");
        sbU.append(this.numUsersVisible);
        sbU.append(", numUsersVisibleWithMobileIndicator=");
        sbU.append(this.numUsersVisibleWithMobileIndicator);
        sbU.append(", numUsersVisibleWithGameActivity=");
        sbU.append(this.numUsersVisibleWithGameActivity);
        sbU.append(", numUsersVisibleWithActivity=");
        sbU.append(this.numUsersVisibleWithActivity);
        sbU.append(", hasAddMembersCta=");
        return outline.D(sbU, this.hasAddMembersCta, ")");
    }
}
