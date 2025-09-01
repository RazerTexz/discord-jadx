package d0.e0.p.d.m0.e.a.i0;

/* compiled from: context.kt */
/* renamed from: d0.e0.p.d.m0.e.a.i0.c, reason: use source file name */
/* loaded from: classes3.dex */
public interface context3 {

    /* compiled from: context.kt */
    /* renamed from: d0.e0.p.d.m0.e.a.i0.c$a */
    public static final class a implements context3 {
        public static final a a = new a();

        @Override // d0.e0.p.d.m0.e.a.i0.context3
        public boolean getCorrectNullabilityForNotNullTypeParameter() {
            return false;
        }

        @Override // d0.e0.p.d.m0.e.a.i0.context3
        public boolean getTypeEnhancementImprovements() {
            return false;
        }

        @Override // d0.e0.p.d.m0.e.a.i0.context3
        public boolean isReleaseCoroutines() {
            return false;
        }
    }

    boolean getCorrectNullabilityForNotNullTypeParameter();

    boolean getTypeEnhancementImprovements();

    boolean isReleaseCoroutines();
}
