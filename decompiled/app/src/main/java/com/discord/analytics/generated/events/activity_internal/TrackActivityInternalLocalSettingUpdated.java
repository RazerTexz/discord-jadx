package com.discord.analytics.generated.events.activity_internal;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackActivityInternalMetadata;
import com.discord.analytics.generated.traits.TrackActivityInternalMetadata2;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: TrackActivityInternalLocalSettingUpdated.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\r\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003J\u0010\u0010\u0005\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\b\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b\b\u0010\tJ\u001a\u0010\r\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\nHÖ\u0003¢\u0006\u0004\b\r\u0010\u000eR\u001b\u0010\u0010\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u001b\u0010\u0015\u001a\u0004\u0018\u00010\u00148\u0006@\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u001b\u0010\u001a\u001a\u0004\u0018\u00010\u00198\u0006@\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR$\u0010\u001f\u001a\u0004\u0018\u00010\u001e8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u001b\u0010%\u001a\u0004\u0018\u00010\u00198\u0006@\u0006¢\u0006\f\n\u0004\b%\u0010\u001b\u001a\u0004\b&\u0010\u001dR\u001b\u0010'\u001a\u0004\u0018\u00010\f8\u0006@\u0006¢\u0006\f\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*R\u001b\u0010+\u001a\u0004\u0018\u00010\u00198\u0006@\u0006¢\u0006\f\n\u0004\b+\u0010\u001b\u001a\u0004\b,\u0010\u001dR\u001b\u0010-\u001a\u0004\u0018\u00010\f8\u0006@\u0006¢\u0006\f\n\u0004\b-\u0010(\u001a\u0004\b.\u0010*R\u001b\u0010/\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b/\u0010\u0011\u001a\u0004\b0\u0010\u0013R\u001c\u00101\u001a\u00020\u00048\u0016@\u0016X\u0096D¢\u0006\f\n\u0004\b1\u00102\u001a\u0004\b3\u0010\u0006R$\u00105\u001a\u0004\u0018\u0001048\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b5\u00106\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R\u001b\u0010;\u001a\u0004\u0018\u00010\u00198\u0006@\u0006¢\u0006\f\n\u0004\b;\u0010\u001b\u001a\u0004\b<\u0010\u001dR\u001b\u0010=\u001a\u0004\u0018\u00010\u00148\u0006@\u0006¢\u0006\f\n\u0004\b=\u0010\u0016\u001a\u0004\b>\u0010\u0018¨\u0006?"}, d2 = {"Lcom/discord/analytics/generated/events/activity_internal/TrackActivityInternalLocalSettingUpdated;", "Lcom/discord/api/science/AnalyticsSchema;", "Lcom/discord/analytics/generated/traits/TrackBaseReceiver;", "Lcom/discord/analytics/generated/traits/TrackActivityInternalMetadataReceiver;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "prevValueInt", "Ljava/lang/Long;", "getPrevValueInt", "()Ljava/lang/Long;", "", "prevValueFloat", "Ljava/lang/Float;", "getPrevValueFloat", "()Ljava/lang/Float;", "", "valueStr", "Ljava/lang/CharSequence;", "getValueStr", "()Ljava/lang/CharSequence;", "Lcom/discord/analytics/generated/traits/TrackActivityInternalMetadata;", "trackActivityInternalMetadata", "Lcom/discord/analytics/generated/traits/TrackActivityInternalMetadata;", "getTrackActivityInternalMetadata", "()Lcom/discord/analytics/generated/traits/TrackActivityInternalMetadata;", "setTrackActivityInternalMetadata", "(Lcom/discord/analytics/generated/traits/TrackActivityInternalMetadata;)V", "phase", "getPhase", "valueBool", "Ljava/lang/Boolean;", "getValueBool", "()Ljava/lang/Boolean;", "prevValueStr", "getPrevValueStr", "prevValueBool", "getPrevValueBool", "valueInt", "getValueInt", "analyticsSchemaTypeName", "Ljava/lang/String;", "d", "Lcom/discord/analytics/generated/traits/TrackBase;", "trackBase", "Lcom/discord/analytics/generated/traits/TrackBase;", "getTrackBase", "()Lcom/discord/analytics/generated/traits/TrackBase;", "setTrackBase", "(Lcom/discord/analytics/generated/traits/TrackBase;)V", "settingName", "getSettingName", "valueFloat", "getValueFloat", "analytics_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final /* data */ class TrackActivityInternalLocalSettingUpdated implements AnalyticsSchema, TrackBase2, TrackActivityInternalMetadata2 {
    private TrackActivityInternalMetadata trackActivityInternalMetadata;
    private TrackBase trackBase;
    private final CharSequence settingName = null;
    private final CharSequence phase = null;
    private final CharSequence valueStr = null;
    private final CharSequence prevValueStr = null;
    private final Boolean valueBool = null;
    private final Boolean prevValueBool = null;
    private final Long valueInt = null;
    private final Long prevValueInt = null;
    private final Float valueFloat = null;
    private final Float prevValueFloat = null;
    private final transient String analyticsSchemaTypeName = "activity_internal_local_setting_updated";

    @Override // com.discord.api.science.AnalyticsSchema
    /* renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackActivityInternalLocalSettingUpdated)) {
            return false;
        }
        TrackActivityInternalLocalSettingUpdated trackActivityInternalLocalSettingUpdated = (TrackActivityInternalLocalSettingUpdated) other;
        return Intrinsics3.areEqual(this.settingName, trackActivityInternalLocalSettingUpdated.settingName) && Intrinsics3.areEqual(this.phase, trackActivityInternalLocalSettingUpdated.phase) && Intrinsics3.areEqual(this.valueStr, trackActivityInternalLocalSettingUpdated.valueStr) && Intrinsics3.areEqual(this.prevValueStr, trackActivityInternalLocalSettingUpdated.prevValueStr) && Intrinsics3.areEqual(this.valueBool, trackActivityInternalLocalSettingUpdated.valueBool) && Intrinsics3.areEqual(this.prevValueBool, trackActivityInternalLocalSettingUpdated.prevValueBool) && Intrinsics3.areEqual(this.valueInt, trackActivityInternalLocalSettingUpdated.valueInt) && Intrinsics3.areEqual(this.prevValueInt, trackActivityInternalLocalSettingUpdated.prevValueInt) && Intrinsics3.areEqual(this.valueFloat, trackActivityInternalLocalSettingUpdated.valueFloat) && Intrinsics3.areEqual(this.prevValueFloat, trackActivityInternalLocalSettingUpdated.prevValueFloat);
    }

    public int hashCode() {
        CharSequence charSequence = this.settingName;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        CharSequence charSequence2 = this.phase;
        int iHashCode2 = (iHashCode + (charSequence2 != null ? charSequence2.hashCode() : 0)) * 31;
        CharSequence charSequence3 = this.valueStr;
        int iHashCode3 = (iHashCode2 + (charSequence3 != null ? charSequence3.hashCode() : 0)) * 31;
        CharSequence charSequence4 = this.prevValueStr;
        int iHashCode4 = (iHashCode3 + (charSequence4 != null ? charSequence4.hashCode() : 0)) * 31;
        Boolean bool = this.valueBool;
        int iHashCode5 = (iHashCode4 + (bool != null ? bool.hashCode() : 0)) * 31;
        Boolean bool2 = this.prevValueBool;
        int iHashCode6 = (iHashCode5 + (bool2 != null ? bool2.hashCode() : 0)) * 31;
        Long l = this.valueInt;
        int iHashCode7 = (iHashCode6 + (l != null ? l.hashCode() : 0)) * 31;
        Long l2 = this.prevValueInt;
        int iHashCode8 = (iHashCode7 + (l2 != null ? l2.hashCode() : 0)) * 31;
        Float f = this.valueFloat;
        int iHashCode9 = (iHashCode8 + (f != null ? f.hashCode() : 0)) * 31;
        Float f2 = this.prevValueFloat;
        return iHashCode9 + (f2 != null ? f2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackActivityInternalLocalSettingUpdated(settingName=");
        sbU.append(this.settingName);
        sbU.append(", phase=");
        sbU.append(this.phase);
        sbU.append(", valueStr=");
        sbU.append(this.valueStr);
        sbU.append(", prevValueStr=");
        sbU.append(this.prevValueStr);
        sbU.append(", valueBool=");
        sbU.append(this.valueBool);
        sbU.append(", prevValueBool=");
        sbU.append(this.prevValueBool);
        sbU.append(", valueInt=");
        sbU.append(this.valueInt);
        sbU.append(", prevValueInt=");
        sbU.append(this.prevValueInt);
        sbU.append(", valueFloat=");
        sbU.append(this.valueFloat);
        sbU.append(", prevValueFloat=");
        sbU.append(this.prevValueFloat);
        sbU.append(")");
        return sbU.toString();
    }
}
