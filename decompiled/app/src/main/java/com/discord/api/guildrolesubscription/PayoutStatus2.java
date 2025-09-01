package com.discord.api.guildrolesubscription;

import com.discord.api.guildrolesubscription.PayoutStatus;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import d0.z.d.Intrinsics3;
import java.io.IOException;
import java.util.Objects;
import kotlin.Metadata;

/* compiled from: PayoutStatus.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/discord/api/guildrolesubscription/PayoutStatusAdapter;", "Lcom/google/gson/TypeAdapter;", "Lcom/discord/api/guildrolesubscription/PayoutStatus;", "<init>", "()V", "discord_api"}, k = 1, mv = {1, 4, 2})
/* renamed from: com.discord.api.guildrolesubscription.PayoutStatusAdapter, reason: use source file name */
/* loaded from: classes.dex */
public final class PayoutStatus2 extends TypeAdapter<PayoutStatus> {
    @Override // com.google.gson.TypeAdapter
    public PayoutStatus read(JsonReader jsonReader) throws IOException {
        Intrinsics3.checkNotNullParameter(jsonReader, "in");
        PayoutStatus.Companion companion = PayoutStatus.INSTANCE;
        int iY = jsonReader.y();
        Objects.requireNonNull(companion);
        PayoutStatus payoutStatus = PayoutStatus.OPEN;
        if (iY == payoutStatus.getApiValue()) {
            return payoutStatus;
        }
        PayoutStatus payoutStatus2 = PayoutStatus.PAID;
        if (iY == payoutStatus2.getApiValue()) {
            return payoutStatus2;
        }
        PayoutStatus payoutStatus3 = PayoutStatus.PENDING;
        if (iY == payoutStatus3.getApiValue()) {
            return payoutStatus3;
        }
        PayoutStatus payoutStatus4 = PayoutStatus.MANUAL;
        if (iY == payoutStatus4.getApiValue()) {
            return payoutStatus4;
        }
        PayoutStatus payoutStatus5 = PayoutStatus.CANCELED;
        if (iY == payoutStatus5.getApiValue()) {
            return payoutStatus5;
        }
        PayoutStatus payoutStatus6 = PayoutStatus.DEFERRED;
        if (iY == payoutStatus6.getApiValue()) {
            return payoutStatus6;
        }
        PayoutStatus payoutStatus7 = PayoutStatus.DEFERRED_INTERNAL;
        if (iY == payoutStatus7.getApiValue()) {
            return payoutStatus7;
        }
        PayoutStatus payoutStatus8 = PayoutStatus.PROCESSING;
        if (iY == payoutStatus8.getApiValue()) {
            return payoutStatus8;
        }
        PayoutStatus payoutStatus9 = PayoutStatus.ERROR;
        if (iY == payoutStatus9.getApiValue()) {
            return payoutStatus9;
        }
        PayoutStatus payoutStatus10 = PayoutStatus.REJECTED;
        if (iY == payoutStatus10.getApiValue()) {
            return payoutStatus10;
        }
        PayoutStatus payoutStatus11 = PayoutStatus.RISK_REVIEW;
        if (iY == payoutStatus11.getApiValue()) {
            return payoutStatus11;
        }
        PayoutStatus payoutStatus12 = PayoutStatus.SUBMITTED;
        if (iY == payoutStatus12.getApiValue()) {
            return payoutStatus12;
        }
        PayoutStatus payoutStatus13 = PayoutStatus.PENDING_FUNDS;
        return iY == payoutStatus13.getApiValue() ? payoutStatus13 : PayoutStatus.UNKNOWN;
    }

    @Override // com.google.gson.TypeAdapter
    public void write(JsonWriter jsonWriter, PayoutStatus payoutStatus) throws IOException {
        PayoutStatus payoutStatus2 = payoutStatus;
        Intrinsics3.checkNotNullParameter(jsonWriter, "out");
        if (payoutStatus2 != null) {
            jsonWriter.D(Integer.valueOf(payoutStatus2.getApiValue()));
        } else {
            jsonWriter.s();
        }
    }
}
