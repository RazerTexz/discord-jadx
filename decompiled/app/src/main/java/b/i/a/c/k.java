package b.i.a.c;

import b.i.a.c.Player2;
import b.i.a.c.f3.ListenerSet;

/* compiled from: lambda */
/* loaded from: classes3.dex */
public final /* synthetic */ class k implements ListenerSet.a {
    public final /* synthetic */ int a;

    public /* synthetic */ k(int i) {
        this.a = i;
    }

    @Override // b.i.a.c.f3.ListenerSet.a
    public final void invoke(Object obj) {
        ((Player2.c) obj).L(this.a);
    }
}
