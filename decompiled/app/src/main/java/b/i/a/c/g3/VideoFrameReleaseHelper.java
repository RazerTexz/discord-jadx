package b.i.a.c.g3;

import android.content.Context;
import android.hardware.display.DisplayManager;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.view.Choreographer;
import android.view.Surface;
import android.view.WindowManager;
import androidx.annotation.DoNotInline;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import b.i.a.c.f3.Log2;
import b.i.a.c.f3.Util2;
import java.util.Objects;

/* compiled from: VideoFrameReleaseHelper.java */
/* renamed from: b.i.a.c.g3.v, reason: use source file name */
/* loaded from: classes3.dex */
public final class VideoFrameReleaseHelper {
    public final FixedFrameRateEstimator a = new FixedFrameRateEstimator();

    /* renamed from: b, reason: collision with root package name */
    @Nullable
    public final b f993b;

    @Nullable
    public final e c;
    public boolean d;

    @Nullable
    public Surface e;
    public float f;
    public float g;
    public float h;
    public float i;
    public int j;
    public long k;
    public long l;
    public long m;
    public long n;
    public long o;
    public long p;
    public long q;

    /* compiled from: VideoFrameReleaseHelper.java */
    @RequiresApi(30)
    /* renamed from: b.i.a.c.g3.v$a */
    public static final class a {
        @DoNotInline
        public static void a(Surface surface, float f) {
            try {
                surface.setFrameRate(f, f == 0.0f ? 0 : 1);
            } catch (IllegalStateException e) {
                Log2.b("VideoFrameReleaseHelper", "Failed to call Surface.setFrameRate", e);
            }
        }
    }

    /* compiled from: VideoFrameReleaseHelper.java */
    /* renamed from: b.i.a.c.g3.v$b */
    public interface b {

        /* compiled from: VideoFrameReleaseHelper.java */
        /* renamed from: b.i.a.c.g3.v$b$a */
        public interface a {
        }

        void a(a aVar);

        void unregister();
    }

    /* compiled from: VideoFrameReleaseHelper.java */
    /* renamed from: b.i.a.c.g3.v$c */
    public static final class c implements b {
        public final WindowManager a;

        public c(WindowManager windowManager) {
            this.a = windowManager;
        }

        @Override // b.i.a.c.g3.VideoFrameReleaseHelper.b
        public void a(b.a aVar) {
            ((b.i.a.c.g3.b) aVar).a(this.a.getDefaultDisplay());
        }

        @Override // b.i.a.c.g3.VideoFrameReleaseHelper.b
        public void unregister() {
        }
    }

    /* compiled from: VideoFrameReleaseHelper.java */
    @RequiresApi(17)
    /* renamed from: b.i.a.c.g3.v$d */
    public static final class d implements b, DisplayManager.DisplayListener {
        public final DisplayManager a;

        /* renamed from: b, reason: collision with root package name */
        @Nullable
        public b.a f994b;

        public d(DisplayManager displayManager) {
            this.a = displayManager;
        }

        @Override // b.i.a.c.g3.VideoFrameReleaseHelper.b
        public void a(b.a aVar) {
            this.f994b = aVar;
            this.a.registerDisplayListener(this, Util2.j());
            ((b.i.a.c.g3.b) aVar).a(this.a.getDisplay(0));
        }

        @Override // android.hardware.display.DisplayManager.DisplayListener
        public void onDisplayAdded(int i) {
        }

        @Override // android.hardware.display.DisplayManager.DisplayListener
        public void onDisplayChanged(int i) {
            b.a aVar = this.f994b;
            if (aVar == null || i != 0) {
                return;
            }
            ((b.i.a.c.g3.b) aVar).a(this.a.getDisplay(0));
        }

        @Override // android.hardware.display.DisplayManager.DisplayListener
        public void onDisplayRemoved(int i) {
        }

        @Override // b.i.a.c.g3.VideoFrameReleaseHelper.b
        public void unregister() {
            this.a.unregisterDisplayListener(this);
            this.f994b = null;
        }
    }

    /* compiled from: VideoFrameReleaseHelper.java */
    /* renamed from: b.i.a.c.g3.v$e */
    public static final class e implements Choreographer.FrameCallback, Handler.Callback {
        public static final e j = new e();
        public volatile long k = -9223372036854775807L;
        public final Handler l;
        public final HandlerThread m;
        public Choreographer n;
        public int o;

