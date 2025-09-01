package com.discord.api.message.embed;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import d0.z.d.Intrinsics3;
import java.io.IOException;
import kotlin.Metadata;

/* compiled from: EmbedType.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/discord/api/message/embed/EmbedTypeTypeAdapter;", "Lcom/google/gson/TypeAdapter;", "Lcom/discord/api/message/embed/EmbedType;", "<init>", "()V", "discord_api"}, k = 1, mv = {1, 4, 2})
/* renamed from: com.discord.api.message.embed.EmbedTypeTypeAdapter, reason: use source file name */
/* loaded from: classes.dex */
public final class EmbedType3 extends TypeAdapter<EmbedType> {
    @Override // com.google.gson.TypeAdapter
    public EmbedType read(JsonReader jsonReader) throws IOException {
        EmbedType embedType;
        Intrinsics3.checkNotNullParameter(jsonReader, "in");
        String strJ = jsonReader.J();
        EmbedType[] embedTypeArrA = EmbedType2.a();
        int length = embedTypeArrA.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                embedType = null;
                break;
            }
            embedType = embedTypeArrA[i];
            if (Intrinsics3.areEqual(embedType.getApiValue(), strJ)) {
                break;
            }
            i++;
        }
        return embedType != null ? embedType : EmbedType.UNKNOWN;
    }

    @Override // com.google.gson.TypeAdapter
    public void write(JsonWriter jsonWriter, EmbedType embedType) throws IOException {
        EmbedType embedType2 = embedType;
        Intrinsics3.checkNotNullParameter(jsonWriter, "out");
        if (embedType2 != null) {
            jsonWriter.H(embedType2.getApiValue());
        } else {
            jsonWriter.s();
        }
    }
}
