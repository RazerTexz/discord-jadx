package b.i.d;

import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import java.lang.reflect.Type;

/* compiled from: JsonDeserializer.java */
/* renamed from: b.i.d.i, reason: use source file name */
/* loaded from: classes3.dex */
public interface JsonDeserializer2<T> {
    T a(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException;
}
