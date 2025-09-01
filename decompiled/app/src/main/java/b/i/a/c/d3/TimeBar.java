package b.i.a.c.d3;

import androidx.annotation.Nullable;

/* compiled from: TimeBar.java */
/* renamed from: b.i.a.c.d3.o, reason: use source file name */
/* loaded from: classes3.dex */
public interface TimeBar {

    /* compiled from: TimeBar.java */
    /* renamed from: b.i.a.c.d3.o$a */
    public interface a {
        void k(TimeBar timeBar, long j);

        void l(TimeBar timeBar, long j, boolean z2);

        void m(TimeBar timeBar, long j);
    }

    void a(@Nullable long[] jArr, @Nullable boolean[] zArr, int i);

    void b(a aVar);

    long getPreferredUpdateDelay();

    void setBufferedPosition(long j);

    void setDuration(long j);

    void setEnabled(boolean z2);

    void setPosition(long j);
}