        public e() {
            HandlerThread handlerThread = new HandlerThread("ExoPlayer:FrameReleaseChoreographer");
            this.m = handlerThread;
            handlerThread.start();
            Looper looper = handlerThread.getLooper();
            int i = Util2.a;
            Handler handler = new Handler(looper, this);
            this.l = handler;
            handler.sendEmptyMessage(0);
        }

        @Override // android.view.Choreographer.FrameCallback
        public void doFrame(long j2) {
            this.k = j2;
            Choreographer choreographer = this.n;
            Objects.requireNonNull(choreographer);
            choreographer.postFrameCallbackDelayed(this, 500L);
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            int i = message.what;
            if (i == 0) {
                this.n = Choreographer.getInstance();
                return true;
            }
            if (i == 1) {
                int i2 = this.o + 1;
                this.o = i2;
                if (i2 == 1) {
                    Choreographer choreographer = this.n;
                    Objects.requireNonNull(choreographer);
                    choreographer.postFrameCallback(this);
                }
                return true;
            }
            if (i != 2) {
                return false;
            }
            int i3 = this.o - 1;
            this.o = i3;
            if (i3 == 0) {
                Choreographer choreographer2 = this.n;
                Objects.requireNonNull(choreographer2);
                choreographer2.removeFrameCallback(this);
                this.k = -9223372036854775807L;
            }
            return true;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x003b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public VideoFrameReleaseHelper(@Nullable Context context) {
        b dVar;
        DisplayManager displayManager;
        if (context != null) {
            Context applicationContext = context.getApplicationContext();
            dVar = (Util2.a < 17 || (displayManager = (DisplayManager) applicationContext.getSystemService("display")) == null) ? null : new d(displayManager);
            if (dVar == null) {
                WindowManager windowManager = (WindowManager) applicationContext.getSystemService("window");
                dVar = windowManager != null ? new c(windowManager) : null;
            }
        }
        this.f993b = dVar;
        this.c = dVar != null ? e.j : null;
        this.k = -9223372036854775807L;
        this.l = -9223372036854775807L;
        this.f = -1.0f;
        this.i = 1.0f;
        this.j = 0;
    }

    public final void a() {
        Surface surface;
        if (Util2.a < 30 || (surface = this.e) == null || this.j == Integer.MIN_VALUE || this.h == 0.0f) {
            return;
        }
        this.h = 0.0f;
        a.a(surface, 0.0f);
    }

    public final void b() {
        this.m = 0L;
        this.p = -1L;
        this.n = -1L;
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0086  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void c() {
        float f;
        if (Util2.a < 30 || this.e == null) {
            return;
        }
        if (this.a.a()) {
            FixedFrameRateEstimator fixedFrameRateEstimator = this.a;
            if (fixedFrameRateEstimator.a()) {
                f = (float) (1.0E9d / (fixedFrameRateEstimator.a.e != 0 ? r0.f / r5 : 0L));
            } else {
                f = -1.0f;
            }
        } else {
            f = this.f;
        }
        float f2 = this.g;
        if (f == f2) {
            return;
        }
        boolean z2 = true;
        if (f == -1.0f || f2 == -1.0f) {
            if (f == -1.0f && this.a.e < 30) {
                z2 = false;
            }
        } else if (this.a.a()) {
            FixedFrameRateEstimator fixedFrameRateEstimator2 = this.a;
            boolean z3 = (fixedFrameRateEstimator2.a() ? fixedFrameRateEstimator2.a.f : -9223372036854775807L) >= 5000000000L;
            if (Math.abs(f - this.g) < (z3 ? 0.02f : 1.0f)) {
            }
        }
        if (z2) {
            this.g = f;
            d(false);
        }
    }

    public final void d(boolean z2) {
        Surface surface;
        if (Util2.a < 30 || (surface = this.e) == null || this.j == Integer.MIN_VALUE) {
            return;
        }
        float f = 0.0f;
        if (this.d) {
            float f2 = this.g;
            if (f2 != -1.0f) {
                f = this.i * f2;
            }
        }
        if (z2 || this.h != f) {
            this.h = f;
            a.a(surface, f);
        }
    }
}
