package com.discord.api.premium;

import b.c.a.a0.AnimatableValueParser;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import d0.z.d.Intrinsics3;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;

/* compiled from: PriceTierType.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/discord/api/premium/PriceTierTypeAdapter;", "Lcom/google/gson/TypeAdapter;", "Lcom/discord/api/premium/PriceTierType;", "<init>", "()V", "discord_api"}, k = 1, mv = {1, 4, 2})
/* renamed from: com.discord.api.premium.PriceTierTypeAdapter, reason: use source file name */
/* loaded from: classes.dex */
public final class PriceTierType2 extends TypeAdapter<PriceTierType> {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.api.premium.PriceTierTypeAdapter$WhenMappings */
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            PriceTierType.values();
            int[] iArr = new int[2];
            $EnumSwitchMapping$0 = iArr;
            iArr[PriceTierType.GUILD_ROLE_SUBSCRIPTIONS.ordinal()] = 1;
            iArr[PriceTierType.UNKNOWN.ordinal()] = 2;
        }
    }

    @Override // com.google.gson.TypeAdapter
    public PriceTierType read(JsonReader jsonReader) throws IOException {
        Intrinsics3.checkNotNullParameter(jsonReader, "in");
        Integer numN1 = AnimatableValueParser.n1(jsonReader);
        return (numN1 != null && numN1.intValue() == 1) ? PriceTierType.GUILD_ROLE_SUBSCRIPTIONS : PriceTierType.UNKNOWN;
    }

    @Override // com.google.gson.TypeAdapter
    public void write(JsonWriter jsonWriter, PriceTierType priceTierType) throws IOException {
        Integer num;
        PriceTierType priceTierType2 = priceTierType;
        Intrinsics3.checkNotNullParameter(jsonWriter, "out");
        if (priceTierType2 == null) {
            jsonWriter.s();
            return;
        }
        int iOrdinal = priceTierType2.ordinal();
        if (iOrdinal == 0) {
            num = null;
        } else {
            if (iOrdinal != 1) {
                throw new NoWhenBranchMatchedException();
            }
            num = 1;
        }
        jsonWriter.D(num);
    }
}
