package b.i.a.c;

import b.i.a.c.Player2;
import b.i.a.c.f3.ListenerSet;

/* compiled from: lambda */
/* loaded from: classes3.dex */
public final /* synthetic */ class j implements ListenerSet.a {
    public final /* synthetic */ ExoPlayerImpl a;

    public /* synthetic */ j(ExoPlayerImpl exoPlayerImpl) {
        this.a = exoPlayerImpl;
    }

    @Override // b.i.a.c.f3.ListenerSet.a
    public final void invoke(Object obj) {
        ((Player2.c) obj).A(this.a.D);
    }
}
