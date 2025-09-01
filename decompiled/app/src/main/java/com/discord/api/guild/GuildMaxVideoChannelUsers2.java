package com.discord.api.guild;

import com.discord.api.guild.GuildMaxVideoChannelUsers;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import d0.z.d.Intrinsics3;
import java.io.IOException;
import kotlin.Metadata;

/* compiled from: GuildMaxVideoChannelUsers.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/discord/api/guild/GuildMaxVideoChannelUsersTypeAdapter;", "Lcom/google/gson/TypeAdapter;", "Lcom/discord/api/guild/GuildMaxVideoChannelUsers;", "<init>", "()V", "discord_api"}, k = 1, mv = {1, 4, 2})
/* renamed from: com.discord.api.guild.GuildMaxVideoChannelUsersTypeAdapter, reason: use source file name */
/* loaded from: classes.dex */
public final class GuildMaxVideoChannelUsers2 extends TypeAdapter<GuildMaxVideoChannelUsers> {
    @Override // com.google.gson.TypeAdapter
    public GuildMaxVideoChannelUsers read(JsonReader jsonReader) throws IOException {
        Intrinsics3.checkNotNullParameter(jsonReader, "in");
        int iY = jsonReader.y();
        return iY != -1 ? new GuildMaxVideoChannelUsers.Limited(iY) : GuildMaxVideoChannelUsers.Unlimited.INSTANCE;
    }

    @Override // com.google.gson.TypeAdapter
    public void write(JsonWriter jsonWriter, GuildMaxVideoChannelUsers guildMaxVideoChannelUsers) throws IOException {
        GuildMaxVideoChannelUsers guildMaxVideoChannelUsers2 = guildMaxVideoChannelUsers;
        Intrinsics3.checkNotNullParameter(jsonWriter, "out");
        if (guildMaxVideoChannelUsers2 instanceof GuildMaxVideoChannelUsers.Limited) {
            jsonWriter.D(Integer.valueOf(((GuildMaxVideoChannelUsers.Limited) guildMaxVideoChannelUsers2).getLimit()));
        } else if (Intrinsics3.areEqual(guildMaxVideoChannelUsers2, GuildMaxVideoChannelUsers.Unlimited.INSTANCE)) {
            jsonWriter.A(-1L);
        } else if (guildMaxVideoChannelUsers2 == null) {
            jsonWriter.s();
        }
    }
}
