package com.discord.api.friendsuggestions;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import d0.z.d.Intrinsics3;
import java.io.IOException;
import kotlin.Metadata;

/* compiled from: AllowedInSuggestionsType.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/discord/api/friendsuggestions/AllowedInSuggestionsTypeAdapter;", "Lcom/google/gson/TypeAdapter;", "Lcom/discord/api/friendsuggestions/AllowedInSuggestionsType;", "<init>", "()V", "discord_api"}, k = 1, mv = {1, 4, 2})
/* renamed from: com.discord.api.friendsuggestions.AllowedInSuggestionsTypeAdapter, reason: use source file name */
/* loaded from: classes.dex */
public final class AllowedInSuggestionsType2 extends TypeAdapter<AllowedInSuggestionsType> {
    @Override // com.google.gson.TypeAdapter
    public AllowedInSuggestionsType read(JsonReader jsonReader) throws IOException {
        AllowedInSuggestionsType allowedInSuggestionsType;
        Intrinsics3.checkNotNullParameter(jsonReader, "in");
        int iY = jsonReader.y();
        AllowedInSuggestionsType[] allowedInSuggestionsTypeArrValues = AllowedInSuggestionsType.values();
        int i = 0;
        while (true) {
            if (i >= 3) {
                allowedInSuggestionsType = null;
                break;
            }
            allowedInSuggestionsType = allowedInSuggestionsTypeArrValues[i];
            if (allowedInSuggestionsType.getApiValue() == iY) {
                break;
            }
            i++;
        }
        return allowedInSuggestionsType != null ? allowedInSuggestionsType : AllowedInSuggestionsType.DISABLED;
    }

    @Override // com.google.gson.TypeAdapter
    public void write(JsonWriter jsonWriter, AllowedInSuggestionsType allowedInSuggestionsType) throws IOException {
        AllowedInSuggestionsType allowedInSuggestionsType2 = allowedInSuggestionsType;
        Intrinsics3.checkNotNullParameter(jsonWriter, "out");
        if (allowedInSuggestionsType2 != null) {
            jsonWriter.D(Integer.valueOf(allowedInSuggestionsType2.getApiValue()));
        } else {
            jsonWriter.s();
        }
    }
}
