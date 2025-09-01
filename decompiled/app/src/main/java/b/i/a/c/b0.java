package b.i.a.c;

import androidx.core.view.PointerIconCompat;
import b.i.a.c.Player2;
import b.i.a.c.f3.ListenerSet;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.ExoTimeoutException;

/* compiled from: lambda */
/* loaded from: classes3.dex */
public final /* synthetic */ class b0 implements ListenerSet.a {
    public static final /* synthetic */ b0 a = new b0();

    @Override // b.i.a.c.f3.ListenerSet.a
    public final void invoke(Object obj) {
        int i = ExoPlayerImpl.f958b;
        ((Player2.c) obj).s(ExoPlaybackException.b(new ExoTimeoutException(1), PointerIconCompat.TYPE_HELP));
    }
}
