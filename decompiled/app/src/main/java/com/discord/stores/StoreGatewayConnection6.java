package com.discord.stores;

import kotlin.Metadata;
import kotlin.jvm.functions.Function5;
import rx.functions.Func5;

/* compiled from: StoreGatewayConnection.kt */
@Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.stores.StoreGatewayConnection$sam$rx_functions_Func5$0, reason: use source file name */
/* loaded from: classes2.dex */
public final class StoreGatewayConnection6 implements Func5 {
    private final /* synthetic */ Function5 function;

    public StoreGatewayConnection6(Function5 function5) {
        this.function = function5;
    }

    @Override // rx.functions.Func5
    public final /* synthetic */ Object call(Object obj, Object obj2, Object obj3, Object obj4, Object obj5) {
        return this.function.invoke(obj, obj2, obj3, obj4, obj5);
    }
}
