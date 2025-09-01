package com.discord.analytics.generated.events;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: TrackSoundboardSoundUploaded.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\t\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u0002J\u0010\u0010\u0004\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u001a\u0010\f\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\tHÖ\u0003¢\u0006\u0004\b\f\u0010\rR\u001b\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001b\u0010\u0013\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0010\u001a\u0004\b\u0014\u0010\u0012R\u001c\u0010\u0015\u001a\u00020\u00038\u0016@\u0016X\u0096D¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0005R\u001b\u0010\u0019\u001a\u0004\u0018\u00010\u00188\u0006@\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u001b\u0010\u001d\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u001b\u0010\"\u001a\u0004\u0018\u00010!8\u0006@\u0006¢\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%R$\u0010'\u001a\u0004\u0018\u00010&8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\u001b\u0010-\u001a\u0004\u0018\u00010!8\u0006@\u0006¢\u0006\f\n\u0004\b-\u0010#\u001a\u0004\b.\u0010%¨\u0006/"}, d2 = {"Lcom/discord/analytics/generated/events/TrackSoundboardSoundUploaded;", "Lcom/discord/api/science/AnalyticsSchema;", "Lcom/discord/analytics/generated/traits/TrackBaseReceiver;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "reasonMessage", "Ljava/lang/CharSequence;", "getReasonMessage", "()Ljava/lang/CharSequence;", "mimeType", "getMimeType", "analyticsSchemaTypeName", "Ljava/lang/String;", "d", "", "durationS", "Ljava/lang/Float;", "getDurationS", "()Ljava/lang/Float;", "success", "Ljava/lang/Boolean;", "getSuccess", "()Ljava/lang/Boolean;", "", "reasonCode", "Ljava/lang/Long;", "getReasonCode", "()Ljava/lang/Long;", "Lcom/discord/analytics/generated/traits/TrackBase;", "trackBase", "Lcom/discord/analytics/generated/traits/TrackBase;", "getTrackBase", "()Lcom/discord/analytics/generated/traits/TrackBase;", "setTrackBase", "(Lcom/discord/analytics/generated/traits/TrackBase;)V", "guildId", "getGuildId", "analytics_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final /* data */ class TrackSoundboardSoundUploaded implements AnalyticsSchema, TrackBase2 {
    private TrackBase trackBase;
    private final Long guildId = null;
    private final Boolean success = null;
    private final Long reasonCode = null;
    private final CharSequence reasonMessage = null;
    private final CharSequence mimeType = null;
    private final Float durationS = null;
    private final transient String analyticsSchemaTypeName = "soundboard_sound_uploaded";

    @Override // com.discord.api.science.AnalyticsSchema
    /* renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackSoundboardSoundUploaded)) {
            return false;
        }
        TrackSoundboardSoundUploaded trackSoundboardSoundUploaded = (TrackSoundboardSoundUploaded) other;
        return Intrinsics3.areEqual(this.guildId, trackSoundboardSoundUploaded.guildId) && Intrinsics3.areEqual(this.success, trackSoundboardSoundUploaded.success) && Intrinsics3.areEqual(this.reasonCode, trackSoundboardSoundUploaded.reasonCode) && Intrinsics3.areEqual(this.reasonMessage, trackSoundboardSoundUploaded.reasonMessage) && Intrinsics3.areEqual(this.mimeType, trackSoundboardSoundUploaded.mimeType) && Intrinsics3.areEqual(this.durationS, trackSoundboardSoundUploaded.durationS);
    }

    public int hashCode() {
        Long l = this.guildId;
        int iHashCode = (l != null ? l.hashCode() : 0) * 31;
        Boolean bool = this.success;
        int iHashCode2 = (iHashCode + (bool != null ? bool.hashCode() : 0)) * 31;
        Long l2 = this.reasonCode;
        int iHashCode3 = (iHashCode2 + (l2 != null ? l2.hashCode() : 0)) * 31;
        CharSequence charSequence = this.reasonMessage;
        int iHashCode4 = (iHashCode3 + (charSequence != null ? charSequence.hashCode() : 0)) * 31;
        CharSequence charSequence2 = this.mimeType;
        int iHashCode5 = (iHashCode4 + (charSequence2 != null ? charSequence2.hashCode() : 0)) * 31;
        Float f = this.durationS;
        return iHashCode5 + (f != null ? f.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackSoundboardSoundUploaded(guildId=");
        sbU.append(this.guildId);
        sbU.append(", success=");
        sbU.append(this.success);
        sbU.append(", reasonCode=");
        sbU.append(this.reasonCode);
        sbU.append(", reasonMessage=");
        sbU.append(this.reasonMessage);
        sbU.append(", mimeType=");
        sbU.append(this.mimeType);
        sbU.append(", durationS=");
        sbU.append(this.durationS);
        sbU.append(")");
        return sbU.toString();
    }
}
