package j0.l.c;

import java.util.concurrent.ThreadFactory;
import rx.Scheduler;

/* compiled from: NewThreadScheduler.java */
/* renamed from: j0.l.c.f, reason: use source file name */
/* loaded from: classes3.dex */
public final class NewThreadScheduler extends Scheduler {
    public final ThreadFactory a;

    public NewThreadScheduler(ThreadFactory threadFactory) {
        this.a = threadFactory;
    }

    @Override // rx.Scheduler
    public Scheduler.Worker a() {
        return new NewThreadWorker(this.a);
    }
}
