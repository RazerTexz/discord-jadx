package androidx.core.graphics;

import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: Matrix.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0014\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\r\u001a\u001c\u0010\u0002\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\u0086\n¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0014\u0010\u0005\u001a\u00020\u0004*\u00020\u0000H\u0086\b¢\u0006\u0004\b\u0005\u0010\u0006\u001a!\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u0007¢\u0006\u0004\b\n\u0010\u000b\u001a!\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\f\u001a\u00020\u00072\b\b\u0002\u0010\r\u001a\u00020\u0007¢\u0006\u0004\b\u000e\u0010\u000b\u001a)\u0010\u0012\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u00072\b\b\u0002\u0010\u0010\u001a\u00020\u00072\b\b\u0002\u0010\u0011\u001a\u00020\u0007¢\u0006\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Landroid/graphics/Matrix;", "m", "times", "(Landroid/graphics/Matrix;Landroid/graphics/Matrix;)Landroid/graphics/Matrix;", "", "values", "(Landroid/graphics/Matrix;)[F", "", "tx", "ty", "translationMatrix", "(FF)Landroid/graphics/Matrix;", "sx", "sy", "scaleMatrix", "degrees", "px", "py", "rotationMatrix", "(FFF)Landroid/graphics/Matrix;", "core-ktx_release"}, k = 2, mv = {1, 5, 1})
/* renamed from: androidx.core.graphics.MatrixKt, reason: use source file name */
/* loaded from: classes.dex */
public final class Matrix {
    public static final android.graphics.Matrix rotationMatrix(float f, float f2, float f3) {
        android.graphics.Matrix matrix = new android.graphics.Matrix();
        matrix.setRotate(f, f2, f3);
        return matrix;
    }

    public static /* synthetic */ android.graphics.Matrix rotationMatrix$default(float f, float f2, float f3, int i, Object obj) {
        if ((i & 2) != 0) {
            f2 = 0.0f;
        }
        if ((i & 4) != 0) {
            f3 = 0.0f;
        }
        return rotationMatrix(f, f2, f3);
    }

    public static final android.graphics.Matrix scaleMatrix(float f, float f2) {
        android.graphics.Matrix matrix = new android.graphics.Matrix();
        matrix.setScale(f, f2);
        return matrix;
    }

    public static /* synthetic */ android.graphics.Matrix scaleMatrix$default(float f, float f2, int i, Object obj) {
        if ((i & 1) != 0) {
            f = 1.0f;
        }
        if ((i & 2) != 0) {
            f2 = 1.0f;
        }
        return scaleMatrix(f, f2);
    }

    public static final android.graphics.Matrix times(android.graphics.Matrix matrix, android.graphics.Matrix matrix2) {
        Intrinsics3.checkNotNullParameter(matrix, "<this>");
        Intrinsics3.checkNotNullParameter(matrix2, "m");
        android.graphics.Matrix matrix3 = new android.graphics.Matrix(matrix);
        matrix3.preConcat(matrix2);
        return matrix3;
    }

    public static final android.graphics.Matrix translationMatrix(float f, float f2) {
        android.graphics.Matrix matrix = new android.graphics.Matrix();
        matrix.setTranslate(f, f2);
        return matrix;
    }

    public static /* synthetic */ android.graphics.Matrix translationMatrix$default(float f, float f2, int i, Object obj) {
        if ((i & 1) != 0) {
            f = 0.0f;
        }
        if ((i & 2) != 0) {
            f2 = 0.0f;
        }
        return translationMatrix(f, f2);
    }

    public static final float[] values(android.graphics.Matrix matrix) {
        Intrinsics3.checkNotNullParameter(matrix, "<this>");
        float[] fArr = new float[9];
        matrix.getValues(fArr);
        return fArr;
    }
}
