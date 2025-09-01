package com.discord.utilities.view.text;

import android.view.View;
import com.discord.utilities.spans.ClickableSpan;
import d0.Result3;
import d0.w.h.Intrinsics2;
import d0.w.i.a.ContinuationImpl6;
import d0.w.i.a.DebugMetadata;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: LinkifiedTextView.kt */
@DebugMetadata(c = "com.discord.utilities.view.text.LinkifiedTextView$ClickableSpanOnTouchListener$onTouch$newJob$1$1$1", f = "LinkifiedTextView.kt", l = {}, m = "invokeSuspend")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u0010\u0005\u001a\u00020\u0001*\u00020\u0000H\u008a@¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "com/discord/utilities/view/text/LinkifiedTextView$ClickableSpanOnTouchListener$onTouch$newJob$1$1$1", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.utilities.view.text.LinkifiedTextView$ClickableSpanOnTouchListener$onTouch$newJob$1$invokeSuspend$$inlined$also$lambda$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class LinkifiedTextView3 extends ContinuationImpl6 implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    public final /* synthetic */ View $it;
    public final /* synthetic */ CoroutineScope $this_launch$inlined;
    public int label;
    public final /* synthetic */ LinkifiedTextView4 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LinkifiedTextView3(View view, Continuation continuation, LinkifiedTextView4 linkifiedTextView4, CoroutineScope coroutineScope) {
        super(2, continuation);
        this.$it = view;
        this.this$0 = linkifiedTextView4;
        this.$this_launch$inlined = coroutineScope;
    }

    @Override // d0.w.i.a.ContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Intrinsics3.checkNotNullParameter(continuation, "completion");
        return new LinkifiedTextView3(this.$it, continuation, this.this$0, this.$this_launch$inlined);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((LinkifiedTextView3) create(coroutineScope, continuation)).invokeSuspend(Unit.a);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // d0.w.i.a.ContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Intrinsics2.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        Result3.throwOnFailure(obj);
        ClickableSpan clickableSpan = (ClickableSpan) ((android.text.style.ClickableSpan) this.this$0.$clickableSpan.element);
        View view = this.$it;
        Intrinsics3.checkNotNullExpressionValue(view, "it");
        clickableSpan.onLongPress(view);
        return Unit.a;
    }
}
