package androidx.core.view;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.annotation.Px;
import androidx.annotation.RequiresApi;
import androidx.exifinterface.media.ExifInterface;
import d0.f0.SequenceBuilder3;
import d0.f0.n;
import d0.z.d.Intrinsics3;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.sequences.Sequence;

/* compiled from: View.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u001a-\u0010\u0004\u001a\u00020\u0002*\u00020\u00002\u0014\b\u0004\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001H\u0086\bø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005\u001a-\u0010\u0006\u001a\u00020\u0002*\u00020\u00002\u0014\b\u0004\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001H\u0086\bø\u0001\u0000¢\u0006\u0004\b\u0006\u0010\u0005\u001a-\u0010\b\u001a\u00020\u0007*\u00020\u00002\u0014\b\u0004\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001H\u0086\bø\u0001\u0000¢\u0006\u0004\b\b\u0010\t\u001a-\u0010\n\u001a\u00020\u0002*\u00020\u00002\u0014\b\u0004\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001H\u0086\bø\u0001\u0000¢\u0006\u0004\b\n\u0010\u0005\u001a-\u0010\u000b\u001a\u00020\u0002*\u00020\u00002\u0014\b\u0004\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001H\u0086\bø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\u0005\u001a<\u0010\u0011\u001a\u00020\u0002*\u00020\u00002\b\b\u0003\u0010\r\u001a\u00020\f2\b\b\u0003\u0010\u000e\u001a\u00020\f2\b\b\u0003\u0010\u000f\u001a\u00020\f2\b\b\u0003\u0010\u0010\u001a\u00020\fH\u0087\b¢\u0006\u0004\b\u0011\u0010\u0012\u001a<\u0010\u0015\u001a\u00020\u0002*\u00020\u00002\b\b\u0003\u0010\u0013\u001a\u00020\f2\b\b\u0003\u0010\u000e\u001a\u00020\f2\b\b\u0003\u0010\u0014\u001a\u00020\f2\b\b\u0003\u0010\u0010\u001a\u00020\fH\u0086\b¢\u0006\u0004\b\u0015\u0010\u0012\u001a\u001e\u0010\u0017\u001a\u00020\u0002*\u00020\u00002\b\b\u0001\u0010\u0016\u001a\u00020\fH\u0086\b¢\u0006\u0004\b\u0017\u0010\u0018\u001a/\u0010\u001d\u001a\u00020\u001c*\u00020\u00002\u0006\u0010\u001a\u001a\u00020\u00192\u000e\b\u0004\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u001bH\u0086\bø\u0001\u0000¢\u0006\u0004\b\u001d\u0010\u001e\u001a/\u0010\u001f\u001a\u00020\u001c*\u00020\u00002\u0006\u0010\u001a\u001a\u00020\u00192\u000e\b\u0004\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u001bH\u0087\bø\u0001\u0000¢\u0006\u0004\b\u001f\u0010\u001e\u001a\u001b\u0010#\u001a\u00020\"*\u00020\u00002\b\b\u0002\u0010!\u001a\u00020 ¢\u0006\u0004\b#\u0010$\u001a+\u0010'\u001a\u00020\u0002*\u00020\u00002\u0012\u0010&\u001a\u000e\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020\u00020\u0001H\u0086\bø\u0001\u0000¢\u0006\u0004\b'\u0010\u0005\u001a7\u0010'\u001a\u00020\u0002\"\n\b\u0000\u0010(\u0018\u0001*\u00020%*\u00020\u00002\u0012\u0010&\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00020\u0001H\u0087\bø\u0001\u0000¢\u0006\u0004\b)\u0010\u0005\"\u0018\u0010,\u001a\u00020\f*\u00020\u00008Æ\u0002@\u0006¢\u0006\u0006\u001a\u0004\b*\u0010+\"\u0018\u0010.\u001a\u00020\f*\u00020\u00008Æ\u0002@\u0006¢\u0006\u0006\u001a\u0004\b-\u0010+\"*\u00101\u001a\u00020/*\u00020\u00002\u0006\u00100\u001a\u00020/8Æ\u0002@Æ\u0002X\u0086\u000e¢\u0006\f\u001a\u0004\b1\u00102\"\u0004\b3\u00104\"*\u00105\u001a\u00020/*\u00020\u00002\u0006\u00100\u001a\u00020/8Æ\u0002@Æ\u0002X\u0086\u000e¢\u0006\f\u001a\u0004\b5\u00102\"\u0004\b6\u00104\"\u0018\u00108\u001a\u00020\f*\u00020\u00008Æ\u0002@\u0006¢\u0006\u0006\u001a\u0004\b7\u0010+\"\u0018\u0010:\u001a\u00020\f*\u00020\u00008Æ\u0002@\u0006¢\u0006\u0006\u001a\u0004\b9\u0010+\"\u001d\u0010>\u001a\b\u0012\u0004\u0012\u00020\u00000;*\u00020\u00008F@\u0006¢\u0006\u0006\u001a\u0004\b<\u0010=\"\u001d\u0010A\u001a\b\u0012\u0004\u0012\u00020?0;*\u00020\u00008F@\u0006¢\u0006\u0006\u001a\u0004\b@\u0010=\"*\u0010B\u001a\u00020/*\u00020\u00002\u0006\u00100\u001a\u00020/8Æ\u0002@Æ\u0002X\u0086\u000e¢\u0006\f\u001a\u0004\bB\u00102\"\u0004\bC\u00104\"\u0018\u0010E\u001a\u00020\f*\u00020\u00008Æ\u0002@\u0006¢\u0006\u0006\u001a\u0004\bD\u0010+\"\u0018\u0010G\u001a\u00020\f*\u00020\u00008Æ\u0002@\u0006¢\u0006\u0006\u001a\u0004\bF\u0010+\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006H"}, d2 = {"Landroid/view/View;", "Lkotlin/Function1;", "", "action", "doOnNextLayout", "(Landroid/view/View;Lkotlin/jvm/functions/Function1;)V", "doOnLayout", "Landroidx/core/view/OneShotPreDrawListener;", "doOnPreDraw", "(Landroid/view/View;Lkotlin/jvm/functions/Function1;)Landroidx/core/view/OneShotPreDrawListener;", "doOnAttach", "doOnDetach", "", "start", "top", "end", "bottom", "updatePaddingRelative", "(Landroid/view/View;IIII)V", "left", "right", "updatePadding", "size", "setPadding", "(Landroid/view/View;I)V", "", "delayInMillis", "Lkotlin/Function0;", "Ljava/lang/Runnable;", "postDelayed", "(Landroid/view/View;JLkotlin/jvm/functions/Function0;)Ljava/lang/Runnable;", "postOnAnimationDelayed", "Landroid/graphics/Bitmap$Config;", "config", "Landroid/graphics/Bitmap;", "drawToBitmap", "(Landroid/view/View;Landroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;", "Landroid/view/ViewGroup$LayoutParams;", "block", "updateLayoutParams", ExifInterface.GPS_DIRECTION_TRUE, "updateLayoutParamsTyped", "getMarginLeft", "(Landroid/view/View;)I", "marginLeft", "getMarginBottom", "marginBottom", "", "value", "isVisible", "(Landroid/view/View;)Z", "setVisible", "(Landroid/view/View;Z)V", "isGone", "setGone", "getMarginStart", "marginStart", "getMarginEnd", "marginEnd", "Lkotlin/sequences/Sequence;", "getAllViews", "(Landroid/view/View;)Lkotlin/sequences/Sequence;", "allViews", "Landroid/view/ViewParent;", "getAncestors", "ancestors", "isInvisible", "setInvisible", "getMarginTop", "marginTop", "getMarginRight", "marginRight", "core-ktx_release"}, k = 2, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class ViewKt {

    /* compiled from: View.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\u0006¨\u0006\b"}, d2 = {"androidx/core/view/ViewKt$doOnAttach$1", "Landroid/view/View$OnAttachStateChangeListener;", "Landroid/view/View;", "view", "", "onViewAttachedToWindow", "(Landroid/view/View;)V", "onViewDetachedFromWindow", "core-ktx_release"}, k = 1, mv = {1, 5, 1})
    /* renamed from: androidx.core.view.ViewKt$doOnAttach$1, reason: invalid class name */
    public static final class AnonymousClass1 implements View.OnAttachStateChangeListener {
        public final /* synthetic */ Function1<View, Unit> $action;
        public final /* synthetic */ View $this_doOnAttach;

        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass1(View view, Function1<? super View, Unit> function1) {
            this.$this_doOnAttach = view;
            this.$action = function1;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            Intrinsics3.checkNotNullParameter(view, "view");
            this.$this_doOnAttach.removeOnAttachStateChangeListener(this);
            this.$action.invoke(view);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            Intrinsics3.checkNotNullParameter(view, "view");
        }
    }

    /* compiled from: View.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\u0006¨\u0006\b"}, d2 = {"androidx/core/view/ViewKt$doOnDetach$1", "Landroid/view/View$OnAttachStateChangeListener;", "Landroid/view/View;", "view", "", "onViewAttachedToWindow", "(Landroid/view/View;)V", "onViewDetachedFromWindow", "core-ktx_release"}, k = 1, mv = {1, 5, 1})
    /* renamed from: androidx.core.view.ViewKt$doOnDetach$1, reason: invalid class name */
    public static final class AnonymousClass1 implements View.OnAttachStateChangeListener {
        public final /* synthetic */ Function1<View, Unit> $action;
        public final /* synthetic */ View $this_doOnDetach;

        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass1(View view, Function1<? super View, Unit> function1) {
            this.$this_doOnDetach = view;
            this.$action = function1;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            Intrinsics3.checkNotNullParameter(view, "view");
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            Intrinsics3.checkNotNullParameter(view, "view");
            this.$this_doOnDetach.removeOnAttachStateChangeListener(this);
            this.$action.invoke(view);
        }
    }

    /* compiled from: View.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001JW\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"androidx/core/view/ViewKt$doOnNextLayout$1", "Landroid/view/View$OnLayoutChangeListener;", "Landroid/view/View;", "view", "", "left", "top", "right", "bottom", "oldLeft", "oldTop", "oldRight", "oldBottom", "", "onLayoutChange", "(Landroid/view/View;IIIIIIII)V", "core-ktx_release"}, k = 1, mv = {1, 5, 1})
    /* renamed from: androidx.core.view.ViewKt$doOnNextLayout$1, reason: invalid class name */
    public static final class AnonymousClass1 implements View.OnLayoutChangeListener {
        public final /* synthetic */ Function1<View, Unit> $action;

        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass1(Function1<? super View, Unit> function1) {
            this.$action = function1;
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View view, int left, int top, int right, int bottom, int oldLeft, int oldTop, int oldRight, int oldBottom) {
            Intrinsics3.checkNotNullParameter(view, "view");
            view.removeOnLayoutChangeListener(this);
            this.$action.invoke(view);
        }
    }

    /* compiled from: View.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "<anonymous>", "()V"}, k = 3, mv = {1, 5, 1})
    /* renamed from: androidx.core.view.ViewKt$doOnPreDraw$1, reason: invalid class name */
    public static final class AnonymousClass1 implements Runnable {
        public final /* synthetic */ Function1<View, Unit> $action;
        public final /* synthetic */ View $this_doOnPreDraw;

        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass1(Function1<? super View, Unit> function1, View view) {
            this.$action = function1;
            this.$this_doOnPreDraw = view;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.$action.invoke(this.$this_doOnPreDraw);
        }
    }

    public static final void doOnAttach(View view, Function1<? super View, Unit> function1) {
        Intrinsics3.checkNotNullParameter(view, "<this>");
        Intrinsics3.checkNotNullParameter(function1, "action");
        if (ViewCompat.isAttachedToWindow(view)) {
            function1.invoke(view);
        } else {
            view.addOnAttachStateChangeListener(new AnonymousClass1(view, function1));
        }
    }

    public static final void doOnDetach(View view, Function1<? super View, Unit> function1) {
        Intrinsics3.checkNotNullParameter(view, "<this>");
        Intrinsics3.checkNotNullParameter(function1, "action");
        if (ViewCompat.isAttachedToWindow(view)) {
            view.addOnAttachStateChangeListener(new AnonymousClass1(view, function1));
        } else {
            function1.invoke(view);
        }
    }

    public static final void doOnLayout(View view, Function1<? super View, Unit> function1) {
        Intrinsics3.checkNotNullParameter(view, "<this>");
        Intrinsics3.checkNotNullParameter(function1, "action");
        if (!ViewCompat.isLaidOut(view) || view.isLayoutRequested()) {
            view.addOnLayoutChangeListener(new ViewKt$doOnLayout$$inlined$doOnNextLayout$1(function1));
        } else {
            function1.invoke(view);
        }
    }

    public static final void doOnNextLayout(View view, Function1<? super View, Unit> function1) {
        Intrinsics3.checkNotNullParameter(view, "<this>");
        Intrinsics3.checkNotNullParameter(function1, "action");
        view.addOnLayoutChangeListener(new AnonymousClass1(function1));
    }

    public static final OneShotPreDrawListener doOnPreDraw(View view, Function1<? super View, Unit> function1) {
        Intrinsics3.checkNotNullParameter(view, "<this>");
        Intrinsics3.checkNotNullParameter(function1, "action");
        OneShotPreDrawListener oneShotPreDrawListenerAdd = OneShotPreDrawListener.add(view, new AnonymousClass1(function1, view));
        Intrinsics3.checkNotNullExpressionValue(oneShotPreDrawListenerAdd, "View.doOnPreDraw(\n    crossinline action: (view: View) -> Unit\n): OneShotPreDrawListener = OneShotPreDrawListener.add(this) { action(this) }");
        return oneShotPreDrawListenerAdd;
    }

    public static final Bitmap drawToBitmap(View view, Bitmap.Config config) {
        Intrinsics3.checkNotNullParameter(view, "<this>");
        Intrinsics3.checkNotNullParameter(config, "config");
        if (!ViewCompat.isLaidOut(view)) {
            throw new IllegalStateException("View needs to be laid out before calling drawToBitmap()");
        }
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(view.getWidth(), view.getHeight(), config);
        Intrinsics3.checkNotNullExpressionValue(bitmapCreateBitmap, "createBitmap(width, height, config)");
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        canvas.translate(-view.getScrollX(), -view.getScrollY());
        view.draw(canvas);
        return bitmapCreateBitmap;
    }

    public static /* synthetic */ Bitmap drawToBitmap$default(View view, Bitmap.Config config, int i, Object obj) {
        if ((i & 1) != 0) {
            config = Bitmap.Config.ARGB_8888;
        }
        return drawToBitmap(view, config);
    }

    public static final Sequence<View> getAllViews(View view) {
        Intrinsics3.checkNotNullParameter(view, "<this>");
        return SequenceBuilder3.sequence(new ViewKt$allViews$1(view, null));
    }

    public static final Sequence<ViewParent> getAncestors(View view) {
        Intrinsics3.checkNotNullParameter(view, "<this>");
        return n.generateSequence(view.getParent(), ViewKt$ancestors$1.INSTANCE);
    }

    public static final int getMarginBottom(View view) {
        Intrinsics3.checkNotNullParameter(view, "<this>");
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        ViewGroup.MarginLayoutParams marginLayoutParams = layoutParams instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams : null;
        if (marginLayoutParams == null) {
            return 0;
        }
        return marginLayoutParams.bottomMargin;
    }

    public static final int getMarginEnd(View view) {
        Intrinsics3.checkNotNullParameter(view, "<this>");
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return MarginLayoutParamsCompat.getMarginEnd((ViewGroup.MarginLayoutParams) layoutParams);
        }
        return 0;
    }

    public static final int getMarginLeft(View view) {
        Intrinsics3.checkNotNullParameter(view, "<this>");
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        ViewGroup.MarginLayoutParams marginLayoutParams = layoutParams instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams : null;
        if (marginLayoutParams == null) {
            return 0;
        }
        return marginLayoutParams.leftMargin;
    }

    public static final int getMarginRight(View view) {
        Intrinsics3.checkNotNullParameter(view, "<this>");
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        ViewGroup.MarginLayoutParams marginLayoutParams = layoutParams instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams : null;
        if (marginLayoutParams == null) {
            return 0;
        }
        return marginLayoutParams.rightMargin;
    }

    public static final int getMarginStart(View view) {
        Intrinsics3.checkNotNullParameter(view, "<this>");
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return MarginLayoutParamsCompat.getMarginStart((ViewGroup.MarginLayoutParams) layoutParams);
        }
        return 0;
    }

    public static final int getMarginTop(View view) {
        Intrinsics3.checkNotNullParameter(view, "<this>");
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        ViewGroup.MarginLayoutParams marginLayoutParams = layoutParams instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams : null;
        if (marginLayoutParams == null) {
            return 0;
        }
        return marginLayoutParams.topMargin;
    }

    public static final boolean isGone(View view) {
        Intrinsics3.checkNotNullParameter(view, "<this>");
        return view.getVisibility() == 8;
    }

    public static final boolean isInvisible(View view) {
        Intrinsics3.checkNotNullParameter(view, "<this>");
        return view.getVisibility() == 4;
    }

    public static final boolean isVisible(View view) {
        Intrinsics3.checkNotNullParameter(view, "<this>");
        return view.getVisibility() == 0;
    }

    public static final Runnable postDelayed(View view, long j, Function0<Unit> function0) {
        Intrinsics3.checkNotNullParameter(view, "<this>");
        Intrinsics3.checkNotNullParameter(function0, "action");
        ViewKt$postDelayed$runnable$1 viewKt$postDelayed$runnable$1 = new ViewKt$postDelayed$runnable$1(function0);
        view.postDelayed(viewKt$postDelayed$runnable$1, j);
        return viewKt$postDelayed$runnable$1;
    }

    @RequiresApi(16)
    public static final Runnable postOnAnimationDelayed(View view, long j, Function0<Unit> function0) {
        Intrinsics3.checkNotNullParameter(view, "<this>");
        Intrinsics3.checkNotNullParameter(function0, "action");
        ViewKt$postOnAnimationDelayed$runnable$1 viewKt$postOnAnimationDelayed$runnable$1 = new ViewKt$postOnAnimationDelayed$runnable$1(function0);
        view.postOnAnimationDelayed(viewKt$postOnAnimationDelayed$runnable$1, j);
        return viewKt$postOnAnimationDelayed$runnable$1;
    }

    public static final void setGone(View view, boolean z2) {
        Intrinsics3.checkNotNullParameter(view, "<this>");
        view.setVisibility(z2 ? 8 : 0);
    }

    public static final void setInvisible(View view, boolean z2) {
        Intrinsics3.checkNotNullParameter(view, "<this>");
        view.setVisibility(z2 ? 4 : 0);
    }

    public static final void setPadding(View view, @Px int i) {
        Intrinsics3.checkNotNullParameter(view, "<this>");
        view.setPadding(i, i, i, i);
    }

    public static final void setVisible(View view, boolean z2) {
        Intrinsics3.checkNotNullParameter(view, "<this>");
        view.setVisibility(z2 ? 0 : 8);
    }

    public static final void updateLayoutParams(View view, Function1<? super ViewGroup.LayoutParams, Unit> function1) {
        Intrinsics3.checkNotNullParameter(view, "<this>");
        Intrinsics3.checkNotNullParameter(function1, "block");
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
        function1.invoke(layoutParams);
        view.setLayoutParams(layoutParams);
    }

    public static final /* synthetic */ <T extends ViewGroup.LayoutParams> void updateLayoutParamsTyped(View view, Function1<? super T, Unit> function1) {
        Intrinsics3.checkNotNullParameter(view, "<this>");
        Intrinsics3.checkNotNullParameter(function1, "block");
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        Intrinsics3.reifiedOperationMarker(1, ExifInterface.GPS_DIRECTION_TRUE);
        function1.invoke(layoutParams);
        view.setLayoutParams(layoutParams);
    }

    public static final void updatePadding(View view, @Px int i, @Px int i2, @Px int i3, @Px int i4) {
        Intrinsics3.checkNotNullParameter(view, "<this>");
        view.setPadding(i, i2, i3, i4);
    }

    public static /* synthetic */ void updatePadding$default(View view, int i, int i2, int i3, int i4, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            i = view.getPaddingLeft();
        }
        if ((i5 & 2) != 0) {
            i2 = view.getPaddingTop();
        }
        if ((i5 & 4) != 0) {
            i3 = view.getPaddingRight();
        }
        if ((i5 & 8) != 0) {
            i4 = view.getPaddingBottom();
        }
        Intrinsics3.checkNotNullParameter(view, "<this>");
        view.setPadding(i, i2, i3, i4);
    }

    @RequiresApi(17)
    public static final void updatePaddingRelative(View view, @Px int i, @Px int i2, @Px int i3, @Px int i4) {
        Intrinsics3.checkNotNullParameter(view, "<this>");
        view.setPaddingRelative(i, i2, i3, i4);
    }

    public static /* synthetic */ void updatePaddingRelative$default(View view, int i, int i2, int i3, int i4, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            i = view.getPaddingStart();
        }
        if ((i5 & 2) != 0) {
            i2 = view.getPaddingTop();
        }
        if ((i5 & 4) != 0) {
            i3 = view.getPaddingEnd();
        }
        if ((i5 & 8) != 0) {
            i4 = view.getPaddingBottom();
        }
        Intrinsics3.checkNotNullParameter(view, "<this>");
        view.setPaddingRelative(i, i2, i3, i4);
    }
}
