package b.i.e.q.r.f.d;

import b.i.e.n.BitArray;

/* compiled from: AI01320xDecoder.java */
/* renamed from: b.i.e.q.r.f.d.b, reason: use source file name */
/* loaded from: classes3.dex */
public final class AI01320xDecoder extends AI013x0xDecoder {
    public AI01320xDecoder(BitArray bitArray) {
        super(bitArray);
    }

    @Override // b.i.e.q.r.f.d.AI01weightDecoder
    public void d(StringBuilder sb, int i) {
        if (i < 10000) {
            sb.append("(3202)");
        } else {
            sb.append("(3203)");
        }
    }

    @Override // b.i.e.q.r.f.d.AI01weightDecoder
    public int e(int i) {
        return i < 10000 ? i : i - 10000;
    }
}
