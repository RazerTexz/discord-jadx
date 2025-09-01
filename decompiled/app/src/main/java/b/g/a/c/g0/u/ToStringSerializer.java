package b.g.a.c.g0.u;

import b.g.a.c.y.JacksonStdImpl;

/* compiled from: ToStringSerializer.java */
@JacksonStdImpl
/* renamed from: b.g.a.c.g0.u.t0, reason: use source file name */
/* loaded from: classes3.dex */
public class ToStringSerializer extends ToStringSerializerBase {
    public static final ToStringSerializer k = new ToStringSerializer();

    public ToStringSerializer() {
        super(Object.class);
    }

    @Override // b.g.a.c.g0.u.ToStringSerializerBase
    public final String p(Object obj) {
        return obj.toString();
    }

    public ToStringSerializer(Class<?> cls) {
        super(cls);
    }
}
