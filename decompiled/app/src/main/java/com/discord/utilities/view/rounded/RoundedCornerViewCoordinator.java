package com.discord.utilities.view.rounded;

import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.StyleableRes;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: RoundedCornerViewCoordinator.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0014\n\u0002\b\u0007\b\u0000\u0018\u00002\u00020\u0001:\u0001-B\u0007¢\u0006\u0004\b+\u0010,JQ\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\b\u0001\u0010\u0007\u001a\u00020\u00062\b\b\u0001\u0010\t\u001a\u00020\b2\b\b\u0001\u0010\n\u001a\u00020\b2\b\b\u0001\u0010\u000b\u001a\u00020\b2\b\b\u0001\u0010\f\u001a\u00020\b¢\u0006\u0004\b\u000e\u0010\u000fJ)\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u00102\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\r0\u0012¢\u0006\u0004\b\u0014\u0010\u0015J\u001d\u0010\u0018\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\b¢\u0006\u0004\b\u0018\u0010\u0019J%\u0010\u001e\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u001c¢\u0006\u0004\b\u001e\u0010\u001fR\u0016\u0010 \u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b \u0010!R\u0016\u0010\"\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\"\u0010!R\u0016\u0010$\u001a\u00020#8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b$\u0010%R\u0016\u0010&\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b&\u0010!R\u0016\u0010(\u001a\u00020'8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b(\u0010)R\u0016\u0010*\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b*\u0010!¨\u0006."}, d2 = {"Lcom/discord/utilities/view/rounded/RoundedCornerViewCoordinator;", "", "Landroid/view/View;", "view", "Landroid/util/AttributeSet;", "attrs", "", "attrsIndexArray", "", "attrsIndexTopLeftRadius", "attrsIndexTopRightRadius", "attrsIndexBottomLeftRadius", "attrsIndexBottomRightRadius", "", "initialize", "(Landroid/view/View;Landroid/util/AttributeSet;[IIIII)V", "Landroid/graphics/Canvas;", "canvas", "Lkotlin/Function1;", "onDraw", "draw", "(Landroid/graphics/Canvas;Lkotlin/jvm/functions/Function1;)V", "w", "h", "onSizeChanged", "(II)V", "", "radius", "Lcom/discord/utilities/view/rounded/RoundedCornerViewCoordinator$Corner;", "corner", "updateRadius", "(Landroid/view/View;FLcom/discord/utilities/view/rounded/RoundedCornerViewCoordinator$Corner;)V", "bottomRightRadius", "F", "bottomLeftRadius", "Landroid/graphics/Path;", "path", "Landroid/graphics/Path;", "topLeftRadius", "", "radii", "[F", "topRightRadius", "<init>", "()V", "Corner", "utils_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class RoundedCornerViewCoordinator {
    private float bottomLeftRadius;
    private float bottomRightRadius;
    private Path path = new Path();
    private final float[] radii = new float[8];
    private float topLeftRadius;
    private float topRightRadius;

    /* compiled from: RoundedCornerViewCoordinator.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/discord/utilities/view/rounded/RoundedCornerViewCoordinator$Corner;", "", "<init>", "(Ljava/lang/String;I)V", "TOP_LEFT", "TOP_RIGHT", "BOTTOM_LEFT", "BOTTOM_RIGHT", "utils_release"}, k = 1, mv = {1, 4, 2})
    public enum Corner {
        TOP_LEFT,
        TOP_RIGHT,
        BOTTOM_LEFT,
        BOTTOM_RIGHT
    }

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            Corner.values();
            int[] iArr = new int[4];
            $EnumSwitchMapping$0 = iArr;
            iArr[Corner.TOP_LEFT.ordinal()] = 1;
            iArr[Corner.TOP_RIGHT.ordinal()] = 2;
            iArr[Corner.BOTTOM_LEFT.ordinal()] = 3;
            iArr[Corner.BOTTOM_RIGHT.ordinal()] = 4;
        }
    }

    public final void draw(Canvas canvas, Function1<? super Canvas, Unit> onDraw) {
        Intrinsics3.checkNotNullParameter(canvas, "canvas");
        Intrinsics3.checkNotNullParameter(onDraw, "onDraw");
        canvas.save();
        canvas.clipPath(this.path);
        onDraw.invoke(canvas);
        canvas.restore();
    }

    public final void initialize(View view, AttributeSet attrs, @StyleableRes int[] attrsIndexArray, @StyleableRes int attrsIndexTopLeftRadius, @StyleableRes int attrsIndexTopRightRadius, @StyleableRes int attrsIndexBottomLeftRadius, @StyleableRes int attrsIndexBottomRightRadius) {
        Intrinsics3.checkNotNullParameter(view, "view");
        Intrinsics3.checkNotNullParameter(attrsIndexArray, "attrsIndexArray");
        view.setWillNotDraw(false);
        TypedArray typedArrayObtainStyledAttributes = view.getContext().obtainStyledAttributes(attrs, attrsIndexArray);
        Intrinsics3.checkNotNullExpressionValue(typedArrayObtainStyledAttributes, "view.context.obtainStyle…s(attrs, attrsIndexArray)");
        try {
            this.topLeftRadius = typedArrayObtainStyledAttributes.getDimension(attrsIndexTopLeftRadius, 0.0f);
            this.topRightRadius = typedArrayObtainStyledAttributes.getDimension(attrsIndexTopRightRadius, 0.0f);
            this.bottomLeftRadius = typedArrayObtainStyledAttributes.getDimension(attrsIndexBottomLeftRadius, 0.0f);
            this.bottomRightRadius = typedArrayObtainStyledAttributes.getDimension(attrsIndexBottomRightRadius, 0.0f);
        } finally {
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    public final void onSizeChanged(int w, int h) {
        Path path = new Path();
        this.path = path;
        float[] fArr = this.radii;
        float f = this.topLeftRadius;
        fArr[0] = f;
        fArr[1] = f;
        float f2 = this.topRightRadius;
        fArr[2] = f2;
        fArr[3] = f2;
        float f3 = this.bottomRightRadius;
        fArr[4] = f3;
        fArr[5] = f3;
        float f4 = this.bottomLeftRadius;
        fArr[6] = f4;
        fArr[7] = f4;
        path.addRoundRect(new RectF(0.0f, 0.0f, w, h), this.radii, Path.Direction.CW);
        this.path.close();
    }

    public final void updateRadius(View view, float radius, Corner corner) {
        Intrinsics3.checkNotNullParameter(view, "view");
        Intrinsics3.checkNotNullParameter(corner, "corner");
        int iOrdinal = corner.ordinal();
        if (iOrdinal == 0) {
            this.topLeftRadius = radius;
        } else if (iOrdinal == 1) {
            this.topRightRadius = radius;
        } else if (iOrdinal == 2) {
            this.bottomLeftRadius = radius;
        } else if (iOrdinal == 3) {
            this.bottomRightRadius = radius;
        }
        view.invalidate();
    }
}
