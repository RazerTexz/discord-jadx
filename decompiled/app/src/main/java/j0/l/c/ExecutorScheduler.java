package j0.l.c;

import j0.r.BooleanSubscription;
import j0.r.MultipleAssignmentSubscription;
import j0.r.Subscriptions;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import rx.Scheduler;
import rx.Subscription;
import rx.functions.Action0;
import rx.subscriptions.CompositeSubscription;

/* compiled from: ExecutorScheduler.java */
/* renamed from: j0.l.c.c, reason: use source file name */
/* loaded from: classes3.dex */
public final class ExecutorScheduler extends Scheduler {
    public final Executor a;

    /* compiled from: ExecutorScheduler.java */
    /* renamed from: j0.l.c.c$a */
    public static final class a extends Scheduler.Worker implements Runnable {
        public final Executor j;
        public final ScheduledExecutorService n;
        public final ConcurrentLinkedQueue<ScheduledAction> l = new ConcurrentLinkedQueue<>();
        public final AtomicInteger m = new AtomicInteger();
        public final CompositeSubscription k = new CompositeSubscription();

        /* compiled from: ExecutorScheduler.java */
        /* renamed from: j0.l.c.c$a$a, reason: collision with other inner class name */
        public class C0431a implements Action0 {
            public final /* synthetic */ MultipleAssignmentSubscription j;

            public C0431a(MultipleAssignmentSubscription multipleAssignmentSubscription) {
                this.j = multipleAssignmentSubscription;
            }

            @Override // rx.functions.Action0
            public void call() {
                a.this.k.c(this.j);
            }
        }

        /* compiled from: ExecutorScheduler.java */
        /* renamed from: j0.l.c.c$a$b */
        public class b implements Action0 {
            public final /* synthetic */ MultipleAssignmentSubscription j;
            public final /* synthetic */ Action0 k;
            public final /* synthetic */ Subscription l;

            public b(MultipleAssignmentSubscription multipleAssignmentSubscription, Action0 action0, Subscription subscription) {
                this.j = multipleAssignmentSubscription;
                this.k = action0;
                this.l = subscription;
            }

            @Override // rx.functions.Action0
            public void call() {
                if (this.j.isUnsubscribed()) {
                    return;
                }
                Subscription subscriptionA = a.this.a(this.k);
                this.j.a(subscriptionA);
                if (subscriptionA.getClass() == ScheduledAction.class) {
                    ((ScheduledAction) subscriptionA).cancel.a(this.l);
                }
            }
        }

        public a(Executor executor) {
            ScheduledExecutorService scheduledExecutorService;
            this.j = executor;
            ScheduledExecutorService[] scheduledExecutorServiceArr = GenericScheduledExecutorService.c.e.get();
            if (scheduledExecutorServiceArr == GenericScheduledExecutorService.a) {
                scheduledExecutorService = GenericScheduledExecutorService.f3789b;
            } else {
                int i = GenericScheduledExecutorService.d + 1;
                i = i >= scheduledExecutorServiceArr.length ? 0 : i;
                GenericScheduledExecutorService.d = i;
                scheduledExecutorService = scheduledExecutorServiceArr[i];
            }
            this.n = scheduledExecutorService;
        }

        @Override // rx.Scheduler.Worker
        public Subscription a(Action0 action0) {
            if (this.k.k) {
                return Subscriptions.a;
            }
            ScheduledAction scheduledAction = new ScheduledAction(j0.o.l.d(action0), this.k);
            this.k.a(scheduledAction);
            this.l.offer(scheduledAction);
            if (this.m.getAndIncrement() == 0) {
                try {
                    this.j.execute(this);
                } catch (RejectedExecutionException e) {
                    this.k.c(scheduledAction);
                    this.m.decrementAndGet();
                    j0.o.l.b(e);
                    throw e;
                }
            }
            return scheduledAction;
        }

        @Override // rx.Scheduler.Worker
        public Subscription b(Action0 action0, long j, TimeUnit timeUnit) {
            if (j <= 0) {
                return a(action0);
            }
            if (this.k.k) {
                return Subscriptions.a;
            }
            Action0 action0D = j0.o.l.d(action0);
            MultipleAssignmentSubscription multipleAssignmentSubscription = new MultipleAssignmentSubscription();
            MultipleAssignmentSubscription multipleAssignmentSubscription2 = new MultipleAssignmentSubscription();
            multipleAssignmentSubscription2.a(multipleAssignmentSubscription);
            this.k.a(multipleAssignmentSubscription2);
            BooleanSubscription booleanSubscription = new BooleanSubscription(new C0431a(multipleAssignmentSubscription2));
            ScheduledAction scheduledAction = new ScheduledAction(new b(multipleAssignmentSubscription2, action0D, booleanSubscription));
            multipleAssignmentSubscription.a(scheduledAction);
            try {
                scheduledAction.a(this.n.schedule(scheduledAction, j, timeUnit));
                return booleanSubscription;
            } catch (RejectedExecutionException e) {
                j0.o.l.b(e);
                throw e;
            }
        }

        @Override // rx.Subscription
        public boolean isUnsubscribed() {
            return this.k.k;
        }

        @Override // java.lang.Runnable
        public void run() {
            while (!this.k.k) {
                ScheduledAction scheduledActionPoll = this.l.poll();
                if (scheduledActionPoll == null) {
                    return;
                }
                if (!scheduledActionPoll.cancel.k) {
                    if (this.k.k) {
                        this.l.clear();
                        return;
                    }
                    scheduledActionPoll.run();
                }
                if (this.m.decrementAndGet() == 0) {
                    return;
                }
            }
            this.l.clear();
        }

        @Override // rx.Subscription
        public void unsubscribe() {
            this.k.unsubscribe();
            this.l.clear();
        }
    }

    public ExecutorScheduler(Executor executor) {
        this.a = executor;
    }

    @Override // rx.Scheduler
    public Scheduler.Worker a() {
        return new a(this.a);
    }
}
