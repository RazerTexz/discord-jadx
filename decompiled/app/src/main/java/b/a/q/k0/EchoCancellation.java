package b.a.q.k0;

import b.d.b.a.outline;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: EchoCancellation.kt */
/* renamed from: b.a.q.k0.g, reason: use source file name */
/* loaded from: classes.dex */
public final class EchoCancellation {
    public volatile boolean d;
    public final boolean e;
    public final boolean f;
    public final boolean g;
    public static final a c = new a(null);
    public static final EchoCancellation a = new EchoCancellation(true, false, false);

    /* renamed from: b, reason: collision with root package name */
    public static final EchoCancellation f264b = new EchoCancellation(true, false, false);

    /* compiled from: EchoCancellation.kt */
    /* renamed from: b.a.q.k0.g$a */
    public static final class a {
        public a(DefaultConstructorMarker defaultConstructorMarker) {
        }
    }

    public EchoCancellation(boolean z2, boolean z3, boolean z4) {
        this.e = z2;
        this.f = z3;
        this.g = z4;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof EchoCancellation)) {
            return false;
        }
        EchoCancellation echoCancellation = (EchoCancellation) obj;
        return this.e == echoCancellation.e && this.f == echoCancellation.f && this.g == echoCancellation.g;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r2v0, types: [boolean] */
    public int hashCode() {
        boolean z2 = this.e;
        ?? r0 = z2;
        if (z2) {
            r0 = 1;
        }
        int i = r0 * 31;
        ?? r2 = this.f;
        int i2 = r2;
        if (r2 != 0) {
            i2 = 1;
        }
        int i3 = (i + i2) * 31;
        boolean z3 = this.g;
        return i3 + (z3 ? 1 : z3 ? 1 : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("EchoCancellation(shouldEarlyEnableHwAec=");
        sbU.append(this.e);
        sbU.append(", alwaysEnableAec=");
        sbU.append(this.f);
        sbU.append(", disableSwAecWhenHwIsEnabled=");
        return outline.O(sbU, this.g, ")");
    }
}
