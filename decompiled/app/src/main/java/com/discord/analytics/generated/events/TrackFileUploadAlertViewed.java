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

/* compiled from: TrackFileUploadAlertViewed.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\r\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u001a\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u000bHÖ\u0003¢\u0006\u0004\b\u000e\u0010\u000fR$\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001b\u0010\u0017\u001a\u0004\u0018\u00010\r8\u0006@\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u001b\u0010\u001b\u001a\u0004\u0018\u00010\r8\u0006@\u0006¢\u0006\f\n\u0004\b\u001b\u0010\u0018\u001a\u0004\b\u001c\u0010\u001aR$\u0010\u001e\u001a\u0004\u0018\u00010\u001d8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001b\u0010%\u001a\u0004\u0018\u00010$8\u0006@\u0006¢\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(R\u001c\u0010)\u001a\u00020\u00058\u0016@\u0016X\u0096D¢\u0006\f\n\u0004\b)\u0010*\u001a\u0004\b+\u0010\u0007R$\u0010-\u001a\u0004\u0018\u00010,8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b-\u0010.\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\u001b\u00104\u001a\u0004\u0018\u0001038\u0006@\u0006¢\u0006\f\n\u0004\b4\u00105\u001a\u0004\b6\u00107R\u001b\u00108\u001a\u0004\u0018\u00010$8\u0006@\u0006¢\u0006\f\n\u0004\b8\u0010&\u001a\u0004\b9\u0010(R\u001b\u0010;\u001a\u0004\u0018\u00010:8\u0006@\u0006¢\u0006\f\n\u0004\b;\u0010<\u001a\u0004\b=\u0010>R\u001b\u0010?\u001a\u0004\u0018\u00010\r8\u0006@\u0006¢\u0006\f\n\u0004\b?\u0010\u0018\u001a\u0004\b@\u0010\u001aR\u001b\u0010A\u001a\u0004\u0018\u00010$8\u0006@\u0006¢\u0006\f\n\u0004\bA\u0010&\u001a\u0004\bB\u0010(R\u001b\u0010C\u001a\u0004\u0018\u00010\r8\u0006@\u0006¢\u0006\f\n\u0004\bC\u0010\u0018\u001a\u0004\bD\u0010\u001aR\u001b\u0010E\u001a\u0004\u0018\u00010\r8\u0006@\u0006¢\u0006\f\n\u0004\bE\u0010\u0018\u001a\u0004\bE\u0010\u001a¨\u0006F"}, d2 = {"Lcom/discord/analytics/generated/events/TrackFileUploadAlertViewed;", "Lcom/discord/api/science/AnalyticsSchema;", "Lcom/discord/analytics/generated/traits/TrackBaseReceiver;", "Lcom/discord/analytics/generated/traits/TrackGuildReceiver;", "Lcom/discord/analytics/generated/traits/TrackChannelReceiver;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/discord/analytics/generated/traits/TrackBase;", "trackBase", "Lcom/discord/analytics/generated/traits/TrackBase;", "getTrackBase", "()Lcom/discord/analytics/generated/traits/TrackBase;", "setTrackBase", "(Lcom/discord/analytics/generated/traits/TrackBase;)V", "previewEnabled", "Ljava/lang/Boolean;", "getPreviewEnabled", "()Ljava/lang/Boolean;", "hasImage", "getHasImage", "Lcom/discord/analytics/generated/traits/TrackChannel;", "trackChannel", "Lcom/discord/analytics/generated/traits/TrackChannel;", "getTrackChannel", "()Lcom/discord/analytics/generated/traits/TrackChannel;", "setTrackChannel", "(Lcom/discord/analytics/generated/traits/TrackChannel;)V", "", "maxAttachmentSize", "Ljava/lang/Long;", "getMaxAttachmentSize", "()Ljava/lang/Long;", "analyticsSchemaTypeName", "Ljava/lang/String;", "d", "Lcom/discord/analytics/generated/traits/TrackGuild;", "trackGuild", "Lcom/discord/analytics/generated/traits/TrackGuild;", "a", "()Lcom/discord/analytics/generated/traits/TrackGuild;", "c", "(Lcom/discord/analytics/generated/traits/TrackGuild;)V", "", "alertType", "Ljava/lang/CharSequence;", "getAlertType", "()Ljava/lang/CharSequence;", "totalAttachmentSize", "getTotalAttachmentSize", "", "imageCompressionQuality", "Ljava/lang/Float;", "getImageCompressionQuality", "()Ljava/lang/Float;", "imageCompressionSettingEnabled", "getImageCompressionSettingEnabled", "numAttachments", "getNumAttachments", "hasVideo", "getHasVideo", "isPremium", "analytics_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final /* data */ class TrackFileUploadAlertViewed implements AnalyticsSchema, TrackBase2, TrackGuild2, TrackChannel2 {
    private TrackBase trackBase;
    private TrackChannel trackChannel;
    private TrackGuild trackGuild;
    private final CharSequence alertType = null;
    private final Long numAttachments = null;
    private final Long maxAttachmentSize = null;
    private final Long totalAttachmentSize = null;
    private final Boolean hasImage = null;
    private final Boolean hasVideo = null;
    private final Boolean isPremium = null;
    private final Float imageCompressionQuality = null;
    private final Boolean imageCompressionSettingEnabled = null;
    private final Boolean previewEnabled = null;
    private final transient String analyticsSchemaTypeName = "file_upload_alert_viewed";

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
        if (!(other instanceof TrackFileUploadAlertViewed)) {
            return false;
        }
        TrackFileUploadAlertViewed trackFileUploadAlertViewed = (TrackFileUploadAlertViewed) other;
        return Intrinsics3.areEqual(this.alertType, trackFileUploadAlertViewed.alertType) && Intrinsics3.areEqual(this.numAttachments, trackFileUploadAlertViewed.numAttachments) && Intrinsics3.areEqual(this.maxAttachmentSize, trackFileUploadAlertViewed.maxAttachmentSize) && Intrinsics3.areEqual(this.totalAttachmentSize, trackFileUploadAlertViewed.totalAttachmentSize) && Intrinsics3.areEqual(this.hasImage, trackFileUploadAlertViewed.hasImage) && Intrinsics3.areEqual(this.hasVideo, trackFileUploadAlertViewed.hasVideo) && Intrinsics3.areEqual(this.isPremium, trackFileUploadAlertViewed.isPremium) && Intrinsics3.areEqual(this.imageCompressionQuality, trackFileUploadAlertViewed.imageCompressionQuality) && Intrinsics3.areEqual(this.imageCompressionSettingEnabled, trackFileUploadAlertViewed.imageCompressionSettingEnabled) && Intrinsics3.areEqual(this.previewEnabled, trackFileUploadAlertViewed.previewEnabled);
    }

    public int hashCode() {
        CharSequence charSequence = this.alertType;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        Long l = this.numAttachments;
        int iHashCode2 = (iHashCode + (l != null ? l.hashCode() : 0)) * 31;
        Long l2 = this.maxAttachmentSize;
        int iHashCode3 = (iHashCode2 + (l2 != null ? l2.hashCode() : 0)) * 31;
        Long l3 = this.totalAttachmentSize;
        int iHashCode4 = (iHashCode3 + (l3 != null ? l3.hashCode() : 0)) * 31;
        Boolean bool = this.hasImage;
        int iHashCode5 = (iHashCode4 + (bool != null ? bool.hashCode() : 0)) * 31;
        Boolean bool2 = this.hasVideo;
        int iHashCode6 = (iHashCode5 + (bool2 != null ? bool2.hashCode() : 0)) * 31;
        Boolean bool3 = this.isPremium;
        int iHashCode7 = (iHashCode6 + (bool3 != null ? bool3.hashCode() : 0)) * 31;
        Float f = this.imageCompressionQuality;
        int iHashCode8 = (iHashCode7 + (f != null ? f.hashCode() : 0)) * 31;
        Boolean bool4 = this.imageCompressionSettingEnabled;
        int iHashCode9 = (iHashCode8 + (bool4 != null ? bool4.hashCode() : 0)) * 31;
        Boolean bool5 = this.previewEnabled;
        return iHashCode9 + (bool5 != null ? bool5.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackFileUploadAlertViewed(alertType=");
        sbU.append(this.alertType);
        sbU.append(", numAttachments=");
        sbU.append(this.numAttachments);
        sbU.append(", maxAttachmentSize=");
        sbU.append(this.maxAttachmentSize);
        sbU.append(", totalAttachmentSize=");
        sbU.append(this.totalAttachmentSize);
        sbU.append(", hasImage=");
        sbU.append(this.hasImage);
        sbU.append(", hasVideo=");
        sbU.append(this.hasVideo);
        sbU.append(", isPremium=");
        sbU.append(this.isPremium);
        sbU.append(", imageCompressionQuality=");
        sbU.append(this.imageCompressionQuality);
        sbU.append(", imageCompressionSettingEnabled=");
        sbU.append(this.imageCompressionSettingEnabled);
        sbU.append(", previewEnabled=");
        return outline.D(sbU, this.previewEnabled, ")");
    }
}
