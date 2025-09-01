package androidx.core.graphics;

import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import b.d.b.a.outline;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: Canvas.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a+\u0010\u0004\u001a\u00020\u0002*\u00020\u00002\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001H\u0086\bø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005\u001a?\u0010\t\u001a\u00020\u0002*\u00020\u00002\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u00062\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001H\u0086\bø\u0001\u0000¢\u0006\u0004\b\t\u0010\n\u001aI\u0010\u000e\u001a\u00020\u0002*\u00020\u00002\b\b\u0002\u0010\u000b\u001a\u00020\u00062\b\b\u0002\u0010\f\u001a\u00020\u00062\b\b\u0002\u0010\r\u001a\u00020\u00062\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001H\u0086\bø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\u000f\u001aS\u0010\u0010\u001a\u00020\u0002*\u00020\u00002\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u00062\b\b\u0002\u0010\f\u001a\u00020\u00062\b\b\u0002\u0010\r\u001a\u00020\u00062\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001H\u0086\bø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\u0011\u001a?\u0010\u0012\u001a\u00020\u0002*\u00020\u00002\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u00062\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001H\u0086\bø\u0001\u0000¢\u0006\u0004\b\u0012\u0010\n\u001a5\u0010\u0015\u001a\u00020\u0002*\u00020\u00002\b\b\u0002\u0010\u0014\u001a\u00020\u00132\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001H\u0086\bø\u0001\u0000¢\u0006\u0004\b\u0015\u0010\u0016\u001a3\u0010\u0019\u001a\u00020\u0002*\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u00172\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001H\u0086\bø\u0001\u0000¢\u0006\u0004\b\u0019\u0010\u001a\u001a3\u0010\u0019\u001a\u00020\u0002*\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u001b2\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001H\u0086\bø\u0001\u0000¢\u0006\u0004\b\u0019\u0010\u001c\u001aK\u0010\u0019\u001a\u00020\u0002*\u00020\u00002\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020\u001d2\u0006\u0010 \u001a\u00020\u001d2\u0006\u0010!\u001a\u00020\u001d2\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001H\u0086\bø\u0001\u0000¢\u0006\u0004\b\u0019\u0010\"\u001aK\u0010\u0019\u001a\u00020\u0002*\u00020\u00002\u0006\u0010\u001e\u001a\u00020\u00062\u0006\u0010\u001f\u001a\u00020\u00062\u0006\u0010 \u001a\u00020\u00062\u0006\u0010!\u001a\u00020\u00062\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001H\u0086\bø\u0001\u0000¢\u0006\u0004\b\u0019\u0010\u0011\u001a3\u0010\u0019\u001a\u00020\u0002*\u00020\u00002\u0006\u0010$\u001a\u00020#2\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001H\u0086\bø\u0001\u0000¢\u0006\u0004\b\u0019\u0010%\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006&"}, d2 = {"Landroid/graphics/Canvas;", "Lkotlin/Function1;", "", "block", "withSave", "(Landroid/graphics/Canvas;Lkotlin/jvm/functions/Function1;)V", "", "x", "y", "withTranslation", "(Landroid/graphics/Canvas;FFLkotlin/jvm/functions/Function1;)V", "degrees", "pivotX", "pivotY", "withRotation", "(Landroid/graphics/Canvas;FFFLkotlin/jvm/functions/Function1;)V", "withScale", "(Landroid/graphics/Canvas;FFFFLkotlin/jvm/functions/Function1;)V", "withSkew", "Landroid/graphics/Matrix;", "matrix", "withMatrix", "(Landroid/graphics/Canvas;Landroid/graphics/Matrix;Lkotlin/jvm/functions/Function1;)V", "Landroid/graphics/Rect;", "clipRect", "withClip", "(Landroid/graphics/Canvas;Landroid/graphics/Rect;Lkotlin/jvm/functions/Function1;)V", "Landroid/graphics/RectF;", "(Landroid/graphics/Canvas;Landroid/graphics/RectF;Lkotlin/jvm/functions/Function1;)V", "", "left", "top", "right", "bottom", "(Landroid/graphics/Canvas;IIIILkotlin/jvm/functions/Function1;)V", "Landroid/graphics/Path;", "clipPath", "(Landroid/graphics/Canvas;Landroid/graphics/Path;Lkotlin/jvm/functions/Function1;)V", "core-ktx_release"}, k = 2, mv = {1, 5, 1})
/* renamed from: androidx.core.graphics.CanvasKt, reason: use source file name */
/* loaded from: classes.dex */
public final class Canvas {
    public static final void withClip(android.graphics.Canvas canvas, Rect rect, Function1<? super android.graphics.Canvas, Unit> function1) {
        Intrinsics3.checkNotNullParameter(canvas, "<this>");
        Intrinsics3.checkNotNullParameter(rect, "clipRect");
        Intrinsics3.checkNotNullParameter(function1, "block");
        int iSave = canvas.save();
        canvas.clipRect(rect);
        try {
            function1.invoke(canvas);
        } finally {
            outline.f0(1, canvas, iSave, 1);
        }
    }

