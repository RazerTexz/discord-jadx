package b.i.a.b.j;

import java.io.Closeable;
import java.io.IOException;

/* compiled from: TransportRuntimeComponent.java */
/* renamed from: b.i.a.b.j.o, reason: use source file name */
/* loaded from: classes3.dex */
public abstract class TransportRuntimeComponent implements Closeable {
    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        ((DaggerTransportRuntimeComponent) this).o.get().close();
    }
}
