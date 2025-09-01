package b.f.d.b;

import android.os.Handler;
import android.os.Looper;

/* compiled from: UiThreadImmediateExecutorService.java */
/* renamed from: b.f.d.b.g, reason: use source file name */
/* loaded from: classes.dex */
public class UiThreadImmediateExecutorService extends HandlerExecutorServiceImpl {
    public static UiThreadImmediateExecutorService k;

    public UiThreadImmediateExecutorService() {
        super(new Handler(Looper.getMainLooper()));
    }

    @Override // b.f.d.b.HandlerExecutorServiceImpl, java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        if (Thread.currentThread() == this.j.getLooper().getThread()) {
            runnable.run();
        } else {
            this.j.post(runnable);
        }
    }
}
