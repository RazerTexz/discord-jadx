package com.discord.widgets.chat.list.adapter;

import b.i.a.f.e.o.f;
import com.discord.widgets.chat.list.adapter.WidgetChatListAdapter;
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

/* compiled from: WidgetChatListAdapter.kt */
@DebugMetadata(c = "com.discord.widgets.chat.list.adapter.WidgetChatListAdapter$ScrollToWithHighlight$scheduleRetry$1", f = "WidgetChatListAdapter.kt", l = {453}, m = "invokeSuspend")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\u008a@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapter$ScrollToWithHighlight$scheduleRetry$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetChatListAdapter5 extends ContinuationImpl6 implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    public int label;
    public final /* synthetic */ WidgetChatListAdapter.ScrollToWithHighlight this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChatListAdapter5(WidgetChatListAdapter.ScrollToWithHighlight scrollToWithHighlight, Continuation continuation) {
        super(2, continuation);
        this.this$0 = scrollToWithHighlight;
    }

    @Override // d0.w.i.a.ContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Intrinsics3.checkNotNullParameter(continuation, "completion");
        return new WidgetChatListAdapter5(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((WidgetChatListAdapter5) create(coroutineScope, continuation)).invokeSuspend(Unit.a);
    }

    @Override // d0.w.i.a.ContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = Intrinsics2.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            Result3.throwOnFailure(obj);
            this.label = 1;
            if (f.P(100L, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            Result3.throwOnFailure(obj);
        }
        this.this$0.run();
        return Unit.a;
    }
}
