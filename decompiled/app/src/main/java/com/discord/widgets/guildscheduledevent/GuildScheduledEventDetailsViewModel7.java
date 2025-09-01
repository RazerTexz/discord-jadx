package com.discord.widgets.guildscheduledevent;

import com.discord.api.guildscheduledevent.GuildScheduledEvent;
import com.discord.widgets.guildscheduledevent.GuildScheduledEventRsvpUserListItem;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* compiled from: GuildScheduledEventDetailsViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/widgets/guildscheduledevent/GuildScheduledEventUser;", "guildScheduledEventUser", "Lcom/discord/widgets/guildscheduledevent/GuildScheduledEventRsvpUserListItem$RsvpUser;", "invoke", "(Lcom/discord/widgets/guildscheduledevent/GuildScheduledEventUser;)Lcom/discord/widgets/guildscheduledevent/GuildScheduledEventRsvpUserListItem$RsvpUser;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.guildscheduledevent.GuildScheduledEventDetailsViewModel$Companion$observeStores$1$rsvpUsers$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class GuildScheduledEventDetailsViewModel7 extends Lambda implements Function1<GuildScheduledEventUser, GuildScheduledEventRsvpUserListItem.RsvpUser> {
    public final /* synthetic */ GuildScheduledEvent $guildScheduledEvent;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildScheduledEventDetailsViewModel7(GuildScheduledEvent guildScheduledEvent) {
        super(1);
        this.$guildScheduledEvent = guildScheduledEvent;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ GuildScheduledEventRsvpUserListItem.RsvpUser invoke(GuildScheduledEventUser guildScheduledEventUser) {
        return invoke2(guildScheduledEventUser);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final GuildScheduledEventRsvpUserListItem.RsvpUser invoke2(GuildScheduledEventUser guildScheduledEventUser) {
        Intrinsics3.checkNotNullParameter(guildScheduledEventUser, "guildScheduledEventUser");
        return GuildScheduledEventRsvpUserListItem.RsvpUser.INSTANCE.from(guildScheduledEventUser, this.$guildScheduledEvent.getGuildId());
    }
}
