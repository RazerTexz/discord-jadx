package com.discord.utilities.messagesend;

import com.discord.models.message.Message;
import com.discord.utilities.error.Error;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: MessageQueue.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u000b\u0004\u0005\u0006\u0007\b\t\n\u000b\f\r\u000eB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u000b\u000f\u0010\u0011\u0012\u0013\u0014\u0015\u0016\u0017\u0018\u0019¨\u0006\u001a"}, d2 = {"Lcom/discord/utilities/messagesend/MessageResult;", "", "<init>", "()V", "AutoModBlock", "CaptchaRequired", "NetworkFailure", "NoValidContent", "RateLimited", "Slowmode", "Success", "Timeout", "UnknownFailure", "UserCancelled", "ValidationError", "Lcom/discord/utilities/messagesend/MessageResult$Success;", "Lcom/discord/utilities/messagesend/MessageResult$Slowmode;", "Lcom/discord/utilities/messagesend/MessageResult$RateLimited;", "Lcom/discord/utilities/messagesend/MessageResult$UserCancelled;", "Lcom/discord/utilities/messagesend/MessageResult$NetworkFailure;", "Lcom/discord/utilities/messagesend/MessageResult$CaptchaRequired;", "Lcom/discord/utilities/messagesend/MessageResult$UnknownFailure;", "Lcom/discord/utilities/messagesend/MessageResult$ValidationError;", "Lcom/discord/utilities/messagesend/MessageResult$NoValidContent;", "Lcom/discord/utilities/messagesend/MessageResult$Timeout;", "Lcom/discord/utilities/messagesend/MessageResult$AutoModBlock;", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* renamed from: com.discord.utilities.messagesend.MessageResult, reason: use source file name */
/* loaded from: classes2.dex */
public abstract class MessageQueue4 {

    /* compiled from: MessageQueue.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\f\u0010\rR\u0019\u0010\u0003\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b¨\u0006\u000e"}, d2 = {"Lcom/discord/utilities/messagesend/MessageResult$AutoModBlock;", "Lcom/discord/utilities/messagesend/MessageResult;", "Lcom/discord/utilities/error/Error;", "error", "Lcom/discord/utilities/error/Error;", "getError", "()Lcom/discord/utilities/error/Error;", "Lcom/discord/models/message/Message;", "message", "Lcom/discord/models/message/Message;", "getMessage", "()Lcom/discord/models/message/Message;", "<init>", "(Lcom/discord/utilities/error/Error;Lcom/discord/models/message/Message;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    /* renamed from: com.discord.utilities.messagesend.MessageResult$AutoModBlock */
    public static final class AutoModBlock extends MessageQueue4 {
        private final Error error;
        private final Message message;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AutoModBlock(Error error, Message message) {
            super(null);
            Intrinsics3.checkNotNullParameter(error, "error");
            this.error = error;
            this.message = message;
        }

        public final Error getError() {
            return this.error;
        }

        public final Message getMessage() {
            return this.message;
        }
    }

    /* compiled from: MessageQueue.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\n\u0010\u000e\u001a\u00060\fj\u0002`\r\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0012\u0010\u0013R\u001b\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\b\u001a\u00020\u00078\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001d\u0010\u000e\u001a\u00060\fj\u0002`\r8\u0006@\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0014"}, d2 = {"Lcom/discord/utilities/messagesend/MessageResult$CaptchaRequired;", "Lcom/discord/utilities/messagesend/MessageResult;", "", "nonce", "Ljava/lang/String;", "getNonce", "()Ljava/lang/String;", "Lcom/discord/utilities/error/Error;", "error", "Lcom/discord/utilities/error/Error;", "getError", "()Lcom/discord/utilities/error/Error;", "", "Lcom/discord/primitives/ChannelId;", "channelId", "J", "getChannelId", "()J", "<init>", "(Lcom/discord/utilities/error/Error;JLjava/lang/String;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    /* renamed from: com.discord.utilities.messagesend.MessageResult$CaptchaRequired */
    public static final class CaptchaRequired extends MessageQueue4 {
        private final long channelId;
        private final Error error;
        private final String nonce;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public CaptchaRequired(Error error, long j, String str) {
            super(null);
            Intrinsics3.checkNotNullParameter(error, "error");
            this.error = error;
            this.channelId = j;
            this.nonce = str;
        }

        public final long getChannelId() {
            return this.channelId;
        }

        public final Error getError() {
            return this.error;
        }

        public final String getNonce() {
            return this.nonce;
        }
    }

    /* compiled from: MessageQueue.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/discord/utilities/messagesend/MessageResult$NetworkFailure;", "Lcom/discord/utilities/messagesend/MessageResult;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    /* renamed from: com.discord.utilities.messagesend.MessageResult$NetworkFailure */
    public static final class NetworkFailure extends MessageQueue4 {
        public static final NetworkFailure INSTANCE = new NetworkFailure();

        private NetworkFailure() {
            super(null);
        }
    }

