package com.discord.widgets.mobile_reports;

import androidx.core.app.NotificationCompat;
import com.discord.api.channel.Channel;
import com.discord.api.directory.DirectoryEntryGuild;
import com.discord.api.guildscheduledevent.GuildScheduledEvent;
import com.discord.api.stageinstance.StageInstance;
import com.discord.models.guild.Guild;
import com.discord.models.message.Message;
import com.discord.stores.utilities.RestCallState;
import com.discord.widgets.mobile_reports.MobileReportsViewModel;
import com.discord.widgets.mobile_reports.WidgetMobileReports2;
import d0.z.d.Intrinsics3;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import rx.functions.Func8;

/* compiled from: MobileReportsViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u001a\u001a\n \u000e*\u0004\u0018\u00010\u00170\u00172\u000e\u0010\u0002\u001a\n\u0018\u00010\u0000j\u0004\u0018\u0001`\u00012\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u000726\u0010\u000f\u001a2\u0012\b\u0012\u00060\nj\u0002`\u000b\u0012\b\u0012\u00060\fj\u0002`\r \u000e*\u0018\u0012\b\u0012\u00060\nj\u0002`\u000b\u0012\b\u0012\u00060\fj\u0002`\r\u0018\u00010\t0\t2\u0014\u0010\u0013\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u0011\u0018\u00010\u00102\b\u0010\u0015\u001a\u0004\u0018\u00010\u00142\b\u0010\u0016\u001a\u0004\u0018\u00010\u0005H\n¢\u0006\u0004\b\u0018\u0010\u0019"}, d2 = {"Lcom/discord/models/message/Message;", "Lcom/discord/stores/ClientMessage;", "message", "Lcom/discord/api/channel/Channel;", "channel", "Lcom/discord/models/guild/Guild;", "guild", "Lcom/discord/api/stageinstance/StageInstance;", "stageInstance", "", "", "Lcom/discord/primitives/UserId;", "", "Lcom/discord/primitives/RelationshipType;", "kotlin.jvm.PlatformType", "blockedUsers", "Lcom/discord/stores/utilities/RestCallState;", "", "Lcom/discord/api/directory/DirectoryEntryGuild;", "directories", "Lcom/discord/api/guildscheduledevent/GuildScheduledEvent;", "event", "eventGuild", "Lcom/discord/widgets/mobile_reports/MobileReportsViewModel$StoreState;", NotificationCompat.CATEGORY_CALL, "(Lcom/discord/models/message/Message;Lcom/discord/api/channel/Channel;Lcom/discord/models/guild/Guild;Lcom/discord/api/stageinstance/StageInstance;Ljava/util/Map;Lcom/discord/stores/utilities/RestCallState;Lcom/discord/api/guildscheduledevent/GuildScheduledEvent;Lcom/discord/models/guild/Guild;)Lcom/discord/widgets/mobile_reports/MobileReportsViewModel$StoreState;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.mobile_reports.MobileReportsViewModel$Companion$getStoreState$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class MobileReportsViewModel2<T1, T2, T3, T4, T5, T6, T7, T8, R> implements Func8<Message, Channel, Guild, StageInstance, Map<Long, ? extends Integer>, RestCallState<? extends List<? extends DirectoryEntryGuild>>, GuildScheduledEvent, Guild, MobileReportsViewModel.StoreState> {
    public final /* synthetic */ WidgetMobileReports2 $args;

    public MobileReportsViewModel2(WidgetMobileReports2 widgetMobileReports2) {
        this.$args = widgetMobileReports2;
    }

    @Override // rx.functions.Func8
    public /* bridge */ /* synthetic */ MobileReportsViewModel.StoreState call(Message message, Channel channel, Guild guild, StageInstance stageInstance, Map<Long, ? extends Integer> map, RestCallState<? extends List<? extends DirectoryEntryGuild>> restCallState, GuildScheduledEvent guildScheduledEvent, Guild guild2) {
        return call2(message, channel, guild, stageInstance, (Map<Long, Integer>) map, (RestCallState<? extends List<DirectoryEntryGuild>>) restCallState, guildScheduledEvent, guild2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final MobileReportsViewModel.StoreState call2(Message message, Channel channel, Guild guild, StageInstance stageInstance, Map<Long, Integer> map, RestCallState<? extends List<DirectoryEntryGuild>> restCallState, GuildScheduledEvent guildScheduledEvent, Guild guild2) {
        List<DirectoryEntryGuild> listInvoke;
        WidgetMobileReports2 widgetMobileReports2 = this.$args;
        DirectoryEntryGuild directoryEntryGuild = null;
        if (!(widgetMobileReports2 instanceof WidgetMobileReports2.DirectoryServer)) {
            widgetMobileReports2 = null;
        }
        WidgetMobileReports2.DirectoryServer directoryServer = (WidgetMobileReports2.DirectoryServer) widgetMobileReports2;
        Long lValueOf = directoryServer != null ? Long.valueOf(directoryServer.getGuildId()) : null;
        Guild guild3 = guild != null ? guild : guild2;
        Intrinsics3.checkNotNullExpressionValue(map, "blockedUsers");
        if (restCallState != null && (listInvoke = restCallState.invoke()) != null) {
            Iterator<T> it = listInvoke.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Object next = it.next();
                if (lValueOf != null && ((DirectoryEntryGuild) next).getGuild().getId() == lValueOf.longValue()) {
                    directoryEntryGuild = next;
                    break;
                }
            }
            directoryEntryGuild = directoryEntryGuild;
        }
        return new MobileReportsViewModel.StoreState(message, channel, guild3, directoryEntryGuild, stageInstance, map, guildScheduledEvent);
    }
}
