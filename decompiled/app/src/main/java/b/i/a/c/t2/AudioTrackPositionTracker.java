package b.i.a.c.t2;

import android.media.AudioTrack;
import android.os.SystemClock;
import androidx.annotation.Nullable;
import b.i.a.c.f3.Util2;
import java.lang.reflect.Method;
import java.util.Objects;

/* compiled from: AudioTrackPositionTracker.java */
/* renamed from: b.i.a.c.t2.t, reason: use source file name */
/* loaded from: classes3.dex */
public final class AudioTrackPositionTracker {
    public long A;
    public long B;
    public long C;
    public boolean D;
    public long E;
    public long F;
    public final a a;

    /* renamed from: b, reason: collision with root package name */
    public final long[] f1129b;

    @Nullable
    public AudioTrack c;
    public int d;
    public int e;

    @Nullable
    public AudioTimestampPoller f;
    public int g;
    public boolean h;
    public long i;
    public float j;
    public boolean k;
    public long l;
    public long m;

    @Nullable
    public Method n;
    public long o;
    public boolean p;
    public boolean q;
    public long r;

    /* renamed from: s, reason: collision with root package name */
    public long f1130s;
    public long t;
    public long u;
    public int v;
    public int w;

    /* renamed from: x, reason: collision with root package name */
    public long f1131x;

    /* renamed from: y, reason: collision with root package name */
    public long f1132y;

    /* renamed from: z, reason: collision with root package name */
    public long f1133z;

    /* compiled from: AudioTrackPositionTracker.java */
    /* renamed from: b.i.a.c.t2.t$a */
    public interface a {
        void a(long j);

        void b(int i, long j);

        void c(long j);

        void d(long j, long j2, long j3, long j4);

        void e(long j, long j2, long j3, long j4);
    }

    public AudioTrackPositionTracker(a aVar) {
        this.a = aVar;
        if (Util2.a >= 18) {
            try {
                this.n = AudioTrack.class.getMethod("getLatency", null);
            } catch (NoSuchMethodException unused) {
            }
        }
        this.f1129b = new long[10];
    }

    public final long a(long j) {
        return (j * 1000000) / this.g;
    }

    public final long b() {
        AudioTrack audioTrack = this.c;
        Objects.requireNonNull(audioTrack);
        if (this.f1131x != -9223372036854775807L) {
            return Math.min(this.A, this.f1133z + ((((SystemClock.elapsedRealtime() * 1000) - this.f1131x) * this.g) / 1000000));
        }
        int playState = audioTrack.getPlayState();
        if (playState == 1) {
            return 0L;
        }
        long playbackHeadPosition = 4294967295L & audioTrack.getPlaybackHeadPosition();
        if (this.h) {
            if (playState == 2 && playbackHeadPosition == 0) {
                this.u = this.f1130s;
            }
            playbackHeadPosition += this.u;
        }
        if (Util2.a <= 29) {
            if (playbackHeadPosition == 0 && this.f1130s > 0 && playState == 3) {
                if (this.f1132y == -9223372036854775807L) {
                    this.f1132y = SystemClock.elapsedRealtime();
                }
                return this.f1130s;
            }
            this.f1132y = -9223372036854775807L;
        }
        if (this.f1130s > playbackHeadPosition) {
            this.t++;
        }
        this.f1130s = playbackHeadPosition;
        return playbackHeadPosition + (this.t << 32);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0026  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean c(long j) {
        if (j <= b()) {
            if (this.h) {
                AudioTrack audioTrack = this.c;
                Objects.requireNonNull(audioTrack);
                boolean z2 = audioTrack.getPlayState() == 2 && b() == 0;
                if (!z2) {
                    return false;
                }
            }
        }
        return true;
    }

    public void d() {
        this.l = 0L;
        this.w = 0;
        this.v = 0;
        this.m = 0L;
        this.C = 0L;
        this.F = 0L;
        this.k = false;
        this.c = null;
        this.f = null;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0029  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void e(AudioTrack audioTrack, boolean z2, int i, int i2, int i3) {
        this.c = audioTrack;
        this.d = i2;
        this.e = i3;
        this.f = new AudioTimestampPoller(audioTrack);
        this.g = audioTrack.getSampleRate();
        boolean z3 = true;
        if (z2) {
            if (!(Util2.a < 23 && (i == 5 || i == 6))) {
            }
        } else {
            z3 = false;
        }
        this.h = z3;
        boolean z4 = Util2.z(i);
        this.q = z4;
        this.i = z4 ? a(i3 / i2) : -9223372036854775807L;
        this.f1130s = 0L;
        this.t = 0L;
        this.u = 0L;
        this.p = false;
        this.f1131x = -9223372036854775807L;
        this.f1132y = -9223372036854775807L;
        this.r = 0L;
        this.o = 0L;
        this.j = 1.0f;
    }
}
