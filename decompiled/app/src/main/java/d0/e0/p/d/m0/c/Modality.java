package d0.e0.p.d.m0.c;

import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: Modality.kt */
/* renamed from: d0.e0.p.d.m0.c.z, reason: use source file name */
/* loaded from: classes3.dex */
public enum Modality {
    FINAL,
    SEALED,
    OPEN,
    ABSTRACT;

    public static final a j = new a(null);

    /* compiled from: Modality.kt */
    /* renamed from: d0.e0.p.d.m0.c.z$a */
    public static final class a {
        public a(DefaultConstructorMarker defaultConstructorMarker) {
        }

        public final Modality convertFromFlags(boolean z2, boolean z3, boolean z4) {
            return z2 ? Modality.SEALED : z3 ? Modality.ABSTRACT : z4 ? Modality.OPEN : Modality.FINAL;
        }
    }

    /* renamed from: values, reason: to resolve conflict with enum method */
    public static Modality[] valuesCustom() {
        Modality[] modalityArrValuesCustom = values();
        Modality[] modalityArr = new Modality[modalityArrValuesCustom.length];
        System.arraycopy(modalityArrValuesCustom, 0, modalityArr, 0, modalityArrValuesCustom.length);
        return modalityArr;
    }
}
