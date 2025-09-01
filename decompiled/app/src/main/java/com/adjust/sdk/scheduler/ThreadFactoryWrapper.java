package com.adjust.sdk.scheduler;

import b.d.b.a.outline;
import com.adjust.sdk.AdjustFactory;
import com.adjust.sdk.Constants;
import java.lang.Thread;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/* loaded from: classes.dex */
public class ThreadFactoryWrapper implements ThreadFactory {
    private String source;

    /* renamed from: com.adjust.sdk.scheduler.ThreadFactoryWrapper$1, reason: invalid class name */
    public class AnonymousClass1 implements Thread.UncaughtExceptionHandler {
        public AnonymousClass1() {
        }

        @Override // java.lang.Thread.UncaughtExceptionHandler
        public void uncaughtException(Thread thread, Throwable th) {
            AdjustFactory.getLogger().error("Thread [%s] with error [%s]", thread.getName(), th.getMessage());
        }
    }

    public ThreadFactoryWrapper(String str) {
        this.source = str;
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        Thread threadNewThread = Executors.defaultThreadFactory().newThread(runnable);
        threadNewThread.setPriority(9);
        StringBuilder sbU = outline.U(Constants.THREAD_PREFIX);
        sbU.append(threadNewThread.getName());
        sbU.append("-");
        sbU.append(this.source);
        threadNewThread.setName(sbU.toString());
        threadNewThread.setDaemon(true);
        threadNewThread.setUncaughtExceptionHandler(new AnonymousClass1());
        return threadNewThread;
    }
}
