package com.discord.widgets.chat.list.adapter;

import androidx.core.app.NotificationCompat;
import com.discord.stores.StoreInstantInvites;
import com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemInvite;
import com.discord.widgets.chat.list.entries.InviteEntry;
import j0.k.Func1;
import j0.l.e.ScalarSynchronousObservable;
import kotlin.Metadata;
import rx.Observable;

/* compiled from: WidgetChatListAdapterItemInvite.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0007\u001a*\u0012\u000e\b\u0001\u0012\n \u0001*\u0004\u0018\u00010\u00040\u0004 \u0001*\u0014\u0012\u000e\b\u0001\u0012\n \u0001*\u0004\u0018\u00010\u00040\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lcom/discord/stores/StoreInstantInvites$InviteState;", "kotlin.jvm.PlatformType", "inviteState", "Lrx/Observable;", "Lcom/discord/widgets/chat/list/adapter/WidgetChatListAdapterItemInvite$Model;", NotificationCompat.CATEGORY_CALL, "(Lcom/discord/stores/StoreInstantInvites$InviteState;)Lrx/Observable;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemInvite$ModelProvider$get$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetChatListAdapterItemInvite2<T, R> implements Func1<StoreInstantInvites.InviteState, Observable<? extends WidgetChatListAdapterItemInvite.Model>> {
    public final /* synthetic */ InviteEntry $item;

    public WidgetChatListAdapterItemInvite2(InviteEntry inviteEntry) {
        this.$item = inviteEntry;
    }

    @Override // j0.k.Func1
    public /* bridge */ /* synthetic */ Observable<? extends WidgetChatListAdapterItemInvite.Model> call(StoreInstantInvites.InviteState inviteState) {
        return call2(inviteState);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends WidgetChatListAdapterItemInvite.Model> call2(StoreInstantInvites.InviteState inviteState) {
        return ((inviteState instanceof StoreInstantInvites.InviteState.Loading) || (inviteState instanceof StoreInstantInvites.InviteState.LoadFailed)) ? new ScalarSynchronousObservable(WidgetChatListAdapterItemInvite.Model.Loading.INSTANCE) : inviteState instanceof StoreInstantInvites.InviteState.Resolved ? WidgetChatListAdapterItemInvite.ModelProvider.access$observeModel(WidgetChatListAdapterItemInvite.ModelProvider.INSTANCE, this.$item, ((StoreInstantInvites.InviteState.Resolved) inviteState).getInvite()) : WidgetChatListAdapterItemInvite.ModelProvider.access$getInvalidInvite(WidgetChatListAdapterItemInvite.ModelProvider.INSTANCE, this.$item);
    }
}
