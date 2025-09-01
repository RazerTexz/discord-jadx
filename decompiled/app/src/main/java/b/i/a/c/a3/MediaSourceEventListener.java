package b.i.a.c.a3;

import android.os.Handler;
import androidx.annotation.CheckResult;
import androidx.annotation.Nullable;
import b.i.a.c.a3.MediaSource2;
import b.i.a.c.f3.Util2;
import java.io.IOException;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: MediaSourceEventListener.java */
/* renamed from: b.i.a.c.a3.b0, reason: use source file name */
/* loaded from: classes3.dex */
public interface MediaSourceEventListener {
    void X(int i, @Nullable MediaSource2.a aVar, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData);

    void g0(int i, @Nullable MediaSource2.a aVar, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData, IOException iOException, boolean z2);

    void o(int i, @Nullable MediaSource2.a aVar, MediaLoadData mediaLoadData);

    void q(int i, @Nullable MediaSource2.a aVar, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData);

    void x(int i, @Nullable MediaSource2.a aVar, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData);

    /* compiled from: MediaSourceEventListener.java */
    /* renamed from: b.i.a.c.a3.b0$a */
    public static class a {
        public final int a;

        /* renamed from: b, reason: collision with root package name */
        @Nullable
        public final MediaSource2.a f807b;
        public final CopyOnWriteArrayList<C0027a> c;
        public final long d;

        /* compiled from: MediaSourceEventListener.java */
        /* renamed from: b.i.a.c.a3.b0$a$a, reason: collision with other inner class name */
        public static final class C0027a {
            public Handler a;

            /* renamed from: b, reason: collision with root package name */
            public MediaSourceEventListener f808b;

            public C0027a(Handler handler, MediaSourceEventListener mediaSourceEventListener) {
                this.a = handler;
                this.f808b = mediaSourceEventListener;
            }
        }

        public a() {
            this.c = new CopyOnWriteArrayList<>();
            this.a = 0;
            this.f807b = null;
            this.d = 0L;
        }

        public final long a(long j) {
            long jM = Util2.M(j);
            if (jM == -9223372036854775807L) {
                return -9223372036854775807L;
            }
            return this.d + jM;
        }

        public void b(MediaLoadData mediaLoadData) {
            Iterator<C0027a> it = this.c.iterator();
            while (it.hasNext()) {
                C0027a next = it.next();
                Util2.E(next.a, new d(this, next.f808b, mediaLoadData));
            }
        }

        public void c(LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
            Iterator<C0027a> it = this.c.iterator();
            while (it.hasNext()) {
                C0027a next = it.next();
                Util2.E(next.a, new f(this, next.f808b, loadEventInfo, mediaLoadData));
            }
        }

        public void d(LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
            Iterator<C0027a> it = this.c.iterator();
            while (it.hasNext()) {
                C0027a next = it.next();
                Util2.E(next.a, new c(this, next.f808b, loadEventInfo, mediaLoadData));
            }
        }

        public void e(LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData, IOException iOException, boolean z2) {
            Iterator<C0027a> it = this.c.iterator();
            while (it.hasNext()) {
                C0027a next = it.next();
                Util2.E(next.a, new b(this, next.f808b, loadEventInfo, mediaLoadData, iOException, z2));
            }
        }

        public void f(LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
            Iterator<C0027a> it = this.c.iterator();
            while (it.hasNext()) {
                C0027a next = it.next();
                Util2.E(next.a, new e(this, next.f808b, loadEventInfo, mediaLoadData));
            }
        }

        @CheckResult
        public a g(int i, @Nullable MediaSource2.a aVar, long j) {
            return new a(this.c, i, aVar, j);
        }

        public a(CopyOnWriteArrayList<C0027a> copyOnWriteArrayList, int i, @Nullable MediaSource2.a aVar, long j) {
            this.c = copyOnWriteArrayList;
            this.a = i;
            this.f807b = aVar;
            this.d = j;
        }
    }
}
