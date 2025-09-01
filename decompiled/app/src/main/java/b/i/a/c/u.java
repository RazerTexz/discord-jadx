package b.i.a.c;

import b.i.a.c.Player2;
import b.i.a.c.f3.FlagSet;
import b.i.a.c.f3.ListenerSet;

/* compiled from: lambda */
/* loaded from: classes3.dex */
public final /* synthetic */ class u implements ListenerSet.b {
    public final /* synthetic */ Player2 a;

    public /* synthetic */ u(Player2 player2) {
        this.a = player2;
    }

    @Override // b.i.a.c.f3.ListenerSet.b
    public final void a(Object obj, FlagSet flagSet) {
        ((Player2.c) obj).E(this.a, new Player2.d(flagSet));
    }
}
