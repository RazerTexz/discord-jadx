package androidx.core.util;

import androidx.annotation.RequiresApi;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: Half.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0010\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u001a\u0014\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u0087\b¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0014\u0010\u0002\u001a\u00020\u0001*\u00020\u0004H\u0087\b¢\u0006\u0004\b\u0002\u0010\u0005\u001a\u0014\u0010\u0002\u001a\u00020\u0001*\u00020\u0006H\u0087\b¢\u0006\u0004\b\u0002\u0010\u0007\u001a\u0014\u0010\u0002\u001a\u00020\u0001*\u00020\bH\u0087\b¢\u0006\u0004\b\u0002\u0010\t¨\u0006\n"}, d2 = {"", "Landroid/util/Half;", "toHalf", "(S)Landroid/util/Half;", "", "(F)Landroid/util/Half;", "", "(D)Landroid/util/Half;", "", "(Ljava/lang/String;)Landroid/util/Half;", "core-ktx_release"}, k = 2, mv = {1, 5, 1})
/* renamed from: androidx.core.util.HalfKt, reason: use source file name */
/* loaded from: classes.dex */
public final class Half {
    @RequiresApi(26)
    public static final android.util.Half toHalf(short s2) {
        android.util.Half halfValueOf = android.util.Half.valueOf(s2);
        Intrinsics3.checkNotNullExpressionValue(halfValueOf, "valueOf(this)");
        return halfValueOf;
    }

    @RequiresApi(26)
    public static final android.util.Half toHalf(float f) {
        android.util.Half halfValueOf = android.util.Half.valueOf(f);
        Intrinsics3.checkNotNullExpressionValue(halfValueOf, "valueOf(this)");
        return halfValueOf;
    }

    @RequiresApi(26)
    public static final android.util.Half toHalf(String str) {
        Intrinsics3.checkNotNullParameter(str, "<this>");
        android.util.Half halfValueOf = android.util.Half.valueOf(str);
        Intrinsics3.checkNotNullExpressionValue(halfValueOf, "valueOf(this)");
        return halfValueOf;
    }

    @RequiresApi(26)
    public static final android.util.Half toHalf(double d) {
        android.util.Half halfValueOf = android.util.Half.valueOf((float) d);
        Intrinsics3.checkNotNullExpressionValue(halfValueOf, "valueOf(this)");
        return halfValueOf;
    }
}
