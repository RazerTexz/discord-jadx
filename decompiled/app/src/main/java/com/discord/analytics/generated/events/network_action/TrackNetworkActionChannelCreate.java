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

/* compiled from: TrackNetworkActionChannelCreate.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004BC\u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010-\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u0010¢\u0006\u0004\b6\u00107J\u0010\u0010\u0006\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u001a\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u000bHÖ\u0003¢\u0006\u0004\b\u000e\u0010\u000fR\u001b\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0015\u001a\u00020\u00058\u0016@\u0016X\u0096D¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0007R$\u0010\u0019\u001a\u0004\u0018\u00010\u00188\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001b\u0010\u001f\u001a\u0004\u0018\u00010\u00108\u0006@\u0006¢\u0006\f\n\u0004\b\u001f\u0010\u0012\u001a\u0004\b \u0010\u0014R\u001b\u0010!\u001a\u0004\u0018\u00010\r8\u0006@\u0006¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b!\u0010#R\u001b\u0010$\u001a\u0004\u0018\u00010\u00108\u0006@\u0006¢\u0006\f\n\u0004\b$\u0010\u0012\u001a\u0004\b%\u0010\u0014R$\u0010'\u001a\u0004\u0018\u00010&8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\u001b\u0010-\u001a\u0004\u0018\u00010\u00108\u0006@\u0006¢\u0006\f\n\u0004\b-\u0010\u0012\u001a\u0004\b.\u0010\u0014R$\u00100\u001a\u0004\u0018\u00010/8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b0\u00101\u001a\u0004\b2\u00103\"\u0004\b4\u00105¨\u00068"}, d2 = {"Lcom/discord/analytics/generated/events/network_action/TrackNetworkActionChannelCreate;", "Lcom/discord/api/science/AnalyticsSchema;", "Lcom/discord/analytics/generated/traits/TrackBaseReceiver;", "Lcom/discord/analytics/generated/traits/TrackLocationMetadataReceiver;", "Lcom/discord/analytics/generated/traits/TrackNetworkMetadataReceiver;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "channelId", "Ljava/lang/Long;", "getChannelId", "()Ljava/lang/Long;", "analyticsSchemaTypeName", "Ljava/lang/String;", "d", "Lcom/discord/analytics/generated/traits/TrackNetworkMetadata;", "trackNetworkMetadata", "Lcom/discord/analytics/generated/traits/TrackNetworkMetadata;", "getTrackNetworkMetadata", "()Lcom/discord/analytics/generated/traits/TrackNetworkMetadata;", "b", "(Lcom/discord/analytics/generated/traits/TrackNetworkMetadata;)V", "guildId", "getGuildId", "isPrivate", "Ljava/lang/Boolean;", "()Ljava/lang/Boolean;", "parentId", "getParentId", "Lcom/discord/analytics/generated/traits/TrackBase;", "trackBase", "Lcom/discord/analytics/generated/traits/TrackBase;", "getTrackBase", "()Lcom/discord/analytics/generated/traits/TrackBase;", "setTrackBase", "(Lcom/discord/analytics/generated/traits/TrackBase;)V", "channelType", "getChannelType", "Lcom/discord/analytics/generated/traits/TrackLocationMetadata;", "trackLocationMetadata", "Lcom/discord/analytics/generated/traits/TrackLocationMetadata;", "getTrackLocationMetadata", "()Lcom/discord/analytics/generated/traits/TrackLocationMetadata;", "setTrackLocationMetadata", "(Lcom/discord/analytics/generated/traits/TrackLocationMetadata;)V", "<init>", "(Ljava/lang/Boolean;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;)V", "analytics_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final /* data */ class TrackNetworkActionChannelCreate implements AnalyticsSchema, TrackBase2, TrackLocationMetadata2, TrackNetworkMetadata2 {
    private final transient String analyticsSchemaTypeName;
    private final Long channelId;
    private final Long channelType;
    private final Long guildId;
    private final Boolean isPrivate;
    private final Long parentId;
    private TrackBase trackBase;
    private TrackLocationMetadata trackLocationMetadata;
    private TrackNetworkMetadata trackNetworkMetadata;

    public TrackNetworkActionChannelCreate(Boolean bool, Long l, Long l2, Long l3, Long l4) {
        this.isPrivate = bool;
        this.channelType = l;
        this.channelId = l2;
        this.parentId = l3;
        this.guildId = l4;
        this.analyticsSchemaTypeName = "network_action_channel_create";
    }

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
        if (!(other instanceof TrackNetworkActionChannelCreate)) {
            return false;
        }
        TrackNetworkActionChannelCreate trackNetworkActionChannelCreate = (TrackNetworkActionChannelCreate) other;
        return Intrinsics3.areEqual(this.isPrivate, trackNetworkActionChannelCreate.isPrivate) && Intrinsics3.areEqual(this.channelType, trackNetworkActionChannelCreate.channelType) && Intrinsics3.areEqual(this.channelId, trackNetworkActionChannelCreate.channelId) && Intrinsics3.areEqual(this.parentId, trackNetworkActionChannelCreate.parentId) && Intrinsics3.areEqual(this.guildId, trackNetworkActionChannelCreate.guildId);
    }

    public int hashCode() {
        Boolean bool = this.isPrivate;
        int iHashCode = (bool != null ? bool.hashCode() : 0) * 31;
        Long l = this.channelType;
        int iHashCode2 = (iHashCode + (l != null ? l.hashCode() : 0)) * 31;
        Long l2 = this.channelId;
        int iHashCode3 = (iHashCode2 + (l2 != null ? l2.hashCode() : 0)) * 31;
        Long l3 = this.parentId;
        int iHashCode4 = (iHashCode3 + (l3 != null ? l3.hashCode() : 0)) * 31;
        Long l4 = this.guildId;
        return iHashCode4 + (l4 != null ? l4.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackNetworkActionChannelCreate(isPrivate=");
        sbU.append(this.isPrivate);
        sbU.append(", channelType=");
        sbU.append(this.channelType);
        sbU.append(", channelId=");
        sbU.append(this.channelId);
        sbU.append(", parentId=");
        sbU.append(this.parentId);
        sbU.append(", guildId=");
        return outline.G(sbU, this.guildId, ")");
    }

    public TrackNetworkActionChannelCreate() {
        this(null, null, null, null, null);
    }
}
