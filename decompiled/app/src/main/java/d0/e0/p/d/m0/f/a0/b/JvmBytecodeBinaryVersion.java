package d0.e0.p.d.m0.f.a0.b;

import d0.e0.p.d.m0.f.z.BinaryVersion;
import d0.z.d.Intrinsics3;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: JvmBytecodeBinaryVersion.kt */
/* renamed from: d0.e0.p.d.m0.f.a0.b.c, reason: use source file name */
/* loaded from: classes3.dex */
public final class JvmBytecodeBinaryVersion extends BinaryVersion {
    public static final JvmBytecodeBinaryVersion f;

    /* compiled from: JvmBytecodeBinaryVersion.kt */
    /* renamed from: d0.e0.p.d.m0.f.a0.b.c$a */
    public static final class a {
        public a(DefaultConstructorMarker defaultConstructorMarker) {
        }
    }

    static {
        new a(null);
        f = new JvmBytecodeBinaryVersion(1, 0, 3);
        new JvmBytecodeBinaryVersion(new int[0]);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public JvmBytecodeBinaryVersion(int... iArr) {
        Intrinsics3.checkNotNullParameter(iArr, "numbers");
        int[] iArr2 = new int[iArr.length];
        System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
        super(iArr2);
    }
}
