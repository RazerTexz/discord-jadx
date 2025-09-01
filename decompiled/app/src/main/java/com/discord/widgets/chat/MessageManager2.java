package com.discord.widgets.chat;

import b.a.d.AppToast;
import com.discord.R;
import com.discord.utilities.messagesend.MessageQueue4;
import com.discord.utilities.rest.SendUtils;
import com.discord.widgets.chat.MessageManager;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: MessageManager.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/widgets/chat/MessageManager$MessageSendResult;", "messageSendResult", "", "invoke", "(Lcom/discord/widgets/chat/MessageManager$MessageSendResult;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.chat.MessageManager$defaultMessageResultHandler$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class MessageManager2 extends Lambda implements Function1<MessageManager.MessageSendResult, Unit> {
    public final /* synthetic */ MessageManager this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MessageManager2(MessageManager messageManager) {
        super(1);
        this.this$0 = messageManager;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(MessageManager.MessageSendResult messageSendResult) {
        invoke2(messageSendResult);
        return Unit.a;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(MessageManager.MessageSendResult messageSendResult) {
        Intrinsics3.checkNotNullParameter(messageSendResult, "messageSendResult");
        MessageQueue4 messageResult = messageSendResult.getMessageResult();
        if (messageResult instanceof MessageQueue4.CaptchaRequired) {
            SendUtils.INSTANCE.handleCaptchaRequired((MessageQueue4.CaptchaRequired) messageResult);
        } else if (messageResult instanceof MessageQueue4.UnknownFailure) {
            SendUtils.handleSendError$default(SendUtils.INSTANCE, ((MessageQueue4.UnknownFailure) messageResult).getError(), MessageManager.access$getContext$p(this.this$0), null, null, 12, null);
        } else if (messageResult instanceof MessageQueue4.Slowmode) {
            AppToast.g(MessageManager.access$getContext$p(this.this$0), R.string.channel_slowmode_desc_short, 0, null, 12);
        }
    }
}
