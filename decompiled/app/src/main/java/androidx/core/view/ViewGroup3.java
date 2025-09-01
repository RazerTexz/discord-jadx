package androidx.core.view;

import android.view.View;
import android.view.ViewGroup;
import d0.Result3;
import d0.f0.SequenceBuilder2;
import d0.w.h.Intrinsics2;
import d0.w.i.a.ContinuationImpl5;
import d0.w.i.a.DebugMetadata;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlin.sequences.Sequence;

/* compiled from: ViewGroup.kt */
@DebugMetadata(c = "androidx.core.view.ViewGroupKt$descendants$1", f = "ViewGroup.kt", l = {97, 99}, m = "invokeSuspend")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u0002*\b\u0012\u0004\u0012\u00020\u00010\u0000H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Ld0/f0/k;", "Landroid/view/View;", "", "<anonymous>", "(Ld0/f0/k;)V"}, k = 3, mv = {1, 5, 1})
/* renamed from: androidx.core.view.ViewGroupKt$descendants$1, reason: use source file name */
/* loaded from: classes.dex */
public final class ViewGroup3 extends ContinuationImpl5 implements Function2<SequenceBuilder2<? super View>, Continuation<? super Unit>, Object> {
    public final /* synthetic */ ViewGroup $this_descendants;
    public int I$0;
    public int I$1;
    private /* synthetic */ Object L$0;
    public Object L$1;
    public Object L$2;
    public int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ViewGroup3(ViewGroup viewGroup, Continuation<? super ViewGroup3> continuation) {
        super(2, continuation);
        this.$this_descendants = viewGroup;
    }

    @Override // d0.w.i.a.ContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        ViewGroup3 viewGroup3 = new ViewGroup3(this.$this_descendants, continuation);
        viewGroup3.L$0 = obj;
        return viewGroup3;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(SequenceBuilder2<? super View> sequenceBuilder2, Continuation<? super Unit> continuation) {
        return ((ViewGroup3) create(sequenceBuilder2, continuation)).invokeSuspend(Unit.a);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(SequenceBuilder2<? super View> sequenceBuilder2, Continuation<? super Unit> continuation) {
        return invoke2(sequenceBuilder2, continuation);
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x009c, code lost:
    
        if (r4 >= r5) goto L26;
     */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0099  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x0091 -> B:23:0x0093). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:24:0x0099 -> B:25:0x009c). Please report as a decompilation issue!!! */
    @Override // d0.w.i.a.ContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        SequenceBuilder2 sequenceBuilder2;
        ViewGroup viewGroup;
        int i;
        int childCount;
        ViewGroup3 viewGroup3;
        ViewGroup3 viewGroup32;
        ViewGroup viewGroup2;
        View view;
        int i2;
        ViewGroup viewGroup4;
        SequenceBuilder2 sequenceBuilder22;
        Object coroutine_suspended = Intrinsics2.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 == 0) {
            Result3.throwOnFailure(obj);
            sequenceBuilder2 = (SequenceBuilder2) this.L$0;
            viewGroup = this.$this_descendants;
            i = 0;
            childCount = viewGroup.getChildCount();
            if (childCount > 0) {
                viewGroup3 = this;
                int i4 = i + 1;
                View childAt = viewGroup.getChildAt(i);
                Intrinsics3.checkNotNullExpressionValue(childAt, "getChildAt(index)");
                viewGroup3.L$0 = sequenceBuilder2;
                viewGroup3.L$1 = viewGroup;
                viewGroup3.L$2 = childAt;
                viewGroup3.I$0 = i4;
                viewGroup3.I$1 = childCount;
                viewGroup3.label = 1;
                if (sequenceBuilder2.yield(childAt, viewGroup3) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                ViewGroup3 viewGroup33 = viewGroup3;
                viewGroup2 = viewGroup;
                i2 = childCount;
                view = childAt;
                i = i4;
                viewGroup32 = viewGroup33;
                if (view instanceof ViewGroup) {
                }
            }
            return Unit.a;
        }
        if (i3 == 1) {
            i2 = this.I$1;
            i = this.I$0;
            view = (View) this.L$2;
            viewGroup2 = (ViewGroup) this.L$1;
            SequenceBuilder2 sequenceBuilder23 = (SequenceBuilder2) this.L$0;
            Result3.throwOnFailure(obj);
            sequenceBuilder2 = sequenceBuilder23;
            viewGroup32 = this;
            if (view instanceof ViewGroup) {
                childCount = i2;
                viewGroup = viewGroup2;
                viewGroup3 = viewGroup32;
            } else {
                Sequence<View> descendants = ViewGroup.getDescendants((ViewGroup) view);
                viewGroup32.L$0 = sequenceBuilder2;
                viewGroup32.L$1 = viewGroup2;
                viewGroup32.L$2 = null;
                viewGroup32.I$0 = i;
                viewGroup32.I$1 = i2;
                viewGroup32.label = 2;
                if (sequenceBuilder2.yieldAll(descendants, viewGroup32) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                viewGroup4 = viewGroup2;
                sequenceBuilder22 = sequenceBuilder2;
                sequenceBuilder2 = sequenceBuilder22;
                viewGroup3 = viewGroup32;
                ViewGroup viewGroup5 = viewGroup4;
                childCount = i2;
                viewGroup = viewGroup5;
            }
        } else {
            if (i3 != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            i2 = this.I$1;
            i = this.I$0;
            viewGroup4 = (ViewGroup) this.L$1;
            sequenceBuilder22 = (SequenceBuilder2) this.L$0;
            Result3.throwOnFailure(obj);
            viewGroup32 = this;
            sequenceBuilder2 = sequenceBuilder22;
            viewGroup3 = viewGroup32;
            ViewGroup viewGroup52 = viewGroup4;
            childCount = i2;
            viewGroup = viewGroup52;
        }
    }
}
