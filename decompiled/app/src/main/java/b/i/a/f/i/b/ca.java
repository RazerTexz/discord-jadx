package b.i.a.f.i.b;

import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import android.text.TextUtils;
import android.util.Pair;
import b.i.a.f.h.l.a1;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
/* loaded from: classes3.dex */
public final class ca {
    public b.i.a.f.h.l.a1 a;

    /* renamed from: b, reason: collision with root package name */
    public Long f1522b;
    public long c;
    public final /* synthetic */ ba d;

    public ca(ba baVar, aa aaVar) {
        this.d = baVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00f8  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0126  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0156  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x017a  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0199  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x019e  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x01c0  */
    /* JADX WARN: Type inference failed for: r14v6, types: [long] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final b.i.a.f.h.l.a1 a(String str, b.i.a.f.h.l.a1 a1Var) {
        Cursor cursor;
        Cursor cursorRawQuery;
        Pair pairCreate;
        Object obj;
        long j;
        ArrayList arrayList;
        ?? LongValue;
        String strF = a1Var.F();
        List<b.i.a.f.h.l.c1> listV = a1Var.v();
        this.d.m();
        Long l = (Long) q9.R(a1Var, "_eid");
        boolean z2 = l != null;
        if (z2 && strF.equals("_ep")) {
            this.d.m();
            String str2 = (String) q9.R(a1Var, "_en");
            if (TextUtils.isEmpty(str2)) {
                this.d.g().g.b("Extra parameter without an event name. eventId", l);
                return null;
            }
            if (this.a == null || this.f1522b == null) {
                g gVarQ = this.d.q();
                gVarQ.b();
                gVarQ.n();
                try {
                    try {
                        cursorRawQuery = gVarQ.t().rawQuery("select main_event, children_to_process from main_event_params where app_id=? and event_id=?", new String[]{str, String.valueOf(l)});
                        try {
                            if (cursorRawQuery.moveToFirst()) {
                                try {
                                    pairCreate = Pair.create((b.i.a.f.h.l.a1) ((b.i.a.f.h.l.u4) ((a1.a) q9.x(b.i.a.f.h.l.a1.M(), cursorRawQuery.getBlob(0))).p()), Long.valueOf(cursorRawQuery.getLong(1)));
                                    cursorRawQuery.close();
                                } catch (IOException e) {
                                    gVarQ.g().f.d("Failed to merge main event. appId, eventId", q3.s(str), l, e);
                                    cursorRawQuery.close();
                                    pairCreate = null;
                                    if (pairCreate != null) {
                                    }
                                    this.d.g().g.c("Extra parameter without existing main event. eventName, eventId", str2, l);
                                    return null;
                                }
                            } else {
                                gVarQ.g().n.a("Main event not found");
                                cursorRawQuery.close();
                                pairCreate = null;
                            }
                        } catch (SQLiteException e2) {
                            e = e2;
                            gVarQ.g().f.b("Error selecting main event", e);
                            if (cursorRawQuery != null) {
                                cursorRawQuery.close();
                            }
                            pairCreate = null;
                            if (pairCreate != null) {
                            }
                            this.d.g().g.c("Extra parameter without existing main event. eventName, eventId", str2, l);
                            return null;
                        }
                    } catch (Throwable th) {
                        th = th;
                        cursor = LongValue;
                        if (cursor != null) {
                            cursor.close();
                        }
                        throw th;
                    }
                } catch (SQLiteException e3) {
                    e = e3;
                    cursorRawQuery = null;
                } catch (Throwable th2) {
                    th = th2;
                    cursor = null;
                    if (cursor != null) {
                    }
                    throw th;
                }
                if (pairCreate != null || (obj = pairCreate.first) == null) {
                    this.d.g().g.c("Extra parameter without existing main event. eventName, eventId", str2, l);
                    return null;
                }
                this.a = (b.i.a.f.h.l.a1) obj;
                this.c = ((Long) pairCreate.second).longValue();
                this.d.m();
                this.f1522b = (Long) q9.R(this.a, "_eid");
                j = this.c - 1;
                this.c = j;
                if (j > 0) {
                    g gVarQ2 = this.d.q();
                    gVarQ2.b();
                    gVarQ2.g().n.b("Clearing complex main event info. appId", str);
                    try {
                        gVarQ2.t().execSQL("delete from main_event_params where app_id=?", new String[]{str});
                    } catch (SQLiteException e4) {
                        gVarQ2.g().f.b("Error clearing complex main event", e4);
                    }
                } else {
                    this.d.q().Q(str, l, this.c, this.a);
                }
                arrayList = new ArrayList();
                for (b.i.a.f.h.l.c1 c1Var : this.a.v()) {
                    this.d.m();
                    if (q9.w(a1Var, c1Var.B()) == null) {
                        arrayList.add(c1Var);
                    }
                }
                if (arrayList.isEmpty()) {
                    arrayList.addAll(listV);
                    listV = arrayList;
                } else {
                    this.d.g().g.b("No unique parameters in main event. eventName", str2);
                }
                strF = str2;
            } else {
                LongValue = l.longValue();
                if (LongValue != this.f1522b.longValue()) {
                }
                j = this.c - 1;
                this.c = j;
                if (j > 0) {
                }
                arrayList = new ArrayList();
                while (r2.hasNext()) {
                }
                if (arrayList.isEmpty()) {
                }
                strF = str2;
            }
        } else if (z2) {
            this.f1522b = l;
            this.a = a1Var;
            this.d.m();
            Object objR = q9.R(a1Var, "_epc");
            long jLongValue = ((Long) (objR != null ? objR : 0L)).longValue();
            this.c = jLongValue;
            if (jLongValue <= 0) {
                this.d.g().g.b("Complex event with zero extra param count. eventName", strF);
            } else {
                this.d.q().Q(str, l, this.c, a1Var);
            }
        }
        a1.a aVarT = a1Var.t();
        aVarT.t(strF);
        if (aVarT.l) {
            aVarT.n();
            aVarT.l = false;
        }
        b.i.a.f.h.l.a1.w((b.i.a.f.h.l.a1) aVarT.k);
        if (aVarT.l) {
            aVarT.n();
            aVarT.l = false;
        }
        b.i.a.f.h.l.a1.B((b.i.a.f.h.l.a1) aVarT.k, listV);
        return (b.i.a.f.h.l.a1) ((b.i.a.f.h.l.u4) aVarT.p());
    }
}
