package com.discord.widgets.chat.list;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.discord.R;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.dimen.DimenUtils;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: ViewReplySpline.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 42\u00020\u0001:\u00014B\u0019\u0012\u0006\u0010/\u001a\u00020.\u0012\b\u00101\u001a\u0004\u0018\u000100¢\u0006\u0004\b2\u00103J/\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\b\u0010\tJ\r\u0010\n\u001a\u00020\u0007¢\u0006\u0004\b\n\u0010\u000bJ\r\u0010\f\u001a\u00020\u0002¢\u0006\u0004\b\f\u0010\rJ\u0019\u0010\u0010\u001a\u00020\u00072\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0014¢\u0006\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0013\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0015\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0017\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010\u0016R\u0016\u0010\u0019\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001c\u001a\u00020\u001b8\u0002@\u0002X\u0082D¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0016\u0010\u001e\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010\u0016R\u0016\u0010\u001f\u001a\u00020\u001b8\u0002@\u0002X\u0082D¢\u0006\u0006\n\u0004\b\u001f\u0010\u001dR\u0016\u0010!\u001a\u00020 8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010#\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b#\u0010\u0016R\u0016\u0010$\u001a\u00020\u00128\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b$\u0010\u0014R\u0016\u0010%\u001a\u00020\u001b8\u0002@\u0002X\u0082D¢\u0006\u0006\n\u0004\b%\u0010\u001dR\u0016\u0010'\u001a\u00020&8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010)\u001a\u00020\u001b8\u0002@\u0002X\u0082D¢\u0006\u0006\n\u0004\b)\u0010\u001dR\u0016\u0010*\u001a\u00020\u001b8\u0002@\u0002X\u0082D¢\u0006\u0006\n\u0004\b*\u0010\u001dR\u0016\u0010+\u001a\u00020\u001b8\u0002@\u0002X\u0082D¢\u0006\u0006\n\u0004\b+\u0010\u001dR\u0016\u0010,\u001a\u00020\u001b8\u0002@\u0002X\u0082D¢\u0006\u0006\n\u0004\b,\u0010\u001dR\u0016\u0010-\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b-\u0010\u0014¨\u00065"}, d2 = {"Lcom/discord/widgets/chat/list/ViewReplySpline;", "Landroid/view/View;", "", "w", "h", "oldw", "oldh", "", "onSizeChanged", "(IIII)V", "createPath", "()V", "getLongPathOffset", "()I", "Landroid/graphics/Canvas;", "canvas", "onDraw", "(Landroid/graphics/Canvas;)V", "Landroid/graphics/RectF;", "arcRectLocal", "Landroid/graphics/RectF;", "spineStartPadding", "I", "spineEndPadding", "Landroid/graphics/Matrix;", "transformMatrix", "Landroid/graphics/Matrix;", "", "startY", "F", "capStyle", "strokeWidth", "Landroid/graphics/Path;", "path", "Landroid/graphics/Path;", "orientation", "pathRect", "halfStrokeWidth", "Landroid/graphics/Paint;", "paint", "Landroid/graphics/Paint;", "arcPercent", "endY", "startX", "endX", "pathRectLocal", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "Companion", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class ViewReplySpline extends View {
    private static final int BOTTOM_TO_END = 0;
    private static final int CAP_LONG = 1;
    private static final int CAP_LONG_AND_SHORT = 0;
    private static final int TOP_TO_END = 1;
    private final float arcPercent;
    private RectF arcRectLocal;
    private int capStyle;
    private final float endX;
    private final float endY;
    private final float halfStrokeWidth;
    private int orientation;
    private final Paint paint;
    private final Path path;
    private final RectF pathRect;
    private RectF pathRectLocal;
    private int spineEndPadding;
    private int spineStartPadding;
    private final float startX;
    private final float startY;
    private final float strokeWidth;
    private Matrix transformMatrix;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ViewReplySpline(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics3.checkNotNullParameter(context, "context");
        Paint paint = new Paint();
        this.paint = paint;
        this.path = new Path();
        this.halfStrokeWidth = 3.0f;
        float f = 3.0f * 2;
        this.strokeWidth = f;
        this.arcPercent = 0.25f;
        this.startY = 1.0f;
        this.endX = 1.0f;
        this.pathRect = new RectF(this.startX, this.endY, 1.0f, 1.0f);
        this.pathRectLocal = new RectF();
        this.arcRectLocal = new RectF();
        this.transformMatrix = new Matrix();
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeCap(Paint.Cap.ROUND);
        paint.setStrokeWidth(f);
        paint.setColor(ColorCompat.getThemedColor(this, R.attr.colorBackgroundAccent));
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.a.ViewReplySpline, 0, 0);
            Intrinsics3.checkNotNullExpressionValue(typedArrayObtainStyledAttributes, "context.obtainStyledAttr…* defStyleRes */0\n      )");
            float dimension = typedArrayObtainStyledAttributes.getDimension(3, 0.0f);
            float dimension2 = typedArrayObtainStyledAttributes.getDimension(1, 0.0f);
            this.orientation = typedArrayObtainStyledAttributes.getInteger(2, 0);
            this.capStyle = typedArrayObtainStyledAttributes.getInteger(0, 0);
            float f2 = 0;
            if (dimension > f2) {
                this.spineStartPadding = DimenUtils.dpToPixels(dimension);
            }
            if (dimension2 > f2) {
                this.spineEndPadding = DimenUtils.dpToPixels(dimension2);
            }
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    public final void createPath() {
        this.path.reset();
        int i = this.orientation;
        if (i == 0) {
            Path path = this.path;
            RectF rectF = this.pathRectLocal;
            path.moveTo(rectF.left, rectF.bottom + getLongPathOffset());
            this.path.arcTo(this.arcRectLocal, 180.0f, 90.0f, false);
            Path path2 = this.path;
            RectF rectF2 = this.pathRectLocal;
            path2.lineTo(rectF2.right, rectF2.top);
            return;
        }
        if (i != 1) {
            return;
        }
        Path path3 = this.path;
        RectF rectF3 = this.pathRectLocal;
        path3.moveTo(rectF3.left, rectF3.top - getLongPathOffset());
        this.path.arcTo(this.arcRectLocal, 180.0f, -90.0f, false);
        Path path4 = this.path;
        RectF rectF4 = this.pathRectLocal;
        path4.lineTo(rectF4.right, rectF4.bottom);
    }

    public final int getLongPathOffset() {
        int i = this.capStyle;
        if (i == 0) {
            return 0;
        }
        if (i == 1) {
            return DimenUtils.dpToPixels(1);
        }
        throw new IllegalStateException("Unknown cap style");
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (canvas != null) {
            canvas.drawPath(this.path, this.paint);
        }
    }

    @Override // android.view.View
    public void onSizeChanged(int w, int h, int oldw, int oldh) {
        RectF rectF;
        super.onSizeChanged(w, h, oldw, oldh);
        if (w == oldw && h == oldh) {
            return;
        }
        this.transformMatrix.reset();
        Matrix matrix = this.transformMatrix;
        float f = this.halfStrokeWidth;
        matrix.preTranslate(f, f);
        Matrix matrix2 = this.transformMatrix;
        float f2 = this.strokeWidth;
        matrix2.preScale((w - f2) - this.spineEndPadding, (h - f2) - this.spineStartPadding);
        this.transformMatrix.mapRect(this.pathRectLocal, this.pathRect);
        float f3 = this.arcPercent;
        RectF rectF2 = this.pathRectLocal;
        float f4 = (rectF2.right - rectF2.left) * f3 * 2;
        int i = this.orientation;
        if (i == 0) {
            RectF rectF3 = this.pathRectLocal;
            float f5 = rectF3.left;
            float f6 = rectF3.top;
            rectF = new RectF(f5, f6, f5 + f4, f4 + f6);
        } else {
            if (i != 1) {
                throw new IllegalStateException("Unknown orientation");
            }
            RectF rectF4 = this.pathRectLocal;
            float f7 = rectF4.left;
            float f8 = rectF4.bottom;
            rectF = new RectF(f7, f8 - f4, f4 + f7, f8);
        }
        this.arcRectLocal = rectF;
        createPath();
    }
}
