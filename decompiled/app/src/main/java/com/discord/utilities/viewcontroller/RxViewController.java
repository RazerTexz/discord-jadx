package com.discord.utilities.viewcontroller;

import android.content.Context;
import android.view.View;
import androidx.annotation.MainThread;
import androidx.core.app.NotificationCompat;
import androidx.exifinterface.media.ExifInterface;
import com.discord.utilities.analytics.Traits;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import j0.k.Func1;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Ref$ObjectRef;
import rx.Observable;
import rx.Subscription;

/* compiled from: RxViewController.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\b&\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u0001*\u0004\b\u0001\u0010\u00032\u00020\u0004B\u000f\u0012\u0006\u0010\u0005\u001a\u00028\u0000¢\u0006\u0004\b\u001a\u0010\u001bJ?\u0010\f\u001a\u00020\u000b\"\u0004\b\u0002\u0010\u00032\u0006\u0010\u0005\u001a\u00020\u00012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00020\u00062\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00020\t0\bH\u0002¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u000f\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00028\u0001H&¢\u0006\u0004\b\u000f\u0010\u0010J\u0015\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00010\u0006H&¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\tH\u0007¢\u0006\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0005\u001a\u00028\u00008\u0004@\u0004X\u0084\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019¨\u0006\u001c"}, d2 = {"Lcom/discord/utilities/viewcontroller/RxViewController;", "Landroid/view/View;", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, ExifInterface.GPS_DIRECTION_TRUE, "", "view", "Lrx/Observable;", "observable", "Lkotlin/Function1;", "", "onNext", "Lrx/Subscription;", "connectViewRx", "(Landroid/view/View;Lrx/Observable;Lkotlin/jvm/functions/Function1;)Lrx/Subscription;", "viewState", "configureView", "(Ljava/lang/Object;)V", "observeState", "()Lrx/Observable;", "bind", "()V", "Landroid/view/View;", "getView", "()Landroid/view/View;", Traits.Payment.Type.SUBSCRIPTION, "Lrx/Subscription;", "<init>", "(Landroid/view/View;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public abstract class RxViewController<V extends View, T> {
    private Subscription subscription;
    private final V view;

    /* compiled from: RxViewController.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0007\u001a\u00020\u0004\"\b\b\u0000\u0010\u0001*\u00020\u0000\"\u0004\b\u0001\u0010\u00022\u0006\u0010\u0003\u001a\u00028\u0001H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Landroid/view/View;", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, ExifInterface.GPS_DIRECTION_TRUE, "it", "", "invoke", "(Ljava/lang/Object;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.utilities.viewcontroller.RxViewController$bind$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<T, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Object obj) {
            invoke2((AnonymousClass1) obj);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(T t) {
            RxViewController.this.configureView(t);
        }
    }

    /* compiled from: RxViewController.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\b\u001a\n \u0003*\u0004\u0018\u00010\u00050\u0005\"\u0004\b\u0000\u0010\u0000\"\b\b\u0001\u0010\u0002*\u00020\u0001\"\u0004\b\u0002\u0010\u00002\u000e\u0010\u0004\u001a\n \u0003*\u0004\u0018\u00018\u00028\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "Landroid/view/View;", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "kotlin.jvm.PlatformType", "it", "", NotificationCompat.CATEGORY_CALL, "(Ljava/lang/Object;)Ljava/lang/Boolean;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.utilities.viewcontroller.RxViewController$connectViewRx$1, reason: invalid class name */
    public static final class AnonymousClass1<T, R> implements Func1<T, Boolean> {
        public final /* synthetic */ View $view;

        public AnonymousClass1(View view) {
            this.$view = view;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // j0.k.Func1
        public /* bridge */ /* synthetic */ Boolean call(Object obj) {
            return call((AnonymousClass1<T, R>) obj);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // j0.k.Func1
        public final Boolean call(T t) {
            return Boolean.valueOf(this.$view.isAttachedToWindow());
        }
    }

    /* compiled from: RxViewController.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\b\u001a\u00020\u0005\"\u0004\b\u0000\u0010\u0000\"\b\b\u0001\u0010\u0002*\u00020\u0001\"\u0004\b\u0002\u0010\u00002\u0006\u0010\u0004\u001a\u00020\u0003H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "Landroid/view/View;", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "Lrx/Subscription;", Traits.Payment.Type.SUBSCRIPTION, "", "invoke", "(Lrx/Subscription;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.utilities.viewcontroller.RxViewController$connectViewRx$2, reason: invalid class name */
    public static final class AnonymousClass2 extends Lambda implements Function1<Subscription, Unit> {
        public final /* synthetic */ Ref$ObjectRef $subscriptionResult;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(Ref$ObjectRef ref$ObjectRef) {
            super(1);
            this.$subscriptionResult = ref$ObjectRef;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Subscription subscription) {
            invoke2(subscription);
            return Unit.a;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Subscription subscription) {
            Intrinsics3.checkNotNullParameter(subscription, Traits.Payment.Type.SUBSCRIPTION);
            this.$subscriptionResult.element = subscription;
        }
    }

    /* compiled from: RxViewController.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\b\u001a\u00020\u0005\"\u0004\b\u0000\u0010\u0000\"\b\b\u0001\u0010\u0002*\u00020\u0001\"\u0004\b\u0002\u0010\u00002\u000e\u0010\u0004\u001a\n \u0003*\u0004\u0018\u00018\u00028\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "Landroid/view/View;", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "kotlin.jvm.PlatformType", "emission", "", "invoke", "(Ljava/lang/Object;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.utilities.viewcontroller.RxViewController$connectViewRx$3, reason: invalid class name */
    public static final class AnonymousClass3 extends Lambda implements Function1<T, Unit> {
        public final /* synthetic */ Function1 $onNext;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass3(Function1 function1) {
            super(1);
            this.$onNext = function1;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Object obj) {
            invoke2((AnonymousClass3) obj);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(T t) {
            this.$onNext.invoke(t);
        }
    }

    public RxViewController(V v) {
        Intrinsics3.checkNotNullParameter(v, "view");
        this.view = v;
    }

    private final <T> Subscription connectViewRx(View view, Observable<T> observable, Function1<? super T, Unit> onNext) {
        Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
        ref$ObjectRef.element = null;
        Observable<T> observableA0 = observable.a0(new ViewDetachedFromWindowObservable(view).observe());
        Intrinsics3.checkNotNullExpressionValue(observableA0, "observable\n        .take…servable(view).observe())");
        Observable<T> observableY = ObservableExtensionsKt.ui(ObservableExtensionsKt.computationLatest(observableA0)).y(new AnonymousClass1(view));
        Intrinsics3.checkNotNullExpressionValue(observableY, "observable\n        .take…view.isAttachedToWindow }");
        ObservableExtensionsKt.appSubscribe$default(observableY, getClass(), (Context) null, new AnonymousClass2(ref$ObjectRef), (Function1) null, (Function0) null, (Function0) null, new AnonymousClass3(onNext), 58, (Object) null);
        T t = ref$ObjectRef.element;
        if (t == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("subscriptionResult");
        }
        return (Subscription) t;
    }

    @MainThread
    public final void bind() {
        Subscription subscription = this.subscription;
        if (subscription != null) {
            subscription.unsubscribe();
        }
        this.subscription = connectViewRx(this.view, observeState(), new AnonymousClass1());
    }

    public abstract void configureView(T viewState);

    public final V getView() {
        return this.view;
    }

    public abstract Observable<T> observeState();
}
