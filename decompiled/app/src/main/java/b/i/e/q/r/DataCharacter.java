package b.i.e.q.r;

import b.d.b.a.outline;

/* compiled from: DataCharacter.java */
/* renamed from: b.i.e.q.r.b, reason: use source file name */
/* loaded from: classes3.dex */
public class DataCharacter {
    public final int a;

    /* renamed from: b, reason: collision with root package name */
    public final int f1863b;

    public DataCharacter(int i, int i2) {
        this.a = i;
        this.f1863b = i2;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof DataCharacter)) {
            return false;
        }
        DataCharacter dataCharacter = (DataCharacter) obj;
        return this.a == dataCharacter.a && this.f1863b == dataCharacter.f1863b;
    }

    public final int hashCode() {
        return this.a ^ this.f1863b;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.a);
        sb.append("(");
        return outline.A(sb, this.f1863b, ')');
    }
}
