package b.i.a.f.e.h.j;

import android.os.DeadObjectException;
import androidx.annotation.NonNull;
import b.c.a.a0.AnimatableValueParser;
import b.d.b.a.outline;
import b.i.a.f.e.h.a;
import b.i.a.f.e.h.j.d;
import b.i.a.f.e.h.j.g;
import com.google.android.gms.common.api.Status;

/* compiled from: com.google.android.gms:play-services-base@@17.3.0 */
/* loaded from: classes3.dex */
public final class o0<A extends d<? extends b.i.a.f.e.h.h, a.b>> extends s {

    /* renamed from: b, reason: collision with root package name */
    public final A f1368b;

    public o0(int i, A a) {
        super(i);
        AnimatableValueParser.z(a, "Null methods are not runnable.");
        this.f1368b = a;
    }

    @Override // b.i.a.f.e.h.j.s
    public final void b(@NonNull Status status) {
        this.f1368b.a(status);
    }

    @Override // b.i.a.f.e.h.j.s
    public final void c(g.a<?> aVar) throws DeadObjectException {
        try {
            this.f1368b.l(aVar.f1361b);
        } catch (RuntimeException e) {
            e(e);
        }
    }

    @Override // b.i.a.f.e.h.j.s
    public final void d(@NonNull x0 x0Var, boolean z2) {
        A a = this.f1368b;
        x0Var.a.put(a, Boolean.valueOf(z2));
        a.c(new z0(x0Var, a));
    }

    @Override // b.i.a.f.e.h.j.s
    public final void e(@NonNull Exception exc) {
        String simpleName = exc.getClass().getSimpleName();
        String localizedMessage = exc.getLocalizedMessage();
        this.f1368b.a(new Status(10, outline.k(outline.b(localizedMessage, simpleName.length() + 2), simpleName, ": ", localizedMessage)));
    }
}
