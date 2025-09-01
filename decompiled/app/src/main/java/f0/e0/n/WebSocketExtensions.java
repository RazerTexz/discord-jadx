package f0.e0.n;

import b.d.b.a.outline;
import d0.z.d.Intrinsics3;

/* compiled from: WebSocketExtensions.kt */
/* renamed from: f0.e0.n.f, reason: use source file name */
/* loaded from: classes3.dex */
public final class WebSocketExtensions {
    public final boolean a;

    /* renamed from: b, reason: collision with root package name */
    public final Integer f3664b;
    public final boolean c;
    public final Integer d;
    public final boolean e;
    public final boolean f;

    public WebSocketExtensions() {
        this.a = false;
        this.f3664b = null;
        this.c = false;
        this.d = null;
        this.e = false;
        this.f = false;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof WebSocketExtensions)) {
            return false;
        }
        WebSocketExtensions webSocketExtensions = (WebSocketExtensions) obj;
        return this.a == webSocketExtensions.a && Intrinsics3.areEqual(this.f3664b, webSocketExtensions.f3664b) && this.c == webSocketExtensions.c && Intrinsics3.areEqual(this.d, webSocketExtensions.d) && this.e == webSocketExtensions.e && this.f == webSocketExtensions.f;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v12 */
    /* JADX WARN: Type inference failed for: r0v13 */
    /* JADX WARN: Type inference failed for: r2v3, types: [boolean] */
    /* JADX WARN: Type inference failed for: r2v6, types: [boolean] */
    public int hashCode() {
        boolean z2 = this.a;
        ?? r0 = z2;
        if (z2) {
            r0 = 1;
        }
        int i = r0 * 31;
        Integer num = this.f3664b;
        int iHashCode = (i + (num != null ? num.hashCode() : 0)) * 31;
        ?? r2 = this.c;
        int i2 = r2;
        if (r2 != 0) {
            i2 = 1;
        }
        int i3 = (iHashCode + i2) * 31;
        Integer num2 = this.d;
        int iHashCode2 = (i3 + (num2 != null ? num2.hashCode() : 0)) * 31;
        ?? r22 = this.e;
        int i4 = r22;
        if (r22 != 0) {
            i4 = 1;
        }
        int i5 = (iHashCode2 + i4) * 31;
        boolean z3 = this.f;
        return i5 + (z3 ? 1 : z3 ? 1 : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("WebSocketExtensions(perMessageDeflate=");
        sbU.append(this.a);
        sbU.append(", clientMaxWindowBits=");
        sbU.append(this.f3664b);
        sbU.append(", clientNoContextTakeover=");
        sbU.append(this.c);
        sbU.append(", serverMaxWindowBits=");
        sbU.append(this.d);
        sbU.append(", serverNoContextTakeover=");
        sbU.append(this.e);
        sbU.append(", unknownValues=");
        return outline.O(sbU, this.f, ")");
    }

    public WebSocketExtensions(boolean z2, Integer num, boolean z3, Integer num2, boolean z4, boolean z5) {
        this.a = z2;
        this.f3664b = num;
        this.c = z3;
        this.d = num2;
        this.e = z4;
        this.f = z5;
    }
}
