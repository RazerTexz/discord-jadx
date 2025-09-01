package b.i.a.f.i.b;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import androidx.annotation.WorkerThread;
import androidx.collection.ArrayMap;
import b.c.a.a0.AnimatableValueParser;
import b.i.a.f.h.l.g1;
import b.i.a.f.h.l.l0;
import java.io.IOException;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
/* loaded from: classes3.dex */
public final class ba extends i9 {
    public String d;
    public Set<Integer> e;
    public Map<Integer, da> f;
    public Long g;
    public Long h;

    public ba(k9 k9Var) {
        super(k9Var);
    }

    @Override // b.i.a.f.i.b.i9
    public final boolean p() {
        return false;
    }

    public final da s(int i) {
        if (this.f.containsKey(Integer.valueOf(i))) {
            return this.f.get(Integer.valueOf(i));
        }
        da daVar = new da(this, this.d, null);
        this.f.put(Integer.valueOf(i), daVar);
        return daVar;
    }

    /* JADX WARN: Code restructure failed: missing block: B:361:0x0903, code lost:
    
        r0 = g().i;
        r1 = b.i.a.f.i.b.q3.s(r62.d);
     */
    /* JADX WARN: Code restructure failed: missing block: B:362:0x0913, code lost:
    
        if (r8.v() == false) goto L364;
     */
    /* JADX WARN: Code restructure failed: missing block: B:363:0x0915, code lost:
    
        r7 = java.lang.Integer.valueOf(r8.w());
     */
    /* JADX WARN: Code restructure failed: missing block: B:364:0x091e, code lost:
    
        r7 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:365:0x091f, code lost:
    
        r0.c("Invalid property filter ID. appId, id", r1, java.lang.String.valueOf(r7));
        r9 = false;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:105:0x026d  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x027b A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:156:0x035c  */
    /* JADX WARN: Removed duplicated region for block: B:211:0x0487  */
    /* JADX WARN: Removed duplicated region for block: B:251:0x0574  */
    /* JADX WARN: Removed duplicated region for block: B:282:0x0639  */
    /* JADX WARN: Removed duplicated region for block: B:323:0x07d8  */
    /* JADX WARN: Removed duplicated region for block: B:373:0x0959  */
    /* JADX WARN: Removed duplicated region for block: B:389:0x09e0  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0184  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x01bb A[Catch: SQLiteException -> 0x022c, all -> 0x09dc, TryCatch #15 {all -> 0x09dc, blocks: (B:67:0x01b5, B:69:0x01bb, B:71:0x01c1, B:73:0x01cd, B:76:0x01db, B:77:0x01e1, B:78:0x01e9, B:79:0x01fb, B:82:0x021b, B:81:0x0206, B:92:0x0234, B:94:0x0249, B:96:0x0255), top: B:406:0x019c }] */
    /* JADX WARN: Removed duplicated region for block: B:76:0x01db A[Catch: SQLiteException -> 0x022c, all -> 0x09dc, TRY_ENTER, TryCatch #15 {all -> 0x09dc, blocks: (B:67:0x01b5, B:69:0x01bb, B:71:0x01c1, B:73:0x01cd, B:76:0x01db, B:77:0x01e1, B:78:0x01e9, B:79:0x01fb, B:82:0x021b, B:81:0x0206, B:92:0x0234, B:94:0x0249, B:96:0x0255), top: B:406:0x019c }] */
    /* JADX WARN: Type inference failed for: r4v44, types: [androidx.collection.ArrayMap, java.util.Map] */
    /* JADX WARN: Type inference failed for: r5v47, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r5v48 */
    /* JADX WARN: Type inference failed for: r5v49, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r7v0 */
    /* JADX WARN: Type inference failed for: r7v1, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r7v2 */
    /* JADX WARN: Type inference failed for: r7v27 */
    /* JADX WARN: Type inference failed for: r7v28, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r7v29 */
    /* JADX WARN: Unreachable blocks removed: 2, instructions: 2 */
    @WorkerThread
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final List<b.i.a.f.h.l.y0> t(String str, List<b.i.a.f.h.l.a1> list, List<b.i.a.f.h.l.i1> list2, Long l, Long l2) throws Throwable {
        int i;
        int i2;
        boolean z2;
        Cursor cursor;
        Object obj;
        Map map;
        Object obj2;
        g gVarQ;
        String str2;
        ?? r7;
        Cursor cursorQuery;
        Map mapEmptyMap;
        Map map2;
        String str3;
        Iterator<Integer> it;
        ArrayMap arrayMap;
        String str4;
        Integer numValueOf;
        l lVar;
        ca caVar;
        Iterator<Integer> it2;
        ArrayMap arrayMap2;
        Iterator<b.i.a.f.h.l.a1> it3;
        String str5;
        Map map3;
        Iterator it4;
        List<b.i.a.f.h.l.l0> list3;
        boolean z3;
        Map map4;
        ?? r72;
        Cursor cursorRawQuery;
        Iterator it5;
        Map map5;
        Iterator it6;
        ArrayMap arrayMap3;
        Cursor cursor2;
        Cursor cursorQuery2;
        AnimatableValueParser.w(str);
        Objects.requireNonNull(list, "null reference");
        Objects.requireNonNull(list2, "null reference");
        this.d = str;
        this.e = new HashSet();
        this.f = new ArrayMap();
        this.g = l;
        this.h = l2;
        Iterator<b.i.a.f.h.l.a1> it7 = list.iterator();
        while (true) {
            i = 1;
            i2 = 0;
            if (!it7.hasNext()) {
                z2 = false;
                break;
            }
            if ("_s".equals(it7.next().F())) {
                z2 = true;
                break;
            }
        }
        boolean z4 = b.i.a.f.h.l.f9.b() && this.a.h.u(this.d, p.f1554c0);
        boolean z5 = b.i.a.f.h.l.f9.b() && this.a.h.u(this.d, p.f1553b0);
        if (z2) {
            g gVarQ2 = q();
            String str6 = this.d;
            gVarQ2.n();
            gVarQ2.b();
            AnimatableValueParser.w(str6);
            ContentValues contentValues = new ContentValues();
            ?? r5 = "current_session_count";
            contentValues.put("current_session_count", (Integer) 0);
            try {
                SQLiteDatabase sQLiteDatabaseT = gVarQ2.t();
                r5 = "events";
                sQLiteDatabaseT.update("events", contentValues, "app_id = ?", new String[]{str6});
                obj = sQLiteDatabaseT;
                cursor = "events";
            } catch (SQLiteException e) {
                gVarQ2.g().f.c("Error resetting session-scoped event counts. appId", q3.s(str6), e);
                obj = "Error resetting session-scoped event counts. appId";
                cursor = r5;
            }
        }
        Map mapEmptyMap2 = Collections.emptyMap();
        Object obj3 = obj;
        obj3 = obj;
        if (z5 && z4) {
            g gVarQ3 = q();
            String str7 = this.d;
            Objects.requireNonNull(gVarQ3);
            AnimatableValueParser.w(str7);
            ?? arrayMap4 = new ArrayMap();
            try {
                try {
                    cursorQuery2 = gVarQ3.t().query("event_filters", new String[]{"audience_id", "data"}, "app_id=?", new String[]{str7}, null, null, null);
                    try {
                    } catch (SQLiteException e2) {
                        e = e2;
                        gVarQ3.g().f.c("Database error querying filters. appId", q3.s(str7), e);
                        mapEmptyMap2 = Collections.emptyMap();
                        obj3 = "Database error querying filters. appId";
                        if (cursorQuery2 != null) {
                            cursorQuery2.close();
                            obj3 = "Database error querying filters. appId";
                        }
                        map = mapEmptyMap2;
                        obj2 = obj3;
                        gVarQ = q();
                        str2 = this.d;
                        gVarQ.n();
                        gVarQ.b();
                        AnimatableValueParser.w(str2);
                        try {
                            cursorQuery = gVarQ.t().query("audience_filter_values", new String[]{"audience_id", "current_results"}, "app_id=?", new String[]{str2}, null, null, null);
                            try {
                                if (!cursorQuery.moveToFirst()) {
                                }
                            } catch (SQLiteException e3) {
                                e = e3;
                                gVarQ.g().f.c("Database error querying filter results. appId", q3.s(str2), e);
                                if (!b.i.a.f.h.l.l9.b() || !gVarQ.a.h.u(str2, p.F0)) {
                                    if (cursorQuery != null) {
                                        cursorQuery.close();
                                    }
                                    map2 = null;
                                    if (b.i.a.f.h.l.l9.b()) {
                                    }
                                    String str8 = "Skipping failed audience ID";
                                    if (!list.isEmpty()) {
                                    }
                                    if (!list2.isEmpty()) {
                                    }
                                    ArrayList arrayList = new ArrayList();
                                    Set<Integer> setKeySet = this.f.keySet();
                                    setKeySet.removeAll(this.e);
                                    it = setKeySet.iterator();
                                    while (it.hasNext()) {
                                    }
                                    return arrayList;
                                }
                                mapEmptyMap = Collections.emptyMap();
                                if (cursorQuery != null) {
                                    cursorQuery.close();
                                }
                                map2 = mapEmptyMap;
                                if (b.i.a.f.h.l.l9.b()) {
                                }
                                String str82 = "Skipping failed audience ID";
                                if (!list.isEmpty()) {
                                }
                                if (!list2.isEmpty()) {
                                }
                                ArrayList arrayList2 = new ArrayList();
                                Set<Integer> setKeySet2 = this.f.keySet();
                                setKeySet2.removeAll(this.e);
                                it = setKeySet2.iterator();
                                while (it.hasNext()) {
                                }
                                return arrayList2;
                            }
                        } catch (Throwable th) {
                            th = th;
                            r7 = obj2;
                            if (r7 != null) {
                                r7.close();
                            }
                            throw th;
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    cursor2 = cursor;
                    if (cursor2 != null) {
                        cursor2.close();
                    }
                    throw th;
                }
            } catch (SQLiteException e4) {
                e = e4;
                cursorQuery2 = null;
            } catch (Throwable th3) {
                th = th3;
                cursor2 = null;
                if (cursor2 != null) {
                }
                throw th;
            }
            if (cursorQuery2.moveToFirst()) {
                while (true) {
                    try {
                        b.i.a.f.h.l.l0 l0Var = (b.i.a.f.h.l.l0) ((b.i.a.f.h.l.u4) ((l0.a) q9.x(b.i.a.f.h.l.l0.I(), cursorQuery2.getBlob(1))).p());
                        if (l0Var.C()) {
                            int i3 = cursorQuery2.getInt(i2);
                            List arrayList3 = (List) arrayMap4.get(Integer.valueOf(i3));
                            if (arrayList3 == null) {
                                arrayList3 = new ArrayList();
                                arrayMap4.put(Integer.valueOf(i3), arrayList3);
                            }
                            arrayList3.add(l0Var);
                        }
                    } catch (IOException e5) {
                        gVarQ3.g().f.c("Failed to merge filter. appId", q3.s(str7), e5);
                    }
                    if (!cursorQuery2.moveToNext()) {
                        break;
                    }
                    i2 = 0;
                }
                cursorQuery2.close();
                map = arrayMap4;
                obj2 = arrayMap4;
            } else {
                mapEmptyMap2 = Collections.emptyMap();
                cursorQuery2.close();
                obj3 = arrayMap4;
                map = mapEmptyMap2;
                obj2 = obj3;
            }
        } else {
            map = mapEmptyMap2;
            obj2 = obj3;
        }
        gVarQ = q();
        str2 = this.d;
        gVarQ.n();
        gVarQ.b();
        AnimatableValueParser.w(str2);
        try {
            cursorQuery = gVarQ.t().query("audience_filter_values", new String[]{"audience_id", "current_results"}, "app_id=?", new String[]{str2}, null, null, null);
        } catch (SQLiteException e6) {
            e = e6;
            cursorQuery = null;
        } catch (Throwable th4) {
            th = th4;
            r7 = null;
            if (r7 != null) {
            }
            throw th;
        }
        if (!cursorQuery.moveToFirst()) {
            ArrayMap arrayMap5 = new ArrayMap();
            int i4 = 0;
            while (true) {
                int i5 = cursorQuery.getInt(i4);
                try {
                    arrayMap5.put(Integer.valueOf(i5), (b.i.a.f.h.l.g1) ((b.i.a.f.h.l.u4) ((g1.a) q9.x(b.i.a.f.h.l.g1.M(), cursorQuery.getBlob(i))).p()));
                    arrayMap3 = arrayMap5;
                } catch (IOException e7) {
                    arrayMap3 = arrayMap5;
                    gVarQ.g().f.d("Failed to merge filter results. appId, audienceId, error", q3.s(str2), Integer.valueOf(i5), e7);
                }
                if (!cursorQuery.moveToNext()) {
                    break;
                }
                arrayMap5 = arrayMap3;
                i4 = 0;
                i = 1;
            }
            cursorQuery.close();
            map2 = arrayMap3;
            if (b.i.a.f.h.l.l9.b()) {
            }
            String str822 = "Skipping failed audience ID";
            if (!list.isEmpty()) {
            }
            if (!list2.isEmpty()) {
            }
            ArrayList arrayList22 = new ArrayList();
            Set<Integer> setKeySet22 = this.f.keySet();
            setKeySet22.removeAll(this.e);
            it = setKeySet22.iterator();
            while (it.hasNext()) {
            }
            return arrayList22;
        }
        if (b.i.a.f.h.l.l9.b() && gVarQ.a.h.u(str2, p.F0)) {
            mapEmptyMap = Collections.emptyMap();
            cursorQuery.close();
            map2 = mapEmptyMap;
            str3 = b.i.a.f.h.l.l9.b() ? "audience_id" : "audience_id";
            String str8222 = "Skipping failed audience ID";
            if (!list.isEmpty()) {
            }
            if (!list2.isEmpty()) {
            }
            ArrayList arrayList222 = new ArrayList();
            Set<Integer> setKeySet222 = this.f.keySet();
            setKeySet222.removeAll(this.e);
            it = setKeySet222.iterator();
            while (it.hasNext()) {
            }
            return arrayList222;
        }
        cursorQuery.close();
        map2 = null;
        if (((b.i.a.f.h.l.l9.b() && this.a.h.u(this.d, p.F0)) || map2 != null) && !map2.isEmpty()) {
            HashSet hashSet = new HashSet(map2.keySet());
            if (z2) {
                String str9 = this.d;
                AnimatableValueParser.w(str9);
                ArrayMap arrayMap6 = new ArrayMap();
                if (map2.isEmpty()) {
                    str5 = "audience_id";
                } else {
                    g gVarQ4 = q();
                    gVarQ4.n();
                    gVarQ4.b();
                    AnimatableValueParser.w(str9);
                    Map arrayMap7 = new ArrayMap();
                    SQLiteDatabase sQLiteDatabaseT2 = gVarQ4.t();
                    try {
                        str5 = "audience_id";
                    } catch (Throwable th5) {
                        th = th5;
                        r72 = sQLiteDatabaseT2;
                    }
                    try {
                        cursorRawQuery = sQLiteDatabaseT2.rawQuery("select audience_id, filter_id from event_filters where app_id = ? and session_scoped = 1 UNION select audience_id, filter_id from property_filters where app_id = ? and session_scoped = 1;", new String[]{str9, str9});
                        try {
                            if (cursorRawQuery.moveToFirst()) {
                                do {
                                    int i6 = cursorRawQuery.getInt(0);
                                    List arrayList4 = (List) arrayMap7.get(Integer.valueOf(i6));
                                    if (arrayList4 == null) {
                                        arrayList4 = new ArrayList();
                                        arrayMap7.put(Integer.valueOf(i6), arrayList4);
                                    }
                                    try {
                                        arrayList4.add(Integer.valueOf(cursorRawQuery.getInt(1)));
                                    } catch (SQLiteException e8) {
                                        e = e8;
                                        gVarQ4.g().f.c("Database error querying scoped filters. appId", q3.s(str9), e);
                                        if (b.i.a.f.h.l.l9.b() && gVarQ4.a.h.u(str9, p.F0)) {
                                            arrayMap7 = Collections.emptyMap();
                                            if (cursorRawQuery != null) {
                                                cursorRawQuery.close();
                                            }
                                        } else {
                                            if (cursorRawQuery != null) {
                                                cursorRawQuery.close();
                                            }
                                            arrayMap7 = null;
                                        }
                                        it5 = map2.keySet().iterator();
                                        while (it5.hasNext()) {
                                        }
                                        map3 = arrayMap6;
                                        it4 = hashSet.iterator();
                                        while (it4.hasNext()) {
                                        }
                                        str3 = str5;
                                        String str82222 = "Skipping failed audience ID";
                                        if (!list.isEmpty()) {
                                        }
                                        if (!list2.isEmpty()) {
                                        }
                                        ArrayList arrayList2222 = new ArrayList();
                                        Set<Integer> setKeySet2222 = this.f.keySet();
                                        setKeySet2222.removeAll(this.e);
                                        it = setKeySet2222.iterator();
                                        while (it.hasNext()) {
                                        }
                                        return arrayList2222;
                                    }
                                } while (cursorRawQuery.moveToNext());
                                cursorRawQuery.close();
                            } else {
                                arrayMap7 = Collections.emptyMap();
                                cursorRawQuery.close();
                            }
                        } catch (SQLiteException e9) {
                            e = e9;
                        }
                    } catch (SQLiteException e10) {
                        e = e10;
                        cursorRawQuery = null;
                    } catch (Throwable th6) {
                        th = th6;
                        r72 = 0;
                        if (r72 != 0) {
                            r72.close();
                        }
                        throw th;
                    }
                    it5 = map2.keySet().iterator();
                    while (it5.hasNext()) {
                        int iIntValue = ((Integer) it5.next()).intValue();
                        b.i.a.f.h.l.g1 g1Var = (b.i.a.f.h.l.g1) map2.get(Integer.valueOf(iIntValue));
                        List<Integer> list4 = (List) arrayMap7.get(Integer.valueOf(iIntValue));
                        if (list4 == null || list4.isEmpty()) {
                            map5 = arrayMap7;
                            it6 = it5;
                            arrayMap6.put(Integer.valueOf(iIntValue), g1Var);
                            it5 = it6;
                            arrayMap7 = map5;
                        } else {
                            List<Long> listC = m().C(g1Var.E(), list4);
                            if (!listC.isEmpty()) {
                                g1.a aVarT = g1Var.t();
                                map5 = arrayMap7;
                                if (aVarT.l) {
                                    aVarT.n();
                                    it6 = it5;
                                    aVarT.l = false;
                                } else {
                                    it6 = it5;
                                }
                                b.i.a.f.h.l.g1.B((b.i.a.f.h.l.g1) aVarT.k);
                                if (aVarT.l) {
                                    aVarT.n();
                                    aVarT.l = false;
                                }
                                b.i.a.f.h.l.g1.D((b.i.a.f.h.l.g1) aVarT.k, listC);
                                List<Long> listC2 = m().C(g1Var.v(), list4);
                                if (aVarT.l) {
                                    aVarT.n();
                                    aVarT.l = false;
                                }
                                b.i.a.f.h.l.g1.w((b.i.a.f.h.l.g1) aVarT.k);
                                if (aVarT.l) {
                                    aVarT.n();
                                    aVarT.l = false;
                                }
                                b.i.a.f.h.l.g1.y((b.i.a.f.h.l.g1) aVarT.k, listC2);
                                for (int i7 = 0; i7 < g1Var.J(); i7++) {
                                    if (list4.contains(Integer.valueOf(g1Var.u(i7).x()))) {
                                        if (aVarT.l) {
                                            aVarT.n();
                                            aVarT.l = false;
                                        }
                                        b.i.a.f.h.l.g1.x((b.i.a.f.h.l.g1) aVarT.k, i7);
                                    }
                                }
                                for (int i8 = 0; i8 < g1Var.L(); i8++) {
                                    if (list4.contains(Integer.valueOf(g1Var.A(i8).y()))) {
                                        if (aVarT.l) {
                                            aVarT.n();
                                            aVarT.l = false;
                                        }
                                        b.i.a.f.h.l.g1.C((b.i.a.f.h.l.g1) aVarT.k, i8);
                                    }
                                }
                                arrayMap6.put(Integer.valueOf(iIntValue), (b.i.a.f.h.l.g1) ((b.i.a.f.h.l.u4) aVarT.p()));
                                it5 = it6;
                                arrayMap7 = map5;
                            }
                        }
                    }
                }
                map3 = arrayMap6;
            } else {
                str5 = "audience_id";
                map3 = map2;
            }
            it4 = hashSet.iterator();
            while (it4.hasNext()) {
                int iIntValue2 = ((Integer) it4.next()).intValue();
                b.i.a.f.h.l.g1 g1Var2 = (b.i.a.f.h.l.g1) map3.get(Integer.valueOf(iIntValue2));
                BitSet bitSet = new BitSet();
                BitSet bitSet2 = new BitSet();
                ArrayMap arrayMap8 = new ArrayMap();
                if (g1Var2 != null && g1Var2.J() != 0) {
                    for (b.i.a.f.h.l.z0 z0Var : g1Var2.I()) {
                        if (z0Var.w()) {
                            arrayMap8.put(Integer.valueOf(z0Var.x()), z0Var.y() ? Long.valueOf(z0Var.z()) : null);
                        }
                    }
                }
                ArrayMap arrayMap9 = new ArrayMap();
                if (g1Var2 != null && g1Var2.L() != 0) {
                    for (b.i.a.f.h.l.h1 h1Var : g1Var2.K()) {
                        if (!h1Var.x() || h1Var.A() <= 0) {
                            map4 = map3;
                        } else {
                            map4 = map3;
                            arrayMap9.put(Integer.valueOf(h1Var.y()), Long.valueOf(h1Var.u(h1Var.A() - 1)));
                        }
                        map3 = map4;
                    }
                }
                Map map6 = map3;
                if (g1Var2 != null) {
                    for (int i9 = 0; i9 < (g1Var2.z() << 6); i9++) {
                        if (q9.Q(g1Var2.v(), i9)) {
                            g().n.c("Filter already evaluated. audience ID, filter ID", Integer.valueOf(iIntValue2), Integer.valueOf(i9));
                            bitSet2.set(i9);
                            if (q9.Q(g1Var2.E(), i9)) {
                                bitSet.set(i9);
                                z3 = true;
                            } else {
                                z3 = false;
                            }
                        }
                        if (!z3) {
                            arrayMap8.remove(Integer.valueOf(i9));
                        }
                    }
                }
                b.i.a.f.h.l.g1 g1Var3 = (b.i.a.f.h.l.g1) map2.get(Integer.valueOf(iIntValue2));
                if (z5 && z4 && (list3 = (List) map.get(Integer.valueOf(iIntValue2))) != null && this.h != null && this.g != null) {
                    for (b.i.a.f.h.l.l0 l0Var2 : list3) {
                        int iY = l0Var2.y();
                        long jLongValue = this.h.longValue() / 1000;
                        if (l0Var2.F()) {
                            jLongValue = this.g.longValue() / 1000;
                        }
                        if (arrayMap8.containsKey(Integer.valueOf(iY))) {
                            arrayMap8.put(Integer.valueOf(iY), Long.valueOf(jLongValue));
                        }
                        if (arrayMap9.containsKey(Integer.valueOf(iY))) {
                            arrayMap9.put(Integer.valueOf(iY), Long.valueOf(jLongValue));
                        }
                    }
                }
                this.f.put(Integer.valueOf(iIntValue2), new da(this, this.d, g1Var3, bitSet, bitSet2, arrayMap8, arrayMap9, null));
                str5 = str5;
                map = map;
                map3 = map6;
            }
            str3 = str5;
        }
        String str822222 = "Skipping failed audience ID";
        if (!list.isEmpty()) {
            ca caVar2 = new ca(this, null);
            ArrayMap arrayMap10 = new ArrayMap();
            Iterator<b.i.a.f.h.l.a1> it8 = list.iterator();
            while (it8.hasNext()) {
                b.i.a.f.h.l.a1 next = it8.next();
                b.i.a.f.h.l.a1 a1VarA = caVar2.a(this.d, next);
                if (a1VarA != null) {
                    g gVarQ5 = q();
                    String str10 = this.d;
                    String strF = a1VarA.F();
                    l lVarZ = gVarQ5.z(str10, next.F());
                    if (lVarZ == null) {
                        gVarQ5.g().i.c("Event aggregate wasn't created during raw event logging. appId, event", q3.s(str10), gVarQ5.d().u(strF));
                        lVar = new l(str10, next.F(), 1L, 1L, 1L, next.H(), 0L, null, null, null, null);
                    } else {
                        lVar = new l(lVarZ.a, lVarZ.f1548b, lVarZ.c + 1, lVarZ.d + 1, lVarZ.e + 1, lVarZ.f, lVarZ.g, lVarZ.h, lVarZ.i, lVarZ.j, lVarZ.k);
                    }
                    q().H(lVar);
                    long j = lVar.c;
                    String strF2 = a1VarA.F();
                    Map<Integer, List<b.i.a.f.h.l.l0>> mapC0 = (Map) arrayMap10.get(strF2);
                    if (mapC0 == null) {
                        mapC0 = q().c0(this.d, strF2);
                        if (b.i.a.f.h.l.l9.b()) {
                            caVar = caVar2;
                            if (!this.a.h.u(this.d, p.F0)) {
                            }
                            arrayMap10.put(strF2, mapC0);
                        } else {
                            caVar = caVar2;
                        }
                        if (mapC0 == null) {
                            mapC0 = new ArrayMap();
                        }
                        arrayMap10.put(strF2, mapC0);
                    } else {
                        caVar = caVar2;
                    }
                    Iterator<Integer> it9 = mapC0.keySet().iterator();
                    while (it9.hasNext()) {
                        int iIntValue3 = it9.next().intValue();
                        if (this.e.contains(Integer.valueOf(iIntValue3))) {
                            g().n.b("Skipping failed audience ID", Integer.valueOf(iIntValue3));
                        } else {
                            Iterator<b.i.a.f.h.l.l0> it10 = mapC0.get(Integer.valueOf(iIntValue3)).iterator();
                            boolean zI = true;
                            while (true) {
                                if (!it10.hasNext()) {
                                    it2 = it9;
                                    arrayMap2 = arrayMap10;
                                    it3 = it8;
                                    break;
                                }
                                b.i.a.f.h.l.l0 next2 = it10.next();
                                it2 = it9;
                                arrayMap2 = arrayMap10;
                                fa faVar = new fa(this, this.d, iIntValue3, next2);
                                it3 = it8;
                                zI = faVar.i(this.g, this.h, a1VarA, j, lVar, u(iIntValue3, next2.y()));
                                if (!zI) {
                                    this.e.add(Integer.valueOf(iIntValue3));
                                    break;
                                }
                                s(iIntValue3).b(faVar);
                                it9 = it2;
                                arrayMap10 = arrayMap2;
                                it8 = it3;
                            }
                            if (!zI) {
                                this.e.add(Integer.valueOf(iIntValue3));
                            }
                            it9 = it2;
                            arrayMap10 = arrayMap2;
                            it8 = it3;
                        }
                    }
                    caVar2 = caVar;
                }
            }
        }
        if (!list2.isEmpty()) {
            ArrayMap arrayMap11 = new ArrayMap();
            for (b.i.a.f.h.l.i1 i1Var : list2) {
                String strD = i1Var.D();
                Map<Integer, List<b.i.a.f.h.l.o0>> mapD0 = (Map) arrayMap11.get(strD);
                if (mapD0 == null) {
                    mapD0 = q().d0(this.d, strD);
                    if ((!b.i.a.f.h.l.l9.b() || !this.a.h.u(this.d, p.F0)) && mapD0 == null) {
                        mapD0 = new ArrayMap<>();
                    }
                    arrayMap11.put(strD, mapD0);
                }
                Iterator<Integer> it11 = mapD0.keySet().iterator();
                while (true) {
                    if (it11.hasNext()) {
                        int iIntValue4 = it11.next().intValue();
                        if (this.e.contains(Integer.valueOf(iIntValue4))) {
                            g().n.b(str822222, Integer.valueOf(iIntValue4));
                            break;
                        }
                        Iterator<b.i.a.f.h.l.o0> it12 = mapD0.get(Integer.valueOf(iIntValue4)).iterator();
                        boolean zI2 = true;
                        while (true) {
                            if (!it12.hasNext()) {
                                arrayMap = arrayMap11;
                                str4 = str822222;
                                break;
                            }
                            b.i.a.f.h.l.o0 next3 = it12.next();
                            if (g().x(2)) {
                                s3 s3Var = g().n;
                                Integer numValueOf2 = Integer.valueOf(iIntValue4);
                                if (next3.v()) {
                                    arrayMap = arrayMap11;
                                    numValueOf = Integer.valueOf(next3.w());
                                } else {
                                    arrayMap = arrayMap11;
                                    numValueOf = null;
                                }
                                str4 = str822222;
                                s3Var.d("Evaluating filter. audience, filter, property", numValueOf2, numValueOf, d().y(next3.x()));
                                g().n.b("Filter definition", m().y(next3));
                            } else {
                                arrayMap = arrayMap11;
                                str4 = str822222;
                            }
                            if (!next3.v() || next3.w() > 256) {
                                break;
                            }
                            ha haVar = new ha(this, this.d, iIntValue4, next3);
                            zI2 = haVar.i(this.g, this.h, i1Var, u(iIntValue4, next3.w()));
                            if (!zI2) {
                                this.e.add(Integer.valueOf(iIntValue4));
                                break;
                            }
                            s(iIntValue4).b(haVar);
                            arrayMap11 = arrayMap;
                            str822222 = str4;
                        }
                        if (!zI2) {
                            this.e.add(Integer.valueOf(iIntValue4));
                        }
                        arrayMap11 = arrayMap;
                        str822222 = str4;
                    }
                }
            }
        }
        ArrayList arrayList22222 = new ArrayList();
        Set<Integer> setKeySet22222 = this.f.keySet();
        setKeySet22222.removeAll(this.e);
        it = setKeySet22222.iterator();
        while (it.hasNext()) {
            int iIntValue5 = it.next().intValue();
            b.i.a.f.h.l.y0 y0VarA = this.f.get(Integer.valueOf(iIntValue5)).a(iIntValue5);
            arrayList22222.add(y0VarA);
            g gVarQ6 = q();
            String str11 = this.d;
            b.i.a.f.h.l.g1 g1VarA = y0VarA.A();
            gVarQ6.n();
            gVarQ6.b();
            AnimatableValueParser.w(str11);
            Objects.requireNonNull(g1VarA, "null reference");
            byte[] bArrD = g1VarA.d();
            ContentValues contentValues2 = new ContentValues();
            contentValues2.put("app_id", str11);
            contentValues2.put(str3, Integer.valueOf(iIntValue5));
            contentValues2.put("current_results", bArrD);
            try {
            } catch (SQLiteException e11) {
                e = e11;
            }
            try {
                if (gVarQ6.t().insertWithOnConflict("audience_filter_values", null, contentValues2, 5) == -1) {
                    gVarQ6.g().f.b("Failed to insert filter results (got -1). appId", q3.s(str11));
                }
            } catch (SQLiteException e12) {
                e = e12;
                gVarQ6.g().f.c("Error storing filter results. appId", q3.s(str11), e);
            }
        }
        return arrayList22222;
    }

    public final boolean u(int i, int i2) {
        if (this.f.get(Integer.valueOf(i)) == null) {
            return false;
        }
        return this.f.get(Integer.valueOf(i)).d.get(i2);
    }
}
