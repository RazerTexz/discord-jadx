package d0.e0.p.d.m0.c.g1;

import d0.z.d.Intrinsics3;

/* compiled from: Annotations.kt */
/* renamed from: d0.e0.p.d.m0.c.g1.i, reason: use source file name */
/* loaded from: classes3.dex */
public final class Annotations5 {
    public static final Annotations4 composeAnnotations(Annotations4 annotations4, Annotations4 annotations42) {
        Intrinsics3.checkNotNullParameter(annotations4, "first");
        Intrinsics3.checkNotNullParameter(annotations42, "second");
        return annotations4.isEmpty() ? annotations42 : annotations42.isEmpty() ? annotations4 : new Annotations6(annotations4, annotations42);
    }
}
