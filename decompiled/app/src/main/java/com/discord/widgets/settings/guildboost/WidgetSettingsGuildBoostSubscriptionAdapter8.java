package com.discord.widgets.settings.guildboost;

import com.discord.models.domain.ModelGuildBoostSlot;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* compiled from: WidgetSettingsGuildBoostSubscriptionAdapter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\b\u001a\u00020\u00052\u0006\u0010\u0001\u001a\u00020\u00002\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"Lcom/discord/models/domain/ModelGuildBoostSlot;", "<anonymous parameter 0>", "", "Lcom/discord/primitives/GuildId;", "<anonymous parameter 1>", "", "invoke", "(Lcom/discord/models/domain/ModelGuildBoostSlot;J)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.settings.guildboost.WidgetSettingsGuildBoostSubscriptionAdapter$transferListener$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetSettingsGuildBoostSubscriptionAdapter8 extends Lambda implements Function2<ModelGuildBoostSlot, Long, Unit> {
    public static final WidgetSettingsGuildBoostSubscriptionAdapter8 INSTANCE = new WidgetSettingsGuildBoostSubscriptionAdapter8();

    public WidgetSettingsGuildBoostSubscriptionAdapter8() {
        super(2);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(ModelGuildBoostSlot modelGuildBoostSlot, Long l) {
        invoke(modelGuildBoostSlot, l.longValue());
        return Unit.a;
    }

    public final void invoke(ModelGuildBoostSlot modelGuildBoostSlot, long j) {
        Intrinsics3.checkNotNullParameter(modelGuildBoostSlot, "<anonymous parameter 0>");
    }
}
