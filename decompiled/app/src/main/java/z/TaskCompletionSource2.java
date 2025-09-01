package z;

/* compiled from: TaskCompletionSource.java */
/* renamed from: z.h, reason: use source file name */
/* loaded from: classes.dex */
public class TaskCompletionSource2<TResult> {
    public final Task6<TResult> a = new Task6<>();

    public void a() {
        if (!this.a.g()) {
            throw new IllegalStateException("Cannot cancel a completed task.");
        }
    }

    public void b(Exception exc) {
        boolean z2;
        Task6<TResult> task6 = this.a;
        synchronized (task6.g) {
            z2 = false;
            if (!task6.h) {
                task6.h = true;
                task6.k = exc;
                task6.l = false;
                task6.g.notifyAll();
                task6.f();
                z2 = true;
            }
        }
        if (!z2) {
            throw new IllegalStateException("Cannot set the error on a completed task.");
        }
    }

    public void c(TResult tresult) {
        if (!this.a.h(tresult)) {
            throw new IllegalStateException("Cannot set the result of a completed task.");
        }
    }
}
