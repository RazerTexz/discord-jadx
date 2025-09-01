package com.discord.analytics.generated.events;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: TrackAfCustomizationSaved.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\r\n\u0002\u0010\r\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u0002J\u0010\u0010\u0004\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u001a\u0010\f\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\tHÖ\u0003¢\u0006\u0004\b\f\u0010\rR\u001b\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0013\u001a\u00020\u00038\u0016@\u0016X\u0096D¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0005R\u001b\u0010\u0016\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0010\u001a\u0004\b\u0017\u0010\u0012R\u001b\u0010\u0018\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0010\u001a\u0004\b\u0019\u0010\u0012R\u001b\u0010\u001a\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u0010\u001a\u0004\b\u001b\u0010\u0012R\u001b\u0010\u001d\u001a\u0004\u0018\u00010\u001c8\u0006@\u0006¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 R$\u0010\"\u001a\u0004\u0018\u00010!8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u001b\u0010(\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b(\u0010\u0010\u001a\u0004\b)\u0010\u0012¨\u0006*"}, d2 = {"Lcom/discord/analytics/generated/events/TrackAfCustomizationSaved;", "Lcom/discord/api/science/AnalyticsSchema;", "Lcom/discord/analytics/generated/traits/TrackBaseReceiver;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "removedMemberCount", "Ljava/lang/Long;", "getRemovedMemberCount", "()Ljava/lang/Long;", "analyticsSchemaTypeName", "Ljava/lang/String;", "d", "addedMemberCount", "getAddedMemberCount", "selectedSuggestedCount", "getSelectedSuggestedCount", "selectedTotalCount", "getSelectedTotalCount", "", "loadId", "Ljava/lang/CharSequence;", "getLoadId", "()Ljava/lang/CharSequence;", "Lcom/discord/analytics/generated/traits/TrackBase;", "trackBase", "Lcom/discord/analytics/generated/traits/TrackBase;", "getTrackBase", "()Lcom/discord/analytics/generated/traits/TrackBase;", "setTrackBase", "(Lcom/discord/analytics/generated/traits/TrackBase;)V", "selectedFriendCount", "getSelectedFriendCount", "analytics_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final /* data */ class TrackAfCustomizationSaved implements AnalyticsSchema, TrackBase2 {
    private TrackBase trackBase;
    private final CharSequence loadId = null;
    private final Long addedMemberCount = null;
    private final Long removedMemberCount = null;
    private final Long selectedFriendCount = null;
    private final Long selectedTotalCount = null;
    private final Long selectedSuggestedCount = null;
    private final transient String analyticsSchemaTypeName = "af_customization_saved";

    @Override // com.discord.api.science.AnalyticsSchema
    /* renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackAfCustomizationSaved)) {
            return false;
        }
        TrackAfCustomizationSaved trackAfCustomizationSaved = (TrackAfCustomizationSaved) other;
        return Intrinsics3.areEqual(this.loadId, trackAfCustomizationSaved.loadId) && Intrinsics3.areEqual(this.addedMemberCount, trackAfCustomizationSaved.addedMemberCount) && Intrinsics3.areEqual(this.removedMemberCount, trackAfCustomizationSaved.removedMemberCount) && Intrinsics3.areEqual(this.selectedFriendCount, trackAfCustomizationSaved.selectedFriendCount) && Intrinsics3.areEqual(this.selectedTotalCount, trackAfCustomizationSaved.selectedTotalCount) && Intrinsics3.areEqual(this.selectedSuggestedCount, trackAfCustomizationSaved.selectedSuggestedCount);
    }

    public int hashCode() {
        CharSequence charSequence = this.loadId;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        Long l = this.addedMemberCount;
        int iHashCode2 = (iHashCode + (l != null ? l.hashCode() : 0)) * 31;
        Long l2 = this.removedMemberCount;
        int iHashCode3 = (iHashCode2 + (l2 != null ? l2.hashCode() : 0)) * 31;
        Long l3 = this.selectedFriendCount;
        int iHashCode4 = (iHashCode3 + (l3 != null ? l3.hashCode() : 0)) * 31;
        Long l4 = this.selectedTotalCount;
        int iHashCode5 = (iHashCode4 + (l4 != null ? l4.hashCode() : 0)) * 31;
        Long l5 = this.selectedSuggestedCount;
        return iHashCode5 + (l5 != null ? l5.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackAfCustomizationSaved(loadId=");
        sbU.append(this.loadId);
        sbU.append(", addedMemberCount=");
        sbU.append(this.addedMemberCount);
        sbU.append(", removedMemberCount=");
        sbU.append(this.removedMemberCount);
        sbU.append(", selectedFriendCount=");
        sbU.append(this.selectedFriendCount);
        sbU.append(", selectedTotalCount=");
        sbU.append(this.selectedTotalCount);
        sbU.append(", selectedSuggestedCount=");
        return outline.G(sbU, this.selectedSuggestedCount, ")");
    }
}
