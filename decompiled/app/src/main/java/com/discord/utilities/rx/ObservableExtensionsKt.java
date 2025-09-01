package com.discord.utilities.rx;

import android.content.Context;
import androidx.core.app.NotificationCompat;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import com.discord.app.AppComponent;
import com.discord.restapi.utils.RetryWithDelay;
import com.discord.utilities.analytics.Traits;
import com.discord.utilities.dimmer.DimmerView;
import com.discord.utilities.error.Error;
import com.discord.utilities.mg_recycler.MGRecyclerAdapterSimple;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import j0.j.b.AndroidSchedulers;
import j0.k.Func1;
import j0.l.a.OnSubscribeLift;
import j0.l.e.ActionSubscriber;
import j0.p.Schedulers2;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Tuples2;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import rx.Observable;
import rx.Subscription;
import rx.functions.Action0;

/* compiled from: ObservableExtensions.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000p\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a#\u0010\u0002\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001¢\u0006\u0004\b\u0002\u0010\u0003\u001a;\u0010\u0002\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0005\u001a\u00020\u00042\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0006¢\u0006\u0004\b\u0002\u0010\b\u001a;\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0005\u001a\u00020\u00042\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0006¢\u0006\u0004\b\t\u0010\b\u001a#\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001¢\u0006\u0004\b\n\u0010\u0003\u001a#\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001¢\u0006\u0004\b\u000b\u0010\u0003\u001a-\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\b\b\u0002\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000e\u0010\u000f\u001a\u0099\u0001\u0010\u001e\u001a\u00020\u0016\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\n\u0010\u0011\u001a\u0006\u0012\u0002\b\u00030\u00102\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00122\u0016\b\u0002\u0010\u0017\u001a\u0010\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u00142\u0016\b\u0002\u0010\u0019\u001a\u0010\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u00142\u000e\b\u0002\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00160\u001a2\u000e\b\u0002\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00160\u001a2\u0012\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00160\u0014¢\u0006\u0004\b\u001e\u0010\u001f\u001a\u0095\u0001\u0010\u001e\u001a\u00020\u0016\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00122\u0006\u0010!\u001a\u00020 2\u0016\b\u0002\u0010\u0017\u001a\u0010\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u00142\u0012\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00160\u00142\u0016\b\u0002\u0010\u0019\u001a\u0010\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u00142\u000e\b\u0002\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00160\u001a2\u000e\b\u0002\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00160\u001a¢\u0006\u0004\b\u001e\u0010\"\u001a3\u0010'\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010$\u001a\u00020#2\u0006\u0010&\u001a\u00020%¢\u0006\u0004\b'\u0010(\u001a&\u0010)\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0006\b\u0000\u0010\u0000\u0018\u0001*\u0006\u0012\u0002\b\u00030\u0001H\u0086\b¢\u0006\u0004\b)\u0010\u0003\u001a*\u0010*\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0006\b\u0000\u0010\u0000\u0018\u0001*\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u0001H\u0086\b¢\u0006\u0004\b*\u0010\u0003\u001a?\u0010.\u001a\u0010\u0012\f\u0012\n -*\u0004\u0018\u00018\u00008\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\b\b\u0002\u0010+\u001a\u00020#2\b\b\u0002\u0010,\u001a\u00020\f¢\u0006\u0004\b.\u0010/\u001aA\u00104\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001030\u0001\"\u0004\b\u0000\u00100\"\u0004\b\u0001\u00101*\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001020\u0001¢\u0006\u0004\b4\u0010\u0003\u001a7\u00108\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\b\u00106\u001a\u0004\u0018\u0001052\b\b\u0002\u00107\u001a\u00020#¢\u0006\u0004\b8\u00109¨\u0006:"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "Lrx/Observable;", "ui", "(Lrx/Observable;)Lrx/Observable;", "Lcom/discord/app/AppComponent;", "appComponent", "Lcom/discord/utilities/mg_recycler/MGRecyclerAdapterSimple;", "adapter", "(Lrx/Observable;Lcom/discord/app/AppComponent;Lcom/discord/utilities/mg_recycler/MGRecyclerAdapterSimple;)Lrx/Observable;", "bindToComponentLifecycle", "computationBuffered", "computationLatest", "", "retry", "restSubscribeOn", "(Lrx/Observable;Z)Lrx/Observable;", "Ljava/lang/Class;", "errorClass", "Landroid/content/Context;", "context", "Lkotlin/Function1;", "Lrx/Subscription;", "", "subscriptionHandler", "Lcom/discord/utilities/error/Error;", "errorHandler", "Lkotlin/Function0;", "onCompleted", "onTerminated", "onNext", "appSubscribe", "(Lrx/Observable;Ljava/lang/Class;Landroid/content/Context;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;)V", "", "errorTag", "(Lrx/Observable;Landroid/content/Context;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V", "", "windowDuration", "Ljava/util/concurrent/TimeUnit;", "timeUnit", "leadingEdgeThrottle", "(Lrx/Observable;JLjava/util/concurrent/TimeUnit;)Lrx/Observable;", "filterIs", "filterNull", "milliseconds", "emitError", "kotlin.jvm.PlatformType", "takeSingleUntilTimeout", "(Lrx/Observable;JZ)Lrx/Observable;", "K", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "Lkotlin/Pair;", "", "toMap", "Lcom/discord/utilities/dimmer/DimmerView;", "dimmer", "delay", "withDimmer", "(Lrx/Observable;Lcom/discord/utilities/dimmer/DimmerView;J)Lrx/Observable;", "app_productionGoogleRelease"}, k = 2, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class ObservableExtensionsKt {

    /* compiled from: ObservableExtensions.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.utilities.rx.ObservableExtensionsKt$appSubscribe$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

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
        }
    }

    /* compiled from: ObservableExtensions.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.utilities.rx.ObservableExtensionsKt$appSubscribe$2, reason: invalid class name */
    public static final class AnonymousClass2 extends Lambda implements Function0<Unit> {
        public static final AnonymousClass2 INSTANCE = new AnonymousClass2();

        public AnonymousClass2() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
        }
    }

    /* compiled from: ObservableExtensions.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.utilities.rx.ObservableExtensionsKt$appSubscribe$3, reason: invalid class name */
    public static final class AnonymousClass3 extends Lambda implements Function0<Unit> {
        public static final AnonymousClass3 INSTANCE = new AnonymousClass3();

        public AnonymousClass3() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
        }
    }

    /* compiled from: ObservableExtensions.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.utilities.rx.ObservableExtensionsKt$appSubscribe$4, reason: invalid class name */
    public static final class AnonymousClass4 extends Lambda implements Function0<Unit> {
        public static final AnonymousClass4 INSTANCE = new AnonymousClass4();

        public AnonymousClass4() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
        }
    }

    /* compiled from: ObservableExtensions.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "", NotificationCompat.CATEGORY_CALL, "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.utilities.rx.ObservableExtensionsKt$bindToComponentLifecycle$2, reason: invalid class name */
    public static final class AnonymousClass2 implements Action0 {
        public final /* synthetic */ MGRecyclerAdapterSimple $adapter;

        public AnonymousClass2(MGRecyclerAdapterSimple mGRecyclerAdapterSimple) {
            this.$adapter = mGRecyclerAdapterSimple;
        }

        @Override // rx.functions.Action0
        public final void call() {
            MGRecyclerAdapterSimple mGRecyclerAdapterSimple = this.$adapter;
            if (mGRecyclerAdapterSimple != null) {
                mGRecyclerAdapterSimple.unsubscribeFromUpdates();
            }
        }
    }

    /* compiled from: ObservableExtensions.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\u0007\u001a\n \u0002*\u0004\u0018\u00010\u00040\u0004\"\u0006\b\u0000\u0010\u0000\u0018\u00012\u000e\u0010\u0003\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "", "kotlin.jvm.PlatformType", "it", "", NotificationCompat.CATEGORY_CALL, "(Ljava/lang/Object;)Ljava/lang/Boolean;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.utilities.rx.ObservableExtensionsKt$filterIs$1, reason: invalid class name */
    public static final class AnonymousClass1<T, R> implements Func1<Object, Boolean> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // j0.k.Func1
        public final Boolean call(Object obj) {
            Intrinsics3.reifiedOperationMarker(3, ExifInterface.GPS_DIRECTION_TRUE);
            return Boolean.valueOf(obj instanceof Object);
        }

        @Override // j0.k.Func1
        public /* bridge */ /* synthetic */ Boolean call(Object obj) {
            return call(obj);
        }
    }

    /* compiled from: ObservableExtensions.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0005\u0010\u0006\u001a\n \u0002*\u0004\u0018\u00018\u00008\u0000\"\u0006\b\u0000\u0010\u0000\u0018\u00012\u000e\u0010\u0003\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "", "kotlin.jvm.PlatformType", "it", NotificationCompat.CATEGORY_CALL, "(Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.utilities.rx.ObservableExtensionsKt$filterIs$2, reason: invalid class name */
    public static final class AnonymousClass2<T, R> implements Func1<Object, T> {
        public static final AnonymousClass2 INSTANCE = new AnonymousClass2();

        /* JADX WARN: Multi-variable type inference failed */
        @Override // j0.k.Func1
        public final T call(Object obj) {
            Intrinsics3.reifiedOperationMarker(1, ExifInterface.GPS_DIRECTION_TRUE);
            return obj;
        }
    }

    /* compiled from: ObservableExtensions.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\u0010\u0006\u001a\n \u0003*\u0004\u0018\u00010\u00020\u0002\"\u0006\b\u0000\u0010\u0000\u0018\u00012\b\u0010\u0001\u001a\u0004\u0018\u00018\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "it", "", "kotlin.jvm.PlatformType", NotificationCompat.CATEGORY_CALL, "(Ljava/lang/Object;)Ljava/lang/Boolean;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.utilities.rx.ObservableExtensionsKt$filterNull$1, reason: invalid class name */
    public static final class AnonymousClass1<T, R> implements Func1<T, Boolean> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // j0.k.Func1
        public final Boolean call(T t) {
            return Boolean.valueOf(t != null);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // j0.k.Func1
        public /* bridge */ /* synthetic */ Boolean call(Object obj) {
            return call((AnonymousClass1<T, R>) obj);
        }
    }

    /* compiled from: ObservableExtensions.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0004\n\u0002\b\u0006\u0010\u0005\u001a\n \u0002*\u0004\u0018\u00018\u00008\u0000\"\u0006\b\u0000\u0010\u0000\u0018\u00012\b\u0010\u0001\u001a\u0004\u0018\u00018\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "it", "kotlin.jvm.PlatformType", NotificationCompat.CATEGORY_CALL, "(Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.utilities.rx.ObservableExtensionsKt$filterNull$2, reason: invalid class name */
    public static final class AnonymousClass2<T, R> implements Func1<T, T> {
        public static final AnonymousClass2 INSTANCE = new AnonymousClass2();

        @Override // j0.k.Func1
        public final T call(T t) {
            Intrinsics3.checkNotNull(t);
            return t;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [V, K] */
    /* compiled from: ObservableExtensions.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0010\u0007\u001a\n \u0003*\u0004\u0018\u00018\u00008\u0000\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u00012&\u0010\u0004\u001a\"\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001 \u0003*\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u00020\u0002H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"K", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "Lkotlin/Pair;", "kotlin.jvm.PlatformType", "it", NotificationCompat.CATEGORY_CALL, "(Lkotlin/Pair;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.utilities.rx.ObservableExtensionsKt$toMap$1, reason: invalid class name */
    public static final class AnonymousClass1<T, R, K, V> implements Func1<Tuples2<? extends K, ? extends V>, K> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        @Override // j0.k.Func1
        public /* bridge */ /* synthetic */ Object call(Object obj) {
            return call((Tuples2) obj);
        }

        public final K call(Tuples2<? extends K, ? extends V> tuples2) {
            return tuples2.getFirst();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [V, K] */
    /* compiled from: ObservableExtensions.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0010\u0007\u001a\n \u0003*\u0004\u0018\u00018\u00018\u0001\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u00012&\u0010\u0004\u001a\"\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001 \u0003*\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u00020\u0002H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"K", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "Lkotlin/Pair;", "kotlin.jvm.PlatformType", "it", NotificationCompat.CATEGORY_CALL, "(Lkotlin/Pair;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.utilities.rx.ObservableExtensionsKt$toMap$2, reason: invalid class name */
    public static final class AnonymousClass2<T, R, K, V> implements Func1<Tuples2<? extends K, ? extends V>, V> {
        public static final AnonymousClass2 INSTANCE = new AnonymousClass2();

        @Override // j0.k.Func1
        public /* bridge */ /* synthetic */ Object call(Object obj) {
            return call((Tuples2) obj);
        }

        public final V call(Tuples2<? extends K, ? extends V> tuples2) {
            return tuples2.getSecond();
        }
    }

    /* compiled from: ObservableExtensions.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "", "it", "", "invoke", "(Z)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.utilities.rx.ObservableExtensionsKt$withDimmer$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<Boolean, Unit> {
        public final /* synthetic */ DimmerView $dimmer;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(DimmerView dimmerView) {
            super(1);
            this.$dimmer = dimmerView;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
            invoke(bool.booleanValue());
            return Unit.a;
        }

        public final void invoke(boolean z2) {
            DimmerView dimmerView = this.$dimmer;
            if (dimmerView != null) {
                DimmerView.setDimmed$default(dimmerView, z2, false, 2, null);
            }
        }
    }

    public static final <T> void appSubscribe(Observable<T> observable, Class<?> cls, Context context, Function1<? super Subscription, Unit> function1, Function1<? super Error, Unit> function12, Function0<Unit> function0, Function0<Unit> function02, Function1<? super T, Unit> function13) {
        Intrinsics3.checkNotNullParameter(observable, "$this$appSubscribe");
        Intrinsics3.checkNotNullParameter(cls, "errorClass");
        Intrinsics3.checkNotNullParameter(function0, "onCompleted");
        Intrinsics3.checkNotNullParameter(function02, "onTerminated");
        Intrinsics3.checkNotNullParameter(function13, "onNext");
        String simpleName = cls.getSimpleName();
        Intrinsics3.checkNotNullExpressionValue(simpleName, "errorClass.simpleName");
        appSubscribe(observable, context, simpleName, function1, function13, function12, function0, function02);
    }

    public static /* synthetic */ void appSubscribe$default(Observable observable, Class cls, Context context, Function1 function1, Function1 function12, Function0 function0, Function0 function02, Function1 function13, int i, Object obj) {
        appSubscribe(observable, (Class<?>) cls, (i & 2) != 0 ? null : context, (Function1<? super Subscription, Unit>) ((i & 4) != 0 ? null : function1), (Function1<? super Error, Unit>) ((i & 8) != 0 ? null : function12), (Function0<Unit>) ((i & 16) != 0 ? AnonymousClass1.INSTANCE : function0), (Function0<Unit>) ((i & 32) != 0 ? AnonymousClass2.INSTANCE : function02), function13);
    }

    public static final <T> Observable<T> bindToComponentLifecycle(Observable<T> observable, AppComponent appComponent, MGRecyclerAdapterSimple<?> mGRecyclerAdapterSimple) {
        Intrinsics3.checkNotNullParameter(observable, "$this$bindToComponentLifecycle");
        Intrinsics3.checkNotNullParameter(appComponent, "appComponent");
        Observable<T> observableA0 = observable.a0(appComponent.getUnsubscribeSignal());
        if (appComponent instanceof Fragment) {
            observableA0 = observableA0.y(new ObservableExtensionsKt$bindToComponentLifecycle$$inlined$let$lambda$1(appComponent));
        }
        Observable<T> observableW = observableA0.w(new AnonymousClass2(mGRecyclerAdapterSimple));
        Intrinsics3.checkNotNullExpressionValue(observableW, "takeUntil(appComponent.u…beFromUpdates()\n        }");
        return observableW;
    }

    public static /* synthetic */ Observable bindToComponentLifecycle$default(Observable observable, AppComponent appComponent, MGRecyclerAdapterSimple mGRecyclerAdapterSimple, int i, Object obj) {
        if ((i & 2) != 0) {
            mGRecyclerAdapterSimple = null;
        }
        return bindToComponentLifecycle(observable, appComponent, mGRecyclerAdapterSimple);
    }

    public static final <T> Observable<T> computationBuffered(Observable<T> observable) {
        Intrinsics3.checkNotNullParameter(observable, "$this$computationBuffered");
        Observable<T> observableJ = observable.K().X(Schedulers2.a()).J(Schedulers2.a());
        Intrinsics3.checkNotNullExpressionValue(observableJ, "onBackpressureBuffer()\n …Schedulers.computation())");
        return observableJ;
    }

    public static final <T> Observable<T> computationLatest(Observable<T> observable) {
        Intrinsics3.checkNotNullParameter(observable, "$this$computationLatest");
        Observable<T> observableJ = observable.L().X(Schedulers2.a()).J(Schedulers2.a());
        Intrinsics3.checkNotNullExpressionValue(observableJ, "onBackpressureLatest()\n …Schedulers.computation())");
        return observableJ;
    }

    public static final /* synthetic */ <T> Observable<T> filterIs(Observable<?> observable) {
        Intrinsics3.checkNotNullParameter(observable, "$this$filterIs");
        Intrinsics3.needClassReification();
        Observable<?> observableY = observable.y(AnonymousClass1.INSTANCE);
        Intrinsics3.needClassReification();
        Observable<T> observable2 = (Observable<T>) observableY.G(AnonymousClass2.INSTANCE);
        Intrinsics3.checkNotNullExpressionValue(observable2, "filter { it is T }.map { it as T }");
        return observable2;
    }

    public static final /* synthetic */ <T> Observable<T> filterNull(Observable<T> observable) {
        Intrinsics3.checkNotNullParameter(observable, "$this$filterNull");
        Observable<T> observable2 = (Observable<T>) observable.y(AnonymousClass1.INSTANCE).G(AnonymousClass2.INSTANCE);
        Intrinsics3.checkNotNullExpressionValue(observable2, "filter { it != null }.map { it!! }");
        return observable2;
    }

    public static final <T> Observable<T> leadingEdgeThrottle(Observable<T> observable, long j, TimeUnit timeUnit) {
        Intrinsics3.checkNotNullParameter(observable, "$this$leadingEdgeThrottle");
        Intrinsics3.checkNotNullParameter(timeUnit, "timeUnit");
        Observable<T> observableH0 = Observable.h0(new OnSubscribeLift(observable.j, new LeadingEdgeThrottle(j, timeUnit)));
        Intrinsics3.checkNotNullExpressionValue(observableH0, "lift(LeadingEdgeThrottle…indowDuration, timeUnit))");
        return observableH0;
    }

    public static final <T> Observable<T> restSubscribeOn(Observable<T> observable, boolean z2) {
        Intrinsics3.checkNotNullParameter(observable, "$this$restSubscribeOn");
        Observable<T> observableX = observable.X(Schedulers2.c());
        if (z2) {
            RetryWithDelay retryWithDelay = RetryWithDelay.INSTANCE;
            Intrinsics3.checkNotNullExpressionValue(observableX, "observable");
            observableX = RetryWithDelay.restRetry$default(retryWithDelay, observableX, 0L, null, null, 7, null);
        }
        Intrinsics3.checkNotNullExpressionValue(observableX, "subscribeOn(Schedulers.i… observable\n      }\n    }");
        return observableX;
    }

    public static /* synthetic */ Observable restSubscribeOn$default(Observable observable, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            z2 = true;
        }
        return restSubscribeOn(observable, z2);
    }

    public static final <T> Observable<T> takeSingleUntilTimeout(Observable<T> observable, long j, boolean z2) {
        Intrinsics3.checkNotNullParameter(observable, "$this$takeSingleUntilTimeout");
        Observable<T> observableZ = observable.Z(1);
        Observable<T> observableC0 = z2 ? observableZ.c0(j, TimeUnit.MILLISECONDS) : observableZ.a0(Observable.d0(j, TimeUnit.MILLISECONDS));
        Intrinsics3.checkNotNullExpressionValue(observableC0, "take(1).let {\n      if (…LISECONDS))\n      }\n    }");
        return computationLatest(observableC0);
    }

    public static /* synthetic */ Observable takeSingleUntilTimeout$default(Observable observable, long j, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            j = 5000;
        }
        if ((i & 2) != 0) {
            z2 = true;
        }
        return takeSingleUntilTimeout(observable, j, z2);
    }

    public static final <K, V> Observable<Map<K, V>> toMap(Observable<Tuples2<K, V>> observable) {
        Intrinsics3.checkNotNullParameter(observable, "$this$toMap");
        Observable<Map<K, V>> observableG0 = observable.g0(AnonymousClass1.INSTANCE, AnonymousClass2.INSTANCE);
        Intrinsics3.checkNotNullExpressionValue(observableG0, "toMap({ it.first }, { it.second })");
        return observableG0;
    }

    public static final <T> Observable<T> ui(Observable<T> observable) {
        Intrinsics3.checkNotNullParameter(observable, "$this$ui");
        Observable<T> observableJ = observable.J(AndroidSchedulers.a());
        Intrinsics3.checkNotNullExpressionValue(observableJ, "observeOn(AndroidSchedulers.mainThread())");
        return observableJ;
    }

    public static /* synthetic */ Observable ui$default(Observable observable, AppComponent appComponent, MGRecyclerAdapterSimple mGRecyclerAdapterSimple, int i, Object obj) {
        if ((i & 2) != 0) {
            mGRecyclerAdapterSimple = null;
        }
        return ui(observable, appComponent, mGRecyclerAdapterSimple);
    }

    public static final <T> Observable<T> withDimmer(Observable<T> observable, DimmerView dimmerView, long j) {
        Intrinsics3.checkNotNullParameter(observable, "$this$withDimmer");
        Observable<T> observableH0 = Observable.h0(new OnSubscribeLift(observable.j, new OnDelayedEmissionHandler(new AnonymousClass1(dimmerView), j, TimeUnit.MILLISECONDS, null, 8, null)));
        Intrinsics3.checkNotNullExpressionValue(observableH0, "lift(\n        OnDelayedE…LISECONDS\n        )\n    )");
        return observableH0;
    }

    public static /* synthetic */ Observable withDimmer$default(Observable observable, DimmerView dimmerView, long j, int i, Object obj) {
        if ((i & 2) != 0) {
            j = 300;
        }
        return withDimmer(observable, dimmerView, j);
    }

    public static final <T> Observable<T> ui(Observable<T> observable, AppComponent appComponent, MGRecyclerAdapterSimple<?> mGRecyclerAdapterSimple) {
        Intrinsics3.checkNotNullParameter(observable, "$this$ui");
        Intrinsics3.checkNotNullParameter(appComponent, "appComponent");
        return bindToComponentLifecycle(ui(observable), appComponent, mGRecyclerAdapterSimple);
    }

    public static final <T> void appSubscribe(Observable<T> observable, Context context, String str, Function1<? super Subscription, Unit> function1, Function1<? super T, Unit> function12, Function1<? super Error, Unit> function13, Function0<Unit> function0, Function0<Unit> function02) {
        Intrinsics3.checkNotNullParameter(observable, "$this$appSubscribe");
        Intrinsics3.checkNotNullParameter(str, "errorTag");
        Intrinsics3.checkNotNullParameter(function12, "onNext");
        Intrinsics3.checkNotNullParameter(function0, "onCompleted");
        Intrinsics3.checkNotNullParameter(function02, "onTerminated");
        WeakReference weakReference = new WeakReference(context);
        ObservableExtensionsKt$sam$rx_functions_Action1$0 observableExtensionsKt$sam$rx_functions_Action1$0 = new ObservableExtensionsKt$sam$rx_functions_Action1$0(function12);
        ObservableExtensionsKt$appSubscribe$subscription$1 observableExtensionsKt$appSubscribe$subscription$1 = new ObservableExtensionsKt$appSubscribe$subscription$1(str, function13, weakReference, function02);
        ObservableExtensionsKt$appSubscribe$subscription$2 observableExtensionsKt$appSubscribe$subscription$2 = new ObservableExtensionsKt$appSubscribe$subscription$2(function0, function02);
        Objects.requireNonNull(observable);
        Subscription subscriptionU = observable.U(new ActionSubscriber(observableExtensionsKt$sam$rx_functions_Action1$0, observableExtensionsKt$appSubscribe$subscription$1, observableExtensionsKt$appSubscribe$subscription$2));
        if (function1 != null) {
            Intrinsics3.checkNotNullExpressionValue(subscriptionU, Traits.Payment.Type.SUBSCRIPTION);
            function1.invoke(subscriptionU);
        }
    }

    public static /* synthetic */ void appSubscribe$default(Observable observable, Context context, String str, Function1 function1, Function1 function12, Function1 function13, Function0 function0, Function0 function02, int i, Object obj) {
        appSubscribe(observable, (i & 1) != 0 ? null : context, str, (Function1<? super Subscription, Unit>) ((i & 4) != 0 ? null : function1), function12, (Function1<? super Error, Unit>) ((i & 16) != 0 ? null : function13), (Function0<Unit>) ((i & 32) != 0 ? AnonymousClass3.INSTANCE : function0), (Function0<Unit>) ((i & 64) != 0 ? AnonymousClass4.INSTANCE : function02));
    }
}
