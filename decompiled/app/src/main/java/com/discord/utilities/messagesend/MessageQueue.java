package com.discord.utilities.messagesend;

import android.content.ContentResolver;
import android.content.Context;
import androidx.core.app.NotificationCompat;
import com.discord.api.activity.Activity;
import com.discord.api.application.Application;
import com.discord.api.message.Message;
import com.discord.api.message.MessageReference;
import com.discord.api.message.activity.MessageActivity;
import com.discord.api.message.allowedmentions.MessageAllowedMentions;
import com.discord.api.sticker.Sticker;
import com.discord.api.sticker.StickerPartial;
import com.discord.restapi.PayloadJSON;
import com.discord.restapi.RestAPIParams;
import com.discord.utilities.analytics.Traits;
import com.discord.utilities.captcha.CaptchaHelper;
import com.discord.utilities.error.Error;
import com.discord.utilities.messagesend.MessageQueue3;
import com.discord.utilities.messagesend.MessageQueue4;
import com.discord.utilities.networking.Backoff;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rest.SendUtils;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.time.Clock;
import d0.t.Iterables2;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import j0.k.Func1;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import okhttp3.MultipartBody;
import rx.Observable;
import rx.Subscription;
import rx.functions.Action1;

/* compiled from: MessageQueue.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0096\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 A2\u00020\u0001:\u0003ABCB\u001f\u0012\u0006\u0010(\u001a\u00020'\u0012\u0006\u0010=\u001a\u00020<\u0012\u0006\u0010+\u001a\u00020*¢\u0006\u0004\b?\u0010@J\u000f\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0004J\u001f\u0010\n\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u001f\u0010\u000e\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u001f\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u001f\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0016\u0010\u0017J+\u0010\u001d\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\b2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001bH\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ\u0015\u0010 \u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u001f¢\u0006\u0004\b \u0010!J\u0015\u0010$\u001a\u00020\u00022\u0006\u0010#\u001a\u00020\"¢\u0006\u0004\b$\u0010%J\r\u0010&\u001a\u00020\u0002¢\u0006\u0004\b&\u0010\u0004R\u0016\u0010(\u001a\u00020'8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b(\u0010)R\u0016\u0010+\u001a\u00020*8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b+\u0010,R\u0018\u0010.\u001a\u0004\u0018\u00010-8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b.\u0010/R\u0018\u00101\u001a\u0004\u0018\u0001008\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b1\u00102R\u001c\u00104\u001a\b\u0012\u0004\u0012\u00020\u001f038\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b4\u00105R\u0016\u00107\u001a\u0002068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b7\u00108R\u0016\u0010:\u001a\u0002098\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b:\u0010;R\u0016\u0010=\u001a\u00020<8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b=\u0010>¨\u0006D"}, d2 = {"Lcom/discord/utilities/messagesend/MessageQueue;", "", "", "processNextRequest", "()V", "onDrainingCompleted", "Lcom/discord/utilities/messagesend/MessageRequest$Send;", "request", "Lcom/discord/utilities/messagesend/MessageQueue$DrainListener;", "drainListener", "doSend", "(Lcom/discord/utilities/messagesend/MessageRequest$Send;Lcom/discord/utilities/messagesend/MessageQueue$DrainListener;)V", "Lcom/discord/utilities/messagesend/MessageRequest$Edit;", "editRequest", "doEdit", "(Lcom/discord/utilities/messagesend/MessageRequest$Edit;Lcom/discord/utilities/messagesend/MessageQueue$DrainListener;)V", "Lcom/discord/utilities/messagesend/MessageRequest$SendApplicationCommand;", "sendApplicationCommandRequest", "doSendApplicationCommand", "(Lcom/discord/utilities/messagesend/MessageRequest$SendApplicationCommand;Lcom/discord/utilities/messagesend/MessageQueue$DrainListener;)V", "Lcom/discord/api/message/Message;", "message", "handleSuccess", "(Lcom/discord/api/message/Message;Lcom/discord/utilities/messagesend/MessageQueue$DrainListener;)V", "Lcom/discord/utilities/error/Error;", "error", "onDrainListener", "Lcom/discord/models/message/Message;", "clientMessage", "handleError", "(Lcom/discord/utilities/error/Error;Lcom/discord/utilities/messagesend/MessageQueue$DrainListener;Lcom/discord/models/message/Message;)V", "Lcom/discord/utilities/messagesend/MessageRequest;", "enqueue", "(Lcom/discord/utilities/messagesend/MessageRequest;)V", "", "requestId", "cancel", "(Ljava/lang/String;)V", "handleConnected", "Landroid/content/ContentResolver;", "contentResolver", "Landroid/content/ContentResolver;", "Lcom/discord/utilities/time/Clock;", "clock", "Lcom/discord/utilities/time/Clock;", "Lcom/discord/utilities/messagesend/MessageQueue$InflightRequest;", "inFlightRequest", "Lcom/discord/utilities/messagesend/MessageQueue$InflightRequest;", "Lrx/Subscription;", "retrySubscription", "Lrx/Subscription;", "Ljava/util/ArrayDeque;", "queue", "Ljava/util/ArrayDeque;", "", "isDraining", "Z", "Lcom/discord/utilities/networking/Backoff;", "networkBackoff", "Lcom/discord/utilities/networking/Backoff;", "Ljava/util/concurrent/ExecutorService;", "executorService", "Ljava/util/concurrent/ExecutorService;", "<init>", "(Landroid/content/ContentResolver;Ljava/util/concurrent/ExecutorService;Lcom/discord/utilities/time/Clock;)V", "Companion", "DrainListener", "InflightRequest", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class MessageQueue {
    private static final Companion Companion = new Companion(null);

    @Deprecated
    private static final long DEFAULT_MESSAGE_TIMEOUT_MS = 3600000;

    @Deprecated
    private static final long DEFAULT_NETWORK_INITIAL_FAILURE_RETRY_MS = 5000;

    @Deprecated
    private static final long DEFAULT_RETRY_MS = 100;
    private final Clock clock;
    private final ContentResolver contentResolver;
    private final ExecutorService executorService;
    private InflightRequest inFlightRequest;
    private boolean isDraining;
    private final Backoff networkBackoff;
    private final ArrayDeque<MessageQueue3> queue;
    private Subscription retrySubscription;

    /* compiled from: MessageQueue.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0007\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0005\u001a\u00020\u00028\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0016\u0010\u0006\u001a\u00020\u00028\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0006\u0010\u0004¨\u0006\t"}, d2 = {"Lcom/discord/utilities/messagesend/MessageQueue$Companion;", "", "", "DEFAULT_MESSAGE_TIMEOUT_MS", "J", "DEFAULT_NETWORK_INITIAL_FAILURE_RETRY_MS", "DEFAULT_RETRY_MS", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: MessageQueue.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001B\u001b\u0012\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040\u0007¢\u0006\u0004\b\r\u0010\u000eJ\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\"\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040\u00078\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0016\u0010\u000b\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010\f¨\u0006\u000f"}, d2 = {"Lcom/discord/utilities/messagesend/MessageQueue$DrainListener;", "", "Lcom/discord/utilities/messagesend/MessageResult;", "result", "", "complete", "(Lcom/discord/utilities/messagesend/MessageResult;)V", "Lkotlin/Function1;", "onCompleted", "Lkotlin/jvm/functions/Function1;", "Ljava/util/concurrent/atomic/AtomicBoolean;", "isCompleted", "Ljava/util/concurrent/atomic/AtomicBoolean;", "<init>", "(Lkotlin/jvm/functions/Function1;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class DrainListener {
        private AtomicBoolean isCompleted;
        private final Function1<MessageQueue4, Unit> onCompleted;

        /* JADX WARN: Multi-variable type inference failed */
        public DrainListener(Function1<? super MessageQueue4, Unit> function1) {
            Intrinsics3.checkNotNullParameter(function1, "onCompleted");
            this.onCompleted = function1;
            this.isCompleted = new AtomicBoolean(false);
        }

        public final synchronized void complete(MessageQueue4 result) {
            Intrinsics3.checkNotNullParameter(result, "result");
            if (!this.isCompleted.getAndSet(true)) {
                this.onCompleted.invoke(result);
            }
        }
    }

    /* compiled from: MessageQueue.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0002\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\r\u001a\u00020\f\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0011\u0010\u0012R\u0019\u0010\u0003\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\b\u001a\u00020\u00078\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u0019\u0010\r\u001a\u00020\f8\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0013"}, d2 = {"Lcom/discord/utilities/messagesend/MessageQueue$InflightRequest;", "", "Lcom/discord/utilities/messagesend/MessageQueue$DrainListener;", "drainListener", "Lcom/discord/utilities/messagesend/MessageQueue$DrainListener;", "getDrainListener", "()Lcom/discord/utilities/messagesend/MessageQueue$DrainListener;", "Lrx/Subscription;", "networkSubscription", "Lrx/Subscription;", "getNetworkSubscription", "()Lrx/Subscription;", "Lcom/discord/utilities/messagesend/MessageRequest;", "baseRequest", "Lcom/discord/utilities/messagesend/MessageRequest;", "getBaseRequest", "()Lcom/discord/utilities/messagesend/MessageRequest;", "<init>", "(Lcom/discord/utilities/messagesend/MessageRequest;Lrx/Subscription;Lcom/discord/utilities/messagesend/MessageQueue$DrainListener;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class InflightRequest {
        private final MessageQueue3 baseRequest;
        private final DrainListener drainListener;
        private final Subscription networkSubscription;

        public InflightRequest(MessageQueue3 messageQueue3, Subscription subscription, DrainListener drainListener) {
            Intrinsics3.checkNotNullParameter(messageQueue3, "baseRequest");
            Intrinsics3.checkNotNullParameter(subscription, "networkSubscription");
            Intrinsics3.checkNotNullParameter(drainListener, "drainListener");
            this.baseRequest = messageQueue3;
            this.networkSubscription = subscription;
            this.drainListener = drainListener;
        }

        public final MessageQueue3 getBaseRequest() {
            return this.baseRequest;
        }

        public final DrainListener getDrainListener() {
            return this.drainListener;
        }

        public final Subscription getNetworkSubscription() {
            return this.networkSubscription;
        }
    }

    /* compiled from: MessageQueue.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "run", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.utilities.messagesend.MessageQueue$cancel$1, reason: invalid class name */
    public static final class AnonymousClass1 implements Runnable {
        public final /* synthetic */ String $requestId;

        public AnonymousClass1(String str) {
            this.$requestId = str;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Object next;
            InflightRequest inflightRequestAccess$getInFlightRequest$p = MessageQueue.access$getInFlightRequest$p(MessageQueue.this);
            if (inflightRequestAccess$getInFlightRequest$p != null && Intrinsics3.areEqual(inflightRequestAccess$getInFlightRequest$p.getBaseRequest().getRequestId(), this.$requestId)) {
                inflightRequestAccess$getInFlightRequest$p.getNetworkSubscription().unsubscribe();
                inflightRequestAccess$getInFlightRequest$p.getDrainListener().complete(MessageQueue4.UserCancelled.INSTANCE);
                return;
            }
            Iterator it = MessageQueue.access$getQueue$p(MessageQueue.this).iterator();
            while (true) {
                if (!it.hasNext()) {
                    next = null;
                    break;
                } else {
                    next = it.next();
                    if (Intrinsics3.areEqual(((MessageQueue3) next).getRequestId(), this.$requestId)) {
                        break;
                    }
                }
            }
            MessageQueue3 messageQueue3 = (MessageQueue3) next;
            if (messageQueue3 != null) {
                MessageQueue.access$getQueue$p(MessageQueue.this).remove(messageQueue3);
                messageQueue3.getOnCompleted().invoke(MessageQueue4.UserCancelled.INSTANCE, Boolean.valueOf(MessageQueue.access$getQueue$p(MessageQueue.this).isEmpty()));
            }
        }
    }

    /* compiled from: MessageQueue.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/api/message/Message;", "message", "", "invoke", "(Lcom/discord/api/message/Message;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.utilities.messagesend.MessageQueue$doEdit$2, reason: invalid class name */
    public static final class AnonymousClass2 extends Lambda implements Function1<Message, Unit> {
        public final /* synthetic */ DrainListener $drainListener;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(DrainListener drainListener) {
            super(1);
            this.$drainListener = drainListener;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Message message) {
            invoke2(message);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Message message) {
            Intrinsics3.checkNotNullParameter(message, "message");
            MessageQueue.access$handleSuccess(MessageQueue.this, message, this.$drainListener);
        }
    }

    /* compiled from: MessageQueue.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/utilities/error/Error;", "it", "", "invoke", "(Lcom/discord/utilities/error/Error;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.utilities.messagesend.MessageQueue$doEdit$3, reason: invalid class name */
    public static final class AnonymousClass3 extends Lambda implements Function1<Error, Unit> {
        public final /* synthetic */ DrainListener $drainListener;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass3(DrainListener drainListener) {
            super(1);
            this.$drainListener = drainListener;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Error error) {
            invoke2(error);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Error error) {
            Intrinsics3.checkNotNullParameter(error, "it");
            MessageQueue.handleError$default(MessageQueue.this, error, this.$drainListener, null, 4, null);
        }
    }

    /* compiled from: MessageQueue.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lrx/Subscription;", Traits.Payment.Type.SUBSCRIPTION, "", "invoke", "(Lrx/Subscription;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.utilities.messagesend.MessageQueue$doEdit$4, reason: invalid class name */
    public static final class AnonymousClass4 extends Lambda implements Function1<Subscription, Unit> {
        public final /* synthetic */ DrainListener $drainListener;
        public final /* synthetic */ MessageQueue3.Edit $editRequest;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass4(MessageQueue3.Edit edit, DrainListener drainListener) {
            super(1);
            this.$editRequest = edit;
            this.$drainListener = drainListener;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Subscription subscription) {
            invoke2(subscription);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Subscription subscription) {
            Intrinsics3.checkNotNullParameter(subscription, Traits.Payment.Type.SUBSCRIPTION);
            MessageQueue.access$setInFlightRequest$p(MessageQueue.this, new InflightRequest(this.$editRequest, subscription, this.$drainListener));
        }
    }

    /* compiled from: MessageQueue.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/discord/utilities/rest/SendUtils$SendPayload;", "kotlin.jvm.PlatformType", "sendPayload", "", NotificationCompat.CATEGORY_CALL, "(Lcom/discord/utilities/rest/SendUtils$SendPayload;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.utilities.messagesend.MessageQueue$doSend$1, reason: invalid class name */
    public static final class AnonymousClass1<T> implements Action1<SendUtils.SendPayload> {
        public final /* synthetic */ MessageQueue3.Send $request;

        public AnonymousClass1(MessageQueue3.Send send) {
            this.$request = send;
        }

        @Override // rx.functions.Action1
        public /* bridge */ /* synthetic */ void call(SendUtils.SendPayload sendPayload) {
            call2(sendPayload);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final void call2(SendUtils.SendPayload sendPayload) {
            if (sendPayload instanceof SendUtils.SendPayload.Preprocessing) {
                this.$request.getOnPreprocessing().invoke(sendPayload);
            } else if (sendPayload instanceof SendUtils.SendPayload.ReadyToSend) {
                SendUtils.SendPayload.ReadyToSend readyToSend = (SendUtils.SendPayload.ReadyToSend) sendPayload;
                if (!readyToSend.getUploads().isEmpty()) {
                    this.$request.getOnProgress().invoke(readyToSend.getUploads());
                }
            }
        }
    }

    /* compiled from: MessageQueue.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0007\u001a*\u0012\u000e\b\u0001\u0012\n \u0001*\u0004\u0018\u00010\u00040\u0004 \u0001*\u0014\u0012\u000e\b\u0001\u0012\n \u0001*\u0004\u0018\u00010\u00040\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lcom/discord/utilities/rest/SendUtils$SendPayload$ReadyToSend;", "kotlin.jvm.PlatformType", "sendPayload", "Lrx/Observable;", "Lcom/discord/api/message/Message;", NotificationCompat.CATEGORY_CALL, "(Lcom/discord/utilities/rest/SendUtils$SendPayload$ReadyToSend;)Lrx/Observable;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.utilities.messagesend.MessageQueue$doSend$2, reason: invalid class name */
    public static final class AnonymousClass2<T, R> implements Func1<SendUtils.SendPayload.ReadyToSend, Observable<? extends Message>> {
        public final /* synthetic */ com.discord.models.message.Message $message;

        public AnonymousClass2(com.discord.models.message.Message message) {
            this.$message = message;
        }

        @Override // j0.k.Func1
        public /* bridge */ /* synthetic */ Observable<? extends Message> call(SendUtils.SendPayload.ReadyToSend readyToSend) {
            return call2(readyToSend);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final Observable<? extends Message> call2(SendUtils.SendPayload.ReadyToSend readyToSend) {
            List<SendUtils.FileUpload> uploads = readyToSend.getUploads();
            ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(uploads, 10));
            Iterator<T> it = uploads.iterator();
            while (it.hasNext()) {
                arrayList.add(((SendUtils.FileUpload) it.next()).getPart());
            }
            if (!(!arrayList.isEmpty())) {
                return RestAPI.INSTANCE.getApi().sendMessage(this.$message.getChannelId(), readyToSend.getMessage());
            }
            RestAPI api = RestAPI.INSTANCE.getApi();
            long channelId = this.$message.getChannelId();
            PayloadJSON<RestAPIParams.Message> payloadJSON = new PayloadJSON<>(readyToSend.getMessage());
            Object[] array = arrayList.toArray(new MultipartBody.Part[0]);
            Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
            return api.sendMessage(channelId, payloadJSON, (MultipartBody.Part[]) array);
        }
    }

    /* compiled from: MessageQueue.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/discord/api/message/Message;", "kotlin.jvm.PlatformType", "resultMessage", "", "invoke", "(Lcom/discord/api/message/Message;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.utilities.messagesend.MessageQueue$doSend$3, reason: invalid class name */
    public static final class AnonymousClass3 extends Lambda implements Function1<Message, Unit> {
        public final /* synthetic */ DrainListener $drainListener;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass3(DrainListener drainListener) {
            super(1);
            this.$drainListener = drainListener;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Message message) {
            invoke2(message);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Message message) {
            MessageQueue messageQueue = MessageQueue.this;
            Intrinsics3.checkNotNullExpressionValue(message, "resultMessage");
            MessageQueue.access$handleSuccess(messageQueue, message, this.$drainListener);
        }
    }

    /* compiled from: MessageQueue.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/utilities/error/Error;", "it", "", "invoke", "(Lcom/discord/utilities/error/Error;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.utilities.messagesend.MessageQueue$doSend$4, reason: invalid class name */
    public static final class AnonymousClass4 extends Lambda implements Function1<Error, Unit> {
        public final /* synthetic */ DrainListener $drainListener;
        public final /* synthetic */ com.discord.models.message.Message $message;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass4(DrainListener drainListener, com.discord.models.message.Message message) {
            super(1);
            this.$drainListener = drainListener;
            this.$message = message;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Error error) {
            invoke2(error);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Error error) {
            Intrinsics3.checkNotNullParameter(error, "it");
            MessageQueue.access$handleError(MessageQueue.this, error, this.$drainListener, this.$message);
        }
    }

    /* compiled from: MessageQueue.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lrx/Subscription;", Traits.Payment.Type.SUBSCRIPTION, "", "invoke", "(Lrx/Subscription;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.utilities.messagesend.MessageQueue$doSend$5, reason: invalid class name */
    public static final class AnonymousClass5 extends Lambda implements Function1<Subscription, Unit> {
        public final /* synthetic */ DrainListener $drainListener;
        public final /* synthetic */ MessageQueue3.Send $request;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass5(MessageQueue3.Send send, DrainListener drainListener) {
            super(1);
            this.$request = send;
            this.$drainListener = drainListener;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Subscription subscription) {
            invoke2(subscription);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Subscription subscription) {
            Intrinsics3.checkNotNullParameter(subscription, Traits.Payment.Type.SUBSCRIPTION);
            MessageQueue.access$setInFlightRequest$p(MessageQueue.this, new InflightRequest(this.$request, subscription, this.$drainListener));
        }
    }

    /* compiled from: MessageQueue.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/discord/utilities/rest/SendUtils$SendPayload;", "kotlin.jvm.PlatformType", "sendPayload", "", NotificationCompat.CATEGORY_CALL, "(Lcom/discord/utilities/rest/SendUtils$SendPayload;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.utilities.messagesend.MessageQueue$doSendApplicationCommand$1, reason: invalid class name */
    public static final class AnonymousClass1<T> implements Action1<SendUtils.SendPayload> {
        public final /* synthetic */ MessageQueue3.SendApplicationCommand $sendApplicationCommandRequest;

        public AnonymousClass1(MessageQueue3.SendApplicationCommand sendApplicationCommand) {
            this.$sendApplicationCommandRequest = sendApplicationCommand;
        }

        @Override // rx.functions.Action1
        public /* bridge */ /* synthetic */ void call(SendUtils.SendPayload sendPayload) {
            call2(sendPayload);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final void call2(SendUtils.SendPayload sendPayload) {
            if (sendPayload instanceof SendUtils.SendPayload.Preprocessing) {
                this.$sendApplicationCommandRequest.getOnPreprocessing().invoke(sendPayload);
            } else if (sendPayload instanceof SendUtils.SendPayload.ReadyToSendCommand) {
                SendUtils.SendPayload.ReadyToSendCommand readyToSendCommand = (SendUtils.SendPayload.ReadyToSendCommand) sendPayload;
                if (!readyToSendCommand.getUploads().isEmpty()) {
                    this.$sendApplicationCommandRequest.getOnProgress().invoke(readyToSendCommand.getUploads());
                }
            }
        }
    }

    /* compiled from: MessageQueue.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0007\u001a\u001e\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u0004 \u0001*\u000e\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lcom/discord/utilities/rest/SendUtils$SendPayload$ReadyToSendCommand;", "kotlin.jvm.PlatformType", "sendPayload", "Lrx/Observable;", "Ljava/lang/Void;", NotificationCompat.CATEGORY_CALL, "(Lcom/discord/utilities/rest/SendUtils$SendPayload$ReadyToSendCommand;)Lrx/Observable;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.utilities.messagesend.MessageQueue$doSendApplicationCommand$2, reason: invalid class name */
    public static final class AnonymousClass2<T, R> implements Func1<SendUtils.SendPayload.ReadyToSendCommand, Observable<? extends Void>> {
        public static final AnonymousClass2 INSTANCE = new AnonymousClass2();

        @Override // j0.k.Func1
        public /* bridge */ /* synthetic */ Observable<? extends Void> call(SendUtils.SendPayload.ReadyToSendCommand readyToSendCommand) {
            return call2(readyToSendCommand);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final Observable<? extends Void> call2(SendUtils.SendPayload.ReadyToSendCommand readyToSendCommand) {
            List<SendUtils.FileUpload> uploads = readyToSendCommand.getUploads();
            ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(uploads, 10));
            Iterator<T> it = uploads.iterator();
            while (it.hasNext()) {
                arrayList.add(((SendUtils.FileUpload) it.next()).getPart());
            }
            if (!(!arrayList.isEmpty())) {
                return RestAPI.INSTANCE.getApi().sendApplicationCommand(readyToSendCommand.getCommand().toRestApiParam());
            }
            PayloadJSON<RestAPIParams.ApplicationCommand> payloadJSON = new PayloadJSON<>(readyToSendCommand.getCommand().toRestApiParam());
            RestAPI api = RestAPI.INSTANCE.getApi();
            Object[] array = arrayList.toArray(new MultipartBody.Part[0]);
            Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
            return api.sendApplicationCommand(payloadJSON, (MultipartBody.Part[]) array);
        }
    }

    /* compiled from: MessageQueue.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Ljava/lang/Void;", "it", "", "invoke", "(Ljava/lang/Void;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.utilities.messagesend.MessageQueue$doSendApplicationCommand$3, reason: invalid class name */
    public static final class AnonymousClass3 extends Lambda implements Function1<Void, Unit> {
        public final /* synthetic */ DrainListener $drainListener;
        public final /* synthetic */ MessageQueue3.SendApplicationCommand $sendApplicationCommandRequest;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass3(MessageQueue3.SendApplicationCommand sendApplicationCommand, DrainListener drainListener) {
            super(1);
            this.$sendApplicationCommandRequest = sendApplicationCommand;
            this.$drainListener = drainListener;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Void r1) {
            invoke2(r1);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Void r3) {
            MessageQueue.access$handleSuccess(MessageQueue.this, this.$sendApplicationCommandRequest.getMessage(), this.$drainListener);
        }
    }

    /* compiled from: MessageQueue.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/utilities/error/Error;", "it", "", "invoke", "(Lcom/discord/utilities/error/Error;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.utilities.messagesend.MessageQueue$doSendApplicationCommand$4, reason: invalid class name */
    public static final class AnonymousClass4 extends Lambda implements Function1<Error, Unit> {
        public final /* synthetic */ DrainListener $drainListener;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass4(DrainListener drainListener) {
            super(1);
            this.$drainListener = drainListener;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Error error) {
            invoke2(error);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Error error) {
            Intrinsics3.checkNotNullParameter(error, "it");
            MessageQueue.handleError$default(MessageQueue.this, error, this.$drainListener, null, 4, null);
        }
    }

    /* compiled from: MessageQueue.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lrx/Subscription;", Traits.Payment.Type.SUBSCRIPTION, "", "invoke", "(Lrx/Subscription;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.utilities.messagesend.MessageQueue$doSendApplicationCommand$5, reason: invalid class name */
    public static final class AnonymousClass5 extends Lambda implements Function1<Subscription, Unit> {
        public final /* synthetic */ DrainListener $drainListener;
        public final /* synthetic */ MessageQueue3.SendApplicationCommand $sendApplicationCommandRequest;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass5(MessageQueue3.SendApplicationCommand sendApplicationCommand, DrainListener drainListener) {
            super(1);
            this.$sendApplicationCommandRequest = sendApplicationCommand;
            this.$drainListener = drainListener;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Subscription subscription) {
            invoke2(subscription);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Subscription subscription) {
            Intrinsics3.checkNotNullParameter(subscription, Traits.Payment.Type.SUBSCRIPTION);
            MessageQueue.access$setInFlightRequest$p(MessageQueue.this, new InflightRequest(this.$sendApplicationCommandRequest, subscription, this.$drainListener));
        }
    }

    /* compiled from: MessageQueue.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "run", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.utilities.messagesend.MessageQueue$enqueue$1, reason: invalid class name */
    public static final class AnonymousClass1 implements Runnable {
        public final /* synthetic */ MessageQueue3 $request;

        public AnonymousClass1(MessageQueue3 messageQueue3) {
            this.$request = messageQueue3;
        }

        @Override // java.lang.Runnable
        public final void run() {
            MessageQueue.access$getQueue$p(MessageQueue.this).add(this.$request);
            MessageQueue.access$processNextRequest(MessageQueue.this);
        }
    }

    /* compiled from: MessageQueue.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "run", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.utilities.messagesend.MessageQueue$handleConnected$1, reason: invalid class name */
    public static final class AnonymousClass1 implements Runnable {
        public AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (MessageQueue.access$getNetworkBackoff$p(MessageQueue.this).getIsPending()) {
                MessageQueue.access$getNetworkBackoff$p(MessageQueue.this).cancel();
                MessageQueue.access$processNextRequest(MessageQueue.this);
            }
        }
    }

    public MessageQueue(ContentResolver contentResolver, ExecutorService executorService, Clock clock) {
        Intrinsics3.checkNotNullParameter(contentResolver, "contentResolver");
        Intrinsics3.checkNotNullParameter(executorService, "executorService");
        Intrinsics3.checkNotNullParameter(clock, "clock");
        this.contentResolver = contentResolver;
        this.executorService = executorService;
        this.clock = clock;
        this.queue = new ArrayDeque<>();
        this.networkBackoff = new Backoff(5000L, DEFAULT_MESSAGE_TIMEOUT_MS, 0, false, null, 28, null);
    }

    public static final /* synthetic */ ExecutorService access$getExecutorService$p(MessageQueue messageQueue) {
        return messageQueue.executorService;
    }

    public static final /* synthetic */ InflightRequest access$getInFlightRequest$p(MessageQueue messageQueue) {
        return messageQueue.inFlightRequest;
    }

    public static final /* synthetic */ Backoff access$getNetworkBackoff$p(MessageQueue messageQueue) {
        return messageQueue.networkBackoff;
    }

    public static final /* synthetic */ ArrayDeque access$getQueue$p(MessageQueue messageQueue) {
        return messageQueue.queue;
    }

    public static final /* synthetic */ Subscription access$getRetrySubscription$p(MessageQueue messageQueue) {
        return messageQueue.retrySubscription;
    }

    public static final /* synthetic */ void access$handleError(MessageQueue messageQueue, Error error, DrainListener drainListener, com.discord.models.message.Message message) {
        messageQueue.handleError(error, drainListener, message);
    }

    public static final /* synthetic */ void access$handleSuccess(MessageQueue messageQueue, Message message, DrainListener drainListener) {
        messageQueue.handleSuccess(message, drainListener);
    }

    public static final /* synthetic */ void access$onDrainingCompleted(MessageQueue messageQueue) {
        messageQueue.onDrainingCompleted();
    }

    public static final /* synthetic */ void access$processNextRequest(MessageQueue messageQueue) {
        messageQueue.processNextRequest();
    }

    public static final /* synthetic */ void access$setInFlightRequest$p(MessageQueue messageQueue, InflightRequest inflightRequest) {
        messageQueue.inFlightRequest = inflightRequest;
    }

    public static final /* synthetic */ void access$setRetrySubscription$p(MessageQueue messageQueue, Subscription subscription) {
        messageQueue.retrySubscription = subscription;
    }

    private final void doEdit(MessageQueue3.Edit editRequest, DrainListener drainListener) {
        RestAPI api = RestAPI.INSTANCE.getApi();
        long channelId = editRequest.getChannelId();
        long messageId = editRequest.getMessageId();
        String content = editRequest.getContent();
        MessageAllowedMentions allowedMentions = editRequest.getAllowedMentions();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.restSubscribeOn(api.editMessage(channelId, messageId, new RestAPIParams.Message(content, null, null, null, null, null, allowedMentions != null ? RestAPIParams.Message.AllowedMentions.INSTANCE.create(allowedMentions) : null, null, null, 444, null)), false), MessageQueue.class, (Context) null, new AnonymousClass4(editRequest, drainListener), new AnonymousClass3(drainListener), (Function0) null, (Function0) null, new AnonymousClass2(drainListener), 50, (Object) null);
    }

    /* JADX WARN: Removed duplicated region for block: B:48:0x00f1  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00f8  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0100  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void doSend(MessageQueue3.Send request, DrainListener drainListener) {
        RestAPIParams.Message.Activity activity;
        RestAPIParams.Message.MessageReference messageReference;
        ArrayList arrayList;
        ArrayList arrayList2;
        String sessionId;
        MessageQueue4.ValidationError validationErrorValidateMessage = request.validateMessage();
        if (validationErrorValidateMessage != null) {
            drainListener.complete(validationErrorValidateMessage);
            return;
        }
        com.discord.models.message.Message message = request.getMessage();
        boolean z2 = message.getNonce() != null;
        MessageActivity activity2 = message.getActivity();
        if (activity2 != null) {
            Activity activity3 = request.getActivity();
            activity = (activity3 == null || (sessionId = activity3.getSessionId()) == null) ? null : new RestAPIParams.Message.Activity(activity2.getType(), activity2.getPartyId(), sessionId);
        } else {
            activity = null;
        }
        MessageReference messageReference2 = message.getMessageReference();
        if (messageReference2 != null) {
            Long guildId = messageReference2.getGuildId();
            Long channelId = messageReference2.getChannelId();
            Intrinsics3.checkNotNull(channelId);
            messageReference = new RestAPIParams.Message.MessageReference(guildId, channelId.longValue(), messageReference2.getMessageId());
        } else {
            messageReference = null;
        }
        MessageAllowedMentions allowedMentions = message.getAllowedMentions();
        RestAPIParams.Message.AllowedMentions allowedMentionsCreate = allowedMentions != null ? RestAPIParams.Message.AllowedMentions.INSTANCE.create(allowedMentions) : null;
        String content = message.getContent();
        String nonce = message.getNonce();
        Application application = message.getApplication();
        Long lValueOf = application != null ? Long.valueOf(application.getId()) : null;
        List<StickerPartial> stickerItems = message.getStickerItems();
        if (stickerItems != null) {
            arrayList2 = new ArrayList(Iterables2.collectionSizeOrDefault(stickerItems, 10));
            Iterator<T> it = stickerItems.iterator();
            while (it.hasNext()) {
                arrayList2.add(Long.valueOf(((StickerPartial) it.next()).getId()));
            }
        } else {
            List<Sticker> stickers = message.getStickers();
            if (stickers == null) {
                arrayList = null;
                CaptchaHelper.CaptchaPayload captchaPayload = message.getCaptchaPayload();
                String captchaKey = captchaPayload == null ? captchaPayload.getCaptchaKey() : null;
                CaptchaHelper.CaptchaPayload captchaPayload2 = message.getCaptchaPayload();
                Observable<SendUtils.SendPayload> observableU = SendUtils.INSTANCE.getSendPayload(this.contentResolver, new RestAPIParams.Message(content, nonce, lValueOf, activity, arrayList, messageReference, allowedMentionsCreate, captchaKey, captchaPayload2 != null ? captchaPayload2.getCaptchaRqtoken() : null), request.getAttachments()).u(new AnonymousClass1(request));
                Intrinsics3.checkNotNullExpressionValue(observableU, "SendUtils\n        .getSe…  }\n          }\n        }");
                Observable<R> observableG = observableU.y(MessageQueue$doSend$$inlined$filterIs$1.INSTANCE).G(MessageQueue$doSend$$inlined$filterIs$2.INSTANCE);
                Intrinsics3.checkNotNullExpressionValue(observableG, "filter { it is T }.map { it as T }");
                Observable observableA = observableG.Z(1).A(new AnonymousClass2(message));
                Intrinsics3.checkNotNullExpressionValue(observableA, "SendUtils\n        .getSe…ge)\n          }\n        }");
                ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.restSubscribeOn(observableA, z2), MessageQueue.class, (Context) null, new AnonymousClass5(request, drainListener), new AnonymousClass4(drainListener, message), (Function0) null, (Function0) null, new AnonymousClass3(drainListener), 50, (Object) null);
            }
            arrayList2 = new ArrayList(Iterables2.collectionSizeOrDefault(stickers, 10));
            Iterator<T> it2 = stickers.iterator();
            while (it2.hasNext()) {
                arrayList2.add(Long.valueOf(((Sticker) it2.next()).getId()));
            }
        }
        arrayList = arrayList2;
        CaptchaHelper.CaptchaPayload captchaPayload3 = message.getCaptchaPayload();
        if (captchaPayload3 == null) {
        }
        CaptchaHelper.CaptchaPayload captchaPayload22 = message.getCaptchaPayload();
        Observable<SendUtils.SendPayload> observableU2 = SendUtils.INSTANCE.getSendPayload(this.contentResolver, new RestAPIParams.Message(content, nonce, lValueOf, activity, arrayList, messageReference, allowedMentionsCreate, captchaKey, captchaPayload22 != null ? captchaPayload22.getCaptchaRqtoken() : null), request.getAttachments()).u(new AnonymousClass1(request));
        Intrinsics3.checkNotNullExpressionValue(observableU2, "SendUtils\n        .getSe…  }\n          }\n        }");
        Observable<R> observableG2 = observableU2.y(MessageQueue$doSend$$inlined$filterIs$1.INSTANCE).G(MessageQueue$doSend$$inlined$filterIs$2.INSTANCE);
        Intrinsics3.checkNotNullExpressionValue(observableG2, "filter { it is T }.map { it as T }");
        Observable observableA2 = observableG2.Z(1).A(new AnonymousClass2(message));
        Intrinsics3.checkNotNullExpressionValue(observableA2, "SendUtils\n        .getSe…ge)\n          }\n        }");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.restSubscribeOn(observableA2, z2), MessageQueue.class, (Context) null, new AnonymousClass5(request, drainListener), new AnonymousClass4(drainListener, message), (Function0) null, (Function0) null, new AnonymousClass3(drainListener), 50, (Object) null);
    }

    private final void doSendApplicationCommand(MessageQueue3.SendApplicationCommand sendApplicationCommandRequest, DrainListener drainListener) {
        Observable<SendUtils.SendPayload> observableU = SendUtils.INSTANCE.getSendCommandPayload(this.contentResolver, sendApplicationCommandRequest.getApplicationCommandSendData(), sendApplicationCommandRequest.getAttachments()).u(new AnonymousClass1(sendApplicationCommandRequest));
        Intrinsics3.checkNotNullExpressionValue(observableU, "SendUtils\n        .getSe…  }\n          }\n        }");
        Observable<R> observableG = observableU.y(MessageQueue$doSendApplicationCommand$$inlined$filterIs$1.INSTANCE).G(MessageQueue$doSendApplicationCommand$$inlined$filterIs$2.INSTANCE);
        Intrinsics3.checkNotNullExpressionValue(observableG, "filter { it is T }.map { it as T }");
        Observable observableA = observableG.z().A(AnonymousClass2.INSTANCE);
        Intrinsics3.checkNotNullExpressionValue(observableA, "SendUtils\n        .getSe…())\n          }\n        }");
        Observable observableRestSubscribeOn = ObservableExtensionsKt.restSubscribeOn(observableA, false);
        AnonymousClass3 anonymousClass3 = new AnonymousClass3(sendApplicationCommandRequest, drainListener);
        ObservableExtensionsKt.appSubscribe$default(observableRestSubscribeOn, MessageQueue.class, (Context) null, new AnonymousClass5(sendApplicationCommandRequest, drainListener), new AnonymousClass4(drainListener), (Function0) null, (Function0) null, anonymousClass3, 50, (Object) null);
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x008e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void handleError(Error error, DrainListener onDrainListener, com.discord.models.message.Message clientMessage) {
        MessageQueue4 unknownFailure;
        MessageQueue4 autoModBlock;
        Long l;
        Error.Response response = error.getResponse();
        Intrinsics3.checkNotNullExpressionValue(response, "error.response");
        if (response.getCode() == 20016) {
            Error.Response response2 = error.getResponse();
            Intrinsics3.checkNotNullExpressionValue(response2, "error.response");
            Long retryAfterMs = response2.getRetryAfterMs();
            l = retryAfterMs != null ? retryAfterMs : 100L;
            Intrinsics3.checkNotNullExpressionValue(l, "error.response.retryAfterMs ?: DEFAULT_RETRY_MS");
            unknownFailure = new MessageQueue4.Slowmode(l.longValue());
        } else if (error.getType() == Error.Type.RATE_LIMITED) {
            Error.Response response3 = error.getResponse();
            Intrinsics3.checkNotNullExpressionValue(response3, "error.response");
            Long retryAfterMs2 = response3.getRetryAfterMs();
            l = retryAfterMs2 != null ? retryAfterMs2 : 100L;
            Intrinsics3.checkNotNullExpressionValue(l, "error.response.retryAfterMs ?: DEFAULT_RETRY_MS");
            unknownFailure = new MessageQueue4.RateLimited(l.longValue());
        } else if (error.getType() == Error.Type.NETWORK) {
            unknownFailure = MessageQueue4.NetworkFailure.INSTANCE;
        } else if (error.getType() == Error.Type.DISCORD_BAD_REQUEST) {
            Error.Response response4 = error.getResponse();
            Intrinsics3.checkNotNullExpressionValue(response4, "error.response");
            if (!response4.getMessages().containsKey(CaptchaHelper.CAPTCHA_KEY) || clientMessage == null) {
                Error.Response response5 = error.getResponse();
                Intrinsics3.checkNotNullExpressionValue(response5, "error.response");
                if (response5.getCode() == 200000) {
                    autoModBlock = new MessageQueue4.AutoModBlock(error, clientMessage);
                } else {
                    unknownFailure = new MessageQueue4.UnknownFailure(error);
                }
            } else {
                autoModBlock = new MessageQueue4.CaptchaRequired(error, clientMessage.getChannelId(), clientMessage.getNonce());
            }
            unknownFailure = autoModBlock;
        }
        onDrainListener.complete(unknownFailure);
    }

    public static /* synthetic */ void handleError$default(MessageQueue messageQueue, Error error, DrainListener drainListener, com.discord.models.message.Message message, int i, Object obj) {
        if ((i & 4) != 0) {
            message = null;
        }
        messageQueue.handleError(error, drainListener, message);
    }

    private final void handleSuccess(Message message, DrainListener drainListener) {
        drainListener.complete(new MessageQueue4.Success(message));
    }

    private final void onDrainingCompleted() {
        this.isDraining = false;
        this.inFlightRequest = null;
    }

    private final void processNextRequest() {
        MessageQueue3 messageQueue3Remove;
        if (this.queue.isEmpty() || this.retrySubscription != null || this.networkBackoff.getIsPending() || this.isDraining || (messageQueue3Remove = this.queue.remove()) == null) {
            return;
        }
        if (this.clock.currentTimeMillis() - messageQueue3Remove.getAttemptTimestamp() > DEFAULT_MESSAGE_TIMEOUT_MS) {
            messageQueue3Remove.getOnCompleted().invoke(MessageQueue4.Timeout.INSTANCE, Boolean.valueOf(this.queue.isEmpty()));
            this.networkBackoff.succeed();
            processNextRequest();
            return;
        }
        this.isDraining = true;
        DrainListener drainListener = new DrainListener(new MessageQueue2(this, messageQueue3Remove));
        if (messageQueue3Remove instanceof MessageQueue3.Send) {
            doSend((MessageQueue3.Send) messageQueue3Remove, drainListener);
        } else if (messageQueue3Remove instanceof MessageQueue3.Edit) {
            doEdit((MessageQueue3.Edit) messageQueue3Remove, drainListener);
        } else if (messageQueue3Remove instanceof MessageQueue3.SendApplicationCommand) {
            doSendApplicationCommand((MessageQueue3.SendApplicationCommand) messageQueue3Remove, drainListener);
        }
    }

    public final void cancel(String requestId) {
        Intrinsics3.checkNotNullParameter(requestId, "requestId");
        this.executorService.submit(new AnonymousClass1(requestId));
    }

    public final void enqueue(MessageQueue3 request) {
        Intrinsics3.checkNotNullParameter(request, "request");
        this.executorService.submit(new AnonymousClass1(request));
    }

    public final void handleConnected() {
        this.executorService.submit(new AnonymousClass1());
    }
}
