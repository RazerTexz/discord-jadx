package com.discord.api.premium;

import b.c.a.a0.AnimatableValueParser;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import d0.z.d.Intrinsics3;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;

/* compiled from: PremiumTier.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/discord/api/premium/PremiumTierTypeAdapter;", "Lcom/google/gson/TypeAdapter;", "Lcom/discord/api/premium/PremiumTier;", "<init>", "()V", "discord_api"}, k = 1, mv = {1, 4, 2})
/* renamed from: com.discord.api.premium.PremiumTierTypeAdapter, reason: use source file name */
/* loaded from: classes.dex */
public final class PremiumTier2 extends TypeAdapter<PremiumTier> {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.api.premium.PremiumTierTypeAdapter$WhenMappings */
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            PremiumTier.values();
            int[] iArr = new int[5];
            $EnumSwitchMapping$0 = iArr;
            iArr[PremiumTier.PREMIUM_GUILD_SUBSCRIPTION_ONLY.ordinal()] = 1;
            iArr[PremiumTier.TIER_1.ordinal()] = 2;
            iArr[PremiumTier.TIER_2.ordinal()] = 3;
            iArr[PremiumTier.TIER_0.ordinal()] = 4;
            iArr[PremiumTier.NONE.ordinal()] = 5;
        }
    }

    @Override // com.google.gson.TypeAdapter
    public PremiumTier read(JsonReader jsonReader) throws IOException {
        Intrinsics3.checkNotNullParameter(jsonReader, "in");
        Integer numN1 = AnimatableValueParser.n1(jsonReader);
        return (numN1 != null && numN1.intValue() == 0) ? PremiumTier.PREMIUM_GUILD_SUBSCRIPTION_ONLY : (numN1 != null && numN1.intValue() == 1) ? PremiumTier.TIER_1 : (numN1 != null && numN1.intValue() == 2) ? PremiumTier.TIER_2 : (numN1 != null && numN1.intValue() == 3) ? PremiumTier.TIER_0 : PremiumTier.NONE;
    }

    @Override // com.google.gson.TypeAdapter
    public void write(JsonWriter jsonWriter, PremiumTier premiumTier) throws IOException {
        Integer num;
        PremiumTier premiumTier2 = premiumTier;
        Intrinsics3.checkNotNullParameter(jsonWriter, "out");
        if (premiumTier2 == null) {
            jsonWriter.s();
            return;
        }
        int iOrdinal = premiumTier2.ordinal();
        if (iOrdinal == 0) {
            num = null;
        } else if (iOrdinal == 1) {
            num = 0;
        } else if (iOrdinal == 2) {
            num = 3;
        } else if (iOrdinal == 3) {
            num = 1;
        } else {
            if (iOrdinal != 4) {
                throw new NoWhenBranchMatchedException();
            }
            num = 2;
        }
        jsonWriter.D(num);
    }
}
