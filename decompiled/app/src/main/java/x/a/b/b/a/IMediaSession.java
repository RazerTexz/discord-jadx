package x.a.b.b.a;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import x.a.b.b.a.IMediaControllerCallback;

/* compiled from: IMediaSession.java */
/* renamed from: x.a.b.b.a.b, reason: use source file name */
/* loaded from: classes.dex */
public interface IMediaSession extends IInterface {

    /* compiled from: IMediaSession.java */
    /* renamed from: x.a.b.b.a.b$a */
    public static abstract class a extends Binder implements IMediaSession {
        public static final /* synthetic */ int a = 0;

        /* compiled from: IMediaSession.java */
        /* renamed from: x.a.b.b.a.b$a$a, reason: collision with other inner class name */
        public static class C0443a implements IMediaSession {
            public IBinder a;

            public C0443a(IBinder iBinder) {
                this.a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.a;
            }

            @Override // x.a.b.b.a.IMediaSession
            public void k(IMediaControllerCallback iMediaControllerCallback) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
                    parcelObtain.writeStrongBinder((IMediaControllerCallback.a) iMediaControllerCallback);
                    if (!this.a.transact(3, parcelObtain, parcelObtain2, 0)) {
                        int i = a.a;
                    }
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public static IMediaSession c(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("android.support.v4.media.session.IMediaSession");
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof IMediaSession)) ? new C0443a(iBinder) : (IMediaSession) iInterfaceQueryLocalInterface;
        }
    }

    void k(IMediaControllerCallback iMediaControllerCallback) throws RemoteException;
}
