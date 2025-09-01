package b.i.a.f.n;

import androidx.annotation.NonNull;
import com.google.android.gms.tasks.Task;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-tasks@@17.2.1 */
/* loaded from: classes3.dex */
public final class n<TResult, TContinuationResult> implements e<TContinuationResult>, d, b, y {
    public final Executor a;

    /* renamed from: b, reason: collision with root package name */
    public final a<TResult, Task<TContinuationResult>> f1596b;
    public final c0<TContinuationResult> c;

    public n(@NonNull Executor executor, @NonNull a<TResult, Task<TContinuationResult>> aVar, @NonNull c0<TContinuationResult> c0Var) {
        this.a = executor;
        this.f1596b = aVar;
        this.c = c0Var;
    }

    @Override // b.i.a.f.n.y
    public final void a(@NonNull Task<TResult> task) {
        this.a.execute(new m(this, task));
    }

    @Override // b.i.a.f.n.b
    public final void b() {
        this.c.u();
    }

    @Override // b.i.a.f.n.d
    public final void onFailure(@NonNull Exception exc) {
        this.c.t(exc);
    }

    @Override // b.i.a.f.n.e
    public final void onSuccess(TContinuationResult tcontinuationresult) {
        this.c.s(tcontinuationresult);
    }
}
