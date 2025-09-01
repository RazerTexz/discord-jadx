package b.g.a.c.g0.u;

import b.g.a.b.JsonGenerator;
import b.g.a.b.JsonParser;
import b.g.a.c.SerializerProvider;
import b.g.a.c.y.JacksonStdImpl;
import java.io.IOException;

/* compiled from: NumberSerializers.java */
@JacksonStdImpl
/* renamed from: b.g.a.c.g0.u.y, reason: use source file name */
/* loaded from: classes3.dex */
public class NumberSerializers6 extends NumberSerializers4<Object> {
    public static final NumberSerializers6 k = new NumberSerializers6();

    public NumberSerializers6() {
        super(Float.class, JsonParser.b.FLOAT, "number");
    }

    @Override // b.g.a.c.JsonSerializer
    public void f(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.D(((Float) obj).floatValue());
    }
}
