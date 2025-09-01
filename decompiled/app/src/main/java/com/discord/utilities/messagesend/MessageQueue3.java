package com.discord.utilities.messagesend;

import androidx.appcompat.widget.ActivityChooserModel;
import com.discord.api.activity.Activity;
import com.discord.api.message.allowedmentions.MessageAllowedMentions;
import com.discord.models.commands.ApplicationCommandLocalSendData;
import com.discord.models.message.Message;
import com.discord.utilities.messagesend.MessageQueue4;
import com.discord.utilities.rest.SendUtils;
import com.lytefast.flexinput.model.Attachment;
import d0.z.d.Intrinsics3;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: MessageQueue.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0016\u0017\u0018B3\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0018\u0010\u000b\u001a\u0014\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\u0007\u0012\u0006\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0014\u0010\u0015R\u0019\u0010\u0003\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R+\u0010\u000b\u001a\u0014\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\u00078\u0006@\u0006¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0019\u0010\u0010\u001a\u00020\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\u0082\u0001\u0003\u0019\u001a\u001b¨\u0006\u001c"}, d2 = {"Lcom/discord/utilities/messagesend/MessageRequest;", "", "", "requestId", "Ljava/lang/String;", "getRequestId", "()Ljava/lang/String;", "Lkotlin/Function2;", "Lcom/discord/utilities/messagesend/MessageResult;", "", "", "onCompleted", "Lkotlin/jvm/functions/Function2;", "getOnCompleted", "()Lkotlin/jvm/functions/Function2;", "", "attemptTimestamp", "J", "getAttemptTimestamp", "()J", "<init>", "(Ljava/lang/String;Lkotlin/jvm/functions/Function2;J)V", "Edit", "Send", "SendApplicationCommand", "Lcom/discord/utilities/messagesend/MessageRequest$Send;", "Lcom/discord/utilities/messagesend/MessageRequest$Edit;", "Lcom/discord/utilities/messagesend/MessageRequest$SendApplicationCommand;", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* renamed from: com.discord.utilities.messagesend.MessageRequest, reason: use source file name */
/* loaded from: classes2.dex */
public abstract class MessageQueue3 {
    private final long attemptTimestamp;
    private final Function2<MessageQueue4, Boolean, Unit> onCompleted;
    private final String requestId;

    /* compiled from: MessageQueue.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001BS\u0012\n\u0010\u000e\u001a\u00060\u0007j\u0002`\r\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u0012\n\u0010\t\u001a\u00060\u0007j\u0002`\b\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0015\u001a\u00020\u0007\u0012\u0018\u0010\u001a\u001a\u0014\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00190\u0016¢\u0006\u0004\b\u001b\u0010\u001cR\u001b\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001d\u0010\t\u001a\u00060\u0007j\u0002`\b8\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001d\u0010\u000e\u001a\u00060\u0007j\u0002`\r8\u0006@\u0006¢\u0006\f\n\u0004\b\u000e\u0010\n\u001a\u0004\b\u000f\u0010\fR\u0019\u0010\u0011\u001a\u00020\u00108\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u001d"}, d2 = {"Lcom/discord/utilities/messagesend/MessageRequest$Edit;", "Lcom/discord/utilities/messagesend/MessageRequest;", "Lcom/discord/api/message/allowedmentions/MessageAllowedMentions;", "allowedMentions", "Lcom/discord/api/message/allowedmentions/MessageAllowedMentions;", "getAllowedMentions", "()Lcom/discord/api/message/allowedmentions/MessageAllowedMentions;", "", "Lcom/discord/primitives/MessageId;", "messageId", "J", "getMessageId", "()J", "Lcom/discord/primitives/ChannelId;", "channelId", "getChannelId", "", "content", "Ljava/lang/String;", "getContent", "()Ljava/lang/String;", "attemptTimestamp", "Lkotlin/Function2;", "Lcom/discord/utilities/messagesend/MessageResult;", "", "", "onCompleted", "<init>", "(JLjava/lang/String;JLcom/discord/api/message/allowedmentions/MessageAllowedMentions;JLkotlin/jvm/functions/Function2;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    /* renamed from: com.discord.utilities.messagesend.MessageRequest$Edit */
    public static final class Edit extends MessageQueue3 {
        private final MessageAllowedMentions allowedMentions;
        private final long channelId;
        private final String content;
        private final long messageId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Edit(long j, String str, long j2, MessageAllowedMentions messageAllowedMentions, long j3, Function2<? super MessageQueue4, ? super Boolean, Unit> function2) {
            super(String.valueOf(j2), function2, j3, null);
            Intrinsics3.checkNotNullParameter(str, "content");
            Intrinsics3.checkNotNullParameter(function2, "onCompleted");
            this.channelId = j;
            this.content = str;
            this.messageId = j2;
            this.allowedMentions = messageAllowedMentions;
        }

        public final MessageAllowedMentions getAllowedMentions() {
            return this.allowedMentions;
        }

        public final long getChannelId() {
            return this.channelId;
        }

        public final String getContent() {
            return this.content;
        }

        public final long getMessageId() {
            return this.messageId;
        }
    }

