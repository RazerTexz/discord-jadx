package com.discord.utilities.analytics;

import com.discord.analytics.generated.traits.TrackGuild;
import com.discord.models.guild.Guild;
import com.discord.stores.StoreStream;
import kotlin.Metadata;

/* compiled from: AnalyticsUtils.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\t\n\u0002\b\u0002\u001a\u0017\u0010\u0001\u001a\u0004\u0018\u00010\u0000*\u0004\u0018\u00010\u0000H\u0002¢\u0006\u0004\b\u0001\u0010\u0002*&\u0010\u0006\"\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00032\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0003¨\u0006\u0007"}, d2 = {"Lcom/discord/analytics/generated/traits/TrackGuild;", "fill", "(Lcom/discord/analytics/generated/traits/TrackGuild;)Lcom/discord/analytics/generated/traits/TrackGuild;", "Lkotlin/Pair;", "", "", "ThrottleKey", "app_productionGoogleRelease"}, k = 2, mv = {1, 4, 2})
/* renamed from: com.discord.utilities.analytics.AnalyticsUtilsKt, reason: use source file name */
/* loaded from: classes2.dex */
public final class AnalyticsUtils6 {
    public static final /* synthetic */ TrackGuild access$fill(TrackGuild trackGuild) {
        return fill(trackGuild);
    }

    private static final TrackGuild fill(TrackGuild trackGuild) {
        Long guildId;
        if (trackGuild != null && (guildId = trackGuild.getGuildId()) != null) {
            long jLongValue = guildId.longValue();
            StoreStream.Companion companion = StoreStream.INSTANCE;
            Guild guild = companion.getGuilds().getGuild(jLongValue);
            if (guild != null) {
                long id2 = companion.getUsers().getMeSnapshot().getId();
                return TrackGuild.a(trackGuild, null, null, null, null, null, null, null, null, null, Boolean.valueOf(companion.getGuilds().getMember(jLongValue, id2) != null), null, Boolean.valueOf(guild.isOwner(id2)), 1535);
            }
        }
        return trackGuild;
    }
}
