package androidx.view;

import d0.w.h.Intrinsics2;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import s.a.d2.FlowCollector;

/* JADX INFO: Add missing generic type declarations: [T] */
/* compiled from: Collect.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001b\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00028\u0000H\u0096@ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0006"}, d2 = {"kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3", "Ls/a/d2/e;", "value", "", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 1})
/* renamed from: androidx.lifecycle.FlowLiveDataConversions$asLiveData$1$invokeSuspend$$inlined$collect$1, reason: use source file name */
/* loaded from: classes.dex */
public final class Collect<T> implements FlowCollector<T> {
    public final /* synthetic */ CoroutineLiveData7 $this_liveData$inlined;

    public Collect(CoroutineLiveData7 coroutineLiveData7) {
        this.$this_liveData$inlined = coroutineLiveData7;
    }

    @Override // s.a.d2.FlowCollector
    public Object emit(Object obj, Continuation continuation) {
        Object objEmit = this.$this_liveData$inlined.emit(obj, continuation);
        return objEmit == Intrinsics2.getCOROUTINE_SUSPENDED() ? objEmit : Unit.a;
    }
}
