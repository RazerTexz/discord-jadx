package d0.e0.p.d.m0.g;

import d0.g0.StringsJVM;
import d0.z.d.Intrinsics3;

/* compiled from: FqNamesUtil.kt */
/* renamed from: d0.e0.p.d.m0.g.d, reason: use source file name */
/* loaded from: classes3.dex */
public final class FqNamesUtil {
    public static final boolean isSubpackageOf(FqName fqName, FqName fqName2) {
        Intrinsics3.checkNotNullParameter(fqName, "<this>");
        Intrinsics3.checkNotNullParameter(fqName2, "packageName");
        if (Intrinsics3.areEqual(fqName, fqName2) || fqName2.isRoot()) {
            return true;
        }
        String strAsString = fqName.asString();
        Intrinsics3.checkNotNullExpressionValue(strAsString, "this.asString()");
        String strAsString2 = fqName2.asString();
        Intrinsics3.checkNotNullExpressionValue(strAsString2, "packageName.asString()");
        return StringsJVM.startsWith$default(strAsString, strAsString2, false, 2, null) && strAsString.charAt(strAsString2.length()) == '.';
    }

    public static final boolean isValidJavaFqName(String str) {
        FqNamesUtil2 fqNamesUtil2 = FqNamesUtil2.AFTER_DOT;
        if (str == null) {
            return false;
        }
        FqNamesUtil2 fqNamesUtil22 = FqNamesUtil2.BEGINNING;
        int i = 0;
        while (i < str.length()) {
            char cCharAt = str.charAt(i);
            i++;
            int iOrdinal = fqNamesUtil22.ordinal();
            if (iOrdinal != 0) {
                if (iOrdinal != 1) {
                    if (iOrdinal != 2) {
                        continue;
                    }
                } else if (cCharAt == '.') {
                    fqNamesUtil22 = fqNamesUtil2;
                } else if (!Character.isJavaIdentifierPart(cCharAt)) {
                    return false;
                }
            }
            if (!Character.isJavaIdentifierPart(cCharAt)) {
                return false;
            }
            fqNamesUtil22 = FqNamesUtil2.MIDDLE;
        }
        return fqNamesUtil22 != fqNamesUtil2;
    }

    public static final FqName tail(FqName fqName, FqName fqName2) {
        Intrinsics3.checkNotNullParameter(fqName, "<this>");
        Intrinsics3.checkNotNullParameter(fqName2, "prefix");
        if (!isSubpackageOf(fqName, fqName2) || fqName2.isRoot()) {
            return fqName;
        }
        if (Intrinsics3.areEqual(fqName, fqName2)) {
            FqName fqName3 = FqName.a;
            Intrinsics3.checkNotNullExpressionValue(fqName3, "ROOT");
            return fqName3;
        }
        String strAsString = fqName.asString();
        Intrinsics3.checkNotNullExpressionValue(strAsString, "asString()");
        String strSubstring = strAsString.substring(fqName2.asString().length() + 1);
        Intrinsics3.checkNotNullExpressionValue(strSubstring, "(this as java.lang.String).substring(startIndex)");
        return new FqName(strSubstring);
    }
}
