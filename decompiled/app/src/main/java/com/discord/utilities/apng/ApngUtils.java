package com.discord.utilities.apng;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import b.i.a.f.e.o.f;
import b.l.a.ApngDrawable;
import d0.Result3;
import d0.w.h.Intrinsics2;
import d0.w.i.a.ContinuationImpl6;
import d0.w.i.a.DebugMetadata;
import d0.y.Closeable;
import d0.z.d.Intrinsics3;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import s.a.CoroutineScope2;
import s.a.Dispatchers;
import s.a.MainCoroutineDispatcher;
import s.a.a.MainDispatchers;

/* compiled from: ApngUtils.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0014\u0010\u0015J?\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\n\u001a\u00020\t¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0013\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\u0013\u0010\u0012¨\u0006\u0016"}, d2 = {"Lcom/discord/utilities/apng/ApngUtils;", "", "Ljava/io/File;", "file", "Landroid/widget/ImageView;", "imageView", "", "maxWidth", "maxHeight", "", "autoPlay", "Lkotlinx/coroutines/Job;", "renderApngFromFile", "(Ljava/io/File;Landroid/widget/ImageView;Ljava/lang/Integer;Ljava/lang/Integer;Z)Lkotlinx/coroutines/Job;", "Landroid/graphics/drawable/Drawable;", "drawable", "", "playApngAnimation", "(Landroid/graphics/drawable/Drawable;)V", "pauseApngAnimation", "<init>", "()V", "utils_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class ApngUtils {
    public static final ApngUtils INSTANCE = new ApngUtils();

    /* compiled from: ApngUtils.kt */
    @DebugMetadata(c = "com.discord.utilities.apng.ApngUtils$renderApngFromFile$3", f = "ApngUtils.kt", l = {31}, m = "invokeSuspend")
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\u008a@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.utilities.apng.ApngUtils$renderApngFromFile$3, reason: invalid class name */
    public static final class AnonymousClass3 extends ContinuationImpl6 implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        public final /* synthetic */ boolean $autoPlay;
        public final /* synthetic */ File $file;
        public final /* synthetic */ Ref$ObjectRef $imageViewRef;
        public final /* synthetic */ Integer $maxHeight;
        public final /* synthetic */ Integer $maxWidth;
        public int label;

        /* compiled from: ApngUtils.kt */
        @DebugMetadata(c = "com.discord.utilities.apng.ApngUtils$renderApngFromFile$3$1", f = "ApngUtils.kt", l = {}, m = "invokeSuspend")
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\u008a@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
        /* renamed from: com.discord.utilities.apng.ApngUtils$renderApngFromFile$3$1, reason: invalid class name */
        public static final class AnonymousClass1 extends ContinuationImpl6 implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            public final /* synthetic */ Ref$ObjectRef $drawable;
            public int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(Ref$ObjectRef ref$ObjectRef, Continuation continuation) {
                super(2, continuation);
                this.$drawable = ref$ObjectRef;
            }

            @Override // d0.w.i.a.ContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                Intrinsics3.checkNotNullParameter(continuation, "completion");
                return AnonymousClass3.this.new AnonymousClass1(this.$drawable, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.a);
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // d0.w.i.a.ContinuationImpl
            public final Object invokeSuspend(Object obj) {
                Intrinsics2.getCOROUTINE_SUSPENDED();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                Result3.throwOnFailure(obj);
                ImageView imageView = (ImageView) ((WeakReference) AnonymousClass3.this.$imageViewRef.element).get();
                if (imageView == null) {
                    return Unit.a;
                }
                Intrinsics3.checkNotNullExpressionValue(imageView, "imageViewRef.get() ?: return@withContext");
                imageView.setImageDrawable((ApngDrawable) this.$drawable.element);
                if (AnonymousClass3.this.$autoPlay) {
                    ApngUtils.INSTANCE.playApngAnimation((ApngDrawable) this.$drawable.element);
                }
                return Unit.a;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass3(File file, Integer num, Integer num2, Ref$ObjectRef ref$ObjectRef, boolean z2, Continuation continuation) {
            super(2, continuation);
            this.$file = file;
            this.$maxHeight = num;
            this.$maxWidth = num2;
            this.$imageViewRef = ref$ObjectRef;
            this.$autoPlay = z2;
        }

        @Override // d0.w.i.a.ContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Intrinsics3.checkNotNullParameter(continuation, "completion");
            return new AnonymousClass3(this.$file, this.$maxHeight, this.$maxWidth, this.$imageViewRef, this.$autoPlay, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass3) create(coroutineScope, continuation)).invokeSuspend(Unit.a);
        }

        /* JADX WARN: Type inference failed for: r1v4, types: [T, b.l.a.a] */
        @Override // d0.w.i.a.ContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = Intrinsics2.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                if (i == 0) {
                    Result3.throwOnFailure(obj);
                    Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
                    File file = this.$file;
                    Integer num = this.$maxHeight;
                    Integer num2 = this.$maxWidth;
                    Intrinsics3.checkNotNullParameter(file, "file");
                    InputStream fileInputStream = new FileInputStream(file);
                    BufferedInputStream bufferedInputStream = fileInputStream instanceof BufferedInputStream ? (BufferedInputStream) fileInputStream : new BufferedInputStream(fileInputStream, 8192);
                    try {
                        ?? A = ApngDrawable.a(bufferedInputStream, num2, num);
                        Closeable.closeFinally(bufferedInputStream, null);
                        ref$ObjectRef.element = A;
                        CoroutineDispatcher coroutineDispatcher = Dispatchers.a;
                        MainCoroutineDispatcher mainCoroutineDispatcher = MainDispatchers.f3830b;
                        AnonymousClass1 anonymousClass1 = new AnonymousClass1(ref$ObjectRef, null);
                        this.label = 1;
                        if (f.C1(mainCoroutineDispatcher, anonymousClass1, this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } finally {
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    Result3.throwOnFailure(obj);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return Unit.a;
        }
    }

    private ApngUtils() {
    }

    public static /* synthetic */ Job renderApngFromFile$default(ApngUtils apngUtils, File file, ImageView imageView, Integer num, Integer num2, boolean z2, int i, Object obj) {
        return apngUtils.renderApngFromFile(file, imageView, (i & 4) != 0 ? null : num, (i & 8) != 0 ? null : num2, (i & 16) != 0 ? false : z2);
    }

    public final void pauseApngAnimation(Drawable drawable) {
        if (drawable instanceof ApngDrawable) {
            ((ApngDrawable) drawable).stop();
        }
    }

    public final void playApngAnimation(Drawable drawable) {
        if (drawable instanceof ApngDrawable) {
            ((ApngDrawable) drawable).start();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v2, types: [T, java.lang.ref.WeakReference] */
    public final Job renderApngFromFile(File file, ImageView imageView, Integer maxWidth, Integer maxHeight, boolean autoPlay) {
        Intrinsics3.checkNotNullParameter(file, "file");
        Intrinsics3.checkNotNullParameter(imageView, "imageView");
        Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
        ref$ObjectRef.element = new WeakReference(imageView);
        if (maxHeight != null) {
            int iIntValue = maxHeight.intValue();
            ImageView imageView2 = (ImageView) ((WeakReference) ref$ObjectRef.element).get();
            if (imageView2 != null) {
                imageView2.setMaxHeight(iIntValue);
            }
        }
        if (maxWidth != null) {
            int iIntValue2 = maxWidth.intValue();
            ImageView imageView3 = (ImageView) ((WeakReference) ref$ObjectRef.element).get();
            if (imageView3 != null) {
                imageView3.setMaxWidth(iIntValue2);
            }
        }
        return f.H0(CoroutineScope2.j, Dispatchers.f3842b, null, new AnonymousClass3(file, maxHeight, maxWidth, ref$ObjectRef, autoPlay, null), 2, null);
    }
}
