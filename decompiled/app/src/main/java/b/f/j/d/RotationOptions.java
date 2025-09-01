package b.f.j.d;

import androidx.annotation.Nullable;
import b.c.a.a0.AnimatableValueParser;

/* compiled from: RotationOptions.java */
/* renamed from: b.f.j.d.f, reason: use source file name */
/* loaded from: classes.dex */
public class RotationOptions {
    public static final RotationOptions a = new RotationOptions(-1, false);

    /* renamed from: b, reason: collision with root package name */
    public static final RotationOptions f567b = new RotationOptions(-1, true);
    public final int c;
    public final boolean d;

    public RotationOptions(int i, boolean z2) {
        this.c = i;
        this.d = z2;
    }

    public int a() {
        if (c()) {
            throw new IllegalStateException("Rotation is set to use EXIF");
        }
        return this.c;
    }

    public boolean b() {
        return this.c != -2;
    }

    public boolean c() {
        return this.c == -1;
    }

    public boolean equals(@Nullable Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof RotationOptions)) {
            return false;
        }
        RotationOptions rotationOptions = (RotationOptions) obj;
        return this.c == rotationOptions.c && this.d == rotationOptions.d;
    }

    public int hashCode() {
        return AnimatableValueParser.K0(Integer.valueOf(this.c), Boolean.valueOf(this.d));
    }

    public String toString() {
        return String.format(null, "%d defer:%b", Integer.valueOf(this.c), Boolean.valueOf(this.d));
    }
}
