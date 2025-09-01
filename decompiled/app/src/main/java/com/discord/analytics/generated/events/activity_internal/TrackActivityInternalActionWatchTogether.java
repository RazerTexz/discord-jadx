package com.discord.analytics.generated.events.activity_internal;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackActivityInternalMetadata;
import com.discord.analytics.generated.traits.TrackActivityInternalMetadata2;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: TrackActivityInternalActionWatchTogether.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003J\u0010\u0010\u0005\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\b\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b\b\u0010\tJ\u001a\u0010\r\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\nHÖ\u0003¢\u0006\u0004\b\r\u0010\u000eR\u001b\u0010\u0010\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u001b\u0010\u0014\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0011\u001a\u0004\b\u0015\u0010\u0013R\u001b\u0010\u0016\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0011\u001a\u0004\b\u0017\u0010\u0013R\u001b\u0010\u0019\u001a\u0004\u0018\u00010\u00188\u0006@\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u001b\u0010\u001d\u001a\u0004\u0018\u00010\u00188\u0006@\u0006¢\u0006\f\n\u0004\b\u001d\u0010\u001a\u001a\u0004\b\u001e\u0010\u001cR\u001c\u0010\u001f\u001a\u00020\u00048\u0016@\u0016X\u0096D¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\u0006R\u001b\u0010\"\u001a\u0004\u0018\u00010\f8\u0006@\u0006¢\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b\"\u0010$R\u001b\u0010%\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b%\u0010\u0011\u001a\u0004\b&\u0010\u0013R$\u0010(\u001a\u0004\u0018\u00010'8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R$\u0010/\u001a\u0004\u0018\u00010.8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b/\u00100\u001a\u0004\b1\u00102\"\u0004\b3\u00104R\u001b\u00105\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b5\u0010\u0011\u001a\u0004\b6\u0010\u0013R\u001b\u00107\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b7\u0010\u0011\u001a\u0004\b8\u0010\u0013¨\u00069"}, d2 = {"Lcom/discord/analytics/generated/events/activity_internal/TrackActivityInternalActionWatchTogether;", "Lcom/discord/api/science/AnalyticsSchema;", "Lcom/discord/analytics/generated/traits/TrackBaseReceiver;", "Lcom/discord/analytics/generated/traits/TrackActivityInternalMetadataReceiver;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "trackingId", "Ljava/lang/CharSequence;", "getTrackingId", "()Ljava/lang/CharSequence;", "hostType", "getHostType", "remoteType", "getRemoteType", "", "orderCurrent", "Ljava/lang/Long;", "getOrderCurrent", "()Ljava/lang/Long;", "orderSelected", "getOrderSelected", "analyticsSchemaTypeName", "Ljava/lang/String;", "d", "isHost", "Ljava/lang/Boolean;", "()Ljava/lang/Boolean;", "searchType", "getSearchType", "Lcom/discord/analytics/generated/traits/TrackBase;", "trackBase", "Lcom/discord/analytics/generated/traits/TrackBase;", "getTrackBase", "()Lcom/discord/analytics/generated/traits/TrackBase;", "setTrackBase", "(Lcom/discord/analytics/generated/traits/TrackBase;)V", "Lcom/discord/analytics/generated/traits/TrackActivityInternalMetadata;", "trackActivityInternalMetadata", "Lcom/discord/analytics/generated/traits/TrackActivityInternalMetadata;", "getTrackActivityInternalMetadata", "()Lcom/discord/analytics/generated/traits/TrackActivityInternalMetadata;", "setTrackActivityInternalMetadata", "(Lcom/discord/analytics/generated/traits/TrackActivityInternalMetadata;)V", "actionName", "getActionName", "via", "getVia", "analytics_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final /* data */ class TrackActivityInternalActionWatchTogether implements AnalyticsSchema, TrackBase2, TrackActivityInternalMetadata2 {
    private TrackActivityInternalMetadata trackActivityInternalMetadata;
    private TrackBase trackBase;
    private final CharSequence actionName = null;
    private final Boolean isHost = null;
    private final CharSequence remoteType = null;
    private final CharSequence hostType = null;
    private final CharSequence searchType = null;
    private final CharSequence via = null;
    private final Long orderCurrent = null;
    private final Long orderSelected = null;
    private final CharSequence trackingId = null;
    private final transient String analyticsSchemaTypeName = "activity_internal_action_watch_together";

    @Override // com.discord.api.science.AnalyticsSchema
    /* renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackActivityInternalActionWatchTogether)) {
            return false;
        }
        TrackActivityInternalActionWatchTogether trackActivityInternalActionWatchTogether = (TrackActivityInternalActionWatchTogether) other;
        return Intrinsics3.areEqual(this.actionName, trackActivityInternalActionWatchTogether.actionName) && Intrinsics3.areEqual(this.isHost, trackActivityInternalActionWatchTogether.isHost) && Intrinsics3.areEqual(this.remoteType, trackActivityInternalActionWatchTogether.remoteType) && Intrinsics3.areEqual(this.hostType, trackActivityInternalActionWatchTogether.hostType) && Intrinsics3.areEqual(this.searchType, trackActivityInternalActionWatchTogether.searchType) && Intrinsics3.areEqual(this.via, trackActivityInternalActionWatchTogether.via) && Intrinsics3.areEqual(this.orderCurrent, trackActivityInternalActionWatchTogether.orderCurrent) && Intrinsics3.areEqual(this.orderSelected, trackActivityInternalActionWatchTogether.orderSelected) && Intrinsics3.areEqual(this.trackingId, trackActivityInternalActionWatchTogether.trackingId);
    }

    public int hashCode() {
        CharSequence charSequence = this.actionName;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        Boolean bool = this.isHost;
        int iHashCode2 = (iHashCode + (bool != null ? bool.hashCode() : 0)) * 31;
        CharSequence charSequence2 = this.remoteType;
        int iHashCode3 = (iHashCode2 + (charSequence2 != null ? charSequence2.hashCode() : 0)) * 31;
        CharSequence charSequence3 = this.hostType;
        int iHashCode4 = (iHashCode3 + (charSequence3 != null ? charSequence3.hashCode() : 0)) * 31;
        CharSequence charSequence4 = this.searchType;
        int iHashCode5 = (iHashCode4 + (charSequence4 != null ? charSequence4.hashCode() : 0)) * 31;
        CharSequence charSequence5 = this.via;
        int iHashCode6 = (iHashCode5 + (charSequence5 != null ? charSequence5.hashCode() : 0)) * 31;
        Long l = this.orderCurrent;
        int iHashCode7 = (iHashCode6 + (l != null ? l.hashCode() : 0)) * 31;
        Long l2 = this.orderSelected;
        int iHashCode8 = (iHashCode7 + (l2 != null ? l2.hashCode() : 0)) * 31;
        CharSequence charSequence6 = this.trackingId;
        return iHashCode8 + (charSequence6 != null ? charSequence6.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackActivityInternalActionWatchTogether(actionName=");
        sbU.append(this.actionName);
        sbU.append(", isHost=");
        sbU.append(this.isHost);
        sbU.append(", remoteType=");
        sbU.append(this.remoteType);
        sbU.append(", hostType=");
        sbU.append(this.hostType);
        sbU.append(", searchType=");
        sbU.append(this.searchType);
        sbU.append(", via=");
        sbU.append(this.via);
        sbU.append(", orderCurrent=");
        sbU.append(this.orderCurrent);
        sbU.append(", orderSelected=");
        sbU.append(this.orderSelected);
        sbU.append(", trackingId=");
        return outline.E(sbU, this.trackingId, ")");
    }
}
