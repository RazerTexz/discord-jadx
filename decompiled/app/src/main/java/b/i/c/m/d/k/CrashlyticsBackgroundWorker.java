package b.i.c.m.d.k;

import com.google.android.gms.tasks.Task;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;

/* compiled from: CrashlyticsBackgroundWorker.java */
/* renamed from: b.i.c.m.d.k.i, reason: use source file name */
/* loaded from: classes3.dex */
public class CrashlyticsBackgroundWorker {
    public final Executor a;

    /* renamed from: b, reason: collision with root package name */
    public Task<Void> f1688b = b.i.a.f.e.o.f.Z(null);
    public final Object c = new Object();
    public ThreadLocal<Boolean> d = new ThreadLocal<>();

    /* compiled from: CrashlyticsBackgroundWorker.java */
    /* renamed from: b.i.c.m.d.k.i$a */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            CrashlyticsBackgroundWorker.this.d.set(Boolean.TRUE);
        }
    }

    public CrashlyticsBackgroundWorker(Executor executor) {
        this.a = executor;
        executor.execute(new a());
    }

    public void a() {
        if (!Boolean.TRUE.equals(this.d.get())) {
            throw new IllegalStateException("Not running on background worker thread as intended.");
        }
    }

    public <T> Task<T> b(Callable<T> callable) {
        Task<T> task;
        synchronized (this.c) {
            task = (Task<T>) this.f1688b.i(this.a, new CrashlyticsBackgroundWorker3(this, callable));
            this.f1688b = task.i(this.a, new CrashlyticsBackgroundWorker4(this));
        }
        return task;
    }

    public <T> Task<T> c(Callable<Task<T>> callable) {
        Task<T> task;
        synchronized (this.c) {
            task = (Task<T>) this.f1688b.j(this.a, new CrashlyticsBackgroundWorker3(this, callable));
            this.f1688b = task.i(this.a, new CrashlyticsBackgroundWorker4(this));
        }
        return task;
    }
}
