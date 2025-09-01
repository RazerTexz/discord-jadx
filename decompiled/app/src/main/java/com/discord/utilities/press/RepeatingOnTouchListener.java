package com.discord.utilities.press;

import android.view.MotionEvent;
import android.view.View;
import androidx.core.app.NotificationCompat;
import com.discord.utilities.analytics.Traits;
import d0.z.d.Intrinsics3;
import j0.j.b.AndroidSchedulers;
import j0.k.Func1;
import j0.p.Schedulers2;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;
import rx.Subscription;
import rx.functions.Action0;
import rx.functions.Action1;

/* compiled from: RepeatingOnTouchListener.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001B3\b\u0007\u0012\u0006\u0010\u001e\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\f\u0012\u0006\u0010\u001a\u001a\u00020\u0019\u0012\u0006\u0010 \u001a\u00020\u0011\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b\"\u0010#J\u000f\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0003\u0010\u0004J#\u0010\n\u001a\u00020\t2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000bR\u0019\u0010\r\u001a\u00020\f8\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u0019\u0010\u0012\u001a\u00020\u00118\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0019\u0010\u001a\u001a\u00020\u00198\u0006@\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u0019\u0010\u001e\u001a\u00020\f8\u0006@\u0006¢\u0006\f\n\u0004\b\u001e\u0010\u000e\u001a\u0004\b\u001f\u0010\u0010R\u0019\u0010 \u001a\u00020\u00118\u0006@\u0006¢\u0006\f\n\u0004\b \u0010\u0013\u001a\u0004\b!\u0010\u0015¨\u0006$"}, d2 = {"Lcom/discord/utilities/press/RepeatingOnTouchListener;", "Landroid/view/View$OnTouchListener;", "", "subscribe", "()V", "Landroid/view/View;", "v", "Landroid/view/MotionEvent;", "event", "", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", "", "repeatRate", "J", "getRepeatRate", "()J", "Lrx/functions/Action0;", "initialAction", "Lrx/functions/Action0;", "getInitialAction", "()Lrx/functions/Action0;", "Lrx/Subscription;", Traits.Payment.Type.SUBSCRIPTION, "Lrx/Subscription;", "Ljava/util/concurrent/TimeUnit;", "timeUnit", "Ljava/util/concurrent/TimeUnit;", "getTimeUnit", "()Ljava/util/concurrent/TimeUnit;", "initialDelay", "getInitialDelay", "action", "getAction", "<init>", "(JJLjava/util/concurrent/TimeUnit;Lrx/functions/Action0;Lrx/functions/Action0;)V", "utils_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class RepeatingOnTouchListener implements View.OnTouchListener {
    private final Action0 action;
    private final Action0 initialAction;
    private final long initialDelay;
    private final long repeatRate;
    private Subscription subscription;
    private final TimeUnit timeUnit;

    /* compiled from: RepeatingOnTouchListener.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0006\u001a*\u0012\u000e\b\u0001\u0012\n \u0001*\u0004\u0018\u00010\u00000\u0000 \u0001*\u0014\u0012\u000e\b\u0001\u0012\n \u0001*\u0004\u0018\u00010\u00000\u0000\u0018\u00010\u00030\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "kotlin.jvm.PlatformType", "it", "Lrx/Observable;", NotificationCompat.CATEGORY_CALL, "(Ljava/lang/Long;)Lrx/Observable;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.utilities.press.RepeatingOnTouchListener$subscribe$1, reason: invalid class name */
    public static final class AnonymousClass1<T, R> implements Func1<Long, Observable<? extends Long>> {
        public AnonymousClass1() {
        }

        @Override // j0.k.Func1
        public /* bridge */ /* synthetic */ Observable<? extends Long> call(Long l) {
            return call2(l);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final Observable<? extends Long> call2(Long l) {
            long repeatRate = RepeatingOnTouchListener.this.getRepeatRate();
            return Observable.F(repeatRate, repeatRate, RepeatingOnTouchListener.this.getTimeUnit(), Schedulers2.a());
        }
    }

    /* compiled from: RepeatingOnTouchListener.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "kotlin.jvm.PlatformType", "it", "", NotificationCompat.CATEGORY_CALL, "(Ljava/lang/Long;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.utilities.press.RepeatingOnTouchListener$subscribe$2, reason: invalid class name */
    public static final class AnonymousClass2<T> implements Action1<Long> {
        public AnonymousClass2() {
        }

        @Override // rx.functions.Action1
        public /* bridge */ /* synthetic */ void call(Long l) {
            call2(l);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final void call2(Long l) {
            RepeatingOnTouchListener.this.getAction().call();
        }
    }

    /* compiled from: RepeatingOnTouchListener.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "kotlin.jvm.PlatformType", "it", "", NotificationCompat.CATEGORY_CALL, "(Ljava/lang/Throwable;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.utilities.press.RepeatingOnTouchListener$subscribe$3, reason: invalid class name */
    public static final class AnonymousClass3<T> implements Action1<Throwable> {
        public static final AnonymousClass3 INSTANCE = new AnonymousClass3();

        @Override // rx.functions.Action1
        public /* bridge */ /* synthetic */ void call(Throwable th) {
            call2(th);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final void call2(Throwable th) {
        }
    }

    public RepeatingOnTouchListener(long j, long j2, TimeUnit timeUnit, Action0 action0) {
        this(j, j2, timeUnit, action0, null, 16, null);
    }

    public RepeatingOnTouchListener(long j, long j2, TimeUnit timeUnit, Action0 action0, Action0 action02) {
        Intrinsics3.checkNotNullParameter(timeUnit, "timeUnit");
        Intrinsics3.checkNotNullParameter(action0, "action");
        Intrinsics3.checkNotNullParameter(action02, "initialAction");
        this.initialDelay = j;
        this.repeatRate = j2;
        this.timeUnit = timeUnit;
        this.action = action0;
        this.initialAction = action02;
    }

    private final void subscribe() {
        this.subscription = Observable.d0(this.initialDelay, this.timeUnit).A(new AnonymousClass1()).J(AndroidSchedulers.a()).W(new AnonymousClass2(), AnonymousClass3.INSTANCE);
    }

    public final Action0 getAction() {
        return this.action;
    }

    public final Action0 getInitialAction() {
        return this.initialAction;
    }

    public final long getInitialDelay() {
        return this.initialDelay;
    }

    public final long getRepeatRate() {
        return this.repeatRate;
    }

    public final TimeUnit getTimeUnit() {
        return this.timeUnit;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View v, MotionEvent event) {
        Integer numValueOf = event != null ? Integer.valueOf(event.getAction()) : null;
        if (numValueOf != null && numValueOf.intValue() == 0) {
            this.initialAction.call();
            subscribe();
            return true;
        }
        if (numValueOf != null && numValueOf.intValue() == 2) {
            return true;
        }
        Subscription subscription = this.subscription;
        if (subscription != null) {
            subscription.unsubscribe();
        }
        this.subscription = null;
        return true;
    }

    public /* synthetic */ RepeatingOnTouchListener(long j, long j2, TimeUnit timeUnit, Action0 action0, Action0 action02, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, j2, timeUnit, action0, (i & 16) != 0 ? action0 : action02);
    }
}
