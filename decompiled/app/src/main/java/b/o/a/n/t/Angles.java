package b.o.a.n.t;

import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import b.d.b.a.outline;
import b.o.a.CameraLogger;
import b.o.a.m.Facing;

/* compiled from: Angles.java */
/* renamed from: b.o.a.n.t.a, reason: use source file name */
/* loaded from: classes3.dex */
public class Angles {
    public static final CameraLogger a = new CameraLogger(Angles.class.getSimpleName());

    /* renamed from: b, reason: collision with root package name */
    public Facing f1940b;

    @VisibleForTesting
    public int c = 0;

    @VisibleForTesting
    public int d = 0;

    @VisibleForTesting
    public int e = 0;

    public final int a(@NonNull Reference2 reference2, @NonNull Reference2 reference22) {
        if (reference2 == reference22) {
            return 0;
        }
        Reference2 reference23 = Reference2.BASE;
        if (reference22 == reference23) {
            return ((360 - a(reference22, reference2)) + 360) % 360;
        }
        if (reference2 != reference23) {
            return ((a(reference23, reference22) - a(reference23, reference2)) + 360) % 360;
        }
        int iOrdinal = reference22.ordinal();
        if (iOrdinal == 1) {
            return ((360 - this.c) + 360) % 360;
        }
        if (iOrdinal == 2) {
            return ((360 - this.d) + 360) % 360;
        }
        if (iOrdinal == 3) {
            return (this.e + 360) % 360;
        }
        throw new RuntimeException("Unknown reference: " + reference22);
    }

    public boolean b(@NonNull Reference2 reference2, @NonNull Reference2 reference22) {
        return c(reference2, reference22, 1) % 180 != 0;
    }

    public int c(@NonNull Reference2 reference2, @NonNull Reference2 reference22, @NonNull int i) {
        int iA = a(reference2, reference22);
        return (i == 2 && this.f1940b == Facing.FRONT) ? ((360 - iA) + 360) % 360 : iA;
    }

    public final void d() {
        a.a(1, "Angles changed:", "sensorOffset:", Integer.valueOf(this.c), "displayOffset:", Integer.valueOf(this.d), "deviceOrientation:", Integer.valueOf(this.e));
    }

    public final void e(int i) {
        if (i != 0 && i != 90 && i != 180 && i != 270) {
            throw new IllegalStateException(outline.q("This value is not sanitized: ", i));
        }
    }

    public void f(@NonNull Facing facing, int i) {
        e(i);
        this.f1940b = facing;
        this.c = i;
        if (facing == Facing.FRONT) {
            this.c = ((360 - i) + 360) % 360;
        }
        d();
    }
}