    /* compiled from: MessageQueue.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\u0018\u00002\u00020\u0001B}\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011\u0012\u0012\u0010\u0018\u001a\u000e\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0017\u0018\u00010\u0016\u0012\u0018\u0010\"\u001a\u0014\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020\f0\u001f\u0012\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\n\u0012\u0018\u0010\u001d\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001c0\u0016\u0012\u0004\u0012\u00020\f0\n\u0012\u0006\u0010$\u001a\u00020#¢\u0006\u0004\b%\u0010&J\u000f\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0003\u0010\u0004R\u0019\u0010\u0006\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\tR%\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\n8\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001b\u0010\u0012\u001a\u0004\u0018\u00010\u00118\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R%\u0010\u0018\u001a\u000e\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0017\u0018\u00010\u00168\u0006@\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR+\u0010\u001d\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001c0\u0016\u0012\u0004\u0012\u00020\f0\n8\u0006@\u0006¢\u0006\f\n\u0004\b\u001d\u0010\u000e\u001a\u0004\b\u001e\u0010\u0010¨\u0006'"}, d2 = {"Lcom/discord/utilities/messagesend/MessageRequest$Send;", "Lcom/discord/utilities/messagesend/MessageRequest;", "Lcom/discord/utilities/messagesend/MessageResult$ValidationError;", "validateMessage", "()Lcom/discord/utilities/messagesend/MessageResult$ValidationError;", "Lcom/discord/models/message/Message;", "message", "Lcom/discord/models/message/Message;", "getMessage", "()Lcom/discord/models/message/Message;", "Lkotlin/Function1;", "Lcom/discord/utilities/rest/SendUtils$SendPayload$Preprocessing;", "", "onPreprocessing", "Lkotlin/jvm/functions/Function1;", "getOnPreprocessing", "()Lkotlin/jvm/functions/Function1;", "Lcom/discord/api/activity/Activity;", ActivityChooserModel.ATTRIBUTE_ACTIVITY, "Lcom/discord/api/activity/Activity;", "getActivity", "()Lcom/discord/api/activity/Activity;", "", "Lcom/lytefast/flexinput/model/Attachment;", "attachments", "Ljava/util/List;", "getAttachments", "()Ljava/util/List;", "Lcom/discord/utilities/rest/SendUtils$FileUpload;", "onProgress", "getOnProgress", "Lkotlin/Function2;", "Lcom/discord/utilities/messagesend/MessageResult;", "", "onCompleted", "", "attemptTimestamp", "<init>", "(Lcom/discord/models/message/Message;Lcom/discord/api/activity/Activity;Ljava/util/List;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;J)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    /* renamed from: com.discord.utilities.messagesend.MessageRequest$Send */
    public static final class Send extends MessageQueue3 {
        private final Activity activity;
        private final List<Attachment<?>> attachments;
        private final Message message;
        private final Function1<SendUtils.SendPayload.Preprocessing, Unit> onPreprocessing;
        private final Function1<List<SendUtils.FileUpload>, Unit> onProgress;

        /* JADX WARN: Illegal instructions before constructor call */
        /* JADX WARN: Multi-variable type inference failed */
        public Send(Message message, Activity activity, List<? extends Attachment<?>> list, Function2<? super MessageQueue4, ? super Boolean, Unit> function2, Function1<? super SendUtils.SendPayload.Preprocessing, Unit> function1, Function1<? super List<SendUtils.FileUpload>, Unit> function12, long j) {
            Intrinsics3.checkNotNullParameter(message, "message");
            Intrinsics3.checkNotNullParameter(function2, "onCompleted");
            Intrinsics3.checkNotNullParameter(function1, "onPreprocessing");
            Intrinsics3.checkNotNullParameter(function12, "onProgress");
            String nonce = message.getNonce();
            Intrinsics3.checkNotNull(nonce);
            super(nonce, function2, j, null);
            this.message = message;
            this.activity = activity;
            this.attachments = list;
            this.onPreprocessing = function1;
            this.onProgress = function12;
        }

        public final Activity getActivity() {
            return this.activity;
        }

        public final List<Attachment<?>> getAttachments() {
            return this.attachments;
        }

        public final Message getMessage() {
            return this.message;
        }

        public final Function1<SendUtils.SendPayload.Preprocessing, Unit> getOnPreprocessing() {
            return this.onPreprocessing;
        }

        public final Function1<List<SendUtils.FileUpload>, Unit> getOnProgress() {
            return this.onProgress;
        }

        public final MessageQueue4.ValidationError validateMessage() {
            if (this.message.getActivity() != null) {
                List<Attachment<?>> list = this.attachments;
                if (!(list == null || list.isEmpty())) {
                    return new MessageQueue4.ValidationError("Cannot send attachments with activity action");
                }
            }
            return null;
        }
    }

