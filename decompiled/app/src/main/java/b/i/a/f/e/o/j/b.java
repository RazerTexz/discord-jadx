package b.i.a.f.e.o.j;

import android.os.Process;

/* compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
/* loaded from: classes3.dex */
public final class b implements Runnable {
    public final Runnable j;

    public b(Runnable runnable) {
        this.j = runnable;
    }

    @Override // java.lang.Runnable
    public final void run() throws SecurityException, IllegalArgumentException {
        Process.setThreadPriority(0);
        this.j.run();
    }
}
