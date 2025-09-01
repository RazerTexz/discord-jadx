package b.i.a.f.i.b;

import androidx.collection.ArrayMap;
import b.d.b.a.outline;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
/* loaded from: classes3.dex */
public final class fa extends ea {
    public b.i.a.f.h.l.l0 g;
    public final /* synthetic */ ba h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public fa(ba baVar, String str, int i, b.i.a.f.h.l.l0 l0Var) {
        super(str, i);
        this.h = baVar;
        this.g = l0Var;
    }

    @Override // b.i.a.f.i.b.ea
    public final int a() {
        return this.g.y();
    }

    @Override // b.i.a.f.i.b.ea
    public final boolean g() {
        return false;
    }

    @Override // b.i.a.f.i.b.ea
    public final boolean h() {
        return this.g.C();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0190  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean i(Long l, Long l2, b.i.a.f.h.l.a1 a1Var, long j, l lVar, boolean z2) {
        Boolean boolF;
        Boolean boolD;
        String string;
        boolean z3 = b.i.a.f.h.l.f9.b() && this.h.a.h.u(this.a, p.f1554c0);
        long j2 = this.g.H() ? lVar.e : j;
        bool = 0;
        bool = 0;
        bool = 0;
        bool = 0;
        bool = 0;
        bool = 0;
        bool = 0;
        bool = 0;
        bool = 0;
        bool = 0;
        bool = 0;
        Boolean bool = 0;
        if (this.h.g().x(2)) {
            this.h.g().n.d("Evaluating filter. audience, filter, event", Integer.valueOf(this.f1531b), this.g.x() ? Integer.valueOf(this.g.y()) : null, this.h.d().u(this.g.z()));
            s3 s3Var = this.h.g().n;
            q9 q9VarM = this.h.m();
            b.i.a.f.h.l.l0 l0Var = this.g;
            Objects.requireNonNull(q9VarM);
            if (l0Var == null) {
                string = "null";
            } else {
                StringBuilder sbU = outline.U("\nevent_filter {\n");
                if (l0Var.x()) {
                    q9.L(sbU, 0, "filter_id", Integer.valueOf(l0Var.y()));
                }
                q9.L(sbU, 0, "event_name", q9VarM.d().u(l0Var.z()));
                String strA = q9.A(l0Var.E(), l0Var.F(), l0Var.H());
                if (!strA.isEmpty()) {
                    q9.L(sbU, 0, "filter_type", strA);
                }
                if (l0Var.C()) {
                    q9.J(sbU, 1, "event_count_filter", l0Var.D());
                }
                if (l0Var.B() > 0) {
                    sbU.append("  filters {\n");
                    Iterator<b.i.a.f.h.l.m0> it = l0Var.A().iterator();
                    while (it.hasNext()) {
                        q9VarM.I(sbU, 2, it.next());
                    }
                }
                q9.H(sbU, 1);
                sbU.append("}\n}\n");
                string = sbU.toString();
            }
            s3Var.b("Filter definition", string);
        }
        if (!this.g.x() || this.g.y() > 256) {
            this.h.g().i.c("Invalid event filter ID. appId, id", q3.s(this.a), String.valueOf(this.g.x() ? Integer.valueOf(this.g.y()) : null));
            return false;
        }
        boolean z4 = this.g.E() || this.g.F() || this.g.H();
        if (z2 && !z4) {
            this.h.g().n.c("Event filter already evaluated true and it is not associated with an enhanced audience. audience ID, filter ID", Integer.valueOf(this.f1531b), this.g.x() ? Integer.valueOf(this.g.y()) : null);
            return true;
        }
        b.i.a.f.h.l.l0 l0Var2 = this.g;
        String strF = a1Var.F();
        if (!l0Var2.C()) {
            HashSet hashSet = new HashSet();
            Iterator<b.i.a.f.h.l.m0> it2 = l0Var2.A().iterator();
            while (true) {
                if (!it2.hasNext()) {
                    ArrayMap arrayMap = new ArrayMap();
                    Iterator<b.i.a.f.h.l.c1> it3 = a1Var.v().iterator();
                    while (true) {
                        if (!it3.hasNext()) {
                            Iterator<b.i.a.f.h.l.m0> it4 = l0Var2.A().iterator();
                            while (true) {
                                if (!it4.hasNext()) {
                                    bool = Boolean.TRUE;
                                    break;
                                }
                                b.i.a.f.h.l.m0 next = it4.next();
                                boolean z5 = next.z() && next.A();
                                String strC = next.C();
                                if (strC.isEmpty()) {
                                    this.h.g().i.b("Event has empty param name. event", this.h.d().u(strF));
                                    break;
                                }
                                Object obj = arrayMap.get(strC);
                                if (obj instanceof Long) {
                                    if (!next.x()) {
                                        this.h.g().i.c("No number filter for long param. event, param", this.h.d().u(strF), this.h.d().x(strC));
                                        break;
                                    }
                                    Boolean boolB = ea.b(((Long) obj).longValue(), next.y());
                                    if (boolB == null) {
                                        break;
                                    }
                                    if (boolB.booleanValue() == z5) {
                                        bool = Boolean.FALSE;
                                        break;
                                    }
                                } else if (obj instanceof Double) {
                                    if (!next.x()) {
                                        this.h.g().i.c("No number filter for double param. event, param", this.h.d().u(strF), this.h.d().x(strC));
                                        break;
                                    }
                                    double dDoubleValue = ((Double) obj).doubleValue();
                                    try {
                                        boolF = ea.f(new BigDecimal(dDoubleValue), next.y(), Math.ulp(dDoubleValue));
                                    } catch (NumberFormatException unused) {
                                        boolF = null;
                                    }
                                    if (boolF == null) {
                                        break;
                                    }
                                    if (boolF.booleanValue() == z5) {
                                        bool = Boolean.FALSE;
                                        break;
                                    }
                                } else if (obj instanceof String) {
                                    if (!next.v()) {
                                        if (!next.x()) {
                                            this.h.g().i.c("No filter for String param. event, param", this.h.d().u(strF), this.h.d().x(strC));
                                            break;
                                        }
                                        String str = (String) obj;
                                        if (!q9.P(str)) {
                                            this.h.g().i.c("Invalid param value for number filter. event, param", this.h.d().u(strF), this.h.d().x(strC));
                                            break;
                                        }
                                        boolD = ea.d(str, next.y());
                                    } else {
                                        boolD = ea.e((String) obj, next.w(), this.h.g());
                                    }
                                    if (boolD == null) {
                                        break;
                                    }
                                    if (boolD.booleanValue() == z5) {
                                        bool = Boolean.FALSE;
                                        break;
                                    }
                                } else if (obj == null) {
                                    this.h.g().n.c("Missing param for filter. event, param", this.h.d().u(strF), this.h.d().x(strC));
                                    bool = Boolean.FALSE;
                                } else {
                                    this.h.g().i.c("Unknown param type. event, param", this.h.d().u(strF), this.h.d().x(strC));
                                }
                            }
                        } else {
                            b.i.a.f.h.l.c1 next2 = it3.next();
                            if (hashSet.contains(next2.B())) {
                                if (!next2.I()) {
                                    if (!next2.M()) {
                                        if (!next2.F()) {
                                            this.h.g().i.c("Unknown value for param. event, param", this.h.d().u(strF), this.h.d().x(next2.B()));
                                            break;
                                        }
                                        arrayMap.put(next2.B(), next2.G());
                                    } else {
                                        arrayMap.put(next2.B(), next2.M() ? Double.valueOf(next2.N()) : null);
                                    }
                                } else {
                                    arrayMap.put(next2.B(), next2.I() ? Long.valueOf(next2.J()) : null);
                                }
                            }
                        }
                    }
                } else {
                    b.i.a.f.h.l.m0 next3 = it2.next();
                    if (next3.C().isEmpty()) {
                        this.h.g().i.b("null or empty param name in filter. event", this.h.d().u(strF));
                        break;
                    }
                    hashSet.add(next3.C());
                }
            }
        } else {
            Boolean boolB2 = ea.b(j2, l0Var2.D());
            if (boolB2 != null) {
                if (!boolB2.booleanValue()) {
                    bool = Boolean.FALSE;
                }
            }
        }
        this.h.g().n.b("Event filter result", bool != 0 ? bool : "null");
        if (bool == 0) {
            return false;
        }
        Boolean bool2 = Boolean.TRUE;
        this.c = bool2;
        if (!bool.booleanValue()) {
            return true;
        }
        this.d = bool2;
        if (z4 && a1Var.G()) {
            Long lValueOf = Long.valueOf(a1Var.H());
            if (this.g.F()) {
                if (z3 && this.g.C()) {
                    lValueOf = l;
                }
                this.f = lValueOf;
            } else {
                if (z3 && this.g.C()) {
                    lValueOf = l2;
                }
                this.e = lValueOf;
            }
        }
        return true;
    }
}
