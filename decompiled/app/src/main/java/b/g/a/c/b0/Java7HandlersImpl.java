package b.g.a.c.b0;

import b.g.a.c.JsonSerializer;
import java.nio.file.Path;

/* compiled from: Java7HandlersImpl.java */
/* renamed from: b.g.a.c.b0.b, reason: use source file name */
/* loaded from: classes3.dex */
public class Java7HandlersImpl extends Java7Handlers {

    /* renamed from: b, reason: collision with root package name */
    public final Class<?> f680b = Path.class;

    @Override // b.g.a.c.b0.Java7Handlers
    public JsonSerializer<?> a(Class<?> cls) {
        if (this.f680b.isAssignableFrom(cls)) {
            return new NioPathSerializer();
        }
        return null;
    }
}
