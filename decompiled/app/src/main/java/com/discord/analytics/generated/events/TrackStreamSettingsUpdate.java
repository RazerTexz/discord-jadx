package com.discord.analytics.generated.events;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: TrackStreamSettingsUpdate.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0014\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u0002J\u0010\u0010\u0004\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u001a\u0010\f\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\tHÖ\u0003¢\u0006\u0004\b\f\u0010\rR\u001b\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001b\u0010\u0013\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0010\u001a\u0004\b\u0014\u0010\u0012R$\u0010\u0016\u001a\u0004\u0018\u00010\u00158\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001b\u0010\u001c\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u0010\u001a\u0004\b\u001d\u0010\u0012R\u001b\u0010\u001e\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b\u001e\u0010\u0010\u001a\u0004\b\u001f\u0010\u0012R\u001b\u0010 \u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b \u0010\u0010\u001a\u0004\b!\u0010\u0012R\u001c\u0010\"\u001a\u00020\u00038\u0016@\u0016X\u0096D¢\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010\u0005R\u001b\u0010%\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b%\u0010\u0010\u001a\u0004\b&\u0010\u0012R\u001b\u0010'\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b'\u0010\u0010\u001a\u0004\b(\u0010\u0012¨\u0006)"}, d2 = {"Lcom/discord/analytics/generated/events/TrackStreamSettingsUpdate;", "Lcom/discord/api/science/AnalyticsSchema;", "Lcom/discord/analytics/generated/traits/TrackBaseReceiver;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "streamQualityPreset", "Ljava/lang/Long;", "getStreamQualityPreset", "()Ljava/lang/Long;", "streamQualityGuildPremiumTier", "getStreamQualityGuildPremiumTier", "Lcom/discord/analytics/generated/traits/TrackBase;", "trackBase", "Lcom/discord/analytics/generated/traits/TrackBase;", "getTrackBase", "()Lcom/discord/analytics/generated/traits/TrackBase;", "setTrackBase", "(Lcom/discord/analytics/generated/traits/TrackBase;)V", "streamQualityResolution", "getStreamQualityResolution", "streamQualityFrameRate", "getStreamQualityFrameRate", "streamQualityUserPremiumTier", "getStreamQualityUserPremiumTier", "analyticsSchemaTypeName", "Ljava/lang/String;", "d", "userPremiumTier", "getUserPremiumTier", "guildPremiumTier", "getGuildPremiumTier", "analytics_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final /* data */ class TrackStreamSettingsUpdate implements AnalyticsSchema, TrackBase2 {
    private TrackBase trackBase;
    private final Long userPremiumTier = null;
    private final Long guildPremiumTier = null;
    private final Long streamQualityUserPremiumTier = null;
    private final Long streamQualityGuildPremiumTier = null;
    private final Long streamQualityPreset = null;
    private final Long streamQualityResolution = null;
    private final Long streamQualityFrameRate = null;
    private final transient String analyticsSchemaTypeName = "stream_settings_update";

    @Override // com.discord.api.science.AnalyticsSchema
    /* renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackStreamSettingsUpdate)) {
            return false;
        }
        TrackStreamSettingsUpdate trackStreamSettingsUpdate = (TrackStreamSettingsUpdate) other;
        return Intrinsics3.areEqual(this.userPremiumTier, trackStreamSettingsUpdate.userPremiumTier) && Intrinsics3.areEqual(this.guildPremiumTier, trackStreamSettingsUpdate.guildPremiumTier) && Intrinsics3.areEqual(this.streamQualityUserPremiumTier, trackStreamSettingsUpdate.streamQualityUserPremiumTier) && Intrinsics3.areEqual(this.streamQualityGuildPremiumTier, trackStreamSettingsUpdate.streamQualityGuildPremiumTier) && Intrinsics3.areEqual(this.streamQualityPreset, trackStreamSettingsUpdate.streamQualityPreset) && Intrinsics3.areEqual(this.streamQualityResolution, trackStreamSettingsUpdate.streamQualityResolution) && Intrinsics3.areEqual(this.streamQualityFrameRate, trackStreamSettingsUpdate.streamQualityFrameRate);
    }

    public int hashCode() {
        Long l = this.userPremiumTier;
        int iHashCode = (l != null ? l.hashCode() : 0) * 31;
        Long l2 = this.guildPremiumTier;
        int iHashCode2 = (iHashCode + (l2 != null ? l2.hashCode() : 0)) * 31;
        Long l3 = this.streamQualityUserPremiumTier;
        int iHashCode3 = (iHashCode2 + (l3 != null ? l3.hashCode() : 0)) * 31;
        Long l4 = this.streamQualityGuildPremiumTier;
        int iHashCode4 = (iHashCode3 + (l4 != null ? l4.hashCode() : 0)) * 31;
        Long l5 = this.streamQualityPreset;
        int iHashCode5 = (iHashCode4 + (l5 != null ? l5.hashCode() : 0)) * 31;
        Long l6 = this.streamQualityResolution;
        int iHashCode6 = (iHashCode5 + (l6 != null ? l6.hashCode() : 0)) * 31;
        Long l7 = this.streamQualityFrameRate;
        return iHashCode6 + (l7 != null ? l7.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackStreamSettingsUpdate(userPremiumTier=");
        sbU.append(this.userPremiumTier);
        sbU.append(", guildPremiumTier=");
        sbU.append(this.guildPremiumTier);
        sbU.append(", streamQualityUserPremiumTier=");
        sbU.append(this.streamQualityUserPremiumTier);
        sbU.append(", streamQualityGuildPremiumTier=");
        sbU.append(this.streamQualityGuildPremiumTier);
        sbU.append(", streamQualityPreset=");
        sbU.append(this.streamQualityPreset);
        sbU.append(", streamQualityResolution=");
        sbU.append(this.streamQualityResolution);
        sbU.append(", streamQualityFrameRate=");
        return outline.G(sbU, this.streamQualityFrameRate, ")");
    }
}
