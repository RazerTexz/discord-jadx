package b.i.a.c.g3;

import androidx.annotation.Nullable;
import b.i.a.c.f3.CodecSpecificDataUtil;
import b.i.a.c.f3.NalUnitUtil;
import b.i.a.c.f3.ParsableByteArray;
import com.google.android.exoplayer2.ParserException;
import java.util.Collections;
import java.util.List;
import org.objectweb.asm.Opcodes;

/* compiled from: HevcConfig.java */
/* renamed from: b.i.a.c.g3.q, reason: use source file name */
/* loaded from: classes3.dex */
public final class HevcConfig {
    public final List<byte[]> a;

    /* renamed from: b, reason: collision with root package name */
    public final int f989b;
    public final float c;

    @Nullable
    public final String d;

    public HevcConfig(List<byte[]> list, int i, int i2, int i3, float f, @Nullable String str) {
        this.a = list;
        this.f989b = i;
        this.c = f;
        this.d = str;
    }

    public static HevcConfig a(ParsableByteArray parsableByteArray) throws ParserException {
        int i;
        int i2;
        try {
            parsableByteArray.F(21);
            int iT = parsableByteArray.t() & 3;
            int iT2 = parsableByteArray.t();
            int i3 = parsableByteArray.f984b;
            int i4 = 0;
            int i5 = 0;
            for (int i6 = 0; i6 < iT2; i6++) {
                parsableByteArray.F(1);
                int iY = parsableByteArray.y();
                for (int i7 = 0; i7 < iY; i7++) {
                    int iY2 = parsableByteArray.y();
                    i5 += iY2 + 4;
                    parsableByteArray.F(iY2);
                }
            }
            parsableByteArray.E(i3);
            byte[] bArr = new byte[i5];
            String strB = null;
            int i8 = 0;
            int i9 = 0;
            int i10 = -1;
            int i11 = -1;
            float f = 1.0f;
            while (i8 < iT2) {
                int iT3 = parsableByteArray.t() & Opcodes.LAND;
                int iY3 = parsableByteArray.y();
                int i12 = 0;
                while (i12 < iY3) {
                    int iY4 = parsableByteArray.y();
                    byte[] bArr2 = NalUnitUtil.a;
                    int i13 = iT2;
                    System.arraycopy(bArr2, i4, bArr, i9, bArr2.length);
                    int length = i9 + bArr2.length;
                    System.arraycopy(parsableByteArray.a, parsableByteArray.f984b, bArr, length, iY4);
                    if (iT3 == 33 && i12 == 0) {
                        NalUnitUtil.a aVarC = NalUnitUtil.c(bArr, length, length + iY4);
                        int i14 = aVarC.g;
                        i11 = aVarC.h;
                        f = aVarC.i;
                        i = iT3;
                        i2 = iY3;
                        i10 = i14;
                        strB = CodecSpecificDataUtil.b(aVarC.a, aVarC.f979b, aVarC.c, aVarC.d, aVarC.e, aVarC.f);
                    } else {
                        i = iT3;
                        i2 = iY3;
                    }
                    i9 = length + iY4;
                    parsableByteArray.F(iY4);
                    i12++;
                    iT2 = i13;
                    iT3 = i;
                    iY3 = i2;
                    i4 = 0;
                }
                i8++;
                i4 = 0;
            }
            return new HevcConfig(i5 == 0 ? Collections.emptyList() : Collections.singletonList(bArr), iT + 1, i10, i11, f, strB);
        } catch (ArrayIndexOutOfBoundsException e) {
            throw ParserException.a("Error parsing HEVC config", e);
        }
    }
}
