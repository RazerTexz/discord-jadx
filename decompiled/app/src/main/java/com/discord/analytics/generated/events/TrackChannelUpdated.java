package com.discord.analytics.generated.events;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.analytics.generated.traits.TrackChannel;
import com.discord.analytics.generated.traits.TrackChannel2;
import com.discord.api.science.AnalyticsSchema;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: TrackChannelUpdated.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\r\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b.\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003J\u0010\u0010\u0005\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\b\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b\b\u0010\tJ\u001a\u0010\r\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\nHÖ\u0003¢\u0006\u0004\b\r\u0010\u000eR$\u0010\u0010\u001a\u0004\u0018\u00010\u000f8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001b\u0010\u0017\u001a\u0004\u0018\u00010\u00168\u0006@\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u001b\u0010\u001c\u001a\u0004\u0018\u00010\u001b8\u0006@\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u001b\u0010 \u001a\u0004\u0018\u00010\u00168\u0006@\u0006¢\u0006\f\n\u0004\b \u0010\u0018\u001a\u0004\b!\u0010\u001aR\u001b\u0010\"\u001a\u0004\u0018\u00010\u00168\u0006@\u0006¢\u0006\f\n\u0004\b\"\u0010\u0018\u001a\u0004\b#\u0010\u001aR\u001b\u0010$\u001a\u0004\u0018\u00010\u00168\u0006@\u0006¢\u0006\f\n\u0004\b$\u0010\u0018\u001a\u0004\b%\u0010\u001aR\u001b\u0010&\u001a\u0004\u0018\u00010\f8\u0006@\u0006¢\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)R\u001b\u0010*\u001a\u0004\u0018\u00010\u00168\u0006@\u0006¢\u0006\f\n\u0004\b*\u0010\u0018\u001a\u0004\b+\u0010\u001aR\u001b\u0010,\u001a\u0004\u0018\u00010\u001b8\u0006@\u0006¢\u0006\f\n\u0004\b,\u0010\u001d\u001a\u0004\b-\u0010\u001fR$\u0010/\u001a\u0004\u0018\u00010.8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b/\u00100\u001a\u0004\b1\u00102\"\u0004\b3\u00104R\u001b\u00105\u001a\u0004\u0018\u00010\f8\u0006@\u0006¢\u0006\f\n\u0004\b5\u0010'\u001a\u0004\b6\u0010)R\u001b\u00107\u001a\u0004\u0018\u00010\u00168\u0006@\u0006¢\u0006\f\n\u0004\b7\u0010\u0018\u001a\u0004\b8\u0010\u001aR\u001b\u00109\u001a\u0004\u0018\u00010\u00168\u0006@\u0006¢\u0006\f\n\u0004\b9\u0010\u0018\u001a\u0004\b:\u0010\u001aR\u001c\u0010;\u001a\u00020\u00048\u0016@\u0016X\u0096D¢\u0006\f\n\u0004\b;\u0010<\u001a\u0004\b=\u0010\u0006R\u001b\u0010>\u001a\u0004\u0018\u00010\f8\u0006@\u0006¢\u0006\f\n\u0004\b>\u0010'\u001a\u0004\b?\u0010)R\u001b\u0010@\u001a\u0004\u0018\u00010\f8\u0006@\u0006¢\u0006\f\n\u0004\b@\u0010'\u001a\u0004\bA\u0010)R\u001b\u0010B\u001a\u0004\u0018\u00010\u00168\u0006@\u0006¢\u0006\f\n\u0004\bB\u0010\u0018\u001a\u0004\bC\u0010\u001aR\u001b\u0010D\u001a\u0004\u0018\u00010\u001b8\u0006@\u0006¢\u0006\f\n\u0004\bD\u0010\u001d\u001a\u0004\bE\u0010\u001fR\u001b\u0010F\u001a\u0004\u0018\u00010\f8\u0006@\u0006¢\u0006\f\n\u0004\bF\u0010'\u001a\u0004\bG\u0010)R\u001b\u0010H\u001a\u0004\u0018\u00010\f8\u0006@\u0006¢\u0006\f\n\u0004\bH\u0010'\u001a\u0004\bI\u0010)R\u001b\u0010J\u001a\u0004\u0018\u00010\u001b8\u0006@\u0006¢\u0006\f\n\u0004\bJ\u0010\u001d\u001a\u0004\bK\u0010\u001fR\u001b\u0010L\u001a\u0004\u0018\u00010\u00168\u0006@\u0006¢\u0006\f\n\u0004\bL\u0010\u0018\u001a\u0004\bM\u0010\u001aR\u001b\u0010N\u001a\u0004\u0018\u00010\u001b8\u0006@\u0006¢\u0006\f\n\u0004\bN\u0010\u001d\u001a\u0004\bO\u0010\u001fR\u001b\u0010P\u001a\u0004\u0018\u00010\f8\u0006@\u0006¢\u0006\f\n\u0004\bP\u0010'\u001a\u0004\bQ\u0010)R\u001b\u0010R\u001a\u0004\u0018\u00010\u001b8\u0006@\u0006¢\u0006\f\n\u0004\bR\u0010\u001d\u001a\u0004\bS\u0010\u001fR\u001b\u0010T\u001a\u0004\u0018\u00010\u001b8\u0006@\u0006¢\u0006\f\n\u0004\bT\u0010\u001d\u001a\u0004\bU\u0010\u001fR\u001b\u0010V\u001a\u0004\u0018\u00010\f8\u0006@\u0006¢\u0006\f\n\u0004\bV\u0010'\u001a\u0004\bW\u0010)R\u001b\u0010X\u001a\u0004\u0018\u00010\u00168\u0006@\u0006¢\u0006\f\n\u0004\bX\u0010\u0018\u001a\u0004\bY\u0010\u001aR\u001b\u0010Z\u001a\u0004\u0018\u00010\u00168\u0006@\u0006¢\u0006\f\n\u0004\bZ\u0010\u0018\u001a\u0004\b[\u0010\u001a¨\u0006\\"}, d2 = {"Lcom/discord/analytics/generated/events/TrackChannelUpdated;", "Lcom/discord/api/science/AnalyticsSchema;", "Lcom/discord/analytics/generated/traits/TrackBaseReceiver;", "Lcom/discord/analytics/generated/traits/TrackChannelReceiver;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/discord/analytics/generated/traits/TrackChannel;", "trackChannel", "Lcom/discord/analytics/generated/traits/TrackChannel;", "getTrackChannel", "()Lcom/discord/analytics/generated/traits/TrackChannel;", "setTrackChannel", "(Lcom/discord/analytics/generated/traits/TrackChannel;)V", "", "guildId", "Ljava/lang/Long;", "getGuildId", "()Ljava/lang/Long;", "", "newName", "Ljava/lang/CharSequence;", "getNewName", "()Ljava/lang/CharSequence;", ModelAuditLogEntry.CHANGE_KEY_BITRATE, "getBitrate", "newAutoArchiveDurationMinutes", "getNewAutoArchiveDurationMinutes", "oldFlags", "getOldFlags", "newInvitable", "Ljava/lang/Boolean;", "getNewInvitable", "()Ljava/lang/Boolean;", "newFlags", "getNewFlags", "rtcRegion", "getRtcRegion", "Lcom/discord/analytics/generated/traits/TrackBase;", "trackBase", "Lcom/discord/analytics/generated/traits/TrackBase;", "getTrackBase", "()Lcom/discord/analytics/generated/traits/TrackBase;", "setTrackBase", "(Lcom/discord/analytics/generated/traits/TrackBase;)V", "oldNsfw", "getOldNsfw", "oldDefaultAutoArchiveDurationMinutes", "getOldDefaultAutoArchiveDurationMinutes", "defaultAutoArchiveDurationMinutes", "getDefaultAutoArchiveDurationMinutes", "analyticsSchemaTypeName", "Ljava/lang/String;", "d", "oldLocked", "getOldLocked", "oldInvitable", "getOldInvitable", "oldAutoArchiveDurationMinutes", "getOldAutoArchiveDurationMinutes", "newBannerHash", "getNewBannerHash", "newLocked", "getNewLocked", "newArchived", "getNewArchived", "guildName", "getGuildName", "oldBitrate", "getOldBitrate", "oldRtcRegion", "getOldRtcRegion", "oldArchived", "getOldArchived", "oldBannerHash", "getOldBannerHash", "oldName", "getOldName", "newNsfw", "getNewNsfw", "videoQualityMode", "getVideoQualityMode", "oldVideoQualityMode", "getOldVideoQualityMode", "analytics_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final /* data */ class TrackChannelUpdated implements AnalyticsSchema, TrackBase2, TrackChannel2 {
    private TrackBase trackBase;
    private TrackChannel trackChannel;
    private final Long guildId = null;
    private final CharSequence guildName = null;
    private final CharSequence oldName = null;
    private final CharSequence newName = null;
    private final Boolean oldNsfw = null;
    private final Boolean newNsfw = null;
    private final Long bitrate = null;
    private final Long oldBitrate = null;
    private final CharSequence rtcRegion = null;
    private final CharSequence oldRtcRegion = null;
    private final Long videoQualityMode = null;
    private final Long oldVideoQualityMode = null;
    private final Long defaultAutoArchiveDurationMinutes = null;
    private final Long oldDefaultAutoArchiveDurationMinutes = null;
    private final Boolean oldArchived = null;
    private final Boolean newArchived = null;
    private final Boolean oldLocked = null;
    private final Boolean newLocked = null;
    private final Boolean oldInvitable = null;
    private final Boolean newInvitable = null;
    private final Long oldAutoArchiveDurationMinutes = null;
    private final Long newAutoArchiveDurationMinutes = null;
    private final CharSequence oldBannerHash = null;
    private final CharSequence newBannerHash = null;
    private final Long oldFlags = null;
    private final Long newFlags = null;
    private final transient String analyticsSchemaTypeName = "channel_updated";

    @Override // com.discord.api.science.AnalyticsSchema
    /* renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackChannelUpdated)) {
            return false;
        }
        TrackChannelUpdated trackChannelUpdated = (TrackChannelUpdated) other;
        return Intrinsics3.areEqual(this.guildId, trackChannelUpdated.guildId) && Intrinsics3.areEqual(this.guildName, trackChannelUpdated.guildName) && Intrinsics3.areEqual(this.oldName, trackChannelUpdated.oldName) && Intrinsics3.areEqual(this.newName, trackChannelUpdated.newName) && Intrinsics3.areEqual(this.oldNsfw, trackChannelUpdated.oldNsfw) && Intrinsics3.areEqual(this.newNsfw, trackChannelUpdated.newNsfw) && Intrinsics3.areEqual(this.bitrate, trackChannelUpdated.bitrate) && Intrinsics3.areEqual(this.oldBitrate, trackChannelUpdated.oldBitrate) && Intrinsics3.areEqual(this.rtcRegion, trackChannelUpdated.rtcRegion) && Intrinsics3.areEqual(this.oldRtcRegion, trackChannelUpdated.oldRtcRegion) && Intrinsics3.areEqual(this.videoQualityMode, trackChannelUpdated.videoQualityMode) && Intrinsics3.areEqual(this.oldVideoQualityMode, trackChannelUpdated.oldVideoQualityMode) && Intrinsics3.areEqual(this.defaultAutoArchiveDurationMinutes, trackChannelUpdated.defaultAutoArchiveDurationMinutes) && Intrinsics3.areEqual(this.oldDefaultAutoArchiveDurationMinutes, trackChannelUpdated.oldDefaultAutoArchiveDurationMinutes) && Intrinsics3.areEqual(this.oldArchived, trackChannelUpdated.oldArchived) && Intrinsics3.areEqual(this.newArchived, trackChannelUpdated.newArchived) && Intrinsics3.areEqual(this.oldLocked, trackChannelUpdated.oldLocked) && Intrinsics3.areEqual(this.newLocked, trackChannelUpdated.newLocked) && Intrinsics3.areEqual(this.oldInvitable, trackChannelUpdated.oldInvitable) && Intrinsics3.areEqual(this.newInvitable, trackChannelUpdated.newInvitable) && Intrinsics3.areEqual(this.oldAutoArchiveDurationMinutes, trackChannelUpdated.oldAutoArchiveDurationMinutes) && Intrinsics3.areEqual(this.newAutoArchiveDurationMinutes, trackChannelUpdated.newAutoArchiveDurationMinutes) && Intrinsics3.areEqual(this.oldBannerHash, trackChannelUpdated.oldBannerHash) && Intrinsics3.areEqual(this.newBannerHash, trackChannelUpdated.newBannerHash) && Intrinsics3.areEqual(this.oldFlags, trackChannelUpdated.oldFlags) && Intrinsics3.areEqual(this.newFlags, trackChannelUpdated.newFlags);
    }

    public int hashCode() {
        Long l = this.guildId;
        int iHashCode = (l != null ? l.hashCode() : 0) * 31;
        CharSequence charSequence = this.guildName;
        int iHashCode2 = (iHashCode + (charSequence != null ? charSequence.hashCode() : 0)) * 31;
        CharSequence charSequence2 = this.oldName;
        int iHashCode3 = (iHashCode2 + (charSequence2 != null ? charSequence2.hashCode() : 0)) * 31;
        CharSequence charSequence3 = this.newName;
        int iHashCode4 = (iHashCode3 + (charSequence3 != null ? charSequence3.hashCode() : 0)) * 31;
        Boolean bool = this.oldNsfw;
        int iHashCode5 = (iHashCode4 + (bool != null ? bool.hashCode() : 0)) * 31;
        Boolean bool2 = this.newNsfw;
        int iHashCode6 = (iHashCode5 + (bool2 != null ? bool2.hashCode() : 0)) * 31;
        Long l2 = this.bitrate;
        int iHashCode7 = (iHashCode6 + (l2 != null ? l2.hashCode() : 0)) * 31;
        Long l3 = this.oldBitrate;
        int iHashCode8 = (iHashCode7 + (l3 != null ? l3.hashCode() : 0)) * 31;
        CharSequence charSequence4 = this.rtcRegion;
        int iHashCode9 = (iHashCode8 + (charSequence4 != null ? charSequence4.hashCode() : 0)) * 31;
        CharSequence charSequence5 = this.oldRtcRegion;
        int iHashCode10 = (iHashCode9 + (charSequence5 != null ? charSequence5.hashCode() : 0)) * 31;
        Long l4 = this.videoQualityMode;
        int iHashCode11 = (iHashCode10 + (l4 != null ? l4.hashCode() : 0)) * 31;
        Long l5 = this.oldVideoQualityMode;
        int iHashCode12 = (iHashCode11 + (l5 != null ? l5.hashCode() : 0)) * 31;
        Long l6 = this.defaultAutoArchiveDurationMinutes;
        int iHashCode13 = (iHashCode12 + (l6 != null ? l6.hashCode() : 0)) * 31;
        Long l7 = this.oldDefaultAutoArchiveDurationMinutes;
        int iHashCode14 = (iHashCode13 + (l7 != null ? l7.hashCode() : 0)) * 31;
        Boolean bool3 = this.oldArchived;
        int iHashCode15 = (iHashCode14 + (bool3 != null ? bool3.hashCode() : 0)) * 31;
        Boolean bool4 = this.newArchived;
        int iHashCode16 = (iHashCode15 + (bool4 != null ? bool4.hashCode() : 0)) * 31;
        Boolean bool5 = this.oldLocked;
        int iHashCode17 = (iHashCode16 + (bool5 != null ? bool5.hashCode() : 0)) * 31;
        Boolean bool6 = this.newLocked;
        int iHashCode18 = (iHashCode17 + (bool6 != null ? bool6.hashCode() : 0)) * 31;
        Boolean bool7 = this.oldInvitable;
        int iHashCode19 = (iHashCode18 + (bool7 != null ? bool7.hashCode() : 0)) * 31;
        Boolean bool8 = this.newInvitable;
        int iHashCode20 = (iHashCode19 + (bool8 != null ? bool8.hashCode() : 0)) * 31;
        Long l8 = this.oldAutoArchiveDurationMinutes;
        int iHashCode21 = (iHashCode20 + (l8 != null ? l8.hashCode() : 0)) * 31;
        Long l9 = this.newAutoArchiveDurationMinutes;
        int iHashCode22 = (iHashCode21 + (l9 != null ? l9.hashCode() : 0)) * 31;
        CharSequence charSequence6 = this.oldBannerHash;
        int iHashCode23 = (iHashCode22 + (charSequence6 != null ? charSequence6.hashCode() : 0)) * 31;
        CharSequence charSequence7 = this.newBannerHash;
        int iHashCode24 = (iHashCode23 + (charSequence7 != null ? charSequence7.hashCode() : 0)) * 31;
        Long l10 = this.oldFlags;
        int iHashCode25 = (iHashCode24 + (l10 != null ? l10.hashCode() : 0)) * 31;
        Long l11 = this.newFlags;
        return iHashCode25 + (l11 != null ? l11.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackChannelUpdated(guildId=");
        sbU.append(this.guildId);
        sbU.append(", guildName=");
        sbU.append(this.guildName);
        sbU.append(", oldName=");
        sbU.append(this.oldName);
        sbU.append(", newName=");
        sbU.append(this.newName);
        sbU.append(", oldNsfw=");
        sbU.append(this.oldNsfw);
        sbU.append(", newNsfw=");
        sbU.append(this.newNsfw);
        sbU.append(", bitrate=");
        sbU.append(this.bitrate);
        sbU.append(", oldBitrate=");
        sbU.append(this.oldBitrate);
        sbU.append(", rtcRegion=");
        sbU.append(this.rtcRegion);
        sbU.append(", oldRtcRegion=");
        sbU.append(this.oldRtcRegion);
        sbU.append(", videoQualityMode=");
        sbU.append(this.videoQualityMode);
        sbU.append(", oldVideoQualityMode=");
        sbU.append(this.oldVideoQualityMode);
        sbU.append(", defaultAutoArchiveDurationMinutes=");
        sbU.append(this.defaultAutoArchiveDurationMinutes);
        sbU.append(", oldDefaultAutoArchiveDurationMinutes=");
        sbU.append(this.oldDefaultAutoArchiveDurationMinutes);
        sbU.append(", oldArchived=");
        sbU.append(this.oldArchived);
        sbU.append(", newArchived=");
        sbU.append(this.newArchived);
        sbU.append(", oldLocked=");
        sbU.append(this.oldLocked);
        sbU.append(", newLocked=");
        sbU.append(this.newLocked);
        sbU.append(", oldInvitable=");
        sbU.append(this.oldInvitable);
        sbU.append(", newInvitable=");
        sbU.append(this.newInvitable);
        sbU.append(", oldAutoArchiveDurationMinutes=");
        sbU.append(this.oldAutoArchiveDurationMinutes);
        sbU.append(", newAutoArchiveDurationMinutes=");
        sbU.append(this.newAutoArchiveDurationMinutes);
        sbU.append(", oldBannerHash=");
        sbU.append(this.oldBannerHash);
        sbU.append(", newBannerHash=");
        sbU.append(this.newBannerHash);
        sbU.append(", oldFlags=");
        sbU.append(this.oldFlags);
        sbU.append(", newFlags=");
        return outline.G(sbU, this.newFlags, ")");
    }
}
