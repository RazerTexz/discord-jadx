package com.discord.widgets.guildscheduledevent;

import com.discord.api.guildscheduledevent.GuildScheduledEventStatus;
import com.discord.restapi.RestAPIParams;
import com.discord.utilities.rest.RestAPI;
import kotlin.Metadata;
import kotlin.Unit;
import rx.Observable;

/* compiled from: GuildScheduledEventAPI.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\f\u0010\rJ+\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u00032\n\u0010\u0006\u001a\u00060\u0002j\u0002`\u0005¢\u0006\u0004\b\t\u0010\nJ+\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u00032\n\u0010\u0006\u001a\u00060\u0002j\u0002`\u0005¢\u0006\u0004\b\u000b\u0010\n¨\u0006\u000e"}, d2 = {"Lcom/discord/widgets/guildscheduledevent/GuildScheduledEventAPI;", "", "", "Lcom/discord/primitives/GuildId;", "guildId", "Lcom/discord/primitives/GuildScheduledEventId;", "guildScheduledEventId", "Lrx/Observable;", "", "startEvent", "(JJ)Lrx/Observable;", "endEvent", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class GuildScheduledEventAPI {
    public static final GuildScheduledEventAPI INSTANCE = new GuildScheduledEventAPI();

    private GuildScheduledEventAPI() {
    }

    public final Observable<Unit> endEvent(long guildId, long guildScheduledEventId) {
        return RestAPI.INSTANCE.getApi().updateGuildScheduledEvent(guildId, guildScheduledEventId, new RestAPIParams.UpdateGuildScheduledEventBody(null, null, null, null, null, null, null, null, GuildScheduledEventStatus.COMPLETED, null, 767, null));
    }

    public final Observable<Unit> startEvent(long guildId, long guildScheduledEventId) {
        return RestAPI.INSTANCE.getApi().updateGuildScheduledEvent(guildId, guildScheduledEventId, new RestAPIParams.UpdateGuildScheduledEventBody(null, null, null, null, null, null, null, null, GuildScheduledEventStatus.ACTIVE, null, 767, null));
    }
}
