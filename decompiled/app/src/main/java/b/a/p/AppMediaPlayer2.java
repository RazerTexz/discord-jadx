package b.a.p;

import b.a.p.RxPlayerEventListener;
import com.discord.player.AppMediaPlayer;
import rx.functions.Action1;

/* compiled from: AppMediaPlayer.kt */
/* renamed from: b.a.p.a, reason: use source file name */
/* loaded from: classes.dex */
public final class AppMediaPlayer2<T> implements Action1<RxPlayerEventListener.a> {
    public final /* synthetic */ AppMediaPlayer j;

    public AppMediaPlayer2(AppMediaPlayer appMediaPlayer) {
        this.j = appMediaPlayer;
    }

    @Override // rx.functions.Action1
    public void call(RxPlayerEventListener.a aVar) {
        this.j.eventSubject.k.onNext(aVar.a ? AppMediaPlayer.Event.f.a : AppMediaPlayer.Event.d.a);
    }
}
