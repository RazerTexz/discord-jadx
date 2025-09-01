package g0;

import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;

/* compiled from: Sink.kt */
/* renamed from: g0.v, reason: use source file name */
/* loaded from: classes3.dex */
public interface Sink extends Closeable, Flushable {
    @Override // java.io.Closeable, java.lang.AutoCloseable
    void close() throws IOException;

    void flush() throws IOException;

    Timeout2 timeout();

    void write(Buffer3 buffer3, long j) throws IOException;
}
