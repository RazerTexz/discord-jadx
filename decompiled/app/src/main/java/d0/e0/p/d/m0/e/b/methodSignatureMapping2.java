package d0.e0.p.d.m0.e.b;

import androidx.exifinterface.media.ExifInterface;
import b.d.b.a.outline;
import d0.e0.p.d.m0.b.PrimitiveType;
import d0.e0.p.d.m0.e.b.methodSignatureMapping;
import d0.e0.p.d.m0.k.y.JvmClassName;
import d0.e0.p.d.m0.k.y.JvmPrimitiveType;
import d0.g0.Strings4;
import d0.z.d.Intrinsics3;
import kotlin.NoWhenBranchMatchedException;

/* compiled from: methodSignatureMapping.kt */
/* renamed from: d0.e0.p.d.m0.e.b.m, reason: use source file name */
/* loaded from: classes3.dex */
public final class methodSignatureMapping2 implements typeSignatureMapping3<methodSignatureMapping> {
    public static final methodSignatureMapping2 a = new methodSignatureMapping2();

    @Override // d0.e0.p.d.m0.e.b.typeSignatureMapping3
    public /* bridge */ /* synthetic */ methodSignatureMapping boxType(methodSignatureMapping methodsignaturemapping) {
        return boxType2(methodsignaturemapping);
    }

    @Override // d0.e0.p.d.m0.e.b.typeSignatureMapping3
    public /* bridge */ /* synthetic */ methodSignatureMapping createFromString(String str) {
        return createFromString(str);
    }

    @Override // d0.e0.p.d.m0.e.b.typeSignatureMapping3
    /* renamed from: createObjectType, reason: avoid collision after fix types in other method */
    public /* bridge */ /* synthetic */ methodSignatureMapping createObjectType2(String str) {
        return createObjectType(str);
    }

    @Override // d0.e0.p.d.m0.e.b.typeSignatureMapping3
    public /* bridge */ /* synthetic */ methodSignatureMapping createPrimitiveType(PrimitiveType primitiveType) {
        return createPrimitiveType(primitiveType);
    }

    @Override // d0.e0.p.d.m0.e.b.typeSignatureMapping3
    public /* bridge */ /* synthetic */ methodSignatureMapping getJavaLangClassType() {
        return getJavaLangClassType();
    }

    @Override // d0.e0.p.d.m0.e.b.typeSignatureMapping3
    public /* bridge */ /* synthetic */ String toString(methodSignatureMapping methodsignaturemapping) {
        return toString2(methodsignaturemapping);
    }

