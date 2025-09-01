package kotlinx.coroutines;

import d0.w.CoroutineContextImpl2;
import java.io.Closeable;
import java.util.concurrent.Executor;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import s.a.Executors4;

/* compiled from: Executors.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b&\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\tB\u0007¢\u0006\u0004\b\u0007\u0010\bR\u0016\u0010\u0006\u001a\u00020\u00038&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\n"}, d2 = {"Lkotlinx/coroutines/ExecutorCoroutineDispatcher;", "Lkotlinx/coroutines/CoroutineDispatcher;", "Ljava/io/Closeable;", "Ljava/util/concurrent/Executor;", "H", "()Ljava/util/concurrent/Executor;", "executor", "<init>", "()V", "a", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
/* renamed from: kotlinx.coroutines.ExecutorCoroutineDispatcher, reason: use source file name */
/* loaded from: classes3.dex */
public abstract class Executors extends CoroutineDispatcher implements Closeable {

    /* compiled from: Executors.kt */
    /* renamed from: kotlinx.coroutines.ExecutorCoroutineDispatcher$a */
    public static final class a extends CoroutineContextImpl2<CoroutineDispatcher, Executors> {
        public a(DefaultConstructorMarker defaultConstructorMarker) {
            super(CoroutineDispatcher.INSTANCE, Executors4.j);
        }
    }

    static {
        new a(null);
    }

    public abstract Executor H();
}
