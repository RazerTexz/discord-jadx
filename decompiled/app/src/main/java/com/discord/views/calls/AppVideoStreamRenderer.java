package com.discord.views.calls;

import android.content.Context;
import android.graphics.Point;
import android.util.AttributeSet;
import android.util.Log;
import androidx.annotation.MainThread;
import b.a.y.j0.AppVideoStreamRenderer2;
import b.a.y.j0.AppVideoStreamRenderer3;
import b.a.y.j0.AppVideoStreamRenderer4;
import b.a.y.j0.AppVideoStreamRenderer5;
import b.a.y.j0.RxRendererEvents;
import b.d.b.a.outline;
import co.discord.media_engine.VideoStreamRenderer;
import com.discord.stores.StoreStream;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.z.d.Intrinsics3;
import d0.z.d.TypeIntrinsics;
import java.util.HashMap;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import org.webrtc.RendererCommon;
import rx.Observable;
import rx.Subscription;
import rx.subjects.BehaviorSubject;

/* compiled from: AppVideoStreamRenderer.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0019\b\u0016\u0012\u0006\u00109\u001a\u000208\u0012\u0006\u0010;\u001a\u00020:¢\u0006\u0004\b<\u0010=J/\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\b\u0010\tJ;\u0010\u0011\u001a\u00020\u00072\u000e\u0010\u000b\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\n2\b\u0010\r\u001a\u0004\u0018\u00010\f2\b\u0010\u000e\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0007¢\u0006\u0004\b\u0011\u0010\u0012J\u0015\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u000f¢\u0006\u0004\b\u0014\u0010\u0015J\u0015\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u000f¢\u0006\u0004\b\u0017\u0010\u0015J\u000f\u0010\u0018\u001a\u00020\u0007H\u0003¢\u0006\u0004\b\u0018\u0010\u0019R:\u0010\u001e\u001a&\u0012\f\u0012\n \u001b*\u0004\u0018\u00010\u00070\u0007 \u001b*\u0012\u0012\f\u0012\n \u001b*\u0004\u0018\u00010\u00070\u0007\u0018\u00010\u001a0\u001a8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0018\u0010\"\u001a\u0004\u0018\u00010\u001f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b \u0010!R0\u0010+\u001a\u0010\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020\u0007\u0018\u00010#8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u0016\u0010.\u001a\u00020\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b,\u0010-R:\u00100\u001a&\u0012\f\u0012\n \u001b*\u0004\u0018\u00010$0$ \u001b*\u0012\u0012\f\u0012\n \u001b*\u0004\u0018\u00010$0$\u0018\u00010\u001a0\u001a8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b/\u0010\u001dR\u0016\u0010\u0016\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b1\u00102R\u001e\u00105\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b3\u00104R\u0016\u00107\u001a\u00020\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b6\u0010-¨\u0006>"}, d2 = {"Lcom/discord/views/calls/AppVideoStreamRenderer;", "Lco/discord/media_engine/VideoStreamRenderer;", "", "w", "h", "oldw", "oldh", "", "onSizeChanged", "(IIII)V", "Lcom/discord/primitives/StreamId;", "newStreamId", "Lorg/webrtc/RendererCommon$ScalingType;", "scalingType", "scalingTypeMismatchOrientation", "", "isVideoMirrored", "c", "(Ljava/lang/Integer;Lorg/webrtc/RendererCommon$ScalingType;Lorg/webrtc/RendererCommon$ScalingType;Z)V", "matchVideoOrientation", "setMatchVideoOrientation", "(Z)V", "isOverlay", "setIsOverlay", "b", "()V", "Lrx/subjects/BehaviorSubject;", "kotlin.jvm.PlatformType", "k", "Lrx/subjects/BehaviorSubject;", "onSizeChangedSubject", "Lrx/Subscription;", "l", "Lrx/Subscription;", "updateRendererSizeSubscription", "Lkotlin/Function1;", "Landroid/graphics/Point;", "o", "Lkotlin/jvm/functions/Function1;", "getOnFrameRenderedListener", "()Lkotlin/jvm/functions/Function1;", "setOnFrameRenderedListener", "(Lkotlin/jvm/functions/Function1;)V", "onFrameRenderedListener", "q", "Lorg/webrtc/RendererCommon$ScalingType;", "prevScalingTypeMismatchOrientation", "n", "currentFrameResolutionSubject", "j", "Z", "m", "Ljava/lang/Integer;", "streamId", "p", "prevScalingType", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class AppVideoStreamRenderer extends VideoStreamRenderer {

    /* renamed from: j, reason: from kotlin metadata */
    public boolean isOverlay;

    /* renamed from: k, reason: from kotlin metadata */
    public final BehaviorSubject<Unit> onSizeChangedSubject;

    /* renamed from: l, reason: from kotlin metadata */
    public Subscription updateRendererSizeSubscription;

    /* renamed from: m, reason: from kotlin metadata */
    public Integer streamId;

    /* renamed from: n, reason: from kotlin metadata */
    public BehaviorSubject<Point> currentFrameResolutionSubject;

    /* renamed from: o, reason: from kotlin metadata */
    public Function1<? super Point, Unit> onFrameRenderedListener;

    /* renamed from: p, reason: from kotlin metadata */
    public RendererCommon.ScalingType prevScalingType;

    /* renamed from: q, reason: from kotlin metadata */
    public RendererCommon.ScalingType prevScalingTypeMismatchOrientation;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AppVideoStreamRenderer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics3.checkNotNullParameter(context, "context");
        Intrinsics3.checkNotNullParameter(attributeSet, "attrs");
        this.onSizeChangedSubject = BehaviorSubject.l0(Unit.a);
        this.currentFrameResolutionSubject = BehaviorSubject.l0(null);
        RendererCommon.ScalingType scalingType = RendererCommon.ScalingType.SCALE_ASPECT_BALANCED;
        this.prevScalingType = scalingType;
        this.prevScalingTypeMismatchOrientation = scalingType;
    }

    @MainThread
    public final void b() {
        Subscription subscription = this.updateRendererSizeSubscription;
        if (subscription != null) {
            subscription.unsubscribe();
        }
        HashMap<Integer, VideoStreamRenderer> map = AppVideoStreamRenderer5.a;
        Integer num = this.streamId;
        Objects.requireNonNull(map, "null cannot be cast to non-null type kotlin.collections.MutableMap<K, V>");
        TypeIntrinsics.asMutableMap(map).remove(num);
        this.currentFrameResolutionSubject.onNext(null);
        map.isEmpty();
        VideoStreamRenderer.attachToStream$default(this, StoreStream.INSTANCE.getMediaEngine().getVoiceEngineNative(), null, null, 4, null);
    }

    @MainThread
    public final void c(Integer newStreamId, RendererCommon.ScalingType scalingType, RendererCommon.ScalingType scalingTypeMismatchOrientation, boolean isVideoMirrored) {
        if (newStreamId == null) {
            b();
            this.streamId = null;
            return;
        }
        boolean z2 = !Intrinsics3.areEqual(newStreamId, this.streamId);
        if (z2) {
            b();
        }
        if (z2) {
            int iIntValue = newStreamId.intValue();
            HashMap<Integer, VideoStreamRenderer> map = AppVideoStreamRenderer5.a;
            VideoStreamRenderer videoStreamRenderer = map.get(Integer.valueOf(iIntValue));
            if (videoStreamRenderer != null && videoStreamRenderer != this) {
                VideoStreamRenderer.attachToStream$default(videoStreamRenderer, StoreStream.INSTANCE.getMediaEngine().getVoiceEngineNative(), null, null, 4, null);
                map.remove(Integer.valueOf(iIntValue));
                map.isEmpty();
            }
            map.put(Integer.valueOf(iIntValue), this);
            RxRendererEvents rxRendererEvents = new RxRendererEvents();
            Subscription subscription = this.updateRendererSizeSubscription;
            if (subscription != null) {
                subscription.unsubscribe();
            }
            Observable<R> observableA = this.onSizeChangedSubject.A(new AppVideoStreamRenderer2(rxRendererEvents));
            Intrinsics3.checkNotNullExpressionValue(observableA, "onSizeChangedSubject\n   …rameResolutionSampled() }");
            Observable observableG = observableA.y(ObservableExtensionsKt.AnonymousClass1.INSTANCE).G(ObservableExtensionsKt.AnonymousClass2.INSTANCE);
            Intrinsics3.checkNotNullExpressionValue(observableG, "filter { it != null }.map { it!! }");
            Observable observableUi = ObservableExtensionsKt.ui(observableG);
            AppVideoStreamRenderer3 appVideoStreamRenderer3 = new AppVideoStreamRenderer3(this);
            String simpleName = AppVideoStreamRenderer.class.getSimpleName();
            Intrinsics3.checkNotNullExpressionValue(simpleName, "javaClass.simpleName");
            ObservableExtensionsKt.appSubscribe$default(observableUi, (Context) null, simpleName, new AppVideoStreamRenderer4(this), appVideoStreamRenderer3, (Function1) null, (Function0) null, (Function0) null, 113, (Object) null);
            StringBuilder sbU = outline.U("binding native renderer ");
            sbU.append(hashCode());
            sbU.append(" to stream id: ");
            sbU.append(iIntValue);
            Log.d("AppVideoStreamRenderer", sbU.toString());
            attachToStream(StoreStream.INSTANCE.getMediaEngine().getVoiceEngineNative(), String.valueOf(iIntValue), rxRendererEvents);
            this.streamId = newStreamId;
        }
        RendererCommon.ScalingType scalingType2 = scalingType != null ? scalingType : this.prevScalingType;
        RendererCommon.ScalingType scalingType3 = scalingTypeMismatchOrientation != null ? scalingTypeMismatchOrientation : this.prevScalingTypeMismatchOrientation;
        setMirror(isVideoMirrored);
        setZOrderMediaOverlay(this.isOverlay);
        if (scalingType2 == this.prevScalingType && scalingType3 == this.prevScalingTypeMismatchOrientation) {
            return;
        }
        setScalingType(scalingType2, scalingType3);
        this.prevScalingType = scalingType2;
        this.prevScalingTypeMismatchOrientation = scalingType3;
    }

    public final Function1<Point, Unit> getOnFrameRenderedListener() {
        return this.onFrameRenderedListener;
    }

    @Override // android.view.View
    public void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        this.onSizeChangedSubject.onNext(Unit.a);
        super.clearImage();
    }

    public final void setIsOverlay(boolean isOverlay) {
        this.isOverlay = isOverlay;
    }

    public final void setMatchVideoOrientation(boolean matchVideoOrientation) {
    }

    public final void setOnFrameRenderedListener(Function1<? super Point, Unit> function1) {
        this.onFrameRenderedListener = function1;
    }
}
