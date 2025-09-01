package b.i.d;

import com.google.gson.JsonElement;
import java.lang.reflect.Type;

/* compiled from: JsonSerializer.java */
/* renamed from: b.i.d.m, reason: use source file name */
/* loaded from: classes3.dex */
public interface JsonSerializer2<T> {
    JsonElement serialize(T t, Type type, JsonSerializationContext jsonSerializationContext);
}
