package com.discord.analytics.generated.events.network_action;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.analytics.generated.traits.TrackLocationMetadata;
import com.discord.analytics.generated.traits.TrackLocationMetadata2;
import com.discord.analytics.generated.traits.TrackNetworkMetadata;
import com.discord.analytics.generated.traits.TrackNetworkMetadata2;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: TrackNetworkActionBugReportSubmit.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\r\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u001a\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u000bHÖ\u0003¢\u0006\u0004\b\u000e\u0010\u000fR$\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001b\u0010\u0018\u001a\u0004\u0018\u00010\u00178\u0006@\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR$\u0010\u001d\u001a\u0004\u0018\u00010\u001c8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R$\u0010$\u001a\u0004\u0018\u00010#8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u001b\u0010+\u001a\u0004\u0018\u00010*8\u0006@\u0006¢\u0006\f\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.R\u001c\u0010/\u001a\u00020\u00058\u0016@\u0016X\u0096D¢\u0006\f\n\u0004\b/\u00100\u001a\u0004\b1\u0010\u0007¨\u00062"}, d2 = {"Lcom/discord/analytics/generated/events/network_action/TrackNetworkActionBugReportSubmit;", "Lcom/discord/api/science/AnalyticsSchema;", "Lcom/discord/analytics/generated/traits/TrackBaseReceiver;", "Lcom/discord/analytics/generated/traits/TrackLocationMetadataReceiver;", "Lcom/discord/analytics/generated/traits/TrackNetworkMetadataReceiver;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/discord/analytics/generated/traits/TrackLocationMetadata;", "trackLocationMetadata", "Lcom/discord/analytics/generated/traits/TrackLocationMetadata;", "getTrackLocationMetadata", "()Lcom/discord/analytics/generated/traits/TrackLocationMetadata;", "setTrackLocationMetadata", "(Lcom/discord/analytics/generated/traits/TrackLocationMetadata;)V", "", "priority", "Ljava/lang/Long;", "getPriority", "()Ljava/lang/Long;", "Lcom/discord/analytics/generated/traits/TrackBase;", "trackBase", "Lcom/discord/analytics/generated/traits/TrackBase;", "getTrackBase", "()Lcom/discord/analytics/generated/traits/TrackBase;", "setTrackBase", "(Lcom/discord/analytics/generated/traits/TrackBase;)V", "Lcom/discord/analytics/generated/traits/TrackNetworkMetadata;", "trackNetworkMetadata", "Lcom/discord/analytics/generated/traits/TrackNetworkMetadata;", "getTrackNetworkMetadata", "()Lcom/discord/analytics/generated/traits/TrackNetworkMetadata;", "b", "(Lcom/discord/analytics/generated/traits/TrackNetworkMetadata;)V", "", "asanaInboxId", "Ljava/lang/CharSequence;", "getAsanaInboxId", "()Ljava/lang/CharSequence;", "analyticsSchemaTypeName", "Ljava/lang/String;", "d", "analytics_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final /* data */ class TrackNetworkActionBugReportSubmit implements AnalyticsSchema, TrackBase2, TrackLocationMetadata2, TrackNetworkMetadata2 {
    private TrackBase trackBase;
    private TrackLocationMetadata trackLocationMetadata;
    private TrackNetworkMetadata trackNetworkMetadata;
    private final Long priority = null;
    private final CharSequence asanaInboxId = null;
    private final transient String analyticsSchemaTypeName = "network_action_bug_report_submit";

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
        if (!(other instanceof TrackNetworkActionBugReportSubmit)) {
            return false;
        }
        TrackNetworkActionBugReportSubmit trackNetworkActionBugReportSubmit = (TrackNetworkActionBugReportSubmit) other;
        return Intrinsics3.areEqual(this.priority, trackNetworkActionBugReportSubmit.priority) && Intrinsics3.areEqual(this.asanaInboxId, trackNetworkActionBugReportSubmit.asanaInboxId);
    }

    public int hashCode() {
        Long l = this.priority;
        int iHashCode = (l != null ? l.hashCode() : 0) * 31;
        CharSequence charSequence = this.asanaInboxId;
        return iHashCode + (charSequence != null ? charSequence.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackNetworkActionBugReportSubmit(priority=");
        sbU.append(this.priority);
        sbU.append(", asanaInboxId=");
        return outline.E(sbU, this.asanaInboxId, ")");
    }
}
