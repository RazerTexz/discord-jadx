package d0.e0.p.d.m0.n.l1;

import d0.e0.p.d.m0.n.KotlinType;
import d0.e0.p.d.m0.n.TypeConstructor;

/* compiled from: KotlinTypeChecker.java */
/* renamed from: d0.e0.p.d.m0.n.l1.f, reason: use source file name */
/* loaded from: classes3.dex */
public interface KotlinTypeChecker {
    public static final KotlinTypeChecker a = NewKotlinTypeChecker.f3529b.getDefault();

    /* compiled from: KotlinTypeChecker.java */
    /* renamed from: d0.e0.p.d.m0.n.l1.f$a */
    public interface a {
        boolean equals(TypeConstructor typeConstructor, TypeConstructor typeConstructor2);
    }

    boolean equalTypes(KotlinType kotlinType, KotlinType kotlinType2);

    boolean isSubtypeOf(KotlinType kotlinType, KotlinType kotlinType2);
}
