package com.discord.analytics.generated.events;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.analytics.generated.traits.TrackOverlayClientMetadata;
import com.discord.analytics.generated.traits.TrackOverlayClientMetadata2;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: TrackOverlayPinToggled.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0010\r\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003J\u0010\u0010\u0005\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\b\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b\b\u0010\tJ\u001a\u0010\r\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\nHÖ\u0003¢\u0006\u0004\b\r\u0010\u000eR\u001c\u0010\u000f\u001a\u00020\u00048\u0016@\u0016X\u0096D¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0006R$\u0010\u0013\u001a\u0004\u0018\u00010\u00128\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R$\u0010\u001a\u001a\u0004\u0018\u00010\u00198\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001b\u0010!\u001a\u0004\u0018\u00010 8\u0006@\u0006¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$R\u001b\u0010%\u001a\u0004\u0018\u00010 8\u0006@\u0006¢\u0006\f\n\u0004\b%\u0010\"\u001a\u0004\b&\u0010$R\u001b\u0010'\u001a\u0004\u0018\u00010\f8\u0006@\u0006¢\u0006\f\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*R\u001b\u0010+\u001a\u0004\u0018\u00010 8\u0006@\u0006¢\u0006\f\n\u0004\b+\u0010\"\u001a\u0004\b,\u0010$R\u001b\u0010.\u001a\u0004\u0018\u00010-8\u0006@\u0006¢\u0006\f\n\u0004\b.\u0010/\u001a\u0004\b0\u00101¨\u00062"}, d2 = {"Lcom/discord/analytics/generated/events/TrackOverlayPinToggled;", "Lcom/discord/api/science/AnalyticsSchema;", "Lcom/discord/analytics/generated/traits/TrackBaseReceiver;", "Lcom/discord/analytics/generated/traits/TrackOverlayClientMetadataReceiver;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "analyticsSchemaTypeName", "Ljava/lang/String;", "d", "Lcom/discord/analytics/generated/traits/TrackBase;", "trackBase", "Lcom/discord/analytics/generated/traits/TrackBase;", "getTrackBase", "()Lcom/discord/analytics/generated/traits/TrackBase;", "setTrackBase", "(Lcom/discord/analytics/generated/traits/TrackBase;)V", "Lcom/discord/analytics/generated/traits/TrackOverlayClientMetadata;", "trackOverlayClientMetadata", "Lcom/discord/analytics/generated/traits/TrackOverlayClientMetadata;", "getTrackOverlayClientMetadata", "()Lcom/discord/analytics/generated/traits/TrackOverlayClientMetadata;", "setTrackOverlayClientMetadata", "(Lcom/discord/analytics/generated/traits/TrackOverlayClientMetadata;)V", "", "channelId", "Ljava/lang/Long;", "getChannelId", "()Ljava/lang/Long;", "channelType", "getChannelType", "pinned", "Ljava/lang/Boolean;", "getPinned", "()Ljava/lang/Boolean;", "guildId", "getGuildId", "", "widgetType", "Ljava/lang/CharSequence;", "getWidgetType", "()Ljava/lang/CharSequence;", "analytics_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final /* data */ class TrackOverlayPinToggled implements AnalyticsSchema, TrackBase2, TrackOverlayClientMetadata2 {
    private TrackBase trackBase;
    private TrackOverlayClientMetadata trackOverlayClientMetadata;
    private final Boolean pinned = null;
    private final Long guildId = null;
    private final Long channelId = null;
    private final Long channelType = null;
    private final CharSequence widgetType = null;
    private final transient String analyticsSchemaTypeName = "overlay_pin_toggled";

    @Override // com.discord.api.science.AnalyticsSchema
    /* renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackOverlayPinToggled)) {
            return false;
        }
        TrackOverlayPinToggled trackOverlayPinToggled = (TrackOverlayPinToggled) other;
        return Intrinsics3.areEqual(this.pinned, trackOverlayPinToggled.pinned) && Intrinsics3.areEqual(this.guildId, trackOverlayPinToggled.guildId) && Intrinsics3.areEqual(this.channelId, trackOverlayPinToggled.channelId) && Intrinsics3.areEqual(this.channelType, trackOverlayPinToggled.channelType) && Intrinsics3.areEqual(this.widgetType, trackOverlayPinToggled.widgetType);
    }

    public int hashCode() {
        Boolean bool = this.pinned;
        int iHashCode = (bool != null ? bool.hashCode() : 0) * 31;
        Long l = this.guildId;
        int iHashCode2 = (iHashCode + (l != null ? l.hashCode() : 0)) * 31;
        Long l2 = this.channelId;
        int iHashCode3 = (iHashCode2 + (l2 != null ? l2.hashCode() : 0)) * 31;
        Long l3 = this.channelType;
        int iHashCode4 = (iHashCode3 + (l3 != null ? l3.hashCode() : 0)) * 31;
        CharSequence charSequence = this.widgetType;
        return iHashCode4 + (charSequence != null ? charSequence.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackOverlayPinToggled(pinned=");
        sbU.append(this.pinned);
        sbU.append(", guildId=");
        sbU.append(this.guildId);
        sbU.append(", channelId=");
        sbU.append(this.channelId);
        sbU.append(", channelType=");
        sbU.append(this.channelType);
        sbU.append(", widgetType=");
        return outline.E(sbU, this.widgetType, ")");
    }
}
