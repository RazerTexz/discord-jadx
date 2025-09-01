package com.discord.api.guild;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import d0.z.d.Intrinsics3;
import java.io.IOException;
import kotlin.Metadata;

/* compiled from: GuildExplicitContentFilter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/discord/api/guild/GuildExplicitContentFilterTypeAdapter;", "Lcom/google/gson/TypeAdapter;", "Lcom/discord/api/guild/GuildExplicitContentFilter;", "<init>", "()V", "discord_api"}, k = 1, mv = {1, 4, 2})
/* renamed from: com.discord.api.guild.GuildExplicitContentFilterTypeAdapter, reason: use source file name */
/* loaded from: classes.dex */
public final class GuildExplicitContentFilter2 extends TypeAdapter<GuildExplicitContentFilter> {
    @Override // com.google.gson.TypeAdapter
    public GuildExplicitContentFilter read(JsonReader jsonReader) throws IOException {
        GuildExplicitContentFilter guildExplicitContentFilter;
        Intrinsics3.checkNotNullParameter(jsonReader, "in");
        int iY = jsonReader.y();
        GuildExplicitContentFilter[] guildExplicitContentFilterArrValues = GuildExplicitContentFilter.values();
        int i = 0;
        while (true) {
            if (i >= 3) {
                guildExplicitContentFilter = null;
                break;
            }
            guildExplicitContentFilter = guildExplicitContentFilterArrValues[i];
            if (guildExplicitContentFilter.getApiValue() == iY) {
                break;
            }
            i++;
        }
        return guildExplicitContentFilter != null ? guildExplicitContentFilter : GuildExplicitContentFilter.NONE;
    }

    @Override // com.google.gson.TypeAdapter
    public void write(JsonWriter jsonWriter, GuildExplicitContentFilter guildExplicitContentFilter) throws IOException {
        GuildExplicitContentFilter guildExplicitContentFilter2 = guildExplicitContentFilter;
        Intrinsics3.checkNotNullParameter(jsonWriter, "out");
        if (guildExplicitContentFilter2 != null) {
            jsonWriter.D(Integer.valueOf(guildExplicitContentFilter2.getApiValue()));
        } else {
            jsonWriter.s();
        }
    }
}
