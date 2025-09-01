package com.discord.utilities.rx;

import androidx.exifinterface.media.ExifInterface;
import d0.Result3;
import d0.w.h.Intrinsics2;
import d0.w.h.IntrinsicsJvm;
import d0.w.i.a.ContinuationImpl6;
import d0.w.i.a.DebugMetadata;
import d0.w.i.a.DebugProbes;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import j0.Observer2;
import j0.l.e.ObserverSubscriber;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.channels.Produce;
import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import s.a.CancellableContinuationImpl5;
import s.a.c2.Produce2;
import s.a.d2.Builders;
import s.a.d2.Flow3;

/* compiled from: RxCoroutineUtils.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a#\u0010\u0002\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001H\u0086@ø\u0001\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a#\u0010\u0004\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001H\u0086@ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0003\u001a)\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001H\u0086@ø\u0001\u0000¢\u0006\u0004\b\u0006\u0010\u0003\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0007"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "Lrx/Observable;", "awaitSingle", "(Lrx/Observable;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitFirst", "Ls/a/d2/d;", "toFlow", "utils_release"}, k = 2, mv = {1, 4, 2})
/* renamed from: com.discord.utilities.rx.RxCoroutineUtilsKt, reason: use source file name */
/* loaded from: classes2.dex */
public final class RxCoroutineUtils {

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: RxCoroutineUtils.kt */
    @DebugMetadata(c = "com.discord.utilities.rx.RxCoroutineUtilsKt$toFlow$2", f = "RxCoroutineUtils.kt", l = {47}, m = "invokeSuspend")
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u0002\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/channels/ProducerScope;", "", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.utilities.rx.RxCoroutineUtilsKt$toFlow$2, reason: invalid class name */
    public static final class AnonymousClass2<T> extends ContinuationImpl6 implements Function2<Produce<? super T>, Continuation<? super Unit>, Object> {
        public final /* synthetic */ Observable $this_toFlow;
        private /* synthetic */ Object L$0;
        public int label;

        /* compiled from: RxCoroutineUtils.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
        /* renamed from: com.discord.utilities.rx.RxCoroutineUtilsKt$toFlow$2$1, reason: invalid class name */
        public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
            public final /* synthetic */ Subscription $subscription;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(Subscription subscription) {
                super(0);
                this.$subscription = subscription;
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                this.$subscription.unsubscribe();
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(Observable observable, Continuation continuation) {
            super(2, continuation);
            this.$this_toFlow = observable;
        }

        @Override // d0.w.i.a.ContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Intrinsics3.checkNotNullParameter(continuation, "completion");
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.$this_toFlow, continuation);
            anonymousClass2.L$0 = obj;
            return anonymousClass2;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(obj, continuation)).invokeSuspend(Unit.a);
        }

        @Override // d0.w.i.a.ContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = Intrinsics2.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                Result3.throwOnFailure(obj);
                Produce produce = (Produce) this.L$0;
                Observable observable = this.$this_toFlow;
                Observer2 rxCoroutineUtils5 = new RxCoroutineUtils5(produce);
                Objects.requireNonNull(observable);
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(rxCoroutineUtils5 instanceof Subscriber ? observable.U((Subscriber) rxCoroutineUtils5) : observable.U(new ObserverSubscriber(rxCoroutineUtils5)));
                this.label = 1;
                if (Produce2.a(produce, anonymousClass1, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                Result3.throwOnFailure(obj);
            }
            return Unit.a;
        }
    }

    public static final <T> Object awaitFirst(Observable<T> observable, Continuation<? super T> continuation) {
        Observable<T> observableZ = observable.z();
        Intrinsics3.checkNotNullExpressionValue(observableZ, "first()");
        return awaitSingle(observableZ, continuation);
    }

    public static final <T> Object awaitSingle(Observable<T> observable, Continuation<? super T> continuation) {
        CancellableContinuationImpl5 cancellableContinuationImpl5 = new CancellableContinuationImpl5(IntrinsicsJvm.intercepted(continuation), 1);
        cancellableContinuationImpl5.A();
        cancellableContinuationImpl5.f(new RxCoroutineUtils2(observable.R().W(new RxCoroutineUtils3(cancellableContinuationImpl5), new RxCoroutineUtils4(cancellableContinuationImpl5))));
        Object objU = cancellableContinuationImpl5.u();
        if (objU == Intrinsics2.getCOROUTINE_SUSPENDED()) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return objU;
    }

    public static final <T> Object toFlow(Observable<T> observable, Continuation<? super Flow3<? extends T>> continuation) {
        return new Builders(new AnonymousClass2(observable, null), null, 0, null, 14);
    }
}
