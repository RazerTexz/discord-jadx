package com.discord.widgets.servers.guildboost;

import d0.z.d.Lambda;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* compiled from: WidgetGuildBoost.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.servers.guildboost.WidgetGuildBoost$choosePlanLauncher$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetGuildBoost3 extends Lambda implements Function0<Unit> {
    public final /* synthetic */ WidgetGuildBoost this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetGuildBoost3(WidgetGuildBoost widgetGuildBoost) {
        super(0);
        this.this$0 = widgetGuildBoost;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        WidgetGuildBoost.access$fetchData(this.this$0);
    }
}
