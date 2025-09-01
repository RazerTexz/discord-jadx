package b.i.a.f.i.b;

import com.google.android.gms.measurement.internal.zzaq;
import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
/* loaded from: classes3.dex */
public final class m5 implements Runnable {
    public final /* synthetic */ zzaq j;
    public final /* synthetic */ String k;
    public final /* synthetic */ z4 l;

    public m5(z4 z4Var, zzaq zzaqVar, String str) {
        this.l = z4Var;
        this.j = zzaqVar;
        this.k = str;
    }

    @Override // java.lang.Runnable
    public final void run() throws IllegalStateException, IOException {
        this.l.a.R();
        this.l.a.m(this.j, this.k);
    }
}
