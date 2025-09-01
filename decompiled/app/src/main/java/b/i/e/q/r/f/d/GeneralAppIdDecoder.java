package b.i.e.q.r.f.d;

import b.i.e.n.BitArray;
import com.discord.widgets.chat.input.MentionUtils;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;

/* compiled from: GeneralAppIdDecoder.java */
/* renamed from: b.i.e.q.r.f.d.s, reason: use source file name */
/* loaded from: classes3.dex */
public final class GeneralAppIdDecoder {
    public final BitArray a;

    /* renamed from: b, reason: collision with root package name */
    public final CurrentParsingState f1874b = new CurrentParsingState();
    public final StringBuilder c = new StringBuilder();

    public GeneralAppIdDecoder(BitArray bitArray) {
        this.a = bitArray;
    }

    public static int d(BitArray bitArray, int i, int i2) {
        int i3 = 0;
        for (int i4 = 0; i4 < i2; i4++) {
            if (bitArray.b(i + i4)) {
                i3 |= 1 << ((i2 - i4) - 1);
            }
        }
        return i3;
    }

    public String a(StringBuilder sb, int i) throws NotFoundException, FormatException {
        String str = null;
        while (true) {
            DecodedInformation decodedInformationB = b(i, str);
            String strA = FieldParser.a(decodedInformationB.f1871b);
            if (strA != null) {
                sb.append(strA);
            }
            String strValueOf = decodedInformationB.d ? String.valueOf(decodedInformationB.c) : null;
            int i2 = decodedInformationB.a;
            if (i == i2) {
                return sb.toString();
            }
            i = i2;
            str = strValueOf;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:154:0x0285, code lost:
    
        r1 = r2.f1868b;
     */
    /* JADX WARN: Removed duplicated region for block: B:172:0x02b9  */
    /* JADX WARN: Removed duplicated region for block: B:213:0x037e  */
    /* JADX WARN: Removed duplicated region for block: B:214:0x0387  */
    /* JADX WARN: Removed duplicated region for block: B:220:0x0399  */
    /* JADX WARN: Removed duplicated region for block: B:222:0x039c A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:223:0x039e A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:237:0x00ed A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:240:0x0249 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:242:0x0358 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x005e  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x017b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public DecodedInformation b(int i, String str) throws FormatException {
        boolean zB;
        boolean z2;
        BlockParsedResult blockParsedResult;
        boolean z3;
        DecodedNumeric decodedNumeric;
        boolean z4;
        char c;
        DecodedChar decodedChar;
        DecodedChar decodedChar2;
        int iD;
        int i2;
        boolean z5;
        char c2;
        DecodedChar decodedChar3;
        DecodedChar decodedChar4;
        int iD2;
        this.c.setLength(0);
        if (str != null) {
            this.c.append(str);
        }
        this.f1874b.a = i;
        int i3 = 2;
        while (true) {
            CurrentParsingState currentParsingState = this.f1874b;
            int i4 = currentParsingState.a;
            int i5 = currentParsingState.f1869b;
            if (i5 == i3) {
                while (true) {
                    int i6 = this.f1874b.a;
                    int i7 = i6 + 5;
                    BitArray bitArray = this.a;
                    if (i7 <= bitArray.k) {
                        int iD3 = d(bitArray, i6, 5);
                        if (iD3 < 5 || iD3 >= 16) {
                            int i8 = i6 + 6;
                            BitArray bitArray2 = this.a;
                            if (i8 > bitArray2.k || (iD2 = d(bitArray2, i6, 6)) < 16 || iD2 >= 63) {
                                z5 = false;
                            }
                            if (z5) {
                                if (e(this.f1874b.a)) {
                                    this.f1874b.a(3);
                                    this.f1874b.f1869b = 1;
                                } else if (f(this.f1874b.a)) {
                                    CurrentParsingState currentParsingState2 = this.f1874b;
                                    int i9 = currentParsingState2.a + 5;
                                    int i10 = this.a.k;
                                    if (i9 < i10) {
                                        currentParsingState2.a(5);
                                    } else {
                                        currentParsingState2.a = i10;
                                    }
                                    this.f1874b.f1869b = 3;
                                }
                                blockParsedResult = new BlockParsedResult(null, false);
                            } else {
                                int i11 = this.f1874b.a;
                                int iD4 = d(this.a, i11, 5);
                                if (iD4 == 15) {
                                    decodedChar4 = new DecodedChar(i11 + 5, '$');
                                } else {
                                    if (iD4 < 5 || iD4 >= 15) {
                                        int iD5 = d(this.a, i11, 6);
                                        if (iD5 < 32 || iD5 >= 58) {
                                            switch (iD5) {
                                                case 58:
                                                    c2 = '*';
                                                    break;
                                                case 59:
                                                    c2 = ',';
                                                    break;
                                                case 60:
                                                    c2 = '-';
                                                    break;
                                                case 61:
                                                    c2 = '.';
                                                    break;
                                                case 62:
                                                    c2 = MentionUtils.SLASH_CHAR;
                                                    break;
                                                default:
                                                    throw new IllegalStateException("Decoding invalid alphanumeric value: ".concat(String.valueOf(iD5)));
                                            }
                                            decodedChar3 = new DecodedChar(i11 + 6, c2);
                                        } else {
                                            decodedChar3 = new DecodedChar(i11 + 6, (char) (iD5 + 33));
                                        }
                                    } else {
                                        decodedChar3 = new DecodedChar(i11 + 5, (char) ((iD4 + 48) - 5));
                                    }
                                    decodedChar4 = decodedChar3;
                                }
                                CurrentParsingState currentParsingState3 = this.f1874b;
                                int i12 = decodedChar4.a;
                                currentParsingState3.a = i12;
                                char c3 = decodedChar4.f1870b;
                                if (c3 == '$') {
                                    blockParsedResult = new BlockParsedResult(new DecodedInformation(i12, this.c.toString()), true);
                                } else {
                                    this.c.append(c3);
                                }
                            }
                        }
                        z5 = true;
                        if (z5) {
                        }
                    }
                    i2 = this.f1874b.a;
                    if (((i4 != i2) || z3) && !z3) {
                    }
                }
                z3 = blockParsedResult.f1868b;
            } else if (i5 == 3) {
                while (true) {
                    int i13 = this.f1874b.a;
                    int i14 = i13 + 5;
                    BitArray bitArray3 = this.a;
                    if (i14 <= bitArray3.k) {
                        int iD6 = d(bitArray3, i13, 5);
                        if (iD6 < 5 || iD6 >= 16) {
                            int i15 = i13 + 7;
                            BitArray bitArray4 = this.a;
                            if (i15 <= bitArray4.k) {
                                int iD7 = d(bitArray4, i13, 7);
                                if (iD7 < 64 || iD7 >= 116) {
                                    int i16 = i13 + 8;
                                    BitArray bitArray5 = this.a;
                                    if (i16 <= bitArray5.k && (iD = d(bitArray5, i13, 8)) >= 232 && iD < 253) {
                                    }
                                    if (z4) {
                                        if (e(this.f1874b.a)) {
                                            this.f1874b.a(3);
                                            this.f1874b.f1869b = 1;
                                        } else if (f(this.f1874b.a)) {
                                            CurrentParsingState currentParsingState4 = this.f1874b;
                                            int i17 = currentParsingState4.a + 5;
                                            int i18 = this.a.k;
                                            if (i17 < i18) {
                                                currentParsingState4.a(5);
                                            } else {
                                                currentParsingState4.a = i18;
                                            }
                                            this.f1874b.f1869b = 2;
                                        }
                                        blockParsedResult = new BlockParsedResult(null, false);
                                    } else {
                                        int i19 = this.f1874b.a;
                                        int iD8 = d(this.a, i19, 5);
                                        if (iD8 == 15) {
                                            decodedChar2 = new DecodedChar(i19 + 5, '$');
                                        } else {
                                            if (iD8 < 5 || iD8 >= 15) {
                                                int iD9 = d(this.a, i19, 7);
                                                if (iD9 >= 64 && iD9 < 90) {
                                                    decodedChar = new DecodedChar(i19 + 7, (char) (iD9 + 1));
                                                } else if (iD9 < 90 || iD9 >= 116) {
                                                    switch (d(this.a, i19, 8)) {
                                                        case 232:
                                                            c = '!';
                                                            break;
                                                        case 233:
                                                            c = '\"';
                                                            break;
                                                        case 234:
                                                            c = '%';
                                                            break;
                                                        case 235:
                                                            c = '&';
                                                            break;
                                                        case 236:
                                                            c = '\'';
                                                            break;
                                                        case 237:
                                                            c = '(';
                                                            break;
                                                        case 238:
                                                            c = ')';
                                                            break;
                                                        case 239:
                                                            c = '*';
                                                            break;
                                                        case 240:
                                                            c = '+';
                                                            break;
                                                        case 241:
                                                            c = ',';
                                                            break;
                                                        case 242:
                                                            c = '-';
                                                            break;
                                                        case 243:
                                                            c = '.';
                                                            break;
                                                        case 244:
                                                            c = MentionUtils.SLASH_CHAR;
                                                            break;
                                                        case 245:
                                                            c = MentionUtils.EMOJIS_AND_STICKERS_CHAR;
                                                            break;
                                                        case 246:
                                                            c = ';';
                                                            break;
                                                        case 247:
                                                            c = '<';
                                                            break;
                                                        case 248:
                                                            c = '=';
                                                            break;
                                                        case 249:
                                                            c = '>';
                                                            break;
                                                        case 250:
                                                            c = '?';
                                                            break;
                                                        case 251:
                                                            c = '_';
                                                            break;
                                                        case 252:
                                                            c = ' ';
                                                            break;
                                                        default:
                                                            throw FormatException.a();
                                                    }
                                                    decodedChar = new DecodedChar(i19 + 8, c);
                                                } else {
                                                    decodedChar = new DecodedChar(i19 + 7, (char) (iD9 + 7));
                                                }
                                            } else {
                                                decodedChar = new DecodedChar(i19 + 5, (char) ((iD8 + 48) - 5));
                                            }
                                            decodedChar2 = decodedChar;
                                        }
                                        CurrentParsingState currentParsingState5 = this.f1874b;
                                        int i20 = decodedChar2.a;
                                        currentParsingState5.a = i20;
                                        char c4 = decodedChar2.f1870b;
                                        if (c4 == '$') {
                                            blockParsedResult = new BlockParsedResult(new DecodedInformation(i20, this.c.toString()), true);
                                        } else {
                                            this.c.append(c4);
                                        }
                                    }
                                }
                            }
                            z4 = false;
                            if (z4) {
                            }
                        }
                        z4 = true;
                        if (z4) {
                        }
                    } else {
                        z4 = false;
                        if (z4) {
                        }
                    }
                    i2 = this.f1874b.a;
                    i3 = i4 != i2 ? 2 : 2;
                }
            } else {
                while (true) {
                    int i21 = this.f1874b.a;
                    int i22 = i21 + 7;
                    int i23 = this.a.k;
                    if (i22 > i23) {
                        zB = i21 + 4 <= i23;
                        if (zB) {
                            int i24 = this.f1874b.a;
                            if (i24 + 1 > this.a.k) {
                                z2 = false;
                                if (!z2) {
                                    CurrentParsingState currentParsingState6 = this.f1874b;
                                    currentParsingState6.f1869b = 2;
                                    currentParsingState6.a(4);
                                }
                                blockParsedResult = new BlockParsedResult(null, false);
                            } else {
                                for (int i25 = 0; i25 < 4; i25++) {
                                    int i26 = i25 + i24;
                                    BitArray bitArray6 = this.a;
                                    if (i26 >= bitArray6.k) {
                                        z2 = true;
                                        if (!z2) {
                                        }
                                        blockParsedResult = new BlockParsedResult(null, false);
                                    } else if (bitArray6.b(i26)) {
                                        z2 = false;
                                        if (!z2) {
                                        }
                                        blockParsedResult = new BlockParsedResult(null, false);
                                    }
                                }
                                z2 = true;
                                if (!z2) {
                                }
                                blockParsedResult = new BlockParsedResult(null, false);
                            }
                        } else {
                            int i27 = this.f1874b.a;
                            int i28 = i27 + 7;
                            BitArray bitArray7 = this.a;
                            if (i28 > bitArray7.k) {
                                int iD10 = d(bitArray7, i27, 4);
                                decodedNumeric = iD10 == 0 ? new DecodedNumeric(this.a.k, 10, 10) : new DecodedNumeric(this.a.k, iD10 - 1, 10);
                            } else {
                                int iD11 = d(bitArray7, i27, 7) - 8;
                                decodedNumeric = new DecodedNumeric(i28, iD11 / 11, iD11 % 11);
                            }
                            CurrentParsingState currentParsingState7 = this.f1874b;
                            int i29 = decodedNumeric.a;
                            currentParsingState7.a = i29;
                            int i30 = decodedNumeric.f1872b;
                            if (i30 == 10) {
                                blockParsedResult = new BlockParsedResult(decodedNumeric.c == 10 ? new DecodedInformation(i29, this.c.toString()) : new DecodedInformation(i29, this.c.toString(), decodedNumeric.c), true);
                            } else {
                                this.c.append(i30);
                                int i31 = decodedNumeric.c;
                                if (i31 == 10) {
                                    blockParsedResult = new BlockParsedResult(new DecodedInformation(this.f1874b.a, this.c.toString()), true);
                                } else {
                                    this.c.append(i31);
                                }
                            }
                        }
                    } else {
                        int i32 = i21;
                        while (true) {
                            int i33 = i21 + 3;
                            if (i32 >= i33) {
                                zB = this.a.b(i33);
                            } else if (!this.a.b(i32)) {
                                i32++;
                            }
                        }
                        if (zB) {
                        }
                    }
                    i2 = this.f1874b.a;
                    if (i4 != i2) {
                    }
                }
                z3 = blockParsedResult.f1868b;
                i2 = this.f1874b.a;
                if (i4 != i2) {
                }
            }
            i2 = this.f1874b.a;
            if (i4 != i2) {
            }
        }
        DecodedInformation decodedInformation = blockParsedResult.a;
        return (decodedInformation == null || !decodedInformation.d) ? new DecodedInformation(i2, this.c.toString()) : new DecodedInformation(i2, this.c.toString(), decodedInformation.c);
    }

    public int c(int i, int i2) {
        return d(this.a, i, i2);
    }

    public final boolean e(int i) {
        int i2 = i + 3;
        if (i2 > this.a.k) {
            return false;
        }
        while (i < i2) {
            if (this.a.b(i)) {
                return false;
            }
            i++;
        }
        return true;
    }

    public final boolean f(int i) {
        if (i + 1 > this.a.k) {
            return false;
        }
        for (int i2 = 0; i2 < 5; i2++) {
            int i3 = i2 + i;
            BitArray bitArray = this.a;
            if (i3 >= bitArray.k) {
                return true;
            }
            if (i2 == 2) {
                if (!bitArray.b(i + 2)) {
                    return false;
                }
            } else if (bitArray.b(i3)) {
                return false;
            }
        }
        return true;
    }
}
