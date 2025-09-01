package b.o.a.n.o;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

/* compiled from: CompletionCallback.java */
@RequiresApi(21)
/* renamed from: b.o.a.n.o.f, reason: use source file name */
/* loaded from: classes3.dex */
public abstract class CompletionCallback implements ActionCallback {
    @Override // b.o.a.n.o.ActionCallback
    public final void a(@NonNull Action2 action2, int i) {
        if (i == Integer.MAX_VALUE) {
            b(action2);
        }
    }

    public abstract void b(@NonNull Action2 action2);
}
