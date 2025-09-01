package b.i.a.c;

import b.i.a.c.Player2;
import b.i.a.c.f3.ListenerSet;

/* compiled from: lambda */
/* loaded from: classes3.dex */
public final /* synthetic */ class d0 implements ListenerSet.a {
    public final /* synthetic */ PlaybackInfo a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f913b;

    public /* synthetic */ d0(PlaybackInfo playbackInfo, int i) {
        this.a = playbackInfo;
        this.f913b = i;
    }

    @Override // b.i.a.c.f3.ListenerSet.a
    public final void invoke(Object obj) {
        PlaybackInfo playbackInfo = this.a;
        ((Player2.c) obj).v(playbackInfo.f1146b, this.f913b);
    }
}
