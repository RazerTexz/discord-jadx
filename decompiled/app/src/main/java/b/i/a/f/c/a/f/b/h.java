package b.i.a.f.c.a.f.b;

import android.os.RemoteException;
import b.i.a.f.e.h.a;
import com.google.android.gms.common.api.Status;

/* compiled from: com.google.android.gms:play-services-auth@@19.0.0 */
/* loaded from: classes3.dex */
public final class h extends k<Status> {
    public h(b.i.a.f.e.h.c cVar) {
        super(cVar);
    }

    @Override // com.google.android.gms.common.api.internal.BasePendingResult
    public final /* synthetic */ b.i.a.f.e.h.h d(Status status) {
        return status;
    }

    @Override // b.i.a.f.e.h.j.d
    public final void k(a.b bVar) throws RemoteException {
        f fVar = (f) bVar;
        ((o) fVar.w()).k0(new j(this), fVar.A);
    }
}
