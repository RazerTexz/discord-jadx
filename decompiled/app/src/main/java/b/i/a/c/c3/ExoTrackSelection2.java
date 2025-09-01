package b.i.a.c.c3;

import b.i.a.c.Format2;
import b.i.a.c.a3.TrackGroup;

/* compiled from: ExoTrackSelection.java */
/* renamed from: b.i.a.c.c3.j, reason: use source file name */
/* loaded from: classes3.dex */
public interface ExoTrackSelection2 extends TrackSelection {

    /* compiled from: ExoTrackSelection.java */
    /* renamed from: b.i.a.c.c3.j$b */
    public interface b {
    }

    int b();

    void c(boolean z2);

    void e();

    void g();

    Format2 h();

    void i(float f);

    void j();

    void k();

    /* compiled from: ExoTrackSelection.java */
    /* renamed from: b.i.a.c.c3.j$a */
    public static final class a {
        public final TrackGroup a;

        /* renamed from: b, reason: collision with root package name */
        public final int[] f902b;
        public final int c;

        public a(TrackGroup trackGroup, int... iArr) {
            this.a = trackGroup;
            this.f902b = iArr;
            this.c = 0;
        }

        public a(TrackGroup trackGroup, int[] iArr, int i) {
            this.a = trackGroup;
            this.f902b = iArr;
            this.c = i;
        }
    }
}
