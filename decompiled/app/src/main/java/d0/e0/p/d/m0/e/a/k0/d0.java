package d0.e0.p.d.m0.e.a.k0;

import d0.e0.p.d.m0.g.ClassId;
import d0.e0.p.d.m0.g.FqName;
import d0.z.d.Intrinsics3;
import java.util.Iterator;

/* compiled from: javaElements.kt */
/* loaded from: classes3.dex */
public interface d0 extends d {

    /* compiled from: javaElements.kt */
    public static final class a {
        public static d0.e0.p.d.m0.e.a.k0.a findAnnotation(d0 d0Var, FqName fqName) {
            Object obj;
            Intrinsics3.checkNotNullParameter(d0Var, "this");
            Intrinsics3.checkNotNullParameter(fqName, "fqName");
            Iterator<T> it = d0Var.getAnnotations().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Object next = it.next();
                ClassId classId = ((d0.e0.p.d.m0.e.a.k0.a) next).getClassId();
                if (Intrinsics3.areEqual(classId != null ? classId.asSingleFqName() : null, fqName)) {
                    obj = next;
                    break;
                }
            }
            return (d0.e0.p.d.m0.e.a.k0.a) obj;
        }
    }
}
