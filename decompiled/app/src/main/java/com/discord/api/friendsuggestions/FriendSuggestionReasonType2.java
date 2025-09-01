package com.discord.api.friendsuggestions;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import d0.z.d.Intrinsics3;
import java.io.IOException;
import kotlin.Metadata;

/* compiled from: FriendSuggestionReasonType.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/discord/api/friendsuggestions/FriendSuggestionReasonTypeAdapter;", "Lcom/google/gson/TypeAdapter;", "Lcom/discord/api/friendsuggestions/FriendSuggestionReasonType;", "<init>", "()V", "discord_api"}, k = 1, mv = {1, 4, 2})
/* renamed from: com.discord.api.friendsuggestions.FriendSuggestionReasonTypeAdapter, reason: use source file name */
/* loaded from: classes.dex */
public final class FriendSuggestionReasonType2 extends TypeAdapter<FriendSuggestionReasonType> {
    @Override // com.google.gson.TypeAdapter
    public FriendSuggestionReasonType read(JsonReader jsonReader) throws IOException {
        FriendSuggestionReasonType friendSuggestionReasonType;
        Intrinsics3.checkNotNullParameter(jsonReader, "in");
        int iY = jsonReader.y();
        FriendSuggestionReasonType[] friendSuggestionReasonTypeArrValues = FriendSuggestionReasonType.values();
        int i = 0;
        while (true) {
            if (i >= 2) {
                friendSuggestionReasonType = null;
                break;
            }
            friendSuggestionReasonType = friendSuggestionReasonTypeArrValues[i];
            if (friendSuggestionReasonType.getApiValue() == iY) {
                break;
            }
            i++;
        }
        return friendSuggestionReasonType != null ? friendSuggestionReasonType : FriendSuggestionReasonType.NONE;
    }

    @Override // com.google.gson.TypeAdapter
    public void write(JsonWriter jsonWriter, FriendSuggestionReasonType friendSuggestionReasonType) throws IOException {
        FriendSuggestionReasonType friendSuggestionReasonType2 = friendSuggestionReasonType;
        Intrinsics3.checkNotNullParameter(jsonWriter, "out");
        if (friendSuggestionReasonType2 != null) {
            jsonWriter.D(Integer.valueOf(friendSuggestionReasonType2.getApiValue()));
        } else {
            jsonWriter.s();
        }
    }
}
