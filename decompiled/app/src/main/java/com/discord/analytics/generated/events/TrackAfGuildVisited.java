package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackAfCard;
import com.discord.analytics.generated.traits.TrackAfCard2;
import com.discord.analytics.generated.traits.TrackAfGame;
import com.discord.analytics.generated.traits.TrackAfGame2;
import com.discord.analytics.generated.traits.TrackAfParty;
import com.discord.analytics.generated.traits.TrackAfParty2;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.analytics.generated.traits.TrackChannel;
import com.discord.analytics.generated.traits.TrackChannel2;
import com.discord.analytics.generated.traits.TrackGuild;
import com.discord.analytics.generated.traits.TrackGuild2;
import com.discord.analytics.generated.traits.TrackSourceMetadata;
import com.discord.analytics.generated.traits.TrackSourceMetadata2;
import com.discord.api.science.AnalyticsSchema;
import kotlin.Metadata;

/* compiled from: TrackAfGuildVisited.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u00062\u00020\u00072\u00020\bB\u0007¢\u0006\u0004\b?\u0010@R\u001c\u0010\n\u001a\u00020\t8\u0016@\u0016X\u0096D¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR$\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R$\u0010\u0016\u001a\u0004\u0018\u00010\u00158\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR$\u0010\u001d\u001a\u0004\u0018\u00010\u001c8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R$\u0010$\u001a\u0004\u0018\u00010#8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R$\u0010+\u001a\u0004\u0018\u00010*8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R$\u00102\u001a\u0004\u0018\u0001018\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b2\u00103\u001a\u0004\b4\u00105\"\u0004\b6\u00107R$\u00109\u001a\u0004\u0018\u0001088\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b9\u0010:\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>¨\u0006A"}, d2 = {"Lcom/discord/analytics/generated/events/TrackAfGuildVisited;", "Lcom/discord/api/science/AnalyticsSchema;", "Lcom/discord/analytics/generated/traits/TrackBaseReceiver;", "Lcom/discord/analytics/generated/traits/TrackAfCardReceiver;", "Lcom/discord/analytics/generated/traits/TrackAfGameReceiver;", "Lcom/discord/analytics/generated/traits/TrackAfPartyReceiver;", "Lcom/discord/analytics/generated/traits/TrackGuildReceiver;", "Lcom/discord/analytics/generated/traits/TrackChannelReceiver;", "Lcom/discord/analytics/generated/traits/TrackSourceMetadataReceiver;", "", "analyticsSchemaTypeName", "Ljava/lang/String;", "d", "()Ljava/lang/String;", "Lcom/discord/analytics/generated/traits/TrackBase;", "trackBase", "Lcom/discord/analytics/generated/traits/TrackBase;", "getTrackBase", "()Lcom/discord/analytics/generated/traits/TrackBase;", "setTrackBase", "(Lcom/discord/analytics/generated/traits/TrackBase;)V", "Lcom/discord/analytics/generated/traits/TrackAfParty;", "trackAfParty", "Lcom/discord/analytics/generated/traits/TrackAfParty;", "getTrackAfParty", "()Lcom/discord/analytics/generated/traits/TrackAfParty;", "setTrackAfParty", "(Lcom/discord/analytics/generated/traits/TrackAfParty;)V", "Lcom/discord/analytics/generated/traits/TrackGuild;", "trackGuild", "Lcom/discord/analytics/generated/traits/TrackGuild;", "a", "()Lcom/discord/analytics/generated/traits/TrackGuild;", "c", "(Lcom/discord/analytics/generated/traits/TrackGuild;)V", "Lcom/discord/analytics/generated/traits/TrackSourceMetadata;", "trackSourceMetadata", "Lcom/discord/analytics/generated/traits/TrackSourceMetadata;", "getTrackSourceMetadata", "()Lcom/discord/analytics/generated/traits/TrackSourceMetadata;", "setTrackSourceMetadata", "(Lcom/discord/analytics/generated/traits/TrackSourceMetadata;)V", "Lcom/discord/analytics/generated/traits/TrackChannel;", "trackChannel", "Lcom/discord/analytics/generated/traits/TrackChannel;", "getTrackChannel", "()Lcom/discord/analytics/generated/traits/TrackChannel;", "setTrackChannel", "(Lcom/discord/analytics/generated/traits/TrackChannel;)V", "Lcom/discord/analytics/generated/traits/TrackAfGame;", "trackAfGame", "Lcom/discord/analytics/generated/traits/TrackAfGame;", "getTrackAfGame", "()Lcom/discord/analytics/generated/traits/TrackAfGame;", "setTrackAfGame", "(Lcom/discord/analytics/generated/traits/TrackAfGame;)V", "Lcom/discord/analytics/generated/traits/TrackAfCard;", "trackAfCard", "Lcom/discord/analytics/generated/traits/TrackAfCard;", "getTrackAfCard", "()Lcom/discord/analytics/generated/traits/TrackAfCard;", "setTrackAfCard", "(Lcom/discord/analytics/generated/traits/TrackAfCard;)V", "<init>", "()V", "analytics_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final class TrackAfGuildVisited implements AnalyticsSchema, TrackBase2, TrackAfCard2, TrackAfGame2, TrackAfParty2, TrackGuild2, TrackChannel2, TrackSourceMetadata2 {
    private final transient String analyticsSchemaTypeName = "af_guild_visited";
    private TrackAfCard trackAfCard;
    private TrackAfGame trackAfGame;
    private TrackAfParty trackAfParty;
    private TrackBase trackBase;
    private TrackChannel trackChannel;
    private TrackGuild trackGuild;
    private TrackSourceMetadata trackSourceMetadata;

    @Override // com.discord.analytics.generated.traits.TrackGuild2
    /* renamed from: a, reason: from getter */
    public TrackGuild getTrackGuild() {
        return this.trackGuild;
    }

    @Override // com.discord.analytics.generated.traits.TrackGuild2
    public void c(TrackGuild trackGuild) {
        this.trackGuild = trackGuild;
    }

    @Override // com.discord.api.science.AnalyticsSchema
    /* renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }
}
