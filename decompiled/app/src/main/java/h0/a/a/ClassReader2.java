package h0.a.a;

import androidx.core.view.InputDeviceCompat;
import androidx.core.view.ViewCompat;
import b.d.b.a.outline;
import java.util.Objects;
import org.objectweb.asm.Opcodes;

/* compiled from: ClassReader.java */
/* renamed from: h0.a.a.d, reason: use source file name */
/* loaded from: classes3.dex */
public class ClassReader2 {
    public final byte[] a;

    /* renamed from: b, reason: collision with root package name */
    public final int[] f3700b;
    public final String[] c;
    public final ConstantDynamic2[] d;
    public final int[] e;
    public final int f;
    public final int g;

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public ClassReader2(byte[] bArr, int i, boolean z2) {
        int i2;
        this.a = bArr;
        if (z2) {
            int i3 = i + 6;
            if (q(i3) > 56) {
                StringBuilder sbU = outline.U("Unsupported class file major version ");
                sbU.append((int) q(i3));
                throw new IllegalArgumentException(sbU.toString());
            }
        }
        int iU = u(i + 8);
        this.f3700b = new int[iU];
        this.c = new String[iU];
        int i4 = i + 10;
        int i5 = 1;
        int i6 = 0;
        boolean z3 = false;
        boolean z4 = false;
        while (true) {
            int iU2 = 4;
            if (i5 >= iU) {
                this.f = i6;
                this.g = i4;
                int[] iArr = null;
                this.d = z3 ? new ConstantDynamic2[iU] : null;
                if (z3 | z4) {
                    char[] cArr = new char[i6];
                    int iC = c();
                    int iU3 = u(iC - 2);
                    while (true) {
                        if (iU3 > 0) {
                            String strT = t(iC, cArr);
                            int iL = l(iC + 2);
                            int i7 = iC + 6;
                            if ("BootstrapMethods".equals(strT)) {
                                int iU4 = u(i7);
                                int[] iArr2 = new int[iU4];
                                int iU5 = i7 + 2;
                                for (int i8 = 0; i8 < iU4; i8++) {
                                    iArr2[i8] = iU5;
                                    iU5 += (u(iU5 + 2) * 2) + 4;
                                }
                                iArr = iArr2;
                            } else {
                                iC = i7 + iL;
                                iU3--;
                            }
                        }
                    }
                }
                this.e = iArr;
                return;
            }
            int i9 = i5 + 1;
            int i10 = i4 + 1;
            this.f3700b[i5] = i10;
            switch (bArr[i4]) {
                case 1:
                    iU2 = u(i10) + 3;
                    if (iU2 > i6) {
                        i6 = iU2;
                    }
                    i2 = iU2;
                    i4 += i2;
                    i5 = i9;
                case 2:
                case 13:
                case 14:
                default:
                    throw new IllegalArgumentException();
                case 3:
                case 4:
                case 9:
                case 10:
                case 11:
                case 12:
                    i2 = 5;
                    i4 += i2;
                    i5 = i9;
                case 5:
                case 6:
                    iU2 = 9;
                    i9++;
                    i2 = iU2;
                    i4 += i2;
                    i5 = i9;
                case 7:
                case 8:
                case 16:
                case 19:
                case 20:
                    i2 = 3;
                    i4 += i2;
                    i5 = i9;
                case 15:
                    i2 = iU2;
                    i4 += i2;
                    i5 = i9;
                case 17:
                    z3 = true;
                    i2 = 5;
                    i4 += i2;
                    i5 = i9;
                case 18:
                    z4 = true;
                    i2 = 5;
                    i4 += i2;
                    i5 = i9;
            }
        }
    }

    public final void a(int i, Label2[] label2Arr) {
        if (label2Arr[i] == null) {
            if (label2Arr[i] == null) {
                label2Arr[i] = new Label2();
            }
            Label2 label2 = label2Arr[i];
            label2.f3714b = (short) (label2.f3714b | 1);
        }
    }

    public final Label2 b(int i, Label2[] label2Arr) {
        if (label2Arr[i] == null) {
            label2Arr[i] = new Label2();
        }
        Label2 label2 = label2Arr[i];
        label2.f3714b = (short) (label2.f3714b & (-2));
        return label2;
    }

    public final int c() {
        int i = this.g;
        int iU = (u(i + 6) * 2) + i + 8;
        int iU2 = u(iU);
        int iL = iU + 2;
        while (true) {
            int i2 = iU2 - 1;
            if (iU2 <= 0) {
                break;
            }
            int iU3 = u(iL + 6);
            iL += 8;
            while (true) {
                int i3 = iU3 - 1;
                if (iU3 > 0) {
                    iL += l(iL + 2) + 6;
                    iU3 = i3;
                }
            }
            iU2 = i2;
        }
        int iU4 = u(iL);
        int iL2 = iL + 2;
        while (true) {
            int i4 = iU4 - 1;
            if (iU4 <= 0) {
                return iL2 + 2;
            }
            int iU5 = u(iL2 + 6);
            iL2 += 8;
            while (true) {
                int i5 = iU5 - 1;
                if (iU5 > 0) {
                    iL2 += l(iL2 + 2) + 6;
                    iU5 = i5;
                }
            }
            iU4 = i4;
        }
    }

    public final int d(int[] iArr, int i) {
        if (iArr == null || i >= iArr.length || f(iArr[i]) < 67) {
            return -1;
        }
        return u(iArr[i] + 1);
    }

    public final Attribute2 e(Attribute2[] attribute2Arr, String str, int i, int i2, char[] cArr, int i3, Label2[] label2Arr) {
        for (Attribute2 attribute2 : attribute2Arr) {
            if (attribute2.a.equals(str)) {
                Attribute2 attribute22 = new Attribute2(attribute2.a);
                byte[] bArr = new byte[i2];
                attribute22.f3697b = bArr;
                System.arraycopy(this.a, i, bArr, 0, i2);
                return attribute22;
            }
        }
        Attribute2 attribute23 = new Attribute2(str);
        byte[] bArr2 = new byte[i2];
        attribute23.f3697b = bArr2;
        System.arraycopy(this.a, i, bArr2, 0, i2);
        return attribute23;
    }

    public int f(int i) {
        return this.a[i] & 255;
    }

