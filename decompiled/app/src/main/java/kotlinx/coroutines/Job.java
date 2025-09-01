package kotlinx.coroutines;

import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.sequences.Sequence;
import s.a.Job2;
import s.a.Job4;
import s.a.Job6;

/* compiled from: Job.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u0000 #2\u00020\u0001:\u0001\u001dJ\u0013\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003H'¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H&¢\u0006\u0004\b\u0007\u0010\bJ!\u0010\u000b\u001a\u00020\n2\u0010\b\u0002\u0010\t\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u0003H&¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\rH'¢\u0006\u0004\b\u0010\u0010\u0011J)\u0010\u0017\u001a\u00020\u00162\u0018\u0010\u0015\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0013\u0012\u0004\u0012\u00020\n0\u0012j\u0002`\u0014H&¢\u0006\u0004\b\u0017\u0010\u0018J=\u0010\u001b\u001a\u00020\u00162\b\b\u0002\u0010\u0019\u001a\u00020\u00062\b\b\u0002\u0010\u001a\u001a\u00020\u00062\u0018\u0010\u0015\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0013\u0012\u0004\u0012\u00020\n0\u0012j\u0002`\u0014H'¢\u0006\u0004\b\u001b\u0010\u001cR\u0016\u0010\u001e\u001a\u00020\u00068&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\bR\u001c\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00000\u001f8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b \u0010!¨\u0006$"}, d2 = {"Lkotlinx/coroutines/Job;", "Lkotlin/coroutines/CoroutineContext$Element;", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "q", "()Ljava/util/concurrent/CancellationException;", "", "start", "()Z", "cause", "", "b", "(Ljava/util/concurrent/CancellationException;)V", "Ls/a/r;", "child", "Ls/a/p;", "D", "(Ls/a/r;)Ls/a/p;", "Lkotlin/Function1;", "", "Lkotlinx/coroutines/CompletionHandler;", "handler", "Ls/a/m0;", "u", "(Lkotlin/jvm/functions/Function1;)Ls/a/m0;", "onCancelling", "invokeImmediately", "n", "(ZZLkotlin/jvm/functions/Function1;)Ls/a/m0;", "a", "isActive", "Lkotlin/sequences/Sequence;", "e", "()Lkotlin/sequences/Sequence;", "children", "h", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes3.dex */
public interface Job extends CoroutineContext.Element {

    /* renamed from: h, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.a;

    /* compiled from: Job.kt */
    /* renamed from: kotlinx.coroutines.Job$a, reason: from kotlin metadata */
    public static final class Companion implements CoroutineContext.Key<Job> {
        public static final /* synthetic */ Companion a = new Companion();

        static {
            int i = CoroutineExceptionHandler.g;
        }
    }

    Job4 D(Job6 child);

    boolean a();

    void b(CancellationException cause);

    Sequence<Job> e();

    Job2 n(boolean onCancelling, boolean invokeImmediately, Function1<? super Throwable, Unit> handler);

    CancellationException q();

    boolean start();

    Job2 u(Function1<? super Throwable, Unit> handler);
}
