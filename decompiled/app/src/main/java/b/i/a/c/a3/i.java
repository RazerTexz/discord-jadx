package b.i.a.c.a3;

import b.i.a.c.a3.MediaPeriod;
import java.util.Objects;

/* compiled from: lambda */
/* loaded from: classes3.dex */
public final /* synthetic */ class i implements Runnable {
    public final /* synthetic */ ProgressiveMediaPeriod j;

    public /* synthetic */ i(ProgressiveMediaPeriod progressiveMediaPeriod) {
        this.j = progressiveMediaPeriod;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ProgressiveMediaPeriod progressiveMediaPeriod = this.j;
        if (progressiveMediaPeriod.W) {
            return;
        }
        MediaPeriod.a aVar = progressiveMediaPeriod.B;
        Objects.requireNonNull(aVar);
        aVar.a(progressiveMediaPeriod);
    }
}
