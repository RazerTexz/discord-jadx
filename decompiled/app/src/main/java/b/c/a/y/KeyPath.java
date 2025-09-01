package b.c.a.y;

import androidx.annotation.CheckResult;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import b.d.b.a.outline;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* compiled from: KeyPath.java */
/* renamed from: b.c.a.y.f, reason: use source file name */
/* loaded from: classes.dex */
public class KeyPath {
    public static final KeyPath a = new KeyPath("COMPOSITION");

    /* renamed from: b, reason: collision with root package name */
    public final List<String> f408b;

    @Nullable
    public KeyPathElement c;

    public KeyPath(String... strArr) {
        this.f408b = Arrays.asList(strArr);
    }

    @CheckResult
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public KeyPath a(String str) {
        KeyPath keyPath = new KeyPath(this);
        keyPath.f408b.add(str);
        return keyPath;
    }

    public final boolean b() {
        return this.f408b.get(r0.size() - 1).equals("**");
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public boolean c(String str, int i) {
        if (i >= this.f408b.size()) {
            return false;
        }
        boolean z2 = i == this.f408b.size() - 1;
        String str2 = this.f408b.get(i);
        if (!str2.equals("**")) {
            return (z2 || (i == this.f408b.size() + (-2) && b())) && (str2.equals(str) || str2.equals("*"));
        }
        if (!z2 && this.f408b.get(i + 1).equals(str)) {
            return i == this.f408b.size() + (-2) || (i == this.f408b.size() + (-3) && b());
        }
        if (z2) {
            return true;
        }
        int i2 = i + 1;
        if (i2 < this.f408b.size() - 1) {
            return false;
        }
        return this.f408b.get(i2).equals(str);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public int d(String str, int i) {
        if ("__container".equals(str)) {
            return 0;
        }
        if (this.f408b.get(i).equals("**")) {
            return (i != this.f408b.size() - 1 && this.f408b.get(i + 1).equals(str)) ? 2 : 0;
        }
        return 1;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public boolean e(String str, int i) {
        if ("__container".equals(str)) {
            return true;
        }
        if (i >= this.f408b.size()) {
            return false;
        }
        return this.f408b.get(i).equals(str) || this.f408b.get(i).equals("**") || this.f408b.get(i).equals("*");
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public boolean f(String str, int i) {
        return "__container".equals(str) || i < this.f408b.size() - 1 || this.f408b.get(i).equals("**");
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public KeyPath g(KeyPathElement keyPathElement) {
        KeyPath keyPath = new KeyPath(this);
        keyPath.c = keyPathElement;
        return keyPath;
    }

    public String toString() {
        StringBuilder sbU = outline.U("KeyPath{keys=");
        sbU.append(this.f408b);
        sbU.append(",resolved=");
        sbU.append(this.c != null);
        sbU.append('}');
        return sbU.toString();
    }

    public KeyPath(KeyPath keyPath) {
        this.f408b = new ArrayList(keyPath.f408b);
        this.c = keyPath.c;
    }
}
