package com.discord.widgets.chat.input;

import com.discord.widgets.chat.MessageManager;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: ChatInputViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/widgets/chat/MessageManager$MessageSendResult;", "messageSendResult", "", "invoke", "(Lcom/discord/widgets/chat/MessageManager$MessageSendResult;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class ChatInputViewModel$sendMessage$sendMessage$1$synchronousValidationSucceeded$1 extends Lambda implements Function1<MessageManager.MessageSendResult, Unit> {
    public final /* synthetic */ ChatInputViewModel$sendMessage$sendMessage$1 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChatInputViewModel$sendMessage$sendMessage$1$synchronousValidationSucceeded$1(ChatInputViewModel$sendMessage$sendMessage$1 chatInputViewModel$sendMessage$sendMessage$1) {
        super(1);
        this.this$0 = chatInputViewModel$sendMessage$sendMessage$1;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(MessageManager.MessageSendResult messageSendResult) {
        invoke2(messageSendResult);
        return Unit.a;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(MessageManager.MessageSendResult messageSendResult) {
        Intrinsics3.checkNotNullParameter(messageSendResult, "messageSendResult");
        this.this$0.$messageSendResultHandler.invoke(messageSendResult.getMessageResult(), messageSendResult.getGuild());
    }
}
