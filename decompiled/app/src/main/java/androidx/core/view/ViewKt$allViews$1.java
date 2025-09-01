package androidx.core.view;

import android.view.View;
import android.view.ViewGroup;
import d0.Result3;
import d0.f0.SequenceBuilder2;
import d0.w.h.Intrinsics2;
import d0.w.i.a.ContinuationImpl5;
import d0.w.i.a.DebugMetadata;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlin.sequences.Sequence;

/* compiled from: View.kt */
@DebugMetadata(c = "androidx.core.view.ViewKt$allViews$1", f = "View.kt", l = {406, 408}, m = "invokeSuspend")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u0002*\b\u0012\u0004\u0012\u00020\u00010\u0000H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Ld0/f0/k;", "Landroid/view/View;", "", "<anonymous>", "(Ld0/f0/k;)V"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class ViewKt$allViews$1 extends ContinuationImpl5 implements Function2<SequenceBuilder2<? super View>, Continuation<? super Unit>, Object> {
    public final /* synthetic */ View $this_allViews;
    private /* synthetic */ Object L$0;
    public int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ViewKt$allViews$1(View view, Continuation<? super ViewKt$allViews$1> continuation) {
        super(2, continuation);
        this.$this_allViews = view;
    }

    @Override // d0.w.i.a.ContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        ViewKt$allViews$1 viewKt$allViews$1 = new ViewKt$allViews$1(this.$this_allViews, continuation);
        viewKt$allViews$1.L$0 = obj;
        return viewKt$allViews$1;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(SequenceBuilder2<? super View> sequenceBuilder2, Continuation<? super Unit> continuation) {
        return ((ViewKt$allViews$1) create(sequenceBuilder2, continuation)).invokeSuspend(Unit.a);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(SequenceBuilder2<? super View> sequenceBuilder2, Continuation<? super Unit> continuation) {
        return invoke2(sequenceBuilder2, continuation);
    }

    @Override // d0.w.i.a.ContinuationImpl
    public final Object invokeSuspend(Object obj) {
        SequenceBuilder2 sequenceBuilder2;
        Object coroutine_suspended = Intrinsics2.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            Result3.throwOnFailure(obj);
            sequenceBuilder2 = (SequenceBuilder2) this.L$0;
            View view = this.$this_allViews;
            this.L$0 = sequenceBuilder2;
            this.label = 1;
            if (sequenceBuilder2.yield(view, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                if (i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                Result3.throwOnFailure(obj);
                return Unit.a;
            }
            sequenceBuilder2 = (SequenceBuilder2) this.L$0;
            Result3.throwOnFailure(obj);
        }
        View view2 = this.$this_allViews;
        if (view2 instanceof ViewGroup) {
            Sequence<View> descendants = ViewGroup.getDescendants((ViewGroup) view2);
            this.L$0 = null;
            this.label = 2;
            if (sequenceBuilder2.yieldAll(descendants, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return Unit.a;
    }
}
