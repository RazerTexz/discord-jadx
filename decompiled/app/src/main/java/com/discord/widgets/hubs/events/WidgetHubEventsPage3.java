package com.discord.widgets.hubs.events;

import kotlin.Metadata;

/* compiled from: WidgetHubEventsPage.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0004J\u0017\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H&¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\n\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H&¢\u0006\u0004\b\n\u0010\tJ\u0017\u0010\u000b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H&¢\u0006\u0004\b\u000b\u0010\tJ\u0017\u0010\f\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H&¢\u0006\u0004\b\f\u0010\t¨\u0006\r"}, d2 = {"Lcom/discord/widgets/hubs/events/HubEventsEventListener;", "", "", "dismissHeader", "()V", "fetchGuildScheduledEvents", "Lcom/discord/widgets/hubs/events/HubGuildScheduledEventData;", "eventData", "onSecondaryButtonClicked", "(Lcom/discord/widgets/hubs/events/HubGuildScheduledEventData;)V", "onPrimaryButtonClicked", "onCardClicked", "onShareClicked", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.hubs.events.HubEventsEventListener, reason: use source file name */
/* loaded from: classes2.dex */
public interface WidgetHubEventsPage3 {
    void dismissHeader();

    void fetchGuildScheduledEvents();

    void onCardClicked(WidgetHubEventsViewModel2 eventData);

    void onPrimaryButtonClicked(WidgetHubEventsViewModel2 eventData);

    void onSecondaryButtonClicked(WidgetHubEventsViewModel2 eventData);

    void onShareClicked(WidgetHubEventsViewModel2 eventData);
}
