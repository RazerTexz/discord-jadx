package b.i.c.m.d.k;

import android.os.Process;

/* compiled from: BackgroundPriorityRunnable.java */
/* renamed from: b.i.c.m.d.k.d, reason: use source file name */
/* loaded from: classes3.dex */
public abstract class BackgroundPriorityRunnable implements Runnable {
    public abstract void a();

    @Override // java.lang.Runnable
    public final void run() throws SecurityException, IllegalArgumentException {
        Process.setThreadPriority(10);
        a();
    }
}
