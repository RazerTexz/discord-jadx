package com.discord.api.user;

import com.discord.api.user.Phone;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import d0.z.d.Intrinsics3;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;

/* compiled from: Phone.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/discord/api/user/PhoneTypeAdapter;", "Lcom/google/gson/TypeAdapter;", "Lcom/discord/api/user/Phone;", "<init>", "()V", "discord_api"}, k = 1, mv = {1, 4, 2})
/* renamed from: com.discord.api.user.PhoneTypeAdapter, reason: use source file name */
/* loaded from: classes.dex */
public final class Phone2 extends TypeAdapter<Phone> {
    @Override // com.google.gson.TypeAdapter
    public Phone read(JsonReader jsonReader) throws IOException {
        Intrinsics3.checkNotNullParameter(jsonReader, "in");
        if (jsonReader.N() == JsonToken.NULL) {
            jsonReader.H();
            return Phone.NoPhoneNumber.INSTANCE;
        }
        String strJ = jsonReader.J();
        Intrinsics3.checkNotNullExpressionValue(strJ, "number");
        return new Phone.PhoneNumber(strJ);
    }

    @Override // com.google.gson.TypeAdapter
    public void write(JsonWriter jsonWriter, Phone phone) throws IOException {
        JsonWriter jsonWriterS;
        Phone phone2 = phone;
        Intrinsics3.checkNotNullParameter(jsonWriter, "out");
        if (phone2 instanceof Phone.PhoneNumber) {
            jsonWriterS = jsonWriter.H(((Phone.PhoneNumber) phone2).getNumber());
        } else {
            if (!Intrinsics3.areEqual(phone2, Phone.NoPhoneNumber.INSTANCE) && phone2 != null) {
                throw new NoWhenBranchMatchedException();
            }
            jsonWriterS = jsonWriter.s();
        }
        jsonWriterS.getClass();
    }
}
