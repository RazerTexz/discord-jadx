package com.discord.analytics.generated.events;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: TrackAnalyticsDataQueried.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\r\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u0002J\u0010\u0010\u0004\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u001a\u0010\f\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\tHÖ\u0003¢\u0006\u0004\b\f\u0010\rR\u001b\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001b\u0010\u0013\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0010\u001a\u0004\b\u0014\u0010\u0012R$\u0010\u0016\u001a\u0004\u0018\u00010\u00158\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001b\u0010\u001d\u001a\u0004\u0018\u00010\u001c8\u0006@\u0006¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u001b\u0010!\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$R!\u0010&\u001a\n\u0018\u00010\u000ej\u0004\u0018\u0001`%8\u0006@\u0006¢\u0006\f\n\u0004\b&\u0010\u0010\u001a\u0004\b'\u0010\u0012R\u001b\u0010(\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b(\u0010\"\u001a\u0004\b)\u0010$R\u001b\u0010*\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b*\u0010\u0010\u001a\u0004\b+\u0010\u0012R!\u0010,\u001a\n\u0018\u00010\u000ej\u0004\u0018\u0001`%8\u0006@\u0006¢\u0006\f\n\u0004\b,\u0010\u0010\u001a\u0004\b-\u0010\u0012R\u001c\u0010.\u001a\u00020\u00038\u0016@\u0016X\u0096D¢\u0006\f\n\u0004\b.\u0010/\u001a\u0004\b0\u0010\u0005¨\u00061"}, d2 = {"Lcom/discord/analytics/generated/events/TrackAnalyticsDataQueried;", "Lcom/discord/api/science/AnalyticsSchema;", "Lcom/discord/analytics/generated/traits/TrackBaseReceiver;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "applicationId", "Ljava/lang/Long;", "getApplicationId", "()Ljava/lang/Long;", "guildId", "getGuildId", "Lcom/discord/analytics/generated/traits/TrackBase;", "trackBase", "Lcom/discord/analytics/generated/traits/TrackBase;", "getTrackBase", "()Lcom/discord/analytics/generated/traits/TrackBase;", "setTrackBase", "(Lcom/discord/analytics/generated/traits/TrackBase;)V", "", "tableName", "Ljava/lang/CharSequence;", "getTableName", "()Ljava/lang/CharSequence;", "responseHasData", "Ljava/lang/Boolean;", "getResponseHasData", "()Ljava/lang/Boolean;", "Lcom/discord/primitives/Timestamp;", "dateRangeEnd", "getDateRangeEnd", "responseIsSuccessful", "getResponseIsSuccessful", "interval", "getInterval", "dateRangeStart", "getDateRangeStart", "analyticsSchemaTypeName", "Ljava/lang/String;", "d", "analytics_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final /* data */ class TrackAnalyticsDataQueried implements AnalyticsSchema, TrackBase2 {
    private TrackBase trackBase;
    private final Long applicationId = null;
    private final Long guildId = null;
    private final CharSequence tableName = null;
    private final Long dateRangeStart = null;
    private final Long dateRangeEnd = null;
    private final Long interval = null;
    private final Boolean responseIsSuccessful = null;
    private final Boolean responseHasData = null;
    private final transient String analyticsSchemaTypeName = "analytics_data_queried";

    @Override // com.discord.api.science.AnalyticsSchema
    /* renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackAnalyticsDataQueried)) {
            return false;
        }
        TrackAnalyticsDataQueried trackAnalyticsDataQueried = (TrackAnalyticsDataQueried) other;
        return Intrinsics3.areEqual(this.applicationId, trackAnalyticsDataQueried.applicationId) && Intrinsics3.areEqual(this.guildId, trackAnalyticsDataQueried.guildId) && Intrinsics3.areEqual(this.tableName, trackAnalyticsDataQueried.tableName) && Intrinsics3.areEqual(this.dateRangeStart, trackAnalyticsDataQueried.dateRangeStart) && Intrinsics3.areEqual(this.dateRangeEnd, trackAnalyticsDataQueried.dateRangeEnd) && Intrinsics3.areEqual(this.interval, trackAnalyticsDataQueried.interval) && Intrinsics3.areEqual(this.responseIsSuccessful, trackAnalyticsDataQueried.responseIsSuccessful) && Intrinsics3.areEqual(this.responseHasData, trackAnalyticsDataQueried.responseHasData);
    }

    public int hashCode() {
        Long l = this.applicationId;
        int iHashCode = (l != null ? l.hashCode() : 0) * 31;
        Long l2 = this.guildId;
        int iHashCode2 = (iHashCode + (l2 != null ? l2.hashCode() : 0)) * 31;
        CharSequence charSequence = this.tableName;
        int iHashCode3 = (iHashCode2 + (charSequence != null ? charSequence.hashCode() : 0)) * 31;
        Long l3 = this.dateRangeStart;
        int iHashCode4 = (iHashCode3 + (l3 != null ? l3.hashCode() : 0)) * 31;
        Long l4 = this.dateRangeEnd;
        int iHashCode5 = (iHashCode4 + (l4 != null ? l4.hashCode() : 0)) * 31;
        Long l5 = this.interval;
        int iHashCode6 = (iHashCode5 + (l5 != null ? l5.hashCode() : 0)) * 31;
        Boolean bool = this.responseIsSuccessful;
        int iHashCode7 = (iHashCode6 + (bool != null ? bool.hashCode() : 0)) * 31;
        Boolean bool2 = this.responseHasData;
        return iHashCode7 + (bool2 != null ? bool2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackAnalyticsDataQueried(applicationId=");
        sbU.append(this.applicationId);
        sbU.append(", guildId=");
        sbU.append(this.guildId);
        sbU.append(", tableName=");
        sbU.append(this.tableName);
        sbU.append(", dateRangeStart=");
        sbU.append(this.dateRangeStart);
        sbU.append(", dateRangeEnd=");
        sbU.append(this.dateRangeEnd);
        sbU.append(", interval=");
        sbU.append(this.interval);
        sbU.append(", responseIsSuccessful=");
        sbU.append(this.responseIsSuccessful);
        sbU.append(", responseHasData=");
        return outline.D(sbU, this.responseHasData, ")");
    }
}
