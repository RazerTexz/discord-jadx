package com.discord.stores;

import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import rx.functions.Func2;

/* compiled from: StoreAuthentication.kt */
@Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.stores.StoreAuthentication$sam$rx_functions_Func2$0, reason: use source file name */
/* loaded from: classes2.dex */
public final class StoreAuthentication6 implements Func2 {
    private final /* synthetic */ Function2 function;

    public StoreAuthentication6(Function2 function2) {
        this.function = function2;
    }

    @Override // rx.functions.Func2
    public final /* synthetic */ Object call(Object obj, Object obj2) {
        return this.function.invoke(obj, obj2);
    }
}
