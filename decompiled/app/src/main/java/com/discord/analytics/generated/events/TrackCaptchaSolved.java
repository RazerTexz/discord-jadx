package com.discord.analytics.generated.events;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Intrinsics3;
import java.util.List;
import kotlin.Metadata;

/* compiled from: TrackCaptchaSolved.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0010\r\n\u0002\b\n\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0007\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u0002J\u0010\u0010\u0004\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u001a\u0010\f\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\tHÖ\u0003¢\u0006\u0004\b\f\u0010\rR\u001c\u0010\u000e\u001a\u00020\u00038\u0016@\u0016X\u0096D¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0005R!\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u00118\u0006@\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u001b\u0010\u0017\u001a\u0004\u0018\u00010\u00128\u0006@\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR!\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u00118\u0006@\u0006¢\u0006\f\n\u0004\b\u001b\u0010\u0014\u001a\u0004\b\u001c\u0010\u0016R\u001b\u0010\u001e\u001a\u0004\u0018\u00010\u001d8\u0006@\u0006¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!R\u001b\u0010\"\u001a\u0004\u0018\u00010\u00128\u0006@\u0006¢\u0006\f\n\u0004\b\"\u0010\u0018\u001a\u0004\b#\u0010\u001aR\u001b\u0010$\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'R!\u0010)\u001a\n\u0018\u00010\u001dj\u0004\u0018\u0001`(8\u0006@\u0006¢\u0006\f\n\u0004\b)\u0010\u001f\u001a\u0004\b*\u0010!R\u001b\u0010+\u001a\u0004\u0018\u00010\u00128\u0006@\u0006¢\u0006\f\n\u0004\b+\u0010\u0018\u001a\u0004\b,\u0010\u001aR\u001b\u0010-\u001a\u0004\u0018\u00010\u001d8\u0006@\u0006¢\u0006\f\n\u0004\b-\u0010\u001f\u001a\u0004\b.\u0010!R\u001b\u0010/\u001a\u0004\u0018\u00010\u00128\u0006@\u0006¢\u0006\f\n\u0004\b/\u0010\u0018\u001a\u0004\b0\u0010\u001aR\u001b\u00101\u001a\u0004\u0018\u00010\u00128\u0006@\u0006¢\u0006\f\n\u0004\b1\u0010\u0018\u001a\u0004\b2\u0010\u001aR$\u00104\u001a\u0004\u0018\u0001038\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b4\u00105\u001a\u0004\b6\u00107\"\u0004\b8\u00109R\u001b\u0010:\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b:\u0010%\u001a\u0004\b;\u0010'R\u001b\u0010<\u001a\u0004\u0018\u00010\u001d8\u0006@\u0006¢\u0006\f\n\u0004\b<\u0010\u001f\u001a\u0004\b=\u0010!R\u001b\u0010?\u001a\u0004\u0018\u00010>8\u0006@\u0006¢\u0006\f\n\u0004\b?\u0010@\u001a\u0004\bA\u0010BR\u001b\u0010C\u001a\u0004\u0018\u00010\u001d8\u0006@\u0006¢\u0006\f\n\u0004\bC\u0010\u001f\u001a\u0004\bD\u0010!R\u001b\u0010E\u001a\u0004\u0018\u00010\u00128\u0006@\u0006¢\u0006\f\n\u0004\bE\u0010\u0018\u001a\u0004\bF\u0010\u001aR\u001b\u0010G\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006¢\u0006\f\n\u0004\bG\u0010%\u001a\u0004\bH\u0010'¨\u0006I"}, d2 = {"Lcom/discord/analytics/generated/events/TrackCaptchaSolved;", "Lcom/discord/api/science/AnalyticsSchema;", "Lcom/discord/analytics/generated/traits/TrackBaseReceiver;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "analyticsSchemaTypeName", "Ljava/lang/String;", "d", "", "", "scoreReason", "Ljava/util/List;", "getScoreReason", "()Ljava/util/List;", "hostname", "Ljava/lang/CharSequence;", "getHostname", "()Ljava/lang/CharSequence;", "errorCodes", "getErrorCodes", "", "locationMessageId", "Ljava/lang/Long;", "getLocationMessageId", "()Ljava/lang/Long;", "scopedUid0", "getScopedUid0", "success", "Ljava/lang/Boolean;", "getSuccess", "()Ljava/lang/Boolean;", "Lcom/discord/primitives/Timestamp;", "challengeTs", "getChallengeTs", "scopedUid1", "getScopedUid1", "locationGuildId", "getLocationGuildId", "sitekey", "getSitekey", "userFlow", "getUserFlow", "Lcom/discord/analytics/generated/traits/TrackBase;", "trackBase", "Lcom/discord/analytics/generated/traits/TrackBase;", "getTrackBase", "()Lcom/discord/analytics/generated/traits/TrackBase;", "setTrackBase", "(Lcom/discord/analytics/generated/traits/TrackBase;)V", "captchaRequired", "getCaptchaRequired", "locationChannelId", "getLocationChannelId", "", "score", "Ljava/lang/Float;", "getScore", "()Ljava/lang/Float;", "locationChannelType", "getLocationChannelType", "captchaService", "getCaptchaService", "forceBad", "getForceBad", "analytics_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final /* data */ class TrackCaptchaSolved implements AnalyticsSchema, TrackBase2 {
    private TrackBase trackBase;
    private final Boolean success = null;
    private final Boolean forceBad = null;
    private final Long challengeTs = null;
    private final CharSequence hostname = null;
    private final CharSequence scopedUid0 = null;
    private final CharSequence scopedUid1 = null;
    private final CharSequence sitekey = null;
    private final Float score = null;
    private final List<CharSequence> scoreReason = null;
    private final List<CharSequence> errorCodes = null;
    private final CharSequence userFlow = null;
    private final CharSequence captchaService = null;
    private final Boolean captchaRequired = null;
    private final Long locationGuildId = null;
    private final Long locationChannelId = null;
    private final Long locationChannelType = null;
    private final Long locationMessageId = null;
    private final transient String analyticsSchemaTypeName = "captcha_solved";

    @Override // com.discord.api.science.AnalyticsSchema
    /* renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackCaptchaSolved)) {
            return false;
        }
        TrackCaptchaSolved trackCaptchaSolved = (TrackCaptchaSolved) other;
        return Intrinsics3.areEqual(this.success, trackCaptchaSolved.success) && Intrinsics3.areEqual(this.forceBad, trackCaptchaSolved.forceBad) && Intrinsics3.areEqual(this.challengeTs, trackCaptchaSolved.challengeTs) && Intrinsics3.areEqual(this.hostname, trackCaptchaSolved.hostname) && Intrinsics3.areEqual(this.scopedUid0, trackCaptchaSolved.scopedUid0) && Intrinsics3.areEqual(this.scopedUid1, trackCaptchaSolved.scopedUid1) && Intrinsics3.areEqual(this.sitekey, trackCaptchaSolved.sitekey) && Intrinsics3.areEqual(this.score, trackCaptchaSolved.score) && Intrinsics3.areEqual(this.scoreReason, trackCaptchaSolved.scoreReason) && Intrinsics3.areEqual(this.errorCodes, trackCaptchaSolved.errorCodes) && Intrinsics3.areEqual(this.userFlow, trackCaptchaSolved.userFlow) && Intrinsics3.areEqual(this.captchaService, trackCaptchaSolved.captchaService) && Intrinsics3.areEqual(this.captchaRequired, trackCaptchaSolved.captchaRequired) && Intrinsics3.areEqual(this.locationGuildId, trackCaptchaSolved.locationGuildId) && Intrinsics3.areEqual(this.locationChannelId, trackCaptchaSolved.locationChannelId) && Intrinsics3.areEqual(this.locationChannelType, trackCaptchaSolved.locationChannelType) && Intrinsics3.areEqual(this.locationMessageId, trackCaptchaSolved.locationMessageId);
    }

    public int hashCode() {
        Boolean bool = this.success;
        int iHashCode = (bool != null ? bool.hashCode() : 0) * 31;
        Boolean bool2 = this.forceBad;
        int iHashCode2 = (iHashCode + (bool2 != null ? bool2.hashCode() : 0)) * 31;
        Long l = this.challengeTs;
        int iHashCode3 = (iHashCode2 + (l != null ? l.hashCode() : 0)) * 31;
        CharSequence charSequence = this.hostname;
        int iHashCode4 = (iHashCode3 + (charSequence != null ? charSequence.hashCode() : 0)) * 31;
        CharSequence charSequence2 = this.scopedUid0;
        int iHashCode5 = (iHashCode4 + (charSequence2 != null ? charSequence2.hashCode() : 0)) * 31;
        CharSequence charSequence3 = this.scopedUid1;
        int iHashCode6 = (iHashCode5 + (charSequence3 != null ? charSequence3.hashCode() : 0)) * 31;
        CharSequence charSequence4 = this.sitekey;
        int iHashCode7 = (iHashCode6 + (charSequence4 != null ? charSequence4.hashCode() : 0)) * 31;
        Float f = this.score;
        int iHashCode8 = (iHashCode7 + (f != null ? f.hashCode() : 0)) * 31;
        List<CharSequence> list = this.scoreReason;
        int iHashCode9 = (iHashCode8 + (list != null ? list.hashCode() : 0)) * 31;
        List<CharSequence> list2 = this.errorCodes;
        int iHashCode10 = (iHashCode9 + (list2 != null ? list2.hashCode() : 0)) * 31;
        CharSequence charSequence5 = this.userFlow;
        int iHashCode11 = (iHashCode10 + (charSequence5 != null ? charSequence5.hashCode() : 0)) * 31;
        CharSequence charSequence6 = this.captchaService;
        int iHashCode12 = (iHashCode11 + (charSequence6 != null ? charSequence6.hashCode() : 0)) * 31;
        Boolean bool3 = this.captchaRequired;
        int iHashCode13 = (iHashCode12 + (bool3 != null ? bool3.hashCode() : 0)) * 31;
        Long l2 = this.locationGuildId;
        int iHashCode14 = (iHashCode13 + (l2 != null ? l2.hashCode() : 0)) * 31;
        Long l3 = this.locationChannelId;
        int iHashCode15 = (iHashCode14 + (l3 != null ? l3.hashCode() : 0)) * 31;
        Long l4 = this.locationChannelType;
        int iHashCode16 = (iHashCode15 + (l4 != null ? l4.hashCode() : 0)) * 31;
        Long l5 = this.locationMessageId;
        return iHashCode16 + (l5 != null ? l5.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackCaptchaSolved(success=");
        sbU.append(this.success);
        sbU.append(", forceBad=");
        sbU.append(this.forceBad);
        sbU.append(", challengeTs=");
        sbU.append(this.challengeTs);
        sbU.append(", hostname=");
        sbU.append(this.hostname);
        sbU.append(", scopedUid0=");
        sbU.append(this.scopedUid0);
        sbU.append(", scopedUid1=");
        sbU.append(this.scopedUid1);
        sbU.append(", sitekey=");
        sbU.append(this.sitekey);
        sbU.append(", score=");
        sbU.append(this.score);
        sbU.append(", scoreReason=");
        sbU.append(this.scoreReason);
        sbU.append(", errorCodes=");
        sbU.append(this.errorCodes);
        sbU.append(", userFlow=");
        sbU.append(this.userFlow);
        sbU.append(", captchaService=");
        sbU.append(this.captchaService);
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
