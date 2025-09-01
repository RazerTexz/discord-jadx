package com.discord.analytics.generated.events;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: TrackNotificationRendered.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u001e\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\r\n\u0002\b\u0010\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u0002J\u0010\u0010\u0004\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u001a\u0010\f\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\tHÖ\u0003¢\u0006\u0004\b\f\u0010\rR\u001b\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001b\u0010\u0013\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0010\u001a\u0004\b\u0014\u0010\u0012R\u001b\u0010\u0015\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0010\u001a\u0004\b\u0016\u0010\u0012R\u001b\u0010\u0017\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u001b\u0010\u001b\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b\u001b\u0010\u0010\u001a\u0004\b\u001c\u0010\u0012R\u001b\u0010\u001d\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b\u001d\u0010\u0010\u001a\u0004\b\u001e\u0010\u0012R\u001b\u0010\u001f\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b\u001f\u0010\u0010\u001a\u0004\b \u0010\u0012R\u001b\u0010!\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b!\u0010\u0010\u001a\u0004\b\"\u0010\u0012R\u001b\u0010#\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b#\u0010\u0010\u001a\u0004\b$\u0010\u0012R\u001b\u0010%\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b%\u0010\u0018\u001a\u0004\b&\u0010\u001aR\u001b\u0010'\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b'\u0010\u0010\u001a\u0004\b(\u0010\u0012R\u001b\u0010)\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b)\u0010\u0010\u001a\u0004\b*\u0010\u0012R\u001b\u0010+\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b+\u0010\u0010\u001a\u0004\b,\u0010\u0012R$\u0010.\u001a\u0004\u0018\u00010-8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b.\u0010/\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\u001b\u00104\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b4\u0010\u0010\u001a\u0004\b5\u0010\u0012R\u001b\u00107\u001a\u0004\u0018\u0001068\u0006@\u0006¢\u0006\f\n\u0004\b7\u00108\u001a\u0004\b9\u0010:R\u001b\u0010;\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b;\u0010\u0010\u001a\u0004\b<\u0010\u0012R\u001b\u0010=\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b=\u0010\u0010\u001a\u0004\b>\u0010\u0012R\u001b\u0010?\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b?\u0010\u0010\u001a\u0004\b@\u0010\u0012R\u001b\u0010A\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\bA\u0010\u0010\u001a\u0004\bB\u0010\u0012R\u001c\u0010C\u001a\u00020\u00038\u0016@\u0016X\u0096D¢\u0006\f\n\u0004\bC\u0010D\u001a\u0004\bE\u0010\u0005¨\u0006F"}, d2 = {"Lcom/discord/analytics/generated/events/TrackNotificationRendered;", "Lcom/discord/api/science/AnalyticsSchema;", "Lcom/discord/analytics/generated/traits/TrackBaseReceiver;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "connectionResumeDurationMs", "Ljava/lang/Long;", "getConnectionResumeDurationMs", "()Ljava/lang/Long;", "appBackgroundedDurationMs", "getAppBackgroundedDurationMs", "cachedRenderDurationMs", "getCachedRenderDurationMs", "messageInPushPayload", "Ljava/lang/Boolean;", "getMessageInPushPayload", "()Ljava/lang/Boolean;", "connectionOpenDurationMs", "getConnectionOpenDurationMs", "onlineDurationMs", "getOnlineDurationMs", "anyNewerMessagesRenderDurationMs", "getAnyNewerMessagesRenderDurationMs", "appInactiveDurationMs", "getAppInactiveDurationMs", "firstMessageFetchStartDurationMs", "getFirstMessageFetchStartDurationMs", "hasCache", "getHasCache", "cacheLoadDurationMs", "getCacheLoadDurationMs", "fullCacheLoadDurationMs", "getFullCacheLoadDurationMs", "fullRenderDurationMs", "getFullRenderDurationMs", "Lcom/discord/analytics/generated/traits/TrackBase;", "trackBase", "Lcom/discord/analytics/generated/traits/TrackBase;", "getTrackBase", "()Lcom/discord/analytics/generated/traits/TrackBase;", "setTrackBase", "(Lcom/discord/analytics/generated/traits/TrackBase;)V", "loadedMessagesRenderDurationMs", "getLoadedMessagesRenderDurationMs", "", "initialAppState", "Ljava/lang/CharSequence;", "getInitialAppState", "()Ljava/lang/CharSequence;", "appActiveDurationMs", "getAppActiveDurationMs", "connectionPreOpenDurationMs", "getConnectionPreOpenDurationMs", "coldStartDurationMs", "getColdStartDurationMs", "firstMessageFetchEndDurationMs", "getFirstMessageFetchEndDurationMs", "analyticsSchemaTypeName", "Ljava/lang/String;", "d", "analytics_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final /* data */ class TrackNotificationRendered implements AnalyticsSchema, TrackBase2 {
    private TrackBase trackBase;
    private final Boolean hasCache = null;
    private final Boolean messageInPushPayload = null;
    private final Long coldStartDurationMs = null;
    private final Long cachedRenderDurationMs = null;
    private final Long anyNewerMessagesRenderDurationMs = null;
    private final Long loadedMessagesRenderDurationMs = null;
    private final Long fullRenderDurationMs = null;
    private final Long cacheLoadDurationMs = null;
    private final Long fullCacheLoadDurationMs = null;
    private final Long connectionPreOpenDurationMs = null;
    private final Long connectionOpenDurationMs = null;
    private final Long connectionResumeDurationMs = null;
    private final Long onlineDurationMs = null;
    private final Long firstMessageFetchStartDurationMs = null;
    private final Long firstMessageFetchEndDurationMs = null;
    private final CharSequence initialAppState = null;
    private final Long appActiveDurationMs = null;
    private final Long appInactiveDurationMs = null;
    private final Long appBackgroundedDurationMs = null;
    private final transient String analyticsSchemaTypeName = "notification_rendered";

    @Override // com.discord.api.science.AnalyticsSchema
    /* renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackNotificationRendered)) {
            return false;
        }
        TrackNotificationRendered trackNotificationRendered = (TrackNotificationRendered) other;
        return Intrinsics3.areEqual(this.hasCache, trackNotificationRendered.hasCache) && Intrinsics3.areEqual(this.messageInPushPayload, trackNotificationRendered.messageInPushPayload) && Intrinsics3.areEqual(this.coldStartDurationMs, trackNotificationRendered.coldStartDurationMs) && Intrinsics3.areEqual(this.cachedRenderDurationMs, trackNotificationRendered.cachedRenderDurationMs) && Intrinsics3.areEqual(this.anyNewerMessagesRenderDurationMs, trackNotificationRendered.anyNewerMessagesRenderDurationMs) && Intrinsics3.areEqual(this.loadedMessagesRenderDurationMs, trackNotificationRendered.loadedMessagesRenderDurationMs) && Intrinsics3.areEqual(this.fullRenderDurationMs, trackNotificationRendered.fullRenderDurationMs) && Intrinsics3.areEqual(this.cacheLoadDurationMs, trackNotificationRendered.cacheLoadDurationMs) && Intrinsics3.areEqual(this.fullCacheLoadDurationMs, trackNotificationRendered.fullCacheLoadDurationMs) && Intrinsics3.areEqual(this.connectionPreOpenDurationMs, trackNotificationRendered.connectionPreOpenDurationMs) && Intrinsics3.areEqual(this.connectionOpenDurationMs, trackNotificationRendered.connectionOpenDurationMs) && Intrinsics3.areEqual(this.connectionResumeDurationMs, trackNotificationRendered.connectionResumeDurationMs) && Intrinsics3.areEqual(this.onlineDurationMs, trackNotificationRendered.onlineDurationMs) && Intrinsics3.areEqual(this.firstMessageFetchStartDurationMs, trackNotificationRendered.firstMessageFetchStartDurationMs) && Intrinsics3.areEqual(this.firstMessageFetchEndDurationMs, trackNotificationRendered.firstMessageFetchEndDurationMs) && Intrinsics3.areEqual(this.initialAppState, trackNotificationRendered.initialAppState) && Intrinsics3.areEqual(this.appActiveDurationMs, trackNotificationRendered.appActiveDurationMs) && Intrinsics3.areEqual(this.appInactiveDurationMs, trackNotificationRendered.appInactiveDurationMs) && Intrinsics3.areEqual(this.appBackgroundedDurationMs, trackNotificationRendered.appBackgroundedDurationMs);
    }

    public int hashCode() {
        Boolean bool = this.hasCache;
        int iHashCode = (bool != null ? bool.hashCode() : 0) * 31;
        Boolean bool2 = this.messageInPushPayload;
        int iHashCode2 = (iHashCode + (bool2 != null ? bool2.hashCode() : 0)) * 31;
        Long l = this.coldStartDurationMs;
        int iHashCode3 = (iHashCode2 + (l != null ? l.hashCode() : 0)) * 31;
        Long l2 = this.cachedRenderDurationMs;
        int iHashCode4 = (iHashCode3 + (l2 != null ? l2.hashCode() : 0)) * 31;
        Long l3 = this.anyNewerMessagesRenderDurationMs;
        int iHashCode5 = (iHashCode4 + (l3 != null ? l3.hashCode() : 0)) * 31;
        Long l4 = this.loadedMessagesRenderDurationMs;
        int iHashCode6 = (iHashCode5 + (l4 != null ? l4.hashCode() : 0)) * 31;
        Long l5 = this.fullRenderDurationMs;
        int iHashCode7 = (iHashCode6 + (l5 != null ? l5.hashCode() : 0)) * 31;
        Long l6 = this.cacheLoadDurationMs;
        int iHashCode8 = (iHashCode7 + (l6 != null ? l6.hashCode() : 0)) * 31;
        Long l7 = this.fullCacheLoadDurationMs;
        int iHashCode9 = (iHashCode8 + (l7 != null ? l7.hashCode() : 0)) * 31;
        Long l8 = this.connectionPreOpenDurationMs;
        int iHashCode10 = (iHashCode9 + (l8 != null ? l8.hashCode() : 0)) * 31;
        Long l9 = this.connectionOpenDurationMs;
        int iHashCode11 = (iHashCode10 + (l9 != null ? l9.hashCode() : 0)) * 31;
        Long l10 = this.connectionResumeDurationMs;
        int iHashCode12 = (iHashCode11 + (l10 != null ? l10.hashCode() : 0)) * 31;
        Long l11 = this.onlineDurationMs;
        int iHashCode13 = (iHashCode12 + (l11 != null ? l11.hashCode() : 0)) * 31;
        Long l12 = this.firstMessageFetchStartDurationMs;
        int iHashCode14 = (iHashCode13 + (l12 != null ? l12.hashCode() : 0)) * 31;
        Long l13 = this.firstMessageFetchEndDurationMs;
        int iHashCode15 = (iHashCode14 + (l13 != null ? l13.hashCode() : 0)) * 31;
        CharSequence charSequence = this.initialAppState;
        int iHashCode16 = (iHashCode15 + (charSequence != null ? charSequence.hashCode() : 0)) * 31;
        Long l14 = this.appActiveDurationMs;
        int iHashCode17 = (iHashCode16 + (l14 != null ? l14.hashCode() : 0)) * 31;
        Long l15 = this.appInactiveDurationMs;
        int iHashCode18 = (iHashCode17 + (l15 != null ? l15.hashCode() : 0)) * 31;
        Long l16 = this.appBackgroundedDurationMs;
        return iHashCode18 + (l16 != null ? l16.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackNotificationRendered(hasCache=");
        sbU.append(this.hasCache);
        sbU.append(", messageInPushPayload=");
        sbU.append(this.messageInPushPayload);
        sbU.append(", coldStartDurationMs=");
        sbU.append(this.coldStartDurationMs);
        sbU.append(", cachedRenderDurationMs=");
        sbU.append(this.cachedRenderDurationMs);
        sbU.append(", anyNewerMessagesRenderDurationMs=");
        sbU.append(this.anyNewerMessagesRenderDurationMs);
        sbU.append(", loadedMessagesRenderDurationMs=");
        sbU.append(this.loadedMessagesRenderDurationMs);
        sbU.append(", fullRenderDurationMs=");
        sbU.append(this.fullRenderDurationMs);
        sbU.append(", cacheLoadDurationMs=");
        sbU.append(this.cacheLoadDurationMs);
        sbU.append(", fullCacheLoadDurationMs=");
        sbU.append(this.fullCacheLoadDurationMs);
        sbU.append(", connectionPreOpenDurationMs=");
        sbU.append(this.connectionPreOpenDurationMs);
        sbU.append(", connectionOpenDurationMs=");
        sbU.append(this.connectionOpenDurationMs);
        sbU.append(", connectionResumeDurationMs=");
        sbU.append(this.connectionResumeDurationMs);
        sbU.append(", onlineDurationMs=");
        sbU.append(this.onlineDurationMs);
        sbU.append(", firstMessageFetchStartDurationMs=");
        sbU.append(this.firstMessageFetchStartDurationMs);
        sbU.append(", firstMessageFetchEndDurationMs=");
        sbU.append(this.firstMessageFetchEndDurationMs);
        sbU.append(", initialAppState=");
        sbU.append(this.initialAppState);
        sbU.append(", appActiveDurationMs=");
        sbU.append(this.appActiveDurationMs);
        sbU.append(", appInactiveDurationMs=");
        sbU.append(this.appInactiveDurationMs);
        sbU.append(", appBackgroundedDurationMs=");
        return outline.G(sbU, this.appBackgroundedDurationMs, ")");
    }
}
