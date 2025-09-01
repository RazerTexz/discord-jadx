package com.discord.analytics.generated.events;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: TrackExternalDynamicLinkReceived.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u0002J\u0010\u0010\u0004\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u001a\u0010\f\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\tHÖ\u0003¢\u0006\u0004\b\f\u0010\rR\u001b\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001b\u0010\u0013\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u001b\u0010\u0017\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0010\u001a\u0004\b\u0018\u0010\u0012R\u001c\u0010\u0019\u001a\u00020\u00038\u0016@\u0016X\u0096D¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u0005R$\u0010\u001d\u001a\u0004\u0018\u00010\u001c8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001b\u0010$\u001a\u0004\u0018\u00010#8\u0006@\u0006¢\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'R\u001b\u0010(\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b(\u0010\u0010\u001a\u0004\b)\u0010\u0012R\u001b\u0010*\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b*\u0010\u0010\u001a\u0004\b+\u0010\u0012R\u001b\u0010,\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b,\u0010\u0010\u001a\u0004\b-\u0010\u0012R\u001b\u0010.\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b.\u0010\u0014\u001a\u0004\b.\u0010\u0016¨\u0006/"}, d2 = {"Lcom/discord/analytics/generated/events/TrackExternalDynamicLinkReceived;", "Lcom/discord/api/science/AnalyticsSchema;", "Lcom/discord/analytics/generated/traits/TrackBaseReceiver;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "guildTemplateCode", "Ljava/lang/CharSequence;", "getGuildTemplateCode", "()Ljava/lang/CharSequence;", "hasAuthToken", "Ljava/lang/Boolean;", "getHasAuthToken", "()Ljava/lang/Boolean;", "attemptId", "getAttemptId", "analyticsSchemaTypeName", "Ljava/lang/String;", "d", "Lcom/discord/analytics/generated/traits/TrackBase;", "trackBase", "Lcom/discord/analytics/generated/traits/TrackBase;", "getTrackBase", "()Lcom/discord/analytics/generated/traits/TrackBase;", "setTrackBase", "(Lcom/discord/analytics/generated/traits/TrackBase;)V", "", "fingerprint", "Ljava/lang/Long;", "getFingerprint", "()Ljava/lang/Long;", "linkType", "getLinkType", "inviteCode", "getInviteCode", "deeplinkSource", "getDeeplinkSource", "isBackgrounded", "analytics_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final /* data */ class TrackExternalDynamicLinkReceived implements AnalyticsSchema, TrackBase2 {
    private TrackBase trackBase;
    private final Long fingerprint = null;
    private final CharSequence attemptId = null;
    private final Boolean hasAuthToken = null;
    private final CharSequence inviteCode = null;
    private final CharSequence guildTemplateCode = null;
    private final Boolean isBackgrounded = null;
    private final CharSequence linkType = null;
    private final CharSequence deeplinkSource = null;
    private final transient String analyticsSchemaTypeName = "external_dynamic_link_received";

    @Override // com.discord.api.science.AnalyticsSchema
    /* renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackExternalDynamicLinkReceived)) {
            return false;
        }
        TrackExternalDynamicLinkReceived trackExternalDynamicLinkReceived = (TrackExternalDynamicLinkReceived) other;
        return Intrinsics3.areEqual(this.fingerprint, trackExternalDynamicLinkReceived.fingerprint) && Intrinsics3.areEqual(this.attemptId, trackExternalDynamicLinkReceived.attemptId) && Intrinsics3.areEqual(this.hasAuthToken, trackExternalDynamicLinkReceived.hasAuthToken) && Intrinsics3.areEqual(this.inviteCode, trackExternalDynamicLinkReceived.inviteCode) && Intrinsics3.areEqual(this.guildTemplateCode, trackExternalDynamicLinkReceived.guildTemplateCode) && Intrinsics3.areEqual(this.isBackgrounded, trackExternalDynamicLinkReceived.isBackgrounded) && Intrinsics3.areEqual(this.linkType, trackExternalDynamicLinkReceived.linkType) && Intrinsics3.areEqual(this.deeplinkSource, trackExternalDynamicLinkReceived.deeplinkSource);
    }

    public int hashCode() {
        Long l = this.fingerprint;
        int iHashCode = (l != null ? l.hashCode() : 0) * 31;
        CharSequence charSequence = this.attemptId;
        int iHashCode2 = (iHashCode + (charSequence != null ? charSequence.hashCode() : 0)) * 31;
        Boolean bool = this.hasAuthToken;
        int iHashCode3 = (iHashCode2 + (bool != null ? bool.hashCode() : 0)) * 31;
        CharSequence charSequence2 = this.inviteCode;
        int iHashCode4 = (iHashCode3 + (charSequence2 != null ? charSequence2.hashCode() : 0)) * 31;
        CharSequence charSequence3 = this.guildTemplateCode;
        int iHashCode5 = (iHashCode4 + (charSequence3 != null ? charSequence3.hashCode() : 0)) * 31;
        Boolean bool2 = this.isBackgrounded;
        int iHashCode6 = (iHashCode5 + (bool2 != null ? bool2.hashCode() : 0)) * 31;
        CharSequence charSequence4 = this.linkType;
        int iHashCode7 = (iHashCode6 + (charSequence4 != null ? charSequence4.hashCode() : 0)) * 31;
        CharSequence charSequence5 = this.deeplinkSource;
        return iHashCode7 + (charSequence5 != null ? charSequence5.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackExternalDynamicLinkReceived(fingerprint=");
        sbU.append(this.fingerprint);
        sbU.append(", attemptId=");
        sbU.append(this.attemptId);
        sbU.append(", hasAuthToken=");
        sbU.append(this.hasAuthToken);
        sbU.append(", inviteCode=");
        sbU.append(this.inviteCode);
        sbU.append(", guildTemplateCode=");
        sbU.append(this.guildTemplateCode);
        sbU.append(", isBackgrounded=");
        sbU.append(this.isBackgrounded);
        sbU.append(", linkType=");
        sbU.append(this.linkType);
        sbU.append(", deeplinkSource=");
        return outline.E(sbU, this.deeplinkSource, ")");
    }
}
