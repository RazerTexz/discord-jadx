package com.discord.utilities.rx;

import androidx.core.app.NotificationCompat;
import androidx.exifinterface.media.ExifInterface;
import b.i.a.f.e.o.f;
import d0.z.d.Intrinsics3;
import j0.l.a.OnSubscribeLift;
import j0.p.Schedulers2;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;
import rx.Scheduler;
import rx.Subscriber;
import rx.Subscription;
import rx.observers.SerializedSubscriber;

/* compiled from: OperatorBufferedDelay.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u001e*\u0004\b\u0000\u0010\u00012\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0003\u0012\u0004\u0012\u00028\u00000\u0002:\u0002\u001e\u001fB)\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0012\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\u0018\u001a\u00020\u0017¢\u0006\u0004\b\u001c\u0010\u001dJ-\u0010\u0006\u001a\n\u0012\u0006\b\u0000\u0012\u00028\u00000\u00042\u0014\u0010\u0005\u001a\u0010\u0012\f\b\u0000\u0012\b\u0012\u0004\u0012\u00028\u00000\u00030\u0004H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0019\u0010\t\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0019\u0010\u000e\u001a\u00020\r8\u0006@\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0019\u0010\u0013\u001a\u00020\u00128\u0006@\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u0019\u0010\u0018\u001a\u00020\u00178\u0006@\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b¨\u0006 "}, d2 = {"Lcom/discord/utilities/rx/OperatorBufferedDelay;", ExifInterface.GPS_DIRECTION_TRUE, "Lrx/Observable$b;", "", "Lrx/Subscriber;", "childSubscriber", NotificationCompat.CATEGORY_CALL, "(Lrx/Subscriber;)Lrx/Subscriber;", "", "size", "I", "getSize", "()I", "", "timeSpan", "J", "getTimeSpan", "()J", "Ljava/util/concurrent/TimeUnit;", "timeUnit", "Ljava/util/concurrent/TimeUnit;", "getTimeUnit", "()Ljava/util/concurrent/TimeUnit;", "Lrx/Scheduler;", "scheduler", "Lrx/Scheduler;", "getScheduler", "()Lrx/Scheduler;", "<init>", "(JLjava/util/concurrent/TimeUnit;ILrx/Scheduler;)V", "Companion", "ExactSubscriber", "utils_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class OperatorBufferedDelay<T> implements Observable.b<List<? extends T>, T> {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final Scheduler scheduler;
    private final int size;
    private final long timeSpan;
    private final TimeUnit timeUnit;

    /* compiled from: OperatorBufferedDelay.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000f\u0010\u0010JM\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\f0\u0003\"\u0004\b\u0001\u0010\u0002*\b\u0012\u0004\u0012\u00028\u00010\u00032\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u0011"}, d2 = {"Lcom/discord/utilities/rx/OperatorBufferedDelay$Companion;", "", ExifInterface.GPS_DIRECTION_TRUE, "Lrx/Observable;", "", "delay", "Ljava/util/concurrent/TimeUnit;", "timeUnit", "", "size", "Lrx/Scheduler;", "scheduler", "", "bufferedDelay", "(Lrx/Observable;JLjava/util/concurrent/TimeUnit;ILrx/Scheduler;)Lrx/Observable;", "<init>", "()V", "utils_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public static /* synthetic */ Observable bufferedDelay$default(Companion companion, Observable observable, long j, TimeUnit timeUnit, int i, Scheduler scheduler, int i2, Object obj) {
            if ((i2 & 2) != 0) {
                timeUnit = TimeUnit.MILLISECONDS;
            }
            TimeUnit timeUnit2 = timeUnit;
            if ((i2 & 8) != 0) {
                scheduler = Schedulers2.a();
                Intrinsics3.checkNotNullExpressionValue(scheduler, "Schedulers.computation()");
            }
            return companion.bufferedDelay(observable, j, timeUnit2, i, scheduler);
        }

        public final <T> Observable<List<T>> bufferedDelay(Observable<T> observable, long j, TimeUnit timeUnit, int i, Scheduler scheduler) {
            Intrinsics3.checkNotNullParameter(observable, "$this$bufferedDelay");
            Intrinsics3.checkNotNullParameter(timeUnit, "timeUnit");
            Intrinsics3.checkNotNullParameter(scheduler, "scheduler");
            Observable<List<T>> observableH0 = Observable.h0(new OnSubscribeLift(observable.j, new OperatorBufferedDelay(j, timeUnit, i, scheduler)));
            Intrinsics3.checkNotNullExpressionValue(observableH0, "this.lift(OperatorBuffer…meUnit, size, scheduler))");
            return observableH0;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: OperatorBufferedDelay.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0010\u0003\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\b\u0082\u0004\u0018\u0000*\u0004\b\u0001\u0010\u00012\b\u0012\u0004\u0012\u00028\u00010\u0002B#\u0012\u0012\u0010\"\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\r0\u0002\u0012\u0006\u0010\u001b\u001a\u00020\u001a¢\u0006\u0004\b&\u0010'J\u000f\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0004\u0010\u0005J!\u0010\b\u001a\u00020\u00032\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u0006H\u0002¢\u0006\u0004\b\b\u0010\tJ'\u0010\u000b\u001a\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u00062\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u0006H\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u001d\u0010\u000f\u001a\u00020\u00032\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00010\rH\u0002¢\u0006\u0004\b\u000f\u0010\tJ\u0017\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00028\u0001H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u0019\u0010\u0015\u001a\u00020\u00032\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0017\u0010\u0005R\u001e\u0010\u0018\u001a\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0019\u0010\u001b\u001a\u00020\u001a8\u0006@\u0006¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u0018\u0010 \u001a\u0004\u0018\u00010\u001f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b \u0010!R%\u0010\"\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\r0\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%¨\u0006("}, d2 = {"Lcom/discord/utilities/rx/OperatorBufferedDelay$ExactSubscriber;", ExifInterface.GPS_DIRECTION_TRUE, "Lrx/Subscriber;", "", "cancelBufferTimer", "()V", "", "newBufferValue", "tryEmit", "(Ljava/util/List;)V", "newValue", "getAndSetBuffer", "(Ljava/util/List;)Ljava/util/List;", "", "bufferedValues", "publish", "t", "onNext", "(Ljava/lang/Object;)V", "", "e", "onError", "(Ljava/lang/Throwable;)V", "onCompleted", "buffer", "Ljava/util/List;", "Lrx/Scheduler$Worker;", "inner", "Lrx/Scheduler$Worker;", "getInner", "()Lrx/Scheduler$Worker;", "Lrx/Subscription;", "ongoingBufferTimer", "Lrx/Subscription;", "child", "Lrx/Subscriber;", "getChild", "()Lrx/Subscriber;", "<init>", "(Lcom/discord/utilities/rx/OperatorBufferedDelay;Lrx/Subscriber;Lrx/Scheduler$Worker;)V", "utils_release"}, k = 1, mv = {1, 4, 2})
    public final class ExactSubscriber<T> extends Subscriber<T> {
        private List<T> buffer;
        private final Subscriber<List<T>> child;
        private final Scheduler.Worker inner;
        private Subscription ongoingBufferTimer;
        public final /* synthetic */ OperatorBufferedDelay this$0;

        public ExactSubscriber(OperatorBufferedDelay operatorBufferedDelay, Subscriber<List<T>> subscriber, Scheduler.Worker worker) {
            Intrinsics3.checkNotNullParameter(subscriber, "child");
            Intrinsics3.checkNotNullParameter(worker, "inner");
            this.this$0 = operatorBufferedDelay;
            this.child = subscriber;
            this.inner = worker;
            this.buffer = new ArrayList();
        }

        private final void cancelBufferTimer() {
            Subscription subscription = this.ongoingBufferTimer;
            if (subscription != null) {
                subscription.unsubscribe();
            }
            this.ongoingBufferTimer = null;
        }

        private final List<T> getAndSetBuffer(List<T> newValue) {
            List<T> list = this.buffer;
            this.buffer = newValue;
            return list;
        }

        private final void publish(List<? extends T> bufferedValues) {
            try {
                if (!bufferedValues.isEmpty()) {
                    this.child.onNext(bufferedValues);
                }
            } catch (Throwable th) {
                f.o1(th);
                onError(th);
            }
        }

        private final void tryEmit(List<T> newBufferValue) {
            synchronized (this) {
                cancelBufferTimer();
                if (this.buffer == null) {
                    return;
                }
                List<T> andSetBuffer = getAndSetBuffer(newBufferValue);
                if (andSetBuffer != null) {
                    publish(andSetBuffer);
                }
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void tryEmit$default(ExactSubscriber exactSubscriber, List list, int i, Object obj) {
            if ((i & 1) != 0) {
                list = new ArrayList();
            }
            exactSubscriber.tryEmit(list);
        }

        public final Subscriber<List<T>> getChild() {
            return this.child;
        }

        public final Scheduler.Worker getInner() {
            return this.inner;
        }

        @Override // j0.Observer2
        public void onCompleted() {
            this.inner.unsubscribe();
            tryEmit(null);
            this.child.onCompleted();
            unsubscribe();
        }

        @Override // j0.Observer2
        public void onError(Throwable e) {
            tryEmit(null);
            this.child.onError(e);
            unsubscribe();
        }

        @Override // j0.Observer2
        public void onNext(T t) {
            synchronized (this) {
                List<T> list = this.buffer;
                if (list != null) {
                    list.add(t);
                    if (list.size() < this.this$0.getSize()) {
                        if (this.ongoingBufferTimer == null) {
                            this.ongoingBufferTimer = this.inner.b(new OperatorBufferedDelay2(this, t), this.this$0.getTimeSpan(), this.this$0.getTimeUnit());
                        }
                    } else {
                        cancelBufferTimer();
                        List<T> andSetBuffer = getAndSetBuffer(new ArrayList());
                        if (andSetBuffer != null) {
                            publish(andSetBuffer);
                        }
                    }
                }
            }
        }
    }

    public OperatorBufferedDelay(long j, TimeUnit timeUnit, int i, Scheduler scheduler) {
        Intrinsics3.checkNotNullParameter(timeUnit, "timeUnit");
        Intrinsics3.checkNotNullParameter(scheduler, "scheduler");
        this.timeSpan = j;
        this.timeUnit = timeUnit;
        this.size = i;
        this.scheduler = scheduler;
    }

    @Override // j0.k.Func1
    public /* bridge */ /* synthetic */ Object call(Object obj) {
        return call((Subscriber) obj);
    }

    public final Scheduler getScheduler() {
        return this.scheduler;
    }

    public final int getSize() {
        return this.size;
    }

    public final long getTimeSpan() {
        return this.timeSpan;
    }

    public final TimeUnit getTimeUnit() {
        return this.timeUnit;
    }

    public /* synthetic */ OperatorBufferedDelay(long j, TimeUnit timeUnit, int i, Scheduler scheduler, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, (i2 & 2) != 0 ? TimeUnit.MILLISECONDS : timeUnit, i, scheduler);
    }

    public Subscriber<? super T> call(Subscriber<? super List<? extends T>> childSubscriber) {
        Intrinsics3.checkNotNullParameter(childSubscriber, "childSubscriber");
        Scheduler.Worker workerA = this.scheduler.a();
        SerializedSubscriber serializedSubscriber = new SerializedSubscriber(childSubscriber);
        Intrinsics3.checkNotNullExpressionValue(workerA, "inner");
        ExactSubscriber exactSubscriber = new ExactSubscriber(this, serializedSubscriber, workerA);
        exactSubscriber.add(workerA);
        childSubscriber.add(exactSubscriber);
        return exactSubscriber;
    }
}
