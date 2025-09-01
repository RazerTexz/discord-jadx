package b.i.a.c.w2;

import b.i.a.c.f3.Consumer3;
import b.i.a.c.w2.DrmSessionEventListener;

/* compiled from: lambda */
/* loaded from: classes3.dex */
public final /* synthetic */ class b implements Consumer3 {
    public final /* synthetic */ Exception a;

    public /* synthetic */ b(Exception exc) {
        this.a = exc;
    }

    @Override // b.i.a.c.f3.Consumer3
    public final void accept(Object obj) {
        ((DrmSessionEventListener.a) obj).e(this.a);
    }
}
