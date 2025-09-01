package com.discord.analytics.generated.events;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.analytics.generated.traits.TrackOverlayClientMetadata;
import com.discord.analytics.generated.traits.TrackOverlayClientMetadata2;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: TrackOverlaySettingsUpdated.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003J\u0010\u0010\u0005\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\b\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b\b\u0010\tJ\u001a\u0010\r\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\nHÖ\u0003¢\u0006\u0004\b\r\u0010\u000eR\u001b\u0010\u0010\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u001b\u0010\u0015\u001a\u0004\u0018\u00010\u00148\u0006@\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u001b\u0010\u0019\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u0011\u001a\u0004\b\u001a\u0010\u0013R\u001b\u0010\u001b\u001a\u0004\u0018\u00010\f8\u0006@\u0006¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u001b\u0010\u001f\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b\u001f\u0010\u0011\u001a\u0004\b \u0010\u0013R$\u0010\"\u001a\u0004\u0018\u00010!8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u001b\u0010(\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b(\u0010\u0011\u001a\u0004\b)\u0010\u0013R\u001c\u0010*\u001a\u00020\u00048\u0016@\u0016X\u0096D¢\u0006\f\n\u0004\b*\u0010+\u001a\u0004\b,\u0010\u0006R$\u0010.\u001a\u0004\u0018\u00010-8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b.\u0010/\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\u001b\u00104\u001a\u0004\u0018\u00010\f8\u0006@\u0006¢\u0006\f\n\u0004\b4\u0010\u001c\u001a\u0004\b5\u0010\u001e¨\u00066"}, d2 = {"Lcom/discord/analytics/generated/events/TrackOverlaySettingsUpdated;", "Lcom/discord/api/science/AnalyticsSchema;", "Lcom/discord/analytics/generated/traits/TrackBaseReceiver;", "Lcom/discord/analytics/generated/traits/TrackOverlayClientMetadataReceiver;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "textActivationHotkey", "Ljava/lang/CharSequence;", "getTextActivationHotkey", "()Ljava/lang/CharSequence;", "", "textOpacitySlider", "Ljava/lang/Long;", "getTextOpacitySlider", "()Ljava/lang/Long;", "hotkey", "getHotkey", "notificationsEnabled", "Ljava/lang/Boolean;", "getNotificationsEnabled", "()Ljava/lang/Boolean;", "notificationsPosition", "getNotificationsPosition", "Lcom/discord/analytics/generated/traits/TrackBase;", "trackBase", "Lcom/discord/analytics/generated/traits/TrackBase;", "getTrackBase", "()Lcom/discord/analytics/generated/traits/TrackBase;", "setTrackBase", "(Lcom/discord/analytics/generated/traits/TrackBase;)V", "textNotificationsMode", "getTextNotificationsMode", "analyticsSchemaTypeName", "Ljava/lang/String;", "d", "Lcom/discord/analytics/generated/traits/TrackOverlayClientMetadata;", "trackOverlayClientMetadata", "Lcom/discord/analytics/generated/traits/TrackOverlayClientMetadata;", "getTrackOverlayClientMetadata", "()Lcom/discord/analytics/generated/traits/TrackOverlayClientMetadata;", "setTrackOverlayClientMetadata", "(Lcom/discord/analytics/generated/traits/TrackOverlayClientMetadata;)V", "enabled", "getEnabled", "analytics_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final /* data */ class TrackOverlaySettingsUpdated implements AnalyticsSchema, TrackBase2, TrackOverlayClientMetadata2 {
    private TrackBase trackBase;
    private TrackOverlayClientMetadata trackOverlayClientMetadata;
    private final Boolean enabled = null;
    private final Boolean notificationsEnabled = null;
    private final CharSequence notificationsPosition = null;
    private final CharSequence textNotificationsMode = null;
    private final CharSequence hotkey = null;
    private final CharSequence textActivationHotkey = null;
    private final Long textOpacitySlider = null;
    private final transient String analyticsSchemaTypeName = "overlay_settings_updated";

    @Override // com.discord.api.science.AnalyticsSchema
    /* renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackOverlaySettingsUpdated)) {
            return false;
        }
        TrackOverlaySettingsUpdated trackOverlaySettingsUpdated = (TrackOverlaySettingsUpdated) other;
        return Intrinsics3.areEqual(this.enabled, trackOverlaySettingsUpdated.enabled) && Intrinsics3.areEqual(this.notificationsEnabled, trackOverlaySettingsUpdated.notificationsEnabled) && Intrinsics3.areEqual(this.notificationsPosition, trackOverlaySettingsUpdated.notificationsPosition) && Intrinsics3.areEqual(this.textNotificationsMode, trackOverlaySettingsUpdated.textNotificationsMode) && Intrinsics3.areEqual(this.hotkey, trackOverlaySettingsUpdated.hotkey) && Intrinsics3.areEqual(this.textActivationHotkey, trackOverlaySettingsUpdated.textActivationHotkey) && Intrinsics3.areEqual(this.textOpacitySlider, trackOverlaySettingsUpdated.textOpacitySlider);
    }

    public int hashCode() {
        Boolean bool = this.enabled;
        int iHashCode = (bool != null ? bool.hashCode() : 0) * 31;
        Boolean bool2 = this.notificationsEnabled;
        int iHashCode2 = (iHashCode + (bool2 != null ? bool2.hashCode() : 0)) * 31;
        CharSequence charSequence = this.notificationsPosition;
        int iHashCode3 = (iHashCode2 + (charSequence != null ? charSequence.hashCode() : 0)) * 31;
        CharSequence charSequence2 = this.textNotificationsMode;
        int iHashCode4 = (iHashCode3 + (charSequence2 != null ? charSequence2.hashCode() : 0)) * 31;
        CharSequence charSequence3 = this.hotkey;
        int iHashCode5 = (iHashCode4 + (charSequence3 != null ? charSequence3.hashCode() : 0)) * 31;
        CharSequence charSequence4 = this.textActivationHotkey;
        int iHashCode6 = (iHashCode5 + (charSequence4 != null ? charSequence4.hashCode() : 0)) * 31;
        Long l = this.textOpacitySlider;
        return iHashCode6 + (l != null ? l.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackOverlaySettingsUpdated(enabled=");
        sbU.append(this.enabled);
        sbU.append(", notificationsEnabled=");
        sbU.append(this.notificationsEnabled);
        sbU.append(", notificationsPosition=");
        sbU.append(this.notificationsPosition);
        sbU.append(", textNotificationsMode=");
        sbU.append(this.textNotificationsMode);
        sbU.append(", hotkey=");
        sbU.append(this.hotkey);
        sbU.append(", textActivationHotkey=");
        sbU.append(this.textActivationHotkey);
        sbU.append(", textOpacitySlider=");
        return outline.G(sbU, this.textOpacitySlider, ")");
    }
}
