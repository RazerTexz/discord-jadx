package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.analytics.generated.traits.TrackDirectoryEntry;
import com.discord.analytics.generated.traits.TrackDirectoryEntry2;
import com.discord.api.science.AnalyticsSchema;
import kotlin.Metadata;

/* compiled from: TrackDirectoryEntryCreated.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0007¢\u0006\u0004\b\u0017\u0010\u0018R\u001c\u0010\u0005\u001a\u00020\u00048\u0016@\u0016X\u0096D¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006\u0019"}, d2 = {"Lcom/discord/analytics/generated/events/TrackDirectoryEntryCreated;", "Lcom/discord/api/science/AnalyticsSchema;", "Lcom/discord/analytics/generated/traits/TrackBaseReceiver;", "Lcom/discord/analytics/generated/traits/TrackDirectoryEntryReceiver;", "", "analyticsSchemaTypeName", "Ljava/lang/String;", "d", "()Ljava/lang/String;", "Lcom/discord/analytics/generated/traits/TrackDirectoryEntry;", "trackDirectoryEntry", "Lcom/discord/analytics/generated/traits/TrackDirectoryEntry;", "getTrackDirectoryEntry", "()Lcom/discord/analytics/generated/traits/TrackDirectoryEntry;", "setTrackDirectoryEntry", "(Lcom/discord/analytics/generated/traits/TrackDirectoryEntry;)V", "Lcom/discord/analytics/generated/traits/TrackBase;", "trackBase", "Lcom/discord/analytics/generated/traits/TrackBase;", "getTrackBase", "()Lcom/discord/analytics/generated/traits/TrackBase;", "setTrackBase", "(Lcom/discord/analytics/generated/traits/TrackBase;)V", "<init>", "()V", "analytics_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final class TrackDirectoryEntryCreated implements AnalyticsSchema, TrackBase2, TrackDirectoryEntry2 {
    private final transient String analyticsSchemaTypeName = "directory_entry_created";
    private TrackBase trackBase;
    private TrackDirectoryEntry trackDirectoryEntry;

    @Override // com.discord.api.science.AnalyticsSchema
    /* renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }
}
