package b.i.a.f.h.l;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import java.util.HashMap;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* loaded from: classes3.dex */
public final /* synthetic */ class g2 implements d2 {
    public final c2 a;

    /* renamed from: b, reason: collision with root package name */
    public final String f1443b;

    public g2(c2 c2Var, String str) {
        this.a = c2Var;
        this.f1443b = str;
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x0088, code lost:
    
        if (b.i.a.f.h.l.u1.l == false) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0090, code lost:
    
        if (b.i.a.f.h.l.u1.f.isEmpty() == false) goto L40;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0092, code lost:
    
        r6 = b.i.a.f.h.l.u1.m;
        r10 = b.i.a.f.h.l.u1.f;
        r2 = r2.query(b.i.a.f.h.l.u1.f1496b, null, null, r6, null);
        r3 = new java.util.TreeMap();
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x00a4, code lost:
    
        if (r2 != null) goto L71;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x00ab, code lost:
    
        if (r2.moveToNext() == false) goto L77;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x00ad, code lost:
    
        r3.put(r2.getString(0), r2.getString(1));
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x00bc, code lost:
    
        r10.putAll(r3);
        b.i.a.f.h.l.u1.l = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x00c7, code lost:
    
        if (b.i.a.f.h.l.u1.f.containsKey(r1) == false) goto L40;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x00c9, code lost:
    
        r1 = b.i.a.f.h.l.u1.f.get(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x00d1, code lost:
    
        if (r1 == null) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x00d3, code lost:
    
        r11 = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x00d8, code lost:
    
        r1 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x00dc, code lost:
    
        throw r1;
     */
    @Override // b.i.a.f.h.l.d2
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object a() {
        String str;
        c2 c2Var = this.a;
        String str2 = this.f1443b;
        ContentResolver contentResolver = c2Var.f1437b.getContentResolver();
        Uri uri = u1.a;
        synchronized (u1.class) {
            if (u1.f == null) {
                u1.e.set(false);
                u1.f = new HashMap<>();
                u1.k = new Object();
                u1.l = false;
                contentResolver.registerContentObserver(u1.a, true, new t1());
            } else if (u1.e.getAndSet(false)) {
                u1.f.clear();
                u1.g.clear();
                u1.h.clear();
                u1.i.clear();
                u1.j.clear();
                u1.k = new Object();
                u1.l = false;
            }
            Object obj = u1.k;
            if (u1.f.containsKey(str2)) {
                String str3 = u1.f.get(str2);
                str = str3 != null ? str3 : null;
            } else {
                String[] strArr = u1.m;
                int length = strArr.length;
                int i = 0;
                while (true) {
                    if (i >= length) {
                        Cursor cursorQuery = contentResolver.query(u1.a, null, null, new String[]{str2}, null);
                        if (cursorQuery != null) {
                            try {
                                if (cursorQuery.moveToFirst()) {
                                    String string = cursorQuery.getString(1);
                                    if (string != null && string.equals(null)) {
                                        string = null;
                                    }
                                    u1.a(obj, str2, string);
                                    str = string != null ? string : null;
                                } else {
                                    u1.a(obj, str2, null);
                                }
                            } finally {
                            }
                        } else if (cursorQuery != null) {
                        }
                    } else {
                        if (str2.startsWith(strArr[i])) {
                            break;
                        }
                        i++;
                    }
                }
            }
        }
        return str;
    }
}
