package b.i.e.q.r.f.d;

import b.i.e.n.BitArray;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;

/* compiled from: AI01393xDecoder.java */
/* renamed from: b.i.e.q.r.f.d.d, reason: use source file name */
/* loaded from: classes3.dex */
public final class AI01393xDecoder extends AI01decoder {
    public AI01393xDecoder(BitArray bitArray) {
        super(bitArray);
    }

    @Override // b.i.e.q.r.f.d.AbstractExpandedDecoder
    public String a() throws NotFoundException, FormatException {
        if (this.a.k < 48) {
            throw NotFoundException.l;
        }
        StringBuilder sb = new StringBuilder();
        b(sb, 8);
        int iC = this.f1867b.c(48, 2);
        sb.append("(393");
        sb.append(iC);
        sb.append(')');
        int iC2 = this.f1867b.c(50, 10);
        if (iC2 / 100 == 0) {
            sb.append('0');
        }
        if (iC2 / 10 == 0) {
            sb.append('0');
        }
        sb.append(iC2);
        sb.append(this.f1867b.b(60, null).f1871b);
        return sb.toString();
    }
}
