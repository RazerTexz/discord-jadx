package b.i.a.f.i.b;

import com.google.android.gms.measurement.internal.zzn;
import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
/* loaded from: classes3.dex */
public final class q5 implements Runnable {
    public final /* synthetic */ zzn j;
    public final /* synthetic */ z4 k;

    public q5(z4 z4Var, zzn zznVar) {
        this.k = z4Var;
        this.j = zznVar;
    }

    @Override // java.lang.Runnable
    public final void run() throws IOException {
        this.k.a.R();
        this.k.a.E(this.j);
    }
}
