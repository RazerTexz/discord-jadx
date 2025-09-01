package com.discord.analytics.generated.events;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.analytics.generated.traits.TrackSourceMetadata;
import com.discord.analytics.generated.traits.TrackSourceMetadata2;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: TrackAgeGateSubmitted.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B=\u0012\u0010\b\u0002\u0010#\u001a\n\u0018\u00010\u0016j\u0004\u0018\u0001`\"\u0012\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\u0016\u0012\n\b\u0002\u0010*\u001a\u0004\u0018\u00010\u0016\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0016¢\u0006\u0004\b,\u0010-J\u0010\u0010\u0005\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\b\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b\b\u0010\tJ\u001a\u0010\r\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\nHÖ\u0003¢\u0006\u0004\b\r\u0010\u000eR$\u0010\u0010\u001a\u0004\u0018\u00010\u000f8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001b\u0010\u0017\u001a\u0004\u0018\u00010\u00168\u0006@\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR$\u0010\u001c\u001a\u0004\u0018\u00010\u001b8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R!\u0010#\u001a\n\u0018\u00010\u0016j\u0004\u0018\u0001`\"8\u0006@\u0006¢\u0006\f\n\u0004\b#\u0010\u0018\u001a\u0004\b$\u0010\u001aR\u001c\u0010%\u001a\u00020\u00048\u0016@\u0016X\u0096D¢\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b'\u0010\u0006R\u001b\u0010(\u001a\u0004\u0018\u00010\u00168\u0006@\u0006¢\u0006\f\n\u0004\b(\u0010\u0018\u001a\u0004\b)\u0010\u001aR\u001b\u0010*\u001a\u0004\u0018\u00010\u00168\u0006@\u0006¢\u0006\f\n\u0004\b*\u0010\u0018\u001a\u0004\b+\u0010\u001a¨\u0006."}, d2 = {"Lcom/discord/analytics/generated/events/TrackAgeGateSubmitted;", "Lcom/discord/api/science/AnalyticsSchema;", "Lcom/discord/analytics/generated/traits/TrackBaseReceiver;", "Lcom/discord/analytics/generated/traits/TrackSourceMetadataReceiver;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/discord/analytics/generated/traits/TrackBase;", "trackBase", "Lcom/discord/analytics/generated/traits/TrackBase;", "getTrackBase", "()Lcom/discord/analytics/generated/traits/TrackBase;", "setTrackBase", "(Lcom/discord/analytics/generated/traits/TrackBase;)V", "", "dobYear", "Ljava/lang/Long;", "getDobYear", "()Ljava/lang/Long;", "Lcom/discord/analytics/generated/traits/TrackSourceMetadata;", "trackSourceMetadata", "Lcom/discord/analytics/generated/traits/TrackSourceMetadata;", "getTrackSourceMetadata", "()Lcom/discord/analytics/generated/traits/TrackSourceMetadata;", "e", "(Lcom/discord/analytics/generated/traits/TrackSourceMetadata;)V", "Lcom/discord/primitives/Timestamp;", "dob", "getDob", "analyticsSchemaTypeName", "Ljava/lang/String;", "d", "dobDay", "getDobDay", "dobMonth", "getDobMonth", "<init>", "(Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;)V", "analytics_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final /* data */ class TrackAgeGateSubmitted implements AnalyticsSchema, TrackBase2, TrackSourceMetadata2 {
    private final transient String analyticsSchemaTypeName;
    private final Long dob;
    private final Long dobDay;
    private final Long dobMonth;
    private final Long dobYear;
    private TrackBase trackBase;
    private TrackSourceMetadata trackSourceMetadata;

    public TrackAgeGateSubmitted() {
        this.dob = null;
        this.dobDay = null;
        this.dobMonth = null;
        this.dobYear = null;
        this.analyticsSchemaTypeName = "age_gate_submitted";
    }

    @Override // com.discord.api.science.AnalyticsSchema
    /* renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public void e(TrackSourceMetadata trackSourceMetadata) {
        this.trackSourceMetadata = trackSourceMetadata;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackAgeGateSubmitted)) {
            return false;
        }
        TrackAgeGateSubmitted trackAgeGateSubmitted = (TrackAgeGateSubmitted) other;
        return Intrinsics3.areEqual(this.dob, trackAgeGateSubmitted.dob) && Intrinsics3.areEqual(this.dobDay, trackAgeGateSubmitted.dobDay) && Intrinsics3.areEqual(this.dobMonth, trackAgeGateSubmitted.dobMonth) && Intrinsics3.areEqual(this.dobYear, trackAgeGateSubmitted.dobYear);
    }

    public int hashCode() {
        Long l = this.dob;
        int iHashCode = (l != null ? l.hashCode() : 0) * 31;
        Long l2 = this.dobDay;
        int iHashCode2 = (iHashCode + (l2 != null ? l2.hashCode() : 0)) * 31;
        Long l3 = this.dobMonth;
        int iHashCode3 = (iHashCode2 + (l3 != null ? l3.hashCode() : 0)) * 31;
        Long l4 = this.dobYear;
        return iHashCode3 + (l4 != null ? l4.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackAgeGateSubmitted(dob=");
        sbU.append(this.dob);
        sbU.append(", dobDay=");
        sbU.append(this.dobDay);
        sbU.append(", dobMonth=");
        sbU.append(this.dobMonth);
        sbU.append(", dobYear=");
        return outline.G(sbU, this.dobYear, ")");
    }

    public TrackAgeGateSubmitted(Long l, Long l2, Long l3, Long l4) {
        this.dob = l;
        this.dobDay = l2;
        this.dobMonth = l3;
        this.dobYear = l4;
        this.analyticsSchemaTypeName = "age_gate_submitted";
    }
}
