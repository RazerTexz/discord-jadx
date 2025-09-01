package com.discord.nullserializable;

import androidx.exifinterface.media.ExifInterface;
import b.i.d.TypeAdapterFactory2;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.reflect.TypeToken;
import d0.z.d.Intrinsics3;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Objects;
import kotlin.Metadata;

/* compiled from: NullSerializable.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\n\u0010\u000bJ3\u0010\b\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0007\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0004\u001a\u00020\u00032\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H\u0016¢\u0006\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lcom/discord/nullserializable/NullSerializableTypeAdapterFactory;", "Lb/i/d/o;", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/google/gson/Gson;", "gson", "Lcom/google/gson/reflect/TypeToken;", "type", "Lcom/google/gson/TypeAdapter;", "create", "(Lcom/google/gson/Gson;Lcom/google/gson/reflect/TypeToken;)Lcom/google/gson/TypeAdapter;", "<init>", "()V", "discord_api"}, k = 1, mv = {1, 4, 2})
/* renamed from: com.discord.nullserializable.NullSerializableTypeAdapterFactory, reason: use source file name */
/* loaded from: classes.dex */
public final class NullSerializable3 implements TypeAdapterFactory2 {
    @Override // b.i.d.TypeAdapterFactory2
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
        Intrinsics3.checkNotNullParameter(gson, "gson");
        Intrinsics3.checkNotNullParameter(type, "type");
        if (!NullSerializable.class.isAssignableFrom(type.getRawType())) {
            return null;
        }
        Type type2 = type.getType();
        Objects.requireNonNull(type2, "null cannot be cast to non-null type java.lang.reflect.ParameterizedType");
        TypeAdapter<T> typeAdapterH = gson.h(TypeToken.get(((ParameterizedType) type2).getActualTypeArguments()[0]));
        Intrinsics3.checkNotNullExpressionValue(typeAdapterH, "delegateTypeAdapter");
        return new NullSerializable2(gson, typeAdapterH);
    }
}
