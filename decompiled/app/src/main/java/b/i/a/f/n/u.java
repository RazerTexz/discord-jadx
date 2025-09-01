package b.i.a.f.n;

import com.google.android.gms.tasks.Task;

/* compiled from: com.google.android.gms:play-services-tasks@@17.2.1 */
/* loaded from: classes3.dex */
public final class u implements Runnable {
    public final /* synthetic */ Task j;
    public final /* synthetic */ v k;

    public u(v vVar, Task task) {
        this.k = vVar;
        this.j = task;
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (this.k.f1600b) {
            e<? super TResult> eVar = this.k.c;
            if (eVar != 0) {
                eVar.onSuccess(this.j.l());
            }
        }
    }
}
