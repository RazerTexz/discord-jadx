package com.discord.analytics.generated.events;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.analytics.generated.traits.TrackChannel;
import com.discord.analytics.generated.traits.TrackChannel2;
import com.discord.analytics.generated.traits.TrackGuild;
import com.discord.analytics.generated.traits.TrackGuild2;
import com.discord.analytics.generated.traits.TrackOverlayClientMetadata;
import com.discord.analytics.generated.traits.TrackOverlayClientMetadata2;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: TrackGuildViewed.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fHÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0011\u001a\u00020\u00068\u0016@\u0016X\u0096D¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\bR\u001b\u0010\u0015\u001a\u0004\u0018\u00010\u00148\u0006@\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u001b\u0010\u0019\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR$\u0010\u001e\u001a\u0004\u0018\u00010\u001d8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R$\u0010%\u001a\u0004\u0018\u00010$8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u001b\u0010+\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b+\u0010\u001a\u001a\u0004\b+\u0010\u001cR\u001b\u0010,\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b,\u0010\u001a\u001a\u0004\b-\u0010\u001cR\u001b\u0010.\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b.\u0010\u001a\u001a\u0004\b/\u0010\u001cR\u001b\u00100\u001a\u0004\u0018\u00010\u00148\u0006@\u0006¢\u0006\f\n\u0004\b0\u0010\u0016\u001a\u0004\b1\u0010\u0018R$\u00103\u001a\u0004\u0018\u0001028\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b3\u00104\u001a\u0004\b5\u00106\"\u0004\b7\u00108R\u001b\u0010:\u001a\u0004\u0018\u0001098\u0006@\u0006¢\u0006\f\n\u0004\b:\u0010;\u001a\u0004\b<\u0010=R$\u0010?\u001a\u0004\u0018\u00010>8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b?\u0010@\u001a\u0004\bA\u0010B\"\u0004\bC\u0010D¨\u0006E"}, d2 = {"Lcom/discord/analytics/generated/events/TrackGuildViewed;", "Lcom/discord/api/science/AnalyticsSchema;", "Lcom/discord/analytics/generated/traits/TrackBaseReceiver;", "Lcom/discord/analytics/generated/traits/TrackGuildReceiver;", "Lcom/discord/analytics/generated/traits/TrackChannelReceiver;", "Lcom/discord/analytics/generated/traits/TrackOverlayClientMetadataReceiver;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "analyticsSchemaTypeName", "Ljava/lang/String;", "d", "", "guildAffinityIndex", "Ljava/lang/Long;", "getGuildAffinityIndex", "()Ljava/lang/Long;", "viewingStarred", "Ljava/lang/Boolean;", "getViewingStarred", "()Ljava/lang/Boolean;", "Lcom/discord/analytics/generated/traits/TrackChannel;", "trackChannel", "Lcom/discord/analytics/generated/traits/TrackChannel;", "getTrackChannel", "()Lcom/discord/analytics/generated/traits/TrackChannel;", "setTrackChannel", "(Lcom/discord/analytics/generated/traits/TrackChannel;)V", "Lcom/discord/analytics/generated/traits/TrackBase;", "trackBase", "Lcom/discord/analytics/generated/traits/TrackBase;", "getTrackBase", "()Lcom/discord/analytics/generated/traits/TrackBase;", "setTrackBase", "(Lcom/discord/analytics/generated/traits/TrackBase;)V", "isPending", "previewEnabled", "getPreviewEnabled", "premiumProgressBarEnabled", "getPremiumProgressBarEnabled", "postableChannels", "getPostableChannels", "Lcom/discord/analytics/generated/traits/TrackGuild;", "trackGuild", "Lcom/discord/analytics/generated/traits/TrackGuild;", "a", "()Lcom/discord/analytics/generated/traits/TrackGuild;", "c", "(Lcom/discord/analytics/generated/traits/TrackGuild;)V", "", "guildAffinityScore", "Ljava/lang/Float;", "getGuildAffinityScore", "()Ljava/lang/Float;", "Lcom/discord/analytics/generated/traits/TrackOverlayClientMetadata;", "trackOverlayClientMetadata", "Lcom/discord/analytics/generated/traits/TrackOverlayClientMetadata;", "getTrackOverlayClientMetadata", "()Lcom/discord/analytics/generated/traits/TrackOverlayClientMetadata;", "setTrackOverlayClientMetadata", "(Lcom/discord/analytics/generated/traits/TrackOverlayClientMetadata;)V", "analytics_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final /* data */ class TrackGuildViewed implements AnalyticsSchema, TrackBase2, TrackGuild2, TrackChannel2, TrackOverlayClientMetadata2 {
    private TrackBase trackBase;
    private TrackChannel trackChannel;
    private TrackGuild trackGuild;
    private TrackOverlayClientMetadata trackOverlayClientMetadata;
    private final Float guildAffinityScore = null;
    private final Long guildAffinityIndex = null;
    private final Boolean isPending = null;
    private final Boolean previewEnabled = null;
    private final Long postableChannels = null;
    private final Boolean premiumProgressBarEnabled = null;
    private final Boolean viewingStarred = null;
    private final transient String analyticsSchemaTypeName = "guild_viewed";

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
        if (!(other instanceof TrackGuildViewed)) {
            return false;
        }
        TrackGuildViewed trackGuildViewed = (TrackGuildViewed) other;
        return Intrinsics3.areEqual(this.guildAffinityScore, trackGuildViewed.guildAffinityScore) && Intrinsics3.areEqual(this.guildAffinityIndex, trackGuildViewed.guildAffinityIndex) && Intrinsics3.areEqual(this.isPending, trackGuildViewed.isPending) && Intrinsics3.areEqual(this.previewEnabled, trackGuildViewed.previewEnabled) && Intrinsics3.areEqual(this.postableChannels, trackGuildViewed.postableChannels) && Intrinsics3.areEqual(this.premiumProgressBarEnabled, trackGuildViewed.premiumProgressBarEnabled) && Intrinsics3.areEqual(this.viewingStarred, trackGuildViewed.viewingStarred);
    }

    public int hashCode() {
        Float f = this.guildAffinityScore;
        int iHashCode = (f != null ? f.hashCode() : 0) * 31;
        Long l = this.guildAffinityIndex;
        int iHashCode2 = (iHashCode + (l != null ? l.hashCode() : 0)) * 31;
        Boolean bool = this.isPending;
        int iHashCode3 = (iHashCode2 + (bool != null ? bool.hashCode() : 0)) * 31;
        Boolean bool2 = this.previewEnabled;
        int iHashCode4 = (iHashCode3 + (bool2 != null ? bool2.hashCode() : 0)) * 31;
        Long l2 = this.postableChannels;
        int iHashCode5 = (iHashCode4 + (l2 != null ? l2.hashCode() : 0)) * 31;
        Boolean bool3 = this.premiumProgressBarEnabled;
        int iHashCode6 = (iHashCode5 + (bool3 != null ? bool3.hashCode() : 0)) * 31;
        Boolean bool4 = this.viewingStarred;
        return iHashCode6 + (bool4 != null ? bool4.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackGuildViewed(guildAffinityScore=");
        sbU.append(this.guildAffinityScore);
        sbU.append(", guildAffinityIndex=");
        sbU.append(this.guildAffinityIndex);
        sbU.append(", isPending=");
        sbU.append(this.isPending);
        sbU.append(", previewEnabled=");
        sbU.append(this.previewEnabled);
        sbU.append(", postableChannels=");
        sbU.append(this.postableChannels);
        sbU.append(", premiumProgressBarEnabled=");
        sbU.append(this.premiumProgressBarEnabled);
        sbU.append(", viewingStarred=");
        return outline.D(sbU, this.viewingStarred, ")");
    }
}
