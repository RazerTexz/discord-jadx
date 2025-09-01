package com.discord.widgets.chat.list.adapter;

import com.discord.api.message.reaction.MessageReaction;
import com.discord.widgets.chat.list.adapter.WidgetChatListAdapterEventsHandler;
import d0.z.d.Lambda;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: WidgetChatListAdapterEventsHandler.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Ljava/lang/Void;", "it", "", "invoke", "(Ljava/lang/Void;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterEventsHandler$UserReactionHandler$requestReactionUpdate$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetChatListAdapterEventsHandler5 extends Lambda implements Function1<Void, Unit> {
    public final /* synthetic */ MessageReaction $reaction;
    public final /* synthetic */ WidgetChatListAdapterEventsHandler.UserReactionHandler this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChatListAdapterEventsHandler5(WidgetChatListAdapterEventsHandler.UserReactionHandler userReactionHandler, MessageReaction messageReaction) {
        super(1);
        this.this$0 = userReactionHandler;
        this.$reaction = messageReaction;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Void r1) {
        invoke2(r1);
        return Unit.a;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Void r2) {
        if (this.$reaction.getMe()) {
            return;
        }
        WidgetChatListAdapterEventsHandler.UserReactionHandler.access$getStoreEmoji$p(this.this$0).onEmojiUsed(this.$reaction.getEmoji().c());
    }
}
