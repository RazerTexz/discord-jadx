package com.discord.utilities.rx;

import android.content.Context;
import d0.z.d.Intrinsics3;
import j0.l.e.ScalarSynchronousObservable;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import rx.Observable;
import rx.Subscriber;
import rx.Subscription;

/* JADX INFO: Add missing generic type declarations: [T] */
/* compiled from: OnDelayedEmissionHandler.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0007*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0004J\u0017\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\u000b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"com/discord/utilities/rx/OnDelayedEmissionHandler$call$wrappedSubscriber$1", "Lrx/Subscriber;", "", "tryFinish", "()V", "onCompleted", "", "e", "onError", "(Ljava/lang/Throwable;)V", "t", "onNext", "(Ljava/lang/Object;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* renamed from: com.discord.utilities.rx.OnDelayedEmissionHandler$call$wrappedSubscriber$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class OnDelayedEmissionHandler2<T> extends Subscriber<T> {
    public final /* synthetic */ Subscriber $subscriber;
    public final /* synthetic */ OnDelayedEmissionHandler this$0;

    public OnDelayedEmissionHandler2(OnDelayedEmissionHandler onDelayedEmissionHandler, Subscriber subscriber) {
        this.this$0 = onDelayedEmissionHandler;
        this.$subscriber = subscriber;
    }

    private final void tryFinish() {
        Subscription subscriptionAccess$getDelaySubscription$p = OnDelayedEmissionHandler.access$getDelaySubscription$p(this.this$0);
        if (subscriptionAccess$getDelaySubscription$p != null) {
            subscriptionAccess$getDelaySubscription$p.unsubscribe();
        }
        Observable<T> observableJ = new ScalarSynchronousObservable(null).J(OnDelayedEmissionHandler.access$getScheduler$p(this.this$0));
        Intrinsics3.checkNotNullExpressionValue(observableJ, "Observable\n            .…    .observeOn(scheduler)");
        ObservableExtensionsKt.appSubscribe$default(observableJ, OnDelayedEmissionHandler2.class, (Context) null, (Function1) null, new OnDelayedEmissionHandler4(this), (Function0) null, (Function0) null, new OnDelayedEmissionHandler3(this), 54, (Object) null);
    }

    @Override // j0.Observer2
    public void onCompleted() {
        if (this.$subscriber.isUnsubscribed()) {
            return;
        }
        tryFinish();
        this.$subscriber.onCompleted();
    }

    @Override // j0.Observer2
    public void onError(Throwable e) {
        Intrinsics3.checkNotNullParameter(e, "e");
        if (this.$subscriber.isUnsubscribed()) {
            return;
        }
        tryFinish();
        this.$subscriber.onError(e);
    }

    @Override // j0.Observer2
    public void onNext(T t) {
        if (this.$subscriber.isUnsubscribed()) {
            return;
        }
        tryFinish();
        this.$subscriber.onNext(t);
    }
}
