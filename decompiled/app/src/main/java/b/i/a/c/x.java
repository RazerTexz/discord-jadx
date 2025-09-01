package b.i.a.c;

import b.i.a.c.Player2;
import b.i.a.c.f3.ListenerSet;

/* compiled from: lambda */
/* loaded from: classes3.dex */
public final /* synthetic */ class x implements ListenerSet.a {
    public final /* synthetic */ ExoPlayerImpl a;

    public /* synthetic */ x(ExoPlayerImpl exoPlayerImpl) {
        this.a = exoPlayerImpl;
    }

    @Override // b.i.a.c.f3.ListenerSet.a
    public final void invoke(Object obj) {
        ((Player2.c) obj).t(this.a.C);
    }
}
