package b.i.a.f.b;

import android.text.TextUtils;
import b.i.a.f.b.e;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/* loaded from: classes3.dex */
public abstract class e<T extends e> {
    public static String a(Object obj, int i) {
        if (i > 10) {
            return "ERROR: Recursive toString calls";
        }
        if (obj == null) {
            return "";
        }
        if (obj instanceof String) {
            return TextUtils.isEmpty((String) obj) ? "" : obj.toString();
        }
        if (obj instanceof Integer) {
            return ((Integer) obj).intValue() == 0 ? "" : obj.toString();
        }
        if (obj instanceof Long) {
            return ((Long) obj).longValue() == 0 ? "" : obj.toString();
        }
        if (obj instanceof Double) {
            return ((Double) obj).doubleValue() == 0.0d ? "" : obj.toString();
        }
        if (obj instanceof Boolean) {
            return !((Boolean) obj).booleanValue() ? "" : obj.toString();
        }
        if (obj instanceof List) {
            StringBuilder sb = new StringBuilder();
            if (i > 0) {
                sb.append("[");
            }
            int length = sb.length();
            for (Object obj2 : (List) obj) {
                if (sb.length() > length) {
                    sb.append(", ");
                }
                sb.append(a(obj2, i + 1));
            }
            if (i > 0) {
                sb.append("]");
            }
            return sb.toString();
        }
        if (!(obj instanceof Map)) {
            return obj.toString();
        }
        StringBuilder sb2 = new StringBuilder();
        boolean z2 = false;
        int length2 = 0;
        for (Map.Entry entry : new TreeMap((Map) obj).entrySet()) {
            String strA = a(entry.getValue(), i + 1);
            if (!TextUtils.isEmpty(strA)) {
                if (i > 0 && !z2) {
                    sb2.append("{");
                    length2 = sb2.length();
                    z2 = true;
                }
                if (sb2.length() > length2) {
                    sb2.append(", ");
                }
                sb2.append((String) entry.getKey());
                sb2.append('=');
                sb2.append(strA);
            }
        }
        if (z2) {
            sb2.append("}");
        }
        return sb2.toString();
    }
}
