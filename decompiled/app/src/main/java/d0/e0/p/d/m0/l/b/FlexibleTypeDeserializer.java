package d0.e0.p.d.m0.l.b;

import d0.e0.p.d.m0.n.KotlinType;
import d0.e0.p.d.m0.n.KotlinType4;
import d0.z.d.Intrinsics3;

/* compiled from: FlexibleTypeDeserializer.kt */
/* renamed from: d0.e0.p.d.m0.l.b.q, reason: use source file name */
/* loaded from: classes3.dex */
public interface FlexibleTypeDeserializer {

    /* compiled from: FlexibleTypeDeserializer.kt */
    /* renamed from: d0.e0.p.d.m0.l.b.q$a */
    public static final class a implements FlexibleTypeDeserializer {
        public static final a a = new a();

        @Override // d0.e0.p.d.m0.l.b.FlexibleTypeDeserializer
        public KotlinType create(d0.e0.p.d.m0.f.q qVar, String str, KotlinType4 kotlinType4, KotlinType4 kotlinType42) {
            Intrinsics3.checkNotNullParameter(qVar, "proto");
            Intrinsics3.checkNotNullParameter(str, "flexibleId");
            Intrinsics3.checkNotNullParameter(kotlinType4, "lowerBound");
            Intrinsics3.checkNotNullParameter(kotlinType42, "upperBound");
            throw new IllegalArgumentException("This method should not be used.");
        }
    }

    KotlinType create(d0.e0.p.d.m0.f.q qVar, String str, KotlinType4 kotlinType4, KotlinType4 kotlinType42);
}
