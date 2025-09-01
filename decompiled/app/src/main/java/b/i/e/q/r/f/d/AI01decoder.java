package b.i.e.q.r.f.d;

import b.i.e.n.BitArray;

/* compiled from: AI01decoder.java */
/* renamed from: b.i.e.q.r.f.d.h, reason: use source file name */
/* loaded from: classes3.dex */
public abstract class AI01decoder extends AbstractExpandedDecoder {
    public AI01decoder(BitArray bitArray) {
        super(bitArray);
    }

    public final void b(StringBuilder sb, int i) {
        sb.append("(01)");
        int length = sb.length();
        sb.append('9');
        c(sb, i, length);
    }

    public final void c(StringBuilder sb, int i, int i2) {
        for (int i3 = 0; i3 < 4; i3++) {
            int iC = this.f1867b.c((i3 * 10) + i, 10);
            if (iC / 100 == 0) {
                sb.append('0');
            }
            if (iC / 10 == 0) {
                sb.append('0');
            }
            sb.append(iC);
        }
        int i4 = 0;
        for (int i5 = 0; i5 < 13; i5++) {
            int iCharAt = sb.charAt(i5 + i2) - '0';
            if ((i5 & 1) == 0) {
                iCharAt *= 3;
            }
            i4 += iCharAt;
        }
        int i6 = 10 - (i4 % 10);
        sb.append(i6 != 10 ? i6 : 0);
    }
}
