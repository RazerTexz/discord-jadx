package b.i.a.c.w2;

import android.os.Handler;
import androidx.annotation.CheckResult;
import androidx.annotation.Nullable;
import b.i.a.c.a3.MediaSource2;
import b.i.a.c.f3.Util2;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: DrmSessionEventListener.java */
/* renamed from: b.i.a.c.w2.s, reason: use source file name */
/* loaded from: classes3.dex */
public interface DrmSessionEventListener {
    void J(int i, @Nullable MediaSource2.a aVar);

    void S(int i, @Nullable MediaSource2.a aVar);

    void c0(int i, @Nullable MediaSource2.a aVar, int i2);

    void d0(int i, @Nullable MediaSource2.a aVar);

    void i0(int i, @Nullable MediaSource2.a aVar);

    void u(int i, @Nullable MediaSource2.a aVar, Exception exc);

    /* compiled from: DrmSessionEventListener.java */
    /* renamed from: b.i.a.c.w2.s$a */
    public static class a {
        public final int a;

        /* renamed from: b, reason: collision with root package name */
        @Nullable
        public final MediaSource2.a f1156b;
        public final CopyOnWriteArrayList<C0031a> c;

        /* compiled from: DrmSessionEventListener.java */
        /* renamed from: b.i.a.c.w2.s$a$a, reason: collision with other inner class name */
        public static final class C0031a {
            public Handler a;

            /* renamed from: b, reason: collision with root package name */
            public DrmSessionEventListener f1157b;

            public C0031a(Handler handler, DrmSessionEventListener drmSessionEventListener) {
                this.a = handler;
                this.f1157b = drmSessionEventListener;
            }
        }

        public a() {
            this.c = new CopyOnWriteArrayList<>();
            this.a = 0;
            this.f1156b = null;
        }

        public void a() {
            Iterator<C0031a> it = this.c.iterator();
            while (it.hasNext()) {
                C0031a next = it.next();
                Util2.E(next.a, new i(this, next.f1157b));
            }
        }

        public void b() {
            Iterator<C0031a> it = this.c.iterator();
            while (it.hasNext()) {
                C0031a next = it.next();
                Util2.E(next.a, new h(this, next.f1157b));
            }
        }

        public void c() {
            Iterator<C0031a> it = this.c.iterator();
            while (it.hasNext()) {
                C0031a next = it.next();
                Util2.E(next.a, new j(this, next.f1157b));
            }
        }

        public void d(int i) {
            Iterator<C0031a> it = this.c.iterator();
            while (it.hasNext()) {
                C0031a next = it.next();
                Util2.E(next.a, new l(this, next.f1157b, i));
            }
        }

        public void e(Exception exc) {
            Iterator<C0031a> it = this.c.iterator();
            while (it.hasNext()) {
                C0031a next = it.next();
                Util2.E(next.a, new k(this, next.f1157b, exc));
            }
        }

        public void f() {
            Iterator<C0031a> it = this.c.iterator();
            while (it.hasNext()) {
                C0031a next = it.next();
                Util2.E(next.a, new g(this, next.f1157b));
            }
        }

        @CheckResult
        public a g(int i, @Nullable MediaSource2.a aVar) {
            return new a(this.c, i, aVar);
        }

        public a(CopyOnWriteArrayList<C0031a> copyOnWriteArrayList, int i, @Nullable MediaSource2.a aVar) {
            this.c = copyOnWriteArrayList;
            this.a = i;
            this.f1156b = aVar;
        }
    }
}
