package b.i.a.c;

import b.i.a.c.Player2;
import b.i.a.c.f3.ListenerSet;

/* compiled from: lambda */
/* loaded from: classes3.dex */
public final /* synthetic */ class z implements ListenerSet.a {
    public final /* synthetic */ MediaItem2 a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f1317b;

    public /* synthetic */ z(MediaItem2 mediaItem2, int i) {
        this.a = mediaItem2;
        this.f1317b = i;
    }

    @Override // b.i.a.c.f3.ListenerSet.a
    public final void invoke(Object obj) {
        ((Player2.c) obj).M(this.a, this.f1317b);
    }
}
