package b.e.b;

import b.d.b.a.outline;
import com.discord.widgets.chat.input.MentionUtils;
import h0.a.a.ClassWriter2;
import h0.a.a.Label2;
import h0.a.a.MethodVisitor2;
import h0.a.a.Type2;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import org.objectweb.asm.Opcodes;

/* compiled from: MethodAccess.java */
/* renamed from: b.e.b.d, reason: use source file name */
/* loaded from: classes.dex */
public abstract class MethodAccess {
    public String[] a;

    /* renamed from: b, reason: collision with root package name */
    public Class[][] f455b;

    public static void a(Class cls, ArrayList<Method> arrayList) throws SecurityException {
        for (Method method : cls.getDeclaredMethods()) {
            if (!Modifier.isPrivate(method.getModifiers())) {
                arrayList.add(method);
            }
        }
    }

    public static MethodAccess b(Class cls) throws SecurityException, ClassNotFoundException {
        Class[][] clsArr;
        String str;
        MethodVisitor2 methodVisitor2;
        Class<?> clsA;
        int i;
        Label2 label2;
        Label2[] label2Arr;
        MethodVisitor2 methodVisitor22;
        Class[][] clsArr2;
        String str2;
        Class[] clsArr3;
        ArrayList arrayList = new ArrayList();
        boolean zIsInterface = cls.isInterface();
        if (zIsInterface) {
            e(cls, arrayList);
        } else {
            for (Class superclass = cls; superclass != Object.class; superclass = superclass.getSuperclass()) {
                a(superclass, arrayList);
            }
        }
        int size = arrayList.size();
        String[] strArr = new String[size];
        Class[][] clsArr4 = new Class[size][];
        Class[] clsArr5 = new Class[size];
        for (int i2 = 0; i2 < size; i2++) {
            Method method = (Method) arrayList.get(i2);
            strArr[i2] = method.getName();
            clsArr4[i2] = method.getParameterTypes();
            clsArr5[i2] = method.getReturnType();
        }
        String name = cls.getName();
        String strW = outline.w(name, "MethodAccess");
        if (strW.startsWith("java.")) {
            strW = outline.w("reflectasm.", strW);
        }
        AccessClassLoader accessClassLoaderB = AccessClassLoader.b(cls);
        try {
            clsA = accessClassLoaderB.loadClass(strW);
            clsArr = clsArr4;
        } catch (ClassNotFoundException unused) {
            synchronized (accessClassLoaderB) {
                try {
                    clsA = accessClassLoaderB.loadClass(strW);
                    clsArr = clsArr4;
                } catch (ClassNotFoundException unused2) {
                    String strReplace = strW.replace('.', MentionUtils.SLASH_CHAR);
                    String strReplace2 = name.replace('.', MentionUtils.SLASH_CHAR);
                    ClassWriter2 classWriter2 = new ClassWriter2(1);
                    classWriter2.c(Opcodes.V1_1, 33, strReplace, null, "com/esotericsoftware/reflectasm/MethodAccess", null);
                    MethodVisitor2 methodVisitor2E = classWriter2.e(1, "<init>", "()V", null, null);
                    methodVisitor2E.t(25, 0);
                    methodVisitor2E.o(Opcodes.INVOKESPECIAL, "com/esotericsoftware/reflectasm/MethodAccess", "<init>", "()V");
                    methodVisitor2E.e(Opcodes.RETURN);
                    methodVisitor2E.n(0, 0);
                    MethodVisitor2 methodVisitor2E2 = classWriter2.e(Opcodes.LOR, "invoke", "(Ljava/lang/Object;I[Ljava/lang/Object;)Ljava/lang/Object;", null, null);
                    if (arrayList.isEmpty()) {
                        clsArr = clsArr4;
                        str = strW;
                        methodVisitor2 = methodVisitor2E2;
                    } else {
                        methodVisitor2E2.t(25, 1);
                        methodVisitor2E2.s(Opcodes.CHECKCAST, strReplace2);
                        methodVisitor2E2.t(58, 4);
                        methodVisitor2E2.t(21, 2);
                        Label2[] label2Arr2 = new Label2[size];
                        for (int i3 = 0; i3 < size; i3++) {
                            label2Arr2[i3] = new Label2();
                        }
                        Label2 label22 = new Label2();
                        methodVisitor2E2.q(0, size - 1, label22, label2Arr2);
                        StringBuilder sb = new StringBuilder(128);
                        int i4 = 0;
                        while (i4 < size) {
                            methodVisitor2E2.i(label2Arr2[i4]);
                            if (i4 == 0) {
                                i = i4;
                                label2 = label22;
                                label2Arr = label2Arr2;
                                methodVisitor22 = methodVisitor2E2;
                                methodVisitor2E2.c(1, 1, new Object[]{strReplace2}, 0, null);
                            } else {
                                i = i4;
                                label2 = label22;
                                label2Arr = label2Arr2;
                                methodVisitor22 = methodVisitor2E2;
                                methodVisitor22.c(3, 0, null, 0, null);
                            }
                            methodVisitor2E2 = methodVisitor22;
                            methodVisitor2E2.t(25, 4);
                            sb.setLength(0);
                            sb.append('(');
                            int i5 = i;
                            Class[] clsArr6 = clsArr4[i5];
                            Class cls2 = clsArr5[i5];
                            int i6 = 0;
                            int i7 = size;
                            while (i6 < clsArr6.length) {
                                Class[] clsArr7 = clsArr5;
                                methodVisitor2E2.t(25, 3);
                                methodVisitor2E2.g(16, i6);
                                methodVisitor2E2.e(50);
                                Type2 type2J = Type2.j(clsArr6[i6]);
                                switch (type2J.i()) {
                                    case 1:
                                        clsArr2 = clsArr4;
                                        str2 = strW;
                                        clsArr3 = clsArr6;
                                        methodVisitor2E2.s(Opcodes.CHECKCAST, "java/lang/Boolean");
                                        methodVisitor2E2.o(Opcodes.INVOKEVIRTUAL, "java/lang/Boolean", "booleanValue", "()Z");
                                        break;
                                    case 2:
                                        clsArr2 = clsArr4;
                                        str2 = strW;
                                        clsArr3 = clsArr6;
                                        methodVisitor2E2.s(Opcodes.CHECKCAST, "java/lang/Character");
                                        methodVisitor2E2.o(Opcodes.INVOKEVIRTUAL, "java/lang/Character", "charValue", "()C");
                                        break;
                                    case 3:
                                        clsArr2 = clsArr4;
                                        str2 = strW;
                                        clsArr3 = clsArr6;
                                        methodVisitor2E2.s(Opcodes.CHECKCAST, "java/lang/Byte");
                                        methodVisitor2E2.o(Opcodes.INVOKEVIRTUAL, "java/lang/Byte", "byteValue", "()B");
                                        break;
                                    case 4:
                                        clsArr2 = clsArr4;
                                        str2 = strW;
                                        clsArr3 = clsArr6;
                                        methodVisitor2E2.s(Opcodes.CHECKCAST, "java/lang/Short");
                                        methodVisitor2E2.o(Opcodes.INVOKEVIRTUAL, "java/lang/Short", "shortValue", "()S");
                                        break;
                                    case 5:
                                        clsArr2 = clsArr4;
                                        str2 = strW;
                                        clsArr3 = clsArr6;
                                        methodVisitor2E2.s(Opcodes.CHECKCAST, "java/lang/Integer");
                                        methodVisitor2E2.o(Opcodes.INVOKEVIRTUAL, "java/lang/Integer", "intValue", "()I");
                                        break;
                                    case 6:
                                        clsArr2 = clsArr4;
                                        str2 = strW;
                                        clsArr3 = clsArr6;
                                        methodVisitor2E2.s(Opcodes.CHECKCAST, "java/lang/Float");
                                        methodVisitor2E2.o(Opcodes.INVOKEVIRTUAL, "java/lang/Float", "floatValue", "()F");
                                        break;
                                    case 7:
                                        clsArr2 = clsArr4;
                                        str2 = strW;
                                        clsArr3 = clsArr6;
                                        methodVisitor2E2.s(Opcodes.CHECKCAST, "java/lang/Long");
                                        methodVisitor2E2.o(Opcodes.INVOKEVIRTUAL, "java/lang/Long", "longValue", "()J");
                                        break;
                                    case 8:
                                        clsArr3 = clsArr6;
                                        methodVisitor2E2.s(Opcodes.CHECKCAST, "java/lang/Double");
                                        clsArr2 = clsArr4;
                                        str2 = strW;
                                        methodVisitor2E2.o(Opcodes.INVOKEVIRTUAL, "java/lang/Double", "doubleValue", "()D");
                                        break;
                                    case 9:
                                        clsArr3 = clsArr6;
                                        methodVisitor2E2.s(Opcodes.CHECKCAST, type2J.d());
                                        clsArr2 = clsArr4;
                                        str2 = strW;
                                        break;
                                    case 10:
                                        clsArr3 = clsArr6;
                                        methodVisitor2E2.s(Opcodes.CHECKCAST, type2J.g());
                                        clsArr2 = clsArr4;
                                        str2 = strW;
                                        break;
                                    default:
                                        clsArr2 = clsArr4;
                                        str2 = strW;
                                        clsArr3 = clsArr6;
                                        break;
                                }
                                sb.append(type2J.d());
                                i6++;
                                clsArr6 = clsArr3;
                                clsArr5 = clsArr7;
                                clsArr4 = clsArr2;
                                strW = str2;
                            }
                            Class[][] clsArr8 = clsArr4;
                            Class[] clsArr9 = clsArr5;
                            String str3 = strW;
                            sb.append(')');
                            sb.append(Type2.e(cls2));
                            methodVisitor2E2.o(zIsInterface ? Opcodes.INVOKEINTERFACE : Modifier.isStatic(((Method) arrayList.get(i5)).getModifiers()) ? Opcodes.INVOKESTATIC : Opcodes.INVOKEVIRTUAL, strReplace2, strArr[i5], sb.toString());
                            switch (Type2.j(cls2).i()) {
                                case 0:
                                    methodVisitor2E2.e(1);
                                    break;
                                case 1:
                                    methodVisitor2E2.o(Opcodes.INVOKESTATIC, "java/lang/Boolean", "valueOf", "(Z)Ljava/lang/Boolean;");
                                    break;
                                case 2:
                                    methodVisitor2E2.o(Opcodes.INVOKESTATIC, "java/lang/Character", "valueOf", "(C)Ljava/lang/Character;");
                                    break;
                                case 3:
                                    methodVisitor2E2.o(Opcodes.INVOKESTATIC, "java/lang/Byte", "valueOf", "(B)Ljava/lang/Byte;");
                                    break;
                                case 4:
                                    methodVisitor2E2.o(Opcodes.INVOKESTATIC, "java/lang/Short", "valueOf", "(S)Ljava/lang/Short;");
                                    break;
                                case 5:
                                    methodVisitor2E2.o(Opcodes.INVOKESTATIC, "java/lang/Integer", "valueOf", "(I)Ljava/lang/Integer;");
                                    break;
                                case 6:
                                    methodVisitor2E2.o(Opcodes.INVOKESTATIC, "java/lang/Float", "valueOf", "(F)Ljava/lang/Float;");
                                    break;
                                case 7:
                                    methodVisitor2E2.o(Opcodes.INVOKESTATIC, "java/lang/Long", "valueOf", "(J)Ljava/lang/Long;");
                                    break;
                                case 8:
                                    methodVisitor2E2.o(Opcodes.INVOKESTATIC, "java/lang/Double", "valueOf", "(D)Ljava/lang/Double;");
                                    break;
                            }
                            methodVisitor2E2.e(Opcodes.ARETURN);
                            i4 = i5 + 1;
                            size = i7;
                            label2Arr2 = label2Arr;
                            clsArr5 = clsArr9;
                            clsArr4 = clsArr8;
                            strW = str3;
                            label22 = label2;
                        }
                        clsArr = clsArr4;
                        str = strW;
                        methodVisitor2E2.i(label22);
                        methodVisitor2 = methodVisitor2E2;
                        methodVisitor2E2.c(3, 0, null, 0, null);
                    }
                    methodVisitor2.s(Opcodes.NEW, "java/lang/IllegalArgumentException");
                    methodVisitor2.e(89);
                    methodVisitor2.s(Opcodes.NEW, "java/lang/StringBuilder");
                    methodVisitor2.e(89);
                    methodVisitor2.j("Method not found: ");
                    methodVisitor2.o(Opcodes.INVOKESPECIAL, "java/lang/StringBuilder", "<init>", "(Ljava/lang/String;)V");
                    methodVisitor2.t(21, 2);
                    methodVisitor2.o(Opcodes.INVOKEVIRTUAL, "java/lang/StringBuilder", "append", "(I)Ljava/lang/StringBuilder;");
                    methodVisitor2.o(Opcodes.INVOKEVIRTUAL, "java/lang/StringBuilder", "toString", "()Ljava/lang/String;");
                    methodVisitor2.o(Opcodes.INVOKESPECIAL, "java/lang/IllegalArgumentException", "<init>", "(Ljava/lang/String;)V");
                    methodVisitor2.e(Opcodes.ATHROW);
                    methodVisitor2.n(0, 0);
                    strW = str;
                    clsA = accessClassLoaderB.a(strW, classWriter2.b());
                }
            }
        }
        try {
            MethodAccess methodAccess = (MethodAccess) clsA.newInstance();
            methodAccess.a = strArr;
            methodAccess.f455b = clsArr;
            return methodAccess;
        } catch (Throwable th) {
            throw new RuntimeException(outline.w("Error constructing method access class: ", strW), th);
        }
    }

    public static void e(Class cls, ArrayList<Method> arrayList) throws SecurityException {
        a(cls, arrayList);
        for (Class<?> cls2 : cls.getInterfaces()) {
            e(cls2, arrayList);
        }
    }

    public int c(String str, Class... clsArr) {
        int length = this.a.length;
        for (int i = 0; i < length; i++) {
            if (this.a[i].equals(str) && Arrays.equals(clsArr, this.f455b[i])) {
                return i;
            }
        }
        StringBuilder sbY = outline.Y("Unable to find non-private method: ", str, " ");
        sbY.append(Arrays.toString(clsArr));
        throw new IllegalArgumentException(sbY.toString());
    }

    public abstract Object d(Object obj, int i, Object... objArr);
}
