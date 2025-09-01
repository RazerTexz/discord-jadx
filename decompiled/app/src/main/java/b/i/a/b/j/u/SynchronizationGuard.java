package b.i.a.b.j.u;

import androidx.annotation.WorkerThread;

/* compiled from: SynchronizationGuard.java */
@WorkerThread
/* renamed from: b.i.a.b.j.u.a, reason: use source file name */
/* loaded from: classes3.dex */
public interface SynchronizationGuard {

    /* compiled from: SynchronizationGuard.java */
    /* renamed from: b.i.a.b.j.u.a$a */
    public interface a<T> {
        T execute();
    }

    <T> T a(a<T> aVar);
}