    /* compiled from: MessageQueue.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/discord/utilities/messagesend/MessageResult$NoValidContent;", "Lcom/discord/utilities/messagesend/MessageResult;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    /* renamed from: com.discord.utilities.messagesend.MessageResult$NoValidContent */
    public static final class NoValidContent extends MessageQueue4 {
        public static final NoValidContent INSTANCE = new NoValidContent();

        private NoValidContent() {
            super(null);
        }
    }

    /* compiled from: MessageQueue.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0019\u0010\u0003\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/discord/utilities/messagesend/MessageResult$RateLimited;", "Lcom/discord/utilities/messagesend/MessageResult;", "", "retryAfterMs", "J", "getRetryAfterMs", "()J", "<init>", "(J)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    /* renamed from: com.discord.utilities.messagesend.MessageResult$RateLimited */
    public static final class RateLimited extends MessageQueue4 {
        private final long retryAfterMs;

        public RateLimited(long j) {
            super(null);
            this.retryAfterMs = j;
        }

        public final long getRetryAfterMs() {
            return this.retryAfterMs;
        }
    }

    /* compiled from: MessageQueue.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0019\u0010\u0003\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/discord/utilities/messagesend/MessageResult$Slowmode;", "Lcom/discord/utilities/messagesend/MessageResult;", "", "cooldownMs", "J", "getCooldownMs", "()J", "<init>", "(J)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    /* renamed from: com.discord.utilities.messagesend.MessageResult$Slowmode */
    public static final class Slowmode extends MessageQueue4 {
        private final long cooldownMs;

        public Slowmode(long j) {
            super(null);
            this.cooldownMs = j;
        }

        public final long getCooldownMs() {
            return this.cooldownMs;
        }
    }

    /* compiled from: MessageQueue.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0019\u0010\u0003\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/discord/utilities/messagesend/MessageResult$Success;", "Lcom/discord/utilities/messagesend/MessageResult;", "Lcom/discord/api/message/Message;", "message", "Lcom/discord/api/message/Message;", "getMessage", "()Lcom/discord/api/message/Message;", "<init>", "(Lcom/discord/api/message/Message;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    /* renamed from: com.discord.utilities.messagesend.MessageResult$Success */
    public static final class Success extends MessageQueue4 {
        private final com.discord.api.message.Message message;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Success(com.discord.api.message.Message message) {
            super(null);
            Intrinsics3.checkNotNullParameter(message, "message");
            this.message = message;
        }

        public final com.discord.api.message.Message getMessage() {
            return this.message;
        }
    }

    /* compiled from: MessageQueue.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/discord/utilities/messagesend/MessageResult$Timeout;", "Lcom/discord/utilities/messagesend/MessageResult;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    /* renamed from: com.discord.utilities.messagesend.MessageResult$Timeout */
    public static final class Timeout extends MessageQueue4 {
        public static final Timeout INSTANCE = new Timeout();

        private Timeout() {
            super(null);
        }
    }

    /* compiled from: MessageQueue.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0019\u0010\u0003\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/discord/utilities/messagesend/MessageResult$UnknownFailure;", "Lcom/discord/utilities/messagesend/MessageResult;", "Lcom/discord/utilities/error/Error;", "error", "Lcom/discord/utilities/error/Error;", "getError", "()Lcom/discord/utilities/error/Error;", "<init>", "(Lcom/discord/utilities/error/Error;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    /* renamed from: com.discord.utilities.messagesend.MessageResult$UnknownFailure */
    public static final class UnknownFailure extends MessageQueue4 {
        private final Error error;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public UnknownFailure(Error error) {
            super(null);
            Intrinsics3.checkNotNullParameter(error, "error");
            this.error = error;
        }

        public final Error getError() {
            return this.error;
        }
    }

    /* compiled from: MessageQueue.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/discord/utilities/messagesend/MessageResult$UserCancelled;", "Lcom/discord/utilities/messagesend/MessageResult;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    /* renamed from: com.discord.utilities.messagesend.MessageResult$UserCancelled */
    public static final class UserCancelled extends MessageQueue4 {
        public static final UserCancelled INSTANCE = new UserCancelled();

        private UserCancelled() {
            super(null);
        }
    }

    /* compiled from: MessageQueue.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0019\u0010\u0003\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/discord/utilities/messagesend/MessageResult$ValidationError;", "Lcom/discord/utilities/messagesend/MessageResult;", "", "message", "Ljava/lang/String;", "getMessage", "()Ljava/lang/String;", "<init>", "(Ljava/lang/String;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    /* renamed from: com.discord.utilities.messagesend.MessageResult$ValidationError */
    public static final class ValidationError extends MessageQueue4 {
        private final String message;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ValidationError(String str) {
            super(null);
            Intrinsics3.checkNotNullParameter(str, "message");
            this.message = str;
        }

        public final String getMessage() {
            return this.message;
        }
    }

    private MessageQueue4() {
    }

    public /* synthetic */ MessageQueue4(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
