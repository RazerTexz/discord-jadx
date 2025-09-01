package b.i.a.b.j;

import b.c.a.a0.AnimatableValueParser;
import java.util.concurrent.Executor;

/* compiled from: SafeLoggingExecutor.java */
/* renamed from: b.i.a.b.j.h, reason: use source file name */
/* loaded from: classes3.dex */
public class SafeLoggingExecutor implements Executor {
    public final Executor j;

    /* compiled from: SafeLoggingExecutor.java */
    /* renamed from: b.i.a.b.j.h$a */
    public static class a implements Runnable {
        public final Runnable j;

        public a(Runnable runnable) {
            this.j = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.j.run();
            } catch (Exception e) {
                AnimatableValueParser.c0("Executor", "Background execution failure.", e);
            }
        }
    }

    public SafeLoggingExecutor(Executor executor) {
        this.j = executor;
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        this.j.execute(new a(runnable));
    }
}
