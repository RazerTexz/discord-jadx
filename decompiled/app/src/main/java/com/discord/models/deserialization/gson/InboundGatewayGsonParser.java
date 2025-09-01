package com.discord.models.deserialization.gson;

import androidx.exifinterface.media.ExifInterface;
import b.a.b.TypeAdapterRegistrar;
import b.i.d.FieldNamingPolicy;
import b.i.d.GsonBuilder;
import com.discord.models.domain.Model;
import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.stream.JsonReader;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: InboundGatewayGsonParser.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0015\u0010\u0016J+\u0010\u0007\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0004\u001a\u00020\u00032\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H\u0007¢\u0006\u0004\b\u0007\u0010\bJ+\u0010\u0007\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0004\u001a\u00020\t2\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H\u0007¢\u0006\u0004\b\u0007\u0010\nJ\u001d\u0010\r\u001a\u00020\f\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u000b\u001a\u00028\u0000H\u0007¢\u0006\u0004\b\r\u0010\u000eR!\u0010\u0011\u001a\n \u0010*\u0004\u0018\u00010\u000f0\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0017"}, d2 = {"Lcom/discord/models/deserialization/gson/InboundGatewayGsonParser;", "", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/discord/models/domain/Model$JsonReader;", "reader", "Ljava/lang/Class;", "clazz", "fromJson", "(Lcom/discord/models/domain/Model$JsonReader;Ljava/lang/Class;)Ljava/lang/Object;", "Lcom/google/gson/stream/JsonReader;", "(Lcom/google/gson/stream/JsonReader;Ljava/lang/Class;)Ljava/lang/Object;", "source", "", "toJson", "(Ljava/lang/Object;)Ljava/lang/String;", "Lcom/google/gson/Gson;", "kotlin.jvm.PlatformType", "gatewayGsonInstance", "Lcom/google/gson/Gson;", "getGatewayGsonInstance", "()Lcom/google/gson/Gson;", "<init>", "()V", "app_models_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final class InboundGatewayGsonParser {
    public static final InboundGatewayGsonParser INSTANCE = new InboundGatewayGsonParser();
    private static final Gson gatewayGsonInstance;

    static {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.a = gsonBuilder.a.j(8);
        gsonBuilder.c = FieldNamingPolicy.m;
        Intrinsics3.checkNotNullExpressionValue(gsonBuilder, "GsonBuilder()\n          …ER_CASE_WITH_UNDERSCORES)");
        TypeAdapterRegistrar.a(gsonBuilder);
        gatewayGsonInstance = gsonBuilder.a();
    }

    private InboundGatewayGsonParser() {
    }

    public static final <T> T fromJson(Model.JsonReader reader, Class<T> clazz) {
        Intrinsics3.checkNotNullParameter(reader, "reader");
        Intrinsics3.checkNotNullParameter(clazz, "clazz");
        JsonReader jsonReader = reader.in;
        Intrinsics3.checkNotNullExpressionValue(jsonReader, "reader.`in`");
        return (T) fromJson(jsonReader, clazz);
    }

    public static final <T> String toJson(T source) throws JsonIOException {
        String strM = gatewayGsonInstance.m(source);
        Intrinsics3.checkNotNullExpressionValue(strM, "gatewayGsonInstance.toJson(source)");
        return strM;
    }

    public final Gson getGatewayGsonInstance() {
        return gatewayGsonInstance;
    }

    public static final <T> T fromJson(JsonReader reader, Class<T> clazz) {
        Intrinsics3.checkNotNullParameter(reader, "reader");
        Intrinsics3.checkNotNullParameter(clazz, "clazz");
        return (T) gatewayGsonInstance.d(reader, clazz);
    }
}
