package b.i.a.f.h.l;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement-base@@18.0.0 */
/* loaded from: classes3.dex */
public final class o5 extends m5 {
    public static final Class<?> c = Collections.unmodifiableList(Collections.emptyList()).getClass();

    public o5(l5 l5Var) {
        super(null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // b.i.a.f.h.l.m5
    public final <E> void a(Object obj, Object obj2, long j) {
        k5 k5Var;
        List list = (List) j7.r(obj2, j);
        int size = list.size();
        List listF = (List) j7.r(obj, j);
        if (listF.isEmpty()) {
            listF = listF instanceof j5 ? new k5(size) : ((listF instanceof l6) && (listF instanceof b5)) ? ((b5) listF).f(size) : new ArrayList(size);
            j7.f(obj, j, listF);
        } else {
            if (c.isAssignableFrom(listF.getClass())) {
                ArrayList arrayList = new ArrayList(listF.size() + size);
                arrayList.addAll(listF);
                j7.f(obj, j, arrayList);
                k5Var = arrayList;
            } else if (listF instanceof e7) {
                k5 k5Var2 = new k5(listF.size() + size);
                k5Var2.addAll(k5Var2.size(), (e7) listF);
                j7.f(obj, j, k5Var2);
                k5Var = k5Var2;
            } else if ((listF instanceof l6) && (listF instanceof b5)) {
                b5 b5Var = (b5) listF;
                if (!b5Var.a()) {
                    listF = b5Var.f(listF.size() + size);
                    j7.f(obj, j, listF);
                }
            }
            listF = k5Var;
        }
        int size2 = listF.size();
        int size3 = list.size();
        if (size2 > 0 && size3 > 0) {
            listF.addAll(list);
        }
        if (size2 > 0) {
            list = listF;
        }
        j7.f(obj, j, list);
    }

    @Override // b.i.a.f.h.l.m5
    public final void b(Object obj, long j) {
        Object objUnmodifiableList;
        List list = (List) j7.r(obj, j);
        if (list instanceof j5) {
            objUnmodifiableList = ((j5) list).s();
        } else {
            if (c.isAssignableFrom(list.getClass())) {
                return;
            }
            if ((list instanceof l6) && (list instanceof b5)) {
                b5 b5Var = (b5) list;
                if (b5Var.a()) {
                    b5Var.g0();
                    return;
                }
                return;
            }
            objUnmodifiableList = Collections.unmodifiableList(list);
        }
        j7.f(obj, j, objUnmodifiableList);
    }
}
