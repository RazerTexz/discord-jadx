package com.discord.utilities.messagesend;

import android.content.Context;
import com.discord.utilities.messagesend.MessageQueue4;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import rx.Observable;
import rx.Subscription;

/* compiled from: MessageQueue.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/utilities/messagesend/MessageResult;", "result", "", "invoke", "(Lcom/discord/utilities/messagesend/MessageResult;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.utilities.messagesend.MessageQueue$processNextRequest$listener$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class MessageQueue2 extends Lambda implements Function1<MessageQueue4, Unit> {
    public final /* synthetic */ MessageQueue3 $request;
    public final /* synthetic */ MessageQueue this$0;

    /* compiled from: MessageQueue.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "kotlin.jvm.PlatformType", "it", "", "invoke", "(Ljava/lang/Long;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.utilities.messagesend.MessageQueue$processNextRequest$listener$1$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<Long, Unit> {

        /* compiled from: MessageQueue.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "run", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
        /* renamed from: com.discord.utilities.messagesend.MessageQueue$processNextRequest$listener$1$1$1, reason: invalid class name and collision with other inner class name */
        public static final class RunnableC02181 implements Runnable {
            public RunnableC02181() {
            }

            @Override // java.lang.Runnable
            public final void run() {
                MessageQueue.access$getQueue$p(MessageQueue2.this.this$0).addFirst(MessageQueue2.this.$request);
                MessageQueue.access$setRetrySubscription$p(MessageQueue2.this.this$0, null);
                MessageQueue.access$onDrainingCompleted(MessageQueue2.this.this$0);
                MessageQueue.access$processNextRequest(MessageQueue2.this.this$0);
            }
        }

        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Long l) {
            invoke2(l);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Long l) {
            MessageQueue.access$getExecutorService$p(MessageQueue2.this.this$0).submit(new RunnableC02181());
        }
    }

    /* compiled from: MessageQueue.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lrx/Subscription;", "it", "", "invoke", "(Lrx/Subscription;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.utilities.messagesend.MessageQueue$processNextRequest$listener$1$2, reason: invalid class name */
    public static final class AnonymousClass2 extends Lambda implements Function1<Subscription, Unit> {
        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Subscription subscription) {
            invoke2(subscription);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Subscription subscription) {
            Intrinsics3.checkNotNullParameter(subscription, "it");
            MessageQueue.access$setRetrySubscription$p(MessageQueue2.this.this$0, subscription);
        }
    }

    /* compiled from: MessageQueue.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "run", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.utilities.messagesend.MessageQueue$processNextRequest$listener$1$3, reason: invalid class name */
    public static final class AnonymousClass3 implements Runnable {

        /* compiled from: MessageQueue.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
        /* renamed from: com.discord.utilities.messagesend.MessageQueue$processNextRequest$listener$1$3$1, reason: invalid class name */
        public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {

            /* compiled from: MessageQueue.kt */
            @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "run", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
            /* renamed from: com.discord.utilities.messagesend.MessageQueue$processNextRequest$listener$1$3$1$1, reason: invalid class name and collision with other inner class name */
            public static final class RunnableC02191 implements Runnable {
                public RunnableC02191() {
                }

                @Override // java.lang.Runnable
                public final void run() {
                    MessageQueue.access$processNextRequest(MessageQueue2.this.this$0);
                }
            }

            public AnonymousClass1() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                MessageQueue.access$getExecutorService$p(MessageQueue2.this.this$0).submit(new RunnableC02191());
            }
        }

        public AnonymousClass3() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            MessageQueue.access$onDrainingCompleted(MessageQueue2.this.this$0);
            MessageQueue.access$getQueue$p(MessageQueue2.this.this$0).addFirst(MessageQueue2.this.$request);
            MessageQueue.access$getNetworkBackoff$p(MessageQueue2.this.this$0).fail(new AnonymousClass1());
        }
    }

    /* compiled from: MessageQueue.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "run", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.utilities.messagesend.MessageQueue$processNextRequest$listener$1$4, reason: invalid class name */
    public static final class AnonymousClass4 implements Runnable {
        public final /* synthetic */ MessageQueue4 $result;

        public AnonymousClass4(MessageQueue4 messageQueue4) {
            this.$result = messageQueue4;
        }

        @Override // java.lang.Runnable
        public final void run() {
            MessageQueue.access$onDrainingCompleted(MessageQueue2.this.this$0);
            MessageQueue2.this.$request.getOnCompleted().invoke(this.$result, Boolean.valueOf(MessageQueue.access$getQueue$p(MessageQueue2.this.this$0).isEmpty()));
            MessageQueue.access$getNetworkBackoff$p(MessageQueue2.this.this$0).succeed();
            MessageQueue.access$processNextRequest(MessageQueue2.this.this$0);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MessageQueue2(MessageQueue messageQueue, MessageQueue3 messageQueue3) {
        super(1);
        this.this$0 = messageQueue;
        this.$request = messageQueue3;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(MessageQueue4 messageQueue4) {
        invoke2(messageQueue4);
        return Unit.a;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(MessageQueue4 messageQueue4) {
        Intrinsics3.checkNotNullParameter(messageQueue4, "result");
        if (!(messageQueue4 instanceof MessageQueue4.RateLimited)) {
            if (messageQueue4 instanceof MessageQueue4.NetworkFailure) {
                MessageQueue.access$getExecutorService$p(this.this$0).submit(new AnonymousClass3());
                return;
            } else {
                MessageQueue.access$getExecutorService$p(this.this$0).submit(new AnonymousClass4(messageQueue4));
                return;
            }
        }
        Observable<Long> observableD0 = Observable.d0(((MessageQueue4.RateLimited) messageQueue4).getRetryAfterMs(), TimeUnit.MILLISECONDS);
        Intrinsics3.checkNotNullExpressionValue(observableD0, "Observable\n             …s, TimeUnit.MILLISECONDS)");
        ObservableExtensionsKt.appSubscribe$default(observableD0, this.this$0.getClass(), (Context) null, new AnonymousClass2(), (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(), 58, (Object) null);
    }
}
