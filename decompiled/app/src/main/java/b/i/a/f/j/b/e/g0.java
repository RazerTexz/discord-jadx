package b.i.a.f.j.b.e;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import b.c.a.a0.AnimatableValueParser;
import com.google.android.gms.nearby.messages.internal.ClientAppContext;
import com.google.android.gms.nearby.messages.internal.zzcb;

/* loaded from: classes3.dex */
public final class g0 implements Parcelable.Creator<zzcb> {
    @Override // android.os.Parcelable.Creator
    public final zzcb createFromParcel(Parcel parcel) {
        int iM2 = AnimatableValueParser.m2(parcel);
        IBinder iBinderF1 = null;
        IBinder iBinderF12 = null;
        String strR = null;
        ClientAppContext clientAppContext = null;
        int iG1 = 0;
        boolean zE1 = false;
        while (parcel.dataPosition() < iM2) {
            int i = parcel.readInt();
            switch ((char) i) {
                case 1:
                    iG1 = AnimatableValueParser.G1(parcel, i);
                    break;
                case 2:
                    iBinderF1 = AnimatableValueParser.F1(parcel, i);
                    break;
                case 3:
                    iBinderF12 = AnimatableValueParser.F1(parcel, i);
                    break;
                case 4:
                    zE1 = AnimatableValueParser.E1(parcel, i);
                    break;
                case 5:
                    strR = AnimatableValueParser.R(parcel, i);
                    break;
                case 6:
                    clientAppContext = (ClientAppContext) AnimatableValueParser.Q(parcel, i, ClientAppContext.CREATOR);
                    break;
                default:
                    AnimatableValueParser.d2(parcel, i);
                    break;
            }
        }
        AnimatableValueParser.f0(parcel, iM2);
        return new zzcb(iG1, iBinderF1, iBinderF12, zE1, strR, clientAppContext);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzcb[] newArray(int i) {
        return new zzcb[i];
    }
}
