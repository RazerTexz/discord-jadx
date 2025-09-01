package com.discord.nullserializable;

import androidx.exifinterface.media.ExifInterface;
import com.discord.nullserializable.NullSerializable;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import d0.z.d.Intrinsics3;
import java.io.IOException;
import java.util.Objects;
import kotlin.Metadata;

/* compiled from: NullSerializable.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\u0010\u0012\f\u0012\n\u0012\u0006\b\u0000\u0012\u00028\u00000\u00030\u0002B\u001d\u0012\u0006\u0010\n\u001a\u00020\u0007\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002¢\u0006\u0004\b\u000b\u0010\fR\u001c\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u00028\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005R\u0016\u0010\n\u001a\u00020\u00078\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\t¨\u0006\r"}, d2 = {"Lcom/discord/nullserializable/NullSerializableTypeAdapter;", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/google/gson/TypeAdapter;", "Lcom/discord/nullserializable/NullSerializable;", "b", "Lcom/google/gson/TypeAdapter;", "delegateTypeAdapter", "Lcom/google/gson/Gson;", "a", "Lcom/google/gson/Gson;", "gsonInstance", "<init>", "(Lcom/google/gson/Gson;Lcom/google/gson/TypeAdapter;)V", "discord_api"}, k = 1, mv = {1, 4, 2})
/* renamed from: com.discord.nullserializable.NullSerializableTypeAdapter, reason: use source file name */
/* loaded from: classes.dex */
public final class NullSerializable2<T> extends TypeAdapter<NullSerializable<? super T>> {

    /* renamed from: a, reason: from kotlin metadata */
    public final Gson gsonInstance;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final TypeAdapter<T> delegateTypeAdapter;

    public NullSerializable2(Gson gson, TypeAdapter<T> typeAdapter) {
        Intrinsics3.checkNotNullParameter(gson, "gsonInstance");
        Intrinsics3.checkNotNullParameter(typeAdapter, "delegateTypeAdapter");
        this.gsonInstance = gson;
        this.delegateTypeAdapter = typeAdapter;
    }

    @Override // com.google.gson.TypeAdapter
    public Object read(JsonReader jsonReader) throws IOException {
        Intrinsics3.checkNotNullParameter(jsonReader, "in");
        T t = this.delegateTypeAdapter.read(jsonReader);
        return t == null ? new NullSerializable.a(null, 1) : new NullSerializable.b(t);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.gson.TypeAdapter
    public void write(JsonWriter jsonWriter, Object obj) throws IOException {
        NullSerializable nullSerializable = (NullSerializable) obj;
        Intrinsics3.checkNotNullParameter(jsonWriter, "out");
        if (nullSerializable instanceof NullSerializable.b) {
            Object objA = nullSerializable.a();
            Gson gson = this.gsonInstance;
            Intrinsics3.checkNotNull(objA);
            TypeAdapter typeAdapterI = gson.i(objA.getClass());
            Objects.requireNonNull(typeAdapterI, "null cannot be cast to non-null type com.google.gson.TypeAdapter<T>");
            typeAdapterI.write(jsonWriter, objA);
            return;
        }
        if (nullSerializable instanceof NullSerializable.a) {
            boolean z2 = jsonWriter.t;
            jsonWriter.t = true;
            jsonWriter.s();
            jsonWriter.t = z2;
            return;
        }
        if (nullSerializable == null) {
            boolean z3 = jsonWriter.t;
            jsonWriter.t = false;
            jsonWriter.s();
            jsonWriter.t = z3;
        }
    }
}
