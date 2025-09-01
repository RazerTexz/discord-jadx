package androidx.core.text;

import android.text.TextUtils;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: String.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0003\u001a\u0014\u0010\u0001\u001a\u00020\u0000*\u00020\u0000H\u0086\b¢\u0006\u0004\b\u0001\u0010\u0002¨\u0006\u0003"}, d2 = {"", "htmlEncode", "(Ljava/lang/String;)Ljava/lang/String;", "core-ktx_release"}, k = 2, mv = {1, 5, 1})
/* renamed from: androidx.core.text.StringKt, reason: use source file name */
/* loaded from: classes.dex */
public final class String {
    public static final java.lang.String htmlEncode(java.lang.String str) {
        Intrinsics3.checkNotNullParameter(str, "<this>");
        java.lang.String strHtmlEncode = TextUtils.htmlEncode(str);
        Intrinsics3.checkNotNullExpressionValue(strHtmlEncode, "htmlEncode(this)");
        return strHtmlEncode;
    }
}
