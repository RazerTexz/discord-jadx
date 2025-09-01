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

/* compiled from: TrackFailedMessageResolved.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\f\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u001a\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u000bHÖ\u0003¢\u0006\u0004\b\u000e\u0010\u000fR\u001b\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001b\u0010\u0015\u001a\u0004\u0018\u00010\r8\u0006@\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u001b\u0010\u0019\u001a\u0004\u0018\u00010\r8\u0006@\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u0016\u001a\u0004\b\u001a\u0010\u0018R\u001b\u0010\u001b\u001a\u0004\u0018\u00010\r8\u0006@\u0006¢\u0006\f\n\u0004\b\u001b\u0010\u0016\u001a\u0004\b\u001c\u0010\u0018R\u001b\u0010\u001e\u001a\u0004\u0018\u00010\u001d8\u0006@\u0006¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!R\u001b\u0010\"\u001a\u0004\u0018\u00010\u001d8\u0006@\u0006¢\u0006\f\n\u0004\b\"\u0010\u001f\u001a\u0004\b#\u0010!R\u001b\u0010$\u001a\u0004\u0018\u00010\u001d8\u0006@\u0006¢\u0006\f\n\u0004\b$\u0010\u001f\u001a\u0004\b%\u0010!R$\u0010'\u001a\u0004\u0018\u00010&8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\u001b\u0010-\u001a\u0004\u0018\u00010\u001d8\u0006@\u0006¢\u0006\f\n\u0004\b-\u0010\u001f\u001a\u0004\b.\u0010!R\u001c\u0010/\u001a\u00020\u00058\u0016@\u0016X\u0096D¢\u0006\f\n\u0004\b/\u00100\u001a\u0004\b1\u0010\u0007R!\u00103\u001a\n\u0018\u00010\u001dj\u0004\u0018\u0001`28\u0006@\u0006¢\u0006\f\n\u0004\b3\u0010\u001f\u001a\u0004\b4\u0010!R$\u00106\u001a\u0004\u0018\u0001058\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b6\u00107\u001a\u0004\b8\u00109\"\u0004\b:\u0010;R$\u0010=\u001a\u0004\u0018\u00010<8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b=\u0010>\u001a\u0004\b?\u0010@\"\u0004\bA\u0010B¨\u0006C"}, d2 = {"Lcom/discord/analytics/generated/events/TrackFailedMessageResolved;", "Lcom/discord/api/science/AnalyticsSchema;", "Lcom/discord/analytics/generated/traits/TrackBaseReceiver;", "Lcom/discord/analytics/generated/traits/TrackGuildReceiver;", "Lcom/discord/analytics/generated/traits/TrackChannelReceiver;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "resolutionType", "Ljava/lang/CharSequence;", "getResolutionType", "()Ljava/lang/CharSequence;", "hasVideo", "Ljava/lang/Boolean;", "getHasVideo", "()Ljava/lang/Boolean;", "previewEnabled", "getPreviewEnabled", "hasImage", "getHasImage", "", "totalAttachmentSize", "Ljava/lang/Long;", "getTotalAttachmentSize", "()Ljava/lang/Long;", "maxAttachmentSize", "getMaxAttachmentSize", "numRetries", "getNumRetries", "Lcom/discord/analytics/generated/traits/TrackChannel;", "trackChannel", "Lcom/discord/analytics/generated/traits/TrackChannel;", "getTrackChannel", "()Lcom/discord/analytics/generated/traits/TrackChannel;", "setTrackChannel", "(Lcom/discord/analytics/generated/traits/TrackChannel;)V", "numAttachments", "getNumAttachments", "analyticsSchemaTypeName", "Ljava/lang/String;", "d", "Lcom/discord/primitives/Timestamp;", "initialAttemptTs", "getInitialAttemptTs", "Lcom/discord/analytics/generated/traits/TrackBase;", "trackBase", "Lcom/discord/analytics/generated/traits/TrackBase;", "getTrackBase", "()Lcom/discord/analytics/generated/traits/TrackBase;", "setTrackBase", "(Lcom/discord/analytics/generated/traits/TrackBase;)V", "Lcom/discord/analytics/generated/traits/TrackGuild;", "trackGuild", "Lcom/discord/analytics/generated/traits/TrackGuild;", "a", "()Lcom/discord/analytics/generated/traits/TrackGuild;", "c", "(Lcom/discord/analytics/generated/traits/TrackGuild;)V", "analytics_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final /* data */ class TrackFailedMessageResolved implements AnalyticsSchema, TrackBase2, TrackGuild2, TrackChannel2 {
    private TrackBase trackBase;
    private TrackChannel trackChannel;
    private TrackGuild trackGuild;
    private final Long numAttachments = null;
    private final Long maxAttachmentSize = null;
    private final Long totalAttachmentSize = null;
    private final Boolean hasImage = null;
    private final Boolean hasVideo = null;
    private final CharSequence resolutionType = null;
    private final Long initialAttemptTs = null;
    private final Long numRetries = null;
    private final Boolean previewEnabled = null;
    private final transient String analyticsSchemaTypeName = "failed_message_resolved";

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
        if (!(other instanceof TrackFailedMessageResolved)) {
            return false;
        }
        TrackFailedMessageResolved trackFailedMessageResolved = (TrackFailedMessageResolved) other;
        return Intrinsics3.areEqual(this.numAttachments, trackFailedMessageResolved.numAttachments) && Intrinsics3.areEqual(this.maxAttachmentSize, trackFailedMessageResolved.maxAttachmentSize) && Intrinsics3.areEqual(this.totalAttachmentSize, trackFailedMessageResolved.totalAttachmentSize) && Intrinsics3.areEqual(this.hasImage, trackFailedMessageResolved.hasImage) && Intrinsics3.areEqual(this.hasVideo, trackFailedMessageResolved.hasVideo) && Intrinsics3.areEqual(this.resolutionType, trackFailedMessageResolved.resolutionType) && Intrinsics3.areEqual(this.initialAttemptTs, trackFailedMessageResolved.initialAttemptTs) && Intrinsics3.areEqual(this.numRetries, trackFailedMessageResolved.numRetries) && Intrinsics3.areEqual(this.previewEnabled, trackFailedMessageResolved.previewEnabled);
    }

    public int hashCode() {
        Long l = this.numAttachments;
        int iHashCode = (l != null ? l.hashCode() : 0) * 31;
        Long l2 = this.maxAttachmentSize;
        int iHashCode2 = (iHashCode + (l2 != null ? l2.hashCode() : 0)) * 31;
        Long l3 = this.totalAttachmentSize;
        int iHashCode3 = (iHashCode2 + (l3 != null ? l3.hashCode() : 0)) * 31;
        Boolean bool = this.hasImage;
        int iHashCode4 = (iHashCode3 + (bool != null ? bool.hashCode() : 0)) * 31;
        Boolean bool2 = this.hasVideo;
        int iHashCode5 = (iHashCode4 + (bool2 != null ? bool2.hashCode() : 0)) * 31;
        CharSequence charSequence = this.resolutionType;
        int iHashCode6 = (iHashCode5 + (charSequence != null ? charSequence.hashCode() : 0)) * 31;
        Long l4 = this.initialAttemptTs;
        int iHashCode7 = (iHashCode6 + (l4 != null ? l4.hashCode() : 0)) * 31;
        Long l5 = this.numRetries;
        int iHashCode8 = (iHashCode7 + (l5 != null ? l5.hashCode() : 0)) * 31;
        Boolean bool3 = this.previewEnabled;
        return iHashCode8 + (bool3 != null ? bool3.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackFailedMessageResolved(numAttachments=");
        sbU.append(this.numAttachments);
        sbU.append(", maxAttachmentSize=");
        sbU.append(this.maxAttachmentSize);
        sbU.append(", totalAttachmentSize=");
        sbU.append(this.totalAttachmentSize);
        sbU.append(", hasImage=");
        sbU.append(this.hasImage);
        sbU.append(", hasVideo=");
        sbU.append(this.hasVideo);
        sbU.append(", resolutionType=");
        sbU.append(this.resolutionType);
        sbU.append(", initialAttemptTs=");
        sbU.append(this.initialAttemptTs);
        sbU.append(", numRetries=");
        sbU.append(this.numRetries);
        sbU.append(", previewEnabled=");
        return outline.D(sbU, this.previewEnabled, ")");
    }
}
