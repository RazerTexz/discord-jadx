package b.i.a.f.h.l;

import b.d.b.a.outline;
import b.i.a.f.h.l.h4;
import b.i.a.f.h.l.u4;
import com.discord.api.permission.Permission;
import com.google.android.gms.internal.measurement.zzhi;
import com.google.android.gms.internal.measurement.zzij;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.RandomAccess;
import sun.misc.Unsafe;

/* compiled from: com.google.android.gms:play-services-measurement-base@@18.0.0 */
/* loaded from: classes3.dex */
public final class e6<T> implements q6<T> {
    public static final int[] a = new int[0];

    /* renamed from: b, reason: collision with root package name */
    public static final Unsafe f1441b = j7.k();
    public final int[] c;
    public final Object[] d;
    public final int e;
    public final int f;
    public final c6 g;
    public final boolean h;
    public final boolean i;
    public final int[] j;
    public final int k;
    public final int l;
    public final i6 m;
    public final m5 n;
    public final d7<?, ?> o;
    public final j4<?> p;
    public final v5 q;

    public e6(int[] iArr, Object[] objArr, int i, int i2, c6 c6Var, boolean z2, int[] iArr2, int i3, int i4, i6 i6Var, m5 m5Var, d7 d7Var, j4 j4Var, v5 v5Var) {
        this.c = iArr;
        this.d = objArr;
        this.e = i;
        this.f = i2;
        boolean z3 = c6Var instanceof u4;
        this.i = z2;
        this.h = j4Var != null && j4Var.e(c6Var);
        this.j = iArr2;
        this.k = i3;
        this.l = i4;
        this.m = i6Var;
        this.n = m5Var;
        this.o = d7Var;
        this.p = j4Var;
        this.g = c6Var;
        this.q = v5Var;
    }

    public static <T> float F(T t, long j) {
        return ((Float) j7.r(t, j)).floatValue();
    }

    public static <T> int J(T t, long j) {
        return ((Integer) j7.r(t, j)).intValue();
    }

    public static <T> long L(T t, long j) {
        return ((Long) j7.r(t, j)).longValue();
    }

    public static c7 M(Object obj) {
        u4 u4Var = (u4) obj;
        c7 c7Var = u4Var.zzb;
        if (c7Var != c7.a) {
            return c7Var;
        }
        c7 c7VarC = c7.c();
        u4Var.zzb = c7VarC;
        return c7VarC;
    }

    public static <T> boolean N(T t, long j) {
        return ((Boolean) j7.r(t, j)).booleanValue();
    }

