package com.discord.api.localizedstring;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import d0.t.Maps6;
import d0.z.d.Intrinsics3;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;

/* compiled from: LocalizedString.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/discord/api/localizedstring/LocalizedStringTypeAdapter;", "Lcom/google/gson/TypeAdapter;", "Lcom/discord/api/localizedstring/LocalizedString;", "<init>", "()V", "discord_api"}, k = 1, mv = {1, 4, 2})
/* renamed from: com.discord.api.localizedstring.LocalizedStringTypeAdapter, reason: use source file name */
/* loaded from: classes.dex */
public final class LocalizedString2 extends TypeAdapter<LocalizedString> {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.api.localizedstring.LocalizedStringTypeAdapter$WhenMappings */
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            JsonToken.values();
            int[] iArr = new int[10];
            $EnumSwitchMapping$0 = iArr;
            iArr[2] = 1;
            iArr[5] = 2;
        }
    }

    @Override // com.google.gson.TypeAdapter
    public LocalizedString read(JsonReader jsonReader) throws IOException {
        Intrinsics3.checkNotNullParameter(jsonReader, "in");
        JsonToken jsonTokenN = jsonReader.N();
        if (jsonTokenN != null) {
            int iOrdinal = jsonTokenN.ordinal();
            if (iOrdinal == 2) {
                jsonReader.b();
                HashMap map = new HashMap();
                String strJ = "";
                while (jsonReader.q()) {
                    String strC = jsonReader.C();
                    if (strC != null) {
                        int iHashCode = strC.hashCode();
                        if (iHashCode != 597626106) {
                            if (iHashCode == 1544803905 && strC.equals("default")) {
                                strJ = jsonReader.J();
                                Intrinsics3.checkNotNullExpressionValue(strJ, "`in`.nextString()");
                            }
                        } else if (strC.equals("localizations")) {
                            jsonReader.b();
                            while (jsonReader.q()) {
                                String strC2 = jsonReader.C();
                                String strJ2 = jsonReader.J();
                                Intrinsics3.checkNotNullExpressionValue(strC2, "locale");
                                Intrinsics3.checkNotNullExpressionValue(strJ2, "localization");
                                map.put(strC2, strJ2);
                            }
                            jsonReader.f();
                        }
                    }
                }
                jsonReader.f();
                return new LocalizedString(strJ, map);
            }
            if (iOrdinal == 5) {
                String strJ3 = jsonReader.J();
                Intrinsics3.checkNotNullExpressionValue(strJ3, "default");
                return new LocalizedString(strJ3, Maps6.emptyMap());
            }
        }
        throw new IllegalArgumentException("could not parse localized string. token was: " + jsonTokenN);
    }

    @Override // com.google.gson.TypeAdapter
    public void write(JsonWriter jsonWriter, LocalizedString localizedString) throws IOException {
        LocalizedString localizedString2 = localizedString;
        Intrinsics3.checkNotNullParameter(jsonWriter, "out");
        if (localizedString2 == null) {
            jsonWriter.s();
            return;
        }
        jsonWriter.c();
        jsonWriter.n("default");
        jsonWriter.H(localizedString2.getDefault());
        jsonWriter.n("localizations");
        jsonWriter.c();
        for (Map.Entry<String, String> entry : localizedString2.b().entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            jsonWriter.n(key);
            jsonWriter.H(value);
        }
        jsonWriter.f();
        jsonWriter.f();
    }
}
