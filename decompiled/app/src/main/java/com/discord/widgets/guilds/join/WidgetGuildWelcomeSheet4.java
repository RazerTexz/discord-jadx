package com.discord.widgets.guilds.join;

import d0.z.d.Lambda;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* compiled from: WidgetGuildWelcomeSheet.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"", "channelId", "", "index", "", "invoke", "(JI)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.guilds.join.WidgetGuildWelcomeSheet$configureWelcomeChannels$goToChannel$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetGuildWelcomeSheet4 extends Lambda implements Function2<Long, Integer, Unit> {
    public final /* synthetic */ long $guildId;
    public final /* synthetic */ List $welcomeChannels;
    public final /* synthetic */ WidgetGuildWelcomeSheet this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetGuildWelcomeSheet4(WidgetGuildWelcomeSheet widgetGuildWelcomeSheet, long j, List list) {
        super(2);
        this.this$0 = widgetGuildWelcomeSheet;
        this.$guildId = j;
        this.$welcomeChannels = list;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(Long l, Integer num) {
        invoke(l.longValue(), num.intValue());
        return Unit.a;
    }

    public final void invoke(long j, int i) {
        WidgetGuildWelcomeSheet.access$getViewModel$p(this.this$0).onClickChannel(this.$guildId, j, i, this.$welcomeChannels);
    }
}
