package com.discord.widgets.channels;

import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import rx.functions.Func2;

/* compiled from: WidgetGroupInviteFriends.kt */
@Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class WidgetGroupInviteFriends$sam$rx_functions_Func2$0 implements Func2 {
    private final /* synthetic */ Function2 function;

    public WidgetGroupInviteFriends$sam$rx_functions_Func2$0(Function2 function2) {
        this.function = function2;
    }

    @Override // rx.functions.Func2
    public final /* synthetic */ Object call(Object obj, Object obj2) {
        return this.function.invoke(obj, obj2);
    }
}
