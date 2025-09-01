package b.g.a.c;

import b.g.a.b.JsonGenerator;
import b.g.a.c.e0.TypeSerializer;
import java.io.IOException;

/* compiled from: JsonSerializable.java */
/* renamed from: b.g.a.c.m, reason: use source file name */
/* loaded from: classes3.dex */
public interface JsonSerializable {

    /* compiled from: JsonSerializable.java */
    /* renamed from: b.g.a.c.m$a */
    public static abstract class a implements JsonSerializable {
    }

    void c(JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException;

    void d(JsonGenerator jsonGenerator, SerializerProvider serializerProvider, TypeSerializer typeSerializer) throws IOException;
}
