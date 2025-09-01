package b.g.a.b.t;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: ThreadLocalBufferManager.java */
/* renamed from: b.g.a.b.t.l, reason: use source file name */
/* loaded from: classes3.dex */
public class ThreadLocalBufferManager {
    public final Map<SoftReference<BufferRecycler>, Boolean> a = new ConcurrentHashMap();

    /* renamed from: b, reason: collision with root package name */
    public final ReferenceQueue<BufferRecycler> f679b = new ReferenceQueue<>();

    /* compiled from: ThreadLocalBufferManager.java */
    /* renamed from: b.g.a.b.t.l$a */
    public static final class a {
        public static final ThreadLocalBufferManager a = new ThreadLocalBufferManager();
    }
}
