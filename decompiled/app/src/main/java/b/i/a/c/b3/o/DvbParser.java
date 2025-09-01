package b.i.a.c.b3.o;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.util.SparseArray;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import b.i.a.c.f3.ParsableBitArray;
import b.i.a.c.f3.Util2;
import org.objectweb.asm.Opcodes;

/* compiled from: DvbParser.java */
/* renamed from: b.i.a.c.b3.o.b, reason: use source file name */
/* loaded from: classes3.dex */
public final class DvbParser {
    public static final byte[] a = {0, 7, 8, 15};

    /* renamed from: b, reason: collision with root package name */
    public static final byte[] f862b = {0, 119, -120, -1};
    public static final byte[] c = {0, 17, 34, 51, 68, 85, 102, 119, -120, -103, -86, -69, -52, -35, -18, -1};
    public final Paint d;
    public final Paint e;
    public final Canvas f;
    public final b g;
    public final a h;
    public final h i;
    public Bitmap j;

    /* compiled from: DvbParser.java */
    /* renamed from: b.i.a.c.b3.o.b$a */
    public static final class a {
        public final int a;

        /* renamed from: b, reason: collision with root package name */
        public final int[] f863b;
        public final int[] c;
        public final int[] d;

        public a(int i, int[] iArr, int[] iArr2, int[] iArr3) {
            this.a = i;
            this.f863b = iArr;
            this.c = iArr2;
            this.d = iArr3;
        }
    }

    /* compiled from: DvbParser.java */
    /* renamed from: b.i.a.c.b3.o.b$b */
    public static final class b {
        public final int a;

        /* renamed from: b, reason: collision with root package name */
        public final int f864b;
        public final int c;
        public final int d;
        public final int e;
        public final int f;

        public b(int i, int i2, int i3, int i4, int i5, int i6) {
            this.a = i;
            this.f864b = i2;
            this.c = i3;
            this.d = i4;
            this.e = i5;
            this.f = i6;
        }
    }

    /* compiled from: DvbParser.java */
    /* renamed from: b.i.a.c.b3.o.b$c */
    public static final class c {
        public final int a;

        /* renamed from: b, reason: collision with root package name */
        public final boolean f865b;
        public final byte[] c;
        public final byte[] d;

        public c(int i, boolean z2, byte[] bArr, byte[] bArr2) {
            this.a = i;
            this.f865b = z2;
            this.c = bArr;
            this.d = bArr2;
        }
    }

    /* compiled from: DvbParser.java */
    /* renamed from: b.i.a.c.b3.o.b$d */
    public static final class d {
        public final int a;

        /* renamed from: b, reason: collision with root package name */
        public final int f866b;
        public final SparseArray<e> c;

        public d(int i, int i2, int i3, SparseArray<e> sparseArray) {
            this.a = i2;
            this.f866b = i3;
            this.c = sparseArray;
        }
    }

    /* compiled from: DvbParser.java */
    /* renamed from: b.i.a.c.b3.o.b$e */
    public static final class e {
        public final int a;

        /* renamed from: b, reason: collision with root package name */
        public final int f867b;

        public e(int i, int i2) {
            this.a = i;
            this.f867b = i2;
        }
    }

    /* compiled from: DvbParser.java */
    /* renamed from: b.i.a.c.b3.o.b$f */
    public static final class f {
        public final int a;

        /* renamed from: b, reason: collision with root package name */
        public final boolean f868b;
        public final int c;
        public final int d;
        public final int e;
        public final int f;
        public final int g;
        public final int h;
        public final int i;
        public final SparseArray<g> j;

        public f(int i, boolean z2, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, SparseArray<g> sparseArray) {
            this.a = i;
            this.f868b = z2;
            this.c = i2;
            this.d = i3;
            this.e = i5;
            this.f = i6;
            this.g = i7;
            this.h = i8;
            this.i = i9;
            this.j = sparseArray;
        }
    }

    /* compiled from: DvbParser.java */
    /* renamed from: b.i.a.c.b3.o.b$g */
    public static final class g {
        public final int a;

        /* renamed from: b, reason: collision with root package name */
        public final int f869b;

        public g(int i, int i2, int i3, int i4, int i5, int i6) {
            this.a = i3;
            this.f869b = i4;
        }
    }

