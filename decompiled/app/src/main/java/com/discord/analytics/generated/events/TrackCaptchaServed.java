package com.discord.analytics.generated.events;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: TrackCaptchaServed.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\r\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0018\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u0002J\u0010\u0010\u0004\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u001a\u0010\f\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\tHÖ\u0003¢\u0006\u0004\b\f\u0010\rR$\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001b\u0010\u0016\u001a\u0004\u0018\u00010\u00158\u0006@\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u001b\u0010\u001b\u001a\u0004\u0018\u00010\u001a8\u0006@\u0006¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u001c\u0010\u001f\u001a\u00020\u00038\u0016@\u0016X\u0096D¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\u0005R\u001b\u0010\"\u001a\u0004\u0018\u00010\u00158\u0006@\u0006¢\u0006\f\n\u0004\b\"\u0010\u0017\u001a\u0004\b#\u0010\u0019R\u001b\u0010$\u001a\u0004\u0018\u00010\u001a8\u0006@\u0006¢\u0006\f\n\u0004\b$\u0010\u001c\u001a\u0004\b%\u0010\u001eR\u001b\u0010&\u001a\u0004\u0018\u00010\u001a8\u0006@\u0006¢\u0006\f\n\u0004\b&\u0010\u001c\u001a\u0004\b'\u0010\u001eR\u001b\u0010(\u001a\u0004\u0018\u00010\u001a8\u0006@\u0006¢\u0006\f\n\u0004\b(\u0010\u001c\u001a\u0004\b)\u0010\u001eR\u001b\u0010*\u001a\u0004\u0018\u00010\u00158\u0006@\u0006¢\u0006\f\n\u0004\b*\u0010\u0017\u001a\u0004\b+\u0010\u0019R\u001b\u0010,\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/R\u001b\u00100\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b0\u0010-\u001a\u0004\b1\u0010/¨\u00062"}, d2 = {"Lcom/discord/analytics/generated/events/TrackCaptchaServed;", "Lcom/discord/api/science/AnalyticsSchema;", "Lcom/discord/analytics/generated/traits/TrackBaseReceiver;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/discord/analytics/generated/traits/TrackBase;", "trackBase", "Lcom/discord/analytics/generated/traits/TrackBase;", "getTrackBase", "()Lcom/discord/analytics/generated/traits/TrackBase;", "setTrackBase", "(Lcom/discord/analytics/generated/traits/TrackBase;)V", "", "captchaService", "Ljava/lang/CharSequence;", "getCaptchaService", "()Ljava/lang/CharSequence;", "", "locationGuildId", "Ljava/lang/Long;", "getLocationGuildId", "()Ljava/lang/Long;", "analyticsSchemaTypeName", "Ljava/lang/String;", "d", "userFlow", "getUserFlow", "locationMessageId", "getLocationMessageId", "locationChannelType", "getLocationChannelType", "locationChannelId", "getLocationChannelId", "sitekey", "getSitekey", "forceBad", "Ljava/lang/Boolean;", "getForceBad", "()Ljava/lang/Boolean;", "captchaRequired", "getCaptchaRequired", "analytics_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final /* data */ class TrackCaptchaServed implements AnalyticsSchema, TrackBase2 {
    private TrackBase trackBase;
    private final CharSequence captchaService = null;
    private final CharSequence sitekey = null;
    private final CharSequence userFlow = null;
    private final Boolean forceBad = null;
    private final Boolean captchaRequired = null;
    private final Long locationGuildId = null;
    private final Long locationChannelId = null;
    private final Long locationChannelType = null;
    private final Long locationMessageId = null;
    private final transient String analyticsSchemaTypeName = "captcha_served";

    @Override // com.discord.api.science.AnalyticsSchema
    /* renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackCaptchaServed)) {
            return false;
        }
        TrackCaptchaServed trackCaptchaServed = (TrackCaptchaServed) other;
        return Intrinsics3.areEqual(this.captchaService, trackCaptchaServed.captchaService) && Intrinsics3.areEqual(this.sitekey, trackCaptchaServed.sitekey) && Intrinsics3.areEqual(this.userFlow, trackCaptchaServed.userFlow) && Intrinsics3.areEqual(this.forceBad, trackCaptchaServed.forceBad) && Intrinsics3.areEqual(this.captchaRequired, trackCaptchaServed.captchaRequired) && Intrinsics3.areEqual(this.locationGuildId, trackCaptchaServed.locationGuildId) && Intrinsics3.areEqual(this.locationChannelId, trackCaptchaServed.locationChannelId) && Intrinsics3.areEqual(this.locationChannelType, trackCaptchaServed.locationChannelType) && Intrinsics3.areEqual(this.locationMessageId, trackCaptchaServed.locationMessageId);
    }

    public int hashCode() {
        CharSequence charSequence = this.captchaService;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        CharSequence charSequence2 = this.sitekey;
        int iHashCode2 = (iHashCode + (charSequence2 != null ? charSequence2.hashCode() : 0)) * 31;
        CharSequence charSequence3 = this.userFlow;
        int iHashCode3 = (iHashCode2 + (charSequence3 != null ? charSequence3.hashCode() : 0)) * 31;
        Boolean bool = this.forceBad;
        int iHashCode4 = (iHashCode3 + (bool != null ? bool.hashCode() : 0)) * 31;
        Boolean bool2 = this.captchaRequired;
        int iHashCode5 = (iHashCode4 + (bool2 != null ? bool2.hashCode() : 0)) * 31;
        Long l = this.locationGuildId;
        int iHashCode6 = (iHashCode5 + (l != null ? l.hashCode() : 0)) * 31;
        Long l2 = this.locationChannelId;
        int iHashCode7 = (iHashCode6 + (l2 != null ? l2.hashCode() : 0)) * 31;
        Long l3 = this.locationChannelType;
        int iHashCode8 = (iHashCode7 + (l3 != null ? l3.hashCode() : 0)) * 31;
        Long l4 = this.locationMessageId;
        return iHashCode8 + (l4 != null ? l4.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackCaptchaServed(captchaService=");
        sbU.append(this.captchaService);
        sbU.append(", sitekey=");
        sbU.append(this.sitekey);
        sbU.append(", userFlow=");
        sbU.append(this.userFlow);
        sbU.append(", forceBad=");
        sbU.append(this.forceBad);
        sbU.append(", captchaRequired=");
        sbU.append(this.captchaRequired);
        sbU.append(", locationGuildId=");
        sbU.append(this.locationGuildId);
        sbU.append(", locationChannelId=");
        sbU.append(this.locationChannelId);
        sbU.append(", locationChannelType=");
        sbU.append(this.locationChannelType);
        sbU.append(", locationMessageId=");
        return outline.G(sbU, this.locationMessageId, ")");
    }
}
