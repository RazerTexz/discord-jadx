package b.i.a.f.i.b;

import b.c.a.a0.AnimatableValueParser;
import com.google.android.gms.measurement.internal.zzn;
import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
/* loaded from: classes3.dex */
public final class c5 implements Runnable {
    public final /* synthetic */ zzn j;
    public final /* synthetic */ z4 k;

    public c5(z4 z4Var, zzn zznVar) {
        this.k = z4Var;
        this.j = zznVar;
    }

    @Override // java.lang.Runnable
    public final void run() throws IOException {
        this.k.a.R();
        k9 k9Var = this.k.a;
        zzn zznVar = this.j;
        k9Var.f().b();
        k9Var.P();
        AnimatableValueParser.w(zznVar.j);
        k9Var.G(zznVar);
    }
}
