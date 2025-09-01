package com.discord.widgets.settings.guildboost;

import d0.z.d.Lambda;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* compiled from: WidgetSettingsGuildBoostSubscriptionAdapter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\b\u001a\u00020\u00052\n\u0010\u0002\u001a\u00060\u0000j\u0002`\u00012\u0006\u0010\u0004\u001a\u00020\u0003H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"", "Lcom/discord/primitives/GuildBoostSlotId;", "<anonymous parameter 0>", "", "<anonymous parameter 1>", "", "invoke", "(JZ)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.settings.guildboost.WidgetSettingsGuildBoostSubscriptionAdapter$cancelListener$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetSettingsGuildBoostSubscriptionAdapter6 extends Lambda implements Function2<Long, Boolean, Unit> {
    public static final WidgetSettingsGuildBoostSubscriptionAdapter6 INSTANCE = new WidgetSettingsGuildBoostSubscriptionAdapter6();

    public WidgetSettingsGuildBoostSubscriptionAdapter6() {
        super(2);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(Long l, Boolean bool) {
        invoke(l.longValue(), bool.booleanValue());
        return Unit.a;
    }

    public final void invoke(long j, boolean z2) {
    }
}
