package b.i.a.c.w2;

import com.google.android.exoplayer2.drm.DefaultDrmSessionManager;
import com.google.android.exoplayer2.drm.DrmSession;

/* compiled from: lambda */
/* loaded from: classes3.dex */
public final /* synthetic */ class d implements Runnable {
    public final /* synthetic */ DefaultDrmSessionManager.d j;

    public /* synthetic */ d(DefaultDrmSessionManager.d dVar) {
        this.j = dVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        DefaultDrmSessionManager.d dVar = this.j;
        if (dVar.d) {
            return;
        }
        DrmSession drmSession = dVar.c;
        if (drmSession != null) {
            drmSession.b(dVar.f2932b);
        }
        DefaultDrmSessionManager.this.n.remove(dVar);
        dVar.d = true;
    }
}
