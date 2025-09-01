package b.i.a.g.i;

import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.tabs.TabLayout;

/* compiled from: ElasticTabIndicatorInterpolator.java */
/* renamed from: b.i.a.g.i.a, reason: use source file name */
/* loaded from: classes3.dex */
public class ElasticTabIndicatorInterpolator extends TabIndicatorInterpolator {
    public static float c(@FloatRange(from = 0.0d, to = 1.0d) float f) {
        return (float) (1.0d - Math.cos((f * 3.141592653589793d) / 2.0d));
    }

    @Override // b.i.a.g.i.TabIndicatorInterpolator
    public void b(TabLayout tabLayout, View view, View view2, float f, @NonNull Drawable drawable) {
        float fSin;
        float fC;
        RectF rectFA = TabIndicatorInterpolator.a(tabLayout, view);
        RectF rectFA2 = TabIndicatorInterpolator.a(tabLayout, view2);
        if (rectFA.left < rectFA2.left) {
            fSin = c(f);
            fC = (float) Math.sin((f * 3.141592653589793d) / 2.0d);
        } else {
            fSin = (float) Math.sin((f * 3.141592653589793d) / 2.0d);
            fC = c(f);
        }
        drawable.setBounds(AnimationUtils.lerp((int) rectFA.left, (int) rectFA2.left, fSin), drawable.getBounds().top, AnimationUtils.lerp((int) rectFA.right, (int) rectFA2.right, fC), drawable.getBounds().bottom);
    }
}
