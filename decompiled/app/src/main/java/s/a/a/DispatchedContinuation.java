package s.a.a;

import b.d.b.a.outline;
import d0.z.d.Intrinsics3;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlinx.coroutines.CoroutineDispatcher;
import s.a.CompletionState3;
import s.a.DispatchedTask;
import s.a.q0;
import s.a.w1;

/* compiled from: DispatchedContinuation.kt */
/* renamed from: s.a.a.g, reason: use source file name */
/* loaded from: classes3.dex */
public final class DispatchedContinuation<T> extends DispatchedTask<T> implements CoroutineStackFrame, Continuation<T> {
    public static final AtomicReferenceFieldUpdater m = AtomicReferenceFieldUpdater.newUpdater(DispatchedContinuation.class, Object.class, "_reusableCancellableContinuation");
    public volatile Object _reusableCancellableContinuation;
    public Object n;
    public final CoroutineStackFrame o;
    public final Object p;
    public final CoroutineDispatcher q;
    public final Continuation<T> r;

    /* JADX WARN: Multi-variable type inference failed */
    public DispatchedContinuation(CoroutineDispatcher coroutineDispatcher, Continuation<? super T> continuation) {
        super(-1);
        this.q = coroutineDispatcher;
        this.r = continuation;
        this.n = DispatchedContinuation2.a;
        this.o = continuation instanceof CoroutineStackFrame ? continuation : (Continuation<? super T>) null;
        Object objFold = getContext().fold(0, ThreadContext.f3825b);
        Intrinsics3.checkNotNull(objFold);
        this.p = objFold;
        this._reusableCancellableContinuation = null;
    }

    @Override // s.a.DispatchedTask
    public void b(Object obj, Throwable th) {
        if (obj instanceof CompletionState3) {
            ((CompletionState3) obj).f3848b.invoke(th);
        }
    }

    @Override // s.a.DispatchedTask
    public Continuation<T> d() {
        return this;
    }

    @Override // kotlin.coroutines.Continuation
    public CoroutineContext getContext() {
        return this.r.getContext();
    }

    @Override // s.a.DispatchedTask
    public Object m() {
        Object obj = this.n;
        this.n = DispatchedContinuation2.a;
        return obj;
    }

    @Override // kotlin.coroutines.Continuation
    public void resumeWith(Object obj) {
        CoroutineContext context;
        Object objB;
        CoroutineContext context2 = this.r.getContext();
        Object objV1 = b.i.a.f.e.o.f.v1(obj, null);
        if (this.q.isDispatchNeeded(context2)) {
            this.n = objV1;
            this.l = 0;
            this.q.dispatch(context2, this);
            return;
        }
        w1 w1Var = w1.f3847b;
        q0 q0VarA = w1.a();
        if (q0VarA.N()) {
            this.n = objV1;
            this.l = 0;
            q0VarA.J(this);
            return;
        }
        q0VarA.L(true);
        try {
            context = getContext();
            objB = ThreadContext.b(context, this.p);
        } finally {
            try {
            } finally {
            }
        }
        try {
            this.r.resumeWith(obj);
            while (q0VarA.R()) {
            }
        } finally {
            ThreadContext.a(context, objB);
        }
    }

    public String toString() {
        StringBuilder sbU = outline.U("DispatchedContinuation[");
        sbU.append(this.q);
        sbU.append(", ");
        sbU.append(b.i.a.f.e.o.f.s1(this.r));
        sbU.append(']');
        return sbU.toString();
    }
}
