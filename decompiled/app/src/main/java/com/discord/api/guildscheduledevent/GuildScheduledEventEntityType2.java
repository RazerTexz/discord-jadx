package com.discord.api.guildscheduledevent;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import d0.z.d.Intrinsics3;
import java.io.IOException;
import kotlin.Metadata;

/* compiled from: GuildScheduledEventEntityType.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/discord/api/guildscheduledevent/GuildScheduledEventEntityTypeTypeAdapter;", "Lcom/google/gson/TypeAdapter;", "Lcom/discord/api/guildscheduledevent/GuildScheduledEventEntityType;", "<init>", "()V", "discord_api"}, k = 1, mv = {1, 4, 2})
/* renamed from: com.discord.api.guildscheduledevent.GuildScheduledEventEntityTypeTypeAdapter, reason: use source file name */
/* loaded from: classes.dex */
public final class GuildScheduledEventEntityType2 extends TypeAdapter<GuildScheduledEventEntityType> {
    @Override // com.google.gson.TypeAdapter
    public GuildScheduledEventEntityType read(JsonReader jsonReader) {
        Intrinsics3.checkNotNullParameter(jsonReader, "in");
        return GuildScheduledEventEntityType.INSTANCE.a(jsonReader.y());
    }

    @Override // com.google.gson.TypeAdapter
    public void write(JsonWriter jsonWriter, GuildScheduledEventEntityType guildScheduledEventEntityType) throws IOException {
        GuildScheduledEventEntityType guildScheduledEventEntityType2 = guildScheduledEventEntityType;
        Intrinsics3.checkNotNullParameter(jsonWriter, "out");
        if (guildScheduledEventEntityType2 != null) {
            jsonWriter.D(Integer.valueOf(guildScheduledEventEntityType2.getApiValue()));
        } else {
            jsonWriter.s();
        }
    }
}