    /* JADX WARN: Removed duplicated region for block: B:182:0x03a5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static e6 n(a6 a6Var, i6 i6Var, m5 m5Var, d7 d7Var, j4 j4Var, v5 v5Var) {
        int i;
        int iCharAt;
        int iCharAt2;
        int iCharAt3;
        int iCharAt4;
        int i2;
        int i3;
        int[] iArr;
        int i4;
        char cCharAt;
        int i5;
        char cCharAt2;
        int i6;
        char cCharAt3;
        int i7;
        char cCharAt4;
        int i8;
        char cCharAt5;
        int i9;
        char cCharAt6;
        int i10;
        char cCharAt7;
        int i11;
        char cCharAt8;
        int i12;
        int i13;
        int i14;
        int i15;
        o6 o6Var;
        boolean z2;
        Object[] objArr;
        int iObjectFieldOffset;
        int i16;
        String str;
        int iObjectFieldOffset2;
        int i17;
        Field fieldP;
        int i18;
        char cCharAt9;
        int i19;
        int i20;
        Field fieldP2;
        Field fieldP3;
        int i21;
        char cCharAt10;
        int i22;
        char cCharAt11;
        int i23;
        char cCharAt12;
        int i24;
        char cCharAt13;
        if (!(a6Var instanceof o6)) {
            throw new NoSuchMethodError();
        }
        o6 o6Var2 = (o6) a6Var;
        int i25 = 0;
        boolean z3 = ((o6Var2.d & 1) == 1 ? (char) 1 : (char) 2) == 2;
        String str2 = o6Var2.f1477b;
        int length = str2.length();
        if (str2.charAt(0) >= 55296) {
            int i26 = 1;
            while (true) {
                i = i26 + 1;
                if (str2.charAt(i26) < 55296) {
                    break;
                }
                i26 = i;
            }
        } else {
            i = 1;
        }
        int i27 = i + 1;
        int iCharAt5 = str2.charAt(i);
        if (iCharAt5 >= 55296) {
            int i28 = iCharAt5 & 8191;
            int i29 = 13;
            while (true) {
                i24 = i27 + 1;
                cCharAt13 = str2.charAt(i27);
                if (cCharAt13 < 55296) {
                    break;
                }
                i28 |= (cCharAt13 & 8191) << i29;
                i29 += 13;
                i27 = i24;
            }
            iCharAt5 = i28 | (cCharAt13 << i29);
            i27 = i24;
        }
        if (iCharAt5 == 0) {
            iArr = a;
            i3 = 0;
            iCharAt = 0;
            iCharAt2 = 0;
            iCharAt3 = 0;
            i2 = 0;
            iCharAt4 = 0;
        } else {
            int i30 = i27 + 1;
            int iCharAt6 = str2.charAt(i27);
            if (iCharAt6 >= 55296) {
                int i31 = iCharAt6 & 8191;
                int i32 = 13;
                while (true) {
                    i11 = i30 + 1;
                    cCharAt8 = str2.charAt(i30);
                    if (cCharAt8 < 55296) {
                        break;
                    }
                    i31 |= (cCharAt8 & 8191) << i32;
                    i32 += 13;
                    i30 = i11;
                }
                iCharAt6 = i31 | (cCharAt8 << i32);
                i30 = i11;
            }
            int i33 = i30 + 1;
            int iCharAt7 = str2.charAt(i30);
            if (iCharAt7 >= 55296) {
                int i34 = iCharAt7 & 8191;
                int i35 = 13;
                while (true) {
                    i10 = i33 + 1;
                    cCharAt7 = str2.charAt(i33);
                    if (cCharAt7 < 55296) {
                        break;
                    }
                    i34 |= (cCharAt7 & 8191) << i35;
                    i35 += 13;
                    i33 = i10;
                }
                iCharAt7 = i34 | (cCharAt7 << i35);
                i33 = i10;
            }
            int i36 = i33 + 1;
            iCharAt = str2.charAt(i33);
            if (iCharAt >= 55296) {
                int i37 = iCharAt & 8191;
                int i38 = 13;
                while (true) {
                    i9 = i36 + 1;
                    cCharAt6 = str2.charAt(i36);
                    if (cCharAt6 < 55296) {
                        break;
                    }
                    i37 |= (cCharAt6 & 8191) << i38;
                    i38 += 13;
                    i36 = i9;
                }
                iCharAt = i37 | (cCharAt6 << i38);
                i36 = i9;
            }
            int i39 = i36 + 1;
            iCharAt2 = str2.charAt(i36);
            if (iCharAt2 >= 55296) {
                int i40 = iCharAt2 & 8191;
                int i41 = 13;
                while (true) {
                    i8 = i39 + 1;
                    cCharAt5 = str2.charAt(i39);
                    if (cCharAt5 < 55296) {
                        break;
                    }
                    i40 |= (cCharAt5 & 8191) << i41;
                    i41 += 13;
                    i39 = i8;
                }
                iCharAt2 = i40 | (cCharAt5 << i41);
                i39 = i8;
            }
            int i42 = i39 + 1;
            iCharAt3 = str2.charAt(i39);
            if (iCharAt3 >= 55296) {
                int i43 = iCharAt3 & 8191;
                int i44 = 13;
                while (true) {
                    i7 = i42 + 1;
                    cCharAt4 = str2.charAt(i42);
                    if (cCharAt4 < 55296) {
                        break;
                    }
                    i43 |= (cCharAt4 & 8191) << i44;
                    i44 += 13;
                    i42 = i7;
                }
                iCharAt3 = i43 | (cCharAt4 << i44);
                i42 = i7;
            }
            int i45 = i42 + 1;
            int iCharAt8 = str2.charAt(i42);
            if (iCharAt8 >= 55296) {
                int i46 = iCharAt8 & 8191;
                int i47 = 13;
                while (true) {
                    i6 = i45 + 1;
                    cCharAt3 = str2.charAt(i45);
                    if (cCharAt3 < 55296) {
                        break;
                    }
                    i46 |= (cCharAt3 & 8191) << i47;
                    i47 += 13;
                    i45 = i6;
                }
                iCharAt8 = i46 | (cCharAt3 << i47);
                i45 = i6;
            }
            int i48 = i45 + 1;
            int iCharAt9 = str2.charAt(i45);
            if (iCharAt9 >= 55296) {
                int i49 = iCharAt9 & 8191;
                int i50 = 13;
                while (true) {
                    i5 = i48 + 1;
                    cCharAt2 = str2.charAt(i48);
                    if (cCharAt2 < 55296) {
                        break;
                    }
                    i49 |= (cCharAt2 & 8191) << i50;
                    i50 += 13;
                    i48 = i5;
                }
                iCharAt9 = i49 | (cCharAt2 << i50);
                i48 = i5;
            }
            int i51 = i48 + 1;
            iCharAt4 = str2.charAt(i48);
            if (iCharAt4 >= 55296) {
                int i52 = iCharAt4 & 8191;
                int i53 = i51;
                int i54 = 13;
                while (true) {
                    i4 = i53 + 1;
                    cCharAt = str2.charAt(i53);
                    if (cCharAt < 55296) {
                        break;
                    }
                    i52 |= (cCharAt & 8191) << i54;
                    i54 += 13;
                    i53 = i4;
                }
                iCharAt4 = i52 | (cCharAt << i54);
                i51 = i4;
            }
            int[] iArr2 = new int[iCharAt4 + iCharAt8 + iCharAt9];
            i2 = (iCharAt6 << 1) + iCharAt7;
            i3 = iCharAt8;
            iArr = iArr2;
            i25 = iCharAt6;
            i27 = i51;
        }
        Unsafe unsafe = f1441b;
        Object[] objArr2 = o6Var2.c;
        Class<?> cls = o6Var2.a.getClass();
        int i55 = i27;
        int[] iArr3 = new int[iCharAt3 * 3];
        Object[] objArr3 = new Object[iCharAt3 << 1];
        int i56 = iCharAt4 + i3;
        int i57 = iCharAt4;
        int i58 = i55;
        int i59 = i56;
        int i60 = 0;
        int i61 = 0;
        while (i58 < length) {
            int i62 = i58 + 1;
            int iCharAt10 = str2.charAt(i58);
            int i63 = length;
            if (iCharAt10 >= 55296) {
                int i64 = iCharAt10 & 8191;
                int i65 = i62;
                int i66 = 13;
                while (true) {
                    i23 = i65 + 1;
                    cCharAt12 = str2.charAt(i65);
                    i12 = iCharAt4;
                    if (cCharAt12 < 55296) {
                        break;
                    }
                    i64 |= (cCharAt12 & 8191) << i66;
                    i66 += 13;
                    i65 = i23;
                    iCharAt4 = i12;
                }
                iCharAt10 = i64 | (cCharAt12 << i66);
                i13 = i23;
            } else {
                i12 = iCharAt4;
                i13 = i62;
            }
            int i67 = i13 + 1;
            int iCharAt11 = str2.charAt(i13);
            if (iCharAt11 >= 55296) {
                int i68 = iCharAt11 & 8191;
                int i69 = i67;
                int i70 = 13;
                while (true) {
                    i22 = i69 + 1;
                    cCharAt11 = str2.charAt(i69);
                    i14 = iCharAt2;
                    if (cCharAt11 < 55296) {
                        break;
                    }
                    i68 |= (cCharAt11 & 8191) << i70;
                    i70 += 13;
                    i69 = i22;
                    iCharAt2 = i14;
                }
                iCharAt11 = i68 | (cCharAt11 << i70);
                i15 = i22;
            } else {
                i14 = iCharAt2;
                i15 = i67;
            }
            int i71 = iCharAt11 & 255;
            int i72 = iCharAt;
            if ((iCharAt11 & 1024) != 0) {
                iArr[i60] = i61;
                i60++;
            }
            if (i71 >= 51) {
                int i73 = i15 + 1;
                int iCharAt12 = str2.charAt(i15);
                char c = 55296;
                if (iCharAt12 >= 55296) {
                    int i74 = 13;
                    int i75 = iCharAt12 & 8191;
                    int i76 = i73;
                    while (true) {
                        i21 = i76 + 1;
                        cCharAt10 = str2.charAt(i76);
                        if (cCharAt10 < c) {
                            break;
                        }
                        i75 |= (cCharAt10 & 8191) << i74;
                        i74 += 13;
                        i76 = i21;
                        c = 55296;
                    }
                    iCharAt12 = i75 | (cCharAt10 << i74);
                    i20 = i21;
                } else {
                    i20 = i73;
                }
                int i77 = i20;
                int i78 = i71 - 51;
                o6Var = o6Var2;
                if (i78 == 9 || i78 == 17) {
                    objArr3[((i61 / 3) << 1) + 1] = objArr2[i2];
                    i2++;
                } else if (i78 == 12 && !z3) {
                    objArr3[((i61 / 3) << 1) + 1] = objArr2[i2];
                    i2++;
                }
                int i79 = iCharAt12 << 1;
                Object obj = objArr2[i79];
                if (obj instanceof Field) {
                    fieldP2 = (Field) obj;
                } else {
                    fieldP2 = p(cls, (String) obj);
                    objArr2[i79] = fieldP2;
                }
                int i80 = i2;
                iObjectFieldOffset = (int) unsafe.objectFieldOffset(fieldP2);
                int i81 = i79 + 1;
                Object obj2 = objArr2[i81];
                if (obj2 instanceof Field) {
                    fieldP3 = (Field) obj2;
                } else {
                    fieldP3 = p(cls, (String) obj2);
                    objArr2[i81] = fieldP3;
                }
                int iObjectFieldOffset3 = (int) unsafe.objectFieldOffset(fieldP3);
                str = str2;
                z2 = z3;
                i15 = i77;
                i16 = i80;
                iObjectFieldOffset2 = iObjectFieldOffset3;
                objArr = objArr3;
                i17 = 0;
            } else {
                o6Var = o6Var2;
                int i82 = i2 + 1;
                Field fieldP4 = p(cls, (String) objArr2[i2]);
                if (i71 == 9 || i71 == 17) {
                    objArr3[((i61 / 3) << 1) + 1] = fieldP4.getType();
                } else {
                    if (i71 == 27 || i71 == 49) {
                        i19 = i82 + 1;
                        objArr3[((i61 / 3) << 1) + 1] = objArr2[i82];
                    } else if (i71 != 12 && i71 != 30 && i71 != 44) {
                        if (i71 == 50) {
                            int i83 = i57 + 1;
                            iArr[i57] = i61;
                            int i84 = (i61 / 3) << 1;
                            i19 = i82 + 1;
                            objArr3[i84] = objArr2[i82];
                            if ((iCharAt11 & 2048) != 0) {
                                i82 = i19 + 1;
                                objArr3[i84 + 1] = objArr2[i19];
                                objArr = objArr3;
                                i57 = i83;
                                z2 = z3;
                            } else {
                                i57 = i83;
                            }
                        }
                        iObjectFieldOffset = (int) unsafe.objectFieldOffset(fieldP4);
                        if ((iCharAt11 & 4096) == 4096 || i71 > 17) {
                            i16 = i82;
                            str = str2;
                            iObjectFieldOffset2 = 1048575;
                            i17 = 0;
                        } else {
                            int i85 = i15 + 1;
                            int iCharAt13 = str2.charAt(i15);
                            if (iCharAt13 >= 55296) {
                                int i86 = iCharAt13 & 8191;
                                int i87 = 13;
                                while (true) {
                                    i18 = i85 + 1;
                                    cCharAt9 = str2.charAt(i85);
                                    if (cCharAt9 < 55296) {
                                        break;
                                    }
                                    i86 |= (cCharAt9 & 8191) << i87;
                                    i87 += 13;
                                    i85 = i18;
                                }
                                iCharAt13 = i86 | (cCharAt9 << i87);
                                i85 = i18;
                            }
                            int i88 = (iCharAt13 / 32) + (i25 << 1);
                            Object obj3 = objArr2[i88];
                            i16 = i82;
                            if (obj3 instanceof Field) {
                                fieldP = (Field) obj3;
                            } else {
                                fieldP = p(cls, (String) obj3);
                                objArr2[i88] = fieldP;
                            }
                            str = str2;
                            iObjectFieldOffset2 = (int) unsafe.objectFieldOffset(fieldP);
                            i17 = iCharAt13 % 32;
                            i15 = i85;
                        }
                        if (i71 >= 18 && i71 <= 49) {
                            iArr[i59] = iObjectFieldOffset;
                            i59++;
                        }
                    } else if (!z3) {
                        i19 = i82 + 1;
                        objArr3[((i61 / 3) << 1) + 1] = objArr2[i82];
                    }
                    i82 = i19;
                }
                z2 = z3;
                objArr = objArr3;
                iObjectFieldOffset = (int) unsafe.objectFieldOffset(fieldP4);
                if ((iCharAt11 & 4096) == 4096) {
                    i16 = i82;
                    str = str2;
                    iObjectFieldOffset2 = 1048575;
                    i17 = 0;
                    if (i71 >= 18) {
                        iArr[i59] = iObjectFieldOffset;
                        i59++;
                    }
                }
            }
            int i89 = i61 + 1;
            iArr3[i61] = iCharAt10;
            int i90 = i89 + 1;
            iArr3[i89] = ((iCharAt11 & 512) != 0 ? 536870912 : 0) | ((iCharAt11 & 256) != 0 ? 268435456 : 0) | (i71 << 20) | iObjectFieldOffset;
            i61 = i90 + 1;
            iArr3[i90] = (i17 << 20) | iObjectFieldOffset2;
            z3 = z2;
            i58 = i15;
            iCharAt = i72;
            length = i63;
            iCharAt4 = i12;
            iCharAt2 = i14;
            objArr3 = objArr;
            str2 = str;
            i2 = i16;
            o6Var2 = o6Var;
        }
        return new e6(iArr3, objArr3, iCharAt, iCharAt2, o6Var2.a, z3, iArr, iCharAt4, i56, i6Var, m5Var, d7Var, j4Var, v5Var);
    }

    public static Field p(Class<?> cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (NoSuchFieldException unused) {
            Field[] declaredFields = cls.getDeclaredFields();
            for (Field field : declaredFields) {
                if (str.equals(field.getName())) {
                    return field;
                }
            }
            String name = cls.getName();
            String string = Arrays.toString(declaredFields);
            throw new RuntimeException(outline.J(outline.S(outline.b(string, name.length() + outline.b(str, 40)), "Field ", str, " for ", name), " not found. Known fields are ", string));
        }
    }

    public static List<?> q(Object obj, long j) {
        return (List) j7.r(obj, j);
    }

    public static void r(int i, Object obj, v7 v7Var) throws IOException {
        if (obj instanceof String) {
            ((g4) v7Var).a.k(i, (String) obj);
        } else {
            ((g4) v7Var).a.h(i, (t3) obj);
        }
    }

    public static <UT, UB> void s(d7<UT, UB> d7Var, T t, v7 v7Var) throws IOException {
        d7Var.c(d7Var.e(t), v7Var);
    }

    public static <T> double y(T t, long j) {
        return ((Double) j7.r(t, j)).doubleValue();
    }

    public final Object A(int i) {
        return this.d[(i / 3) << 1];
    }

    public final void B(T t, int i) {
        int i2 = this.c[i + 2];
        long j = 1048575 & i2;
        if (j == 1048575) {
            return;
        }
        j7.e.e(t, j, (1 << (i2 >>> 20)) | j7.b(t, j));
    }

    public final void C(T t, int i, int i2) {
        j7.e.e(t, this.c[i2 + 2] & 1048575, i);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void D(T t, v7 v7Var) throws IOException {
        Iterator itL;
        Map.Entry<?, ?> entry;
        int i;
        if (this.h) {
            n4<T> n4VarB = this.p.b(t);
            if (n4VarB.f1461b.isEmpty()) {
                itL = null;
                entry = null;
            } else {
                itL = n4VarB.l();
                entry = (Map.Entry) itL.next();
            }
        }
        int length = this.c.length;
        Unsafe unsafe = f1441b;
        int i2 = 1048575;
        int i3 = 0;
        for (int i4 = 0; i4 < length; i4 += 3) {
            int I = I(i4);
            int[] iArr = this.c;
            int i5 = iArr[i4];
            int i6 = (I & 267386880) >>> 20;
            if (i6 <= 17) {
                int i7 = iArr[i4 + 2];
                int i8 = i7 & 1048575;
                if (i8 != i2) {
                    i3 = unsafe.getInt(t, i8);
                    i2 = i8;
                }
                i = 1 << (i7 >>> 20);
            } else {
                i = 0;
            }
            while (entry != null && this.p.a(entry) <= i5) {
                this.p.d(v7Var, entry);
                entry = itL.hasNext() ? (Map.Entry) itL.next() : null;
            }
            long j = I & 1048575;
            switch (i6) {
                case 0:
                    if ((i & i3) != 0) {
                        ((g4) v7Var).a(i5, j7.q(t, j));
                        continue;
                    }
                case 1:
                    if ((i & i3) != 0) {
                        ((g4) v7Var).b(i5, j7.n(t, j));
                    } else {
                        continue;
                    }
                case 2:
                    if ((i & i3) != 0) {
                        ((g4) v7Var).a.g(i5, unsafe.getLong(t, j));
                    } else {
                        continue;
                    }
                case 3:
                    if ((i & i3) != 0) {
                        ((g4) v7Var).a.g(i5, unsafe.getLong(t, j));
                    } else {
                        continue;
                    }
                case 4:
                    if ((i & i3) != 0) {
                        ((g4) v7Var).a.s(i5, unsafe.getInt(t, j));
                    } else {
                        continue;
                    }
                case 5:
                    if ((i & i3) != 0) {
                        ((g4) v7Var).a.z(i5, unsafe.getLong(t, j));
                    } else {
                        continue;
                    }
                case 6:
                    if ((i & i3) != 0) {
                        ((g4) v7Var).a.G(i5, unsafe.getInt(t, j));
                    } else {
                        continue;
                    }
                case 7:
                    if ((i & i3) != 0) {
                        ((g4) v7Var).a.l(i5, j7.m(t, j));
                    } else {
                        continue;
                    }
                case 8:
                    if ((i & i3) != 0) {
                        r(i5, unsafe.getObject(t, j), v7Var);
                    } else {
                        continue;
                    }
                case 9:
                    if ((i & i3) != 0) {
                        ((g4) v7Var).d(i5, unsafe.getObject(t, j), o(i4));
                    } else {
                        continue;
                    }
                case 10:
                    if ((i & i3) != 0) {
                        ((g4) v7Var).a.h(i5, (t3) unsafe.getObject(t, j));
                    } else {
                        continue;
                    }
                case 11:
                    if ((i & i3) != 0) {
                        ((g4) v7Var).a.y(i5, unsafe.getInt(t, j));
                    } else {
                        continue;
                    }
                case 12:
                    if ((i & i3) != 0) {
                        ((g4) v7Var).a.s(i5, unsafe.getInt(t, j));
                    } else {
                        continue;
                    }
                case 13:
                    if ((i & i3) != 0) {
                        ((g4) v7Var).a.G(i5, unsafe.getInt(t, j));
                    } else {
                        continue;
                    }
                case 14:
                    if ((i & i3) != 0) {
                        ((g4) v7Var).a.z(i5, unsafe.getLong(t, j));
                    } else {
                        continue;
                    }
                case 15:
                    if ((i & i3) != 0) {
                        ((g4) v7Var).g(i5, unsafe.getInt(t, j));
                    } else {
                        continue;
                    }
                case 16:
                    if ((i & i3) != 0) {
                        ((g4) v7Var).f(i5, unsafe.getLong(t, j));
                    } else {
                        continue;
                    }
                case 17:
                    if ((i & i3) != 0) {
                        ((g4) v7Var).e(i5, unsafe.getObject(t, j), o(i4));
                    } else {
                        continue;
                    }
                case 18:
                    s6.h(this.c[i4], (List) unsafe.getObject(t, j), v7Var, false);
                    break;
                case 19:
                    s6.q(this.c[i4], (List) unsafe.getObject(t, j), v7Var, false);
                    break;
                case 20:
                    s6.u(this.c[i4], (List) unsafe.getObject(t, j), v7Var, false);
                    break;
                case 21:
                    s6.x(this.c[i4], (List) unsafe.getObject(t, j), v7Var, false);
                    break;
                case 22:
                    s6.J(this.c[i4], (List) unsafe.getObject(t, j), v7Var, false);
                    break;
                case 23:
                    s6.D(this.c[i4], (List) unsafe.getObject(t, j), v7Var, false);
                    break;
                case 24:
                    s6.O(this.c[i4], (List) unsafe.getObject(t, j), v7Var, false);
                    break;
                case 25:
                    s6.R(this.c[i4], (List) unsafe.getObject(t, j), v7Var, false);
                    break;
                case 26:
                    s6.f(this.c[i4], (List) unsafe.getObject(t, j), v7Var);
                    break;
                case 27:
                    s6.g(this.c[i4], (List) unsafe.getObject(t, j), v7Var, o(i4));
                    break;
                case 28:
                    s6.o(this.c[i4], (List) unsafe.getObject(t, j), v7Var);
                    break;
                case 29:
                    s6.M(this.c[i4], (List) unsafe.getObject(t, j), v7Var, false);
                    break;
                case 30:
                    s6.Q(this.c[i4], (List) unsafe.getObject(t, j), v7Var, false);
                    break;
                case 31:
                    s6.P(this.c[i4], (List) unsafe.getObject(t, j), v7Var, false);
                    break;
                case 32:
                    s6.G(this.c[i4], (List) unsafe.getObject(t, j), v7Var, false);
                    break;
                case 33:
                    s6.N(this.c[i4], (List) unsafe.getObject(t, j), v7Var, false);
                    break;
                case 34:
                    s6.A(this.c[i4], (List) unsafe.getObject(t, j), v7Var, false);
                    break;
                case 35:
                    s6.h(this.c[i4], (List) unsafe.getObject(t, j), v7Var, true);
                    break;
                case 36:
                    s6.q(this.c[i4], (List) unsafe.getObject(t, j), v7Var, true);
                    break;
                case 37:
                    s6.u(this.c[i4], (List) unsafe.getObject(t, j), v7Var, true);
                    break;
                case 38:
                    s6.x(this.c[i4], (List) unsafe.getObject(t, j), v7Var, true);
                    break;
                case 39:
                    s6.J(this.c[i4], (List) unsafe.getObject(t, j), v7Var, true);
                    break;
                case 40:
                    s6.D(this.c[i4], (List) unsafe.getObject(t, j), v7Var, true);
                    break;
                case 41:
                    s6.O(this.c[i4], (List) unsafe.getObject(t, j), v7Var, true);
                    break;
                case 42:
                    s6.R(this.c[i4], (List) unsafe.getObject(t, j), v7Var, true);
                    break;
                case 43:
                    s6.M(this.c[i4], (List) unsafe.getObject(t, j), v7Var, true);
                    break;
                case 44:
                    s6.Q(this.c[i4], (List) unsafe.getObject(t, j), v7Var, true);
                    break;
                case 45:
                    s6.P(this.c[i4], (List) unsafe.getObject(t, j), v7Var, true);
                    break;
                case 46:
                    s6.G(this.c[i4], (List) unsafe.getObject(t, j), v7Var, true);
                    break;
                case 47:
                    s6.N(this.c[i4], (List) unsafe.getObject(t, j), v7Var, true);
                    break;
                case 48:
                    s6.A(this.c[i4], (List) unsafe.getObject(t, j), v7Var, true);
                    break;
                case 49:
                    s6.p(this.c[i4], (List) unsafe.getObject(t, j), v7Var, o(i4));
                    break;
                case 50:
                    t(v7Var, i5, unsafe.getObject(t, j), i4);
                    break;
                case 51:
                    if (w(t, i5, i4)) {
                        ((g4) v7Var).a(i5, y(t, j));
                        break;
                    }
                    break;
                case 52:
                    if (w(t, i5, i4)) {
                        ((g4) v7Var).b(i5, F(t, j));
                        break;
                    }
                    break;
                case 53:
                    if (w(t, i5, i4)) {
                        ((g4) v7Var).a.g(i5, L(t, j));
                        break;
                    }
                    break;
                case 54:
                    if (w(t, i5, i4)) {
                        ((g4) v7Var).a.g(i5, L(t, j));
                        break;
                    }
                    break;
                case 55:
                    if (w(t, i5, i4)) {
                        ((g4) v7Var).a.s(i5, J(t, j));
                        break;
                    }
                    break;
                case 56:
                    if (w(t, i5, i4)) {
                        ((g4) v7Var).a.z(i5, L(t, j));
                        break;
                    }
                    break;
                case 57:
                    if (w(t, i5, i4)) {
                        ((g4) v7Var).a.G(i5, J(t, j));
                        break;
                    }
                    break;
                case 58:
                    if (w(t, i5, i4)) {
                        ((g4) v7Var).a.l(i5, N(t, j));
                        break;
                    }
                    break;
                case 59:
                    if (w(t, i5, i4)) {
                        r(i5, unsafe.getObject(t, j), v7Var);
                        break;
                    }
                    break;
                case 60:
                    if (w(t, i5, i4)) {
                        ((g4) v7Var).d(i5, unsafe.getObject(t, j), o(i4));
                        break;
                    }
                    break;
                case 61:
                    if (w(t, i5, i4)) {
                        ((g4) v7Var).a.h(i5, (t3) unsafe.getObject(t, j));
                        break;
                    }
                    break;
                case 62:
                    if (w(t, i5, i4)) {
                        ((g4) v7Var).a.y(i5, J(t, j));
                        break;
                    }
                    break;
                case 63:
                    if (w(t, i5, i4)) {
                        ((g4) v7Var).a.s(i5, J(t, j));
                        break;
                    }
                    break;
                case 64:
                    if (w(t, i5, i4)) {
                        ((g4) v7Var).a.G(i5, J(t, j));
                        break;
                    }
                    break;
                case 65:
                    if (w(t, i5, i4)) {
                        ((g4) v7Var).a.z(i5, L(t, j));
                        break;
                    }
                    break;
                case 66:
                    if (w(t, i5, i4)) {
                        ((g4) v7Var).g(i5, J(t, j));
                        break;
                    }
                    break;
                case 67:
                    if (w(t, i5, i4)) {
                        ((g4) v7Var).f(i5, L(t, j));
                        break;
                    }
                    break;
                case 68:
                    if (w(t, i5, i4)) {
                        ((g4) v7Var).e(i5, unsafe.getObject(t, j), o(i4));
                        break;
                    }
                    break;
            }
        }
        while (entry != null) {
            this.p.d(v7Var, entry);
            entry = itL.hasNext() ? (Map.Entry) itL.next() : null;
        }
        s(this.o, t, v7Var);
    }

    public final void E(T t, T t2, int i) {
        int[] iArr = this.c;
        int i2 = iArr[i + 1];
        int i3 = iArr[i];
        long j = i2 & 1048575;
        if (w(t2, i3, i)) {
            Object objR = w(t, i3, i) ? j7.r(t, j) : null;
            Object objR2 = j7.r(t2, j);
            if (objR != null && objR2 != null) {
                j7.f(t, j, w4.c(objR, objR2));
                C(t, i3, i);
            } else if (objR2 != null) {
                j7.f(t, j, objR2);
                C(t, i3, i);
            }
        }
    }

    public final a5 G(int i) {
        return (a5) this.d[((i / 3) << 1) + 1];
    }

    public final boolean H(T t, T t2, int i) {
        return v(t, i) == v(t2, i);
    }

    public final int I(int i) {
        return this.c[i + 1];
    }

    public final int K(int i) {
        return this.c[i + 2];
    }

    @Override // b.i.a.f.h.l.q6
    public final T a() {
        return (T) this.m.b(this.g);
    }

    @Override // b.i.a.f.h.l.q6
    public final int b(T t) {
        int i;
        int iA;
        int length = this.c.length;
        int i2 = 0;
        for (int i3 = 0; i3 < length; i3 += 3) {
            int I = I(i3);
            int i4 = this.c[i3];
            long j = 1048575 & I;
            int iHashCode = 37;
            switch ((I & 267386880) >>> 20) {
                case 0:
                    i = i2 * 53;
                    iA = w4.a(Double.doubleToLongBits(j7.q(t, j)));
                    i2 = iA + i;
                    break;
                case 1:
                    i = i2 * 53;
                    iA = Float.floatToIntBits(j7.n(t, j));
                    i2 = iA + i;
                    break;
                case 2:
                    i = i2 * 53;
                    iA = w4.a(j7.i(t, j));
                    i2 = iA + i;
                    break;
                case 3:
                    i = i2 * 53;
                    iA = w4.a(j7.i(t, j));
                    i2 = iA + i;
                    break;
                case 4:
                    i = i2 * 53;
                    iA = j7.b(t, j);
                    i2 = iA + i;
                    break;
                case 5:
                    i = i2 * 53;
                    iA = w4.a(j7.i(t, j));
                    i2 = iA + i;
                    break;
                case 6:
                    i = i2 * 53;
                    iA = j7.b(t, j);
                    i2 = iA + i;
                    break;
                case 7:
                    i = i2 * 53;
                    iA = w4.b(j7.m(t, j));
                    i2 = iA + i;
                    break;
                case 8:
                    i = i2 * 53;
                    iA = ((String) j7.r(t, j)).hashCode();
                    i2 = iA + i;
                    break;
                case 9:
                    Object objR = j7.r(t, j);
                    if (objR != null) {
                        iHashCode = objR.hashCode();
                    }
                    i2 = (i2 * 53) + iHashCode;
                    break;
                case 10:
                    i = i2 * 53;
                    iA = j7.r(t, j).hashCode();
                    i2 = iA + i;
                    break;
                case 11:
                    i = i2 * 53;
                    iA = j7.b(t, j);
                    i2 = iA + i;
                    break;
                case 12:
                    i = i2 * 53;
                    iA = j7.b(t, j);
                    i2 = iA + i;
                    break;
                case 13:
                    i = i2 * 53;
                    iA = j7.b(t, j);
                    i2 = iA + i;
                    break;
                case 14:
                    i = i2 * 53;
                    iA = w4.a(j7.i(t, j));
                    i2 = iA + i;
                    break;
                case 15:
                    i = i2 * 53;
                    iA = j7.b(t, j);
                    i2 = iA + i;
                    break;
                case 16:
                    i = i2 * 53;
                    iA = w4.a(j7.i(t, j));
                    i2 = iA + i;
                    break;
                case 17:
                    Object objR2 = j7.r(t, j);
                    if (objR2 != null) {
                        iHashCode = objR2.hashCode();
                    }
                    i2 = (i2 * 53) + iHashCode;
                    break;
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
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
                    i = i2 * 53;
                    iA = j7.r(t, j).hashCode();
                    i2 = iA + i;
                    break;
                case 50:
                    i = i2 * 53;
                    iA = j7.r(t, j).hashCode();
                    i2 = iA + i;
                    break;
                case 51:
                    if (w(t, i4, i3)) {
                        i = i2 * 53;
                        iA = w4.a(Double.doubleToLongBits(y(t, j)));
                        i2 = iA + i;
                        break;
                    } else {
                        break;
                    }
                case 52:
                    if (w(t, i4, i3)) {
                        i = i2 * 53;
                        iA = Float.floatToIntBits(F(t, j));
                        i2 = iA + i;
                        break;
                    } else {
                        break;
                    }
                case 53:
                    if (w(t, i4, i3)) {
                        i = i2 * 53;
                        iA = w4.a(L(t, j));
                        i2 = iA + i;
                        break;
                    } else {
                        break;
                    }
                case 54:
                    if (w(t, i4, i3)) {
                        i = i2 * 53;
                        iA = w4.a(L(t, j));
                        i2 = iA + i;
                        break;
                    } else {
                        break;
                    }
                case 55:
                    if (w(t, i4, i3)) {
                        i = i2 * 53;
                        iA = J(t, j);
                        i2 = iA + i;
                        break;
                    } else {
                        break;
                    }
                case 56:
                    if (w(t, i4, i3)) {
                        i = i2 * 53;
                        iA = w4.a(L(t, j));
                        i2 = iA + i;
                        break;
                    } else {
                        break;
                    }
                case 57:
                    if (w(t, i4, i3)) {
                        i = i2 * 53;
                        iA = J(t, j);
                        i2 = iA + i;
                        break;
                    } else {
                        break;
                    }
                case 58:
                    if (w(t, i4, i3)) {
                        i = i2 * 53;
                        iA = w4.b(N(t, j));
                        i2 = iA + i;
                        break;
                    } else {
                        break;
                    }
                case 59:
                    if (w(t, i4, i3)) {
                        i = i2 * 53;
                        iA = ((String) j7.r(t, j)).hashCode();
                        i2 = iA + i;
                        break;
                    } else {
                        break;
                    }
                case 60:
                    if (w(t, i4, i3)) {
                        i = i2 * 53;
                        iA = j7.r(t, j).hashCode();
                        i2 = iA + i;
                        break;
                    } else {
                        break;
                    }
                case 61:
                    if (w(t, i4, i3)) {
                        i = i2 * 53;
                        iA = j7.r(t, j).hashCode();
                        i2 = iA + i;
                        break;
                    } else {
                        break;
                    }
                case 62:
                    if (w(t, i4, i3)) {
                        i = i2 * 53;
                        iA = J(t, j);
                        i2 = iA + i;
                        break;
                    } else {
                        break;
                    }
                case 63:
                    if (w(t, i4, i3)) {
                        i = i2 * 53;
                        iA = J(t, j);
                        i2 = iA + i;
                        break;
                    } else {
                        break;
                    }
                case 64:
                    if (w(t, i4, i3)) {
                        i = i2 * 53;
                        iA = J(t, j);
                        i2 = iA + i;
                        break;
                    } else {
                        break;
                    }
                case 65:
                    if (w(t, i4, i3)) {
                        i = i2 * 53;
                        iA = w4.a(L(t, j));
                        i2 = iA + i;
                        break;
                    } else {
                        break;
                    }
                case 66:
                    if (w(t, i4, i3)) {
                        i = i2 * 53;
                        iA = J(t, j);
                        i2 = iA + i;
                        break;
                    } else {
                        break;
                    }
                case 67:
                    if (w(t, i4, i3)) {
                        i = i2 * 53;
                        iA = w4.a(L(t, j));
                        i2 = iA + i;
                        break;
                    } else {
                        break;
                    }
                case 68:
                    if (w(t, i4, i3)) {
                        i = i2 * 53;
                        iA = j7.r(t, j).hashCode();
                        i2 = iA + i;
                        break;
                    } else {
                        break;
                    }
            }
        }
        int iHashCode2 = this.o.e(t).hashCode() + (i2 * 53);
        return this.h ? (iHashCode2 * 53) + this.p.b(t).hashCode() : iHashCode2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00b8  */
    @Override // b.i.a.f.h.l.q6
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean c(T t) {
        int i;
        int i2;
        int i3 = 1048575;
        int i4 = 0;
        int i5 = 0;
        while (true) {
            boolean z2 = true;
            if (i5 >= this.k) {
                return !this.h || this.p.b(t).m();
            }
            int i6 = this.j[i5];
            int i7 = this.c[i6];
            int I = I(i6);
            int i8 = this.c[i6 + 2];
            int i9 = i8 & 1048575;
            int i10 = 1 << (i8 >>> 20);
            if (i9 != i3) {
                if (i9 != 1048575) {
                    i4 = f1441b.getInt(t, i9);
                }
                i2 = i4;
                i = i9;
            } else {
                i = i3;
                i2 = i4;
            }
            if (((268435456 & I) != 0) && !x(t, i6, i, i2, i10)) {
                return false;
            }
            int i11 = (267386880 & I) >>> 20;
            if (i11 == 9 || i11 == 17) {
                if (x(t, i6, i, i2, i10) && !o(i6).c(j7.r(t, I & 1048575))) {
                    return false;
                }
            } else if (i11 == 27) {
                List list = (List) j7.r(t, I & 1048575);
                if (!list.isEmpty()) {
                    q6 q6VarO = o(i6);
                    int i12 = 0;
                    while (true) {
                        if (i12 >= list.size()) {
                            break;
                        }
                        if (!q6VarO.c(list.get(i12))) {
                            z2 = false;
                            break;
                        }
                        i12++;
                    }
                }
                if (!z2) {
                    return false;
                }
            } else if (i11 == 60 || i11 == 68) {
                if (w(t, i7, i6) && !o(i6).c(j7.r(t, I & 1048575))) {
                    return false;
                }
            } else if (i11 != 49) {
                if (i11 == 50 && !this.q.e(j7.r(t, I & 1048575)).isEmpty()) {
                    Objects.requireNonNull(this.q.g(A(i6)));
                    throw null;
                }
            }
            i5++;
            i3 = i;
            i4 = i2;
        }
    }

