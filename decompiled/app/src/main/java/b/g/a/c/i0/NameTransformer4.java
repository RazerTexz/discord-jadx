package b.g.a.c.i0;

import b.d.b.a.outline;
import java.io.Serializable;

/* compiled from: NameTransformer.java */
/* renamed from: b.g.a.c.i0.n, reason: use source file name */
/* loaded from: classes3.dex */
public abstract class NameTransformer4 {
    public static final NameTransformer4 j = new b();

    /* compiled from: NameTransformer.java */
    /* renamed from: b.g.a.c.i0.n$a */
    public static class a extends NameTransformer4 implements Serializable {
        private static final long serialVersionUID = 1;
        public final NameTransformer4 _t1;
        public final NameTransformer4 _t2;

        public a(NameTransformer4 nameTransformer4, NameTransformer4 nameTransformer42) {
            this._t1 = nameTransformer4;
            this._t2 = nameTransformer42;
        }

        @Override // b.g.a.c.i0.NameTransformer4
        public String a(String str) {
            return this._t1.a(this._t2.a(str));
        }

        public String toString() {
            StringBuilder sbU = outline.U("[ChainedTransformer(");
            sbU.append(this._t1);
            sbU.append(", ");
            sbU.append(this._t2);
            sbU.append(")]");
            return sbU.toString();
        }
    }

    /* compiled from: NameTransformer.java */
    /* renamed from: b.g.a.c.i0.n$b */
    public static final class b extends NameTransformer4 implements Serializable {
        private static final long serialVersionUID = 1;

        @Override // b.g.a.c.i0.NameTransformer4
        public String a(String str) {
            return str;
        }
    }

    public abstract String a(String str);
}
