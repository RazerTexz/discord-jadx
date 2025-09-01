package b.i.a.c.e3;

import android.os.Handler;
import androidx.annotation.Nullable;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: BandwidthMeter.java */
/* renamed from: b.i.a.c.e3.f, reason: use source file name */
/* loaded from: classes3.dex */
public interface BandwidthMeter {

    /* compiled from: BandwidthMeter.java */
    /* renamed from: b.i.a.c.e3.f$a */
    public interface a {

        /* compiled from: BandwidthMeter.java */
        /* renamed from: b.i.a.c.e3.f$a$a, reason: collision with other inner class name */
        public static final class C0029a {
            public final CopyOnWriteArrayList<C0030a> a = new CopyOnWriteArrayList<>();

            /* compiled from: BandwidthMeter.java */
            /* renamed from: b.i.a.c.e3.f$a$a$a, reason: collision with other inner class name */
            public static final class C0030a {
                public final Handler a;

                /* renamed from: b, reason: collision with root package name */
                public final a f940b;
                public boolean c;

                public C0030a(Handler handler, a aVar) {
                    this.a = handler;
                    this.f940b = aVar;
                }
            }

            public void a(a aVar) {
                Iterator<C0030a> it = this.a.iterator();
                while (it.hasNext()) {
                    C0030a next = it.next();
                    if (next.f940b == aVar) {
                        next.c = true;
                        this.a.remove(next);
                    }
                }
            }
        }
    }

    @Nullable
    TransferListener c();

    void d(a aVar);

    void f(Handler handler, a aVar);
}
