package com.discord.api.auth;

import com.discord.api.auth.OAuthScope;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import d0.e0.KClass;
import d0.z.d.Intrinsics3;
import d0.z.d.Reflection2;
import java.io.IOException;
import java.util.HashMap;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: OAuthScopeTypeAdapter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00052\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0005B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0006"}, d2 = {"Lcom/discord/api/auth/OAuthScopeTypeAdapter;", "Lcom/google/gson/TypeAdapter;", "Lcom/discord/api/auth/OAuthScope;", "<init>", "()V", "Companion", "discord_api"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final class OAuthScopeTypeAdapter extends TypeAdapter<OAuthScope> {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final HashMap<String, OAuthScope> nameToScopeMap;

    /* compiled from: OAuthScopeTypeAdapter.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/discord/api/auth/OAuthScopeTypeAdapter$Companion;", "", "<init>", "()V", "discord_api"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
        }
    }

    static {
        HashMap<String, OAuthScope> map = new HashMap<>();
        for (KClass kClass : Reflection2.getOrCreateKotlinClass(OAuthScope.class).getSealedSubclasses()) {
            if (kClass.getObjectInstance() != null) {
                Object objectInstance = kClass.getObjectInstance();
                Objects.requireNonNull(objectInstance, "null cannot be cast to non-null type com.discord.api.auth.OAuthScope");
                OAuthScope oAuthScope = (OAuthScope) objectInstance;
                map.put(oAuthScope.getScopeName(), oAuthScope);
            }
        }
        nameToScopeMap = map;
    }

    public static final /* synthetic */ HashMap a() {
        return nameToScopeMap;
    }

    @Override // com.google.gson.TypeAdapter
    public OAuthScope read(JsonReader jsonReader) throws IOException {
        Intrinsics3.checkNotNullParameter(jsonReader, "in");
        if (jsonReader.N() == JsonToken.NULL) {
            jsonReader.H();
            return null;
        }
        String strJ = jsonReader.J();
        OAuthScope invalid = nameToScopeMap.get(strJ);
        if (invalid == null) {
            Intrinsics3.checkNotNullExpressionValue(strJ, "scopeName");
            invalid = new OAuthScope.Invalid(strJ);
        }
        return invalid;
    }

    @Override // com.google.gson.TypeAdapter
    public void write(JsonWriter jsonWriter, OAuthScope oAuthScope) throws IOException {
        OAuthScope oAuthScope2 = oAuthScope;
        Intrinsics3.checkNotNullParameter(jsonWriter, "out");
        if (oAuthScope2 != null) {
            jsonWriter.H(oAuthScope2.getScopeName());
        } else {
            jsonWriter.s();
        }
    }
}
