package d0.e0.p.d.m0.c.k1.b;

import d0.e0.p.d.m0.g.FqName;
import d0.z.JvmClassMapping;
import d0.z.d.Intrinsics3;
import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.List;

/* compiled from: ReflectJavaAnnotationOwner.kt */
/* renamed from: d0.e0.p.d.m0.c.k1.b.g, reason: use source file name */
/* loaded from: classes3.dex */
public final class ReflectJavaAnnotationOwner2 {
    public static final ReflectJavaAnnotation findAnnotation(Annotation[] annotationArr, FqName fqName) {
        Annotation annotation;
        Intrinsics3.checkNotNullParameter(annotationArr, "<this>");
        Intrinsics3.checkNotNullParameter(fqName, "fqName");
        int length = annotationArr.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                annotation = null;
                break;
            }
            annotation = annotationArr[i];
            if (Intrinsics3.areEqual(reflectClassUtil.getClassId(JvmClassMapping.getJavaClass(JvmClassMapping.getAnnotationClass(annotation))).asSingleFqName(), fqName)) {
                break;
            }
            i++;
        }
        if (annotation == null) {
            return null;
        }
        return new ReflectJavaAnnotation(annotation);
    }

    public static final List<ReflectJavaAnnotation> getAnnotations(Annotation[] annotationArr) {
        Intrinsics3.checkNotNullParameter(annotationArr, "<this>");
        ArrayList arrayList = new ArrayList(annotationArr.length);
        for (Annotation annotation : annotationArr) {
            arrayList.add(new ReflectJavaAnnotation(annotation));
        }
        return arrayList;
    }
}
