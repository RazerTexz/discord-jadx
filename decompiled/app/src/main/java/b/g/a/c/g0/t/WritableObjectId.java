package b.g.a.c.g0.t;

import b.g.a.a.ObjectIdGenerator;
import b.g.a.b.JsonGenerator;
import b.g.a.c.SerializerProvider;
import java.io.IOException;
import java.util.Objects;

/* compiled from: WritableObjectId.java */
/* renamed from: b.g.a.c.g0.t.u, reason: use source file name */
/* loaded from: classes3.dex */
public final class WritableObjectId {
    public final ObjectIdGenerator<?> a;

    /* renamed from: b, reason: collision with root package name */
    public Object f713b;
    public boolean c = false;

    public WritableObjectId(ObjectIdGenerator<?> objectIdGenerator) {
        this.a = objectIdGenerator;
    }

    public boolean a(JsonGenerator jsonGenerator, SerializerProvider serializerProvider, ObjectIdWriter objectIdWriter) throws IOException {
        if (this.f713b == null) {
            return false;
        }
        if (!this.c && !objectIdWriter.e) {
            return false;
        }
        Objects.requireNonNull(jsonGenerator);
        objectIdWriter.d.f(this.f713b, jsonGenerator, serializerProvider);
        return true;
    }
}
