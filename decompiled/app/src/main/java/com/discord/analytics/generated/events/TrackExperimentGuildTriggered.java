package com.discord.analytics.generated.events;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.api.science.AnalyticsSchema;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: TrackExperimentGuildTriggered.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\r\n\u0002\b\u0010\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u0002J\u0010\u0010\u0004\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u001a\u0010\f\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\tHÖ\u0003¢\u0006\u0004\b\f\u0010\rR$\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001b\u0010\u0016\u001a\u0004\u0018\u00010\u00158\u0006@\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u001b\u0010\u001a\u001a\u0004\u0018\u00010\u00158\u0006@\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u0017\u001a\u0004\b\u001b\u0010\u0019R\u001b\u0010\u001d\u001a\u0004\u0018\u00010\u001c8\u0006@\u0006¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u001b\u0010!\u001a\u0004\u0018\u00010\u001c8\u0006@\u0006¢\u0006\f\n\u0004\b!\u0010\u001e\u001a\u0004\b\"\u0010 R\u001b\u0010#\u001a\u0004\u0018\u00010\u00158\u0006@\u0006¢\u0006\f\n\u0004\b#\u0010\u0017\u001a\u0004\b$\u0010\u0019R\u001b\u0010%\u001a\u0004\u0018\u00010\u00158\u0006@\u0006¢\u0006\f\n\u0004\b%\u0010\u0017\u001a\u0004\b&\u0010\u0019R\u001c\u0010'\u001a\u00020\u00038\u0016@\u0016X\u0096D¢\u0006\f\n\u0004\b'\u0010(\u001a\u0004\b)\u0010\u0005R\u001b\u0010*\u001a\u0004\u0018\u00010\u00158\u0006@\u0006¢\u0006\f\n\u0004\b*\u0010\u0017\u001a\u0004\b+\u0010\u0019¨\u0006,"}, d2 = {"Lcom/discord/analytics/generated/events/TrackExperimentGuildTriggered;", "Lcom/discord/api/science/AnalyticsSchema;", "Lcom/discord/analytics/generated/traits/TrackBaseReceiver;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/discord/analytics/generated/traits/TrackBase;", "trackBase", "Lcom/discord/analytics/generated/traits/TrackBase;", "getTrackBase", "()Lcom/discord/analytics/generated/traits/TrackBase;", "setTrackBase", "(Lcom/discord/analytics/generated/traits/TrackBase;)V", "", "guildId", "Ljava/lang/Long;", "getGuildId", "()Ljava/lang/Long;", "bucket", "getBucket", "", "linkedUserExperimentName", "Ljava/lang/CharSequence;", "getLinkedUserExperimentName", "()Ljava/lang/CharSequence;", ModelAuditLogEntry.CHANGE_KEY_NAME, "getName", "revision", "getRevision", "linkedUserExperimentRevision", "getLinkedUserExperimentRevision", "analyticsSchemaTypeName", "Ljava/lang/String;", "d", "linkedUserExperimentBucket", "getLinkedUserExperimentBucket", "analytics_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final /* data */ class TrackExperimentGuildTriggered implements AnalyticsSchema, TrackBase2 {
    private TrackBase trackBase;
    private final CharSequence name = null;
    private final Long bucket = null;
    private final Long revision = null;
    private final Long guildId = null;
    private final CharSequence linkedUserExperimentName = null;
    private final Long linkedUserExperimentBucket = null;
    private final Long linkedUserExperimentRevision = null;
    private final transient String analyticsSchemaTypeName = "experiment_guild_triggered";

    @Override // com.discord.api.science.AnalyticsSchema
    /* renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackExperimentGuildTriggered)) {
            return false;
        }
        TrackExperimentGuildTriggered trackExperimentGuildTriggered = (TrackExperimentGuildTriggered) other;
        return Intrinsics3.areEqual(this.name, trackExperimentGuildTriggered.name) && Intrinsics3.areEqual(this.bucket, trackExperimentGuildTriggered.bucket) && Intrinsics3.areEqual(this.revision, trackExperimentGuildTriggered.revision) && Intrinsics3.areEqual(this.guildId, trackExperimentGuildTriggered.guildId) && Intrinsics3.areEqual(this.linkedUserExperimentName, trackExperimentGuildTriggered.linkedUserExperimentName) && Intrinsics3.areEqual(this.linkedUserExperimentBucket, trackExperimentGuildTriggered.linkedUserExperimentBucket) && Intrinsics3.areEqual(this.linkedUserExperimentRevision, trackExperimentGuildTriggered.linkedUserExperimentRevision);
    }

    public int hashCode() {
        CharSequence charSequence = this.name;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        Long l = this.bucket;
        int iHashCode2 = (iHashCode + (l != null ? l.hashCode() : 0)) * 31;
        Long l2 = this.revision;
        int iHashCode3 = (iHashCode2 + (l2 != null ? l2.hashCode() : 0)) * 31;
        Long l3 = this.guildId;
        int iHashCode4 = (iHashCode3 + (l3 != null ? l3.hashCode() : 0)) * 31;
        CharSequence charSequence2 = this.linkedUserExperimentName;
        int iHashCode5 = (iHashCode4 + (charSequence2 != null ? charSequence2.hashCode() : 0)) * 31;
        Long l4 = this.linkedUserExperimentBucket;
        int iHashCode6 = (iHashCode5 + (l4 != null ? l4.hashCode() : 0)) * 31;
        Long l5 = this.linkedUserExperimentRevision;
        return iHashCode6 + (l5 != null ? l5.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackExperimentGuildTriggered(name=");
        sbU.append(this.name);
        sbU.append(", bucket=");
        sbU.append(this.bucket);
        sbU.append(", revision=");
        sbU.append(this.revision);
        sbU.append(", guildId=");
        sbU.append(this.guildId);
        sbU.append(", linkedUserExperimentName=");
        sbU.append(this.linkedUserExperimentName);
        sbU.append(", linkedUserExperimentBucket=");
        sbU.append(this.linkedUserExperimentBucket);
        sbU.append(", linkedUserExperimentRevision=");
        return outline.G(sbU, this.linkedUserExperimentRevision, ")");
    }
}
