package b.i.a.f.j.b.e;

import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes3.dex */
public abstract class x0 extends b.i.a.f.h.m.b implements w0 {
    public x0() {
        super("com.google.android.gms.nearby.messages.internal.IPublishCallback");
    }

    @Override // b.i.a.f.h.m.b
    public final boolean c(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i != 1) {
            return false;
        }
        r rVar = (r) this;
        rVar.d.b(rVar.c.c);
        b.i.a.f.e.h.j.k<b.i.a.f.j.b.b> kVar = rVar.f1582b;
        if (kVar != null) {
            kVar.a(b0.a);
        }
        return true;
    }
}
