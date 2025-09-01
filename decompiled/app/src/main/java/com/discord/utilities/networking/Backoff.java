package com.discord.utilities.networking;

import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ExecutorService;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: Backoff.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0002!\"B9\u0012\b\b\u0002\u0010\u001b\u001a\u00020\f\u0012\b\b\u0002\u0010\u0019\u001a\u00020\f\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u001c¢\u0006\u0004\b\u001f\u0010 J\u001d\u0010\u0005\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\r\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\r\u0010\n\u001a\u00020\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u001f\u0010\r\u001a\u00020\f2\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002¢\u0006\u0004\b\r\u0010\u000eJ\r\u0010\u000f\u001a\u00020\u0003¢\u0006\u0004\b\u000f\u0010\u000bR\u0016\u0010\u0011\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0012R\u0016\u0010\u0014\u001a\u00020\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R$\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u00078\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0017\u0010\tR\u0016\u0010\u0019\u001a\u00020\f8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u0015R\u0016\u0010\u001a\u001a\u00020\u00078\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u0018R\u0016\u0010\u001b\u001a\u00020\f8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u0015R\u0016\u0010\u001d\u001a\u00020\u001c8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001e¨\u0006#"}, d2 = {"Lcom/discord/utilities/networking/Backoff;", "", "Lkotlin/Function0;", "", "callback", "executeFailureCallback", "(Lkotlin/jvm/functions/Function0;)V", "", "hasReachedFailureThreshold", "()Z", "succeed", "()V", "", "fail", "(Lkotlin/jvm/functions/Function0;)J", "cancel", "", "fails", "I", "failureThreshold", "current", "J", "<set-?>", "isPending", "Z", "maxBackoffMs", "jitter", "minBackoffMs", "Lcom/discord/utilities/networking/Backoff$Scheduler;", "scheduler", "Lcom/discord/utilities/networking/Backoff$Scheduler;", "<init>", "(JJIZLcom/discord/utilities/networking/Backoff$Scheduler;)V", "Scheduler", "TimerScheduler", "utils_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class Backoff {
    private long current;
    private int fails;
    private final int failureThreshold;
    private boolean isPending;
    private final boolean jitter;
    private final long maxBackoffMs;
    private final long minBackoffMs;
    private final Scheduler scheduler;

    /* compiled from: Backoff.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J%\u0010\u0007\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0006\u001a\u00020\u0005H&¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0003H&¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/discord/utilities/networking/Backoff$Scheduler;", "", "Lkotlin/Function0;", "", "action", "", "delayMs", "schedule", "(Lkotlin/jvm/functions/Function0;J)V", "cancel", "()V", "utils_release"}, k = 1, mv = {1, 4, 2})
    public interface Scheduler {
        void cancel();

        void schedule(Function0<Unit> action, long delayMs);
    }

    /* compiled from: Backoff.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002B\u001d\u0012\b\b\u0002\u0010\r\u001a\u00020\f\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b\u0015\u0010\u0016J%\u0010\b\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\n\u0010\u000bR\u0016\u0010\r\u001a\u00020\f8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014¨\u0006\u0017"}, d2 = {"Lcom/discord/utilities/networking/Backoff$TimerScheduler;", "Lcom/discord/utilities/networking/Backoff$Scheduler;", "Ljava/util/Timer;", "Lkotlin/Function0;", "", "action", "", "delayMs", "schedule", "(Lkotlin/jvm/functions/Function0;J)V", "cancel", "()V", "", "tag", "Ljava/lang/String;", "Ljava/util/concurrent/ExecutorService;", "delegateExecutor", "Ljava/util/concurrent/ExecutorService;", "Ljava/util/TimerTask;", "timeoutTimerTask", "Ljava/util/TimerTask;", "<init>", "(Ljava/lang/String;Ljava/util/concurrent/ExecutorService;)V", "utils_release"}, k = 1, mv = {1, 4, 2})
    public static final class TimerScheduler extends Timer implements Scheduler {
        private final ExecutorService delegateExecutor;
        private final String tag;
        private TimerTask timeoutTimerTask;

        public TimerScheduler() {
            this(null, null, 3, null);
        }

        public /* synthetic */ TimerScheduler(String str, ExecutorService executorService, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? "TimerScheduler" : str, (i & 2) != 0 ? null : executorService);
        }

        public static final /* synthetic */ ExecutorService access$getDelegateExecutor$p(TimerScheduler timerScheduler) {
            return timerScheduler.delegateExecutor;
        }

        public static final /* synthetic */ String access$getTag$p(TimerScheduler timerScheduler) {
            return timerScheduler.tag;
        }

        @Override // java.util.Timer, com.discord.utilities.networking.Backoff.Scheduler
        public synchronized void cancel() {
            TimerTask timerTask = this.timeoutTimerTask;
            if (timerTask != null) {
                timerTask.cancel();
            }
        }

        @Override // com.discord.utilities.networking.Backoff.Scheduler
        public synchronized void schedule(Function0<Unit> action, long delayMs) {
            Intrinsics3.checkNotNullParameter(action, "action");
            TimerTask timerTask = this.timeoutTimerTask;
            if (timerTask != null) {
                timerTask.cancel();
            }
            Backoff2 backoff2 = new Backoff2(this, action);
            this.timeoutTimerTask = backoff2;
            schedule(backoff2, delayMs);
        }

        public TimerScheduler(String str, ExecutorService executorService) {
            Intrinsics3.checkNotNullParameter(str, "tag");
            this.tag = str;
            this.delegateExecutor = executorService;
        }
    }

    /* compiled from: Backoff.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.utilities.networking.Backoff$fail$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ Function0 $callback;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Function0 function0) {
            super(0);
            this.$callback = function0;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            Backoff.access$executeFailureCallback(Backoff.this, this.$callback);
        }
    }

    public Backoff() {
        this(0L, 0L, 0, false, null, 31, null);
    }

    public Backoff(long j, long j2, int i, boolean z2, Scheduler scheduler) {
        Intrinsics3.checkNotNullParameter(scheduler, "scheduler");
        this.minBackoffMs = j;
        this.maxBackoffMs = j2;
        this.failureThreshold = i;
        this.jitter = z2;
        this.scheduler = scheduler;
        this.current = j;
    }

    public static final /* synthetic */ void access$executeFailureCallback(Backoff backoff, Function0 function0) {
        backoff.executeFailureCallback(function0);
    }

    private final synchronized void executeFailureCallback(Function0<Unit> callback) {
        this.isPending = false;
        callback.invoke();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ long fail$default(Backoff backoff, Function0 function0, int i, Object obj) {
        if ((i & 1) != 0) {
            function0 = null;
        }
        return backoff.fail(function0);
    }

    public final synchronized void cancel() {
        this.scheduler.cancel();
        this.isPending = false;
    }

    public final synchronized long fail(Function0<Unit> callback) {
        this.fails++;
        double dRandom = this.jitter ? Math.random() : 1.0d;
        this.current = Math.min(this.current + ((long) (2 * r4 * dRandom)), this.maxBackoffMs);
        if (callback != null && !this.isPending) {
            this.isPending = true;
            this.scheduler.schedule(new AnonymousClass1(callback), this.current);
        }
        return this.current;
    }

    public final boolean hasReachedFailureThreshold() {
        return this.fails > this.failureThreshold;
    }

    /* renamed from: isPending, reason: from getter */
    public final boolean getIsPending() {
        return this.isPending;
    }

    public final synchronized void succeed() {
        cancel();
        this.fails = 0;
        this.current = this.minBackoffMs;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ Backoff(long j, long j2, int i, boolean z2, Scheduler scheduler, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        long j3 = (i2 & 1) != 0 ? 500L : j;
        this(j3, (i2 & 2) != 0 ? 10 * j3 : j2, (i2 & 4) != 0 ? Integer.MAX_VALUE : i, (i2 & 8) != 0 ? true : z2, (i2 & 16) != 0 ? new TimerScheduler(null, null, 3, null) : scheduler);
    }
}
