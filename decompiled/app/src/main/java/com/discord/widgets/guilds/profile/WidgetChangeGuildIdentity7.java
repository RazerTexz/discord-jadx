package com.discord.widgets.guilds.profile;

import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import rx.functions.Action1;

/* compiled from: WidgetChangeGuildIdentity.kt */
@Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.guilds.profile.WidgetChangeGuildIdentity$sam$rx_functions_Action1$0, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetChangeGuildIdentity7 implements Action1 {
    private final /* synthetic */ Function1 function;

    public WidgetChangeGuildIdentity7(Function1 function1) {
        this.function = function1;
    }

    @Override // rx.functions.Action1
    public final /* synthetic */ void call(Object obj) {
        Intrinsics3.checkNotNullExpressionValue(this.function.invoke(obj), "invoke(...)");
    }
}
