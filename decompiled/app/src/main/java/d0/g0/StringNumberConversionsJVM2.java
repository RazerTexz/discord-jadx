package d0.g0;

import d0.z.d.Intrinsics3;

/* compiled from: StringNumberConversionsJVM.kt */
/* renamed from: d0.g0.r, reason: use source file name */
/* loaded from: classes3.dex */
public class StringNumberConversionsJVM2 extends StringBuilder {
    public static final Double toDoubleOrNull(String str) {
        Intrinsics3.checkNotNullParameter(str, "$this$toDoubleOrNull");
        try {
            if (StringNumberConversionsJVM.a.matches(str)) {
                return Double.valueOf(Double.parseDouble(str));
            }
            return null;
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    public static final Float toFloatOrNull(String str) {
        Intrinsics3.checkNotNullParameter(str, "$this$toFloatOrNull");
        try {
            if (StringNumberConversionsJVM.a.matches(str)) {
                return Float.valueOf(Float.parseFloat(str));
            }
            return null;
        } catch (NumberFormatException unused) {
            return null;
        }
    }
}
