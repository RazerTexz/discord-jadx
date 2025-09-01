package b.i.a.c;

import b.i.a.c.f3.Log2;
import com.google.android.exoplayer2.ExoPlaybackException;
import java.util.Objects;

/* compiled from: lambda */
/* loaded from: classes3.dex */
public final /* synthetic */ class g0 implements Runnable {
    public final /* synthetic */ ExoPlayerImplInternal2 j;
    public final /* synthetic */ PlayerMessage k;

    public /* synthetic */ g0(ExoPlayerImplInternal2 exoPlayerImplInternal2, PlayerMessage playerMessage) {
        this.j = exoPlayerImplInternal2;
        this.k = playerMessage;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ExoPlayerImplInternal2 exoPlayerImplInternal2 = this.j;
        PlayerMessage playerMessage = this.k;
        Objects.requireNonNull(exoPlayerImplInternal2);
        try {
            exoPlayerImplInternal2.d(playerMessage);
        } catch (ExoPlaybackException e) {
            Log2.b("ExoPlayerImplInternal", "Unexpected error delivering message on external thread.", e);
            throw new RuntimeException(e);
        }
    }
}
