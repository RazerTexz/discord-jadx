package b.i.c.u.p;

import androidx.annotation.GuardedBy;
import b.i.c.u.Utils6;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

/* compiled from: RequestLimiter.java */
/* renamed from: b.i.c.u.p.e, reason: use source file name */
/* loaded from: classes3.dex */
public class RequestLimiter {
    public static final long a = TimeUnit.HOURS.toMillis(24);

    /* renamed from: b, reason: collision with root package name */
    public static final long f1792b = TimeUnit.MINUTES.toMillis(30);
    public final Utils6 c = Utils6.c();

    @GuardedBy("this")
    public long d;

    @GuardedBy("this")
    public int e;

    /* JADX WARN: Removed duplicated region for block: B:10:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized boolean a() {
        boolean z2;
        if (this.e != 0) {
            z2 = this.c.a() > this.d;
        }
        return z2;
    }

    public synchronized void b(int i) {
        long jMin;
        boolean z2 = false;
        if ((i >= 200 && i < 300) || i == 401 || i == 404) {
            synchronized (this) {
                this.e = 0;
            }
            return;
        }
        this.e++;
        synchronized (this) {
            if (i == 429 || (i >= 500 && i < 600)) {
                z2 = true;
            }
            if (z2) {
                double dPow = Math.pow(2.0d, this.e);
                Objects.requireNonNull(this.c);
                jMin = (long) Math.min(dPow + ((long) (Math.random() * 1000.0d)), f1792b);
            } else {
                jMin = a;
            }
            this.d = this.c.a() + jMin;
        }
        return;
    }
}
