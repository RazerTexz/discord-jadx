package com.discord.widgets.stage;

import d0.Result2;
import d0.z.d.Lambda;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlinx.coroutines.CancellableContinuation;

/* compiled from: StageChannelJoinHelper.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.stage.StageChannelJoinHelper$lurkAndJoinStageAsync$2$2, reason: use source file name */
/* loaded from: classes2.dex */
public final class StageChannelJoinHelper5 extends Lambda implements Function0<Unit> {
    public final /* synthetic */ CancellableContinuation $continuation;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StageChannelJoinHelper5(CancellableContinuation cancellableContinuation) {
        super(0);
        this.$continuation = cancellableContinuation;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        CancellableContinuation cancellableContinuation = this.$continuation;
        Result2.a aVar = Result2.j;
        cancellableContinuation.resumeWith(Result2.m97constructorimpl(null));
    }
}
