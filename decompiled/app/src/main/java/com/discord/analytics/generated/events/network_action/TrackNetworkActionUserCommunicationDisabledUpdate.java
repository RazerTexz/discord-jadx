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

/* compiled from: TrackNetworkActionUserCommunicationDisabledUpdate.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\r\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004BI\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010&\u001a\u0004\u0018\u00010%\u0012\n\b\u0002\u00105\u001a\u0004\u0018\u000104\u0012\u0010\b\u0002\u0010:\u001a\n\u0018\u00010\u0010j\u0004\u0018\u0001`9¢\u0006\u0004\b<\u0010=J\u0010\u0010\u0006\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u001a\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u000bHÖ\u0003¢\u0006\u0004\b\u000e\u0010\u000fR\u001b\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001b\u0010\u0015\u001a\u0004\u0018\u00010\u00108\u0006@\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0012\u001a\u0004\b\u0016\u0010\u0014R$\u0010\u0018\u001a\u0004\u0018\u00010\u00178\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR$\u0010\u001f\u001a\u0004\u0018\u00010\u001e8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u001b\u0010&\u001a\u0004\u0018\u00010%8\u0006@\u0006¢\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)R$\u0010+\u001a\u0004\u0018\u00010*8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\u001c\u00101\u001a\u00020\u00058\u0016@\u0016X\u0096D¢\u0006\f\n\u0004\b1\u00102\u001a\u0004\b3\u0010\u0007R\u001b\u00105\u001a\u0004\u0018\u0001048\u0006@\u0006¢\u0006\f\n\u0004\b5\u00106\u001a\u0004\b7\u00108R!\u0010:\u001a\n\u0018\u00010\u0010j\u0004\u0018\u0001`98\u0006@\u0006¢\u0006\f\n\u0004\b:\u0010\u0012\u001a\u0004\b;\u0010\u0014¨\u0006>"}, d2 = {"Lcom/discord/analytics/generated/events/network_action/TrackNetworkActionUserCommunicationDisabledUpdate;", "Lcom/discord/api/science/AnalyticsSchema;", "Lcom/discord/analytics/generated/traits/TrackBaseReceiver;", "Lcom/discord/analytics/generated/traits/TrackLocationMetadataReceiver;", "Lcom/discord/analytics/generated/traits/TrackNetworkMetadataReceiver;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "targetUserId", "Ljava/lang/Long;", "getTargetUserId", "()Ljava/lang/Long;", "guildId", "getGuildId", "Lcom/discord/analytics/generated/traits/TrackNetworkMetadata;", "trackNetworkMetadata", "Lcom/discord/analytics/generated/traits/TrackNetworkMetadata;", "getTrackNetworkMetadata", "()Lcom/discord/analytics/generated/traits/TrackNetworkMetadata;", "b", "(Lcom/discord/analytics/generated/traits/TrackNetworkMetadata;)V", "Lcom/discord/analytics/generated/traits/TrackBase;", "trackBase", "Lcom/discord/analytics/generated/traits/TrackBase;", "getTrackBase", "()Lcom/discord/analytics/generated/traits/TrackBase;", "setTrackBase", "(Lcom/discord/analytics/generated/traits/TrackBase;)V", "", "duration", "Ljava/lang/Float;", "getDuration", "()Ljava/lang/Float;", "Lcom/discord/analytics/generated/traits/TrackLocationMetadata;", "trackLocationMetadata", "Lcom/discord/analytics/generated/traits/TrackLocationMetadata;", "getTrackLocationMetadata", "()Lcom/discord/analytics/generated/traits/TrackLocationMetadata;", "setTrackLocationMetadata", "(Lcom/discord/analytics/generated/traits/TrackLocationMetadata;)V", "analyticsSchemaTypeName", "Ljava/lang/String;", "d", "", ModelAuditLogEntry.CHANGE_KEY_REASON, "Ljava/lang/CharSequence;", "getReason", "()Ljava/lang/CharSequence;", "Lcom/discord/primitives/Timestamp;", "communicationDisabledUntil", "getCommunicationDisabledUntil", "<init>", "(Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Float;Ljava/lang/CharSequence;Ljava/lang/Long;)V", "analytics_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final /* data */ class TrackNetworkActionUserCommunicationDisabledUpdate implements AnalyticsSchema, TrackBase2, TrackLocationMetadata2, TrackNetworkMetadata2 {
    private final transient String analyticsSchemaTypeName;
    private final Long communicationDisabledUntil;
    private final Float duration;
    private final Long guildId;
    private final CharSequence reason;
    private final Long targetUserId;
    private TrackBase trackBase;
    private TrackLocationMetadata trackLocationMetadata;
    private TrackNetworkMetadata trackNetworkMetadata;

    public TrackNetworkActionUserCommunicationDisabledUpdate(Long l, Long l2, Float f, CharSequence charSequence, Long l3) {
        this.guildId = l;
        this.targetUserId = l2;
        this.duration = f;
        this.reason = charSequence;
        this.communicationDisabledUntil = l3;
        this.analyticsSchemaTypeName = "network_action_user_communication_disabled_update";
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
        if (!(other instanceof TrackNetworkActionUserCommunicationDisabledUpdate)) {
            return false;
        }
        TrackNetworkActionUserCommunicationDisabledUpdate trackNetworkActionUserCommunicationDisabledUpdate = (TrackNetworkActionUserCommunicationDisabledUpdate) other;
        return Intrinsics3.areEqual(this.guildId, trackNetworkActionUserCommunicationDisabledUpdate.guildId) && Intrinsics3.areEqual(this.targetUserId, trackNetworkActionUserCommunicationDisabledUpdate.targetUserId) && Intrinsics3.areEqual(this.duration, trackNetworkActionUserCommunicationDisabledUpdate.duration) && Intrinsics3.areEqual(this.reason, trackNetworkActionUserCommunicationDisabledUpdate.reason) && Intrinsics3.areEqual(this.communicationDisabledUntil, trackNetworkActionUserCommunicationDisabledUpdate.communicationDisabledUntil);
    }

    public int hashCode() {
        Long l = this.guildId;
        int iHashCode = (l != null ? l.hashCode() : 0) * 31;
        Long l2 = this.targetUserId;
        int iHashCode2 = (iHashCode + (l2 != null ? l2.hashCode() : 0)) * 31;
        Float f = this.duration;
        int iHashCode3 = (iHashCode2 + (f != null ? f.hashCode() : 0)) * 31;
        CharSequence charSequence = this.reason;
        int iHashCode4 = (iHashCode3 + (charSequence != null ? charSequence.hashCode() : 0)) * 31;
        Long l3 = this.communicationDisabledUntil;
        return iHashCode4 + (l3 != null ? l3.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackNetworkActionUserCommunicationDisabledUpdate(guildId=");
        sbU.append(this.guildId);
        sbU.append(", targetUserId=");
        sbU.append(this.targetUserId);
        sbU.append(", duration=");
        sbU.append(this.duration);
        sbU.append(", reason=");
        sbU.append(this.reason);
        sbU.append(", communicationDisabledUntil=");
        return outline.G(sbU, this.communicationDisabledUntil, ")");
    }

    public TrackNetworkActionUserCommunicationDisabledUpdate() {
        this(null, null, null, null, null);
    }
}
