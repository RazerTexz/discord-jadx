package d0;

import d0.z.d.Intrinsics3;
import d0.z.d.g0.KMarkers;
import java.util.Collection;

/* compiled from: UIntArray.kt */
/* renamed from: d0.q, reason: use source file name */
/* loaded from: classes3.dex */
public final class UIntArray implements Collection<UInt>, KMarkers {
    /* renamed from: constructor-impl, reason: not valid java name */
    public static int[] m106constructorimpl(int i) {
        return m107constructorimpl(new int[i]);
    }

    /* renamed from: constructor-impl, reason: not valid java name */
    public static int[] m107constructorimpl(int[] iArr) {
        Intrinsics3.checkNotNullParameter(iArr, "storage");
        return iArr;
    }

    /* renamed from: get-pVg5ArA, reason: not valid java name */
    public static final int m108getpVg5ArA(int[] iArr, int i) {
        return UInt.m105constructorimpl(iArr[i]);
    }

    /* renamed from: getSize-impl, reason: not valid java name */
    public static int m109getSizeimpl(int[] iArr) {
        return iArr.length;
    }

    /* renamed from: set-VXSXFK8, reason: not valid java name */
    public static final void m110setVXSXFK8(int[] iArr, int i, int i2) {
        iArr[i] = i2;
    }
}
