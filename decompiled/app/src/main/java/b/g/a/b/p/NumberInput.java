package b.g.a.b.p;

import androidx.recyclerview.widget.RecyclerView;

/* compiled from: NumberInput.java */
/* renamed from: b.g.a.b.p.f, reason: use source file name */
/* loaded from: classes3.dex */
public final class NumberInput {
    public static final String a = String.valueOf(Long.MIN_VALUE).substring(1);

    /* renamed from: b, reason: collision with root package name */
    public static final String f668b = String.valueOf(RecyclerView.FOREVER_NS);

    /* JADX WARN: Code restructure failed: missing block: B:43:0x0077, code lost:
    
        r8 = java.lang.Integer.parseInt(r8);
     */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0086 A[EDGE_INSN: B:56:0x0086->B:46:0x0086 BREAK  A[LOOP:0: B:35:0x0062->B:42:0x0075], PHI: r2
      0x0086: PHI (r2v3 int) = (r2v2 int), (r2v5 int), (r2v7 int), (r2v10 int) binds: [B:22:0x003e, B:28:0x004f, B:34:0x0060, B:56:0x0086] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x008c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static long a(String str) throws NumberFormatException {
        int i;
        if (str.length() > 9) {
            return Long.parseLong(str);
        }
        char cCharAt = str.charAt(0);
        int length = str.length();
        int i2 = 1;
        boolean z2 = cCharAt == '-';
        if (z2) {
            if (length == 1 || length > 10) {
                i = Integer.parseInt(str);
            } else {
                cCharAt = str.charAt(1);
                i2 = 2;
                if (cCharAt <= '9' || cCharAt < '0') {
                    i = Integer.parseInt(str);
                } else {
                    int i3 = cCharAt - '0';
                    if (i2 < length) {
                        int i4 = i2 + 1;
                        char cCharAt2 = str.charAt(i2);
                        if (cCharAt2 > '9' || cCharAt2 < '0') {
                            i = Integer.parseInt(str);
                        } else {
                            i3 = (i3 * 10) + (cCharAt2 - '0');
                            if (i4 < length) {
                                int i5 = i4 + 1;
                                char cCharAt3 = str.charAt(i4);
                                if (cCharAt3 > '9' || cCharAt3 < '0') {
                                    i = Integer.parseInt(str);
                                } else {
                                    i3 = (i3 * 10) + (cCharAt3 - '0');
                                    if (i5 < length) {
                                        while (true) {
                                            int i6 = i5 + 1;
                                            char cCharAt4 = str.charAt(i5);
                                            if (cCharAt4 > '9' || cCharAt4 < '0') {
                                                break;
                                            }
                                            i3 = (i3 * 10) + (cCharAt4 - '0');
                                            if (i6 >= length) {
                                                break;
                                            }
                                            i5 = i6;
                                        }
                                        i = !z2 ? -i3 : i3;
                                    } else if (!z2) {
                                    }
                                }
                            }
                        }
                    }
                }
            }
        } else if (length > 9) {
            i = Integer.parseInt(str);
        } else if (cCharAt <= '9') {
            i = Integer.parseInt(str);
        }
        return i;
    }
}
