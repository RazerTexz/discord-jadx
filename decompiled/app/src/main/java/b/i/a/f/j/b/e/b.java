package b.i.a.f.j.b.e;

import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes3.dex */
public abstract class b extends b.i.a.f.h.m.b implements a {
    public b() {
        super("com.google.android.gms.nearby.messages.internal.ISubscribeCallback");
    }

    @Override // b.i.a.f.h.m.b
    public final boolean c(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i != 1) {
            return false;
        }
        s sVar = (s) this;
        sVar.d.b(sVar.c.c);
        b.i.a.f.e.h.j.k<b.i.a.f.j.b.d> kVar = sVar.f1583b;
        if (kVar != null) {
            kVar.a(d0.a);
        }
        return true;
    }
}
