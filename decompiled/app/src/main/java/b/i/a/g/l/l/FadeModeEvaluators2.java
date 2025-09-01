package b.i.a.g.l.l;

import androidx.annotation.RequiresApi;
import b.d.b.a.outline;

/* compiled from: FadeModeEvaluators.java */
@RequiresApi(21)
/* renamed from: b.i.a.g.l.l.b, reason: use source file name */
/* loaded from: classes3.dex */
public class FadeModeEvaluators2 {
    public static final FadeModeEvaluator2 a = new a();

    /* renamed from: b, reason: collision with root package name */
    public static final FadeModeEvaluator2 f1636b = new b();
    public static final FadeModeEvaluator2 c = new c();
    public static final FadeModeEvaluator2 d = new d();

    /* compiled from: FadeModeEvaluators.java */
    /* renamed from: b.i.a.g.l.l.b$a */
    public static class a implements FadeModeEvaluator2 {
        @Override // b.i.a.g.l.l.FadeModeEvaluator2
        public FadeModeResult2 a(float f, float f2, float f3) {
            return new FadeModeResult2(255, TransitionUtils5.g(0, 255, f2, f3, f), true);
        }
    }

    /* compiled from: FadeModeEvaluators.java */
    /* renamed from: b.i.a.g.l.l.b$b */
    public static class b implements FadeModeEvaluator2 {
        @Override // b.i.a.g.l.l.FadeModeEvaluator2
        public FadeModeResult2 a(float f, float f2, float f3) {
            return FadeModeResult2.a(TransitionUtils5.g(255, 0, f2, f3, f), 255);
        }
    }

    /* compiled from: FadeModeEvaluators.java */
    /* renamed from: b.i.a.g.l.l.b$c */
    public static class c implements FadeModeEvaluator2 {
        @Override // b.i.a.g.l.l.FadeModeEvaluator2
        public FadeModeResult2 a(float f, float f2, float f3) {
            return FadeModeResult2.a(TransitionUtils5.g(255, 0, f2, f3, f), TransitionUtils5.g(0, 255, f2, f3, f));
        }
    }

    /* compiled from: FadeModeEvaluators.java */
    /* renamed from: b.i.a.g.l.l.b$d */
    public static class d implements FadeModeEvaluator2 {
        @Override // b.i.a.g.l.l.FadeModeEvaluator2
        public FadeModeResult2 a(float f, float f2, float f3) {
            float fA = outline.a(f3, f2, 0.35f, f2);
            return FadeModeResult2.a(TransitionUtils5.g(255, 0, f2, fA, f), TransitionUtils5.g(0, 255, fA, f3, f));
        }
    }
}
