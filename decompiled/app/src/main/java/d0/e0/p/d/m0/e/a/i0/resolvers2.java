package d0.e0.p.d.m0.e.a.i0;

import d0.e0.p.d.m0.c.TypeParameterDescriptor;
import d0.e0.p.d.m0.e.a.k0.y;
import d0.z.d.Intrinsics3;

/* compiled from: resolvers.kt */
/* renamed from: d0.e0.p.d.m0.e.a.i0.k, reason: use source file name */
/* loaded from: classes3.dex */
public interface resolvers2 {

    /* compiled from: resolvers.kt */
    /* renamed from: d0.e0.p.d.m0.e.a.i0.k$a */
    public static final class a implements resolvers2 {
        public static final a a = new a();

        @Override // d0.e0.p.d.m0.e.a.i0.resolvers2
        public TypeParameterDescriptor resolveTypeParameter(y yVar) {
            Intrinsics3.checkNotNullParameter(yVar, "javaTypeParameter");
            return null;
        }
    }

    TypeParameterDescriptor resolveTypeParameter(y yVar);
}