    @Override // b.i.a.f.h.l.q6
    public final void d(T t) {
        int i;
        int i2 = this.k;
        while (true) {
            i = this.l;
            if (i2 >= i) {
                break;
            }
            long jI = I(this.j[i2]) & 1048575;
            Object objR = j7.r(t, jI);
            if (objR != null) {
                j7.f(t, jI, this.q.c(objR));
            }
            i2++;
        }
        int length = this.j.length;
        while (i < length) {
            this.n.b(t, this.j[i]);
            i++;
        }
        this.o.h(t);
        if (this.h) {
            this.p.g(t);
        }
    }

    @Override // b.i.a.f.h.l.q6
    public final int e(T t) {
        int i;
        int iU;
        int iL;
        int iD;
        int iL2;
        int iU2;
        int iL3;
        int iD2;
        int iL4;
        if (this.i) {
            Unsafe unsafe = f1441b;
            int i2 = 0;
            for (int i3 = 0; i3 < this.c.length; i3 += 3) {
                int I = I(i3);
                int i4 = (I & 267386880) >>> 20;
                int i5 = this.c[i3];
                long j = I & 1048575;
                if (i4 >= o4.S.a() && i4 <= o4.f1468f0.a()) {
                    int i6 = this.c[i3 + 2];
                }
                switch (i4) {
                    case 0:
                        if (v(t, i3)) {
                            iU2 = zzhi.u(i5);
                            i2 += iU2;
                            break;
                        } else {
                            break;
                        }
                    case 1:
                        if (v(t, i3)) {
                            iU2 = zzhi.n(i5);
                            i2 += iU2;
                            break;
                        } else {
                            break;
                        }
                    case 2:
                        if (v(t, i3)) {
                            iU2 = zzhi.B(i5, j7.i(t, j));
                            i2 += iU2;
                            break;
                        } else {
                            break;
                        }
                    case 3:
                        if (v(t, i3)) {
                            iU2 = zzhi.E(i5, j7.i(t, j));
                            i2 += iU2;
                            break;
                        } else {
                            break;
                        }
                    case 4:
                        if (v(t, i3)) {
                            iU2 = zzhi.I(i5, j7.b(t, j));
                            i2 += iU2;
                            break;
                        } else {
                            break;
                        }
                    case 5:
                        if (v(t, i3)) {
                            iU2 = zzhi.N(i5);
                            i2 += iU2;
                            break;
                        } else {
                            break;
                        }
                    case 6:
                        if (v(t, i3)) {
                            iU2 = zzhi.S(i5);
                            i2 += iU2;
                            break;
                        } else {
                            break;
                        }
                    case 7:
                        if (v(t, i3)) {
                            iU2 = zzhi.v(i5);
                            i2 += iU2;
                            break;
                        } else {
                            break;
                        }
                    case 8:
                        if (v(t, i3)) {
                            Object objR = j7.r(t, j);
                            iU2 = objR instanceof t3 ? zzhi.w(i5, (t3) objR) : zzhi.o(i5, (String) objR);
                            i2 += iU2;
                            break;
                        } else {
                            break;
                        }
                    case 9:
                        if (v(t, i3)) {
                            iU2 = s6.a(i5, j7.r(t, j), o(i3));
                            i2 += iU2;
                            break;
                        } else {
                            break;
                        }
                    case 10:
                        if (v(t, i3)) {
                            iU2 = zzhi.w(i5, (t3) j7.r(t, j));
                            i2 += iU2;
                            break;
                        } else {
                            break;
                        }
                    case 11:
                        if (v(t, i3)) {
                            iU2 = zzhi.M(i5, j7.b(t, j));
                            i2 += iU2;
                            break;
                        } else {
                            break;
                        }
                    case 12:
                        if (v(t, i3)) {
                            iU2 = zzhi.U(i5, j7.b(t, j));
                            i2 += iU2;
                            break;
                        } else {
                            break;
                        }
                    case 13:
                        if (v(t, i3)) {
                            iU2 = zzhi.T(i5);
                            i2 += iU2;
                            break;
                        } else {
                            break;
                        }
                    case 14:
                        if (v(t, i3)) {
                            iU2 = zzhi.Q(i5);
                            i2 += iU2;
                            break;
                        } else {
                            break;
                        }
                    case 15:
                        if (v(t, i3)) {
                            iU2 = zzhi.P(i5, j7.b(t, j));
                            i2 += iU2;
                            break;
                        } else {
                            break;
                        }
                    case 16:
                        if (v(t, i3)) {
                            iU2 = zzhi.J(i5, j7.i(t, j));
                            i2 += iU2;
                            break;
                        } else {
                            break;
                        }
                    case 17:
                        if (v(t, i3)) {
                            iU2 = zzhi.x(i5, (c6) j7.r(t, j), o(i3));
                            i2 += iU2;
                            break;
                        } else {
                            break;
                        }
                    case 18:
                        iU2 = s6.K(i5, q(t, j));
                        i2 += iU2;
                        break;
                    case 19:
                        iU2 = s6.H(i5, q(t, j));
                        i2 += iU2;
                        break;
                    case 20:
                        iU2 = s6.k(i5, q(t, j));
                        i2 += iU2;
                        break;
                    case 21:
                        iU2 = s6.r(i5, q(t, j));
                        i2 += iU2;
                        break;
                    case 22:
                        iU2 = s6.y(i5, q(t, j));
                        i2 += iU2;
                        break;
                    case 23:
                        iU2 = s6.K(i5, q(t, j));
                        i2 += iU2;
                        break;
                    case 24:
                        iU2 = s6.H(i5, q(t, j));
                        i2 += iU2;
                        break;
                    case 25:
                        List<?> listQ = q(t, j);
                        Class<?> cls = s6.a;
                        int size = listQ.size();
                        iU2 = size == 0 ? 0 : size * zzhi.v(i5);
                        i2 += iU2;
                        break;
                    case 26:
                        iU2 = s6.b(i5, q(t, j));
                        i2 += iU2;
                        break;
                    case 27:
                        iU2 = s6.c(i5, q(t, j), o(i3));
                        i2 += iU2;
                        break;
                    case 28:
                        iU2 = s6.l(i5, q(t, j));
                        i2 += iU2;
                        break;
                    case 29:
                        iU2 = s6.B(i5, q(t, j));
                        i2 += iU2;
                        break;
                    case 30:
                        iU2 = s6.v(i5, q(t, j));
                        i2 += iU2;
                        break;
                    case 31:
                        iU2 = s6.H(i5, q(t, j));
                        i2 += iU2;
                        break;
                    case 32:
                        iU2 = s6.K(i5, q(t, j));
                        i2 += iU2;
                        break;
                    case 33:
                        iU2 = s6.E(i5, q(t, j));
                        i2 += iU2;
                        break;
                    case 34:
                        iU2 = s6.s(i5, q(t, j));
                        i2 += iU2;
                        break;
                    case 35:
                        iL3 = s6.L((List) unsafe.getObject(t, j));
                        if (iL3 > 0) {
                            iD2 = zzhi.D(i5);
                            iL4 = zzhi.L(iL3);
                            i2 = iL4 + iD2 + iL3 + i2;
                            break;
                        } else {
                            break;
                        }
                    case 36:
                        iL3 = s6.I((List) unsafe.getObject(t, j));
                        if (iL3 > 0) {
                            iD2 = zzhi.D(i5);
                            iL4 = zzhi.L(iL3);
                            i2 = iL4 + iD2 + iL3 + i2;
                            break;
                        } else {
                            break;
                        }
                    case 37:
                        iL3 = s6.d((List) unsafe.getObject(t, j));
                        if (iL3 > 0) {
                            iD2 = zzhi.D(i5);
                            iL4 = zzhi.L(iL3);
                            i2 = iL4 + iD2 + iL3 + i2;
                            break;
                        } else {
                            break;
                        }
                    case 38:
                        iL3 = s6.n((List) unsafe.getObject(t, j));
                        if (iL3 > 0) {
                            iD2 = zzhi.D(i5);
                            iL4 = zzhi.L(iL3);
                            i2 = iL4 + iD2 + iL3 + i2;
                            break;
                        } else {
                            break;
                        }
                    case 39:
                        iL3 = s6.z((List) unsafe.getObject(t, j));
                        if (iL3 > 0) {
                            iD2 = zzhi.D(i5);
                            iL4 = zzhi.L(iL3);
                            i2 = iL4 + iD2 + iL3 + i2;
                            break;
                        } else {
                            break;
                        }
                    case 40:
                        iL3 = s6.L((List) unsafe.getObject(t, j));
                        if (iL3 > 0) {
                            iD2 = zzhi.D(i5);
                            iL4 = zzhi.L(iL3);
                            i2 = iL4 + iD2 + iL3 + i2;
                            break;
                        } else {
                            break;
                        }
                    case 41:
                        iL3 = s6.I((List) unsafe.getObject(t, j));
                        if (iL3 > 0) {
                            iD2 = zzhi.D(i5);
                            iL4 = zzhi.L(iL3);
                            i2 = iL4 + iD2 + iL3 + i2;
                            break;
                        } else {
                            break;
                        }
                    case 42:
                        List list = (List) unsafe.getObject(t, j);
                        Class<?> cls2 = s6.a;
                        iL3 = list.size();
                        if (iL3 > 0) {
                            iD2 = zzhi.D(i5);
                            iL4 = zzhi.L(iL3);
                            i2 = iL4 + iD2 + iL3 + i2;
                            break;
                        } else {
                            break;
                        }
                    case 43:
                        iL3 = s6.C((List) unsafe.getObject(t, j));
                        if (iL3 > 0) {
                            iD2 = zzhi.D(i5);
                            iL4 = zzhi.L(iL3);
                            i2 = iL4 + iD2 + iL3 + i2;
                            break;
                        } else {
                            break;
                        }
                    case 44:
                        iL3 = s6.w((List) unsafe.getObject(t, j));
                        if (iL3 > 0) {
                            iD2 = zzhi.D(i5);
                            iL4 = zzhi.L(iL3);
                            i2 = iL4 + iD2 + iL3 + i2;
                            break;
                        } else {
                            break;
                        }
                    case 45:
                        iL3 = s6.I((List) unsafe.getObject(t, j));
                        if (iL3 > 0) {
                            iD2 = zzhi.D(i5);
                            iL4 = zzhi.L(iL3);
                            i2 = iL4 + iD2 + iL3 + i2;
                            break;
                        } else {
                            break;
                        }
                    case 46:
                        iL3 = s6.L((List) unsafe.getObject(t, j));
                        if (iL3 > 0) {
                            iD2 = zzhi.D(i5);
                            iL4 = zzhi.L(iL3);
                            i2 = iL4 + iD2 + iL3 + i2;
                            break;
                        } else {
                            break;
                        }
                    case 47:
                        iL3 = s6.F((List) unsafe.getObject(t, j));
                        if (iL3 > 0) {
                            iD2 = zzhi.D(i5);
                            iL4 = zzhi.L(iL3);
                            i2 = iL4 + iD2 + iL3 + i2;
                            break;
                        } else {
                            break;
                        }
                    case 48:
                        iL3 = s6.t((List) unsafe.getObject(t, j));
                        if (iL3 > 0) {
                            iD2 = zzhi.D(i5);
                            iL4 = zzhi.L(iL3);
                            i2 = iL4 + iD2 + iL3 + i2;
                            break;
                        } else {
                            break;
                        }
                    case 49:
                        iU2 = s6.m(i5, q(t, j), o(i3));
                        i2 += iU2;
                        break;
                    case 50:
                        iU2 = this.q.i(i5, j7.r(t, j), A(i3));
                        i2 += iU2;
                        break;
                    case 51:
                        if (w(t, i5, i3)) {
                            iU2 = zzhi.u(i5);
                            i2 += iU2;
                            break;
                        } else {
                            break;
                        }
                    case 52:
                        if (w(t, i5, i3)) {
                            iU2 = zzhi.n(i5);
                            i2 += iU2;
                            break;
                        } else {
                            break;
                        }
                    case 53:
                        if (w(t, i5, i3)) {
                            iU2 = zzhi.B(i5, L(t, j));
                            i2 += iU2;
                            break;
                        } else {
                            break;
                        }
                    case 54:
                        if (w(t, i5, i3)) {
                            iU2 = zzhi.E(i5, L(t, j));
                            i2 += iU2;
                            break;
                        } else {
                            break;
                        }
                    case 55:
                        if (w(t, i5, i3)) {
                            iU2 = zzhi.I(i5, J(t, j));
                            i2 += iU2;
                            break;
                        } else {
                            break;
                        }
                    case 56:
                        if (w(t, i5, i3)) {
                            iU2 = zzhi.N(i5);
                            i2 += iU2;
                            break;
                        } else {
                            break;
                        }
                    case 57:
                        if (w(t, i5, i3)) {
                            iU2 = zzhi.S(i5);
                            i2 += iU2;
                            break;
                        } else {
                            break;
                        }
                    case 58:
                        if (w(t, i5, i3)) {
                            iU2 = zzhi.v(i5);
                            i2 += iU2;
                            break;
                        } else {
                            break;
                        }
                    case 59:
                        if (w(t, i5, i3)) {
                            Object objR2 = j7.r(t, j);
                            iU2 = objR2 instanceof t3 ? zzhi.w(i5, (t3) objR2) : zzhi.o(i5, (String) objR2);
                            i2 += iU2;
                            break;
                        } else {
                            break;
                        }
                    case 60:
                        if (w(t, i5, i3)) {
                            iU2 = s6.a(i5, j7.r(t, j), o(i3));
                            i2 += iU2;
                            break;
                        } else {
                            break;
                        }
                    case 61:
                        if (w(t, i5, i3)) {
                            iU2 = zzhi.w(i5, (t3) j7.r(t, j));
                            i2 += iU2;
                            break;
                        } else {
                            break;
                        }
                    case 62:
                        if (w(t, i5, i3)) {
                            iU2 = zzhi.M(i5, J(t, j));
                            i2 += iU2;
                            break;
                        } else {
                            break;
                        }
                    case 63:
                        if (w(t, i5, i3)) {
                            iU2 = zzhi.U(i5, J(t, j));
                            i2 += iU2;
                            break;
                        } else {
                            break;
                        }
                    case 64:
                        if (w(t, i5, i3)) {
                            iU2 = zzhi.T(i5);
                            i2 += iU2;
                            break;
                        } else {
                            break;
                        }
                    case 65:
                        if (w(t, i5, i3)) {
                            iU2 = zzhi.Q(i5);
                            i2 += iU2;
                            break;
                        } else {
                            break;
                        }
                    case 66:
                        if (w(t, i5, i3)) {
                            iU2 = zzhi.P(i5, J(t, j));
                            i2 += iU2;
                            break;
                        } else {
                            break;
                        }
                    case 67:
                        if (w(t, i5, i3)) {
                            iU2 = zzhi.J(i5, L(t, j));
                            i2 += iU2;
                            break;
                        } else {
                            break;
                        }
                    case 68:
                        if (w(t, i5, i3)) {
                            iU2 = zzhi.x(i5, (c6) j7.r(t, j), o(i3));
                            i2 += iU2;
                            break;
                        } else {
                            break;
                        }
                }
            }
            d7<?, ?> d7Var = this.o;
            return d7Var.j(d7Var.e(t)) + i2;
        }
        Unsafe unsafe2 = f1441b;
        int i7 = 0;
        int i8 = 1048575;
        int i9 = 0;
        for (int i10 = 0; i10 < this.c.length; i10 += 3) {
            int I2 = I(i10);
            int[] iArr = this.c;
            int i11 = iArr[i10];
            int i12 = (I2 & 267386880) >>> 20;
            if (i12 <= 17) {
                int i13 = iArr[i10 + 2];
                int i14 = i13 & 1048575;
                i = 1 << (i13 >>> 20);
                if (i14 != i8) {
                    i9 = unsafe2.getInt(t, i14);
                    i8 = i14;
                }
            } else {
                i = 0;
            }
            long j2 = I2 & 1048575;
            switch (i12) {
                case 0:
                    if ((i9 & i) != 0) {
                        iU = zzhi.u(i11);
                        i7 += iU;
                        break;
                    } else {
                        break;
                    }
                case 1:
                    if ((i9 & i) != 0) {
                        iU = zzhi.n(i11);
                        i7 += iU;
                        break;
                    } else {
                        break;
                    }
                case 2:
                    if ((i9 & i) != 0) {
                        iU = zzhi.B(i11, unsafe2.getLong(t, j2));
                        i7 += iU;
                        break;
                    } else {
                        break;
                    }
                case 3:
                    if ((i9 & i) != 0) {
                        iU = zzhi.E(i11, unsafe2.getLong(t, j2));
                        i7 += iU;
                        break;
                    } else {
                        break;
                    }
                case 4:
                    if ((i9 & i) != 0) {
                        iU = zzhi.I(i11, unsafe2.getInt(t, j2));
                        i7 += iU;
                        break;
                    } else {
                        break;
                    }
                case 5:
                    if ((i9 & i) != 0) {
                        iU = zzhi.N(i11);
                        i7 += iU;
                        break;
                    } else {
                        break;
                    }
                case 6:
                    if ((i9 & i) != 0) {
                        iU = zzhi.S(i11);
                        i7 += iU;
                        break;
                    } else {
                        break;
                    }
                case 7:
                    if ((i9 & i) != 0) {
                        iU = zzhi.v(i11);
                        i7 += iU;
                        break;
                    } else {
                        break;
                    }
                case 8:
                    if ((i9 & i) != 0) {
                        Object object = unsafe2.getObject(t, j2);
                        iU = object instanceof t3 ? zzhi.w(i11, (t3) object) : zzhi.o(i11, (String) object);
                        i7 += iU;
                        break;
                    } else {
                        break;
                    }
                case 9:
                    if ((i9 & i) != 0) {
                        iU = s6.a(i11, unsafe2.getObject(t, j2), o(i10));
                        i7 += iU;
                        break;
                    } else {
                        break;
                    }
                case 10:
                    if ((i9 & i) != 0) {
                        iU = zzhi.w(i11, (t3) unsafe2.getObject(t, j2));
                        i7 += iU;
                        break;
                    } else {
                        break;
                    }
                case 11:
                    if ((i9 & i) != 0) {
                        iU = zzhi.M(i11, unsafe2.getInt(t, j2));
                        i7 += iU;
                        break;
                    } else {
                        break;
                    }
                case 12:
                    if ((i9 & i) != 0) {
                        iU = zzhi.U(i11, unsafe2.getInt(t, j2));
                        i7 += iU;
                        break;
                    } else {
                        break;
                    }
                case 13:
                    if ((i9 & i) != 0) {
                        iU = zzhi.T(i11);
                        i7 += iU;
                        break;
                    } else {
                        break;
                    }
                case 14:
                    if ((i9 & i) != 0) {
                        iU = zzhi.Q(i11);
                        i7 += iU;
                        break;
                    } else {
                        break;
                    }
                case 15:
                    if ((i9 & i) != 0) {
                        iU = zzhi.P(i11, unsafe2.getInt(t, j2));
                        i7 += iU;
                        break;
                    } else {
                        break;
                    }
                case 16:
                    if ((i9 & i) != 0) {
                        iU = zzhi.J(i11, unsafe2.getLong(t, j2));
                        i7 += iU;
                        break;
                    } else {
                        break;
                    }
                case 17:
                    if ((i9 & i) != 0) {
                        iU = zzhi.x(i11, (c6) unsafe2.getObject(t, j2), o(i10));
                        i7 += iU;
                        break;
                    } else {
                        break;
                    }
                case 18:
                    iU = s6.K(i11, (List) unsafe2.getObject(t, j2));
                    i7 += iU;
                    break;
                case 19:
                    iU = s6.H(i11, (List) unsafe2.getObject(t, j2));
                    i7 += iU;
                    break;
                case 20:
                    iU = s6.k(i11, (List) unsafe2.getObject(t, j2));
                    i7 += iU;
                    break;
                case 21:
                    iU = s6.r(i11, (List) unsafe2.getObject(t, j2));
                    i7 += iU;
                    break;
                case 22:
                    iU = s6.y(i11, (List) unsafe2.getObject(t, j2));
                    i7 += iU;
                    break;
                case 23:
                    iU = s6.K(i11, (List) unsafe2.getObject(t, j2));
                    i7 += iU;
                    break;
                case 24:
                    iU = s6.H(i11, (List) unsafe2.getObject(t, j2));
                    i7 += iU;
                    break;
                case 25:
                    List list2 = (List) unsafe2.getObject(t, j2);
                    Class<?> cls3 = s6.a;
                    int size2 = list2.size();
                    iU = size2 == 0 ? 0 : size2 * zzhi.v(i11);
                    i7 += iU;
                    break;
                case 26:
                    iU = s6.b(i11, (List) unsafe2.getObject(t, j2));
                    i7 += iU;
                    break;
                case 27:
                    iU = s6.c(i11, (List) unsafe2.getObject(t, j2), o(i10));
                    i7 += iU;
                    break;
                case 28:
                    iU = s6.l(i11, (List) unsafe2.getObject(t, j2));
                    i7 += iU;
                    break;
                case 29:
                    iU = s6.B(i11, (List) unsafe2.getObject(t, j2));
                    i7 += iU;
                    break;
                case 30:
                    iU = s6.v(i11, (List) unsafe2.getObject(t, j2));
                    i7 += iU;
                    break;
                case 31:
                    iU = s6.H(i11, (List) unsafe2.getObject(t, j2));
                    i7 += iU;
                    break;
                case 32:
                    iU = s6.K(i11, (List) unsafe2.getObject(t, j2));
                    i7 += iU;
                    break;
                case 33:
                    iU = s6.E(i11, (List) unsafe2.getObject(t, j2));
                    i7 += iU;
                    break;
                case 34:
                    iU = s6.s(i11, (List) unsafe2.getObject(t, j2));
                    i7 += iU;
                    break;
                case 35:
                    iL = s6.L((List) unsafe2.getObject(t, j2));
                    if (iL > 0) {
                        iD = zzhi.D(i11);
                        iL2 = zzhi.L(iL);
                        i7 = iL2 + iD + iL + i7;
                        break;
                    } else {
                        break;
                    }
                case 36:
                    iL = s6.I((List) unsafe2.getObject(t, j2));
                    if (iL > 0) {
                        iD = zzhi.D(i11);
                        iL2 = zzhi.L(iL);
                        i7 = iL2 + iD + iL + i7;
                        break;
                    } else {
                        break;
                    }
                case 37:
                    iL = s6.d((List) unsafe2.getObject(t, j2));
                    if (iL > 0) {
                        iD = zzhi.D(i11);
                        iL2 = zzhi.L(iL);
                        i7 = iL2 + iD + iL + i7;
                        break;
                    } else {
                        break;
                    }
                case 38:
                    iL = s6.n((List) unsafe2.getObject(t, j2));
                    if (iL > 0) {
                        iD = zzhi.D(i11);
                        iL2 = zzhi.L(iL);
                        i7 = iL2 + iD + iL + i7;
                        break;
                    } else {
                        break;
                    }
                case 39:
                    iL = s6.z((List) unsafe2.getObject(t, j2));
                    if (iL > 0) {
                        iD = zzhi.D(i11);
                        iL2 = zzhi.L(iL);
                        i7 = iL2 + iD + iL + i7;
                        break;
                    } else {
                        break;
                    }
                case 40:
                    iL = s6.L((List) unsafe2.getObject(t, j2));
                    if (iL > 0) {
                        iD = zzhi.D(i11);
                        iL2 = zzhi.L(iL);
                        i7 = iL2 + iD + iL + i7;
                        break;
                    } else {
                        break;
                    }
                case 41:
                    iL = s6.I((List) unsafe2.getObject(t, j2));
                    if (iL > 0) {
                        iD = zzhi.D(i11);
                        iL2 = zzhi.L(iL);
                        i7 = iL2 + iD + iL + i7;
                        break;
                    } else {
                        break;
                    }
                case 42:
                    List list3 = (List) unsafe2.getObject(t, j2);
                    Class<?> cls4 = s6.a;
                    iL = list3.size();
                    if (iL > 0) {
                        iD = zzhi.D(i11);
                        iL2 = zzhi.L(iL);
                        i7 = iL2 + iD + iL + i7;
                        break;
                    } else {
                        break;
                    }
                case 43:
                    iL = s6.C((List) unsafe2.getObject(t, j2));
                    if (iL > 0) {
                        iD = zzhi.D(i11);
                        iL2 = zzhi.L(iL);
                        i7 = iL2 + iD + iL + i7;
                        break;
                    } else {
                        break;
                    }
                case 44:
                    iL = s6.w((List) unsafe2.getObject(t, j2));
                    if (iL > 0) {
                        iD = zzhi.D(i11);
                        iL2 = zzhi.L(iL);
                        i7 = iL2 + iD + iL + i7;
                        break;
                    } else {
                        break;
                    }
                case 45:
                    iL = s6.I((List) unsafe2.getObject(t, j2));
                    if (iL > 0) {
                        iD = zzhi.D(i11);
                        iL2 = zzhi.L(iL);
                        i7 = iL2 + iD + iL + i7;
                        break;
                    } else {
                        break;
                    }
                case 46:
                    iL = s6.L((List) unsafe2.getObject(t, j2));
                    if (iL > 0) {
                        iD = zzhi.D(i11);
                        iL2 = zzhi.L(iL);
                        i7 = iL2 + iD + iL + i7;
                        break;
                    } else {
                        break;
                    }
                case 47:
                    iL = s6.F((List) unsafe2.getObject(t, j2));
                    if (iL > 0) {
                        iD = zzhi.D(i11);
                        iL2 = zzhi.L(iL);
                        i7 = iL2 + iD + iL + i7;
                        break;
                    } else {
                        break;
                    }
                case 48:
                    iL = s6.t((List) unsafe2.getObject(t, j2));
                    if (iL > 0) {
                        iD = zzhi.D(i11);
                        iL2 = zzhi.L(iL);
                        i7 = iL2 + iD + iL + i7;
                        break;
                    } else {
                        break;
                    }
                case 49:
                    iU = s6.m(i11, (List) unsafe2.getObject(t, j2), o(i10));
                    i7 += iU;
                    break;
                case 50:
                    iU = this.q.i(i11, unsafe2.getObject(t, j2), A(i10));
                    i7 += iU;
                    break;
                case 51:
                    if (w(t, i11, i10)) {
                        iU = zzhi.u(i11);
                        i7 += iU;
                        break;
                    } else {
                        break;
                    }
                case 52:
                    if (w(t, i11, i10)) {
                        iU = zzhi.n(i11);
                        i7 += iU;
                        break;
                    } else {
                        break;
                    }
                case 53:
                    if (w(t, i11, i10)) {
                        iU = zzhi.B(i11, L(t, j2));
                        i7 += iU;
                        break;
                    } else {
                        break;
                    }
                case 54:
                    if (w(t, i11, i10)) {
                        iU = zzhi.E(i11, L(t, j2));
                        i7 += iU;
                        break;
                    } else {
                        break;
                    }
                case 55:
                    if (w(t, i11, i10)) {
                        iU = zzhi.I(i11, J(t, j2));
                        i7 += iU;
                        break;
                    } else {
                        break;
                    }
                case 56:
                    if (w(t, i11, i10)) {
                        iU = zzhi.N(i11);
                        i7 += iU;
                        break;
                    } else {
                        break;
                    }
                case 57:
                    if (w(t, i11, i10)) {
                        iU = zzhi.S(i11);
                        i7 += iU;
                        break;
                    } else {
                        break;
                    }
                case 58:
                    if (w(t, i11, i10)) {
                        iU = zzhi.v(i11);
                        i7 += iU;
                        break;
                    } else {
                        break;
                    }
                case 59:
                    if (w(t, i11, i10)) {
                        Object object2 = unsafe2.getObject(t, j2);
                        iU = object2 instanceof t3 ? zzhi.w(i11, (t3) object2) : zzhi.o(i11, (String) object2);
                        i7 += iU;
                        break;
                    } else {
                        break;
                    }
                case 60:
                    if (w(t, i11, i10)) {
                        iU = s6.a(i11, unsafe2.getObject(t, j2), o(i10));
                        i7 += iU;
                        break;
                    } else {
                        break;
                    }
                case 61:
                    if (w(t, i11, i10)) {
                        iU = zzhi.w(i11, (t3) unsafe2.getObject(t, j2));
                        i7 += iU;
                        break;
                    } else {
                        break;
                    }
                case 62:
                    if (w(t, i11, i10)) {
                        iU = zzhi.M(i11, J(t, j2));
                        i7 += iU;
                        break;
                    } else {
                        break;
                    }
                case 63:
                    if (w(t, i11, i10)) {
                        iU = zzhi.U(i11, J(t, j2));
                        i7 += iU;
                        break;
                    } else {
                        break;
                    }
                case 64:
                    if (w(t, i11, i10)) {
                        iU = zzhi.T(i11);
                        i7 += iU;
                        break;
                    } else {
                        break;
                    }
                case 65:
                    if (w(t, i11, i10)) {
                        iU = zzhi.Q(i11);
                        i7 += iU;
                        break;
                    } else {
                        break;
                    }
                case 66:
                    if (w(t, i11, i10)) {
                        iU = zzhi.P(i11, J(t, j2));
                        i7 += iU;
                        break;
                    } else {
                        break;
                    }
                case 67:
                    if (w(t, i11, i10)) {
                        iU = zzhi.J(i11, L(t, j2));
                        i7 += iU;
                        break;
                    } else {
                        break;
                    }
                case 68:
                    if (w(t, i11, i10)) {
                        iU = zzhi.x(i11, (c6) unsafe2.getObject(t, j2), o(i10));
                        i7 += iU;
                        break;
                    } else {
                        break;
                    }
            }
        }
        d7<?, ?> d7Var2 = this.o;
        int iJ = d7Var2.j(d7Var2.e(t)) + i7;
        if (!this.h) {
            return iJ;
        }
        n4<T> n4VarB = this.p.b(t);
        int iA = 0;
        for (int i15 = 0; i15 < n4VarB.f1461b.e(); i15++) {
            Map.Entry entryD = n4VarB.f1461b.d(i15);
            iA += n4.a((p4) entryD.getKey(), entryD.getValue());
        }
        for (Map.Entry entry : n4VarB.f1461b.g()) {
            iA += n4.a((p4) entry.getKey(), entry.getValue());
        }
        return iJ + iA;
    }

