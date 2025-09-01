package b.i.a.c.w2;

import android.os.Looper;
import b.i.a.c.Format2;
import com.google.android.exoplayer2.drm.DefaultDrmSessionManager;
import java.util.Objects;

/* compiled from: lambda */
/* loaded from: classes3.dex */
public final /* synthetic */ class e implements Runnable {
    public final /* synthetic */ DefaultDrmSessionManager.d j;
    public final /* synthetic */ Format2 k;

    public /* synthetic */ e(DefaultDrmSessionManager.d dVar, Format2 format2) {
        this.j = dVar;
        this.k = format2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        DefaultDrmSessionManager.d dVar = this.j;
        Format2 format2 = this.k;
        DefaultDrmSessionManager defaultDrmSessionManager = DefaultDrmSessionManager.this;
        if (defaultDrmSessionManager.p == 0 || dVar.d) {
            return;
        }
        Looper looper = defaultDrmSessionManager.t;
        Objects.requireNonNull(looper);
        dVar.c = defaultDrmSessionManager.e(looper, dVar.f2932b, format2, false);
        DefaultDrmSessionManager.this.n.add(dVar);
    }
}
