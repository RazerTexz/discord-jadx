package com.discord.analytics.generated.events;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.analytics.generated.traits.TrackMarketingSite;
import com.discord.analytics.generated.traits.TrackMarketingSite2;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: TrackDownloadApp.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003J\u0010\u0010\u0005\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\b\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b\b\u0010\tJ\u001a\u0010\r\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\nHÖ\u0003¢\u0006\u0004\b\r\u0010\u000eR\u001b\u0010\u0010\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u001b\u0010\u0014\u001a\u0004\u0018\u00010\f8\u0006@\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u001b\u0010\u0018\u001a\u0004\u0018\u00010\f8\u0006@\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0015\u001a\u0004\b\u0019\u0010\u0017R\u001b\u0010\u001a\u001a\u0004\u0018\u00010\f8\u0006@\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u0015\u001a\u0004\b\u001b\u0010\u0017R$\u0010\u001d\u001a\u0004\u0018\u00010\u001c8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001c\u0010#\u001a\u00020\u00048\u0016@\u0016X\u0096D¢\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b%\u0010\u0006R\u001b\u0010&\u001a\u0004\u0018\u00010\f8\u0006@\u0006¢\u0006\f\n\u0004\b&\u0010\u0015\u001a\u0004\b'\u0010\u0017R\u001b\u0010(\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b(\u0010\u0011\u001a\u0004\b)\u0010\u0013R\u001b\u0010*\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b*\u0010\u0011\u001a\u0004\b+\u0010\u0013R\u001b\u0010,\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b,\u0010\u0011\u001a\u0004\b-\u0010\u0013R$\u0010/\u001a\u0004\u0018\u00010.8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b/\u00100\u001a\u0004\b1\u00102\"\u0004\b3\u00104¨\u00065"}, d2 = {"Lcom/discord/analytics/generated/events/TrackDownloadApp;", "Lcom/discord/api/science/AnalyticsSchema;", "Lcom/discord/analytics/generated/traits/TrackBaseReceiver;", "Lcom/discord/analytics/generated/traits/TrackMarketingSiteReceiver;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "referringLocation", "Ljava/lang/CharSequence;", "getReferringLocation", "()Ljava/lang/CharSequence;", "released", "Ljava/lang/Boolean;", "getReleased", "()Ljava/lang/Boolean;", "qrCode", "getQrCode", "hasEMail", "getHasEMail", "Lcom/discord/analytics/generated/traits/TrackBase;", "trackBase", "Lcom/discord/analytics/generated/traits/TrackBase;", "getTrackBase", "()Lcom/discord/analytics/generated/traits/TrackBase;", "setTrackBase", "(Lcom/discord/analytics/generated/traits/TrackBase;)V", "analyticsSchemaTypeName", "Ljava/lang/String;", "d", "ptb", "getPtb", "staticExperimentUuid", "getStaticExperimentUuid", "platform", "getPlatform", "pageName", "getPageName", "Lcom/discord/analytics/generated/traits/TrackMarketingSite;", "trackMarketingSite", "Lcom/discord/analytics/generated/traits/TrackMarketingSite;", "getTrackMarketingSite", "()Lcom/discord/analytics/generated/traits/TrackMarketingSite;", "setTrackMarketingSite", "(Lcom/discord/analytics/generated/traits/TrackMarketingSite;)V", "analytics_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final /* data */ class TrackDownloadApp implements AnalyticsSchema, TrackBase2, TrackMarketingSite2 {
    private TrackBase trackBase;
    private TrackMarketingSite trackMarketingSite;
    private final Boolean hasEMail = null;
    private final CharSequence platform = null;
    private final Boolean ptb = null;
    private final CharSequence referringLocation = null;
    private final Boolean released = null;
    private final CharSequence pageName = null;
    private final CharSequence staticExperimentUuid = null;
    private final Boolean qrCode = null;
    private final transient String analyticsSchemaTypeName = "download_app";

    @Override // com.discord.api.science.AnalyticsSchema
    /* renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackDownloadApp)) {
            return false;
        }
        TrackDownloadApp trackDownloadApp = (TrackDownloadApp) other;
        return Intrinsics3.areEqual(this.hasEMail, trackDownloadApp.hasEMail) && Intrinsics3.areEqual(this.platform, trackDownloadApp.platform) && Intrinsics3.areEqual(this.ptb, trackDownloadApp.ptb) && Intrinsics3.areEqual(this.referringLocation, trackDownloadApp.referringLocation) && Intrinsics3.areEqual(this.released, trackDownloadApp.released) && Intrinsics3.areEqual(this.pageName, trackDownloadApp.pageName) && Intrinsics3.areEqual(this.staticExperimentUuid, trackDownloadApp.staticExperimentUuid) && Intrinsics3.areEqual(this.qrCode, trackDownloadApp.qrCode);
    }

    public int hashCode() {
        Boolean bool = this.hasEMail;
        int iHashCode = (bool != null ? bool.hashCode() : 0) * 31;
        CharSequence charSequence = this.platform;
        int iHashCode2 = (iHashCode + (charSequence != null ? charSequence.hashCode() : 0)) * 31;
        Boolean bool2 = this.ptb;
        int iHashCode3 = (iHashCode2 + (bool2 != null ? bool2.hashCode() : 0)) * 31;
        CharSequence charSequence2 = this.referringLocation;
        int iHashCode4 = (iHashCode3 + (charSequence2 != null ? charSequence2.hashCode() : 0)) * 31;
        Boolean bool3 = this.released;
        int iHashCode5 = (iHashCode4 + (bool3 != null ? bool3.hashCode() : 0)) * 31;
        CharSequence charSequence3 = this.pageName;
        int iHashCode6 = (iHashCode5 + (charSequence3 != null ? charSequence3.hashCode() : 0)) * 31;
        CharSequence charSequence4 = this.staticExperimentUuid;
        int iHashCode7 = (iHashCode6 + (charSequence4 != null ? charSequence4.hashCode() : 0)) * 31;
        Boolean bool4 = this.qrCode;
        return iHashCode7 + (bool4 != null ? bool4.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackDownloadApp(hasEMail=");
        sbU.append(this.hasEMail);
        sbU.append(", platform=");
        sbU.append(this.platform);
        sbU.append(", ptb=");
        sbU.append(this.ptb);
        sbU.append(", referringLocation=");
        sbU.append(this.referringLocation);
        sbU.append(", released=");
        sbU.append(this.released);
        sbU.append(", pageName=");
        sbU.append(this.pageName);
        sbU.append(", staticExperimentUuid=");
        sbU.append(this.staticExperimentUuid);
        sbU.append(", qrCode=");
        return outline.D(sbU, this.qrCode, ")");
    }
}
