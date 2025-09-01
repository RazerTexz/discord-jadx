package com.discord.widgets.chat.input;

import android.content.Context;
import com.discord.models.guild.Guild;
import com.discord.models.user.MeUser;
import com.discord.utilities.messagesend.MessageQueue4;
import com.discord.utilities.premium.PremiumUtils;
import com.discord.utilities.rest.SendUtils;
import com.discord.utilities.user.UserUtils;
import com.discord.widgets.chat.input.ChatInputViewModel;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import rx.subjects.PublishSubject;

/* compiled from: ChatInputViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lcom/discord/utilities/messagesend/MessageResult;", "messageResult", "Lcom/discord/models/guild/Guild;", "guild", "", "invoke", "(Lcom/discord/utilities/messagesend/MessageResult;Lcom/discord/models/guild/Guild;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class ChatInputViewModel$sendMessage$messageSendResultHandler$1 extends Lambda implements Function2<MessageQueue4, Guild, Unit> {
    public final /* synthetic */ ChatInputViewModel.AttachmentContext $attachmentsContext;
    public final /* synthetic */ Context $context;
    public final /* synthetic */ boolean $isThreadDraft;
    public final /* synthetic */ ChatInputViewModel.ViewState.Loaded $loadedViewState;
    public final /* synthetic */ Function0 $messageResendCompressedHandler;
    public final /* synthetic */ ChatInputViewModel this$0;

    /* compiled from: ChatInputViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.chat.input.ChatInputViewModel$sendMessage$messageSendResultHandler$1$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ Guild $guild;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Guild guild) {
            super(0);
            this.$guild = guild;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            PremiumUtils premiumUtils = PremiumUtils.INSTANCE;
            Guild guild = this.$guild;
            int iMax = Math.max(premiumUtils.getGuildMaxFileSizeMB(guild != null ? guild.getPremiumTier() : 0), premiumUtils.getMaxFileSizeMB(ChatInputViewModel$sendMessage$messageSendResultHandler$1.this.$loadedViewState.getMe()));
            PublishSubject publishSubjectAccess$getEventSubject$p = ChatInputViewModel.access$getEventSubject$p(ChatInputViewModel$sendMessage$messageSendResultHandler$1.this.this$0);
            MeUser me2 = ChatInputViewModel$sendMessage$messageSendResultHandler$1.this.$loadedViewState.getMe();
            publishSubjectAccess$getEventSubject$p.k.onNext(new ChatInputViewModel.Event.FilesTooLarge(iMax, Float.MAX_VALUE, Float.MAX_VALUE, me2 != null ? UserUtils.INSTANCE.isPremium(me2) : false, ChatInputViewModel$sendMessage$messageSendResultHandler$1.this.$attachmentsContext.getAttachments(), ChatInputViewModel$sendMessage$messageSendResultHandler$1.this.$attachmentsContext.getHasImage(), ChatInputViewModel$sendMessage$messageSendResultHandler$1.this.$attachmentsContext.getHasVideo(), ChatInputViewModel$sendMessage$messageSendResultHandler$1.this.$attachmentsContext.getHasGif(), ChatInputViewModel$sendMessage$messageSendResultHandler$1.this.$messageResendCompressedHandler));
        }
    }

    /* compiled from: ChatInputViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.chat.input.ChatInputViewModel$sendMessage$messageSendResultHandler$1$2, reason: invalid class name */
    public static final class AnonymousClass2 extends Lambda implements Function0<Unit> {
        public AnonymousClass2() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            PublishSubject publishSubjectAccess$getEventSubject$p = ChatInputViewModel.access$getEventSubject$p(ChatInputViewModel$sendMessage$messageSendResultHandler$1.this.this$0);
            publishSubjectAccess$getEventSubject$p.k.onNext(ChatInputViewModel.Event.FailedDeliveryToRecipient.INSTANCE);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChatInputViewModel$sendMessage$messageSendResultHandler$1(ChatInputViewModel chatInputViewModel, Context context, ChatInputViewModel.ViewState.Loaded loaded, ChatInputViewModel.AttachmentContext attachmentContext, Function0 function0, boolean z2) {
        super(2);
        this.this$0 = chatInputViewModel;
        this.$context = context;
        this.$loadedViewState = loaded;
        this.$attachmentsContext = attachmentContext;
        this.$messageResendCompressedHandler = function0;
        this.$isThreadDraft = z2;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(MessageQueue4 messageQueue4, Guild guild) {
        invoke2(messageQueue4, guild);
        return Unit.a;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(MessageQueue4 messageQueue4, Guild guild) {
        Intrinsics3.checkNotNullParameter(messageQueue4, "messageResult");
        if (messageQueue4 instanceof MessageQueue4.CaptchaRequired) {
            SendUtils.INSTANCE.handleCaptchaRequired((MessageQueue4.CaptchaRequired) messageQueue4);
        } else if (messageQueue4 instanceof MessageQueue4.UnknownFailure) {
            SendUtils.INSTANCE.handleSendError(((MessageQueue4.UnknownFailure) messageQueue4).getError(), this.$context, new AnonymousClass1(guild), new AnonymousClass2());
        } else if (this.$isThreadDraft) {
            ChatInputViewModel.access$getStoreThreadDraft$p(this.this$0).clearDraftState();
        }
    }
}
