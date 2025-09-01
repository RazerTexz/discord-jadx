package b.i.a.b.j;

import c0.a.Provider3;
import java.util.concurrent.Executors;

/* compiled from: ExecutionModule_ExecutorFactory.java */
/* renamed from: b.i.a.b.j.g, reason: use source file name */
/* loaded from: classes3.dex */
public final class ExecutionModule_ExecutorFactory implements Provider3 {

    /* compiled from: ExecutionModule_ExecutorFactory.java */
    /* renamed from: b.i.a.b.j.g$a */
    public static final class a {
        public static final ExecutionModule_ExecutorFactory a = new ExecutionModule_ExecutorFactory();
    }

    @Override // c0.a.Provider3
    public Object get() {
        return new SafeLoggingExecutor(Executors.newSingleThreadExecutor());
    }
}