    /* compiled from: DvbParser.java */
    /* renamed from: b.i.a.c.b3.o.b$h */
    public static final class h {
        public final int a;

        /* renamed from: b, reason: collision with root package name */
        public final int f870b;
        public final SparseArray<f> c = new SparseArray<>();
        public final SparseArray<a> d = new SparseArray<>();
        public final SparseArray<c> e = new SparseArray<>();
        public final SparseArray<a> f = new SparseArray<>();
        public final SparseArray<c> g = new SparseArray<>();

        @Nullable
        public b h;

        @Nullable
        public d i;

        public h(int i, int i2) {
            this.a = i;
            this.f870b = i2;
        }
    }

    public DvbParser(int i, int i2) {
        Paint paint = new Paint();
        this.d = paint;
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC));
        paint.setPathEffect(null);
        Paint paint2 = new Paint();
        this.e = paint2;
        paint2.setStyle(Paint.Style.FILL);
        paint2.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OVER));
        paint2.setPathEffect(null);
        this.f = new Canvas();
        this.g = new b(719, 575, 0, 719, 0, 575);
        this.h = new a(0, new int[]{0, -1, ViewCompat.MEASURED_STATE_MASK, -8421505}, b(), c());
        this.i = new h(i, i2);
    }

    public static byte[] a(int i, int i2, ParsableBitArray parsableBitArray) {
        byte[] bArr = new byte[i];
        for (int i3 = 0; i3 < i; i3++) {
            bArr[i3] = (byte) parsableBitArray.g(i2);
        }
        return bArr;
    }

    public static int[] b() {
        int[] iArr = new int[16];
        iArr[0] = 0;
        for (int i = 1; i < 16; i++) {
            if (i < 8) {
                iArr[i] = d(255, (i & 1) != 0 ? 255 : 0, (i & 2) != 0 ? 255 : 0, (i & 4) != 0 ? 255 : 0);
            } else {
                int i2 = i & 1;
                int i3 = Opcodes.LAND;
                int i4 = i2 != 0 ? Opcodes.LAND : 0;
                int i5 = (i & 2) != 0 ? Opcodes.LAND : 0;
                if ((i & 4) == 0) {
                    i3 = 0;
                }
                iArr[i] = d(255, i4, i5, i3);
            }
        }
        return iArr;
    }

    public static int[] c() {
        int i;
        int[] iArr = new int[256];
        iArr[0] = 0;
        for (int i2 = 0; i2 < 256; i2++) {
            if (i2 < 8) {
                iArr[i2] = d(63, (i2 & 1) != 0 ? 255 : 0, (i2 & 2) != 0 ? 255 : 0, (i2 & 4) == 0 ? 0 : 255);
            } else {
                int i3 = i2 & Opcodes.L2I;
                int i4 = Opcodes.TABLESWITCH;
                if (i3 == 0) {
                    int i5 = ((i2 & 1) != 0 ? 85 : 0) + ((i2 & 16) != 0 ? Opcodes.TABLESWITCH : 0);
                    int i6 = ((i2 & 2) != 0 ? 85 : 0) + ((i2 & 32) != 0 ? Opcodes.TABLESWITCH : 0);
                    i = (i2 & 4) == 0 ? 0 : 85;
                    if ((i2 & 64) == 0) {
                        i4 = 0;
                    }
                    iArr[i2] = d(255, i5, i6, i + i4);
                } else if (i3 == 8) {
                    int i7 = ((i2 & 1) != 0 ? 85 : 0) + ((i2 & 16) != 0 ? Opcodes.TABLESWITCH : 0);
                    int i8 = ((i2 & 2) != 0 ? 85 : 0) + ((i2 & 32) != 0 ? Opcodes.TABLESWITCH : 0);
                    i = (i2 & 4) == 0 ? 0 : 85;
                    if ((i2 & 64) == 0) {
                        i4 = 0;
                    }
                    iArr[i2] = d(Opcodes.LAND, i7, i8, i + i4);
                } else if (i3 == 128) {
                    iArr[i2] = d(255, ((i2 & 1) != 0 ? 43 : 0) + Opcodes.LAND + ((i2 & 16) != 0 ? 85 : 0), ((i2 & 2) != 0 ? 43 : 0) + Opcodes.LAND + ((i2 & 32) != 0 ? 85 : 0), ((i2 & 4) == 0 ? 0 : 43) + Opcodes.LAND + ((i2 & 64) == 0 ? 0 : 85));
                } else if (i3 == 136) {
                    iArr[i2] = d(255, ((i2 & 1) != 0 ? 43 : 0) + ((i2 & 16) != 0 ? 85 : 0), ((i2 & 2) != 0 ? 43 : 0) + ((i2 & 32) != 0 ? 85 : 0), ((i2 & 4) == 0 ? 0 : 43) + ((i2 & 64) == 0 ? 0 : 85));
                }
            }
        }
        return iArr;
    }

    public static int d(int i, int i2, int i3, int i4) {
        return (i << 24) | (i2 << 16) | (i3 << 8) | i4;
    }

    /* JADX WARN: Removed duplicated region for block: B:110:0x01d1 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:114:0x01fb  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x020b A[LOOP:3: B:87:0x0163->B:118:0x020b, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:141:0x013b A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:142:0x0205 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0112 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0134  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0141 A[LOOP:2: B:41:0x00ab->B:74:0x0141, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:90:0x016a  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0184 A[PHI: r1
      0x0184: PHI (r1v4 int) = (r1v3 int), (r1v22 int) binds: [B:88:0x0167, B:95:0x0183] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void e(byte[] bArr, int[] iArr, int i, int i2, int i3, @Nullable Paint paint, Canvas canvas) {
        byte[] bArr2;
        byte[] bArr3;
        boolean z2;
        int iG;
        boolean z3;
        int i4;
        int i5;
        int iG2;
        int iG3;
        byte[] bArr4;
        boolean z4;
        int iG4;
        int i6;
        int i7;
        int iG5;
        boolean z5;
        int iG6;
        ParsableBitArray parsableBitArray = new ParsableBitArray(bArr);
        int i8 = i2;
        int i9 = i3;
        byte[] bArrA = null;
        byte[] bArrA2 = null;
        byte[] bArrA3 = null;
        while (parsableBitArray.b() != 0) {
            int i10 = 8;
            int iG7 = parsableBitArray.g(8);
            if (iG7 != 240) {
                int i11 = 4;
                int i12 = 2;
                switch (iG7) {
                    case 16:
                        if (i == 3) {
                            bArr3 = bArrA == null ? f862b : bArrA;
                        } else if (i == 2) {
                            bArr3 = bArrA3 == null ? a : bArrA3;
                        } else {
                            bArr2 = null;
                            int i13 = i8;
                            z2 = false;
                            while (true) {
                                iG = parsableBitArray.g(2);
                                if (iG == 0) {
                                    if (parsableBitArray.f()) {
                                        iG2 = parsableBitArray.g(3) + 3;
                                        iG3 = parsableBitArray.g(2);
                                    } else if (parsableBitArray.f()) {
                                        iG = 0;
                                        z3 = z2;
                                        i4 = 1;
                                        if (i4 == 0 || paint == null) {
                                            i5 = i13;
                                        } else {
                                            if (bArr2 != 0) {
                                                iG = bArr2[iG];
                                            }
                                            paint.setColor(iArr[iG]);
                                            i5 = i13;
                                            canvas.drawRect(i13, i9, i13 + i4, i9 + 1, paint);
                                        }
                                        i13 = i5 + i4;
                                        if (!z3) {
                                            parsableBitArray.c();
                                            i8 = i13;
                                            break;
                                        } else {
                                            z2 = z3;
                                        }
                                    } else {
                                        int iG8 = parsableBitArray.g(2);
                                        if (iG8 == 0) {
                                            z2 = true;
                                        } else if (iG8 == 1) {
                                            z3 = z2;
                                            iG = 0;
                                            i4 = 2;
                                            if (i4 == 0) {
                                                i5 = i13;
                                                i13 = i5 + i4;
                                                if (!z3) {
                                                }
                                            }
                                        } else if (iG8 == 2) {
                                            iG2 = parsableBitArray.g(4) + 12;
                                            iG3 = parsableBitArray.g(2);
                                        } else if (iG8 == 3) {
                                            iG2 = parsableBitArray.g(8) + 29;
                                            iG3 = parsableBitArray.g(2);
                                        }
                                        z3 = z2;
                                        iG = 0;
                                        i4 = 0;
                                        if (i4 == 0) {
                                        }
                                    }
                                    i4 = iG2;
                                    iG = iG3;
                                    z3 = z2;
                                    if (i4 == 0) {
                                    }
                                } else {
                                    z3 = z2;
                                    i4 = 1;
                                    if (i4 == 0) {
                                    }
                                }
                            }
                        }
                        bArr2 = bArr3;
                        int i132 = i8;
                        z2 = false;
                        while (true) {
                            iG = parsableBitArray.g(2);
                            if (iG == 0) {
                            }
                            z2 = z3;
                        }
                    case 17:
                        if (i == 3) {
                            bArr4 = bArrA2 == null ? c : bArrA2;
                        } else {
                            bArr4 = null;
                        }
                        int i14 = i8;
                        boolean z6 = false;
                        while (true) {
                            int iG9 = parsableBitArray.g(i11);
                            if (iG9 != 0) {
                                z4 = z6;
                                iG4 = iG9;
                                i6 = 1;
                                if (i6 == 0) {
                                }
                            } else if (parsableBitArray.f()) {
                                if (parsableBitArray.f()) {
                                    int iG10 = parsableBitArray.g(i12);
                                    if (iG10 == 0) {
                                        iG9 = 0;
                                        z4 = z6;
                                        iG4 = iG9;
                                        i6 = 1;
                                        if (i6 == 0) {
                                        }
                                    } else if (iG10 == 1) {
                                        z4 = z6;
                                        iG4 = 0;
                                        i6 = 2;
                                        if (i6 == 0) {
                                        }
                                    } else if (iG10 != i12) {
                                        if (iG10 == 3) {
                                            iG5 = parsableBitArray.g(i10) + 25;
                                            iG4 = parsableBitArray.g(i11);
                                        }
                                        z4 = z6;
                                        iG4 = 0;
                                        i6 = 0;
                                        if (i6 == 0) {
                                        }
                                    } else {
                                        iG5 = parsableBitArray.g(i11) + 9;
                                        iG4 = parsableBitArray.g(i11);
                                    }
                                } else {
                                    iG5 = parsableBitArray.g(i12) + i11;
                                    iG4 = parsableBitArray.g(i11);
                                }
                                z4 = z6;
                                i6 = iG5;
                                if (i6 == 0) {
                                }
                            } else {
                                int iG11 = parsableBitArray.g(3);
                                if (iG11 != 0) {
                                    z4 = z6;
                                    i6 = iG11 + 2;
                                    iG4 = 0;
                                    if (i6 == 0 || paint == null) {
                                        i7 = i14;
                                    } else {
                                        if (bArr4 != 0) {
                                            iG4 = bArr4[iG4];
                                        }
                                        paint.setColor(iArr[iG4]);
                                        i7 = i14;
                                        canvas.drawRect(i14, i9, i14 + i6, i9 + 1, paint);
                                    }
                                    i14 = i7 + i6;
                                    if (!z4) {
                                        parsableBitArray.c();
                                        i8 = i14;
                                        break;
                                    } else {
                                        z6 = z4;
                                        i12 = 2;
                                        i11 = 4;
                                        i10 = 8;
                                    }
                                } else {
                                    z6 = true;
                                    z4 = z6;
                                    iG4 = 0;
                                    i6 = 0;
                                    if (i6 == 0) {
                                        i7 = i14;
                                        i14 = i7 + i6;
                                        if (!z4) {
                                        }
                                    }
                                }
                            }
                        }
                    case 18:
                        int i15 = i8;
                        boolean z7 = false;
                        while (true) {
                            int iG12 = parsableBitArray.g(8);
                            if (iG12 != 0) {
                                z5 = z7;
                                iG6 = 1;
                            } else if (parsableBitArray.f()) {
                                z5 = z7;
                                iG6 = parsableBitArray.g(7);
                                iG12 = parsableBitArray.g(8);
                            } else {
                                int iG13 = parsableBitArray.g(7);
                                if (iG13 != 0) {
                                    z5 = z7;
                                    iG6 = iG13;
                                    iG12 = 0;
                                } else {
                                    iG12 = 0;
                                    z5 = true;
                                    iG6 = 0;
                                }
                            }
                            if (iG6 != 0 && paint != null) {
                                paint.setColor(iArr[iG12]);
                                canvas.drawRect(i15, i9, i15 + iG6, i9 + 1, paint);
                            }
                            i15 += iG6;
                            if (z5) {
                                i8 = i15;
                                break;
                            } else {
                                z7 = z5;
                            }
                        }
                    default:
                        switch (iG7) {
                            case 32:
                                bArrA3 = a(4, 4, parsableBitArray);
                                break;
                            case 33:
                                bArrA = a(4, 8, parsableBitArray);
                                break;
                            case 34:
                                bArrA2 = a(16, 8, parsableBitArray);
                                break;
                        }
                }
            } else {
                i9 += 2;
                i8 = i2;
            }
        }
    }

    public static a f(ParsableBitArray parsableBitArray, int i) {
        int iG;
        int iG2;
        int iG3;
        int iG4;
        int i2 = 8;
        int iG5 = parsableBitArray.g(8);
        parsableBitArray.m(8);
        int i3 = i - 2;
        int i4 = 4;
        int[] iArr = {0, -1, ViewCompat.MEASURED_STATE_MASK, -8421505};
        int[] iArrB = b();
        int[] iArrC = c();
        while (i3 > 0) {
            int iG6 = parsableBitArray.g(i2);
            int iG7 = parsableBitArray.g(i2);
            int i5 = i3 - 2;
            int[] iArr2 = (iG7 & 128) != 0 ? iArr : (iG7 & 64) != 0 ? iArrB : iArrC;
            if ((iG7 & 1) != 0) {
                iG3 = parsableBitArray.g(i2);
                iG = parsableBitArray.g(i2);
                iG4 = parsableBitArray.g(i2);
                iG2 = parsableBitArray.g(i2);
                i3 = i5 - 4;
            } else {
                int iG8 = parsableBitArray.g(6) << 2;
                int iG9 = parsableBitArray.g(i4) << i4;
                int iG10 = parsableBitArray.g(i4) << i4;
                i3 = i5 - 2;
                iG = iG9;
                iG2 = parsableBitArray.g(2) << 6;
                iG3 = iG8;
                iG4 = iG10;
            }
            if (iG3 == 0) {
                iG = 0;
                iG4 = 0;
                iG2 = 255;
            }
            double d2 = iG3;
            double d3 = iG - 128;
            double d4 = iG4 - 128;
            iArr2[iG6] = d((byte) (255 - (iG2 & 255)), Util2.h((int) ((1.402d * d3) + d2), 0, 255), Util2.h((int) ((d2 - (0.34414d * d4)) - (d3 * 0.71414d)), 0, 255), Util2.h((int) ((d4 * 1.772d) + d2), 0, 255));
            iArr = iArr;
            iG5 = iG5;
            i2 = 8;
            i4 = 4;
        }
        return new a(iG5, iArr, iArrB, iArrC);
    }

    public static c g(ParsableBitArray parsableBitArray) {
        byte[] bArr;
        int iG = parsableBitArray.g(16);
        parsableBitArray.m(4);
        int iG2 = parsableBitArray.g(2);
        boolean zF = parsableBitArray.f();
        parsableBitArray.m(1);
        byte[] bArr2 = Util2.f;
        if (iG2 != 1) {
            if (iG2 == 0) {
                int iG3 = parsableBitArray.g(16);
                int iG4 = parsableBitArray.g(16);
                if (iG3 > 0) {
                    bArr2 = new byte[iG3];
                    parsableBitArray.i(bArr2, 0, iG3);
                }
                if (iG4 > 0) {
                    bArr = new byte[iG4];
                    parsableBitArray.i(bArr, 0, iG4);
                }
            }
            return new c(iG, zF, bArr2, bArr);
        }
        parsableBitArray.m(parsableBitArray.g(8) * 16);
        bArr = bArr2;
        return new c(iG, zF, bArr2, bArr);
    }
}
