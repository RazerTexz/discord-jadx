package com.discord.widgets.guildscheduledevent;

import com.discord.api.guildscheduledevent.GuildScheduledEvent;
import com.discord.api.utcdatetime.UtcDateTime;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.Tuples2;

/* compiled from: GuildScheduledEventModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/discord/api/guildscheduledevent/GuildScheduledEvent;", "Lcom/discord/widgets/guildscheduledevent/GuildScheduledEventModel;", "toModel", "(Lcom/discord/api/guildscheduledevent/GuildScheduledEvent;)Lcom/discord/widgets/guildscheduledevent/GuildScheduledEventModel;", "app_productionGoogleRelease"}, k = 2, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.guildscheduledevent.GuildScheduledEventModelKt, reason: use source file name */
/* loaded from: classes2.dex */
public final class GuildScheduledEventModel2 {
    public static final GuildScheduledEventModel toModel(GuildScheduledEvent guildScheduledEvent) {
        Intrinsics3.checkNotNullParameter(guildScheduledEvent, "$this$toModel");
        GuildScheduledEventPickerDateTime guildScheduledEventPickerDateTime = GuildScheduledEventPickerDateTime.INSTANCE;
        Tuples2<GuildScheduledEventPickerDateTime2, GuildScheduledEventPickerDateTime3> tuples2FromUtcDateTime = guildScheduledEventPickerDateTime.fromUtcDateTime(guildScheduledEvent.getScheduledStartTime());
        UtcDateTime scheduledEndTime = guildScheduledEvent.getScheduledEndTime();
        Tuples2<GuildScheduledEventPickerDateTime2, GuildScheduledEventPickerDateTime3> tuples2FromUtcDateTime2 = scheduledEndTime != null ? guildScheduledEventPickerDateTime.fromUtcDateTime(scheduledEndTime) : null;
        return new GuildScheduledEventModel(guildScheduledEvent.getGuildId(), guildScheduledEvent.getName(), guildScheduledEvent.getChannelId(), guildScheduledEvent.getCreatorId(), tuples2FromUtcDateTime.getFirst(), tuples2FromUtcDateTime.getSecond(), tuples2FromUtcDateTime2 != null ? tuples2FromUtcDateTime2.getFirst() : null, tuples2FromUtcDateTime2 != null ? tuples2FromUtcDateTime2.getSecond() : null, guildScheduledEvent.getDescription(), guildScheduledEvent.getEntityType(), guildScheduledEvent.getEntityMetadata(), guildScheduledEvent.getUserCount(), null, 4096, null);
    }
}
