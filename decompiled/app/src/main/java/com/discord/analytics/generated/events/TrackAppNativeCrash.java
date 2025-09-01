package com.discord.analytics.generated.events;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.analytics.generated.traits.TrackOverlayClientMetadata;
import com.discord.analytics.generated.traits.TrackOverlayClientMetadata2;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: TrackAppNativeCrash.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\t\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003J\u0010\u0010\u0005\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\b\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b\b\u0010\tJ\u001a\u0010\r\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\nHÖ\u0003¢\u0006\u0004\b\r\u0010\u000eR\u001b\u0010\u0010\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R$\u0010\u0015\u001a\u0004\u0018\u00010\u00148\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001b\u0010\u001b\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b\u001b\u0010\u0011\u001a\u0004\b\u001c\u0010\u0013R\u001b\u0010\u001d\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b\u001d\u0010\u0011\u001a\u0004\b\u001e\u0010\u0013R\u001b\u0010\u001f\u001a\u0004\u0018\u00010\f8\u0006@\u0006¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"R\u001b\u0010#\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b#\u0010\u0011\u001a\u0004\b$\u0010\u0013R\u001b\u0010%\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b%\u0010\u0011\u001a\u0004\b&\u0010\u0013R\u001b\u0010(\u001a\u0004\u0018\u00010'8\u0006@\u0006¢\u0006\f\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+R\u001c\u0010,\u001a\u00020\u00048\u0016@\u0016X\u0096D¢\u0006\f\n\u0004\b,\u0010-\u001a\u0004\b.\u0010\u0006R\u001b\u0010/\u001a\u0004\u0018\u00010'8\u0006@\u0006¢\u0006\f\n\u0004\b/\u0010)\u001a\u0004\b0\u0010+R\u001b\u00101\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b1\u0010\u0011\u001a\u0004\b2\u0010\u0013R\u001b\u00103\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b3\u0010\u0011\u001a\u0004\b4\u0010\u0013R\u001b\u00105\u001a\u0004\u0018\u00010'8\u0006@\u0006¢\u0006\f\n\u0004\b5\u0010)\u001a\u0004\b6\u0010+R\u001b\u00107\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b7\u0010\u0011\u001a\u0004\b8\u0010\u0013R\u001b\u00109\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b9\u0010\u0011\u001a\u0004\b:\u0010\u0013R$\u0010<\u001a\u0004\u0018\u00010;8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b<\u0010=\u001a\u0004\b>\u0010?\"\u0004\b@\u0010A¨\u0006B"}, d2 = {"Lcom/discord/analytics/generated/events/TrackAppNativeCrash;", "Lcom/discord/api/science/AnalyticsSchema;", "Lcom/discord/analytics/generated/traits/TrackBaseReceiver;", "Lcom/discord/analytics/generated/traits/TrackOverlayClientMetadataReceiver;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "tombstoneCause", "Ljava/lang/CharSequence;", "getTombstoneCause", "()Ljava/lang/CharSequence;", "Lcom/discord/analytics/generated/traits/TrackOverlayClientMetadata;", "trackOverlayClientMetadata", "Lcom/discord/analytics/generated/traits/TrackOverlayClientMetadata;", "getTrackOverlayClientMetadata", "()Lcom/discord/analytics/generated/traits/TrackOverlayClientMetadata;", "setTrackOverlayClientMetadata", "(Lcom/discord/analytics/generated/traits/TrackOverlayClientMetadata;)V", "exitReason", "getExitReason", "exitDescription", "getExitDescription", "didCrash", "Ljava/lang/Boolean;", "getDidCrash", "()Ljava/lang/Boolean;", "rendererCrashReason", "getRendererCrashReason", "tombstoneHash", "getTombstoneHash", "", "exceptionCode", "Ljava/lang/Long;", "getExceptionCode", "()Ljava/lang/Long;", "analyticsSchemaTypeName", "Ljava/lang/String;", "d", "exceptionType", "getExceptionType", "callstackHash", "getCallstackHash", "minidumpExceptionType", "getMinidumpExceptionType", "signal", "getSignal", "binaryName", "getBinaryName", "terminationReason", "getTerminationReason", "Lcom/discord/analytics/generated/traits/TrackBase;", "trackBase", "Lcom/discord/analytics/generated/traits/TrackBase;", "getTrackBase", "()Lcom/discord/analytics/generated/traits/TrackBase;", "setTrackBase", "(Lcom/discord/analytics/generated/traits/TrackBase;)V", "analytics_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final /* data */ class TrackAppNativeCrash implements AnalyticsSchema, TrackBase2, TrackOverlayClientMetadata2 {
    private TrackBase trackBase;
    private TrackOverlayClientMetadata trackOverlayClientMetadata;
    private final Boolean didCrash = null;
    private final CharSequence rendererCrashReason = null;
    private final CharSequence minidumpExceptionType = null;
    private final CharSequence exitReason = null;
    private final CharSequence exitDescription = null;
    private final CharSequence tombstoneHash = null;
    private final CharSequence tombstoneCause = null;
    private final Long signal = null;
    private final Long exceptionType = null;
    private final Long exceptionCode = null;
    private final CharSequence terminationReason = null;
    private final CharSequence binaryName = null;
    private final CharSequence callstackHash = null;
    private final transient String analyticsSchemaTypeName = "app_native_crash";

    @Override // com.discord.api.science.AnalyticsSchema
    /* renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackAppNativeCrash)) {
            return false;
        }
        TrackAppNativeCrash trackAppNativeCrash = (TrackAppNativeCrash) other;
        return Intrinsics3.areEqual(this.didCrash, trackAppNativeCrash.didCrash) && Intrinsics3.areEqual(this.rendererCrashReason, trackAppNativeCrash.rendererCrashReason) && Intrinsics3.areEqual(this.minidumpExceptionType, trackAppNativeCrash.minidumpExceptionType) && Intrinsics3.areEqual(this.exitReason, trackAppNativeCrash.exitReason) && Intrinsics3.areEqual(this.exitDescription, trackAppNativeCrash.exitDescription) && Intrinsics3.areEqual(this.tombstoneHash, trackAppNativeCrash.tombstoneHash) && Intrinsics3.areEqual(this.tombstoneCause, trackAppNativeCrash.tombstoneCause) && Intrinsics3.areEqual(this.signal, trackAppNativeCrash.signal) && Intrinsics3.areEqual(this.exceptionType, trackAppNativeCrash.exceptionType) && Intrinsics3.areEqual(this.exceptionCode, trackAppNativeCrash.exceptionCode) && Intrinsics3.areEqual(this.terminationReason, trackAppNativeCrash.terminationReason) && Intrinsics3.areEqual(this.binaryName, trackAppNativeCrash.binaryName) && Intrinsics3.areEqual(this.callstackHash, trackAppNativeCrash.callstackHash);
    }

    public int hashCode() {
        Boolean bool = this.didCrash;
        int iHashCode = (bool != null ? bool.hashCode() : 0) * 31;
        CharSequence charSequence = this.rendererCrashReason;
        int iHashCode2 = (iHashCode + (charSequence != null ? charSequence.hashCode() : 0)) * 31;
        CharSequence charSequence2 = this.minidumpExceptionType;
        int iHashCode3 = (iHashCode2 + (charSequence2 != null ? charSequence2.hashCode() : 0)) * 31;
        CharSequence charSequence3 = this.exitReason;
        int iHashCode4 = (iHashCode3 + (charSequence3 != null ? charSequence3.hashCode() : 0)) * 31;
        CharSequence charSequence4 = this.exitDescription;
        int iHashCode5 = (iHashCode4 + (charSequence4 != null ? charSequence4.hashCode() : 0)) * 31;
        CharSequence charSequence5 = this.tombstoneHash;
        int iHashCode6 = (iHashCode5 + (charSequence5 != null ? charSequence5.hashCode() : 0)) * 31;
        CharSequence charSequence6 = this.tombstoneCause;
        int iHashCode7 = (iHashCode6 + (charSequence6 != null ? charSequence6.hashCode() : 0)) * 31;
        Long l = this.signal;
        int iHashCode8 = (iHashCode7 + (l != null ? l.hashCode() : 0)) * 31;
        Long l2 = this.exceptionType;
        int iHashCode9 = (iHashCode8 + (l2 != null ? l2.hashCode() : 0)) * 31;
        Long l3 = this.exceptionCode;
        int iHashCode10 = (iHashCode9 + (l3 != null ? l3.hashCode() : 0)) * 31;
        CharSequence charSequence7 = this.terminationReason;
        int iHashCode11 = (iHashCode10 + (charSequence7 != null ? charSequence7.hashCode() : 0)) * 31;
        CharSequence charSequence8 = this.binaryName;
        int iHashCode12 = (iHashCode11 + (charSequence8 != null ? charSequence8.hashCode() : 0)) * 31;
        CharSequence charSequence9 = this.callstackHash;
        return iHashCode12 + (charSequence9 != null ? charSequence9.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackAppNativeCrash(didCrash=");
        sbU.append(this.didCrash);
        sbU.append(", rendererCrashReason=");
        sbU.append(this.rendererCrashReason);
        sbU.append(", minidumpExceptionType=");
        sbU.append(this.minidumpExceptionType);
        sbU.append(", exitReason=");
        sbU.append(this.exitReason);
        sbU.append(", exitDescription=");
        sbU.append(this.exitDescription);
        sbU.append(", tombstoneHash=");
        sbU.append(this.tombstoneHash);
        sbU.append(", tombstoneCause=");
        sbU.append(this.tombstoneCause);
        sbU.append(", signal=");
        sbU.append(this.signal);
        sbU.append(", exceptionType=");
        sbU.append(this.exceptionType);
        sbU.append(", exceptionCode=");
        sbU.append(this.exceptionCode);
        sbU.append(", terminationReason=");
        sbU.append(this.terminationReason);
        sbU.append(", binaryName=");
        sbU.append(this.binaryName);
        sbU.append(", callstackHash=");
        return outline.E(sbU, this.callstackHash, ")");
    }
}
