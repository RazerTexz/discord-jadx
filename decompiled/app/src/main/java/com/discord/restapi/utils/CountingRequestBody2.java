package com.discord.restapi.utils;

import d0.z.d.FunctionReferenceImpl;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: CountingRequestBody.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "p1", "", "invoke", "(J)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.restapi.utils.CountingRequestBody$writeTo$countingSink$1, reason: use source file name */
/* loaded from: classes.dex */
public final /* synthetic */ class CountingRequestBody2 extends FunctionReferenceImpl implements Function1<Long, Unit> {
    public CountingRequestBody2(CountingRequestBody countingRequestBody) {
        super(1, countingRequestBody, CountingRequestBody.class, "updateProgress", "updateProgress(J)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Long l) {
        invoke(l.longValue());
        return Unit.a;
    }

    public final void invoke(long j) {
        CountingRequestBody.access$updateProgress((CountingRequestBody) this.receiver, j);
    }
}
