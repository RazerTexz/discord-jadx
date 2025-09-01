package com.discord.api.stageinstance;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import d0.z.d.Intrinsics3;
import java.io.IOException;
import kotlin.Metadata;

/* compiled from: StageInstancePrivacyLevel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/discord/api/stageinstance/StageInstancePrivacyLevelTypeAdapter;", "Lcom/google/gson/TypeAdapter;", "Lcom/discord/api/stageinstance/StageInstancePrivacyLevel;", "<init>", "()V", "discord_api"}, k = 1, mv = {1, 4, 2})
/* renamed from: com.discord.api.stageinstance.StageInstancePrivacyLevelTypeAdapter, reason: use source file name */
/* loaded from: classes.dex */
public final class StageInstancePrivacyLevel2 extends TypeAdapter<StageInstancePrivacyLevel> {
    @Override // com.google.gson.TypeAdapter
    public StageInstancePrivacyLevel read(JsonReader jsonReader) throws IOException {
        StageInstancePrivacyLevel stageInstancePrivacyLevel;
        Intrinsics3.checkNotNullParameter(jsonReader, "in");
        int iY = jsonReader.y();
        StageInstancePrivacyLevel[] stageInstancePrivacyLevelArrValues = StageInstancePrivacyLevel.values();
        int i = 0;
        while (true) {
            if (i >= 3) {
                stageInstancePrivacyLevel = null;
                break;
            }
            stageInstancePrivacyLevel = stageInstancePrivacyLevelArrValues[i];
            if (stageInstancePrivacyLevel.getApiValue() == iY) {
                break;
            }
            i++;
        }
        return stageInstancePrivacyLevel != null ? stageInstancePrivacyLevel : StageInstancePrivacyLevel.INVALID;
    }

    @Override // com.google.gson.TypeAdapter
    public void write(JsonWriter jsonWriter, StageInstancePrivacyLevel stageInstancePrivacyLevel) throws IOException {
        StageInstancePrivacyLevel stageInstancePrivacyLevel2 = stageInstancePrivacyLevel;
        Intrinsics3.checkNotNullParameter(jsonWriter, "out");
        if (stageInstancePrivacyLevel2 != null) {
            jsonWriter.D(Integer.valueOf(stageInstancePrivacyLevel2.getApiValue()));
        } else {
            jsonWriter.s();
        }
    }
}
