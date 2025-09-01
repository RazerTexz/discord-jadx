package b.f.j.c;

import com.facebook.common.memory.PooledByteBuffer;

/* compiled from: EncodedCountingMemoryCacheFactory.java */
/* renamed from: b.f.j.c.p, reason: use source file name */
/* loaded from: classes.dex */
public final class EncodedCountingMemoryCacheFactory implements ValueDescriptor<PooledByteBuffer> {
    @Override // b.f.j.c.ValueDescriptor
    public int a(PooledByteBuffer pooledByteBuffer) {
        return pooledByteBuffer.size();
    }
}
