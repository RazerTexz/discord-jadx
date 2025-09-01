package d0.e0.p.d.m0.n;

import d0.e0.p.d.m0.n.l1.KotlinTypeRefiner;

/* compiled from: TypeProjection.java */
/* renamed from: d0.e0.p.d.m0.n.w0, reason: use source file name */
/* loaded from: classes3.dex */
public interface TypeProjection extends d0.e0.p.d.m0.n.n1.k {
    Variance getProjectionKind();

    KotlinType getType();

    boolean isStarProjection();

    TypeProjection refine(KotlinTypeRefiner kotlinTypeRefiner);
}
