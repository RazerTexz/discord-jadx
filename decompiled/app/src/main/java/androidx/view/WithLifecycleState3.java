package androidx.view;

import androidx.view.Lifecycle;
import d0.Result2;
import d0.Result3;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CoroutineDispatcher;

/* compiled from: WithLifecycleState.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t¸\u0006\u0000"}, d2 = {"androidx/lifecycle/WithLifecycleStateKt$suspendWithStateAtLeastUnchecked$2$observer$1", "Landroidx/lifecycle/LifecycleEventObserver;", "Landroidx/lifecycle/LifecycleOwner;", "source", "Landroidx/lifecycle/Lifecycle$Event;", "event", "", "onStateChanged", "(Landroidx/lifecycle/LifecycleOwner;Landroidx/lifecycle/Lifecycle$Event;)V", "lifecycle-runtime-ktx_release"}, k = 1, mv = {1, 4, 1})
/* renamed from: androidx.lifecycle.WithLifecycleStateKt$suspendWithStateAtLeastUnchecked$$inlined$suspendCancellableCoroutine$lambda$1, reason: use source file name */
/* loaded from: classes.dex */
public final class WithLifecycleState3 implements LifecycleEventObserver {
    public final /* synthetic */ Function0 $block$inlined;
    public final /* synthetic */ CancellableContinuation $co;
    public final /* synthetic */ boolean $dispatchNeeded$inlined;
    public final /* synthetic */ CoroutineDispatcher $lifecycleDispatcher$inlined;
    public final /* synthetic */ Lifecycle.State $state$inlined;
    public final /* synthetic */ Lifecycle $this_suspendWithStateAtLeastUnchecked$inlined;

    public WithLifecycleState3(CancellableContinuation cancellableContinuation, Lifecycle lifecycle, Lifecycle.State state, Function0 function0, boolean z2, CoroutineDispatcher coroutineDispatcher) {
        this.$co = cancellableContinuation;
        this.$this_suspendWithStateAtLeastUnchecked$inlined = lifecycle;
        this.$state$inlined = state;
        this.$block$inlined = function0;
        this.$dispatchNeeded$inlined = z2;
        this.$lifecycleDispatcher$inlined = coroutineDispatcher;
    }

    @Override // androidx.view.LifecycleEventObserver
    public void onStateChanged(LifecycleOwner source, Lifecycle.Event event) {
        Object objM97constructorimpl;
        Intrinsics3.checkNotNullParameter(source, "source");
        Intrinsics3.checkNotNullParameter(event, "event");
        if (event != Lifecycle.Event.upTo(this.$state$inlined)) {
            if (event == Lifecycle.Event.ON_DESTROY) {
                this.$this_suspendWithStateAtLeastUnchecked$inlined.removeObserver(this);
                CancellableContinuation cancellableContinuation = this.$co;
                WithLifecycleState withLifecycleState = new WithLifecycleState();
                Result2.a aVar = Result2.j;
                cancellableContinuation.resumeWith(Result2.m97constructorimpl(Result3.createFailure(withLifecycleState)));
                return;
            }
            return;
        }
        this.$this_suspendWithStateAtLeastUnchecked$inlined.removeObserver(this);
        CancellableContinuation cancellableContinuation2 = this.$co;
        Function0 function0 = this.$block$inlined;
        try {
            Result2.a aVar2 = Result2.j;
            objM97constructorimpl = Result2.m97constructorimpl(function0.invoke());
        } catch (Throwable th) {
            Result2.a aVar3 = Result2.j;
            objM97constructorimpl = Result2.m97constructorimpl(Result3.createFailure(th));
        }
        cancellableContinuation2.resumeWith(objM97constructorimpl);
    }
}
