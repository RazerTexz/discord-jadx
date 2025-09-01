package b.i.a.c;

import android.content.Context;
import android.os.Looper;
import b.i.a.c.a3.MediaSourceFactory;
import b.i.a.c.c3.TrackSelector;
import b.i.a.c.e3.BandwidthMeter;
import b.i.a.c.f3.Clock4;
import b.i.a.c.f3.Util2;
import b.i.a.c.s2.AnalyticsCollector;
import b.i.a.c.t2.AudioAttributes;
import b.i.b.a.Supplier2;

/* compiled from: ExoPlayer.java */
/* renamed from: b.i.a.c.e1, reason: use source file name */
/* loaded from: classes3.dex */
public interface ExoPlayer2 extends Player2 {

    /* compiled from: ExoPlayer.java */
    /* renamed from: b.i.a.c.e1$a */
    public interface a {
        void o(boolean z2);

        void x(boolean z2);
    }

    /* compiled from: ExoPlayer.java */
    /* renamed from: b.i.a.c.e1$b */
    public static final class b {
        public final Context a;

        /* renamed from: b, reason: collision with root package name */
        public Clock4 f923b;
        public Supplier2<RenderersFactory> c;
        public Supplier2<MediaSourceFactory> d;
        public Supplier2<TrackSelector> e;
        public Supplier2<LoadControl> f;
        public Supplier2<BandwidthMeter> g;
        public Supplier2<AnalyticsCollector> h;
        public Looper i;
        public AudioAttributes j;
        public int k;
        public boolean l;
        public SeekParameters m;
        public long n;
        public long o;
        public LivePlaybackSpeedControl p;
        public long q;
        public long r;

        /* renamed from: s, reason: collision with root package name */
        public boolean f924s;

        public b(Context context) {
            f fVar = new f(context);
            h hVar = new h(context);
            g gVar = new g(context);
            b.i.a.c.a aVar = b.i.a.c.a.j;
            e eVar = new e(context);
            this.a = context;
            this.c = fVar;
            this.d = hVar;
            this.e = gVar;
            this.f = aVar;
            this.g = eVar;
            this.h = new i(this);
            this.i = Util2.o();
            this.j = AudioAttributes.j;
            this.k = 1;
            this.l = true;
            this.m = SeekParameters.f1026b;
            this.n = 5000L;
            this.o = 15000L;
            this.p = new DefaultLivePlaybackSpeedControl(0.97f, 1.03f, 1000L, 1.0E-7f, Util2.B(20L), Util2.B(500L), 0.999f, null);
            this.f923b = Clock4.a;
            this.q = 500L;
            this.r = 2000L;
        }
    }
}
