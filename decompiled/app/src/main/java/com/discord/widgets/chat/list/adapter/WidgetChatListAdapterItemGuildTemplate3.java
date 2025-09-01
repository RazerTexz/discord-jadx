package com.discord.widgets.chat.list.adapter;

import androidx.core.app.NotificationCompat;
import com.discord.stores.StoreGuildTemplates;
import com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemGuildTemplate;
import j0.k.Func1;
import j0.l.e.ScalarSynchronousObservable;
import kotlin.Metadata;
import rx.Observable;

/* compiled from: WidgetChatListAdapterItemGuildTemplate.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0007\u001a*\u0012\u000e\b\u0001\u0012\n \u0001*\u0004\u0018\u00010\u00040\u0004 \u0001*\u0014\u0012\u000e\b\u0001\u0012\n \u0001*\u0004\u0018\u00010\u00040\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lcom/discord/stores/StoreGuildTemplates$GuildTemplateState;", "kotlin.jvm.PlatformType", "guildTemplateState", "Lrx/Observable;", "Lcom/discord/widgets/chat/list/adapter/WidgetChatListAdapterItemGuildTemplate$Model;", NotificationCompat.CATEGORY_CALL, "(Lcom/discord/stores/StoreGuildTemplates$GuildTemplateState;)Lrx/Observable;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemGuildTemplate$ModelProvider$get$2, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetChatListAdapterItemGuildTemplate3<T, R> implements Func1<StoreGuildTemplates.GuildTemplateState, Observable<? extends WidgetChatListAdapterItemGuildTemplate.Model>> {
    public static final WidgetChatListAdapterItemGuildTemplate3 INSTANCE = new WidgetChatListAdapterItemGuildTemplate3();

    @Override // j0.k.Func1
    public /* bridge */ /* synthetic */ Observable<? extends WidgetChatListAdapterItemGuildTemplate.Model> call(StoreGuildTemplates.GuildTemplateState guildTemplateState) {
        return call2(guildTemplateState);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends WidgetChatListAdapterItemGuildTemplate.Model> call2(StoreGuildTemplates.GuildTemplateState guildTemplateState) {
        return ((guildTemplateState instanceof StoreGuildTemplates.GuildTemplateState.Loading) || (guildTemplateState instanceof StoreGuildTemplates.GuildTemplateState.LoadFailed)) ? new ScalarSynchronousObservable(WidgetChatListAdapterItemGuildTemplate.Model.Loading.INSTANCE) : guildTemplateState instanceof StoreGuildTemplates.GuildTemplateState.Resolved ? new ScalarSynchronousObservable(new WidgetChatListAdapterItemGuildTemplate.Model.Resolved(((StoreGuildTemplates.GuildTemplateState.Resolved) guildTemplateState).getGuildTemplate())) : new ScalarSynchronousObservable(WidgetChatListAdapterItemGuildTemplate.Model.Invalid.INSTANCE);
    }
}
