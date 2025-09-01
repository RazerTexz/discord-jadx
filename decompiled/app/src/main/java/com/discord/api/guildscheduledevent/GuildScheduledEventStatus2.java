package com.discord.api.guildscheduledevent;

import com.discord.api.guildscheduledevent.GuildScheduledEventStatus;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import d0.z.d.Intrinsics3;
import java.io.IOException;
import java.util.Objects;
import kotlin.Metadata;

/* compiled from: GuildScheduledEventStatus.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/discord/api/guildscheduledevent/GuildScheduledEventStatusTypeAdapter;", "Lcom/google/gson/TypeAdapter;", "Lcom/discord/api/guildscheduledevent/GuildScheduledEventStatus;", "<init>", "()V", "discord_api"}, k = 1, mv = {1, 4, 2})
/* renamed from: com.discord.api.guildscheduledevent.GuildScheduledEventStatusTypeAdapter, reason: use source file name */
/* loaded from: classes.dex */
public final class GuildScheduledEventStatus2 extends TypeAdapter<GuildScheduledEventStatus> {
    @Override // com.google.gson.TypeAdapter
    public GuildScheduledEventStatus read(JsonReader jsonReader) throws IOException {
        Intrinsics3.checkNotNullParameter(jsonReader, "in");
        GuildScheduledEventStatus.Companion companion = GuildScheduledEventStatus.INSTANCE;
        int iY = jsonReader.y();
        Objects.requireNonNull(companion);
        return iY != 1 ? iY != 2 ? iY != 3 ? iY != 4 ? GuildScheduledEventStatus.UNKNOWN : GuildScheduledEventStatus.CANCELED : GuildScheduledEventStatus.COMPLETED : GuildScheduledEventStatus.ACTIVE : GuildScheduledEventStatus.SCHEDULED;
    }

    @Override // com.google.gson.TypeAdapter
    public void write(JsonWriter jsonWriter, GuildScheduledEventStatus guildScheduledEventStatus) throws IOException {
        GuildScheduledEventStatus guildScheduledEventStatus2 = guildScheduledEventStatus;
        Intrinsics3.checkNotNullParameter(jsonWriter, "out");
        if (guildScheduledEventStatus2 != null) {
            jsonWriter.D(Integer.valueOf(guildScheduledEventStatus2.getApiValue()));
        } else {
            jsonWriter.s();
        }
    }
}
