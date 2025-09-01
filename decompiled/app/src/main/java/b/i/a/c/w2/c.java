package b.i.a.c.w2;

import b.i.a.c.f3.Consumer3;
import b.i.a.c.w2.DrmSessionEventListener;

/* compiled from: lambda */
/* loaded from: classes3.dex */
public final /* synthetic */ class c implements Consumer3 {
    public final /* synthetic */ int a;

    public /* synthetic */ c(int i) {
        this.a = i;
    }

    @Override // b.i.a.c.f3.Consumer3
    public final void accept(Object obj) {
        ((DrmSessionEventListener.a) obj).d(this.a);
    }
}
