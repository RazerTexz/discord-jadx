package com.discord.api.guildrolesubscription;

import com.discord.api.guildrolesubscription.GuildRoleSubscriptionBenefitType;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import d0.z.d.Intrinsics3;
import java.io.IOException;
import java.util.Objects;
import kotlin.Metadata;

/* compiled from: GuildRoleSubscriptionBenefitType.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/discord/api/guildrolesubscription/GuildRoleSubscriptionBenefitTypeAdapter;", "Lcom/google/gson/TypeAdapter;", "Lcom/discord/api/guildrolesubscription/GuildRoleSubscriptionBenefitType;", "<init>", "()V", "discord_api"}, k = 1, mv = {1, 4, 2})
/* renamed from: com.discord.api.guildrolesubscription.GuildRoleSubscriptionBenefitTypeAdapter, reason: use source file name */
/* loaded from: classes.dex */
public final class GuildRoleSubscriptionBenefitType2 extends TypeAdapter<GuildRoleSubscriptionBenefitType> {
    @Override // com.google.gson.TypeAdapter
    public GuildRoleSubscriptionBenefitType read(JsonReader jsonReader) throws IOException {
        Intrinsics3.checkNotNullParameter(jsonReader, "in");
        GuildRoleSubscriptionBenefitType.Companion companion = GuildRoleSubscriptionBenefitType.INSTANCE;
        int iY = jsonReader.y();
        Objects.requireNonNull(companion);
        return iY != 1 ? iY != 2 ? GuildRoleSubscriptionBenefitType.UNKNOWN : GuildRoleSubscriptionBenefitType.INTANGIBLE : GuildRoleSubscriptionBenefitType.CHANNEL;
    }

    @Override // com.google.gson.TypeAdapter
    public void write(JsonWriter jsonWriter, GuildRoleSubscriptionBenefitType guildRoleSubscriptionBenefitType) throws IOException {
        GuildRoleSubscriptionBenefitType guildRoleSubscriptionBenefitType2 = guildRoleSubscriptionBenefitType;
        Intrinsics3.checkNotNullParameter(jsonWriter, "out");
        if (guildRoleSubscriptionBenefitType2 != null) {
            jsonWriter.D(Integer.valueOf(guildRoleSubscriptionBenefitType2.getApiValue()));
        } else {
            jsonWriter.s();
        }
    }
}
