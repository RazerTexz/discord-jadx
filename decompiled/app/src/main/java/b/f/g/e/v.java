package b.f.g.e;

import android.graphics.Matrix;
import android.graphics.Rect;
import com.facebook.drawee.drawable.ScalingUtils$ScaleType;

/* compiled from: ScalingUtils.java */
/* loaded from: classes.dex */
public class v extends q {
    public static final ScalingUtils$ScaleType l = new v();

    @Override // b.f.g.e.q
    public void b(Matrix matrix, Rect rect, int i, int i2, float f, float f2, float f3, float f4) {
        float fMin = Math.min(f3, f4);
        float fWidth = ((rect.width() - (i * fMin)) * 0.5f) + rect.left;
        float fHeight = ((rect.height() - (i2 * fMin)) * 0.5f) + rect.top;
        matrix.setScale(fMin, fMin);
        matrix.postTranslate((int) (fWidth + 0.5f), (int) (fHeight + 0.5f));
    }

    public String toString() {
        return "fit_center";
    }
}
