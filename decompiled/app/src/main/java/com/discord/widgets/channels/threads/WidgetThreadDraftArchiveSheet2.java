package com.discord.widgets.channels.threads;

import androidx.core.app.NotificationCompat;
import com.discord.api.channel.Channel;
import com.discord.models.guild.Guild;
import com.discord.stores.StoreThreadDraft;
import com.discord.widgets.channels.threads.WidgetThreadDraftArchiveSheet;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import rx.functions.Func3;

/* compiled from: WidgetThreadDraftArchiveSheet.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\n\u001a\n \u0001*\u0004\u0018\u00010\u00070\u00072\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u00002\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\n¢\u0006\u0004\b\b\u0010\t"}, d2 = {"Lcom/discord/stores/StoreThreadDraft$ThreadDraftState;", "kotlin.jvm.PlatformType", "draftState", "Lcom/discord/models/guild/Guild;", "guild", "Lcom/discord/api/channel/Channel;", "channel", "Lcom/discord/widgets/channels/threads/WidgetThreadDraftArchiveSheet$Model;", NotificationCompat.CATEGORY_CALL, "(Lcom/discord/stores/StoreThreadDraft$ThreadDraftState;Lcom/discord/models/guild/Guild;Lcom/discord/api/channel/Channel;)Lcom/discord/widgets/channels/threads/WidgetThreadDraftArchiveSheet$Model;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.channels.threads.WidgetThreadDraftArchiveSheet$Model$Companion$get$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetThreadDraftArchiveSheet2<T1, T2, T3, R> implements Func3<StoreThreadDraft.ThreadDraftState, Guild, Channel, WidgetThreadDraftArchiveSheet.Model> {
    public static final WidgetThreadDraftArchiveSheet2 INSTANCE = new WidgetThreadDraftArchiveSheet2();

    @Override // rx.functions.Func3
    public /* bridge */ /* synthetic */ WidgetThreadDraftArchiveSheet.Model call(StoreThreadDraft.ThreadDraftState threadDraftState, Guild guild, Channel channel) {
        return call2(threadDraftState, guild, channel);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final WidgetThreadDraftArchiveSheet.Model call2(StoreThreadDraft.ThreadDraftState threadDraftState, Guild guild, Channel channel) {
        Intrinsics3.checkNotNullExpressionValue(threadDraftState, "draftState");
        return new WidgetThreadDraftArchiveSheet.Model(threadDraftState, guild, channel);
    }
}
