package b.i.c.m.d.k;

import androidx.annotation.NonNull;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.concurrent.Callable;

/* compiled from: Utils.java */
/* renamed from: b.i.c.m.d.k.j1, reason: use source file name */
/* loaded from: classes3.dex */
public class Utils5 implements Runnable {
    public final /* synthetic */ Callable j;
    public final /* synthetic */ TaskCompletionSource k;

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: Utils.java */
    /* renamed from: b.i.c.m.d.k.j1$a */
    public class a<T> implements b.i.a.f.n.a<T, Void> {
        public a() {
        }

        @Override // b.i.a.f.n.a
        public Void a(@NonNull Task task) throws Exception {
            if (task.p()) {
                TaskCompletionSource taskCompletionSource = Utils5.this.k;
                taskCompletionSource.a.s(task.l());
                return null;
            }
            TaskCompletionSource taskCompletionSource2 = Utils5.this.k;
            taskCompletionSource2.a.t(task.k());
            return null;
        }
    }

    public Utils5(Callable callable, TaskCompletionSource taskCompletionSource) {
        this.j = callable;
        this.k = taskCompletionSource;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            ((Task) this.j.call()).h(new a());
        } catch (Exception e) {
            this.k.a.t(e);
        }
    }
}
