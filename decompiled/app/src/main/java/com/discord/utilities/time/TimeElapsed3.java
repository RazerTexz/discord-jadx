package com.discord.utilities.time;

import d0.z.d.Lambda;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

/* compiled from: TimeElapsed.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0007\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()F", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.utilities.time.TimeElapsed$seconds$2, reason: use source file name */
/* loaded from: classes2.dex */
public final class TimeElapsed3 extends Lambda implements Function0<Float> {
    public final /* synthetic */ TimeElapsed this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TimeElapsed3(TimeElapsed timeElapsed) {
        super(0);
        this.this$0 = timeElapsed;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Float invoke() {
        return Float.valueOf(invoke2());
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final float invoke2() {
        return this.this$0.getMilliseconds() / 1000.0f;
    }
}
