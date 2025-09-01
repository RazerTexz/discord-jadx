package com.discord.widgets.chat.input;

import com.discord.widgets.chat.input.ChatInputViewModel;
import d0.z.d.Lambda;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import rx.subjects.PublishSubject;

/* compiled from: ChatInputViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "currentCharacterCount", "maxCharacterCount", "", "invoke", "(II)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class ChatInputViewModel$sendMessage$onMessageTooLong$1 extends Lambda implements Function2<Integer, Integer, Unit> {
    public final /* synthetic */ ChatInputViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChatInputViewModel$sendMessage$onMessageTooLong$1(ChatInputViewModel chatInputViewModel) {
        super(2);
        this.this$0 = chatInputViewModel;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(Integer num, Integer num2) {
        invoke(num.intValue(), num2.intValue());
        return Unit.a;
    }

    public final void invoke(int i, int i2) {
        PublishSubject publishSubjectAccess$getEventSubject$p = ChatInputViewModel.access$getEventSubject$p(this.this$0);
        publishSubjectAccess$getEventSubject$p.k.onNext(new ChatInputViewModel.Event.MessageTooLong(i, i2));
    }
}
