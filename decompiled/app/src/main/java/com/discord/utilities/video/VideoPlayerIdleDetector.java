package com.discord.utilities.video;

import android.content.Context;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import j0.j.b.AndroidSchedulers;
import j0.p.Schedulers2;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;
import rx.Scheduler;
import rx.Subscription;

/* compiled from: VideoPlayerIdleDetector.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\f\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B9\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0011\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0014\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u0014\u0012\u0012\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040\u0017¢\u0006\u0004\b\u001f\u0010 J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\t\u0010\bJ\r\u0010\n\u001a\u00020\u0004¢\u0006\u0004\b\n\u0010\bJ\r\u0010\u000b\u001a\u00020\u0004¢\u0006\u0004\b\u000b\u0010\bJ\r\u0010\f\u001a\u00020\u0004¢\u0006\u0004\b\f\u0010\bJ\u0017\u0010\u000e\u001a\u00020\u00042\b\b\u0002\u0010\r\u001a\u00020\u0002¢\u0006\u0004\b\u000e\u0010\u0006J\r\u0010\u000f\u001a\u00020\u0004¢\u0006\u0004\b\u000f\u0010\bJ\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0010R\u0016\u0010\u0012\u001a\u00020\u00118\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0015\u001a\u00020\u00148\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\"\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040\u00178\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u001a8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010\u001d\u001a\u00020\u00148\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u0016R\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u001e¨\u0006!"}, d2 = {"Lcom/discord/utilities/video/VideoPlayerIdleDetector;", "", "", "isIdle", "", "setIdle", "(Z)V", "beginIdleDetectionTimer", "()V", "cancelIdleDetectionTimer", "beginIdleDetection", "endIdleDetection", "dispose", "otherIsIdle", "onInteraction", "onPreventIdle", "()Z", "", "idleDetectionMs", "J", "Lrx/Scheduler;", "idleDetectionScheduler", "Lrx/Scheduler;", "Lkotlin/Function1;", "onIdleStateChanged", "Lkotlin/jvm/functions/Function1;", "Lrx/Subscription;", "idleDetectionSubscription", "Lrx/Subscription;", "backgroundThreadScheduler", "Z", "<init>", "(JLrx/Scheduler;Lrx/Scheduler;Lkotlin/jvm/functions/Function1;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class VideoPlayerIdleDetector {
    private final Scheduler backgroundThreadScheduler;
    private final long idleDetectionMs;
    private final Scheduler idleDetectionScheduler;
    private Subscription idleDetectionSubscription;
    private boolean isIdle;
    private final Function1<Boolean, Unit> onIdleStateChanged;

    /* compiled from: VideoPlayerIdleDetector.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "kotlin.jvm.PlatformType", "it", "", "invoke", "(Ljava/lang/Long;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.utilities.video.VideoPlayerIdleDetector$beginIdleDetectionTimer$1, reason: invalid class name */
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
            VideoPlayerIdleDetector.access$setIdle(VideoPlayerIdleDetector.this, true);
        }
    }

    /* compiled from: VideoPlayerIdleDetector.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lrx/Subscription;", "it", "", "invoke", "(Lrx/Subscription;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.utilities.video.VideoPlayerIdleDetector$beginIdleDetectionTimer$2, reason: invalid class name */
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
            VideoPlayerIdleDetector.access$setIdleDetectionSubscription$p(VideoPlayerIdleDetector.this, subscription);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public VideoPlayerIdleDetector(long j, Scheduler scheduler, Scheduler scheduler2, Function1<? super Boolean, Unit> function1) {
        Intrinsics3.checkNotNullParameter(scheduler, "idleDetectionScheduler");
        Intrinsics3.checkNotNullParameter(scheduler2, "backgroundThreadScheduler");
        Intrinsics3.checkNotNullParameter(function1, "onIdleStateChanged");
        this.idleDetectionMs = j;
        this.idleDetectionScheduler = scheduler;
        this.backgroundThreadScheduler = scheduler2;
        this.onIdleStateChanged = function1;
    }

    public static final /* synthetic */ Subscription access$getIdleDetectionSubscription$p(VideoPlayerIdleDetector videoPlayerIdleDetector) {
        return videoPlayerIdleDetector.idleDetectionSubscription;
    }

    public static final /* synthetic */ void access$setIdle(VideoPlayerIdleDetector videoPlayerIdleDetector, boolean z2) {
        videoPlayerIdleDetector.setIdle(z2);
    }

    public static final /* synthetic */ void access$setIdleDetectionSubscription$p(VideoPlayerIdleDetector videoPlayerIdleDetector, Subscription subscription) {
        videoPlayerIdleDetector.idleDetectionSubscription = subscription;
    }

    private final void beginIdleDetectionTimer() {
        cancelIdleDetectionTimer();
        Observable<Long> observableJ = Observable.e0(this.idleDetectionMs, TimeUnit.MILLISECONDS, this.backgroundThreadScheduler).J(this.idleDetectionScheduler);
        Intrinsics3.checkNotNullExpressionValue(observableJ, "Observable\n        .time…n(idleDetectionScheduler)");
        ObservableExtensionsKt.appSubscribe$default(observableJ, VideoPlayerIdleDetector.class, (Context) null, new AnonymousClass2(), (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(), 58, (Object) null);
    }

    private final void cancelIdleDetectionTimer() {
        Subscription subscription = this.idleDetectionSubscription;
        if (subscription != null) {
            subscription.unsubscribe();
        }
        this.idleDetectionSubscription = null;
    }

    public static /* synthetic */ void onInteraction$default(VideoPlayerIdleDetector videoPlayerIdleDetector, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            z2 = true;
        }
        videoPlayerIdleDetector.onInteraction(z2);
    }

    private final void setIdle(boolean isIdle) {
        if (isIdle != this.isIdle) {
            this.isIdle = isIdle;
            this.onIdleStateChanged.invoke(Boolean.valueOf(isIdle));
        }
    }

    public final void beginIdleDetection() {
        if (this.idleDetectionSubscription == null) {
            setIdle(false);
            beginIdleDetectionTimer();
        }
    }

    public final void dispose() {
        cancelIdleDetectionTimer();
        setIdle(false);
    }

    public final void endIdleDetection() {
        cancelIdleDetectionTimer();
        setIdle(false);
    }

    /* renamed from: isIdle, reason: from getter */
    public final boolean getIsIdle() {
        return this.isIdle;
    }

    public final void onInteraction(boolean otherIsIdle) {
        if ((this.isIdle || otherIsIdle) ? false : true) {
            cancelIdleDetectionTimer();
            setIdle(true);
        } else {
            setIdle(false);
            beginIdleDetectionTimer();
        }
    }

    public final void onPreventIdle() {
        setIdle(false);
        if (this.idleDetectionSubscription != null) {
            beginIdleDetectionTimer();
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ VideoPlayerIdleDetector(long j, Scheduler scheduler, Scheduler scheduler2, Function1 function1, int i, DefaultConstructorMarker defaultConstructorMarker) {
        long j2 = (i & 1) != 0 ? 3000L : j;
        if ((i & 2) != 0) {
            scheduler = AndroidSchedulers.a();
            Intrinsics3.checkNotNullExpressionValue(scheduler, "AndroidSchedulers.mainThread()");
        }
        Scheduler scheduler3 = scheduler;
        if ((i & 4) != 0) {
            scheduler2 = Schedulers2.a();
            Intrinsics3.checkNotNullExpressionValue(scheduler2, "Schedulers.computation()");
        }
        this(j2, scheduler3, scheduler2, function1);
    }
}