    public String g(int i, char[] cArr) {
        return t(this.f3700b[u(i)], cArr);
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:138:0x036d. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:151:0x03ab  */
    /* JADX WARN: Removed duplicated region for block: B:208:0x04bd  */
    /* JADX WARN: Removed duplicated region for block: B:267:0x066f  */
    /* JADX WARN: Removed duplicated region for block: B:271:0x0683  */
    /* JADX WARN: Removed duplicated region for block: B:276:0x0695  */
    /* JADX WARN: Removed duplicated region for block: B:278:0x06b7  */
    /* JADX WARN: Removed duplicated region for block: B:293:0x06f7  */
    /* JADX WARN: Removed duplicated region for block: B:294:0x070b  */
    /* JADX WARN: Removed duplicated region for block: B:304:0x0755  */
    /* JADX WARN: Removed duplicated region for block: B:309:0x077e  */
    /* JADX WARN: Removed duplicated region for block: B:311:0x078f  */
    /* JADX WARN: Removed duplicated region for block: B:329:0x0845  */
    /* JADX WARN: Removed duplicated region for block: B:342:0x089e  */
    /* JADX WARN: Removed duplicated region for block: B:350:0x092f  */
    /* JADX WARN: Removed duplicated region for block: B:354:0x0972  */
    /* JADX WARN: Removed duplicated region for block: B:355:0x098c  */
    /* JADX WARN: Removed duplicated region for block: B:356:0x09a6  */
    /* JADX WARN: Removed duplicated region for block: B:357:0x09be  */
    /* JADX WARN: Removed duplicated region for block: B:359:0x09d8  */
    /* JADX WARN: Removed duplicated region for block: B:360:0x09f1  */
    /* JADX WARN: Removed duplicated region for block: B:364:0x0a17  */
    /* JADX WARN: Removed duplicated region for block: B:365:0x0a31  */
    /* JADX WARN: Removed duplicated region for block: B:366:0x0a4b  */
    /* JADX WARN: Removed duplicated region for block: B:368:0x0a63  */
    /* JADX WARN: Removed duplicated region for block: B:371:0x0a80  */
    /* JADX WARN: Removed duplicated region for block: B:375:0x0a87  */
    /* JADX WARN: Removed duplicated region for block: B:379:0x0ab0  */
    /* JADX WARN: Removed duplicated region for block: B:383:0x0ab7  */
    /* JADX WARN: Removed duplicated region for block: B:384:0x0ad9  */
    /* JADX WARN: Removed duplicated region for block: B:494:0x068f A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void h(MethodVisitor2 methodVisitor2, Context3 context3, int i) {
        Label2[] label2Arr;
        int i2;
        Label2[] label2Arr2;
        int i3;
        Attribute2 attribute2;
        int i4;
        int i5;
        Attribute2 attribute22;
        int[] iArr;
        String strT;
        int i6;
        int i7;
        boolean z2;
        int i8;
        boolean z3;
        boolean z4;
        int i9;
        int i10;
        int iD;
        int i11;
        boolean z5;
        int[] iArr2;
        boolean z6;
        int i12;
        boolean z7;
        int i13;
        int iD2;
        boolean z8;
        int i14;
        int i15;
        int[] iArr3;
        int[] iArr4;
        int i16;
        int i17;
        int i18;
        boolean z9;
        int i19;
        int i20;
        int i21;
        Label2[] label2Arr3;
        int i22;
        int iU;
        int iX;
        short s2;
        Label2[] label2Arr4;
        int i23;
        int iU2;
        int i24;
        int i25;
        int[] iArr5;
        Label2[] label2Arr5;
        int i26;
        int i27;
        Label2[] label2Arr6;
        int i28;
        int i29;
        int[] iArrS;
        int i30;
        int[] iArr6;
        Label2[] label2Arr7;
        int i31;
        int i32;
        int i33;
        int i34;
        byte[] bArr = this.a;
        char[] cArr = context3.c;
        int iU3 = u(i);
        int iU4 = u(i + 2);
        int iL = l(i + 4);
        int i35 = i + 8;
        int i36 = i35 + iL;
        Label2[] label2Arr8 = new Label2[iL + 1];
        context3.g = label2Arr8;
        int i37 = i35;
        while (i37 < i36) {
            int i38 = i37 - i35;
            switch (bArr[i37] & 255) {
                case 0:
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                case 7:
                case 8:
                case 9:
                case 10:
                case 11:
                case 12:
                case 13:
                case 14:
                case 15:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                case 42:
                case 43:
                case 44:
                case 45:
                case 46:
                case 47:
                case 48:
                case 49:
                case 50:
                case 51:
                case 52:
                case 53:
                case 59:
                case 60:
                case 61:
                case 62:
                case 63:
                case 64:
                case 65:
                case 66:
                case 67:
                case 68:
                case 69:
                case 70:
                case 71:
                case 72:
                case 73:
                case 74:
                case 75:
                case 76:
                case 77:
                case 78:
                case 79:
                case 80:
                case 81:
                case 82:
                case 83:
                case 84:
                case 85:
                case 86:
                case 87:
                case 88:
                case 89:
                case 90:
                case 91:
                case 92:
                case 93:
                case 94:
                case 95:
                case 96:
                case 97:
                case 98:
                case 99:
                case 100:
                case 101:
                case 102:
                case 103:
                case 104:
                case 105:
                case 106:
                case 107:
                case 108:
                case 109:
                case 110:
                case 111:
                case 112:
                case 113:
                case 114:
                case 115:
                case 116:
                case 117:
                case 118:
                case 119:
                case 120:
                case 121:
                case 122:
                case 123:
                case 124:
                case Opcodes.LUSHR /* 125 */:
                case 126:
                case Opcodes.LAND /* 127 */:
                case 128:
                case Opcodes.LOR /* 129 */:
                case 130:
                case Opcodes.LXOR /* 131 */:
                case Opcodes.I2L /* 133 */:
                case Opcodes.I2F /* 134 */:
                case Opcodes.I2D /* 135 */:
                case Opcodes.L2I /* 136 */:
                case Opcodes.L2F /* 137 */:
                case Opcodes.L2D /* 138 */:
                case Opcodes.F2I /* 139 */:
                case Opcodes.F2L /* 140 */:
                case Opcodes.F2D /* 141 */:
                case Opcodes.D2I /* 142 */:
                case Opcodes.D2L /* 143 */:
                case Opcodes.D2F /* 144 */:
                case Opcodes.I2B /* 145 */:
                case Opcodes.I2C /* 146 */:
                case Opcodes.I2S /* 147 */:
                case Opcodes.LCMP /* 148 */:
                case Opcodes.FCMPL /* 149 */:
                case 150:
                case Opcodes.DCMPL /* 151 */:
                case Opcodes.DCMPG /* 152 */:
                case Opcodes.IRETURN /* 172 */:
                case Opcodes.LRETURN /* 173 */:
                case Opcodes.FRETURN /* 174 */:
                case 175:
                case Opcodes.ARETURN /* 176 */:
                case Opcodes.RETURN /* 177 */:
                case Opcodes.ARRAYLENGTH /* 190 */:
                case Opcodes.ATHROW /* 191 */:
                case Opcodes.MONITORENTER /* 194 */:
                case Opcodes.MONITOREXIT /* 195 */:
                    i37++;
                case 16:
                case 18:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 54:
                case 55:
                case 56:
                case 57:
                case 58:
                case Opcodes.RET /* 169 */:
                case Opcodes.NEWARRAY /* 188 */:
                    i37 += 2;
                case 17:
                case 19:
                case 20:
                case Opcodes.IINC /* 132 */:
                case Opcodes.GETSTATIC /* 178 */:
                case Opcodes.PUTSTATIC /* 179 */:
                case 180:
                case Opcodes.PUTFIELD /* 181 */:
                case Opcodes.INVOKEVIRTUAL /* 182 */:
                case Opcodes.INVOKESPECIAL /* 183 */:
                case Opcodes.INVOKESTATIC /* 184 */:
                case Opcodes.NEW /* 187 */:
                case Opcodes.ANEWARRAY /* 189 */:
                case Opcodes.CHECKCAST /* 192 */:
                case Opcodes.INSTANCEOF /* 193 */:
                    i37 += 3;
                case 153:
                case 154:
                case 155:
                case 156:
                case 157:
                case 158:
                case Opcodes.IF_ICMPEQ /* 159 */:
                case Opcodes.IF_ICMPNE /* 160 */:
                case Opcodes.IF_ICMPLT /* 161 */:
                case Opcodes.IF_ICMPGE /* 162 */:
                case Opcodes.IF_ICMPGT /* 163 */:
                case Opcodes.IF_ICMPLE /* 164 */:
                case Opcodes.IF_ACMPEQ /* 165 */:
                case Opcodes.IF_ACMPNE /* 166 */:
                case Opcodes.GOTO /* 167 */:
                case Opcodes.JSR /* 168 */:
                case Opcodes.IFNULL /* 198 */:
                case Opcodes.IFNONNULL /* 199 */:
                    b(q(i37 + 1) + i38, label2Arr8);
                    i37 += 3;
                case Opcodes.TABLESWITCH /* 170 */:
                    int i39 = (4 - (i38 & 3)) + i37;
                    b(l(i39) + i38, label2Arr8);
                    int iL2 = (l(i39 + 8) - l(i39 + 4)) + 1;
                    i34 = i39 + 12;
                    while (true) {
                        int i40 = iL2 - 1;
                        if (iL2 > 0) {
                            b(l(i34) + i38, label2Arr8);
                            i34 += 4;
                            iL2 = i40;
                        } else {
                            i37 = i34;
                        }
                    }
                case Opcodes.LOOKUPSWITCH /* 171 */:
                    int i41 = (4 - (i38 & 3)) + i37;
                    b(l(i41) + i38, label2Arr8);
                    int iL3 = l(i41 + 4);
                    i34 = i41 + 8;
                    while (true) {
                        int i42 = iL3 - 1;
                        if (iL3 > 0) {
                            b(l(i34 + 4) + i38, label2Arr8);
                            i34 += 8;
                            iL3 = i42;
                        } else {
                            i37 = i34;
                        }
                    }
                case Opcodes.INVOKEINTERFACE /* 185 */:
                case Opcodes.INVOKEDYNAMIC /* 186 */:
                    i37 += 5;
                case 196:
                    int i43 = bArr[i37 + 1] & 255;
                    if (i43 != 132) {
                        if (i43 != 169) {
                            switch (i43) {
                                default:
                                    switch (i43) {
                                        case 54:
                                        case 55:
                                        case 56:
                                        case 57:
                                        case 58:
                                            break;
                                        default:
                                            throw new IllegalArgumentException();
                                    }
                                case 21:
                                case 22:
                                case 23:
                                case 24:
                                case 25:
                                    i37 += 4;
                            }
                        }
                        i37 += 4;
                    } else {
                        i37 += 6;
                    }
                case Opcodes.MULTIANEWARRAY /* 197 */:
                    i37 += 4;
                case 200:
                case 201:
                case 220:
                    b(l(i37 + 1) + i38, label2Arr8);
                    i37 += 5;
                case 202:
                case 203:
                case 204:
                case 205:
                case 206:
                case 207:
                case 208:
                case 209:
                case 210:
                case 211:
                case 212:
                case 213:
                case 214:
                case 215:
                case 216:
                case 217:
                case 218:
                case 219:
                    b(u(i37 + 1) + i38, label2Arr8);
                    i37 += 3;
                default:
                    throw new IllegalArgumentException();
            }
        }
        int iU5 = u(i37);
        int i44 = i37 + 2;
        while (true) {
            int i45 = iU5 - 1;
            if (iU5 > 0) {
                Label2 label2B = b(u(i44), label2Arr8);
                Label2 label2B2 = b(u(i44 + 2), label2Arr8);
                Label2 label2B3 = b(u(i44 + 4), label2Arr8);
                String strT2 = t(this.f3700b[u(i44 + 6)], cArr);
                i44 += 8;
                MethodWriter2 methodWriter2 = (MethodWriter2) methodVisitor2;
                if (strT2 != null) {
                    i32 = i36;
                    i33 = methodWriter2.d.m(7, strT2).a;
                } else {
                    i32 = i36;
                    i33 = 0;
                }
                Handler5 handler5 = new Handler5(label2B, label2B2, label2B3, i33, strT2);
                if (methodWriter2.m == null) {
                    methodWriter2.m = handler5;
                } else {
                    methodWriter2.n.f = handler5;
                }
                methodWriter2.n = handler5;
                iU5 = i45;
                i36 = i32;
            } else {
                int i46 = i36;
                int iU6 = u(i44);
                int i47 = i44 + 2;
                int[] iArr7 = null;
                boolean z10 = true;
                int i48 = 0;
                Attribute2 attribute23 = null;
                int i49 = 0;
                int[] iArrS2 = null;
                int i50 = 0;
                int i51 = 0;
                while (true) {
                    int i52 = iU6 - 1;
                    if (iU6 > 0) {
                        String strT3 = t(i47, cArr);
                        int iL4 = l(i47 + 2);
                        int i53 = i47 + 6;
                        if ("LocalVariableTable".equals(strT3)) {
                            if ((context3.f3707b & 2) == 0) {
                                int iU7 = u(i53);
                                int i54 = i53 + 2;
                                while (true) {
                                    int i55 = iU7 - 1;
                                    if (iU7 > 0) {
                                        int iU8 = u(i54);
                                        a(iU8, label2Arr8);
                                        a(u(i54 + 2) + iU8, label2Arr8);
                                        i54 += 10;
                                        iU7 = i55;
                                    } else {
                                        i50 = i53;
                                        iArrS = iArr7;
                                        label2Arr5 = label2Arr8;
                                        i26 = iL;
                                        iArr7 = iArrS;
                                        i27 = i53;
                                        i28 = i46;
                                        label2Arr6 = label2Arr5;
                                        i29 = i26;
                                    }
                                }
                            }
                            iArr5 = iArr7;
                            label2Arr5 = label2Arr8;
                            i26 = iL;
                            iArrS = iArr5;
                            iArr7 = iArrS;
                            i27 = i53;
                            i28 = i46;
                            label2Arr6 = label2Arr5;
                            i29 = i26;
                        } else if ("LocalVariableTypeTable".equals(strT3)) {
                            i51 = i53;
                            iArrS = iArr7;
                            label2Arr5 = label2Arr8;
                            i26 = iL;
                            iArr7 = iArrS;
                            i27 = i53;
                            i28 = i46;
                            label2Arr6 = label2Arr5;
                            i29 = i26;
                        } else if ("LineNumberTable".equals(strT3)) {
                            if ((context3.f3707b & 2) == 0) {
                                int iU9 = u(i53);
                                int i56 = i53 + 2;
                                while (true) {
                                    int i57 = iU9 - 1;
                                    if (iU9 > 0) {
                                        int iU10 = u(i56);
                                        int iU11 = u(i56 + 2);
                                        int i58 = i56 + 4;
                                        a(iU10, label2Arr8);
                                        Label2 label2 = label2Arr8[iU10];
                                        if (label2.c == 0) {
                                            label2.c = (short) iU11;
                                            i30 = i58;
                                            iArr6 = iArr7;
                                            label2Arr7 = label2Arr8;
                                            i31 = iL;
                                        } else {
                                            if (label2.d == null) {
                                                i30 = i58;
                                                label2.d = new int[4];
                                            } else {
                                                i30 = i58;
                                            }
                                            int[] iArr8 = label2.d;
                                            iArr6 = iArr7;
                                            int i59 = iArr8[0] + 1;
                                            iArr8[0] = i59;
                                            if (i59 >= iArr8.length) {
                                                int[] iArr9 = new int[iArr8.length + 4];
                                                label2Arr7 = label2Arr8;
                                                i31 = iL;
                                                System.arraycopy(iArr8, 0, iArr9, 0, iArr8.length);
                                                label2.d = iArr9;
                                            } else {
                                                label2Arr7 = label2Arr8;
                                                i31 = iL;
                                            }
                                            label2.d[i59] = iU11;
                                        }
                                        iU9 = i57;
                                        i56 = i30;
                                        iArr7 = iArr6;
                                        label2Arr8 = label2Arr7;
                                        iL = i31;
                                    }
                                }
                            }
                            iArr5 = iArr7;
                            label2Arr5 = label2Arr8;
                            i26 = iL;
                            iArrS = iArr5;
                            iArr7 = iArrS;
                            i27 = i53;
                            i28 = i46;
                            label2Arr6 = label2Arr5;
                            i29 = i26;
                        } else {
                            iArr5 = iArr7;
                            label2Arr5 = label2Arr8;
                            i26 = iL;
                            if ("RuntimeVisibleTypeAnnotations".equals(strT3)) {
                                iArrS = s(methodVisitor2, context3, i53, true);
                                iArr7 = iArrS;
                                i27 = i53;
                                i28 = i46;
                                label2Arr6 = label2Arr5;
                                i29 = i26;
                            } else if ("RuntimeInvisibleTypeAnnotations".equals(strT3)) {
                                iArrS2 = s(methodVisitor2, context3, i53, false);
                                iArrS = iArr5;
                                iArr7 = iArrS;
                                i27 = i53;
                                i28 = i46;
                                label2Arr6 = label2Arr5;
                                i29 = i26;
                            } else {
                                if ("StackMapTable".equals(strT3)) {
                                    if ((context3.f3707b & 4) == 0) {
                                        i48 = i53 + 2;
                                        i49 = i53 + iL4;
                                    }
                                } else if (!"StackMap".equals(strT3)) {
                                    i27 = i53;
                                    label2Arr6 = label2Arr5;
                                    i28 = i46;
                                    i29 = i26;
                                    Attribute2 attribute2E = e(context3.a, strT3, i53, iL4, cArr, i, label2Arr6);
                                    attribute2E.c = attribute23;
                                    attribute23 = attribute2E;
                                    iArr7 = iArr5;
                                } else if ((context3.f3707b & 4) == 0) {
                                    i48 = i53 + 2;
                                    i49 = i53 + iL4;
                                    i27 = i53;
                                    i28 = i46;
                                    iArr7 = iArr5;
                                    label2Arr6 = label2Arr5;
                                    i29 = i26;
                                    z10 = false;
                                }
                                iArrS = iArr5;
                                iArr7 = iArrS;
                                i27 = i53;
                                i28 = i46;
                                label2Arr6 = label2Arr5;
                                i29 = i26;
                            }
                        }
                        i47 = i27 + iL4;
                        label2Arr8 = label2Arr6;
                        iU6 = i52;
                        i46 = i28;
                        iL = i29;
                    } else {
                        int[] iArr10 = iArr7;
                        Label2[] label2Arr9 = label2Arr8;
                        int i60 = iL;
                        int i61 = i46;
                        Attribute2 attribute24 = attribute23;
                        boolean z11 = (context3.f3707b & 8) != 0;
                        if (i48 != 0) {
                            context3.m = -1;
                            context3.n = 0;
                            context3.o = 0;
                            context3.p = 0;
                            Object[] objArr = new Object[iU4];
                            context3.q = objArr;
                            context3.r = 0;
                            context3.f3708s = new Object[iU3];
                            if (z11) {
                                String str = context3.f;
                                if ((context3.d & 8) == 0) {
                                    if ("<init>".equals(context3.e)) {
                                        objArr[0] = Opcodes2.g;
                                    } else {
                                        objArr[0] = g(this.g + 2, context3.c);
                                    }
                                    i24 = 1;
                                } else {
                                    i24 = 0;
                                }
                                int i62 = i24;
                                int i63 = 1;
                                while (true) {
                                    int i64 = i63 + 1;
                                    char cCharAt = str.charAt(i63);
                                    if (cCharAt == 'F') {
                                        i25 = i62 + 1;
                                        objArr[i62] = Opcodes2.c;
                                    } else if (cCharAt == 'L') {
                                        int i65 = i64;
                                        while (str.charAt(i65) != ';') {
                                            i65++;
                                        }
                                        objArr[i62] = str.substring(i64, i65);
                                        i62++;
                                        i63 = i65 + 1;
                                    } else if (cCharAt == 'S' || cCharAt == 'I') {
                                        i25 = i62 + 1;
                                        objArr[i62] = Opcodes2.f3723b;
                                    } else if (cCharAt == 'J') {
                                        i25 = i62 + 1;
                                        objArr[i62] = Opcodes2.e;
                                    } else if (cCharAt != 'Z') {
                                        if (cCharAt != '[') {
                                            switch (cCharAt) {
                                                case 'D':
                                                    i25 = i62 + 1;
                                                    objArr[i62] = Opcodes2.d;
                                                    break;
                                            }
                                            context3.o = i62;
                                        } else {
                                            while (str.charAt(i64) == '[') {
                                                i64++;
                                            }
                                            if (str.charAt(i64) == 'L') {
                                                do {
                                                    i64++;
                                                } while (str.charAt(i64) != ';');
                                            }
                                            int i66 = i64 + 1;
                                            objArr[i62] = str.substring(i63, i66);
                                            i63 = i66;
                                            i62++;
                                        }
                                    }
                                    i62 = i25;
                                    i63 = i64;
                                }
                            }
                            int i67 = i48;
                            while (true) {
                                i2 = i49;
                                if (i67 < i2 - 2) {
                                    if (bArr[i67] != 8 || (iU2 = u(i67 + 1)) < 0) {
                                        label2Arr4 = label2Arr9;
                                        i23 = i60;
                                    } else {
                                        i23 = i60;
                                        if (iU2 < i23) {
                                            if ((bArr[i35 + iU2] & 255) == 187) {
                                                label2Arr4 = label2Arr9;
                                                b(iU2, label2Arr4);
                                            } else {
                                                label2Arr4 = label2Arr9;
                                            }
                                            i67++;
                                            label2Arr9 = label2Arr4;
                                            i60 = i23;
                                            i49 = i2;
                                        } else {
                                            label2Arr4 = label2Arr9;
                                        }
                                    }
                                    i67++;
                                    label2Arr9 = label2Arr4;
                                    i60 = i23;
                                    i49 = i2;
                                } else {
                                    label2Arr = label2Arr9;
                                }
                            }
                        } else {
                            label2Arr = label2Arr9;
                            i2 = i49;
                        }
                        int i68 = i60;
                        if (!z11 || (context3.f3707b & 256) == 0) {
                            label2Arr2 = label2Arr;
                            i3 = i68;
                            attribute2 = attribute24;
                            i4 = 0;
                        } else {
                            label2Arr2 = label2Arr;
                            attribute2 = attribute24;
                            i4 = 0;
                            i3 = i68;
                            methodVisitor2.c(-1, iU4, null, 0, null);
                        }
                        int[] iArr11 = iArr10;
                        int iD3 = d(iArr11, i4);
                        int[] iArr12 = iArrS2;
                        int iD4 = d(iArr12, i4);
                        int i69 = (context3.f3707b & 256) == 0 ? 33 : 0;
                        int i70 = iD4;
                        int i71 = i35;
                        int i72 = i48;
                        int i73 = 0;
                        int i74 = 0;
                        int i75 = iD3;
                        boolean z12 = false;
                        while (true) {
                            int i76 = i61;
                            if (i71 >= i76) {
                                int[] iArr13 = iArr11;
                                int i77 = iU3;
                                int i78 = iU4;
                                Label2[] label2Arr10 = label2Arr2;
                                int[] iArr14 = iArr12;
                                if (label2Arr10[i3] != null) {
                                    methodVisitor2.i(label2Arr10[i3]);
                                }
                                int i79 = i50;
                                if (i79 != 0 && (context3.f3707b & 2) == 0) {
                                    int i80 = i51;
                                    if (i80 != 0) {
                                        int iU12 = u(i80) * 3;
                                        int[] iArr15 = new int[iU12];
                                        int i81 = i80 + 2;
                                        while (iU12 > 0) {
                                            int i82 = iU12 - 1;
                                            iArr15[i82] = i81 + 6;
                                            int i83 = i82 - 1;
                                            iArr15[i83] = u(i81 + 8);
                                            iU12 = i83 - 1;
                                            iArr15[iU12] = u(i81);
                                            i81 += 10;
                                        }
                                        iArr = iArr15;
                                    } else {
                                        iArr = null;
                                    }
                                    int iU13 = u(i79);
                                    int i84 = i79 + 2;
                                    while (true) {
                                        int i85 = iU13 - 1;
                                        if (iU13 > 0) {
                                            int iU14 = u(i84);
                                            int iU15 = u(i84 + 2);
                                            String strT4 = t(i84 + 4, cArr);
                                            String strT5 = t(i84 + 6, cArr);
                                            int iU16 = u(i84 + 8);
                                            int i86 = i84 + 10;
                                            if (iArr != null) {
                                                for (int i87 = 0; i87 < iArr.length; i87 += 3) {
                                                    if (iArr[i87] == iU14 && iArr[i87 + 1] == iU16) {
                                                        strT = t(iArr[i87 + 2], cArr);
                                                    }
                                                }
                                                strT = null;
                                            } else {
                                                strT = null;
                                            }
                                            methodVisitor2.l(strT4, strT5, strT, label2Arr10[iU14], label2Arr10[iU14 + iU15], iU16);
                                            iU13 = i85;
                                            i84 = i86;
                                        }
                                    }
                                }
                                int i88 = 65;
                                if (iArr13 != null) {
                                    int length = iArr13.length;
                                    int i89 = 0;
                                    while (i89 < length) {
                                        int i90 = iArr13[i89];
                                        int iF = f(i90);
                                        if (iF == 64 || iF == i88) {
                                            int iR = r(context3, i90);
                                            i5 = i89;
                                            attribute22 = attribute2;
                                            k(methodVisitor2.m(context3.h, context3.i, context3.j, context3.k, context3.l, t(iR, cArr), true), iR + 2, true, cArr);
                                        } else {
                                            i5 = i89;
                                            attribute22 = attribute2;
                                        }
                                        i89 = i5 + 1;
                                        attribute2 = attribute22;
                                        i88 = 65;
                                    }
                                }
                                Attribute2 attribute25 = attribute2;
                                if (iArr14 != null) {
                                    for (int i91 : iArr14) {
                                        int iF2 = f(i91);
                                        if (iF2 == 64 || iF2 == 65) {
                                            int iR2 = r(context3, i91);
                                            k(methodVisitor2.m(context3.h, context3.i, context3.j, context3.k, context3.l, t(iR2, cArr), false), iR2 + 2, true, cArr);
                                        }
                                    }
                                }
                                Attribute2 attribute26 = attribute25;
                                while (attribute26 != null) {
                                    Attribute2 attribute27 = attribute26.c;
                                    attribute26.c = null;
                                    MethodWriter2 methodWriter22 = (MethodWriter2) methodVisitor2;
                                    attribute26.c = methodWriter22.M;
                                    methodWriter22.M = attribute26;
                                    attribute26 = attribute27;
                                }
                                methodVisitor2.n(i77, i78);
                                return;
                            }
                            i61 = i76;
                            int i92 = i71 - i35;
                            int i93 = iU3;
                            Label2[] label2Arr11 = label2Arr2;
                            Label2 label22 = label2Arr11[i92];
                            boolean z13 = z12;
                            if (label22 == null) {
                                i6 = i72;
                                i7 = i71;
                            } else {
                                boolean z14 = (context3.f3707b & 2) == 0;
                                methodVisitor2.i(label22);
                                if (z14 && (s2 = label22.c) != 0) {
                                    methodVisitor2.k(s2 & 65535, label22);
                                    if (label22.d != null) {
                                        i6 = i72;
                                        int i94 = 1;
                                        while (true) {
                                            int[] iArr16 = label22.d;
                                            i7 = i71;
                                            if (i94 <= iArr16[0]) {
                                                methodVisitor2.k(iArr16[i94], label22);
                                                i94++;
                                                i71 = i7;
                                            }
                                        }
                                    }
                                }
                            }
                            boolean z15 = z13;
                            int i95 = i6;
                            while (i95 != 0) {
                                int i96 = context3.m;
                                if (i96 == i92 || i96 == -1) {
                                    if (i96 != -1) {
                                        if (!z10 || z11) {
                                            iArr3 = iArr12;
                                            iArr4 = iArr11;
                                            i16 = iU4;
                                            i17 = i7;
                                            i18 = i95;
                                            methodVisitor2.c(-1, context3.o, context3.q, context3.r, context3.f3708s);
                                        } else {
                                            i16 = iU4;
                                            i18 = i95;
                                            i17 = i7;
                                            iArr3 = iArr12;
                                            iArr4 = iArr11;
                                            methodVisitor2.c(context3.n, context3.p, context3.q, context3.r, context3.f3708s);
                                        }
                                        z9 = false;
                                    } else {
                                        iArr3 = iArr12;
                                        iArr4 = iArr11;
                                        i16 = iU4;
                                        i17 = i7;
                                        i18 = i95;
                                        z9 = z15;
                                    }
                                    if (i18 < i2) {
                                        char[] cArr2 = context3.c;
                                        Label2[] label2Arr12 = context3.g;
                                        if (z10) {
                                            i19 = i18 + 1;
                                            i21 = this.a[i18] & 255;
                                            i20 = 0;
                                        } else {
                                            context3.m = -1;
                                            i19 = i18;
                                            i20 = 0;
                                            i21 = 255;
                                        }
                                        context3.p = i20;
                                        if (i21 < 64) {
                                            context3.n = 3;
                                            context3.r = i20;
                                            iX = i19;
                                            label2Arr3 = label2Arr12;
                                            i22 = i2;
                                        } else {
                                            if (i21 < 128) {
                                                iU = i21 - 64;
                                                i22 = i2;
                                                label2Arr3 = label2Arr12;
                                                iX = x(i19, context3.f3708s, 0, cArr2, label2Arr3);
                                                context3.n = 4;
                                                context3.r = 1;
                                            } else {
                                                label2Arr3 = label2Arr12;
                                                i22 = i2;
                                                if (i21 < 247) {
                                                    throw new IllegalArgumentException();
                                                }
                                                iU = u(i19);
                                                int iX2 = i19 + 2;
                                                if (i21 == 247) {
                                                    iX = x(iX2, context3.f3708s, 0, cArr2, label2Arr3);
                                                    context3.n = 4;
                                                    context3.r = 1;
                                                } else {
                                                    if (i21 >= 248 && i21 < 251) {
                                                        context3.n = 2;
                                                        int i97 = 251 - i21;
                                                        context3.p = i97;
                                                        context3.o -= i97;
                                                        context3.r = 0;
                                                    } else if (i21 == 251) {
                                                        context3.n = 3;
                                                        context3.r = 0;
                                                    } else if (i21 < 255) {
                                                        int i98 = i21 - 251;
                                                        int i99 = z11 ? context3.o : 0;
                                                        int i100 = i98;
                                                        while (i100 > 0) {
                                                            iX2 = x(iX2, context3.q, i99, cArr2, label2Arr3);
                                                            i100--;
                                                            i98 = i98;
                                                            i99++;
                                                            cArr2 = cArr2;
                                                        }
                                                        int i101 = i98;
                                                        context3.n = 1;
                                                        context3.p = i101;
                                                        context3.o += i101;
                                                        context3.r = 0;
                                                    } else {
                                                        int iU17 = u(iX2);
                                                        int iX3 = iX2 + 2;
                                                        context3.n = 0;
                                                        context3.p = iU17;
                                                        context3.o = iU17;
                                                        for (int i102 = 0; i102 < iU17; i102++) {
                                                            iX3 = x(iX3, context3.q, i102, cArr2, label2Arr3);
                                                        }
                                                        int iU18 = u(iX3);
                                                        iX2 = iX3 + 2;
                                                        context3.r = iU18;
                                                        for (int i103 = 0; i103 < iU18; i103++) {
                                                            iX2 = x(iX2, context3.f3708s, i103, cArr2, label2Arr3);
                                                        }
                                                    }
                                                    iX = iX2;
                                                }
                                            }
                                            i21 = iU;
                                        }
                                        int i104 = i21 + 1 + context3.m;
                                        context3.m = i104;
                                        b(i104, label2Arr3);
                                        i95 = iX;
                                        i7 = i17;
                                        z15 = z9;
                                        i2 = i22;
                                        iU4 = i16;
                                        iArr12 = iArr3;
                                        iArr11 = iArr4;
                                    } else {
                                        i7 = i17;
                                        z15 = z9;
                                        iU4 = i16;
                                        iArr12 = iArr3;
                                        iArr11 = iArr4;
                                        i95 = 0;
                                    }
                                } else {
                                    int[] iArr17 = iArr12;
                                    int[] iArr18 = iArr11;
                                    int i105 = i2;
                                    int i106 = iU4;
                                    int i107 = i7;
                                    int i108 = i95;
                                    if (z15) {
                                        z2 = z15;
                                    } else {
                                        if ((context3.f3707b & 8) != 0) {
                                            methodVisitor2.c(256, 0, null, 0, null);
                                        }
                                        z2 = false;
                                    }
                                    i8 = bArr[i107] & 255;
                                    switch (i8) {
                                        case 0:
                                        case 1:
                                        case 2:
                                        case 3:
                                        case 4:
                                        case 5:
                                        case 6:
                                        case 7:
                                        case 8:
                                        case 9:
                                        case 10:
                                        case 11:
                                        case 12:
                                        case 13:
                                        case 14:
                                        case 15:
                                        case 46:
                                        case 47:
                                        case 48:
                                        case 49:
                                        case 50:
                                        case 51:
                                        case 52:
                                        case 53:
                                        case 79:
                                        case 80:
                                        case 81:
                                        case 82:
                                        case 83:
                                        case 84:
                                        case 85:
                                        case 86:
                                        case 87:
                                        case 88:
                                        case 89:
                                        case 90:
                                        case 91:
                                        case 92:
                                        case 93:
                                        case 94:
                                        case 95:
                                        case 96:
                                        case 97:
                                        case 98:
                                        case 99:
                                        case 100:
                                        case 101:
                                        case 102:
                                        case 103:
                                        case 104:
                                        case 105:
                                        case 106:
                                        case 107:
                                        case 108:
                                        case 109:
                                        case 110:
                                        case 111:
                                        case 112:
                                        case 113:
                                        case 114:
                                        case 115:
                                        case 116:
                                        case 117:
                                        case 118:
                                        case 119:
                                        case 120:
                                        case 121:
                                        case 122:
                                        case 123:
                                        case 124:
                                        case Opcodes.LUSHR /* 125 */:
                                        case 126:
                                        case Opcodes.LAND /* 127 */:
                                        case 128:
                                        case Opcodes.LOR /* 129 */:
                                        case 130:
                                        case Opcodes.LXOR /* 131 */:
                                        case Opcodes.I2L /* 133 */:
                                        case Opcodes.I2F /* 134 */:
                                        case Opcodes.I2D /* 135 */:
                                        case Opcodes.L2I /* 136 */:
                                        case Opcodes.L2F /* 137 */:
                                        case Opcodes.L2D /* 138 */:
                                        case Opcodes.F2I /* 139 */:
                                        case Opcodes.F2L /* 140 */:
                                        case Opcodes.F2D /* 141 */:
                                        case Opcodes.D2I /* 142 */:
                                        case Opcodes.D2L /* 143 */:
                                        case Opcodes.D2F /* 144 */:
                                        case Opcodes.I2B /* 145 */:
                                        case Opcodes.I2C /* 146 */:
                                        case Opcodes.I2S /* 147 */:
                                        case Opcodes.LCMP /* 148 */:
                                        case Opcodes.FCMPL /* 149 */:
                                        case 150:
                                        case Opcodes.DCMPL /* 151 */:
                                        case Opcodes.DCMPG /* 152 */:
                                        case Opcodes.IRETURN /* 172 */:
                                        case Opcodes.LRETURN /* 173 */:
                                        case Opcodes.FRETURN /* 174 */:
                                        case 175:
                                        case Opcodes.ARETURN /* 176 */:
                                        case Opcodes.RETURN /* 177 */:
                                        case Opcodes.ARRAYLENGTH /* 190 */:
                                        case Opcodes.ATHROW /* 191 */:
                                        case Opcodes.MONITORENTER /* 194 */:
                                        case Opcodes.MONITOREXIT /* 195 */:
                                            z3 = z11;
                                            z4 = z2;
                                            i9 = i108;
                                            methodVisitor2.e(i8);
                                            i10 = i107 + 1;
                                            iD = i75;
                                            i11 = i73;
                                            z5 = z4;
                                            iArr2 = iArr18;
                                            while (iArr2 != null && i11 < iArr2.length && iD <= i92) {
                                                if (iD == i92) {
                                                    int iR3 = r(context3, iArr2[i11]);
                                                    k(methodVisitor2.f(context3.h, context3.i, t(iR3, cArr), true), iR3 + 2, true, cArr);
                                                }
                                                i11++;
                                                iD = d(iArr2, i11);
                                            }
                                            i13 = i74;
                                            iD2 = i70;
                                            while (iArr17 != null && i13 < iArr17.length && iD2 <= i92) {
                                                if (iD2 != i92) {
                                                    int iR4 = r(context3, iArr17[i13]);
                                                    z8 = z5;
                                                    i14 = i10;
                                                    i15 = i92;
                                                    k(methodVisitor2.f(context3.h, context3.i, t(iR4, cArr), false), iR4 + 2, true, cArr);
                                                } else {
                                                    z8 = z5;
                                                    i14 = i10;
                                                    i15 = i92;
                                                }
                                                i13++;
                                                iD2 = d(iArr17, i13);
                                                z5 = z8;
                                                i10 = i14;
                                                i92 = i15;
                                            }
                                            z12 = z5;
                                            i74 = i13;
                                            i70 = iD2;
                                            i73 = i11;
                                            iArr11 = iArr2;
                                            label2Arr2 = label2Arr11;
                                            i71 = i10;
                                            iU3 = i93;
                                            z11 = z3;
                                            i2 = i105;
                                            i72 = i9;
                                            i75 = iD;
                                            iArr12 = iArr17;
                                            iU4 = i106;
                                        case 16:
                                        case Opcodes.NEWARRAY /* 188 */:
                                            z3 = z11;
                                            z4 = z2;
                                            i9 = i108;
                                            methodVisitor2.g(i8, bArr[i107 + 1]);
                                            i10 = i107 + 2;
                                            iD = i75;
                                            i11 = i73;
                                            z5 = z4;
                                            iArr2 = iArr18;
                                            while (iArr2 != null) {
                                                if (iD == i92) {
                                                }
                                                i11++;
                                                iD = d(iArr2, i11);
                                                break;
                                            }
                                            i13 = i74;
                                            iD2 = i70;
                                            while (iArr17 != null) {
                                                if (iD2 != i92) {
                                                }
                                                i13++;
                                                iD2 = d(iArr17, i13);
                                                z5 = z8;
                                                i10 = i14;
                                                i92 = i15;
                                                break;
                                            }
                                            z12 = z5;
                                            i74 = i13;
                                            i70 = iD2;
                                            i73 = i11;
                                            iArr11 = iArr2;
                                            label2Arr2 = label2Arr11;
                                            i71 = i10;
                                            iU3 = i93;
                                            z11 = z3;
                                            i2 = i105;
                                            i72 = i9;
                                            i75 = iD;
                                            iArr12 = iArr17;
                                            iU4 = i106;
                                            break;
                                        case 17:
                                            z3 = z11;
                                            z4 = z2;
                                            i9 = i108;
                                            methodVisitor2.g(i8, q(i107 + 1));
                                            i10 = i107 + 3;
                                            iD = i75;
                                            i11 = i73;
                                            z5 = z4;
                                            iArr2 = iArr18;
                                            while (iArr2 != null) {
                                            }
                                            i13 = i74;
                                            iD2 = i70;
                                            while (iArr17 != null) {
                                            }
                                            z12 = z5;
                                            i74 = i13;
                                            i70 = iD2;
                                            i73 = i11;
                                            iArr11 = iArr2;
                                            label2Arr2 = label2Arr11;
                                            i71 = i10;
                                            iU3 = i93;
                                            z11 = z3;
                                            i2 = i105;
                                            i72 = i9;
                                            i75 = iD;
                                            iArr12 = iArr17;
                                            iU4 = i106;
                                        case 18:
                                            z3 = z11;
                                            z4 = z2;
                                            i9 = i108;
                                            methodVisitor2.j(i(bArr[i107 + 1] & 255, cArr));
                                            i10 = i107 + 2;
                                            iD = i75;
                                            i11 = i73;
                                            z5 = z4;
                                            iArr2 = iArr18;
                                            while (iArr2 != null) {
                                            }
                                            i13 = i74;
                                            iD2 = i70;
                                            while (iArr17 != null) {
                                            }
                                            z12 = z5;
                                            i74 = i13;
                                            i70 = iD2;
                                            i73 = i11;
                                            iArr11 = iArr2;
                                            label2Arr2 = label2Arr11;
                                            i71 = i10;
                                            iU3 = i93;
                                            z11 = z3;
                                            i2 = i105;
                                            i72 = i9;
                                            i75 = iD;
                                            iArr12 = iArr17;
                                            iU4 = i106;
                                        case 19:
                                        case 20:
                                            z3 = z11;
                                            z6 = z2;
                                            i9 = i108;
                                            methodVisitor2.j(i(u(i107 + 1), cArr));
                                            i10 = i107 + 3;
                                            iD = i75;
                                            i11 = i73;
                                            z5 = z6;
                                            iArr2 = iArr18;
                                            while (iArr2 != null) {
                                            }
                                            i13 = i74;
                                            iD2 = i70;
                                            while (iArr17 != null) {
                                            }
                                            z12 = z5;
                                            i74 = i13;
                                            i70 = iD2;
                                            i73 = i11;
                                            iArr11 = iArr2;
                                            label2Arr2 = label2Arr11;
                                            i71 = i10;
                                            iU3 = i93;
                                            z11 = z3;
                                            i2 = i105;
                                            i72 = i9;
                                            i75 = iD;
                                            iArr12 = iArr17;
                                            iU4 = i106;
                                        case 21:
                                        case 22:
                                        case 23:
                                        case 24:
                                        case 25:
                                        case 54:
                                        case 55:
                                        case 56:
                                        case 57:
                                        case 58:
                                        case Opcodes.RET /* 169 */:
                                            z3 = z11;
                                            z6 = z2;
                                            i9 = i108;
                                            methodVisitor2.t(i8, bArr[i107 + 1] & 255);
                                            i10 = i107 + 2;
                                            iD = i75;
                                            i11 = i73;
                                            z5 = z6;
                                            iArr2 = iArr18;
                                            while (iArr2 != null) {
                                            }
                                            i13 = i74;
                                            iD2 = i70;
                                            while (iArr17 != null) {
                                            }
                                            z12 = z5;
                                            i74 = i13;
                                            i70 = iD2;
                                            i73 = i11;
                                            iArr11 = iArr2;
                                            label2Arr2 = label2Arr11;
                                            i71 = i10;
                                            iU3 = i93;
                                            z11 = z3;
                                            i2 = i105;
                                            i72 = i9;
                                            i75 = iD;
                                            iArr12 = iArr17;
                                            iU4 = i106;
                                        case 26:
                                        case 27:
                                        case 28:
                                        case 29:
                                        case 30:
                                        case 31:
                                        case 32:
                                        case 33:
                                        case 34:
                                        case 35:
                                        case 36:
                                        case 37:
                                        case 38:
                                        case 39:
                                        case 40:
                                        case 41:
                                        case 42:
                                        case 43:
                                        case 44:
                                        case 45:
                                            z3 = z11;
                                            z6 = z2;
                                            i9 = i108;
                                            int i109 = i8 - 26;
                                            methodVisitor2.t((i109 >> 2) + 21, 3 & i109);
                                            i10 = i107 + 1;
                                            iD = i75;
                                            i11 = i73;
                                            z5 = z6;
                                            iArr2 = iArr18;
                                            while (iArr2 != null) {
                                            }
                                            i13 = i74;
                                            iD2 = i70;
                                            while (iArr17 != null) {
                                            }
                                            z12 = z5;
                                            i74 = i13;
                                            i70 = iD2;
                                            i73 = i11;
                                            iArr11 = iArr2;
                                            label2Arr2 = label2Arr11;
                                            i71 = i10;
                                            iU3 = i93;
                                            z11 = z3;
                                            i2 = i105;
                                            i72 = i9;
                                            i75 = iD;
                                            iArr12 = iArr17;
                                            iU4 = i106;
                                        case 59:
                                        case 60:
                                        case 61:
                                        case 62:
                                        case 63:
                                        case 64:
                                        case 65:
                                        case 66:
                                        case 67:
                                        case 68:
                                        case 69:
                                        case 70:
                                        case 71:
                                        case 72:
                                        case 73:
                                        case 74:
                                        case 75:
                                        case 76:
                                        case 77:
                                        case 78:
                                            z3 = z11;
                                            z6 = z2;
                                            i9 = i108;
                                            int i110 = i8 - 59;
                                            methodVisitor2.t((i110 >> 2) + 54, 3 & i110);
                                            i10 = i107 + 1;
                                            iD = i75;
                                            i11 = i73;
                                            z5 = z6;
                                            iArr2 = iArr18;
                                            while (iArr2 != null) {
                                            }
                                            i13 = i74;
                                            iD2 = i70;
                                            while (iArr17 != null) {
                                            }
                                            z12 = z5;
                                            i74 = i13;
                                            i70 = iD2;
                                            i73 = i11;
                                            iArr11 = iArr2;
                                            label2Arr2 = label2Arr11;
                                            i71 = i10;
                                            iU3 = i93;
                                            z11 = z3;
                                            i2 = i105;
                                            i72 = i9;
                                            i75 = iD;
                                            iArr12 = iArr17;
                                            iU4 = i106;
                                        case Opcodes.IINC /* 132 */:
                                            z3 = z11;
                                            z6 = z2;
                                            i9 = i108;
                                            methodVisitor2.d(bArr[i107 + 1] & 255, bArr[i107 + 2]);
                                            i10 = i107 + 3;
                                            iD = i75;
                                            i11 = i73;
                                            z5 = z6;
                                            iArr2 = iArr18;
                                            while (iArr2 != null) {
                                            }
                                            i13 = i74;
                                            iD2 = i70;
                                            while (iArr17 != null) {
                                            }
                                            z12 = z5;
                                            i74 = i13;
                                            i70 = iD2;
                                            i73 = i11;
                                            iArr11 = iArr2;
                                            label2Arr2 = label2Arr11;
                                            i71 = i10;
                                            iU3 = i93;
                                            z11 = z3;
                                            i2 = i105;
                                            i72 = i9;
                                            i75 = iD;
                                            iArr12 = iArr17;
                                            iU4 = i106;
                                        case 153:
                                        case 154:
                                        case 155:
                                        case 156:
                                        case 157:
                                        case 158:
                                        case Opcodes.IF_ICMPEQ /* 159 */:
                                        case Opcodes.IF_ICMPNE /* 160 */:
                                        case Opcodes.IF_ICMPLT /* 161 */:
                                        case Opcodes.IF_ICMPGE /* 162 */:
                                        case Opcodes.IF_ICMPGT /* 163 */:
                                        case Opcodes.IF_ICMPLE /* 164 */:
                                        case Opcodes.IF_ACMPEQ /* 165 */:
                                        case Opcodes.IF_ACMPNE /* 166 */:
                                        case Opcodes.GOTO /* 167 */:
                                        case Opcodes.JSR /* 168 */:
                                        case Opcodes.IFNULL /* 198 */:
                                        case Opcodes.IFNONNULL /* 199 */:
                                            z3 = z11;
                                            z6 = z2;
                                            i9 = i108;
                                            methodVisitor2.h(i8, label2Arr11[q(i107 + 1) + i92]);
                                            i10 = i107 + 3;
                                            iD = i75;
                                            i11 = i73;
                                            z5 = z6;
                                            iArr2 = iArr18;
                                            while (iArr2 != null) {
                                            }
                                            i13 = i74;
                                            iD2 = i70;
                                            while (iArr17 != null) {
                                            }
                                            z12 = z5;
                                            i74 = i13;
                                            i70 = iD2;
                                            i73 = i11;
                                            iArr11 = iArr2;
                                            label2Arr2 = label2Arr11;
                                            i71 = i10;
                                            iU3 = i93;
                                            z11 = z3;
                                            i2 = i105;
                                            i72 = i9;
                                            i75 = iD;
                                            iArr12 = iArr17;
                                            iU4 = i106;
                                        case Opcodes.TABLESWITCH /* 170 */:
                                            z3 = z11;
                                            z6 = z2;
                                            i9 = i108;
                                            int i111 = (4 - (i92 & 3)) + i107;
                                            Label2 label23 = label2Arr11[l(i111) + i92];
                                            int iL5 = l(i111 + 4);
                                            int iL6 = l(i111 + 8);
                                            int i112 = i111 + 12;
                                            int i113 = (iL6 - iL5) + 1;
                                            Label2[] label2Arr13 = new Label2[i113];
                                            for (int i114 = 0; i114 < i113; i114++) {
                                                label2Arr13[i114] = label2Arr11[l(i112) + i92];
                                                i112 += 4;
                                            }
                                            methodVisitor2.q(iL5, iL6, label23, label2Arr13);
                                            i10 = i112;
                                            iD = i75;
                                            i11 = i73;
                                            z5 = z6;
                                            iArr2 = iArr18;
                                            while (iArr2 != null) {
                                            }
                                            i13 = i74;
                                            iD2 = i70;
                                            while (iArr17 != null) {
                                            }
                                            z12 = z5;
                                            i74 = i13;
                                            i70 = iD2;
                                            i73 = i11;
                                            iArr11 = iArr2;
                                            label2Arr2 = label2Arr11;
                                            i71 = i10;
                                            iU3 = i93;
                                            z11 = z3;
                                            i2 = i105;
                                            i72 = i9;
                                            i75 = iD;
                                            iArr12 = iArr17;
                                            iU4 = i106;
                                        case Opcodes.LOOKUPSWITCH /* 171 */:
                                            z3 = z11;
                                            z6 = z2;
                                            int i115 = (4 - (i92 & 3)) + i107;
                                            Label2 label24 = label2Arr11[l(i115) + i92];
                                            int iL7 = l(i115 + 4);
                                            int[] iArr19 = new int[iL7];
                                            Label2[] label2Arr14 = new Label2[iL7];
                                            int i116 = i115 + 8;
                                            for (int i117 = 0; i117 < iL7; i117++) {
                                                iArr19[i117] = l(i116);
                                                label2Arr14[i117] = label2Arr11[l(i116 + 4) + i92];
                                                i116 += 8;
                                            }
                                            MethodWriter2 methodWriter23 = (MethodWriter2) methodVisitor2;
                                            ByteVector2 byteVector2 = methodWriter23.l;
                                            methodWriter23.Z = byteVector2.f3699b;
                                            byteVector2.g(Opcodes.LOOKUPSWITCH);
                                            int i118 = i116;
                                            i9 = i108;
                                            byteVector2.h(null, 0, (4 - (methodWriter23.l.f3699b % 4)) % 4);
                                            boolean z16 = true;
                                            label24.e(methodWriter23.l, methodWriter23.Z, true);
                                            methodWriter23.l.i(iL7);
                                            int i119 = 0;
                                            while (i119 < iL7) {
                                                methodWriter23.l.i(iArr19[i119]);
                                                label2Arr14[i119].e(methodWriter23.l, methodWriter23.Z, z16);
                                                i119++;
                                                iL7 = iL7;
                                                z16 = true;
                                            }
                                            methodWriter23.B(label24, label2Arr14);
                                            i10 = i118;
                                            iD = i75;
                                            i11 = i73;
                                            z5 = z6;
                                            iArr2 = iArr18;
                                            while (iArr2 != null) {
                                            }
                                            i13 = i74;
                                            iD2 = i70;
                                            while (iArr17 != null) {
                                            }
                                            z12 = z5;
                                            i74 = i13;
                                            i70 = iD2;
                                            i73 = i11;
                                            iArr11 = iArr2;
                                            label2Arr2 = label2Arr11;
                                            i71 = i10;
                                            iU3 = i93;
                                            z11 = z3;
                                            i2 = i105;
                                            i72 = i9;
                                            i75 = iD;
                                            iArr12 = iArr17;
                                            iU4 = i106;
                                        case Opcodes.GETSTATIC /* 178 */:
                                        case Opcodes.PUTSTATIC /* 179 */:
                                        case 180:
                                        case Opcodes.PUTFIELD /* 181 */:
                                        case Opcodes.INVOKEVIRTUAL /* 182 */:
                                        case Opcodes.INVOKESPECIAL /* 183 */:
                                        case Opcodes.INVOKESTATIC /* 184 */:
                                        case Opcodes.INVOKEINTERFACE /* 185 */:
                                            z3 = z11;
                                            int i120 = this.f3700b[u(i107 + 1)];
                                            int i121 = this.f3700b[u(i120 + 2)];
                                            String strG = g(i120, cArr);
                                            String strT6 = t(i121, cArr);
                                            String strT7 = t(i121 + 2, cArr);
                                            if (i8 < 182) {
                                                methodVisitor2.b(i8, strG, strT6, strT7);
                                                z6 = z2;
                                                i12 = i8;
                                            } else {
                                                z6 = z2;
                                                i12 = i8;
                                                methodVisitor2.p(i8, strG, strT6, strT7, bArr[i120 + (-1)] == 11);
                                            }
                                            i10 = i12 == 185 ? i107 + 5 : i107 + 3;
                                            i9 = i108;
                                            iD = i75;
                                            i11 = i73;
                                            z5 = z6;
                                            iArr2 = iArr18;
                                            while (iArr2 != null) {
                                            }
                                            i13 = i74;
                                            iD2 = i70;
                                            while (iArr17 != null) {
                                            }
                                            z12 = z5;
                                            i74 = i13;
                                            i70 = iD2;
                                            i73 = i11;
                                            iArr11 = iArr2;
                                            label2Arr2 = label2Arr11;
                                            i71 = i10;
                                            iU3 = i93;
                                            z11 = z3;
                                            i2 = i105;
                                            i72 = i9;
                                            i75 = iD;
                                            iArr12 = iArr17;
                                            iU4 = i106;
                                        case Opcodes.INVOKEDYNAMIC /* 186 */:
                                            int i122 = this.f3700b[u(i107 + 1)];
                                            int i123 = this.f3700b[u(i122 + 2)];
                                            String strT8 = t(i123, cArr);
                                            String strT9 = t(i123 + 2, cArr);
                                            int i124 = this.e[u(i122)];
                                            Handle2 handle2 = (Handle2) i(u(i124), cArr);
                                            int iU19 = u(i124 + 2);
                                            Object[] objArr2 = new Object[iU19];
                                            int i125 = i124 + 4;
                                            z3 = z11;
                                            int i126 = 0;
                                            while (i126 < iU19) {
                                                objArr2[i126] = i(u(i125), cArr);
                                                i125 += 2;
                                                i126++;
                                                iU19 = iU19;
                                            }
                                            MethodWriter2 methodWriter24 = (MethodWriter2) methodVisitor2;
                                            methodWriter24.Z = methodWriter24.l.f3699b;
                                            SymbolTable2 symbolTable2 = methodWriter24.d;
                                            Symbol2 symbol2D = symbolTable2.d(18, strT8, strT9, symbolTable2.a(handle2, objArr2).a);
                                            methodWriter24.l.e(Opcodes.INVOKEDYNAMIC, symbol2D.a);
                                            methodWriter24.l.j(0);
                                            Label2 label25 = methodWriter24.Q;
                                            if (label25 != null) {
                                                int i127 = methodWriter24.N;
                                                if (i127 == 4 || i127 == 3) {
                                                    label25.k.b(Opcodes.INVOKEDYNAMIC, 0, symbol2D, methodWriter24.d);
                                                } else {
                                                    int iA = symbol2D.a();
                                                    int i128 = methodWriter24.R + ((iA & 3) - (iA >> 2)) + 1;
                                                    if (i128 > methodWriter24.S) {
                                                        methodWriter24.S = i128;
                                                    }
                                                    methodWriter24.R = i128;
                                                }
                                            }
                                            i10 = i107 + 5;
                                            z7 = z2;
                                            z5 = z7;
                                            i9 = i108;
                                            iD = i75;
                                            i11 = i73;
                                            iArr2 = iArr18;
                                            while (iArr2 != null) {
                                            }
                                            i13 = i74;
                                            iD2 = i70;
                                            while (iArr17 != null) {
                                            }
                                            z12 = z5;
                                            i74 = i13;
                                            i70 = iD2;
                                            i73 = i11;
                                            iArr11 = iArr2;
                                            label2Arr2 = label2Arr11;
                                            i71 = i10;
                                            iU3 = i93;
                                            z11 = z3;
                                            i2 = i105;
                                            i72 = i9;
                                            i75 = iD;
                                            iArr12 = iArr17;
                                            iU4 = i106;
                                            break;
                                        case Opcodes.NEW /* 187 */:
                                        case Opcodes.ANEWARRAY /* 189 */:
                                        case Opcodes.CHECKCAST /* 192 */:
                                        case Opcodes.INSTANCEOF /* 193 */:
                                            methodVisitor2.s(i8, g(i107 + 1, cArr));
                                            i10 = i107 + 3;
                                            z3 = z11;
                                            z7 = z2;
                                            z5 = z7;
                                            i9 = i108;
                                            iD = i75;
                                            i11 = i73;
                                            iArr2 = iArr18;
                                            while (iArr2 != null) {
                                            }
                                            i13 = i74;
                                            iD2 = i70;
                                            while (iArr17 != null) {
                                            }
                                            z12 = z5;
                                            i74 = i13;
                                            i70 = iD2;
                                            i73 = i11;
                                            iArr11 = iArr2;
                                            label2Arr2 = label2Arr11;
                                            i71 = i10;
                                            iU3 = i93;
                                            z11 = z3;
                                            i2 = i105;
                                            i72 = i9;
                                            i75 = iD;
                                            iArr12 = iArr17;
                                            iU4 = i106;
                                        case 196:
                                            int i129 = bArr[i107 + 1] & 255;
                                            if (i129 == 132) {
                                                methodVisitor2.d(u(i107 + 2), q(i107 + 4));
                                                i10 = i107 + 6;
                                                z3 = z11;
                                                z7 = z2;
                                                z5 = z7;
                                                i9 = i108;
                                                iD = i75;
                                                i11 = i73;
                                                iArr2 = iArr18;
                                                while (iArr2 != null) {
                                                }
                                                i13 = i74;
                                                iD2 = i70;
                                                while (iArr17 != null) {
                                                }
                                                z12 = z5;
                                                i74 = i13;
                                                i70 = iD2;
                                                i73 = i11;
                                                iArr11 = iArr2;
                                                label2Arr2 = label2Arr11;
                                                i71 = i10;
                                                iU3 = i93;
                                                z11 = z3;
                                                i2 = i105;
                                                i72 = i9;
                                                i75 = iD;
                                                iArr12 = iArr17;
                                                iU4 = i106;
                                            } else {
                                                methodVisitor2.t(i129, u(i107 + 2));
                                                i10 = i107 + 4;
                                                z3 = z11;
                                                z7 = z2;
                                                z5 = z7;
                                                i9 = i108;
                                                iD = i75;
                                                i11 = i73;
                                                iArr2 = iArr18;
                                                while (iArr2 != null) {
                                                }
                                                i13 = i74;
                                                iD2 = i70;
                                                while (iArr17 != null) {
                                                }
                                                z12 = z5;
                                                i74 = i13;
                                                i70 = iD2;
                                                i73 = i11;
                                                iArr11 = iArr2;
                                                label2Arr2 = label2Arr11;
                                                i71 = i10;
                                                iU3 = i93;
                                                z11 = z3;
                                                i2 = i105;
                                                i72 = i9;
                                                i75 = iD;
                                                iArr12 = iArr17;
                                                iU4 = i106;
                                            }
                                        case Opcodes.MULTIANEWARRAY /* 197 */:
                                            String strG2 = g(i107 + 1, cArr);
                                            int i130 = bArr[i107 + 3] & 255;
                                            MethodWriter2 methodWriter25 = (MethodWriter2) methodVisitor2;
                                            methodWriter25.Z = methodWriter25.l.f3699b;
                                            Symbol2 symbol2M = methodWriter25.d.m(7, strG2);
                                            ByteVector2 byteVector22 = methodWriter25.l;
                                            byteVector22.e(Opcodes.MULTIANEWARRAY, symbol2M.a);
                                            byteVector22.g(i130);
                                            Label2 label26 = methodWriter25.Q;
                                            if (label26 != null) {
                                                int i131 = methodWriter25.N;
                                                if (i131 == 4 || i131 == 3) {
                                                    label26.k.b(Opcodes.MULTIANEWARRAY, i130, symbol2M, methodWriter25.d);
                                                } else {
                                                    methodWriter25.R = (1 - i130) + methodWriter25.R;
                                                }
                                            }
                                            i10 = i107 + 4;
                                            z3 = z11;
                                            z7 = z2;
                                            z5 = z7;
                                            i9 = i108;
                                            iD = i75;
                                            i11 = i73;
                                            iArr2 = iArr18;
                                            while (iArr2 != null) {
                                            }
                                            i13 = i74;
                                            iD2 = i70;
                                            while (iArr17 != null) {
                                            }
                                            z12 = z5;
                                            i74 = i13;
                                            i70 = iD2;
                                            i73 = i11;
                                            iArr11 = iArr2;
                                            label2Arr2 = label2Arr11;
                                            i71 = i10;
                                            iU3 = i93;
                                            z11 = z3;
                                            i2 = i105;
                                            i72 = i9;
                                            i75 = iD;
                                            iArr12 = iArr17;
                                            iU4 = i106;
                                            break;
                                        case 200:
                                        case 201:
                                            methodVisitor2.h(i8 - i69, label2Arr11[l(i107 + 1) + i92]);
                                            i10 = i107 + 5;
                                            z3 = z11;
                                            z7 = z2;
                                            z5 = z7;
                                            i9 = i108;
                                            iD = i75;
                                            i11 = i73;
                                            iArr2 = iArr18;
                                            while (iArr2 != null) {
                                            }
                                            i13 = i74;
                                            iD2 = i70;
                                            while (iArr17 != null) {
                                            }
                                            z12 = z5;
                                            i74 = i13;
                                            i70 = iD2;
                                            i73 = i11;
                                            iArr11 = iArr2;
                                            label2Arr2 = label2Arr11;
                                            i71 = i10;
                                            iU3 = i93;
                                            z11 = z3;
                                            i2 = i105;
                                            i72 = i9;
                                            i75 = iD;
                                            iArr12 = iArr17;
                                            iU4 = i106;
                                        case 202:
                                        case 203:
                                        case 204:
                                        case 205:
                                        case 206:
                                        case 207:
                                        case 208:
                                        case 209:
                                        case 210:
                                        case 211:
                                        case 212:
                                        case 213:
                                        case 214:
                                        case 215:
                                        case 216:
                                        case 217:
                                        case 218:
                                        case 219:
                                            int i132 = i8 < 218 ? i8 - 49 : i8 - 20;
                                            Label2 label27 = label2Arr11[u(i107 + 1) + i92];
                                            if (i132 == 167 || i132 == 168) {
                                                methodVisitor2.h(i132 + 33, label27);
                                                z7 = z2;
                                            } else {
                                                methodVisitor2.h(i132 < 167 ? ((i132 + 1) ^ 1) - 1 : i132 ^ 1, b(i92 + 3, label2Arr11));
                                                methodVisitor2.h(200, label27);
                                                z7 = true;
                                            }
                                            i10 = i107 + 3;
                                            z3 = z11;
                                            z5 = z7;
                                            i9 = i108;
                                            iD = i75;
                                            i11 = i73;
                                            iArr2 = iArr18;
                                            while (iArr2 != null) {
                                            }
                                            i13 = i74;
                                            iD2 = i70;
                                            while (iArr17 != null) {
                                            }
                                            z12 = z5;
                                            i74 = i13;
                                            i70 = iD2;
                                            i73 = i11;
                                            iArr11 = iArr2;
                                            label2Arr2 = label2Arr11;
                                            i71 = i10;
                                            iU3 = i93;
                                            z11 = z3;
                                            i2 = i105;
                                            i72 = i9;
                                            i75 = iD;
                                            iArr12 = iArr17;
                                            iU4 = i106;
                                            break;
                                        case 220:
                                            methodVisitor2.h(200, label2Arr11[l(i107 + 1) + i92]);
                                            i10 = i107 + 5;
                                            z3 = z11;
                                            i9 = i108;
                                            iD = i75;
                                            i11 = i73;
                                            iArr2 = iArr18;
                                            z5 = true;
                                            while (iArr2 != null) {
                                            }
                                            i13 = i74;
                                            iD2 = i70;
                                            while (iArr17 != null) {
                                            }
                                            z12 = z5;
                                            i74 = i13;
                                            i70 = iD2;
                                            i73 = i11;
                                            iArr11 = iArr2;
                                            label2Arr2 = label2Arr11;
                                            i71 = i10;
                                            iU3 = i93;
                                            z11 = z3;
                                            i2 = i105;
                                            i72 = i9;
                                            i75 = iD;
                                            iArr12 = iArr17;
                                            iU4 = i106;
                                        default:
                                            throw new AssertionError();
                                    }
                                }
                            }
                            int[] iArr172 = iArr12;
                            int[] iArr182 = iArr11;
                            int i1052 = i2;
                            int i1062 = iU4;
                            int i1072 = i7;
                            int i1082 = i95;
                            if (z15) {
                            }
                            i8 = bArr[i1072] & 255;
                            switch (i8) {
                            }
                        }
                    }
                }
            }
        }
    }

    public Object i(int i, char[] cArr) {
        int[] iArr = this.f3700b;
        int i2 = iArr[i];
        byte b2 = this.a[i2 - 1];
        switch (b2) {
            case 3:
                return Integer.valueOf(l(i2));
            case 4:
                return Float.valueOf(Float.intBitsToFloat(l(i2)));
            case 5:
                return Long.valueOf(m(i2));
            case 6:
                return Double.valueOf(Double.longBitsToDouble(m(i2)));
            case 7:
                return Type2.h(t(i2, cArr));
            case 8:
                return t(i2, cArr);
            default:
                switch (b2) {
                    case 15:
                        int iF = f(i2);
                        int i3 = this.f3700b[u(i2 + 1)];
                        int i4 = this.f3700b[u(i3 + 2)];
                        return new Handle2(iF, g(i3, cArr), t(i4, cArr), t(i4 + 2, cArr), this.a[i3 - 1] == 11);
                    case 16:
                        String strT = t(i2, cArr);
                        return new Type2(11, strT, 0, strT.length());
                    case 17:
                        ConstantDynamic2 constantDynamic2 = this.d[i];
                        if (constantDynamic2 != null) {
                            return constantDynamic2;
                        }
                        int i5 = iArr[i];
                        int i6 = iArr[u(i5 + 2)];
                        String strT2 = t(i6, cArr);
                        String strT3 = t(i6 + 2, cArr);
                        int i7 = this.e[u(i5)];
                        Handle2 handle2 = (Handle2) i(u(i7), cArr);
                        int iU = u(i7 + 2);
                        Object[] objArr = new Object[iU];
                        int i8 = i7 + 4;
                        for (int i9 = 0; i9 < iU; i9++) {
                            objArr[i9] = i(u(i8), cArr);
                            i8 += 2;
                        }
                        ConstantDynamic2[] constantDynamic2Arr = this.d;
                        ConstantDynamic2 constantDynamic22 = new ConstantDynamic2(strT2, strT3, handle2, objArr);
                        constantDynamic2Arr[i] = constantDynamic22;
                        return constantDynamic22;
                    default:
                        throw new IllegalArgumentException();
                }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:99:0x0235  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final int j(AnnotationWriter2 annotationWriter2, int i, String str, char[] cArr) {
        int i2 = 0;
        if (annotationWriter2 == null) {
            int i3 = this.a[i] & 255;
            return i3 != 64 ? i3 != 91 ? i3 != 101 ? i + 3 : i + 5 : k(null, i + 1, false, cArr) : k(null, i + 3, true, cArr);
        }
        int i4 = i + 1;
        int i5 = this.a[i] & 255;
        if (i5 == 64) {
            String strT = t(i4, cArr);
            annotationWriter2.e++;
            if (annotationWriter2.f3696b) {
                annotationWriter2.c.j(annotationWriter2.a.l(str));
            }
            ByteVector2 byteVector2 = annotationWriter2.c;
            byteVector2.e(64, annotationWriter2.a.l(strT));
            byteVector2.j(0);
            return k(new AnnotationWriter2(annotationWriter2.a, true, annotationWriter2.c, null), i4 + 2, true, cArr);
        }
        if (i5 == 70) {
            annotationWriter2.e(str, i(u(i4), cArr));
        } else if (i5 == 83) {
            annotationWriter2.e(str, Short.valueOf((short) l(this.f3700b[u(i4)])));
        } else if (i5 == 99) {
            String strT2 = t(i4, cArr);
            annotationWriter2.e(str, Type2.k(strT2, 0, strT2.length()));
        } else {
            if (i5 == 101) {
                String strT3 = t(i4, cArr);
                String strT4 = t(i4 + 2, cArr);
                annotationWriter2.e++;
                if (annotationWriter2.f3696b) {
                    annotationWriter2.c.j(annotationWriter2.a.l(str));
                }
                ByteVector2 byteVector22 = annotationWriter2.c;
                byteVector22.e(101, annotationWriter2.a.l(strT3));
                byteVector22.j(annotationWriter2.a.l(strT4));
                return i4 + 4;
            }
            if (i5 == 115) {
                annotationWriter2.e(str, t(i4, cArr));
            } else if (i5 != 73 && i5 != 74) {
                if (i5 == 90) {
                    annotationWriter2.e(str, l(this.f3700b[u(i4)]) == 0 ? Boolean.FALSE : Boolean.TRUE);
                } else {
                    if (i5 == 91) {
                        int iU = u(i4);
                        int i6 = i4 + 2;
                        if (iU == 0) {
                            return k(annotationWriter2.f(str), i6 - 2, false, cArr);
                        }
                        int i7 = this.a[i6] & 255;
                        if (i7 == 70) {
                            float[] fArr = new float[iU];
                            while (i2 < iU) {
                                fArr[i2] = Float.intBitsToFloat(l(this.f3700b[u(i6 + 1)]));
                                i6 += 3;
                                i2++;
                            }
                            annotationWriter2.e(str, fArr);
                            return i6;
                        }
                        if (i7 == 83) {
                            short[] sArr = new short[iU];
                            while (i2 < iU) {
                                sArr[i2] = (short) l(this.f3700b[u(i6 + 1)]);
                                i6 += 3;
                                i2++;
                            }
                            annotationWriter2.e(str, sArr);
                            return i6;
                        }
                        if (i7 == 90) {
                            boolean[] zArr = new boolean[iU];
                            for (int i8 = 0; i8 < iU; i8++) {
                                zArr[i8] = l(this.f3700b[u(i6 + 1)]) != 0;
                                i6 += 3;
                            }
                            annotationWriter2.e(str, zArr);
                            return i6;
                        }
                        if (i7 == 73) {
                            int[] iArr = new int[iU];
                            while (i2 < iU) {
                                iArr[i2] = l(this.f3700b[u(i6 + 1)]);
                                i6 += 3;
                                i2++;
                            }
                            annotationWriter2.e(str, iArr);
                            return i6;
                        }
                        if (i7 == 74) {
                            long[] jArr = new long[iU];
                            while (i2 < iU) {
                                jArr[i2] = m(this.f3700b[u(i6 + 1)]);
                                i6 += 3;
                                i2++;
                            }
                            annotationWriter2.e(str, jArr);
                            return i6;
                        }
                        switch (i7) {
                            case 66:
                                byte[] bArr = new byte[iU];
                                while (i2 < iU) {
                                    bArr[i2] = (byte) l(this.f3700b[u(i6 + 1)]);
                                    i6 += 3;
                                    i2++;
                                }
                                annotationWriter2.e(str, bArr);
                                return i6;
                            case 67:
                                char[] cArr2 = new char[iU];
                                while (i2 < iU) {
                                    cArr2[i2] = (char) l(this.f3700b[u(i6 + 1)]);
                                    i6 += 3;
                                    i2++;
                                }
                                annotationWriter2.e(str, cArr2);
                                return i6;
                            case 68:
                                double[] dArr = new double[iU];
                                while (i2 < iU) {
                                    dArr[i2] = Double.longBitsToDouble(m(this.f3700b[u(i6 + 1)]));
                                    i6 += 3;
                                    i2++;
                                }
                                annotationWriter2.e(str, dArr);
                                return i6;
                            default:
                                return k(annotationWriter2.f(str), i6 - 2, false, cArr);
                        }
                    }
                    switch (i5) {
                        case 66:
                            annotationWriter2.e(str, Byte.valueOf((byte) l(this.f3700b[u(i4)])));
                            break;
                        case 67:
                            annotationWriter2.e(str, Character.valueOf((char) l(this.f3700b[u(i4)])));
                            break;
                        case 68:
                            break;
                        default:
                            throw new IllegalArgumentException();
                    }
                }
            }
        }
        return i4 + 2;
    }

    public final int k(AnnotationWriter2 annotationWriter2, int i, boolean z2, char[] cArr) {
        int iU = u(i);
        int iJ = i + 2;
        if (!z2) {
            while (true) {
                int i2 = iU - 1;
                if (iU <= 0) {
                    break;
                }
                iJ = j(annotationWriter2, iJ, null, cArr);
                iU = i2;
            }
        } else {
            while (true) {
                int i3 = iU - 1;
                if (iU <= 0) {
                    break;
                }
                iJ = j(annotationWriter2, iJ + 2, t(iJ, cArr), cArr);
                iU = i3;
            }
        }
        if (annotationWriter2 != null) {
            annotationWriter2.g();
        }
        return iJ;
    }

    public int l(int i) {
        byte[] bArr = this.a;
        return (bArr[i + 3] & 255) | ((bArr[i] & 255) << 24) | ((bArr[i + 1] & 255) << 16) | ((bArr[i + 2] & 255) << 8);
    }

    public long m(int i) {
        return (l(i) << 32) | (l(i + 4) & 4294967295L);
    }

    public String n(int i, char[] cArr) {
        return t(this.f3700b[u(i)], cArr);
    }

    public String o(int i, char[] cArr) {
        return t(this.f3700b[u(i)], cArr);
    }

    public final void p(MethodVisitor2 methodVisitor2, Context3 context3, int i, boolean z2) {
        AnnotationWriter2 annotationWriter2;
        int iK = i + 1;
        int i2 = this.a[i] & 255;
        MethodWriter2 methodWriter2 = (MethodWriter2) methodVisitor2;
        if (z2) {
            methodWriter2.D = i2;
        } else {
            methodWriter2.F = i2;
        }
        char[] cArr = context3.c;
        for (int i3 = 0; i3 < i2; i3++) {
            int iU = u(iK);
            iK += 2;
            while (true) {
                int i4 = iU - 1;
                if (iU > 0) {
                    String strT = t(iK, cArr);
                    int i5 = iK + 2;
                    ByteVector2 byteVector2 = new ByteVector2();
                    byteVector2.j(methodWriter2.d.l(strT));
                    byteVector2.j(0);
                    if (z2) {
                        if (methodWriter2.E == null) {
                            methodWriter2.E = new AnnotationWriter2[Type2.a(methodWriter2.i).length];
                        }
                        AnnotationWriter2[] annotationWriter2Arr = methodWriter2.E;
                        annotationWriter2 = new AnnotationWriter2(methodWriter2.d, true, byteVector2, annotationWriter2Arr[i3]);
                        annotationWriter2Arr[i3] = annotationWriter2;
                    } else {
                        if (methodWriter2.G == null) {
                            methodWriter2.G = new AnnotationWriter2[Type2.a(methodWriter2.i).length];
                        }
                        AnnotationWriter2[] annotationWriter2Arr2 = methodWriter2.G;
                        annotationWriter2 = new AnnotationWriter2(methodWriter2.d, true, byteVector2, annotationWriter2Arr2[i3]);
                        annotationWriter2Arr2[i3] = annotationWriter2;
                    }
                    iK = k(annotationWriter2, i5, true, cArr);
                    iU = i4;
                }
            }
        }
    }

    public short q(int i) {
        byte[] bArr = this.a;
        return (short) ((bArr[i + 1] & 255) | ((bArr[i] & 255) << 8));
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0070  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final int r(Context3 context3, int i) {
        int i2;
        int i3;
        int iL = l(i);
        int i4 = iL >>> 24;
        if (i4 == 0 || i4 == 1) {
            i2 = iL & (-65536);
            i3 = i + 2;
        } else {
            switch (i4) {
                case 16:
                case 17:
                case 18:
                case 23:
                    i2 = iL & InputDeviceCompat.SOURCE_ANY;
                    i3 = i + 3;
                    break;
                case 19:
                case 20:
                case 21:
                    i2 = iL & ViewCompat.MEASURED_STATE_MASK;
                    i3 = i + 1;
                    break;
                case 22:
                    break;
                default:
                    switch (i4) {
                        case 64:
                        case 65:
                            i2 = iL & ViewCompat.MEASURED_STATE_MASK;
                            int iU = u(i + 1);
                            i3 = i + 3;
                            context3.j = new Label2[iU];
                            context3.k = new Label2[iU];
                            context3.l = new int[iU];
                            for (int i5 = 0; i5 < iU; i5++) {
                                int iU2 = u(i3);
                                int iU3 = u(i3 + 2);
                                int iU4 = u(i3 + 4);
                                i3 += 6;
                                context3.j[i5] = b(iU2, context3.g);
                                context3.k[i5] = b(iU2 + iU3, context3.g);
                                context3.l[i5] = iU4;
                            }
                            break;
                        case 66:
                            break;
                        case 67:
                        case 68:
                        case 69:
                        case 70:
                            i2 = iL & ViewCompat.MEASURED_STATE_MASK;
                            i3 = i + 3;
                            break;
                        case 71:
                        case 72:
                        case 73:
                        case 74:
                        case 75:
                            i2 = iL & (-16776961);
                            i3 = i + 4;
                            break;
                        default:
                            throw new IllegalArgumentException();
                    }
            }
        }
        context3.h = i2;
        int iF = f(i3);
        context3.i = iF == 0 ? null : new TypePath2(this.a, i3);
        return (iF * 2) + i3 + 1;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x004e A[FALL_THROUGH] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final int[] s(MethodVisitor2 methodVisitor2, Context3 context3, int i, boolean z2) {
        int i2;
        AnnotationWriter2 annotationWriter2;
        char[] cArr = context3.c;
        int iU = u(i);
        int[] iArr = new int[iU];
        int iK = i + 2;
        for (int i3 = 0; i3 < iU; i3++) {
            iArr[i3] = iK;
            int iL = l(iK);
            int i4 = iL >>> 24;
            if (i4 != 23) {
                switch (i4) {
                    default:
                        switch (i4) {
                            case 64:
                            case 65:
                                int iU2 = u(iK + 1);
                                i2 = iK + 3;
                                while (true) {
                                    int i5 = iU2 - 1;
                                    if (iU2 <= 0) {
                                        break;
                                    } else {
                                        int iU3 = u(i2);
                                        int iU4 = u(i2 + 2);
                                        i2 += 6;
                                        b(iU3, context3.g);
                                        b(iU3 + iU4, context3.g);
                                        iU2 = i5;
                                    }
                                }
                            case 66:
                            case 67:
                            case 68:
                            case 69:
                            case 70:
                                break;
                            case 71:
                            case 72:
                            case 73:
                            case 74:
                            case 75:
                                i2 = iK + 4;
                                break;
                            default:
                                throw new IllegalArgumentException();
                        }
                    case 16:
                    case 17:
                    case 18:
                        i2 = iK + 3;
                        break;
                }
            }
            int iF = f(i2);
            if (i4 == 66) {
                TypePath2 typePath2 = iF != 0 ? new TypePath2(this.a, i2) : null;
                int i6 = (iF * 2) + 1 + i2;
                String strT = t(i6, cArr);
                int i7 = i6 + 2;
                int i8 = iL & InputDeviceCompat.SOURCE_ANY;
                MethodWriter2 methodWriter2 = (MethodWriter2) methodVisitor2;
                Objects.requireNonNull(methodWriter2);
                ByteVector2 byteVector2 = new ByteVector2();
                b.i.a.f.e.o.f.W0(i8, byteVector2);
                TypePath2.a(typePath2, byteVector2);
                byteVector2.j(methodWriter2.d.l(strT));
                byteVector2.j(0);
                if (z2) {
                    annotationWriter2 = new AnnotationWriter2(methodWriter2.d, true, byteVector2, methodWriter2.w);
                    methodWriter2.w = annotationWriter2;
                } else {
                    annotationWriter2 = new AnnotationWriter2(methodWriter2.d, true, byteVector2, methodWriter2.f3719x);
                    methodWriter2.f3719x = annotationWriter2;
                }
                iK = k(annotationWriter2, i7, true, cArr);
            } else {
                iK = k(null, (iF * 2) + 3 + i2, true, cArr);
            }
        }
        return iArr;
    }

    public String t(int i, char[] cArr) {
        int iU = u(i);
        if (i == 0 || iU == 0) {
            return null;
        }
        return w(iU, cArr);
    }

    public int u(int i) {
        byte[] bArr = this.a;
        return (bArr[i + 1] & 255) | ((bArr[i] & 255) << 8);
    }

    public final String v(int i, int i2, char[] cArr) {
        int i3;
        int i4 = i2 + i;
        byte[] bArr = this.a;
        int i5 = 0;
        while (i < i4) {
            int i6 = i + 1;
            byte b2 = bArr[i];
            if ((b2 & 128) == 0) {
                i3 = i5 + 1;
                cArr[i5] = (char) (b2 & 127);
            } else if ((b2 & 224) == 192) {
                cArr[i5] = (char) (((b2 & 31) << 6) + (bArr[i6] & 63));
                i5++;
                i = i6 + 1;
            } else {
                i3 = i5 + 1;
                int i7 = i6 + 1;
                int i8 = ((b2 & 15) << 12) + ((bArr[i6] & 63) << 6);
                i6 = i7 + 1;
                cArr[i5] = (char) (i8 + (bArr[i7] & 63));
            }
            i = i6;
            i5 = i3;
        }
        return new String(cArr, 0, i5);
    }

    public final String w(int i, char[] cArr) {
        String[] strArr = this.c;
        String str = strArr[i];
        if (str != null) {
            return str;
        }
        int i2 = this.f3700b[i];
        String strV = v(i2 + 2, u(i2), cArr);
        strArr[i] = strV;
        return strV;
    }

    public final int x(int i, Object[] objArr, int i2, char[] cArr, Label2[] label2Arr) {
        int i3 = i + 1;
        switch (this.a[i] & 255) {
            case 0:
                objArr[i2] = Opcodes2.a;
                return i3;
            case 1:
                objArr[i2] = Opcodes2.f3723b;
                return i3;
            case 2:
                objArr[i2] = Opcodes2.c;
                return i3;
            case 3:
                objArr[i2] = Opcodes2.d;
                return i3;
            case 4:
                objArr[i2] = Opcodes2.e;
                return i3;
            case 5:
                objArr[i2] = Opcodes2.f;
                return i3;
            case 6:
                objArr[i2] = Opcodes2.g;
                return i3;
            case 7:
                objArr[i2] = g(i3, cArr);
                break;
            case 8:
                objArr[i2] = b(u(i3), label2Arr);
                break;
            default:
                throw new IllegalArgumentException();
        }
        return i3 + 2;
    }
}
