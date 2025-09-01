package d0.e0.p.d.m0.d.b;

import b.d.b.a.outline;
import java.io.Serializable;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: LookupLocation.kt */
/* renamed from: d0.e0.p.d.m0.d.b.e, reason: use source file name */
/* loaded from: classes3.dex */
public final class LookupLocation4 implements Serializable {
    public static final a j = new a(null);
    public static final LookupLocation4 k = new LookupLocation4(-1, -1);
    private final int column;
    private final int line;

    /* compiled from: LookupLocation.kt */
    /* renamed from: d0.e0.p.d.m0.d.b.e$a */
    public static final class a {
        public a(DefaultConstructorMarker defaultConstructorMarker) {
        }

        public final LookupLocation4 getNO_POSITION() {
            return LookupLocation4.access$getNO_POSITION$cp();
        }
    }

    public LookupLocation4(int i, int i2) {
        this.line = i;
        this.column = i2;
    }

    public static final /* synthetic */ LookupLocation4 access$getNO_POSITION$cp() {
        return k;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LookupLocation4)) {
            return false;
        }
        LookupLocation4 lookupLocation4 = (LookupLocation4) obj;
        return this.line == lookupLocation4.line && this.column == lookupLocation4.column;
    }

    public int hashCode() {
        return (this.line * 31) + this.column;
    }

    public String toString() {
        StringBuilder sbU = outline.U("Position(line=");
        sbU.append(this.line);
        sbU.append(", column=");
        return outline.A(sbU, this.column, ')');
    }
}
