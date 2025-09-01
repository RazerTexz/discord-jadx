package d0.e0.p.d.m0.n;

import d0.e0.p.d.m0.c.g1.Annotations4;
import d0.e0.p.d.m0.n.l1.KotlinTypeRefiner;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: KotlinType.kt */
/* renamed from: d0.e0.p.d.m0.n.i1, reason: use source file name */
/* loaded from: classes3.dex */
public abstract class KotlinType3 extends KotlinType {
    public KotlinType3() {
        super(null);
    }

    public abstract KotlinType3 makeNullableAsSpecified(boolean z2);

    @Override // d0.e0.p.d.m0.n.KotlinType
    public abstract KotlinType3 refine(KotlinTypeRefiner kotlinTypeRefiner);

    public abstract KotlinType3 replaceAnnotations(Annotations4 annotations4);

    @Override // d0.e0.p.d.m0.n.KotlinType
    public final KotlinType3 unwrap() {
        return this;
    }

    public KotlinType3(DefaultConstructorMarker defaultConstructorMarker) {
        super(null);
    }
}
