package b.i.a.c.f3;

import b.i.a.c.PlaybackParameters;

/* compiled from: StandaloneMediaClock.java */
/* renamed from: b.i.a.c.f3.z, reason: use source file name */
/* loaded from: classes3.dex */
public final class StandaloneMediaClock implements MediaClock {
    public final Clock4 j;
    public boolean k;
    public long l;
    public long m;
    public PlaybackParameters n = PlaybackParameters.j;

    public StandaloneMediaClock(Clock4 clock4) {
        this.j = clock4;
    }

    public void a(long j) {
        this.l = j;
        if (this.k) {
            this.m = this.j.d();
        }
    }

    public void b() {
        if (this.k) {
            return;
        }
        this.m = this.j.d();
        this.k = true;
    }

    @Override // b.i.a.c.f3.MediaClock
    public PlaybackParameters c() {
        return this.n;
    }

    @Override // b.i.a.c.f3.MediaClock
    public long e() {
        long j = this.l;
        if (!this.k) {
            return j;
        }
        long jD = this.j.d() - this.m;
        return this.n.k == 1.0f ? j + Util2.B(jD) : j + (jD * r4.m);
    }

    @Override // b.i.a.c.f3.MediaClock
    public void i(PlaybackParameters playbackParameters) {
        if (this.k) {
            a(e());
        }
        this.n = playbackParameters;
    }
}
