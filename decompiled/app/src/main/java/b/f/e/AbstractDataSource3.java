package b.f.e;

import android.util.Pair;
import com.facebook.datasource.DataSource;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executor;

/* compiled from: AbstractDataSource.java */
/* renamed from: b.f.e.c, reason: use source file name */
/* loaded from: classes.dex */
public abstract class AbstractDataSource3<T> implements DataSource<T> {
    public Map<String, Object> a;
    public T d = null;
    public Throwable e = null;
    public float f = 0.0f;
    public boolean c = false;

    /* renamed from: b, reason: collision with root package name */
    public int f475b = 1;
    public final ConcurrentLinkedQueue<Pair<DataSubscriber<T>, Executor>> g = new ConcurrentLinkedQueue<>();

    @Override // com.facebook.datasource.DataSource
    public Map<String, Object> a() {
        return this.a;
    }

    @Override // com.facebook.datasource.DataSource
    public synchronized boolean b() {
        return this.d != null;
    }

    @Override // com.facebook.datasource.DataSource
    public synchronized boolean c() {
        return this.f475b != 1;
    }

    @Override // com.facebook.datasource.DataSource
    public boolean close() {
        synchronized (this) {
            if (this.c) {
                return false;
            }
            this.c = true;
            T t = this.d;
            this.d = null;
            if (t != null) {
                g(t);
            }
            if (!c()) {
                j();
            }
            synchronized (this) {
                this.g.clear();
            }
            return true;
        }
    }

    @Override // com.facebook.datasource.DataSource
    public synchronized Throwable d() {
        return this.e;
    }

    @Override // com.facebook.datasource.DataSource
    public boolean e() {
        return false;
    }

    @Override // com.facebook.datasource.DataSource
    public void f(DataSubscriber<T> dataSubscriber, Executor executor) {
        Objects.requireNonNull(executor);
        synchronized (this) {
            if (this.c) {
                return;
            }
            boolean z2 = true;
            if (this.f475b == 1) {
                this.g.add(Pair.create(dataSubscriber, executor));
            }
            if (!b() && !c() && !n()) {
                z2 = false;
            }
            if (z2) {
                executor.execute(new AbstractDataSource(this, h(), dataSubscriber, n()));
            }
        }
    }

    public void g(T t) {
    }

    @Override // com.facebook.datasource.DataSource
    public synchronized float getProgress() {
        return this.f;
    }

    @Override // com.facebook.datasource.DataSource
    public synchronized T getResult() {
        return this.d;
    }

    public synchronized boolean h() {
        return this.f475b == 3;
    }

    public synchronized boolean i() {
        return this.c;
    }

    public final void j() {
        boolean zH = h();
        boolean zN = n();
        Iterator<Pair<DataSubscriber<T>, Executor>> it = this.g.iterator();
        while (it.hasNext()) {
            Pair<DataSubscriber<T>, Executor> next = it.next();
            ((Executor) next.second).execute(new AbstractDataSource(this, zH, (DataSubscriber) next.first, zN));
        }
    }

    public boolean k(Throwable th, Map<String, Object> map) {
        boolean z2;
        synchronized (this) {
            z2 = true;
            if (this.c || this.f475b != 1) {
                z2 = false;
            } else {
                this.f475b = 3;
                this.e = th;
                this.a = map;
            }
        }
        if (z2) {
            j();
        }
        return z2;
    }

    public boolean l(float f) {
        boolean z2;
        synchronized (this) {
            z2 = false;
            if (!this.c && this.f475b == 1 && f >= this.f) {
                this.f = f;
                z2 = true;
            }
        }
        if (z2) {
            Iterator<Pair<DataSubscriber<T>, Executor>> it = this.g.iterator();
            while (it.hasNext()) {
                Pair<DataSubscriber<T>, Executor> next = it.next();
                ((Executor) next.second).execute(new AbstractDataSource2(this, (DataSubscriber) next.first));
            }
        }
        return z2;
    }

    public boolean m(T t, boolean z2, Map<String, Object> map) throws Throwable {
        T t2;
        this.a = map;
        T t3 = null;
        try {
            synchronized (this) {
                try {
                    boolean z3 = true;
                    try {
                        if (this.c || this.f475b != 1) {
                            z3 = false;
                            if (t != null) {
                                g(t);
                            }
                        } else {
                            if (z2) {
                                this.f475b = 2;
                                this.f = 1.0f;
                            }
                            t2 = this.d;
                            if (t2 != t) {
                                try {
                                    this.d = t;
                                    t = t2;
                                } catch (Throwable th) {
                                    th = th;
                                    t3 = t2;
                                    T t4 = t3;
                                    while (true) {
                                        try {
                                            try {
                                                throw th;
                                            } catch (Throwable th2) {
                                                th = th2;
                                                t3 = t4;
                                                if (t3 != null) {
                                                    g(t3);
                                                }
                                                throw th;
                                            }
                                        } catch (Throwable th3) {
                                            th = th3;
                                        }
                                    }
                                }
                            } else {
                                t = null;
                            }
                            if (t != null) {
                                g(t);
                            }
                        }
                        if (z3) {
                            j();
                        }
                        return z3;
                    } catch (Throwable th4) {
                        t2 = t;
                        th = th4;
                    }
                } catch (Throwable th5) {
                    th = th5;
                }
            }
        } catch (Throwable th6) {
            th = th6;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x000f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final synchronized boolean n() {
        boolean z2;
        if (i()) {
            z2 = !c();
        }
        return z2;
    }
}
