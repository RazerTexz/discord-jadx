package com.discord.widgets.channels.threads.browser;

import androidx.core.app.NotificationCompat;
import com.discord.api.channel.Channel;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.guild.Guild;
import com.discord.widgets.channels.threads.browser.WidgetThreadBrowserViewModel;
import kotlin.Metadata;
import rx.functions.Func3;

/* compiled from: WidgetThreadBrowserViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u000b\u001a\n \b*\u0004\u0018\u00010\u00070\u00072\b\u0010\u0001\u001a\u0004\u0018\u00010\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u000e\u0010\u0006\u001a\n\u0018\u00010\u0004j\u0004\u0018\u0001`\u0005H\n¢\u0006\u0004\b\t\u0010\n"}, d2 = {"Lcom/discord/api/channel/Channel;", "channel", "Lcom/discord/models/guild/Guild;", "guild", "", "Lcom/discord/api/permission/PermissionBit;", ModelAuditLogEntry.CHANGE_KEY_PERMISSIONS, "Lcom/discord/widgets/channels/threads/browser/WidgetThreadBrowserViewModel$StoreState;", "kotlin.jvm.PlatformType", NotificationCompat.CATEGORY_CALL, "(Lcom/discord/api/channel/Channel;Lcom/discord/models/guild/Guild;Ljava/lang/Long;)Lcom/discord/widgets/channels/threads/browser/WidgetThreadBrowserViewModel$StoreState;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.channels.threads.browser.WidgetThreadBrowserViewModel$Companion$observeStoreState$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetThreadBrowserViewModel2<T1, T2, T3, R> implements Func3<Channel, Guild, Long, WidgetThreadBrowserViewModel.StoreState> {
    public static final WidgetThreadBrowserViewModel2 INSTANCE = new WidgetThreadBrowserViewModel2();

    @Override // rx.functions.Func3
    public /* bridge */ /* synthetic */ WidgetThreadBrowserViewModel.StoreState call(Channel channel, Guild guild, Long l) {
        return call2(channel, guild, l);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final WidgetThreadBrowserViewModel.StoreState call2(Channel channel, Guild guild, Long l) {
        return new WidgetThreadBrowserViewModel.StoreState(channel, guild, l);
    }
}
