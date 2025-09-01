package com.discord.stores;

import com.discord.api.utcdatetime.UtcDateTime;
import com.discord.models.commands.ApplicationCommandLocalSendData;
import com.discord.models.message.Message;
import com.discord.stores.StoreMessages;
import com.discord.utilities.messagesend.MessageQueue3;
import com.discord.utilities.messagesend.MessageQueue4;
import com.discord.utilities.rest.SendUtils;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import rx.Emitter;

/* compiled from: StoreMessages.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lrx/Emitter;", "Lcom/discord/utilities/messagesend/MessageResult;", "emitter", "Lcom/discord/utilities/messagesend/MessageRequest$SendApplicationCommand;", "invoke", "(Lrx/Emitter;)Lcom/discord/utilities/messagesend/MessageRequest$SendApplicationCommand;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.stores.StoreMessages$sendMessage$createRequest$2, reason: use source file name */
/* loaded from: classes2.dex */
public final class StoreMessages4 extends Lambda implements Function1<Emitter<MessageQueue4>, MessageQueue3.SendApplicationCommand> {
    public final /* synthetic */ ApplicationCommandLocalSendData $applicationCommandLocalSendData;
    public final /* synthetic */ List $attachments;
    public final /* synthetic */ Message $message;
    public final /* synthetic */ StoreMessages this$0;

    /* compiled from: StoreMessages.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lcom/discord/utilities/messagesend/MessageResult;", "messageResult", "", "isLastMessage", "", "invoke", "(Lcom/discord/utilities/messagesend/MessageResult;Z)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreMessages$sendMessage$createRequest$2$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function2<MessageQueue4, Boolean, Unit> {
        public final /* synthetic */ Emitter $emitter;

        /* compiled from: StoreMessages.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
        /* renamed from: com.discord.stores.StoreMessages$sendMessage$createRequest$2$1$1, reason: invalid class name and collision with other inner class name */
        public static final class C01591 extends Lambda implements Function0<Unit> {
            public C01591() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                StoreMessages.Companion.access$cancelBackgroundSendingWork(StoreMessages.INSTANCE, StoreMessages.access$getContext$p(StoreMessages4.this.this$0));
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
            Intrinsics3.checkNotNullParameter(messageQueue4, "messageResult");
            this.$emitter.onNext(messageQueue4);
            this.$emitter.onCompleted();
            if (z2) {
                StoreMessages.access$getDispatcher$p(StoreMessages4.this.this$0).schedule(new C01591());
            }
        }
    }

    /* compiled from: StoreMessages.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/utilities/rest/SendUtils$SendPayload$Preprocessing;", "<name for destructuring parameter 0>", "", "invoke", "(Lcom/discord/utilities/rest/SendUtils$SendPayload$Preprocessing;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreMessages$sendMessage$createRequest$2$2, reason: invalid class name */
    public static final class AnonymousClass2 extends Lambda implements Function1<SendUtils.SendPayload.Preprocessing, Unit> {

        /* compiled from: StoreMessages.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
        /* renamed from: com.discord.stores.StoreMessages$sendMessage$createRequest$2$2$1, reason: invalid class name */
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
                StoreMessages.access$getStream$p(StoreMessages4.this.this$0).getMessageUploads().onPreprocessing(StoreMessages4.this.$applicationCommandLocalSendData.getNonceString(), this.$numFiles, this.$displayName, this.$mimeType);
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
            StoreMessages.access$getDispatcher$p(StoreMessages4.this.this$0).schedule(new AnonymousClass1(preprocessing.getNumFiles(), preprocessing.getName(), preprocessing.getMimeType()));
        }
    }

    /* compiled from: StoreMessages.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "Lcom/discord/utilities/rest/SendUtils$FileUpload;", "uploads", "", "invoke", "(Ljava/util/List;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreMessages$sendMessage$createRequest$2$3, reason: invalid class name */
    public static final class AnonymousClass3 extends Lambda implements Function1<List<? extends SendUtils.FileUpload>, Unit> {

        /* compiled from: StoreMessages.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
        /* renamed from: com.discord.stores.StoreMessages$sendMessage$createRequest$2$3$1, reason: invalid class name */
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
                StoreMessages.access$getStream$p(StoreMessages4.this.this$0).getMessageUploads().bindUpload(StoreMessages4.this.$applicationCommandLocalSendData.getNonceString(), this.$uploads);
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
            StoreMessages.access$getDispatcher$p(StoreMessages4.this.this$0).schedule(new AnonymousClass1(list));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreMessages4(StoreMessages storeMessages, Message message, ApplicationCommandLocalSendData applicationCommandLocalSendData, List list) {
        super(1);
        this.this$0 = storeMessages;
        this.$message = message;
        this.$applicationCommandLocalSendData = applicationCommandLocalSendData;
        this.$attachments = list;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ MessageQueue3.SendApplicationCommand invoke(Emitter<MessageQueue4> emitter) {
        return invoke2(emitter);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final MessageQueue3.SendApplicationCommand invoke2(Emitter<MessageQueue4> emitter) {
        Intrinsics3.checkNotNullParameter(emitter, "emitter");
        com.discord.api.message.Message messageSynthesizeApiMessage = this.$message.synthesizeApiMessage();
        ApplicationCommandLocalSendData applicationCommandLocalSendData = this.$applicationCommandLocalSendData;
        UtcDateTime timestamp = this.$message.getTimestamp();
        return new MessageQueue3.SendApplicationCommand(messageSynthesizeApiMessage, applicationCommandLocalSendData, this.$attachments, new AnonymousClass2(), new AnonymousClass3(), new AnonymousClass1(emitter), timestamp != null ? timestamp.getDateTimeMillis() : 0L);
    }
}
