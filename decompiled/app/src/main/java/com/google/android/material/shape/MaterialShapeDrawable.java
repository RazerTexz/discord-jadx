package com.google.android.material.shape;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Looper;
import android.util.AttributeSet;
import android.util.Log;
import androidx.annotation.AttrRes;
import androidx.annotation.ColorInt;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;
import androidx.core.graphics.drawable.TintAwareDrawable;
import androidx.core.util.ObjectsCompat;
import com.google.android.material.R;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.elevation.ElevationOverlayProvider;
import com.google.android.material.shadow.ShadowRenderer;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.shape.ShapeAppearancePathProvider;
import com.google.android.material.shape.ShapePath;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.BitSet;

/* loaded from: classes3.dex */
public class MaterialShapeDrawable extends Drawable implements TintAwareDrawable, Shapeable {
    public static final int SHADOW_COMPAT_MODE_ALWAYS = 2;
    public static final int SHADOW_COMPAT_MODE_DEFAULT = 0;
    public static final int SHADOW_COMPAT_MODE_NEVER = 1;
    private static final float SHADOW_OFFSET_MULTIPLIER = 0.25f;
    private static final float SHADOW_RADIUS_MULTIPLIER = 0.75f;
    private static final String TAG = MaterialShapeDrawable.class.getSimpleName();
    private static final Paint clearPaint = new Paint(1);
    private final BitSet containsIncompatibleShadowOp;
    private final ShapePath.d[] cornerShadowOperation;
    private c drawableState;
    private final ShapePath.d[] edgeShadowOperation;
    private final Paint fillPaint;
    private final RectF insetRectF;
    private final Matrix matrix;
    private final Path path;

    @NonNull
    private final RectF pathBounds;
    private boolean pathDirty;
    private final Path pathInsetByStroke;
    private final ShapeAppearancePathProvider pathProvider;

    @NonNull
    private final ShapeAppearancePathProvider.PathListener pathShadowListener;
    private final RectF rectF;
    private final Region scratchRegion;
    private boolean shadowBitmapDrawingEnable;
    private final ShadowRenderer shadowRenderer;
    private final Paint strokePaint;
    private ShapeAppearanceModel strokeShapeAppearance;

    @Nullable
    private PorterDuffColorFilter strokeTintFilter;

    @Nullable
    private PorterDuffColorFilter tintFilter;
    private final Region transparentRegion;

    @Retention(RetentionPolicy.SOURCE)
    public @interface CompatibilityShadowMode {
    }

    public class a implements ShapeAppearancePathProvider.PathListener {
        public a() {
        }

        @Override // com.google.android.material.shape.ShapeAppearancePathProvider.PathListener
        public void onCornerPathCreated(@NonNull ShapePath shapePath, Matrix matrix, int i) {
            MaterialShapeDrawable.access$000(MaterialShapeDrawable.this).set(i, shapePath.containsIncompatibleShadowOp());
            MaterialShapeDrawable.access$100(MaterialShapeDrawable.this)[i] = shapePath.createShadowCompatOperation(matrix);
        }

        @Override // com.google.android.material.shape.ShapeAppearancePathProvider.PathListener
        public void onEdgePathCreated(@NonNull ShapePath shapePath, Matrix matrix, int i) {
            MaterialShapeDrawable.access$000(MaterialShapeDrawable.this).set(i + 4, shapePath.containsIncompatibleShadowOp());
            MaterialShapeDrawable.access$200(MaterialShapeDrawable.this)[i] = shapePath.createShadowCompatOperation(matrix);
        }
    }

    public class b implements ShapeAppearanceModel.CornerSizeUnaryOperator {
        public final /* synthetic */ float a;

        public b(MaterialShapeDrawable materialShapeDrawable, float f) {
            this.a = f;
        }

        @Override // com.google.android.material.shape.ShapeAppearanceModel.CornerSizeUnaryOperator
        @NonNull
        public CornerSize apply(@NonNull CornerSize cornerSize) {
            return cornerSize instanceof RelativeCornerSize ? cornerSize : new AdjustedCornerSize(this.a, cornerSize);
        }
    }

    public /* synthetic */ MaterialShapeDrawable(c cVar, a aVar) {
        this(cVar);
    }

    public static /* synthetic */ BitSet access$000(MaterialShapeDrawable materialShapeDrawable) {
        return materialShapeDrawable.containsIncompatibleShadowOp;
    }

