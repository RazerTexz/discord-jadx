package com.discord.widgets.chat.list.adapter;

import com.discord.api.message.reaction.MessageReactionUpdate;
import com.discord.widgets.chat.list.adapter.WidgetChatListAdapterEventsHandler;
import d0.t.CollectionsJVM;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: WidgetChatListAdapterEventsHandler.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/api/message/reaction/MessageReactionUpdate;", "reactionUpdate", "", "invoke", "(Lcom/discord/api/message/reaction/MessageReactionUpdate;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterEventsHandler$UserReactionHandler$commitReactionAdd$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetChatListAdapterEventsHandler3 extends Lambda implements Function1<MessageReactionUpdate, Unit> {
    public final /* synthetic */ WidgetChatListAdapterEventsHandler.UserReactionHandler this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChatListAdapterEventsHandler3(WidgetChatListAdapterEventsHandler.UserReactionHandler userReactionHandler) {
        super(1);
        this.this$0 = userReactionHandler;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(MessageReactionUpdate messageReactionUpdate) {
        invoke2(messageReactionUpdate);
        return Unit.a;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(MessageReactionUpdate messageReactionUpdate) {
        Intrinsics3.checkNotNullParameter(messageReactionUpdate, "reactionUpdate");
        WidgetChatListAdapterEventsHandler.UserReactionHandler.access$getStoreMessages$p(this.this$0).handleReactionUpdate(CollectionsJVM.listOf(messageReactionUpdate), true);
    }
}
