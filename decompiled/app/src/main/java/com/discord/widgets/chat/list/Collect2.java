package com.discord.widgets.chat.list;

import android.view.View;
import com.discord.widgets.chat.list.InlineMediaView;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import s.a.d2.FlowCollector;

/* compiled from: Collect.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001b\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00028\u0000H\u0096@ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0006"}, d2 = {"kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3", "Ls/a/d2/e;", "value", "", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.chat.list.InlineMediaView$onViewAttachedToWindow$1$invokeSuspend$$inlined$collect$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class Collect2 implements FlowCollector<Boolean> {
    public final /* synthetic */ InlineMediaView.AnonymousClass1 this$0;

    public Collect2(InlineMediaView.AnonymousClass1 anonymousClass1) {
        this.this$0 = anonymousClass1;
    }

    @Override // s.a.d2.FlowCollector
    public Object emit(Boolean bool, Continuation continuation) {
        Boolean bool2 = bool;
        View view = InlineMediaView.access$getBinding$p(InlineMediaView.this).h;
        Intrinsics3.checkNotNullExpressionValue(view, "binding.opacityShim");
        Intrinsics3.checkNotNullExpressionValue(bool2, "isAnyPanelOpen");
        view.setVisibility(bool2.booleanValue() ? 0 : 8);
        return Unit.a;
    }
}
