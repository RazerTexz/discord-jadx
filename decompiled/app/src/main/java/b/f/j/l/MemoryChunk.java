package b.f.j.l;

import java.nio.ByteBuffer;

/* compiled from: MemoryChunk.java */
/* renamed from: b.f.j.l.r, reason: use source file name */
/* loaded from: classes3.dex */
public interface MemoryChunk {
    void a(int i, MemoryChunk memoryChunk, int i2, int i3);

    int b(int i, byte[] bArr, int i2, int i3);

    void close();

    ByteBuffer getByteBuffer();

    int getSize();

    long getUniqueId();

    byte h(int i);

    int i(int i, byte[] bArr, int i2, int i3);

    boolean isClosed();

    long k() throws UnsupportedOperationException;
}
