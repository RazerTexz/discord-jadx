package com.discord.analytics.generated.events;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Intrinsics3;
import java.util.List;
import kotlin.Metadata;

/* compiled from: TrackSmiteActionClassification.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\r\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0012\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u0002J\u0010\u0010\u0004\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u001a\u0010\f\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\tHÖ\u0003¢\u0006\u0004\b\f\u0010\rR#\u0010\u0010\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u001b\u0010\u0014\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u001b\u0010\u0019\u001a\u0004\u0018\u00010\u00188\u0006@\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u001b\u0010\u001d\u001a\u0004\u0018\u00010\u00188\u0006@\u0006¢\u0006\f\n\u0004\b\u001d\u0010\u001a\u001a\u0004\b\u001e\u0010\u001cR\u001b\u0010\u001f\u001a\u0004\u0018\u00010\u00188\u0006@\u0006¢\u0006\f\n\u0004\b\u001f\u0010\u001a\u001a\u0004\b \u0010\u001cR\u001b\u0010!\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b!\u0010\u0015\u001a\u0004\b\"\u0010\u0017R#\u0010#\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b#\u0010\u0011\u001a\u0004\b$\u0010\u0013R\u001b\u0010%\u001a\u0004\u0018\u00010\u00188\u0006@\u0006¢\u0006\f\n\u0004\b%\u0010\u001a\u001a\u0004\b&\u0010\u001cR\u001b\u0010'\u001a\u0004\u0018\u00010\u00188\u0006@\u0006¢\u0006\f\n\u0004\b'\u0010\u001a\u001a\u0004\b(\u0010\u001cR\u001b\u0010)\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b)\u0010\u0015\u001a\u0004\b*\u0010\u0017R$\u0010,\u001a\u0004\u0018\u00010+8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\u001b\u00102\u001a\u0004\u0018\u00010\u00188\u0006@\u0006¢\u0006\f\n\u0004\b2\u0010\u001a\u001a\u0004\b3\u0010\u001cR#\u00104\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b4\u0010\u0011\u001a\u0004\b5\u0010\u0013R\u001b\u00106\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b6\u0010\u0015\u001a\u0004\b7\u0010\u0017R#\u00108\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b8\u0010\u0011\u001a\u0004\b9\u0010\u0013R\u001c\u0010:\u001a\u00020\u00038\u0016@\u0016X\u0096D¢\u0006\f\n\u0004\b:\u0010;\u001a\u0004\b<\u0010\u0005¨\u0006="}, d2 = {"Lcom/discord/analytics/generated/events/TrackSmiteActionClassification;", "Lcom/discord/api/science/AnalyticsSchema;", "Lcom/discord/analytics/generated/traits/TrackBaseReceiver;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "", "labelReasons", "Ljava/util/List;", "getLabelReasons", "()Ljava/util/List;", "rulesSourceSha", "Ljava/lang/CharSequence;", "getRulesSourceSha", "()Ljava/lang/CharSequence;", "", "locationChannelType", "Ljava/lang/Long;", "getLocationChannelType", "()Ljava/lang/Long;", "locationGuildId", "getLocationGuildId", "locationMessageId", "getLocationMessageId", "rulesGitSha", "getRulesGitSha", "labels", "getLabels", "locationChannelId", "getLocationChannelId", "guildId", "getGuildId", "actionName", "getActionName", "Lcom/discord/analytics/generated/traits/TrackBase;", "trackBase", "Lcom/discord/analytics/generated/traits/TrackBase;", "getTrackBase", "()Lcom/discord/analytics/generated/traits/TrackBase;", "setTrackBase", "(Lcom/discord/analytics/generated/traits/TrackBase;)V", "channelId", "getChannelId", "labelReasonsShas", "getLabelReasonsShas", "actionId", "getActionId", "labelStatuses", "getLabelStatuses", "analyticsSchemaTypeName", "Ljava/lang/String;", "d", "analytics_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final /* data */ class TrackSmiteActionClassification implements AnalyticsSchema, TrackBase2 {
    private TrackBase trackBase;
    private final CharSequence actionName = null;
    private final CharSequence actionId = null;
    private final CharSequence rulesGitSha = null;
    private final CharSequence rulesSourceSha = null;
    private final List<CharSequence> labels = null;
    private final List<CharSequence> labelStatuses = null;
    private final List<CharSequence> labelReasons = null;
    private final List<CharSequence> labelReasonsShas = null;
    private final Long guildId = null;
    private final Long channelId = null;
    private final Long locationGuildId = null;
    private final Long locationChannelId = null;
    private final Long locationChannelType = null;
    private final Long locationMessageId = null;
    private final transient String analyticsSchemaTypeName = "smite_action_classification";

    @Override // com.discord.api.science.AnalyticsSchema
    /* renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackSmiteActionClassification)) {
            return false;
        }
        TrackSmiteActionClassification trackSmiteActionClassification = (TrackSmiteActionClassification) other;
        return Intrinsics3.areEqual(this.actionName, trackSmiteActionClassification.actionName) && Intrinsics3.areEqual(this.actionId, trackSmiteActionClassification.actionId) && Intrinsics3.areEqual(this.rulesGitSha, trackSmiteActionClassification.rulesGitSha) && Intrinsics3.areEqual(this.rulesSourceSha, trackSmiteActionClassification.rulesSourceSha) && Intrinsics3.areEqual(this.labels, trackSmiteActionClassification.labels) && Intrinsics3.areEqual(this.labelStatuses, trackSmiteActionClassification.labelStatuses) && Intrinsics3.areEqual(this.labelReasons, trackSmiteActionClassification.labelReasons) && Intrinsics3.areEqual(this.labelReasonsShas, trackSmiteActionClassification.labelReasonsShas) && Intrinsics3.areEqual(this.guildId, trackSmiteActionClassification.guildId) && Intrinsics3.areEqual(this.channelId, trackSmiteActionClassification.channelId) && Intrinsics3.areEqual(this.locationGuildId, trackSmiteActionClassification.locationGuildId) && Intrinsics3.areEqual(this.locationChannelId, trackSmiteActionClassification.locationChannelId) && Intrinsics3.areEqual(this.locationChannelType, trackSmiteActionClassification.locationChannelType) && Intrinsics3.areEqual(this.locationMessageId, trackSmiteActionClassification.locationMessageId);
    }

    public int hashCode() {
        CharSequence charSequence = this.actionName;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        CharSequence charSequence2 = this.actionId;
        int iHashCode2 = (iHashCode + (charSequence2 != null ? charSequence2.hashCode() : 0)) * 31;
        CharSequence charSequence3 = this.rulesGitSha;
        int iHashCode3 = (iHashCode2 + (charSequence3 != null ? charSequence3.hashCode() : 0)) * 31;
        CharSequence charSequence4 = this.rulesSourceSha;
        int iHashCode4 = (iHashCode3 + (charSequence4 != null ? charSequence4.hashCode() : 0)) * 31;
        List<CharSequence> list = this.labels;
        int iHashCode5 = (iHashCode4 + (list != null ? list.hashCode() : 0)) * 31;
        List<CharSequence> list2 = this.labelStatuses;
        int iHashCode6 = (iHashCode5 + (list2 != null ? list2.hashCode() : 0)) * 31;
        List<CharSequence> list3 = this.labelReasons;
        int iHashCode7 = (iHashCode6 + (list3 != null ? list3.hashCode() : 0)) * 31;
        List<CharSequence> list4 = this.labelReasonsShas;
        int iHashCode8 = (iHashCode7 + (list4 != null ? list4.hashCode() : 0)) * 31;
        Long l = this.guildId;
        int iHashCode9 = (iHashCode8 + (l != null ? l.hashCode() : 0)) * 31;
        Long l2 = this.channelId;
        int iHashCode10 = (iHashCode9 + (l2 != null ? l2.hashCode() : 0)) * 31;
        Long l3 = this.locationGuildId;
        int iHashCode11 = (iHashCode10 + (l3 != null ? l3.hashCode() : 0)) * 31;
        Long l4 = this.locationChannelId;
        int iHashCode12 = (iHashCode11 + (l4 != null ? l4.hashCode() : 0)) * 31;
        Long l5 = this.locationChannelType;
        int iHashCode13 = (iHashCode12 + (l5 != null ? l5.hashCode() : 0)) * 31;
        Long l6 = this.locationMessageId;
        return iHashCode13 + (l6 != null ? l6.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackSmiteActionClassification(actionName=");
        sbU.append(this.actionName);
        sbU.append(", actionId=");
        sbU.append(this.actionId);
        sbU.append(", rulesGitSha=");
        sbU.append(this.rulesGitSha);
        sbU.append(", rulesSourceSha=");
        sbU.append(this.rulesSourceSha);
        sbU.append(", labels=");
        sbU.append(this.labels);
        sbU.append(", labelStatuses=");
        sbU.append(this.labelStatuses);
        sbU.append(", labelReasons=");
        sbU.append(this.labelReasons);
        sbU.append(", labelReasonsShas=");
        sbU.append(this.labelReasonsShas);
        sbU.append(", guildId=");
        sbU.append(this.guildId);
        sbU.append(", channelId=");
        sbU.append(this.channelId);
        sbU.append(", locationGuildId=");
        sbU.append(this.locationGuildId);
        sbU.append(", locationChannelId=");
        sbU.append(this.locationChannelId);
        sbU.append(", locationChannelType=");
        sbU.append(this.locationChannelType);
        sbU.append(", locationMessageId=");
        return outline.G(sbU, this.locationMessageId, ")");
    }
}
