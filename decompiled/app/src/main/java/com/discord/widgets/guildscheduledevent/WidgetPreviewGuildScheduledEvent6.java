package com.discord.widgets.guildscheduledevent;

import com.discord.widgets.guildscheduledevent.WidgetPreviewGuildScheduledEvent;
import d0.z.d.Lambda;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

/* compiled from: WidgetPreviewGuildScheduledEvent.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lcom/discord/widgets/guildscheduledevent/PreviewGuildScheduledEventViewModel;", "invoke", "()Lcom/discord/widgets/guildscheduledevent/PreviewGuildScheduledEventViewModel;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.guildscheduledevent.WidgetPreviewGuildScheduledEvent$viewModel$2, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetPreviewGuildScheduledEvent6 extends Lambda implements Function0<PreviewGuildScheduledEventViewModel> {
    public final /* synthetic */ WidgetPreviewGuildScheduledEvent this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetPreviewGuildScheduledEvent6(WidgetPreviewGuildScheduledEvent widgetPreviewGuildScheduledEvent) {
        super(0);
        this.this$0 = widgetPreviewGuildScheduledEvent;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ PreviewGuildScheduledEventViewModel invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final PreviewGuildScheduledEventViewModel invoke() {
        return new PreviewGuildScheduledEventViewModel(WidgetPreviewGuildScheduledEvent.access$getEventModel$p(this.this$0), (WidgetPreviewGuildScheduledEvent.Companion.ExistingEventData) this.this$0.getMostRecentIntent().getSerializableExtra("INTENT_EXTRA_EXISTING_EVENT_DATA"), null, null, null, 28, null);
    }
}
