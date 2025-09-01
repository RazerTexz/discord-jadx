package b.i.a.f.i.b;

import com.google.android.gms.measurement.internal.zzn;
import com.google.android.gms.measurement.internal.zzz;
import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
/* loaded from: classes3.dex */
public final class b5 implements Runnable {
    public final /* synthetic */ zzz j;
    public final /* synthetic */ zzn k;
    public final /* synthetic */ z4 l;

    public b5(z4 z4Var, zzz zzzVar, zzn zznVar) {
        this.l = z4Var;
        this.j = zzzVar;
        this.k = zznVar;
    }

    @Override // java.lang.Runnable
    public final void run() throws IOException {
        this.l.a.R();
        if (this.j.l.w0() == null) {
            this.l.a.F(this.j, this.k);
        } else {
            this.l.a.q(this.j, this.k);
        }
    }
}
