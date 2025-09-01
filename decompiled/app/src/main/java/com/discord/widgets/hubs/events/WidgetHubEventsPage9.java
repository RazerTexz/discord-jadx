package com.discord.widgets.hubs.events;

import d0.z.d.Lambda;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

/* compiled from: WidgetHubEventsPage.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lcom/discord/widgets/hubs/events/WidgetHubEventsViewModel;", "invoke", "()Lcom/discord/widgets/hubs/events/WidgetHubEventsViewModel;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.hubs.events.WidgetHubEventsPage$viewModel$2, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetHubEventsPage9 extends Lambda implements Function0<WidgetHubEventsViewModel> {
    public final /* synthetic */ WidgetHubEventsPage this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetHubEventsPage9(WidgetHubEventsPage widgetHubEventsPage) {
        super(0);
        this.this$0 = widgetHubEventsPage;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ WidgetHubEventsViewModel invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final WidgetHubEventsViewModel invoke() {
        return new WidgetHubEventsViewModel(this.this$0.getArgs().getGuildId(), this.this$0.getArgs().getDirectoryChannelId(), null, null, null, null, null, null, null, 508, null);
    }
}
