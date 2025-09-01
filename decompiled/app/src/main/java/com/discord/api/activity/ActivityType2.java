package com.discord.api.activity;

import b.c.a.a0.AnimatableValueParser;
import com.discord.api.activity.ActivityType;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import d0.z.d.Intrinsics3;
import java.io.IOException;
import java.util.Objects;
import kotlin.Metadata;

/* compiled from: ActivityType.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/discord/api/activity/ActivityTypeTypeAdapter;", "Lcom/google/gson/TypeAdapter;", "Lcom/discord/api/activity/ActivityType;", "<init>", "()V", "discord_api"}, k = 1, mv = {1, 4, 2})
/* renamed from: com.discord.api.activity.ActivityTypeTypeAdapter, reason: use source file name */
/* loaded from: classes.dex */
public final class ActivityType2 extends TypeAdapter<ActivityType> {
    @Override // com.google.gson.TypeAdapter
    public ActivityType read(JsonReader jsonReader) throws IOException {
        Intrinsics3.checkNotNullParameter(jsonReader, "in");
        ActivityType.Companion companion = ActivityType.INSTANCE;
        Integer numN1 = AnimatableValueParser.n1(jsonReader);
        Objects.requireNonNull(companion);
        ActivityType activityType = ActivityType.PLAYING;
        int apiInt = activityType.getApiInt();
        if (numN1 != null && numN1.intValue() == apiInt) {
            return activityType;
        }
        ActivityType activityType2 = ActivityType.STREAMING;
        int apiInt2 = activityType2.getApiInt();
        if (numN1 != null && numN1.intValue() == apiInt2) {
            return activityType2;
        }
        ActivityType activityType3 = ActivityType.LISTENING;
        int apiInt3 = activityType3.getApiInt();
        if (numN1 != null && numN1.intValue() == apiInt3) {
            return activityType3;
        }
        ActivityType activityType4 = ActivityType.WATCHING;
        int apiInt4 = activityType4.getApiInt();
        if (numN1 != null && numN1.intValue() == apiInt4) {
            return activityType4;
        }
        ActivityType activityType5 = ActivityType.CUSTOM_STATUS;
        int apiInt5 = activityType5.getApiInt();
        if (numN1 != null && numN1.intValue() == apiInt5) {
            return activityType5;
        }
        ActivityType activityType6 = ActivityType.COMPETING;
        return (numN1 != null && numN1.intValue() == activityType6.getApiInt()) ? activityType6 : ActivityType.UNKNOWN;
    }

    @Override // com.google.gson.TypeAdapter
    public void write(JsonWriter jsonWriter, ActivityType activityType) throws IOException {
        ActivityType activityType2 = activityType;
        Intrinsics3.checkNotNullParameter(jsonWriter, "out");
        if (activityType2 != null) {
            jsonWriter.D(Integer.valueOf(activityType2.getApiInt()));
        } else {
            jsonWriter.s();
        }
    }
}
