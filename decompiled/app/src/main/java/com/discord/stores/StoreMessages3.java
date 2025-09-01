package com.discord.stores;

import com.discord.api.activity.Activity;
import com.discord.models.message.Message;
import com.discord.stores.StoreMessages;
import com.discord.stores.StoreSlowMode;
import com.discord.utilities.messagesend.MessageQueue3;
import com.discord.utilities.messagesend.MessageQueue4;
import com.discord.utilities.rest.SendUtils;
import d0.t.CollectionsJVM;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref$ObjectRef;
import rx.Emitter;

/* compiled from: StoreMessages.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lrx/Emitter;", "Lcom/discord/utilities/messagesend/MessageResult;", "emitter", "Lcom/discord/utilities/messagesend/MessageRequest$Send;", "invoke", "(Lrx/Emitter;)Lcom/discord/utilities/messagesend/MessageRequest$Send;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.stores.StoreMessages$sendMessage$createRequest$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class StoreMessages3 extends Lambda implements Function1<Emitter<MessageQueue4>, MessageQueue3.Send> {
    public final /* synthetic */ Activity $activity;
    public final /* synthetic */ long $attemptTimestamp;
    public final /* synthetic */ Message $localMessage;
    public final /* synthetic */ Ref$ObjectRef $validAttachments;
    public final /* synthetic */ StoreMessages this$0;

    /* compiled from: StoreMessages.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lcom/discord/utilities/messagesend/MessageResult;", "result", "", "isLastMessage", "", "invoke", "(Lcom/discord/utilities/messagesend/MessageResult;Z)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreMessages$sendMessage$createRequest$1$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function2<MessageQueue4, Boolean, Unit> {
        public final /* synthetic */ Emitter $emitter;

        /* compiled from: StoreMessages.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
        /* renamed from: com.discord.stores.StoreMessages$sendMessage$createRequest$1$1$1, reason: invalid class name and collision with other inner class name */
        public static final class C01581 extends Lambda implements Function0<Unit> {
            public final /* synthetic */ boolean $isLastMessage;
            public final /* synthetic */ MessageQueue4 $result;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C01581(boolean z2, MessageQueue4 messageQueue4) {
                super(0);
                this.$isLastMessage = z2;
                this.$result = messageQueue4;
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                if (this.$isLastMessage) {
                    StoreMessages.Companion.access$cancelBackgroundSendingWork(StoreMessages.INSTANCE, StoreMessages.access$getContext$p(StoreMessages3.this.this$0));
                }
                MessageQueue4 messageQueue4 = this.$result;
                if (messageQueue4 instanceof MessageQueue4.Success) {
                    StoreMessages.access$getStream$p(StoreMessages3.this.this$0).getSlowMode().onMessageSent(((MessageQueue4.Success) this.$result).getMessage().getChannelId());
                    StoreMessages3.this.this$0.handleMessageCreate(CollectionsJVM.listOf(((MessageQueue4.Success) this.$result).getMessage()));
                    Integer numRetries = StoreMessages3.this.$localMessage.getNumRetries();
                    if ((numRetries != null ? numRetries.intValue() : 0) > 0) {
                        StoreMessages3 storeMessages3 = StoreMessages3.this;
                        StoreMessages.access$trackFailedLocalMessageResolved(storeMessages3.this$0, storeMessages3.$localMessage, StoreMessages2.RESENT);
                    }
                } else if (messageQueue4 instanceof MessageQueue4.Slowmode) {
                    StoreMessages3 storeMessages32 = StoreMessages3.this;
                    StoreMessages.access$handleSendMessageFailure(storeMessages32.this$0, storeMessages32.$localMessage);
                    StoreMessages.access$getStream$p(StoreMessages3.this.this$0).getSlowMode().onCooldown(StoreMessages3.this.$localMessage.getChannelId(), ((MessageQueue4.Slowmode) this.$result).getCooldownMs(), StoreSlowMode.Type.MessageSend.INSTANCE);
                } else if (!(messageQueue4 instanceof MessageQueue4.RateLimited)) {
                    if (messageQueue4 instanceof MessageQueue4.UserCancelled) {
                        StoreMessages3 storeMessages33 = StoreMessages3.this;
                        StoreMessages.access$handleLocalMessageDelete(storeMessages33.this$0, storeMessages33.$localMessage);
                    } else if (messageQueue4 instanceof MessageQueue4.CaptchaRequired) {
                        StoreMessages3 storeMessages34 = StoreMessages3.this;
                        StoreMessages.access$handleSendMessageCaptchaRequired(storeMessages34.this$0, storeMessages34.$localMessage);
                    } else if (messageQueue4 instanceof MessageQueue4.UnknownFailure) {
                        StoreMessages3 storeMessages35 = StoreMessages3.this;
                        StoreMessages.access$handleSendMessageFailure(storeMessages35.this$0, storeMessages35.$localMessage);
                    } else if (messageQueue4 instanceof MessageQueue4.ValidationError) {
                        StoreMessages3 storeMessages36 = StoreMessages3.this;
                        StoreMessages.access$handleSendMessageValidationError(storeMessages36.this$0, storeMessages36.$localMessage, ((MessageQueue4.ValidationError) messageQueue4).getMessage());
                    } else if (!(messageQueue4 instanceof MessageQueue4.NetworkFailure)) {
                        if (messageQueue4 instanceof MessageQueue4.Timeout) {
                            StoreMessages3 storeMessages37 = StoreMessages3.this;
                            StoreMessages.access$handleSendMessageFailure(storeMessages37.this$0, storeMessages37.$localMessage);
                        } else if (messageQueue4 instanceof MessageQueue4.AutoModBlock) {
                            StoreMessages3 storeMessages38 = StoreMessages3.this;
                            StoreMessages.handleSendMessageFailureAutoMod$default(storeMessages38.this$0, storeMessages38.$localMessage, null, 2, null);
                        }
                    }
                }
                AnonymousClass1.this.$emitter.onNext(this.$result);
                AnonymousClass1.this.$emitter.onCompleted();
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Emitter emitter) {
            super(2);
            this.$emitter = emitter;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(MessageQueue4 messageQueue4, Boolean bool) {
            invoke(messageQueue4, bool.booleanValue());
            return Unit.a;
        }

        public final void invoke(MessageQueue4 messageQueue4, boolean z2) {
            Intrinsics3.checkNotNullParameter(messageQueue4, "result");
            StoreMessages.access$getDispatcher$p(StoreMessages3.this.this$0).schedule(new C01581(z2, messageQueue4));
        }
    }

    /* compiled from: StoreMessages.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/utilities/rest/SendUtils$SendPayload$Preprocessing;", "<name for destructuring parameter 0>", "", "invoke", "(Lcom/discord/utilities/rest/SendUtils$SendPayload$Preprocessing;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreMessages$sendMessage$createRequest$1$2, reason: invalid class name */
    public static final class AnonymousClass2 extends Lambda implements Function1<SendUtils.SendPayload.Preprocessing, Unit> {

        /* compiled from: StoreMessages.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
        /* renamed from: com.discord.stores.StoreMessages$sendMessage$createRequest$1$2$1, reason: invalid class name */
        public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
            public final /* synthetic */ String $displayName;
            public final /* synthetic */ String $mimeType;
            public final /* synthetic */ int $numFiles;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(int i, String str, String str2) {
                super(0);
                this.$numFiles = i;
                this.$displayName = str;
                this.$mimeType = str2;
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                StoreMessageUploads messageUploads = StoreMessages.access$getStream$p(StoreMessages3.this.this$0).getMessageUploads();
                String nonce = StoreMessages3.this.$localMessage.getNonce();
                Intrinsics3.checkNotNull(nonce);
                messageUploads.onPreprocessing(nonce, this.$numFiles, this.$displayName, this.$mimeType);
            }
        }

        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(SendUtils.SendPayload.Preprocessing preprocessing) {
            invoke2(preprocessing);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(SendUtils.SendPayload.Preprocessing preprocessing) {
            Intrinsics3.checkNotNullParameter(preprocessing, "<name for destructuring parameter 0>");
            StoreMessages.access$getDispatcher$p(StoreMessages3.this.this$0).schedule(new AnonymousClass1(preprocessing.getNumFiles(), preprocessing.getName(), preprocessing.getMimeType()));
        }
    }

    /* compiled from: StoreMessages.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "Lcom/discord/utilities/rest/SendUtils$FileUpload;", "uploads", "", "invoke", "(Ljava/util/List;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreMessages$sendMessage$createRequest$1$3, reason: invalid class name */
    public static final class AnonymousClass3 extends Lambda implements Function1<List<? extends SendUtils.FileUpload>, Unit> {

        /* compiled from: StoreMessages.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
        /* renamed from: com.discord.stores.StoreMessages$sendMessage$createRequest$1$3$1, reason: invalid class name */
        public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
            public final /* synthetic */ List $uploads;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(List list) {
                super(0);
                this.$uploads = list;
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                StoreMessageUploads messageUploads = StoreMessages.access$getStream$p(StoreMessages3.this.this$0).getMessageUploads();
                String nonce = StoreMessages3.this.$localMessage.getNonce();
                Intrinsics3.checkNotNull(nonce);
                messageUploads.bindUpload(nonce, this.$uploads);
            }
        }

        public AnonymousClass3() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(List<? extends SendUtils.FileUpload> list) {
            invoke2((List<SendUtils.FileUpload>) list);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(List<SendUtils.FileUpload> list) {
            Intrinsics3.checkNotNullParameter(list, "uploads");
            StoreMessages.access$getDispatcher$p(StoreMessages3.this.this$0).schedule(new AnonymousClass1(list));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreMessages3(StoreMessages storeMessages, Message message, Ref$ObjectRef ref$ObjectRef, Activity activity, long j) {
        super(1);
        this.this$0 = storeMessages;
        this.$localMessage = message;
        this.$validAttachments = ref$ObjectRef;
        this.$activity = activity;
        this.$attemptTimestamp = j;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ MessageQueue3.Send invoke(Emitter<MessageQueue4> emitter) {
        return invoke2(emitter);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final MessageQueue3.Send invoke2(Emitter<MessageQueue4> emitter) {
        Intrinsics3.checkNotNullParameter(emitter, "emitter");
        Message message = this.$localMessage;
        List list = (List) this.$validAttachments.element;
        return new MessageQueue3.Send(message, this.$activity, list, new AnonymousClass1(emitter), new AnonymousClass2(), new AnonymousClass3(), this.$attemptTimestamp);
    }
}
