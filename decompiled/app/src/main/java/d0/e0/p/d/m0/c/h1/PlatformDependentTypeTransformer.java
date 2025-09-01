package d0.e0.p.d.m0.c.h1;

import d0.e0.p.d.m0.g.ClassId;
import d0.e0.p.d.m0.n.KotlinType4;
import d0.z.d.Intrinsics3;

/* compiled from: PlatformDependentTypeTransformer.kt */
/* renamed from: d0.e0.p.d.m0.c.h1.e, reason: use source file name */
/* loaded from: classes3.dex */
public interface PlatformDependentTypeTransformer {

    /* compiled from: PlatformDependentTypeTransformer.kt */
    /* renamed from: d0.e0.p.d.m0.c.h1.e$a */
    public static final class a implements PlatformDependentTypeTransformer {
        public static final a a = new a();

        @Override // d0.e0.p.d.m0.c.h1.PlatformDependentTypeTransformer
        public KotlinType4 transformPlatformType(ClassId classId, KotlinType4 kotlinType4) {
            Intrinsics3.checkNotNullParameter(classId, "classId");
            Intrinsics3.checkNotNullParameter(kotlinType4, "computedType");
            return kotlinType4;
        }
    }

    KotlinType4 transformPlatformType(ClassId classId, KotlinType4 kotlinType4);
}
