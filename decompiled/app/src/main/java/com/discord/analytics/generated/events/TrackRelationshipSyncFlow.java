package com.discord.analytics.generated.events;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.analytics.generated.traits.TrackLocationMetadata;
import com.discord.analytics.generated.traits.TrackLocationMetadata2;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: TrackRelationshipSyncFlow.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\r\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003J\u0010\u0010\u0005\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\b\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b\b\u0010\tJ\u001a\u0010\r\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\nHÖ\u0003¢\u0006\u0004\b\r\u0010\u000eR\u001b\u0010\u0010\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u001b\u0010\u0015\u001a\u0004\u0018\u00010\u00148\u0006@\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R$\u0010\u001a\u001a\u0004\u0018\u00010\u00198\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001b\u0010 \u001a\u0004\u0018\u00010\f8\u0006@\u0006¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#R\u001b\u0010$\u001a\u0004\u0018\u00010\u00148\u0006@\u0006¢\u0006\f\n\u0004\b$\u0010\u0016\u001a\u0004\b%\u0010\u0018R\u001b\u0010&\u001a\u0004\u0018\u00010\f8\u0006@\u0006¢\u0006\f\n\u0004\b&\u0010!\u001a\u0004\b'\u0010#R\u001b\u0010(\u001a\u0004\u0018\u00010\u00148\u0006@\u0006¢\u0006\f\n\u0004\b(\u0010\u0016\u001a\u0004\b)\u0010\u0018R\u001b\u0010*\u001a\u0004\u0018\u00010\f8\u0006@\u0006¢\u0006\f\n\u0004\b*\u0010!\u001a\u0004\b+\u0010#R\u001b\u0010-\u001a\u0004\u0018\u00010,8\u0006@\u0006¢\u0006\f\n\u0004\b-\u0010.\u001a\u0004\b/\u00100R\u001b\u00101\u001a\u0004\u0018\u00010\u00148\u0006@\u0006¢\u0006\f\n\u0004\b1\u0010\u0016\u001a\u0004\b2\u0010\u0018R\u001c\u00103\u001a\u00020\u00048\u0016@\u0016X\u0096D¢\u0006\f\n\u0004\b3\u00104\u001a\u0004\b5\u0010\u0006R$\u00107\u001a\u0004\u0018\u0001068\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b7\u00108\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R\u001b\u0010=\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b=\u0010\u0011\u001a\u0004\b>\u0010\u0013¨\u0006?"}, d2 = {"Lcom/discord/analytics/generated/events/TrackRelationshipSyncFlow;", "Lcom/discord/api/science/AnalyticsSchema;", "Lcom/discord/analytics/generated/traits/TrackBaseReceiver;", "Lcom/discord/analytics/generated/traits/TrackLocationMetadataReceiver;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "numContactsFound", "Ljava/lang/Long;", "getNumContactsFound", "()Ljava/lang/Long;", "", "mobileContactsPermission", "Ljava/lang/CharSequence;", "getMobileContactsPermission", "()Ljava/lang/CharSequence;", "Lcom/discord/analytics/generated/traits/TrackBase;", "trackBase", "Lcom/discord/analytics/generated/traits/TrackBase;", "getTrackBase", "()Lcom/discord/analytics/generated/traits/TrackBase;", "setTrackBase", "(Lcom/discord/analytics/generated/traits/TrackBase;)V", "skip", "Ljava/lang/Boolean;", "getSkip", "()Ljava/lang/Boolean;", "toStep", "getToStep", "back", "getBack", "fromStep", "getFromStep", "hasPhoneNumber", "getHasPhoneNumber", "", "secondsOnFromStep", "Ljava/lang/Float;", "getSecondsOnFromStep", "()Ljava/lang/Float;", "flowType", "getFlowType", "analyticsSchemaTypeName", "Ljava/lang/String;", "d", "Lcom/discord/analytics/generated/traits/TrackLocationMetadata;", "trackLocationMetadata", "Lcom/discord/analytics/generated/traits/TrackLocationMetadata;", "getTrackLocationMetadata", "()Lcom/discord/analytics/generated/traits/TrackLocationMetadata;", "setTrackLocationMetadata", "(Lcom/discord/analytics/generated/traits/TrackLocationMetadata;)V", "numContactsAdded", "getNumContactsAdded", "analytics_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final /* data */ class TrackRelationshipSyncFlow implements AnalyticsSchema, TrackBase2, TrackLocationMetadata2 {
    private TrackBase trackBase;
    private TrackLocationMetadata trackLocationMetadata;
    private final CharSequence flowType = null;
    private final CharSequence fromStep = null;
    private final CharSequence toStep = null;
    private final Boolean skip = null;
    private final Boolean back = null;
    private final Float secondsOnFromStep = null;
    private final Long numContactsFound = null;
    private final Long numContactsAdded = null;
    private final CharSequence mobileContactsPermission = null;
    private final Boolean hasPhoneNumber = null;
    private final transient String analyticsSchemaTypeName = "relationship_sync_flow";

    @Override // com.discord.api.science.AnalyticsSchema
    /* renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackRelationshipSyncFlow)) {
            return false;
        }
        TrackRelationshipSyncFlow trackRelationshipSyncFlow = (TrackRelationshipSyncFlow) other;
        return Intrinsics3.areEqual(this.flowType, trackRelationshipSyncFlow.flowType) && Intrinsics3.areEqual(this.fromStep, trackRelationshipSyncFlow.fromStep) && Intrinsics3.areEqual(this.toStep, trackRelationshipSyncFlow.toStep) && Intrinsics3.areEqual(this.skip, trackRelationshipSyncFlow.skip) && Intrinsics3.areEqual(this.back, trackRelationshipSyncFlow.back) && Intrinsics3.areEqual(this.secondsOnFromStep, trackRelationshipSyncFlow.secondsOnFromStep) && Intrinsics3.areEqual(this.numContactsFound, trackRelationshipSyncFlow.numContactsFound) && Intrinsics3.areEqual(this.numContactsAdded, trackRelationshipSyncFlow.numContactsAdded) && Intrinsics3.areEqual(this.mobileContactsPermission, trackRelationshipSyncFlow.mobileContactsPermission) && Intrinsics3.areEqual(this.hasPhoneNumber, trackRelationshipSyncFlow.hasPhoneNumber);
    }

    public int hashCode() {
        CharSequence charSequence = this.flowType;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        CharSequence charSequence2 = this.fromStep;
        int iHashCode2 = (iHashCode + (charSequence2 != null ? charSequence2.hashCode() : 0)) * 31;
        CharSequence charSequence3 = this.toStep;
        int iHashCode3 = (iHashCode2 + (charSequence3 != null ? charSequence3.hashCode() : 0)) * 31;
        Boolean bool = this.skip;
        int iHashCode4 = (iHashCode3 + (bool != null ? bool.hashCode() : 0)) * 31;
        Boolean bool2 = this.back;
        int iHashCode5 = (iHashCode4 + (bool2 != null ? bool2.hashCode() : 0)) * 31;
        Float f = this.secondsOnFromStep;
        int iHashCode6 = (iHashCode5 + (f != null ? f.hashCode() : 0)) * 31;
        Long l = this.numContactsFound;
        int iHashCode7 = (iHashCode6 + (l != null ? l.hashCode() : 0)) * 31;
        Long l2 = this.numContactsAdded;
        int iHashCode8 = (iHashCode7 + (l2 != null ? l2.hashCode() : 0)) * 31;
        CharSequence charSequence4 = this.mobileContactsPermission;
        int iHashCode9 = (iHashCode8 + (charSequence4 != null ? charSequence4.hashCode() : 0)) * 31;
        Boolean bool3 = this.hasPhoneNumber;
        return iHashCode9 + (bool3 != null ? bool3.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackRelationshipSyncFlow(flowType=");
        sbU.append(this.flowType);
        sbU.append(", fromStep=");
        sbU.append(this.fromStep);
        sbU.append(", toStep=");
        sbU.append(this.toStep);
        sbU.append(", skip=");
        sbU.append(this.skip);
        sbU.append(", back=");
        sbU.append(this.back);
        sbU.append(", secondsOnFromStep=");
        sbU.append(this.secondsOnFromStep);
        sbU.append(", numContactsFound=");
        sbU.append(this.numContactsFound);
        sbU.append(", numContactsAdded=");
        sbU.append(this.numContactsAdded);
        sbU.append(", mobileContactsPermission=");
        sbU.append(this.mobileContactsPermission);
        sbU.append(", hasPhoneNumber=");
        return outline.D(sbU, this.hasPhoneNumber, ")");
    }
}