    /* compiled from: MessageQueue.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\u0018\u00002\u00020\u0001B{\u0012\u0006\u0010\u0018\u001a\u00020\u0017\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u0012\u0012\u0010\u000b\u001a\u000e\u0012\b\u0012\u0006\u0012\u0002\b\u00030\n\u0018\u00010\u0003\u0012\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00050\u0002\u0012\u0018\u0010\u0006\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0004\u0012\u00020\u00050\u0002\u0012\u0018\u0010\u001f\u001a\u0014\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u00050\u001c\u0012\u0006\u0010!\u001a\u00020 ¢\u0006\u0004\b\"\u0010#R+\u0010\u0006\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0004\u0012\u00020\u00050\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\tR%\u0010\u000b\u001a\u000e\u0012\b\u0012\u0006\u0012\u0002\b\u00030\n\u0018\u00010\u00038\u0006@\u0006¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0019\u0010\u0010\u001a\u00020\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R%\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00050\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0007\u001a\u0004\b\u0016\u0010\tR\u0019\u0010\u0018\u001a\u00020\u00178\u0006@\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b¨\u0006$"}, d2 = {"Lcom/discord/utilities/messagesend/MessageRequest$SendApplicationCommand;", "Lcom/discord/utilities/messagesend/MessageRequest;", "Lkotlin/Function1;", "", "Lcom/discord/utilities/rest/SendUtils$FileUpload;", "", "onProgress", "Lkotlin/jvm/functions/Function1;", "getOnProgress", "()Lkotlin/jvm/functions/Function1;", "Lcom/lytefast/flexinput/model/Attachment;", "attachments", "Ljava/util/List;", "getAttachments", "()Ljava/util/List;", "Lcom/discord/models/commands/ApplicationCommandLocalSendData;", "applicationCommandSendData", "Lcom/discord/models/commands/ApplicationCommandLocalSendData;", "getApplicationCommandSendData", "()Lcom/discord/models/commands/ApplicationCommandLocalSendData;", "Lcom/discord/utilities/rest/SendUtils$SendPayload$Preprocessing;", "onPreprocessing", "getOnPreprocessing", "Lcom/discord/api/message/Message;", "message", "Lcom/discord/api/message/Message;", "getMessage", "()Lcom/discord/api/message/Message;", "Lkotlin/Function2;", "Lcom/discord/utilities/messagesend/MessageResult;", "", "onCompleted", "", "attemptTimestamp", "<init>", "(Lcom/discord/api/message/Message;Lcom/discord/models/commands/ApplicationCommandLocalSendData;Ljava/util/List;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;J)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    /* renamed from: com.discord.utilities.messagesend.MessageRequest$SendApplicationCommand */
    public static final class SendApplicationCommand extends MessageQueue3 {
        private final ApplicationCommandLocalSendData applicationCommandSendData;
        private final List<Attachment<?>> attachments;
        private final com.discord.api.message.Message message;
        private final Function1<SendUtils.SendPayload.Preprocessing, Unit> onPreprocessing;
        private final Function1<List<SendUtils.FileUpload>, Unit> onProgress;

        /* JADX WARN: Illegal instructions before constructor call */
        /* JADX WARN: Multi-variable type inference failed */
        public SendApplicationCommand(com.discord.api.message.Message message, ApplicationCommandLocalSendData applicationCommandLocalSendData, List<? extends Attachment<?>> list, Function1<? super SendUtils.SendPayload.Preprocessing, Unit> function1, Function1<? super List<SendUtils.FileUpload>, Unit> function12, Function2<? super MessageQueue4, ? super Boolean, Unit> function2, long j) {
            Intrinsics3.checkNotNullParameter(message, "message");
            Intrinsics3.checkNotNullParameter(applicationCommandLocalSendData, "applicationCommandSendData");
            Intrinsics3.checkNotNullParameter(function1, "onPreprocessing");
            Intrinsics3.checkNotNullParameter(function12, "onProgress");
            Intrinsics3.checkNotNullParameter(function2, "onCompleted");
            String nonce = message.getNonce();
            super(nonce == null ? String.valueOf(applicationCommandLocalSendData.getNonce()) : nonce, function2, j, null);
            this.message = message;
            this.applicationCommandSendData = applicationCommandLocalSendData;
            this.attachments = list;
            this.onPreprocessing = function1;
            this.onProgress = function12;
        }

        public final ApplicationCommandLocalSendData getApplicationCommandSendData() {
            return this.applicationCommandSendData;
        }

        public final List<Attachment<?>> getAttachments() {
            return this.attachments;
        }

        public final com.discord.api.message.Message getMessage() {
            return this.message;
        }

        public final Function1<SendUtils.SendPayload.Preprocessing, Unit> getOnPreprocessing() {
            return this.onPreprocessing;
        }

        public final Function1<List<SendUtils.FileUpload>, Unit> getOnProgress() {
            return this.onProgress;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private MessageQueue3(String str, Function2<? super MessageQueue4, ? super Boolean, Unit> function2, long j) {
        this.requestId = str;
        this.onCompleted = function2;
        this.attemptTimestamp = j;
    }

    public final long getAttemptTimestamp() {
        return this.attemptTimestamp;
    }

    public final Function2<MessageQueue4, Boolean, Unit> getOnCompleted() {
        return this.onCompleted;
    }

    public final String getRequestId() {
        return this.requestId;
    }

    public /* synthetic */ MessageQueue3(String str, Function2 function2, long j, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, function2, j);
    }
}
