package com.discord.widgets.settings.guildboost;

import d0.z.d.Lambda;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: WidgetSettingsGuildBoostSubscriptionAdapter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\n\u0010\u0002\u001a\u00060\u0000j\u0002`\u0001H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "Lcom/discord/primitives/GuildBoostSlotId;", "it", "", "invoke", "(J)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.settings.guildboost.WidgetSettingsGuildBoostSubscriptionAdapter$subscribeListener$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetSettingsGuildBoostSubscriptionAdapter7 extends Lambda implements Function1<Long, Unit> {
    public static final WidgetSettingsGuildBoostSubscriptionAdapter7 INSTANCE = new WidgetSettingsGuildBoostSubscriptionAdapter7();

    public WidgetSettingsGuildBoostSubscriptionAdapter7() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Long l) {
        invoke(l.longValue());
        return Unit.a;
    }

    public final void invoke(long j) {
    }
}
