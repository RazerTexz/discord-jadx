package b.i.a.g.l.l;

import android.graphics.RectF;
import androidx.annotation.NonNull;
import com.google.android.material.shape.CornerSize;
import com.google.android.material.shape.RelativeCornerSize;
import com.google.android.material.shape.ShapeAppearanceModel;

/* compiled from: TransitionUtils.java */
/* renamed from: b.i.a.g.l.l.j, reason: use source file name */
/* loaded from: classes3.dex */
public final class TransitionUtils4 implements ShapeAppearanceModel.CornerSizeUnaryOperator {
    public final /* synthetic */ RectF a;

    public TransitionUtils4(RectF rectF) {
        this.a = rectF;
    }

    @Override // com.google.android.material.shape.ShapeAppearanceModel.CornerSizeUnaryOperator
    @NonNull
    public CornerSize apply(@NonNull CornerSize cornerSize) {
        return cornerSize instanceof RelativeCornerSize ? cornerSize : new RelativeCornerSize(cornerSize.getCornerSize(this.a) / this.a.height());
    }
}
