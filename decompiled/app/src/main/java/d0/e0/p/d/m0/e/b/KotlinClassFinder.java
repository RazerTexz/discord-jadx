package d0.e0.p.d.m0.e.b;

import d0.e0.p.d.m0.g.ClassId;
import d0.e0.p.d.m0.l.b.KotlinMetadataFinder;
import d0.z.d.Intrinsics3;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: KotlinClassFinder.kt */
/* renamed from: d0.e0.p.d.m0.e.b.n, reason: use source file name */
/* loaded from: classes3.dex */
public interface KotlinClassFinder extends KotlinMetadataFinder {

    /* compiled from: KotlinClassFinder.kt */
    /* renamed from: d0.e0.p.d.m0.e.b.n$a */
    public static abstract class a {

        /* compiled from: KotlinClassFinder.kt */
        /* renamed from: d0.e0.p.d.m0.e.b.n$a$a, reason: collision with other inner class name */
        public static final class C0390a extends a {
            public final byte[] getContent() {
                return null;
            }
        }

        /* compiled from: KotlinClassFinder.kt */
        /* renamed from: d0.e0.p.d.m0.e.b.n$a$b */
        public static final class b extends a {
            public final KotlinJvmBinaryClass a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public b(KotlinJvmBinaryClass kotlinJvmBinaryClass, byte[] bArr) {
                super(null);
                Intrinsics3.checkNotNullParameter(kotlinJvmBinaryClass, "kotlinJvmBinaryClass");
                this.a = kotlinJvmBinaryClass;
            }

            public final KotlinJvmBinaryClass getKotlinJvmBinaryClass() {
                return this.a;
            }

            public /* synthetic */ b(KotlinJvmBinaryClass kotlinJvmBinaryClass, byte[] bArr, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this(kotlinJvmBinaryClass, (i & 2) != 0 ? null : bArr);
            }
        }

        public a(DefaultConstructorMarker defaultConstructorMarker) {
        }

        public final KotlinJvmBinaryClass toKotlinJvmBinaryClass() {
            b bVar = this instanceof b ? (b) this : null;
            if (bVar == null) {
                return null;
            }
            return bVar.getKotlinJvmBinaryClass();
        }
    }

    a findKotlinClassOrContent(d0.e0.p.d.m0.e.a.k0.g gVar);

    a findKotlinClassOrContent(ClassId classId);
}