    /* renamed from: boxType, reason: avoid collision after fix types in other method */
    public methodSignatureMapping boxType2(methodSignatureMapping methodsignaturemapping) {
        Intrinsics3.checkNotNullParameter(methodsignaturemapping, "possiblyPrimitiveType");
        if (!(methodsignaturemapping instanceof methodSignatureMapping.d)) {
            return methodsignaturemapping;
        }
        methodSignatureMapping.d dVar = (methodSignatureMapping.d) methodsignaturemapping;
        if (dVar.getJvmPrimitiveType() == null) {
            return methodsignaturemapping;
        }
        String internalName = JvmClassName.byFqNameWithoutInnerClasses(dVar.getJvmPrimitiveType().getWrapperFqName()).getInternalName();
        Intrinsics3.checkNotNullExpressionValue(internalName, "byFqNameWithoutInnerClasses(possiblyPrimitiveType.jvmPrimitiveType.wrapperFqName).internalName");
        return createObjectType(internalName);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // d0.e0.p.d.m0.e.b.typeSignatureMapping3
    public methodSignatureMapping createFromString(String str) {
        JvmPrimitiveType jvmPrimitiveType;
        methodSignatureMapping cVar;
        Intrinsics3.checkNotNullParameter(str, "representation");
        str.length();
        char cCharAt = str.charAt(0);
        JvmPrimitiveType[] jvmPrimitiveTypeArrValues = JvmPrimitiveType.values();
        int i = 0;
        while (true) {
            if (i >= 8) {
                jvmPrimitiveType = null;
                break;
            }
            jvmPrimitiveType = jvmPrimitiveTypeArrValues[i];
            if (jvmPrimitiveType.getDesc().charAt(0) == cCharAt) {
                break;
            }
            i++;
        }
        if (jvmPrimitiveType != null) {
            return new methodSignatureMapping.d(jvmPrimitiveType);
        }
        if (cCharAt == 'V') {
            return new methodSignatureMapping.d(null);
        }
        if (cCharAt == '[') {
            String strSubstring = str.substring(1);
            Intrinsics3.checkNotNullExpressionValue(strSubstring, "(this as java.lang.String).substring(startIndex)");
            cVar = new methodSignatureMapping.a(createFromString(strSubstring));
        } else {
            if (cCharAt == 'L') {
                Strings4.endsWith$default((CharSequence) str, ';', false, 2, (Object) null);
            }
            String strSubstring2 = str.substring(1, str.length() - 1);
            Intrinsics3.checkNotNullExpressionValue(strSubstring2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            cVar = new methodSignatureMapping.c(strSubstring2);
        }
        return cVar;
    }

    @Override // d0.e0.p.d.m0.e.b.typeSignatureMapping3
    public methodSignatureMapping createObjectType(String str) {
        Intrinsics3.checkNotNullParameter(str, "internalName");
        return new methodSignatureMapping.c(str);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // d0.e0.p.d.m0.e.b.typeSignatureMapping3
    public methodSignatureMapping createPrimitiveType(PrimitiveType primitiveType) {
        Intrinsics3.checkNotNullParameter(primitiveType, "primitiveType");
        switch (primitiveType) {
            case BOOLEAN:
                return methodSignatureMapping.a.getBOOLEAN$descriptors_jvm();
            case CHAR:
                return methodSignatureMapping.a.getCHAR$descriptors_jvm();
            case BYTE:
                return methodSignatureMapping.a.getBYTE$descriptors_jvm();
            case SHORT:
                return methodSignatureMapping.a.getSHORT$descriptors_jvm();
            case INT:
                return methodSignatureMapping.a.getINT$descriptors_jvm();
            case FLOAT:
                return methodSignatureMapping.a.getFLOAT$descriptors_jvm();
            case LONG:
                return methodSignatureMapping.a.getLONG$descriptors_jvm();
            case DOUBLE:
                return methodSignatureMapping.a.getDOUBLE$descriptors_jvm();
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // d0.e0.p.d.m0.e.b.typeSignatureMapping3
    public methodSignatureMapping getJavaLangClassType() {
        return createObjectType("java/lang/Class");
    }

    /* renamed from: toString, reason: avoid collision after fix types in other method */
    public String toString2(methodSignatureMapping methodsignaturemapping) {
        String desc;
        Intrinsics3.checkNotNullParameter(methodsignaturemapping, "type");
        if (methodsignaturemapping instanceof methodSignatureMapping.a) {
            return Intrinsics3.stringPlus("[", toString2(((methodSignatureMapping.a) methodsignaturemapping).getElementType()));
        }
        if (methodsignaturemapping instanceof methodSignatureMapping.d) {
            JvmPrimitiveType jvmPrimitiveType = ((methodSignatureMapping.d) methodsignaturemapping).getJvmPrimitiveType();
            return (jvmPrimitiveType == null || (desc = jvmPrimitiveType.getDesc()) == null) ? ExifInterface.GPS_MEASUREMENT_INTERRUPTED : desc;
        }
        if (!(methodsignaturemapping instanceof methodSignatureMapping.c)) {
            throw new NoWhenBranchMatchedException();
        }
        StringBuilder sbQ = outline.Q('L');
        sbQ.append(((methodSignatureMapping.c) methodsignaturemapping).getInternalName());
        sbQ.append(';');
        return sbQ.toString();
    }
}
