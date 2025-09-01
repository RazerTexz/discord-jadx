package com.discord.widgets.hubs.events;

import androidx.fragment.app.FragmentManager;
import com.discord.analytics.utils.hubs.HubGuildScheduledEventClickType;
import com.discord.utilities.directories.DirectoryUtils;
import com.discord.utilities.guildscheduledevent.GuildScheduledEventUtilities;
import com.discord.utilities.guildscheduledevent.GuildScheduledEventUtilities5;
import com.discord.widgets.guildscheduledevent.WidgetGuildScheduledEventDetailsBottomSheet;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: WidgetHubEventsPage.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0004J\u0017\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\n\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\n\u0010\tJ\u0017\u0010\u000b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u000b\u0010\tJ\u0017\u0010\f\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\f\u0010\t¨\u0006\r"}, d2 = {"com/discord/widgets/hubs/events/WidgetHubEventsPage$listener$1", "Lcom/discord/widgets/hubs/events/HubEventsEventListener;", "", "dismissHeader", "()V", "fetchGuildScheduledEvents", "Lcom/discord/widgets/hubs/events/HubGuildScheduledEventData;", "eventData", "onSecondaryButtonClicked", "(Lcom/discord/widgets/hubs/events/HubGuildScheduledEventData;)V", "onPrimaryButtonClicked", "onCardClicked", "onShareClicked", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.hubs.events.WidgetHubEventsPage$listener$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetHubEventsPage6 implements WidgetHubEventsPage3 {
    public final /* synthetic */ WidgetHubEventsPage this$0;

    public WidgetHubEventsPage6(WidgetHubEventsPage widgetHubEventsPage) {
        this.this$0 = widgetHubEventsPage;
    }

    @Override // com.discord.widgets.hubs.events.WidgetHubEventsPage3
    public void dismissHeader() {
        this.this$0.getViewModel().dismissHeader();
    }

    @Override // com.discord.widgets.hubs.events.WidgetHubEventsPage3
    public void fetchGuildScheduledEvents() {
        this.this$0.getViewModel().fetchGuildScheduledEvents();
    }

    @Override // com.discord.widgets.hubs.events.WidgetHubEventsPage3
    public void onCardClicked(WidgetHubEventsViewModel2 eventData) {
        Intrinsics3.checkNotNullParameter(eventData, "eventData");
        DirectoryUtils.INSTANCE.logGuildScheduledEventClickAction(eventData.getEvent().getId(), eventData.getEvent().getGuildId(), this.this$0.getArgs().getGuildId(), HubGuildScheduledEventClickType.JoinServer);
        WidgetGuildScheduledEventDetailsBottomSheet.Companion companion = WidgetGuildScheduledEventDetailsBottomSheet.INSTANCE;
        FragmentManager parentFragmentManager = this.this$0.getParentFragmentManager();
        Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
        companion.showForDirectory(parentFragmentManager, eventData.getEvent().getId(), this.this$0.getArgs().getGuildId(), this.this$0.getArgs().getDirectoryChannelId());
    }

    @Override // com.discord.widgets.hubs.events.WidgetHubEventsPage3
    public void onPrimaryButtonClicked(WidgetHubEventsViewModel2 eventData) {
        Intrinsics3.checkNotNullParameter(eventData, "eventData");
        DirectoryUtils.INSTANCE.maybeJoinAndGoToGuild(this.this$0, eventData.getEvent(), eventData.isInGuild(), this.this$0.getArgs().getGuildId(), this.this$0.getArgs().getDirectoryChannelId(), !eventData.isRsvped() && GuildScheduledEventUtilities5.canRsvp(eventData.getEvent()), new WidgetHubEventsPage7(this, eventData));
    }

    @Override // com.discord.widgets.hubs.events.WidgetHubEventsPage3
    public void onSecondaryButtonClicked(WidgetHubEventsViewModel2 eventData) {
        Intrinsics3.checkNotNullParameter(eventData, "eventData");
        this.this$0.getViewModel().toggleRsvp(eventData.getEvent());
    }

    @Override // com.discord.widgets.hubs.events.WidgetHubEventsPage3
    public void onShareClicked(WidgetHubEventsViewModel2 eventData) {
        Intrinsics3.checkNotNullParameter(eventData, "eventData");
        long guildId = eventData.getEvent().getGuildId();
        long id2 = eventData.getEvent().getId();
        Long channelId = eventData.getEvent().getChannelId();
        GuildScheduledEventUtilities.Companion companion = GuildScheduledEventUtilities.INSTANCE;
        companion.launchInvite(GuildScheduledEventUtilities.Companion.canShareEvent$default(companion, channelId, guildId, null, null, null, null, 60, null), this.this$0, guildId, eventData.getChannel(), id2);
    }
}
