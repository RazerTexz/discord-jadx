package b.i.a.f.i.a;

import android.os.BadParcelableException;
import android.os.NetworkOnMainThreadException;
import android.os.RemoteException;
import android.util.Log;
import android.util.Pair;
import b.i.a.f.h.l.a0;
import b.i.a.f.h.l.g;
import b.i.a.f.i.b.z5;
import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@18.0.0 */
/* loaded from: classes3.dex */
public class a {
    public final g a;

    /* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@18.0.0 */
    /* renamed from: b.i.a.f.i.a.a$a, reason: collision with other inner class name */
    public interface InterfaceC0041a extends z5 {
    }

    public a(g gVar) {
        this.a = gVar;
    }

    public void a(InterfaceC0041a interfaceC0041a) {
        g gVar = this.a;
        Objects.requireNonNull(gVar);
        synchronized (gVar.g) {
            for (int i = 0; i < gVar.g.size(); i++) {
                if (interfaceC0041a.equals(gVar.g.get(i).first)) {
                    Log.w(gVar.c, "OnEventListener already registered.");
                    return;
                }
            }
            g.c cVar = new g.c(interfaceC0041a);
            gVar.g.add(new Pair<>(interfaceC0041a, cVar));
            if (gVar.j != null) {
                try {
                    gVar.j.registerOnMeasurementEventListener(cVar);
                    return;
                } catch (BadParcelableException | NetworkOnMainThreadException | RemoteException | IllegalArgumentException | IllegalStateException | NullPointerException | SecurityException | UnsupportedOperationException unused) {
                    Log.w(gVar.c, "Failed to register event listener on calling thread. Trying again on the dynamite thread.");
                }
            }
            gVar.e.execute(new a0(gVar, cVar));
        }
    }
}
