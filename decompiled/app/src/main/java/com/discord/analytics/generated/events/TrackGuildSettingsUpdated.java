package com.discord.analytics.generated.events;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.api.science.AnalyticsSchema;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: TrackGuildSettingsUpdated.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\r\n\u0002\b!\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u0002J\u0010\u0010\u0004\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u001a\u0010\f\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\tHÖ\u0003¢\u0006\u0004\b\f\u0010\rR\u001b\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001b\u0010\u0013\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0010\u001a\u0004\b\u0014\u0010\u0012R\u001b\u0010\u0016\u001a\u0004\u0018\u00010\u00158\u0006@\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u001b\u0010\u001a\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u001b\u0010\u001e\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\u001e\u0010\u001b\u001a\u0004\b\u001f\u0010\u001dR\u001b\u0010 \u001a\u0004\u0018\u00010\u00158\u0006@\u0006¢\u0006\f\n\u0004\b \u0010\u0017\u001a\u0004\b!\u0010\u0019R\u001b\u0010\"\u001a\u0004\u0018\u00010\u00158\u0006@\u0006¢\u0006\f\n\u0004\b\"\u0010\u0017\u001a\u0004\b#\u0010\u0019R\u001b\u0010$\u001a\u0004\u0018\u00010\u00158\u0006@\u0006¢\u0006\f\n\u0004\b$\u0010\u0017\u001a\u0004\b%\u0010\u0019R\u001b\u0010&\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b&\u0010\u001b\u001a\u0004\b'\u0010\u001dR\u001b\u0010(\u001a\u0004\u0018\u00010\u00158\u0006@\u0006¢\u0006\f\n\u0004\b(\u0010\u0017\u001a\u0004\b)\u0010\u0019R\u001b\u0010*\u001a\u0004\u0018\u00010\u00158\u0006@\u0006¢\u0006\f\n\u0004\b*\u0010\u0017\u001a\u0004\b+\u0010\u0019R\u001b\u0010,\u001a\u0004\u0018\u00010\u00158\u0006@\u0006¢\u0006\f\n\u0004\b,\u0010\u0017\u001a\u0004\b-\u0010\u0019R\u001c\u0010.\u001a\u00020\u00038\u0016@\u0016X\u0096D¢\u0006\f\n\u0004\b.\u0010/\u001a\u0004\b0\u0010\u0005R\u001b\u00101\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b1\u0010\u0010\u001a\u0004\b2\u0010\u0012R\u001b\u00103\u001a\u0004\u0018\u00010\u00158\u0006@\u0006¢\u0006\f\n\u0004\b3\u0010\u0017\u001a\u0004\b4\u0010\u0019R\u001b\u00105\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b5\u0010\u001b\u001a\u0004\b5\u0010\u001dR\u001b\u00106\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b6\u0010\u001b\u001a\u0004\b6\u0010\u001dR$\u00108\u001a\u0004\u0018\u0001078\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b8\u00109\u001a\u0004\b:\u0010;\"\u0004\b<\u0010=R\u001b\u0010>\u001a\u0004\u0018\u00010\u00158\u0006@\u0006¢\u0006\f\n\u0004\b>\u0010\u0017\u001a\u0004\b?\u0010\u0019R\u001b\u0010@\u001a\u0004\u0018\u00010\u00158\u0006@\u0006¢\u0006\f\n\u0004\b@\u0010\u0017\u001a\u0004\bA\u0010\u0019R\u001b\u0010B\u001a\u0004\u0018\u00010\u00158\u0006@\u0006¢\u0006\f\n\u0004\bB\u0010\u0017\u001a\u0004\bC\u0010\u0019R\u001b\u0010D\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006¢\u0006\f\n\u0004\bD\u0010\u001b\u001a\u0004\bD\u0010\u001d¨\u0006E"}, d2 = {"Lcom/discord/analytics/generated/events/TrackGuildSettingsUpdated;", "Lcom/discord/api/science/AnalyticsSchema;", "Lcom/discord/analytics/generated/traits/TrackBaseReceiver;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "guildId", "Ljava/lang/Long;", "getGuildId", "()Ljava/lang/Long;", "publicUpdatesChannelId", "getPublicUpdatesChannelId", "", "oldVanityUrlCode", "Ljava/lang/CharSequence;", "getOldVanityUrlCode", "()Ljava/lang/CharSequence;", "premiumProgressBarEnabled", "Ljava/lang/Boolean;", "getPremiumProgressBarEnabled", "()Ljava/lang/Boolean;", "animatedIcon", "getAnimatedIcon", "guildName", "getGuildName", "vanityUrlCodeEditType", "getVanityUrlCodeEditType", "bannerEditType", "getBannerEditType", "animatedBanner", "getAnimatedBanner", "preferredLocale", "getPreferredLocale", "oldGuildName", "getOldGuildName", "iconEditType", "getIconEditType", "analyticsSchemaTypeName", "Ljava/lang/String;", "d", "rulesChannelId", "getRulesChannelId", "vanityUrlCode", "getVanityUrlCode", "isFeaturable", "isPublic", "Lcom/discord/analytics/generated/traits/TrackBase;", "trackBase", "Lcom/discord/analytics/generated/traits/TrackBase;", "getTrackBase", "()Lcom/discord/analytics/generated/traits/TrackBase;", "setTrackBase", "(Lcom/discord/analytics/generated/traits/TrackBase;)V", ModelAuditLogEntry.CHANGE_KEY_DESCRIPTION, "getDescription", "splashEditType", "getSplashEditType", "discoverySplashEditType", "getDiscoverySplashEditType", "isDiscoverable", "analytics_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final /* data */ class TrackGuildSettingsUpdated implements AnalyticsSchema, TrackBase2 {
    private TrackBase trackBase;
    private final Long guildId = null;
    private final CharSequence iconEditType = null;
    private final CharSequence guildName = null;
    private final CharSequence oldGuildName = null;
    private final Boolean animatedIcon = null;
    private final CharSequence bannerEditType = null;
    private final CharSequence splashEditType = null;
    private final CharSequence vanityUrlCodeEditType = null;
    private final CharSequence vanityUrlCode = null;
    private final CharSequence oldVanityUrlCode = null;
    private final CharSequence discoverySplashEditType = null;
    private final CharSequence description = null;
    private final CharSequence preferredLocale = null;
    private final Boolean isPublic = null;
    private final Boolean isDiscoverable = null;
    private final Boolean isFeaturable = null;
    private final Long rulesChannelId = null;
    private final Long publicUpdatesChannelId = null;
    private final Boolean premiumProgressBarEnabled = null;
    private final Boolean animatedBanner = null;
    private final transient String analyticsSchemaTypeName = "guild_settings_updated";

    @Override // com.discord.api.science.AnalyticsSchema
    /* renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackGuildSettingsUpdated)) {
            return false;
        }
        TrackGuildSettingsUpdated trackGuildSettingsUpdated = (TrackGuildSettingsUpdated) other;
        return Intrinsics3.areEqual(this.guildId, trackGuildSettingsUpdated.guildId) && Intrinsics3.areEqual(this.iconEditType, trackGuildSettingsUpdated.iconEditType) && Intrinsics3.areEqual(this.guildName, trackGuildSettingsUpdated.guildName) && Intrinsics3.areEqual(this.oldGuildName, trackGuildSettingsUpdated.oldGuildName) && Intrinsics3.areEqual(this.animatedIcon, trackGuildSettingsUpdated.animatedIcon) && Intrinsics3.areEqual(this.bannerEditType, trackGuildSettingsUpdated.bannerEditType) && Intrinsics3.areEqual(this.splashEditType, trackGuildSettingsUpdated.splashEditType) && Intrinsics3.areEqual(this.vanityUrlCodeEditType, trackGuildSettingsUpdated.vanityUrlCodeEditType) && Intrinsics3.areEqual(this.vanityUrlCode, trackGuildSettingsUpdated.vanityUrlCode) && Intrinsics3.areEqual(this.oldVanityUrlCode, trackGuildSettingsUpdated.oldVanityUrlCode) && Intrinsics3.areEqual(this.discoverySplashEditType, trackGuildSettingsUpdated.discoverySplashEditType) && Intrinsics3.areEqual(this.description, trackGuildSettingsUpdated.description) && Intrinsics3.areEqual(this.preferredLocale, trackGuildSettingsUpdated.preferredLocale) && Intrinsics3.areEqual(this.isPublic, trackGuildSettingsUpdated.isPublic) && Intrinsics3.areEqual(this.isDiscoverable, trackGuildSettingsUpdated.isDiscoverable) && Intrinsics3.areEqual(this.isFeaturable, trackGuildSettingsUpdated.isFeaturable) && Intrinsics3.areEqual(this.rulesChannelId, trackGuildSettingsUpdated.rulesChannelId) && Intrinsics3.areEqual(this.publicUpdatesChannelId, trackGuildSettingsUpdated.publicUpdatesChannelId) && Intrinsics3.areEqual(this.premiumProgressBarEnabled, trackGuildSettingsUpdated.premiumProgressBarEnabled) && Intrinsics3.areEqual(this.animatedBanner, trackGuildSettingsUpdated.animatedBanner);
    }

    public int hashCode() {
        Long l = this.guildId;
        int iHashCode = (l != null ? l.hashCode() : 0) * 31;
        CharSequence charSequence = this.iconEditType;
        int iHashCode2 = (iHashCode + (charSequence != null ? charSequence.hashCode() : 0)) * 31;
        CharSequence charSequence2 = this.guildName;
        int iHashCode3 = (iHashCode2 + (charSequence2 != null ? charSequence2.hashCode() : 0)) * 31;
        CharSequence charSequence3 = this.oldGuildName;
        int iHashCode4 = (iHashCode3 + (charSequence3 != null ? charSequence3.hashCode() : 0)) * 31;
        Boolean bool = this.animatedIcon;
        int iHashCode5 = (iHashCode4 + (bool != null ? bool.hashCode() : 0)) * 31;
        CharSequence charSequence4 = this.bannerEditType;
        int iHashCode6 = (iHashCode5 + (charSequence4 != null ? charSequence4.hashCode() : 0)) * 31;
        CharSequence charSequence5 = this.splashEditType;
        int iHashCode7 = (iHashCode6 + (charSequence5 != null ? charSequence5.hashCode() : 0)) * 31;
        CharSequence charSequence6 = this.vanityUrlCodeEditType;
        int iHashCode8 = (iHashCode7 + (charSequence6 != null ? charSequence6.hashCode() : 0)) * 31;
        CharSequence charSequence7 = this.vanityUrlCode;
        int iHashCode9 = (iHashCode8 + (charSequence7 != null ? charSequence7.hashCode() : 0)) * 31;
        CharSequence charSequence8 = this.oldVanityUrlCode;
        int iHashCode10 = (iHashCode9 + (charSequence8 != null ? charSequence8.hashCode() : 0)) * 31;
        CharSequence charSequence9 = this.discoverySplashEditType;
        int iHashCode11 = (iHashCode10 + (charSequence9 != null ? charSequence9.hashCode() : 0)) * 31;
        CharSequence charSequence10 = this.description;
        int iHashCode12 = (iHashCode11 + (charSequence10 != null ? charSequence10.hashCode() : 0)) * 31;
        CharSequence charSequence11 = this.preferredLocale;
        int iHashCode13 = (iHashCode12 + (charSequence11 != null ? charSequence11.hashCode() : 0)) * 31;
        Boolean bool2 = this.isPublic;
        int iHashCode14 = (iHashCode13 + (bool2 != null ? bool2.hashCode() : 0)) * 31;
        Boolean bool3 = this.isDiscoverable;
        int iHashCode15 = (iHashCode14 + (bool3 != null ? bool3.hashCode() : 0)) * 31;
        Boolean bool4 = this.isFeaturable;
        int iHashCode16 = (iHashCode15 + (bool4 != null ? bool4.hashCode() : 0)) * 31;
        Long l2 = this.rulesChannelId;
        int iHashCode17 = (iHashCode16 + (l2 != null ? l2.hashCode() : 0)) * 31;
        Long l3 = this.publicUpdatesChannelId;
        int iHashCode18 = (iHashCode17 + (l3 != null ? l3.hashCode() : 0)) * 31;
        Boolean bool5 = this.premiumProgressBarEnabled;
        int iHashCode19 = (iHashCode18 + (bool5 != null ? bool5.hashCode() : 0)) * 31;
        Boolean bool6 = this.animatedBanner;
        return iHashCode19 + (bool6 != null ? bool6.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackGuildSettingsUpdated(guildId=");
        sbU.append(this.guildId);
        sbU.append(", iconEditType=");
        sbU.append(this.iconEditType);
        sbU.append(", guildName=");
        sbU.append(this.guildName);
        sbU.append(", oldGuildName=");
        sbU.append(this.oldGuildName);
        sbU.append(", animatedIcon=");
        sbU.append(this.animatedIcon);
        sbU.append(", bannerEditType=");
        sbU.append(this.bannerEditType);
        sbU.append(", splashEditType=");
        sbU.append(this.splashEditType);
        sbU.append(", vanityUrlCodeEditType=");
        sbU.append(this.vanityUrlCodeEditType);
        sbU.append(", vanityUrlCode=");
        sbU.append(this.vanityUrlCode);
        sbU.append(", oldVanityUrlCode=");
        sbU.append(this.oldVanityUrlCode);
        sbU.append(", discoverySplashEditType=");
        sbU.append(this.discoverySplashEditType);
        sbU.append(", description=");
        sbU.append(this.description);
        sbU.append(", preferredLocale=");
        sbU.append(this.preferredLocale);
        sbU.append(", isPublic=");
        sbU.append(this.isPublic);
        sbU.append(", isDiscoverable=");
        sbU.append(this.isDiscoverable);
        sbU.append(", isFeaturable=");
        sbU.append(this.isFeaturable);
        sbU.append(", rulesChannelId=");
        sbU.append(this.rulesChannelId);
        sbU.append(", publicUpdatesChannelId=");
        sbU.append(this.publicUpdatesChannelId);
        sbU.append(", premiumProgressBarEnabled=");
        sbU.append(this.premiumProgressBarEnabled);
        sbU.append(", animatedBanner=");
        return outline.D(sbU, this.animatedBanner, ")");
    }
}
