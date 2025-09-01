package b.o.a.r;

import android.os.Handler;
import android.os.HandlerThread;
import androidx.annotation.NonNull;
import b.o.a.CameraLogger;
import java.lang.ref.WeakReference;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;

/* compiled from: WorkerHandler.java */
/* renamed from: b.o.a.r.g, reason: use source file name */
/* loaded from: classes3.dex */
public class WorkerHandler {
    public static final CameraLogger a = new CameraLogger(WorkerHandler.class.getSimpleName());

    /* renamed from: b, reason: collision with root package name */
    public static final ConcurrentHashMap<String, WeakReference<WorkerHandler>> f1952b = new ConcurrentHashMap<>(4);
    public static WorkerHandler c;
    public String d;
    public HandlerThread e;
    public Handler f;
    public Executor g;

    /* compiled from: WorkerHandler.java */
    /* renamed from: b.o.a.r.g$a */
    public class a extends HandlerThread {
        public a(WorkerHandler workerHandler, String str) {
            super(str);
        }

        @Override // java.lang.Thread
        @NonNull
        public String toString() {
            return super.toString() + "[" + getThreadId() + "]";
        }
    }

    /* compiled from: WorkerHandler.java */
    /* renamed from: b.o.a.r.g$b */
    public class b implements Executor {
        public b() {
        }

        @Override // java.util.concurrent.Executor
        public void execute(@NonNull Runnable runnable) {
            WorkerHandler.this.c(runnable);
        }
    }

    /* compiled from: WorkerHandler.java */
    /* renamed from: b.o.a.r.g$c */
    public class c implements Runnable {
        public final /* synthetic */ CountDownLatch j;

        public c(WorkerHandler workerHandler, CountDownLatch countDownLatch) {
            this.j = countDownLatch;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.j.countDown();
        }
    }

    public WorkerHandler(@NonNull String str) throws InterruptedException {
        this.d = str;
        a aVar = new a(this, str);
        this.e = aVar;
        aVar.setDaemon(true);
        this.e.start();
        this.f = new Handler(this.e.getLooper());
        this.g = new b();
        CountDownLatch countDownLatch = new CountDownLatch(1);
        this.f.post(new c(this, countDownLatch));
        try {
            countDownLatch.await();
        } catch (InterruptedException unused) {
        }
    }

    public static void a(@NonNull Runnable runnable) {
        WorkerHandler workerHandlerB = b("FallbackCameraThread");
        c = workerHandlerB;
        workerHandlerB.f.post(runnable);
    }

    @NonNull
    public static WorkerHandler b(@NonNull String str) {
        ConcurrentHashMap<String, WeakReference<WorkerHandler>> concurrentHashMap = f1952b;
        if (concurrentHashMap.containsKey(str)) {
            WorkerHandler workerHandler = concurrentHashMap.get(str).get();
            if (workerHandler == null) {
                a.a(2, "get:", "Thread reference died. Removing.", str);
                concurrentHashMap.remove(str);
            } else {
                if (workerHandler.e.isAlive() && !workerHandler.e.isInterrupted()) {
                    a.a(2, "get:", "Reusing cached worker handler.", str);
                    return workerHandler;
                }
                HandlerThread handlerThread = workerHandler.e;
                if (handlerThread.isAlive()) {
                    handlerThread.interrupt();
                    handlerThread.quit();
                }
                concurrentHashMap.remove(workerHandler.d);
                a.a(2, "get:", "Thread reference found, but not alive or interrupted.", "Removing.", str);
                concurrentHashMap.remove(str);
            }
        }
        a.a(1, "get:", "Creating new handler.", str);
        WorkerHandler workerHandler2 = new WorkerHandler(str);
        concurrentHashMap.put(str, new WeakReference<>(workerHandler2));
        return workerHandler2;
    }

    public void c(@NonNull Runnable runnable) {
        if (Thread.currentThread() == this.e) {
            runnable.run();
        } else {
            this.f.post(runnable);
        }
    }
}
