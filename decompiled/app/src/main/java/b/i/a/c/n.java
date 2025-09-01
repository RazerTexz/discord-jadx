package b.i.a.c;

import b.i.a.c.Player2;
import b.i.a.c.f3.ListenerSet;

/* compiled from: lambda */
/* loaded from: classes3.dex */
public final /* synthetic */ class n implements ListenerSet.a {
    public final /* synthetic */ boolean a;

    public /* synthetic */ n(boolean z2) {
        this.a = z2;
    }

    @Override // b.i.a.c.f3.ListenerSet.a
    public final void invoke(Object obj) {
        ((Player2.c) obj).D(this.a);
    }
}