    public static /* synthetic */ ShapePath.d[] access$100(MaterialShapeDrawable materialShapeDrawable) {
        return materialShapeDrawable.cornerShadowOperation;
    }

    public static /* synthetic */ ShapePath.d[] access$200(MaterialShapeDrawable materialShapeDrawable) {
        return materialShapeDrawable.edgeShadowOperation;
    }

    public static /* synthetic */ boolean access$402(MaterialShapeDrawable materialShapeDrawable, boolean z2) {
        materialShapeDrawable.pathDirty = z2;
        return z2;
    }

    @Nullable
    private PorterDuffColorFilter calculatePaintColorTintFilter(@NonNull Paint paint, boolean z2) {
        int color;
        int iCompositeElevationOverlayIfNeeded;
        if (!z2 || (iCompositeElevationOverlayIfNeeded = compositeElevationOverlayIfNeeded((color = paint.getColor()))) == color) {
            return null;
        }
        return new PorterDuffColorFilter(iCompositeElevationOverlayIfNeeded, PorterDuff.Mode.SRC_IN);
    }

    private void calculatePath(@NonNull RectF rectF, @NonNull Path path) {
        calculatePathForSize(rectF, path);
        if (this.drawableState.j != 1.0f) {
            this.matrix.reset();
            Matrix matrix = this.matrix;
            float f = this.drawableState.j;
            matrix.setScale(f, f, rectF.width() / 2.0f, rectF.height() / 2.0f);
            path.transform(this.matrix);
        }
        path.computeBounds(this.pathBounds, true);
    }

    private void calculateStrokePath() {
        ShapeAppearanceModel shapeAppearanceModelWithTransformedCornerSizes = getShapeAppearanceModel().withTransformedCornerSizes(new b(this, -getStrokeInsetLength()));
        this.strokeShapeAppearance = shapeAppearanceModelWithTransformedCornerSizes;
        this.pathProvider.calculatePath(shapeAppearanceModelWithTransformedCornerSizes, this.drawableState.k, getBoundsInsetByStroke(), this.pathInsetByStroke);
    }

    @NonNull
    private PorterDuffColorFilter calculateTintColorTintFilter(@NonNull ColorStateList colorStateList, @NonNull PorterDuff.Mode mode, boolean z2) {
        int colorForState = colorStateList.getColorForState(getState(), 0);
        if (z2) {
            colorForState = compositeElevationOverlayIfNeeded(colorForState);
        }
        return new PorterDuffColorFilter(colorForState, mode);
    }

    @NonNull
    private PorterDuffColorFilter calculateTintFilter(@Nullable ColorStateList colorStateList, @Nullable PorterDuff.Mode mode, @NonNull Paint paint, boolean z2) {
        return (colorStateList == null || mode == null) ? calculatePaintColorTintFilter(paint, z2) : calculateTintColorTintFilter(colorStateList, mode, z2);
    }

    @NonNull
    public static MaterialShapeDrawable createWithElevationOverlay(Context context) {
        return createWithElevationOverlay(context, 0.0f);
    }

    private void drawCompatShadow(@NonNull Canvas canvas) {
        if (this.containsIncompatibleShadowOp.cardinality() > 0) {
            Log.w(TAG, "Compatibility shadow requested but can't be drawn for all operations in this shape.");
        }
        if (this.drawableState.f3054s != 0) {
            canvas.drawPath(this.path, this.shadowRenderer.getShadowPaint());
        }
        for (int i = 0; i < 4; i++) {
            ShapePath.d dVar = this.cornerShadowOperation[i];
            ShadowRenderer shadowRenderer = this.shadowRenderer;
            int i2 = this.drawableState.r;
            Matrix matrix = ShapePath.d.a;
            dVar.a(matrix, shadowRenderer, i2, canvas);
            this.edgeShadowOperation[i].a(matrix, this.shadowRenderer, this.drawableState.r, canvas);
        }
        if (this.shadowBitmapDrawingEnable) {
            int shadowOffsetX = getShadowOffsetX();
            int shadowOffsetY = getShadowOffsetY();
            canvas.translate(-shadowOffsetX, -shadowOffsetY);
            canvas.drawPath(this.path, clearPaint);
            canvas.translate(shadowOffsetX, shadowOffsetY);
        }
    }

