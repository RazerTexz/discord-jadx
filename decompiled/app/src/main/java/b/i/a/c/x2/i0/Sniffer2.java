package b.i.a.c.x2.i0;

import b.i.a.c.f3.ParsableByteArray;
import b.i.a.c.x2.ExtractorInput;
import com.discord.api.permission.Permission;
import java.io.IOException;

/* compiled from: Sniffer.java */
/* renamed from: b.i.a.c.x2.i0.l, reason: use source file name */
/* loaded from: classes3.dex */
public final class Sniffer2 {
    public static final int[] a = {1769172845, 1769172786, 1769172787, 1769172788, 1769172789, 1769172790, 1769172793, 1635148593, 1752589105, 1751479857, 1635135537, 1836069937, 1836069938, 862401121, 862401122, 862417462, 862417718, 862414134, 862414646, 1295275552, 1295270176, 1714714144, 1801741417, 1295275600, 1903435808, 1297305174, 1684175153, 1769172332, 1885955686};

    /* JADX WARN: Removed duplicated region for block: B:101:0x00e5 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:98:0x00e3 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean a(ExtractorInput extractorInput, boolean z2, boolean z3) throws IOException {
        boolean z4;
        boolean z5;
        long jB = extractorInput.b();
        long j = Permission.SEND_TTS_MESSAGES;
        long j2 = -1;
        if (jB != -1 && jB <= Permission.SEND_TTS_MESSAGES) {
            j = jB;
        }
        int i = (int) j;
        ParsableByteArray parsableByteArray = new ParsableByteArray(64);
        boolean z6 = false;
        int i2 = 0;
        boolean z7 = false;
        while (i2 < i) {
            parsableByteArray.A(8);
            if (!extractorInput.e(parsableByteArray.a, z6 ? 1 : 0, 8, true)) {
                break;
            }
            long jU = parsableByteArray.u();
            int iF = parsableByteArray.f();
            int i3 = 16;
            if (jU == 1) {
                extractorInput.o(parsableByteArray.a, 8, 8);
                parsableByteArray.D(16);
                jU = parsableByteArray.m();
            } else {
                if (jU == 0) {
                    long jB2 = extractorInput.b();
                    if (jB2 != j2) {
                        jU = (jB2 - extractorInput.f()) + 8;
                    }
                }
                i3 = 8;
            }
            long j3 = i3;
            if (jU < j3) {
                return z6;
            }
            i2 += i3;
            if (iF == 1836019574) {
                i += (int) jU;
                if (jB != -1 && i > jB) {
                    i = (int) jB;
                }
                j2 = -1;
            } else {
                if (iF == 1836019558 || iF == 1836475768) {
                    z4 = true;
                    break;
                }
                long j4 = jB;
                if ((i2 + jU) - j3 >= i) {
                    break;
                }
                int i4 = (int) (jU - j3);
                i2 += i4;
                if (iF == 1718909296) {
                    if (i4 < 8) {
                        return false;
                    }
                    parsableByteArray.A(i4);
                    extractorInput.o(parsableByteArray.a, 0, i4);
                    int i5 = i4 / 4;
                    int i6 = 0;
                    while (true) {
                        if (i6 >= i5) {
                            break;
                        }
                        if (i6 != 1) {
                            int iF2 = parsableByteArray.f();
                            if ((iF2 >>> 8) != 3368816 && (iF2 != 1751476579 || !z3)) {
                                for (int i7 : a) {
                                    if (i7 == iF2) {
                                        z5 = true;
                                        break;
                                    }
                                }
                                z5 = false;
                                if (!z5) {
                                    z7 = true;
                                    break;
                                }
                            } else {
                                z5 = true;
                                if (!z5) {
                                }
                            }
                        } else {
                            parsableByteArray.F(4);
                        }
                        i6++;
                    }
                    if (!z7) {
                        return false;
                    }
                } else if (i4 != 0) {
                    extractorInput.g(i4);
                }
                jB = j4;
                j2 = -1;
                z6 = false;
            }
        }
        z4 = false;
        return z7 && z2 == z4;
    }
}
