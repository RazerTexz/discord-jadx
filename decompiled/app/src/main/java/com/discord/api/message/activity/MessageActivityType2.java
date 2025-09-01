package com.discord.api.message.activity;

import b.c.a.a0.AnimatableValueParser;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import d0.z.d.Intrinsics3;
import java.io.IOException;
import kotlin.Metadata;

/* compiled from: MessageActivityType.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/discord/api/message/activity/MessageActivityTypeTypeAdapter;", "Lcom/google/gson/TypeAdapter;", "Lcom/discord/api/message/activity/MessageActivityType;", "<init>", "()V", "discord_api"}, k = 1, mv = {1, 4, 2})
/* renamed from: com.discord.api.message.activity.MessageActivityTypeTypeAdapter, reason: use source file name */
/* loaded from: classes.dex */
public final class MessageActivityType2 extends TypeAdapter<MessageActivityType> {
    @Override // com.google.gson.TypeAdapter
    public MessageActivityType read(JsonReader jsonReader) {
        Intrinsics3.checkNotNullParameter(jsonReader, "in");
        return MessageActivityType.INSTANCE.a(AnimatableValueParser.n1(jsonReader));
    }

    @Override // com.google.gson.TypeAdapter
    public void write(JsonWriter jsonWriter, MessageActivityType messageActivityType) throws IOException {
        MessageActivityType messageActivityType2 = messageActivityType;
        Intrinsics3.checkNotNullParameter(jsonWriter, "out");
        if (messageActivityType2 != null) {
            jsonWriter.D(Integer.valueOf(messageActivityType2.getApiInt()));
        } else {
            jsonWriter.s();
        }
    }
}