    private void drawFillShape(@NonNull Canvas canvas) {
        drawShape(canvas, this.fillPaint, this.path, this.drawableState.a, getBoundsAsRectF());
    }

    private void drawStrokeShape(@NonNull Canvas canvas) {
        drawShape(canvas, this.strokePaint, this.pathInsetByStroke, this.strokeShapeAppearance, getBoundsInsetByStroke());
    }

    @NonNull
    private RectF getBoundsInsetByStroke() {
        this.insetRectF.set(getBoundsAsRectF());
        float strokeInsetLength = getStrokeInsetLength();
        this.insetRectF.inset(strokeInsetLength, strokeInsetLength);
        return this.insetRectF;
    }

    private float getStrokeInsetLength() {
        if (hasStroke()) {
            return this.strokePaint.getStrokeWidth() / 2.0f;
        }
        return 0.0f;
    }

    private boolean hasCompatShadow() {
        c cVar = this.drawableState;
        int i = cVar.q;
        return i != 1 && cVar.r > 0 && (i == 2 || requiresCompatShadow());
    }

    private boolean hasFill() {
        Paint.Style style = this.drawableState.v;
        return style == Paint.Style.FILL_AND_STROKE || style == Paint.Style.FILL;
    }

    private boolean hasStroke() {
        Paint.Style style = this.drawableState.v;
        return (style == Paint.Style.FILL_AND_STROKE || style == Paint.Style.STROKE) && this.strokePaint.getStrokeWidth() > 0.0f;
    }

    private void invalidateSelfIgnoreShape() {
        super.invalidateSelf();
    }

    private void maybeDrawCompatShadow(@NonNull Canvas canvas) {
        if (hasCompatShadow()) {
            canvas.save();
            prepareCanvasForShadow(canvas);
            if (!this.shadowBitmapDrawingEnable) {
                drawCompatShadow(canvas);
                canvas.restore();
                return;
            }
            int iWidth = (int) (this.pathBounds.width() - getBounds().width());
            int iHeight = (int) (this.pathBounds.height() - getBounds().height());
            if (iWidth < 0 || iHeight < 0) {
                throw new IllegalStateException("Invalid shadow bounds. Check that the treatments result in a valid path.");
            }
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap((this.drawableState.r * 2) + ((int) this.pathBounds.width()) + iWidth, (this.drawableState.r * 2) + ((int) this.pathBounds.height()) + iHeight, Bitmap.Config.ARGB_8888);
            Canvas canvas2 = new Canvas(bitmapCreateBitmap);
            float f = (getBounds().left - this.drawableState.r) - iWidth;
            float f2 = (getBounds().top - this.drawableState.r) - iHeight;
            canvas2.translate(-f, -f2);
            drawCompatShadow(canvas2);
            canvas.drawBitmap(bitmapCreateBitmap, f, f2, (Paint) null);
            bitmapCreateBitmap.recycle();
            canvas.restore();
        }
    }

    private static int modulateAlpha(int i, int i2) {
        return ((i2 + (i2 >>> 7)) * i) >>> 8;
    }

    private void prepareCanvasForShadow(@NonNull Canvas canvas) {
        canvas.translate(getShadowOffsetX(), getShadowOffsetY());
    }

    private boolean updateColorsForState(int[] iArr) {
        boolean z2;
        int color;
        int colorForState;
        int color2;
        int colorForState2;
        if (this.drawableState.d == null || color2 == (colorForState2 = this.drawableState.d.getColorForState(iArr, (color2 = this.fillPaint.getColor())))) {
            z2 = false;
        } else {
            this.fillPaint.setColor(colorForState2);
            z2 = true;
        }
        if (this.drawableState.e == null || color == (colorForState = this.drawableState.e.getColorForState(iArr, (color = this.strokePaint.getColor())))) {
            return z2;
        }
        this.strokePaint.setColor(colorForState);
        return true;
    }

