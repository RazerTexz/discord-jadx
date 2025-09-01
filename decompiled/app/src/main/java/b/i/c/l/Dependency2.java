package b.i.c.l;

import b.d.b.a.outline;
import java.util.Objects;

/* compiled from: Dependency.java */
/* renamed from: b.i.c.l.o, reason: use source file name */
/* loaded from: classes3.dex */
public final class Dependency2 {
    public final Class<?> a;

    /* renamed from: b, reason: collision with root package name */
    public final int f1668b;
    public final int c;

    public Dependency2(Class<?> cls, int i, int i2) {
        Objects.requireNonNull(cls, "Null dependency anInterface.");
        this.a = cls;
        this.f1668b = i;
        this.c = i2;
    }

    public boolean a() {
        return this.f1668b == 2;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Dependency2)) {
            return false;
        }
        Dependency2 dependency2 = (Dependency2) obj;
        return this.a == dependency2.a && this.f1668b == dependency2.f1668b && this.c == dependency2.c;
    }

    public int hashCode() {
        return ((((this.a.hashCode() ^ 1000003) * 1000003) ^ this.f1668b) * 1000003) ^ this.c;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Dependency{anInterface=");
        sb.append(this.a);
        sb.append(", type=");
        int i = this.f1668b;
        sb.append(i == 1 ? "required" : i == 0 ? "optional" : "set");
        sb.append(", direct=");
        return outline.O(sb, this.c == 0, "}");
    }
}
