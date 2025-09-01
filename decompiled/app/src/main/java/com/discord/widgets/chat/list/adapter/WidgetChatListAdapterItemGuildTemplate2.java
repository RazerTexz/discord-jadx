package com.discord.widgets.chat.list.adapter;

import androidx.core.app.NotificationCompat;
import com.discord.stores.StoreStream;
import com.discord.widgets.chat.list.entries.GuildTemplateEntry;
import kotlin.Metadata;
import rx.functions.Action0;

/* compiled from: WidgetChatListAdapterItemGuildTemplate.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", NotificationCompat.CATEGORY_CALL, "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemGuildTemplate$ModelProvider$get$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetChatListAdapterItemGuildTemplate2 implements Action0 {
    public final /* synthetic */ GuildTemplateEntry $item;

    public WidgetChatListAdapterItemGuildTemplate2(GuildTemplateEntry guildTemplateEntry) {
        this.$item = guildTemplateEntry;
    }

    @Override // rx.functions.Action0
    public final void call() {
        StoreStream.INSTANCE.getGuildTemplates().maybeInitTemplateState(this.$item.getGuildTemplateCode());
    }
}
