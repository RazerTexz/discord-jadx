package com.discord.utilities.rx;

import android.content.Context;
import androidx.core.app.NotificationCompat;
import androidx.exifinterface.media.ExifInterface;
import com.discord.utilities.error.Error;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import j0.j.b.AndroidSchedulers;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;
import rx.Scheduler;
import rx.Subscriber;
import rx.Subscription;

/* compiled from: OnDelayedEmissionHandler.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000*\u0004\b\u0000\u0010\u00012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00000\u0002B9\u0012\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007\u0012\b\b\u0002\u0010\r\u001a\u00020\f\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0018\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u001b\u0010\u001cJ'\u0010\u0005\u001a\n\u0012\u0006\b\u0000\u0012\u00028\u00000\u00032\u000e\u0010\u0004\u001a\n\u0012\u0006\b\u0000\u0012\u00028\u00000\u0003H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\"\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u00078\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0016\u0010\r\u001a\u00020\f8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u0010\u001a\u00020\u000f8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0013\u001a\u00020\u00128\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u0019\u001a\u00020\u00188\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001a¨\u0006\u001d"}, d2 = {"Lcom/discord/utilities/rx/OnDelayedEmissionHandler;", ExifInterface.GPS_DIRECTION_TRUE, "Lrx/Observable$b;", "Lrx/Subscriber;", "subscriber", NotificationCompat.CATEGORY_CALL, "(Lrx/Subscriber;)Lrx/Subscriber;", "Lkotlin/Function1;", "", "", "onDelayCallback", "Lkotlin/jvm/functions/Function1;", "", "timeout", "J", "Ljava/util/concurrent/atomic/AtomicBoolean;", "hasFinished", "Ljava/util/concurrent/atomic/AtomicBoolean;", "Lrx/Scheduler;", "scheduler", "Lrx/Scheduler;", "Lrx/Subscription;", "delaySubscription", "Lrx/Subscription;", "Ljava/util/concurrent/TimeUnit;", "unit", "Ljava/util/concurrent/TimeUnit;", "<init>", "(Lkotlin/jvm/functions/Function1;JLjava/util/concurrent/TimeUnit;Lrx/Scheduler;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class OnDelayedEmissionHandler<T> implements Observable.b<T, T> {
    private Subscription delaySubscription;
    private final AtomicBoolean hasFinished;
    private final Function1<Boolean, Unit> onDelayCallback;
    private final Scheduler scheduler;
    private final long timeout;
    private final TimeUnit unit;

    /* compiled from: OnDelayedEmissionHandler.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0007\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u00002\u000e\u0010\u0003\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "", "kotlin.jvm.PlatformType", "it", "", "invoke", "(Ljava/lang/Long;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.utilities.rx.OnDelayedEmissionHandler$call$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<Long, Unit> {
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
            if (OnDelayedEmissionHandler.access$getHasFinished$p(OnDelayedEmissionHandler.this).get()) {
                return;
            }
            OnDelayedEmissionHandler.access$getOnDelayCallback$p(OnDelayedEmissionHandler.this).invoke(Boolean.TRUE);
        }
    }

    /* compiled from: OnDelayedEmissionHandler.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "Lcom/discord/utilities/error/Error;", "error", "", "invoke", "(Lcom/discord/utilities/error/Error;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.utilities.rx.OnDelayedEmissionHandler$call$2, reason: invalid class name */
    public static final class AnonymousClass2 extends Lambda implements Function1<Error, Unit> {
        public final /* synthetic */ OnDelayedEmissionHandler2 $wrappedSubscriber;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(OnDelayedEmissionHandler2 onDelayedEmissionHandler2) {
            super(1);
            this.$wrappedSubscriber = onDelayedEmissionHandler2;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Error error) {
            invoke2(error);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Error error) {
            Intrinsics3.checkNotNullParameter(error, "error");
            OnDelayedEmissionHandler2 onDelayedEmissionHandler2 = this.$wrappedSubscriber;
            Throwable throwable = error.getThrowable();
            Intrinsics3.checkNotNullExpressionValue(throwable, "error.throwable");
            onDelayedEmissionHandler2.onError(throwable);
        }
    }

    /* compiled from: OnDelayedEmissionHandler.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "Lrx/Subscription;", "it", "", "invoke", "(Lrx/Subscription;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.utilities.rx.OnDelayedEmissionHandler$call$3, reason: invalid class name */
    public static final class AnonymousClass3 extends Lambda implements Function1<Subscription, Unit> {
        public AnonymousClass3() {
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
            OnDelayedEmissionHandler.access$setDelaySubscription$p(OnDelayedEmissionHandler.this, subscription);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public OnDelayedEmissionHandler(Function1<? super Boolean, Unit> function1, long j, TimeUnit timeUnit, Scheduler scheduler) {
        Intrinsics3.checkNotNullParameter(function1, "onDelayCallback");
        Intrinsics3.checkNotNullParameter(timeUnit, "unit");
        Intrinsics3.checkNotNullParameter(scheduler, "scheduler");
        this.onDelayCallback = function1;
        this.timeout = j;
        this.unit = timeUnit;
        this.scheduler = scheduler;
        this.hasFinished = new AtomicBoolean(false);
    }

    public static final /* synthetic */ Subscription access$getDelaySubscription$p(OnDelayedEmissionHandler onDelayedEmissionHandler) {
        return onDelayedEmissionHandler.delaySubscription;
    }

    public static final /* synthetic */ AtomicBoolean access$getHasFinished$p(OnDelayedEmissionHandler onDelayedEmissionHandler) {
        return onDelayedEmissionHandler.hasFinished;
    }

    public static final /* synthetic */ Function1 access$getOnDelayCallback$p(OnDelayedEmissionHandler onDelayedEmissionHandler) {
        return onDelayedEmissionHandler.onDelayCallback;
    }

    public static final /* synthetic */ Scheduler access$getScheduler$p(OnDelayedEmissionHandler onDelayedEmissionHandler) {
        return onDelayedEmissionHandler.scheduler;
    }

    public static final /* synthetic */ void access$setDelaySubscription$p(OnDelayedEmissionHandler onDelayedEmissionHandler, Subscription subscription) {
        onDelayedEmissionHandler.delaySubscription = subscription;
    }

    @Override // j0.k.Func1
    public /* bridge */ /* synthetic */ Object call(Object obj) {
        return call((Subscriber) obj);
    }

    public Subscriber<? super T> call(Subscriber<? super T> subscriber) {
        Intrinsics3.checkNotNullParameter(subscriber, "subscriber");
        OnDelayedEmissionHandler2 onDelayedEmissionHandler2 = new OnDelayedEmissionHandler2(this, subscriber);
        Observable<Long> observableJ = Observable.d0(this.timeout, this.unit).J(this.scheduler);
        Intrinsics3.checkNotNullExpressionValue(observableJ, "Observable\n        .time…    .observeOn(scheduler)");
        AnonymousClass1 anonymousClass1 = new AnonymousClass1();
        ObservableExtensionsKt.appSubscribe$default(observableJ, OnDelayedEmissionHandler.class, (Context) null, new AnonymousClass3(), new AnonymousClass2(onDelayedEmissionHandler2), (Function0) null, (Function0) null, anonymousClass1, 50, (Object) null);
        return onDelayedEmissionHandler2;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ OnDelayedEmissionHandler(Function1 function1, long j, TimeUnit timeUnit, Scheduler scheduler, int i, DefaultConstructorMarker defaultConstructorMarker) {
        long j2 = (i & 2) != 0 ? 0L : j;
        TimeUnit timeUnit2 = (i & 4) != 0 ? TimeUnit.MILLISECONDS : timeUnit;
        if ((i & 8) != 0) {
            scheduler = AndroidSchedulers.a();
            Intrinsics3.checkNotNullExpressionValue(scheduler, "AndroidSchedulers.mainThread()");
        }
        this(function1, j2, timeUnit2, scheduler);
    }
}
