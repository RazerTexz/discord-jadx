package com.discord.widgets.channels.list;

import com.discord.models.guild.Guild;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: WidgetChannelsListAdapter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/models/guild/Guild;", "it", "", "invoke", "(Lcom/discord/models/guild/Guild;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class WidgetChannelsListAdapter$onViewGuildScheduledEvents$1 extends Lambda implements Function1<Guild, Unit> {
    public static final WidgetChannelsListAdapter$onViewGuildScheduledEvents$1 INSTANCE = new WidgetChannelsListAdapter$onViewGuildScheduledEvents$1();

    public WidgetChannelsListAdapter$onViewGuildScheduledEvents$1() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Guild guild) {
        invoke2(guild);
        return Unit.a;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Guild guild) {
        Intrinsics3.checkNotNullParameter(guild, "it");
    }
}
