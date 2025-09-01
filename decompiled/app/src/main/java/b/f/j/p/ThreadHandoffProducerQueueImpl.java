package b.f.j.p;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Objects;
import java.util.concurrent.Executor;

/* compiled from: ThreadHandoffProducerQueueImpl.java */
/* renamed from: b.f.j.p.h1, reason: use source file name */
/* loaded from: classes3.dex */
public class ThreadHandoffProducerQueueImpl implements ThreadHandoffProducerQueue {
    public final Deque<Runnable> a;

    /* renamed from: b, reason: collision with root package name */
    public final Executor f614b;

    public ThreadHandoffProducerQueueImpl(Executor executor) {
        Objects.requireNonNull(executor);
        this.f614b = executor;
        this.a = new ArrayDeque();
    }
}
