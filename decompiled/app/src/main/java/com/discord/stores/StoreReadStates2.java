package com.discord.stores;

import kotlin.Metadata;
import kotlin.jvm.functions.Function9;
import rx.functions.Func9;

/* compiled from: StoreReadStates.kt */
@Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.stores.StoreReadStates$sam$rx_functions_Func9$0, reason: use source file name */
/* loaded from: classes2.dex */
public final class StoreReadStates2 implements Func9 {
    private final /* synthetic */ Function9 function;

    public StoreReadStates2(Function9 function9) {
        this.function = function9;
    }

    @Override // rx.functions.Func9
    public final /* synthetic */ Object call(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8, Object obj9) {
        return this.function.invoke(obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9);
    }
}
