package com.discord.analytics.generated.events;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.analytics.generated.traits.TrackOverlayClientMetadata;
import com.discord.analytics.generated.traits.TrackOverlayClientMetadata2;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: TrackOverlayLayoutUpdated.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0010\r\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003J\u0010\u0010\u0005\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\b\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b\b\u0010\tJ\u001a\u0010\r\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\nHÖ\u0003¢\u0006\u0004\b\r\u0010\u000eR\u001c\u0010\u000f\u001a\u00020\u00048\u0016@\u0016X\u0096D¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0006R\u001b\u0010\u0012\u001a\u0004\u0018\u00010\f8\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u001b\u0010\u0017\u001a\u0004\u0018\u00010\u00168\u0006@\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u001b\u0010\u001b\u001a\u0004\u0018\u00010\f8\u0006@\u0006¢\u0006\f\n\u0004\b\u001b\u0010\u0013\u001a\u0004\b\u001c\u0010\u0015R\u001b\u0010\u001d\u001a\u0004\u0018\u00010\u00168\u0006@\u0006¢\u0006\f\n\u0004\b\u001d\u0010\u0018\u001a\u0004\b\u001e\u0010\u001aR\u001b\u0010\u001f\u001a\u0004\u0018\u00010\u00168\u0006@\u0006¢\u0006\f\n\u0004\b\u001f\u0010\u0018\u001a\u0004\b \u0010\u001aR\u001b\u0010\"\u001a\u0004\u0018\u00010!8\u0006@\u0006¢\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%R\u001b\u0010&\u001a\u0004\u0018\u00010\u00168\u0006@\u0006¢\u0006\f\n\u0004\b&\u0010\u0018\u001a\u0004\b'\u0010\u001aR\u001b\u0010(\u001a\u0004\u0018\u00010\u00168\u0006@\u0006¢\u0006\f\n\u0004\b(\u0010\u0018\u001a\u0004\b)\u0010\u001aR$\u0010+\u001a\u0004\u0018\u00010*8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\u001b\u00101\u001a\u0004\u0018\u00010\u00168\u0006@\u0006¢\u0006\f\n\u0004\b1\u0010\u0018\u001a\u0004\b2\u0010\u001aR$\u00104\u001a\u0004\u0018\u0001038\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b4\u00105\u001a\u0004\b6\u00107\"\u0004\b8\u00109¨\u0006:"}, d2 = {"Lcom/discord/analytics/generated/events/TrackOverlayLayoutUpdated;", "Lcom/discord/api/science/AnalyticsSchema;", "Lcom/discord/analytics/generated/traits/TrackBaseReceiver;", "Lcom/discord/analytics/generated/traits/TrackOverlayClientMetadataReceiver;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "analyticsSchemaTypeName", "Ljava/lang/String;", "d", "wasResized", "Ljava/lang/Boolean;", "getWasResized", "()Ljava/lang/Boolean;", "", "windowWidth", "Ljava/lang/Long;", "getWindowWidth", "()Ljava/lang/Long;", "wasDragged", "getWasDragged", "windowHeight", "getWindowHeight", "widgetLeft", "getWidgetLeft", "", "widgetType", "Ljava/lang/CharSequence;", "getWidgetType", "()Ljava/lang/CharSequence;", "widgetWidth", "getWidgetWidth", "widgetTop", "getWidgetTop", "Lcom/discord/analytics/generated/traits/TrackOverlayClientMetadata;", "trackOverlayClientMetadata", "Lcom/discord/analytics/generated/traits/TrackOverlayClientMetadata;", "getTrackOverlayClientMetadata", "()Lcom/discord/analytics/generated/traits/TrackOverlayClientMetadata;", "setTrackOverlayClientMetadata", "(Lcom/discord/analytics/generated/traits/TrackOverlayClientMetadata;)V", "widgetHeight", "getWidgetHeight", "Lcom/discord/analytics/generated/traits/TrackBase;", "trackBase", "Lcom/discord/analytics/generated/traits/TrackBase;", "getTrackBase", "()Lcom/discord/analytics/generated/traits/TrackBase;", "setTrackBase", "(Lcom/discord/analytics/generated/traits/TrackBase;)V", "analytics_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final /* data */ class TrackOverlayLayoutUpdated implements AnalyticsSchema, TrackBase2, TrackOverlayClientMetadata2 {
    private TrackBase trackBase;
    private TrackOverlayClientMetadata trackOverlayClientMetadata;
    private final Boolean wasResized = null;
    private final Boolean wasDragged = null;
    private final CharSequence widgetType = null;
    private final Long windowWidth = null;
    private final Long windowHeight = null;
    private final Long widgetWidth = null;
    private final Long widgetHeight = null;
    private final Long widgetLeft = null;
    private final Long widgetTop = null;
    private final transient String analyticsSchemaTypeName = "overlay_layout_updated";

    @Override // com.discord.api.science.AnalyticsSchema
    /* renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackOverlayLayoutUpdated)) {
            return false;
        }
        TrackOverlayLayoutUpdated trackOverlayLayoutUpdated = (TrackOverlayLayoutUpdated) other;
        return Intrinsics3.areEqual(this.wasResized, trackOverlayLayoutUpdated.wasResized) && Intrinsics3.areEqual(this.wasDragged, trackOverlayLayoutUpdated.wasDragged) && Intrinsics3.areEqual(this.widgetType, trackOverlayLayoutUpdated.widgetType) && Intrinsics3.areEqual(this.windowWidth, trackOverlayLayoutUpdated.windowWidth) && Intrinsics3.areEqual(this.windowHeight, trackOverlayLayoutUpdated.windowHeight) && Intrinsics3.areEqual(this.widgetWidth, trackOverlayLayoutUpdated.widgetWidth) && Intrinsics3.areEqual(this.widgetHeight, trackOverlayLayoutUpdated.widgetHeight) && Intrinsics3.areEqual(this.widgetLeft, trackOverlayLayoutUpdated.widgetLeft) && Intrinsics3.areEqual(this.widgetTop, trackOverlayLayoutUpdated.widgetTop);
    }

    public int hashCode() {
        Boolean bool = this.wasResized;
        int iHashCode = (bool != null ? bool.hashCode() : 0) * 31;
        Boolean bool2 = this.wasDragged;
        int iHashCode2 = (iHashCode + (bool2 != null ? bool2.hashCode() : 0)) * 31;
        CharSequence charSequence = this.widgetType;
        int iHashCode3 = (iHashCode2 + (charSequence != null ? charSequence.hashCode() : 0)) * 31;
        Long l = this.windowWidth;
        int iHashCode4 = (iHashCode3 + (l != null ? l.hashCode() : 0)) * 31;
        Long l2 = this.windowHeight;
        int iHashCode5 = (iHashCode4 + (l2 != null ? l2.hashCode() : 0)) * 31;
        Long l3 = this.widgetWidth;
        int iHashCode6 = (iHashCode5 + (l3 != null ? l3.hashCode() : 0)) * 31;
        Long l4 = this.widgetHeight;
        int iHashCode7 = (iHashCode6 + (l4 != null ? l4.hashCode() : 0)) * 31;
        Long l5 = this.widgetLeft;
        int iHashCode8 = (iHashCode7 + (l5 != null ? l5.hashCode() : 0)) * 31;
        Long l6 = this.widgetTop;
        return iHashCode8 + (l6 != null ? l6.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackOverlayLayoutUpdated(wasResized=");
        sbU.append(this.wasResized);
        sbU.append(", wasDragged=");
        sbU.append(this.wasDragged);
        sbU.append(", widgetType=");
        sbU.append(this.widgetType);
        sbU.append(", windowWidth=");
        sbU.append(this.windowWidth);
        sbU.append(", windowHeight=");
        sbU.append(this.windowHeight);
        sbU.append(", widgetWidth=");
        sbU.append(this.widgetWidth);
        sbU.append(", widgetHeight=");
        sbU.append(this.widgetHeight);
        sbU.append(", widgetLeft=");
        sbU.append(this.widgetLeft);
        sbU.append(", widgetTop=");
        return outline.G(sbU, this.widgetTop, ")");
    }
}
