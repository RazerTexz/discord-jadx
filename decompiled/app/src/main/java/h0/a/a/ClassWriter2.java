package h0.a.a;

import b.d.b.a.outline;
import h0.a.a.Attribute2;
import org.objectweb.asm.ClassTooLargeException;
import org.objectweb.asm.MethodTooLargeException;
import org.objectweb.asm.Opcodes;

/* compiled from: ClassWriter.java */
/* renamed from: h0.a.a.f, reason: use source file name */
/* loaded from: classes3.dex */
public class ClassWriter2 extends ClassVisitor2 {
    public Attribute2 A;
    public int B;
    public int a;

    /* renamed from: b, reason: collision with root package name */
    public final SymbolTable2 f3701b;
    public int c;
    public int d;
    public int e;
    public int f;
    public int[] g;
    public FieldWriter2 h;
    public FieldWriter2 i;
    public MethodWriter2 j;
    public MethodWriter2 k;
    public int l;
    public ByteVector2 m;
    public int n;
    public int o;
    public int p;
    public int q;
    public ByteVector2 r;

    /* renamed from: s, reason: collision with root package name */
    public AnnotationWriter2 f3702s;
    public AnnotationWriter2 t;
    public AnnotationWriter2 u;
    public AnnotationWriter2 v;
    public ModuleWriter2 w;

    /* renamed from: x, reason: collision with root package name */
    public int f3703x;

    /* renamed from: y, reason: collision with root package name */
    public int f3704y;

    /* renamed from: z, reason: collision with root package name */
    public ByteVector2 f3705z;

