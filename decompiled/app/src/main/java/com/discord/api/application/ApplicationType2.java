package com.discord.api.application;

import b.c.a.a0.AnimatableValueParser;
import com.discord.api.application.ApplicationType;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import d0.z.d.Intrinsics3;
import java.io.IOException;
import java.util.Objects;
import kotlin.Metadata;

/* compiled from: ApplicationType.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/discord/api/application/ApplicationTypeAdapter;", "Lcom/google/gson/TypeAdapter;", "Lcom/discord/api/application/ApplicationType;", "<init>", "()V", "discord_api"}, k = 1, mv = {1, 4, 2})
/* renamed from: com.discord.api.application.ApplicationTypeAdapter, reason: use source file name */
/* loaded from: classes.dex */
public final class ApplicationType2 extends TypeAdapter<ApplicationType> {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.api.application.ApplicationTypeAdapter$WhenMappings */
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            ApplicationType.values();
            int[] iArr = new int[5];
            $EnumSwitchMapping$0 = iArr;
            iArr[ApplicationType.UNKNOWN.ordinal()] = 1;
        }
    }

    @Override // com.google.gson.TypeAdapter
    public ApplicationType read(JsonReader jsonReader) throws IOException {
        Intrinsics3.checkNotNullParameter(jsonReader, "in");
        ApplicationType.Companion companion = ApplicationType.INSTANCE;
        Integer numN1 = AnimatableValueParser.n1(jsonReader);
        Objects.requireNonNull(companion);
        return (numN1 != null && numN1.intValue() == 1) ? ApplicationType.GAME : (numN1 != null && numN1.intValue() == 2) ? ApplicationType.MUSIC : (numN1 != null && numN1.intValue() == 3) ? ApplicationType.TICKETED_EVENTS : (numN1 != null && numN1.intValue() == 4) ? ApplicationType.GUILD_ROLE_SUBSCRIPTIONS : ApplicationType.UNKNOWN;
    }

    @Override // com.google.gson.TypeAdapter
    public void write(JsonWriter jsonWriter, ApplicationType applicationType) throws IOException {
        ApplicationType applicationType2 = applicationType;
        Intrinsics3.checkNotNullParameter(jsonWriter, "out");
        if (applicationType2 != null) {
            jsonWriter.D(applicationType2.ordinal() != 0 ? Integer.valueOf(applicationType2.getApiValue()) : null);
        } else {
            jsonWriter.s();
        }
    }
}
