package com.discord.analytics.generated.events.activity_internal;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackActivityInternalMetadata;
import com.discord.analytics.generated.traits.TrackActivityInternalMetadata2;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: TrackActivityInternalWatchTogetherVideoSelected.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003J\u0010\u0010\u0005\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\b\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b\b\u0010\tJ\u001a\u0010\r\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\nHÖ\u0003¢\u0006\u0004\b\r\u0010\u000eR\u001b\u0010\u000f\u001a\u0004\u0018\u00010\f8\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u000f\u0010\u0011R\u001b\u0010\u0013\u001a\u0004\u0018\u00010\u00128\u0006@\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u001b\u0010\u0017\u001a\u0004\u0018\u00010\u00128\u0006@\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0014\u001a\u0004\b\u0018\u0010\u0016R$\u0010\u001a\u001a\u0004\u0018\u00010\u00198\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001b\u0010 \u001a\u0004\u0018\u00010\f8\u0006@\u0006¢\u0006\f\n\u0004\b \u0010\u0010\u001a\u0004\b \u0010\u0011R$\u0010\"\u001a\u0004\u0018\u00010!8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u001c\u0010(\u001a\u00020\u00048\u0016@\u0016X\u0096D¢\u0006\f\n\u0004\b(\u0010)\u001a\u0004\b*\u0010\u0006¨\u0006+"}, d2 = {"Lcom/discord/analytics/generated/events/activity_internal/TrackActivityInternalWatchTogetherVideoSelected;", "Lcom/discord/api/science/AnalyticsSchema;", "Lcom/discord/analytics/generated/traits/TrackBaseReceiver;", "Lcom/discord/analytics/generated/traits/TrackActivityInternalMetadataReceiver;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "isHostMode", "Ljava/lang/Boolean;", "()Ljava/lang/Boolean;", "", "orderSelected", "Ljava/lang/Long;", "getOrderSelected", "()Ljava/lang/Long;", "orderCurrent", "getOrderCurrent", "Lcom/discord/analytics/generated/traits/TrackActivityInternalMetadata;", "trackActivityInternalMetadata", "Lcom/discord/analytics/generated/traits/TrackActivityInternalMetadata;", "getTrackActivityInternalMetadata", "()Lcom/discord/analytics/generated/traits/TrackActivityInternalMetadata;", "setTrackActivityInternalMetadata", "(Lcom/discord/analytics/generated/traits/TrackActivityInternalMetadata;)V", "isHost", "Lcom/discord/analytics/generated/traits/TrackBase;", "trackBase", "Lcom/discord/analytics/generated/traits/TrackBase;", "getTrackBase", "()Lcom/discord/analytics/generated/traits/TrackBase;", "setTrackBase", "(Lcom/discord/analytics/generated/traits/TrackBase;)V", "analyticsSchemaTypeName", "Ljava/lang/String;", "d", "analytics_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final /* data */ class TrackActivityInternalWatchTogetherVideoSelected implements AnalyticsSchema, TrackBase2, TrackActivityInternalMetadata2 {
    private TrackActivityInternalMetadata trackActivityInternalMetadata;
    private TrackBase trackBase;
    private final Boolean isHost = null;
    private final Boolean isHostMode = null;
    private final Long orderCurrent = null;
    private final Long orderSelected = null;
    private final transient String analyticsSchemaTypeName = "activity_internal_watch_together_video_selected";

    @Override // com.discord.api.science.AnalyticsSchema
    /* renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackActivityInternalWatchTogetherVideoSelected)) {
            return false;
        }
        TrackActivityInternalWatchTogetherVideoSelected trackActivityInternalWatchTogetherVideoSelected = (TrackActivityInternalWatchTogetherVideoSelected) other;
        return Intrinsics3.areEqual(this.isHost, trackActivityInternalWatchTogetherVideoSelected.isHost) && Intrinsics3.areEqual(this.isHostMode, trackActivityInternalWatchTogetherVideoSelected.isHostMode) && Intrinsics3.areEqual(this.orderCurrent, trackActivityInternalWatchTogetherVideoSelected.orderCurrent) && Intrinsics3.areEqual(this.orderSelected, trackActivityInternalWatchTogetherVideoSelected.orderSelected);
    }

    public int hashCode() {
        Boolean bool = this.isHost;
        int iHashCode = (bool != null ? bool.hashCode() : 0) * 31;
        Boolean bool2 = this.isHostMode;
        int iHashCode2 = (iHashCode + (bool2 != null ? bool2.hashCode() : 0)) * 31;
        Long l = this.orderCurrent;
        int iHashCode3 = (iHashCode2 + (l != null ? l.hashCode() : 0)) * 31;
        Long l2 = this.orderSelected;
        return iHashCode3 + (l2 != null ? l2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackActivityInternalWatchTogetherVideoSelected(isHost=");
        sbU.append(this.isHost);
        sbU.append(", isHostMode=");
        sbU.append(this.isHostMode);
        sbU.append(", orderCurrent=");
        sbU.append(this.orderCurrent);
        sbU.append(", orderSelected=");
        return outline.G(sbU, this.orderSelected, ")");
    }
}
