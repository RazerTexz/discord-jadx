package d0.g0;

import b.d.b.a.outline;
import d0.t.Collections2;
import d0.t.Iterables2;
import d0.t._Collections;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.jvm.functions.Function1;

/* compiled from: Indent.kt */
/* renamed from: d0.g0.m, reason: use source file name */
/* loaded from: classes3.dex */
public class Indent extends Appendable {

    /* compiled from: Indent.kt */
    /* renamed from: d0.g0.m$a */
    public static final class a extends Lambda implements Function1<String, String> {
        public static final a j = new a();

        public a() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ String invoke(String str) {
            return invoke2(str);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final String invoke2(String str) {
            Intrinsics3.checkNotNullParameter(str, "line");
            return str;
        }
    }

    /* compiled from: Indent.kt */
    /* renamed from: d0.g0.m$b */
    public static final class b extends Lambda implements Function1<String, String> {
        public final /* synthetic */ String $indent;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(String str) {
            super(1);
            this.$indent = str;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ String invoke(String str) {
            return invoke2(str);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final String invoke2(String str) {
            Intrinsics3.checkNotNullParameter(str, "line");
            return outline.J(new StringBuilder(), this.$indent, str);
        }
    }

    public static final Function1<String, String> a(String str) {
        return str.length() == 0 ? a.j : new b(str);
    }

    public static final String replaceIndent(String str, String str2) {
        int length;
        String strInvoke;
        Intrinsics3.checkNotNullParameter(str, "$this$replaceIndent");
        Intrinsics3.checkNotNullParameter(str2, "newIndent");
        List<String> listLines = Strings4.lines(str);
        ArrayList arrayList = new ArrayList();
        for (Object obj : listLines) {
            if (!StringsJVM.isBlank((String) obj)) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList(Iterables2.collectionSizeOrDefault(arrayList, 10));
        Iterator it = arrayList.iterator();
        while (true) {
            length = 0;
            if (!it.hasNext()) {
                break;
            }
            String str3 = (String) it.next();
            int length2 = str3.length();
            while (true) {
                if (length >= length2) {
                    length = -1;
                    break;
                }
                if (!CharJVM.isWhitespace(str3.charAt(length))) {
                    break;
                }
                length++;
            }
            if (length == -1) {
                length = str3.length();
            }
            arrayList2.add(Integer.valueOf(length));
        }
        Integer num = (Integer) _Collections.minOrNull(arrayList2);
        int iIntValue = num != null ? num.intValue() : 0;
        int size = (listLines.size() * str2.length()) + str.length();
        Function1<String, String> function1A = a(str2);
        int lastIndex = Collections2.getLastIndex(listLines);
        ArrayList arrayList3 = new ArrayList();
        for (Object obj2 : listLines) {
            int i = length + 1;
            if (length < 0) {
                Collections2.throwIndexOverflow();
            }
            String str4 = (String) obj2;
            if ((length == 0 || length == lastIndex) && StringsJVM.isBlank(str4)) {
                str4 = null;
            } else {
                String strDrop = _Strings.drop(str4, iIntValue);
                if (strDrop != null && (strInvoke = function1A.invoke(strDrop)) != null) {
                    str4 = strInvoke;
                }
            }
            if (str4 != null) {
                arrayList3.add(str4);
            }
            length = i;
        }
        String string = ((StringBuilder) _Collections.joinTo$default(arrayList3, new StringBuilder(size), "\n", null, null, 0, null, null, 124, null)).toString();
        Intrinsics3.checkNotNullExpressionValue(string, "mapIndexedNotNull { inde…\"\\n\")\n        .toString()");
        return string;
    }

    public static final String replaceIndentByMargin(String str, String str2, String str3) {
        int i;
        String strInvoke;
        Intrinsics3.checkNotNullParameter(str, "$this$replaceIndentByMargin");
        Intrinsics3.checkNotNullParameter(str2, "newIndent");
        Intrinsics3.checkNotNullParameter(str3, "marginPrefix");
        if (!(!StringsJVM.isBlank(str3))) {
            throw new IllegalArgumentException("marginPrefix must be non-blank string.".toString());
        }
        List<String> listLines = Strings4.lines(str);
        int size = (listLines.size() * str2.length()) + str.length();
        Function1<String, String> function1A = a(str2);
        int lastIndex = Collections2.getLastIndex(listLines);
        ArrayList arrayList = new ArrayList();
        int i2 = 0;
        for (Object obj : listLines) {
            int i3 = i2 + 1;
            if (i2 < 0) {
                Collections2.throwIndexOverflow();
            }
            String str4 = (String) obj;
            String strSubstring = null;
            if ((i2 != 0 && i2 != lastIndex) || !StringsJVM.isBlank(str4)) {
                int length = str4.length();
                int i4 = 0;
                while (true) {
                    if (i4 >= length) {
                        i = -1;
                        break;
                    }
                    if (!CharJVM.isWhitespace(str4.charAt(i4))) {
                        i = i4;
                        break;
                    }
                    i4++;
                }
                if (i != -1) {
                    int i5 = i;
                    if (StringsJVM.startsWith$default(str4, str3, i, false, 4, null)) {
                        int length2 = str3.length() + i5;
                        Objects.requireNonNull(str4, "null cannot be cast to non-null type java.lang.String");
                        strSubstring = str4.substring(length2);
                        Intrinsics3.checkNotNullExpressionValue(strSubstring, "(this as java.lang.String).substring(startIndex)");
                    }
                }
                if (strSubstring != null && (strInvoke = function1A.invoke(strSubstring)) != null) {
                    str4 = strInvoke;
                }
                strSubstring = str4;
            }
            if (strSubstring != null) {
                arrayList.add(strSubstring);
            }
            i2 = i3;
        }
        String string = ((StringBuilder) _Collections.joinTo$default(arrayList, new StringBuilder(size), "\n", null, null, 0, null, null, 124, null)).toString();
        Intrinsics3.checkNotNullExpressionValue(string, "mapIndexedNotNull { inde…\"\\n\")\n        .toString()");
        return string;
    }

    public static final String trimIndent(String str) {
        Intrinsics3.checkNotNullParameter(str, "$this$trimIndent");
        return replaceIndent(str, "");
    }

    public static final String trimMargin(String str, String str2) {
        Intrinsics3.checkNotNullParameter(str, "$this$trimMargin");
        Intrinsics3.checkNotNullParameter(str2, "marginPrefix");
        return replaceIndentByMargin(str, "", str2);
    }

    public static /* synthetic */ String trimMargin$default(String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str2 = "|";
        }
        return trimMargin(str, str2);
    }
}
