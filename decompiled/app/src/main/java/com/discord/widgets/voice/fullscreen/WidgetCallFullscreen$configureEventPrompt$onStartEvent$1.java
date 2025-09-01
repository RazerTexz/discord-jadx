package com.discord.widgets.voice.fullscreen;

import com.discord.api.guildscheduledevent.GuildScheduledEvent;
import com.discord.widgets.guildscheduledevent.GuildScheduledEventModel2;
import com.discord.widgets.guildscheduledevent.WidgetPreviewGuildScheduledEvent;
import d0.z.d.Lambda;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* compiled from: WidgetCallFullscreen.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final class WidgetCallFullscreen$configureEventPrompt$onStartEvent$1 extends Lambda implements Function0<Unit> {
    public final /* synthetic */ GuildScheduledEvent $startableEvent;
    public final /* synthetic */ WidgetCallFullscreen this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetCallFullscreen$configureEventPrompt$onStartEvent$1(WidgetCallFullscreen widgetCallFullscreen, GuildScheduledEvent guildScheduledEvent) {
        super(0);
        this.this$0 = widgetCallFullscreen;
        this.$startableEvent = guildScheduledEvent;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        if (this.$startableEvent == null) {
            return;
        }
        WidgetPreviewGuildScheduledEvent.Companion.launch$default(WidgetPreviewGuildScheduledEvent.INSTANCE, this.this$0.requireContext(), GuildScheduledEventModel2.toModel(this.$startableEvent), new WidgetPreviewGuildScheduledEvent.Companion.ExistingEventData(this.$startableEvent.getId(), WidgetPreviewGuildScheduledEvent.Companion.Action.START_EVENT), null, false, 24, null);
    }
}
