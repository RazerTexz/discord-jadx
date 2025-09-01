package com.discord.utilities.rx;

import androidx.recyclerview.widget.RecyclerView;
import b.i.a.f.e.o.f;
import d0.w.ContinuationInterceptor;
import d0.w.CoroutineContextImpl4;
import j0.Observer2;
import java.util.concurrent.locks.LockSupport;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.channels.Produce;
import s.a.Builders4;
import s.a.CompletionState2;
import s.a.Dispatchers;
import s.a.c2.Channels;
import s.a.i1;
import s.a.q0;
import s.a.w1;
import s.a.z0;

/* JADX INFO: Add missing generic type declarations: [T] */
/* compiled from: RxCoroutineUtils.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0007*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u0019\u0010\u0007\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\n\u001a\u00020\u00022\u0006\u0010\t\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"com/discord/utilities/rx/RxCoroutineUtilsKt$toFlow$2$subscription$1", "Lj0/g;", "", "onCompleted", "()V", "", "e", "onError", "(Ljava/lang/Throwable;)V", "value", "onNext", "(Ljava/lang/Object;)V", "utils_release"}, k = 1, mv = {1, 4, 2})
/* renamed from: com.discord.utilities.rx.RxCoroutineUtilsKt$toFlow$2$subscription$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class RxCoroutineUtils5<T> implements Observer2<T> {
    public final /* synthetic */ Produce $this_callbackFlow;

    public RxCoroutineUtils5(Produce<? super T> produce) {
        this.$this_callbackFlow = produce;
    }

    @Override // j0.Observer2
    public void onCompleted() {
        f.I(this.$this_callbackFlow, null, 1, null);
    }

    @Override // j0.Observer2
    public void onError(Throwable e) {
        f.r(this.$this_callbackFlow, f.a("Error in Observable", e));
    }

    @Override // j0.Observer2
    public void onNext(T value) throws Throwable {
        q0 q0VarA;
        CoroutineContext coroutineContextPlus;
        Produce produce = this.$this_callbackFlow;
        if (produce.offer(value)) {
            return;
        }
        Channels channels = new Channels(produce, value, null);
        CoroutineContext coroutineContext = CoroutineContextImpl4.j;
        Thread threadCurrentThread = Thread.currentThread();
        ContinuationInterceptor.b bVar = ContinuationInterceptor.b.a;
        ContinuationInterceptor continuationInterceptor = (ContinuationInterceptor) coroutineContext.get(bVar);
        if (continuationInterceptor == null) {
            w1 w1Var = w1.f3847b;
            q0VarA = w1.a();
            coroutineContextPlus = coroutineContext.plus(coroutineContext.plus(q0VarA));
            CoroutineDispatcher coroutineDispatcher = Dispatchers.a;
            if (coroutineContextPlus != coroutineDispatcher && coroutineContextPlus.get(bVar) == null) {
                coroutineContextPlus = coroutineContextPlus.plus(coroutineDispatcher);
            }
        } else {
            if (!(continuationInterceptor instanceof q0)) {
                continuationInterceptor = null;
            }
            w1 w1Var2 = w1.f3847b;
            q0VarA = w1.a.get();
            coroutineContextPlus = coroutineContext.plus(coroutineContext);
            CoroutineDispatcher coroutineDispatcher2 = Dispatchers.a;
            if (coroutineContextPlus != coroutineDispatcher2 && coroutineContextPlus.get(bVar) == null) {
                coroutineContextPlus = coroutineContextPlus.plus(coroutineDispatcher2);
            }
        }
        Builders4 builders4 = new Builders4(coroutineContextPlus, threadCurrentThread, q0VarA);
        builders4.j0(CoroutineStart.DEFAULT, builders4, channels);
        q0 q0Var = builders4.n;
        if (q0Var != null) {
            int i = q0.j;
            q0Var.L(false);
        }
        while (!Thread.interrupted()) {
            try {
                q0 q0Var2 = builders4.n;
                long jO = q0Var2 != null ? q0Var2.O() : RecyclerView.FOREVER_NS;
                if (!(builders4.M() instanceof z0)) {
                    Object objA = i1.a(builders4.M());
                    CompletionState2 completionState2 = (CompletionState2) (objA instanceof CompletionState2 ? objA : null);
                    if (completionState2 != null) {
                        throw completionState2.f3846b;
                    }
                    return;
                }
                LockSupport.parkNanos(builders4, jO);
            } finally {
                q0 q0Var3 = builders4.n;
                if (q0Var3 != null) {
                    int i2 = q0.j;
                    q0Var3.H(false);
                }
            }
        }
        InterruptedException interruptedException = new InterruptedException();
        builders4.w(interruptedException);
        throw interruptedException;
    }
}
