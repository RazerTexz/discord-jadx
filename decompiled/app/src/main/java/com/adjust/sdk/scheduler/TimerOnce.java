package com.adjust.sdk.scheduler;

import com.adjust.sdk.AdjustFactory;
import com.adjust.sdk.ILogger;
import com.adjust.sdk.Util;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public class TimerOnce {
    private Runnable command;
    private ILogger logger = AdjustFactory.getLogger();
    private String name;
    private FutureScheduler scheduler;
    private ScheduledFuture waitingTask;

    /* renamed from: com.adjust.sdk.scheduler.TimerOnce$1, reason: invalid class name */
    public class AnonymousClass1 implements Runnable {
        public AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public void run() {
            TimerOnce.access$100(TimerOnce.this).verbose("%s fired", TimerOnce.access$000(TimerOnce.this));
            TimerOnce.access$200(TimerOnce.this).run();
            TimerOnce.access$302(TimerOnce.this, null);
        }
    }

    public TimerOnce(Runnable runnable, String str) {
        this.name = str;
        this.scheduler = new SingleThreadFutureScheduler(str, true);
        this.command = runnable;
    }

    public static /* synthetic */ String access$000(TimerOnce timerOnce) {
        return timerOnce.name;
    }

    public static /* synthetic */ ILogger access$100(TimerOnce timerOnce) {
        return timerOnce.logger;
    }

    public static /* synthetic */ Runnable access$200(TimerOnce timerOnce) {
        return timerOnce.command;
    }

    public static /* synthetic */ ScheduledFuture access$302(TimerOnce timerOnce, ScheduledFuture scheduledFuture) {
        timerOnce.waitingTask = scheduledFuture;
        return scheduledFuture;
    }

    private void cancel(boolean z2) {
        ScheduledFuture scheduledFuture = this.waitingTask;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(z2);
        }
        this.waitingTask = null;
        this.logger.verbose("%s canceled", this.name);
    }

    public long getFireIn() {
        ScheduledFuture scheduledFuture = this.waitingTask;
        if (scheduledFuture == null) {
            return 0L;
        }
        return scheduledFuture.getDelay(TimeUnit.MILLISECONDS);
    }

    public void startIn(long j) {
        cancel(false);
        this.logger.verbose("%s starting. Launching in %s seconds", this.name, Util.SecondsDisplayFormat.format(j / 1000.0d));
        this.waitingTask = this.scheduler.scheduleFuture(new AnonymousClass1(), j);
    }

    public void teardown() {
        cancel(true);
        FutureScheduler futureScheduler = this.scheduler;
        if (futureScheduler != null) {
            futureScheduler.teardown();
        }
        this.scheduler = null;
    }

    public void cancel() {
        cancel(false);
    }
}
