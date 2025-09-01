package androidx.view;

import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;

/* compiled from: DispatchQueue.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0004\u0010\u0004\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002¨\u0006\u0003"}, d2 = {"", "run", "()V", "androidx/lifecycle/DispatchQueue$dispatchAndEnqueue$1$1", "<anonymous>"}, k = 3, mv = {1, 4, 1})
/* renamed from: androidx.lifecycle.DispatchQueue$dispatchAndEnqueue$$inlined$with$lambda$1, reason: use source file name */
/* loaded from: classes.dex */
public final class DispatchQueue2 implements Runnable {
    public final /* synthetic */ CoroutineContext $context$inlined;
    public final /* synthetic */ Runnable $runnable$inlined;
    public final /* synthetic */ DispatchQueue this$0;

    public DispatchQueue2(DispatchQueue dispatchQueue, CoroutineContext coroutineContext, Runnable runnable) {
        this.this$0 = dispatchQueue;
        this.$context$inlined = coroutineContext;
        this.$runnable$inlined = runnable;
    }

    @Override // java.lang.Runnable
    public final void run() {
        DispatchQueue.access$enqueue(this.this$0, this.$runnable$inlined);
    }
}
