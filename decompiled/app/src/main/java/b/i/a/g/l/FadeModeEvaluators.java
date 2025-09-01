package b.i.a.g.l;

import b.d.b.a.outline;

/* compiled from: FadeModeEvaluators.java */
/* renamed from: b.i.a.g.l.b, reason: use source file name */
/* loaded from: classes3.dex */
public class FadeModeEvaluators {
    public static final FadeModeEvaluator a = new a();

    /* renamed from: b, reason: collision with root package name */
    public static final FadeModeEvaluator f1631b = new b();
    public static final FadeModeEvaluator c = new c();
    public static final FadeModeEvaluator d = new d();

    /* compiled from: FadeModeEvaluators.java */
    /* renamed from: b.i.a.g.l.b$a */
    public static class a implements FadeModeEvaluator {
        @Override // b.i.a.g.l.FadeModeEvaluator
        public FadeModeResult a(float f, float f2, float f3) {
            return new FadeModeResult(255, TransitionUtils3.g(0, 255, f2, f3, f), true);
        }
    }

    /* compiled from: FadeModeEvaluators.java */
    /* renamed from: b.i.a.g.l.b$b */
    public static class b implements FadeModeEvaluator {
        @Override // b.i.a.g.l.FadeModeEvaluator
        public FadeModeResult a(float f, float f2, float f3) {
            return FadeModeResult.a(TransitionUtils3.g(255, 0, f2, f3, f), 255);
        }
    }

    /* compiled from: FadeModeEvaluators.java */
    /* renamed from: b.i.a.g.l.b$c */
    public static class c implements FadeModeEvaluator {
        @Override // b.i.a.g.l.FadeModeEvaluator
        public FadeModeResult a(float f, float f2, float f3) {
            return FadeModeResult.a(TransitionUtils3.g(255, 0, f2, f3, f), TransitionUtils3.g(0, 255, f2, f3, f));
        }
    }

    /* compiled from: FadeModeEvaluators.java */
    /* renamed from: b.i.a.g.l.b$d */
    public static class d implements FadeModeEvaluator {
        @Override // b.i.a.g.l.FadeModeEvaluator
        public FadeModeResult a(float f, float f2, float f3) {
            float fA = outline.a(f3, f2, 0.35f, f2);
            return FadeModeResult.a(TransitionUtils3.g(255, 0, f2, fA, f), TransitionUtils3.g(0, 255, fA, f3, f));
        }
    }
}
