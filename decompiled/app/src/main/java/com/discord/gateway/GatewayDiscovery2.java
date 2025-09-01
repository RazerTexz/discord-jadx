package com.discord.gateway;

import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import rx.functions.Action1;

/* compiled from: GatewayDiscovery.kt */
@Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.gateway.GatewayDiscovery$sam$rx_functions_Action1$0, reason: use source file name */
/* loaded from: classes.dex */
public final class GatewayDiscovery2 implements Action1 {
    private final /* synthetic */ Function1 function;

    public GatewayDiscovery2(Function1 function1) {
        this.function = function1;
    }

    @Override // rx.functions.Action1
    public final /* synthetic */ void call(Object obj) {
        Intrinsics3.checkNotNullExpressionValue(this.function.invoke(obj), "invoke(...)");
    }
}
