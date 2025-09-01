package d0.c0;

import d0.z.d.Intrinsics3;
import java.util.Random;

/* compiled from: PlatformRandom.kt */
/* renamed from: d0.c0.b, reason: use source file name */
/* loaded from: classes3.dex */
public final class PlatformRandom2 extends PlatformRandom {
    public final a l = new a();

    /* compiled from: PlatformRandom.kt */
    /* renamed from: d0.c0.b$a */
    public static final class a extends ThreadLocal<Random> {
        @Override // java.lang.ThreadLocal
        public Random initialValue() {
            return new Random();
        }
    }

    @Override // d0.c0.PlatformRandom
    public Random getImpl() {
        Random random = this.l.get();
        Intrinsics3.checkNotNullExpressionValue(random, "implStorage.get()");
        return random;
    }
}
