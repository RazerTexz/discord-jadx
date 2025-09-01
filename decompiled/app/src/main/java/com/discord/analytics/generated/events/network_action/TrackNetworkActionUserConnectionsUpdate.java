package com.discord.analytics.generated.events.network_action;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.analytics.generated.traits.TrackLocationMetadata;
import com.discord.analytics.generated.traits.TrackLocationMetadata2;
import com.discord.analytics.generated.traits.TrackNetworkMetadata;
import com.discord.analytics.generated.traits.TrackNetworkMetadata2;
import com.discord.api.science.AnalyticsSchema;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: TrackNetworkActionUserConnectionsUpdate.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u001a\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u000bHÖ\u0003¢\u0006\u0004\b\u000e\u0010\u000fR\u001b\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R$\u0010\u0016\u001a\u0004\u0018\u00010\u00158\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001b\u0010\u001c\u001a\u0004\u0018\u00010\r8\u0006@\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR$\u0010!\u001a\u0004\u0018\u00010 8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u001b\u0010'\u001a\u0004\u0018\u00010\r8\u0006@\u0006¢\u0006\f\n\u0004\b'\u0010\u001d\u001a\u0004\b(\u0010\u001fR$\u0010*\u001a\u0004\u0018\u00010)8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\u001c\u00100\u001a\u00020\u00058\u0016@\u0016X\u0096D¢\u0006\f\n\u0004\b0\u00101\u001a\u0004\b2\u0010\u0007R\u001b\u00103\u001a\u0004\u0018\u00010\r8\u0006@\u0006¢\u0006\f\n\u0004\b3\u0010\u001d\u001a\u0004\b4\u0010\u001f¨\u00065"}, d2 = {"Lcom/discord/analytics/generated/events/network_action/TrackNetworkActionUserConnectionsUpdate;", "Lcom/discord/api/science/AnalyticsSchema;", "Lcom/discord/analytics/generated/traits/TrackBaseReceiver;", "Lcom/discord/analytics/generated/traits/TrackLocationMetadataReceiver;", "Lcom/discord/analytics/generated/traits/TrackNetworkMetadataReceiver;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", ModelAuditLogEntry.CHANGE_KEY_NAME, "Ljava/lang/CharSequence;", "getName", "()Ljava/lang/CharSequence;", "Lcom/discord/analytics/generated/traits/TrackNetworkMetadata;", "trackNetworkMetadata", "Lcom/discord/analytics/generated/traits/TrackNetworkMetadata;", "getTrackNetworkMetadata", "()Lcom/discord/analytics/generated/traits/TrackNetworkMetadata;", "b", "(Lcom/discord/analytics/generated/traits/TrackNetworkMetadata;)V", "friendSync", "Ljava/lang/Boolean;", "getFriendSync", "()Ljava/lang/Boolean;", "Lcom/discord/analytics/generated/traits/TrackBase;", "trackBase", "Lcom/discord/analytics/generated/traits/TrackBase;", "getTrackBase", "()Lcom/discord/analytics/generated/traits/TrackBase;", "setTrackBase", "(Lcom/discord/analytics/generated/traits/TrackBase;)V", "visibility", "getVisibility", "Lcom/discord/analytics/generated/traits/TrackLocationMetadata;", "trackLocationMetadata", "Lcom/discord/analytics/generated/traits/TrackLocationMetadata;", "getTrackLocationMetadata", "()Lcom/discord/analytics/generated/traits/TrackLocationMetadata;", "setTrackLocationMetadata", "(Lcom/discord/analytics/generated/traits/TrackLocationMetadata;)V", "analyticsSchemaTypeName", "Ljava/lang/String;", "d", "showActivity", "getShowActivity", "analytics_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final /* data */ class TrackNetworkActionUserConnectionsUpdate implements AnalyticsSchema, TrackBase2, TrackLocationMetadata2, TrackNetworkMetadata2 {
    private final transient String analyticsSchemaTypeName;
    private final Boolean friendSync;
    private final CharSequence name;
    private final Boolean showActivity;
    private TrackBase trackBase;
    private TrackLocationMetadata trackLocationMetadata;
    private TrackNetworkMetadata trackNetworkMetadata;
    private final Boolean visibility;

    public TrackNetworkActionUserConnectionsUpdate() {
        this(null, null, null, null, 15);
    }

    public TrackNetworkActionUserConnectionsUpdate(CharSequence charSequence, Boolean bool, Boolean bool2, Boolean bool3, int i) {
        charSequence = (i & 1) != 0 ? null : charSequence;
        bool = (i & 2) != 0 ? null : bool;
        int i2 = i & 4;
        int i3 = i & 8;
        this.name = charSequence;
        this.friendSync = bool;
        this.visibility = null;
        this.showActivity = null;
        this.analyticsSchemaTypeName = "network_action_user_connections_update";
    }

    @Override // com.discord.analytics.generated.traits.TrackNetworkMetadata2
    public void b(TrackNetworkMetadata trackNetworkMetadata) {
        this.trackNetworkMetadata = trackNetworkMetadata;
    }

    @Override // com.discord.api.science.AnalyticsSchema
    /* renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackNetworkActionUserConnectionsUpdate)) {
            return false;
        }
        TrackNetworkActionUserConnectionsUpdate trackNetworkActionUserConnectionsUpdate = (TrackNetworkActionUserConnectionsUpdate) other;
        return Intrinsics3.areEqual(this.name, trackNetworkActionUserConnectionsUpdate.name) && Intrinsics3.areEqual(this.friendSync, trackNetworkActionUserConnectionsUpdate.friendSync) && Intrinsics3.areEqual(this.visibility, trackNetworkActionUserConnectionsUpdate.visibility) && Intrinsics3.areEqual(this.showActivity, trackNetworkActionUserConnectionsUpdate.showActivity);
    }

    public int hashCode() {
        CharSequence charSequence = this.name;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        Boolean bool = this.friendSync;
        int iHashCode2 = (iHashCode + (bool != null ? bool.hashCode() : 0)) * 31;
        Boolean bool2 = this.visibility;
        int iHashCode3 = (iHashCode2 + (bool2 != null ? bool2.hashCode() : 0)) * 31;
        Boolean bool3 = this.showActivity;
        return iHashCode3 + (bool3 != null ? bool3.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackNetworkActionUserConnectionsUpdate(name=");
        sbU.append(this.name);
        sbU.append(", friendSync=");
        sbU.append(this.friendSync);
        sbU.append(", visibility=");
        sbU.append(this.visibility);
        sbU.append(", showActivity=");
        return outline.D(sbU, this.showActivity, ")");
    }
}