    /* JADX WARN: Removed duplicated region for block: B:104:0x01c1  */
    @Override // b.i.a.f.h.l.q6
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean f(T t, T t2) {
        int length = this.c.length;
        int i = 0;
        while (true) {
            boolean zJ = true;
            if (i >= length) {
                if (!this.o.e(t).equals(this.o.e(t2))) {
                    return false;
                }
                if (this.h) {
                    return this.p.b(t).equals(this.p.b(t2));
                }
                return true;
            }
            int I = I(i);
            long j = I & 1048575;
            switch ((I & 267386880) >>> 20) {
                case 0:
                    if (!H(t, t2, i) || Double.doubleToLongBits(j7.q(t, j)) != Double.doubleToLongBits(j7.q(t2, j))) {
                        zJ = false;
                        break;
                    }
                    break;
                case 1:
                    if (!H(t, t2, i) || Float.floatToIntBits(j7.n(t, j)) != Float.floatToIntBits(j7.n(t2, j))) {
                    }
                    break;
                case 2:
                    if (!H(t, t2, i) || j7.i(t, j) != j7.i(t2, j)) {
                    }
                    break;
                case 3:
                    if (!H(t, t2, i) || j7.i(t, j) != j7.i(t2, j)) {
                    }
                    break;
                case 4:
                    if (!H(t, t2, i) || j7.b(t, j) != j7.b(t2, j)) {
                    }
                    break;
                case 5:
                    if (!H(t, t2, i) || j7.i(t, j) != j7.i(t2, j)) {
                    }
                    break;
                case 6:
                    if (!H(t, t2, i) || j7.b(t, j) != j7.b(t2, j)) {
                    }
                    break;
                case 7:
                    if (!H(t, t2, i) || j7.m(t, j) != j7.m(t2, j)) {
                    }
                    break;
                case 8:
                    if (!H(t, t2, i) || !s6.j(j7.r(t, j), j7.r(t2, j))) {
                    }
                    break;
                case 9:
                    if (!H(t, t2, i) || !s6.j(j7.r(t, j), j7.r(t2, j))) {
                    }
                    break;
                case 10:
                    if (!H(t, t2, i) || !s6.j(j7.r(t, j), j7.r(t2, j))) {
                    }
                    break;
                case 11:
                    if (!H(t, t2, i) || j7.b(t, j) != j7.b(t2, j)) {
                    }
                    break;
                case 12:
                    if (!H(t, t2, i) || j7.b(t, j) != j7.b(t2, j)) {
                    }
                    break;
                case 13:
                    if (!H(t, t2, i) || j7.b(t, j) != j7.b(t2, j)) {
                    }
                    break;
                case 14:
                    if (!H(t, t2, i) || j7.i(t, j) != j7.i(t2, j)) {
                    }
                    break;
                case 15:
                    if (!H(t, t2, i) || j7.b(t, j) != j7.b(t2, j)) {
                    }
                    break;
                case 16:
                    if (!H(t, t2, i) || j7.i(t, j) != j7.i(t2, j)) {
                    }
                    break;
                case 17:
                    if (!H(t, t2, i) || !s6.j(j7.r(t, j), j7.r(t2, j))) {
                    }
                    break;
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
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
                    zJ = s6.j(j7.r(t, j), j7.r(t2, j));
                    break;
                case 50:
                    zJ = s6.j(j7.r(t, j), j7.r(t2, j));
                    break;
                case 51:
                case 52:
                case 53:
                case 54:
                case 55:
                case 56:
                case 57:
                case 58:
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
                    long jK = K(i) & 1048575;
                    if (j7.b(t, jK) != j7.b(t2, jK) || !s6.j(j7.r(t, j), j7.r(t2, j))) {
                    }
                    break;
            }
            if (!zJ) {
                return false;
            }
            i += 3;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x0025  */
    @Override // b.i.a.f.h.l.q6
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void g(T t, v7 v7Var) throws IOException {
        Iterator itL;
        Map.Entry<?, ?> entry;
        Objects.requireNonNull(v7Var);
        if (!this.i) {
            D(t, v7Var);
            return;
        }
        if (this.h) {
            n4<T> n4VarB = this.p.b(t);
            if (n4VarB.f1461b.isEmpty()) {
                itL = null;
                entry = null;
            } else {
                itL = n4VarB.l();
                entry = (Map.Entry) itL.next();
            }
        }
        int length = this.c.length;
        for (int i = 0; i < length; i += 3) {
            int I = I(i);
            int i2 = this.c[i];
            while (entry != null && this.p.a(entry) <= i2) {
                this.p.d(v7Var, entry);
                entry = itL.hasNext() ? (Map.Entry) itL.next() : null;
            }
            switch ((267386880 & I) >>> 20) {
                case 0:
                    if (v(t, i)) {
                        ((g4) v7Var).a(i2, j7.q(t, I & 1048575));
                        break;
                    } else {
                        break;
                    }
                case 1:
                    if (v(t, i)) {
                        ((g4) v7Var).b(i2, j7.n(t, I & 1048575));
                        break;
                    } else {
                        break;
                    }
                case 2:
                    if (v(t, i)) {
                        ((g4) v7Var).a.g(i2, j7.i(t, I & 1048575));
                        break;
                    } else {
                        break;
                    }
                case 3:
                    if (v(t, i)) {
                        ((g4) v7Var).a.g(i2, j7.i(t, I & 1048575));
                        break;
                    } else {
                        break;
                    }
                case 4:
                    if (v(t, i)) {
                        ((g4) v7Var).a.s(i2, j7.b(t, I & 1048575));
                        break;
                    } else {
                        break;
                    }
                case 5:
                    if (v(t, i)) {
                        ((g4) v7Var).a.z(i2, j7.i(t, I & 1048575));
                        break;
                    } else {
                        break;
                    }
                case 6:
                    if (v(t, i)) {
                        ((g4) v7Var).a.G(i2, j7.b(t, I & 1048575));
                        break;
                    } else {
                        break;
                    }
                case 7:
                    if (v(t, i)) {
                        ((g4) v7Var).a.l(i2, j7.m(t, I & 1048575));
                        break;
                    } else {
                        break;
                    }
                case 8:
                    if (v(t, i)) {
                        r(i2, j7.r(t, I & 1048575), v7Var);
                        break;
                    } else {
                        break;
                    }
                case 9:
                    if (v(t, i)) {
                        ((g4) v7Var).d(i2, j7.r(t, I & 1048575), o(i));
                        break;
                    } else {
                        break;
                    }
                case 10:
                    if (v(t, i)) {
                        ((g4) v7Var).a.h(i2, (t3) j7.r(t, I & 1048575));
                        break;
                    } else {
                        break;
                    }
                case 11:
                    if (v(t, i)) {
                        ((g4) v7Var).a.y(i2, j7.b(t, I & 1048575));
                        break;
                    } else {
                        break;
                    }
                case 12:
                    if (v(t, i)) {
                        ((g4) v7Var).a.s(i2, j7.b(t, I & 1048575));
                        break;
                    } else {
                        break;
                    }
                case 13:
                    if (v(t, i)) {
                        ((g4) v7Var).a.G(i2, j7.b(t, I & 1048575));
                        break;
                    } else {
                        break;
                    }
                case 14:
                    if (v(t, i)) {
                        ((g4) v7Var).a.z(i2, j7.i(t, I & 1048575));
                        break;
                    } else {
                        break;
                    }
                case 15:
                    if (v(t, i)) {
                        ((g4) v7Var).g(i2, j7.b(t, I & 1048575));
                        break;
                    } else {
                        break;
                    }
                case 16:
                    if (v(t, i)) {
                        ((g4) v7Var).f(i2, j7.i(t, I & 1048575));
                        break;
                    } else {
                        break;
                    }
                case 17:
                    if (v(t, i)) {
                        ((g4) v7Var).e(i2, j7.r(t, I & 1048575), o(i));
                        break;
                    } else {
                        break;
                    }
                case 18:
                    s6.h(this.c[i], (List) j7.r(t, I & 1048575), v7Var, false);
                    break;
                case 19:
                    s6.q(this.c[i], (List) j7.r(t, I & 1048575), v7Var, false);
                    break;
                case 20:
                    s6.u(this.c[i], (List) j7.r(t, I & 1048575), v7Var, false);
                    break;
                case 21:
                    s6.x(this.c[i], (List) j7.r(t, I & 1048575), v7Var, false);
                    break;
                case 22:
                    s6.J(this.c[i], (List) j7.r(t, I & 1048575), v7Var, false);
                    break;
                case 23:
                    s6.D(this.c[i], (List) j7.r(t, I & 1048575), v7Var, false);
                    break;
                case 24:
                    s6.O(this.c[i], (List) j7.r(t, I & 1048575), v7Var, false);
                    break;
                case 25:
                    s6.R(this.c[i], (List) j7.r(t, I & 1048575), v7Var, false);
                    break;
                case 26:
                    s6.f(this.c[i], (List) j7.r(t, I & 1048575), v7Var);
                    break;
                case 27:
                    s6.g(this.c[i], (List) j7.r(t, I & 1048575), v7Var, o(i));
                    break;
                case 28:
                    s6.o(this.c[i], (List) j7.r(t, I & 1048575), v7Var);
                    break;
                case 29:
                    s6.M(this.c[i], (List) j7.r(t, I & 1048575), v7Var, false);
                    break;
                case 30:
                    s6.Q(this.c[i], (List) j7.r(t, I & 1048575), v7Var, false);
                    break;
                case 31:
                    s6.P(this.c[i], (List) j7.r(t, I & 1048575), v7Var, false);
                    break;
                case 32:
                    s6.G(this.c[i], (List) j7.r(t, I & 1048575), v7Var, false);
                    break;
                case 33:
                    s6.N(this.c[i], (List) j7.r(t, I & 1048575), v7Var, false);
                    break;
                case 34:
                    s6.A(this.c[i], (List) j7.r(t, I & 1048575), v7Var, false);
                    break;
                case 35:
                    s6.h(this.c[i], (List) j7.r(t, I & 1048575), v7Var, true);
                    break;
                case 36:
                    s6.q(this.c[i], (List) j7.r(t, I & 1048575), v7Var, true);
                    break;
                case 37:
                    s6.u(this.c[i], (List) j7.r(t, I & 1048575), v7Var, true);
                    break;
                case 38:
                    s6.x(this.c[i], (List) j7.r(t, I & 1048575), v7Var, true);
                    break;
                case 39:
                    s6.J(this.c[i], (List) j7.r(t, I & 1048575), v7Var, true);
                    break;
                case 40:
                    s6.D(this.c[i], (List) j7.r(t, I & 1048575), v7Var, true);
                    break;
                case 41:
                    s6.O(this.c[i], (List) j7.r(t, I & 1048575), v7Var, true);
                    break;
                case 42:
                    s6.R(this.c[i], (List) j7.r(t, I & 1048575), v7Var, true);
                    break;
                case 43:
                    s6.M(this.c[i], (List) j7.r(t, I & 1048575), v7Var, true);
                    break;
                case 44:
                    s6.Q(this.c[i], (List) j7.r(t, I & 1048575), v7Var, true);
                    break;
                case 45:
                    s6.P(this.c[i], (List) j7.r(t, I & 1048575), v7Var, true);
                    break;
                case 46:
                    s6.G(this.c[i], (List) j7.r(t, I & 1048575), v7Var, true);
                    break;
                case 47:
                    s6.N(this.c[i], (List) j7.r(t, I & 1048575), v7Var, true);
                    break;
                case 48:
                    s6.A(this.c[i], (List) j7.r(t, I & 1048575), v7Var, true);
                    break;
                case 49:
                    s6.p(this.c[i], (List) j7.r(t, I & 1048575), v7Var, o(i));
                    break;
                case 50:
                    t(v7Var, i2, j7.r(t, I & 1048575), i);
                    break;
                case 51:
                    if (w(t, i2, i)) {
                        ((g4) v7Var).a(i2, y(t, I & 1048575));
                        break;
                    } else {
                        break;
                    }
                case 52:
                    if (w(t, i2, i)) {
                        ((g4) v7Var).b(i2, F(t, I & 1048575));
                        break;
                    } else {
                        break;
                    }
                case 53:
                    if (w(t, i2, i)) {
                        ((g4) v7Var).a.g(i2, L(t, I & 1048575));
                        break;
                    } else {
                        break;
                    }
                case 54:
                    if (w(t, i2, i)) {
                        ((g4) v7Var).a.g(i2, L(t, I & 1048575));
                        break;
                    } else {
                        break;
                    }
                case 55:
                    if (w(t, i2, i)) {
                        ((g4) v7Var).a.s(i2, J(t, I & 1048575));
                        break;
                    } else {
                        break;
                    }
                case 56:
                    if (w(t, i2, i)) {
                        ((g4) v7Var).a.z(i2, L(t, I & 1048575));
                        break;
                    } else {
                        break;
                    }
                case 57:
                    if (w(t, i2, i)) {
                        ((g4) v7Var).a.G(i2, J(t, I & 1048575));
                        break;
                    } else {
                        break;
                    }
                case 58:
                    if (w(t, i2, i)) {
                        ((g4) v7Var).a.l(i2, N(t, I & 1048575));
                        break;
                    } else {
                        break;
                    }
                case 59:
                    if (w(t, i2, i)) {
                        r(i2, j7.r(t, I & 1048575), v7Var);
                        break;
                    } else {
                        break;
                    }
                case 60:
                    if (w(t, i2, i)) {
                        ((g4) v7Var).d(i2, j7.r(t, I & 1048575), o(i));
                        break;
                    } else {
                        break;
                    }
                case 61:
                    if (w(t, i2, i)) {
                        ((g4) v7Var).a.h(i2, (t3) j7.r(t, I & 1048575));
                        break;
                    } else {
                        break;
                    }
                case 62:
                    if (w(t, i2, i)) {
                        ((g4) v7Var).a.y(i2, J(t, I & 1048575));
                        break;
                    } else {
                        break;
                    }
                case 63:
                    if (w(t, i2, i)) {
                        ((g4) v7Var).a.s(i2, J(t, I & 1048575));
                        break;
                    } else {
                        break;
                    }
                case 64:
                    if (w(t, i2, i)) {
                        ((g4) v7Var).a.G(i2, J(t, I & 1048575));
                        break;
                    } else {
                        break;
                    }
                case 65:
                    if (w(t, i2, i)) {
                        ((g4) v7Var).a.z(i2, L(t, I & 1048575));
                        break;
                    } else {
                        break;
                    }
                case 66:
                    if (w(t, i2, i)) {
                        ((g4) v7Var).g(i2, J(t, I & 1048575));
                        break;
                    } else {
                        break;
                    }
                case 67:
                    if (w(t, i2, i)) {
                        ((g4) v7Var).f(i2, L(t, I & 1048575));
                        break;
                    } else {
                        break;
                    }
                case 68:
                    if (w(t, i2, i)) {
                        ((g4) v7Var).e(i2, j7.r(t, I & 1048575), o(i));
                        break;
                    } else {
                        break;
                    }
            }
        }
        while (entry != null) {
            this.p.d(v7Var, entry);
            entry = itL.hasNext() ? (Map.Entry) itL.next() : null;
        }
        s(this.o, t, v7Var);
    }

    /* JADX WARN: Code restructure failed: missing block: B:118:0x0340, code lost:
    
        if (r0 == r14) goto L129;
     */
    /* JADX WARN: Code restructure failed: missing block: B:128:0x0387, code lost:
    
        if (r0 == r15) goto L129;
     */
    /* JADX WARN: Code restructure failed: missing block: B:131:0x03a1, code lost:
    
        r2 = r18;
        r10 = r19;
        r8 = r24;
     */
    /* JADX WARN: Failed to find 'out' block for switch in B:38:0x009b. Please report as an issue. */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v16, types: [int] */
    @Override // b.i.a.f.h.l.q6
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void h(T t, byte[] bArr, int i, int i2, s3 s3Var) throws IOException {
        byte b2;
        int iJ1;
        int iZ;
        int i3;
        int i4;
        int i5;
        Unsafe unsafe;
        e6<T> e6Var;
        int i6;
        int i7;
        int i8;
        s3 s3Var2;
        e6<T> e6Var2;
        int i9;
        int i10;
        int i11;
        int i12;
        T t2;
        byte[] bArr2;
        int i13;
        T t3;
        s3 s3Var3;
        e6<T> e6Var3;
        int i14;
        T t4;
        s3 s3Var4;
        s3 s3Var5;
        T t5;
        s3 s3Var6;
        T t6;
        e6<T> e6Var4;
        int i15 = i2;
        if (!this.i) {
            m(t, bArr, i, i2, 0, s3Var);
            return;
        }
        Unsafe unsafe2 = f1441b;
        int i16 = -1;
        int i17 = 0;
        T t7 = t;
        byte[] bArr3 = bArr;
        int iI1 = i;
        s3 s3Var7 = s3Var;
        e6<T> e6Var5 = this;
        int i18 = -1;
        int i19 = 0;
        int i20 = 1048575;
        int i21 = 0;
        while (iI1 < i15) {
            int i22 = iI1 + 1;
            byte b3 = bArr3[iI1];
            if (b3 < 0) {
                iJ1 = b.i.a.f.e.o.f.J1(b3, bArr3, i22, s3Var7);
                b2 = s3Var7.a;
            } else {
                b2 = b3;
                iJ1 = i22;
            }
            int i23 = b2 >>> 3;
            int i24 = b2 & 7;
            if (i23 > i18) {
                int i25 = i19 / 3;
                if (i23 >= e6Var5.e && i23 <= e6Var5.f) {
                    iZ = e6Var5.z(i23, i25);
                    i3 = iZ;
                }
                i3 = -1;
            } else {
                if (i23 >= e6Var5.e && i23 <= e6Var5.f) {
                    iZ = e6Var5.z(i23, i17);
                    i3 = iZ;
                }
                i3 = -1;
            }
            if (i3 == i16) {
                i4 = i23;
                i5 = 0;
            } else {
                int[] iArr = e6Var5.c;
                int i26 = iArr[i3 + 1];
                int i27 = (i26 & 267386880) >>> 20;
                long j = i26 & 1048575;
                e6<T> e6Var6 = e6Var5;
                if (i27 <= 17) {
                    int i28 = iArr[i3 + 2];
                    int i29 = 1 << (i28 >>> 20);
                    int i30 = i28 & 1048575;
                    if (i30 != i20) {
                        bArr2 = bArr3;
                        if (i20 != 1048575) {
                            unsafe2.putInt(t7, i20, i21);
                        }
                        if (i30 != 1048575) {
                            i21 = unsafe2.getInt(t7, i30);
                        }
                        i20 = i30;
                    } else {
                        bArr2 = bArr3;
                    }
                    switch (i27) {
                        case 0:
                            i4 = i23;
                            i13 = i3;
                            T t8 = t7;
                            s3 s3Var8 = s3Var7;
                            bArr3 = bArr2;
                            e6Var = e6Var6;
                            if (i24 == 1) {
                                j7.d(t8, j, Double.longBitsToDouble(b.i.a.f.e.o.f.o2(bArr3, iJ1)));
                                iI1 = iJ1 + 8;
                                i6 = i21 | i29;
                                t7 = t8;
                                s3Var7 = s3Var8;
                                unsafe = unsafe2;
                                i19 = i13;
                                i21 = i6;
                                e6Var5 = e6Var;
                                i15 = i2;
                                i18 = i4;
                                unsafe2 = unsafe;
                                i17 = 0;
                                i16 = -1;
                                break;
                            }
                            i5 = i13;
                            break;
                        case 1:
                            i4 = i23;
                            i13 = i3;
                            t3 = t7;
                            s3Var3 = s3Var7;
                            bArr3 = bArr2;
                            e6Var3 = e6Var6;
                            if (i24 == 5) {
                                j7.e.d(t3, j, Float.intBitsToFloat(b.i.a.f.e.o.f.N1(bArr3, iJ1)));
                                iI1 = iJ1 + 4;
                                i14 = i21 | i29;
                                i21 = i14;
                                t7 = t3;
                                s3Var7 = s3Var3;
                                unsafe = unsafe2;
                                i19 = i13;
                                e6Var5 = e6Var3;
                                i15 = i2;
                                i18 = i4;
                                unsafe2 = unsafe;
                                i17 = 0;
                                i16 = -1;
                                break;
                            }
                            i5 = i13;
                            break;
                        case 2:
                        case 3:
                            i4 = i23;
                            i13 = i3;
                            s3Var3 = s3Var7;
                            bArr3 = bArr2;
                            T t9 = t7;
                            e6Var3 = e6Var6;
                            if (i24 == 0) {
                                iI1 = b.i.a.f.e.o.f.n2(bArr3, iJ1, s3Var3);
                                unsafe2.putLong(t, j, s3Var3.f1493b);
                                i14 = i21 | i29;
                                t3 = t9;
                                i21 = i14;
                                t7 = t3;
                                s3Var7 = s3Var3;
                                unsafe = unsafe2;
                                i19 = i13;
                                e6Var5 = e6Var3;
                                i15 = i2;
                                i18 = i4;
                                unsafe2 = unsafe;
                                i17 = 0;
                                i16 = -1;
                                break;
                            }
                            i5 = i13;
                            break;
                        case 4:
                        case 11:
                            i4 = i23;
                            i13 = i3;
                            s3Var3 = s3Var7;
                            bArr3 = bArr2;
                            t4 = t7;
                            e6Var3 = e6Var6;
                            if (i24 == 0) {
                                iI1 = b.i.a.f.e.o.f.O1(bArr3, iJ1, s3Var3);
                                unsafe2.putInt(t4, j, s3Var3.a);
                                t3 = t4;
                                i14 = i21 | i29;
                                i21 = i14;
                                t7 = t3;
                                s3Var7 = s3Var3;
                                unsafe = unsafe2;
                                i19 = i13;
                                e6Var5 = e6Var3;
                                i15 = i2;
                                i18 = i4;
                                unsafe2 = unsafe;
                                i17 = 0;
                                i16 = -1;
                                break;
                            }
                            i5 = i13;
                            break;
                        case 5:
                        case 14:
                            i4 = i23;
                            i13 = i3;
                            s3 s3Var9 = s3Var7;
                            bArr3 = bArr2;
                            T t10 = t7;
                            if (i24 == 1) {
                                e6Var3 = e6Var6;
                                s3Var3 = s3Var9;
                                unsafe2.putLong(t, j, b.i.a.f.e.o.f.o2(bArr3, iJ1));
                                iI1 = iJ1 + 8;
                                t3 = t10;
                                i14 = i21 | i29;
                                i21 = i14;
                                t7 = t3;
                                s3Var7 = s3Var3;
                                unsafe = unsafe2;
                                i19 = i13;
                                e6Var5 = e6Var3;
                                i15 = i2;
                                i18 = i4;
                                unsafe2 = unsafe;
                                i17 = 0;
                                i16 = -1;
                                break;
                            }
                            i5 = i13;
                            break;
                        case 6:
                        case 13:
                            i4 = i23;
                            i13 = i3;
                            s3Var5 = s3Var7;
                            bArr3 = bArr2;
                            t5 = t7;
                            i15 = i2;
                            if (i24 != 5) {
                                i5 = i13;
                                break;
                            } else {
                                unsafe2.putInt(t5, j, b.i.a.f.e.o.f.N1(bArr3, iJ1));
                                iI1 = iJ1 + 4;
                                i21 |= i29;
                                t7 = t5;
                                s3Var7 = s3Var5;
                                i19 = i13;
                                e6Var5 = e6Var6;
                                i18 = i4;
                                i17 = 0;
                                i16 = -1;
                                break;
                            }
                        case 7:
                            i4 = i23;
                            i13 = i3;
                            s3Var5 = s3Var7;
                            bArr3 = bArr2;
                            t5 = t7;
                            i15 = i2;
                            if (i24 != 0) {
                                i5 = i13;
                                break;
                            } else {
                                iI1 = b.i.a.f.e.o.f.n2(bArr3, iJ1, s3Var5);
                                j7.e.g(t5, j, s3Var5.f1493b != 0);
                                i21 |= i29;
                                t7 = t5;
                                s3Var7 = s3Var5;
                                i19 = i13;
                                e6Var5 = e6Var6;
                                i18 = i4;
                                i17 = 0;
                                i16 = -1;
                                break;
                            }
                        case 8:
                            i4 = i23;
                            i13 = i3;
                            s3Var4 = s3Var7;
                            bArr3 = bArr2;
                            t4 = t7;
                            if (i24 == 2) {
                                iI1 = (536870912 & i26) == 0 ? b.i.a.f.e.o.f.r2(bArr3, iJ1, s3Var4) : b.i.a.f.e.o.f.t2(bArr3, iJ1, s3Var4);
                                unsafe2.putObject(t4, j, s3Var4.c);
                                s3Var3 = s3Var4;
                                e6Var3 = e6Var6;
                                t3 = t4;
                                i14 = i21 | i29;
                                i21 = i14;
                                t7 = t3;
                                s3Var7 = s3Var3;
                                unsafe = unsafe2;
                                i19 = i13;
                                e6Var5 = e6Var3;
                                i15 = i2;
                                i18 = i4;
                                unsafe2 = unsafe;
                                i17 = 0;
                                i16 = -1;
                                break;
                            }
                            i5 = i13;
                            break;
                        case 9:
                            i4 = i23;
                            i13 = i3;
                            s3Var4 = s3Var7;
                            bArr3 = bArr2;
                            t4 = t7;
                            if (i24 == 2) {
                                q6 q6VarO = e6Var6.o(i13);
                                e6Var6 = e6Var6;
                                iI1 = b.i.a.f.e.o.f.M1(q6VarO, bArr3, iJ1, i2, s3Var4);
                                Object object = unsafe2.getObject(t4, j);
                                if (object == null) {
                                    unsafe2.putObject(t4, j, s3Var4.c);
                                } else {
                                    unsafe2.putObject(t4, j, w4.c(object, s3Var4.c));
                                }
                                s3Var3 = s3Var4;
                                e6Var3 = e6Var6;
                                t3 = t4;
                                i14 = i21 | i29;
                                i21 = i14;
                                t7 = t3;
                                s3Var7 = s3Var3;
                                unsafe = unsafe2;
                                i19 = i13;
                                e6Var5 = e6Var3;
                                i15 = i2;
                                i18 = i4;
                                unsafe2 = unsafe;
                                i17 = 0;
                                i16 = -1;
                                break;
                            }
                            i5 = i13;
                            break;
                        case 10:
                            i4 = i23;
                            i13 = i3;
                            s3Var6 = s3Var7;
                            bArr3 = bArr2;
                            t6 = t7;
                            e6Var4 = e6Var6;
                            if (i24 != 2) {
                                i5 = i13;
                                break;
                            } else {
                                iI1 = b.i.a.f.e.o.f.v2(bArr3, iJ1, s3Var6);
                                unsafe2.putObject(t6, j, s3Var6.c);
                                i21 |= i29;
                                i15 = i2;
                                e6Var2 = e6Var4;
                                t2 = t6;
                                s3Var2 = s3Var6;
                                i12 = i13;
                                break;
                            }
                        case 12:
                            i4 = i23;
                            i13 = i3;
                            s3Var6 = s3Var7;
                            bArr3 = bArr2;
                            t6 = t7;
                            e6Var4 = e6Var6;
                            if (i24 != 0) {
                                i5 = i13;
                                break;
                            } else {
                                iI1 = b.i.a.f.e.o.f.O1(bArr3, iJ1, s3Var6);
                                unsafe2.putInt(t6, j, s3Var6.a);
                                i21 |= i29;
                                i15 = i2;
                                e6Var2 = e6Var4;
                                t2 = t6;
                                s3Var2 = s3Var6;
                                i12 = i13;
                                break;
                            }
                        case 15:
                            i4 = i23;
                            i13 = i3;
                            s3Var6 = s3Var7;
                            bArr3 = bArr2;
                            t6 = t7;
                            e6Var4 = e6Var6;
                            if (i24 != 0) {
                                i5 = i13;
                                break;
                            } else {
                                iI1 = b.i.a.f.e.o.f.O1(bArr3, iJ1, s3Var6);
                                unsafe2.putInt(t6, j, d4.b(s3Var6.a));
                                i21 |= i29;
                                i15 = i2;
                                e6Var2 = e6Var4;
                                t2 = t6;
                                s3Var2 = s3Var6;
                                i12 = i13;
                                break;
                            }
                        case 16:
                            if (i24 != 0) {
                                i4 = i23;
                                i13 = i3;
                                i5 = i13;
                                break;
                            } else {
                                bArr3 = bArr2;
                                int iN2 = b.i.a.f.e.o.f.n2(bArr3, iJ1, s3Var7);
                                i13 = i3;
                                i4 = i23;
                                s3 s3Var10 = s3Var7;
                                unsafe2.putLong(t, j, d4.a(s3Var7.f1493b));
                                i21 |= i29;
                                iI1 = iN2;
                                t6 = t7;
                                s3Var6 = s3Var10;
                                e6Var4 = e6Var6;
                                i15 = i2;
                                e6Var2 = e6Var4;
                                t2 = t6;
                                s3Var2 = s3Var6;
                                i12 = i13;
                                break;
                            }
                        default:
                            i4 = i23;
                            i13 = i3;
                            i5 = i13;
                            break;
                    }
                } else {
                    i4 = i23;
                    T t11 = t7;
                    s3Var2 = s3Var7;
                    e6Var2 = e6Var6;
                    i15 = i2;
                    int i31 = i3;
                    if (i27 != 27) {
                        int i32 = iJ1;
                        i7 = i31;
                        if (i27 <= 49) {
                            i9 = i20;
                            i10 = i21;
                            unsafe = unsafe2;
                            iI1 = k(t, bArr, i32, i2, b2, i4, i24, i7, i26, i27, j, s3Var);
                        } else {
                            i9 = i20;
                            i10 = i21;
                            unsafe = unsafe2;
                            i11 = i32;
                            if (i27 != 50) {
                                iI1 = j(t, bArr, i11, i2, b2, i4, i24, i26, i27, j, i7, s3Var);
                            } else if (i24 == 2) {
                                l(t, bArr, i11, i2, i7, j, s3Var);
                                throw null;
                            }
                        }
                    } else if (i24 == 2) {
                        b5 b5VarF = (b5) unsafe2.getObject(t11, j);
                        if (!b5VarF.a()) {
                            int size = b5VarF.size();
                            b5VarF = b5VarF.f(size == 0 ? 10 : size << 1);
                            unsafe2.putObject(t11, j, b5VarF);
                        }
                        i12 = i31;
                        t2 = t11;
                        iI1 = b.i.a.f.e.o.f.K1(e6Var2.o(i31), b2, bArr, iJ1, i2, b5VarF, s3Var);
                    } else {
                        i7 = i31;
                        i11 = iJ1;
                        i9 = i20;
                        i10 = i21;
                        unsafe = unsafe2;
                    }
                    iI1 = i11;
                    i8 = iI1;
                    i21 = i10;
                    i20 = i9;
                    iI1 = b.i.a.f.e.o.f.I1(b2, bArr, i8, i2, M(t), s3Var);
                    i19 = i7;
                    e6Var = this;
                    t7 = t;
                    bArr3 = bArr;
                    s3Var7 = s3Var;
                    i6 = i21;
                    i21 = i6;
                    e6Var5 = e6Var;
                    i15 = i2;
                    i18 = i4;
                    unsafe2 = unsafe;
                    i17 = 0;
                    i16 = -1;
                }
                t7 = t2;
                e6Var5 = e6Var2;
                s3Var7 = s3Var2;
                i19 = i12;
                i18 = i4;
                i17 = 0;
                i16 = -1;
            }
            i7 = i5;
            unsafe = unsafe2;
            i8 = iJ1;
            iI1 = b.i.a.f.e.o.f.I1(b2, bArr, i8, i2, M(t), s3Var);
            i19 = i7;
            e6Var = this;
            t7 = t;
            bArr3 = bArr;
            s3Var7 = s3Var;
            i6 = i21;
            i21 = i6;
            e6Var5 = e6Var;
            i15 = i2;
            i18 = i4;
            unsafe2 = unsafe;
            i17 = 0;
            i16 = -1;
        }
        int i33 = i21;
        Unsafe unsafe3 = unsafe2;
        if (i20 != 1048575) {
            unsafe3.putInt(t, i20, i33);
        }
        if (iI1 != i2) {
            throw zzij.d();
        }
    }

    @Override // b.i.a.f.h.l.q6
    public final void i(T t, T t2) {
        Objects.requireNonNull(t2);
        for (int i = 0; i < this.c.length; i += 3) {
            int I = I(i);
            long j = 1048575 & I;
            int i2 = this.c[i];
            switch ((I & 267386880) >>> 20) {
                case 0:
                    if (v(t2, i)) {
                        j7.d(t, j, j7.q(t2, j));
                        B(t, i);
                        break;
                    } else {
                        break;
                    }
                case 1:
                    if (v(t2, i)) {
                        j7.e.d(t, j, j7.n(t2, j));
                        B(t, i);
                        break;
                    } else {
                        break;
                    }
                case 2:
                    if (v(t2, i)) {
                        j7.e(t, j, j7.i(t2, j));
                        B(t, i);
                        break;
                    } else {
                        break;
                    }
                case 3:
                    if (v(t2, i)) {
                        j7.e(t, j, j7.i(t2, j));
                        B(t, i);
                        break;
                    } else {
                        break;
                    }
                case 4:
                    if (v(t2, i)) {
                        j7.e.e(t, j, j7.b(t2, j));
                        B(t, i);
                        break;
                    } else {
                        break;
                    }
                case 5:
                    if (v(t2, i)) {
                        j7.e(t, j, j7.i(t2, j));
                        B(t, i);
                        break;
                    } else {
                        break;
                    }
                case 6:
                    if (v(t2, i)) {
                        j7.e.e(t, j, j7.b(t2, j));
                        B(t, i);
                        break;
                    } else {
                        break;
                    }
                case 7:
                    if (v(t2, i)) {
                        j7.e.g(t, j, j7.m(t2, j));
                        B(t, i);
                        break;
                    } else {
                        break;
                    }
                case 8:
                    if (v(t2, i)) {
                        j7.f(t, j, j7.r(t2, j));
                        B(t, i);
                        break;
                    } else {
                        break;
                    }
                case 9:
                    u(t, t2, i);
                    break;
                case 10:
                    if (v(t2, i)) {
                        j7.f(t, j, j7.r(t2, j));
                        B(t, i);
                        break;
                    } else {
                        break;
                    }
                case 11:
                    if (v(t2, i)) {
                        j7.e.e(t, j, j7.b(t2, j));
                        B(t, i);
                        break;
                    } else {
                        break;
                    }
                case 12:
                    if (v(t2, i)) {
                        j7.e.e(t, j, j7.b(t2, j));
                        B(t, i);
                        break;
                    } else {
                        break;
                    }
                case 13:
                    if (v(t2, i)) {
                        j7.e.e(t, j, j7.b(t2, j));
                        B(t, i);
                        break;
                    } else {
                        break;
                    }
                case 14:
                    if (v(t2, i)) {
                        j7.e(t, j, j7.i(t2, j));
                        B(t, i);
                        break;
                    } else {
                        break;
                    }
                case 15:
                    if (v(t2, i)) {
                        j7.e.e(t, j, j7.b(t2, j));
                        B(t, i);
                        break;
                    } else {
                        break;
                    }
                case 16:
                    if (v(t2, i)) {
                        j7.e(t, j, j7.i(t2, j));
                        B(t, i);
                        break;
                    } else {
                        break;
                    }
                case 17:
                    u(t, t2, i);
                    break;
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
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
                    this.n.a(t, t2, j);
                    break;
                case 50:
                    v5 v5Var = this.q;
                    Class<?> cls = s6.a;
                    j7.f(t, j, v5Var.f(j7.r(t, j), j7.r(t2, j)));
                    break;
                case 51:
                case 52:
                case 53:
                case 54:
                case 55:
                case 56:
                case 57:
                case 58:
                case 59:
                    if (w(t2, i2, i)) {
                        j7.f(t, j, j7.r(t2, j));
                        C(t, i2, i);
                        break;
                    } else {
                        break;
                    }
                case 60:
                    E(t, t2, i);
                    break;
                case 61:
                case 62:
                case 63:
                case 64:
                case 65:
                case 66:
                case 67:
                    if (w(t2, i2, i)) {
                        j7.f(t, j, j7.r(t2, j));
                        C(t, i2, i);
                        break;
                    } else {
                        break;
                    }
                case 68:
                    E(t, t2, i);
                    break;
            }
        }
        d7<?, ?> d7Var = this.o;
        Class<?> cls2 = s6.a;
        d7Var.d(t, d7Var.g(d7Var.e(t), d7Var.e(t2)));
        if (this.h) {
            s6.i(this.p, t, t2);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public final int j(T t, byte[] bArr, int i, int i2, int i3, int i4, int i5, int i6, int i7, long j, int i8, s3 s3Var) throws IOException {
        int iN2;
        Unsafe unsafe = f1441b;
        long j2 = this.c[i8 + 2] & 1048575;
        switch (i7) {
            case 51:
                if (i5 == 1) {
                    unsafe.putObject(t, j, Double.valueOf(Double.longBitsToDouble(b.i.a.f.e.o.f.o2(bArr, i))));
                    iN2 = i + 8;
                    unsafe.putInt(t, j2, i4);
                    return iN2;
                }
                return i;
            case 52:
                if (i5 == 5) {
                    unsafe.putObject(t, j, Float.valueOf(Float.intBitsToFloat(b.i.a.f.e.o.f.N1(bArr, i))));
                    iN2 = i + 4;
                    unsafe.putInt(t, j2, i4);
                    return iN2;
                }
                return i;
            case 53:
            case 54:
                if (i5 == 0) {
                    iN2 = b.i.a.f.e.o.f.n2(bArr, i, s3Var);
                    unsafe.putObject(t, j, Long.valueOf(s3Var.f1493b));
                    unsafe.putInt(t, j2, i4);
                    return iN2;
                }
                return i;
            case 55:
            case 62:
                if (i5 == 0) {
                    iN2 = b.i.a.f.e.o.f.O1(bArr, i, s3Var);
                    unsafe.putObject(t, j, Integer.valueOf(s3Var.a));
                    unsafe.putInt(t, j2, i4);
                    return iN2;
                }
                return i;
            case 56:
            case 65:
                if (i5 == 1) {
                    unsafe.putObject(t, j, Long.valueOf(b.i.a.f.e.o.f.o2(bArr, i)));
                    iN2 = i + 8;
                    unsafe.putInt(t, j2, i4);
                    return iN2;
                }
                return i;
            case 57:
            case 64:
                if (i5 == 5) {
                    unsafe.putObject(t, j, Integer.valueOf(b.i.a.f.e.o.f.N1(bArr, i)));
                    iN2 = i + 4;
                    unsafe.putInt(t, j2, i4);
                    return iN2;
                }
                return i;
            case 58:
                if (i5 == 0) {
                    iN2 = b.i.a.f.e.o.f.n2(bArr, i, s3Var);
                    unsafe.putObject(t, j, Boolean.valueOf(s3Var.f1493b != 0));
                    unsafe.putInt(t, j2, i4);
                    return iN2;
                }
                return i;
            case 59:
                if (i5 == 2) {
                    int iO1 = b.i.a.f.e.o.f.O1(bArr, i, s3Var);
                    int i9 = s3Var.a;
                    if (i9 == 0) {
                        unsafe.putObject(t, j, "");
                    } else {
                        if ((i6 & 536870912) != 0 && !k7.b(bArr, iO1, iO1 + i9)) {
                            throw zzij.e();
                        }
                        unsafe.putObject(t, j, new String(bArr, iO1, i9, w4.a));
                        iO1 += i9;
                    }
                    unsafe.putInt(t, j2, i4);
                    return iO1;
                }
                return i;
            case 60:
                if (i5 == 2) {
                    int iM1 = b.i.a.f.e.o.f.M1(o(i8), bArr, i, i2, s3Var);
                    Object object = unsafe.getInt(t, j2) == i4 ? unsafe.getObject(t, j) : null;
                    if (object == null) {
                        unsafe.putObject(t, j, s3Var.c);
                    } else {
                        unsafe.putObject(t, j, w4.c(object, s3Var.c));
                    }
                    unsafe.putInt(t, j2, i4);
                    return iM1;
                }
                return i;
            case 61:
                if (i5 == 2) {
                    iN2 = b.i.a.f.e.o.f.v2(bArr, i, s3Var);
                    unsafe.putObject(t, j, s3Var.c);
                    unsafe.putInt(t, j2, i4);
                    return iN2;
                }
                return i;
            case 63:
                if (i5 == 0) {
                    int iO12 = b.i.a.f.e.o.f.O1(bArr, i, s3Var);
                    int i10 = s3Var.a;
                    a5 a5Var = (a5) this.d[((i8 / 3) << 1) + 1];
                    if (a5Var != null && !a5Var.f(i10)) {
                        M(t).a(i3, Long.valueOf(i10));
                        return iO12;
                    }
                    unsafe.putObject(t, j, Integer.valueOf(i10));
                    iN2 = iO12;
                    unsafe.putInt(t, j2, i4);
                    return iN2;
                }
                return i;
            case 66:
                if (i5 == 0) {
                    iN2 = b.i.a.f.e.o.f.O1(bArr, i, s3Var);
                    unsafe.putObject(t, j, Integer.valueOf(d4.b(s3Var.a)));
                    unsafe.putInt(t, j2, i4);
                    return iN2;
                }
                return i;
            case 67:
                if (i5 == 0) {
                    iN2 = b.i.a.f.e.o.f.n2(bArr, i, s3Var);
                    unsafe.putObject(t, j, Long.valueOf(d4.a(s3Var.f1493b)));
                    unsafe.putInt(t, j2, i4);
                    return iN2;
                }
                return i;
            case 68:
                if (i5 == 3) {
                    iN2 = b.i.a.f.e.o.f.L1(o(i8), bArr, i, i2, (i3 & (-8)) | 4, s3Var);
                    Object object2 = unsafe.getInt(t, j2) == i4 ? unsafe.getObject(t, j) : null;
                    if (object2 == null) {
                        unsafe.putObject(t, j, s3Var.c);
                    } else {
                        unsafe.putObject(t, j, w4.c(object2, s3Var.c));
                    }
                    unsafe.putInt(t, j2, i4);
                    return iN2;
                }
                return i;
            default:
                return i;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final int k(T t, byte[] bArr, int i, int i2, int i3, int i4, int i5, int i6, long j, int i7, long j2, s3 s3Var) throws IOException {
        int iH1;
        int iO1 = i;
        Unsafe unsafe = f1441b;
        b5 b5VarF = (b5) unsafe.getObject(t, j2);
        if (!b5VarF.a()) {
            int size = b5VarF.size();
            b5VarF = b5VarF.f(size == 0 ? 10 : size << 1);
            unsafe.putObject(t, j2, b5VarF);
        }
        switch (i7) {
            case 18:
            case 35:
                if (i5 == 2) {
                    f4 f4Var = (f4) b5VarF;
                    int iO12 = b.i.a.f.e.o.f.O1(bArr, iO1, s3Var);
                    int i8 = s3Var.a + iO12;
                    while (iO12 < i8) {
                        f4Var.d(Double.longBitsToDouble(b.i.a.f.e.o.f.o2(bArr, iO12)));
                        iO12 += 8;
                    }
                    if (iO12 == i8) {
                        return iO12;
                    }
                    throw zzij.a();
                }
                if (i5 == 1) {
                    f4 f4Var2 = (f4) b5VarF;
                    f4Var2.d(Double.longBitsToDouble(b.i.a.f.e.o.f.o2(bArr, i)));
                    while (true) {
                        int i9 = iO1 + 8;
                        if (i9 >= i2) {
                            return i9;
                        }
                        iO1 = b.i.a.f.e.o.f.O1(bArr, i9, s3Var);
                        if (i3 != s3Var.a) {
                            return i9;
                        }
                        f4Var2.d(Double.longBitsToDouble(b.i.a.f.e.o.f.o2(bArr, iO1)));
                    }
                }
                break;
            case 19:
            case 36:
                if (i5 == 2) {
                    t4 t4Var = (t4) b5VarF;
                    int iO13 = b.i.a.f.e.o.f.O1(bArr, iO1, s3Var);
                    int i10 = s3Var.a + iO13;
                    while (iO13 < i10) {
                        t4Var.d(Float.intBitsToFloat(b.i.a.f.e.o.f.N1(bArr, iO13)));
                        iO13 += 4;
                    }
                    if (iO13 == i10) {
                        return iO13;
                    }
                    throw zzij.a();
                }
                if (i5 == 5) {
                    t4 t4Var2 = (t4) b5VarF;
                    t4Var2.d(Float.intBitsToFloat(b.i.a.f.e.o.f.N1(bArr, i)));
                    while (true) {
                        int i11 = iO1 + 4;
                        if (i11 >= i2) {
                            return i11;
                        }
                        iO1 = b.i.a.f.e.o.f.O1(bArr, i11, s3Var);
                        if (i3 != s3Var.a) {
                            return i11;
                        }
                        t4Var2.d(Float.intBitsToFloat(b.i.a.f.e.o.f.N1(bArr, iO1)));
                    }
                }
                break;
            case 20:
            case 21:
            case 37:
            case 38:
                if (i5 == 2) {
                    q5 q5Var = (q5) b5VarF;
                    int iO14 = b.i.a.f.e.o.f.O1(bArr, iO1, s3Var);
                    int i12 = s3Var.a + iO14;
                    while (iO14 < i12) {
                        iO14 = b.i.a.f.e.o.f.n2(bArr, iO14, s3Var);
                        q5Var.d(s3Var.f1493b);
                    }
                    if (iO14 == i12) {
                        return iO14;
                    }
                    throw zzij.a();
                }
                if (i5 == 0) {
                    q5 q5Var2 = (q5) b5VarF;
                    int iN2 = b.i.a.f.e.o.f.n2(bArr, iO1, s3Var);
                    q5Var2.d(s3Var.f1493b);
                    while (iN2 < i2) {
                        int iO15 = b.i.a.f.e.o.f.O1(bArr, iN2, s3Var);
                        if (i3 != s3Var.a) {
                            return iN2;
                        }
                        iN2 = b.i.a.f.e.o.f.n2(bArr, iO15, s3Var);
                        q5Var2.d(s3Var.f1493b);
                    }
                    return iN2;
                }
                break;
            case 22:
            case 29:
            case 39:
            case 43:
                if (i5 == 2) {
                    return b.i.a.f.e.o.f.P1(bArr, iO1, b5VarF, s3Var);
                }
                if (i5 == 0) {
                    return b.i.a.f.e.o.f.H1(i3, bArr, i, i2, b5VarF, s3Var);
                }
                break;
            case 23:
            case 32:
            case 40:
            case 46:
                if (i5 == 2) {
                    q5 q5Var3 = (q5) b5VarF;
                    int iO16 = b.i.a.f.e.o.f.O1(bArr, iO1, s3Var);
                    int i13 = s3Var.a + iO16;
                    while (iO16 < i13) {
                        q5Var3.d(b.i.a.f.e.o.f.o2(bArr, iO16));
                        iO16 += 8;
                    }
                    if (iO16 == i13) {
                        return iO16;
                    }
                    throw zzij.a();
                }
                if (i5 == 1) {
                    q5 q5Var4 = (q5) b5VarF;
                    q5Var4.d(b.i.a.f.e.o.f.o2(bArr, i));
                    while (true) {
                        int i14 = iO1 + 8;
                        if (i14 >= i2) {
                            return i14;
                        }
                        iO1 = b.i.a.f.e.o.f.O1(bArr, i14, s3Var);
                        if (i3 != s3Var.a) {
                            return i14;
                        }
                        q5Var4.d(b.i.a.f.e.o.f.o2(bArr, iO1));
                    }
                }
                break;
            case 24:
            case 31:
            case 41:
            case 45:
                if (i5 == 2) {
                    x4 x4Var = (x4) b5VarF;
                    int iO17 = b.i.a.f.e.o.f.O1(bArr, iO1, s3Var);
                    int i15 = s3Var.a + iO17;
                    while (iO17 < i15) {
                        x4Var.g(b.i.a.f.e.o.f.N1(bArr, iO17));
                        iO17 += 4;
                    }
                    if (iO17 == i15) {
                        return iO17;
                    }
                    throw zzij.a();
                }
                if (i5 == 5) {
                    x4 x4Var2 = (x4) b5VarF;
                    x4Var2.g(b.i.a.f.e.o.f.N1(bArr, i));
                    while (true) {
                        int i16 = iO1 + 4;
                        if (i16 >= i2) {
                            return i16;
                        }
                        iO1 = b.i.a.f.e.o.f.O1(bArr, i16, s3Var);
                        if (i3 != s3Var.a) {
                            return i16;
                        }
                        x4Var2.g(b.i.a.f.e.o.f.N1(bArr, iO1));
                    }
                }
                break;
            case 25:
            case 42:
                if (i5 == 2) {
                    r3 r3Var = (r3) b5VarF;
                    int iO18 = b.i.a.f.e.o.f.O1(bArr, iO1, s3Var);
                    int i17 = s3Var.a + iO18;
                    while (iO18 < i17) {
                        iO18 = b.i.a.f.e.o.f.n2(bArr, iO18, s3Var);
                        r3Var.d(s3Var.f1493b != 0);
                    }
                    if (iO18 == i17) {
                        return iO18;
                    }
                    throw zzij.a();
                }
                if (i5 == 0) {
                    r3 r3Var2 = (r3) b5VarF;
                    int iN22 = b.i.a.f.e.o.f.n2(bArr, iO1, s3Var);
                    r3Var2.d(s3Var.f1493b != 0);
                    while (iN22 < i2) {
                        int iO19 = b.i.a.f.e.o.f.O1(bArr, iN22, s3Var);
                        if (i3 != s3Var.a) {
                            return iN22;
                        }
                        iN22 = b.i.a.f.e.o.f.n2(bArr, iO19, s3Var);
                        r3Var2.d(s3Var.f1493b != 0);
                    }
                    return iN22;
                }
                break;
            case 26:
                if (i5 == 2) {
                    if ((j & Permission.MANAGE_WEBHOOKS) != 0) {
                        iO1 = b.i.a.f.e.o.f.O1(bArr, iO1, s3Var);
                        int i18 = s3Var.a;
                        if (i18 < 0) {
                            throw zzij.b();
                        }
                        if (i18 == 0) {
                            b5VarF.add("");
                        } else {
                            int i19 = iO1 + i18;
                            if (!k7.b(bArr, iO1, i19)) {
                                throw zzij.e();
                            }
                            b5VarF.add(new String(bArr, iO1, i18, w4.a));
                            iO1 = i19;
                        }
                        while (iO1 < i2) {
                            int iO110 = b.i.a.f.e.o.f.O1(bArr, iO1, s3Var);
                            if (i3 != s3Var.a) {
                                break;
                            } else {
                                iO1 = b.i.a.f.e.o.f.O1(bArr, iO110, s3Var);
                                int i20 = s3Var.a;
                                if (i20 < 0) {
                                    throw zzij.b();
                                }
                                if (i20 == 0) {
                                    b5VarF.add("");
                                } else {
                                    int i21 = iO1 + i20;
                                    if (!k7.b(bArr, iO1, i21)) {
                                        throw zzij.e();
                                    }
                                    b5VarF.add(new String(bArr, iO1, i20, w4.a));
                                    iO1 = i21;
                                }
                            }
                        }
                        break;
                    } else {
                        iO1 = b.i.a.f.e.o.f.O1(bArr, iO1, s3Var);
                        int i22 = s3Var.a;
                        if (i22 < 0) {
                            throw zzij.b();
                        }
                        if (i22 == 0) {
                            b5VarF.add("");
                        } else {
                            b5VarF.add(new String(bArr, iO1, i22, w4.a));
                            iO1 += i22;
                        }
                        while (iO1 < i2) {
                            int iO111 = b.i.a.f.e.o.f.O1(bArr, iO1, s3Var);
                            if (i3 != s3Var.a) {
                                break;
                            } else {
                                iO1 = b.i.a.f.e.o.f.O1(bArr, iO111, s3Var);
                                int i23 = s3Var.a;
                                if (i23 < 0) {
                                    throw zzij.b();
                                }
                                if (i23 == 0) {
                                    b5VarF.add("");
                                } else {
                                    b5VarF.add(new String(bArr, iO1, i23, w4.a));
                                    iO1 += i23;
                                }
                            }
                        }
                        break;
                    }
                }
                break;
            case 27:
                if (i5 == 2) {
                    return b.i.a.f.e.o.f.K1(o(i6), i3, bArr, i, i2, b5VarF, s3Var);
                }
                break;
            case 28:
                if (i5 == 2) {
                    int iO112 = b.i.a.f.e.o.f.O1(bArr, iO1, s3Var);
                    int i24 = s3Var.a;
                    if (i24 < 0) {
                        throw zzij.b();
                    }
                    if (i24 > bArr.length - iO112) {
                        throw zzij.a();
                    }
                    if (i24 == 0) {
                        b5VarF.add(t3.j);
                    } else {
                        b5VarF.add(t3.h(bArr, iO112, i24));
                        iO112 += i24;
                    }
                    while (iO112 < i2) {
                        int iO113 = b.i.a.f.e.o.f.O1(bArr, iO112, s3Var);
                        if (i3 != s3Var.a) {
                            return iO112;
                        }
                        iO112 = b.i.a.f.e.o.f.O1(bArr, iO113, s3Var);
                        int i25 = s3Var.a;
                        if (i25 < 0) {
                            throw zzij.b();
                        }
                        if (i25 > bArr.length - iO112) {
                            throw zzij.a();
                        }
                        if (i25 == 0) {
                            b5VarF.add(t3.j);
                        } else {
                            b5VarF.add(t3.h(bArr, iO112, i25));
                            iO112 += i25;
                        }
                    }
                    return iO112;
                }
                break;
            case 30:
            case 44:
                if (i5 == 2) {
                    iH1 = b.i.a.f.e.o.f.P1(bArr, iO1, b5VarF, s3Var);
                } else if (i5 == 0) {
                    iH1 = b.i.a.f.e.o.f.H1(i3, bArr, i, i2, b5VarF, s3Var);
                }
                u4 u4Var = (u4) t;
                Object objA = u4Var.zzb;
                if (objA == c7.a) {
                    objA = null;
                }
                a5 a5Var = (a5) this.d[((i6 / 3) << 1) + 1];
                d7<?, ?> d7Var = this.o;
                Class<?> cls = s6.a;
                if (a5Var != null) {
                    if (b5VarF instanceof RandomAccess) {
                        int size2 = b5VarF.size();
                        int i26 = 0;
                        for (int i27 = 0; i27 < size2; i27++) {
                            int iIntValue = ((Integer) b5VarF.get(i27)).intValue();
                            if (a5Var.f(iIntValue)) {
                                if (i27 != i26) {
                                    b5VarF.set(i26, Integer.valueOf(iIntValue));
                                }
                                i26++;
                            } else {
                                if (objA == null) {
                                    objA = d7Var.a();
                                }
                                d7Var.b(objA, i4, iIntValue);
                            }
                        }
                        if (i26 != size2) {
                            b5VarF.subList(i26, size2).clear();
                        }
                    } else {
                        Iterator<E> it = b5VarF.iterator();
                        while (it.hasNext()) {
                            int iIntValue2 = ((Integer) it.next()).intValue();
                            if (!a5Var.f(iIntValue2)) {
                                if (objA == null) {
                                    objA = d7Var.a();
                                }
                                d7Var.b(objA, i4, iIntValue2);
                                it.remove();
                            }
                        }
                    }
                }
                c7 c7Var = (c7) objA;
                if (c7Var != null) {
                    u4Var.zzb = c7Var;
                }
                return iH1;
            case 33:
            case 47:
                if (i5 == 2) {
                    x4 x4Var3 = (x4) b5VarF;
                    int iO114 = b.i.a.f.e.o.f.O1(bArr, iO1, s3Var);
                    int i28 = s3Var.a + iO114;
                    while (iO114 < i28) {
                        iO114 = b.i.a.f.e.o.f.O1(bArr, iO114, s3Var);
                        x4Var3.g(d4.b(s3Var.a));
                    }
                    if (iO114 == i28) {
                        return iO114;
                    }
                    throw zzij.a();
                }
                if (i5 == 0) {
                    x4 x4Var4 = (x4) b5VarF;
                    int iO115 = b.i.a.f.e.o.f.O1(bArr, iO1, s3Var);
                    x4Var4.g(d4.b(s3Var.a));
                    while (iO115 < i2) {
                        int iO116 = b.i.a.f.e.o.f.O1(bArr, iO115, s3Var);
                        if (i3 != s3Var.a) {
                            return iO115;
                        }
                        iO115 = b.i.a.f.e.o.f.O1(bArr, iO116, s3Var);
                        x4Var4.g(d4.b(s3Var.a));
                    }
                    return iO115;
                }
                break;
            case 34:
            case 48:
                if (i5 == 2) {
                    q5 q5Var5 = (q5) b5VarF;
                    int iO117 = b.i.a.f.e.o.f.O1(bArr, iO1, s3Var);
                    int i29 = s3Var.a + iO117;
                    while (iO117 < i29) {
                        iO117 = b.i.a.f.e.o.f.n2(bArr, iO117, s3Var);
                        q5Var5.d(d4.a(s3Var.f1493b));
                    }
                    if (iO117 == i29) {
                        return iO117;
                    }
                    throw zzij.a();
                }
                if (i5 == 0) {
                    q5 q5Var6 = (q5) b5VarF;
                    int iN23 = b.i.a.f.e.o.f.n2(bArr, iO1, s3Var);
                    q5Var6.d(d4.a(s3Var.f1493b));
                    while (iN23 < i2) {
                        int iO118 = b.i.a.f.e.o.f.O1(bArr, iN23, s3Var);
                        if (i3 != s3Var.a) {
                            return iN23;
                        }
                        iN23 = b.i.a.f.e.o.f.n2(bArr, iO118, s3Var);
                        q5Var6.d(d4.a(s3Var.f1493b));
                    }
                    return iN23;
                }
                break;
            case 49:
                if (i5 == 3) {
                    q6 q6VarO = o(i6);
                    int i30 = (i3 & (-8)) | 4;
                    iO1 = b.i.a.f.e.o.f.L1(q6VarO, bArr, i, i2, i30, s3Var);
                    b5VarF.add(s3Var.c);
                    while (iO1 < i2) {
                        int iO119 = b.i.a.f.e.o.f.O1(bArr, iO1, s3Var);
                        if (i3 != s3Var.a) {
                            break;
                        } else {
                            iO1 = b.i.a.f.e.o.f.L1(q6VarO, bArr, iO119, i2, i30, s3Var);
                            b5VarF.add(s3Var.c);
                        }
                    }
                    break;
                }
                break;
        }
        return iO1;
    }

    public final <K, V> int l(T t, byte[] bArr, int i, int i2, int i3, long j, s3 s3Var) throws IOException {
        Unsafe unsafe = f1441b;
        Object obj = this.d[(i3 / 3) << 1];
        Object object = unsafe.getObject(t, j);
        if (this.q.d(object)) {
            Object objH = this.q.h(obj);
            this.q.f(objH, object);
            unsafe.putObject(t, j, objH);
            object = objH;
        }
        t5<?, ?> t5VarG = this.q.g(obj);
        this.q.b(object);
        int iO1 = b.i.a.f.e.o.f.O1(bArr, i, s3Var);
        int i4 = s3Var.a;
        if (i4 < 0 || i4 > i2 - iO1) {
            throw zzij.a();
        }
        Objects.requireNonNull(t5VarG);
        throw null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:170:0x04fe, code lost:
    
        if (r5 == 1048575) goto L172;
     */
    /* JADX WARN: Code restructure failed: missing block: B:171:0x0500, code lost:
    
        r28.putInt(r11, r5, r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:172:0x0506, code lost:
    
        r3 = r7.k;
     */
    /* JADX WARN: Code restructure failed: missing block: B:174:0x050a, code lost:
    
        if (r3 >= r7.l) goto L248;
     */
    /* JADX WARN: Code restructure failed: missing block: B:175:0x050c, code lost:
    
        r4 = r7.j[r3];
        r5 = r7.o;
        r8 = r7.c[r4];
        r6 = b.i.a.f.h.l.j7.r(r11, r6[r4 + 1] & 1048575);
     */
    /* JADX WARN: Code restructure failed: missing block: B:176:0x0520, code lost:
    
        if (r6 != null) goto L178;
     */
    /* JADX WARN: Code restructure failed: missing block: B:178:0x0523, code lost:
    
        r4 = (r4 / 3) << 1;
        r8 = (b.i.a.f.h.l.a5) r7.d[r4 + 1];
     */
    /* JADX WARN: Code restructure failed: missing block: B:179:0x052f, code lost:
    
        if (r8 != null) goto L181;
     */
    /* JADX WARN: Code restructure failed: missing block: B:181:0x0532, code lost:
    
        r6 = r7.q.b(r6);
        r7.q.g(r7.d[r4]);
        r4 = r6.entrySet().iterator();
     */
    /* JADX WARN: Code restructure failed: missing block: B:183:0x054d, code lost:
    
        if (r4.hasNext() == false) goto L249;
     */
    /* JADX WARN: Code restructure failed: missing block: B:184:0x054f, code lost:
    
        r6 = r4.next();
     */
    /* JADX WARN: Code restructure failed: missing block: B:185:0x0563, code lost:
    
        if (r8.f(((java.lang.Integer) r6.getValue()).intValue()) == false) goto L247;
     */
    /* JADX WARN: Code restructure failed: missing block: B:187:0x0566, code lost:
    
        r5.a();
        r6.getKey();
        r6.getValue();
        java.util.Objects.requireNonNull(null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:188:0x0572, code lost:
    
        throw null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:189:0x0573, code lost:
    
        r3 = r3 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:190:0x0576, code lost:
    
        if (r1 != 0) goto L196;
     */
    /* JADX WARN: Code restructure failed: missing block: B:192:0x057a, code lost:
    
        if (r0 != r34) goto L194;
     */
    /* JADX WARN: Code restructure failed: missing block: B:195:0x0581, code lost:
    
        throw com.google.android.gms.internal.measurement.zzij.d();
     */
    /* JADX WARN: Code restructure failed: missing block: B:197:0x0584, code lost:
    
        if (r0 > r34) goto L200;
     */
    /* JADX WARN: Code restructure failed: missing block: B:198:0x0586, code lost:
    
        if (r10 != r1) goto L200;
     */
    /* JADX WARN: Code restructure failed: missing block: B:199:0x0588, code lost:
    
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:201:0x058d, code lost:
    
        throw com.google.android.gms.internal.measurement.zzij.d();
     */
    /* JADX WARN: Multi-variable type inference failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final int m(T t, byte[] bArr, int i, int i2, int i3, s3 s3Var) throws IOException {
        Unsafe unsafe;
        Object obj;
        e6<T> e6Var;
        int i4;
        int i5;
        int iZ;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        s3 s3Var2;
        Object obj2;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        long j;
        int i19;
        int i20;
        int i21;
        int iN2;
        int i22;
        int i23;
        int i24;
        int i25;
        Object obj3;
        e6<T> e6Var2 = this;
        Object obj4 = t;
        byte[] bArr2 = bArr;
        int i26 = i2;
        s3 s3Var3 = s3Var;
        Unsafe unsafe2 = f1441b;
        int iI1 = i;
        int i27 = i3;
        byte[] bArr3 = bArr2;
        int i28 = -1;
        int i29 = 0;
        int i30 = 1048575;
        int i31 = 0;
        int i32 = 0;
        while (true) {
            if (iI1 < i26) {
                int iJ1 = iI1 + 1;
                int i33 = bArr3[iI1];
                if (i33 < 0) {
                    iJ1 = b.i.a.f.e.o.f.J1(i33, bArr3, iJ1, s3Var3);
                    i33 = s3Var3.a;
                }
                int i34 = i33 >>> 3;
                int i35 = i33 & 7;
                int i36 = i33;
                if (i34 > i28) {
                    iZ = (i34 < e6Var2.e || i34 > e6Var2.f) ? -1 : e6Var2.z(i34, i29 / 3);
                    i5 = -1;
                } else if (i34 < e6Var2.e || i34 > e6Var2.f) {
                    i5 = -1;
                    iZ = -1;
                } else {
                    iZ = e6Var2.z(i34, 0);
                    i5 = -1;
                }
                if (iZ == i5) {
                    i6 = i30;
                    i7 = i31;
                    i8 = i34;
                    unsafe = unsafe2;
                    i9 = iJ1;
                    i4 = i36;
                    i10 = 0;
                    i11 = i27;
                } else {
                    int[] iArr = e6Var2.c;
                    byte[] bArr4 = bArr3;
                    int i37 = iArr[iZ + 1];
                    int i38 = (i37 & 267386880) >>> 20;
                    long j2 = i37 & 1048575;
                    if (i38 <= 17) {
                        int i39 = iArr[iZ + 2];
                        int i40 = 1 << (i39 >>> 20);
                        int i41 = i39 & 1048575;
                        if (i41 != i30) {
                            if (i30 != 1048575) {
                                long j3 = i30;
                                obj3 = t;
                                j = j2;
                                unsafe2.putInt(obj3, j3, i31);
                            } else {
                                obj3 = t;
                                j = j2;
                            }
                            obj4 = obj3;
                            i7 = unsafe2.getInt(obj3, i41);
                            i19 = i41;
                        } else {
                            obj4 = t;
                            j = j2;
                            i7 = i31;
                            i19 = i30;
                        }
                        switch (i38) {
                            case 0:
                                i12 = i34;
                                i20 = i36;
                                i14 = iZ;
                                long j4 = j;
                                if (i35 == 1) {
                                    j7.d(obj4, j4, Double.longBitsToDouble(b.i.a.f.e.o.f.o2(bArr2, iJ1)));
                                    iI1 = iJ1 + 8;
                                    i7 |= i40;
                                    i30 = i19;
                                    bArr3 = bArr2;
                                    i31 = i7;
                                    i13 = i20;
                                    bArr2 = bArr;
                                    i27 = i3;
                                    s3Var3 = s3Var;
                                    i29 = i14;
                                    i32 = i13;
                                    i28 = i12;
                                    i26 = i2;
                                    break;
                                }
                                i6 = i19;
                                unsafe = unsafe2;
                                i9 = iJ1;
                                i8 = i12;
                                i11 = i3;
                                i4 = i20;
                                i10 = i14;
                                break;
                            case 1:
                                i12 = i34;
                                i20 = i36;
                                i14 = iZ;
                                long j5 = j;
                                if (i35 == 5) {
                                    j7.e.d(obj4, j5, Float.intBitsToFloat(b.i.a.f.e.o.f.N1(bArr2, iJ1)));
                                    iI1 = iJ1 + 4;
                                    i7 |= i40;
                                    i30 = i19;
                                    bArr3 = bArr2;
                                    i31 = i7;
                                    i13 = i20;
                                    bArr2 = bArr;
                                    i27 = i3;
                                    s3Var3 = s3Var;
                                    i29 = i14;
                                    i32 = i13;
                                    i28 = i12;
                                    i26 = i2;
                                    break;
                                }
                                i6 = i19;
                                unsafe = unsafe2;
                                i9 = iJ1;
                                i8 = i12;
                                i11 = i3;
                                i4 = i20;
                                i10 = i14;
                                break;
                            case 2:
                            case 3:
                                i12 = i34;
                                i21 = i36;
                                i14 = iZ;
                                long j6 = j;
                                if (i35 == 0) {
                                    iN2 = b.i.a.f.e.o.f.n2(bArr2, iJ1, s3Var3);
                                    i22 = i21;
                                    unsafe2.putLong(t, j6, s3Var3.f1493b);
                                    i7 |= i40;
                                    iI1 = iN2;
                                    i20 = i22;
                                    i30 = i19;
                                    bArr3 = bArr2;
                                    i31 = i7;
                                    i13 = i20;
                                    bArr2 = bArr;
                                    i27 = i3;
                                    s3Var3 = s3Var;
                                    i29 = i14;
                                    i32 = i13;
                                    i28 = i12;
                                    i26 = i2;
                                    break;
                                }
                                i20 = i21;
                                i6 = i19;
                                unsafe = unsafe2;
                                i9 = iJ1;
                                i8 = i12;
                                i11 = i3;
                                i4 = i20;
                                i10 = i14;
                                break;
                            case 4:
                            case 11:
                                i12 = i34;
                                i21 = i36;
                                i14 = iZ;
                                long j7 = j;
                                if (i35 == 0) {
                                    iI1 = b.i.a.f.e.o.f.O1(bArr2, iJ1, s3Var3);
                                    unsafe2.putInt(obj4, j7, s3Var3.a);
                                    i20 = i21;
                                    i7 |= i40;
                                    i30 = i19;
                                    bArr3 = bArr2;
                                    i31 = i7;
                                    i13 = i20;
                                    bArr2 = bArr;
                                    i27 = i3;
                                    s3Var3 = s3Var;
                                    i29 = i14;
                                    i32 = i13;
                                    i28 = i12;
                                    i26 = i2;
                                    break;
                                }
                                i20 = i21;
                                i6 = i19;
                                unsafe = unsafe2;
                                i9 = iJ1;
                                i8 = i12;
                                i11 = i3;
                                i4 = i20;
                                i10 = i14;
                                break;
                            case 5:
                            case 14:
                                i12 = i34;
                                i23 = i36;
                                i14 = iZ;
                                long j8 = j;
                                if (i35 == 1) {
                                    unsafe2.putLong(t, j8, b.i.a.f.e.o.f.o2(bArr2, iJ1));
                                    i20 = i23;
                                    iI1 = iJ1 + 8;
                                    i7 |= i40;
                                    i30 = i19;
                                    bArr3 = bArr2;
                                    i31 = i7;
                                    i13 = i20;
                                    bArr2 = bArr;
                                    i27 = i3;
                                    s3Var3 = s3Var;
                                    i29 = i14;
                                    i32 = i13;
                                    i28 = i12;
                                    i26 = i2;
                                    break;
                                }
                                i20 = i23;
                                i6 = i19;
                                unsafe = unsafe2;
                                i9 = iJ1;
                                i8 = i12;
                                i11 = i3;
                                i4 = i20;
                                i10 = i14;
                                break;
                            case 6:
                            case 13:
                                i12 = i34;
                                i23 = i36;
                                i14 = iZ;
                                long j9 = j;
                                if (i35 != 5) {
                                    i20 = i23;
                                    i6 = i19;
                                    unsafe = unsafe2;
                                    i9 = iJ1;
                                    i8 = i12;
                                    i11 = i3;
                                    i4 = i20;
                                    i10 = i14;
                                    break;
                                } else {
                                    unsafe2.putInt(obj4, j9, b.i.a.f.e.o.f.N1(bArr2, iJ1));
                                    iI1 = iJ1 + 4;
                                    i25 = i7 | i40;
                                    i26 = i2;
                                    i32 = i23;
                                    i30 = i19;
                                    i29 = i14;
                                    bArr3 = bArr2;
                                    i28 = i12;
                                    i31 = i25;
                                    i27 = i3;
                                    break;
                                }
                            case 7:
                                i12 = i34;
                                i23 = i36;
                                i14 = iZ;
                                long j10 = j;
                                if (i35 != 0) {
                                    i20 = i23;
                                    i6 = i19;
                                    unsafe = unsafe2;
                                    i9 = iJ1;
                                    i8 = i12;
                                    i11 = i3;
                                    i4 = i20;
                                    i10 = i14;
                                    break;
                                } else {
                                    int iN22 = b.i.a.f.e.o.f.n2(bArr2, iJ1, s3Var3);
                                    j7.e.g(obj4, j10, s3Var3.f1493b != 0);
                                    iI1 = iN22;
                                    i25 = i7 | i40;
                                    i26 = i2;
                                    i32 = i23;
                                    i30 = i19;
                                    i29 = i14;
                                    bArr3 = bArr2;
                                    i28 = i12;
                                    i31 = i25;
                                    i27 = i3;
                                    break;
                                }
                            case 8:
                                i12 = i34;
                                i23 = i36;
                                i14 = iZ;
                                long j11 = j;
                                if (i35 != 2) {
                                    i20 = i23;
                                    i6 = i19;
                                    unsafe = unsafe2;
                                    i9 = iJ1;
                                    i8 = i12;
                                    i11 = i3;
                                    i4 = i20;
                                    i10 = i14;
                                    break;
                                } else {
                                    iI1 = (536870912 & i37) == 0 ? b.i.a.f.e.o.f.r2(bArr2, iJ1, s3Var3) : b.i.a.f.e.o.f.t2(bArr2, iJ1, s3Var3);
                                    unsafe2.putObject(obj4, j11, s3Var3.c);
                                    i25 = i7 | i40;
                                    i26 = i2;
                                    i32 = i23;
                                    i30 = i19;
                                    i29 = i14;
                                    bArr3 = bArr2;
                                    i28 = i12;
                                    i31 = i25;
                                    i27 = i3;
                                    break;
                                }
                            case 9:
                                i12 = i34;
                                i23 = i36;
                                i14 = iZ;
                                long j12 = j;
                                if (i35 != 2) {
                                    i20 = i23;
                                    i6 = i19;
                                    unsafe = unsafe2;
                                    i9 = iJ1;
                                    i8 = i12;
                                    i11 = i3;
                                    i4 = i20;
                                    i10 = i14;
                                    break;
                                } else {
                                    iI1 = b.i.a.f.e.o.f.M1(e6Var2.o(i14), bArr2, iJ1, i2, s3Var3);
                                    if ((i7 & i40) == 0) {
                                        unsafe2.putObject(obj4, j12, s3Var3.c);
                                    } else {
                                        unsafe2.putObject(obj4, j12, w4.c(unsafe2.getObject(obj4, j12), s3Var3.c));
                                    }
                                    i25 = i7 | i40;
                                    i26 = i2;
                                    i32 = i23;
                                    i30 = i19;
                                    i29 = i14;
                                    bArr3 = bArr2;
                                    i28 = i12;
                                    i31 = i25;
                                    i27 = i3;
                                    break;
                                }
                            case 10:
                                i12 = i34;
                                i24 = i36;
                                i14 = iZ;
                                long j13 = j;
                                if (i35 == 2) {
                                    iI1 = b.i.a.f.e.o.f.v2(bArr2, iJ1, s3Var3);
                                    unsafe2.putObject(obj4, j13, s3Var3.c);
                                    i20 = i24;
                                    i7 |= i40;
                                    i30 = i19;
                                    bArr3 = bArr2;
                                    i31 = i7;
                                    i13 = i20;
                                    bArr2 = bArr;
                                    i27 = i3;
                                    s3Var3 = s3Var;
                                    i29 = i14;
                                    i32 = i13;
                                    i28 = i12;
                                    i26 = i2;
                                    break;
                                }
                                i20 = i24;
                                i6 = i19;
                                unsafe = unsafe2;
                                i9 = iJ1;
                                i8 = i12;
                                i11 = i3;
                                i4 = i20;
                                i10 = i14;
                                break;
                            case 12:
                                i12 = i34;
                                i24 = i36;
                                i14 = iZ;
                                long j14 = j;
                                if (i35 == 0) {
                                    iI1 = b.i.a.f.e.o.f.O1(bArr2, iJ1, s3Var3);
                                    int i42 = s3Var3.a;
                                    a5 a5VarG = e6Var2.G(i14);
                                    if (a5VarG == null || a5VarG.f(i42)) {
                                        unsafe2.putInt(obj4, j14, i42);
                                        i20 = i24;
                                        i7 |= i40;
                                        i30 = i19;
                                        bArr3 = bArr2;
                                        i31 = i7;
                                        i13 = i20;
                                        bArr2 = bArr;
                                        i27 = i3;
                                        s3Var3 = s3Var;
                                        i29 = i14;
                                        i32 = i13;
                                        i28 = i12;
                                        i26 = i2;
                                        break;
                                    } else {
                                        M(t).a(i24, Long.valueOf(i42));
                                        i20 = i24;
                                        i30 = i19;
                                        bArr3 = bArr2;
                                        i31 = i7;
                                        i13 = i20;
                                        bArr2 = bArr;
                                        i27 = i3;
                                        s3Var3 = s3Var;
                                        i29 = i14;
                                        i32 = i13;
                                        i28 = i12;
                                        i26 = i2;
                                    }
                                }
                                i20 = i24;
                                i6 = i19;
                                unsafe = unsafe2;
                                i9 = iJ1;
                                i8 = i12;
                                i11 = i3;
                                i4 = i20;
                                i10 = i14;
                                break;
                            case 15:
                                i12 = i34;
                                i24 = i36;
                                i14 = iZ;
                                long j15 = j;
                                if (i35 == 0) {
                                    iI1 = b.i.a.f.e.o.f.O1(bArr2, iJ1, s3Var3);
                                    unsafe2.putInt(obj4, j15, d4.b(s3Var3.a));
                                    i20 = i24;
                                    i7 |= i40;
                                    i30 = i19;
                                    bArr3 = bArr2;
                                    i31 = i7;
                                    i13 = i20;
                                    bArr2 = bArr;
                                    i27 = i3;
                                    s3Var3 = s3Var;
                                    i29 = i14;
                                    i32 = i13;
                                    i28 = i12;
                                    i26 = i2;
                                    break;
                                }
                                i20 = i24;
                                i6 = i19;
                                unsafe = unsafe2;
                                i9 = iJ1;
                                i8 = i12;
                                i11 = i3;
                                i4 = i20;
                                i10 = i14;
                                break;
                            case 16:
                                int i43 = iZ;
                                i24 = i36;
                                long j16 = j;
                                if (i35 != 0) {
                                    i12 = i34;
                                    i14 = i43;
                                    i20 = i24;
                                    i6 = i19;
                                    unsafe = unsafe2;
                                    i9 = iJ1;
                                    i8 = i12;
                                    i11 = i3;
                                    i4 = i20;
                                    i10 = i14;
                                    break;
                                } else {
                                    iN2 = b.i.a.f.e.o.f.n2(bArr2, iJ1, s3Var3);
                                    i22 = i24;
                                    i12 = i34;
                                    i14 = i43;
                                    unsafe2.putLong(t, j16, d4.a(s3Var3.f1493b));
                                    i7 |= i40;
                                    iI1 = iN2;
                                    i20 = i22;
                                    i30 = i19;
                                    bArr3 = bArr2;
                                    i31 = i7;
                                    i13 = i20;
                                    bArr2 = bArr;
                                    i27 = i3;
                                    s3Var3 = s3Var;
                                    i29 = i14;
                                    i32 = i13;
                                    i28 = i12;
                                    i26 = i2;
                                    break;
                                }
                            case 17:
                                if (i35 != 3) {
                                    i20 = i36;
                                    i12 = i34;
                                    i14 = iZ;
                                    i6 = i19;
                                    unsafe = unsafe2;
                                    i9 = iJ1;
                                    i8 = i12;
                                    i11 = i3;
                                    i4 = i20;
                                    i10 = i14;
                                    break;
                                } else {
                                    int i44 = iZ;
                                    iI1 = b.i.a.f.e.o.f.L1(e6Var2.o(iZ), bArr, iJ1, i2, (i34 << 3) | 4, s3Var);
                                    if ((i7 & i40) == 0) {
                                        unsafe2.putObject(obj4, j, s3Var3.c);
                                    } else {
                                        long j17 = j;
                                        unsafe2.putObject(obj4, j17, w4.c(unsafe2.getObject(obj4, j17), s3Var3.c));
                                    }
                                    i25 = i7 | i40;
                                    i26 = i2;
                                    i30 = i19;
                                    i32 = i36;
                                    i28 = i34;
                                    i29 = i44;
                                    bArr3 = bArr2;
                                    i31 = i25;
                                    i27 = i3;
                                    break;
                                }
                            default:
                                i12 = i34;
                                i20 = i36;
                                i14 = iZ;
                                i6 = i19;
                                unsafe = unsafe2;
                                i9 = iJ1;
                                i8 = i12;
                                i11 = i3;
                                i4 = i20;
                                i10 = i14;
                                break;
                        }
                    } else {
                        obj4 = t;
                        i12 = i34;
                        i13 = i36;
                        i14 = iZ;
                        if (i38 != 27) {
                            i6 = i30;
                            i15 = i31;
                            if (i38 <= 49) {
                                i8 = i12;
                                i10 = i14;
                                unsafe = unsafe2;
                                int i45 = iJ1;
                                i17 = i13;
                                iI1 = k(t, bArr, iJ1, i2, i13, i12, i35, i14, i37, i38, j2, s3Var);
                                if (iI1 != i45) {
                                    s3Var2 = s3Var;
                                    bArr3 = bArr;
                                    bArr2 = bArr3;
                                    i26 = i2;
                                    i27 = i3;
                                    e6Var2 = this;
                                    i28 = i8;
                                    i32 = i17;
                                    obj4 = t;
                                    i29 = i10;
                                    i30 = i6;
                                    i31 = i15;
                                    unsafe2 = unsafe;
                                    s3Var3 = s3Var2;
                                }
                                i18 = iI1;
                                i11 = i3;
                                i9 = i18;
                                i4 = i17;
                                i7 = i15;
                            } else {
                                unsafe = unsafe2;
                                i16 = iJ1;
                                i17 = i13;
                                i8 = i12;
                                i10 = i14;
                                if (i38 != 50) {
                                    iI1 = j(t, bArr, i16, i2, i17, i8, i35, i37, i38, j2, i10, s3Var);
                                    if (iI1 != i16) {
                                        s3Var2 = s3Var;
                                        bArr3 = bArr;
                                        bArr2 = bArr3;
                                        i26 = i2;
                                        i27 = i3;
                                        e6Var2 = this;
                                        i28 = i8;
                                        i32 = i17;
                                        obj4 = t;
                                        i29 = i10;
                                        i30 = i6;
                                        i31 = i15;
                                        unsafe2 = unsafe;
                                        s3Var3 = s3Var2;
                                    }
                                    i18 = iI1;
                                    i11 = i3;
                                    i9 = i18;
                                    i4 = i17;
                                    i7 = i15;
                                } else if (i35 == 2) {
                                    l(t, bArr, i16, i2, i10, j2, s3Var);
                                    throw null;
                                }
                            }
                        } else if (i35 == 2) {
                            b5 b5VarF = (b5) unsafe2.getObject(obj4, j2);
                            if (!b5VarF.a()) {
                                int size = b5VarF.size();
                                b5VarF = b5VarF.f(size == 0 ? 10 : size << 1);
                                unsafe2.putObject(obj4, j2, b5VarF);
                            }
                            iI1 = b.i.a.f.e.o.f.K1(e6Var2.o(i14), i13, bArr, iJ1, i2, b5VarF, s3Var);
                            bArr3 = bArr4;
                            i30 = i30;
                            i31 = i31;
                            bArr2 = bArr;
                            i27 = i3;
                            s3Var3 = s3Var;
                            i29 = i14;
                            i32 = i13;
                            i28 = i12;
                            i26 = i2;
                        } else {
                            i6 = i30;
                            i15 = i31;
                            unsafe = unsafe2;
                            i16 = iJ1;
                            i17 = i13;
                            i8 = i12;
                            i10 = i14;
                        }
                        i18 = i16;
                        i11 = i3;
                        i9 = i18;
                        i4 = i17;
                        i7 = i15;
                    }
                }
                if (i4 != i11 || i11 == 0) {
                    if (this.h) {
                        s3Var2 = s3Var;
                        if (s3Var2.d != h4.a()) {
                            int i46 = i8;
                            if (s3Var2.d.d.get(new h4.a(this.g, i46)) != null) {
                                ((u4.d) t).u();
                                throw new NoSuchMethodError();
                            }
                            iI1 = b.i.a.f.e.o.f.I1(i4, bArr, i9, i2, M(t), s3Var);
                            obj4 = t;
                            bArr3 = bArr;
                            bArr2 = bArr3;
                            i27 = i11;
                            e6Var2 = this;
                            s3Var3 = s3Var2;
                            i28 = i46;
                            i32 = i4;
                            i31 = i7;
                            i29 = i10;
                            i30 = i6;
                            unsafe2 = unsafe;
                            i26 = i2;
                        } else {
                            obj2 = t;
                        }
                    } else {
                        obj2 = t;
                        s3Var2 = s3Var;
                    }
                    iI1 = b.i.a.f.e.o.f.I1(i4, bArr, i9, i2, M(t), s3Var);
                    bArr3 = bArr;
                    bArr2 = bArr3;
                    i27 = i11;
                    e6Var2 = this;
                    i28 = i8;
                    i32 = i4;
                    obj4 = obj2;
                    i31 = i7;
                    i29 = i10;
                    i30 = i6;
                    unsafe2 = unsafe;
                    i26 = i2;
                    s3Var3 = s3Var2;
                } else {
                    e6Var = this;
                    obj = t;
                    iI1 = i9;
                    i27 = i11;
                    i31 = i7;
                    i30 = i6;
                }
            } else {
                unsafe = unsafe2;
                obj = obj4;
                e6Var = e6Var2;
                i4 = i32;
            }
        }
    }

    public final q6 o(int i) {
        int i2 = (i / 3) << 1;
        Object[] objArr = this.d;
        q6 q6Var = (q6) objArr[i2];
        if (q6Var != null) {
            return q6Var;
        }
        q6<T> q6VarA = n6.a.a((Class) objArr[i2 + 1]);
        this.d[i2] = q6VarA;
        return q6VarA;
    }

    public final <K, V> void t(v7 v7Var, int i, Object obj, int i2) throws IOException {
        if (obj != null) {
            this.q.g(this.d[(i2 / 3) << 1]);
            Map<?, ?> mapE = this.q.e(obj);
            g4 g4Var = (g4) v7Var;
            Objects.requireNonNull(g4Var);
            Iterator<Map.Entry<?, ?>> it = mapE.entrySet().iterator();
            if (it.hasNext()) {
                Map.Entry<?, ?> next = it.next();
                g4Var.a.f(i, 2);
                next.getKey();
                next.getValue();
                Objects.requireNonNull(null);
                throw null;
            }
        }
    }

    public final void u(T t, T t2, int i) {
        long j = this.c[i + 1] & 1048575;
        if (v(t2, i)) {
            Object objR = j7.r(t, j);
            Object objR2 = j7.r(t2, j);
            if (objR != null && objR2 != null) {
                j7.f(t, j, w4.c(objR, objR2));
                B(t, i);
            } else if (objR2 != null) {
                j7.f(t, j, objR2);
                B(t, i);
            }
        }
    }

    public final boolean v(T t, int i) {
        int[] iArr = this.c;
        int i2 = iArr[i + 2];
        long j = i2 & 1048575;
        if (j != 1048575) {
            return (j7.b(t, j) & (1 << (i2 >>> 20))) != 0;
        }
        int i3 = iArr[i + 1];
        long j2 = i3 & 1048575;
        switch ((i3 & 267386880) >>> 20) {
            case 0:
                return j7.q(t, j2) != 0.0d;
            case 1:
                return j7.n(t, j2) != 0.0f;
            case 2:
                return j7.i(t, j2) != 0;
            case 3:
                return j7.i(t, j2) != 0;
            case 4:
                return j7.b(t, j2) != 0;
            case 5:
                return j7.i(t, j2) != 0;
            case 6:
                return j7.b(t, j2) != 0;
            case 7:
                return j7.m(t, j2);
            case 8:
                Object objR = j7.r(t, j2);
                if (objR instanceof String) {
                    return !((String) objR).isEmpty();
                }
                if (objR instanceof t3) {
                    return !t3.j.equals(objR);
                }
                throw new IllegalArgumentException();
            case 9:
                return j7.r(t, j2) != null;
            case 10:
                return !t3.j.equals(j7.r(t, j2));
            case 11:
                return j7.b(t, j2) != 0;
            case 12:
                return j7.b(t, j2) != 0;
            case 13:
                return j7.b(t, j2) != 0;
            case 14:
                return j7.i(t, j2) != 0;
            case 15:
                return j7.b(t, j2) != 0;
            case 16:
                return j7.i(t, j2) != 0;
            case 17:
                return j7.r(t, j2) != null;
            default:
                throw new IllegalArgumentException();
        }
    }

    public final boolean w(T t, int i, int i2) {
        return j7.b(t, (long) (this.c[i2 + 2] & 1048575)) == i;
    }

    public final boolean x(T t, int i, int i2, int i3, int i4) {
        return i2 == 1048575 ? v(t, i) : (i3 & i4) != 0;
    }

    public final int z(int i, int i2) {
        int length = (this.c.length / 3) - 1;
        while (i2 <= length) {
            int i3 = (length + i2) >>> 1;
            int i4 = i3 * 3;
            int i5 = this.c[i4];
            if (i == i5) {
                return i4;
            }
            if (i < i5) {
                length = i3 - 1;
            } else {
                i2 = i3 + 1;
            }
        }
        return -1;
    }
}
