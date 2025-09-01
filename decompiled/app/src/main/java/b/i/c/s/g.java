package b.i.c.s;

import java.util.concurrent.Executor;

/* compiled from: com.google.firebase:firebase-iid@@21.0.0 */
/* loaded from: classes3.dex */
public final /* synthetic */ class g implements Executor {
    public static final Executor j = new g();

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        runnable.run();
    }
}
