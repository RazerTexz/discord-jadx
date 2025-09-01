package com.facebook.imagepipeline.memory;

import b.f.d.d.DoNotStrip;
import b.f.d.g.MemoryTrimmableRegistry;
import b.f.j.l.MemoryChunk;
import b.f.j.l.MemoryChunkPool;
import b.f.j.l.PoolParams;
import b.f.j.l.PoolStatsTracker;

@DoNotStrip
/* loaded from: classes3.dex */
public class NativeMemoryChunkPool extends MemoryChunkPool {
    @DoNotStrip
    public NativeMemoryChunkPool(MemoryTrimmableRegistry memoryTrimmableRegistry, PoolParams poolParams, PoolStatsTracker poolStatsTracker) {
        super(memoryTrimmableRegistry, poolParams, poolStatsTracker);
    }

    @Override // b.f.j.l.MemoryChunkPool, com.facebook.imagepipeline.memory.BasePool
    public MemoryChunk e(int i) {
        return new NativeMemoryChunk(i);
    }

    @Override // b.f.j.l.MemoryChunkPool
    public MemoryChunk s(int i) {
        return new NativeMemoryChunk(i);
    }
}
