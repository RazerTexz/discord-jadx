package com.discord.api.guildrolesubscription;

import com.discord.api.guildrolesubscription.PayoutGroupType;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import d0.z.d.Intrinsics3;
import java.io.IOException;
import java.util.Objects;
import kotlin.Metadata;

/* compiled from: PayoutGroupType.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/discord/api/guildrolesubscription/PayoutGroupTypeAdapter;", "Lcom/google/gson/TypeAdapter;", "Lcom/discord/api/guildrolesubscription/PayoutGroupType;", "<init>", "()V", "discord_api"}, k = 1, mv = {1, 4, 2})
/* renamed from: com.discord.api.guildrolesubscription.PayoutGroupTypeAdapter, reason: use source file name */
/* loaded from: classes.dex */
public final class PayoutGroupType2 extends TypeAdapter<PayoutGroupType> {
    @Override // com.google.gson.TypeAdapter
    public PayoutGroupType read(JsonReader jsonReader) throws IOException {
        Intrinsics3.checkNotNullParameter(jsonReader, "in");
        PayoutGroupType.Companion companion = PayoutGroupType.INSTANCE;
        String strJ = jsonReader.J();
        Intrinsics3.checkNotNullExpressionValue(strJ, "`in`.nextString()");
        Objects.requireNonNull(companion);
        Intrinsics3.checkNotNullParameter(strJ, "apiValue");
        PayoutGroupType payoutGroupType = PayoutGroupType.MARKETPLACE;
        if (Intrinsics3.areEqual(strJ, payoutGroupType.getApiValue())) {
            return payoutGroupType;
        }
        PayoutGroupType payoutGroupType2 = PayoutGroupType.STAGE_EVENT_SKU;
        if (Intrinsics3.areEqual(strJ, payoutGroupType2.getApiValue())) {
            return payoutGroupType2;
        }
        PayoutGroupType payoutGroupType3 = PayoutGroupType.SERVER_ROLE_SUBSCRIPTION;
        return Intrinsics3.areEqual(strJ, payoutGroupType3.getApiValue()) ? payoutGroupType3 : PayoutGroupType.UNKNOWN;
    }

    @Override // com.google.gson.TypeAdapter
    public void write(JsonWriter jsonWriter, PayoutGroupType payoutGroupType) throws IOException {
        PayoutGroupType payoutGroupType2 = payoutGroupType;
        Intrinsics3.checkNotNullParameter(jsonWriter, "out");
        if (payoutGroupType2 != null) {
            jsonWriter.H(payoutGroupType2.getApiValue());
        } else {
            jsonWriter.s();
        }
    }
}
