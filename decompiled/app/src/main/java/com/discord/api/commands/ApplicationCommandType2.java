package com.discord.api.commands;

import com.discord.api.commands.ApplicationCommandType;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import d0.z.d.Intrinsics3;
import java.io.IOException;
import java.util.Objects;
import kotlin.Metadata;

/* compiled from: ApplicationCommandType.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/discord/api/commands/CommandTypeAdapter;", "Lcom/google/gson/TypeAdapter;", "Lcom/discord/api/commands/ApplicationCommandType;", "<init>", "()V", "discord_api"}, k = 1, mv = {1, 4, 2})
/* renamed from: com.discord.api.commands.CommandTypeAdapter, reason: use source file name */
/* loaded from: classes.dex */
public final class ApplicationCommandType2 extends TypeAdapter<ApplicationCommandType> {
    @Override // com.google.gson.TypeAdapter
    public ApplicationCommandType read(JsonReader jsonReader) throws IOException {
        Intrinsics3.checkNotNullParameter(jsonReader, "in");
        ApplicationCommandType.Companion companion = ApplicationCommandType.INSTANCE;
        int iY = jsonReader.y();
        Objects.requireNonNull(companion);
        switch (iY) {
            case 1:
                return ApplicationCommandType.SUBCOMMAND;
            case 2:
                return ApplicationCommandType.SUBCOMMAND_GROUP;
            case 3:
                return ApplicationCommandType.STRING;
            case 4:
                return ApplicationCommandType.INTEGER;
            case 5:
                return ApplicationCommandType.BOOLEAN;
            case 6:
                return ApplicationCommandType.USER;
            case 7:
                return ApplicationCommandType.CHANNEL;
            case 8:
                return ApplicationCommandType.ROLE;
            case 9:
                return ApplicationCommandType.MENTIONABLE;
            case 10:
                return ApplicationCommandType.NUMBER;
            case 11:
                return ApplicationCommandType.ATTACHMENT;
            default:
                return ApplicationCommandType.UNKNOWN;
        }
    }

    @Override // com.google.gson.TypeAdapter
    public void write(JsonWriter jsonWriter, ApplicationCommandType applicationCommandType) throws IOException {
        ApplicationCommandType applicationCommandType2 = applicationCommandType;
        Intrinsics3.checkNotNullParameter(jsonWriter, "out");
        if (applicationCommandType2 != null) {
            jsonWriter.D(Integer.valueOf(applicationCommandType2.getType()));
        } else {
            jsonWriter.s();
        }
    }
}
