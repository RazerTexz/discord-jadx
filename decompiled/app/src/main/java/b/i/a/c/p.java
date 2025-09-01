package b.i.a.c;

import b.i.a.c.Player2;
import b.i.a.c.f3.ListenerSet;

/* compiled from: lambda */
/* loaded from: classes3.dex */
public final /* synthetic */ class p implements ListenerSet.a {
    public final /* synthetic */ MediaMetadata a;

    public /* synthetic */ p(MediaMetadata mediaMetadata) {
        this.a = mediaMetadata;
    }

    @Override // b.i.a.c.f3.ListenerSet.a
    public final void invoke(Object obj) {
        ((Player2.c) obj).A(this.a);
    }
}
