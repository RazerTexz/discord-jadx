package b.g.a.c.g0.u;

import b.g.a.b.JsonGenerator;
import b.g.a.c.SerializerProvider;
import java.io.IOException;

/* compiled from: StdKeySerializer.java */
@Deprecated
/* renamed from: b.g.a.c.g0.u.n0, reason: use source file name */
/* loaded from: classes3.dex */
public class StdKeySerializer extends StdSerializer<Object> {
    public StdKeySerializer() {
        super(Object.class);
    }

    @Override // b.g.a.c.JsonSerializer
    public void f(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.y(obj.toString());
    }
}
