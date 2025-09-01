package com.discord.stores;

import d0.z.d.FunctionReferenceImpl;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* compiled from: StoreMediaEngine.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final /* synthetic */ class StoreMediaEngine$localVoiceStatus$1 extends FunctionReferenceImpl implements Function0<Unit> {
    public StoreMediaEngine$localVoiceStatus$1(StoreMediaEngine storeMediaEngine) {
        super(0, storeMediaEngine, StoreMediaEngine.class, "enableLocalVoiceStatusListening", "enableLocalVoiceStatusListening()V", 0);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        StoreMediaEngine.access$enableLocalVoiceStatusListening((StoreMediaEngine) this.receiver);
    }
}
