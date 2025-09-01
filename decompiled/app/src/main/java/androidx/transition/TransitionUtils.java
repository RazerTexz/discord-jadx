package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.TypeEvaluator;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Picture;
import android.graphics.RectF;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure;

/* loaded from: classes.dex */
public class TransitionUtils {
    private static final boolean HAS_IS_ATTACHED_TO_WINDOW;
    private static final boolean HAS_OVERLAY;
    private static final boolean HAS_PICTURE_BITMAP;
    private static final int MAX_IMAGE_SIZE = 1048576;

    public static class MatrixEvaluator implements TypeEvaluator<Matrix> {
        public final float[] mTempStartValues = new float[9];
        public final float[] mTempEndValues = new float[9];
        public final Matrix mTempMatrix = new Matrix();

        @Override // android.animation.TypeEvaluator
        public /* bridge */ /* synthetic */ Matrix evaluate(float f, Matrix matrix, Matrix matrix2) {
            return evaluate2(f, matrix, matrix2);
        }

        /* renamed from: evaluate, reason: avoid collision after fix types in other method */
        public Matrix evaluate2(float f, Matrix matrix, Matrix matrix2) {
            matrix.getValues(this.mTempStartValues);
            matrix2.getValues(this.mTempEndValues);
            for (int i = 0; i < 9; i++) {
                float[] fArr = this.mTempEndValues;
                float f2 = fArr[i];
                float[] fArr2 = this.mTempStartValues;
                fArr[i] = ((f2 - fArr2[i]) * f) + fArr2[i];
            }
            this.mTempMatrix.setValues(this.mTempEndValues);
            return this.mTempMatrix;
        }
    }

    static {
        int i = Build.VERSION.SDK_INT;
        HAS_IS_ATTACHED_TO_WINDOW = true;
        HAS_OVERLAY = true;
        HAS_PICTURE_BITMAP = i >= 28;
    }

    private TransitionUtils() {
    }

    public static View copyViewImage(ViewGroup viewGroup, View view, View view2) {
        Matrix matrix = new Matrix();
        matrix.setTranslate(-view2.getScrollX(), -view2.getScrollY());
        ViewUtils.transformMatrixToGlobal(view, matrix);
        ViewUtils.transformMatrixToLocal(viewGroup, matrix);
        RectF rectF = new RectF(0.0f, 0.0f, view.getWidth(), view.getHeight());
        matrix.mapRect(rectF);
        int iRound = Math.round(rectF.left);
        int iRound2 = Math.round(rectF.top);
        int iRound3 = Math.round(rectF.right);
        int iRound4 = Math.round(rectF.bottom);
        ImageView imageView = new ImageView(view.getContext());
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        Bitmap bitmapCreateViewBitmap = createViewBitmap(view, matrix, rectF, viewGroup);
        if (bitmapCreateViewBitmap != null) {
            imageView.setImageBitmap(bitmapCreateViewBitmap);
        }
        imageView.measure(View.MeasureSpec.makeMeasureSpec(iRound3 - iRound, BasicMeasure.EXACTLY), View.MeasureSpec.makeMeasureSpec(iRound4 - iRound2, BasicMeasure.EXACTLY));
        imageView.layout(iRound, iRound2, iRound3, iRound4);
        return imageView;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0088  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static Bitmap createViewBitmap(View view, Matrix matrix, RectF rectF, ViewGroup viewGroup) {
        boolean z2;
        boolean zIsAttachedToWindow;
        boolean z3;
        ViewGroup viewGroup2;
        int iIndexOfChild;
        int iRound;
        int iRound2;
        if (HAS_IS_ATTACHED_TO_WINDOW) {
            z2 = !view.isAttachedToWindow();
            if (viewGroup != null) {
                zIsAttachedToWindow = viewGroup.isAttachedToWindow();
            }
            z3 = HAS_OVERLAY;
            Bitmap bitmapCreateBitmap = null;
            if (z3 || !z2) {
                viewGroup2 = null;
                iIndexOfChild = 0;
            } else {
                if (!zIsAttachedToWindow) {
                    return null;
                }
                viewGroup2 = (ViewGroup) view.getParent();
                iIndexOfChild = viewGroup2.indexOfChild(view);
                viewGroup.getOverlay().add(view);
            }
            iRound = Math.round(rectF.width());
            iRound2 = Math.round(rectF.height());
            if (iRound > 0 && iRound2 > 0) {
                float fMin = Math.min(1.0f, 1048576.0f / (iRound * iRound2));
                int iRound3 = Math.round(iRound * fMin);
                int iRound4 = Math.round(iRound2 * fMin);
                matrix.postTranslate(-rectF.left, -rectF.top);
                matrix.postScale(fMin, fMin);
                if (HAS_PICTURE_BITMAP) {
                    bitmapCreateBitmap = Bitmap.createBitmap(iRound3, iRound4, Bitmap.Config.ARGB_8888);
                    Canvas canvas = new Canvas(bitmapCreateBitmap);
                    canvas.concat(matrix);
                    view.draw(canvas);
                } else {
                    Picture picture = new Picture();
                    Canvas canvasBeginRecording = picture.beginRecording(iRound3, iRound4);
                    canvasBeginRecording.concat(matrix);
                    view.draw(canvasBeginRecording);
                    picture.endRecording();
                    bitmapCreateBitmap = Bitmap.createBitmap(picture);
                }
            }
            if (z3 && z2) {
                viewGroup.getOverlay().remove(view);
                viewGroup2.addView(view, iIndexOfChild);
            }
            return bitmapCreateBitmap;
        }
        z2 = false;
        zIsAttachedToWindow = false;
        z3 = HAS_OVERLAY;
        Bitmap bitmapCreateBitmap2 = null;
        if (z3) {
            viewGroup2 = null;
            iIndexOfChild = 0;
        }
        iRound = Math.round(rectF.width());
        iRound2 = Math.round(rectF.height());
        if (iRound > 0) {
            float fMin2 = Math.min(1.0f, 1048576.0f / (iRound * iRound2));
            int iRound32 = Math.round(iRound * fMin2);
            int iRound42 = Math.round(iRound2 * fMin2);
            matrix.postTranslate(-rectF.left, -rectF.top);
            matrix.postScale(fMin2, fMin2);
            if (HAS_PICTURE_BITMAP) {
            }
        }
        if (z3) {
            viewGroup.getOverlay().remove(view);
            viewGroup2.addView(view, iIndexOfChild);
        }
        return bitmapCreateBitmap2;
    }

    public static Animator mergeAnimators(Animator animator, Animator animator2) {
        if (animator == null) {
            return animator2;
        }
        if (animator2 == null) {
            return animator;
        }
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(animator, animator2);
        return animatorSet;
    }
}
