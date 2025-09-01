package com.discord.widgets.status;

import kotlin.Metadata;
import kotlin.jvm.functions.Function3;
import rx.functions.Func3;

/* compiled from: WidgetChatStatus.kt */
@Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.status.WidgetChatStatus$sam$rx_functions_Func3$0, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetChatStatus7 implements Func3 {
    private final /* synthetic */ Function3 function;

    public WidgetChatStatus7(Function3 function3) {
        this.function = function3;
    }

    @Override // rx.functions.Func3
    public final /* synthetic */ Object call(Object obj, Object obj2, Object obj3) {
        return this.function.invoke(obj, obj2, obj3);
    }
}
