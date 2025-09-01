package b.i.a.f.j;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.util.Log;
import androidx.core.content.PermissionChecker;
import b.i.a.f.h.m.p;
import java.util.HashMap;
import java.util.TreeMap;

/* loaded from: classes3.dex */
public final class a {
    /* JADX WARN: Removed duplicated region for block: B:71:0x00ed A[DONT_GENERATE, PHI: r9
      0x00ed: PHI (r9v2 java.lang.String) = (r9v0 java.lang.String), (r9v1 java.lang.String), (r9v0 java.lang.String) binds: [B:67:0x00e4, B:68:0x00e6, B:70:0x00eb] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean a(Context context) {
        Object obj;
        String str;
        boolean z2;
        Cursor cursorQuery;
        String str2;
        Boolean bool;
        if (PermissionChecker.checkCallingOrSelfPermission(context, "com.google.android.providers.gsf.permission.READ_GSERVICES") != 0) {
            return true;
        }
        ContentResolver contentResolver = context.getContentResolver();
        Uri uri = p.a;
        synchronized (p.class) {
            p.a(contentResolver);
            obj = p.k;
        }
        HashMap<String, Boolean> map = p.g;
        Boolean bool2 = Boolean.TRUE;
        synchronized (p.class) {
            str = null;
            if (map.containsKey("gms:nearby:requires_gms_check")) {
                Boolean bool3 = map.get("gms:nearby:requires_gms_check");
                if (bool3 != null) {
                    bool2 = bool3;
                }
            } else {
                bool2 = null;
            }
        }
        Boolean bool4 = bool2;
        if (bool4 != null) {
            return bool4.booleanValue();
        }
        synchronized (p.class) {
            p.a(contentResolver);
            Object obj2 = p.k;
            z2 = false;
            if (p.f.containsKey("gms:nearby:requires_gms_check")) {
                str2 = p.f.get("gms:nearby:requires_gms_check");
                if (str2 != null) {
                    str = str2;
                }
            } else {
                for (String str3 : p.m) {
                    if ("gms:nearby:requires_gms_check".startsWith(str3)) {
                        if (!p.l || p.f.isEmpty()) {
                            String[] strArr = p.m;
                            HashMap<String, String> map2 = p.f;
                            cursorQuery = contentResolver.query(p.f1510b, null, null, strArr, null);
                            TreeMap treeMap = new TreeMap();
                            if (cursorQuery != null) {
                                while (cursorQuery.moveToNext()) {
                                    try {
                                        treeMap.put(cursorQuery.getString(0), cursorQuery.getString(1));
                                    } finally {
                                        cursorQuery.close();
                                    }
                                }
                            }
                            map2.putAll(treeMap);
                            p.l = true;
                            if (p.f.containsKey("gms:nearby:requires_gms_check") && (str2 = p.f.get("gms:nearby:requires_gms_check")) != null) {
                                str = str2;
                            }
                        }
                    }
                }
                cursorQuery = contentResolver.query(p.a, null, null, new String[]{"gms:nearby:requires_gms_check"}, null);
                if (cursorQuery != null) {
                    try {
                        if (cursorQuery.moveToFirst()) {
                            String string = cursorQuery.getString(1);
                            if (string != null && string.equals(null)) {
                                string = null;
                            }
                            p.b(obj2, "gms:nearby:requires_gms_check", string);
                            if (string != null) {
                                str = string;
                            }
                        } else {
                            p.b(obj2, "gms:nearby:requires_gms_check", null);
                        }
                    } finally {
                        if (cursorQuery != null) {
                        }
                    }
                } else {
                    p.b(obj2, "gms:nearby:requires_gms_check", null);
                }
            }
        }
        if (str == null || str.equals("")) {
            bool = bool4;
            z2 = true;
        } else {
            if (p.c.matcher(str).matches()) {
                bool4 = Boolean.TRUE;
            } else if (p.d.matcher(str).matches()) {
                bool = Boolean.FALSE;
            } else {
                Log.w("Gservices", "attempt to read gservices key gms:nearby:requires_gms_check (value \"" + str + "\") as boolean");
            }
            bool = bool4;
            z2 = true;
        }
        HashMap<String, Boolean> map3 = p.g;
        synchronized (p.class) {
            if (obj == p.k) {
                map3.put("gms:nearby:requires_gms_check", bool);
                p.f.remove("gms:nearby:requires_gms_check");
            }
        }
        return z2;
    }
}
