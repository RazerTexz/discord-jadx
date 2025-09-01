package d0.y;

import d0.z.d.Intrinsics3;
import java.io.File;

/* compiled from: Exceptions.kt */
/* renamed from: d0.y.c, reason: use source file name */
/* loaded from: classes3.dex */
public final class Exceptions2 {
    public static final String access$constructMessage(File file, File file2, String str) {
        StringBuilder sb = new StringBuilder(file.toString());
        if (file2 != null) {
            sb.append(" -> " + file2);
        }
        if (str != null) {
            sb.append(": " + str);
        }
        String string = sb.toString();
        Intrinsics3.checkNotNullExpressionValue(string, "sb.toString()");
        return string;
    }
}
