package com.discord.api.auth;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import d0.z.d.Intrinsics3;
import java.io.IOException;
import java.util.Locale;
import kotlin.Metadata;

/* compiled from: RequiredAction.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/discord/api/auth/RequiredActionTypeAdapter;", "Lcom/google/gson/TypeAdapter;", "Lcom/discord/api/auth/RequiredAction;", "<init>", "()V", "discord_api"}, k = 1, mv = {1, 4, 2})
/* renamed from: com.discord.api.auth.RequiredActionTypeAdapter, reason: use source file name */
/* loaded from: classes.dex */
public final class RequiredAction2 extends TypeAdapter<RequiredAction> {
    @Override // com.google.gson.TypeAdapter
    public RequiredAction read(JsonReader jsonReader) throws IOException {
        Intrinsics3.checkNotNullParameter(jsonReader, "in");
        String strJ = jsonReader.J();
        return (strJ != null && strJ.hashCode() == 509052241 && strJ.equals("update_password")) ? RequiredAction.UPDATE_PASSWORD : RequiredAction.UNKNOWN;
    }

    @Override // com.google.gson.TypeAdapter
    public void write(JsonWriter jsonWriter, RequiredAction requiredAction) throws IOException {
        String lowerCase;
        String strName;
        RequiredAction requiredAction2 = requiredAction;
        Intrinsics3.checkNotNullParameter(jsonWriter, "out");
        if (requiredAction2 == null || (strName = requiredAction2.name()) == null) {
            lowerCase = null;
        } else {
            Locale locale = Locale.ROOT;
            Intrinsics3.checkNotNullExpressionValue(locale, "Locale.ROOT");
            lowerCase = strName.toLowerCase(locale);
            Intrinsics3.checkNotNullExpressionValue(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
        }
        jsonWriter.H(lowerCase);
    }
}
