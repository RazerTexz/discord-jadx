package com.discord.views.calls;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.animation.PathInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.discord.R;
import com.discord.utilities.accessibility.AccessibilityUtils;
import com.discord.utilities.animations.AnimationCoroutineUtils;
import com.discord.utilities.views.ViewCoroutineScope;
import d0.Lazy5;
import d0.LazyJVM;
import d0.Result3;
import d0.d0._Ranges;
import d0.w.h.Intrinsics2;
import d0.w.i.a.ContinuationImpl3;
import d0.w.i.a.ContinuationImpl6;
import d0.w.i.a.DebugMetadata;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.Iterator;
import java.util.Objects;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import org.objectweb.asm.Opcodes;
import s.a.CompletableJob;
import s.a.Deferred;

/* compiled from: SpeakerPulseView.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001d\b\u0007\u0012\u0006\u00101\u001a\u000200\u0012\n\b\u0002\u00103\u001a\u0004\u0018\u000102¢\u0006\u0004\b4\u00105J\u000f\u0010\u0003\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0006\u001a\u00020\u0002*\u00020\u0005H\u0082@ø\u0001\u0000¢\u0006\u0004\b\u0006\u0010\u0007J'\u0010\f\u001a\u00020\u0002*\u00020\b2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tH\u0082@ø\u0001\u0000¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u000e\u0010\u0004R\u001d\u0010\u0014\u001a\u00020\u000f8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R*\u0010\u001d\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00198\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u0016\u0010\"\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b!\u0010\u001cR\u0016\u0010&\u001a\u00020#8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b$\u0010%R\u0016\u0010(\u001a\u00020#8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b'\u0010%R\u001d\u0010+\u001a\u00020\u000f8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b)\u0010\u0011\u001a\u0004\b*\u0010\u0013R\u0016\u0010/\u001a\u00020,8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b-\u0010.\u0082\u0002\u0004\n\u0002\b\u0019¨\u00066"}, d2 = {"Lcom/discord/views/calls/SpeakerPulseView;", "Landroid/widget/FrameLayout;", "", "onAttachedToWindow", "()V", "Lkotlinx/coroutines/CoroutineScope;", "e", "(Lkotlinx/coroutines/CoroutineScope;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Landroid/view/View;", "", "rampStartDelay", "rampedDuration", "d", "(Landroid/view/View;JJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "f", "Landroid/widget/ImageView;", "o", "Lkotlin/Lazy;", "getInnerView", "()Landroid/widget/ImageView;", "innerView", "Lkotlinx/coroutines/Job;", "n", "Lkotlinx/coroutines/Job;", "animationJob", "", "value", "q", "Z", "isPulsing", "()Z", "setPulsing", "(Z)V", "l", "hasEverAnimated", "Landroid/view/animation/PathInterpolator;", "k", "Landroid/view/animation/PathInterpolator;", "fadeOutInterpolator", "j", "rampUpInterpolator", "p", "getOuterView", "outerView", "Ls/a/u;", "m", "Ls/a/u;", "animationSupervisor", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class SpeakerPulseView extends FrameLayout {

    /* renamed from: j, reason: from kotlin metadata */
    public final PathInterpolator rampUpInterpolator;

    /* renamed from: k, reason: from kotlin metadata */
    public final PathInterpolator fadeOutInterpolator;

    /* renamed from: l, reason: from kotlin metadata */
    public boolean hasEverAnimated;

    /* renamed from: m, reason: from kotlin metadata */
    public final CompletableJob animationSupervisor;

    /* renamed from: n, reason: from kotlin metadata */
    public Job animationJob;

    /* renamed from: o, reason: from kotlin metadata */
    public final Lazy innerView;

    /* renamed from: p, reason: from kotlin metadata */
    public final Lazy outerView;

    /* renamed from: q, reason: from kotlin metadata */
    public boolean isPulsing;

    /* compiled from: kotlin-style lambda group */
    public static final class a extends Lambda implements Function0<ImageView> {
        public final /* synthetic */ int j;
        public final /* synthetic */ Object k;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(int i, Object obj) {
            super(0);
            this.j = i;
            this.k = obj;
        }

        @Override // kotlin.jvm.functions.Function0
        public final ImageView invoke() {
            int i = this.j;
            if (i == 0) {
                return SpeakerPulseView.a((SpeakerPulseView) this.k, 0);
            }
            if (i == 1) {
                return SpeakerPulseView.a((SpeakerPulseView) this.k, 1);
            }
            throw null;
        }
    }

    /* compiled from: SpeakerPulseView.kt */
    @DebugMetadata(c = "com.discord.views.calls.SpeakerPulseView", f = "SpeakerPulseView.kt", l = {Opcodes.LOR, Opcodes.I2D}, m = "animatePulse")
    public static final class b extends ContinuationImpl3 {
        public long J$0;
        public Object L$0;
        public Object L$1;
        public int label;
        public /* synthetic */ Object result;

        public b(Continuation continuation) {
            super(continuation);
        }

        @Override // d0.w.i.a.ContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return SpeakerPulseView.this.d(null, 0L, 0L, this);
        }
    }

    /* compiled from: SpeakerPulseView.kt */
    @DebugMetadata(c = "com.discord.views.calls.SpeakerPulseView", f = "SpeakerPulseView.kt", l = {117}, m = "performPulseAnimation")
    public static final class c extends ContinuationImpl3 {
        public Object L$0;
        public Object L$1;
        public int label;
        public /* synthetic */ Object result;

        public c(Continuation continuation) {
            super(continuation);
        }

        @Override // d0.w.i.a.ContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return SpeakerPulseView.this.e(null, this);
        }
    }

    /* compiled from: SpeakerPulseView.kt */
    @DebugMetadata(c = "com.discord.views.calls.SpeakerPulseView$performPulseAnimation$inner$1", f = "SpeakerPulseView.kt", l = {106}, m = "invokeSuspend")
    public static final class d extends ContinuationImpl6 implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        public int label;

        public d(Continuation continuation) {
            super(2, continuation);
        }

        @Override // d0.w.i.a.ContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Intrinsics3.checkNotNullParameter(continuation, "completion");
            return SpeakerPulseView.this.new d(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            Continuation<? super Unit> continuation2 = continuation;
            Intrinsics3.checkNotNullParameter(continuation2, "completion");
            return SpeakerPulseView.this.new d(continuation2).invokeSuspend(Unit.a);
        }

        @Override // d0.w.i.a.ContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = Intrinsics2.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                Result3.throwOnFailure(obj);
                SpeakerPulseView speakerPulseView = SpeakerPulseView.this;
                ImageView imageViewB = SpeakerPulseView.b(speakerPulseView);
                this.label = 1;
                if (speakerPulseView.d(imageViewB, 200L, 500L, this) == coroutine_suspended) {
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

    /* compiled from: SpeakerPulseView.kt */
    @DebugMetadata(c = "com.discord.views.calls.SpeakerPulseView$performPulseAnimation$outer$1", f = "SpeakerPulseView.kt", l = {113}, m = "invokeSuspend")
    public static final class e extends ContinuationImpl6 implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        public int label;

        public e(Continuation continuation) {
            super(2, continuation);
        }

        @Override // d0.w.i.a.ContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Intrinsics3.checkNotNullParameter(continuation, "completion");
            return SpeakerPulseView.this.new e(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            Continuation<? super Unit> continuation2 = continuation;
            Intrinsics3.checkNotNullParameter(continuation2, "completion");
            return SpeakerPulseView.this.new e(continuation2).invokeSuspend(Unit.a);
        }

        @Override // d0.w.i.a.ContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = Intrinsics2.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                Result3.throwOnFailure(obj);
                SpeakerPulseView speakerPulseView = SpeakerPulseView.this;
                ImageView imageViewC = SpeakerPulseView.c(speakerPulseView);
                this.label = 1;
                if (speakerPulseView.d(imageViewC, 700L, 0L, this) == coroutine_suspended) {
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

    /* compiled from: SpeakerPulseView.kt */
    @DebugMetadata(c = "com.discord.views.calls.SpeakerPulseView$startAnimating$1", f = "SpeakerPulseView.kt", l = {87}, m = "invokeSuspend")
    public static final class f extends ContinuationImpl6 implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        public int label;

        /* compiled from: SpeakerPulseView.kt */
        @DebugMetadata(c = "com.discord.views.calls.SpeakerPulseView$startAnimating$1$1", f = "SpeakerPulseView.kt", l = {88}, m = "invokeSuspend")
        public static final class a extends ContinuationImpl6 implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            private /* synthetic */ Object L$0;
            public int label;

            public a(Continuation continuation) {
                super(2, continuation);
            }

            @Override // d0.w.i.a.ContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                Intrinsics3.checkNotNullParameter(continuation, "completion");
                a aVar = f.this.new a(continuation);
                aVar.L$0 = obj;
                return aVar;
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                Continuation<? super Unit> continuation2 = continuation;
                Intrinsics3.checkNotNullParameter(continuation2, "completion");
                a aVar = f.this.new a(continuation2);
                aVar.L$0 = coroutineScope;
                return aVar.invokeSuspend(Unit.a);
            }

            @Override // d0.w.i.a.ContinuationImpl
            public final Object invokeSuspend(Object obj) {
                Object coroutine_suspended = Intrinsics2.getCOROUTINE_SUSPENDED();
                int i = this.label;
                if (i == 0) {
                    Result3.throwOnFailure(obj);
                    CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
                    SpeakerPulseView speakerPulseView = SpeakerPulseView.this;
                    this.label = 1;
                    if (speakerPulseView.e(coroutineScope, this) == coroutine_suspended) {
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

        public f(Continuation continuation) {
            super(2, continuation);
        }

        @Override // d0.w.i.a.ContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Intrinsics3.checkNotNullParameter(continuation, "completion");
            return SpeakerPulseView.this.new f(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            Continuation<? super Unit> continuation2 = continuation;
            Intrinsics3.checkNotNullParameter(continuation2, "completion");
            return SpeakerPulseView.this.new f(continuation2).invokeSuspend(Unit.a);
        }

        @Override // d0.w.i.a.ContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = Intrinsics2.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                Result3.throwOnFailure(obj);
                CompletableJob completableJob = SpeakerPulseView.this.animationSupervisor;
                a aVar = new a(null);
                this.label = 1;
                if (b.i.a.f.e.o.f.C1(completableJob, aVar, this) == coroutine_suspended) {
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

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SpeakerPulseView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics3.checkNotNullParameter(context, "context");
        PathInterpolator pathInterpolator = new PathInterpolator(0.4f, 0.0f, 1.0f, 1.0f);
        this.rampUpInterpolator = pathInterpolator;
        this.fadeOutInterpolator = pathInterpolator;
        this.animationSupervisor = b.i.a.f.e.o.f.d(null, 1);
        Lazy5 lazy5 = Lazy5.NONE;
        this.innerView = LazyJVM.lazy(lazy5, new a(0, this));
        this.outerView = LazyJVM.lazy(lazy5, new a(1, this));
        setClipChildren(false);
        setClipToOutline(false);
        setClipToPadding(false);
    }

    public static final ImageView a(SpeakerPulseView speakerPulseView, int i) {
        Objects.requireNonNull(speakerPulseView);
        ImageView imageView = new ImageView(speakerPulseView.getContext());
        View childAt = speakerPulseView.getChildAt(speakerPulseView.getChildCount() - 1);
        float paddingLeft = speakerPulseView.getPaddingLeft() / 2.0f;
        int i2 = i + 1;
        Intrinsics3.checkNotNullExpressionValue(childAt, "actualChild");
        ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
        Integer numValueOf = layoutParams != null ? Integer.valueOf(layoutParams.width + ((int) (2 * paddingLeft * i2))) : null;
        imageView.setAlpha(0.0f);
        imageView.setImageResource(R.drawable.drawable_circle_white);
        int iCoerceAtLeast = _Ranges.coerceAtLeast(speakerPulseView.getChildCount() - 1, 0);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(numValueOf != null ? numValueOf.intValue() : -1, numValueOf != null ? numValueOf.intValue() : -1);
        layoutParams2.gravity = 17;
        speakerPulseView.addView(imageView, iCoerceAtLeast, layoutParams2);
        return imageView;
    }

    public static final /* synthetic */ ImageView b(SpeakerPulseView speakerPulseView) {
        return speakerPulseView.getInnerView();
    }

    public static final /* synthetic */ ImageView c(SpeakerPulseView speakerPulseView) {
        return speakerPulseView.getOuterView();
    }

    private final ImageView getInnerView() {
        return (ImageView) this.innerView.getValue();
    }

    private final ImageView getOuterView() {
        return (ImageView) this.outerView.getValue();
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final /* synthetic */ Object d(View view, long j, long j2, Continuation<? super Unit> continuation) {
        b bVar;
        SpeakerPulseView speakerPulseView;
        if (continuation instanceof b) {
            bVar = (b) continuation;
            int i = bVar.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                bVar.label = i - Integer.MIN_VALUE;
            } else {
                bVar = new b(continuation);
            }
        }
        Object obj = bVar.result;
        Object coroutine_suspended = Intrinsics2.getCOROUTINE_SUSPENDED();
        int i2 = bVar.label;
        if (i2 == 0) {
            Result3.throwOnFailure(obj);
            ViewPropertyAnimator viewPropertyAnimatorAlpha = view.animate().setInterpolator(this.rampUpInterpolator).setStartDelay(j).setDuration(500L).alpha(0.16f);
            Intrinsics3.checkNotNullExpressionValue(viewPropertyAnimatorAlpha, "animate()\n        .setIn…    .alpha(PULSE_OPACITY)");
            bVar.L$0 = this;
            bVar.L$1 = view;
            bVar.J$0 = j2;
            bVar.label = 1;
            if (AnimationCoroutineUtils.await(viewPropertyAnimatorAlpha, bVar) == coroutine_suspended) {
                return coroutine_suspended;
            }
            speakerPulseView = this;
        } else {
            if (i2 != 1) {
                if (i2 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                Result3.throwOnFailure(obj);
                return Unit.a;
            }
            j2 = bVar.J$0;
            view = (View) bVar.L$1;
            speakerPulseView = (SpeakerPulseView) bVar.L$0;
            Result3.throwOnFailure(obj);
        }
        ViewPropertyAnimator viewPropertyAnimatorAlpha2 = view.animate().setInterpolator(speakerPulseView.fadeOutInterpolator).setStartDelay(j2).setDuration(1000L).alpha(0.0f);
        Intrinsics3.checkNotNullExpressionValue(viewPropertyAnimatorAlpha2, "animate()\n        .setIn…ON_MS)\n        .alpha(0f)");
        bVar.L$0 = null;
        bVar.L$1 = null;
        bVar.label = 2;
        if (AnimationCoroutineUtils.await(viewPropertyAnimatorAlpha2, bVar) == coroutine_suspended) {
            return coroutine_suspended;
        }
        return Unit.a;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final /* synthetic */ Object e(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        c cVar;
        SpeakerPulseView speakerPulseView;
        CoroutineScope coroutineScope2;
        SpeakerPulseView speakerPulseView2;
        if (continuation instanceof c) {
            cVar = (c) continuation;
            int i = cVar.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                cVar.label = i - Integer.MIN_VALUE;
                speakerPulseView = this;
            } else {
                speakerPulseView = this;
                cVar = speakerPulseView.new c(continuation);
            }
        }
        Object obj = cVar.result;
        Object coroutine_suspended = Intrinsics2.getCOROUTINE_SUSPENDED();
        int i2 = cVar.label;
        if (i2 == 0) {
            Result3.throwOnFailure(obj);
            coroutineScope2 = coroutineScope;
            speakerPulseView2 = speakerPulseView;
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            coroutineScope2 = (CoroutineScope) cVar.L$1;
            SpeakerPulseView speakerPulseView3 = (SpeakerPulseView) cVar.L$0;
            Result3.throwOnFailure(obj);
            speakerPulseView2 = speakerPulseView3;
        }
        while (b.i.a.f.e.o.f.y0(coroutineScope2)) {
            CoroutineScope coroutineScope3 = coroutineScope2;
            Deferred[] deferredArr = {b.i.a.f.e.o.f.i(coroutineScope3, null, null, speakerPulseView2.new d(null), 3, null), b.i.a.f.e.o.f.i(coroutineScope3, null, null, speakerPulseView2.new e(null), 3, null)};
            cVar.L$0 = speakerPulseView2;
            cVar.L$1 = coroutineScope2;
            cVar.label = 1;
            if (b.i.a.f.e.o.f.l(deferredArr, cVar) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return Unit.a;
    }

    public final void f() {
        CoroutineScope coroutineScope = ViewCoroutineScope.getCoroutineScope(this);
        if (coroutineScope == null || AccessibilityUtils.INSTANCE.isReducedMotionEnabled()) {
            return;
        }
        this.hasEverAnimated = true;
        Job job = this.animationJob;
        if (job != null) {
            b.i.a.f.e.o.f.t(job, null, 1, null);
        }
        this.animationJob = b.i.a.f.e.o.f.H0(coroutineScope, null, null, new f(null), 3, null);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.isPulsing) {
            f();
        }
    }

    public final void setPulsing(boolean z2) {
        if (this.isPulsing != z2) {
            this.isPulsing = z2;
            if (z2) {
                f();
                return;
            }
            Iterator<Job> it = this.animationSupervisor.e().iterator();
            while (it.hasNext()) {
                it.next().b(null);
            }
            if (this.hasEverAnimated) {
                getInnerView().animate().setDuration(500L).alpha(0.0f);
                getOuterView().animate().setDuration(500L).alpha(0.0f);
            }
        }
    }
}
