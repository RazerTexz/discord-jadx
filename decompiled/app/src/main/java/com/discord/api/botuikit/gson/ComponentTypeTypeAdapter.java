package com.discord.api.botuikit.gson;

import b.c.a.a0.AnimatableValueParser;
import com.discord.api.botuikit.Component6;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import d0.z.d.Intrinsics3;
import java.io.IOException;
import kotlin.Metadata;

/* compiled from: ComponentTypeTypeAdapter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/discord/api/botuikit/gson/ComponentTypeTypeAdapter;", "Lcom/google/gson/TypeAdapter;", "Lcom/discord/api/botuikit/ComponentType;", "<init>", "()V", "discord_api"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final class ComponentTypeTypeAdapter extends TypeAdapter<Component6> {
    @Override // com.google.gson.TypeAdapter
    public Component6 read(JsonReader jsonReader) throws IOException {
        Component6 component6;
        Intrinsics3.checkNotNullParameter(jsonReader, "in");
        Integer numN1 = AnimatableValueParser.n1(jsonReader);
        Component6[] component6ArrValues = Component6.values();
        int i = 0;
        while (true) {
            if (i >= 5) {
                component6 = null;
                break;
            }
            component6 = component6ArrValues[i];
            if (numN1 != null && component6.getType() == numN1.intValue()) {
                break;
            }
            i++;
        }
        return component6 != null ? component6 : Component6.UNKNOWN;
    }

    @Override // com.google.gson.TypeAdapter
    public void write(JsonWriter jsonWriter, Component6 component6) throws IOException {
        Component6 component62 = component6;
        Intrinsics3.checkNotNullParameter(jsonWriter, "out");
        if (component62 != null) {
            jsonWriter.D(Integer.valueOf(component62.getType()));
        }
    }
}
