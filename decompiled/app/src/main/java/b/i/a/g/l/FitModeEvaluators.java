package b.i.a.g.l;

import android.graphics.RectF;

/* compiled from: FitModeEvaluators.java */
/* renamed from: b.i.a.g.l.e, reason: use source file name */
/* loaded from: classes3.dex */
public class FitModeEvaluators {
    public static final FitModeEvaluator a = new a();

    /* renamed from: b, reason: collision with root package name */
    public static final FitModeEvaluator f1633b = new b();

    /* compiled from: FitModeEvaluators.java */
    /* renamed from: b.i.a.g.l.e$a */
    public static class a implements FitModeEvaluator {
        @Override // b.i.a.g.l.FitModeEvaluator
        public FitModeResult a(float f, float f2, float f3, float f4, float f5, float f6, float f7) {
            float f8 = TransitionUtils3.f(f4, f6, f2, f3, f, true);
            float f9 = f8 / f4;
            float f10 = f8 / f6;
            return new FitModeResult(f9, f10, f8, f5 * f9, f8, f7 * f10);
        }

        @Override // b.i.a.g.l.FitModeEvaluator
        public boolean b(FitModeResult fitModeResult) {
            return fitModeResult.d > fitModeResult.f;
        }

        @Override // b.i.a.g.l.FitModeEvaluator
        public void c(RectF rectF, float f, FitModeResult fitModeResult) {
            rectF.bottom -= Math.abs(fitModeResult.f - fitModeResult.d) * f;
        }
    }

    /* compiled from: FitModeEvaluators.java */
    /* renamed from: b.i.a.g.l.e$b */
    public static class b implements FitModeEvaluator {
        @Override // b.i.a.g.l.FitModeEvaluator
        public FitModeResult a(float f, float f2, float f3, float f4, float f5, float f6, float f7) {
            float f8 = TransitionUtils3.f(f5, f7, f2, f3, f, true);
            float f9 = f8 / f5;
            float f10 = f8 / f7;
            return new FitModeResult(f9, f10, f4 * f9, f8, f6 * f10, f8);
        }

        @Override // b.i.a.g.l.FitModeEvaluator
        public boolean b(FitModeResult fitModeResult) {
            return fitModeResult.c > fitModeResult.e;
        }

        @Override // b.i.a.g.l.FitModeEvaluator
        public void c(RectF rectF, float f, FitModeResult fitModeResult) {
            float fAbs = (Math.abs(fitModeResult.e - fitModeResult.c) / 2.0f) * f;
            rectF.left += fAbs;
            rectF.right -= fAbs;
        }
    }
}
