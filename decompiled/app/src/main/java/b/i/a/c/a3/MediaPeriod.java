package b.i.a.c.a3;

import b.i.a.c.SeekParameters;
import b.i.a.c.a3.SequenceableLoader;
import b.i.a.c.c3.ExoTrackSelection2;
import java.io.IOException;

/* compiled from: MediaPeriod.java */
/* renamed from: b.i.a.c.a3.x, reason: use source file name */
/* loaded from: classes3.dex */
public interface MediaPeriod extends SequenceableLoader {

    /* compiled from: MediaPeriod.java */
    /* renamed from: b.i.a.c.a3.x$a */
    public interface a extends SequenceableLoader.a<MediaPeriod> {
        void b(MediaPeriod mediaPeriod);
    }

    long c();

    void e() throws IOException;

    long f(long j);

    boolean g(long j);

    boolean h();

    long i(long j, SeekParameters seekParameters);

    long k();

    void l(a aVar, long j);

    long m(ExoTrackSelection2[] exoTrackSelection2Arr, boolean[] zArr, SampleStream[] sampleStreamArr, boolean[] zArr2, long j);

    TrackGroupArray n();

    long q();

    void r(long j, boolean z2);

    void s(long j);
}
