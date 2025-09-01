package com.discord.widgets.chat.input;

import com.discord.widgets.chat.input.ChatInputViewModel;
import d0.z.d.Lambda;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import rx.subjects.PublishSubject;

/* compiled from: ChatInputViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"", "maxFileSizeMB", "", "isUserPremium", "", "invoke", "(IZ)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class ChatInputViewModel$sendCommand$validated$3 extends Lambda implements Function2<Integer, Boolean, Unit> {
    public final /* synthetic */ ChatInputViewModel.AttachmentContext $attachmentsContext;
    public final /* synthetic */ Function0 $commandResendCompressedHandler;
    public final /* synthetic */ ChatInputViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChatInputViewModel$sendCommand$validated$3(ChatInputViewModel chatInputViewModel, ChatInputViewModel.AttachmentContext attachmentContext, Function0 function0) {
        super(2);
        this.this$0 = chatInputViewModel;
        this.$attachmentsContext = attachmentContext;
        this.$commandResendCompressedHandler = function0;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(Integer num, Boolean bool) {
        invoke(num.intValue(), bool.booleanValue());
        return Unit.a;
    }

    public final void invoke(int i, boolean z2) {
        PublishSubject publishSubjectAccess$getEventSubject$p = ChatInputViewModel.access$getEventSubject$p(this.this$0);
        publishSubjectAccess$getEventSubject$p.k.onNext(new ChatInputViewModel.Event.FilesTooLarge(i, this.$attachmentsContext.getCurrentFileSizeMB(), this.$attachmentsContext.getMaxAttachmentSizeMB(), z2, this.$attachmentsContext.getAttachments(), this.$attachmentsContext.getHasImage(), this.$attachmentsContext.getHasVideo(), this.$attachmentsContext.getHasGif(), this.$commandResendCompressedHandler));
    }
}
