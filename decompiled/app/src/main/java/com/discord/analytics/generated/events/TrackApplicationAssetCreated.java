package com.discord.analytics.generated.events;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.api.science.AnalyticsSchema;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: TrackApplicationAssetCreated.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\r\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u0002J\u0010\u0010\u0004\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u001a\u0010\f\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\tHÖ\u0003¢\u0006\u0004\b\f\u0010\rR\u001b\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001b\u0010\u0014\u001a\u0004\u0018\u00010\u00138\u0006@\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u001b\u0010\u0018\u001a\u0004\u0018\u00010\u00138\u0006@\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0015\u001a\u0004\b\u0019\u0010\u0017R\u001b\u0010\u001a\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u0010\u001a\u0004\b\u001b\u0010\u0012R\u001b\u0010\u001c\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u0010\u001a\u0004\b\u001d\u0010\u0012R\u001b\u0010\u001e\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!R$\u0010#\u001a\u0004\u0018\u00010\"8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u001b\u0010)\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b)\u0010\u0010\u001a\u0004\b*\u0010\u0012R\u001c\u0010+\u001a\u00020\u00038\u0016@\u0016X\u0096D¢\u0006\f\n\u0004\b+\u0010,\u001a\u0004\b-\u0010\u0005R\u001b\u0010.\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b.\u0010\u001f\u001a\u0004\b/\u0010!¨\u00060"}, d2 = {"Lcom/discord/analytics/generated/events/TrackApplicationAssetCreated;", "Lcom/discord/api/science/AnalyticsSchema;", "Lcom/discord/analytics/generated/traits/TrackBaseReceiver;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", ModelAuditLogEntry.CHANGE_KEY_ID, "Ljava/lang/Long;", "getId", "()Ljava/lang/Long;", "", "applicationName", "Ljava/lang/CharSequence;", "getApplicationName", "()Ljava/lang/CharSequence;", ModelAuditLogEntry.CHANGE_KEY_NAME, "getName", "applicationId", "getApplicationId", "type", "getType", "hasBot", "Ljava/lang/Boolean;", "getHasBot", "()Ljava/lang/Boolean;", "Lcom/discord/analytics/generated/traits/TrackBase;", "trackBase", "Lcom/discord/analytics/generated/traits/TrackBase;", "getTrackBase", "()Lcom/discord/analytics/generated/traits/TrackBase;", "setTrackBase", "(Lcom/discord/analytics/generated/traits/TrackBase;)V", "botId", "getBotId", "analyticsSchemaTypeName", "Ljava/lang/String;", "d", "hasRedirectUri", "getHasRedirectUri", "analytics_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final /* data */ class TrackApplicationAssetCreated implements AnalyticsSchema, TrackBase2 {
    private TrackBase trackBase;
    private final Long id = null;
    private final Long applicationId = null;
    private final Long botId = null;
    private final CharSequence applicationName = null;
    private final Boolean hasBot = null;
    private final Boolean hasRedirectUri = null;
    private final Long type = null;
    private final CharSequence name = null;
    private final transient String analyticsSchemaTypeName = "application_asset_created";

    @Override // com.discord.api.science.AnalyticsSchema
    /* renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackApplicationAssetCreated)) {
            return false;
        }
        TrackApplicationAssetCreated trackApplicationAssetCreated = (TrackApplicationAssetCreated) other;
        return Intrinsics3.areEqual(this.id, trackApplicationAssetCreated.id) && Intrinsics3.areEqual(this.applicationId, trackApplicationAssetCreated.applicationId) && Intrinsics3.areEqual(this.botId, trackApplicationAssetCreated.botId) && Intrinsics3.areEqual(this.applicationName, trackApplicationAssetCreated.applicationName) && Intrinsics3.areEqual(this.hasBot, trackApplicationAssetCreated.hasBot) && Intrinsics3.areEqual(this.hasRedirectUri, trackApplicationAssetCreated.hasRedirectUri) && Intrinsics3.areEqual(this.type, trackApplicationAssetCreated.type) && Intrinsics3.areEqual(this.name, trackApplicationAssetCreated.name);
    }

    public int hashCode() {
        Long l = this.id;
        int iHashCode = (l != null ? l.hashCode() : 0) * 31;
        Long l2 = this.applicationId;
        int iHashCode2 = (iHashCode + (l2 != null ? l2.hashCode() : 0)) * 31;
        Long l3 = this.botId;
        int iHashCode3 = (iHashCode2 + (l3 != null ? l3.hashCode() : 0)) * 31;
        CharSequence charSequence = this.applicationName;
        int iHashCode4 = (iHashCode3 + (charSequence != null ? charSequence.hashCode() : 0)) * 31;
        Boolean bool = this.hasBot;
        int iHashCode5 = (iHashCode4 + (bool != null ? bool.hashCode() : 0)) * 31;
        Boolean bool2 = this.hasRedirectUri;
        int iHashCode6 = (iHashCode5 + (bool2 != null ? bool2.hashCode() : 0)) * 31;
        Long l4 = this.type;
        int iHashCode7 = (iHashCode6 + (l4 != null ? l4.hashCode() : 0)) * 31;
        CharSequence charSequence2 = this.name;
        return iHashCode7 + (charSequence2 != null ? charSequence2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackApplicationAssetCreated(id=");
        sbU.append(this.id);
        sbU.append(", applicationId=");
        sbU.append(this.applicationId);
        sbU.append(", botId=");
        sbU.append(this.botId);
        sbU.append(", applicationName=");
        sbU.append(this.applicationName);
        sbU.append(", hasBot=");
        sbU.append(this.hasBot);
        sbU.append(", hasRedirectUri=");
        sbU.append(this.hasRedirectUri);
        sbU.append(", type=");
        sbU.append(this.type);
        sbU.append(", name=");
        return outline.E(sbU, this.name, ")");
    }
}