    private boolean updateTintFilter() {
        PorterDuffColorFilter porterDuffColorFilter = this.tintFilter;
        PorterDuffColorFilter porterDuffColorFilter2 = this.strokeTintFilter;
        c cVar = this.drawableState;
        this.tintFilter = calculateTintFilter(cVar.g, cVar.h, this.fillPaint, true);
        c cVar2 = this.drawableState;
        this.strokeTintFilter = calculateTintFilter(cVar2.f, cVar2.h, this.strokePaint, false);
        c cVar3 = this.drawableState;
        if (cVar3.u) {
            this.shadowRenderer.setShadowColor(cVar3.g.getColorForState(getState(), 0));
        }
        return (ObjectsCompat.equals(porterDuffColorFilter, this.tintFilter) && ObjectsCompat.equals(porterDuffColorFilter2, this.strokeTintFilter)) ? false : true;
    }

    private void updateZ() {
        float z2 = getZ();
        this.drawableState.r = (int) Math.ceil(0.75f * z2);
        this.drawableState.f3054s = (int) Math.ceil(z2 * 0.25f);
        updateTintFilter();
        invalidateSelfIgnoreShape();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final void calculatePathForSize(@NonNull RectF rectF, @NonNull Path path) {
        ShapeAppearancePathProvider shapeAppearancePathProvider = this.pathProvider;
        c cVar = this.drawableState;
        shapeAppearancePathProvider.calculatePath(cVar.a, cVar.k, rectF, this.pathShadowListener, path);
    }

    @ColorInt
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public int compositeElevationOverlayIfNeeded(@ColorInt int i) {
        float parentAbsoluteElevation = getParentAbsoluteElevation() + getZ();
        ElevationOverlayProvider elevationOverlayProvider = this.drawableState.f3053b;
        return elevationOverlayProvider != null ? elevationOverlayProvider.compositeOverlayIfNeeded(i, parentAbsoluteElevation) : i;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        this.fillPaint.setColorFilter(this.tintFilter);
        int alpha = this.fillPaint.getAlpha();
        this.fillPaint.setAlpha(modulateAlpha(alpha, this.drawableState.m));
        this.strokePaint.setColorFilter(this.strokeTintFilter);
        this.strokePaint.setStrokeWidth(this.drawableState.l);
        int alpha2 = this.strokePaint.getAlpha();
        this.strokePaint.setAlpha(modulateAlpha(alpha2, this.drawableState.m));
        if (this.pathDirty) {
            calculateStrokePath();
            calculatePath(getBoundsAsRectF(), this.path);
            this.pathDirty = false;
        }
        maybeDrawCompatShadow(canvas);
        if (hasFill()) {
            drawFillShape(canvas);
        }
        if (hasStroke()) {
            drawStrokeShape(canvas);
        }
        this.fillPaint.setAlpha(alpha);
        this.strokePaint.setAlpha(alpha2);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void drawShape(@NonNull Canvas canvas, @NonNull Paint paint, @NonNull Path path, @NonNull RectF rectF) {
        drawShape(canvas, paint, path, this.drawableState.a, rectF);
    }

    public float getBottomLeftCornerResolvedSize() {
        return this.drawableState.a.getBottomLeftCornerSize().getCornerSize(getBoundsAsRectF());
    }

    public float getBottomRightCornerResolvedSize() {
        return this.drawableState.a.getBottomRightCornerSize().getCornerSize(getBoundsAsRectF());
    }

    @NonNull
    public RectF getBoundsAsRectF() {
        this.rectF.set(getBounds());
        return this.rectF;
    }

    @Override // android.graphics.drawable.Drawable
    @Nullable
    public Drawable.ConstantState getConstantState() {
        return this.drawableState;
    }

    public float getElevation() {
        return this.drawableState.o;
    }

    @Nullable
    public ColorStateList getFillColor() {
        return this.drawableState.d;
    }

    public float getInterpolation() {
        return this.drawableState.k;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    @TargetApi(21)
    public void getOutline(@NonNull Outline outline) {
        if (this.drawableState.q == 2) {
            return;
        }
        if (isRoundRect()) {
            outline.setRoundRect(getBounds(), getTopLeftCornerResolvedSize() * this.drawableState.k);
            return;
        }
        calculatePath(getBoundsAsRectF(), this.path);
        if (this.path.isConvex() || Build.VERSION.SDK_INT >= 29) {
            try {
                outline.setConvexPath(this.path);
            } catch (IllegalArgumentException unused) {
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean getPadding(@NonNull Rect rect) {
        Rect rect2 = this.drawableState.i;
        if (rect2 == null) {
            return super.getPadding(rect);
        }
        rect.set(rect2);
        return true;
    }

    public Paint.Style getPaintStyle() {
        return this.drawableState.v;
    }

    public float getParentAbsoluteElevation() {
        return this.drawableState.n;
    }

    @Deprecated
    public void getPathForSize(int i, int i2, @NonNull Path path) {
        calculatePathForSize(new RectF(0.0f, 0.0f, i, i2), path);
    }

    public float getScale() {
        return this.drawableState.j;
    }

    public int getShadowCompatRotation() {
        return this.drawableState.t;
    }

    public int getShadowCompatibilityMode() {
        return this.drawableState.q;
    }

    @Deprecated
    public int getShadowElevation() {
        return (int) getElevation();
    }

    public int getShadowOffsetX() {
        c cVar = this.drawableState;
        return (int) (Math.sin(Math.toRadians(cVar.t)) * cVar.f3054s);
    }

    public int getShadowOffsetY() {
        c cVar = this.drawableState;
        return (int) (Math.cos(Math.toRadians(cVar.t)) * cVar.f3054s);
    }

    public int getShadowRadius() {
        return this.drawableState.r;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public int getShadowVerticalOffset() {
        return this.drawableState.f3054s;
    }

    @Override // com.google.android.material.shape.Shapeable
    @NonNull
    public ShapeAppearanceModel getShapeAppearanceModel() {
        return this.drawableState.a;
    }

    @Nullable
    @Deprecated
    public ShapePathModel getShapedViewModel() {
        ShapeAppearanceModel shapeAppearanceModel = getShapeAppearanceModel();
        if (shapeAppearanceModel instanceof ShapePathModel) {
            return (ShapePathModel) shapeAppearanceModel;
        }
        return null;
    }

    @Nullable
    public ColorStateList getStrokeColor() {
        return this.drawableState.e;
    }

    @Nullable
    public ColorStateList getStrokeTintList() {
        return this.drawableState.f;
    }

    public float getStrokeWidth() {
        return this.drawableState.l;
    }

    @Nullable
    public ColorStateList getTintList() {
        return this.drawableState.g;
    }

    public float getTopLeftCornerResolvedSize() {
        return this.drawableState.a.getTopLeftCornerSize().getCornerSize(getBoundsAsRectF());
    }

    public float getTopRightCornerResolvedSize() {
        return this.drawableState.a.getTopRightCornerSize().getCornerSize(getBoundsAsRectF());
    }

    public float getTranslationZ() {
        return this.drawableState.p;
    }

    @Override // android.graphics.drawable.Drawable
    public Region getTransparentRegion() {
        this.transparentRegion.set(getBounds());
        calculatePath(getBoundsAsRectF(), this.path);
        this.scratchRegion.setPath(this.path, this.transparentRegion);
        this.transparentRegion.op(this.scratchRegion, Region.Op.DIFFERENCE);
        return this.transparentRegion;
    }

    public float getZ() {
        return getTranslationZ() + getElevation();
    }

    public void initializeElevationOverlay(Context context) {
        this.drawableState.f3053b = new ElevationOverlayProvider(context);
        updateZ();
    }

    @Override // android.graphics.drawable.Drawable
    public void invalidateSelf() {
        this.pathDirty = true;
        super.invalidateSelf();
    }

    public boolean isElevationOverlayEnabled() {
        ElevationOverlayProvider elevationOverlayProvider = this.drawableState.f3053b;
        return elevationOverlayProvider != null && elevationOverlayProvider.isThemeElevationOverlayEnabled();
    }

    public boolean isElevationOverlayInitialized() {
        return this.drawableState.f3053b != null;
    }

    public boolean isPointInTransparentRegion(int i, int i2) {
        return getTransparentRegion().contains(i, i2);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public boolean isRoundRect() {
        return this.drawableState.a.isRoundRect(getBoundsAsRectF());
    }

    @Deprecated
    public boolean isShadowEnabled() {
        int i = this.drawableState.q;
        return i == 0 || i == 2;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        ColorStateList colorStateList;
        ColorStateList colorStateList2;
        ColorStateList colorStateList3;
        ColorStateList colorStateList4;
        return super.isStateful() || ((colorStateList = this.drawableState.g) != null && colorStateList.isStateful()) || (((colorStateList2 = this.drawableState.f) != null && colorStateList2.isStateful()) || (((colorStateList3 = this.drawableState.e) != null && colorStateList3.isStateful()) || ((colorStateList4 = this.drawableState.d) != null && colorStateList4.isStateful())));
    }

    @Override // android.graphics.drawable.Drawable
    @NonNull
    public Drawable mutate() {
        this.drawableState = new c(this.drawableState);
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        this.pathDirty = true;
        super.onBoundsChange(rect);
    }

    @Override // android.graphics.drawable.Drawable, com.google.android.material.internal.TextDrawableHelper.TextDrawableDelegate
    public boolean onStateChange(int[] iArr) {
        boolean z2 = updateColorsForState(iArr) || updateTintFilter();
        if (z2) {
            invalidateSelf();
        }
        return z2;
    }

    public boolean requiresCompatShadow() {
        return (isRoundRect() || this.path.isConvex() || Build.VERSION.SDK_INT >= 29) ? false : true;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(@IntRange(from = 0, to = 255) int i) {
        c cVar = this.drawableState;
        if (cVar.m != i) {
            cVar.m = i;
            invalidateSelfIgnoreShape();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(@Nullable ColorFilter colorFilter) {
        this.drawableState.c = colorFilter;
        invalidateSelfIgnoreShape();
    }

    public void setCornerSize(float f) {
        setShapeAppearanceModel(this.drawableState.a.withCornerSize(f));
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setEdgeIntersectionCheckEnable(boolean z2) {
        this.pathProvider.setEdgeIntersectionCheckEnable(z2);
    }

    public void setElevation(float f) {
        c cVar = this.drawableState;
        if (cVar.o != f) {
            cVar.o = f;
            updateZ();
        }
    }

    public void setFillColor(@Nullable ColorStateList colorStateList) {
        c cVar = this.drawableState;
        if (cVar.d != colorStateList) {
            cVar.d = colorStateList;
            onStateChange(getState());
        }
    }

    public void setInterpolation(float f) {
        c cVar = this.drawableState;
        if (cVar.k != f) {
            cVar.k = f;
            this.pathDirty = true;
            invalidateSelf();
        }
    }

    public void setPadding(int i, int i2, int i3, int i4) {
        c cVar = this.drawableState;
        if (cVar.i == null) {
            cVar.i = new Rect();
        }
        this.drawableState.i.set(i, i2, i3, i4);
        invalidateSelf();
    }

    public void setPaintStyle(Paint.Style style) {
        this.drawableState.v = style;
        invalidateSelfIgnoreShape();
    }

    public void setParentAbsoluteElevation(float f) {
        c cVar = this.drawableState;
        if (cVar.n != f) {
            cVar.n = f;
            updateZ();
        }
    }

    public void setScale(float f) {
        c cVar = this.drawableState;
        if (cVar.j != f) {
            cVar.j = f;
            invalidateSelf();
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setShadowBitmapDrawingEnable(boolean z2) {
        this.shadowBitmapDrawingEnable = z2;
    }

    public void setShadowColor(int i) {
        this.shadowRenderer.setShadowColor(i);
        this.drawableState.u = false;
        invalidateSelfIgnoreShape();
    }

    public void setShadowCompatRotation(int i) {
        c cVar = this.drawableState;
        if (cVar.t != i) {
            cVar.t = i;
            invalidateSelfIgnoreShape();
        }
    }

    public void setShadowCompatibilityMode(int i) {
        c cVar = this.drawableState;
        if (cVar.q != i) {
            cVar.q = i;
            invalidateSelfIgnoreShape();
        }
    }

    @Deprecated
    public void setShadowElevation(int i) {
        setElevation(i);
    }

    @Deprecated
    public void setShadowEnabled(boolean z2) {
        setShadowCompatibilityMode(!z2 ? 1 : 0);
    }

    @Deprecated
    public void setShadowRadius(int i) {
        this.drawableState.r = i;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setShadowVerticalOffset(int i) {
        c cVar = this.drawableState;
        if (cVar.f3054s != i) {
            cVar.f3054s = i;
            invalidateSelfIgnoreShape();
        }
    }

    @Override // com.google.android.material.shape.Shapeable
    public void setShapeAppearanceModel(@NonNull ShapeAppearanceModel shapeAppearanceModel) {
        this.drawableState.a = shapeAppearanceModel;
        invalidateSelf();
    }

    @Deprecated
    public void setShapedViewModel(@NonNull ShapePathModel shapePathModel) {
        setShapeAppearanceModel(shapePathModel);
    }

    public void setStroke(float f, @ColorInt int i) {
        setStrokeWidth(f);
        setStrokeColor(ColorStateList.valueOf(i));
    }

    public void setStrokeColor(@Nullable ColorStateList colorStateList) {
        c cVar = this.drawableState;
        if (cVar.e != colorStateList) {
            cVar.e = colorStateList;
            onStateChange(getState());
        }
    }

    public void setStrokeTint(ColorStateList colorStateList) {
        this.drawableState.f = colorStateList;
        updateTintFilter();
        invalidateSelfIgnoreShape();
    }

    public void setStrokeWidth(float f) {
        this.drawableState.l = f;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable, androidx.core.graphics.drawable.TintAwareDrawable
    public void setTint(@ColorInt int i) {
        setTintList(ColorStateList.valueOf(i));
    }

    @Override // android.graphics.drawable.Drawable, androidx.core.graphics.drawable.TintAwareDrawable
    public void setTintList(@Nullable ColorStateList colorStateList) {
        this.drawableState.g = colorStateList;
        updateTintFilter();
        invalidateSelfIgnoreShape();
    }

    @Override // android.graphics.drawable.Drawable, androidx.core.graphics.drawable.TintAwareDrawable
    public void setTintMode(@Nullable PorterDuff.Mode mode) {
        c cVar = this.drawableState;
        if (cVar.h != mode) {
            cVar.h = mode;
            updateTintFilter();
            invalidateSelfIgnoreShape();
        }
    }

    public void setTranslationZ(float f) {
        c cVar = this.drawableState;
        if (cVar.p != f) {
            cVar.p = f;
            updateZ();
        }
    }

    public void setUseTintColorForShadow(boolean z2) {
        c cVar = this.drawableState;
        if (cVar.u != z2) {
            cVar.u = z2;
            invalidateSelf();
        }
    }

    public void setZ(float f) {
        setTranslationZ(f - getElevation());
    }

    public MaterialShapeDrawable() {
        this(new ShapeAppearanceModel());
    }

    @NonNull
    public static MaterialShapeDrawable createWithElevationOverlay(Context context, float f) {
        int color = MaterialColors.getColor(context, R.attr.colorSurface, MaterialShapeDrawable.class.getSimpleName());
        MaterialShapeDrawable materialShapeDrawable = new MaterialShapeDrawable();
        materialShapeDrawable.initializeElevationOverlay(context);
        materialShapeDrawable.setFillColor(ColorStateList.valueOf(color));
        materialShapeDrawable.setElevation(f);
        return materialShapeDrawable;
    }

    private void drawShape(@NonNull Canvas canvas, @NonNull Paint paint, @NonNull Path path, @NonNull ShapeAppearanceModel shapeAppearanceModel, @NonNull RectF rectF) {
        if (!shapeAppearanceModel.isRoundRect(rectF)) {
            canvas.drawPath(path, paint);
        } else {
            float cornerSize = shapeAppearanceModel.getTopRightCornerSize().getCornerSize(rectF) * this.drawableState.k;
            canvas.drawRoundRect(rectF, cornerSize, cornerSize, paint);
        }
    }

    public void setCornerSize(@NonNull CornerSize cornerSize) {
        setShapeAppearanceModel(this.drawableState.a.withCornerSize(cornerSize));
    }

    public MaterialShapeDrawable(@NonNull Context context, @Nullable AttributeSet attributeSet, @AttrRes int i, @StyleRes int i2) {
        this(ShapeAppearanceModel.builder(context, attributeSet, i, i2).build());
    }

    public void setStroke(float f, @Nullable ColorStateList colorStateList) {
        setStrokeWidth(f);
        setStrokeColor(colorStateList);
    }

    @Deprecated
    public MaterialShapeDrawable(@NonNull ShapePathModel shapePathModel) {
        this((ShapeAppearanceModel) shapePathModel);
    }

    public void setStrokeTint(@ColorInt int i) {
        setStrokeTint(ColorStateList.valueOf(i));
    }

    public MaterialShapeDrawable(@NonNull ShapeAppearanceModel shapeAppearanceModel) {
        this(new c(shapeAppearanceModel, null));
    }

    private MaterialShapeDrawable(@NonNull c cVar) {
        this.cornerShadowOperation = new ShapePath.d[4];
        this.edgeShadowOperation = new ShapePath.d[4];
        this.containsIncompatibleShadowOp = new BitSet(8);
        this.matrix = new Matrix();
        this.path = new Path();
        this.pathInsetByStroke = new Path();
        this.rectF = new RectF();
        this.insetRectF = new RectF();
        this.transparentRegion = new Region();
        this.scratchRegion = new Region();
        Paint paint = new Paint(1);
        this.fillPaint = paint;
        Paint paint2 = new Paint(1);
        this.strokePaint = paint2;
        this.shadowRenderer = new ShadowRenderer();
        this.pathProvider = Looper.getMainLooper().getThread() == Thread.currentThread() ? ShapeAppearancePathProvider.getInstance() : new ShapeAppearancePathProvider();
        this.pathBounds = new RectF();
        this.shadowBitmapDrawingEnable = true;
        this.drawableState = cVar;
        paint2.setStyle(Paint.Style.STROKE);
        paint.setStyle(Paint.Style.FILL);
        Paint paint3 = clearPaint;
        paint3.setColor(-1);
        paint3.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        updateTintFilter();
        updateColorsForState(getState());
        this.pathShadowListener = new a();
    }

    public static final class c extends Drawable.ConstantState {

        @NonNull
        public ShapeAppearanceModel a;

        /* renamed from: b, reason: collision with root package name */
        @Nullable
        public ElevationOverlayProvider f3053b;

        @Nullable
        public ColorFilter c;

        @Nullable
        public ColorStateList d;

        @Nullable
        public ColorStateList e;

        @Nullable
        public ColorStateList f;

        @Nullable
        public ColorStateList g;

        @Nullable
        public PorterDuff.Mode h;

        @Nullable
        public Rect i;
        public float j;
        public float k;
        public float l;
        public int m;
        public float n;
        public float o;
        public float p;
        public int q;
        public int r;

        /* renamed from: s, reason: collision with root package name */
        public int f3054s;
        public int t;
        public boolean u;
        public Paint.Style v;

        public c(ShapeAppearanceModel shapeAppearanceModel, ElevationOverlayProvider elevationOverlayProvider) {
            this.d = null;
            this.e = null;
            this.f = null;
            this.g = null;
            this.h = PorterDuff.Mode.SRC_IN;
            this.i = null;
            this.j = 1.0f;
            this.k = 1.0f;
            this.m = 255;
            this.n = 0.0f;
            this.o = 0.0f;
            this.p = 0.0f;
            this.q = 0;
            this.r = 0;
            this.f3054s = 0;
            this.t = 0;
            this.u = false;
            this.v = Paint.Style.FILL_AND_STROKE;
            this.a = shapeAppearanceModel;
            this.f3053b = null;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return 0;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        @NonNull
        public Drawable newDrawable() {
            MaterialShapeDrawable materialShapeDrawable = new MaterialShapeDrawable(this, null);
            MaterialShapeDrawable.access$402(materialShapeDrawable, true);
            return materialShapeDrawable;
        }

        public c(@NonNull c cVar) {
            this.d = null;
            this.e = null;
            this.f = null;
            this.g = null;
            this.h = PorterDuff.Mode.SRC_IN;
            this.i = null;
            this.j = 1.0f;
            this.k = 1.0f;
            this.m = 255;
            this.n = 0.0f;
            this.o = 0.0f;
            this.p = 0.0f;
            this.q = 0;
            this.r = 0;
            this.f3054s = 0;
            this.t = 0;
            this.u = false;
            this.v = Paint.Style.FILL_AND_STROKE;
            this.a = cVar.a;
            this.f3053b = cVar.f3053b;
            this.l = cVar.l;
            this.c = cVar.c;
            this.d = cVar.d;
            this.e = cVar.e;
            this.h = cVar.h;
            this.g = cVar.g;
            this.m = cVar.m;
            this.j = cVar.j;
            this.f3054s = cVar.f3054s;
            this.q = cVar.q;
            this.u = cVar.u;
            this.k = cVar.k;
            this.n = cVar.n;
            this.o = cVar.o;
            this.p = cVar.p;
            this.r = cVar.r;
            this.t = cVar.t;
            this.f = cVar.f;
            this.v = cVar.v;
            if (cVar.i != null) {
                this.i = new Rect(cVar.i);
            }
        }
    }
}
