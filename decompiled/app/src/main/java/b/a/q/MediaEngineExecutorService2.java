package b.a.q;

/* compiled from: MediaEngineExecutorService.kt */
/* renamed from: b.a.q.d, reason: use source file name */
/* loaded from: classes.dex */
public final class MediaEngineExecutorService2 implements Runnable {
    public final /* synthetic */ IllegalStateException j;

    public MediaEngineExecutorService2(IllegalStateException illegalStateException) {
        this.j = illegalStateException;
    }

    @Override // java.lang.Runnable
    public final void run() {
        throw this.j;
    }
}
