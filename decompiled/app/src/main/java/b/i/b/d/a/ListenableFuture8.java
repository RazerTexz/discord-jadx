package b.i.b.d.a;

import java.util.concurrent.Executor;
import java.util.concurrent.Future;

/* compiled from: ListenableFuture.java */
/* renamed from: b.i.b.d.a.a, reason: use source file name */
/* loaded from: classes3.dex */
public interface ListenableFuture8<V> extends Future<V> {
    void addListener(Runnable runnable, Executor executor);
}