    public ClassWriter2(int i) {
        super(Opcodes.ASM7);
        this.f3701b = new SymbolTable2(this);
        if ((i & 2) != 0) {
            this.B = 4;
        } else if ((i & 1) != 0) {
            this.B = 1;
        } else {
            this.B = 0;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:412:0x0acf  */
    /* JADX WARN: Removed duplicated region for block: B:412:0x0acf A[EDGE_INSN: B:412:0x0acf->B:413:0x0ad0 BREAK  A[LOOP:39: B:405:0x0ab3->B:410:0x0ac2]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final byte[] a(byte[] bArr, boolean z2) {
        String strG;
        Attribute2 attribute2;
        String str;
        String str2;
        String str3;
        String str4;
        int i;
        String str5;
        ClassWriter2 classWriter2;
        String str6;
        String str7;
        String str8;
        String strW;
        boolean z3;
        boolean z4;
        String str9;
        String str10;
        String str11;
        String str12;
        int i2;
        String str13;
        String str14;
        String str15;
        String str16;
        int i3;
        String str17;
        String str18;
        String str19;
        String str20;
        String str21;
        String str22;
        int i4;
        String str23;
        int i5;
        String str24;
        String str25;
        String str26;
        String str27;
        String str28;
        String str29;
        String str30;
        String str31;
        ClassReader2 classReader2;
        String str32;
        Context3 context3;
        int i6;
        String[] strArr;
        String[] strArr2;
        String str33;
        int i7;
        String str34;
        int i8;
        int i9;
        String[] strArr3;
        Attribute2.a aVar = new Attribute2.a();
        aVar.a(this.A);
        for (FieldWriter2 fieldWriter2 = this.h; fieldWriter2 != null; fieldWriter2 = (FieldWriter2) fieldWriter2.a) {
            aVar.a(fieldWriter2.l);
        }
        MethodWriter2 methodWriter2 = this.j;
        while (true) {
            strG = null;
            if (methodWriter2 == null) {
                break;
            }
            aVar.a(methodWriter2.M);
            aVar.a(null);
            methodWriter2 = (MethodWriter2) methodWriter2.f3715b;
        }
        int i10 = aVar.a;
        Attribute2[] attribute2Arr = new Attribute2[i10];
        System.arraycopy(aVar.f3698b, 0, attribute2Arr, 0, i10);
        this.h = null;
        this.i = null;
        this.j = null;
        this.k = null;
        this.f3702s = null;
        this.t = null;
        this.u = null;
        this.v = null;
        this.w = null;
        this.f3703x = 0;
        this.f3704y = 0;
        this.f3705z = null;
        this.A = null;
        this.B = z2 ? 3 : 0;
        ClassReader2 classReader22 = new ClassReader2(bArr, 0, false);
        int i11 = (z2 ? 8 : 0) | 256;
        Context3 context32 = new Context3();
        context32.a = attribute2Arr;
        context32.f3707b = i11;
        char[] cArr = new char[classReader22.f];
        context32.c = cArr;
        int i12 = classReader22.g;
        int iU = classReader22.u(i12);
        String strG2 = classReader22.g(i12 + 2, cArr);
        String strG3 = classReader22.g(i12 + 4, cArr);
        int iU2 = classReader22.u(i12 + 6);
        String[] strArr4 = new String[iU2];
        int i13 = i12 + 8;
        for (int i14 = 0; i14 < iU2; i14++) {
            strArr4[i14] = classReader22.g(i13, cArr);
            i13 += 2;
        }
        int iC = classReader22.c();
        String strT = null;
        Attribute2 attribute2E = null;
        String strT2 = null;
        String strG4 = null;
        int i15 = iU;
        int iU3 = classReader22.u(iC - 2);
        String[] strArr5 = strArr4;
        int i16 = 0;
        int i17 = 0;
        int i18 = 0;
        int i19 = 0;
        int i20 = 0;
        int i21 = 0;
        int i22 = 0;
        int i23 = 0;
        int i24 = 0;
        String strV = null;
        while (true) {
            attribute2 = attribute2E;
            str = strT;
            str2 = "Synthetic";
            str3 = strV;
            str4 = "Deprecated";
            i = i16;
            str5 = strG;
            if (iU3 <= 0) {
                break;
            }
            String strT3 = classReader22.t(iC, cArr);
            int i25 = i13;
            int iL = classReader22.l(iC + 2);
            int i26 = iC + 6;
            Context3 context33 = context32;
            if ("SourceFile".equals(strT3)) {
                strT = classReader22.t(i26, cArr);
                strV = str3;
                i16 = i;
                strG = str5;
            } else {
                if ("InnerClasses".equals(strT3)) {
                    i24 = i26;
                } else if ("EnclosingMethod".equals(strT3)) {
                    i18 = i26;
                } else if ("NestHost".equals(strT3)) {
                    strG4 = classReader22.g(i26, cArr);
                } else if ("NestMembers".equals(strT3)) {
                    i23 = i26;
                } else if ("Signature".equals(strT3)) {
                    strT2 = classReader22.t(i26, cArr);
                } else if ("RuntimeVisibleAnnotations".equals(strT3)) {
                    i19 = i26;
                } else if ("RuntimeVisibleTypeAnnotations".equals(strT3)) {
                    i21 = i26;
                } else if ("Deprecated".equals(strT3)) {
                    i15 |= 131072;
                } else if ("Synthetic".equals(strT3)) {
                    i15 |= 4096;
                } else if ("SourceDebugExtension".equals(strT3)) {
                    strV = classReader22.v(i26, iL, new char[iL]);
                    i16 = i;
                    strG = str5;
                    strT = str;
                } else if ("RuntimeInvisibleAnnotations".equals(strT3)) {
                    i20 = i26;
                } else if ("RuntimeInvisibleTypeAnnotations".equals(strT3)) {
                    i22 = i26;
                } else if ("Module".equals(strT3)) {
                    i16 = i26;
                    strG = str5;
                    strV = str3;
                    strT = str;
                } else if ("ModuleMainClass".equals(strT3)) {
                    strG = classReader22.g(i26, cArr);
                    i16 = i;
                    strV = str3;
                    strT = str;
                } else if ("ModulePackages".equals(strT3)) {
                    i17 = i26;
                } else {
                    if ("BootstrapMethods".equals(strT3)) {
                        str33 = str;
                        i7 = i26;
                        str34 = str3;
                        i8 = i;
                        i9 = i15;
                        strArr3 = strArr5;
                        attribute2E = attribute2;
                    } else {
                        i7 = i26;
                        i8 = i;
                        str33 = str;
                        str34 = str3;
                        i9 = i15;
                        strArr3 = strArr5;
                        attribute2E = classReader22.e(attribute2Arr, strT3, i7, iL, cArr, -1, null);
                        attribute2E.c = attribute2;
                    }
                    strT = str33;
                    i16 = i8;
                    i15 = i9;
                    strG = str5;
                    strV = str34;
                    iC = i7 + iL;
                    iU3--;
                    strArr5 = strArr3;
                    i13 = i25;
                    context32 = context33;
                }
                i16 = i;
                strG = str5;
                strV = str3;
                strT = str;
            }
            attribute2E = attribute2;
            i7 = i26;
            strArr3 = strArr5;
            iC = i7 + iL;
            iU3--;
            strArr5 = strArr3;
            i13 = i25;
            context32 = context33;
        }
        int i27 = i13;
        String str35 = "RuntimeInvisibleTypeAnnotations";
        String str36 = "RuntimeInvisibleAnnotations";
        Context3 context34 = context32;
        ClassReader2 classReader23 = classReader22;
        String str37 = "RuntimeVisibleTypeAnnotations";
        c(classReader22.l(classReader22.f3700b[1] - 7), i15, strG2, strT2, strG3, strArr5);
        if ((i11 & 2) != 0 || (str == null && str3 == null)) {
            classWriter2 = this;
            str6 = "Signature";
        } else {
            classWriter2 = this;
            str6 = "Signature";
            if (str != null) {
                classWriter2.q = classWriter2.f3701b.l(str);
            }
            if (str3 != null) {
                ByteVector2 byteVector2 = new ByteVector2();
                byteVector2.a(str3, 0, Integer.MAX_VALUE);
                classWriter2.r = byteVector2;
            }
        }
        if (i != 0) {
            char[] cArr2 = context34.c;
            String strT4 = classReader23.t(classReader23.f3700b[classReader23.u(i)], cArr2);
            int iU4 = classReader23.u(i + 2);
            String strT5 = classReader23.t(i + 4, cArr2);
            int i28 = i + 6;
            SymbolTable2 symbolTable2 = classWriter2.f3701b;
            str7 = "RuntimeVisibleAnnotations";
            ModuleWriter2 moduleWriter2 = new ModuleWriter2(symbolTable2, symbolTable2.m(19, strT4).a, iU4, strT5 == null ? 0 : classWriter2.f3701b.l(strT5));
            classWriter2.w = moduleWriter2;
            if (str5 != null) {
                moduleWriter2.q = symbolTable2.m(7, str5).a;
            }
            int i29 = i17;
            if (i29 != 0) {
                int iU5 = classReader23.u(i29);
                int i30 = i29 + 2;
                while (true) {
                    int i31 = iU5 - 1;
                    if (iU5 <= 0) {
                        break;
                    }
                    moduleWriter2.p.j(moduleWriter2.a.m(20, classReader23.o(i30, cArr2)).a);
                    moduleWriter2.o++;
                    i30 += 2;
                    iU5 = i31;
                }
            }
            int iU6 = classReader23.u(i28);
            int i32 = i28 + 2;
            while (true) {
                int i33 = iU6 - 1;
                if (iU6 <= 0) {
                    break;
                }
                String strN = classReader23.n(i32, cArr2);
                int iU7 = classReader23.u(i32 + 2);
                String strT6 = classReader23.t(i32 + 4, cArr2);
                i32 += 6;
                ByteVector2 byteVector22 = moduleWriter2.f;
                String str38 = str2;
                byteVector22.j(moduleWriter2.a.m(19, strN).a);
                byteVector22.j(iU7);
                byteVector22.j(strT6 == null ? 0 : moduleWriter2.a.l(strT6));
                moduleWriter2.e++;
                iU6 = i33;
                str2 = str38;
            }
            str8 = str2;
            int iU8 = classReader23.u(i32);
            int i34 = i32 + 2;
            while (true) {
                int i35 = iU8 - 1;
                if (iU8 <= 0) {
                    break;
                }
                String strO = classReader23.o(i34, cArr2);
                int iU9 = classReader23.u(i34 + 2);
                int iU10 = classReader23.u(i34 + 4);
                i34 += 6;
                if (iU10 != 0) {
                    strArr2 = new String[iU10];
                    int i36 = i34;
                    for (int i37 = 0; i37 < iU10; i37++) {
                        strArr2[i37] = classReader23.n(i36, cArr2);
                        i36 += 2;
                    }
                    i34 = i36;
                } else {
                    strArr2 = null;
                }
                ByteVector2 byteVector23 = moduleWriter2.h;
                byteVector23.j(moduleWriter2.a.m(20, strO).a);
                byteVector23.j(iU9);
                if (strArr2 == null) {
                    moduleWriter2.h.j(0);
                } else {
                    moduleWriter2.h.j(strArr2.length);
                    for (String str39 : strArr2) {
                        moduleWriter2.h.j(moduleWriter2.a.j(str39).a);
                    }
                }
                moduleWriter2.g++;
                iU8 = i35;
            }
            int iU11 = classReader23.u(i34);
            int i38 = i34 + 2;
            while (true) {
                int i39 = iU11 - 1;
                if (iU11 <= 0) {
                    break;
                }
                String strO2 = classReader23.o(i38, cArr2);
                int iU12 = classReader23.u(i38 + 2);
                int iU13 = classReader23.u(i38 + 4);
                i38 += 6;
                if (iU13 != 0) {
                    strArr = new String[iU13];
                    int i40 = i38;
                    for (int i41 = 0; i41 < iU13; i41++) {
                        strArr[i41] = classReader23.n(i40, cArr2);
                        i40 += 2;
                    }
                    i38 = i40;
                } else {
                    strArr = null;
                }
                ByteVector2 byteVector24 = moduleWriter2.j;
                byteVector24.j(moduleWriter2.a.m(20, strO2).a);
                byteVector24.j(iU12);
                if (strArr == null) {
                    moduleWriter2.j.j(0);
                } else {
                    moduleWriter2.j.j(strArr.length);
                    for (String str40 : strArr) {
                        moduleWriter2.j.j(moduleWriter2.a.j(str40).a);
                    }
                }
                moduleWriter2.i++;
                iU11 = i39;
            }
            int iU14 = classReader23.u(i38);
            int i42 = i38 + 2;
            while (true) {
                int i43 = iU14 - 1;
                if (iU14 <= 0) {
                    break;
                }
                moduleWriter2.l.j(moduleWriter2.a.m(7, classReader23.g(i42, cArr2)).a);
                moduleWriter2.k++;
                i42 += 2;
                iU14 = i43;
            }
            int iU15 = classReader23.u(i42);
            int i44 = i42 + 2;
            while (true) {
                int i45 = iU15 - 1;
                if (iU15 <= 0) {
                    break;
                }
                String strG5 = classReader23.g(i44, cArr2);
                int iU16 = classReader23.u(i44 + 2);
                String[] strArr6 = new String[iU16];
                int i46 = i44 + 4;
                for (int i47 = 0; i47 < iU16; i47++) {
                    strArr6[i47] = classReader23.g(i46, cArr2);
                    i46 += 2;
                }
                char[] cArr3 = cArr2;
                moduleWriter2.n.j(moduleWriter2.a.m(7, strG5).a);
                moduleWriter2.n.j(iU16);
                for (int i48 = 0; i48 < iU16; i48++) {
                    moduleWriter2.n.j(moduleWriter2.a.c(strArr6[i48]).a);
                }
                moduleWriter2.m++;
                iU15 = i45;
                i44 = i46;
                cArr2 = cArr3;
            }
        } else {
            str7 = "RuntimeVisibleAnnotations";
            str8 = "Synthetic";
        }
        String str41 = strG4;
        if (str41 != null) {
            classWriter2.f3703x = classWriter2.f3701b.m(7, str41).a;
        }
        int i49 = i18;
        if (i49 != 0) {
            String strG6 = classReader23.g(i49, cArr);
            int iU17 = classReader23.u(i49 + 2);
            String strT7 = iU17 == 0 ? null : classReader23.t(classReader23.f3700b[iU17], cArr);
            String strT8 = iU17 == 0 ? null : classReader23.t(classReader23.f3700b[iU17] + 2, cArr);
            classWriter2.n = classWriter2.f3701b.m(7, strG6).a;
            if (strT7 != null && strT8 != null) {
                classWriter2.o = classWriter2.f3701b.k(strT7, strT8);
            }
        }
        int i50 = i19;
        if (i50 != 0) {
            int iU18 = classReader23.u(i50);
            int iK = i50 + 2;
            while (true) {
                int i51 = iU18 - 1;
                if (iU18 <= 0) {
                    break;
                }
                iK = classReader23.k(classWriter2.d(classReader23.t(iK, cArr), true), iK + 2, true, cArr);
                iU18 = i51;
            }
        }
        int i52 = i20;
        if (i52 != 0) {
            int iU19 = classReader23.u(i52);
            int iK2 = i52 + 2;
            while (true) {
                int i53 = iU19 - 1;
                if (iU19 <= 0) {
                    break;
                }
                iK2 = classReader23.k(classWriter2.d(classReader23.t(iK2, cArr), false), iK2 + 2, true, cArr);
                iU19 = i53;
            }
        }
        int i54 = i21;
        if (i54 != 0) {
            int iU20 = classReader23.u(i54);
            int iK3 = i54 + 2;
            while (true) {
                int i55 = iU20 - 1;
                if (iU20 <= 0) {
                    break;
                }
                int iR = classReader23.r(context34, iK3);
                iK3 = classReader23.k(classWriter2.f(context34.h, context34.i, classReader23.t(iR, cArr), true), iR + 2, true, cArr);
                iU20 = i55;
            }
        }
        int i56 = i22;
        if (i56 != 0) {
            int iU21 = classReader23.u(i56);
            int iK4 = i56 + 2;
            while (true) {
                int i57 = iU21 - 1;
                if (iU21 <= 0) {
                    break;
                }
                int iR2 = classReader23.r(context34, iK4);
                iK4 = classReader23.k(classWriter2.f(context34.h, context34.i, classReader23.t(iR2, cArr), false), iR2 + 2, true, cArr);
                iU21 = i57;
            }
        }
        Attribute2 attribute22 = attribute2;
        while (attribute22 != null) {
            Attribute2 attribute23 = attribute22.c;
            attribute22.c = null;
            attribute22.c = classWriter2.A;
            classWriter2.A = attribute22;
            attribute22 = attribute23;
        }
        int i58 = i23;
        if (i58 != 0) {
            int iU22 = classReader23.u(i58);
            int i59 = i58 + 2;
            while (true) {
                int i60 = iU22 - 1;
                if (iU22 <= 0) {
                    break;
                }
                String strG7 = classReader23.g(i59, cArr);
                if (classWriter2.f3705z == null) {
                    classWriter2.f3705z = new ByteVector2();
                }
                classWriter2.f3704y++;
                classWriter2.f3705z.j(classWriter2.f3701b.m(7, strG7).a);
                i59 += 2;
                iU22 = i60;
            }
        }
        int i61 = i24;
        if (i61 != 0) {
            int iU23 = classReader23.u(i61);
            int i62 = i61 + 2;
            while (true) {
                int i63 = iU23 - 1;
                if (iU23 <= 0) {
                    break;
                }
                String strG8 = classReader23.g(i62, cArr);
                String strG9 = classReader23.g(i62 + 2, cArr);
                String strT9 = classReader23.t(i62 + 4, cArr);
                int iU24 = classReader23.u(i62 + 6);
                if (classWriter2.m == null) {
                    classWriter2.m = new ByteVector2();
                }
                Symbol2 symbol2M = classWriter2.f3701b.m(7, strG8);
                if (symbol2M.g == 0) {
                    classWriter2.l++;
                    classWriter2.m.j(symbol2M.a);
                    classWriter2.m.j(strG9 == null ? 0 : classWriter2.f3701b.m(7, strG9).a);
                    classWriter2.m.j(strT9 == null ? 0 : classWriter2.f3701b.l(strT9));
                    classWriter2.m.j(iU24);
                    symbol2M.g = classWriter2.l;
                }
                i62 += 8;
                iU23 = i63;
            }
        }
        int iU25 = classReader23.u(i27);
        int i64 = i27 + 2;
        while (true) {
            int i65 = iU25 - 1;
            if (iU25 <= 0) {
                break;
            }
            char[] cArr4 = context34.c;
            int iU26 = classReader23.u(i64);
            String strT10 = classReader23.t(i64 + 2, cArr4);
            String strT11 = classReader23.t(i64 + 4, cArr4);
            int i66 = i64 + 6;
            int iU27 = classReader23.u(i66);
            i64 = i66 + 2;
            int i67 = iU26;
            int i68 = 0;
            int i69 = 0;
            int i70 = 0;
            Attribute2 attribute24 = null;
            int i71 = 0;
            String strT12 = null;
            Object objI = null;
            while (true) {
                int i72 = iU27 - 1;
                if (iU27 <= 0) {
                    break;
                }
                String strT13 = classReader23.t(i64, cArr4);
                int iL2 = classReader23.l(i64 + 2);
                int i73 = i64 + 6;
                if ("ConstantValue".equals(strT13)) {
                    int iU28 = classReader23.u(i73);
                    if (iU28 == 0) {
                        str22 = str8;
                        objI = null;
                        i4 = i65;
                        i6 = i67;
                        i5 = i71;
                        str23 = str37;
                        str24 = str36;
                        str25 = str7;
                        str26 = str35;
                        str32 = str26;
                        str31 = str6;
                        str28 = str22;
                        str27 = str23;
                        str30 = str4;
                        classReader2 = classReader23;
                        str29 = str24;
                        context3 = context34;
                        i71 = i5;
                        i67 = i6;
                    } else {
                        objI = classReader23.i(iU28, cArr4);
                        str22 = str8;
                        i4 = i65;
                        i6 = i67;
                        i5 = i71;
                        str23 = str37;
                        str24 = str36;
                        str25 = str7;
                        str26 = str35;
                        str32 = str26;
                        str31 = str6;
                        str28 = str22;
                        str27 = str23;
                        str30 = str4;
                        classReader2 = classReader23;
                        str29 = str24;
                        context3 = context34;
                        i71 = i5;
                        i67 = i6;
                    }
                } else {
                    if (str6.equals(strT13)) {
                        strT12 = classReader23.t(i73, cArr4);
                    } else if (str4.equals(strT13)) {
                        i67 |= 131072;
                    } else {
                        str22 = str8;
                        if (str22.equals(strT13)) {
                            i67 |= 4096;
                            i4 = i65;
                            i6 = i67;
                            i5 = i71;
                            str23 = str37;
                            str24 = str36;
                            str25 = str7;
                            str26 = str35;
                            str32 = str26;
                            str31 = str6;
                            str28 = str22;
                            str27 = str23;
                            str30 = str4;
                            classReader2 = classReader23;
                            str29 = str24;
                            context3 = context34;
                            i71 = i5;
                            i67 = i6;
                        } else {
                            i4 = i65;
                            String str42 = str7;
                            if (str42.equals(strT13)) {
                                str32 = str35;
                                i68 = i73;
                                str31 = str6;
                                str28 = str22;
                                str30 = str4;
                                context3 = context34;
                                str27 = str37;
                                str29 = str36;
                                str25 = str42;
                                classReader2 = classReader23;
                            } else {
                                int i74 = i67;
                                str23 = str37;
                                if (str23.equals(strT13)) {
                                    i70 = i73;
                                    i5 = i71;
                                    str24 = str36;
                                } else {
                                    i5 = i71;
                                    str24 = str36;
                                    if (str24.equals(strT13)) {
                                        i69 = i73;
                                    } else {
                                        str25 = str42;
                                        str26 = str35;
                                        if (str26.equals(strT13)) {
                                            i6 = i74;
                                            i5 = i73;
                                            str32 = str26;
                                            str31 = str6;
                                            str28 = str22;
                                            str27 = str23;
                                            str30 = str4;
                                            classReader2 = classReader23;
                                            str29 = str24;
                                            context3 = context34;
                                            i71 = i5;
                                            i67 = i6;
                                        } else {
                                            str27 = str23;
                                            str28 = str22;
                                            str29 = str24;
                                            str30 = str4;
                                            str31 = str6;
                                            classReader2 = classReader23;
                                            str32 = str26;
                                            context3 = context34;
                                            Attribute2 attribute2E2 = classReader23.e(context34.a, strT13, i73, iL2, cArr4, -1, null);
                                            attribute2E2.c = attribute24;
                                            attribute24 = attribute2E2;
                                            i67 = i74;
                                            i71 = i5;
                                        }
                                    }
                                }
                                i6 = i74;
                                str25 = str42;
                                str26 = str35;
                                str32 = str26;
                                str31 = str6;
                                str28 = str22;
                                str27 = str23;
                                str30 = str4;
                                classReader2 = classReader23;
                                str29 = str24;
                                context3 = context34;
                                i71 = i5;
                                i67 = i6;
                            }
                        }
                    }
                    str22 = str8;
                    i4 = i65;
                    i6 = i67;
                    i5 = i71;
                    str23 = str37;
                    str24 = str36;
                    str25 = str7;
                    str26 = str35;
                    str32 = str26;
                    str31 = str6;
                    str28 = str22;
                    str27 = str23;
                    str30 = str4;
                    classReader2 = classReader23;
                    str29 = str24;
                    context3 = context34;
                    i71 = i5;
                    i67 = i6;
                }
                i64 = i73 + iL2;
                classReader23 = classReader2;
                context34 = context3;
                iU27 = i72;
                str4 = str30;
                i65 = i4;
                str8 = str28;
                str36 = str29;
                str35 = str32;
                str6 = str31;
                str7 = str25;
                str37 = str27;
            }
            String str43 = str35;
            int i75 = i65;
            String str44 = str4;
            Attribute2 attribute25 = attribute24;
            ClassReader2 classReader24 = classReader23;
            int i76 = i71;
            String str45 = str37;
            String str46 = str36;
            String str47 = str8;
            String str48 = str7;
            String str49 = str6;
            Context3 context35 = context34;
            FieldWriter2 fieldWriter22 = new FieldWriter2(classWriter2.f3701b, i67, strT10, strT11, strT12, objI);
            if (classWriter2.h == null) {
                classWriter2.h = fieldWriter22;
            } else {
                classWriter2.i.a = fieldWriter22;
            }
            classWriter2.i = fieldWriter22;
            if (i68 != 0) {
                int iU29 = classReader24.u(i68);
                int iK5 = i68 + 2;
                while (true) {
                    int i77 = iU29 - 1;
                    if (iU29 <= 0) {
                        break;
                    }
                    iK5 = classReader24.k(fieldWriter22.a(classReader24.t(iK5, cArr4), true), iK5 + 2, true, cArr4);
                    iU29 = i77;
                }
            }
            if (i69 != 0) {
                int iU30 = classReader24.u(i69);
                int iK6 = i69 + 2;
                while (true) {
                    int i78 = iU30 - 1;
                    if (iU30 <= 0) {
                        break;
                    }
                    iK6 = classReader24.k(fieldWriter22.a(classReader24.t(iK6, cArr4), false), iK6 + 2, true, cArr4);
                    iU30 = i78;
                }
            }
            if (i70 != 0) {
                int iU31 = classReader24.u(i70);
                int iK7 = i70 + 2;
                while (true) {
                    int i79 = iU31 - 1;
                    if (iU31 <= 0) {
                        break;
                    }
                    int iR3 = classReader24.r(context35, iK7);
                    iK7 = classReader24.k(fieldWriter22.b(context35.h, context35.i, classReader24.t(iR3, cArr4), true), iR3 + 2, true, cArr4);
                    iU31 = i79;
                }
            }
            if (i76 != 0) {
                int iU32 = classReader24.u(i76);
                int iK8 = i76 + 2;
                while (true) {
                    int i80 = iU32 - 1;
                    if (iU32 <= 0) {
                        break;
                    }
                    int iR4 = classReader24.r(context35, iK8);
                    iK8 = classReader24.k(fieldWriter22.b(context35.h, context35.i, classReader24.t(iR4, cArr4), false), iR4 + 2, true, cArr4);
                    iU32 = i80;
                }
            }
            Attribute2 attribute26 = attribute25;
            while (attribute26 != null) {
                Attribute2 attribute27 = attribute26.c;
                attribute26.c = null;
                attribute26.c = fieldWriter22.l;
                fieldWriter22.l = attribute26;
                attribute26 = attribute27;
            }
            classReader23 = classReader24;
            context34 = context35;
            str4 = str44;
            iU25 = i75;
            str8 = str47;
            str36 = str46;
            str35 = str43;
            str6 = str49;
            str7 = str48;
            str37 = str45;
        }
        String str50 = str35;
        String str51 = str4;
        ClassReader2 classReader25 = classReader23;
        String str52 = str37;
        String str53 = str36;
        String str54 = str8;
        String str55 = str7;
        String str56 = str6;
        Context3 context36 = context34;
        int i81 = 1;
        int iU33 = classReader25.u(i64);
        int i82 = i64 + 2;
        while (true) {
            int i83 = iU33 - 1;
            if (iU33 <= 0) {
                return b();
            }
            char[] cArr5 = context36.c;
            context36.d = classReader25.u(i82);
            context36.e = classReader25.t(i82 + 2, cArr5);
            int i84 = i82 + 4;
            context36.f = classReader25.t(i84, cArr5);
            int i85 = i82 + 6;
            int iU34 = classReader25.u(i85);
            int i86 = i85 + 2;
            int i87 = 0;
            int i88 = 0;
            boolean z5 = false;
            Attribute2 attribute28 = null;
            String[] strArr7 = null;
            int i89 = 0;
            int i90 = 0;
            int iU35 = 0;
            int i91 = 0;
            int i92 = 0;
            int i93 = 0;
            int i94 = 0;
            int i95 = 0;
            int i96 = 0;
            while (true) {
                int i97 = iU34 - 1;
                if (iU34 <= 0) {
                    break;
                }
                String strT14 = classReader25.t(i86, cArr5);
                int iL3 = classReader25.l(i86 + 2);
                int i98 = i86 + 6;
                if ("Code".equals(strT14)) {
                    if ((context36.f3707b & i81) == 0) {
                        i96 = i98;
                        str11 = str55;
                        str10 = str51;
                        i2 = i85;
                        str12 = str11;
                        str15 = str50;
                        str17 = str56;
                        str16 = str10;
                        i3 = i98;
                        str18 = str12;
                        str19 = str52;
                        str20 = str53;
                        str21 = str15;
                    } else {
                        str9 = str56;
                        str10 = str51;
                        str56 = str9;
                        str11 = str55;
                        i2 = i85;
                        str12 = str11;
                        str15 = str50;
                        str17 = str56;
                        str16 = str10;
                        i3 = i98;
                        str18 = str12;
                        str19 = str52;
                        str20 = str53;
                        str21 = str15;
                    }
                } else if ("Exceptions".equals(strT14)) {
                    int iU36 = classReader25.u(i98);
                    String[] strArr8 = new String[iU36];
                    int i99 = i98 + 2;
                    for (int i100 = 0; i100 < iU36; i100++) {
                        strArr8[i100] = classReader25.g(i99, cArr5);
                        i99 += 2;
                    }
                    strArr7 = strArr8;
                    i88 = i98;
                    str11 = str55;
                    str10 = str51;
                    i2 = i85;
                    str12 = str11;
                    str15 = str50;
                    str17 = str56;
                    str16 = str10;
                    i3 = i98;
                    str18 = str12;
                    str19 = str52;
                    str20 = str53;
                    str21 = str15;
                } else {
                    str9 = str56;
                    if (str9.equals(strT14)) {
                        iU35 = classReader25.u(i98);
                        str10 = str51;
                        str56 = str9;
                        str11 = str55;
                        i2 = i85;
                        str12 = str11;
                        str15 = str50;
                        str17 = str56;
                        str16 = str10;
                        i3 = i98;
                        str18 = str12;
                        str19 = str52;
                        str20 = str53;
                        str21 = str15;
                    } else {
                        str10 = str51;
                        if (str10.equals(strT14)) {
                            context36.d |= 131072;
                            str56 = str9;
                            str11 = str55;
                            i2 = i85;
                            str12 = str11;
                            str15 = str50;
                            str17 = str56;
                            str16 = str10;
                            i3 = i98;
                            str18 = str12;
                            str19 = str52;
                            str20 = str53;
                            str21 = str15;
                        } else {
                            str56 = str9;
                            str11 = str55;
                            if (str11.equals(strT14)) {
                                i90 = i98;
                                i2 = i85;
                                str12 = str11;
                                str15 = str50;
                                str17 = str56;
                                str16 = str10;
                                i3 = i98;
                                str18 = str12;
                                str19 = str52;
                                str20 = str53;
                                str21 = str15;
                            } else {
                                str12 = str11;
                                String str57 = str52;
                                if (str57.equals(strT14)) {
                                    i2 = i85;
                                    i92 = i98;
                                } else {
                                    i2 = i85;
                                    if ("AnnotationDefault".equals(strT14)) {
                                        i87 = i98;
                                    } else {
                                        str13 = str54;
                                        if (str13.equals(strT14)) {
                                            context36.d |= 4096;
                                            str17 = str56;
                                            str54 = str13;
                                            str16 = str10;
                                            i3 = i98;
                                            str19 = str57;
                                            str18 = str12;
                                            str20 = str53;
                                            str21 = str50;
                                            z5 = true;
                                        } else {
                                            str52 = str57;
                                            str14 = str53;
                                            if (str14.equals(strT14)) {
                                                i91 = i98;
                                                str54 = str13;
                                                str53 = str14;
                                                str15 = str50;
                                                str17 = str56;
                                                str16 = str10;
                                                i3 = i98;
                                                str18 = str12;
                                                str19 = str52;
                                                str20 = str53;
                                                str21 = str15;
                                            } else {
                                                str53 = str14;
                                                str15 = str50;
                                                if (str15.equals(strT14)) {
                                                    str54 = str13;
                                                    i93 = i98;
                                                } else {
                                                    str54 = str13;
                                                    if ("RuntimeVisibleParameterAnnotations".equals(strT14)) {
                                                        i94 = i98;
                                                    } else if ("RuntimeInvisibleParameterAnnotations".equals(strT14)) {
                                                        i95 = i98;
                                                    } else if ("MethodParameters".equals(strT14)) {
                                                        i89 = i98;
                                                    } else {
                                                        str16 = str10;
                                                        i3 = i98;
                                                        str17 = str56;
                                                        str18 = str12;
                                                        str19 = str52;
                                                        str20 = str53;
                                                        str21 = str15;
                                                        Attribute2 attribute2E3 = classReader25.e(context36.a, strT14, i98, iL3, cArr5, -1, null);
                                                        attribute2E3.c = attribute28;
                                                        z5 = z5;
                                                        i88 = i88;
                                                        attribute28 = attribute2E3;
                                                        i87 = i87;
                                                    }
                                                }
                                                str17 = str56;
                                                str16 = str10;
                                                i3 = i98;
                                                str18 = str12;
                                                str19 = str52;
                                                str20 = str53;
                                                str21 = str15;
                                            }
                                        }
                                    }
                                }
                                str52 = str57;
                                str13 = str54;
                                str14 = str53;
                                str54 = str13;
                                str53 = str14;
                                str15 = str50;
                                str17 = str56;
                                str16 = str10;
                                i3 = i98;
                                str18 = str12;
                                str19 = str52;
                                str20 = str53;
                                str21 = str15;
                            }
                        }
                    }
                }
                i86 = i3 + iL3;
                i85 = i2;
                str50 = str21;
                iU34 = i97;
                str51 = str16;
                str53 = str20;
                str52 = str19;
                str55 = str18;
                str56 = str17;
                i81 = 1;
            }
            String str58 = str56;
            int i101 = i85;
            int i102 = i87;
            int i103 = i88;
            boolean z6 = z5;
            Attribute2 attribute29 = attribute28;
            String str59 = str55;
            String str60 = str51;
            String str61 = str52;
            String str62 = str53;
            String str63 = str50;
            int i104 = context36.d;
            String str64 = context36.e;
            String str65 = context36.f;
            int i105 = iU35;
            if (i105 == 0) {
                z3 = z6;
                strW = null;
            } else {
                strW = classReader25.w(i105, cArr5);
                z3 = z6;
            }
            String str66 = str54;
            ClassReader2 classReader26 = classReader25;
            str51 = str60;
            String str67 = strW;
            Context3 context37 = context36;
            MethodVisitor2 methodVisitor2E = e(i104, str64, str65, str67, strArr7);
            MethodWriter2 methodWriter22 = (MethodWriter2) methodVisitor2E;
            int i106 = i86 - i82;
            boolean z7 = (context37.d & 131072) != 0;
            int iU37 = classReader26.u(i84);
            SymbolTable2 symbolTable22 = methodWriter22.d;
            if (classReader26 != symbolTable22.f3725b || iU37 != methodWriter22.h || i105 != methodWriter22.A) {
                z4 = false;
                break;
            }
            int i107 = methodWriter22.e;
            if (z7 == ((i107 & 131072) != 0)) {
                if (z3 == (symbolTable22.c < 49 && (i107 & 4096) != 0)) {
                    if (i103 != 0) {
                        if (classReader26.u(i103) == methodWriter22.f3720y) {
                            int i108 = i103 + 2;
                            for (int i109 = 0; i109 < methodWriter22.f3720y; i109++) {
                                if (classReader26.u(i108) != methodWriter22.f3721z[i109]) {
                                    z4 = false;
                                    break;
                                }
                                i108 += 2;
                            }
                        }
                        methodWriter22.f3716a0 = i101;
                        methodWriter22.f3717b0 = i106 - 6;
                        z4 = true;
                    } else if (methodWriter22.f3720y == 0) {
                        methodWriter22.f3716a0 = i101;
                        methodWriter22.f3717b0 = i106 - 6;
                        z4 = true;
                    }
                }
            }
            if (!z4) {
                int i110 = i89;
                if (i110 != 0) {
                    int iF = classReader26.f(i110);
                    int i111 = i110 + 1;
                    while (true) {
                        int i112 = iF - 1;
                        if (iF <= 0) {
                            break;
                        }
                        String strT15 = classReader26.t(i111, cArr5);
                        int iU38 = classReader26.u(i111 + 2);
                        if (methodWriter22.L == null) {
                            methodWriter22.L = new ByteVector2();
                        }
                        methodWriter22.K++;
                        ByteVector2 byteVector25 = methodWriter22.L;
                        byteVector25.j(strT15 == null ? 0 : methodWriter22.d.l(strT15));
                        byteVector25.j(iU38);
                        i111 += 4;
                        iF = i112;
                    }
                }
                if (i102 != 0) {
                    ByteVector2 byteVector26 = new ByteVector2();
                    methodWriter22.J = byteVector26;
                    AnnotationWriter2 annotationWriter2 = new AnnotationWriter2(methodWriter22.d, false, byteVector26, null);
                    classReader26.j(annotationWriter2, i102, null, cArr5);
                    annotationWriter2.g();
                }
                int i113 = i90;
                if (i113 != 0) {
                    int iU39 = classReader26.u(i113);
                    int iK9 = i113 + 2;
                    while (true) {
                        int i114 = iU39 - 1;
                        if (iU39 <= 0) {
                            break;
                        }
                        iK9 = classReader26.k(methodVisitor2E.a(classReader26.t(iK9, cArr5), true), iK9 + 2, true, cArr5);
                        iU39 = i114;
                    }
                }
                int i115 = i91;
                if (i115 != 0) {
                    int iU40 = classReader26.u(i115);
                    int iK10 = i115 + 2;
                    while (true) {
                        int i116 = iU40 - 1;
                        if (iU40 <= 0) {
                            break;
                        }
                        iK10 = classReader26.k(methodVisitor2E.a(classReader26.t(iK10, cArr5), false), iK10 + 2, true, cArr5);
                        iU40 = i116;
                    }
                }
                int i117 = i92;
                if (i117 != 0) {
                    int iU41 = classReader26.u(i117);
                    int iK11 = i117 + 2;
                    while (true) {
                        int i118 = iU41 - 1;
                        if (iU41 <= 0) {
                            break;
                        }
                        int iR5 = classReader26.r(context37, iK11);
                        iK11 = classReader26.k(methodVisitor2E.r(context37.h, context37.i, classReader26.t(iR5, cArr5), true), iR5 + 2, true, cArr5);
                        iU41 = i118;
                    }
                }
                int i119 = i93;
                if (i119 != 0) {
                    int iU42 = classReader26.u(i119);
                    int iK12 = i119 + 2;
                    while (true) {
                        int i120 = iU42 - 1;
                        if (iU42 <= 0) {
                            break;
                        }
                        int iR6 = classReader26.r(context37, iK12);
                        iK12 = classReader26.k(methodVisitor2E.r(context37.h, context37.i, classReader26.t(iR6, cArr5), false), iR6 + 2, true, cArr5);
                        iU42 = i120;
                    }
                }
                int i121 = i94;
                if (i121 != 0) {
                    classReader26.p(methodVisitor2E, context37, i121, true);
                }
                int i122 = i95;
                if (i122 != 0) {
                    classReader26.p(methodVisitor2E, context37, i122, false);
                }
                Attribute2 attribute210 = attribute29;
                while (attribute210 != null) {
                    Attribute2 attribute211 = attribute210.c;
                    attribute210.c = null;
                    attribute210.c = methodWriter22.M;
                    methodWriter22.M = attribute210;
                    attribute210 = attribute211;
                }
                int i123 = i96;
                if (i123 != 0) {
                    classReader26.h(methodVisitor2E, context37, i123);
                }
            }
            iU33 = i83;
            i82 = i86;
            classReader25 = classReader26;
            context36 = context37;
            str54 = str66;
            str50 = str63;
            str55 = str59;
            str56 = str58;
            str53 = str62;
            str52 = str61;
            i81 = 1;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:337:0x06b3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public byte[] b() throws MethodTooLargeException, ClassTooLargeException {
        int iA;
        int i;
        String str;
        int i2;
        String str2;
        String str3;
        int i3;
        int i4;
        int i5;
        String str4;
        String str5;
        int i6;
        int i7;
        int iA2;
        int iA3;
        int iA4 = (this.f * 2) + 24;
        FieldWriter2 fieldWriter2 = this.h;
        int i8 = 0;
        while (true) {
            iA = 16;
            if (fieldWriter2 == null) {
                break;
            }
            i8++;
            if (fieldWriter2.g != 0) {
                fieldWriter2.f3710b.l("ConstantValue");
            } else {
                iA = 8;
            }
            if ((fieldWriter2.c & 4096) != 0) {
                SymbolTable2 symbolTable2 = fieldWriter2.f3710b;
                if (symbolTable2.c < 49) {
                    symbolTable2.l("Synthetic");
                    iA += 6;
                }
            }
            if (fieldWriter2.f != 0) {
                fieldWriter2.f3710b.l("Signature");
                iA += 8;
            }
            if ((fieldWriter2.c & 131072) != 0) {
                fieldWriter2.f3710b.l("Deprecated");
                iA += 6;
            }
            AnnotationWriter2 annotationWriter2 = fieldWriter2.h;
            if (annotationWriter2 != null) {
                iA += annotationWriter2.a("RuntimeVisibleAnnotations");
            }
            AnnotationWriter2 annotationWriter22 = fieldWriter2.i;
            if (annotationWriter22 != null) {
                iA += annotationWriter22.a("RuntimeInvisibleAnnotations");
            }
            AnnotationWriter2 annotationWriter23 = fieldWriter2.j;
            if (annotationWriter23 != null) {
                iA += annotationWriter23.a("RuntimeVisibleTypeAnnotations");
            }
            AnnotationWriter2 annotationWriter24 = fieldWriter2.k;
            if (annotationWriter24 != null) {
                iA += annotationWriter24.a("RuntimeInvisibleTypeAnnotations");
            }
            Attribute2 attribute2 = fieldWriter2.l;
            if (attribute2 != null) {
                iA += attribute2.a(fieldWriter2.f3710b);
            }
            iA4 += iA;
            fieldWriter2 = (FieldWriter2) fieldWriter2.a;
        }
        MethodWriter2 methodWriter2 = this.j;
        int i9 = 0;
        while (true) {
            if (methodWriter2 == null) {
                ByteVector2 byteVector2 = this.m;
                if (byteVector2 != null) {
                    iA4 += byteVector2.f3699b + 8;
                    this.f3701b.l("InnerClasses");
                    i = 1;
                } else {
                    i = 0;
                }
                if (this.n != 0) {
                    i++;
                    iA4 += 10;
                    this.f3701b.l("EnclosingMethod");
                }
                if ((this.c & 4096) != 0) {
                    str = "EnclosingMethod";
                    if ((this.a & 65535) < 49) {
                        i++;
                        iA4 += 6;
                        this.f3701b.l("Synthetic");
                    }
                } else {
                    str = "EnclosingMethod";
                }
                if (this.p != 0) {
                    i++;
                    iA4 += 8;
                    this.f3701b.l("Signature");
                }
                if (this.q != 0) {
                    i++;
                    iA4 += 8;
                    this.f3701b.l("SourceFile");
                }
                ByteVector2 byteVector22 = this.r;
                if (byteVector22 != null) {
                    i++;
                    iA4 += byteVector22.f3699b + 6;
                    this.f3701b.l("SourceDebugExtension");
                }
                if ((this.c & 131072) != 0) {
                    i++;
                    iA4 += 6;
                    this.f3701b.l("Deprecated");
                }
                AnnotationWriter2 annotationWriter25 = this.f3702s;
                if (annotationWriter25 != null) {
                    i++;
                    iA4 += annotationWriter25.a("RuntimeVisibleAnnotations");
                }
                AnnotationWriter2 annotationWriter26 = this.t;
                if (annotationWriter26 != null) {
                    i++;
                    iA4 += annotationWriter26.a("RuntimeInvisibleAnnotations");
                }
                AnnotationWriter2 annotationWriter27 = this.u;
                if (annotationWriter27 != null) {
                    i++;
                    iA4 += annotationWriter27.a("RuntimeVisibleTypeAnnotations");
                }
                AnnotationWriter2 annotationWriter28 = this.v;
                if (annotationWriter28 != null) {
                    i++;
                    iA4 += annotationWriter28.a("RuntimeInvisibleTypeAnnotations");
                }
                SymbolTable2 symbolTable22 = this.f3701b;
                if (symbolTable22.j != null) {
                    symbolTable22.l("BootstrapMethods");
                    i2 = symbolTable22.j.f3699b + 8;
                } else {
                    i2 = 0;
                }
                if (i2 > 0) {
                    i++;
                    SymbolTable2 symbolTable23 = this.f3701b;
                    if (symbolTable23.j != null) {
                        symbolTable23.l("BootstrapMethods");
                        i6 = symbolTable23.j.f3699b + 8;
                    } else {
                        i6 = 0;
                    }
                    iA4 += i6;
                }
                ModuleWriter2 moduleWriter2 = this.w;
                String str6 = "ModuleMainClass";
                int i10 = i9;
                if (moduleWriter2 != null) {
                    str2 = "RuntimeInvisibleTypeAnnotations";
                    str3 = "RuntimeVisibleTypeAnnotations";
                    i += (moduleWriter2.o > 0 ? 1 : 0) + 1 + (moduleWriter2.q > 0 ? 1 : 0);
                    moduleWriter2.a.l("Module");
                    int i11 = moduleWriter2.f.f3699b + 22 + moduleWriter2.h.f3699b + moduleWriter2.j.f3699b + moduleWriter2.l.f3699b + moduleWriter2.n.f3699b;
                    if (moduleWriter2.o > 0) {
                        moduleWriter2.a.l("ModulePackages");
                        i11 += moduleWriter2.p.f3699b + 8;
                    }
                    if (moduleWriter2.q > 0) {
                        moduleWriter2.a.l("ModuleMainClass");
                        i11 += 8;
                    }
                    iA4 += i11;
                } else {
                    str2 = "RuntimeInvisibleTypeAnnotations";
                    str3 = "RuntimeVisibleTypeAnnotations";
                }
                if (this.f3703x != 0) {
                    i++;
                    iA4 += 8;
                    this.f3701b.l("NestHost");
                }
                ByteVector2 byteVector23 = this.f3705z;
                if (byteVector23 != null) {
                    i++;
                    iA4 += byteVector23.f3699b + 8;
                    this.f3701b.l("NestMembers");
                }
                Attribute2 attribute22 = this.A;
                if (attribute22 != null) {
                    int iC = i + attribute22.c();
                    iA4 += this.A.a(this.f3701b);
                    i = iC;
                }
                SymbolTable2 symbolTable24 = this.f3701b;
                int i12 = iA4 + symbolTable24.h.f3699b;
                int i13 = symbolTable24.g;
                if (i13 > 65535) {
                    throw new ClassTooLargeException(this.f3701b.d, i13);
                }
                ByteVector2 byteVector24 = new ByteVector2(i12);
                byteVector24.i(-889275714);
                byteVector24.i(this.a);
                SymbolTable2 symbolTable25 = this.f3701b;
                byteVector24.j(symbolTable25.g);
                ByteVector2 byteVector25 = symbolTable25.h;
                byteVector24.h(byteVector25.a, 0, byteVector25.f3699b);
                byteVector24.j((~((this.a & 65535) < 49 ? 4096 : 0)) & this.c);
                byteVector24.j(this.d);
                byteVector24.j(this.e);
                byteVector24.j(this.f);
                for (int i14 = 0; i14 < this.f; i14++) {
                    byteVector24.j(this.g[i14]);
                }
                byteVector24.j(i8);
                FieldWriter2 fieldWriter22 = this.h;
                while (fieldWriter22 != null) {
                    boolean z2 = fieldWriter22.f3710b.c < 49;
                    byteVector24.j((~(z2 ? 4096 : 0)) & fieldWriter22.c);
                    byteVector24.j(fieldWriter22.d);
                    byteVector24.j(fieldWriter22.e);
                    int iC2 = fieldWriter22.g != 0 ? 1 : 0;
                    int i15 = fieldWriter22.c;
                    String str7 = str6;
                    if ((i15 & 4096) != 0 && z2) {
                        iC2++;
                    }
                    if (fieldWriter22.f != 0) {
                        iC2++;
                    }
                    if ((i15 & 131072) != 0) {
                        iC2++;
                    }
                    if (fieldWriter22.h != null) {
                        iC2++;
                    }
                    if (fieldWriter22.i != null) {
                        iC2++;
                    }
                    if (fieldWriter22.j != null) {
                        iC2++;
                    }
                    if (fieldWriter22.k != null) {
                        iC2++;
                    }
                    Attribute2 attribute23 = fieldWriter22.l;
                    if (attribute23 != null) {
                        iC2 += attribute23.c();
                    }
                    byteVector24.j(iC2);
                    if (fieldWriter22.g != 0) {
                        outline.t0(fieldWriter22.f3710b, "ConstantValue", byteVector24, 2);
                        byteVector24.j(fieldWriter22.g);
                    }
                    if ((fieldWriter22.c & 4096) != 0 && z2) {
                        outline.t0(fieldWriter22.f3710b, "Synthetic", byteVector24, 0);
                    }
                    if (fieldWriter22.f != 0) {
                        outline.t0(fieldWriter22.f3710b, "Signature", byteVector24, 2);
                        byteVector24.j(fieldWriter22.f);
                    }
                    if ((fieldWriter22.c & 131072) != 0) {
                        outline.t0(fieldWriter22.f3710b, "Deprecated", byteVector24, 0);
                    }
                    AnnotationWriter2 annotationWriter29 = fieldWriter22.h;
                    if (annotationWriter29 != null) {
                        annotationWriter29.c(fieldWriter22.f3710b.l("RuntimeVisibleAnnotations"), byteVector24);
                    }
                    AnnotationWriter2 annotationWriter210 = fieldWriter22.i;
                    if (annotationWriter210 != null) {
                        annotationWriter210.c(fieldWriter22.f3710b.l("RuntimeInvisibleAnnotations"), byteVector24);
                    }
                    AnnotationWriter2 annotationWriter211 = fieldWriter22.j;
                    if (annotationWriter211 != null) {
                        str4 = str3;
                        annotationWriter211.c(fieldWriter22.f3710b.l(str4), byteVector24);
                    } else {
                        str4 = str3;
                    }
                    AnnotationWriter2 annotationWriter212 = fieldWriter22.k;
                    if (annotationWriter212 != null) {
                        str5 = str2;
                        annotationWriter212.c(fieldWriter22.f3710b.l(str5), byteVector24);
                    } else {
                        str5 = str2;
                    }
                    Attribute2 attribute24 = fieldWriter22.l;
                    if (attribute24 != null) {
                        attribute24.d(fieldWriter22.f3710b, byteVector24);
                    }
                    fieldWriter22 = (FieldWriter2) fieldWriter22.a;
                    str3 = str4;
                    str2 = str5;
                    str6 = str7;
                }
                String str8 = str6;
                String str9 = str2;
                String str10 = str3;
                byteVector24.j(i10);
                boolean z3 = false;
                boolean z4 = false;
                for (MethodWriter2 methodWriter22 = this.j; methodWriter22 != null; methodWriter22 = (MethodWriter2) methodWriter22.f3715b) {
                    z4 |= methodWriter22.u > 0;
                    z3 |= methodWriter22.Y;
                    methodWriter22.y(byteVector24);
                }
                byteVector24.j(i);
                if (this.m != null) {
                    byteVector24.j(this.f3701b.l("InnerClasses"));
                    byteVector24.i(this.m.f3699b + 2);
                    byteVector24.j(this.l);
                    ByteVector2 byteVector26 = this.m;
                    byteVector24.h(byteVector26.a, 0, byteVector26.f3699b);
                }
                if (this.n != 0) {
                    outline.t0(this.f3701b, str, byteVector24, 4);
                    byteVector24.j(this.n);
                    byteVector24.j(this.o);
                }
                if ((this.c & 4096) != 0 && (this.a & 65535) < 49) {
                    outline.t0(this.f3701b, "Synthetic", byteVector24, 0);
                }
                if (this.p != 0) {
                    i3 = 2;
                    outline.t0(this.f3701b, "Signature", byteVector24, 2);
                    byteVector24.j(this.p);
                } else {
                    i3 = 2;
                }
                if (this.q != 0) {
                    outline.t0(this.f3701b, "SourceFile", byteVector24, i3);
                    byteVector24.j(this.q);
                }
                ByteVector2 byteVector27 = this.r;
                if (byteVector27 != null) {
                    int i16 = byteVector27.f3699b;
                    outline.t0(this.f3701b, "SourceDebugExtension", byteVector24, i16);
                    i4 = 0;
                    byteVector24.h(this.r.a, 0, i16);
                } else {
                    i4 = 0;
                }
                if ((this.c & 131072) != 0) {
                    outline.t0(this.f3701b, "Deprecated", byteVector24, i4);
                }
                AnnotationWriter2 annotationWriter213 = this.f3702s;
                if (annotationWriter213 != null) {
                    annotationWriter213.c(this.f3701b.l("RuntimeVisibleAnnotations"), byteVector24);
                }
                AnnotationWriter2 annotationWriter214 = this.t;
                if (annotationWriter214 != null) {
                    annotationWriter214.c(this.f3701b.l("RuntimeInvisibleAnnotations"), byteVector24);
                }
                AnnotationWriter2 annotationWriter215 = this.u;
                if (annotationWriter215 != null) {
                    annotationWriter215.c(this.f3701b.l(str10), byteVector24);
                }
                AnnotationWriter2 annotationWriter216 = this.v;
                if (annotationWriter216 != null) {
                    annotationWriter216.c(this.f3701b.l(str9), byteVector24);
                }
                SymbolTable2 symbolTable26 = this.f3701b;
                if (symbolTable26.j != null) {
                    byteVector24.j(symbolTable26.l("BootstrapMethods"));
                    byteVector24.i(symbolTable26.j.f3699b + 2);
                    byteVector24.j(symbolTable26.i);
                    ByteVector2 byteVector28 = symbolTable26.j;
                    byteVector24.h(byteVector28.a, 0, byteVector28.f3699b);
                }
                ModuleWriter2 moduleWriter22 = this.w;
                if (moduleWriter22 != null) {
                    outline.t0(moduleWriter22.a, "Module", byteVector24, moduleWriter22.f.f3699b + 16 + moduleWriter22.h.f3699b + moduleWriter22.j.f3699b + moduleWriter22.l.f3699b + moduleWriter22.n.f3699b);
                    byteVector24.j(moduleWriter22.f3722b);
                    byteVector24.j(moduleWriter22.c);
                    byteVector24.j(moduleWriter22.d);
                    byteVector24.j(moduleWriter22.e);
                    ByteVector2 byteVector29 = moduleWriter22.f;
                    byteVector24.h(byteVector29.a, 0, byteVector29.f3699b);
                    byteVector24.j(moduleWriter22.g);
                    ByteVector2 byteVector210 = moduleWriter22.h;
                    byteVector24.h(byteVector210.a, 0, byteVector210.f3699b);
                    byteVector24.j(moduleWriter22.i);
                    ByteVector2 byteVector211 = moduleWriter22.j;
                    byteVector24.h(byteVector211.a, 0, byteVector211.f3699b);
                    byteVector24.j(moduleWriter22.k);
                    ByteVector2 byteVector212 = moduleWriter22.l;
                    byteVector24.h(byteVector212.a, 0, byteVector212.f3699b);
                    byteVector24.j(moduleWriter22.m);
                    ByteVector2 byteVector213 = moduleWriter22.n;
                    byteVector24.h(byteVector213.a, 0, byteVector213.f3699b);
                    if (moduleWriter22.o > 0) {
                        byteVector24.j(moduleWriter22.a.l("ModulePackages"));
                        byteVector24.i(moduleWriter22.p.f3699b + 2);
                        byteVector24.j(moduleWriter22.o);
                        ByteVector2 byteVector214 = moduleWriter22.p;
                        byteVector24.h(byteVector214.a, 0, byteVector214.f3699b);
                    }
                    if (moduleWriter22.q > 0) {
                        i5 = 2;
                        outline.t0(moduleWriter22.a, str8, byteVector24, 2);
                        byteVector24.j(moduleWriter22.q);
                    } else {
                        i5 = 2;
                    }
                }
                if (this.f3703x != 0) {
                    outline.t0(this.f3701b, "NestHost", byteVector24, i5);
                    byteVector24.j(this.f3703x);
                }
                if (this.f3705z != null) {
                    byteVector24.j(this.f3701b.l("NestMembers"));
                    byteVector24.i(this.f3705z.f3699b + 2);
                    byteVector24.j(this.f3704y);
                    ByteVector2 byteVector215 = this.f3705z;
                    byteVector24.h(byteVector215.a, 0, byteVector215.f3699b);
                }
                Attribute2 attribute25 = this.A;
                if (attribute25 != null) {
                    attribute25.d(this.f3701b, byteVector24);
                }
                return z3 ? a(byteVector24.a, z4) : byteVector24.a;
            }
            int i17 = i9 + 1;
            if (methodWriter2.f3716a0 != 0) {
                iA3 = methodWriter2.f3717b0 + 6;
                i7 = i17;
            } else {
                int i18 = methodWriter2.l.f3699b;
                if (i18 <= 0) {
                    i7 = i17;
                    iA2 = 8;
                } else {
                    if (i18 > 65535) {
                        throw new MethodTooLargeException(methodWriter2.d.d, methodWriter2.g, methodWriter2.i, methodWriter2.l.f3699b);
                    }
                    methodWriter2.d.l("Code");
                    int i19 = methodWriter2.l.f3699b + iA;
                    int i20 = 0;
                    for (Handler5 handler5 = methodWriter2.m; handler5 != null; handler5 = handler5.f) {
                        i20++;
                    }
                    iA2 = (i20 * 8) + 2 + i19 + 8;
                    if (methodWriter2.v != null) {
                        SymbolTable2 symbolTable27 = methodWriter2.d;
                        i7 = i17;
                        symbolTable27.l(symbolTable27.c >= 50 ? "StackMapTable" : "StackMap");
                        iA2 += methodWriter2.v.f3699b + 8;
                    } else {
                        i7 = i17;
                    }
                    if (methodWriter2.p != null) {
                        methodWriter2.d.l("LineNumberTable");
                        iA2 += methodWriter2.p.f3699b + 8;
                    }
                    if (methodWriter2.r != null) {
                        methodWriter2.d.l("LocalVariableTable");
                        iA2 += methodWriter2.r.f3699b + 8;
                    }
                    if (methodWriter2.t != null) {
                        methodWriter2.d.l("LocalVariableTypeTable");
                        iA2 += methodWriter2.t.f3699b + 8;
                    }
                    AnnotationWriter2 annotationWriter217 = methodWriter2.w;
                    if (annotationWriter217 != null) {
                        iA2 += annotationWriter217.a("RuntimeVisibleTypeAnnotations");
                    }
                    AnnotationWriter2 annotationWriter218 = methodWriter2.f3719x;
                    if (annotationWriter218 != null) {
                        iA2 += annotationWriter218.a("RuntimeInvisibleTypeAnnotations");
                    }
                }
                if (methodWriter2.f3720y > 0) {
                    methodWriter2.d.l("Exceptions");
                    iA2 += (methodWriter2.f3720y * 2) + 8;
                }
                SymbolTable2 symbolTable28 = methodWriter2.d;
                boolean z5 = symbolTable28.c < 49;
                if ((methodWriter2.e & 4096) != 0 && z5) {
                    symbolTable28.l("Synthetic");
                    iA2 += 6;
                }
                if (methodWriter2.A != 0) {
                    methodWriter2.d.l("Signature");
                    iA2 += 8;
                }
                if ((methodWriter2.e & 131072) != 0) {
                    methodWriter2.d.l("Deprecated");
                    iA2 += 6;
                }
                AnnotationWriter2 annotationWriter219 = methodWriter2.B;
                if (annotationWriter219 != null) {
                    iA2 += annotationWriter219.a("RuntimeVisibleAnnotations");
                }
                AnnotationWriter2 annotationWriter220 = methodWriter2.C;
                if (annotationWriter220 != null) {
                    iA2 += annotationWriter220.a("RuntimeInvisibleAnnotations");
                }
                AnnotationWriter2[] annotationWriter2Arr = methodWriter2.E;
                if (annotationWriter2Arr != null) {
                    int length = methodWriter2.D;
                    if (length == 0) {
                        length = annotationWriter2Arr.length;
                    }
                    iA2 += AnnotationWriter2.b("RuntimeVisibleParameterAnnotations", annotationWriter2Arr, length);
                }
                AnnotationWriter2[] annotationWriter2Arr2 = methodWriter2.G;
                if (annotationWriter2Arr2 != null) {
                    int length2 = methodWriter2.F;
                    if (length2 == 0) {
                        length2 = annotationWriter2Arr2.length;
                    }
                    iA2 += AnnotationWriter2.b("RuntimeInvisibleParameterAnnotations", annotationWriter2Arr2, length2);
                }
                AnnotationWriter2 annotationWriter221 = methodWriter2.H;
                if (annotationWriter221 != null) {
                    iA2 += annotationWriter221.a("RuntimeVisibleTypeAnnotations");
                }
                AnnotationWriter2 annotationWriter222 = methodWriter2.I;
                if (annotationWriter222 != null) {
                    iA2 += annotationWriter222.a("RuntimeInvisibleTypeAnnotations");
                }
                if (methodWriter2.J != null) {
                    methodWriter2.d.l("AnnotationDefault");
                    iA2 += methodWriter2.J.f3699b + 6;
                }
                if (methodWriter2.L != null) {
                    methodWriter2.d.l("MethodParameters");
                    iA3 = methodWriter2.L.f3699b + 7 + iA2;
                } else {
                    iA3 = iA2;
                }
                Attribute2 attribute26 = methodWriter2.M;
                if (attribute26 != null) {
                    iA3 += attribute26.a(methodWriter2.d);
                }
            }
            iA4 += iA3;
            methodWriter2 = (MethodWriter2) methodWriter2.f3715b;
            iA = 16;
            i9 = i7;
        }
    }

    public final void c(int i, int i2, String str, String str2, String str3, String[] strArr) {
        this.a = i;
        this.c = i2;
        SymbolTable2 symbolTable2 = this.f3701b;
        int i3 = i & 65535;
        symbolTable2.c = i3;
        symbolTable2.d = str;
        this.d = symbolTable2.m(7, str).a;
        if (str2 != null) {
            this.p = this.f3701b.l(str2);
        }
        this.e = str3 == null ? 0 : this.f3701b.m(7, str3).a;
        if (strArr != null && strArr.length > 0) {
            int length = strArr.length;
            this.f = length;
            this.g = new int[length];
            for (int i4 = 0; i4 < this.f; i4++) {
                this.g[i4] = this.f3701b.c(strArr[i4]).a;
            }
        }
        if (this.B != 1 || i3 < 51) {
            return;
        }
        this.B = 2;
    }

    public final AnnotationWriter2 d(String str, boolean z2) {
        ByteVector2 byteVector2 = new ByteVector2();
        byteVector2.j(this.f3701b.l(str));
        byteVector2.j(0);
        if (z2) {
            AnnotationWriter2 annotationWriter2 = new AnnotationWriter2(this.f3701b, true, byteVector2, this.f3702s);
            this.f3702s = annotationWriter2;
            return annotationWriter2;
        }
        AnnotationWriter2 annotationWriter22 = new AnnotationWriter2(this.f3701b, true, byteVector2, this.t);
        this.t = annotationWriter22;
        return annotationWriter22;
    }

    public final MethodVisitor2 e(int i, String str, String str2, String str3, String[] strArr) {
        MethodWriter2 methodWriter2 = new MethodWriter2(this.f3701b, i, str, str2, str3, strArr, this.B);
        if (this.j == null) {
            this.j = methodWriter2;
        } else {
            this.k.f3715b = methodWriter2;
        }
        this.k = methodWriter2;
        return methodWriter2;
    }

    public final AnnotationWriter2 f(int i, TypePath2 typePath2, String str, boolean z2) {
        ByteVector2 byteVector2 = new ByteVector2();
        b.i.a.f.e.o.f.W0(i, byteVector2);
        TypePath2.a(typePath2, byteVector2);
        byteVector2.j(this.f3701b.l(str));
        byteVector2.j(0);
        if (z2) {
            AnnotationWriter2 annotationWriter2 = new AnnotationWriter2(this.f3701b, true, byteVector2, this.u);
            this.u = annotationWriter2;
            return annotationWriter2;
        }
        AnnotationWriter2 annotationWriter22 = new AnnotationWriter2(this.f3701b, true, byteVector2, this.v);
        this.v = annotationWriter22;
        return annotationWriter22;
    }
}
