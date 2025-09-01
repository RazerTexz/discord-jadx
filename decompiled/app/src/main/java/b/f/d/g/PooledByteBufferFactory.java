package b.f.d.g;

import com.facebook.common.memory.PooledByteBuffer;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: PooledByteBufferFactory.java */
/* renamed from: b.f.d.g.g, reason: use source file name */
/* loaded from: classes.dex */
public interface PooledByteBufferFactory {
    PooledByteBufferOutputStream a();

    PooledByteBuffer b(byte[] bArr);

    PooledByteBuffer c(InputStream inputStream) throws IOException;

    PooledByteBuffer d(InputStream inputStream, int i) throws IOException;

    PooledByteBufferOutputStream e(int i);
}
