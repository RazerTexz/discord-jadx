package b.a.p;

import com.discord.player.AppMediaPlayer;
import com.discord.utilities.logging.Logger;
import rx.functions.Action1;

/* compiled from: AppMediaPlayer.kt */
/* renamed from: b.a.p.d, reason: use source file name */
/* loaded from: classes.dex */
public final class AppMediaPlayer5<T> implements Action1<Throwable> {
    public final /* synthetic */ AppMediaPlayer j;

    public AppMediaPlayer5(AppMediaPlayer appMediaPlayer) {
        this.j = appMediaPlayer;
    }

    @Override // rx.functions.Action1
    public void call(Throwable th) {
        Logger.e$default(this.j.logger, "error while listening to player errors", th, null, 4, null);
    }
}
