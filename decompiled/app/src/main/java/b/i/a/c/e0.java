package b.i.a.c;

import b.i.a.c.Player2;
import b.i.a.c.f3.ListenerSet;

/* compiled from: lambda */
/* loaded from: classes3.dex */
public final /* synthetic */ class e0 implements ListenerSet.a {
    public final /* synthetic */ PlaybackInfo a;

    public /* synthetic */ e0(PlaybackInfo playbackInfo) {
        this.a = playbackInfo;
    }

    @Override // b.i.a.c.f3.ListenerSet.a
    public final void invoke(Object obj) {
        PlaybackInfo playbackInfo = this.a;
        ((Player2.c) obj).H(playbackInfo.m, playbackInfo.f);
    }
}
