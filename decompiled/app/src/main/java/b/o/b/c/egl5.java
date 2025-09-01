package b.o.b.c;

import android.opengl.EGLSurface;
import b.d.b.a.outline;
import d0.z.d.Intrinsics3;

/* compiled from: egl.kt */
/* renamed from: b.o.b.c.e, reason: use source file name */
/* loaded from: classes3.dex */
public final class egl5 {
    public final EGLSurface a;

    public egl5(EGLSurface eGLSurface) {
        this.a = eGLSurface;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof egl5) && Intrinsics3.areEqual(this.a, ((egl5) obj).a);
    }

    public int hashCode() {
        EGLSurface eGLSurface = this.a;
        if (eGLSurface == null) {
            return 0;
        }
        return eGLSurface.hashCode();
    }

    public String toString() {
        StringBuilder sbU = outline.U("EglSurface(native=");
        sbU.append(this.a);
        sbU.append(')');
        return sbU.toString();
    }
}
