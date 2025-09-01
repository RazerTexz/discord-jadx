package b.i.a.f.h.c;

import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.auth.api.credentials.Credential;
import com.google.android.gms.common.api.Status;

/* compiled from: com.google.android.gms:play-services-auth@@19.0.0 */
/* loaded from: classes3.dex */
public interface r extends IInterface {
    void O(Status status, Credential credential) throws RemoteException;

    void l(Status status) throws RemoteException;
}
