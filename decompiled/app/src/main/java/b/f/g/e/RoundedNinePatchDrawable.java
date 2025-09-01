package b.f.g.e;

import android.graphics.Canvas;
import android.graphics.drawable.NinePatchDrawable;
import b.f.j.r.FrescoSystrace;

/* compiled from: RoundedNinePatchDrawable.java */
/* renamed from: b.f.g.e.o, reason: use source file name */
/* loaded from: classes.dex */
public class RoundedNinePatchDrawable extends RoundedDrawable {
    public RoundedNinePatchDrawable(NinePatchDrawable ninePatchDrawable) {
        super(ninePatchDrawable);
    }

    @Override // b.f.g.e.RoundedDrawable, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        FrescoSystrace.b();
        if (!d()) {
            super.draw(canvas);
            FrescoSystrace.b();
            return;
        }
        h();
        g();
        canvas.clipPath(this.n);
        super.draw(canvas);
        FrescoSystrace.b();
    }
}
