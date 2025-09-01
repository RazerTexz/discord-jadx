package b.i.c.s;

import b.i.c.s.d0;
import com.google.android.gms.tasks.Task;

/* compiled from: com.google.firebase:firebase-iid@@21.0.0 */
/* loaded from: classes3.dex */
public final /* synthetic */ class z implements b.i.a.f.n.c {
    public final d0.a a;

    public z(d0.a aVar) {
        this.a = aVar;
    }

    @Override // b.i.a.f.n.c
    public final void onComplete(Task task) {
        this.a.a();
    }
}
