package b.i.a.c.b3.p;

import b.i.a.c.b3.Cue;
import b.i.a.c.b3.Subtitle;
import java.util.List;

/* compiled from: PgsSubtitle.java */
/* renamed from: b.i.a.c.b3.p.b, reason: use source file name */
/* loaded from: classes3.dex */
public final class PgsSubtitle implements Subtitle {
    public final List<Cue> j;

    public PgsSubtitle(List<Cue> list) {
        this.j = list;
    }

    @Override // b.i.a.c.b3.Subtitle
    public int f(long j) {
        return -1;
    }

    @Override // b.i.a.c.b3.Subtitle
    public long g(int i) {
        return 0L;
    }

    @Override // b.i.a.c.b3.Subtitle
    public List<Cue> h(long j) {
        return this.j;
    }

    @Override // b.i.a.c.b3.Subtitle
    public int i() {
        return 1;
    }
}
