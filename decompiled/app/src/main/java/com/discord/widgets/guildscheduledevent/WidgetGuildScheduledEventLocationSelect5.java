package com.discord.widgets.guildscheduledevent;

import d0.z.d.Lambda;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

/* compiled from: WidgetGuildScheduledEventLocationSelect.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lcom/discord/widgets/guildscheduledevent/GuildScheduledEventDirectoryAssociationViewModel;", "invoke", "()Lcom/discord/widgets/guildscheduledevent/GuildScheduledEventDirectoryAssociationViewModel;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.guildscheduledevent.WidgetGuildScheduledEventLocationSelect$hubViewModel$2, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetGuildScheduledEventLocationSelect5 extends Lambda implements Function0<GuildScheduledEventDirectoryAssociationViewModel> {
    public final /* synthetic */ WidgetGuildScheduledEventLocationSelect this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetGuildScheduledEventLocationSelect5(WidgetGuildScheduledEventLocationSelect widgetGuildScheduledEventLocationSelect) {
        super(0);
        this.this$0 = widgetGuildScheduledEventLocationSelect;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ GuildScheduledEventDirectoryAssociationViewModel invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final GuildScheduledEventDirectoryAssociationViewModel invoke() {
        return new GuildScheduledEventDirectoryAssociationViewModel(WidgetGuildScheduledEventLocationSelect.access$getGuildId$p(this.this$0), WidgetGuildScheduledEventLocationSelect.access$getExistingGuildScheduledEventId$p(this.this$0), null, null, 12, null);
    }
}
