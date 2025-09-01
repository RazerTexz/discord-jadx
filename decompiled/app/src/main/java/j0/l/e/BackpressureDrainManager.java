package j0.l.e;

import androidx.recyclerview.widget.RecyclerView;
import j0.l.a.NotificationLite;
import j0.l.a.OperatorOnBackpressureBuffer;
import java.util.concurrent.atomic.AtomicLong;
import rx.Producer;

/* compiled from: BackpressureDrainManager.java */
/* renamed from: j0.l.e.c, reason: use source file name */
/* loaded from: classes3.dex */
public final class BackpressureDrainManager extends AtomicLong implements Producer {
    private static final long serialVersionUID = 2826241102729529449L;
    public final a actual;
    public boolean emitting;
    public Throwable exception;
    public volatile boolean terminated;

    /* compiled from: BackpressureDrainManager.java */
    /* renamed from: j0.l.e.c$a */
    public interface a {
    }

    public BackpressureDrainManager(a aVar) {
        this.actual = aVar;
    }

    /* JADX WARN: Code restructure failed: missing block: B:110:?, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x002a, code lost:
    
        r1 = r14.exception;
        r5 = (j0.l.a.OperatorOnBackpressureBuffer.a) r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x002e, code lost:
    
        if (r1 == null) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0030, code lost:
    
        r5.l.onError(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0036, code lost:
    
        r5.l.onCompleted();
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x003b, code lost:
    
        return;
     */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0043 A[Catch: all -> 0x00bc, TRY_ENTER, TryCatch #5 {all -> 0x00bc, blocks: (B:10:0x0012, B:32:0x0057, B:16:0x001f, B:27:0x0043, B:30:0x0052, B:69:0x00a9), top: B:95:0x0012 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a() throws Throwable {
        Throwable th;
        BackpressureDrainManager backpressureDrainManager;
        a aVar;
        boolean z2;
        synchronized (this) {
            if (this.emitting) {
                return;
            }
            boolean z3 = true;
            this.emitting = true;
            boolean z4 = this.terminated;
            long j = get();
            try {
                aVar = this.actual;
            } catch (Throwable th2) {
                th = th2;
                backpressureDrainManager = this;
                z3 = false;
            }
            loop0: while (true) {
                int i = 0;
                while (true) {
                    if (j <= 0 && !z4) {
                        break;
                    }
                    if (!z4) {
                        OperatorOnBackpressureBuffer.a aVar2 = (OperatorOnBackpressureBuffer.a) aVar;
                        Object objPoll = aVar2.j.poll();
                        AtomicLong atomicLong = aVar2.k;
                        if (atomicLong != null && objPoll != null) {
                            atomicLong.incrementAndGet();
                        }
                        if (objPoll == null) {
                            break;
                        }
                        if (NotificationLite.a(((OperatorOnBackpressureBuffer.a) aVar).l, objPoll)) {
                            return;
                        }
                        j--;
                        i++;
                    } else if (((OperatorOnBackpressureBuffer.a) aVar).j.peek() == null) {
                        try {
                            break loop0;
                        } catch (Throwable th3) {
                            th = th3;
                            backpressureDrainManager = this;
                        }
                    } else if (j == 0) {
                        break;
                    }
                    if (z3) {
                        throw th;
                    }
                    synchronized (backpressureDrainManager) {
                        backpressureDrainManager.emitting = false;
                    }
                    throw th;
                }
                synchronized (this) {
                    try {
                        z4 = this.terminated;
                        boolean z5 = ((OperatorOnBackpressureBuffer.a) aVar).j.peek() != null;
                        try {
                            if (get() != RecyclerView.FOREVER_NS) {
                                long jAddAndGet = addAndGet(-i);
                                if ((jAddAndGet == 0 || !z5) && (!z4 || z5)) {
                                    break;
                                } else {
                                    j = jAddAndGet;
                                }
                            } else {
                                if (!z5 && !z4) {
                                    this.emitting = false;
                                    return;
                                }
                                j = Long.MAX_VALUE;
                            }
                        } catch (Throwable th4) {
                            backpressureDrainManager = this;
                            th = th4;
                            z2 = true;
                            while (true) {
                                try {
                                    try {
                                        break;
                                    } catch (Throwable th5) {
                                        boolean z6 = z2;
                                        th = th5;
                                        z3 = z6;
                                    }
                                } catch (Throwable th6) {
                                    th = th6;
                                }
                            }
                            throw th;
                        }
                    } catch (Throwable th7) {
                        th = th7;
                        z2 = false;
                        backpressureDrainManager = this;
                    }
                }
            }
            this.emitting = false;
        }
    }

    @Override // rx.Producer
    public void j(long j) throws Throwable {
        boolean z2;
        if (j == 0) {
            return;
        }
        while (true) {
            long j2 = get();
            boolean z3 = true;
            z2 = j2 == 0;
            long j3 = RecyclerView.FOREVER_NS;
            if (j2 == RecyclerView.FOREVER_NS) {
                break;
            }
            if (j == RecyclerView.FOREVER_NS) {
                j3 = j;
            } else {
                if (j2 <= RecyclerView.FOREVER_NS - j) {
                    j3 = j2 + j;
                }
                z3 = z2;
            }
            if (compareAndSet(j2, j3)) {
                z2 = z3;
                break;
            }
        }
        if (z2) {
            a();
        }
    }
}