    public static final void withMatrix(android.graphics.Canvas canvas, Matrix matrix, Function1<? super android.graphics.Canvas, Unit> function1) {
        Intrinsics3.checkNotNullParameter(canvas, "<this>");
        Intrinsics3.checkNotNullParameter(matrix, "matrix");
        Intrinsics3.checkNotNullParameter(function1, "block");
        int iSave = canvas.save();
        canvas.concat(matrix);
        try {
            function1.invoke(canvas);
        } finally {
            outline.f0(1, canvas, iSave, 1);
        }
    }

    public static /* synthetic */ void withMatrix$default(android.graphics.Canvas canvas, Matrix matrix, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            matrix = new Matrix();
        }
        Intrinsics3.checkNotNullParameter(canvas, "<this>");
        Intrinsics3.checkNotNullParameter(matrix, "matrix");
        Intrinsics3.checkNotNullParameter(function1, "block");
        int iSave = canvas.save();
        canvas.concat(matrix);
        try {
            function1.invoke(canvas);
        } finally {
            outline.f0(1, canvas, iSave, 1);
        }
    }

    public static final void withRotation(android.graphics.Canvas canvas, float f, float f2, float f3, Function1<? super android.graphics.Canvas, Unit> function1) {
        Intrinsics3.checkNotNullParameter(canvas, "<this>");
        Intrinsics3.checkNotNullParameter(function1, "block");
        int iSave = canvas.save();
        canvas.rotate(f, f2, f3);
        try {
            function1.invoke(canvas);
        } finally {
            outline.f0(1, canvas, iSave, 1);
        }
    }

    public static /* synthetic */ void withRotation$default(android.graphics.Canvas canvas, float f, float f2, float f3, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            f = 0.0f;
        }
        if ((i & 2) != 0) {
            f2 = 0.0f;
        }
        if ((i & 4) != 0) {
            f3 = 0.0f;
        }
        Intrinsics3.checkNotNullParameter(canvas, "<this>");
        Intrinsics3.checkNotNullParameter(function1, "block");
        int iSave = canvas.save();
        canvas.rotate(f, f2, f3);
        try {
            function1.invoke(canvas);
        } finally {
            outline.f0(1, canvas, iSave, 1);
        }
    }

    public static final void withSave(android.graphics.Canvas canvas, Function1<? super android.graphics.Canvas, Unit> function1) {
        Intrinsics3.checkNotNullParameter(canvas, "<this>");
        Intrinsics3.checkNotNullParameter(function1, "block");
        int iSave = canvas.save();
        try {
            function1.invoke(canvas);
        } finally {
            outline.f0(1, canvas, iSave, 1);
        }
    }

    public static final void withScale(android.graphics.Canvas canvas, float f, float f2, float f3, float f4, Function1<? super android.graphics.Canvas, Unit> function1) {
        Intrinsics3.checkNotNullParameter(canvas, "<this>");
        Intrinsics3.checkNotNullParameter(function1, "block");
        int iSave = canvas.save();
        canvas.scale(f, f2, f3, f4);
        try {
            function1.invoke(canvas);
        } finally {
            outline.f0(1, canvas, iSave, 1);
        }
    }

    public static /* synthetic */ void withScale$default(android.graphics.Canvas canvas, float f, float f2, float f3, float f4, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            f = 1.0f;
        }
        if ((i & 2) != 0) {
            f2 = 1.0f;
        }
        if ((i & 4) != 0) {
            f3 = 0.0f;
        }
        if ((i & 8) != 0) {
            f4 = 0.0f;
        }
        Intrinsics3.checkNotNullParameter(canvas, "<this>");
        Intrinsics3.checkNotNullParameter(function1, "block");
        int iSave = canvas.save();
        canvas.scale(f, f2, f3, f4);
        try {
            function1.invoke(canvas);
        } finally {
            outline.f0(1, canvas, iSave, 1);
        }
    }

    public static final void withSkew(android.graphics.Canvas canvas, float f, float f2, Function1<? super android.graphics.Canvas, Unit> function1) {
        Intrinsics3.checkNotNullParameter(canvas, "<this>");
        Intrinsics3.checkNotNullParameter(function1, "block");
        int iSave = canvas.save();
        canvas.skew(f, f2);
        try {
            function1.invoke(canvas);
        } finally {
            outline.f0(1, canvas, iSave, 1);
        }
    }

    public static /* synthetic */ void withSkew$default(android.graphics.Canvas canvas, float f, float f2, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            f = 0.0f;
        }
        if ((i & 2) != 0) {
            f2 = 0.0f;
        }
        Intrinsics3.checkNotNullParameter(canvas, "<this>");
        Intrinsics3.checkNotNullParameter(function1, "block");
        int iSave = canvas.save();
        canvas.skew(f, f2);
        try {
            function1.invoke(canvas);
        } finally {
            outline.f0(1, canvas, iSave, 1);
        }
    }

    public static final void withTranslation(android.graphics.Canvas canvas, float f, float f2, Function1<? super android.graphics.Canvas, Unit> function1) {
        Intrinsics3.checkNotNullParameter(canvas, "<this>");
        Intrinsics3.checkNotNullParameter(function1, "block");
        int iSave = canvas.save();
        canvas.translate(f, f2);
        try {
            function1.invoke(canvas);
        } finally {
            outline.f0(1, canvas, iSave, 1);
        }
    }

    public static /* synthetic */ void withTranslation$default(android.graphics.Canvas canvas, float f, float f2, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            f = 0.0f;
        }
        if ((i & 2) != 0) {
            f2 = 0.0f;
        }
        Intrinsics3.checkNotNullParameter(canvas, "<this>");
        Intrinsics3.checkNotNullParameter(function1, "block");
        int iSave = canvas.save();
        canvas.translate(f, f2);
        try {
            function1.invoke(canvas);
        } finally {
            outline.f0(1, canvas, iSave, 1);
        }
    }

    public static final void withClip(android.graphics.Canvas canvas, RectF rectF, Function1<? super android.graphics.Canvas, Unit> function1) {
        Intrinsics3.checkNotNullParameter(canvas, "<this>");
        Intrinsics3.checkNotNullParameter(rectF, "clipRect");
        Intrinsics3.checkNotNullParameter(function1, "block");
        int iSave = canvas.save();
        canvas.clipRect(rectF);
        try {
            function1.invoke(canvas);
        } finally {
            outline.f0(1, canvas, iSave, 1);
        }
    }

    public static final void withClip(android.graphics.Canvas canvas, int i, int i2, int i3, int i4, Function1<? super android.graphics.Canvas, Unit> function1) {
        Intrinsics3.checkNotNullParameter(canvas, "<this>");
        Intrinsics3.checkNotNullParameter(function1, "block");
        int iSave = canvas.save();
        canvas.clipRect(i, i2, i3, i4);
        try {
            function1.invoke(canvas);
        } finally {
            outline.f0(1, canvas, iSave, 1);
        }
    }

    public static final void withClip(android.graphics.Canvas canvas, float f, float f2, float f3, float f4, Function1<? super android.graphics.Canvas, Unit> function1) {
        Intrinsics3.checkNotNullParameter(canvas, "<this>");
        Intrinsics3.checkNotNullParameter(function1, "block");
        int iSave = canvas.save();
        canvas.clipRect(f, f2, f3, f4);
        try {
            function1.invoke(canvas);
        } finally {
            outline.f0(1, canvas, iSave, 1);
        }
    }

    public static final void withClip(android.graphics.Canvas canvas, Path path, Function1<? super android.graphics.Canvas, Unit> function1) {
        Intrinsics3.checkNotNullParameter(canvas, "<this>");
        Intrinsics3.checkNotNullParameter(path, "clipPath");
        Intrinsics3.checkNotNullParameter(function1, "block");
        int iSave = canvas.save();
        canvas.clipPath(path);
        try {
            function1.invoke(canvas);
        } finally {
            outline.f0(1, canvas, iSave, 1);
        }
    }
}
