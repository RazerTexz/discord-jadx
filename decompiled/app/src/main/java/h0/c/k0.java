package h0.c;

import java.util.concurrent.CountDownLatch;

/* compiled from: lambda */
/* loaded from: classes3.dex */
public final /* synthetic */ class k0 implements Runnable {
    public final /* synthetic */ CountDownLatch j;

    public /* synthetic */ k0(CountDownLatch countDownLatch) {
        this.j = countDownLatch;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.j.countDown();
    }
}
