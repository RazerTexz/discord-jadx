package b.i.a.f.h.l;

import android.app.Activity;
import android.os.Bundle;
import android.os.RemoteException;
import b.i.a.f.h.l.g;

/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@18.0.0 */
/* loaded from: classes3.dex */
public final class e0 extends g.a {
    public final /* synthetic */ Bundle n;
    public final /* synthetic */ Activity o;
    public final /* synthetic */ g.b p;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e0(g.b bVar, Bundle bundle, Activity activity) {
        super(true);
        this.p = bVar;
        this.n = bundle;
        this.o = activity;
    }

    @Override // b.i.a.f.h.l.g.a
    public final void a() throws RemoteException {
        Bundle bundle;
        if (this.n != null) {
            bundle = new Bundle();
            if (this.n.containsKey("com.google.app_measurement.screen_service")) {
                Object obj = this.n.get("com.google.app_measurement.screen_service");
                if (obj instanceof Bundle) {
                    bundle.putBundle("com.google.app_measurement.screen_service", (Bundle) obj);
                }
            }
        } else {
            bundle = null;
        }
        g.this.j.onActivityCreated(new b.i.a.f.f.b(this.o), bundle, this.k);
    }
}
