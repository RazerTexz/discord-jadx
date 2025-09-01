package b.i.a.c.y2;

/* compiled from: lambda */
/* loaded from: classes3.dex */
public final /* synthetic */ class d implements Runnable {
    public final /* synthetic */ AsynchronousMediaCodecCallback j;
    public final /* synthetic */ Runnable k;

    public /* synthetic */ d(AsynchronousMediaCodecCallback asynchronousMediaCodecCallback, Runnable runnable) {
        this.j = asynchronousMediaCodecCallback;
        this.k = runnable;
    }

    @Override // java.lang.Runnable
    public final void run() {
        AsynchronousMediaCodecCallback asynchronousMediaCodecCallback = this.j;
        Runnable runnable = this.k;
        synchronized (asynchronousMediaCodecCallback.a) {
            if (!asynchronousMediaCodecCallback.l) {
                long j = asynchronousMediaCodecCallback.k - 1;
                asynchronousMediaCodecCallback.k = j;
                if (j <= 0) {
                    if (j < 0) {
                        asynchronousMediaCodecCallback.c(new IllegalStateException());
                    } else {
                        asynchronousMediaCodecCallback.a();
                        try {
                            runnable.run();
                        } catch (IllegalStateException e) {
                            asynchronousMediaCodecCallback.c(e);
                        } catch (Exception e2) {
                            asynchronousMediaCodecCallback.c(new IllegalStateException(e2));
                        }
                    }
                }
            }
        }
    }
}
