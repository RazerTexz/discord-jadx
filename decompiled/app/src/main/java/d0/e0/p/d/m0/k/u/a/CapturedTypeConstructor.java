package d0.e0.p.d.m0.k.u.a;

import b.d.b.a.outline;
import d0.e0.p.d.m0.c.g1.Annotations4;
import d0.e0.p.d.m0.k.a0.MemberScope3;
import d0.e0.p.d.m0.n.ErrorUtils;
import d0.e0.p.d.m0.n.KotlinType;
import d0.e0.p.d.m0.n.KotlinType3;
import d0.e0.p.d.m0.n.KotlinType4;
import d0.e0.p.d.m0.n.TypeConstructor;
import d0.e0.p.d.m0.n.TypeProjection;
import d0.e0.p.d.m0.n.l1.KotlinTypeRefiner;
import d0.t.Collections2;
import d0.z.d.Intrinsics3;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: CapturedTypeConstructor.kt */
/* renamed from: d0.e0.p.d.m0.k.u.a.a, reason: use source file name */
/* loaded from: classes3.dex */
public final class CapturedTypeConstructor extends KotlinType4 implements d0.e0.p.d.m0.n.n1.c {
    public final TypeProjection k;
    public final CapturedTypeConstructor2 l;
    public final boolean m;
    public final Annotations4 n;

    public /* synthetic */ CapturedTypeConstructor(TypeProjection typeProjection, CapturedTypeConstructor2 capturedTypeConstructor2, boolean z2, Annotations4 annotations4, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(typeProjection, (i & 2) != 0 ? new CapturedTypeConstructor3(typeProjection) : capturedTypeConstructor2, (i & 4) != 0 ? false : z2, (i & 8) != 0 ? Annotations4.f.getEMPTY() : annotations4);
    }

    @Override // d0.e0.p.d.m0.c.g1.Annotations3
    public Annotations4 getAnnotations() {
        return this.n;
    }

    @Override // d0.e0.p.d.m0.n.KotlinType
    public List<TypeProjection> getArguments() {
        return Collections2.emptyList();
    }

    @Override // d0.e0.p.d.m0.n.KotlinType
    public /* bridge */ /* synthetic */ TypeConstructor getConstructor() {
        return getConstructor();
    }

    @Override // d0.e0.p.d.m0.n.KotlinType
    public MemberScope3 getMemberScope() {
        MemberScope3 memberScope3CreateErrorScope = ErrorUtils.createErrorScope("No member resolution should be done on captured type, it used only during constraint system resolution", true);
        Intrinsics3.checkNotNullExpressionValue(memberScope3CreateErrorScope, "createErrorScope(\n            \"No member resolution should be done on captured type, it used only during constraint system resolution\", true\n        )");
        return memberScope3CreateErrorScope;
    }

    @Override // d0.e0.p.d.m0.n.KotlinType
    public boolean isMarkedNullable() {
        return this.m;
    }

    @Override // d0.e0.p.d.m0.n.KotlinType4, d0.e0.p.d.m0.n.KotlinType3
    public /* bridge */ /* synthetic */ KotlinType4 makeNullableAsSpecified(boolean z2) {
        return makeNullableAsSpecified(z2);
    }

    @Override // d0.e0.p.d.m0.n.KotlinType
    public /* bridge */ /* synthetic */ KotlinType refine(KotlinTypeRefiner kotlinTypeRefiner) {
        return refine(kotlinTypeRefiner);
    }

    @Override // d0.e0.p.d.m0.n.KotlinType4, d0.e0.p.d.m0.n.KotlinType3
    public /* bridge */ /* synthetic */ KotlinType4 replaceAnnotations(Annotations4 annotations4) {
        return replaceAnnotations(annotations4);
    }

    @Override // d0.e0.p.d.m0.n.KotlinType4
    public String toString() {
        StringBuilder sbU = outline.U("Captured(");
        sbU.append(this.k);
        sbU.append(')');
        sbU.append(isMarkedNullable() ? "?" : "");
        return sbU.toString();
    }

    @Override // d0.e0.p.d.m0.n.KotlinType
    public CapturedTypeConstructor2 getConstructor() {
        return this.l;
    }

    @Override // d0.e0.p.d.m0.n.KotlinType3
    public /* bridge */ /* synthetic */ KotlinType3 makeNullableAsSpecified(boolean z2) {
        return makeNullableAsSpecified(z2);
    }

    @Override // d0.e0.p.d.m0.n.KotlinType3, d0.e0.p.d.m0.n.KotlinType
    public /* bridge */ /* synthetic */ KotlinType3 refine(KotlinTypeRefiner kotlinTypeRefiner) {
        return refine(kotlinTypeRefiner);
    }

    @Override // d0.e0.p.d.m0.n.KotlinType3
    public /* bridge */ /* synthetic */ KotlinType3 replaceAnnotations(Annotations4 annotations4) {
        return replaceAnnotations(annotations4);
    }

    @Override // d0.e0.p.d.m0.n.KotlinType4, d0.e0.p.d.m0.n.KotlinType3
    public CapturedTypeConstructor makeNullableAsSpecified(boolean z2) {
        return z2 == isMarkedNullable() ? this : new CapturedTypeConstructor(this.k, getConstructor(), z2, getAnnotations());
    }

    @Override // d0.e0.p.d.m0.n.KotlinType3, d0.e0.p.d.m0.n.KotlinType
    public CapturedTypeConstructor refine(KotlinTypeRefiner kotlinTypeRefiner) {
        Intrinsics3.checkNotNullParameter(kotlinTypeRefiner, "kotlinTypeRefiner");
        TypeProjection typeProjectionRefine = this.k.refine(kotlinTypeRefiner);
        Intrinsics3.checkNotNullExpressionValue(typeProjectionRefine, "typeProjection.refine(kotlinTypeRefiner)");
        return new CapturedTypeConstructor(typeProjectionRefine, getConstructor(), isMarkedNullable(), getAnnotations());
    }

    @Override // d0.e0.p.d.m0.n.KotlinType4, d0.e0.p.d.m0.n.KotlinType3
    public CapturedTypeConstructor replaceAnnotations(Annotations4 annotations4) {
        Intrinsics3.checkNotNullParameter(annotations4, "newAnnotations");
        return new CapturedTypeConstructor(this.k, getConstructor(), isMarkedNullable(), annotations4);
    }

    public CapturedTypeConstructor(TypeProjection typeProjection, CapturedTypeConstructor2 capturedTypeConstructor2, boolean z2, Annotations4 annotations4) {
        Intrinsics3.checkNotNullParameter(typeProjection, "typeProjection");
        Intrinsics3.checkNotNullParameter(capturedTypeConstructor2, "constructor");
        Intrinsics3.checkNotNullParameter(annotations4, "annotations");
        this.k = typeProjection;
        this.l = capturedTypeConstructor2;
        this.m = z2;
        this.n = annotations4;
    }
}
