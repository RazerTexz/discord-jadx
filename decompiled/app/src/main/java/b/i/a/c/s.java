package b.i.a.c;

import b.i.a.c.Player2;
import b.i.a.c.f3.ListenerSet;

/* compiled from: lambda */
/* loaded from: classes3.dex */
public final /* synthetic */ class s implements ListenerSet.a {
    public final /* synthetic */ PlaybackInfo a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f1060b;

    public /* synthetic */ s(PlaybackInfo playbackInfo, int i) {
        this.a = playbackInfo;
        this.f1060b = i;
    }

    @Override // b.i.a.c.f3.ListenerSet.a
    public final void invoke(Object obj) {
        PlaybackInfo playbackInfo = this.a;
        ((Player2.c) obj).W(playbackInfo.m, this.f1060b);
    }
}
