package d0.e0.p.d.m0.e.b;

import d0.e0.p.d.m0.k.y.JvmPrimitiveType;
import d0.z.d.Intrinsics3;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: methodSignatureMapping.kt */
/* renamed from: d0.e0.p.d.m0.e.b.k, reason: use source file name */
/* loaded from: classes3.dex */
public abstract class methodSignatureMapping {
    public static final b a = new b(null);

    /* renamed from: b, reason: collision with root package name */
    public static final d f3379b = new d(JvmPrimitiveType.BOOLEAN);
    public static final d c = new d(JvmPrimitiveType.CHAR);
    public static final d d = new d(JvmPrimitiveType.BYTE);
    public static final d e = new d(JvmPrimitiveType.SHORT);
    public static final d f = new d(JvmPrimitiveType.INT);
    public static final d g = new d(JvmPrimitiveType.FLOAT);
    public static final d h = new d(JvmPrimitiveType.LONG);
    public static final d i = new d(JvmPrimitiveType.DOUBLE);

    /* compiled from: methodSignatureMapping.kt */
    /* renamed from: d0.e0.p.d.m0.e.b.k$a */
    public static final class a extends methodSignatureMapping {
        public final methodSignatureMapping j;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(methodSignatureMapping methodsignaturemapping) {
            super(null);
            Intrinsics3.checkNotNullParameter(methodsignaturemapping, "elementType");
            this.j = methodsignaturemapping;
        }

        public final methodSignatureMapping getElementType() {
            return this.j;
        }
    }

    /* compiled from: methodSignatureMapping.kt */
    /* renamed from: d0.e0.p.d.m0.e.b.k$b */
    public static final class b {
        public b(DefaultConstructorMarker defaultConstructorMarker) {
        }

        public final d getBOOLEAN$descriptors_jvm() {
            return methodSignatureMapping.access$getBOOLEAN$cp();
        }

        public final d getBYTE$descriptors_jvm() {
            return methodSignatureMapping.access$getBYTE$cp();
        }

        public final d getCHAR$descriptors_jvm() {
            return methodSignatureMapping.access$getCHAR$cp();
        }

        public final d getDOUBLE$descriptors_jvm() {
            return methodSignatureMapping.access$getDOUBLE$cp();
        }

        public final d getFLOAT$descriptors_jvm() {
            return methodSignatureMapping.access$getFLOAT$cp();
        }

        public final d getINT$descriptors_jvm() {
            return methodSignatureMapping.access$getINT$cp();
        }

        public final d getLONG$descriptors_jvm() {
            return methodSignatureMapping.access$getLONG$cp();
        }

        public final d getSHORT$descriptors_jvm() {
            return methodSignatureMapping.access$getSHORT$cp();
        }
    }

    /* compiled from: methodSignatureMapping.kt */
    /* renamed from: d0.e0.p.d.m0.e.b.k$c */
    public static final class c extends methodSignatureMapping {
        public final String j;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(String str) {
            super(null);
            Intrinsics3.checkNotNullParameter(str, "internalName");
            this.j = str;
        }

        public final String getInternalName() {
            return this.j;
        }
    }

    /* compiled from: methodSignatureMapping.kt */
    /* renamed from: d0.e0.p.d.m0.e.b.k$d */
    public static final class d extends methodSignatureMapping {
        public final JvmPrimitiveType j;

        public d(JvmPrimitiveType jvmPrimitiveType) {
            super(null);
            this.j = jvmPrimitiveType;
        }

        public final JvmPrimitiveType getJvmPrimitiveType() {
            return this.j;
        }
    }

    public methodSignatureMapping() {
    }

    public static final /* synthetic */ d access$getBOOLEAN$cp() {
        return f3379b;
    }

    public static final /* synthetic */ d access$getBYTE$cp() {
        return d;
    }

    public static final /* synthetic */ d access$getCHAR$cp() {
        return c;
    }

    public static final /* synthetic */ d access$getDOUBLE$cp() {
        return i;
    }

    public static final /* synthetic */ d access$getFLOAT$cp() {
        return g;
    }

    public static final /* synthetic */ d access$getINT$cp() {
        return f;
    }

    public static final /* synthetic */ d access$getLONG$cp() {
        return h;
    }

    public static final /* synthetic */ d access$getSHORT$cp() {
        return e;
    }

    public String toString() {
        return methodSignatureMapping2.a.toString2(this);
    }

    public methodSignatureMapping(DefaultConstructorMarker defaultConstructorMarker) {
    }
}
