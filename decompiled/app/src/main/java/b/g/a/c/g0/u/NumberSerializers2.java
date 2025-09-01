package b.g.a.c.g0.u;

import b.g.a.b.JsonGenerator;
import b.g.a.b.JsonParser;
import b.g.a.c.SerializerProvider;
import b.g.a.c.y.JacksonStdImpl;
import java.io.IOException;

/* compiled from: NumberSerializers.java */
@JacksonStdImpl
/* renamed from: b.g.a.c.g0.u.b0, reason: use source file name */
/* loaded from: classes3.dex */
public class NumberSerializers2 extends NumberSerializers4<Object> {
    public NumberSerializers2(Class<?> cls) {
        super(cls, JsonParser.b.LONG, "number");
    }

    @Override // b.g.a.c.JsonSerializer
    public void f(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.I(((Long) obj).longValue());
    }
}
