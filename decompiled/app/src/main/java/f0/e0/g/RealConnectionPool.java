package f0.e0.g;

import androidx.core.app.NotificationCompat;
import b.d.b.a.outline;
import d0.z.d.Intrinsics3;
import f0.Address;
import f0.Route;
import f0.e0.Util7;
import f0.e0.f.Task2;
import f0.e0.f.TaskQueue2;
import f0.e0.f.TaskRunner;
import f0.e0.g.RealCall;
import f0.e0.k.Platform2;
import java.io.IOException;
import java.lang.ref.Reference;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.TimeUnit;

/* compiled from: RealConnectionPool.kt */
/* renamed from: f0.e0.g.k, reason: use source file name */
/* loaded from: classes3.dex */
public final class RealConnectionPool {
    public final long a;

    /* renamed from: b, reason: collision with root package name */
    public final TaskQueue2 f3621b;
    public final a c;
    public final ConcurrentLinkedQueue<RealConnection4> d;
    public final int e;

    /* compiled from: RealConnectionPool.kt */
    /* renamed from: f0.e0.g.k$a */
    public static final class a extends Task2 {
        public a(String str) {
            super(str, true);
        }

        @Override // f0.e0.f.Task2
        public long a() throws IOException {
            RealConnectionPool realConnectionPool = RealConnectionPool.this;
            long jNanoTime = System.nanoTime();
            Iterator<RealConnection4> it = realConnectionPool.d.iterator();
            RealConnection4 realConnection4 = null;
            long j = Long.MIN_VALUE;
            int i = 0;
            int i2 = 0;
            while (it.hasNext()) {
                RealConnection4 next = it.next();
                Intrinsics3.checkExpressionValueIsNotNull(next, "connection");
                synchronized (next) {
                    if (realConnectionPool.b(next, jNanoTime) > 0) {
                        i2++;
                    } else {
                        i++;
                        long j2 = jNanoTime - next.p;
                        if (j2 > j) {
                            realConnection4 = next;
                            j = j2;
                        }
                    }
                }
            }
            long j3 = realConnectionPool.a;
            if (j < j3 && i <= realConnectionPool.e) {
                if (i > 0) {
                    return j3 - j;
                }
                if (i2 > 0) {
                    return j3;
                }
                return -1L;
            }
            if (realConnection4 == null) {
                Intrinsics3.throwNpe();
            }
            synchronized (realConnection4) {
                if (!realConnection4.o.isEmpty()) {
                    return 0L;
                }
                if (realConnection4.p + j != jNanoTime) {
                    return 0L;
                }
                realConnection4.i = true;
                realConnectionPool.d.remove(realConnection4);
                Util7.e(realConnection4.n());
                if (!realConnectionPool.d.isEmpty()) {
                    return 0L;
                }
                realConnectionPool.f3621b.a();
                return 0L;
            }
        }
    }

    public RealConnectionPool(TaskRunner taskRunner, int i, long j, TimeUnit timeUnit) {
        Intrinsics3.checkParameterIsNotNull(taskRunner, "taskRunner");
        Intrinsics3.checkParameterIsNotNull(timeUnit, "timeUnit");
        this.e = i;
        this.a = timeUnit.toNanos(j);
        this.f3621b = taskRunner.f();
        this.c = new a(outline.J(new StringBuilder(), Util7.g, " ConnectionPool"));
        this.d = new ConcurrentLinkedQueue<>();
        if (!(j > 0)) {
            throw new IllegalArgumentException(outline.t("keepAliveDuration <= 0: ", j).toString());
        }
    }

    public final boolean a(Address address, RealCall realCall, List<Route> list, boolean z2) {
        Intrinsics3.checkParameterIsNotNull(address, "address");
        Intrinsics3.checkParameterIsNotNull(realCall, NotificationCompat.CATEGORY_CALL);
        Iterator<RealConnection4> it = this.d.iterator();
        while (it.hasNext()) {
            RealConnection4 next = it.next();
            Intrinsics3.checkExpressionValueIsNotNull(next, "connection");
            synchronized (next) {
                if (z2) {
                    if (!next.j()) {
                    }
                }
                if (next.h(address, list)) {
                    realCall.f(next);
                    return true;
                }
            }
        }
        return false;
    }

    public final int b(RealConnection4 realConnection4, long j) {
        byte[] bArr = Util7.a;
        List<Reference<RealCall>> list = realConnection4.o;
        int i = 0;
        while (i < list.size()) {
            Reference<RealCall> reference = list.get(i);
            if (reference.get() != null) {
                i++;
            } else {
                StringBuilder sbU = outline.U("A connection to ");
                sbU.append(realConnection4.q.a.a);
                sbU.append(" was leaked. ");
                sbU.append("Did you forget to close a response body?");
                String string = sbU.toString();
                Platform2.a aVar = Platform2.c;
                Platform2.a.k(string, ((RealCall.b) reference).a);
                list.remove(i);
                realConnection4.i = true;
                if (list.isEmpty()) {
                    realConnection4.p = j - this.a;
                    return 0;
                }
            }
        }
        return list.size();
    }
}
