package com.adjust.sdk.scheduler;

import com.adjust.sdk.AdjustFactory;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public class SingleThreadCachedScheduler implements ThreadScheduler {
    private ThreadPoolExecutor threadPoolExecutor;
    private final List<Runnable> queue = new ArrayList();
    private boolean isThreadProcessing = false;
    private boolean isTeardown = false;

    /* renamed from: com.adjust.sdk.scheduler.SingleThreadCachedScheduler$1, reason: invalid class name */
    public class AnonymousClass1 implements RejectedExecutionHandler {
        public final /* synthetic */ String val$source;

        public AnonymousClass1(String str) {
            this.val$source = str;
        }

        @Override // java.util.concurrent.RejectedExecutionHandler
        public void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
            AdjustFactory.getLogger().warn("Runnable [%s] rejected from [%s] ", runnable.toString(), this.val$source);
        }
    }

    /* renamed from: com.adjust.sdk.scheduler.SingleThreadCachedScheduler$2, reason: invalid class name */
    public class AnonymousClass2 implements Runnable {
        public final /* synthetic */ long val$millisecondsDelay;
        public final /* synthetic */ Runnable val$task;

        public AnonymousClass2(long j, Runnable runnable) {
            this.val$millisecondsDelay = j;
            this.val$task = runnable;
        }

        @Override // java.lang.Runnable
        public void run() throws InterruptedException {
            try {
                Thread.sleep(this.val$millisecondsDelay);
            } catch (InterruptedException e) {
                AdjustFactory.getLogger().warn("Sleep delay exception: %s", e.getMessage());
            }
            SingleThreadCachedScheduler.this.submit(this.val$task);
        }
    }

    /* renamed from: com.adjust.sdk.scheduler.SingleThreadCachedScheduler$3, reason: invalid class name */
    public class AnonymousClass3 implements Runnable {
        public final /* synthetic */ Runnable val$firstRunnable;

        public AnonymousClass3(Runnable runnable) {
            this.val$firstRunnable = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            Runnable runnable;
            SingleThreadCachedScheduler.access$000(SingleThreadCachedScheduler.this, this.val$firstRunnable);
            while (true) {
                synchronized (SingleThreadCachedScheduler.access$100(SingleThreadCachedScheduler.this)) {
                    if (SingleThreadCachedScheduler.access$200(SingleThreadCachedScheduler.this)) {
                        return;
                    }
                    if (SingleThreadCachedScheduler.access$100(SingleThreadCachedScheduler.this).isEmpty()) {
                        SingleThreadCachedScheduler.access$302(SingleThreadCachedScheduler.this, false);
                        return;
                    } else {
                        runnable = (Runnable) SingleThreadCachedScheduler.access$100(SingleThreadCachedScheduler.this).get(0);
                        SingleThreadCachedScheduler.access$100(SingleThreadCachedScheduler.this).remove(0);
                    }
                }
                SingleThreadCachedScheduler.access$000(SingleThreadCachedScheduler.this, runnable);
            }
        }
    }

    public SingleThreadCachedScheduler(String str) {
        this.threadPoolExecutor = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60L, TimeUnit.SECONDS, new SynchronousQueue(), new ThreadFactoryWrapper(str), new AnonymousClass1(str));
    }

    public static /* synthetic */ void access$000(SingleThreadCachedScheduler singleThreadCachedScheduler, Runnable runnable) {
        singleThreadCachedScheduler.tryExecuteRunnable(runnable);
    }

    public static /* synthetic */ List access$100(SingleThreadCachedScheduler singleThreadCachedScheduler) {
        return singleThreadCachedScheduler.queue;
    }

    public static /* synthetic */ boolean access$200(SingleThreadCachedScheduler singleThreadCachedScheduler) {
        return singleThreadCachedScheduler.isTeardown;
    }

    public static /* synthetic */ boolean access$302(SingleThreadCachedScheduler singleThreadCachedScheduler, boolean z2) {
        singleThreadCachedScheduler.isThreadProcessing = z2;
        return z2;
    }

    private void processQueue(Runnable runnable) {
        this.threadPoolExecutor.submit(new AnonymousClass3(runnable));
    }

    private void tryExecuteRunnable(Runnable runnable) {
        try {
            if (this.isTeardown) {
                return;
            }
            runnable.run();
        } catch (Throwable th) {
            AdjustFactory.getLogger().warn("Execution failed: %s", th.getMessage());
        }
    }

    @Override // com.adjust.sdk.scheduler.ThreadScheduler
    public void schedule(Runnable runnable, long j) {
        synchronized (this.queue) {
            if (this.isTeardown) {
                return;
            }
            this.threadPoolExecutor.submit(new AnonymousClass2(j, runnable));
        }
    }

    @Override // com.adjust.sdk.scheduler.ThreadExecutor
    public void submit(Runnable runnable) {
        synchronized (this.queue) {
            if (this.isTeardown) {
                return;
            }
            if (this.isThreadProcessing) {
                this.queue.add(runnable);
            } else {
                this.isThreadProcessing = true;
                processQueue(runnable);
            }
        }
    }

    @Override // com.adjust.sdk.scheduler.ThreadExecutor
    public void teardown() {
        synchronized (this.queue) {
            this.isTeardown = true;
            this.queue.clear();
            this.threadPoolExecutor.shutdown();
        }
    }
}
